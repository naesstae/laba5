package allForDragons;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

import java.util.Date;
public class Dragon implements Comparable<Dragon>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    private Color color; //Поле может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonHead head;
    public Dragon(String name, Coordinates coordinates, Long age, Color color, DragonType type, DragonCharacter character, DragonHead head){
        creationDate = new Date();
        UUID myuuid = UUID.randomUUID();
        id = myuuid.getMostSignificantBits();
        while (id < 0) {
            myuuid = UUID.randomUUID();
            id = myuuid.getMostSignificantBits();
        }
        this.name = name;
        this.age = age;
        this.coordinates = coordinates;
        this.character = character;
        this.head = head;
        this.type = type;
        this.color = color;
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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Long getAge() {
        return age;
    }

    public Color getColor() {
        return color;
    }

    public DragonType getType() {
        return type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public DragonHead getHead() {
        return head;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public void setHead(DragonHead head) {
        this.head = head;
    }

    @Override
    public int compareTo(Dragon o) {
        return (int)(this.age-o.getAge());
    }
}