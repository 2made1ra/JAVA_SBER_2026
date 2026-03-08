package LAB_2.tasks.Task4;

public class Task4 {
    public static void main(String[] args) {
        Person me = new Person("Andrey", 29, "male");
        System.out.println(me.getName());

        me.setName("Alexander");
        System.out.println(me.getName());
    }
}
