package LAB_2.tasks.Task8;

public class Animal {
    private String name;
    private int age;
    private final String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank() ) {
            throw new IllegalArgumentException("Имя должно содержать символы и не быть null");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <=0 || age <= this.age) {
            throw new IllegalArgumentException("Некорректное значение возраста: возраст должен расти.");
        }
        this.age = age;
    }

    public String getSound() {
        return this.sound;
    }

    public void makeSound() {
        System.out.printf("%s говорит %s\n", this.name, this.sound);
    }
}
