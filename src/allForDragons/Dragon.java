package allForDragons;

import java.util.UUID;

import java.util.Date;
public class Dragon {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    private Color color; //Поле может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonHead head;
    public Dragon(String name, Coordinates coordinates, long age, Color color, DragonType type, DragonCharacter character, DragonHead head){
        creationDate = new Date();
        UUID myuuid = UUID.randomUUID();
        id = (int)(myuuid.getMostSignificantBits());
        id = java.lang.Math.abs(id);
        this.name=name;
        this.age=age;
        this.coordinates=coordinates;
        this.character=character;
        this.head=head;
        this.type=type;
        this.color=color;
    }
}