package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;

    public TypefaceCompatApi28Impl() {
        super();
    }

    protected Typeface createFromFamiliesWithDefault(Object arg4) {
        try {
            Object v0 = Array.newInstance(this.mFontFamily, 1);
            Array.set(v0, 0, arg4);
            return this.mCreateFromFamiliesWithDefault.invoke(null, v0, "sans-serif", Integer.valueOf(-1), Integer.valueOf(-1));
        }
        catch(InvocationTargetException v3) {
            throw new RuntimeException(((Throwable)v3));
        }
    }

    Typeface createWeightStyle(Context arg1, Typeface arg2, int arg3, boolean arg4) {
        return Typeface.create(arg2, arg3, arg4);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class arg4) throws NoSuchMethodException {
        Method v4 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(arg4, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE);
        v4.setAccessible(true);
        return v4;
    }
}

