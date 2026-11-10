package kotlin.time.jdk8;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004¨\u0006\u0004"}, d2={"toJavaInstant", "Ljava/time/Instant;", "Lkotlin/time/Instant;", "toKotlinInstant", "kotlin-stdlib-jdk8"}, k=2, mv={2, 3, 0}, pn="kotlin.time", xi=0x30) public final class InstantConversionsJDK8Kt {
    public static final Instant toJavaInstant(kotlin.time.Instant arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Instant v4 = Instant.ofEpochSecond(arg4.getEpochSeconds(), ((long)arg4.getNanosecondsOfSecond()));
        Intrinsics.checkNotNullExpressionValue(v4, "ofEpochSecond(...)");
        return v4;
    }

    public static final kotlin.time.Instant toKotlinInstant(Instant arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return kotlin.time.Instant.Companion.fromEpochSeconds(arg3.getEpochSecond(), arg3.getNano());
    }
}

