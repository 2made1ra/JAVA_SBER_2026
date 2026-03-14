package lab2.tasks.task8;

public class Task8 {
    public static void main(String[] args) {
        Dog rex = new Dog("Rex", 8, "Овчарка", "Гав");
        System.out.println("Имя моей собаки " + rex.getName());
        rex.findSomething();
        rex.setName("Рекс");
        System.out.printf("Мою собаку зовут %s, она породы %s\n", rex.getName(), rex.getBreed());
        System.out.println();

        Cat mason = new Cat("Mason", 11, "мяу", "лосось");
        System.out.println("Имя моего кота " + mason.getName());
        mason.sleep();
        System.out.println();

        Bird voodie = new Bird("Вуди", 4, "тук тук");
        voodie.fly();
        System.out.println();

        Animal[] animals = new Animal[] {rex, mason, voodie};
        for (Animal animal: animals) {
            animal.makeSound();
        }
    }
}
