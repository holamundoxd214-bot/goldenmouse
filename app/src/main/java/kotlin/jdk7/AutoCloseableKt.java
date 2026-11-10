package kotlin.jdk7;

import androidx.activity.OnBackPressedCallback$$ExternalSyntheticThrowIAE2;
import kotlin.ExceptionsKt;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u001A!\u0010\u0000\u001A\u00060\u0001j\u0002`\u00052\u000E\b\u0004\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001AO\u0010\t\u001A\u0002H\n\"\u0010\b\u0000\u0010\u000B*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0005\"\u0004\b\u0001\u0010\n*\u0002H\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u000B\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0088\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000E\u001A \u0010\u000F\u001A\u00020\b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0081\u0080\u0004*\u001A\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2={"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lkotlin/SinceKotlin;", "version", "2.0", "Lkotlin/AutoCloseable;", "closeAction", "Lkotlin/Function0;", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closeFinally", "cause", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, pn="kotlin", xi=0x30) public final class AutoCloseableKt {
    private static final AutoCloseable AutoCloseable(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "closeAction");
        return new AutoCloseableKt$AutoCloseable$1(arg1);
    }

    public static void AutoCloseable$annotations() {
    }

    public static final void closeFinally(AutoCloseable arg0, Throwable arg1) {
        if(arg0 != null) {
            if(arg1 == null) {
                OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg0);
                return;
            }

            try {
                OnBackPressedCallback$$ExternalSyntheticThrowIAE2.m(arg0);
                return;
            }
            catch(Throwable v0) {
                ExceptionsKt.addSuppressed(arg1, v0);
            }
        }
    }

    @IgnorableReturnValue private static final Object use(AutoCloseable arg1, Function1 arg2) {
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
                AutoCloseableKt.closeFinally(arg1, v2);
                throw v0;
            }
        }

        AutoCloseableKt.closeFinally(arg1, null);
        return v2_1;
    }
}

