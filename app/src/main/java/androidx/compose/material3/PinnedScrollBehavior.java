package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001C\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u001C\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0019X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2={"Landroidx/compose/material3/PinnedScrollBehavior;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;)V", "getState", "()Landroidx/compose/material3/TopAppBarState;", "getCanScroll", "()Lkotlin/jvm/functions/Function0;", "isPinned", "()Z", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setNestedScrollConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class PinnedScrollBehavior implements TopAppBarScrollBehavior {
    private final Function0 canScroll;
    private final DecayAnimationSpec flingAnimationSpec;
    private final boolean isPinned;
    private NestedScrollConnection nestedScrollConnection;
    private final AnimationSpec snapAnimationSpec;
    private final TopAppBarState state;

    public PinnedScrollBehavior(TopAppBarState arg1, Function0 arg2) {
        super();
        this.state = arg1;
        this.canScroll = arg2;
        this.isPinned = true;
        this.nestedScrollConnection = new PinnedScrollBehavior$nestedScrollConnection$1(this);
    }

    public PinnedScrollBehavior(TopAppBarState arg1, Function0 arg2, int arg3, DefaultConstructorMarker arg4) {
        PinnedScrollBehavior$$ExternalSyntheticLambda0 v2;
        if((arg3 & 2) != 0) {
            v2 = new PinnedScrollBehavior$$ExternalSyntheticLambda0();
        }

        this(arg1, ((Function0)v2));
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

