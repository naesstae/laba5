import java.time.LocalDate;
public class Dragon {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private Color color; //Поле не может быть null
    private DragonType type; //Поле может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonHead head;
    public Dragon(String name, Coordinates coordinates, long age, Color color, DragonType type, DragonCharacter character, DragonHead head){
        creationDate = LocalDate.now();
        this.name=name;
        this.age=age;
        this.coordinates=coordinates;
        this.character=character;
        this.head=head;
        this.type=type;
        this.color=color;
    }
}