package androidx.compose.foundation.text;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\f\u001A\u00020\rH\u0086@¢\u0006\u0002\u0010\u000ER\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000F\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001A\u00020\u00108F¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2={"Landroidx/compose/foundation/text/LinkStateInteractionSourceObserver;", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "Focused", "", "Hovered", "Pressed", "interactionState", "Landroidx/compose/runtime/MutableIntState;", "collectInteractionsForLinks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFocused", "", "()Z", "isHovered", "isPressed", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LinkStateInteractionSourceObserver {
    public static final int $stable;
    private final int Focused;
    private final int Hovered;
    private final int Pressed;
    private final InteractionSource interactionSource;
    private final MutableIntState interactionState;

    static {
    }

    public LinkStateInteractionSourceObserver(InteractionSource arg1) {
        super();
        this.interactionSource = arg1;
        this.Focused = 1;
        this.Hovered = 2;
        this.Pressed = 4;
        this.interactionState = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final int access$getFocused$p(LinkStateInteractionSourceObserver arg0) {
        return arg0.Focused;
    }

    public static final int access$getHovered$p(LinkStateInteractionSourceObserver arg0) {
        return arg0.Hovered;
    }

    public static final MutableIntState access$getInteractionState$p(LinkStateInteractionSourceObserver arg0) {
        return arg0.interactionState;
    }

    public static final int access$getPressed$p(LinkStateInteractionSourceObserver arg0) {
        return arg0.Pressed;
    }

    public final Object collectInteractionsForLinks(Continuation arg5) {
        Object v4 = this.interactionSource.getInteractions().collect(new LinkStateInteractionSourceObserver$collectInteractionsForLinks$2(new MutableObjectList(0, 1, null), this), arg5);
        if(v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }

        return Unit.INSTANCE;
    }

    public final boolean isFocused() {
        if((this.Focused & this.interactionState.getIntValue()) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isHovered() {
        if((this.Hovered & this.interactionState.getIntValue()) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isPressed() {
        if((this.Pressed & this.interactionState.getIntValue()) != 0) {
            return 1;
        }

        return 0;
    }
}

