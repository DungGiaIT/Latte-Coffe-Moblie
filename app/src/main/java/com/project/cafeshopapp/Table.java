
package com.project.cafeshopapp;

public class Table {
    private int number;
    private String status;

    public Table(int number) {
        this.number = number;
        this.status = "empty"; // mặc định là "trống"
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
