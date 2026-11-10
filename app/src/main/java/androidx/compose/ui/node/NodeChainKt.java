package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0018\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000\u001A$\u0010\b\u001A\u00020\t\"\b\b\u0000\u0010\n*\u00020\u000B*\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\r\u001A\u00020\u000BH\u0002\u001A.\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\u000F*\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u000F2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00100\u000FH\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"ActionReplace", "", "ActionUpdate", "ActionReuse", "actionForModifiers", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "updateUnsafe", "", "T", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/ModifierNodeElement;", "node", "fillVector", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier;", "result", "stack", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;

    public static final MutableVector access$fillVector(Modifier arg0, MutableVector arg1, MutableVector arg2) {
        return NodeChainKt.fillVector(arg0, arg1, arg2);
    }

    public static final void access$updateUnsafe(ModifierNodeElement arg0, Node arg1) {
        NodeChainKt.updateUnsafe(arg0, arg1);
    }

    public static final int actionForModifiers(Element arg1, Element arg2) {
        if(Intrinsics.areEqual(arg1, arg2)) {
            return 2;
        }

        if(Actual_jvmKt.areObjectsOfSameType(arg1, arg2)) {
            return 1;
        }

        return 0;
    }

    private static final MutableVector fillVector(Modifier arg2, MutableVector arg3, MutableVector arg4) {
        arg4.add(arg2);
        NodeChainKt$fillVector$1 v2;
        for(v2 = null; arg4.getSize() != 0; v2 = v2) {
            Object v0 = arg4.removeAt(arg4.getSize() - 1);
            if((v0 instanceof CombinedModifier)) {
                arg4.add(((CombinedModifier)v0).getInner$ui());
                arg4.add(((CombinedModifier)v0).getOuter$ui());
                continue;
            }

            if((v0 instanceof Element)) {
                arg3.add(v0);
                continue;
            }

            if(v2 == null) {
                v2 = new NodeChainKt$fillVector$1(arg3);
            }

            ((Modifier)v0).all(((Function1)v2));
        }

        return arg3;
    }

    private static final void updateUnsafe(ModifierNodeElement arg1, Node arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        arg1.update(arg2);
    }
}

