package lambdas.cars;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Car {

    public static enum CarType {
        COUPE, SEDAN, CABRIO, SUV, KOMBII
    }

    private String brand;
    private String model;
    private int power;
    private int weight;
    private CarType type;

    public Car(String brand, String model, int power, int weight, CarType type) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.weight = weight;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", power=" + power
                + ", weight=" + weight + ", type=" + type + "]";
    }

    public static Map<String, Optional<Car>> groupByBrandWithMaxPowerCar(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getBrand, maxBy((a, b) -> a.getPower() - b.getPower())));
    }

    public static Map<String, Double> groupByBrandAveragePower(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getBrand, averagingDouble(Car::getPower)));
    }

    public static Map<CarType, Long> groupByTypeCount(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getType, counting()));
    }

    public static Map<String, List<Car>> groupByBrand(List<Car> cars) {
        return cars.stream().collect(groupingBy(Car::getBrand));
    }

    public static List<Car> findByType(List<Car> cars, CarType type) {
        return cars.stream().filter(e -> e.getType() == type).collect(toList());
    }

    public static long countByType(List<Car> cars, CarType type) {
        return cars.stream().filter(e -> e.getType() == type).count();
    }

    public static Car findHeaviestCar(List<Car> cars) {
        return cars.stream().max((a, b) -> a.getWeight() - b.getWeight()).orElseThrow(IllegalArgumentException::new);
    }

    public static double calculateAveragePower(List<Car> cars) {
        return cars.stream().collect(Collectors.averagingDouble(Car::getPower));
    }

    // new Predicate
}