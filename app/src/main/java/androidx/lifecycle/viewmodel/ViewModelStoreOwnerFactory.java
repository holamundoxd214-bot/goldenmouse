package androidx.lifecycle.viewmodel;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A7\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\b\u0002\u0010\u0004\u001A\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\b\u000B\u001A?\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\f\b\u0002\u0010\u0004\u001A\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\b\u000B\u001AG\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\f\b\u0002\u0010\u0004\u001A\u00060\u0005j\u0002`\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\b\u000B¨\u0006\u0012"}, d2={"ViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "defaultArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "defaultFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "lifecycle-viewmodel-savedstate"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ViewModelStoreOwnerFactory {
    public static final ViewModelStoreOwner create(ViewModelStore arg7) {
        Intrinsics.checkNotNullParameter(arg7, "viewModelStore");
        return ViewModelStoreOwnerFactory.create$default(arg7, null, null, null, 14, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg7, Bundle arg8) {
        Intrinsics.checkNotNullParameter(arg7, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg8, "defaultArgs");
        return ViewModelStoreOwnerFactory.create$default(arg7, arg8, null, null, 12, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg7, Bundle arg8, CreationExtras arg9) {
        Intrinsics.checkNotNullParameter(arg7, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg8, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg9, "defaultCreationExtras");
        return ViewModelStoreOwnerFactory.create$default(arg7, arg8, arg9, null, 8, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg1, Bundle arg2, CreationExtras arg3, Factory arg4) {
        Intrinsics.checkNotNullParameter(arg1, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg2, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg3, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg4, "defaultFactory");
        return new ViewModelStoreOwnerFactory$ViewModelStoreOwner$1(arg1, arg4, arg3, arg2);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg9, SavedStateRegistry arg10, Lifecycle arg11) {
        Intrinsics.checkNotNullParameter(arg9, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg10, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(arg11, "lifecycle");
        return ViewModelStoreOwnerFactory.create$default(arg9, arg10, arg11, null, null, null, 56, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg9, SavedStateRegistry arg10, Lifecycle arg11, Bundle arg12) {
        Intrinsics.checkNotNullParameter(arg9, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg10, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(arg11, "lifecycle");
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        return ViewModelStoreOwnerFactory.create$default(arg9, arg10, arg11, arg12, null, null, 0x30, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg9, SavedStateRegistry arg10, Lifecycle arg11, Bundle arg12, CreationExtras arg13) {
        Intrinsics.checkNotNullParameter(arg9, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg10, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(arg11, "lifecycle");
        Intrinsics.checkNotNullParameter(arg12, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg13, "defaultCreationExtras");
        return ViewModelStoreOwnerFactory.create$default(arg9, arg10, arg11, arg12, arg13, null, 0x20, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg8, SavedStateRegistry arg9, Lifecycle arg10, Bundle arg11, CreationExtras arg12, Factory arg13) {
        Intrinsics.checkNotNullParameter(arg8, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg9, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(arg10, "lifecycle");
        Intrinsics.checkNotNullParameter(arg11, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg12, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg13, "defaultFactory");
        return new ViewModelStoreOwnerFactory$ViewModelStoreOwner$2(arg9, arg8, arg10, arg13, arg12, arg11);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg8, SavedStateRegistryOwner arg9) {
        Intrinsics.checkNotNullParameter(arg8, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg9, "savedStateRegistryOwner");
        return ViewModelStoreOwnerFactory.create$default(arg8, arg9, null, null, null, 28, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg8, SavedStateRegistryOwner arg9, Bundle arg10) {
        Intrinsics.checkNotNullParameter(arg8, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg9, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(arg10, "defaultArgs");
        return ViewModelStoreOwnerFactory.create$default(arg8, arg9, arg10, null, null, 24, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg8, SavedStateRegistryOwner arg9, Bundle arg10, CreationExtras arg11) {
        Intrinsics.checkNotNullParameter(arg8, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg9, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(arg10, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg11, "defaultCreationExtras");
        return ViewModelStoreOwnerFactory.create$default(arg8, arg9, arg10, arg11, null, 16, null);
    }

    public static final ViewModelStoreOwner create(ViewModelStore arg7, SavedStateRegistryOwner arg8, Bundle arg9, CreationExtras arg10, Factory arg11) {
        Intrinsics.checkNotNullParameter(arg7, "viewModelStore");
        Intrinsics.checkNotNullParameter(arg8, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(arg9, "defaultArgs");
        Intrinsics.checkNotNullParameter(arg10, "defaultCreationExtras");
        Intrinsics.checkNotNullParameter(arg11, "defaultFactory");
        return ViewModelStoreOwnerFactory.create(arg7, arg8.getSavedStateRegistry(), arg8.getLifecycle(), arg9, arg10, arg11);
    }

    public static ViewModelStoreOwner create$default(ViewModelStore arg3, Bundle arg4, CreationExtras arg5, Factory arg6, int arg7, Object arg8) {
        SavedStateViewModelFactory v6;
        Empty v5;
        Object[] v4_3;
        if((arg7 & 2) != 0) {
            Map v4 = MapsKt.emptyMap();
            if(v4.isEmpty()) {
                Pair[] v4_1 = new Pair[0];
            }
            else {
                ArrayList v8 = new ArrayList(v4.size());
                Iterator v4_2 = v4.entrySet().iterator();
                while(v4_2.hasNext()) {
                    Object v1 = v4_2.next();
                    ((Collection)v8).add(TuplesKt.to(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue()));
                }

                v4_3 = ((Collection)v8).toArray(new Pair[0]);
            }

            arg4 = BundleKt.bundleOf(Arrays.copyOf(v4_3, ((Pair[])v4_3).length));
            SavedStateWriter.constructor-impl(arg4);
        }

        if((arg7 & 4) != 0) {
            v5 = Empty.INSTANCE;
        }

        if((arg7 & 8) != 0) {
            v6 = new SavedStateViewModelFactory();
        }

        return ViewModelStoreOwnerFactory.create(arg3, arg4, ((CreationExtras)v5), ((Factory)v6));
    }

    public static ViewModelStoreOwner create$default(ViewModelStore arg6, SavedStateRegistry arg7, Lifecycle arg8, Bundle arg9, CreationExtras arg10, Factory arg11, int arg12, Object arg13) {
        SavedStateViewModelFactory v11;
        Empty v10;
        Object[] v9_3;
        if((arg12 & 8) != 0) {
            Map v9 = MapsKt.emptyMap();
            if(v9.isEmpty()) {
                Pair[] v9_1 = new Pair[0];
            }
            else {
                ArrayList v13 = new ArrayList(v9.size());
                Iterator v9_2 = v9.entrySet().iterator();
                while(v9_2.hasNext()) {
                    Object v1 = v9_2.next();
                    ((Collection)v13).add(TuplesKt.to(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue()));
                }

                v9_3 = ((Collection)v13).toArray(new Pair[0]);
            }

            arg9 = BundleKt.bundleOf(Arrays.copyOf(v9_3, ((Pair[])v9_3).length));
            SavedStateWriter.constructor-impl(arg9);
        }

        Bundle v3 = arg9;
        if((arg12 & 16) != 0) {
            v10 = Empty.INSTANCE;
        }

        CreationExtras v4 = ((CreationExtras)v10);
        if((arg12 & 0x20) != 0) {
            v11 = new SavedStateViewModelFactory();
        }

        return ViewModelStoreOwnerFactory.create(arg6, arg7, arg8, v3, v4, ((Factory)v11));
    }

    public static ViewModelStoreOwner create$default(ViewModelStore arg3, SavedStateRegistryOwner arg4, Bundle arg5, CreationExtras arg6, Factory arg7, int arg8, Object arg9) {
        SavedStateViewModelFactory v7;
        Empty v6;
        Object[] v5_3;
        if((arg8 & 4) != 0) {
            Map v5 = MapsKt.emptyMap();
            if(v5.isEmpty()) {
                Pair[] v5_1 = new Pair[0];
            }
            else {
                ArrayList v9 = new ArrayList(v5.size());
                Iterator v5_2 = v5.entrySet().iterator();
                while(v5_2.hasNext()) {
                    Object v1 = v5_2.next();
                    ((Collection)v9).add(TuplesKt.to(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue()));
                }

                v5_3 = ((Collection)v9).toArray(new Pair[0]);
            }

            arg5 = BundleKt.bundleOf(Arrays.copyOf(v5_3, ((Pair[])v5_3).length));
            SavedStateWriter.constructor-impl(arg5);
        }

        if((arg8 & 8) != 0) {
            v6 = Empty.INSTANCE;
        }

        if((arg8 & 16) != 0) {
            v7 = new SavedStateViewModelFactory();
        }

        return ViewModelStoreOwnerFactory.create(arg3, arg4, arg5, ((CreationExtras)v6), ((Factory)v7));
    }
}

