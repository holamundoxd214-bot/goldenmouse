package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\u0003H\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/compose/ui/input/pointer/AndroidPointerIconType;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "type", "", "<init>", "(I)V", "getType", "()I", "equals", "", "other", "", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AndroidPointerIconType implements PointerIcon {
    public static final int $stable;
    private final int type;

    static {
    }

    public AndroidPointerIconType(int arg1) {
        super();
        this.type = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((AndroidPointerIconType)arg4))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg4 != null) {
            Class v2 = arg4.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2_1)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.AndroidPointerIconType");
        if(this.type != ((AndroidPointerIconType)arg4).type) {
            return 0;
        }

        return 1;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type;
    }

    public String toString() {
        return "AndroidPointerIcon(type=" + this.type + ')';
    }
}

