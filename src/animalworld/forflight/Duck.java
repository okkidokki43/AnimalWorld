package animalworld.forflight;

import animalworld.Animal;

public class Duck extends Animal implements IFly {
    public void fly() {
        System.out.println("Я умею летать");
    }
    public void say() {
        System.out.println("Кря-кря");
    }
    public void go() {
        System.out.println("Хожу шоркаясь пузом о землю");
    }
    public void drink() {
        System.out.println("Пью воду");
    }
    public void eat() {
        System.out.println("Кушаю ряску");
    }
}


