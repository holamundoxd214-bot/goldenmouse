package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001AC\u0010\u000F\u001A\u00020\u0010*\u00020\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u00122\'\u0010\u0013\u001A#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0000\u001A!\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00040\u00192\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0003¢\u0006\u0002\u0010\u001B\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0016\u0010\u0007\u001A\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\t\"\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\fX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001C²\u0006\n\u0010\u0017\u001A\u00020\u0004X\u008A\u0084\u0002²\u0006\n\u0010\u001D\u001A\u00020\u0004X\u008A\u0084\u0002"}, d2={"UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Offset;", "getUnspecifiedSafeOffsetVectorConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "OffsetDisplacementThreshold", "getOffsetDisplacementThreshold", "()J", "J", "MagnifierSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getMagnifierSpringSpec", "()Landroidx/compose/animation/core/SpringSpec;", "animatedSelectionMagnifier", "Landroidx/compose/ui/Modifier;", "magnifierCenter", "Lkotlin/Function0;", "platformMagnifier", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animatedCenter", "rememberAnimatedMagnifierPosition", "Landroidx/compose/runtime/State;", "targetCalculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation", "targetValue"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SelectionMagnifierKt {
    private static final SpringSpec MagnifierSpringSpec;
    private static final long OffsetDisplacementThreshold;
    private static final AnimationVector2D UnspecifiedAnimationVector2D;
    private static final TwoWayConverter UnspecifiedSafeOffsetVectorConverter;

    public static Offset $r8$lambda$O5YDaFAAsyRvXThzqwro_LFBp0w(State arg0) {
        return SelectionMagnifierKt.animatedSelectionMagnifier$lambda$0$1$0(arg0);
    }

    static {
        SelectionMagnifierKt.UnspecifiedAnimationVector2D = new AnimationVector2D(NaNf, NaNf);
        SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(new SelectionMagnifierKt$$ExternalSyntheticLambda1(), new SelectionMagnifierKt$$ExternalSyntheticLambda2());
        long v0 = Offset.constructor-impl((((long)Float.floatToRawIntBits(0.01f))) << 0x20 | (((long)Float.floatToRawIntBits(0.01f))) & 0xFFFFFFFFL);
        SelectionMagnifierKt.OffsetDisplacementThreshold = v0;
        SelectionMagnifierKt.MagnifierSpringSpec = new SpringSpec(0f, 0f, Offset.box-impl(v0), 3, null);
    }

    static final AnimationVector2D UnspecifiedSafeOffsetVectorConverter$lambda$0(Offset arg6) {
        if((arg6.unbox-impl() & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L) {
            return new AnimationVector2D(Float.intBitsToFloat(((int)(arg6.unbox-impl() >> 0x20))), Float.intBitsToFloat(((int)(arg6.unbox-impl() & 0xFFFFFFFFL))));
        }

        return SelectionMagnifierKt.UnspecifiedAnimationVector2D;
    }

    static final Offset UnspecifiedSafeOffsetVectorConverter$lambda$1(AnimationVector2D arg6) {
        return Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(arg6.getV1()))) << 0x20 | (((long)Float.floatToRawIntBits(arg6.getV2()))) & 0xFFFFFFFFL));
    }

    public static final long access$rememberAnimatedMagnifierPosition$lambda$1(State arg2) {
        return SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1(arg2);
    }

    public static final Modifier animatedSelectionMagnifier(Modifier arg1, Function0 arg2, Function1 arg3) {
        return ComposedModifierKt.composed$default(arg1, null, new SelectionMagnifierKt$$ExternalSyntheticLambda3(arg2, arg3), 1, null);
    }

    static final Modifier animatedSelectionMagnifier$lambda$0(Function0 arg2, Function1 arg3, Modifier arg4, Composer arg5, int arg6) {
        int v4 = 0x2D4ACC1B;
        arg5.startReplaceGroup(v4);
        ComposerKt.sourceInformation(arg5, "C64@2538L70,65@2647L18:SelectionMagnifier.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, arg6, -1, "androidx.compose.foundation.text.selection.animatedSelectionMagnifier.<anonymous> (SelectionMagnifier.kt:64)");
        }

        State v2 = SelectionMagnifierKt.rememberAnimatedMagnifierPosition(arg2, arg5, 0);
        ComposerKt.sourceInformationMarkerStart(arg5, 97010317, "CC(remember):SelectionMagnifier.kt#9igjgp");
        boolean v4_1 = arg5.changed(v2);
        Object v6 = arg5.rememberedValue();
        if((v4_1) || v6 == Composer.Companion.getEmpty()) {
            SelectionMagnifierKt$$ExternalSyntheticLambda0 v6_1 = new SelectionMagnifierKt$$ExternalSyntheticLambda0(v2);
            arg5.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        Object v2_1 = arg3.invoke(v6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return ((Modifier)v2_1);
    }

    private static final long animatedSelectionMagnifier$lambda$0$0(State arg2) {
        return arg2.getValue().unbox-impl();
    }

    private static final Offset animatedSelectionMagnifier$lambda$0$1$0(State arg2) {
        return Offset.box-impl(SelectionMagnifierKt.animatedSelectionMagnifier$lambda$0$0(arg2));
    }

    public static final SpringSpec getMagnifierSpringSpec() {
        return SelectionMagnifierKt.MagnifierSpringSpec;
    }

    public static final long getOffsetDisplacementThreshold() {
        return SelectionMagnifierKt.OffsetDisplacementThreshold;
    }

    public static final TwoWayConverter getUnspecifiedSafeOffsetVectorConverter() {
        return SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter;
    }

    private static final State rememberAnimatedMagnifierPosition(Function0 arg9, Composer arg10, int arg11) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1 v2_2;
        Animatable v9_1;
        State v11_1;
        int v1 = 0xA13DA64F;
        ComposerKt.sourceInformationMarkerStart(arg10, v1, "C(rememberAnimatedMagnifierPosition)N(targetCalculation)74@3002L46,75@3070L208,79@3304L1129,79@3283L1150:SelectionMagnifier.kt#eksfi3");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg11, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:73)");
        }

        String v0 = "CC(remember):SelectionMagnifier.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg10, 0x486D5C9D, v0);
        Object v11 = arg10.rememberedValue();
        if(v11 == Composer.Companion.getEmpty()) {
            v11_1 = SnapshotStateKt.derivedStateOf(arg9);
            arg10.updateRememberedValue(v11_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        ComposerKt.sourceInformationMarkerStart(arg10, 0x486D65BF, v0);
        Object v9 = arg10.rememberedValue();
        if(v9 == Composer.Companion.getEmpty()) {
            Animatable v2 = new Animatable(Offset.box-impl(SelectionMagnifierKt.rememberAnimatedMagnifierPosition$lambda$1(v11_1)), SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter, Offset.box-impl(SelectionMagnifierKt.OffsetDisplacementThreshold), null, 8, null);
            arg10.updateRememberedValue(v2);
            v9_1 = v2;
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        Unit v1_1 = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(arg10, 0x486D8698, v0);
        boolean v0_1 = arg10.changedInstance(v9_1);
        Object v2_1 = arg10.rememberedValue();
        if((v0_1) || v2_1 == Composer.Companion.getEmpty()) {
            v2_2 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$1(v11_1, v9_1, null);
            arg10.updateRememberedValue(v2_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        EffectsKt.LaunchedEffect(v1_1, ((Function2)v2_2), arg10, 6);
        State v9_2 = v9_1.asState();
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v9_2;
    }

    private static final long rememberAnimatedMagnifierPosition$lambda$1(State arg2) {
        return arg2.getValue().unbox-impl();
    }
}

