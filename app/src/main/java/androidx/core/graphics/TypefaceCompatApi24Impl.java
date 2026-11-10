package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;

    static {
        Method v1;
        Method v3;
        Constructor v2;
        Class v0_1;
        try {
            v0_1 = Class.forName("android.graphics.FontFamily");
            v2 = v0_1.getConstructor();
            v3 = v0_1.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            v1 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(v0_1, 1).getClass());
        }
        catch(NoSuchMethodException v0) {
            Log.e("TypefaceCompatApi24Impl", v0.getClass().getName(), ((Throwable)v0));
            v0_1 = null;
            v1 = ((Method)v0_1);
            v2 = ((Constructor)v1);
            v3 = ((Method)v2);
        }

        TypefaceCompatApi24Impl.sFontFamilyCtor = v2;
        TypefaceCompatApi24Impl.sFontFamily = v0_1;
        TypefaceCompatApi24Impl.sAddFontWeightStyle = v3;
        TypefaceCompatApi24Impl.sCreateFromFamiliesWithDefault = v1;
    }

    TypefaceCompatApi24Impl() {
        super();
    }

    private static boolean addFontWeightStyle(Object arg2, ByteBuffer arg3, int arg4, int arg5, boolean arg6) {
        try {
            return TypefaceCompatApi24Impl.sAddFontWeightStyle.invoke(arg2, arg3, Integer.valueOf(arg4), null, Integer.valueOf(arg5), Boolean.valueOf(arg6)).booleanValue();
        }
        catch(InvocationTargetException ) {
            return 0;
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object arg3) {
        Object v0 = null;
        try {
            Object v1 = Array.newInstance(TypefaceCompatApi24Impl.sFontFamily, 1);
            Array.set(v1, 0, arg3);
            return TypefaceCompatApi24Impl.sCreateFromFamiliesWithDefault.invoke(v0, v1);
        }
        catch(InvocationTargetException ) {
            return ((Typeface)v0);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context arg7, FontFamilyFilesResourceEntry arg8, Resources arg9, int arg10) {
        Object v6 = TypefaceCompatApi24Impl.newFamily();
        Typeface v10 = null;
        if(v6 == null) {
            return v10;
        }

        FontFileResourceEntry[] v8 = arg8.getEntries();
        int v0 = v8.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            FontFileResourceEntry v2 = v8[v1];
            ByteBuffer v3 = TypefaceCompatUtil.copyToDirectBuffer(arg7, arg9, v2.getResourceId());
            if(v3 == null) {
                return v10;
            }

            if(!TypefaceCompatApi24Impl.addFontWeightStyle(v6, v3, v2.getTtcIndex(), v2.getWeight(), v2.isItalic())) {
                return v10;
            }
        }

        return TypefaceCompatApi24Impl.createFromFamiliesWithDefault(v6);
    }

    public Typeface createFromFontInfo(Context arg9, CancellationSignal arg10, FontInfo[] arg11, int arg12) {
        Object v8 = TypefaceCompatApi24Impl.newFamily();
        Typeface v0 = null;
        if(v8 == null) {
            return v0;
        }

        SimpleArrayMap v1 = new SimpleArrayMap();
        int v2 = arg11.length;
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            FontInfo v4 = arg11[v3];
            Uri v5 = v4.getUri();
            Object v6 = v1.get(v5);
            if(v6 == null) {
                ByteBuffer v6_1 = TypefaceCompatUtil.mmap(arg9, arg10, v5);
                v1.put(v5, v6_1);
            }

            if(v6_1 == null) {
                return v0;
            }

            if(!TypefaceCompatApi24Impl.addFontWeightStyle(v8, v6_1, v4.getTtcIndex(), v4.getWeight(), v4.isItalic())) {
                return v0;
            }
        }

        Typeface v8_1 = TypefaceCompatApi24Impl.createFromFamiliesWithDefault(v8);
        if(v8_1 == null) {
            return v0;
        }

        return Typeface.create(v8_1, arg12);
    }

    Typeface createWeightStyle(Context arg2, Typeface arg3, int arg4, boolean arg5) {
        Typeface v0;
        try {
            v0 = WeightTypefaceApi21.createWeightStyle(arg3, arg4, arg5);
        }
        catch(RuntimeException ) {
            v0 = null;
        }

        if(v0 == null) {
            v0 = super.createWeightStyle(arg2, arg3, arg4, arg5);
        }

        return v0;
    }

    public static boolean isUsable() {
        Method v0 = TypefaceCompatApi24Impl.sAddFontWeightStyle;
        if(v0 == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }

        if(v0 != null) {
            return 1;
        }

        return 0;
    }

    private static Object newFamily() {
        try {
            return TypefaceCompatApi24Impl.sFontFamilyCtor.newInstance();
        }
        catch(InvocationTargetException ) {
            return null;
        }
    }
}

