package demo.java;

public class Traits {

    public static void main(String[] args) {
        var car = new SomeCar();
        stats(car);
    }

    private static void stats(Car car) {
        var c = (CarDelegate & IsExpensive & HasPoorMileage) () -> car;
        System.out.printf("Car %s is %s and has %s", c.name(), c.isExpensive() ? "Expensive" : "Cheap", c.hasPoorMileage() ? "good mileage" : "poor mileage");
    }


    // private interface
    interface Car {

        String name();

        Double price();

        Float mileage();
    }

    private static class SomeCar implements Car {

        @Override
        public String name() {
            return "Some Car";
        }

        @Override
        public Double price() {
            return 1_000_000.00;
        }

        @Override
        public Float mileage() {
            return 15.23f;
        }
    }

    @FunctionalInterface
    interface CarDelegate extends Car {
        Car delegate();

        @Override
        default String name() {
            return delegate().name();
        }

        @Override
        default Double price() {
            return delegate().price();
        }

        @Override
        default Float mileage() {
            return delegate().mileage();
        }
    }

    interface IsExpensive extends Car {

        Double EXPENSIVE_PRICE = 5_000_000.00;

        default boolean isExpensive() {
            return price().compareTo(EXPENSIVE_PRICE) > 0;
        }
    }

    interface HasPoorMileage extends Car {

        Double POOR_MILEAGE = 5.00;

        default boolean hasPoorMileage() {
            return price().compareTo(POOR_MILEAGE) < 0;
        }
    }
}
