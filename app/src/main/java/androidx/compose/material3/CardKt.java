package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A_\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001A\u0083\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001AS\u0010\u0019\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001A\u001Aw\u0010\u0019\u001A\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001B\u001A]\u0010\u001C\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001A\u0081\u0001\u0010\u001C\u001A\u00020\u00012\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u001C\u0010\f\u001A\u0018\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001D"}, d2={"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "onClick", "Lkotlin/Function0;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CardKt {
    public static final void Card(Modifier arg21, Shape arg22, CardColors arg23, CardElevation arg24, BorderStroke arg25, Function3 arg26, Composer arg27, int arg28, int arg29) {
        CardElevation v4_2;
        BorderStroke v5_3;
        CardColors v3_1;
        boolean v5_2;
        CardColors v4_1;
        Shape v9_2;
        Modifier v8_2;
        BorderStroke v16;
        CardElevation v1_1;
        Shape v2_1;
        Modifier v1_3;
        int v10;
        BorderStroke v9_1;
        int v9;
        CardElevation v8_1;
        int v8;
        CardColors v5_1;
        int v5;
        Shape v4;
        Modifier v2;
        int v3;
        Function3 v6 = arg26;
        int v7 = arg28;
        int v0 = 0x510B47DE;
        Composer v15 = arg27.startRestartGroup(v0);
        ComposerKt.sourceInformation(v15, "C(Card)N(modifier,shape,colors,elevation,border,content)92@4165L57,94@4261L41,87@3953L349:Card.kt#uh7d8r");
        int v1 = arg29 & 1;
        if(v1 != 0) {
            v3 = v7 | 6;
            v2 = arg21;
        }
        else if((v7 & 6) == 0) {
            v2 = arg21;
            v3 = v15.changed(v2) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v2 = arg21;
            v3 = v7;
        }

        if((v7 & 0x30) == 0) {
            if((arg29 & 2) == 0) {
                v4 = arg22;
                if(v15.changed(v4)) {
                    v5 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v4 = arg22;
            label_35:
                v5 = 16;
            }

            v3 |= v5;
        }
        else {
            v4 = arg22;
        }

        if((v7 & 0x180) == 0) {
            if((arg29 & 4) == 0) {
                v5_1 = arg23;
                if(v15.changed(v5_1)) {
                    v8 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v5_1 = arg23;
            label_49:
                v8 = 0x80;
            }

            v3 |= v8;
        }
        else {
            v5_1 = arg23;
        }

        if((v7 & 0xC00) == 0) {
            if((arg29 & 8) == 0) {
                v8_1 = arg24;
                if(v15.changed(v8_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_63;
                }
            }
            else {
                v8_1 = arg24;
            label_63:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg24;
        }

        int v18 = arg29 & 16;
        if(v18 != 0) {
            v3 |= 0x6000;
            goto label_81;
        }
        else if((v7 & 0x6000) == 0) {
            v9_1 = arg25;
            v10 = v15.changed(v9_1) ? 0x4000 : 0x2000;
            v3 |= v10;
        }
        else {
        label_81:
            v9_1 = arg25;
        }

        int v11 = 0x30000;
        if((arg29 & 0x20) != 0) {
            v3 |= v11;
        }
        else if((v7 & v11) == 0) {
            v10 = v15.changedInstance(v6) ? 0x20000 : 0x10000;
            v3 |= v10;
        }

        boolean v10_1 = (74899 & v3) != 74898 ? true : false;
        if(v15.shouldExecute(v10_1, v3 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "81@3742L5,82@3787L12,83@3845L15");
            Object v11_1 = null;
            int v13 = 6;
            if((v7 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v1 != 0) {
                    Companion v1_2 = Modifier.Companion;
                }
                else {
                    v1_3 = v2;
                }

                if((arg29 & 2) != 0) {
                    v2_1 = CardDefaults.INSTANCE.getShape(v15, v13);
                    v3 &= 0xFFFFFF8F;
                }
                else {
                    v2_1 = v4;
                }

                if((arg29 & 4) != 0) {
                    v4_1 = CardDefaults.INSTANCE.cardColors(v15, v13);
                    v3 &= -897;
                }
                else {
                    v4_1 = v5_1;
                }

                if((arg29 & 8) != 0) {
                    v5_2 = true;
                    v8_1 = CardDefaults.INSTANCE.cardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v15, 0x180000, 0x3F);
                    v3 &= 0xFFFFE3FF;
                }
                else {
                    v5_2 = true;
                }

                CardElevation v9_3 = v8_1;
                Companion v8_3 = ((Companion)v1_3);
                v1_1 = v9_3;
                if(v18 != 0) {
                    v9_2 = v2_1;
                    v16 = null;
                    goto label_182;
                }

                v16 = arg25;
                v9_2 = v2_1;
            }
            else {
                v15.skipToGroupEnd();
                if((arg29 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                if((arg29 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg29 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                v1_1 = v8_1;
                v16 = v9_1;
                v8_2 = v2;
                v9_2 = v4;
                v4_1 = v5_1;
                v5_2 = true;
            }

        label_182:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.Card (Card.kt:86)");
            }

            SurfaceKt.Surface-T9BRK9s(v8_2, v9_2, v4_1.containerColor-vNxB06k$material3(v5_2), v4_1.contentColor-vNxB06k$material3(v5_2), 0f, v1_1.shadowElevation$material3(v5_2, null, v15, v3 >> 3 & 0x380 | 54).getValue().unbox-impl(), v16, ComposableLambdaKt.rememberComposableLambda(-97109725, v5_2, new CardKt$Card$1(v6), v15, 54), v15, v3 & 14 | 0xC00000 | v3 & 0x70 | 0x380000 & v3 << 6, 16);
            v15 = v15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v4_1;
            v2_1 = v9_2;
            v5_3 = v16;
            v4_2 = v1_1;
            v1_3 = v8_2;
        }
        else {
            v15.skipToGroupEnd();
            v1_3 = v2;
            v2_1 = v4;
            v3_1 = v5_1;
            v4_2 = v8_1;
            v5_3 = arg25;
        }

        ScopeUpdateScope v9_4 = v15.endRestartGroup();
        if(v9_4 != null) {
            v9_4.updateScope(new CardKt$$ExternalSyntheticLambda2(v1_3, v2_1, v3_1, v4_2, v5_3, v6, v7, arg29));
        }
    }

    public static final void Card(Function0 arg29, Modifier arg30, boolean arg31, Shape arg32, CardColors arg33, CardElevation arg34, BorderStroke arg35, MutableInteractionSource arg36, Function3 arg37, Composer arg38, int arg39, int arg40) {
        BorderStroke v7_1;
        Shape v4_2;
        boolean v3_2;
        Modifier v2_1;
        MutableInteractionSource v8_2;
        CardElevation v6_3;
        CardColors v5_3;
        Composer v25;
        MutableInteractionSource v23_1;
        MutableInteractionSource v6_2;
        int v5_1;
        CardElevation v1_1;
        boolean v14_2;
        Modifier v13_1;
        Composer v12_2;
        BorderStroke v22_1;
        boolean v4_1;
        CardColors v0_3;
        Shape v15_1;
        MutableInteractionSource v3_1;
        int v15;
        BorderStroke v14_1;
        int v14;
        int v13;
        CardColors v12_1;
        int v12;
        Shape v8_1;
        boolean v7;
        int v6;
        Modifier v5;
        int v3;
        Function3 v9 = arg37;
        int v10 = arg39;
        int v11 = arg40;
        Composer v1 = arg38.startRestartGroup(0x7F51EB4D);
        ComposerKt.sourceInformation(v1, "C(Card)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)155@7038L43,158@7167L41,148@6786L422:Card.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v1.changedInstance(arg29) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_40;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg30;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_40:
            v5 = arg30;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_55;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg31;
            int v8 = v1.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_55:
            v7 = arg31;
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 8) == 0) {
                v8_1 = arg32;
                if(v1.changed(v8_1)) {
                    v12 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v8_1 = arg32;
            label_66:
                v12 = 0x400;
            }

            v3 |= v12;
        }
        else {
            v8_1 = arg32;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v12_1 = arg33;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v12_1 = arg33;
            label_80:
                v13 = 0x2000;
            }

            v3 |= v13;
        }
        else {
            v12_1 = arg33;
        }

        if((0x30000 & v10) == 0) {
            v14 = (v11 & 0x20) != 0 || !v1.changed(arg34) ? 0x10000 : 0x20000;
            v3 |= v14;
        }

        int v22 = v11 & 0x40;
        v14 = 0x180000;
        if(v22 != 0) {
            v3 |= v14;
            goto label_114;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg35;
            v15 = v1.changed(v14_1) ? 0x100000 : 0x80000;
            v3 |= v15;
        }
        else {
        label_114:
            v14_1 = arg35;
        }

        v15 = v11 & 0x80;
        int v16 = 0xC00000;
        if(v15 != 0) {
            v3 |= v16;
        }
        else {
            MutableInteractionSource v0 = arg36;
            if((v10 & v16) == 0) {
                v16 = v1.changed(v0) ? 0x800000 : 0x400000;
                v3 |= v16;
            }
        }

        v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v3 |= v16;
        }
        else if((v10 & v16) == 0) {
            int v0_1 = v1.changedInstance(v9) ? 0x4000000 : 0x2000000;
            v3 |= v0_1;
        }

        boolean v0_2 = (0x2492493 & v3) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "139@6397L5,140@6442L12,141@6500L15");
            v16 = 0xFFFF1FFF;
            int v38 = 0xFFF8FFFF;
            int v2 = 6;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v5_2 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = true;
                }

                if((v11 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                    v8_1 = CardDefaults.INSTANCE.getShape(v1, v2);
                }

                if((v11 & 16) != 0) {
                    v0_3 = CardDefaults.INSTANCE.cardColors(v1, v2);
                    v3 &= v16;
                }
                else {
                    v0_3 = v12_1;
                }

                if((v11 & 0x20) != 0) {
                    v4_1 = true;
                    v6 = v15;
                    Composer v19 = v1;
                    v1_1 = CardDefaults.INSTANCE.cardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v19, 0x180000, 0x3F);
                    v12_2 = v19;
                    v3 &= v38;
                }
                else {
                    v12_2 = v1;
                    v4_1 = true;
                    v6 = v15;
                    v1_1 = arg34;
                }

                BorderStroke v13_2 = null;
                v14_1 = v22 != 0 ? v13_2 : arg35;
                if(v6 != 0) {
                    Modifier v15_2 = v5;
                    v5_1 = v3;
                    v3_1 = ((MutableInteractionSource)v13_2);
                    v13_1 = v15_2;
                    v15_1 = v8_1;
                    v22_1 = v14_1;
                    v14_2 = v7;
                    goto label_246;
                }

                v13_1 = v5;
                v15_1 = v8_1;
                v22_1 = v14_1;
                v5_1 = v3;
                v14_2 = v7;
            label_184:
                v3_1 = arg36;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v11 & 16) != 0) {
                    v3 &= v16;
                }

                if((v11 & 0x20) != 0) {
                    v3 &= v38;
                }

                v15_1 = v8_1;
                v0_3 = v12_1;
                v4_1 = true;
                v22_1 = v14_1;
                v12_2 = v1;
                v13_1 = v5;
                v14_2 = v7;
                v1_1 = arg34;
                v5_1 = v3;
                goto label_184;
            }

        label_246:
            v12_2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7F51EB4D, v5_1, -1, "androidx.compose.material3.Card (Card.kt:145)");
            }

            if(v3_1 == null) {
                v12_2.startReplaceGroup(1577885006);
                ComposerKt.sourceInformation(v12_2, "147@6742L39");
                ComposerKt.sourceInformationMarkerStart(v12_2, 0xF2848934, "CC(remember):Card.kt#9igjgp");
                Object v6_1 = v12_2.rememberedValue();
                if(v6_1 == Composer.Companion.getEmpty()) {
                    v6_2 = InteractionSourceKt.MutableInteractionSource();
                    v12_2.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v12_2);
                v12_2.endReplaceGroup();
                Object v23 = v6_2;
            }
            else {
                v12_2.startReplaceGroup(0xF28486A9);
                v12_2.endReplaceGroup();
                v23_1 = v3_1;
            }

            v25 = v12_2;
            SurfaceKt.Surface-o_FOJdg(arg29, v13_1, v14_2, v15_1, v0_3.containerColor-vNxB06k$material3(v14_2), v0_3.contentColor-vNxB06k$material3(v14_2), 0f, v1_1.shadowElevation$material3(v14_2, v23_1, v12_2, v5_1 >> 6 & 14 | v5_1 >> 9 & 0x380).getValue().unbox-impl(), v22_1, v23_1, ComposableLambdaKt.rememberComposableLambda(0xAFAE4E98, v4_1, new CardKt$Card$3(v9), v12_2, 54), v25, v5_1 & 0x1FFE | v5_1 << 6 & 0xE000000, 6, 0x40);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_3 = v0_3;
            v6_3 = v1_1;
            v8_2 = v3_1;
            v2_1 = v13_1;
            v3_2 = v14_2;
            v4_2 = v15_1;
            v7_1 = v22_1;
        }
        else {
            v25 = v1;
            v25.skipToGroupEnd();
            v6_3 = arg34;
            v2_1 = v5;
            v3_2 = v7;
            v4_2 = v8_1;
            v5_3 = v12_1;
            v7_1 = arg35;
            v8_2 = arg36;
        }

        ScopeUpdateScope v12_3 = v25.endRestartGroup();
        if(v12_3 != null) {
            v12_3.updateScope(new CardKt$$ExternalSyntheticLambda0(arg29, v2_1, v3_2, v4_2, v5_3, v6_3, v7_1, v8_2, v9, v10, v11));
        }
    }

    static final Unit Card$lambda$0(Modifier arg10, Shape arg11, CardColors arg12, CardElevation arg13, BorderStroke arg14, Function3 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        CardKt.Card(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit Card$lambda$2(Function0 arg13, Modifier arg14, boolean arg15, Shape arg16, CardColors arg17, CardElevation arg18, BorderStroke arg19, MutableInteractionSource arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        CardKt.Card(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public static final void ElevatedCard(Modifier arg17, Shape arg18, CardColors arg19, CardElevation arg20, Function3 arg21, Composer arg22, int arg23, int arg24) {
        CardElevation v4_2;
        CardColors v3_1;
        Modifier v7_2;
        Composer v14;
        CardElevation v10;
        CardColors v9_2;
        Shape v8_1;
        Companion v7_3;
        CardColors v4_1;
        Shape v2_1;
        Modifier v1_2;
        int v9;
        int v8;
        CardElevation v7_1;
        int v7;
        CardColors v5_1;
        int v5;
        Shape v4;
        Modifier v2;
        int v3;
        int v6 = arg23;
        int v0 = 0xA8B2DF96;
        Composer v13 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v13, "C(ElevatedCard)N(modifier,shape,colors,elevation,content)197@8874L169:Card.kt#uh7d8r");
        int v1 = arg24 & 1;
        if(v1 != 0) {
            v3 = v6 | 6;
            v2 = arg17;
        }
        else if((v6 & 6) == 0) {
            v2 = arg17;
            v3 = v13.changed(v2) ? 4 : 2;
            v3 |= v6;
        }
        else {
            v2 = arg17;
            v3 = v6;
        }

        if((v6 & 0x30) == 0) {
            if((arg24 & 2) == 0) {
                v4 = arg18;
                if(v13.changed(v4)) {
                    v5 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v4 = arg18;
            label_34:
                v5 = 16;
            }

            v3 |= v5;
        }
        else {
            v4 = arg18;
        }

        if((v6 & 0x180) == 0) {
            if((arg24 & 4) == 0) {
                v5_1 = arg19;
                if(v13.changed(v5_1)) {
                    v7 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v5_1 = arg19;
            label_48:
                v7 = 0x80;
            }

            v3 |= v7;
        }
        else {
            v5_1 = arg19;
        }

        if((v6 & 0xC00) == 0) {
            if((arg24 & 8) == 0) {
                v7_1 = arg20;
                if(v13.changed(v7_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v7_1 = arg20;
            label_62:
                v8 = 0x400;
            }

            v3 |= v8;
        }
        else {
            v7_1 = arg20;
        }

        if((arg24 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v6 & 0x6000) == 0) {
            v9 = v13.changedInstance(arg21) ? 0x4000 : 0x2000;
            v3 |= v9;
        }

        boolean v9_1 = (v3 & 9363) != 9362 ? true : false;
        if(v13.shouldExecute(v9_1, v3 & 1)) {
            v13.startDefaults();
            ComposerKt.sourceInformation(v13, "192@8673L13,193@8726L20,194@8792L23");
            if((v6 & 1) == 0 || (v13.getDefaultsInvalid())) {
                if(v1 != 0) {
                    Companion v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                v9 = 6;
                if((arg24 & 2) != 0) {
                    v2_1 = CardDefaults.INSTANCE.getElevatedShape(v13, v9);
                    v3 &= 0xFFFFFF8F;
                }
                else {
                    v2_1 = v4;
                }

                if((arg24 & 4) != 0) {
                    v4_1 = CardDefaults.INSTANCE.elevatedCardColors(v13, v9);
                    v3 &= -897;
                }
                else {
                    v4_1 = v5_1;
                }

                if((arg24 & 8) != 0) {
                    v14 = v13;
                    v3 &= 0xFFFFE3FF;
                    v7_3 = ((Companion)v1_2);
                    v8_1 = v2_1;
                    v9_2 = v4_1;
                    v10 = CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v14, 0x180000, 0x3F);
                    goto label_157;
                }

                v14 = v13;
                v8_1 = v2_1;
                v9_2 = v4_1;
                v10 = v7_1;
                v7_3 = ((Companion)v1_2);
            }
            else {
                v13.skipToGroupEnd();
                if((arg24 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                if((arg24 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg24 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                v8_1 = v4;
                v9_2 = v5_1;
                v10 = v7_1;
                v14 = v13;
                v7_2 = v2;
            }

        label_157:
            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:197)");
            }

            CardKt.Card(v7_2, v8_1, v9_2, v10, null, arg21, v14, v3 & 14 | 0x6000 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | v3 << 3 & 0x70000, 0);
            v14 = v14;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = v7_2;
            v2_1 = v8_1;
            v3_1 = v9_2;
            v4_2 = v10;
        }
        else {
            v14 = v13;
            v14.skipToGroupEnd();
            v1_2 = v2;
            v2_1 = v4;
            v3_1 = v5_1;
            v4_2 = v7_1;
        }

        ScopeUpdateScope v8_2 = v14.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new CardKt$$ExternalSyntheticLambda4(v1_2, v2_1, v3_1, v4_2, arg21, v6, arg24));
        }
    }

    public static final void ElevatedCard(Function0 arg24, Modifier arg25, boolean arg26, Shape arg27, CardColors arg28, CardElevation arg29, MutableInteractionSource arg30, Function3 arg31, Composer arg32, int arg33, int arg34) {
        CardElevation v6_1;
        CardColors v5_2;
        Shape v4_1;
        boolean v3_1;
        Modifier v2_1;
        MutableInteractionSource v7_1;
        boolean v13_2;
        Modifier v12_2;
        MutableInteractionSource v18;
        CardElevation v16;
        CardColors v15_1;
        Shape v14_1;
        Composer v20;
        Composer v18_1;
        CardColors v0_1;
        Companion v5_1;
        MutableInteractionSource v13_1;
        int v13;
        CardElevation v12_1;
        int v12;
        CardColors v11_1;
        int v11;
        Shape v8_1;
        boolean v7;
        int v6;
        Modifier v5;
        Function0 v2;
        int v3;
        int v9 = arg33;
        int v10 = arg34;
        Composer v1 = arg32.startRestartGroup(0xF84D8075);
        ComposerKt.sourceInformation(v1, "C(ElevatedCard)N(onClick,modifier,enabled,shape,colors,elevation,interactionSource,content)250@11337L270:Card.kt#uh7d8r");
        if((v10 & 1) != 0) {
            v3 = v9 | 6;
            v2 = arg24;
        }
        else if((v9 & 6) == 0) {
            v2 = arg24;
            v3 = v1.changedInstance(v2) ? 4 : 2;
            v3 |= v9;
        }
        else {
            v2 = arg24;
            v3 = v9;
        }

        int v4 = v10 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_39;
        }
        else if((v9 & 0x30) == 0) {
            v5 = arg25;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_39:
            v5 = arg25;
        }

        v6 = v10 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_54;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg26;
            int v8 = v1.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_54:
            v7 = arg26;
        }

        if((v9 & 0xC00) == 0) {
            if((v10 & 8) == 0) {
                v8_1 = arg27;
                if(v1.changed(v8_1)) {
                    v11 = 0x800;
                }
                else {
                    goto label_65;
                }
            }
            else {
                v8_1 = arg27;
            label_65:
                v11 = 0x400;
            }

            v3 |= v11;
        }
        else {
            v8_1 = arg27;
        }

        if((v9 & 0x6000) == 0) {
            if((v10 & 16) == 0) {
                v11_1 = arg28;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v11_1 = arg28;
            label_79:
                v12 = 0x2000;
            }

            v3 |= v12;
        }
        else {
            v11_1 = arg28;
        }

        if((0x30000 & v9) == 0) {
            if((v10 & 0x20) == 0) {
                v12_1 = arg29;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v12_1 = arg29;
            label_94:
                v13 = 0x10000;
            }

            v3 |= v13;
        }
        else {
            v12_1 = arg29;
        }

        int v21 = v10 & 0x40;
        int v22 = 0x180000;
        if(v21 != 0) {
            v3 |= v22;
            goto label_113;
        }
        else if((v9 & v22) == 0) {
            v13_1 = arg30;
            int v14 = v1.changed(v13_1) ? 0x100000 : 0x80000;
            v3 |= v14;
        }
        else {
        label_113:
            v13_1 = arg30;
        }

        int v15 = 0xC00000;
        if((v10 & 0x80) != 0) {
            v3 |= v15;
        }
        else if((v9 & v15) == 0) {
            v15 = v1.changedInstance(arg31) ? 0x800000 : 0x400000;
            v3 |= v15;
        }

        boolean v0 = (0x492493 & v3) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "244@11079L13,245@11132L20,246@11198L23");
            int v23 = 0xFFF8FFFF;
            v15 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = true;
                }

                v4 = 6;
                if((v10 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                    v8_1 = CardDefaults.INSTANCE.getElevatedShape(v1, v4);
                }

                if((v10 & 16) != 0) {
                    v0_1 = CardDefaults.INSTANCE.elevatedCardColors(v1, v4);
                    v3 &= v15;
                }
                else {
                    v0_1 = v11_1;
                }

                if((v10 & 0x20) != 0) {
                    v18_1 = v1;
                    v3 &= v23;
                    v12_1 = CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v18_1, 0x180000, 0x3F);
                }
                else {
                    v18_1 = v1;
                }

                if(v21 != 0) {
                    v15_1 = v0_1;
                    v13_2 = v7;
                    v14_1 = v8_1;
                    v16 = v12_1;
                    v20 = v18_1;
                    v18 = null;
                }
                else {
                    v15_1 = v0_1;
                    v13_2 = v7;
                    v14_1 = v8_1;
                    v16 = v12_1;
                    v20 = v18_1;
                    v18 = arg30;
                }

                v12_2 = ((Modifier)v5_1);
            }
            else {
                v1.skipToGroupEnd();
                if((v10 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v10 & 16) != 0) {
                    v3 &= v15;
                }

                if((v10 & 0x20) != 0) {
                    v3 &= v23;
                }

                v20 = v1;
                v14_1 = v8_1;
                v15_1 = v11_1;
                v16 = v12_1;
                v18 = v13_1;
                v12_2 = v5;
                v13_2 = v7;
            }

            v20.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF84D8075, v3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
            }

            int v1_1 = v3 << 3;
            CardKt.Card(v2, v12_2, v13_2, v14_1, v15_1, v16, null, v18, arg31, v20, v3 & 14 | v22 | v3 & 0x70 | v3 & 0x380 | v3 & 0x1C00 | 0xE000 & v3 | 0x70000 & v3 | 0x1C00000 & v1_1 | v1_1 & 0xE000000, 0);
            MutableInteractionSource v1_2 = v18;
            v18_1 = v20;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v1_2;
            v2_1 = v12_2;
            v3_1 = v13_2;
            v4_1 = v14_1;
            v5_2 = v15_1;
            v6_1 = v16;
        }
        else {
            v18_1 = v1;
            v18_1.skipToGroupEnd();
            v2_1 = v5;
            v3_1 = v7;
            v4_1 = v8_1;
            v5_2 = v11_1;
            v6_1 = v12_1;
            v7_1 = arg30;
        }

        ScopeUpdateScope v11_2 = v18_1.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new CardKt$$ExternalSyntheticLambda3(arg24, v2_1, v3_1, v4_1, v5_2, v6_1, v7_1, arg31, v9, v10));
        }
    }

    static final Unit ElevatedCard$lambda$3(Modifier arg8, Shape arg9, CardColors arg10, CardElevation arg11, Function3 arg12, int arg13, int arg14, Composer arg15, int arg16) {
        CardKt.ElevatedCard(arg8, arg9, arg10, arg11, arg12, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedCard$lambda$4(Function0 arg12, Modifier arg13, boolean arg14, Shape arg15, CardColors arg16, CardElevation arg17, MutableInteractionSource arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        CardKt.ElevatedCard(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final void OutlinedCard(Modifier arg20, Shape arg21, CardColors arg22, CardElevation arg23, BorderStroke arg24, Function3 arg25, Composer arg26, int arg27, int arg28) {
        CardElevation v4_2;
        CardColors v3_1;
        Composer v15;
        BorderStroke v12;
        CardElevation v11;
        CardColors v10_2;
        Shape v9_1;
        Companion v8_3;
        BorderStroke v5_3;
        boolean v5_2;
        CardColors v4_1;
        Shape v2_1;
        Modifier v1_2;
        Companion v1_1;
        int v9;
        BorderStroke v8_1;
        int v8;
        CardElevation v6_1;
        int v6;
        CardColors v5_1;
        int v5;
        Shape v4;
        Modifier v2;
        int v3;
        int v7 = arg27;
        int v0 = 0x8C07D6E0;
        Composer v14 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(OutlinedCard)N(modifier,shape,colors,elevation,border,content)298@13425L171:Card.kt#uh7d8r");
        int v1 = arg28 & 1;
        if(v1 != 0) {
            v3 = v7 | 6;
            v2 = arg20;
        }
        else if((v7 & 6) == 0) {
            v2 = arg20;
            v3 = v14.changed(v2) ? 4 : 2;
            v3 |= v7;
        }
        else {
            v2 = arg20;
            v3 = v7;
        }

        if((v7 & 0x30) == 0) {
            if((arg28 & 2) == 0) {
                v4 = arg21;
                if(v14.changed(v4)) {
                    v5 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v4 = arg21;
            label_34:
                v5 = 16;
            }

            v3 |= v5;
        }
        else {
            v4 = arg21;
        }

        if((v7 & 0x180) == 0) {
            if((arg28 & 4) == 0) {
                v5_1 = arg22;
                if(v14.changed(v5_1)) {
                    v6 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v5_1 = arg22;
            label_48:
                v6 = 0x80;
            }

            v3 |= v6;
        }
        else {
            v5_1 = arg22;
        }

        if((v7 & 0xC00) == 0) {
            if((arg28 & 8) == 0) {
                v6_1 = arg23;
                if(v14.changed(v6_1)) {
                    v8 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v6_1 = arg23;
            label_62:
                v8 = 0x400;
            }

            v3 |= v8;
        }
        else {
            v6_1 = arg23;
        }

        if((v7 & 0x6000) == 0) {
            if((arg28 & 16) == 0) {
                v8_1 = arg24;
                if(v14.changed(v8_1)) {
                    v9 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v8_1 = arg24;
            label_76:
                v9 = 0x2000;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg24;
        }

        int v10 = 0x30000;
        if((arg28 & 0x20) != 0) {
            v3 |= v10;
        }
        else if((v7 & v10) == 0) {
            v10 = v14.changedInstance(arg25) ? 0x20000 : 0x10000;
            v3 |= v10;
        }

        boolean v10_1 = (74899 & v3) != 74898 ? true : false;
        if(v14.shouldExecute(v10_1, v3 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "292@13162L13,293@13215L20,294@13281L23,295@13346L20");
            int v18 = 0xFFFF1FFF;
            if((v7 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v1 != 0) {
                    v1_1 = Modifier.Companion;
                }
                else {
                    v1_2 = v2;
                }

                v10 = 6;
                if((arg28 & 2) != 0) {
                    v2_1 = CardDefaults.INSTANCE.getOutlinedShape(v14, v10);
                    v3 &= 0xFFFFFF8F;
                }
                else {
                    v2_1 = v4;
                }

                if((arg28 & 4) != 0) {
                    v4_1 = CardDefaults.INSTANCE.outlinedCardColors(v14, v10);
                    v3 &= -897;
                }
                else {
                    v4_1 = v5_1;
                }

                if((arg28 & 8) != 0) {
                    v5_2 = false;
                    v15 = v14;
                    v3 &= 0xFFFFE3FF;
                    v8 = 1;
                    v6_1 = CardDefaults.INSTANCE.outlinedCardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v15, 0x180000, 0x3F);
                }
                else {
                    v5_2 = false;
                    v8 = 1;
                    v15 = v14;
                }

                if((arg28 & 16) != 0) {
                    v5_3 = CardDefaults.INSTANCE.outlinedCardBorder(v5_2, v15, 0x30, v8);
                    v3 &= v18;
                    v8_3 = v1_1;
                    v9_1 = v2_1;
                    v10_2 = v4_1;
                    v12 = v5_3;
                }
                else {
                    v12 = arg24;
                    v8_3 = v1_1;
                    v9_1 = v2_1;
                    v10_2 = v4_1;
                }

                v11 = v6_1;
            }
            else {
                v14.skipToGroupEnd();
                if((arg28 & 2) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                if((arg28 & 4) != 0) {
                    v3 &= -897;
                }

                if((arg28 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((arg28 & 16) != 0) {
                    v3 &= v18;
                }

                v9_1 = v4;
                v10_2 = v5_1;
                v11 = v6_1;
                v12 = v8_1;
                v15 = v14;
                Modifier v8_2 = v2;
            }

            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:298)");
            }

            CardKt.Card(((Modifier)v8_3), v9_1, v10_2, v11, v12, arg25, v15, 0x7FFFE & v3, 0);
            v15 = v15;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_2 = ((Modifier)v8_3);
            v2_1 = v9_1;
            v3_1 = v10_2;
            v4_2 = v11;
            v5_3 = v12;
        }
        else {
            v15 = v14;
            v15.skipToGroupEnd();
            v1_2 = v2;
            v2_1 = v4;
            v3_1 = v5_1;
            v4_2 = v6_1;
            v5_3 = arg24;
        }

        ScopeUpdateScope v9_2 = v15.endRestartGroup();
        if(v9_2 != null) {
            v9_2.updateScope(new CardKt$$ExternalSyntheticLambda1(v1_2, v2_1, v3_1, v4_2, v5_3, arg25, v7, arg28));
        }
    }

    public static final void OutlinedCard(Function0 arg24, Modifier arg25, boolean arg26, Shape arg27, CardColors arg28, CardElevation arg29, BorderStroke arg30, MutableInteractionSource arg31, Function3 arg32, Composer arg33, int arg34, int arg35) {
        MutableInteractionSource v8_2;
        BorderStroke v7_1;
        CardElevation v6_2;
        CardColors v5_2;
        Shape v4_1;
        boolean v3_1;
        Modifier v2_1;
        Composer v21;
        Shape v15_2;
        MutableInteractionSource v19;
        CardElevation v17_1;
        CardColors v16_1;
        boolean v14_1;
        Modifier v13_1;
        Composer v6_1;
        BorderStroke v18;
        BorderStroke v0_2;
        int v0_1;
        Companion v5_1;
        int v16;
        MutableInteractionSource v15_1;
        int v14;
        int v13;
        CardElevation v12_1;
        int v12;
        CardColors v9_1;
        int v9;
        Shape v8_1;
        boolean v7;
        int v6;
        Modifier v5;
        int v3;
        int v10 = arg34;
        int v11 = arg35;
        Composer v1 = arg33.startRestartGroup(0x538ACF0B);
        ComposerKt.sourceInformation(v1, "C(OutlinedCard)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)353@16051L272:Card.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v3 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v3 = v1.changedInstance(arg24) ? 4 : 2;
            v3 |= v10;
        }
        else {
            v3 = v10;
        }

        int v4 = v11 & 2;
        if(v4 != 0) {
            v3 |= 0x30;
            goto label_39;
        }
        else if((v10 & 0x30) == 0) {
            v5 = arg25;
            v6 = v1.changed(v5) ? 0x20 : 16;
            v3 |= v6;
        }
        else {
        label_39:
            v5 = arg25;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v3 |= 0x180;
            goto label_54;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg26;
            int v8 = v1.changed(v7) ? 0x100 : 0x80;
            v3 |= v8;
        }
        else {
        label_54:
            v7 = arg26;
        }

        if((v10 & 0xC00) == 0) {
            if((v11 & 8) == 0) {
                v8_1 = arg27;
                if(v1.changed(v8_1)) {
                    v9 = 0x800;
                }
                else {
                    goto label_65;
                }
            }
            else {
                v8_1 = arg27;
            label_65:
                v9 = 0x400;
            }

            v3 |= v9;
        }
        else {
            v8_1 = arg27;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v9_1 = arg28;
                if(v1.changed(v9_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v9_1 = arg28;
            label_79:
                v12 = 0x2000;
            }

            v3 |= v12;
        }
        else {
            v9_1 = arg28;
        }

        if((0x30000 & v10) == 0) {
            if((v11 & 0x20) == 0) {
                v12_1 = arg29;
                if(v1.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_94;
                }
            }
            else {
                v12_1 = arg29;
            label_94:
                v13 = 0x10000;
            }

            v3 |= v13;
        }
        else {
            v12_1 = arg29;
        }

        if((0x180000 & v10) == 0) {
            v14 = (v11 & 0x40) != 0 || !v1.changed(arg30) ? 0x80000 : 0x100000;
            v3 |= v14;
        }

        v14 = v11 & 0x80;
        int v15 = 0xC00000;
        if(v14 != 0) {
            v3 |= v15;
            goto label_128;
        }
        else if((v15 & v10) == 0) {
            v15_1 = arg31;
            v16 = v1.changed(v15_1) ? 0x800000 : 0x400000;
            v3 |= v16;
        }
        else {
        label_128:
            v15_1 = arg31;
        }

        v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v3 |= v16;
        }
        else if((v10 & v16) == 0) {
            v16 = v1.changedInstance(arg32) ? 0x4000000 : 0x2000000;
            v3 |= v16;
        }

        boolean v0 = (v3 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0, v3 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
            int v2 = 0xFFC7FFFF;
            int v23 = 0xFFF8FFFF;
            int v17 = 0xFFFF1FFF;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v7 = true;
                }

                v4 = 6;
                if((v11 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                    v8_1 = CardDefaults.INSTANCE.getOutlinedShape(v1, v4);
                }

                if((v11 & 16) != 0) {
                    v3 &= v17;
                    v9_1 = CardDefaults.INSTANCE.outlinedCardColors(v1, v4);
                }

                if((v11 & 0x20) != 0) {
                    v0_1 = 0;
                    v4 = v14;
                    v6_1 = v1;
                    v3 &= v23;
                    v12_1 = CardDefaults.INSTANCE.outlinedCardElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v1, 0x180000, 0x3F);
                }
                else {
                    v6_1 = v1;
                    v0_1 = 0;
                    v4 = v14;
                }

                if((v11 & 0x40) != 0) {
                    v0_2 = CardDefaults.INSTANCE.outlinedCardBorder(v7, v6_1, v3 >> 6 & 14 | 0x30, v0_1);
                    v3 &= v2;
                }
                else {
                    v0_2 = arg30;
                }

                if(v4 != 0) {
                    v18 = v0_2;
                    v19 = null;
                }
                else {
                    v19 = arg31;
                    v18 = v0_2;
                }

                v13_1 = ((Modifier)v5_1);
                v14_1 = v7;
                v15_2 = v8_1;
                v16_1 = v9_1;
                v17_1 = v12_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v11 & 16) != 0) {
                    v3 &= v17;
                }

                if((v11 & 0x20) != 0) {
                    v3 &= v23;
                }

                if((v11 & 0x40) != 0) {
                    v3 &= v2;
                }

                v18 = arg30;
                v6_1 = v1;
                v13_1 = v5;
                v14_1 = v7;
                v16_1 = v9_1;
                v17_1 = v12_1;
                v19 = v15_1;
                v15_2 = v8_1;
            }

            v6_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x538ACF0B, v3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
            }

            v21 = v6_1;
            CardKt.Card(arg24, v13_1, v14_1, v15_2, v16_1, v17_1, v18, v19, arg32, v21, v3 & 0xFFFFFFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v13_1;
            v3_1 = v14_1;
            v4_1 = v15_2;
            v5_2 = v16_1;
            v6_2 = v17_1;
            v7_1 = v18;
            v8_2 = v19;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v2_1 = v5;
            v3_1 = v7;
            v4_1 = v8_1;
            v5_2 = v9_1;
            v6_2 = v12_1;
            v7_1 = arg30;
            v8_2 = arg31;
        }

        ScopeUpdateScope v12_2 = v21.endRestartGroup();
        if(v12_2 != null) {
            v12_2.updateScope(new CardKt$$ExternalSyntheticLambda5(arg24, v2_1, v3_1, v4_1, v5_2, v6_2, v7_1, v8_2, arg32, v10, v11));
        }
    }

    static final Unit OutlinedCard$lambda$5(Modifier arg10, Shape arg11, CardColors arg12, CardElevation arg13, BorderStroke arg14, Function3 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        CardKt.OutlinedCard(arg10, arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedCard$lambda$6(Function0 arg13, Modifier arg14, boolean arg15, Shape arg16, CardColors arg17, CardElevation arg18, BorderStroke arg19, MutableInteractionSource arg20, Function3 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        CardKt.OutlinedCard(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }
}

