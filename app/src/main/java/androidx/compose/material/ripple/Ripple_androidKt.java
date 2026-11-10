package androidx.compose.material.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A=\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0012H\u0002\u001A\u0010\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0015H\u0002¨\u0006\u0016"}, d2={"createPlatformRippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createPlatformRippleNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "createAndAttachRippleContainerIfNeeded", "Landroidx/compose/material/ripple/RippleContainer;", "view", "Landroid/view/ViewGroup;", "findNearestViewGroup", "initialView", "Landroid/view/View;", "material-ripple"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Ripple_androidKt {
    public static final RippleContainer access$createAndAttachRippleContainerIfNeeded(ViewGroup arg0) {
        return Ripple_androidKt.createAndAttachRippleContainerIfNeeded(arg0);
    }

    public static final ViewGroup access$findNearestViewGroup(View arg0) {
        return Ripple_androidKt.findNearestViewGroup(arg0);
    }

    private static final RippleContainer createAndAttachRippleContainerIfNeeded(ViewGroup arg4) {
        int v0 = arg4.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = arg4.getChildAt(v1);
            if((v2 instanceof RippleContainer)) {
                return ((RippleContainer)v2);
            }
        }

        RippleContainer v0_1 = new RippleContainer(arg4.getContext());
        arg4.addView(v0_1);
        return v0_1;
    }

    public static final DelegatableNode createPlatformRippleNode-TDGSqEk(InteractionSource arg7, boolean arg8, float arg9, ColorProducer arg10, Function0 arg11) {
        return new AndroidRippleNode(arg7, arg8, arg9, arg10, arg11, null);
    }

    private static final ViewGroup findNearestViewGroup(View arg2) {
        ViewParent v2;
        while(true) {
            if((arg2 instanceof ViewGroup)) {
                goto label_19;
            }

            ViewParent v0 = arg2.getParent();
            if(!(v0 instanceof View)) {
                break;
            }

            v2 = v0;
        }

        throw new IllegalArgumentException("Couldn\'t find a valid parent for " + v2 + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?".toString());
    label_19:
        return ((View)v2);
    }
}

