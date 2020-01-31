package MyAnimals;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Dog dog = new Dog("Бобик");
        Cat cat = new Cat("Мурзик");

        boolean c = cat.getFullness();
        System.out.println(cat.name + " ты еже поел? -" + c);

        //todo сделать проверку на поел/нет
        dog.eat(dog.name, plate, 39);
        boolean d = dog.getFullness();
        System.out.println(dog.name + " ты еже поел? -" + d );

        plate.getInfo();

        cat.eat(cat.name, plate, 23);
        c = cat.getFullness();
        System.out.println(cat.name + " ты еже поел? -" + c);

        plate.getInfo();

        System.out.println("\nПроверка на лимит еды в миске ");
        dog.eat(dog.name, plate, 44);
    }
}
