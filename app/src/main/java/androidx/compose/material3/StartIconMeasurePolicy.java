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
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0012\u001A\u00020\u0013*\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\"\u0010\u001C\u001A\u00020\u001D*\u00020\u001E2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u001F0\u00162\u0006\u0010 \u001A\u00020\u001DH\u0016J\"\u0010!\u001A\u00020\u001D*\u00020\u001E2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u001F0\u00162\u0006\u0010\"\u001A\u00020\u001DH\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\u0013\u0010\u0007\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0010\u0010\u000ER\u0013\u0010\b\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\u0011\u0010\u000E¨\u0006#"}, d2={"Landroidx/compose/material3/StartIconMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "startIconToLabelHorizontalPadding", "<init>", "(Lkotlin/jvm/functions/Function0;FFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicHeight", "width", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class StartIconMeasurePolicy implements MeasurePolicy {
    private final Function0 indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;

    public StartIconMeasurePolicy(Function0 arg1, float arg2, float arg3, float arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    private StartIconMeasurePolicy(Function0 arg1, float arg2, float arg3, float arg4) {
        super();
        this.indicatorAnimationProgress = arg1;
        this.indicatorHorizontalPadding = arg2;
        this.indicatorVerticalPadding = arg3;
        this.startIconToLabelHorizontalPadding = arg4;
    }

    public final Function0 getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    public final float getIndicatorHorizontalPadding-D9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    public final float getIndicatorVerticalPadding-D9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    public final float getStartIconToLabelHorizontalPadding-D9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg9, List arg10, int arg11) {
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
                v1 = ((IntrinsicMeasurable)v5).maxIntrinsicHeight(arg11);
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
                return Math.max(v1, ((IntrinsicMeasurable)v3_1).maxIntrinsicHeight(arg11)) + arg9.roundToPx-0680j_4(Dp.constructor-impl(this.indicatorVerticalPadding * 2f));
            }

            ++v2;
        }

        ListUtilsKt.throwNoSuchElementException(v4);
        throw new KotlinNothingValueException();
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
                return v1 + ((IntrinsicMeasurable)v3_1).maxIntrinsicWidth(arg11) + arg9.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(this.indicatorHorizontalPadding * 2f) + this.startIconToLabelHorizontalPadding));
            }

            ++v2;
        }

        ListUtilsKt.throwNoSuchElementException(v4);
        throw new KotlinNothingValueException();
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg19, List arg20, long arg21) {
        int v6;
        Placeable v1_1;
        Placeable v17;
        int v14;
        int v3_1;
        int v10_1;
        Placeable v7_1;
        int v9_1;
        Placeable v5_1;
        String v8;
        StartIconMeasurePolicy v0 = this;
        MeasureScope v1 = arg19;
        List v2 = arg20;
        float v3 = v0.indicatorAnimationProgress.invoke().floatValue();
        long v12 = Constraints.copy-Zbe2FdA$default(arg21, 0, 0, 0, 0, 10, null);
        List v4 = v2;
        int v5 = ((Collection)v4).size();
        int v7 = 0;
        while(true) {
            v8 = "Collection contains no element matching the predicate.";
            if(v7 >= v5) {
                break;
            }

            Object v9 = v2.get(v7);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "icon")) {
                v5_1 = ((Measurable)v9).measure-BRTryo0(v12);
                v7 = ((Collection)v4).size();
                v9_1 = 0;
                goto label_27;
            }

            ++v7;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_27:
        while(v9_1 < v7) {
            Object v10 = v2.get(v9_1);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v10)), "label")) {
                v7_1 = ((Measurable)v10).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v12, -(v5_1.getWidth() + v1.roundToPx-0680j_4(v0.startIconToLabelHorizontalPadding)), 0, 2, null));
                v9_1 = v5_1.getWidth() + v7_1.getWidth() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.startIconToLabelHorizontalPadding + Dp.constructor-impl(v0.indicatorHorizontalPadding * 2f)));
                v10_1 = Math.max(v5_1.getHeight(), v7_1.getHeight()) + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.indicatorVerticalPadding * 2f));
                v3_1 = MathKt.roundToInt((((float)v9_1)) * v3);
                int v11 = ((Collection)v4).size();
                v14 = 0;
                goto label_68;
            }

            ++v9_1;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_68:
        while(v14 < v11) {
            Object v15 = v2.get(v14);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v15)), "indicatorRipple")) {
                v17 = v5_1;
                v1_1 = ((Measurable)v15).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v12, Constraints.Companion.fixed-JhjzzOo(v9_1, v10_1)));
                int v4_1 = v4.size();
                v6 = 0;
                goto label_82;
            }

            ++v14;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_82:
        while(v6 < v4_1) {
            Object v5_2 = v2.get(v6);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v5_2)), "indicator")) {
                return NavigationItemKt.placeLabelAndStartIcon-nru01g4(arg19, v7_1, v17, v1_1, ((Measurable)v5_2).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v12, Constraints.Companion.fixed-JhjzzOo(v3_1, v10_1))), arg21, v0.startIconToLabelHorizontalPadding);
            }

            ++v6;
            v1_1 = v1_1;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    }
}

