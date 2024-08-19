package com.javaconcepts.singleton.design.pattern;

import java.io.*;

class Car implements Serializable {

    private static Car car;

    private Car() {

    }

    public static Car getInstance() {

        if (car == null) {
            synchronized (Car.class) {
                if (car == null) {
                    return new Car();
                }
            }
        }

        return car;
    }

    protected Object readResolve() {
        return car;
    }
}

public class SingletonClass {

    public static void main(String[] args) throws Exception {

        Car car = Car.getInstance();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.obj"));
        objectOutputStream.writeObject(car);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.obj"));
        Car deserializedCar = (Car) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(car.hashCode());
        System.out.println(deserializedCar.hashCode());
    }
}
