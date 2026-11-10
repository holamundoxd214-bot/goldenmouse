package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000\u008C\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u008F\u0003\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2 \b\u0002\u0010\f\u001A\u001A\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\b\b\u0002\u0010\u0018\u001A\u00020\u00072\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"28\b\u0002\u0010#\u001A2\u0012\u0004\u0012\u00020%\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020/2\n\b\u0002\u00100\u001A\u0004\u0018\u000101H\u0007¢\u0006\u0004\b2\u00103\u001A\u008F\u0003\u00104\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2 \b\u0002\u0010\f\u001A\u001A\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u000F2\b\b\u0002\u0010\u0018\u001A\u00020\u00072\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 2\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\"28\b\u0002\u0010#\u001A2\u0012\u0004\u0012\u00020%\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010&0\u0012¢\u0006\f\b\'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u0001\u0018\u00010$¢\u0006\u0002\b\u00102\b\b\u0002\u0010*\u001A\u00020+2\b\b\u0002\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020/2\n\b\u0002\u00100\u001A\u0004\u0018\u000101H\u0007¢\u0006\u0004\b5\u00103\"\u000E\u00106\u001A\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u00107\u001A\u00020\u001EX\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2={"SecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SecureTextField-XvU6IwQ", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;ICLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedSecureTextField", "OutlinedSecureTextField-XvU6IwQ", "SecureTextFieldKeyboardOptions", "DefaultObfuscationCharacter", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = '•';
    private static final KeyboardOptions SecureTextFieldKeyboardOptions;

    static {
        SecureTextFieldKt.SecureTextFieldKeyboardOptions = new KeyboardOptions(0, Boolean.valueOf(false), KeyboardType.Companion.getPassword-PjHm6EE(), 0, null, null, null, 0x79, null);
    }

    public static final void OutlinedSecureTextField-XvU6IwQ(TextFieldState arg65, Modifier arg66, boolean arg67, TextStyle arg68, TextFieldLabelPosition arg69, Function3 arg70, Function2 arg71, Function2 arg72, Function2 arg73, Function2 arg74, Function2 arg75, Function2 arg76, boolean arg77, InputTransformation arg78, int arg79, char arg80, KeyboardOptions arg81, KeyboardActionHandler arg82, Function2 arg83, Shape arg84, TextFieldColors arg85, PaddingValues arg86, MutableInteractionSource arg87, Composer arg88, int arg89, int arg90, int arg91, int arg92) {
        KeyboardOptions v17_3;
        Function2 v7_2;
        TextStyle v4_1;
        Composer v0_11;
        MutableInteractionSource v23_3;
        PaddingValues v22_2;
        boolean v13_2;
        TextFieldColors v21_3;
        Shape v20_2;
        char v16_3;
        KeyboardActionHandler v18_3;
        InputTransformation v14_1;
        Function2 v11_3;
        Function2 v10_1;
        Function2 v9_3;
        boolean v3_1;
        TextFieldLabelPosition v5_1;
        Function3 v6_2;
        Modifier v2_4;
        Object v16_1;
        MutableInteractionSource v1_2;
        TextFieldColors v13_1;
        Function2 v17_1;
        MutableInteractionSource v0_10;
        PaddingValues v23_1;
        Shape v31_1;
        Function2 v28_1;
        KeyboardActionHandler v27_1;
        KeyboardOptions v26_1;
        char v30_1;
        InputTransformation v24_1;
        boolean v12_1;
        Function2 v22_1;
        Function2 v21_1;
        Function2 v20_1;
        Function2 v19_1;
        Function2 v18_1;
        boolean v15_1;
        Modifier v9_1;
        TextFieldLabelPosition v11_1;
        Shape v6_1;
        Function2 v12_2;
        Function2 v8_1;
        Object v7_1;
        Companion v11_2;
        TextFieldColors v0_6;
        int v36;
        int v35;
        int v34;
        int v33;
        int v32;
        int v31;
        Function2 v0_1;
        int v30;
        Function2 v13;
        int v23;
        Function3 v10;
        int v20;
        TextFieldLabelPosition v9;
        int v18;
        TextStyle v7;
        int v16;
        int v12;
        Modifier v11;
        TextFieldState v14;
        int v5;
        int v0 = arg89;
        int v1 = arg90;
        int v2 = arg91;
        int v3 = arg92;
        Composer v4 = arg88.startRestartGroup(0xEFB4B2F0);
        ComposerKt.sourceInformation(v4, "C(OutlinedSecureTextField)N(state,modifier,enabled,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,onTextLayout,shape,colors,contentPadding,interactionSource)326@19422L2745,326@19335L2832:SecureTextField.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
            v14 = arg65;
        }
        else {
            v14 = arg65;
            if((v0 & 6) == 0) {
                v5 = v4.changed(v14) ? 4 : 2;
                v5 |= v0;
            }
            else {
                v5 = v0;
            }
        }

        int v8 = v3 & 2;
        if(v8 != 0) {
            v5 |= 0x30;
            goto label_39;
        }
        else if((v0 & 0x30) == 0) {
            v11 = arg66;
            v12 = v4.changed(v11) ? 0x20 : 16;
            v5 |= v12;
        }
        else {
        label_39:
            v11 = arg66;
        }

        v12 = v3 & 4;
        if(v12 != 0) {
            v5 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            v16 = v4.changed(arg67) ? 0x100 : 0x80;
            v5 |= v16;
        }

        int v17 = 0x400;
        if((v0 & 0xC00) == 0) {
            if((v3 & 8) == 0) {
                v7 = arg68;
                if(v4.changed(v7)) {
                    v18 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v7 = arg68;
            label_66:
                v18 = v17;
            }

            v5 |= v18;
        }
        else {
            v7 = arg68;
        }

        int v19 = 0x4000;
        if((v0 & 0x6000) == 0) {
            if((v3 & 16) == 0) {
                v9 = arg69;
                if(v4.changed(v9)) {
                    v20 = v19;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v9 = arg69;
            label_81:
                v20 = 0x2000;
            }

            v5 |= v20;
        }
        else {
            v9 = arg69;
        }

        v20 = v3 & 0x20;
        int v21 = 0x30000;
        if(v20 != 0) {
            v5 |= v21;
            v10 = arg70;
        }
        else {
            v10 = arg70;
            if((v0 & v21) == 0) {
                v23 = v4.changedInstance(v10) ? 0x20000 : 0x10000;
                v5 |= v23;
            }
        }

        v23 = v3 & 0x40;
        int v24 = 0x100000;
        int v25 = 0x180000;
        int v26 = 0x80000;
        if(v23 != 0) {
            v5 |= v25;
            v13 = arg71;
        }
        else {
            v13 = arg71;
            if((v0 & v25) == 0) {
                int v28 = v4.changedInstance(v13) ? v24 : v26;
                v5 |= v28;
            }
        }

        int v15 = v3 & 0x80;
        int v29 = 0xC00000;
        if(v15 != 0) {
            v5 |= v29;
        }
        else {
            v30 = v0 & v29;
            v0_1 = arg72;
            if(v30 == 0) {
                v30 = v4.changedInstance(v0_1) ? 0x800000 : 0x400000;
                v5 |= v30;
            }
        }

        v0 = v3 & 0x100;
        v30 = 0x6000000;
        if(v0 != 0) {
            v5 |= v30;
            goto label_148;
        }
        else if((arg89 & v30) == 0) {
            v31 = v0;
            v32 = v4.changedInstance(arg73) ? 0x4000000 : 0x2000000;
            v5 |= v32;
        }
        else {
        label_148:
            v31 = v0;
        }

        v0 = v3 & 0x200;
        v32 = 0x30000000;
        if(v0 != 0) {
            v5 |= v32;
            goto label_166;
        }
        else if((arg89 & v32) == 0) {
            v32 = v0;
            v33 = v4.changedInstance(arg74) ? 0x20000000 : 0x10000000;
            v5 |= v33;
        }
        else {
        label_166:
            v32 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v34 = v1 | 6;
            v33 = v0;
        }
        else if((v1 & 6) == 0) {
            v33 = v0;
            v34 = v4.changedInstance(arg75) ? 4 : 2;
            v34 |= v1;
        }
        else {
            v33 = v0;
            v34 = v1;
        }

        v0 = v3 & 0x800;
        if(v0 != 0) {
            v34 |= 0x30;
            v35 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v35 = v0;
            v36 = v4.changedInstance(arg76) ? 0x20 : 16;
            v34 |= v36;
        }
        else {
            v35 = v0;
        }

        v0 = v34;
        int v6 = v3 & 0x1000;
        if(v6 != 0) {
            v0 |= 0x180;
        }
        else {
            v34 = v0;
            if((v1 & 0x180) == 0) {
                v36 = v4.changed(arg77) ? 0x100 : 0x80;
                v34 |= v36;
            }

            v0 = v34;
        }

        v34 = v6;
        v6 = v3 & 0x2000;
        if(v6 != 0) {
            v36 = v0 | 0xC00;
        }
        else {
            v36 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg78)) {
                    v17 = 0x800;
                }

                v36 |= v17;
            }
        }

        if((v1 & 0x6000) == 0) {
            if((v3 & 0x4000) != 0 || !v4.changed(arg79)) {
                v19 = 0x2000;
            }
            else {
            }

            v36 |= v19;
        }

        v17 = v3 & 0x8000;
        if(v17 != 0) {
            v36 |= v21;
        }
        else {
            char v0_2 = arg80;
            if((v1 & v21) == 0) {
                v19 = v4.changed(v0_2) ? 0x20000 : 0x10000;
                v36 |= v19;
            }
        }

        v19 = v3 & 0x10000;
        if(v19 != 0) {
            v36 |= v25;
        }
        else {
            KeyboardOptions v0_3 = arg81;
            if((v1 & v25) == 0) {
                v21 = v4.changed(v0_3) ? v24 : v26;
                v36 |= v21;
            }
        }

        v21 = v3 & 0x20000;
        if(v21 != 0) {
            v36 |= v29;
        }
        else {
            KeyboardActionHandler v0_4 = arg82;
            if((v1 & v29) == 0) {
                v25 = v4.changed(v0_4) ? 0x800000 : 0x400000;
                v36 |= v25;
            }
        }

        v25 = v3 & 0x40000;
        if(v25 != 0) {
            v36 |= v30;
        }
        else {
            v0_1 = arg83;
            if((v1 & v30) == 0) {
                v29 = v4.changedInstance(v0_1) ? 0x4000000 : 0x2000000;
                v36 |= v29;
            }
        }

        if((v1 & 0x30000000) == 0) {
            Shape v0_5 = arg84;
            v29 = (v3 & v26) != 0 || !v4.changed(v0_5) ? 0x10000000 : 0x20000000;
            v36 |= v29;
        }

        if((v2 & 6) == 0) {
            v0_6 = arg85;
            v16 = (v3 & v24) != 0 || !v4.changed(v0_6) ? 2 : 4;
            v16 |= v2;
        }
        else {
            v16 = v2;
        }

        if((v2 & 0x30) == 0) {
            PaddingValues v0_7 = arg86;
            int v22 = (v3 & 0x200000) != 0 || !v4.changed(v0_7) ? 16 : 0x20;
            v16 |= v22;
        }

        v0 = v16;
        v16 = v3 & 0x400000;
        if(v16 != 0) {
            v0 |= 0x180;
        }
        else {
            v18 = v0;
            if((v2 & 0x180) == 0) {
                int v27 = v4.changed(arg87) ? 0x100 : 0x80;
                v18 |= v27;
            }

            v0 = v18;
        }

        v18 = v6;
        boolean v0_8 = (v5 & 306783379) != 306783378 || (v36 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v0_8, v5 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "295@17703L7,311@18641L5,312@18704L8");
            v1 = 0xFFFF1FFF;
            if((arg89 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v11_2 = Modifier.Companion;
                }

                v0_8 = v12 != 0 ? true : arg67;
                if((v3 & 8) != 0) {
                    ProvidableCompositionLocal v2_1 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v2_2 = v4.consume(((CompositionLocal)v2_1));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v5 &= 0xFFFFE3FF;
                    v7_1 = v2_2;
                }

                if((v3 & 16) != 0) {
                    v5 &= v1;
                    Attached v9_2 = new Attached(false, null, null, 7, null);
                }

                if(v20 != 0) {
                    v10 = null;
                }

                if(v23 != 0) {
                    v13 = null;
                }

                v8_1 = v15 != 0 ? null : arg72;
                v12_2 = v31 != 0 ? null : arg73;
                Function2 v15_2 = v32 != 0 ? null : arg74;
                v20_1 = v33 != 0 ? null : arg75;
                v22_1 = v35 != 0 ? null : arg76;
                boolean v23_2 = v34 != 0 ? false : arg77;
                InputTransformation v18_2 = v18 != 0 ? null : arg78;
                int v88 = v1;
                if((v3 & 0x4000) != 0) {
                    v1 = TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0();
                    v36 &= v88;
                }
                else {
                    v1 = arg79;
                }

                char v17_2 = v17 != 0 ? '•' : arg80;
                KeyboardOptions v19_2 = v19 != 0 ? SecureTextFieldKt.SecureTextFieldKeyboardOptions : arg81;
                KeyboardActionHandler v21_2 = v21 != 0 ? null : arg82;
                Function2 v25_1 = v25 != 0 ? null : arg83;
                v2 = 6;
                if((v3 & v26) != 0) {
                    v6_1 = OutlinedTextFieldDefaults.INSTANCE.getShape(v4, v2);
                    v36 &= 0x8FFFFFFF;
                }
                else {
                    v6_1 = arg84;
                }

                arg67 = v0_8;
                v0_6 = (v3 & v24) != 0 ? OutlinedTextFieldDefaults.INSTANCE.colors(v4, v2) : arg85;
                PaddingValues v2_3 = (0x200000 & v3) != 0 ? OutlinedTextFieldDefaults.contentPadding-a9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null) : arg86;
                Modifier v24_2 = ((Modifier)v11_2);
                v11_1 = v9;
                v9_1 = v24_2;
                v29 = v1;
                v31_1 = v6_1;
                v30_1 = v17_2;
                v24_1 = v18_2;
                v26_1 = v19_2;
                v27_1 = v21_2;
                v28_1 = v25_1;
                v1 = v36;
                v18_1 = v8_1;
                v19_1 = v12_2;
                v17_1 = v13;
                v21_1 = v20_1;
                v12_1 = v23_2;
                v13_1 = v0_6;
                v23_1 = v2_3;
                v20_1 = v15_2;
                if(v16 != 0) {
                    v0_10 = null;
                    v15_1 = arg67;
                    goto label_588;
                }

                v15_1 = arg67;
                v0_10 = arg87;
            }
            else {
                v4.skipToGroupEnd();
                if((v3 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                }

                if((v3 & 16) != 0) {
                    v5 &= v1;
                }

                if((v3 & 0x4000) != 0) {
                    v36 &= v1;
                }

                if((v3 & v26) != 0) {
                    v36 &= 0x8FFFFFFF;
                }

                Modifier v0_9 = v11;
                v11_1 = v9;
                v9_1 = v0_9;
                v15_1 = arg67;
                v18_1 = arg72;
                v19_1 = arg73;
                v20_1 = arg74;
                v21_1 = arg75;
                v22_1 = arg76;
                v12_1 = arg77;
                v24_1 = arg78;
                v29 = arg79;
                v30_1 = arg80;
                v26_1 = arg81;
                v27_1 = arg82;
                v28_1 = arg83;
                v31_1 = arg84;
                v23_1 = arg86;
                v0_10 = arg87;
                v17_1 = v13;
                v1 = v36;
                v13_1 = arg85;
            }

        label_588:
            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xEFB4B2F0, v5, v1, "androidx.compose.material3.OutlinedSecureTextField (SecureTextField.kt:315)");
            }

            if(v0_10 == null) {
                v4.startReplaceGroup(0xD53912EB);
                ComposerKt.sourceInformation(v4, "317@18936L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0xD5546BF7, "CC(remember):SecureTextField.kt#9igjgp");
                Object v1_1 = v4.rememberedValue();
                if(v1_1 == Composer.Companion.getEmpty()) {
                    v1_2 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v1_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                v16_1 = v1_2;
            }
            else {
                v4.startReplaceGroup(0xD554696C);
                v4.endReplaceGroup();
                MutableInteractionSource v16_2 = v0_10;
            }

            v4.startReplaceGroup(0xD554814A);
            ComposerKt.sourceInformation(v4, "*321@19160L25");
            long v1_3 = ((TextStyle)v7_1).getColor-0d7_KjU();
            if(v1_3 != 16) {
            }
            else {
                v1_3 = v13_1.textColor-XeAY9LY$material3(v15_1, v12_1, FocusInteractionKt.collectIsFocusedAsState(v16_1, v4, 0).getValue().booleanValue());
            }

            v4.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(v13_1.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(1147500080, true, new SecureTextFieldKt$OutlinedSecureTextField$1(v9_1, v10, v11_1, v12_1, v13_1, v14, v15_1, ((MutableInteractionSource)v16_1), v17_1, v18_1, v19_1, v20_1, v21_1, v22_1, v23_1, v24_1, ((TextStyle)v7_1).merge(new TextStyle(v1_3, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null)), v26_1, v27_1, v28_1, v29, v30_1, v31_1), v4, 54), v4, ProvidedValue.$stable | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_4 = v9_1;
            v6_2 = v10;
            v5_1 = v11_1;
            v3_1 = v15_1;
            v8_1 = v18_1;
            v9_3 = v19_1;
            v10_1 = v20_1;
            v11_3 = v21_1;
            v14_1 = v24_1;
            v18_3 = v27_1;
            v19_1 = v28_1;
            v15 = v29;
            v16_3 = v30_1;
            v20_2 = v31_1;
            v21_3 = v13_1;
            v13_2 = v12_1;
            v12_2 = v22_1;
            v22_2 = v23_1;
            v23_3 = v0_10;
            v0_11 = v4;
            v4_1 = ((TextStyle)v7_1);
            v7_2 = v17_1;
            v17_3 = v26_1;
        }
        else {
            v4.skipToGroupEnd();
            v3_1 = arg67;
            v8_1 = arg72;
            v12_2 = arg76;
            v14_1 = arg78;
            v15 = arg79;
            v16_3 = arg80;
            v17_3 = arg81;
            v18_3 = arg82;
            v19_1 = arg83;
            v20_2 = arg84;
            v21_3 = arg85;
            v22_2 = arg86;
            v23_3 = arg87;
            v0_11 = v4;
            v4_1 = v7;
            v5_1 = v9;
            v6_2 = v10;
            v2_4 = v11;
            v7_2 = v13;
            v9_3 = arg73;
            v10_1 = arg74;
            v11_3 = arg75;
            v13_2 = arg77;
        }

        ScopeUpdateScope v0_12 = v0_11.endRestartGroup();
        if(v0_12 != null) {
            v0_12.updateScope(new SecureTextFieldKt$$ExternalSyntheticLambda0(arg65, v2_4, v3_1, v4_1, v5_1, v6_2, v7_2, v8_1, v9_3, v10_1, v11_3, v12_2, v13_2, v14_1, v15, v16_3, v17_3, v18_3, v19_1, v20_2, v21_3, v22_2, v23_3, arg89, arg90, arg91, arg92));
        }
    }

    static final Unit OutlinedSecureTextField_XvU6IwQ$lambda$5(TextFieldState arg29, Modifier arg30, boolean arg31, TextStyle arg32, TextFieldLabelPosition arg33, Function3 arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, Function2 arg39, Function2 arg40, boolean arg41, InputTransformation arg42, int arg43, char arg44, KeyboardOptions arg45, KeyboardActionHandler arg46, Function2 arg47, Shape arg48, TextFieldColors arg49, PaddingValues arg50, MutableInteractionSource arg51, int arg52, int arg53, int arg54, int arg55, Composer arg56, int arg57) {
        SecureTextFieldKt.OutlinedSecureTextField-XvU6IwQ(arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg56, RecomposeScopeImplKt.updateChangedFlags(arg52 | 1), RecomposeScopeImplKt.updateChangedFlags(arg53), RecomposeScopeImplKt.updateChangedFlags(arg54), arg55);
        return Unit.INSTANCE;
    }

    public static final void SecureTextField-XvU6IwQ(TextFieldState arg65, Modifier arg66, boolean arg67, TextStyle arg68, TextFieldLabelPosition arg69, Function3 arg70, Function2 arg71, Function2 arg72, Function2 arg73, Function2 arg74, Function2 arg75, Function2 arg76, boolean arg77, InputTransformation arg78, int arg79, char arg80, KeyboardOptions arg81, KeyboardActionHandler arg82, Function2 arg83, Shape arg84, TextFieldColors arg85, PaddingValues arg86, MutableInteractionSource arg87, Composer arg88, int arg89, int arg90, int arg91, int arg92) {
        Shape v20_2;
        KeyboardOptions v17_3;
        Function2 v10_2;
        Function2 v7_2;
        TextStyle v4_1;
        Composer v0_10;
        MutableInteractionSource v23_3;
        char v16_2;
        KeyboardActionHandler v18_3;
        InputTransformation v14_3;
        PaddingValues v22_2;
        Function2 v12_1;
        Function2 v9_3;
        Function3 v6_2;
        TextFieldLabelPosition v5_1;
        boolean v3_1;
        Modifier v2_5;
        Function2 v11_3;
        TextFieldColors v21_3;
        MutableInteractionSource v14_2;
        TextFieldColors v11_1;
        boolean v10_1;
        Function2 v17_1;
        Modifier v9_1;
        Function3 v16_1;
        TextFieldLabelPosition v15_1;
        MutableInteractionSource v0_9;
        PaddingValues v23_1;
        Shape v31_1;
        Function2 v28_1;
        KeyboardActionHandler v27_1;
        KeyboardOptions v26_1;
        char v30_1;
        InputTransformation v24_1;
        Function2 v22_1;
        Function2 v21_1;
        Function2 v20_1;
        Function2 v19_1;
        Function2 v18_1;
        boolean v13_1;
        PaddingValues v2_3;
        Shape v6_1;
        Function2 v8_1;
        Object v7_1;
        TextFieldColors v0_6;
        int v36;
        int v35;
        int v34;
        int v33;
        int v32;
        int v31;
        Function2 v0_1;
        int v30;
        Function2 v14;
        int v23;
        Function3 v10;
        int v20;
        TextFieldLabelPosition v9;
        int v18;
        TextStyle v7;
        int v16;
        int v13;
        Modifier v11;
        TextFieldState v12;
        int v5;
        int v0 = arg89;
        int v1 = arg90;
        int v2 = arg91;
        int v3 = arg92;
        Composer v4 = arg88.startRestartGroup(1177133806);
        ComposerKt.sourceInformation(v4, "C(SecureTextField)N(state,modifier,enabled,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,keyboardOptions,onKeyboardAction,onTextLayout,shape,colors,contentPadding,interactionSource)166@9935L2109,166@9848L2196:SecureTextField.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
            v12 = arg65;
        }
        else {
            v12 = arg65;
            if((v0 & 6) == 0) {
                v5 = v4.changed(v12) ? 4 : 2;
                v5 |= v0;
            }
            else {
                v5 = v0;
            }
        }

        int v8 = v3 & 2;
        if(v8 != 0) {
            v5 |= 0x30;
            goto label_39;
        }
        else if((v0 & 0x30) == 0) {
            v11 = arg66;
            v13 = v4.changed(v11) ? 0x20 : 16;
            v5 |= v13;
        }
        else {
        label_39:
            v11 = arg66;
        }

        v13 = v3 & 4;
        if(v13 != 0) {
            v5 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            v16 = v4.changed(arg67) ? 0x100 : 0x80;
            v5 |= v16;
        }

        int v17 = 0x400;
        if((v0 & 0xC00) == 0) {
            if((v3 & 8) == 0) {
                v7 = arg68;
                if(v4.changed(v7)) {
                    v18 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v7 = arg68;
            label_66:
                v18 = v17;
            }

            v5 |= v18;
        }
        else {
            v7 = arg68;
        }

        int v19 = 0x4000;
        if((v0 & 0x6000) == 0) {
            if((v3 & 16) == 0) {
                v9 = arg69;
                if(v4.changed(v9)) {
                    v20 = v19;
                }
                else {
                    goto label_81;
                }
            }
            else {
                v9 = arg69;
            label_81:
                v20 = 0x2000;
            }

            v5 |= v20;
        }
        else {
            v9 = arg69;
        }

        v20 = v3 & 0x20;
        int v21 = 0x30000;
        if(v20 != 0) {
            v5 |= v21;
            v10 = arg70;
        }
        else {
            v10 = arg70;
            if((v0 & v21) == 0) {
                v23 = v4.changedInstance(v10) ? 0x20000 : 0x10000;
                v5 |= v23;
            }
        }

        v23 = v3 & 0x40;
        int v24 = 0x100000;
        int v25 = 0x180000;
        int v26 = 0x80000;
        if(v23 != 0) {
            v5 |= v25;
            v14 = arg71;
        }
        else {
            v14 = arg71;
            if((v0 & v25) == 0) {
                int v28 = v4.changedInstance(v14) ? v24 : v26;
                v5 |= v28;
            }
        }

        int v15 = v3 & 0x80;
        int v29 = 0xC00000;
        if(v15 != 0) {
            v5 |= v29;
        }
        else {
            v30 = v0 & v29;
            v0_1 = arg72;
            if(v30 == 0) {
                v30 = v4.changedInstance(v0_1) ? 0x800000 : 0x400000;
                v5 |= v30;
            }
        }

        v0 = v3 & 0x100;
        v30 = 0x6000000;
        if(v0 != 0) {
            v5 |= v30;
            goto label_148;
        }
        else if((arg89 & v30) == 0) {
            v31 = v0;
            v32 = v4.changedInstance(arg73) ? 0x4000000 : 0x2000000;
            v5 |= v32;
        }
        else {
        label_148:
            v31 = v0;
        }

        v0 = v3 & 0x200;
        v32 = 0x30000000;
        if(v0 != 0) {
            v5 |= v32;
            goto label_166;
        }
        else if((arg89 & v32) == 0) {
            v32 = v0;
            v33 = v4.changedInstance(arg74) ? 0x20000000 : 0x10000000;
            v5 |= v33;
        }
        else {
        label_166:
            v32 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v34 = v1 | 6;
            v33 = v0;
        }
        else if((v1 & 6) == 0) {
            v33 = v0;
            v34 = v4.changedInstance(arg75) ? 4 : 2;
            v34 |= v1;
        }
        else {
            v33 = v0;
            v34 = v1;
        }

        v0 = v3 & 0x800;
        if(v0 != 0) {
            v34 |= 0x30;
            v35 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v35 = v0;
            v36 = v4.changedInstance(arg76) ? 0x20 : 16;
            v34 |= v36;
        }
        else {
            v35 = v0;
        }

        v0 = v34;
        int v6 = v3 & 0x1000;
        if(v6 != 0) {
            v0 |= 0x180;
        }
        else {
            v34 = v0;
            if((v1 & 0x180) == 0) {
                v36 = v4.changed(arg77) ? 0x100 : 0x80;
                v34 |= v36;
            }

            v0 = v34;
        }

        v34 = v6;
        v6 = v3 & 0x2000;
        if(v6 != 0) {
            v36 = v0 | 0xC00;
        }
        else {
            v36 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg78)) {
                    v17 = 0x800;
                }

                v36 |= v17;
            }
        }

        if((v1 & 0x6000) == 0) {
            if((v3 & 0x4000) != 0 || !v4.changed(arg79)) {
                v19 = 0x2000;
            }
            else {
            }

            v36 |= v19;
        }

        v17 = v3 & 0x8000;
        if(v17 != 0) {
            v36 |= v21;
        }
        else {
            char v0_2 = arg80;
            if((v1 & v21) == 0) {
                v19 = v4.changed(v0_2) ? 0x20000 : 0x10000;
                v36 |= v19;
            }
        }

        v19 = v3 & 0x10000;
        if(v19 != 0) {
            v36 |= v25;
        }
        else {
            KeyboardOptions v0_3 = arg81;
            if((v1 & v25) == 0) {
                v21 = v4.changed(v0_3) ? v24 : v26;
                v36 |= v21;
            }
        }

        v21 = v3 & 0x20000;
        if(v21 != 0) {
            v36 |= v29;
        }
        else {
            KeyboardActionHandler v0_4 = arg82;
            if((v1 & v29) == 0) {
                v25 = v4.changed(v0_4) ? 0x800000 : 0x400000;
                v36 |= v25;
            }
        }

        v25 = v3 & 0x40000;
        if(v25 != 0) {
            v36 |= v30;
        }
        else {
            v0_1 = arg83;
            if((v1 & v30) == 0) {
                v29 = v4.changedInstance(v0_1) ? 0x4000000 : 0x2000000;
                v36 |= v29;
            }
        }

        if((v1 & 0x30000000) == 0) {
            Shape v0_5 = arg84;
            v29 = (v3 & v26) != 0 || !v4.changed(v0_5) ? 0x10000000 : 0x20000000;
            v36 |= v29;
        }

        if((v2 & 6) == 0) {
            v0_6 = arg85;
            v16 = (v3 & v24) != 0 || !v4.changed(v0_6) ? 2 : 4;
            v16 |= v2;
        }
        else {
            v16 = v2;
        }

        if((v2 & 0x30) == 0) {
            PaddingValues v0_7 = arg86;
            int v22 = (v3 & 0x200000) != 0 || !v4.changed(v0_7) ? 16 : 0x20;
            v16 |= v22;
        }

        v0 = v16;
        v16 = v3 & 0x400000;
        if(v16 != 0) {
            v0 |= 0x180;
        }
        else {
            v18 = v0;
            if((v2 & 0x180) == 0) {
                int v27 = v4.changed(arg87) ? 0x100 : 0x80;
                v18 |= v27;
            }

            v0 = v18;
        }

        v18 = v6;
        boolean v0_8 = (v5 & 306783379) != 306783378 || (v36 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v0_8, v5 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "130@8055L7,146@8985L5,147@9040L8");
            v1 = 0xFFFF1FFF;
            if((arg89 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v11_2 = Modifier.Companion;
                }

                v0_8 = v13 != 0 ? true : arg67;
                if((v3 & 8) != 0) {
                    ProvidableCompositionLocal v2_1 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v2_2 = v4.consume(((CompositionLocal)v2_1));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v5 &= 0xFFFFE3FF;
                    v7_1 = v2_2;
                }

                if((v3 & 16) != 0) {
                    v5 &= v1;
                    Attached v9_2 = new Attached(false, null, null, 7, null);
                }

                if(v20 != 0) {
                    v10 = null;
                }

                if(v23 != 0) {
                    v14 = null;
                }

                v8_1 = v15 != 0 ? null : arg72;
                Function2 v13_2 = v31 != 0 ? null : arg73;
                Function2 v15_2 = v32 != 0 ? null : arg74;
                v20_1 = v33 != 0 ? null : arg75;
                v22_1 = v35 != 0 ? null : arg76;
                boolean v23_2 = v34 != 0 ? false : arg77;
                InputTransformation v18_2 = v18 != 0 ? null : arg78;
                int v88 = v1;
                if((v3 & 0x4000) != 0) {
                    v1 = TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0();
                    v36 &= v88;
                }
                else {
                    v1 = arg79;
                }

                char v17_2 = v17 != 0 ? '•' : arg80;
                KeyboardOptions v19_2 = v19 != 0 ? SecureTextFieldKt.SecureTextFieldKeyboardOptions : arg81;
                KeyboardActionHandler v21_2 = v21 != 0 ? null : arg82;
                Function2 v25_1 = v25 != 0 ? null : arg83;
                v2 = 6;
                if((v3 & v26) != 0) {
                    v6_1 = TextFieldDefaults.INSTANCE.getShape(v4, v2);
                    v36 &= 0x8FFFFFFF;
                }
                else {
                    v6_1 = arg84;
                }

                arg67 = v0_8;
                v0_6 = (v3 & v24) != 0 ? TextFieldDefaults.INSTANCE.colors(v4, v2) : arg85;
                if((0x200000 & v3) != 0) {
                    if(v10 != null) {
                        if((v9 instanceof Above)) {
                        }
                        else {
                            v2_3 = TextFieldDefaults.contentPaddingWithLabel-a9UjIt4$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null);
                            goto label_583;
                        }
                    }

                    v2_3 = TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null);
                }
                else {
                    v2_3 = arg86;
                }

            label_583:
                v29 = v1;
                v31_1 = v6_1;
                if(v16 != 0) {
                    v16_1 = v10;
                    v30_1 = v17_2;
                    v24_1 = v18_2;
                    v26_1 = v19_2;
                    v27_1 = v21_2;
                    v10_1 = v23_2;
                    v28_1 = v25_1;
                    v1 = v36;
                    v23_1 = v2_3;
                    v18_1 = v8_1;
                    v19_1 = v13_2;
                    v17_1 = v14;
                    v21_1 = v20_1;
                    v13_1 = arg67;
                    v20_1 = v15_2;
                    v15_1 = v9;
                    v9_1 = v11;
                    v11_1 = v0_6;
                    v0_9 = null;
                    goto label_625;
                }

                v16_1 = v10;
                v30_1 = v17_2;
                v24_1 = v18_2;
                v26_1 = v19_2;
                v27_1 = v21_2;
                v10_1 = v23_2;
                v28_1 = v25_1;
                v1 = v36;
                v23_1 = v2_3;
                v18_1 = v8_1;
                v19_1 = v13_2;
                v17_1 = v14;
                v21_1 = v20_1;
                v13_1 = arg67;
                v20_1 = v15_2;
                v15_1 = v9;
                v9_1 = v11;
                v11_1 = v0_6;
                v0_9 = arg87;
            }
            else {
                v4.skipToGroupEnd();
                if((v3 & 8) != 0) {
                    v5 &= 0xFFFFE3FF;
                }

                if((v3 & 16) != 0) {
                    v5 &= v1;
                }

                if((v3 & 0x4000) != 0) {
                    v36 &= v1;
                }

                if((v3 & v26) != 0) {
                    v36 &= 0x8FFFFFFF;
                }

                v13_1 = arg67;
                v18_1 = arg72;
                v19_1 = arg73;
                v20_1 = arg74;
                v21_1 = arg75;
                v22_1 = arg76;
                v24_1 = arg78;
                v29 = arg79;
                v30_1 = arg80;
                v26_1 = arg81;
                v27_1 = arg82;
                v28_1 = arg83;
                v31_1 = arg84;
                v23_1 = arg86;
                v0_9 = arg87;
                v15_1 = v9;
                v16_1 = v10;
                v9_1 = v11;
                v17_1 = v14;
                v1 = v36;
                v10_1 = arg77;
                v11_1 = arg85;
            }

        label_625:
            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1177133806, v5, v1, "androidx.compose.material3.SecureTextField (SecureTextField.kt:155)");
            }

            if(v0_9 == null) {
                v4.startReplaceGroup(0xE75F8B0D);
                ComposerKt.sourceInformation(v4, "157@9449L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0x624D6795, "CC(remember):SecureTextField.kt#9igjgp");
                Object v1_1 = v4.rememberedValue();
                if(v1_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v1_2 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v1_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                Object v14_1 = v1_1;
            }
            else {
                v4.startReplaceGroup(0x624D650A);
                v4.endReplaceGroup();
                v14_2 = v0_9;
            }

            v4.startReplaceGroup(0x624D7CE8);
            ComposerKt.sourceInformation(v4, "*161@9673L25");
            long v1_3 = ((TextStyle)v7_1).getColor-0d7_KjU();
            if(v1_3 != 16) {
            }
            else {
                v1_3 = v11_1.textColor-XeAY9LY$material3(v13_1, v10_1, FocusInteractionKt.collectIsFocusedAsState(v14_2, v4, 0).getValue().booleanValue());
            }

            v4.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(v11_1.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(-2072926674, true, new SecureTextFieldKt$SecureTextField$1(v9_1, v10_1, v11_1, v12, v13_1, v14_2, v15_1, v16_1, v17_1, v18_1, v19_1, v20_1, v21_1, v22_1, v23_1, v24_1, ((TextStyle)v7_1).merge(new TextStyle(v1_3, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null)), v26_1, v27_1, v28_1, v29, v30_1, v31_1), v4, 54), v4, ProvidedValue.$stable | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Function2 v2_4 = v21_1;
            v21_3 = v11_1;
            v11_3 = v2_4;
            v2_5 = v9_1;
            v3_1 = v13_1;
            v5_1 = v15_1;
            v6_2 = v16_1;
            v8_1 = v18_1;
            v9_3 = v19_1;
            v12_1 = v22_1;
            v22_2 = v23_1;
            v14_3 = v24_1;
            v18_3 = v27_1;
            v19_1 = v28_1;
            v15 = v29;
            v16_2 = v30_1;
            v23_3 = v0_9;
            v0_10 = v4;
            v4_1 = ((TextStyle)v7_1);
            v13_1 = v10_1;
            v7_2 = v17_1;
            v10_2 = v20_1;
            v17_3 = v26_1;
            v20_2 = v31_1;
        }
        else {
            v4.skipToGroupEnd();
            v3_1 = arg67;
            v8_1 = arg72;
            v12_1 = arg76;
            v13_1 = arg77;
            v15 = arg79;
            v16_2 = arg80;
            v17_3 = arg81;
            v18_3 = arg82;
            v19_1 = arg83;
            v20_2 = arg84;
            v21_3 = arg85;
            v22_2 = arg86;
            v23_3 = arg87;
            v0_10 = v4;
            v4_1 = v7;
            v5_1 = v9;
            v6_2 = v10;
            v2_5 = v11;
            v7_2 = v14;
            v9_3 = arg73;
            v10_2 = arg74;
            v11_3 = arg75;
            v14_3 = arg78;
        }

        ScopeUpdateScope v0_11 = v0_10.endRestartGroup();
        if(v0_11 != null) {
            v0_11.updateScope(new SecureTextFieldKt$$ExternalSyntheticLambda1(arg65, v2_5, v3_1, v4_1, v5_1, v6_2, v7_2, v8_1, v9_3, v10_2, v11_3, v12_1, v13_1, v14_3, v15, v16_2, v17_3, v18_3, v19_1, v20_2, v21_3, v22_2, v23_3, arg89, arg90, arg91, arg92));
        }
    }

    static final Unit SecureTextField_XvU6IwQ$lambda$2(TextFieldState arg29, Modifier arg30, boolean arg31, TextStyle arg32, TextFieldLabelPosition arg33, Function3 arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, Function2 arg39, Function2 arg40, boolean arg41, InputTransformation arg42, int arg43, char arg44, KeyboardOptions arg45, KeyboardActionHandler arg46, Function2 arg47, Shape arg48, TextFieldColors arg49, PaddingValues arg50, MutableInteractionSource arg51, int arg52, int arg53, int arg54, int arg55, Composer arg56, int arg57) {
        SecureTextFieldKt.SecureTextField-XvU6IwQ(arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg56, RecomposeScopeImplKt.updateChangedFlags(arg52 | 1), RecomposeScopeImplKt.updateChangedFlags(arg53), RecomposeScopeImplKt.updateChangedFlags(arg54), arg55);
        return Unit.INSTANCE;
    }
}

