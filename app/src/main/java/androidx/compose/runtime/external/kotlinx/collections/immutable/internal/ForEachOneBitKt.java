package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AE\u0010\u0000\u001A\u00020\u0001*\u00020\u000226\u0010\u0003\u001A2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\b¨\u0006\t"}, d2={"forEachOneBit", "", "", "body", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "mask", "index", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ForEachOneBitKt {
    public static final void forEachOneBit(int arg4, Function2 arg5) {
        int v0 = 0;
        while(arg4 != 0) {
            int v1 = Integer.lowestOneBit(arg4);
            arg5.invoke(Integer.valueOf(v1), Integer.valueOf(v0));
            ++v0;
            arg4 ^= v1;
        }
    }
}

