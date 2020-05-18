package by.epam.multithreading.entity;

import java.util.concurrent.ThreadLocalRandom;

public class Container {
    private double weight;

    public Container() {
        weight = ThreadLocalRandom.current().nextDouble(10, 150);
    }

    public Container(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        return container.weight == weight;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(weight);
        return (int) (temp ^ (temp >>> 32));
    }
}
