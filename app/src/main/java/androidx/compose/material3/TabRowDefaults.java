package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\fH\u0007¢\u0006\u0004\b!\u0010\"JA\u0010#\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010$\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\f2\b\b\u0002\u0010%\u001A\u00020&H\u0007¢\u0006\u0004\b\'\u0010(J-\u0010)\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\fH\u0007¢\u0006\u0004\b*\u0010\"J\u0014\u0010+\u001A\u00020\u001E*\u00020\u001E2\u0006\u0010,\u001A\u00020-H\u0007R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u001A\u0010\u000B\u001A\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u000FR\u001A\u0010\u0014\u001A\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001A\u0004\b\u0016\u0010\u000FR\u0011\u0010\u0017\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u000FR\u0011\u0010\u0019\u001A\u00020\f8G¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u000F¨\u0006.²\u0006\n\u0010/\u001A\u00020\u0005X\u008A\u0084\u0002²\u0006\n\u00100\u001A\u00020\u0005X\u008A\u0084\u0002"}, d2={"Landroidx/compose/material3/TabRowDefaults;", "", "<init>", "()V", "ScrollableTabRowMinTabWidth", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowMinTabWidth-D9Ej5fM", "()F", "F", "ScrollableTabRowEdgeStartPadding", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryContainerColor", "getPrimaryContainerColor", "secondaryContainerColor", "getSecondaryContainerColor", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3", "currentTabWidth", "indicatorOffset"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TabRowDefaults {
    public static final int $stable;
    public static final TabRowDefaults INSTANCE;
    private static final float ScrollableTabRowEdgeStartPadding;
    private static final float ScrollableTabRowMinTabWidth;

    static {
        TabRowDefaults.INSTANCE = new TabRowDefaults();
        TabRowDefaults.ScrollableTabRowMinTabWidth = Dp.constructor-impl(90f);
        TabRowDefaults.ScrollableTabRowEdgeStartPadding = Dp.constructor-impl(52f);
    }

    private TabRowDefaults() {
        super();
    }

    @Deprecated(message="Use SecondaryIndicator instead.", replaceWith="<_subannotation>") public final void Indicator-9IZ8Weo(Modifier arg21, float arg22, long arg23, Composer arg25, int arg26, int arg27) {
        long v4_1;
        float v3_1;
        Modifier v2_1;
        long v15;
        Companion v2_2;
        int v10;
        long v8_1;
        float v7;
        Modifier v3;
        int v4;
        int v6 = arg26;
        int v0 = 1454716052;
        Composer v1 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(Indicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1039@44576L69:TabRow.kt#uh7d8r");
        int v2 = arg27 & 1;
        if(v2 != 0) {
            v4 = v6 | 6;
            v3 = arg21;
        }
        else if((v6 & 6) == 0) {
            v3 = arg21;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v6;
        }
        else {
            v3 = arg21;
            v4 = v6;
        }

        int v5 = arg27 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v6 & 0x30) == 0) {
            v7 = arg22;
            int v8 = v1.changed(v7) ? 0x20 : 16;
            v4 |= v8;
        }
        else {
        label_38:
            v7 = arg22;
        }

        if((v6 & 0x180) == 0) {
            if((arg27 & 4) == 0) {
                v8_1 = arg23;
                if(v1.changed(v8_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v8_1 = arg23;
            label_49:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v8_1 = arg23;
        }

        boolean v10_1 = (v4 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v10_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1037@44488L11");
            if((v6 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                v3_1 = v5 != 0 ? PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() : v7;
                if((arg27 & 4) != 0) {
                    v4 &= -897;
                    v15 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(v1, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                    goto label_99;
                }

            label_78:
                v15 = v8_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg27 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = v3;
                v3_1 = v7;
                goto label_78;
            }

        label_99:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1038)");
            }

            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(((Modifier)v2_2), 0f, 1, null), v3_1), v15, null, 2, null), v1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v15;
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = v3;
            v3_1 = v7;
            v4_1 = v8_1;
        }

        ScopeUpdateScope v8_2 = v1.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new TabRowDefaults$$ExternalSyntheticLambda0(this, ((Modifier)v2_2), v3_1, v4_1, v6, arg27));
        }
    }

    static final Unit Indicator_9IZ8Weo$lambda$0(TabRowDefaults arg8, Modifier arg9, float arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.Indicator-9IZ8Weo(arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public final void PrimaryIndicator-10LGxhE(Modifier arg17, float arg18, float arg19, long arg20, Shape arg22, Composer arg23, int arg24, int arg25) {
        Modifier v2_1;
        RoundedCornerShape v13_1;
        Companion v2_2;
        Shape v13;
        int v12;
        long v10_1;
        float v9;
        int v7;
        float v6;
        Modifier v3;
        int v4;
        int v8 = arg24;
        Composer v1 = arg23.startRestartGroup(0x8F037F53);
        ComposerKt.sourceInformation(v1, "C(PrimaryIndicator)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,color:c#ui.graphics.Color,shape)1060@45366L174:TabRow.kt#uh7d8r");
        int v2 = arg25 & 1;
        if(v2 != 0) {
            v4 = v8 | 6;
            v3 = arg17;
        }
        else if((v8 & 6) == 0) {
            v3 = arg17;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v8;
        }
        else {
            v3 = arg17;
            v4 = v8;
        }

        int v5 = arg25 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v8 & 0x30) == 0) {
            v6 = arg18;
            v7 = v1.changed(v6) ? 0x20 : 16;
            v4 |= v7;
        }
        else {
        label_38:
            v6 = arg18;
        }

        v7 = arg25 & 4;
        if(v7 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v8 & 0x180) == 0) {
            v9 = arg19;
            int v10 = v1.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_53:
            v9 = arg19;
        }

        if((v8 & 0xC00) == 0) {
            if((arg25 & 8) == 0) {
                v10_1 = arg20;
                if(v1.changed(v10_1)) {
                    v12 = 0x800;
                }
                else {
                    goto label_64;
                }
            }
            else {
                v10_1 = arg20;
            label_64:
                v12 = 0x400;
            }

            v4 |= v12;
        }
        else {
            v10_1 = arg20;
        }

        v12 = arg25 & 16;
        if(v12 != 0) {
            v4 |= 0x6000;
            goto label_82;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = arg22;
            int v14 = v1.changed(v13) ? 0x4000 : 0x2000;
            v4 |= v14;
        }
        else {
        label_82:
            v13 = arg22;
        }

        boolean v14_1 = (v4 & 9363) != 9362 ? true : false;
        if(v1.shouldExecute(v14_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1057@45271L5");
            if((v8 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                if(v5 != 0) {
                    v6 = Dp.constructor-impl(24f);
                }

                if(v7 != 0) {
                    v9 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
                }

                if((arg25 & 8) != 0) {
                    v10_1 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), v1, 6);
                    v4 &= 0xFFFFE3FF;
                }

                if(v12 == 0) {
                    goto label_130;
                }

                v13_1 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
            }
            else {
                v1.skipToGroupEnd();
                if((arg25 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                v2_1 = v3;
            }

        label_130:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x8F037F53, v4, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1059)");
            }

            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.requiredWidth-3ABfNKs(SizeKt.requiredHeight-3ABfNKs(((Modifier)v2_2), v9), v6), v10_1, ((Shape)v13_1)), v1, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_147;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = v3;
        }

    label_147:
        float v3_1 = v6;
        float v4_1 = v9;
        long v5_1 = v10_1;
        Shape v7_1 = ((Shape)v13_1);
        ScopeUpdateScope v10_2 = v1.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new TabRowDefaults$$ExternalSyntheticLambda1(this, ((Modifier)v2_2), v3_1, v4_1, v5_1, v7_1, v8, arg25));
        }
    }

    static final Unit PrimaryIndicator_10LGxhE$lambda$1(TabRowDefaults arg11, Modifier arg12, float arg13, float arg14, long arg15, Shape arg17, int arg18, int arg19, Composer arg20, int arg21) {
        arg11.PrimaryIndicator-10LGxhE(arg12, arg13, arg14, arg15, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public final void SecondaryIndicator-9IZ8Weo(Modifier arg21, float arg22, long arg23, Composer arg25, int arg26, int arg27) {
        long v4_1;
        float v3_1;
        Modifier v2_1;
        long v15;
        Companion v2_2;
        int v10;
        long v8_1;
        float v7;
        Modifier v3;
        int v4;
        int v6 = arg26;
        int v0 = -1498258020;
        Composer v1 = arg25.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(SecondaryIndicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1082@46080L69:TabRow.kt#uh7d8r");
        int v2 = arg27 & 1;
        if(v2 != 0) {
            v4 = v6 | 6;
            v3 = arg21;
        }
        else if((v6 & 6) == 0) {
            v3 = arg21;
            v4 = v1.changed(v3) ? 4 : 2;
            v4 |= v6;
        }
        else {
            v3 = arg21;
            v4 = v6;
        }

        int v5 = arg27 & 2;
        if(v5 != 0) {
            v4 |= 0x30;
            goto label_38;
        }
        else if((v6 & 0x30) == 0) {
            v7 = arg22;
            int v8 = v1.changed(v7) ? 0x20 : 16;
            v4 |= v8;
        }
        else {
        label_38:
            v7 = arg22;
        }

        if((v6 & 0x180) == 0) {
            if((arg27 & 4) == 0) {
                v8_1 = arg23;
                if(v1.changed(v8_1)) {
                    v10 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v8_1 = arg23;
            label_49:
                v10 = 0x80;
            }

            v4 |= v10;
        }
        else {
            v8_1 = arg23;
        }

        boolean v10_1 = (v4 & 0x93) != 0x92 ? true : false;
        if(v1.shouldExecute(v10_1, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "1080@46057L5");
            if((v6 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_2 = Modifier.Companion;
                }
                else {
                    v2_1 = v3;
                }

                v3_1 = v5 != 0 ? PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM() : v7;
                if((arg27 & 4) != 0) {
                    v4 &= -897;
                    v15 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), v1, 6);
                    goto label_97;
                }

            label_78:
                v15 = v8_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg27 & 4) != 0) {
                    v4 &= -897;
                }

                v2_1 = v3;
                v3_1 = v7;
                goto label_78;
            }

        label_97:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1081)");
            }

            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(((Modifier)v2_2), 0f, 1, null), v3_1), v15, null, 2, null), v1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v15;
        }
        else {
            v1.skipToGroupEnd();
            v2_1 = v3;
            v3_1 = v7;
            v4_1 = v8_1;
        }

        ScopeUpdateScope v8_2 = v1.endRestartGroup();
        if(v8_2 != null) {
            v8_2.updateScope(new TabRowDefaults$$ExternalSyntheticLambda2(this, ((Modifier)v2_2), v3_1, v4_1, v6, arg27));
        }
    }

    static final Unit SecondaryIndicator_9IZ8Weo$lambda$2(TabRowDefaults arg8, Modifier arg9, float arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        arg8.SecondaryIndicator-9IZ8Weo(arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    public final long getContainerColor(Composer arg3, int arg4) {
        int v0 = -2026555673;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-containerColor>)994@42840L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:994)");
        }

        long v0_1 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(message="Use TabRowDefaults.primaryContainerColor instead", replaceWith="<_subannotation>") public static void getContainerColor$annotations() {
    }

    public final long getContentColor(Composer arg3, int arg4) {
        int v0 = 1163072359;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-contentColor>)1010@43495L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1010)");
        }

        long v0_1 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(message="Use TabRowDefaults.primaryContentColor instead", replaceWith="<_subannotation>") public static void getContentColor$annotations() {
    }

    public final long getPrimaryContainerColor(Composer arg3, int arg4) {
        int v0 = -2069154037;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-primaryContainerColor>)998@43011L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:998)");
        }

        long v0_1 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getPrimaryContentColor(Composer arg3, int arg4) {
        int v0 = 0x54106CFB;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-primaryContentColor>)1014@43668L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1014)");
        }

        long v0_1 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final float getScrollableTabRowEdgeStartPadding-D9Ej5fM() {
        return TabRowDefaults.ScrollableTabRowEdgeStartPadding;
    }

    public final float getScrollableTabRowMinTabWidth-D9Ej5fM() {
        return TabRowDefaults.ScrollableTabRowMinTabWidth;
    }

    public final long getSecondaryContainerColor(Composer arg3, int arg4) {
        int v0 = -1938007129;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-secondaryContainerColor>)1002@43188L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1002)");
        }

        long v0_1 = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    public final long getSecondaryContentColor(Composer arg3, int arg4) {
        int v0 = 0x45862617;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-secondaryContentColor>)1018@43847L5:TabRow.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1018)");
        }

        long v0_1 = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Solely for use alongside deprecated TabRowDefaults.Indicator method. For recommended PrimaryIndicator and SecondaryIndicator methods, please use TabIndicatorScope.tabIndicatorOffset method.") public final Modifier tabIndicatorOffset(Modifier arg2, TabPosition arg3) {
        TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1 v1;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v1 = new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(arg3);
        }
        else {
            Function1 v1_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v1), new TabRowDefaults$tabIndicatorOffset$2(arg3));
    }
}

