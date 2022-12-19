package management;

public class Salary {
    Currency c;
    public void setSalary(Worker w, int wHours, int dWeek){
        double k = w.getLevel() * 0.65;
        int santics = (int)(k * wHours * dWeek * 4);
        Currency c = new Currency(0, santics);
        this.c = c;
    }
    public Currency getCurrency(){
        return new Currency(this.c);
    }
}
