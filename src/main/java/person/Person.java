package person;

import management.Currency;

public class Person {
    String name;
    int age;

    Currency budget;

    public Currency getBudget(){
        return budget;
    }
    public Person (String name, int age){
        this.name = name;
        this.age = age;
        this.budget = new Currency(0, 0);
    }

    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
}
