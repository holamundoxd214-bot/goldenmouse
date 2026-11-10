package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u001B\u0010\u0006\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001A\u001A\u0010\u000B\u001A\u00020\u0005*\u00020\u00052\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00050\rH\u0002¨\u0006\u000E"}, d2={"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextDrawStyleKt {
    public static final float access$takeOrElse(float arg0, Function0 arg1) {
        return TextDrawStyleKt.takeOrElse(arg0, arg1);
    }

    public static final TextForegroundStyle lerp(TextForegroundStyle arg3, TextForegroundStyle arg4, float arg5) {
        boolean v0 = arg3 instanceof BrushStyle;
        if(!v0 && !(arg4 instanceof BrushStyle)) {
            return TextForegroundStyle.Companion.from-8_81llA(ColorKt.lerp-jxsXWHM(arg3.getColor-0d7_KjU(), arg4.getColor-0d7_KjU(), arg5));
        }

        if((v0) && ((arg4 instanceof BrushStyle))) {
            return TextForegroundStyle.Companion.from(SpanStyleKt.lerpDiscrete(((BrushStyle)arg3).getBrush(), ((BrushStyle)arg4).getBrush(), arg5), MathHelpersKt.lerp(((BrushStyle)arg3).getAlpha(), ((BrushStyle)arg4).getAlpha(), arg5));
        }

        return SpanStyleKt.lerpDiscrete(arg3, arg4, arg5);
    }

    public static final long modulate-DxMtmZc(long arg9, float arg11) {
        if(!Float.isNaN(arg11)) {
            if(arg11 >= 1f) {
            }
            else {
                return Color.copy-wmQWz5c$default(arg9, Color.getAlpha-impl(arg9) * arg11, 0f, 0f, 0f, 14, null);
            }
        }

        return arg9;
    }

    private static final float takeOrElse(float arg1, Function0 arg2) {
        if(Float.isNaN(arg1)) {
            arg1 = arg2.invoke().floatValue();
        }

        return arg1;
    }
}

