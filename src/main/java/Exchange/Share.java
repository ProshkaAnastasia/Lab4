package Exchange;

import Exceptions.NegativeCurrencyException;
import management.Currency;
import management.enterpreneur.Broker;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Share {
    String name;
    Currency price;
    int number;
    public static Share getShare(String name){
        if (!summary.containsKey(name)){
            return null;
        }
        else{
            return summary.get(name);
        }
    }
    public static void putNumber(String name, Broker b, boolean inc){
        if (inc){
            summary.get(name).number++;
        }
        else {
            summary.get(name).number--;
        }
    }
    //anonymous class
    public static Thread renewShare = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                Share.renew();
                try{
                    sleep(1);
                }
                catch(InterruptedException e){}
            }
        }
    });
    private static HashMap <String, Share> summary;

    synchronized private static void renew(){
        for (var i : summary.keySet()){
            boolean fall = !(Math.random() * 10000 + 1 > 50);
            summary.get(i).changePrice(fall);
            //System.out.println(summary.get(i));
        }
    }
    static{
        summary = new HashMap<String, Share>();
    }
    public Share(String name, Currency price){
        this.name = name;
        this.price = price;
        this.number = (int)(Math.random() * 1000 + 1);
        summary.put(name, this);
    }
    private Share(Share s){
        this.name = s.name;
        this.price = s.price;
        this.number = s.number;
    }
    public int getNumber(){
        return this.number;
    }
    public Currency getPrice(){
        return new Currency(this.price);
    }
    synchronized public void changePrice(boolean fall){
        long f = (int)(Math.random() * price.getFertings());
        long s = (int)(Math.random() * price.getSantics());
        try {
            if (fall) {
                price.change(new Currency(f, s), false);
            } else {
                price.change(new Currency(f, s), true);
            }
        }
        catch(NegativeCurrencyException e){
            e.getMessage();
        }
    }
    @Override
    public String toString(){
        return this.name + ": " + this.price;
    }
}
