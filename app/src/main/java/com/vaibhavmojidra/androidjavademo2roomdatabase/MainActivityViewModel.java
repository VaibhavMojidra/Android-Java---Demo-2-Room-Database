package com.vaibhavmojidra.androidjavademo2roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private EmployeeRepository repository;
    public MutableLiveData<String> updateAndSaveButtonText,clearAllAndDeleteButtonText,nameInputValue,companyInputValue;
    public LiveData<List<Employee>> employees;

    private Employee employee;
    private boolean isUpdateAndDelete=false;

    MainActivityViewModel(EmployeeRepository repository){
        this.repository=repository;
        employees=repository.employees;
        updateAndSaveButtonText=new MutableLiveData<String>();
        clearAllAndDeleteButtonText=new MutableLiveData<String>();
        nameInputValue=new MutableLiveData<String>();
        companyInputValue=new MutableLiveData<String>();
        updateAndSaveButtonText.setValue("Save");
        clearAllAndDeleteButtonText.setValue("Clear All");
        nameInputValue.setValue("");
        companyInputValue.setValue("");
    }

    public void updateAndSaveButtonClick(){
        if(isUpdateAndDelete){
            String name=nameInputValue.getValue().toString();
            String companyName=companyInputValue.getValue().toString();
            employee.setName(name);
            employee.setCompanyName(companyName);
            repository.update(employee);
            isUpdateAndDelete=false;
            nameInputValue.setValue("");
            companyInputValue.setValue("");
            updateAndSaveButtonText.setValue("Save");
            clearAllAndDeleteButtonText.setValue("Clear All");
        }else{
            String name=nameInputValue.getValue().toString();
            String companyName=companyInputValue.getValue().toString();
            Employee employee=new Employee(0,name,companyName);
            repository.insert(employee);
            nameInputValue.setValue("");
            companyInputValue.setValue("");
        }
    }

    public void clearAllAndDeleteButtonClick(){
        if(isUpdateAndDelete){
            repository.delete(employee);
            isUpdateAndDelete=false;
            updateAndSaveButtonText.setValue("Save");
            clearAllAndDeleteButtonText.setValue("Clear All");
            nameInputValue.setValue("");
            companyInputValue.setValue("");
        }else{
            repository.deleteAll();
        }

    }

    void initUpdateAndDelete(Employee employee){
        this.employee=employee;
        nameInputValue.setValue(employee.getName());
        companyInputValue.setValue(employee.getCompanyName());
        updateAndSaveButtonText.setValue("Update");
        clearAllAndDeleteButtonText.setValue("Delete");
        isUpdateAndDelete=true;
    }

}
