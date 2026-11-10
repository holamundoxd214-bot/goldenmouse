package kotlin.time;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\n\u0010\u0002\u001A\u00020\u0003H\u0080\u0080\u0004\u001A\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0003H\u0080\u0080\u0004\"\u000F\u0010\u0000\u001A\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"systemClock", "Lkotlin/time/Clock;", "systemClockNow", "Lkotlin/time/Instant;", "serializedInstant", "", "instant", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class InstantJvmKt {
    private static final Clock systemClock;

    static {
        InstantJvmKt.systemClock = PlatformImplementationsKt.IMPLEMENTATIONS.getSystemClock();
    }

    public static final Object serializedInstant(Instant arg3) {
        Intrinsics.checkNotNullParameter(arg3, "instant");
        return new InstantSerialized(arg3.getEpochSeconds(), arg3.getNanosecondsOfSecond());
    }

    public static final Instant systemClockNow() {
        return InstantJvmKt.systemClock.now();
    }
}

