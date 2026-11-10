package androidx.compose.runtime.tooling;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/tooling/LocationSourceInformation;", "", "lineNumber", "", "offset", "length", "isRepeatable", "", "<init>", "(IIIZ)V", "getLineNumber", "()I", "getOffset", "getLength", "()Z", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LocationSourceInformation {
    public static final int $stable;
    private final boolean isRepeatable;
    private final int length;
    private final int lineNumber;
    private final int offset;

    static {
    }

    public LocationSourceInformation(int arg1, int arg2, int arg3, boolean arg4) {
        super();
        this.lineNumber = arg1;
        this.offset = arg2;
        this.length = arg3;
        this.isRepeatable = arg4;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final boolean isRepeatable() {
        return this.isRepeatable;
    }
}

