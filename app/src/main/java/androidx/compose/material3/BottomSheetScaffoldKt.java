package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\u001A\u0087\u0002\u0010\u0000\u001A\u00020\u00012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00112\b\b\u0002\u0010\u0013\u001A\u00020\f2\b\b\u0002\u0010\u0014\u001A\u00020\f2\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001A\u00020\u00182\u0015\b\u0002\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001A\u001A\u0013\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001C\u001A\u00020\u00112\b\b\u0002\u0010\u001D\u001A\u00020\u00112\u0017\u0010\u001E\u001A\u0013\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007¢\u0006\u0004\b \u0010!\u001A!\u0010\"\u001A\u00020\n2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020\u001BH\u0007¢\u0006\u0002\u0010&\u001A7\u0010\'\u001A\u00020$2\b\b\u0002\u0010(\u001A\u00020)2\u0014\b\u0002\u0010*\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010+\u001A\u00020\u0018H\u0007¢\u0006\u0002\u0010,\u001A\u008A\u0001\u0010-\u001A\u00020\u00012\u0006\u0010.\u001A\u00020$2\u0006\u0010/\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u00100\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u00112\u0006\u00101\u001A\u00020\f2\u0006\u00102\u001A\u00020\f2\u0013\u00103\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001C\u0010\u001E\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b4\u00105\u001Aq\u00106\u001A\u00020\u00012\u0013\u0010\u0019\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00107\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u00108\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0011\u0010\u001A\u001A\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\f\u00109\u001A\b\u0012\u0004\u0012\u00020:0\u00162\u0006\u0010;\u001A\u00020$H\u0003¢\u0006\u0002\u0010<\u001A\u0014\u0010=\u001A\u00020\b*\u00020\b2\u0006\u0010.\u001A\u00020$H\u0000\u001A\u0014\u0010>\u001A\u00020\b*\u00020\b2\u0006\u0010.\u001A\u00020$H\u0000¨\u0006?"}, d2={"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "Landroidx/compose/material3/SheetState;", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "StandardBottomSheet", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffoldLayout", "body", "bottomSheet", "sheetOffset", "", "sheetState", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;Landroidx/compose/runtime/Composer;I)V", "verticalScaleUp", "verticalScaleDown", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BottomSheetScaffoldKt {
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

    public static final void BottomSheetScaffold-sdMYb0k(Function3 arg34, Modifier arg35, BottomSheetScaffoldState arg36, float arg37, float arg38, Shape arg39, long arg40, long arg42, float arg44, float arg45, Function2 arg46, boolean arg47, Function2 arg48, Function3 arg49, long arg50, long arg52, Function3 arg54, Composer arg55, int arg56, int arg57, int arg58) {
        long v19_1;
        boolean v14_1;
        Function2 v15_1;
        Function2 v13_2;
        long v17_2;
        Function3 v16_2;
        Modifier v2_3;
        long v9_1;
        float v11;
        long v7_2;
        Shape v6_1;
        BottomSheetScaffoldState v3_1;
        float v4_2;
        Composer v0_7;
        float v12_2;
        BottomSheetScaffoldState v8_1;
        long v26_1;
        long v24_1;
        Function3 v17_1;
        Function2 v21_1;
        boolean v22_1;
        Function2 v20_1;
        float v13_1;
        Modifier v0_5;
        Companion v35;
        Companion v0_6;
        long v0_2;
        int v31;
        int v21;
        int v30;
        long v14;
        int v27;
        int v26;
        long v10;
        int v24;
        Shape v9;
        int v22;
        float v6;
        int v18;
        float v5;
        int v15;
        BottomSheetScaffoldState v12_1;
        int v7;
        int v0 = arg56;
        int v1 = arg57;
        int v2 = arg58;
        Composer v3 = arg55.startRestartGroup(920075480);
        ComposerKt.sourceInformation(v3, "C(BottomSheetScaffold)N(sheetContent,modifier,scaffoldState,sheetPeekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetShape,sheetContainerColor:c#ui.graphics.Color,sheetContentColor:c#ui.graphics.Color,sheetTonalElevation:c#ui.unit.Dp,sheetShadowElevation:c#ui.unit.Dp,sheetDragHandle,sheetSwipeEnabled,topBar,snackbarHost,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,content)136@7263L1424:BottomSheetScaffold.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v3.changedInstance(arg34) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        int v8 = v2 & 2;
        if(v8 != 0) {
            v7 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            int v12 = v3.changed(arg35) ? 0x20 : 16;
            v7 |= v12;
        }

        if((v0 & 0x180) == 0) {
            if((v2 & 4) == 0) {
                v12_1 = arg36;
                if(v3.changed(v12_1)) {
                    v15 = 0x100;
                }
                else {
                    goto label_51;
                }
            }
            else {
                v12_1 = arg36;
            label_51:
                v15 = 0x80;
            }

            v7 |= v15;
        }
        else {
            v12_1 = arg36;
        }

        v15 = v2 & 8;
        int v16 = 0x800;
        int v17 = 0x400;
        if(v15 != 0) {
            v7 |= 0xC00;
            goto label_71;
        }
        else if((v0 & 0xC00) == 0) {
            v5 = arg37;
            v18 = v3.changed(v5) ? v16 : v17;
            v7 |= v18;
        }
        else {
        label_71:
            v5 = arg37;
        }

        v18 = v2 & 16;
        int v19 = 0x2000;
        int v20 = 0x4000;
        if(v18 != 0) {
            v7 |= 0x6000;
            goto label_88;
        }
        else if((v0 & 0x6000) == 0) {
            v6 = arg38;
            v22 = v3.changed(v6) ? v20 : v19;
            v7 |= v22;
        }
        else {
        label_88:
            v6 = arg38;
        }

        int v23 = 0x10000;
        if((v0 & 0x30000) == 0) {
            v9 = arg39;
            v24 = (v2 & 0x20) != 0 || !v3.changed(v9) ? v23 : 0x20000;
            v7 |= v24;
        }
        else {
            v9 = arg39;
        }

        v24 = 0x180000;
        if((v0 & v24) == 0) {
            v10 = arg40;
            v26 = (v2 & 0x40) != 0 || !v3.changed(v10) ? 0x80000 : 0x100000;
            v7 |= v26;
        }
        else {
            v10 = arg40;
        }

        if((v0 & 0xC00000) == 0) {
            v27 = v15;
            v14 = arg42;
            int v28 = (v2 & 0x80) != 0 || !v3.changed(v14) ? 0x400000 : 0x800000;
            v7 |= v28;
        }
        else {
            v27 = v15;
            v14 = arg42;
        }

        int v13 = v2 & 0x100;
        int v29 = 0x6000000;
        if(v13 != 0) {
            v7 |= v29;
        }
        else {
            v29 &= v0;
            float v0_1 = arg44;
            if(v29 == 0) {
                v29 = v3.changed(v0_1) ? 0x4000000 : 0x2000000;
                v7 |= v29;
            }
        }

        v0 = v2 & 0x200;
        v29 = 0x30000000;
        if(v0 != 0) {
            v7 |= v29;
            goto label_165;
        }
        else if((arg56 & v29) == 0) {
            v29 = v0;
            v30 = v3.changed(arg45) ? 0x20000000 : 0x10000000;
            v7 |= v30;
        }
        else {
        label_165:
            v29 = v0;
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v21 = v1 | 6;
            v30 = v0;
        }
        else if((v1 & 6) == 0) {
            v30 = v0;
            v21 = v3.changedInstance(arg46) ? 4 : 2;
            v21 |= v1;
        }
        else {
            v30 = v0;
            v21 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v21 |= 0x30;
            v31 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v31 = v0;
            int v25 = v3.changed(arg47) ? 0x20 : 16;
            v21 |= v25;
        }
        else {
            v31 = v0;
        }

        v0 = v21;
        int v4 = v2 & 0x1000;
        if(v4 != 0) {
            v0 |= 0x180;
        }
        else {
            v21 = v0;
            if((v1 & 0x180) == 0) {
                v26 = v3.changedInstance(arg48) ? 0x100 : 0x80;
                v21 |= v26;
            }

            v0 = v21;
        }

        v21 = v4;
        v4 = v2 & 0x2000;
        if(v4 != 0) {
            v16 = v0 | 0xC00;
        }
        else {
            v22 = v0;
            if((v1 & 0xC00) == 0) {
                if(v3.changedInstance(arg49)) {
                }
                else {
                    v16 = v17;
                }

                v16 |= v22;
            }
            else {
                v16 = v22;
            }
        }

        if((v1 & 0x6000) == 0) {
            if((v2 & 0x4000) == 0 && (v3.changed(arg50))) {
                v19 = v20;
            }

            v16 |= v19;
        }

        if((arg57 & 0x30000) == 0) {
            v0_2 = arg52;
            v17 = (v2 & 0x8000) != 0 || !v3.changed(v0_2) ? v23 : 0x20000;
            v16 |= v17;
        }

        if((v2 & v23) != 0) {
            v16 |= v24;
        }
        else {
            Function3 v0_3 = arg54;
            if((arg57 & v24) == 0) {
                v1 = v3.changedInstance(v0_3) ? 0x100000 : 0x80000;
                v16 |= v1;
            }
        }

        v17 = v4;
        boolean v0_4 = (306783379 & v7) != 306783378 || (v16 & 0x92493) != 0x92492 ? true : false;
        if(v3.shouldExecute(v0_4, v7 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "120@6376L34,123@6578L13,124@6646L14,125@6693L36,132@7125L11,133@7172L31");
            v19 = 0xFFF8FFFF;
            SheetState v1_1 = null;
            if((arg56 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v0_6 = Modifier.Companion;
                }
                else {
                    v0_5 = arg35;
                }

                if((v2 & 4) != 0) {
                    v8_1 = BottomSheetScaffoldKt.rememberBottomSheetScaffoldState(v1_1, ((SnackbarHostState)v1_1), v3, 0, 3);
                    v7 &= -897;
                }
                else {
                    v8_1 = v12_1;
                }

                if(v27 != 0) {
                    v5 = BottomSheetDefaults.INSTANCE.getSheetPeekHeight-D9Ej5fM();
                }

                if(v18 != 0) {
                    v6 = BottomSheetDefaults.INSTANCE.getSheetMaxWidth-D9Ej5fM();
                }

                v1 = 6;
                if((v2 & 0x20) != 0) {
                    v9 = BottomSheetDefaults.INSTANCE.getExpandedShape(v3, v1);
                    v7 &= v19;
                }

                if((v2 & 0x40) != 0) {
                    v10 = BottomSheetDefaults.INSTANCE.getContainerColor(v3, v1);
                    v7 &= 0xFFC7FFFF;
                }

                if((v2 & 0x80) != 0) {
                    v14 = ColorSchemeKt.contentColorFor-ek8zF_U(v10, v3, v7 >> 18 & 14);
                    v7 &= 0xFE3FFFFF;
                }

                v12_2 = v13 != 0 ? Dp.constructor-impl(0f) : arg44;
                v13_1 = v29 != 0 ? BottomSheetDefaults.INSTANCE.getElevation-D9Ej5fM() : arg45;
                v20_1 = v30 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1392012807$material3() : arg46;
                v22_1 = v31 != 0 ? true : arg47;
                v21_1 = v21 != 0 ? null : arg48;
                v17_1 = v17 != 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$1768941633$material3() : arg49;
                if((v2 & 0x4000) != 0) {
                    v16 &= 0xFFFF1FFF;
                    v35 = ((Companion)v0_5);
                    v0_2 = MaterialTheme.INSTANCE.getColorScheme(v3, v1).getSurface-0d7_KjU();
                }
                else {
                    v35 = ((Companion)v0_5);
                    v0_2 = arg50;
                }

                if((0x8000 & v2) != 0) {
                    v24_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v0_2, v3, v16 >> 12 & 14);
                    v16 &= v19;
                    v26_1 = v24_1;
                }
                else {
                    v26_1 = arg52;
                }

                v24_1 = v0_2;
                v1 = v16;
                v0_6 = v35;
            }
            else {
                v3.skipToGroupEnd();
                if((v2 & 4) != 0) {
                    v7 &= -897;
                }

                if((v2 & 0x20) != 0) {
                    v7 &= v19;
                }

                if((v2 & 0x40) != 0) {
                    v7 &= 0xFFC7FFFF;
                }

                if((v2 & 0x80) != 0) {
                    v7 &= 0xFE3FFFFF;
                }

                if((v2 & 0x4000) != 0) {
                    v16 &= 0xFFFF1FFF;
                }

                if((0x8000 & v2) != 0) {
                    v16 &= v19;
                }

                v0_5 = arg35;
                v13_1 = arg45;
                v20_1 = arg46;
                v22_1 = arg47;
                v21_1 = arg48;
                v17_1 = arg49;
                v24_1 = arg50;
                v26_1 = arg52;
                v8_1 = v12_1;
                v1 = v16;
                v12_2 = arg44;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(920075480, v7, v1, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:135)");
            }

            Modifier v1_2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(v0_5, 0f, 1, null), v24_1, null, 2, null);
            long v18_1 = v24_1;
            ComposerKt.sourceInformationMarkerStart(v3, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v2_1 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            Modifier v16_1 = v0_5;
            ComposerKt.sourceInformationMarkerStart(v3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v0 = ComposablesKt.getCurrentCompositeKeyHash(v3, 0);
            CompositionLocalMap v4_1 = v3.getCurrentCompositionLocalMap();
            v1_2 = ComposedModifierKt.materializeModifier(v3, v1_2);
            Function0 v7_1 = ComposeUiNode.Companion.getConstructor();
            int v35_1 = v0;
            float v39 = v5;
            ComposerKt.sourceInformationMarkerStart(v3, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v3.startReusableNode();
            if(v3.getInserting()) {
                v3.createNode(v7_1);
            }
            else {
                v3.useNode();
            }

            v0_7 = Updater.constructor-impl(v3);
            Updater.set-impl(v0_7, v2_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_7, v4_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v2_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_7.getInserting()) || !Intrinsics.areEqual(v0_7.rememberedValue(), Integer.valueOf(v35_1))) {
                v0_7.updateRememberedValue(Integer.valueOf(v35_1));
                v0_7.apply(Integer.valueOf(v35_1), v2_2);
            }

            Updater.set-impl(v0_7, v1_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v3, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(v3, 0xBF99708E, "C139@7540L1141,139@7474L1207:BottomSheetScaffold.kt#uh7d8r");
            v5 = v39;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(v26_1)), ComposableLambdaKt.rememberComposableLambda(999829022, true, new BottomSheetScaffoldKt$BottomSheetScaffold$1$1(v8_1, v21_1, arg54, v39, v6, v22_1, v9, v10, v14, v12_2, v13_1, v20_1, arg34, v17_1), v3, 54), v3, ProvidedValue.$stable | 0x30);
            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            v3.endNode();
            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_7 = v3;
            v4_2 = v5;
            v5 = v6;
            v3_1 = v8_1;
            v6_1 = v9;
            v7_2 = v10;
            v11 = v12_2;
            v12_2 = v13_1;
            v9_1 = v14;
            v2_3 = v16_1;
            v16_2 = v17_1;
            v17_2 = v18_1;
            v13_2 = v20_1;
            v15_1 = v21_1;
            v14_1 = v22_1;
            v19_1 = v26_1;
        }
        else {
            v3.skipToGroupEnd();
            v2_3 = arg35;
            v13_2 = arg46;
            v16_2 = arg49;
            v17_2 = arg50;
            v19_1 = arg52;
            v0_7 = v3;
            v4_2 = v5;
            v5 = v6;
            v6_1 = v9;
            v7_2 = v10;
            v3_1 = v12_1;
            v9_1 = v14;
            v11 = arg44;
            v12_2 = arg45;
            v14_1 = arg47;
            v15_1 = arg48;
        }

        ScopeUpdateScope v0_8 = v0_7.endRestartGroup();
        if(v0_8 != null) {
            v0_8.updateScope(new BottomSheetScaffoldKt$$ExternalSyntheticLambda7(arg34, v2_3, v3_1, v4_2, v5, v6_1, v7_2, v9_1, v11, v12_2, v13_2, v14_1, v15_1, v16_2, v17_2, v19_1, arg54, arg56, arg57, arg58));
        }
    }

    private static final void BottomSheetScaffoldLayout(Function2 arg17, Function2 arg18, Function2 arg19, Function2 arg20, Function0 arg21, SheetState arg22, Composer arg23, int arg24) {
        BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 v10_3;
        int v12;
        int v9;
        Function2 v1 = arg17;
        Function2 v2 = arg18;
        Function2 v3 = arg19;
        Function2 v4 = arg20;
        Function0 v5 = arg21;
        SheetState v6 = arg22;
        int v7 = arg24;
        int v0 = 0xB76B0349;
        Composer v8 = arg23.startRestartGroup(v0);
        ComposerKt.sourceInformation(v8, "C(BottomSheetScaffoldLayout)N(topBar,body,bottomSheet,snackbarHost,sheetOffset,sheetState)416@20022L1942,414@19911L2053:BottomSheetScaffold.kt#uh7d8r");
        int v10 = 4;
        if((v7 & 6) == 0) {
            v9 = v8.changedInstance(v1) ? v10 : 2;
            v9 |= v7;
        }
        else {
            v9 = v7;
        }

        if((v7 & 0x30) == 0) {
            v12 = v8.changedInstance(v2) ? 0x20 : 16;
            v9 |= v12;
        }

        if((v7 & 0x180) == 0) {
            v12 = v8.changedInstance(v3) ? 0x100 : 0x80;
            v9 |= v12;
        }

        if((v7 & 0xC00) == 0) {
            v12 = v8.changedInstance(v4) ? 0x800 : 0x400;
            v9 |= v12;
        }

        int v13 = 0x4000;
        if((v7 & 0x6000) == 0) {
            v12 = v8.changedInstance(v5) ? v13 : 0x2000;
            v9 |= v12;
        }

        int v14 = 0x20000;
        if((0x30000 & v7) == 0) {
            v12 = v8.changed(v6) ? v14 : 0x10000;
            v9 |= v12;
        }

        int v16 = 1;
        int v23 = 2;
        boolean v12_1 = (74899 & v9) != 74898 ? true : false;
        if(v8.shouldExecute(v12_1, v9 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:413)");
            }

            Function2[] v0_1 = new Function2[v10];
            Function2 v10_1 = v1 == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.getLambda$-788244078$material3() : v1;
            v0_1[0] = v10_1;
            v0_1[1] = v2;
            v0_1[v23] = v3;
            v0_1[3] = v4;
            List v0_2 = CollectionsKt.listOf(((Object[])v0_1));
            ComposerKt.sourceInformationMarkerStart(v8, -2001235553, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            v10 = (0x70000 & v9) == v14 ? 1 : 0;
            if((v9 & 0xE000) == v13) {
            }
            else {
                v16 = 0;
            }

            v9 = v10 | v16;
            Object v10_2 = v8.rememberedValue();
            if(v9 != 0 || v10_2 == Composer.Companion.getEmpty()) {
                v10_3 = new BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(v6, v5);
                v8.updateRememberedValue(v10_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, 0x5365E06C, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Companion v9_1 = Modifier.Companion;
            Function2 v0_3 = LayoutKt.combineAsVirtualLayouts(v0_2);
            ComposerKt.sourceInformationMarkerStart(v8, -290764973, "CC(remember):Layout.kt#9igjgp");
            v12_1 = v8.changed(v10_3);
            Object v13_1 = v8.rememberedValue();
            if((v12_1) || v13_1 == Composer.Companion.getEmpty()) {
                MeasurePolicy v13_2 = MultiContentMeasurePolicyKt.createMeasurePolicy(((MultiContentMeasurePolicy)v10_3));
                v8.updateRememberedValue(v13_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerStart(v8, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v10 = ComposablesKt.getCurrentCompositeKeyHash(v8, 0);
            CompositionLocalMap v12_2 = v8.getCurrentCompositionLocalMap();
            Modifier v9_2 = ComposedModifierKt.materializeModifier(v8, ((Modifier)v9_1));
            Function0 v14_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v8, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v8.startReusableNode();
            if(v8.getInserting()) {
                v8.createNode(v14_1);
            }
            else {
                v8.useNode();
            }

            Composer v11 = Updater.constructor-impl(v8);
            Updater.set-impl(v11, v13_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v11, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v12_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v11.getInserting()) || !Intrinsics.areEqual(v11.rememberedValue(), Integer.valueOf(v10))) {
                v11.updateRememberedValue(Integer.valueOf(v10));
                v11.apply(Integer.valueOf(v10), v12_3);
            }

            Updater.set-impl(v11, v9_2, ComposeUiNode.Companion.getSetModifier());
            v0_3.invoke(v8, Integer.valueOf(0));
            v8.endNode();
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            ComposerKt.sourceInformationMarkerEnd(v8);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_193;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v8.skipToGroupEnd();
        }

    label_193:
        ScopeUpdateScope v8_1 = v8.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new BottomSheetScaffoldKt$$ExternalSyntheticLambda9(v1, v2, v3, v4, v5, v6, v7));
        }
    }

    static final Unit BottomSheetScaffoldLayout$lambda$16(Function2 arg8, Function2 arg9, Function2 arg10, Function2 arg11, Function0 arg12, SheetState arg13, int arg14, Composer arg15, int arg16) {
        BottomSheetScaffoldKt.BottomSheetScaffoldLayout(arg8, arg9, arg10, arg11, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    static final Unit BottomSheetScaffold_sdMYb0k$lambda$1(Function3 arg26, Modifier arg27, BottomSheetScaffoldState arg28, float arg29, float arg30, Shape arg31, long arg32, long arg34, float arg36, float arg37, Function2 arg38, boolean arg39, Function2 arg40, Function3 arg41, long arg42, long arg44, Function3 arg46, int arg47, int arg48, int arg49, Composer arg50, int arg51) {
        BottomSheetScaffoldKt.BottomSheetScaffold-sdMYb0k(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg34, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg44, arg46, arg50, RecomposeScopeImplKt.updateChangedFlags(arg47 | 1), RecomposeScopeImplKt.updateChangedFlags(arg48), arg49);
        return Unit.INSTANCE;
    }

    private static final void StandardBottomSheet-w7I5h1o(SheetState arg24, float arg25, float arg26, boolean arg27, Shape arg28, long arg29, long arg31, float arg33, float arg34, Function2 arg35, Function3 arg36, Composer arg37, int arg38, int arg39) {
        Composer v18;
        BottomSheetScaffoldKt$$ExternalSyntheticLambda3 v8_6;
        Modifier v8_4;
        Object v22;
        NestedScrollConnection v8_3;
        Object v8_2;
        int v21;
        int v8;
        int v17;
        int v11;
        int v10;
        int v5;
        SheetState v1 = arg24;
        float v6 = arg25;
        float v7 = arg26;
        boolean v4 = arg27;
        int v0 = arg38;
        Composer v3 = arg37.startRestartGroup(-2108849428);
        ComposerKt.sourceInformation(v3, "C(StandardBottomSheet)N(state,peekHeight:c#ui.unit.Dp,sheetMaxWidth:c#ui.unit.Dp,sheetSwipeEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,dragHandle,content)238@11171L7,239@11265L7,240@11356L7,242@11380L159,242@11369L170,248@11557L24,250@11666L7,271@12473L1938,322@15222L4372,265@12198L7396:BottomSheetScaffold.kt#uh7d8r");
        if((v0 & 6) == 0) {
            v5 = v3.changed(v1) ? 4 : 2;
            v5 |= v0;
        }
        else {
            v5 = v0;
        }

        if((v0 & 0x30) == 0) {
            v10 = v3.changed(v6) ? 0x20 : 16;
            v5 |= v10;
        }

        if((v0 & 0x180) == 0) {
            v10 = v3.changed(v7) ? 0x100 : 0x80;
            v5 |= v10;
        }

        if((v0 & 0xC00) == 0) {
            v10 = v3.changed(v4) ? 0x800 : 0x400;
            v5 |= v10;
        }

        if((v0 & 0x6000) == 0) {
            v11 = v3.changed(arg28) ? 0x4000 : 0x2000;
            v5 |= v11;
        }

        if((0x30000 & v0) == 0) {
            int v13 = v3.changed(arg29) ? 0x20000 : 0x10000;
            v5 |= v13;
        }

        if((0x180000 & v0) == 0) {
            int v15 = v3.changed(arg31) ? 0x100000 : 0x80000;
            v5 |= v15;
        }

        int v16 = 0xC00000;
        if((v0 & v16) == 0) {
            v17 = v3.changed(arg33) ? 0x800000 : 0x400000;
            v5 |= v17;
        }

        float v12 = arg34;
        if((v0 & 0x6000000) == 0) {
            v11 = v3.changed(v12) ? 0x4000000 : 0x2000000;
            v5 |= v11;
        }

        if((0x30000000 & v0) == 0) {
            v17 = v3.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v5 |= v17;
        }

        Function3 v12_1 = arg36;
        if((arg39 & 6) == 0) {
            v17 = v3.changedInstance(v12_1) ? 4 : 2;
            v8 = arg39 | v17;
        }
        else {
            v8 = arg39;
        }

        boolean v2 = (v5 & 306783379) != 306783378 || (v8 & 3) != 2 ? true : false;
        if(v3.shouldExecute(v2, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2108849428, v5, v8, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:235)");
            }

            FiniteAnimationSpec v2_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v3, 6);
            FiniteAnimationSpec v9 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, v3, 6);
            FiniteAnimationSpec v8_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v3, 6);
            String v0_1 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, 0x24F8DACB, v0_1);
            int v12_2 = v5 & 14;
            int v4_1 = v12_2 == 4 ? 1 : 0;
            int v20 = v4_1 | v3.changedInstance(v9) | v3.changedInstance(v8_1) | v3.changedInstance(v2_1);
            Object v4_2 = v3.rememberedValue();
            if(v20 == 0) {
                v21 = v5;
                if(v4_2 == Composer.Companion.getEmpty()) {
                    goto label_175;
                }
            }
            else {
                v21 = v5;
            label_175:
                BottomSheetScaffoldKt$$ExternalSyntheticLambda1 v4_3 = new BottomSheetScaffoldKt$$ExternalSyntheticLambda1(v1, v9, v8_1, v2_1);
                v3.updateRememberedValue(v4_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            EffectsKt.SideEffect(((Function0)v4_2), v3, 0);
            ComposerKt.sourceInformationMarkerStart(v3, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v3, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            v4_2 = v3.rememberedValue();
            if(v4_2 == Composer.Companion.getEmpty()) {
                CoroutineScope v4_4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v3);
                v3.updateRememberedValue(v4_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            Orientation v10_1 = Orientation.Vertical;
            ProvidableCompositionLocal v5_1 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v5_2 = v3.consume(((CompositionLocal)v5_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            float v5_3 = ((Density)v5_2).toPx-0680j_4(v6);
            if(arg27) {
                v3.startReplaceGroup(2049456610);
                ComposerKt.sourceInformation(v3, "254@11804L327");
                Companion v9_1 = Modifier.Companion;
                AnchoredDraggableState v2_2 = v1.getAnchoredDraggableState$material3();
                ComposerKt.sourceInformationMarkerStart(v3, 0x24F91073, v0_1);
                v2 = v3.changed(v2_2);
                v8_2 = v3.rememberedValue();
                if((v2) || v8_2 == Composer.Companion.getEmpty()) {
                    v8_3 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(v1, v10_1, new BottomSheetScaffoldKt$$ExternalSyntheticLambda2(((CoroutineScope)v4_2), v1));
                    v3.updateRememberedValue(v8_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                v22 = v4_2;
                v8_4 = NestedScrollModifierKt.nestedScroll$default(((Modifier)v9_1), v8_3, null, 2, null);
                v3.endReplaceGroup();
            }
            else {
                v22 = v4_2;
                v3.startReplaceGroup(2049851798);
                v3.endReplaceGroup();
                Companion v8_5 = Modifier.Companion;
            }

            Modifier v2_3 = SizeKt.requiredHeightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0f, v7, 1, null), 0f, 1, null), v6, 0f, 2, null).then(v8_4);
            AnchoredDraggableState v4_5 = v1.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(v3, 620325470, v0_1);
            v0 = v12_2 == 4 ? 1 : 0;
            v0 |= v3.changed(v5_3);
            v8_2 = v3.rememberedValue();
            if(v0 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                v8_6 = new BottomSheetScaffoldKt$$ExternalSyntheticLambda3(v1, v5_3);
                v3.updateRememberedValue(v8_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            v0 = v21 >> 9;
            v18 = v3;
            SurfaceKt.Surface-T9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(v2_3, v4_5, v10_1, ((Function2)v8_6)), v1.getAnchoredDraggableState$material3(), v10_1, arg27, false, null, 24, null), v1), arg28, arg29, arg31, arg33, arg34, null, ComposableLambdaKt.rememberComposableLambda(0x59E70371, true, new BottomSheetScaffoldKt$StandardBottomSheet$3(v1, arg35, arg36, v22, arg27), v3, 54), v18, v0 & 0x70 | v16 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | v0 & 0x70000, 0x40);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_314;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v18 = v3;
            v18.skipToGroupEnd();
        }

    label_314:
        ScopeUpdateScope v0_2 = v18.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BottomSheetScaffoldKt$$ExternalSyntheticLambda4(arg24, v6, v7, arg27, arg28, arg29, arg31, arg33, arg34, arg35, arg36, arg38, arg39));
        }
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$10$lambda$9(CoroutineScope arg8, SheetState arg9, float arg10) {
        BuildersKt.launch$default(arg8, null, null, new BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1(arg9, arg10, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Pair StandardBottomSheet_w7I5h1o$lambda$13$lambda$12(SheetState arg4, float arg5, IntSize arg6, Constraints arg7) {
        SheetValue v4_1;
        DraggableAnchors v5 = AnchoredDraggableKt.DraggableAnchors(new BottomSheetScaffoldKt$$ExternalSyntheticLambda8(arg4, ((float)Constraints.getMaxHeight-impl(arg7.unbox-impl())), arg5, ((float)(((int)(arg6.unbox-impl() & 0xFFFFFFFFL))))));
        Object v4 = arg4.getAnchoredDraggableState$material3().getTargetValue();
        int v6 = WhenMappings.$EnumSwitchMapping$0[((SheetValue)v4).ordinal()];
        if(v6 != 1) {
            if(v6 != 2) {
                if(v6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                else if(v5.hasAnchorFor(SheetValue.Expanded)) {
                    v4_1 = SheetValue.Expanded;
                }
                else if(v5.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                    v4_1 = SheetValue.PartiallyExpanded;
                }
                else if(v5.hasAnchorFor(SheetValue.Hidden)) {
                    v4_1 = SheetValue.Hidden;
                }
            }
            else if(v5.hasAnchorFor(SheetValue.PartiallyExpanded)) {
                v4_1 = SheetValue.PartiallyExpanded;
            }
            else if(v5.hasAnchorFor(SheetValue.Expanded)) {
                v4_1 = SheetValue.Expanded;
            }
            else if(v5.hasAnchorFor(SheetValue.Hidden)) {
                v4_1 = SheetValue.Hidden;
            }
        }
        else if(v5.hasAnchorFor(SheetValue.Hidden)) {
            v4_1 = SheetValue.Hidden;
        }

        return TuplesKt.to(v5, v4_1);
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$13$lambda$12$lambda$11(SheetState arg2, float arg3, float arg4, float arg5, DraggableAnchorsConfig arg6) {
        if(!arg2.getSkipPartiallyExpanded$material3()) {
            arg6.at(SheetValue.PartiallyExpanded, arg3 - arg4);
        }

        if(arg5 == arg4) {
        }
        else {
            arg6.at(SheetValue.Expanded, Math.max(arg3 - arg5, 0f));
        }

        if(!arg2.getSkipHiddenState$material3()) {
            arg6.at(SheetValue.Hidden, arg3);
        }

        return Unit.INSTANCE;
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$14(SheetState arg17, float arg18, float arg19, boolean arg20, Shape arg21, long arg22, long arg24, float arg26, float arg27, Function2 arg28, Function3 arg29, int arg30, int arg31, Composer arg32, int arg33) {
        BottomSheetScaffoldKt.StandardBottomSheet-w7I5h1o(arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg26, arg27, arg28, arg29, arg32, RecomposeScopeImplKt.updateChangedFlags(arg30 | 1), RecomposeScopeImplKt.updateChangedFlags(arg31));
        return Unit.INSTANCE;
    }

    static final Unit StandardBottomSheet_w7I5h1o$lambda$7$lambda$6(SheetState arg0, FiniteAnimationSpec arg1, FiniteAnimationSpec arg2, FiniteAnimationSpec arg3) {
        arg0.setShowMotionSpec$material3(arg1);
        arg0.setHideMotionSpec$material3(arg2);
        arg0.setAnchoredDraggableMotionSpec$material3(((AnimationSpec)arg3));
        return Unit.INSTANCE;
    }

    public static final void access$BottomSheetScaffoldLayout(Function2 arg0, Function2 arg1, Function2 arg2, Function2 arg3, Function0 arg4, SheetState arg5, Composer arg6, int arg7) {
        BottomSheetScaffoldKt.BottomSheetScaffoldLayout(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final void access$StandardBottomSheet-w7I5h1o(SheetState arg0, float arg1, float arg2, boolean arg3, Shape arg4, long arg5, long arg7, float arg9, float arg10, Function2 arg11, Function3 arg12, Composer arg13, int arg14, int arg15) {
        BottomSheetScaffoldKt.StandardBottomSheet-w7I5h1o(arg0, arg1, arg2, arg3, arg4, arg5, arg7, arg9, arg10, arg11, arg12, arg13, arg14, arg15);
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState arg8, SnackbarHostState arg9, Composer arg10, int arg11, int arg12) {
        BottomSheetScaffoldState v11_1;
        Object v9;
        Composer v5;
        int v1 = -1474606134;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberBottomSheetScaffoldState)N(bottomSheetState,snackbarHostState)189@9451L34,190@9530L32,192@9605L197:BottomSheetScaffold.kt#uh7d8r");
        if((arg12 & 1) != 0) {
            v5 = arg10;
            arg8 = BottomSheetScaffoldKt.rememberStandardBottomSheetState(null, null, false, v5, 0, 7);
        }
        else {
            v5 = arg10;
        }

        int v10 = arg12 & 2;
        String v12 = "CC(remember):BottomSheetScaffold.kt#9igjgp";
        if(v10 != 0) {
            ComposerKt.sourceInformationMarkerStart(v5, 242719018, v12);
            v9 = v5.rememberedValue();
            if(v9 == Composer.Companion.getEmpty()) {
                arg9 = new SnackbarHostState();
                v5.updateRememberedValue(arg9);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }

        ComposerKt.sourceInformationMarkerStart(v5, 0xE77A32F, v12);
        arg12 = 0;
        int v0 = 4;
        v10 = (arg11 & 14 ^ 6) > v0 && (v5.changed(arg8)) || (arg11 & 6) == v0 ? 1 : 0;
        int v2 = 0x20;
        if((arg11 & 0x70 ^ 0x30) > v2 && (v5.changed(v9)) || (arg11 & 0x30) == v2) {
            arg12 = 1;
        }

        Object v11 = v5.rememberedValue();
        if((v10 | arg12) != 0 || v11 == Composer.Companion.getEmpty()) {
            v11_1 = new BottomSheetScaffoldState(arg8, ((SnackbarHostState)v9));
            v5.updateRememberedValue(v11_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v5);
        return v11_1;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue arg9, Function1 arg10, boolean arg11, Composer arg12, int arg13, int arg14) {
        Object v3;
        int v2 = 0x287143DD;
        ComposerKt.sourceInformationMarkerStart(arg12, v2, "C(rememberStandardBottomSheetState)N(initialValue,confirmValueChange,skipHiddenState)212@10383L8,215@10438L154:BottomSheetScaffold.kt#uh7d8r");
        SheetValue v1 = (arg14 & 1) != 0 ? SheetValue.PartiallyExpanded : arg9;
        if((arg14 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg12, 0xD12FD6A5, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            v3 = arg12.rememberedValue();
            if(v3 == Composer.Companion.getEmpty()) {
                BottomSheetScaffoldKt$$ExternalSyntheticLambda6 v3_1 = new BottomSheetScaffoldKt$$ExternalSyntheticLambda6();
                arg12.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg12);
        }
        else {
            Function1 v3_2 = arg10;
        }

        boolean v4 = (arg14 & 4) != 0 ? true : arg11;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg13, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:215)");
        }

        SheetState v0 = SheetDefaultsKt.rememberSheetState-AGcomas(false, v3, v1, v4, 0f, 0f, arg12, arg13 & 0x70 | arg13 << 6 & 0x380 | arg13 << 3 & 0x1C00, 49);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v0;
    }

    static final boolean rememberStandardBottomSheetState$lambda$5$lambda$4(SheetValue arg0) {
        return 1;
    }

    public static final Modifier verticalScaleDown(Modifier arg1, SheetState arg2) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new BottomSheetScaffoldKt$$ExternalSyntheticLambda0(arg2));
    }

    static final Unit verticalScaleDown$lambda$18(SheetState arg7, GraphicsLayerScope arg8) {
        float v0 = arg7.getAnchoredDraggableState$material3().getOffset();
        float v7 = arg7.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        if(Float.compare(v0, v7) < 0) {
            v7 -= v0;
        }
        else {
            v7 = 0f;
        }

        float v1 = 1f;
        if(Float.compare(v7, 0f) > 0) {
            v1 /= (Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() & 0xFFFFFFFFL))) + v7) / Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() & 0xFFFFFFFFL)));
        }

        arg8.setScaleY(v1);
        arg8.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0f));
        return Unit.INSTANCE;
    }

    public static final Modifier verticalScaleUp(Modifier arg1, SheetState arg2) {
        return GraphicsLayerModifierKt.graphicsLayer(arg1, new BottomSheetScaffoldKt$$ExternalSyntheticLambda5(arg2));
    }

    static final Unit verticalScaleUp$lambda$17(SheetState arg7, GraphicsLayerScope arg8) {
        float v0 = arg7.getAnchoredDraggableState$material3().getOffset();
        float v7 = arg7.getAnchoredDraggableState$material3().getAnchors().minAnchor();
        if(Float.compare(v0, v7) < 0) {
            v7 -= v0;
        }
        else {
            v7 = 0f;
        }

        v0 = v7 > 0f ? (Float.intBitsToFloat(((int)(arg8.getSize-NH-jbRc() & 0xFFFFFFFFL))) + v7) / Float.intBitsToFloat(((int)(0xFFFFFFFFL & arg8.getSize-NH-jbRc()))) : 1f;
        arg8.setScaleY(v0);
        arg8.setTransformOrigin-__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, 0f));
        return Unit.INSTANCE;
    }
}

