package com.company;

import com.company.services.EmployeeService;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        EmployeeService employeeService = EmployeeService.INSTANCE;

        employeeService.setDates();

        employeeService.setEmployee();

        employeeService.todayIsBirthday();

        employeeService.tomorrowIsBirthday();

        employeeService.averageAge();

        employeeService.getOldest();

        employeeService.getPeers();

    }
}