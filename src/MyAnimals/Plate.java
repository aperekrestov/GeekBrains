package MyAnimals;

public class Plate {
    private int fullness = 100;

    public Plate() {

    }

    public void eat(String name, int percent) {
        if(percent > fullness || percent < 0) {
            System.out.println(name + " тут так " + "(" + percent + "%) " + "покушать не получиться \n");
        }
        else {
            fullness -= percent;
            System.out.println(name + " съел " + percent + "% еды" + "\n");

        }
    }

    public void getInfo() {
        System.out.println("Остаток еды = " + fullness + "%");
    }

}
