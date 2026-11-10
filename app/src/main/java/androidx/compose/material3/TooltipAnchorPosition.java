package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/material3/TooltipAnchorPosition;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class TooltipAnchorPosition {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2={"Landroidx/compose/material3/TooltipAnchorPosition$Companion;", "", "<init>", "()V", "Above", "Landroidx/compose/material3/TooltipAnchorPosition;", "getAbove-lOKsHw4", "()I", "I", "Below", "getBelow-lOKsHw4", "Left", "getLeft-lOKsHw4", "Right", "getRight-lOKsHw4", "Start", "getStart-lOKsHw4", "End", "getEnd-lOKsHw4", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAbove-lOKsHw4() {
            return TooltipAnchorPosition.Above;
        }

        public final int getBelow-lOKsHw4() {
            return TooltipAnchorPosition.Below;
        }

        public final int getEnd-lOKsHw4() {
            return TooltipAnchorPosition.End;
        }

        public final int getLeft-lOKsHw4() {
            return TooltipAnchorPosition.Left;
        }

        public final int getRight-lOKsHw4() {
            return TooltipAnchorPosition.Right;
        }

        public final int getStart-lOKsHw4() {
            return TooltipAnchorPosition.Start;
        }
    }

    private static final int Above;
    private static final int Below;
    public static final Companion Companion;
    private static final int End;
    private static final int Left;
    private static final int Right;
    private static final int Start;
    private final int value;

    static {
        TooltipAnchorPosition.Companion = new Companion(null);
        TooltipAnchorPosition.Above = TooltipAnchorPosition.constructor-impl(1);
        TooltipAnchorPosition.Below = TooltipAnchorPosition.constructor-impl(2);
        TooltipAnchorPosition.Left = TooltipAnchorPosition.constructor-impl(3);
        TooltipAnchorPosition.Right = TooltipAnchorPosition.constructor-impl(4);
        TooltipAnchorPosition.Start = TooltipAnchorPosition.constructor-impl(5);
        TooltipAnchorPosition.End = TooltipAnchorPosition.constructor-impl(6);
    }

    private TooltipAnchorPosition(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAbove$cp() {
        return TooltipAnchorPosition.Above;
    }

    public static final int access$getBelow$cp() {
        return TooltipAnchorPosition.Below;
    }

    public static final int access$getEnd$cp() {
        return TooltipAnchorPosition.End;
    }

    public static final int access$getLeft$cp() {
        return TooltipAnchorPosition.Left;
    }

    public static final int access$getRight$cp() {
        return TooltipAnchorPosition.Right;
    }

    public static final int access$getStart$cp() {
        return TooltipAnchorPosition.Start;
    }

    public static final TooltipAnchorPosition box-impl(int arg1) {
        return new TooltipAnchorPosition(arg1);
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return TooltipAnchorPosition.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof TooltipAnchorPosition)) {
            return 0;
        }

        if(arg2 != ((TooltipAnchorPosition)arg3).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(int arg0, int arg1) {
        if(arg0 == arg1) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return TooltipAnchorPosition.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return TooltipAnchorPosition.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.Above)) {
            return "Above";
        }

        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.Below)) {
            return "Below";
        }

        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.Left)) {
            return "Left";
        }

        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.Right)) {
            return "Right";
        }

        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.Start)) {
            return "Start";
        }

        if(TooltipAnchorPosition.equals-impl0(arg1, TooltipAnchorPosition.End)) {
            return "End";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

