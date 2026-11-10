package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\f\u0010\u0003\u001A\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2={"invalidateFocusEvent", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusState", "Landroidx/compose/ui/focus/FocusState;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusEventModifierNodeKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[FocusStateImpl.values().length];
            try {
                v0[FocusStateImpl.Active.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[FocusStateImpl.ActiveParent.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[FocusStateImpl.Captured.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[FocusStateImpl.Inactive.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final FocusState getFocusState(FocusEventModifierNode arg13) {
        Node v13_1;
        Object v13;
        int v7;
        int v0 = NodeKind.constructor-impl(0x400);
        Node v1 = ((DelegatableNode)arg13).getNode();
        Node v2 = null;
        MutableVector v3 = ((MutableVector)v2);
        while(true) {
        label_5:
            int v4 = 4;
            int v5 = 3;
            int v6 = 2;
            v7 = 16;
            if(v1 == null) {
                goto label_59;
            }

            if((v1 instanceof FocusTargetNode)) {
                FocusStateImpl v1_1 = ((FocusTargetNode)v1).getFocusState();
                v7 = WhenMappings.$EnumSwitchMapping$0[v1_1.ordinal()];
                if(v7 != 1 && v7 != v6 && v7 != v5) {
                    if(v7 == v4) {
                        break;
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return ((FocusState)v1_1);
            }
            else {
                if((v1.getKindSet$ui() & v0) == 0) {
                    break;
                }

                if(!(v1 instanceof DelegatingNode)) {
                    break;
                }

                Node v4_1 = v1.getDelegate$ui();
                v5 = 0;
                while(v4_1 != null) {
                    if((v4_1.getKindSet$ui() & v0) != 0) {
                        ++v5;
                        if(v5 == 1) {
                            v1 = v4_1;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v7], 0);
                            }

                            if(v1 != null) {
                                if(v3 != null) {
                                    v3.add(v1);
                                }

                                v1 = v2;
                            }

                            if(v3 == null) {
                                goto label_53;
                            }

                            v3.add(v4_1);
                        }
                    }

                label_53:
                    v4_1 = v4_1.getChild$ui();
                }

                if(v5 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v1 = DelegatableNodeKt.access$pop(v3);
        goto label_5;
    label_59:
        if(!((DelegatableNode)arg13).getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v1_2 = new MutableVector(new Node[v7], 0);
        Node v3_1 = ((DelegatableNode)arg13).getNode().getChild$ui();
        if(v3_1 == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(v1_2, ((DelegatableNode)arg13).getNode(), false);
        }
        else {
            v1_2.add(v3_1);
        }

    label_74:
        while(v1_2.getSize() != 0) {
            v13 = v1_2.removeAt(v1_2.getSize() - 1);
            if((((Node)v13).getAggregateChildKindSet$ui() & v0) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(v1_2, ((Node)v13), false);
                continue;
            }

            goto label_84;
        }

        return FocusStateImpl.Inactive;
        while(true) {
        label_84:
            if(v13 == null) {
                goto label_74;
            }

            if((((Node)v13).getKindSet$ui() & v0) != 0) {
                v3 = ((MutableVector)v2);
                break;
            }

            v13_1 = ((Node)v13).getChild$ui();
        }

        while(true) {
        label_89:
            if(v13 == null) {
                goto label_74;
            }

            if((v13 instanceof FocusTargetNode)) {
                FocusStateImpl v13_2 = ((FocusTargetNode)v13).getFocusState();
                int v10 = WhenMappings.$EnumSwitchMapping$0[v13_2.ordinal()];
                if(v10 != 1 && v10 != v6 && v10 != v5) {
                    if(v10 == v4) {
                        break;
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }

                return ((FocusState)v13_2);
            }
            else {
                if((((Node)v13).getKindSet$ui() & v0) == 0) {
                    break;
                }

                if(!(v13 instanceof DelegatingNode)) {
                    break;
                }

                Node v10_1 = v13.getDelegate$ui();
                int v11 = 0;
                while(v10_1 != null) {
                    if((v10_1.getKindSet$ui() & v0) != 0) {
                        ++v11;
                        if(v11 == 1) {
                            v13_1 = v10_1;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v7], 0);
                            }

                            if(v13 != null) {
                                if(v3 != null) {
                                    v3.add(v13);
                                }

                                v13 = v2;
                            }

                            if(v3 == null) {
                                goto label_131;
                            }

                            v3.add(v10_1);
                        }
                    }

                label_131:
                    v10_1 = v10_1.getChild$ui();
                }

                if(v11 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v13_1 = DelegatableNodeKt.access$pop(v3);
        goto label_89;
    }

    public static final void invalidateFocusEvent(FocusEventModifierNode arg1) {
        DelegatableNodeKt.requireOwner(arg1).getFocusOwner().scheduleInvalidation(arg1);
    }
}

