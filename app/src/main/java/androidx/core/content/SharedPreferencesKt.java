package androidx.core.content;

import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A3\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\u0017\u0010\u0005\u001A\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2={"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class SharedPreferencesKt {
    public static final void edit(SharedPreferences arg1, boolean arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        SharedPreferences$Editor v1 = arg1.edit();
        Intrinsics.checkNotNull(v1);
        arg3.invoke(v1);
        if(arg2) {
            v1.commit();
            return;
        }

        v1.apply();
    }

    public static void edit$default(SharedPreferences arg0, boolean arg1, Function1 arg2, int arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        SharedPreferences$Editor v0 = arg0.edit();
        Intrinsics.checkNotNull(v0);
        arg2.invoke(v0);
        if(0 != 0) {
            v0.commit();
            return;
        }

        v0.apply();
    }
}

