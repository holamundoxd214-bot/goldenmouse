package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A9\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001A.\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00012\f\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00070\u0019H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005¨\u0006\u001A"}, d2={"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "getEmptyTextReplacement", "()Ljava/lang/String;", "computeSizeForDefaultText", "Landroidx/compose/ui/unit/IntSize;", "style", "Landroidx/compose/ui/text/TextStyle;", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "text", "maxLines", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/lang/String;I)J", "focusedRectInRoot", "Landroidx/compose/ui/geometry/Rect;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "focusOffset", "sizeForDefaultText", "Lkotlin/Function0;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldDelegateKt {
    public static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement;

    static {
        TextFieldDelegateKt.EmptyTextReplacement = StringsKt.repeat("H", 10);
    }

    public static final long computeSizeForDefaultText(TextStyle arg12, Density arg13, Resolver arg14, String arg15, int arg16) {
        Paragraph v12 = ParagraphKt.Paragraph-Ul8oQg4$default(arg15, arg12, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), arg13, arg14, CollectionsKt.emptyList(), null, arg16, TextOverflow.Companion.getClip-gIe3tQ8(), 0x40, null);
        return IntSize.constructor-impl((((long)TextDelegateKt.ceilToIntPx(v12.getMinIntrinsicWidth()))) << 0x20 | (((long)TextDelegateKt.ceilToIntPx(v12.getHeight()))) & 0xFFFFFFFFL);
    }

    public static long computeSizeForDefaultText$default(TextStyle arg0, Density arg1, Resolver arg2, String arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 8) != 0) {
            arg3 = TextFieldDelegateKt.EmptyTextReplacement;
        }

        return TextFieldDelegateKt.computeSizeForDefaultText(arg0, arg1, arg2, arg3, 1);
    }

    public static final Rect focusedRectInRoot(TextLayoutResult arg8, LayoutCoordinates arg9, int arg10, Function0 arg11) {
        Rect v8;
        long v1 = 0xFFFFFFFFL;
        if(arg10 < arg8.getLayoutInput().getText().length()) {
            v8 = arg8.getBoundingBox(arg10);
        }
        else if(arg10 != 0) {
            v8 = arg8.getBoundingBox(arg10 - 1);
        }
        else {
            v8 = new Rect(0f, 0f, 1f, ((float)(((int)(arg11.invoke().unbox-impl() & v1)))));
        }

        long v9 = arg9.localToRoot-MK-Hz9U(Offset.constructor-impl((((long)Float.floatToRawIntBits(v8.getTop()))) & v1 | (((long)Float.floatToRawIntBits(v8.getLeft()))) << 0x20));
        return RectKt.Rect-tz77jQw(Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v9 >> 0x20)))))) << 0x20 | (((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v9 & v1)))))) & v1), Size.constructor-impl((((long)Float.floatToRawIntBits(v8.getBottom() - v8.getTop()))) & v1 | (((long)Float.floatToRawIntBits(v8.getRight() - v8.getLeft()))) << 0x20));
    }

    public static final String getEmptyTextReplacement() {
        return TextFieldDelegateKt.EmptyTextReplacement;
    }
}

