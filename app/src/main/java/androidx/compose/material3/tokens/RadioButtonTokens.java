package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u000E\u0010\f\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001A\u00020\u000E¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0007R\u0013\u0010\u001A\u001A\u00020\u000E¢\u0006\n\n\u0002\u0010\u0011\u001A\u0004\b\u001B\u0010\u0010R\u0011\u0010\u001C\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0011\u0010\u001E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0007R\u0011\u0010 \u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0007R\u0011\u0010\"\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0007¨\u0006$"}, d2={"Landroidx/compose/material3/tokens/RadioButtonTokens;", "", "<init>", "()V", "DisabledSelectedIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledSelectedIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledSelectedIconOpacity", "", "DisabledUnselectedIconColor", "getDisabledUnselectedIconColor", "DisabledUnselectedIconOpacity", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RadioButtonTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens DisabledSelectedIconColor = null;
    public static final float DisabledSelectedIconOpacity = 0.38f;
    private static final ColorSchemeKeyTokens DisabledUnselectedIconColor = null;
    public static final float DisabledUnselectedIconOpacity = 0.38f;
    public static final RadioButtonTokens INSTANCE;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;
    private static final ColorSchemeKeyTokens SelectedIconColor;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;
    private static final float StateLayerSize;
    private static final ColorSchemeKeyTokens UnselectedFocusIconColor;
    private static final ColorSchemeKeyTokens UnselectedHoverIconColor;
    private static final ColorSchemeKeyTokens UnselectedIconColor;
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor;

    static {
        RadioButtonTokens.INSTANCE = new RadioButtonTokens();
        RadioButtonTokens.DisabledSelectedIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.DisabledUnselectedIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.IconSize = Dp.constructor-impl(20f);
        RadioButtonTokens.SelectedFocusIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedHoverIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.SelectedPressedIconColor = ColorSchemeKeyTokens.Primary;
        RadioButtonTokens.StateLayerSize = Dp.constructor-impl(40f);
        RadioButtonTokens.UnselectedFocusIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.UnselectedHoverIconColor = ColorSchemeKeyTokens.OnSurface;
        RadioButtonTokens.UnselectedIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        RadioButtonTokens.UnselectedPressedIconColor = ColorSchemeKeyTokens.OnSurface;
    }

    private RadioButtonTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getDisabledSelectedIconColor() {
        return RadioButtonTokens.DisabledSelectedIconColor;
    }

    public final ColorSchemeKeyTokens getDisabledUnselectedIconColor() {
        return RadioButtonTokens.DisabledUnselectedIconColor;
    }

    public final float getIconSize-D9Ej5fM() {
        return RadioButtonTokens.IconSize;
    }

    public final ColorSchemeKeyTokens getSelectedFocusIconColor() {
        return RadioButtonTokens.SelectedFocusIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoverIconColor() {
        return RadioButtonTokens.SelectedHoverIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedIconColor() {
        return RadioButtonTokens.SelectedIconColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedIconColor() {
        return RadioButtonTokens.SelectedPressedIconColor;
    }

    public final float getStateLayerSize-D9Ej5fM() {
        return RadioButtonTokens.StateLayerSize;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusIconColor() {
        return RadioButtonTokens.UnselectedFocusIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoverIconColor() {
        return RadioButtonTokens.UnselectedHoverIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedIconColor() {
        return RadioButtonTokens.UnselectedIconColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedIconColor() {
        return RadioButtonTokens.UnselectedPressedIconColor;
    }
}

