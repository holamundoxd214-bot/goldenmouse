package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScopeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001A5\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u001C\u0010\u0004\u001A\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t\u001A1\u0010\n\u001A\u00020\u00012\"\u0010\u0004\u001A\u001E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000B¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\f\u001A\u0018\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0002\"\u0014\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u001A\u001A\u00020\u0013*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C\"\u0018\u0010\u001A\u001A\u00020\u0013*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001D\"&\u0010\u001E\u001A\u001A\u0012\u0004\u0012\u00020\u0017\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u001F0\u001FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2={"SharedTransitionLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SharedTransitionScope", "Lkotlin/Function2;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "DefaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Rect;", "ParentClip", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "VisualDebugging", "", "ScaleToBoundsCached", "Landroidx/compose/animation/ScaleToBoundsImpl;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "shouldCache", "getShouldCache", "(Landroidx/compose/ui/Alignment;)Z", "(Landroidx/compose/ui/layout/ContentScale;)Z", "cachedScaleToBoundsImplMap", "Landroidx/collection/MutableScatterMap;", "animation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SharedTransitionScopeKt {
    private static final SpringSpec DefaultSpring = null;
    private static final OverlayClip ParentClip = null;
    public static final boolean VisualDebugging = false;
    private static final MutableScatterMap cachedScaleToBoundsImplMap;

    static {
        SharedTransitionScopeKt.DefaultSpring = AnimationSpecKt.spring$default(0f, 400f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.Companion), 1, null);
        SharedTransitionScopeKt.ParentClip = new SharedTransitionScopeKt$ParentClip$1();
        SharedTransitionScopeKt.cachedScaleToBoundsImplMap = new MutableScatterMap(0, 1, null);
    }

    private static final ScaleToBoundsImpl ScaleToBoundsCached(ContentScale arg5, Alignment arg6) {
        ScaleToBoundsImpl v0_2;
        if((SharedTransitionScopeKt.getShouldCache(arg5)) && (SharedTransitionScopeKt.getShouldCache(arg6))) {
            MutableScatterMap v0 = SharedTransitionScopeKt.cachedScaleToBoundsImplMap;
            Object v1 = v0.get(arg5);
            if(v1 == null) {
                MutableScatterMap v1_1 = new MutableScatterMap(0, 1, null);
                v0.set(arg5, v1_1);
            }

            Object v0_1 = ((MutableScatterMap)v1).get(arg6);
            if(v0_1 == null) {
                v0_2 = new ScaleToBoundsImpl(arg5, arg6);
                ((MutableScatterMap)v1).set(arg6, v0_2);
            }

            return v0_2;
        }

        return new ScaleToBoundsImpl(arg5, arg6);
    }

    public static final void SharedTransitionLayout(Modifier arg6, Function3 arg7, Composer arg8, int arg9, int arg10) {
        Companion v6;
        int v2;
        int v0 = 0x2686F612;
        arg8 = arg8.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg8, "C(SharedTransitionLayout)P(1)121@5979L279,121@5957L301:SharedTransitionScope.kt#xbi5r1");
        int v1 = arg10 & 1;
        if(v1 != 0) {
            v2 = arg9 | 6;
        }
        else if((arg9 & 6) == 0) {
            v2 = arg8.changed(arg6) ? 4 : 2;
            v2 |= arg9;
        }
        else {
            v2 = arg9;
        }

        if((arg9 & 0x30) == 0) {
            int v3 = arg8.changedInstance(arg7) ? 0x20 : 16;
            v2 |= v3;
        }

        boolean v3_1 = (v2 & 19) != 18 ? true : false;
        if(arg8.shouldExecute(v3_1, v2 & 1)) {
            if(v1 != 0) {
                v6 = Modifier.Companion;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:120)");
            }

            SharedTransitionScopeKt.SharedTransitionScope(ComposableLambdaKt.rememberComposableLambda(1948801580, true, new SharedTransitionScopeKt$SharedTransitionLayout$1(((Modifier)v6), arg7), arg8, 54), arg8, 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_55;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg8.skipToGroupEnd();
        }

    label_55:
        ScopeUpdateScope v8 = arg8.endRestartGroup();
        if(v8 != null) {
            v8.updateScope(new SharedTransitionScopeKt$SharedTransitionLayout$2(((Modifier)v6), arg7, arg9, arg10));
        }
    }

    public static final void SharedTransitionScope(Function4 arg5, Composer arg6, int arg7) {
        int v1;
        int v0 = 1908320054;
        arg6 = arg6.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg6, "C(SharedTransitionScope)143@7122L231,143@7107L246:SharedTransitionScope.kt#xbi5r1");
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:142)");
            }

            LookaheadScopeKt.LookaheadScope(ComposableLambdaKt.rememberComposableLambda(0x7AF4A235, true, new SharedTransitionScopeKt$SharedTransitionScope$1(arg5), arg6, 54), arg6, 6);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_41;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg6.skipToGroupEnd();
        }

    label_41:
        ScopeUpdateScope v6 = arg6.endRestartGroup();
        if(v6 != null) {
            v6.updateScope(new SharedTransitionScopeKt$SharedTransitionScope$2(arg5, arg7));
        }
    }

    public static final ScaleToBoundsImpl access$ScaleToBoundsCached(ContentScale arg0, Alignment arg1) {
        return SharedTransitionScopeKt.ScaleToBoundsCached(arg0, arg1);
    }

    public static final SpringSpec access$getDefaultSpring$p() {
        return SharedTransitionScopeKt.DefaultSpring;
    }

    public static final OverlayClip access$getParentClip$p() {
        return SharedTransitionScopeKt.ParentClip;
    }

    private static final boolean getShouldCache(ContentScale arg1) {
        if(arg1 != ContentScale.Companion.getFillWidth() && arg1 != ContentScale.Companion.getFillHeight() && arg1 != ContentScale.Companion.getFillBounds() && arg1 != ContentScale.Companion.getFit() && arg1 != ContentScale.Companion.getCrop() && arg1 != ContentScale.Companion.getNone()) {
            if(arg1 == ContentScale.Companion.getInside()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean getShouldCache(Alignment arg1) {
        if(arg1 != Alignment.Companion.getTopStart() && arg1 != Alignment.Companion.getTopCenter() && arg1 != Alignment.Companion.getTopEnd() && arg1 != Alignment.Companion.getCenterStart() && arg1 != Alignment.Companion.getCenter() && arg1 != Alignment.Companion.getCenterEnd() && arg1 != Alignment.Companion.getBottomStart() && arg1 != Alignment.Companion.getBottomCenter()) {
            if(arg1 == Alignment.Companion.getBottomEnd()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

