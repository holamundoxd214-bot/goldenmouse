package androidx.compose.runtime.composer.gapbuffer.changelist;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005H&¨\u0006\u0007"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/changelist/OperationsDebugStringFormattable;", "", "<init>", "()V", "toDebugString", "", "linePrefix", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public abstract class OperationsDebugStringFormattable {
    public static final int $stable;

    static {
    }

    public OperationsDebugStringFormattable() {
        super();
    }

    public abstract String toDebugString(String arg1);

    public static String toDebugString$default(OperationsDebugStringFormattable arg0, String arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            if((arg2 & 1) != 0) {
                arg1 = "  ";
            }

            return arg0.toDebugString(arg1);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toDebugString");
    }
}

