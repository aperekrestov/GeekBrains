package MyAnimals;

public class Plate {
    private int fullness = 100;

    public Plate() {

    }

    public boolean eat(String name, int percent) {
        if(percent > fullness || percent < 0) {
            System.out.println(name + " тут на " + "(" + percent + "%) " + "покушать не получиться");
            return false;
        }
        else {
            fullness -= percent;
            System.out.println(name + " съел " + percent + "% еды");
            return true;

        }
    }

    public void getInfo() {
        System.out.println("Остаток еды = " + fullness + "%");
    }

}
