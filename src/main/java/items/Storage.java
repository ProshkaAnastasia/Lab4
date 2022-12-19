package items;

import java.util.ArrayList;

public abstract class Storage extends Item{
    private boolean empty;
    private boolean locked;
    private Key key;
    private ArrayList<Item> objects;
    public boolean isLocked(){
        return locked;
    }
    public boolean isEmpty(){
        return empty;
    }
    public void showItems(){
        for (var i : objects){
            System.out.println(i.getName());
        }
    }
    public Item getItem(String name){
        if (locked){
            return null;
        }
        for (var i : objects){
            if (i.getName() == name){
                return i;
            }
        }
        return null;
    }
    public abstract boolean lock(Key key);
    public abstract boolean unlock(Key key);
    public abstract boolean isOpened();
    public boolean compareKeys(Key key){
        if (this.key == key){
            return true;
        }
        else{
            return false;
        }
    }
    protected void setLocked(){
        this.locked = true;
    }
    protected void setUnLocked(){
        this.locked = false;
    }
    @Override
    public abstract String getClassName();
}
