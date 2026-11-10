package androidx.compose.foundation.layout;

import android.os.Build$VERSION;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0007\u001A\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t\"\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0013\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0014\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0015\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"imeNestedScroll", "Landroidx/compose/ui/Modifier;", "rememberWindowInsetsConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "rememberWindowInsetsConnection-VRgvIgI", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Inflection", "", "PlatformFlingScrollFriction", "GravityEarth", "InchesPerMeter", "DecelerationRate", "", "DecelMinusOne", "StartTension", "EndTension", "P1", "P2", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WindowInsetsConnection_androidKt {
    private static final double DecelMinusOne = 0;
    private static final double DecelerationRate = 0;
    private static final float EndTension = 1f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.369999f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35f;
    private static final float PlatformFlingScrollFriction = 0f;
    private static final float StartTension = 0.5f;

    public static DisposableEffectResult $r8$lambda$Eaq4m4auNxm2RJ3NQ3J6FJkx6QM(WindowInsetsNestedScrollConnection arg0, DisposableEffectScope arg1) {
        return WindowInsetsConnection_androidKt.rememberWindowInsetsConnection_VRgvIgI$lambda$1$0(arg0, arg1);
    }

    static {
        WindowInsetsConnection_androidKt.PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        double v0 = Math.log(0.78) / Math.log(0.9);
        WindowInsetsConnection_androidKt.DecelerationRate = v0;
        WindowInsetsConnection_androidKt.DecelMinusOne = v0 - 1;
    }

    public static final double access$getDecelMinusOne$p() {
        return WindowInsetsConnection_androidKt.DecelMinusOne;
    }

    public static final double access$getDecelerationRate$p() {
        return WindowInsetsConnection_androidKt.DecelerationRate;
    }

    public static final float access$getPlatformFlingScrollFriction$p() {
        return WindowInsetsConnection_androidKt.PlatformFlingScrollFriction;
    }

    public static final Modifier imeNestedScroll(Modifier arg2) {
        Function1 v0_1;
        if(Build$VERSION.SDK_INT < 30) {
            return arg2;
        }

        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1 v0 = new WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1();
        }
        else {
            v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, v0_1, new WindowInsetsConnection_androidKt$$ExternalSyntheticLambda1());
    }

    static final Modifier imeNestedScroll$lambda$1(Modifier arg3, Composer arg4, int arg5) {
        int v0 = 0xE9F29258;
        arg4.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg4, "C78@3217L9,77@3150L137:WindowInsetsConnection.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg5, -1, "androidx.compose.foundation.layout.imeNestedScroll.<anonymous> (WindowInsetsConnection.android.kt:76)");
        }

        arg3 = NestedScrollModifierKt.nestedScroll$default(arg3, WindowInsetsConnection_androidKt.rememberWindowInsetsConnection-VRgvIgI(WindowInsetsHolder.Companion.current(arg4, 6).getIme(), WindowInsetsSides.Companion.getBottom-JoeWqyM(), arg4, 0x30), null, 2, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg4.endReplaceGroup();
        return arg3;
    }

    public static final NestedScrollConnection rememberWindowInsetsConnection-VRgvIgI(AndroidWindowInsets arg6, int arg7, Composer arg8, int arg9) {
        int v0 = -1011341039;
        arg8.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(rememberWindowInsetsConnection)N(windowInsets,side:c#foundation.layout.WindowInsetsSides)109@4560L7,111@4673L7,112@4712L7,114@4749L157,117@4940L38,117@4911L67:WindowInsetsConnection.android.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg9, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:105)");
        }

        if(Build$VERSION.SDK_INT < 30) {
            DoNothingNestedScrollConnection v6 = DoNothingNestedScrollConnection.INSTANCE;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            arg8.endReplaceGroup();
            return ((NestedScrollConnection)v6);
        }

        ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_2 = arg8.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg8);
        SideCalculator v7 = SideCalculator.Companion.chooseCalculator-ni1skBw(arg7, ((LayoutDirection)v0_2));
        v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v0_2 = arg8.consume(((CompositionLocal)v0_1));
        ComposerKt.sourceInformationMarkerEnd(arg8);
        ProvidableCompositionLocal v3 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg8, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v1 = arg8.consume(((CompositionLocal)v3));
        ComposerKt.sourceInformationMarkerEnd(arg8);
        String v3_1 = "CC(remember):WindowInsetsConnection.android.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg8, -1236114130, v3_1);
        int v5 = 4;
        arg9 = (arg9 & 14 ^ 6) > v5 && (arg8.changed(arg6)) || (arg9 & 6) == v5 ? 1 : 0;
        arg9 = arg9 | arg8.changed(v0_2) | arg8.changed(v7) | arg8.changed(v1);
        Object v2 = arg8.rememberedValue();
        if(arg9 != 0 || v2 == Composer.Companion.getEmpty()) {
            WindowInsetsNestedScrollConnection v2_1 = new WindowInsetsNestedScrollConnection(arg6, ((View)v0_2), v7, ((Density)v1));
            arg8.updateRememberedValue(v2_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        ComposerKt.sourceInformationMarkerStart(arg8, -1236108137, v3_1);
        boolean v6_1 = arg8.changedInstance(v2);
        Object v7_1 = arg8.rememberedValue();
        if((v6_1) || v7_1 == Composer.Companion.getEmpty()) {
            WindowInsetsConnection_androidKt$$ExternalSyntheticLambda0 v7_2 = new WindowInsetsConnection_androidKt$$ExternalSyntheticLambda0(((WindowInsetsNestedScrollConnection)v2));
            arg8.updateRememberedValue(v7_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        EffectsKt.DisposableEffect(v2, ((Function1)v7_1), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg8.endReplaceGroup();
        return ((NestedScrollConnection)v2);
    }

    private static final DisposableEffectResult rememberWindowInsetsConnection_VRgvIgI$lambda$1$0(WindowInsetsNestedScrollConnection arg0, DisposableEffectScope arg1) {
        return new WindowInsetsConnection_androidKt$rememberWindowInsetsConnection_VRgvIgI$lambda$1$0$$inlined$onDispose$1(arg0);
    }
}

