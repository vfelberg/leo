package leo.inheritance;

public class Cat extends Animal {
    public Cat(String name, String gender) {
        super(name, gender);
    }

    public void print() {
        System.out.println("Cat{name=" + name + ", gender=" + gender + "}");
    }
}
