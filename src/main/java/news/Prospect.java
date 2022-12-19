package news;

public enum Prospect {
    BOMB(6),
    VERYPROMISING(5),
    PROMISING(4),
    INTERESTING(3),
    BORING(2),
    UNPROMISING(1);
    private int interest;
    private Prospect(int interest){
        this.interest = interest;
    }
    public int getInterest(){
        return this.interest;
    }
    protected static Prospect getProspect(int ind){
        switch(ind){
            case 1:
                return UNPROMISING;
            case 2:
                return BORING;
            case 3:
                return INTERESTING;
            case 4:
                return PROMISING;
            case 5:
                return VERYPROMISING;
            default:
                return BOMB;
        }
    }
    protected static Prospect randProspect(){
        int ind = (int)(Math.random() * 6 + 1);
        return getProspect(ind);
    }
}
