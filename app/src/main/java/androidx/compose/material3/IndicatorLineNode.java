package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010JI\u0010%\u001A\u00020&2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\'\u0010(J\b\u0010,\u001A\u00020&H\u0016J\u000E\u0010-\u001A\u00020&H\u0082@¢\u0006\u0002\u0010.J\b\u0010/\u001A\u00020&H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u000E\u001A\u00020\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0011R\u000E\u0010\u0012\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0018\u001A\u0010\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001B\u0018\u00010\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\u001D\u001A\u0004\u0018\u00010\u000B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u000B@BX\u0082\u000E¢\u0006\b\n\u0000\"\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u000B8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"R\u001A\u0010#\u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020$0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+R\u000E\u00100\u001A\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2={"Landroidx/compose/material3/IndicatorLineNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "textFieldShape", "Landroidx/compose/ui/graphics/Shape;", "focusedIndicatorWidth", "Landroidx/compose/ui/unit/Dp;", "unfocusedIndicatorWidth", "<init>", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "focused", "trackFocusStateJob", "Lkotlinx/coroutines/Job;", "_colors", "getColors", "()Landroidx/compose/material3/TextFieldColors;", "colorAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "value", "_shape", "set_shape", "(Landroidx/compose/ui/graphics/Shape;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "widthAnimatable", "Landroidx/compose/animation/core/AnimationVector1D;", "update", "", "update-gv0btCI", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "onAttach", "trackFocusState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidateIndicator", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class IndicatorLineNode extends DelegatingNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private TextFieldColors _colors;
    private Shape _shape;
    private Animatable colorAnimatable;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private boolean enabled;
    private boolean focused;
    private float focusedIndicatorWidth;
    private InteractionSource interactionSource;
    private boolean isError;
    private Job trackFocusStateJob;
    private float unfocusedIndicatorWidth;
    private final Animatable widthAnimatable;

    static {
    }

    public IndicatorLineNode(boolean arg1, boolean arg2, InteractionSource arg3, TextFieldColors arg4, Shape arg5, float arg6, float arg7, DefaultConstructorMarker arg8) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    private IndicatorLineNode(boolean arg1, boolean arg2, InteractionSource arg3, TextFieldColors arg4, Shape arg5, float arg6, float arg7) {
        super();
        this.enabled = arg1;
        this.isError = arg2;
        this.interactionSource = arg3;
        this.focusedIndicatorWidth = arg6;
        this.unfocusedIndicatorWidth = arg7;
        this._colors = arg4;
        this._shape = arg5;
        float v2 = !this.focused || !this.enabled ? this.unfocusedIndicatorWidth : this.focusedIndicatorWidth;
        this.widthAnimatable = new Animatable(Dp.box-impl(v2), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
        this.drawWithCacheModifierNode = this.delegate(DrawModifierKt.CacheDrawModifierNode(new IndicatorLineNode$$ExternalSyntheticLambda0(this)));
    }

    public static final Animatable access$getColorAnimatable$p(IndicatorLineNode arg0) {
        return arg0.colorAnimatable;
    }

    public static final TextFieldColors access$getColors(IndicatorLineNode arg0) {
        return arg0.getColors();
    }

    public static final boolean access$getEnabled$p(IndicatorLineNode arg0) {
        return arg0.enabled;
    }

    public static final boolean access$getFocused$p(IndicatorLineNode arg0) {
        return arg0.focused;
    }

    public static final float access$getFocusedIndicatorWidth$p(IndicatorLineNode arg0) {
        return arg0.focusedIndicatorWidth;
    }

    public static final float access$getUnfocusedIndicatorWidth$p(IndicatorLineNode arg0) {
        return arg0.unfocusedIndicatorWidth;
    }

    public static final Animatable access$getWidthAnimatable$p(IndicatorLineNode arg0) {
        return arg0.widthAnimatable;
    }

    public static final void access$invalidateIndicator(IndicatorLineNode arg0) {
        arg0.invalidateIndicator();
    }

    public static final boolean access$isError$p(IndicatorLineNode arg0) {
        return arg0.isError;
    }

    public static final void access$setFocused$p(IndicatorLineNode arg0, boolean arg1) {
        arg0.focused = arg1;
    }

    public static final Object access$trackFocusState(IndicatorLineNode arg0, Continuation arg1) {
        return arg0.trackFocusState(arg1);
    }

    static final DrawResult drawWithCacheModifierNode$lambda$3(IndicatorLineNode arg10, CacheDrawScope arg11) {
        float v0 = arg11.toPx-0680j_4(arg10.widthAnimatable.getValue().unbox-impl());
        Path v1 = AndroidPath_androidKt.Path();
        OutlineKt.addOutline(v1, arg10.getShape().createOutline-Pq9zytI(arg11.getSize-NH-jbRc(), arg11.getLayoutDirection(), arg11));
        Path v2 = AndroidPath_androidKt.Path();
        Path.addRect$default(v2, new Rect(0f, Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() & 0xFFFFFFFFL))) - v0, Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() >> 0x20))), Float.intBitsToFloat(((int)(arg11.getSize-NH-jbRc() & 0xFFFFFFFFL)))), null, 2, null);
        return arg11.onDrawWithContent(new IndicatorLineNode$$ExternalSyntheticLambda1(v2.and(v1), arg10));
    }

    static final Unit drawWithCacheModifierNode$lambda$3$lambda$2(Path arg9, IndicatorLineNode arg10, ContentDrawScope arg11) {
        arg11.drawContent();
        Animatable v10 = arg10.colorAnimatable;
        Intrinsics.checkNotNull(v10);
        DrawScope.drawPath-GBMwjPU$default(arg11, arg9, new SolidColor(v10.getValue().unbox-impl(), null), 0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    private final TextFieldColors getColors() {
        TextFieldColors v0 = this._colors;
        if(v0 == null) {
            return TextFieldDefaults.INSTANCE.defaultTextFieldColors$material3(CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), ColorSchemeKt.getLocalColorScheme()), CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), TextSelectionColorsKt.getLocalTextSelectionColors()));
        }

        return v0;
    }

    private final Shape getShape() {
        Shape v0 = this._shape;
        if(v0 == null) {
            return ShapesKt.fromToken(CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), ShapesKt.getLocalShapes()), FilledTextFieldTokens.INSTANCE.getContainerShape());
        }

        return v0;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    private final void invalidateIndicator() {
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new IndicatorLineNode$invalidateIndicator$1(this, null), 3, null);
        BuildersKt.launch$default(this.getCoroutineScope(), null, null, new IndicatorLineNode$invalidateIndicator$2(this, null), 3, null);
    }

    public void onAttach() {
        this.trackFocusStateJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new IndicatorLineNode$onAttach$1(this, null), 3, null);
        if(this.colorAnimatable == null) {
            long v0 = this.getColors().indicatorColor-XeAY9LY$material3(this.enabled, this.isError, this.focused);
            this.colorAnimatable = new Animatable(Color.box-impl(v0), ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(v0)), null, null, 12, null);
        }
    }

    private final void set_shape(Shape arg2) {
        if(!Intrinsics.areEqual(this._shape, arg2)) {
            this._shape = arg2;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    private final Object trackFocusState(Continuation arg4) {
        this.focused = false;
        Object v3 = this.interactionSource.getInteractions().collect(new IndicatorLineNode$trackFocusState$2(new ArrayList(), this), arg4);
        if(v3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v3;
        }

        return Unit.INSTANCE;
    }

    public final void update-gv0btCI(boolean arg9, boolean arg10, InteractionSource arg11, TextFieldColors arg12, Shape arg13, float arg14, float arg15) {
        int v9;
        int v1 = 1;
        if(this.enabled != arg9) {
            this.enabled = arg9;
            v9 = 1;
        }
        else {
            v9 = 0;
        }

        if(this.isError != arg10) {
            this.isError = arg10;
            v9 = 1;
        }

        if(this.interactionSource != arg11) {
            this.interactionSource = arg11;
            Job v10 = this.trackFocusStateJob;
            CancellationException v11 = null;
            if(v10 != null) {
                DefaultImpls.cancel$default(v10, v11, 1, v11);
            }

            this.trackFocusStateJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new IndicatorLineNode$update$1(this, ((Continuation)v11)), 3, null);
        }

        if(!Intrinsics.areEqual(this._colors, arg12)) {
            this._colors = arg12;
            v9 = 1;
        }

        if(!Intrinsics.areEqual(this._shape, arg13)) {
            this.set_shape(arg13);
            v9 = 1;
        }

        if(!Dp.equals-impl0(this.focusedIndicatorWidth, arg14)) {
            this.focusedIndicatorWidth = arg14;
            v9 = 1;
        }

        if(!Dp.equals-impl0(this.unfocusedIndicatorWidth, arg15)) {
            this.unfocusedIndicatorWidth = arg15;
        }
        else {
            v1 = v9;
        }

        if(v1 != 0) {
            this.invalidateIndicator();
        }
    }
}

