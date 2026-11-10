package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001>B%\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ#\u0010*\u001A\u00020+*\u00020,2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u000200H\u0016¢\u0006\u0004\b1\u00102J\f\u00103\u001A\u000204*\u000205H\u0016J\b\u0010<\u001A\u000204H\u0016J\b\u0010=\u001A\u000204H\u0016R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R+\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u000B8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001E8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u001E\u0010\"\u001A\u00020\t2\u0006\u0010!\u001A\u00020\t@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b#\u0010$R \u0010&\u001A\u00020%2\u0006\u0010!\u001A\u00020%@BX\u0082\u000E¢\u0006\n\n\u0002\u0010)\"\u0004\b\'\u0010(R\u0013\u00106\u001A\u0004\u0018\u0001078F¢\u0006\u0006\u001A\u0004\b8\u00109R\u0014\u0010:\u001A\b\u0018\u00010;R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006?"}, d2={"Landroidx/compose/animation/RenderInTransitionOverlayNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "sharedScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "<init>", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;F)V", "getSharedScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getZIndexInOverlay", "()F", "setZIndexInOverlay", "(F)V", "zIndexInOverlay$delegate", "Landroidx/compose/runtime/MutableFloatState;", "parentState", "Landroidx/compose/animation/SharedElementEntry;", "getParentState", "()Landroidx/compose/animation/SharedElementEntry;", "value", "enabled", "setEnabled", "(Z)V", "Landroidx/compose/ui/geometry/Offset;", "positionInOverlay", "setPositionInOverlay-k-4lQ0M", "(J)V", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layerWithRenderer", "Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "onAttach", "onDetach", "LayerWithRenderer", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RenderInTransitionOverlayNode extends Node implements ModifierLocalModifierNode, DrawModifierNode, LayoutModifierNode {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0014"}, d2={"Landroidx/compose/animation/RenderInTransitionOverlayNode$LayerWithRenderer;", "Landroidx/compose/animation/LayerRenderer;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "<init>", "(Landroidx/compose/animation/RenderInTransitionOverlayNode;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentState", "Landroidx/compose/animation/SharedElementEntry;", "getParentState", "()Landroidx/compose/animation/SharedElementEntry;", "zIndex", "", "getZIndex", "()F", "drawInOverlay", "", "drawScope", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LayerWithRenderer implements LayerRenderer {
        private final GraphicsLayer layer;

        public LayerWithRenderer(RenderInTransitionOverlayNode arg1, GraphicsLayer arg2) {
            RenderInTransitionOverlayNode.this = arg1;
            super();
            this.layer = arg2;
        }

        public void drawInOverlay(DrawScope arg7) {
            if(RenderInTransitionOverlayNode.this.enabled) {
                RenderInTransitionOverlayNode v0 = RenderInTransitionOverlayNode.this;
                float v1 = Float.intBitsToFloat(((int)(v0.positionInOverlay >> 0x20)));
                float v0_1 = Float.intBitsToFloat(((int)(v0.positionInOverlay & 0xFFFFFFFFL)));
                arg7.getDrawContext().getTransform().translate(v1, v0_1);
                try {
                    GraphicsLayerKt.drawLayer(arg7, this.layer);
                }
                catch(Throwable v6) {
                    arg7.getDrawContext().getTransform().translate(-v1, -v0_1);
                    throw v6;
                }

                arg7.getDrawContext().getTransform().translate(-v1, -v0_1);
                return;
            }
        }

        public final GraphicsLayer getLayer() {
            return this.layer;
        }

        public SharedElementEntry getParentState() {
            return RenderInTransitionOverlayNode.this.getParentState();
        }

        public float getZIndex() {
            return RenderInTransitionOverlayNode.this.getZIndexInOverlay();
        }
    }

    public static final int $stable = 8;
    private boolean enabled;
    private LayerWithRenderer layerWithRenderer;
    private long positionInOverlay;
    private Function0 renderInOverlay;
    private SharedTransitionScopeImpl sharedScope;
    private final MutableFloatState zIndexInOverlay$delegate;

    static {
    }

    public RenderInTransitionOverlayNode(SharedTransitionScopeImpl arg1, Function0 arg2, float arg3) {
        super();
        this.sharedScope = arg1;
        this.renderInOverlay = arg2;
        this.zIndexInOverlay$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(arg3);
        this.positionInOverlay = Offset.Companion.getZero-F1C5BW0();
    }

    public static final boolean access$getEnabled$p(RenderInTransitionOverlayNode arg0) {
        return arg0.enabled;
    }

    public static final long access$getPositionInOverlay$p(RenderInTransitionOverlayNode arg2) {
        return arg2.positionInOverlay;
    }

    public static final void access$setEnabled(RenderInTransitionOverlayNode arg0, boolean arg1) {
        arg0.setEnabled(arg1);
    }

    public static final void access$setPositionInOverlay-k-4lQ0M(RenderInTransitionOverlayNode arg0, long arg1) {
        arg0.setPositionInOverlay-k-4lQ0M(arg1);
    }

    public void draw(ContentDrawScope arg8) {
        GraphicsLayer v1 = this.getLayer();
        if(v1 != null) {
            ContentDrawScope v0 = arg8;
            DrawScope.record-JVtK1S4$default(((DrawScope)v0), v1, 0, new RenderInTransitionOverlayNode$draw$1(arg8), 1, null);
            if(!this.enabled) {
                GraphicsLayerKt.drawLayer(((DrawScope)v0), v1);
            }

            return;
        }

        throw new IllegalArgumentException("Error: layer never initialized".toString());
    }

    public final GraphicsLayer getLayer() {
        LayerWithRenderer v0 = this.layerWithRenderer;
        if(v0 != null) {
            return v0.getLayer();
        }

        return null;
    }

    public final SharedElementEntry getParentState() {
        return this.getCurrent(SharedContentNodeKt.getModifierLocalSharedElementInternalState());
    }

    public final Function0 getRenderInOverlay() {
        return this.renderInOverlay;
    }

    public final SharedTransitionScopeImpl getSharedScope() {
        return this.sharedScope;
    }

    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay$delegate.getFloatValue();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg8, Measurable arg9, long arg10) {
        Placeable v9 = arg9.measure-BRTryo0(arg10);
        return MeasureScope.layout$default(arg8, v9.getWidth(), v9.getHeight(), null, new RenderInTransitionOverlayNode$measure$1$1(arg8, this, v9), 4, null);
    }

    public void onAttach() {
        LayerWithRenderer v0 = new LayerWithRenderer(this, DelegatableNodeKt.requireGraphicsContext(this).createGraphicsLayer());
        this.sharedScope.onLayerRendererCreated$animation(v0);
        this.layerWithRenderer = v0;
    }

    public void onDetach() {
        LayerWithRenderer v0 = this.layerWithRenderer;
        if(v0 != null) {
            this.sharedScope.onLayerRendererRemoved$animation(v0);
            DelegatableNodeKt.requireGraphicsContext(((DelegatableNode)this)).releaseGraphicsLayer(v0.getLayer());
        }
    }

    private final void setEnabled(boolean arg2) {
        if(arg2 != this.enabled) {
            Function0 v0 = this.sharedScope.getInvalidateOverlay();
            if(v0 != null) {
                v0.invoke();
            }

            DrawModifierNodeKt.invalidateDraw(this);
            this.enabled = arg2;
        }
    }

    private final void setPositionInOverlay-k-4lQ0M(long arg3) {
        if(!Offset.equals-impl0(arg3, this.positionInOverlay)) {
            Function0 v0 = this.sharedScope.getInvalidateOverlay();
            if(v0 != null) {
                v0.invoke();
            }

            DrawModifierNodeKt.invalidateDraw(this);
            this.positionInOverlay = arg3;
        }
    }

    public final void setRenderInOverlay(Function0 arg1) {
        this.renderInOverlay = arg1;
    }

    public final void setSharedScope(SharedTransitionScopeImpl arg1) {
        this.sharedScope = arg1;
    }

    public final void setZIndexInOverlay(float arg1) {
        this.zIndexInOverlay$delegate.setFloatValue(arg1);
    }
}

