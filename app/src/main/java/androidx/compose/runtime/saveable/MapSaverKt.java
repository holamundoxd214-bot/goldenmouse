package androidx.compose.runtime.saveable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001Ax\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u00022:\u0010\u0004\u001A6\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n0\u0005¢\u0006\u0002\b\f2\"\u0010\r\u001A\u001E\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000E¨\u0006\u000F"}, d2={"mapSaver", "Landroidx/compose/runtime/saveable/Saver;", "T", "", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "", "", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "runtime-saveable"}, k=2, mv={2, 1, 0}, xi=0x30) public final class MapSaverKt {
    public static final Saver mapSaver(Function2 arg1, Function1 arg2) {
        return ListSaverKt.listSaver(new MapSaverKt$$ExternalSyntheticLambda0(arg1), new MapSaverKt$$ExternalSyntheticLambda1(arg2));
    }

    static final List mapSaver$lambda$0(Function2 arg1, SaverScope arg2, Object arg3) {
        ArrayList v0 = new ArrayList();
        Iterator v1 = arg1.invoke(arg2, arg3).entrySet().iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            ((List)v0).add(((Map$Entry)v2).getKey());
            ((List)v0).add(((Map$Entry)v2).getValue());
        }

        return ((List)v0);
    }

    static final Object mapSaver$lambda$1(Function1 arg4, List arg5) {
        LinkedHashMap v0 = new LinkedHashMap();
        if(arg5.size() % 2 == 0) {
            int v1;
            for(v1 = 0; v1 < arg5.size(); v1 += 2) {
                Object v2 = arg5.get(v1);
                Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlin.String");
                ((Map)v0).put(v2, arg5.get(v1 + 1));
            }

            return arg4.invoke(v0);
        }

        throw new IllegalStateException("non-zero remainder".toString());
    }
}

