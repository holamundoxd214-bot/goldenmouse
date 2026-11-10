package androidx.compose.runtime.tooling;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalCompositionErrorContext", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/tooling/CompositionErrorContext;", "getLocalCompositionErrorContext", "()Landroidx/compose/runtime/CompositionLocal;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositionErrorContextKt {
    private static final CompositionLocal LocalCompositionErrorContext;

    static {
        CompositionErrorContextKt.LocalCompositionErrorContext = CompositionLocalKt.staticCompositionLocalOf(new CompositionErrorContextKt$$ExternalSyntheticLambda0());
    }

    static final CompositionErrorContext LocalCompositionErrorContext$lambda$0() {
        return null;
    }

    public static final CompositionLocal getLocalCompositionErrorContext() {
        return CompositionErrorContextKt.LocalCompositionErrorContext;
    }
}

