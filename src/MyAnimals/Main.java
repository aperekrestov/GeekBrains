package MyAnimals;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Bobik");
        dog.run();
        dog.jump();
        dog.swim();

        System.out.println("");
        Cat cat = new Cat("Murzik");
        cat.run();
        cat.jump();
        cat.swim();

    }
}
