package management;

public class Manager{
    Enterpreneur e;
    /*
    @Override
    public void fire(Worker w){
        w.setFired();
        e.removeWorker(w);
    }
    @Override
    public void hire(Worker w){
        w.setHired();
        e.addWorker(w);
    }
    private Worker findWorker(int level){
        return Worker.findFreeWorker(level);
    }
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
    public void hireWorker(){
        hire(findWorker(6));
    }
    */

    public Manager(Enterpreneur e){
        super();
        this.e = e;
    }

}
