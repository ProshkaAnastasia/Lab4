package management.enterpreneur;

import Exchange.Share;
import management.Currency;
import management.Enterpreneur;
import management.Worker;
import org.jetbrains.annotations.NotNull;
import person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Broker extends Enterpreneur {
    private HashMap <String, Integer> shares = new HashMap<>();
    public Broker(Currency budget){
        super(budget);
    }
    static class Barker extends Worker{
        Barker(String name, int age){
            super(name, age);
        }
        Barker(Worker w){
            super(w.getName(), w.getAge());
        }
        @Override
        public void work(){

        }
        public void Shout(){

        }
    }
    public void hire(Barker b){
        addWorker(b);
    }
    public void fire(Barker b){
        removeWorker(b);
    }
    public boolean buyOficialShares(String name, int quantity){
        Share s = Share.getShare(name);
        if (s == null){
            return false;
        }
        else{
            int n = Math.min(quantity, s.getNumber());
            for (int i = 0; i < n; i++){
                if (!changeBudget(s.getPrice(), false)){
                    System.out.println("Shares bought: " + Integer.toString(i));
                    break;
                }
                if(!shares.containsKey(name)){
                    shares.put(name, 1);
                }
                else{
                    shares.put(name, shares.get(name) + 1);
                }
                Share.putNumber(name, this, false);
            }
            return true;
        }
    }
    public boolean sellOficialShares(String name, int quantity){
        Share s = Share.getShare(name);
        if (s == null){
            return false;
        }
        else{
            int n = quantity;
            for (int i = 0; i < n; i++){
                changeBudget(s.getPrice(), true);
            }
            Share.putNumber(name, this, true);
        }
        return true;
    }

}
