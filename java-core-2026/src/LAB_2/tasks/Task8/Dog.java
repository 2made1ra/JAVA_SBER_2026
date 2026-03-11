package LAB_2.tasks.Task8;

public class Dog extends Animal{
    private final String breed;

    public Dog(String name, int age, String breed, String sound) {
        super(name, age, sound);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void findSomething() {
        System.out.println(this.getName() + " ищет что-то...");
    }
}
