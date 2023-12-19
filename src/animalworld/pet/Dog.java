package animalworld.pet;

import animalworld.Animal;

public class Dog extends Animal implements IHunter {

    public void hunter() {
        System.out.println("Я умею охотиться");
    }

    public void say() {
        System.out.println("Гав");
    }

    public void go() {
        System.out.println("Хожу всегда рядом");

    }

    public void drink() {
        System.out.println("Пью воду");

    }

    public void eat() {
        System.out.println("Кушаю мняско");
    }
}

