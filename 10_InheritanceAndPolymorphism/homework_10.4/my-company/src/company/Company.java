package company;

import employee.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private final String name;
    private double companyIncome;
    private final List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "\nname='" + name + '\'' +
                "\ncompanyIncome=" + companyIncome +
                "\nemployeeList=" + employeeList.size() +
                '}';
    }

    public double getCompanyIncome() {
        return companyIncome;
    }

    public void setCompanyIncome(double companyIncome) {
        this.companyIncome = companyIncome;
    }

    public double income() {
        double result = 0;
        List<Employee> test = new ArrayList<>(employeeList);
        for(Employee employee : test) {
            result += employee.getGain();

        }
        return result;
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }
    public void hireAll(List<Employee> empList) {
        employeeList.addAll(empList);
    }
    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public List<Employee> getLowSalaryStaff(int count) {
        count = Math.abs(count);
        Collections.sort(employeeList);
        List<Employee> test = new ArrayList<>();
        if (count >= employeeList.size()) {
            test.addAll(employeeList);
        } else {
            for (int i = 0; i < count; i++) {
                test.add(employeeList.get(i));
            }
        }
        return test;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        count = Math.abs(count);
        Collections.sort(employeeList);
        List<Employee> test = new ArrayList<>();
        int iter = 0;
        if (count < employeeList.size()) {
            iter = employeeList.size() - count - 1;
        }
        for (int i = employeeList.size() - 1; i > iter; i--) {
            test.add(employeeList.get(i));
        }
        return test;
    }
}
