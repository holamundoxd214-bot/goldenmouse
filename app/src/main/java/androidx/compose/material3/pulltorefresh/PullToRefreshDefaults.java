package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jo\u0010\u001F\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010(\u001A\u00020\u00152\u001C\u0010)\u001A\u0018\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020 0*¢\u0006\u0002\b,¢\u0006\u0002\b-H\u0007¢\u0006\u0004\b.\u0010/JG\u00100\u001A\u00020 2\u0006\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u00101\u001A\u00020\f2\b\b\u0002\u0010\'\u001A\u00020\u0015H\u0007¢\u0006\u0004\b2\u00103R\u001C\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\bR\u001A\u0010\u000B\u001A\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000FR\u0013\u0010\u0014\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0019\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u001A\u0010\u0017R\u0013\u0010\u001B\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u001C\u0010\u0017R\u0013\u0010\u001D\u001A\u00020\u0015¢\u0006\n\n\u0002\u0010\u0018\u001A\u0004\b\u001E\u0010\u0017¨\u00064"}, d2={"Landroidx/compose/material3/pulltorefresh/PullToRefreshDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape$annotations", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "indicatorShape", "getIndicatorShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "indicatorContainerColor", "getIndicatorContainerColor", "indicatorColor", "getIndicatorColor", "PositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "getPositionalThreshold-D9Ej5fM", "()F", "F", "IndicatorMaxDistance", "getIndicatorMaxDistance-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM", "LoadingIndicatorElevation", "getLoadingIndicatorElevation-D9Ej5fM", "IndicatorBox", "", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "modifier", "Landroidx/compose/ui/Modifier;", "maxDistance", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "IndicatorBox-1CPYgEU", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;JFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Indicator", "color", "Indicator-2poqoh4", "(Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZLandroidx/compose/ui/Modifier;JJFLandroidx/compose/runtime/Composer;II)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PullToRefreshDefaults {
    public static final int $stable;
    private static final float Elevation;
    public static final PullToRefreshDefaults INSTANCE;
    private static final float IndicatorMaxDistance;
    private static final float LoadingIndicatorElevation;
    private static final float PositionalThreshold;
    private static final Shape indicatorShape;
    private static final Shape shape;

    static {
        PullToRefreshDefaults.INSTANCE = new PullToRefreshDefaults();
        PullToRefreshDefaults.shape = RoundedCornerShapeKt.getCircleShape();
        PullToRefreshDefaults.indicatorShape = RoundedCornerShapeKt.getCircleShape();
        float v0 = Dp.constructor-impl(80f);
        PullToRefreshDefaults.PositionalThreshold = v0;
        PullToRefreshDefaults.IndicatorMaxDistance = v0;
        PullToRefreshDefaults.Elevation = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
        PullToRefreshDefaults.LoadingIndicatorElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
    }

    private PullToRefreshDefaults() {
        super();
    }

    public final void Indicator-2poqoh4(PullToRefreshState arg18, boolean arg19, Modifier arg20, long arg21, long arg23, float arg25, Composer arg26, int arg27, int arg28) {
        Modifier v4_2;
        long v5_3;
        float v4_1;
        int v8;
        long v14_2;
        long v6_1;
        Modifier v5_1;
        Companion v5_2;
        int v14;
        float v9_1;
        long v11;
        int v9;
        long v7_1;
        Modifier v6;
        int v5;
        int v4;
        PullToRefreshDefaults v0 = this;
        PullToRefreshState v1 = arg18;
        boolean v2 = arg19;
        int v13 = arg27;
        Composer v10 = arg26.startRestartGroup(0xBFD04390);
        ComposerKt.sourceInformation(v10, "C(Indicator)N(state,isRefreshing,modifier,containerColor:c#ui.graphics.Color,color:c#ui.graphics.Color,maxDistance:c#ui.unit.Dp)522@20382L755,516@20173L964:PullToRefresh.kt#djiw08");
        if((arg28 & 1) != 0) {
            v4 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v4 = v10.changed(v1) ? 4 : 2;
            v4 |= v13;
        }
        else {
            v4 = v13;
        }

        if((arg28 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v13 & 0x30) == 0) {
            v5 = v10.changed(v2) ? 0x20 : 16;
            v4 |= v5;
        }

        v5 = arg28 & 4;
        if(v5 != 0) {
            v4 |= 0x180;
            goto label_49;
        }
        else if((v13 & 0x180) == 0) {
            v6 = arg20;
            int v7 = v10.changed(v6) ? 0x100 : 0x80;
            v4 |= v7;
        }
        else {
        label_49:
            v6 = arg20;
        }

        if((v13 & 0xC00) == 0) {
            if((arg28 & 8) == 0) {
                v7_1 = arg21;
                if(v10.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_60;
                }
            }
            else {
                v7_1 = arg21;
            label_60:
                v9 = 0x400;
            }

            v4 |= v9;
        }
        else {
            v7_1 = arg21;
        }

        if((v13 & 0x6000) == 0) {
            v11 = arg23;
            v9 = (arg28 & 16) != 0 || !v10.changed(v11) ? 0x2000 : 0x4000;
            v4 |= v9;
        }
        else {
            v11 = arg23;
        }

        if((0x30000 & v13) == 0) {
            if((arg28 & 0x20) == 0) {
                v9_1 = arg25;
                if(v10.changed(v9_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_88;
                }
            }
            else {
                v9_1 = arg25;
            label_88:
                v14 = 0x10000;
            }

            v4 |= v14;
        }
        else {
            v9_1 = arg25;
        }

        int v15 = 0x180000;
        if((arg28 & 0x40) != 0) {
            v4 |= v15;
        }
        else if((v13 & v15) == 0) {
            v14 = v10.changed(v0) ? 0x100000 : 0x80000;
            v4 |= v14;
        }

        boolean v14_1 = (0x92493 & v4) != 0x92492 ? true : false;
        if(v10.shouldExecute(v14_1, v4 & 1)) {
            v10.startDefaults();
            ComposerKt.sourceInformation(v10, "512@20040L23,513@20093L14");
            v15 = 0xFFF8FFFF;
            int v16 = 0xFFFF1FFF;
            if((v13 & 1) == 0 || (v10.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v5_2 = Modifier.Companion;
                }
                else {
                    v5_1 = v6;
                }

                if((arg28 & 8) != 0) {
                    v6_1 = v0.getIndicatorContainerColor(v10, v4 >> 18 & 14);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v6_1 = v7_1;
                }

                if((arg28 & 16) != 0) {
                    v11 = v0.getIndicatorColor(v10, v4 >> 18 & 14);
                    v4 &= v16;
                }

                if((arg28 & 0x20) != 0) {
                    v8 = v4 & v15;
                    v4_1 = PullToRefreshDefaults.IndicatorMaxDistance;
                }
                else {
                    v8 = v4;
                    v4_1 = v9_1;
                }

                v14_2 = v11;
            }
            else {
                v10.skipToGroupEnd();
                if((arg28 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg28 & 16) != 0) {
                    v4 &= v16;
                }

                if((arg28 & 0x20) != 0) {
                    v4 &= v15;
                }

                v5_1 = v6;
                v6_1 = v7_1;
                v14_2 = v11;
                v8 = v4;
                v4_1 = v9_1;
            }

            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xBFD04390, v8, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator (PullToRefresh.kt:515)");
            }

            int v3 = v8 & 14 | 0xC00000 | v8 & 0x70 | v8 & 0x380 | v8 >> 6 & 0x1C00;
            v8 <<= 6;
            int v11_1 = v3 | 0x70000 & v8 | v8 & 0xE000000;
            Modifier v3_1 = ((Modifier)v5_2);
            v0.IndicatorBox-1CPYgEU(v1, v2, v3_1, v4_1, null, v6_1, 0f, ComposableLambdaKt.rememberComposableLambda(0x11C6AB49, true, new PullToRefreshDefaults$Indicator$1(v2, v14_2, v1), v10, 54), v10, v11_1, 80);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v4_1;
            v5_3 = v6_1;
            v7_1 = v14_2;
            v4_2 = v3_1;
        }
        else {
            v10.skipToGroupEnd();
            v4_2 = v6;
            v5_3 = v7_1;
            v7_1 = v11;
        }

        ScopeUpdateScope v12 = v10.endRestartGroup();
        if(v12 != null) {
            v12.updateScope(new PullToRefreshDefaults$$ExternalSyntheticLambda0(this, arg18, arg19, v4_2, v5_3, v7_1, v9_1, v13, arg28));
        }
    }

    public final void IndicatorBox-1CPYgEU(PullToRefreshState arg23, boolean arg24, Modifier arg25, float arg26, Shape arg27, long arg28, float arg30, Function3 arg31, Composer arg32, int arg33, int arg34) {
        Shape v6_1;
        PullToRefreshDefaults$$ExternalSyntheticLambda2 v3_1;
        Shape v0_1;
        Companion v8_1;
        float v15;
        long v13;
        int v16;
        int v14;
        float v9_1;
        Modifier v8;
        int v7;
        boolean v5;
        int v4;
        Function3 v10 = arg31;
        int v11 = arg33;
        int v12 = arg34;
        Composer v1 = arg32.startRestartGroup(0xB00FC257);
        ComposerKt.sourceInformation(v1, "C(IndicatorBox)N(state,isRefreshing,modifier,maxDistance:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)461@17782L372,471@18183L951,457@17644L1652:PullToRefresh.kt#djiw08");
        if((v12 & 1) != 0) {
            v4 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v4 = v1.changed(arg23) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        if((v12 & 2) != 0) {
            v4 |= 0x30;
            goto label_40;
        }
        else if((v11 & 0x30) == 0) {
            v5 = arg24;
            v7 = v1.changed(v5) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_40:
            v5 = arg24;
        }

        v7 = v12 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_55;
        }
        else if((v11 & 0x180) == 0) {
            v8 = arg25;
            int v9 = v1.changed(v8) ? 0x100 : 0x80;
            v4 |= v9;
        }
        else {
        label_55:
            v8 = arg25;
        }

        if((v11 & 0xC00) == 0) {
            if((v12 & 8) == 0) {
                v9_1 = arg26;
                if(v1.changed(v9_1)) {
                    v14 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v9_1 = arg26;
            label_66:
                v14 = 0x400;
            }

            v4 |= v14;
        }
        else {
            v9_1 = arg26;
        }

        if((v11 & 0x6000) == 0) {
            v16 = (v12 & 16) != 0 || !v1.changed(arg27) ? 0x2000 : 0x4000;
            v4 |= v16;
        }

        v16 = v12 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v4 |= v17;
            v13 = arg28;
        }
        else {
            v13 = arg28;
            if((v11 & v17) == 0) {
                v17 = v1.changed(v13) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = 0x180000;
        if((v11 & v17) == 0) {
            v15 = arg30;
            int v19 = (v12 & 0x40) != 0 || !v1.changed(v15) ? 0x80000 : 0x100000;
            v4 |= v19;
        }
        else {
            v15 = arg30;
        }

        int v20 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v4 |= v20;
        }
        else if((v11 & v20) == 0) {
            int v6 = v1.changedInstance(v10) ? 0x800000 : 0x400000;
            v4 |= v6;
        }

        if((v12 & 0x100) != 0) {
            v4 |= 0x6000000;
        }
        else if((0x6000000 & v11) == 0) {
            v20 = v1.changed(this) ? 0x4000000 : 0x2000000;
            v4 |= v20;
        }

        int v21 = 1;
        boolean v0 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v8_1 = Modifier.Companion;
                }

                if((v12 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                    v9_1 = PullToRefreshDefaults.IndicatorMaxDistance;
                }

                if((v12 & 16) != 0) {
                    v0_1 = PullToRefreshDefaults.indicatorShape;
                    v4 &= 0xFFFF1FFF;
                }
                else {
                    v0_1 = arg27;
                }

                if(v16 != 0) {
                    v13 = Color.Companion.getUnspecified-0d7_KjU();
                }

                if((v12 & 0x40) == 0) {
                    goto label_199;
                }

                v4 &= 0xFFC7FFFF;
                v15 = PullToRefreshDefaults.Elevation;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v4 &= 0xFFFF1FFF;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= 0xFFC7FFFF;
                }

                v0_1 = arg27;
            }

        label_199:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xB00FC257, v4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.IndicatorBox (PullToRefresh.kt:456)");
            }

            Modifier v2 = SizeKt.size-3ABfNKs(((Modifier)v8_1), PullToRefreshKt.getSpinnerContainerSize());
            ComposerKt.sourceInformationMarkerStart(v1, 0xEB28CA8B, "CC(remember):PullToRefresh.kt#9igjgp");
            Object v3 = v1.rememberedValue();
            if(v3 == Composer.Companion.getEmpty()) {
                v3_1 = new PullToRefreshDefaults$$ExternalSyntheticLambda2();
                v1.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2 = DrawModifierKt.drawWithContent(v2, ((Function1)v3_1));
            ComposerKt.sourceInformationMarkerStart(v1, 0xEB28FEEE, "CC(remember):PullToRefresh.kt#9igjgp");
            int v3_2 = (v4 & 14) == 4 ? 1 : 0;
            int v25 = v3_2;
            v3_2 = (v4 & 0x70) == 0x20 ? 1 : 0;
            v25 |= v3_2;
            v3_2 = 0x800;
            v3_2 = (v4 & 0x1C00 ^ 0xC00) > v3_2 && (v1.changed(v9_1)) || (v4 & 0xC00) == v3_2 ? 1 : 0;
            v25 |= v3_2;
            v3_2 = 0x100000;
            v3_2 = (0x380000 & v4 ^ v17) > v3_2 && (v1.changed(v15)) || (v4 & v17) == v3_2 ? 1 : 0;
            v25 |= v3_2;
            v3_2 = 0x4000;
            if((0xE000 & v4 ^ 0x6000) <= v3_2 || !v1.changed(v0_1)) {
                if((v4 & 0x6000) == v3_2) {
                }
                else {
                    v21 = 0;
                }
            }

            Object v7_1 = v1.rememberedValue();
            if((v25 | v21) != 0 || v7_1 == Composer.Companion.getEmpty()) {
                PullToRefreshDefaults$$ExternalSyntheticLambda3 v7_2 = new PullToRefreshDefaults$$ExternalSyntheticLambda3(arg23, v5, v9_1, v15, v0_1);
                v1.updateRememberedValue(v7_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v2 = BackgroundKt.background-bw27NRU(LayoutModifierKt.layout(v2, ((Function3)v7_1)), v13, v0_1);
            Alignment v3_3 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(v1, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v3_4 = BoxKt.maybeCachedBoxMeasurePolicy(v3_3, false);
            Shape v30 = v0_1;
            ComposerKt.sourceInformationMarkerStart(v1, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v0_2 = ComposablesKt.getCurrentCompositeKeyHash(v1, 0);
            CompositionLocalMap v5_1 = v1.getCurrentCompositionLocalMap();
            v2 = ComposedModifierKt.materializeModifier(v1, v2);
            Function0 v7_3 = ComposeUiNode.Companion.getConstructor();
            v25 = v0_2;
            int v26 = v4 >> 12 & 0x1C00 | 0x30;
            ComposerKt.sourceInformationMarkerStart(v1, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v1.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v1.startReusableNode();
            if(v1.getInserting()) {
                v1.createNode(v7_3);
            }
            else {
                v1.useNode();
            }

            Composer v0_3 = Updater.constructor-impl(v1);
            Updater.set-impl(v0_3, v3_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v0_3, v5_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v3_5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v0_3.getInserting()) || !Intrinsics.areEqual(v0_3.rememberedValue(), Integer.valueOf(v25))) {
                v0_3.updateRememberedValue(Integer.valueOf(v25));
                v0_3.apply(Integer.valueOf(v25), v3_5);
            }

            Updater.set-impl(v0_3, v2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v1, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            v10.invoke(BoxScopeInstance.INSTANCE, v1, Integer.valueOf(v26 >> 6 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v1);
            v1.endNode();
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerEnd(v1);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v30;
        }
        else {
            v1.skipToGroupEnd();
            v6_1 = arg27;
        }

        Modifier v4_1 = ((Modifier)v8_1);
        float v5_2 = v9_1;
        long v7_4 = v13;
        v9_1 = v15;
        ScopeUpdateScope v13_1 = v1.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new PullToRefreshDefaults$$ExternalSyntheticLambda4(this, arg23, arg24, v4_1, v5_2, v6_1, v7_4, v9_1, v10, v11, v12));
        }
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$2$lambda$1(ContentDrawScope arg10) {
        int v7 = ClipOp.Companion.getIntersect-rtfAjoo();
        DrawContext v1 = arg10.getDrawContext();
        long v8 = v1.getSize-NH-jbRc();
        v1.getCanvas().save();
        try {
            v1.getTransform().clipRect-N_I0leg(-3.402823E+38f, 0f, 3.402823E+38f, 3.402823E+38f, v7);
            arg10.drawContent();
        }
        catch(Throwable v0) {
            v1.getCanvas().restore();
            v1.setSize-uvyYCjk(v8);
            throw v0;
        }

        v1.getCanvas().restore();
        v1.setSize-uvyYCjk(v8);
        return Unit.INSTANCE;
    }

    static final MeasureResult IndicatorBox_1CPYgEU$lambda$6$lambda$5(PullToRefreshState arg11, boolean arg12, float arg13, float arg14, Shape arg15, MeasureScope arg16, Measurable arg17, Constraints arg18) {
        Placeable v3 = arg17.measure-BRTryo0(arg18.unbox-impl());
        return MeasureScope.layout$default(arg16, v3.getWidth(), v3.getHeight(), null, new PullToRefreshDefaults$$ExternalSyntheticLambda5(v3, arg11, arg12, arg13, arg14, arg15), 4, null);
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4(Placeable arg8, PullToRefreshState arg9, boolean arg10, float arg11, float arg12, Shape arg13, PlacementScope arg14) {
        PlacementScope.placeWithLayer$default(arg14, arg8, 0, 0, 0f, new PullToRefreshDefaults$$ExternalSyntheticLambda1(arg9, arg10, arg11, arg12, arg13), 4, null);
        return Unit.INSTANCE;
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$6$lambda$5$lambda$4$lambda$3(PullToRefreshState arg7, boolean arg8, float arg9, float arg10, Shape arg11, GraphicsLayerScope arg12) {
        float v1 = 0f;
        int v8 = Float.compare(arg7.getDistanceFraction(), 0f) > 0 || (arg8) ? 1 : 0;
        arg12.setTranslationY(arg7.getDistanceFraction() * (((float)arg12.roundToPx-0680j_4(arg9))) - Float.intBitsToFloat(((int)(arg12.getSize-NH-jbRc() & 0xFFFFFFFFL))));
        if(v8 != 0) {
            v1 = arg12.toPx-0680j_4(arg10);
        }

        arg12.setShadowElevation(v1);
        arg12.setShape(arg11);
        arg12.setClip(true);
        return Unit.INSTANCE;
    }

    static final Unit IndicatorBox_1CPYgEU$lambda$7(PullToRefreshDefaults arg14, PullToRefreshState arg15, boolean arg16, Modifier arg17, float arg18, Shape arg19, long arg20, float arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        arg14.IndicatorBox-1CPYgEU(arg15, arg16, arg17, arg18, arg19, arg20, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit Indicator_2poqoh4$lambda$8(PullToRefreshDefaults arg13, PullToRefreshState arg14, boolean arg15, Modifier arg16, long arg17, long arg19, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        arg13.Indicator-2poqoh4(arg14, arg15, arg16, arg17, arg19, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = 0x3F8DCE34;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)405@15435L11:PullToRefresh.kt#djiw08");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:405)");
        }

        long v0_1 = MaterialTheme.INSTANCE.getColorScheme(arg3, 6).getSurfaceContainerHigh-0d7_KjU();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(message="Use indicatorContainerColor instead", replaceWith="<_subannotation>") public static void getContainerColor$annotations() {
    }

    public final float getElevation-D9Ej5fM() {
        return PullToRefreshDefaults.Elevation;
    }

    public final long getIndicatorColor(Composer arg3, int arg4) {
        int v0 = 0xAA16FC74;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-indicatorColor>)413@15766L11:PullToRefresh.kt#djiw08");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:413)");
        }

        long v0_1 = MaterialTheme.INSTANCE.getColorScheme(arg3, 6).getOnSurfaceVariant-0d7_KjU();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getIndicatorContainerColor(Composer arg3, int arg4) {
        int v0 = -80510850;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-indicatorContainerColor>)409@15605L11:PullToRefresh.kt#djiw08");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorContainerColor> (PullToRefresh.kt:409)");
        }

        long v0_1 = MaterialTheme.INSTANCE.getColorScheme(arg3, 6).getSurfaceContainerHigh-0d7_KjU();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getIndicatorMaxDistance-D9Ej5fM() {
        return PullToRefreshDefaults.IndicatorMaxDistance;
    }

    public final Shape getIndicatorShape() {
        return PullToRefreshDefaults.indicatorShape;
    }

    public final float getLoadingIndicatorElevation-D9Ej5fM() {
        return PullToRefreshDefaults.LoadingIndicatorElevation;
    }

    public final float getPositionalThreshold-D9Ej5fM() {
        return PullToRefreshDefaults.PositionalThreshold;
    }

    public final Shape getShape() {
        return PullToRefreshDefaults.shape;
    }

    @Deprecated(message="Use indicatorShape instead", replaceWith="<_subannotation>") public static void getShape$annotations() {
    }
}

