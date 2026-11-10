package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\u0006\u0012\u0006\u0010\u000B\u001A\u00020\f\u0012\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\b\u0010:\u001A\u00020;H\u0016J\b\u0010<\u001A\u00020;H\u0016J=\u0010=\u001A\u00020;2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u00020;2\u0006\u0010A\u001A\u00020BH\u0016J#\u0010C\u001A\u00020D*\u00020E2\u0006\u0010F\u001A\u00020G2\u0006\u0010H\u001A\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u001C\u0010L\u001A\u00020\u0006*\u00020M2\u0006\u0010F\u001A\u00020N2\u0006\u0010O\u001A\u00020\u0006H\u0016J\u001C\u0010P\u001A\u00020\u0006*\u00020M2\u0006\u0010F\u001A\u00020N2\u0006\u0010O\u001A\u00020\u0006H\u0016J\u001C\u0010Q\u001A\u00020\u0006*\u00020M2\u0006\u0010F\u001A\u00020N2\u0006\u0010R\u001A\u00020\u0006H\u0016J\u001C\u0010S\u001A\u00020\u0006*\u00020M2\u0006\u0010F\u001A\u00020N2\u0006\u0010R\u001A\u00020\u0006H\u0016J\f\u0010T\u001A\u00020;*\u00020UH\u0016J\b\u0010V\u001A\u00020;H\u0002J\u000E\u0010W\u001A\u00020;H\u0082@¢\u0006\u0002\u0010XR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R+\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00068B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00068B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u001D\u0010\u0019\u001A\u0004\b\u001B\u0010\u0015\"\u0004\b\u001C\u0010\u0017R+\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0012\u001A\u00020\u001E8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010&\u001A\u0004\u0018\u00010\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010(\u001A\u0004\u0018\u00010)X\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b.\u0010%\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\b8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b1\u0010%\u001A\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001A\u00102\u001A\u000E\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020503X\u0082\u0004¢\u0006\u0002\n\u0000R\u001B\u00106\u001A\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001A\u0004\b7\u0010\u0015¨\u0006Y"}, d2={"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "<init>", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "<set-?>", "contentWidth", "getContentWidth", "()I", "setContentWidth", "(I)V", "contentWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "animationJob", "Lkotlinx/coroutines/Job;", "marqueeLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "getAnimationMode-ZbEOnfQ", "setAnimationMode-97h66l8", "animationMode$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "onAttach", "", "onDetach", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class MarqueeModifierNode extends Node implements FocusEventModifierNode, DrawModifierNode, LayoutModifierNode {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[LayoutDirection.values().length];
            try {
                v0[LayoutDirection.Ltr.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[LayoutDirection.Rtl.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    private Job animationJob;
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    private int delayMillis;
    private final MutableState hasFocus$delegate;
    private int initialDelayMillis;
    private int iterations;
    private GraphicsLayer marqueeLayer;
    private final Animatable offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    private float velocity;

    public static Unit $r8$lambda$U47EmRGrLFvd7yEuXuHv1cuEB9s(ContentDrawScope arg0, DrawScope arg1) {
        return MarqueeModifierNode.draw$lambda$0$0(arg0, arg1);
    }

    public MarqueeModifierNode(int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private MarqueeModifierNode(int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6) {
        super();
        this.iterations = arg1;
        this.delayMillis = arg3;
        this.initialDelayMillis = arg4;
        this.velocity = arg6;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(false), null, 2, null);
        this.spacing$delegate = SnapshotStateKt.mutableStateOf$default(arg5, null, 2, null);
        this.animationMode$delegate = SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.box-impl(arg2), null, 2, null);
        this.offset = AnimatableKt.Animatable$default(0f, 0f, 2, null);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf(new MarqueeModifierNode$$ExternalSyntheticLambda2(arg5, this));
    }

    public static final int access$getContainerWidth(MarqueeModifierNode arg0) {
        return arg0.getContainerWidth();
    }

    public static final int access$getContentWidth(MarqueeModifierNode arg0) {
        return arg0.getContentWidth();
    }

    public static final int access$getDelayMillis$p(MarqueeModifierNode arg0) {
        return arg0.delayMillis;
    }

    public static final boolean access$getHasFocus(MarqueeModifierNode arg0) {
        return arg0.getHasFocus();
    }

    public static final int access$getInitialDelayMillis$p(MarqueeModifierNode arg0) {
        return arg0.initialDelayMillis;
    }

    public static final int access$getIterations$p(MarqueeModifierNode arg0) {
        return arg0.iterations;
    }

    public static final Animatable access$getOffset$p(MarqueeModifierNode arg0) {
        return arg0.offset;
    }

    public static final int access$getSpacingPx(MarqueeModifierNode arg0) {
        return arg0.getSpacingPx();
    }

    public static final float access$getVelocity$p(MarqueeModifierNode arg0) {
        return arg0.velocity;
    }

    public static final Object access$runAnimation(MarqueeModifierNode arg0, Continuation arg1) {
        return arg0.runAnimation(arg1);
    }

    public void draw(ContentDrawScope arg18) {
        GraphicsLayer v0_2;
        float v11;
        float v2_1;
        int v2;
        MarqueeModifierNode v0 = this;
        ContentDrawScope v1 = arg18;
        int v4 = 2;
        int v5 = 1;
        if(Dp.compareTo-0680j_4(v0.velocity, Dp.constructor-impl(0f)) > 0) {
            v2 = WhenMappings.$EnumSwitchMapping$0[v1.getLayoutDirection().ordinal()];
            if(v2 == 1) {
                v2_1 = v0.offset.getValue().floatValue();
            }
            else if(v2 == v4) {
                v2_1 = -v0.offset.getValue().floatValue() + (((float)(v0.getContentWidth() * v4))) + (((float)v0.getSpacingPx()));
                v4 = v0.getContainerWidth();
                goto label_48;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        else {
            v2 = WhenMappings.$EnumSwitchMapping$0[v1.getLayoutDirection().ordinal()];
            if(v2 == 1) {
                v2_1 = -v0.offset.getValue().floatValue() + (((float)v0.getContentWidth())) + (((float)v0.getSpacingPx()));
            }
            else if(v2 == v4) {
                v2_1 = v0.offset.getValue().floatValue() + (((float)v0.getContentWidth()));
                v4 = v0.getContainerWidth();
            label_48:
                v2_1 -= ((float)v4);
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        v4 = Float.compare(v2_1, ((float)v0.getContentWidth())) < 0 ? 1 : 0;
        if((((float)v0.getContainerWidth())) + v2_1 > (((float)(v0.getContentWidth() + v0.getSpacingPx())))) {
        }
        else {
            v5 = 0;
        }

        float v6 = ((float)(v0.getContentWidth() + v0.getSpacingPx()));
        long v9 = 0xFFFFFFFFL;
        float v7 = Float.intBitsToFloat(((int)(v1.getSize-NH-jbRc() & v9)));
        GraphicsLayer v8 = v0.marqueeLayer;
        if(v8 != null) {
            v1.record-JVtK1S4(v8, IntSize.constructor-impl((((long)v0.getContentWidth())) << 0x20 | (((long)MathKt.roundToInt(v7))) & v9), new MarqueeModifierNode$$ExternalSyntheticLambda0(v1));
        }

        ContentDrawScope v7_1 = v1;
        float v14 = ((float)v0.getContainerWidth());
        float v15 = Float.intBitsToFloat(((int)(((DrawScope)v7_1).getSize-NH-jbRc() & v9)));
        int v16 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext v8_1 = ((DrawScope)v7_1).getDrawContext();
        v9 = v8_1.getSize-NH-jbRc();
        v8_1.getCanvas().save();
        try {
            v8_1.getTransform().clipRect-N_I0leg(0f, 0f, v14, v15, v16);
            v2_1 = -v2_1;
            ((DrawScope)v7_1).getDrawContext().getTransform().translate(v2_1, 0f);
            v11 = -0f;
        }
        catch(Throwable v0_1) {
            goto label_181;
        }

        try {
            v0_2 = v0.marqueeLayer;
            if(v0_2 != null) {
                if(v4 != 0) {
                    GraphicsLayerKt.drawLayer(((DrawScope)v7_1), v0_2);
                }

                if(v5 == 0) {
                    goto label_165;
                }

                ((DrawScope)v7_1).getDrawContext().getTransform().translate(v6, 0f);
            }
            else {
                goto label_147;
            }
        }
        catch(Throwable v0_1) {
            goto label_174;
        }

        try {
            GraphicsLayerKt.drawLayer(((DrawScope)v7_1), v0_2);
            goto label_136;
        }
        catch(Throwable v0_1) {
            try {
                ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v6, v11);
                throw v0_1;
            label_136:
                ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v6, v11);
                goto label_165;
            label_147:
                if(v4 != 0) {
                    v1.drawContent();
                }

                if(v5 == 0) {
                    goto label_165;
                }

                ((DrawScope)v7_1).getDrawContext().getTransform().translate(v6, 0f);
            }
            catch(Throwable v0_1) {
                goto label_174;
            }
        }

        try {
            v1.drawContent();
            goto label_154;
        }
        catch(Throwable v0_1) {
            try {
                ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v6, v11);
                throw v0_1;
            label_154:
                ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v6, v11);
                goto label_165;
            }
            catch(Throwable v0_1) {
                try {
                label_174:
                    ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v2_1, v11);
                    throw v0_1;
                label_165:
                    ((DrawScope)v7_1).getDrawContext().getTransform().translate(-v2_1, v11);
                }
                catch(Throwable v0_1) {
                label_181:
                    v8_1.getCanvas().restore();
                    v8_1.setSize-uvyYCjk(v9);
                    throw v0_1;
                }
            }
        }

        v8_1.getCanvas().restore();
        v8_1.setSize-uvyYCjk(v9);
    }

    private static final Unit draw$lambda$0$0(ContentDrawScope arg0, DrawScope arg1) {
        arg0.drawContent();
        return Unit.INSTANCE;
    }

    public final int getAnimationMode-ZbEOnfQ() {
        return this.animationMode$delegate.getValue().unbox-impl();
    }

    private final int getContainerWidth() {
        return this.containerWidth$delegate.getIntValue();
    }

    private final int getContentWidth() {
        return this.contentWidth$delegate.getIntValue();
    }

    private final boolean getHasFocus() {
        return this.hasFocus$delegate.getValue().booleanValue();
    }

    public final MarqueeSpacing getSpacing() {
        return this.spacing$delegate.getValue();
    }

    private final int getSpacingPx() {
        return this.spacingPx$delegate.getValue().intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicHeight(0x7FFFFFFF);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.maxIntrinsicWidth(arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        Placeable v10 = arg10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg11, 0, 0x7FFFFFFF, 0, 0, 13, null));
        this.setContainerWidth(ConstraintsKt.constrainWidth-K40F9xA(arg11, v10.getWidth()));
        this.setContentWidth(v10.getWidth());
        return MeasureScope.layout$default(arg9, this.getContainerWidth(), v10.getHeight(), null, new MarqueeModifierNode$$ExternalSyntheticLambda1(v10), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg8, PlacementScope arg9) {
        PlacementScope.placeWithLayer$default(arg9, arg8, 0, 0, 0f, null, 12, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return arg2.minIntrinsicHeight(0x7FFFFFFF);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return 0;
    }

    public void onAttach() {
        GraphicsLayer v0 = this.marqueeLayer;
        GraphicsContext v1 = DelegatableNodeKt.requireGraphicsContext(this);
        if(v0 != null) {
            v1.releaseGraphicsLayer(v0);
        }

        this.marqueeLayer = v1.createGraphicsLayer();
        this.restartAnimation();
    }

    public void onDetach() {
        Job v0 = this.animationJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        this.animationJob = ((Job)v1);
        GraphicsLayer v0_1 = this.marqueeLayer;
        if(v0_1 != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(v0_1);
            this.marqueeLayer = ((GraphicsLayer)v1);
        }
    }

    public void onFocusEvent(FocusState arg1) {
        this.setHasFocus(arg1.getHasFocus());
    }

    private final void restartAnimation() {
        Job v0 = this.animationJob;
        CancellationException v1 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v1, 1, v1);
        }

        if(this.isAttached()) {
            this.animationJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new MarqueeModifierNode$restartAnimation$1(v0, this, ((Continuation)v1)), 3, null);
        }
    }

    private final Object runAnimation(Continuation arg4) {
        if(this.iterations <= 0) {
            return Unit.INSTANCE;
        }

        Object v3 = BuildersKt.withContext(FixedMotionDurationScale.INSTANCE, new MarqueeModifierNode$runAnimation$2(this, null), arg4);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public final void setAnimationMode-97h66l8(int arg1) {
        this.animationMode$delegate.setValue(MarqueeAnimationMode.box-impl(arg1));
    }

    private final void setContainerWidth(int arg1) {
        this.containerWidth$delegate.setIntValue(arg1);
    }

    private final void setContentWidth(int arg1) {
        this.contentWidth$delegate.setIntValue(arg1);
    }

    private final void setHasFocus(boolean arg1) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(arg1));
    }

    public final void setSpacing(MarqueeSpacing arg1) {
        this.spacing$delegate.setValue(arg1);
    }

    static final int spacingPx_delegate$lambda$0(MarqueeSpacing arg2, MarqueeModifierNode arg3) {
        return arg2.calculateSpacing(DelegatableNodeKt.requireDensity(arg3), arg3.getContentWidth(), arg3.getContainerWidth());
    }

    public final void update-lWfNwf4(int arg1, int arg2, int arg3, int arg4, MarqueeSpacing arg5, float arg6) {
        this.setSpacing(arg5);
        this.setAnimationMode-97h66l8(arg2);
        if(this.iterations == arg1 && this.delayMillis == arg3 && this.initialDelayMillis == arg4) {
            if(!Dp.equals-impl0(this.velocity, arg6)) {
            }
            else {
                return;
            }
        }

        this.iterations = arg1;
        this.delayMillis = arg3;
        this.initialDelayMillis = arg4;
        this.velocity = arg6;
        this.restartAnimation();
    }
}

