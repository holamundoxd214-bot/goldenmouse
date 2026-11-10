package androidx.compose.material3;

import androidx.compose.material3.tokens.DragHandleTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J-\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\u000EH\u0007¢\u0006\u0002\u0010\u000FJ1\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001A\u00020\u0016J+\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00182\b\b\u0002\u0010\u001A\u001A\u00020\u0018¢\u0006\u0004\b\u001B\u0010\u001CR\u0018\u0010\u0004\u001A\u00020\u0005*\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0018\u0010\r\u001A\u00020\u000E*\u00020 8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/material3/VerticalDragHandleDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DragHandleColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleColors;", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleShapes;", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "draggedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleShapes;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "sizes-L9TjZb0", "(JJJ)Landroidx/compose/material3/DragHandleSizes;", "Landroidx/compose/material3/ColorScheme;", "getColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/DragHandleColors;", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/DragHandleShapes;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VerticalDragHandleDefaults {
    public static final int $stable;
    public static final VerticalDragHandleDefaults INSTANCE;
    private static final DragHandleSizes sizes;

    static {
        VerticalDragHandleDefaults.INSTANCE = new VerticalDragHandleDefaults();
        VerticalDragHandleDefaults.sizes = new DragHandleSizes(DpKt.DpSize-YgX7TsA(DragHandleTokens.INSTANCE.getWidth-D9Ej5fM(), DragHandleTokens.INSTANCE.getHeight-D9Ej5fM()), DpKt.DpSize-YgX7TsA(DragHandleTokens.INSTANCE.getPressedWidth-D9Ej5fM(), DragHandleTokens.INSTANCE.getPressedHeight-D9Ej5fM()), DpKt.DpSize-YgX7TsA(DragHandleTokens.INSTANCE.getDraggedWidth-D9Ej5fM(), DragHandleTokens.INSTANCE.getDraggedHeight-D9Ej5fM()), null);
    }

    private VerticalDragHandleDefaults() {
        super();
    }

    public final DragHandleColors colors(Composer arg4, int arg5) {
        int v1 = -1465068453;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)215@9367L11:DragHandle.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:215)");
        }

        DragHandleColors v3 = this.getColors(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final DragHandleColors colors-RGew2ao(long arg20, long arg22, long arg24, Composer arg26, int arg27, int arg28) {
        Composer v0 = arg26;
        int v2 = -2062501640;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(colors)N(color:c#ui.graphics.Color,pressedColor:c#ui.graphics.Color,draggedColor:c#ui.graphics.Color)234@10175L11:DragHandle.kt#uh7d8r");
        long v3 = (arg28 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v5 = (arg28 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v7 = (arg28 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg27, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:234)");
        }

        DragHandleColors v1 = this.getColors(MaterialTheme.INSTANCE.getColorScheme(v0, 6));
        long v9 = 16;
        if(v3 != v9) {
        }
        else {
            v3 = v1.getColor-0d7_KjU();
        }

        long v12 = v3;
        if(v5 != v9) {
        }
        else {
            v5 = v1.getPressedColor-0d7_KjU();
        }

        long v14 = v5;
        if(v7 != v9) {
        }
        else {
            v7 = v1.getDraggedColor-0d7_KjU();
        }

        DragHandleColors v11 = new DragHandleColors(v12, v14, v7, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v11;
    }

    private final DragHandleColors getColors(ColorScheme arg9) {
        DragHandleColors v8 = arg9.getDefaultVerticalDragHandleColorsCached$material3();
        if(v8 == null) {
            DragHandleColors v0 = new DragHandleColors(ColorSchemeKt.fromToken(arg9, DragHandleTokens.INSTANCE.getColor()), ColorSchemeKt.fromToken(arg9, DragHandleTokens.INSTANCE.getPressedColor()), ColorSchemeKt.fromToken(arg9, DragHandleTokens.INSTANCE.getDraggedColor()), null);
            arg9.setDefaultVerticalDragHandleColorsCached$material3(v0);
            return v0;
        }

        return v8;
    }

    private final DragHandleShapes getShapes(Shapes arg4) {
        DragHandleShapes v3 = arg4.getDefaultVerticalDragHandleShapesCached$material3();
        if(v3 == null) {
            v3 = new DragHandleShapes(ShapesKt.fromToken(arg4, DragHandleTokens.INSTANCE.getShape()), ShapesKt.fromToken(arg4, DragHandleTokens.INSTANCE.getPressedShape()), ShapesKt.fromToken(arg4, DragHandleTokens.INSTANCE.getDraggedShape()));
            arg4.setDefaultVerticalDragHandleShapesCached$material3(v3);
        }

        return v3;
    }

    public final DragHandleShapes shapes(Composer arg4, int arg5) {
        int v1 = 0x52928B57;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(shapes)246@10638L6:DragHandle.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:246)");
        }

        DragHandleShapes v3 = this.getShapes(MaterialTheme.INSTANCE.getShapes(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final DragHandleShapes shapes(Shape arg4, Shape arg5, Shape arg6, Composer arg7, int arg8, int arg9) {
        int v1 = 650848370;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(shapes)N(shape,pressedShape,draggedShape)265@11405L6:DragHandle.kt#uh7d8r");
        Shape v2 = null;
        if((arg9 & 1) != 0) {
            arg4 = v2;
        }

        if((arg9 & 2) != 0) {
            arg5 = v2;
        }

        if((arg9 & 4) != 0) {
            arg6 = v2;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:265)");
        }

        DragHandleShapes v3 = this.getShapes(MaterialTheme.INSTANCE.getShapes(arg7, 6));
        if(arg4 == null) {
            arg4 = v3.getShape();
        }

        if(arg5 == null) {
            arg5 = v3.getPressedShape();
        }

        if(arg6 == null) {
            arg6 = v3.getDraggedShape();
        }

        DragHandleShapes v8 = new DragHandleShapes(arg4, arg5, arg6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return v8;
    }

    public final DragHandleSizes sizes() {
        return VerticalDragHandleDefaults.sizes;
    }

    public final DragHandleSizes sizes-L9TjZb0(long arg9, long arg11, long arg13) {
        DragHandleSizes v8 = VerticalDragHandleDefaults.sizes;
        long v1 = 0x7FC000007FC00000L;
        if(arg9 != v1) {
        }
        else {
            arg9 = v8.getSize-MYxV2XQ();
        }

        if(arg11 != v1) {
        }
        else {
            arg11 = v8.getPressedSize-MYxV2XQ();
        }

        long v3 = arg11;
        if(arg13 != v1) {
        }
        else {
            arg13 = v8.getDraggedSize-MYxV2XQ();
        }

        return new DragHandleSizes(arg9, v3, arg13, null);
    }

    public static DragHandleSizes sizes-L9TjZb0$default(VerticalDragHandleDefaults arg7, long arg8, long arg10, long arg12, int arg14, Object arg15) {
        if((arg14 & 1) != 0) {
            arg8 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        long v1 = arg8;
        if((arg14 & 2) != 0) {
            arg10 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        long v3 = arg10;
        if((arg14 & 4) != 0) {
            arg12 = DpSize.Companion.getUnspecified-MYxV2XQ();
        }

        return arg7.sizes-L9TjZb0(v1, v3, arg12);
    }
}

