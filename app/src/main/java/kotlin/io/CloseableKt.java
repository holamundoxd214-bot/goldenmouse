package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001AI\u0010\u0000\u001A\u0002H\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0006\u001A\u001A\u0010\u0007\u001A\u00020\b*\u0004\u0018\u00010\u00032\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0081\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000B"}, d2={"use", "R", "T", "Ljava/io/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closeFinally", "", "cause", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CloseableKt {
    public static final void closeFinally(Closeable arg0, Throwable arg1) {
        if(arg0 != null) {
            if(arg1 == null) {
                arg0.close();
                return;
            }

            try {
                arg0.close();
                return;
            }
            catch(Throwable v0) {
                ExceptionsKt.addSuppressed(arg1, v0);
            }
        }
    }

    @IgnorableReturnValue private static final Object use(Closeable arg1, Function1 arg2) {
        Object v2_1;
        Intrinsics.checkNotNullParameter(arg2, "block");
        try {
            v2_1 = arg2.invoke(arg1);
        }
        catch(Throwable v2) {
            try {
                throw v2;
            }
            catch(Throwable v0) {
                CloseableKt.closeFinally(arg1, v2);
                throw v0;
            }
        }

        CloseableKt.closeFinally(arg1, null);
        return v2_1;
    }
}

