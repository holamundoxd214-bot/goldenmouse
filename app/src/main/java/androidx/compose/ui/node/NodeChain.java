package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000E\n\u0002\b\u0003*\u0001\t\b\u0001\u0018\u00002\u00020\u0001:\u0002pqB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010,\u001A\u00020-2\b\u0010*\u001A\u0004\u0018\u00010+H\u0000¢\u0006\u0002\b.J\b\u0010/\u001A\u00020\u0015H\u0002J\u0010\u00100\u001A\u00020\u00152\u0006\u00101\u001A\u00020\u0015H\u0002J\u0015\u00102\u001A\u00020-2\u0006\u00103\u001A\u00020\'H\u0000¢\u0006\u0002\b4J\r\u00105\u001A\u00020-H\u0000¢\u0006\u0002\b6J\u0006\u00107\u001A\u00020-J\b\u00108\u001A\u00020-H\u0002J\u0006\u00109\u001A\u00020-J\u0006\u0010:\u001A\u00020-J\f\u0010;\u001A\b\u0012\u0004\u0012\u00020=0<J\r\u0010>\u001A\u00020-H\u0000¢\u0006\u0002\b?J\r\u0010@\u001A\u00020-H\u0000¢\u0006\u0002\bAJ@\u0010B\u001A\u00060)R\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u00152\u0006\u0010C\u001A\u00020\u001F2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020$0#2\f\u0010E\u001A\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010F\u001A\u00020\u001BH\u0002J\u0018\u0010G\u001A\u00020-2\u0006\u0010H\u001A\u00020\u00152\u0006\u0010I\u001A\u00020\u0010H\u0002J<\u0010J\u001A\u00020-2\u0006\u0010C\u001A\u00020\u001F2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020$0#2\f\u0010E\u001A\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010F\u001A\u00020\u001BH\u0002J\u0010\u0010K\u001A\u00020\u00152\u0006\u0010L\u001A\u00020\u0015H\u0002J\u0010\u0010M\u001A\u00020\u00152\u0006\u0010L\u001A\u00020\u0015H\u0002J\u0018\u0010N\u001A\u00020\u00152\u0006\u0010O\u001A\u00020$2\u0006\u0010P\u001A\u00020\u0015H\u0002J\u0018\u0010Q\u001A\u00020\u00152\u0006\u0010L\u001A\u00020\u00152\u0006\u0010P\u001A\u00020\u0015H\u0002J \u0010R\u001A\u00020-2\u0006\u0010S\u001A\u00020$2\u0006\u0010T\u001A\u00020$2\u0006\u0010L\u001A\u00020\u0015H\u0002J<\u0010U\u001A\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020\u001B0ZH\u0080\b¢\u0006\u0004\b[\u0010\\J:\u0010]\u001A\u00020-\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0004\b^\u0010_J*\u0010]\u001A\u00020-2\u0006\u0010`\u001A\u00020\u001F2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\baJ\"\u0010]\u001A\u00020-2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\baJ\"\u0010b\u001A\u00020-2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bcJ:\u0010d\u001A\u00020-\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u0002HV0X2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0004\be\u0010_J*\u0010d\u001A\u00020-2\u0006\u0010`\u001A\u00020\u001F2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bfJ\"\u0010d\u001A\u00020-2\u0012\u0010Y\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020-0ZH\u0080\b¢\u0006\u0002\bfJ(\u0010\u0014\u001A\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u0002HV0XH\u0080\b¢\u0006\u0004\bg\u0010hJ(\u0010\u0018\u001A\u0004\u0018\u0001HV\"\u0006\b\u0000\u0010V\u0018\u00012\f\u0010W\u001A\b\u0012\u0004\u0012\u0002HV0XH\u0080\b¢\u0006\u0004\bi\u0010hJ\u001B\u0010j\u001A\u00020\u001B2\n\u0010W\u001A\u0006\u0012\u0002\b\u00030XH\u0000¢\u0006\u0004\bk\u0010lJ\u0015\u0010j\u001A\u00020\u001B2\u0006\u0010`\u001A\u00020\u001FH\u0000¢\u0006\u0002\bmJ\b\u0010n\u001A\u00020oH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000B\u001A\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001E\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001E\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u000F\u001A\u00020\u0015@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u001B8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u001F8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u0016\u0010\"\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010%\u001A\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010&\u001A\b\u0012\u0004\u0012\u00020\'0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001A\b\u0018\u00010)R\u00020\u0000X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010*\u001A\u0004\u0018\u00010+X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006r"}, d2={"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "sentinelHead", "androidx/compose/ui/node/NodeChain$sentinelHead$1", "Landroidx/compose/ui/node/NodeChain$sentinelHead$1;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "value", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail$ui", "()Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui", "isUpdating", "", "isUpdating$ui", "()Z", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "current", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "buffer", "stack", "Landroidx/compose/ui/Modifier;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "useLogger", "", "useLogger$ui", "padChain", "trimChain", "paddedHead", "updateFrom", "m", "updateFrom$ui", "resetState", "resetState$ui", "syncCoordinators", "syncAggregateChildKindSet", "markAsAttached", "runAttachLifecycle", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "markAsDetached", "markAsDetached$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "getDiffer", "offset", "before", "after", "shouldAttachOnInsert", "propagateCoordinator", "start", "coordinator", "structuralUpdate", "detachAndRemoveNode", "node", "removeNode", "createAndInsertNodeAsChild", "element", "parent", "insertChild", "updateNode", "prev", "next", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "headToTail", "headToTail-aLcG6gQ$ui", "(ILkotlin/jvm/functions/Function1;)V", "mask", "headToTail$ui", "headToTailExclusive", "headToTailExclusive$ui", "tailToHead", "tailToHead-aLcG6gQ$ui", "tailToHead$ui", "tail-H91voCI$ui", "(I)Ljava/lang/Object;", "head-H91voCI$ui", "has", "has-H91voCI$ui", "(I)Z", "has$ui", "toString", "", "Differ", "Logger", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NodeChain {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010 \u001A\u00020\u000B2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0005H\u0016J\u0010\u0010#\u001A\u00020$2\u0006\u0010\"\u001A\u00020\u0005H\u0016J\u0018\u0010%\u001A\u00020$2\u0006\u0010&\u001A\u00020\u00052\u0006\u0010!\u001A\u00020\u0005H\u0016J\u0018\u0010\'\u001A\u00020$2\u0006\u0010!\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u0005H\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0017\"\u0004\b\u001B\u0010\u0019R\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006("}, d2={"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "offset", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "<init>", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getBefore", "()Landroidx/compose/runtime/collection/MutableVector;", "setBefore", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "setAfter", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class Differ implements DiffCallback {
        private MutableVector after;
        private MutableVector before;
        private Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(NodeChain arg1, Node arg2, int arg3, MutableVector arg4, MutableVector arg5, boolean arg6) {
            NodeChain.this = arg1;
            super();
            this.node = arg2;
            this.offset = arg3;
            this.before = arg4;
            this.after = arg5;
            this.shouldAttachOnInsert = arg6;
        }

        public boolean areItemsTheSame(int arg3, int arg4) {
            if(NodeChainKt.actionForModifiers(this.before.content[this.offset + arg3], this.after.content[this.offset + arg4]) != 0) {
                return 1;
            }

            return 0;
        }

        public final MutableVector getAfter() {
            return this.after;
        }

        public final MutableVector getBefore() {
            return this.before;
        }

        public final Node getNode() {
            return this.node;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public void insert(int arg8) {
            int v2 = this.offset + arg8;
            Node v5 = this.node;
            this.node = NodeChain.this.createAndInsertNodeAsChild(this.after.content[v2], v5);
            Logger v1 = NodeChain.this.logger;
            if(v1 != null) {
                v1.nodeInserted(v2, v2, this.after.content[v2], v5, this.node);
            }

            boolean v8 = this.shouldAttachOnInsert;
            Node v0 = this.node;
            if(v8) {
                Node v8_1 = v0.getChild$ui();
                Intrinsics.checkNotNull(v8_1);
                NodeCoordinator v8_2 = v8_1.getCoordinator$ui();
                Intrinsics.checkNotNull(v8_2);
                LayoutModifierNode v0_1 = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if(v0_1 != null) {
                    LayoutModifierNodeCoordinator v1_1 = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), v0_1);
                    this.node.updateCoordinator$ui(v1_1);
                    NodeChain.this.propagateCoordinator(this.node, v1_1);
                    v1_1.setWrappedBy$ui(v8_2.getWrappedBy$ui());
                    v1_1.setWrapped$ui(v8_2);
                    v8_2.setWrappedBy$ui(v1_1);
                }
                else {
                    this.node.updateCoordinator$ui(v8_2);
                }

                this.node.markAsAttached$ui();
                this.node.runAttachLifecycle$ui();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }

            v0.setInsertedNodeAwaitingAttachForInvalidation$ui(true);
        }

        public void remove(int arg4, int arg5) {
            Node v4 = this.node.getChild$ui();
            Intrinsics.checkNotNull(v4);
            Logger v0 = NodeChain.this.logger;
            if(v0 != null) {
                v0.nodeRemoved(arg5, this.before.content[this.offset + arg5], v4);
            }

            if((NodeKind.constructor-impl(2) & v4.getKindSet$ui()) != 0) {
                NodeCoordinator v5 = v4.getCoordinator$ui();
                Intrinsics.checkNotNull(v5);
                NodeCoordinator v0_1 = v5.getWrappedBy$ui();
                v5 = v5.getWrapped$ui();
                Intrinsics.checkNotNull(v5);
                if(v0_1 != null) {
                    v0_1.setWrapped$ui(v5);
                }

                v5.setWrappedBy$ui(v0_1);
                NodeChain.this.propagateCoordinator(this.node, v5);
            }

            this.node = NodeChain.this.detachAndRemoveNode(v4);
        }

        public void same(int arg8, int arg9) {
            Logger v1_1;
            Node v0 = this.node.getChild$ui();
            Intrinsics.checkNotNull(v0);
            this.node = v0;
            Object v4 = this.before.content[this.offset + arg8];
            Object v5 = this.after.content[this.offset + arg9];
            boolean v0_1 = Intrinsics.areEqual(v4, v5);
            NodeChain v1 = NodeChain.this;
            if(!v0_1) {
                v1.updateNode(((Element)v4), ((Element)v5), this.node);
                v1_1 = NodeChain.this.logger;
                if(v1_1 != null) {
                    v1_1.nodeUpdated(this.offset + arg8, this.offset + arg9, ((Element)v4), ((Element)v5), this.node);
                    return;
                }
            }
            else {
                v1_1 = v1.logger;
                if(v1_1 != null) {
                    v1_1.nodeReused(this.offset + arg8, this.offset + arg9, ((Element)v4), ((Element)v5), this.node);
                }
            }
        }

        public final void setAfter(MutableVector arg1) {
            this.after = arg1;
        }

        public final void setBefore(MutableVector arg1) {
            this.before = arg1;
        }

        public final void setNode(Node arg1) {
            this.node = arg1;
        }

        public final void setOffset(int arg1) {
            this.offset = arg1;
        }

        public final void setShouldAttachOnInsert(boolean arg1) {
            this.shouldAttachOnInsert = arg1;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH&J0\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH&J0\u0010\u000E\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH&J0\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\nH&J \u0010\u0014\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2={"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeUpdated", "oldIndex", "newIndex", "nodeReused", "nodeInserted", "atIndex", "element", "child", "inserted", "nodeRemoved", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Logger {
        void linearDiffAborted(int arg1, Element arg2, Element arg3, Node arg4);

        void nodeInserted(int arg1, int arg2, Element arg3, Node arg4, Node arg5);

        void nodeRemoved(int arg1, Element arg2, Node arg3);

        void nodeReused(int arg1, int arg2, Element arg3, Element arg4, Node arg5);

        void nodeUpdated(int arg1, int arg2, Element arg3, Element arg4, Node arg5);
    }

    public static final int $stable = 8;
    private MutableVector buffer;
    private Differ cachedDiffer;
    private MutableVector current;
    private Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final NodeChain$sentinelHead$1 sentinelHead;
    private final MutableVector stack;
    private final Node tail;

    static {
    }

    public NodeChain(LayoutNode arg3) {
        super();
        this.layoutNode = arg3;
        NodeChain$sentinelHead$1 v0 = new NodeChain$sentinelHead$1();
        v0.setAggregateChildKindSet$ui(-1);
        this.sentinelHead = v0;
        InnerNodeCoordinator v0_1 = new InnerNodeCoordinator(arg3);
        this.innerCoordinator = v0_1;
        this.outerCoordinator = v0_1;
        TailModifierNode v3 = v0_1.getTail();
        this.tail = ((Node)v3);
        this.head = ((Node)v3);
        this.stack = new MutableVector(new Modifier[16], 0);
    }

    public static final Node access$createAndInsertNodeAsChild(NodeChain arg0, Element arg1, Node arg2) {
        return arg0.createAndInsertNodeAsChild(arg1, arg2);
    }

    public static final Node access$detachAndRemoveNode(NodeChain arg0, Node arg1) {
        return arg0.detachAndRemoveNode(arg1);
    }

    public static final int access$getAggregateChildKindSet(NodeChain arg0) {
        return arg0.getAggregateChildKindSet();
    }

    public static final Logger access$getLogger$p(NodeChain arg0) {
        return arg0.logger;
    }

    public static final void access$propagateCoordinator(NodeChain arg0, Node arg1, NodeCoordinator arg2) {
        arg0.propagateCoordinator(arg1, arg2);
    }

    public static final void access$updateNode(NodeChain arg0, Element arg1, Element arg2, Node arg3) {
        arg0.updateNode(arg1, arg2, arg3);
    }

    private final Node createAndInsertNodeAsChild(Element arg2, Node arg3) {
        BackwardsCompatNode v2_1;
        if((arg2 instanceof ModifierNodeElement)) {
            Node v2 = ((ModifierNodeElement)arg2).create();
            v2.setKindSet$ui(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(v2));
        }
        else {
            v2_1 = new BackwardsCompatNode(arg2);
        }

        if(((Node)v2_1).isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ");
        }

        ((Node)v2_1).setInsertedNodeAwaitingAttachForInvalidation$ui(true);
        return this.insertChild(((Node)v2_1), arg3);
    }

    private final Node detachAndRemoveNode(Node arg2) {
        if(arg2.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(arg2);
            arg2.runDetachLifecycle$ui();
            arg2.markAsDetached$ui();
        }

        return this.removeNode(arg2);
    }

    public final Object firstFromHead-aLcG6gQ$ui(int arg9, Function1 arg10) {
        Node v1 = null;
        if((this.getAggregateChildKindSet() & arg9) != 0) {
            Node v8;
            for(v8 = this.getHead$ui(); v8 != null; v8 = v8.getChild$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = v8;
                    MutableVector v2 = ((MutableVector)v1);
                    while(true) {
                    label_13:
                        if(v0 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v0 instanceof Object)) {
                                if(arg10.invoke(v0).booleanValue()) {
                                    return v0;
                                }
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
                                                goto label_59;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_59:
                                    v3 = v3.getChild$ui();
                                }

                                if(v5 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_66;
                    }

                    v0 = DelegatableNodeKt.pop(v2);
                    goto label_13;
                }

            label_66:
                if((v8.getAggregateChildKindSet$ui() & arg9) == 0) {
                    return v1;
                }
            }
        }

        return v1;
    }

    private final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui();
    }

    private final Differ getDiffer(Node arg9, int arg10, MutableVector arg11, MutableVector arg12, boolean arg13) {
        Differ v0 = this.cachedDiffer;
        if(v0 == null) {
            Differ v1 = new Differ(this, arg9, arg10, arg11, arg12, arg13);
            this.cachedDiffer = v1;
            return v1;
        }

        v0.setNode(arg9);
        v0.setOffset(arg10);
        v0.setBefore(arg11);
        v0.setAfter(arg12);
        v0.setShouldAttachOnInsert(arg13);
        return v0;
    }

    public final Node getHead$ui() {
        return this.head;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui() {
        return this.innerCoordinator;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final List getModifierInfo() {
        MutableVector v0 = this.current;
        if(v0 == null) {
            return CollectionsKt.emptyList();
        }

        int v3 = 0;
        MutableVector v2 = new MutableVector(new ModifierInfo[v0.getSize()], 0);
        Node v1 = this.getHead$ui();
        while(true) {
            if(v1 != null && v1 != this.getTail$ui()) {
                NodeCoordinator v4 = v1.getCoordinator$ui();
                if(v4 != null) {
                    OwnedLayer v5 = v4.getLayer();
                    OwnedLayer v6 = this.innerCoordinator.getLayer();
                    Node v7 = v1.getChild$ui();
                    if(v7 != this.tail || v1.getCoordinator$ui() == v7.getCoordinator$ui()) {
                        v6 = null;
                    }
                    else {
                    }

                    if(v5 == null) {
                        v5 = v6;
                    }

                    v2.add(new ModifierInfo(v0.content[v3], ((LayoutCoordinates)v4), v5));
                    v1 = v1.getChild$ui();
                    ++v3;
                    continue;
                }
                else {
                    break;
                }
            }

            goto label_42;
        }

        throw new IllegalArgumentException("getModifierInfo called on node with no coordinator".toString());
    label_42:
        return v2.asMutableList();
    }

    public final NodeCoordinator getOuterCoordinator$ui() {
        return this.outerCoordinator;
    }

    public final Node getTail$ui() {
        return this.tail;
    }

    public final boolean has$ui(int arg1) {
        if((this.getAggregateChildKindSet() & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean has-H91voCI$ui(int arg1) {
        if((this.getAggregateChildKindSet() & arg1) != 0) {
            return 1;
        }

        return 0;
    }

    public final Object head-H91voCI$ui(int arg9) {
        Node v1 = null;
        if((this.getAggregateChildKindSet() & arg9) != 0) {
            Node v8;
            for(v8 = this.getHead$ui(); v8 != null; v8 = v8.getChild$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = v8;
                    MutableVector v2 = ((MutableVector)v1);
                    while(true) {
                    label_13:
                        if(v0 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v0 instanceof Object)) {
                                return v0;
                            }
                            else {
                                if((v0.getKindSet$ui() & arg9) != 0 && ((v0 instanceof DelegatingNode))) {
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
                                                    goto label_56;
                                                }

                                                v2.add(v3);
                                            }
                                        }

                                    label_56:
                                        v3 = v3.getChild$ui();
                                    }

                                    if(v5 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }
                        }

                        goto label_63;
                    }

                    v0 = DelegatableNodeKt.pop(v2);
                    goto label_13;
                }

            label_63:
                if((v8.getAggregateChildKindSet$ui() & arg9) == 0) {
                    return v1;
                }
            }
        }

        return v1;
    }

    public final void headToTail$ui(int arg2, Function1 arg3) {
        if((this.getAggregateChildKindSet() & arg2) == 0) {
        }
        else {
            Node v1;
            for(v1 = this.getHead$ui(); v1 != null; v1 = v1.getChild$ui()) {
                if((v1.getKindSet$ui() & arg2) != 0) {
                    arg3.invoke(v1);
                }

                if((v1.getAggregateChildKindSet$ui() & arg2) == 0) {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui(Function1 arg1) {
        Node v0;
        for(v0 = this.getHead$ui(); v0 != null; v0 = v0.getChild$ui()) {
            arg1.invoke(v0);
        }
    }

    public final void headToTail-aLcG6gQ$ui(int arg9, Function1 arg10) {
        if((this.getAggregateChildKindSet() & arg9) != 0) {
            Node v8;
            for(v8 = this.getHead$ui(); v8 != null; v8 = v8.getChild$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = null;
                    Node v1 = v8;
                    MutableVector v2 = ((MutableVector)v0);
                    while(true) {
                    label_13:
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
                                                goto label_57;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_57:
                                    v3 = v3.getChild$ui();
                                }

                                if(v5 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_64;
                    }

                    v1 = DelegatableNodeKt.pop(v2);
                    goto label_13;
                }

            label_64:
                if((v8.getAggregateChildKindSet$ui() & arg9) == 0) {
                    return;
                }
            }
        }
    }

    public final void headToTailExclusive$ui(Function1 arg3) {
        Node v0;
        for(v0 = this.getHead$ui(); v0 != null; v0 = v0.getChild$ui()) {
            if(v0 == this.getTail$ui()) {
                return;
            }

            arg3.invoke(v0);
        }
    }

    private final Node insertChild(Node arg1, Node arg2) {
        Node v0 = arg2.getChild$ui();
        if(v0 != null) {
            v0.setParent$ui(arg1);
            arg1.setChild$ui(v0);
        }

        arg2.setChild$ui(arg1);
        arg1.setParent$ui(arg2);
        return arg1;
    }

    public final boolean isUpdating$ui() {
        if(this.sentinelHead.getChild$ui() != null) {
            return 1;
        }

        return 0;
    }

    public final void markAsAttached() {
        Node v0;
        for(v0 = this.getHead$ui(); v0 != null; v0 = v0.getChild$ui()) {
            v0.markAsAttached$ui();
        }
    }

    public final void markAsDetached$ui() {
        Node v1;
        for(v1 = this.getTail$ui(); v1 != null; v1 = v1.getParent$ui()) {
            if(v1.isAttached()) {
                v1.markAsDetached$ui();
            }
        }
    }

    private final Node padChain() {
        int v0 = this.head != this.sentinelHead ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("padChain called on already padded chain");
        }

        Node v0_1 = this.head;
        v0_1.setParent$ui(this.sentinelHead);
        this.sentinelHead.setChild$ui(v0_1);
        return this.sentinelHead;
    }

    private final void propagateCoordinator(Node arg3, NodeCoordinator arg4) {
        for(arg3 = arg3.getParent$ui(); arg3 != null; arg3 = arg3.getParent$ui()) {
            if(arg3 == this.sentinelHead) {
                LayoutNode v3 = this.layoutNode.getParent$ui();
                NodeCoordinator v3_1 = v3 != null ? v3.getInnerCoordinator$ui() : null;
                arg4.setWrappedBy$ui(v3_1);
                this.outerCoordinator = arg4;
                return;
            }

            if((NodeKind.constructor-impl(2) & arg3.getKindSet$ui()) != 0) {
                return;
            }

            arg3.updateCoordinator$ui(arg4);
        }
    }

    private final Node removeNode(Node arg3) {
        Node v2 = arg3.getChild$ui();
        Node v0 = arg3.getParent$ui();
        Node v1 = null;
        if(v2 != null) {
            v2.setParent$ui(v0);
            arg3.setChild$ui(v1);
        }

        if(v0 != null) {
            v0.setChild$ui(v2);
            arg3.setParent$ui(v1);
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    public final void resetState$ui() {
        Node v0;
        for(v0 = this.getTail$ui(); v0 != null; v0 = v0.getParent$ui()) {
            if(v0.isAttached()) {
                v0.reset$ui();
            }
        }

        this.runDetachLifecycle$ui();
        this.markAsDetached$ui();
    }

    public final void runAttachLifecycle() {
        Node v1;
        for(v1 = this.getHead$ui(); v1 != null; v1 = v1.getChild$ui()) {
            v1.runAttachLifecycle$ui();
            if(v1.getInsertedNodeAwaitingAttachForInvalidation$ui()) {
                NodeKindKt.autoInvalidateInsertedNode(v1);
            }

            if(v1.getUpdatedNodeAwaitingAttachForInvalidation$ui()) {
                NodeKindKt.autoInvalidateUpdatedNode(v1);
            }

            v1.setInsertedNodeAwaitingAttachForInvalidation$ui(false);
            v1.setUpdatedNodeAwaitingAttachForInvalidation$ui(false);
        }
    }

    public final void runDetachLifecycle$ui() {
        Node v1;
        for(v1 = this.getTail$ui(); v1 != null; v1 = v1.getParent$ui()) {
            if(v1.isAttached()) {
                v1.runDetachLifecycle$ui();
            }
        }
    }

    private final void structuralUpdate(int arg2, MutableVector arg3, MutableVector arg4, Node arg5, boolean arg6) {
        MyersDiffKt.executeDiff(arg3.getSize() - arg2, arg4.getSize() - arg2, this.getDiffer(arg5, arg2, arg3, arg4, arg6));
        this.syncAggregateChildKindSet();
    }

    private final void syncAggregateChildKindSet() {
        Node v0 = this.tail.getParent$ui();
        int v1 = 0;
        while(v0 != null) {
            if(v0 == this.sentinelHead) {
                return;
            }

            v1 |= v0.getKindSet$ui();
            v0.setAggregateChildKindSet$ui(v1);
            v0 = v0.getParent$ui();
        }
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator v3_1;
        InnerNodeCoordinator v0 = this.innerCoordinator;
        Node v1;
        for(v1 = this.tail.getParent$ui(); v1 != null; v1 = v1.getParent$ui()) {
            LayoutModifierNode v2 = DelegatableNodeKt.asLayoutModifierNode(v1);
            if(v2 != null) {
                if(v1.getCoordinator$ui() != null) {
                    NodeCoordinator v3 = v1.getCoordinator$ui();
                    Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    LayoutModifierNode v4 = ((LayoutModifierNodeCoordinator)v3).getLayoutModifierNode();
                    ((LayoutModifierNodeCoordinator)v3).setLayoutModifierNode$ui(v2);
                    if((((Node)v4)) != v1) {
                        ((LayoutModifierNodeCoordinator)v3).onLayoutModifierNodeChanged();
                    }
                }
                else {
                    v3_1 = new LayoutModifierNodeCoordinator(this.layoutNode, v2);
                    v1.updateCoordinator$ui(v3_1);
                }

                ((NodeCoordinator)v0).setWrappedBy$ui(((NodeCoordinator)v3_1));
                v3_1.setWrapped$ui(((NodeCoordinator)v0));
                NodeCoordinator v0_1 = ((NodeCoordinator)v3_1);
            }
            else {
                v1.updateCoordinator$ui(((NodeCoordinator)v0));
            }
        }

        LayoutNode v1_1 = this.layoutNode.getParent$ui();
        NodeCoordinator v1_2 = v1_1 != null ? v1_1.getInnerCoordinator$ui() : null;
        ((NodeCoordinator)v0).setWrappedBy$ui(v1_2);
        this.outerCoordinator = ((NodeCoordinator)v0);
    }

    public final Object tail-H91voCI$ui(int arg9) {
        Node v1 = null;
        if((this.getAggregateChildKindSet() & arg9) != 0) {
            Node v8;
            for(v8 = this.getTail$ui(); v8 != null; v8 = v8.getParent$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = v8;
                    MutableVector v2 = ((MutableVector)v1);
                    while(true) {
                    label_13:
                        if(v0 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if((v0 instanceof Object)) {
                                return v0;
                            }
                            else {
                                if((v0.getKindSet$ui() & arg9) != 0 && ((v0 instanceof DelegatingNode))) {
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
                                                    goto label_56;
                                                }

                                                v2.add(v3);
                                            }
                                        }

                                    label_56:
                                        v3 = v3.getChild$ui();
                                    }

                                    if(v5 != 1) {
                                        break;
                                    }

                                    continue;
                                }

                                break;
                            }
                        }

                        goto label_63;
                    }

                    v0 = DelegatableNodeKt.pop(v2);
                    goto label_13;
                }

            label_63:
            }
        }

        return v1;
    }

    public final void tailToHead$ui(int arg2, Function1 arg3) {
        if((this.getAggregateChildKindSet() & arg2) == 0) {
        }
        else {
            Node v1;
            for(v1 = this.getTail$ui(); v1 != null; v1 = v1.getParent$ui()) {
                if((v1.getKindSet$ui() & arg2) != 0) {
                    arg3.invoke(v1);
                }
            }
        }
    }

    public final void tailToHead$ui(Function1 arg1) {
        Node v0;
        for(v0 = this.getTail$ui(); v0 != null; v0 = v0.getParent$ui()) {
            arg1.invoke(v0);
        }
    }

    public final void tailToHead-aLcG6gQ$ui(int arg9, Function1 arg10) {
        if((this.getAggregateChildKindSet() & arg9) != 0) {
            Node v8;
            for(v8 = this.getTail$ui(); v8 != null; v8 = v8.getParent$ui()) {
                if((v8.getKindSet$ui() & arg9) != 0) {
                    Node v0 = null;
                    Node v1 = v8;
                    MutableVector v2 = ((MutableVector)v0);
                    while(true) {
                    label_13:
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
                                                goto label_57;
                                            }

                                            v2.add(v3);
                                        }
                                    }

                                label_57:
                                    v3 = v3.getChild$ui();
                                }

                                if(v5 != 1) {
                                    break;
                                }

                                continue;
                            }

                            break;
                        }

                        goto label_64;
                    }

                    v1 = DelegatableNodeKt.pop(v2);
                    goto label_13;
                }

            label_64:
            }
        }
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("[");
        String v3 = "]";
        if(this.head == this.tail) {
            v0.append(v3);
        }
        else {
            Node v1 = this.getHead$ui();
            while(v1 != null) {
                if(v1 == this.getTail$ui()) {
                    break;
                }

                v0.append(String.valueOf(v1));
                if(v1.getChild$ui() == this.tail) {
                    v0.append(v3);
                }
                else {
                    v0.append(",");
                    v1 = v1.getChild$ui();
                    continue;
                }

                break;
            }
        }

        String v5 = v0.toString();
        Intrinsics.checkNotNullExpressionValue(v5, "toString(...)");
        return v5;
    }

    private final Node trimChain(Node arg6) {
        int v1 = 1;
        int v6 = arg6 == this.sentinelHead ? 1 : 0;
        if(v6 == 0) {
            InlineClassHelperKt.throwIllegalStateException("trimChain called on already trimmed chain");
        }

        arg6 = this.sentinelHead.getChild$ui();
        if(arg6 == null) {
            arg6 = this.tail;
        }

        arg6.setParent$ui(null);
        this.sentinelHead.setChild$ui(null);
        this.sentinelHead.setAggregateChildKindSet$ui(-1);
        this.sentinelHead.updateCoordinator$ui(null);
        if(arg6 != this.sentinelHead) {
        }
        else {
            v1 = 0;
        }

        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("trimChain did not update the head");
        }

        return arg6;
    }

    public final void updateFrom$ui(Modifier arg18) {
        Node v4_1;
        MutableVector v3_1;
        Logger v7;
        Node v5_1;
        Logger v11;
        Object v15;
        Object v14;
        Node v16;
        NodeChain v0 = this;
        Node v6 = v0.padChain();
        MutableVector v2 = v0.current;
        int v1 = 0;
        int v3 = v2 != null ? v2.getSize() : 0;
        MutableVector v4 = v0.buffer;
        int v5 = 16;
        if(v4 == null) {
            v4 = new MutableVector(new Element[v5], 0);
        }

        v4 = NodeChainKt.access$fillVector(arg18, v4, v0.stack);
        MutableVector v8 = null;
        String v9 = "expected prior modifier list to be non-empty";
        if(v4.getSize() == v3) {
            int v12 = 0;
            v16 = v6.getChild$ui();
            while(true) {
                if(v16 == null) {
                    goto label_66;
                }
                else if(v12 >= v3) {
                    goto label_66;
                }
                else if(v2 != null) {
                    v14 = v2.content[v12];
                    v15 = v4.content[v12];
                    v5 = NodeChainKt.actionForModifiers(((Element)v14), ((Element)v15));
                    if(v5 != 0) {
                        if(v5 != 1) {
                            if(v5 == 2) {
                                v11 = v0.logger;
                                if(v11 != null) {
                                    v11.nodeReused(v12, v12, ((Element)v14), ((Element)v15), v16);
                                }
                            }

                            v5_1 = v16;
                        }
                        else {
                            v5_1 = v16;
                            v0.updateNode(((Element)v14), ((Element)v15), v5_1);
                            v11 = v0.logger;
                            if(v11 == null) {
                                goto label_53;
                            }

                            v11.nodeUpdated(v12, v12, ((Element)v14), ((Element)v15), v5_1);
                        }

                    label_53:
                        v16 = v5_1.getChild$ui();
                        ++v12;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                else {
                    goto label_62;
                }

                goto label_68;
            }

            v5_1 = v16;
            v7 = v0.logger;
            if(v7 != null) {
                v7.linearDiffAborted(v12, ((Element)v14), ((Element)v15), v5_1);
            }

            v16 = v5_1.getParent$ui();
            goto label_68;
        label_62:
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(v9);
            throw new KotlinNothingValueException();
        label_66:
            v16 = v16;
        label_68:
            if(v12 >= v3) {
                goto label_139;
            }

            if(v2 != null) {
                if(v16 != null) {
                    v3_1 = v4;
                    v0.structuralUpdate(v12, v2, v3_1, v16, v0.layoutNode.getApplyingModifierOnAttach$ui() ^ 1);
                    goto label_109;
                }

                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("structuralUpdate requires a non-null tail");
                throw new KotlinNothingValueException();
            }

            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(v9);
            throw new KotlinNothingValueException();
        }
        else {
            if((v0.layoutNode.getApplyingModifierOnAttach$ui()) && v3 == 0) {
                int v13 = 0;
                Node v15_1;
                for(v15_1 = v6; v13 < v4.getSize(); v15_1 = v16) {
                    v14 = v4.content[v13];
                    v16 = v0.createAndInsertNodeAsChild(((Element)v14), v15_1);
                    v11 = v0.logger;
                    if(v11 != null) {
                        v11.nodeInserted(0, v13, ((Element)v14), v15_1, v16);
                    }

                    ++v13;
                }

                v0.syncAggregateChildKindSet();
                v3_1 = v4;
            label_109:
                v4_1 = v6;
                goto label_110;
            }

            if(v4.getSize() == 0) {
                if(v2 != null) {
                    Node v3_2 = v6.getChild$ui();
                    for(v5 = 0; v3_2 != null; ++v5) {
                        if(v5 >= v2.getSize()) {
                            break;
                        }

                        v7 = v0.logger;
                        if(v7 != null) {
                            v7.nodeRemoved(v5, v2.content[v5], v3_2);
                        }

                        v3_2 = v0.detachAndRemoveNode(v3_2).getChild$ui();
                    }

                    InnerNodeCoordinator v3_3 = v0.innerCoordinator;
                    LayoutNode v5_2 = v0.layoutNode.getParent$ui();
                    NodeCoordinator v5_3 = v5_2 != null ? v5_2.getInnerCoordinator$ui() : ((NodeCoordinator)v8);
                    v3_3.setWrappedBy$ui(v5_3);
                    v0.outerCoordinator = v0.innerCoordinator;
                label_139:
                    v3_1 = v4;
                    v4_1 = v6;
                    goto label_158;
                }

                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(v9);
                throw new KotlinNothingValueException();
            }

            if(v2 == null) {
                v2 = new MutableVector(new Element[v5], 0);
            }

            v3_1 = v4;
            v4_1 = v6;
            v0.structuralUpdate(0, v2, v3_1, v4_1, v0.layoutNode.getApplyingModifierOnAttach$ui() ^ 1);
        label_110:
            v1 = 1;
        }

    label_158:
        v0.current = v3_1;
        if(v2 != null) {
            v2.clear();
            v8 = v2;
        }

        v0.buffer = v8;
        v0.head = v0.trimChain(v4_1);
        if(v1 != 0) {
            v0.syncCoordinators();
        }
    }

    private final void updateNode(Element arg1, Element arg2, Node arg3) {
        if(((arg1 instanceof ModifierNodeElement)) && ((arg2 instanceof ModifierNodeElement))) {
            NodeChainKt.access$updateUnsafe(((ModifierNodeElement)arg2), arg3);
            if(arg3.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(arg3);
                return;
            }
            else {
                arg3.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
                return;
            }
        }

        if((arg3 instanceof BackwardsCompatNode)) {
            arg3.setElement(arg2);
            if(arg3.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(arg3);
                return;
            }

            arg3.setUpdatedNodeAwaitingAttachForInvalidation$ui(true);
            return;
        }

        InlineClassHelperKt.throwIllegalStateException("Unknown Modifier.Node type");
    }

    public final void useLogger$ui(Logger arg1) {
        this.logger = arg1;
    }
}

