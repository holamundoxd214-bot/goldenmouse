package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000.\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001AL\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u00032\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\tH\u0087\u008A\u0004¢\u0006\u0002\u0010\n\u001AP\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u0002H\u0002*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u000B\b\u0001\u0012\u0007H\u0002¢\u0006\u0002\b\u00050\u000B2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\tH\u0087\u008A\u0004¢\u0006\u0004\b\f\u0010\n\u001AG\u0010\r\u001A\u00020\u000E\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0004\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000B2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000F\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2={"getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class MapAccessorsKt {
    private static final Object getValue(Map arg0, Object arg1, KProperty arg2) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "property");
        return MapsKt.getOrImplicitDefaultNullable(arg0, arg2.getName());
    }

    private static final Object getVar(Map arg0, Object arg1, KProperty arg2) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "property");
        return MapsKt.getOrImplicitDefaultNullable(arg0, arg2.getName());
    }

    private static final void setValue(Map arg0, Object arg1, KProperty arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "property");
        arg0.put(arg2.getName(), arg3);
    }
}

