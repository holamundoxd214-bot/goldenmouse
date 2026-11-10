package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087@\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\t\u001A\u00020\u0003HÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\r"}, d2={"Landroidx/compose/animation/core/ArcMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "hashCode", "toString", "", "Companion", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class ArcMode {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/animation/core/ArcMode$Companion;", "", "<init>", "()V", "ArcAbove", "Landroidx/compose/animation/core/ArcMode;", "getArcAbove--9T-Mq4", "()I", "I", "ArcBelow", "getArcBelow--9T-Mq4", "ArcLinear", "getArcLinear--9T-Mq4", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getArcAbove--9T-Mq4() {
            return ArcMode.ArcAbove;
        }

        public final int getArcBelow--9T-Mq4() {
            return ArcMode.ArcBelow;
        }

        public final int getArcLinear--9T-Mq4() {
            return ArcMode.ArcLinear;
        }
    }

    private static final int ArcAbove;
    private static final int ArcBelow;
    private static final int ArcLinear;
    public static final Companion Companion;
    private final int value;

    static {
        ArcMode.Companion = new Companion(null);
        ArcMode.ArcAbove = ArcMode.constructor-impl(5);
        ArcMode.ArcBelow = ArcMode.constructor-impl(4);
        ArcMode.ArcLinear = ArcMode.constructor-impl(0);
    }

    private ArcMode(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getArcAbove$cp() {
        return ArcMode.ArcAbove;
    }

    public static final int access$getArcBelow$cp() {
        return ArcMode.ArcBelow;
    }

    public static final int access$getArcLinear$cp() {
        return ArcMode.ArcLinear;
    }

    public static final ArcMode box-impl(int arg1) {
        return new ArcMode(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ArcMode.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof ArcMode)) {
            return 0;
        }

        if(arg2 != ((ArcMode)arg3).unbox-impl()) {
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
        return ArcMode.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return ArcMode.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        return "ArcMode(value=" + arg2 + ')';
    }

    public final int unbox-impl() {
        return this.value;
    }
}

