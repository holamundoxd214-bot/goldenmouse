package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u009F\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u00132\b\b\u0002\u0010\u0014\u001A\u00020\u00132\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\u001C\u0010\u0017\u001A\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001A¢\u0006\u0002\b\u001BH\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001Ak\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u001C\u0010\u0017\u001A\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001A¢\u0006\u0002\b\u001BH\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001Aa\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\f\u001A\u00020\r2\u001C\u0010\u0017\u001A\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u001A¢\u0006\u0002\b\u001BH\u0007¢\u0006\u0004\b \u0010!\u001A\u0090\u0001\u0010\"\u001A\u00020\u00012\u0011\u0010#\u001A\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001A2\f\u0010$\u001A\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0015\b\u0002\u0010%\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001A2\u0015\b\u0002\u0010&\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u001A2\b\b\u0002\u0010\'\u001A\u00020\u00032\b\b\u0002\u0010(\u001A\u00020)2\b\b\u0002\u0010*\u001A\u00020+2\n\b\u0002\u0010,\u001A\u0004\u0018\u00010-H\u0007¢\u0006\u0002\u0010.\"\u0014\u0010/\u001A\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b0\u00101¨\u00062"}, d2={"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-IlH_yew", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DropdownMenu-4kj-_NE", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/ScrollState;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "DefaultMenuProperties", "getDefaultMenuProperties", "()Landroidx/compose/ui/window/PopupProperties;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidMenu_androidKt {
    private static final PopupProperties DefaultMenuProperties;

    static {
        AndroidMenu_androidKt.DefaultMenuProperties = new PopupProperties(true, false, false, false, 14, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with parameters for shape, color, elevation, and border.", replaceWith="<_subannotation>") public static final void DropdownMenu-4kj-_NE(boolean arg28, Function0 arg29, Modifier arg30, long arg31, ScrollState arg33, PopupProperties arg34, Function3 arg35, Composer arg36, int arg37, int arg38) {
        PopupProperties v7_1;
        ScrollState v6_2;
        long v4_1;
        Modifier v3_2;
        Composer v24;
        Modifier v12_2;
        int v0_1;
        PopupProperties v16_1;
        ScrollState v15_1;
        long v13_1;
        Companion v5_1;
        PopupProperties v14_1;
        int v13;
        ScrollState v12_1;
        long v7;
        int v6;
        Modifier v5;
        int v3;
        Function0 v11;
        boolean v10;
        int v2;
        int v9 = arg37;
        Composer v1 = arg36.startRestartGroup(1518067413);
        ComposerKt.sourceInformation(v1, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,content)130@4963L5,131@5008L14,123@4724L465:AndroidMenu.android.kt#uh7d8r");
        if((arg38 & 1) != 0) {
            v2 = v9 | 6;
            v10 = arg28;
        }
        else {
            v10 = arg28;
            if((v9 & 6) == 0) {
                v2 = v1.changed(v10) ? 4 : 2;
                v2 |= v9;
            }
            else {
                v2 = v9;
            }
        }

        if((arg38 & 2) != 0) {
            v2 |= 0x30;
            v11 = arg29;
        }
        else {
            v11 = arg29;
            if((v9 & 0x30) == 0) {
                v3 = v1.changedInstance(v11) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg38 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v9 & 0x180) == 0) {
            v5 = arg30;
            v6 = v1.changed(v5) ? 0x100 : 0x80;
            v2 |= v6;
        }
        else {
        label_50:
            v5 = arg30;
        }

        v6 = arg38 & 8;
        if(v6 != 0) {
            v2 |= 0xC00;
            goto label_65;
        }
        else if((v9 & 0xC00) == 0) {
            v7 = arg31;
            int v12 = v1.changed(v7) ? 0x800 : 0x400;
            v2 |= v12;
        }
        else {
        label_65:
            v7 = arg31;
        }

        if((v9 & 0x6000) == 0) {
            if((arg38 & 16) == 0) {
                v12_1 = arg33;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_76;
                }
            }
            else {
                v12_1 = arg33;
            label_76:
                v13 = 0x2000;
            }

            v2 |= v13;
        }
        else {
            v12_1 = arg33;
        }

        v13 = arg38 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_95;
        }
        else if((v14 & v9) == 0) {
            v14_1 = arg34;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_95:
            v14_1 = arg34;
        }

        int v16 = 0x180000;
        if((arg38 & 0x40) != 0) {
            v2 |= v16;
        }
        else if((v9 & v16) == 0) {
            v16 = v1.changedInstance(arg35) ? 0x100000 : 0x80000;
            v2 |= v16;
        }

        int v36 = 0x20;
        int v17 = v2;
        boolean v0 = (v2 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0, v17 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "119@4575L21");
            int v4 = 0xFFFF1FFF;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v5_1 = Modifier.Companion;
                }

                if(v6 != 0) {
                    float v3_1 = Dp.constructor-impl(0f);
                    float v0_2 = Dp.constructor-impl(0f);
                    long v6_1 = ((long)Float.floatToRawIntBits(v3_1));
                    v3 = v4;
                    arg30 = ((Modifier)v5_1);
                    v7 = DpOffset.constructor-impl((((long)Float.floatToRawIntBits(v0_2))) & 0xFFFFFFFFL | v6_1 << v36);
                }
                else {
                    v3 = v4;
                    arg30 = ((Modifier)v5_1);
                }

                if((arg38 & 16) != 0) {
                    v2 = v17 & v3;
                    v12_1 = ScrollKt.rememberScrollState(0, v1, 0, 1);
                }
                else {
                    v2 = v17;
                }

                if(v13 != 0) {
                    v13_1 = v7;
                    v15_1 = v12_1;
                    v16_1 = new PopupProperties(true, false, false, false, 14, null);
                    v0_1 = 1518067413;
                    v12_2 = arg30;
                    goto label_198;
                }

                v15_1 = v12_1;
                v16_1 = v14_1;
                v0_1 = 1518067413;
                v12_2 = arg30;
            label_146:
                v13_1 = v7;
            }
            else {
                v1.skipToGroupEnd();
                if((arg38 & 16) != 0) {
                    v2 = v17 & v4;
                    v15_1 = v12_1;
                    v16_1 = v14_1;
                }
                else {
                    v15_1 = v12_1;
                    v16_1 = v14_1;
                    v2 = v17;
                }

                v0_1 = 1518067413;
                v12_2 = v5;
                goto label_146;
            }

        label_198:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v2, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:123)");
            }

            v24 = v1;
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(v10, v11, v12_2, v13_1, v15_1, v16_1, MenuDefaults.INSTANCE.getShape(v1, 6), MenuDefaults.INSTANCE.getContainerColor(v1, 6), MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM(), null, arg35, v24, v2 & 14 | 0x36000000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2, v2 >> 15 & 0x70 | 6, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v12_2;
            v4_1 = v13_1;
            v6_2 = v15_1;
            v7_1 = v16_1;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v3_2 = v5;
            v4_1 = v7;
            v6_2 = v12_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v11_1 = v24.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new AndroidMenu_androidKt$$ExternalSyntheticLambda4(arg28, arg29, v3_2, v4_1, v6_2, v7_1, arg35, v9, arg38));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Replaced by a DropdownMenu function with a ScrollState parameter", replaceWith="<_subannotation>") public static final void DropdownMenu-ILWXrKs(boolean arg31, Function0 arg32, Modifier arg33, long arg34, PopupProperties arg36, Function3 arg37, Composer arg38, int arg39, int arg40) {
        PopupProperties v6_1;
        long v4_1;
        Companion v3_1;
        long v12;
        Composer v23;
        Companion v11_1;
        Function3 v14_1;
        int v7;
        int v6;
        Modifier v5;
        int v3;
        Function0 v10;
        boolean v9;
        int v2;
        int v8 = arg39;
        Composer v1 = arg38.startRestartGroup(0x67F65BDD);
        ComposerKt.sourceInformation(v1, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,properties,content)163@6066L21,158@5902L252:AndroidMenu.android.kt#uh7d8r");
        if((arg40 & 1) != 0) {
            v2 = v8 | 6;
            v9 = arg31;
        }
        else {
            v9 = arg31;
            if((v8 & 6) == 0) {
                v2 = v1.changed(v9) ? 4 : 2;
                v2 |= v8;
            }
            else {
                v2 = v8;
            }
        }

        if((arg40 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg32;
        }
        else {
            v10 = arg32;
            if((v8 & 0x30) == 0) {
                v3 = v1.changedInstance(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg40 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v8 & 0x180) == 0) {
            v5 = arg33;
            v6 = v1.changed(v5) ? 0x100 : 0x80;
            v2 |= v6;
        }
        else {
        label_50:
            v5 = arg33;
        }

        v6 = arg40 & 8;
        if(v6 != 0) {
            v2 |= 0xC00;
        }
        else {
            long v11 = arg34;
            if((v8 & 0xC00) == 0) {
                v7 = v1.changed(v11) ? 0x800 : 0x400;
                v2 |= v7;
            }
        }

        v7 = arg40 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
        }
        else if((v8 & 0x6000) == 0) {
            int v14 = v1.changed(arg36) ? 0x4000 : 0x2000;
            v2 |= v14;
        }

        int v15 = 0x30000;
        if((arg40 & 0x20) != 0) {
            v2 |= v15;
            goto label_95;
        }
        else if((v8 & v15) == 0) {
            v14_1 = arg37;
            v15 = v1.changedInstance(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_95:
            v14_1 = arg37;
        }

        int v38 = 0x20;
        boolean v4 = (74899 & v2) != 74898 ? true : false;
        if(v1.shouldExecute(v4, v2 & 1)) {
            if(v3 != 0) {
                v11_1 = Modifier.Companion;
            }
            else {
                Modifier v11_2 = v5;
            }

            if(v6 != 0) {
                v23 = v1;
                v12 = DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(0f)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(Dp.constructor-impl(0f)))) << v38);
            }
            else {
                v23 = v1;
                v12 = arg34;
            }

            PopupProperties v15_1 = v7 != 0 ? new PopupProperties(true, false, false, false, 14, null) : arg36;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x67F65BDD, v2, -1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:158)");
            }

            ScrollState v1_1 = ScrollKt.rememberScrollState(0, v23, 0, 1);
            v23 = v23;
            AndroidMenu_androidKt.DropdownMenu-IlH_yew(v9, v10, ((Modifier)v11_1), v12, v1_1, v15_1, null, 0, 0f, 0f, null, v14_1, v23, v2 & 0x1FFE | v2 << 3 & 0x70000, v2 >> 12 & 0x70, 0x7C0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_1 = v11_1;
            v4_1 = v12;
            v6_1 = v15_1;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v6_1 = arg36;
            Modifier v3_2 = v5;
            v4_1 = arg34;
        }

        ScopeUpdateScope v10_1 = v23.endRestartGroup();
        if(v10_1 != null) {
            v10_1.updateScope(new AndroidMenu_androidKt$$ExternalSyntheticLambda3(arg31, arg32, ((Modifier)v3_1), v4_1, v6_1, arg37, v8, arg40));
        }
    }

    public static final void DropdownMenu-IlH_yew(boolean arg37, Function0 arg38, Modifier arg39, long arg40, ScrollState arg42, PopupProperties arg43, Shape arg44, long arg45, float arg47, float arg48, BorderStroke arg49, Function3 arg50, Composer arg51, int arg52, int arg53, int arg54) {
        BorderStroke v13_1;
        float v12_2;
        float v11_4;
        long v9;
        Shape v8_1;
        ScrollState v6_1;
        long v4_3;
        Composer v1_4;
        DropdownMenuPositionProvider v11_3;
        MutableTransitionState v1_3;
        Shape v29;
        BorderStroke v34;
        float v33;
        float v32;
        long v30;
        ScrollState v28;
        Companion v25_1;
        long v12_1;
        Shape v10_1;
        ScrollState v11_1;
        Modifier v3_3;
        Companion v3_2;
        int v23;
        int v22;
        int v5;
        Shape v13;
        PopupProperties v14;
        int v17;
        int v16;
        int v51;
        long v8;
        int v12;
        Modifier v11;
        int v10;
        Function0 v7;
        int v6;
        int v15 = arg52;
        int v0 = arg54;
        Composer v2 = arg51.startRestartGroup(0x66DAB59F);
        ComposerKt.sourceInformation(v2, "C(DropdownMenu)N(expanded,onDismissRequest,modifier,offset:c#ui.unit.DpOffset,scrollState,properties,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)55@2074L42:AndroidMenu.android.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v6 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v6 = v2.changed(arg37) ? 4 : 2;
            v6 |= v15;
        }
        else {
            v6 = v15;
        }

        if((v0 & 2) != 0) {
            v6 |= 0x30;
            goto label_39;
        }
        else if((v15 & 0x30) == 0) {
            v7 = arg38;
            v10 = v2.changedInstance(v7) ? 0x20 : 16;
            v6 |= v10;
        }
        else {
        label_39:
            v7 = arg38;
        }

        v10 = v0 & 4;
        if(v10 != 0) {
            v6 |= 0x180;
            goto label_54;
        }
        else if((v15 & 0x180) == 0) {
            v11 = arg39;
            v12 = v2.changed(v11) ? 0x100 : 0x80;
            v6 |= v12;
        }
        else {
        label_54:
            v11 = arg39;
        }

        v12 = v0 & 8;
        if(v12 != 0) {
            v6 |= 0xC00;
            v8 = arg40;
            v51 = 0x20;
        }
        else {
            v8 = arg40;
            v51 = 0x20;
            if((v15 & 0xC00) == 0) {
                v16 = v2.changed(v8) ? 0x800 : 0x400;
                v6 |= v16;
            }
        }

        if((v15 & 0x6000) == 0) {
            v17 = (v0 & 16) != 0 || !v2.changed(arg42) ? 0x2000 : 0x4000;
            v6 |= v17;
        }

        v17 = v0 & 0x20;
        int v18 = 0x30000;
        if(v17 != 0) {
            v6 |= v18;
            v14 = arg43;
        }
        else {
            v14 = arg43;
            if((v15 & v18) == 0) {
                int v19 = v2.changed(v14) ? 0x20000 : 0x10000;
                v6 |= v19;
            }
        }

        if((v15 & 0x180000) == 0) {
            v13 = arg44;
            int v20 = (v0 & 0x40) != 0 || !v2.changed(v13) ? 0x80000 : 0x100000;
            v6 |= v20;
        }
        else {
            v13 = arg44;
        }

        if((v15 & 0xC00000) == 0) {
            long v3 = arg45;
            v5 = (v0 & 0x80) != 0 || !v2.changed(v3) ? 0x400000 : 0x800000;
            v6 |= v5;
        }

        v5 = v0 & 0x100;
        int v21 = 0x6000000;
        if(v5 != 0) {
            v6 |= v21;
        }
        else {
            float v1 = arg47;
            if((v15 & v21) == 0) {
                v22 = v2.changed(v1) ? 0x4000000 : 0x2000000;
                v6 |= v22;
            }
        }

        int v1_1 = v0 & 0x200;
        v22 = 0x30000000;
        if(v1_1 != 0) {
            v6 |= v22;
            goto label_159;
        }
        else if((v15 & v22) == 0) {
            v22 = v1_1;
            v23 = v2.changed(arg48) ? 0x20000000 : 0x10000000;
            v6 |= v23;
        }
        else {
        label_159:
            v22 = v1_1;
        }

        v1_1 = v0 & 0x400;
        if(v1_1 != 0) {
            v16 = arg53 | 6;
            v23 = v1_1;
        }
        else if((arg53 & 6) == 0) {
            v23 = v1_1;
            v16 = v2.changed(arg49) ? 4 : 2;
            v16 |= arg53;
        }
        else {
            v23 = v1_1;
            v16 = arg53;
        }

        if((v0 & 0x800) != 0) {
            v16 |= 0x30;
        }
        else if((arg53 & 0x30) == 0) {
            v18 = v2.changedInstance(arg50) ? v51 : 16;
            v16 |= v18;
        }

        v1_1 = v16;
        v16 = v5;
        boolean v3_1 = (v6 & 306783379) != 306783378 || (v1_1 & 19) != 18 ? true : false;
        if(v2.shouldExecute(v3_1, v6 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "178@6461L21,182@6573L5,184@6621L14");
            int v24 = 0xFFFF1FFF;
            SnapshotMutationPolicy v4 = null;
            if((v15 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v10 != 0) {
                    v3_2 = Modifier.Companion;
                }
                else {
                    v3_3 = v11;
                }

                if(v12 != 0) {
                    v8 = DpOffset.constructor-impl((((long)Float.floatToRawIntBits(Dp.constructor-impl(0f)))) << v51 | (((long)Float.floatToRawIntBits(Dp.constructor-impl(0f)))) & 0xFFFFFFFFL);
                }

                if((v0 & 16) != 0) {
                    v11_1 = ScrollKt.rememberScrollState(0, v2, 0, 1);
                    v6 &= v24;
                }
                else {
                    v11_1 = arg42;
                }

                if(v17 != 0) {
                    v14 = AndroidMenu_androidKt.DefaultMenuProperties;
                }

                v12 = 6;
                if((v0 & 0x40) != 0) {
                    v10_1 = MenuDefaults.INSTANCE.getShape(v2, v12);
                    v6 &= 0xFFC7FFFF;
                }
                else {
                    v10_1 = v13;
                }

                if((v0 & 0x80) != 0) {
                    v12_1 = MenuDefaults.INSTANCE.getContainerColor(v2, v12);
                    v6 &= 0xFE3FFFFF;
                }
                else {
                    v12_1 = arg45;
                }

                float v16_1 = v16 != 0 ? MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg47;
                float v17_1 = v22 != 0 ? MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg48;
                if(v23 != 0) {
                    v25_1 = v3_2;
                    v34 = ((BorderStroke)v4);
                }
                else {
                    v34 = arg49;
                    v25_1 = v3_2;
                }

                v29 = v10_1;
                v28 = v11_1;
                v30 = v12_1;
                v32 = v16_1;
                v33 = v17_1;
            }
            else {
                v2.skipToGroupEnd();
                if((v0 & 16) != 0) {
                    v6 &= v24;
                }

                if((v0 & 0x40) != 0) {
                    v6 &= 0xFFC7FFFF;
                }

                if((v0 & 0x80) != 0) {
                    v6 &= 0xFE3FFFFF;
                }

                v28 = arg42;
                v30 = arg45;
                v32 = arg47;
                v33 = arg48;
                v34 = arg49;
                Modifier v25 = v11;
                v29 = v13;
            }

            v2.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x66DAB59F, v6, v1_1, "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:54)");
            }

            String v3_4 = "CC(remember):AndroidMenu.android.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v2, 0x1B03FC29, v3_4);
            Object v1_2 = v2.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                v18 = 0;
                v1_3 = new MutableTransitionState(Boolean.valueOf(false));
                v2.updateRememberedValue(v1_3);
            }
            else {
                v18 = 0;
            }

            ComposerKt.sourceInformationMarkerEnd(v2);
            v1_3.setTargetState(Boolean.valueOf(arg37));
            if((v1_3.getCurrentState().booleanValue()) || (v1_3.getTargetState().booleanValue())) {
                v2.startReplaceGroup(1165905588);
                ComposerKt.sourceInformation(v2, "59@2261L51,60@2348L7,62@2404L251,72@2827L494,68@2665L656");
                ComposerKt.sourceInformationMarkerStart(v2, 0x1B041392, v3_4);
                Object v10_2 = v2.rememberedValue();
                if(v10_2 == Composer.Companion.getEmpty()) {
                    MutableState v10_3 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), v4, 2, v4);
                    v2.updateRememberedValue(v10_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                ProvidableCompositionLocal v4_1 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(v2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object v4_2 = v2.consume(((CompositionLocal)v4_1));
                ComposerKt.sourceInformationMarkerEnd(v2);
                ComposerKt.sourceInformationMarkerStart(v2, 0x1B04263A, v3_4);
                if((v6 & 0x1C00) == 0x800) {
                    v18 = 1;
                }

                int v3_5 = v18 | v2.changed(v4_2);
                Object v11_2 = v2.rememberedValue();
                if(v3_5 != 0 || v11_2 == Composer.Companion.getEmpty()) {
                    v11_3 = new DropdownMenuPositionProvider(v8, v4_2, 0, new AndroidMenu_androidKt$$ExternalSyntheticLambda0(((MutableState)v10_2)), 4, null);
                    v2.updateRememberedValue(v11_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v2);
                AndroidPopup_androidKt.Popup(v11_3, v7, v14, ComposableLambdaKt.rememberComposableLambda(0xC9502CD8, true, new AndroidMenu_androidKt$DropdownMenu$1(((Modifier)v25_1), v1_3, v10_2, v28, v29, v30, v32, v33, v34, arg50), v2, 54), v2, v6 & 0x70 | 0xC00 | v6 >> 9 & 0x380, 0);
                v1_4 = v2;
                v1_4.endReplaceGroup();
            }
            else {
                v2.startReplaceGroup(0x458E7B43);
                v2.endReplaceGroup();
                v1_4 = v2;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_3 = v8;
            v3_3 = ((Modifier)v25_1);
            v6_1 = v28;
            v8_1 = v29;
            v9 = v30;
            v11_4 = v32;
            v12_2 = v33;
            v13_1 = v34;
        }
        else {
            v1_4 = v2;
            v1_4.skipToGroupEnd();
            v6_1 = arg42;
            v12_2 = arg48;
            v4_3 = v8;
            v3_3 = v11;
            v8_1 = v13;
            v9 = arg45;
            v11_4 = arg47;
            v13_1 = arg49;
        }

        PopupProperties v7_1 = v14;
        ScopeUpdateScope v1_5 = v1_4.endRestartGroup();
        if(v1_5 != null) {
            v1_5.updateScope(new AndroidMenu_androidKt$$ExternalSyntheticLambda1(arg37, arg38, v3_3, v4_3, v6_1, v7_1, v8_1, v9, v11_4, v12_2, v13_1, arg50, v15, arg53, arg54));
        }
    }

    public static final void DropdownMenuItem(Function2 arg23, Function0 arg24, Modifier arg25, Function2 arg26, Function2 arg27, boolean arg28, MenuItemColors arg29, PaddingValues arg30, MutableInteractionSource arg31, Composer arg32, int arg33, int arg34) {
        MutableInteractionSource v9_1;
        PaddingValues v8_1;
        MenuItemColors v7_1;
        boolean v6_1;
        Function2 v5_1;
        Function2 v4_2;
        Modifier v3_2;
        Composer v21;
        MutableInteractionSource v20;
        PaddingValues v19_1;
        Companion v4_1;
        int v18;
        int v16;
        MenuItemColors v15_1;
        boolean v14_1;
        int v9;
        Function2 v8;
        int v7;
        Function2 v6;
        int v5;
        Modifier v4;
        int v3;
        Function0 v13;
        Function2 v12;
        int v2;
        int v10 = arg33;
        int v11 = arg34;
        Composer v1 = arg32.startRestartGroup(0xE03BB073);
        ComposerKt.sourceInformation(v1, "C(DropdownMenuItem)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)180@6512L319:AndroidMenu.android.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v2 = v10 | 6;
            v12 = arg23;
        }
        else {
            v12 = arg23;
            if((v10 & 6) == 0) {
                v2 = v1.changedInstance(v12) ? 4 : 2;
                v2 |= v10;
            }
            else {
                v2 = v10;
            }
        }

        if((v11 & 2) != 0) {
            v2 |= 0x30;
            v13 = arg24;
        }
        else {
            v13 = arg24;
            if((v10 & 0x30) == 0) {
                v3 = v1.changedInstance(v13) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = v11 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_51;
        }
        else if((v10 & 0x180) == 0) {
            v4 = arg25;
            v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_51:
            v4 = arg25;
        }

        v5 = v11 & 8;
        if(v5 != 0) {
            v2 |= 0xC00;
            goto label_66;
        }
        else if((v10 & 0xC00) == 0) {
            v6 = arg26;
            v7 = v1.changedInstance(v6) ? 0x800 : 0x400;
            v2 |= v7;
        }
        else {
        label_66:
            v6 = arg26;
        }

        v7 = v11 & 16;
        if(v7 != 0) {
            v2 |= 0x6000;
            goto label_81;
        }
        else if((v10 & 0x6000) == 0) {
            v8 = arg27;
            v9 = v1.changedInstance(v8) ? 0x4000 : 0x2000;
            v2 |= v9;
        }
        else {
        label_81:
            v8 = arg27;
        }

        v9 = v11 & 0x20;
        int v14 = 0x30000;
        if(v9 != 0) {
            v2 |= v14;
            goto label_97;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg28;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_97:
            v14_1 = arg28;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v15_1 = arg29;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v15_1 = arg29;
            label_109:
                v16 = 0x80000;
            }

            v2 |= v16;
        }
        else {
            v15_1 = arg29;
        }

        int v0 = v11 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v2 |= v17;
            goto label_129;
        }
        else if((v10 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg30) ? 0x800000 : 0x400000;
            v2 |= v18;
        }
        else {
        label_129:
            v17 = v0;
        }

        v0 = v11 & 0x100;
        v18 = 0x6000000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_147;
        }
        else if((v10 & v18) == 0) {
            v18 = v0;
            int v19 = v1.changed(arg31) ? 0x4000000 : 0x2000000;
            v2 |= v19;
        }
        else {
        label_147:
            v18 = v0;
        }

        int v32 = v2;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v32 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "194@8776L12");
            v2 = 0xFFC7FFFF;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v4_1 = Modifier.Companion;
                }

                Function2 v0_2 = null;
                if(v5 != 0) {
                    v6 = v0_2;
                }

                if(v7 != 0) {
                    v8 = v0_2;
                }

                if(v9 != 0) {
                    v14_1 = true;
                }

                if((v11 & 0x40) != 0) {
                    v2 &= v32;
                    v15_1 = MenuDefaults.INSTANCE.itemColors(v1, 6);
                }
                else {
                    v2 = v32;
                }

                PaddingValues v3_1 = v17 != 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : arg30;
                v20 = v18 != 0 ? ((MutableInteractionSource)v0_2) : arg31;
                v19_1 = v3_1;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 0x40) != 0) {
                    v2 &= v32;
                    v19_1 = arg30;
                    v20 = arg31;
                }
                else {
                    v19_1 = arg30;
                    v20 = arg31;
                    v2 = v32;
                }
            }

            Function2 v16_1 = v8;
            boolean v17_1 = v14_1;
            MenuItemColors v18_1 = v15_1;
            v0 = 0xE03BB073;
            Modifier v14_2 = ((Modifier)v4_1);
            Function2 v15_2 = v6;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:179)");
            }

            v21 = v1;
            MenuKt.DropdownMenuItemContent(v12, v13, v14_2, v15_2, v16_1, v17_1, v18_1, v19_1, v20, v21, v2 & 0xFFFFFFE);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v14_2;
            v4_2 = v15_2;
            v5_1 = v16_1;
            v6_1 = v17_1;
            v7_1 = v18_1;
            v8_1 = v19_1;
            v9_1 = v20;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v9_1 = arg31;
            v3_2 = v4;
            v4_2 = v6;
            v5_1 = v8;
            v6_1 = v14_1;
            v7_1 = v15_1;
            v8_1 = arg30;
        }

        ScopeUpdateScope v12_1 = v21.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new AndroidMenu_androidKt$$ExternalSyntheticLambda2(arg23, arg24, v3_2, v4_2, v5_1, v6_1, v7_1, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit DropdownMenuItem$lambda$7(Function2 arg13, Function0 arg14, Modifier arg15, Function2 arg16, Function2 arg17, boolean arg18, MenuItemColors arg19, PaddingValues arg20, MutableInteractionSource arg21, int arg22, int arg23, Composer arg24, int arg25) {
        AndroidMenu_androidKt.DropdownMenuItem(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_4kj__NE$lambda$5(boolean arg12, Function0 arg13, Modifier arg14, long arg15, ScrollState arg17, PopupProperties arg18, Function3 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        AndroidMenu_androidKt.DropdownMenu-4kj-_NE(arg12, arg13, arg14, arg15, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_ILWXrKs$lambda$6(boolean arg11, Function0 arg12, Modifier arg13, long arg14, PopupProperties arg16, Function3 arg17, int arg18, int arg19, Composer arg20, int arg21) {
        AndroidMenu_androidKt.DropdownMenu-ILWXrKs(arg11, arg12, arg13, arg14, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_IlH_yew$lambda$3$lambda$2(MutableState arg0, IntRect arg1, IntRect arg2) {
        arg0.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(arg1, arg2)));
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenu_IlH_yew$lambda$4(boolean arg19, Function0 arg20, Modifier arg21, long arg22, ScrollState arg24, PopupProperties arg25, Shape arg26, long arg27, float arg29, float arg30, BorderStroke arg31, Function3 arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        AndroidMenu_androidKt.DropdownMenu-IlH_yew(arg19, arg20, arg21, arg22, arg24, arg25, arg26, arg27, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    public static final PopupProperties getDefaultMenuProperties() {
        return AndroidMenu_androidKt.DefaultMenuProperties;
    }
}

