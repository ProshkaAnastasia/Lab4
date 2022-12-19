package items;

import java.util.ArrayList;

class Pair{
    Item item;
    Rope rope;
    protected Pair(Rope rope, Item item){
        this.item = item;
        this.rope = rope;
    }
}

public class Rope extends Item{
    private static ArrayList<Pair> array = new ArrayList<Pair>();
    public static boolean getInfo(Item item){
        for (var a : array){
            if (a.item == item){
                return true;
            }
        }
        return false;
    }
    private float length;
    public Rope(float length){
        super();
        this.length = length;
    }
    private boolean isTied = false;

    public boolean tie(Item item){
        if (!isTied){
            array.add(new Pair(this, item));
            this.isTied = true;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean unTie(){
        if (isTied){
            int index = -1;
            for (int i = 0; i < array.size(); i++){
                if (array.get(i).rope == this){
                    array.remove(i);
                }
                this.isTied = false;
            }
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String getClassName(){
        return "Rope";
    }

}
