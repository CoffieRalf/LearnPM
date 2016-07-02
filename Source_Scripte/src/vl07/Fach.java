package vl07;

/**
 * @author Carsten Gips
 * @version 25.02.2016
 *
 */

public enum Fach {
    IFM, ELM("Elektrotechnik Praxisintegriert", 1, 30), ARC("Architektur", 4, 40), PHY("Physik", 3, 10);

    private final String description;
    private final int number;
    private final int capacity;

    private Fach() {
        this("Informatik Bachelor", 0, 60);
        System.out.println("Basiskonstruktor");
    }

    private Fach(String descr, int number, int capacity) {
        this.description = descr;
        this.number = number;
        this.capacity = capacity;
        System.out.println("Erweiterter Konstruktur: " + descr);
    }

    public String getBeschreibung() {
        return "Konstante: " + name() + " (Beschreibung: " + description + ", Kapazitaet: " + capacity + ", Nummer: "
                + number + ", Ordinal: " + ordinal() + ")";
    }

    @Override
    public String toString() {
        return "toString-Methode von " + name();
    }
}
