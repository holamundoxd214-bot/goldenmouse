package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\u0016\b\u0002\u0010\u0002\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0011\u001A\u00020\fH\u0007J\u0011\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0004H\u0087\u0002J)\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u0002H\u0019H\u0007¢\u0006\u0002\u0010\u001BJ)\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u00190\u000E\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u001A\u001A\u0002H\u0019H\u0007¢\u0006\u0002\u0010\u001DJ\u000E\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00040\u001FH\u0007J\u001E\u0010 \u001A\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001A\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010!J&\u0010\"\u001A\u00020#\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001A\u00020\u00042\b\u0010$\u001A\u0004\u0018\u0001H\u0019H\u0087\u0002¢\u0006\u0002\u0010%J\u001D\u0010&\u001A\u0004\u0018\u0001H\u0019\"\u0004\b\u0000\u0010\u00192\u0006\u0010\u0016\u001A\u00020\u0004H\u0007¢\u0006\u0002\u0010!J\u0018\u0010\'\u001A\u00020#2\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\fH\u0007J\u0010\u0010)\u001A\u00020#2\u0006\u0010\u0016\u001A\u00020\u0004H\u0007R\u001F\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000E0\bX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u000F\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000E0\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2={"Landroidx/lifecycle/internal/SavedStateHandleImpl;", "", "initialState", "", "", "<init>", "(Ljava/util/Map;)V", "regular", "", "getRegular", "()Ljava/util/Map;", "providers", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "flows", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mutableFlows", "getMutableFlows", "savedStateProvider", "getSavedStateProvider", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "", "key", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "T", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "getMutableStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "keys", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "setSavedStateProvider", "provider", "clearSavedStateProvider", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandleImpl {
    private final Map flows;
    private final Map mutableFlows;
    private final Map providers;
    private final Map regular;
    private final SavedStateProvider savedStateProvider;

    public SavedStateHandleImpl(Map arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = MapsKt.emptyMap();
        }

        this(arg1);
    }

    public SavedStateHandleImpl(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initialState");
        super();
        this.regular = MapsKt.toMutableMap(arg2);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandleImpl$$ExternalSyntheticLambda0(this);
    }

    public SavedStateHandleImpl() {
        this(null, 1, null);
    }

    public final void clearSavedStateProvider(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.providers.remove(arg2);
    }

    public final boolean contains(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return this.regular.containsKey(arg2);
    }

    public final Object get(String arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "key");
        try {
            Object v0 = this.mutableFlows.get(arg2);
            if(v0 != null) {
                v0 = ((MutableStateFlow)v0).getValue();
                if(v0 == null) {
                }
                else {
                    return v0;
                }
            }

            v1 = this.regular.get(arg2);
            return v1;
        }
        catch(ClassCastException ) {
            ((SavedStateHandleImpl)v1).remove(arg2);
            return null;
        }
    }

    public final Map getMutableFlows() {
        return this.mutableFlows;
    }

    public final MutableStateFlow getMutableStateFlow(String arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Map v0 = this.mutableFlows;
        Object v1 = v0.get(arg3);
        if(v1 == null) {
            if(!this.regular.containsKey(arg3)) {
                this.regular.put(arg3, arg4);
            }

            MutableStateFlow v1_1 = StateFlowKt.MutableStateFlow(this.regular.get(arg3));
            v0.put(arg3, v1_1);
        }

        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getMutableStateFlow>");
        return ((MutableStateFlow)v1);
    }

    public final Map getRegular() {
        return this.regular;
    }

    public final SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    public final StateFlow getStateFlow(String arg3, Object arg4) {
        MutableStateFlow v1_1;
        Intrinsics.checkNotNullParameter(arg3, "key");
        Map v0 = this.flows;
        Object v1 = v0.get(arg3);
        if(v1 == null) {
            if(!this.regular.containsKey(arg3)) {
                this.regular.put(arg3, arg4);
            }

            v1_1 = StateFlowKt.MutableStateFlow(this.regular.get(arg3));
            v0.put(arg3, v1_1);
        }

        StateFlow v2 = FlowKt.asStateFlow(v1_1);
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getStateFlow>");
        return v2;
    }

    public final Set keys() {
        return SetsKt.plus(this.regular.keySet(), this.providers.keySet());
    }

    public final Object remove(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Object v0 = this.regular.remove(arg3);
        this.flows.remove(arg3);
        this.mutableFlows.remove(arg3);
        return v0;
    }

    public final SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    static final Bundle savedStateProvider$lambda$0(SavedStateHandleImpl arg4) {
        Pair[] v4_1;
        Object v1;
        Iterator v0 = MapsKt.toMap(arg4.mutableFlows).entrySet().iterator();
        while(v0.hasNext()) {
            v1 = v0.next();
            arg4.set(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue().getValue());
        }

        v0 = MapsKt.toMap(arg4.providers).entrySet().iterator();
        while(v0.hasNext()) {
            v1 = v0.next();
            arg4.set(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue().saveState());
        }

        Map v4 = arg4.regular;
        if(v4.isEmpty()) {
            v4_1 = new Pair[0];
        }
        else {
            ArrayList v0_1 = new ArrayList(v4.size());
            Iterator v4_2 = v4.entrySet().iterator();
            while(v4_2.hasNext()) {
                Object v2 = v4_2.next();
                ((Collection)v0_1).add(TuplesKt.to(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue()));
            }

            Object[] v4_3 = ((Collection)v0_1).toArray(new Pair[0]);
        }

        Bundle v4_4 = BundleKt.bundleOf(Arrays.copyOf(((Object[])v4_1), v4_1.length));
        SavedStateWriter.constructor-impl(v4_4);
        return v4_4;
    }

    public final void set(String arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        this.regular.put(arg2, arg3);
        Object v0 = this.flows.get(arg2);
        if(v0 != null) {
            ((MutableStateFlow)v0).setValue(arg3);
        }

        Object v1 = this.mutableFlows.get(arg2);
        if(v1 != null) {
            ((MutableStateFlow)v1).setValue(arg3);
        }
    }

    public final void setSavedStateProvider(String arg2, SavedStateProvider arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "provider");
        this.providers.put(arg2, arg3);
    }
}

