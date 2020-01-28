package MyAnimals;

public class Animal {
    protected String name;
    protected int run;


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
}
