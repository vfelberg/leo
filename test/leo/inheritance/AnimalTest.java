package leo.inheritance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {
    @Test
    public void testAnimal() {
        Animal animal1 = new Cat("Jessy", "female");

        Animal animal2 = new Dog();
        animal2.setName("Bob");
        animal2.setGender("male");

        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);
        for (Animal animal : animals) {
            animal.print();
        }
    }
}