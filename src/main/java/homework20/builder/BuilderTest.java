package homework20.builder;

public class BuilderTest {

    public static void main(String[] args) {

        Animal animal = new Animal.Builder()
                .withAge(10)
                .withName("Samantha")
                .withPrice(1500)
                .withWeight(20)
                .withBreed("Golden Retriever")
                .build();

        System.out.println(animal);
    }
}
