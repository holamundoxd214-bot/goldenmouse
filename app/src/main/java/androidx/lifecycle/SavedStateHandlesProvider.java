package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0013\u001A\u00060\u000Bj\u0002`\fH\u0016J\u0006\u0010\u0014\u001A\u00020\u0015J\u0016\u0010\u0016\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f2\u0006\u0010\u0017\u001A\u00020\u0018R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001B\u0010\r\u001A\u00020\u000E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0019"}, d2={"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "viewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "restored", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "viewModel", "Landroidx/lifecycle/SavedStateHandlesVM;", "getViewModel", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel$delegate", "Lkotlin/Lazy;", "saveState", "performRestore", "", "consumeRestoredStateForKey", "key", "", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SavedStateHandlesProvider implements SavedStateProvider {
    private boolean restored;
    private Bundle restoredState;
    private final SavedStateRegistry savedStateRegistry;
    private final Lazy viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry arg2, ViewModelStoreOwner arg3) {
        Intrinsics.checkNotNullParameter(arg2, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(arg3, "viewModelStoreOwner");
        super();
        this.savedStateRegistry = arg2;
        this.viewModel$delegate = LazyKt.lazy(new SavedStateHandlesProvider$$ExternalSyntheticLambda0(arg3));
    }

    public final Bundle consumeRestoredStateForKey(String arg8) {
        Object[] v2_4;
        Intrinsics.checkNotNullParameter(arg8, "key");
        this.performRestore();
        Bundle v0 = this.restoredState;
        Bundle v1 = null;
        if(v0 == null) {
            return v1;
        }

        if(!SavedStateReader.contains-impl(SavedStateReader.constructor-impl(v0), arg8)) {
            return v1;
        }

        Bundle v2 = SavedStateReader.getSavedStateOrNull-impl(SavedStateReader.constructor-impl(v0), arg8);
        if(v2 == null) {
            Map v2_1 = MapsKt.emptyMap();
            if(v2_1.isEmpty()) {
                Pair[] v2_2 = new Pair[0];
            }
            else {
                ArrayList v3 = new ArrayList(v2_1.size());
                Iterator v2_3 = v2_1.entrySet().iterator();
                while(v2_3.hasNext()) {
                    Object v5 = v2_3.next();
                    ((Collection)v3).add(TuplesKt.to(((Map$Entry)v5).getKey(), ((Map$Entry)v5).getValue()));
                }

                v2_4 = ((Collection)v3).toArray(new Pair[0]);
            }

            v2 = BundleKt.bundleOf(Arrays.copyOf(v2_4, ((Pair[])v2_4).length));
            SavedStateWriter.constructor-impl(v2);
        }

        SavedStateWriter.remove-impl(SavedStateWriter.constructor-impl(v0), arg8);
        if(SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(v0))) {
            this.restoredState = v1;
        }

        return v2;
    }

    private final SavedStateHandlesVM getViewModel() {
        return this.viewModel$delegate.getValue();
    }

    public final void performRestore() {
        Object[] v1_3;
        if(!this.restored) {
            Bundle v0 = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Map v1 = MapsKt.emptyMap();
            if(v1.isEmpty()) {
                Pair[] v1_1 = new Pair[0];
            }
            else {
                ArrayList v2 = new ArrayList(v1.size());
                Iterator v1_2 = v1.entrySet().iterator();
                while(v1_2.hasNext()) {
                    Object v4 = v1_2.next();
                    ((Collection)v2).add(TuplesKt.to(((Map$Entry)v4).getKey(), ((Map$Entry)v4).getValue()));
                }

                v1_3 = ((Collection)v2).toArray(new Pair[0]);
            }

            Bundle v1_4 = BundleKt.bundleOf(Arrays.copyOf(v1_3, ((Pair[])v1_3).length));
            Bundle v2_1 = SavedStateWriter.constructor-impl(v1_4);
            Bundle v3 = this.restoredState;
            if(v3 != null) {
                SavedStateWriter.putAll-impl(v2_1, v3);
            }

            if(v0 != null) {
                SavedStateWriter.putAll-impl(v2_1, v0);
            }

            this.restoredState = v1_4;
            this.restored = true;
            this.getViewModel();
        }
    }

    public Bundle saveState() {
        Pair[] v0_1;
        Map v0 = MapsKt.emptyMap();
        if(v0.isEmpty()) {
            v0_1 = new Pair[0];
        }
        else {
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_2 = v0.entrySet().iterator();
            while(v0_2.hasNext()) {
                Object v3 = v0_2.next();
                ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
            }

            Object[] v0_3 = ((Collection)v1).toArray(new Pair[0]);
        }

        Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(((Object[])v0_1), v0_1.length));
        Bundle v1_1 = SavedStateWriter.constructor-impl(v0_4);
        Bundle v3_1 = this.restoredState;
        if(v3_1 != null) {
            SavedStateWriter.putAll-impl(v1_1, v3_1);
        }

        Iterator v3_2 = this.getViewModel().getHandles().entrySet().iterator();
        while(v3_2.hasNext()) {
            Object v4 = v3_2.next();
            Object v5 = ((Map$Entry)v4).getKey();
            Bundle v4_1 = ((Map$Entry)v4).getValue().savedStateProvider().saveState();
            if(SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(v4_1))) {
                continue;
            }

            SavedStateWriter.putSavedState-impl(v1_1, ((String)v5), v4_1);
        }

        this.restored = false;
        return v0_4;
    }

    static final SavedStateHandlesVM viewModel_delegate$lambda$0(ViewModelStoreOwner arg0) {
        return SavedStateHandleSupport.getSavedStateHandlesVM(arg0);
    }
}

