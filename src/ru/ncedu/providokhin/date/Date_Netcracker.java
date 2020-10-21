package ru.ncedu.providokhin.date;

import java.time.LocalDate;
import java.util.*;

public class Date_Netcracker {
    public int year;
    public int month;
    public int day;

    public Date_Netcracker(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return day;
    }

    public void setDate(int date) {
        this.day = date;
    }

    public boolean isLeapYear() {

        int multipleof100 = 100;
        int multipleof400 = 400;
        int multipleof4 = 4;
        if ((year % multipleof400 == 0) || (year % multipleof4 == 0) && (year % multipleof100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidDate() {
        int MIN = 0;//количество дней, месяцев и лет не может быть меньше нуля
        int MAX_COUNT_OF_MONTH = 12;
        int MAX_COUNT_OF_DAY = 31;
        ArrayList<Integer> MONTH_WHICH_MAX_30_DAYS = new ArrayList<Integer>();
        MONTH_WHICH_MAX_30_DAYS.add(4);
        MONTH_WHICH_MAX_30_DAYS.add(6);
        MONTH_WHICH_MAX_30_DAYS.add(9);
        MONTH_WHICH_MAX_30_DAYS.add(11);
        int MAX_COUNT_DAYS_OF_LEAP_YEAR = 29;
        int MAX_COUNT_DAYS_OF_NOT_LEAP_YEAR = 28;
        int FEBRUARY = 2;
        if ((year < MIN) || ((month < MIN) || (month > MAX_COUNT_OF_MONTH)) || ((day < MIN) || (day > MAX_COUNT_OF_DAY))) {
            return false;
        }
        if (MONTH_WHICH_MAX_30_DAYS.contains(month)) {
            if (day > MAX_COUNT_OF_DAY - 1) {
                return false;
            }
        }

        if (month == FEBRUARY) {
            if (isLeapYear()) {
                if (day > MAX_COUNT_DAYS_OF_LEAP_YEAR) {
                    return false;
                }
            } else if (day > MAX_COUNT_DAYS_OF_NOT_LEAP_YEAR) {
                return false;
            }
        }
        return true;
    }

    public int getDayOfWeek() {
        int dayOfWeek;
        int a = (14 - month) / 12;//смещение первых двух месцев?
        int y = year - a;
        int m = month + 12 * a - 2;
        dayOfWeek = (day + (31 * m) / 12 + y + y / 4 - y / 100 + y / 400) % 7;
        dayOfWeek--;
        if (dayOfWeek == -1) {
            dayOfWeek = 6;
        }
        return dayOfWeek;
    }

    public String getStringDayOfWeek(int d) {
        String dayOfWeek = "";
        switch (d) {
            case 0:
                dayOfWeek = "Monday";
                break;
            case 1:
                dayOfWeek = "Tuesday";
                break;
            case 2:
                dayOfWeek = "Wednesday";
                break;
            case 3:
                dayOfWeek = "Thursday";
                break;
            case 4:
                dayOfWeek = "Friday";
                break;
            case 5:
                dayOfWeek = "Saturday";
                break;
            case 6:
                dayOfWeek = "Sunday";
                break;
        }
        return dayOfWeek;
    }


    public int countDays() {
        int y = year;
        int m = month;
        if (m < 3) {
            y--;
            m += 12;
        }
        int countDay = 365 * y + y / 4 - y / 100 + y / 400 + (153 * m - 457) / 5 + day - 306;

        LocalDate currentDate = LocalDate.now();
        int currentDays = currentDate.getDayOfMonth();
        int currentMonths = currentDate.getMonthValue();
        int currentYears = currentDate.getYear();

        int currentCountDay = 365 * currentYears + currentYears / 4 - currentYears / 100 + currentYears / 400 + (153 * currentMonths - 457) / 5 + currentDays - 306;

        return Math.abs(countDay - currentCountDay);
    }

    public enum MonthsString {

        Jan(1),
        Feb(2),
        Mar(3),
        Apr(4),
        May(5),
        Jun(6),
        Jul(7),
        Aug(8),
        Sep(9),
        Oct(10),
        Nov(11),
        Dec(12);
        private int val;

        MonthsString(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    @Override
    public String toString() {
        String BeatifulDate = "";
        return BeatifulDate = getStringDayOfWeek(getDayOfWeek()) + " " + day + " " + MonthsString.values()[month - 1] + " " + year;
    }

}
