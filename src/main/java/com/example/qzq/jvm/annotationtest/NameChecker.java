package com.example.qzq.jvm.annotationtest;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

import static javax.lang.model.element.Modifier.*;


/**
 * @Description 程序命名规范检查
 * @Date 2020/2/21 10:55
 * @Author by qiziqian
 */
public class NameChecker {
    private final Messager messager;

    NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();

    public NameChecker(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
    }

    public void checkName(Element element) {
        nameCheckerScanner.scan(element);
    }

    private class NameCheckerScanner extends ElementScanner8<Void, Void> {

        //检查java类
        @Override
        public Void visitType(TypeElement e, Void p) {
            scan(e.getTypeParameters(), p);
            checkCamelCase(e, true);
            super.visitType(e, p);
            return null;
        }

        //检查方法命名是否合法
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName()))
                    messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法" + name + "与类名重复,请修改并予以区分", e);
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, aVoid);
            return null;
        }


        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {
            //如果是枚举或者常量,就按大写命名检查,否则按驼峰命名规则检查
            if (e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)) {
                checkAllCaps(e);
            } else {
                checkCamelCase(e, false);
            }
            super.visitVariable(e, aVoid);
            return null;
        }

        //判断一个变量是否是常量
        private boolean heuristicallyConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            } else if (e.getKind() == ElementKind.FIELD && e.getModifiers().contains(EnumSet.of(PUBLIC, STATIC, FINAL))) {
                return true;
            } else {
                return false;
            }
        }

        //检查是否符合驼峰命名法
        private void checkCamelCase(Element e, boolean initialCaps) {
            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "名称: " + name + " 应该以小写开头", e);
                    return;
                }
            } else if (Character.isLowerCase(firstCodePoint)) {
                if (initialCaps) {
                    messager.printMessage(Diagnostic.Kind.WARNING, "名称: " + name + " 应该以大写开头", e);
                    return;
                }
            } else conventional = false;

            if (conventional) {
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
                    cp = name.codePointAt(i);
                    if (Character.isUpperCase(cp)) {
                        if (previousUpper) {
                            conventional = false;
                            break;
                        }
                        previousUpper = true;
                    } else previousUpper = false;
                }
            }
            if (!conventional) {
                messager.printMessage(Diagnostic.Kind.WARNING, "名称: " + name + " 应当符合驼峰命名法(Camel Case Names)", e);
            }
        }

        //检查是否符合大写命名法,第一个字母必须是大写,其余部分可以是大写或者下划线
        private void checkAllCaps(Element e) {
            String name = e.getSimpleName().toString();
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (!Character.isUpperCase(firstCodePoint)) {
                conventional = false;
            } else {
                boolean previousUnderSource = false;
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
                    cp = name.codePointAt(i);
                    if (cp == (int) '_') {
                        if (previousUnderSource) {
                            conventional = false;
                            break;
                        }
                        previousUnderSource = true;
                    } else {
                        previousUnderSource = false;
                        if (!Character.isUpperCase(cp) && Character.isDigit(cp)) {
                            conventional = false;
                            break;
                        }
                    }
                }
            }
            if (!conventional) {
                messager.printMessage(Diagnostic.Kind.WARNING, "常量: " + name + " 首字母必须为大写字母,其后可以是大写字母或者下划线", e);
            }
        }
    }
}
