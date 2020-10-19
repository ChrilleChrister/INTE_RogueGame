package se.su.dsv.inte;

public enum Race {
    HOBBIT ("Hobbit", 5, new Stats(20, 2, 4)),
    DWARF ("Dwarf", 3, new Stats(30, 5, 3));

    Race(String name, int baseMovementSpeed, Stats defaultStats) {
        this.name = name;
        this.baseMovementSpeed = baseMovementSpeed;
        this.defaultStats = defaultStats;
    }

    private String name;
    private int baseMovementSpeed;
    private Stats defaultStats;

    public String getName() {
        return name;
    }

    public int getBaseMovementSpeed() {
        return baseMovementSpeed;
    }

    public Stats getDefaultStats() {
        return defaultStats;
    }
}
