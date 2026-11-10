package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Aj\u0010\u0000\u001A\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u008E\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00010\u000F2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001A\u0096\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00152\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00010\u000F2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001B\u0010\u001C\u001A\u009C\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u00152\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001F2\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u0011\u0010\u000E\u001A\r\u0012\u0004\u0012\u00020\u00010\u000F¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001B\u0010 \u001A5\u0010!\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\"\u001A\u00020\u00072\b\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000B\u001A\u00020#H\u0003¢\u0006\u0004\b$\u0010%\u001A\u001F\u0010&\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\'\u001A\u00020\nH\u0003¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001A\b\u0012\u0004\u0012\u00020\n0+¢\u0006\b\n\u0000\u001A\u0004\b,\u0010-¨\u0006."}, d2={"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SurfaceKt {
    private static final ProvidableCompositionLocal LocalAbsoluteTonalElevation;

    static {
        SurfaceKt.LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new SurfaceKt$$ExternalSyntheticLambda0(), 1, null);
    }

    static final Dp LocalAbsoluteTonalElevation$lambda$3() {
        return Dp.box-impl(Dp.constructor-impl(0f));
    }

    public static final void Surface-T9BRK9s(Modifier arg3, Shape arg4, long arg5, long arg7, float arg9, float arg10, BorderStroke arg11, Function2 arg12, Composer arg13, int arg14, int arg15) {
        Companion v3;
        int v1 = -1093433818;
        ComposerKt.sourceInformationMarkerStart(arg13, v1, "C(Surface)N(modifier,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)98@5172L11,99@5219L22,105@5437L7,109@5611L884,106@5466L1029:Surface.kt#uh7d8r");
        if((arg15 & 1) != 0) {
            v3 = Modifier.Companion;
        }

        if((arg15 & 2) != 0) {
            arg4 = RectangleShapeKt.getRectangleShape();
        }

        if((arg15 & 4) != 0) {
            arg5 = MaterialTheme.INSTANCE.getColorScheme(arg13, 6).getSurface-0d7_KjU();
        }

        if((arg15 & 8) != 0) {
            arg7 = ColorSchemeKt.contentColorFor-ek8zF_U(arg5, arg13, arg14 >> 6 & 14);
        }

        if((arg15 & 16) != 0) {
            arg9 = Dp.constructor-impl(0f);
        }

        if((arg15 & 0x20) != 0) {
            arg10 = Dp.constructor-impl(0f);
        }

        if((arg15 & 0x40) != 0) {
            arg11 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg14, -1, "androidx.compose.material3.Surface (Surface.kt:104)");
        }

        ProvidableCompositionLocal v14 = SurfaceKt.LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(arg13, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v15 = arg13.consume(v14);
        ComposerKt.sourceInformationMarkerEnd(arg13);
        arg9 = Dp.constructor-impl(((Dp)v15).unbox-impl() + arg9);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg7)), v14.provides(Dp.box-impl(arg9))}, ComposableLambdaKt.rememberComposableLambda(421772006, true, new SurfaceKt$Surface$1(((Modifier)v3), arg4, arg5, arg9, arg11, arg10, arg12), arg13, 54), arg13, ProvidedValue.$stable | 0x30);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg13);
    }

    public static final void Surface-d85dljk(boolean arg18, Function0 arg19, Modifier arg20, boolean arg21, Shape arg22, long arg23, long arg25, float arg27, float arg28, BorderStroke arg29, MutableInteractionSource arg30, Function2 arg31, Composer arg32, int arg33, int arg34, int arg35) {
        Companion v6;
        Composer v0 = arg32;
        int v1 = arg33;
        int v2 = arg35;
        int v4 = 0x546E65B3;
        ComposerKt.sourceInformationMarkerStart(v0, v4, "C(Surface)N(selected,onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)306@16724L11,307@16771L22,316@17167L7,320@17341L916,317@17196L1061:Surface.kt#uh7d8r");
        if((v2 & 4) != 0) {
            v6 = Modifier.Companion;
        }
        else {
            Modifier v6_1 = arg20;
        }

        boolean v14 = (v2 & 8) != 0 ? true : arg21;
        Shape v7 = (v2 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : arg22;
        long v8 = (v2 & 0x20) != 0 ? MaterialTheme.INSTANCE.getColorScheme(v0, 6).getSurface-0d7_KjU() : arg23;
        long v10 = (v2 & 0x40) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v8, v0, v1 >> 15 & 14) : arg25;
        float v3 = (v2 & 0x80) != 0 ? Dp.constructor-impl(0f) : arg27;
        float v16 = (v2 & 0x100) != 0 ? Dp.constructor-impl(0f) : arg28;
        MutableInteractionSource v13 = null;
        BorderStroke v12 = (v2 & 0x200) != 0 ? ((BorderStroke)v13) : arg29;
        if((v2 & 0x400) != 0) {
        }
        else {
            v13 = arg30;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v1, arg34, "androidx.compose.material3.Surface (Surface.kt:313)");
        }

        if(v13 == null) {
            v0.startReplaceGroup(0x5B159DE8);
            ComposerKt.sourceInformation(v0, "315@17071L39");
            ComposerKt.sourceInformationMarkerStart(v0, 0xF26C0D5A, "CC(remember):Surface.kt#9igjgp");
            Object v1_1 = v0.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                MutableInteractionSource v1_2 = InteractionSourceKt.MutableInteractionSource();
                v0.updateRememberedValue(v1_2);
            }

            Object v13_1 = v1_1;
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v0.startReplaceGroup(-227800369);
        }

        v0.endReplaceGroup();
        ProvidableCompositionLocal v1_3 = SurfaceKt.LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = v0.consume(v1_3);
        ComposerKt.sourceInformationMarkerEnd(v0);
        float v2_2 = Dp.constructor-impl(((Dp)v2_1).unbox-impl() + v3);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(v10)), v1_3.provides(Dp.box-impl(v2_2))}, ComposableLambdaKt.rememberComposableLambda(0x59ED78F3, true, new SurfaceKt$Surface$3(((Modifier)v6), v7, v8, v2_2, v12, arg18, v13, v14, arg19, v16, arg31), v0, 54), v0, ProvidedValue.$stable | 0x30);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
    }

    public static final void Surface-d85dljk(boolean arg18, Function1 arg19, Modifier arg20, boolean arg21, Shape arg22, long arg23, long arg25, float arg27, float arg28, BorderStroke arg29, MutableInteractionSource arg30, Function2 arg31, Composer arg32, int arg33, int arg34, int arg35) {
        MutableInteractionSource v1_2;
        Companion v6;
        Composer v0 = arg32;
        int v1 = arg33;
        int v2 = arg35;
        int v4 = 0x8CE30492;
        ComposerKt.sourceInformationMarkerStart(v0, v4, "C(Surface)N(checked,onCheckedChange,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)413@22663L11,414@22710L22,423@23106L7,427@23280L926,424@23135L1071:Surface.kt#uh7d8r");
        if((v2 & 4) != 0) {
            v6 = Modifier.Companion;
        }
        else {
            Modifier v6_1 = arg20;
        }

        boolean v14 = (v2 & 8) != 0 ? true : arg21;
        Shape v7 = (v2 & 16) != 0 ? RectangleShapeKt.getRectangleShape() : arg22;
        long v8 = (v2 & 0x20) != 0 ? MaterialTheme.INSTANCE.getColorScheme(v0, 6).getSurface-0d7_KjU() : arg23;
        long v10 = (v2 & 0x40) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v8, v0, v1 >> 15 & 14) : arg25;
        float v3 = (v2 & 0x80) != 0 ? Dp.constructor-impl(0f) : arg27;
        float v16 = (v2 & 0x100) != 0 ? Dp.constructor-impl(0f) : arg28;
        MutableInteractionSource v13 = null;
        BorderStroke v12 = (v2 & 0x200) != 0 ? ((BorderStroke)v13) : arg29;
        if((v2 & 0x400) != 0) {
        }
        else {
            v13 = arg30;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, v1, arg34, "androidx.compose.material3.Surface (Surface.kt:420)");
        }

        if(v13 == null) {
            v0.startReplaceGroup(0x2659D4E9);
            ComposerKt.sourceInformation(v0, "422@23010L39");
            ComposerKt.sourceInformationMarkerStart(v0, 0xE0347239, "CC(remember):Surface.kt#9igjgp");
            Object v1_1 = v0.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = InteractionSourceKt.MutableInteractionSource();
                v0.updateRememberedValue(v1_2);
            }

            Object v13_1 = v1_2;
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v0.startReplaceGroup(0xE0346FAE);
        }

        v0.endReplaceGroup();
        ProvidableCompositionLocal v1_3 = SurfaceKt.LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = v0.consume(v1_3);
        ComposerKt.sourceInformationMarkerEnd(v0);
        float v2_2 = Dp.constructor-impl(((Dp)v2_1).unbox-impl() + v3);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(v10)), v1_3.provides(Dp.box-impl(v2_2))}, ComposableLambdaKt.rememberComposableLambda(-1839065134, true, new SurfaceKt$Surface$4(((Modifier)v6), v7, v8, v2_2, v12, arg18, v13, v14, arg19, v16, arg31), v0, 54), v0, ProvidedValue.$stable | 0x30);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
    }

    public static final void Surface-o_FOJdg(Function0 arg17, Modifier arg18, boolean arg19, Shape arg20, long arg21, long arg23, float arg25, float arg26, BorderStroke arg27, MutableInteractionSource arg28, Function2 arg29, Composer arg30, int arg31, int arg32, int arg33) {
        Object v14_1;
        MutableInteractionSource v1_2;
        int v18;
        Modifier v6_1;
        Composer v0 = arg30;
        int v1 = arg31;
        int v2 = arg33;
        int v4 = 0xA837918F;
        ComposerKt.sourceInformationMarkerStart(v0, v4, "C(Surface)N(onClick,modifier,enabled,shape,color:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,interactionSource,content)200@10898L11,201@10945L22,210@11341L7,214@11515L870,211@11370L1015:Surface.kt#uh7d8r");
        if((v2 & 2) != 0) {
            Companion v6 = Modifier.Companion;
        }
        else {
            v6_1 = arg18;
        }

        boolean v13 = (v2 & 4) != 0 ? true : arg19;
        Shape v7 = (v2 & 8) != 0 ? RectangleShapeKt.getRectangleShape() : arg20;
        long v8 = (v2 & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme(v0, 6).getSurface-0d7_KjU() : arg21;
        long v10 = (v2 & 0x20) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v8, v0, v1 >> 12 & 14) : arg23;
        float v3 = (v2 & 0x40) != 0 ? Dp.constructor-impl(0f) : arg25;
        float v15 = (v2 & 0x80) != 0 ? Dp.constructor-impl(0f) : arg26;
        MutableInteractionSource v14 = null;
        BorderStroke v12 = (v2 & 0x100) != 0 ? ((BorderStroke)v14) : arg27;
        if((v2 & 0x200) != 0) {
        }
        else {
            v14 = arg28;
        }

        if(ComposerKt.isTraceInProgress()) {
            v18 = 1;
            ComposerKt.traceEventStart(v4, v1, arg32, "androidx.compose.material3.Surface (Surface.kt:207)");
        }
        else {
            v18 = 1;
        }

        if(v14 == null) {
            v0.startReplaceGroup(-1701037204);
            ComposerKt.sourceInformation(v0, "209@11245L39");
            ComposerKt.sourceInformationMarkerStart(v0, 0x7899AF56, "CC(remember):Surface.kt#9igjgp");
            Object v1_1 = v0.rememberedValue();
            if(v1_1 == Composer.Companion.getEmpty()) {
                v1_2 = InteractionSourceKt.MutableInteractionSource();
                v0.updateRememberedValue(v1_2);
            }

            v14_1 = v1_2;
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v0.startReplaceGroup(2023337163);
        }

        v0.endReplaceGroup();
        ProvidableCompositionLocal v1_3 = SurfaceKt.LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_1 = v0.consume(v1_3);
        ComposerKt.sourceInformationMarkerEnd(v0);
        float v2_2 = Dp.constructor-impl(((Dp)v2_1).unbox-impl() + v3);
        ProvidedValue[] v3_1 = new ProvidedValue[2];
        v3_1[0] = ContentColorKt.getLocalContentColor().provides(Color.box-impl(v10));
        v3_1[v18] = v1_3.provides(Dp.box-impl(v2_2));
        CompositionLocalKt.CompositionLocalProvider(v3_1, ComposableLambdaKt.rememberComposableLambda(0x329DE4CF, ((boolean)v18), new SurfaceKt$Surface$2(v6_1, v7, v8, v2_2, v12, ((MutableInteractionSource)v14_1), v13, arg17, v15, arg29), v0, 54), v0, ProvidedValue.$stable | 0x30);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
    }

    public static final Modifier access$surface-XO-JAsU(Modifier arg0, Shape arg1, long arg2, BorderStroke arg4, float arg5) {
        return SurfaceKt.surface-XO-JAsU(arg0, arg1, arg2, arg4, arg5);
    }

    public static final long access$surfaceColorAtElevation-CLU3JFs(long arg0, float arg2, Composer arg3, int arg4) {
        return SurfaceKt.surfaceColorAtElevation-CLU3JFs(arg0, arg2, arg3, arg4);
    }

    public static final ProvidableCompositionLocal getLocalAbsoluteTonalElevation() {
        return SurfaceKt.LocalAbsoluteTonalElevation;
    }

    private static final Modifier surface-XO-JAsU(Modifier arg24, Shape arg25, long arg26, BorderStroke arg28, float arg29) {
        Modifier v0_1;
        Companion v1_1;
        Modifier v1;
        Shape v14;
        BorderStroke v0 = arg28;
        if(arg29 > 0f) {
            v14 = arg25;
            v1 = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(Modifier.Companion, 0f, 0f, 0f, 0f, 0f, arg29, 0f, 0f, 0f, 0f, 0, v14, false, null, 0, 0, 0, 0x1E7DF, null);
        }
        else {
            v14 = arg25;
            v1_1 = Modifier.Companion;
        }

        v1 = arg24.then(((Modifier)v1_1));
        if(v0 != null) {
            v0_1 = BorderKt.border(Modifier.Companion, v0, v14);
        }
        else {
            Companion v0_2 = Modifier.Companion;
        }

        return ClipKt.clip(BackgroundKt.background-bw27NRU(v1.then(v0_1), arg26, v14), v14);
    }

    private static final long surfaceColorAtElevation-CLU3JFs(long arg8, float arg10, Composer arg11, int arg12) {
        int v1 = 0x8406F7F6;
        ComposerKt.sourceInformationMarkerStart(arg11, v1, "C(surfaceColorAtElevation)N(color:c#ui.graphics.Color,elevation:c#ui.unit.Dp)478@24926L11,478@24938L37:Surface.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg12, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:478)");
        }

        Composer v6 = arg11;
        arg8 = ColorSchemeKt.applyTonalElevation-RFCenO8(MaterialTheme.INSTANCE.getColorScheme(arg11, 6), arg8, arg10, v6, arg12 << 3 & 0x3F0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        return arg8;
    }
}

