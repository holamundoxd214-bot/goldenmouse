package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\"\u0010\u0005\u001A\u00020\u0002*\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\t\"\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004¨\u0006\n"}, d2={"isSpecified", "", "Landroidx/compose/ui/text/style/TextDirection;", "isSpecified-Hejc4pk", "(I)Z", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-HklW4sA", "(ILkotlin/jvm/functions/Function0;)I", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextDirectionKt {
    public static final boolean isSpecified-Hejc4pk(int arg0) {
        if(arg0 != 0) {
            return 1;
        }

        return 0;
    }

    public static final int takeOrElse-HklW4sA(int arg0, Function0 arg1) {
        if(arg0 != 0) {
            return arg0;
        }

        return arg1.invoke().unbox-impl();
    }
}

