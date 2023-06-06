package com.vaibhavmojidra.androidjavademo2roomdatabase;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vaibhavmojidra.androidjavademo2roomdatabase.databinding.EmployeeItemBinding;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Employee> employees;
    private EmployeeItemClickListener employeeItemClickListener;

    public MyRecyclerViewAdapter(List<Employee> employees, EmployeeItemClickListener employeeItemClickListener) {
        this.employees = employees;
        this.employeeItemClickListener = employeeItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        EmployeeItemBinding binding=DataBindingUtil.inflate(inflater,R.layout.employee_item,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(employees.get(position),employeeItemClickListener);
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private EmployeeItemBinding employeeItemBinding;

        public MyViewHolder(EmployeeItemBinding binding) {
            super(binding.getRoot());
            employeeItemBinding=binding;
        }

        void bind(Employee employee,EmployeeItemClickListener clickListener){
            employeeItemBinding.nameTextView.setText(employee.getName());
            employeeItemBinding.companyTextView.setText(employee.getCompanyName());
            employeeItemBinding.employeeIdTextView.setText(String.valueOf(employee.getEmployeeID()));
            employeeItemBinding.card.setOnClickListener(view -> {
                clickListener.onClick(employee);
            });
        }

    }
}
