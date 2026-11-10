package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface$CustomFallbackBuilder;
import android.graphics.Typeface;
import android.graphics.fonts.Font$Builder;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily$Builder;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build$VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import java.io.IOException;
import java.util.List;

public class TypefaceCompat {
    public class ResourcesCallbackAdapter extends FontRequestCallback {
        private FontCallback mFontCallback;

        public ResourcesCallbackAdapter(FontCallback arg1) {
            super();
            this.mFontCallback = arg1;
        }

        public void onTypefaceRequestFailed(int arg1) {
            FontCallback v0 = this.mFontCallback;
            if(v0 != null) {
                v0.onFontRetrievalFailed(arg1);
            }
        }

        public void onTypefaceRetrieved(Typeface arg1) {
            FontCallback v0 = this.mFontCallback;
            if(v0 != null) {
                v0.onFontRetrieved(arg1);
            }
        }
    }

    public static final boolean DOWNLOADABLE_FALLBACK_DEBUG = false;
    public static final boolean DOWNLOADABLE_FONT_TRACING = true;
    private static final String REFERENCE_CHAR_FOR_PRIMARY_FONT = " ";
    private static final String TAG = "TypefaceCompat";
    private static Paint sCachedPaint;
    private static final LruCache sTypefaceCache;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    static {
        Trace.beginSection("TypefaceCompat static init");
        if(Build$VERSION.SDK_INT >= 0x1F) {
            TypefaceCompat.sTypefaceCompatImpl = new TypefaceCompatApi31Impl();
        }
        else if(Build$VERSION.SDK_INT >= 29) {
            TypefaceCompat.sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        }
        else if(Build$VERSION.SDK_INT >= 28) {
            TypefaceCompat.sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        }
        else {
            TypefaceCompat.sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        }

        TypefaceCompat.sTypefaceCache = new LruCache(16);
        TypefaceCompat.sCachedPaint = null;
        Trace.endSection();
    }

    private TypefaceCompat() {
        super();
    }

    public static void clearCache() {
        TypefaceCompat.sTypefaceCache.evictAll();
    }

    public static Typeface create(Context arg0, Typeface arg1, int arg2) {
        if(arg0 != null) {
            return Typeface.create(arg1, arg2);
        }

        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface create(Context arg3, Typeface arg4, int arg5, boolean arg6) {
        if(arg3 != null) {
            Preconditions.checkArgumentInRange(arg5, 1, 1000, "weight");
            if(arg4 == null) {
                arg4 = Typeface.DEFAULT;
            }

            return TypefaceCompat.sTypefaceCompatImpl.createWeightStyle(arg3, arg4, arg5, arg6);
        }

        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface createFromFontInfo(Context arg1, CancellationSignal arg2, FontInfo[] arg3, int arg4) {
        Typeface v1_1;
        Trace.beginSection("TypefaceCompat.createFromFontInfo");
        try {
            v1_1 = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(arg1, arg2, arg3, arg4);
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
        return v1_1;
    }

    public static Typeface createFromFontInfoWithFallback(Context arg1, CancellationSignal arg2, List arg3, int arg4) {
        Typeface v1_1;
        Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            v1_1 = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfoWithFallback(arg1, arg2, arg3, arg4);
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
        return v1_1;
    }

    public static Typeface createFromResourcesFamilyXml(Context arg12, FamilyResourceEntry arg13, Resources arg14, int arg15, String arg16, int arg17, int arg18, FontCallback arg19, Handler arg20, boolean arg21) {
        Typeface v12;
        boolean v8;
        FontCallback v0 = arg19;
        Handler v1 = arg20;
        if((arg13 instanceof ProviderResourceEntry)) {
            Typeface v2 = TypefaceCompat.getSystemFontFamilyWithFallback(((ProviderResourceEntry)arg13));
            if(v2 != null) {
                if(v0 != null) {
                    v0.callbackSuccessAsync(v2, v1);
                }

                TypefaceCompat.sTypefaceCache.put(TypefaceCompat.createResourceUid(arg14, arg15, arg16, arg17, arg18), v2);
                return v2;
            }
            else {
                if(arg21) {
                    if(((ProviderResourceEntry)arg13).getFetchStrategy() == 0) {
                        goto label_19;
                    }
                    else {
                        goto label_21;
                    }
                }
                else if(v0 == null) {
                label_19:
                    v8 = true;
                }
                else {
                label_21:
                    v8 = false;
                }

                int v2_1 = arg21 ? ((ProviderResourceEntry)arg13).getTimeout() : -1;
                v12 = FontsContractCompat.requestFont(arg12, ((ProviderResourceEntry)arg13).getRequests(), arg18, v8, v2_1, FontCallback.getHandler(v1), new ResourcesCallbackAdapter(v0));
            }
        }
        else {
            v12 = TypefaceCompat.sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(arg12, ((FontFamilyFilesResourceEntry)arg13), arg14, arg18);
            if(v0 == null) {
                goto label_44;
            }

            if(v12 != null) {
                v0.callbackSuccessAsync(v12, v1);
                goto label_44;
            }

            v0.callbackFailAsync(-3, v1);
        }

    label_44:
        if(v12 != null) {
            TypefaceCompat.sTypefaceCache.put(TypefaceCompat.createResourceUid(arg14, arg15, arg16, arg17, arg18), v12);
        }

        return v12;
    }

    @Deprecated public static Typeface createFromResourcesFamilyXml(Context arg10, FamilyResourceEntry arg11, Resources arg12, int arg13, int arg14, FontCallback arg15, Handler arg16, boolean arg17) {
        return TypefaceCompat.createFromResourcesFamilyXml(arg10, arg11, arg12, arg13, null, 0, arg14, arg15, arg16, arg17);
    }

    public static Typeface createFromResourcesFontFile(Context arg6, Resources arg7, int arg8, String arg9, int arg10, int arg11) {
        Resources v2 = arg7;
        int v3 = arg8;
        String v4 = arg9;
        int v5 = arg11;
        Typeface v6 = TypefaceCompat.sTypefaceCompatImpl.createFromResourcesFontFile(arg6, v2, v3, v4, v5);
        if(v6 != null) {
            TypefaceCompat.sTypefaceCache.put(TypefaceCompat.createResourceUid(v2, v3, v4, arg10, v5), v6);
        }

        return v6;
    }

    @Deprecated public static Typeface createFromResourcesFontFile(Context arg6, Resources arg7, int arg8, String arg9, int arg10) {
        return TypefaceCompat.createFromResourcesFontFile(arg6, arg7, arg8, arg9, 0, arg10);
    }

    private static String createResourceUid(Resources arg1, int arg2, String arg3, int arg4, int arg5) {
        return arg1.getResourcePackageName(arg2) + '-' + arg3 + '-' + arg4 + '-' + arg2 + '-' + arg5;
    }

    public static Typeface findFromCache(Resources arg1, int arg2, String arg3, int arg4, int arg5) {
        return TypefaceCompat.sTypefaceCache.get(TypefaceCompat.createResourceUid(arg1, arg2, arg3, arg4, arg5));
    }

    @Deprecated public static Typeface findFromCache(Resources arg2, int arg3, int arg4) {
        return TypefaceCompat.findFromCache(arg2, arg3, null, 0, arg4);
    }

    public static Typeface getSystemFontFamily(String arg3) {
        Typeface v0 = null;
        if(arg3 != null) {
            if(arg3.isEmpty()) {
            }
            else {
                Typeface v3 = Typeface.create(arg3, 0);
                Typeface v1 = Typeface.create(Typeface.DEFAULT, 0);
                if(v3 != null && !v3.equals(v1)) {
                    return v3;
                }
            }
        }

        return v0;
    }

    private static Typeface getSystemFontFamilyWithFallback(ProviderResourceEntry arg9) {
        FontFamily v3_1;
        String v0 = arg9.getSystemFontFamilyName();
        if(!TextUtils.isEmpty(((CharSequence)v0))) {
            Typeface v0_1 = TypefaceCompat.getSystemFontFamily(v0);
            if(v0_1 != null) {
                return v0_1;
            }
        }

        List v9 = arg9.getRequests();
        int v1 = 0;
        if(v9.size() == 1) {
            return TypefaceCompat.getSystemFontFamily(v9.get(0).getSystemFont());
        }

        Typeface v4 = null;
        if(Build$VERSION.SDK_INT < 0x1F) {
            return v4;
        }

        int v0_2;
        for(v0_2 = 0; v0_2 < v9.size(); ++v0_2) {
            if(TypefaceCompat.getSystemFontFamily(v9.get(v0_2).getSystemFont()) == null) {
                return v4;
            }
        }

        Typeface$CustomFallbackBuilder v0_3 = ((Typeface$CustomFallbackBuilder)v4);
        while(v1 < v9.size()) {
            Object v3 = v9.get(v1);
            if(v1 == v9.size() - 1 && (TextUtils.isEmpty(((FontRequest)v3).getVariationSettings()))) {
                v0_3.setSystemFallback(((FontRequest)v3).getSystemFont());
                break;
            }

            Font v5 = TypefaceCompat.guessPrimaryFont(TypefaceCompat.getSystemFontFamily(((FontRequest)v3).getSystemFont()));
            String v6 = "TypefaceCompat";
            if(v5 == null) {
                Log.w(v6, "Unable identify the primary font for " + ((FontRequest)v3).getSystemFont() + ". Falling back to provider font.");
                return v4;
            }

            if(!TextUtils.isEmpty(((FontRequest)v3).getVariationSettings())) {
                try {
                    v3_1 = new FontFamily$Builder(new Font$Builder(v5).setFontVariationSettings(((FontRequest)v3).getVariationSettings()).build()).build();
                }
                catch(IOException ) {
                    Log.e(v6, "Failed to clone Font instance. Fall back to provider font.");
                    return v4;
                }
            }
            else {
                v3_1 = new FontFamily$Builder(v5).build();
            }

            if(v0_3 == null) {
                v0_3 = new Typeface$CustomFallbackBuilder(v3_1);
            }
            else {
                v0_3.addCustomFallback(v3_1);
            }

            ++v1;
        }

        return v0_3.build();
    }

    public static Font guessPrimaryFont(Typeface arg9) {
        Paint v0 = TypefaceCompat.sCachedPaint;
        if(v0 == null) {
            v0 = new Paint();
            TypefaceCompat.sCachedPaint = v0;
        }

        v0.setTextSize(10f);
        TypefaceCompat.sCachedPaint.setTypeface(arg9);
        PositionedGlyphs v9 = TextRunShaper.shapeTextRun(" ", 0, " ".length(), 0, " ".length(), 0f, 0f, false, TypefaceCompat.sCachedPaint);
        if(v9.glyphCount() == 0) {
            return null;
        }

        return v9.getFont(0);
    }
}

