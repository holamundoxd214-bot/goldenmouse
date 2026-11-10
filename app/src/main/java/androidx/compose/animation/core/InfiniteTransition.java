package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u001D\u001A\u00020\u001E2\u0012\u0010\u001F\u001A\u000E\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u0000H\u0000¢\u0006\u0002\b J!\u0010!\u001A\u00020\u001E2\u0012\u0010\u001F\u001A\u000E\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u0000H\u0000¢\u0006\u0002\b\"J\u000F\u0010#\u001A\u00020\u001EH\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u001E2\u0006\u0010\'\u001A\u00020\u0015H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R \u0010\b\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u0016\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\f8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0016\u0010\u000F\"\u0004\b\u0017\u0010\u0011R#\u0010\u0019\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nR\u00020\u00000\u001A8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006)"}, d2={"Landroidx/compose/animation/core/InfiniteTransition;", "", "label", "", "<init>", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "_animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "<set-?>", "", "refreshChildNeeded", "getRefreshChildNeeded", "()Z", "setRefreshChildNeeded", "(Z)V", "refreshChildNeeded$delegate", "Landroidx/compose/runtime/MutableState;", "startTimeNanos", "", "isRunning", "setRunning", "isRunning$delegate", "animations", "", "getAnimations", "()Ljava/util/List;", "addAnimation", "", "animation", "addAnimation$animation_core", "removeAnimation", "removeAnimation$animation_core", "run", "run$animation_core", "(Landroidx/compose/runtime/Composer;I)V", "onFrame", "playTimeNanos", "TransitionAnimationState", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InfiniteTransition {
    @Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004BC\b\u0000\u0012\u0006\u0010\u0005\u001A\u00028\u0000\u0012\u0006\u0010\u0006\u001A\u00028\u0000\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ-\u00101\u001A\u0002022\u0006\u0010\u0005\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u00002\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\nH\u0000¢\u0006\u0004\b3\u00104J\u0015\u00105\u001A\u0002022\u0006\u00106\u001A\u000200H\u0000¢\u0006\u0002\b7J\r\u00108\u001A\u000202H\u0000¢\u0006\u0002\b9J\r\u0010:\u001A\u000202H\u0000¢\u0006\u0002\b;R\u001C\u0010\u0005\u001A\u00028\u0000X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0006\u001A\u00028\u0000X\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001D\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R+\u0010\u001B\u001A\u00028\u00002\u0006\u0010\u001A\u001A\u00028\u00008V@PX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b\u001C\u0010\u0010\"\u0004\b\u001D\u0010\u0012R*\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\n@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R<\u0010#\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"2\u0012\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"@@X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001A\u0010(\u001A\u00020)X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000E\u0010.\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u000200X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006<"}, d2={"Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "", "<init>", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;)V", "getInitialValue$animation_core", "()Ljava/lang/Object;", "setInitialValue$animation_core", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getTargetValue$animation_core", "setTargetValue$animation_core", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "value", "getValue", "setValue$animation_core", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation$animation_core", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "isFinished", "", "isFinished$animation_core", "()Z", "setFinished$animation_core", "(Z)V", "startOnTheNextFrame", "playTimeNanosOffset", "", "updateValues", "", "updateValues$animation_core", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;)V", "onPlayTimeChanged", "playTimeNanos", "onPlayTimeChanged$animation_core", "skipToEnd", "skipToEnd$animation_core", "reset", "reset$animation_core", "animation-core"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TransitionAnimationState implements State {
        private TargetBasedAnimation animation;
        private AnimationSpec animationSpec;
        private Object initialValue;
        private boolean isFinished;
        private final String label;
        private long playTimeNanosOffset;
        private boolean startOnTheNextFrame;
        private Object targetValue;
        private final TwoWayConverter typeConverter;
        private final MutableState value$delegate;

        public TransitionAnimationState(InfiniteTransition arg9, Object arg10, Object arg11, TwoWayConverter arg12, AnimationSpec arg13, String arg14) {
            InfiniteTransition.this = arg9;
            super();
            this.initialValue = arg10;
            this.targetValue = arg11;
            this.typeConverter = arg12;
            this.label = arg14;
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(arg10, null, 2, null);
            this.animationSpec = arg13;
            this.animation = new TargetBasedAnimation(this.animationSpec, arg12, this.initialValue, this.targetValue, null, 16, null);
        }

        public final TargetBasedAnimation getAnimation() {
            return this.animation;
        }

        public final AnimationSpec getAnimationSpec() {
            return this.animationSpec;
        }

        public final Object getInitialValue$animation_core() {
            return this.initialValue;
        }

        public final String getLabel() {
            return this.label;
        }

        public final Object getTargetValue$animation_core() {
            return this.targetValue;
        }

        public final TwoWayConverter getTypeConverter() {
            return this.typeConverter;
        }

        public Object getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core() {
            return this.isFinished;
        }

        public final void onPlayTimeChanged$animation_core(long arg3) {
            InfiniteTransition.this.setRefreshChildNeeded(false);
            if(this.startOnTheNextFrame) {
                this.startOnTheNextFrame = false;
                this.playTimeNanosOffset = arg3;
            }

            arg3 -= this.playTimeNanosOffset;
            this.setValue$animation_core(this.animation.getValueFromNanos(arg3));
            this.isFinished = this.animation.isFinishedFromNanos(arg3);
        }

        public final void reset$animation_core() {
            this.startOnTheNextFrame = true;
        }

        public final void setAnimation$animation_core(TargetBasedAnimation arg1) {
            this.animation = arg1;
        }

        public final void setFinished$animation_core(boolean arg1) {
            this.isFinished = arg1;
        }

        public final void setInitialValue$animation_core(Object arg1) {
            this.initialValue = arg1;
        }

        public final void setTargetValue$animation_core(Object arg1) {
            this.targetValue = arg1;
        }

        public void setValue$animation_core(Object arg1) {
            this.value$delegate.setValue(arg1);
        }

        public final void skipToEnd$animation_core() {
            this.setValue$animation_core(this.animation.getTargetValue());
            this.startOnTheNextFrame = true;
        }

        public final void updateValues$animation_core(Object arg9, Object arg10, AnimationSpec arg11) {
            this.initialValue = arg9;
            this.targetValue = arg10;
            this.animationSpec = arg11;
            this.animation = new TargetBasedAnimation(arg11, this.typeConverter, arg9, arg10, null, 16, null);
            InfiniteTransition.this.setRefreshChildNeeded(true);
            this.isFinished = false;
            this.startOnTheNextFrame = true;
        }
    }

    public static final int $stable = 8;
    private final MutableVector _animations;
    private final MutableState isRunning$delegate;
    private final String label;
    private final MutableState refreshChildNeeded$delegate;
    private long startTimeNanos;

    static {
    }

    public InfiniteTransition(String arg5) {
        super();
        this.label = arg5;
        this._animations = new MutableVector(new TransitionAnimationState[16], 0);
        this.refreshChildNeeded$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.startTimeNanos = -9223372036854775808L;
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(true), null, 2, null);
    }

    public static final long access$getStartTimeNanos$p(InfiniteTransition arg2) {
        return arg2.startTimeNanos;
    }

    public static final MutableVector access$get_animations$p(InfiniteTransition arg0) {
        return arg0._animations;
    }

    public static final void access$onFrame(InfiniteTransition arg0, long arg1) {
        arg0.onFrame(arg1);
    }

    public static final void access$setRefreshChildNeeded(InfiniteTransition arg0, boolean arg1) {
        arg0.setRefreshChildNeeded(arg1);
    }

    public static final void access$setStartTimeNanos$p(InfiniteTransition arg0, long arg1) {
        arg0.startTimeNanos = arg1;
    }

    public final void addAnimation$animation_core(TransitionAnimationState arg2) {
        this._animations.add(arg2);
        this.setRefreshChildNeeded(true);
    }

    public final List getAnimations() {
        return this._animations.asMutableList();
    }

    public final String getLabel() {
        return this.label;
    }

    private final boolean getRefreshChildNeeded() {
        return this.refreshChildNeeded$delegate.getValue().booleanValue();
    }

    private final boolean isRunning() {
        return this.isRunning$delegate.getValue().booleanValue();
    }

    private final void onFrame(long arg9) {
        MutableVector v0 = this._animations;
        Object[] v1 = v0.content;
        int v0_1 = v0.getSize();
        int v5 = 1;
        int v4;
        for(v4 = 0; v4 < v0_1; ++v4) {
            Object v6 = v1[v4];
            if(!((TransitionAnimationState)v6).isFinished$animation_core()) {
                ((TransitionAnimationState)v6).onPlayTimeChanged$animation_core(arg9);
            }

            if(!((TransitionAnimationState)v6).isFinished$animation_core()) {
                v5 = 0;
            }
        }

        this.setRunning(v5 ^ 1);
    }

    public final void removeAnimation$animation_core(TransitionAnimationState arg1) {
        this._animations.remove(arg1);
    }

    public final void run$animation_core(Composer arg7, int arg8) {
        InfiniteTransition$run$1$1 v3_3;
        int v1;
        int v0 = 0xED0B0967;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(run)165@6995L47:InfiniteTransition.kt#pdpnli");
        int v2 = 2;
        if((arg8 & 6) == 0) {
            v1 = arg7.changedInstance(this) ? 4 : v2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        boolean v3 = (v1 & 3) != v2 ? true : false;
        if(arg7.shouldExecute(v3, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:164)");
            }

            String v3_1 = "CC(remember):InfiniteTransition.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg7, 0xD66E5116, v3_1);
            Object v0_1 = arg7.rememberedValue();
            Object v5 = null;
            if(v0_1 == Composer.Companion.getEmpty()) {
                MutableState v0_2 = SnapshotStateKt.mutableStateOf$default(v5, ((SnapshotMutationPolicy)v5), v2, v5);
                arg7.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg7);
            if((this.isRunning()) || (this.getRefreshChildNeeded())) {
                arg7.startReplaceGroup(-144841960);
                ComposerKt.sourceInformation(arg7, "167@7123L1398,167@7102L1419");
                ComposerKt.sourceInformationMarkerStart(arg7, -697407907, v3_1);
                boolean v2_1 = arg7.changedInstance(this);
                Object v3_2 = arg7.rememberedValue();
                if((v2_1) || v3_2 == Composer.Companion.getEmpty()) {
                    v3_3 = new InfiniteTransition$run$1$1(((MutableState)v0_1), this, ((Continuation)v5));
                    arg7.updateRememberedValue(v3_3);
                }

                ComposerKt.sourceInformationMarkerEnd(arg7);
                EffectsKt.LaunchedEffect(this, ((Function2)v3_3), arg7, v1 & 14);
            }
            else {
                arg7.startReplaceGroup(0xF6F1E67B);
            }

            arg7.endReplaceGroup();
            if(!ComposerKt.isTraceInProgress()) {
                goto label_73;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_73:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new InfiniteTransition$$ExternalSyntheticLambda0(this, arg8));
        }
    }

    static final Unit run$lambda$2(InfiniteTransition arg0, int arg1, Composer arg2, int arg3) {
        arg0.run$animation_core(arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private final void setRefreshChildNeeded(boolean arg1) {
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(arg1));
    }

    private final void setRunning(boolean arg1) {
        this.isRunning$delegate.setValue(Boolean.valueOf(arg1));
    }
}

