package com.vaibhavmojidra.androidjavademo2roomdatabase;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EmployeeRepository {
    private EmployeeDao dao;
    LiveData<List<Employee>> employees;

    public EmployeeRepository(EmployeeDao dao) {
        this.dao = dao;
        this.employees = dao.getAllEmployeeData();
    }

    public void update(Employee employee){
        Executors.newSingleThreadExecutor().execute(() -> {
            dao.updateEmployee(employee);
        });
    }

    public void insert(Employee employee){
        Executors.newSingleThreadExecutor().execute(() -> {
            dao.insertEmployee(employee);
        });
    }

    public void delete(Employee employee){
        Executors.newSingleThreadExecutor().execute(() -> {
            dao.deleteEmployee(employee);
        });
    }

    public void deleteAll(){
        Executors.newSingleThreadExecutor().execute(() -> {
            dao.deleteAllEmployeesData();
        });
    }

}
