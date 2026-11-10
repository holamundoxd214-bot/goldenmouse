package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0013\u0010\u000E\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0015\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000BR\u0013\u0010\u0017\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u0018\u0010\u0011R\u0013\u0010\u0019\u001A\u00020\u000F¢\u0006\n\n\u0002\u0010\u0012\u001A\u0004\b\u001A\u0010\u0011R\u0011\u0010\u001B\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0007¨\u0006\u001D"}, d2={"Landroidx/compose/material3/tokens/SheetBottomTokens;", "", "<init>", "()V", "DockedContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDockedContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DockedContainerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getDockedContainerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "DockedDragHandleColor", "getDockedDragHandleColor", "DockedDragHandleHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedDragHandleHeight-D9Ej5fM", "()F", "F", "DockedDragHandleWidth", "getDockedDragHandleWidth-D9Ej5fM", "DockedMinimizedContainerShape", "getDockedMinimizedContainerShape", "DockedModalContainerElevation", "getDockedModalContainerElevation-D9Ej5fM", "DockedStandardContainerElevation", "getDockedStandardContainerElevation-D9Ej5fM", "FocusIndicatorColor", "getFocusIndicatorColor", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SheetBottomTokens {
    public static final int $stable;
    private static final ColorSchemeKeyTokens DockedContainerColor;
    private static final ShapeKeyTokens DockedContainerShape;
    private static final ColorSchemeKeyTokens DockedDragHandleColor;
    private static final float DockedDragHandleHeight;
    private static final float DockedDragHandleWidth;
    private static final ShapeKeyTokens DockedMinimizedContainerShape;
    private static final float DockedModalContainerElevation;
    private static final float DockedStandardContainerElevation;
    private static final ColorSchemeKeyTokens FocusIndicatorColor;
    public static final SheetBottomTokens INSTANCE;

    static {
        SheetBottomTokens.INSTANCE = new SheetBottomTokens();
        SheetBottomTokens.DockedContainerColor = ColorSchemeKeyTokens.SurfaceContainerLow;
        SheetBottomTokens.DockedContainerShape = ShapeKeyTokens.CornerExtraLargeTop;
        SheetBottomTokens.DockedDragHandleColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SheetBottomTokens.DockedDragHandleHeight = Dp.constructor-impl(4f);
        SheetBottomTokens.DockedDragHandleWidth = Dp.constructor-impl(32f);
        SheetBottomTokens.DockedMinimizedContainerShape = ShapeKeyTokens.CornerNone;
        SheetBottomTokens.DockedModalContainerElevation = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        SheetBottomTokens.DockedStandardContainerElevation = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
        SheetBottomTokens.FocusIndicatorColor = ColorSchemeKeyTokens.Secondary;
    }

    private SheetBottomTokens() {
        super();
    }

    public final ColorSchemeKeyTokens getDockedContainerColor() {
        return SheetBottomTokens.DockedContainerColor;
    }

    public final ShapeKeyTokens getDockedContainerShape() {
        return SheetBottomTokens.DockedContainerShape;
    }

    public final ColorSchemeKeyTokens getDockedDragHandleColor() {
        return SheetBottomTokens.DockedDragHandleColor;
    }

    public final float getDockedDragHandleHeight-D9Ej5fM() {
        return SheetBottomTokens.DockedDragHandleHeight;
    }

    public final float getDockedDragHandleWidth-D9Ej5fM() {
        return SheetBottomTokens.DockedDragHandleWidth;
    }

    public final ShapeKeyTokens getDockedMinimizedContainerShape() {
        return SheetBottomTokens.DockedMinimizedContainerShape;
    }

    public final float getDockedModalContainerElevation-D9Ej5fM() {
        return SheetBottomTokens.DockedModalContainerElevation;
    }

    public final float getDockedStandardContainerElevation-D9Ej5fM() {
        return SheetBottomTokens.DockedStandardContainerElevation;
    }

    public final ColorSchemeKeyTokens getFocusIndicatorColor() {
        return SheetBottomTokens.FocusIndicatorColor;
    }
}

