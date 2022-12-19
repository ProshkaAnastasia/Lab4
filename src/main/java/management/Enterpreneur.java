package management;

import Exceptions.NegativeCurrencyException;

import java.util.ArrayList;

public class Enterpreneur {
    private Currency budget;
    ArrayList <Worker> workers = new ArrayList<Worker>();
    protected void addWorker(Worker w){
        workers.add(w);
    }
    protected void removeWorker(Worker w){
        workers.remove(w);
    }
    protected boolean changeBudget(Currency c, boolean plus){
        try {
            return budget.change(c, plus);
        }
        catch(NegativeCurrencyException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    public Enterpreneur(Currency budget){
        super();
        this.budget = budget;
    }
    protected Currency getBudget(){
        return budget;
    }
}
