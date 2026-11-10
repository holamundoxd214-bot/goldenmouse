package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001A(\u0010\u0002\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00012\b\b\u0002\u0010\u0007\u001A\u00020\u0001H\u0000\u001A\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0001H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n²\u0006\n\u0010\u000B\u001A\u00020\fX\u008A\u0084\u0002"}, d2={"DefaultMinLines", "", "heightInLines", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minLines", "maxLines", "validateMinMaxLines", "", "foundation", "typeface", ""}, k=2, mv={2, 0, 0}, xi=0x30) public final class HeightInLinesModifierKt {
    public static final int DefaultMinLines = 1;

    public static final Modifier heightInLines(Modifier arg2, TextStyle arg3, int arg4, int arg5) {
        HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1 v0;
        if(InspectableValueKt.isDebugInspectorInfoEnabled()) {
            v0 = new HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1(arg4, arg5, arg3);
        }
        else {
            Function1 v0_1 = InspectableValueKt.getNoInspectorInfo();
        }

        return ComposedModifierKt.composed(arg2, ((Function1)v0), new HeightInLinesModifierKt$$ExternalSyntheticLambda0(arg4, arg5, arg3));
    }

    public static Modifier heightInLines$default(Modifier arg0, TextStyle arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = 0x7FFFFFFF;
        }

        return HeightInLinesModifierKt.heightInLines(arg0, arg1, 1, arg3);
    }

    static final Modifier heightInLines$lambda$1(int arg20, int arg21, TextStyle arg22, Modifier arg23, Composer arg24, int arg25) {
        Integer v8_4;
        long v18;
        TextStyle v12_1;
        int v0 = arg20;
        int v1 = arg21;
        TextStyle v2 = arg22;
        Composer v3 = arg24;
        int v4 = 408240218;
        v3.startReplaceGroup(v4);
        ComposerKt.sourceInformation(v3, "C65@2532L7,66@2597L7,67@2656L7,72@2851L84,74@2972L369,84@3385L430,96@3863L500:HeightInLinesModifier.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v4, arg25, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:62)");
        }

        HeightInLinesModifierKt.validateMinMaxLines(arg20, arg21);
        v4 = 0x7FFFFFFF;
        if(v0 == 1 && v1 == v4) {
            Companion v0_1 = Modifier.Companion;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v3.endReplaceGroup();
            return ((Modifier)v0_1);
        }

        ProvidableCompositionLocal v6 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v6_1 = v3.consume(((CompositionLocal)v6));
        ComposerKt.sourceInformationMarkerEnd(v3);
        ProvidableCompositionLocal v9 = CompositionLocalsKt.getLocalFontFamilyResolver();
        ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v9_1 = v3.consume(((CompositionLocal)v9));
        ComposerKt.sourceInformationMarkerEnd(v3);
        ProvidableCompositionLocal v10 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v7 = v3.consume(((CompositionLocal)v10));
        ComposerKt.sourceInformationMarkerEnd(v3);
        String v10_1 = "CC(remember):HeightInLinesModifier.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(v3, 0x5806D0AE, v10_1);
        Object v11 = v7;
        int v8 = v3.changed(v2) | v3.changed(((Enum)v11).ordinal());
        Object v12 = v3.rememberedValue();
        if(v8 != 0 || v12 == Composer.Companion.getEmpty()) {
            v12_1 = TextStyleKt.resolveDefaults(v2, ((LayoutDirection)v7));
            v3.updateRememberedValue(v12_1);
        }

        ComposerKt.sourceInformationMarkerEnd(v3);
        ComposerKt.sourceInformationMarkerStart(v3, 0x5806E0EB, v10_1);
        int v7_1 = v3.changed(v9_1) | v3.changed(v12_1);
        Object v8_1 = v3.rememberedValue();
        if(v7_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
            FontFamily v7_2 = v12_1.getFontFamily();
            FontWeight v8_2 = v12_1.getFontWeight();
            if(v8_2 == null) {
                v8_2 = FontWeight.Companion.getNormal();
            }

            FontStyle v13 = v12_1.getFontStyle-4Lr2A7w();
            int v13_1 = v13 != null ? v13.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
            FontSynthesis v14 = v12_1.getFontSynthesis-ZQGJjVo();
            int v14_1 = v14 != null ? v14.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
            State v8_3 = ((Resolver)v9_1).resolve-DPcqOEQ(v7_2, v8_2, v13_1, v14_1);
            v3.updateRememberedValue(v8_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v3);
        v7 = HeightInLinesModifierKt.heightInLines$lambda$1$2(((State)v8_1));
        ComposerKt.sourceInformationMarkerStart(v3, 1476859080, v10_1);
        v7_1 = v3.changed(v7) | (v3.changed(v6_1) | v3.changed(v9_1) | v3.changed(v2) | v3.changed(((Enum)v11).ordinal()));
        Object v13_2 = v3.rememberedValue();
        if(v7_1 != 0 || v13_2 == Composer.Companion.getEmpty()) {
            v18 = 0xFFFFFFFFL;
            Integer v13_3 = Integer.valueOf(((int)(TextFieldDelegateKt.computeSizeForDefaultText(v12_1, ((Density)v6_1), ((Resolver)v9_1), TextFieldDelegateKt.getEmptyTextReplacement(), 1) & v18)));
            v3.updateRememberedValue(v13_3);
        }
        else {
            v18 = 0xFFFFFFFFL;
        }

        v7_1 = ((Number)v13_2).intValue();
        ComposerKt.sourceInformationMarkerEnd(v3);
        v8_1 = HeightInLinesModifierKt.heightInLines$lambda$1$2(((State)v8_1));
        ComposerKt.sourceInformationMarkerStart(v3, 0x580750CE, v10_1);
        int v2_1 = v3.changed(v2) | (v3.changed(v6_1) | v3.changed(v9_1)) | v3.changed(((Enum)v11).ordinal()) | v3.changed(v8_1);
        v8_1 = v3.rememberedValue();
        if(v2_1 != 0 || v8_1 == Composer.Companion.getEmpty()) {
            v8_4 = Integer.valueOf(((int)(TextFieldDelegateKt.computeSizeForDefaultText(v12_1, ((Density)v6_1), ((Resolver)v9_1), TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2) & v18)));
            v3.updateRememberedValue(v8_4);
        }

        v2_1 = ((Number)v8_4).intValue();
        ComposerKt.sourceInformationMarkerEnd(v3);
        v2_1 -= v7_1;
        v8_4 = null;
        Integer v0_2 = v0 == 1 ? v8_4 : Integer.valueOf((v0 - 1) * v2_1 + v7_1);
        if(v1 == v4) {
        }
        else {
            v8_4 = Integer.valueOf(v7_1 + v2_1 * (v1 - 1));
        }

        Companion v1_1 = Modifier.Companion;
        float v0_3 = v0_2 != null ? ((Density)v6_1).toDp-u2uoSUM(v0_2.intValue()) : Dp.Companion.getUnspecified-D9Ej5fM();
        float v2_2 = v8_4 != null ? ((Density)v6_1).toDp-u2uoSUM(v8_4.intValue()) : Dp.Companion.getUnspecified-D9Ej5fM();
        Modifier v0_4 = SizeKt.heightIn-VpY3zN4(((Modifier)v1_1), v0_3, v2_2);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v3.endReplaceGroup();
        return v0_4;
    }

    private static final Object heightInLines$lambda$1$2(State arg0) {
        return arg0.getValue();
    }

    public static final void validateMinMaxLines(int arg4, int arg5) {
        int v0 = 1;
        int v2 = arg4 <= 0 || arg5 <= 0 ? 0 : 1;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("both minLines " + arg4 + " and maxLines " + arg5 + " must be greater than zero");
        }

        if(arg4 <= arg5) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("minLines " + arg4 + " must be less than or equal to maxLines " + arg5);
        }
    }
}

