package employee;

public class Manager extends Employee{
    public final double MANAGER_BONUS = 0.05;
    public final double MIN_MANAGER_GAIN = 115_000;
    public final double MAX_MANAGER_GAIN = 140_000;



    public Manager(double salary) {
        super(salary);

    }

    public int getGain() {
        double result;
        do{
            result = (int)(Math.random() * MAX_MANAGER_GAIN);
        } while (result < MIN_MANAGER_GAIN | result > MAX_MANAGER_GAIN);
        return (int) result;
    }

    public double getMonthSalary() {
        double result = this.getSalary() + this.getGain() * MANAGER_BONUS;
        return result;
    }
}
