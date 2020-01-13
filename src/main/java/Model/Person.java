package Model;

public class Person {
    private String name;
    private String surname;
    private int age;

    public Person (String name, String surname, int age) {
        this.age = age;
        this.surname= surname;
        this.name = name;
    }

    public String getName() { return name; }

    public String getSurname() {
        return surname;
    }

    public int getAge() { return age; }

    public String toString () {
        return name + " " + surname + " " + age;
    }
}
