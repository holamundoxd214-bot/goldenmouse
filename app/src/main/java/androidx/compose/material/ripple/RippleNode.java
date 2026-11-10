package androidx.compose.material.ripple;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.foundation.interaction.PressInteraction$Release;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010.\u001A\u00020/2\u0006\u00100\u001A\u000201H\u0016¢\u0006\u0004\b2\u00103J\b\u00104\u001A\u00020/H\u0016J\u0010\u00105\u001A\u00020/2\u0006\u00106\u001A\u00020-H\u0002J\f\u00107\u001A\u00020/*\u000208H\u0016J\f\u00109\u001A\u00020/*\u00020:H&J\'\u0010;\u001A\u00020/2\u0006\u0010<\u001A\u00020=2\u0006\u00100\u001A\u00020\"2\u0006\u0010\u001B\u001A\u00020\u001CH&¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u00020/2\u0006\u0010<\u001A\u00020=H&J\u0018\u0010A\u001A\u00020/2\u0006\u0010<\u001A\u00020B2\u0006\u0010C\u001A\u00020DH\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0010\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0084\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\bX\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0013R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\u001B\u001A\u00020\u001CX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R \u0010#\u001A\u00020\"2\u0006\u0010!\u001A\u00020\"@BX\u0084\u000E¢\u0006\n\n\u0002\u0010&\u001A\u0004\b$\u0010%R\u0011\u0010\'\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b)\u0010%R\u000E\u0010*\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010+\u001A\b\u0012\u0004\u0012\u00020-0,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2={"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBounded", "()Z", "F", "getRippleAlpha", "()Lkotlin/jvm/functions/Function0;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "targetRadius", "", "getTargetRadius", "()F", "setTargetRadius", "(F)V", "value", "Landroidx/compose/ui/geometry/Size;", "rippleSize", "getRippleSize-NH-jbRc", "()J", "J", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "getRippleColor-0d7_KjU", "hasValidSize", "pendingInteractions", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/interaction/PressInteraction;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "onAttach", "handlePressInteraction", "pressInteraction", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "addRipple", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class RippleNode extends Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private final boolean bounded;
    private final ColorProducer color;
    private boolean hasValidSize;
    private final InteractionSource interactionSource;
    private final MutableObjectList pendingInteractions;
    private final float radius;
    private final Function0 rippleAlpha;
    private long rippleSize;
    private final boolean shouldAutoInvalidate;
    private StateLayer stateLayer;
    private float targetRadius;

    static {
    }

    private RippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4, Function0 arg5) {
        super();
        this.interactionSource = arg1;
        this.bounded = arg2;
        this.radius = arg3;
        this.color = arg4;
        this.rippleAlpha = arg5;
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        this.pendingInteractions = new MutableObjectList(0, 1, null);
    }

    public RippleNode(InteractionSource arg1, boolean arg2, float arg3, ColorProducer arg4, Function0 arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public static final boolean access$getHasValidSize$p(RippleNode arg0) {
        return arg0.hasValidSize;
    }

    public static final InteractionSource access$getInteractionSource$p(RippleNode arg0) {
        return arg0.interactionSource;
    }

    public static final MutableObjectList access$getPendingInteractions$p(RippleNode arg0) {
        return arg0.pendingInteractions;
    }

    public static final void access$handlePressInteraction(RippleNode arg0, PressInteraction arg1) {
        arg0.handlePressInteraction(arg1);
    }

    public static final void access$updateStateLayer(RippleNode arg0, Interaction arg1, CoroutineScope arg2) {
        arg0.updateStateLayer(arg1, arg2);
    }

    public abstract void addRipple-12SF9DM(Press arg1, long arg2, float arg3);

    public void draw(ContentDrawScope arg6) {
        arg6.drawContent();
        StateLayer v0 = this.stateLayer;
        if(v0 != null) {
            v0.drawStateLayer-mxwnekA(arg6, this.targetRadius, this.getRippleColor-0d7_KjU());
        }

        this.drawRipples(((DrawScope)arg6));
    }

    public abstract void drawRipples(DrawScope arg1);

    protected final boolean getBounded() {
        return this.bounded;
    }

    protected final Function0 getRippleAlpha() {
        return this.rippleAlpha;
    }

    public final long getRippleColor-0d7_KjU() {
        return this.color.invoke-0d7_KjU();
    }

    protected final long getRippleSize-NH-jbRc() {
        return this.rippleSize;
    }

    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    protected final float getTargetRadius() {
        return this.targetRadius;
    }

    private final void handlePressInteraction(PressInteraction arg4) {
        if((arg4 instanceof Press)) {
            this.addRipple-12SF9DM(((Press)arg4), this.rippleSize, this.targetRadius);
            return;
        }

        if((arg4 instanceof Release)) {
            this.removeRipple(((Release)arg4).getPress());
            return;
        }

        if((arg4 instanceof Cancel)) {
            this.removeRipple(((Cancel)arg4).getPress());
        }
    }

    public void onAttach() {
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new RippleNode$onAttach$1(this, null), 3, null);
    }

    public void onRemeasured-ozmzZPI(long arg4) {
        this.hasValidSize = true;
        Density v0 = DelegatableNodeKt.requireDensity(this);
        this.rippleSize = IntSizeKt.toSize-ozmzZPI(arg4);
        float v4 = Float.isNaN(this.radius) ? RippleAnimationKt.getRippleEndRadius-cSwnlzA(v0, this.bounded, this.rippleSize) : v0.toPx-0680j_4(this.radius);
        this.targetRadius = v4;
        MutableObjectList v4_1 = this.pendingInteractions;
        Object[] v5 = ((ObjectList)v4_1).content;
        int v4_2 = ((ObjectList)v4_1)._size;
        int v0_1;
        for(v0_1 = 0; v0_1 < v4_2; ++v0_1) {
            this.handlePressInteraction(v5[v0_1]);
        }

        this.pendingInteractions.clear();
    }

    public abstract void removeRipple(Press arg1);

    protected final void setTargetRadius(float arg1) {
        this.targetRadius = arg1;
    }

    private final void updateStateLayer(Interaction arg4, CoroutineScope arg5) {
        StateLayer v0 = this.stateLayer;
        if(v0 == null) {
            v0 = new StateLayer(this.bounded, this.rippleAlpha);
            DrawModifierNodeKt.invalidateDraw(this);
            this.stateLayer = v0;
        }

        v0.handleInteraction$material_ripple(arg4, arg5);
    }
}

