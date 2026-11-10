package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build$VERSION;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A \u0010\u0002\u001A\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001\u001A\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\fH\u0001¨\u0006\r"}, d2={"PlatformTypefaces", "Landroidx/compose/ui/text/font/PlatformTypefaces;", "setFontVariationSettings", "Landroid/graphics/Typeface;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "context", "Landroid/content/Context;", "getWeightSuffixForFallbackFamilyName", "", "name", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlatformTypefaces_androidKt {
    public static final PlatformTypefaces PlatformTypefaces() {
        if(Build$VERSION.SDK_INT >= 28) {
            return new PlatformTypefacesApi28();
        }

        return new PlatformTypefacesApi();
    }

    public static final String getWeightSuffixForFallbackFamilyName(String arg2, FontWeight arg3) {
        int v3 = arg3.getWeight() / 100;
        int v0 = 2;
        if(v3 >= 0 && v3 < v0) {
            return arg2 + "-thin";
        }

        int v1 = 4;
        if(v0 <= v3 && v3 < v1) {
            return arg2 + "-light";
        }

        if(v3 == v1) {
            return arg2;
        }

        if(v3 == 5) {
            return arg2 + "-medium";
        }

        v1 = 8;
        if(6 <= v3 && v3 < v1) {
            return arg2;
        }

        if(v1 <= v3 && v3 < 11) {
            arg2 = arg2 + "-black";
        }

        return arg2;
    }

    public static final Typeface setFontVariationSettings(Typeface arg1, Settings arg2, Context arg3) {
        return TypefaceCompatApi26.INSTANCE.setFontVariationSettings(arg1, arg2, arg3);
    }
}

