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

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0018\u001A\u00020\u0019*\u00020\u001A2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001D0\u001C2\u0006\u0010\u001E\u001A\u00020\u001FH\u0016¢\u0006\u0004\b \u0010!J\"\u0010\"\u001A\u00020#*\u00020$2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020%0\u001C2\u0006\u0010&\u001A\u00020#H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0015\u0010\u0013R\u0013\u0010\n\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0016\u0010\u0013R\u0013\u0010\u000B\u001A\u00020\b¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0017\u0010\u0013¨\u0006\'"}, d2={"Landroidx/compose/material3/TopIconOrIconOnlyMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "hasLabel", "", "indicatorAnimationProgress", "Lkotlin/Function0;", "", "indicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "topIconItemVerticalPadding", "<init>", "(ZLkotlin/jvm/functions/Function0;FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHasLabel", "()Z", "getIndicatorAnimationProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getIndicatorVerticalPadding-D9Ej5fM", "getIndicatorToLabelVerticalPadding-D9Ej5fM", "getTopIconItemVerticalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {
    private final boolean hasLabel;
    private final Function0 indicatorAnimationProgress;
    private final float indicatorHorizontalPadding;
    private final float indicatorToLabelVerticalPadding;
    private final float indicatorVerticalPadding;
    private final float topIconItemVerticalPadding;

    public TopIconOrIconOnlyMeasurePolicy(boolean arg1, Function0 arg2, float arg3, float arg4, float arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean arg1, Function0 arg2, float arg3, float arg4, float arg5, float arg6) {
        super();
        this.hasLabel = arg1;
        this.indicatorAnimationProgress = arg2;
        this.indicatorHorizontalPadding = arg3;
        this.indicatorVerticalPadding = arg4;
        this.indicatorToLabelVerticalPadding = arg5;
        this.topIconItemVerticalPadding = arg6;
    }

    public final boolean getHasLabel() {
        return this.hasLabel;
    }

    public final Function0 getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    public final float getIndicatorHorizontalPadding-D9Ej5fM() {
        return this.indicatorHorizontalPadding;
    }

    public final float getIndicatorToLabelVerticalPadding-D9Ej5fM() {
        return this.indicatorToLabelVerticalPadding;
    }

    public final float getIndicatorVerticalPadding-D9Ej5fM() {
        return this.indicatorVerticalPadding;
    }

    public final float getTopIconItemVerticalPadding-D9Ej5fM() {
        return this.topIconItemVerticalPadding;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg8, List arg9, int arg10) {
        Object v4;
        List v0 = arg9;
        int v1 = ((Collection)v0).size();
        int v2 = 0;
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            v4 = arg9.get(v3);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(((IntrinsicMeasurable)v4)), "icon")) {
                v1 = ((IntrinsicMeasurable)v4).maxIntrinsicHeight(arg10);
                int v0_1 = ((Collection)v0).size();
                v3 = 0;
                goto label_13;
            }
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
        while(true) {
        label_13:
            if(v3 < v0_1) {
                v4 = arg9.get(v3);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v4), "label")) {
                }
                else {
                    ++v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_24;
        }

        v4 = null;
    label_24:
        if(v4 != null) {
            v2 = ((IntrinsicMeasurable)v4).maxIntrinsicHeight(arg10);
        }

        return v1 + v2 + arg8.roundToPx-0680j_4(Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(this.topIconItemVerticalPadding * 2f) + Dp.constructor-impl(this.indicatorVerticalPadding * 2f)) + this.indicatorToLabelVerticalPadding));
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg19, List arg20, long arg21) {
        Placeable v3_2;
        Placeable v6;
        int v11;
        int v3_1;
        int v10;
        int v9_1;
        Placeable v5_1;
        Object v9;
        String v8;
        TopIconOrIconOnlyMeasurePolicy v0 = this;
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

            v9 = v2.get(v7);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "icon")) {
                v5_1 = ((Measurable)v9).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(v12, -v1.roundToPx-0680j_4(Dp.constructor-impl(v0.indicatorHorizontalPadding * 2f)), -v1.roundToPx-0680j_4(Dp.constructor-impl(v0.indicatorVerticalPadding * 2f))));
                v9_1 = v5_1.getWidth() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.indicatorHorizontalPadding * 2f));
                v10 = v5_1.getHeight() + v1.roundToPx-0680j_4(Dp.constructor-impl(v0.indicatorVerticalPadding * 2f));
                v3_1 = MathKt.roundToInt((((float)v9_1)) * v3);
                v7 = ((Collection)v4).size();
                v11 = 0;
                goto label_54;
            }

            ++v7;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_54:
        while(v11 < v7) {
            Object v14 = v2.get(v11);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v14)), "indicatorRipple")) {
                v6 = ((Measurable)v14).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v12, Constraints.Companion.fixed-JhjzzOo(v9_1, v10)));
                v7 = ((Collection)v4).size();
                v9_1 = 0;
                goto label_66;
            }

            ++v11;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_66:
        while(v9_1 < v7) {
            Object v11_1 = v2.get(v9_1);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v11_1)), "indicator")) {
                v3_2 = ((Measurable)v11_1).measure-BRTryo0(ConstraintsKt.constrain-N9IONVI(v12, Constraints.Companion.fixed-JhjzzOo(v3_1, v10)));
                if(v0.hasLabel) {
                    int v4_1 = ((Collection)v4).size();
                    v7 = 0;
                    goto label_80;
                }

                return NavigationItemKt.placeIcon-X9ElhV4(v1, v5_1, v6, v3_2, arg21);
            }

            ++v9_1;
            v5_1 = v5_1;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    label_80:
        while(v7 < v4_1) {
            v9 = v2.get(v7);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "label")) {
                return NavigationItemKt.placeLabelAndTopIcon-qoqLrGI(v1, ((Measurable)v9).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v12, 0, -(v3_2.getHeight() + v1.roundToPx-0680j_4(v0.indicatorToLabelVerticalPadding)), 1, null)), v5_1, v6, v3_2, arg21, v0.indicatorToLabelVerticalPadding, v0.indicatorVerticalPadding, v0.topIconItemVerticalPadding);
            }

            ++v7;
            v3_2 = v3_2;
            v5_1 = v5_1;
            v1 = arg19;
        }

        ListUtilsKt.throwNoSuchElementException(v8);
        throw new KotlinNothingValueException();
    }
}

