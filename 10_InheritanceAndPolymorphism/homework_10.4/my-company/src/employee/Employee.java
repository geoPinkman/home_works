package employee;

import company.Company;

public abstract class Employee implements Comparable<Employee> {

    private double salary;
    private double gain;

    public Employee(double salary) {
        this.salary = salary;
        this.gain = getGain();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract int getGain();

    public abstract double getMonthSalary();

    @Override
    public int compareTo(Employee employee) {
        if (this.getMonthSalary() > employee.getMonthSalary()) {
            return 1;
        } else if (this.getMonthSalary() < employee.getMonthSalary()) {
            return -1;
        } else {
            return 0;
        }

    }
}
