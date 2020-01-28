package MyAnimals;

public class Dog extends Animal{
    private int maxW = 600;
    private int maxS = 20;
    private double maxH = 2;

    public Dog(String name) {
        this.name = name;
    }

    public void swim() {
        int  s = (int) (Math.random() * maxS/2 + maxS/2);
        System.out.println(this.name + " swimming " + s);
    }

    public void run() {
        int  w = (int) (Math.random() * maxW/2 + maxW/2);
        System.out.println(this.name + " running " + w);
    }

    public void jump() {
        double j = (double) (Math.random() * maxH/2 + maxH/2);
        System.out.println(this.name + " jumping " + j);
    }



}
