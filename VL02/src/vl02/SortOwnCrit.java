package vl02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Carsten Gips
 * @version 05.04.2016
 *
 */
public class SortOwnCrit {
    public static void main(String[] args) {
        List<Studi> list = new ArrayList<Studi>();

        list.add(new Studi("Klaas"));
        list.add(new Studi("Hein"));
        list.add(new Studi("Pit"));

        // Sortieren der Liste (eigene Reihenfolge)?!
        Comparator<Studi> c = new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return 0; // hier Kriterium fuer eigene Ordnung definieren
            }
        };

        list.sort(c);
        Collections.sort(list, c);
    }
}
