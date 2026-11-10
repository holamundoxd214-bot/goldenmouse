package kotlin;

import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000F\n\u0002\b\u0003\u001A\'\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001A\u0002H\u0002H\u0087\u008C\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2={"compareTo", "", "T", "", "other", "(Ljava/lang/Comparable;Ljava/lang/Object;)I", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CompareToKt {
    private static final int compareTo(Comparable arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.compareTo(arg2);
    }
}

