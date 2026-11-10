package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"LocalHostDefaultProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/HostDefaultProvider;", "getLocalHostDefaultProvider", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class HostDefaultProviderKt {
    private static final ProvidableCompositionLocal LocalHostDefaultProvider;

    static {
        HostDefaultProviderKt.LocalHostDefaultProvider = CompositionLocalKt.compositionLocalOf$default(null, new HostDefaultProviderKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final HostDefaultProvider LocalHostDefaultProvider$lambda$0() {
        throw new IllegalStateException("CompositionLocal LocalHostDefaultProvider not present".toString());
    }

    public static final ProvidableCompositionLocal getLocalHostDefaultProvider() {
        return HostDefaultProviderKt.LocalHostDefaultProvider;
    }
}

