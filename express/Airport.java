package express;

public enum Airport {
    
    MOB("Mobile, Alabama"), ANC("Anchoraga, Alaska"), PHX("Phoenix, Arizona"), LIT("Little Rock, Arkansas"),
    LAX("Los Angelex, California"), SAN("San Diego, California"), DEN("Denver, Colorado");

    private String name;

    private Airport(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
