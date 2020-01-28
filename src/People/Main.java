package People;

public class Main {
    public static void main(String[] args) {

        People anna = new People("Анна", "повар", 25, 1200);
        People pavel = new People("Павел", "водитель", 62, 2700);
        People olga = new People("Ольга", "аналитик", 33, 1800);
        People sofia = new People("София", "художник", 57, 3200);
        People yan = new People("Ян", "архитектор", 38, 3200);

        People[] peopleArray = new People[5];
        peopleArray[0] = anna;
        peopleArray[1] = pavel;
        peopleArray[2] = olga;
        peopleArray[3] = sofia;
        peopleArray[4] = yan;

        System.out.println("Все кому за 40:");
        for (int i = 0; i < peopleArray.length; i++) {
            if (peopleArray[i].a > 40) {
                peopleArray[i].getInfo();
            }
        }
    }
}
