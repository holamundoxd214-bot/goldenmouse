package androidx.core.util;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A*\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n¢\u0006\u0002\u0010\u0004\u001A*\u0010\u0005\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n¢\u0006\u0002\u0010\u0004\u001A1\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\b\u001A1\u0010\b\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u001A*\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0087\n¢\u0006\u0002\u0010\n\u001A*\u0010\u0005\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0087\n¢\u0006\u0002\u0010\n\u001A1\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0086\b\u001A1\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b¨\u0006\f"}, d2={"component1", "F", "S", "Landroidx/core/util/Pair;", "(Landroidx/core/util/Pair;)Ljava/lang/Object;", "component2", "toKotlinPair", "Lkotlin/Pair;", "toAndroidXPair", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "toAndroidPair", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class PairKt {
    public static final Object component1(Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.first;
    }

    public static final Object component1(androidx.core.util.Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.first;
    }

    public static final Object component2(Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.second;
    }

    public static final Object component2(androidx.core.util.Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.second;
    }

    public static final Pair toAndroidPair(kotlin.Pair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Pair(arg2.getFirst(), arg2.getSecond());
    }

    public static final androidx.core.util.Pair toAndroidXPair(kotlin.Pair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new androidx.core.util.Pair(arg2.getFirst(), arg2.getSecond());
    }

    public static final kotlin.Pair toKotlinPair(Pair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new kotlin.Pair(arg2.first, arg2.second);
    }

    public static final kotlin.Pair toKotlinPair(androidx.core.util.Pair arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new kotlin.Pair(arg2.first, arg2.second);
    }
}

