package se.su.dsv.inte.character;

public enum Race {
    HOBBIT ("Hobbit", 5, 20, 2, 4),
    DWARF ("Dwarf", 3, 30, 5, 3);

    Race(String name, int baseMovementSpeed, int baseHitPoints, int baseAttackPoints, int baseDefensePoints) {
        this.name = name;
        this.baseMovementSpeed = baseMovementSpeed;
        this.baseHitPoints = baseHitPoints;
        this.baseAttackPoints = baseAttackPoints;
        this.baseDefensePoints = baseDefensePoints;
    }

    private String name;
    private int baseMovementSpeed;
    private int baseHitPoints;
    private int baseAttackPoints;
    private int baseDefensePoints;

    public String getName() {
        return name;
    }

    public int getBaseMovementSpeed() {
        return baseMovementSpeed;
    }

    public int getBaseHitPoints() {
        return baseHitPoints;
    }

    public int getBaseAttackPoints() {
        return baseAttackPoints;
    }

    public int getBaseDefensePoints() {
        return baseDefensePoints;
    }

}
