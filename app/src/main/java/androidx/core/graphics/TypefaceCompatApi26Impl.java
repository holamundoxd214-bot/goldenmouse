package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface$Builder;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method v6;
        Method v5;
        Method v4;
        Method v3;
        Method v2;
        Constructor v1;
        Class v0_2;
        super();
        try {
            v0_2 = this.obtainFontFamily();
            v1 = this.obtainFontFamilyCtor(v0_2);
            v2 = this.obtainAddFontFromAssetManagerMethod(v0_2);
            v3 = this.obtainAddFontFromBufferMethod(v0_2);
            v4 = this.obtainFreezeMethod(v0_2);
            v5 = this.obtainAbortCreationMethod(v0_2);
            v6 = this.obtainCreateFromFamiliesWithDefaultMethod(v0_2);
            goto label_28;
        }
        catch(NoSuchMethodException v0) {
        }
        catch(ClassNotFoundException v0_1) {
        }

        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + v0_1.getClass().getName(), ((Throwable)v0_1));
        v0_2 = null;
        v1 = ((Constructor)v0_2);
        v2 = ((Method)v1);
        v3 = v2;
        v4 = v3;
        v5 = v4;
        v6 = v5;
    label_28:
        this.mFontFamily = v0_2;
        this.mFontFamilyCtor = v1;
        this.mAddFontFromAssetManager = v2;
        this.mAddFontFromBuffer = v3;
        this.mFreeze = v4;
        this.mAbortCreation = v5;
        this.mCreateFromFamiliesWithDefault = v6;
    }

    private void abortCreation(Object arg2) {
        try {
            this.mAbortCreation.invoke(arg2);
            return;
        }
        catch(InvocationTargetException ) {
            return;
        }
    }

    private boolean addFontFromAssetManager(Context arg10, Object arg11, String arg12, int arg13, int arg14, int arg15, FontVariationAxis[] arg16) {
        try {
            return this.mAddFontFromAssetManager.invoke(arg11, arg10.getAssets(), arg12, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(arg13), Integer.valueOf(arg14), Integer.valueOf(arg15), arg16).booleanValue();
        }
        catch(InvocationTargetException ) {
            return 0;
        }
    }

    private boolean addFontFromBuffer(Object arg2, ByteBuffer arg3, int arg4, int arg5, int arg6) {
        try {
            return this.mAddFontFromBuffer.invoke(arg2, arg3, Integer.valueOf(arg4), null, Integer.valueOf(arg5), Integer.valueOf(arg6)).booleanValue();
        }
        catch(InvocationTargetException ) {
            return 0;
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object arg4) {
        Object v0 = null;
        try {
            Object v1 = Array.newInstance(this.mFontFamily, 1);
            Array.set(v1, 0, arg4);
            return this.mCreateFromFamiliesWithDefault.invoke(v0, v1, Integer.valueOf(-1), Integer.valueOf(-1));
        }
        catch(InvocationTargetException ) {
            return ((Typeface)v0);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context arg10, FontFamilyFilesResourceEntry arg11, Resources arg12, int arg13) {
        TypefaceCompatApi26Impl v0_1;
        if(!this.isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(arg10, arg11, arg12, arg13);
        }

        Object v2 = this.newFamily();
        Typeface v12 = null;
        if(v2 == null) {
            return v12;
        }

        FontFileResourceEntry[] v11 = arg11.getEntries();
        arg13 = v11.length;
        int v8 = 0;
        while(v8 < arg13) {
            FontFileResourceEntry v0 = v11[v8];
            String v3 = v0.getFileName();
            int v4 = v0.getTtcIndex();
            int v5 = v0.getWeight();
            boolean v6 = v0.isItalic();
            FontVariationAxis[] v7 = FontVariationAxis.fromFontVariationSettings(v0.getVariationSettings());
            v0_1 = this;
            Context v1 = arg10;
            if(!v0_1.addFontFromAssetManager(v1, v2, v3, v4, v5, ((int)v6), v7)) {
                v0_1.abortCreation(v2);
                return v12;
            }

            ++v8;
            this = v0_1;
            arg10 = v1;
        }

        v0_1 = this;
        if(!v0_1.freeze(v2)) {
            return v12;
        }

        return v0_1.createFromFamiliesWithDefault(v2);
    }

    public Typeface createFromFontInfo(Context arg10, CancellationSignal arg11, FontInfo[] arg12, int arg13) {
        TypefaceCompatApi26Impl v4_1;
        Object v5_1;
        Typeface v9_1;
        ParcelFileDescriptor v10_1;
        Typeface v1 = null;
        if(arg12.length < 1) {
            return v1;
        }

        if(this.isFontFamilyPrivateAPIAvailable()) {
            goto label_37;
        }

        FontInfo v9 = this.findBestInfo(arg12, arg13);
        ContentResolver v10 = arg10.getContentResolver();
        try {
            v10_1 = v10.openFileDescriptor(v9.getUri(), "r", arg11);
            if(v10_1 != null) {
                goto label_16;
            }

            if(v10_1 != null) {
                v10_1.close();
            }
        }
        catch(IOException ) {
            return v1;
        }

        return v1;
        try {
        label_16:
            v9_1 = new Typeface$Builder(v10_1.getFileDescriptor()).setWeight(v9.getWeight()).setItalic(v9.isItalic()).build();
            if(v10_1 == null) {
                return v9_1;
            }

            goto label_25;
        }
        catch(Throwable v0) {
            Throwable v9_2 = v0;
            if(v10_1 != null) {
                try {
                    v10_1.close();
                    goto label_35;
                }
                catch(Throwable v0) {
                    Throwable v10_2 = v0;
                    try {
                        v9_2.addSuppressed(v10_2);
                    label_35:
                        throw v9_2;
                    label_25:
                        v10_1.close();
                    }
                    catch(IOException ) {
                        return v1;
                    }
                }
            }
            else {
                goto label_35;
            }
        }

        return v9_1;
    label_37:
        Map v10_3 = TypefaceCompatUtil.readFontInfoIntoByteBuffer(arg10, arg12, arg11);
        Object v4 = this.newFamily();
        if(v4 == null) {
            return v1;
        }

        int v11 = arg12.length;
        int v0_1 = 0;
        int v3 = 0;
        while(v0_1 < v11) {
            FontInfo v5 = arg12[v0_1];
            Object v6 = v10_3.get(v5.getUri());
            if(v6 == null) {
                v5_1 = v4;
                v4_1 = this;
            }
            else {
                FontInfo v3_1 = v5;
                v5_1 = v6;
                int v6_1 = v3_1.getTtcIndex();
                int v7 = v3_1.getWeight();
                boolean v8 = v3_1.isItalic();
                TypefaceCompatApi26Impl v3_2 = this;
                boolean v9_3 = v3_2.addFontFromBuffer(v4, ((ByteBuffer)v5_1), v6_1, v7, ((int)v8));
                v5_1 = v4;
                v4_1 = v3_2;
                if(!v9_3) {
                    v4_1.abortCreation(v5_1);
                    return v1;
                }
                else {
                    v3 = 1;
                }
            }

            ++v0_1;
            this = v4_1;
            v4 = v5_1;
        }

        v5_1 = v4;
        v4_1 = this;
        if(v3 == 0) {
            v4_1.abortCreation(v5_1);
            return v1;
        }

        if(!v4_1.freeze(v5_1)) {
            return v1;
        }

        v9_1 = v4_1.createFromFamiliesWithDefault(v5_1);
        if(v9_1 == null) {
            return v1;
        }

        return Typeface.create(v9_1, arg13);
    }

    public Typeface createFromFontInfoWithFallback(Context arg1, CancellationSignal arg2, List arg3, int arg4) {
        return super.createFromFontInfoWithFallback(arg1, arg2, arg3, arg4);
    }

    public Typeface createFromResourcesFontFile(Context arg10, Resources arg11, int arg12, String arg13, int arg14) {
        if(!this.isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(arg10, arg11, arg12, arg13, arg14);
        }

        Object v3 = this.newFamily();
        Typeface v11 = null;
        if(v3 == null) {
            return v11;
        }

        TypefaceCompatApi26Impl v1 = this;
        if(!v1.addFontFromAssetManager(arg10, v3, arg13, 0, -1, -1, null)) {
            v1.abortCreation(v3);
            return v11;
        }

        if(!v1.freeze(v3)) {
            return v11;
        }

        return v1.createFromFamiliesWithDefault(v3);
    }

    Typeface createWeightStyle(Context arg2, Typeface arg3, int arg4, boolean arg5) {
        Typeface v0;
        try {
            v0 = WeightTypefaceApi26.createWeightStyle(arg3, arg4, arg5);
        }
        catch(RuntimeException ) {
            v0 = null;
        }

        if(v0 == null) {
            v0 = super.createWeightStyle(arg2, arg3, arg4, arg5);
        }

        return v0;
    }

    private boolean freeze(Object arg3) {
        try {
            return this.mFreeze.invoke(arg3).booleanValue();
        }
        catch(InvocationTargetException ) {
            return 0;
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if(this.mAddFontFromAssetManager == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }

        if(this.mAddFontFromAssetManager != null) {
            return 1;
        }

        return 0;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance();
        }
        catch(InvocationTargetException ) {
            return null;
        }
    }

    protected Method obtainAbortCreationMethod(Class arg2) throws NoSuchMethodException {
        return arg2.getMethod("abortCreation");
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class arg3) throws NoSuchMethodException {
        return arg3.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    protected Method obtainAddFontFromBufferMethod(Class arg3) throws NoSuchMethodException {
        return arg3.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class arg4) throws NoSuchMethodException {
        Method v4 = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(arg4, 1).getClass(), Integer.TYPE, Integer.TYPE);
        v4.setAccessible(true);
        return v4;
    }

    protected Class obtainFontFamily() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor obtainFontFamilyCtor(Class arg1) throws NoSuchMethodException {
        return arg1.getConstructor();
    }

    protected Method obtainFreezeMethod(Class arg2) throws NoSuchMethodException {
        return arg2.getMethod("freeze");
    }
}

