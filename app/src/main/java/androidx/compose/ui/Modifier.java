package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\u00020\u0001:\u0003\u0011\u0012\u0013J5\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u0002H\u00032\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ5\u0010\t\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u0002H\u00032\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ\u001C\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000B0\rH&J\u001C\u0010\u000E\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000B0\rH&J\u0011\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u0000H\u0096\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2={"Landroidx/compose/ui/Modifier;", "", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "then", "other", "Element", "Node", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Modifier {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001A\u0002H\u00052\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\nJ5\u0010\u000B\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001A\u0002H\u00052\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\nJ\u001C\u0010\f\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000FH\u0016J\u001C\u0010\u0010\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u000FH\u0016J\u0011\u0010\u0011\u001A\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0001H\u0096\u0004J\b\u0010\u0013\u001A\u00020\u0014H\u0016¨\u0006\u0015"}, d2={"Landroidx/compose/ui/Modifier$Companion;", "Landroidx/compose/ui/Modifier;", "<init>", "()V", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "Landroidx/compose/ui/Modifier$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "then", "other", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion implements Modifier {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public boolean all(Function1 arg1) {
            return 1;
        }

        public boolean any(Function1 arg1) {
            return 0;
        }

        public Object foldIn(Object arg1, Function2 arg2) {
            return arg1;
        }

        public Object foldOut(Object arg1, Function2 arg2) {
            return arg1;
        }

        public Modifier then(Modifier arg1) {
            return arg1;
        }

        public String toString() {
            return "Modifier";
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Modifier then(Modifier arg0, Modifier arg1) {
            return arg0.then(arg1);
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u0002H\u00032\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J5\u0010\b\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001A\u0002H\u00032\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J\u001C\u0010\t\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001C\u0010\r\u001A\u00020\n2\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/Modifier;", "foldIn", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldOut", "any", "", "predicate", "Lkotlin/Function1;", "all", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Element extends Modifier {
        @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.Modifier$Element$DefaultImpls {
            @Deprecated public static boolean all(Element arg0, Function1 arg1) {
                return arg0.all(arg1);
            }

            @Deprecated public static boolean any(Element arg0, Function1 arg1) {
                return arg0.any(arg1);
            }

            @Deprecated public static Object foldIn(Element arg0, Object arg1, Function2 arg2) {
                return arg0.foldIn(arg1, arg2);
            }

            @Deprecated public static Object foldOut(Element arg0, Object arg1, Function2 arg2) {
                return arg0.foldOut(arg1, arg2);
            }

            @Deprecated public static Modifier then(Element arg0, Modifier arg1) {
                return arg0.then(arg1);
            }
        }

        static boolean access$all$jd(Element arg0, Function1 arg1) {
            return super.all(arg1);
        }

        static boolean access$any$jd(Element arg0, Function1 arg1) {
            return super.any(arg1);
        }

        static Object access$foldIn$jd(Element arg0, Object arg1, Function2 arg2) {
            return super.foldIn(arg1, arg2);
        }

        static Object access$foldOut$jd(Element arg0, Object arg1, Function2 arg2) {
            return super.foldOut(arg1, arg2);
        }

        static Modifier access$then$jd(Element arg0, Modifier arg1) {
            return super.then(arg1);
        }

        default boolean all(Function1 arg1) {
            return arg1.invoke(this).booleanValue();
        }

        default boolean any(Function1 arg1) {
            return arg1.invoke(this).booleanValue();
        }

        default Object foldIn(Object arg1, Function2 arg2) {
            return arg2.invoke(arg1, this);
        }

        default Object foldOut(Object arg1, Function2 arg2) {
            return arg2.invoke(this, arg1);
        }
    }

    @Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010>\u001A\u0002052\b\u0010%\u001A\u0004\u0018\u00010$H\u0010¢\u0006\u0002\b?J\u001C\u0010@\u001A\u00020)2\n\u0010A\u001A\u0006\u0012\u0002\b\u00030BH\u0080\b¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001A\u000205H\u0010¢\u0006\u0002\bFJ\r\u0010G\u001A\u000205H\u0010¢\u0006\u0002\bHJ\r\u0010I\u001A\u000205H\u0010¢\u0006\u0002\bJJ\r\u0010K\u001A\u000205H\u0010¢\u0006\u0002\bLJ\r\u0010M\u001A\u000205H\u0010¢\u0006\u0002\bNJ\b\u0010O\u001A\u000205H\u0016J\b\u0010P\u001A\u000205H\u0016J\b\u0010Q\u001A\u000205H\u0016J\u0014\u0010R\u001A\u0002052\f\u0010S\u001A\b\u0012\u0004\u0012\u00020504J\u0015\u0010T\u001A\u0002052\u0006\u0010U\u001A\u00020\u0000H\u0010¢\u0006\u0002\bVR$\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0000@BX\u0086\u000E¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001C\u0010\u0017\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001AR\u001C\u0010\u001B\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\b\"\u0004\b\u001D\u0010\u001AR\u001C\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\u0004\u001A\u0004\u0018\u00010$@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'R\u001A\u0010(\u001A\u00020)X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001A\u0010.\u001A\u00020)X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b/\u0010+\"\u0004\b0\u0010-R\u000E\u00101\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u00103\u001A\n\u0012\u0004\u0012\u000205\u0018\u000104X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b6\u00107\"\u0004\b8\u00109R\u001E\u0010:\u001A\u00020)2\u0006\u0010\u0004\u001A\u00020)@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b:\u0010+R\u001A\u0010;\u001A\u00020)8VX\u0096\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0003\u001A\u0004\b=\u0010+¨\u0006W"}, d2={"Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "<init>", "()V", "value", "node", "getNode$annotations", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "kindSet", "", "getKindSet$ui", "()I", "setKindSet$ui", "(I)V", "aggregateChildKindSet", "getAggregateChildKindSet$ui", "setAggregateChildKindSet$ui", "parent", "getParent$ui", "setParent$ui", "(Landroidx/compose/ui/Modifier$Node;)V", "child", "getChild$ui", "setChild$ui", "ownerScope", "Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "getOwnerScope$ui", "()Landroidx/compose/ui/node/ObserverNodeOwnerScope;", "setOwnerScope$ui", "(Landroidx/compose/ui/node/ObserverNodeOwnerScope;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "getCoordinator$ui", "()Landroidx/compose/ui/node/NodeCoordinator;", "insertedNodeAwaitingAttachForInvalidation", "", "getInsertedNodeAwaitingAttachForInvalidation$ui", "()Z", "setInsertedNodeAwaitingAttachForInvalidation$ui", "(Z)V", "updatedNodeAwaitingAttachForInvalidation", "getUpdatedNodeAwaitingAttachForInvalidation$ui", "setUpdatedNodeAwaitingAttachForInvalidation$ui", "onAttachRunExpected", "onDetachRunExpected", "detachedListener", "Lkotlin/Function0;", "", "getDetachedListener$ui", "()Lkotlin/jvm/functions/Function0;", "setDetachedListener$ui", "(Lkotlin/jvm/functions/Function0;)V", "isAttached", "shouldAutoInvalidate", "getShouldAutoInvalidate$annotations", "getShouldAutoInvalidate", "updateCoordinator", "updateCoordinator$ui", "isKind", "kind", "Landroidx/compose/ui/node/NodeKind;", "isKind-H91voCI$ui", "(I)Z", "markAsAttached", "markAsAttached$ui", "runAttachLifecycle", "runAttachLifecycle$ui", "runDetachLifecycle", "runDetachLifecycle$ui", "markAsDetached", "markAsDetached$ui", "reset", "reset$ui", "onAttach", "onDetach", "onReset", "sideEffect", "effect", "setAsDelegateTo", "owner", "setAsDelegateTo$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private int aggregateChildKindSet;
        private Node child;
        private NodeCoordinator coordinator;
        private Function0 detachedListener;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private Node node;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;

        static {
        }

        public Node() {
            super();
            this.node = this;
            this.aggregateChildKindSet = -1;
        }

        public final int getAggregateChildKindSet$ui() {
            return this.aggregateChildKindSet;
        }

        public final Node getChild$ui() {
            return this.child;
        }

        public final NodeCoordinator getCoordinator$ui() {
            return this.coordinator;
        }

        public final CoroutineScope getCoroutineScope() {
            CoroutineScope v0 = this.scope;
            if(v0 == null) {
                v0 = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner(this).getCoroutineContext().plus(JobKt.Job(DelegatableNodeKt.requireOwner(this).getCoroutineContext().get(Job.Key))));
                this.scope = v0;
            }

            return v0;
        }

        public final Function0 getDetachedListener$ui() {
            return this.detachedListener;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final int getKindSet$ui() {
            return this.kindSet;
        }

        public final Node getNode() {
            return this.node;
        }

        public static void getNode$annotations() {
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui() {
            return this.ownerScope;
        }

        public final Node getParent$ui() {
            return this.parent;
        }

        public boolean getShouldAutoInvalidate() {
            return 1;
        }

        public static void getShouldAutoInvalidate$annotations() {
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        public final boolean isKind-H91voCI$ui(int arg1) {
            if((this.getKindSet$ui() & arg1) != 0) {
                return 1;
            }

            return 0;
        }

        public void markAsAttached$ui() {
            if(this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("node attached multiple times");
            }

            int v0 = this.coordinator != null ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("attach invoked on a node without a coordinator");
            }

            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void markAsDetached$ui() {
            if(!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("Cannot detach a node that is not attached");
            }

            if(this.onAttachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
            }

            if(this.onDetachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
            }

            this.isAttached = false;
            CoroutineScope v0 = this.scope;
            if(v0 != null) {
                CoroutineScopeKt.cancel(v0, new ModifierNodeDetachedCancellationException());
                this.scope = null;
            }
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }

        public void reset$ui() {
            if(!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("reset() called on an unattached node");
            }

            this.onReset();
        }

        public void runAttachLifecycle$ui() {
            if(!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
            }

            if(!this.onAttachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
            }

            this.onAttachRunExpected = false;
            this.onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui() {
            if(!this.isAttached) {
                InlineClassHelperKt.throwIllegalStateException("node detached multiple times");
            }

            int v0 = this.coordinator != null ? 1 : 0;
            if(v0 == 0) {
                InlineClassHelperKt.throwIllegalStateException("detach invoked on a node without a coordinator");
            }

            if(!this.onDetachRunExpected) {
                InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }

            this.onDetachRunExpected = false;
            Function0 v0_1 = this.detachedListener;
            if(v0_1 != null) {
                v0_1.invoke();
            }

            this.onDetach();
        }

        public final void setAggregateChildKindSet$ui(int arg1) {
            this.aggregateChildKindSet = arg1;
        }

        public void setAsDelegateTo$ui(Node arg1) {
            this.node = arg1;
        }

        public final void setChild$ui(Node arg1) {
            this.child = arg1;
        }

        public final void setDetachedListener$ui(Function0 arg1) {
            this.detachedListener = arg1;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui(boolean arg1) {
            this.insertedNodeAwaitingAttachForInvalidation = arg1;
        }

        public final void setKindSet$ui(int arg1) {
            this.kindSet = arg1;
        }

        public final void setOwnerScope$ui(ObserverNodeOwnerScope arg1) {
            this.ownerScope = arg1;
        }

        public final void setParent$ui(Node arg1) {
            this.parent = arg1;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui(boolean arg1) {
            this.updatedNodeAwaitingAttachForInvalidation = arg1;
        }

        public final void sideEffect(Function0 arg1) {
            DelegatableNodeKt.requireOwner(((DelegatableNode)this)).registerOnEndApplyChangesListener(arg1);
        }

        public void updateCoordinator$ui(NodeCoordinator arg1) {
            this.coordinator = arg1;
        }
    }

    public static final Companion Companion;

    static {
        Modifier.Companion = Companion.$$INSTANCE;
    }

    static Modifier access$then$jd(Modifier arg0, Modifier arg1) {
        return super.then(arg1);
    }

    boolean all(Function1 arg1);

    boolean any(Function1 arg1);

    Object foldIn(Object arg1, Function2 arg2);

    Object foldOut(Object arg1, Function2 arg2);

    default Modifier then(Modifier arg2) {
        if(arg2 == Modifier.Companion) {
            return this;
        }

        return new CombinedModifier(this, arg2);
    }
}

