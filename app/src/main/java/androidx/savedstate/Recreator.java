package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u000F\u0010B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u000EH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/LifecycleEventObserver;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "reflectiveNew", "className", "", "SavedStateProvider", "Companion", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Recreator implements LifecycleEventObserver {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/savedstate/Recreator$Companion;", "", "<init>", "()V", "CLASSES_KEY", "", "COMPONENT_KEY", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\t\u001A\u00060\nj\u0002`\u000BH\u0016J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\bR\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "<init>", "(Landroidx/savedstate/SavedStateRegistry;)V", "classes", "", "", "saveState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "add", "", "className", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateProvider implements androidx.savedstate.SavedStateRegistry$SavedStateProvider {
        private final Set classes;

        public SavedStateProvider(SavedStateRegistry arg2) {
            Intrinsics.checkNotNullParameter(arg2, "registry");
            super();
            this.classes = new LinkedHashSet();
            arg2.registerSavedStateProvider("androidx.savedstate.Restarter", ((androidx.savedstate.SavedStateRegistry$SavedStateProvider)this));
        }

        public final void add(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "className");
            this.classes.add(arg2);
        }

        public Bundle saveState() {
            Object[] v0_3;
            Map v0 = MapsKt.emptyMap();
            if(v0.isEmpty()) {
                Pair[] v0_1 = new Pair[0];
            }
            else {
                ArrayList v1 = new ArrayList(v0.size());
                Iterator v0_2 = v0.entrySet().iterator();
                while(v0_2.hasNext()) {
                    Object v3 = v0_2.next();
                    ((Collection)v1).add(TuplesKt.to(((Map$Entry)v3).getKey(), ((Map$Entry)v3).getValue()));
                }

                v0_3 = ((Collection)v1).toArray(new Pair[0]);
            }

            Bundle v0_4 = BundleKt.bundleOf(Arrays.copyOf(v0_3, ((Pair[])v0_3).length));
            SavedStateWriter.putStringList-impl(SavedStateWriter.constructor-impl(v0_4), "classes_to_restore", CollectionsKt.toList(this.classes));
            return v0_4;
        }
    }

    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion;
    private final SavedStateRegistryOwner owner;

    static {
        Recreator.Companion = new Companion(null);
    }

    public Recreator(SavedStateRegistryOwner arg2) {
        Intrinsics.checkNotNullParameter(arg2, "owner");
        super();
        this.owner = arg2;
    }

    public void onStateChanged(LifecycleOwner arg2, Event arg3) {
        Intrinsics.checkNotNullParameter(arg2, "source");
        Intrinsics.checkNotNullParameter(arg3, "event");
        if(arg3 != Event.ON_CREATE) {
            goto label_31;
        }

        arg2.getLifecycle().removeObserver(this);
        Bundle v2 = this.owner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
        if(v2 == null) {
        }
        else {
            List v2_1 = SavedStateReader.getStringListOrNull-impl(SavedStateReader.constructor-impl(v2), "classes_to_restore");
            if(v2_1 != null) {
                Iterator v2_2 = v2_1.iterator();
                while(v2_2.hasNext()) {
                    this.reflectiveNew(v2_2.next());
                }
            }
            else {
                goto label_26;
            }
        }

        return;
    label_26:
        throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"".toString());
    label_31:
        throw new AssertionError("Next event must be ON_CREATE");
    }

    private final void reflectiveNew(String arg5) {
        SavedStateRegistryOwner v4_3;
        Object v0_2;
        Constructor v0_1;
        Class v1;
        String v0 = "Class ";
        try {
            v1 = Class.forName(arg5, false, Recreator.class.getClassLoader()).asSubclass(AutoRecreated.class);
            Intrinsics.checkNotNull(v1);
        }
        catch(ClassNotFoundException v4) {
            throw new RuntimeException(v0 + arg5 + " wasn\'t found", ((Throwable)v4));
        }

        try {
            v0_1 = v1.getDeclaredConstructor();
        }
        catch(NoSuchMethodException v4_1) {
            throw new IllegalStateException((((String)v0_1)) + v1.getSimpleName() + " must have default constructor in order to be automatically recreated", ((Throwable)v4_1));
        }

        v0_1.setAccessible(true);
        try {
            v0_2 = v0_1.newInstance();
            Intrinsics.checkNotNull(v0_2);
            v4_3 = this.owner;
        }
        catch(Exception v4_2) {
            throw new RuntimeException("Failed to instantiate " + arg5, ((Throwable)v4_2));
        }

        ((AutoRecreated)v0_2).onRecreated(v4_3);
    }
}

