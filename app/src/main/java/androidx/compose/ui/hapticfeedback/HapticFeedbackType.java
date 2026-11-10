package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0006\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001A\u00020\u0003HÖ\u0001R\u000E\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000F"}, d2={"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class HapticFeedbackType {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00050!R\u0011\u0010\u0004\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u0011\u0010\f\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0007R\u0011\u0010\u0010\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001A\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0007R\u0011\u0010\u001C\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u0007R\u0011\u0010\u001E\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u0007¨\u0006\""}, d2={"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final int getConfirm-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getConfirm-5zf0vsI();
        }

        public final int getContextClick-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getContextClick-5zf0vsI();
        }

        public final int getGestureEnd-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getGestureEnd-5zf0vsI();
        }

        public final int getGestureThresholdActivate-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getGestureThresholdActivate-5zf0vsI();
        }

        public final int getKeyboardTap-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getKeyboardTap-5zf0vsI();
        }

        public final int getLongPress-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getLongPress-5zf0vsI();
        }

        public final int getReject-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getReject-5zf0vsI();
        }

        public final int getSegmentFrequentTick-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getSegmentFrequentTick-5zf0vsI();
        }

        public final int getSegmentTick-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getSegmentTick-5zf0vsI();
        }

        public final int getTextHandleMove-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getTextHandleMove-5zf0vsI();
        }

        public final int getToggleOff-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getToggleOff-5zf0vsI();
        }

        public final int getToggleOn-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getToggleOn-5zf0vsI();
        }

        public final int getVirtualKey-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getVirtualKey-5zf0vsI();
        }

        public final List values() {
            return CollectionsKt.listOf(new HapticFeedbackType[]{HapticFeedbackType.box-impl(this.getConfirm-5zf0vsI()), HapticFeedbackType.box-impl(this.getContextClick-5zf0vsI()), HapticFeedbackType.box-impl(this.getGestureEnd-5zf0vsI()), HapticFeedbackType.box-impl(this.getGestureThresholdActivate-5zf0vsI()), HapticFeedbackType.box-impl(this.getKeyboardTap-5zf0vsI()), HapticFeedbackType.box-impl(this.getLongPress-5zf0vsI()), HapticFeedbackType.box-impl(this.getReject-5zf0vsI()), HapticFeedbackType.box-impl(this.getSegmentFrequentTick-5zf0vsI()), HapticFeedbackType.box-impl(this.getSegmentTick-5zf0vsI()), HapticFeedbackType.box-impl(this.getTextHandleMove-5zf0vsI()), HapticFeedbackType.box-impl(this.getToggleOff-5zf0vsI()), HapticFeedbackType.box-impl(this.getToggleOn-5zf0vsI()), HapticFeedbackType.box-impl(this.getVirtualKey-5zf0vsI())});
        }
    }

    public static final Companion Companion;
    private final int value;

    static {
        HapticFeedbackType.Companion = new Companion(null);
    }

    private HapticFeedbackType(int arg1) {
        super();
        this.value = arg1;
    }

    public static final HapticFeedbackType box-impl(int arg1) {
        return new HapticFeedbackType(arg1);
    }

    public static int constructor-impl(int arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return HapticFeedbackType.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(int arg2, Object arg3) {
        if(!(arg3 instanceof HapticFeedbackType)) {
            return 0;
        }

        if(arg2 != ((HapticFeedbackType)arg3).unbox-impl()) {
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
        return HapticFeedbackType.hashCode-impl(this.value);
    }

    public static int hashCode-impl(int arg0) {
        return Integer.hashCode(arg0);
    }

    public String toString() {
        return HapticFeedbackType.toString-impl(this.value);
    }

    public static String toString-impl(int arg2) {
        Companion v0 = HapticFeedbackType.Companion;
        if(HapticFeedbackType.equals-impl0(arg2, v0.getConfirm-5zf0vsI())) {
            return "Confirm";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getContextClick-5zf0vsI())) {
            return "ContextClick";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getGestureEnd-5zf0vsI())) {
            return "GestureEnd";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getGestureThresholdActivate-5zf0vsI())) {
            return "GestureThresholdActivate";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getKeyboardTap-5zf0vsI())) {
            return "KeyboardTap";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getLongPress-5zf0vsI())) {
            return "LongPress";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getReject-5zf0vsI())) {
            return "Reject";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getSegmentFrequentTick-5zf0vsI())) {
            return "SegmentFrequentTick";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getSegmentTick-5zf0vsI())) {
            return "SegmentTick";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getTextHandleMove-5zf0vsI())) {
            return "TextHandleMove";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getToggleOff-5zf0vsI())) {
            return "ToggleOff";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getToggleOn-5zf0vsI())) {
            return "ToggleOn";
        }

        if(HapticFeedbackType.equals-impl0(arg2, v0.getVirtualKey-5zf0vsI())) {
            return "VirtualKey";
        }

        return "Invalid";
    }

    public final int unbox-impl() {
        return this.value;
    }
}

