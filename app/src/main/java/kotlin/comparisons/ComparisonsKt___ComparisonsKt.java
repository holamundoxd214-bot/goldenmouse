package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\u001AI\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001AA\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0006\u0010\u0003\u001A\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001AM\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000B\"\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\f\u001AI\u0010\r\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0006\u0010\u0003\u001A\u0002H\u00012\u0006\u0010\u0004\u001A\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001AA\u0010\r\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0006\u0010\u0003\u001A\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001AM\u0010\r\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u0002H\u00012\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u000B\"\u0002H\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`\u0007H\u0087\u0080\u0004¢\u0006\u0002\u0010\f¨\u0006\u000E"}, d2={"maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/comparisons/ComparisonsKt") class ComparisonsKt___ComparisonsKt extends ComparisonsKt___ComparisonsJvmKt {
    public ComparisonsKt___ComparisonsKt() {
        super();
    }

    public static final Object maxOf(Object arg1, Object arg2, Object arg3, Comparator arg4) {
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        return ComparisonsKt.maxOf(arg1, ComparisonsKt.maxOf(arg2, arg3, arg4), arg4);
    }

    public static final Object maxOf(Object arg1, Object arg2, Comparator arg3) {
        Intrinsics.checkNotNullParameter(arg3, "comparator");
        if(arg3.compare(arg1, arg2) >= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final Object maxOf(Object arg4, Object[] arg5, Comparator arg6) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        Intrinsics.checkNotNullParameter(arg6, "comparator");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg5[v1];
            if(arg6.compare(arg4, v2) < 0) {
                arg4 = v2;
            }
        }

        return arg4;
    }

    public static final Object minOf(Object arg1, Object arg2, Object arg3, Comparator arg4) {
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        return ComparisonsKt.minOf(arg1, ComparisonsKt.minOf(arg2, arg3, arg4), arg4);
    }

    public static final Object minOf(Object arg1, Object arg2, Comparator arg3) {
        Intrinsics.checkNotNullParameter(arg3, "comparator");
        if(arg3.compare(arg1, arg2) <= 0) {
            return arg1;
        }

        return arg2;
    }

    public static final Object minOf(Object arg4, Object[] arg5, Comparator arg6) {
        Intrinsics.checkNotNullParameter(arg5, "other");
        Intrinsics.checkNotNullParameter(arg6, "comparator");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg5[v1];
            if(arg6.compare(arg4, v2) > 0) {
                arg4 = v2;
            }
        }

        return arg4;
    }
}

