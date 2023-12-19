import animalworld.Animal;
import animalworld.pet.IHunter;
import creator.AnimalFactory;
import animalworld.forflight.IFly;
import validator.NumberValidator;
import data.AnimalData;
import data.CommandsData;
import validator.DataValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        AnimalFactory animalFactory = new AnimalFactory();
        DataValidator commandValidator = new DataValidator();
        NumberValidator numberValidator = new NumberValidator();

        while (true) {
            System.out.println("Введите команду add/list/exit");
            String commandStr = scanner.next().toUpperCase().trim();

            if (!commandValidator.isValidate(commandStr, CommandsData.values())) {
                System.out.println("Вы ввели не верную команду,введите согласно шаблону");
                continue;
            }
            CommandsData commandsData = CommandsData.valueOf(commandStr);

            switch (commandsData) {
                case ADD:
                    String animalTypeStr = "";
                    while (true) {
                        System.out.println("Ведите тип животного : cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();
                        if (commandValidator.isValidate(animalTypeStr, AnimalData.values())) {
                            break;
                        }
                        System.out.println("Вы ввели не верный тип животного");
                    }

                    Animal animal = animalFactory.create(AnimalData.valueOf(animalTypeStr));

                    System.out.println("Ведите имя животного");
                    animal.setName(scanner.next());

                    System.out.println("Ведите возраст животного");
                    animal.setAge(scanner);

                    System.out.println("Введите вес животного");
                    animal.setWeight(scanner);

                    while (true) {
                        System.out.println("Введите цвет животного");
                        String colorStr = scanner.next();
                        if (numberValidator.isNumber(colorStr, Pattern.compile("^[а-яА-Я,a-zA-Z]+$"))) {
                            animal.setColor(colorStr);
                            break;
                        }
                        System.out.println("Вы ввели не верный цвет животного");
                    }
                    animalList.add(animal);
                    animal.say();
                    animal.go();
                    animal.drink();
                    animal.eat();
                    if (animal instanceof IFly) {
                        ((IFly) animal).fly();
                    }
                    if (animal instanceof IHunter) {
                        ((IHunter) animal).hunter();
                    }
                    break;

                case LIST:
                    if (animalList.isEmpty()) {
                        System.out.println("Никого не создали из мира животных, начните с комманды add");
                        continue;
                    }
                    for (Animal animalObj : animalList) {
                        System.out.println(animalObj.toString());
                    }
                    break;

                case EXIT:
                    System.exit(0);

                    System.out.println("Вы ввели не верную команду,введите согласно шаблону");
            }
        }
    }
}