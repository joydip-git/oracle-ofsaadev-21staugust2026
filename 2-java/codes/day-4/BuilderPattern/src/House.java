public class House {
    private Roof roof;
    private Room[] rooms;
    private Garden garden;
    private Pool pool;
    private Balcony balcony;

    public House(Roof roof, Room[] rooms, Garden garden, Pool pool, Balcony balcony) {
        this.roof = roof;
        this.rooms = rooms;
        this.garden = garden;
        this.pool = pool;
        this.balcony = balcony;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    public Balcony getBalcony() {
        return balcony;
    }

    public void setBalcony(Balcony balcony) {
        this.balcony = balcony;
    }
}
