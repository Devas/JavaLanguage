package lambdas.cars;//import lambdas.cars.Car.*;
//import lambdas.cars.Car.CarType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<Car> cars = Arrays.asList(
                new Car("BMW", "M6", 615, 1850, Car.CarType.COUPE),
                new Car("Audi", "R8", 610, 1550, Car.CarType.COUPE),
                new Car("BMW", "M5", 560, 1900, Car.CarType.SEDAN),
                new Car("Porsche", "991 Turbo S", 560, 1550, Car.CarType.COUPE),
                new Car("Porsche", "Panamera 4s", 400, 2000, Car.CarType.SEDAN),
                new Car("Mercedes", "S63 AMG S", 585, 2100, Car.CarType.CABRIO),
                new Car("Mercedes", "G63 AMG", 571, 2600, Car.CarType.SUV),
                new Car("Audi", "RS6", 560, 2050, Car.CarType.KOMBII),
                new Car("BMW", "X6M", 575, 2300, Car.CarType.SUV),
                new Car("Ferrari", "488gtb", 670, 1450, Car.CarType.COUPE),
                new Car("Audi", "RS4", 420, 1800, Car.CarType.KOMBII)
        );

        double averagePower = Car.calculateAveragePower(cars);
        System.out.println("Average power is: " + averagePower);

        Car heaviestCar = Car.findHeaviestCar(cars);
        System.out.println("Heaviest car is: " + heaviestCar);

        long numberOfCoupes = Car.countByType(cars, Car.CarType.COUPE);
        System.out.println("List contains " + numberOfCoupes + " coupe cars");

        List<Car> coupes = Car.findByType(cars, Car.CarType.COUPE);
        System.out.println("Coupes:");
        coupes.forEach(System.out::println);

        Map<String, List<Car>> groupedByBrand = Car.groupByBrand(cars);
        groupedByBrand.forEach((k, v) -> {
            System.out.println("Brand: " + k);
            v.forEach(System.out::println);
        });

        Map<Car.CarType, Long> groupedByTypeCount = Car.groupByTypeCount(cars);
        groupedByTypeCount.forEach((k, v) -> System.out.println("Type: " + k + ", count: " + v));

        Map<String, Double> groupedByBrandAveragePower = Car.groupByBrandAveragePower(cars);
        groupedByBrandAveragePower.forEach((k, v) -> System.out.println("Brand: " + k + ", average power: " + v));

        Map<String, Optional<Car>> groupedByBrandWithMaxPowerCar = Car.groupByBrandWithMaxPowerCar(cars);
        groupedByBrandWithMaxPowerCar
                .forEach((k, v) -> System.out.println("Brand: " + k + ", max power car: " + v.orElseThrow(IllegalArgumentException::new)));
    }

}
