package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.BeyondBoundsLayoutProviderModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u009A\u0001\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A3\u0010\u0004\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A\u0016\u0010\f\u001A\u0004\u0018\u00010\u000B*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\u001A\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0001H\u0002\u001A\"\u0010\u0011\u001A\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000B0\u000E2\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u0001H\u0002\u001A1\u0010\u0013\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A1\u0010\u0014\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\nH\u0080\b\u001A)\u0010\u0015\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A3\u0010\u0015\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A)\u0010\u0016\u001A\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00072\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001A>\u0010\u0017\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001B\u0010\u001C\u001A>\u0010\u0015\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001D\u0010\u001C\u001A>\u0010\u0016\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001E\u0010\u001C\u001AH\u0010\u0004\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\b\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001F\u0010 \u001AJ\u0010!\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\n\u0010\"\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b#\u0010$\u001A<\u0010%\u001A\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010&\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\b\u001A\u00020\u0001H\u0080\b¢\u0006\u0004\b\'\u0010(\u001A<\u0010)\u001A\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010*\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\b\u001A\u00020\u0001H\u0080\b¢\u0006\u0004\b+\u0010,\u001A0\u0010\f\u001A\u0004\u0018\u0001H\u0018\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020-*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001AH\u0080\b¢\u0006\u0004\b.\u0010/\u001AH\u0010\u0013\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b0\u0010 \u001AH\u00101\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b2\u0010 \u001AH\u0010\u0014\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00010\nH\u0080\b¢\u0006\u0004\b3\u0010 \u001AH\u00104\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\b\b\u0002\u0010\u0010\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b5\u0010 \u001A\u001F\u00106\u001A\u00020\u0001*\u00020\u00022\n\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\u001AH\u0000¢\u0006\u0004\b7\u00108\u001A\u001F\u00109\u001A\u00020:*\u00020\u00022\n\u0010;\u001A\u0006\u0012\u0002\b\u00030\u001AH\u0000¢\u0006\u0004\b<\u0010=\u001A\f\u0010>\u001A\u00020\u000F*\u00020\u0002H\u0000\u001A\f\u0010?\u001A\u00020@*\u00020\u0002H\u0000\u001A\f\u0010A\u001A\u00020B*\u00020\u0002H\u0000\u001A\n\u0010C\u001A\u00020\u0005*\u00020\u0002\u001A\n\u0010D\u001A\u00020E*\u00020\u0002\u001A\n\u0010F\u001A\u00020G*\u00020\u0002\u001A\n\u0010H\u001A\u00020I*\u00020\u0002\u001A\n\u0010J\u001A\u00020K*\u00020\u0002\u001A\n\u0010L\u001A\u00020\u0005*\u00020\u0002\u001A\n\u0010M\u001A\u00020\u0005*\u00020\u0002\u001A\n\u0010N\u001A\u00020\u0005*\u00020\u0002\u001A\u0019\u0010O\u001A\u00020\u0005*\u00020\u00022\u0006\u0010P\u001A\u00020Q¢\u0006\u0004\bR\u0010S\u001A\f\u0010T\u001A\u0004\u0018\u00010U*\u00020\u0002\u001A\u000E\u0010V\u001A\u0004\u0018\u00010W*\u00020\u000BH\u0000\u001A>\u0010X\u001A\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u000B2\f\u0010;\u001A\b\u0012\u0004\u0012\u0002H\u00180\u001A2\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\bY\u0010Z\u001A\u0016\u0010[\u001A\u0004\u0018\u00010\u000B*\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u000EH\u0002\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0000\u0010\u0003¨\u0006\\"}, d2={"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "visitAncestors", "", "mask", "", "includeSelf", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Node;", "nearestAncestor", "getChildren", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "zOrder", "addLayoutNodeChildren", "node", "visitChildren", "visitSubtreeIf", "visitLocalDescendants", "visitLocalAncestors", "visitSelfAndLocalDescendants", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "visitSelfAndLocalDescendants-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalDescendants-6rFNWt0", "visitLocalAncestors-6rFNWt0", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "ancestors", "", "ancestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;IZ)Ljava/util/List;", "setOfAncestors", "", "setOfAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;IZ)Ljava/util/Set;", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "visitChildren-Y-YKmho", "visitSelfAndChildren", "visitSelfAndChildren-Y-YKmho", "visitSubtreeIf-Y-YKmho", "visitSubtree", "visitSubtree-Y-YKmho", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "requireSemanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "requestAutofill", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invalidateSubtree", "invalidateMeasurementForSubtree", "invalidateDrawForSubtree", "dispatchOnScrollChanged", "delta", "Landroidx/compose/ui/geometry/Offset;", "dispatchOnScrollChanged-Uv8p0NA", "(Landroidx/compose/ui/node/DelegatableNode;J)V", "findNearestBeyondBoundsLayoutAncestor", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "pop", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DelegatableNodeKt {
    public static final void access$addLayoutNodeChildren(MutableVector arg0, Node arg1, boolean arg2) {
        DelegatableNodeKt.addLayoutNodeChildren(arg0, arg1, arg2);
    }

    public static final Node access$pop(MutableVector arg0) {
        return DelegatableNodeKt.pop(arg0);
    }

    private static final void addLayoutNodeChildren(MutableVector arg1, Node arg2, boolean arg3) {
        MutableVector v2 = DelegatableNodeKt.getChildren(DelegatableNodeKt.requireLayoutNode(((DelegatableNode)arg2)), arg3);
        int v3 = v2.getSize() - 1;
        Object[] v2_1 = v2.content;
        if(v3 < v2_1.length) {
            while(v3 >= 0) {
                arg1.add(v2_1[v3].getNodes$ui().getHead$ui());
                --v3;
            }
        }
    }

    public static final List ancestors-6rFNWt0(DelegatableNode arg9, int arg10, boolean arg11) {
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v11 = arg11 ? arg9.getNode() : arg9.getNode().getParent$ui();
        LayoutNode v9 = DelegatableNodeKt.requireLayoutNode(arg9);
        Node v0 = null;
        ArrayList v1 = ((ArrayList)v0);
        while(v9 != null) {
            if((v9.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg10) != 0) {
                while(v11 != null) {
                    if((v11.getKindSet$ui() & arg10) != 0) {
                        Node v2 = v11;
                        MutableVector v3 = ((MutableVector)v0);
                        while(true) {
                        label_27:
                            if(v2 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v2 instanceof Object)) {
                                    if(v1 == null) {
                                        v1 = new ArrayList();
                                    }

                                    ((List)v1).add(v2);
                                }
                                else {
                                    if((v2.getKindSet$ui() & arg10) == 0) {
                                        break;
                                    }

                                    if(!(v2 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v4 = v2.getDelegate$ui();
                                    int v6 = 0;
                                    while(v4 != null) {
                                        if((v4.getKindSet$ui() & arg10) != 0) {
                                            ++v6;
                                            if(v6 == 1) {
                                                v2 = v4;
                                            }
                                            else {
                                                if(v3 == null) {
                                                    v3 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v3 != null) {
                                                        v3.add(v2);
                                                    }

                                                    v2 = v0;
                                                }

                                                if(v3 == null) {
                                                    goto label_75;
                                                }

                                                v3.add(v4);
                                            }
                                        }

                                    label_75:
                                        v4 = v4.getChild$ui();
                                    }

                                    if(v6 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_82;
                        }

                        v2 = DelegatableNodeKt.pop(v3);
                        goto label_27;
                    }

                label_82:
                    v11 = v11.getParent$ui();
                }
            }

            v9 = v9.getParent$ui();
            if(v9 != null) {
                NodeChain v11_1 = v9.getNodes$ui();
                if(v11_1 != null) {
                    v11 = v11_1.getTail$ui();
                    continue;
                }
            }

            v11 = v0;
        }

        return ((List)v1);
    }

    public static List ancestors-6rFNWt0$default(DelegatableNode arg7, int arg8, boolean arg9, int arg10, Object arg11) {
        if(!arg7.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v9 = 0 != 0 ? arg7.getNode() : arg7.getNode().getParent$ui();
        LayoutNode v7 = DelegatableNodeKt.requireLayoutNode(arg7);
        Node v10 = null;
        ArrayList v0 = ((ArrayList)v10);
        while(v7 != null) {
            if((v7.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg8) != 0) {
                while(v9 != null) {
                    if((v9.getKindSet$ui() & arg8) != 0) {
                        Node v1 = v9;
                        MutableVector v2 = ((MutableVector)v10);
                        while(true) {
                        label_31:
                            if(v1 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v1 instanceof Object)) {
                                    if(v0 == null) {
                                        v0 = new ArrayList();
                                    }

                                    ((List)v0).add(v1);
                                }
                                else {
                                    if((v1.getKindSet$ui() & arg8) == 0) {
                                        break;
                                    }

                                    if(!(v1 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v3 = v1.getDelegate$ui();
                                    int v4 = 0;
                                    while(v3 != null) {
                                        if((v3.getKindSet$ui() & arg8) != 0) {
                                            ++v4;
                                            if(v4 == 1) {
                                                v1 = v3;
                                            }
                                            else {
                                                if(v2 == null) {
                                                    v2 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v1 != null) {
                                                    if(v2 != null) {
                                                        v2.add(v1);
                                                    }

                                                    v1 = v10;
                                                }

                                                if(v2 == null) {
                                                    goto label_78;
                                                }

                                                v2.add(v3);
                                            }
                                        }

                                    label_78:
                                        v3 = v3.getChild$ui();
                                    }

                                    if(v4 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_85;
                        }

                        v1 = DelegatableNodeKt.pop(v2);
                        goto label_31;
                    }

                label_85:
                    v9 = v9.getParent$ui();
                }
            }

            v7 = v7.getParent$ui();
            if(v7 != null) {
                NodeChain v9_1 = v7.getNodes$ui();
                if(v9_1 != null) {
                    v9 = v9_1.getTail$ui();
                    continue;
                }
            }

            v9 = v10;
        }

        return ((List)v0);
    }

    public static final LayoutModifierNode asLayoutModifierNode(Node arg4) {
        int v0 = 2;
        LayoutModifierNode v2 = null;
        if((NodeKind.constructor-impl(v0) & arg4.getKindSet$ui()) != 0) {
            if((arg4 instanceof LayoutModifierNode)) {
                return arg4;
            }
            else if((arg4 instanceof DelegatingNode)) {
                arg4 = ((DelegatingNode)arg4).getDelegate$ui();
                while(arg4 != null) {
                    if((arg4 instanceof LayoutModifierNode)) {
                        return ((LayoutModifierNode)arg4);
                    }
                    else {
                        if(((arg4 instanceof DelegatingNode)) && (NodeKind.constructor-impl(v0) & arg4.getKindSet$ui()) != 0) {
                            arg4 = ((DelegatingNode)arg4).getDelegate$ui();
                            continue;
                        }

                        arg4 = arg4.getChild$ui();
                        continue;
                    }

                    return v2;
                }
            }
        }

        return v2;
    }

    public static final void dispatchForKind-6rFNWt0(Node arg7, int arg8, Function1 arg9) {
        Node v0 = null;
        MutableVector v1 = ((MutableVector)v0);
        while(true) {
        label_2:
            if(arg7 == null) {
                return;
            }

            Intrinsics.reifiedOperationMarker(3, "T");
            if((arg7 instanceof Object)) {
                arg9.invoke(arg7);
            }
            else if((arg7.getKindSet$ui() & arg8) != 0 && ((arg7 instanceof DelegatingNode))) {
                Node v2 = arg7.getDelegate$ui();
                int v4 = 0;
                while(v2 != null) {
                    if((v2.getKindSet$ui() & arg8) != 0) {
                        ++v4;
                        if(v4 == 1) {
                            arg7 = v2;
                        }
                        else {
                            if(v1 == null) {
                                v1 = new MutableVector(new Node[16], 0);
                            }

                            if(arg7 != null) {
                                if(v1 != null) {
                                    v1.add(arg7);
                                }

                                arg7 = v0;
                            }

                            if(v1 == null) {
                                goto label_46;
                            }

                            v1.add(v2);
                        }
                    }

                label_46:
                    v2 = v2.getChild$ui();
                }

                if(v4 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        arg7 = DelegatableNodeKt.pop(v1);
        goto label_2;
    }

    public static final void dispatchOnScrollChanged-Uv8p0NA(DelegatableNode arg0, long arg1) {
        DelegatableNodeKt.requireOwner(arg0).dispatchOnScrollChanged-k-4lQ0M(arg1);
    }

    public static final BeyondBoundsLayout findNearestBeyondBoundsLayoutAncestor(DelegatableNode arg8) {
        Node v6;
        BeyondBoundsLayout v4;
        int v0 = 0x800000;
        int v2 = 0x20;
        int v1 = NodeKind.constructor-impl(v0) | NodeKind.constructor-impl(v2);
        if(!arg8.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v3 = arg8.getNode().getParent$ui();
        LayoutNode v8 = DelegatableNodeKt.requireLayoutNode(arg8);
        while(true) {
            v4 = null;
            if(v8 == null) {
                return v4;
            }

            if((v8.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v1) != 0) {
                while(v3 != null) {
                    if((v3.getKindSet$ui() & v1) != 0) {
                        if((NodeKind.constructor-impl(v0) & v3.getKindSet$ui()) != 0) {
                            if((v3 instanceof BeyondBoundsLayoutProviderModifierNode)) {
                            }
                            else if((v3 instanceof DelegatingNode)) {
                                Node v8_1 = ((DelegatingNode)v3).getDelegate$ui();
                                v3 = ((Node)v4);
                                while(v8_1 != null) {
                                    if((v8_1 instanceof BeyondBoundsLayoutProviderModifierNode)) {
                                        v3 = v8_1;
                                    }

                                    v8_1 = v8_1.getChild$ui();
                                }
                            }
                            else {
                                v3 = ((Node)v4);
                            }

                            if(v3 != null) {
                                return ((BeyondBoundsLayoutProviderModifierNode)v3).getBeyondBoundsLayout();
                            }

                            return v4;
                        }
                        else {
                            if((NodeKind.constructor-impl(v2) & v3.getKindSet$ui()) == 0) {
                                goto label_75;
                            }

                            if((v3 instanceof ModifierLocalModifierNode)) {
                                v6 = v3;
                            }
                            else if((v3 instanceof DelegatingNode)) {
                                Node v5 = v3.getDelegate$ui();
                                v6 = ((Node)v4);
                                while(v5 != null) {
                                    if((v5 instanceof ModifierLocalModifierNode)) {
                                        v6 = v5;
                                    }

                                    v5 = v5.getChild$ui();
                                }
                            }
                            else {
                                v6 = ((Node)v4);
                            }

                            if(v6 == null) {
                                goto label_75;
                            }

                            if(!((ModifierLocalModifierNode)v6).getProvidedValues().contains$ui(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout())) {
                                goto label_75;
                            }

                            return ((ModifierLocalModifierNode)v6).getProvidedValues().get$ui(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
                        }
                    }

                label_75:
                    v3 = v3.getParent$ui();
                }
            }

            v8 = v8.getParent$ui();
            if(v8 != null) {
                NodeChain v3_1 = v8.getNodes$ui();
                if(v3_1 != null) {
                    v3 = v3_1.getTail$ui();
                    continue;
                }
            }

            v3 = ((Node)v4);
        }

        return v4;
    }

    private static final MutableVector getChildren(LayoutNode arg0, boolean arg1) {
        if(arg1) {
            return arg0.getZSortedChildren();
        }

        return arg0.get_children$ui();
    }

    public static final boolean has-64DMado(DelegatableNode arg0, int arg1) {
        if((arg0.getNode().getAggregateChildKindSet$ui() & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public static final void invalidateDrawForSubtree(DelegatableNode arg3) {
        if(arg3.getNode().isAttached()) {
            LayoutNode.invalidateDrawForSubtree$default(DelegatableNodeKt.requireLayoutNode(arg3), false, 1, null);
        }
    }

    public static final void invalidateMeasurementForSubtree(DelegatableNode arg1) {
        if(arg1.getNode().isAttached()) {
            DelegatableNodeKt.requireLayoutNode(arg1).invalidateMeasurementForSubtree();
        }
    }

    public static final void invalidateSubtree(DelegatableNode arg3) {
        if(arg3.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(DelegatableNodeKt.requireLayoutNode(arg3), false, 1, null);
        }
    }

    public static final boolean isDelegationRoot(DelegatableNode arg1) {
        if(arg1.getNode() == arg1) {
            return 1;
        }

        return 0;
    }

    public static final Node nearestAncestor(DelegatableNode arg3, int arg4) {
        Node v1;
        if(!arg3.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
        }

        Node v0 = arg3.getNode().getParent$ui();
        LayoutNode v3 = DelegatableNodeKt.requireLayoutNode(arg3);
        while(true) {
            v1 = null;
            if(v3 == null) {
                return v1;
            }

            if((v3.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg4) != 0) {
                while(v0 != null) {
                    if((v0.getKindSet$ui() & arg4) != 0) {
                        return v0;
                    }
                    else {
                        v0 = v0.getParent$ui();
                        continue;
                    }

                    break;
                }
            }

            v3 = v3.getParent$ui();
            if(v3 != null) {
                NodeChain v0_1 = v3.getNodes$ui();
                if(v0_1 != null) {
                    v0 = v0_1.getTail$ui();
                    continue;
                }
            }

            v0 = v1;
        }

        return v1;
    }

    public static final Object nearestAncestor-64DMado(DelegatableNode arg9, int arg10) {
        Node v1;
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v0 = arg9.getNode().getParent$ui();
        LayoutNode v9 = DelegatableNodeKt.requireLayoutNode(arg9);
        while(true) {
            v1 = null;
            if(v9 == null) {
                return v1;
            }

            if((v9.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg10) != 0) {
                while(v0 != null) {
                    if((v0.getKindSet$ui() & arg10) != 0) {
                        Node v2 = v0;
                        MutableVector v3 = ((MutableVector)v1);
                        while(true) {
                        label_23:
                            if(v2 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v2 instanceof Object)) {
                                    return v2;
                                }
                                else {
                                    if((v2.getKindSet$ui() & arg10) != 0 && ((v2 instanceof DelegatingNode))) {
                                        Node v4 = v2.getDelegate$ui();
                                        int v6 = 0;
                                        while(v4 != null) {
                                            if((v4.getKindSet$ui() & arg10) != 0) {
                                                ++v6;
                                                if(v6 == 1) {
                                                    v2 = v4;
                                                }
                                                else {
                                                    if(v3 == null) {
                                                        v3 = new MutableVector(new Node[16], 0);
                                                    }

                                                    if(v2 != null) {
                                                        if(v3 != null) {
                                                            v3.add(v2);
                                                        }

                                                        v2 = v1;
                                                    }

                                                    if(v3 == null) {
                                                        goto label_66;
                                                    }

                                                    v3.add(v4);
                                                }
                                            }

                                        label_66:
                                            v4 = v4.getChild$ui();
                                        }

                                        if(v6 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }
                            }

                            goto label_73;
                        }

                        v2 = DelegatableNodeKt.pop(v3);
                        goto label_23;
                    }

                label_73:
                    v0 = v0.getParent$ui();
                }
            }

            v9 = v9.getParent$ui();
            if(v9 != null) {
                NodeChain v0_1 = v9.getNodes$ui();
                if(v0_1 != null) {
                    v0 = v0_1.getTail$ui();
                    continue;
                }
            }

            v0 = v1;
        }

        return v1;
    }

    private static final Node pop(MutableVector arg1) {
        if(arg1 != null) {
            if(arg1.getSize() == 0) {
            }
            else {
                return arg1.removeAt(arg1.getSize() - 1);
            }
        }

        return null;
    }

    public static final void requestAutofill(DelegatableNode arg0) {
        DelegatableNodeKt.requireLayoutNode(arg0).requestAutofill$ui();
    }

    public static final NodeCoordinator requireCoordinator-64DMado(DelegatableNode arg2, int arg3) {
        NodeCoordinator v0 = arg2.getNode().getCoordinator$ui();
        Intrinsics.checkNotNull(v0);
        if(v0.getTail() != arg2) {
        }
        else if(NodeKindKt.getIncludeSelfInTraversal-H91voCI(arg3)) {
            NodeCoordinator v2 = v0.getWrapped$ui();
            Intrinsics.checkNotNull(v2);
            return v2;
        }

        return v0;
    }

    public static final Density requireDensity(DelegatableNode arg0) {
        return DelegatableNodeKt.requireLayoutNode(arg0).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode arg0) {
        return DelegatableNodeKt.requireOwner(arg0).getGraphicsContext();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(DelegatableNode arg1) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }

        LayoutCoordinates v1 = DelegatableNodeKt.requireCoordinator-64DMado(arg1, NodeKind.constructor-impl(2)).getCoordinates();
        if(!v1.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }

        return v1;
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode arg0) {
        return DelegatableNodeKt.requireLayoutNode(arg0).getLayoutDirection();
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode arg0) {
        NodeCoordinator v0 = arg0.getNode().getCoordinator$ui();
        if(v0 != null) {
            return v0.getLayoutNode();
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final Owner requireOwner(DelegatableNode arg0) {
        Owner v0 = DelegatableNodeKt.requireLayoutNode(arg0).getOwner$ui();
        if(v0 != null) {
            return v0;
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }

    public static final SemanticsInfo requireSemanticsInfo(DelegatableNode arg0) {
        return DelegatableNodeKt.requireLayoutNode(arg0);
    }

    public static final Set setOfAncestors-6rFNWt0(DelegatableNode arg9, int arg10, boolean arg11) {
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v11 = arg11 ? arg9.getNode() : arg9.getNode().getParent$ui();
        LayoutNode v9 = DelegatableNodeKt.requireLayoutNode(arg9);
        Node v0 = null;
        LinkedHashSet v1 = ((LinkedHashSet)v0);
        while(v9 != null) {
            if((v9.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg10) != 0) {
                while(v11 != null) {
                    if((v11.getKindSet$ui() & arg10) != 0) {
                        Node v2 = v11;
                        MutableVector v3 = ((MutableVector)v0);
                        while(true) {
                        label_27:
                            if(v2 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v2 instanceof Object)) {
                                    if(v1 == null) {
                                        v1 = new LinkedHashSet();
                                    }

                                    ((Set)v1).add(v2);
                                }
                                else {
                                    if((v2.getKindSet$ui() & arg10) == 0) {
                                        break;
                                    }

                                    if(!(v2 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v4 = v2.getDelegate$ui();
                                    int v6 = 0;
                                    while(v4 != null) {
                                        if((v4.getKindSet$ui() & arg10) != 0) {
                                            ++v6;
                                            if(v6 == 1) {
                                                v2 = v4;
                                            }
                                            else {
                                                if(v3 == null) {
                                                    v3 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v2 != null) {
                                                    if(v3 != null) {
                                                        v3.add(v2);
                                                    }

                                                    v2 = v0;
                                                }

                                                if(v3 == null) {
                                                    goto label_75;
                                                }

                                                v3.add(v4);
                                            }
                                        }

                                    label_75:
                                        v4 = v4.getChild$ui();
                                    }

                                    if(v6 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_82;
                        }

                        v2 = DelegatableNodeKt.pop(v3);
                        goto label_27;
                    }

                label_82:
                    v11 = v11.getParent$ui();
                }
            }

            v9 = v9.getParent$ui();
            if(v9 != null) {
                NodeChain v11_1 = v9.getNodes$ui();
                if(v11_1 != null) {
                    v11 = v11_1.getTail$ui();
                    continue;
                }
            }

            v11 = v0;
        }

        return ((Set)v1);
    }

    public static Set setOfAncestors-6rFNWt0$default(DelegatableNode arg7, int arg8, boolean arg9, int arg10, Object arg11) {
        if(!arg7.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v9 = 0 != 0 ? arg7.getNode() : arg7.getNode().getParent$ui();
        LayoutNode v7 = DelegatableNodeKt.requireLayoutNode(arg7);
        Node v10 = null;
        LinkedHashSet v0 = ((LinkedHashSet)v10);
        while(v7 != null) {
            if((v7.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg8) != 0) {
                while(v9 != null) {
                    if((v9.getKindSet$ui() & arg8) != 0) {
                        Node v1 = v9;
                        MutableVector v2 = ((MutableVector)v10);
                        while(true) {
                        label_31:
                            if(v1 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v1 instanceof Object)) {
                                    if(v0 == null) {
                                        v0 = new LinkedHashSet();
                                    }

                                    ((Set)v0).add(v1);
                                }
                                else {
                                    if((v1.getKindSet$ui() & arg8) == 0) {
                                        break;
                                    }

                                    if(!(v1 instanceof DelegatingNode)) {
                                        break;
                                    }

                                    Node v3 = v1.getDelegate$ui();
                                    int v4 = 0;
                                    while(v3 != null) {
                                        if((v3.getKindSet$ui() & arg8) != 0) {
                                            ++v4;
                                            if(v4 == 1) {
                                                v1 = v3;
                                            }
                                            else {
                                                if(v2 == null) {
                                                    v2 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v1 != null) {
                                                    if(v2 != null) {
                                                        v2.add(v1);
                                                    }

                                                    v1 = v10;
                                                }

                                                if(v2 == null) {
                                                    goto label_78;
                                                }

                                                v2.add(v3);
                                            }
                                        }

                                    label_78:
                                        v3 = v3.getChild$ui();
                                    }

                                    if(v4 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_85;
                        }

                        v1 = DelegatableNodeKt.pop(v2);
                        goto label_31;
                    }

                label_85:
                    v9 = v9.getParent$ui();
                }
            }

            v7 = v7.getParent$ui();
            if(v7 != null) {
                NodeChain v9_1 = v7.getNodes$ui();
                if(v9_1 != null) {
                    v9 = v9_1.getTail$ui();
                    continue;
                }
            }

            v9 = v10;
        }

        return ((Set)v0);
    }

    public static final void visitAncestors(DelegatableNode arg1, int arg2, boolean arg3, Function1 arg4) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v3 = arg3 ? arg1.getNode() : arg1.getNode().getParent$ui();
        LayoutNode v1 = DelegatableNodeKt.requireLayoutNode(arg1);
        while(v1 != null) {
            if((v1.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg2) != 0) {
                while(v3 != null) {
                    if((v3.getKindSet$ui() & arg2) != 0) {
                        arg4.invoke(v3);
                    }

                    v3 = v3.getParent$ui();
                }
            }

            v1 = v1.getParent$ui();
            if(v1 != null) {
                NodeChain v3_1 = v1.getNodes$ui();
                if(v3_1 != null) {
                    v3 = v3_1.getTail$ui();
                    continue;
                }
            }

            v3 = null;
        }
    }

    public static void visitAncestors$default(DelegatableNode arg0, int arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        if(!arg0.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v2 = 0 != 0 ? arg0.getNode() : arg0.getNode().getParent$ui();
        LayoutNode v0 = DelegatableNodeKt.requireLayoutNode(arg0);
        while(v0 != null) {
            if((v0.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg1) != 0) {
                while(v2 != null) {
                    if((v2.getKindSet$ui() & arg1) != 0) {
                        arg3.invoke(v2);
                    }

                    v2 = v2.getParent$ui();
                }
            }

            v0 = v0.getParent$ui();
            if(v0 != null) {
                NodeChain v2_1 = v0.getNodes$ui();
                if(v2_1 != null) {
                    v2 = v2_1.getTail$ui();
                    continue;
                }
            }

            v2 = null;
        }
    }

    public static final void visitAncestors-Y-YKmho(DelegatableNode arg8, int arg9, boolean arg10, Function1 arg11) {
        if(!arg8.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v10 = arg10 ? arg8.getNode() : arg8.getNode().getParent$ui();
        LayoutNode v8 = DelegatableNodeKt.requireLayoutNode(arg8);
        while(v8 != null) {
            Node v1 = null;
            if((v8.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg9) != 0) {
                while(v10 != null) {
                    if((v10.getKindSet$ui() & arg9) != 0) {
                        Node v0 = v10;
                        MutableVector v2 = ((MutableVector)v1);
                        while(true) {
                        label_26:
                            if(v0 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v0 instanceof Object)) {
                                    arg11.invoke(v0);
                                }
                                else if((v0.getKindSet$ui() & arg9) != 0 && ((v0 instanceof DelegatingNode))) {
                                    Node v3 = v0.getDelegate$ui();
                                    int v5 = 0;
                                    while(v3 != null) {
                                        if((v3.getKindSet$ui() & arg9) != 0) {
                                            ++v5;
                                            if(v5 == 1) {
                                                v0 = v3;
                                            }
                                            else {
                                                if(v2 == null) {
                                                    v2 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v0 != null) {
                                                    if(v2 != null) {
                                                        v2.add(v0);
                                                    }

                                                    v0 = v1;
                                                }

                                                if(v2 == null) {
                                                    goto label_70;
                                                }

                                                v2.add(v3);
                                            }
                                        }

                                    label_70:
                                        v3 = v3.getChild$ui();
                                    }

                                    if(v5 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_77;
                        }

                        v0 = DelegatableNodeKt.pop(v2);
                        goto label_26;
                    }

                label_77:
                    v10 = v10.getParent$ui();
                }
            }

            v8 = v8.getParent$ui();
            if(v8 != null) {
                NodeChain v10_1 = v8.getNodes$ui();
                if(v10_1 != null) {
                    v10 = v10_1.getTail$ui();
                    continue;
                }
            }

            v10 = v1;
        }
    }

    public static void visitAncestors-Y-YKmho$default(DelegatableNode arg6, int arg7, boolean arg8, Function1 arg9, int arg10, Object arg11) {
        if(!arg6.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v8 = 0 != 0 ? arg6.getNode() : arg6.getNode().getParent$ui();
        LayoutNode v6 = DelegatableNodeKt.requireLayoutNode(arg6);
        while(v6 != null) {
            Node v0 = null;
            if((v6.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & arg7) != 0) {
                while(v8 != null) {
                    if((v8.getKindSet$ui() & arg7) != 0) {
                        Node v10 = v8;
                        MutableVector v1 = ((MutableVector)v0);
                        while(true) {
                        label_30:
                            if(v10 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v10 instanceof Object)) {
                                    arg9.invoke(v10);
                                }
                                else if((v10.getKindSet$ui() & arg7) != 0 && ((v10 instanceof DelegatingNode))) {
                                    Node v2 = v10.getDelegate$ui();
                                    int v3 = 0;
                                    while(v2 != null) {
                                        if((v2.getKindSet$ui() & arg7) != 0) {
                                            ++v3;
                                            if(v3 == 1) {
                                                v10 = v2;
                                            }
                                            else {
                                                if(v1 == null) {
                                                    v1 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v10 != null) {
                                                    if(v1 != null) {
                                                        v1.add(v10);
                                                    }

                                                    v10 = v0;
                                                }

                                                if(v1 == null) {
                                                    goto label_73;
                                                }

                                                v1.add(v2);
                                            }
                                        }

                                    label_73:
                                        v2 = v2.getChild$ui();
                                    }

                                    if(v3 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_80;
                        }

                        v10 = DelegatableNodeKt.pop(v1);
                        goto label_30;
                    }

                label_80:
                    v8 = v8.getParent$ui();
                }
            }

            v6 = v6.getParent$ui();
            if(v6 != null) {
                NodeChain v8_1 = v6.getNodes$ui();
                if(v8_1 != null) {
                    v8 = v8_1.getTail$ui();
                    continue;
                }
            }

            v8 = v0;
        }
    }

    public static final void visitChildren(DelegatableNode arg3, int arg4, boolean arg5, Function1 arg6) {
        Object v3;
        if(!arg3.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v0 = new MutableVector(new Node[16], 0);
        Node v1 = arg3.getNode().getChild$ui();
        if(v1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0, arg3.getNode(), arg5);
        }
        else {
            v0.add(v1);
        }

    label_17:
        while(v0.getSize() != 0) {
            v3 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v3).getAggregateChildKindSet$ui() & arg4) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v0, ((Node)v3), arg5);
                continue;
            }

            goto label_27;
        }

        return;
        while(true) {
        label_27:
            if(v3 == null) {
                goto label_17;
            }

            if((((Node)v3).getKindSet$ui() & arg4) != 0) {
                arg6.invoke(v3);
                goto label_17;
            }

            Node v3_1 = v3_1.getChild$ui();
        }
    }

    public static final void visitChildren-Y-YKmho(DelegatableNode arg9, int arg10, boolean arg11, Function1 arg12) {
        Node v9_1;
        MutableVector v5;
        Object v4;
        Object v9;
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v1 = 16;
        MutableVector v0 = new MutableVector(new Node[v1], 0);
        Node v2 = arg9.getNode().getChild$ui();
        if(v2 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0, arg9.getNode(), arg11);
        }
        else {
            v0.add(v2);
        }

    label_18:
        while(v0.getSize() != 0) {
            v9 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v9).getAggregateChildKindSet$ui() & arg10) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v0, ((Node)v9), arg11);
                continue;
            }

            goto label_29;
        }

        return;
        while(true) {
        label_29:
            if(v9 == null) {
                goto label_18;
            }

            if((((Node)v9).getKindSet$ui() & arg10) != 0) {
                v4 = null;
                v5 = ((MutableVector)v4);
                break;
            }

            v9_1 = ((Node)v9).getChild$ui();
        }

        while(true) {
        label_36:
            if(v9 == null) {
                goto label_18;
            }

            Intrinsics.reifiedOperationMarker(3, "T");
            if((v9 instanceof Object)) {
                arg12.invoke(v9);
            }
            else if((((Node)v9).getKindSet$ui() & arg10) != 0 && ((v9 instanceof DelegatingNode))) {
                Node v6 = v9.getDelegate$ui();
                int v7 = 0;
                while(v6 != null) {
                    if((v6.getKindSet$ui() & arg10) != 0) {
                        ++v7;
                        if(v7 == 1) {
                            v9_1 = v6;
                        }
                        else {
                            if(v5 == null) {
                                v5 = new MutableVector(new Node[v1], 0);
                            }

                            if(v9 != null) {
                                if(v5 != null) {
                                    v5.add(v9);
                                }

                                v9 = v4;
                            }

                            if(v5 == null) {
                                goto label_77;
                            }

                            v5.add(v6);
                        }
                    }

                label_77:
                    v6 = v6.getChild$ui();
                }

                if(v7 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v9_1 = DelegatableNodeKt.pop(v5);
        goto label_36;
    }

    public static void visitChildren-Y-YKmho$default(DelegatableNode arg7, int arg8, boolean arg9, Function1 arg10, int arg11, Object arg12) {
        Node v7_1;
        MutableVector v3;
        Object v2;
        Object v7;
        if(!arg7.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        int v0 = 16;
        MutableVector v11 = new MutableVector(new Node[v0], 0);
        Node v1 = arg7.getNode().getChild$ui();
        if(v1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v11, arg7.getNode(), false);
        }
        else {
            v11.add(v1);
        }

    label_21:
        while(v11.getSize() != 0) {
            v7 = v11.removeAt(v11.getSize() - 1);
            if((((Node)v7).getAggregateChildKindSet$ui() & arg8) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v11, ((Node)v7), false);
                continue;
            }

            goto label_32;
        }

        return;
        while(true) {
        label_32:
            if(v7 == null) {
                goto label_21;
            }

            if((((Node)v7).getKindSet$ui() & arg8) != 0) {
                v2 = null;
                v3 = ((MutableVector)v2);
                break;
            }

            v7_1 = ((Node)v7).getChild$ui();
        }

        while(true) {
        label_39:
            if(v7 == null) {
                goto label_21;
            }

            Intrinsics.reifiedOperationMarker(3, "T");
            if((v7 instanceof Object)) {
                arg10.invoke(v7);
            }
            else if((((Node)v7).getKindSet$ui() & arg8) != 0 && ((v7 instanceof DelegatingNode))) {
                Node v4 = v7.getDelegate$ui();
                int v5 = 0;
                while(v4 != null) {
                    if((v4.getKindSet$ui() & arg8) != 0) {
                        ++v5;
                        if(v5 == 1) {
                            v7_1 = v4;
                        }
                        else {
                            if(v3 == null) {
                                v3 = new MutableVector(new Node[v0], 0);
                            }

                            if(v7 != null) {
                                if(v3 != null) {
                                    v3.add(v7);
                                }

                                v7 = v2;
                            }

                            if(v3 == null) {
                                goto label_80;
                            }

                            v3.add(v4);
                        }
                    }

                label_80:
                    v4 = v4.getChild$ui();
                }

                if(v5 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v7_1 = DelegatableNodeKt.pop(v3);
        goto label_39;
    }

    public static final void visitLocalAncestors(DelegatableNode arg1, int arg2, Function1 arg3) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }

        Node v1;
        for(v1 = arg1.getNode().getParent$ui(); v1 != null; v1 = v1.getParent$ui()) {
            if((v1.getKindSet$ui() & arg2) != 0) {
                arg3.invoke(v1);
            }
        }
    }

    public static final void visitLocalAncestors-6rFNWt0(DelegatableNode arg8, int arg9, Function1 arg10) {
        if(!arg8.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }

        Node v8;
        for(v8 = arg8.getNode().getParent$ui(); v8 != null; v8 = v8.getParent$ui()) {
            if((v8.getKindSet$ui() & arg9) != 0) {
                Node v0 = null;
                Node v1 = v8;
                MutableVector v2 = ((MutableVector)v0);
                while(true) {
                label_16:
                    if(v1 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if((v1 instanceof Object)) {
                            arg10.invoke(v1);
                        }
                        else if((v1.getKindSet$ui() & arg9) != 0 && ((v1 instanceof DelegatingNode))) {
                            Node v3 = v1.getDelegate$ui();
                            int v5 = 0;
                            while(v3 != null) {
                                if((v3.getKindSet$ui() & arg9) != 0) {
                                    ++v5;
                                    if(v5 == 1) {
                                        v1 = v3;
                                    }
                                    else {
                                        if(v2 == null) {
                                            v2 = new MutableVector(new Node[16], 0);
                                        }

                                        if(v1 != null) {
                                            if(v2 != null) {
                                                v2.add(v1);
                                            }

                                            v1 = v0;
                                        }

                                        if(v2 == null) {
                                            goto label_60;
                                        }

                                        v2.add(v3);
                                    }
                                }

                            label_60:
                                v3 = v3.getChild$ui();
                            }

                            if(v5 != 1) {
                                break;
                            }

                            continue;
                        }

                        break;
                    }

                    goto label_67;
                }

                v1 = DelegatableNodeKt.pop(v2);
                goto label_16;
            }

        label_67:
        }
    }

    public static final void visitLocalDescendants(DelegatableNode arg1, int arg2, Function1 arg3) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v1 = arg1.getNode();
        if((v1.getAggregateChildKindSet$ui() & arg2) != 0) {
            for(v1 = v1.getChild$ui(); v1 != null; v1 = v1.getChild$ui()) {
                if((v1.getKindSet$ui() & arg2) != 0) {
                    arg3.invoke(v1);
                }
            }
        }
    }

    public static final void visitLocalDescendants(DelegatableNode arg1, int arg2, boolean arg3, Function1 arg4) {
        if(!arg1.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v1 = arg1.getNode();
        if((v1.getAggregateChildKindSet$ui() & arg2) == 0) {
        }
        else {
            if(arg3) {
            }
            else {
                v1 = v1.getChild$ui();
            }

            while(v1 != null) {
                if((v1.getKindSet$ui() & arg2) != 0) {
                    arg4.invoke(v1);
                }

                v1 = v1.getChild$ui();
            }
        }
    }

    public static void visitLocalDescendants$default(DelegatableNode arg0, int arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        if(!arg0.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v0 = arg0.getNode();
        if((v0.getAggregateChildKindSet$ui() & arg1) == 0) {
        }
        else {
            if(0 != 0) {
            }
            else {
                v0 = v0.getChild$ui();
            }

            while(v0 != null) {
                if((v0.getKindSet$ui() & arg1) != 0) {
                    arg3.invoke(v0);
                }

                v0 = v0.getChild$ui();
            }
        }
    }

    public static final void visitLocalDescendants-6rFNWt0(DelegatableNode arg8, int arg9, Function1 arg10) {
        if(!arg8.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v8 = arg8.getNode();
        if((v8.getAggregateChildKindSet$ui() & arg9) != 0) {
            for(v8 = v8.getChild$ui(); v8 != null; v8 = v8.getChild$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = null;
                    Node v1 = v8;
                    MutableVector v2 = ((MutableVector)v0);
                    while(true) {
                    label_19:
                        if(v1 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v1 instanceof Object)) {
                                arg10.invoke(v1);
                            }
                            else if((v1.getKindSet$ui() & arg9) != 0 && ((v1 instanceof DelegatingNode))) {
                                Node v3 = v1.getDelegate$ui();
                                int v5 = 0;
                                while(v3 != null) {
                                    if((v3.getKindSet$ui() & arg9) != 0) {
                                        ++v5;
                                        if(v5 == 1) {
                                            v1 = v3;
                                        }
                                        else {
                                            if(v2 == null) {
                                                v2 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v1 != null) {
                                                if(v2 != null) {
                                                    v2.add(v1);
                                                }

                                                v1 = v0;
                                            }

                                            if(v2 == null) {
                                                goto label_63;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_63:
                                    v3 = v3.getChild$ui();
                                }

                                if(v5 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_70;
                    }

                    v1 = DelegatableNodeKt.pop(v2);
                    goto label_19;
                }

            label_70:
            }
        }
    }

    public static final void visitSelfAndAncestors-5BbP62I(DelegatableNode arg11, int arg12, int arg13, Function1 arg14) {
        Node v0 = arg11.getNode();
        int v1 = arg12 | arg13;
        if(!arg11.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }

        Node v2 = arg11.getNode();
        LayoutNode v11 = DelegatableNodeKt.requireLayoutNode(arg11);
        while(v11 != null) {
            Node v4 = null;
            if((v11.getNodes$ui().getHead$ui().getAggregateChildKindSet$ui() & v1) != 0) {
                while(v2 != null) {
                    if((v2.getKindSet$ui() & v1) != 0) {
                        if(v2 != v0 && (v2.getKindSet$ui() & arg13) != 0) {
                            return;
                        }

                        if((v2.getKindSet$ui() & arg12) == 0) {
                            goto label_83;
                        }

                        Node v3 = v2;
                        MutableVector v5 = ((MutableVector)v4);
                        while(true) {
                        label_32:
                            if(v3 == null) {
                                goto label_83;
                            }

                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v3 instanceof Object)) {
                                arg14.invoke(v3);
                            }
                            else if((v3.getKindSet$ui() & arg12) != 0 && ((v3 instanceof DelegatingNode))) {
                                Node v6 = v3.getDelegate$ui();
                                int v8 = 0;
                                while(v6 != null) {
                                    if((v6.getKindSet$ui() & arg12) != 0) {
                                        ++v8;
                                        if(v8 == 1) {
                                            v3 = v6;
                                        }
                                        else {
                                            if(v5 == null) {
                                                v5 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v3 != null) {
                                                if(v5 != null) {
                                                    v5.add(v3);
                                                }

                                                v3 = v4;
                                            }

                                            if(v5 == null) {
                                                goto label_76;
                                            }

                                            v5.add(v6);
                                        }
                                    }

                                label_76:
                                    v6 = v6.getChild$ui();
                                }

                                if(v8 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        v3 = DelegatableNodeKt.pop(v5);
                        goto label_32;
                    }

                label_83:
                    v2 = v2.getParent$ui();
                }
            }

            v11 = v11.getParent$ui();
            if(v11 != null) {
                NodeChain v2_1 = v11.getNodes$ui();
                if(v2_1 != null) {
                    v2 = v2_1.getTail$ui();
                    continue;
                }
            }

            v2 = v4;
        }
    }

    public static final void visitSelfAndChildren-Y-YKmho(DelegatableNode arg11, int arg12, boolean arg13, Function1 arg14) {
        Node v11_1;
        Object v11;
        int v5;
        int v4;
        String v3;
        Node v0 = arg11.getNode();
        Node v1 = null;
        MutableVector v2 = ((MutableVector)v1);
        while(true) {
        label_3:
            v3 = "T";
            v4 = 3;
            v5 = 16;
            if(v0 == null) {
                goto label_54;
            }

            Intrinsics.reifiedOperationMarker(v4, v3);
            if((v0 instanceof Object)) {
                arg14.invoke(v0);
            }
            else if((v0.getKindSet$ui() & arg12) != 0 && ((v0 instanceof DelegatingNode))) {
                Node v3_1 = v0.getDelegate$ui();
                v4 = 0;
                while(v3_1 != null) {
                    if((v3_1.getKindSet$ui() & arg12) != 0) {
                        ++v4;
                        if(v4 == 1) {
                            v0 = v3_1;
                        }
                        else {
                            if(v2 == null) {
                                v2 = new MutableVector(new Node[v5], 0);
                            }

                            if(v0 != null) {
                                if(v2 != null) {
                                    v2.add(v0);
                                }

                                v0 = v1;
                            }

                            if(v2 == null) {
                                goto label_47;
                            }

                            v2.add(v3_1);
                        }
                    }

                label_47:
                    v3_1 = v3_1.getChild$ui();
                }

                if(v4 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v0 = DelegatableNodeKt.pop(v2);
        goto label_3;
    label_54:
        if(!arg11.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v0_1 = new MutableVector(new Node[v5], 0);
        Node v2_1 = arg11.getNode().getChild$ui();
        if(v2_1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0_1, arg11.getNode(), arg13);
        }
        else {
            v0_1.add(v2_1);
        }

    label_70:
        while(v0_1.getSize() != 0) {
            v11 = v0_1.removeAt(v0_1.getSize() - 1);
            if((((Node)v11).getAggregateChildKindSet$ui() & arg12) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v0_1, ((Node)v11), arg13);
                continue;
            }

            goto label_80;
        }

        return;
        while(true) {
        label_80:
            if(v11 == null) {
                goto label_70;
            }

            if((((Node)v11).getKindSet$ui() & arg12) != 0) {
                v2 = ((MutableVector)v1);
                break;
            }

            v11_1 = ((Node)v11).getChild$ui();
        }

        while(true) {
        label_86:
            if(v11 == null) {
                goto label_70;
            }

            Intrinsics.reifiedOperationMarker(v4, v3);
            if((v11 instanceof Object)) {
                arg14.invoke(v11);
            }
            else if((((Node)v11).getKindSet$ui() & arg12) != 0 && ((v11 instanceof DelegatingNode))) {
                Node v8 = v11.getDelegate$ui();
                int v9 = 0;
                while(v8 != null) {
                    if((v8.getKindSet$ui() & arg12) != 0) {
                        ++v9;
                        if(v9 == 1) {
                            v11_1 = v8;
                        }
                        else {
                            if(v2 == null) {
                                v2 = new MutableVector(new Node[v5], 0);
                            }

                            if(v11 != null) {
                                if(v2 != null) {
                                    v2.add(v11);
                                }

                                v11 = v1;
                            }

                            if(v2 == null) {
                                goto label_125;
                            }

                            v2.add(v8);
                        }
                    }

                label_125:
                    v8 = v8.getChild$ui();
                }

                if(v9 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v11_1 = DelegatableNodeKt.pop(v2);
        goto label_86;
    }

    public static void visitSelfAndChildren-Y-YKmho$default(DelegatableNode arg9, int arg10, boolean arg11, Function1 arg12, int arg13, Object arg14) {
        Node v9_1;
        Object v9;
        int v4;
        int v3;
        String v2;
        Node v13 = arg9.getNode();
        Node v0 = null;
        MutableVector v1 = ((MutableVector)v0);
        while(true) {
        label_7:
            v2 = "T";
            v3 = 3;
            v4 = 16;
            if(v13 == null) {
                goto label_57;
            }

            Intrinsics.reifiedOperationMarker(v3, v2);
            if((v13 instanceof Object)) {
                arg12.invoke(v13);
            }
            else if((v13.getKindSet$ui() & arg10) != 0 && ((v13 instanceof DelegatingNode))) {
                Node v2_1 = v13.getDelegate$ui();
                v3 = 0;
                while(v2_1 != null) {
                    if((v2_1.getKindSet$ui() & arg10) != 0) {
                        ++v3;
                        if(v3 == 1) {
                            v13 = v2_1;
                        }
                        else {
                            if(v1 == null) {
                                v1 = new MutableVector(new Node[v4], 0);
                            }

                            if(v13 != null) {
                                if(v1 != null) {
                                    v1.add(v13);
                                }

                                v13 = v0;
                            }

                            if(v1 == null) {
                                goto label_50;
                            }

                            v1.add(v2_1);
                        }
                    }

                label_50:
                    v2_1 = v2_1.getChild$ui();
                }

                if(v3 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v13 = DelegatableNodeKt.pop(v1);
        goto label_7;
    label_57:
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }

        MutableVector v13_1 = new MutableVector(new Node[v4], 0);
        Node v1_1 = arg9.getNode().getChild$ui();
        if(v1_1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v13_1, arg9.getNode(), false);
        }
        else {
            v13_1.add(v1_1);
        }

    label_73:
        while(v13_1.getSize() != 0) {
            v9 = v13_1.removeAt(v13_1.getSize() - 1);
            if((((Node)v9).getAggregateChildKindSet$ui() & arg10) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(v13_1, ((Node)v9), false);
                continue;
            }

            goto label_83;
        }

        return;
        while(true) {
        label_83:
            if(v9 == null) {
                goto label_73;
            }

            if((((Node)v9).getKindSet$ui() & arg10) != 0) {
                v1 = ((MutableVector)v0);
                break;
            }

            v9_1 = v9_1.getChild$ui();
        }

        while(true) {
        label_89:
            if(v9_1 == null) {
                goto label_73;
            }

            Intrinsics.reifiedOperationMarker(v3, v2);
            if((v9_1 instanceof Object)) {
                arg12.invoke(v9_1);
            }
            else if((v9_1.getKindSet$ui() & arg10) != 0 && ((v9_1 instanceof DelegatingNode))) {
                Node v6 = v9_1.getDelegate$ui();
                int v7 = 0;
                while(v6 != null) {
                    if((v6.getKindSet$ui() & arg10) != 0) {
                        ++v7;
                        if(v7 == 1) {
                            v9_1 = v6;
                        }
                        else {
                            if(v1 == null) {
                                v1 = new MutableVector(new Node[v4], 0);
                            }

                            if(v9_1 != null) {
                                if(v1 != null) {
                                    v1.add(v9_1);
                                }

                                v9 = v0;
                            }

                            if(v1 == null) {
                                goto label_128;
                            }

                            v1.add(v6);
                        }
                    }

                label_128:
                    v6 = v6.getChild$ui();
                }

                if(v7 != 1) {
                    break;
                }

                continue;
            }

            break;
        }

        v9_1 = DelegatableNodeKt.pop(v1);
        goto label_89;
    }

    public static final void visitSelfAndLocalDescendants-6rFNWt0(DelegatableNode arg8, int arg9, Function1 arg10) {
        if(!arg8.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }

        Node v8 = arg8.getNode();
        if((v8.getAggregateChildKindSet$ui() & arg9) != 0) {
            while(v8 != null) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = null;
                    Node v1 = v8;
                    MutableVector v2 = ((MutableVector)v0);
                    while(true) {
                    label_18:
                        if(v1 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v1 instanceof Object)) {
                                arg10.invoke(v1);
                            }
                            else if((v1.getKindSet$ui() & arg9) != 0 && ((v1 instanceof DelegatingNode))) {
                                Node v3 = v1.getDelegate$ui();
                                int v5 = 0;
                                while(v3 != null) {
                                    if((v3.getKindSet$ui() & arg9) != 0) {
                                        ++v5;
                                        if(v5 == 1) {
                                            v1 = v3;
                                        }
                                        else {
                                            if(v2 == null) {
                                                v2 = new MutableVector(new Node[16], 0);
                                            }

                                            if(v1 != null) {
                                                if(v2 != null) {
                                                    v2.add(v1);
                                                }

                                                v1 = v0;
                                            }

                                            if(v2 == null) {
                                                goto label_62;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_62:
                                    v3 = v3.getChild$ui();
                                }

                                if(v5 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_69;
                    }

                    v1 = DelegatableNodeKt.pop(v2);
                    goto label_18;
                }

            label_69:
                v8 = v8.getChild$ui();
            }
        }
    }

    public static final void visitSubtree-Y-YKmho(DelegatableNode arg11, int arg12, boolean arg13, Function1 arg14) {
        Node v6_1;
        if(!arg11.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v1 = 16;
        MutableVector v0 = new MutableVector(new Node[v1], 0);
        Node v2 = arg11.getNode().getChild$ui();
        if(v2 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0, arg11.getNode(), arg13);
        }
        else {
            v0.add(v2);
        }

        while(v0.getSize() != 0) {
            Object v11 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v11).getAggregateChildKindSet$ui() & arg12) != 0) {
                Object v4 = v11;
                while(v4 != null) {
                    if(!((Node)v4).isAttached()) {
                        break;
                    }

                    if((((Node)v4).getKindSet$ui() & arg12) != 0) {
                        Object v5 = null;
                        Object v6 = v4;
                        MutableVector v7 = ((MutableVector)v5);
                        while(true) {
                        label_38:
                            if(v6 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v6 instanceof Object)) {
                                    arg14.invoke(v6);
                                }
                                else if((((Node)v6).getKindSet$ui() & arg12) != 0 && ((v6 instanceof DelegatingNode))) {
                                    Node v8 = v6.getDelegate$ui();
                                    int v9 = 0;
                                    while(v8 != null) {
                                        if((v8.getKindSet$ui() & arg12) != 0) {
                                            ++v9;
                                            if(v9 == 1) {
                                                v6_1 = v8;
                                            }
                                            else {
                                                if(v7 == null) {
                                                    v7 = new MutableVector(new Node[v1], 0);
                                                }

                                                if(v6_1 != null) {
                                                    if(v7 != null) {
                                                        v7.add(v6_1);
                                                    }

                                                    v6 = v5;
                                                }

                                                if(v7 == null) {
                                                    goto label_79;
                                                }

                                                v7.add(v8);
                                            }
                                        }

                                    label_79:
                                        v8 = v8.getChild$ui();
                                    }

                                    if(v9 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_86;
                        }

                        v6_1 = DelegatableNodeKt.pop(v7);
                        goto label_38;
                    }

                label_86:
                    Node v4_1 = ((Node)v4).getChild$ui();
                }
            }

            DelegatableNodeKt.addLayoutNodeChildren(v0, ((Node)v11), arg13);
        }
    }

    public static void visitSubtree-Y-YKmho$default(DelegatableNode arg9, int arg10, boolean arg11, Function1 arg12, int arg13, Object arg14) {
        Node v4_1;
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v0 = 16;
        MutableVector v13 = new MutableVector(new Node[v0], 0);
        Node v1 = arg9.getNode().getChild$ui();
        if(v1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v13, arg9.getNode(), false);
        }
        else {
            v13.add(v1);
        }

        while(v13.getSize() != 0) {
            Object v9 = v13.removeAt(v13.getSize() - 1);
            if((((Node)v9).getAggregateChildKindSet$ui() & arg10) != 0) {
                Object v2 = v9;
                while(v2 != null) {
                    if(!((Node)v2).isAttached()) {
                        break;
                    }

                    if((((Node)v2).getKindSet$ui() & arg10) != 0) {
                        Object v3 = null;
                        Object v4 = v2;
                        MutableVector v5 = ((MutableVector)v3);
                        while(true) {
                        label_41:
                            if(v4 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if((v4 instanceof Object)) {
                                    arg12.invoke(v4);
                                }
                                else if((((Node)v4).getKindSet$ui() & arg10) != 0 && ((v4 instanceof DelegatingNode))) {
                                    Node v6 = v4.getDelegate$ui();
                                    int v7 = 0;
                                    while(v6 != null) {
                                        if((v6.getKindSet$ui() & arg10) != 0) {
                                            ++v7;
                                            if(v7 == 1) {
                                                v4_1 = v6;
                                            }
                                            else {
                                                if(v5 == null) {
                                                    v5 = new MutableVector(new Node[v0], 0);
                                                }

                                                if(v4_1 != null) {
                                                    if(v5 != null) {
                                                        v5.add(v4_1);
                                                    }

                                                    v4 = v3;
                                                }

                                                if(v5 == null) {
                                                    goto label_82;
                                                }

                                                v5.add(v6);
                                            }
                                        }

                                    label_82:
                                        v6 = v6.getChild$ui();
                                    }

                                    if(v7 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_89;
                        }

                        v4_1 = DelegatableNodeKt.pop(v5);
                        goto label_41;
                    }

                label_89:
                    Node v2_1 = v2_1.getChild$ui();
                }
            }

            DelegatableNodeKt.addLayoutNodeChildren(v13, ((Node)v9), false);
        }
    }

    public static final void visitSubtreeIf(DelegatableNode arg3, int arg4, boolean arg5, Function1 arg6) {
        Object v3;
        if(!arg3.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        MutableVector v0 = new MutableVector(new Node[16], 0);
        Node v1 = arg3.getNode().getChild$ui();
        if(v1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0, arg3.getNode(), arg5);
        }
        else {
            v0.add(v1);
        }

        do {
        label_17:
            if(v0.getSize() == 0) {
                return;
            }

            v3 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v3).getAggregateChildKindSet$ui() & arg4) != 0) {
                Object v1_1 = v3;
                while(true) {
                label_26:
                    if(v1_1 != null && (((Node)v1_1).isAttached())) {
                        if((((Node)v1_1).getKindSet$ui() & arg4) != 0 && !arg6.invoke(v1_1).booleanValue()) {
                            goto label_17;
                        }

                        goto label_35;
                    }

                    goto label_37;
                }
            }

            goto label_37;
        }
        while(true);

    label_35:
        v1 = v1.getChild$ui();
        goto label_26;
    label_37:
        DelegatableNodeKt.addLayoutNodeChildren(v0, ((Node)v3), arg5);
        goto label_17;
    }

    public static final void visitSubtreeIf-Y-YKmho(DelegatableNode arg11, int arg12, boolean arg13, Function1 arg14) {
        Node v6_1;
        MutableVector v7;
        Object v6;
        Object v5;
        Object v11;
        if(!arg11.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v1 = 16;
        MutableVector v0 = new MutableVector(new Node[v1], 0);
        Node v2 = arg11.getNode().getChild$ui();
        if(v2 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v0, arg11.getNode(), arg13);
        }
        else {
            v0.add(v2);
        }

        while(true) {
        label_18:
            if(v0.getSize() == 0) {
                return;
            }

            v11 = v0.removeAt(v0.getSize() - 1);
            if((((Node)v11).getAggregateChildKindSet$ui() & arg12) != 0) {
                Object v4 = v11;
                while(true) {
                label_28:
                    if(v4 != null && (((Node)v4).isAttached())) {
                        if((((Node)v4).getKindSet$ui() & arg12) != 0) {
                            v5 = null;
                            v6 = v4;
                            v7 = ((MutableVector)v5);
                            while(true) {
                            label_38:
                                if(v6 != null) {
                                    Intrinsics.reifiedOperationMarker(3, "T");
                                    if(!(v6 instanceof Object)) {
                                        goto label_48;
                                    }
                                    else if(!arg14.invoke(v6).booleanValue()) {
                                        goto label_18;
                                    }

                                    goto label_85;
                                }

                                goto label_88;
                            }
                        }

                        goto label_88;
                    }

                    goto label_90;
                }
            }

            goto label_90;
        }

    label_48:
        if((((Node)v6).getKindSet$ui() & arg12) != 0 && ((v6 instanceof DelegatingNode))) {
            Node v8 = v6.getDelegate$ui();
            int v9 = 0;
            while(v8 != null) {
                if((v8.getKindSet$ui() & arg12) != 0) {
                    ++v9;
                    if(v9 == 1) {
                        v6_1 = v8;
                    }
                    else {
                        if(v7 == null) {
                            v7 = new MutableVector(new Node[v1], 0);
                        }

                        if(v6_1 != null) {
                            if(v7 != null) {
                                v7.add(v6_1);
                            }

                            v6 = v5;
                        }

                        if(v7 == null) {
                            goto label_81;
                        }

                        v7.add(v8);
                    }
                }

            label_81:
                v8 = v8.getChild$ui();
            }

            if(v9 != 1) {
                goto label_85;
            }

            goto label_38;
        }

    label_85:
        v6_1 = DelegatableNodeKt.pop(v7);
        goto label_38;
    label_88:
        Node v4_1 = v4_1.getChild$ui();
        goto label_28;
    label_90:
        DelegatableNodeKt.addLayoutNodeChildren(v0, ((Node)v11), arg13);
        goto label_18;
    }

    public static void visitSubtreeIf-Y-YKmho$default(DelegatableNode arg9, int arg10, boolean arg11, Function1 arg12, int arg13, Object arg14) {
        Node v4_1;
        MutableVector v5;
        Object v4;
        Object v3;
        Object v2;
        Object v9;
        if(!arg9.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }

        int v0 = 16;
        MutableVector v13 = new MutableVector(new Node[v0], 0);
        Node v1 = arg9.getNode().getChild$ui();
        if(v1 == null) {
            DelegatableNodeKt.addLayoutNodeChildren(v13, arg9.getNode(), false);
        }
        else {
            v13.add(v1);
        }

        while(true) {
        label_21:
            if(v13.getSize() == 0) {
                return;
            }

            v9 = v13.removeAt(v13.getSize() - 1);
            if((((Node)v9).getAggregateChildKindSet$ui() & arg10) != 0) {
                v2 = v9;
                while(true) {
                label_31:
                    if(v2 != null && (((Node)v2).isAttached())) {
                        if((((Node)v2).getKindSet$ui() & arg10) != 0) {
                            v3 = null;
                            v4 = v2;
                            v5 = ((MutableVector)v3);
                            while(true) {
                            label_41:
                                if(v4 != null) {
                                    Intrinsics.reifiedOperationMarker(3, "T");
                                    if(!(v4 instanceof Object)) {
                                        goto label_51;
                                    }
                                    else if(!arg12.invoke(v4).booleanValue()) {
                                        goto label_21;
                                    }

                                    goto label_88;
                                }

                                goto label_91;
                            }
                        }

                        goto label_91;
                    }

                    goto label_93;
                }
            }

            goto label_93;
        }

    label_51:
        if((((Node)v4).getKindSet$ui() & arg10) != 0 && ((v4 instanceof DelegatingNode))) {
            Node v6 = v4.getDelegate$ui();
            int v7 = 0;
            while(v6 != null) {
                if((v6.getKindSet$ui() & arg10) != 0) {
                    ++v7;
                    if(v7 == 1) {
                        v4_1 = v6;
                    }
                    else {
                        if(v5 == null) {
                            v5 = new MutableVector(new Node[v0], 0);
                        }

                        if(v4 != null) {
                            if(v5 != null) {
                                v5.add(v4);
                            }

                            v4 = v3;
                        }

                        if(v5 == null) {
                            goto label_84;
                        }

                        v5.add(v6);
                    }
                }

            label_84:
                v6 = v6.getChild$ui();
            }

            if(v7 != 1) {
                goto label_88;
            }

            goto label_41;
        }

    label_88:
        v4_1 = DelegatableNodeKt.pop(v5);
        goto label_41;
    label_91:
        Node v2_1 = ((Node)v2).getChild$ui();
        goto label_31;
    label_93:
        DelegatableNodeKt.addLayoutNodeChildren(v13, ((Node)v9), false);
        goto label_21;
    }
}

