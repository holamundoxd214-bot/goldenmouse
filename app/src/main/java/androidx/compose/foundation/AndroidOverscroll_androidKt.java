package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A#\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u000E\u0010\b\u001A\u0004\u0018\u00010\u0001*\u00020\tH\u0000\u001A\u000F\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0001¢\u0006\u0002\u0010\f\u001A\u0017\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u000E\u0010\u0013\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0014\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015\"\u000E\u0010\u0016\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"rememberPlatformOverscrollFactory", "Landroidx/compose/foundation/OverscrollFactory;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "rememberPlatformOverscrollFactory-3J-VO9M", "(JLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/OverscrollFactory;", "defaultOverscrollFactory", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "rememberPlatformOverscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/OverscrollEffect;", "destretchMultiplier", "", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "destretchMultiplier-GyEprt8", "(I)F", "FlingDestretchFactor", "DefaultGlowColor", "J", "DefaultGlowPaddingValues", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidOverscroll_androidKt {
    private static final long DefaultGlowColor = 0;
    private static final PaddingValues DefaultGlowPaddingValues = null;
    private static final float FlingDestretchFactor = 4f;

    static {
        AndroidOverscroll_androidKt.DefaultGlowColor = ColorKt.Color(0xFF666666L);
        AndroidOverscroll_androidKt.DefaultGlowPaddingValues = PaddingKt.PaddingValues-YgX7TsA$default(0f, 0f, 3, null);
    }

    public static final float access$destretchMultiplier-GyEprt8(int arg0) {
        return AndroidOverscroll_androidKt.destretchMultiplier-GyEprt8(arg0);
    }

    public static final long access$getDefaultGlowColor$p() {
        return AndroidOverscroll_androidKt.DefaultGlowColor;
    }

    public static final PaddingValues access$getDefaultGlowPaddingValues$p() {
        return AndroidOverscroll_androidKt.DefaultGlowPaddingValues;
    }

    public static final OverscrollFactory defaultOverscrollFactory(CompositionLocalAccessorScope arg8) {
        Object v2 = arg8.getCurrentValue(AndroidCompositionLocals_androidKt.getLocalContext());
        Object v3 = arg8.getCurrentValue(CompositionLocalsKt.getLocalDensity());
        Object v8 = arg8.getCurrentValue(OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration());
        if(v8 == null) {
            return null;
        }

        return new AndroidEdgeEffectOverscrollFactory(((Context)v2), ((Density)v3), ((OverscrollConfiguration)v8).getGlowColor-0d7_KjU(), ((OverscrollConfiguration)v8).getDrawPadding(), null);
    }

    private static final float destretchMultiplier-GyEprt8(int arg1) {
        if(NestedScrollSource.equals-impl0(arg1, NestedScrollSource.Companion.getSideEffect-WNlRxjI())) {
            return 4f;
        }

        return 1f;
    }

    public static final OverscrollEffect rememberPlatformOverscrollEffect(Composer arg9, int arg10) {
        AndroidEdgeEffectOverscrollEffect v1_2;
        int v1 = 0x5D8D117F;
        ComposerKt.sourceInformationMarkerStart(arg9, v1, "C(rememberPlatformOverscrollEffect)108@4781L7,109@4820L7,110@4874L7:AndroidOverscroll.android.kt#71ulvw");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg10, -1, "androidx.compose.foundation.rememberPlatformOverscrollEffect (AndroidOverscroll.android.kt:107)");
        }

        ProvidableCompositionLocal v10 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v10_1 = arg9.consume(((CompositionLocal)v10));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v3 = v10_1;
        v10 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v10_1 = arg9.consume(((CompositionLocal)v10));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v4 = v10_1;
        v10 = OverscrollConfiguration_androidKt.getLocalOverscrollConfiguration();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v10_1 = arg9.consume(((CompositionLocal)v10));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        if(v10_1 == null) {
            arg9.startReplaceGroup(-1555403601);
            arg9.endReplaceGroup();
            OverscrollEffect v10_2 = null;
        }
        else {
            arg9.startReplaceGroup(0xA34AEC70);
            ComposerKt.sourceInformation(arg9, "114@4949L227");
            ComposerKt.sourceInformationMarkerStart(arg9, 0x2E8ECF02, "CC(remember):AndroidOverscroll.android.kt#9igjgp");
            int v0 = arg9.changed(v3) | arg9.changed(v4) | arg9.changed(v10_1);
            Object v1_1 = arg9.rememberedValue();
            if(v0 != 0 || v1_1 == Composer.Companion.getEmpty()) {
                AndroidEdgeEffectOverscrollEffect v2 = new AndroidEdgeEffectOverscrollEffect(((Context)v3), ((Density)v4), ((OverscrollConfiguration)v10_1).getGlowColor-0d7_KjU(), ((OverscrollConfiguration)v10_1).getDrawPadding(), null);
                arg9.updateRememberedValue(v2);
                v1_2 = v2;
            }

            ComposerKt.sourceInformationMarkerEnd(arg9);
            arg9.endReplaceGroup();
            v10_1 = v1_2;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        return ((OverscrollEffect)v10_1);
    }

    public static final OverscrollFactory rememberPlatformOverscrollFactory-3J-VO9M(long arg9, PaddingValues arg11, Composer arg12, int arg13, int arg14) {
        int v1 = -2017030679;
        ComposerKt.sourceInformationMarkerStart(arg12, v1, "C(rememberPlatformOverscrollFactory)N(glowColor:c#ui.graphics.Color,glowDrawPadding)86@3975L7,87@4014L7:AndroidOverscroll.android.kt#71ulvw");
        if((arg14 & 1) != 0) {
            arg9 = AndroidOverscroll_androidKt.DefaultGlowColor;
        }

        long v5 = arg9;
        if((arg14 & 2) != 0) {
            arg11 = AndroidOverscroll_androidKt.DefaultGlowPaddingValues;
        }

        PaddingValues v7 = arg11;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg13, -1, "androidx.compose.foundation.rememberPlatformOverscrollFactory (AndroidOverscroll.android.kt:85)");
        }

        ProvidableCompositionLocal v9 = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v9_1 = arg12.consume(((CompositionLocal)v9));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        Object v3 = v9_1;
        v9 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v9_1 = arg12.consume(((CompositionLocal)v9));
        ComposerKt.sourceInformationMarkerEnd(arg12);
        AndroidEdgeEffectOverscrollFactory v2 = new AndroidEdgeEffectOverscrollFactory(((Context)v3), v9_1, v5, v7, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg12);
        return ((OverscrollFactory)v2);
    }
}

