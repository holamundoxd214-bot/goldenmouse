package androidx.core.util;

public class DebugUtils {
    private DebugUtils() {
        super();
    }

    public static void buildShortClassTag(Object arg2, StringBuilder arg3) {
        if(arg2 == null) {
            arg3.append("null");
            return;
        }

        String v0 = arg2.getClass().getSimpleName();
        if(v0 == null || v0.length() <= 0) {
            v0 = arg2.getClass().getName();
            int v1 = v0.lastIndexOf(46);
            if(v1 > 0) {
                v0 = v0.substring(v1 + 1);
            }
        }

        arg3.append(v0);
        arg3.append('{');
        arg3.append(Integer.toHexString(System.identityHashCode(arg2)));
    }
}

