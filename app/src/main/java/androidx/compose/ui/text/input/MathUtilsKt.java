package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A0\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000\u001A0\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¨\u0006\u0006"}, d2={"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MathUtilsKt {
    public static final int addExactOrElse(int arg1, int arg2, Function0 arg3) {
        int v0 = arg1 + arg2;
        if(((arg1 ^ v0) & (arg2 ^ v0)) < 0) {
            return arg3.invoke().intValue();
        }

        return v0;
    }

    public static final int subtractExactOrElse(int arg1, int arg2, Function0 arg3) {
        int v0 = arg1 - arg2;
        if(((arg1 ^ v0) & (arg2 ^ arg1)) < 0) {
            return arg3.invoke().intValue();
        }

        return v0;
    }
}

