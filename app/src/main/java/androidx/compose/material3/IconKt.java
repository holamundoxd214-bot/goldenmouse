package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000E\u001A5\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u0011\u001A3\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\u00122\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0013\u001A\u0014\u0010\u0014\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0010H\u0002\u001A\u0013\u0010\u0015\u001A\u00020\u0016*\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u000E\u0010\u001A\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Icon", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/graphics/ColorProducer;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/ColorProducer;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "DefaultIconSizeModifier", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class IconKt {
    private static final Modifier DefaultIconSizeModifier;

    static {
        IconKt.DefaultIconSizeModifier = SizeKt.size-3ABfNKs(Modifier.Companion, SmallIconButtonTokens.INSTANCE.getIconSize-D9Ej5fM());
    }

    public static final void Icon(Painter arg14, ColorProducer arg15, String arg16, Modifier arg17, Composer arg18, int arg19, int arg20) {
        IconKt$$ExternalSyntheticLambda1 v4_2;
        Companion v2_1;
        Modifier v4;
        String v3;
        int v2;
        int v1;
        int v5 = arg19;
        int v0 = 1755070997;
        Composer v11 = arg18.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(Icon)N(painter,tint,contentDescription,modifier)195@9038L311,190@8868L488:Icon.kt#uh7d8r");
        if((arg20 & 1) != 0) {
            v1 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            v1 = v11.changedInstance(arg14) ? 4 : 2;
            v1 |= v5;
        }
        else {
            v1 = v5;
        }

        if((arg20 & 2) != 0) {
            v1 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            v2 = v11.changedInstance(arg15) ? 0x20 : 16;
            v1 |= v2;
        }

        if((arg20 & 4) != 0) {
            v1 |= 0x180;
            v3 = arg16;
        }
        else {
            v3 = arg16;
            if((v5 & 0x180) == 0) {
                v2 = v11.changed(v3) ? 0x100 : 0x80;
                v1 |= v2;
            }
        }

        v2 = arg20 & 8;
        if(v2 != 0) {
            v1 |= 0xC00;
            goto label_60;
        }
        else if((v5 & 0xC00) == 0) {
            v4 = arg17;
            int v6 = v11.changed(v4) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_60:
            v4 = arg17;
        }

        boolean v6_1 = (v1 & 0x493) != 1170 ? true : false;
        if(v11.shouldExecute(v6_1, v1 & 1)) {
            if(v2 != 0) {
                v2_1 = Modifier.Companion;
            }
            else {
                Modifier v2_2 = v4;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.Icon (Icon.kt:189)");
            }

            long v9 = Color.Companion.getUnspecified-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(v11, -1298908788, "CC(remember):Icon.kt#9igjgp");
            boolean v0_1 = v11.changedInstance(arg15);
            Object v4_1 = v11.rememberedValue();
            if((v0_1) || v4_1 == Composer.Companion.getEmpty()) {
                v4_2 = new IconKt$$ExternalSyntheticLambda1(arg15);
                v11.updateRememberedValue(v4_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            IconKt.Icon-ww6aTOc(arg14, v3, DrawModifierKt.drawWithCache(((Modifier)v2_1), ((Function1)v4_2)), v9, v11, v1 & 14 | 0xC00 | v1 >> 3 & 0x70, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v4_3 = v2_1;
        }
        else {
            v11.skipToGroupEnd();
        }

        ScopeUpdateScope v7 = v11.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new IconKt$$ExternalSyntheticLambda2(arg14, arg15, arg16, v4, v5, arg20));
        }
    }

    static final DrawResult Icon$lambda$12$lambda$11(ColorProducer arg9, CacheDrawScope arg10) {
        GraphicsLayer v1 = arg10.obtainGraphicsLayer();
        CacheDrawScope v0 = arg10;
        CacheDrawScope.record-TdoYBX4$default(v0, v1, null, null, 0, new IconKt$$ExternalSyntheticLambda4(), 7, null);
        if(arg9 != null) {
            v1.setColorFilter(androidx.compose.ui.graphics.ColorFilter$Companion.tint-xETnrds$default(ColorFilter.Companion, arg9.invoke-0d7_KjU(), 0, 2, null));
        }

        return v0.onDrawWithContent(new IconKt$$ExternalSyntheticLambda5(v1));
    }

    static final Unit Icon$lambda$12$lambda$11$lambda$10(GraphicsLayer arg0, ContentDrawScope arg1) {
        GraphicsLayerKt.drawLayer(((DrawScope)arg1), arg0);
        return Unit.INSTANCE;
    }

    static final Unit Icon$lambda$12$lambda$11$lambda$9$lambda$7(ContentDrawScope arg0) {
        arg0.drawContent();
        return Unit.INSTANCE;
    }

    static final Unit Icon$lambda$13(Painter arg7, ColorProducer arg8, String arg9, Modifier arg10, int arg11, int arg12, Composer arg13, int arg14) {
        IconKt.Icon(arg7, arg8, arg9, arg10, arg13, RecomposeScopeImplKt.updateChangedFlags(arg11 | 1), arg12);
        return Unit.INSTANCE;
    }

    public static final void Icon-ww6aTOc(ImageVector arg15, String arg16, Modifier arg17, long arg18, Composer arg20, int arg21, int arg22) {
        Modifier v9;
        long v10;
        Companion v9_1;
        Companion v2_1;
        int v7;
        long v4_1;
        Modifier v3;
        int v2;
        String v8;
        int v1;
        int v6 = arg21;
        int v0 = 0xF86FCC34;
        Composer v12 = arg20.startRestartGroup(v0);
        ComposerKt.sourceInformation(v12, "C(Icon)N(imageVector,contentDescription,modifier,tint:c#ui.graphics.Color)71@3410L34,70@3386L164:Icon.kt#uh7d8r");
        if((arg22 & 1) != 0) {
            v1 = v6 | 6;
        }
        else if((v6 & 6) == 0) {
            v1 = v12.changed(arg15) ? 4 : 2;
            v1 |= v6;
        }
        else {
            v1 = v6;
        }

        if((arg22 & 2) != 0) {
            v1 |= 0x30;
            v8 = arg16;
        }
        else {
            v8 = arg16;
            if((v6 & 0x30) == 0) {
                v2 = v12.changed(v8) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = arg22 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_48;
        }
        else if((v6 & 0x180) == 0) {
            v3 = arg17;
            int v4 = v12.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_48:
            v3 = arg17;
        }

        if((v6 & 0xC00) == 0) {
            if((arg22 & 8) == 0) {
                v4_1 = arg18;
                if(v12.changed(v4_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_59;
                }
            }
            else {
                v4_1 = arg18;
            label_59:
                v7 = 0x400;
            }

            v1 |= v7;
        }
        else {
            v4_1 = arg18;
        }

        boolean v7_1 = (v1 & 0x493) != 1170 ? true : false;
        if(v12.shouldExecute(v7_1, v1 & 1)) {
            v12.startDefaults();
            ComposerKt.sourceInformation(v12, "68@3369L7");
            if((v6 & 1) == 0 || (v12.getDefaultsInvalid())) {
                if(v2 != 0) {
                    v2_1 = Modifier.Companion;
                }
                else {
                    Modifier v2_2 = v3;
                }

                if((arg22 & 8) != 0) {
                    ProvidableCompositionLocal v3_1 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v12, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v3_2 = v12.consume(((CompositionLocal)v3_1));
                    ComposerKt.sourceInformationMarkerEnd(v12);
                    v1 &= 0xFFFFE3FF;
                    v9_1 = v2_1;
                    v10 = ((Color)v3_2).unbox-impl();
                    goto label_105;
                }

                v9_1 = v2_1;
            label_104:
                v10 = v4_1;
            }
            else {
                v12.skipToGroupEnd();
                if((arg22 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                v9 = v3;
                goto label_104;
            }

        label_105:
            v12.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.Icon (Icon.kt:69)");
            }

            IconKt.Icon-ww6aTOc(VectorPainterKt.rememberVectorPainter(arg15, v12, v1 & 14), v8, v9, v10, v12, VectorPainter.$stable | v1 & 0x70 | v1 & 0x380 | v1 & 0x1C00, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3 = v9;
            v4_1 = v10;
        }
        else {
            v12.skipToGroupEnd();
        }

        ScopeUpdateScope v8_1 = v12.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new IconKt$$ExternalSyntheticLambda0(arg15, arg16, v3, v4_1, v6, arg22));
        }
    }

    public static final void Icon-ww6aTOc(Painter arg24, String arg25, Modifier arg26, long arg27, Composer arg29, int arg30, int arg31) {
        long v4_1;
        IconKt$$ExternalSyntheticLambda6 v3_5;
        Companion v0_3;
        Object v0_1;
        long v17;
        long v5_1;
        Modifier v12_1;
        Modifier v3_2;
        Companion v3_1;
        long v12;
        int v6;
        Modifier v5;
        int v3;
        int v2;
        Painter v1 = arg24;
        String v9 = arg25;
        int v10 = arg30;
        int v0 = 0x80500507;
        Composer v11 = arg29.startRestartGroup(v0);
        ComposerKt.sourceInformation(v11, "C(Icon)N(painter,contentDescription,modifier,tint:c#ui.graphics.Color)144@6871L82,154@7215L217:Icon.kt#uh7d8r");
        if((arg31 & 1) != 0) {
            v2 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v2 = v11.changedInstance(v1) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        int v4 = 0x20;
        if((arg31 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v3 = v11.changed(v9) ? v4 : 16;
            v2 |= v3;
        }

        v3 = arg31 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_49;
        }
        else if((v10 & 0x180) == 0) {
            v5 = arg26;
            v6 = v11.changed(v5) ? 0x100 : 0x80;
            v2 |= v6;
        }
        else {
        label_49:
            v5 = arg26;
        }

        int v7 = 0x800;
        if((v10 & 0xC00) == 0) {
            v12 = arg27;
            v6 = (arg31 & 8) != 0 || !v11.changed(v12) ? 0x400 : v7;
            v2 |= v6;
        }
        else {
            v12 = arg27;
        }

        boolean v6_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v11.shouldExecute(v6_1, v2 & 1)) {
            v11.startDefaults();
            ComposerKt.sourceInformation(v11, "141@6828L7");
            if((v10 & 1) == 0 || (v11.getDefaultsInvalid())) {
                if(v3 != 0) {
                    v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v5;
                }

                if((arg31 & 8) != 0) {
                    ProvidableCompositionLocal v5_2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v11, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v5_3 = v11.consume(((CompositionLocal)v5_2));
                    ComposerKt.sourceInformationMarkerEnd(v11);
                    v5_1 = ((Color)v5_3).unbox-impl();
                    v2 &= 0xFFFFE3FF;
                }
                else {
                    v5_1 = v12;
                }

                Companion v12_2 = v3_1;
            }
            else {
                v11.skipToGroupEnd();
                if((arg31 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                long v22 = v12;
                v12_1 = v5;
                v5_1 = v22;
            }

            v11.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.Icon (Icon.kt:142)");
            }

            String v3_3 = "CC(remember):Icon.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v11, -1402800263, v3_3);
            v0 = (v2 & 0x1C00 ^ 0xC00) > v7 && (v11.changed(v5_1)) || (v2 & 0xC00) == v7 ? 1 : 0;
            Object v7_1 = v11.rememberedValue();
            Object v8 = null;
            if(v0 != 0 || v7_1 == Composer.Companion.getEmpty()) {
                if(Color.equals-impl0(v5_1, Color.Companion.getUnspecified-0d7_KjU())) {
                    v17 = v5_1;
                    v0_1 = v8;
                }
                else {
                    v17 = v5_1;
                    ColorFilter v0_2 = androidx.compose.ui.graphics.ColorFilter$Companion.tint-xETnrds$default(ColorFilter.Companion, v17, 0, 2, null);
                }

                v11.updateRememberedValue(v0_1);
            }
            else {
                v17 = v5_1;
                v0_1 = v7_1;
            }

            Object v6_2 = v0_1;
            ComposerKt.sourceInformationMarkerEnd(v11);
            if(v9 != null) {
                v11.startReplaceGroup(0xDFFE2AFD);
                ComposerKt.sourceInformation(v11, "147@7047L115");
                v0_3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v11, 0xAC630D9A, v3_3);
                v2 = (v2 & 0x70) == v4 ? 1 : 0;
                Object v3_4 = v11.rememberedValue();
                if(v2 != 0 || v3_4 == Composer.Companion.getEmpty()) {
                    v3_5 = new IconKt$$ExternalSyntheticLambda6(v9);
                    v11.updateRememberedValue(v3_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v11);
                Modifier v0_4 = SemanticsModifierKt.semantics$default(((Modifier)v0_3), false, ((Function1)v3_5), 1, v8);
                v11.endReplaceGroup();
            }
            else {
                v11.startReplaceGroup(0xE000973B);
                v11.endReplaceGroup();
                v0_3 = Modifier.Companion;
            }

            BoxKt.Box(PainterModifierKt.paint$default(IconKt.defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(v12_1), v1), v1, false, null, ContentScale.Companion.getFit(), 0f, ((ColorFilter)v6_2), 22, null).then(((Modifier)v0_3)), v11, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v12_1;
            v4_1 = v17;
        }
        else {
            v11.skipToGroupEnd();
            v3_2 = v5;
            v4_1 = v12;
        }

        ScopeUpdateScope v8_1 = v11.endRestartGroup();
        if(v8_1 != null) {
            v8_1.updateScope(new IconKt$$ExternalSyntheticLambda7(arg24, v9, v3_2, v4_1, v10, arg31));
        }
    }

    public static final void Icon-ww6aTOc(ImageBitmap arg17, String arg18, Modifier arg19, long arg20, Composer arg22, int arg23, int arg24) {
        long v4_3;
        BitmapPainter v2_2;
        Modifier v11;
        int v9;
        long v12;
        Companion v11_1;
        Modifier v3_2;
        int v7;
        long v5_1;
        Modifier v4;
        int v3;
        String v10;
        int v2;
        ImageBitmap v1 = arg17;
        int v8 = arg23;
        int v0 = -1092052280;
        Composer v14 = arg22.startRestartGroup(v0);
        ComposerKt.sourceInformation(v14, "C(Icon)N(bitmap,contentDescription,modifier,tint:c#ui.graphics.Color)106@5114L42,107@5161L137:Icon.kt#uh7d8r");
        if((arg24 & 1) != 0) {
            v2 = v8 | 6;
        }
        else if((v8 & 6) == 0) {
            v2 = v14.changedInstance(v1) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        if((arg24 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg18;
        }
        else {
            v10 = arg18;
            if((v8 & 0x30) == 0) {
                v3 = v14.changed(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        v3 = arg24 & 4;
        if(v3 != 0) {
            v2 |= 0x180;
            goto label_49;
        }
        else if((v8 & 0x180) == 0) {
            v4 = arg19;
            int v5 = v14.changed(v4) ? 0x100 : 0x80;
            v2 |= v5;
        }
        else {
        label_49:
            v4 = arg19;
        }

        if((v8 & 0xC00) == 0) {
            if((arg24 & 8) == 0) {
                v5_1 = arg20;
                if(v14.changed(v5_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_60;
                }
            }
            else {
                v5_1 = arg20;
            label_60:
                v7 = 0x400;
            }

            v2 |= v7;
        }
        else {
            v5_1 = arg20;
        }

        boolean v7_1 = (v2 & 0x493) != 1170 ? true : false;
        if(v14.shouldExecute(v7_1, v2 & 1)) {
            v14.startDefaults();
            ComposerKt.sourceInformation(v14, "104@5083L7");
            if((v8 & 1) == 0 || (v14.getDefaultsInvalid())) {
                if(v3 != 0) {
                    Companion v3_1 = Modifier.Companion;
                }
                else {
                    v3_2 = v4;
                }

                if((arg24 & 8) != 0) {
                    ProvidableCompositionLocal v4_1 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v14, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v4_2 = v14.consume(((CompositionLocal)v4_1));
                    ComposerKt.sourceInformationMarkerEnd(v14);
                    v9 = v2 & 0xFFFFE3FF;
                    v11_1 = ((Companion)v3_2);
                    v12 = ((Color)v4_2).unbox-impl();
                    goto label_109;
                }

                v9 = v2;
                v11_1 = ((Companion)v3_2);
            label_108:
                v12 = v5_1;
            }
            else {
                v14.skipToGroupEnd();
                if((arg24 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }

                v9 = v2;
                v11 = v4;
                goto label_108;
            }

        label_109:
            v14.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v9, -1, "androidx.compose.material3.Icon (Icon.kt:105)");
            }

            ComposerKt.sourceInformationMarkerStart(v14, -1490214990, "CC(remember):Icon.kt#9igjgp");
            boolean v0_1 = v14.changed(v1);
            Object v2_1 = v14.rememberedValue();
            if((v0_1) || v2_1 == Composer.Companion.getEmpty()) {
                BitmapPainter v0_2 = new BitmapPainter(v1, 0, 0, 6, null);
                v14.updateRememberedValue(v0_2);
                v2_2 = v0_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v14);
            IconKt.Icon-ww6aTOc(v2_2, v10, v11, v12, v14, v9 & 0x1FF0, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3_2 = v11;
            v4_3 = v12;
        }
        else {
            v14.skipToGroupEnd();
            v3_2 = v4;
            v4_3 = v5_1;
        }

        ScopeUpdateScope v9_1 = v14.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new IconKt$$ExternalSyntheticLambda3(arg17, arg18, v3_2, v4_3, v8, arg24));
        }
    }

    static final Unit Icon_ww6aTOc$lambda$0(ImageVector arg8, String arg9, Modifier arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        IconKt.Icon-ww6aTOc(arg8, arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit Icon_ww6aTOc$lambda$2(ImageBitmap arg8, String arg9, Modifier arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        IconKt.Icon-ww6aTOc(arg8, arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    static final Unit Icon_ww6aTOc$lambda$5$lambda$4(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Icon_ww6aTOc$lambda$6(Painter arg8, String arg9, Modifier arg10, long arg11, int arg13, int arg14, Composer arg15, int arg16) {
        IconKt.Icon-ww6aTOc(arg8, arg9, arg10, arg11, arg15, RecomposeScopeImplKt.updateChangedFlags(arg13 | 1), arg14);
        return Unit.INSTANCE;
    }

    private static final Modifier defaultSizeFor(Modifier arg4, Painter arg5) {
        Companion v5;
        if((Size.equals-impl0(arg5.getIntrinsicSize-NH-jbRc(), Size.Companion.getUnspecified-NH-jbRc())) || (IconKt.isInfinite-uvyYCjk(arg5.getIntrinsicSize-NH-jbRc()))) {
            Modifier v5_1 = IconKt.DefaultIconSizeModifier;
        }
        else {
            v5 = Modifier.Companion;
        }

        return arg4.then(((Modifier)v5));
    }

    private static final boolean isInfinite-uvyYCjk(long arg2) {
        if((Float.isInfinite(Float.intBitsToFloat(((int)(arg2 >> 0x20))))) && (Float.isInfinite(Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)))))) {
            return 1;
        }

        return 0;
    }
}

