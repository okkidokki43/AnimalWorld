package animalworld;

import validator.NumberValidator;
import java.util.Scanner;
import java.util.regex.Pattern;
public abstract class Animal {

    private String name = "";
    private int age = -1;
    private int weight = -1;
    private String color = "";

    private NumberValidator numberValidator = new NumberValidator();
    public void say() {
        System.out.println("Я говорю");
    }
    public void go() {
        System.out.println("Я иду");
    }
    public void drink() {
        System.out.println("Я пью");
    }
    public void eat() {
        System.out.println("Я ем");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Scanner scanner) {
        int animalAge = -1;
        while (true) {
            String ageStr = scanner.next();
            if (numberValidator.isNumber(ageStr, Pattern.compile("^\\d+$"))) {
                animalAge = Integer.parseInt(ageStr);
                if (animalAge > 50 || animalAge <= 0) {
                    System.out.println("Нет такого возраста");
                    continue;
                }
                break;
            }
            System.out.println("Нет такого возраста");
        }
        this.age = animalAge;
    }
    public void setWeight(Scanner scanner) {
        int animalWeight = -1;
        while (true) {
            String ageStr = scanner.next();
            if (numberValidator.isNumber(ageStr, Pattern.compile("^\\d+$"))) {
                animalWeight = Integer.parseInt(ageStr);
                if (animalWeight > 50 || animalWeight <= 0) {
                    System.out.println("Нет такого веса");
                    continue;
                }
                break;
            }
            System.out.println("Нет такого веса");
        }
        this.weight = animalWeight;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getWeight() {
        return weight;
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        String yearPadej = getYearPadej();
        if (yearPadej == null) {
            return "Возраст не верный";
        }
        return String.format("Привет! меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s",
                this.name,
                this.age,
                yearPadej,
                this.weight,
                this.color);
    }
    private String getYearPadej() {
        if (this.age <= 0 || this.age > 50) {
            return null;
        }
        if (this.age >= 11 && this.age <= 19) {
            return "лет";
        }
        int ostatok = this.age % 10;
        if (ostatok == 0 || ostatok >= 5) {
            return "лет";
        }
        if (ostatok == 1) {
            return "год";
        }
        return "года";
    }
}
