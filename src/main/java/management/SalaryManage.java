package management;

public interface SalaryManage {
    public void changeSalary(Worker w, Salary s, int hours, int wDays);
    public boolean paySalary(Worker w);
}
