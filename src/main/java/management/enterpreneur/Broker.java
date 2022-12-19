package management.enterpreneur;

import Exchange.Share;
import management.Currency;
import management.Enterpreneur;
import management.Worker;
import org.jetbrains.annotations.NotNull;
import person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Broker extends Enterpreneur {
    private HashMap <String, Integer> shares = new HashMap<>();
    public Broker(Currency budget){
        super(budget);
    }
    class Barker extends Worker{
        Barker(String name, int age){
            super(name, age);
        }
        Barker(Worker w){
            super(w.getName(), w.getAge());
        }
        private ArrayList <Broker> myBroker;
        private HashMap <Broker, pair> shareB;
        {
            myBroker = new ArrayList<>();
            shareB = new HashMap<>();
        }
        private void add(Broker b, String name){
            shareB.put(b, new pair(name, Share.getShare(name).getPrice()));
        }
        static class pair {
            String name;
            Currency price;
            public pair(String name, Currency c){
                this.name = name;
                this.price = c;
            }
        }
        @Override
        public void work(){
            HashMap <String, Currency> sB = new HashMap<>();
            int j = 0;
            for (var i : myBroker){
                i.giveTask(this);
                if(getInstruction(i) == 0){
                    buy(new pair(shareB.get(i).name, shareB.get(i).price));
                }
                else{
                    sell(new pair(shareB.get(i).name, shareB.get(i).price));
                }
            }
        }
        private void buy(pair p){

        }
        private void sell(pair p){

        }
        private int getInstruction(Broker b){
            b.giveTask(this);
            return (int)(Math.random() * 2);
        }
        private void Shout(){

        }
    }
    public void hire(Barker b){
        addWorker(b);
        b.myBroker.add(this);
    }
    public void giveTask(Barker b){
        int instruction = (int)(Math.random() * 100 + 1);
        boolean added = false;
        if (instruction < 50){
            for (var i : shares.keySet()){
                if ((int)(Math.random() * 100 + 1) % 2 == 0){
                    b.add(this, i);
                    added = true;
                }
            }
            if (!added){
                for (var i : shares.keySet()){
                    b.add(this, i);
                    break;
                }
            }
        }
        else{
            for (var i : Share.getNames()){
                if ((int)(Math.random() * 100 + 1) % 2 != 0){
                    b.add(this, i);
                    added = true;
                }
            }
            if (!added){
                for (var i : shares.keySet()){
                    b.add(this, i);
                    break;
                }
            }
        }
    }
    public void fire(Barker b){
        removeWorker(b);
        b.myBroker.remove(this);
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
