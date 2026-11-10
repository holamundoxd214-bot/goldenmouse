package androidx.core.util;

import java.util.Objects;

public class ObjectsCompat {
    private ObjectsCompat() {
        super();
    }

    public static boolean equals(Object arg0, Object arg1) {
        return Objects.equals(arg0, arg1);
    }

    public static int hash(Object[] arg0) {
        return Objects.hash(arg0);
    }

    public static int hashCode(Object arg0) {
        if(arg0 != null) {
            return arg0.hashCode();
        }

        return 0;
    }

    public static Object requireNonNull(Object arg0) {
        arg0.getClass();
        return arg0;
    }

    public static Object requireNonNull(Object arg0, String arg1) {
        if(arg0 != null) {
            return arg0;
        }

        throw new NullPointerException(arg1);
    }

    public static String toString(Object arg0, String arg1) {
        if(arg0 != null) {
            return arg0.toString();
        }

        return arg1;
    }
}

