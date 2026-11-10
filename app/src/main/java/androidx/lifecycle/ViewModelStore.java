package androidx.lifecycle;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\u00012\u0006\u0010\n\u001A\u00020\u0006H\u0007J\u0015\u0010\u000B\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0087\u0002J/\u0010\f\u001A\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u00012\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\r0\u000FH\u0007¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0007J\u0006\u0010\u0013\u001A\u00020\bJ\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u001C\u0010\u0004\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/lifecycle/ViewModelStore;", "", "<init>", "()V", "map", "", "Landroidx/lifecycle/ViewModel;", "put", "", "key", "viewModel", "get", "getOrPut", "T", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Landroidx/lifecycle/ViewModel;", "keys", "", "clear", "toString", "", "lifecycle-viewmodel"}, k=1, mv={2, 1, 0}, xi=0x30) public class ViewModelStore {
    private final Map map;

    public ViewModelStore() {
        super();
        this.map = new LinkedHashMap();
    }

    public final void clear() {
        Map v0 = MapsKt.toMap(this.map);
        this.map.clear();
        Iterator v1 = v0.values().iterator();
        while(v1.hasNext()) {
            v1.next().clear$lifecycle_viewmodel();
        }
    }

    public final ViewModel get(Object arg1) {
        return this.map.get(arg1);
    }

    public final ViewModel getOrPut(Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Map v1 = this.map;
        Object v0 = v1.get(arg2);
        if(v0 == null) {
            v0 = arg3.invoke();
            v1.put(arg2, v0);
        }

        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelStore.getOrPut");
        return ((ViewModel)v0);
    }

    public final Set keys() {
        return CollectionsKt.toSet(this.map.keySet());
    }

    public final void put(Object arg2, ViewModel arg3) {
        Intrinsics.checkNotNullParameter(arg3, "viewModel");
        Object v1 = this.map.put(arg2, arg3);
        if(v1 != null) {
            ((ViewModel)v1).clear$lifecycle_viewmodel();
        }
    }

    public String toString() {
        String v0 = Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName();
        if(v0 == null) {
            v0 = "ViewModelStore";
        }

        String v1 = Integer.toString(this.hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v0 + "@" + v1 + "(keys=" + this.keys() + ")";
    }
}

