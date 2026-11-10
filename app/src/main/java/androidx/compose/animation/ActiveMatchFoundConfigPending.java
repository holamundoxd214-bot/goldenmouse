package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001B\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001C\u001A\u00020\u001DH\u0016J7\u0010\u001E\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020#2\u0006\u0010$\u001A\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0012\u0010\'\u001A\u00020\u00012\b\u0010(\u001A\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0007H\u0016J\b\u0010,\u001A\u00020\u0001H\u0016R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R/\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\u0014\u001A\u0004\u0018\u00010\u00078V@RX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2={"Landroidx/compose/animation/ActiveMatchFoundConfigPending;", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "targetBoundsProviderBeforeConfig", "Landroidx/compose/animation/BoundsProvider;", "targetData", "Landroidx/compose/animation/TargetData;", "currentBounds", "Landroidx/compose/ui/geometry/Rect;", "<init>", "(Landroidx/compose/animation/BoundsProvider;Landroidx/compose/animation/TargetData;Landroidx/compose/ui/geometry/Rect;)V", "getTargetBoundsProviderBeforeConfig", "()Landroidx/compose/animation/BoundsProvider;", "setTargetBoundsProviderBeforeConfig", "(Landroidx/compose/animation/BoundsProvider;)V", "getTargetData", "()Landroidx/compose/animation/TargetData;", "activeMatchFound", "", "getActiveMatchFound", "()Z", "<set-?>", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "setCurrentBounds", "(Landroidx/compose/ui/geometry/Rect;)V", "currentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "initializeCurrentBounds", "sharedElement", "Landroidx/compose/animation/SharedElement;", "configureActiveMatch", "targetBoundsProvider", "lookaheadSize", "Landroidx/compose/ui/geometry/Size;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "structuralOffset", "configureActiveMatch-38uP1EE", "(Landroidx/compose/animation/SharedElement;Landroidx/compose/animation/BoundsProvider;JJJ)Landroidx/compose/animation/SharedTransitionStateMachine$State;", "onMatchFound", "previousTargetBoundsProvider", "updateBounds", "", "bounds", "onVisibleContentRemovedDuringTransition", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ActiveMatchFoundConfigPending extends State {
    public static final int $stable = 8;
    private final MutableState currentBounds$delegate;
    private BoundsProvider targetBoundsProviderBeforeConfig;
    private final TargetData targetData;

    static {
    }

    public ActiveMatchFoundConfigPending(BoundsProvider arg2, TargetData arg3, Rect arg4) {
        super(null);
        this.targetBoundsProviderBeforeConfig = arg2;
        this.targetData = arg3;
        this.currentBounds$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
    }

    public ActiveMatchFoundConfigPending(BoundsProvider arg2, TargetData arg3, Rect arg4, int arg5, DefaultConstructorMarker arg6) {
        TargetData v0 = null;
        if((arg5 & 2) != 0) {
            arg3 = v0;
        }

        if((arg5 & 4) != 0) {
            arg4 = ((Rect)v0);
        }

        this(arg2, arg3, arg4);
    }

    public State configureActiveMatch-38uP1EE(SharedElement arg11, BoundsProvider arg12, long arg13, long arg15, long arg17) {
        long v5_1;
        Object v6;
        Object v5;
        TargetData v0 = this.getTargetData();
        if(v0 == null) {
            v0 = new TargetData(arg13, Offset.minus-MK-Hz9U(arg15, arg17), arg17, null);
        }

        Rect v1 = this.getCurrentBounds();
        if(v1 == null) {
            BoundsProvider v10 = this.targetBoundsProviderBeforeConfig;
            if(v10 == null) {
                List v10_1 = arg11.getAllEntries();
                int v1_1 = v10_1.size();
                int v4 = 0;
                while(true) {
                    v5 = null;
                    if(v4 < v1_1) {
                        v6 = v10_1.get(v4);
                        if(arg11.getEnabledEntries().contains(v6)) {
                        }
                        else {
                            ++v4;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_28;
                }

                v6 = v5;
            label_28:
                if(v6 != null) {
                    v10 = ((SharedElementEntry)v6).getBoundsProvider();
                    goto label_32;
                }

                v10 = ((BoundsProvider)v5);
            }

        label_32:
            v1 = SharedTransitionStateMachineKt.access$obtainBoundsFromLastTarget(arg11, v10);
            if(v1 != null) {
                goto label_37;
            }

            v5_1 = arg15;
            v1 = RectKt.Rect-tz77jQw(v5_1, arg13);
        }
        else {
        label_37:
            v5_1 = arg15;
        }

        SharedTransitionStateMachineKt.access$updateTargetData-BGTQxF0(v0, arg13, v5_1, arg17, true);
        return new ActiveMatchConfigured(v0, arg12, v1);
    }

    public boolean getActiveMatchFound() {
        return 1;
    }

    public Rect getCurrentBounds() {
        return this.currentBounds$delegate.getValue();
    }

    public final BoundsProvider getTargetBoundsProviderBeforeConfig() {
        return this.targetBoundsProviderBeforeConfig;
    }

    public TargetData getTargetData() {
        return this.targetData;
    }

    public Rect initializeCurrentBounds(SharedElement arg8) {
        Object v4;
        Object v3;
        Rect v0 = this.getCurrentBounds();
        if(v0 != null) {
            return v0;
        }

        if(this.getCurrentBounds() == null) {
            BoundsProvider v0_1 = this.targetBoundsProviderBeforeConfig;
            if(v0_1 == null) {
                List v0_2 = arg8.getAllEntries();
                int v1 = v0_2.size();
                int v2 = 0;
                while(true) {
                    v3 = null;
                    if(v2 < v1) {
                        v4 = v0_2.get(v2);
                        if(arg8.getEnabledEntries().contains(v4)) {
                        }
                        else {
                            ++v2;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_22;
                }

                v4 = v3;
            label_22:
                if(v4 != null) {
                    v0_1 = ((SharedElementEntry)v4).getBoundsProvider();
                    goto label_26;
                }

                v0_1 = ((BoundsProvider)v3);
            }

        label_26:
            Rect v8 = SharedTransitionStateMachineKt.access$obtainBoundsFromLastTarget(arg8, v0_1);
            if(v8 == null) {
                goto label_29;
            }

            this.setCurrentBounds(v8);
        }

    label_29:
        return this.getCurrentBounds();
    }

    public State onMatchFound(BoundsProvider arg2) {
        if(this.targetBoundsProviderBeforeConfig == null) {
            this.targetBoundsProviderBeforeConfig = arg2;
        }

        return this;
    }

    public State onVisibleContentRemovedDuringTransition() {
        return NoMatchFound.INSTANCE;
    }

    private void setCurrentBounds(Rect arg1) {
        this.currentBounds$delegate.setValue(arg1);
    }

    public final void setTargetBoundsProviderBeforeConfig(BoundsProvider arg1) {
        this.targetBoundsProviderBeforeConfig = arg1;
    }

    public void updateBounds(Rect arg1) {
        this.setCurrentBounds(arg1);
    }
}

