package items;

import management.Currency;

public class Chest extends Storage{
    private boolean lidOpen;
    @Override
    public boolean lock(Key key){
        if(isLocked()){
            return true;
        }
        if (!isOpened()){
            closeLid();
        }
        if (!compareKeys(key)){
            return false;
        }
        else{
            setLocked();
            return true;
        }
    }
    @Override
    public boolean unlock(Key key){
        if(!isLocked()){
            return true;
        }
        if (!compareKeys(key)){
            return false;
        }
        openLid();
        setUnLocked();
        return true;
    }
    @Override
    public boolean isOpened(){
        return lidOpen;
    }
    private void closeLid(){
        lidOpen = false;
    }
    private void openLid(){
        lidOpen = true;
    }
    @Override
    public String getClassName(){
        return "Chest";
    }
    @Override
    public String toString() {
        return  this.getClassName() + ", " + this.getName();
    }
    @Override
    public boolean equals(Object o){
        Chest c = (Chest)(o);
        if (!((Storage)(this)).equals(c)){
            return false;
        }
        if (this.lidOpen = c.lidOpen){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        int j = 0;
        String s = this.getName();
        for (int i = 0; i < this.getName().length(); i++){
            j += 1;
        }
        return j;
    }
}
