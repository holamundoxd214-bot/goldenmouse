package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A\"\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0000\u001A#\u0010\b\u001A\u0004\u0018\u00010\u0003*\u00020\u00032\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A\f\u0010\u000F\u001A\u00020\u0010*\u00020\u0001H\u0002\u001A\f\u0010\u0011\u001A\u00020\u0010*\u00020\u0001H\u0002\"\u001A\u0010\u000B\u001A\u0004\u0018\u00010\f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0012"}, d2={"SemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "mergingEnabled", "", "outerSemanticsNode", "Landroidx/compose/ui/node/SemanticsModifierNode;", "findClosestParentNode", "selector", "Lkotlin/Function1;", "role", "Landroidx/compose/ui/semantics/Role;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "contentDescriptionFakeNodeId", "", "roleFakeNodeId", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode arg10, boolean arg11) {
        NodeChain v0 = arg10.getNodes$ui();
        int v1 = NodeKind.constructor-impl(8);
        Node v3 = null;
        if((v0.getAggregateChildKindSet() & v1) != 0) {
            Node v0_1;
            for(v0_1 = v0.getHead$ui(); v0_1 != null; v0_1 = v0_1.getChild$ui()) {
                if((v0_1.getKindSet$ui() & v1) != 0) {
                    Node v2 = v0_1;
                    MutableVector v4 = ((MutableVector)v3);
                    while(true) {
                    label_14:
                        if(v2 != null) {
                            if((v2 instanceof SemanticsModifierNode)) {
                                v3 = v2;
                                goto label_59;
                            }
                            else {
                                if((v2.getKindSet$ui() & v1) != 0 && ((v2 instanceof DelegatingNode))) {
                                    Node v5 = v2.getDelegate$ui();
                                    int v7 = 0;
                                    while(v5 != null) {
                                        if((v5.getKindSet$ui() & v1) != 0) {
                                            ++v7;
                                            if(v7 == 1) {
                                                v2 = v5;
                                            }
                                            else {
                                                if(v4 == null) {
                                                    v4 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v4 != null) {
                                                        v4.add(v2);
                                                    }

                                                    v2 = v3;
                                                }

                                                if(v4 == null) {
                                                    goto label_48;
                                                }

                                                v4.add(v5);
                                            }
                                        }

                                    label_48:
                                        v5 = v5.getChild$ui();
                                    }

                                    if(v7 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }
                        }

                        goto label_54;
                    }

                    v2 = DelegatableNodeKt.pop(v4);
                    goto label_14;
                }

            label_54:
                if((v0_1.getAggregateChildKindSet$ui() & v1) == 0) {
                    break;
                }
            }
        }

    label_59:
        Intrinsics.checkNotNull(v3);
        v0_1 = ((SemanticsModifierNode)v3).getNode();
        SemanticsConfiguration v1_1 = arg10.getSemanticsConfiguration();
        if(v1_1 == null) {
            v1_1 = new SemanticsConfiguration();
        }

        return new SemanticsNode(v0_1, arg11, arg10, v1_1);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode arg2, boolean arg3, LayoutNode arg4) {
        Node v2 = arg2.getNode();
        SemanticsConfiguration v1 = arg4.getSemanticsConfiguration();
        if(v1 == null) {
            v1 = new SemanticsConfiguration();
        }

        return new SemanticsNode(v2, arg3, arg4, v1);
    }

    public static SemanticsNode SemanticsNode$default(SemanticsModifierNode arg0, boolean arg1, LayoutNode arg2, int arg3, Object arg4) {
        if((arg3 & 4) != 0) {
            arg2 = DelegatableNodeKt.requireLayoutNode(arg0);
        }

        return SemanticsNodeKt.SemanticsNode(arg0, arg1, arg2);
    }

    public static final int access$contentDescriptionFakeNodeId(SemanticsNode arg0) {
        return SemanticsNodeKt.contentDescriptionFakeNodeId(arg0);
    }

    public static final Role access$getRole(SemanticsNode arg0) {
        return SemanticsNodeKt.getRole(arg0);
    }

    public static final int access$roleFakeNodeId(SemanticsNode arg0) {
        return SemanticsNodeKt.roleFakeNodeId(arg0);
    }

    private static final int contentDescriptionFakeNodeId(SemanticsNode arg1) {
        return arg1.getId() + 2000000000;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode arg1, Function1 arg2) {
        for(arg1 = arg1.getParent$ui(); arg1 != null; arg1 = arg1.getParent$ui()) {
            if(arg2.invoke(arg1).booleanValue()) {
                return arg1;
            }
        }

        return null;
    }

    private static final Role getRole(SemanticsNode arg1) {
        return SemanticsConfigurationKt.getOrNull(arg1.getUnmergedConfig$ui(), SemanticsProperties.INSTANCE.getRole());
    }

    private static final int roleFakeNodeId(SemanticsNode arg1) {
        return arg1.getId() + 1000000000;
    }
}

