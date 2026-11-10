package androidx.lifecycle.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalLifecycleOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "lifecycle-runtime-compose"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LocalLifecycleOwnerKt {
    private static final ProvidableCompositionLocal LocalLifecycleOwner;

    static {
        LocalLifecycleOwnerKt.LocalLifecycleOwner = CompositionLocalKt.staticCompositionLocalOf(new LocalLifecycleOwnerKt$$ExternalSyntheticLambda0());
    }

    static final LifecycleOwner LocalLifecycleOwner$lambda$0() {
        throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
    }

    public static final ProvidableCompositionLocal getLocalLifecycleOwner() {
        return LocalLifecycleOwnerKt.LocalLifecycleOwner;
    }
}

