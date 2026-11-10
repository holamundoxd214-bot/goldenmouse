package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Font", "Landroidx/compose/ui/text/font/Font;", "familyName", "Landroidx/compose/ui/text/font/DeviceFontFamilyName;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "Font-vxs03AY", "(Ljava/lang/String;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;)Landroidx/compose/ui/text/font/Font;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DeviceFontFamilyNameFontKt {
    public static final Font Font-vxs03AY(String arg6, FontWeight arg7, int arg8, Settings arg9) {
        return new DeviceFontFamilyNameFont(arg6, arg7, arg8, arg9, null);
    }

    public static Font Font-vxs03AY$default(String arg0, FontWeight arg1, int arg2, Settings arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg1 = FontWeight.Companion.getNormal();
        }

        if((arg4 & 4) != 0) {
            arg2 = FontStyle.Companion.getNormal-_-LCdwA();
        }

        if((arg4 & 8) != 0) {
            arg3 = new Settings(new Setting[0]);
        }

        return DeviceFontFamilyNameFontKt.Font-vxs03AY(arg0, arg1, arg2, arg3);
    }
}

