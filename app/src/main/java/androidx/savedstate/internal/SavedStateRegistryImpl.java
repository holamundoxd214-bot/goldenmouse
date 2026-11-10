package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u001E\u001A\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u00152\u0006\u0010\u001F\u001A\u00020\u000FH\u0007¢\u0006\u0002\u0010 J\u0018\u0010!\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u000F2\u0006\u0010\"\u001A\u00020\u0010H\u0007J\u0010\u0010#\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u001F\u001A\u00020\u000FJ\u0010\u0010$\u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u000FH\u0007J\b\u0010%\u001A\u00020\u0006H\u0007J\u001F\u0010&\u001A\u00020\u00062\u000E\u0010\'\u001A\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015H\u0001¢\u0006\u0004\b(\u0010)J\u001B\u0010*\u001A\u00020\u00062\n\u0010+\u001A\u00060\u0014j\u0002`\u0015H\u0001¢\u0006\u0004\b,\u0010)R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u00100\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001A\n\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0016R \u0010\u0018\u001A\u00020\u00122\u0006\u0010\u0017\u001A\u00020\u00128G@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\u00020\u0012X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0019\"\u0004\b\u001C\u0010\u001D¨\u0006."}, d2={"Landroidx/savedstate/internal/SavedStateRegistryImpl;", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "onAttach", "Lkotlin/Function0;", "", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;Lkotlin/jvm/functions/Function0;)V", "getOnAttach$savedstate", "()Lkotlin/jvm/functions/Function0;", "lock", "Landroidx/savedstate/internal/SynchronizedObject;", "keyToProviders", "", "", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "attached", "", "restoredState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Landroid/os/Bundle;", "value", "isRestored", "()Z", "isAllowingSavingState", "isAllowingSavingState$savedstate", "setAllowingSavingState$savedstate", "(Z)V", "consumeRestoredStateForKey", "key", "(Ljava/lang/String;)Landroid/os/Bundle;", "registerSavedStateProvider", "provider", "getSavedStateProvider", "unregisterSavedStateProvider", "performAttach", "performRestore", "savedState", "performRestore$savedstate", "(Landroid/os/Bundle;)V", "performSave", "outBundle", "performSave$savedstate", "Companion", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateRegistryImpl {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/savedstate/internal/SavedStateRegistryImpl$Companion;", "", "<init>", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    private static final Companion Companion = null;
    private static final String SAVED_COMPONENTS_KEY = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    private boolean attached;
    private boolean isAllowingSavingState;
    private boolean isRestored;
    private final Map keyToProviders;
    private final SynchronizedObject lock;
    private final Function0 onAttach;
    private final SavedStateRegistryOwner owner;
    private Bundle restoredState;

    static {
        SavedStateRegistryImpl.Companion = new Companion(null);
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        Intrinsics.checkNotNullParameter(arg3, "onAttach");
        super();
        this.owner = arg2;
        this.onAttach = arg3;
        this.lock = new SynchronizedObject();
        this.keyToProviders = new LinkedHashMap();
        this.isAllowingSavingState = true;
    }

    public SavedStateRegistryImpl(SavedStateRegistryOwner arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        SavedStateRegistryImpl$$ExternalSyntheticLambda1 v2;
        if((arg3 & 2) != 0) {
            v2 = new SavedStateRegistryImpl$$ExternalSyntheticLambda1();
        }

        this(arg1, ((Function0)v2));
    }

    static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final Map access$getKeyToProviders$p(SavedStateRegistryImpl arg0) {
        return arg0.keyToProviders;
    }

    public final Bundle consumeRestoredStateForKey(String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        if(this.isRestored) {
            Bundle v0 = this.restoredState;
            Bundle v1 = null;
            if(v0 == null) {
                return v1;
            }

            Bundle v2 = SavedStateReader.constructor-impl(v0);
            v2 = SavedStateReader.contains-impl(v2, arg5) ? SavedStateReader.getSavedState-impl(v2, arg5) : v1;
            SavedStateWriter.remove-impl(SavedStateWriter.constructor-impl(v0), arg5);
            if(SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(v0))) {
                this.restoredState = v1;
            }

            return v2;
        }

        throw new IllegalStateException("You can \'consumeRestoredStateForKey\' only after the corresponding component has moved to the \'CREATED\' state".toString());
    }

    public final Function0 getOnAttach$savedstate() {
        return this.onAttach;
    }

    public final SavedStateProvider getSavedStateProvider(String arg5) {
        Object v1;
        Object v2;
        Intrinsics.checkNotNullParameter(arg5, "key");
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            Iterator v4_1 = this.keyToProviders.entrySet().iterator();
            do {
            label_7:
                v2 = null;
                if(v4_1.hasNext()) {
                    v1 = v4_1.next();
                    Object v3 = ((Map$Entry)v1).getKey();
                    v1 = ((Map$Entry)v1).getValue();
                    if(Intrinsics.areEqual(v3, arg5)) {
                        break;
                    }

                    goto label_16;
                }

                goto label_17;
            }
            while(true);
        }
        catch(Throwable v4) {
            goto label_20;
        }

        v2 = v1;
    label_16:
        if(v2 == null) {
            goto label_7;
        }

    label_17:
        __monitor_exit(v0);
        return ((SavedStateProvider)v2);
    label_20:
        __monitor_exit(v0);
        throw v4;
    }

    public final boolean isAllowingSavingState$savedstate() {
        return this.isAllowingSavingState;
    }

    public final boolean isRestored() {
        return this.isRestored;
    }

    public final void performAttach() {
        if(this.owner.getLifecycle().getCurrentState() == State.INITIALIZED) {
            if(!this.attached) {
                this.onAttach.invoke();
                this.owner.getLifecycle().addObserver(new SavedStateRegistryImpl$$ExternalSyntheticLambda0(this));
                this.attached = true;
                return;
            }

            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }

        throw new IllegalStateException("Restarter must be created only during owner\'s initialization stage".toString());
    }

    static final void performAttach$lambda$12(SavedStateRegistryImpl arg1, LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<unused var>");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 == Event.ON_START) {
            arg1.isAllowingSavingState = true;
            return;
        }

        if(arg3 == Event.ON_STOP) {
            arg1.isAllowingSavingState = false;
        }
    }

    public final void performRestore$savedstate(Bundle arg4) {
        if(!this.attached) {
            this.performAttach();
        }

        if(!this.owner.getLifecycle().getCurrentState().isAtLeast(State.STARTED)) {
            if(!this.isRestored) {
                Bundle v0 = null;
                if(arg4 != null) {
                    arg4 = SavedStateReader.constructor-impl(arg4);
                    String v1 = "androidx.lifecycle.BundlableSavedStateRegistry.key";
                    if(SavedStateReader.contains-impl(arg4, v1)) {
                        v0 = SavedStateReader.getSavedState-impl(arg4, v1);
                    }
                }

                this.restoredState = v0;
                this.isRestored = true;
                return;
            }

            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }

        throw new IllegalStateException("performRestore cannot be called when owner is " + this.owner.getLifecycle().getCurrentState().toString());
    }

    public final void performSave$savedstate(Bundle arg6) {
        Object v3;
        Pair[] v0_1;
        Intrinsics.checkNotNullParameter(arg6, "outBundle");
        Map v0 = MapsKt.emptyMap();
        if(v0.isEmpty()) {
            v0_1 = new Pair[0];
        }
        else {
            ArrayList v1 = new ArrayList(v0.size());
            Iterator v0_2 = v0.entrySet().iterator();
            while(v0_2.hasNext()) {
                v3 = v0_2.next();
                ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
            }

            Object[] v0_3 = ((Collection)v1).toArray(new Pair[0]);
        }

        Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(((Object[])v0_1), v0_1.length));
        Bundle v1_1 = SavedStateWriter.constructor-impl(v0_4);
        Bundle v2 = this.restoredState;
        if(v2 != null) {
            SavedStateWriter.putAll-impl(v1_1, v2);
        }

        SynchronizedObject v2_1 = this.lock;
        __monitor_enter(v2_1);
        try {
            Iterator v5_1 = this.keyToProviders.entrySet().iterator();
            while(v5_1.hasNext()) {
                v3 = v5_1.next();
                SavedStateWriter.putSavedState-impl(v1_1, ((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue().saveState());
            }
        }
        catch(Throwable v5) {
            goto label_53;
        }

        __monitor_exit(v2_1);
        if(!SavedStateReader.isEmpty-impl(SavedStateReader.constructor-impl(v0_4))) {
            SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(arg6), "androidx.lifecycle.BundlableSavedStateRegistry.key", v0_4);
        }

        return;
    label_53:
        __monitor_exit(v2_1);
        throw v5;
    }

    public final void registerSavedStateProvider(String arg3, SavedStateProvider arg4) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.checkNotNullParameter(arg4, "provider");
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            if(this.keyToProviders.containsKey(arg3)) {
                goto label_14;
            }

            this.keyToProviders.put(arg3, arg4);
        }
        catch(Throwable v2) {
            goto label_20;
        }

        __monitor_exit(v0);
        return;
        try {
        label_14:
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
        catch(Throwable v2) {
        label_20:
            __monitor_exit(v0);
            throw v2;
        }
    }

    public final void setAllowingSavingState$savedstate(boolean arg1) {
        this.isAllowingSavingState = arg1;
    }

    public final void unregisterSavedStateProvider(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        SynchronizedObject v0 = this.lock;
        __monitor_enter(v0);
        try {
            this.keyToProviders.remove(arg2);
            __monitor_exit(v0);
            return;
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }
    }
}

