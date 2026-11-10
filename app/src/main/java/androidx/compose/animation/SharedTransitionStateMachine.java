package androidx.compose.animation;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001BB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001A\u00020!J\u000E\u00100\u001A\u00020!2\u0006\u00101\u001A\u00020\u001FJ\u0006\u00102\u001A\u00020!J\u000E\u00103\u001A\u00020!2\u0006\u00104\u001A\u00020\tJ\u0006\u00105\u001A\u00020!J\r\u00106\u001A\u00020!H\u0000¢\u0006\u0002\b7J\b\u00108\u001A\u0004\u0018\u000109J%\u0010:\u001A\u00020!2\u0006\u0010;\u001A\u00020<2\u0006\u0010=\u001A\u00020>2\u0006\u0010?\u001A\u00020>¢\u0006\u0004\b@\u0010AR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR+\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u0017\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u00168B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u000E\u0010\u001E\u001A\u00020\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u001A\u0010\"\u001A\b\u0012\u0004\u0012\u00020$0#8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b%\u0010&R\u001A\u0010\'\u001A\b\u0012\u0004\u0012\u00020$0#8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b(\u0010&R\u0010\u0010)\u001A\u0004\u0018\u00010*X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010+\u001A\u00020\u00162\u0006\u0010\f\u001A\u00020\u00168B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b.\u0010\u001D\u001A\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001BR\u000E\u0010/\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006C"}, d2={"Landroidx/compose/animation/SharedTransitionStateMachine;", "", "sharedElement", "Landroidx/compose/animation/SharedElement;", "<init>", "(Landroidx/compose/animation/SharedElement;)V", "getSharedElement", "()Landroidx/compose/animation/SharedElement;", "activeMatchDeferred", "", "getActiveMatchDeferred", "()Z", "<set-?>", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "state", "getState", "()Landroidx/compose/animation/SharedTransitionStateMachine$State;", "setState", "(Landroidx/compose/animation/SharedTransitionStateMachine$State;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "lastHandledRequestId", "", "requestId", "getRequestId", "()I", "setRequestId", "(I)V", "requestId$delegate", "Landroidx/compose/runtime/MutableIntState;", "requestToBeHandled", "Landroidx/compose/animation/StateChangeRequest;", "resetState", "", "allEntries", "", "Landroidx/compose/animation/SharedElementEntry;", "getAllEntries", "()Ljava/util/List;", "enabledEntries", "getEnabledEntries", "targetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "targetBoundsProviderUpdateRequestId", "getTargetBoundsProviderUpdateRequestId", "setTargetBoundsProviderUpdateRequestId", "targetBoundsProviderUpdateRequestId$delegate", "lastHandledTargetProviderUpdateRequestId", "deferRequest", "request", "processPendingRequest", "checkForAndDeferStateUpdates", "hasVisibleContent", "invalidateTargetBoundsProvider", "updateTargetBoundsProvider", "updateTargetBoundsProvider$animation", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "configureActiveMatch", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-L7TYDSY", "(JJJ)V", "State", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedTransitionStateMachine {
    @Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\tH\u0016J\u0012\u0010\u0015\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001A\u00020\u0000H&J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\t2\u0006\u0010\u001A\u001A\u00020\u001BH\u0016J7\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u00172\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020!H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000F\u0082\u0001\u0003%&\'¨\u0006("}, d2={"Landroidx/compose/animation/SharedTransitionStateMachine$State;", "", "<init>", "()V", "targetData", "Landroidx/compose/animation/TargetData;", "getTargetData", "()Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "matchIsOrHasBeenConfigured", "getMatchIsOrHasBeenConfigured", "updateBounds", "", "bounds", "onMatchFound", "previousTargetBoundsProvider", "Landroidx/compose/animation/BoundsProvider;", "onVisibleContentRemovedDuringTransition", "initializeCurrentBounds", "sharedElement", "Landroidx/compose/animation/SharedElement;", "configureActiveMatch", "targetBoundsProvider", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "Landroidx/compose/animation/ActiveMatchFoundConfigPending;", "Landroidx/compose/animation/MatchIsOrHasBeenConfigured;", "Landroidx/compose/animation/NoMatchFound;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class State {
        public static final int $stable;

        static {
        }

        public State(DefaultConstructorMarker arg1) {
            this();
        }

        private State() {
            super();
        }

        public State configureActiveMatch-38uP1EE(SharedElement arg1, BoundsProvider arg2, long arg3, long arg5, long arg7) {
            throw new IllegalStateException("Active match can only be configured in ActiveMatchFoundConfigPending or ActiveMatchConfigured state. Current state: " + this.toString());
        }

        public boolean getActiveMatchFound() {
            return 0;
        }

        public Rect getCurrentBounds() {
            return null;
        }

        public boolean getMatchIsOrHasBeenConfigured() {
            return 0;
        }

        public TargetData getTargetData() {
            return null;
        }

        public Rect initializeCurrentBounds(SharedElement arg1) {
            return this.getCurrentBounds();
        }

        public abstract State onMatchFound(BoundsProvider arg1);

        public abstract State onVisibleContentRemovedDuringTransition();

        public void updateBounds(Rect arg1) {
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StateChangeRequest.values().length];
            try {
                v0[StateChangeRequest.NoMatchFound.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StateChangeRequest.NoRequest.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StateChangeRequest.MatchFound.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StateChangeRequest.VisibleContentAbsentDuringTransition.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 8;
    private int lastHandledRequestId;
    private int lastHandledTargetProviderUpdateRequestId;
    private final MutableIntState requestId$delegate;
    private StateChangeRequest requestToBeHandled;
    private final SharedElement sharedElement;
    private final MutableState state$delegate;
    private BoundsProvider targetBoundsProvider;
    private final MutableIntState targetBoundsProviderUpdateRequestId$delegate;

    static {
    }

    public SharedTransitionStateMachine(SharedElement arg3) {
        super();
        this.sharedElement = arg3;
        this.state$delegate = SnapshotStateKt.mutableStateOf$default(NoMatchFound.INSTANCE, null, 2, null);
        this.requestId$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.requestToBeHandled = StateChangeRequest.NoRequest;
        this.targetBoundsProviderUpdateRequestId$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public final void checkForAndDeferStateUpdates(boolean arg3) {
        if(this.getEnabledEntries().size() > 1 && (arg3)) {
            this.deferRequest(StateChangeRequest.MatchFound);
        }
        else if(!this.sharedElement.getScope().isTransitionActive()) {
            this.resetState();
        }
        else if(!arg3) {
            this.deferRequest(StateChangeRequest.VisibleContentAbsentDuringTransition);
        }

        this.invalidateTargetBoundsProvider();
    }

    public final void configureActiveMatch-L7TYDSY(long arg10, long arg12, long arg14) {
        State v0 = this.getState();
        SharedElement v1 = this.sharedElement;
        BoundsProvider v2 = this.targetBoundsProvider;
        Intrinsics.checkNotNull(v2);
        this.setState(v0.configureActiveMatch-38uP1EE(v1, v2, arg10, arg12, arg14));
    }

    public final void deferRequest(StateChangeRequest arg1) {
        this.requestToBeHandled = arg1;
        this.setRequestId(this.lastHandledRequestId + 1);
    }

    public final boolean getActiveMatchDeferred() {
        if(this.requestToBeHandled == StateChangeRequest.MatchFound) {
            return 1;
        }

        return 0;
    }

    private final List getAllEntries() {
        return this.sharedElement.getAllEntries();
    }

    private final List getEnabledEntries() {
        return this.sharedElement.getEnabledEntries();
    }

    private final int getRequestId() {
        return this.requestId$delegate.getIntValue();
    }

    public final SharedElement getSharedElement() {
        return this.sharedElement;
    }

    public final State getState() {
        return this.state$delegate.getValue();
    }

    private final int getTargetBoundsProviderUpdateRequestId() {
        return this.targetBoundsProviderUpdateRequestId$delegate.getIntValue();
    }

    public final void invalidateTargetBoundsProvider() {
        Object v4;
        Object v3;
        List v0 = this.getEnabledEntries();
        int v1 = v0.size();
        int v2 = 0;
        while(true) {
            v3 = null;
            if(v2 < v1) {
                v4 = v0.get(v2);
                if(v4.getTarget()) {
                }
                else {
                    ++v2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_14;
        }

        v4 = v3;
    label_14:
        if(v4 != null || this.targetBoundsProvider != null) {
            if(v4 != null) {
                BoundsProvider v3_1 = ((SharedElementEntry)v4).getBoundsProvider();
            }

            if(!Intrinsics.areEqual(v3_1, this.targetBoundsProvider)) {
                goto label_24;
            }
        }
        else {
        }

        return;
    label_24:
        this.setTargetBoundsProviderUpdateRequestId(this.lastHandledTargetProviderUpdateRequestId + 1);
    }

    public final void processPendingRequest() {
        State v0_3;
        NoMatchFound v0_2;
        if(this.getRequestId() != this.lastHandledRequestId) {
            this.lastHandledRequestId = this.getRequestId();
            int v0 = WhenMappings.$EnumSwitchMapping$0[this.requestToBeHandled.ordinal()];
            if(v0 == 1) {
                v0_2 = NoMatchFound.INSTANCE;
            }
            else if(v0 == 2) {
                v0_3 = this.getState();
            }
            else if(v0 == 3) {
                v0_3 = this.getState().onMatchFound(this.targetBoundsProvider);
            }
            else if(v0 == 4) {
                List v0_1 = this.getEnabledEntries();
                int v1 = v0_1.size();
                int v2 = 0;
                while(true) {
                    if(v2 >= v1) {
                        break;
                    }
                    else if(Intrinsics.areEqual(v0_1.get(v2).getBoundsProvider(), this.targetBoundsProvider)) {
                        v0_2 = NoMatchFound.INSTANCE;
                    }
                    else {
                        ++v2;
                        continue;
                    }

                    goto label_44;
                }

                v0_3 = this.getState().onVisibleContentRemovedDuringTransition();
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

        label_44:
            this.setState(((State)v0_2));
            this.requestToBeHandled = StateChangeRequest.NoRequest;
        }

        this.updateTargetBoundsProvider$animation();
    }

    public final void resetState() {
        this.requestToBeHandled = StateChangeRequest.NoRequest;
        this.lastHandledRequestId = this.getRequestId();
        this.setState(NoMatchFound.INSTANCE);
    }

    private final void setRequestId(int arg1) {
        this.requestId$delegate.setIntValue(arg1);
    }

    private final void setState(State arg1) {
        this.state$delegate.setValue(arg1);
    }

    private final void setTargetBoundsProviderUpdateRequestId(int arg1) {
        this.targetBoundsProviderUpdateRequestId$delegate.setIntValue(arg1);
    }

    public final Rect tryInitializingCurrentBounds() {
        this.processPendingRequest();
        return this.getState().initializeCurrentBounds(this.sharedElement);
    }

    public final void updateTargetBoundsProvider$animation() {
        BoundsProvider v2_1;
        Object v4;
        int v3;
        List v0;
        if(this.getTargetBoundsProviderUpdateRequestId() != this.lastHandledTargetProviderUpdateRequestId) {
            int v1 = 0;
            Object v2 = null;
            if(this.sharedElement.getScope().isTransitionActive()) {
                v0 = this.getEnabledEntries();
                v3 = v0.size();
                while(true) {
                    if(v1 < v3) {
                        v4 = v0.get(v1);
                        if(v4.getTarget()) {
                        }
                        else {
                            ++v1;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_21;
                }

                v4 = v2;
            label_21:
                if(v4 == null) {
                    goto label_38;
                }

                v2_1 = ((SharedElementEntry)v4).getBoundsProvider();
            }
            else {
                v0 = this.getAllEntries();
                v3 = v0.size();
                while(true) {
                    if(v1 < v3) {
                        v4 = v0.get(v1);
                        if(v4.getTarget()) {
                        }
                        else {
                            ++v1;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_36;
                }

                v4 = v2;
            label_36:
                if(v4 == null) {
                    goto label_38;
                }

                v2_1 = ((SharedElementEntry)v4).getBoundsProvider();
            }

        label_38:
            if(!Intrinsics.areEqual(v2_1, this.targetBoundsProvider)) {
                this.targetBoundsProvider = v2_1;
            }

            this.lastHandledTargetProviderUpdateRequestId = this.getTargetBoundsProviderUpdateRequestId();
        }
    }
}

