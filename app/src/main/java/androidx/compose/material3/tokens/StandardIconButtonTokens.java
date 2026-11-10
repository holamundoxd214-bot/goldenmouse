package androidx.compose.material3.tokens;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001B\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\tX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0011\u0010\u000E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0011\u0010\u0010\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001A\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0007R\u0011\u0010\u001C\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0011\u0010\u001E\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0007R\u0011\u0010 \u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0007R\u0011\u0010\"\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0007¨\u0006$"}, d2={"Landroidx/compose/material3/tokens/StandardIconButtonTokens;", "", "<init>", "()V", "DisabledColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledOpacity", "", "getDisabledOpacity", "()F", "FocusedColor", "getFocusedColor", "HoveredColor", "getHoveredColor", "Color", "getColor", "PressedColor", "getPressedColor", "SelectedFocusedColor", "getSelectedFocusedColor", "SelectedHoveredColor", "getSelectedHoveredColor", "SelectedColor", "getSelectedColor", "SelectedPressedColor", "getSelectedPressedColor", "UnselectedFocusedColor", "getUnselectedFocusedColor", "UnselectedHoveredColor", "getUnselectedHoveredColor", "UnselectedColor", "getUnselectedColor", "UnselectedPressedColor", "getUnselectedPressedColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StandardIconButtonTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens Color;
    private static final ColorSchemeKeyTokens DisabledColor;
    private static final float DisabledOpacity;
    private static final ColorSchemeKeyTokens FocusedColor;
    private static final ColorSchemeKeyTokens HoveredColor;
    public static final StandardIconButtonTokens INSTANCE;
    private static final ColorSchemeKeyTokens PressedColor;
    private static final ColorSchemeKeyTokens SelectedColor;
    private static final ColorSchemeKeyTokens SelectedFocusedColor;
    private static final ColorSchemeKeyTokens SelectedHoveredColor;
    private static final ColorSchemeKeyTokens SelectedPressedColor;
    private static final ColorSchemeKeyTokens UnselectedColor;
    private static final ColorSchemeKeyTokens UnselectedFocusedColor;
    private static final ColorSchemeKeyTokens UnselectedHoveredColor;
    private static final ColorSchemeKeyTokens UnselectedPressedColor;

    static {
        StandardIconButtonTokens.INSTANCE = new StandardIconButtonTokens();
        StandardIconButtonTokens.DisabledColor = ColorSchemeKeyTokens.OnSurface;
        StandardIconButtonTokens.DisabledOpacity = 0.38f;
        StandardIconButtonTokens.FocusedColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.HoveredColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.Color = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.PressedColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.SelectedFocusedColor = ColorSchemeKeyTokens.Primary;
        StandardIconButtonTokens.SelectedHoveredColor = ColorSchemeKeyTokens.Primary;
        StandardIconButtonTokens.SelectedColor = ColorSchemeKeyTokens.Primary;
        StandardIconButtonTokens.SelectedPressedColor = ColorSchemeKeyTokens.Primary;
        StandardIconButtonTokens.UnselectedFocusedColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.UnselectedHoveredColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.UnselectedColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        StandardIconButtonTokens.UnselectedPressedColor = ColorSchemeKeyTokens.OnSurfaceVariant;
    }

    private StandardIconButtonTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getColor() {
        return StandardIconButtonTokens.Color;
    }

    public final ColorSchemeKeyTokens getDisabledColor() {
        return StandardIconButtonTokens.DisabledColor;
    }

    public final float getDisabledOpacity() {
        return StandardIconButtonTokens.DisabledOpacity;
    }

    public final ColorSchemeKeyTokens getFocusedColor() {
        return StandardIconButtonTokens.FocusedColor;
    }

    public final ColorSchemeKeyTokens getHoveredColor() {
        return StandardIconButtonTokens.HoveredColor;
    }

    public final ColorSchemeKeyTokens getPressedColor() {
        return StandardIconButtonTokens.PressedColor;
    }

    public final ColorSchemeKeyTokens getSelectedColor() {
        return StandardIconButtonTokens.SelectedColor;
    }

    public final ColorSchemeKeyTokens getSelectedFocusedColor() {
        return StandardIconButtonTokens.SelectedFocusedColor;
    }

    public final ColorSchemeKeyTokens getSelectedHoveredColor() {
        return StandardIconButtonTokens.SelectedHoveredColor;
    }

    public final ColorSchemeKeyTokens getSelectedPressedColor() {
        return StandardIconButtonTokens.SelectedPressedColor;
    }

    public final ColorSchemeKeyTokens getUnselectedColor() {
        return StandardIconButtonTokens.UnselectedColor;
    }

    public final ColorSchemeKeyTokens getUnselectedFocusedColor() {
        return StandardIconButtonTokens.UnselectedFocusedColor;
    }

    public final ColorSchemeKeyTokens getUnselectedHoveredColor() {
        return StandardIconButtonTokens.UnselectedHoveredColor;
    }

    public final ColorSchemeKeyTokens getUnselectedPressedColor() {
        return StandardIconButtonTokens.UnselectedPressedColor;
    }
}

