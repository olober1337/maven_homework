package homework14.functions;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        predicateInterfaceTest();
        consumerInterfaceTest();
        functionInterfaceTest();
        supplierInterfaceTest();
    }

    private static void predicateInterfaceTest() {

        Predicate<Double> salaryIsMoreThan1500 = salary -> salary > 1500.0;

        System.out.println(salaryIsMoreThan1500.test(16547.2));
        System.out.println(salaryIsMoreThan1500.test(784.25) + "\n");

    }

    private static void consumerInterfaceTest() {
        
        Consumer<String> transformString = string -> charArray(string.toCharArray());
        transformString.accept("hello".concat("\n"));

    }

    private static void charArray(char[] toCharArray) {

        for (char c : toCharArray) {
            System.out.println(c);
        }
    }

    private static void functionInterfaceTest() {

        Function<Integer, String> convertFunction = FunctionalInterfaces::convertIntToString;

        System.out.println(convertFunction.apply(6));
        System.out.println(convertFunction.apply(4));
        System.out.println(convertFunction.apply(7));
        System.out.println(convertFunction.apply(89));
        System.out.println(convertFunction.apply(95) + "\n");

    }

    private static String convertIntToString(int number) {
        switch (number) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            default:
                return "unknown";
        }
    }

    private static void supplierInterfaceTest() {

        String string = "hello people!";

        Supplier<String> newSupplier = () -> string.toUpperCase(Locale.ROOT);
        System.out.println(newSupplier.get());

    }
}
