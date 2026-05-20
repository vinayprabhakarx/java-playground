package com.vinayprabhakarx.io.deserialization;

import com.vinayprabhakarx.pojo.Employee;

public class EmployeeDeserializeApp {
    public static void main(String[] args) {
        String filePath = "src/main/resources/com/vinayprabhakarx/io/file/employee.ser";

        DeserializeApp<Employee> deserializeApp = new DeserializeApp<>();
        deserializeApp.deserialize(filePath, Employee.class);
    }
}
