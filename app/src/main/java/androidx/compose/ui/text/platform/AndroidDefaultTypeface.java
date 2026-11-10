package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import android.os.Build$VERSION;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceHelperMethodsApi28;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="This path for preloading fonts is not supported") @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2={"Landroidx/compose/ui/text/platform/AndroidDefaultTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "<init>", "()V", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getNativeTypeface", "Landroid/graphics/Typeface;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidDefaultTypeface implements AndroidTypeface {
    public static final int $stable;
    private final FontFamily fontFamily;

    static {
    }

    public AndroidDefaultTypeface() {
        super();
        this.fontFamily = FontFamily.Companion.getDefault();
    }

    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public Typeface getNativeTypeface-PYhJU0U(FontWeight arg2, int arg3, int arg4) {
        if(Build$VERSION.SDK_INT < 28) {
            return Typeface.defaultFromStyle(AndroidFontUtils_androidKt.getAndroidTypefaceStyle-FO1MlWM(arg2, arg3));
        }

        return TypefaceHelperMethodsApi28.INSTANCE.create(Typeface.DEFAULT, arg2.getWeight(), FontStyle.equals-impl0(arg3, FontStyle.Companion.getItalic-_-LCdwA()));
    }
}

