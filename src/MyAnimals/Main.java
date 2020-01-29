package MyAnimals;

public class Main {
    private Plate plate = new Plate();

    public static void main(String[] args) {

        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Мурзик");

        Plate plate = new Plate();

        dog.eat(dog.name, plate, 34);
        cat.eat(cat.name, plate, 17);

        Cat cat2 = new Cat("Коржик");
        cat2.eat(cat2.name, plate, 13);

        plate.getInfo();
    }
}
