package androidx.compose.ui.text.font;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001A+\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\r\u001A?\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A\f\u0010\u0012\u001A\u00020\u0013*\u00020\u0001H\u0007¨\u0006\u0014"}, d2={"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "Font-YpTlLL0", "(ILandroidx/compose/ui/text/font/FontWeight;II)Landroidx/compose/ui/text/font/Font;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-F3nL8kk", "(ILandroidx/compose/ui/text/font/FontWeight;IILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontKt {
    public static final Font Font-F3nL8kk(int arg7, FontWeight arg8, int arg9, int arg10, Settings arg11) {
        return new ResourceFont(arg7, arg8, arg9, arg11, arg10, null);
    }

    public static Font Font-F3nL8kk$default(int arg0, FontWeight arg1, int arg2, int arg3, Settings arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg5 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg5 & 8) != 0) {
            arg3 = FontLoadingStrategy.Companion.getBlocking-PKNRLFQ();
        }

        if((arg5 & 16) != 0) {
            arg4 = FontVariation.INSTANCE.Settings-6EWAqTQ(arg1, arg2, new Setting[0]);
        }

        return FontKt.Font-F3nL8kk(arg0, arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility until Compose 1.3.", replaceWith="<_subannotation>") public static final Font Font-RetOiIg(int arg8, FontWeight arg9, int arg10) {
        return new ResourceFont(arg8, arg9, arg10, null, FontLoadingStrategy.Companion.getBlocking-PKNRLFQ(), 8, null);
    }

    public static Font Font-RetOiIg$default(int arg0, FontWeight arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg3 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        return FontKt.Font-RetOiIg(arg0, arg1, arg2);
    }

    public static final Font Font-YpTlLL0(int arg7, FontWeight arg8, int arg9, int arg10) {
        return new ResourceFont(arg7, arg8, arg9, new Settings(new Setting[0]), arg10, null);
    }

    public static Font Font-YpTlLL0$default(int arg0, FontWeight arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg4 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg4 & 8) != 0) {
            arg3 = FontLoadingStrategy.Companion.getBlocking-PKNRLFQ();
        }

        return FontKt.Font-YpTlLL0(arg0, arg1, arg2, arg3);
    }

    public static final FontFamily toFontFamily(Font arg2) {
        return FontFamilyKt.FontFamily(new Font[]{arg2});
    }
}

