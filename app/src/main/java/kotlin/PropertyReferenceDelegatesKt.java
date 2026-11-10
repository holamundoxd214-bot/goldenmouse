package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A5\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0007\u001A=\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\n2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00042\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000B\u001A\u0002H\u0001H\u0087\u008A\u0004¢\u0006\u0002\u0010\f\u001A?\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00010\u000E2\u0006\u0010\u0003\u001A\u0002H\r2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0006H\u0087\u008A\u0004¢\u0006\u0002\u0010\u000F\u001AG\u0010\b\u001A\u00020\t\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00010\u00102\u0006\u0010\u0003\u001A\u0002H\r2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000B\u001A\u0002H\u0001H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2={"getValue", "V", "Lkotlin/reflect/KProperty0;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "Lkotlin/reflect/KMutableProperty0;", "value", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "T", "Lkotlin/reflect/KProperty1;", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/reflect/KMutableProperty1;", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class PropertyReferenceDelegatesKt {
    private static final Object getValue(KProperty0 arg0, Object arg1, KProperty arg2) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "property");
        return arg0.get();
    }

    private static final Object getValue(KProperty1 arg1, Object arg2, KProperty arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "property");
        return arg1.get(arg2);
    }

    private static final void setValue(KMutableProperty0 arg0, Object arg1, KProperty arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "property");
        arg0.set(arg3);
    }

    private static final void setValue(KMutableProperty1 arg1, Object arg2, KProperty arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "property");
        arg1.set(arg2, arg4);
    }
}

