package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020%H\u0016¢\u0006\u0004\b&\u0010\'J\'\u0010(\u001A\u00020\"2\u0006\u0010)\u001A\u00020\"2\u0006\u0010#\u001A\u00020\"2\u0006\u0010$\u001A\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001A\u00020-2\u0006\u0010#\u001A\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J \u00100\u001A\u00020-2\u0006\u0010)\u001A\u00020-2\u0006\u0010#\u001A\u00020-H\u0096@¢\u0006\u0004\b1\u00102J\u0012\u00103\u001A\u0002042\b\u00105\u001A\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001A\u000204H\u0016J\b\u00107\u001A\u000204H\u0016J\b\u00108\u001A\u000204H\u0002J\b\u00109\u001A\u000204H\u0002J\u001F\u0010:\u001A\u0002042\u0006\u0010\u0004\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b;R\u001A\u0010\u0004\u001A\u00020\u0002X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000E\u001A\u0004\u0018\u00010\u0000X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001A\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001A\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001A\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001B\u001A\u00020\u001C8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 ¨\u0006<"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "lastKnownParentNode", "getLastKnownParentNode$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parentNestedScrollNode", "getParentNestedScrollNode$ui", "parentConnection", "getParentConnection", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope$annotations", "()V", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDispatcher", "", "newDispatcher", "onAttach", "onDetach", "updateDispatcherFields", "resetDispatcherFields", "updateNode", "updateNode$ui", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NestedScrollNode extends Node implements NestedScrollConnection, TraversableNode {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    static {
    }

    public NestedScrollNode(NestedScrollConnection arg1, NestedScrollDispatcher arg2) {
        super();
        this.connection = arg1;
        if(arg2 == null) {
            arg2 = new NestedScrollDispatcher();
        }

        this.resolvedDispatcher = arg2;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    public static final CoroutineScope access$getNestedCoroutineScope(NestedScrollNode arg0) {
        return arg0.getNestedCoroutineScope();
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final NestedScrollNode getLastKnownParentNode$ui() {
        return this.lastKnownParentNode;
    }

    private final CoroutineScope getNestedCoroutineScope() {
        NestedScrollNode v0 = this.getParentNestedScrollNode$ui();
        CoroutineScope v0_1 = v0 != null ? v0.getNestedCoroutineScope() : null;
        if(v0_1 != null && (CoroutineScopeKt.isActive(v0_1))) {
            return v0_1;
        }

        CoroutineScope v3 = this.resolvedDispatcher.getScope$ui();
        if(v3 != null) {
            return v3;
        }

        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private static void getNestedCoroutineScope$annotations() {
    }

    private final NestedScrollConnection getParentConnection() {
        if(this.isAttached()) {
            return this.getParentNestedScrollNode$ui();
        }

        return null;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui() {
        if(this.isAttached()) {
            return TraversableNodeKt.findNearestAncestor(((TraversableNode)this));
        }

        return null;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public void onAttach() {
        this.updateDispatcherFields();
    }

    public void onDetach() {
        TraversableNode v0 = NestedScrollNodeKt.access$findNearestAttachedAncestor(this);
        this.lastKnownParentNode = ((NestedScrollNode)v0);
        this.resolvedDispatcher.setLastKnownParentNode$ui(((NestedScrollNode)v0));
        this.resetDispatcherFields();
    }

    public Object onPostFling-RZ2iAVY(long arg12, long arg14, Continuation arg16) {
        long v11;
        long v2_1;
        long v0_2;
        long v4;
        NestedScrollNode$onPostFling$1 v1_1;
        Continuation v0 = arg16;
        if((v0 instanceof NestedScrollNode$onPostFling$1)) {
            Continuation v1 = v0;
            int v3 = 0x80000000;
            if((((NestedScrollNode$onPostFling$1)v1).label & v3) != 0) {
                ((NestedScrollNode$onPostFling$1)v1).label -= v3;
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v1_1 = new NestedScrollNode$onPostFling$1(this, v0);
        }

        Continuation v7 = ((Continuation)v1_1);
        Object v0_1 = ((NestedScrollNode$onPostFling$1)v7).result;
        Object v1_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int v2 = ((NestedScrollNode$onPostFling$1)v7).label;
        int v8 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_1);
            NestedScrollConnection v2_2 = this.connection;
            ((NestedScrollNode$onPostFling$1)v7).J$0 = arg12;
            ((NestedScrollNode$onPostFling$1)v7).J$1 = arg14;
            ((NestedScrollNode$onPostFling$1)v7).label = 1;
            v0_1 = v2_2.onPostFling-RZ2iAVY(arg12, arg14, v7);
            if(v0_1 == v1_2) {
                return v1_2;
            }
            else {
                v2_1 = arg14;
            label_48:
                v4 = ((Velocity)v0_1).unbox-impl();
                if(this.isAttached()) {
                    NestedScrollConnection v11_1 = this.getParentConnection();
                }
                else {
                    this = this.lastKnownParentNode;
                }

                if((((NestedScrollConnection)this)) != null) {
                    arg12 = Velocity.plus-AH228Gc(arg12, v4);
                    v2_1 = Velocity.minus-AH228Gc(v2_1, v4);
                    ((NestedScrollNode$onPostFling$1)v7).J$0 = v4;
                    ((NestedScrollNode$onPostFling$1)v7).label = v8;
                    v0_1 = ((NestedScrollConnection)this).onPostFling-RZ2iAVY(arg12, v2_1, v7);
                    if(v0_1 == v1_2) {
                        return v1_2;
                    }

                    v11 = v4;
                label_65:
                    v0_2 = ((Velocity)v0_1).unbox-impl();
                    v4 = v11;
                    goto label_70;
                }

                v0_2 = Velocity.Companion.getZero-9UxMQ8M();
            }
        }
        else if(v2 == 1) {
            arg12 = ((NestedScrollNode$onPostFling$1)v7).J$1;
            v2_1 = ((NestedScrollNode$onPostFling$1)v7).J$0;
            ResultKt.throwOnFailure(v0_1);
            long v9 = v2_1;
            v2_1 = arg12;
            arg12 = v9;
            goto label_48;
        }
        else if(v2 == v8) {
            v11 = ((NestedScrollNode$onPostFling$1)v7).J$0;
            ResultKt.throwOnFailure(v0_1);
            goto label_65;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_70:
        return Velocity.box-impl(Velocity.plus-AH228Gc(v4, v0_2));
    }

    public long onPostScroll-DzOQY0M(long arg7, long arg9, int arg11) {
        long v1 = arg7;
        long v3 = arg9;
        int v5 = arg11;
        arg7 = this.connection.onPostScroll-DzOQY0M(v1, v3, v5);
        NestedScrollConnection v0 = this.getParentConnection();
        arg9 = v0 != null ? v0.onPostScroll-DzOQY0M(Offset.plus-MK-Hz9U(v1, arg7), Offset.minus-MK-Hz9U(v3, arg7), v5) : Offset.Companion.getZero-F1C5BW0();
        return Offset.plus-MK-Hz9U(arg7, arg9);
    }

    public Object onPreFling-QWom1Mo(long arg7, Continuation arg9) {
        long v6;
        long v4;
        NestedScrollNode$onPreFling$1 v0_1;
        int v2;
        if((arg9 instanceof NestedScrollNode$onPreFling$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((NestedScrollNode$onPreFling$1)v0).label & v2) != 0) {
                ((NestedScrollNode$onPreFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new NestedScrollNode$onPreFling$1(this, arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            NestedScrollConnection v9_1 = this.getParentConnection();
            if(v9_1 != null) {
                v0_1.J$0 = arg7;
                v0_1.label = 1;
                v9 = v9_1.onPreFling-QWom1Mo(arg7, ((Continuation)v0_1));
                if(v9 == v1) {
                    return v1;
                }
                else {
                label_39:
                    v4 = ((Velocity)v9).unbox-impl();
                    goto label_43;
                }
            }
            else {
                v4 = Velocity.Companion.getZero-9UxMQ8M();
            label_43:
                NestedScrollConnection v6_1 = this.connection;
                arg7 = Velocity.minus-AH228Gc(arg7, v4);
                v0_1.J$0 = v4;
                v0_1.label = v3;
                v9 = v6_1.onPreFling-QWom1Mo(arg7, ((Continuation)v0_1));
                if(v9 == v1) {
                    return v1;
                }
                else {
                    v6 = v4;
                }
            }
        }
        else if(v2 == 1) {
            arg7 = v0_1.J$0;
            ResultKt.throwOnFailure(v9);
            goto label_39;
        }
        else if(v2 == v3) {
            v6 = v0_1.J$0;
            ResultKt.throwOnFailure(v9);
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Velocity.box-impl(Velocity.plus-AH228Gc(v6, ((Velocity)v9).unbox-impl()));
    }

    public long onPreScroll-OzD1aCk(long arg3, int arg5) {
        NestedScrollConnection v0 = this.getParentConnection();
        long v0_1 = v0 != null ? v0.onPreScroll-OzD1aCk(arg3, arg5) : Offset.Companion.getZero-F1C5BW0();
        return Offset.plus-MK-Hz9U(v0_1, this.connection.onPreScroll-OzD1aCk(Offset.minus-MK-Hz9U(arg3, v0_1), arg5));
    }

    private final void resetDispatcherFields() {
        if(this.resolvedDispatcher.getNestedScrollNode$ui() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui(null);
        }
    }

    public final void setConnection(NestedScrollConnection arg1) {
        this.connection = arg1;
    }

    public final void setLastKnownParentNode$ui(NestedScrollNode arg1) {
        this.lastKnownParentNode = arg1;
    }

    private final void updateDispatcher(NestedScrollDispatcher arg2) {
        this.resetDispatcherFields();
        if(arg2 == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        }
        else if(!Intrinsics.areEqual(arg2, this.resolvedDispatcher)) {
            this.resolvedDispatcher = arg2;
        }

        if(this.isAttached()) {
            this.updateDispatcherFields();
        }
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui(new NestedScrollNode$updateDispatcherFields$1(this));
        this.resolvedDispatcher.setScope$ui(this.getCoroutineScope());
    }

    public final void updateNode$ui(NestedScrollConnection arg1, NestedScrollDispatcher arg2) {
        this.connection = arg1;
        this.updateDispatcher(arg2);
    }
}

