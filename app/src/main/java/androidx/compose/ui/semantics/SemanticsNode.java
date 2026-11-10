package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010<\u001A\u00020(2\u0006\u0010=\u001A\u00020>H\u0002J\u000E\u0010A\u001A\u00020$2\u0006\u0010B\u001A\u00020CJ\u001E\u0010F\u001A\u00020G2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010J\u001A\u00020\tH\u0002J7\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00000L2\u000E\b\u0002\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00000I2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u0005H\u0000¢\u0006\u0002\bOJ\"\u0010P\u001A\u00020G*\u00020\u00072\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010N\u001A\u00020\u0005H\u0002J1\u0010S\u001A\b\u0012\u0004\u0012\u00020\u00000L2\b\b\u0002\u0010W\u001A\u00020\u00052\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u0005H\u0000¢\u0006\u0002\bXJ,\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00000L2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00000I2\u000E\b\u0002\u0010Q\u001A\b\u0012\u0004\u0012\u00020\u00000IH\u0002J2\u0010^\u001A\u00020G*\b\u0012\u0004\u0012\u00020\u00000I2\u0012\u0010_\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020G0`H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000F\u0010a\u001A\u0004\u0018\u00010bH\u0000¢\u0006\u0002\bcJ\n\u0010d\u001A\u0004\u0018\u00010eH\u0002J\u0016\u0010f\u001A\u00020G2\f\u0010H\u001A\b\u0012\u0004\u0012\u00020\u00000IH\u0002J0\u0010g\u001A\u00020\u00002\b\u0010h\u001A\u0004\u0018\u00010i2\u0017\u0010j\u001A\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020G0`¢\u0006\u0002\blH\u0002¢\u0006\u0002\bmJ\r\u0010n\u001A\u00020\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0006\u001A\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001A\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000F\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u000FR\u0011\u0010\u001B\u001A\u00020\u001C8F¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u0013\u0010\u001F\u001A\u0004\u0018\u00010 8F¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u0011\u0010#\u001A\u00020$¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\'\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b)\u0010*R\u0011\u0010+\u001A\u00020,8F¢\u0006\u0006\u001A\u0004\b-\u0010.R\u0011\u0010/\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b0\u0010*R\u0011\u00101\u001A\u0002028F¢\u0006\u0006\u001A\u0004\b3\u0010.R\u0011\u00104\u001A\u00020(8F¢\u0006\u0006\u001A\u0004\b5\u0010*R\u0011\u00106\u001A\u0002028F¢\u0006\u0006\u001A\u0004\b7\u0010.R\u0011\u00108\u001A\u0002028F¢\u0006\u0006\u001A\u0004\b9\u0010.R\u0014\u0010:\u001A\u00020(8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b;\u0010*R\u0014\u0010?\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b@\u0010\u000FR\u0011\u0010D\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\bE\u0010\u0013R\u0014\u0010K\u001A\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bK\u0010\u000FR\u0017\u0010R\u001A\b\u0012\u0004\u0012\u00020\u00000L8F¢\u0006\u0006\u001A\u0004\bS\u0010TR\u001A\u0010U\u001A\b\u0012\u0004\u0012\u00020\u00000L8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bV\u0010TR\u0011\u0010Y\u001A\u00020\u00058F¢\u0006\u0006\u001A\u0004\bY\u0010\u000FR\u0013\u0010Z\u001A\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001A\u0004\b[\u0010\\¨\u0006p"}, d2={"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<init>", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "getOuterSemanticsNode$ui", "()Landroidx/compose/ui/Modifier$Node;", "getMergingEnabled", "()Z", "getLayoutNode$ui", "()Landroidx/compose/ui/node/LayoutNode;", "getUnmergedConfig$ui", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isFake", "isFake$ui", "setFake$ui", "(Z)V", "fakeNodeParent", "isUnmergedLeafNode", "isUnmergedLeafNode$ui", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "id", "", "getId", "()I", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "boundsInRoot", "getBoundsInRoot", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "boundsInWindow", "getBoundsInWindow", "positionInWindow", "getPositionInWindow-F1C5BW0", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "boundsInParent", "getBoundsInParent$ui", "boundsInImportantForBoundsAncestor", "nodeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isTransparent", "isTransparent$ui", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "config", "getConfig", "mergeConfig", "", "unmergedChildren", "", "mergedConfig", "isMergingSemanticsOfDescendants", "", "includeFakeNodes", "includeDeactivatedNodes", "unmergedChildren$ui", "fillOneLayerOfSemanticsWrappers", "list", "children", "getChildren", "()Ljava/util/List;", "replacedChildren", "getReplacedChildren$ui", "includeReplacedSemantics", "getChildren$ui", "isRoot", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "findOneLayerOfMergingSemanticsNodes", "forEachUnmergedChild", "block", "Lkotlin/Function1;", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui", "findSemanticsModifierNodeToGetBounds", "Landroidx/compose/ui/node/SemanticsModifierNode;", "emitFakeNodes", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "copyWithMergingEnabled", "copyWithMergingEnabled$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    static {
    }

    public SemanticsNode(Node arg1, boolean arg2, LayoutNode arg3, SemanticsConfiguration arg4) {
        super();
        this.outerSemanticsNode = arg1;
        this.mergingEnabled = arg2;
        this.layoutNode = arg3;
        this.unmergedConfig = arg4;
        this.id = arg3.getSemanticsId();
    }

    private final Rect boundsInImportantForBoundsAncestor(LayoutCoordinates arg12) {
        Node v3;
        this = this.getParent();
        if(this == null) {
            return Rect.Companion.getZero();
        }

        NodeChain v0 = this.layoutNode.getNodes$ui();
        int v1 = 8;
        int v2 = NodeKind.constructor-impl(v1);
        Node v5 = null;
        if((v0.getAggregateChildKindSet() & v2) != 0) {
            Node v0_1 = v0.getHead$ui();
            while(true) {
                if(v0_1 != null) {
                    if((v0_1.getKindSet$ui() & v2) != 0) {
                        v3 = v0_1;
                        MutableVector v6 = ((MutableVector)v5);
                        while(true) {
                        label_21:
                            if(v3 != null) {
                                if((v3 instanceof SemanticsModifierNode)) {
                                    if(v3.isImportantForBounds()) {
                                        goto label_68;
                                    }
                                }
                                else if((v3.getKindSet$ui() & v2) != 0 && ((v3 instanceof DelegatingNode))) {
                                    Node v7 = v3.getDelegate$ui();
                                    int v8 = 0;
                                    while(v7 != null) {
                                        if((v7.getKindSet$ui() & v2) != 0) {
                                            ++v8;
                                            if(v8 == 1) {
                                                v3 = v7;
                                            }
                                            else {
                                                if(v6 == null) {
                                                    v6 = new MutableVector(new Node[16], 0);
                                                }

                                                if(v3 != null) {
                                                    if(v6 != null) {
                                                        v6.add(v3);
                                                    }

                                                    v3 = v5;
                                                }

                                                if(v6 == null) {
                                                    goto label_56;
                                                }

                                                v6.add(v7);
                                            }
                                        }

                                    label_56:
                                        v7 = v7.getChild$ui();
                                    }

                                    if(v8 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }

                            goto label_62;
                        }

                        v3 = DelegatableNodeKt.pop(v6);
                        goto label_21;
                    }

                label_62:
                    if((v0_1.getAggregateChildKindSet$ui() & v2) == 0) {
                        goto label_67;
                    }

                    v0_1 = v0_1.getChild$ui();
                    continue;
                }
                else {
                    goto label_67;
                }
            }
        }
        else {
        label_67:
            v3 = v5;
        }

    label_68:
        NodeCoordinator v0_2 = v3 != null ? DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)v3), NodeKind.constructor-impl(v1)) : ((NodeCoordinator)v5);
        if(v0_2 == null) {
            return this.boundsInImportantForBoundsAncestor(arg12);
        }

        return LayoutCoordinates.localBoundingBoxOf$default(((LayoutCoordinates)v0_2), arg12, false, 2, v5);
    }

    public final SemanticsNode copyWithMergingEnabled$ui() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    private final void emitFakeNodes(List arg4) {
        Role v0 = SemanticsNodeKt.access$getRole(this);
        if(v0 != null && (this.unmergedConfig.isMergingSemanticsOfDescendants()) && !arg4.isEmpty()) {
            arg4.add(this.fakeSemanticsNode-ypyhhiA(v0, new SemanticsNode$emitFakeNodes$fakeNode$1(v0)));
        }

        if((this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription())) && !arg4.isEmpty() && (this.unmergedConfig.isMergingSemanticsOfDescendants())) {
            Object v0_1 = SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            Role v1 = null;
            v0_1 = v0_1 != null ? CollectionsKt.firstOrNull(((List)v0_1)) : v1;
            if(v0_1 == null) {
                return;
            }

            arg4.add(0, this.fakeSemanticsNode-ypyhhiA(v1, new SemanticsNode$emitFakeNodes$fakeNode$2(((String)v0_1))));
        }
    }

    private final SemanticsNode fakeSemanticsNode-ypyhhiA(Role arg6, Function1 arg7) {
        SemanticsConfiguration v0 = new SemanticsConfiguration();
        v0.setMergingSemanticsOfDescendants(false);
        v0.setClearingSemantics(false);
        arg7.invoke(v0);
        SemanticsNode$fakeSemanticsNode$fakeNode$1 v3 = new SemanticsNode$fakeSemanticsNode$fakeNode$1(arg7);
        int v6 = arg6 != null ? SemanticsNodeKt.access$roleFakeNodeId(this) : SemanticsNodeKt.access$contentDescriptionFakeNodeId(this);
        SemanticsNode v2 = new SemanticsNode(((Node)v3), false, new LayoutNode(true, v6), v0);
        v2.isFake = true;
        v2.fakeNodeParent = this;
        return v2;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode arg6, List arg7, boolean arg8) {
        MutableVector v6 = arg6.getZSortedChildren();
        Object[] v0 = v6.content;
        int v6_1 = v6.getSize();
        int v1;
        for(v1 = 0; v1 < v6_1; ++v1) {
            Object v2 = v0[v1];
            if((((LayoutNode)v2).isAttached()) && ((arg8) || !((LayoutNode)v2).isDeactivated())) {
                if(((LayoutNode)v2).getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(8))) {
                    arg7.add(SemanticsNodeKt.SemanticsNode(((LayoutNode)v2), this.mergingEnabled));
                    goto label_21;
                }

                this.fillOneLayerOfSemanticsWrappers(((LayoutNode)v2), arg7, arg8);
            }

        label_21:
        }
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui() {
        if(this.isFake) {
            this = this.getParent();
            if(this != null) {
                return this.findCoordinatorToGetBounds$ui();
            }

            return null;
        }

        SemanticsModifierNode v0 = this.findSemanticsModifierNodeToGetBounds();
        if(v0 != null) {
            NodeCoordinator v0_1 = DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)v0), NodeKind.constructor-impl(8));
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        return this.layoutNode.getInnerCoordinator$ui();
    }

    private final List findOneLayerOfMergingSemanticsNodes(List arg8, List arg9) {
        int v0 = arg8.size();
        List v2 = arg8;
        SemanticsNode.unmergedChildren$ui$default(this, v2, false, false, 6, null);
        int v7 = v2.size();
        while(v0 < v7) {
            Object v8 = v2.get(v0);
            if(((SemanticsNode)v8).isMergingSemanticsOfDescendants()) {
                arg9.add(v8);
            }
            else if(!((SemanticsNode)v8).unmergedConfig.isClearingSemantics()) {
                ((SemanticsNode)v8).findOneLayerOfMergingSemanticsNodes(v2, arg9);
            }

            ++v0;
        }

        return arg9;
    }

    static List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode arg0, List arg1, List arg2, int arg3, Object arg4) {
        ArrayList v2;
        if((arg3 & 2) != 0) {
            v2 = new ArrayList();
        }

        return arg0.findOneLayerOfMergingSemanticsNodes(arg1, ((List)v2));
    }

    private final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        Node v2_1;
        Node v11_2;
        int v0_1;
        NodeChain v11_1;
        boolean v0 = this.unmergedConfig.isMergingSemanticsOfDescendants();
        LayoutNode v11 = this.layoutNode;
        int v1 = 16;
        int v2 = 8;
        Node v5 = null;
        if(v0) {
            v11_1 = v11.getNodes$ui();
            v0_1 = NodeKind.constructor-impl(v2);
            if((v11_1.getAggregateChildKindSet() & v0_1) != 0) {
                v11_2 = v11_1.getHead$ui();
                v2_1 = v5;
                while(true) {
                    if(v11_2 != null) {
                        if((v11_2.getKindSet$ui() & v0_1) != 0) {
                            Node v6 = v11_2;
                            MutableVector v7 = ((MutableVector)v5);
                            while(true) {
                            label_22:
                                if(v6 != null) {
                                    if((v6 instanceof SemanticsModifierNode)) {
                                        if(((SemanticsModifierNode)v6).isImportantForBounds()) {
                                            if(((SemanticsModifierNode)v6).getShouldMergeDescendantSemantics()) {
                                                return ((SemanticsModifierNode)v6);
                                            }
                                            else if(v2_1 == null) {
                                                v2_1 = v6;
                                            }
                                        }
                                    }
                                    else if((v6.getKindSet$ui() & v0_1) != 0 && ((v6 instanceof DelegatingNode))) {
                                        Node v8 = v6.getDelegate$ui();
                                        int v9 = 0;
                                        while(v8 != null) {
                                            if((v8.getKindSet$ui() & v0_1) != 0) {
                                                ++v9;
                                                if(v9 == 1) {
                                                    v6 = v8;
                                                }
                                                else {
                                                    if(v7 == null) {
                                                        v7 = new MutableVector(new Node[v1], 0);
                                                    }

                                                    if(v6 != null) {
                                                        if(v7 != null) {
                                                            v7.add(v6);
                                                        }

                                                        v6 = v5;
                                                    }

                                                    if(v7 == null) {
                                                        goto label_59;
                                                    }

                                                    v7.add(v8);
                                                }
                                            }

                                        label_59:
                                            v8 = v8.getChild$ui();
                                        }

                                        if(v9 != 1) {
                                            break;
                                        }

                                        continue;
                                    }

                                    break;
                                }

                                goto label_65;
                            }

                            v6 = DelegatableNodeKt.pop(v7);
                            goto label_22;
                        }

                    label_65:
                        if((v11_2.getAggregateChildKindSet$ui() & v0_1) == 0) {
                            goto label_70;
                        }

                        v11_2 = v11_2.getChild$ui();
                        continue;
                    }
                    else {
                        goto label_70;
                    }
                }
            }
        }
        else {
            v11_1 = v11.getNodes$ui();
            v0_1 = NodeKind.constructor-impl(v2);
            if((v11_1.getAggregateChildKindSet() & v0_1) == 0) {
                goto label_128;
            }

            for(v11_2 = v11_1.getHead$ui(); true; v11_2 = v11_2.getChild$ui()) {
                if(v11_2 == null) {
                    goto label_128;
                }

                if((v11_2.getKindSet$ui() & v0_1) != 0) {
                    v2_1 = v11_2;
                    MutableVector v6_1 = ((MutableVector)v5);
                    while(true) {
                    label_84:
                        if(v2_1 != null) {
                            if((v2_1 instanceof SemanticsModifierNode)) {
                                if(v2_1.isImportantForBounds()) {
                                    goto label_70;
                                }
                            }
                            else if((v2_1.getKindSet$ui() & v0_1) != 0 && ((v2_1 instanceof DelegatingNode))) {
                                Node v7_1 = v2_1.getDelegate$ui();
                                int v8_1 = 0;
                                while(v7_1 != null) {
                                    if((v7_1.getKindSet$ui() & v0_1) != 0) {
                                        ++v8_1;
                                        if(v8_1 == 1) {
                                            v2_1 = v7_1;
                                        }
                                        else {
                                            if(v6_1 == null) {
                                                v6_1 = new MutableVector(new Node[v1], 0);
                                            }

                                            if(v2_1 != null) {
                                                if(v6_1 != null) {
                                                    v6_1.add(v2_1);
                                                }

                                                v2_1 = v5;
                                            }

                                            if(v6_1 == null) {
                                                goto label_117;
                                            }

                                            v6_1.add(v7_1);
                                        }
                                    }

                                label_117:
                                    v7_1 = v7_1.getChild$ui();
                                }

                                if(v8_1 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_123;
                    }

                    v2_1 = DelegatableNodeKt.pop(v6_1);
                    goto label_84;
                }

            label_123:
                if((v11_2.getAggregateChildKindSet$ui() & v0_1) == 0) {
                    goto label_128;
                }
            }

        label_70:
            v5 = v2_1;
        }

    label_128:
        return ((SemanticsModifierNode)v5);
    }

    private final void forEachUnmergedChild(List arg8, Function1 arg9) {
        int v0 = arg8.size();
        List v2 = arg8;
        SemanticsNode.unmergedChildren$ui$default(this, v2, false, false, 6, null);
        int v7 = v2.size();
        while(v0 < v7) {
            arg9.invoke(v2.get(v0));
            ++v0;
        }
    }

    public final int getAlignmentLinePosition(AlignmentLine arg1) {
        NodeCoordinator v0 = this.findCoordinatorToGetBounds$ui();
        if(v0 != null) {
            return v0.get(arg1);
        }

        return 0x80000000;
    }

    public final Rect getBoundsInParent$ui() {
        NodeCoordinator v0 = this.findCoordinatorToGetBounds$ui();
        if(v0 != null) {
            if(v0.isAttached()) {
            }
            else {
                v0 = null;
            }

            if(v0 == null) {
                goto label_12;
            }

            LayoutCoordinates v0_1 = v0.getCoordinates();
            if(v0_1 == null) {
                goto label_12;
            }

            return this.boundsInImportantForBoundsAncestor(v0_1);
        }

    label_12:
        return Rect.Companion.getZero();
    }

    public final Rect getBoundsInRoot() {
        NodeCoordinator v1 = this.findCoordinatorToGetBounds$ui();
        if(v1 != null) {
            if(v1.isAttached()) {
            }
            else {
                v1 = null;
            }

            if(v1 == null) {
                goto label_11;
            }

            Rect v1_1 = LayoutCoordinatesKt.boundsInRoot(((LayoutCoordinates)v1));
            if(v1_1 == null) {
                goto label_11;
            }

            return v1_1;
        }

    label_11:
        return Rect.Companion.getZero();
    }

    public final Rect getBoundsInWindow() {
        NodeCoordinator v3 = this.findCoordinatorToGetBounds$ui();
        if(v3 != null) {
            Object v1 = null;
            if(v3.isAttached()) {
            }
            else {
                v3 = ((NodeCoordinator)v1);
            }

            if(v3 == null) {
                goto label_14;
            }

            Rect v3_1 = LayoutCoordinatesKt.boundsInWindow$default(((LayoutCoordinates)v3), false, 1, v1);
            if(v3_1 == null) {
                goto label_14;
            }

            return v3_1;
        }

    label_14:
        return Rect.Companion.getZero();
    }

    public final List getChildren() {
        return SemanticsNode.getChildren$ui$default(this, false, false, false, 7, null);
    }

    public final List getChildren$ui(boolean arg2, boolean arg3, boolean arg4) {
        if(!arg2 && (this.unmergedConfig.isClearingSemantics())) {
            return CollectionsKt.emptyList();
        }

        ArrayList v2 = new ArrayList();
        if(this.isMergingSemanticsOfDescendants()) {
            return SemanticsNode.findOneLayerOfMergingSemanticsNodes$default(this, ((List)v2), null, 2, null);
        }

        return this.unmergedChildren$ui(((List)v2), arg3, arg4);
    }

    public static List getChildren$ui$default(SemanticsNode arg1, boolean arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        int v2;
        if((arg5 & 1) != 0) {
            v2 = arg1.mergingEnabled ^ 1;
        }

        return arg1.getChildren$ui(((boolean)v2), false, false);
    }

    public final SemanticsConfiguration getConfig() {
        boolean v0 = this.isMergingSemanticsOfDescendants();
        SemanticsConfiguration v1 = this.unmergedConfig;
        if(v0) {
            SemanticsConfiguration v0_1 = v1.copy();
            this.mergeConfig(new ArrayList(), v0_1);
            return v0_1;
        }

        return v1;
    }

    public final int getId() {
        return this.id;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final LayoutNode getLayoutNode$ui() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final Node getOuterSemanticsNode$ui() {
        return this.outerSemanticsNode;
    }

    public final SemanticsNode getParent() {
        LayoutNode v0_1;
        SemanticsNode v0 = this.fakeNodeParent;
        if(v0 != null) {
            return v0;
        }

        SemanticsNode v1 = null;
        if(this.mergingEnabled) {
            v0_1 = this.layoutNode.getParent$ui();
            while(true) {
                if(v0_1 != null) {
                    SemanticsConfiguration v2 = v0_1.getSemanticsConfiguration();
                    if(v2 != null && (v2.isMergingSemanticsOfDescendants())) {
                        break;
                    }

                    v0_1 = v0_1.getParent$ui();
                    continue;
                }
                else {
                    goto label_17;
                }
            }
        }
        else {
        label_17:
            v0_1 = ((LayoutNode)v1);
        }

        if(v0_1 == null) {
            v0_1 = this.layoutNode.getParent$ui();
            while(true) {
                if(v0_1 == null) {
                    break;
                }
                else if(v0_1.getNodes$ui().has-H91voCI$ui(NodeKind.constructor-impl(8))) {
                }
                else {
                    v0_1 = v0_1.getParent$ui();
                    continue;
                }

                goto label_31;
            }

            v0_1 = ((LayoutNode)v1);
        }

    label_31:
        if(v0_1 == null) {
            return v1;
        }

        return SemanticsNodeKt.SemanticsNode(v0_1, this.mergingEnabled);
    }

    public final long getPositionInRoot-F1C5BW0() {
        NodeCoordinator v2 = this.findCoordinatorToGetBounds$ui();
        if(v2 != null) {
            if(v2.isAttached()) {
            }
            else {
                v2 = null;
            }

            if(v2 == null) {
                goto label_9;
            }

            return LayoutCoordinatesKt.positionInRoot(((LayoutCoordinates)v2));
        }

    label_9:
        return Offset.Companion.getZero-F1C5BW0();
    }

    public final long getPositionInWindow-F1C5BW0() {
        NodeCoordinator v2 = this.findCoordinatorToGetBounds$ui();
        if(v2 != null) {
            if(v2.isAttached()) {
            }
            else {
                v2 = null;
            }

            if(v2 == null) {
                goto label_9;
            }

            return LayoutCoordinatesKt.positionInWindow(((LayoutCoordinates)v2));
        }

    label_9:
        return Offset.Companion.getZero-F1C5BW0();
    }

    public final long getPositionOnScreen-F1C5BW0() {
        NodeCoordinator v2 = this.findCoordinatorToGetBounds$ui();
        if(v2 != null) {
            if(v2.isAttached()) {
            }
            else {
                v2 = null;
            }

            if(v2 == null) {
                goto label_9;
            }

            return LayoutCoordinatesKt.positionOnScreen(((LayoutCoordinates)v2));
        }

    label_9:
        return Offset.Companion.getZero-F1C5BW0();
    }

    public final List getReplacedChildren$ui() {
        return SemanticsNode.getChildren$ui$default(this, false, true, false, 4, null);
    }

    public final RootForTest getRoot() {
        Owner v0 = this.layoutNode.getOwner$ui();
        if(v0 != null) {
            return v0.getRootForTest();
        }

        return null;
    }

    public final long getSize-YbymL2g() {
        NodeCoordinator v2 = this.findCoordinatorToGetBounds$ui();
        if(v2 != null) {
            return v2.getSize-YbymL2g();
        }

        return IntSize.Companion.getZero-YbymL2g();
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode v0 = this.findSemanticsModifierNodeToGetBounds();
        if(v0 == null) {
            return this.layoutNode.getInnerCoordinator$ui().touchBoundsInRoot();
        }

        return SemanticsModifierNodeKt.touchBoundsInRoot(v0.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    public final SemanticsConfiguration getUnmergedConfig$ui() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui() {
        return this.isFake;
    }

    private final boolean isMergingSemanticsOfDescendants() {
        if((this.mergingEnabled) && (this.unmergedConfig.isMergingSemanticsOfDescendants())) {
            return 1;
        }

        return 0;
    }

    public final boolean isRoot() {
        if(this.getParent() == null) {
            return 1;
        }

        return 0;
    }

    public final boolean isTransparent$ui() {
        NodeCoordinator v0 = this.findCoordinatorToGetBounds$ui();
        if(v0 != null) {
            return v0.isTransparent();
        }

        return 0;
    }

    public final boolean isUnmergedLeafNode$ui() {
        if(!this.isFake && (this.getReplacedChildren$ui().isEmpty())) {
            LayoutNode v2;
            for(v2 = this.layoutNode.getParent$ui(); v2 != null; v2 = v2.getParent$ui()) {
                SemanticsConfiguration v1 = v2.getSemanticsConfiguration();
                if(v1 != null && (v1.isMergingSemanticsOfDescendants())) {
                    goto label_17;
                }
            }

            v2 = null;
        label_17:
            if(v2 != null) {
                return 0;
            }

            return 1;
        }

        return 0;
    }

    private final void mergeConfig(List arg8, SemanticsConfiguration arg9) {
        if(!this.unmergedConfig.isClearingSemantics()) {
            int v0 = arg8.size();
            List v2 = arg8;
            SemanticsNode.unmergedChildren$ui$default(this, v2, false, false, 6, null);
            int v7 = v2.size();
            while(v0 < v7) {
                Object v8 = v2.get(v0);
                if(!((SemanticsNode)v8).isMergingSemanticsOfDescendants()) {
                    arg9.mergeChild$ui(((SemanticsNode)v8).unmergedConfig);
                    ((SemanticsNode)v8).mergeConfig(v2, arg9);
                }

                ++v0;
            }
        }
    }

    public final void setFake$ui(boolean arg1) {
        this.isFake = arg1;
    }

    public final List unmergedChildren$ui(List arg2, boolean arg3, boolean arg4) {
        if(this.isFake) {
            return CollectionsKt.emptyList();
        }

        this.fillOneLayerOfSemanticsWrappers(this.layoutNode, arg2, arg4);
        if(arg3) {
            this.emitFakeNodes(arg2);
        }

        return arg2;
    }

    public static List unmergedChildren$ui$default(SemanticsNode arg1, List arg2, boolean arg3, boolean arg4, int arg5, Object arg6) {
        ArrayList v2;
        if((arg5 & 1) != 0) {
            v2 = new ArrayList();
        }

        return arg1.unmergedChildren$ui(((List)v2), false, false);
    }
}

