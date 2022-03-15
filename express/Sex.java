package express;

/**
 * Sex enum
 * @author rleboeu
 * @version 1.0.0
 */
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