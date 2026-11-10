package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001A\u00020\nH\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/internal/IntRef;", "", "element", "", "<init>", "(I)V", "getElement", "()I", "setElement", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class IntRef {
    public static final int $stable = 8;
    private int element;

    static {
    }

    public IntRef(int arg1) {
        super();
        this.element = arg1;
    }

    public IntRef(int arg1, int arg2, DefaultConstructorMarker arg3) {
        this(0);
    }

    public IntRef() {
        this(0, 1, null);
    }

    public final int getElement() {
        return this.element;
    }

    public final void setElement(int arg1) {
        this.element = arg1;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("IntRef(element = ").append(this.element).append(")@");
        String v2 = Integer.toString(this.hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        return v0.append(v2).toString();
    }
}

