package item38;

import java.util.Arrays;
import java.util.Collection;

public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };
    private final String symbol;
    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override public String toString() {
        return symbol;
    }
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y){
        for(Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
    private static void test(Collection<? extends Operation> opSet, double x, double y){
        for(Operation op : opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }
}