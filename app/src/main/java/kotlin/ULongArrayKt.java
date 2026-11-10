package kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A.\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001A\u001D\u0010\b\u001A\u00020\u00012\n\u0010\t\u001A\u00020\u0001\"\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0004\b\n\u0010\u000B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2={"ULongArray", "Lkotlin/ULongArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ULong;", "(ILkotlin/jvm/functions/Function1;)[J", "ulongArrayOf", "elements", "ulongArrayOf-QwZRm1k", "([J)[J", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ULongArrayKt {
    private static final long[] ULongArray(int arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "init");
        long[] v0 = new long[arg4];
        int v1;
        for(v1 = 0; v1 < arg4; ++v1) {
            v0[v1] = arg5.invoke(Integer.valueOf(v1)).unbox-impl();
        }

        return ULongArray.constructor-impl(v0);
    }

    private static final long[] ulongArrayOf-QwZRm1k(long[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return arg1;
    }
}

