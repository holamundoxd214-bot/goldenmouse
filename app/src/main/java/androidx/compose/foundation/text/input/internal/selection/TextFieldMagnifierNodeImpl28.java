package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u001E\u001A\u00020\u001FH\u0016J(\u0010 \u001A\u00020\u001F2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016J\b\u0010!\u001A\u00020\u001FH\u0002J\f\u0010\"\u001A\u00020\u001F*\u00020#H\u0016J\u0010\u0010$\u001A\u00020\u001F2\u0006\u0010%\u001A\u00020&H\u0016J\f\u0010\'\u001A\u00020\u001F*\u00020(H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8B@BX\u0082\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u001BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Z)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "animationJob", "Lkotlinx/coroutines/Job;", "onAttach", "", "update", "restartAnimationJob", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable;
    private final Animatable animatable;
    private Job animationJob;
    private final MagnifierNode magnifierNode;
    private final MutableState magnifierSize$delegate;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean visible;

    static {
    }

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState arg18, TextFieldSelectionState arg19, TextLayoutState arg20, boolean arg21) {
        super();
        this.textFieldState = arg18;
        this.textFieldSelectionState = arg19;
        this.textLayoutState = arg20;
        this.visible = arg21;
        this.magnifierSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), null, 2, null);
        this.animatable = new Animatable(Offset.box-impl(TextFieldMagnifierKt.calculateSelectionMagnifierCenterAndroid-hUlJWOE(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, this.getMagnifierSize-YbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.box-impl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), null, 8, null);
        this.magnifierNode = this.delegate(new MagnifierNode(new TextFieldMagnifierNodeImpl28$$ExternalSyntheticLambda0(this), null, new TextFieldMagnifierNodeImpl28$$ExternalSyntheticLambda1(this), 0f, true, 0, 0f, 0f, false, null, 1002, null));
    }

    public static final Animatable access$getAnimatable$p(TextFieldMagnifierNodeImpl28 arg0) {
        return arg0.animatable;
    }

    public static final long access$getMagnifierSize-YbymL2g(TextFieldMagnifierNodeImpl28 arg2) {
        return arg2.getMagnifierSize-YbymL2g();
    }

    public static final TextFieldSelectionState access$getTextFieldSelectionState$p(TextFieldMagnifierNodeImpl28 arg0) {
        return arg0.textFieldSelectionState;
    }

    public static final TransformedTextFieldState access$getTextFieldState$p(TextFieldMagnifierNodeImpl28 arg0) {
        return arg0.textFieldState;
    }

    public static final TextLayoutState access$getTextLayoutState$p(TextFieldMagnifierNodeImpl28 arg0) {
        return arg0.textLayoutState;
    }

    public static final boolean access$getVisible$p(TextFieldMagnifierNodeImpl28 arg0) {
        return arg0.visible;
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        this.magnifierNode.applySemantics(arg1);
    }

    public void draw(ContentDrawScope arg1) {
        arg1.drawContent();
        this.magnifierNode.draw(arg1);
    }

    private final long getMagnifierSize-YbymL2g() {
        return this.magnifierSize$delegate.getValue().unbox-impl();
    }

    static final Offset magnifierNode$lambda$0(TextFieldMagnifierNodeImpl28 arg0, Density arg1) {
        return arg0.animatable.getValue();
    }

    static final Unit magnifierNode$lambda$1(TextFieldMagnifierNodeImpl28 arg6, DpSize arg7) {
        Object v0 = CompositionLocalConsumerModifierNodeKt.currentValueOf(arg6, CompositionLocalsKt.getLocalDensity());
        arg6.setMagnifierSize-ozmzZPI(IntSize.constructor-impl((((long)((Density)v0).roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(arg7.unbox-impl())))) << 0x20 | (((long)((Density)v0).roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(arg7.unbox-impl())))) & 0xFFFFFFFFL));
        return Unit.INSTANCE;
    }

    public void onAttach() {
        this.restartAnimationJob();
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        this.magnifierNode.onGloballyPositioned(arg1);
    }

    private final void restartAnimationJob() {
        Job v0 = this.animationJob;
        CancellationException v2 = null;
        if(v0 != null) {
            DefaultImpls.cancel$default(v0, v2, 1, v2);
        }

        this.animationJob = ((Job)v2);
        if(!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, v2)) {
            return;
        }

        this.animationJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TextFieldMagnifierNodeImpl28$restartAnimationJob$1(this, ((Continuation)v2)), 3, null);
    }

    private final void setMagnifierSize-ozmzZPI(long arg1) {
        this.magnifierSize$delegate.setValue(IntSize.box-impl(arg1));
    }

    public void update(TransformedTextFieldState arg5, TextFieldSelectionState arg6, TextLayoutState arg7, boolean arg8) {
        TransformedTextFieldState v0 = this.textFieldState;
        TextFieldSelectionState v1 = this.textFieldSelectionState;
        TextLayoutState v2 = this.textLayoutState;
        boolean v3 = this.visible;
        this.textFieldState = arg5;
        this.textFieldSelectionState = arg6;
        this.textLayoutState = arg7;
        this.visible = arg8;
        if((Intrinsics.areEqual(arg5, v0)) && (Intrinsics.areEqual(arg6, v1)) && (Intrinsics.areEqual(arg7, v2))) {
            if(arg8 != v3) {
            }
            else {
                return;
            }
        }

        this.restartAnimationJob();
    }
}

