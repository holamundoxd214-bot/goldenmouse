package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JK\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\b2\b\b\u0002\u0010\r\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000E\u0010\u000FJA\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u001A\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001B\u0010\u0011J\r\u0010\u001C\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001D\u0010\u0011J\r\u0010\u001E\u001A\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006JA\u0010\u001E\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001F\u0010\u0011J\'\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#2\u000E\b\u0002\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%H\u0007¢\u0006\u0002\u0010\'JK\u0010(\u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#2\u000E\b\u0002\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.JU\u0010(\u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#2\u000E\b\u0002\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010-2\b\b\u0002\u0010/\u001A\u00020&H\u0007¢\u0006\u0002\u00100JK\u00101\u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#2\u000E\b\u0002\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0010\b\u0002\u0010)\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0010\b\u0002\u0010,\u001A\n\u0012\u0004\u0012\u00020+\u0018\u00010-H\u0007¢\u0006\u0002\u0010.R\u0018\u0010\u0012\u001A\u00020\u0005*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001A\u00020\u00178G¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0013\u00102\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b4\u00105R\u0013\u00107\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b8\u00105R\u0013\u00109\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b:\u00105R\u0013\u0010;\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b<\u00105R\u0013\u0010=\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b>\u00105R\u0013\u0010?\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\b@\u00105R\u0013\u0010A\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\bB\u00105R\u0013\u0010C\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\bD\u00105R\u0013\u0010E\u001A\u000203¢\u0006\n\n\u0002\u00106\u001A\u0004\bF\u00105¨\u0006G"}, d2={"Landroidx/compose/material3/TopAppBarDefaults;", "", "<init>", "()V", "topAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "subtitleContentColor", "topAppBarColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "topAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "defaultTopAppBarColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultTopAppBarColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "centerAlignedTopAppBarColors", "centerAlignedTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "enterAlwaysScrollBehavior", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "reverseLayout", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "TopAppBarExpandedHeight", "Landroidx/compose/ui/unit/Dp;", "getTopAppBarExpandedHeight-D9Ej5fM", "()F", "F", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithoutSubtitleExpandedHeight", "getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "MediumFlexibleAppBarWithSubtitleExpandedHeight", "getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "LargeAppBarCollapsedHeight", "getLargeAppBarCollapsedHeight-D9Ej5fM", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithoutSubtitleExpandedHeight", "getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM", "LargeFlexibleAppBarWithSubtitleExpandedHeight", "getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TopAppBarDefaults {
    public static final int $stable;
    public static final TopAppBarDefaults INSTANCE;
    private static final float LargeAppBarCollapsedHeight;
    private static final float LargeAppBarExpandedHeight;
    private static final float LargeFlexibleAppBarWithSubtitleExpandedHeight;
    private static final float LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    private static final float MediumAppBarCollapsedHeight;
    private static final float MediumAppBarExpandedHeight;
    private static final float MediumFlexibleAppBarWithSubtitleExpandedHeight;
    private static final float MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    private static final float TopAppBarExpandedHeight;

    static {
        TopAppBarDefaults.INSTANCE = new TopAppBarDefaults();
        TopAppBarDefaults.TopAppBarExpandedHeight = AppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumAppBarExpandedHeight = AppBarMediumTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight = AppBarMediumFlexibleTokens.INSTANCE.getLargeContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeAppBarCollapsedHeight = AppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeAppBarExpandedHeight = AppBarLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight = AppBarLargeFlexibleTokens.INSTANCE.getLargeContainerHeight-D9Ej5fM();
    }

    private TopAppBarDefaults() {
        super();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors centerAlignedTopAppBarColors(Composer arg4, int arg5) {
        int v1 = 513940029;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(centerAlignedTopAppBarColors)1540@76486L11:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1540)");
        }

        TopAppBarColors v3 = this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors centerAlignedTopAppBarColors-zjMxDiM(long arg21, long arg23, long arg25, long arg27, long arg29, Composer arg31, int arg32, int arg33) {
        Composer v0 = arg31;
        int v2 = 0x7102EF78;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(centerAlignedTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1570@77887L11:AppBar.kt#uh7d8r");
        long v6 = (arg33 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v8 = (arg33 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v10 = (arg33 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v12 = (arg33 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v14 = (arg33 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg32, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1570)");
        }

        TopAppBarColors v1 = TopAppBarColors.copy-tNS2XkQ$default(this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)), v6, v8, v10, v12, v14, 0, 0x20, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState arg10, Function0 arg11, AnimationSpec arg12, DecayAnimationSpec arg13, Composer arg14, int arg15, int arg16) {
        AnimationSpec v0_3;
        Object v2;
        int v7 = 0x392A8052;
        ComposerKt.sourceInformationMarkerStart(arg14, v7, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1718@84505L24,1719@84566L8,1721@84740L7,1722@84806L26,1724@84882L237:AppBar.kt#uh7d8r");
        TopAppBarState v1 = (arg16 & 1) != 0 ? AppBarKt.rememberTopAppBarState(0f, 0f, 0f, arg14, 0, 7) : arg10;
        if((arg16 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(arg14, 0x988BD41A, "CC(remember):AppBar.kt#9igjgp");
            Object v0 = arg14.rememberedValue();
            if(v0 == Composer.Companion.getEmpty()) {
                TopAppBarDefaults$$ExternalSyntheticLambda3 v0_1 = new TopAppBarDefaults$$ExternalSyntheticLambda3();
                arg14.updateRememberedValue(v0_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
            v2 = v0;
        }
        else {
            Function0 v2_1 = arg11;
        }

        if((arg16 & 4) != 0) {
            FiniteAnimationSpec v0_2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg14, 6);
        }
        else {
            v0_3 = arg12;
        }

        DecayAnimationSpec v4 = (arg16 & 8) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(arg14, 0) : arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v7, arg15, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1723)");
        }

        TopAppBarScrollBehavior v0_4 = this.enterAlwaysScrollBehavior(v1, ((Function0)v2), ((FiniteAnimationSpec)v0_3), v4, false, arg14, arg15 & 14 | 0x6000 | arg15 & 0x70 | arg15 & 0x380 | arg15 & 0x1C00 | arg15 << 3 & 0x70000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v0_4;
    }

    public final TopAppBarScrollBehavior enterAlwaysScrollBehavior(TopAppBarState arg8, Function0 arg9, AnimationSpec arg10, DecayAnimationSpec arg11, boolean arg12, Composer arg13, int arg14, int arg15) {
        EnterAlwaysScrollBehavior v13_3;
        FiniteAnimationSpec v10;
        Object v9;
        Composer v4;
        int v0 = 53729710;
        ComposerKt.sourceInformationMarkerStart(arg13, v0, "C(enterAlwaysScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1755@86491L24,1756@86552L8,1758@86726L7,1759@86792L26,1762@86901L374:AppBar.kt#uh7d8r");
        if((arg15 & 1) != 0) {
            v4 = arg13;
            arg8 = AppBarKt.rememberTopAppBarState(0f, 0f, 0f, v4, 0, 7);
        }
        else {
            v4 = arg13;
        }

        String v13 = "CC(remember):AppBar.kt#9igjgp";
        if((arg15 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(v4, 94649206, v13);
            Object v7 = v4.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                TopAppBarDefaults$$ExternalSyntheticLambda1 v7_1 = new TopAppBarDefaults$$ExternalSyntheticLambda1();
                v4.updateRememberedValue(v7_1);
            }

            v9 = v7;
            ComposerKt.sourceInformationMarkerEnd(v4);
        }

        int v1 = 6;
        if((arg15 & 4) != 0) {
            v10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v4, v1);
        }

        int v2 = 0;
        if((arg15 & 8) != 0) {
            arg11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(v4, 0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg14, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1762)");
        }

        ComposerKt.sourceInformationMarkerStart(v4, 94660740, v13);
        int v13_1 = 4;
        int v7_2 = (arg14 & 14 ^ v1) > v13_1 && (v4.changed(arg8)) || (arg14 & 6) == v13_1 ? 1 : 0;
        v0 = 0x20;
        v13_1 = (arg14 & 0x70 ^ 0x30) > v0 && (v4.changed(v9)) || (arg14 & 0x30) == v0 ? 1 : 0;
        v7_2 = v7_2 | v13_1 | v4.changed(v10) | v4.changed(arg11);
        v0 = 0x4000;
        if((0xE000 & arg14 ^ 0x6000) > v0 && (v4.changed(false)) || (arg14 & 0x6000) == v0) {
            v2 = 1;
        }

        Object v13_2 = v4.rememberedValue();
        if((v7_2 | v2) != 0 || v13_2 == Composer.Companion.getEmpty()) {
            EnterAlwaysScrollBehavior v9_1 = new EnterAlwaysScrollBehavior(arg8, ((AnimationSpec)v10), arg11, ((Function0)v9), false);
            v4.updateRememberedValue(v9_1);
            v13_3 = v9_1;
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return ((TopAppBarScrollBehavior)v13_3);
    }

    static final boolean enterAlwaysScrollBehavior$lambda$5$lambda$4() {
        return 1;
    }

    static final boolean enterAlwaysScrollBehavior$lambda$7$lambda$6() {
        return 1;
    }

    public final TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(TopAppBarState arg8, Function0 arg9, AnimationSpec arg10, DecayAnimationSpec arg11, Composer arg12, int arg13, int arg14) {
        FiniteAnimationSpec v10;
        Object v9;
        Composer v4;
        int v0 = 0x9745F3FE;
        ComposerKt.sourceInformationMarkerStart(arg12, v0, "C(exitUntilCollapsedScrollBehavior)N(state,canScroll,snapAnimationSpec,flingAnimationSpec)1795@88631L24,1796@88692L8,1798@88866L7,1799@88932L26,1801@89001L319:AppBar.kt#uh7d8r");
        if((arg14 & 1) != 0) {
            v4 = arg12;
            arg8 = AppBarKt.rememberTopAppBarState(0f, 0f, 0f, v4, 0, 7);
        }
        else {
            v4 = arg12;
        }

        String v12 = "CC(remember):AppBar.kt#9igjgp";
        if((arg14 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(v4, 0xDD9902A6, v12);
            Object v7 = v4.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                TopAppBarDefaults$$ExternalSyntheticLambda0 v7_1 = new TopAppBarDefaults$$ExternalSyntheticLambda0();
                v4.updateRememberedValue(v7_1);
            }

            v9 = v7;
            ComposerKt.sourceInformationMarkerEnd(v4);
        }

        int v1 = 6;
        if((arg14 & 4) != 0) {
            v10 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v4, v1);
        }

        int v7_2 = arg14 & 8;
        arg14 = 0;
        if(v7_2 != 0) {
            arg11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(v4, 0);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg13, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1801)");
        }

        ComposerKt.sourceInformationMarkerStart(v4, 0xDD992A7D, v12);
        int v12_1 = 4;
        v7_2 = (arg13 & 14 ^ v1) > v12_1 && (v4.changed(arg8)) || (arg13 & 6) == v12_1 ? 1 : 0;
        v1 = 0x20;
        if((arg13 & 0x70 ^ 0x30) > v1 && (v4.changed(v9)) || (arg13 & 0x30) == v1) {
            arg14 = 1;
        }

        v7_2 = v7_2 | arg14 | v4.changed(v10) | v4.changed(arg11);
        Object v12_2 = v4.rememberedValue();
        if(v7_2 != 0 || v12_2 == Composer.Companion.getEmpty()) {
            ExitUntilCollapsedScrollBehavior v12_3 = new ExitUntilCollapsedScrollBehavior(arg8, ((AnimationSpec)v10), arg11, ((Function0)v9));
            v4.updateRememberedValue(v12_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return ((TopAppBarScrollBehavior)v12_2);
    }

    static final boolean exitUntilCollapsedScrollBehavior$lambda$10$lambda$9() {
        return 1;
    }

    public final TopAppBarColors getDefaultTopAppBarColors$material3(ColorScheme arg15) {
        TopAppBarColors v14 = arg15.getDefaultTopAppBarColorsCached$material3();
        if(v14 == null) {
            TopAppBarColors v0 = new TopAppBarColors(ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getOnScrollContainerColor()), ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getLeadingIconColor()), ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getTitleColor()), ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getTrailingIconColor()), ColorSchemeKt.fromToken(arg15, AppBarTokens.INSTANCE.getSubtitleColor()), null);
            arg15.setDefaultTopAppBarColorsCached$material3(v0);
            return v0;
        }

        return v14;
    }

    public final float getLargeAppBarCollapsedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeAppBarCollapsedHeight;
    }

    public final float getLargeAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeAppBarExpandedHeight;
    }

    public final float getLargeFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeFlexibleAppBarWithSubtitleExpandedHeight;
    }

    public final float getLargeFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    public final float getMediumAppBarCollapsedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumAppBarCollapsedHeight;
    }

    public final float getMediumAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumAppBarExpandedHeight;
    }

    public final float getMediumFlexibleAppBarWithSubtitleExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumFlexibleAppBarWithSubtitleExpandedHeight;
    }

    public final float getMediumFlexibleAppBarWithoutSubtitleExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumFlexibleAppBarWithoutSubtitleExpandedHeight;
    }

    public final float getTopAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.TopAppBarExpandedHeight;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = 0x7FBE5FFF;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)1526@75942L29:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1526)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getTop-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors largeTopAppBarColors(Composer arg4, int arg5) {
        int v1 = 0x68018E29;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(largeTopAppBarColors)1639@80652L11:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1639)");
        }

        TopAppBarColors v3 = this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors largeTopAppBarColors-zjMxDiM(long arg21, long arg23, long arg25, long arg27, long arg29, Composer arg31, int arg32, int arg33) {
        Composer v0 = arg31;
        int v2 = -1471507700;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(largeTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1670@82075L11:AppBar.kt#uh7d8r");
        long v6 = (arg33 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v8 = (arg33 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v10 = (arg33 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v12 = (arg33 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v14 = (arg33 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg32, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1670)");
        }

        TopAppBarColors v1 = TopAppBarColors.copy-tNS2XkQ$default(this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)), v6, v8, v10, v12, v14, 0, 0x20, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors mediumTopAppBarColors(Composer arg4, int arg5) {
        int v1 = 0x4BA1ABBF;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(mediumTopAppBarColors)1589@78558L11:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1589)");
        }

        TopAppBarColors v3 = this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use topAppBarColors instead", replaceWith="<_subannotation>") public final TopAppBarColors mediumTopAppBarColors-zjMxDiM(long arg21, long arg23, long arg25, long arg27, long arg29, Composer arg31, int arg32, int arg33) {
        Composer v0 = arg31;
        int v2 = 0xDD482536;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(mediumTopAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1620@79983L11:AppBar.kt#uh7d8r");
        long v6 = (arg33 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v8 = (arg33 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v10 = (arg33 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v12 = (arg33 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        long v14 = (arg33 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg29;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg32, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1620)");
        }

        TopAppBarColors v1 = TopAppBarColors.copy-tNS2XkQ$default(this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)), v6, v8, v10, v12, v14, 0, 0x20, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    public final TopAppBarScrollBehavior pinnedScrollBehavior(TopAppBarState arg8, Function0 arg9, Composer arg10, int arg11, int arg12) {
        PinnedScrollBehavior v10_3;
        Object v9;
        Composer v4;
        int v0 = 286497075;
        ComposerKt.sourceInformationMarkerStart(arg10, v0, "C(pinnedScrollBehavior)N(state,canScroll)1692@83005L24,1693@83066L8,1695@83117L89:AppBar.kt#uh7d8r");
        if((arg12 & 1) != 0) {
            v4 = arg10;
            arg8 = AppBarKt.rememberTopAppBarState(0f, 0f, 0f, v4, 0, 7);
        }
        else {
            v4 = arg10;
        }

        String v10 = "CC(remember):AppBar.kt#9igjgp";
        if((arg12 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(v4, 0x1A922D1B, v10);
            Object v7 = v4.rememberedValue();
            if(v7 == Composer.Companion.getEmpty()) {
                TopAppBarDefaults$$ExternalSyntheticLambda2 v7_1 = new TopAppBarDefaults$$ExternalSyntheticLambda2();
                v4.updateRememberedValue(v7_1);
            }

            v9 = v7;
            ComposerKt.sourceInformationMarkerEnd(v4);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg11, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1695)");
        }

        ComposerKt.sourceInformationMarkerStart(v4, 0x1A9233CC, v10);
        int v10_1 = 0;
        arg12 = 4;
        int v7_2 = (arg11 & 14 ^ 6) > arg12 && (v4.changed(arg8)) || (arg11 & 6) == arg12 ? 1 : 0;
        int v1 = 0x20;
        if((arg11 & 0x70 ^ 0x30) > v1 && (v4.changed(v9)) || (arg11 & 0x30) == v1) {
            v10_1 = 1;
        }

        v7_2 |= v10_1;
        Object v10_2 = v4.rememberedValue();
        if(v7_2 != 0 || v10_2 == Composer.Companion.getEmpty()) {
            v10_3 = new PinnedScrollBehavior(arg8, ((Function0)v9));
            v4.updateRememberedValue(v10_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return ((TopAppBarScrollBehavior)v10_3);
    }

    static final boolean pinnedScrollBehavior$lambda$2$lambda$1() {
        return 1;
    }

    public final TopAppBarColors topAppBarColors(Composer arg4, int arg5) {
        int v1 = -1388520854;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(topAppBarColors)1444@72002L11:AppBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1444)");
        }

        TopAppBarColors v3 = this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final TopAppBarColors topAppBarColors-5tl4gsc(long arg17, long arg19, long arg21, long arg23, long arg25, long arg27, Composer arg29, int arg30, int arg31) {
        Composer v0 = arg29;
        int v2 = 0xB0FAE9C2;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color)1467@73186L11:AppBar.kt#uh7d8r");
        long v3 = (arg31 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v5 = (arg31 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        long v7 = (arg31 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg21;
        long v9 = (arg31 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg23;
        long v11 = (arg31 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg25;
        long v13 = (arg31 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg27;
        if(ComposerKt.isTraceInProgress()) {
            arg17 = v3;
            ComposerKt.traceEventStart(v2, arg30, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1467)");
        }
        else {
            arg17 = v3;
        }

        TopAppBarColors v1 = this.getDefaultTopAppBarColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-tNS2XkQ(arg17, v5, v7, v9, v11, v13);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility in favor of topAppBarColors with subtitleContentColor") public final TopAppBarColors topAppBarColors-zjMxDiM(long arg20, long arg22, long arg24, long arg26, long arg28, Composer arg30, int arg31, int arg32) {
        int v0 = arg31;
        int v2 = 0x7FBA5A6B;
        Composer v3 = arg30;
        ComposerKt.sourceInformationMarkerStart(v3, v2, "C(topAppBarColors)N(containerColor:c#ui.graphics.Color,scrolledContainerColor:c#ui.graphics.Color,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color)1499@74610L367:AppBar.kt#uh7d8r");
        long v4 = (arg32 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        long v6 = (arg32 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v8 = (arg32 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg24;
        long v10 = (arg32 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg26;
        long v12 = (arg32 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg28;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:1499)");
        }

        TopAppBarColors v0_1 = this.topAppBarColors-5tl4gsc(v4, v6, v8, v10, v12, v10, v3, 0xFFFE & v0 | v0 << 6 & 0x70000 | v0 << 3 & 0x380000, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg30);
        return v0_1;
    }
}

