import company.Company;
import employee.Employee;
import employee.Manager;
import employee.Operator;
import employee.TopManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company test = new Company("test-company");
        test.hireAll(getOperators());
        test.hireAll(getManagers());
        double income = test.income();
        test.setCompanyIncome(income);
        for (int i = 0; i < 10; i++) {
            double salaryForTopManager = (int) (Math.random() * 1_000 + 15_000);
            test.hire(new TopManager(salaryForTopManager, test));
        }

        List<Employee> testList = test.getLowSalaryStaff(3);
        for (Employee qq : testList) {
            System.out.println(qq.getMonthSalary());
        }

        System.out.println("***");

        List<Employee> testList1 = test.getTopSalaryStaff(10);
        for (Employee qq : testList1) {
            System.out.println(qq.getMonthSalary());
        }
        int ytes = (int) test.getCompanyIncome();
        System.out.println(ytes);

        System.out.println(test);
    }
    public static List<Employee> getManagers() {
        List<Employee> tests = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            double salaryForManager = (int) (Math.random() * 1_000 + 10_000);
            tests.add(new Manager(salaryForManager));
        }
        return tests;
    }

    public static List<Employee> getOperators() {
        List<Employee> tests = new ArrayList<>();
        for (int i = 0; i < 180; i++) {
            double salaryForOperators = (int) (Math.random() * 1_000 + 5_000);
            tests.add(new Operator(salaryForOperators));
        }
        return tests;
    }

}
