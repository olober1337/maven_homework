package homework13.entity;

import lombok.Data;

/*3. Создать сущности для этих daos, опираясь на поля таблиц из ДЗ_11 по работе с SQL;*/

@Data
public class Client {

    private int id;
    private String name;
    private String email;
    private Long phone;
    private String about;
    private int age;

}
