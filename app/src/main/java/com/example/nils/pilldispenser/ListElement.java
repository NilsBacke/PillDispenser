package com.example.nils.pilldispenser;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Nils on 6/15/17.
 */

public class ListElement {

    public String name;
    public int number;
    public int quantity;
    public Date time;

    public ListElement() {
        number = 0;
        name = "";
        quantity = 0;
    }

    public ListElement(ListElement listElement) {
        name = listElement.getName();
        number = listElement.getNumber();
        quantity = listElement.getQuantity();
    }

    public ListElement(int number, String name) {
        this.number = number;
        this.name = name;
        quantity = 0;
    }

    public ListElement(int number, String name, int quantity) {
        this.number = number;
        this.name = name;
        this.quantity = quantity;
    }

    public ListElement(int number, String name, int quantity, Date time) {
        this.number = number;
        this.name = name;
        this.quantity = quantity;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setQuantity(int q) {quantity = q;}

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

}
