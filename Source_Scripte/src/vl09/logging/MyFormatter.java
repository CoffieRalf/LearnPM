package vl09.logging;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 */
class MyFormatter extends SimpleFormatter {
    private String name;

    public MyFormatter(String n) {
        name = n;
    }

    @Override
    public String format(LogRecord record) {
        return "---- " + name + " ::" + record.getMessage() + ":: " + name + " ----\n";
    }
}
