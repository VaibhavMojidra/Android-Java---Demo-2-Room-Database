package com.vaibhavmojidra.androidjavademo2roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee_Table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int employeeID;

    private String name;

    @ColumnInfo(name = "Company")
    private String companyName;

    public Employee(int employeeID, String name, String companyName) {
        this.employeeID = employeeID;
        this.name = name;
        this.companyName = companyName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
