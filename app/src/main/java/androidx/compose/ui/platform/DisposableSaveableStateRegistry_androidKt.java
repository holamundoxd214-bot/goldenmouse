package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.R$id;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0000\u001A\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0002\u001A \u0010\u0011\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00130\u0012*\u00020\u0014H\u0002\u001A \u0010\u0015\u001A\u00020\u0014*\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00130\u0012H\u0002\"\u001E\u0010\r\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000F0\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0016"}, d2={"DisposableSaveableStateRegistry", "Landroidx/compose/ui/platform/DisposableSaveableStateRegistry;", "view", "Landroid/view/View;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "id", "", "savedStateRegistryOwner", "canBeSavedToBundle", "", "value", "", "AcceptableClasses", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "toMap", "", "", "Landroid/os/Bundle;", "toBundle", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DisposableSaveableStateRegistry_androidKt {
    private static final Class[] AcceptableClasses;

    static {
        DisposableSaveableStateRegistry_androidKt.AcceptableClasses = new Class[]{Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};
    }

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(View arg2, SavedStateRegistryOwner arg3) {
        ViewParent v2 = arg2.getParent();
        Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type android.view.View");
        Object v0 = ((View)v2).getTag(id.compose_view_saveable_id_tag);
        if((v0 instanceof String)) {
        }
        else {
            v0 = null;
        }

        if(v0 == null) {
            String v0_1 = String.valueOf(((View)v2).getId());
        }

        return DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry(((String)v0), arg3);
    }

    public static final DisposableSaveableStateRegistry DisposableSaveableStateRegistry(String arg4, SavedStateRegistryOwner arg5) {
        boolean v1;
        arg4 = SaveableStateRegistry.class.getSimpleName() + ':' + arg4;
        SavedStateRegistry v5 = arg5.getSavedStateRegistry();
        Bundle v0 = v5.consumeRestoredStateForKey(arg4);
        Map v0_1 = v0 != null ? DisposableSaveableStateRegistry_androidKt.toMap(v0) : null;
        SaveableStateRegistry v0_2 = SaveableStateRegistryKt.SaveableStateRegistry(v0_1, DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1.INSTANCE);
        try {
            v5.registerSavedStateProvider(arg4, new DisposableSaveableStateRegistry_androidKt$$ExternalSyntheticLambda0(v0_2));
            v1 = true;
        }
        catch(IllegalArgumentException ) {
            v1 = false;
        }

        return new DisposableSaveableStateRegistry(v0_2, new DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1(v1, v5, arg4));
    }

    static final Bundle DisposableSaveableStateRegistry$lambda$0(SaveableStateRegistry arg0) {
        return DisposableSaveableStateRegistry_androidKt.toBundle(arg0.performSave());
    }

    public static final boolean access$canBeSavedToBundle(Object arg0) {
        return DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(arg0);
    }

    private static final boolean canBeSavedToBundle(Object arg6) {
        if((arg6 instanceof SnapshotMutableState)) {
            if(((SnapshotMutableState)arg6).getPolicy() != SnapshotStateKt.neverEqualPolicy() && ((SnapshotMutableState)arg6).getPolicy() != SnapshotStateKt.structuralEqualityPolicy()) {
                if(((SnapshotMutableState)arg6).getPolicy() == SnapshotStateKt.referentialEqualityPolicy()) {
                }
                else {
                    return 0;
                }
            }

            arg6 = ((SnapshotMutableState)arg6).getValue();
            if(arg6 == null) {
                return 1;
            }

            return DisposableSaveableStateRegistry_androidKt.canBeSavedToBundle(arg6);
        }

        if(((arg6 instanceof Function)) && ((arg6 instanceof Serializable))) {
            return 0;
        }

        Class[] v0 = DisposableSaveableStateRegistry_androidKt.AcceptableClasses;
        int v3 = v0.length;
        int v4;
        for(v4 = 0; v4 < v3; ++v4) {
            if(v0[v4].isInstance(arg6)) {
                return 1;
            }
        }

        return 0;
    }

    private static final Bundle toBundle(Map arg4) {
        Bundle v0 = new Bundle();
        Iterator v4 = arg4.entrySet().iterator();
        while(v4.hasNext()) {
            Object v1 = v4.next();
            Object v2 = ((Map$Entry)v1).getKey();
            v1 = ((Map$Entry)v1).getValue();
            if((v1 instanceof ArrayList)) {
            }
            else {
                ArrayList v1_1 = new ArrayList(((Collection)v1));
            }

            v0.putParcelableArrayList(((String)v2), ((ArrayList)v1));
        }

        return v0;
    }

    private static final Map toMap(Bundle arg5) {
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg5.keySet().iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            ArrayList v3 = arg5.getParcelableArrayList(((String)v2));
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>");
            ((Map)v0).put(v2, v3);
        }

        return ((Map)v0);
    }
}

