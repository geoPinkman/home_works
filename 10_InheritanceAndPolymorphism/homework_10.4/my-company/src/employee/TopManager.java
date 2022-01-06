package employee;

import company.Company;

public class TopManager extends Employee {

    public final double TOP_MANAGER_BONUS = 1.5;
    public final double BONUS_CONDITION = 10_000_000;

    private Company company;

    public TopManager(double salary) {
        super(salary);
    }

    public TopManager(double salary, Company company) {
        super(salary);
        this.company = company;
    }

    @Override
    public double getMonthSalary() {
        double result = this.getSalary();
        if (BONUS_CONDITION < this.company.getCompanyIncome()) {
            result *= (1 + TOP_MANAGER_BONUS);
        }
        return result;
    }

    @Override
    public int getGain() {
        return 0;
    }
}
