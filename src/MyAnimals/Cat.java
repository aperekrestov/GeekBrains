package MyAnimals;

public class Cat extends Animal{
    private int maxW = 300;
    private double maxH = 10;

    public Cat(String name) {
        this.name = name;
    }

    public void swim() {
        System.out.println(this.name + " can not swim ");
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
