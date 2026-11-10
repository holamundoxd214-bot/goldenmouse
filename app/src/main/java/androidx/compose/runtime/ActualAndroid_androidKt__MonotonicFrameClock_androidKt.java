package androidx.compose.runtime;

import android.os.Looper;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"!\u0010\u0002\u001A\u00020\u00038FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2={"DisallowDefaultMonotonicFrameClock", "", "DefaultMonotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/ActualAndroid_androidKt") final class ActualAndroid_androidKt__MonotonicFrameClock_androidKt {
    private static final Lazy DefaultMonotonicFrameClock$delegate = null;
    private static final boolean DisallowDefaultMonotonicFrameClock = false;

    public static MonotonicFrameClock $r8$lambda$bxDx1PK51Zr7g4x1LW4y-GPauuI() {
        return ActualAndroid_androidKt__MonotonicFrameClock_androidKt.DefaultMonotonicFrameClock_delegate$lambda$0$ActualAndroid_androidKt__MonotonicFrameClock_androidKt();
    }

    static {
        ActualAndroid_androidKt__MonotonicFrameClock_androidKt.DefaultMonotonicFrameClock$delegate = LazyKt.lazy(new ActualAndroid_androidKt__MonotonicFrameClock_androidKt$$ExternalSyntheticLambda0());
    }

    private static final MonotonicFrameClock DefaultMonotonicFrameClock_delegate$lambda$0$ActualAndroid_androidKt__MonotonicFrameClock_androidKt() {
        DefaultChoreographerFrameClock v0;
        if(Looper.getMainLooper() != null) {
            v0 = DefaultChoreographerFrameClock.INSTANCE;
        }
        else {
            FallbackFrameClock v0_1 = FallbackFrameClock.INSTANCE;
        }

        return ((MonotonicFrameClock)v0);
    }

    public static final MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return ActualAndroid_androidKt__MonotonicFrameClock_androidKt.DefaultMonotonicFrameClock$delegate.getValue();
    }

    @Deprecated(message="MonotonicFrameClocks are not globally applicable across platforms. Use an appropriate local clock.") public static void getDefaultMonotonicFrameClock$annotations() {
    }
}

