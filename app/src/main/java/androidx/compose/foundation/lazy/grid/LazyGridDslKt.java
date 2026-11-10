package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement$Horizontal;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1={"\u0000\u009C\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001A\u008A\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001A~\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001A\u001A\u008A\u0001\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001D\u001A~\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001E\u001A\u001D\u0010\u001F\u001A\u00020 2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\u000FH\u0003¢\u0006\u0002\u0010!\u001A\u001D\u0010\"\u001A\u00020 2\u0006\u0010\u001C\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\rH\u0003¢\u0006\u0002\u0010#\u001A&\u0010$\u001A\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020&2\u0006\u0010)\u001A\u00020&H\u0002\u001AÛ\u0001\u0010*\u001A\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001A\b\u0012\u0004\u0012\u0002H+0%2%\b\n\u0010,\u001A\u001F\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001A*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001A\u001F\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001A-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u00109\u001A¯\u0002\u0010:\u001A\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001A\b\u0012\u0004\u0012\u0002H+0%2:\b\n\u0010,\u001A4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001A?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001A4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001AB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010=\u001AÛ\u0001\u0010*\u001A\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001A\b\u0012\u0004\u0012\u0002H+0>2%\b\n\u0010,\u001A\u001F\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001A*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001A\u001F\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001A-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001A¯\u0002\u0010:\u001A\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001A\b\u0012\u0004\u0012\u0002H+0>2:\b\n\u0010,\u001A4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001A?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001A4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001AB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2={"LazyVerticalGrid", "", "columns", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyHorizontalGrid", "rows", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "items", "T", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyGridDslKt {
    public static LazyGridSlots $r8$lambda$ZiMmUPeTYYbh0U3nvqQvgtDW4EU(GridCells arg0, Vertical arg1, Density arg2, Constraints arg3) {
        return LazyGridDslKt.rememberRowHeightSums$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static LazyGridSlots $r8$lambda$_EObm34mI59r3yRwYrfRdcDSliw(GridCells arg0, Horizontal arg1, Density arg2, Constraints arg3) {
        return LazyGridDslKt.rememberColumnWidthSums$lambda$0$0(arg0, arg1, arg2, arg3);
    }

    public static final void LazyHorizontalGrid(GridCells arg31, Modifier arg32, LazyGridState arg33, PaddingValues arg34, boolean arg35, Horizontal arg36, Vertical arg37, FlingBehavior arg38, boolean arg39, OverscrollEffect arg40, Function1 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        Horizontal v6_1;
        Vertical v7_3;
        OverscrollEffect v10_2;
        boolean v9_3;
        FlingBehavior v8_3;
        boolean v5_2;
        PaddingValues v4_4;
        LazyGridState v3_1;
        Modifier v2_1;
        Composer v27;
        Vertical v10_1;
        boolean v19_1;
        PaddingValues v18_1;
        LazyGridState v16_1;
        OverscrollEffect v23;
        boolean v22;
        FlingBehavior v21_1;
        Horizontal v25;
        Companion v15_3;
        FlingBehavior v11_1;
        Horizontal v9_2;
        LazyGridState v7_1;
        Modifier v4_3;
        int v0_2;
        int v19;
        Vertical v15_1;
        int v16;
        int v15;
        boolean v13;
        int v11;
        PaddingValues v10;
        int v9;
        LazyGridState v8_1;
        Modifier v7;
        int v3;
        GridCells v1 = arg31;
        int v12 = arg43;
        int v14 = arg45;
        Composer v2 = arg42.startRestartGroup(0x25E7B320);
        ComposerKt.sourceInformation(v2, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)170@7824L48,169@7798L505:LazyGridDsl.kt#7791vq");
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

        v15 = 0x30000;
        if((v12 & v15) == 0) {
            Horizontal v5 = arg36;
            v16 = (v14 & 0x20) != 0 || !v2.changed(v5) ? 0x10000 : 0x20000;
            v3 |= v16;
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
            goto label_107;
        }
        else if((v12 & v17) == 0) {
            v17 = v15;
            v15_1 = arg37;
            int v18 = v2.changed(v15_1) ? 0x100000 : 0x80000;
            v3 |= v18;
        }
        else {
        label_107:
            v17 = v15;
            v15_1 = arg37;
        }

        if((v12 & 0xC00000) == 0) {
            v19 = (v14 & 0x80) != 0 || !v2.changed(arg38) ? 0x400000 : 0x800000;
            v3 |= v19;
        }

        int v4 = v14 & 0x100;
        int v20 = 0x6000000;
        if(v4 != 0) {
            v3 |= v20;
        }
        else {
            boolean v0 = arg39;
            if((v12 & v20) == 0) {
                v20 = v2.changed(v0) ? 0x4000000 : 0x2000000;
                v3 |= v20;
            }
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v2.changed(arg40) ? 0x10000000 : 0x20000000;
            v3 |= v20;
        }

        Function1 v0_1 = arg41;
        if((arg44 & 6) == 0) {
            v20 = v2.changedInstance(v0_1) ? 4 : 2;
            v0_2 = arg44 | v20;
        }
        else {
            v0_2 = arg44;
        }

        int v21 = v4;
        boolean v20_1 = true;
        int v42 = v6;
        boolean v4_1 = (v3 & 306783379) != 306783378 || (v0_2 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v4_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "158@7268L23,164@7625L15,166@7723L26");
            v19 = 0xFFF8FFFF;
            int v5_1 = 3;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v42 != 0) {
                    Companion v4_2 = Modifier.Companion;
                }
                else {
                    v4_3 = v7;
                }

                if((v14 & 4) != 0) {
                    v7_1 = LazyGridStateKt.rememberLazyGridState(0, 0, v2, 0, v5_1);
                    v3 &= -897;
                }
                else {
                    v7_1 = v8_1;
                }

                PaddingValues v8_2 = v9 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v10;
                if(v11 != 0) {
                    v13 = false;
                }

                if((v14 & 0x20) != 0) {
                    Arrangement v9_1 = Arrangement.INSTANCE;
                    v9_2 = !v13 ? v9_1.getStart() : v9_1.getEnd();
                    v3 &= v19;
                }
                else {
                    v9_2 = arg36;
                }

                v10_1 = v16 != 0 ? Arrangement.INSTANCE.getTop() : v15_1;
                if((v14 & 0x80) != 0) {
                    v11_1 = ScrollableDefaults.INSTANCE.flingBehavior(v2, 6);
                    v3 &= 0xFE3FFFFF;
                }
                else {
                    v11_1 = arg38;
                }

                if(v21 != 0) {
                }
                else {
                    v20_1 = arg39;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= 0x8FFFFFFF;
                    v15_3 = ((Companion)v4_3);
                    v23 = OverscrollKt.rememberOverscrollEffect(v2, 0);
                }
                else {
                    v23 = arg40;
                    v15_3 = ((Companion)v4_3);
                }

                v16_1 = v7_1;
                v18_1 = v8_2;
                v25 = v9_2;
                v21_1 = v11_1;
                v19_1 = v13;
                v22 = v20_1;
                v4 = 0x25E7B320;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 4) != 0) {
                    v3 &= -897;
                }

                if((v14 & 0x20) != 0) {
                    v3 &= v19;
                }

                if((v14 & 0x80) != 0) {
                    v3 &= 0xFE3FFFFF;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= 0x8FFFFFFF;
                }

                v25 = arg36;
                v21_1 = arg38;
                v22 = arg39;
                v23 = arg40;
                v16_1 = v8_1;
                v18_1 = v10;
                v19_1 = v13;
                v10_1 = v15_1;
                v4 = 0x25E7B320;
                Modifier v15_2 = v7;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v3, v0_2, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
            }

            v6 = v3 >> 15;
            int v7_2 = v3 >> 3;
            v27 = v2;
            Vertical v24 = v10_1;
            LazyGridKt.LazyGrid(((Modifier)v15_3), v16_1, LazyGridDslKt.rememberRowHeightSums(v1, v10_1, v2, v3 & 14 | v6 & 0x70), v18_1, v19_1, false, v21_1, v22, v23, v24, v25, arg41, v27, v7_2 & 0xE000000 | (v7_2 & 14 | v17 | v7_2 & 0x70 | v3 & 0x1C00 | 0xE000 & v3 | 0x380000 & v7_2 | 0x1C00000 & v7_2) | v3 << 9 & 0x70000000, v6 & 14 | v0_2 << v5_1 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v15_3);
            v3_1 = v16_1;
            v4_4 = v18_1;
            v5_2 = v19_1;
            v8_3 = v21_1;
            v9_3 = v22;
            v10_2 = v23;
            v7_3 = v24;
            v6_1 = v25;
        }
        else {
            v27 = v2;
            v27.skipToGroupEnd();
            v6_1 = arg36;
            v9_3 = arg39;
            v2_1 = v7;
            v3_1 = v8_1;
            v4_4 = v10;
            v5_2 = v13;
            v7_3 = v15_1;
            v8_3 = arg38;
            v10_2 = arg40;
        }

        ScopeUpdateScope v15_4 = v27.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new LazyGridDslKt$$ExternalSyntheticLambda4(v1, v2_1, v3_1, v4_4, v5_2, v6_1, v7_3, v8_3, v9_3, v10_2, arg41, v12, arg44, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyHorizontalGrid(GridCells arg28, Modifier arg29, LazyGridState arg30, PaddingValues arg31, boolean arg32, Horizontal arg33, Vertical arg34, FlingBehavior arg35, boolean arg36, Function1 arg37, Composer arg38, int arg39, int arg40) {
        FlingBehavior v8_2;
        Vertical v7_3;
        Horizontal v6_2;
        boolean v5_2;
        PaddingValues v4;
        LazyGridState v3_1;
        Modifier v2_1;
        Composer v24;
        LazyGridState v15_2;
        Vertical v19_1;
        Horizontal v18_1;
        boolean v17_1;
        PaddingValues v16_1;
        boolean v21;
        FlingBehavior v20;
        Companion v14_2;
        FlingBehavior v10_2;
        Horizontal v7_2;
        Companion v0_3;
        int v18;
        int v17;
        Vertical v15_1;
        int v14;
        Horizontal v10_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyGridState v5_1;
        int v2;
        int v11 = arg39;
        int v12 = arg40;
        Composer v1 = arg38.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(v1, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,content)210@9358L26,200@8966L452:LazyGridDsl.kt#7791vq");
        GridCells v13 = arg28;
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
            int v10 = v1.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v10;
        }
        else {
        label_76:
            v9 = arg32;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v10_1 = arg33;
                if(v1.changed(v10_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_88;
                }
            }
            else {
                v10_1 = arg33;
            label_88:
                v14 = 0x10000;
            }

            v2 |= v14;
        }
        else {
            v10_1 = arg33;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_107;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg34;
            int v16 = v1.changed(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_107:
            v15_1 = arg34;
        }

        if((v11 & 0xC00000) == 0) {
            v17 = (v12 & 0x80) != 0 || !v1.changed(arg35) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0 = v12 & 0x100;
        v17 = 0x6000000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_139;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_139:
            v17 = v0;
        }

        Function1 v0_1 = arg37;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v38 = v3;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "190@8506L23,196@8863L15");
            v3 = 0xFE3FFFFF;
            int v19 = 0xFFF8FFFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg29;
                }

                if((v12 & 4) != 0) {
                    v5_1 = LazyGridStateKt.rememberLazyGridState(0, 0, v1, 0, 3);
                    v2 &= -897;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v12 & 0x20) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getStart() : v7_1.getEnd();
                    v2 &= v19;
                }
                else {
                    v7_2 = v10_1;
                }

                Vertical v8_1 = v14 != 0 ? Arrangement.INSTANCE.getTop() : v15_1;
                if((v12 & 0x80) != 0) {
                    v10_2 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v2 &= v3;
                }
                else {
                    v10_2 = arg35;
                }

                if(v17 != 0) {
                    v14_2 = v0_3;
                    v15_2 = v5_1;
                    v16_1 = v6_1;
                    v19_1 = v8_1;
                    v17_1 = v9;
                    v20 = v10_2;
                    v21 = true;
                    v0 = 2123608858;
                    v18_1 = v7_2;
                    goto label_254;
                }

                v21 = arg36;
                v14_2 = v0_3;
                v15_2 = v5_1;
                v16_1 = v6_1;
                v18_1 = v7_2;
                v19_1 = v8_1;
                v17_1 = v9;
                v20 = v10_2;
                v0 = 2123608858;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v2 &= -897;
                }

                if((v12 & 0x20) != 0) {
                    v2 &= v19;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                }

                Modifier v14_1 = arg29;
                v20 = arg35;
                v21 = arg36;
                v16_1 = v7;
                v17_1 = v9;
                v18_1 = v10_1;
                v19_1 = v15_1;
                v0 = 2123608858;
                v15_2 = v5_1;
            }

        label_254:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
            }

            v24 = v1;
            LazyGridDslKt.LazyHorizontalGrid(v13, ((Modifier)v14_2), v15_2, v16_1, v17_1, v18_1, v19_1, v20, v21, OverscrollKt.rememberOverscrollEffect(v1, 0), arg37, v24, v2 & 0xFFFFFFE, v2 >> 27 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v14_2);
            v3_1 = v15_2;
            v4 = v16_1;
            v5_2 = v17_1;
            v6_2 = v18_1;
            v7_3 = v19_1;
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
            v6_2 = v10_1;
            v7_3 = v15_1;
            v9 = arg36;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new LazyGridDslKt$$ExternalSyntheticLambda5(arg28, v2_1, v3_1, v4, v5_2, v6_2, v7_3, v8_2, v9, arg37, v11, v12));
        }
    }

    static final Unit LazyHorizontalGrid$lambda$0(GridCells arg16, Modifier arg17, LazyGridState arg18, PaddingValues arg19, boolean arg20, Horizontal arg21, Vertical arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, Function1 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        LazyGridDslKt.LazyHorizontalGrid(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit LazyHorizontalGrid$lambda$1(GridCells arg14, Modifier arg15, LazyGridState arg16, PaddingValues arg17, boolean arg18, Horizontal arg19, Vertical arg20, FlingBehavior arg21, boolean arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyGridDslKt.LazyHorizontalGrid(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void LazyVerticalGrid(GridCells arg31, Modifier arg32, LazyGridState arg33, PaddingValues arg34, boolean arg35, Vertical arg36, Horizontal arg37, FlingBehavior arg38, boolean arg39, OverscrollEffect arg40, Function1 arg41, Composer arg42, int arg43, int arg44, int arg45) {
        Horizontal v7_2;
        Vertical v6_1;
        OverscrollEffect v10_2;
        boolean v9_3;
        FlingBehavior v8_3;
        boolean v5_2;
        PaddingValues v4_4;
        LazyGridState v3_1;
        Modifier v2_1;
        Composer v27;
        Horizontal v10_1;
        boolean v19_1;
        PaddingValues v18_1;
        LazyGridState v16_1;
        OverscrollEffect v23;
        boolean v22;
        FlingBehavior v21_1;
        Vertical v24;
        Companion v15_3;
        FlingBehavior v11_1;
        Vertical v9_2;
        LazyGridState v7_1;
        Modifier v4_3;
        int v0_2;
        int v19;
        Horizontal v15_1;
        int v16;
        int v15;
        boolean v13;
        int v11;
        PaddingValues v10;
        int v9;
        LazyGridState v8_1;
        Modifier v7;
        int v3;
        GridCells v1 = arg31;
        int v12 = arg43;
        int v14 = arg45;
        Composer v2 = arg42.startRestartGroup(-2072102870);
        ComposerKt.sourceInformation(v2, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)81@3849L55,80@3823L511:LazyGridDsl.kt#7791vq");
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

        v15 = 0x30000;
        if((v12 & v15) == 0) {
            Vertical v5 = arg36;
            v16 = (v14 & 0x20) != 0 || !v2.changed(v5) ? 0x10000 : 0x20000;
            v3 |= v16;
        }

        v16 = v14 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v3 |= v17;
            goto label_107;
        }
        else if((v12 & v17) == 0) {
            v17 = v15;
            v15_1 = arg37;
            int v18 = v2.changed(v15_1) ? 0x100000 : 0x80000;
            v3 |= v18;
        }
        else {
        label_107:
            v17 = v15;
            v15_1 = arg37;
        }

        if((v12 & 0xC00000) == 0) {
            v19 = (v14 & 0x80) != 0 || !v2.changed(arg38) ? 0x400000 : 0x800000;
            v3 |= v19;
        }

        int v4 = v14 & 0x100;
        int v20 = 0x6000000;
        if(v4 != 0) {
            v3 |= v20;
        }
        else {
            boolean v0 = arg39;
            if((v12 & v20) == 0) {
                v20 = v2.changed(v0) ? 0x4000000 : 0x2000000;
                v3 |= v20;
            }
        }

        if((v12 & 0x30000000) == 0) {
            v20 = (v14 & 0x200) != 0 || !v2.changed(arg40) ? 0x10000000 : 0x20000000;
            v3 |= v20;
        }

        Function1 v0_1 = arg41;
        if((arg44 & 6) == 0) {
            v20 = v2.changedInstance(v0_1) ? 4 : 2;
            v0_2 = arg44 | v20;
        }
        else {
            v0_2 = arg44;
        }

        int v21 = v4;
        boolean v20_1 = true;
        int v42 = v6;
        boolean v4_1 = (v3 & 306783379) != 306783378 || (v0_2 & 3) != 2 ? true : false;
        if(v2.shouldExecute(v4_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "69@3290L23,75@3650L15,77@3748L26");
            v19 = 0xFFF8FFFF;
            int v5_1 = 3;
            if((v12 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v42 != 0) {
                    Companion v4_2 = Modifier.Companion;
                }
                else {
                    v4_3 = v7;
                }

                if((v14 & 4) != 0) {
                    v7_1 = LazyGridStateKt.rememberLazyGridState(0, 0, v2, 0, v5_1);
                    v3 &= -897;
                }
                else {
                    v7_1 = v8_1;
                }

                PaddingValues v8_2 = v9 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v10;
                if(v11 != 0) {
                    v13 = false;
                }

                if((v14 & 0x20) != 0) {
                    Arrangement v9_1 = Arrangement.INSTANCE;
                    v9_2 = !v13 ? v9_1.getTop() : v9_1.getBottom();
                    v3 &= v19;
                }
                else {
                    v9_2 = arg36;
                }

                v10_1 = v16 != 0 ? Arrangement.INSTANCE.getStart() : v15_1;
                if((v14 & 0x80) != 0) {
                    v11_1 = ScrollableDefaults.INSTANCE.flingBehavior(v2, 6);
                    v3 &= 0xFE3FFFFF;
                }
                else {
                    v11_1 = arg38;
                }

                if(v21 != 0) {
                }
                else {
                    v20_1 = arg39;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= 0x8FFFFFFF;
                    v15_3 = ((Companion)v4_3);
                    v23 = OverscrollKt.rememberOverscrollEffect(v2, 0);
                }
                else {
                    v23 = arg40;
                    v15_3 = ((Companion)v4_3);
                }

                v16_1 = v7_1;
                v18_1 = v8_2;
                v24 = v9_2;
                v21_1 = v11_1;
                v19_1 = v13;
                v22 = v20_1;
                v4 = -2072102870;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 4) != 0) {
                    v3 &= -897;
                }

                if((v14 & 0x20) != 0) {
                    v3 &= v19;
                }

                if((v14 & 0x80) != 0) {
                    v3 &= 0xFE3FFFFF;
                }

                if((v14 & 0x200) != 0) {
                    v3 &= 0x8FFFFFFF;
                }

                v24 = arg36;
                v21_1 = arg38;
                v22 = arg39;
                v23 = arg40;
                v16_1 = v8_1;
                v18_1 = v10;
                v19_1 = v13;
                v10_1 = v15_1;
                v4 = -2072102870;
                Modifier v15_2 = v7;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v4, v3, v0_2, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
            }

            v6 = v3 >> 3;
            v27 = v2;
            Horizontal v25 = v10_1;
            LazyGridKt.LazyGrid(((Modifier)v15_3), v16_1, LazyGridDslKt.rememberColumnWidthSums(v1, v10_1, v2, v3 & 14 | v3 >> 15 & 0x70), v18_1, v19_1, true, v21_1, v22, v23, v24, v25, arg41, v27, v6 & 0xE000000 | (v6 & 14 | v17 | v6 & 0x70 | v3 & 0x1C00 | 0xE000 & v3 | 0x380000 & v6 | 0x1C00000 & v6) | v3 << 12 & 0x70000000, v3 >> 18 & 14 | v0_2 << v5_1 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v15_3);
            v3_1 = v16_1;
            v4_4 = v18_1;
            v5_2 = v19_1;
            v8_3 = v21_1;
            v9_3 = v22;
            v10_2 = v23;
            v6_1 = v24;
            v7_2 = v25;
        }
        else {
            v27 = v2;
            v27.skipToGroupEnd();
            v6_1 = arg36;
            v9_3 = arg39;
            v2_1 = v7;
            v3_1 = v8_1;
            v4_4 = v10;
            v5_2 = v13;
            v7_2 = v15_1;
            v8_3 = arg38;
            v10_2 = arg40;
        }

        ScopeUpdateScope v15_4 = v27.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new LazyGridDslKt$$ExternalSyntheticLambda2(v1, v2_1, v3_1, v4_4, v5_2, v6_1, v7_2, v8_3, v9_3, v10_2, arg41, v12, arg44, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyVerticalGrid(GridCells arg28, Modifier arg29, LazyGridState arg30, PaddingValues arg31, boolean arg32, Vertical arg33, Horizontal arg34, FlingBehavior arg35, boolean arg36, Function1 arg37, Composer arg38, int arg39, int arg40) {
        FlingBehavior v8_2;
        Horizontal v7_3;
        Vertical v6_2;
        boolean v5_2;
        PaddingValues v4;
        LazyGridState v3_1;
        Modifier v2_1;
        Composer v24;
        LazyGridState v15_2;
        Horizontal v19_1;
        Vertical v18_1;
        boolean v17_1;
        PaddingValues v16_1;
        boolean v21;
        FlingBehavior v20;
        Companion v14_2;
        FlingBehavior v10_2;
        Vertical v7_2;
        Companion v0_3;
        int v18;
        int v17;
        Horizontal v15_1;
        int v14;
        Vertical v10_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyGridState v5_1;
        int v2;
        int v11 = arg39;
        int v12 = arg40;
        Composer v1 = arg38.startRestartGroup(0x588990D0);
        ComposerKt.sourceInformation(v1, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,content)121@5397L26,111@5001L456:LazyGridDsl.kt#7791vq");
        GridCells v13 = arg28;
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
            int v10 = v1.changed(v9) ? 0x4000 : 0x2000;
            v2 |= v10;
        }
        else {
        label_76:
            v9 = arg32;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v10_1 = arg33;
                if(v1.changed(v10_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_88;
                }
            }
            else {
                v10_1 = arg33;
            label_88:
                v14 = 0x10000;
            }

            v2 |= v14;
        }
        else {
            v10_1 = arg33;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v2 |= v15;
            goto label_107;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg34;
            int v16 = v1.changed(v15_1) ? 0x100000 : 0x80000;
            v2 |= v16;
        }
        else {
        label_107:
            v15_1 = arg34;
        }

        if((v11 & 0xC00000) == 0) {
            v17 = (v12 & 0x80) != 0 || !v1.changed(arg35) ? 0x400000 : 0x800000;
            v2 |= v17;
        }

        int v0 = v12 & 0x100;
        v17 = 0x6000000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_139;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v18;
        }
        else {
        label_139:
            v17 = v0;
        }

        Function1 v0_1 = arg37;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x20000000 : 0x10000000;
            v2 |= v18;
        }

        int v38 = v3;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "101@4538L23,107@4898L15");
            v3 = 0xFE3FFFFF;
            int v19 = 0xFFF8FFFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg29;
                }

                if((v12 & 4) != 0) {
                    v5_1 = LazyGridStateKt.rememberLazyGridState(0, 0, v1, 0, 3);
                    v2 &= -897;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v12 & 0x20) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getTop() : v7_1.getBottom();
                    v2 &= v19;
                }
                else {
                    v7_2 = v10_1;
                }

                Horizontal v8_1 = v14 != 0 ? Arrangement.INSTANCE.getStart() : v15_1;
                if((v12 & 0x80) != 0) {
                    v10_2 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v2 &= v3;
                }
                else {
                    v10_2 = arg35;
                }

                if(v17 != 0) {
                    v14_2 = v0_3;
                    v15_2 = v5_1;
                    v16_1 = v6_1;
                    v19_1 = v8_1;
                    v17_1 = v9;
                    v20 = v10_2;
                    v21 = true;
                    v0 = 0x588990D0;
                    v18_1 = v7_2;
                    goto label_254;
                }

                v21 = arg36;
                v14_2 = v0_3;
                v15_2 = v5_1;
                v16_1 = v6_1;
                v18_1 = v7_2;
                v19_1 = v8_1;
                v17_1 = v9;
                v20 = v10_2;
                v0 = 0x588990D0;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v2 &= -897;
                }

                if((v12 & 0x20) != 0) {
                    v2 &= v19;
                }

                if((v12 & 0x80) != 0) {
                    v2 &= v3;
                }

                Modifier v14_1 = arg29;
                v20 = arg35;
                v21 = arg36;
                v16_1 = v7;
                v17_1 = v9;
                v18_1 = v10_1;
                v19_1 = v15_1;
                v0 = 0x588990D0;
                v15_2 = v5_1;
            }

        label_254:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
            }

            v24 = v1;
            LazyGridDslKt.LazyVerticalGrid(v13, ((Modifier)v14_2), v15_2, v16_1, v17_1, v18_1, v19_1, v20, v21, OverscrollKt.rememberOverscrollEffect(v1, 0), arg37, v24, v2 & 0xFFFFFFE, v2 >> 27 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v14_2);
            v3_1 = v15_2;
            v4 = v16_1;
            v5_2 = v17_1;
            v6_2 = v18_1;
            v7_3 = v19_1;
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
            v6_2 = v10_1;
            v7_3 = v15_1;
            v9 = arg36;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new LazyGridDslKt$$ExternalSyntheticLambda1(arg28, v2_1, v3_1, v4, v5_2, v6_2, v7_3, v8_2, v9, arg37, v11, v12));
        }
    }

    static final Unit LazyVerticalGrid$lambda$0(GridCells arg16, Modifier arg17, LazyGridState arg18, PaddingValues arg19, boolean arg20, Vertical arg21, Horizontal arg22, FlingBehavior arg23, boolean arg24, OverscrollEffect arg25, Function1 arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        LazyGridDslKt.LazyVerticalGrid(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit LazyVerticalGrid$lambda$1(GridCells arg14, Modifier arg15, LazyGridState arg16, PaddingValues arg17, boolean arg18, Vertical arg19, Horizontal arg20, FlingBehavior arg21, boolean arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyGridDslKt.LazyVerticalGrid(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final List access$calculateCellsCrossAxisSizeImpl(int arg0, int arg1, int arg2) {
        return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(arg0, arg1, arg2);
    }

    private static final List calculateCellsCrossAxisSizeImpl(int arg4, int arg5, int arg6) {
        arg4 -= arg6 * (arg5 - 1);
        arg6 = arg4 / arg5;
        arg4 %= arg5;
        ArrayList v0 = new ArrayList(arg5);
        int v2;
        for(v2 = 0; v2 < arg5; ++v2) {
            int v3 = v2 < arg4 ? 1 : 0;
            v0.add(Integer.valueOf(v3 + arg6));
        }

        return ((List)v0);
    }

    public static final void items(LazyGridScope arg3, List arg4, Function1 arg5, Function2 arg6, Function1 arg7, Function4 arg8) {
        LazyGridDslKt$items$2 v5;
        List v0 = arg4;
        int v4 = v0.size();
        LazyGridDslKt$items$3 v1 = null;
        if(arg5 != null) {
            v5 = new LazyGridDslKt$items$2(arg5, v0);
        }
        else {
            arg5 = ((Function1)v1);
        }

        if(arg6 != null) {
            v1 = new LazyGridDslKt$items$3(arg6, v0);
        }

        arg3.items(v4, ((Function1)v5), v1, new LazyGridDslKt$items$4(arg7, v0), ComposableLambdaKt.composableLambdaInstance(0xBD681FEB, true, new LazyGridDslKt$items$5(arg8, v0)));
    }

    public static final void items(LazyGridScope arg3, Object[] arg4, Function1 arg5, Function2 arg6, Function1 arg7, Function4 arg8) {
        LazyGridDslKt$items$7 v5;
        Object[] v0 = arg4;
        int v4 = v0.length;
        LazyGridDslKt$items$8 v1 = null;
        if(arg5 != null) {
            v5 = new LazyGridDslKt$items$7(arg5, v0);
        }
        else {
            arg5 = ((Function1)v1);
        }

        if(arg6 != null) {
            v1 = new LazyGridDslKt$items$8(arg6, v0);
        }

        arg3.items(v4, ((Function1)v5), v1, new LazyGridDslKt$items$9(arg7, v0), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new LazyGridDslKt$items$10(arg8, v0)));
    }

    public static void items$default(LazyGridScope arg7, List arg8, Function1 arg9, Function2 arg10, Function1 arg11, Function4 arg12, int arg13, Object arg14) {
        LazyGridDslKt$items$2 v3;
        LazyGridDslKt$items$1 v11;
        LazyGridDslKt$items$3 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function1)v0);
        }

        if((arg13 & 4) != 0) {
            arg10 = ((Function2)v0);
        }

        if((arg13 & 8) != 0) {
            v11 = LazyGridDslKt$items$1.INSTANCE;
        }

        int v2 = arg8.size();
        if(arg9 != null) {
            v3 = new LazyGridDslKt$items$2(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        if(arg10 != null) {
            v0 = new LazyGridDslKt$items$3(arg10, arg8);
        }

        arg7.items(v2, ((Function1)v3), v0, new LazyGridDslKt$items$4(((Function1)v11), arg8), ComposableLambdaKt.composableLambdaInstance(0xBD681FEB, true, new LazyGridDslKt$items$5(arg12, arg8)));
    }

    public static void items$default(LazyGridScope arg7, Object[] arg8, Function1 arg9, Function2 arg10, Function1 arg11, Function4 arg12, int arg13, Object arg14) {
        LazyGridDslKt$items$7 v3;
        LazyGridDslKt$items$6 v11;
        LazyGridDslKt$items$8 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function1)v0);
        }

        if((arg13 & 4) != 0) {
            arg10 = ((Function2)v0);
        }

        if((arg13 & 8) != 0) {
            v11 = LazyGridDslKt$items$6.INSTANCE;
        }

        int v2 = arg8.length;
        if(arg9 != null) {
            v3 = new LazyGridDslKt$items$7(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        if(arg10 != null) {
            v0 = new LazyGridDslKt$items$8(arg10, arg8);
        }

        arg7.items(v2, ((Function1)v3), v0, new LazyGridDslKt$items$9(((Function1)v11), arg8), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new LazyGridDslKt$items$10(arg12, arg8)));
    }

    public static final void itemsIndexed(LazyGridScope arg3, List arg4, Function2 arg5, Function3 arg6, Function2 arg7, Function5 arg8) {
        LazyGridDslKt$itemsIndexed$2 v5;
        List v0 = arg4;
        int v4 = v0.size();
        LazyGridDslKt$itemsIndexed$3 v1 = null;
        if(arg5 != null) {
            v5 = new LazyGridDslKt$itemsIndexed$2(arg5, v0);
        }
        else {
            Function1 v5_1 = ((Function1)v1);
        }

        if(arg6 != null) {
            v1 = new LazyGridDslKt$itemsIndexed$3(arg6, v0);
        }

        arg3.items(v4, ((Function1)v5), v1, new LazyGridDslKt$itemsIndexed$4(arg7, v0), ComposableLambdaKt.composableLambdaInstance(0x8C3BAF56, true, new LazyGridDslKt$itemsIndexed$5(arg8, v0)));
    }

    public static final void itemsIndexed(LazyGridScope arg3, Object[] arg4, Function2 arg5, Function3 arg6, Function2 arg7, Function5 arg8) {
        Function1 v5_1;
        Object[] v0 = arg4;
        int v4 = v0.length;
        LazyGridDslKt$itemsIndexed$8 v1 = null;
        if(arg5 != null) {
            LazyGridDslKt$itemsIndexed$7 v5 = new LazyGridDslKt$itemsIndexed$7(arg5, v0);
        }
        else {
            v5_1 = ((Function1)v1);
        }

        if(arg6 != null) {
            v1 = new LazyGridDslKt$itemsIndexed$8(arg6, v0);
        }

        arg3.items(v4, v5_1, v1, new LazyGridDslKt$itemsIndexed$9(arg7, v0), ComposableLambdaKt.composableLambdaInstance(0x2F002EB, true, new LazyGridDslKt$itemsIndexed$10(arg8, v0)));
    }

    public static void itemsIndexed$default(LazyGridScope arg7, List arg8, Function2 arg9, Function3 arg10, Function2 arg11, Function5 arg12, int arg13, Object arg14) {
        LazyGridDslKt$itemsIndexed$2 v3;
        LazyGridDslKt$itemsIndexed$1 v11;
        LazyGridDslKt$itemsIndexed$3 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function2)v0);
        }

        if((arg13 & 4) != 0) {
            arg10 = ((Function3)v0);
        }

        if((arg13 & 8) != 0) {
            v11 = LazyGridDslKt$itemsIndexed$1.INSTANCE;
        }

        int v2 = arg8.size();
        if(arg9 != null) {
            v3 = new LazyGridDslKt$itemsIndexed$2(arg9, arg8);
        }
        else {
            Function1 v3_1 = ((Function1)v0);
        }

        if(arg10 != null) {
            v0 = new LazyGridDslKt$itemsIndexed$3(arg10, arg8);
        }

        arg7.items(v2, ((Function1)v3), v0, new LazyGridDslKt$itemsIndexed$4(((Function2)v11), arg8), ComposableLambdaKt.composableLambdaInstance(0x8C3BAF56, true, new LazyGridDslKt$itemsIndexed$5(arg12, arg8)));
    }

    public static void itemsIndexed$default(LazyGridScope arg7, Object[] arg8, Function2 arg9, Function3 arg10, Function2 arg11, Function5 arg12, int arg13, Object arg14) {
        Function1 v3_1;
        LazyGridDslKt$itemsIndexed$6 v11;
        LazyGridDslKt$itemsIndexed$8 v0 = null;
        if((arg13 & 2) != 0) {
            arg9 = ((Function2)v0);
        }

        if((arg13 & 4) != 0) {
            arg10 = ((Function3)v0);
        }

        if((arg13 & 8) != 0) {
            v11 = LazyGridDslKt$itemsIndexed$6.INSTANCE;
        }

        int v2 = arg8.length;
        if(arg9 != null) {
            LazyGridDslKt$itemsIndexed$7 v3 = new LazyGridDslKt$itemsIndexed$7(arg9, arg8);
        }
        else {
            v3_1 = ((Function1)v0);
        }

        if(arg10 != null) {
            v0 = new LazyGridDslKt$itemsIndexed$8(arg10, arg8);
        }

        arg7.items(v2, v3_1, v0, new LazyGridDslKt$itemsIndexed$9(((Function2)v11), arg8), ComposableLambdaKt.composableLambdaInstance(0x2F002EB, true, new LazyGridDslKt$itemsIndexed$10(arg12, arg8)));
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(GridCells arg5, Horizontal arg6, Composer arg7, int arg8) {
        int v1 = -76500289;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberColumnWidthSums)N(columns,horizontalArrangement)221@9599L849:LazyGridDsl.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0xE20F1050, "CC(remember):LazyGridDsl.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
        int v4 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
            v1 = 1;
        }

        arg8 = v0 | v1;
        Object v0_1 = arg7.rememberedValue();
        if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            GridSlotCache v0_2 = new GridSlotCache(new LazyGridDslKt$$ExternalSyntheticLambda0(arg5, arg6));
            arg7.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((LazyGridSlotsProvider)v0_1);
    }

    private static final LazyGridSlots rememberColumnWidthSums$lambda$0$0(GridCells arg8, Horizontal arg9, Density arg10, Constraints arg11) {
        int v0 = Constraints.getMaxWidth-impl(arg11.unbox-impl()) != 0x7FFFFFFF ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid\'s width should be bound by parent.");
        }

        int v4 = Constraints.getMaxWidth-impl(arg11.unbox-impl());
        int[] v5 = CollectionsKt.toIntArray(arg8.calculateCrossAxisCellSizes(arg10, v4, arg10.roundToPx-0680j_4(arg9.getSpacing-D9Ej5fM())));
        int[] v7 = new int[v5.length];
        arg9.arrange(arg10, v4, v5, LayoutDirection.Ltr, v7);
        return new LazyGridSlots(v5, v7);
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(GridCells arg5, Vertical arg6, Composer arg7, int arg8) {
        GridSlotCache v0_2;
        int v1 = 0xF702B2A0;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(rememberRowHeightSums)N(rows,verticalArrangement)245@10605L772:LazyGridDsl.kt#7791vq");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:245)");
        }

        ComposerKt.sourceInformationMarkerStart(arg7, 0x41209924, "CC(remember):LazyGridDsl.kt#9igjgp");
        v1 = 0;
        int v3 = 4;
        int v0 = (arg8 & 14 ^ 6) > v3 && (arg7.changed(arg5)) || (arg8 & 6) == v3 ? 1 : 0;
        int v4 = 0x20;
        if((arg8 & 0x70 ^ 0x30) > v4 && (arg7.changed(arg6)) || (arg8 & 0x30) == v4) {
            v1 = 1;
        }

        arg8 = v0 | v1;
        Object v0_1 = arg7.rememberedValue();
        if(arg8 != 0 || v0_1 == Composer.Companion.getEmpty()) {
            v0_2 = new GridSlotCache(new LazyGridDslKt$$ExternalSyntheticLambda3(arg5, arg6));
            arg7.updateRememberedValue(v0_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((LazyGridSlotsProvider)v0_2);
    }

    private static final LazyGridSlots rememberRowHeightSums$lambda$0$0(GridCells arg2, Vertical arg3, Density arg4, Constraints arg5) {
        int v0 = Constraints.getMaxHeight-impl(arg5.unbox-impl()) != 0x7FFFFFFF ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid\'s height should be bound by parent.");
        }

        int v5 = Constraints.getMaxHeight-impl(arg5.unbox-impl());
        int[] v2 = CollectionsKt.toIntArray(arg2.calculateCrossAxisCellSizes(arg4, v5, arg4.roundToPx-0680j_4(arg3.getSpacing-D9Ej5fM())));
        int[] v0_1 = new int[v2.length];
        arg3.arrange(arg4, v5, v2, v0_1);
        return new LazyGridSlots(v2, v0_1);
    }
}

