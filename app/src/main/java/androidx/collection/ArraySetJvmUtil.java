package androidx.collection;

import java.lang.reflect.Array;

class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
        super();
    }

    static Object[] resizeForToArray(Object[] arg1, int arg2) {
        if(arg1.length < arg2) {
            return Array.newInstance(arg1.getClass().getComponentType(), arg2);
        }

        if(arg1.length > arg2) {
            arg1[arg2] = null;
        }

        return arg1;
    }
}

