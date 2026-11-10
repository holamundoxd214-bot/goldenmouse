package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class TypefaceCompatBaseImpl {
    interface StyleExtractor {
        int getWeight(Object arg1);

        boolean isItalic(Object arg1);
    }

    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap mFontFamilies;

    TypefaceCompatBaseImpl() {
        super();
        this.mFontFamilies = new ConcurrentHashMap();
    }

    private void addFontFamily(Typeface arg5, FontFamilyFilesResourceEntry arg6) {
        long v0 = TypefaceCompatBaseImpl.getUniqueKey(arg5);
        if(v0 != 0) {
            this.mFontFamilies.put(Long.valueOf(v0), arg6);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context arg7, FontFamilyFilesResourceEntry arg8, Resources arg9, int arg10) {
        FontFileResourceEntry v0 = this.findBestEntry(arg8, arg10);
        if(v0 == null) {
            return null;
        }

        Typeface v7 = TypefaceCompat.createFromResourcesFontFile(arg7, arg9, v0.getResourceId(), v0.getFileName(), 0, arg10);
        this.addFontFamily(v7, arg8);
        return v7;
    }

    Typeface createFromFontFamilyFilesResourceEntry(Context arg7, FontFamilyFilesResourceEntry arg8, Resources arg9, int arg10, boolean arg11) {
        FontFileResourceEntry v10 = this.findBestEntry(arg8, arg10, arg11);
        if(v10 == null) {
            return null;
        }

        Typeface v7 = TypefaceCompat.createFromResourcesFontFile(arg7, arg9, v10.getResourceId(), v10.getFileName(), 0, 0);
        this.addFontFamily(v7, arg8);
        return v7;
    }

    public Typeface createFromFontInfo(Context arg3, CancellationSignal arg4, FontInfo[] arg5, int arg6) {
        InputStream v1_1;
        Typeface v2_1;
        InputStream v4_1;
        Typeface v1 = null;
        if(arg5.length < 1) {
            return v1;
        }

        FontInfo v4 = this.findBestInfo(arg5, arg6);
        try {
            v4_1 = arg3.getContentResolver().openInputStream(v4.getUri());
        }
        catch(Throwable v2) {
            goto label_16;
        }
        catch(IOException ) {
            Closeable v4_2 = ((Closeable)v1);
            goto label_19;
        }

        try {
            v2_1 = this.createFromInputStream(arg3, v4_1);
            goto label_10;
        }
        catch(Throwable v2) {
            v1_1 = v4_1;
        }
        catch(IOException ) {
        label_19:
            TypefaceCompatUtil.closeQuietly(((Closeable)v4_1));
            return v1;
        }

    label_16:
        TypefaceCompatUtil.closeQuietly(((Closeable)v1_1));
        throw v2;
    label_10:
        TypefaceCompatUtil.closeQuietly(((Closeable)v4_1));
        return v2_1;
    }

    public Typeface createFromFontInfoWithFallback(Context arg1, CancellationSignal arg2, List arg3, int arg4) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    protected Typeface createFromInputStream(Context arg1, InputStream arg2) {
        File v0 = TypefaceCompatUtil.getTempFile(arg1);
        Typeface v1 = null;
        if(v0 == null) {
            return v1;
        }

        try {
            if(TypefaceCompatUtil.copyToFile(v0, arg2)) {
                goto label_8;
            }
        }
        catch(Throwable v1_1) {
            goto label_13;
        }
        catch(RuntimeException ) {
            goto label_15;
        }

        v0.delete();
        return v1;
        try {
        label_8:
            v1 = Typeface.createFromFile(v0.getPath());
        }
        catch(Throwable v1_1) {
        label_13:
            v0.delete();
            throw v1_1;
        }
        catch(RuntimeException ) {
        label_15:
            v0.delete();
            return v1;
        }

        v0.delete();
        return v1;
    }

    public Typeface createFromResourcesFontFile(Context arg1, Resources arg2, int arg3, String arg4, int arg5) {
        File v0 = TypefaceCompatUtil.getTempFile(arg1);
        Typeface v1 = null;
        if(v0 == null) {
            return v1;
        }

        try {
            if(TypefaceCompatUtil.copyToFile(v0, arg2, arg3)) {
                goto label_8;
            }
        }
        catch(Throwable v1_1) {
            goto label_13;
        }
        catch(RuntimeException ) {
            goto label_15;
        }

        v0.delete();
        return v1;
        try {
        label_8:
            v1 = Typeface.createFromFile(v0.getPath());
        }
        catch(Throwable v1_1) {
        label_13:
            v0.delete();
            throw v1_1;
        }
        catch(RuntimeException ) {
        label_15:
            v0.delete();
            return v1;
        }

        v0.delete();
        return v1;
    }

    Typeface createWeightStyle(Context arg1, Typeface arg2, int arg3, boolean arg4) {
        Typeface v0;
        try {
            v0 = WeightTypefaceApi14.createWeightStyle(this, arg1, arg2, arg3, arg4);
        }
        catch(RuntimeException ) {
            v0 = null;
        }

        if(v0 == null) {
        }
        else {
            arg2 = v0;
        }

        return arg2;
    }

    private FontFileResourceEntry findBestEntry(FontFamilyFilesResourceEntry arg2, int arg3) {
        return TypefaceCompatBaseImpl.findBestFont(arg2.getEntries(), arg3, new StyleExtractor() {
            public int getWeight(FontFileResourceEntry arg1) {
                return arg1.getWeight();
            }

            public int getWeight(Object arg1) {
                return this.getWeight(((FontFileResourceEntry)arg1));
            }

            public boolean isItalic(FontFileResourceEntry arg1) {
                return arg1.isItalic();
            }

            public boolean isItalic(Object arg1) {
                return this.isItalic(((FontFileResourceEntry)arg1));
            }
        });
    }

    private FontFileResourceEntry findBestEntry(FontFamilyFilesResourceEntry arg2, int arg3, boolean arg4) {
        return TypefaceCompatBaseImpl.findBestFont(arg2.getEntries(), arg3, arg4, new StyleExtractor() {
            public int getWeight(FontFileResourceEntry arg1) {
                return arg1.getWeight();
            }

            public int getWeight(Object arg1) {
                return this.getWeight(((FontFileResourceEntry)arg1));
            }

            public boolean isItalic(FontFileResourceEntry arg1) {
                return arg1.isItalic();
            }

            public boolean isItalic(Object arg1) {
                return this.isItalic(((FontFileResourceEntry)arg1));
            }
        });
    }

    private static Object findBestFont(Object[] arg1, int arg2, StyleExtractor arg3) {
        int v0 = (arg2 & 1) == 0 ? 400 : 700;
        boolean v2 = (arg2 & 2) != 0 ? true : false;
        return TypefaceCompatBaseImpl.findBestFont(arg1, v0, v2, arg3);
    }

    private static Object findBestFont(Object[] arg8, int arg9, boolean arg10, StyleExtractor arg11) {
        int v0 = arg8.length;
        Object v1 = null;
        int v2 = 0x7FFFFFFF;
        int v4;
        for(v4 = 0; v4 < v0; ++v4) {
            Object v5 = arg8[v4];
            int v6 = Math.abs(arg11.getWeight(v5) - arg9) * 2;
            int v7 = arg11.isItalic(v5) == arg10 ? 0 : 1;
            v6 += v7;
            if(v1 == null || v2 > v6) {
                v1 = v5;
                v2 = v6;
            }
        }

        return v1;
    }

    protected FontInfo findBestInfo(FontInfo[] arg2, int arg3) {
        return TypefaceCompatBaseImpl.findBestFont(((Object[])arg2), arg3, new StyleExtractor() {
            public int getWeight(FontInfo arg1) {
                return arg1.getWeight();
            }

            public int getWeight(Object arg1) {
                return this.getWeight(((FontInfo)arg1));
            }

            public boolean isItalic(FontInfo arg1) {
                return arg1.isItalic();
            }

            public boolean isItalic(Object arg1) {
                return this.isItalic(((FontInfo)arg1));
            }
        });
    }

    FontFamilyFilesResourceEntry getFontFamily(Typeface arg5) {
        long v0 = TypefaceCompatBaseImpl.getUniqueKey(arg5);
        if(v0 == 0) {
            return null;
        }

        return this.mFontFamilies.get(Long.valueOf(v0));
    }

    private static long getUniqueKey(Typeface arg6) {
        // Method was not decompiled
    }
}

