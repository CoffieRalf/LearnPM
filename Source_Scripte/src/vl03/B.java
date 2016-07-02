/**
 * Package für Code-Snippets in VL03
 */
package vl03;

import java.util.Date;

/**
 * Summary für Klasse B
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 * Wozu, warum, wieso :)
 *
 * @author Carsten Gips
 * @version 24.02.2016
 *
 */
public class B extends A {

    /**
     * Methode überschreibt {@link A#getInfo()} Erweitert Parameter-String mit
     * Zeichenkette "Klasse B" ... Es folgt die ausführliche Beschreibung, die
     * später im Abschnitt "Method Detail" erscheint, aber nicht in der
     * Übersicht.
     *
     * @see A#getInfo()
     * @param s
     *            String, der verarbeitet werden soll
     * @return neuer String
     */
    // @Override
    public String getInfo(String s) {
        return s + "Klasse B";
    }

    /**
     * Kleines Testprogramm zur Demonstration von Annotationen
     *
     * @param args
     *            CLI-Parameter für main()
     */
    public static void main(String[] args) {
        B s = new B();

        System.out.println(s.getInfo());
        System.out.println(s.getInfo("Info: "));

        Date d; // Dummy zum schnellen Oeffnen von java.util.Date ... :)
    }

}
