package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\"\"\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"LocalRippleTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ripple/RippleTheme;", "getLocalRippleTheme$annotations", "()V", "getLocalRippleTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LightThemeHighContrastRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeLowContrastRippleAlpha", "DarkThemeRippleAlpha", "RippleThemeDeprecationMessage", "", "material-ripple"}, k=2, mv={2, 0, 0}, xi=0x30) public final class RippleThemeKt {
    private static final RippleAlpha DarkThemeRippleAlpha = null;
    private static final RippleAlpha LightThemeHighContrastRippleAlpha = null;
    private static final RippleAlpha LightThemeLowContrastRippleAlpha = null;
    private static final ProvidableCompositionLocal LocalRippleTheme = null;
    private static final String RippleThemeDeprecationMessage = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com";

    static {
        RippleThemeKt.LocalRippleTheme = CompositionLocalKt.staticCompositionLocalOf(new RippleThemeKt$$ExternalSyntheticLambda0());
        RippleThemeKt.LightThemeHighContrastRippleAlpha = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);
        RippleThemeKt.LightThemeLowContrastRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);
        RippleThemeKt.DarkThemeRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);
    }

    static final RippleTheme LocalRippleTheme$lambda$0() {
        return DebugRippleTheme.INSTANCE;
    }

    public static final RippleAlpha access$getDarkThemeRippleAlpha$p() {
        return RippleThemeKt.DarkThemeRippleAlpha;
    }

    public static final RippleAlpha access$getLightThemeHighContrastRippleAlpha$p() {
        return RippleThemeKt.LightThemeHighContrastRippleAlpha;
    }

    public static final RippleAlpha access$getLightThemeLowContrastRippleAlpha$p() {
        return RippleThemeKt.LightThemeLowContrastRippleAlpha;
    }

    public static final ProvidableCompositionLocal getLocalRippleTheme() {
        return RippleThemeKt.LocalRippleTheme;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com") public static void getLocalRippleTheme$annotations() {
    }
}

