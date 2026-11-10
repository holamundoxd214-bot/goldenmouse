package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\u001A\u007F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001E\b\u0002\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u00102\u001C\u0010\u0011\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0012\u001AC\u0010\u0013\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0014\u001A\u00020\u00032\b\b\u0002\u0010\u0015\u001A\u00020\u00162\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018\u001A\r\u0010\u0019\u001A\u00020\tH\u0007¢\u0006\u0002\u0010\u001A\u001A\b\u0010\u001B\u001A\u00020\tH\u0007\u001A\u001F\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020 H\u0003¢\u0006\u0004\b!\u0010\"\u001A;\u0010#\u001A\u00020\u0001*\u00020$2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u0016H\u0002¢\u0006\u0004\b,\u0010-\u001A\u0010\u0010.\u001A\u00020(2\u0006\u0010\u001D\u001A\u00020&H\u0002\u001AC\u0010/\u001A\u00020\u0001*\u00020$2\u0006\u00100\u001A\u0002012\u0006\u00102\u001A\u00020*2\u0006\u0010\u001F\u001A\u00020 2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(2\u0006\u0010+\u001A\u00020\u0016H\u0002¢\u0006\u0004\b3\u00104\"\u000E\u00105\u001A\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00106\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u00108\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0016\u00109\u001A\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001A\u0004\b:\u0010;\"\u0016\u0010<\u001A\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u00107\u001A\u0004\b=\u0010;\"\u0010\u0010>\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u0010\u0010?\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00107\"\u000E\u0010@\u001A\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010A\u001A\u00020&X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010B\u001A\u00020&X\u0082T¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010D\u001A\u00020&X\u008A\u0084\u0002"}, d2={"PullToRefreshBox", "", "isRefreshing", "", "onRefresh", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "pullToRefresh", "enabled", "threshold", "Landroidx/compose/ui/unit/Dp;", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "PullToRefreshState", "CircularArrowProgressIndicator", "progress", "Landroidx/compose/material3/internal/FloatProducer;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Landroidx/compose/material3/internal/FloatProducer;JLandroidx/compose/runtime/Composer;I)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "alpha", "", "values", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "arcBounds", "Landroidx/compose/ui/geometry/Rect;", "strokeWidth", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "ArrowValues", "drawArrow", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "MaxProgressArc", "StrokeWidth", "F", "ArcRadius", "SpinnerSize", "getSpinnerSize", "()F", "SpinnerContainerSize", "getSpinnerContainerSize", "ArrowWidth", "ArrowHeight", "MinAlpha", "MaxAlpha", "DragMultiplier", "material3", "targetAlpha"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PullToRefreshKt {
    private static final float ArcRadius = 0f;
    private static final float ArrowHeight = 0f;
    private static final float ArrowWidth = 0f;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float SpinnerContainerSize;
    private static final float SpinnerSize;
    private static final float StrokeWidth;

    static {
        PullToRefreshKt.StrokeWidth = Dp.constructor-impl(2.5f);
        PullToRefreshKt.ArcRadius = Dp.constructor-impl(5.5f);
        PullToRefreshKt.SpinnerSize = Dp.constructor-impl(16f);
        PullToRefreshKt.SpinnerContainerSize = Dp.constructor-impl(40f);
        PullToRefreshKt.ArrowWidth = Dp.constructor-impl(10f);
        PullToRefreshKt.ArrowHeight = Dp.constructor-impl(5f);
    }

    private static final ArrowValues ArrowValues(float arg7) {
        float v1 = Math.max(Math.min(1f, arg7) - 0.4f, 0f) * 5f / 3f;
        arg7 = RangesKt.coerceIn(Math.abs(arg7) - 1f, 0f, 2f);
        float v2 = (0.4f * v1 - 0.25f + (arg7 - (((float)Math.pow(((double)arg7), 2))) / 4f)) * 0.5f;
        return new ArrowValues(v2, v2 * 360f, (0.8f * v1 + v2) * 360f, Math.min(1f, v1));
    }

    private static final void CircularArrowProgressIndicator-RPmYEkk(FloatProducer arg19, long arg20, Composer arg22, int arg23) {
        PullToRefreshKt$$ExternalSyntheticLambda2 v5_2;
        PullToRefreshKt$$ExternalSyntheticLambda1 v11_1;
        int v10;
        State v8_1;
        Path v0_2;
        int v2_1;
        FloatProducer v1 = arg19;
        long v3 = arg20;
        int v6 = arg23;
        int v0 = 0xAF52451C;
        Composer v12 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(CircularArrowProgressIndicator)N(progress,color:c#ui.graphics.Color)632@23995L61,634@24157L76,639@24460L7,637@24335L143,644@24553L175,650@24770L443,642@24484L729:PullToRefresh.kt#djiw08");
        int v5 = 4;
        if((v6 & 6) == 0) {
            boolean v2 = (v6 & 8) == 0 ? v12.changed(v1) : v12.changedInstance(v1);
            v2_1 = v2 ? v5 : 2;
            v2_1 |= v6;
        }
        else {
            v2_1 = v6;
        }

        if((v6 & 0x30) == 0) {
            int v7 = v12.changed(v3) ? 0x20 : 16;
            v2_1 |= v7;
        }

        int v16 = 1;
        boolean v7_1 = (v2_1 & 19) != 18 ? true : false;
        if(v12.shouldExecute(v7_1, v2_1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2_1, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:631)");
            }

            String v7_2 = "CC(remember):PullToRefresh.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v12, 601193529, v7_2);
            Object v0_1 = v12.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_2 = AndroidPath_androidKt.Path();
                v0_2.setFillType-oQ8Xj4U(PathFillType.Companion.getEvenOdd-Rg-k1Os());
                v12.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            ComposerKt.sourceInformationMarkerStart(v12, 0x23D59088, v7_2);
            Object v8 = v12.rememberedValue();
            if(v8 == Composer.Companion.getEmpty()) {
                v8_1 = SnapshotStateKt.derivedStateOf(new PullToRefreshKt$$ExternalSyntheticLambda0(v1));
                v12.updateRememberedValue(v8_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            String v15 = v7_2;
            State v7_3 = AnimateAsStateKt.animateFloatAsState(PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$8(v8_1), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v12, 6), 0f, null, null, v12, 0, 28);
            Companion v8_2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v12, 601211499, v15);
            int v9 = v2_1 & 14;
            if(v9 != v5) {
                if((v2_1 & 8) != 0 && (v12.changedInstance(v1))) {
                    goto label_99;
                }

                v10 = 0;
            }
            else {
            label_99:
                v10 = 1;
            }

            Object v11 = v12.rememberedValue();
            if(v10 != 0 || v11 == Composer.Companion.getEmpty()) {
                v11_1 = new PullToRefreshKt$$ExternalSyntheticLambda1(v1);
                v12.updateRememberedValue(v11_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            Modifier v8_3 = SizeKt.size-3ABfNKs(SemanticsModifierKt.clearAndSetSemantics(((Modifier)v8_2), ((Function1)v11_1)), PullToRefreshKt.SpinnerSize);
            ComposerKt.sourceInformationMarkerStart(v12, 601218711, v15);
            if(v9 != v5) {
                if((v2_1 & 8) != 0 && (v12.changedInstance(v1))) {
                    goto label_122;
                }

                v9 = 0;
            }
            else {
            label_122:
                v9 = 1;
            }

            v5 = v12.changed(v7_3) | v9;
            if((v2_1 & 0x70) == 0x20) {
            }
            else {
                v16 = 0;
            }

            v2_1 = v5 | v16 | v12.changedInstance(v0_2);
            Object v5_1 = v12.rememberedValue();
            if(v2_1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                PullToRefreshKt$$ExternalSyntheticLambda2 v0_3 = new PullToRefreshKt$$ExternalSyntheticLambda2(v1, v7_3, v3, v0_2);
                v12.updateRememberedValue(v0_3);
                v5_2 = v0_3;
            }

            ComposerKt.sourceInformationMarkerEnd(v12);
            CanvasKt.Canvas(v8_3, ((Function1)v5_2), v12, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_152;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12.skipToGroupEnd();
        }

    label_152:
        ScopeUpdateScope v0_4 = v12.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new PullToRefreshKt$$ExternalSyntheticLambda3(v1, v3, v6));
        }
    }

    static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$10$lambda$9(FloatProducer arg3, SemanticsPropertyReceiver arg4) {
        if(arg3.invoke() > 0f) {
            SemanticsPropertiesKt.setProgressBarRangeInfo(arg4, new ProgressBarRangeInfo(arg3.invoke(), RangesKt.rangeTo(0f, 1f), 0));
        }

        return Unit.INSTANCE;
    }

    static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$13$lambda$12(FloatProducer arg10, State arg11, long arg12, Path arg14, DrawScope arg15) {
        ArrowValues v4 = PullToRefreshKt.ArrowValues(arg10.invoke());
        float v3 = arg11.getValue().floatValue();
        float v10 = v4.getRotation();
        long v1 = arg15.getCenter-F1C5BW0();
        DrawContext v11 = arg15.getDrawContext();
        long v8 = v11.getSize-NH-jbRc();
        v11.getCanvas().save();
        try {
            v11.getTransform().rotate-Uv8p0NA(v10, v1);
            v10 = arg15.toPx-0680j_4(PullToRefreshKt.ArcRadius);
            float v6 = PullToRefreshKt.StrokeWidth;
            Rect v5 = RectKt.Rect-3MmeM6k(androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk(arg15.getSize-NH-jbRc()), v10 + arg15.toPx-0680j_4(v6) / 2f);
            PullToRefreshKt.drawCircularIndicator-KzyDr3Q(arg15, arg12, v3, v4, v5, v6);
            PullToRefreshKt.drawArrow-uDrxG_w(arg15, arg14, v5, arg12, v3, v4, v6);
        }
        catch(Throwable v0) {
            v11.getCanvas().restore();
            v11.setSize-uvyYCjk(v8);
            throw v0;
        }

        v11.getCanvas().restore();
        v11.setSize-uvyYCjk(v8);
        return Unit.INSTANCE;
    }

    static final Unit CircularArrowProgressIndicator_RPmYEkk$lambda$14(FloatProducer arg0, long arg1, int arg3, Composer arg4, int arg5) {
        PullToRefreshKt.CircularArrowProgressIndicator-RPmYEkk(arg0, arg1, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final float CircularArrowProgressIndicator_RPmYEkk$lambda$7$lambda$6(FloatProducer arg1) {
        float v0 = 1f;
        if(arg1.invoke() >= v0) {
            return v0;
        }

        return 0.3f;
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$8(State arg0) {
        return arg0.getValue().floatValue();
    }

    public static final void PullToRefreshBox(boolean arg16, Function0 arg17, Modifier arg18, PullToRefreshState arg19, Alignment arg20, Function3 arg21, Function3 arg22, Composer arg23, int arg24, int arg25) {
        PullToRefreshState v4_3;
        Modifier v3_1;
        PullToRefreshState v2_1;
        Modifier v0;
        ComposableLambda v13_2;
        int v14;
        Function3 v13_1;
        int v12;
        Alignment v11;
        int v7;
        PullToRefreshState v6_1;
        Modifier v4;
        int v3;
        Function0 v5;
        int v2;
        boolean v1 = arg16;
        Function3 v8 = arg22;
        int v9 = arg24;
        Composer v10 = arg23.startRestartGroup(0xE0453ED9);
        ComposerKt.sourceInformation(v10, "C(PullToRefreshBox)N(isRefreshing,onRefresh,modifier,state,contentAlignment,indicator,content)134@6006L200:PullToRefresh.kt#djiw08");
        if((arg25 & 1) != 0) {
            v2 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v2 = v10.changed(v1) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        if((arg25 & 2) != 0) {
            v2 |= 0x30;
            v5 = arg17;
        }
        else {
            v5 = arg17;
            if((v9 & 0x30) == 0) {
                v3 = v10.changedInstance(v5) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg25 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v9 & 0x180) == 0) {
            v4 = arg18;
            int v6 = v10.changed(v4) ? 0x100 : 0x80;
            v2 |= v6;
        }
        else {
        label_50:
            v4 = arg18;
        }

        if((v9 & 0xC00) == 0) {
            if((arg25 & 8) == 0) {
                v6_1 = arg19;
                if(v10.changed(v6_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v6_1 = arg19;
            label_61:
                v7 = 0x400;
            }

            v2 |= v7;
        }
        else {
            v6_1 = arg19;
        }

        v7 = arg25 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v9 & 0x6000) == 0) {
            v11 = arg20;
            v12 = v10.changed(v11) ? 0x4000 : 0x2000;
            v2 |= v12;
        }
        else {
        label_79:
            v11 = arg20;
        }

        v12 = arg25 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v2 |= v13;
            goto label_95;
        }
        else if((v13 & v9) == 0) {
            v13_1 = arg21;
            v14 = v10.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v2 |= v14;
        }
        else {
        label_95:
            v13_1 = arg21;
        }

        int v15 = 0x180000;
        if((arg25 & 0x40) != 0) {
            v2 |= v15;
        }
        else if((v9 & v15) == 0) {
            v14 = v10.changedInstance(v8) ? 0x100000 : 0x80000;
            v2 |= v14;
        }

        int v23 = v3;
        boolean v14_1 = (0x92493 & v2) != 0x92492 ? true : false;
        if(v10.shouldExecute(v14_1, v2 & 1)) {
            v10.startDefaults();
            ComposerKt.sourceInformation(v10, "123@5653L28,125@5786L164");
            if((v9 & 1) == 0 || (v10.getDefaultsInvalid())) {
                if(v23 != 0) {
                    Companion v4_1 = Modifier.Companion;
                }

                if((arg25 & 8) != 0) {
                    v6_1 = PullToRefreshKt.rememberPullToRefreshState(v10, 0);
                    v2 &= 0xFFFFE3FF;
                }

                Alignment v7_1 = v7 != 0 ? Alignment.Companion.getTopStart() : v11;
                if(v12 != 0) {
                    v13_2 = ComposableLambdaKt.rememberComposableLambda(1028036671, true, new PullToRefreshKt$PullToRefreshBox$1(v6_1, v1), v10, 54);
                }

                v12 = v2;
                v0 = v4;
                v2_1 = v6_1;
                v11 = v7_1;
            }
            else {
                v10.skipToGroupEnd();
                if((arg25 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v12 = v2;
                v0 = v4;
                v2_1 = v6_1;
            }

            v10.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xE0453ED9, v12, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:133)");
            }

            v3_1 = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(v0, v1, v2_1, false, 0f, v5, 12, null);
            ComposerKt.sourceInformationMarkerStart(v10, 0x2BB5B5D7, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy v1_1 = BoxKt.maybeCachedBoxMeasurePolicy(v11, false);
            ComposerKt.sourceInformationMarkerStart(v10, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int v4_2 = ComposablesKt.getCurrentCompositeKeyHash(v10, 0);
            CompositionLocalMap v5_1 = v10.getCurrentCompositionLocalMap();
            v3_1 = ComposedModifierKt.materializeModifier(v10, v3_1);
            Function0 v6_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v10, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(v10.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v10.startReusableNode();
            if(v10.getInserting()) {
                v10.createNode(v6_2);
            }
            else {
                v10.useNode();
            }

            Composer v6_3 = Updater.constructor-impl(v10);
            Updater.set-impl(v6_3, v1_1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_3, v5_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v1_2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v6_3.getInserting()) || !Intrinsics.areEqual(v6_3.rememberedValue(), Integer.valueOf(v4_2))) {
                v6_3.updateRememberedValue(Integer.valueOf(v4_2));
                v6_3.apply(Integer.valueOf(v4_2), v1_2);
            }

            Updater.set-impl(v6_3, v3_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v10, 0x800B7D29, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance v1_3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v10, 0x5EC42953, "C138@6171L9,139@6189L11:PullToRefresh.kt#djiw08");
            v8.invoke(v1_3, v10, Integer.valueOf(v12 >> 15 & 0x70 | 6));
            ((Function3)v13_2).invoke(v1_3, v10, Integer.valueOf(v12 >> 12 & 0x70 | 6));
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerEnd(v10);
            v10.endNode();
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerEnd(v10);
            ComposerKt.sourceInformationMarkerEnd(v10);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v0;
            v4_3 = v2_1;
        }
        else {
            v10.skipToGroupEnd();
            v3_1 = v4;
            v4_3 = v6_1;
        }

        Alignment v5_2 = v11;
        Function3 v6_4 = ((Function3)v13_2);
        ScopeUpdateScope v10_1 = v10.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new PullToRefreshKt$$ExternalSyntheticLambda4(arg16, arg17, v3_1, v4_3, v5_2, v6_4, v8, v9, arg25));
        }
    }

    static final Unit PullToRefreshBox$lambda$1(boolean arg11, Function0 arg12, Modifier arg13, PullToRefreshState arg14, Alignment arg15, Function3 arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        PullToRefreshKt.PullToRefreshBox(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final PullToRefreshState PullToRefreshState() {
        return new PullToRefreshStateImpl();
    }

    public static final void access$CircularArrowProgressIndicator-RPmYEkk(FloatProducer arg0, long arg1, Composer arg3, int arg4) {
        PullToRefreshKt.CircularArrowProgressIndicator-RPmYEkk(arg0, arg1, arg3, arg4);
    }

    public static final float access$getStrokeWidth$p() {
        return PullToRefreshKt.StrokeWidth;
    }

    private static final void drawArrow-uDrxG_w(DrawScope arg21, Path arg22, Rect arg23, long arg24, float arg26, ArrowValues arg27, float arg28) {
        DrawScope v0 = arg21;
        Path v1 = arg22;
        float v2 = arg28;
        v1.reset();
        v1.moveTo(0f, 0f);
        float v4 = PullToRefreshKt.ArrowWidth;
        v1.lineTo(v0.toPx-0680j_4(v4) * arg27.getScale() / 2f, v0.toPx-0680j_4(PullToRefreshKt.ArrowHeight) * arg27.getScale());
        v1.lineTo(v0.toPx-0680j_4(v4) * arg27.getScale(), 0f);
        v1.translate-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(arg23.getCenter-F1C5BW0() & 0xFFFFFFFFL))) - v0.toPx-0680j_4(v2)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Math.min(arg23.getRight() - arg23.getLeft(), arg23.getBottom() - arg23.getTop()) / 2f + Float.intBitsToFloat(((int)(arg23.getCenter-F1C5BW0() >> 0x20))) - v0.toPx-0680j_4(v4) * arg27.getScale() / 2f))) << 0x20));
        float v3 = arg27.getEndAngle() - v0.toPx-0680j_4(v2);
        long v4_1 = v0.getCenter-F1C5BW0();
        DrawContext v10 = v0.getDrawContext();
        long v11 = v10.getSize-NH-jbRc();
        v10.getCanvas().save();
        try {
            v10.getTransform().rotate-Uv8p0NA(v3, v4_1);
            DrawScope.drawPath-LG529CI$default(v0, v1, arg24, arg26, new Stroke(v0.toPx-0680j_4(v2), 0f, 0, 0, null, 30, null), null, 0, 0x30, null);
        }
        catch(Throwable v0_1) {
            v10.getCanvas().restore();
            v10.setSize-uvyYCjk(v11);
            throw v0_1;
        }

        v10.getCanvas().restore();
        v10.setSize-uvyYCjk(v11);
    }

    private static final void drawCircularIndicator-KzyDr3Q(DrawScope arg18, long arg19, float arg21, ArrowValues arg22, Rect arg23, float arg24) {
        DrawScope.drawArc-yD3GUKo$default(arg18, arg19, arg22.getStartAngle(), arg22.getEndAngle() - arg22.getStartAngle(), false, arg23.getTopLeft-F1C5BW0(), arg23.getSize-NH-jbRc(), arg21, new Stroke(arg18.toPx-0680j_4(arg24), 0f, StrokeCap.Companion.getButt-KaPHkGw(), 0, null, 26, null), null, 0, 0x300, null);
    }

    public static final float getSpinnerContainerSize() {
        return PullToRefreshKt.SpinnerContainerSize;
    }

    public static final float getSpinnerSize() {
        return PullToRefreshKt.SpinnerSize;
    }

    public static final Modifier pullToRefresh-Z4HSEVQ(Modifier arg7, boolean arg8, PullToRefreshState arg9, boolean arg10, float arg11, Function0 arg12) {
        return arg7.then(new PullToRefreshElement(arg8, arg12, arg10, arg9, arg11, null));
    }

    public static Modifier pullToRefresh-Z4HSEVQ$default(Modifier arg6, boolean arg7, PullToRefreshState arg8, boolean arg9, float arg10, Function0 arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = PullToRefreshDefaults.INSTANCE.getPositionalThreshold-D9Ej5fM();
        }

        return PullToRefreshKt.pullToRefresh-Z4HSEVQ(arg6, arg7, arg8, true, arg10, arg11);
    }

    public static final PullToRefreshState rememberPullToRefreshState(Composer arg3, int arg4) {
        int v1 = 318623070;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(rememberPullToRefreshState)586@22650L28,586@22595L83:PullToRefresh.kt#djiw08");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:585)");
        }

        Object[] v4 = new Object[0];
        Saver v0 = PullToRefreshStateImpl.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x4ABFFE9A, "CC(remember):PullToRefresh.kt#9igjgp");
        Object v1_1 = arg3.rememberedValue();
        if(v1_1 == Composer.Companion.getEmpty()) {
            PullToRefreshKt$$ExternalSyntheticLambda5 v1_2 = new PullToRefreshKt$$ExternalSyntheticLambda5();
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        Object v4_1 = RememberSaveableKt.rememberSaveable(v4, v0, ((Function0)v1_1), arg3, 0x180);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return ((PullToRefreshState)v4_1);
    }

    static final PullToRefreshStateImpl rememberPullToRefreshState$lambda$3$lambda$2() {
        return new PullToRefreshStateImpl();
    }
}

