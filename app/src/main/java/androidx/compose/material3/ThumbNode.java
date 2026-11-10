package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010!\u001A\u00020\"H\u0016J#\u0010#\u001A\u00020$*\u00020%2\u0006\u0010&\u001A\u00020\'2\u0006\u0010(\u001A\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0006\u0010,\u001A\u00020\"R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0011R\u000E\u0010\u001A\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001D\u0018\u00010\u001CX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006-"}, d2={"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;ZLandroidx/compose/animation/core/FiniteAnimationSpec;)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "getChecked", "()Z", "setChecked", "(Z)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "sizeAnim", "initialOffset", "initialSize", "onAttach", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "update", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class ThumbNode extends Node implements LayoutModifierNode {
    private FiniteAnimationSpec animationSpec;
    private boolean checked;
    private float initialOffset;
    private float initialSize;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable offsetAnim;
    private Animatable sizeAnim;

    public ThumbNode(InteractionSource arg1, boolean arg2, FiniteAnimationSpec arg3) {
        super();
        this.interactionSource = arg1;
        this.checked = arg2;
        this.animationSpec = arg3;
        this.initialOffset = NaNf;
        this.initialSize = NaNf;
    }

    public static final Animatable access$getOffsetAnim$p(ThumbNode arg0) {
        return arg0.offsetAnim;
    }

    public static final Animatable access$getSizeAnim$p(ThumbNode arg0) {
        return arg0.sizeAnim;
    }

    public static final boolean access$isPressed$p(ThumbNode arg0) {
        return arg0.isPressed;
    }

    public static final void access$setPressed$p(ThumbNode arg0, boolean arg1) {
        arg0.isPressed = arg1;
    }

    public final FiniteAnimationSpec getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, Measurable arg11, long arg12) {
        Float v0_3;
        Object v0_2;
        float v12_1;
        int v12 = arg11.maxIntrinsicHeight(Constraints.getMaxWidth-impl(arg12)) == 0 || arg11.maxIntrinsicWidth(Constraints.getMaxHeight-impl(arg12)) == 0 ? 0 : 1;
        if(this.isPressed) {
            v12_1 = SwitchTokens.INSTANCE.getPressedHandleWidth-D9Ej5fM();
        }
        else {
            if(v12 == 0) {
                if(this.checked) {
                }
                else {
                    v12_1 = SwitchKt.getUncheckedThumbDiameter();
                    goto label_21;
                }
            }

            v12_1 = SwitchKt.getThumbDiameter();
        }

    label_21:
        v12_1 = arg10.toPx-0680j_4(v12_1);
        Animatable v13 = this.sizeAnim;
        float v13_1 = v13 != null ? v13.getValue().floatValue() : v12_1;
        int v1 = ((int)v13_1);
        Placeable v11 = arg11.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(v1, v1));
        v13_1 = arg10.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(SwitchKt.SwitchHeight - arg10.toDp-u2uoSUM(v12_1)) / 2f));
        float v0 = arg10.toPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(SwitchKt.SwitchWidth - SwitchKt.getThumbDiameter()) - SwitchKt.ThumbPadding));
        boolean v2 = this.isPressed;
        if(!v2 || !this.checked) {
            if((v2) && !this.checked) {
                v13_1 = arg10.toPx-0680j_4(SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM());
                goto label_67;
            }

            if(!this.checked) {
                goto label_67;
            }

            v13_1 = v0;
        }
        else {
            v13_1 = v0 - arg10.toPx-0680j_4(SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM());
        }

    label_67:
        Animatable v0_1 = this.sizeAnim;
        Continuation v2_1 = null;
        if(v0_1 != null) {
            v0_2 = v0_1.getTargetValue();
        }
        else {
            v0_3 = ((Float)v2_1);
        }

        if(!Intrinsics.areEqual(((Float)v0_2), v12_1)) {
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new ThumbNode$measure$1(this, v12_1, v2_1), 3, null);
        }

        v0_1 = this.offsetAnim;
        if(v0_1 != null) {
            v0_2 = v0_1.getTargetValue();
        }
        else {
            v0_3 = ((Float)v2_1);
        }

        if(!Intrinsics.areEqual(v0_3, v13_1)) {
            BuildersKt.launch$default(this.getCoroutineScope(), null, null, new ThumbNode$measure$2(this, v13_1, v2_1), 3, null);
        }

        if((Float.isNaN(this.initialSize)) && (Float.isNaN(this.initialOffset))) {
            this.initialSize = v12_1;
            this.initialOffset = v13_1;
        }

        return MeasureScope.layout$default(arg10, v1, v1, null, new ThumbNode$$ExternalSyntheticLambda0(v11, this, v13_1), 4, null);
    }

    static final Unit measure_3p2s80s$lambda$0(Placeable arg7, ThumbNode arg8, float arg9, PlacementScope arg10) {
        Animatable v8 = arg8.offsetAnim;
        int v8_1 = v8 != null ? ((int)v8.getValue().floatValue()) : ((int)arg9);
        PlacementScope.placeRelative$default(arg10, arg7, v8_1, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public void onAttach() {
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new ThumbNode$onAttach$1(this, null), 3, null);
    }

    public final void setAnimationSpec(FiniteAnimationSpec arg1) {
        this.animationSpec = arg1;
    }

    public final void setChecked(boolean arg1) {
        this.checked = arg1;
    }

    public final void setInteractionSource(InteractionSource arg1) {
        this.interactionSource = arg1;
    }

    public final void update() {
        Object v1 = null;
        int v2 = 2;
        if(this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, 0f, v2, v1);
        }

        if(this.offsetAnim == null && !Float.isNaN(this.initialOffset)) {
            this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, 0f, v2, v1);
        }
    }
}

