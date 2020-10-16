package se.su.dsv.inte;

public enum Race {
    HOBBIT ("Hobbit"),
    DWARF ("Dwarf");

    Race(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
