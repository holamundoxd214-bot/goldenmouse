package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AF\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001A.\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001A\u00020\u00042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001A:\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\f\u001A\u00020\u00042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001A:\u0010\r\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001A?\u0010\u000E\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00042\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001A?\u0010\u0014\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00042\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0013\u001AG\u0010\u0017\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u00042\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u001A\u0010\u001B\u001A?\u0010\u0017\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001A\u00020\u00042\b\b\u0002\u0010\u0010\u001A\u00020\u00112\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b\u001C\u0010\u0013\u001A_\u0010\u001D\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b \u0010!\u001A?\u0010\"\u001A\u00020\u0001*\u00020\u00022\u0006\u0010#\u001A\u00020$2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b%\u0010&\u001A!\u0010\'\u001A\u00020\u0001*\u00020\u00022\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\tH\u0086\b\u001A?\u0010)\u001A\u00020\u0001*\u00020\u00022\u0017\u0010*\u001A\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0017\u0010,\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b\u001AM\u0010-\u001A\u00020\u0001*\u00020\u00022\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u00020(2\u0006\u00103\u001A\u0002042\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0087\b¢\u0006\u0004\b5\u00106\u001AY\u0010-\u001A\u00020\u0001*\u00020\u00022\u0006\u0010.\u001A\u00020/2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u00020(2\u0006\u00103\u001A\u0002042\n\b\u0002\u00107\u001A\u0004\u0018\u0001082\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0086\b¢\u0006\u0004\b9\u0010:¨\u0006;"}, d2={"inset", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "left", "", "top", "right", "bottom", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "horizontal", "vertical", "translate", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "scale-Rg1IO4c", "clipRect", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "draw-ymL40Pk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;Lkotlin/jvm/functions/Function1;)V", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawScopeKt {
    public static final void clipPath-KD09W0M(DrawScope arg4, Path arg5, int arg6, Function1 arg7) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            v0.getTransform().clipPath-mtrdD-E(arg5, arg6);
            arg7.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }

    public static void clipPath-KD09W0M$default(DrawScope arg2, Path arg3, int arg4, Function1 arg5, int arg6, Object arg7) {
        if((arg6 & 2) != 0) {
            arg4 = ClipOp.Companion.getIntersect-rtfAjoo();
        }

        DrawContext v6 = arg2.getDrawContext();
        long v0 = v6.getSize-NH-jbRc();
        v6.getCanvas().save();
        try {
            v6.getTransform().clipPath-mtrdD-E(arg3, arg4);
            arg5.invoke(arg2);
        }
        catch(Throwable v2) {
            v6.getCanvas().restore();
            v6.setSize-uvyYCjk(v0);
            throw v2;
        }

        v6.getCanvas().restore();
        v6.setSize-uvyYCjk(v0);
    }

    public static final void clipRect-rOu3jXo(DrawScope arg10, float arg11, float arg12, float arg13, float arg14, int arg15, Function1 arg16) {
        DrawContext v1 = arg10.getDrawContext();
        long v2 = v1.getSize-NH-jbRc();
        v1.getCanvas().save();
        try {
            v1.getTransform().clipRect-N_I0leg(arg11, arg12, arg13, arg14, arg15);
            arg16.invoke(arg10);
        }
        catch(Throwable v0) {
            v1.getCanvas().restore();
            v1.setSize-uvyYCjk(v2);
            throw v0;
        }

        v1.getCanvas().restore();
        v1.setSize-uvyYCjk(v2);
    }

    public static void clipRect-rOu3jXo$default(DrawScope arg7, float arg8, float arg9, float arg10, float arg11, int arg12, Function1 arg13, int arg14, Object arg15) {
        float v2 = (arg14 & 1) != 0 ? 0f : arg8;
        float v3 = (arg14 & 2) != 0 ? 0f : arg9;
        if((arg14 & 4) != 0) {
            arg10 = Float.intBitsToFloat(((int)(arg7.getSize-NH-jbRc() >> 0x20)));
        }

        float v4 = arg10;
        if((arg14 & 8) != 0) {
            arg11 = Float.intBitsToFloat(((int)(arg7.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        }

        float v5 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = ClipOp.Companion.getIntersect-rtfAjoo();
        }

        int v6 = arg12;
        DrawContext v8 = arg7.getDrawContext();
        long v9 = v8.getSize-NH-jbRc();
        v8.getCanvas().save();
        try {
            v8.getTransform().clipRect-N_I0leg(v2, v3, v4, v5, v6);
            arg13.invoke(arg7);
        }
        catch(Throwable v0) {
            v8.getCanvas().restore();
            v8.setSize-uvyYCjk(v9);
            throw v0;
        }

        v8.getCanvas().restore();
        v8.setSize-uvyYCjk(v9);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use a new overload accepting nullable GraphicsLayer") public static final void draw-GRGpd60(DrawScope arg7, Density arg8, LayoutDirection arg9, Canvas arg10, long arg11, Function1 arg13) {
        DrawContext v7;
        Density v0 = arg7.getDrawContext().getDensity();
        LayoutDirection v1 = arg7.getDrawContext().getLayoutDirection();
        Canvas v2 = arg7.getDrawContext().getCanvas();
        long v3 = arg7.getDrawContext().getSize-NH-jbRc();
        GraphicsLayer v5 = arg7.getDrawContext().getGraphicsLayer();
        DrawContext v6 = arg7.getDrawContext();
        v6.setDensity(arg8);
        v6.setLayoutDirection(arg9);
        v6.setCanvas(arg10);
        v6.setSize-uvyYCjk(arg11);
        v6.setGraphicsLayer(null);
        arg10.save();
        try {
            arg13.invoke(arg7);
        }
        catch(Throwable v8) {
            arg10.restore();
            v7 = arg7.getDrawContext();
            v7.setDensity(v0);
            v7.setLayoutDirection(v1);
            v7.setCanvas(v2);
            v7.setSize-uvyYCjk(v3);
            v7.setGraphicsLayer(v5);
            throw v8;
        }

        arg10.restore();
        v7 = arg7.getDrawContext();
        v7.setDensity(v0);
        v7.setLayoutDirection(v1);
        v7.setCanvas(v2);
        v7.setSize-uvyYCjk(v3);
        v7.setGraphicsLayer(v5);
    }

    public static final void draw-ymL40Pk(DrawScope arg7, Density arg8, LayoutDirection arg9, Canvas arg10, long arg11, GraphicsLayer arg13, Function1 arg14) {
        DrawContext v7;
        Density v0 = arg7.getDrawContext().getDensity();
        LayoutDirection v1 = arg7.getDrawContext().getLayoutDirection();
        Canvas v2 = arg7.getDrawContext().getCanvas();
        long v3 = arg7.getDrawContext().getSize-NH-jbRc();
        GraphicsLayer v5 = arg7.getDrawContext().getGraphicsLayer();
        DrawContext v6 = arg7.getDrawContext();
        v6.setDensity(arg8);
        v6.setLayoutDirection(arg9);
        v6.setCanvas(arg10);
        v6.setSize-uvyYCjk(arg11);
        v6.setGraphicsLayer(arg13);
        arg10.save();
        try {
            arg14.invoke(arg7);
        }
        catch(Throwable v8) {
            arg10.restore();
            v7 = arg7.getDrawContext();
            v7.setDensity(v0);
            v7.setLayoutDirection(v1);
            v7.setCanvas(v2);
            v7.setSize-uvyYCjk(v3);
            v7.setGraphicsLayer(v5);
            throw v8;
        }

        arg10.restore();
        v7 = arg7.getDrawContext();
        v7.setDensity(v0);
        v7.setLayoutDirection(v1);
        v7.setCanvas(v2);
        v7.setSize-uvyYCjk(v3);
        v7.setGraphicsLayer(v5);
    }

    public static void draw-ymL40Pk$default(DrawScope arg5, Density arg6, LayoutDirection arg7, Canvas arg8, long arg9, GraphicsLayer arg11, Function1 arg12, int arg13, Object arg14) {
        DrawContext v5;
        if((arg13 & 16) != 0) {
            arg11 = null;
        }

        Density v13 = arg5.getDrawContext().getDensity();
        LayoutDirection v14 = arg5.getDrawContext().getLayoutDirection();
        Canvas v0 = arg5.getDrawContext().getCanvas();
        long v1 = arg5.getDrawContext().getSize-NH-jbRc();
        GraphicsLayer v3 = arg5.getDrawContext().getGraphicsLayer();
        DrawContext v4 = arg5.getDrawContext();
        v4.setDensity(arg6);
        v4.setLayoutDirection(arg7);
        v4.setCanvas(arg8);
        v4.setSize-uvyYCjk(arg9);
        v4.setGraphicsLayer(arg11);
        arg8.save();
        try {
            arg12.invoke(arg5);
        }
        catch(Throwable v6) {
            arg8.restore();
            v5 = arg5.getDrawContext();
            v5.setDensity(v13);
            v5.setLayoutDirection(v14);
            v5.setCanvas(v0);
            v5.setSize-uvyYCjk(v1);
            v5.setGraphicsLayer(v3);
            throw v6;
        }

        arg8.restore();
        v5 = arg5.getDrawContext();
        v5.setDensity(v13);
        v5.setLayoutDirection(v14);
        v5.setCanvas(v0);
        v5.setSize-uvyYCjk(v1);
        v5.setGraphicsLayer(v3);
    }

    public static final void drawIntoCanvas(DrawScope arg0, Function1 arg1) {
        arg1.invoke(arg0.getDrawContext().getCanvas());
    }

    public static final void inset(DrawScope arg1, float arg2, float arg3, float arg4, float arg5, Function1 arg6) {
        arg1.getDrawContext().getTransform().inset(arg2, arg3, arg4, arg5);
        try {
            arg6.invoke(arg1);
        }
        catch(Throwable v6) {
            arg1.getDrawContext().getTransform().inset(-arg2, -arg3, -arg4, -arg5);
            throw v6;
        }

        arg1.getDrawContext().getTransform().inset(-arg2, -arg3, -arg4, -arg5);
    }

    public static final void inset(DrawScope arg1, float arg2, float arg3, Function1 arg4) {
        arg1.getDrawContext().getTransform().inset(arg2, arg3, arg2, arg3);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v4) {
            arg2 = -arg2;
            arg3 = -arg3;
            arg1.getDrawContext().getTransform().inset(arg2, arg3, arg2, arg3);
            throw v4;
        }

        arg2 = -arg2;
        arg3 = -arg3;
        arg1.getDrawContext().getTransform().inset(arg2, arg3, arg2, arg3);
    }

    public static final void inset(DrawScope arg1, float arg2, Function1 arg3) {
        arg1.getDrawContext().getTransform().inset(arg2, arg2, arg2, arg2);
        try {
            arg3.invoke(arg1);
        }
        catch(Throwable v3) {
            arg2 = -arg2;
            arg1.getDrawContext().getTransform().inset(arg2, arg2, arg2, arg2);
            throw v3;
        }

        arg2 = -arg2;
        arg1.getDrawContext().getTransform().inset(arg2, arg2, arg2, arg2);
    }

    public static void inset$default(DrawScope arg1, float arg2, float arg3, Function1 arg4, int arg5, Object arg6) {
        arg1.getDrawContext().getTransform().inset(0f, 0f, 0f, 0f);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v4) {
            arg2 = -0f;
            arg3 = -0f;
            arg1.getDrawContext().getTransform().inset(arg2, arg3, arg2, arg3);
            throw v4;
        }

        arg2 = -0f;
        arg3 = -0f;
        arg1.getDrawContext().getTransform().inset(arg2, arg3, arg2, arg3);
    }

    public static final void rotate-Rg1IO4c(DrawScope arg4, float arg5, long arg6, Function1 arg8) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            v0.getTransform().rotate-Uv8p0NA(arg5, arg6);
            arg8.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }

    public static void rotate-Rg1IO4c$default(DrawScope arg2, float arg3, long arg4, Function1 arg6, int arg7, Object arg8) {
        if((arg7 & 2) != 0) {
            arg4 = arg2.getCenter-F1C5BW0();
        }

        DrawContext v7 = arg2.getDrawContext();
        long v0 = v7.getSize-NH-jbRc();
        v7.getCanvas().save();
        try {
            v7.getTransform().rotate-Uv8p0NA(arg3, arg4);
            arg6.invoke(arg2);
        }
        catch(Throwable v2) {
            v7.getCanvas().restore();
            v7.setSize-uvyYCjk(v0);
            throw v2;
        }

        v7.getCanvas().restore();
        v7.setSize-uvyYCjk(v0);
    }

    public static final void rotateRad-Rg1IO4c(DrawScope arg4, float arg5, long arg6, Function1 arg8) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            v0.getTransform().rotate-Uv8p0NA(DegreesKt.degrees(arg5), arg6);
            arg8.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }

    public static void rotateRad-Rg1IO4c$default(DrawScope arg2, float arg3, long arg4, Function1 arg6, int arg7, Object arg8) {
        if((arg7 & 2) != 0) {
            arg4 = arg2.getCenter-F1C5BW0();
        }

        DrawContext v7 = arg2.getDrawContext();
        long v0 = v7.getSize-NH-jbRc();
        v7.getCanvas().save();
        try {
            v7.getTransform().rotate-Uv8p0NA(DegreesKt.degrees(arg3), arg4);
            arg6.invoke(arg2);
        }
        catch(Throwable v2) {
            v7.getCanvas().restore();
            v7.setSize-uvyYCjk(v0);
            throw v2;
        }

        v7.getCanvas().restore();
        v7.setSize-uvyYCjk(v0);
    }

    public static final void scale-Fgt4K4Q(DrawScope arg4, float arg5, float arg6, long arg7, Function1 arg9) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            v0.getTransform().scale-0AR0LA0(arg5, arg6, arg7);
            arg9.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }

    public static void scale-Fgt4K4Q$default(DrawScope arg2, float arg3, float arg4, long arg5, Function1 arg7, int arg8, Object arg9) {
        if((arg8 & 4) != 0) {
            arg5 = arg2.getCenter-F1C5BW0();
        }

        DrawContext v8 = arg2.getDrawContext();
        long v0 = v8.getSize-NH-jbRc();
        v8.getCanvas().save();
        try {
            v8.getTransform().scale-0AR0LA0(arg3, arg4, arg5);
            arg7.invoke(arg2);
        }
        catch(Throwable v2) {
            v8.getCanvas().restore();
            v8.setSize-uvyYCjk(v0);
            throw v2;
        }

        v8.getCanvas().restore();
        v8.setSize-uvyYCjk(v0);
    }

    public static final void scale-Rg1IO4c(DrawScope arg4, float arg5, long arg6, Function1 arg8) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            v0.getTransform().scale-0AR0LA0(arg5, arg5, arg6);
            arg8.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }

    public static void scale-Rg1IO4c$default(DrawScope arg2, float arg3, long arg4, Function1 arg6, int arg7, Object arg8) {
        if((arg7 & 2) != 0) {
            arg4 = arg2.getCenter-F1C5BW0();
        }

        DrawContext v7 = arg2.getDrawContext();
        long v0 = v7.getSize-NH-jbRc();
        v7.getCanvas().save();
        try {
            v7.getTransform().scale-0AR0LA0(arg3, arg3, arg4);
            arg6.invoke(arg2);
        }
        catch(Throwable v2) {
            v7.getCanvas().restore();
            v7.setSize-uvyYCjk(v0);
            throw v2;
        }

        v7.getCanvas().restore();
        v7.setSize-uvyYCjk(v0);
    }

    public static final void translate(DrawScope arg1, float arg2, float arg3, Function1 arg4) {
        arg1.getDrawContext().getTransform().translate(arg2, arg3);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v4) {
            arg1.getDrawContext().getTransform().translate(-arg2, -arg3);
            throw v4;
        }

        arg1.getDrawContext().getTransform().translate(-arg2, -arg3);
    }

    public static void translate$default(DrawScope arg1, float arg2, float arg3, Function1 arg4, int arg5, Object arg6) {
        arg1.getDrawContext().getTransform().translate(0f, 0f);
        try {
            arg4.invoke(arg1);
        }
        catch(Throwable v4) {
            arg1.getDrawContext().getTransform().translate(-0f, -0f);
            throw v4;
        }

        arg1.getDrawContext().getTransform().translate(-0f, -0f);
    }

    public static final void withTransform(DrawScope arg4, Function1 arg5, Function1 arg6) {
        DrawContext v0 = arg4.getDrawContext();
        long v1 = v0.getSize-NH-jbRc();
        v0.getCanvas().save();
        try {
            arg5.invoke(v0.getTransform());
            arg6.invoke(arg4);
        }
        catch(Throwable v4) {
            v0.getCanvas().restore();
            v0.setSize-uvyYCjk(v1);
            throw v4;
        }

        v0.getCanvas().restore();
        v0.setSize-uvyYCjk(v1);
    }
}

