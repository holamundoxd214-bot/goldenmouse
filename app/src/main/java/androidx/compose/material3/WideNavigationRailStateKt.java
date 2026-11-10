package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A\u0017\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001A\r\u0010\b\u001A\u00020\u0003*\u00020\u0003H\u0080\u0002\"\u0018\u0010\u0005\u001A\u00020\u0006*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2={"rememberWideNavigationRailState", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailState;", "isExpanded", "", "(Landroidx/compose/material3/WideNavigationRailValue;)Z", "not", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class WideNavigationRailStateKt {
    public static final boolean isExpanded(WideNavigationRailValue arg1) {
        if(arg1 == WideNavigationRailValue.Expanded) {
            return 1;
        }

        return 0;
    }

    public static final WideNavigationRailValue not(WideNavigationRailValue arg1) {
        if(arg1 == WideNavigationRailValue.Collapsed) {
            return WideNavigationRailValue.Expanded;
        }

        return WideNavigationRailValue.Collapsed;
    }

    public static final WideNavigationRailState rememberWideNavigationRailState(WideNavigationRailValue arg7, Composer arg8, int arg9, int arg10) {
        int v1 = 0x5F15F100;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberWideNavigationRailState)N(initialValue)88@3279L14,89@3380L103,89@3305L178:WideNavigationRailState.kt#uh7d8r");
        int v0 = 1;
        if((arg10 & 1) != 0) {
            arg7 = WideNavigationRailValue.Collapsed;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.rememberWideNavigationRailState (WideNavigationRailState.kt:86)");
        }

        v1 = 6;
        FiniteAnimationSpec v10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, arg8, v1);
        Object[] v3 = new Object[0];
        Saver v4 = WideNavigationRailStateImpl.Companion.Saver(v10);
        ComposerKt.sourceInformationMarkerStart(arg8, -245505433, "CC(remember):WideNavigationRailState.kt#9igjgp");
        int v6 = 4;
        if((arg9 & 14 ^ v1) <= v6 || !arg8.changed(arg7.ordinal())) {
            if((arg9 & v1) == v6) {
            }
            else {
                v0 = 0;
            }
        }

        arg9 = arg8.changedInstance(v10) | v0;
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            WideNavigationRailStateKt$$ExternalSyntheticLambda0 v0_2 = new WideNavigationRailStateKt$$ExternalSyntheticLambda0(arg7, v10);
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        Object v7 = RememberSaveableKt.rememberSaveable(v3, v4, ((Function0)v0_1), arg8, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((WideNavigationRailState)v7);
    }

    static final WideNavigationRailState rememberWideNavigationRailState$lambda$1$lambda$0(WideNavigationRailValue arg1, FiniteAnimationSpec arg2) {
        return new WideNavigationRailStateImpl(arg1, ((AnimationSpec)arg2));
    }
}

