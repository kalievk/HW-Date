package com.company.services;

import com.company.services.impl.EmployeeServiceImpl;

import java.text.ParseException;

public interface EmployeeService {

    EmployeeService INSTANCE = new EmployeeServiceImpl();

    void setDates() throws ParseException;

    void setEmployee() throws ParseException;

    void todayIsBirthday() throws ParseException;

    void tomorrowIsBirthday();

    void averageAge();

    void getOldest();

    void getPeers();
}