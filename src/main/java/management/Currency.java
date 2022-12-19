package management;

import Exceptions.NegativeCurrencyException;

@FunctionalInterface
interface Convertation <T, N> {
    void copy(T value1, N value2);
}

class Pair{
    long f;
    long s;
    public Pair(long f, long s){
        this.f = f;
        this.s = s;
    }
}

public class Currency {
    private long fertings;
    private long santics;
    public Currency(long f, long s){
        Convertation<Currency, Pair> conv = (c, p) -> {c.fertings = p.f; c.santics = p.s;};
        //s += f * 100;
        Convertation<Currency, Long> convert = (c, sant) -> {c.fertings = sant / 100; c.santics = sant % 100;};
        if (f >= 0 && s >= 0){
            convert.copy(this, f * 100 + s);
            //conv.copy(this, new Pair(f, s));
        }
        else{
            convert.copy(this, (long)(0));
            //conv.copy(this, new Pair(0, 0));
        }
        //calculate();
    }

    public Currency(Currency c){
        super();
        this.fertings = c.getFertings();
        this.santics = c.getSantics();
    }
    private void calculate(){
        fertings += santics / 100;
        santics = santics % 100;
    }

    public boolean change(Currency c, boolean plus) throws NegativeCurrencyException{
        //Convertation<Pair, Currency> conv = (x, y) -> {}
        if (!plus){
            if (change(-c.getFertings(), -c.getSantics())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (change(c.getFertings(), c.getSantics())){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public boolean change(long f, long s) throws NegativeCurrencyException{
        if (f * s < 0){
            System.out.println("Unexpected currency");
            return false;
        }
        boolean plus = f >= 0 && s >= 0 ? true : false;
        long santics = this.santics;
        long fertings = this.fertings;
        if (plus){
            this.fertings += f;
            this.santics += s;
            calculate();
            return true;
        }
        else{
            int z = 0;
            if (Math.abs(s) > santics){
                santics = 100 + santics + s;
                z = 1;
            }
            else{
                santics += s;
            }
            fertings += (f - z);
            if (fertings < 0){
                //Checkable exception
                throw new NegativeCurrencyException();
            }
            this.santics = santics;
            this.fertings = fertings;
            return true;
        }
    }
    public long getFertings(){
        return fertings;
    }
    public long getSantics(){
        return santics;
    }
    public void setCurrency(Currency c){
        this.fertings = c.getFertings();
        this.santics = c.getSantics();
    }

    @Override
    public String toString() {
        return  Long.toString(this.fertings) + "f. " + Long.toString(this.santics) + "s.";
    }
    @Override
    public boolean equals(Object o){
        Currency c = (Currency)(o);
        if (c.fertings == this.fertings && c.santics == this.santics){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return (int)(this.santics * this.fertings) / 123;
    }
}
