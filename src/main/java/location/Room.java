package location;

public class Room extends Location{
    //private ArrayList<Prisoners> prisoners;
    private float height;
    public Room(String name, float height){
        super(name);
        this.height = height;
    }
    @Override
    public float getMinimumHeight(){
        return height;
    }
}
