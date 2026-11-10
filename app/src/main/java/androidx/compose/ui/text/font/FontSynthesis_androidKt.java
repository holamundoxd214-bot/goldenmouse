package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import android.os.Build$VERSION;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"synthesizeTypeface", "", "Landroidx/compose/ui/text/font/FontSynthesis;", "typeface", "font", "Landroidx/compose/ui/text/font/Font;", "requestedWeight", "Landroidx/compose/ui/text/font/FontWeight;", "requestedStyle", "Landroidx/compose/ui/text/font/FontStyle;", "synthesizeTypeface-FxwP2eA", "(ILjava/lang/Object;Landroidx/compose/ui/text/font/Font;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/lang/Object;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FontSynthesis_androidKt {
    public static final Object synthesizeTypeface-FxwP2eA(int arg5, Object arg6, Font arg7, FontWeight arg8, int arg9) {
        boolean v0;
        boolean v1;
        if(!(arg6 instanceof Typeface)) {
        }
        else {
            v1 = true;
            v0 = !FontSynthesis.isWeightOn-impl$ui_text(arg5) || (Intrinsics.areEqual(arg7.getWeight(), arg8)) || arg8.compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) < 0 || arg7.getWeight().compareTo(AndroidFontUtils_androidKt.getAndroidBold(FontWeight.Companion)) >= 0 ? false : true;
            arg5 = !FontSynthesis.isStyleOn-impl$ui_text(arg5) || (FontStyle.equals-impl0(arg9, arg7.getStyle-_-LCdwA())) ? 0 : 1;
            if(arg5 == 0 && !v0) {
                return arg6;
            }

            goto label_33;
        }

        return arg6;
    label_33:
        if(Build$VERSION.SDK_INT < 28) {
            if(arg5 == 0 || !FontStyle.equals-impl0(arg9, FontStyle.Companion.getItalic-_-LCdwA())) {
                v1 = false;
            }
            else {
            }

            return Typeface.create(((Typeface)arg6), AndroidFontUtils_androidKt.getAndroidTypefaceStyle(v0, v1));
        }

        int v8 = v0 ? arg8.getWeight() : arg7.getWeight().getWeight();
        boolean v5 = arg5 != 0 ? FontStyle.equals-impl0(arg9, FontStyle.Companion.getItalic-_-LCdwA()) : FontStyle.equals-impl0(arg7.getStyle-_-LCdwA(), FontStyle.Companion.getItalic-_-LCdwA());
        return TypefaceHelperMethodsApi28.INSTANCE.create(((Typeface)arg6), v8, v5);
    }
}

