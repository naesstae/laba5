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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dragon dragon)) return false;
        return id == dragon.id && Objects.equals(name, dragon.name) && Objects.equals(coordinates, dragon.coordinates) && Objects.equals(creationDate, dragon.creationDate) && Objects.equals(age, dragon.age) && color == dragon.color && type == dragon.type && character == dragon.character && Objects.equals(head, dragon.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, age, color, type, character, head);
    }
}
