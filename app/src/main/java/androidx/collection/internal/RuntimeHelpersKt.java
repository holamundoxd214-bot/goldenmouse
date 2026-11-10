package androidx.collection.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\u001A-\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A-\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0000\u001A\u0002\u0010\u0001\u001A\u0010\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A\u0010\u0010\n\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A\u0010\u0010\u000B\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A\u0010\u0010\f\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u0006H\u0000\u001A\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\u0006H\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000F"}, d2={"checkPrecondition", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "requirePrecondition", "throwIllegalArgumentException", "message", "throwIllegalStateException", "throwIndexOutOfBoundsException", "throwNoSuchElementException", "throwNoSuchElementExceptionForInline", "", "collection"}, k=2, mv={1, 9, 0}, xi=0x30) public final class RuntimeHelpersKt {
    public static final void checkPrecondition(boolean arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(!arg1) {
            RuntimeHelpersKt.throwIllegalStateException(arg2.invoke());
        }
    }

    public static final void requirePrecondition(boolean arg1, Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "lazyMessage");
        if(!arg1) {
            RuntimeHelpersKt.throwIllegalArgumentException(arg2.invoke());
        }
    }

    public static final void throwIllegalArgumentException(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new IllegalArgumentException(arg1);
    }

    public static final void throwIllegalStateException(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new IllegalStateException(arg1);
    }

    public static final void throwIndexOutOfBoundsException(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new IndexOutOfBoundsException(arg1);
    }

    public static final void throwNoSuchElementException(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new NoSuchElementException(arg1);
    }

    public static final Void throwNoSuchElementExceptionForInline(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "message");
        throw new NoSuchElementException(arg1);
    }
}

