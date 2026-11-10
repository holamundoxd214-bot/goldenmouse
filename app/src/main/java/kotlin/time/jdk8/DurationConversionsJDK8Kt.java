package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0003\u001A\u0015\u0010\u0004\u001A\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"toKotlinDuration", "Lkotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, k=2, mv={2, 3, 0}, pn="kotlin.time", xi=0x30) public final class DurationConversionsJDK8Kt {
    private static final Duration toJavaDuration-LRDsOJo(long arg2) {
        Duration v2 = Duration.ofSeconds(kotlin.time.Duration.getInWholeSeconds-impl(arg2), ((long)kotlin.time.Duration.getNanosecondsComponent-impl(arg2)));
        Intrinsics.checkNotNullExpressionValue(v2, "toComponents-impl(...)");
        return v2;
    }

    private static final long toKotlinDuration(Duration arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        return kotlin.time.Duration.plus-LRDsOJo(DurationKt.toDuration(arg4.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(arg4.getNano(), DurationUnit.NANOSECONDS));
    }
}

