package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\r\u0010\u0000\u001A\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001A\u001B\u0010\u0003\u001A\u00020\u00042\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001A\u001F\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0001¢\u0006\u0004\b\u000E\u0010\u000F\u001A+\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0003¢\u0006\u0002\u0010\u0016\u001A\f\u0010\u0017\u001A\u00020\u0018*\u00020\u0012H\u0002¨\u0006\u0019²\u0006\n\u0010\u001A\u001A\u00020\rX\u008A\u0084\u0002"}, d2={"platformWindowBoundsCalculator", "Landroidx/compose/material3/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "popupPropertiesForAnchorType", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "alwaysFocusable", "", "popupPropertiesForAnchorType-BTG8-q0", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "material3", "a11yServicesEnabled"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ExposedDropdownMenu_androidKt {
    public static final void OnPlatformWindowBoundsChange(Function0 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 0x9DDB8E7B;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(OnPlatformWindowBoundsChange)N(block)48@1868L7,49@1907L7,50@1919L42:ExposedDropdownMenu.android.kt#uh7d8r");
        int v2 = 2;
        if((arg7 & 6) == 0) {
            v1 = arg6.changedInstance(arg5) ? 4 : v2;
            v1 |= arg7;
        }
        else {
            v1 = arg7;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg6.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:47)");
            }

            ProvidableCompositionLocal v0_1 = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg6.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg6);
            ProvidableCompositionLocal v4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(arg6, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = arg6.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(arg6);
            ExposedDropdownMenu_androidKt.SoftKeyboardListener(((View)v0_2), ((Density)v2_2), arg5, arg6, v1 << 6 & 0x380);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_46;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_46:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda0(arg5, arg7));
        }
    }

    static final Unit OnPlatformWindowBoundsChange$lambda$1(Function0 arg0, int arg1, Composer arg2, int arg3) {
        ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final void SoftKeyboardListener(View arg7, Density arg8, Function0 arg9, Composer arg10, int arg11) {
        int v2;
        int v1;
        int v0 = 0xB159AF58;
        arg10 = arg10.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg10, "C(SoftKeyboardListener)N(view,density,onKeyboardVisibilityChange)88@3457L1420,88@3425L1452:ExposedDropdownMenu.android.kt#uh7d8r");
        if((arg11 & 6) == 0) {
            v1 = arg10.changedInstance(arg7) ? 4 : 2;
            v1 |= arg11;
        }
        else {
            v1 = arg11;
        }

        if((arg11 & 0x30) == 0) {
            v2 = arg10.changed(arg8) ? 0x20 : 16;
            v1 |= v2;
        }

        int v3 = 0x100;
        if((arg11 & 0x180) == 0) {
            v2 = arg10.changedInstance(arg9) ? v3 : 0x80;
            v1 |= v2;
        }

        int v5 = 0;
        boolean v2_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg10.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:85)");
            }

            ComposerKt.sourceInformationMarkerStart(arg10, -1045730588, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean v0_1 = arg10.changedInstance(arg7);
            if((v1 & 0x380) == v3) {
                v5 = 1;
            }

            Object v2_2 = arg10.rememberedValue();
            if(((((int)v0_1)) | v5) != 0 || v2_2 == Composer.Companion.getEmpty()) {
                ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda1 v2_3 = new ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda1(arg7, arg9);
                arg10.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg10);
            EffectsKt.DisposableEffect(arg7, arg8, ((Function1)v2_2), arg10, v1 & 0x7E);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_71;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg10.skipToGroupEnd();
        }

    label_71:
        ScopeUpdateScope v10 = arg10.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new ExposedDropdownMenu_androidKt$$ExternalSyntheticLambda2(arg7, arg8, arg9, arg11));
        }
    }

    static final DisposableEffectResult SoftKeyboardListener$lambda$5$lambda$4(View arg0, Function0 arg1, DisposableEffectScope arg2) {
        return new ExposedDropdownMenu_androidKt$SoftKeyboardListener$lambda$5$lambda$4$$inlined$onDispose$1(new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(arg0, arg1));
    }

    static final Unit SoftKeyboardListener$lambda$6(View arg0, Density arg1, Function0 arg2, int arg3, Composer arg4, int arg5) {
        ExposedDropdownMenu_androidKt.SoftKeyboardListener(arg0, arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    public static final IntRect access$getWindowBounds(View arg0) {
        return ExposedDropdownMenu_androidKt.getWindowBounds(arg0);
    }

    private static final IntRect getWindowBounds(View arg1) {
        Rect v0 = new Rect();
        arg1.getWindowVisibleDisplayFrame(v0);
        return RectHelper_androidKt.toComposeIntRect(v0);
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer arg3, int arg4) {
        WindowBoundsCalculator v1_2;
        int v1 = 0x29EBE073;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(platformWindowBoundsCalculator)41@1650L7,42@1683L7,43@1702L55:ExposedDropdownMenu.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:40)");
        }

        ProvidableCompositionLocal v4 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ProvidableCompositionLocal v2 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0 = arg3.consume(((CompositionLocal)v2));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        ComposerKt.sourceInformationMarkerStart(arg3, 0x5E75A64A, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        arg4 = arg3.changed(v4_1) | arg3.changed(v0);
        Object v1_1 = arg3.rememberedValue();
        if(arg4 != 0 || v1_1 == Composer.Companion.getEmpty()) {
            v1_2 = new WindowBoundsCalculator(((View)v0));
            arg3.updateRememberedValue(v1_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v1_2;
    }

    public static final PopupProperties popupPropertiesForAnchorType-BTG8-q0(String arg10, boolean arg11, Composer arg12, int arg13) {
        int v1 = 895018515;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(popupPropertiesForAnchorType)N(anchorType:c#material3.ExposedDropdownMenuAnchorType,alwaysFocusable)58@2156L35:ExposedDropdownMenu.android.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.material3.popupPropertiesForAnchorType (ExposedDropdownMenu.android.kt:57)");
        }

        State v13 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, arg12, 0, 7);
        int v0 = !ExposedDropdownMenu_androidKt.popupPropertiesForAnchorType_BTG8_q0$lambda$2(v13) ? 0x60020 : 0x60000;
        if(((ExposedDropdownMenuAnchorType.equals-impl0(arg10, ExposedDropdownMenuAnchorType.Companion.getPrimaryEditable-oYjWRB4())) || (ExposedDropdownMenuAnchorType.equals-impl0(arg10, ExposedDropdownMenuAnchorType.Companion.getSecondaryEditable-oYjWRB4())) && !ExposedDropdownMenu_androidKt.popupPropertiesForAnchorType_BTG8_q0$lambda$2(v13)) && !arg11) {
            v0 |= 8;
        }

        PopupProperties v1_1 = new PopupProperties(v0, false, false, false, false, false, 62, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return v1_1;
    }

    private static final boolean popupPropertiesForAnchorType_BTG8_q0$lambda$2(State arg0) {
        return arg0.getValue().booleanValue();
    }
}

