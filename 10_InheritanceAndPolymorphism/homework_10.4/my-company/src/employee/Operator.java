package employee;

public class Operator extends Employee {

    public Operator(double salary) {
        super(salary);
    }

    @Override
    public double getMonthSalary() {
        return getSalary();
    }

    @Override
    public int getGain() {
        return 0;
    }

}
