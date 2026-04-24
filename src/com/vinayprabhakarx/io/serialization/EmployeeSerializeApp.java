package com.vinayprabhakarx.io.serialization;

import com.vinayprabhakarx.pojo.Employee;

public class EmployeeSerializeApp {
    public static void main(String[] args) {
        String filePath = "src/com/vinayprabhakarx/io/file/employee.ser";
        Employee employee = new Employee(201, "Vinay", "Engineering", 75000.0);

        SerializeApp<Employee> serializeApp = new SerializeApp<>();
        serializeApp.serialize(employee, filePath);
    }
}
