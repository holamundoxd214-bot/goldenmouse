package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0013\u001A\u00020\u0014*\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001A\u00020\u001AH\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\"\u0010\u001D\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001A\u00020\u001EH\u0016J\"\u0010\"\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001A\u00020\u001EH\u0016J\"\u0010#\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001A\u00020\u001EH\u0016J\"\u0010%\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001A\u00020\u001EH\u0016J<\u0010&\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010$\u001A\u00020\u001E2\u0018\u0010\'\u001A\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001E0(H\u0002J<\u0010)\u001A\u00020\u001E*\u00020\u001F2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020 0\u00172\u0006\u0010!\u001A\u00020\u001E2\u0018\u0010\'\u001A\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001E0(H\u0002J[\u0010*\u001A\u00020\u001E*\u00020+2\u0006\u0010,\u001A\u00020\u001E2\u0006\u0010-\u001A\u00020\u001E2\u0006\u0010.\u001A\u00020\u001E2\u0006\u0010/\u001A\u00020\u001E2\u0006\u00100\u001A\u00020\u001E2\u0006\u00101\u001A\u00020\u001E2\u0006\u00102\u001A\u00020\u001E2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\n\u001A\u000203H\u0002¢\u0006\u0004\b4\u00105Jk\u00106\u001A\u00020\u001E*\u00020+2\u0006\u00107\u001A\u00020\u001E2\u0006\u00108\u001A\u00020\u001E2\u0006\u00109\u001A\u00020\u001E2\u0006\u0010:\u001A\u00020\u001E2\u0006\u0010;\u001A\u00020\u001E2\u0006\u0010<\u001A\u00020\u001E2\u0006\u0010=\u001A\u00020\u001E2\u0006\u0010>\u001A\u00020\u001E2\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u00072\u0006\u0010\n\u001A\u000203H\u0002¢\u0006\u0004\b@\u0010AJ\u009A\u0001\u0010B\u001A\u00020\u0005*\u00020C2\u0006\u0010D\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020\u001E2\b\u0010E\u001A\u0004\u0018\u00010F2\b\u0010G\u001A\u0004\u0018\u00010F2\b\u0010H\u001A\u0004\u0018\u00010F2\b\u0010I\u001A\u0004\u0018\u00010F2\u0006\u0010J\u001A\u00020F2\b\u0010K\u001A\u0004\u0018\u00010F2\b\u0010L\u001A\u0004\u0018\u00010F2\u0006\u0010M\u001A\u00020F2\b\u0010N\u001A\u0004\u0018\u00010F2\u0006\u0010O\u001A\u0002032\u0006\u0010P\u001A\u00020Q2\u0006\u0010?\u001A\u00020\u00072\u0006\u0010\n\u001A\u0002032\u0006\u0010R\u001A\u000203H\u0002R\u001A\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006S"}, d2={"Landroidx/compose/material3/OutlinedTextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "onLabelMeasured", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Size;", "", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "horizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "Landroidx/compose/ui/unit/Density;", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "", "calculateWidth-IzADHW4", "(Landroidx/compose/ui/unit/Density;IIIIIIIJF)I", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "iconPadding", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    private final float horizontalIconPadding;
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final Function1 onLabelMeasured;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public OutlinedTextFieldMeasurePolicy(Function1 arg1, boolean arg2, TextFieldLabelPosition arg3, FloatProducer arg4, PaddingValues arg5, float arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    private OutlinedTextFieldMeasurePolicy(Function1 arg1, boolean arg2, TextFieldLabelPosition arg3, FloatProducer arg4, PaddingValues arg5, float arg6) {
        super();
        this.onLabelMeasured = arg1;
        this.singleLine = arg2;
        this.labelPosition = arg3;
        this.labelProgress = arg4;
        this.paddingValues = arg5;
        this.horizontalIconPadding = arg6;
    }

    private final int calculateHeight-mKXJcVc(Density arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, long arg12, boolean arg14, float arg15) {
        int v1 = arg14 ? 0 : MathHelpersKt.lerp(arg9, 0, arg15);
        arg6 = ComparisonsKt.maxOf(arg8, new int[]{arg10, arg6, arg7, v1});
        float v7 = arg3.toPx-0680j_4(this.paddingValues.calculateTopPadding-D9Ej5fM());
        if(arg14) {
        }
        else {
            v7 = MathHelpersKt.lerp(v7, Math.max(v7, (((float)arg9)) / 2f), arg15);
        }

        return ConstraintsKt.constrainHeight-K40F9xA(arg12, Math.max(arg4, Math.max(arg5, MathKt.roundToInt(v7 + (((float)arg6)) + arg3.toPx-0680j_4(this.paddingValues.calculateBottomPadding-D9Ej5fM())))) + arg11);
    }

    private final int calculateWidth-IzADHW4(Density arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, long arg9, float arg11) {
        arg4 += arg5;
        return ConstraintsKt.constrainWidth-K40F9xA(arg9, Math.max(arg2 + Math.max(arg6 + arg4, Math.max(arg8 + arg4, MathHelpersKt.lerp(arg7, 0, arg11))) + arg3, MathKt.roundToInt(((((float)arg7)) + arg1.toPx-0680j_4(Dp.constructor-impl(this.paddingValues.calculateLeftPadding-u2uoSUM(LayoutDirection.Ltr) + this.paddingValues.calculateRightPadding-u2uoSUM(LayoutDirection.Ltr)))) * arg11)));
    }

    private final int intrinsicHeight(IntrinsicMeasureScope arg26, List arg27, int arg28, Function2 arg29) {
        Object v11_1;
        int v16;
        int v8;
        Object v14;
        Object v12;
        int v9_1;
        Object v9;
        OutlinedTextFieldMeasurePolicy v0 = this;
        List v1 = arg27;
        int v2 = arg28;
        Function2 v3 = arg29;
        float v13 = v0.labelProgress.invoke();
        List v4 = v1;
        int v5 = ((Collection)v4).size();
        int v7 = 0;
        while(true) {
            if(v7 < v5) {
                v9 = v1.get(v7);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v9), "Leading")) {
                }
                else {
                    ++v7;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_20;
        }

        v9 = null;
    label_20:
        v5 = 0x7FFFFFFF;
        if(v9 != null) {
            v7 = LayoutUtilKt.subtractConstraintSafely(v2, ((IntrinsicMeasurable)v9).maxIntrinsicWidth(v5));
            v9_1 = v3.invoke(v9, Integer.valueOf(v2)).intValue();
        }
        else {
            v7 = v2;
            v9_1 = 0;
        }

        int v10 = ((Collection)v4).size();
        int v11 = 0;
        while(true) {
            if(v11 < v10) {
                v12 = v1.get(v11);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v12), "Trailing")) {
                }
                else {
                    ++v11;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_43;
        }

        v12 = null;
    label_43:
        if(v12 != null) {
            v7 = LayoutUtilKt.subtractConstraintSafely(v7, ((IntrinsicMeasurable)v12).maxIntrinsicWidth(v5));
            v10 = v3.invoke(v12, Integer.valueOf(v2)).intValue();
        }
        else {
            v10 = 0;
        }

        v11 = ((Collection)v4).size();
        int v12_1 = 0;
        while(true) {
            if(v12_1 < v11) {
                v14 = v1.get(v12_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Label")) {
                }
                else {
                    ++v12_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_64;
        }

        v14 = null;
    label_64:
        int v6 = v14 != null ? v3.invoke(v14, Integer.valueOf(MathHelpersKt.lerp(v7, v2, v13))).intValue() : 0;
        v11 = ((Collection)v4).size();
        v12_1 = 0;
        while(true) {
            if(v12_1 < v11) {
                v14 = v1.get(v12_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Prefix")) {
                }
                else {
                    ++v12_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_84;
        }

        v14 = null;
    label_84:
        if(v14 != null) {
            v8 = v3.invoke(v14, Integer.valueOf(v7)).intValue();
            v7 = LayoutUtilKt.subtractConstraintSafely(v7, ((IntrinsicMeasurable)v14).maxIntrinsicWidth(v5));
        }
        else {
            v8 = 0;
        }

        v11 = ((Collection)v4).size();
        v12_1 = 0;
        while(true) {
            if(v12_1 < v11) {
                v14 = v1.get(v12_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Suffix")) {
                }
                else {
                    ++v12_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_106;
        }

        v14 = null;
    label_106:
        if(v14 != null) {
            v5 = v3.invoke(v14, Integer.valueOf(v7)).intValue();
            v7 = LayoutUtilKt.subtractConstraintSafely(v7, ((IntrinsicMeasurable)v14).maxIntrinsicWidth(0x7FFFFFFF));
        }
        else {
            v5 = 0;
        }

        v11 = ((Collection)v4).size();
        v12_1 = 0;
        while(v12_1 < v11) {
            v14 = v1.get(v12_1);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "TextField")) {
                v2 = v3.invoke(v14, Integer.valueOf(v7)).intValue();
                v11 = ((Collection)v4).size();
                v12_1 = 0;
                goto label_129;
            }

            ++v12_1;
            v6 = v6;
            v0 = this;
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
        while(true) {
        label_129:
            if(v12_1 < v11) {
                v14 = v1.get(v12_1);
                v16 = v2;
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Hint")) {
                }
                else {
                    ++v12_1;
                    v2 = v16;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_143;
        }

        v16 = v2;
        v14 = null;
    label_143:
        v2 = v14 != null ? v3.invoke(v14, Integer.valueOf(v7)).intValue() : 0;
        int v4_1 = ((Collection)v4).size();
        v7 = 0;
        while(true) {
            if(v7 < v4_1) {
                v11_1 = v1.get(v7);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v11_1), "Supporting")) {
                }
                else {
                    ++v7;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_162;
        }

        v11_1 = null;
    label_162:
        if(v11_1 != null) {
            v4_1 = v8;
            v8 = v2;
            v2 = v9_1;
            v9_1 = v3.invoke(v11_1, Integer.valueOf(arg28)).intValue();
        }
        else {
            v4_1 = v8;
            v8 = v2;
            v2 = v9_1;
            v9_1 = 0;
        }

        return v0.calculateHeight-mKXJcVc(arg26, v2, v10, v4_1, v5, v16, v6, v8, v9_1, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), v0.labelPosition instanceof Above, v13);
    }

    private final int intrinsicWidth(IntrinsicMeasureScope arg18, List arg19, int arg20, Function2 arg21) {
        Object v10;
        Object v9;
        Object v7;
        int v11;
        Object v6;
        List v0 = arg19;
        Function2 v1 = arg21;
        List v2 = v0;
        int v3 = ((Collection)v2).size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            v6 = v0.get(v5);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v6), "TextField")) {
                v11 = v1.invoke(v6, Integer.valueOf(arg20)).intValue();
                v3 = ((Collection)v2).size();
                v5 = 0;
                goto label_18;
            }
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
        while(true) {
        label_18:
            v6 = null;
            if(v5 < v3) {
                v7 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v7), "Label")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_30;
        }

        v7 = v6;
    label_30:
        int v12 = v7 != null ? v1.invoke(v7, Integer.valueOf(arg20)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v7 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v7), "Trailing")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_50;
        }

        v7 = v6;
    label_50:
        int v8 = v7 != null ? v1.invoke(v7, Integer.valueOf(arg20)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v7 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v7), "Leading")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_70;
        }

        v7 = v6;
    label_70:
        int v7_1 = v7 != null ? v1.invoke(v7, Integer.valueOf(arg20)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v9 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v9), "Prefix")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_90;
        }

        v9 = v6;
    label_90:
        int v9_1 = v9 != null ? v1.invoke(v9, Integer.valueOf(arg20)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v10 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v10), "Suffix")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_110;
        }

        v10 = v6;
    label_110:
        int v10_1 = v10 != null ? v1.invoke(v10, Integer.valueOf(arg20)).intValue() : 0;
        int v2_1 = ((Collection)v2).size();
        v3 = 0;
        while(v3 < v2_1) {
            Object v5_1 = v0.get(v3);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v5_1), "Hint")) {
                v6 = v5_1;
            }
            else {
                ++v3;
                continue;
            }

            break;
        }

        if(v6 != null) {
            v4 = v1.invoke(v6, Integer.valueOf(arg20)).intValue();
        }

        return this.calculateWidth-IzADHW4(arg18, v7_1, v8, v9_1, v10_1, v11, v12, v4, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), this.labelProgress.invoke());
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicHeight(arg2, arg3, arg4, new OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda3());
    }

    static final int maxIntrinsicHeight$lambda$12(IntrinsicMeasurable arg0, int arg1) {
        return arg0.maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicWidth(arg2, arg3, arg4, new OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda1());
    }

    static final int maxIntrinsicWidth$lambda$14(IntrinsicMeasurable arg0, int arg1) {
        return arg0.maxIntrinsicWidth(arg1);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg51, List arg52, long arg53) {
        Placeable v2_3;
        int v41;
        long v2_2;
        Placeable v35;
        int v18;
        boolean v16_1;
        Object v2_1;
        int v17;
        String v34;
        Object v10;
        int v21;
        Object v9;
        Placeable v28;
        long v7_1;
        Placeable v26;
        long v16;
        Object v8;
        Object v6;
        OutlinedTextFieldMeasurePolicy v0 = this;
        MeasureScope v14 = arg51;
        List v15 = arg52;
        float v11 = v0.labelProgress.invoke();
        int v1 = v14.roundToPx-0680j_4(v0.paddingValues.calculateBottomPadding-D9Ej5fM());
        long v4 = Constraints.copy-Zbe2FdA$default(arg53, 0, 0, 0, 0, 10, null);
        List v24 = v15;
        int v2 = ((Collection)v24).size();
        int v3 = 0;
        while(true) {
            if(v3 < v2) {
                v6 = v15.get(v3);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Leading")) {
                }
                else {
                    ++v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_31;
        }

        v6 = null;
    label_31:
        Placeable v25 = v6 != null ? ((Measurable)v6).measure-BRTryo0(v4) : null;
        v2 = LayoutUtilKt.getWidthOrZero(v25);
        v3 = Math.max(0, LayoutUtilKt.getHeightOrZero(v25));
        int v6_1 = ((Collection)v24).size();
        int v7 = 0;
        while(true) {
            if(v7 < v6_1) {
                v8 = v15.get(v7);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v8), "Trailing")) {
                }
                else {
                    ++v7;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_52;
        }

        v8 = null;
    label_52:
        if(v8 != null) {
            v16 = v4;
            v26 = ((Measurable)v8).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v16, -v2, 0, 2, null));
        }
        else {
            v16 = v4;
            v26 = null;
        }

        v2 += LayoutUtilKt.getWidthOrZero(v26);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v26));
        int v4_1 = ((Collection)v24).size();
        int v5 = 0;
        while(true) {
            if(v5 < v4_1) {
                v6 = v15.get(v5);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Prefix")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_82;
        }

        v6 = null;
    label_82:
        Placeable v27 = v6 != null ? ((Measurable)v6).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v16, -v2, 0, 2, null)) : null;
        v2 += LayoutUtilKt.getWidthOrZero(v27);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v27));
        v4_1 = ((Collection)v24).size();
        v5 = 0;
        while(true) {
            if(v5 < v4_1) {
                v6 = v15.get(v5);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Suffix")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_110;
        }

        v6 = null;
    label_110:
        if(v6 != null) {
            v7_1 = v16;
            v28 = ((Measurable)v6).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v16, -v2, 0, 2, null));
        }
        else {
            v7_1 = v16;
            v28 = null;
        }

        v2 += LayoutUtilKt.getWidthOrZero(v28);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v28));
        boolean v4_2 = v0.labelPosition instanceof Above;
        v5 = ((Collection)v24).size();
        v6_1 = 0;
        while(true) {
            if(v6_1 < v5) {
                v9 = v15.get(v6_1);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v9), "Label")) {
                }
                else {
                    ++v6_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_143;
        }

        v9 = null;
    label_143:
        Object v12 = v9;
        ObjectRef v5_1 = new ObjectRef();
        long v30 = 0xFFFFFFFFL;
        int v32 = 0x20;
        if(!v4_2) {
            v6_1 = v14.roundToPx-0680j_4(v0.paddingValues.calculateLeftPadding-u2uoSUM(v14.getLayoutDirection())) + v14.roundToPx-0680j_4(v0.paddingValues.calculateRightPadding-u2uoSUM(v14.getLayoutDirection()));
            long v9_1 = ConstraintsKt.offset-NN6Ew-U(v7_1, -MathHelpersKt.lerp(v2 + v6_1, v6_1, v11), -v1);
            if(v12 != null) {
                Placeable v6_2 = ((Measurable)v12).measure-BRTryo0(v9_1);
            }
            else {
                v6 = null;
            }

            v5_1.element = v6;
            v6 = v5_1.element;
            v9_1 = v6 != null ? Size.constructor-impl((((long)Float.floatToRawIntBits(((float)((Placeable)v6).getWidth())))) << v32 | (((long)Float.floatToRawIntBits(((float)((Placeable)v6).getHeight())))) & v30) : Size.Companion.getZero-NH-jbRc();
            v0.onLabelMeasured.invoke(Size.box-impl(v9_1));
            v21 = 0;
        }
        else {
            v6_1 = v12 != null ? ((Measurable)v12).minIntrinsicHeight(Constraints.getMinWidth-impl(arg53)) : 0;
            v21 = v6_1;
        }

        v6_1 = ((Collection)v24).size();
        int v9_2 = 0;
        while(true) {
            if(v9_2 < v6_1) {
                v10 = v15.get(v9_2);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v10), "Supporting")) {
                }
                else {
                    ++v9_2;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_209;
        }

        v10 = null;
    label_209:
        Object v13 = v10;
        v6_1 = v13 != null ? ((Measurable)v13).minIntrinsicHeight(Constraints.getMinWidth-impl(arg53)) : 0;
        if(v4_2) {
            v14 = arg51;
            v9_2 = v14.roundToPx-0680j_4(v0.paddingValues.calculateTopPadding-D9Ej5fM());
        }
        else {
            v14 = arg51;
            v9_2 = Math.max(LayoutUtilKt.getHeightOrZero(v5_1.element) / 2, v14.roundToPx-0680j_4(v0.paddingValues.calculateTopPadding-D9Ej5fM()));
        }

        int v10_1 = -v1 - v9_2 - v21 - v6_1;
        v6_1 = v1;
        long v0_1 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U(arg53, -v2, v10_1), 0, 0, 0, 0, 11, null);
        v2 = ((Collection)v24).size();
        v10_1 = 0;
        while(true) {
            v34 = "Collection contains no element matching the predicate.";
            if(v10_1 >= v2) {
                break;
            }

            v17 = v2;
            v2_1 = v15.get(v10_1);
            v16_1 = v4_2;
            v18 = v6_1;
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v2_1)), "TextField")) {
                v35 = ((Measurable)v2_1).measure-BRTryo0(v0_1);
                v0_1 = Constraints.copy-Zbe2FdA$default(v0_1, 0, 0, 0, 0, 14, null);
                v2 = ((Collection)v24).size();
                v4_1 = 0;
                goto label_268;
            }

            ++v10_1;
            v5_1 = v5_1;
            v4_2 = v16_1;
            v2 = v17;
            v6_1 = v18;
            v14 = arg51;
            v7_1 = v7_1;
            v0_1 = v0_1;
        }

        ListUtilsKt.throwNoSuchElementException(v34);
        throw new KotlinNothingValueException();
        while(true) {
        label_268:
            if(v4_1 < v2) {
                v6 = v15.get(v4_1);
                v17 = v2;
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Hint")) {
                }
                else {
                    ++v4_1;
                    v2 = v17;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_281;
        }

        v6 = null;
    label_281:
        Placeable v36 = v6 != null ? ((Measurable)v6).measure-BRTryo0(v0_1) : null;
        MeasureScope v1_1 = v14;
        int v15_1 = Math.max(v3, Math.max(LayoutUtilKt.getHeightOrZero(v35), LayoutUtilKt.getHeightOrZero(v36)) + v9_2 + v18);
        ObjectRef v14_1 = v5_1;
        boolean v37 = v16_1;
        v16 = v7_1;
        v0 = this;
        int v19 = v0.calculateWidth-IzADHW4(((Density)v1_1), LayoutUtilKt.getWidthOrZero(v25), LayoutUtilKt.getWidthOrZero(v26), LayoutUtilKt.getWidthOrZero(v27), LayoutUtilKt.getWidthOrZero(v28), v35.getWidth(), LayoutUtilKt.getWidthOrZero(v5_1.element), LayoutUtilKt.getWidthOrZero(v36), arg53, v11);
        if(v37) {
            v2_2 = Constraints.copy-Zbe2FdA$default(v16, 0, v19, 0, v21, 5, null);
            v41 = v19;
            if(v12 != null) {
                v2_3 = ((Measurable)v12).measure-BRTryo0(v2_2);
            }
            else {
                v2_1 = null;
            }

            v14_1.element = v2_3;
            v2_1 = v14_1.element;
            v2_2 = v2_1 != null ? Size.constructor-impl((((long)Float.floatToRawIntBits(((float)((Placeable)v2_1).getWidth())))) << v32 | (((long)Float.floatToRawIntBits(((float)((Placeable)v2_1).getHeight())))) & v30) : Size.Companion.getZero-NH-jbRc();
            v0.onLabelMeasured.invoke(Size.box-impl(v2_2));
        }
        else {
            v41 = v19;
        }

        v2_2 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(v16, 0, -v15_1, 1, null), 0, v41, 0, 0, 9, null);
        v15_1 = v41;
        Placeable v33 = v13 != null ? ((Measurable)v13).measure-BRTryo0(v2_2) : null;
        int v16_2 = LayoutUtilKt.getHeightOrZero(v33);
        boolean v12_1 = v37;
        v2 = v0.calculateHeight-mKXJcVc(((Density)v1_1), LayoutUtilKt.getHeightOrZero(v25), LayoutUtilKt.getHeightOrZero(v26), LayoutUtilKt.getHeightOrZero(v27), LayoutUtilKt.getHeightOrZero(v28), v35.getHeight(), LayoutUtilKt.getHeightOrZero(v14_1.element), LayoutUtilKt.getHeightOrZero(v36), LayoutUtilKt.getHeightOrZero(v33), arg53, v12_1, v11);
        v11 = v11;
        int v0_2 = v2 - v16_2;
        v1 = v12_1 ? LayoutUtilKt.getHeightOrZero(v14_1.element) : 0;
        v0_2 -= v1;
        v1 = ((Collection)v24).size();
        v3 = 0;
        while(v3 < v1) {
            Object v5_2 = arg52.get(v3);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v5_2)), "Container")) {
                v1 = 0x7FFFFFFF;
                v3 = v15_1 != v1 ? v15_1 : 0;
                v1 = v0_2 != v1 ? v0_2 : 0;
                return MeasureScope.layout$default(arg51, v15_1, v2, null, new OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda2(this, v2, v15_1, v25, v26, v27, v28, v35, v14_1, v36, ((Measurable)v5_2).measure-BRTryo0(ConstraintsKt.Constraints(v3, v15_1, v1, v0_2)), v33, arg51, v12_1, v11), 4, null);
            }

            ++v3;
            v2 = v2;
            v12_1 = v12_1;
            v14_1 = v14_1;
        }

        ListUtilsKt.throwNoSuchElementException(v34);
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$11(OutlinedTextFieldMeasurePolicy arg19, int arg20, int arg21, Placeable arg22, Placeable arg23, Placeable arg24, Placeable arg25, Placeable arg26, ObjectRef arg27, Placeable arg28, Placeable arg29, Placeable arg30, MeasureScope arg31, boolean arg32, float arg33, PlacementScope arg34) {
        arg19.place(arg34, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27.element, arg28, arg29, arg30, arg31.getDensity(), arg31.getLayoutDirection(), arg32, arg33, arg31.toPx-0680j_4(arg19.horizontalIconPadding));
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicHeight(arg2, arg3, arg4, new OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda0());
    }

    static final int minIntrinsicHeight$lambda$13(IntrinsicMeasurable arg0, int arg1) {
        return arg0.minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicWidth(arg2, arg3, arg4, new OutlinedTextFieldMeasurePolicy$$ExternalSyntheticLambda4());
    }

    static final int minIntrinsicWidth$lambda$15(IntrinsicMeasurable arg0, int arg1) {
        return arg0.minIntrinsicWidth(arg1);
    }

    private final void place(PlacementScope arg22, int arg23, int arg24, Placeable arg25, Placeable arg26, Placeable arg27, Placeable arg28, Placeable arg29, Placeable arg30, Placeable arg31, Placeable arg32, Placeable arg33, float arg34, LayoutDirection arg35, boolean arg36, float arg37, float arg38) {
        int v0_1;
        int v2_1;
        int v7;
        OutlinedTextFieldMeasurePolicy v1 = this;
        int v6 = arg24;
        LayoutDirection v0 = arg35;
        float v2 = arg37;
        int v3 = 0;
        int v10 = arg36 ? LayoutUtilKt.getHeightOrZero(arg30) : 0;
        PlacementScope.place$default(arg22, arg32, 0, v10, 0f, 4, null);
        int v4 = arg23 - LayoutUtilKt.getHeightOrZero(arg33);
        int v5 = arg36 ? LayoutUtilKt.getHeightOrZero(arg30) : 0;
        v4 -= v5;
        v5 = MathKt.roundToInt(v1.paddingValues.calculateTopPadding-D9Ej5fM() * arg34);
        if(arg25 != null) {
            PlacementScope.placeRelative$default(arg22, arg25, 0, v10 + Alignment.Companion.getCenterVertically().align(arg25.getHeight(), v4), 0f, 4, null);
        }

        if(arg30 != null) {
            if(arg36) {
                v7 = 0;
            }
            else if(v1.singleLine) {
                v7 = Alignment.Companion.getCenterVertically().align(arg30.getHeight(), v4);
            }
            else {
                v7 = v5;
            }

            if(arg36) {
            }
            else {
                v3 = -(arg30.getHeight() / 2);
            }

            int v17 = MathHelpersKt.lerp(v7, v3, v2);
            if(arg36) {
                PlacementScope.place$default(arg22, arg30, TextFieldImplKt.getMinimizedAlignment(v1.labelPosition).align(arg30.getWidth(), v6, v0), v17, 0f, 4, null);
                goto label_130;
            }

            float v3_1 = PaddingKt.calculateStartPadding(v1.paddingValues, v0) * arg34;
            float v7_1 = PaddingKt.calculateEndPadding(v1.paddingValues, v0) * arg34;
            float v9 = arg25 == null ? v3_1 : (((float)arg25.getWidth())) + RangesKt.coerceAtLeast(v3_1 - arg38, 0f);
            float v11 = arg26 == null ? v7_1 : (((float)arg26.getWidth())) + RangesKt.coerceAtLeast(v7_1 - arg38, 0f);
            float v8 = v0 == LayoutDirection.Ltr ? v3_1 : v7_1;
            float v12 = v0 == LayoutDirection.Ltr ? v9 : v11;
            PlacementScope.place$default(arg22, arg30, MathKt.roundToInt(MathHelpersKt.lerp((((float)TextFieldImplKt.getExpandedAlignment(v1.labelPosition).align(arg30.getWidth(), v6 - MathKt.roundToInt(v9 + v11), v0))) + v12, (((float)TextFieldImplKt.getMinimizedAlignment(v1.labelPosition).align(arg30.getWidth(), v6 - MathKt.roundToInt(v3_1 + v7_1), v0))) + v8, v2)), v17, 0f, 4, null);
        }

    label_130:
        if(arg27 != null) {
            v2_1 = v4;
            v3 = v5;
            v0_1 = v10;
            PlacementScope.placeRelative$default(arg22, arg27, LayoutUtilKt.getWidthOrZero(arg25), OutlinedTextFieldMeasurePolicy.place$calculateVerticalPosition(v0_1, v1, v2_1, v3, arg30, arg27), 0f, 4, null);
        }
        else {
            v2_1 = v4;
            v3 = v5;
            v0_1 = v10;
        }

        int v16 = LayoutUtilKt.getWidthOrZero(arg25) + LayoutUtilKt.getWidthOrZero(arg27);
        PlacementScope.placeRelative$default(arg22, arg29, v16, OutlinedTextFieldMeasurePolicy.place$calculateVerticalPosition(v0_1, this, v2_1, v3, arg30, arg29), 0f, 4, null);
        if(arg31 != null) {
            PlacementScope.placeRelative$default(arg22, arg31, v16, OutlinedTextFieldMeasurePolicy.place$calculateVerticalPosition(v0_1, this, v2_1, v3, arg30, arg31), 0f, 4, null);
        }

        if(arg28 != null) {
            PlacementScope.placeRelative$default(arg22, arg28, v6 - LayoutUtilKt.getWidthOrZero(arg26) - arg28.getWidth(), OutlinedTextFieldMeasurePolicy.place$calculateVerticalPosition(v0_1, this, v2_1, v3, arg30, arg28), 0f, 4, null);
        }

        if(arg26 != null) {
            PlacementScope.placeRelative$default(arg22, arg26, v6 - arg26.getWidth(), v0_1 + Alignment.Companion.getCenterVertically().align(arg26.getHeight(), v2_1), 0f, 4, null);
        }

        if(arg33 != null) {
            PlacementScope.placeRelative$default(arg22, arg33, 0, v0_1 + v2_1, 0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(int arg1, OutlinedTextFieldMeasurePolicy arg2, int arg3, int arg4, Placeable arg5, Placeable arg6) {
        if(arg2.singleLine) {
            arg4 = Alignment.Companion.getCenterVertically().align(arg6.getHeight(), arg3);
        }

        arg1 += arg4;
        if((arg2.labelPosition instanceof Above)) {
            return arg1;
        }

        return Math.max(arg1, LayoutUtilKt.getHeightOrZero(arg5) / 2);
    }
}

