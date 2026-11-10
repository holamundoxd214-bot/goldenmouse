package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
import androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1={"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\u008C\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001A\u001A\u0080\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001A%\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010\u001F\u001A\u008C\u0001\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\"\u001A\u00020#2\b\b\u0002\u0010$\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b%\u0010&\u001A\u0080\u0001\u0010 \u001A\u00020\u00012\u0006\u0010!\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\"\u001A\u00020#2\b\b\u0002\u0010$\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\'\u0010(\u001A%\u0010)\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020#2\u0006\u0010\b\u001A\u00020\tH\u0003¢\u0006\u0002\u0010*\u001AÐ\u0001\u0010+\u001A\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001A\b\u0012\u0004\u0012\u0002H,0-2%\b\n\u0010.\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001A-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010:\u001A¤\u0002\u0010;\u001A\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001A\b\u0012\u0004\u0012\u0002H,0-2:\b\n\u0010.\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001AB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001AÐ\u0001\u0010+\u001A\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001A\b\u0012\u0004\u0012\u0002H,0@2%\b\n\u0010.\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001A\u001F\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001A-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010A\u001A¤\u0002\u0010;\u001A\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001A\b\u0012\u0004\u0012\u0002H,0@2:\b\n\u0010.\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001A4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001AB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010B¨\u0006C"}, d2={"LazyVerticalStaggeredGrid", "", "columns", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyVerticalStaggeredGrid-6qCrX9Q", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "LazyHorizontalStaggeredGrid", "rows", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "LazyHorizontalStaggeredGrid-121YqSk", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyStaggeredGridDslKt {
    public static LazyStaggeredGridSlots $r8$lambda$KmcLpbfEa4JnZ7WDM15dY6y6cv0(PaddingValues arg0, StaggeredGridCells arg1, Horizontal arg2, Density arg3, Constraints arg4) {
        return LazyStaggeredGridDslKt.rememberColumnSlots$lambda$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static LazyStaggeredGridSlots $r8$lambda$oghxAD6TYxvQH8FIEk2KTiQ3LN8(PaddingValues arg0, StaggeredGridCells arg1, Vertical arg2, Density arg3, Constraints arg4) {
        return LazyStaggeredGridDslKt.rememberRowSlots$lambda$0$0(arg0, arg1, arg2, arg3, arg4);
    }

    public static final void LazyHorizontalStaggeredGrid-121YqSk(StaggeredGridCells arg31, Modifier arg32, LazyStaggeredGridState arg33, PaddingValues arg34, boolean arg35, Vertical arg36, float arg37, FlingBehavior arg38, boolean arg39, OverscrollEffect arg40, Function1 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        float v7_3;
        OverscrollEffect v10_3;
        boolean v9_2;
        FlingBehavior v8_3;
        boolean v5_2;
        PaddingValues v4_3;
        Modifier v2_1;
        LazyStaggeredGridState v3_1;
        Vertical v6_1;
        Composer v27;
        Vertical v10_1;
        PaddingValues v9_1;
        LazyStaggeredGridState v15_1;
        OverscrollEffect v23;
        boolean v22;
        FlingBehavior v21_1;
        float v24;
        Companion v18_2;
        FlingBehavior v11_1;
        HorizontalOrVertical v10_2;
        LazyStaggeredGridState v7_1;
        Companion v4_1;
        int v20;
        int v19;
        int v18;
        int v15;
        boolean v13;
        int v11;
        PaddingValues v10;
        int v9;
        LazyStaggeredGridState v8_1;
        Modifier v7;
        int v3;
        StaggeredGridCells v1 = arg31;
        int v12 = arg43;
        int v14 = arg45;
        Composer v2 = arg42.startRestartGroup(0xD80562E4);
        ComposerKt.sourceInformation(v2, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,overscrollEffect,content)214@9926L59,203@9477L542:LazyStaggeredGridDsl.kt#fzvcnm");
        if((v12 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v6 = v14 & 2;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_32;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg32;
            int v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_32:
            v7 = arg32;
        }

        if((v12 & 0x180) == 0) {
            if((v14 & 4) == 0) {
                v8_1 = arg33;
                if(v2.changed(v8_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_43;
                }
            }
            else {
                v8_1 = arg33;
            label_43:
                v9 = 0x80;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg33;
        }

        v9 = v14 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_61;
        }
        else if((v12 & 0xC00) == 0) {
            v10 = arg34;
            v11 = v2.changed(v10) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_61:
            v10 = arg34;
        }

        v11 = v14 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_76;
        }
        else if((v12 & 0x6000) == 0) {
            v13 = arg35;
            v15 = v2.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v15;
        }
        else {
        label_76:
            v13 = arg35;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            Vertical v5 = arg36;
            if((v12 & v16) == 0) {
                v16 = v2.changed(v5) ? 0x20000 : 0x10000;
                v3 |= v16;
            }
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            float v0 = arg37;
            if((v12 & v17) == 0) {
                v18 = v2.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        if((v12 & 0xC00000) == 0) {
            v19 = (v14 & 0x80) != 0 || !v2.changed(arg38) ? 0x400000 : 0x800000;
            v3 |= v19;
        }

        int v0_1 = v14 & 0x100;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_138;
        }
        else if((v12 & v19) == 0) {
            v19 = v0_1;
            v20 = v2.changed(arg39) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_138:
            v19 = v0_1;
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v2.changed(arg40) ? 0x10000000 : 0x20000000;
            v3 |= v20;
        }

        Function1 v0_2 = arg41;
        if((arg44 & 6) == 0) {
            v20 = v2.changedInstance(v0_2) ? 4 : 2;
            v0_1 = arg44 | v20;
        }
        else {
            v0_1 = arg44;
        }

        boolean v20_1 = true;
        int v42 = v6;
        boolean v4 = (v3 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v4, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "193@9000L32,198@9295L15,200@9393L26");
            v18 = 0xFE3FFFFF;
            int v21 = 0x8FFFFFFF;
            int v5_1 = 3;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v42 != 0) {
                    v4_1 = Modifier.Companion;
                }
                else {
                    Modifier v4_2 = v7;
                }

                if((v14 & 4) != 0) {
                    v7_1 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, v2, 0, v5_1);
                    v3 &= -897;
                }
                else {
                    v7_1 = v8_1;
                }

                v9_1 = v9 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v10;
                if(v11 != 0) {
                    v13 = false;
                }

                if(v15 != 0) {
                    v10_2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0f));
                }
                else {
                    v10_1 = arg36;
                }

                float v8_2 = v16 != 0 ? Dp.constructor-impl(0f) : arg37;
                if((v14 & 0x80) != 0) {
                    v11_1 = ScrollableDefaults.INSTANCE.flingBehavior(v2, 6);
                    v3 &= v18;
                }
                else {
                    v11_1 = arg38;
                }

                if(v19 != 0) {
                }
                else {
                    v20_1 = arg39;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= v21;
                    v18_2 = v4_1;
                    v23 = OverscrollKt.rememberOverscrollEffect(v2, 0);
                }
                else {
                    v23 = arg40;
                    v18_2 = v4_1;
                }

                v15_1 = v7_1;
                v24 = v8_2;
                v21_1 = v11_1;
                v22 = v20_1;
                v20_1 = v13;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 4) != 0) {
                    v3 &= -897;
                }

                if((v14 & 0x80) != 0) {
                    v3 &= v18;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= v21;
                }

                v24 = arg37;
                v21_1 = arg38;
                v22 = arg39;
                v23 = arg40;
                Modifier v18_1 = v7;
                v15_1 = v8_1;
                v9_1 = v10;
                v20_1 = v13;
                v10_1 = arg36;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD80562E4, v3, v0_1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:202)");
            }

            v6 = v3 >> 3;
            int v7_2 = v3 << 3;
            v27 = v2;
            PaddingValues v19_1 = v9_1;
            LazyStaggeredGridKt.LazyStaggeredGrid-w41Enmo(v15_1, Orientation.Horizontal, LazyStaggeredGridDslKt.rememberRowSlots(v1, ((Vertical)v10_2), v9_1, v2, v3 & 14 | v3 >> 12 & 0x70 | v6 & 0x380), ((Modifier)v18_2), v19_1, v20_1, v21_1, v22, v23, v24, ((Vertical)v10_2).getSpacing-D9Ej5fM(), arg41, v27, v3 >> 6 & 14 | 0x30 | v3 << 6 & 0x1C00 | 0xE000 & v7_2 | v7_2 & 0x70000 | 0x380000 & v6 | 0x1C00000 & v6 | v6 & 0xE000000 | v3 << 9 & 0x70000000, v0_1 << v5_1 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = ((Vertical)v10_2);
            v3_1 = v15_1;
            v2_1 = ((Modifier)v18_2);
            v4_3 = v19_1;
            v5_2 = v20_1;
            v8_3 = v21_1;
            v9_2 = v22;
            v10_3 = v23;
            v7_3 = v24;
        }
        else {
            v27 = v2;
            v27.skipToGroupEnd();
            v6_1 = arg36;
            v9_2 = arg39;
            v2_1 = v7;
            v3_1 = v8_1;
            v4_3 = v10;
            v5_2 = v13;
            v7_3 = arg37;
            v8_3 = arg38;
            v10_3 = arg40;
        }

        ScopeUpdateScope v15_2 = v27.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda4(v1, v2_1, v3_1, v4_3, v5_2, v6_1, v7_3, v8_3, v9_2, v10_3, arg41, v12, arg44, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyHorizontalStaggeredGrid-cJHQLPU(StaggeredGridCells arg28, Modifier arg29, LazyStaggeredGridState arg30, PaddingValues arg31, boolean arg32, Vertical arg33, float arg34, FlingBehavior arg35, boolean arg36, Function1 arg37, Composer arg38, int arg39, int arg40) {
        FlingBehavior v8_2;
        float v7_3;
        Vertical v6_2;
        boolean v5_2;
        PaddingValues v4;
        LazyStaggeredGridState v3_1;
        Modifier v2_1;
        Composer v24;
        boolean v17_1;
        PaddingValues v16_1;
        LazyStaggeredGridState v15_1;
        boolean v21;
        FlingBehavior v20;
        float v19;
        HorizontalOrVertical v18_2;
        Companion v14_3;
        FlingBehavior v10_1;
        HorizontalOrVertical v7_1;
        Companion v0_4;
        int v18;
        int v17;
        int v15;
        Vertical v14_1;
        int v10;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyStaggeredGridState v5_1;
        int v2;
        int v11 = arg39;
        int v12 = arg40;
        Composer v1 = arg38.startRestartGroup(-8666074);
        ComposerKt.sourceInformation(v1, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,content)243@11057L26,233@10656L461:LazyStaggeredGridDsl.kt#fzvcnm");
        StaggeredGridCells v13 = arg28;
        if((v11 & 6) == 0) {
            v2 = v1.changed(v13) ? 4 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            int v5 = v1.changed(arg29) ? 0x20 : 16;
            v2 |= v5;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v5_1 = arg30;
                if(v1.changed(v5_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_43;
                }
            }
            else {
                v5_1 = arg30;
            label_43:
                v6 = 0x80;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg30;
        }

        v6 = v12 & 8;
        if(v6 != 0) {
            v2 |= 0xC00;
            goto label_61;
        }
        else if((v11 & 0xC00) == 0) {
            v7 = arg31;
            v8 = v1.changed(v7) ? 0x800 : 0x400;
            v2 |= v8;
        }
        else {
        label_61:
            v7 = arg31;
        }

        v8 = v12 & 16;
        if(v8 != 0) {
            v2 |= 0x6000;
            goto label_76;
        }
        else if((v11 & 0x6000) == 0) {
            v9 = arg32;
            v10 = v1.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v10;
        }
        else {
        label_76:
            v9 = arg32;
        }

        v10 = v12 & 0x20;
        int v14 = 0x30000;
        if(v10 != 0) {
            v2 |= v14;
            goto label_92;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg33;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_92:
            v14_1 = arg33;
        }

        v15 = v12 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            float v0 = arg34;
            if((v11 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        if((v11 & 0xC00000) == 0) {
            v17 = (v12 & 0x80) != 0 || !v1.changed(arg35) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0_1 = v12 & 0x100;
        v17 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_139;
        }
        else if((v11 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_139:
            v17 = v0_1;
        }

        Function1 v0_2 = arg37;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_2) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v38 = v3;
        boolean v0_3 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_3, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "224@10249L32,229@10544L15");
            v3 = 0xFE3FFFFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_4 = Modifier.Companion;
                }
                else {
                    Modifier v0_5 = arg29;
                }

                if((v12 & 4) != 0) {
                    v5_1 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, v1, 0, 3);
                    v2 &= -897;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if(v10 != 0) {
                    v7_1 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0f));
                }
                else {
                    Vertical v7_2 = v14_1;
                }

                float v8_1 = v15 != 0 ? Dp.constructor-impl(0f) : arg34;
                if((v12 & 0x80) != 0) {
                    v10_1 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v2 &= v3;
                }
                else {
                    v10_1 = arg35;
                }

                if(v17 != 0) {
                    v14_3 = v0_4;
                    v15_1 = v5_1;
                    v16_1 = v6_1;
                    v19 = v8_1;
                    v17_1 = v9;
                    v20 = v10_1;
                    v21 = true;
                    v0_1 = -8666074;
                    v18_2 = v7_1;
                    goto label_245;
                }

                v21 = arg36;
                v14_3 = v0_4;
                v15_1 = v5_1;
                v16_1 = v6_1;
                v18_2 = v7_1;
                v19 = v8_1;
                v17_1 = v9;
                v20 = v10_1;
                v0_1 = -8666074;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v2 &= -897;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                }

                v19 = arg34;
                v20 = arg35;
                v21 = arg36;
                v15_1 = v5_1;
                v16_1 = v7;
                v17_1 = v9;
                Vertical v18_1 = v14_1;
                v0_1 = -8666074;
                Modifier v14_2 = arg29;
            }

        label_245:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:232)");
            }

            v24 = v1;
            LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid-121YqSk(v13, ((Modifier)v14_3), v15_1, v16_1, v17_1, ((Vertical)v18_2), v19, v20, v21, OverscrollKt.rememberOverscrollEffect(v1, 0), arg37, v24, v2 & 0xFFFFFFE, v2 >> 27 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v14_3);
            v3_1 = v15_1;
            v4 = v16_1;
            v5_2 = v17_1;
            v6_2 = ((Vertical)v18_2);
            v7_3 = v19;
            v8_2 = v20;
            v9 = v21;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v2_1 = arg29;
            v8_2 = arg35;
            v3_1 = v5_1;
            v4 = v7;
            v5_2 = v9;
            v6_2 = v14_1;
            v7_3 = arg34;
            v9 = arg36;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda3(arg28, v2_1, v3_1, v4, v5_2, v6_2, v7_3, v8_2, v9, arg37, v11, v12));
        }
    }

    static final Unit LazyHorizontalStaggeredGrid_121YqSk$lambda$0(StaggeredGridCells arg16, Modifier arg17, LazyStaggeredGridState arg18, PaddingValues arg19, boolean arg20, Vertical arg21, float arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, Function1 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid-121YqSk(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit LazyHorizontalStaggeredGrid_cJHQLPU$lambda$0(StaggeredGridCells arg14, Modifier arg15, LazyStaggeredGridState arg16, PaddingValues arg17, boolean arg18, Vertical arg19, float arg20, FlingBehavior arg21, boolean arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid-cJHQLPU(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void LazyVerticalStaggeredGrid-6qCrX9Q(StaggeredGridCells arg31, Modifier arg32, LazyStaggeredGridState arg33, PaddingValues arg34, boolean arg35, float arg36, Horizontal arg37, FlingBehavior arg38, boolean arg39, OverscrollEffect arg40, Function1 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        float v6_1;
        OverscrollEffect v10_2;
        boolean v9_2;
        FlingBehavior v8_4;
        boolean v5_2;
        PaddingValues v4_3;
        Modifier v2_1;
        LazyStaggeredGridState v3_1;
        Horizontal v7_3;
        Composer v27;
        Horizontal v8_2;
        PaddingValues v9_1;
        LazyStaggeredGridState v15_1;
        OverscrollEffect v23;
        boolean v22;
        FlingBehavior v21_1;
        float v24;
        Companion v18_2;
        FlingBehavior v11_1;
        LazyStaggeredGridState v7_1;
        Modifier v4_2;
        int v20;
        int v19;
        int v18;
        int v15;
        boolean v13;
        int v11;
        PaddingValues v10;
        int v9;
        LazyStaggeredGridState v8_1;
        Modifier v7;
        int v3;
        StaggeredGridCells v1 = arg31;
        int v12 = arg43;
        int v14 = arg45;
        Composer v2 = arg42.startRestartGroup(0xDD7E35F8);
        ComposerKt.sourceInformation(v2, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)93@4432L67,82@3985L548:LazyStaggeredGridDsl.kt#fzvcnm");
        if((v12 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        int v6 = v14 & 2;
        if(v6 != 0) {
            v3 |= 0x30;
            goto label_32;
        }
        else if((v12 & 0x30) == 0) {
            v7 = arg32;
            int v8 = v2.changed(v7) ? 0x20 : 16;
            v3 |= v8;
        }
        else {
        label_32:
            v7 = arg32;
        }

        if((v12 & 0x180) == 0) {
            if((v14 & 4) == 0) {
                v8_1 = arg33;
                if(v2.changed(v8_1)) {
                    v9 = 0x100;
                }
                else {
                    goto label_43;
                }
            }
            else {
                v8_1 = arg33;
            label_43:
                v9 = 0x80;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg33;
        }

        v9 = v14 & 8;
        if(v9 != 0) {
            v3 |= 0xC00;
            goto label_61;
        }
        else if((v12 & 0xC00) == 0) {
            v10 = arg34;
            v11 = v2.changed(v10) ? 0x800 : 0x400;
            v3 |= v11;
        }
        else {
        label_61:
            v10 = arg34;
        }

        v11 = v14 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_76;
        }
        else if((v12 & 0x6000) == 0) {
            v13 = arg35;
            v15 = v2.changed(v13) ? 0x4000 : 0x2000;
            v3 |= v15;
        }
        else {
        label_76:
            v13 = arg35;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            float v5 = arg36;
            if((v12 & v16) == 0) {
                v16 = v2.changed(v5) ? 0x20000 : 0x10000;
                v3 |= v16;
            }
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
        }
        else {
            Horizontal v0 = arg37;
            if((v12 & v17) == 0) {
                v18 = v2.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        if((v12 & 0xC00000) == 0) {
            v19 = (v14 & 0x80) != 0 || !v2.changed(arg38) ? 0x400000 : 0x800000;
            v3 |= v19;
        }

        int v0_1 = v14 & 0x100;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_138;
        }
        else if((v12 & v19) == 0) {
            v19 = v0_1;
            v20 = v2.changed(arg39) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_138:
            v19 = v0_1;
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v2.changed(arg40) ? 0x10000000 : 0x20000000;
            v3 |= v20;
        }

        Function1 v0_2 = arg41;
        if((arg44 & 6) == 0) {
            v20 = v2.changedInstance(v0_2) ? 4 : 2;
            v0_1 = arg44 | v20;
        }
        else {
            v0_1 = arg44;
        }

        boolean v20_1 = true;
        int v42 = v6;
        boolean v4 = (v3 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v4, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "72@3506L32,77@3803L15,79@3901L26");
            v18 = 0xFE3FFFFF;
            int v21 = 0x8FFFFFFF;
            int v5_1 = 3;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v42 != 0) {
                    Companion v4_1 = Modifier.Companion;
                }
                else {
                    v4_2 = v7;
                }

                if((v14 & 4) != 0) {
                    v7_1 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, v2, 0, v5_1);
                    v3 &= -897;
                }
                else {
                    v7_1 = v8_1;
                }

                v9_1 = v9 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v10;
                if(v11 != 0) {
                    v13 = false;
                }

                float v10_1 = v15 != 0 ? Dp.constructor-impl(0f) : arg36;
                if(v16 != 0) {
                    HorizontalOrVertical v8_3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0f));
                }
                else {
                    v8_2 = arg37;
                }

                if((v14 & 0x80) != 0) {
                    v11_1 = ScrollableDefaults.INSTANCE.flingBehavior(v2, 6);
                    v3 &= v18;
                }
                else {
                    v11_1 = arg38;
                }

                if(v19 != 0) {
                }
                else {
                    v20_1 = arg39;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= v21;
                    v18_2 = ((Companion)v4_2);
                    v23 = OverscrollKt.rememberOverscrollEffect(v2, 0);
                }
                else {
                    v23 = arg40;
                    v18_2 = ((Companion)v4_2);
                }

                v15_1 = v7_1;
                v24 = v10_1;
                v21_1 = v11_1;
                v22 = v20_1;
                v20_1 = v13;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 4) != 0) {
                    v3 &= -897;
                }

                if((v14 & 0x80) != 0) {
                    v3 &= v18;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= v21;
                }

                v24 = arg36;
                v21_1 = arg38;
                v22 = arg39;
                v23 = arg40;
                Modifier v18_1 = v7;
                v15_1 = v8_1;
                v9_1 = v10;
                v20_1 = v13;
                v8_2 = arg37;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xDD7E35F8, v3, v0_1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:81)");
            }

            v6 = v3 >> 3;
            int v7_2 = v3 << 3;
            v27 = v2;
            PaddingValues v19_1 = v9_1;
            LazyStaggeredGridKt.LazyStaggeredGrid-w41Enmo(v15_1, Orientation.Vertical, LazyStaggeredGridDslKt.rememberColumnSlots(v1, v8_2, v9_1, v2, v3 & 14 | v3 >> 15 & 0x70 | v6 & 0x380), ((Modifier)v18_2), v19_1, v20_1, v21_1, v22, v23, v24, v8_2.getSpacing-D9Ej5fM(), arg41, v27, v3 >> 6 & 14 | 0x30 | v3 << 6 & 0x1C00 | 0xE000 & v7_2 | v7_2 & 0x70000 | 0x380000 & v6 | 0x1C00000 & v6 | v6 & 0xE000000 | v3 << 12 & 0x70000000, v0_1 << v5_1 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_3 = v8_2;
            v3_1 = v15_1;
            v2_1 = ((Modifier)v18_2);
            v4_3 = v19_1;
            v5_2 = v20_1;
            v8_4 = v21_1;
            v9_2 = v22;
            v10_2 = v23;
            v6_1 = v24;
        }
        else {
            v27 = v2;
            v27.skipToGroupEnd();
            v6_1 = arg36;
            v9_2 = arg39;
            v2_1 = v7;
            v3_1 = v8_1;
            v4_3 = v10;
            v5_2 = v13;
            v7_3 = arg37;
            v8_4 = arg38;
            v10_2 = arg40;
        }

        ScopeUpdateScope v15_2 = v27.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda0(v1, v2_1, v3_1, v4_3, v5_2, v6_1, v7_3, v8_4, v9_2, v10_2, arg41, v12, arg44, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyVerticalStaggeredGrid-zadm560(StaggeredGridCells arg28, Modifier arg29, LazyStaggeredGridState arg30, PaddingValues arg31, boolean arg32, float arg33, Horizontal arg34, FlingBehavior arg35, boolean arg36, Function1 arg37, Composer arg38, int arg39, int arg40) {
        FlingBehavior v8_3;
        Horizontal v7_2;
        float v6_2;
        boolean v5_2;
        PaddingValues v4;
        LazyStaggeredGridState v3_1;
        Modifier v2_1;
        Composer v24;
        float v18_1;
        boolean v17_1;
        PaddingValues v16_1;
        LazyStaggeredGridState v15_1;
        boolean v21;
        FlingBehavior v20;
        HorizontalOrVertical v19_1;
        Companion v14_3;
        FlingBehavior v10_1;
        Horizontal v8_2;
        Companion v0_4;
        int v18;
        int v17;
        int v15;
        float v14_1;
        int v10;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyStaggeredGridState v5_1;
        int v2;
        int v11 = arg39;
        int v12 = arg40;
        Composer v1 = arg38.startRestartGroup(0x650C9692);
        ComposerKt.sourceInformation(v1, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,content)122@5578L26,112@5173L465:LazyStaggeredGridDsl.kt#fzvcnm");
        StaggeredGridCells v13 = arg28;
        if((v11 & 6) == 0) {
            v2 = v1.changed(v13) ? 4 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            int v5 = v1.changed(arg29) ? 0x20 : 16;
            v2 |= v5;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v5_1 = arg30;
                if(v1.changed(v5_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_43;
                }
            }
            else {
                v5_1 = arg30;
            label_43:
                v6 = 0x80;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg30;
        }

        v6 = v12 & 8;
        if(v6 != 0) {
            v2 |= 0xC00;
            goto label_61;
        }
        else if((v11 & 0xC00) == 0) {
            v7 = arg31;
            v8 = v1.changed(v7) ? 0x800 : 0x400;
            v2 |= v8;
        }
        else {
        label_61:
            v7 = arg31;
        }

        v8 = v12 & 16;
        if(v8 != 0) {
            v2 |= 0x6000;
            goto label_76;
        }
        else if((v11 & 0x6000) == 0) {
            v9 = arg32;
            v10 = v1.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v10;
        }
        else {
        label_76:
            v9 = arg32;
        }

        v10 = v12 & 0x20;
        int v14 = 0x30000;
        if(v10 != 0) {
            v2 |= v14;
            goto label_92;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg33;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_92:
            v14_1 = arg33;
        }

        v15 = v12 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            Horizontal v0 = arg34;
            if((v11 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        if((v11 & 0xC00000) == 0) {
            v17 = (v12 & 0x80) != 0 || !v1.changed(arg35) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0_1 = v12 & 0x100;
        v17 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_139;
        }
        else if((v11 & v17) == 0) {
            v17 = v0_1;
            v18 = v1.changed(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_139:
            v17 = v0_1;
        }

        Function1 v0_2 = arg37;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_2) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v38 = v3;
        boolean v0_3 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_3, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "103@4764L32,108@5061L15");
            v3 = 0xFE3FFFFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_4 = Modifier.Companion;
                }
                else {
                    Modifier v0_5 = arg29;
                }

                if((v12 & 4) != 0) {
                    v5_1 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, v1, 0, 3);
                    v2 &= -897;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                float v7_1 = v10 != 0 ? Dp.constructor-impl(0f) : v14_1;
                if(v15 != 0) {
                    HorizontalOrVertical v8_1 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0f));
                }
                else {
                    v8_2 = arg34;
                }

                if((v12 & 0x80) != 0) {
                    v10_1 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v2 &= v3;
                }
                else {
                    v10_1 = arg35;
                }

                if(v17 != 0) {
                    v14_3 = v0_4;
                    v15_1 = v5_1;
                    v16_1 = v6_1;
                    v19_1 = ((HorizontalOrVertical)v8_2);
                    v17_1 = v9;
                    v20 = v10_1;
                    v21 = true;
                    v0_1 = 0x650C9692;
                    v18_1 = v7_1;
                    goto label_245;
                }

                v21 = arg36;
                v14_3 = v0_4;
                v15_1 = v5_1;
                v16_1 = v6_1;
                v18_1 = v7_1;
                v19_1 = ((HorizontalOrVertical)v8_2);
                v17_1 = v9;
                v20 = v10_1;
                v0_1 = 0x650C9692;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v2 &= -897;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                }

                Horizontal v19 = arg34;
                v20 = arg35;
                v21 = arg36;
                v15_1 = v5_1;
                v16_1 = v7;
                v17_1 = v9;
                v18_1 = v14_1;
                v0_1 = 0x650C9692;
                Modifier v14_2 = arg29;
            }

        label_245:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:111)");
            }

            v24 = v1;
            LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-6qCrX9Q(v13, ((Modifier)v14_3), v15_1, v16_1, v17_1, v18_1, ((Horizontal)v19_1), v20, v21, OverscrollKt.rememberOverscrollEffect(v1, 0), arg37, v24, v2 & 0xFFFFFFE, v2 >> 27 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v14_3);
            v3_1 = v15_1;
            v4 = v16_1;
            v5_2 = v17_1;
            v6_2 = v18_1;
            v7_2 = ((Horizontal)v19_1);
            v8_3 = v20;
            v9 = v21;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v2_1 = arg29;
            v8_3 = arg35;
            v3_1 = v5_1;
            v4 = v7;
            v5_2 = v9;
            v6_2 = v14_1;
            v7_2 = arg34;
            v9 = arg36;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda5(arg28, v2_1, v3_1, v4, v5_2, v6_2, v7_2, v8_3, v9, arg37, v11, v12));
        }
    }

    static final Unit LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(StaggeredGridCells arg16, Modifier arg17, LazyStaggeredGridState arg18, PaddingValues arg19, boolean arg20, float arg21, Horizontal arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, Function1 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-6qCrX9Q(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit LazyVerticalStaggeredGrid_zadm560$lambda$0(StaggeredGridCells arg14, Modifier arg15, LazyStaggeredGridState arg16, PaddingValues arg17, boolean arg18, float arg19, Horizontal arg20, FlingBehavior arg21, boolean arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid-zadm560(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void items(LazyStaggeredGridScope arg3, List arg4, Function1 arg5, Function1 arg6, Function1 arg7, Function4 arg8) {
        LazyStaggeredGridDslKt$items$2$1 v5;
        List v0 = arg4;
        int v4 = v0.size();
        LazyStaggeredGridDslKt$items$4$1 v1 = null;
        if(arg5 != null) {
            v5 = new LazyStaggeredGridDslKt$items$2$1(arg5, v0);
        }
        else {
            arg5 = ((Function1)v1);
        }

        LazyStaggeredGridDslKt$items$3 v6 = new LazyStaggeredGridDslKt$items$3(arg6, v0);
        if(arg7 != null) {
            v1 = new LazyStaggeredGridDslKt$items$4$1(arg7, v0);
        }

        arg3.items(v4, ((Function1)v5), ((Function1)v6), v1, ComposableLambdaKt.composableLambdaInstance(0xEC087F4E, true, new LazyStaggeredGridDslKt$items$5(arg8, v0)));
    }

    public static final void items(LazyStaggeredGridScope arg3, Object[] arg4, Function1 arg5, Function1 arg6, Function1 arg7, Function4 arg8) {
        Object[] v0 = arg4;
        int v4 = v0.length;
        LazyStaggeredGridDslKt$items$9$1 v1 = null;
        if(arg5 != null) {
            LazyStaggeredGridDslKt$items$7$1 v5 = new LazyStaggeredGridDslKt$items$7$1(arg5, v0);
        }
        else {
            arg5 = ((Function1)v1);
        }

        LazyStaggeredGridDslKt$items$8 v6 = new LazyStaggeredGridDslKt$items$8(arg6, v0);
        if(arg7 != null) {
            v1 = new LazyStaggeredGridDslKt$items$9$1(arg7, v0);
        }

        arg3.items(v4, arg5, ((Function1)v6), v1, ComposableLambdaKt.composableLambdaInstance(0x9624A0AD, true, new LazyStaggeredGridDslKt$items$10(arg8, v0)));
    }

    public static void items$default(LazyStaggeredGridScope arg7, List arg8, Function1 arg9, Function1 arg10, Function1 arg11, Function4 arg12, int arg13, Object arg14) {
        LazyStaggeredGridDslKt$items$2$1 v3;
        LazyStaggeredGridDslKt$items$1 v10;
        LazyStaggeredGridDslKt$items$4$1 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function1)v0);
        }

        if((arg13 & 4) != 0) {
            v10 = LazyStaggeredGridDslKt$items$1.INSTANCE;
        }

        if((arg13 & 8) != 0) {
            arg11 = ((Function1)v0);
        }

        int v2 = arg8.size();
        if(arg9 != null) {
            v3 = new LazyStaggeredGridDslKt$items$2$1(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        LazyStaggeredGridDslKt$items$3 v4 = new LazyStaggeredGridDslKt$items$3(((Function1)v10), arg8);
        if(arg11 != null) {
            v0 = new LazyStaggeredGridDslKt$items$4$1(arg11, arg8);
        }

        arg7.items(v2, ((Function1)v3), ((Function1)v4), v0, ComposableLambdaKt.composableLambdaInstance(0xEC087F4E, true, new LazyStaggeredGridDslKt$items$5(arg12, arg8)));
    }

    public static void items$default(LazyStaggeredGridScope arg7, Object[] arg8, Function1 arg9, Function1 arg10, Function1 arg11, Function4 arg12, int arg13, Object arg14) {
        LazyStaggeredGridDslKt$items$7$1 v3;
        LazyStaggeredGridDslKt$items$6 v10;
        LazyStaggeredGridDslKt$items$9$1 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function1)v0);
        }

        if((arg13 & 4) != 0) {
            v10 = LazyStaggeredGridDslKt$items$6.INSTANCE;
        }

        if((arg13 & 8) != 0) {
            arg11 = ((Function1)v0);
        }

        int v2 = arg8.length;
        if(arg9 != null) {
            v3 = new LazyStaggeredGridDslKt$items$7$1(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        LazyStaggeredGridDslKt$items$8 v4 = new LazyStaggeredGridDslKt$items$8(((Function1)v10), arg8);
        if(arg11 != null) {
            v0 = new LazyStaggeredGridDslKt$items$9$1(arg11, arg8);
        }

        arg7.items(v2, ((Function1)v3), ((Function1)v4), v0, ComposableLambdaKt.composableLambdaInstance(0x9624A0AD, true, new LazyStaggeredGridDslKt$items$10(arg12, arg8)));
    }

    public static final void itemsIndexed(LazyStaggeredGridScope arg3, List arg4, Function2 arg5, Function2 arg6, Function2 arg7, Function5 arg8) {
        LazyStaggeredGridDslKt$itemsIndexed$2$1 v5;
        List v0 = arg4;
        int v4 = v0.size();
        LazyStaggeredGridDslKt$itemsIndexed$4$1 v1 = null;
        if(arg5 != null) {
            v5 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(arg5, v0);
        }
        else {
            Function1 v5_1 = ((Function1)v1);
        }

        LazyStaggeredGridDslKt$itemsIndexed$3 v6 = new LazyStaggeredGridDslKt$itemsIndexed$3(arg6, v0);
        if(arg7 != null) {
            v1 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(arg7, v0);
        }

        arg3.items(v4, ((Function1)v5), ((Function1)v6), v1, ComposableLambdaKt.composableLambdaInstance(0xA8979A85, true, new LazyStaggeredGridDslKt$itemsIndexed$5(arg8, v0)));
    }

    public static final void itemsIndexed(LazyStaggeredGridScope arg3, Object[] arg4, Function2 arg5, Function2 arg6, Function2 arg7, Function5 arg8) {
        LazyStaggeredGridDslKt$itemsIndexed$7$1 v5;
        Object[] v0 = arg4;
        int v4 = v0.length;
        LazyStaggeredGridDslKt$itemsIndexed$9$1 v1 = null;
        if(arg5 != null) {
            v5 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(arg5, v0);
        }
        else {
            Function1 v5_1 = ((Function1)v1);
        }

        LazyStaggeredGridDslKt$itemsIndexed$8 v6 = new LazyStaggeredGridDslKt$itemsIndexed$8(arg6, v0);
        if(arg7 != null) {
            v1 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(arg7, v0);
        }

        arg3.items(v4, ((Function1)v5), ((Function1)v6), v1, ComposableLambdaKt.composableLambdaInstance(0x1961E84E, true, new LazyStaggeredGridDslKt$itemsIndexed$10(arg8, v0)));
    }

    public static void itemsIndexed$default(LazyStaggeredGridScope arg7, List arg8, Function2 arg9, Function2 arg10, Function2 arg11, Function5 arg12, int arg13, Object arg14) {
        LazyStaggeredGridDslKt$itemsIndexed$2$1 v3;
        LazyStaggeredGridDslKt$itemsIndexed$1 v10;
        LazyStaggeredGridDslKt$itemsIndexed$4$1 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function2)v0);
        }

        if((arg13 & 4) != 0) {
            v10 = LazyStaggeredGridDslKt$itemsIndexed$1.INSTANCE;
        }

        if((arg13 & 8) != 0) {
            arg11 = ((Function2)v0);
        }

        int v2 = arg8.size();
        if(arg9 != null) {
            v3 = new LazyStaggeredGridDslKt$itemsIndexed$2$1(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        LazyStaggeredGridDslKt$itemsIndexed$3 v4 = new LazyStaggeredGridDslKt$itemsIndexed$3(((Function2)v10), arg8);
        if(arg11 != null) {
            v0 = new LazyStaggeredGridDslKt$itemsIndexed$4$1(arg11, arg8);
        }

        arg7.items(v2, ((Function1)v3), ((Function1)v4), v0, ComposableLambdaKt.composableLambdaInstance(0xA8979A85, true, new LazyStaggeredGridDslKt$itemsIndexed$5(arg12, arg8)));
    }

    public static void itemsIndexed$default(LazyStaggeredGridScope arg7, Object[] arg8, Function2 arg9, Function2 arg10, Function2 arg11, Function5 arg12, int arg13, Object arg14) {
        Function1 v3_1;
        LazyStaggeredGridDslKt$itemsIndexed$6 v10;
        LazyStaggeredGridDslKt$itemsIndexed$9$1 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function2)v0);
        }

        if((arg13 & 4) != 0) {
            v10 = LazyStaggeredGridDslKt$itemsIndexed$6.INSTANCE;
        }

        if((arg13 & 8) != 0) {
            arg11 = ((Function2)v0);
        }

        int v2 = arg8.length;
        if(arg9 != null) {
            LazyStaggeredGridDslKt$itemsIndexed$7$1 v3 = new LazyStaggeredGridDslKt$itemsIndexed$7$1(arg9, arg8);
        }
        else {
            v3_1 = ((Function1)v0);
        }

        LazyStaggeredGridDslKt$itemsIndexed$8 v4 = new LazyStaggeredGridDslKt$itemsIndexed$8(((Function2)v10), arg8);
        if(arg11 != null) {
            v0 = new LazyStaggeredGridDslKt$itemsIndexed$9$1(arg11, arg8);
        }

        arg7.items(v2, v3_1, ((Function1)v4), v0, ComposableLambdaKt.composableLambdaInstance(0x1961E84E, true, new LazyStaggeredGridDslKt$itemsIndexed$10(arg12, arg8)));
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(StaggeredGridCells arg5, Horizontal arg6, PaddingValues arg7, Composer arg8, int arg9) {
        int v1 = 0xB479F117;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberColumnSlots)N(columns,horizontalArrangement,contentPadding)134@5881L1194:LazyStaggeredGridDsl.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:134)");
        }

        ComposerKt.sourceInformationMarkerStart(arg8, 0x7DC21F01, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        v1 = 4;
        int v2 = 0;
        int v0 = (arg9 & 14 ^ 6) > v1 && (arg8.changed(arg5)) || (arg9 & 6) == v1 ? 1 : 0;
        int v4 = 0x20;
        v1 = (arg9 & 0x70 ^ 0x30) > v4 && (arg8.changed(arg6)) || (arg9 & 0x30) == v4 ? 1 : 0;
        v0 |= v1;
        v4 = 0x100;
        if((arg9 & 0x380 ^ 0x180) > v4 && (arg8.changed(arg7)) || (arg9 & 0x180) == v4) {
            v2 = 1;
        }

        arg9 = v0 | v2;
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            LazyStaggeredGridSlotCache v0_2 = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda1(arg7, arg5, arg6));
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((LazyGridStaggeredGridSlotsProvider)v0_1);
    }

    private static final LazyStaggeredGridSlots rememberColumnSlots$lambda$0$0(PaddingValues arg6, StaggeredGridCells arg7, Horizontal arg8, Density arg9, Constraints arg10) {
        int v0 = Constraints.getMaxWidth-impl(arg10.unbox-impl()) != 0x7FFFFFFF ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalStaggeredGrid\'s width should be bound by parent.");
        }

        int v2 = Constraints.getMaxWidth-impl(arg10.unbox-impl()) - arg9.roundToPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(arg6, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(arg6, LayoutDirection.Ltr)));
        int[] v3 = arg7.calculateCrossAxisCellSizes(arg9, v2, arg9.roundToPx-0680j_4(arg8.getSpacing-D9Ej5fM()));
        int[] v5 = new int[v3.length];
        arg8.arrange(arg9, v2, v3, LayoutDirection.Ltr, v5);
        return new LazyStaggeredGridSlots(v5, v3);
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(StaggeredGridCells arg5, Vertical arg6, PaddingValues arg7, Composer arg8, int arg9) {
        int v1 = 0xA4A9B0B3;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(rememberRowSlots)N(rows,verticalArrangement,contentPadding)255@11347L956:LazyStaggeredGridDsl.kt#fzvcnm");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:255)");
        }

        ComposerKt.sourceInformationMarkerStart(arg8, 0x2100656F, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        v1 = 4;
        int v2 = 0;
        int v0 = (arg9 & 14 ^ 6) > v1 && (arg8.changed(arg5)) || (arg9 & 6) == v1 ? 1 : 0;
        int v4 = 0x20;
        v1 = (arg9 & 0x70 ^ 0x30) > v4 && (arg8.changed(arg6)) || (arg9 & 0x30) == v4 ? 1 : 0;
        v0 |= v1;
        v4 = 0x100;
        if((arg9 & 0x380 ^ 0x180) > v4 && (arg8.changed(arg7)) || (arg9 & 0x180) == v4) {
            v2 = 1;
        }

        arg9 = v0 | v2;
        Object v0_1 = arg8.rememberedValue();
        if(arg9 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            LazyStaggeredGridSlotCache v0_2 = new LazyStaggeredGridSlotCache(new LazyStaggeredGridDslKt$$ExternalSyntheticLambda2(arg7, arg5, arg6));
            arg8.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return ((LazyGridStaggeredGridSlotsProvider)v0_1);
    }

    private static final LazyStaggeredGridSlots rememberRowSlots$lambda$0$0(PaddingValues arg2, StaggeredGridCells arg3, Vertical arg4, Density arg5, Constraints arg6) {
        int v0 = Constraints.getMaxHeight-impl(arg6.unbox-impl()) != 0x7FFFFFFF ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalStaggeredGrid\'s height should be bound by parent.");
        }

        int v6 = Constraints.getMaxHeight-impl(arg6.unbox-impl()) - arg5.roundToPx-0680j_4(Dp.constructor-impl(arg2.calculateTopPadding-D9Ej5fM() + arg2.calculateBottomPadding-D9Ej5fM()));
        int[] v2 = arg3.calculateCrossAxisCellSizes(arg5, v6, arg5.roundToPx-0680j_4(arg4.getSpacing-D9Ej5fM()));
        int[] v3 = new int[v2.length];
        arg4.arrange(arg5, v6, v2, v3);
        return new LazyStaggeredGridSlots(v3, v2);
    }
}

