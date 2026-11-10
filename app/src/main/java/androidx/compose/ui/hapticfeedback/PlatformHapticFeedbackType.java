package androidx.compose.ui.hapticfeedback;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001C\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u0013\u0010\u000B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001A\u0010\u0007R\u0013\u0010\u001B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001C\u0010\u0007R\u0013\u0010\u001D\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u001E\u0010\u0007R\u0013\u0010\u001F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b \u0010\u0007¨\u0006!"}, d2={"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedbackType;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformHapticFeedbackType {
    public static final int $stable;
    private static final int Confirm;
    private static final int ContextClick;
    private static final int GestureEnd;
    private static final int GestureThresholdActivate;
    public static final PlatformHapticFeedbackType INSTANCE;
    private static final int KeyboardTap;
    private static final int LongPress;
    private static final int Reject;
    private static final int SegmentFrequentTick;
    private static final int SegmentTick;
    private static final int TextHandleMove;
    private static final int ToggleOff;
    private static final int ToggleOn;
    private static final int VirtualKey;

    static {
        PlatformHapticFeedbackType.INSTANCE = new PlatformHapticFeedbackType();
        PlatformHapticFeedbackType.Confirm = HapticFeedbackType.constructor-impl(16);
        PlatformHapticFeedbackType.ContextClick = HapticFeedbackType.constructor-impl(6);
        PlatformHapticFeedbackType.GestureEnd = HapticFeedbackType.constructor-impl(13);
        PlatformHapticFeedbackType.GestureThresholdActivate = HapticFeedbackType.constructor-impl(23);
        PlatformHapticFeedbackType.KeyboardTap = HapticFeedbackType.constructor-impl(3);
        PlatformHapticFeedbackType.LongPress = HapticFeedbackType.constructor-impl(0);
        PlatformHapticFeedbackType.Reject = HapticFeedbackType.constructor-impl(17);
        PlatformHapticFeedbackType.SegmentFrequentTick = HapticFeedbackType.constructor-impl(27);
        PlatformHapticFeedbackType.SegmentTick = HapticFeedbackType.constructor-impl(26);
        PlatformHapticFeedbackType.TextHandleMove = HapticFeedbackType.constructor-impl(9);
        PlatformHapticFeedbackType.ToggleOff = HapticFeedbackType.constructor-impl(22);
        PlatformHapticFeedbackType.ToggleOn = HapticFeedbackType.constructor-impl(21);
        PlatformHapticFeedbackType.VirtualKey = HapticFeedbackType.constructor-impl(1);
    }

    private PlatformHapticFeedbackType() {
        super();
    }

    public final int getConfirm-5zf0vsI() {
        return PlatformHapticFeedbackType.Confirm;
    }

    public final int getContextClick-5zf0vsI() {
        return PlatformHapticFeedbackType.ContextClick;
    }

    public final int getGestureEnd-5zf0vsI() {
        return PlatformHapticFeedbackType.GestureEnd;
    }

    public final int getGestureThresholdActivate-5zf0vsI() {
        return PlatformHapticFeedbackType.GestureThresholdActivate;
    }

    public final int getKeyboardTap-5zf0vsI() {
        return PlatformHapticFeedbackType.KeyboardTap;
    }

    public final int getLongPress-5zf0vsI() {
        return PlatformHapticFeedbackType.LongPress;
    }

    public final int getReject-5zf0vsI() {
        return PlatformHapticFeedbackType.Reject;
    }

    public final int getSegmentFrequentTick-5zf0vsI() {
        return PlatformHapticFeedbackType.SegmentFrequentTick;
    }

    public final int getSegmentTick-5zf0vsI() {
        return PlatformHapticFeedbackType.SegmentTick;
    }

    public final int getTextHandleMove-5zf0vsI() {
        return PlatformHapticFeedbackType.TextHandleMove;
    }

    public final int getToggleOff-5zf0vsI() {
        return PlatformHapticFeedbackType.ToggleOff;
    }

    public final int getToggleOn-5zf0vsI() {
        return PlatformHapticFeedbackType.ToggleOn;
    }

    public final int getVirtualKey-5zf0vsI() {
        return PlatformHapticFeedbackType.VirtualKey;
    }
}

