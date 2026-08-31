public class Room {
    private Window[] windows;
    private Door[] doors;

    public Room(Window[] windows, Door[] doors) {
        this.windows = windows;
        this.doors = doors;
    }

    public Window[] getWindows() {
        return windows;
    }

    public void setWindows(Window[] windows) {
        this.windows = windows;
    }

    public Door[] getDoors() {
        return doors;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }
}
