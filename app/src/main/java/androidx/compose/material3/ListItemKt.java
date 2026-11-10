package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A¦\u0001\u0010\u0000\u001A\u00020\u00012\u0011\u0010\u0002\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0015\b\u0002\u0010\u0007\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\b\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\t\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u000EH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001At\u0010\u0012\u001A\u00020\u00012\u0013\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0015\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0002\u0010\u0018\u001AK\u0010\u0019\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020\u001A2\u0006\u0010!\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020#H\u0002¢\u0006\u0004\b$\u0010%\u001AS\u0010&\u001A\u00020\u001A*\u00020\u001B2\u0006\u0010\'\u001A\u00020\u001A2\u0006\u0010(\u001A\u00020\u001A2\u0006\u0010)\u001A\u00020\u001A2\u0006\u0010*\u001A\u00020\u001A2\u0006\u0010+\u001A\u00020\u001A2\u0006\u0010,\u001A\u00020-2\u0006\u0010.\u001A\u00020\u001A2\u0006\u0010\"\u001A\u00020#H\u0002¢\u0006\u0004\b/\u00100\u001An\u00101\u001A\u000202*\u0002032\u0006\u00104\u001A\u00020\u001A2\u0006\u00105\u001A\u00020\u001A2\b\u00106\u001A\u0004\u0018\u0001072\b\u00108\u001A\u0004\u0018\u0001072\b\u00109\u001A\u0004\u0018\u0001072\b\u0010:\u001A\u0004\u0018\u0001072\b\u0010;\u001A\u0004\u0018\u0001072\u0006\u0010<\u001A\u00020=2\u0006\u0010>\u001A\u00020\u001A2\u0006\u0010?\u001A\u00020\u001A2\u0006\u0010@\u001A\u00020\u001AH\u0002\u001A2\u0010A\u001A\u00020\u00012\u0006\u0010B\u001A\u00020C2\u0006\u0010D\u001A\u00020E2\u0011\u0010F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0003¢\u0006\u0004\bG\u0010H\u001A\u0014\u0010^\u001A\u00020=*\u00020_2\u0006\u0010`\u001A\u00020\u001AH\u0002\u001A\u0017\u0010.\u001A\u00020\u000E2\u0006\u0010,\u001A\u00020-H\u0002¢\u0006\u0004\ba\u0010b\"\u001E\u0010I\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u001E\u0010O\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bP\u0010K\u001A\u0004\bQ\u0010M\"\u001E\u0010R\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bS\u0010K\u001A\u0004\bT\u0010M\"\u001E\u0010U\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bV\u0010K\u001A\u0004\bW\u0010M\"\u001E\u0010X\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\bY\u0010K\u001A\u0004\bZ\u0010M\"\u001E\u0010[\u001A\u00020\u000E8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010N\u0012\u0004\b\\\u0010K\u001A\u0004\b]\u0010M¨\u0006c"}, d2={"ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "calculateHeight", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "listItemType", "Landroidx/compose/material3/ListItemType;", "verticalPadding", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "isThreeLine", "", "startPadding", "endPadding", "topPadding", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "()V", "getListItemVerticalPadding", "()F", "F", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "LeadingContentEndPadding", "getLeadingContentEndPadding$annotations", "getLeadingContentEndPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "isSupportingMultilineHeuristic", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "verticalPadding-yh95HIg", "(I)F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float ListItemThreeLineVerticalPadding;
    private static final float ListItemVerticalPadding;
    private static final float TrailingContentStartPadding;

    static {
        ListItemKt.ListItemVerticalPadding = Dp.constructor-impl(8f);
        ListItemKt.ListItemThreeLineVerticalPadding = Dp.constructor-impl(12f);
        ListItemKt.ListItemStartPadding = Dp.constructor-impl(16f);
        ListItemKt.ListItemEndPadding = Dp.constructor-impl(16f);
        ListItemKt.LeadingContentEndPadding = Dp.constructor-impl(16f);
        ListItemKt.TrailingContentStartPadding = Dp.constructor-impl(16f);
    }

    public static final void ListItem-HXNGIdc(Function2 arg25, Modifier arg26, Function2 arg27, Function2 arg28, Function2 arg29, Function2 arg30, ListItemColors arg31, float arg32, float arg33, Composer arg34, int arg35, int arg36) {
        Function2 v5_2;
        float v9_1;
        Function2 v4_1;
        ListItemColors v7_1;
        Function2 v3_2;
        Modifier v2_1;
        Composer v22_2;
        ListItemKt$$ExternalSyntheticLambda2 v14_2;
        ComposableLambda v27;
        ComposableLambda v0_4;
        Function2 v32;
        ComposableLambda v1_1;
        ComposableLambda v3_1;
        float v19_1;
        float v18_1;
        ListItemColors v8_1;
        Function2 v6_1;
        Function2 v0_3;
        float v8_2;
        Companion v5_1;
        int v20;
        int v19;
        int v18;
        int v17;
        ListItemColors v0;
        Function2 v15_1;
        int v14;
        Function2 v13;
        int v12;
        Function2 v9;
        int v8;
        Function2 v7;
        int v6;
        Modifier v5;
        int v3;
        Function2 v1 = arg25;
        int v10 = arg35;
        int v11 = arg36;
        Composer v2 = arg34.startRestartGroup(0x1D090FC6);
        ComposerKt.sourceInformation(v2, "C(ListItem)N(headlineContent,modifier,overlineContent,supportingContent,leadingContent,trailingContent,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp)105@4827L177,157@6607L2,158@6659L5,163@6858L288,156@6535L611:ListItem.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v2.changedInstance(v1) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_36;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg26;
            v6 = v2.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_36:
            v5 = arg26;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_51;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg27;
            v8 = v2.changedInstance(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_51:
            v7 = arg27;
        }

        v8 = v11 & 8;
        if(v8 != 0) {
            v3 |= 0xC00;
            goto label_66;
        }
        else if((v10 & 0xC00) == 0) {
            v9 = arg28;
            v12 = v2.changedInstance(v9) ? 0x800 : 0x400;
            v3 |= v12;
        }
        else {
        label_66:
            v9 = arg28;
        }

        v12 = v11 & 16;
        if(v12 != 0) {
            v3 |= 0x6000;
            goto label_81;
        }
        else if((v10 & 0x6000) == 0) {
            v13 = arg29;
            v14 = v2.changedInstance(v13) ? 0x4000 : 0x2000;
            v3 |= v14;
        }
        else {
        label_81:
            v13 = arg29;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v3 |= v15;
            goto label_97;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg30;
            int v16 = v2.changedInstance(v15_1) ? 0x20000 : 0x10000;
            v3 |= v16;
        }
        else {
        label_97:
            v15_1 = arg30;
        }

        if((v10 & 0x180000) == 0) {
            v0 = arg31;
            v17 = (v11 & 0x40) != 0 || !v2.changed(v0) ? 0x80000 : 0x100000;
            v3 |= v17;
        }

        int v0_1 = v11 & 0x80;
        v17 = 0xC00000;
        if(v0_1 != 0) {
            v3 |= v17;
            goto label_128;
        }
        else if((v10 & v17) == 0) {
            v18 = v0_1;
            v19 = v2.changed(arg32) ? 0x800000 : 0x400000;
            v3 |= v19;
        }
        else {
        label_128:
            v18 = v0_1;
        }

        v0_1 = v11 & 0x100;
        v19 = 0x6000000;
        if(v0_1 != 0) {
            v3 |= v19;
            goto label_146;
        }
        else if((v10 & v19) == 0) {
            v19 = v0_1;
            v20 = v2.changed(arg33) ? 0x4000000 : 0x2000000;
            v3 |= v20;
        }
        else {
        label_146:
            v19 = v0_1;
        }

        int v34 = v3;
        v20 = v4;
        boolean v0_2 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v2.shouldExecute(v0_2, v34 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "101@4647L8");
            int v21 = 0xFFC7FFFF;
            v3 = 6;
            Function2 v22 = null;
            if((v10 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v20 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = v22;
                }

                if(v8 != 0) {
                    v9 = v22;
                }

                if(v12 != 0) {
                    v13 = v22;
                }

                if(v14 != 0) {
                    v15_1 = v22;
                }

                if((v11 & 0x40) != 0) {
                    v0 = ListItemDefaults.INSTANCE.colors(v2, v3);
                    v6 = v34 & v21;
                }
                else {
                    v0 = arg31;
                    v6 = v34;
                }

                v8_2 = v18 != 0 ? ListItemDefaults.INSTANCE.getElevation-D9Ej5fM() : arg32;
                if(v19 != 0) {
                    v18_1 = v8_2;
                    v19_1 = ListItemDefaults.INSTANCE.getElevation-D9Ej5fM();
                    v8_1 = v0;
                    v12 = v6;
                label_185:
                    v0_3 = v13;
                    v6_1 = v15_1;
                    goto label_226;
                }

                v19_1 = arg33;
                v12 = v6;
                v18_1 = v8_2;
                v6_1 = v15_1;
                v8_1 = v0;
                v0_3 = v13;
            }
            else {
                v2.skipToGroupEnd();
                if((v11 & 0x40) != 0) {
                    v8_1 = arg31;
                    v18_1 = arg32;
                    v19_1 = arg33;
                    v12 = v34 & v21;
                }
                else {
                    v8_1 = arg31;
                    v18_1 = arg32;
                    v19_1 = arg33;
                    v12 = v34;
                }

                goto label_185;
            }

        label_226:
            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x1D090FC6, v12, -1, "androidx.compose.material3.ListItem (ListItem.kt:104)");
            }

            v15 = 54;
            ComposableLambda v13_1 = ComposableLambdaKt.rememberComposableLambda(629852750, true, new ListItemKt$ListItem$decoratedHeadlineContent$1(v8_1, v1), v2, v15);
            if(v9 == null) {
                v2.startReplaceGroup(0xE18F1FF2);
                v2.endReplaceGroup();
                v3_1 = ((ComposableLambda)v22);
            }
            else {
                v2.startReplaceGroup(0xE18F1FF3);
                ComposerKt.sourceInformation(v2, "*114@5114L205");
                v3_1 = ComposableLambdaKt.rememberComposableLambda(0xB309AC84, true, new ListItemKt$ListItem$decoratedSupportingContent$1$1(v8_1, v9), v2, v15);
                v2.endReplaceGroup();
            }

            if(v7 == null) {
                v2.startReplaceGroup(0xE193FADA);
                v2.endReplaceGroup();
                v1_1 = ((ComposableLambda)v22);
            }
            else {
                v2.startReplaceGroup(0xE193FADB);
                ComposerKt.sourceInformation(v2, "*124@5435L197");
                v1_1 = ComposableLambdaKt.rememberComposableLambda(0x16329A0F, true, new ListItemKt$ListItem$decoratedOverlineContent$1$1(v8_1, v7), v2, v15);
                v2.endReplaceGroup();
            }

            if(v0_3 == null) {
                v2.startReplaceGroup(-510083888);
                v2.endReplaceGroup();
                v32 = v0_3;
                v0_4 = ((ComposableLambda)v22);
            }
            else {
                v2.startReplaceGroup(-510083887);
                ComposerKt.sourceInformation(v2, "*134@5746L303");
                v32 = v0_3;
                v0_4 = ComposableLambdaKt.rememberComposableLambda(0x1ACB90A3, true, new ListItemKt$ListItem$decoratedLeadingContent$1$1(v8_1, v0_3), v2, v15);
                v2.endReplaceGroup();
            }

            if(v6_1 == null) {
                v2.startReplaceGroup(0xE19F1A9D);
                v2.endReplaceGroup();
                v27 = v0_4;
            }
            else {
                v2.startReplaceGroup(0xE19F1A9E);
                ComposerKt.sourceInformation(v2, "*145@6165L354");
                v27 = v0_4;
                ComposableLambda v22_1 = ComposableLambdaKt.rememberComposableLambda(0x7403E03B, true, new ListItemKt$ListItem$decoratedTrailingContent$1$1(v8_1, v6_1), v2, v15);
                v2.endReplaceGroup();
            }

            Companion v0_5 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(v2, 0xFF0559E8, "CC(remember):ListItem.kt#9igjgp");
            Object v14_1 = v2.rememberedValue();
            if(v14_1 == Composer.Companion.getEmpty()) {
                v14_2 = new ListItemKt$$ExternalSyntheticLambda2();
                v2.updateRememberedValue(v14_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            Modifier v0_6 = SemanticsModifierKt.semantics(((Modifier)v0_5), true, ((Function1)v14_2)).then(((Modifier)v5_1));
            ComposableLambda v16_1 = v13_1;
            Shape v13_2 = ListItemDefaults.INSTANCE.getShape(v2, 6);
            long v14_3 = v8_1.containerColor-0d7_KjU$material3();
            ComposableLambda v20_1 = v16_1;
            v21 = v17;
            long v16_2 = v8_1.headlineColor-vNxB06k$material3(true);
            arg26 = v0_6;
            v0_4 = ComposableLambdaKt.rememberComposableLambda(0x4713EF21, true, new ListItemKt$ListItem$2(((Function2)v27), ((ComposableLambda)v22), v20_1, v1_1, v3_1), v2, 54);
            int v1_2 = v12 >> 9;
            v22_2 = v2;
            SurfaceKt.Surface-T9BRK9s(arg26, v13_2, v14_3, v16_2, v18_1, v19_1, null, v0_4, v22_2, 0xE000 & v1_2 | v21 | v1_2 & 0x70000, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = ((Modifier)v5_1);
            v3_2 = v7;
            v7_1 = v8_1;
            v4_1 = v9;
            v8_2 = v18_1;
            v9_1 = v19_1;
            v5_2 = v32;
        }
        else {
            v22_2 = v2;
            v22_2.skipToGroupEnd();
            v8_2 = arg32;
            v2_1 = v5;
            v3_2 = v7;
            v4_1 = v9;
            v5_2 = v13;
            v6_1 = v15_1;
            v7_1 = arg31;
            v9_1 = arg33;
        }

        ScopeUpdateScope v12_1 = v22_2.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new ListItemKt$$ExternalSyntheticLambda3(arg25, v2_1, v3_2, v4_1, v5_2, v6_1, v7_1, v8_2, v9_1, v10, v11));
        }
    }

    private static final void ListItemLayout(Function2 arg9, Function2 arg10, Function2 arg11, Function2 arg12, Function2 arg13, Composer arg14, int arg15) {
        MeasurePolicy v3_3;
        int v4;
        int v1;
        int v0 = 0xFC58FAAE;
        arg14 = arg14.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg14, "C(ListItemLayout)N(leading,trailing,headline,overline,supporting)182@7421L36,183@7462L166:ListItem.kt#uh7d8r");
        int v2 = 4;
        int v3 = 2;
        if((arg15 & 6) == 0) {
            v1 = arg14.changedInstance(arg9) ? v2 : v3;
            v1 |= arg15;
        }
        else {
            v1 = arg15;
        }

        if((arg15 & 0x30) == 0) {
            v4 = arg14.changedInstance(arg10) ? 0x20 : 16;
            v1 |= v4;
        }

        if((arg15 & 0x180) == 0) {
            v4 = arg14.changedInstance(arg11) ? 0x100 : 0x80;
            v1 |= v4;
        }

        if((arg15 & 0xC00) == 0) {
            v4 = arg14.changedInstance(arg12) ? 0x800 : 0x400;
            v1 |= v4;
        }

        if((arg15 & 0x6000) == 0) {
            v4 = arg14.changedInstance(arg13) ? 0x4000 : 0x2000;
            v1 |= v4;
        }

        boolean v4_1 = (v1 & 9363) != 9362 ? true : false;
        if(arg14.shouldExecute(v4_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:181)");
            }

            ComposerKt.sourceInformationMarkerStart(arg14, 0x4A052932, "CC(remember):ListItem.kt#9igjgp");
            Object v0_1 = arg14.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                ListItemMeasurePolicy v0_2 = new ListItemMeasurePolicy();
                arg14.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
            Function2[] v1_1 = new Function2[5];
            v1_1[0] = arg11;
            Function2 v4_2 = arg12 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$-489887388$material3() : arg12;
            v1_1[1] = v4_2;
            v4_2 = arg13 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$1629163587$material3() : arg13;
            v1_1[v3] = v4_2;
            Function2 v3_1 = arg9 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$-546752734$material3() : arg9;
            v1_1[3] = v3_1;
            v3_1 = arg10 == null ? ComposableSingletons$ListItemKt.INSTANCE.getLambda$1572298241$material3() : arg10;
            v1_1[v2] = v3_1;
            List v1_2 = CollectionsKt.listOf(((Object[])v1_1));
            ComposerKt.sourceInformationMarkerStart(arg14, 0x5365E06C, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
            Companion v2_1 = Modifier.Companion;
            Function2 v1_3 = LayoutKt.combineAsVirtualLayouts(v1_2);
            ComposerKt.sourceInformationMarkerStart(arg14, -290764973, "CC(remember):Layout.kt#9igjgp");
            Object v3_2 = arg14.rememberedValue();
            if(v3_2 == Composer.Companion.getEmpty()) {
                v3_3 = MultiContentMeasurePolicyKt.createMeasurePolicy(((MultiContentMeasurePolicy)v0_1));
                arg14.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(arg14);
            ComposerKt.sourceInformationMarkerStart(arg14, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            v0 = ComposablesKt.getCurrentCompositeKeyHash(arg14, 0);
            CompositionLocalMap v4_3 = arg14.getCurrentCompositionLocalMap();
            Modifier v2_2 = ComposedModifierKt.materializeModifier(arg14, ((Modifier)v2_1));
            Function0 v5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(arg14, 0xD6BD0031, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if(!(arg14.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            arg14.startReusableNode();
            if(arg14.getInserting()) {
                arg14.createNode(v5);
            }
            else {
                arg14.useNode();
            }

            Composer v5_1 = Updater.constructor-impl(arg14);
            Updater.set-impl(v5_1, v3_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v5_1, v4_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v3_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v0))) {
                v5_1.updateRememberedValue(Integer.valueOf(v0));
                v5_1.apply(Integer.valueOf(v0), v3_1);
            }

            Updater.set-impl(v5_1, v2_2, ComposeUiNode.Companion.getSetModifier());
            v1_3.invoke(arg14, Integer.valueOf(0));
            arg14.endNode();
            ComposerKt.sourceInformationMarkerEnd(arg14);
            ComposerKt.sourceInformationMarkerEnd(arg14);
            ComposerKt.sourceInformationMarkerEnd(arg14);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_173;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg14.skipToGroupEnd();
        }

    label_173:
        ScopeUpdateScope v14 = arg14.endRestartGroup();
        if(v14 != null) {
            v14.updateScope(new ListItemKt$$ExternalSyntheticLambda1(arg9, arg10, arg11, arg12, arg13, arg15));
        }
    }

    static final Unit ListItemLayout$lambda$8(Function2 arg7, Function2 arg8, Function2 arg9, Function2 arg10, Function2 arg11, int arg12, Composer arg13, int arg14) {
        ListItemKt.ListItemLayout(arg7, arg8, arg9, arg10, arg11, arg13, RecomposeScopeImplKt.updateChangedFlags(arg12 | 1));
        return Unit.INSTANCE;
    }

    static final Unit ListItem_HXNGIdc$lambda$5$lambda$4(SemanticsPropertyReceiver arg0) {
        return Unit.INSTANCE;
    }

    static final Unit ListItem_HXNGIdc$lambda$6(Function2 arg13, Modifier arg14, Function2 arg15, Function2 arg16, Function2 arg17, Function2 arg18, ListItemColors arg19, float arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        ListItemKt.ListItem-HXNGIdc(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    private static final void ProvideTextStyleFromToken-3J-VO9M(long arg7, TypographyKeyTokens arg9, Function2 arg10, Composer arg11, int arg12) {
        Function2 v11_1;
        long v1_2;
        int v1;
        int v11;
        int v0 = 0xEEFD2FE0;
        Composer v5 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(ProvideTextStyleFromToken)N(color:c#ui.graphics.Color,textToken,content)705@29794L5,703@29704L129:ListItem.kt#uh7d8r");
        if((arg12 & 6) == 0) {
            v11 = v5.changed(arg7) ? 4 : 2;
            v11 |= arg12;
        }
        else {
            v11 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v1 = v5.changed(arg9.ordinal()) ? 0x20 : 16;
            v11 |= v1;
        }

        if((arg12 & 0x180) == 0) {
            v1 = v5.changedInstance(arg10) ? 0x100 : 0x80;
            v11 |= v1;
        }

        boolean v1_1 = (v11 & 0x93) != 0x92 ? true : false;
        if(v5.shouldExecute(v1_1, v11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v11, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:703)");
            }

            v1_2 = arg7;
            ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(v1_2, TypographyKt.getValue(arg9, v5, v11 >> 3 & 14), arg10, v5, v11 & 910);
            v11_1 = arg10;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_61;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1_2 = arg7;
            v11_1 = arg10;
            v5.skipToGroupEnd();
        }

    label_61:
        ScopeUpdateScope v0_1 = v5.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ListItemKt$$ExternalSyntheticLambda4(v1_2, arg9, v11_1, arg12));
        }
    }

    static final Unit ProvideTextStyleFromToken_3J_VO9M$lambda$12(long arg6, TypographyKeyTokens arg8, Function2 arg9, int arg10, Composer arg11, int arg12) {
        ListItemKt.ProvideTextStyleFromToken-3J-VO9M(arg6, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    public static final void access$ListItemLayout(Function2 arg0, Function2 arg1, Function2 arg2, Function2 arg3, Function2 arg4, Composer arg5, int arg6) {
        ListItemKt.ListItemLayout(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    public static final void access$ProvideTextStyleFromToken-3J-VO9M(long arg0, TypographyKeyTokens arg2, Function2 arg3, Composer arg4, int arg5) {
        ListItemKt.ProvideTextStyleFromToken-3J-VO9M(arg0, arg2, arg3, arg4, arg5);
    }

    public static final int access$calculateHeight-N4Jib3Y(IntrinsicMeasureScope arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, long arg8) {
        return ListItemKt.calculateHeight-N4Jib3Y(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public static final int access$calculateWidth-yeHjK3Y(IntrinsicMeasureScope arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) {
        return ListItemKt.calculateWidth-yeHjK3Y(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final boolean access$isSupportingMultilineHeuristic(Density arg0, int arg1) {
        return ListItemKt.isSupportingMultilineHeuristic(arg0, arg1);
    }

    public static final MeasureResult access$place(MeasureScope arg0, int arg1, int arg2, Placeable arg3, Placeable arg4, Placeable arg5, Placeable arg6, Placeable arg7, boolean arg8, int arg9, int arg10, int arg11) {
        return ListItemKt.place(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final float access$verticalPadding-yh95HIg(int arg0) {
        return ListItemKt.verticalPadding-yh95HIg(arg0);
    }

    private static final int calculateHeight-N4Jib3Y(IntrinsicMeasureScope arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, long arg9) {
        float v7;
        if(ListItemType.equals-impl0(arg7, ListItemType.Companion.getOneLine-AlXitO8())) {
            v7 = ListTokens.INSTANCE.getListItemOneLineContainerHeight-D9Ej5fM();
        }
        else if(ListItemType.equals-impl0(arg7, ListItemType.Companion.getTwoLine-AlXitO8())) {
            v7 = ListTokens.INSTANCE.getListItemTwoLineContainerHeight-D9Ej5fM();
        }
        else {
            v7 = ListTokens.INSTANCE.getListItemThreeLineContainerHeight-D9Ej5fM();
        }

        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.getMinHeight-impl(arg9), arg1.roundToPx-0680j_4(v7)), arg8 + Math.max(arg2, Math.max(arg4 + arg5 + arg6, arg3))), Constraints.getMaxHeight-impl(arg9));
    }

    private static final int calculateWidth-yeHjK3Y(IntrinsicMeasureScope arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, long arg7) {
        if(Constraints.getHasBoundedWidth-impl(arg7)) {
            return Constraints.getMaxWidth-impl(arg7);
        }

        return arg6 + arg1 + Math.max(arg3, Math.max(arg4, arg5)) + arg2;
    }

    public static final float getLeadingContentEndPadding() {
        return ListItemKt.LeadingContentEndPadding;
    }

    public static void getLeadingContentEndPadding$annotations() {
    }

    public static final float getListItemEndPadding() {
        return ListItemKt.ListItemEndPadding;
    }

    public static void getListItemEndPadding$annotations() {
    }

    public static final float getListItemStartPadding() {
        return ListItemKt.ListItemStartPadding;
    }

    public static void getListItemStartPadding$annotations() {
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemKt.ListItemThreeLineVerticalPadding;
    }

    public static void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static final float getListItemVerticalPadding() {
        return ListItemKt.ListItemVerticalPadding;
    }

    public static void getListItemVerticalPadding$annotations() {
    }

    public static final float getTrailingContentStartPadding() {
        return ListItemKt.TrailingContentStartPadding;
    }

    public static void getTrailingContentStartPadding$annotations() {
    }

    private static final boolean isSupportingMultilineHeuristic(Density arg2, int arg3) {
        if(arg3 > arg2.roundToPx--R2X_6o(TextUnitKt.getSp(30))) {
            return 1;
        }

        return 0;
    }

    private static final MeasureResult place(MeasureScope arg12, int arg13, int arg14, Placeable arg15, Placeable arg16, Placeable arg17, Placeable arg18, Placeable arg19, boolean arg20, int arg21, int arg22, int arg23) {
        return MeasureScope.layout$default(arg12, arg13, arg14, null, new ListItemKt$$ExternalSyntheticLambda0(arg15, arg21, arg20, arg23, arg17, arg18, arg19, arg14, arg16, arg13, arg22), 4, null);
    }

    static final Unit place$lambda$11(Placeable arg9, int arg10, boolean arg11, int arg12, Placeable arg13, Placeable arg14, Placeable arg15, int arg16, Placeable arg17, int arg18, int arg19, PlacementScope arg20) {
        int v0 = arg16;
        if(arg9 != null) {
            int v5 = arg11 ? arg12 : Alignment.Companion.getCenterVertically().align(arg9.getHeight(), v0);
            PlacementScope.placeRelative$default(arg20, arg9, arg10, v5, 0f, 4, null);
        }

        int v3 = arg10 + LayoutUtilKt.getWidthOrZero(arg9);
        int v4 = arg11 ? arg12 : Alignment.Companion.getCenterVertically().align(LayoutUtilKt.getHeightOrZero(arg13) + LayoutUtilKt.getHeightOrZero(arg14) + LayoutUtilKt.getHeightOrZero(arg15), v0);
        if(arg14 != null) {
            PlacementScope.placeRelative$default(arg20, arg14, v3, v4, 0f, 4, null);
        }

        v4 += LayoutUtilKt.getHeightOrZero(arg14);
        if(arg13 != null) {
            PlacementScope.placeRelative$default(arg20, arg13, v3, v4, 0f, 4, null);
        }

        v4 += LayoutUtilKt.getHeightOrZero(arg13);
        if(arg15 != null) {
            PlacementScope.placeRelative$default(arg20, arg15, v3, v4, 0f, 4, null);
        }

        if(arg17 != null) {
            int v9 = arg18 - arg19 - arg17.getWidth();
            if(arg11) {
            }
            else {
                arg12 = Alignment.Companion.getCenterVertically().align(arg17.getHeight(), v0);
            }

            PlacementScope.placeRelative$default(arg20, arg17, v9, arg12, 0f, 4, null);
        }

        return Unit.INSTANCE;
    }

    private static final float verticalPadding-yh95HIg(int arg1) {
        if(ListItemType.equals-impl0(arg1, ListItemType.Companion.getThreeLine-AlXitO8())) {
            return ListItemKt.ListItemThreeLineVerticalPadding;
        }

        return ListItemKt.ListItemVerticalPadding;
    }
}

