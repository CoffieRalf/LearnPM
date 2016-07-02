package vl09.reflection;

/**
 * @author Carsten Gips
 * @since 27.02.2016
 *
 * basierend auf einer Idee nach http://docs.oracle.com/javase/tutorial/reflect/index.html
 *
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionDemo {

    private static void showFields(Class<?> c) {
        Field[] allFields = c.getDeclaredFields();

        for (Field f : allFields) {
            System.out.println(f.toGenericString());
            System.out.println("  Modifiers:  " + Modifier.toString(f.getModifiers()));
        }
        System.out.println();
    }

    private static void showMethods(Class<?> c) {
        Method[] allMethods = c.getDeclaredMethods();

        for (Method m : allMethods) {
            System.out.println(m.toGenericString());
            System.out.println("  Modifiers:  " + Modifier.toString(m.getModifiers()));
        }
        System.out.println();
    }

    private static void showConstructors(Class<?> c) {
        Constructor<?>[] allCtors = c.getDeclaredConstructors();

        for (Constructor<?> ctor : allCtors) {
            System.out.println(ctor.toGenericString());
            System.out.println("  Modifiers:  " + Modifier.toString(ctor.getModifiers()));
        }
        System.out.println();
    }

    private static Studi createStudiByClass(Class<?> c) {
        Studi s = null;

        try {
            s = (Studi) c.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return s;
    }

    private static Studi createStudiByConstructor(Class<?> c) {
        Studi s = null;
        Constructor<?> ctor = null;

        try {
            ctor = c.getConstructor();
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        }

        try {
            s = (Studi) ctor.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        }
        return s;
    }

    private static Studi createStudiByParamConstructor(Class<?> c) {
        Studi s = null;
        Constructor<?> ctor = null;

        Class<?>[] paramTypes = new Class<?>[] { String.class, int.class };
        try {
            ctor = c.getDeclaredConstructor(paramTypes);
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        }

        try {
            s = (Studi) ctor.newInstance("Beate", 42);
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        }
        return s;
    }

    private static void callSetName(Class<?> c, Studi s) {
        String methodName = "setName";
        Class<?>[] paramTypes = new Class<?>[] { String.class };
        Method method = null;

        try {
            method = c.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
        } catch (SecurityException e) {
        }

        try {
            method.invoke(s, "Holgi");
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        }
        System.out.println("studi: " + s);
    }

    private static void callGetCredits(Class<?> c, Studi s) {
        String methodName = "getCredits";
        Class<?>[] paramTypes = new Class<?>[0];
        Method method = null;

        try {
            method = c.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e1) {
        } catch (SecurityException e1) {
        }

        method.setAccessible(true);
        int result = 0;
        try {
            result = (Integer) method.invoke(s);
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e) {
        } catch (InvocationTargetException e) {
        }
        System.out.println("getCredits() via Reflection: " + result);
    }

    public static void main(String[] argv) {
        Class<?> c = null;
        try {
            c = Class.forName("vl09.reflection.Studi");
        } catch (ClassNotFoundException e) {
            // Hier fehlt eine Fehlerbehandlung für den Fall, dass die Klasse
            // nicht gefunden wurde!
        }

        showConstructors(c);
        showMethods(c);
        showFields(c);

        Studi s1, s2, s3;
        s1 = createStudiByClass(c);
        s2 = createStudiByConstructor(c);
        s3 = createStudiByParamConstructor(c);

        System.out.println("\ndirekte Methodenaufrufe");
        s1.setName("Herbert");
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        System.out.println("s3: " + s3);

        System.out.println("\nindirekte Methodenaufrufe (Reflection)");
        callSetName(c, s2);
        callGetCredits(c, s3);
    }

}
