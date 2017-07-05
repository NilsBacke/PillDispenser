package com.example.nils.pilldispenser;

import java.util.Date;

/**
 * Created by Nils on 6/19/17.
 */

public class DayRegiment extends ListElement {

    public int day;
    public Date time;

    public DayRegiment(ListElement listElement, int day, Date time) {
        super(listElement);
        this.day = day;
        this.time = time;
    }

    public DayRegiment(ListElement listElement, int day) {
        super(listElement);
        this.day = day;
        this.time = null;
    }

    public DayRegiment(int number, String name, int quantity, int day) {
        super(number, name, quantity);
        this.day = day;
    }

    public DayRegiment() {
        super();
        day = 0;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return name + " on " + day;
    }

}
