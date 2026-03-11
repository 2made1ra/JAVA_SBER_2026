package LAB_2.tasks.Task8;

public class Cat extends Animal{
    private String favoriteFood;

    public Cat(String name, int age, String sound, String favoriteFood) {
        super(name, age, sound);
        this.favoriteFood = favoriteFood;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public void sleep() {
        System.out.printf("%s спит весь день\n", getName());
    }
}
