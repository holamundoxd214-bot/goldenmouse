package androidx.compose.runtime.saveable;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000B\u001A\u00020\u0007H\u0002J\u0018\u0010\u0011\u001A\u00020\r2\u000E\u0010\u0012\u001A\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014H\u0002J\u0011\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001CH\u0096\u0001J\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001E\u001A\u00020\u001FH\u0096\u0001J\u001D\u0010 \u001A\u0016\u0012\u0004\u0012\u00020\u001F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001C0\"0!H\u0096\u0001J!\u0010#\u001A\u00020$2\u0006\u0010\u001E\u001A\u00020\u001F2\u000E\u0010%\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001C0&H\u0096\u0001R\u0014\u0010\u0006\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0010\u0010\n\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0010\u0010\u0010\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\'"}, d2={"Landroidx/compose/runtime/saveable/SaveableStateRegistryWrapper;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/savedstate/SavedStateRegistryOwner;", "base", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "_lifecycle", "getOrInitLifecycle", "controller", "Landroidx/savedstate/SavedStateRegistryController;", "getController", "()Landroidx/savedstate/SavedStateRegistryController;", "_controller", "getOrInitController", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "canBeSaved", "", "value", "", "consumeRestored", "key", "", "performSave", "", "", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Lkotlin/Function0;", "runtime-saveable"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SaveableStateRegistryWrapper implements SaveableStateRegistry, SavedStateRegistryOwner {
    public static final int $stable = 8;
    private SavedStateRegistryController _controller;
    private LifecycleRegistry _lifecycle;

    static {
    }

    public SaveableStateRegistryWrapper(SaveableStateRegistry arg3) {
        super();
        this.$$delegate_0 = arg3;
        String v3 = "androidx.savedstate.SavedStateRegistry";
        Object v0 = this.consumeRestored(v3);
        if((v0 instanceof Bundle)) {
        }
        else {
            v0 = null;
        }

        if(v0 != null) {
            this.getOrInitController(((Bundle)v0));
        }

        this.registerProvider(v3, new SaveableStateRegistryWrapper$$ExternalSyntheticLambda0(this));
    }

    static final Object _init_$lambda$0(SaveableStateRegistryWrapper arg6) {
        Object[] v1_3;
        SavedStateRegistryController v6 = arg6._controller;
        Object v0 = null;
        if(v6 != null) {
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
            SavedStateWriter.constructor-impl(v1_4);
            v6.performSave(v1_4);
            if(SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(v1_4))) {
                return v0;
            }

            return v1_4;
        }

        return v0;
    }

    public boolean canBeSaved(Object arg1) {
        return this.$$delegate_0.canBeSaved(arg1);
    }

    public Object consumeRestored(String arg1) {
        return this.$$delegate_0.consumeRestored(arg1);
    }

    private final SavedStateRegistryController getController() {
        return this.getOrInitController(null);
    }

    public Lifecycle getLifecycle() {
        return this.getLifecycle();
    }

    public LifecycleRegistry getLifecycle() {
        return this.getOrInitLifecycle();
    }

    private final SavedStateRegistryController getOrInitController(Bundle arg3) {
        SavedStateRegistryController v0 = this._controller;
        if(v0 == null) {
            v0 = SavedStateRegistryController.Companion.create(this);
            this._controller = v0;
            v0.performRestore(arg3);
        }

        return v0;
    }

    private final LifecycleRegistry getOrInitLifecycle() {
        LifecycleRegistry v0 = this._lifecycle;
        if(v0 == null) {
            v0 = LifecycleRegistry.Companion.createUnsafe(this);
            this._lifecycle = v0;
        }

        return v0;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.getController().getSavedStateRegistry();
    }

    public Map performSave() {
        return this.$$delegate_0.performSave();
    }

    public Entry registerProvider(String arg1, Function0 arg2) {
        return this.$$delegate_0.registerProvider(arg1, arg2);
    }
}

