package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0018\u001A\u00020\u0019J\r\u0010\u001E\u001A\u00020\u001FH\u0000¢\u0006\u0002\b J\u0017\u0010\"\u001A\u00020\u001F2\u0006\u0010#\u001A\u00020$H\u0000¢\u0006\u0004\b%\u0010&J\u0006\u0010+\u001A\u00020\u001FJ\b\u0010,\u001A\u0004\u0018\u00010-J\u0006\u0010.\u001A\u00020\u001FJ\u0016\u00104\u001A\u00020\u001F2\u0006\u00105\u001A\u0002062\u0006\u0010\r\u001A\u00020\u0013J\u000E\u0010<\u001A\u00020\u001F2\u0006\u0010=\u001A\u00020\u0013J\u000E\u0010>\u001A\u00020\u001F2\u0006\u0010=\u001A\u00020\u0013R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001A\u00020\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0017\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0015R\u001A\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D0\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u0017\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u001C0(¢\u0006\b\n\u0000\u001A\u0004\b)\u0010*R\u0011\u0010/\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b0\u00101R\u0011\u00102\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b3\u00101R\u0014\u00107\u001A\b\u0012\u0004\u0012\u00020\u001308X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001A\b\u0012\u0004\u0012\u00020\u001308X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010:\u001A\b\u0012\u0004\u0012\u00020\u001F0(X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b;\u0010*¨\u0006?"}, d2={"Landroidx/compose/animation/SharedElement;", "", "key", "scope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getKey", "()Ljava/lang/Object;", "getScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "stateMachine", "Landroidx/compose/animation/SharedTransitionStateMachine;", "state", "Landroidx/compose/animation/SharedTransitionStateMachine$State;", "getState$animation", "()Landroidx/compose/animation/SharedTransitionStateMachine$State;", "enabledEntries", "", "Landroidx/compose/animation/SharedElementEntry;", "getEnabledEntries", "()Ljava/util/List;", "allEntries", "getAllEntries", "isAnimating", "", "momentumAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "updateMatch", "", "updateMatch$animation", "animationSpecFinalized", "updateExitVelocity", "velocity", "Landroidx/compose/ui/unit/Velocity;", "updateExitVelocity-TH1AsA0$animation", "(J)V", "momentumAnimationOffset", "Lkotlin/Function0;", "getMomentumAnimationOffset", "()Lkotlin/jvm/functions/Function0;", "invalidateTargetBoundsProvider", "tryInitializingCurrentBounds", "Landroidx/compose/ui/geometry/Rect;", "onSharedTransitionFinished", "foundMatch", "getFoundMatch", "()Z", "boundsTransformIsActive", "getBoundsTransformIsActive", "onLookaheadPlaced", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "_allEntries", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "_enabledEntries", "observingVisibilityChange", "getObservingVisibilityChange$animation", "addEntry", "sharedElementState", "removeEntry", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedElement {
    public static final int $stable = 8;
    private final SnapshotStateList _allEntries;
    private final SnapshotStateList _enabledEntries;
    private boolean animationSpecFinalized;
    private final Object key;
    private final Animatable momentumAnimation;
    private final Function0 momentumAnimationOffset;
    private final Function0 observingVisibilityChange;
    private final SharedTransitionScopeImpl scope;
    private final SharedTransitionStateMachine stateMachine;

    static {
    }

    public SharedElement(Object arg8, SharedTransitionScopeImpl arg9) {
        super();
        this.key = arg8;
        this.scope = arg9;
        this.stateMachine = new SharedTransitionStateMachine(this);
        this.momentumAnimation = new Animatable(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), VectorConvertersKt.getVectorConverter(Offset.Companion), null, null, 12, null);
        this.momentumAnimationOffset = new SharedElement$momentumAnimationOffset$1(this);
        this._allEntries = SnapshotStateKt.mutableStateListOf();
        this._enabledEntries = SnapshotStateKt.mutableStateListOf();
        this.observingVisibilityChange = new SharedElement$observingVisibilityChange$1(this);
    }

    public static final boolean access$getAnimationSpecFinalized$p(SharedElement arg0) {
        return arg0.animationSpecFinalized;
    }

    public static final Animatable access$getMomentumAnimation$p(SharedElement arg0) {
        return arg0.momentumAnimation;
    }

    public static final void access$setAnimationSpecFinalized$p(SharedElement arg0, boolean arg1) {
        arg0.animationSpecFinalized = arg1;
    }

    public final void addEntry(SharedElementEntry arg2) {
        this._allEntries.add(arg2);
        this.updateMatch$animation();
    }

    public final List getAllEntries() {
        return this._allEntries;
    }

    public final boolean getBoundsTransformIsActive() {
        return this.getState$animation().getMatchIsOrHasBeenConfigured();
    }

    public final List getEnabledEntries() {
        return this._enabledEntries;
    }

    public final boolean getFoundMatch() {
        if(!this.getState$animation().getActiveMatchFound() && !this.getState$animation().getMatchIsOrHasBeenConfigured()) {
            if(this.stateMachine.getActiveMatchDeferred()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final Object getKey() {
        return this.key;
    }

    public final Function0 getMomentumAnimationOffset() {
        return this.momentumAnimationOffset;
    }

    public final Function0 getObservingVisibilityChange$animation() {
        return this.observingVisibilityChange;
    }

    public final SharedTransitionScopeImpl getScope() {
        return this.scope;
    }

    public final State getState$animation() {
        return this.stateMachine.getState();
    }

    public final void invalidateTargetBoundsProvider() {
        this.stateMachine.invalidateTargetBoundsProvider();
    }

    public final boolean isAnimating() {
        List v4 = this.getEnabledEntries();
        int v0 = v4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(v4.get(v2).getBoundsAnimation().isRunning()) {
                return 1;
            }
        }

        return 0;
    }

    public final void onLookaheadPlaced(PlacementScope arg14, SharedElementEntry arg15) {
        this.stateMachine.processPendingRequest();
        if(!Intrinsics.areEqual(this.getState$animation(), NoMatchFound.INSTANCE)) {
            if(!arg15.isEnabled()) {
            }
            else {
                State v0 = this.getState$animation();
                if((arg15.getBoundsAnimation().getTarget()) && (v0.getActiveMatchFound())) {
                    LayoutCoordinates v2 = arg14.getCoordinates();
                    if(v2 != null) {
                        long v9 = IntSizeKt.toSize-ozmzZPI(v2.getSize-YbymL2g());
                        long v11 = LookaheadScope.localLookaheadPositionOf-au-aQtc$default(arg15.getSharedElement().scope, arg15.getSharedElement().scope.getLookaheadRoot$animation(), v2, 0, false, 6, null);
                        arg15.getSharedElement();
                        this.stateMachine.configureActiveMatch-L7TYDSY(v9, v11, LayoutCoordinates.localPositionOf-S_NoaFU$default(arg15.getSharedElement().scope.getLookaheadRoot$animation(), v2, 0, false, 2, null));
                    }
                }
            }
        }
    }

    public final void onSharedTransitionFinished() {
        if(this.getEnabledEntries().size() > 1) {
            if(!SharedElementKt.access$hasVisibleContent(this.getEnabledEntries())) {
            }
            else {
                return;
            }
        }

        this.stateMachine.resetState();
    }

    public final void removeEntry(SharedElementEntry arg2) {
        this._allEntries.remove(arg2);
        this._enabledEntries.remove(arg2);
        this.updateMatch$animation();
    }

    public final Rect tryInitializingCurrentBounds() {
        return this.stateMachine.tryInitializingCurrentBounds();
    }

    public final void updateExitVelocity-TH1AsA0$animation(long arg8) {
        BuildersKt.launch$default(this.scope.getCoroutineScope(), null, null, new SharedElement$updateExitVelocity$1(this, arg8, null), 3, null);
    }

    public final void updateMatch$animation() {
        Function0 v0 = this.scope.getTestBlockToRun();
        if(v0 != null) {
            v0.invoke();
        }

        CollectionsKt.removeAll(this._enabledEntries, new SharedElement$updateMatch$1(this));
        List v0_1 = this.getAllEntries();
        int v1 = v0_1.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = v0_1.get(v2);
            if((((SharedElementEntry)v3).isEnabled()) && !this.getEnabledEntries().contains(v3)) {
                this._enabledEntries.add(v3);
            }
        }

        this.stateMachine.checkForAndDeferStateUpdates(SharedElementKt.access$hasVisibleContent(this._enabledEntries));
    }
}

