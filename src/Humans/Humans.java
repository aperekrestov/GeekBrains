package Humans;

public class Humans {
    public static void main(String[] args) {
        //4. Создать массив из 5 сотрудников
        Person[] persArray = new Person[5];//Массив сотрудников

        //Проинициализируем элементы массива
        persArray[0] = new Person("Иванов Иван Иванович", "директор", "ivanov_ii@fgh.ru", "+7-952-123-12-31", 100_000.00, 43);
        persArray[1] = new Person("Петров Петр Петрович", "главный инженер", "petrov_pp@fgh.ru", "+7-952-321-35-36", 80_000.00, 48);
        persArray[2] = new Person("Сидоров Сидр Сидорович", "Java-программист", "sidorov_ss@fgh.ru", "+7-952-538-75-81", 100_000.00, 30);
        persArray[3] = new Person("Климов Клим Климович", "экспедитор", "klimov_kk@fgh.ru", "+7-952-168-25-70", 50_000.00, 56);
        persArray[4] = new Person("Сергеев Сергей Сергеевич", "техник", "sergeev_ss@fgh.ru", "+7-952-823-44-75", 35_000.00, 24);

        //С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("Информация о сотрудниках старше 40 лет:");
        for (Person person : persArray) {
            if (person.getAge() > 40)
                person.personInfo();
        }
        System.out.println();

        //Дополнительно найдем сотрудника или сотрудников с самой высокой з/п
        int index = 0;
        Person[] buf = new Person[persArray.length];//Временный буфер для хранения списка сотрудников
        buf[index] = persArray[index];
        int max = (int) persArray[index].getWages();//Отбросим дробную часть
        for (int i = 1; i < persArray.length; i++) {
            int next = (int) persArray[i].getWages();
            if (next > max) {
                max = next;
                buf[index] = persArray[i];
            } else if (next == max) {
                buf[++index] = persArray[i];
            }
        }
        System.out.println("Информация о сотрудниках с максимальной зарплатой.");
        System.out.println("Максимальная зарплата в компании у сотрудников:");
        for (Person person : buf) {
            if (person != null) {
                System.out.print(person.getName() + " - ");
                System.out.print(person.getWages());
                System.out.print(" рублей, должность: ");
                System.out.println(person.getPosition());
            } else
                break;
        }
    }
}
