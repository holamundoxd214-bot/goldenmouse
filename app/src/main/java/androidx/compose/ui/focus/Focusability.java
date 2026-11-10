package androidx.compose.ui.focus;

import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u0013\u0010\u0010\u001A\u00020\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2={"Landroidx/compose/ui/focus/Focusability;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "canFocus", "", "node", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canFocus-impl$ui", "(ILandroidx/compose/ui/node/CompositionLocalConsumerModifierNode;)Z", "equals", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class Focusability {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/ui/focus/Focusability$Companion;", "", "<init>", "()V", "Always", "Landroidx/compose/ui/focus/Focusability;", "getAlways-LCbbffg", "()I", "I", "SystemDefined", "getSystemDefined-LCbbffg", "Never", "getNever-LCbbffg", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getAlways-LCbbffg() {
            return Focusability.Always;
        }

        public final int getNever-LCbbffg() {
            return Focusability.Never;
        }

        public final int getSystemDefined-LCbbffg() {
            return Focusability.SystemDefined;
        }
    }

    private static final int Always;
    public static final Companion Companion;
    private static final int Never;
    private static final int SystemDefined;
    private final int value;

    static {
        Focusability.Companion = new Companion(null);
        Focusability.Always = Focusability.constructor-impl(1);
        Focusability.SystemDefined = Focusability.constructor-impl(0);
        Focusability.Never = Focusability.constructor-impl(2);
    }

    private Focusability(int arg1) {
        super();
        this.value = arg1;
    }

    public static final int access$getAlways$cp() {
        return Focusability.Always;
    }

    public static final int access$getNever$cp() {
        return Focusability.Never;
    }

    public static final int access$getSystemDefined$cp() {
        return Focusability.SystemDefined;
    }

    public static final Focusability box-impl(int arg1) {
        return new Focusability(arg1);
    }

    public static final boolean canFocus-impl$ui(int arg2, CompositionLocalConsumerModifierNode arg3) {
        if(Focusability.equals-impl0(arg2, Focusability.Always)) {
            return 1;
        }

        if(Focusability.equals-impl0(arg2, Focusability.SystemDefined)) {
            return InputMode.equals-impl0(CompositionLocalConsumerModifierNodeKt.currentValueOf(arg3, CompositionLocalsKt.getLocalInputModeManager()).getInputMode-aOaMEAU(), InputMode.Companion.getTouch-aOaMEAU()) ^ 1;
        }

        if(Focusability.equals-impl0(arg2, Focusability.Never)) {
            return 0;
        }

        throw new IllegalStateException("Unknown Focusability".toString());
    }

    private static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Focusability.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof Focusability)) {
            return 0;
        }

        if(arg2 != ((Focusability)arg3).unbox-impl()) {
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
        return Focusability.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return Focusability.toString-impl(this.value);
    }

    public static String toString-impl(int arg1) {
        if(Focusability.equals-impl0(arg1, Focusability.Always)) {
            return "Always";
        }

        if(Focusability.equals-impl0(arg1, Focusability.SystemDefined)) {
            return "SystemDefined";
        }

        if(Focusability.equals-impl0(arg1, Focusability.Never)) {
            return "Never";
        }

        throw new IllegalStateException("Unknown Focusability".toString());
    }

    public final int unbox-impl() {
        return this.value;
    }
}

