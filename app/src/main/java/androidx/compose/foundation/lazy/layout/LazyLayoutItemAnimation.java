package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 N2\u00020\u0001:\u0001NB+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010B\u001A\u00020\bJ\u001D\u0010F\u001A\u00020\b2\u0006\u0010G\u001A\u00020\u00132\u0006\u0010H\u001A\u00020\u001A¢\u0006\u0004\bI\u0010JJ\u0006\u0010K\u001A\u00020\bJ\u0006\u0010L\u001A\u00020\bJ\u0006\u0010M\u001A\u00020\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u000F\"\u0004\b\u0018\u0010\u0011R\u001E\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001A@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR+\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b\u001E\u0010\u001C\"\u0004\b\u001F\u0010 R+\u0010#\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b%\u0010\"\u001A\u0004\b#\u0010\u001C\"\u0004\b$\u0010 R+\u0010&\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001A\u0004\b&\u0010\u001C\"\u0004\b\'\u0010 R+\u0010)\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A8F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b+\u0010\"\u001A\u0004\b)\u0010\u001C\"\u0004\b*\u0010 R\u001C\u0010,\u001A\u00020\u0013X\u0086\u000E¢\u0006\u0010\n\u0002\u00101\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R\u001C\u00102\u001A\u00020\u0013X\u0086\u000E¢\u0006\u0010\n\u0002\u00101\u001A\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00106\u001A\u0004\u0018\u0001052\b\u0010\u0019\u001A\u0004\u0018\u000105@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b7\u00108R\u001A\u00109\u001A\u000E\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010<\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020=0:X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010>\u001A\u00020\u00132\u0006\u0010\u001D\u001A\u00020\u00138F@BX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\bA\u0010\"\u001A\u0004\b?\u0010.\"\u0004\b@\u00100R\u001C\u0010C\u001A\u00020\u0013X\u0086\u000E¢\u0006\u0010\n\u0002\u00101\u001A\u0004\bD\u0010.\"\u0004\bE\u00100¨\u0006O"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "getPlacementSpec", "setPlacementSpec", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "value", "", "isRunningMovingAwayAnimation", "()Z", "<set-?>", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isAppearanceAnimationInProgress", "setAppearanceAnimationInProgress", "isAppearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "rawOffset", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "J", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "cancelPlacementAnimation", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "animatePlacementDelta", "delta", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animateAppearance", "animateDisappearance", "release", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LazyLayoutItemAnimation {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2={"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "<init>", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final long getNotInitialized-nOcc-ac() {
            return LazyLayoutItemAnimation.NotInitialized;
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private static final long NotInitialized;
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec fadeInSpec;
    private FiniteAnimationSpec fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;
    private final MutableState isAppearanceAnimationInProgress$delegate;
    private final MutableState isDisappearanceAnimationFinished$delegate;
    private final MutableState isDisappearanceAnimationInProgress$delegate;
    private final MutableState isPlacementAnimationInProgress$delegate;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0 onLayerPropertyChanged;
    private final MutableState placementDelta$delegate;
    private final Animatable placementDeltaAnimation;
    private FiniteAnimationSpec placementSpec;
    private long rawOffset;
    private final Animatable visibilityAnimation;

    static {
        LazyLayoutItemAnimation.Companion = new Companion(null);
        LazyLayoutItemAnimation.$stable = 8;
        LazyLayoutItemAnimation.NotInitialized = IntOffset.constructor-impl(0x7FFFFFFF7FFFFFFFL);
    }

    public LazyLayoutItemAnimation(CoroutineScope arg12, GraphicsContext arg13, Function0 arg14) {
        super();
        this.coroutineScope = arg12;
        this.graphicsContext = arg13;
        this.onLayerPropertyChanged = arg14;
        Boolean v12 = Boolean.valueOf(false);
        SnapshotMutationPolicy v14 = null;
        int v0 = 2;
        this.isPlacementAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(v12, v14, v0, v14);
        this.isAppearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(v12, v14, v0, v14);
        this.isDisappearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(v12, v14, v0, v14);
        this.isDisappearanceAnimationFinished$delegate = SnapshotStateKt.mutableStateOf$default(v12, v14, v0, v14);
        long v1 = LazyLayoutItemAnimation.NotInitialized;
        this.rawOffset = v1;
        this.finalOffset = IntOffset.Companion.getZero-nOcc-ac();
        GraphicsLayer v12_1 = arg13 != null ? arg13.createGraphicsLayer() : ((GraphicsLayer)v14);
        this.layer = v12_1;
        this.placementDeltaAnimation = new Animatable(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), VectorConvertersKt.getVectorConverter(IntOffset.Companion), null, null, 12, null);
        this.visibilityAnimation = new Animatable(Float.valueOf(1f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this.placementDelta$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), v14, v0, v14);
        this.lookaheadOffset = v1;
    }

    public LazyLayoutItemAnimation(CoroutineScope arg1, GraphicsContext arg2, Function0 arg3, int arg4, DefaultConstructorMarker arg5) {
        LazyLayoutItemAnimation$$ExternalSyntheticLambda0 v3;
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        if((arg4 & 4) != 0) {
            v3 = new LazyLayoutItemAnimation$$ExternalSyntheticLambda0();
        }

        this(arg1, arg2, ((Function0)v3));
    }

    static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final long access$getNotInitialized$cp() {
        return LazyLayoutItemAnimation.NotInitialized;
    }

    public static final Function0 access$getOnLayerPropertyChanged$p(LazyLayoutItemAnimation arg0) {
        return arg0.onLayerPropertyChanged;
    }

    public static final Animatable access$getPlacementDeltaAnimation$p(LazyLayoutItemAnimation arg0) {
        return arg0.placementDeltaAnimation;
    }

    public static final Animatable access$getVisibilityAnimation$p(LazyLayoutItemAnimation arg0) {
        return arg0.visibilityAnimation;
    }

    public static final void access$setAppearanceAnimationInProgress(LazyLayoutItemAnimation arg0, boolean arg1) {
        arg0.setAppearanceAnimationInProgress(arg1);
    }

    public static final void access$setDisappearanceAnimationFinished(LazyLayoutItemAnimation arg0, boolean arg1) {
        arg0.setDisappearanceAnimationFinished(arg1);
    }

    public static final void access$setDisappearanceAnimationInProgress(LazyLayoutItemAnimation arg0, boolean arg1) {
        arg0.setDisappearanceAnimationInProgress(arg1);
    }

    public static final void access$setPlacementAnimationInProgress(LazyLayoutItemAnimation arg0, boolean arg1) {
        arg0.setPlacementAnimationInProgress(arg1);
    }

    public static final void access$setPlacementDelta--gyyYBs(LazyLayoutItemAnimation arg0, long arg1) {
        arg0.setPlacementDelta--gyyYBs(arg1);
    }

    public static final void access$setRunningMovingAwayAnimation$p(LazyLayoutItemAnimation arg0, boolean arg1) {
        arg0.isRunningMovingAwayAnimation = arg1;
    }

    public final void animateAppearance() {
        GraphicsLayer v4 = this.layer;
        FiniteAnimationSpec v3 = this.fadeInSpec;
        if(!this.isAppearanceAnimationInProgress() && v3 != null) {
            if(v4 == null) {
            }
            else {
                this.setAppearanceAnimationInProgress(true);
                boolean v0 = this.isDisappearanceAnimationInProgress();
                int v1 = (((int)v0)) ^ 1;
                if(!v0) {
                    v4.setAlpha(0f);
                }

                BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animateAppearance$2(((boolean)v1), this, v3, v4, null), 3, null);
                return;
            }
        }

        LazyLayoutItemAnimation v2 = this;
        if(v2.isDisappearanceAnimationInProgress()) {
            if(v4 != null) {
                v4.setAlpha(1f);
            }

            BuildersKt.launch$default(v2.coroutineScope, null, null, new LazyLayoutItemAnimation$animateAppearance$1(v2, null), 3, null);
        }
    }

    public final void animateDisappearance() {
        GraphicsLayer v0 = this.layer;
        FiniteAnimationSpec v1 = this.fadeOutSpec;
        if(v0 != null && !this.isDisappearanceAnimationInProgress()) {
            if(v1 == null) {
            }
            else {
                this.setDisappearanceAnimationInProgress(true);
                BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animateDisappearance$1(this, v1, v0, null), 3, null);
            }
        }
    }

    public final void animatePlacementDelta-ar5cAso(long arg12, boolean arg14) {
        FiniteAnimationSpec v2 = this.placementSpec;
        if(v2 == null) {
            return;
        }

        long v3 = IntOffset.minus-qkQi6aY(this.getPlacementDelta-nOcc-ac(), arg12);
        this.setPlacementDelta--gyyYBs(v3);
        this.setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = arg14;
        BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, v2, v3, null), 3, null);
    }

    public final void cancelPlacementAnimation() {
        if(this.isPlacementAnimationInProgress()) {
            BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$cancelPlacementAnimation$1(this, null), 3, null);
        }
    }

    public final FiniteAnimationSpec getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    public final long getFinalOffset-nOcc-ac() {
        return this.finalOffset;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    public final long getLookaheadOffset-nOcc-ac() {
        return this.lookaheadOffset;
    }

    public final long getPlacementDelta-nOcc-ac() {
        return this.placementDelta$delegate.getValue().unbox-impl();
    }

    public final FiniteAnimationSpec getPlacementSpec() {
        return this.placementSpec;
    }

    public final long getRawOffset-nOcc-ac() {
        return this.rawOffset;
    }

    public final boolean isAppearanceAnimationInProgress() {
        return this.isAppearanceAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isDisappearanceAnimationFinished() {
        return this.isDisappearanceAnimationFinished$delegate.getValue().booleanValue();
    }

    public final boolean isDisappearanceAnimationInProgress() {
        return this.isDisappearanceAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isPlacementAnimationInProgress() {
        return this.isPlacementAnimationInProgress$delegate.getValue().booleanValue();
    }

    public final boolean isRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    public final void release() {
        Continuation v2 = null;
        if(this.isPlacementAnimationInProgress()) {
            this.setPlacementAnimationInProgress(false);
            BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$release$1(this, v2), 3, null);
        }

        if(this.isAppearanceAnimationInProgress()) {
            this.setAppearanceAnimationInProgress(false);
            BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$release$2(this, v2), 3, null);
        }

        if(this.isDisappearanceAnimationInProgress()) {
            this.setDisappearanceAnimationInProgress(false);
            BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$release$3(this, v2), 3, null);
        }

        this.isRunningMovingAwayAnimation = false;
        this.setPlacementDelta--gyyYBs(IntOffset.Companion.getZero-nOcc-ac());
        this.rawOffset = LazyLayoutItemAnimation.NotInitialized;
        GraphicsLayer v0 = this.layer;
        if(v0 != null) {
            GraphicsContext v1 = this.graphicsContext;
            if(v1 != null) {
                v1.releaseGraphicsLayer(v0);
            }
        }

        this.layer = ((GraphicsLayer)v2);
        this.fadeInSpec = ((FiniteAnimationSpec)v2);
        this.fadeOutSpec = ((FiniteAnimationSpec)v2);
        this.placementSpec = ((FiniteAnimationSpec)v2);
    }

    private final void setAppearanceAnimationInProgress(boolean arg1) {
        this.isAppearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setDisappearanceAnimationFinished(boolean arg1) {
        this.isDisappearanceAnimationFinished$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setDisappearanceAnimationInProgress(boolean arg1) {
        this.isDisappearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setFadeInSpec(FiniteAnimationSpec arg1) {
        this.fadeInSpec = arg1;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec arg1) {
        this.fadeOutSpec = arg1;
    }

    public final void setFinalOffset--gyyYBs(long arg1) {
        this.finalOffset = arg1;
    }

    public final void setLookaheadOffset--gyyYBs(long arg1) {
        this.lookaheadOffset = arg1;
    }

    private final void setPlacementAnimationInProgress(boolean arg1) {
        this.isPlacementAnimationInProgress$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setPlacementDelta--gyyYBs(long arg1) {
        this.placementDelta$delegate.setValue(IntOffset.box-impl(arg1));
    }

    public final void setPlacementSpec(FiniteAnimationSpec arg1) {
        this.placementSpec = arg1;
    }

    public final void setRawOffset--gyyYBs(long arg1) {
        this.rawOffset = arg1;
    }
}

