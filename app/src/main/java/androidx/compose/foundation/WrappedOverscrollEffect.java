package androidx.compose.foundation;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\f2\u0012\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J<\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\"\u0010\u0015\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0096@¢\u0006\u0004\b\u0019\u0010\u001AJ\u0013\u0010!\u001A\u00020\u00032\b\u0010\"\u001A\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010#\u001A\u00020$H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001B\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u001EX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u0006%"}, d2={"Landroidx/compose/foundation/WrappedOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "attachNode", "", "eventHandlingEnabled", "innerOverscrollEffect", "<init>", "(ZZLandroidx/compose/foundation/OverscrollEffect;)V", "applyToScroll", "Landroidx/compose/ui/geometry/Offset;", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInProgress", "()Z", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "equals", "other", "hashCode", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class WrappedOverscrollEffect implements OverscrollEffect {
    private final boolean attachNode;
    private final boolean eventHandlingEnabled;
    private final OverscrollEffect innerOverscrollEffect;
    private final DelegatableNode node;

    public WrappedOverscrollEffect(boolean arg1, boolean arg2, OverscrollEffect arg3) {
        WrappedOverscrollEffect$node$1 v1_1;
        super();
        this.attachNode = arg1;
        this.eventHandlingEnabled = arg2;
        this.innerOverscrollEffect = arg3;
        if(arg1) {
            DelegatableNode v1 = arg3.getNode();
        }
        else {
            v1_1 = new WrappedOverscrollEffect$node$1();
        }

        this.node = ((DelegatableNode)v1_1);
    }

    public Object applyToFling-BMRW4eQ(long arg2, Function2 arg4, Continuation arg5) {
        Object v1;
        if(this.eventHandlingEnabled) {
            v1 = this.innerOverscrollEffect.applyToFling-BMRW4eQ(arg2, arg4, arg5);
            if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return v1;
            }

            return Unit.INSTANCE;
        }

        v1 = arg4.invoke(Velocity.box-impl(arg2), arg5);
        if(v1 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v1;
        }

        return Unit.INSTANCE;
    }

    public long applyToScroll-Rhakbz0(long arg2, int arg4, Function1 arg5) {
        if(this.eventHandlingEnabled) {
            return this.innerOverscrollEffect.applyToScroll-Rhakbz0(arg2, arg4, arg5);
        }

        return arg5.invoke(Offset.box-impl(arg2)).unbox-impl();
    }

    public boolean equals(Object arg5) {
        if(this == (((WrappedOverscrollEffect)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof WrappedOverscrollEffect)) {
            return 0;
        }

        if(this.attachNode != ((WrappedOverscrollEffect)arg5).attachNode) {
            return 0;
        }

        if(this.eventHandlingEnabled != ((WrappedOverscrollEffect)arg5).eventHandlingEnabled) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.innerOverscrollEffect, ((WrappedOverscrollEffect)arg5).innerOverscrollEffect)) {
            return 0;
        }

        return 1;
    }

    public DelegatableNode getNode() {
        return this.node;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.attachNode) * 0x1F + Boolean.hashCode(this.eventHandlingEnabled)) * 0x1F + this.innerOverscrollEffect.hashCode();
    }

    public boolean isInProgress() {
        return this.innerOverscrollEffect.isInProgress();
    }
}

