package androidx.navigationevent.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import androidx.navigationevent.NavigationEventTransitionState$Idle;
import androidx.navigationevent.NavigationEventTransitionState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B1\b\u0000\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tR+\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000B8F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R7\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0004\u001A\u00028\u00002\u0006\u0010\n\u001A\u00028\u00008F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\u0012\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR7\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068F@@X\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u001F\u0010\u0012\u001A\u0004\b\u001D\u0010\u0014\"\u0004\b\u001E\u0010\u0016R$\u0010 \u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010!X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2={"Landroidx/navigationevent/compose/NavigationEventState;", "T", "Landroidx/navigationevent/NavigationEventInfo;", "", "currentInfo", "backInfo", "", "forwardInfo", "<init>", "(Landroidx/navigationevent/NavigationEventInfo;Ljava/util/List;Ljava/util/List;)V", "<set-?>", "Landroidx/navigationevent/NavigationEventTransitionState;", "transitionState", "getTransitionState", "()Landroidx/navigationevent/NavigationEventTransitionState;", "setTransitionState$navigationevent_compose", "(Landroidx/navigationevent/NavigationEventTransitionState;)V", "transitionState$delegate", "Landroidx/compose/runtime/MutableState;", "getBackInfo", "()Ljava/util/List;", "setBackInfo$navigationevent_compose", "(Ljava/util/List;)V", "backInfo$delegate", "getCurrentInfo", "()Landroidx/navigationevent/NavigationEventInfo;", "setCurrentInfo$navigationevent_compose", "(Landroidx/navigationevent/NavigationEventInfo;)V", "currentInfo$delegate", "getForwardInfo", "setForwardInfo$navigationevent_compose", "forwardInfo$delegate", "sourceHandler", "Landroidx/navigationevent/NavigationEventHandler;", "getSourceHandler$navigationevent_compose", "()Landroidx/navigationevent/NavigationEventHandler;", "setSourceHandler$navigationevent_compose", "(Landroidx/navigationevent/NavigationEventHandler;)V", "navigationevent-compose"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationEventState {
    public static final int $stable;
    private final MutableState backInfo$delegate;
    private final MutableState currentInfo$delegate;
    private final MutableState forwardInfo$delegate;
    private NavigationEventHandler sourceHandler;
    private final MutableState transitionState$delegate;

    static {
    }

    public NavigationEventState(NavigationEventInfo arg4, List arg5, List arg6) {
        super();
        this.transitionState$delegate = SnapshotStateKt.mutableStateOf$default(Idle.INSTANCE, null, 2, null);
        this.backInfo$delegate = SnapshotStateKt.mutableStateOf$default(arg5, null, 2, null);
        this.currentInfo$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.forwardInfo$delegate = SnapshotStateKt.mutableStateOf$default(arg6, null, 2, null);
    }

    public NavigationEventState(NavigationEventInfo arg1, List arg2, List arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        if((arg4 & 4) != 0) {
            arg3 = CollectionsKt.emptyList();
        }

        this(arg1, arg2, arg3);
    }

    public final List getBackInfo() {
        return this.backInfo$delegate.getValue();
    }

    public final NavigationEventInfo getCurrentInfo() {
        return this.currentInfo$delegate.getValue();
    }

    public final List getForwardInfo() {
        return this.forwardInfo$delegate.getValue();
    }

    public final NavigationEventHandler getSourceHandler$navigationevent_compose() {
        return this.sourceHandler;
    }

    public final NavigationEventTransitionState getTransitionState() {
        return this.transitionState$delegate.getValue();
    }

    public final void setBackInfo$navigationevent_compose(List arg1) {
        this.backInfo$delegate.setValue(arg1);
    }

    public final void setCurrentInfo$navigationevent_compose(NavigationEventInfo arg1) {
        this.currentInfo$delegate.setValue(arg1);
    }

    public final void setForwardInfo$navigationevent_compose(List arg1) {
        this.forwardInfo$delegate.setValue(arg1);
    }

    public final void setSourceHandler$navigationevent_compose(NavigationEventHandler arg1) {
        this.sourceHandler = arg1;
    }

    public final void setTransitionState$navigationevent_compose(NavigationEventTransitionState arg1) {
        this.transitionState$delegate.setValue(arg1);
    }
}

