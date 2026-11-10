package androidx.compose.animation;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0082\u0001\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042*\b\n\u0010\u0005\u001A$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2&\u0010\r\u001A\"\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u000E\u0012\b\b\u000F\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\b\tH\u0087\b¢\u0006\u0002\u0010\u0011\u001AA\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00022\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00020\u00162\b\b\u0002\u0010\u000B\u001A\u00020\fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u00022\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2={"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "label", "", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TransitionKt {
    public static final State animateColor(Transition arg16, Function3 arg17, String arg18, Function3 arg19, Composer arg20, int arg21, int arg22) {
        State v9_1;
        Object v15;
        Object v12;
        TransitionKt$animateColor$1 v2;
        Transition v0 = arg16;
        Function3 v1 = arg19;
        Composer v6 = arg20;
        ComposerKt.sourceInformationMarkerStart(v6, 0xFC28D121, "CC(animateColor)P(2)67@3230L31,68@3297L58,70@3368L70:Transition.kt#xbi5r1");
        if((arg22 & 1) != 0) {
            v2 = TransitionKt$animateColor$1.INSTANCE;
        }
        else {
            Function3 v2_1 = arg17;
        }

        String v5 = (arg22 & 2) != 0 ? "ColorAnimation" : arg18;
        ColorSpace v3 = Color.getColorSpace-impl(v1.invoke(v0.getTargetState(), v6, Integer.valueOf(arg21 >> 6 & 0x70)).unbox-impl());
        String v7 = "CC(remember):Transition.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v6, 0x95393A7B, v7);
        boolean v4 = v6.changed(v3);
        Object v8 = v6.rememberedValue();
        if((v4) || v8 == Composer.Companion.getEmpty()) {
            v8 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v3);
            v6.updateRememberedValue(v8);
        }

        Object v4_1 = v8;
        ComposerKt.sourceInformationMarkerEnd(v6);
        int v8_1 = arg21 << 3;
        int v3_1 = arg21 & 14 | v8_1 & 0x380 | v8_1 & 0x1C00 | v8_1 & 0xE000;
        ComposerKt.sourceInformationMarkerStart(v6, 0x442155F1, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1848@78638L32,1855@79111L49,1855@79092L75,1856@79207L45,1856@79192L67,1858@79272L89:Transition.kt#pdpnli");
        int v10 = 4;
        if(!v0.isSeeking()) {
            v6.startReplaceGroup(0x6355E4B0);
            ComposerKt.sourceInformation(v6, "1844@78495L67");
            ComposerKt.sourceInformationMarkerStart(v6, -1054612652, v7);
            v8_1 = (v3_1 & 14 ^ 6) > v10 && (v6.changed(v0)) || (v3_1 & 6) == v10 ? 1 : 0;
            v12 = v6.rememberedValue();
            if(v8_1 != 0 || v12 == Composer.Companion.getEmpty()) {
                Companion v8_2 = Snapshot.Companion;
                Snapshot v12_1 = v8_2.getCurrentThreadSnapshot();
                Function1 v13 = v12_1 != null ? v12_1.getReadObserver() : null;
                Snapshot v14 = v8_2.makeCurrentNonObservable(v12_1);
                try {
                    v15 = v0.getCurrentState();
                }
                catch(Throwable v0_1) {
                    v8_2.restoreNonObservable(v12_1, v14, v13);
                    throw v0_1;
                }

                v8_2.restoreNonObservable(v12_1, v14, v13);
                v6.updateRememberedValue(v15);
                v12 = v15;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            v6.endReplaceGroup();
        }
        else {
            v6.startReplaceGroup(0x6359C50D);
            v6.endReplaceGroup();
            v12 = v0.getCurrentState();
        }

        v8_1 = v3_1 >> 9 & 0x70;
        v12 = v1.invoke(v12, v6, Integer.valueOf(v8_1));
        ComposerKt.sourceInformationMarkerStart(v6, 0xC1243042, v7);
        int v13_1 = v3_1 & 14;
        int v14_1 = v13_1 ^ 6;
        int v15_1 = v14_1 > v10 && (v6.changed(v0)) || (v3_1 & 6) == v10 ? 1 : 0;
        Object v9 = v6.rememberedValue();
        if(v15_1 != 0 || v9 == Composer.Companion.getEmpty()) {
            v9_1 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateColor$$inlined$animateValue$1(v0));
            v6.updateRememberedValue(v9_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Object v1_1 = v1.invoke(v9_1.getValue(), v6, Integer.valueOf(v8_1));
        ComposerKt.sourceInformationMarkerStart(v6, -1054589890, v7);
        int v9_2 = v14_1 > v10 && (v6.changed(v0)) || (v3_1 & 6) == v10 ? 1 : 0;
        Object v7_1 = v6.rememberedValue();
        if(v9_2 != 0 || v7_1 == Composer.Companion.getEmpty()) {
            State v7_2 = SnapshotStateKt.derivedStateOf(new TransitionKt$animateColor$$inlined$animateValue$2(v0));
            v6.updateRememberedValue(v7_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        State v0_2 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(v0, v12, v1_1, ((Function3)v2).invoke(((State)v7_1).getValue(), v6, Integer.valueOf(v3_1 >> 3 & 0x70)), ((TwoWayConverter)v4_1), v5, v6, v13_1 | v3_1 << 6 & 0x70000);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        ComposerKt.sourceInformationMarkerEnd(arg20);
        return v0_2;
    }

    public static final State animateColor-DTcfvLk(InfiniteTransition arg9, long arg10, long arg12, InfiniteRepeatableSpec arg14, String arg15, Composer arg16, int arg17, int arg18) {
        Composer v6 = arg16;
        int v0 = arg17;
        int v2 = 0x715DA90D;
        ComposerKt.sourceInformationMarkerStart(v6, v2, "C(animateColor)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color)98@4599L60,99@4671L72:Transition.kt#xbi5r1");
        if((arg18 & 8) != 0) {
            arg15 = "ColorAnimation";
        }

        String v5 = arg15;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.animateColor (Transition.kt:97)");
        }

        ComposerKt.sourceInformationMarkerStart(v6, -1869106039, "CC(remember):Transition.kt#9igjgp");
        Object v15 = v6.rememberedValue();
        if(v15 == Composer.Companion.getEmpty()) {
            v15 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.getColorSpace-impl(arg12));
            v6.updateRememberedValue(v15);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        Color v1 = Color.box-impl(arg10);
        int v11 = v0 << 3;
        State v9 = InfiniteTransitionKt.animateValue(arg9, v1, Color.box-impl(arg12), v15, arg14, v5, v6, InfiniteTransition.$stable | v0 & 14 | v0 & 0x70 | v0 & 0x380 | InfiniteRepeatableSpec.$stable << 12 | 0xE000 & v11 | v11 & 0x70000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg16);
        return v9;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="animateColor APIs now have a new label parameter added.") public static final State animateColor-RIQooxk(InfiniteTransition arg13, long arg14, long arg16, InfiniteRepeatableSpec arg18, Composer arg19, int arg20) {
        int v0 = arg20;
        int v2 = 1400583834;
        Composer v10 = arg19;
        ComposerKt.sourceInformationMarkerStart(v10, v2, "C(animateColor)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color)112@5044L164:Transition.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.animation.animateColor (Transition.kt:112)");
        }

        State v13 = TransitionKt.animateColor-DTcfvLk(arg13, arg14, arg16, arg18, "ColorAnimation", v10, InfiniteTransition.$stable | 0x6000 | v0 & 14 | v0 & 0x70 | v0 & 0x380 | InfiniteRepeatableSpec.$stable << 9 | v0 & 0x1C00, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg19);
        return v13;
    }
}

