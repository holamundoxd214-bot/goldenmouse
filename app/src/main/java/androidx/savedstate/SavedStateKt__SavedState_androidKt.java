package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001AC\u0010\u0002\u001A\u00060\u0001j\u0002`\u00032\u0016\b\u0002\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0019\b\u0002\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001A7\u0010\u0002\u001A\u00060\u0001j\u0002`\u00032\n\u0010\u0004\u001A\u00060\u0001j\u0002`\u00032\u0019\b\u0002\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000B0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2={"SavedState", "Landroid/os/Bundle;", "savedState", "Landroidx/savedstate/SavedState;", "initialState", "", "", "", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateWriter;", "", "Lkotlin/ExtensionFunctionType;", "savedstate"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/savedstate/SavedStateKt") final class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Bundle arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "initialState");
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Bundle v0 = new Bundle(arg1);
        arg2.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(v0)));
        return v0;
    }

    public static final Bundle savedState(Map arg4, Function1 arg5) {
        Object[] v4_2;
        Intrinsics.checkNotNullParameter(arg4, "initialState");
        Intrinsics.checkNotNullParameter(arg5, "builderAction");
        if(arg4.isEmpty()) {
            Pair[] v4 = new Pair[0];
        }
        else {
            ArrayList v0 = new ArrayList(arg4.size());
            Iterator v4_1 = arg4.entrySet().iterator();
            while(v4_1.hasNext()) {
                Object v2 = v4_1.next();
                ((Collection)v0).add(TuplesKt.to(((Map$Entry)v2).getKey(), ((Map$Entry)v2).getValue()));
            }

            v4_2 = ((Collection)v0).toArray(new Pair[0]);
        }

        Bundle v4_3 = BundleKt.bundleOf(Arrays.copyOf(v4_2, ((Pair[])v4_2).length));
        arg5.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(v4_3)));
        return v4_3;
    }

    public static Bundle savedState$default(Bundle arg0, Function1 arg1, int arg2, Object arg3) {
        SavedStateKt__SavedState_androidKt$savedState$3 v1;
        if((arg2 & 2) != 0) {
            v1 = SavedStateKt__SavedState_androidKt$savedState$3.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg0, "initialState");
        Intrinsics.checkNotNullParameter(v1, "builderAction");
        Bundle v2 = new Bundle(arg0);
        ((Function1)v1).invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(v2)));
        return v2;
    }

    public static Bundle savedState$default(Map arg2, Function1 arg3, int arg4, Object arg5) {
        Object[] v2_2;
        SavedStateKt__SavedState_androidKt$savedState$1 v3;
        if((arg4 & 1) != 0) {
            arg2 = MapsKt.emptyMap();
        }

        if((arg4 & 2) != 0) {
            v3 = SavedStateKt__SavedState_androidKt$savedState$1.INSTANCE;
        }

        Intrinsics.checkNotNullParameter(arg2, "initialState");
        Intrinsics.checkNotNullParameter(v3, "builderAction");
        if(arg2.isEmpty()) {
            Pair[] v2 = new Pair[0];
        }
        else {
            ArrayList v4 = new ArrayList(arg2.size());
            Iterator v2_1 = arg2.entrySet().iterator();
            while(v2_1.hasNext()) {
                Object v0 = v2_1.next();
                ((Collection)v4).add(TuplesKt.to(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue()));
            }

            v2_2 = ((Collection)v4).toArray(new Pair[0]);
        }

        Bundle v2_3 = BundleKt.bundleOf(Arrays.copyOf(v2_2, ((Pair[])v2_2).length));
        ((Function1)v3).invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(v2_3)));
        return v2_3;
    }
}

