package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0087\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\u0015\b\u0002\u0010\t\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u007F\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000B\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001Aw\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u001C\u0010\u0016\u001A\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001A\u0010\u001B\u001A:\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\r2\u0006\u0010\u0002\u001A\u00020\u00032\u0011\u0010\u0016\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001F\u0010 \u001A7\u0010!\u001A\u00020\u00012\u0013\u0010\t\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001A\u001C\u0010#\u001A\u00020\u0001*\u00020$2\u0006\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020(H\u0002\u001AD\u0010)\u001A\u00020\u0001*\u00020$2\u0006\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020&2\u0006\u0010-\u001A\u00020&2\u0006\u0010.\u001A\u00020(2\u0006\u0010\'\u001A\u00020(2\u0006\u0010/\u001A\u00020(2\u0006\u00100\u001A\u00020(H\u0002\"\u0010\u00101\u001A\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001A\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0016\u00105\u001A\u000202X\u0080\u0004¢\u0006\n\n\u0002\u00103\u001A\u0004\b6\u00107\"\u0010\u00108\u001A\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001A\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001A\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<\"\u0010\u0010=\u001A\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006>²\u0006\n\u0010?\u001A\u00020\rX\u008A\u0084\u0002"}, d2={"Tab", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", "icon", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material3", "color"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TabKt {
    private static final float DoubleLineTextBaselineWithIcon;
    private static final float HorizontalTextPadding;
    private static final long IconDistanceFromBaseline;
    private static final float LargeTabHeight;
    private static final float SingleLineTextBaselineWithIcon;
    private static final float SmallTabHeight;
    private static final float TextDistanceFromLeadingIcon;

    static {
        TabKt.SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TabKt.LargeTabHeight = Dp.constructor-impl(72f);
        TabKt.HorizontalTextPadding = Dp.constructor-impl(16f);
        TabKt.SingleLineTextBaselineWithIcon = Dp.constructor-impl(14f);
        TabKt.DoubleLineTextBaselineWithIcon = Dp.constructor-impl(6f);
        TabKt.IconDistanceFromBaseline = TextUnitKt.getSp(20);
        TabKt.TextDistanceFromLeadingIcon = Dp.constructor-impl(8f);
    }

    public static final void LeadingIconTab-wqdebIU(boolean arg20, Function0 arg21, Function2 arg22, Function2 arg23, Modifier arg24, boolean arg25, long arg26, long arg28, MutableInteractionSource arg30, Composer arg31, int arg32, int arg33) {
        long v9_1;
        boolean v6_2;
        MutableInteractionSource v11_1;
        Modifier v5_1;
        Composer v0_4;
        long v18_1;
        MutableInteractionSource v6_1;
        int v18;
        long v14;
        int v11;
        boolean v10_1;
        int v8;
        Modifier v7;
        int v6;
        Function2 v4_1;
        int v3;
        Function0 v9;
        boolean v5;
        int v2;
        int v12 = arg32;
        int v13 = arg33;
        Composer v1 = arg31.startRestartGroup(0xDB8CB526);
        ComposerKt.sourceInformation(v1, "C(LeadingIconTab)N(selected,onClick,text,icon,modifier,enabled,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource)170@7524L952,170@7454L1022:Tab.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v2 = v12 | 6;
            v5 = arg20;
        }
        else {
            v5 = arg20;
            if((v12 & 6) == 0) {
                v2 = v1.changed(v5) ? 4 : 2;
                v2 |= v12;
            }
            else {
                v2 = v12;
            }
        }

        if((v13 & 2) != 0) {
            v2 |= 0x30;
            v9 = arg21;
        }
        else {
            v9 = arg21;
            if((v12 & 0x30) == 0) {
                v3 = v1.changedInstance(v9) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        if((v13 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v12 & 0x180) == 0) {
            int v4 = v1.changedInstance(arg22) ? 0x100 : 0x80;
            v2 |= v4;
        }

        if((v13 & 8) != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v4_1 = arg23;
            v6 = v1.changedInstance(v4_1) ? 0x800 : 0x400;
            v2 |= v6;
        }
        else {
        label_66:
            v4_1 = arg23;
        }

        v6 = v13 & 16;
        if(v6 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v7 = arg24;
            v8 = v1.changed(v7) ? 0x4000 : 0x2000;
            v2 |= v8;
        }
        else {
        label_81:
            v7 = arg24;
        }

        v8 = v13 & 0x20;
        int v10 = 0x30000;
        if(v8 != 0) {
            v2 |= v10;
            goto label_97;
        }
        else if((v10 & v12) == 0) {
            v10_1 = arg25;
            v11 = v1.changed(v10_1) ? 0x20000 : 0x10000;
            v2 |= v11;
        }
        else {
        label_97:
            v10_1 = arg25;
        }

        if((0x180000 & v12) == 0) {
            v14 = arg26;
            v11 = (v13 & 0x40) != 0 || !v1.changed(v14) ? 0x80000 : 0x100000;
            v2 |= v11;
        }
        else {
            v14 = arg26;
        }

        if((0xC00000 & v12) == 0) {
            int v31 = v2;
            long v2_1 = arg28;
            v11 = (v13 & 0x80) != 0 || !v1.changed(v2_1) ? 0x400000 : 0x800000;
            v11 |= v31;
        }
        else {
            v11 = v2;
        }

        int v0 = v13 & 0x100;
        int v17 = 0x6000000;
        if(v0 != 0) {
            v11 |= v17;
            goto label_145;
        }
        else if((v12 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg30) ? 0x4000000 : 0x2000000;
            v11 |= v18;
        }
        else {
        label_145:
            v17 = v0;
        }

        boolean v0_1 = (v11 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v11 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "161@7032L7");
            v2 = 0xFE3FFFFF;
            v18 = 0xFFC7FFFF;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v6 != 0) {
                    Companion v7_1 = Modifier.Companion;
                }

                if(v8 != 0) {
                    v10_1 = true;
                }

                if((v13 & 0x40) != 0) {
                    ProvidableCompositionLocal v0_2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_3 = v1.consume(((CompositionLocal)v0_2));
                    ComposerKt.sourceInformationMarkerEnd(v1);
                    v14 = ((Color)v0_3).unbox-impl();
                    v11 &= v18;
                }

                if((v13 & 0x80) != 0) {
                    v11 &= v2;
                    v18_1 = v14;
                }
                else {
                    v18_1 = arg28;
                }

                if(v17 != 0) {
                    v6_1 = null;
                    goto label_177;
                }

            label_176:
                v6_1 = arg30;
            }
            else {
                v1.skipToGroupEnd();
                if((v13 & 0x40) != 0) {
                    v11 &= v18;
                }

                if((v13 & 0x80) != 0) {
                    v11 &= v2;
                }

                v18_1 = arg28;
                goto label_176;
            }

        label_177:
            boolean v8_1 = v10_1;
            v0 = v11;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xDB8CB526, v0, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
            }

            Function2 v10_2 = v4_1;
            Modifier v4_2 = v7;
            v3 = v0 >> 18;
            TabKt.TabTransition-Klgx-Pg(v14, v18_1, arg20, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new TabKt$LeadingIconTab$1(v4_2, v5, v6_1, RippleKt.ripple-H2RKhps$default(true, 0f, v14, 2, null), v8_1, v9, v10_2, arg22), v1, 54), v1, v0 << 6 & 0x380 | (v3 & 0x70 | (v3 & 14 | 0xC00)));
            v0_4 = v1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v4_2;
            v11_1 = v6_1;
            v6_2 = v8_1;
            v9_1 = v18_1;
        }
        else {
            v0_4 = v1;
            v0_4.skipToGroupEnd();
            v11_1 = arg30;
            v5_1 = v7;
            v6_2 = v10_1;
            v9_1 = arg28;
        }

        long v7_2 = v14;
        ScopeUpdateScope v14_1 = v0_4.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new TabKt$$ExternalSyntheticLambda2(arg20, arg21, arg22, arg23, v5_1, v6_2, v7_2, v9_1, v11_1, v12, v13));
        }
    }

    static final Unit LeadingIconTab_wqdebIU$lambda$2(boolean arg15, Function0 arg16, Function2 arg17, Function2 arg18, Modifier arg19, boolean arg20, long arg21, long arg23, MutableInteractionSource arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TabKt.LeadingIconTab-wqdebIU(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg23, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void Tab-bogVsAg(boolean arg23, Function0 arg24, Modifier arg25, boolean arg26, long arg27, long arg29, MutableInteractionSource arg31, Function3 arg32, Composer arg33, int arg34, int arg35) {
        boolean v4_2;
        Modifier v3_2;
        long v7_1;
        MutableInteractionSource v9_2;
        long v5_1;
        Composer v0_5;
        int v0_2;
        MutableInteractionSource v16_1;
        long v3_1;
        Modifier v14;
        long v21;
        int v17;
        int v15;
        long v13_1;
        int v13;
        long v9_1;
        boolean v8;
        int v6;
        Modifier v4;
        int v3;
        boolean v5;
        int v1;
        int v11 = arg34;
        int v12 = arg35;
        Composer v7 = arg33.startRestartGroup(0xA23BD62B);
        ComposerKt.sourceInformation(v7, "C(Tab)N(selected,onClick,modifier,enabled,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource,content)243@10768L602,243@10698L672:Tab.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v5 = arg23;
        }
        else {
            v5 = arg23;
            if((v11 & 6) == 0) {
                v1 = v7.changed(v5) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v1 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v3 = v7.changedInstance(arg24) ? 0x20 : 16;
            v1 |= v3;
        }

        v3 = v12 & 4;
        if(v3 != 0) {
            v1 |= 0x180;
            goto label_52;
        }
        else if((v11 & 0x180) == 0) {
            v4 = arg25;
            v6 = v7.changed(v4) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_52:
            v4 = arg25;
        }

        v6 = v12 & 8;
        if(v6 != 0) {
            v1 |= 0xC00;
            goto label_67;
        }
        else if((v11 & 0xC00) == 0) {
            v8 = arg26;
            int v9 = v7.changed(v8) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_67:
            v8 = arg26;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v9_1 = arg27;
                if(v7.changed(v9_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v9_1 = arg27;
            label_78:
                v13 = 0x2000;
            }

            v1 |= v13;
        }
        else {
            v9_1 = arg27;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v13_1 = arg29;
                if(v7.changed(v13_1)) {
                    v15 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v13_1 = arg29;
            label_93:
                v15 = 0x10000;
            }

            v1 |= v15;
        }
        else {
            v13_1 = arg29;
        }

        v15 = v12 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            MutableInteractionSource v0 = arg31;
            if((v11 & v16) == 0) {
                v17 = v7.changed(v0) ? 0x100000 : 0x80000;
                v1 |= v17;
            }
        }

        v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v7.changedInstance(arg32) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v33 = v1;
        boolean v0_1 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v7.shouldExecute(v0_1, v33 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "233@10230L7");
            v1 = 0xFFF8FFFF;
            v17 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v4_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    v8 = true;
                }

                if((v12 & 16) != 0) {
                    ProvidableCompositionLocal v0_3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_4 = v7.consume(((CompositionLocal)v0_3));
                    ComposerKt.sourceInformationMarkerEnd(v7);
                    v9_1 = ((Color)v0_4).unbox-impl();
                    v0_2 = v33 & v17;
                }
                else {
                    v0_2 = v33;
                }

                if((v12 & 0x20) != 0) {
                    v0_2 &= v1;
                    v13_1 = v9_1;
                }

                if(v15 != 0) {
                    v21 = v13_1;
                    v14 = v4;
                    v3_1 = v21;
                    v16_1 = null;
                    goto label_163;
                }

            label_159:
                v21 = v13_1;
                v14 = v4;
                v3_1 = v21;
                v16_1 = arg31;
            }
            else {
                v7.skipToGroupEnd();
                v0_2 = (v12 & 16) != 0 ? v33 & v17 : v33;
                if((v12 & 0x20) == 0) {
                    goto label_159;
                }

                v0_2 &= v1;
                goto label_159;
            }

        label_163:
            boolean v18 = v8;
            v1 = 0xA23BD62B;
            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v0_2, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
            }

            v1 = v0_2 >> 12;
            TabKt.TabTransition-Klgx-Pg(v9_1, v3_1, arg23, ComposableLambdaKt.rememberComposableLambda(0x434457E7, true, new TabKt$Tab$3(v14, v5, v16_1, RippleKt.ripple-H2RKhps$default(true, 0f, v9_1, 2, null), v18, arg24, arg32), v7, 54), v7, v1 & 0x70 | (v1 & 14 | 0xC00) | v0_2 << 6 & 0x380);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_5 = v7;
            v5_1 = v9_1;
            v9_2 = v16_1;
            v7_1 = v3_1;
            v3_2 = v14;
            v4_2 = v18;
        }
        else {
            v7.skipToGroupEnd();
            v3_2 = v4;
            v0_5 = v7;
            v4_2 = v8;
            v5_1 = v9_1;
            v7_1 = v13_1;
            v9_2 = arg31;
        }

        ScopeUpdateScope v13_2 = v0_5.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new TabKt$$ExternalSyntheticLambda0(arg23, arg24, v3_2, v4_2, v5_1, v7_1, v9_2, arg32, v11, v12));
        }
    }

    public static final void Tab-wqdebIU(boolean arg27, Function0 arg28, Modifier arg29, boolean arg30, Function2 arg31, Function2 arg32, long arg33, long arg35, MutableInteractionSource arg37, Composer arg38, int arg39, int arg40) {
        MutableInteractionSource v11_1;
        long v9_1;
        long v7_1;
        boolean v4_2;
        Function2 v6_1;
        Function2 v5_1;
        Modifier v3_1;
        Composer v24;
        long v20_1;
        Function2 v0_2;
        boolean v17;
        MutableInteractionSource v22;
        long v18_1;
        long v23;
        long v21;
        Companion v4_1;
        int v19;
        int v0;
        int v16;
        int v38;
        int v11;
        Function2 v10_1;
        int v9;
        Function2 v8;
        int v7;
        boolean v6;
        int v5;
        Modifier v4;
        int v3;
        Function0 v15;
        boolean v14;
        int v2;
        int v12 = arg39;
        int v13 = arg40;
        Composer v1 = arg38.startRestartGroup(0x3C7FF1ED);
        ComposerKt.sourceInformation(v1, "C(Tab)N(selected,onClick,modifier,enabled,text,icon,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource)119@5177L65,111@4883L359:Tab.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v2 = v12 | 6;
            v14 = arg27;
        }
        else {
            v14 = arg27;
            if((v12 & 6) == 0) {
                v2 = v1.changed(v14) ? 4 : 2;
                v2 |= v12;
            }
            else {
                v2 = v12;
            }
        }

        if((v13 & 2) != 0) {
            v2 |= 0x30;
            v15 = arg28;
        }
        else {
            v15 = arg28;
            if((v12 & 0x30) == 0) {
                v3 = v1.changedInstance(v15) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v13 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v4 = arg29;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_51:
            v4 = arg29;
        }

        v5 = v13 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v6 = arg30;
            v7 = v1.changed(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_66:
            v6 = arg30;
        }

        v7 = v13 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v8 = arg31;
            v9 = v1.changedInstance(v8) ? 0x4000 : 0x2000;
            v2 |= v9;
        }
        else {
        label_81:
            v8 = arg31;
        }

        v9 = v13 & 0x20;
        int v10 = 0x30000;
        if(v9 != 0) {
            v2 |= v10;
            goto label_97;
        }
        else if((v10 & v12) == 0) {
            v10_1 = arg32;
            v11 = v1.changedInstance(v10_1) ? 0x20000 : 0x10000;
            v2 |= v11;
        }
        else {
        label_97:
            v10_1 = arg32;
        }

        if((0x180000 & v12) == 0) {
            if((v13 & 0x40) == 0) {
                v11 = v2;
                v38 = v3;
                if(v1.changed(arg33)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_113;
                }
            }
            else {
                v11 = v2;
                v38 = v3;
            label_113:
                v16 = 0x80000;
            }

            v11 |= v16;
        }
        else {
            v11 = v2;
            v38 = v3;
        }

        v16 = 0xC00000;
        if((v12 & v16) == 0) {
            long v2_1 = arg35;
            v0 = (v13 & 0x80) != 0 || !v1.changed(v2_1) ? 0x400000 : 0x800000;
            v11 |= v0;
        }

        v0 = v13 & 0x100;
        int v18 = 0x6000000;
        if(v0 != 0) {
            v11 |= v18;
            goto label_149;
        }
        else if((v12 & v18) == 0) {
            v18 = v0;
            v19 = v1.changed(arg37) ? 0x4000000 : 0x2000000;
            v11 |= v19;
        }
        else {
        label_149:
            v18 = v0;
        }

        boolean v0_1 = (v11 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v11 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "97@4401L7");
            v2 = 0xFE3FFFFF;
            v19 = 0xFFC7FFFF;
            Function2 v20 = null;
            if((v12 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v4_1 = Modifier.Companion;
                }

                if(v5 != 0) {
                    v6 = true;
                }

                if(v7 != 0) {
                    v8 = v20;
                }

                if(v9 != 0) {
                    v10_1 = v20;
                }

                if((v13 & 0x40) != 0) {
                    ProvidableCompositionLocal v0_3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v1, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_4 = v1.consume(((CompositionLocal)v0_3));
                    ComposerKt.sourceInformationMarkerEnd(v1);
                    v21 = ((Color)v0_4).unbox-impl();
                    v11 &= v19;
                }
                else {
                    v21 = arg33;
                }

                if((v13 & 0x80) != 0) {
                    v11 &= v2;
                    v23 = v21;
                }
                else {
                    v23 = arg35;
                }

                v17 = v6;
                v0_2 = v20;
                if(v18 != 0) {
                    v18_1 = v21;
                    v2 = 0x3C7FF1ED;
                    v22 = ((MutableInteractionSource)v0_2);
                    v20_1 = v23;
                    goto label_227;
                }

                v18_1 = v21;
                v20_1 = v23;
                v2 = 0x3C7FF1ED;
                v22 = arg37;
            }
            else {
                v1.skipToGroupEnd();
                if((v13 & 0x40) != 0) {
                    v11 &= v19;
                }

                if((v13 & 0x80) != 0) {
                    v11 &= v2;
                }

                v18_1 = arg33;
                v22 = arg37;
                v17 = v6;
                v0_2 = v20;
                v2 = 0x3C7FF1ED;
                v20_1 = arg35;
            }

        label_227:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v2, v11, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
            }

            v2 = 54;
            if(v8 == null) {
                v1.startReplaceGroup(0x6D214FD5);
            }
            else {
                v1.startReplaceGroup(1830899670);
                ComposerKt.sourceInformation(v1, "*103@4621L247");
                ComposableLambda v0_5 = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new TabKt$Tab$styledText$1$1(v8), v1, v2);
            }

            v1.endReplaceGroup();
            v5 = v16;
            Modifier v16_1 = BadgeKt.badgeBounds(((Modifier)v4_1));
            ComposableLambda v23_1 = ComposableLambdaKt.rememberComposableLambda(0xC9FE3BA0, true, new TabKt$Tab$1(v0_2, v10_1), v1, v2);
            v2 = v11 >> 6;
            v24 = v1;
            TabKt.Tab-bogVsAg(v14, v15, v16_1, v17, v18_1, v20_1, v22, ((Function3)v23_1), v24, v11 & 14 | v5 | v11 & 0x70 | v11 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | v2 & 0x380000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = ((Modifier)v4_1);
            v5_1 = v8;
            v6_1 = v10_1;
            v4_2 = v17;
            v7_1 = v18_1;
            v9_1 = v20_1;
            v11_1 = v22;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v11_1 = arg37;
            v3_1 = v4;
            v4_2 = v6;
            v5_1 = v8;
            v6_1 = v10_1;
            v7_1 = arg33;
            v9_1 = arg35;
        }

        ScopeUpdateScope v14_1 = v24.endRestartGroup();
        if(v14_1 != null) {
            v14_1.updateScope(new TabKt$$ExternalSyntheticLambda1(arg27, arg28, v3_1, v4_2, v5_1, v6_1, v7_1, v9_1, v11_1, v12, v13));
        }
    }

    private static final void TabBaselineLayout(Function2 arg16, Function2 arg17, Composer arg18, int arg19) {
        int v5;
        Function2 v0 = arg16;
        Function2 v1 = arg17;
        int v2 = arg19;
        int v3 = 0xAF8A23AA;
        Composer v4 = arg18.startRestartGroup(v3);
        ComposerKt.sourceInformation(v4, "C(TabBaselineLayout)N(text,icon)308@13077L2044,301@12833L2288:Tab.kt#uh7d8r");
        int v6 = 4;
        int v7 = 2;
        if((v2 & 6) == 0) {
            v5 = v4.changedInstance(v0) ? v6 : v7;
            v5 |= v2;
        }
        else {
            v5 = v2;
        }

        int v9 = 0x20;
        if((v2 & 0x30) == 0) {
            int v8 = v4.changedInstance(v1) ? v9 : 16;
            v5 |= v8;
        }

        int v11 = 1;
        boolean v8_1 = (v5 & 19) != 18 ? true : false;
        if(v4.shouldExecute(v8_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v5, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:300)");
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xF59015E6, "CC(remember):Tab.kt#9igjgp");
            v3 = v5 & 14;
            v6 = v3 == v6 ? 1 : 0;
            if((v5 & 0x70) == v9) {
            }
            else {
                v11 = 0;
            }

            Object v8_2 = v4.rememberedValue();
            if((v6 | v11) != 0 || v8_2 == Composer.Companion.getEmpty()) {
                TabKt$TabBaselineLayout$2$1 v8_3 = new TabKt$TabBaselineLayout$2$1(v0, v1);
                v4.updateRememberedValue(v8_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            String v9_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v4, -1323940314, v9_1);
            Companion v10 = Modifier.Companion;
            v11 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
            CompositionLocalMap v13 = v4.getCurrentCompositionLocalMap();
            Modifier v10_1 = ComposedModifierKt.materializeModifier(v4, ((Modifier)v10));
            Function0 v14 = ComposeUiNode.Companion.getConstructor();
            String v6_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, v6_1);
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v14);
            }
            else {
                v4.useNode();
            }

            Composer v14_1 = Updater.constructor-impl(v4);
            Updater.set-impl(v14_1, v8_2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v14_1, v13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v8_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v14_1.getInserting()) || !Intrinsics.areEqual(v14_1.rememberedValue(), Integer.valueOf(v11))) {
                v14_1.updateRememberedValue(Integer.valueOf(v11));
                v14_1.apply(Integer.valueOf(v11), v8_4);
            }

            Updater.set-impl(v14_1, v10_1, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 0x33E07087, "C:Tab.kt#uh7d8r");
            String v8_5 = "C72@3468L9:Box.kt#2w3rfo";
            String v11_1 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            int v13_1 = 0x2BB5B5D7;
            if(v0 != null) {
                v4.startReplaceGroup(0x33E0A8F4);
                ComposerKt.sourceInformation(v4, "303@12882L85");
                Modifier v7_1 = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0f, v7, null);
                ComposerKt.sourceInformationMarkerStart(v4, v13_1, v11_1);
                MeasurePolicy v10_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4, -1323940314, v9_1);
                int v14_2 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
                CompositionLocalMap v12 = v4.getCurrentCompositionLocalMap();
                v7_1 = ComposedModifierKt.materializeModifier(v4, v7_1);
                Function0 v15 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, v6_1);
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v15);
                }
                else {
                    v4.useNode();
                }

                Composer v13_2 = Updater.constructor-impl(v4);
                Updater.set-impl(v13_2, v10_2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v13_2, v12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v10_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v13_2.getInserting()) || !Intrinsics.areEqual(v13_2.rememberedValue(), Integer.valueOf(v14_2))) {
                    v13_2.updateRememberedValue(Integer.valueOf(v14_2));
                    v13_2.apply(Integer.valueOf(v14_2), v10_3);
                }

                Updater.set-impl(v13_2, v7_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x800B7D29, v8_5);
                ComposerKt.sourceInformationMarkerStart(v4, 0x5CC49B3B, "C303@12959L6:Tab.kt#uh7d8r");
                v0.invoke(v4, Integer.valueOf(v3));
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(870466081);
                v4.endReplaceGroup();
            }

            if(v1 != null) {
                v4.startReplaceGroup(870494880);
                ComposerKt.sourceInformation(v4, "306@13018L41");
                Modifier v3_1 = LayoutIdKt.layoutId(Modifier.Companion, "icon");
                ComposerKt.sourceInformationMarkerStart(v4, 0x2BB5B5D7, v11_1);
                MeasurePolicy v7_2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4, -1323940314, v9_1);
                v9 = ComposablesKt.getCurrentCompositeKeyHash(v4, 0);
                CompositionLocalMap v10_4 = v4.getCurrentCompositionLocalMap();
                v3_1 = ComposedModifierKt.materializeModifier(v4, v3_1);
                Function0 v11_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4, 0xD6BD0031, v6_1);
                if(!(v4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4.startReusableNode();
                if(v4.getInserting()) {
                    v4.createNode(v11_2);
                }
                else {
                    v4.useNode();
                }

                Composer v6_2 = Updater.constructor-impl(v4);
                Updater.set-impl(v6_2, v7_2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v6_2, v10_4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 v7_3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v6_2.getInserting()) || !Intrinsics.areEqual(v6_2.rememberedValue(), Integer.valueOf(v9))) {
                    v6_2.updateRememberedValue(Integer.valueOf(v9));
                    v6_2.apply(Integer.valueOf(v9), v7_3);
                }

                Updater.set-impl(v6_2, v3_1, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4, 0x800B7D29, v8_5);
                ComposerKt.sourceInformationMarkerStart(v4, 0x443CEBE4, "C306@13051L6:Tab.kt#uh7d8r");
                v1.invoke(v4, Integer.valueOf(v5 >> 3 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(870557345);
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_280;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v4.skipToGroupEnd();
        }

    label_280:
        ScopeUpdateScope v3_2 = v4.endRestartGroup();
        if(v3_2 != null) {
            v3_2.updateScope(new TabKt$$ExternalSyntheticLambda4(v0, v1, v2));
        }
    }

    static final Unit TabBaselineLayout$lambda$11(Function2 arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        TabKt.TabBaselineLayout(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    private static final void TabTransition-Klgx-Pg(long arg19, long arg21, boolean arg23, Function2 arg24, Composer arg25, int arg26) {
        int v10;
        boolean v5_1;
        int v1;
        Function2 v6 = arg24;
        int v7 = arg26;
        int v0 = 0xCE57367B;
        Composer v14 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(TabTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)275@11802L26,278@11937L416,291@12358L77:Tab.kt#uh7d8r");
        int v2 = 2;
        long v3 = arg19;
        if((v7 & 6) == 0) {
            v1 = v14.changed(v3) ? 4 : v2;
            v1 |= v7;
        }
        else {
            v1 = v7;
        }

        long v8 = arg21;
        if((v7 & 0x30) == 0) {
            int v5 = v14.changed(v8) ? 0x20 : 16;
            v1 |= v5;
        }

        if((v7 & 0x180) == 0) {
            v5_1 = arg23;
            v10 = v14.changed(v5_1) ? 0x100 : 0x80;
            v1 |= v10;
        }
        else {
            v5_1 = arg23;
        }

        if((v7 & 0xC00) == 0) {
            v10 = v14.changedInstance(v6) ? 0x800 : 0x400;
            v1 |= v10;
        }

        boolean v10_1 = (v1 & 0x493) != 1170 ? true : false;
        if(v14.shouldExecute(v10_1, v1 & 1)) {
            int v11 = -1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, v11, "androidx.compose.material3.TabTransition (Tab.kt:274)");
            }

            v1 >>= 6;
            Transition v0_1 = TransitionKt.updateTransition(Boolean.valueOf(v5_1), null, v14, v1 & 14, v2);
            TabKt$TabTransition$color$2 v2_1 = TabKt$TabTransition$color$2.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v14, 0x8C629A81, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            v10_1 = v0_1.getTargetState().booleanValue();
            int v13 = 0xC044C4D8;
            v14.startReplaceGroup(v13);
            String v15 = "CN(it):Tab.kt#uh7d8r";
            ComposerKt.sourceInformation(v14, v15);
            Transition v25 = v0_1;
            String v0_2 = "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)";
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v13, 0, v11, v0_2);
            }

            long v16 = v10_1 ? v3 : v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v14.endReplaceGroup();
            ColorSpace v10_2 = Color.getColorSpace-impl(v16);
            ComposerKt.sourceInformationMarkerStart(v14, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean v11_1 = v14.changed(v10_2);
            Object v12 = v14.rememberedValue();
            if((v11_1) || v12 == Composer.Companion.getEmpty()) {
                v12 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v10_2);
                v14.updateRememberedValue(v12);
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerStart(v14, 0xF77F2E11, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            v10_1 = v25.getCurrentState().booleanValue();
            v14.startReplaceGroup(v13);
            ComposerKt.sourceInformation(v14, v15);
            int v18 = v1;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v13, 0, -1, v0_2);
            }

            long v10_3 = v10_1 ? v3 : v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v14.endReplaceGroup();
            Color v1_1 = Color.box-impl(v10_3);
            v10_1 = v25.getTargetState().booleanValue();
            v14.startReplaceGroup(v13);
            ComposerKt.sourceInformation(v14, v15);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v13, 0, -1, v0_2);
            }

            v10_3 = v10_1 ? v3 : v8;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v14.endReplaceGroup();
            State v0_3 = TransitionKt.createTransitionAnimation(v25, v1_1, Color.box-impl(v10_3), ((Function3)v2_1).invoke(v25.getSegment(), v14, Integer.valueOf(0)), ((TwoWayConverter)v12), "ColorAnimation", v14, 0);
            ComposerKt.sourceInformationMarkerEnd(v14);
            ComposerKt.sourceInformationMarkerEnd(v14);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(TabKt.TabTransition_Klgx_Pg$lambda$5(v0_3))), v6, v14, ProvidedValue.$stable | v18 & 0x70);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_171;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14.skipToGroupEnd();
        }

    label_171:
        ScopeUpdateScope v8_1 = v14.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new TabKt$$ExternalSyntheticLambda3(v3, arg21, v5_1, v6, v7));
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$5(State arg2) {
        return arg2.getValue().unbox-impl();
    }

    static final Unit TabTransition_Klgx_Pg$lambda$6(long arg8, long arg10, boolean arg12, Function2 arg13, int arg14, Composer arg15, int arg16) {
        TabKt.TabTransition-Klgx-Pg(arg8, arg10, arg12, arg13, arg15, RecomposeScopeImplKt.updateChangedFlags(arg14 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Tab_bogVsAg$lambda$3(boolean arg14, Function0 arg15, Modifier arg16, boolean arg17, long arg18, long arg20, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        TabKt.Tab-bogVsAg(arg14, arg15, arg16, arg17, arg18, arg20, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit Tab_wqdebIU$lambda$1(boolean arg15, Function0 arg16, Modifier arg17, boolean arg18, Function2 arg19, Function2 arg20, long arg21, long arg23, MutableInteractionSource arg25, int arg26, int arg27, Composer arg28, int arg29) {
        TabKt.Tab-wqdebIU(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg23, arg25, arg28, RecomposeScopeImplKt.updateChangedFlags(arg26 | 1), arg27);
        return Unit.INSTANCE;
    }

    public static final void access$TabBaselineLayout(Function2 arg0, Function2 arg1, Composer arg2, int arg3) {
        TabKt.TabBaselineLayout(arg0, arg1, arg2, arg3);
    }

    public static final long access$getIconDistanceFromBaseline$p() {
        return TabKt.IconDistanceFromBaseline;
    }

    public static final float access$getLargeTabHeight$p() {
        return TabKt.LargeTabHeight;
    }

    public static final float access$getSmallTabHeight$p() {
        return TabKt.SmallTabHeight;
    }

    public static final float access$getTextDistanceFromLeadingIcon$p() {
        return TabKt.TextDistanceFromLeadingIcon;
    }

    public static final void access$placeTextAndIcon(PlacementScope arg0, Density arg1, Placeable arg2, Placeable arg3, int arg4, int arg5, int arg6, int arg7) {
        TabKt.placeTextAndIcon(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    public static final void access$placeTextOrIcon(PlacementScope arg0, Placeable arg1, int arg2) {
        TabKt.placeTextOrIcon(arg0, arg1, arg2);
    }

    public static final float getHorizontalTextPadding() {
        return TabKt.HorizontalTextPadding;
    }

    private static final void placeTextAndIcon(PlacementScope arg19, Density arg20, Placeable arg21, Placeable arg22, int arg23, int arg24, int arg25, int arg26) {
        Density v0 = arg20;
        int v1 = arg25;
        int v2 = arg26;
        float v3 = v1 == v2 ? TabKt.SingleLineTextBaselineWithIcon : TabKt.DoubleLineTextBaselineWithIcon;
        int v3_1 = v0.roundToPx-0680j_4(v3) + v0.roundToPx-0680j_4(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM());
        int v4 = arg22.getHeight() + v0.roundToPx--R2X_6o(TabKt.IconDistanceFromBaseline) - v1;
        int v8 = arg24 - v2 - v3_1;
        PlacementScope.placeRelative$default(arg19, arg21, (arg23 - arg21.getWidth()) / 2, v8, 0f, 4, null);
        PlacementScope.placeRelative$default(arg19, arg22, (arg23 - arg22.getWidth()) / 2, v8 - v4, 0f, 4, null);
    }

    private static final void placeTextOrIcon(PlacementScope arg7, Placeable arg8, int arg9) {
        PlacementScope.placeRelative$default(arg7, arg8, 0, (arg9 - arg8.getHeight()) / 2, 0f, 4, null);
    }
}

