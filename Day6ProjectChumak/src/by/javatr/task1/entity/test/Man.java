package by.javatr.task1.entity.test;

import java.util.Objects;

public class Man implements Comparable<Man> {
    private int age;
    private String name;

    public Man() {
    }

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age &&
                Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {
        int result = 1;
        final int prime = 31;
        result = prime * result + name.hashCode();
        result = prime * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Some{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Man o) {
        int result = 1;
        if(this.age < o.getAge()) result = -1;
        else if(this.age == o.getAge()) result = 0;
        return result;
    }
}
