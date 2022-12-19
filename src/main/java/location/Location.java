package location;

import items.Item;
import person.Prisoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Location {
    private static Map<Item, Location> dict = new HashMap<Item, Location>();
    private static Map<Prisoner, Location> pris = new HashMap<Prisoner, Location>();
    private String name;
    public static void putObject(Item item, Location location){
        dict.put(item, location);
    }
    public static void addPrisoner(Prisoner prisoner, Location location){
        pris.put(prisoner, location);
    }
    public Location(String name){
        this.name = name;
    }
    public static Location getLocation(Item item){
        return dict.get(item);
    }
    public static Location getLocation(Prisoner prisoner){
        return pris.get(prisoner);
    }

    public static ArrayList<Item> getObjects(Location location){
        ArrayList<Item> array = new ArrayList<Item>();
        for (Map.Entry<Item, Location> entry: dict.entrySet()){
            if (entry.getValue() == location){
                array.add(entry.getKey());
            }
        }
        return array;
    }
    public float getMinimumHeight(){
        return 0;
    }
}
