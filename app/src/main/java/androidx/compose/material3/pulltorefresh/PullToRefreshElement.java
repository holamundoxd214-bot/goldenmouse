package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001A\u00020\u0004\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0018\u001A\u00020\u0002H\u0016J\u0010\u0010\u0019\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0002H\u0016J\f\u0010\u001B\u001A\u00020\u0007*\u00020\u001CH\u0016J\u0013\u0010\u001D\u001A\u00020\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001FH\u0096\u0002J\b\u0010 \u001A\u00020!H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0003\u0010\u000FR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000B\u001A\u00020\f¢\u0006\n\n\u0002\u0010\u0017\u001A\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/material3/pulltorefresh/PullToRefreshElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshModifierNode;", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "", "enabled", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "threshold", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getOnRefresh", "()Lkotlin/jvm/functions/Function0;", "getEnabled", "getState", "()Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "getThreshold-D9Ej5fM", "()F", "F", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PullToRefreshElement extends ModifierNodeElement {
    public static final int $stable;
    private final boolean enabled;
    private final boolean isRefreshing;
    private final Function0 onRefresh;
    private final PullToRefreshState state;
    private final float threshold;

    static {
    }

    private PullToRefreshElement(boolean arg1, Function0 arg2, boolean arg3, PullToRefreshState arg4, float arg5) {
        super();
        this.isRefreshing = arg1;
        this.onRefresh = arg2;
        this.enabled = arg3;
        this.state = arg4;
        this.threshold = arg5;
    }

    public PullToRefreshElement(boolean arg1, Function0 arg2, boolean arg3, PullToRefreshState arg4, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    public PullToRefreshModifierNode create() {
        return new PullToRefreshModifierNode(this.isRefreshing, this.onRefresh, this.enabled, this.state, this.threshold, null);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((PullToRefreshElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof PullToRefreshElement)) {
            return 0;
        }

        if(this.isRefreshing != ((PullToRefreshElement)arg5).isRefreshing) {
            return 0;
        }

        if(this.enabled != ((PullToRefreshElement)arg5).enabled) {
            return 0;
        }

        if(this.onRefresh != ((PullToRefreshElement)arg5).onRefresh) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.state, ((PullToRefreshElement)arg5).state)) {
            return 0;
        }

        if(!Dp.equals-impl0(this.threshold, ((PullToRefreshElement)arg5).threshold)) {
            return 0;
        }

        return 1;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final Function0 getOnRefresh() {
        return this.onRefresh;
    }

    public final PullToRefreshState getState() {
        return this.state;
    }

    public final float getThreshold-D9Ej5fM() {
        return this.threshold;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isRefreshing) * 0x1F + Boolean.hashCode(this.enabled)) * 0x1F + this.onRefresh.hashCode()) * 0x1F + this.state.hashCode()) * 0x1F + Dp.hashCode-impl(this.threshold);
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("PullToRefreshModifierNode");
        arg4.getProperties().set("isRefreshing", Boolean.valueOf(this.isRefreshing));
        arg4.getProperties().set("onRefresh", this.onRefresh);
        arg4.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        arg4.getProperties().set("state", this.state);
        arg4.getProperties().set("threshold", Dp.box-impl(this.threshold));
    }

    public final boolean isRefreshing() {
        return this.isRefreshing;
    }

    public void update(PullToRefreshModifierNode arg2) {
        arg2.setOnRefresh(this.onRefresh);
        arg2.setEnabled(this.enabled);
        arg2.setState(this.state);
        arg2.setThreshold-0680j_4(this.threshold);
        boolean v0 = arg2.isRefreshing();
        boolean v1 = this.isRefreshing;
        if(v0 != v1) {
            arg2.setRefreshing(v1);
            arg2.update();
        }
    }

    public void update(Node arg1) {
        this.update(((PullToRefreshModifierNode)arg1));
    }
}

