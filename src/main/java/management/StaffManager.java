package management;

public class StaffManager extends Manager implements StaffManage{
    @Override
    public void fire(Worker w){
        w.setFired();
        e.removeWorker(w);
    }
    @Override
    public void hire(Worker w){
        w.setHired();
        e.addWorker(w);
    }

    private Worker findWorker(int level){
        return Worker.findFreeWorker(level);
    }

    public StaffManager (Enterpreneur e){
        super(e);
    }
    public void hireWorker(int level){
        hire(findWorker(level));
    }
}
