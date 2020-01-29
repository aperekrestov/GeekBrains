package Humans;

/*
1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
*/

/**
 * Класс "Сотрудник"
 */
public class Person {
    private String name;    //ФИО
    private String position;//Должность
    private String email;   //Адрес электронной почты
    private String phone;   //Номер телефона
    private double wages;   //Заработная плата
    private int age;        //Возраст

    /**
     * Конструктор по умолчанию
     */
    public Person () {
        name = "unknown";
        position = "unknown";
        email = "unknown";
        phone = "unknown";
        wages = 0.0;
        age = 0;
    }

    /**
     * Параметризированный конструктор
     * @param name - фимилия, имя, отчество сотрудника
     * @param position - должность сотрудника
     * @param email - адрес электронной почты сотрудника
     * @param phone - телефор сотрудника
     * @param wages - заработная плата сотрудника
     * @param age - возраст сотрудника
     */
    public Person (String name, String position, String email, String phone, double wages, int age) {
        //Использую сеттеры, т.к. в них могут выполняться всякого рода проверки корректности введенных данных
        setName(name);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setWages(wages);
        setAge(age);
    }

    /**
     * Метод выводит информацию о сотруднике в консоль
     */
    public void personInfo () {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Информация о сотруднике " + name + ":");
        System.out.println("\tдолжность - \t" + position + ";");
        System.out.println("\te-mail - \t\t" + email + ";");
        System.out.println("\tтелефон - \t\t" + phone + ";");
        System.out.println("\tзарплата - \t\t" + wages + ";");
        System.out.println("\tвозраст - \t\t" + age + ".");
        System.out.println("----------------------------------------------------------------------");
    }
    //Методы установки полей
    public void setName (String name) {
        if (!name.isEmpty())
            this.name = name;
        else
            System.out.println("Введено не корректное имя");
    }

    public void setPosition (String position) {
        this.position = position;
    }

    public void setEmail (String email) {
        if (email.contains("@") && email.contains("."))
            this.email = email;
        else
            System.out.println("Введен не корректный адрес электронной почты");
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public void setWages (double wages) {
        this.wages = wages;
    }

    public void setAge (int age) {
        this.age = age;
    }
    //Методы доступа
    public String getName () {
        return name;
    }

    public String getPosition () {
        return position;
    }

    public String getEmail () {
        return email;
    }

    public String getPhone () {
        return phone;
    }

    public double getWages () {
        return wages;
    }

    public int getAge () {
        return age;
    }
}
