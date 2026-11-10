package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010.\u001A\u00020/*\u0002002\u0006\u00101\u001A\u0002022\u0006\u00103\u001A\u000204H\u0016¢\u0006\u0004\b5\u00106J\u001C\u00107\u001A\u000208*\u0002092\u0006\u00101\u001A\u00020:2\u0006\u0010;\u001A\u000208H\u0016J\u001C\u0010<\u001A\u000208*\u0002092\u0006\u00101\u001A\u00020:2\u0006\u0010;\u001A\u000208H\u0016J\u001C\u0010=\u001A\u000208*\u0002092\u0006\u00101\u001A\u00020:2\u0006\u0010>\u001A\u000208H\u0016J\u001C\u0010?\u001A\u000208*\u0002092\u0006\u00101\u001A\u00020:2\u0006\u0010>\u001A\u000208H\u0016J\u0017\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001A\u0002042\u0006\u00103\u001A\u000204H\u0002¢\u0006\u0004\bF\u0010DJ\f\u0010G\u001A\u00020H*\u00020IH\u0016J\u0013\u0010J\u001A\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001A\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bN\u0010LJ\b\u0010O\u001A\u00020PH\u0016R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\u001A\u0010\f\u001A\u00020\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001C\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b+\u0010\u0017R\u0014\u0010,\u001A\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b-\u0010\u0017¨\u0006Q"}, d2={"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "useIntrinsicSize", "getUseIntrinsicSize", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class PainterNode extends Node implements DrawModifierNode, LayoutModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public PainterNode(Painter arg1, boolean arg2, Alignment arg3, ContentScale arg4, float arg5, ColorFilter arg6) {
        super();
        this.painter = arg1;
        this.sizeToIntrinsics = arg2;
        this.alignment = arg3;
        this.contentScale = arg4;
        this.alpha = arg5;
        this.colorFilter = arg6;
    }

    public PainterNode(Painter arg8, boolean arg9, Alignment arg10, ContentScale arg11, float arg12, ColorFilter arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 4) != 0) {
            arg10 = Alignment.Companion.getCenter();
        }

        Alignment v3 = arg10;
        if((arg14 & 8) != 0) {
            arg11 = ContentScale.Companion.getInside();
        }

        ContentScale v4 = arg11;
        if((arg14 & 16) != 0) {
            arg12 = 1f;
        }

        float v5 = arg12;
        if((arg14 & 0x20) != 0) {
            arg13 = null;
        }

        this(arg8, arg9, v3, v4, v5, arg13);
    }

    private final long calculateScaledSize-E7KxVPU(long arg10) {
        if(!this.getUseIntrinsicSize()) {
            return arg10;
        }

        int v1 = 0x20;
        float v0 = !this.hasSpecifiedAndFiniteWidth-uvyYCjk(this.painter.getIntrinsicSize-NH-jbRc()) ? Float.intBitsToFloat(((int)(arg10 >> v1))) : Float.intBitsToFloat(((int)(this.painter.getIntrinsicSize-NH-jbRc() >> v1)));
        long v3 = 0xFFFFFFFFL;
        float v2 = !this.hasSpecifiedAndFiniteHeight-uvyYCjk(this.painter.getIntrinsicSize-NH-jbRc()) ? Float.intBitsToFloat(((int)(arg10 & v3))) : Float.intBitsToFloat(((int)(this.painter.getIntrinsicSize-NH-jbRc() & v3)));
        long v5 = Size.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v1 | (((long)Float.floatToRawIntBits(v2))) & v3);
        if(Float.intBitsToFloat(((int)(arg10 >> v1))) == 0f) {
        }
        else {
            if(Float.intBitsToFloat(((int)(arg10 & v3))) == 0f) {
                goto label_49;
            }

            goto label_52;
        }

    label_49:
        return Size.Companion.getZero-NH-jbRc();
    label_52:
        return ScaleFactorKt.times-UQTWf7w(v5, this.contentScale.computeScaleFactor-H7hwNQA(v5, arg10));
    }

    public void draw(ContentDrawScope arg19) {
        PainterNode v0 = this;
        long v1 = v0.painter.getIntrinsicSize-NH-jbRc();
        int v4 = 0x20;
        float v3 = v0.hasSpecifiedAndFiniteWidth-uvyYCjk(v1) ? Float.intBitsToFloat(((int)(v1 >> v4))) : Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() >> v4)));
        long v6 = 0xFFFFFFFFL;
        float v1_1 = v0.hasSpecifiedAndFiniteHeight-uvyYCjk(v1) ? Float.intBitsToFloat(((int)(v1 & v6))) : Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() & v6)));
        v1 = Size.constructor-impl((((long)Float.floatToRawIntBits(v3))) << v4 | (((long)Float.floatToRawIntBits(v1_1))) & v6);
        v1 = Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() >> v4))) == 0f || Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() & v6))) == 0f ? Size.Companion.getZero-NH-jbRc() : ScaleFactorKt.times-UQTWf7w(v1, v0.contentScale.computeScaleFactor-H7hwNQA(v1, arg19.getSize-NH-jbRc()));
        long v10 = v1;
        v1 = v0.alignment.align-KFBX0sM(IntSize.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(v10 & v6)))))) & v6 | (((long)Math.round(Float.intBitsToFloat(((int)(v10 >> v4)))))) << v4), IntSize.constructor-impl((((long)Math.round(Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() & v6)))))) & v6 | (((long)Math.round(Float.intBitsToFloat(((int)(arg19.getSize-NH-jbRc() >> v4)))))) << v4), arg19.getLayoutDirection());
        v3 = ((float)IntOffset.getX-impl(v1));
        v1_1 = ((float)IntOffset.getY-impl(v1));
        ContentDrawScope v9 = arg19;
        ((DrawScope)v9).getDrawContext().getTransform().translate(v3, v1_1);
        try {
            v0.painter.draw-x_KDEd0(((DrawScope)v9), v10, v0.alpha, v0.colorFilter);
        }
        catch(Throwable v0_1) {
            ((DrawScope)v9).getDrawContext().getTransform().translate(-v3, -v1_1);
            throw v0_1;
        }

        ((DrawScope)v9).getDrawContext().getTransform().translate(-v3, -v1_1);
        arg19.drawContent();
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    private final boolean getUseIntrinsicSize() {
        if((this.sizeToIntrinsics) && this.painter.getIntrinsicSize-NH-jbRc() != 0x7FC000007FC00000L) {
            return 1;
        }

        return 0;
    }

    private final boolean hasSpecifiedAndFiniteHeight-uvyYCjk(long arg3) {
        if(!Size.equals-impl0(arg3, Size.Companion.getUnspecified-NH-jbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg3 & 0xFFFFFFFFL)))) & 0x7FFFFFFF) < 0x7F800000) {
            return 1;
        }

        return 0;
    }

    private final boolean hasSpecifiedAndFiniteWidth-uvyYCjk(long arg3) {
        if(!Size.equals-impl0(arg3, Size.Companion.getUnspecified-NH-jbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg3 >> 0x20)))) & 0x7FFFFFFF) < 0x7F800000) {
            return 1;
        }

        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg7, IntrinsicMeasurable arg8, int arg9) {
        if(this.getUseIntrinsicSize()) {
            return Math.max(Constraints.getMinHeight-impl(this.modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(0, arg9, 0, 0, 13, null))), arg8.maxIntrinsicHeight(arg9));
        }

        return arg8.maxIntrinsicHeight(arg9);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg7, IntrinsicMeasurable arg8, int arg9) {
        if(this.getUseIntrinsicSize()) {
            return Math.max(Constraints.getMinWidth-impl(this.modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, arg9, 7, null))), arg8.maxIntrinsicWidth(arg9));
        }

        return arg8.maxIntrinsicWidth(arg9);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v7 = arg9.measure-BRTryo0(this.modifyConstraints-ZezNO4M(arg10));
        return MeasureScope.layout$default(arg8, v7.getWidth(), v7.getHeight(), null, new PainterNode$measure$1(v7), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg7, IntrinsicMeasurable arg8, int arg9) {
        if(this.getUseIntrinsicSize()) {
            return Math.max(Constraints.getMinHeight-impl(this.modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(0, arg9, 0, 0, 13, null))), arg8.minIntrinsicHeight(arg9));
        }

        return arg8.minIntrinsicHeight(arg9);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg7, IntrinsicMeasurable arg8, int arg9) {
        if(this.getUseIntrinsicSize()) {
            return Math.max(Constraints.getMinWidth-impl(this.modifyConstraints-ZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, arg9, 7, null))), arg8.minIntrinsicWidth(arg9));
        }

        return arg8.minIntrinsicWidth(arg9);
    }

    private final long modifyConstraints-ZezNO4M(long arg12) {
        int v1 = 1;
        int v0 = !Constraints.getHasBoundedWidth-impl(arg12) || !Constraints.getHasBoundedHeight-impl(arg12) ? 0 : 1;
        if(!Constraints.getHasFixedWidth-impl(arg12) || !Constraints.getHasFixedHeight-impl(arg12)) {
            v1 = 0;
        }
        else {
        }

        if(!this.getUseIntrinsicSize() && v0 != 0 || v1 != 0) {
            return Constraints.copy-Zbe2FdA$default(arg12, Constraints.getMaxWidth-impl(arg12), 0, Constraints.getMaxHeight-impl(arg12), 0, 10, null);
        }

        long v0_1 = arg12;
        arg12 = this.painter.getIntrinsicSize-NH-jbRc();
        int v3 = 0x20;
        int v2 = this.hasSpecifiedAndFiniteWidth-uvyYCjk(arg12) ? Math.round(Float.intBitsToFloat(((int)(arg12 >> v3)))) : Constraints.getMinWidth-impl(v0_1);
        long v5 = 0xFFFFFFFFL;
        int v12 = this.hasSpecifiedAndFiniteHeight-uvyYCjk(arg12) ? Math.round(Float.intBitsToFloat(((int)(arg12 & v5)))) : Constraints.getMinHeight-impl(v0_1);
        long v11 = this.calculateScaledSize-E7KxVPU(Size.constructor-impl((((long)Float.floatToRawIntBits(((float)ConstraintsKt.constrainHeight-K40F9xA(v0_1, v12))))) & v5 | (((long)Float.floatToRawIntBits(((float)ConstraintsKt.constrainWidth-K40F9xA(v0_1, v2))))) << v3));
        return Constraints.copy-Zbe2FdA$default(v0_1, ConstraintsKt.constrainWidth-K40F9xA(v0_1, Math.round(Float.intBitsToFloat(((int)(v11 >> v3))))), 0, ConstraintsKt.constrainHeight-K40F9xA(v0_1, Math.round(Float.intBitsToFloat(((int)(v11 & v5))))), 0, 10, null);
    }

    public final void setAlignment(Alignment arg1) {
        this.alignment = arg1;
    }

    public final void setAlpha(float arg1) {
        this.alpha = arg1;
    }

    public final void setColorFilter(ColorFilter arg1) {
        this.colorFilter = arg1;
    }

    public final void setContentScale(ContentScale arg1) {
        this.contentScale = arg1;
    }

    public final void setPainter(Painter arg1) {
        this.painter = arg1;
    }

    public final void setSizeToIntrinsics(boolean arg1) {
        this.sizeToIntrinsics = arg1;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}

