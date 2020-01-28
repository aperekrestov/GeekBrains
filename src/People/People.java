package People;

public class People {
    protected String n;
    private String j;
    protected int a;
    private int s;

    public People(String name, String job, int age, int salary) {
       n = name;
       j = job;
       a = age;
       s = salary;
    }

    public void getInfo() {
        System.out.println(n + " / " + j + " / " + a + " / " + s );
    }

    public void getAge() {
        System.out.println(a);
    }
}
