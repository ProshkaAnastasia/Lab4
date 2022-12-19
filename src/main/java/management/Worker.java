package management;

import Exceptions.NegativeCurrencyException;
import person.Person;

import java.util.ArrayList;

public class Worker extends Person {
    private static ArrayList<Worker> freeWorkers = new ArrayList<Worker>();
    public static boolean addWorker(Worker w){
        if (!w.isHired()){
            freeWorkers.add(w);
            return true;
        }
        else{
            return false;
        }
    }
    private int level;
    private Salary s;
    protected void setSalary(Salary s){
        this.s = s;
    }
    public int getLevel(){
        return level;
    }
    protected static Worker findFreeWorker(int level){
        Worker w = null;
        if (freeWorkers.size() == 0){
            //return false;
        }
        for (int i = 0; i < freeWorkers.size(); i++){
            if (freeWorkers.get(i).getLevel() >= level){
                w = freeWorkers.get(i);
                break;
            }
        }
        if (w == null){
            w = freeWorkers.get((int)(Math.random() * freeWorkers.size()));
        }
        return w;
    }
    private boolean hired = false;
    public boolean isHired(){
        return hired;
    }

    protected void getSalary(){
        try {
            getBudget().change(s.getCurrency(), true);
        }
        catch (NegativeCurrencyException e){
            e.getMessage();
        }
    }

    protected Currency showSalary(){
        return new Currency(s.getCurrency());
    }
    protected void setHired(){
        hired = true;
        freeWorkers.remove(this);
    }
    protected void setFired(){
        hired = false;
        freeWorkers.add(this);
    }
    public Worker(String name, int age, int level){
        super(name, age);
        this.level = level;
    }
    public Worker(String name, int age){
        super(name, age);
        level = 10;
    }
    public void work(){

    }
}
