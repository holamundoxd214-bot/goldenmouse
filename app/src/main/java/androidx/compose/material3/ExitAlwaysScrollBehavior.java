package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u000BX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2={"Landroidx/compose/material3/ExitAlwaysScrollBehavior;", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "state", "Landroidx/compose/material3/BottomAppBarState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "canScroll", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/material3/BottomAppBarState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function0;)V", "getState", "()Landroidx/compose/material3/BottomAppBarState;", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "isPinned", "()Z", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setNestedScrollConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ExitAlwaysScrollBehavior implements BottomAppBarScrollBehavior {
    private final Function0 canScroll;
    private final DecayAnimationSpec flingAnimationSpec;
    private final boolean isPinned;
    private NestedScrollConnection nestedScrollConnection;
    private final AnimationSpec snapAnimationSpec;
    private final BottomAppBarState state;

    public ExitAlwaysScrollBehavior(BottomAppBarState arg1, AnimationSpec arg2, DecayAnimationSpec arg3, Function0 arg4) {
        super();
        this.state = arg1;
        this.snapAnimationSpec = arg2;
        this.flingAnimationSpec = arg3;
        this.canScroll = arg4;
        this.nestedScrollConnection = new ExitAlwaysScrollBehavior$nestedScrollConnection$1(this);
    }

    public ExitAlwaysScrollBehavior(BottomAppBarState arg1, AnimationSpec arg2, DecayAnimationSpec arg3, Function0 arg4, int arg5, DefaultConstructorMarker arg6) {
        ExitAlwaysScrollBehavior$$ExternalSyntheticLambda0 v4;
        if((arg5 & 8) != 0) {
            v4 = new ExitAlwaysScrollBehavior$$ExternalSyntheticLambda0();
        }

        this(arg1, arg2, arg3, ((Function0)v4));
    }

    static final boolean _init_$lambda$0() {
        return 1;
    }

    public final Function0 getCanScroll() {
        return this.canScroll;
    }

    public DecayAnimationSpec getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    public AnimationSpec getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public BottomAppBarState getState() {
        return this.state;
    }

    public boolean isPinned() {
        return this.isPinned;
    }

    public void setNestedScrollConnection(NestedScrollConnection arg1) {
        this.nestedScrollConnection = arg1;
    }
}

