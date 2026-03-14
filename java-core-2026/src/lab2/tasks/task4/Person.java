package lab2.tasks.task4;

/**
 * Создайте класс Person, который содержит поля для имени,
 * возраста и пола человека.
 * Добавьте методы, которые позволяют установить и получить
 * значения этих полей.
 * Добавьте конструктор, который позволяет создавать объекты
 * класса Person, используя значения для имени, возраста и пола.
 */
public class Person {
    // Поля класса
    private String name;
    private int age;
    private String gender;

    // Конструктор класса
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттер для name
    public String getName() {
        return this.name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для age
    public int getAge() {
        return this.age;
    }

    // Сеттер для age
    public void setAge(int age) {
        if (age >= 0 && age < 125) {
            this.age = age;
        } else {
            System.out.println("Incorrect age!");
        }
    }

    // Геттер для gender
    public String getGender() {
        return this.gender;
    }

    //Сеттер для gender
    public void setGender(String gender) {
        this.gender = gender;
    }
}
