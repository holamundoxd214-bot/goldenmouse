package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001F\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u001A\u001A\u00020\u001B*\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001C\u0010\"\u001A\u00020#*\u00020$2\u0006\u0010\u001D\u001A\u00020%2\u0006\u0010&\u001A\u00020#H\u0016J\u001C\u0010\'\u001A\u00020#*\u00020$2\u0006\u0010\u001D\u001A\u00020%2\u0006\u0010&\u001A\u00020#H\u0016J\u001C\u0010(\u001A\u00020#*\u00020$2\u0006\u0010\u001D\u001A\u00020%2\u0006\u0010)\u001A\u00020#H\u0016J\u001C\u0010*\u001A\u00020#*\u00020$2\u0006\u0010\u001D\u001A\u00020%2\u0006\u0010)\u001A\u00020#H\u0016R/\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\n\u001A\u0004\u0018\u00010\u00048F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER7\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001A\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006+"}, d2={"Landroidx/compose/animation/SkipToLookaheadSizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "Landroidx/compose/runtime/MutableState;", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "maxIntrinsicHeight", "width", "minIntrinsicHeight", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SkipToLookaheadSizeNode extends Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private final MutableState isEnabled$delegate;
    private Constraints lookaheadConstraints;
    private long lookaheadSize;
    private final MutableState scaleToBounds$delegate;

    static {
    }

    public SkipToLookaheadSizeNode(ScaleToBoundsImpl arg3, Function0 arg4) {
        super();
        this.scaleToBounds$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
        this.isEnabled$delegate = SnapshotStateKt.mutableStateOf$default(arg4, null, 2, null);
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    public static final long access$getLookaheadSize$p(SkipToLookaheadSizeNode arg2) {
        return arg2.lookaheadSize;
    }

    public final ScaleToBoundsImpl getScaleToBounds() {
        return this.scaleToBounds$delegate.getValue();
    }

    public final Function0 isEnabled() {
        return this.isEnabled$delegate.getValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        if(!arg3.isLookingAhead() && (AnimationModifierKt.isValid-ozmzZPI(this.lookaheadSize))) {
            return ((int)(this.lookaheadSize & 0xFFFFFFFFL));
        }

        return arg4.maxIntrinsicHeight(arg5);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        if(!arg3.isLookingAhead() && (AnimationModifierKt.isValid-ozmzZPI(this.lookaheadSize))) {
            return ((int)(this.lookaheadSize >> 0x20));
        }

        return arg4.maxIntrinsicWidth(arg5);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, Measurable arg11, long arg12) {
        Placeable v10;
        if(arg10.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.box-impl(arg12);
        }

        if(!this.isEnabled().invoke().booleanValue()) {
            Placeable v9 = arg11.measure-BRTryo0(arg12);
            return MeasureScope.layout$default(arg10, v9.getWidth(), v9.getHeight(), null, new SkipToLookaheadSizeNode$measure$1$1(v9), 4, null);
        }

        MeasureScope v0 = arg10;
        long v1 = 0xFFFFFFFFL;
        int v3 = 0x20;
        if(v0.isLookingAhead()) {
            v10 = arg11.measure-BRTryo0(arg12);
            this.lookaheadSize = IntSize.constructor-impl((((long)v10.getWidth())) << v3 | (((long)v10.getHeight())) & v1);
        }
        else {
            Constraints v10_1 = this.lookaheadConstraints;
            Intrinsics.checkNotNull(v10_1);
            v10 = arg11.measure-BRTryo0(v10_1.unbox-impl());
        }

        long v11 = ConstraintsKt.constrain-4WqzIAM(arg12, this.lookaheadSize);
        return MeasureScope.layout$default(v0, ((int)(v11 >> v3)), ((int)(v1 & v11)), null, new SkipToLookaheadSizeNode$measure$2(this, v10, v11, v0), 4, null);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        if(!arg3.isLookingAhead() && (AnimationModifierKt.isValid-ozmzZPI(this.lookaheadSize))) {
            return ((int)(this.lookaheadSize & 0xFFFFFFFFL));
        }

        return arg4.minIntrinsicHeight(arg5);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg3, IntrinsicMeasurable arg4, int arg5) {
        if(!arg3.isLookingAhead() && (AnimationModifierKt.isValid-ozmzZPI(this.lookaheadSize))) {
            return ((int)(this.lookaheadSize >> 0x20));
        }

        return arg4.minIntrinsicWidth(arg5);
    }

    public final void setEnabled(Function0 arg1) {
        this.isEnabled$delegate.setValue(arg1);
    }

    public final void setScaleToBounds(ScaleToBoundsImpl arg1) {
        this.scaleToBounds$delegate.setValue(arg1);
    }
}

