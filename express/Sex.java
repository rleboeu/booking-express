package express;

public enum Sex {
    MALE("M"), FEMALE("F");

    private String name;

    private Sex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}