package homework15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Main {

    public static void main(String[] args) {

        emptyStreamWithOperations();
        setWithData();
        setToListWithData();
        mapCollection();
        streamOperations();
        streamToMultithreading();
        referenceMethods1();
    }

    //1.Создать пустой поток с двумя любыми промежуточными операциями и одной терминальной,
    // которая напечатает результат коллекции;

    private static void emptyStreamWithOperations() {

        Optional<String> emptyStream = Stream.of().map(n -> n + "null")
                .distinct()
                .findAny();

        emptyStream.ifPresent(System.out::println);
    }

    //2. Создать поток с Листом данных(на Ваше усмотрения),
    // который будет иметь две промежуточные операции и результатом выполнения получить Набор данных;

    private static void setWithData() {

        List<String> collection = Arrays.asList("Iphone 10", "Bphone 11", "Cphone 12 Pro Max Ultra", "Samsung Galaxy");
        System.out.println(collection.stream()
                .map(String::toUpperCase)
                .skip(1).collect(toSet()));

    }

    //3. Создать поток Набора данных(на Ваше усмотрение),
    // который не будет иметь промежуточных данных и результатом будет Лист данных;

    private static void setToListWithData() {

        Set<Integer> collectionSet = new HashSet<>();

        for (int i = 1; i < 10; i++) {
            collectionSet.add(i);
        }

        List<Integer> collectionList = collectionSet.stream()
                .collect(toList());

        System.out.println(collectionList);
    }

    //4. Создать Коллекцию в виде “ключ-значение”, наполнить, получив значение ключей пройтись по всем,
    // напечатать их значение и результатом сохранить в виде коллекции;

    private static void mapCollection() {

        Map<Integer, String> collectionMap = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            collectionMap.put(i, "null" + i);
        }

        Set<Integer> mySet = collectionMap.keySet().stream().collect(toSet());
        mySet.forEach(System.out::println);

    }


    //5. Cоздать коллекцию из 10 строчных значений в виде чисел. Используя стрим пропустить первое значение,
    // указать лимит 8 значений, преобразовать все значения в int,
    // отфильтровать значения только четных значения и собрать результат в коллекцию ТОЛЬКО уникальных значений;

    private static void streamOperations() {

        List<String> collection = Arrays.asList("2", "3", "4", "11", "6", "11", "8", "9", "10", "14");
        collection.stream()
                .skip(1).limit(8)
                .mapToInt(Integer::parseInt)
                .filter(number -> number % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    //6. Создать поток, сразу наполнив его данными(не из коллекции),
    // преобразовать в многопоточный поток, отсортировать,
    // задать фильтр(на свое усмотрение) и найти первый элемент, который попадется(как результат выполнения);

    private static void streamToMultithreading() {

        Stream<Integer> newStream = Stream.of(1, 2, 4, 234, 65, 12, 98, 64, 97, 52);

        Optional<Integer> outputStream = newStream.parallel().filter(number -> number % 2 == 0).findAny();

        outputStream.ifPresent(System.out::println);

    }

    //7. Создать поток, в котором показать применения всех 4х возможных вызовов Ссылочных методов.
    // На свое усмотрение, но должны быть примеры вызовов всех методов в одном потоке.
    // Можно создавать свои классы и методы для примера вызова, можно использовать представленные уже в Java;

    private static void referenceMethods1() {

        List<Integer> numbers = Arrays.asList(5, 3, 50, 24, 40, 2, 9, 18);

        numbers.stream()
                .filter(Main::isGreaterThan3)
                .filter(Main::isEven)
                .map(Main::doubleNumber)
                .map(Main::minusNumber)
                .forEach(System.out::println);
    }

    private static boolean isGreaterThan3(int number) {
        return number > 3;
    }


    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static int doubleNumber(int number) {
        return number * 2;
    }

    private static int minusNumber(int number) {
        return number - 2;
    }
}
