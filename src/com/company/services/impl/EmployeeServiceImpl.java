package com.company.services.impl;

import com.company.Employee;
import com.company.services.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {

    Scanner scan = new Scanner(System.in);
    Employee[] employees = new Employee[5];
    Date today = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM");

    @Override
    public void setDates() throws ParseException {
        Date[] dates = new Date[10];
        System.out.println("Введите время в формате 'часы:минуты': ");
        for (int i = 0; i < dates.length; i++) {
            String a = scan.nextLine();
            dates[i] = sdf1.parse(a);
        }
        Date minDate = dates[0];
        for (int i = 0; i < dates.length; i++) {
            if (dates[i].before(minDate)) {
                minDate = dates[i];}
        }
        System.out.println("Минимальная из дат: " + sdf1.format(minDate));
    }

    @Override
    public void setEmployee() throws ParseException {
        for (int i = 0; i < employees.length; i++) {
            System.out.print("Enter name: ");
            String name = scan.next();
            System.out.print("Enter birth date: ");
            String day = scan.next();
            Employee employee = new Employee(name, sdf2.parse(day));
            employees[i] = employee;
        }
    }

    @Override
    public void todayIsBirthday() throws ParseException {
        for (int x = 0; x < employees.length; x++) {
            if (sdf3.format(employees[x].getBirthDate()).equals(sdf3.format(today))) {
                System.out.println("Сегодня день рождения у: " + employees[x].getName());
            } else {
                continue;
            }
        }
    }
    @Override
    public void tomorrowIsBirthday() {
        for (int x = 0; x < employees.length; x++) {
            if (sdf3.format(employees[x].getBirthDate()).equals(sdf3.format(today.getTime() + (1000 * 60 * 60 * 24)))) {
                System.out.println("Завтра день рождения у: " + employees[x].getName());
            }
        }
    }

    @Override
    public void averageAge() {
        int age = 0;
        for (int i = 0; i < employees.length; i++) {
            Date date = new Date();
            employees[i].setAge(date.getYear() - employees[i].getBirthDate().getYear());
            age = age + employees[i].getAge();
        }
        System.out.println("Средний возраст сотрудников: " + age/employees.length);
    }

    @Override
    public void getOldest() {
        Employee oldest = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (oldest.getBirthDate().after(employees[i].getBirthDate())){
                oldest = employees[i];
            }
        }
        System.out.println("Самый старший: " + oldest.getName());
    }

    @Override
    public void getPeers() {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            for (int j = i + 1; j < employees.length; j++) {
                if(employees[i].getAge()==employees[j].getAge()){
                    System.out.println("Ровесниками являются: ");
                    System.out.println(employees[i].getName());
                    System.out.println(employees[j].getName());
                    count++;
                }
            }
            }
        if(count==0){
            System.out.println("Ровесников нет");
        }
    }
}