package vl07;

/**
 * @author Carsten Gips
 * @version 25.02.2016
 *
 */

enum FachV1 {
    IFM, ELM, ARC, PHY
}

public class StudiV2 {

    public StudiV2(String name, int credits, FachV1 studiengang) {
        // Typsicherheit fuer studiengang
    }

    public void revealEnumEigenschaften() {
        // Referenzen auf Enum-Objekte koennen null sein
        FachV1 f = null;
        f = FachV1.IFM;

        // Vergleich mit ==
        // equals() unnoetig, da Vergleich mit Referenz auf statische Variable
        if (f == FachV1.IFM) {
            System.out.println("Richtiges Fach :-)");
        }

        // switch/case
        switch (f) {
        case IFM: // Achtung: *NICHT* StudiengangSimple.IFM
            System.out.println("Richtiges Fach :-)");
            break;
        default:
            throw new IllegalArgumentException("FALSCHES FACH: " + f);
        }
    }

    public static void main(String[] args) {
        StudiV2 rainer = new StudiV2("Rainer", 10, FachV1.IFM);
        // StudiV2 holger = new StudiV2("Holger", 3, 4); // Syntax-Fehler

        for (FachV1 m : FachV1.values()) {
            System.out.printf("Element: %s%n", m);
        }
    }
}
