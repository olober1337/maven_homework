package homework12.entity;

import lombok.Data;

/*3. Создать сущности для этих daos, опираясь на поля таблиц из ДЗ_11 по работе с SQL;*/

@Data
public class Status {

    private int id;
    private String alias;
    private String description;

}

