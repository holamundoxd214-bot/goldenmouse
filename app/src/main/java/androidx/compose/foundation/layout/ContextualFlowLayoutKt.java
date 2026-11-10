package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

@Metadata(d1={"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u008E\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u000F21\u0010\u0010\u001A-\u0012\u0004\u0012\u00020\u0012\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001A\u008E\u0001\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u001D21\u0010\u0010\u001A-\u0012\u0004\u0012\u00020\u001E\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001F\u001A­\u0001\u0010 \u001A\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010%\u001A\u00020&2\u0006\u0010\u0002\u001A\u00020\u00032\u0017\u0010\'\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001A7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010-\u001A­\u0001\u0010.\u001A\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00112\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010$\u001A\u00020\u00032\u0006\u0010\r\u001A\u00020\u00032\u0006\u0010%\u001A\u00020&2\u0006\u0010\u0002\u001A\u00020\u00032\u0017\u0010\'\u001A\u0013\u0012\u000F\u0012\r\u0012\u0004\u0012\u00020\u00010)¢\u0006\u0002\b\u00160(2;\u0010*\u001A7\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110+¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010/¨\u00060"}, d2={"ContextualFlowRow", "", "itemCount", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "maxLines", "overflow", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/ContextualFlowRowOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "ContextualFlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowColumnScope;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/ContextualFlowColumnOverflow;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "contextualRowMeasurementHelper", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "maxItemsInMainAxis", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowComposables", "", "Lkotlin/Function0;", "getComposable", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "contextualColumnMeasureHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;ILjava/util/List;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation-layout"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContextualFlowLayoutKt {
    @Deprecated(message="ContextualFlowLayouts are no longer maintained") public static final void ContextualFlowColumn(int arg24, Modifier arg25, Vertical arg26, Horizontal arg27, androidx.compose.ui.Alignment$Horizontal arg28, int arg29, int arg30, ContextualFlowColumnOverflow arg31, Function4 arg32, Composer arg33, int arg34, int arg35) {
        Horizontal v4_1;
        Vertical v3_1;
        ContextualFlowColumnOverflow v8_3;
        int v7_1;
        Horizontal v13_1;
        Companion v5_1;
        int v20;
        int v17;
        int v0;
        int v15;
        androidx.compose.ui.Alignment$Horizontal v14;
        int v13;
        int v8;
        Vertical v7;
        int v6;
        Modifier v5;
        int v3;
        Function4 v9 = arg32;
        int v10 = arg34;
        int v11 = arg35;
        Composer v1 = arg33.startRestartGroup(0x766CF2D0);
        ComposerKt.sourceInformation(v1, "C(ContextualFlowColumn)N(itemCount,modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)155@7415L53,157@7522L209,172@8034L339,163@7764L609,183@8379L68:ContextualFlowLayout.kt#2w3rfo");
        if((v10 & 6) == 0) {
            v3 = v1.changed(arg24) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_34;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg25;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_34:
            v5 = arg25;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_49;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg26;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_49:
            v7 = arg26;
        }

        v8 = v11 & 8;
        if(v8 != 0) {
            v3 |= 0xC00;
        }
        else if((v10 & 0xC00) == 0) {
            v13 = v1.changed(arg27) ? 0x800 : 0x400;
            v3 |= v13;
        }

        v13 = v11 & 16;
        if(v13 != 0) {
            v3 |= 0x6000;
            goto label_79;
        }
        else if((v10 & 0x6000) == 0) {
            v14 = arg28;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v3 |= v15;
        }
        else {
        label_79:
            v14 = arg28;
        }

        v15 = v11 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            v0 = arg29;
            if((v10 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        v17 = v11 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v3 |= v18;
        }
        else {
            v0 = arg30;
            if((v10 & v18) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        v18 = 0xC00000;
        int v19 = v11 & 0x80;
        if(v19 != 0) {
            v3 |= v18;
        }
        else {
            ContextualFlowColumnOverflow v0_1 = arg31;
            if((v10 & v18) == 0) {
                v18 = v1.changed(v0_1) ? 0x800000 : 0x400000;
                v3 |= v18;
            }
        }

        v18 = 0x6000000;
        if((v10 & v18) == 0) {
            v20 = v1.changedInstance(v9) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }

        v20 = v4;
        boolean v0_2 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v3 & 1)) {
            if(v20 != 0) {
                v5_1 = Modifier.Companion;
            }

            Vertical v12 = v6 != 0 ? Arrangement.INSTANCE.getTop() : v7;
            if(v8 != 0) {
                int v23 = v13;
                v13_1 = Arrangement.INSTANCE.getStart();
                v0 = v23;
            }
            else {
                v0 = v13;
                v13_1 = arg27;
            }

            if(v0 != 0) {
                v14 = Alignment.Companion.getStart();
            }

            v0 = 0x7FFFFFFF;
            v15 = v15 != 0 ? v0 : arg29;
            v16 = v17 != 0 ? v0 : arg30;
            v0 = 0x766CF2D0;
            ContextualFlowColumnOverflow v2 = v19 != 0 ? ContextualFlowColumnOverflow.Companion.getClip() : arg31;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.foundation.layout.ContextualFlowColumn (ContextualFlowLayout.kt:154)");
            }

            String v6_1 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, -1896103003, v6_1);
            v0 = 0x1C00000 & v3;
            v7_1 = v0 == 0x800000 ? 1 : 0;
            Object v8_1 = v1.rememberedValue();
            if(v7_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                FlowLayoutOverflowState v8_2 = v2.createOverflowState$foundation_layout();
                v1.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0x8EFBD1A1, v6_1);
            v0 = v0 == 0x800000 ? 1 : 0;
            Object v6_2 = v1.rememberedValue();
            if(v0 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                ArrayList v6_3 = new ArrayList();
                v2.addOverflowComposables$foundation_layout(((FlowLayoutOverflowState)v8_1), ((List)v6_3));
                v1.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0 = v3 >> 6;
            SubcomposeLayoutKt.SubcomposeLayout(((Modifier)v5_1), ContextualFlowLayoutKt.contextualColumnMeasureHelper(v12, v13_1, v14, v15, v16, v8_1, arg24, v6_2, ComposableLambdaKt.rememberComposableLambda(620176540, true, new ContextualFlowLayoutKt$$ExternalSyntheticLambda2(v9), v1, 54), v1, v0 & 0xE000 | (v0 & 14 | v18 | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00) | v3 << 18 & 0x380000), v1, v3 >> 3 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_3 = v2;
            v3_1 = v12;
            v4_1 = v13_1;
            v6 = v15;
            v7_1 = v16;
        }
        else {
            v1.skipToGroupEnd();
            v4_1 = arg27;
            v6 = arg29;
            v8_3 = arg31;
            v3_1 = v7;
            v7_1 = arg30;
        }

        Modifier v2_1 = ((Modifier)v5_1);
        androidx.compose.ui.Alignment$Horizontal v5_2 = v14;
        ScopeUpdateScope v12_1 = v1.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new ContextualFlowLayoutKt$$ExternalSyntheticLambda3(arg24, v2_1, v3_1, v4_1, v5_2, v6, v7_1, v8_3, v9, v10, v11));
        }
    }

    static final Unit ContextualFlowColumn$lambda$2(Function4 arg9, int arg10, FlowLineInfo arg11, Composer arg12, int arg13) {
        ComposerKt.sourceInformation(arg12, "CN(index,info)180@8349L14:ContextualFlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(620176540, arg13, -1, "androidx.compose.foundation.layout.ContextualFlowColumn.<anonymous> (ContextualFlowLayout.kt:173)");
        }

        arg9.invoke(new ContextualFlowColumnScopeImpl(arg11.getLineIndex$foundation_layout(), arg11.getPositionInLine$foundation_layout(), arg11.getMaxCrossAxisSize-D9Ej5fM$foundation_layout(), arg11.getMaxMainAxisSize-D9Ej5fM$foundation_layout(), null), Integer.valueOf(arg10), arg12, Integer.valueOf(arg13 << 3 & 0x70));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        return Unit.INSTANCE;
    }

    static final Unit ContextualFlowColumn$lambda$3(int arg13, Modifier arg14, Vertical arg15, Horizontal arg16, androidx.compose.ui.Alignment$Horizontal arg17, int arg18, int arg19, ContextualFlowColumnOverflow arg20, Function4 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ContextualFlowLayoutKt.ContextualFlowColumn(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    @Deprecated(message="ContextualFlowLayouts are no longer maintained") public static final void ContextualFlowRow(int arg24, Modifier arg25, Horizontal arg26, Vertical arg27, androidx.compose.ui.Alignment$Vertical arg28, int arg29, int arg30, ContextualFlowRowOverflow arg31, Function4 arg32, Composer arg33, int arg34, int arg35) {
        Vertical v4_1;
        Horizontal v3_1;
        ContextualFlowRowOverflow v8_3;
        int v7_1;
        Vertical v13_1;
        int v20;
        int v17;
        int v0;
        int v15;
        androidx.compose.ui.Alignment$Vertical v14;
        int v13;
        int v8;
        Horizontal v7;
        int v6;
        Modifier v5;
        int v3;
        Function4 v9 = arg32;
        int v10 = arg34;
        int v11 = arg35;
        Composer v1 = arg33.startRestartGroup(-294153140);
        ComposerKt.sourceInformation(v1, "C(ContextualFlowRow)N(itemCount,modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)80@3819L53,82@3926L209,97@4434L336,88@4168L602,107@4775L68:ContextualFlowLayout.kt#2w3rfo");
        if((v10 & 6) == 0) {
            v3 = v1.changed(arg24) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_34;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg25;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_34:
            v5 = arg25;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_49;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg26;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_49:
            v7 = arg26;
        }

        v8 = v11 & 8;
        if(v8 != 0) {
            v3 |= 0xC00;
        }
        else if((v10 & 0xC00) == 0) {
            v13 = v1.changed(arg27) ? 0x800 : 0x400;
            v3 |= v13;
        }

        v13 = v11 & 16;
        if(v13 != 0) {
            v3 |= 0x6000;
            goto label_79;
        }
        else if((v10 & 0x6000) == 0) {
            v14 = arg28;
            v15 = v1.changed(v14) ? 0x4000 : 0x2000;
            v3 |= v15;
        }
        else {
        label_79:
            v14 = arg28;
        }

        v15 = v11 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            v0 = arg29;
            if((v10 & v16) == 0) {
                v17 = v1.changed(v0) ? 0x20000 : 0x10000;
                v3 |= v17;
            }
        }

        v17 = v11 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v3 |= v18;
        }
        else {
            v0 = arg30;
            if((v10 & v18) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v3 |= v18;
            }
        }

        v18 = 0xC00000;
        int v19 = v11 & 0x80;
        if(v19 != 0) {
            v3 |= v18;
        }
        else {
            ContextualFlowRowOverflow v0_1 = arg31;
            if((v10 & v18) == 0) {
                v18 = v1.changed(v0_1) ? 0x800000 : 0x400000;
                v3 |= v18;
            }
        }

        v18 = 0x6000000;
        if((v10 & v18) == 0) {
            v20 = v1.changedInstance(v9) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }

        v20 = v4;
        boolean v0_2 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v3 & 1)) {
            if(v20 != 0) {
                Companion v5_1 = Modifier.Companion;
            }

            Horizontal v12 = v6 != 0 ? Arrangement.INSTANCE.getStart() : v7;
            if(v8 != 0) {
                int v23 = v13;
                v13_1 = Arrangement.INSTANCE.getTop();
                v0 = v23;
            }
            else {
                v0 = v13;
                v13_1 = arg27;
            }

            if(v0 != 0) {
                v14 = Alignment.Companion.getTop();
            }

            v0 = 0x7FFFFFFF;
            v15 = v15 != 0 ? v0 : arg29;
            v16 = v17 != 0 ? v0 : arg30;
            v0 = -294153140;
            ContextualFlowRowOverflow v2 = v19 != 0 ? ContextualFlowRowOverflow.Companion.getClip() : arg31;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.foundation.layout.ContextualFlowRow (ContextualFlowLayout.kt:79)");
            }

            String v6_1 = "CC(remember):ContextualFlowLayout.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v1, 0x2EE3F381, v6_1);
            v0 = 0x1C00000 & v3;
            v7_1 = v0 == 0x800000 ? 1 : 0;
            Object v8_1 = v1.rememberedValue();
            if(v7_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                FlowLayoutOverflowState v8_2 = v2.createOverflowState$foundation_layout();
                v1.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            ComposerKt.sourceInformationMarkerStart(v1, 0x2EE4017D, v6_1);
            v0 = v0 == 0x800000 ? 1 : 0;
            Object v6_2 = v1.rememberedValue();
            if(v0 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                ArrayList v6_3 = new ArrayList();
                v2.addOverflowComposables$foundation_layout(((FlowLayoutOverflowState)v8_1), ((List)v6_3));
                v1.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v1);
            v0 = v3 >> 6;
            SubcomposeLayoutKt.SubcomposeLayout(v5, ContextualFlowLayoutKt.contextualRowMeasurementHelper(v12, v13_1, v14, v15, v16, v8_1, arg24, v6_2, ComposableLambdaKt.rememberComposableLambda(0x9BFE1BAE, true, new ContextualFlowLayoutKt$$ExternalSyntheticLambda0(v9), v1, 54), v1, v0 & 0xE000 | (v0 & 14 | v18 | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00) | v3 << 18 & 0x380000), v1, v3 >> 3 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_3 = v2;
            v3_1 = v12;
            v4_1 = v13_1;
            v6 = v15;
            v7_1 = v16;
        }
        else {
            v1.skipToGroupEnd();
            v4_1 = arg27;
            v6 = arg29;
            v8_3 = arg31;
            v3_1 = v7;
            v7_1 = arg30;
        }

        Modifier v2_1 = v5;
        androidx.compose.ui.Alignment$Vertical v5_2 = v14;
        ScopeUpdateScope v12_1 = v1.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new ContextualFlowLayoutKt$$ExternalSyntheticLambda1(arg24, v2_1, v3_1, v4_1, v5_2, v6, v7_1, v8_3, v9, v10, v11));
        }
    }

    static final Unit ContextualFlowRow$lambda$2(Function4 arg9, int arg10, FlowLineInfo arg11, Composer arg12, int arg13) {
        ComposerKt.sourceInformation(arg12, "CN(index,info)105@4746L14:ContextualFlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x9BFE1BAE, arg13, -1, "androidx.compose.foundation.layout.ContextualFlowRow.<anonymous> (ContextualFlowLayout.kt:98)");
        }

        arg9.invoke(new ContextualFlowRowScopeImpl(arg11.getLineIndex$foundation_layout(), arg11.getPositionInLine$foundation_layout(), arg11.getMaxMainAxisSize-D9Ej5fM$foundation_layout(), arg11.getMaxCrossAxisSize-D9Ej5fM$foundation_layout(), null), Integer.valueOf(arg10), arg12, Integer.valueOf(arg13 << 3 & 0x70));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        return Unit.INSTANCE;
    }

    static final Unit ContextualFlowRow$lambda$3(int arg13, Modifier arg14, Horizontal arg15, Vertical arg16, androidx.compose.ui.Alignment$Vertical arg17, int arg18, int arg19, ContextualFlowRowOverflow arg20, Function4 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ContextualFlowLayoutKt.ContextualFlowRow(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final Function2 contextualColumnMeasureHelper(Vertical arg21, Horizontal arg22, androidx.compose.ui.Alignment$Horizontal arg23, int arg24, int arg25, FlowLayoutOverflowState arg26, int arg27, List arg28, Function4 arg29, Composer arg30, int arg31) {
        androidx.compose.ui.Alignment$Horizontal v0 = arg23;
        Composer v1 = arg30;
        int v2 = arg31;
        int v4 = 0xD7AB63D9;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(contextualColumnMeasureHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)425@18138L978:ContextualFlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.foundation.layout.contextualColumnMeasureHelper (ContextualFlowLayout.kt:424)");
        }

        ComposerKt.sourceInformationMarkerStart(v1, -1704848565, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        v4 = 4;
        int v5 = 0;
        Vertical v10 = arg21;
        int v3 = (v2 & 14 ^ 6) > v4 && (v1.changed(v10)) || (v2 & 6) == v4 ? 1 : 0;
        int v7 = 0x20;
        Horizontal v9 = arg22;
        v4 = (v2 & 0x70 ^ 0x30) > v7 && (v1.changed(v9)) || (v2 & 0x30) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x100;
        v4 = (v2 & 0x380 ^ 0x180) > v7 && (v1.changed(v0)) || (v2 & 0x180) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x800;
        if((v2 & 0x1C00 ^ 0xC00) > v7) {
            v4 = arg24;
            if(!v1.changed(v4)) {
                goto label_62;
            }
            else {
                goto label_64;
            }
        }
        else {
            v4 = arg24;
        label_62:
            if((v2 & 0xC00) == v7) {
            label_64:
                v7 = 1;
            }
            else {
                v7 = 0;
            }
        }

        v3 |= v7;
        int v8 = 0x4000;
        int v15 = arg25;
        v7 = (0xE000 & v2 ^ 0x6000) > v8 && (v1.changed(v15)) || (v2 & 0x6000) == v8 ? 1 : 0;
        v3 = v3 | v7 | v1.changed(arg26);
        int v11 = 0x180000;
        int v12 = 0x100000;
        int v14 = arg27;
        v8 = (0x380000 & v2 ^ v11) > v12 && (v1.changed(v14)) || (v2 & v11) == v12 ? 1 : 0;
        v3 |= v8;
        v11 = 0x6000000;
        v12 = 0x4000000;
        if((0xE000000 & v2 ^ v11) > v12 && (v1.changed(arg29)) || (v2 & v11) == v12) {
            v5 = 1;
        }

        v2 = v3 | v5;
        Object v3_1 = v1.rememberedValue();
        if(v2 != 0 || v3_1 == Composer.Companion.getEmpty()) {
            Function2 v3_2 = new FlowMeasureLazyPolicy(false, v9, v10, v10.getSpacing-D9Ej5fM(), CrossAxisAlignment.Companion.horizontal$foundation_layout(v0), v9.getSpacing-D9Ej5fM(), v14, v15, v4, arg26, arg28, arg29, null).getMeasurePolicy();
            v1.updateRememberedValue(v3_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return ((Function2)v3_1);
    }

    public static final Function2 contextualRowMeasurementHelper(Horizontal arg21, Vertical arg22, androidx.compose.ui.Alignment$Vertical arg23, int arg24, int arg25, FlowLayoutOverflowState arg26, int arg27, List arg28, Function4 arg29, Composer arg30, int arg31) {
        androidx.compose.ui.Alignment$Vertical v0 = arg23;
        Composer v1 = arg30;
        int v2 = arg31;
        int v4 = 962906403;
        ComposerKt.sourceInformationMarkerStart(v1, v4, "C(contextualRowMeasurementHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState,itemCount,overflowComposables,getComposable)385@16647L971:ContextualFlowLayout.kt#2w3rfo");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v2, -1, "androidx.compose.foundation.layout.contextualRowMeasurementHelper (ContextualFlowLayout.kt:384)");
        }

        ComposerKt.sourceInformationMarkerStart(v1, 1935101358, "CC(remember):ContextualFlowLayout.kt#9igjgp");
        v4 = 4;
        int v5 = 0;
        Horizontal v9 = arg21;
        int v3 = (v2 & 14 ^ 6) > v4 && (v1.changed(v9)) || (v2 & 6) == v4 ? 1 : 0;
        int v7 = 0x20;
        Vertical v10 = arg22;
        v4 = (v2 & 0x70 ^ 0x30) > v7 && (v1.changed(v10)) || (v2 & 0x30) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x100;
        v4 = (v2 & 0x380 ^ 0x180) > v7 && (v1.changed(v0)) || (v2 & 0x180) == v7 ? 1 : 0;
        v3 |= v4;
        v7 = 0x800;
        if((v2 & 0x1C00 ^ 0xC00) > v7) {
            v4 = arg24;
            if(!v1.changed(v4)) {
                goto label_62;
            }
            else {
                goto label_64;
            }
        }
        else {
            v4 = arg24;
        label_62:
            if((v2 & 0xC00) == v7) {
            label_64:
                v7 = 1;
            }
            else {
                v7 = 0;
            }
        }

        v3 |= v7;
        int v8 = 0x4000;
        int v15 = arg25;
        v7 = (0xE000 & v2 ^ 0x6000) > v8 && (v1.changed(v15)) || (v2 & 0x6000) == v8 ? 1 : 0;
        v3 = v3 | v7 | v1.changed(arg26);
        int v11 = 0x180000;
        int v12 = 0x100000;
        int v14 = arg27;
        v8 = (0x380000 & v2 ^ v11) > v12 && (v1.changed(v14)) || (v2 & v11) == v12 ? 1 : 0;
        v3 |= v8;
        v11 = 0x6000000;
        v12 = 0x4000000;
        if((0xE000000 & v2 ^ v11) > v12 && (v1.changed(arg29)) || (v2 & v11) == v12) {
            v5 = 1;
        }

        v2 = v3 | v5;
        Object v3_1 = v1.rememberedValue();
        if(v2 != 0 || v3_1 == Composer.Companion.getEmpty()) {
            Function2 v3_2 = new FlowMeasureLazyPolicy(true, v9, v10, v9.getSpacing-D9Ej5fM(), CrossAxisAlignment.Companion.vertical$foundation_layout(v0), v10.getSpacing-D9Ej5fM(), v14, v15, v4, arg26, arg28, arg29, null).getMeasurePolicy();
            v1.updateRememberedValue(v3_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return ((Function2)v3_1);
    }
}

