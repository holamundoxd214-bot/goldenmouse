package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AË\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\t2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\u0015\b\u0002\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u001A¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001CH\u0007¢\u0006\u0004\b\u001D\u0010\u001E\u001AÁ\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\t2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\u0015\b\u0002\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u001A¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001CH\u0007¢\u0006\u0004\b\u001F\u0010 \u001Aú\u0001\u0010!\u001A\u00020\u0001*\u00020\"2\u0012\u0010#\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010\'\u001A\u00020(2\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032!\u0010*\u001A\u001D\u0012\u0013\u0012\u00110%¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\u001A2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\t2\u0015\b\u0002\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001C\u0010\u0019\u001A\u0018\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u001A¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001CH\u0001¢\u0006\u0004\b.\u0010/\u001A\u0014\u00100\u001A\u00020%*\u0002012\u0006\u00102\u001A\u00020%H\u0002\u001A\u0014\u00103\u001A\u00020%*\u0002012\u0006\u00102\u001A\u00020%H\u0002\u001A-\u00104\u001A\u00020\u00072\b\b\u0002\u00105\u001A\u00020\u000B2\u0014\b\u0002\u00106\u001A\u000E\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000B0\u001AH\u0007¢\u0006\u0002\u00108\u001A5\u00109\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u000F2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010;\u001A\u00020\u000B2\u0006\u0010<\u001A\u00020\u000BH\u0003¢\u0006\u0004\b=\u0010>\"\u0010\u0010?\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001A\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001A\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006E²\u0006\n\u0010F\u001A\u00020%X\u008A\u0084\u0002"}, d2={"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", "visible", "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ModalBottomSheetKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[SheetValue.values().length];
            try {
                v0[SheetValue.Hidden.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[SheetValue.Expanded.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private static final long PredictiveBackChildTransformOrigin;
    private static final float PredictiveBackMaxScaleXDistance;
    private static final float PredictiveBackMaxScaleYDistance;

    static {
        ModalBottomSheetKt.PredictiveBackMaxScaleXDistance = Dp.constructor-impl(48f);
        ModalBottomSheetKt.PredictiveBackMaxScaleYDistance = Dp.constructor-impl(24f);
        ModalBottomSheetKt.PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0f);
    }

    public static final void ModalBottomSheet-YbuCTN8(Function0 arg48, Modifier arg49, SheetState arg50, float arg51, boolean arg52, Shape arg53, long arg54, long arg56, float arg58, long arg59, Function2 arg61, Function2 arg62, ModalBottomSheetProperties arg63, Function3 arg64, Composer arg65, int arg66, int arg67, int arg68) {
        Function2 v14_1;
        float v11_7;
        Shape v6_7;
        boolean v5_1;
        Modifier v2_6;
        ModalBottomSheetProperties v16_1;
        long v12_2;
        SheetState v3_1;
        ModalBottomSheetKt$ModalBottomSheet$5$1 v2_5;
        Composer v0_1;
        ModalBottomSheetKt$$ExternalSyntheticLambda2 v11_6;
        Animatable v6_6;
        ModalBottomSheetKt$$ExternalSyntheticLambda1 v11_5;
        Shape v38;
        Modifier v35;
        boolean v37;
        float v36;
        ModalBottomSheetProperties v31;
        Function2 v44;
        long v27;
        float v43;
        long v41;
        long v39;
        ModalBottomSheetKt$ModalBottomSheet$1 v45_1;
        ModalBottomSheetKt$ModalBottomSheet$1 v4_2;
        Function2 v15_1;
        long v26_1;
        long v18_1;
        long v9_1;
        int v20;
        int v26;
        int v25;
        float v4;
        int v15;
        long v6_1;
        int v8;
        long v7;
        Shape v14;
        int v21;
        boolean v11;
        int v19;
        float v10;
        int v16;
        SheetState v13_1;
        Modifier v12;
        int v6;
        Function0 v1 = arg48;
        int v0 = arg66;
        int v2 = arg67;
        int v3 = arg68;
        Composer v5 = arg65.startRestartGroup(0x7188EB30);
        ComposerKt.sourceInformation(v5, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)140@7306L7,141@7400L7,142@7491L7,144@7515L174,144@7504L185,149@7706L24,150@7770L327,161@8151L149,167@8335L42,172@8504L708,184@9277L883,169@8383L1777:ModalBottomSheet.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v6 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v6 = v5.changedInstance(v1) ? 4 : 2;
            v6 |= v0;
        }
        else {
            v6 = v0;
        }

        int v9 = v3 & 2;
        if(v9 != 0) {
            v6 |= 0x30;
            goto label_37;
        }
        else if((v0 & 0x30) == 0) {
            v12 = arg49;
            int v13 = v5.changed(v12) ? 0x20 : 16;
            v6 |= v13;
        }
        else {
        label_37:
            v12 = arg49;
        }

        if((v0 & 0x180) == 0) {
            if((v3 & 4) == 0) {
                v13_1 = arg50;
                if(v5.changed(v13_1)) {
                    v16 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v13_1 = arg50;
            label_48:
                v16 = 0x80;
            }

            v6 |= v16;
        }
        else {
            v13_1 = arg50;
        }

        v16 = v3 & 8;
        int v17 = 0x400;
        int v18 = 0x800;
        if(v16 != 0) {
            v6 |= 0xC00;
            goto label_68;
        }
        else if((v0 & 0xC00) == 0) {
            v10 = arg51;
            v19 = v5.changed(v10) ? v18 : v17;
            v6 |= v19;
        }
        else {
        label_68:
            v10 = arg51;
        }

        v19 = v3 & 16;
        if(v19 != 0) {
            v6 |= 0x6000;
            goto label_83;
        }
        else if((v0 & 0x6000) == 0) {
            v11 = arg52;
            v21 = v5.changed(v11) ? 0x4000 : 0x2000;
            v6 |= v21;
        }
        else {
        label_83:
            v11 = arg52;
        }

        if((v0 & 0x30000) == 0) {
            v14 = arg53;
            int v22 = (v3 & 0x20) != 0 || !v5.changed(v14) ? 0x10000 : 0x20000;
            v6 |= v22;
        }
        else {
            v14 = arg53;
        }

        if((v0 & 0x180000) == 0) {
            v7 = arg54;
            int v23 = (v3 & 0x40) != 0 || !v5.changed(v7) ? 0x80000 : 0x100000;
            v6 |= v23;
        }

        if((v0 & 0xC00000) == 0) {
            v8 = v6;
            v6_1 = arg56;
            v15 = (v3 & 0x80) != 0 || !v5.changed(v6_1) ? 0x400000 : 0x800000;
            v8 |= v15;
        }
        else {
            v8 = v6;
        }

        v15 = v3 & 0x100;
        int v24 = 0x6000000;
        if(v15 != 0) {
            v8 |= v24;
        }
        else {
            v4 = arg58;
            if((v0 & v24) == 0) {
                v25 = v5.changed(v4) ? 0x4000000 : 0x2000000;
                v8 |= v25;
            }
        }

        if((v0 & 0x30000000) == 0) {
            v6_1 = arg59;
            v0 = (v3 & 0x200) != 0 || !v5.changed(v6_1) ? 0x10000000 : 0x20000000;
            v8 |= v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v26 = v2 | 6;
            v25 = v0;
        }
        else if((v2 & 6) == 0) {
            v25 = v0;
            v26 = v5.changedInstance(arg61) ? 4 : 2;
            v26 |= v2;
        }
        else {
            v25 = v0;
            v26 = v2;
        }

        if((v2 & 0x30) == 0) {
            v20 = (v3 & 0x800) != 0 || !v5.changedInstance(arg62) ? 16 : 0x20;
            v26 |= v20;
        }

        v0 = v26;
        int v4_1 = v3 & 0x1000;
        if(v4_1 != 0) {
            v0 |= 0x180;
        }
        else {
            v20 = v0;
            if((v2 & 0x180) == 0) {
                v21 = v5.changed(arg63) ? 0x100 : 0x80;
                v20 |= v21;
            }

            v0 = v20;
        }

        v20 = v4_1;
        if((v3 & 0x2000) != 0) {
            v0 |= 0xC00;
        }
        else if((v2 & 0xC00) == 0) {
            if(v5.changedInstance(arg64)) {
                v17 = v18;
            }

            v0 |= v17;
        }

        boolean v2_1 = (v8 & 306783379) != 306783378 || (v0 & 0x493) != 1170 ? true : false;
        if(v5.shouldExecute(v2_1, v8 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "125@6423L31,128@6596L13,129@6659L14,130@6701L31,132@6809L10");
            Function1 v7_1 = null;
            v4_1 = 6;
            if((arg66 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v12_1 = Modifier.Companion;
                }

                if((v3 & 4) != 0) {
                    v8 &= -897;
                    v13_1 = ModalBottomSheetKt.rememberModalBottomSheetState(false, v7_1, v5, 0, 3);
                }

                float v2_2 = v16 != 0 ? BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM() : v10;
                if(v19 != 0) {
                    v11 = true;
                }

                if((v3 & 0x20) != 0) {
                    v8 &= 0xFFF8FFFF;
                    v14 = BottomSheetDefaults.INSTANCE.getExpandedShape(v5, v4_1);
                }

                if((v3 & 0x40) != 0) {
                    v9_1 = BottomSheetDefaults.INSTANCE.getContainerColor(v5, v4_1);
                    v8 &= 0xFFC7FFFF;
                }
                else {
                    v9_1 = arg54;
                }

                if((v3 & 0x80) != 0) {
                    v18_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v9_1, v5, v8 >> 18 & 14);
                    v8 &= 0xFE3FFFFF;
                }
                else {
                    v18_1 = arg56;
                }

                float v6_2 = v15 != 0 ? Dp.constructor-impl(0f) : arg58;
                if((v3 & 0x200) != 0) {
                    v26_1 = BottomSheetDefaults.INSTANCE.getScrimColor(v5, v4_1);
                    v8 &= 0x8FFFFFFF;
                }
                else {
                    v26_1 = arg59;
                }

                v15_1 = v25 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3() : arg61;
                if((v3 & 0x800) != 0) {
                    v4_2 = ModalBottomSheetKt$ModalBottomSheet$1.INSTANCE;
                    v0 &= 0xFFFFFF8F;
                }
                else {
                    Function2 v4_3 = arg62;
                }

                int v49 = v0;
                if(v20 != 0) {
                    v36 = v2_2;
                    v31 = new ModalBottomSheetProperties(false, false, 3, ((DefaultConstructorMarker)v7_1));
                    v45_1 = v4_2;
                    v43 = v6_2;
                    v39 = v9_1;
                    v37 = v11;
                    v35 = v12;
                    v38 = v14;
                    v44 = v15_1;
                    v41 = v18_1;
                    v27 = v26_1;
                    v0 = v49;
                    goto label_380;
                }

                v36 = v2_2;
                v31 = arg63;
                v45_1 = v4_2;
                v43 = v6_2;
                v39 = v9_1;
                v37 = v11;
                v35 = v12;
                v38 = v14;
                v44 = v15_1;
                v41 = v18_1;
                v27 = v26_1;
            }
            else {
                v5.skipToGroupEnd();
                if((v3 & 4) != 0) {
                    v8 &= -897;
                }

                if((v3 & 0x20) != 0) {
                    v8 &= 0xFFF8FFFF;
                }

                if((v3 & 0x40) != 0) {
                    v8 &= 0xFFC7FFFF;
                }

                if((v3 & 0x80) != 0) {
                    v8 &= 0xFE3FFFFF;
                }

                if((v3 & 0x200) != 0) {
                    v8 &= 0x8FFFFFFF;
                }

                if((v3 & 0x800) != 0) {
                    v0 &= 0xFFFFFF8F;
                }

                v39 = arg54;
                v41 = arg56;
                v43 = arg58;
                v27 = arg59;
                v44 = arg61;
                Function2 v45 = arg62;
                v31 = arg63;
                v36 = v10;
                v37 = v11;
                v35 = v12;
                v38 = v14;
            }

        label_380:
            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7188EB30, v8, v0, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:137)");
            }

            FiniteAnimationSpec v2_3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v5, 6);
            FiniteAnimationSpec v4_4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v5, 6);
            FiniteAnimationSpec v6_3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v5, 6);
            String v9_2 = "CC(remember):ModalBottomSheet.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 0x32FB7C1E, v9_2);
            v3 = v8 & 0x380 ^ 0x180;
            int v10_1 = 0x100;
            v10_1 = v3 > v10_1 && (v5.changed(v13_1)) || (v8 & 0x180) == v10_1 ? 1 : 0;
            v10_1 = v10_1 | v5.changedInstance(v4_4) | v5.changedInstance(v6_3) | v5.changedInstance(v2_3);
            Object v11_1 = v5.rememberedValue();
            if(v10_1 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                ModalBottomSheetKt$$ExternalSyntheticLambda17 v11_2 = new ModalBottomSheetKt$$ExternalSyntheticLambda17(v13_1, v4_4, v6_3, v2_3);
                v5.updateRememberedValue(v11_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            EffectsKt.SideEffect(((Function0)v11_1), v5, 0);
            ComposerKt.sourceInformationMarkerStart(v5, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v5, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v4_5 = v5.rememberedValue();
            if(v4_5 == Composer.Companion.getEmpty()) {
                CoroutineScope v4_6 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v5);
                v5.updateRememberedValue(v4_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x32FB9C97, v9_2);
            v10_1 = 0x100;
            v6 = v3 > v10_1 && (v5.changed(v13_1)) || (v8 & 0x180) == v10_1 ? 1 : 0;
            v6 |= v5.changedInstance(v4_5);
            v10_1 = v8 & 14;
            int v11_3 = v10_1 == 4 ? 1 : 0;
            v6 |= v11_3;
            v11_1 = v5.rememberedValue();
            if(v6 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                ModalBottomSheetKt$$ExternalSyntheticLambda18 v11_4 = new ModalBottomSheetKt$$ExternalSyntheticLambda18(v13_1, ((CoroutineScope)v4_5), v1);
                v5.updateRememberedValue(v11_4);
            }

            Object v29 = v11_1;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x32FBCB85, v9_2);
            boolean v6_4 = v5.changedInstance(v4_5);
            v11_3 = 0x100;
            v11_3 = v3 > v11_3 && (v5.changed(v13_1)) || (v8 & 0x180) == v11_3 ? 1 : 0;
            v6 = (((int)v6_4)) | v11_3;
            v11_3 = v10_1 == 4 ? 1 : 0;
            v6 |= v11_3;
            v11_1 = v5.rememberedValue();
            if(v6 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v11_5 = new ModalBottomSheetKt$$ExternalSyntheticLambda1(((CoroutineScope)v4_5), v13_1, v1);
                v5.updateRememberedValue(v11_5);
            }

            Object v34 = v11_5;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x32FBE21A, v9_2);
            Object v6_5 = v5.rememberedValue();
            if(v6_5 == Composer.Companion.getEmpty()) {
                v6_6 = AnimatableKt.Animatable$default(0f, 0f, 2, v7_1);
                v5.updateRememberedValue(v6_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x32FBF9D4, v9_2);
            v11_3 = 0x100;
            v11_3 = v3 > v11_3 && (v5.changed(v13_1)) || (v8 & 0x180) == v11_3 ? 1 : 0;
            v11_3 = v11_3 | v5.changedInstance(v4_5) | v5.changedInstance(v6_6);
            v10_1 = v10_1 == 4 ? 1 : 0;
            v10_1 |= v11_3;
            v11_1 = v5.rememberedValue();
            if(v10_1 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                v11_6 = new ModalBottomSheetKt$$ExternalSyntheticLambda2(v13_1, ((CoroutineScope)v4_5), v6_6, v1);
                v5.updateRememberedValue(v11_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            ModalBottomSheet_androidKt.ModalBottomSheetDialog-sW7UJKQ(v11_6, v41, v31, v6_6, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new ModalBottomSheetKt$ModalBottomSheet$4(v27, ((Function0)v29), v13_1, v31, v6_6, v4_5, ((Function1)v34), v35, v36, v37, v38, v39, v41, v43, v44, ((Function2)v45_1), arg64), v5, 54), v5, v0 & 0x380 | (v8 >> 18 & 0x70 | 0x6000) | Animatable.$stable << 9);
            v0_1 = v5;
            if(v13_1.getHasExpandedState()) {
                v0_1.startReplaceGroup(0x2C9C96F2);
                ComposerKt.sourceInformation(v0_1, "212@10235L21,212@10208L48");
                ComposerKt.sourceInformationMarkerStart(v0_1, 0x32FCCF85, v9_2);
                v11_3 = 0x100;
                v6 = v3 > v11_3 && (v0_1.changed(v13_1)) || (v8 & 0x180) == v11_3 ? 1 : 0;
                Object v2_4 = v0_1.rememberedValue();
                if(v6 != 0 || v2_4 == Composer.Companion.getEmpty()) {
                    v2_5 = new ModalBottomSheetKt$ModalBottomSheet$5$1(v13_1, ((Continuation)v7_1));
                    v0_1.updateRememberedValue(v2_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v0_1);
                EffectsKt.LaunchedEffect(v13_1, ((Function2)v2_5), v0_1, v8 >> 6 & 14);
                v0_1.endReplaceGroup();
            }
            else {
                v0_1.startReplaceGroup(0x2C9D8732);
                v0_1.endReplaceGroup();
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v13_1;
            v12_2 = v27;
            v16_1 = v31;
            v2_6 = v35;
            v4 = v36;
            v5_1 = v37;
            v6_7 = v38;
            v7 = v39;
            v9_1 = v41;
            v11_7 = v43;
            v14_1 = v44;
            v15_1 = ((Function2)v45_1);
        }
        else {
            v0_1 = v5;
            v0_1.skipToGroupEnd();
            v7 = arg54;
            v15_1 = arg62;
            v16_1 = arg63;
            v4 = v10;
            v5_1 = v11;
            v2_6 = v12;
            v3_1 = v13_1;
            v6_7 = v14;
            v9_1 = arg56;
            v11_7 = arg58;
            v12_2 = arg59;
            v14_1 = arg61;
        }

        ScopeUpdateScope v0_2 = v0_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new ModalBottomSheetKt$$ExternalSyntheticLambda3(v1, v2_6, v3_1, v4, v5_1, v6_7, v7, v9_1, v11_7, v12_2, v14_1, v15_1, v16_1, arg64, arg66, arg67, arg68));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for Binary compatibility. Use overload with sheetGesturesEnabled param.") public static final void ModalBottomSheet-dYc4hso(Function0 arg30, Modifier arg31, SheetState arg32, float arg33, Shape arg34, long arg35, long arg37, float arg39, long arg40, Function2 arg42, Function2 arg43, ModalBottomSheetProperties arg44, Function3 arg45, Composer arg46, int arg47, int arg48, int arg49) {
        Function2 v14_2;
        Function2 v13_2;
        float v10_1;
        long v6_3;
        float v4_1;
        SheetState v3_2;
        long v8_1;
        Composer v21;
        long v15;
        float v14_1;
        float v7_1;
        long v12_1;
        SheetState v6;
        Modifier v5_1;
        Shape v9_1;
        ModalBottomSheetProperties v19;
        Function2 v18_1;
        Function2 v17_1;
        ModalBottomSheetKt$ModalBottomSheet$7 v11;
        long v16_1;
        long v9_2;
        Shape v5_2;
        int v24;
        long v14;
        int v20;
        long v10;
        int v18;
        Shape v7;
        int v17;
        int v16;
        SheetState v13_1;
        Modifier v12;
        int v8;
        int v0 = arg47;
        int v1 = arg48;
        int v2 = arg49;
        Composer v4 = arg46.startRestartGroup(0x38DB610C);
        ComposerKt.sourceInformation(v4, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)237@11249L525:ModalBottomSheet.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changedInstance(arg30) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
            goto label_40;
        }
        else if((v0 & 0x30) == 0) {
            v12 = arg31;
            int v13 = v4.changed(v12) ? 0x20 : 16;
            v8 |= v13;
        }
        else {
        label_40:
            v12 = arg31;
        }

        if((v0 & 0x180) == 0) {
            if((v2 & 4) == 0) {
                v13_1 = arg32;
                if(v4.changed(v13_1)) {
                    v16 = 0x100;
                }
                else {
                    goto label_51;
                }
            }
            else {
                v13_1 = arg32;
            label_51:
                v16 = 0x80;
            }

            v8 |= v16;
        }
        else {
            v13_1 = arg32;
        }

        v16 = v2 & 8;
        if(v16 != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v17 = v4.changed(arg33) ? 0x800 : 0x400;
            v8 |= v17;
        }

        if((v0 & 0x6000) == 0) {
            if((v2 & 16) == 0) {
                v7 = arg34;
                if(v4.changed(v7)) {
                    v18 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v7 = arg34;
            label_80:
                v18 = 0x2000;
            }

            v8 |= v18;
        }
        else {
            v7 = arg34;
        }

        if((v0 & 0x30000) == 0) {
            v10 = arg35;
            v20 = (v2 & 0x20) != 0 || !v4.changed(v10) ? 0x10000 : 0x20000;
            v8 |= v20;
        }
        else {
            v10 = arg35;
        }

        if((v0 & 0x180000) == 0) {
            v14 = arg37;
            int v22 = (v2 & 0x40) != 0 || !v4.changed(v14) ? 0x80000 : 0x100000;
            v8 |= v22;
        }
        else {
            v14 = arg37;
        }

        int v3 = v2 & 0x80;
        int v23 = 0xC00000;
        if(v3 != 0) {
            v8 |= v23;
        }
        else {
            v23 &= v0;
            float v0_1 = arg39;
            if(v23 == 0) {
                v23 = v4.changed(v0_1) ? 0x800000 : 0x400000;
                v8 |= v23;
            }
        }

        if((arg47 & 0x6000000) == 0) {
            long v5 = arg40;
            v0 = (v2 & 0x100) != 0 || !v4.changed(v5) ? 0x2000000 : 0x4000000;
            v8 |= v0;
        }

        v0 = v2 & 0x200;
        v23 = 0x30000000;
        if(v0 != 0) {
            v8 |= v23;
            goto label_157;
        }
        else if((arg47 & v23) == 0) {
            v23 = v0;
            v24 = v4.changedInstance(arg42) ? 0x20000000 : 0x10000000;
            v8 |= v24;
        }
        else {
        label_157:
            v23 = v0;
        }

        if((v1 & 6) == 0) {
            v17 = (v2 & 0x400) != 0 || !v4.changedInstance(arg43) ? 2 : 4;
            v17 |= v1;
        }
        else {
            v17 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v17 |= 0x30;
            v24 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v24 = v0;
            v18 = v4.changed(arg44) ? 0x20 : 16;
            v17 |= v18;
        }
        else {
            v24 = v0;
        }

        v0 = v17;
        v17 = v3;
        if((v2 & 0x1000) != 0) {
            v0 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v20 = v4.changedInstance(arg45) ? 0x100 : 0x80;
            v0 |= v20;
        }

        boolean v1_1 = (v8 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v1_1, v8 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "225@10576L31,227@10707L13,228@10770L14,229@10812L31,231@10920L10");
            v3 = 3;
            if((arg47 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v12_2 = Modifier.Companion;
                }

                if((v2 & 4) != 0) {
                    v8 &= -897;
                    v13_1 = ModalBottomSheetKt.rememberModalBottomSheetState(false, null, v4, 0, v3);
                }

                float v1_2 = v16 != 0 ? BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM() : arg33;
                int v6_1 = 6;
                if((v2 & 16) != 0) {
                    v5_2 = BottomSheetDefaults.INSTANCE.getExpandedShape(v4, v6_1);
                    v8 &= 0xFFFF1FFF;
                }
                else {
                    v5_2 = v7;
                }

                if((v2 & 0x20) != 0) {
                    v9_2 = BottomSheetDefaults.INSTANCE.getContainerColor(v4, v6_1);
                    v8 &= 0xFFF8FFFF;
                }
                else {
                    v9_2 = v10;
                }

                if((v2 & 0x40) != 0) {
                    v14 = ColorSchemeKt.contentColorFor-ek8zF_U(v9_2, v4, v8 >> 15 & 14);
                    v8 &= 0xFFC7FFFF;
                }

                v7_1 = v17 != 0 ? Dp.constructor-impl(0f) : arg39;
                if((v2 & 0x100) != 0) {
                    v16_1 = BottomSheetDefaults.INSTANCE.getScrimColor(v4, v6_1);
                    v8 &= 0xF1FFFFFF;
                }
                else {
                    v16_1 = arg40;
                }

                Function2 v6_2 = v23 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$-655173438$material3() : arg42;
                if((v2 & 0x400) != 0) {
                    v11 = ModalBottomSheetKt$ModalBottomSheet$7.INSTANCE;
                    v0 &= -15;
                }
                else {
                    Function2 v11_1 = arg43;
                }

                v19 = v24 != 0 ? ModalBottomSheetDefaults.INSTANCE.getProperties() : arg44;
                ModalBottomSheetKt$ModalBottomSheet$7 v18_2 = v11;
                v10 = v9_2;
                v9_1 = v5_2;
                v5_1 = v12;
                float v27 = v7_1;
                v7_1 = v1_2;
                long v28 = v16_1;
                v17_1 = v6_2;
                v6 = v13_1;
                v12_1 = v14;
                v15 = v28;
                v14_1 = v27;
            }
            else {
                v4.skipToGroupEnd();
                if((v2 & 4) != 0) {
                    v8 &= -897;
                }

                if((v2 & 16) != 0) {
                    v8 &= 0xFFFF1FFF;
                }

                if((v2 & 0x20) != 0) {
                    v8 &= 0xFFF8FFFF;
                }

                if((v2 & 0x40) != 0) {
                    v8 &= 0xFFC7FFFF;
                }

                if((v2 & 0x100) != 0) {
                    v8 &= 0xF1FFFFFF;
                }

                if((v2 & 0x400) != 0) {
                    v0 &= -15;
                }

                v17_1 = arg42;
                v18_1 = arg43;
                v19 = arg44;
                v9_1 = v7;
                v5_1 = v12;
                v6 = v13_1;
                v12_1 = v14;
                v7_1 = arg33;
                v14_1 = arg39;
                v15 = arg40;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x38DB610C, v8, v0, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:237)");
            }

            v3 = v8 << 3;
            v0 <<= 3;
            v21 = v4;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(arg30, v5_1, v6, v7_1, true, v9_1, v10, v12_1, v14_1, v15, v17_1, v18_1, v19, arg45, v21, v8 & 14 | 0x6000 | v8 & 0x70 | v8 & 0x380 | v8 & 0x1C00 | v3 & 0x70000 | v3 & 0x380000 | v3 & 0x1C00000 | v3 & 0xE000000 | v3 & 0x70000000, v8 >> 27 & 14 | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            long v3_1 = v12_1;
            v12 = v5_1;
            v5_2 = v9_1;
            v8_1 = v3_1;
            v3_2 = v6;
            v4_1 = v7_1;
            v6_3 = v10;
            v10_1 = v14_1;
            v13_2 = v17_1;
            v14_2 = v18_1;
        }
        else {
            v21 = v4;
            v21.skipToGroupEnd();
            v4_1 = arg33;
            v19 = arg44;
            v5_2 = v7;
            v6_3 = v10;
            v3_2 = v13_1;
            v8_1 = v14;
            v10_1 = arg39;
            v15 = arg40;
            v13_2 = arg42;
            v14_2 = arg43;
        }

        ScopeUpdateScope v0_2 = v21.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new ModalBottomSheetKt$$ExternalSyntheticLambda11(arg30, v12, v3_2, v4_1, v5_2, v6_3, v8_1, v10_1, v15, v13_2, v14_2, v19, arg45, arg47, arg48, v2));
        }
    }

    public static final void ModalBottomSheetContent-7---e2Q(BoxScope arg46, Animatable arg47, CoroutineScope arg48, Function0 arg49, Function1 arg50, Modifier arg51, SheetState arg52, float arg53, boolean arg54, Shape arg55, long arg56, long arg58, float arg60, Function2 arg61, Function2 arg62, Function3 arg63, Composer arg64, int arg65, int arg66, int arg67) {
        long v13_3;
        Modifier v6_1;
        Composer v0_4;
        float v15_2;
        Shape v10_4;
        Function2 v16_1;
        SheetState v7_7;
        boolean v9_3;
        long v11_1;
        Composer v17_2;
        ModalBottomSheetKt$$ExternalSyntheticLambda8 v3_8;
        ModalBottomSheetKt$ModalBottomSheetContent$4$1 v3_6;
        ModalBottomSheetKt$$ExternalSyntheticLambda6 v10_3;
        Modifier v3_2;
        long v30;
        float v61;
        Shape v60;
        Shape v8_1;
        float v13_1;
        float v3_1;
        Modifier v0_2;
        Function2 v7_3;
        Function2 v17_1;
        long v28_1;
        long v9_1;
        ModalBottomSheetKt$ModalBottomSheetContent$1 v7_4;
        long v44;
        Shape v9_2;
        Companion v13_2;
        int v20;
        long v7_1;
        int v64;
        int v28;
        boolean v14;
        float v8;
        int v24;
        SheetState v12;
        int v21;
        Modifier v13;
        int v11;
        int v17;
        Function0 v15_1;
        int v7;
        BoxScope v1 = arg46;
        Animatable v2 = arg47;
        Function1 v5 = arg50;
        int v0 = arg65;
        int v3 = arg66;
        int v4 = arg67;
        Composer v6 = arg64.startRestartGroup(0xFDC55090);
        ComposerKt.sourceInformation(v6, "C(ModalBottomSheetContent)N(predictiveBackProgress,scope,animateToDismiss,settleToDismiss,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,dragHandle,contentWindowInsets,content)273@12729L48,294@13641L1602,331@15615L23,333@15685L112,338@15930L612,358@17107L4293,275@12783L8617:ModalBottomSheet.kt#uh7d8r");
        if((0x80000000 & v4) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v6.changed(v1) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v4 & 1) != 0) {
            v7 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            boolean v10 = (v0 & 0x40) == 0 ? v6.changed(v2) : v6.changedInstance(v2);
            int v10_1 = v10 ? 0x20 : 16;
            v7 |= v10_1;
        }

        if((v4 & 2) != 0) {
            v7 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            int v15 = v6.changedInstance(arg48) ? 0x100 : 0x80;
            v7 |= v15;
        }

        int v16 = 0x400;
        if((v4 & 4) != 0) {
            v7 |= 0xC00;
            goto label_72;
        }
        else if((v0 & 0xC00) == 0) {
            v15_1 = arg49;
            v17 = v6.changedInstance(v15_1) ? 0x800 : v16;
            v7 |= v17;
        }
        else {
        label_72:
            v15_1 = arg49;
        }

        int v18 = 0x2000;
        if((v4 & 8) != 0) {
            v7 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v11 = v6.changedInstance(v5) ? 0x4000 : v18;
            v7 |= v11;
        }

        v11 = v4 & 16;
        int v19 = 0x30000;
        if(v11 != 0) {
            v7 |= v19;
            v13 = arg51;
        }
        else {
            v13 = arg51;
            if((v0 & v19) == 0) {
                v21 = v6.changed(v13) ? 0x20000 : 0x10000;
                v7 |= v21;
            }
        }

        v21 = 0x180000;
        if((v0 & v21) == 0) {
            v12 = arg52;
            v24 = (v4 & 0x20) != 0 || !v6.changed(v12) ? 0x80000 : 0x100000;
            v7 |= v24;
        }
        else {
            v12 = arg52;
        }

        v24 = v4 & 0x40;
        int v25 = 0xC00000;
        if(v24 != 0) {
            v7 |= v25;
        }
        else {
            v8 = arg53;
            if((v0 & v25) == 0) {
                int v26 = v6.changed(v8) ? 0x800000 : 0x400000;
                v7 |= v26;
            }
        }

        int v9 = v4 & 0x80;
        int v27 = 0x6000000;
        if(v9 != 0) {
            v7 |= v27;
            v14 = arg54;
        }
        else {
            v14 = arg54;
            if((v0 & v27) == 0) {
                v28 = v6.changed(v14) ? 0x4000000 : 0x2000000;
                v7 |= v28;
            }
        }

        if((v0 & 0x30000000) == 0) {
            v28 = (v4 & 0x100) != 0 || !v6.changed(arg55) ? 0x10000000 : 0x20000000;
            v7 |= v28;
        }

        if((v3 & 6) == 0) {
            if((v4 & 0x200) == 0) {
                v0 = v7;
                if(v6.changed(arg56)) {
                    v28 = 4;
                }
                else {
                    goto label_172;
                }
            }
            else {
                v0 = v7;
            label_172:
                v28 = 2;
            }

            v28 |= v3;
        }
        else {
            v0 = v7;
            v28 = v3;
        }

        if((v3 & 0x30) == 0) {
            v64 = v0;
            v7_1 = arg58;
            v17 = (v4 & 0x400) != 0 || !v6.changed(v7_1) ? 16 : 0x20;
            v28 |= v17;
        }
        else {
            v64 = v0;
        }

        v0 = v28;
        v7 = v4 & 0x800;
        if(v7 != 0) {
            v0 |= 0x180;
            goto label_208;
        }
        else if((v3 & 0x180) == 0) {
            v8 = arg60;
            v20 = v6.changed(v8) ? 0x100 : 0x80;
            v0 |= v20;
        }
        else {
        label_208:
            v8 = arg60;
        }

        v17 = v7;
        v7 = v4 & 0x1000;
        if(v7 != 0) {
            v16 = v0 | 0xC00;
        }
        else {
            v20 = v0;
            if((v3 & 0xC00) == 0) {
                if(v6.changedInstance(arg61)) {
                    v16 = 0x800;
                }

                v16 |= v20;
            }
            else {
                v16 = v20;
            }
        }

        if((v3 & 0x6000) == 0) {
            if((v4 & 0x2000) == 0 && (v6.changedInstance(arg62))) {
                v18 = 0x4000;
            }

            v16 |= v18;
        }

        if((v4 & 0x4000) != 0) {
            v16 |= v19;
        }
        else if((v3 & v19) == 0) {
            v18 = v6.changedInstance(arg63) ? 0x20000 : 0x10000;
            v16 |= v18;
        }

        v18 = v7;
        boolean v0_1 = (v64 & 306783379) != 306783378 || (v16 & 74899) != 74898 ? true : false;
        if(v6.shouldExecute(v0_1, v64 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "262@12100L31,265@12273L13,266@12336L14,267@12378L31");
            v3 = 6;
            Function1 v7_2 = null;
            if((arg65 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v11 != 0) {
                    v13_2 = Modifier.Companion;
                }

                if((v4 & 0x20) != 0) {
                    v11 = v64 & 0xFFC7FFFF;
                    v12 = ModalBottomSheetKt.rememberModalBottomSheetState(false, v7_2, v6, 0, 3);
                }
                else {
                    v11 = v64;
                }

                float v0_3 = v24 != 0 ? BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM() : arg53;
                if(v9 != 0) {
                    v14 = true;
                }

                if((v4 & 0x100) != 0) {
                    v9_2 = BottomSheetDefaults.INSTANCE.getExpandedShape(v6, v3);
                    v11 &= 0x8FFFFFFF;
                }
                else {
                    v9_2 = arg55;
                }

                if((v4 & 0x200) != 0) {
                    v16 &= -15;
                    v7_1 = BottomSheetDefaults.INSTANCE.getContainerColor(v6, v3);
                }
                else {
                    v7_1 = arg56;
                }

                if((v4 & 0x400) != 0) {
                    v28_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v7_1, v6, v16 & 14);
                    v16 &= 0xFFFFFF8F;
                }
                else {
                    v28_1 = arg58;
                }

                v3_1 = v17 != 0 ? BottomSheetDefaults.INSTANCE.getElevation-D9Ej5fM() : arg60;
                v17_1 = v18 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1716959002$material3() : arg61;
                float v51 = v0_3;
                if((v4 & 0x2000) != 0) {
                    v16 &= 0xFFFF1FFF;
                    v44 = v7_1;
                    v8_1 = v9_2;
                    v9_1 = v44;
                    v7_4 = ModalBottomSheetKt$ModalBottomSheetContent$1.INSTANCE;
                }
                else {
                    v44 = v7_1;
                    v8_1 = v9_2;
                    v9_1 = v44;
                    v7_3 = arg62;
                }

                v0_2 = ((Modifier)v13_2);
                v4 = v16;
                v13_1 = v3_1;
                v3_1 = v51;
            }
            else {
                v6.skipToGroupEnd();
                v0 = (v4 & 0x20) != 0 ? v64 & 0xFFC7FFFF : v64;
                if((v4 & 0x100) != 0) {
                    v0 &= 0x8FFFFFFF;
                }

                if((v4 & 0x200) != 0) {
                    v16 &= -15;
                }

                if((v4 & 0x400) != 0) {
                    v16 &= 0xFFFFFF8F;
                }

                if((v4 & 0x2000) != 0) {
                    v16 &= 0xFFFF1FFF;
                }

                v9_1 = arg56;
                v28_1 = arg58;
                v17_1 = arg61;
                v7_3 = arg62;
                v11 = v0;
                v0_2 = v13;
                v4 = v16;
                v3_1 = arg53;
                v13_1 = v8;
                v8_1 = arg55;
            }

            v6.endDefaults();
            Function2 v52 = ((Function2)v7_4);
            if(ComposerKt.isTraceInProgress()) {
                v60 = v8_1;
                ComposerKt.traceEventStart(0xFDC55090, v11, v4, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:272)");
            }
            else {
                v60 = v8_1;
            }

            String v7_5 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_bottom_sheet_pane_title), v6, 0);
            Modifier v24_1 = v0_2;
            v16 = v4;
            v0_2 = SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default(v1.align(v0_2, Alignment.Companion.getTopCenter()), 0f, v3_1, 1, null), 0f, 1, null);
            String v1_1 = "CC(remember):ModalBottomSheet.kt#9igjgp";
            if(v14) {
                v6.startReplaceGroup(0xA1B40E49);
                ComposerKt.sourceInformation(v6, "284@13098L373");
                Companion v4_1 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v6, -1582034107, v1_1);
                v61 = v3_1;
                v3 = 0x100000;
                v3 = (0x380000 & v11 ^ v21) > v3 && (v6.changed(v12)) || (v11 & v21) == v3 ? 1 : 0;
                Object v8_2 = v6.rememberedValue();
                if(v3 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                    NestedScrollConnection v8_3 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(v12, Orientation.Vertical, v5);
                    v6.updateRememberedValue(v8_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v6);
                v30 = v9_1;
                v3_2 = NestedScrollModifierKt.nestedScroll$default(((Modifier)v4_1), ((NestedScrollConnection)v8_2), null, 2, null);
                v6.endReplaceGroup();
            }
            else {
                v61 = v3_1;
                v30 = v9_1;
                v6.startReplaceGroup(-1582020872);
                v6.endReplaceGroup();
                Companion v3_3 = Modifier.Companion;
            }

            v0_2 = v0_2.then(v3_2);
            AnchoredDraggableState v3_4 = v12.getAnchoredDraggableState$material3();
            Orientation v4_2 = Orientation.Vertical;
            ComposerKt.sourceInformationMarkerStart(v6, -1582015502, v1_1);
            int v8_4 = 0x380000 & v11 ^ v21;
            v9 = 0x100000;
            v9 = v8_4 > v9 && (v6.changed(v12)) || (v11 & v21) == v9 ? 1 : 0;
            Object v10_2 = v6.rememberedValue();
            if(v9 != 0 || v10_2 == Composer.Companion.getEmpty()) {
                v10_3 = new ModalBottomSheetKt$$ExternalSyntheticLambda6(v12);
                v6.updateRememberedValue(v10_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            Modifier v32 = AnchoredDraggableKt.draggableAnchors(v0_2, v3_4, v4_2, ((Function2)v10_3));
            DraggableState v33 = v12.getAnchoredDraggableState$material3().getDraggableState$material3();
            Orientation v34 = Orientation.Vertical;
            boolean v35 = !v14 || !v12.isVisible() ? false : true;
            boolean v37 = v12.getAnchoredDraggableState$material3().isAnimationRunning();
            ComposerKt.sourceInformationMarkerStart(v6, 0xA1B54C87, v1_1);
            v0 = (0xE000 & v11) == 0x4000 ? 1 : 0;
            Object v3_5 = v6.rememberedValue();
            if(v0 != 0 || v3_5 == Composer.Companion.getEmpty()) {
                v3_6 = new ModalBottomSheetKt$ModalBottomSheetContent$4$1(v5, null);
                v6.updateRememberedValue(v3_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v0_2 = DraggableKt.draggable$default(v32, v33, v34, v35, null, v37, null, v3_6, false, 0xA8, null);
            ComposerKt.sourceInformationMarkerStart(v6, 0xA1B555A0, v1_1);
            boolean v3_7 = v6.changed(v7_5);
            Object v4_3 = v6.rememberedValue();
            if((v3_7) || v4_3 == Composer.Companion.getEmpty()) {
                ModalBottomSheetKt$$ExternalSyntheticLambda7 v4_4 = new ModalBottomSheetKt$$ExternalSyntheticLambda7(v7_5);
                v6.updateRememberedValue(v4_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v0_2 = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(v0_2, false, ((Function1)v4_3), 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast(((int)v12.getOffset$material3()), 0), 0, 0, 13, null));
            ComposerKt.sourceInformationMarkerStart(v6, 0xA1B57634, v1_1);
            v9 = 0x100000;
            int v1_2 = v8_4 > v9 && (v6.changed(v12)) || (v11 & v21) == v9 ? 1 : 0;
            if((v11 & 0x70) != 0x20) {
                if((v11 & 0x40) != 0 && (v6.changedInstance(v2))) {
                    goto label_575;
                }

                v7 = 0;
            }
            else {
            label_575:
                v7 = 1;
            }

            v3_5 = v6.rememberedValue();
            if((v1_2 | v7) != 0 || v3_5 == Composer.Companion.getEmpty()) {
                v3_8 = new ModalBottomSheetKt$$ExternalSyntheticLambda8(v12, v2);
                v6.updateRememberedValue(v3_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            Modifier v7_6 = BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(v0_2, ((Function1)v3_8)), v12);
            Function2 v4_5 = v52;
            SheetState v1_3 = v12;
            Function2 v3_9 = v17_1;
            v0_1 = v14;
            ComposableLambda v2_1 = ComposableLambdaKt.rememberComposableLambda(0x2B6FBD6B, true, new ModalBottomSheetKt$ModalBottomSheetContent$7(v52, v2, v12, v17_1, arg63, v15_1, arg48, v14), v6, 54);
            v9 = v16 << 6;
            v18 = v11 >> 24 & 0x70 | 0xC00000 | v9 & 0x380 | v9 & 0x1C00 | v9 & 0xE000;
            v8_1 = v60;
            v17_2 = v6;
            v11_1 = v28_1;
            SurfaceKt.Surface-T9BRK9s(v7_6, v8_1, v30, v11_1, v13_1, 0f, null, v2_1, v17_2, v18, 0x60);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_3 = v0_1;
            v7_7 = v1_3;
            v16_1 = v3_9;
            v10_4 = v8_1;
            v15_2 = v13_1;
            v0_4 = v17_2;
            v6_1 = v24_1;
            v8 = v61;
            v17_1 = v4_5;
            v13_3 = v11_1;
            v11_1 = v30;
        }
        else {
            v17_2 = v6;
            v17_2.skipToGroupEnd();
            v8 = arg53;
            v10_4 = arg55;
            v15_2 = arg60;
            v16_1 = arg61;
            v7_7 = v12;
            v6_1 = v13;
            v9_3 = v14;
            v0_4 = v17_2;
            v11_1 = arg56;
            v13_3 = arg58;
            v17_1 = arg62;
        }

        ScopeUpdateScope v0_5 = v0_4.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new ModalBottomSheetKt$$ExternalSyntheticLambda9(arg46, arg47, arg48, arg49, v5, v6_1, v7_7, v8, v9_3, v10_4, v11_1, v13_3, v15_2, v16_1, v17_1, arg63, arg65, arg66, arg67));
        }
    }

    static final Pair ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(SheetState arg2, IntSize arg3, Constraints arg4) {
        SheetValue v2_1;
        DraggableAnchors v3 = AnchoredDraggableKt.DraggableAnchors(new ModalBottomSheetKt$$ExternalSyntheticLambda10(((float)Constraints.getMaxHeight-impl(arg4.unbox-impl())), arg3, arg2));
        int v2 = WhenMappings.$EnumSwitchMapping$0[arg2.getAnchoredDraggableState$material3().getTargetValue().ordinal()];
        if(v2 == 1) {
            v2_1 = SheetValue.Hidden;
        }
        else if(v2 != 2) {
            if(v2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            else if(v3.hasAnchorFor(SheetValue.Expanded)) {
                v2_1 = SheetValue.Expanded;
            }
            else {
                v2_1 = SheetValue.Hidden;
            }
        }
        else if(v3.hasAnchorFor(SheetValue.PartiallyExpanded)) {
            v2_1 = SheetValue.PartiallyExpanded;
        }
        else if(v3.hasAnchorFor(SheetValue.Expanded)) {
            v2_1 = SheetValue.Expanded;
        }
        else {
            v2_1 = SheetValue.Hidden;
        }

        return TuplesKt.to(v3, v2_1);
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(float arg5, IntSize arg6, SheetState arg7, DraggableAnchorsConfig arg8) {
        arg8.at(SheetValue.Hidden, arg5);
        long v2 = 0xFFFFFFFFL;
        float v1 = 2f;
        if((((float)(((int)(arg6.unbox-impl() & v2))))) > arg5 / v1 && !arg7.getSkipPartiallyExpanded$material3()) {
            arg8.at(SheetValue.PartiallyExpanded, arg5 / v1);
        }

        if((((int)(arg6.unbox-impl() & v2))) != 0) {
            arg8.at(SheetValue.Expanded, Math.max(0f, arg5 - (((float)(((int)(arg6.unbox-impl() & v2)))))));
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setPaneTitle(arg1, arg0);
        SemanticsPropertiesKt.setTraversalIndex(arg1, 0f);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState arg4, Animatable arg5, GraphicsLayerScope arg6) {
        float v4 = arg4.getAnchoredDraggableState$material3().getOffset();
        float v0 = Float.intBitsToFloat(((int)(arg6.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        if(!Float.isNaN(v4) && !Float.isNaN(v0)) {
            if(v0 == 0f) {
            }
            else {
                float v5 = arg5.getValue().floatValue();
                arg6.setScaleX(ModalBottomSheetKt.calculatePredictiveBackScaleX(arg6, v5));
                arg6.setScaleY(ModalBottomSheetKt.calculatePredictiveBackScaleY(arg6, v5));
                arg6.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (v4 + v0) / v0));
            }
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope arg23, Animatable arg24, CoroutineScope arg25, Function0 arg26, Function1 arg27, Modifier arg28, SheetState arg29, float arg30, boolean arg31, Shape arg32, long arg33, long arg35, float arg37, Function2 arg38, Function2 arg39, Function3 arg40, int arg41, int arg42, int arg43, Composer arg44, int arg45) {
        ModalBottomSheetKt.ModalBottomSheetContent-7---e2Q(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg35, arg37, arg38, arg39, arg40, arg44, RecomposeScopeImplKt.updateChangedFlags(arg41 | 1), RecomposeScopeImplKt.updateChangedFlags(arg42), arg43);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState arg0, FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        arg0.setShowMotionSpec$material3(arg1);
        arg0.setHideMotionSpec$material3(arg2);
        arg0.setAnchoredDraggableMotionSpec$material3(((AnimationSpec)arg3));
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState arg16, CoroutineScope arg17, Animatable arg18, Function0 arg19) {
        SheetState v0 = arg16;
        Continuation v3 = null;
        if(v0.getCurrentValue() != SheetValue.Expanded || !v0.getHasPartiallyExpandedState()) {
            BuildersKt.launch$default(arg17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(v0, v3), 3, null).invokeOnCompletion(new ModalBottomSheetKt$$ExternalSyntheticLambda4(arg19));
        }
        else {
            BuildersKt.launch$default(arg17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(arg18, v3), 3, null);
            BuildersKt.launch$default(arg17, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(v0, v3), 3, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0 arg0, Throwable arg1) {
        arg0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$13(Function0 arg22, Modifier arg23, SheetState arg24, float arg25, boolean arg26, Shape arg27, long arg28, long arg30, float arg32, long arg33, Function2 arg35, Function2 arg36, ModalBottomSheetProperties arg37, Function3 arg38, int arg39, int arg40, int arg41, Composer arg42, int arg43) {
        ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg30, arg32, arg33, arg35, arg36, arg37, arg38, arg42, RecomposeScopeImplKt.updateChangedFlags(arg39 | 1), RecomposeScopeImplKt.updateChangedFlags(arg40), arg41);
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(SheetState arg8, CoroutineScope arg9, Function0 arg10) {
        if(arg8.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            BuildersKt.launch$default(arg9, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(arg8, null), 3, null).invokeOnCompletion(new ModalBottomSheetKt$$ExternalSyntheticLambda0(arg8, arg10));
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState arg0, Function0 arg1, Throwable arg2) {
        if(!arg0.isVisible()) {
            arg1.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope arg8, SheetState arg9, Function0 arg10, float arg11) {
        BuildersKt.launch$default(arg8, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(arg9, arg11, null), 3, null).invokeOnCompletion(new ModalBottomSheetKt$$ExternalSyntheticLambda5(arg9, arg10));
        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState arg0, Function0 arg1, Throwable arg2) {
        if(!arg0.isVisible()) {
            arg1.invoke();
        }

        return Unit.INSTANCE;
    }

    static final Unit ModalBottomSheet_dYc4hso$lambda$14(Function0 arg21, Modifier arg22, SheetState arg23, float arg24, Shape arg25, long arg26, long arg28, float arg30, long arg31, Function2 arg33, Function2 arg34, ModalBottomSheetProperties arg35, Function3 arg36, int arg37, int arg38, int arg39, Composer arg40, int arg41) {
        ModalBottomSheetKt.ModalBottomSheet-dYc4hso(arg21, arg22, arg23, arg24, arg25, arg26, arg28, arg30, arg31, arg33, arg34, arg35, arg36, arg40, RecomposeScopeImplKt.updateChangedFlags(arg37 | 1), RecomposeScopeImplKt.updateChangedFlags(arg38), arg39);
        return Unit.INSTANCE;
    }

    private static final void Scrim-KTwxG1Y(long arg20, Function0 arg22, boolean arg23, boolean arg24, Composer arg25, int arg26) {
        ModalBottomSheetKt$$ExternalSyntheticLambda15 v9_3;
        Modifier v0_1;
        int v14_2;
        ModalBottomSheetKt$$ExternalSyntheticLambda14 v11_2;
        ModalBottomSheetKt$Scrim$dismissSheet$1$1 v14_1;
        int v11;
        int v8;
        int v7;
        long v1 = arg20;
        Function0 v3 = arg22;
        boolean v4 = arg23;
        boolean v5 = arg24;
        int v6 = arg26;
        int v0 = 0xE8A87229;
        Composer v12 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible,dismissEnabled):ModalBottomSheet.kt#uh7d8r");
        if((v6 & 6) == 0) {
            v7 = v12.changed(v1) ? 4 : 2;
            v7 |= v6;
        }
        else {
            v7 = v6;
        }

        int v9 = 0x20;
        if((v6 & 0x30) == 0) {
            v8 = v12.changedInstance(v3) ? v9 : 16;
            v7 |= v8;
        }

        if((v6 & 0x180) == 0) {
            v8 = v12.changed(v4) ? 0x100 : 0x80;
            v7 |= v8;
        }

        if((v6 & 0xC00) == 0) {
            v8 = v12.changed(v5) ? 0x800 : 0x400;
            v7 |= v8;
        }

        boolean v8_1 = (v7 & 0x493) != 1170 ? true : false;
        if(v12.shouldExecute(v8_1, v7 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v7, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:514)");
            }

            if(v1 != 16) {
                v12.startReplaceGroup(0xAA40F9CA);
                ComposerKt.sourceInformation(v12, "520@24316L7,518@24171L167,522@24364L29,537@24994L79,537@24944L129");
                float v8_2 = v4 ? 1f : 0f;
                int v18 = v7;
                v0 = v9;
                State v7_1 = AnimateAsStateKt.animateFloatAsState(v8_2, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v12, 6), 0f, null, null, v12, 0, 28);
                String v8_3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(androidx.compose.ui.R$string.close_sheet), v12, 0);
                String v9_1 = "CC(remember):ModalBottomSheet.kt#9igjgp";
                if(v5) {
                    v12.startReplaceGroup(0xAA4588C5);
                    ComposerKt.sourceInformation(v12, "525@24511L44,526@24612L263");
                    Companion v10 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(v12, 0x6054D895, v9_1);
                    v11 = v18 & 0x70;
                    int v13 = v11 == v0 ? 1 : 0;
                    Object v14 = v12.rememberedValue();
                    if(v13 != 0 || v14 == Composer.Companion.getEmpty()) {
                        v14_1 = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(v3);
                        v12.updateRememberedValue(v14_1);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                    Modifier v10_1 = SuspendingPointerInputFilterKt.pointerInput(((Modifier)v10), v3, ((PointerInputEventHandler)v14_1));
                    ComposerKt.sourceInformationMarkerStart(v12, 0x6054E610, v9_1);
                    boolean v13_1 = v12.changed(v8_3);
                    v11 = v11 == v0 ? 1 : 0;
                    v0 = (((int)v13_1)) | v11;
                    Object v11_1 = v12.rememberedValue();
                    if(v0 != 0 || v11_1 == Composer.Companion.getEmpty()) {
                        v11_2 = new ModalBottomSheetKt$$ExternalSyntheticLambda14(v8_3, v3);
                        v12.updateRememberedValue(v11_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v12);
                    v14_2 = 1;
                    v0_1 = SemanticsModifierKt.semantics(v10_1, true, ((Function1)v11_2));
                    v12.endReplaceGroup();
                }
                else {
                    v14_2 = 1;
                    v12.startReplaceGroup(0xAA4C0991);
                    v12.endReplaceGroup();
                    Companion v0_2 = Modifier.Companion;
                }

                v0_1 = SizeKt.fillMaxSize$default(Modifier.Companion, 0f, v14_2, null).then(v0_1);
                ComposerKt.sourceInformationMarkerStart(v12, 0x60551518, v9_1);
                v11 = (v18 & 14) == 4 ? v14_2 : 0;
                v8 = v12.changed(v7_1) | v11;
                Object v9_2 = v12.rememberedValue();
                if(v8 != 0 || v9_2 == Composer.Companion.getEmpty()) {
                    v9_3 = new ModalBottomSheetKt$$ExternalSyntheticLambda15(v1, v7_1);
                    v12.updateRememberedValue(v9_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v12);
                CanvasKt.Canvas(v0_1, ((Function1)v9_3), v12, 0);
                v12.endReplaceGroup();
            }
            else {
                v12.startReplaceGroup(-1437676103);
                v12.endReplaceGroup();
            }

            if(!ComposerKt.isTraceInProgress()) {
                goto label_179;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
        }

    label_179:
        ScopeUpdateScope v7_2 = v12.endRestartGroup();
        if(v7_2 != null) {
            v7_2.updateScope(new ModalBottomSheetKt$$ExternalSyntheticLambda16(v1, v3, v4, v5, v6));
        }
    }

    private static final float Scrim_KTwxG1Y$lambda$27(State arg0) {
        return arg0.getValue().floatValue();
    }

    static final Unit Scrim_KTwxG1Y$lambda$31$lambda$30(String arg1, Function0 arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setTraversalIndex(arg3, 1f);
        SemanticsPropertiesKt.setContentDescription(arg3, arg1);
        SemanticsPropertiesKt.onClick$default(arg3, null, new ModalBottomSheetKt$$ExternalSyntheticLambda13(arg2), 1, null);
        return Unit.INSTANCE;
    }

    static final boolean Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0 arg0) {
        arg0.invoke();
        return 1;
    }

    static final Unit Scrim_KTwxG1Y$lambda$33$lambda$32(long arg16, State arg18, DrawScope arg19) {
        DrawScope.drawRect-n-J9OG0$default(arg19, arg16, 0, 0, RangesKt.coerceIn(ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$27(arg18), 0f, 1f), null, null, 0, 0x76, null);
        return Unit.INSTANCE;
    }

    static final Unit Scrim_KTwxG1Y$lambda$34(long arg7, Function0 arg9, boolean arg10, boolean arg11, int arg12, Composer arg13, int arg14) {
        ModalBottomSheetKt.Scrim-KTwxG1Y(arg7, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$Scrim-KTwxG1Y(long arg0, Function0 arg2, boolean arg3, boolean arg4, Composer arg5, int arg6) {
        ModalBottomSheetKt.Scrim-KTwxG1Y(arg0, arg2, arg3, arg4, arg5, arg6);
    }

    public static final float access$calculatePredictiveBackScaleX(GraphicsLayerScope arg0, float arg1) {
        return ModalBottomSheetKt.calculatePredictiveBackScaleX(arg0, arg1);
    }

    public static final float access$calculatePredictiveBackScaleY(GraphicsLayerScope arg0, float arg1) {
        return ModalBottomSheetKt.calculatePredictiveBackScaleY(arg0, arg1);
    }

    public static final long access$getPredictiveBackChildTransformOrigin$p() {
        return ModalBottomSheetKt.PredictiveBackChildTransformOrigin;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope arg4, float arg5) {
        float v0 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() >> 0x20)));
        float v2 = 1f;
        if(!Float.isNaN(v0)) {
            if(v0 == 0f) {
            }
            else {
                v2 -= MathHelpersKt.lerp(0f, Math.min(arg4.toPx-0680j_4(ModalBottomSheetKt.PredictiveBackMaxScaleXDistance), v0), arg5) / v0;
            }
        }

        return v2;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope arg4, float arg5) {
        float v0 = Float.intBitsToFloat(((int)(arg4.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        float v2 = 1f;
        if(!Float.isNaN(v0)) {
            if(v0 == 0f) {
            }
            else {
                v2 -= MathHelpersKt.lerp(0f, Math.min(arg4.toPx-0680j_4(ModalBottomSheetKt.PredictiveBackMaxScaleYDistance), v0), arg5) / v0;
            }
        }

        return v2;
    }

    public static final SheetState rememberModalBottomSheetState(boolean arg11, Function1 arg12, Composer arg13, int arg14, int arg15) {
        Object v12;
        ModalBottomSheetKt$$ExternalSyntheticLambda12 v11_1;
        int v1 = -778250030;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)500@23719L8,502@23737L160:ModalBottomSheet.kt#uh7d8r");
        if((arg15 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg13, 0xDDCA013A, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object v11 = arg13.rememberedValue();
            if(v11 == Composer.Companion.getEmpty()) {
                v11_1 = new ModalBottomSheetKt$$ExternalSyntheticLambda12();
                arg13.updateRememberedValue(v11_1);
            }

            v12 = v11_1;
            ComposerKt.sourceInformationMarkerEnd(arg13);
        }

        Function1 v3 = ((Function1)v12);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:502)");
        }

        Composer v8 = arg13;
        SheetState v11_2 = SheetDefaultsKt.rememberSheetState-AGcomas(false, v3, SheetValue.Hidden, false, 0f, 0f, v8, arg14 & 14 | 0x180 | arg14 & 0x70, 56);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v8);
        return v11_2;
    }

    static final boolean rememberModalBottomSheetState$lambda$26$lambda$25(SheetValue arg0) {
        return 1;
    }
}

