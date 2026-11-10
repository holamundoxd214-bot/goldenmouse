package androidx.compose.foundation;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0000\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2={"LocalOverscrollConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/OverscrollConfiguration;", "getLocalOverscrollConfiguration$annotations", "()V", "getLocalOverscrollConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OverscrollConfiguration_androidKt {
    private static final ProvidableCompositionLocal LocalOverscrollConfiguration;

    static {
        OverscrollConfiguration_androidKt.LocalOverscrollConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new OverscrollConfiguration_androidKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final OverscrollConfiguration LocalOverscrollConfiguration$lambda$0() {
        return new OverscrollConfiguration(0, null, 3, null);
    }

    public static final ProvidableCompositionLocal getLocalOverscrollConfiguration() {
        return OverscrollConfiguration_androidKt.LocalOverscrollConfiguration;
    }

    @Deprecated(message="Providing `OverscrollConfiguration` through `LocalOverscrollConfiguration` to disable / configure overscroll has been replaced with `LocalOverscrollFactory` and `rememberPlatformOverscrollFactory`. To disable overscroll, instead of `LocalOverscrollConfiguration provides null`, use `LocalOverscrollFactory provides null`. To change the glow color / padding, instead of `LocalOverscrollConfiguration provides OverscrollConfiguration(myColor, myPadding)`, use `LocalOverscrollFactory provides rememberPlatformOverscrollFactory(myColor, myPadding)`", replaceWith="<_subannotation>") public static void getLocalOverscrollConfiguration$annotations() {
    }
}

