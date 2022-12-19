package person;

import items.Item;
import items.Rope;
import location.Location;
import location.Room;
import location.Freedom;

import java.util.ArrayList;

public class Prisoner extends Person implements Escape{
    public Prisoner(String name, int age){
        super(name, age);
        Location.addPrisoner(this, new Room("Unnamed", 2.5f));
    }
    public Rope makeRope(float length){
        return new Rope(length);
    }
    public Item findWindowSill(){
        Location l = Location.getLocation(this);
        ArrayList<Item> array = Location.getObjects(l);
        Item answer = null;
        for (var i : array){
            if (i.getClassName() == "WindowSill" && i.isTied()){
                return i;
            }
            if (i.getClassName() == "WindowSill"){
                answer = i;
            }
        }
        return answer;
    }
    public void fixRope(Item ws, Rope rope){
        rope.tie(ws);
    }
    public boolean escape(){
        Location l = Location.getLocation(this);
        Item ws = findWindowSill();
        if (ws == null){
            return false;
        }
        if (!ws.isTied()){
            Rope r = makeRope(l.getMinimumHeight());
            r.tie(ws);
        }
        Location.addPrisoner(this, new Freedom("Freedom"));
        System.out.println(getName() + " спасен!");
        return true;
    }
}
