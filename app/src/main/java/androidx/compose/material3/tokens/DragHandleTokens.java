package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0007R\u0013\u0010\u000F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000BR\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0011\u0010\u0013\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0018\u0010\u000BR\u0013\u0010\u0019\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001A\u0010\u000BR\u0013\u0010\u001B\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001C\u0010\u000BR\u0011\u0010\u001D\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0007R\u0013\u0010\u001F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b \u0010\u000BR\u0013\u0010!\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\"\u0010\u000BR\u0011\u0010#\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0016R\u0013\u0010%\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b&\u0010\u000BR\u0011\u0010\'\u001A\u00020\u0014¢\u0006\b\n\u0000\u001A\u0004\b(\u0010\u0016R\u0013\u0010)\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b*\u0010\u000B¨\u0006+"}, d2={"Landroidx/compose/material3/tokens/DragHandleTokens;", "", "<init>", "()V", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ContainerWidth", "Landroidx/compose/ui/unit/Dp;", "getContainerWidth-D9Ej5fM", "()F", "F", "DraggedColor", "getDraggedColor", "DraggedElevation", "getDraggedElevation-D9Ej5fM", "DraggedHeight", "getDraggedHeight-D9Ej5fM", "DraggedShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDraggedShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DraggedWidth", "getDraggedWidth-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM", "Height", "getHeight-D9Ej5fM", "PressedColor", "getPressedColor", "PressedElevation", "getPressedElevation-D9Ej5fM", "PressedHeight", "getPressedHeight-D9Ej5fM", "PressedShape", "getPressedShape", "PressedWidth", "getPressedWidth-D9Ej5fM", "Shape", "getShape", "Width", "getWidth-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DragHandleTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens Color;
    private static final float ContainerWidth;
    private static final ColorSchemeKeyTokens DraggedColor;
    private static final float DraggedElevation;
    private static final float DraggedHeight;
    private static final ShapeKeyTokens DraggedShape;
    private static final float DraggedWidth;
    private static final float Elevation;
    private static final float Height;
    public static final DragHandleTokens INSTANCE;
    private static final ColorSchemeKeyTokens PressedColor;
    private static final float PressedElevation;
    private static final float PressedHeight;
    private static final ShapeKeyTokens PressedShape;
    private static final float PressedWidth;
    private static final ShapeKeyTokens Shape;
    private static final float Width;

    static {
        DragHandleTokens.INSTANCE = new DragHandleTokens();
        DragHandleTokens.Color = ColorSchemeKeyTokens.Outline;
        DragHandleTokens.ContainerWidth = Dp.constructor-impl(24f);
        DragHandleTokens.DraggedColor = ColorSchemeKeyTokens.OnSurface;
        DragHandleTokens.DraggedElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DragHandleTokens.DraggedHeight = Dp.constructor-impl(52f);
        DragHandleTokens.DraggedShape = ShapeKeyTokens.CornerMedium;
        DragHandleTokens.DraggedWidth = Dp.constructor-impl(12f);
        DragHandleTokens.Elevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DragHandleTokens.Height = Dp.constructor-impl(48f);
        DragHandleTokens.PressedColor = ColorSchemeKeyTokens.OnSurface;
        DragHandleTokens.PressedElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DragHandleTokens.PressedHeight = Dp.constructor-impl(52f);
        DragHandleTokens.PressedShape = ShapeKeyTokens.CornerMedium;
        DragHandleTokens.PressedWidth = Dp.constructor-impl(12f);
        DragHandleTokens.Shape = ShapeKeyTokens.CornerFull;
        DragHandleTokens.Width = Dp.constructor-impl(4f);
    }

    private DragHandleTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getColor() {
        return DragHandleTokens.Color;
    }

    public final float getContainerWidth-D9Ej5fM() {
        return DragHandleTokens.ContainerWidth;
    }

    public final ColorSchemeKeyTokens getDraggedColor() {
        return DragHandleTokens.DraggedColor;
    }

    public final float getDraggedElevation-D9Ej5fM() {
        return DragHandleTokens.DraggedElevation;
    }

    public final float getDraggedHeight-D9Ej5fM() {
        return DragHandleTokens.DraggedHeight;
    }

    public final ShapeKeyTokens getDraggedShape() {
        return DragHandleTokens.DraggedShape;
    }

    public final float getDraggedWidth-D9Ej5fM() {
        return DragHandleTokens.DraggedWidth;
    }

    public final float getElevation-D9Ej5fM() {
        return DragHandleTokens.Elevation;
    }

    public final float getHeight-D9Ej5fM() {
        return DragHandleTokens.Height;
    }

    public final ColorSchemeKeyTokens getPressedColor() {
        return DragHandleTokens.PressedColor;
    }

    public final float getPressedElevation-D9Ej5fM() {
        return DragHandleTokens.PressedElevation;
    }

    public final float getPressedHeight-D9Ej5fM() {
        return DragHandleTokens.PressedHeight;
    }

    public final ShapeKeyTokens getPressedShape() {
        return DragHandleTokens.PressedShape;
    }

    public final float getPressedWidth-D9Ej5fM() {
        return DragHandleTokens.PressedWidth;
    }

    public final ShapeKeyTokens getShape() {
        return DragHandleTokens.Shape;
    }

    public final float getWidth-D9Ej5fM() {
        return DragHandleTokens.Width;
    }
}

