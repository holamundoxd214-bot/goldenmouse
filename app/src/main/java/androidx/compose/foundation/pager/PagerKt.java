package androidx.compose.foundation.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition$Start;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000\u009C\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\u001Aë\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00132%\b\u0002\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00162\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 21\u0010!\u001A-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b\'\u0010(\u001Aß\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00132%\b\u0002\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00162\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E21\u0010!\u001A-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b)\u0010*\u001Aë\u0001\u0010+\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00132%\b\u0002\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00162\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010 21\u0010!\u001A-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b.\u0010/\u001Aß\u0001\u0010+\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00132%\b\u0002\u0010\u0015\u001A\u001F\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001A\u0018\u00010\u00162\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E21\u0010!\u001A-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u000B¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0007¢\u0006\u0004\b0\u00101\u001AL\u00102\u001A\u00020\u000B*\u00020\u001E2\u0006\u00103\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u000B2\u0006\u00104\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000B2\u0006\u00106\u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u000B2\u0006\u00108\u001A\u0002092\u0006\u0010:\u001A\u00020\u000BH\u0000\u001A,\u0010;\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010<\u001A\u00020\u00132\u0006\u0010=\u001A\u00020>2\u0006\u0010\u0012\u001A\u00020\u0013H\u0000\u001A\u0017\u0010?\u001A\u00020\u00012\f\u0010@\u001A\b\u0012\u0004\u0012\u00020B0AH\u0082\b¨\u0006C"}, d2={"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PagerKt {
    public static boolean $r8$lambda$8sNgzGCzF0cVp4fQcMsW-OAthf4(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$lambda$0$0(arg0, arg1);
    }

    public static boolean $r8$lambda$Fvlby3bMwqYbr6IwEgR2xz0QVvo(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$lambda$0$2(arg0, arg1);
    }

    public static boolean $r8$lambda$NBKKtOo1VW1i3N2lrKTPPwAwINw(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$lambda$0$1(arg0, arg1);
    }

    public static boolean $r8$lambda$XhwI_upOB6DzkYOEzjff_hbszmQ(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$lambda$0$3(arg0, arg1);
    }

    public static final void HorizontalPager--8jOkeI(PagerState arg36, Modifier arg37, PaddingValues arg38, PageSize arg39, int arg40, float arg41, Vertical arg42, TargetedFlingBehavior arg43, boolean arg44, boolean arg45, Function1 arg46, NestedScrollConnection arg47, SnapPosition arg48, OverscrollEffect arg49, Function4 arg50, Composer arg51, int arg52, int arg53, int arg54) {
        Modifier v2_4;
        PaddingValues v3_2;
        boolean v10_3;
        SnapPosition v13_2;
        PageSize v4_4;
        Function1 v11_2;
        NestedScrollConnection v12_2;
        Vertical v7_4;
        OverscrollEffect v14_1;
        float v6_2;
        boolean v9_2;
        TargetedFlingBehavior v8_3;
        TargetedFlingBehavior v5_1;
        int v8_1;
        OverscrollEffect v7_1;
        boolean v6_1;
        PaddingValues v2_3;
        Modifier v0_2;
        float v9_1;
        Composer v17_1;
        NestedScrollConnection v11_1;
        Function1 v12_1;
        boolean v3;
        Companion v0_4;
        Fill v10_2;
        Start v15_2;
        Start v7_2;
        NestedScrollConnection v3_1;
        Fill v16_1;
        Companion v19_1;
        int v33;
        Function1 v2_2;
        int v19;
        int v32;
        int v30;
        TargetedFlingBehavior v15;
        int v29;
        Vertical v14;
        int v27;
        float v7;
        int v24;
        int v5;
        int v20;
        int v16;
        int v13;
        Modifier v8;
        int v0;
        PagerState v1 = arg36;
        int v9 = arg52;
        int v10 = arg53;
        int v11 = arg54;
        Composer v6 = arg51.startRestartGroup(1860873769);
        ComposerKt.sourceInformation(v6, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)131@7501L707:Pager.kt#g6yjnt");
        if((v9 & 6) == 0) {
            v0 = v6.changed(v1) ? 4 : 2;
            v0 |= v9;
        }
        else {
            v0 = v9;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v0 |= 0x30;
            goto label_33;
        }
        else if((v9 & 0x30) == 0) {
            v8 = arg37;
            v13 = v6.changed(v8) ? 0x20 : 16;
            v0 |= v13;
        }
        else {
        label_33:
            v8 = arg37;
        }

        v13 = v11 & 4;
        if(v13 != 0) {
            v0 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v16 = v6.changed(arg38) ? 0x100 : 0x80;
            v0 |= v16;
        }

        v16 = v11 & 8;
        int v17 = 0x400;
        int v18 = 0x800;
        if(v16 != 0) {
            v0 |= 0xC00;
        }
        else if((v9 & 0xC00) == 0) {
            v20 = v6.changed(arg39) ? v18 : v17;
            v0 |= v20;
        }

        v20 = v11 & 16;
        int v21 = 0x4000;
        int v22 = 0x2000;
        if(v20 != 0) {
            v0 |= 0x6000;
            goto label_82;
        }
        else if((v9 & 0x6000) == 0) {
            v5 = arg40;
            v24 = v6.changed(v5) ? v21 : v22;
            v0 |= v24;
        }
        else {
        label_82:
            v5 = arg40;
        }

        v24 = v11 & 0x20;
        int v25 = 0x30000;
        if(v24 != 0) {
            v0 |= v25;
            v7 = arg41;
        }
        else {
            v7 = arg41;
            if((v9 & v25) == 0) {
                v27 = v6.changed(v7) ? 0x20000 : 0x10000;
                v0 |= v27;
            }
        }

        v27 = v11 & 0x40;
        int v28 = 0x180000;
        if(v27 != 0) {
            v0 |= v28;
            v14 = arg42;
        }
        else {
            v14 = arg42;
            if((v9 & v28) == 0) {
                v29 = v6.changed(v14) ? 0x100000 : 0x80000;
                v0 |= v29;
            }
        }

        if((v9 & 0xC00000) == 0) {
            if((v11 & 0x80) == 0) {
                v15 = arg43;
                if(v6.changed(v15)) {
                    v30 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15 = arg43;
            label_124:
                v30 = 0x400000;
            }

            v0 |= v30;
        }
        else {
            v15 = arg43;
        }

        int v12 = v11 & 0x100;
        int v31 = 0x6000000;
        if(v12 != 0) {
            v0 |= v31;
        }
        else {
            boolean v2 = arg44;
            if((v9 & v31) == 0) {
                v31 = v6.changed(v2) ? 0x4000000 : 0x2000000;
                v0 |= v31;
            }
        }

        int v2_1 = v11 & 0x200;
        v31 = 0x30000000;
        if(v2_1 != 0) {
            v32 = v0 | v31;
            v31 = v2_1;
        }
        else {
            if((v9 & v31) == 0) {
                v31 = v2_1;
                v32 = v6.changed(arg45) ? 0x20000000 : 0x10000000;
                v0 |= v32;
            }
            else {
                v31 = v2_1;
            }

            v32 = v0;
        }

        v0 = v11 & 0x400;
        if(v0 != 0) {
            v19 = v10 | 6;
        }
        else {
            v2_2 = arg46;
            if((v10 & 6) == 0) {
                v19 = v6.changedInstance(v2_2) ? 4 : 2;
                v19 |= v10;
            }
            else {
                v19 = v10;
            }
        }

        if((v10 & 0x30) == 0) {
            v33 = v0;
            int v23 = (v11 & 0x800) != 0 || !v6.changedInstance(arg47) ? 16 : 0x20;
            v19 |= v23;
        }
        else {
            v33 = v0;
        }

        v0 = v19;
        v2_1 = v11 & 0x1000;
        if(v2_1 != 0) {
            v19 = v0 | 0x180;
        }
        else {
            v19 = v0;
            if((v10 & 0x180) == 0) {
                v29 = v6.changed(arg48) ? 0x100 : 0x80;
                v19 |= v29;
            }
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 0x2000) == 0 && (v6.changed(arg49))) {
                v17 = v18;
            }

            v19 |= v17;
        }

        if((v10 & 0x6000) == 0) {
            if(v6.changedInstance(arg50)) {
            }
            else {
                v21 = v22;
            }

            v19 |= v21;
        }

        v17 = v2_1;
        v2_1 = v19;
        boolean v18_1 = true;
        boolean v0_1 = (v32 & 306783379) != 306783378 || (v2_1 & 9363) != 9362 ? true : false;
        if(v6.shouldExecute(v0_1, v32 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "121@7026L28,126@7250L57,128@7404L26");
            if((v9 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v19_1 = Modifier.Companion;
                }
                else {
                    Modifier v19_2 = v8;
                }

                PaddingValues v13_1 = v13 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : arg38;
                if(v16 != 0) {
                    v16_1 = Fill.INSTANCE;
                }
                else {
                    PageSize v16_2 = arg39;
                }

                v20 = v20 != 0 ? 0 : v5;
                float v21_1 = v24 != 0 ? Dp.constructor-impl(0f) : v7;
                if(v27 != 0) {
                    v14 = Alignment.Companion.getCenterVertically();
                }

                if((v11 & 0x80) != 0) {
                    v22 = v17;
                    v17 = v2_1;
                    v1 = arg36;
                    TargetedFlingBehavior v0_3 = PagerDefaults.INSTANCE.flingBehavior(v1, null, null, null, 0f, v6, v32 & 14 | v25, 30);
                    v32 &= 0xFE3FFFFF;
                    v4 = 0;
                    v15 = v0_3;
                }
                else {
                    v1 = arg36;
                    v4 = 0;
                    v22 = v17;
                    v17 = v2_1;
                }

                if(v12 != 0) {
                }
                else {
                    v18_1 = arg44;
                }

                v0_1 = v31 != 0 ? ((boolean)v4) : arg45;
                v2_2 = v33 != 0 ? null : arg46;
                if((v11 & 0x800) != 0) {
                    v3_1 = PagerDefaults.INSTANCE.pageNestedScrollConnection(v1, Orientation.Horizontal, v6, v32 & 14 | 0x1B0);
                    v5 = v17 & 0xFFFFFF8F;
                }
                else {
                    v3_1 = arg47;
                    v5 = v17;
                }

                if(v22 != 0) {
                    v7_2 = Start.INSTANCE;
                }
                else {
                    SnapPosition v7_3 = arg48;
                }

                if((v11 & 0x2000) != 0) {
                    Start v8_2 = v7_2;
                    v7_1 = OverscrollKt.rememberOverscrollEffect(v6, v4);
                    v4 = v5 & 0xFFFFE3FF;
                    v5_1 = v15;
                    v15_2 = v8_2;
                    v12_1 = v2_2;
                    v11_1 = v3_1;
                    v17_1 = v6;
                    v2_3 = v13_1;
                    v10_2 = v16_1;
                    v6_1 = v18_1;
                    v8_1 = v20;
                    v9_1 = v21_1;
                    v13 = v32;
                    v3 = v0_1;
                    v0_4 = v19_1;
                    goto label_412;
                }

                v12_1 = v2_2;
                v11_1 = v3_1;
                v4 = v5;
                v17_1 = v6;
                v2_3 = v13_1;
                v5_1 = v15;
                v10_2 = v16_1;
                v6_1 = v18_1;
                v8_1 = v20;
                v9_1 = v21_1;
                v13 = v32;
                v3 = v0_1;
                v15_2 = v7_2;
                v0_4 = v19_1;
                v7_1 = arg49;
            }
            else {
                v6.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v32 &= 0xFE3FFFFF;
                }

                if((v11 & 0x800) != 0) {
                    v2_1 &= 0xFFFFFF8F;
                }

                if((v11 & 0x2000) != 0) {
                    v2_1 &= 0xFFFFE3FF;
                }

                PageSize v10_1 = arg39;
                v3 = arg45;
                v12_1 = arg46;
                v11_1 = arg47;
                v4 = v2_1;
                v17_1 = v6;
                v9_1 = v7;
                v0_2 = v8;
                v13 = v32;
                v2_3 = arg38;
                v6_1 = arg44;
                v7_1 = arg49;
                v8_1 = v5;
                v5_1 = v15;
                SnapPosition v15_1 = arg48;
            }

        label_412:
            v17_1.endDefaults();
            arg37 = v0_2;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1860873769, v13, v4, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:130)");
            }

            v16 = v13 >> 6;
            v18 = v13 << 12;
            v18 = v13 >> 3 & 14 | 0x6000 | v13 << 3 & 0x70 | v13 & 0x380 | v13 >> 18 & 0x1C00 | v16 & 0x70000 | v16 & 0x380000 | v4 << 12 & 0x1C00000 | v18 & 0xE000000 | v18 & 0x70000000;
            v0 = v13 >> 9 & 14 | 0xC00;
            v13 = v4 << 6;
            v19 = v0 | v4 & 0x70 | v13 & 0x380 | v16 & 0xE000 | v4 << 9 & 0x70000 | v13 & 0x380000;
            v0_2 = arg37;
            LazyLayoutPagerKt.Pager-eLwUrMk(v0_2, arg36, v2_3, v3, Orientation.Horizontal, v5_1, v6_1, v7_1, v8_1, v9_1, ((PageSize)v10_2), v11_1, v12_1, Alignment.Companion.getCenterHorizontally(), v14, ((SnapPosition)v15_2), arg50, v17_1, v18, v19, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v8_1;
            v8_3 = v5_1;
            v5 = v4;
            float v4_1 = v9_1;
            v9_2 = v6_1;
            v6_2 = v4_1;
            Vertical v4_2 = v14;
            v14_1 = v7_1;
            v7_4 = v4_2;
            Function1 v4_3 = v12_1;
            v12_2 = v11_1;
            v11_2 = v4_3;
            v4_4 = ((PageSize)v10_2);
            v13_2 = ((SnapPosition)v15_2);
            v10_3 = v3;
            v3_2 = v2_3;
            v2_4 = v0_2;
        }
        else {
            v17_1 = v6;
            v17_1.skipToGroupEnd();
            v3_2 = arg38;
            v4_4 = arg39;
            v9_2 = arg44;
            v10_3 = arg45;
            v11_2 = arg46;
            v12_2 = arg47;
            v13_2 = arg48;
            v6_2 = v7;
            v2_4 = v8;
            v7_4 = v14;
            v8_3 = v15;
            v14_1 = arg49;
        }

        ScopeUpdateScope v0_5 = v17_1.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new PagerKt$$ExternalSyntheticLambda8(arg36, v2_4, v3_2, v4_4, v5, v6_2, v7_4, v8_3, v9_2, v10_3, v11_2, v12_2, v13_2, v14_1, arg50, arg52, arg53, arg54));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void HorizontalPager-oI3XNZo(PagerState arg34, Modifier arg35, PaddingValues arg36, PageSize arg37, int arg38, float arg39, Vertical arg40, TargetedFlingBehavior arg41, boolean arg42, boolean arg43, Function1 arg44, NestedScrollConnection arg45, SnapPosition arg46, Function4 arg47, Composer arg48, int arg49, int arg50, int arg51) {
        Modifier v2_4;
        PaddingValues v3_3;
        PageSize v4_2;
        Vertical v7_2;
        TargetedFlingBehavior v8_2;
        boolean v10_2;
        Function1 v11_2;
        NestedScrollConnection v12_3;
        SnapPosition v13_2;
        PaddingValues v2_3;
        int v15_1;
        PageSize v3;
        Composer v6_1;
        TargetedFlingBehavior v7_1;
        Modifier v21_1;
        float v5_1;
        SnapPosition v12_1;
        NestedScrollConnection v11_1;
        Function1 v10_1;
        boolean v9_1;
        boolean v8_1;
        NestedScrollConnection v3_1;
        PageSize v16_2;
        Companion v21_2;
        int v31;
        Function1 v2_2;
        int v19;
        int v30;
        int v28;
        TargetedFlingBehavior v14;
        Vertical v13;
        int v25;
        float v6;
        int v22;
        int v5;
        int v20;
        int v16;
        int v8;
        Modifier v7;
        int v0;
        PagerState v1 = arg34;
        int v9 = arg49;
        int v10 = arg50;
        int v11 = arg51;
        Composer v15 = arg48.startRestartGroup(0x455EB26F);
        ComposerKt.sourceInformation(v15, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)185@9669L26,171@9116L621:Pager.kt#g6yjnt");
        if((v9 & 6) == 0) {
            v0 = v15.changed(v1) ? 4 : 2;
            v0 |= v9;
        }
        else {
            v0 = v9;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v0 |= 0x30;
            goto label_33;
        }
        else if((v9 & 0x30) == 0) {
            v7 = arg35;
            v8 = v15.changed(v7) ? 0x20 : 16;
            v0 |= v8;
        }
        else {
        label_33:
            v7 = arg35;
        }

        v8 = v11 & 4;
        if(v8 != 0) {
            v0 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v16 = v15.changed(arg36) ? 0x100 : 0x80;
            v0 |= v16;
        }

        v16 = v11 & 8;
        int v17 = 0x400;
        int v18 = 0x800;
        if(v16 != 0) {
            v0 |= 0xC00;
        }
        else if((v9 & 0xC00) == 0) {
            v20 = v15.changed(arg37) ? v18 : v17;
            v0 |= v20;
        }

        v20 = v11 & 16;
        if(v20 != 0) {
            v0 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v5 = arg38;
            v22 = v15.changed(v5) ? 0x4000 : 0x2000;
            v0 |= v22;
        }
        else {
        label_80:
            v5 = arg38;
        }

        v22 = v11 & 0x20;
        int v23 = 0x30000;
        if(v22 != 0) {
            v0 |= v23;
            v6 = arg39;
        }
        else {
            v6 = arg39;
            if((v9 & v23) == 0) {
                v25 = v15.changed(v6) ? 0x20000 : 0x10000;
                v0 |= v25;
            }
        }

        v25 = v11 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v0 |= v26;
            v13 = arg40;
        }
        else {
            v13 = arg40;
            if((v9 & v26) == 0) {
                int v27 = v15.changed(v13) ? 0x100000 : 0x80000;
                v0 |= v27;
            }
        }

        if((v9 & 0xC00000) == 0) {
            if((v11 & 0x80) == 0) {
                v14 = arg41;
                if(v15.changed(v14)) {
                    v28 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v14 = arg41;
            label_122:
                v28 = 0x400000;
            }

            v0 |= v28;
        }
        else {
            v14 = arg41;
        }

        int v12 = v11 & 0x100;
        int v29 = 0x6000000;
        if(v12 != 0) {
            v0 |= v29;
        }
        else {
            boolean v2 = arg42;
            if((v9 & v29) == 0) {
                v29 = v15.changed(v2) ? 0x4000000 : 0x2000000;
                v0 |= v29;
            }
        }

        int v2_1 = v11 & 0x200;
        v29 = 0x30000000;
        if(v2_1 != 0) {
            v30 = v0 | v29;
            v29 = v2_1;
        }
        else {
            if((v9 & v29) == 0) {
                v29 = v2_1;
                v30 = v15.changed(arg43) ? 0x20000000 : 0x10000000;
                v0 |= v30;
            }
            else {
                v29 = v2_1;
            }

            v30 = v0;
        }

        v0 = v11 & 0x400;
        if(v0 != 0) {
            v19 = v10 | 6;
        }
        else {
            v2_2 = arg44;
            if((v10 & 6) == 0) {
                v19 = v15.changedInstance(v2_2) ? 4 : 2;
                v19 |= v10;
            }
            else {
                v19 = v10;
            }
        }

        if((v10 & 0x30) == 0) {
            v31 = v0;
            int v21 = (v11 & 0x800) != 0 || !v15.changedInstance(arg45) ? 16 : 0x20;
            v19 |= v21;
        }
        else {
            v31 = v0;
        }

        v0 = v19;
        v2_1 = v11 & 0x1000;
        if(v2_1 != 0) {
            v19 = v0 | 0x180;
        }
        else {
            v19 = v0;
            if((v10 & 0x180) == 0) {
                v26 = v15.changed(arg46) ? 0x100 : 0x80;
                v19 |= v26;
            }
        }

        if((v10 & 0xC00) == 0) {
            if(v15.changedInstance(arg47)) {
                v17 = v18;
            }

            v19 |= v17;
        }

        v17 = v2_1;
        v2_1 = v19;
        boolean v18_1 = true;
        boolean v0_1 = (v30 & 306783379) != 306783378 || (v2_1 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v0_1, v30 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "162@8711L28,167@8935L57");
            v19 = 0xFE3FFFFF;
            if((v9 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v21_2 = Modifier.Companion;
                }
                else {
                    v21_1 = v7;
                }

                PaddingValues v24 = v8 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : arg36;
                if(v16 != 0) {
                    Fill v16_1 = Fill.INSTANCE;
                }
                else {
                    v16_2 = arg37;
                }

                v20 = v20 != 0 ? 0 : v5;
                float v22_1 = v22 != 0 ? Dp.constructor-impl(0f) : v6;
                if(v25 != 0) {
                    v13 = Alignment.Companion.getCenterVertically();
                }

                if((v11 & 0x80) != 0) {
                    v6_1 = v15;
                    v15_1 = v2_1;
                    v1 = arg34;
                    TargetedFlingBehavior v0_2 = PagerDefaults.INSTANCE.flingBehavior(v1, null, null, null, 0f, v6_1, v30 & 14 | v23, 30);
                    v30 &= v19;
                    v4 = 0;
                    v14 = v0_2;
                }
                else {
                    v1 = arg34;
                    v4 = 0;
                    v6_1 = v15;
                    v15_1 = v2_1;
                }

                if(v12 != 0) {
                }
                else {
                    v18_1 = arg42;
                }

                v0_1 = v29 != 0 ? ((boolean)v4) : arg43;
                v2_2 = v31 != 0 ? null : arg44;
                if((v11 & 0x800) != 0) {
                    v3_1 = PagerDefaults.INSTANCE.pageNestedScrollConnection(v1, Orientation.Horizontal, v6_1, v30 & 14 | 0x1B0);
                    v15_1 &= 0xFFFFFF8F;
                }
                else {
                    v3_1 = arg45;
                }

                if(v17 != 0) {
                    v9_1 = v0_1;
                    v10_1 = v2_2;
                    v11_1 = v3_1;
                    Start v12_2 = Start.INSTANCE;
                }
                else {
                    v12_1 = arg46;
                    v9_1 = v0_1;
                    v10_1 = v2_2;
                    v11_1 = v3_1;
                }

                v7_1 = v14;
                Fill v3_2 = ((Fill)v16_2);
                v8_1 = v18_1;
                v5_1 = v22_1;
                v2_3 = v24;
                v0 = v30;
            }
            else {
                v15.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v30 &= v19;
                }

                if((v11 & 0x800) != 0) {
                    v2_1 &= 0xFFFFFF8F;
                }

                v1 = arg34;
                v8_1 = arg42;
                v9_1 = arg43;
                v10_1 = arg44;
                v11_1 = arg45;
                v12_1 = arg46;
                v4 = 0;
                v20 = v5;
                v5_1 = v6;
                v21_1 = v7;
                v7_1 = v14;
                v6_1 = v15;
                v0 = v30;
                v3 = arg37;
                v15_1 = v2_1;
                v2_3 = arg36;
            }

            v6_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x455EB26F, v0, v15_1, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:170)");
                v4 = 0;
            }

            OverscrollEffect v4_1 = OverscrollKt.rememberOverscrollEffect(v6_1, v4);
            v16 = v0 & 0x7FFFFFFE;
            v17 = v15_1 & 0x3FE | v15_1 << 3 & 0xE000;
            PagerState v0_3 = v1;
            v15 = v6_1;
            Vertical v6_2 = v13;
            Modifier v1_1 = ((Modifier)v21_2);
            OverscrollEffect v13_1 = v4_1;
            v4 = v20;
            PagerKt.HorizontalPager--8jOkeI(v0_3, v1_1, v2_3, v3, v4, v5_1, v6_2, v7_1, v8_1, v9_1, v10_1, v11_1, v12_1, v13_1, arg47, v15, v16, v17, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v13_2 = v12_1;
            v12_3 = v11_1;
            v11_2 = v10_1;
            v10_2 = v9_1;
            v9_1 = v8_1;
            v8_2 = v7_1;
            v7_2 = v6_2;
            v6 = v5_1;
            v5 = v4;
            v4_2 = v3;
            v3_3 = v2_3;
            v2_4 = v1_1;
        }
        else {
            v15.skipToGroupEnd();
            v3_3 = arg36;
            v4_2 = arg37;
            v9_1 = arg42;
            v10_2 = arg43;
            v11_2 = arg44;
            v12_3 = arg45;
            v2_4 = v7;
            v7_2 = v13;
            v8_2 = v14;
            v13_2 = arg46;
        }

        ScopeUpdateScope v0_4 = v15.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new PagerKt$$ExternalSyntheticLambda7(arg34, v2_4, v3_3, v4_2, v5, v6, v7_2, v8_2, v9_1, v10_2, v11_2, v12_3, v13_2, arg47, arg49, arg50, arg51));
        }
    }

    static final Unit HorizontalPager__8jOkeI$lambda$0(PagerState arg20, Modifier arg21, PaddingValues arg22, PageSize arg23, int arg24, float arg25, Vertical arg26, TargetedFlingBehavior arg27, boolean arg28, boolean arg29, Function1 arg30, NestedScrollConnection arg31, SnapPosition arg32, OverscrollEffect arg33, Function4 arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        PagerKt.HorizontalPager--8jOkeI(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    static final Unit HorizontalPager_oI3XNZo$lambda$0(PagerState arg19, Modifier arg20, PaddingValues arg21, PageSize arg22, int arg23, float arg24, Vertical arg25, TargetedFlingBehavior arg26, boolean arg27, boolean arg28, Function1 arg29, NestedScrollConnection arg30, SnapPosition arg31, Function4 arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        PagerKt.HorizontalPager-oI3XNZo(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    public static final void VerticalPager--8jOkeI(PagerState arg36, Modifier arg37, PaddingValues arg38, PageSize arg39, int arg40, float arg41, Horizontal arg42, TargetedFlingBehavior arg43, boolean arg44, boolean arg45, Function1 arg46, NestedScrollConnection arg47, SnapPosition arg48, OverscrollEffect arg49, Function4 arg50, Composer arg51, int arg52, int arg53, int arg54) {
        Modifier v2_4;
        PaddingValues v3_2;
        boolean v10_3;
        SnapPosition v13_3;
        Horizontal v7_4;
        PageSize v4_3;
        OverscrollEffect v14_2;
        Function1 v11_2;
        NestedScrollConnection v12_2;
        float v6_2;
        boolean v9_2;
        TargetedFlingBehavior v8_3;
        SnapPosition v15_1;
        TargetedFlingBehavior v5_1;
        int v8_1;
        OverscrollEffect v7_1;
        boolean v6_1;
        PaddingValues v2_3;
        int v14_1;
        Horizontal v13_1;
        Modifier v0_2;
        float v9_1;
        Composer v17_1;
        NestedScrollConnection v11_1;
        Function1 v12_1;
        boolean v3;
        PageSize v10_1;
        Companion v0_4;
        Fill v10_2;
        Start v15_2;
        Start v7_2;
        NestedScrollConnection v3_1;
        Fill v16_1;
        Companion v19_1;
        int v33;
        Function1 v2_2;
        int v19;
        int v32;
        int v30;
        TargetedFlingBehavior v15;
        int v29;
        Horizontal v14;
        int v27;
        float v7;
        int v24;
        int v5;
        int v20;
        int v16;
        int v13;
        Modifier v8;
        int v0;
        PagerState v1 = arg36;
        int v9 = arg52;
        int v10 = arg53;
        int v11 = arg54;
        Composer v6 = arg51.startRestartGroup(-1590376023);
        ComposerKt.sourceInformation(v6, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)261@14430L705:Pager.kt#g6yjnt");
        if((v9 & 6) == 0) {
            v0 = v6.changed(v1) ? 4 : 2;
            v0 |= v9;
        }
        else {
            v0 = v9;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v0 |= 0x30;
            goto label_33;
        }
        else if((v9 & 0x30) == 0) {
            v8 = arg37;
            v13 = v6.changed(v8) ? 0x20 : 16;
            v0 |= v13;
        }
        else {
        label_33:
            v8 = arg37;
        }

        v13 = v11 & 4;
        if(v13 != 0) {
            v0 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v16 = v6.changed(arg38) ? 0x100 : 0x80;
            v0 |= v16;
        }

        v16 = v11 & 8;
        int v17 = 0x400;
        int v18 = 0x800;
        if(v16 != 0) {
            v0 |= 0xC00;
        }
        else if((v9 & 0xC00) == 0) {
            v20 = v6.changed(arg39) ? v18 : v17;
            v0 |= v20;
        }

        v20 = v11 & 16;
        int v21 = 0x4000;
        int v22 = 0x2000;
        if(v20 != 0) {
            v0 |= 0x6000;
            goto label_82;
        }
        else if((v9 & 0x6000) == 0) {
            v5 = arg40;
            v24 = v6.changed(v5) ? v21 : v22;
            v0 |= v24;
        }
        else {
        label_82:
            v5 = arg40;
        }

        v24 = v11 & 0x20;
        int v25 = 0x30000;
        if(v24 != 0) {
            v0 |= v25;
            v7 = arg41;
        }
        else {
            v7 = arg41;
            if((v9 & v25) == 0) {
                v27 = v6.changed(v7) ? 0x20000 : 0x10000;
                v0 |= v27;
            }
        }

        v27 = v11 & 0x40;
        int v28 = 0x180000;
        if(v27 != 0) {
            v0 |= v28;
            v14 = arg42;
        }
        else {
            v14 = arg42;
            if((v9 & v28) == 0) {
                v29 = v6.changed(v14) ? 0x100000 : 0x80000;
                v0 |= v29;
            }
        }

        if((v9 & 0xC00000) == 0) {
            if((v11 & 0x80) == 0) {
                v15 = arg43;
                if(v6.changed(v15)) {
                    v30 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15 = arg43;
            label_124:
                v30 = 0x400000;
            }

            v0 |= v30;
        }
        else {
            v15 = arg43;
        }

        int v12 = v11 & 0x100;
        int v31 = 0x6000000;
        if(v12 != 0) {
            v0 |= v31;
        }
        else {
            boolean v2 = arg44;
            if((v9 & v31) == 0) {
                v31 = v6.changed(v2) ? 0x4000000 : 0x2000000;
                v0 |= v31;
            }
        }

        int v2_1 = v11 & 0x200;
        v31 = 0x30000000;
        if(v2_1 != 0) {
            v32 = v0 | v31;
            v31 = v2_1;
        }
        else {
            if((v9 & v31) == 0) {
                v31 = v2_1;
                v32 = v6.changed(arg45) ? 0x20000000 : 0x10000000;
                v0 |= v32;
            }
            else {
                v31 = v2_1;
            }

            v32 = v0;
        }

        v0 = v11 & 0x400;
        if(v0 != 0) {
            v19 = v10 | 6;
        }
        else {
            v2_2 = arg46;
            if((v10 & 6) == 0) {
                v19 = v6.changedInstance(v2_2) ? 4 : 2;
                v19 |= v10;
            }
            else {
                v19 = v10;
            }
        }

        if((v10 & 0x30) == 0) {
            v33 = v0;
            int v23 = (v11 & 0x800) != 0 || !v6.changedInstance(arg47) ? 16 : 0x20;
            v19 |= v23;
        }
        else {
            v33 = v0;
        }

        v0 = v19;
        v2_1 = v11 & 0x1000;
        if(v2_1 != 0) {
            v19 = v0 | 0x180;
        }
        else {
            v19 = v0;
            if((v10 & 0x180) == 0) {
                v29 = v6.changed(arg48) ? 0x100 : 0x80;
                v19 |= v29;
            }
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 0x2000) == 0 && (v6.changed(arg49))) {
                v17 = v18;
            }

            v19 |= v17;
        }

        if((v10 & 0x6000) == 0) {
            if(v6.changedInstance(arg50)) {
            }
            else {
                v21 = v22;
            }

            v19 |= v21;
        }

        v17 = v2_1;
        v2_1 = v19;
        boolean v18_1 = true;
        boolean v0_1 = (v32 & 306783379) != 306783378 || (v2_1 & 9363) != 9362 ? true : false;
        if(v6.shouldExecute(v0_1, v32 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "251@13957L28,256@14181L55,258@14333L26");
            if((v9 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v19_1 = Modifier.Companion;
                }
                else {
                    Modifier v19_2 = v8;
                }

                PaddingValues v13_2 = v13 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : arg38;
                if(v16 != 0) {
                    v16_1 = Fill.INSTANCE;
                }
                else {
                    PageSize v16_2 = arg39;
                }

                v20 = v20 != 0 ? 0 : v5;
                float v21_1 = v24 != 0 ? Dp.constructor-impl(0f) : v7;
                if(v27 != 0) {
                    v14 = Alignment.Companion.getCenterHorizontally();
                }

                if((v11 & 0x80) != 0) {
                    v22 = v17;
                    v17 = v2_1;
                    v1 = arg36;
                    TargetedFlingBehavior v0_3 = PagerDefaults.INSTANCE.flingBehavior(v1, null, null, null, 0f, v6, v32 & 14 | v25, 30);
                    v32 &= 0xFE3FFFFF;
                    v4 = 0;
                    v15 = v0_3;
                }
                else {
                    v1 = arg36;
                    v4 = 0;
                    v22 = v17;
                    v17 = v2_1;
                }

                if(v12 != 0) {
                }
                else {
                    v18_1 = arg44;
                }

                v0_1 = v31 != 0 ? ((boolean)v4) : arg45;
                v2_2 = v33 != 0 ? null : arg46;
                if((v11 & 0x800) != 0) {
                    v3_1 = PagerDefaults.INSTANCE.pageNestedScrollConnection(v1, Orientation.Vertical, v6, v32 & 14 | 0x1B0);
                    v5 = v17 & 0xFFFFFF8F;
                }
                else {
                    v3_1 = arg47;
                    v5 = v17;
                }

                if(v22 != 0) {
                    v7_2 = Start.INSTANCE;
                }
                else {
                    SnapPosition v7_3 = arg48;
                }

                if((v11 & 0x2000) != 0) {
                    Start v8_2 = v7_2;
                    v7_1 = OverscrollKt.rememberOverscrollEffect(v6, v4);
                    v4 = v5 & 0xFFFFE3FF;
                    v5_1 = v15;
                    v15_2 = v8_2;
                    v12_1 = v2_2;
                    v11_1 = v3_1;
                    v17_1 = v6;
                    v2_3 = v13_2;
                    v13_1 = v14;
                    v10_2 = v16_1;
                    v6_1 = v18_1;
                    v8_1 = v20;
                    v9_1 = v21_1;
                    v14_1 = v32;
                    v3 = v0_1;
                    v0_4 = v19_1;
                    goto label_415;
                }

                v12_1 = v2_2;
                v11_1 = v3_1;
                v4 = v5;
                v17_1 = v6;
                v2_3 = v13_2;
                v13_1 = v14;
                v5_1 = v15;
                v10_2 = v16_1;
                v6_1 = v18_1;
                v8_1 = v20;
                v9_1 = v21_1;
                v14_1 = v32;
                v3 = v0_1;
                v15_2 = v7_2;
                v0_4 = v19_1;
                v7_1 = arg49;
            }
            else {
                v6.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v32 &= 0xFE3FFFFF;
                }

                if((v11 & 0x800) != 0) {
                    v2_1 &= 0xFFFFFF8F;
                }

                if((v11 & 0x2000) != 0) {
                    v2_1 &= 0xFFFFE3FF;
                }

                v10_1 = arg39;
                v3 = arg45;
                v12_1 = arg46;
                v11_1 = arg47;
                v4 = v2_1;
                v17_1 = v6;
                v9_1 = v7;
                v0_2 = v8;
                v13_1 = v14;
                v14_1 = v32;
                v2_3 = arg38;
                v6_1 = arg44;
                v7_1 = arg49;
                v8_1 = v5;
                v5_1 = v15;
                v15_1 = arg48;
            }

        label_415:
            v17_1.endDefaults();
            arg37 = v0_2;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1590376023, v14_1, v4, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:260)");
            }

            v16 = v14_1 >> 6;
            v0 = v14_1 >> 3 & 14 | 0x6000 | v14_1 << 3 & 0x70 | v14_1 & 0x380 | v14_1 >> 18 & 0x1C00 | v16 & 0x70000 | v16 & 0x380000;
            v16 = v14_1 << 12;
            v18 = v0 | v4 << 12 & 0x1C00000 | v16 & 0xE000000 | v16 & 0x70000000;
            v0 = v14_1 >> 9;
            int v1_1 = v4 << 6;
            v19 = v0 & 0x1C00 | (v1_1 & 0x380 | (v0 & 14 | 0x6000 | v4 & 0x70)) | v4 << 9 & 0x70000 | v1_1 & 0x380000;
            v0_2 = arg37;
            v2_3 = v2_3;
            LazyLayoutPagerKt.Pager-eLwUrMk(v0_2, arg36, v2_3, v3, Orientation.Vertical, v5_1, v6_1, v7_1, v8_1, v9_1, v10_1, v11_1, v12_1, v13_1, Alignment.Companion.getCenterVertically(), v15_1, arg50, v17_1, v18, v19, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v8_1;
            v8_3 = v5_1;
            v5 = v4;
            float v4_1 = v9_1;
            v9_2 = v6_1;
            v6_2 = v4_1;
            Function1 v4_2 = v12_1;
            v12_2 = v11_1;
            v11_2 = v4_2;
            v14_2 = v7_1;
            v4_3 = v10_1;
            v7_4 = v13_1;
            v13_3 = v15_1;
            v10_3 = v3;
            v3_2 = v2_3;
            v2_4 = v0_2;
        }
        else {
            v17_1 = v6;
            v17_1.skipToGroupEnd();
            v3_2 = arg38;
            v4_3 = arg39;
            v9_2 = arg44;
            v10_3 = arg45;
            v11_2 = arg46;
            v12_2 = arg47;
            v13_3 = arg48;
            v6_2 = v7;
            v2_4 = v8;
            v7_4 = v14;
            v8_3 = v15;
            v14_2 = arg49;
        }

        ScopeUpdateScope v0_5 = v17_1.endRestartGroup();
        if(v0_5 != null) {
            v0_5.updateScope(new PagerKt$$ExternalSyntheticLambda6(arg36, v2_4, v3_2, v4_3, v5, v6_2, v7_4, v8_3, v9_2, v10_3, v11_2, v12_2, v13_3, v14_2, arg50, arg52, arg53, arg54));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void VerticalPager-oI3XNZo(PagerState arg34, Modifier arg35, PaddingValues arg36, PageSize arg37, int arg38, float arg39, Horizontal arg40, TargetedFlingBehavior arg41, boolean arg42, boolean arg43, Function1 arg44, NestedScrollConnection arg45, SnapPosition arg46, Function4 arg47, Composer arg48, int arg49, int arg50, int arg51) {
        Modifier v2_4;
        PaddingValues v3_3;
        PageSize v4_2;
        Horizontal v7_2;
        TargetedFlingBehavior v8_2;
        boolean v10_2;
        Function1 v11_2;
        NestedScrollConnection v12_3;
        SnapPosition v13_2;
        PaddingValues v2_3;
        int v15_1;
        Composer v6_1;
        TargetedFlingBehavior v7_1;
        Modifier v21_1;
        float v5_1;
        SnapPosition v12_1;
        NestedScrollConnection v11_1;
        Function1 v10_1;
        boolean v9_1;
        boolean v8_1;
        Fill v3_2;
        Start v12_2;
        NestedScrollConnection v3_1;
        Fill v16_1;
        Companion v21_2;
        int v31;
        Function1 v2_2;
        int v19;
        int v30;
        int v28;
        TargetedFlingBehavior v14;
        Horizontal v13;
        int v25;
        float v6;
        int v22;
        int v5;
        int v20;
        int v16;
        int v8;
        Modifier v7;
        int v0;
        PagerState v1 = arg34;
        int v9 = arg49;
        int v10 = arg50;
        int v11 = arg51;
        Composer v15 = arg48.startRestartGroup(-1474550033);
        ComposerKt.sourceInformation(v15, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)315@16600L26,301@16045L623:Pager.kt#g6yjnt");
        if((v9 & 6) == 0) {
            v0 = v15.changed(v1) ? 4 : 2;
            v0 |= v9;
        }
        else {
            v0 = v9;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v0 |= 0x30;
            goto label_33;
        }
        else if((v9 & 0x30) == 0) {
            v7 = arg35;
            v8 = v15.changed(v7) ? 0x20 : 16;
            v0 |= v8;
        }
        else {
        label_33:
            v7 = arg35;
        }

        v8 = v11 & 4;
        if(v8 != 0) {
            v0 |= 0x180;
        }
        else if((v9 & 0x180) == 0) {
            v16 = v15.changed(arg36) ? 0x100 : 0x80;
            v0 |= v16;
        }

        v16 = v11 & 8;
        int v17 = 0x400;
        int v18 = 0x800;
        if(v16 != 0) {
            v0 |= 0xC00;
        }
        else if((v9 & 0xC00) == 0) {
            v20 = v15.changed(arg37) ? v18 : v17;
            v0 |= v20;
        }

        v20 = v11 & 16;
        if(v20 != 0) {
            v0 |= 0x6000;
            goto label_80;
        }
        else if((v9 & 0x6000) == 0) {
            v5 = arg38;
            v22 = v15.changed(v5) ? 0x4000 : 0x2000;
            v0 |= v22;
        }
        else {
        label_80:
            v5 = arg38;
        }

        v22 = v11 & 0x20;
        int v23 = 0x30000;
        if(v22 != 0) {
            v0 |= v23;
            v6 = arg39;
        }
        else {
            v6 = arg39;
            if((v9 & v23) == 0) {
                v25 = v15.changed(v6) ? 0x20000 : 0x10000;
                v0 |= v25;
            }
        }

        v25 = v11 & 0x40;
        int v26 = 0x180000;
        if(v25 != 0) {
            v0 |= v26;
            v13 = arg40;
        }
        else {
            v13 = arg40;
            if((v9 & v26) == 0) {
                int v27 = v15.changed(v13) ? 0x100000 : 0x80000;
                v0 |= v27;
            }
        }

        if((v9 & 0xC00000) == 0) {
            if((v11 & 0x80) == 0) {
                v14 = arg41;
                if(v15.changed(v14)) {
                    v28 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v14 = arg41;
            label_122:
                v28 = 0x400000;
            }

            v0 |= v28;
        }
        else {
            v14 = arg41;
        }

        int v12 = v11 & 0x100;
        int v29 = 0x6000000;
        if(v12 != 0) {
            v0 |= v29;
        }
        else {
            boolean v2 = arg42;
            if((v9 & v29) == 0) {
                v29 = v15.changed(v2) ? 0x4000000 : 0x2000000;
                v0 |= v29;
            }
        }

        int v2_1 = v11 & 0x200;
        v29 = 0x30000000;
        if(v2_1 != 0) {
            v30 = v0 | v29;
            v29 = v2_1;
        }
        else {
            if((v9 & v29) == 0) {
                v29 = v2_1;
                v30 = v15.changed(arg43) ? 0x20000000 : 0x10000000;
                v0 |= v30;
            }
            else {
                v29 = v2_1;
            }

            v30 = v0;
        }

        v0 = v11 & 0x400;
        if(v0 != 0) {
            v19 = v10 | 6;
        }
        else {
            v2_2 = arg44;
            if((v10 & 6) == 0) {
                v19 = v15.changedInstance(v2_2) ? 4 : 2;
                v19 |= v10;
            }
            else {
                v19 = v10;
            }
        }

        if((v10 & 0x30) == 0) {
            v31 = v0;
            int v21 = (v11 & 0x800) != 0 || !v15.changedInstance(arg45) ? 16 : 0x20;
            v19 |= v21;
        }
        else {
            v31 = v0;
        }

        v0 = v19;
        v2_1 = v11 & 0x1000;
        if(v2_1 != 0) {
            v19 = v0 | 0x180;
        }
        else {
            v19 = v0;
            if((v10 & 0x180) == 0) {
                v26 = v15.changed(arg46) ? 0x100 : 0x80;
                v19 |= v26;
            }
        }

        if((v10 & 0xC00) == 0) {
            if(v15.changedInstance(arg47)) {
                v17 = v18;
            }

            v19 |= v17;
        }

        v17 = v2_1;
        v2_1 = v19;
        boolean v18_1 = true;
        boolean v0_1 = (v30 & 306783379) != 306783378 || (v2_1 & 0x493) != 1170 ? true : false;
        if(v15.shouldExecute(v0_1, v30 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "292@15642L28,297@15866L55");
            v19 = 0xFE3FFFFF;
            if((v9 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v21_2 = Modifier.Companion;
                }
                else {
                    v21_1 = v7;
                }

                PaddingValues v24 = v8 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : arg36;
                if(v16 != 0) {
                    v16_1 = Fill.INSTANCE;
                }
                else {
                    PageSize v16_2 = arg37;
                }

                v20 = v20 != 0 ? 0 : v5;
                float v22_1 = v22 != 0 ? Dp.constructor-impl(0f) : v6;
                if(v25 != 0) {
                    v13 = Alignment.Companion.getCenterHorizontally();
                }

                if((v11 & 0x80) != 0) {
                    v6_1 = v15;
                    v15_1 = v2_1;
                    v1 = arg34;
                    TargetedFlingBehavior v0_2 = PagerDefaults.INSTANCE.flingBehavior(v1, null, null, null, 0f, v6_1, v30 & 14 | v23, 30);
                    v30 &= v19;
                    v4 = 0;
                    v14 = v0_2;
                }
                else {
                    v1 = arg34;
                    v4 = 0;
                    v6_1 = v15;
                    v15_1 = v2_1;
                }

                if(v12 != 0) {
                }
                else {
                    v18_1 = arg42;
                }

                v0_1 = v29 != 0 ? ((boolean)v4) : arg43;
                v2_2 = v31 != 0 ? null : arg44;
                if((v11 & 0x800) != 0) {
                    v3_1 = PagerDefaults.INSTANCE.pageNestedScrollConnection(v1, Orientation.Vertical, v6_1, v30 & 14 | 0x1B0);
                    v15_1 &= 0xFFFFFF8F;
                }
                else {
                    v3_1 = arg45;
                }

                if(v17 != 0) {
                    v9_1 = v0_1;
                    v10_1 = v2_2;
                    v11_1 = v3_1;
                    v12_2 = Start.INSTANCE;
                }
                else {
                    v12_1 = arg46;
                    v9_1 = v0_1;
                    v10_1 = v2_2;
                    v11_1 = v3_1;
                }

                v7_1 = v14;
                v3_2 = v16_1;
                v8_1 = v18_1;
                v5_1 = v22_1;
                v2_3 = v24;
                v0 = v30;
            }
            else {
                v15.skipToGroupEnd();
                if((v11 & 0x80) != 0) {
                    v30 &= v19;
                }

                if((v11 & 0x800) != 0) {
                    v2_1 &= 0xFFFFFF8F;
                }

                v1 = arg34;
                v8_1 = arg42;
                v9_1 = arg43;
                v10_1 = arg44;
                v11_1 = arg45;
                v12_1 = arg46;
                v4 = 0;
                v20 = v5;
                v5_1 = v6;
                v21_1 = v7;
                v7_1 = v14;
                v6_1 = v15;
                v0 = v30;
                PageSize v3 = arg37;
                v15_1 = v2_1;
                v2_3 = arg36;
            }

            v6_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1474550033, v0, v15_1, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:300)");
                v4 = 0;
            }

            OverscrollEffect v4_1 = OverscrollKt.rememberOverscrollEffect(v6_1, v4);
            v16 = v0 & 0x7FFFFFFE;
            v17 = v15_1 & 0x3FE | v15_1 << 3 & 0xE000;
            PagerState v0_3 = v1;
            v15 = v6_1;
            Horizontal v6_2 = v13;
            Modifier v1_1 = ((Modifier)v21_2);
            OverscrollEffect v13_1 = v4_1;
            v4 = v20;
            PagerKt.VerticalPager--8jOkeI(v0_3, v1_1, v2_3, ((PageSize)v3_2), v4, v5_1, v6_2, v7_1, v8_1, v9_1, v10_1, v11_1, ((SnapPosition)v12_2), v13_1, arg47, v15, v16, v17, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v13_2 = ((SnapPosition)v12_2);
            v12_3 = v11_1;
            v11_2 = v10_1;
            v10_2 = v9_1;
            v9_1 = v8_1;
            v8_2 = v7_1;
            v7_2 = v6_2;
            v6 = v5_1;
            v5 = v4;
            v4_2 = ((PageSize)v3_2);
            v3_3 = v2_3;
            v2_4 = v1_1;
        }
        else {
            v15.skipToGroupEnd();
            v3_3 = arg36;
            v4_2 = arg37;
            v9_1 = arg42;
            v10_2 = arg43;
            v11_2 = arg44;
            v12_3 = arg45;
            v2_4 = v7;
            v7_2 = v13;
            v8_2 = v14;
            v13_2 = arg46;
        }

        ScopeUpdateScope v0_4 = v15.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new PagerKt$$ExternalSyntheticLambda1(arg34, v2_4, v3_3, v4_2, v5, v6, v7_2, v8_2, v9_1, v10_2, v11_2, v12_3, v13_2, arg47, arg49, arg50, arg51));
        }
    }

    static final Unit VerticalPager__8jOkeI$lambda$0(PagerState arg20, Modifier arg21, PaddingValues arg22, PageSize arg23, int arg24, float arg25, Horizontal arg26, TargetedFlingBehavior arg27, boolean arg28, boolean arg29, Function1 arg30, NestedScrollConnection arg31, SnapPosition arg32, OverscrollEffect arg33, Function4 arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        PagerKt.VerticalPager--8jOkeI(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    static final Unit VerticalPager_oI3XNZo$lambda$0(PagerState arg19, Modifier arg20, PaddingValues arg21, PageSize arg22, int arg23, float arg24, Horizontal arg25, TargetedFlingBehavior arg26, boolean arg27, boolean arg28, Function1 arg29, NestedScrollConnection arg30, SnapPosition arg31, Function4 arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        PagerKt.VerticalPager-oI3XNZo(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    public static final int currentPageOffset(SnapPosition arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, float arg14, int arg15) {
        return MathKt.roundToInt((((float)arg7.position(arg8, arg9, arg11, arg12, arg13, arg15))) - arg14 * (((float)(arg9 + arg10))));
    }

    private static final void debugLog(Function0 arg0) {
    }

    public static final Modifier pagerSemantics(Modifier arg1, PagerState arg2, boolean arg3, CoroutineScope arg4, boolean arg5) {
        if(arg5) {
            return arg1.then(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new PagerKt$$ExternalSyntheticLambda0(arg3, arg2, arg4), 1, null));
        }

        return arg1.then(Modifier.Companion);
    }

    static final Unit pagerSemantics$lambda$0(boolean arg2, PagerState arg3, CoroutineScope arg4, SemanticsPropertyReceiver arg5) {
        String v1 = null;
        if(arg2) {
            SemanticsPropertiesKt.pageUp$default(arg5, v1, new PagerKt$$ExternalSyntheticLambda2(arg3, arg4), 1, v1);
            SemanticsPropertiesKt.pageDown$default(arg5, v1, new PagerKt$$ExternalSyntheticLambda3(arg3, arg4), 1, v1);
        }
        else {
            SemanticsPropertiesKt.pageLeft$default(arg5, v1, new PagerKt$$ExternalSyntheticLambda4(arg3, arg4), 1, v1);
            SemanticsPropertiesKt.pageRight$default(arg5, v1, new PagerKt$$ExternalSyntheticLambda5(arg3, arg4), 1, v1);
        }

        return Unit.INSTANCE;
    }

    private static final boolean pagerSemantics$lambda$0$0(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$performBackwardPaging(arg0, arg1);
    }

    private static final boolean pagerSemantics$lambda$0$1(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$performForwardPaging(arg0, arg1);
    }

    private static final boolean pagerSemantics$lambda$0$2(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$performBackwardPaging(arg0, arg1);
    }

    private static final boolean pagerSemantics$lambda$0$3(PagerState arg0, CoroutineScope arg1) {
        return PagerKt.pagerSemantics$performForwardPaging(arg0, arg1);
    }

    private static final boolean pagerSemantics$performBackwardPaging(PagerState arg8, CoroutineScope arg9) {
        if(arg8.getCanScrollBackward()) {
            BuildersKt.launch$default(arg9, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(arg8, null), 3, null);
            return 1;
        }

        return 0;
    }

    private static final boolean pagerSemantics$performForwardPaging(PagerState arg8, CoroutineScope arg9) {
        if(arg8.getCanScrollForward()) {
            BuildersKt.launch$default(arg9, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(arg8, null), 3, null);
            return 1;
        }

        return 0;
    }
}

