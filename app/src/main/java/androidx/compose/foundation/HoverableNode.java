package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0004J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001A\u00020\nH\u0016J\b\u0010\u0015\u001A\u00020\nH\u0016J\u000E\u0010\u0016\u001A\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\u000E\u0010\u0018\u001A\u00020\nH\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001A\u00020\nH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"Landroidx/compose/foundation/HoverableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "hoverInteraction", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "updateInteractionSource", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onDetach", "emitEnter", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitExit", "tryEmitExit", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class HoverableNode extends Node implements PointerInputModifierNode {
    private Enter hoverInteraction;
    private MutableInteractionSource interactionSource;

    public HoverableNode(MutableInteractionSource arg1) {
        super();
        this.interactionSource = arg1;
    }

    public static final Object access$emitEnter(HoverableNode arg0, Continuation arg1) {
        return arg0.emitEnter(arg1);
    }

    public static final Object access$emitExit(HoverableNode arg0, Continuation arg1) {
        return arg0.emitExit(arg1);
    }

    private final Object emitEnter(Continuation arg6) {
        Object v0_2;
        int v2;
        Continuation v0;
        if((arg6 instanceof HoverableNode$emitEnter$1)) {
            v0 = arg6;
            v2 = 0x80000000;
            if((((HoverableNode$emitEnter$1)v0).label & v2) != 0) {
                ((HoverableNode$emitEnter$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            HoverableNode$emitEnter$1 v0_1 = new HoverableNode$emitEnter$1(this, arg6);
        }

        Object v6 = ((HoverableNode$emitEnter$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((HoverableNode$emitEnter$1)v0).label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            if(this.hoverInteraction == null) {
                Enter v6_1 = new Enter();
                MutableInteractionSource v2_1 = this.interactionSource;
                ((HoverableNode$emitEnter$1)v0).L$0 = v6_1;
                ((HoverableNode$emitEnter$1)v0).label = 1;
                if(v2_1.emit(v6_1, v0) == v1) {
                    return v1;
                }
                else {
                    Enter v0_3 = v6_1;
                label_39:
                    this.hoverInteraction = ((Enter)v0_2);
                }
            }
        }
        else if(v2 == 1) {
            v0_2 = ((HoverableNode$emitEnter$1)v0).L$0;
            ResultKt.throwOnFailure(v6);
            goto label_39;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    private final Object emitExit(Continuation arg5) {
        HoverableNode$emitExit$1 v0_1;
        int v2;
        if((arg5 instanceof HoverableNode$emitExit$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((HoverableNode$emitExit$1)v0).label & v2) != 0) {
                ((HoverableNode$emitExit$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new HoverableNode$emitExit$1(this, arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            Enter v5_1 = this.hoverInteraction;
            if(v5_1 != null) {
                Exit v2_1 = new Exit(v5_1);
                MutableInteractionSource v5_2 = this.interactionSource;
                v0_1.label = 1;
                if(v5_2.emit(((Interaction)v2_1), ((Continuation)v0_1)) == v1) {
                    return v1;
                }
                else {
                label_35:
                    this.hoverInteraction = null;
                }
            }
        }
        else if(v2 == 1) {
            ResultKt.throwOnFailure(v5);
            goto label_35;
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        return Unit.INSTANCE;
    }

    public void onCancelPointerInput() {
        this.tryEmitExit();
    }

    public void onDetach() {
        this.tryEmitExit();
    }

    public void onPointerEvent-H0pRuoY(PointerEvent arg7, PointerEventPass arg8, long arg9) {
        if(arg8 == PointerEventPass.Main) {
            int v7 = arg7.getType-7fucELk();
            Continuation v9 = null;
            if(PointerEventType.equals-impl0(v7, PointerEventType.Companion.getEnter-7fucELk())) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$1(this, v9), 3, null);
                return;
            }
            else if(PointerEventType.equals-impl0(v7, PointerEventType.Companion.getExit-7fucELk())) {
                BuildersKt.launch$default(this.getCoroutineScope(), null, null, new HoverableNode$onPointerEvent$2(this, v9), 3, null);
            }
        }
    }

    private final void tryEmitExit() {
        Enter v0 = this.hoverInteraction;
        if(v0 != null) {
            this.interactionSource.tryEmit(new Exit(v0));
            this.hoverInteraction = null;
        }
    }

    public final void updateInteractionSource(MutableInteractionSource arg2) {
        if(!Intrinsics.areEqual(this.interactionSource, arg2)) {
            this.tryEmitExit();
            this.interactionSource = arg2;
        }
    }
}

