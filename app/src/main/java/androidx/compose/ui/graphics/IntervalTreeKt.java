package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\"\u001C\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004\"\u000E\u0010\u0007\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0005\"\u00020\u00062\u00020\u0006¨\u0006\t"}, d2={"EmptyInterval", "Landroidx/compose/ui/graphics/Interval;", "", "getEmptyInterval", "()Landroidx/compose/ui/graphics/Interval;", "TreeColor", "", "TreeColorRed", "TreeColorBlack", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IntervalTreeKt {
    private static final Interval EmptyInterval = null;
    private static final int TreeColorBlack = 1;
    private static final int TreeColorRed;

    static {
        IntervalTreeKt.EmptyInterval = new Interval(3.402823E+38f, 1.401298E-45f, null);
    }

    public static final Interval getEmptyInterval() {
        return IntervalTreeKt.EmptyInterval;
    }
}

