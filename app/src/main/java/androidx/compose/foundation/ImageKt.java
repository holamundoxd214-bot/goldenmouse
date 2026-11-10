package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AS\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0002\u0010\u0010\u001A_\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001AS\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00162\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0002\u0010\u0017\u001AS\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0002\u0010\u001A¨\u0006\u001B"}, d2={"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ImageKt {
    public static Unit $r8$lambda$rC3fRvclEqRAZwgsmAUneyxY_iY(String arg0, SemanticsPropertyReceiver arg1) {
        return ImageKt.Image$lambda$0$0(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith="<_subannotation>") public static final void Image(ImageBitmap arg14, String arg15, Modifier arg16, Alignment arg17, ContentScale arg18, float arg19, ColorFilter arg20, Composer arg21, int arg22, int arg23) {
        Modifier v5_1;
        int v0 = arg22;
        int v2 = 0x817219FF;
        Composer v11 = arg21;
        ComposerKt.sourceInformationMarkerStart(v11, v2, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)99@4665L178:Image.kt#71ulvw");
        if((arg23 & 4) != 0) {
            Companion v5 = Modifier.Companion;
        }
        else {
            v5_1 = arg16;
        }

        Alignment v6 = (arg23 & 8) != 0 ? Alignment.Companion.getCenter() : arg17;
        ContentScale v7 = (arg23 & 16) != 0 ? ContentScale.Companion.getFit() : arg18;
        float v8 = (arg23 & 0x20) != 0 ? 1f : arg19;
        ColorFilter v9 = (arg23 & 0x40) != 0 ? null : arg20;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.foundation.Image (Image.kt:98)");
        }

        ImageKt.Image-5h-nEew(arg14, arg15, v5_1, v6, v7, v8, v9, FilterQuality.Companion.getLow-f-v9h1I(), v11, v0 & 0x3FFFFE, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg21);
    }

    public static final void Image(Painter arg17, String arg18, Modifier arg19, Alignment arg20, ContentScale arg21, float arg22, ColorFilter arg23, Composer arg24, int arg25, int arg26) {
        Companion v3_2;
        Alignment v4_2;
        ContentScale v5_2;
        float v6_3;
        ColorFilter v7_1;
        ImageKt$Image$1$1 v1_3;
        Companion v2_3;
        Companion v13_1;
        Modifier v0_2;
        Companion v0_1;
        int v15;
        float v14_1;
        int v13;
        ContentScale v12;
        int v8;
        int v6;
        Modifier v5;
        int v3;
        int v2_1;
        Painter v1 = arg17;
        String v9 = arg18;
        int v10 = arg25;
        Composer v11 = arg24.startRestartGroup(0x441D0E20);
        ComposerKt.sourceInformation(v11, "C(Image)N(painter,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)271@12440L88,260@12135L393:Image.kt#71ulvw");
        if((v10 & 6) == 0) {
            boolean v2 = (v10 & 8) == 0 ? v11.changed(v1) : v11.changedInstance(v1);
            v2_1 = v2 ? 4 : 2;
            v2_1 |= v10;
        }
        else {
            v2_1 = v10;
        }

        if((v10 & 0x30) == 0) {
            v3 = v11.changed(v9) ? 0x20 : 16;
            v2_1 |= v3;
        }

        v3 = arg26 & 4;
        if(v3 != 0) {
            v2_1 |= 0x180;
            goto label_44;
        }
        else if((v10 & 0x180) == 0) {
            v5 = arg19;
            v6 = v11.changed(v5) ? 0x100 : 0x80;
            v2_1 |= v6;
        }
        else {
        label_44:
            v5 = arg19;
        }

        v6 = arg26 & 8;
        if(v6 != 0) {
            v2_1 |= 0xC00;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = v11.changed(arg20) ? 0x800 : 0x400;
            v2_1 |= v8;
        }

        v8 = arg26 & 16;
        if(v8 != 0) {
            v2_1 |= 0x6000;
            goto label_74;
        }
        else if((v10 & 0x6000) == 0) {
            v12 = arg21;
            v13 = v11.changed(v12) ? 0x4000 : 0x2000;
            v2_1 |= v13;
        }
        else {
        label_74:
            v12 = arg21;
        }

        v13 = arg26 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v2_1 |= v14;
            goto label_90;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg22;
            v15 = v11.changed(v14_1) ? 0x20000 : 0x10000;
            v2_1 |= v15;
        }
        else {
        label_90:
            v14_1 = arg22;
        }

        v15 = arg26 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2_1 |= v16;
        }
        else {
            ColorFilter v4 = arg23;
            if((v10 & v16) == 0) {
                v16 = v11.changed(v4) ? 0x100000 : 0x80000;
                v2_1 |= v16;
            }
        }

        v16 = v3;
        boolean v0 = (v2_1 & 0x92493) != 0x92492 ? true : false;
        if(v11.shouldExecute(v0, v2_1 & 1)) {
            if(v16 != 0) {
                v0_1 = Modifier.Companion;
            }
            else {
                v0_2 = v5;
            }

            Alignment v1_1 = v6 != 0 ? Alignment.Companion.getCenter() : arg20;
            ContentScale v4_1 = v8 != 0 ? ContentScale.Companion.getFit() : v12;
            float v5_1 = v13 != 0 ? 1f : v14_1;
            Object v6_1 = null;
            ColorFilter v8_1 = v15 != 0 ? ((ColorFilter)v6_1) : arg23;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x441D0E20, v2_1, -1, "androidx.compose.foundation.Image (Image.kt:247)");
            }

            String v12_1 = "CC(remember):Image.kt#9igjgp";
            if(v9 != null) {
                v11.startReplaceGroup(0x7133D784);
                ComposerKt.sourceInformation(v11, "250@11847L115");
                v13_1 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v11, -1324207053, v12_1);
                v2_1 = (v2_1 & 0x70) == 0x20 ? 1 : 0;
                Object v14_2 = v11.rememberedValue();
                if(v2_1 != 0 || v14_2 == Composer.Companion.getEmpty()) {
                    ImageKt$$ExternalSyntheticLambda0 v14_3 = new ImageKt$$ExternalSyntheticLambda0(v9);
                    v11.updateRememberedValue(v14_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v11);
                Modifier v2_2 = SemanticsModifierKt.semantics$default(((Modifier)v13_1), false, ((Function1)v14_2), 1, v6_1);
                v11.endReplaceGroup();
            }
            else {
                v11.startReplaceGroup(0x713643C2);
                v11.endReplaceGroup();
                v2_3 = Modifier.Companion;
            }

            ColorFilter v6_2 = v8_1;
            v13_1 = v0_1;
            Alignment v3_1 = v1_1;
            v0_2 = PainterModifierKt.paint$default(ClipKt.clipToBounds(((Modifier)v0_1).then(((Modifier)v2_3))), arg17, false, v3_1, v4_1, v5_1, v6_2, 2, null);
            ComposerKt.sourceInformationMarkerStart(v11, -1324188104, v12_1);
            Object v1_2 = v11.rememberedValue();
            if(v1_2 == Composer.Companion.getEmpty()) {
                v1_3 = ImageKt$Image$1$1.INSTANCE;
                v11.updateRememberedValue(v1_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerStart(v11, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
            v2_1 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v11, 0));
            v0_2 = ComposedModifierKt.materializeModifier(v11, v0_2);
            CompositionLocalMap v7 = v11.getCurrentCompositionLocalMap();
            Function0 v8_2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v11, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(v11.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v11.startReusableNode();
            if(v11.getInserting()) {
                v11.createNode(v8_2);
            }
            else {
                v11.useNode();
            }

            Composer v8_3 = Updater.constructor-impl(v11);
            Updater.set-impl(v8_3, v1_3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v8_3, v7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.reconcile-impl(v8_3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v8_3, v0_2, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v8_3, Integer.valueOf(v2_1), ComposeUiNode.Companion.getSetCompositeKeyHash());
            v11.endNode();
            ComposerKt.sourceInformationMarkerEnd(v11);
            ComposerKt.sourceInformationMarkerEnd(v11);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_1 = v6_2;
            v6_3 = v5_1;
            v5_2 = v4_1;
            v4_2 = v3_1;
            v3_2 = v13_1;
        }
        else {
            v11.skipToGroupEnd();
            v4_2 = arg20;
            v7_1 = arg23;
            Modifier v3_3 = v5;
            v5_2 = v12;
            v6_3 = v14_1;
        }

        ScopeUpdateScope v11_1 = v11.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new ImageKt$$ExternalSyntheticLambda1(arg17, v9, ((Modifier)v3_2), v4_2, v5_2, v6_3, v7_1, v10, arg26));
        }
    }

    public static final void Image(ImageVector arg10, String arg11, Modifier arg12, Alignment arg13, ContentScale arg14, float arg15, ColorFilter arg16, Composer arg17, int arg18, int arg19) {
        Companion v12;
        Composer v7 = arg17;
        int v0 = arg18;
        int v2 = 0x5F1F9C13;
        ComposerKt.sourceInformationMarkerStart(v7, v2, "C(Image)N(imageVector,contentDescription,modifier,alignment,contentScale,alpha,colorFilter)203@9457L34,202@9432L270:Image.kt#71ulvw");
        if((arg19 & 4) != 0) {
            v12 = Modifier.Companion;
        }

        if((arg19 & 8) != 0) {
            arg13 = Alignment.Companion.getCenter();
        }

        Alignment v3 = arg13;
        if((arg19 & 16) != 0) {
            arg14 = ContentScale.Companion.getFit();
        }

        ContentScale v4 = arg14;
        if((arg19 & 0x20) != 0) {
            arg15 = 1f;
        }

        float v5 = arg15;
        ColorFilter v6 = (arg19 & 0x40) != 0 ? null : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, v0, -1, "androidx.compose.foundation.Image (Image.kt:202)");
        }

        ImageKt.Image(VectorPainterKt.rememberVectorPainter(arg10, v7, v0 & 14), arg11, ((Modifier)v12), v3, v4, v5, v6, v7, VectorPainter.$stable | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | 0x70000 & v0 | 0x380000 & v0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg17);
    }

    private static final Unit Image$lambda$0$0(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentDescription(arg1, arg0);
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getImage-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Image$lambda$2(Painter arg11, String arg12, Modifier arg13, Alignment arg14, ContentScale arg15, float arg16, ColorFilter arg17, int arg18, int arg19, Composer arg20, int arg21) {
        ImageKt.Image(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    public static final void Image-5h-nEew(ImageBitmap arg17, String arg18, Modifier arg19, Alignment arg20, ContentScale arg21, float arg22, ColorFilter arg23, int arg24, Composer arg25, int arg26, int arg27) {
        Companion v2;
        Composer v7 = arg25;
        int v0 = arg26;
        int v1 = arg27;
        int v3 = 0xACC6C084;
        ComposerKt.sourceInformationMarkerStart(v7, v3, "C(Image)N(bitmap,contentDescription,modifier,alignment,contentScale,alpha,colorFilter,filterQuality:c#ui.graphics.FilterQuality)157@7327L73,158@7405L249:Image.kt#71ulvw");
        if((v1 & 4) != 0) {
            v2 = Modifier.Companion;
        }
        else {
            Modifier v2_1 = arg19;
        }

        Alignment v4 = (v1 & 8) != 0 ? Alignment.Companion.getCenter() : arg20;
        ContentScale v5 = (v1 & 16) != 0 ? ContentScale.Companion.getFit() : arg21;
        float v6 = (v1 & 0x20) != 0 ? 1f : arg22;
        ColorFilter v8 = (v1 & 0x40) != 0 ? null : arg23;
        int v14 = (v1 & 0x80) != 0 ? DrawScope.Companion.getDefaultFilterQuality-f-v9h1I() : arg24;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v0, -1, "androidx.compose.foundation.Image (Image.kt:156)");
        }

        ComposerKt.sourceInformationMarkerStart(v7, 0x9618DC4D, "CC(remember):Image.kt#9igjgp");
        ImageBitmap v9 = arg17;
        boolean v1_1 = v7.changed(v9);
        Object v3_1 = v7.rememberedValue();
        if((v1_1) || v3_1 == Composer.Companion.getEmpty()) {
            BitmapPainter v3_2 = BitmapPainterKt.BitmapPainter-QZhYCtY$default(v9, 0, 0, v14, 6, null);
            v7.updateRememberedValue(v3_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v7);
        ImageKt.Image(v3_1, arg18, ((Modifier)v2), v4, v5, v6, v8, v7, v0 & 0x380000 | (BitmapPainter.$stable | v0 & 0x70 | v0 & 0x380 | v0 & 0x1C00 | 0xE000 & v0 | 0x70000 & v0), 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg25);
    }
}

