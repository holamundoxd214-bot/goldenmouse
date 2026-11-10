package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u0003H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000E"}, d2={"Landroidx/compose/ui/text/input/PlatformImeOptions;", "", "privateImeOptions", "", "<init>", "(Ljava/lang/String;)V", "getPrivateImeOptions", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PlatformImeOptions {
    public static final int $stable;
    private final String privateImeOptions;

    static {
    }

    public PlatformImeOptions() {
        this(null, 1, null);
    }

    public PlatformImeOptions(String arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public PlatformImeOptions(String arg1) {
        super();
        this.privateImeOptions = arg1;
    }

    public boolean equals(Object arg4) {
        if(this == (((PlatformImeOptions)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof PlatformImeOptions)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.privateImeOptions, ((PlatformImeOptions)arg4).privateImeOptions)) {
            return 0;
        }

        return 1;
    }

    public final String getPrivateImeOptions() {
        return this.privateImeOptions;
    }

    public int hashCode() {
        String v0 = this.privateImeOptions;
        if(v0 != null) {
            return v0.hashCode();
        }

        return 0;
    }

    public String toString() {
        return "PlatformImeOptions(privateImeOptions=" + this.privateImeOptions + ')';
    }
}

