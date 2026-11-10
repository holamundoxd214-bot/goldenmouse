package androidx.compose.foundation.text;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits$SingleLine;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode_androidKt;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AÛ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001A2\u0012\u0004\u0012\u00020\u0013\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#2\b\b\u0002\u0010$\u001A\u00020%H\u0007¢\u0006\u0004\b&\u0010\'\u001A\u001A\u0010(\u001A\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u0010)\u001A\u0004\u0018\u00010\nH\u0002\u001A \u0010-\u001A\u00020\u00012\u0011\u0010.\u001A\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b/H\u0003¢\u0006\u0002\u00100\u001AÇ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001A2\u0012\u0004\u0012\u00020\u0013\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b1\u00102\u001AÑ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001A2\u0012\u0004\u0012\u00020\u0013\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b3\u00104\"\u000E\u0010*\u001A\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010,\u001A\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2={"BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-ltb6GB4", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "then", "next", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "DefaultObfuscationCharacter", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = '•';
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    public static Unit $r8$lambda$7q_5pHTMJj2b2wVNd1sG18J9-PA(SemanticsPropertyReceiver arg0) {
        return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$4$0(arg0);
    }

    public static int $r8$lambda$tEQdrNLl9eQX2DNbJTpsuRVEG2A(State arg0, int arg1, int arg2) {
        return BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$3$0(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the overload that takes in readOnly parameter.") public static final void BasicSecureTextField-Jb9bMDk(TextFieldState arg37, Modifier arg38, boolean arg39, InputTransformation arg40, TextStyle arg41, KeyboardOptions arg42, KeyboardActionHandler arg43, Function2 arg44, MutableInteractionSource arg45, Brush arg46, TextFieldDecorator arg47, int arg48, char arg49, Composer arg50, int arg51, int arg52, int arg53) {
        Modifier v2_2;
        char v13_1;
        TextFieldDecorator v11_1;
        SolidColor v10_1;
        MutableInteractionSource v9_1;
        Function2 v8_1;
        KeyboardActionHandler v7_1;
        KeyboardOptions v6_1;
        TextStyle v5_2;
        InputTransformation v4_1;
        boolean v3_1;
        Composer v31;
        SolidColor v26_1;
        TextStyle v21_1;
        Companion v17_1;
        int v36;
        int v20;
        int v18;
        int v29;
        int v28;
        int v27;
        KeyboardActionHandler v13;
        int v23;
        KeyboardOptions v10;
        int v21;
        TextStyle v9;
        int v19;
        InputTransformation v6;
        int v17;
        boolean v5;
        int v12;
        Modifier v11;
        int v7;
        TextFieldState v4;
        TextFieldDecorator v0 = arg47;
        int v14 = arg51;
        int v15 = arg52;
        int v1 = arg53;
        Composer v3 = arg50.startRestartGroup(1399310985);
        ComposerKt.sourceInformation(v3, "C(BasicSecureTextField)N(state,modifier,enabled,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)364@17059L564:BasicSecureTextField.kt#423gt5");
        if((v14 & 6) == 0) {
            v4 = arg37;
            v7 = v3.changed(v4) ? 4 : 2;
            v7 |= v14;
        }
        else {
            v4 = arg37;
            v7 = v14;
        }

        int v8 = v1 & 2;
        if(v8 != 0) {
            v7 |= 0x30;
            goto label_35;
        }
        else if((v14 & 0x30) == 0) {
            v11 = arg38;
            v12 = v3.changed(v11) ? 0x20 : 16;
            v7 |= v12;
        }
        else {
        label_35:
            v11 = arg38;
        }

        v12 = v1 & 4;
        int v16 = 0x80;
        if(v12 != 0) {
            v7 |= 0x180;
            goto label_51;
        }
        else if((v14 & 0x180) == 0) {
            v5 = arg39;
            v17 = v3.changed(v5) ? 0x100 : v16;
            v7 |= v17;
        }
        else {
        label_51:
            v5 = arg39;
        }

        v17 = v1 & 8;
        if(v17 != 0) {
            v7 |= 0xC00;
            goto label_66;
        }
        else if((v14 & 0xC00) == 0) {
            v6 = arg40;
            v19 = v3.changed(v6) ? 0x800 : 0x400;
            v7 |= v19;
        }
        else {
        label_66:
            v6 = arg40;
        }

        v19 = v1 & 16;
        if(v19 != 0) {
            v7 |= 0x6000;
            goto label_81;
        }
        else if((v14 & 0x6000) == 0) {
            v9 = arg41;
            v21 = v3.changed(v9) ? 0x4000 : 0x2000;
            v7 |= v21;
        }
        else {
        label_81:
            v9 = arg41;
        }

        v21 = v1 & 0x20;
        int v22 = 0x30000;
        if(v21 != 0) {
            v7 |= v22;
            v10 = arg42;
        }
        else {
            v10 = arg42;
            if((v14 & v22) == 0) {
                v23 = v3.changed(v10) ? 0x20000 : 0x10000;
                v7 |= v23;
            }
        }

        v23 = v1 & 0x40;
        int v24 = 0x180000;
        if(v23 != 0) {
            v7 |= v24;
            v13 = arg43;
        }
        else {
            v13 = arg43;
            if((v14 & v24) == 0) {
                int v25 = v3.changed(v13) ? 0x100000 : 0x80000;
                v7 |= v25;
            }
        }

        int v2 = v1 & 0x80;
        int v26 = 0xC00000;
        if(v2 != 0) {
            v7 |= v26;
            goto label_128;
        }
        else if((v14 & v26) == 0) {
            v26 = v2;
            v27 = v3.changedInstance(arg44) ? 0x800000 : 0x400000;
            v7 |= v27;
        }
        else {
        label_128:
            v26 = v2;
        }

        v2 = v1 & 0x100;
        v27 = 0x6000000;
        if(v2 != 0) {
            v7 |= v27;
            goto label_146;
        }
        else if((v14 & v27) == 0) {
            v27 = v2;
            v28 = v3.changed(arg45) ? 0x4000000 : 0x2000000;
            v7 |= v28;
        }
        else {
        label_146:
            v27 = v2;
        }

        v2 = v1 & 0x200;
        v28 = 0x30000000;
        if(v2 != 0) {
            v7 |= v28;
            goto label_164;
        }
        else if((v14 & v28) == 0) {
            v28 = v2;
            v29 = v3.changed(arg46) ? 0x20000000 : 0x10000000;
            v7 |= v29;
        }
        else {
        label_164:
            v28 = v2;
        }

        v2 = v1 & 0x400;
        if(v2 != 0) {
            v18 = v15 | 6;
        }
        else if((v15 & 6) == 0) {
            boolean v29_1 = (v15 & 8) == 0 ? v3.changed(v0) : v3.changedInstance(v0);
            v18 = v29_1 ? 4 : 2;
            v18 |= v15;
        }
        else {
            v18 = v15;
        }

        int v0_1 = v1 & 0x800;
        if(v0_1 != 0) {
            v18 |= 0x30;
            v29 = v0_1;
        }
        else if((v15 & 0x30) == 0) {
            v29 = v0_1;
            v20 = v3.changed(arg48) ? 0x20 : 16;
            v18 |= v20;
        }
        else {
            v29 = v0_1;
        }

        v0_1 = v18;
        v18 = v2;
        v2 = v1 & 0x1000;
        if(v2 != 0) {
            v0_1 |= 0x180;
        }
        else {
            v20 = v0_1;
            if((v15 & 0x180) == 0) {
                if(v3.changed(arg49)) {
                    v16 = 0x100;
                }

                v0_1 = v20 | v16;
            }
            else {
                v0_1 = v20;
            }
        }

        v16 = v2;
        boolean v1_1 = (v7 & 306783379) != 306783378 || (v0_1 & 0x93) != 0x92 ? true : false;
        if(v3.shouldExecute(v1_1, v7 & 1)) {
            if(v8 != 0) {
                v36 = v17;
                v17_1 = Modifier.Companion;
                v1 = v36;
            }
            else {
                v1 = v17;
                Modifier v17_2 = v11;
            }

            v2 = v18;
            boolean v18_1 = v12 != 0 ? true : v5;
            DefaultConstructorMarker v5_1 = null;
            InputTransformation v20_1 = v1 != 0 ? ((InputTransformation)v5_1) : v6;
            if(v19 != 0) {
                v36 = v21;
                v21_1 = TextStyle.Companion.getDefault();
                v1 = v36;
            }
            else {
                v1 = v21;
                v21_1 = v9;
            }

            KeyboardOptions v22_1 = v1 != 0 ? KeyboardOptions.Companion.getSecureTextField$foundation() : v10;
            KeyboardActionHandler v23_1 = v23 != 0 ? ((KeyboardActionHandler)v5_1) : v13;
            Function2 v24_1 = v26 != 0 ? ((Function2)v5_1) : arg44;
            MutableInteractionSource v25_1 = v27 != 0 ? ((MutableInteractionSource)v5_1) : arg45;
            v1 = 1399310985;
            if(v28 != 0) {
                v26_1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), v5_1);
            }
            else {
                Brush v26_2 = arg46;
            }

            TextFieldDecorator v27_1 = v2 != 0 ? ((TextFieldDecorator)v5_1) : arg47;
            v28 = v29 != 0 ? TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0() : arg48;
            char v29_2 = v16 != 0 ? '•' : arg49;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v7, v0_1, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:363)");
            }

            v2 = v7 << 3;
            v0_1 <<= 3;
            v31 = v3;
            BasicSecureTextFieldKt.BasicSecureTextField-ltb6GB4(v4, ((Modifier)v17_1), v18_1, false, v20_1, v21_1, v22_1, v23_1, v24_1, v25_1, ((Brush)v26_1), v27_1, v28, v29_2, null, v31, v7 & 14 | 0xC00 | v7 & 0x70 | v7 & 0x380 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000, v7 >> 27 & 14 | v0_1 & 0x70 | v0_1 & 0x380 | v0_1 & 0x1C00, 0x4000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = v17_1;
            v3_1 = v18_1;
            v4_1 = v20_1;
            v5_2 = v21_1;
            v6_1 = v22_1;
            v7_1 = v23_1;
            v8_1 = v24_1;
            v9_1 = v25_1;
            v10_1 = v26_1;
            v11_1 = v27_1;
            v12 = v28;
            v13_1 = v29_2;
        }
        else {
            v31 = v3;
            v31.skipToGroupEnd();
            v8_1 = arg44;
            v12 = arg48;
            v3_1 = v5;
            v4_1 = v6;
            v5_2 = v9;
            v6_1 = v10;
            v2_2 = v11;
            v7_1 = v13;
            v9_1 = arg45;
            Brush v10_2 = arg46;
            v11_1 = arg47;
            v13_1 = arg49;
        }

        ScopeUpdateScope v0_2 = v31.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BasicSecureTextFieldKt$$ExternalSyntheticLambda2(arg37, v2_2, v3_1, v4_1, v5_2, v6_1, v7_1, v8_1, v9_1, ((Brush)v10_1), v11_1, v12, v13_1, v14, v15, arg53));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Please use the overload that takes in scrollState parameter.") public static final void BasicSecureTextField-egD4TGM(TextFieldState arg37, Modifier arg38, boolean arg39, boolean arg40, InputTransformation arg41, TextStyle arg42, KeyboardOptions arg43, KeyboardActionHandler arg44, Function2 arg45, MutableInteractionSource arg46, Brush arg47, TextFieldDecorator arg48, int arg49, char arg50, Composer arg51, int arg52, int arg53, int arg54) {
        Brush v11_2;
        char v14_1;
        TextFieldDecorator v12_1;
        MutableInteractionSource v10_1;
        Function2 v9_2;
        KeyboardActionHandler v8_1;
        KeyboardOptions v7_2;
        TextStyle v6_1;
        InputTransformation v5_1;
        boolean v3_2;
        Companion v2_1;
        boolean v4_1;
        Composer v31;
        Brush v26_2;
        int v7_1;
        TextStyle v21_1;
        InputTransformation v20_1;
        Companion v17_1;
        int v36;
        int v18;
        int v27;
        int v26;
        int v25;
        KeyboardOptions v11;
        int v21;
        TextStyle v10;
        int v19;
        InputTransformation v7;
        int v17;
        boolean v6;
        int v13;
        Modifier v12;
        int v8;
        TextFieldState v5;
        TextFieldDecorator v0 = arg48;
        int v15 = arg52;
        int v1 = arg53;
        int v2 = arg54;
        Composer v4 = arg51.startRestartGroup(0xCF45BBE5);
        ComposerKt.sourceInformation(v4, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)421@19275L21,406@18694L609:BasicSecureTextField.kt#423gt5");
        if((v15 & 6) == 0) {
            v5 = arg37;
            v8 = v4.changed(v5) ? 4 : 2;
            v8 |= v15;
        }
        else {
            v5 = arg37;
            v8 = v15;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
            goto label_35;
        }
        else if((v15 & 0x30) == 0) {
            v12 = arg38;
            v13 = v4.changed(v12) ? 0x20 : 16;
            v8 |= v13;
        }
        else {
        label_35:
            v12 = arg38;
        }

        v13 = v2 & 4;
        int v16 = 0x80;
        if(v13 != 0) {
            v8 |= 0x180;
            goto label_51;
        }
        else if((v15 & 0x180) == 0) {
            v6 = arg39;
            v17 = v4.changed(v6) ? 0x100 : v16;
            v8 |= v17;
        }
        else {
        label_51:
            v6 = arg39;
        }

        v17 = v2 & 16;
        if(v17 != 0) {
            v8 |= 0x6000;
            goto label_66;
        }
        else if((v15 & 0x6000) == 0) {
            v7 = arg41;
            v19 = v4.changed(v7) ? 0x4000 : 0x2000;
            v8 |= v19;
        }
        else {
        label_66:
            v7 = arg41;
        }

        v19 = v2 & 0x20;
        int v20 = 0x30000;
        if(v19 != 0) {
            v8 |= v20;
            v10 = arg42;
        }
        else {
            v10 = arg42;
            if((v15 & v20) == 0) {
                v21 = v4.changed(v10) ? 0x20000 : 0x10000;
                v8 |= v21;
            }
        }

        v21 = v2 & 0x40;
        int v22 = 0x180000;
        if(v21 != 0) {
            v8 |= v22;
            v11 = arg43;
        }
        else {
            v11 = arg43;
            if((v15 & v22) == 0) {
                int v23 = v4.changed(v11) ? 0x100000 : 0x80000;
                v8 |= v23;
            }
        }

        int v14 = v2 & 0x80;
        int v24 = 0xC00000;
        if(v14 != 0) {
            v8 |= v24;
        }
        else {
            KeyboardActionHandler v3 = arg44;
            if((v15 & v24) == 0) {
                v25 = v4.changed(v3) ? 0x800000 : 0x400000;
                v8 |= v25;
            }
        }

        int v3_1 = v2 & 0x100;
        v25 = 0x6000000;
        if(v3_1 != 0) {
            v8 |= v25;
            goto label_128;
        }
        else if((v15 & v25) == 0) {
            v25 = v3_1;
            v26 = v4.changedInstance(arg45) ? 0x4000000 : 0x2000000;
            v8 |= v26;
        }
        else {
        label_128:
            v25 = v3_1;
        }

        v3_1 = v2 & 0x200;
        v26 = 0x30000000;
        if(v3_1 != 0) {
            v8 |= v26;
            goto label_146;
        }
        else if((v15 & v26) == 0) {
            v26 = v3_1;
            v27 = v4.changed(arg46) ? 0x20000000 : 0x10000000;
            v8 |= v27;
        }
        else {
        label_146:
            v26 = v3_1;
        }

        v3_1 = v2 & 0x400;
        if(v3_1 != 0) {
            v18 = v1 | 6;
            v27 = v3_1;
        }
        else if((v1 & 6) == 0) {
            v27 = v3_1;
            v18 = v4.changed(arg47) ? 4 : 2;
            v18 |= v1;
        }
        else {
            v27 = v3_1;
            v18 = v1;
        }

        v3_1 = v2 & 0x800;
        if(v3_1 != 0) {
            v18 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            boolean v28 = (v1 & 0x40) == 0 ? v4.changed(v0) : v4.changedInstance(v0);
            v20 = v28 ? 0x20 : 16;
            v18 |= v20;
        }

        int v0_1 = v18;
        v18 = v3_1;
        v3_1 = v2 & 0x1000;
        if(v3_1 != 0) {
            v0_1 |= 0x180;
        }
        else {
            v20 = v0_1;
            if((v1 & 0x180) == 0) {
                if(v4.changed(arg49)) {
                    v16 = 0x100;
                }

                v0_1 = v20 | v16;
            }
            else {
                v0_1 = v20;
            }
        }

        v16 = v3_1;
        v3_1 = v2 & 0x2000;
        if(v3_1 != 0) {
            v0_1 |= 0xC00;
        }
        else {
            v20 = v0_1;
            if((v1 & 0xC00) == 0) {
                v22 = v4.changed(arg50) ? 0x800 : 0x400;
                v20 |= v22;
            }

            v0_1 = v20;
        }

        v20 = v3_1;
        boolean v1_1 = (v8 & 0x12492093) != 0x12492092 || (v0_1 & 0x493) != 1170 ? true : false;
        if(v4.shouldExecute(v1_1, v8 & 1)) {
            if(v9 != 0) {
                v36 = v17;
                v17_1 = Modifier.Companion;
                v1 = v36;
            }
            else {
                v1 = v17;
                Modifier v17_2 = v12;
            }

            v2 = v18;
            boolean v18_1 = v13 != 0 ? true : v6;
            v6 = (arg54 & 8) != 0 ? false : arg40;
            DefaultConstructorMarker v9_1 = null;
            if(v1 != 0) {
                v1 = v20;
                v20_1 = ((InputTransformation)v9_1);
            }
            else {
                v1 = v20;
                v20_1 = v7;
            }

            if(v19 != 0) {
                v36 = v21;
                v21_1 = TextStyle.Companion.getDefault();
                v7_1 = v36;
            }
            else {
                v7_1 = v21;
                v21_1 = v10;
            }

            KeyboardOptions v22_1 = v7_1 != 0 ? KeyboardOptions.Companion.getSecureTextField$foundation() : v11;
            KeyboardActionHandler v23_1 = v14 != 0 ? ((KeyboardActionHandler)v9_1) : arg44;
            Function2 v24_1 = v25 != 0 ? ((Function2)v9_1) : arg45;
            v7_1 = 0xCF45BBE5;
            MutableInteractionSource v25_1 = v26 != 0 ? ((MutableInteractionSource)v9_1) : arg46;
            if(v27 != 0) {
                SolidColor v26_1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), v9_1);
            }
            else {
                v26_2 = arg47;
            }

            TextFieldDecorator v27_1 = v2 != 0 ? ((TextFieldDecorator)v9_1) : arg48;
            int v28_1 = v16 != 0 ? TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0() : arg49;
            char v29 = v1 != 0 ? '•' : arg50;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v7_1, v8, v0_1, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:405)");
            }

            v31 = v4;
            BasicSecureTextFieldKt.BasicSecureTextField-ltb6GB4(v5, ((Modifier)v17_1), v18_1, false, v20_1, v21_1, v22_1, v23_1, v24_1, v25_1, v26_2, v27_1, v28_1, v29, ScrollKt.rememberScrollState(0, v4, 0, 1), v31, v8 & 14 | 0xC00 | v8 & 0x70 | v8 & 0x380 | 0xE000 & v8 | 0x70000 & v8 | 0x380000 & v8 | 0x1C00000 & v8 | 0xE000000 & v8 | 0x70000000 & v8, v0_1 & 0x1FFE, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4_1 = v6;
            v2_1 = v17_1;
            v3_2 = v18_1;
            v5_1 = v20_1;
            v6_1 = v21_1;
            v7_2 = v22_1;
            v8_1 = v23_1;
            v9_2 = v24_1;
            v10_1 = v25_1;
            SolidColor v11_1 = ((SolidColor)v26_2);
            v12_1 = v27_1;
            v13 = v28_1;
            v14_1 = v29;
        }
        else {
            v31 = v4;
            v31.skipToGroupEnd();
            v4_1 = arg40;
            v8_1 = arg44;
            v9_2 = arg45;
            v13 = arg49;
            v14_1 = arg50;
            v3_2 = v6;
            v5_1 = v7;
            v6_1 = v10;
            v7_2 = v11;
            Modifier v2_2 = v12;
            v10_1 = arg46;
            v11_2 = arg47;
            v12_1 = arg48;
        }

        ScopeUpdateScope v0_2 = v31.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new BasicSecureTextFieldKt$$ExternalSyntheticLambda0(arg37, ((Modifier)v2_1), v3_2, v4_1, v5_1, v6_1, v7_2, v8_1, v9_2, v10_1, v11_2, v12_1, v13, v14_1, v15, arg53, arg54));
        }
    }

    public static final void BasicSecureTextField-ltb6GB4(TextFieldState arg35, Modifier arg36, boolean arg37, boolean arg38, InputTransformation arg39, TextStyle arg40, KeyboardOptions arg41, KeyboardActionHandler arg42, Function2 arg43, MutableInteractionSource arg44, Brush arg45, TextFieldDecorator arg46, int arg47, char arg48, ScrollState arg49, Composer arg50, int arg51, int arg52, int arg53) {
        ScrollState v15_2;
        TextFieldDecorator v12_3;
        Brush v11_1;
        MutableInteractionSource v10_2;
        Function2 v9_6;
        KeyboardActionHandler v8_2;
        TextStyle v6_2;
        boolean v4_3;
        boolean v3_1;
        InputTransformation v5_1;
        int v13_1;
        Composer v0_9;
        char v14_5;
        Modifier v2_6;
        BasicSecureTextFieldKt$$ExternalSyntheticLambda4 v0_7;
        BasicSecureTextFieldKt$$ExternalSyntheticLambda3 v0_6;
        BasicSecureTextFieldKt$BasicSecureTextField$2$1 v0_4;
        char v37_2;
        boolean v14_4;
        BasicSecureTextFieldKt$BasicSecureTextField$1$1 v14_3;
        int v8_1;
        boolean v15_1;
        TextStyle v0_2;
        Modifier v1_3;
        boolean v16_1;
        ScrollState v25_1;
        char v2_2;
        TextFieldDecorator v24;
        Brush v22_1;
        MutableInteractionSource v21_1;
        Function2 v20_1;
        KeyboardActionHandler v19_1;
        SolidColor v22_2;
        SolidColor v4_1;
        boolean v36;
        KeyboardOptions v37;
        int v20;
        int v16;
        int v32;
        int v31;
        KeyboardOptions v7;
        int v27;
        TextStyle v15;
        int v25;
        InputTransformation v11;
        int v21;
        boolean v10;
        int v17;
        boolean v8;
        int v14;
        Modifier v12;
        int v6;
        TextFieldDecorator v0 = arg46;
        int v1 = arg51;
        int v2 = arg52;
        int v3 = arg53;
        Composer v5 = arg50.startRestartGroup(1568790509);
        ComposerKt.sourceInformation(v5, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,scrollState)140@8345L46,141@8428L60,142@8535L130,142@8493L172,155@9098L129,155@9059L168,162@9271L424,176@9771L38,177@9841L288,191@10367L891,191@10352L906:BasicSecureTextField.kt#423gt5");
        TextFieldState v13 = arg35;
        if((v1 & 6) == 0) {
            v6 = v5.changed(v13) ? 4 : 2;
            v6 |= v1;
        }
        else {
            v6 = v1;
        }

        int v9 = v3 & 2;
        if(v9 != 0) {
            v6 |= 0x30;
            goto label_34;
        }
        else if((v1 & 0x30) == 0) {
            v12 = arg36;
            v14 = v5.changed(v12) ? 0x20 : 16;
            v6 |= v14;
        }
        else {
        label_34:
            v12 = arg36;
        }

        v14 = v3 & 4;
        if(v14 != 0) {
            v6 |= 0x180;
            goto label_49;
        }
        else if((v1 & 0x180) == 0) {
            v8 = arg37;
            v17 = v5.changed(v8) ? 0x100 : 0x80;
            v6 |= v17;
        }
        else {
        label_49:
            v8 = arg37;
        }

        v17 = v3 & 8;
        int v18 = 0x800;
        int v19 = 0x400;
        if(v17 != 0) {
            v6 |= 0xC00;
            goto label_66;
        }
        else if((v1 & 0xC00) == 0) {
            v10 = arg38;
            v21 = v5.changed(v10) ? v18 : v19;
            v6 |= v21;
        }
        else {
        label_66:
            v10 = arg38;
        }

        v21 = v3 & 16;
        int v22 = 0x2000;
        int v23 = 0x4000;
        if(v21 != 0) {
            v6 |= 0x6000;
            goto label_83;
        }
        else if((v1 & 0x6000) == 0) {
            v11 = arg39;
            v25 = v5.changed(v11) ? v23 : v22;
            v6 |= v25;
        }
        else {
        label_83:
            v11 = arg39;
        }

        v25 = v3 & 0x20;
        int v26 = 0x30000;
        if(v25 != 0) {
            v6 |= v26;
            v15 = arg40;
        }
        else {
            v15 = arg40;
            if((v1 & v26) == 0) {
                v27 = v5.changed(v15) ? 0x20000 : 0x10000;
                v6 |= v27;
            }
        }

        v27 = v3 & 0x40;
        int v28 = 0x180000;
        if(v27 != 0) {
            v6 |= v28;
            v7 = arg41;
        }
        else {
            v7 = arg41;
            if((v1 & v28) == 0) {
                int v29 = v5.changed(v7) ? 0x100000 : 0x80000;
                v6 |= v29;
            }
        }

        int v4 = v3 & 0x80;
        int v30 = 0xC00000;
        if(v4 != 0) {
            v6 |= v30;
        }
        else {
            v30 &= v1;
            KeyboardActionHandler v1_1 = arg42;
            if(v30 == 0) {
                v30 = v5.changed(v1_1) ? 0x800000 : 0x400000;
                v6 |= v30;
            }
        }

        v1 = v3 & 0x100;
        v30 = 0x6000000;
        if(v1 != 0) {
            v6 |= v30;
            goto label_145;
        }
        else if((arg51 & v30) == 0) {
            v30 = v1;
            v31 = v5.changedInstance(arg43) ? 0x4000000 : 0x2000000;
            v6 |= v31;
        }
        else {
        label_145:
            v30 = v1;
        }

        v1 = v3 & 0x200;
        v31 = 0x30000000;
        if(v1 != 0) {
            v6 |= v31;
            goto label_163;
        }
        else if((arg51 & v31) == 0) {
            v31 = v1;
            v32 = v5.changed(arg44) ? 0x20000000 : 0x10000000;
            v6 |= v32;
        }
        else {
        label_163:
            v31 = v1;
        }

        v1 = v3 & 0x400;
        if(v1 != 0) {
            v16 = v2 | 6;
            v32 = v1;
        }
        else if((v2 & 6) == 0) {
            v32 = v1;
            v16 = v5.changed(arg45) ? 4 : 2;
            v16 |= v2;
        }
        else {
            v32 = v1;
            v16 = v2;
        }

        v1 = v3 & 0x800;
        if(v1 != 0) {
            v16 |= 0x30;
        }
        else if((v2 & 0x30) == 0) {
            boolean v33 = (v2 & 0x40) == 0 ? v5.changed(v0) : v5.changedInstance(v0);
            v20 = v33 ? 0x20 : 16;
            v16 |= v20;
        }

        if((v2 & 0x180) == 0) {
            v26 = (v3 & 0x1000) != 0 || !v5.changed(arg47) ? 0x80 : 0x100;
            v16 |= v26;
        }

        int v0_1 = v16;
        v16 = v1;
        v1 = v3 & 0x2000;
        if(v1 != 0) {
            v18 = v0_1 | 0xC00;
        }
        else {
            v20 = v0_1;
            if((v2 & 0xC00) == 0) {
                if(v5.changed(arg48)) {
                }
                else {
                    v18 = v19;
                }

                v18 |= v20;
            }
            else {
                v18 = v20;
            }
        }

        if((v2 & 0x6000) == 0) {
            if((v3 & 0x4000) == 0 && (v5.changed(arg49))) {
                v22 = v23;
            }

            v18 |= v22;
        }

        v0_1 = v18;
        v19 = v1;
        v18 = v4;
        boolean v1_2 = (v6 & 306783379) != 306783378 || (v0_1 & 9363) != 9362 ? true : false;
        if(v5.shouldExecute(v1_2, v6 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "138@8287L21");
            DefaultConstructorMarker v2_1 = null;
            if((arg51 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v1_4 = Modifier.Companion;
                }
                else {
                    v1_3 = v12;
                }

                if(v14 != 0) {
                    v8 = true;
                }

                if(v17 != 0) {
                    v10 = false;
                }

                if(v21 != 0) {
                    v11 = ((InputTransformation)v2_1);
                }

                if(v25 != 0) {
                    v15 = TextStyle.Companion.getDefault();
                }

                if(v27 != 0) {
                    v7 = KeyboardOptions.Companion.getSecureTextField$foundation();
                }

                KeyboardActionHandler v9_1 = v18 != 0 ? ((KeyboardActionHandler)v2_1) : arg42;
                Function2 v12_1 = v30 != 0 ? ((Function2)v2_1) : arg43;
                MutableInteractionSource v14_1 = v31 != 0 ? ((MutableInteractionSource)v2_1) : arg44;
                if(v32 != 0) {
                    v37 = v7;
                    v36 = v8;
                    v4_1 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), v2_1);
                }
                else {
                    v37 = v7;
                    v36 = v8;
                    Brush v4_2 = arg45;
                }

                TextFieldDecorator v7_1 = v16 != 0 ? ((TextFieldDecorator)v2_1) : arg46;
                if((v3 & 0x1000) != 0) {
                    v8_1 = TextObfuscationMode_androidKt.getDefault(TextObfuscationMode.Companion);
                    v0_1 &= -897;
                }
                else {
                    v8_1 = arg47;
                }

                char v16_2 = v19 != 0 ? '•' : arg48;
                int v38 = v0_1;
                if((v3 & 0x4000) != 0) {
                    v22_2 = v4_1;
                    v24 = v7_1;
                    v20_1 = v12_1;
                    v21_1 = v14_1;
                    v2_2 = v16_2;
                    v25_1 = ScrollKt.rememberScrollState(0, v5, 0, 1);
                    v7 = v37;
                    v4 = v38 & 0xFFFF1FFF;
                    v19_1 = v9_1;
                    v16_1 = v10;
                    v0_2 = v15;
                    v15_1 = v36;
                    goto label_384;
                }

                v25_1 = arg49;
                v22_2 = v4_1;
                v24 = v7_1;
                v19_1 = v9_1;
                v20_1 = v12_1;
                v21_1 = v14_1;
                v0_2 = v15;
                v2_2 = v16_2;
                v15_1 = v36;
                v7 = v37;
                v4 = v38;
                v16_1 = v10;
            }
            else {
                v5.skipToGroupEnd();
                if((v3 & 0x1000) != 0) {
                    v0_1 &= -897;
                }

                if((v3 & 0x4000) != 0) {
                    v0_1 &= 0xFFFF1FFF;
                }

                v19_1 = arg42;
                v20_1 = arg43;
                v21_1 = arg44;
                v22_1 = arg45;
                v24 = arg46;
                v2_2 = arg48;
                v25_1 = arg49;
                v4 = v0_1;
                v16_1 = v10;
                v1_3 = v12;
                v0_2 = v15;
                v15_1 = v8;
                v8_1 = arg47;
            }

        label_384:
            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1568790509, v6, v4, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:139)");
            }

            State v6_1 = SnapshotStateKt.rememberUpdatedState(Character.valueOf(v2_2), v5, v4 >> 9 & 14);
            String v10_1 = "CC(remember):BasicSecureTextField.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v5, 74191401, v10_1);
            Object v9_2 = v5.rememberedValue();
            if(v9_2 == Composer.Companion.getEmpty()) {
                SecureTextFieldController v9_3 = new SecureTextFieldController(v6_1);
                v5.updateRememberedValue(v9_3);
            }

            Object v12_2 = v9_2;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x46C1FCF, v10_1);
            boolean v9_4 = v5.changedInstance(v12_2);
            Object v14_2 = v5.rememberedValue();
            if((v9_4) || v14_2 == Composer.Companion.getEmpty()) {
                v14_3 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(((SecureTextFieldController)v12_2), null);
                v5.updateRememberedValue(v14_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            EffectsKt.LaunchedEffect(v12_2, ((Function2)v14_3), v5, 0);
            if(TextObfuscationMode.equals-impl0(v8_1, TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0())) {
                v5.startReplaceGroup(74207180);
                ComposerKt.sourceInformation(v5, "152@8922L31");
                v14_4 = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped(v5, 0);
                v5.endReplaceGroup();
            }
            else {
                v5.startReplaceGroup(0x891DAE89);
                v5.endReplaceGroup();
                v14_4 = false;
            }

            Boolean v9_5 = Boolean.valueOf(v14_4);
            TextStyle v36_1 = v0_2;
            ComposerKt.sourceInformationMarkerStart(v5, 74212910, v10_1);
            int v37_1 = v5.changed(v14_4) | v5.changedInstance(v12_2);
            Object v0_3 = v5.rememberedValue();
            if(v37_1 == 0) {
                v37_2 = v2_2;
                if(v0_3 == Composer.Companion.getEmpty()) {
                    goto label_453;
                }
            }
            else {
                v37_2 = v2_2;
            label_453:
                v0_4 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(v14_4, ((SecureTextFieldController)v12_2), null);
                v5.updateRememberedValue(v0_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            EffectsKt.LaunchedEffect(v9_5, ((Function2)v0_4), v5, 0);
            ComposerKt.sourceInformationMarkerStart(v5, 0x46C7CF5, v10_1);
            v2 = 0x100;
            v0_1 = (v4 & 0x380 ^ 0x180) > v2 && (v5.changed(v8_1)) || (v4 & 0x180) == v2 ? 1 : 0;
            Object v2_3 = v5.rememberedValue();
            if(v0_1 != 0 || v2_3 == Composer.Companion.getEmpty()) {
                if(TextObfuscationMode.equals-impl0(v8_1, TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0())) {
                    CodepointTransformation v0_5 = ((SecureTextFieldController)v12_2).getCodepointTransformation();
                }
                else if(TextObfuscationMode.equals-impl0(v8_1, TextObfuscationMode.Companion.getHidden-vTwcZD0())) {
                    v0_6 = new BasicSecureTextFieldKt$$ExternalSyntheticLambda3(v6_1);
                }
                else {
                    v0_3 = null;
                }

                v5.updateRememberedValue(v0_6);
                CodepointTransformation v2_4 = ((CodepointTransformation)v0_6);
            }

            Object v23_1 = v2_3;
            ComposerKt.sourceInformationMarkerEnd(v5);
            ComposerKt.sourceInformationMarkerStart(v5, 0x46CB9F3, v10_1);
            v0_3 = v5.rememberedValue();
            if(v0_3 == Composer.Companion.getEmpty()) {
                v0_7 = new BasicSecureTextFieldKt$$ExternalSyntheticLambda4();
                v5.updateRememberedValue(v0_7);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            Modifier v0_8 = SemanticsModifierKt.semantics$default(v1_3, false, ((Function1)v0_7), 1, null);
            ComposerKt.sourceInformationMarkerStart(v5, 0x46CC3AD, v10_1);
            v2_3 = v5.rememberedValue();
            if(v2_3 == Composer.Companion.getEmpty()) {
                BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1 v2_5 = BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1.INSTANCE;
                v5.updateRememberedValue(v2_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            v0_8 = KeyInputModifierKt.onPreviewKeyEvent(v0_8, ((Function1)v2_3));
            if(v14_4) {
                v2_6 = ((SecureTextFieldController)v12_2).getFocusChangeModifier();
            }
            else {
                Companion v2_7 = Modifier.Companion;
            }

            TextStyle v17_1 = v36_1;
            KeyboardOptions v18_1 = v7;
            BasicSecureTextFieldKt.DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(0x80E3211, true, new BasicSecureTextFieldKt$$ExternalSyntheticLambda5(v14_4, v11, ((SecureTextFieldController)v12_2), v13, v0_8.then(v2_6), v15_1, v16_1, v17_1, v18_1, v19_1, v20_1, v21_1, v22_1, ((CodepointTransformation)v23_1), v24, v25_1), v5, 54), v5, 6);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v14_5 = v37_2;
            v2_6 = v1_3;
            v0_9 = v5;
            v13_1 = v8_1;
            v5_1 = v11;
            v3_1 = v15_1;
            v4_3 = v16_1;
            v6_2 = v17_1;
            v7 = v18_1;
            v8_2 = v19_1;
            v9_6 = v20_1;
            v10_2 = v21_1;
            v11_1 = v22_1;
            v12_3 = v24;
            v15_2 = v25_1;
        }
        else {
            v5.skipToGroupEnd();
            v9_6 = arg43;
            v13_1 = arg47;
            v14_5 = arg48;
            v0_9 = v5;
            v3_1 = v8;
            v4_3 = v10;
            v5_1 = v11;
            v2_6 = v12;
            v6_2 = v15;
            v8_2 = arg42;
            v10_2 = arg44;
            v11_1 = arg45;
            v12_3 = arg46;
            v15_2 = arg49;
        }

        ScopeUpdateScope v0_10 = v0_9.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new BasicSecureTextFieldKt$$ExternalSyntheticLambda6(arg35, v2_6, v3_1, v4_3, v5_1, v6_2, v7, v8_2, v9_6, v10_2, v11_1, v12_3, v13_1, v14_5, v15_2, arg51, arg52, arg53));
        }
    }

    static final Unit BasicSecureTextField_Jb9bMDk$lambda$0(TextFieldState arg18, Modifier arg19, boolean arg20, InputTransformation arg21, TextStyle arg22, KeyboardOptions arg23, KeyboardActionHandler arg24, Function2 arg25, MutableInteractionSource arg26, Brush arg27, TextFieldDecorator arg28, int arg29, char arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        BasicSecureTextFieldKt.BasicSecureTextField-Jb9bMDk(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_egD4TGM$lambda$0(TextFieldState arg19, Modifier arg20, boolean arg21, boolean arg22, InputTransformation arg23, TextStyle arg24, KeyboardOptions arg25, KeyboardActionHandler arg26, Function2 arg27, MutableInteractionSource arg28, Brush arg29, TextFieldDecorator arg30, int arg31, char arg32, int arg33, int arg34, int arg35, Composer arg36, int arg37) {
        BasicSecureTextFieldKt.BasicSecureTextField-egD4TGM(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg36, RecomposeScopeImplKt.updateChangedFlags(arg33 | 1), RecomposeScopeImplKt.updateChangedFlags(arg34), arg35);
        return Unit.INSTANCE;
    }

    private static final int BasicSecureTextField_ltb6GB4$lambda$3$0(State arg0, int arg1, int arg2) {
        return arg0.getValue().charValue();
    }

    private static final Unit BasicSecureTextField_ltb6GB4$lambda$4$0(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setContentType(arg1, ContentType.Companion.getPassword());
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_ltb6GB4$lambda$6(boolean arg21, InputTransformation arg22, SecureTextFieldController arg23, TextFieldState arg24, Modifier arg25, boolean arg26, boolean arg27, TextStyle arg28, KeyboardOptions arg29, KeyboardActionHandler arg30, Function2 arg31, MutableInteractionSource arg32, Brush arg33, CodepointTransformation arg34, TextFieldDecorator arg35, ScrollState arg36, Composer arg37, int arg38) {
        Composer v0 = arg37;
        int v1 = arg38;
        ComposerKt.sourceInformation(v0, "C192@10377L875:BasicSecureTextField.kt#423gt5");
        boolean v2 = (v1 & 3) != 2 ? true : false;
        if(v0.shouldExecute(v2, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x80E3211, v1, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:192)");
            }

            InputTransformation v4 = arg21 ? BasicSecureTextFieldKt.then(arg22, arg23.getPasswordInputTransformation()) : arg22;
            BasicTextFieldKt.BasicTextField(arg24, arg25, arg26, arg27, v4, arg28, arg29, arg30, SingleLine.INSTANCE, arg31, arg32, arg33, arg34, null, arg35, arg36, true, v0, 0x6000000, 0x180000, 0x2000);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_54;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg37.skipToGroupEnd();
        }

    label_54:
        return Unit.INSTANCE;
    }

    static final Unit BasicSecureTextField_ltb6GB4$lambda$7(TextFieldState arg20, Modifier arg21, boolean arg22, boolean arg23, InputTransformation arg24, TextStyle arg25, KeyboardOptions arg26, KeyboardActionHandler arg27, Function2 arg28, MutableInteractionSource arg29, Brush arg30, TextFieldDecorator arg31, int arg32, char arg33, ScrollState arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        BasicSecureTextFieldKt.BasicSecureTextField-ltb6GB4(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    private static final void DisableCutCopy(Function2 arg4, Composer arg5, int arg6) {
        BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1 v3_1;
        int v1;
        int v0 = 0x4404F003;
        arg5 = arg5.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(DisableCutCopy)N(content)312@14862L7,314@14908L877,335@15790L80:BasicSecureTextField.kt#423gt5");
        int v2 = 2;
        if((arg6 & 6) == 0) {
            v1 = arg5.changedInstance(arg4) ? 4 : v2;
            v1 |= arg6;
        }
        else {
            v1 = arg6;
        }

        boolean v2_1 = (v1 & 3) != v2 ? true : false;
        if(arg5.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:311)");
            }

            ProvidableCompositionLocal v0_1 = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(arg5, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v0_2 = arg5.consume(((CompositionLocal)v0_1));
            ComposerKt.sourceInformationMarkerEnd(arg5);
            ComposerKt.sourceInformationMarkerStart(arg5, 0x56891070, "CC(remember):BasicSecureTextField.kt#9igjgp");
            v2_1 = arg5.changed(v0_2);
            Object v3 = arg5.rememberedValue();
            if((v2_1) || v3 == Composer.Companion.getEmpty()) {
                v3_1 = new BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1(((TextToolbar)v0_2));
                arg5.updateRememberedValue(v3_1);
            }

            ComposerKt.sourceInformationMarkerEnd(arg5);
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides(v3_1), arg4, arg5, v1 << 3 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_59;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg5.skipToGroupEnd();
        }

    label_59:
        ScopeUpdateScope v5 = arg5.endRestartGroup();
        if(v5 != null) {
            v5.updateScope(new BasicSecureTextFieldKt$$ExternalSyntheticLambda1(arg4, arg6));
        }
    }

    static final Unit DisableCutCopy$lambda$1(Function2 arg0, int arg1, Composer arg2, int arg3) {
        BasicSecureTextFieldKt.DisableCutCopy(arg0, arg2, RecomposeScopeImplKt.updateChangedFlags(arg1 | 1));
        return Unit.INSTANCE;
    }

    private static final InputTransformation then(InputTransformation arg0, InputTransformation arg1) {
        if(arg0 == null) {
            return arg1;
        }

        if(arg1 == null) {
            return arg0;
        }

        return InputTransformationKt.then(arg0, arg1);
    }
}

