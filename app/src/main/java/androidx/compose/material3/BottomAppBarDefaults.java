package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.DockedToolbarTokens;
import androidx.compose.material3.tokens.FabSecondaryContainerTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\u000E\b\u0002\u0010%\u001A\b\u0012\u0004\u0012\u00020\'0&2\u0010\b\u0002\u0010(\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010+\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010,H\u0007¢\u0006\u0002\u0010-R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\r\u001A\u00020\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u00128G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001A\u00020\u000EX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001A\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u001A\u0010\u000BR\u0014\u0010\u001B\u001A\u00020\u001CX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u001CX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u001E¨\u0006."}, d2={"Landroidx/compose/material3/BottomAppBarDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "bottomAppBarFabColor", "getBottomAppBarFabColor", "FlexibleContentPadding", "getFlexibleContentPadding$material3", "FlexibleBottomAppBarHeight", "getFlexibleBottomAppBarHeight-D9Ej5fM$material3", "FlexibleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getFlexibleHorizontalArrangement$material3", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleFixedHorizontalArrangement", "getFlexibleFixedHorizontalArrangement$material3", "exitAlwaysScrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "state", "Landroidx/compose/material3/BottomAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarScrollBehavior;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BottomAppBarDefaults {
    public static final int $stable;
    private static final float ContainerElevation;
    private static final PaddingValues ContentPadding;
    private static final float FlexibleBottomAppBarHeight;
    private static final PaddingValues FlexibleContentPadding;
    private static final Horizontal FlexibleFixedHorizontalArrangement;
    private static final Horizontal FlexibleHorizontalArrangement;
    public static final BottomAppBarDefaults INSTANCE;

    static {
        BottomAppBarDefaults.INSTANCE = new BottomAppBarDefaults();
        BottomAppBarDefaults.ContainerElevation = Dp.constructor-impl(0f);
        BottomAppBarDefaults.ContentPadding = PaddingKt.PaddingValues-a9UjIt4$default(AppBarKt.BottomAppBarHorizontalPadding, AppBarKt.getBottomAppBarVerticalPadding(), AppBarKt.BottomAppBarHorizontalPadding, 0f, 8, null);
        BottomAppBarDefaults.FlexibleContentPadding = PaddingKt.PaddingValues-a9UjIt4$default(DockedToolbarTokens.INSTANCE.getContainerLeadingSpace-D9Ej5fM(), 0f, DockedToolbarTokens.INSTANCE.getContainerTrailingSpace-D9Ej5fM(), 0f, 10, null);
        BottomAppBarDefaults.FlexibleBottomAppBarHeight = DockedToolbarTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        BottomAppBarDefaults.FlexibleHorizontalArrangement = Arrangement.INSTANCE.getSpaceBetween();
        BottomAppBarDefaults.FlexibleFixedHorizontalArrangement = Arrangement.INSTANCE.spacedBy-D5KLDUw(DockedToolbarTokens.INSTANCE.getContainerMaxSpacing-D9Ej5fM(), Alignment.Companion.getCenterHorizontally());
    }

    private BottomAppBarDefaults() {
        super();
    }

    public final BottomAppBarScrollBehavior exitAlwaysScrollBehavior(BottomAppBarState arg8, Function0 arg9, AnimationSpec arg10, DecayAnimationSpec arg11, Composer arg12, int arg13, int arg14) {
        FiniteAnimationSpec v10;
        Object v9;
        BottomAppBarDefaults$$ExternalSyntheticLambda0 v7_1;
        Composer v4;
        int v0 = 0x1B3F76E2;
        ComposerKt.sourceInformationMarkerStart(arg12, v0, "C(exitAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)2202@105741L27,2203@105805L8,2205@105976L7,2206@106042L26,2208@106114L311:AppBar.kt#uh7d8r");
        if((arg14 & 1) != 0) {
            v4 = arg12;
            arg8 = AppBarKt.rememberBottomAppBarState(0f, 0f, 0f, v4, 0, 7);
        }
        else {
            v4 = arg12;
        }

        String v12 = "CC(remember):AppBar.kt#9igjgp";
        if((arg14 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(v4, 1228758090, v12);
            Object v7 = v4.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                v7_1 = new BottomAppBarDefaults$$ExternalSyntheticLambda0();
                v4.updateRememberedValue(v7_1);
            }

            v9 = v7_1;
            ComposerKt.sourceInformationMarkerEnd(v4);
        }

        int v1 = 6;
        if((arg14 & 4) != 0) {
            v10 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v4, v1);
        }

        int v7_2 = arg14 & 8;
        arg14 = 0;
        if(v7_2 != 0) {
            arg11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(v4, 0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior (AppBar.kt:2208)");
        }

        ComposerKt.sourceInformationMarkerStart(v4, 0x493D8419, v12);
        int v12_1 = 4;
        v7_2 = (arg13 & 14 ^ v1) > v12_1 && (v4.changed(arg8)) || (arg13 & 6) == v12_1 ? 1 : 0;
        v1 = 0x20;
        if((arg13 & 0x70 ^ 0x30) > v1 && (v4.changed(v9)) || (arg13 & 0x30) == v1) {
            arg14 = 1;
        }

        v7_2 = v7_2 | arg14 | v4.changed(v10) | v4.changed(arg11);
        Object v12_2 = v4.rememberedValue();
        if(v7_2 != 0 || v12_2 == Composer.Companion.getEmpty()) {
            ExitAlwaysScrollBehavior v12_3 = new ExitAlwaysScrollBehavior(arg8, ((AnimationSpec)v10), arg11, ((Function0)v9));
            v4.updateRememberedValue(v12_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return ((BottomAppBarScrollBehavior)v12_2);
    }

    static final boolean exitAlwaysScrollBehavior$lambda$1$lambda$0() {
        return 1;
    }

    public final long getBottomAppBarFabColor(Composer arg3, int arg4) {
        int v0 = 0xA8B490B2;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-bottomAppBarFabColor>)2155@103238L5:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-bottomAppBarFabColor> (AppBar.kt:2155)");
        }

        long v0_1 = ColorSchemeKt.getValue(FabSecondaryContainerTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = -368340078;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)2128@102275L5:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-containerColor> (AppBar.kt:2128)");
        }

        long v0_1 = ColorSchemeKt.getValue(BottomAppBarTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getContainerElevation-D9Ej5fM() {
        return BottomAppBarDefaults.ContainerElevation;
    }

    public final PaddingValues getContentPadding() {
        return BottomAppBarDefaults.ContentPadding;
    }

    public final float getFlexibleBottomAppBarHeight-D9Ej5fM$material3() {
        return BottomAppBarDefaults.FlexibleBottomAppBarHeight;
    }

    public final PaddingValues getFlexibleContentPadding$material3() {
        return BottomAppBarDefaults.FlexibleContentPadding;
    }

    public final Horizontal getFlexibleFixedHorizontalArrangement$material3() {
        return BottomAppBarDefaults.FlexibleFixedHorizontalArrangement;
    }

    public final Horizontal getFlexibleHorizontalArrangement$material3() {
        return BottomAppBarDefaults.FlexibleHorizontalArrangement;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = 0x290FB999;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)2148@102932L29:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-windowInsets> (AppBar.kt:2147)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }
}

