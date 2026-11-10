package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J3\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\t\u0010\nJ<\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\"\u0010\u000F\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000E0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H¦@¢\u0006\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\u0015X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0016R\u001A\u0010\u0017\u001A\u00020\u00188VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2={"Landroidx/compose/foundation/OverscrollEffect;", "", "applyToScroll", "Landroidx/compose/ui/geometry/Offset;", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInProgress", "", "()Z", "effectModifier", "Landroidx/compose/ui/Modifier;", "getEffectModifier$annotations", "()V", "getEffectModifier", "()Landroidx/compose/ui/Modifier;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface OverscrollEffect {
    Object applyToFling-BMRW4eQ(long arg1, Function2 arg2, Continuation arg3);

    long applyToScroll-Rhakbz0(long arg1, int arg2, Function1 arg3);

    default Modifier getEffectModifier() {
        return Modifier.Companion;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="This has been replaced with `node`. If you are calling this property to render overscroll, use Modifier.overscroll() instead. If you are implementing OverscrollEffect, override `node` instead to render your overscroll.", replaceWith="<_subannotation>") static void getEffectModifier$annotations() {
    }

    default DelegatableNode getNode() {
        return new OverscrollEffect$node$1();
    }

    boolean isInProgress();
}

