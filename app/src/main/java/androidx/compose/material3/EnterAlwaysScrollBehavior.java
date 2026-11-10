package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u000BX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0018R\u001A\u0010\u001A\u001A\u00020\u001BX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2={"Landroidx/compose/material3/EnterAlwaysScrollBehavior;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "canScroll", "Lkotlin/Function0;", "", "reverseLayout", "<init>", "(Landroidx/compose/material3/TopAppBarState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function0;Z)V", "getState", "()Landroidx/compose/material3/TopAppBarState;", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "getReverseLayout", "()Z", "isPinned", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setNestedScrollConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class EnterAlwaysScrollBehavior implements TopAppBarScrollBehavior {
    private final Function0 canScroll;
    private final DecayAnimationSpec flingAnimationSpec;
    private final boolean isPinned;
    private NestedScrollConnection nestedScrollConnection;
    private final boolean reverseLayout;
    private final AnimationSpec snapAnimationSpec;
    private final TopAppBarState state;

    public EnterAlwaysScrollBehavior(TopAppBarState arg1, AnimationSpec arg2, DecayAnimationSpec arg3, Function0 arg4, boolean arg5) {
        super();
        this.state = arg1;
        this.snapAnimationSpec = arg2;
        this.flingAnimationSpec = arg3;
        this.canScroll = arg4;
        this.reverseLayout = arg5;
        this.nestedScrollConnection = new EnterAlwaysScrollBehavior$nestedScrollConnection$1(this);
    }

    public EnterAlwaysScrollBehavior(TopAppBarState arg7, AnimationSpec arg8, DecayAnimationSpec arg9, Function0 arg10, boolean arg11, int arg12, DefaultConstructorMarker arg13) {
        EnterAlwaysScrollBehavior$$ExternalSyntheticLambda0 v10;
        if((arg12 & 8) != 0) {
            v10 = new EnterAlwaysScrollBehavior$$ExternalSyntheticLambda0();
        }

        this(arg7, arg8, arg9, ((Function0)v10), false);
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

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public AnimationSpec getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public TopAppBarState getState() {
        return this.state;
    }

    public boolean isPinned() {
        return this.isPinned;
    }

    public void setNestedScrollConnection(NestedScrollConnection arg1) {
        this.nestedScrollConnection = arg1;
    }
}

