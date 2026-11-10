package androidx.compose.ui.layout;

import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\f\u0010\n\u001A\u00020\u0004*\u00020\u0004H\u0016R\"\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0018\u0010\u000B\u001A\u00020\u0004*\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2={"Landroidx/compose/ui/layout/LookaheadScopeImpl;", "Landroidx/compose/ui/layout/LookaheadScope;", "scopeCoordinates", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getScopeCoordinates", "()Lkotlin/jvm/functions/Function0;", "setScopeCoordinates", "toLookaheadCoordinates", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LookaheadScopeImpl implements LookaheadScope {
    public static final int $stable = 8;
    private Function0 scopeCoordinates;

    static {
    }

    public LookaheadScopeImpl() {
        this(null, 1, null);
    }

    public LookaheadScopeImpl(Function0 arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public LookaheadScopeImpl(Function0 arg1) {
        super();
        this.scopeCoordinates = arg1;
    }

    public LayoutCoordinates getLookaheadScopeCoordinates(PlacementScope arg1) {
        Function0 v0 = this.scopeCoordinates;
        Intrinsics.checkNotNull(v0);
        return v0.invoke();
    }

    public final Function0 getScopeCoordinates() {
        return this.scopeCoordinates;
    }

    public final void setScopeCoordinates(Function0 arg1) {
        this.scopeCoordinates = arg1;
    }

    public LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates arg1) {
        LayoutCoordinates v0 = (arg1 instanceof LookaheadLayoutCoordinates) ? arg1 : null;
        if(v0 != null) {
            return v0;
        }

        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        LookaheadDelegate v0_1 = ((NodeCoordinator)arg1).getLookaheadDelegate();
        if(v0_1 != null) {
            LookaheadLayoutCoordinates v0_2 = v0_1.getLookaheadLayoutCoordinates();
            if(v0_2 != null) {
                return ((LayoutCoordinates)v0_2);
            }
        }

        return arg1;
    }
}

