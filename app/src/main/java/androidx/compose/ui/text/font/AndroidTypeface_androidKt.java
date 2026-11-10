package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.platform.AndroidDefaultTypeface;
import androidx.compose.ui.text.platform.AndroidFontListTypeface;
import androidx.compose.ui.text.platform.AndroidGenericFontFamilyTypeface;
import androidx.compose.ui.text.platform.AndroidTypefaceWrapper;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A6\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u001C\b\u0002\u0010\u0006\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007H\u0007\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\f\u001A\u000E\u0010\r\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\f¨\u0006\u000E"}, d2={"Typeface", "Landroidx/compose/ui/text/font/Typeface;", "context", "Landroid/content/Context;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "styles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "typeface", "Landroid/graphics/Typeface;", "FontFamily", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidTypeface_androidKt {
    public static final FontFamily FontFamily(Typeface arg0) {
        return FontFamilyKt.FontFamily(AndroidTypeface_androidKt.Typeface(arg0));
    }

    public static final androidx.compose.ui.text.font.Typeface Typeface(Typeface arg1) {
        return new AndroidTypefaceWrapper(arg1);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="This API is deprecated with the introduction of async fonts which cannot resolve in this context. To preload fonts, use FontFamily.Resolver.", replaceWith="<_subannotation>") public static final androidx.compose.ui.text.font.Typeface Typeface(Context arg8, FontFamily arg9, List arg10) {
        if((arg9 instanceof FontListFontFamily)) {
            return new AndroidFontListTypeface(arg9, arg8, arg10, null, 8, null);
        }

        if((arg9 instanceof GenericFontFamily)) {
            return new AndroidGenericFontFamilyTypeface(((GenericFontFamily)arg9));
        }

        if((arg9 instanceof DefaultFontFamily)) {
            return new AndroidDefaultTypeface();
        }

        if((arg9 instanceof LoadedFontFamily)) {
            return ((LoadedFontFamily)arg9).getTypeface();
        }

        throw new NoWhenBranchMatchedException();
    }

    public static androidx.compose.ui.text.font.Typeface Typeface$default(Context arg0, FontFamily arg1, List arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = null;
        }

        return AndroidTypeface_androidKt.Typeface(arg0, arg1, arg2);
    }
}

