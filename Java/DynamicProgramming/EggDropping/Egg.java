package DynamicProgramming.EggDropping;

public class Egg {
    private boolean broken;

    public Egg(){
        this.broken = false;
    }

    public boolean isBroken(){
        return broken;
    }

    public void breakEgg(){
        this.broken = true;
    }
}
