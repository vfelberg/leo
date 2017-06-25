package leo.inheritance;

public abstract class Animal {
    protected String name;
    protected String gender;

    public Animal() {

    }

    public Animal(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract void print();
}
