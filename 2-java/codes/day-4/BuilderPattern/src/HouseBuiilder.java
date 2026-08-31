import java.util.List;

public class HouseBuiilder {
    private final House house;

    public HouseBuiilder() {
        Window[] windows = new Window[]{new Window(), new Window()};
        Door[] doors = new Door[]{new Door(), new Door()};
        Room[] rooms = new Room[]{new Room(windows, doors)};
        this.house = new House(roof, rooms, windows);
    }

    public HouseBuiilder AddGarden() {
        this.house.setGarden(new Garden());
        return this;
    }

    public HouseBuiilder AddPool() {
        this.house.setPool(new Pool());
        return this;
    }

    public HouseBuiilder AddBalcony() {
        this.house.setBalcony(new Balcony());
        return this;
    }

    public House Build() {
        return house;
    }
}
