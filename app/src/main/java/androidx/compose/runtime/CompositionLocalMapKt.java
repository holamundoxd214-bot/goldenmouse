package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A=\u0010\u0000\u001A\u00020\u0001*\u00020\u00012.\u0010\u0002\u001A*\u0012 \u0012\u001E\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00070\u0004\u0012\u0004\u0012\u00020\b0\u0003H\u0080\b\u001A \u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u000B*\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0005H\u0000\u001A%\u0010\r\u001A\u0002H\u000B\"\u0004\b\u0000\u0010\u000B*\u00020\u00012\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u000B0\u0005H\u0000¢\u0006\u0002\u0010\u000E\u001A3\u0010\u000F\u001A\u00020\u00012\u0012\u0010\u0010\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00120\u00112\u0006\u0010\u0013\u001A\u00020\u00012\b\b\u0002\u0010\u0014\u001A\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2={"mutate", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "mutator", "Lkotlin/Function1;", "", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/ValueHolder;", "", "contains", "", "T", "key", "read", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "updateCompositionMap", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "previous", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/PersistentCompositionLocalMap;Landroidx/compose/runtime/PersistentCompositionLocalMap;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionLocalMapKt {
    public static final boolean contains(PersistentCompositionLocalMap arg1, CompositionLocal arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        return arg1.containsKey(arg2);
    }

    public static final PersistentCompositionLocalMap mutate(PersistentCompositionLocalMap arg0, Function1 arg1) {
        Builder v0 = arg0.builder();
        arg1.invoke(v0);
        return v0.build();
    }

    public static final Object read(PersistentCompositionLocalMap arg2, CompositionLocal arg3) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Object v0 = arg2.get(arg3);
        if(v0 == null) {
            ValueHolder v0_1 = arg3.getDefaultValueHolder$runtime();
        }

        return ((ValueHolder)v0).readValue(arg2);
    }

    public static final PersistentCompositionLocalMap updateCompositionMap(ProvidedValue[] arg7, PersistentCompositionLocalMap arg8, PersistentCompositionLocalMap arg9) {
        androidx.compose.runtime.internal.PersistentCompositionLocalHashMap$Builder v0 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf().builder();
        int v1 = arg7.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            ProvidedValue v3 = arg7[v2];
            CompositionLocal v4 = v3.getCompositionLocal();
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
            if((v3.getCanOverride()) || !CompositionLocalMapKt.contains(arg8, v4)) {
                Object v5 = ((PersistentMap)arg9).get(v4);
                Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
                v0.put(v4, ((ProvidableCompositionLocal)v4).updatedStateOf$runtime(v3, ((ValueHolder)v5)));
            }
        }

        return ((Builder)v0).build();
    }

    public static PersistentCompositionLocalMap updateCompositionMap$default(ProvidedValue[] arg0, PersistentCompositionLocalMap arg1, PersistentCompositionLocalMap arg2, int arg3, Object arg4) {
        PersistentCompositionLocalHashMap v2;
        if((arg3 & 4) != 0) {
            v2 = PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        }

        return CompositionLocalMapKt.updateCompositionMap(arg0, arg1, ((PersistentCompositionLocalMap)v2));
    }
}

