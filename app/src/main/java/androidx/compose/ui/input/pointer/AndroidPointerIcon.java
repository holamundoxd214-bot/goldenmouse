package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/compose/ui/input/pointer/AndroidPointerIcon;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "pointerIcon", "Landroid/view/PointerIcon;", "<init>", "(Landroid/view/PointerIcon;)V", "getPointerIcon", "()Landroid/view/PointerIcon;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPointerIcon implements PointerIcon {
    public static final int $stable;
    private final android.view.PointerIcon pointerIcon;

    static {
    }

    public AndroidPointerIcon(android.view.PointerIcon arg1) {
        super();
        this.pointerIcon = arg1;
    }

    public boolean equals(Object arg3) {
        if(this == (((AndroidPointerIcon)arg3))) {
            return 1;
        }

        Class v0 = this.getClass();
        if(arg3 != null) {
            Class v1 = arg3.getClass();
        }
        else {
            Object v1_1 = null;
        }

        if(!Intrinsics.areEqual(v0, v1)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIcon");
        return Intrinsics.areEqual(this.pointerIcon, ((AndroidPointerIcon)arg3).pointerIcon);
    }

    public final android.view.PointerIcon getPointerIcon() {
        return this.pointerIcon;
    }

    public int hashCode() {
        return this.pointerIcon.hashCode();
    }

    public String toString() {
        return "AndroidPointerIcon(pointerIcon=" + this.pointerIcon + ')';
    }
}

