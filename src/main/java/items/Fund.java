package items;

public class Fund extends Storage{
    boolean doorsOpened;

    @Override
    public boolean lock(Key key){
        if (isLocked()){
            return true;
        }
        if (!isOpened()){
            closeDoors();
        }
        if (!compareKeys(key)){
            return false;
        }
        setLocked();
        return true;
    }
    @Override
    public boolean unlock(Key key){
        if (!isLocked()){
            return true;
        }
        if (!compareKeys(key)){
            return false;
        }
        setUnLocked();
        openDoors();
        return true;
    }
    @Override
    public boolean isOpened(){
        return doorsOpened;
    }
    public void openDoors(){
        doorsOpened = true;
    }
    public void closeDoors(){
        doorsOpened = false;
    }
    @Override
    public String getClassName(){
        return "Fund";
    }
}
