package com.vaibhavmojidra.androidjavademo2roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Insert
    void insertEmployee(Employee employee);

    @Delete
    void deleteEmployee(Employee employee);

    @Update
    void updateEmployee(Employee employee);

    @Query("DELETE FROM Employee_Table")
    void deleteAllEmployeesData();

    @Query("SELECT * FROM Employee_Table")
    LiveData<List<Employee>> getAllEmployeeData();

}
