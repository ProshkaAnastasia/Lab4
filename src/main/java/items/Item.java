package items;

import location.Location;

public abstract class Item {
    private String name;
    private boolean fireProof;
    public boolean isTied(){
        return Rope.getInfo(this);
    }
    public boolean isFireProof(){
        return fireProof;
    }
    public String getName(){
        return this.name;
    }
    public void changeLocation(Location location){
        Location.putObject(this, location);
    }
    public Location getLocation(){
        return Location.getLocation(this);
    }
    public abstract String getClassName();
}
