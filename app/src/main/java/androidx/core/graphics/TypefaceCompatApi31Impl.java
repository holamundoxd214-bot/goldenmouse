package androidx.core.graphics;

import android.graphics.Typeface;
import android.graphics.fonts.Font$Builder;
import android.graphics.fonts.Font;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;

public class TypefaceCompatApi31Impl extends TypefaceCompatApi29Impl {
    private static final String TAG = "TypefaceCompatApi31Impl";

    public TypefaceCompatApi31Impl() {
        super();
    }

    protected Font getFontFromSystemFont(FontInfo arg3) {
        String v2 = arg3.getSystemFont();
        Font v0 = null;
        if(v2 == null) {
            return v0;
        }

        Typeface v2_1 = TypefaceCompatApi31Impl.getSystemFontFamily(v2);
        if(v2_1 == null) {
            return v0;
        }

        Font v2_2 = TypefaceCompat.guessPrimaryFont(v2_1);
        if(v2_2 == null) {
            return v0;
        }

        if(TextUtils.isEmpty(arg3.getVariationSettings())) {
            return v2_2;
        }

        try {
            return new Font$Builder(v2_2).setFontVariationSettings(arg3.getVariationSettings()).build();
        }
        catch(IOException ) {
            Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
            return v0;
        }
    }

    private static Typeface getSystemFontFamily(String arg2) {
        Typeface v2 = Typeface.create(arg2, 0);
        Typeface v0 = Typeface.create(Typeface.DEFAULT, 0);
        if(v2 != null && !v2.equals(v0)) {
            return v2;
        }

        return null;
    }
}

