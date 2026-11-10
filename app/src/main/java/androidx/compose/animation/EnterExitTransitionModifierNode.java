package androidx.compose.animation;

import androidx.compose.animation.core.Transition$DeferredAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u009B\u0001\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001E\u0010\u0005\u001A\u001A\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001E\u0010\t\u001A\u001A\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001E\u0010\u000B\u001A\u001A\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010I\u001A\u00020\u00072\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0007¢\u0006\u0004\bL\u0010MJ\b\u0010N\u001A\u00020OH\u0016J\u001D\u0010P\u001A\u00020\n2\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0007¢\u0006\u0004\bQ\u0010MJ#\u0010R\u001A\u00020S*\u00020T2\u0006\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u000206H\u0016¢\u0006\u0004\bX\u0010YJ\u001D\u0010\\\u001A\u00020\n2\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020\u0007¢\u0006\u0004\b]\u0010MR \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR2\u0010\u0005\u001A\u001A\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER2\u0010\t\u001A\u001A\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u001C\"\u0004\b \u0010\u001ER2\u0010\u000B\u001A\u001A\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u001C\"\u0004\b\"\u0010\u001ER\u001A\u0010\f\u001A\u00020\rX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001A\u0010\u000E\u001A\u00020\u000FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*R \u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010+\"\u0004\b,\u0010-R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R\u000E\u00102\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u00103\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0004\n\u0002\u00104R \u00107\u001A\u0002062\u0006\u00105\u001A\u000206@BX\u0082\u000E¢\u0006\n\n\u0002\u00104\"\u0004\b8\u00109R\u001C\u0010:\u001A\u0004\u0018\u00010;X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0013\u0010@\u001A\u0004\u0018\u00010;8F¢\u0006\u0006\u001A\u0004\bA\u0010=R.\u0010B\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001A\u0004\bG\u0010HR.\u0010Z\u001A\u001F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040D\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0E0C¢\u0006\u0002\bF¢\u0006\b\n\u0000\u001A\u0004\b[\u0010H¨\u0006^"}, d2={"Landroidx/compose/animation/EnterExitTransitionModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "transition", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "sizeAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "offsetAnimation", "Landroidx/compose/ui/unit/IntOffset;", "slideAnimation", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "isEnabled", "Lkotlin/Function0;", "", "graphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "getTransition", "()Landroidx/compose/animation/core/Transition;", "setTransition", "(Landroidx/compose/animation/core/Transition;)V", "getSizeAnimation", "()Landroidx/compose/animation/core/Transition$DeferredAnimation;", "setSizeAnimation", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;)V", "getOffsetAnimation", "setOffsetAnimation", "getSlideAnimation", "setSlideAnimation", "getEnter", "()Landroidx/compose/animation/EnterTransition;", "setEnter", "(Landroidx/compose/animation/EnterTransition;)V", "getExit", "()Landroidx/compose/animation/ExitTransition;", "setExit", "(Landroidx/compose/animation/ExitTransition;)V", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "getGraphicsLayerBlock", "()Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "setGraphicsLayerBlock", "(Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;)V", "lookaheadConstraintsAvailable", "lookaheadSize", "J", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "currentAlignment", "Landroidx/compose/ui/Alignment;", "getCurrentAlignment", "()Landroidx/compose/ui/Alignment;", "setCurrentAlignment", "(Landroidx/compose/ui/Alignment;)V", "alignment", "getAlignment", "sizeTransitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "getSizeTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "sizeByState", "targetState", "fullSize", "sizeByState-Uzc_VyU", "(Landroidx/compose/animation/EnterExitState;J)J", "onAttach", "", "targetOffsetByState", "targetOffsetByState-oFUgxo0", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "slideSpec", "getSlideSpec", "slideTargetValueByState", "slideTargetValueByState-oFUgxo0", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class EnterExitTransitionModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[EnterExitState.values().length];
            try {
                v0[EnterExitState.Visible.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[EnterExitState.PreEnter.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[EnterExitState.PostExit.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private Alignment currentAlignment;
    private EnterTransition enter;
    private ExitTransition exit;
    private GraphicsLayerBlockForEnterExit graphicsLayerBlock;
    private Function0 isEnabled;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;
    private DeferredAnimation offsetAnimation;
    private DeferredAnimation sizeAnimation;
    private final Function1 sizeTransitionSpec;
    private DeferredAnimation slideAnimation;
    private final Function1 slideSpec;
    private Transition transition;

    public EnterExitTransitionModifierNode(Transition arg1, DeferredAnimation arg2, DeferredAnimation arg3, DeferredAnimation arg4, EnterTransition arg5, ExitTransition arg6, Function0 arg7, GraphicsLayerBlockForEnterExit arg8) {
        super();
        this.transition = arg1;
        this.sizeAnimation = arg2;
        this.offsetAnimation = arg3;
        this.slideAnimation = arg4;
        this.enter = arg5;
        this.exit = arg6;
        this.isEnabled = arg7;
        this.graphicsLayerBlock = arg8;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.sizeTransitionSpec = new EnterExitTransitionModifierNode$sizeTransitionSpec$1(this);
        this.slideSpec = new EnterExitTransitionModifierNode$slideSpec$1(this);
    }

    public final Alignment getAlignment() {
        ChangeSize v3;
        Alignment v0_1;
        ChangeSize v0;
        Alignment v1 = null;
        if(this.transition.getSegment().isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            v0 = this.enter.getData$animation().getChangeSize();
            if(v0 != null) {
                v0_1 = v0.getAlignment();
                if(v0_1 == null) {
                }
                else {
                    return v0_1;
                }
            }

            v3 = this.exit.getData$animation().getChangeSize();
            if(v3 != null) {
                return v3.getAlignment();
            }

            return v1;
        }

        v0 = this.exit.getData$animation().getChangeSize();
        if(v0 != null) {
            v0_1 = v0.getAlignment();
            if(v0_1 == null) {
            }
            else {
                return v0_1;
            }
        }

        v3 = this.enter.getData$animation().getChangeSize();
        if(v3 != null) {
            return v3.getAlignment();
        }

        return v1;
    }

    public final Alignment getCurrentAlignment() {
        return this.currentAlignment;
    }

    public final EnterTransition getEnter() {
        return this.enter;
    }

    public final ExitTransition getExit() {
        return this.exit;
    }

    public final GraphicsLayerBlockForEnterExit getGraphicsLayerBlock() {
        return this.graphicsLayerBlock;
    }

    public final DeferredAnimation getOffsetAnimation() {
        return this.offsetAnimation;
    }

    public final DeferredAnimation getSizeAnimation() {
        return this.sizeAnimation;
    }

    public final Function1 getSizeTransitionSpec() {
        return this.sizeTransitionSpec;
    }

    public final DeferredAnimation getSlideAnimation() {
        return this.slideAnimation;
    }

    public final Function1 getSlideSpec() {
        return this.slideSpec;
    }

    public final Transition getTransition() {
        return this.transition;
    }

    public final Function0 isEnabled() {
        return this.isEnabled;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg22, Measurable arg23, long arg24) {
        State v5_1;
        EnterExitTransitionModifierNode v0 = this;
        long v1 = arg24;
        Alignment v5 = null;
        if(v0.transition.getCurrentState() == v0.transition.getTargetState()) {
            v0.currentAlignment = v5;
        }
        else if(v0.currentAlignment == null) {
            Alignment v3 = v0.getAlignment();
            if(v3 == null) {
                v3 = Alignment.Companion.getTopStart();
            }

            v0.currentAlignment = v3;
        }

        long v6 = 0xFFFFFFFFL;
        int v4 = 0x20;
        if(arg22.isLookingAhead()) {
            Placeable v3_1 = arg23.measure-BRTryo0(arg24);
            long v8 = IntSize.constructor-impl((((long)v3_1.getWidth())) << v4 | (((long)v3_1.getHeight())) & v6);
            v0.lookaheadSize = v8;
            v0.setLookaheadConstraints-BRTryo0(v1);
            return MeasureScope.layout$default(arg22, ((int)(v8 >> v4)), ((int)(v8 & v6)), null, new EnterExitTransitionModifierNode$measure$1(v3_1), 4, null);
        }

        if(v0.isEnabled.invoke().booleanValue()) {
            Function1 v14 = v0.graphicsLayerBlock.init();
            Placeable v9 = arg23.measure-BRTryo0(arg24);
            long v10 = IntSize.constructor-impl((((long)v9.getWidth())) << v4 | (((long)v9.getHeight())) & v6);
            long v12 = AnimationModifierKt.isValid-ozmzZPI(v0.lookaheadSize) ? v0.lookaheadSize : v10;
            DeferredAnimation v3_2 = v0.sizeAnimation;
            if(v3_2 != null) {
                v5_1 = v3_2.animate(v0.sizeTransitionSpec, new EnterExitTransitionModifierNode$measure$animSize$1(v0, v12));
            }

            if(v5_1 != null) {
                v10 = v5_1.getValue().unbox-impl();
            }

            long v18 = ConstraintsKt.constrain-4WqzIAM(v1, v10);
            DeferredAnimation v1_1 = v0.offsetAnimation;
            if(v1_1 != null) {
                State v1_2 = v1_1.animate(EnterExitTransitionModifierNode$measure$offsetDelta$1.INSTANCE, new EnterExitTransitionModifierNode$measure$offsetDelta$2(v0, v12));
                if(v1_2 != null) {
                    v1 = v1_2.getValue().unbox-impl();
                }
                else {
                    goto label_86;
                }
            }
            else {
            label_86:
                v1 = IntOffset.Companion.getZero-nOcc-ac();
            }

            v3_2 = v0.slideAnimation;
            if(v3_2 != null) {
                State v3_3 = v3_2.animate(v0.slideSpec, new EnterExitTransitionModifierNode$measure$slideOffset$1(v0, v12));
                if(v3_3 != null) {
                    v10 = v3_3.getValue().unbox-impl();
                }
                else {
                    goto label_98;
                }
            }
            else {
            label_98:
                v10 = IntOffset.Companion.getZero-nOcc-ac();
            }

            Alignment v15 = v0.currentAlignment;
            v12 = v15 != null ? v15.align-KFBX0sM(v12, v18, LayoutDirection.Ltr) : IntOffset.Companion.getZero-nOcc-ac();
            return MeasureScope.layout$default(arg22, ((int)(v18 >> v4)), ((int)(v18 & v6)), null, new EnterExitTransitionModifierNode$measure$2(v9, IntOffset.plus-qkQi6aY(v12, v10), v1, v14), 4, null);
        }

        Placeable v0_1 = arg23.measure-BRTryo0(arg24);
        return MeasureScope.layout$default(arg22, v0_1.getWidth(), v0_1.getHeight(), null, new EnterExitTransitionModifierNode$measure$3$1(v0_1), 4, null);
    }

    public void onAttach() {
        super.onAttach();
        this.lookaheadConstraintsAvailable = false;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    public final void setCurrentAlignment(Alignment arg1) {
        this.currentAlignment = arg1;
    }

    public final void setEnabled(Function0 arg1) {
        this.isEnabled = arg1;
    }

    public final void setEnter(EnterTransition arg1) {
        this.enter = arg1;
    }

    public final void setExit(ExitTransition arg1) {
        this.exit = arg1;
    }

    public final void setGraphicsLayerBlock(GraphicsLayerBlockForEnterExit arg1) {
        this.graphicsLayerBlock = arg1;
    }

    private final void setLookaheadConstraints-BRTryo0(long arg2) {
        this.lookaheadConstraintsAvailable = true;
        this.lookaheadConstraints = arg2;
    }

    public final void setOffsetAnimation(DeferredAnimation arg1) {
        this.offsetAnimation = arg1;
    }

    public final void setSizeAnimation(DeferredAnimation arg1) {
        this.sizeAnimation = arg1;
    }

    public final void setSlideAnimation(DeferredAnimation arg1) {
        this.slideAnimation = arg1;
    }

    public final void setTransition(Transition arg1) {
        this.transition = arg1;
    }

    public final long sizeByState-Uzc_VyU(EnterExitState arg2, long arg3) {
        Function1 v1_1;
        ChangeSize v1;
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.ordinal()];
        if(v2 != 1) {
            if(v2 == 2) {
                v1 = this.enter.getData$animation().getChangeSize();
                if(v1 != null) {
                    v1_1 = v1.getSize();
                    if(v1_1 != null) {
                        return v1_1.invoke(IntSize.box-impl(arg3)).unbox-impl();
                    }
                }
            }
            else if(v2 == 3) {
                v1 = this.exit.getData$animation().getChangeSize();
                if(v1 != null) {
                    v1_1 = v1.getSize();
                    if(v1_1 != null) {
                        return v1_1.invoke(IntSize.box-impl(arg3)).unbox-impl();
                    }
                }
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        return arg3;
    }

    public final long slideTargetValueByState-oFUgxo0(EnterExitState arg3, long arg4) {
        long v0_2;
        Slide v0 = this.enter.getData$animation().getSlide();
        if(v0 != null) {
            Function1 v0_1 = v0.getSlideOffset();
            if(v0_1 != null) {
                v0_2 = v0_1.invoke(IntSize.box-impl(arg4)).unbox-impl();
            }
            else {
                goto label_10;
            }
        }
        else {
        label_10:
            v0_2 = IntOffset.Companion.getZero-nOcc-ac();
        }

        Slide v2 = this.exit.getData$animation().getSlide();
        if(v2 != null) {
            Function1 v2_1 = v2.getSlideOffset();
            if(v2_1 != null) {
                arg4 = v2_1.invoke(IntSize.box-impl(arg4)).unbox-impl();
            }
            else {
                goto label_22;
            }
        }
        else {
        label_22:
            arg4 = IntOffset.Companion.getZero-nOcc-ac();
        }

        int v2_2 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v2_2 != 1) {
            if(v2_2 != 2) {
                if(v2_2 == 3) {
                    return arg4;
                }

                throw new NoWhenBranchMatchedException();
            }

            return v0_2;
        }

        return IntOffset.Companion.getZero-nOcc-ac();
    }

    public final long targetOffsetByState-oFUgxo0(EnterExitState arg7, long arg8) {
        if(this.currentAlignment == null) {
            return IntOffset.Companion.getZero-nOcc-ac();
        }

        if(this.getAlignment() == null) {
            return IntOffset.Companion.getZero-nOcc-ac();
        }

        if(Intrinsics.areEqual(this.currentAlignment, this.getAlignment())) {
            return IntOffset.Companion.getZero-nOcc-ac();
        }

        int v7 = WhenMappings.$EnumSwitchMapping$0[arg7.ordinal()];
        if(v7 != 1) {
            if(v7 != 2) {
                if(v7 == 3) {
                    ChangeSize v7_1 = this.exit.getData$animation().getChangeSize();
                    if(v7_1 != null) {
                        long v3 = v7_1.getSize().invoke(IntSize.box-impl(arg8)).unbox-impl();
                        Alignment v0 = this.getAlignment();
                        Intrinsics.checkNotNull(v0);
                        long v1 = arg8;
                        long v7_2 = v0.align-KFBX0sM(v1, v3, LayoutDirection.Ltr);
                        v0 = this.currentAlignment;
                        Intrinsics.checkNotNull(v0);
                        return IntOffset.minus-qkQi6aY(v7_2, v0.align-KFBX0sM(v1, v3, LayoutDirection.Ltr));
                    }

                    return IntOffset.Companion.getZero-nOcc-ac();
                }

                throw new NoWhenBranchMatchedException();
            }

            return IntOffset.Companion.getZero-nOcc-ac();
        }

        return IntOffset.Companion.getZero-nOcc-ac();
    }
}

