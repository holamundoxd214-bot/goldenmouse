package androidx.savedstate;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A8\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001A8\u0010\t\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000B"}, d2={"read", "T", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "block", "Lkotlin/Function1;", "Landroidx/savedstate/SavedStateReader;", "Lkotlin/ExtensionFunctionType;", "(Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "write", "Landroidx/savedstate/SavedStateWriter;", "savedstate"}, k=5, mv={2, 0, 0}, xi=0x30, xs="androidx/savedstate/SavedStateKt") final class SavedStateKt__SavedStateKt {
    public static final Object read(Bundle arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(SavedStateReader.box-impl(SavedStateReader.constructor-impl(arg1)));
    }

    public static final Object write(Bundle arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "block");
        return arg2.invoke(SavedStateWriter.box-impl(SavedStateWriter.constructor-impl(arg1)));
    }
}

