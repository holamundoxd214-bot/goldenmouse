package androidx.compose.ui.input.pointer;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005\"\u0014\u0010\u0006\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0014\u0010\t\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b\"\u0014\u0010\u000B\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\b\"\u0014\u0010\r\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\b¨\u0006\u000F"}, d2={"PointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "pointerIcon", "Landroid/view/PointerIcon;", "pointerIconType", "", "pointerIconDefault", "getPointerIconDefault", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "pointerIconCrosshair", "getPointerIconCrosshair", "pointerIconText", "getPointerIconText", "pointerIconHand", "getPointerIconHand", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PointerIcon_androidKt {
    private static final PointerIcon pointerIconCrosshair;
    private static final PointerIcon pointerIconDefault;
    private static final PointerIcon pointerIconHand;
    private static final PointerIcon pointerIconText;

    static {
        PointerIcon_androidKt.pointerIconDefault = new AndroidPointerIconType(1000);
        PointerIcon_androidKt.pointerIconCrosshair = new AndroidPointerIconType(1007);
        PointerIcon_androidKt.pointerIconText = new AndroidPointerIconType(0x3F0);
        PointerIcon_androidKt.pointerIconHand = new AndroidPointerIconType(1002);
    }

    public static final PointerIcon PointerIcon(int arg1) {
        return new AndroidPointerIconType(arg1);
    }

    public static final PointerIcon PointerIcon(android.view.PointerIcon arg1) {
        return new AndroidPointerIcon(arg1);
    }

    public static final PointerIcon getPointerIconCrosshair() {
        return PointerIcon_androidKt.pointerIconCrosshair;
    }

    public static final PointerIcon getPointerIconDefault() {
        return PointerIcon_androidKt.pointerIconDefault;
    }

    public static final PointerIcon getPointerIconHand() {
        return PointerIcon_androidKt.pointerIconHand;
    }

    public static final PointerIcon getPointerIconText() {
        return PointerIcon_androidKt.pointerIconText;
    }
}

