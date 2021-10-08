package homework20.builder;

import java.util.Set;

public class Animal {

    public int age;
    public double weight;
    public String breed;
    public String name;
    public int price;
    private Set<Animal> dogs;

    public static class Builder {

        private Animal animal;

        public Builder() {
            animal = new Animal();
        }

        public Builder withAge(int age){
            animal.age = age;
            return this;
        }

        public Builder withWeight(int weight){
            animal.weight = weight;
            return this;
        }

        public Builder withBreed(String breed){
            animal.breed = breed;
            return this;
        }

        public Builder withName(String name){
            animal.name = name;
            return this;
        }

        public Builder withPrice(int price) {
            animal.price = price;
            return this;
        }

        public Builder withDogs(Set<Animal> dogs) {
            animal.dogs = dogs;
            return this;
        }

        public Animal build() {
            return animal;
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", weight=" + weight +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
