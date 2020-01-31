package MyAnimals;

public class Animal {
    protected String name;
    protected int run;
    private boolean fullness;
    private int wontEat = 9; // - 9% - остаток энергии

    public Animal(){

    }

    public Animal(String name) {

        this.name = name;
    }

    public void run() {

        System.out.println(this.name + " running ");
    }

    public void jump() {

        System.out.println(this.name + " jumping ");
    }

    public void name() {

        System.out.println(this.name);
    }

    public boolean getFullness() {

        return fullness;
    }

    public void eat(String name, Plate plate, int percent) {

        Plate pl = plate;
        fullness = plate.eat(name, percent);
    }
}
