package person;

import items.Item;
import items.Rope;

public interface Escape {
    public Rope makeRope(float length);
    public Item findWindowSill();
    public void fixRope(Item ws, Rope r);
    public boolean escape();
}
