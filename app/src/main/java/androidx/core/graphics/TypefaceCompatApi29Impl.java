package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface$CustomFallbackBuilder;
import android.graphics.Typeface;
import android.graphics.fonts.Font$Builder;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily$Builder;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private static final String TAG = "TypefaceCompatApi29Impl";

    public TypefaceCompatApi29Impl() {
        super();
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context arg7, FontFamilyFilesResourceEntry arg8, Resources arg9, int arg10) {
        FontFamily$Builder v2;
        Typeface v7 = null;
        try {
            FontFileResourceEntry[] v8 = arg8.getEntries();
            int v0 = v8.length;
            int v1 = 0;
            v2 = ((FontFamily$Builder)v7);
            while(v1 < v0) {
                FontFileResourceEntry v3 = v8[v1];
                try {
                    Font v3_1 = new Font$Builder(arg9, v3.getResourceId()).setWeight(v3.getWeight()).setSlant(v3.isItalic()).setTtcIndex(v3.getTtcIndex()).setFontVariationSettings(v3.getVariationSettings()).build();
                    if(v2 == null) {
                        v2 = new FontFamily$Builder(v3_1);
                    }
                    else {
                        v2.addFont(v3_1);
                    }

                    goto label_25;
                }
                catch(IOException ) {
                label_25:
                    ++v1;
                    continue;
                }
            }
        }
        catch(Exception v6) {
            goto label_40;
        }

        if(v2 == null) {
            return v7;
        }

        try {
            FontFamily v8_1 = v2.build();
            return new Typeface$CustomFallbackBuilder(v8_1).setStyle(this.findBaseFont(v8_1, arg10).getStyle()).build();
        }
        catch(Exception v6) {
        label_40:
            Log.w("TypefaceCompatApi29Impl", "Font load failed", ((Throwable)v6));
            return v7;
        }
    }

    public Typeface createFromFontInfo(Context arg2, CancellationSignal arg3, FontInfo[] arg4, int arg5) {
        ContentResolver v2 = arg2.getContentResolver();
        Typeface v0 = null;
        try {
            FontFamily v2_1 = this.getFontFamily(arg3, arg4, v2);
            if(v2_1 == null) {
                return v0;
            }

            return new Typeface$CustomFallbackBuilder(v2_1).setStyle(this.findBaseFont(v2_1, arg5).getStyle()).build();
        }
        catch(Exception v1) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", ((Throwable)v1));
            return v0;
        }
    }

    public Typeface createFromFontInfoWithFallback(Context arg6, CancellationSignal arg7, List arg8, int arg9) {
        ContentResolver v6 = arg6.getContentResolver();
        Typeface v1 = null;
        try {
            FontFamily v0 = this.getFontFamily(arg7, arg8.get(0), v6);
            if(v0 == null) {
                return v1;
            }

            Typeface$CustomFallbackBuilder v2 = new Typeface$CustomFallbackBuilder(v0);
            int v3;
            for(v3 = 1; v3 < arg8.size(); ++v3) {
                FontFamily v4 = this.getFontFamily(arg7, arg8.get(v3), v6);
                if(v4 != null) {
                    v2.addCustomFallback(v4);
                }
            }

            return v2.setStyle(this.findBaseFont(v0, arg9).getStyle()).build();
        }
        catch(Exception v5) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", ((Throwable)v5));
            return v1;
        }
    }

    protected Typeface createFromInputStream(Context arg1, InputStream arg2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public Typeface createFromResourcesFontFile(Context arg1, Resources arg2, int arg3, String arg4, int arg5) {
        try {
            Font v0_1 = new Font$Builder(arg2, arg3).build();
            return new Typeface$CustomFallbackBuilder(new FontFamily$Builder(v0_1).build()).setStyle(v0_1.getStyle()).build();
        }
        catch(Exception v0) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", ((Throwable)v0));
            return null;
        }
    }

    Typeface createWeightStyle(Context arg1, Typeface arg2, int arg3, boolean arg4) {
        return Typeface.create(arg2, arg3, arg4);
    }

    private Font findBaseFont(FontFamily arg5, int arg6) {
        int v0 = (arg6 & 1) != 0 ? 700 : 400;
        int v2 = 1;
        arg6 = (arg6 & 2) != 0 ? 1 : 0;
        FontStyle v4 = new FontStyle(v0, arg6);
        Font v6 = arg5.getFont(0);
        v0 = TypefaceCompatApi29Impl.getMatchScore(v4, v6.getStyle());
        while(v2 < arg5.getSize()) {
            Font v1 = arg5.getFont(v2);
            int v3 = TypefaceCompatApi29Impl.getMatchScore(v4, v1.getStyle());
            if(v3 < v0) {
                v6 = v1;
                v0 = v3;
            }

            ++v2;
        }

        return v6;
    }

    protected FontInfo findBestInfo(FontInfo[] arg1, int arg2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    private Font getFont(CancellationSignal arg2, FontInfo arg3, ContentResolver arg4) {
        if(arg3.isSystemFont()) {
            return this.getFontFromSystemFont(arg3);
        }

        return this.getFontFromProvider(arg2, arg3, arg4);
    }

    protected FontFamily getFontFamily(CancellationSignal arg6, FontInfo[] arg7, ContentResolver arg8) {
        int v0 = arg7.length;
        FontFamily v1 = null;
        int v2 = 0;
        FontFamily$Builder v3 = ((FontFamily$Builder)v1);
        while(v2 < v0) {
            Font v4 = this.getFont(arg6, arg7[v2], arg8);
            if(v4 == null) {
            }
            else if(v3 == null) {
                v3 = new FontFamily$Builder(v4);
            }
            else {
                v3.addFont(v4);
            }

            ++v2;
        }

        if(v3 == null) {
            return v1;
        }

        return v3.build();
    }

    private Font getFontFromProvider(CancellationSignal arg3, FontInfo arg4, ContentResolver arg5) {
        Font v4_1;
        ParcelFileDescriptor v3_1;
        Font v2 = null;
        try {
            v3_1 = arg5.openFileDescriptor(arg4.getUri(), "r", arg3);
            if(v3_1 != null) {
                goto label_8;
            }

            if(v3_1 != null) {
                v3_1.close();
            }
        }
        catch(IOException v3) {
            goto label_35;
        }

        return v2;
        try {
        label_8:
            Font$Builder v5 = new Font$Builder(v3_1).setWeight(arg4.getWeight()).setSlant(arg4.isItalic()).setTtcIndex(arg4.getTtcIndex());
            if(!TextUtils.isEmpty(arg4.getVariationSettings())) {
                v5.setFontVariationSettings(arg4.getVariationSettings());
            }

            v4_1 = v5.build();
            if(v3_1 == null) {
                return v4_1;
            }

            goto label_23;
        }
        catch(Throwable v4) {
            if(v3_1 != null) {
                try {
                    v3_1.close();
                    goto label_31;
                }
                catch(Throwable v3_2) {
                    try {
                        v4.addSuppressed(v3_2);
                    label_31:
                        throw v4;
                    label_23:
                        v3_1.close();
                    }
                    catch(IOException v3) {
                    label_35:
                        Log.w("TypefaceCompatApi29Impl", "Font load failed", ((Throwable)v3));
                        return v2;
                    }
                }
            }
            else {
                goto label_31;
            }
        }

        return v4_1;
    }

    protected Font getFontFromSystemFont(FontInfo arg1) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    private static int getMatchScore(FontStyle arg2, FontStyle arg3) {
        int v0 = Math.abs(arg2.getWeight() - arg3.getWeight()) / 100;
        int v2 = arg2.getSlant() == arg3.getSlant() ? 0 : 2;
        return v0 + v2;
    }
}

