package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class sFontFamily = null;
    private static Constructor sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    static {
    }

    TypefaceCompatApi21Impl() {
        super();
    }

    private static boolean addFontWeightStyle(Object arg1, String arg2, int arg3, boolean arg4) {
        TypefaceCompatApi21Impl.init();
        try {
            return TypefaceCompatApi21Impl.sAddFontWeightStyle.invoke(arg1, arg2, Integer.valueOf(arg3), Boolean.valueOf(arg4)).booleanValue();
        }
        catch(InvocationTargetException v1) {
            throw new RuntimeException(((Throwable)v1));
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object arg2) {
        TypefaceCompatApi21Impl.init();
        try {
            Object v0 = Array.newInstance(TypefaceCompatApi21Impl.sFontFamily, 1);
            Array.set(v0, 0, arg2);
            return TypefaceCompatApi21Impl.sCreateFromFamiliesWithDefault.invoke(null, v0);
        }
        catch(InvocationTargetException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context arg7, FontFamilyFilesResourceEntry arg8, Resources arg9, int arg10) {
        Object v6 = TypefaceCompatApi21Impl.newFamily();
        FontFileResourceEntry[] v8 = arg8.getEntries();
        arg10 = v8.length;
        int v0;
        for(v0 = 0; v0 < arg10; ++v0) {
            FontFileResourceEntry v1 = v8[v0];
            File v2 = TypefaceCompatUtil.getTempFile(arg7);
            Typeface v3 = null;
            if(v2 == null) {
                return v3;
            }

            try {
                if(TypefaceCompatUtil.copyToFile(v2, arg9, v1.getResourceId())) {
                    goto label_15;
                }
            }
            catch(Throwable v6_1) {
                goto label_26;
            }
            catch(RuntimeException ) {
                goto label_28;
            }

            v2.delete();
            return v3;
            try {
            label_15:
                if(TypefaceCompatApi21Impl.addFontWeightStyle(v6, v2.getPath(), v1.getWeight(), v1.isItalic())) {
                    goto label_22;
                }
            }
            catch(Throwable v6_1) {
            label_26:
                v2.delete();
                throw v6_1;
            }
            catch(RuntimeException ) {
            label_28:
                v2.delete();
                return v3;
            }

            v2.delete();
            return v3;
        label_22:
            v2.delete();
        }

        return TypefaceCompatApi21Impl.createFromFamiliesWithDefault(v6);
    }

    public Typeface createFromFontInfo(Context arg4, CancellationSignal arg5, FontInfo[] arg6, int arg7) {
        Typeface v3_1;
        FileInputStream v6_2;
        ParcelFileDescriptor v5;
        Typeface v2 = null;
        if(arg6.length < 1) {
            return v2;
        }

        FontInfo v6 = this.findBestInfo(arg6, arg7);
        ContentResolver v7 = arg4.getContentResolver();
        try {
            v5 = v7.openFileDescriptor(v6.getUri(), "r", arg5);
            if(v5 != null) {
                goto label_14;
            }

            if(v5 != null) {
                v5.close();
            }
        }
        catch(IOException ) {
            return v2;
        }

        return v2;
        try {
        label_14:
            File v6_1 = this.getFile(v5);
            if(v6_1 == null || !v6_1.canRead()) {
                v6_2 = new FileInputStream(v5.getFileDescriptor());
            }
            else {
                v3_1 = Typeface.createFromFile(v6_1);
                if(v5 == null) {
                    return v3_1;
                }

                goto label_21;
            }
        }
        catch(Throwable v3) {
            goto label_38;
        }

        try {
            v3_1 = super.createFromInputStream(arg4, ((InputStream)v6_2));
            goto label_27;
        }
        catch(Throwable v3) {
            try {
                v6_2.close();
                goto label_36;
            }
            catch(Throwable v4) {
                try {
                    v3.addSuppressed(v4);
                label_36:
                    throw v3;
                label_27:
                    v6_2.close();
                    if(v5 == null) {
                        return v3_1;
                    }
                }
                catch(Throwable v3) {
                label_38:
                    if(v5 != null) {
                        try {
                            v5.close();
                            goto label_43;
                        }
                        catch(Throwable v4) {
                            try {
                                v3.addSuppressed(v4);
                            label_43:
                                throw v3;
                            }
                            catch(IOException ) {
                                return v2;
                            }
                        }
                    }
                    else {
                        goto label_43;
                    }

                    return v3_1;
                }
            }
        }

        try {
        label_21:
            v5.close();
        }
        catch(IOException ) {
            return v2;
        }

        return v3_1;
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

    private File getFile(ParcelFileDescriptor arg3) {
        String v2 = "/proc/self/fd/";
        File v0 = null;
        try {
            v2 = Os.readlink(v2 + arg3.getFd());
            if(!OsConstants.S_ISREG(Os.stat(v2).st_mode)) {
                return v0;
            }

            return new File(v2);
        }
        catch(ErrnoException ) {
            return v0;
        }
    }

    private static void init() {
        Method v0_1;
        Method v4;
        Constructor v3;
        Class v1;
        if(TypefaceCompatApi21Impl.sHasInitBeenCalled) {
            return;
        }

        TypefaceCompatApi21Impl.sHasInitBeenCalled = true;
        try {
            v1 = Class.forName("android.graphics.FontFamily");
            v3 = v1.getConstructor();
            v4 = v1.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            v0_1 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(v1, 1).getClass());
        }
        catch(NoSuchMethodException v0) {
            Log.e("TypefaceCompatApi21Impl", v0.getClass().getName(), ((Throwable)v0));
            v1 = null;
            v0_1 = ((Method)v1);
            v3 = ((Constructor)v0_1);
            v4 = ((Method)v3);
        }

        TypefaceCompatApi21Impl.sFontFamilyCtor = v3;
        TypefaceCompatApi21Impl.sFontFamily = v1;
        TypefaceCompatApi21Impl.sAddFontWeightStyle = v4;
        TypefaceCompatApi21Impl.sCreateFromFamiliesWithDefault = v0_1;
    }

    private static Object newFamily() {
        TypefaceCompatApi21Impl.init();
        try {
            return TypefaceCompatApi21Impl.sFontFamilyCtor.newInstance();
        }
        catch(InvocationTargetException v0) {
            throw new RuntimeException(((Throwable)v0));
        }
    }
}

