package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.DragInteraction$Stop;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J!\u0010\u0017\u001A\u00020\u0012*\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u001B¢\u0006\u0004\b\u001C\u0010\u001DR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2={"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "<init>", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "interactions", "", "Landroidx/compose/foundation/interaction/Interaction;", "currentInteraction", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class StateLayer {
    private final Animatable animatedAlpha;
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List interactions;
    private final Function0 rippleAlpha;

    public StateLayer(boolean arg2, Function0 arg3) {
        super();
        this.bounded = arg2;
        this.rippleAlpha = arg3;
        this.animatedAlpha = AnimatableKt.Animatable$default(0f, 0f, 2, null);
        this.interactions = new ArrayList();
    }

    public static final Animatable access$getAnimatedAlpha$p(StateLayer arg0) {
        return arg0.animatedAlpha;
    }

    public final void drawStateLayer-mxwnekA(DrawScope arg23, float arg24, long arg25) {
        StateLayer v0 = this;
        float v4 = v0.animatedAlpha.getValue().floatValue();
        if(v4 > 0f) {
            long v11 = Color.copy-wmQWz5c$default(arg25, v4, 0f, 0f, 0f, 14, null);
            if(v0.bounded) {
                float v5 = Size.getWidth-impl(arg23.getSize-NH-jbRc());
                float v6 = Size.getHeight-impl(arg23.getSize-NH-jbRc());
                int v7 = ClipOp.Companion.getIntersect-rtfAjoo();
                DrawContext v1 = arg23.getDrawContext();
                long v8 = v1.getSize-NH-jbRc();
                v1.getCanvas().save();
                try {
                    v1.getTransform().clipRect-N_I0leg(0f, 0f, v5, v6, v7);
                    DrawScope.drawCircle-VaOC9Bg$default(arg23, v11, arg24, 0, 0f, null, null, 0, 0x7C, null);
                }
                catch(Throwable v0_1) {
                    v1.getCanvas().restore();
                    v1.setSize-uvyYCjk(v8);
                    throw v0_1;
                }

                v1.getCanvas().restore();
                v1.setSize-uvyYCjk(v8);
                return;
            }
            else {
                DrawScope.drawCircle-VaOC9Bg$default(arg23, v11, arg24, 0, 0f, null, null, 0, 0x7C, null);
            }
        }
    }

    public final void handleInteraction$material_ripple(Interaction arg19, CoroutineScope arg20) {
        float v3_1;
        StateLayer v0 = this;
        Interaction v1 = arg19;
        if((v1 instanceof Enter)) {
            v0.interactions.add(v1);
            goto label_40;
        }
        else if((v1 instanceof Exit)) {
            v0.interactions.remove(((Exit)v1).getEnter());
            goto label_40;
        }
        else if((v1 instanceof Focus)) {
            v0.interactions.add(v1);
            goto label_40;
        }
        else if((v1 instanceof Unfocus)) {
            v0.interactions.remove(((Unfocus)v1).getFocus());
            goto label_40;
        }
        else if((v1 instanceof Start)) {
            v0.interactions.add(v1);
            goto label_40;
        }
        else if((v1 instanceof Stop)) {
            v0.interactions.remove(((Stop)v1).getStart());
            goto label_40;
        }
        else if((v1 instanceof Cancel)) {
            v0.interactions.remove(((Cancel)v1).getStart());
        label_40:
            Object v1_1 = CollectionsKt.lastOrNull(v0.interactions);
            if(!Intrinsics.areEqual(v0.currentInteraction, v1_1)) {
                Continuation v2 = null;
                if(v1_1 != null) {
                    Object v3 = v0.rippleAlpha.invoke();
                    if((v1_1 instanceof Enter)) {
                        v3_1 = ((RippleAlpha)v3).getHoveredAlpha();
                    }
                    else if((v1_1 instanceof Focus)) {
                        v3_1 = ((RippleAlpha)v3).getFocusedAlpha();
                    }
                    else if((v1_1 instanceof Start)) {
                        v3_1 = ((RippleAlpha)v3).getDraggedAlpha();
                    }
                    else {
                        v3_1 = 0f;
                    }

                    BuildersKt.launch$default(arg20, null, null, new StateLayer$handleInteraction$1(v0, v3_1, RippleKt.incomingStateLayerAnimationSpecFor(((Interaction)v1_1)), v2), 3, null);
                }
                else {
                    BuildersKt.launch$default(arg20, null, null, new StateLayer$handleInteraction$2(v0, RippleKt.outgoingStateLayerAnimationSpecFor(v0.currentInteraction), v2), 3, null);
                }

                v0.currentInteraction = ((Interaction)v1_1);
            }
        }
    }
}

