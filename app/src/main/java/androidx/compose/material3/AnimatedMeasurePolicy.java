package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t\u0012\u0006\u0010\f\u001A\u00020\t\u0012\u0006\u0010\r\u001A\u00020\t\u0012\u0006\u0010\u000E\u001A\u00020\t\u0012\u0006\u0010\u000F\u001A\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010!\u001A\u00020\"*\u00020#2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\'\u001A\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\"\u0010+\u001A\u00020,*\u00020-2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001A\u00020,H\u0016R\u0013\u0010\u0002\u001A\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001B\u0010\u0019R\u0013\u0010\u000B\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001C\u0010\u0019R\u0013\u0010\f\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001D\u0010\u0019R\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001E\u0010\u0019R\u0013\u0010\u000E\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b\u001F\u0010\u0019R\u0013\u0010\u000F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\u001A\u001A\u0004\b \u0010\u0019¨\u00060"}, d2={"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "topIconIndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getTopIconIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getTopIconIndicatorVerticalPadding-D9Ej5fM", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "getStartIconIndicatorHorizontalPadding-D9Ej5fM", "getStartIconIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0 iconPositionProgress;
    private final Function0 indicatorAnimationProgress;
    private final float itemHorizontalPadding;
    private final float startIconIndicatorHorizontalPadding;
    private final float startIconIndicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;
    private final float topIconIndicatorVerticalPadding;

    private AnimatedMeasurePolicy(int arg1, Function0 arg2, Function0 arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10) {
        super();
        this.iconPosition = arg1;
        this.iconPositionProgress = arg2;
        this.indicatorAnimationProgress = arg3;
        this.topIconIndicatorHorizontalPadding = arg4;
        this.topIconIndicatorVerticalPadding = arg5;
        this.topIconIndicatorToLabelVerticalPadding = arg6;
        this.startIconIndicatorHorizontalPadding = arg7;
        this.startIconIndicatorVerticalPadding = arg8;
        this.startIconToLabelHorizontalPadding = arg9;
        this.itemHorizontalPadding = arg10;
    }

    public AnimatedMeasurePolicy(int arg1, Function0 arg2, Function0 arg3, float arg4, float arg5, float arg6, float arg7, float arg8, float arg9, float arg10, DefaultConstructorMarker arg11) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public final int getIconPosition--xw1Ddg() {
        return this.iconPosition;
    }

    public final Function0 getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0 getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    public final float getItemHorizontalPadding-D9Ej5fM() {
        return this.itemHorizontalPadding;
    }

    public final float getStartIconIndicatorHorizontalPadding-D9Ej5fM() {
        return this.startIconIndicatorHorizontalPadding;
    }

    public final float getStartIconIndicatorVerticalPadding-D9Ej5fM() {
        return this.startIconIndicatorVerticalPadding;
    }

    public final float getStartIconToLabelHorizontalPadding-D9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    public final float getTopIconIndicatorHorizontalPadding-D9Ej5fM() {
        return this.topIconIndicatorHorizontalPadding;
    }

    public final float getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    public final float getTopIconIndicatorVerticalPadding-D9Ej5fM() {
        return this.topIconIndicatorVerticalPadding;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg9, List arg10, int arg11) {
        String v4;
        List v0 = arg10;
        int v1 = ((Collection)v0).size();
        int v2 = 0;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = "Collection contains no element matching the predicate.";
            if(v3 >= v1) {
                break;
            }

            Object v5 = arg10.get(v3);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(((IntrinsicMeasurable)v5)), "icon")) {
                v1 = ((IntrinsicMeasurable)v5).maxIntrinsicWidth(arg11);
                int v0_1 = ((Collection)v0).size();
                goto label_13;
            }
        }

        ListUtilsKt.throwNoSuchElementException(v4);
        throw new KotlinNothingValueException();
    label_13:
        while(v2 < v0_1) {
            Object v3_1 = arg10.get(v2);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(((IntrinsicMeasurable)v3_1)), "label")) {
                int v10 = ((IntrinsicMeasurable)v3_1).maxIntrinsicWidth(arg11);
                float v0_2 = 2f;
                if(NavigationItemIconPosition.equals-impl0(this.iconPosition, NavigationItemIconPosition.Companion.getTop--xw1Ddg())) {
                    return Math.max(v10, v1 + arg9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(this.topIconIndicatorHorizontalPadding * v0_2) + Dp.constructor-impl(this.itemHorizontalPadding * v0_2))));
                }

                return v1 + v10 + arg9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(this.startIconIndicatorHorizontalPadding * v0_2) + this.startIconToLabelHorizontalPadding) + this.itemHorizontalPadding));
            }

            ++v2;
        }

        ListUtilsKt.throwNoSuchElementException(v4);
        throw new KotlinNothingValueException();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg20, List arg21, long arg22) {
        Placeable v1_1;
        int v4_1;
        int v3_1;
        int v14;
        int v7;
        int v13_1;
        Placeable v8_1;
        Object v13;
        int v12_1;
        Placeable v6_1;
        String v11;
        AnimatedMeasurePolicy v0 = this;
        MeasureScope v1 = arg20;
        List v2 = arg21;
        float v3 = v0.indicatorAnimationProgress.invoke().floatValue();
        float v4 = v0.iconPositionProgress.invoke().floatValue();
        long v9 = Constraints.copy-Zbe2FdA$default(arg22, 0, 0, 0, 0, 10, null);
        List v5 = v2;
        int v6 = ((Collection)v5).size();
        int v8 = 0;
        while(true) {
            v11 = "Collection contains no element matching the predicate.";
            if(v8 >= v6) {
                break;
            }

            Object v12 = v2.get(v8);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v12)), "icon")) {
                v6_1 = ((Measurable)v12).measure-BRTryo0(v9);
                v8 = ((Collection)v5).size();
                v12_1 = 0;
                goto label_30;
            }

            ++v8;
            v1 = arg20;
        }

        ListUtilsKt.throwNoSuchElementException(v11);
        throw new KotlinNothingValueException();
    label_30:
        while(v12_1 < v8) {
            v13 = v2.get(v12_1);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v13)), "label")) {
                v8_1 = ((Measurable)v13).measure-BRTryo0(v9);
                v12_1 = v6_1.getWidth() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.topIconIndicatorHorizontalPadding * 2f));
                v13_1 = v6_1.getHeight() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.topIconIndicatorVerticalPadding * 2f));
                int v15 = v6_1.getWidth() + v8_1.getWidth() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.startIconToLabelHorizontalPadding + Dp.constructor-impl(v0.startIconIndicatorHorizontalPadding * 2f)));
                v7 = Math.max(v6_1.getHeight(), v8_1.getHeight()) + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.startIconIndicatorVerticalPadding * 2f));
                v14 = MathHelpersKt.lerp(v12_1, v15, v4);
                v3_1 = MathKt.roundToInt((((float)v14)) * v3);
                v4_1 = MathHelpersKt.lerp(v13_1, v7, v4);
                v7 = ((Collection)v5).size();
                v13_1 = 0;
                goto label_77;
            }

            ++v12_1;
            v1 = arg20;
        }

        ListUtilsKt.throwNoSuchElementException(v11);
        throw new KotlinNothingValueException();
    label_77:
        while(v13_1 < v7) {
            Object v15_1 = v2.get(v13_1);
            List v23 = v5;
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v15_1)), "indicatorRipple")) {
                v1_1 = ((Measurable)v15_1).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v9, Constraints.Companion.fixed-JhjzzOo(v14, v4_1)));
                int v5_1 = ((Collection)v23).size();
                v7 = 0;
                goto label_90;
            }

            ++v13_1;
            v5 = v23;
            v8_1 = v8_1;
            v6_1 = v6_1;
        }

        ListUtilsKt.throwNoSuchElementException(v11);
        throw new KotlinNothingValueException();
    label_90:
        while(v7 < v5_1) {
            v13 = v2.get(v7);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v13)), "indicator")) {
                return NavigationItemKt.access$placeAnimatedLabelAndIcon-2QYhCQ8(arg20, v0.iconPosition, v0.iconPositionProgress, v8_1, v6_1, v1_1, ((Measurable)v13).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v9, Constraints.Companion.fixed-JhjzzOo(v3_1, v4_1))), v12_1, v9, v0.topIconIndicatorToLabelVerticalPadding, v0.topIconIndicatorVerticalPadding, v0.topIconIndicatorHorizontalPadding, v0.startIconIndicatorHorizontalPadding, v0.startIconIndicatorVerticalPadding, v0.startIconToLabelHorizontalPadding, v0.itemHorizontalPadding);
            }

            int v18 = v12_1;
            Placeable v12_2 = v1_1;
            v1_1 = v6_1;
            v6_1 = v8_1;
            v8 = v18;
            ++v7;
            Placeable v18_1 = v6_1;
            v6_1 = v1_1;
            v1_1 = v12_2;
            v12_1 = v8;
            v8_1 = v18_1;
        }

        ListUtilsKt.throwNoSuchElementException(v11);
        throw new KotlinNothingValueException();
    }
}

