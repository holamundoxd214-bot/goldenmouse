package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0010\u001A\u00020\u0011*\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0014H\u0002J\b\u0010\u0015\u001A\u00020\u0014H\u0002J\u001C\u0010\u0016\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0002J\u001C\u0010\u001C\u001A\u00020\u00142\u0006\u0010\u001D\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0002J\u001C\u0010\u001E\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0002J\u001C\u0010 \u001A\u00020\u00142\u0006\u0010!\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0002J$\u0010\"\u001A\u00020\u00142\u0006\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020\u00182\n\u0010\u0019\u001A\u00060\u001Aj\u0002`\u001BH\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006&"}, d2={"Landroidx/compose/foundation/StretchOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "shouldDrawVerticalStretch", "", "shouldDrawHorizontalStretch", "drawLeftStretch", "left", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawTopStretch", "top", "drawRightStretch", "right", "drawBottomStretch", "bottom", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public StretchOverscrollNode(DelegatableNode arg1, AndroidEdgeEffectOverscrollEffect arg2, EdgeEffectWrapper arg3) {
        super();
        this.overscrollEffect = arg2;
        this.edgeEffectWrapper = arg3;
        this.delegate(arg1);
    }

    public void draw(ContentDrawScope arg20) {
        float v5_2;
        int v18;
        EdgeEffect v7;
        float v17;
        boolean v13;
        EdgeEffect v9;
        StretchOverscrollNode v0 = this;
        ContentDrawScope v1 = arg20;
        v0.overscrollEffect.updateSize-uvyYCjk$foundation(v1.getSize-NH-jbRc());
        Canvas v2 = AndroidCanvas_androidKt.getNativeCanvas(v1.getDrawContext().getCanvas());
        v0.overscrollEffect.getRedrawSignal$foundation().getValue();
        if(Size.isEmpty-impl(v1.getSize-NH-jbRc())) {
            v1.drawContent();
            return;
        }

        if(!v2.isHardwareAccelerated()) {
            v0.edgeEffectWrapper.finishAll();
            v1.drawContent();
            return;
        }

        float v3 = v1.toPx-0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        EdgeEffectWrapper v4 = v0.edgeEffectWrapper;
        boolean v5 = v0.shouldDrawVerticalStretch();
        boolean v6 = v0.shouldDrawHorizontalStretch();
        if((v5) && (v6)) {
            v0.getRenderNode().setPosition(0, 0, v2.getWidth(), v2.getHeight());
        }
        else if(v5) {
            v0.getRenderNode().setPosition(0, 0, v2.getWidth() + MathKt.roundToInt(v3) * 2, v2.getHeight());
        }
        else if(v6) {
            v0.getRenderNode().setPosition(0, 0, v2.getWidth(), v2.getHeight() + MathKt.roundToInt(v3) * 2);
        }
        else {
            goto label_251;
        }

        RecordingCanvas v8 = v0.getRenderNode().beginRecording();
        if(v4.isLeftNegationStretched()) {
            v9 = v4.getOrCreateLeftEffectNegation();
            v0.drawRightStretch(v9, v8);
            v9.finish();
        }

        long v11 = 0xFFFFFFFFL;
        if(v4.isLeftAnimating()) {
            v9 = v4.getOrCreateLeftEffect();
            v13 = v0.drawLeftStretch(v9, v8);
            if(v4.isLeftStretched()) {
                v17 = 1f;
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v4.getOrCreateLeftEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(v9), v17 - Float.intBitsToFloat(((int)(v0.overscrollEffect.displacement-F1C5BW0$foundation() & v11))));
            }
            else {
                v17 = 1f;
            }
        }
        else {
            v17 = 1f;
            v13 = false;
        }

        if(v4.isTopNegationStretched()) {
            v7 = v4.getOrCreateTopEffectNegation();
            v0.drawBottomStretch(v7, v8);
            v7.finish();
        }

        int v9_1 = 0x20;
        if(v4.isTopAnimating()) {
            v7 = v4.getOrCreateTopEffect();
            v13 = (v0.drawTopStretch(v7, v8)) || (v13) ? true : false;
            if(!v4.isTopStretched()) {
                goto label_117;
            }

            v18 = v9_1;
            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v4.getOrCreateTopEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(v7), Float.intBitsToFloat(((int)(v0.overscrollEffect.displacement-F1C5BW0$foundation() >> v9_1))));
        }
        else {
        label_117:
            v18 = v9_1;
        }

        if(v4.isRightNegationStretched()) {
            v7 = v4.getOrCreateRightEffectNegation();
            v0.drawLeftStretch(v7, v8);
            v7.finish();
        }

        if(v4.isRightAnimating()) {
            v7 = v4.getOrCreateRightEffect();
            v13 = (v0.drawRightStretch(v7, v8)) || (v13) ? true : false;
            if(!v4.isRightStretched()) {
                goto label_147;
            }

            EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v4.getOrCreateRightEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(v7), Float.intBitsToFloat(((int)(v0.overscrollEffect.displacement-F1C5BW0$foundation() & v11))));
        }

    label_147:
        if(v4.isBottomNegationStretched()) {
            v7 = v4.getOrCreateBottomEffectNegation();
            v0.drawTopStretch(v7, v8);
            v7.finish();
        }

        if(v4.isBottomAnimating()) {
            v7 = v4.getOrCreateBottomEffect();
            boolean v16 = (v0.drawBottomStretch(v7, v8)) || (v13) ? true : false;
            if(v4.isBottomStretched()) {
                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(v4.getOrCreateBottomEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(v7), v17 - Float.intBitsToFloat(((int)(v0.overscrollEffect.displacement-F1C5BW0$foundation() >> v18))));
            }

            v13 = v16;
        }

        if(v13) {
            v0.overscrollEffect.invalidateOverscroll$foundation();
        }

        float v6_1 = v6 ? 0f : v3;
        if(v5) {
            v3 = 0f;
        }

        ContentDrawScope v4_1 = v1;
        ContentDrawScope v5_1 = v1;
        LayoutDirection v7_1 = v1.getLayoutDirection();
        androidx.compose.ui.graphics.Canvas v8_1 = AndroidCanvas_androidKt.Canvas(((Canvas)v8));
        long v9_2 = v1.getSize-NH-jbRc();
        Density v11_1 = ((DrawScope)v4_1).getDrawContext().getDensity();
        LayoutDirection v12 = ((DrawScope)v4_1).getDrawContext().getLayoutDirection();
        androidx.compose.ui.graphics.Canvas v13_1 = ((DrawScope)v4_1).getDrawContext().getCanvas();
        long v14 = ((DrawScope)v4_1).getDrawContext().getSize-NH-jbRc();
        GraphicsLayer v1_1 = ((DrawScope)v4_1).getDrawContext().getGraphicsLayer();
        DrawContext v0_1 = ((DrawScope)v4_1).getDrawContext();
        v0_1.setDensity(((Density)v5_1));
        v0_1.setLayoutDirection(v7_1);
        v0_1.setCanvas(v8_1);
        v0_1.setSize-uvyYCjk(v9_2);
        v0_1.setGraphicsLayer(null);
        v8_1.save();
        try {
            ((DrawScope)v4_1).getDrawContext().getTransform().translate(v6_1, v3);
        }
        catch(Throwable v0_2) {
            goto label_243;
        }

        try {
            arg20.drawContent();
            goto label_215;
        }
        catch(Throwable v0_2) {
            try {
                ((DrawScope)v4_1).getDrawContext().getTransform().translate(-v6_1, -v3);
                throw v0_2;
            label_215:
                v5_2 = -v6_1;
                v3 = -v3;
                ((DrawScope)v4_1).getDrawContext().getTransform().translate(v5_2, v3);
            }
            catch(Throwable v0_2) {
            label_243:
                v8_1.restore();
                DrawContext v2_1 = ((DrawScope)v4_1).getDrawContext();
                v2_1.setDensity(v11_1);
                v2_1.setLayoutDirection(v12);
                v2_1.setCanvas(v13_1);
                v2_1.setSize-uvyYCjk(v14);
                v2_1.setGraphicsLayer(v1_1);
                throw v0_2;
            }
        }

        v8_1.restore();
        v0_1 = ((DrawScope)v4_1).getDrawContext();
        v0_1.setDensity(v11_1);
        v0_1.setLayoutDirection(v12);
        v0_1.setCanvas(v13_1);
        v0_1.setSize-uvyYCjk(v14);
        v0_1.setGraphicsLayer(v1_1);
        this.getRenderNode().endRecording();
        int v0_3 = v2.save();
        v2.translate(v5_2, v3);
        v2.drawRenderNode(this.getRenderNode());
        v2.restoreToCount(v0_3);
        return;
    label_251:
        arg20.drawContent();
    }

    private final boolean drawBottomStretch(EdgeEffect arg2, Canvas arg3) {
        return this.drawWithRotation(180f, arg2, arg3);
    }

    private final boolean drawLeftStretch(EdgeEffect arg2, Canvas arg3) {
        return this.drawWithRotation(270f, arg2, arg3);
    }

    private final boolean drawRightStretch(EdgeEffect arg2, Canvas arg3) {
        return this.drawWithRotation(90f, arg2, arg3);
    }

    private final boolean drawTopStretch(EdgeEffect arg2, Canvas arg3) {
        return this.drawWithRotation(0f, arg2, arg3);
    }

    private final boolean drawWithRotation(float arg1, EdgeEffect arg2, Canvas arg3) {
        if(arg1 == 0f) {
            return arg2.draw(arg3);
        }

        int v0 = arg3.save();
        arg3.rotate(arg1);
        boolean v1 = arg2.draw(arg3);
        arg3.restoreToCount(v0);
        return v1;
    }

    private final RenderNode getRenderNode() {
        RenderNode v0 = this._renderNode;
        if(v0 == null) {
            v0 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
            this._renderNode = v0;
        }

        return v0;
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper v1 = this.edgeEffectWrapper;
        if(!v1.isLeftAnimating() && !v1.isLeftNegationStretched() && !v1.isRightAnimating()) {
            if(v1.isRightNegationStretched()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper v1 = this.edgeEffectWrapper;
        if(!v1.isTopAnimating() && !v1.isTopNegationStretched() && !v1.isBottomAnimating()) {
            if(v1.isBottomNegationStretched()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

