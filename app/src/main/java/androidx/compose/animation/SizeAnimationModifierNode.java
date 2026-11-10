package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001:\u0001?B[\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012:\b\u0002\u0010\u0007\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\b¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010%\u001A\u00020\u001F2\u0006\u0010&\u001A\u00020\u001FH\u0002¢\u0006\u0004\b\'\u0010(J\b\u00102\u001A\u00020\rH\u0016J\b\u00103\u001A\u00020\rH\u0016J#\u00104\u001A\u000205*\u0002062\u0006\u00107\u001A\u0002082\u0006\u00109\u001A\u00020\u001FH\u0016¢\u0006\u0004\b:\u0010;J\u0015\u0010<\u001A\u00020\u00042\u0006\u0010=\u001A\u00020\u0004¢\u0006\u0004\b>\u0010(R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RL\u0010\u0007\u001A4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u0010\u0010\u001C\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u001DR \u0010 \u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u001F@BX\u0082\u000E¢\u0006\n\n\u0002\u0010\u001D\"\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020$X\u0082\u000E¢\u0006\u0002\n\u0000R/\u0010+\u001A\u0004\u0018\u00010*2\b\u0010)\u001A\u0004\u0018\u00010*8F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006@"}, d2={"Landroidx/compose/animation/SizeAnimationModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "alignment", "Landroidx/compose/ui/Alignment;", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startSize", "endSize", "", "<init>", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function2;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "lookaheadSize", "J", "value", "Landroidx/compose/ui/unit/Constraints;", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "lookaheadConstraintsAvailable", "", "targetConstraints", "default", "targetConstraints-ZezNO4M", "(J)J", "<set-?>", "Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "animData", "getAnimData", "()Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "setAnimData", "(Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;)V", "animData$delegate", "Landroidx/compose/runtime/MutableState;", "onReset", "onAttach", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "animateTo", "targetSize", "animateTo-mzRDjE0", "AnimData", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) final class SizeAnimationModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0010\u0010\u0011\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJ0\u0010\u0013\u001A\u00020\u00002\u0014\b\u0002\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001R\u001D\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001C\u0010\u0006\u001A\u00020\u0004X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u001D"}, d2={"Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "startSize", "<init>", "(Landroidx/compose/animation/core/Animatable;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnim", "()Landroidx/compose/animation/core/Animatable;", "getStartSize-YbymL2g", "()J", "setStartSize-ozmzZPI", "(J)V", "J", "component1", "component2", "component2-YbymL2g", "copy", "copy-O0kMr_c", "(Landroidx/compose/animation/core/Animatable;J)Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "equals", "", "other", "hashCode", "", "toString", "", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimData {
        public static final int $stable = 8;
        private final Animatable anim;
        private long startSize;

        static {
        }

        public AnimData(Animatable arg1, long arg2, DefaultConstructorMarker arg4) {
            this(arg1, arg2);
        }

        private AnimData(Animatable arg1, long arg2) {
            super();
            this.anim = arg1;
            this.startSize = arg2;
        }

        public final Animatable component1() {
            return this.anim;
        }

        public final long component2-YbymL2g() {
            return this.startSize;
        }

        public final AnimData copy-O0kMr_c(Animatable arg2, long arg3) {
            return new AnimData(arg2, arg3, null);
        }

        public static AnimData copy-O0kMr_c$default(AnimData arg0, Animatable arg1, long arg2, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.anim;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.startSize;
            }

            return arg0.copy-O0kMr_c(arg1, arg2);
        }

        public boolean equals(Object arg6) {
            if(this == (((AnimData)arg6))) {
                return 1;
            }

            if(!(arg6 instanceof AnimData)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.anim, ((AnimData)arg6).anim)) {
                return 0;
            }

            if(!IntSize.equals-impl0(this.startSize, ((AnimData)arg6).startSize)) {
                return 0;
            }

            return 1;
        }

        public final Animatable getAnim() {
            return this.anim;
        }

        public final long getStartSize-YbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return this.anim.hashCode() * 0x1F + IntSize.hashCode-impl(this.startSize);
        }

        public final void setStartSize-ozmzZPI(long arg1) {
            this.startSize = arg1;
        }

        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + IntSize.toString-impl(this.startSize) + ')';
        }
    }

    private Alignment alignment;
    private final MutableState animData$delegate;
    private AnimationSpec animationSpec;
    private Function2 listener;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;

    public SizeAnimationModifierNode(AnimationSpec arg7, Alignment arg8, Function2 arg9) {
        super();
        this.animationSpec = arg7;
        this.alignment = arg8;
        this.listener = arg9;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.animData$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public SizeAnimationModifierNode(AnimationSpec arg1, Alignment arg2, Function2 arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = Alignment.Companion.getTopStart();
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public final long animateTo-mzRDjE0(long arg12) {
        AnimData v1 = this.getAnimData();
        if(v1 != null) {
            int v0 = (IntSize.equals-impl0(arg12, v1.getAnim().getValue().unbox-impl())) || (v1.getAnim().isRunning()) ? 0 : 1;
            if((IntSize.equals-impl0(arg12, v1.getAnim().getTargetValue().unbox-impl())) && v0 == 0) {
                goto label_51;
            }

            v1.setStartSize-ozmzZPI(v1.getAnim().getValue().unbox-impl());
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new SizeAnimationModifierNode$animateTo$data$1$1(v1, arg12, this, null), 3, null);
        }
        else {
            v1 = new AnimData(new Animatable(IntSize.box-impl(arg12), VectorConvertersKt.getVectorConverter(IntSize.Companion), IntSize.box-impl(IntSize.constructor-impl(0x100000001L)), null, 8, null), arg12, null);
        }

    label_51:
        this.setAnimData(v1);
        return v1.getAnim().getValue().unbox-impl();
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final AnimData getAnimData() {
        return this.animData$delegate.getValue();
    }

    public final AnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final Function2 getListener() {
        return this.listener;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg20, Measurable arg21, long arg22) {
        Placeable v0;
        SizeAnimationModifierNode v1 = this;
        long v2 = arg22;
        if(arg20.isLookingAhead()) {
            v1.setLookaheadConstraints-BRTryo0(v2);
            v0 = arg21.measure-BRTryo0(arg22);
        }
        else {
            v0 = arg21.measure-BRTryo0(v1.targetConstraints-ZezNO4M(v2));
        }

        Placeable v7 = v0;
        int v0_1 = 0x20;
        long v10 = 0xFFFFFFFFL;
        long v4 = IntSize.constructor-impl((((long)v7.getWidth())) << v0_1 | (((long)v7.getHeight())) & v10);
        if(arg20.isLookingAhead()) {
            v1.lookaheadSize = v4;
            v2 = v4;
        }
        else {
            long v8 = AnimationModifierKt.isValid-ozmzZPI(v1.lookaheadSize) ? v1.lookaheadSize : v4;
            v2 = ConstraintsKt.constrain-4WqzIAM(v2, v1.animateTo-mzRDjE0(v8));
        }

        int v13 = ((int)(v2 >> v0_1));
        int v14 = ((int)(v2 & v10));
        return MeasureScope.layout$default(arg20, v13, v14, null, new SizeAnimationModifierNode$measure$2(v1, v4, v13, v14, arg20, v7), 4, null);
    }

    public void onAttach() {
        super.onAttach();
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraintsAvailable = false;
    }

    public void onReset() {
        super.onReset();
        this.setAnimData(null);
    }

    public final void setAlignment(Alignment arg1) {
        this.alignment = arg1;
    }

    public final void setAnimData(AnimData arg1) {
        this.animData$delegate.setValue(arg1);
    }

    public final void setAnimationSpec(AnimationSpec arg1) {
        this.animationSpec = arg1;
    }

    public final void setListener(Function2 arg1) {
        this.listener = arg1;
    }

    private final void setLookaheadConstraints-BRTryo0(long arg1) {
        this.lookaheadConstraints = arg1;
        this.lookaheadConstraintsAvailable = true;
    }

    private final long targetConstraints-ZezNO4M(long arg2) {
        if(this.lookaheadConstraintsAvailable) {
            return this.lookaheadConstraints;
        }

        return arg2;
    }
}

