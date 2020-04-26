package com.example.qzq.effective_java.枚举;

/**
 * @Classname Operation
 * @Description
 * @Date 2020/4/23 13:15
 * @Created by qiziqian
 */
public class OperationTest {
    public static void main(String[] args) {
        System.out.println(Operation2.values()[1]);
    }

    public enum Operation1 {
        PLUS, MINUS, TIMES, DIVIDE;

        public double apply(double x, double y) {
            switch (this) {
                case PLUS:
                    return x + y;
                case MINUS:
                    return x - y;
                case TIMES:
                    return x * y;
                case DIVIDE:
                    return x / y;
            }
            throw new AssertionError("Unknow op: " + this);
        }


    }
    //合适的案例
    public enum Operation2 {
        PLUS("+") {
            public double apply(double x, double y) {
                return x + y;
            }
        },
        MINUS("-") {
            public double apply(double x, double y) {
                return x - y;
            }
        },
        TIMES ("*"){
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE ("/"){
            public double apply(double x, double y) {
                return x / y;
            }
        };
        public abstract  double apply(double x,double y );
        private  final  String symbol;
        Operation2(String symbol){
            this.symbol = symbol;
        }
        @Override
        public String toString() {
            return symbol;
        }
    }

}
