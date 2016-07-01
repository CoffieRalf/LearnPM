package vl02;

/**
 * @author Carsten Gips
 * @version 24.02.2016
 *
 */

interface ITranslator {
    String translate(String s);
}

class DE implements ITranslator {
    @Override
    public String translate(String s) {
        // mach was mit `s` ...
        return s;
    }
}

class ES implements ITranslator {
    @Override
    public String translate(String s) {
        // mach was mit `s` ...
        return s;
    }
}

class StratEx {
    private ITranslator translator;

    StratEx(ITranslator t) {
        translator = t;
    }

    public String getMessage() {
        return translator.translate("hello world");
    }

    public static void main(String[] args) {
        StratEx j = new StratEx(new DE());
        j.getMessage();
    }
}
