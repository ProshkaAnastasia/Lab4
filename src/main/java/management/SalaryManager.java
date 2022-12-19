package management;

public class SalaryManager extends Manager implements SalaryManage{
    @Override
    public void changeSalary(Worker w, Salary s, int hours, int wDays){
        s.setSalary(w, hours, wDays);
        w.setSalary(s);
    }
    @Override
    public boolean paySalary(Worker w){
        if (e.changeBudget(w.showSalary(), false)){
            w.getSalary();
            return true;
        }
        else{
            return false;
        }
    }
    public SalaryManager(Enterpreneur e){
        super(e);
    }
}
