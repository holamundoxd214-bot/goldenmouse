package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u0004²\u0006\n\u0010\u0005\u001A\u00020\u0006X\u008A\u0084\u0002"}, d2={"textFieldMinSize", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "foundation", "typeface", ""}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldSizeKt {
    public static Unit $r8$lambda$J8iRo982Zony74O_1-FxA4p7zOA(Placeable arg0, PlacementScope arg1) {
        return TextFieldSizeKt.textFieldMinSize$lambda$0$4$0$0(arg0, arg1);
    }

    public static MeasureResult $r8$lambda$oVElyUuYcIFGld5u6uKnyDP4gkc(TextFieldSize arg0, MeasureScope arg1, Measurable arg2, Constraints arg3) {
        return TextFieldSizeKt.textFieldMinSize$lambda$0$4$0(arg0, arg1, arg2, arg3);
    }

    public static final Modifier textFieldMinSize(Modifier arg2, TextStyle arg3) {
        return ComposedModifierKt.composed$default(arg2, null, new TextFieldSizeKt$$ExternalSyntheticLambda1(arg3), 1, null);
    }

    static final Modifier textFieldMinSize$lambda$0(TextStyle arg7, Modifier arg8, Composer arg9, int arg10) {
        TextFieldSizeKt$$ExternalSyntheticLambda0 v10_2;
        State v1_2;
        int v8 = 0x5E56A525;
        arg9.startReplaceGroup(v8);
        ComposerKt.sourceInformation(arg9, "C37@1534L7,38@1595L7,39@1650L7,41@1683L76,43@1788L341,52@2154L101,58@2373L488:TextFieldSize.kt#423gt5");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v8, arg10, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
        }

        ProvidableCompositionLocal v8_1 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v8_2 = arg9.consume(((CompositionLocal)v8_1));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v3 = v8_2;
        v8_1 = CompositionLocalsKt.getLocalFontFamilyResolver();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v8_2 = arg9.consume(((CompositionLocal)v8_1));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v4 = v8_2;
        v8_1 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(arg9, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        v8_2 = arg9.consume(((CompositionLocal)v8_1));
        ComposerKt.sourceInformationMarkerEnd(arg9);
        Object v2 = v8_2;
        String v10 = "CC(remember):TextFieldSize.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(arg9, 0x234206F1, v10);
        v8 = arg9.changed(arg7) | arg9.changed(v2.ordinal());
        Object v0 = arg9.rememberedValue();
        if(v8 != 0 || v0 == Composer.Companion.getEmpty()) {
            TextStyle v0_1 = TextStyleKt.resolveDefaults(arg7, ((LayoutDirection)v2));
            arg9.updateRememberedValue(v0_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        ComposerKt.sourceInformationMarkerStart(arg9, 0x2342151A, v10);
        v8 = arg9.changed(v4) | arg9.changed(v0);
        Object v1 = arg9.rememberedValue();
        if(v8 != 0 || v1 == Composer.Companion.getEmpty()) {
            FontFamily v8_3 = ((TextStyle)v0).getFontFamily();
            FontWeight v1_1 = ((TextStyle)v0).getFontWeight();
            if(v1_1 == null) {
                v1_1 = FontWeight.Companion.getNormal();
            }

            FontStyle v5 = ((TextStyle)v0).getFontStyle-4Lr2A7w();
            int v5_1 = v5 != null ? v5.unbox-impl() : FontStyle.Companion.getNormal-_-LCdwA();
            FontSynthesis v6 = ((TextStyle)v0).getFontSynthesis-ZQGJjVo();
            int v6_1 = v6 != null ? v6.unbox-impl() : FontSynthesis.Companion.getAll-GVVA2EU();
            v1_2 = ((Resolver)v4).resolve-DPcqOEQ(v8_3, v1_1, v5_1, v6_1);
            arg9.updateRememberedValue(v1_2);
        }

        v8_2 = v1_2;
        ComposerKt.sourceInformationMarkerEnd(arg9);
        ComposerKt.sourceInformationMarkerStart(arg9, 591544810, v10);
        v1 = arg9.rememberedValue();
        if(v1 == Composer.Companion.getEmpty()) {
            TextFieldSize v1_3 = new TextFieldSize(((LayoutDirection)v2), ((Density)v3), ((Resolver)v4), arg7, TextFieldSizeKt.textFieldMinSize$lambda$0$2(((State)v8_2)));
            arg9.updateRememberedValue(v1_3);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        ((TextFieldSize)v1).update(((LayoutDirection)v2), ((Density)v3), ((Resolver)v4), v0, TextFieldSizeKt.textFieldMinSize$lambda$0$2(((State)v8_2)));
        Companion v7 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(arg9, 591552205, v10);
        boolean v8_4 = arg9.changedInstance(v1);
        Object v10_1 = arg9.rememberedValue();
        if((v8_4) || v10_1 == Composer.Companion.getEmpty()) {
            v10_2 = new TextFieldSizeKt$$ExternalSyntheticLambda0(((TextFieldSize)v1));
            arg9.updateRememberedValue(v10_2);
        }

        ComposerKt.sourceInformationMarkerEnd(arg9);
        Modifier v7_1 = LayoutModifierKt.layout(((Modifier)v7), ((Function3)v10_2));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg9.endReplaceGroup();
        return v7_1;
    }

    private static final Object textFieldMinSize$lambda$0$2(State arg0) {
        return arg0.getValue();
    }

    private static final MeasureResult textFieldMinSize$lambda$0$4$0(TextFieldSize arg10, MeasureScope arg11, Measurable arg12, Constraints arg13) {
        long v0 = arg10.getMinSize-YbymL2g();
        Placeable v10 = arg12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg13.unbox-impl(), RangesKt.coerceIn(((int)(v0 >> 0x20)), Constraints.getMinWidth-impl(arg13.unbox-impl()), Constraints.getMaxWidth-impl(arg13.unbox-impl())), 0, RangesKt.coerceIn(((int)(v0 & 0xFFFFFFFFL)), Constraints.getMinHeight-impl(arg13.unbox-impl()), Constraints.getMaxHeight-impl(arg13.unbox-impl())), 0, 10, null));
        return MeasureScope.layout$default(arg11, v10.getWidth(), v10.getHeight(), null, new TextFieldSizeKt$$ExternalSyntheticLambda2(v10), 4, null);
    }

    private static final Unit textFieldMinSize$lambda$0$4$0$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.placeRelative$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

