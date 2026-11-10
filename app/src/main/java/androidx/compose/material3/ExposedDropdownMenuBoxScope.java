package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH&¢\u0006\u0004\b\n\u0010\u000BJ\u0016\u0010\f\u001A\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\tH&J\u0095\u0001\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\r\u001A\u00020\t2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020!2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\u001C\u0010%\u001A\u0018\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b*\u0010+J\f\u0010\u0004\u001A\u00020\u0005*\u00020\u0005H\u0007J\u009F\u0001\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010,\u001A\u00020\t2\b\b\u0002\u0010-\u001A\u00020\t2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020!2\n\b\u0002\u0010#\u001A\u0004\u0018\u00010$2\u001C\u0010%\u001A\u0018\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0004\b.\u0010/JU\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\t2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00150\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u00052\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\u001C\u0010%\u001A\u0018\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u00150&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u00100R\u0012\u0010\u000E\u001A\u00020\u0007X \u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0012\u0010\u0011\u001A\u00020\tX \u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\u0082\u0001\u00011¨\u00062"}, d2={"Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "", "<init>", "()V", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "exposedDropdownSize", "matchAnchorWidth", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "ExposedDropdownMenu", "", "expanded", "onDismissRequest", "Lkotlin/Function0;", "modifier", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ExposedDropdownMenu-vNxi1II", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "focusable", "matchTextFieldWidth", "ExposedDropdownMenu-kbRbctU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ExposedDropdownMenuBoxScope {
    public static final int $stable;

    static {
    }

    private ExposedDropdownMenuBoxScope() {
        super();
    }

    public ExposedDropdownMenuBoxScope(DefaultConstructorMarker arg1) {
        this();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with customization options parameters.") public final void ExposedDropdownMenu(boolean arg27, Function0 arg28, Modifier arg29, ScrollState arg30, Function3 arg31, Composer arg32, int arg33, int arg34) {
        Composer v22;
        Modifier v11_2;
        ScrollState v12;
        Companion v11_3;
        Companion v3_1;
        ExposedDropdownMenuBoxScope v8_1;
        Function3 v6_1;
        int v6;
        ScrollState v5_1;
        Modifier v4;
        int v3;
        Function0 v10;
        boolean v9;
        int v2;
        int v7 = arg33;
        int v0 = 0xA681E0AF;
        Composer v1 = arg32.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,content)436@19905L5,437@19954L14,430@19657L498:ExposedDropdownMenu.kt#uh7d8r");
        if((arg34 & 1) != 0) {
            v2 = v7 | 6;
            v9 = arg27;
        }
        else {
            v9 = arg27;
            if((v7 & 6) == 0) {
                v2 = v1.changed(v9) ? 4 : 2;
                v2 |= v7;
            }
            else {
                v2 = v7;
            }
        }

        if((arg34 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg28;
        }
        else {
            v10 = arg28;
            if((v7 & 0x30) == 0) {
                v3 = v1.changedInstance(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg34 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_50;
        }
        else if((v7 & 0x180) == 0) {
            v4 = arg29;
            int v5 = v1.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_50:
            v4 = arg29;
        }

        if((v7 & 0xC00) == 0) {
            if((arg34 & 8) == 0) {
                v5_1 = arg30;
                if(v1.changed(v5_1)) {
                    v6 = 0x800;
                }
                else {
                    goto label_61;
                }
            }
            else {
                v5_1 = arg30;
            label_61:
                v6 = 0x400;
            }

            v2 |= v6;
        }
        else {
            v5_1 = arg30;
        }

        if((arg34 & 16) != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v7 & 0x6000) == 0) {
            v6_1 = arg31;
            int v8 = v1.changedInstance(v6_1) ? 0x4000 : 0x2000;
            v2 |= v8;
        }
        else {
        label_79:
            v6_1 = arg31;
        }

        int v11 = 0x30000;
        if((arg34 & 0x20) != 0) {
            v2 |= v11;
            goto label_95;
        }
        else if((v7 & v11) == 0) {
            v8_1 = this;
            v11 = v1.changed(v8_1) ? 0x20000 : 0x10000;
            v2 |= v11;
        }
        else {
        label_95:
            v8_1 = this;
        }

        boolean v11_1 = (74899 & v2) != 74898 ? true : false;
        if(v1.shouldExecute(v11_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "427@19565L21");
            if((v7 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v3_1 = Modifier.Companion;
                }
                else {
                    Modifier v3_2 = v4;
                }

                if((arg34 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                    v11_3 = v3_1;
                    v12 = ScrollKt.rememberScrollState(0, v1, 0, 1);
                    goto label_135;
                }

                v11_3 = v3_1;
            label_134:
                v12 = v5_1;
            }
            else {
                v1.skipToGroupEnd();
                if((arg34 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v11_2 = v4;
                goto label_134;
            }

        label_135:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:430)");
            }

            v0 = v2 >> 9;
            v22 = v1;
            v8_1.ExposedDropdownMenu-kbRbctU(v9, v10, v11_2, v12, false, true, MenuDefaults.INSTANCE.getShape(v1, 6), MenuDefaults.INSTANCE.getContainerColor(v1, 6), MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM(), MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM(), null, v6_1, v22, v2 & 14 | 0x36030000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00, v0 & 0x70 | 6 | v0 & 0x380, 16);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4 = v11_2;
            v5_1 = v12;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
        }

        ScopeUpdateScope v9_1 = v22.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda0(this, arg27, arg28, v4, v5_1, arg31, v7, arg34));
        }
    }

    static final Unit ExposedDropdownMenu$lambda$9(ExposedDropdownMenuBoxScope arg10, boolean arg11, Function0 arg12, Modifier arg13, ScrollState arg14, Function3 arg15, int arg16, int arg17, Composer arg18, int arg19) {
        arg10.ExposedDropdownMenu(arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="The `focusable` parameter is unused. Pass the proper ExposedDropdownMenuAnchorType to Modifier.menuAnchor instead, which will handle focusability automatically.") public final void ExposedDropdownMenu-kbRbctU(boolean arg35, Function0 arg36, Modifier arg37, ScrollState arg38, boolean arg39, boolean arg40, Shape arg41, long arg42, float arg44, float arg45, BorderStroke arg46, Function3 arg47, Composer arg48, int arg49, int arg50, int arg51) {
        BorderStroke v13;
        float v12_1;
        float v11_2;
        long v9_2;
        Shape v8_1;
        boolean v7_1;
        ScrollState v5_1;
        Modifier v4_2;
        Composer v29;
        Shape v22_1;
        boolean v21_1;
        BorderStroke v27;
        float v26;
        float v25;
        boolean v11_1;
        ScrollState v20_1;
        Shape v6_1;
        ScrollState v0_2;
        Companion v14_1;
        int v24;
        int v23;
        long v12;
        Shape v9;
        int v18;
        boolean v6;
        int v16;
        Modifier v14;
        int v11;
        Function0 v8;
        int v7;
        int v15 = arg49;
        int v0 = arg50;
        int v1 = arg51;
        Composer v3 = arg48.startRestartGroup(0x96552261);
        ComposerKt.sourceInformation(v3, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,focusable,matchTextFieldWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)401@18683L460:ExposedDropdownMenu.kt#uh7d8r");
        if((v1 & 1) != 0) {
            v7 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            v7 = v3.changed(arg35) ? 4 : 2;
            v7 |= v15;
        }
        else {
            v7 = v15;
        }

        if((v1 & 2) != 0) {
            v7 |= 0x30;
            goto label_40;
        }
        else if((v15 & 0x30) == 0) {
            v8 = arg36;
            v11 = v3.changedInstance(v8) ? 0x20 : 16;
            v7 |= v11;
        }
        else {
        label_40:
            v8 = arg36;
        }

        v11 = v1 & 4;
        if(v11 != 0) {
            v7 |= 0x180;
            goto label_55;
        }
        else if((v15 & 0x180) == 0) {
            v14 = arg37;
            v16 = v3.changed(v14) ? 0x100 : 0x80;
            v7 |= v16;
        }
        else {
        label_55:
            v14 = arg37;
        }

        if((v15 & 0xC00) == 0) {
            v16 = (v1 & 8) != 0 || !v3.changed(arg38) ? 0x400 : 0x800;
            v7 |= v16;
        }

        v16 = v1 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v7 |= v17;
            v6 = arg40;
        }
        else {
            v6 = arg40;
            if((v15 & v17) == 0) {
                v18 = v3.changed(v6) ? 0x20000 : 0x10000;
                v7 |= v18;
            }
        }

        if((v15 & 0x180000) == 0) {
            v9 = arg41;
            int v19 = (v1 & 0x40) != 0 || !v3.changed(v9) ? 0x80000 : 0x100000;
            v7 |= v19;
        }
        else {
            v9 = arg41;
        }

        if((v15 & 0xC00000) == 0) {
            v12 = arg42;
            int v21 = (v1 & 0x80) != 0 || !v3.changed(v12) ? 0x400000 : 0x800000;
            v7 |= v21;
        }
        else {
            v12 = arg42;
        }

        int v10 = v1 & 0x100;
        int v22 = 0x6000000;
        if(v10 != 0) {
            v7 |= v22;
        }
        else {
            float v2 = arg44;
            if((v15 & v22) == 0) {
                v23 = v3.changed(v2) ? 0x4000000 : 0x2000000;
                v7 |= v23;
            }
        }

        int v2_1 = v1 & 0x200;
        v23 = 0x30000000;
        if(v2_1 != 0) {
            v7 |= v23;
            goto label_144;
        }
        else if((v15 & v23) == 0) {
            v23 = v2_1;
            v24 = v3.changed(arg45) ? 0x20000000 : 0x10000000;
            v7 |= v24;
        }
        else {
        label_144:
            v23 = v2_1;
        }

        v2_1 = v1 & 0x400;
        if(v2_1 != 0) {
            v17 = v0 | 6;
            v24 = v2_1;
        }
        else if((v0 & 6) == 0) {
            v24 = v2_1;
            v17 = v3.changed(arg46) ? 4 : 2;
            v17 |= v0;
        }
        else {
            v24 = v2_1;
            v17 = v0;
        }

        if((v1 & 0x800) != 0) {
            v17 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v18 = v3.changedInstance(arg47) ? 0x20 : 16;
            v17 |= v18;
        }

        v2_1 = v17;
        if((v1 & 0x1000) != 0) {
            v2_1 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            int v20 = v3.changed(this) ? 0x100 : 0x80;
            v2_1 |= v20;
        }

        boolean v5 = true;
        boolean v0_1 = (v7 & 0x12490493) != 0x12490492 || (v2_1 & 0x93) != 0x92 ? true : false;
        if(v3.shouldExecute(v0_1, v7 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "391@18251L21,394@18390L5,395@18442L14");
            int v4 = 0xFE3FFFFF;
            v17 = 0xFFC7FFFF;
            if((v15 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v11 != 0) {
                    v14_1 = Modifier.Companion;
                }

                if((v1 & 8) != 0) {
                    v0_2 = ScrollKt.rememberScrollState(0, v3, 0, 1);
                    v7 &= 0xFFFFE3FF;
                }
                else {
                    v0_2 = arg38;
                }

                v11_1 = (v1 & 16) != 0 ? true : arg39;
                if(v16 != 0) {
                }
                else {
                    v5 = v6;
                }

                int v48 = v4;
                v4 = 6;
                if((v1 & 0x40) != 0) {
                    v6_1 = MenuDefaults.INSTANCE.getShape(v3, v4);
                    v7 &= v17;
                }
                else {
                    v6_1 = v9;
                }

                if((v1 & 0x80) != 0) {
                    v12 = MenuDefaults.INSTANCE.getContainerColor(v3, v4);
                    v7 &= v48;
                }

                float v4_1 = v10 != 0 ? MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg44;
                float v9_1 = v23 != 0 ? MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg45;
                if(v24 != 0) {
                    v20_1 = v0_2;
                    v25 = v4_1;
                    v21_1 = v5;
                    v22_1 = v6_1;
                    v26 = v9_1;
                    v27 = null;
                    goto label_239;
                }

                v27 = arg46;
                v20_1 = v0_2;
                v25 = v4_1;
                v21_1 = v5;
                v22_1 = v6_1;
                v26 = v9_1;
            }
            else {
                v3.skipToGroupEnd();
                if((v1 & 8) != 0) {
                    v7 &= 0xFFFFE3FF;
                }

                if((v1 & 0x40) != 0) {
                    v7 &= v17;
                }

                if((v1 & 0x80) != 0) {
                    v7 &= v4;
                }

                v20_1 = arg38;
                v11_1 = arg39;
                v25 = arg44;
                v26 = arg45;
                v27 = arg46;
                v21_1 = v6;
                v22_1 = v9;
            }

        label_239:
            long v23_1 = v12;
            Modifier v19_1 = ((Modifier)v14_1);
            v0 = 0x96552261;
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v7, v2_1, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:401)");
            }

            v4 = v7 >> 3;
            v29 = v3;
            this.ExposedDropdownMenu-vNxi1II(arg35, v8, v19_1, v20_1, v21_1, v22_1, v23_1, v25, v26, v27, arg47, v29, v7 & 0x1FFE | 0xE000 & v4 | 0x70000 & v4 | 0x380000 & v4 | 0x1C00000 & v4 | v4 & 0xE000000 | v2_1 << 27 & 0x70000000, v2_1 >> 3 & 0x7E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6 = v11_1;
            v4_2 = v19_1;
            v5_1 = v20_1;
            v7_1 = v21_1;
            v8_1 = v22_1;
            v9_2 = v23_1;
            v11_2 = v25;
            v12_1 = v26;
            v13 = v27;
        }
        else {
            v29 = v3;
            v29.skipToGroupEnd();
            v5_1 = arg38;
            v11_2 = arg44;
            v7_1 = v6;
            v8_1 = v9;
            v9_2 = v12;
            v4_2 = v14;
            v6 = arg39;
            v12_1 = arg45;
            v13 = arg46;
        }

        ScopeUpdateScope v0_3 = v29.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda1(this, arg35, arg36, v4_2, v5_1, v6, v7_1, v8_1, v9_2, v11_2, v12_1, v13, arg47, v15, arg50, v1));
        }
    }

    public final void ExposedDropdownMenu-vNxi1II(boolean arg37, Function0 arg38, Modifier arg39, ScrollState arg40, boolean arg41, Shape arg42, long arg43, float arg45, float arg46, BorderStroke arg47, Function3 arg48, Composer arg49, int arg50, int arg51, int arg52) {
        BorderStroke v12_3;
        float v11_2;
        float v10_4;
        Shape v7_1;
        ScrollState v5_1;
        boolean v6_4;
        Modifier v4_1;
        Composer v0_3;
        ExposedDropdownMenuPositionProvider v10_3;
        MutableState v9_2;
        ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2 v9_1;
        Object v9;
        ScrollState v27;
        Modifier v23;
        long v29;
        BorderStroke v33;
        float v32;
        float v31;
        Shape v28;
        boolean v24;
        Companion v23_1;
        Shape v10_1;
        ScrollState v11_1;
        Modifier v1_4;
        int v21;
        int v20;
        int v19;
        long v8;
        int v16;
        boolean v15;
        int v13;
        ScrollState v12_1;
        Modifier v11;
        int v10;
        Function0 v7;
        int v4;
        boolean v2 = arg37;
        int v14 = arg50;
        int v0 = arg52;
        Composer v3 = arg49.startRestartGroup(0xF870723D);
        ComposerKt.sourceInformation(v3, "C(ExposedDropdownMenu)N(expanded,onDismissRequest,modifier,scrollState,matchAnchorWidth,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)324@15347L53,325@15436L7,326@15487L10,333@15744L42:ExposedDropdownMenu.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v4 = v14 | 6;
        }
        else if((v14 & 6) == 0) {
            v4 = v3.changed(v2) ? 4 : 2;
            v4 |= v14;
        }
        else {
            v4 = v14;
        }

        if((v0 & 2) != 0) {
            v4 |= 0x30;
            goto label_36;
        }
        else if((v14 & 0x30) == 0) {
            v7 = arg38;
            v10 = v3.changedInstance(v7) ? 0x20 : 16;
            v4 |= v10;
        }
        else {
        label_36:
            v7 = arg38;
        }

        v10 = v0 & 4;
        if(v10 != 0) {
            v4 |= 0x180;
            goto label_51;
        }
        else if((v14 & 0x180) == 0) {
            v11 = arg39;
            int v12 = v3.changed(v11) ? 0x100 : 0x80;
            v4 |= v12;
        }
        else {
        label_51:
            v11 = arg39;
        }

        if((v14 & 0xC00) == 0) {
            if((v0 & 8) == 0) {
                v12_1 = arg40;
                if(v3.changed(v12_1)) {
                    v13 = 0x800;
                }
                else {
                    goto label_62;
                }
            }
            else {
                v12_1 = arg40;
            label_62:
                v13 = 0x400;
            }

            v4 |= v13;
        }
        else {
            v12_1 = arg40;
        }

        v13 = v0 & 16;
        if(v13 != 0) {
            v4 |= 0x6000;
            goto label_80;
        }
        else if((v14 & 0x6000) == 0) {
            v15 = arg41;
            v16 = v3.changed(v15) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
        label_80:
            v15 = arg41;
        }

        if((v14 & 0x30000) == 0) {
            Shape v5 = arg42;
            v16 = (v0 & 0x20) != 0 || !v3.changed(v5) ? 0x10000 : 0x20000;
            v4 |= v16;
        }

        if((v14 & 0x180000) == 0) {
            v8 = arg43;
            int v17 = (v0 & 0x40) != 0 || !v3.changed(v8) ? 0x80000 : 0x100000;
            v4 |= v17;
        }
        else {
            v8 = arg43;
        }

        int v6 = v0 & 0x80;
        int v18 = 0xC00000;
        if(v6 != 0) {
            v4 |= v18;
        }
        else {
            float v1 = arg45;
            if((v14 & v18) == 0) {
                v19 = v3.changed(v1) ? 0x800000 : 0x400000;
                v4 |= v19;
            }
        }

        int v1_1 = v0 & 0x100;
        v19 = 0x6000000;
        if(v1_1 != 0) {
            v4 |= v19;
            goto label_140;
        }
        else if((v14 & v19) == 0) {
            v19 = v1_1;
            v20 = v3.changed(arg46) ? 0x4000000 : 0x2000000;
            v4 |= v20;
        }
        else {
        label_140:
            v19 = v1_1;
        }

        v1_1 = v0 & 0x200;
        v20 = 0x30000000;
        if(v1_1 != 0) {
            v4 |= v20;
            goto label_158;
        }
        else if((v14 & v20) == 0) {
            v20 = v1_1;
            v21 = v3.changed(arg47) ? 0x20000000 : 0x10000000;
            v4 |= v21;
        }
        else {
        label_158:
            v20 = v1_1;
        }

        if((v0 & 0x400) != 0) {
            v21 = arg51 | 6;
        }
        else if((arg51 & 6) == 0) {
            v21 = v3.changedInstance(arg48) ? 4 : 2;
            v21 |= arg51;
        }
        else {
            v21 = arg51;
        }

        if((v0 & 0x800) != 0) {
            v21 |= 0x30;
        }
        else if((arg51 & 0x30) == 0) {
            v16 = v3.changed(this) ? 0x20 : 16;
            v21 |= v16;
        }

        v0 = v21;
        boolean v1_2 = (v4 & 306783379) != 306783378 || (v0 & 19) != 18 ? true : false;
        if(v3.shouldExecute(v1_2, v4 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "313@14737L21,315@14838L5,316@14890L14");
            int v2_1 = 6;
            if((v14 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v10 != 0) {
                    Companion v1_3 = Modifier.Companion;
                }
                else {
                    v1_4 = v11;
                }

                if((arg52 & 8) != 0) {
                    v11_1 = ScrollKt.rememberScrollState(0, v3, 0, 1);
                    v4 &= 0xFFFFE3FF;
                }
                else {
                    v11_1 = v12_1;
                }

                if(v13 != 0) {
                    v15 = true;
                }

                if((arg52 & 0x20) != 0) {
                    v10_1 = MenuDefaults.INSTANCE.getShape(v3, v2_1);
                    v4 &= 0xFFF8FFFF;
                }
                else {
                    v10_1 = arg42;
                }

                if((arg52 & 0x40) != 0) {
                    v8 = MenuDefaults.INSTANCE.getContainerColor(v3, v2_1);
                    v4 &= 0xFFC7FFFF;
                }

                float v6_1 = v6 != 0 ? MenuDefaults.INSTANCE.getTonalElevation-D9Ej5fM() : arg45;
                float v12_2 = v19 != 0 ? MenuDefaults.INSTANCE.getShadowElevation-D9Ej5fM() : arg46;
                if(v20 != 0) {
                    v23_1 = ((Companion)v1_4);
                    v31 = v6_1;
                    v29 = v8;
                    v28 = v10_1;
                    v27 = v11_1;
                    v32 = v12_2;
                    v24 = v15;
                    v33 = null;
                    goto label_294;
                }

                v33 = arg47;
                v23_1 = ((Companion)v1_4);
                v31 = v6_1;
                v29 = v8;
                v28 = v10_1;
                v27 = v11_1;
                v32 = v12_2;
            label_237:
                v24 = v15;
            }
            else {
                v3.skipToGroupEnd();
                if((arg52 & 8) != 0) {
                    v4 &= 0xFFFFE3FF;
                }

                if((arg52 & 0x20) != 0) {
                    v4 &= 0xFFF8FFFF;
                }

                if((arg52 & 0x40) != 0) {
                    v4 &= 0xFFC7FFFF;
                }

                v28 = arg42;
                v31 = arg45;
                v32 = arg46;
                v33 = arg47;
                v29 = v8;
                v23 = v11;
                v27 = v12_1;
                goto label_237;
            }

        label_294:
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF870723D, v4, v0, "androidx.compose.material3.ExposedDropdownMenuBoxScope.ExposedDropdownMenu (ExposedDropdownMenu.kt:321)");
            }

            String v1_5 = "CC(remember):ExposedDropdownMenu.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, 0x9E1D39F2, v1_5);
            Object v0_1 = v3.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                MutableState v0_2 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                v3.updateRememberedValue(v0_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ProvidableCompositionLocal v6_2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v6_3 = v3.consume(((CompositionLocal)v6_2));
            ComposerKt.sourceInformationMarkerEnd(v3);
            int v8_1 = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, v3, v2_1).getTop(((Density)v6_3));
            if(arg37) {
                v3.startReplaceGroup(629991660);
                ComposerKt.sourceInformation(v3, "329@15580L36,329@15551L65");
                ComposerKt.sourceInformationMarkerStart(v3, 0x9E1D5701, v1_5);
                v9 = v3.rememberedValue();
                if(v9 == Composer.Companion.getEmpty()) {
                    v9_1 = new ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda2(((MutableState)v0_1));
                    v3.updateRememberedValue(v9_1);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                ExposedDropdownMenu_androidKt.OnPlatformWindowBoundsChange(((Function0)v9_1), v3, v2_1);
                v3.endReplaceGroup();
            }
            else {
                v3.startReplaceGroup(630077189);
                v3.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v3, -1642239097, v1_5);
            Object v2_2 = v3.rememberedValue();
            if(v2_2 == Composer.Companion.getEmpty()) {
                MutableTransitionState v2_3 = new MutableTransitionState(Boolean.valueOf(false));
                v3.updateRememberedValue(v2_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v3);
            ((MutableTransitionState)v2_2).setTargetState(Boolean.valueOf(arg37));
            if((((MutableTransitionState)v2_2).getCurrentState().booleanValue()) || (((MutableTransitionState)v2_2).getTargetState().booleanValue())) {
                v3.startReplaceGroup(630396489);
                ComposerKt.sourceInformation(v3, "337@15943L51,339@16051L486,353@16703L57,354@16776L584,350@16551L809");
                ComposerKt.sourceInformationMarkerStart(v3, 0x9E1D8470, v1_5);
                v9 = v3.rememberedValue();
                if(v9 == Composer.Companion.getEmpty()) {
                    v9_2 = SnapshotStateKt.mutableStateOf$default(TransformOrigin.box-impl(TransformOrigin.Companion.getCenter-SzJe1aQ()), null, 2, null);
                    v3.updateRememberedValue(v9_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                ComposerKt.sourceInformationMarkerStart(v3, 0x9E1D93A3, v1_5);
                v1_1 = v3.changed(v6_3) | v3.changed(v8_1);
                Object v10_2 = v3.rememberedValue();
                if(v1_1 != 0 || v10_2 == Composer.Companion.getEmpty()) {
                    v10_3 = new ExposedDropdownMenuPositionProvider(v6_3, v8_1, v0_1, 0, new ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda3(v9_2), 8, null);
                    v3.updateRememberedValue(v10_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                AndroidPopup_androidKt.Popup(v10_3, v7, ExposedDropdownMenu_androidKt.popupPropertiesForAnchorType-BTG8-q0(this.getAnchorType-oYjWRB4$material3(), this.getAlwaysFocusable$material3(), v3, 0), ComposableLambdaKt.rememberComposableLambda(0x7AF8B32D, true, new ExposedDropdownMenuBoxScope$ExposedDropdownMenu$2(this, v23, v24, v2_2, v9_2, v27, v28, v29, v31, v32, v33, arg48), v3, 54), v3, v4 & 0x70 | 0xC00, 0);
                v0_3 = v3;
                v0_3.endReplaceGroup();
            }
            else {
                v3.startReplaceGroup(0x25A89D05);
                v3.endReplaceGroup();
                v0_3 = v3;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v23;
            v6_4 = v24;
            v5_1 = v27;
            v7_1 = v28;
            v8 = v29;
            v10_4 = v31;
            v11_2 = v32;
            v12_3 = v33;
        }
        else {
            v0_3 = v3;
            v0_3.skipToGroupEnd();
            v7_1 = arg42;
            v10_4 = arg45;
            v4_1 = v11;
            v5_1 = v12_1;
            v6_4 = v15;
            v11_2 = arg46;
            v12_3 = arg47;
        }

        ScopeUpdateScope v0_4 = v0_3.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new ExposedDropdownMenuBoxScope$$ExternalSyntheticLambda4(this, arg37, arg38, v4_1, v5_1, v6_4, v7_1, v8, v10_4, v11_2, v12_3, arg48, v14, arg51, arg52));
        }
    }

    static final Unit ExposedDropdownMenu_kbRbctU$lambda$8(ExposedDropdownMenuBoxScope arg19, boolean arg20, Function0 arg21, Modifier arg22, ScrollState arg23, boolean arg24, boolean arg25, Shape arg26, long arg27, float arg29, float arg30, BorderStroke arg31, Function3 arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        arg19.ExposedDropdownMenu-kbRbctU(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$2$lambda$1(MutableState arg1) {
        arg1.setValue(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$6$lambda$5(MutableState arg0, IntRect arg1, IntRect arg2) {
        arg0.setValue(TransformOrigin.box-impl(MenuKt.calculateTransformOrigin(arg1, arg2)));
        return Unit.INSTANCE;
    }

    static final Unit ExposedDropdownMenu_vNxi1II$lambda$7(ExposedDropdownMenuBoxScope arg18, boolean arg19, Function0 arg20, Modifier arg21, ScrollState arg22, boolean arg23, Shape arg24, long arg25, float arg27, float arg28, BorderStroke arg29, Function3 arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        arg18.ExposedDropdownMenu-vNxi1II(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg27, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    public abstract Modifier exposedDropdownSize(Modifier arg1, boolean arg2);

    public static Modifier exposedDropdownSize$default(ExposedDropdownMenuBoxScope arg0, Modifier arg1, boolean arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.exposedDropdownSize(arg1, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exposedDropdownSize");
    }

    public abstract boolean getAlwaysFocusable$material3();

    public abstract String getAnchorType-oYjWRB4$material3();

    @Deprecated(level=DeprecationLevel.WARNING, message="Use overload that takes ExposedDropdownMenuAnchorType and enabled parameters", replaceWith="<_subannotation>") public final Modifier menuAnchor(Modifier arg8) {
        return ExposedDropdownMenuBoxScope.menuAnchor-2Hz36ac$default(this, arg8, ExposedDropdownMenuAnchorType.Companion.getPrimaryNotEditable-oYjWRB4(), false, 2, null);
    }

    public abstract Modifier menuAnchor-2Hz36ac(Modifier arg1, String arg2, boolean arg3);

    public static Modifier menuAnchor-2Hz36ac$default(ExposedDropdownMenuBoxScope arg0, Modifier arg1, String arg2, boolean arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            return arg0.menuAnchor-2Hz36ac(arg1, arg2, true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: menuAnchor-2Hz36ac");
    }
}

