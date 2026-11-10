package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\u001A}\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A}\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0012\u001A\u009B\u0001\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001A\u001A\u00020\u00192\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001A\u009B\u0001\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001A\u001A\u00020\u00192\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u001E\u0010\u001C\u001Ak\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u001C\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b \u0010!\u001A\u008B\u0001\u0010\"\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0016\u001A\u00020\u00172\u001C\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b#\u0010$\u001A{\u0010%\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072,\u0010\t\u001A(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\b+\u0010!\u001A\u009D\u0001\u0010,\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032,\u0010\t\u001A(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0006\u0010\u0016\u001A\u00020\u0017H\u0003¢\u0006\u0004\b-\u0010.\u001A\u0091\u0001\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b/\u00100\u001A\u0091\u0001\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192\u001E\b\u0002\u0010\t\u001A\u0018\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\r2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b1\u00100\u001A\u008D\u0001\u00102\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072.\b\u0002\u0010\t\u001A(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b3\u0010\u0012\u001A\u0097\u0001\u00104\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0018\u001A\u00020\u00192.\b\u0002\u0010\t\u001A(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\'0&¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f2\u0013\b\u0002\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\f2\u0011\u0010\u0010\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b5\u00106¨\u00067"}, d2={"PrimaryTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "Landroidx/compose/material3/TabIndicatorScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "PrimaryScrollableTabRow", "scrollState", "Landroidx/compose/foundation/ScrollState;", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "minTabWidth", "PrimaryScrollableTabRow-cx2KkNY", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-cx2KkNY", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ScrollableTabRowImpl", "ScrollableTabRowImpl-xam5sdo", "(ILandroidx/compose/ui/Modifier;JJFFLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "TabRowWithSubcomposeImpl-DTcfvLk", "ScrollableTabRowWithSubcomposeImpl", "ScrollableTabRowWithSubcomposeImpl-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow-qhFBPw4", "TabRow", "TabRow-pAZo6Ak", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TabRowKt {
    public static final void PrimaryScrollableTabRow-cx2KkNY(int arg24, Modifier arg25, ScrollState arg26, long arg27, long arg29, float arg31, Function3 arg32, Function2 arg33, float arg34, Function2 arg35, Composer arg36, int arg37, int arg38) {
        float v8_3;
        Modifier v2_2;
        float v7;
        Function2 v10_1;
        Function3 v9;
        Modifier v0_4;
        float v6_2;
        long v2_1;
        long v4;
        ScrollState v8_2;
        long v21;
        ComposableLambda v9_1;
        long v7_1;
        long v5_2;
        ScrollState v3_1;
        Companion v0_5;
        int v19;
        int v18;
        int v17;
        int v13;
        float v11_1;
        int v10;
        long v8_1;
        int v8;
        long v6_1;
        int v6;
        ScrollState v5_1;
        int v2;
        int v1 = arg24;
        int v14 = arg37;
        int v15 = arg38;
        Composer v12 = arg36.startRestartGroup(0x1ADF69A0);
        ComposerKt.sourceInformation(v12, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)270@14011L363:TabRow.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v2 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v2 = v12.changed(v1) ? 4 : 2;
            v2 |= v14;
        }
        else {
            v2 = v14;
        }

        int v3 = v15 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v14 & 0x30) == 0) {
            int v5 = v12.changed(arg25) ? 0x20 : 16;
            v2 |= v5;
        }

        if((v14 & 0x180) == 0) {
            if((v15 & 4) == 0) {
                v5_1 = arg26;
                if(v12.changed(v5_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v5_1 = arg26;
            label_47:
                v6 = 0x80;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg26;
        }

        if((v14 & 0xC00) == 0) {
            if((v15 & 8) == 0) {
                v6_1 = arg27;
                if(v12.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v6_1 = arg27;
            label_61:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v6_1 = arg27;
        }

        if((v14 & 0x6000) == 0) {
            if((v15 & 16) == 0) {
                v8_1 = arg29;
                if(v12.changed(v8_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v8_1 = arg29;
            label_75:
                v10 = 0x2000;
            }

            v2 |= v10;
        }
        else {
            v8_1 = arg29;
        }

        v10 = v15 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v2 |= v11;
            goto label_94;
        }
        else if((v11 & v14) == 0) {
            v11_1 = arg31;
            v13 = v12.changed(v11_1) ? 0x20000 : 0x10000;
            v2 |= v13;
        }
        else {
        label_94:
            v11_1 = arg31;
        }

        v13 = v15 & 0x40;
        int v16 = 0x180000;
        if(v13 != 0) {
            v2 |= v16;
        }
        else {
            Function3 v0 = arg32;
            if((v14 & v16) == 0) {
                v17 = v12.changedInstance(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        int v0_1 = v15 & 0x80;
        v17 = 0xC00000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_126;
        }
        else if((v14 & v17) == 0) {
            v17 = v0_1;
            v18 = v12.changedInstance(arg33) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_126:
            v17 = v0_1;
        }

        v0_1 = v15 & 0x100;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v18;
            goto label_144;
        }
        else if((v14 & v18) == 0) {
            v18 = v0_1;
            v19 = v12.changed(arg34) ? 0x4000000 : 0x2000000;
            v2 |= v19;
        }
        else {
        label_144:
            v18 = v0_1;
        }

        v19 = 0x30000000;
        if((v15 & 0x200) != 0) {
            v2 |= v19;
        }
        else if((v14 & v19) == 0) {
            v19 = v12.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v2 |= v19;
        }

        int v36 = v3;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v12.shouldExecute(v0_2, v2 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "255@13328L21,256@13394L21,257@13458L19,260@13628L198");
            v3 = 0xFFFF1FFF;
            if((v14 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v36 != 0) {
                    v0_5 = Modifier.Companion;
                }
                else {
                    v0_4 = arg25;
                }

                v36 = v3;
                if((v15 & 4) != 0) {
                    v3_1 = ScrollKt.rememberScrollState(0, v12, 0, 1);
                    v2 &= -897;
                }
                else {
                    v3_1 = v5_1;
                }

                int v4_1 = 6;
                if((v15 & 8) != 0) {
                    v5_2 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v12, v4_1);
                    v2 &= 0xFFFFE3FF;
                }
                else {
                    v5_2 = v6_1;
                }

                if((v15 & 16) != 0) {
                    v7_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v12, v4_1);
                    v2 &= v36;
                }
                else {
                    v7_1 = v8_1;
                }

                float v4_2 = v10 != 0 ? TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM() : v11_1;
                if(v13 != 0) {
                    v9_1 = ComposableLambdaKt.rememberComposableLambda(0x31C9AF8F, true, new TabRowKt$PrimaryScrollableTabRow$1(v1), v12, 54);
                }
                else {
                    v9 = arg32;
                }

                v10_1 = v17 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.getLambda$-773954579$material3() : arg33;
                if(v18 != 0) {
                    v11 = v2;
                    long v22 = v7_1;
                    v8_2 = v3_1;
                    v2_1 = v5_2;
                    v7 = TabRowDefaults.INSTANCE.getScrollableTabRowMinTabWidth-D9Ej5fM();
                    v6_2 = v4_2;
                    v4 = v22;
                    goto label_270;
                }

                v11 = v2;
                v21 = v7_1;
                v7 = arg34;
                v8_2 = v3_1;
                v2_1 = v5_2;
                v6_2 = v4_2;
                v4 = v21;
            }
            else {
                v12.skipToGroupEnd();
                if((v15 & 4) != 0) {
                    v2 &= -897;
                }

                if((v15 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v15 & 16) != 0) {
                    v2 &= v3;
                }

                v21 = v8_1;
                v8_2 = v5_1;
                v4 = v21;
                float v0_3 = v11_1;
                v11 = v2;
                v2_1 = v6_1;
                v6_2 = v0_3;
                v0_4 = arg25;
                v9 = arg32;
                v10_1 = arg33;
                v7 = arg34;
            }

        label_270:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                arg25 = ((Modifier)v0_5);
                ComposerKt.traceEventStart(0x1ADF69A0, v11, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:269)");
            }
            else {
                arg25 = ((Modifier)v0_5);
            }

            v1 = v11 >> 3;
            v0_1 = v11 & 0x7E | v1 & 0x380 | v1 & 0x1C00 | v1 & 0xE000;
            v1 = v11 << 3;
            v13 = v0_1 | v11 >> 9 & 0x70000 | v11 << 12 & 0x380000 | 0x1C00000 & v1 | v1 & 0xE000000 | 0x70000000 & v11;
            Modifier v1_1 = arg25;
            TabRowKt.ScrollableTabRowImpl-xam5sdo(arg24, v1_1, v2_1, v4, v6_2, v7, v8_2, ((Function3)v9_1), v10_1, arg35, v12, v13);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v11_1 = v7;
            v21 = v2_1;
            v2_2 = v1_1;
            v3_1 = v8_2;
            v8_3 = v6_2;
            v6_1 = v4;
            v4 = v21;
        }
        else {
            v12.skipToGroupEnd();
            v2_2 = arg25;
            v10_1 = arg33;
            v3_1 = v5_1;
            v4 = v6_1;
            v6_1 = v8_1;
            v8_3 = v11_1;
            v9 = arg32;
            v11_1 = arg34;
        }

        ScopeUpdateScope v0_6 = v12.endRestartGroup();
        if(v0_6 != null) {
            v0_6.updateScope(new TabRowKt$$ExternalSyntheticLambda3(arg24, v2_2, v3_1, v4, v6_1, v8_3, ((Function3)v9_1), v10_1, v11_1, arg35, v14, v15));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for Binary Compatibility.") public static final void PrimaryScrollableTabRow-qhFBPw4(int arg24, Modifier arg25, ScrollState arg26, long arg27, long arg29, float arg31, Function3 arg32, Function2 arg33, Function2 arg34, Composer arg35, int arg36, int arg37) {
        Modifier v2_3;
        ScrollState v3_2;
        long v4_1;
        long v6_2;
        float v8_2;
        Function3 v9_3;
        Function2 v10_1;
        Function3 v8;
        float v7_2;
        long v3_1;
        int v10;
        Function2 v9_2;
        long v5_1;
        ScrollState v2_2;
        Modifier v1_2;
        ComposableLambda v8_1;
        long v20;
        ComposableLambda v1_3;
        Companion v5_2;
        int v18;
        int v17;
        int v14;
        float v13_1;
        int v11;
        long v9_1;
        int v9;
        long v7_1;
        int v7;
        ScrollState v6_1;
        Modifier v5;
        int v3;
        int v0 = arg24;
        int v15 = arg36;
        int v1 = arg37;
        Composer v12 = arg35.startRestartGroup(1501129198);
        ComposerKt.sourceInformation(v12, "C(PrimaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1205@51273L397:TabRow.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v3 = v12.changed(v0) ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v1 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg25;
            int v6 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_36:
            v5 = arg25;
        }

        if((v15 & 0x180) == 0) {
            if((v1 & 4) == 0) {
                v6_1 = arg26;
                if(v12.changed(v6_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v6_1 = arg26;
            label_47:
                v7 = 0x80;
            }

            v3 |= v7;
        }
        else {
            v6_1 = arg26;
        }

        if((v15 & 0xC00) == 0) {
            if((v1 & 8) == 0) {
                v7_1 = arg27;
                if(v12.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v7_1 = arg27;
            label_61:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 16) == 0) {
                v9_1 = arg29;
                if(v12.changed(v9_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v9_1 = arg29;
            label_75:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg29;
        }

        v11 = v1 & 0x20;
        int v13 = 0x30000;
        if(v11 != 0) {
            v3 |= v13;
            goto label_94;
        }
        else if((v13 & v15) == 0) {
            v13_1 = arg31;
            v14 = v12.changed(v13_1) ? 0x20000 : 0x10000;
            v3 |= v14;
        }
        else {
        label_94:
            v13_1 = arg31;
        }

        v14 = v1 & 0x40;
        int v16 = 0x180000;
        if(v14 != 0) {
            v3 |= v16;
        }
        else {
            Function3 v2 = arg32;
            if((v15 & v16) == 0) {
                v17 = v12.changedInstance(v2) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        int v2_1 = v1 & 0x80;
        v17 = 0xC00000;
        if(v2_1 != 0) {
            v3 |= v17;
            goto label_126;
        }
        else if((v15 & v17) == 0) {
            v17 = v2_1;
            v18 = v12.changedInstance(arg33) ? 0x800000 : 0x400000;
            v3 |= v18;
        }
        else {
        label_126:
            v17 = v2_1;
        }

        v18 = 0x6000000;
        if((v1 & 0x100) != 0) {
            v3 |= v18;
        }
        else if((v15 & v18) == 0) {
            int v19 = v12.changedInstance(arg34) ? 0x4000000 : 0x2000000;
            v3 |= v19;
        }

        int v35 = v4;
        boolean v1_1 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v1_1, v3 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "1191@50656L21,1192@50722L21,1193@50786L19,1196@50956L198");
            v2_1 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v35 != 0) {
                    v5_2 = Modifier.Companion;
                }

                if((arg37 & 4) != 0) {
                    v3 &= -897;
                    v6_1 = ScrollKt.rememberScrollState(0, v12, 0, 1);
                }

                v35 = v2_1;
                v2_1 = 6;
                if((arg37 & 8) != 0) {
                    v7_1 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v12, v2_1);
                    v3 &= 0xFFFFE3FF;
                }

                if((arg37 & 16) != 0) {
                    v3 &= v35;
                    v9_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v12, v2_1);
                }

                if(v11 != 0) {
                    v13_1 = TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM();
                }

                if(v14 != 0) {
                    v1_3 = ComposableLambdaKt.rememberComposableLambda(-1872002465, true, new TabRowKt$PrimaryScrollableTabRow$3(v0), v12, 54);
                }
                else {
                    Function3 v1_4 = arg32;
                }

                if(v17 != 0) {
                    v20 = v7_1;
                    v8_1 = v1_3;
                    v1_2 = ((Modifier)v5_2);
                    v7_2 = v13_1;
                    long v22 = v9_1;
                    v9_2 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$-306947391$material3();
                    v10 = v3;
                    v2_2 = v6_1;
                    v3_1 = v20;
                    v5_1 = v22;
                    goto label_241;
                }

                v2_2 = v6_1;
                v20 = v9_1;
                v9_2 = arg33;
                v10 = v3;
                v3_1 = v7_1;
                v7_2 = v13_1;
                v8_1 = v1_3;
                v1_2 = ((Modifier)v5_2);
                v5_1 = v20;
            }
            else {
                v12.skipToGroupEnd();
                if((arg37 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg37 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((arg37 & 16) != 0) {
                    v3 &= v2_1;
                }

                v1_2 = v5;
                v2_2 = v6_1;
                v5_1 = v9_1;
                v9_2 = arg33;
                v10 = v3;
                v3_1 = v7_1;
                v7_2 = v13_1;
                v8 = arg32;
            }

        label_241:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1501129198, v10, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:1205)");
            }

            TabRowKt.PrimaryScrollableTabRow-cx2KkNY(v0, v1_2, v2_2, v3_1, v5_1, v7_2, v8, v9_2, TabRowDefaults.INSTANCE.getScrollableTabRowMinTabWidth-D9Ej5fM(), arg34, v12, v10 & 14 | v18 | v10 & 0x70 | v10 & 0x380 | v10 & 0x1C00 | 0xE000 & v10 | 0x70000 & v10 | 0x380000 & v10 | 0x1C00000 & v10 | v10 << 3 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v9_2;
            v9_3 = v8;
            v8_2 = v7_2;
            v6_2 = v5_1;
            v4_1 = v3_1;
            v3_2 = v2_2;
            v2_3 = v1_2;
        }
        else {
            v12.skipToGroupEnd();
            v2_3 = v5;
            v3_2 = v6_1;
            v4_1 = v7_1;
            v6_2 = v9_1;
            v8_2 = v13_1;
            v9_3 = arg32;
            v10_1 = arg33;
        }

        ScopeUpdateScope v14_1 = v12.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new TabRowKt$$ExternalSyntheticLambda7(arg24, v2_3, v3_2, v4_1, v6_2, v8_2, v9_3, v10_1, arg34, v15, arg37));
        }
    }

    static final Unit PrimaryScrollableTabRow_cx2KkNY$lambda$2(int arg16, Modifier arg17, ScrollState arg18, long arg19, long arg21, float arg23, Function3 arg24, Function2 arg25, float arg26, Function2 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        TabRowKt.PrimaryScrollableTabRow-cx2KkNY(arg16, arg17, arg18, arg19, arg21, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    static final Unit PrimaryScrollableTabRow_qhFBPw4$lambda$8(int arg15, Modifier arg16, ScrollState arg17, long arg18, long arg20, float arg22, Function3 arg23, Function2 arg24, Function2 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TabRowKt.PrimaryScrollableTabRow-qhFBPw4(arg15, arg16, arg17, arg18, arg20, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void PrimaryTabRow-pAZo6Ak(int arg21, Modifier arg22, long arg23, long arg25, Function3 arg27, Function2 arg28, Function2 arg29, Composer arg30, int arg31, int arg32) {
        Function2 v8_4;
        Function3 v7;
        long v5_1;
        long v3_1;
        Modifier v2_1;
        Composer v19;
        long v14_2;
        long v12_1;
        int v0_1;
        Function2 v17;
        ComposableLambda v16_2;
        Companion v11_2;
        ComposableLambda v8_2;
        long v4_1;
        Companion v0_2;
        Function2 v14_1;
        int v13;
        Function3 v12;
        int v11;
        long v8_1;
        int v8;
        long v6_1;
        int v3;
        int v1 = arg21;
        int v10 = arg31;
        Composer v2 = arg30.startRestartGroup(0xC39F3D73);
        ComposerKt.sourceInformation(v2, "C(PrimaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)163@7987L76:TabRow.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = arg32 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            int v6 = v2.changed(arg22) ? 0x20 : 16;
            v3 |= v6;
        }

        if((v10 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v6_1 = arg23;
                if(v2.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v6_1 = arg23;
            label_46:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg23;
        }

        if((v10 & 0xC00) == 0) {
            if((arg32 & 8) == 0) {
                v8_1 = arg25;
                if(v2.changed(v8_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_60;
                }
            }
            else {
                v8_1 = arg25;
            label_60:
                v11 = 0x400;
            }

            v3 |= v11;
        }
        else {
            v8_1 = arg25;
        }

        v11 = arg32 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_78;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg27;
            v13 = v2.changedInstance(v12) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_78:
            v12 = arg27;
        }

        v13 = arg32 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v3 |= v14;
            goto label_94;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg28;
            int v15 = v2.changedInstance(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_94:
            v14_1 = arg28;
        }

        int v16 = 0x180000;
        if((arg32 & 0x40) != 0) {
            v3 |= v16;
        }
        else if((v10 & v16) == 0) {
            v16 = v2.changedInstance(arg29) ? 0x100000 : 0x80000;
            v3 |= v16;
        }

        int v30 = v4;
        boolean v0 = (v3 & 0x92493) != 0x92492 ? true : false;
        if(v2.shouldExecute(v0, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "152@7536L21,153@7600L19,154@7679L189");
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v30 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = arg22;
                }

                int v5 = 6;
                if((arg32 & 4) != 0) {
                    v6_1 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v2, v5);
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v4_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v2, v5);
                    v3 &= 0xFFFFE3FF;
                }
                else {
                    v4_1 = v8_1;
                }

                if(v11 != 0) {
                    v8_2 = ComposableLambdaKt.rememberComposableLambda(0x4FC46FE2, true, new TabRowKt$PrimaryTabRow$1(v1), v2, 54);
                }
                else {
                    Function3 v8_3 = v12;
                }

                if(v13 != 0) {
                    v11_2 = v0_2;
                    v14_2 = v4_1;
                    v12_1 = v6_1;
                    v16_2 = v8_2;
                    v17 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$-1429684928$material3();
                    v0_1 = 0xC39F3D73;
                    goto label_186;
                }

                v11_2 = v0_2;
                v12_1 = v6_1;
                v16_2 = v8_2;
                v17 = v14_1;
                v0_1 = 0xC39F3D73;
                v14_2 = v4_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg32 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                Modifier v11_1 = arg22;
                Function3 v16_1 = v12;
                v17 = v14_1;
                v0_1 = 0xC39F3D73;
                v12_1 = v6_1;
                v14_2 = v8_1;
            }

        label_186:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v3, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:162)");
            }

            v19 = v2;
            TabRowKt.TabRowImpl-DTcfvLk(((Modifier)v11_2), v12_1, v14_2, ((Function3)v16_2), v17, arg29, v19, v3 >> 3 & 0x7FFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v11_2);
            v3_1 = v12_1;
            v5_1 = v14_2;
            v7 = ((Function3)v16_2);
            v8_4 = v17;
        }
        else {
            v19 = v2;
            v19.skipToGroupEnd();
            v2_1 = arg22;
            v3_1 = v6_1;
            v5_1 = v8_1;
            v7 = v12;
            v8_4 = v14_1;
        }

        ScopeUpdateScope v12_2 = v19.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new TabRowKt$$ExternalSyntheticLambda9(v1, v2_1, v3_1, v5_1, v7, v8_4, arg29, v10, arg32));
        }
    }

    static final Unit PrimaryTabRow_pAZo6Ak$lambda$0(int arg13, Modifier arg14, long arg15, long arg17, Function3 arg19, Function2 arg20, Function2 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        TabRowKt.PrimaryTabRow-pAZo6Ak(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Replaced with PrimaryScrollableTabRow and SecondaryScrollableTabRow tab variants.", replaceWith="<_subannotation>") public static final void ScrollableTabRow-sKfQg0A(int arg21, Modifier arg22, long arg23, long arg25, float arg27, Function3 arg28, Function2 arg29, Function2 arg30, Composer arg31, int arg32, int arg33) {
        Function2 v9_1;
        Modifier v2_1;
        Function3 v1_2;
        float v7_2;
        long v3_1;
        long v19_1;
        Function2 v8_2;
        ComposableLambda v1_5;
        Companion v2_2;
        Function3 v8_1;
        Companion v1_3;
        int v18;
        int v16;
        Function3 v13_1;
        int v12;
        float v10;
        int v9;
        long v7_1;
        int v7;
        long v5_1;
        int v2;
        int v0 = arg21;
        int v14 = arg32;
        int v15 = arg33;
        Composer v11 = arg31.startRestartGroup(0x327CF4BC);
        ComposerKt.sourceInformation(v11, "C(ScrollableTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1423@61760L21,1414@61436L352:TabRow.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v2 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v2 = v11.changed(v0) ? 4 : 2;
            v2 |= v14;
        }
        else {
            v2 = v14;
        }

        int v3 = v15 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v14 & 0x30) == 0) {
            int v5 = v11.changed(arg22) ? 0x20 : 16;
            v2 |= v5;
        }

        if((v14 & 0x180) == 0) {
            if((v15 & 4) == 0) {
                v5_1 = arg23;
                if(v11.changed(v5_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v5_1 = arg23;
            label_47:
                v7 = 0x80;
            }

            v2 |= v7;
        }
        else {
            v5_1 = arg23;
        }

        if((v14 & 0xC00) == 0) {
            if((v15 & 8) == 0) {
                v7_1 = arg25;
                if(v11.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v7_1 = arg25;
            label_61:
                v9 = 0x400;
            }

            v2 |= v9;
        }
        else {
            v7_1 = arg25;
        }

        v9 = v15 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v14 & 0x6000) == 0) {
            v10 = arg27;
            v12 = v11.changed(v10) ? 0x4000 : 0x2000;
            v2 |= v12;
        }
        else {
        label_79:
            v10 = arg27;
        }

        v12 = v15 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v2 |= v13;
            goto label_95;
        }
        else if((v13 & v14) == 0) {
            v13_1 = arg28;
            v16 = v11.changedInstance(v13_1) ? 0x20000 : 0x10000;
            v2 |= v16;
        }
        else {
        label_95:
            v13_1 = arg28;
        }

        v16 = v15 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            Function2 v1 = arg29;
            if((v14 & v17) == 0) {
                v18 = v11.changedInstance(v1) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v18 = 0xC00000;
        if((v15 & 0x80) != 0) {
            v2 |= v18;
        }
        else if((v14 & v18) == 0) {
            v18 = v11.changedInstance(arg30) ? 0x800000 : 0x400000;
            v2 |= v18;
        }

        int v31 = v3;
        boolean v1_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v11.shouldExecute(v1_1, v2 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "1402@60906L21,1403@60970L19,1406@61153L164");
            if((v14 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v31 != 0) {
                    v1_3 = Modifier.Companion;
                }
                else {
                    Modifier v1_4 = arg22;
                }

                int v4 = 6;
                if((v15 & 4) != 0) {
                    v5_1 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v11, v4);
                    v2 &= -897;
                }

                if((v15 & 8) != 0) {
                    v3_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v11, v4);
                    v2 &= 0xFFFFE3FF;
                }
                else {
                    v3_1 = v7_1;
                }

                v7_2 = v9 != 0 ? TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM() : v10;
                if(v12 != 0) {
                    ComposableLambda v8 = ComposableLambdaKt.rememberComposableLambda(0xD50EF081, true, new TabRowKt$ScrollableTabRow$1(v0), v11, 54);
                }
                else {
                    v8_1 = v13_1;
                }

                if(v16 != 0) {
                    int v19 = v2;
                    v2_2 = v1_3;
                    v1_5 = ((ComposableLambda)v8_1);
                    v8_2 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$-358046007$material3();
                    v9 = v19;
                    v19_1 = v5_1;
                    v5_1 = v3_1;
                    v3_1 = v19_1;
                    goto label_211;
                }

                v19_1 = v5_1;
                v5_1 = v3_1;
                v3_1 = v19_1;
                v9 = v2;
                v2_2 = v1_3;
                v1_5 = ((ComposableLambda)v8_1);
            label_159:
                v8_2 = arg29;
            }
            else {
                v11.skipToGroupEnd();
                if((v15 & 4) != 0) {
                    v2 &= -897;
                }

                if((v15 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v9 = v2;
                v3_1 = v5_1;
                v5_1 = v7_1;
                v7_2 = v10;
                v1_2 = v13_1;
                v2_1 = arg22;
                goto label_159;
            }

        label_211:
            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x327CF4BC, v9, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:1413)");
            }

            v13 = v9 << 3;
            TabRowKt.ScrollableTabRowWithSubcomposeImpl-qhFBPw4(arg21, v1_2, v2_1, v3_1, v5_1, v7_2, v8_2, arg30, ScrollKt.rememberScrollState(0, v11, 0, 1), v11, v13 & 0x380 | (v9 & 14 | v9 >> 12 & 0x70) | v13 & 0x1C00 | 0xE000 & v13 | 0x70000 & v13 | 0x380000 & v9 | v9 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = v8_2;
            v8_1 = v1_2;
        }
        else {
            v11.skipToGroupEnd();
            v2_1 = arg22;
            v9_1 = arg29;
            v3_1 = v5_1;
            v5_1 = v7_1;
            v7_2 = v10;
            v8_1 = v13_1;
        }

        ScopeUpdateScope v13_2 = v11.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new TabRowKt$$ExternalSyntheticLambda2(arg21, v2_1, v3_1, v5_1, v7_2, v8_1, v9_1, arg30, v14, v15));
        }
    }

    private static final void ScrollableTabRowImpl-xam5sdo(int arg27, Modifier arg28, long arg29, long arg31, float arg33, float arg34, ScrollState arg35, Function3 arg36, Function2 arg37, Function2 arg38, Composer arg39, int arg40) {
        Composer v24;
        int v16;
        Function2 v6_1;
        int v6;
        ScrollState v5_1;
        int v5;
        int v3;
        int v2;
        int v13 = arg40;
        Composer v1 = arg39.startRestartGroup(414860860);
        ComposerKt.sourceInformation(v1, "C(ScrollableTabRowImpl)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,minTabWidth:c#ui.unit.Dp,scrollState,indicator,divider,tabs)522@24247L5677,522@24165L5759:TabRow.kt#uh7d8r");
        int v9 = arg27;
        if((v13 & 6) == 0) {
            v2 = v1.changed(v9) ? 4 : 2;
            v2 |= v13;
        }
        else {
            v2 = v13;
        }

        Modifier v14 = arg28;
        if((v13 & 0x30) == 0) {
            v3 = v1.changed(v14) ? 0x20 : 16;
            v2 |= v3;
        }

        long v11 = arg29;
        if((v13 & 0x180) == 0) {
            v3 = v1.changed(v11) ? 0x100 : 0x80;
            v2 |= v3;
        }

        if((v13 & 0xC00) == 0) {
            v5 = v1.changed(arg31) ? 0x800 : 0x400;
            v2 |= v5;
        }

        float v7 = arg33;
        if((v13 & 0x6000) == 0) {
            v5 = v1.changed(v7) ? 0x4000 : 0x2000;
            v2 |= v5;
        }

        float v8 = arg34;
        if((0x30000 & v13) == 0) {
            v5 = v1.changed(v8) ? 0x20000 : 0x10000;
            v2 |= v5;
        }

        if((0x180000 & v13) == 0) {
            v5_1 = arg35;
            v6 = v1.changed(v5_1) ? 0x100000 : 0x80000;
            v2 |= v6;
        }
        else {
            v5_1 = arg35;
        }

        int v15 = 0xC00000;
        Function3 v10 = arg36;
        if((v13 & v15) == 0) {
            v6 = v1.changedInstance(v10) ? 0x800000 : 0x400000;
            v2 |= v6;
        }

        if((0x6000000 & v13) == 0) {
            v6_1 = arg37;
            v16 = v1.changedInstance(v6_1) ? 0x4000000 : 0x2000000;
            v2 |= v16;
        }
        else {
            v6_1 = arg37;
        }

        int v39 = v15;
        Function2 v15_1 = arg38;
        if((v13 & 0x30000000) == 0) {
            v16 = v1.changedInstance(v15_1) ? 0x20000000 : 0x10000000;
            v2 |= v16;
        }

        boolean v0 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0, v2 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(414860860, v2, -1, "androidx.compose.material3.ScrollableTabRowImpl (TabRow.kt:521)");
            }

            v24 = v1;
            SurfaceKt.Surface-T9BRK9s(v14, null, v11, arg31, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0x6FF5B981, true, new TabRowKt$ScrollableTabRowImpl$1(v5_1, v6_1, v15_1, v7, v8, v9, v10), v1, 54), v24, v2 >> 3 & 14 | v39 | v2 & 0x380 | v2 & 0x1C00, 0x72);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_158;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
        }

    label_158:
        ScopeUpdateScope v14_1 = v24.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new TabRowKt$$ExternalSyntheticLambda8(arg27, arg28, arg29, arg31, arg33, arg34, arg35, arg36, arg37, arg38, v13));
        }
    }

    static final Unit ScrollableTabRowImpl_xam5sdo$lambda$5(int arg15, Modifier arg16, long arg17, long arg19, float arg21, float arg22, ScrollState arg23, Function3 arg24, Function2 arg25, Function2 arg26, int arg27, Composer arg28, int arg29) {
        TabRowKt.ScrollableTabRowImpl-xam5sdo(arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg24, arg25, arg26, arg28, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1));
        return Unit.INSTANCE;
    }

    private static final void ScrollableTabRowWithSubcomposeImpl-qhFBPw4(int arg27, Function3 arg28, Modifier arg29, long arg30, long arg32, float arg34, Function2 arg35, Function2 arg36, ScrollState arg37, Composer arg38, int arg39, int arg40) {
        long v6_4;
        long v4;
        Modifier v3_1;
        Function2 v9_2;
        float v8;
        Composer v24;
        Function2 v2_1;
        Companion v6_1;
        int v18;
        int v17;
        int v15;
        float v14_1;
        int v11;
        long v9_1;
        int v9;
        long v7_1;
        Modifier v6;
        int v5;
        int v3;
        int v12 = arg39;
        int v13 = arg40;
        Composer v1 = arg38.startRestartGroup(901781420);
        ComposerKt.sourceInformation(v1, "C(ScrollableTabRowWithSubcomposeImpl)N(selectedTabIndex,indicator,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,divider,tabs,scrollState)835@36626L4172,835@36544L4254:TabRow.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v1.changed(arg27) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        if((v13 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v5 = v1.changedInstance(arg28) ? 0x20 : 16;
            v3 |= v5;
        }

        v5 = v13 & 4;
        if(v5 != 0) {
            v3 |= 0x180;
            goto label_54;
        }
        else if((v12 & 0x180) == 0) {
            v6 = arg29;
            int v7 = v1.changed(v6) ? 0x100 : 0x80;
            v3 |= v7;
        }
        else {
        label_54:
            v6 = arg29;
        }

        if((v12 & 0xC00) == 0) {
            if((v13 & 8) == 0) {
                v7_1 = arg30;
                if(v1.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_65;
                }
            }
            else {
                v7_1 = arg30;
            label_65:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v7_1 = arg30;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v9_1 = arg32;
                if(v1.changed(v9_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v9_1 = arg32;
            label_79:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg32;
        }

        v11 = v13 & 0x20;
        int v14 = 0x30000;
        if(v11 != 0) {
            v3 |= v14;
            goto label_98;
        }
        else if((v14 & v12) == 0) {
            v14_1 = arg34;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_98:
            v14_1 = arg34;
        }

        v15 = v13 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            Function2 v0 = arg35;
            if((v12 & v16) == 0) {
                v17 = v1.changedInstance(v0) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        v17 = 0xC00000;
        if((v13 & 0x80) != 0) {
            v3 |= v17;
        }
        else if((v12 & v17) == 0) {
            v18 = v1.changedInstance(arg36) ? 0x800000 : 0x400000;
            v3 |= v18;
        }

        v18 = 0x6000000;
        if((v13 & 0x100) != 0) {
            v3 |= v18;
        }
        else if((v12 & v18) == 0) {
            v18 = v1.changed(arg37) ? 0x4000000 : 0x2000000;
            v3 |= v18;
        }

        boolean v0_1 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "828@36241L21,829@36305L19");
            int v2 = 0xFFFF1FFF;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v5 != 0) {
                    v6_1 = Modifier.Companion;
                }

                v5 = 6;
                if((v13 & 8) != 0) {
                    v7_1 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v1, v5);
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v9_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v1, v5);
                    v3 &= v2;
                }

                if(v11 != 0) {
                    v14_1 = TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM();
                }

                if(v15 != 0) {
                    v2_1 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$2075817209$material3();
                    goto label_174;
                }

            label_173:
                v2_1 = arg35;
            }
            else {
                v1.skipToGroupEnd();
                if((v13 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) == 0) {
                    goto label_173;
                }

                v3 &= v2;
                goto label_173;
            }

        label_174:
            long v18_1 = v9_1;
            float v0_2 = v14_1;
            v5 = v17;
            Modifier v14_2 = ((Modifier)v6_1);
            long v16_1 = v7_1;
            int v6_2 = 901781420;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6_2, v3, -1, "androidx.compose.material3.ScrollableTabRowWithSubcomposeImpl (TabRow.kt:834)");
            }

            float v31 = v0_2;
            Function2 v33 = v2_1;
            float v2_2 = v31;
            Function2 v6_3 = v33;
            int v0_3 = v3 >> 6 & 14 | v5;
            v3 >>= 3;
            v24 = v1;
            SurfaceKt.Surface-T9BRK9s(v14_2, null, v16_1, v18_1, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(0x7BD05747, true, new TabRowKt$ScrollableTabRowWithSubcomposeImpl$1(arg37, v31, arg36, v33, arg28, arg27), v1, 54), v24, v0_3 | v3 & 0x380 | v3 & 0x1C00, 0x72);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = v2_2;
            v9_2 = v6_3;
            v3_1 = v14_2;
            v4 = v16_1;
            v6_4 = v18_1;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v3_1 = v6;
            v4 = v7_1;
            v6_4 = v9_1;
            v8 = v14_1;
            v9_2 = arg35;
        }

        ScopeUpdateScope v14_3 = v24.endRestartGroup();
        if(v14_3 != null) {
            v14_3.updateScope(new TabRowKt$$ExternalSyntheticLambda5(arg27, arg28, v3_1, v4, v6_4, v8, v9_2, arg36, arg37, v12, v13));
        }
    }

    static final Unit ScrollableTabRowWithSubcomposeImpl_qhFBPw4$lambda$7(int arg15, Function3 arg16, Modifier arg17, long arg18, long arg20, float arg22, Function2 arg23, Function2 arg24, ScrollState arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TabRowKt.ScrollableTabRowWithSubcomposeImpl-qhFBPw4(arg15, arg16, arg17, arg18, arg20, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    static final Unit ScrollableTabRow_sKfQg0A$lambda$11(int arg14, Modifier arg15, long arg16, long arg18, float arg20, Function3 arg21, Function2 arg22, Function2 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        TabRowKt.ScrollableTabRow-sKfQg0A(arg14, arg15, arg16, arg18, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void SecondaryScrollableTabRow-cx2KkNY(int arg24, Modifier arg25, ScrollState arg26, long arg27, long arg29, float arg31, Function3 arg32, Function2 arg33, float arg34, Function2 arg35, Composer arg36, int arg37, int arg38) {
        float v8_3;
        Modifier v2_2;
        float v7;
        Function2 v10_1;
        Function3 v9;
        Modifier v0_4;
        float v6_2;
        long v2_1;
        long v4;
        ScrollState v8_2;
        long v21;
        long v7_1;
        long v5_2;
        ScrollState v3_1;
        Companion v0_5;
        int v19;
        int v18;
        int v17;
        int v13;
        float v11_1;
        int v10;
        long v8_1;
        int v8;
        long v6_1;
        int v6;
        ScrollState v5_1;
        int v2;
        int v1 = arg24;
        int v14 = arg37;
        int v15 = arg38;
        Composer v12 = arg36.startRestartGroup(0x1EF0C212);
        ComposerKt.sourceInformation(v12, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,minTabWidth:c#ui.unit.Dp,tabs)340@17697L363:TabRow.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v2 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v2 = v12.changed(v1) ? 4 : 2;
            v2 |= v14;
        }
        else {
            v2 = v14;
        }

        int v3 = v15 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
        }
        else if((v14 & 0x30) == 0) {
            int v5 = v12.changed(arg25) ? 0x20 : 16;
            v2 |= v5;
        }

        if((v14 & 0x180) == 0) {
            if((v15 & 4) == 0) {
                v5_1 = arg26;
                if(v12.changed(v5_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v5_1 = arg26;
            label_47:
                v6 = 0x80;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg26;
        }

        if((v14 & 0xC00) == 0) {
            if((v15 & 8) == 0) {
                v6_1 = arg27;
                if(v12.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v6_1 = arg27;
            label_61:
                v8 = 0x400;
            }

            v2 |= v8;
        }
        else {
            v6_1 = arg27;
        }

        if((v14 & 0x6000) == 0) {
            if((v15 & 16) == 0) {
                v8_1 = arg29;
                if(v12.changed(v8_1)) {
                    v10 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v8_1 = arg29;
            label_75:
                v10 = 0x2000;
            }

            v2 |= v10;
        }
        else {
            v8_1 = arg29;
        }

        v10 = v15 & 0x20;
        int v11 = 0x30000;
        if(v10 != 0) {
            v2 |= v11;
            goto label_94;
        }
        else if((v11 & v14) == 0) {
            v11_1 = arg31;
            v13 = v12.changed(v11_1) ? 0x20000 : 0x10000;
            v2 |= v13;
        }
        else {
        label_94:
            v11_1 = arg31;
        }

        v13 = v15 & 0x40;
        int v16 = 0x180000;
        if(v13 != 0) {
            v2 |= v16;
        }
        else {
            Function3 v0 = arg32;
            if((v14 & v16) == 0) {
                v17 = v12.changedInstance(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        int v0_1 = v15 & 0x80;
        v17 = 0xC00000;
        if(v0_1 != 0) {
            v2 |= v17;
            goto label_126;
        }
        else if((v14 & v17) == 0) {
            v17 = v0_1;
            v18 = v12.changedInstance(arg33) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_126:
            v17 = v0_1;
        }

        v0_1 = v15 & 0x100;
        v18 = 0x6000000;
        if(v0_1 != 0) {
            v2 |= v18;
            goto label_144;
        }
        else if((v14 & v18) == 0) {
            v18 = v0_1;
            v19 = v12.changed(arg34) ? 0x4000000 : 0x2000000;
            v2 |= v19;
        }
        else {
        label_144:
            v18 = v0_1;
        }

        v19 = 0x30000000;
        if((v15 & 0x200) != 0) {
            v2 |= v19;
        }
        else if((v14 & v19) == 0) {
            v19 = v12.changedInstance(arg35) ? 0x20000000 : 0x10000000;
            v2 |= v19;
        }

        int v36 = v3;
        boolean v0_2 = (v2 & 306783379) != 306783378 ? true : false;
        if(v12.shouldExecute(v0_2, v2 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "326@17048L21,327@17114L23,328@17180L21,331@17352L160");
            v3 = 0xFFFF1FFF;
            if((v14 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v36 != 0) {
                    v0_5 = Modifier.Companion;
                }
                else {
                    v0_4 = arg25;
                }

                v36 = v3;
                if((v15 & 4) != 0) {
                    v3_1 = ScrollKt.rememberScrollState(0, v12, 0, 1);
                    v2 &= -897;
                }
                else {
                    v3_1 = v5_1;
                }

                int v4_1 = 6;
                if((v15 & 8) != 0) {
                    v5_2 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(v12, v4_1);
                    v2 &= 0xFFFFE3FF;
                }
                else {
                    v5_2 = v6_1;
                }

                if((v15 & 16) != 0) {
                    v7_1 = TabRowDefaults.INSTANCE.getSecondaryContentColor(v12, v4_1);
                    v2 &= v36;
                }
                else {
                    v7_1 = v8_1;
                }

                float v4_2 = v10 != 0 ? TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM() : v11_1;
                if(v13 != 0) {
                    ComposableLambda v9_1 = ComposableLambdaKt.rememberComposableLambda(610355265, true, new TabRowKt$SecondaryScrollableTabRow$1(v1), v12, 54);
                }
                else {
                    v9 = arg32;
                }

                v10_1 = v17 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.getLambda$303717663$material3() : arg33;
                if(v18 != 0) {
                    v11 = v2;
                    long v22 = v7_1;
                    v8_2 = v3_1;
                    v2_1 = v5_2;
                    v7 = TabRowDefaults.INSTANCE.getScrollableTabRowMinTabWidth-D9Ej5fM();
                    v6_2 = v4_2;
                    v4 = v22;
                    goto label_270;
                }

                v11 = v2;
                v21 = v7_1;
                v7 = arg34;
                v8_2 = v3_1;
                v2_1 = v5_2;
                v6_2 = v4_2;
                v4 = v21;
            }
            else {
                v12.skipToGroupEnd();
                if((v15 & 4) != 0) {
                    v2 &= -897;
                }

                if((v15 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                if((v15 & 16) != 0) {
                    v2 &= v3;
                }

                v21 = v8_1;
                v8_2 = v5_1;
                v4 = v21;
                float v0_3 = v11_1;
                v11 = v2;
                v2_1 = v6_1;
                v6_2 = v0_3;
                v0_4 = arg25;
                v9 = arg32;
                v10_1 = arg33;
                v7 = arg34;
            }

        label_270:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                arg25 = ((Modifier)v0_5);
                ComposerKt.traceEventStart(0x1EF0C212, v11, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:339)");
            }
            else {
                arg25 = ((Modifier)v0_5);
            }

            v1 = v11 >> 3;
            v0_1 = v11 & 0x7E | v1 & 0x380 | v1 & 0x1C00 | v1 & 0xE000;
            v1 = v11 << 3;
            v13 = v0_1 | v11 >> 9 & 0x70000 | v11 << 12 & 0x380000 | 0x1C00000 & v1 | v1 & 0xE000000 | 0x70000000 & v11;
            Modifier v1_1 = arg25;
            TabRowKt.ScrollableTabRowImpl-xam5sdo(arg24, v1_1, v2_1, v4, v6_2, v7, v8_2, v9, v10_1, arg35, v12, v13);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v11_1 = v7;
            v21 = v2_1;
            v2_2 = v1_1;
            v3_1 = v8_2;
            v8_3 = v6_2;
            v6_1 = v4;
            v4 = v21;
        }
        else {
            v12.skipToGroupEnd();
            v2_2 = arg25;
            v10_1 = arg33;
            v3_1 = v5_1;
            v4 = v6_1;
            v6_1 = v8_1;
            v8_3 = v11_1;
            v9 = arg32;
            v11_1 = arg34;
        }

        ScopeUpdateScope v0_6 = v12.endRestartGroup();
        if(v0_6 != null) {
            v0_6.updateScope(new TabRowKt$$ExternalSyntheticLambda4(arg24, v2_2, v3_1, v4, v6_1, v8_3, v9, v10_1, v11_1, arg35, v14, v15));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for Binary Compatibility.") public static final void SecondaryScrollableTabRow-qhFBPw4(int arg24, Modifier arg25, ScrollState arg26, long arg27, long arg29, float arg31, Function3 arg32, Function2 arg33, Function2 arg34, Composer arg35, int arg36, int arg37) {
        Modifier v2_3;
        ScrollState v3_2;
        long v4_1;
        long v6_2;
        float v8_2;
        Function3 v9_3;
        Function2 v10_1;
        Function3 v8;
        float v7_2;
        long v3_1;
        int v10;
        Function2 v9_2;
        long v5_1;
        ScrollState v2_2;
        Modifier v1_2;
        ComposableLambda v8_1;
        long v20;
        Function3 v1_4;
        Companion v5_2;
        int v18;
        int v17;
        int v14;
        float v13_1;
        int v11;
        long v9_1;
        int v9;
        long v7_1;
        int v7;
        ScrollState v6_1;
        Modifier v5;
        int v3;
        int v0 = arg24;
        int v15 = arg36;
        int v1 = arg37;
        Composer v12 = arg35.startRestartGroup(0xD58236BC);
        ComposerKt.sourceInformation(v12, "C(SecondaryScrollableTabRow)N(selectedTabIndex,modifier,scrollState,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,indicator,divider,tabs)1236@52486L399:TabRow.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v3 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v3 = v12.changed(v0) ? 4 : 2;
            v3 |= v15;
        }
        else {
            v3 = v15;
        }

        int v4 = v1 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v15 & 0x30) == 0) {
            v5 = arg25;
            int v6 = v12.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_36:
            v5 = arg25;
        }

        if((v15 & 0x180) == 0) {
            if((v1 & 4) == 0) {
                v6_1 = arg26;
                if(v12.changed(v6_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_47;
                }
            }
            else {
                v6_1 = arg26;
            label_47:
                v7 = 0x80;
            }

            v3 |= v7;
        }
        else {
            v6_1 = arg26;
        }

        if((v15 & 0xC00) == 0) {
            if((v1 & 8) == 0) {
                v7_1 = arg27;
                if(v12.changed(v7_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v7_1 = arg27;
            label_61:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v7_1 = arg27;
        }

        if((v15 & 0x6000) == 0) {
            if((v1 & 16) == 0) {
                v9_1 = arg29;
                if(v12.changed(v9_1)) {
                    v11 = 0x4000;
                }
                else {
                    goto label_75;
                }
            }
            else {
                v9_1 = arg29;
            label_75:
                v11 = 0x2000;
            }

            v3 |= v11;
        }
        else {
            v9_1 = arg29;
        }

        v11 = v1 & 0x20;
        int v13 = 0x30000;
        if(v11 != 0) {
            v3 |= v13;
            goto label_94;
        }
        else if((v13 & v15) == 0) {
            v13_1 = arg31;
            v14 = v12.changed(v13_1) ? 0x20000 : 0x10000;
            v3 |= v14;
        }
        else {
        label_94:
            v13_1 = arg31;
        }

        v14 = v1 & 0x40;
        int v16 = 0x180000;
        if(v14 != 0) {
            v3 |= v16;
        }
        else {
            Function3 v2 = arg32;
            if((v15 & v16) == 0) {
                v17 = v12.changedInstance(v2) ? 0x100000 : 0x80000;
                v3 |= v17;
            }
        }

        int v2_1 = v1 & 0x80;
        v17 = 0xC00000;
        if(v2_1 != 0) {
            v3 |= v17;
            goto label_126;
        }
        else if((v15 & v17) == 0) {
            v17 = v2_1;
            v18 = v12.changedInstance(arg33) ? 0x800000 : 0x400000;
            v3 |= v18;
        }
        else {
        label_126:
            v17 = v2_1;
        }

        v18 = 0x6000000;
        if((v1 & 0x100) != 0) {
            v3 |= v18;
        }
        else if((v15 & v18) == 0) {
            int v19 = v12.changedInstance(arg34) ? 0x4000000 : 0x2000000;
            v3 |= v19;
        }

        int v35 = v4;
        boolean v1_1 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v12.shouldExecute(v1_1, v3 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "1223@51903L21,1224@51969L23,1225@52035L21,1228@52207L160");
            v2_1 = 0xFFFF1FFF;
            if((v15 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v35 != 0) {
                    v5_2 = Modifier.Companion;
                }

                if((arg37 & 4) != 0) {
                    v3 &= -897;
                    v6_1 = ScrollKt.rememberScrollState(0, v12, 0, 1);
                }

                v35 = v2_1;
                v2_1 = 6;
                if((arg37 & 8) != 0) {
                    v7_1 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(v12, v2_1);
                    v3 &= 0xFFFFE3FF;
                }

                if((arg37 & 16) != 0) {
                    v3 &= v35;
                    v9_1 = TabRowDefaults.INSTANCE.getSecondaryContentColor(v12, v2_1);
                }

                if(v11 != 0) {
                    v13_1 = TabRowDefaults.INSTANCE.getScrollableTabRowEdgeStartPadding-D9Ej5fM();
                }

                if(v14 != 0) {
                    ComposableLambda v1_3 = ComposableLambdaKt.rememberComposableLambda(0x184FF6ED, true, new TabRowKt$SecondaryScrollableTabRow$3(v0), v12, 54);
                }
                else {
                    v1_4 = arg32;
                }

                if(v17 != 0) {
                    v20 = v7_1;
                    v8_1 = ((ComposableLambda)v1_4);
                    v1_2 = ((Modifier)v5_2);
                    v7_2 = v13_1;
                    long v22 = v9_1;
                    v9_2 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$1187266255$material3();
                    v10 = v3;
                    v2_2 = v6_1;
                    v3_1 = v20;
                    v5_1 = v22;
                    goto label_241;
                }

                v2_2 = v6_1;
                v20 = v9_1;
                v9_2 = arg33;
                v10 = v3;
                v3_1 = v7_1;
                v7_2 = v13_1;
                v8_1 = ((ComposableLambda)v1_4);
                v1_2 = ((Modifier)v5_2);
                v5_1 = v20;
            }
            else {
                v12.skipToGroupEnd();
                if((arg37 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg37 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((arg37 & 16) != 0) {
                    v3 &= v2_1;
                }

                v1_2 = v5;
                v2_2 = v6_1;
                v5_1 = v9_1;
                v9_2 = arg33;
                v10 = v3;
                v3_1 = v7_1;
                v7_2 = v13_1;
                v8 = arg32;
            }

        label_241:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD58236BC, v10, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:1236)");
            }

            TabRowKt.SecondaryScrollableTabRow-cx2KkNY(v0, v1_2, v2_2, v3_1, v5_1, v7_2, v8, v9_2, TabRowDefaults.INSTANCE.getScrollableTabRowMinTabWidth-D9Ej5fM(), arg34, v12, v10 & 14 | v18 | v10 & 0x70 | v10 & 0x380 | v10 & 0x1C00 | 0xE000 & v10 | 0x70000 & v10 | 0x380000 & v10 | 0x1C00000 & v10 | v10 << 3 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v9_2;
            v9_3 = v8;
            v8_2 = v7_2;
            v6_2 = v5_1;
            v4_1 = v3_1;
            v3_2 = v2_2;
            v2_3 = v1_2;
        }
        else {
            v12.skipToGroupEnd();
            v2_3 = v5;
            v3_2 = v6_1;
            v4_1 = v7_1;
            v6_2 = v9_1;
            v8_2 = v13_1;
            v9_3 = arg32;
            v10_1 = arg33;
        }

        ScopeUpdateScope v14_1 = v12.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new TabRowKt$$ExternalSyntheticLambda0(arg24, v2_3, v3_2, v4_1, v6_2, v8_2, v9_3, v10_1, arg34, v15, arg37));
        }
    }

    static final Unit SecondaryScrollableTabRow_cx2KkNY$lambda$3(int arg16, Modifier arg17, ScrollState arg18, long arg19, long arg21, float arg23, Function3 arg24, Function2 arg25, float arg26, Function2 arg27, int arg28, int arg29, Composer arg30, int arg31) {
        TabRowKt.SecondaryScrollableTabRow-cx2KkNY(arg16, arg17, arg18, arg19, arg21, arg23, arg24, arg25, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    static final Unit SecondaryScrollableTabRow_qhFBPw4$lambda$9(int arg15, Modifier arg16, ScrollState arg17, long arg18, long arg20, float arg22, Function3 arg23, Function2 arg24, Function2 arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TabRowKt.SecondaryScrollableTabRow-qhFBPw4(arg15, arg16, arg17, arg18, arg20, arg22, arg23, arg24, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void SecondaryTabRow-pAZo6Ak(int arg21, Modifier arg22, long arg23, long arg25, Function3 arg27, Function2 arg28, Function2 arg29, Composer arg30, int arg31, int arg32) {
        Function2 v8_4;
        Function3 v7;
        long v5_1;
        long v3_1;
        Modifier v2_1;
        Composer v19;
        long v14_2;
        long v12_1;
        int v0_1;
        Function2 v17;
        Function3 v16_1;
        ComposableLambda v16_2;
        Companion v11_2;
        ComposableLambda v8_2;
        long v4_1;
        Companion v0_2;
        Function2 v14_1;
        int v13;
        Function3 v12;
        int v11;
        long v8_1;
        int v8;
        long v6_1;
        int v3;
        int v1 = arg21;
        int v10 = arg31;
        Composer v2 = arg30.startRestartGroup(0x219554E5);
        ComposerKt.sourceInformation(v2, "C(SecondaryTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)214@10853L76:TabRow.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = arg32 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            int v6 = v2.changed(arg22) ? 0x20 : 16;
            v3 |= v6;
        }

        if((v10 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v6_1 = arg23;
                if(v2.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v6_1 = arg23;
            label_46:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg23;
        }

        if((v10 & 0xC00) == 0) {
            if((arg32 & 8) == 0) {
                v8_1 = arg25;
                if(v2.changed(v8_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_60;
                }
            }
            else {
                v8_1 = arg25;
            label_60:
                v11 = 0x400;
            }

            v3 |= v11;
        }
        else {
            v8_1 = arg25;
        }

        v11 = arg32 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_78;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg27;
            v13 = v2.changedInstance(v12) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_78:
            v12 = arg27;
        }

        v13 = arg32 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v3 |= v14;
            goto label_94;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg28;
            int v15 = v2.changedInstance(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_94:
            v14_1 = arg28;
        }

        int v16 = 0x180000;
        if((arg32 & 0x40) != 0) {
            v3 |= v16;
        }
        else if((v10 & v16) == 0) {
            v16 = v2.changedInstance(arg29) ? 0x100000 : 0x80000;
            v3 |= v16;
        }

        int v30 = v4;
        boolean v0 = (v3 & 0x92493) != 0x92492 ? true : false;
        if(v2.shouldExecute(v0, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "203@10407L23,204@10473L21,206@10574L160");
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v30 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = arg22;
                }

                int v5 = 6;
                if((arg32 & 4) != 0) {
                    v6_1 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(v2, v5);
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v4_1 = TabRowDefaults.INSTANCE.getSecondaryContentColor(v2, v5);
                    v3 &= 0xFFFFE3FF;
                }
                else {
                    v4_1 = v8_1;
                }

                if(v11 != 0) {
                    v8_2 = ComposableLambdaKt.rememberComposableLambda(0x3937A794, true, new TabRowKt$SecondaryTabRow$1(v1), v2, 54);
                }
                else {
                    Function3 v8_3 = v12;
                }

                if(v13 != 0) {
                    v11_2 = v0_2;
                    v14_2 = v4_1;
                    v12_1 = v6_1;
                    v16_2 = v8_2;
                    v17 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$-463596174$material3();
                    v0_1 = 0x219554E5;
                    goto label_186;
                }

                v11_2 = v0_2;
                v12_1 = v6_1;
                v16_2 = v8_2;
                v17 = v14_1;
                v0_1 = 0x219554E5;
                v14_2 = v4_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg32 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                Modifier v11_1 = arg22;
                v16_1 = v12;
                v17 = v14_1;
                v0_1 = 0x219554E5;
                v12_1 = v6_1;
                v14_2 = v8_1;
            }

        label_186:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v3, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:213)");
            }

            v19 = v2;
            TabRowKt.TabRowImpl-DTcfvLk(((Modifier)v11_2), v12_1, v14_2, v16_1, v17, arg29, v19, v3 >> 3 & 0x7FFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v11_2);
            v3_1 = v12_1;
            v5_1 = v14_2;
            v7 = v16_1;
            v8_4 = v17;
        }
        else {
            v19 = v2;
            v19.skipToGroupEnd();
            v2_1 = arg22;
            v3_1 = v6_1;
            v5_1 = v8_1;
            v7 = v12;
            v8_4 = v14_1;
        }

        ScopeUpdateScope v12_2 = v19.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new TabRowKt$$ExternalSyntheticLambda11(v1, v2_1, v3_1, v5_1, v7, v8_4, arg29, v10, arg32));
        }
    }

    static final Unit SecondaryTabRow_pAZo6Ak$lambda$1(int arg13, Modifier arg14, long arg15, long arg17, Function3 arg19, Function2 arg20, Function2 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        TabRowKt.SecondaryTabRow-pAZo6Ak(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Replaced with PrimaryTabRow and SecondaryTabRow.", replaceWith="<_subannotation>") public static final void TabRow-pAZo6Ak(int arg21, Modifier arg22, long arg23, long arg25, Function3 arg27, Function2 arg28, Function2 arg29, Composer arg30, int arg31, int arg32) {
        Function2 v8_4;
        Function3 v7;
        long v5_1;
        long v3_1;
        Modifier v2_1;
        Composer v19;
        long v14_2;
        long v12_1;
        int v0_1;
        Function2 v17;
        Modifier v11_1;
        ComposableLambda v16_2;
        Companion v11_2;
        Function3 v8_3;
        long v4_1;
        Modifier v0_3;
        Function2 v14_1;
        int v13;
        Function3 v12;
        int v11;
        long v8_1;
        int v8;
        long v6_1;
        int v3;
        int v1 = arg21;
        int v10 = arg31;
        Composer v2 = arg30.startRestartGroup(1445190381);
        ComposerKt.sourceInformation(v2, "C(TabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)1349@57943L90:TabRow.kt#uh7d8r");
        if((arg32 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changed(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = arg32 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            int v6 = v2.changed(arg22) ? 0x20 : 16;
            v3 |= v6;
        }

        if((v10 & 0x180) == 0) {
            if((arg32 & 4) == 0) {
                v6_1 = arg23;
                if(v2.changed(v6_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_46;
                }
            }
            else {
                v6_1 = arg23;
            label_46:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg23;
        }

        if((v10 & 0xC00) == 0) {
            if((arg32 & 8) == 0) {
                v8_1 = arg25;
                if(v2.changed(v8_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_60;
                }
            }
            else {
                v8_1 = arg25;
            label_60:
                v11 = 0x400;
            }

            v3 |= v11;
        }
        else {
            v8_1 = arg25;
        }

        v11 = arg32 & 16;
        if(v11 != 0) {
            v3 |= 0x6000;
            goto label_78;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg27;
            v13 = v2.changedInstance(v12) ? 0x4000 : 0x2000;
            v3 |= v13;
        }
        else {
        label_78:
            v12 = arg27;
        }

        v13 = arg32 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v3 |= v14;
            goto label_94;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg28;
            int v15 = v2.changedInstance(v14_1) ? 0x20000 : 0x10000;
            v3 |= v15;
        }
        else {
        label_94:
            v14_1 = arg28;
        }

        int v16 = 0x180000;
        if((arg32 & 0x40) != 0) {
            v3 |= v16;
        }
        else if((v10 & v16) == 0) {
            v16 = v2.changedInstance(arg29) ? 0x100000 : 0x80000;
            v3 |= v16;
        }

        int v30 = v4;
        boolean v0 = (v3 & 0x92493) != 0x92492 ? true : false;
        if(v2.shouldExecute(v0, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "1336@57402L21,1337@57466L19,1339@57578L246");
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v30 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = arg22;
                }

                int v5 = 6;
                if((arg32 & 4) != 0) {
                    v6_1 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(v2, v5);
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v4_1 = TabRowDefaults.INSTANCE.getPrimaryContentColor(v2, v5);
                    v3 &= 0xFFFFE3FF;
                }
                else {
                    v4_1 = v8_1;
                }

                if(v11 != 0) {
                    ComposableLambda v8_2 = ComposableLambdaKt.rememberComposableLambda(0x360B2308, true, new TabRowKt$TabRow$1(v1), v2, 54);
                }
                else {
                    v8_3 = v12;
                }

                if(v13 != 0) {
                    v11_2 = ((Companion)v0_3);
                    v14_2 = v4_1;
                    v12_1 = v6_1;
                    v16_2 = ((ComposableLambda)v8_3);
                    v17 = ComposableSingletons$TabRowKt.INSTANCE.getLambda$-1132537920$material3();
                    v0_1 = 1445190381;
                    goto label_186;
                }

                v11_2 = ((Companion)v0_3);
                v12_1 = v6_1;
                v16_2 = ((ComposableLambda)v8_3);
                v17 = v14_1;
                v0_1 = 1445190381;
                v14_2 = v4_1;
            }
            else {
                v2.skipToGroupEnd();
                if((arg32 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg32 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                v11_1 = arg22;
                Function3 v16_1 = v12;
                v17 = v14_1;
                v0_1 = 1445190381;
                v12_1 = v6_1;
                v14_2 = v8_1;
            }

        label_186:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v3, -1, "androidx.compose.material3.TabRow (TabRow.kt:1348)");
            }

            v19 = v2;
            TabRowKt.TabRowWithSubcomposeImpl-DTcfvLk(v11_1, v12_1, v14_2, ((Function3)v16_2), v17, arg29, v19, v3 >> 3 & 0x7FFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v11_1;
            v3_1 = v12_1;
            v5_1 = v14_2;
            v7 = ((Function3)v16_2);
            v8_4 = v17;
        }
        else {
            v19 = v2;
            v19.skipToGroupEnd();
            v2_1 = arg22;
            v3_1 = v6_1;
            v5_1 = v8_1;
            v7 = v12;
            v8_4 = v14_1;
        }

        ScopeUpdateScope v12_2 = v19.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new TabRowKt$$ExternalSyntheticLambda10(v1, v2_1, v3_1, v5_1, v7, v8_4, arg29, v10, arg32));
        }
    }

    private static final void TabRowImpl-DTcfvLk(Modifier arg23, long arg24, long arg26, Function3 arg28, Function2 arg29, Function2 arg30, Composer arg31, int arg32) {
        Composer v20;
        int v4;
        int v3;
        Modifier v2;
        Function3 v6 = arg28;
        Function2 v7 = arg29;
        Function2 v8 = arg30;
        int v9 = arg32;
        int v0 = 0x748B4C8A;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(TabRowImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)403@19706L4058,399@19575L4189:TabRow.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v2 = arg23;
            v3 = v1.changed(v2) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v2 = arg23;
            v3 = v9;
        }

        long v12 = arg24;
        if((v9 & 0x30) == 0) {
            v4 = v1.changed(v12) ? 0x20 : 16;
            v3 |= v4;
        }

        long v14 = arg26;
        if((v9 & 0x180) == 0) {
            v4 = v1.changed(v14) ? 0x100 : 0x80;
            v3 |= v4;
        }

        if((v9 & 0xC00) == 0) {
            v4 = v1.changedInstance(v6) ? 0x800 : 0x400;
            v3 |= v4;
        }

        if((v9 & 0x6000) == 0) {
            v4 = v1.changedInstance(v7) ? 0x4000 : 0x2000;
            v3 |= v4;
        }

        if((0x30000 & v9) == 0) {
            v4 = v1.changedInstance(v8) ? 0x20000 : 0x10000;
            v3 |= v4;
        }

        boolean v4_1 = (74899 & v3) != 74898 ? true : false;
        if(v1.shouldExecute(v4_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:398)");
            }

            v3 <<= 3;
            v20 = v1;
            SurfaceKt.Surface-T9BRK9s(SelectableGroupKt.selectableGroup(v2), null, v12, v14, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(830280655, true, new TabRowKt$TabRowImpl$1(v8, v7, v6), v1, 54), v20, v3 & 0x380 | 0xC00000 | v3 & 0x1C00, 0x72);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_107;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v20 = v1;
            v20.skipToGroupEnd();
        }

    label_107:
        ScopeUpdateScope v10 = v20.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new TabRowKt$$ExternalSyntheticLambda6(v2, arg24, arg26, v6, v7, v8, v9));
        }
    }

    static final Unit TabRowImpl_DTcfvLk$lambda$4(Modifier arg11, long arg12, long arg14, Function3 arg16, Function2 arg17, Function2 arg18, int arg19, Composer arg20, int arg21) {
        TabRowKt.TabRowImpl-DTcfvLk(arg11, arg12, arg14, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    private static final void TabRowWithSubcomposeImpl-DTcfvLk(Modifier arg23, long arg24, long arg26, Function3 arg28, Function2 arg29, Function2 arg30, Composer arg31, int arg32) {
        Composer v20;
        int v4;
        int v3;
        Modifier v2;
        Function3 v6 = arg28;
        Function2 v7 = arg29;
        Function2 v8 = arg30;
        int v9 = arg32;
        int v0 = 0x8DF2422;
        Composer v1 = arg31.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(TabRowWithSubcomposeImpl)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,indicator,divider,tabs)767@33784L2218,763@33653L2349:TabRow.kt#uh7d8r");
        if((v9 & 6) == 0) {
            v2 = arg23;
            v3 = v1.changed(v2) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v2 = arg23;
            v3 = v9;
        }

        long v12 = arg24;
        if((v9 & 0x30) == 0) {
            v4 = v1.changed(v12) ? 0x20 : 16;
            v3 |= v4;
        }

        long v14 = arg26;
        if((v9 & 0x180) == 0) {
            v4 = v1.changed(v14) ? 0x100 : 0x80;
            v3 |= v4;
        }

        if((v9 & 0xC00) == 0) {
            v4 = v1.changedInstance(v6) ? 0x800 : 0x400;
            v3 |= v4;
        }

        if((v9 & 0x6000) == 0) {
            v4 = v1.changedInstance(v7) ? 0x4000 : 0x2000;
            v3 |= v4;
        }

        if((0x30000 & v9) == 0) {
            v4 = v1.changedInstance(v8) ? 0x20000 : 0x10000;
            v3 |= v4;
        }

        boolean v4_1 = (74899 & v3) != 74898 ? true : false;
        if(v1.shouldExecute(v4_1, v3 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:762)");
            }

            v3 <<= 3;
            v20 = v1;
            SurfaceKt.Surface-T9BRK9s(SelectableGroupKt.selectableGroup(v2), null, v12, v14, 0f, 0f, null, ComposableLambdaKt.rememberComposableLambda(-1815327065, true, new TabRowKt$TabRowWithSubcomposeImpl$1(v8, v7, v6), v1, 54), v20, v3 & 0x380 | 0xC00000 | v3 & 0x1C00, 0x72);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_107;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v20 = v1;
            v20.skipToGroupEnd();
        }

    label_107:
        ScopeUpdateScope v10 = v20.endRestartGroup();
        if(v10 != null) {
            v10.updateScope(new TabRowKt$$ExternalSyntheticLambda1(v2, arg24, arg26, v6, v7, v8, v9));
        }
    }

    static final Unit TabRowWithSubcomposeImpl_DTcfvLk$lambda$6(Modifier arg11, long arg12, long arg14, Function3 arg16, Function2 arg17, Function2 arg18, int arg19, Composer arg20, int arg21) {
        TabRowKt.TabRowWithSubcomposeImpl-DTcfvLk(arg11, arg12, arg14, arg16, arg17, arg18, arg20, RecomposeScopeImplKt.updateChangedFlags(arg19 | 1));
        return Unit.INSTANCE;
    }

    static final Unit TabRow_pAZo6Ak$lambda$10(int arg13, Modifier arg14, long arg15, long arg17, Function3 arg19, Function2 arg20, Function2 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        TabRowKt.TabRow-pAZo6Ak(arg13, arg14, arg15, arg17, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }
}

