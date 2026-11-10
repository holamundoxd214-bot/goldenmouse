package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001BT\u0012K\u0010\u0002\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003¢\u0006\u0004\b\f\u0010\rJ?\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00192\'\u0010\u001A\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\u001C\u0012\u0006\u0012\u0004\u0018\u00010\u001D0\u001B¢\u0006\u0002\b\u001EH\u0096@¢\u0006\u0002\u0010\u001FRV\u0010\u0002\u001AG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006\""}, d2={"Landroidx/compose/foundation/gestures/DefaultTransformableState;", "Landroidx/compose/foundation/gestures/TransformableState;", "onTransformation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "zoomChange", "Landroidx/compose/ui/geometry/Offset;", "panChange", "rotationChange", "", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "getOnTransformation", "()Lkotlin/jvm/functions/Function3;", "transformScope", "Landroidx/compose/foundation/gestures/TransformScope;", "transformMutex", "Landroidx/compose/foundation/MutatorMutex;", "isTransformingState", "Landroidx/compose/runtime/MutableState;", "", "transform", "transformPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTransformInProgress", "()Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class DefaultTransformableState implements TransformableState {
    private final MutableState isTransformingState;
    private final Function3 onTransformation;
    private final MutatorMutex transformMutex;
    private final TransformScope transformScope;

    public DefaultTransformableState(Function3 arg3) {
        super();
        this.onTransformation = arg3;
        this.transformScope = new DefaultTransformableState$transformScope$1(this);
        this.transformMutex = new MutatorMutex();
        this.isTransformingState = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
    }

    public static final MutatorMutex access$getTransformMutex$p(DefaultTransformableState arg0) {
        return arg0.transformMutex;
    }

    public static final TransformScope access$getTransformScope$p(DefaultTransformableState arg0) {
        return arg0.transformScope;
    }

    public static final MutableState access$isTransformingState$p(DefaultTransformableState arg0) {
        return arg0.isTransformingState;
    }

    public final Function3 getOnTransformation() {
        return this.onTransformation;
    }

    public boolean isTransformInProgress() {
        return this.isTransformingState.getValue().booleanValue();
    }

    public Object transform(MutatePriority arg3, Function2 arg4, Continuation arg5) {
        Object v2 = CoroutineScopeKt.coroutineScope(new DefaultTransformableState$transform$2(this, arg3, arg4, null), arg5);
        if(v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v2;
        }

        return Unit.INSTANCE;
    }
}

