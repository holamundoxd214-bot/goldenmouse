package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0002\u001Aí\u0003\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u00032\b\b\u0002\u0010\'\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\u00032\b\b\u0002\u0010)\u001A\u00020\u00032\b\b\u0002\u0010*\u001A\u00020\u00032\b\b\u0002\u0010+\u001A\u00020\u00032\b\b\u0002\u0010,\u001A\u00020\u00032\b\b\u0002\u0010-\u001A\u00020\u00032\b\b\u0002\u0010.\u001A\u00020\u00032\b\b\u0002\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\u00032\b\b\u0002\u00101\u001A\u00020\u00032\b\b\u0002\u00102\u001A\u00020\u0003¢\u0006\u0004\b3\u00104\u001Aí\u0003\u00105\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u00032\b\b\u0002\u0010\'\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020\u00032\b\b\u0002\u0010)\u001A\u00020\u00032\b\b\u0002\u0010*\u001A\u00020\u00032\b\b\u0002\u0010+\u001A\u00020\u00032\b\b\u0002\u0010,\u001A\u00020\u00032\b\b\u0002\u0010-\u001A\u00020\u00032\b\b\u0002\u0010.\u001A\u00020\u00032\b\b\u0002\u0010/\u001A\u00020\u00032\b\b\u0002\u00100\u001A\u00020\u00032\b\b\u0002\u00101\u001A\u00020\u00032\b\b\u0002\u00102\u001A\u00020\u0003¢\u0006\u0004\b6\u00104\u001A\u001B\u00107\u001A\u00020\u0003*\u00020\u00012\u0006\u00108\u001A\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001A\u0017\u00107\u001A\u00020\u00032\u0006\u00108\u001A\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001A\u001B\u0010=\u001A\u00020\u0003*\u00020\u00012\u0006\u0010>\u001A\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001A\b\u0010B\u001A\u00020\u0001H\u0000\u001A÷\u0002\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001A±\u0002\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001A÷\u0002\u00105\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010 \u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00032\b\b\u0002\u0010%\u001A\u00020\u00032\b\b\u0002\u0010&\u001A\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001A±\u0002\u00105\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00032\b\b\u0002\u0010\u0010\u001A\u00020\u00032\b\b\u0002\u0010\u0011\u001A\u00020\u00032\b\b\u0002\u0010\u0012\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\u00032\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\u00032\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u001D\u001A\u00020\u00032\b\b\u0002\u0010\u001E\u001A\u00020\u00032\b\b\u0002\u0010\u001F\u001A\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001A\u0019\u0010I\u001A\u00020\u0003*\u00020\u00012\u0006\u0010J\u001A\u00020KH\u0001¢\u0006\u0002\u0010L\u001A#\u0010U\u001A\u00020\u0003*\u00020\u00012\u0006\u00108\u001A\u00020\u00032\u0006\u0010>\u001A\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001A\u0010M\u001A\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bO\u0010P\"\u000E\u0010Q\u001A\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001A\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\bS\u0010T\"\u0017\u0010X\u001A\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001A\u0004\bZ\u0010P¨\u0006["}, d2={"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ColorSchemeKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[ColorSchemeKeyTokens.values().length];
            try {
                v0[ColorSchemeKeyTokens.Background.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[ColorSchemeKeyTokens.Error.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                        try {
                                        label_31:
                                            v0[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
                                            goto label_35;
                                        }
                                        catch(NoSuchFieldError ) {
                                            try {
                                            label_35:
                                                v0[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
                                                goto label_39;
                                            }
                                            catch(NoSuchFieldError ) {
                                                try {
                                                label_39:
                                                    v0[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
                                                    goto label_43;
                                                }
                                                catch(NoSuchFieldError ) {
                                                    try {
                                                    label_43:
                                                        v0[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
                                                        goto label_47;
                                                    }
                                                    catch(NoSuchFieldError ) {
                                                        try {
                                                        label_47:
                                                            v0[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
                                                            goto label_51;
                                                        }
                                                        catch(NoSuchFieldError ) {
                                                            try {
                                                            label_51:
                                                                v0[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
                                                                goto label_55;
                                                            }
                                                            catch(NoSuchFieldError ) {
                                                                try {
                                                                label_55:
                                                                    v0[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
                                                                    goto label_59;
                                                                }
                                                                catch(NoSuchFieldError ) {
                                                                    try {
                                                                    label_59:
                                                                        v0[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
                                                                        goto label_63;
                                                                    }
                                                                    catch(NoSuchFieldError ) {
                                                                        try {
                                                                        label_63:
                                                                            v0[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
                                                                            goto label_67;
                                                                        }
                                                                        catch(NoSuchFieldError ) {
                                                                            try {
                                                                            label_67:
                                                                                v0[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
                                                                                goto label_71;
                                                                            }
                                                                            catch(NoSuchFieldError ) {
                                                                                try {
                                                                                label_71:
                                                                                    v0[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
                                                                                    goto label_75;
                                                                                }
                                                                                catch(NoSuchFieldError ) {
                                                                                    try {
                                                                                    label_75:
                                                                                        v0[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
                                                                                        goto label_79;
                                                                                    }
                                                                                    catch(NoSuchFieldError ) {
                                                                                        try {
                                                                                        label_79:
                                                                                            v0[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
                                                                                            goto label_83;
                                                                                        }
                                                                                        catch(NoSuchFieldError ) {
                                                                                            try {
                                                                                            label_83:
                                                                                                v0[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
                                                                                                goto label_87;
                                                                                            }
                                                                                            catch(NoSuchFieldError ) {
                                                                                                try {
                                                                                                label_87:
                                                                                                    v0[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
                                                                                                    goto label_91;
                                                                                                }
                                                                                                catch(NoSuchFieldError ) {
                                                                                                    try {
                                                                                                    label_91:
                                                                                                        v0[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
                                                                                                        goto label_95;
                                                                                                    }
                                                                                                    catch(NoSuchFieldError ) {
                                                                                                        try {
                                                                                                        label_95:
                                                                                                            v0[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
                                                                                                            goto label_99;
                                                                                                        }
                                                                                                        catch(NoSuchFieldError ) {
                                                                                                            try {
                                                                                                            label_99:
                                                                                                                v0[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
                                                                                                                goto label_103;
                                                                                                            }
                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                try {
                                                                                                                label_103:
                                                                                                                    v0[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
                                                                                                                    goto label_107;
                                                                                                                }
                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                    try {
                                                                                                                    label_107:
                                                                                                                        v0[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
                                                                                                                        goto label_111;
                                                                                                                    }
                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                        try {
                                                                                                                        label_111:
                                                                                                                            v0[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
                                                                                                                            goto label_115;
                                                                                                                        }
                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                            try {
                                                                                                                            label_115:
                                                                                                                                v0[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
                                                                                                                                goto label_119;
                                                                                                                            }
                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                try {
                                                                                                                                label_119:
                                                                                                                                    v0[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
                                                                                                                                    goto label_123;
                                                                                                                                }
                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                    try {
                                                                                                                                    label_123:
                                                                                                                                        v0[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 0x1F;
                                                                                                                                        goto label_127;
                                                                                                                                    }
                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                        try {
                                                                                                                                        label_127:
                                                                                                                                            v0[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 0x20;
                                                                                                                                            goto label_131;
                                                                                                                                        }
                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                            try {
                                                                                                                                            label_131:
                                                                                                                                                v0[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
                                                                                                                                                goto label_135;
                                                                                                                                            }
                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                try {
                                                                                                                                                label_135:
                                                                                                                                                    v0[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
                                                                                                                                                    goto label_139;
                                                                                                                                                }
                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                    try {
                                                                                                                                                    label_139:
                                                                                                                                                        v0[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
                                                                                                                                                        goto label_143;
                                                                                                                                                    }
                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                        try {
                                                                                                                                                        label_143:
                                                                                                                                                            v0[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
                                                                                                                                                            goto label_147;
                                                                                                                                                        }
                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                            try {
                                                                                                                                                            label_147:
                                                                                                                                                                v0[ColorSchemeKeyTokens.PrimaryFixed.ordinal()] = 37;
                                                                                                                                                                goto label_151;
                                                                                                                                                            }
                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                try {
                                                                                                                                                                label_151:
                                                                                                                                                                    v0[ColorSchemeKeyTokens.PrimaryFixedDim.ordinal()] = 38;
                                                                                                                                                                    goto label_155;
                                                                                                                                                                }
                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                    try {
                                                                                                                                                                    label_155:
                                                                                                                                                                        v0[ColorSchemeKeyTokens.OnPrimaryFixed.ordinal()] = 39;
                                                                                                                                                                        goto label_159;
                                                                                                                                                                    }
                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                        try {
                                                                                                                                                                        label_159:
                                                                                                                                                                            v0[ColorSchemeKeyTokens.OnPrimaryFixedVariant.ordinal()] = 40;
                                                                                                                                                                            goto label_163;
                                                                                                                                                                        }
                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                            try {
                                                                                                                                                                            label_163:
                                                                                                                                                                                v0[ColorSchemeKeyTokens.SecondaryFixed.ordinal()] = 41;
                                                                                                                                                                                goto label_167;
                                                                                                                                                                            }
                                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                                try {
                                                                                                                                                                                label_167:
                                                                                                                                                                                    v0[ColorSchemeKeyTokens.SecondaryFixedDim.ordinal()] = 42;
                                                                                                                                                                                    goto label_171;
                                                                                                                                                                                }
                                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                                    try {
                                                                                                                                                                                    label_171:
                                                                                                                                                                                        v0[ColorSchemeKeyTokens.OnSecondaryFixed.ordinal()] = 43;
                                                                                                                                                                                        goto label_175;
                                                                                                                                                                                    }
                                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                                        try {
                                                                                                                                                                                        label_175:
                                                                                                                                                                                            v0[ColorSchemeKeyTokens.OnSecondaryFixedVariant.ordinal()] = 44;
                                                                                                                                                                                            goto label_179;
                                                                                                                                                                                        }
                                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                                            try {
                                                                                                                                                                                            label_179:
                                                                                                                                                                                                v0[ColorSchemeKeyTokens.TertiaryFixed.ordinal()] = 45;
                                                                                                                                                                                                goto label_183;
                                                                                                                                                                                            }
                                                                                                                                                                                            catch(NoSuchFieldError ) {
                                                                                                                                                                                                try {
                                                                                                                                                                                                label_183:
                                                                                                                                                                                                    v0[ColorSchemeKeyTokens.TertiaryFixedDim.ordinal()] = 46;
                                                                                                                                                                                                    goto label_187;
                                                                                                                                                                                                }
                                                                                                                                                                                                catch(NoSuchFieldError ) {
                                                                                                                                                                                                    try {
                                                                                                                                                                                                    label_187:
                                                                                                                                                                                                        v0[ColorSchemeKeyTokens.OnTertiaryFixed.ordinal()] = 0x2F;
                                                                                                                                                                                                        goto label_191;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    catch(NoSuchFieldError ) {
                                                                                                                                                                                                        try {
                                                                                                                                                                                                        label_191:
                                                                                                                                                                                                            v0[ColorSchemeKeyTokens.OnTertiaryFixedVariant.ordinal()] = 0x30;
                                                                                                                                                                                                            goto label_195;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        catch(NoSuchFieldError ) {
                                                                                                                                                                                                        label_195:
                                                                                                                                                                                                            WhenMappings.$EnumSwitchMapping$0 = v0;
                                                                                                                                                                                                            return;
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal LocalColorScheme;
    private static final ProvidableCompositionLocal LocalTonalElevationEnabled;

    static {
        ColorSchemeKt.LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new ColorSchemeKt$$ExternalSyntheticLambda0());
        ColorSchemeKt.LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new ColorSchemeKt$$ExternalSyntheticLambda1());
    }

    static final ColorScheme LocalColorScheme$lambda$1() {
        return ColorSchemeKt.lightColorScheme-_VG5OTI$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0xFFFF, null);
    }

    static final boolean LocalTonalElevationEnabled$lambda$2() {
        return 1;
    }

    public static final long applyTonalElevation-RFCenO8(ColorScheme arg3, long arg4, float arg6, Composer arg7, int arg8) {
        int v1 = 0x9FFA6E6E;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(applyTonalElevation)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)1540@70581L7:ColorScheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
        }

        ProvidableCompositionLocal v8 = ColorSchemeKt.LocalTonalElevationEnabled;
        ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v8_1 = arg7.consume(((CompositionLocal)v8));
        ComposerKt.sourceInformationMarkerEnd(arg7);
        boolean v8_2 = ((Boolean)v8_1).booleanValue();
        if((Color.equals-impl0(arg4, arg3.getSurface-0d7_KjU())) && (v8_2)) {
            arg4 = ColorSchemeKt.surfaceColorAtElevation-3ABfNKs(arg3, arg6);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return arg4;
    }

    public static final long contentColorFor-4WTKRHQ(ColorScheme arg2, long arg3) {
        if(Color.equals-impl0(arg3, arg2.getPrimary-0d7_KjU())) {
            return arg2.getOnPrimary-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSecondary-0d7_KjU())) {
            return arg2.getOnSecondary-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getTertiary-0d7_KjU())) {
            return arg2.getOnTertiary-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getBackground-0d7_KjU())) {
            return arg2.getOnBackground-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getError-0d7_KjU())) {
            return arg2.getOnError-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getPrimaryContainer-0d7_KjU())) {
            return arg2.getOnPrimaryContainer-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSecondaryContainer-0d7_KjU())) {
            return arg2.getOnSecondaryContainer-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getTertiaryContainer-0d7_KjU())) {
            return arg2.getOnTertiaryContainer-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getErrorContainer-0d7_KjU())) {
            return arg2.getOnErrorContainer-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getInverseSurface-0d7_KjU())) {
            return arg2.getInverseOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurface-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceVariant-0d7_KjU())) {
            return arg2.getOnSurfaceVariant-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceBright-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceContainer-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceContainerHigh-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceContainerHighest-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceContainerLow-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceContainerLowest-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSurfaceDim-0d7_KjU())) {
            return arg2.getOnSurface-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getPrimaryFixed-0d7_KjU())) {
            return arg2.getOnPrimaryFixed-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getPrimaryFixedDim-0d7_KjU())) {
            return arg2.getOnPrimaryFixed-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSecondaryFixed-0d7_KjU())) {
            return arg2.getOnSecondaryFixed-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getSecondaryFixedDim-0d7_KjU())) {
            return arg2.getOnSecondaryFixed-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getTertiaryFixed-0d7_KjU())) {
            return arg2.getOnTertiaryFixed-0d7_KjU();
        }

        if(Color.equals-impl0(arg3, arg2.getTertiaryFixedDim-0d7_KjU())) {
            return arg2.getOnTertiaryFixed-0d7_KjU();
        }

        return Color.Companion.getUnspecified-0d7_KjU();
    }

    public static final long contentColorFor-ek8zF_U(long arg3, Composer arg5, int arg6) {
        int v1 = 0x1E5FB886;
        ComposerKt.sourceInformationMarkerStart(arg5, v1, "C(contentColorFor)N(backgroundColor:c#ui.graphics.Color)1112@50936L11:ColorScheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg6, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
        }

        arg5.startReplaceGroup(0x553C0DA);
        ComposerKt.sourceInformation(arg5, "*1113@51020L7");
        arg3 = ColorSchemeKt.contentColorFor-4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(arg5, 6), arg3);
        if(arg3 != 16) {
        }
        else {
            ProvidableCompositionLocal v3 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v3_1 = arg5.consume(((CompositionLocal)v3));
            ComposerKt.sourceInformationMarkerEnd(arg5);
            arg3 = ((Color)v3_1).unbox-impl();
        }

        arg5.endReplaceGroup();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        return arg3;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional surface roles instead") public static final ColorScheme darkColorScheme-C-Xl9yA(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170) {
        return ColorSchemeKt.darkColorScheme-_VG5OTI$default(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg158, arg160, arg162, arg164, arg166, arg168, arg170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFFF0, null);
    }

    public static ColorScheme darkColorScheme-C-Xl9yA$default(long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, int arg131, int arg132, Object arg133) {
        int v0 = arg131;
        long v1 = (v0 & 1) != 0 ? ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU() : arg59;
        long v3 = (v0 & 2) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg61;
        long v5 = (v0 & 4) != 0 ? ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg63;
        long v7 = (v0 & 8) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg65;
        long v9 = (v0 & 16) != 0 ? ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg67;
        long v11 = (v0 & 0x20) != 0 ? ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU() : arg69;
        long v13 = (v0 & 0x40) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg71;
        long v15 = (v0 & 0x80) != 0 ? ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg73;
        arg59 = v1;
        v1 = (v0 & 0x100) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg75;
        arg75 = v1;
        v1 = (v0 & 0x200) != 0 ? ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU() : arg77;
        arg77 = v1;
        v1 = (v0 & 0x400) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg79;
        arg79 = v1;
        v1 = (v0 & 0x800) != 0 ? ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg81;
        arg81 = v1;
        v1 = (v0 & 0x1000) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg83;
        arg83 = v1;
        v1 = (v0 & 0x2000) != 0 ? ColorDarkTokens.INSTANCE.getBackground-0d7_KjU() : arg85;
        arg85 = v1;
        v1 = (v0 & 0x4000) != 0 ? ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU() : arg87;
        long v17 = (v0 & 0x8000) != 0 ? ColorDarkTokens.INSTANCE.getSurface-0d7_KjU() : arg89;
        long v19 = (v0 & 0x10000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU() : arg91;
        long v21 = (v0 & 0x20000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg93;
        long v23 = (v0 & 0x40000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg95;
        long v25 = (v0 & 0x80000) != 0 ? arg59 : arg97;
        long v27 = (v0 & 0x100000) != 0 ? ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg99;
        long v29 = (v0 & 0x200000) != 0 ? ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg101;
        long v31 = (v0 & 0x400000) != 0 ? ColorDarkTokens.INSTANCE.getError-0d7_KjU() : arg103;
        long v33 = (v0 & 0x800000) != 0 ? ColorDarkTokens.INSTANCE.getOnError-0d7_KjU() : arg105;
        long v35 = (v0 & 0x1000000) != 0 ? ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg107;
        long v37 = (v0 & 0x2000000) != 0 ? ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg109;
        long v39 = (v0 & 0x4000000) != 0 ? ColorDarkTokens.INSTANCE.getOutline-0d7_KjU() : arg111;
        long v41 = (v0 & 0x8000000) != 0 ? ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg113;
        long v43 = (v0 & 0x10000000) != 0 ? ColorDarkTokens.INSTANCE.getScrim-0d7_KjU() : arg115;
        long v45 = (v0 & 0x20000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceBright-0d7_KjU() : arg117;
        long v47 = (v0 & 0x40000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainer-0d7_KjU() : arg119;
        long v49 = (v0 & 0x80000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU() : arg121;
        long v51 = (arg132 & 1) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU() : arg123;
        long v53 = (arg132 & 2) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU() : arg125;
        long v55 = (arg132 & 4) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU() : arg127;
        if((arg132 & 8) != 0) {
            arg129 = ColorDarkTokens.INSTANCE.getSurfaceDim-0d7_KjU();
        }

        return ColorSchemeKt.darkColorScheme-C-Xl9yA(arg59, v3, v5, v7, v9, v11, v13, v15, arg75, arg77, arg79, arg81, arg83, arg85, v1, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, arg129);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional surface roles instead") public static final ColorScheme darkColorScheme-G1PFc-w(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156) {
        return ColorSchemeKt.darkColorScheme-_VG5OTI$default(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xE0000000, 0xFFFF, null);
    }

    public static ColorScheme darkColorScheme-G1PFc-w$default(long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, int arg103, Object arg104) {
        int v0 = arg103;
        long v1 = (v0 & 1) != 0 ? ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU() : arg45;
        long v3 = (v0 & 2) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg47;
        long v5 = (v0 & 4) != 0 ? ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg49;
        long v7 = (v0 & 8) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg51;
        long v9 = (v0 & 16) != 0 ? ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg53;
        long v11 = (v0 & 0x20) != 0 ? ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU() : arg55;
        long v13 = (v0 & 0x40) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg57;
        long v15 = (v0 & 0x80) != 0 ? ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg59;
        arg45 = v1;
        v1 = (v0 & 0x100) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg61;
        arg61 = v1;
        v1 = (v0 & 0x200) != 0 ? ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU() : arg63;
        arg63 = v1;
        v1 = (v0 & 0x400) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg65;
        arg65 = v1;
        v1 = (v0 & 0x800) != 0 ? ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg67;
        arg67 = v1;
        v1 = (v0 & 0x1000) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg69;
        arg69 = v1;
        v1 = (v0 & 0x2000) != 0 ? ColorDarkTokens.INSTANCE.getBackground-0d7_KjU() : arg71;
        arg71 = v1;
        v1 = (v0 & 0x4000) != 0 ? ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU() : arg73;
        long v17 = (v0 & 0x8000) != 0 ? ColorDarkTokens.INSTANCE.getSurface-0d7_KjU() : arg75;
        long v19 = (v0 & 0x10000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU() : arg77;
        long v21 = (v0 & 0x20000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg79;
        long v23 = (v0 & 0x40000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg81;
        long v25 = (v0 & 0x80000) != 0 ? arg45 : arg83;
        long v27 = (v0 & 0x100000) != 0 ? ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg85;
        long v29 = (v0 & 0x200000) != 0 ? ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg87;
        long v31 = (v0 & 0x400000) != 0 ? ColorDarkTokens.INSTANCE.getError-0d7_KjU() : arg89;
        long v33 = (v0 & 0x800000) != 0 ? ColorDarkTokens.INSTANCE.getOnError-0d7_KjU() : arg91;
        long v35 = (v0 & 0x1000000) != 0 ? ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg93;
        long v37 = (v0 & 0x2000000) != 0 ? ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg95;
        long v39 = (v0 & 0x4000000) != 0 ? ColorDarkTokens.INSTANCE.getOutline-0d7_KjU() : arg97;
        long v41 = (v0 & 0x8000000) != 0 ? ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg99;
        if((v0 & 0x10000000) != 0) {
            arg101 = ColorDarkTokens.INSTANCE.getScrim-0d7_KjU();
        }

        return ColorSchemeKt.darkColorScheme-G1PFc-w(arg45, v3, v5, v7, v9, v11, v13, v15, arg61, arg63, arg65, arg67, arg69, arg71, v1, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, arg101);
    }

    public static final ColorScheme darkColorScheme-_VG5OTI(long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170, long arg172, long arg174, long arg176, long arg178, long arg180, long arg182, long arg184, long arg186, long arg188, long arg190, long arg192) {
        return new ColorScheme(arg98, arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg168, arg158, arg160, arg162, arg164, arg166, arg170, arg172, arg174, arg176, arg178, arg180, arg182, arg184, arg186, arg188, arg190, arg192, null);
    }

    public static ColorScheme darkColorScheme-_VG5OTI$default(long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, long arg173, long arg175, int arg177, int arg178, Object arg179) {
        int v0 = arg177;
        int v1 = arg178;
        long v2 = (v0 & 1) != 0 ? ColorDarkTokens.INSTANCE.getPrimary-0d7_KjU() : arg81;
        long v4 = (v0 & 2) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg83;
        long v6 = (v0 & 4) != 0 ? ColorDarkTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg85;
        long v8 = (v0 & 8) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg87;
        long v10 = (v0 & 16) != 0 ? ColorDarkTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg89;
        long v12 = (v0 & 0x20) != 0 ? ColorDarkTokens.INSTANCE.getSecondary-0d7_KjU() : arg91;
        long v14 = (v0 & 0x40) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg93;
        arg81 = v2;
        v2 = (v0 & 0x80) != 0 ? ColorDarkTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg95;
        arg95 = v2;
        v2 = (v0 & 0x100) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg97;
        arg97 = v2;
        v2 = (v0 & 0x200) != 0 ? ColorDarkTokens.INSTANCE.getTertiary-0d7_KjU() : arg99;
        arg99 = v2;
        v2 = (v0 & 0x400) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg101;
        arg101 = v2;
        v2 = (v0 & 0x800) != 0 ? ColorDarkTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg103;
        arg103 = v2;
        v2 = (v0 & 0x1000) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg105;
        arg105 = v2;
        v2 = (v0 & 0x2000) != 0 ? ColorDarkTokens.INSTANCE.getBackground-0d7_KjU() : arg107;
        arg107 = v2;
        v2 = (v0 & 0x4000) != 0 ? ColorDarkTokens.INSTANCE.getOnBackground-0d7_KjU() : arg109;
        int v16 = 0x8000;
        long v17 = (v0 & v16) != 0 ? ColorDarkTokens.INSTANCE.getSurface-0d7_KjU() : arg111;
        long v19 = (v0 & 0x10000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurface-0d7_KjU() : arg113;
        long v21 = (v0 & 0x20000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg115;
        long v23 = (v0 & 0x40000) != 0 ? ColorDarkTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg117;
        long v25 = (v0 & 0x80000) != 0 ? arg81 : arg119;
        long v27 = (v0 & 0x100000) != 0 ? ColorDarkTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg121;
        long v29 = (v0 & 0x200000) != 0 ? ColorDarkTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg123;
        long v31 = (v0 & 0x400000) != 0 ? ColorDarkTokens.INSTANCE.getError-0d7_KjU() : arg125;
        long v33 = (v0 & 0x800000) != 0 ? ColorDarkTokens.INSTANCE.getOnError-0d7_KjU() : arg127;
        long v35 = (v0 & 0x1000000) != 0 ? ColorDarkTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg129;
        long v37 = (v0 & 0x2000000) != 0 ? ColorDarkTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg131;
        long v39 = (v0 & 0x4000000) != 0 ? ColorDarkTokens.INSTANCE.getOutline-0d7_KjU() : arg133;
        long v41 = (v0 & 0x8000000) != 0 ? ColorDarkTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg135;
        long v43 = (v0 & 0x10000000) != 0 ? ColorDarkTokens.INSTANCE.getScrim-0d7_KjU() : arg137;
        long v45 = (v0 & 0x20000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceBright-0d7_KjU() : arg139;
        long v47 = (v0 & 0x40000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainer-0d7_KjU() : arg141;
        long v49 = (v0 & 0x80000000) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU() : arg143;
        long v51 = (v1 & 1) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU() : arg145;
        long v53 = (v1 & 2) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU() : arg147;
        long v55 = (v1 & 4) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU() : arg149;
        long v57 = (v1 & 8) != 0 ? ColorDarkTokens.INSTANCE.getSurfaceDim-0d7_KjU() : arg151;
        long v59 = (v1 & 16) != 0 ? ColorDarkTokens.INSTANCE.getPrimaryFixed-0d7_KjU() : arg153;
        long v61 = (v1 & 0x20) != 0 ? ColorDarkTokens.INSTANCE.getPrimaryFixedDim-0d7_KjU() : arg155;
        long v63 = (v1 & 0x40) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimaryFixed-0d7_KjU() : arg157;
        long v65 = (v1 & 0x80) != 0 ? ColorDarkTokens.INSTANCE.getOnPrimaryFixedVariant-0d7_KjU() : arg159;
        long v67 = (v1 & 0x100) != 0 ? ColorDarkTokens.INSTANCE.getSecondaryFixed-0d7_KjU() : arg161;
        long v69 = (v1 & 0x200) != 0 ? ColorDarkTokens.INSTANCE.getSecondaryFixedDim-0d7_KjU() : arg163;
        long v71 = (v1 & 0x400) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondaryFixed-0d7_KjU() : arg165;
        long v73 = (v1 & 0x800) != 0 ? ColorDarkTokens.INSTANCE.getOnSecondaryFixedVariant-0d7_KjU() : arg167;
        long v75 = (v1 & 0x1000) != 0 ? ColorDarkTokens.INSTANCE.getTertiaryFixed-0d7_KjU() : arg169;
        long v77 = (v1 & 0x2000) != 0 ? ColorDarkTokens.INSTANCE.getTertiaryFixedDim-0d7_KjU() : arg171;
        long v79 = (v1 & 0x4000) != 0 ? ColorDarkTokens.INSTANCE.getOnTertiaryFixed-0d7_KjU() : arg173;
        if((v1 & v16) != 0) {
            arg175 = ColorDarkTokens.INSTANCE.getOnTertiaryFixedVariant-0d7_KjU();
        }

        return ColorSchemeKt.darkColorScheme-_VG5OTI(arg81, v4, v6, v8, v10, v12, v14, arg95, arg97, arg99, arg101, arg103, arg105, arg107, v2, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, arg175);
    }

    public static final ColorScheme expressiveLightColorScheme() {
        return ColorSchemeKt.lightColorScheme-_VG5OTI$default(0, 0, 0, PaletteTokens.INSTANCE.getPrimary30-0d7_KjU(), 0, 0, 0, 0, PaletteTokens.INSTANCE.getSecondary30-0d7_KjU(), 0, 0, 0, PaletteTokens.INSTANCE.getTertiary30-0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, PaletteTokens.INSTANCE.getError30-0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFDFFEEF7, 0xFFFF, null);
    }

    public static final long fromToken(ColorScheme arg1, ColorSchemeKeyTokens arg2) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()]) {
            case 1: {
                goto label_101;
            }
            case 2: {
                goto label_99;
            }
            case 3: {
                goto label_97;
            }
            case 4: {
                goto label_95;
            }
            case 5: {
                goto label_93;
            }
            case 6: {
                goto label_91;
            }
            case 7: {
                goto label_89;
            }
            case 8: {
                goto label_87;
            }
            case 9: {
                goto label_85;
            }
            case 10: {
                goto label_83;
            }
            case 11: {
                goto label_81;
            }
            case 12: {
                goto label_79;
            }
            case 13: {
                goto label_77;
            }
            case 14: {
                goto label_75;
            }
            case 15: {
                goto label_73;
            }
            case 16: {
                goto label_71;
            }
            case 17: {
                goto label_69;
            }
            case 18: {
                goto label_67;
            }
            case 19: {
                goto label_65;
            }
            case 20: {
                goto label_63;
            }
            case 21: {
                goto label_61;
            }
            case 22: {
                goto label_59;
            }
            case 23: {
                goto label_57;
            }
            case 24: {
                goto label_55;
            }
            case 25: {
                goto label_53;
            }
            case 26: {
                goto label_51;
            }
            case 27: {
                goto label_49;
            }
            case 28: {
                goto label_47;
            }
            case 29: {
                goto label_45;
            }
            case 30: {
                goto label_43;
            }
            case 31: {
                goto label_41;
            }
            case 32: {
                goto label_39;
            }
            case 33: {
                goto label_37;
            }
            case 34: {
                goto label_35;
            }
            case 35: {
                goto label_33;
            }
            case 36: {
                goto label_31;
            }
            case 37: {
                goto label_29;
            }
            case 38: {
                goto label_27;
            }
            case 39: {
                goto label_25;
            }
            case 40: {
                goto label_23;
            }
            case 41: {
                goto label_21;
            }
            case 42: {
                goto label_19;
            }
            case 43: {
                goto label_17;
            }
            case 44: {
                goto label_15;
            }
            case 45: {
                goto label_13;
            }
            case 46: {
                goto label_11;
            }
            case 47: {
                goto label_9;
            }
            case 48: {
                goto label_7;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_97:
        return arg1.getErrorContainer-0d7_KjU();
    label_99:
        return arg1.getError-0d7_KjU();
    label_101:
        return arg1.getBackground-0d7_KjU();
    label_7:
        return arg1.getOnTertiaryFixedVariant-0d7_KjU();
    label_9:
        return arg1.getOnTertiaryFixed-0d7_KjU();
    label_11:
        return arg1.getTertiaryFixedDim-0d7_KjU();
    label_13:
        return arg1.getTertiaryFixed-0d7_KjU();
    label_15:
        return arg1.getOnSecondaryFixedVariant-0d7_KjU();
    label_17:
        return arg1.getOnSecondaryFixed-0d7_KjU();
    label_19:
        return arg1.getSecondaryFixedDim-0d7_KjU();
    label_21:
        return arg1.getSecondaryFixed-0d7_KjU();
    label_23:
        return arg1.getOnPrimaryFixedVariant-0d7_KjU();
    label_25:
        return arg1.getOnPrimaryFixed-0d7_KjU();
    label_27:
        return arg1.getPrimaryFixedDim-0d7_KjU();
    label_29:
        return arg1.getPrimaryFixed-0d7_KjU();
    label_31:
        return arg1.getTertiaryContainer-0d7_KjU();
    label_33:
        return arg1.getTertiary-0d7_KjU();
    label_35:
        return arg1.getSurfaceDim-0d7_KjU();
    label_37:
        return arg1.getSurfaceContainerLowest-0d7_KjU();
    label_39:
        return arg1.getSurfaceContainerLow-0d7_KjU();
    label_41:
        return arg1.getSurfaceContainerHighest-0d7_KjU();
    label_43:
        return arg1.getSurfaceContainerHigh-0d7_KjU();
    label_45:
        return arg1.getSurfaceContainer-0d7_KjU();
    label_47:
        return arg1.getSurfaceBright-0d7_KjU();
    label_49:
        return arg1.getSurfaceVariant-0d7_KjU();
    label_51:
        return arg1.getSurface-0d7_KjU();
    label_53:
        return arg1.getSecondaryContainer-0d7_KjU();
    label_55:
        return arg1.getSecondary-0d7_KjU();
    label_57:
        return arg1.getScrim-0d7_KjU();
    label_59:
        return arg1.getPrimaryContainer-0d7_KjU();
    label_61:
        return arg1.getPrimary-0d7_KjU();
    label_63:
        return arg1.getOutlineVariant-0d7_KjU();
    label_65:
        return arg1.getOutline-0d7_KjU();
    label_67:
        return arg1.getOnTertiaryContainer-0d7_KjU();
    label_69:
        return arg1.getOnTertiary-0d7_KjU();
    label_71:
        return arg1.getSurfaceTint-0d7_KjU();
    label_73:
        return arg1.getOnSurfaceVariant-0d7_KjU();
    label_75:
        return arg1.getOnSurface-0d7_KjU();
    label_77:
        return arg1.getOnSecondaryContainer-0d7_KjU();
    label_79:
        return arg1.getOnSecondary-0d7_KjU();
    label_81:
        return arg1.getOnPrimaryContainer-0d7_KjU();
    label_83:
        return arg1.getOnPrimary-0d7_KjU();
    label_85:
        return arg1.getOnErrorContainer-0d7_KjU();
    label_87:
        return arg1.getOnError-0d7_KjU();
    label_89:
        return arg1.getOnBackground-0d7_KjU();
    label_91:
        return arg1.getInverseSurface-0d7_KjU();
    label_93:
        return arg1.getInversePrimary-0d7_KjU();
    label_95:
        return arg1.getInverseOnSurface-0d7_KjU();
    }

    public static final ProvidableCompositionLocal getLocalColorScheme() {
        return ColorSchemeKt.LocalColorScheme;
    }

    public static final ProvidableCompositionLocal getLocalTonalElevationEnabled() {
        return ColorSchemeKt.LocalTonalElevationEnabled;
    }

    public static final long getValue(ColorSchemeKeyTokens arg3, Composer arg4, int arg5) {
        int v1 = -810780884;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-value>)1524@69711L11:ColorScheme.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1524)");
        }

        long v0 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(arg4, 6), arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v0;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional Fixed roles instead") public static final ColorScheme lightColorScheme-C-Xl9yA(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170) {
        return ColorSchemeKt.lightColorScheme-_VG5OTI$default(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg158, arg160, arg162, arg164, arg166, arg168, arg170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFFF0, null);
    }

    public static ColorScheme lightColorScheme-C-Xl9yA$default(long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, int arg131, int arg132, Object arg133) {
        int v0 = arg131;
        long v1 = (v0 & 1) != 0 ? ColorLightTokens.INSTANCE.getPrimary-0d7_KjU() : arg59;
        long v3 = (v0 & 2) != 0 ? ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg61;
        long v5 = (v0 & 4) != 0 ? ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg63;
        long v7 = (v0 & 8) != 0 ? ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg65;
        long v9 = (v0 & 16) != 0 ? ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg67;
        long v11 = (v0 & 0x20) != 0 ? ColorLightTokens.INSTANCE.getSecondary-0d7_KjU() : arg69;
        long v13 = (v0 & 0x40) != 0 ? ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg71;
        long v15 = (v0 & 0x80) != 0 ? ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg73;
        arg59 = v1;
        v1 = (v0 & 0x100) != 0 ? ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg75;
        arg75 = v1;
        v1 = (v0 & 0x200) != 0 ? ColorLightTokens.INSTANCE.getTertiary-0d7_KjU() : arg77;
        arg77 = v1;
        v1 = (v0 & 0x400) != 0 ? ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg79;
        arg79 = v1;
        v1 = (v0 & 0x800) != 0 ? ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg81;
        arg81 = v1;
        v1 = (v0 & 0x1000) != 0 ? ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg83;
        arg83 = v1;
        v1 = (v0 & 0x2000) != 0 ? ColorLightTokens.INSTANCE.getBackground-0d7_KjU() : arg85;
        arg85 = v1;
        v1 = (v0 & 0x4000) != 0 ? ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU() : arg87;
        long v17 = (v0 & 0x8000) != 0 ? ColorLightTokens.INSTANCE.getSurface-0d7_KjU() : arg89;
        long v19 = (v0 & 0x10000) != 0 ? ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU() : arg91;
        long v21 = (v0 & 0x20000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg93;
        long v23 = (v0 & 0x40000) != 0 ? ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg95;
        long v25 = (v0 & 0x80000) != 0 ? arg59 : arg97;
        long v27 = (v0 & 0x100000) != 0 ? ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg99;
        long v29 = (v0 & 0x200000) != 0 ? ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg101;
        long v31 = (v0 & 0x400000) != 0 ? ColorLightTokens.INSTANCE.getError-0d7_KjU() : arg103;
        long v33 = (v0 & 0x800000) != 0 ? ColorLightTokens.INSTANCE.getOnError-0d7_KjU() : arg105;
        long v35 = (v0 & 0x1000000) != 0 ? ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg107;
        long v37 = (v0 & 0x2000000) != 0 ? ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg109;
        long v39 = (v0 & 0x4000000) != 0 ? ColorLightTokens.INSTANCE.getOutline-0d7_KjU() : arg111;
        long v41 = (v0 & 0x8000000) != 0 ? ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg113;
        long v43 = (v0 & 0x10000000) != 0 ? ColorLightTokens.INSTANCE.getScrim-0d7_KjU() : arg115;
        long v45 = (v0 & 0x20000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceBright-0d7_KjU() : arg117;
        long v47 = (v0 & 0x40000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainer-0d7_KjU() : arg119;
        long v49 = (v0 & 0x80000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU() : arg121;
        long v51 = (arg132 & 1) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU() : arg123;
        long v53 = (arg132 & 2) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU() : arg125;
        long v55 = (arg132 & 4) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU() : arg127;
        if((arg132 & 8) != 0) {
            arg129 = ColorLightTokens.INSTANCE.getSurfaceDim-0d7_KjU();
        }

        return ColorSchemeKt.lightColorScheme-C-Xl9yA(arg59, v3, v5, v7, v9, v11, v13, v15, arg75, arg77, arg79, arg81, arg83, arg85, v1, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, arg129);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with additional surface roles instead") public static final ColorScheme lightColorScheme-G1PFc-w(long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156) {
        return ColorSchemeKt.lightColorScheme-_VG5OTI$default(arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xE0000000, 0xFFFF, null);
    }

    public static ColorScheme lightColorScheme-G1PFc-w$default(long arg45, long arg47, long arg49, long arg51, long arg53, long arg55, long arg57, long arg59, long arg61, long arg63, long arg65, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, int arg103, Object arg104) {
        int v0 = arg103;
        long v1 = (v0 & 1) != 0 ? ColorLightTokens.INSTANCE.getPrimary-0d7_KjU() : arg45;
        long v3 = (v0 & 2) != 0 ? ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg47;
        long v5 = (v0 & 4) != 0 ? ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg49;
        long v7 = (v0 & 8) != 0 ? ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg51;
        long v9 = (v0 & 16) != 0 ? ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg53;
        long v11 = (v0 & 0x20) != 0 ? ColorLightTokens.INSTANCE.getSecondary-0d7_KjU() : arg55;
        long v13 = (v0 & 0x40) != 0 ? ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg57;
        long v15 = (v0 & 0x80) != 0 ? ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg59;
        arg45 = v1;
        v1 = (v0 & 0x100) != 0 ? ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg61;
        arg61 = v1;
        v1 = (v0 & 0x200) != 0 ? ColorLightTokens.INSTANCE.getTertiary-0d7_KjU() : arg63;
        arg63 = v1;
        v1 = (v0 & 0x400) != 0 ? ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg65;
        arg65 = v1;
        v1 = (v0 & 0x800) != 0 ? ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg67;
        arg67 = v1;
        v1 = (v0 & 0x1000) != 0 ? ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg69;
        arg69 = v1;
        v1 = (v0 & 0x2000) != 0 ? ColorLightTokens.INSTANCE.getBackground-0d7_KjU() : arg71;
        arg71 = v1;
        v1 = (v0 & 0x4000) != 0 ? ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU() : arg73;
        long v17 = (v0 & 0x8000) != 0 ? ColorLightTokens.INSTANCE.getSurface-0d7_KjU() : arg75;
        long v19 = (v0 & 0x10000) != 0 ? ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU() : arg77;
        long v21 = (v0 & 0x20000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg79;
        long v23 = (v0 & 0x40000) != 0 ? ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg81;
        long v25 = (v0 & 0x80000) != 0 ? arg45 : arg83;
        long v27 = (v0 & 0x100000) != 0 ? ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg85;
        long v29 = (v0 & 0x200000) != 0 ? ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg87;
        long v31 = (v0 & 0x400000) != 0 ? ColorLightTokens.INSTANCE.getError-0d7_KjU() : arg89;
        long v33 = (v0 & 0x800000) != 0 ? ColorLightTokens.INSTANCE.getOnError-0d7_KjU() : arg91;
        long v35 = (v0 & 0x1000000) != 0 ? ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg93;
        long v37 = (v0 & 0x2000000) != 0 ? ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg95;
        long v39 = (v0 & 0x4000000) != 0 ? ColorLightTokens.INSTANCE.getOutline-0d7_KjU() : arg97;
        long v41 = (v0 & 0x8000000) != 0 ? ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg99;
        if((v0 & 0x10000000) != 0) {
            arg101 = ColorLightTokens.INSTANCE.getScrim-0d7_KjU();
        }

        return ColorSchemeKt.lightColorScheme-G1PFc-w(arg45, v3, v5, v7, v9, v11, v13, v15, arg61, arg63, arg65, arg67, arg69, arg71, v1, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, arg101);
    }

    public static final ColorScheme lightColorScheme-_VG5OTI(long arg98, long arg100, long arg102, long arg104, long arg106, long arg108, long arg110, long arg112, long arg114, long arg116, long arg118, long arg120, long arg122, long arg124, long arg126, long arg128, long arg130, long arg132, long arg134, long arg136, long arg138, long arg140, long arg142, long arg144, long arg146, long arg148, long arg150, long arg152, long arg154, long arg156, long arg158, long arg160, long arg162, long arg164, long arg166, long arg168, long arg170, long arg172, long arg174, long arg176, long arg178, long arg180, long arg182, long arg184, long arg186, long arg188, long arg190, long arg192) {
        return new ColorScheme(arg98, arg100, arg102, arg104, arg106, arg108, arg110, arg112, arg114, arg116, arg118, arg120, arg122, arg124, arg126, arg128, arg130, arg132, arg134, arg136, arg138, arg140, arg142, arg144, arg146, arg148, arg150, arg152, arg154, arg156, arg168, arg158, arg160, arg162, arg164, arg166, arg170, arg172, arg174, arg176, arg178, arg180, arg182, arg184, arg186, arg188, arg190, arg192, null);
    }

    public static ColorScheme lightColorScheme-_VG5OTI$default(long arg81, long arg83, long arg85, long arg87, long arg89, long arg91, long arg93, long arg95, long arg97, long arg99, long arg101, long arg103, long arg105, long arg107, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, long arg173, long arg175, int arg177, int arg178, Object arg179) {
        int v0 = arg177;
        int v1 = arg178;
        long v2 = (v0 & 1) != 0 ? ColorLightTokens.INSTANCE.getPrimary-0d7_KjU() : arg81;
        long v4 = (v0 & 2) != 0 ? ColorLightTokens.INSTANCE.getOnPrimary-0d7_KjU() : arg83;
        long v6 = (v0 & 4) != 0 ? ColorLightTokens.INSTANCE.getPrimaryContainer-0d7_KjU() : arg85;
        long v8 = (v0 & 8) != 0 ? ColorLightTokens.INSTANCE.getOnPrimaryContainer-0d7_KjU() : arg87;
        long v10 = (v0 & 16) != 0 ? ColorLightTokens.INSTANCE.getInversePrimary-0d7_KjU() : arg89;
        long v12 = (v0 & 0x20) != 0 ? ColorLightTokens.INSTANCE.getSecondary-0d7_KjU() : arg91;
        long v14 = (v0 & 0x40) != 0 ? ColorLightTokens.INSTANCE.getOnSecondary-0d7_KjU() : arg93;
        arg81 = v2;
        v2 = (v0 & 0x80) != 0 ? ColorLightTokens.INSTANCE.getSecondaryContainer-0d7_KjU() : arg95;
        arg95 = v2;
        v2 = (v0 & 0x100) != 0 ? ColorLightTokens.INSTANCE.getOnSecondaryContainer-0d7_KjU() : arg97;
        arg97 = v2;
        v2 = (v0 & 0x200) != 0 ? ColorLightTokens.INSTANCE.getTertiary-0d7_KjU() : arg99;
        arg99 = v2;
        v2 = (v0 & 0x400) != 0 ? ColorLightTokens.INSTANCE.getOnTertiary-0d7_KjU() : arg101;
        arg101 = v2;
        v2 = (v0 & 0x800) != 0 ? ColorLightTokens.INSTANCE.getTertiaryContainer-0d7_KjU() : arg103;
        arg103 = v2;
        v2 = (v0 & 0x1000) != 0 ? ColorLightTokens.INSTANCE.getOnTertiaryContainer-0d7_KjU() : arg105;
        arg105 = v2;
        v2 = (v0 & 0x2000) != 0 ? ColorLightTokens.INSTANCE.getBackground-0d7_KjU() : arg107;
        arg107 = v2;
        v2 = (v0 & 0x4000) != 0 ? ColorLightTokens.INSTANCE.getOnBackground-0d7_KjU() : arg109;
        int v16 = 0x8000;
        long v17 = (v0 & v16) != 0 ? ColorLightTokens.INSTANCE.getSurface-0d7_KjU() : arg111;
        long v19 = (v0 & 0x10000) != 0 ? ColorLightTokens.INSTANCE.getOnSurface-0d7_KjU() : arg113;
        long v21 = (v0 & 0x20000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceVariant-0d7_KjU() : arg115;
        long v23 = (v0 & 0x40000) != 0 ? ColorLightTokens.INSTANCE.getOnSurfaceVariant-0d7_KjU() : arg117;
        long v25 = (v0 & 0x80000) != 0 ? arg81 : arg119;
        long v27 = (v0 & 0x100000) != 0 ? ColorLightTokens.INSTANCE.getInverseSurface-0d7_KjU() : arg121;
        long v29 = (v0 & 0x200000) != 0 ? ColorLightTokens.INSTANCE.getInverseOnSurface-0d7_KjU() : arg123;
        long v31 = (v0 & 0x400000) != 0 ? ColorLightTokens.INSTANCE.getError-0d7_KjU() : arg125;
        long v33 = (v0 & 0x800000) != 0 ? ColorLightTokens.INSTANCE.getOnError-0d7_KjU() : arg127;
        long v35 = (v0 & 0x1000000) != 0 ? ColorLightTokens.INSTANCE.getErrorContainer-0d7_KjU() : arg129;
        long v37 = (v0 & 0x2000000) != 0 ? ColorLightTokens.INSTANCE.getOnErrorContainer-0d7_KjU() : arg131;
        long v39 = (v0 & 0x4000000) != 0 ? ColorLightTokens.INSTANCE.getOutline-0d7_KjU() : arg133;
        long v41 = (v0 & 0x8000000) != 0 ? ColorLightTokens.INSTANCE.getOutlineVariant-0d7_KjU() : arg135;
        long v43 = (v0 & 0x10000000) != 0 ? ColorLightTokens.INSTANCE.getScrim-0d7_KjU() : arg137;
        long v45 = (v0 & 0x20000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceBright-0d7_KjU() : arg139;
        long v47 = (v0 & 0x40000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainer-0d7_KjU() : arg141;
        long v49 = (v0 & 0x80000000) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerHigh-0d7_KjU() : arg143;
        long v51 = (v1 & 1) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerHighest-0d7_KjU() : arg145;
        long v53 = (v1 & 2) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerLow-0d7_KjU() : arg147;
        long v55 = (v1 & 4) != 0 ? ColorLightTokens.INSTANCE.getSurfaceContainerLowest-0d7_KjU() : arg149;
        long v57 = (v1 & 8) != 0 ? ColorLightTokens.INSTANCE.getSurfaceDim-0d7_KjU() : arg151;
        long v59 = (v1 & 16) != 0 ? ColorLightTokens.INSTANCE.getPrimaryFixed-0d7_KjU() : arg153;
        long v61 = (v1 & 0x20) != 0 ? ColorLightTokens.INSTANCE.getPrimaryFixedDim-0d7_KjU() : arg155;
        long v63 = (v1 & 0x40) != 0 ? ColorLightTokens.INSTANCE.getOnPrimaryFixed-0d7_KjU() : arg157;
        long v65 = (v1 & 0x80) != 0 ? ColorLightTokens.INSTANCE.getOnPrimaryFixedVariant-0d7_KjU() : arg159;
        long v67 = (v1 & 0x100) != 0 ? ColorLightTokens.INSTANCE.getSecondaryFixed-0d7_KjU() : arg161;
        long v69 = (v1 & 0x200) != 0 ? ColorLightTokens.INSTANCE.getSecondaryFixedDim-0d7_KjU() : arg163;
        long v71 = (v1 & 0x400) != 0 ? ColorLightTokens.INSTANCE.getOnSecondaryFixed-0d7_KjU() : arg165;
        long v73 = (v1 & 0x800) != 0 ? ColorLightTokens.INSTANCE.getOnSecondaryFixedVariant-0d7_KjU() : arg167;
        long v75 = (v1 & 0x1000) != 0 ? ColorLightTokens.INSTANCE.getTertiaryFixed-0d7_KjU() : arg169;
        long v77 = (v1 & 0x2000) != 0 ? ColorLightTokens.INSTANCE.getTertiaryFixedDim-0d7_KjU() : arg171;
        long v79 = (v1 & 0x4000) != 0 ? ColorLightTokens.INSTANCE.getOnTertiaryFixed-0d7_KjU() : arg173;
        if((v1 & v16) != 0) {
            arg175 = ColorLightTokens.INSTANCE.getOnTertiaryFixedVariant-0d7_KjU();
        }

        return ColorSchemeKt.lightColorScheme-_VG5OTI(arg81, v4, v6, v8, v10, v12, v14, arg95, arg97, arg99, arg101, arg103, arg105, arg107, v2, v17, v19, v21, v23, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, arg175);
    }

    public static final long surfaceColorAtElevation-3ABfNKs(ColorScheme arg9, float arg10) {
        if(Dp.equals-impl0(arg10, Dp.constructor-impl(0f))) {
            return arg9.getSurface-0d7_KjU();
        }

        return ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(arg9.getSurfaceTint-0d7_KjU(), ((((float)Math.log(((double)(arg10 + 1f))))) * 4.5f + 2f) / 100f, 0f, 0f, 0f, 14, null), arg9.getSurface-0d7_KjU());
    }
}

