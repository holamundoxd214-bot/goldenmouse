package androidx.compose.animation;

import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\"\u0010\u0003\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"DefaultEnabled", "Lkotlin/Function0;", "", "createContentScaleModifier", "Landroidx/compose/ui/Modifier;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SkipToLookaheadSizeNodeKt {
    private static final Function0 DefaultEnabled;

    static {
        SkipToLookaheadSizeNodeKt.DefaultEnabled = SkipToLookaheadSizeNodeKt$DefaultEnabled$1.INSTANCE;
    }

    public static final Function0 access$getDefaultEnabled$p() {
        return SkipToLookaheadSizeNodeKt.DefaultEnabled;
    }

    public static final Modifier createContentScaleModifier(Modifier arg2, ScaleToBoundsImpl arg3, Function0 arg4) {
        Companion v0_1;
        if(Intrinsics.areEqual(arg3.getContentScale(), ContentScale.Companion.getCrop())) {
            Modifier v0 = GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new SkipToLookaheadSizeNodeKt$createContentScaleModifier$1(arg4));
        }
        else {
            v0_1 = Modifier.Companion;
        }

        return arg2.then(((Modifier)v0_1)).then(new SkipToLookaheadSizeElement(arg3, arg4));
    }
}

