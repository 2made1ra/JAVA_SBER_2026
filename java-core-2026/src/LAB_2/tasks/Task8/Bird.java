package LAB_2.tasks.Task8;

public class Bird extends Animal{
    public Bird(String name, int age, String sound) {
        super(name, age, sound);
    }

    public void fly() {
        System.out.println(getName() + " летит в небе!");
    }
}
