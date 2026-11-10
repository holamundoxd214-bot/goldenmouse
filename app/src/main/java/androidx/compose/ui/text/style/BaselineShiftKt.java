package androidx.compose.ui.text.style;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\u001A\"\u0010\u0005\u001A\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001A\'\u0010\n\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u000F\u0010\u0010\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2={"isSpecified", "", "Landroidx/compose/ui/text/style/BaselineShift;", "isSpecified-4Dl_Bck", "(F)Z", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-JpAxnlU", "(FLkotlin/jvm/functions/Function0;)F", "lerp", "start", "stop", "fraction", "", "lerp-jWV1Mfo", "(FFF)F", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BaselineShiftKt {
    public static final boolean isSpecified-4Dl_Bck(float arg0) {
        return Float.isNaN(arg0) ^ 1;
    }

    public static final float lerp-jWV1Mfo(float arg0, float arg1, float arg2) {
        return BaselineShift.constructor-impl(MathHelpersKt.lerp(arg0, arg1, arg2));
    }

    public static final float takeOrElse-JpAxnlU(float arg1, Function0 arg2) {
        if(Float.isNaN(arg1)) {
            arg1 = arg2.invoke().unbox-impl();
        }

        return arg1;
    }
}

