package ru.ncedu.providokhin.date;

public class Main {
    public static void main(String[] args) {
        Date_Netcracker date = new Date_Netcracker(1900, 1, 1);
        System.out.println(date.isLeapYear());
        date.setYear(2000);
        System.out.println(date.isLeapYear());

        Date_Netcracker date1 = new Date_Netcracker(1900, 2, 1);
        System.out.println(date1.isValidDate());

        Date_Netcracker date2 = new Date_Netcracker(1900, 4, 32);
        System.out.println(date2.isValidDate());

        Date_Netcracker date3 = new Date_Netcracker(2000, 2, 29);
        System.out.println(date3.isValidDate());

        Date_Netcracker date4 = new Date_Netcracker(2001, 2, 29);
        System.out.println(date4.isValidDate());

        Date_Netcracker date5 = new Date_Netcracker(2020, 10, 18);
        System.out.println(date5.getDayOfWeek());

        System.out.println(date5.getStringDayOfWeek(date5.getDayOfWeek()));

        Date_Netcracker date6 = new Date_Netcracker(2020, 10, 18);
        System.out.println(date6.countDays());
        System.out.println(date6.toString());


    }
}
