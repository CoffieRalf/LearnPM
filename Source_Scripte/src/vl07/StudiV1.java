package vl07;

/**
 * @author Carsten Gips
 * @version 25.02.2016
 *
 */

public class StudiV1 {
    public static final int IFM = 0;
    public static final int ELM = 1;
    public static final int ARC = 2;
    public static final int PHY = 3;

    public StudiV1(String name, int credits, int studiengang) {
        // Wert fuer studiengang muss zwischen 0 und 3 liegen
        // Erwuenscht: Konstanten nutzen
    }

    public static void main(String[] args) {
        StudiV1 rainer = new StudiV1("Rainer", 10, StudiV1.IFM);
        StudiV1 holger = new StudiV1("Holger", 3, 4); // Laufzeit-Problem
    }
}
