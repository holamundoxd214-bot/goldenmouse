package androidx.compose.ui.text.font;

import kotlin.Metadata;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A\u001F\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u000F"}, d2={"AndroidBold", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "getAndroidBold", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/ui/text/font/FontWeight;", "getAndroidTypefaceStyle", "", "fontWeight", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "getAndroidTypefaceStyle-FO1MlWM", "(Landroidx/compose/ui/text/font/FontWeight;I)I", "isBold", "", "isItalic", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidFontUtils_androidKt {
    public static final FontWeight getAndroidBold(Companion arg0) {
        return arg0.getW600();
    }

    public static final int getAndroidTypefaceStyle(boolean arg0, boolean arg1) {
        if((arg1) && (arg0)) {
            return 3;
        }

        if(arg0) {
            return 1;
        }

        if(arg1) {
            return 2;
        }

        return 0;
    }

    public static final int getAndroidTypefaceStyle-FO1MlWM(FontWeight arg1, int arg2) {
        boolean v1 = arg1.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 ? true : false;
        return AndroidFontUtils_androidKt.getAndroidTypefaceStyle(v1, FontStyle.equals-impl0(arg2, FontStyle.Companion.getItalic-_-LCdwA()));
    }
}

