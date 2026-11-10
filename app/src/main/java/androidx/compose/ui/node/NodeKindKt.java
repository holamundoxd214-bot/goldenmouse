package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.BeyondBoundsLayoutProviderModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnPlacedNode;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.OnSizeChangedNode;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.relocation.BringIntoViewModifierNode;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A \u0010\u0000\u001A\u00020\u0001*\u00020\u00012\n\u0010\u0002\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0080\f¢\u0006\u0004\b\u0004\u0010\u0005\u001A \u0010\u0006\u001A\u00020\u0007*\u00020\u00012\n\u0010\b\u001A\u0006\u0012\u0002\b\u00030\u0003H\u0080\n¢\u0006\u0004\b\t\u0010\n\u001A\u0010\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0010H\u0000\u001A\u0010\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\u001A\u0010\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\u001A\u0010\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\u001A\u0010\u0010 \u001A\u00020\u001E2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\u001A \u0010!\u001A\u00020\u001E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\"\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u0001H\u0000\u001A \u0010$\u001A\u00020\u001E2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010%\u001A\u00020\u00012\u0006\u0010#\u001A\u00020\u0001H\u0002\u001A\f\u0010&\u001A\u00020\u0007*\u00020\'H\u0002\u001A\u0010\u0010(\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\"\u001C\u0010\u000B\u001A\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r\"\u0014\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0016\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001A\u0010\u0018\"\u0014\u0010\u001B\u001A\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001C\u0010\u0018¨\u0006)"}, d2={"or", "", "other", "Landroidx/compose/ui/node/NodeKind;", "or-64DMado", "(II)I", "contains", "", "value", "contains-64DMado", "(II)Z", "includeSelfInTraversal", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "node", "Landroidx/compose/ui/Modifier$Node;", "Updated", "getUpdated$annotations", "()V", "Inserted", "getInserted$annotations", "Removed", "getRemoved$annotations", "autoInvalidateRemovedNode", "", "autoInvalidateInsertedNode", "autoInvalidateUpdatedNode", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "specifiesCanFocusProperty", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "calculateNodeKindSetFromIncludingDelegates", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated;
    private static final MutableObjectIntMap classToKindSetMap;

    static {
        NodeKindKt.classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();
    }

    public static final void autoInvalidateInsertedNode(Node arg2) {
        if(!arg2.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }

        NodeKindKt.autoInvalidateNodeIncludingDelegates(arg2, -1, 1);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Node arg2, int arg3, int arg4) {
        if((arg2 instanceof DelegatingNode)) {
            Node v0 = arg2;
            NodeKindKt.autoInvalidateNodeSelf(arg2, ((DelegatingNode)v0).getSelfKindSet$ui() & arg3, arg4);
            int v2 = ~((DelegatingNode)v0).getSelfKindSet$ui() & arg3;
            Node v3;
            for(v3 = ((DelegatingNode)v0).getDelegate$ui(); v3 != null; v3 = v3.getChild$ui()) {
                NodeKindKt.autoInvalidateNodeIncludingDelegates(v3, v2, arg4);
            }

            return;
        }

        NodeKindKt.autoInvalidateNodeSelf(arg2, arg3 & arg2.getKindSet$ui(), arg4);
    }

    private static final void autoInvalidateNodeSelf(Node arg5, int arg6, int arg7) {
        LayoutNode v1;
        if(arg7 != 0 || (arg5.getShouldAutoInvalidate())) {
            int v0 = 2;
            if((NodeKind.constructor-impl(v0) & arg6) != 0 && ((arg5 instanceof LayoutModifierNode))) {
                LayoutModifierNodeKt.invalidateMeasurement(arg5);
                if(arg7 == v0) {
                    DelegatableNodeKt.requireCoordinator-64DMado(arg5, NodeKind.constructor-impl(v0)).onRelease();
                }
            }

            if((NodeKind.constructor-impl(0x80) & arg6) != 0 && arg7 != v0) {
                DelegatableNodeKt.requireLayoutNode(arg5).invalidateMeasurements$ui();
            }

            if((NodeKind.constructor-impl(0x400000) & arg6) != 0 && arg7 != v0) {
                LayoutNode.requestRelayout$ui$default(DelegatableNodeKt.requireLayoutNode(arg5), false, 1, null);
            }

            if((NodeKind.constructor-impl(0x100) & arg6) != 0 && ((arg5 instanceof GlobalPositionAwareModifierNode))) {
                if(arg7 == 1) {
                    v1 = DelegatableNodeKt.requireLayoutNode(arg5);
                    v1.setGloballyPositionedObservers(v1.getGloballyPositionedObservers() + 1);
                }
                else if(arg7 != v0) {
                }
                else {
                    v1 = DelegatableNodeKt.requireLayoutNode(arg5);
                    v1.setGloballyPositionedObservers(v1.getGloballyPositionedObservers() - 1);
                }

                if(arg7 == v0) {
                    goto label_60;
                }

                DelegatableNodeKt.requireLayoutNode(arg5).invalidateOnPositioned$ui();
            }

        label_60:
            if((NodeKind.constructor-impl(4) & arg6) != 0 && ((arg5 instanceof DrawModifierNode))) {
                DrawModifierNodeKt.invalidateDraw(arg5);
            }

            if((NodeKind.constructor-impl(8) & arg6) != 0 && ((arg5 instanceof SemanticsModifierNode))) {
                DelegatableNodeKt.requireLayoutNode(arg5).setSemanticsInvalidated$ui(true);
            }

            if((NodeKind.constructor-impl(0x40) & arg6) != 0 && ((arg5 instanceof ParentDataModifierNode))) {
                ParentDataModifierNodeKt.invalidateParentData(arg5);
            }

            if((NodeKind.constructor-impl(0x800) & arg6) != 0 && ((arg5 instanceof FocusPropertiesModifierNode))) {
                Node v7 = arg5;
                if(NodeKindKt.specifiesCanFocusProperty(((FocusPropertiesModifierNode)v7))) {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties(((FocusPropertiesModifierNode)v7));
                }
            }

            if((arg6 & NodeKind.constructor-impl(0x1000)) == 0) {
                return;
            }

            if(!(arg5 instanceof FocusEventModifierNode)) {
                return;
            }

            FocusEventModifierNodeKt.invalidateFocusEvent(((FocusEventModifierNode)arg5));
        }
        else {
        }
    }

    public static final void autoInvalidateRemovedNode(Node arg2) {
        if(!arg2.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }

        NodeKindKt.autoInvalidateNodeIncludingDelegates(arg2, -1, 2);
    }

    public static final void autoInvalidateUpdatedNode(Node arg2) {
        if(!arg2.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }

        NodeKindKt.autoInvalidateNodeIncludingDelegates(arg2, -1, 0);
    }

    public static final int calculateNodeKindSetFrom(Node arg6) {
        int v3;
        if(arg6.getKindSet$ui() != 0) {
            return arg6.getKindSet$ui();
        }

        MutableObjectIntMap v0 = NodeKindKt.classToKindSetMap;
        Object v1 = Actual_jvmKt.classKeyForObject(arg6);
        int v2 = v0.findKeyIndex(v1);
        if(v2 >= 0) {
            return v0.values[v2];
        }

        v2 = NodeKind.constructor-impl(1);
        if((arg6 instanceof LayoutModifierNode)) {
            v2 |= NodeKind.constructor-impl(2);
        }

        if((arg6 instanceof DrawModifierNode)) {
            v2 |= NodeKind.constructor-impl(4);
        }

        if((arg6 instanceof SemanticsModifierNode)) {
            v2 |= NodeKind.constructor-impl(8);
        }

        if((arg6 instanceof PointerInputModifierNode)) {
            v2 |= NodeKind.constructor-impl(16);
        }

        if((arg6 instanceof ModifierLocalModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x20);
        }

        if((arg6 instanceof ParentDataModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x40);
        }

        int v4 = 0x400000;
        if((arg6 instanceof OnPlacedNode)) {
            v3 = NodeKind.constructor-impl(v4);
            goto label_47;
        }
        else {
            int v5 = 0x80;
            if((arg6 instanceof OnSizeChangedNode)) {
                v3 = NodeKind.constructor-impl(v5);
                goto label_47;
            }
            else if((arg6 instanceof LayoutAwareModifierNode)) {
                v2 |= NodeKind.constructor-impl(v5);
                v3 = NodeKind.constructor-impl(v4);
            label_47:
                v2 |= v3;
            }
        }

        if((arg6 instanceof GlobalPositionAwareModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x100);
        }

        if((arg6 instanceof ApproachLayoutModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x200);
        }

        if((arg6 instanceof FocusTargetNode)) {
            v2 |= NodeKind.constructor-impl(0x400);
        }

        if((arg6 instanceof FocusPropertiesModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x800);
        }

        if((arg6 instanceof FocusEventModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x1000);
        }

        if((arg6 instanceof KeyInputModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x2000);
        }

        if((arg6 instanceof RotaryInputModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x4000);
        }

        if((arg6 instanceof CompositionLocalConsumerModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x8000);
        }

        if((arg6 instanceof SoftKeyboardInterceptionModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x20000);
        }

        if((arg6 instanceof TraversableNode)) {
            v2 |= NodeKind.constructor-impl(0x40000);
        }

        if((arg6 instanceof BringIntoViewModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x80000);
        }

        if((arg6 instanceof UnplacedAwareModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x100000);
        }

        if((arg6 instanceof IndirectPointerInputModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x200000);
        }

        if((arg6 instanceof BeyondBoundsLayoutProviderModifierNode)) {
            v2 |= NodeKind.constructor-impl(0x800000);
        }

        v0.set(v1, v2);
        return v2;
    }

    public static final int calculateNodeKindSetFrom(Element arg2) {
        int v0 = NodeKind.constructor-impl(1);
        if((arg2 instanceof LayoutModifier)) {
            v0 |= NodeKind.constructor-impl(2);
        }

        if((arg2 instanceof DrawModifier)) {
            v0 |= NodeKind.constructor-impl(4);
        }

        if((arg2 instanceof SemanticsModifier)) {
            v0 |= NodeKind.constructor-impl(8);
        }

        if((arg2 instanceof PointerInputModifier)) {
            v0 |= NodeKind.constructor-impl(16);
        }

        if(((arg2 instanceof ModifierLocalConsumer)) || ((arg2 instanceof ModifierLocalProvider))) {
            v0 |= NodeKind.constructor-impl(0x20);
        }

        if((arg2 instanceof FocusEventModifier)) {
            v0 |= NodeKind.constructor-impl(0x1000);
        }

        if((arg2 instanceof FocusOrderModifier)) {
            v0 |= NodeKind.constructor-impl(0x800);
        }

        if((arg2 instanceof OnGloballyPositionedModifier)) {
            v0 |= NodeKind.constructor-impl(0x100);
        }

        if((arg2 instanceof ParentDataModifier)) {
            v0 |= NodeKind.constructor-impl(0x40);
        }

        if((arg2 instanceof OnPlacedModifier)) {
            v0 |= NodeKind.constructor-impl(0x400000);
        }

        if((arg2 instanceof OnRemeasuredModifier)) {
            v0 |= NodeKind.constructor-impl(0x80);
        }

        if((arg2 instanceof BringIntoViewModifierNode)) {
            return NodeKind.constructor-impl(0x80000) | v0;
        }

        return v0;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Node arg2) {
        if((arg2 instanceof DelegatingNode)) {
            int v0 = ((DelegatingNode)arg2).getSelfKindSet$ui();
            for(arg2 = ((DelegatingNode)arg2).getDelegate$ui(); arg2 != null; arg2 = arg2.getChild$ui()) {
                v0 |= NodeKindKt.calculateNodeKindSetFromIncludingDelegates(arg2);
            }

            return v0;
        }

        return NodeKindKt.calculateNodeKindSetFrom(arg2);
    }

    public static final boolean contains-64DMado(int arg0, int arg1) {
        if((arg0 & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean getIncludeSelfInTraversal-H91voCI(int arg4) {
        int v1 = 1;
        int v0 = (NodeKind.constructor-impl(0x80) & arg4) != 0 ? 1 : 0;
        if((arg4 & NodeKind.constructor-impl(0x400000)) != 0) {
        }
        else {
            v1 = 0;
        }

        return v0 | v1;
    }

    private static void getInserted$annotations() {
    }

    private static void getRemoved$annotations() {
    }

    private static void getUpdated$annotations() {
    }

    public static final int or-64DMado(int arg0, int arg1) {
        return arg0 | arg1;
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode arg1) {
        CanFocusChecker.INSTANCE.reset();
        arg1.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }
}

