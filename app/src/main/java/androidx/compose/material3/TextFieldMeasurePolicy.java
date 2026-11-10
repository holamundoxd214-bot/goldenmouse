package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.ui.Alignment;
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
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;

@Metadata(d1={"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ)\u0010\u000F\u001A\u00020\u0010*\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\"\u0010\u001E\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010\u001D\u001A\u00020\u001AH\u0016J\"\u0010\u001F\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010 \u001A\u00020\u001AH\u0016J\"\u0010!\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010 \u001A\u00020\u001AH\u0016J8\u0010\"\u001A\u00020\u001A2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010 \u001A\u00020\u001A2\u0018\u0010#\u001A\u0014\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001A0$H\u0002J<\u0010%\u001A\u00020\u001A*\u00020\u001B2\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u001C0\u00132\u0006\u0010\u001D\u001A\u00020\u001A2\u0018\u0010#\u001A\u0014\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001A\u0012\u0004\u0012\u00020\u001A0$H\u0002JO\u0010&\u001A\u00020\u001A2\u0006\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020\u001A2\u0006\u0010)\u001A\u00020\u001A2\u0006\u0010*\u001A\u00020\u001A2\u0006\u0010+\u001A\u00020\u001A2\u0006\u0010,\u001A\u00020\u001A2\u0006\u0010-\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/Jk\u00100\u001A\u00020\u001A*\u0002012\u0006\u00102\u001A\u00020\u001A2\u0006\u00103\u001A\u00020\u001A2\u0006\u00104\u001A\u00020\u001A2\u0006\u00105\u001A\u00020\u001A2\u0006\u00106\u001A\u00020\u001A2\u0006\u00107\u001A\u00020\u001A2\u0006\u00108\u001A\u00020\u001A2\u0006\u00109\u001A\u00020\u001A2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010:\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020;H\u0002¢\u0006\u0004\b<\u0010=J \u0001\u0010>\u001A\u00020?*\u00020@2\u0006\u0010\u001D\u001A\u00020\u001A2\u0006\u0010A\u001A\u00020\u001A2\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020C2\b\u0010E\u001A\u0004\u0018\u00010C2\b\u0010F\u001A\u0004\u0018\u00010C2\b\u0010G\u001A\u0004\u0018\u00010C2\b\u0010H\u001A\u0004\u0018\u00010C2\b\u0010I\u001A\u0004\u0018\u00010C2\u0006\u0010J\u001A\u00020C2\b\u0010K\u001A\u0004\u0018\u00010C2\u0006\u0010L\u001A\u00020\u001A2\u0006\u0010M\u001A\u00020\u001A2\u0006\u0010:\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020;2\u0006\u0010N\u001A\u00020\u001A2\u0006\u0010O\u001A\u00020PH\u0002Jp\u0010Q\u001A\u00020?*\u00020@2\u0006\u0010\u001D\u001A\u00020\u001A2\u0006\u0010A\u001A\u00020\u001A2\u0006\u0010R\u001A\u00020C2\b\u0010E\u001A\u0004\u0018\u00010C2\b\u0010F\u001A\u0004\u0018\u00010C2\b\u0010G\u001A\u0004\u0018\u00010C2\b\u0010H\u001A\u0004\u0018\u00010C2\b\u0010I\u001A\u0004\u0018\u00010C2\u0006\u0010J\u001A\u00020C2\b\u0010K\u001A\u0004\u0018\u00010C2\u0006\u0010S\u001A\u00020;H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000E¨\u0006T"}, d2={"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "minimizedLabelHalfHeight", "Landroidx/compose/ui/unit/Dp;", "<init>", "(ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/PaddingValues;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicHeight", "maxIntrinsicWidth", "height", "minIntrinsicWidth", "intrinsicWidth", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "calculateWidth", "leadingWidth", "trailingWidth", "prefixWidth", "suffixWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-yeHjK3Y", "(IIIIIIIJ)I", "calculateHeight", "Landroidx/compose/ui/unit/Density;", "textFieldHeight", "labelHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "placeholderHeight", "supportingHeight", "isLabelAbove", "", "calculateHeight-mKXJcVc", "(Landroidx/compose/ui/unit/Density;IIIIIIIIJZF)I", "placeWithLabel", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "containerPlaceable", "supportingPlaceable", "labelStartY", "labelEndY", "textPosition", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeWithoutLabel", "textPlaceable", "density", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextFieldMeasurePolicy implements MeasurePolicy {
    private final TextFieldLabelPosition labelPosition;
    private final FloatProducer labelProgress;
    private final float minimizedLabelHalfHeight;
    private final PaddingValues paddingValues;
    private final boolean singleLine;

    public TextFieldMeasurePolicy(boolean arg1, TextFieldLabelPosition arg2, FloatProducer arg3, PaddingValues arg4, float arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg4, arg5);
    }

    private TextFieldMeasurePolicy(boolean arg1, TextFieldLabelPosition arg2, FloatProducer arg3, PaddingValues arg4, float arg5) {
        super();
        this.singleLine = arg1;
        this.labelPosition = arg2;
        this.labelProgress = arg3;
        this.paddingValues = arg4;
        this.minimizedLabelHalfHeight = arg5;
    }

    private final int calculateHeight-mKXJcVc(Density arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, long arg14, boolean arg16, float arg17) {
        float v0 = arg17;
        int v1 = arg5.roundToPx-0680j_4(Dp.constructor-impl(this.paddingValues.calculateTopPadding-D9Ej5fM() + this.paddingValues.calculateBottomPadding-D9Ej5fM()));
        int v3 = arg16 ? 0 : MathHelpersKt.lerp(arg7, 0, v0);
        arg6 = ComparisonsKt.maxOf(arg6, new int[]{arg12, arg10, arg11, v3});
        int v4 = arg7 <= 0 || (arg16) ? 0 : Math.max(arg5.roundToPx-0680j_4(Dp.constructor-impl(this.minimizedLabelHalfHeight * 2f)), MathHelpersKt.lerp(0, arg7, MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier().transform(v0)));
        return ConstraintsKt.constrainHeight-K40F9xA(arg14, Math.max(arg8, Math.max(arg9, v1 + v4 + arg6)) + arg13);
    }

    private final int calculateWidth-yeHjK3Y(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        arg3 += arg4;
        return ConstraintsKt.constrainWidth-K40F9xA(arg8, arg1 + Math.max(arg5 + arg3, Math.max(arg7 + arg3, arg6)) + arg2);
    }

    private final int intrinsicHeight(IntrinsicMeasureScope arg22, List arg23, int arg24, Function2 arg25) {
        List v18;
        int v7;
        int v5;
        Object v14;
        Object v13;
        Object v12;
        int v8_1;
        int v9;
        Object v8;
        TextFieldMeasurePolicy v0 = this;
        List v1 = arg23;
        Function2 v2 = arg25;
        List v3 = v1;
        int v4 = ((Collection)v3).size();
        int v6 = 0;
        while(true) {
            if(v6 < v4) {
                v8 = v1.get(v6);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v8), "Leading")) {
                }
                else {
                    ++v6;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_17;
        }

        v8 = null;
    label_17:
        v4 = 0x7FFFFFFF;
        if(v8 != null) {
            v9 = arg24;
            v6 = LayoutUtilKt.subtractConstraintSafely(v9, ((IntrinsicMeasurable)v8).maxIntrinsicWidth(v4));
            v8_1 = v2.invoke(v8, Integer.valueOf(v9)).intValue();
        }
        else {
            v9 = arg24;
            v6 = v9;
            v8_1 = 0;
        }

        int v10 = ((Collection)v3).size();
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

            goto label_42;
        }

        v12 = null;
    label_42:
        if(v12 != null) {
            v6 = LayoutUtilKt.subtractConstraintSafely(v6, ((IntrinsicMeasurable)v12).maxIntrinsicWidth(v4));
            v10 = v2.invoke(v12, Integer.valueOf(v9)).intValue();
        }
        else {
            v10 = 0;
        }

        v11 = ((Collection)v3).size();
        int v12_1 = 0;
        while(true) {
            if(v12_1 < v11) {
                v13 = v1.get(v12_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v13), "Label")) {
                }
                else {
                    ++v12_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_63;
        }

        v13 = null;
    label_63:
        v11 = v13 != null ? v2.invoke(v13, Integer.valueOf(v6)).intValue() : 0;
        v12_1 = ((Collection)v3).size();
        int v13_1 = 0;
        while(true) {
            if(v13_1 < v12_1) {
                v14 = v1.get(v13_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Prefix")) {
                }
                else {
                    ++v13_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_82;
        }

        v14 = null;
    label_82:
        if(v14 != null) {
            v5 = v2.invoke(v14, Integer.valueOf(v6)).intValue();
            int v19 = LayoutUtilKt.subtractConstraintSafely(v6, ((IntrinsicMeasurable)v14).maxIntrinsicWidth(v4));
            v6 = v5;
            v5 = v19;
        }
        else {
            v5 = v6;
            v6 = 0;
        }

        v12_1 = ((Collection)v3).size();
        v13_1 = 0;
        while(true) {
            if(v13_1 < v12_1) {
                v14 = v1.get(v13_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Suffix")) {
                }
                else {
                    ++v13_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_107;
        }

        v14 = null;
    label_107:
        if(v14 != null) {
            v7 = v2.invoke(v14, Integer.valueOf(v5)).intValue();
            v5 = LayoutUtilKt.subtractConstraintSafely(v5, ((IntrinsicMeasurable)v14).maxIntrinsicWidth(v4));
        }
        else {
            v7 = 0;
        }

        v4 = ((Collection)v3).size();
        v12_1 = 0;
        while(v12_1 < v4) {
            v13 = v1.get(v12_1);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v13), "TextField")) {
                v4 = v2.invoke(v13, Integer.valueOf(v5)).intValue();
                v12_1 = ((Collection)v3).size();
                v13_1 = 0;
                goto label_129;
            }

            ++v12_1;
            v0 = this;
            v3 = v3;
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
        while(true) {
        label_129:
            if(v13_1 < v12_1) {
                v14 = v1.get(v13_1);
                v18 = v3;
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v14), "Hint")) {
                }
                else {
                    ++v13_1;
                    v3 = v18;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_143;
        }

        v18 = v3;
        v14 = null;
    label_143:
        int v3_1 = v14 != null ? v2.invoke(v14, Integer.valueOf(v5)).intValue() : 0;
        v5 = ((Collection)v18).size();
        v12_1 = 0;
        while(true) {
            if(v12_1 < v5) {
                v13 = v1.get(v12_1);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v13), "Supporting")) {
                }
                else {
                    ++v12_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_162;
        }

        v13 = null;
    label_162:
        v9 = v13 != null ? v2.invoke(v13, Integer.valueOf(v9)).intValue() : 0;
        return v0.calculateHeight-mKXJcVc(arg22, v4, v11, v8_1, v10, v6, v7, v3_1, v9, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null), v0.labelPosition instanceof Above, v0.labelProgress.invoke());
    }

    private final int intrinsicWidth(List arg20, int arg21, Function2 arg22) {
        Object v12;
        Object v9;
        Object v8;
        Object v7;
        int v10;
        Object v6;
        List v0 = arg20;
        Function2 v1 = arg22;
        List v2 = v0;
        int v3 = ((Collection)v2).size();
        int v4 = 0;
        int v5;
        for(v5 = 0; v5 < v3; ++v5) {
            v6 = v0.get(v5);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v6), "TextField")) {
                v10 = v1.invoke(v6, Integer.valueOf(arg21)).intValue();
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
        int v11 = v7 != null ? v1.invoke(v7, Integer.valueOf(arg21)).intValue() : 0;
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
        int v7_1 = v7 != null ? v1.invoke(v7, Integer.valueOf(arg21)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v8 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v8), "Prefix")) {
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

        v8 = v6;
    label_70:
        int v8_1 = v8 != null ? v1.invoke(v8, Integer.valueOf(arg21)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v9 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v9), "Suffix")) {
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
        int v9_1 = v9 != null ? v1.invoke(v9, Integer.valueOf(arg21)).intValue() : 0;
        v3 = ((Collection)v2).size();
        v5 = 0;
        while(true) {
            if(v5 < v3) {
                v12 = v0.get(v5);
                if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v12), "Leading")) {
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

        v12 = v6;
    label_110:
        v3 = v12 != null ? v1.invoke(v12, Integer.valueOf(arg21)).intValue() : 0;
        int v2_1 = ((Collection)v2).size();
        v5 = 0;
        while(v5 < v2_1) {
            v12 = v0.get(v5);
            if(Intrinsics.areEqual(LayoutUtilKt.getLayoutId(v12), "Hint")) {
                v6 = v12;
            }
            else {
                ++v5;
                continue;
            }

            break;
        }

        if(v6 != null) {
            v4 = v1.invoke(v6, Integer.valueOf(arg21)).intValue();
        }

        return this.calculateWidth-yeHjK3Y(v3, v7_1, v8_1, v9_1, v10, v11, v4, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicHeight(arg2, arg3, arg4, new TextFieldMeasurePolicy$$ExternalSyntheticLambda4());
    }

    static final int maxIntrinsicHeight$lambda$10(IntrinsicMeasurable arg0, int arg1) {
        return arg0.maxIntrinsicHeight(arg1);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.intrinsicWidth(arg2, arg3, new TextFieldMeasurePolicy$$ExternalSyntheticLambda1());
    }

    static final int maxIntrinsicWidth$lambda$12(IntrinsicMeasurable arg0, int arg1) {
        return arg0.maxIntrinsicWidth(arg1);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg52, List arg53, long arg54) {
        Placeable v16_1;
        Placeable v0_3;
        Placeable v41;
        int v19;
        int v18;
        String v40;
        Object v9;
        int v30;
        Object v5_3;
        Placeable v14;
        long v7_1;
        Placeable v27;
        long v17;
        Object v8;
        Object v6;
        TextFieldMeasurePolicy v0 = this;
        List v15 = arg53;
        float v13 = v0.labelProgress.invoke();
        int v16 = arg52.roundToPx-0680j_4(v0.paddingValues.calculateTopPadding-D9Ej5fM());
        int v1 = arg52.roundToPx-0680j_4(v0.paddingValues.calculateBottomPadding-D9Ej5fM());
        long v4 = Constraints.copy-Zbe2FdA$default(arg54, 0, 0, 0, 0, 10, null);
        List v25 = v15;
        int v2 = ((Collection)v25).size();
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

            goto label_34;
        }

        v6 = null;
    label_34:
        Placeable v26 = v6 != null ? ((Measurable)v6).measure-BRTryo0(v4) : null;
        v2 = LayoutUtilKt.getWidthOrZero(v26);
        v3 = Math.max(0, LayoutUtilKt.getHeightOrZero(v26));
        int v6_1 = ((Collection)v25).size();
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

            goto label_55;
        }

        v8 = null;
    label_55:
        if(v8 != null) {
            v17 = v4;
            v27 = ((Measurable)v8).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v17, -v2, 0, 2, null));
        }
        else {
            v17 = v4;
            v27 = null;
        }

        v2 += LayoutUtilKt.getWidthOrZero(v27);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v27));
        int v4_1 = ((Collection)v25).size();
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

            goto label_85;
        }

        v6 = null;
    label_85:
        Placeable v28 = v6 != null ? ((Measurable)v6).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v17, -v2, 0, 2, null)) : null;
        v2 += LayoutUtilKt.getWidthOrZero(v28);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v28));
        v4_1 = ((Collection)v25).size();
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

            goto label_113;
        }

        v6 = null;
    label_113:
        if(v6 != null) {
            v7_1 = v17;
            v14 = ((Measurable)v6).measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(v17, -v2, 0, 2, null));
        }
        else {
            v7_1 = v17;
            v14 = null;
        }

        v2 += LayoutUtilKt.getWidthOrZero(v14);
        v3 = Math.max(v3, LayoutUtilKt.getHeightOrZero(v14));
        boolean v12 = v0.labelPosition instanceof Above;
        v4_1 = ((Collection)v25).size();
        v5 = 0;
        while(true) {
            if(v5 < v4_1) {
                v6 = v15.get(v5);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Label")) {
                }
                else {
                    ++v5;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_146;
        }

        v6 = null;
    label_146:
        Object v10 = v6;
        ObjectRef v4_2 = new ObjectRef();
        if(!v12) {
            long v5_1 = ConstraintsKt.offset-NN6Ew-U(v7_1, -v2, -v1);
            if(v10 != null) {
                Placeable v5_2 = ((Measurable)v10).measure-BRTryo0(v5_1);
            }
            else {
                v5_3 = null;
            }

            v4_2.element = v5_3;
            v30 = 0;
        }
        else {
            v5 = v10 != null ? ((Measurable)v10).minIntrinsicHeight(Constraints.getMinWidth-impl(arg54)) : 0;
            v30 = v5;
        }

        v5 = ((Collection)v25).size();
        v6_1 = 0;
        while(true) {
            if(v6_1 < v5) {
                v9 = v15.get(v6_1);
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v9), "Supporting")) {
                }
                else {
                    ++v6_1;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_180;
        }

        v9 = null;
    label_180:
        Object v11 = v9;
        int v0_1 = v11 != null ? ((Measurable)v11).minIntrinsicHeight(Constraints.getMinWidth-impl(arg54)) : 0;
        v5 = v16 + (LayoutUtilKt.getHeightOrZero(v4_2.element) + v30);
        int v17_1 = v1;
        long v0_2 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(arg54, 0, 0, 0, 0, 11, null), -v2, -v5 - v17_1 - v0_1);
        v2 = ((Collection)v25).size();
        v6_1 = 0;
        while(true) {
            v40 = "Collection contains no element matching the predicate.";
            if(v6_1 >= v2) {
                break;
            }

            v9 = v15.get(v6_1);
            v18 = v2;
            v19 = v5;
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v9)), "TextField")) {
                v41 = ((Measurable)v9).measure-BRTryo0(v0_2);
                v0_2 = Constraints.copy-Zbe2FdA$default(v0_2, 0, 0, 0, 0, 14, null);
                v2 = ((Collection)v25).size();
                v5 = 0;
                goto label_228;
            }

            ++v6_1;
            v2 = v18;
            v5 = v19;
            v12 = v12;
            v4_2 = v4_2;
            v0_2 = v0_2;
        }

        ListUtilsKt.throwNoSuchElementException(v40);
        throw new KotlinNothingValueException();
        while(true) {
        label_228:
            if(v5 < v2) {
                v6 = v15.get(v5);
                v18 = v2;
                if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(v6), "Hint")) {
                }
                else {
                    ++v5;
                    v2 = v18;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_241;
        }

        v6 = null;
    label_241:
        Placeable v32 = v6 != null ? ((Measurable)v6).measure-BRTryo0(v0_2) : null;
        v0_1 = Math.max(v3, Math.max(LayoutUtilKt.getHeightOrZero(v41), LayoutUtilKt.getHeightOrZero(v32)) + v19 + v17_1);
        v1 = LayoutUtilKt.getWidthOrZero(v26);
        v2 = LayoutUtilKt.getWidthOrZero(v27);
        v3 = LayoutUtilKt.getWidthOrZero(v28);
        v6_1 = LayoutUtilKt.getWidthOrZero(v14);
        v17 = v7_1;
        boolean v34 = v12;
        Placeable v33 = v14;
        int v12_1 = v0_1;
        ObjectRef v14_1 = v4_2;
        int v45 = this.calculateWidth-yeHjK3Y(v1, v2, v3, v6_1, v41.getWidth(), LayoutUtilKt.getWidthOrZero(v4_2.element), LayoutUtilKt.getWidthOrZero(v32), arg54);
        if(v34) {
            v0_2 = Constraints.copy-Zbe2FdA$default(v17, 0, v45, 0, v30, 5, null);
            if(v10 != null) {
                v0_3 = ((Measurable)v10).measure-BRTryo0(v0_2);
            }
            else {
                Object v0_4 = null;
            }

            v14_1.element = v0_3;
        }

        v0_2 = Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(v17, 0, -v12_1, 1, null), 0, v45, 0, 0, 9, null);
        if(v11 != null) {
            v17_1 = v16;
            v16_1 = ((Measurable)v11).measure-BRTryo0(v0_2);
        }
        else {
            v17_1 = v16;
            v16_1 = null;
        }

        v18 = LayoutUtilKt.getHeightOrZero(v16_1);
        v12 = v34;
        int v50 = v45;
        v2 = this.calculateHeight-mKXJcVc(arg52, v41.getHeight(), LayoutUtilKt.getHeightOrZero(v14_1.element), LayoutUtilKt.getHeightOrZero(v26), LayoutUtilKt.getHeightOrZero(v27), LayoutUtilKt.getHeightOrZero(v28), LayoutUtilKt.getHeightOrZero(v33), LayoutUtilKt.getHeightOrZero(v32), LayoutUtilKt.getHeightOrZero(v16_1), arg54, v12, v13);
        v0_1 = v2 - v18;
        int v10_1 = v12 ? LayoutUtilKt.getHeightOrZero(v14_1.element) : 0;
        v4_1 = v0_1 - v10_1;
        v0_1 = ((Collection)v25).size();
        v10_1 = 0;
        while(v10_1 < v0_1) {
            Object v1_1 = v15.get(v10_1);
            if(Intrinsics.areEqual(LayoutIdKt.getLayoutId(((Measurable)v1_1)), "Container")) {
                v0_1 = 0x7FFFFFFF;
                v7 = v50;
                v10_1 = v7 != v0_1 ? v7 : 0;
                v0_1 = v4_1 != v0_1 ? v4_1 : 0;
                return MeasureScope.layout$default(arg52, v7, v2, null, new TextFieldMeasurePolicy$$ExternalSyntheticLambda2(v14_1, v12, this, v4_1, v17_1, arg52, v7, v2, v41, v32, v26, v27, v28, v33, ((Measurable)v1_1).measure-BRTryo0(ConstraintsKt.Constraints(v10_1, v7, v0_1, v4_1)), v16_1, v13), 4, null);
            }

            ++v10_1;
            v2 = v2;
            v12 = v12;
            v14_1 = v14_1;
            v4_1 = v4_1;
        }

        ListUtilsKt.throwNoSuchElementException(v40);
        throw new KotlinNothingValueException();
    }

    static final Unit measure_3p2s80s$lambda$9(ObjectRef arg19, boolean arg20, TextFieldMeasurePolicy arg21, int arg22, int arg23, MeasureScope arg24, int arg25, int arg26, Placeable arg27, Placeable arg28, Placeable arg29, Placeable arg30, Placeable arg31, Placeable arg32, Placeable arg33, Placeable arg34, float arg35, PlacementScope arg36) {
        int v3;
        int v13;
        MeasureScope v4;
        ObjectRef v0 = arg19;
        TextFieldMeasurePolicy v1 = arg21;
        if(v0.element != null) {
            int v2 = 0;
            if(arg20) {
                v4 = arg24;
                v13 = 0;
            }
            else {
                if(v1.singleLine) {
                    v3 = Alignment.Companion.getCenterVertically().align(v0.element.getHeight(), arg22);
                    v4 = arg24;
                }
                else {
                    v4 = arg24;
                    v3 = arg23 + v4.roundToPx-0680j_4(v1.minimizedLabelHalfHeight);
                }

                v13 = v3;
            }

            int v14 = arg20 ? 0 : arg23;
            Object v5 = v0.element;
            if(arg20) {
            }
            else {
                v2 = v0.element.getHeight();
            }

            v1.placeWithLabel(arg36, arg25, arg26, arg27, ((Placeable)v5), arg28, arg29, arg30, arg31, arg32, arg33, arg34, v13, v14, arg20, arg35, arg23 + v2, v4.getLayoutDirection());
        }
        else {
            arg21.placeWithoutLabel(arg36, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg24.getDensity());
        }

        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg2, List arg3, int arg4) {
        return this.intrinsicHeight(arg2, arg3, arg4, new TextFieldMeasurePolicy$$ExternalSyntheticLambda3());
    }

    static final int minIntrinsicHeight$lambda$11(IntrinsicMeasurable arg0, int arg1) {
        return arg0.minIntrinsicHeight(arg1);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, List arg2, int arg3) {
        return this.intrinsicWidth(arg2, arg3, new TextFieldMeasurePolicy$$ExternalSyntheticLambda0());
    }

    static final int minIntrinsicWidth$lambda$13(IntrinsicMeasurable arg0, int arg1) {
        return arg0.minIntrinsicWidth(arg1);
    }

    private final void placeWithLabel(PlacementScope arg21, int arg22, int arg23, Placeable arg24, Placeable arg25, Placeable arg26, Placeable arg27, Placeable arg28, Placeable arg29, Placeable arg30, Placeable arg31, Placeable arg32, int arg33, int arg34, boolean arg35, float arg36, int arg37, LayoutDirection arg38) {
        TextFieldMeasurePolicy v0 = this;
        int v1 = arg22;
        float v2 = arg36;
        LayoutDirection v3 = arg38;
        int v4 = 0;
        int v9 = arg35 ? arg25.getHeight() : 0;
        PlacementScope.place$default(arg21, arg31, 0, v9, 0f, 4, null);
        int v5 = arg23 - LayoutUtilKt.getHeightOrZero(arg32);
        if(arg35) {
            v4 = arg25.getHeight();
        }

        v5 -= v4;
        if(arg27 != null) {
            PlacementScope.placeRelative$default(arg21, arg27, 0, v9 + Alignment.Companion.getCenterVertically().align(arg27.getHeight(), v5), 0f, 4, null);
        }

        int v16 = MathHelpersKt.lerp(arg33, arg34, v2);
        if(arg35) {
            PlacementScope.place$default(arg21, arg25, TextFieldImplKt.getMinimizedAlignment(v0.labelPosition).align(arg25.getWidth(), v1, v3), v16, 0f, 4, null);
        }
        else {
            v4 = v3 == LayoutDirection.Ltr ? LayoutUtilKt.getWidthOrZero(arg27) : LayoutUtilKt.getWidthOrZero(arg28);
            PlacementScope.place$default(arg21, arg25, MathHelpersKt.lerp(TextFieldImplKt.getExpandedAlignment(v0.labelPosition).align(arg25.getWidth(), v1 - LayoutUtilKt.getWidthOrZero(arg27) - LayoutUtilKt.getWidthOrZero(arg28), v3) + v4, TextFieldImplKt.getMinimizedAlignment(v0.labelPosition).align(arg25.getWidth(), v1 - LayoutUtilKt.getWidthOrZero(arg27) - LayoutUtilKt.getWidthOrZero(arg28), v3) + v4, v2), v16, 0f, 4, null);
        }

        if(arg29 != null) {
            PlacementScope.placeRelative$default(arg21, arg29, LayoutUtilKt.getWidthOrZero(arg27), v9 + arg37, 0f, 4, null);
        }

        int v15 = LayoutUtilKt.getWidthOrZero(arg27) + LayoutUtilKt.getWidthOrZero(arg29);
        v16 = v9 + arg37;
        PlacementScope.placeRelative$default(arg21, arg24, v15, v16, 0f, 4, null);
        if(arg26 != null) {
            PlacementScope.placeRelative$default(arg21, arg26, v15, v16, 0f, 4, null);
        }

        if(arg30 != null) {
            PlacementScope.placeRelative$default(arg21, arg30, v1 - LayoutUtilKt.getWidthOrZero(arg28) - arg30.getWidth(), v16, 0f, 4, null);
        }

        if(arg28 != null) {
            PlacementScope.placeRelative$default(arg21, arg28, v1 - arg28.getWidth(), v9 + Alignment.Companion.getCenterVertically().align(arg28.getHeight(), v5), 0f, 4, null);
        }

        if(arg32 != null) {
            PlacementScope.placeRelative$default(arg21, arg32, 0, v9 + v5, 0f, 4, null);
        }
    }

    private final void placeWithoutLabel(PlacementScope arg26, int arg27, int arg28, Placeable arg29, Placeable arg30, Placeable arg31, Placeable arg32, Placeable arg33, Placeable arg34, Placeable arg35, Placeable arg36, float arg37) {
        TextFieldMeasurePolicy v0 = this;
        Placeable v2 = arg30;
        Placeable v4 = arg33;
        Placeable v10 = arg34;
        PlacementScope.place-70tqf50$default(arg26, arg35, IntOffset.Companion.getZero-nOcc-ac(), 0f, 2, null);
        int v11 = arg28 - LayoutUtilKt.getHeightOrZero(arg36);
        int v12 = MathKt.roundToInt(v0.paddingValues.calculateTopPadding-D9Ej5fM() * arg37);
        if(arg31 != null) {
            PlacementScope.placeRelative$default(arg26, arg31, 0, Alignment.Companion.getCenterVertically().align(arg31.getHeight(), v11), 0f, 4, null);
        }

        if(v4 != null) {
            PlacementScope.placeRelative$default(arg26, v4, LayoutUtilKt.getWidthOrZero(arg31), TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(v0, v11, v12, v4), 0f, 4, null);
        }

        int v5 = LayoutUtilKt.getWidthOrZero(arg33) + LayoutUtilKt.getWidthOrZero(arg31);
        PlacementScope.placeRelative$default(arg26, arg29, v5, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(v0, v11, v12, arg29), 0f, 4, null);
        int v3 = v5;
        if(v2 != null) {
            PlacementScope.placeRelative$default(arg26, v2, v3, TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(v0, v11, v12, v2), 0f, 4, null);
        }

        if(v10 != null) {
            PlacementScope.placeRelative$default(arg26, v10, arg27 - LayoutUtilKt.getWidthOrZero(arg32) - v10.getWidth(), TextFieldMeasurePolicy.placeWithoutLabel$calculateVerticalPosition(v0, v11, v12, v10), 0f, 4, null);
        }

        if(arg32 != null) {
            PlacementScope.placeRelative$default(arg26, arg32, arg27 - arg32.getWidth(), Alignment.Companion.getCenterVertically().align(arg32.getHeight(), v11), 0f, 4, null);
        }

        if(arg36 != null) {
            PlacementScope.placeRelative$default(arg26, arg36, 0, v11, 0f, 4, null);
        }
    }

    private static final int placeWithoutLabel$calculateVerticalPosition(TextFieldMeasurePolicy arg0, int arg1, int arg2, Placeable arg3) {
        if(arg0.singleLine) {
            return Alignment.Companion.getCenterVertically().align(arg3.getHeight(), arg1);
        }

        return arg2;
    }
}

