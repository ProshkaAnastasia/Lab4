package management.enterpreneur;

import management.Currency;
import management.Enterpreneur;

public class FabricOwner extends Enterpreneur {
    public FabricOwner(Currency budget){
        super(budget);
    }
    private String fabricName;
    public void releaseOptimization(){

    }
    public boolean isDevastating(){
        if (getBudget().getFertings() < 5){
            return true;
        }
        else{
            return false;
        }
    }
}
