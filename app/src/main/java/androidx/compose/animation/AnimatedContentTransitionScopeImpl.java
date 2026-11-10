package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003VWXB\'\b\u0000\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u001A\u001A\u00020\u001B*\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DH\u0096\u0004JH\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020$0#2!\u0010%\u001A\u001D\u0012\u0013\u0012\u00110\'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\'0&H\u0016¢\u0006\u0004\b+\u0010,J\u001F\u00103\u001A\u00020$2\u0006\u00104\u001A\u0002052\u0006\u00106\u001A\u000205H\u0002¢\u0006\u0004\b7\u00108JH\u00109\u001A\u00020:2\u0006\u0010 \u001A\u00020!2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020$0#2!\u0010;\u001A\u001D\u0012\u0013\u0012\u00110\'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\'0&H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010Q\u001A\u00020R2\u0006\u0010S\u001A\u00020\u001BH\u0001¢\u0006\u0004\bT\u0010UR\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0007\u001A\u00020\bX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0017R\u0018\u0010-\u001A\u00020.*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b/\u00100R\u0018\u00101\u001A\u00020.*\u00020!8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b2\u00100R+\u0010?\u001A\u0002052\u0006\u0010>\u001A\u0002058@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\bD\u0010E\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR&\u0010F\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002050H0GX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bI\u0010JR\"\u0010K\u001A\n\u0012\u0004\u0012\u000205\u0018\u00010HX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u00106\u001A\u0002058BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bP\u0010A¨\u0006Y²\u0006\n\u0010Z\u001A\u00020.X\u008A\u008E\u0002"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "S", "Landroidx/compose/animation/AnimatedContentTransitionScope;", "transition", "Landroidx/compose/animation/core/Transition;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/unit/LayoutDirection;)V", "getTransition$animation", "()Landroidx/compose/animation/core/Transition;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "setContentAlignment", "(Landroidx/compose/ui/Alignment;)V", "getLayoutDirection$animation", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection$animation", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "initialState", "getInitialState", "()Ljava/lang/Object;", "targetState", "getTargetState", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "isLeft", "", "isLeft-gWo6LJ4", "(I)Z", "isRight", "isRight-gWo6LJ4", "calculateOffset", "fullSize", "Landroidx/compose/ui/unit/IntSize;", "currentSize", "calculateOffset-emnUabE", "(JJ)J", "slideOutOfContainer", "Landroidx/compose/animation/ExitTransition;", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "<set-?>", "measuredSize", "getMeasuredSize-YbymL2g$animation", "()J", "setMeasuredSize-ozmzZPI$animation", "(J)V", "measuredSize$delegate", "Landroidx/compose/runtime/MutableState;", "targetSizeMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/State;", "getTargetSizeMap$animation", "()Landroidx/collection/MutableScatterMap;", "animatedSize", "getAnimatedSize$animation", "()Landroidx/compose/runtime/State;", "setAnimatedSize$animation", "(Landroidx/compose/runtime/State;)V", "getCurrentSize-YbymL2g", "createSizeAnimationModifier", "Landroidx/compose/ui/Modifier;", "contentTransform", "createSizeAnimationModifier$animation", "(Landroidx/compose/animation/ContentTransform;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "ChildData", "SizeModifierElement", "SizeModifierNode", "animation", "shouldAnimateSize"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimatedContentTransitionScopeImpl implements AnimatedContentTransitionScope {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000B\u001A\u00020\f*\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\fH\u0016R+\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00038F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000F"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$ChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "isTarget", "", "<init>", "(Z)V", "<set-?>", "()Z", "setTarget", "isTarget$delegate", "Landroidx/compose/runtime/MutableState;", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChildData implements ParentDataModifier {
        public static final int $stable;
        private final MutableState isTarget$delegate;

        static {
        }

        public ChildData(boolean arg3) {
            super();
            this.isTarget$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arg3), null, 2, null);
        }

        public final boolean isTarget() {
            return this.isTarget$delegate.getValue().booleanValue();
        }

        public Object modifyParentData(Density arg1, Object arg2) {
            return this;
        }

        public final void setTarget(boolean arg1) {
            this.isTarget$delegate.setValue(Boolean.valueOf(arg1));
        }
    }

    @Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002BE\u0012\u001E\u0010\u0004\u001A\u001A\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u000E\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u000E\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016J\b\u0010\u0017\u001A\u00020\u0018H\u0016J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\u0016\u0010\u001D\u001A\u00020\u001E2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016J\f\u0010 \u001A\u00020\u001E*\u00020!H\u0016R)\u0010\u0004\u001A\u001A\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005R\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0019\u0010\t\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\r¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierElement;", "S", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierNode;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "scope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "getSizeTransform", "()Landroidx/compose/runtime/State;", "getScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "create", "hashCode", "", "equals", "", "other", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeModifierElement extends ModifierNodeElement {
        private final AnimatedContentTransitionScopeImpl scope;
        private final DeferredAnimation sizeAnimation;
        private final State sizeTransform;

        public SizeModifierElement(DeferredAnimation arg1, State arg2, AnimatedContentTransitionScopeImpl arg3) {
            super();
            this.sizeAnimation = arg1;
            this.sizeTransform = arg2;
            this.scope = arg3;
        }

        public SizeModifierNode create() {
            return new SizeModifierNode(this.sizeAnimation, this.sizeTransform, this.scope);
        }

        public Node create() {
            return this.create();
        }

        public boolean equals(Object arg3) {
            if(((arg3 instanceof SizeModifierElement)) && (Intrinsics.areEqual(((SizeModifierElement)arg3).sizeAnimation, this.sizeAnimation)) && (Intrinsics.areEqual(((SizeModifierElement)arg3).sizeTransform, this.sizeTransform))) {
                return 1;
            }

            return 0;
        }

        public final AnimatedContentTransitionScopeImpl getScope() {
            return this.scope;
        }

        public final DeferredAnimation getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State getSizeTransform() {
            return this.sizeTransform;
        }

        public int hashCode() {
            int v0 = this.scope.hashCode() * 0x1F;
            DeferredAnimation v1 = this.sizeAnimation;
            int v1_1 = v1 != null ? v1.hashCode() : 0;
            return (v0 + v1_1) * 0x1F + this.sizeTransform.hashCode();
        }

        public void inspectableProperties(InspectorInfo arg5) {
            arg5.setName("sizeTransform");
            arg5.getProperties().set("sizeAnimation", this.sizeAnimation);
            arg5.getProperties().set("sizeTransform", this.sizeTransform);
            arg5.getProperties().set("scope", this.scope);
        }

        public void update(SizeModifierNode arg2) {
            arg2.setSizeAnimation(this.sizeAnimation);
            arg2.setSizeTransform(this.sizeTransform);
            arg2.setScope(this.scope);
        }

        public void update(Node arg1) {
            this.update(((SizeModifierNode)arg1));
        }
    }

    @Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002BE\u0012\u001E\u0010\u0003\u001A\u001A\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u000E\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u001E\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u001F\u0010 J\b\u0010!\u001A\u00020\"H\u0016J#\u0010#\u001A\u00020$*\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b*\u0010+R2\u0010\u0003\u001A\u001A\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0010\u0010\u001B\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001C¨\u0006,"}, d2={"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierNode;", "S", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/Transition;", "sizeTransform", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/SizeTransform;", "scope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/runtime/State;Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getSizeTransform", "()Landroidx/compose/runtime/State;", "setSizeTransform", "(Landroidx/compose/runtime/State;)V", "getScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "setScope", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "lastSize", "J", "lastContinuousSizeOrDefault", "default", "lastContinuousSizeOrDefault-mzRDjE0", "(J)J", "onReset", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
        private long lastSize;
        private AnimatedContentTransitionScopeImpl scope;
        private DeferredAnimation sizeAnimation;
        private State sizeTransform;

        public SizeModifierNode(DeferredAnimation arg1, State arg2, AnimatedContentTransitionScopeImpl arg3) {
            super();
            this.sizeAnimation = arg1;
            this.sizeTransform = arg2;
            this.scope = arg3;
            this.lastSize = AnimatedContentKt.UnspecifiedSize;
        }

        public static final long access$lastContinuousSizeOrDefault-mzRDjE0(SizeModifierNode arg0, long arg1) {
            return arg0.lastContinuousSizeOrDefault-mzRDjE0(arg1);
        }

        public final AnimatedContentTransitionScopeImpl getScope() {
            return this.scope;
        }

        public final DeferredAnimation getSizeAnimation() {
            return this.sizeAnimation;
        }

        public final State getSizeTransform() {
            return this.sizeTransform;
        }

        private final long lastContinuousSizeOrDefault-mzRDjE0(long arg5) {
            if(IntSize.equals-impl0(this.lastSize, AnimatedContentKt.UnspecifiedSize)) {
                return arg5;
            }

            return this.lastSize;
        }

        public MeasureResult measure-3p2s80s(MeasureScope arg12, Measurable arg13, long arg14) {
            long v2;
            Placeable v13 = arg13.measure-BRTryo0(arg14);
            long v0 = 0xFFFFFFFFL;
            int v15 = 0x20;
            if(arg12.isLookingAhead()) {
                v2 = IntSize.constructor-impl((((long)v13.getWidth())) << v15 | (((long)v13.getHeight())) & v0);
            }
            else if(this.sizeAnimation == null) {
                v2 = IntSize.constructor-impl((((long)v13.getWidth())) << v15 | (((long)v13.getHeight())) & v0);
                this.lastSize = IntSize.constructor-impl((((long)v13.getWidth())) << v15 | (((long)v13.getHeight())) & v0);
            }
            else {
                v2 = IntSize.constructor-impl((((long)v13.getWidth())) << v15 | (((long)v13.getHeight())) & v0);
                DeferredAnimation v14 = this.sizeAnimation;
                Intrinsics.checkNotNull(v14);
                State v14_1 = v14.animate(new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$1(this, v2), new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$size$2(this, v2));
                this.scope.setAnimatedSize$animation(v14_1);
                v2 = v14_1.getValue().unbox-impl();
                this.lastSize = v14_1.getValue().unbox-impl();
            }

            return MeasureScope.layout$default(arg12, ((int)(v2 >> v15)), ((int)(v2 & v0)), null, new AnimatedContentTransitionScopeImpl$SizeModifierNode$measure$1(this, v13, v2), 4, null);
        }

        public void onReset() {
            super.onReset();
            this.lastSize = AnimatedContentKt.UnspecifiedSize;
        }

        public final void setScope(AnimatedContentTransitionScopeImpl arg1) {
            this.scope = arg1;
        }

        public final void setSizeAnimation(DeferredAnimation arg1) {
            this.sizeAnimation = arg1;
        }

        public final void setSizeTransform(State arg1) {
            this.sizeTransform = arg1;
        }
    }

    public static final int $stable = 8;
    private State animatedSize;
    private Alignment contentAlignment;
    private LayoutDirection layoutDirection;
    private final MutableState measuredSize$delegate;
    private final MutableScatterMap targetSizeMap;
    private final Transition transition;

    static {
    }

    public AnimatedContentTransitionScopeImpl(Transition arg1, Alignment arg2, LayoutDirection arg3) {
        super();
        this.transition = arg1;
        this.contentAlignment = arg2;
        this.layoutDirection = arg3;
        this.measuredSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
        this.targetSizeMap = ScatterMapKt.mutableScatterMapOf();
    }

    public static final long access$calculateOffset-emnUabE(AnimatedContentTransitionScopeImpl arg0, long arg1, long arg3) {
        return arg0.calculateOffset-emnUabE(arg1, arg3);
    }

    public static final long access$getCurrentSize-YbymL2g(AnimatedContentTransitionScopeImpl arg2) {
        return arg2.getCurrentSize-YbymL2g();
    }

    private final long calculateOffset-emnUabE(long arg7, long arg9) {
        return this.getContentAlignment().align-KFBX0sM(arg7, arg9, LayoutDirection.Ltr);
    }

    public final Modifier createSizeAnimationModifier$animation(ContentTransform arg8, Composer arg9, int arg10) {
        Companion v10_2;
        Companion v9_2;
        DeferredAnimation v3_1;
        Composer v4;
        MutableState v1_2;
        int v1 = 93755870;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(createSizeAnimationModifier)558@27920L40,559@27989L52:AnimatedContent.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:557)");
        }

        String v0 = "CC(remember):AnimatedContent.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg9, -94918490, v0);
        boolean v10 = arg9.changed(this);
        Object v1_1 = arg9.rememberedValue();
        SnapshotMutationPolicy v3 = null;
        if((v10) || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), v3, 2, v3);
            arg9.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        State v8 = SnapshotStateKt.rememberUpdatedState(arg8.getSizeTransform(), arg9, 0);
        if(Intrinsics.areEqual(this.transition.getCurrentState(), this.transition.getTargetState())) {
            AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$2(v1_2, false);
        }
        else if(v8.getValue() != null) {
            AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$2(v1_2, true);
        }

        if(AnimatedContentTransitionScopeImpl.createSizeAnimationModifier$lambda$1(v1_2)) {
            arg9.startReplaceGroup(0x50A652F9);
            ComposerKt.sourceInformation(arg9, "570@28546L48,571@28611L143");
            v4 = arg9;
            v3_1 = TransitionKt.createDeferredAnimation(this.transition, VectorConvertersKt.getVectorConverter(IntSize.Companion), null, v4, 0, 2);
            ComposerKt.sourceInformationMarkerStart(v4, 0xFA57FF6D, v0);
            boolean v9 = v4.changed(v3_1);
            Object v10_1 = v4.rememberedValue();
            if((v9) || v10_1 == Composer.Companion.getEmpty()) {
                Object v9_1 = v8.getValue();
                if(v9_1 == null || (((SizeTransform)v9_1).getClip())) {
                    Modifier v9_3 = ClipKt.clipToBounds(Modifier.Companion);
                }
                else {
                    v9_2 = Modifier.Companion;
                }

                v10_2 = v9_2;
                v4.updateRememberedValue(v10_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endReplaceGroup();
        }
        else {
            v4 = arg9;
            v4.startReplaceGroup(0x50AA6233);
            v4.endReplaceGroup();
            this.animatedSize = ((State)v3);
            v10_2 = Modifier.Companion;
        }

        Modifier v7 = ((Modifier)v10_2).then(new SizeModifierElement(v3_1, v8, this));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return v7;
    }

    private static final boolean createSizeAnimationModifier$lambda$1(MutableState arg0) {
        return ((State)arg0).getValue().booleanValue();
    }

    private static final void createSizeAnimationModifier$lambda$2(MutableState arg0, boolean arg1) {
        arg0.setValue(Boolean.valueOf(arg1));
    }

    public final State getAnimatedSize$animation() {
        return this.animatedSize;
    }

    public Alignment getContentAlignment() {
        return this.contentAlignment;
    }

    private final long getCurrentSize-YbymL2g() {
        State v0 = this.animatedSize;
        if(v0 != null) {
            return v0.getValue().unbox-impl();
        }

        return this.getMeasuredSize-YbymL2g$animation();
    }

    public Object getInitialState() {
        return this.transition.getSegment().getInitialState();
    }

    public final LayoutDirection getLayoutDirection$animation() {
        return this.layoutDirection;
    }

    public final long getMeasuredSize-YbymL2g$animation() {
        return this.measuredSize$delegate.getValue().unbox-impl();
    }

    public final MutableScatterMap getTargetSizeMap$animation() {
        return this.targetSizeMap;
    }

    public Object getTargetState() {
        return this.transition.getSegment().getTargetState();
    }

    public final Transition getTransition$animation() {
        return this.transition;
    }

    private final boolean isLeft-gWo6LJ4(int arg3) {
        if(!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getLeft-DKzdypw()) && (!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getStart-DKzdypw()) || this.layoutDirection != LayoutDirection.Ltr) && (!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getEnd-DKzdypw()) || this.layoutDirection != LayoutDirection.Rtl)) {
            return 0;
        }

        return 1;
    }

    private final boolean isRight-gWo6LJ4(int arg3) {
        if(!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getRight-DKzdypw()) && (!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getStart-DKzdypw()) || this.layoutDirection != LayoutDirection.Rtl) && (!SlideDirection.equals-impl0(arg3, SlideDirection.Companion.getEnd-DKzdypw()) || this.layoutDirection != LayoutDirection.Ltr)) {
            return 0;
        }

        return 1;
    }

    public final void setAnimatedSize$animation(State arg1) {
        this.animatedSize = arg1;
    }

    public void setContentAlignment(Alignment arg1) {
        this.contentAlignment = arg1;
    }

    public final void setLayoutDirection$animation(LayoutDirection arg1) {
        this.layoutDirection = arg1;
    }

    public final void setMeasuredSize-ozmzZPI$animation(long arg1) {
        this.measuredSize$delegate.setValue(IntSize.box-impl(arg1));
    }

    public EnterTransition slideIntoContainer-mOhB8PU(int arg2, FiniteAnimationSpec arg3, Function1 arg4) {
        if(this.isLeft-gWo6LJ4(arg2)) {
            return EnterExitTransitionKt.slideInHorizontally(arg3, new AnimatedContentTransitionScopeImpl$slideIntoContainer$1(arg4, this));
        }

        if(this.isRight-gWo6LJ4(arg2)) {
            return EnterExitTransitionKt.slideInHorizontally(arg3, new AnimatedContentTransitionScopeImpl$slideIntoContainer$2(arg4, this));
        }

        if(SlideDirection.equals-impl0(arg2, SlideDirection.Companion.getUp-DKzdypw())) {
            return EnterExitTransitionKt.slideInVertically(arg3, new AnimatedContentTransitionScopeImpl$slideIntoContainer$3(arg4, this));
        }

        if(SlideDirection.equals-impl0(arg2, SlideDirection.Companion.getDown-DKzdypw())) {
            return EnterExitTransitionKt.slideInVertically(arg3, new AnimatedContentTransitionScopeImpl$slideIntoContainer$4(arg4, this));
        }

        return EnterTransition.Companion.getNone();
    }

    public ExitTransition slideOutOfContainer-mOhB8PU(int arg2, FiniteAnimationSpec arg3, Function1 arg4) {
        if(this.isLeft-gWo6LJ4(arg2)) {
            return EnterExitTransitionKt.slideOutHorizontally(arg3, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$1(this, arg4));
        }

        if(this.isRight-gWo6LJ4(arg2)) {
            return EnterExitTransitionKt.slideOutHorizontally(arg3, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$2(this, arg4));
        }

        if(SlideDirection.equals-impl0(arg2, SlideDirection.Companion.getUp-DKzdypw())) {
            return EnterExitTransitionKt.slideOutVertically(arg3, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$3(this, arg4));
        }

        if(SlideDirection.equals-impl0(arg2, SlideDirection.Companion.getDown-DKzdypw())) {
            return EnterExitTransitionKt.slideOutVertically(arg3, new AnimatedContentTransitionScopeImpl$slideOutOfContainer$4(this, arg4));
        }

        return ExitTransition.Companion.getNone();
    }

    public ContentTransform using(ContentTransform arg1, SizeTransform arg2) {
        arg1.setSizeTransform$animation(arg2);
        return arg1;
    }
}

