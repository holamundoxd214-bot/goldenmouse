package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A(\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0000\u001A,\u0010\t\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\bH\u0002\"\u001E\u0010\u000E\u001A\u00020\f*\u00020\u000F8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u001E\u0010\u0014\u001A\u00020\f*\u00020\u00158BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"setPlaceholders", "", "Landroid/text/Spannable;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholder", "placeholder", "start", "", "end", "spanUnit", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PlaceholderExtensions_androidKt {
    private static final int getSpanUnit--R2X_6o(long arg2) {
        arg2 = TextUnit.getType-UIouoOA(arg2);
        if(TextUnitType.equals-impl0(arg2, TextUnitType.Companion.getSp-UIouoOA())) {
            return 0;
        }

        if(TextUnitType.equals-impl0(arg2, TextUnitType.Companion.getEm-UIouoOA())) {
            return 1;
        }

        return 2;
    }

    private static void getSpanUnit--R2X_6o$annotations(long arg0) {
    }

    private static final int getSpanVerticalAlign-do9X-Gg(int arg1) {
        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getAboveBaseline-J6kI3mc())) {
            return 0;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getTop-J6kI3mc())) {
            return 1;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getBottom-J6kI3mc())) {
            return 2;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc())) {
            return 3;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getTextTop-J6kI3mc())) {
            return 4;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getTextBottom-J6kI3mc())) {
            return 5;
        }

        if(PlaceholderVerticalAlign.equals-impl0(arg1, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc())) {
            return 6;
        }

        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    private static void getSpanVerticalAlign-do9X-Gg$annotations(int arg0) {
    }

    private static final void setPlaceholder(Spannable arg10, Placeholder arg11, int arg12, int arg13, Density arg14) {
        Object[] v0 = arg10.getSpans(arg12, arg13, EmojiSpan.class);
        int v1 = v0.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            arg10.removeSpan(v0[v2]);
        }

        SpannableExtensions_androidKt.setSpan(arg10, new PlaceholderSpan(TextUnit.getValue-impl(arg11.getWidth-XSAIIZE()), PlaceholderExtensions_androidKt.getSpanUnit--R2X_6o(arg11.getWidth-XSAIIZE()), TextUnit.getValue-impl(arg11.getHeight-XSAIIZE()), PlaceholderExtensions_androidKt.getSpanUnit--R2X_6o(arg11.getHeight-XSAIIZE()), arg14, PlaceholderExtensions_androidKt.getSpanVerticalAlign-do9X-Gg(arg11.getPlaceholderVerticalAlign-J6kI3mc())), arg12, arg13);
    }

    public static final void setPlaceholders(Spannable arg5, List arg6, Density arg7) {
        int v0 = arg6.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg6.get(v1);
            PlaceholderExtensions_androidKt.setPlaceholder(arg5, ((Range)v2).component1(), ((Range)v2).component2(), ((Range)v2).component3(), arg7);
        }
    }
}

