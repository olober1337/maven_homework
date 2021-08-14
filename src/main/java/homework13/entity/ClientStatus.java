package homework13.entity;

import lombok.Data;

/*3. Создать сущности для этих daos, опираясь на поля таблиц из ДЗ_11 по работе с SQL;*/

@Data
public class ClientStatus {

    private String name;
    private String email;
    private String alias;
}

