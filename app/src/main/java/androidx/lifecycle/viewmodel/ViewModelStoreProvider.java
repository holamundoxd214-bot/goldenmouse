package androidx.lifecycle.viewmodel;

import android.os.Bundle;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewModelStoreOwnerDefaults;
import androidx.savedstate.SavedStateRegistryOwner;
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
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004!\"#$BA\b\u0007\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\f\b\u0002\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rBA\b\u0017\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0001\u0012\f\b\u0002\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\u0010J\u0010\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001J\u0010\u0010\u001A\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001J@\u0010\u001B\u001A\u00020\u000F2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\f\b\u0002\u0010\u0005\u001A\u00060\u0006j\u0002`\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BH\u0007J\u0010\u0010\u001E\u001A\u00020\u001F2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001J\u0006\u0010 \u001A\u00020\u001FR\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001A\u00060\u0006j\u0002`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u0010\u0011\u001A\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2={"Landroidx/lifecycle/viewmodel/ViewModelStoreProvider;", "", "parentStore", "Landroidx/lifecycle/ViewModelStore;", "parentKey", "defaultArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "defaultFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "(Landroidx/lifecycle/ViewModelStore;Ljava/lang/Object;Landroid/os/Bundle;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "parentOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/Object;Landroid/os/Bundle;Landroidx/lifecycle/viewmodel/CreationExtras;Landroidx/lifecycle/ViewModelProvider$Factory;)V", "stateHolder", "Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$StateHolder;", "getStateHolder", "()Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$StateHolder;", "stateHolder$delegate", "Lkotlin/Lazy;", "acquireToken", "Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$ReferenceToken;", "key", "getOrCreate", "getOrCreateOwner", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "clearKey", "", "clearAllKeys", "ReferenceToken", "ProviderMarkerKey", "Entry", "StateHolder", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ViewModelStoreProvider {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J3\u0010\u001A\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0014\u0010\u001B\u001A\u00020\b2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001D\u001A\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001E\u001A\u00020\u001FHÖ\u0081\u0004R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0007\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2={"Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$Entry;", "", "key", "store", "Landroidx/lifecycle/ViewModelStore;", "refCount", "", "isDisposable", "", "<init>", "(Ljava/lang/Object;Landroidx/lifecycle/ViewModelStore;IZ)V", "getKey", "()Ljava/lang/Object;", "getStore", "()Landroidx/lifecycle/ViewModelStore;", "getRefCount", "()I", "setRefCount", "(I)V", "()Z", "setDisposable", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) final class Entry {
        private boolean isDisposable;
        private final Object key;
        private int refCount;
        private final ViewModelStore store;

        public Entry(Object arg2, ViewModelStore arg3, int arg4, boolean arg5) {
            Intrinsics.checkNotNullParameter(arg3, "store");
            super();
            this.key = arg2;
            this.store = arg3;
            this.refCount = arg4;
            this.isDisposable = arg5;
        }

        public Entry(Object arg2, ViewModelStore arg3, int arg4, boolean arg5, int arg6, DefaultConstructorMarker arg7) {
            if((arg6 & 2) != 0) {
                arg3 = new ViewModelStore();
            }

            this(arg2, arg3, 0, false);
        }

        public final Object component1() {
            return this.key;
        }

        public final ViewModelStore component2() {
            return this.store;
        }

        public final int component3() {
            return this.refCount;
        }

        public final boolean component4() {
            return this.isDisposable;
        }

        public final Entry copy(Object arg1, ViewModelStore arg2, int arg3, boolean arg4) {
            Intrinsics.checkNotNullParameter(arg2, "store");
            return new Entry(arg1, arg2, arg3, arg4);
        }

        public static Entry copy$default(Entry arg0, Object arg1, ViewModelStore arg2, int arg3, boolean arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.key;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.store;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.refCount;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.isDisposable;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((Entry)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Entry)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.key, ((Entry)arg5).key)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.store, ((Entry)arg5).store)) {
                return 0;
            }

            if(this.refCount != ((Entry)arg5).refCount) {
                return 0;
            }

            if(this.isDisposable != ((Entry)arg5).isDisposable) {
                return 0;
            }

            return 1;
        }

        public final Object getKey() {
            return this.key;
        }

        public final int getRefCount() {
            return this.refCount;
        }

        public final ViewModelStore getStore() {
            return this.store;
        }

        public int hashCode() {
            Object v0 = this.key;
            int v0_1 = v0 == null ? 0 : v0.hashCode();
            return ((v0_1 * 0x1F + this.store.hashCode()) * 0x1F + Integer.hashCode(this.refCount)) * 0x1F + Boolean.hashCode(this.isDisposable);
        }

        public final boolean isDisposable() {
            return this.isDisposable;
        }

        public final void setDisposable(boolean arg1) {
            this.isDisposable = arg1;
        }

        public final void setRefCount(int arg1) {
            this.refCount = arg1;
        }

        public String toString() {
            return "Entry(key=" + this.key + ", store=" + this.store + ", refCount=" + this.refCount + ", isDisposable=" + this.isDisposable + ")";
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2={"Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$ProviderMarkerKey;", "", "<init>", "()V", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ProviderMarkerKey {
        public static final ProviderMarkerKey INSTANCE;

        static {
            ProviderMarkerKey.INSTANCE = new ProviderMarkerKey();
        }

        private ProviderMarkerKey() {
            super();
        }
    }

    @Metadata(d1={"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00060\u0001j\u0002`\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2={"Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$ReferenceToken;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) public interface ReferenceToken extends AutoCloseable {
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u00072\b\u0010\u000B\u001A\u0004\u0018\u00010\u0006J\u0017\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\r2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0006J\b\u0010\u0010\u001A\u00020\rH\u0016R\u001F\u0010\u0004\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0011"}, d2={"Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$StateHolder;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "entries", "Landroidx/collection/MutableScatterMap;", "", "Landroidx/lifecycle/viewmodel/ViewModelStoreProvider$Entry;", "getEntries", "()Landroidx/collection/MutableScatterMap;", "getOrCreate", "key", "remove", "", "(Ljava/lang/Object;)Lkotlin/Unit;", "clearKey", "onCleared", "lifecycle-viewmodel-savedstate"}, k=1, mv={2, 1, 0}, xi=0x30) final class StateHolder extends ViewModel {
        private final MutableScatterMap entries;

        public StateHolder() {
            super();
            this.entries = ScatterMapKt.mutableScatterMapOf();
        }

        public final void clearKey(Object arg3) {
            Object v0 = this.entries.get(arg3);
            if(v0 == null) {
            }
            else {
                ((Entry)v0).setDisposable(true);
                if((((Entry)v0).isDisposable()) && ((Entry)v0).getRefCount() <= 0) {
                    this.remove(arg3);
                }
            }
        }

        public final MutableScatterMap getEntries() {
            return this.entries;
        }

        public final Entry getOrCreate(Object arg9) {
            Entry v0_1;
            MutableScatterMap v8 = this.entries;
            Object v0 = v8.get(arg9);
            if(v0 == null) {
                Entry v1 = new Entry(arg9, null, 0, false, 14, null);
                v8.set(arg9, v1);
                v0_1 = v1;
            }

            return v0_1;
        }

        public void onCleared() {
            ScatterMap v0 = ViewModelStoreProviderKt.access$toScatterMap(this.entries);
            Object[] v1 = v0.values;
            long[] v0_1 = v0.metadata;
            int v2 = v0_1.length - 2;
            if(v2 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v0_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80) {
                                Object v10 = v1[(v4 << 3) + v9];
                                ((Entry)v10).setDisposable(true);
                                if(((Entry)v10).getRefCount() <= 0) {
                                    this.remove(((Entry)v10).getKey());
                                }
                            }

                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            return;
                        }
                    }

                    if(v4 == v2) {
                        return;
                    }
                }
            }
        }

        public final Unit remove(Object arg1) {
            Object v0 = this.entries.remove(arg1);
            if(v0 != null) {
                ViewModelStore v0_1 = ((Entry)v0).getStore();
                if(v0_1 != null) {
                    v0_1.clear();
                    return Unit.INSTANCE;
                }
            }

            return null;
        }
    }

    private final Bundle defaultArgs;
    private final CreationExtras defaultCreationExtras;
    private final Factory defaultFactory;
    private final Object parentKey;
    private final ViewModelStore parentStore;
    private final Lazy stateHolder$delegate;

    public static StateHolder $r8$lambda$cUrpk5rgrsR-xBWPp8KvtY3ziio() {
        return ViewModelStoreProvider.stateHolder_delegate$lambda$0$0();
    }

    public ViewModelStoreProvider(ViewModelStore arg9) {
        this(arg9, null, null, null, null, 30, null);
    }

    public ViewModelStoreProvider(ViewModelStore arg7, Object arg8, Bundle arg9, CreationExtras arg10, Factory arg11, int arg12, DefaultConstructorMarker arg13) {
        SavedStateViewModelFactory v11;
        Empty v10;
        Object[] v8_3;
        if((arg12 & 2) != 0) {
            arg8 = null;
        }

        Object v2 = arg8;
        if((arg12 & 4) != 0) {
            Map v8 = MapsKt.emptyMap();
            if(v8.isEmpty()) {
                Pair[] v8_1 = new Pair[0];
            }
            else {
                ArrayList v9 = new ArrayList(v8.size());
                Iterator v8_2 = v8.entrySet().iterator();
                while(v8_2.hasNext()) {
                    Object v0 = v8_2.next();
                    ((Collection)v9).add(TuplesKt.to(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue()));
                }

                v8_3 = ((Collection)v9).toArray(new Pair[0]);
            }

            arg9 = BundleKt.bundleOf(Arrays.copyOf(v8_3, ((Pair[])v8_3).length));
            SavedStateWriter.constructor-impl(arg9);
        }

        Bundle v3 = arg9;
        if((arg12 & 8) != 0) {
            v10 = Empty.INSTANCE;
        }

        CreationExtras v4 = ((CreationExtras)v10);
        if((arg12 & 16) != 0) {
            v11 = new SavedStateViewModelFactory();
        }

        this(arg7, v2, v3, v4, ((Factory)v11));
    }

    public ViewModelStoreProvider(ViewModelStore arg9, Object arg10) {
        this(arg9, arg10, null, null, null, 28, null);
    }

    public ViewModelStoreProvider(ViewModelStore arg10, Object arg11, Bundle arg12) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        this(arg10, arg11, arg12, null, null, 24, null);
    }

    public ViewModelStoreProvider(ViewModelStore arg10, Object arg11, Bundle arg12, CreationExtras arg13) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg13, "defaultCreationExtras");
        this(arg10, arg11, arg12, arg13, null, 16, null);
    }

    public ViewModelStoreProvider(ViewModelStore arg2, Object arg3, Bundle arg4, CreationExtras arg5, Factory arg6) {
        Intrinsics.checkNotNullParameter(arg4, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg5, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg6, "defaultFactory");
        super();
        this.parentStore = arg2;
        this.parentKey = arg3;
        this.defaultArgs = arg4;
        this.defaultCreationExtras = arg5;
        this.defaultFactory = arg6;
        this.stateHolder$delegate = LazyKt.lazy(new ViewModelStoreProvider$$ExternalSyntheticLambda0(this));
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg9) {
        this(arg9, null, null, null, null, 30, null);
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg7, Object arg8, Bundle arg9, CreationExtras arg10, Factory arg11, int arg12, DefaultConstructorMarker arg13) {
        Object[] v8_3;
        if((arg12 & 2) != 0) {
            arg8 = null;
        }

        Object v2 = arg8;
        if((arg12 & 4) != 0) {
            Map v8 = MapsKt.emptyMap();
            if(v8.isEmpty()) {
                Pair[] v8_1 = new Pair[0];
            }
            else {
                ArrayList v9 = new ArrayList(v8.size());
                Iterator v8_2 = v8.entrySet().iterator();
                while(v8_2.hasNext()) {
                    Object v0 = v8_2.next();
                    ((Collection)v9).add(TuplesKt.to(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue()));
                }

                v8_3 = ((Collection)v9).toArray(new Pair[0]);
            }

            arg9 = BundleKt.bundleOf(Arrays.copyOf(v8_3, ((Pair[])v8_3).length));
            SavedStateWriter.constructor-impl(arg9);
        }

        Bundle v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = ViewModelStoreOwnerDefaults.getViewModelCreationExtras(arg7);
        }

        CreationExtras v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = ViewModelStoreOwnerDefaults.getViewModelProviderFactory(arg7);
        }

        this(arg7, v2, v3, v4, arg11);
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg9, Object arg10) {
        this(arg9, arg10, null, null, null, 28, null);
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg10, Object arg11, Bundle arg12) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        this(arg10, arg11, arg12, null, null, 24, null);
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg10, Object arg11, Bundle arg12, CreationExtras arg13) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg13, "defaultCreationExtras");
        this(arg10, arg11, arg12, arg13, null, 16, null);
    }

    public ViewModelStoreProvider(ViewModelStoreOwner arg7, Object arg8, Bundle arg9, CreationExtras arg10, Factory arg11) {
        Intrinsics.checkNotNullParameter(arg9, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg10, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg11, "defaultFactory");
        ViewModelStore v7 = arg7 != null ? arg7.getViewModelStore() : null;
        this(v7, arg8, arg9, arg10, arg11);
    }

    public final ReferenceToken acquireToken(Object arg3) {
        Entry v0 = this.getStateHolder().getOrCreate(arg3);
        v0.setRefCount(v0.getRefCount() + 1);
        return new ViewModelStoreProvider$$ExternalSyntheticLambda1(v0, this, arg3);
    }

    static final void acquireToken$lambda$0(Entry arg1, ViewModelStoreProvider arg2, Object arg3) {
        arg1.setRefCount(arg1.getRefCount() - 1);
        if((arg1.isDisposable()) && arg1.getRefCount() <= 0) {
            arg2.getStateHolder().remove(arg3);
        }
    }

    public final void clearAllKeys() {
        Object v0 = this.getStateHolder().getEntries().get(ProviderMarkerKey.INSTANCE);
        if(v0 != null && ((Entry)v0).getRefCount() > 0) {
            return;
        }

        this.getStateHolder().onCleared();
    }

    public final void clearKey(Object arg1) {
        this.getStateHolder().clearKey(arg1);
    }

    public final ViewModelStore getOrCreate(Object arg1) {
        return this.getStateHolder().getOrCreate(arg1).getStore();
    }

    public final ViewModelStoreOwner getOrCreateOwner(Object arg2, SavedStateRegistryOwner arg3, Bundle arg4, CreationExtras arg5, Factory arg6) {
        Intrinsics.checkNotNullParameter(arg4, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg5, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg6, "defaultFactory");
        ViewModelStore v1 = this.getOrCreate(arg2);
        if(arg3 == null) {
            return ViewModelStoreOwnerFactory.create(v1, arg4, arg5, arg6);
        }

        return ViewModelStoreOwnerFactory.create(v1, arg3, arg4, arg5, arg6);
    }

    public final ViewModelStoreOwner getOrCreateOwner(Object arg9) {
        return ViewModelStoreProvider.getOrCreateOwner$default(this, arg9, null, null, null, null, 30, null);
    }

    public final ViewModelStoreOwner getOrCreateOwner(Object arg9, SavedStateRegistryOwner arg10) {
        return ViewModelStoreProvider.getOrCreateOwner$default(this, arg9, arg10, null, null, null, 28, null);
    }

    public final ViewModelStoreOwner getOrCreateOwner(Object arg10, SavedStateRegistryOwner arg11, Bundle arg12) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        return ViewModelStoreProvider.getOrCreateOwner$default(this, arg10, arg11, arg12, null, null, 24, null);
    }

    public final ViewModelStoreOwner getOrCreateOwner(Object arg10, SavedStateRegistryOwner arg11, Bundle arg12, CreationExtras arg13) {
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg13, "defaultCreationExtras");
        return ViewModelStoreProvider.getOrCreateOwner$default(this, arg10, arg11, arg12, arg13, null, 16, null);
    }

    public static ViewModelStoreOwner getOrCreateOwner$default(ViewModelStoreProvider arg6, Object arg7, SavedStateRegistryOwner arg8, Bundle arg9, CreationExtras arg10, Factory arg11, int arg12, Object arg13) {
        if((arg12 & 2) != 0) {
            arg8 = null;
        }

        SavedStateRegistryOwner v2 = arg8;
        if((arg12 & 4) != 0) {
            arg9 = arg6.defaultArgs;
        }

        Bundle v3 = arg9;
        if((arg12 & 8) != 0) {
            arg10 = arg6.defaultCreationExtras;
        }

        CreationExtras v4 = arg10;
        if((arg12 & 16) != 0) {
            arg11 = arg6.defaultFactory;
        }

        return arg6.getOrCreateOwner(arg7, v2, v3, v4, arg11);
    }

    private final StateHolder getStateHolder() {
        return this.stateHolder$delegate.getValue();
    }

    static final StateHolder stateHolder_delegate$lambda$0(ViewModelStoreProvider arg2) {
        ViewModelStore v0 = arg2.parentStore;
        if(v0 != null) {
            ViewModel v2 = v0.getOrPut(arg2.parentKey, new ViewModelStoreProvider$$ExternalSyntheticLambda2());
            if(v2 == null) {
            }
            else {
                return ((StateHolder)v2);
            }
        }

        return new StateHolder();
    }

    private static final StateHolder stateHolder_delegate$lambda$0$0() {
        return new StateHolder();
    }
}

