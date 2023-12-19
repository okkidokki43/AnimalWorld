package animalworld.pet;

import animalworld.Animal;

public class Cat extends Animal implements IHunter {


    public void hunter() {
        System.out.println("Я умею охотиться");
    }

    public void say() {
        System.out.println("Мяу");
    }

    public void go() {
        System.out.println("Ночами хожу : Тыгы-дык");

    }

    public void drink() {
        System.out.println("Выпиваю молочко");

    }

    public void eat() {
        System.out.println("Кушаю Воробушков");
    }
}