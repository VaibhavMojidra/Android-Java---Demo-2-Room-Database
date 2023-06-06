package com.vaibhavmojidra.androidjavademo2roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.vaibhavmojidra.androidjavademo2roomdatabase.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModelFactory factory;
    private MainActivityViewModel viewModel;
    private EmployeeRepository repository;
    private EmployeeDao dao;

    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        dao=EmployeeDatabase.getInstance(getApplicationContext()).dao();
        repository=new EmployeeRepository(dao);
        factory=new MainActivityViewModelFactory(repository);
        viewModel= new ViewModelProvider(this,factory).get(MainActivityViewModel.class);
        binding.setMyViewModel(viewModel);
        binding.setLifecycleOwner(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.employees.observe(this, employees -> {
            Log.i("MyTag",employees.toString());
            binding.recyclerView.setAdapter(new MyRecyclerViewAdapter(employees, new EmployeeItemClickListener() {
                @Override
                public void onClick(Employee employee) {
                    viewModel.initUpdateAndDelete(employee);
                }
            }));
        });


    }
}