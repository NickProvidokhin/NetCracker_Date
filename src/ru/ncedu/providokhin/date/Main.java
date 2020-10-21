package ru.ncedu.providokhin.date;

public class Main {
    public static void main(String[] args) {
        DateNetcracker date = new DateNetcracker(1900, 1, 1);
        System.out.println(date.isLeapYear());
        date.setYear(2000);
        System.out.println(date.isLeapYear());

        DateNetcracker date1 = new DateNetcracker(1900, 2, 1);
        System.out.println(date1.isValidDate());

        DateNetcracker date2 = new DateNetcracker(1900, 4, 32);
        System.out.println(date2.isValidDate());

        DateNetcracker date3 = new DateNetcracker(2000, 2, 29);
        System.out.println(date3.isValidDate());

        DateNetcracker date4 = new DateNetcracker(2001, 2, 29);
        System.out.println(date4.isValidDate());

        DateNetcracker date5 = new DateNetcracker(2020, 10, 18);
        System.out.println(date5.getDayOfWeek());

        //System.out.println(date5.StringDayOfWeek(date5.getDayOfWeek()));

        DateNetcracker date6 = new DateNetcracker(2020, 10, 18);
        System.out.println(date6.countDays());
        System.out.println(date6.toString());


    }
}
