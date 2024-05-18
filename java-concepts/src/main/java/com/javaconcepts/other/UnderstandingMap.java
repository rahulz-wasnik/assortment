package com.javaconcepts.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class UnderstandingMap {

    public static void main(String[] args) {

        Map<MapEmployee, MapCar> carEmployeeMap = new HashMap<>();

        MapEmployee mapEmployee = new MapEmployee(10, "Rahul");
        MapCar mapCar = new MapCar("Hyundai");

        MapEmployee mapEmployee_2 = new MapEmployee(11, "Shishir");
        MapCar mapCar_2 = new MapCar("Maruti");

        MapEmployee mapEmployee_3 = new MapEmployee(12, "Pondy");
        MapCar mapCar_3 = new MapCar("Bentley");

        MapEmployee mapEmployee_4 = new MapEmployee(10, "Lala");
        MapCar mapCar_4 = new MapCar("Renault");

        MapEmployee mapEmployee_5 = new MapEmployee(11, "Quashar");
        MapCar mapCar_5 = new MapCar("Ford");

        MapEmployee mapEmployee_6 = new MapEmployee(12, "Narvariya");
        MapCar mapCar_6 = new MapCar("Toyota");

        MapEmployee mapEmployee_7 = new MapEmployee(10, "Debh");
        MapCar mapCar_7 = new MapCar("Kia");

        MapEmployee mapEmployee_8 = new MapEmployee(11, "Maggie");
        MapCar mapCar_8 = new MapCar("Audi");

        MapEmployee mapEmployee_9 = new MapEmployee(12, "Ajar");
        MapCar mapCar_9 = new MapCar("Kia");

        carEmployeeMap.put(mapEmployee, mapCar);
        System.out.println();
        carEmployeeMap.put(mapEmployee_2, mapCar_2);
        System.out.println();
        carEmployeeMap.put(mapEmployee_3, mapCar_3);
        System.out.println();
        carEmployeeMap.put(mapEmployee_4, mapCar_4);
        System.out.println();
        carEmployeeMap.put(mapEmployee_5, mapCar_5);
        System.out.println();
        carEmployeeMap.put(mapEmployee_6, mapCar_6);
        System.out.println();
        carEmployeeMap.put(mapEmployee_7, mapCar_7);
        System.out.println();
        carEmployeeMap.put(mapEmployee_8, mapCar_8);
        System.out.println();
        carEmployeeMap.put(mapEmployee_9, mapCar_9);

        System.out.println("---------- Now getting ---------");
        carEmployeeMap.get(mapEmployee_9);

    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MapEmployee  {

    private int employeeId;
    private String firstName;

    @Override
    public int hashCode() {
        System.out.println("I am in hashcode of employee - " + getFirstName());
        return getEmployeeId();
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof MapEmployee)) {
            return false;
        }
        MapEmployee employee = (MapEmployee) object;
        System.out.println("I am in equals of employee - " +  employee.getFirstName() + " " + getFirstName());
        return employee.getFirstName().equalsIgnoreCase(getFirstName());
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class MapCar {

    private String carName;

    @Override
    public int hashCode() {
        System.out.println("I am in hashcode of car");
        return 1;
    }

    @Override
    public boolean equals(Object car) {
        System.out.println("I am in equals of car");
        return ((MapCar)car).getCarName().equalsIgnoreCase(getCarName());
    }

}