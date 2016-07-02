package vl09.reflection;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */

public class Studi {
    private String name;
    private int credits;

    public Studi() {
        this("", 0);
    }

    public Studi(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    private int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String toString() {
        return "'" + getName() + "' (" + getCredits() + ")";
    }

}
