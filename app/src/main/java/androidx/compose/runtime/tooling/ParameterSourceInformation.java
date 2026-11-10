package androidx.compose.runtime.tooling;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u000E"}, d2={"Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "", "sortedIndex", "", "name", "", "inlineClass", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getSortedIndex", "()I", "getName", "()Ljava/lang/String;", "getInlineClass", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ParameterSourceInformation {
    public static final int $stable;
    private final String inlineClass;
    private final String name;
    private final int sortedIndex;

    static {
    }

    public ParameterSourceInformation(int arg1, String arg2, String arg3) {
        super();
        this.sortedIndex = arg1;
        this.name = arg2;
        this.inlineClass = arg3;
    }

    public ParameterSourceInformation(int arg2, String arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        String v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = v0;
        }

        this(arg2, arg3, arg4);
    }

    public final String getInlineClass() {
        return this.inlineClass;
    }

    public final String getName() {
        return this.name;
    }

    public final int getSortedIndex() {
        return this.sortedIndex;
    }
}

