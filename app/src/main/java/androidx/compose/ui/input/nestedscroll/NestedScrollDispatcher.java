package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020#¢\u0006\u0004\b$\u0010%J%\u0010&\u001A\u00020 2\u0006\u0010\'\u001A\u00020 2\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020#¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001A\u00020+2\u0006\u0010!\u001A\u00020+H\u0086@¢\u0006\u0004\b,\u0010-J \u0010.\u001A\u00020+2\u0006\u0010\'\u001A\u00020+2\u0006\u0010!\u001A\u00020+H\u0086@¢\u0006\u0004\b/\u00100R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u000FX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0016R\u0016\u0010\u001B\u001A\u0004\u0018\u00010\u001C8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u00061"}, d2={"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "<init>", "()V", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "lastKnownParentNode", "getLastKnownParentNode$ui", "setLastKnownParentNode$ui", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui", "(Lkotlin/jvm/functions/Function0;)V", "scope", "getScope$ui", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$ui", "(Lkotlinx/coroutines/CoroutineScope;)V", "coroutineScope", "getCoroutineScope", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatchPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPreScroll-OzD1aCk", "(JI)J", "dispatchPostScroll", "consumed", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "Landroidx/compose/ui/unit/Velocity;", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostFling", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0 calculateNestedScrollScope;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    static {
    }

    public NestedScrollDispatcher() {
        super();
        this.calculateNestedScrollScope = new NestedScrollDispatcher$calculateNestedScrollScope$1(this);
    }

    public final Object dispatchPostFling-RZ2iAVY(long arg6, long arg8, Continuation arg10) {
        long v5_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof NestedScrollDispatcher$dispatchPostFling$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((NestedScrollDispatcher$dispatchPostFling$1)v0).label & v2) != 0) {
                ((NestedScrollDispatcher$dispatchPostFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            NestedScrollDispatcher$dispatchPostFling$1 v0_1 = new NestedScrollDispatcher$dispatchPostFling$1(this, arg10);
        }

        arg10 = v0;
        Object v0_2 = ((NestedScrollDispatcher$dispatchPostFling$1)arg10).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((NestedScrollDispatcher$dispatchPostFling$1)arg10).label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v0_2);
            if(this.getParent$ui() == null) {
                NestedScrollNode v5 = this.lastKnownParentNode;
                if(v5 != null) {
                    ((NestedScrollDispatcher$dispatchPostFling$1)arg10).label = 1;
                    v0_2 = v5.onPostFling-RZ2iAVY(arg6, arg8, arg10);
                    if(v0_2 == v1) {
                    }
                    else {
                    label_39:
                        v5_1 = ((Velocity)v0_2).unbox-impl();
                        goto label_54;
                    }
                }
                else {
                    v5_1 = Velocity.Companion.getZero-9UxMQ8M();
                    goto label_54;
                }
            }
            else {
                NestedScrollConnection v5_2 = this.getParent$ui();
                if(v5_2 != null) {
                    ((NestedScrollDispatcher$dispatchPostFling$1)arg10).label = v3;
                    v0_2 = v5_2.onPostFling-RZ2iAVY(arg6, arg8, arg10);
                    if(v0_2 == v1) {
                        return v1;
                    }

                    goto label_50;
                }
                else {
                    goto label_52;
                }
            }

            return v1;
        label_50:
            v5_1 = ((Velocity)v0_2).unbox-impl();
            goto label_54;
        label_52:
            v5_1 = Velocity.Companion.getZero-9UxMQ8M();
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v0_2);
            goto label_39;
        }
        else if(v2 == v3) {
            ResultKt.throwOnFailure(v0_2);
            goto label_50;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_54:
        return Velocity.box-impl(v5_1);
    }

    public final long dispatchPostScroll-DzOQY0M(long arg1, long arg3, int arg5) {
        NestedScrollConnection v0 = this.getParent$ui();
        if(v0 != null) {
            return v0.onPostScroll-DzOQY0M(arg1, arg3, arg5);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public final Object dispatchPreFling-QWom1Mo(long arg5, Continuation arg7) {
        long v4_1;
        NestedScrollDispatcher$dispatchPreFling$1 v0_1;
        int v2;
        if((arg7 instanceof NestedScrollDispatcher$dispatchPreFling$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((NestedScrollDispatcher$dispatchPreFling$1)v0).label & v2) != 0) {
                ((NestedScrollDispatcher$dispatchPreFling$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new NestedScrollDispatcher$dispatchPreFling$1(this, arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            NestedScrollConnection v4 = this.getParent$ui();
            if(v4 != null) {
                v0_1.label = 1;
                v7 = v4.onPreFling-QWom1Mo(arg5, ((Continuation)v0_1));
                if(v7 == v1) {
                    return v1;
                }
                else {
                label_32:
                    v4_1 = ((Velocity)v7).unbox-impl();
                }
            }
            else {
                v4_1 = Velocity.Companion.getZero-9UxMQ8M();
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v7);
            goto label_32;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Velocity.box-impl(v4_1);
    }

    public final long dispatchPreScroll-OzD1aCk(long arg1, int arg3) {
        NestedScrollConnection v0 = this.getParent$ui();
        if(v0 != null) {
            return v0.onPreScroll-OzD1aCk(arg1, arg3);
        }

        return Offset.Companion.getZero-F1C5BW0();
    }

    public final Function0 getCalculateNestedScrollScope$ui() {
        return this.calculateNestedScrollScope;
    }

    public final CoroutineScope getCoroutineScope() {
        Object v1 = this.calculateNestedScrollScope.invoke();
        if(v1 != null) {
            return ((CoroutineScope)v1);
        }

        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollNode getLastKnownParentNode$ui() {
        return this.lastKnownParentNode;
    }

    public final NestedScrollNode getNestedScrollNode$ui() {
        return this.nestedScrollNode;
    }

    public final NestedScrollConnection getParent$ui() {
        NestedScrollNode v0 = this.nestedScrollNode;
        if(v0 != null) {
            v0 = v0.getParentNestedScrollNode$ui();
        }
        else {
            NestedScrollConnection v0_1 = null;
        }

        return ((NestedScrollConnection)v0);
    }

    public final CoroutineScope getScope$ui() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui(Function0 arg1) {
        this.calculateNestedScrollScope = arg1;
    }

    public final void setLastKnownParentNode$ui(NestedScrollNode arg1) {
        this.lastKnownParentNode = arg1;
    }

    public final void setNestedScrollNode$ui(NestedScrollNode arg1) {
        this.nestedScrollNode = arg1;
    }

    public final void setScope$ui(CoroutineScope arg1) {
        this.scope = arg1;
    }
}

