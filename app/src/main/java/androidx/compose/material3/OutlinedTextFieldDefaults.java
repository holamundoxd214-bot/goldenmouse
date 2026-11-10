package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldType;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 2 \b\u0002\u0010!\u001A\u001A\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010\'\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001A\u00020\u00182\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u0002022\u0013\b\u0002\u00103\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001A\u00020$2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\tH\u0007¢\u0006\u0004\b:\u0010;J\u009C\u0002\u0010<\u001A\u00020$2\u0006\u0010=\u001A\u00020>2\u0011\u0010?\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010@\u001A\u00020\u00182\u0006\u0010A\u001A\u00020B2\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010.\u001A\u00020\u00182\u0015\b\u0002\u0010!\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010\'\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u0002022\u0013\b\u0002\u00103\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010CJ5\u00101\u001A\u0002022\b\b\u0002\u0010D\u001A\u00020\t2\b\b\u0002\u0010E\u001A\u00020\t2\b\b\u0002\u0010F\u001A\u00020\t2\b\b\u0002\u0010G\u001A\u00020\t¢\u0006\u0004\bH\u0010IJ\r\u0010/\u001A\u000200H\u0007¢\u0006\u0002\u0010JJ¿\u0003\u0010/\u001A\u0002002\b\b\u0002\u0010K\u001A\u00020L2\b\b\u0002\u0010M\u001A\u00020L2\b\b\u0002\u0010N\u001A\u00020L2\b\b\u0002\u0010O\u001A\u00020L2\b\b\u0002\u0010P\u001A\u00020L2\b\b\u0002\u0010Q\u001A\u00020L2\b\b\u0002\u0010R\u001A\u00020L2\b\b\u0002\u0010S\u001A\u00020L2\b\b\u0002\u0010T\u001A\u00020L2\b\b\u0002\u0010U\u001A\u00020L2\n\b\u0002\u0010V\u001A\u0004\u0018\u00010W2\b\b\u0002\u0010X\u001A\u00020L2\b\b\u0002\u0010Y\u001A\u00020L2\b\b\u0002\u0010Z\u001A\u00020L2\b\b\u0002\u0010[\u001A\u00020L2\b\b\u0002\u0010\\\u001A\u00020L2\b\b\u0002\u0010]\u001A\u00020L2\b\b\u0002\u0010^\u001A\u00020L2\b\b\u0002\u0010_\u001A\u00020L2\b\b\u0002\u0010`\u001A\u00020L2\b\b\u0002\u0010a\u001A\u00020L2\b\b\u0002\u0010b\u001A\u00020L2\b\b\u0002\u0010c\u001A\u00020L2\b\b\u0002\u0010d\u001A\u00020L2\b\b\u0002\u0010e\u001A\u00020L2\b\b\u0002\u0010f\u001A\u00020L2\b\b\u0002\u0010g\u001A\u00020L2\b\b\u0002\u0010h\u001A\u00020L2\b\b\u0002\u0010i\u001A\u00020L2\b\b\u0002\u0010j\u001A\u00020L2\b\b\u0002\u0010k\u001A\u00020L2\b\b\u0002\u0010l\u001A\u00020L2\b\b\u0002\u0010m\u001A\u00020L2\b\b\u0002\u0010n\u001A\u00020L2\b\b\u0002\u0010o\u001A\u00020L2\b\b\u0002\u0010p\u001A\u00020L2\b\b\u0002\u0010q\u001A\u00020L2\b\b\u0002\u0010r\u001A\u00020L2\b\b\u0002\u0010s\u001A\u00020L2\b\b\u0002\u0010t\u001A\u00020L2\b\b\u0002\u0010u\u001A\u00020L2\b\b\u0002\u0010v\u001A\u00020L2\b\b\u0002\u0010w\u001A\u00020LH\u0007¢\u0006\u0004\bx\u0010yJP\u0010~\u001A\u00020$2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\tH\u0007¢\u0006\u0005\b\u007F\u0010\u0080\u0001R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u000F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000BR\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u0018\u0010z\u001A\u000200*\u00020{8AX\u0080\u0004¢\u0006\u0006\u001A\u0004\b|\u0010}¨\u0006\u0081\u0001"}, d2={"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Container", "modifier", "Landroidx/compose/ui/Modifier;", "focusedBorderThickness", "unfocusedBorderThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OutlinedTextFieldDefaults {
    public static final int $stable;
    private static final float FocusedBorderThickness;
    public static final OutlinedTextFieldDefaults INSTANCE;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float UnfocusedBorderThickness;

    static {
        OutlinedTextFieldDefaults.INSTANCE = new OutlinedTextFieldDefaults();
        OutlinedTextFieldDefaults.MinHeight = Dp.constructor-impl(56f);
        OutlinedTextFieldDefaults.MinWidth = Dp.constructor-impl(280f);
        OutlinedTextFieldDefaults.UnfocusedBorderThickness = Dp.constructor-impl(1f);
        OutlinedTextFieldDefaults.FocusedBorderThickness = Dp.constructor-impl(2f);
    }

    private OutlinedTextFieldDefaults() {
        super();
    }

    public final void Container-4EFweAY(boolean arg21, boolean arg22, InteractionSource arg23, Modifier arg24, TextFieldColors arg25, Shape arg26, float arg27, float arg28, Composer arg29, int arg30, int arg31) {
        Modifier v5_2;
        float v8_2;
        Composer v15_1;
        Modifier v12_2;
        Shape v13_2;
        float v6_1;
        TextFieldColors v5_1;
        int v4_1;
        Companion v12_3;
        float v7_2;
        float v9_2;
        Shape v7_1;
        TextFieldColors v6_2;
        Modifier v4_3;
        Companion v4_2;
        int v15;
        float v14_1;
        int v14;
        float v13_1;
        int v13;
        Shape v12_1;
        int v12;
        TextFieldColors v9_1;
        int v9;
        Modifier v7;
        int v6;
        int v5;
        OutlinedTextFieldDefaults v1 = this;
        boolean v2 = arg21;
        boolean v3 = arg22;
        InteractionSource v0 = arg23;
        int v10 = arg30;
        int v11 = arg31;
        Composer v8 = arg29.startRestartGroup(1035477640);
        ComposerKt.sourceInformation(v8, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1055@55084L25,1057@55155L222,1069@55662L7,1067@55495L189,1071@55693L153:TextFieldDefaults.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v5 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v5 = v8.changed(v2) ? 4 : 2;
            v5 |= v10;
        }
        else {
            v5 = v10;
        }

        if((v11 & 2) != 0) {
            v5 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v6 = v8.changed(v3) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v11 & 4) != 0) {
            v5 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v6 = v8.changed(v0) ? 0x100 : 0x80;
            v5 |= v6;
        }

        v6 = v11 & 8;
        if(v6 != 0) {
            v5 |= 0xC00;
            goto label_63;
        }
        else if((v10 & 0xC00) == 0) {
            v7 = arg24;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v5 |= v9;
        }
        else {
        label_63:
            v7 = arg24;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v9_1 = arg25;
                if(v8.changed(v9_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_74;
                }
            }
            else {
                v9_1 = arg25;
            label_74:
                v12 = 0x2000;
            }

            v5 |= v12;
        }
        else {
            v9_1 = arg25;
        }

        if((0x30000 & v10) == 0) {
            if((v11 & 0x20) == 0) {
                v12_1 = arg26;
                if(v8.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_89;
                }
            }
            else {
                v12_1 = arg26;
            label_89:
                v13 = 0x10000;
            }

            v5 |= v13;
        }
        else {
            v12_1 = arg26;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v13_1 = arg27;
                if(v8.changed(v13_1)) {
                    v14 = 0x100000;
                }
                else {
                    goto label_104;
                }
            }
            else {
                v13_1 = arg27;
            label_104:
                v14 = 0x80000;
            }

            v5 |= v14;
        }
        else {
            v13_1 = arg27;
        }

        if((0xC00000 & v10) == 0) {
            if((v11 & 0x80) == 0) {
                v14_1 = arg28;
                if(v8.changed(v14_1)) {
                    v15 = 0x800000;
                }
                else {
                    goto label_119;
                }
            }
            else {
                v14_1 = arg28;
            label_119:
                v15 = 0x400000;
            }

            v5 |= v15;
        }
        else {
            v14_1 = arg28;
        }

        int v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v5 |= v16;
        }
        else if((v10 & v16) == 0) {
            v15 = v8.changed(v1) ? 0x4000000 : 0x2000000;
            v5 |= v15;
        }

        boolean v4 = (0x2492493 & v5) != 0x2492492 ? true : false;
        if(v8.shouldExecute(v4, v5 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "1050@54844L8,1051@54903L5");
            int v17 = 0xFFC7FFFF;
            int v18 = 0xFFF8FFFF;
            int v19 = 0xFFFF1FFF;
            int v29 = 0xFE3FFFFF;
            v15 = 6;
            if((arg30 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v6 != 0) {
                    v4_2 = Modifier.Companion;
                }
                else {
                    v4_3 = v7;
                }

                if((v11 & 16) != 0) {
                    v6_2 = v1.colors(v8, v5 >> 24 & 14);
                    v5 &= v19;
                }
                else {
                    v6_2 = v9_1;
                }

                if((v11 & 0x20) != 0) {
                    v7_1 = OutlinedTextFieldDefaults.INSTANCE.getShape(v8, v15);
                    v5 &= v18;
                }
                else {
                    v7_1 = v12_1;
                }

                if((v11 & 0x40) != 0) {
                    v9_2 = OutlinedTextFieldDefaults.FocusedBorderThickness;
                    v5 &= v17;
                }
                else {
                    v9_2 = v13_1;
                }

                if((v11 & 0x80) != 0) {
                    v13_2 = v7_1;
                    v7_2 = OutlinedTextFieldDefaults.UnfocusedBorderThickness;
                    v12_3 = v4_2;
                    v4_1 = v5 & v29;
                    v5_1 = v6_2;
                    v6_1 = v9_2;
                    goto label_220;
                }

                v12_3 = v4_2;
                v4_1 = v5;
                v5_1 = v6_2;
                v13_2 = v7_1;
                v6_1 = v9_2;
            label_219:
                v7_2 = v14_1;
            }
            else {
                v8.skipToGroupEnd();
                if((v11 & 16) != 0) {
                    v5 &= v19;
                }

                if((v11 & 0x20) != 0) {
                    v5 &= v18;
                }

                if((v11 & 0x40) != 0) {
                    v5 &= v17;
                }

                if((v11 & 0x80) != 0) {
                    v5 &= v29;
                }

                v4_1 = v5;
                v5_1 = v9_1;
                v6_1 = v13_1;
                v13_2 = v12_1;
                v12_2 = v7;
                goto label_219;
            }

        label_220:
            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035477640, v4_1, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.Container (TextFieldDefaults.kt:1054)");
            }

            v9 = v4_1 >> 6;
            boolean v10_1 = FocusInteractionKt.collectIsFocusedAsState(v0, v8, v9 & 14).getValue().booleanValue();
            State v9_3 = TextFieldImplKt.animateBorderStrokeAsState-NuRrP5Q(v2, v3, v10_1, v5_1, v6_1, v7_2, v8, v9 & 0x70000 | (v4_1 >> 3 & 0x1C00 | v4_1 & 0x7E | 0xE000 & v9));
            long v16_1 = v5_1.containerColor-XeAY9LY$material3(v2, v3, v10_1);
            v4_3 = v12_2;
            Shape v10_2 = v13_2;
            long v12_4 = v16_1;
            Composer v17_1 = v8;
            State v8_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v12_4, MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v8, v15), null, null, v17_1, 0, 12);
            v15_1 = v17_1;
            BoxKt.Box(TextFieldImplKt.textFieldBackground(BorderKt.border(v4_3, v9_3.getValue(), v10_2), new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new OutlinedTextFieldDefaults$Container$1(v8_1)), v10_2), v15_1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v6_1;
            v9_2 = v7_2;
            v7_1 = v10_2;
            v6_2 = v5_1;
            v5_2 = v4_3;
        }
        else {
            v15_1 = v8;
            v15_1.skipToGroupEnd();
            v5_2 = v7;
            v6_2 = v9_1;
            v7_1 = v12_1;
            v8_2 = v13_1;
            v9_2 = v14_1;
        }

        ScopeUpdateScope v12_5 = v15_1.endRestartGroup();
        if(v12_5 != null) {
            v12_5.updateScope(new OutlinedTextFieldDefaults$$ExternalSyntheticLambda0(v1, v2, v3, arg23, v5_2, v6_2, v7_1, v8_2, v9_2, arg30, v11));
        }
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to OutlinedTextFieldDefaults.Container", replaceWith="<_subannotation>") public final void ContainerBox-nbWgWpA(boolean arg19, boolean arg20, InteractionSource arg21, TextFieldColors arg22, Shape arg23, float arg24, float arg25, Composer arg26, int arg27, int arg28) {
        float v7_2;
        Shape v6_2;
        TextFieldColors v5_2;
        int v11;
        float v10_1;
        int v10;
        float v8_1;
        int v8;
        Shape v7_1;
        int v7;
        TextFieldColors v6_1;
        InteractionSource v5_1;
        boolean v4;
        boolean v2;
        int v3;
        OutlinedTextFieldDefaults v0 = this;
        int v12 = arg27;
        int v13 = arg28;
        int v1 = 0x5720B56A;
        Composer v9 = arg26.startRestartGroup(v1);
        ComposerKt.sourceInformation(v9, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)1482@80172L348:TextFieldDefaults.kt#uh7d8r");
        if((v13 & 1) != 0) {
            v3 = v12 | 6;
            v2 = arg19;
        }
        else if((v12 & 6) == 0) {
            v2 = arg19;
            v3 = v9.changed(v2) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v2 = arg19;
            v3 = v12;
        }

        if((v13 & 2) != 0) {
            v3 |= 0x30;
            goto label_40;
        }
        else if((v12 & 0x30) == 0) {
            v4 = arg20;
            int v5 = v9.changed(v4) ? 0x20 : 16;
            v3 |= v5;
        }
        else {
        label_40:
            v4 = arg20;
        }

        if((v13 & 4) != 0) {
            v3 |= 0x180;
            goto label_55;
        }
        else if((v12 & 0x180) == 0) {
            v5_1 = arg21;
            int v6 = v9.changed(v5_1) ? 0x100 : 0x80;
            v3 |= v6;
        }
        else {
        label_55:
            v5_1 = arg21;
        }

        if((v12 & 0xC00) == 0) {
            if((v13 & 8) == 0) {
                v6_1 = arg22;
                if(v9.changed(v6_1)) {
                    v7 = 0x800;
                }
                else {
                    goto label_66;
                }
            }
            else {
                v6_1 = arg22;
            label_66:
                v7 = 0x400;
            }

            v3 |= v7;
        }
        else {
            v6_1 = arg22;
        }

        if((v12 & 0x6000) == 0) {
            if((v13 & 16) == 0) {
                v7_1 = arg23;
                if(v9.changed(v7_1)) {
                    v8 = 0x4000;
                }
                else {
                    goto label_80;
                }
            }
            else {
                v7_1 = arg23;
            label_80:
                v8 = 0x2000;
            }

            v3 |= v8;
        }
        else {
            v7_1 = arg23;
        }

        if((0x30000 & v12) == 0) {
            if((v13 & 0x20) == 0) {
                v8_1 = arg24;
                if(v9.changed(v8_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_95;
                }
            }
            else {
                v8_1 = arg24;
            label_95:
                v10 = 0x10000;
            }

            v3 |= v10;
        }
        else {
            v8_1 = arg24;
        }

        if((0x180000 & v12) == 0) {
            if((v13 & 0x40) == 0) {
                v10_1 = arg25;
                if(v9.changed(v10_1)) {
                    v11 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v10_1 = arg25;
            label_110:
                v11 = 0x80000;
            }

            v3 |= v11;
        }
        else {
            v10_1 = arg25;
        }

        int v14 = 0xC00000;
        if((v13 & 0x80) != 0) {
            v3 |= v14;
        }
        else if((v12 & v14) == 0) {
            v11 = v9.changed(v0) ? 0x800000 : 0x400000;
            v3 |= v11;
        }

        boolean v11_1 = (0x492493 & v3) != 4793490 ? true : false;
        if(v9.shouldExecute(v11_1, v3 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "1477@79964L8,1478@80023L5");
            v14 = 0xFFC7FFFF;
            int v15 = 0xFFF8FFFF;
            int v16 = 0xFFFF1FFF;
            if((v12 & 1) == 0 || (v9.getDefaultsInvalid())) {
                if((v13 & 8) != 0) {
                    v6_1 = v0.colors(v9, v3 >> 21 & 14);
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v7_1 = OutlinedTextFieldDefaults.INSTANCE.getShape(v9, 6);
                    v3 &= v16;
                }

                if((v13 & 0x20) != 0) {
                    v8_1 = OutlinedTextFieldDefaults.FocusedBorderThickness;
                    v3 &= v15;
                }

                if((v13 & 0x40) == 0) {
                    goto label_181;
                }

                v10_1 = OutlinedTextFieldDefaults.UnfocusedBorderThickness;
            label_180:
                v3 &= v14;
            }
            else {
                v9.skipToGroupEnd();
                if((v13 & 8) != 0) {
                    v3 &= 0xFFFFE3FF;
                }

                if((v13 & 16) != 0) {
                    v3 &= v16;
                }

                if((v13 & 0x20) != 0) {
                    v3 &= v15;
                }

                if((v13 & 0x40) == 0) {
                    goto label_181;
                }

                goto label_180;
            }

        label_181:
            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1, v3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1482)");
            }

            v11 = v3 & 14 | 0xC00 | v3 & 0x70 | v3 & 0x380;
            v3 <<= 3;
            float v17 = v10_1;
            v10 = v3 & 0xE000000 | (v11 | 0xE000 & v3 | 0x70000 & v3 | 0x380000 & v3 | 0x1C00000 & v3);
            InteractionSource v3_1 = v5_1;
            v5_2 = v6_1;
            v6_2 = v7_1;
            v7_2 = v8_1;
            v8_1 = v17;
            v0.Container-4EFweAY(v2, v4, v3_1, Modifier.Companion, v5_2, v6_2, v7_2, v8_1, v9, v10, 0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_232;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v9.skipToGroupEnd();
            v5_2 = v6_1;
            v6_2 = v7_1;
            v7_2 = v8_1;
            v8_1 = v10_1;
        }

    label_232:
        ScopeUpdateScope v11_2 = v9.endRestartGroup();
        if(v11_2 != null) {
            v11_2.updateScope(new OutlinedTextFieldDefaults$$ExternalSyntheticLambda2(this, arg19, arg20, arg21, v5_2, v6_2, v7_2, v8_1, v12, v13));
        }
    }

    static final Unit ContainerBox_nbWgWpA$lambda$7(OutlinedTextFieldDefaults arg12, boolean arg13, boolean arg14, InteractionSource arg15, TextFieldColors arg16, Shape arg17, float arg18, float arg19, int arg20, int arg21, Composer arg22, int arg23) {
        arg12.ContainerBox-nbWgWpA(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit Container_4EFweAY$lambda$0(OutlinedTextFieldDefaults arg13, boolean arg14, boolean arg15, InteractionSource arg16, Modifier arg17, TextFieldColors arg18, Shape arg19, float arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        arg13.Container-4EFweAY(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public final void DecorationBox(String arg37, Function2 arg38, boolean arg39, boolean arg40, VisualTransformation arg41, InteractionSource arg42, boolean arg43, Function2 arg44, Function2 arg45, Function2 arg46, Function2 arg47, Function2 arg48, Function2 arg49, Function2 arg50, TextFieldColors arg51, PaddingValues arg52, Function2 arg53, Composer arg54, int arg55, int arg56, int arg57) {
        TextFieldColors v16_3;
        boolean v8_2;
        Function2 v18_2;
        PaddingValues v17_1;
        Function2 v15_1;
        Function2 v14_2;
        Composer v21_2;
        ComposableLambda v4_2;
        TransformedText v5_2;
        TextFieldColors v19_1;
        Function2 v10_1;
        boolean v16_1;
        Function2 v20_1;
        PaddingValues v18_1;
        Function2 v13_1;
        Function2 v11;
        Function2 v12_1;
        Function2 v1_1;
        ComposableLambda v20_2;
        TextFieldColors v23_1;
        PaddingValues v1_2;
        TextFieldColors v4_1;
        Function2 v3_2;
        int v33;
        int v32;
        int v31;
        int v30;
        int v29;
        Function2 v9;
        boolean v10;
        int v13;
        int v20;
        boolean v14_1;
        int v14;
        int v8;
        OutlinedTextFieldDefaults v1 = this;
        String v2 = arg37;
        boolean v15 = arg39;
        VisualTransformation v0 = arg41;
        InteractionSource v7 = arg42;
        int v3 = arg55;
        int v4 = arg56;
        int v5 = arg57;
        Composer v6 = arg54.startRestartGroup(0x98BF7AEE);
        ComposerKt.sourceInformation(v6, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,colors,contentPadding,container)1170@61544L129,1176@61727L751:TextFieldDefaults.kt#uh7d8r");
        if((v5 & 1) != 0) {
            v8 = v3 | 6;
        }
        else if((v3 & 6) == 0) {
            v8 = v6.changed(v2) ? 4 : 2;
            v8 |= v3;
        }
        else {
            v8 = v3;
        }

        if((v5 & 2) != 0) {
            v8 |= 0x30;
        }
        else if((v3 & 0x30) == 0) {
            v14 = v6.changedInstance(arg38) ? 0x20 : 16;
            v8 |= v14;
        }

        int v16 = 0x100;
        int v17 = 0x80;
        if((v5 & 4) != 0) {
            v8 |= 0x180;
        }
        else if((v3 & 0x180) == 0) {
            v14 = v6.changed(v15) ? v16 : v17;
            v8 |= v14;
        }

        int v18 = 0x800;
        int v19 = 0x400;
        if((v5 & 8) != 0) {
            v8 |= 0xC00;
            goto label_72;
        }
        else if((v3 & 0xC00) == 0) {
            v14_1 = arg40;
            v20 = v6.changed(v14_1) ? v18 : v19;
            v8 |= v20;
        }
        else {
        label_72:
            v14_1 = arg40;
        }

        int v21 = 0x2000;
        if((v5 & 16) != 0) {
            v8 |= 0x6000;
        }
        else if((v3 & 0x6000) == 0) {
            v13 = v6.changed(v0) ? 0x4000 : v21;
            v8 |= v13;
        }

        int v22 = 0x10000;
        int v23 = 0x30000;
        if((v5 & 0x20) != 0) {
            v8 |= v23;
        }
        else if((v3 & v23) == 0) {
            v13 = v6.changed(v7) ? 0x20000 : v22;
            v8 |= v13;
        }

        v13 = v5 & 0x40;
        int v24 = 0x180000;
        if(v13 != 0) {
            v8 |= v24;
            v10 = arg43;
        }
        else {
            v10 = arg43;
            if((v3 & v24) == 0) {
                int v26 = v6.changed(v10) ? 0x100000 : 0x80000;
                v8 |= v26;
            }
        }

        int v12 = v5 & 0x80;
        int v27 = 0xC00000;
        if(v12 != 0) {
            v8 |= v27;
        }
        else {
            v9 = arg44;
            if((v3 & v27) == 0) {
                v29 = v6.changedInstance(v9) ? 0x800000 : 0x400000;
                v8 |= v29;
            }
        }

        v3 = v5 & 0x100;
        v29 = 0x6000000;
        if(v3 != 0) {
            v8 |= v29;
            goto label_146;
        }
        else if((arg55 & v29) == 0) {
            v29 = v3;
            v30 = v6.changedInstance(arg45) ? 0x4000000 : 0x2000000;
            v8 |= v30;
        }
        else {
        label_146:
            v29 = v3;
        }

        v3 = v5 & 0x200;
        v30 = 0x30000000;
        if(v3 != 0) {
            v8 |= v30;
            goto label_164;
        }
        else if((arg55 & v30) == 0) {
            v30 = v3;
            v31 = v6.changedInstance(arg46) ? 0x20000000 : 0x10000000;
            v8 |= v31;
        }
        else {
        label_164:
            v30 = v3;
        }

        v3 = v5 & 0x400;
        if(v3 != 0) {
            v32 = v4 | 6;
            v31 = v3;
        }
        else if((v4 & 6) == 0) {
            v31 = v3;
            v32 = v6.changedInstance(arg47) ? 4 : 2;
            v32 |= v4;
        }
        else {
            v31 = v3;
            v32 = v4;
        }

        v3 = v5 & 0x800;
        if(v3 != 0) {
            v32 |= 0x30;
            v33 = v3;
        }
        else if((v4 & 0x30) == 0) {
            v33 = v3;
            v20 = v6.changedInstance(arg48) ? 0x20 : 16;
            v32 |= v20;
        }
        else {
            v33 = v3;
        }

        v3 = v32;
        int v9_1 = v5 & 0x1000;
        if(v9_1 != 0) {
            v3 |= 0x180;
        }
        else {
            v20 = v3;
            if((v4 & 0x180) == 0) {
                if(v6.changedInstance(arg49)) {
                }
                else {
                    v16 = v17;
                }

                v3 = v20 | v16;
            }
            else {
                v3 = v20;
            }
        }

        v16 = v9_1;
        v9_1 = v5 & 0x2000;
        if(v9_1 != 0) {
            v17 = v3 | 0xC00;
        }
        else {
            v17 = v3;
            if((v4 & 0xC00) == 0) {
                if(v6.changedInstance(arg50)) {
                }
                else {
                    v18 = v19;
                }

                v17 |= v18;
            }
        }

        if((v4 & 0x6000) == 0) {
            if((v5 & 0x4000) == 0 && (v6.changed(arg51))) {
                v21 = 0x4000;
            }

            v17 |= v21;
        }

        if((v4 & v23) == 0) {
            PaddingValues v3_1 = arg52;
            v18 = (v5 & 0x8000) != 0 || !v6.changed(v3_1) ? v22 : 0x20000;
            v17 |= v18;
        }

        v18 = v5 & v22;
        if(v18 != 0) {
            v17 |= v24;
        }
        else {
            v3_2 = arg53;
            if((v4 & v24) == 0) {
                v19 = v6.changedInstance(v3_2) ? 0x100000 : 0x80000;
                v17 |= v19;
            }
        }

        if((v5 & 0x20000) != 0) {
            v17 |= v27;
        }
        else if((v4 & v27) == 0) {
            v19 = v6.changed(v1) ? 0x800000 : 0x400000;
            v17 |= v19;
        }

        v20 = v9_1;
        boolean v3_3 = (v8 & 306783379) != 306783378 || (v17 & 0x492493) != 4793490 ? true : false;
        if(v6.shouldExecute(v3_3, v8 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "1154@60977L8,1156@61089L408");
            if((arg55 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v13 != 0) {
                    v10 = false;
                }

                v3_2 = v12 != 0 ? null : arg44;
                v12_1 = v29 != 0 ? null : arg45;
                v13_1 = v30 != 0 ? null : arg46;
                Function2 v21_1 = v31 != 0 ? null : arg47;
                Function2 v22_1 = v33 != 0 ? null : arg48;
                Function2 v16_2 = v16 != 0 ? null : arg49;
                v20_1 = v20 != 0 ? null : arg50;
                if((v5 & 0x4000) != 0) {
                    v4_1 = v1.colors(v6, v17 >> 21 & 14);
                    v17 &= 0xFFFF1FFF;
                }
                else {
                    v4_1 = arg51;
                }

                if((v5 & 0x8000) != 0) {
                    v1_2 = OutlinedTextFieldDefaults.contentPadding-a9UjIt4$default(v1, 0f, 0f, 0f, 0f, 15, null);
                    v17 &= 0xFFF8FFFF;
                }
                else {
                    v1_2 = arg52;
                }

                if(v18 != 0) {
                    PaddingValues v43 = v1_2;
                    arg44 = v3_2;
                    v23_1 = v4_1;
                    ComposableLambda v1_3 = ComposableLambdaKt.rememberComposableLambda(0xCA9400A3, true, new OutlinedTextFieldDefaults$DecorationBox$1(v15, v10, v7, v4_1), v6, 54);
                    v18_1 = v43;
                    v9 = v13_1;
                    v3_2 = v16_2;
                    v4 = v17;
                    v17 = 0;
                    v13_1 = v20_1;
                    v11 = v22_1;
                    v19_1 = v23_1;
                    v20_2 = v1_3;
                    v16_1 = v10;
                    v10_1 = v21_1;
                    v21 = 1;
                    v1_1 = arg44;
                    goto label_444;
                }

                v23_1 = v4_1;
                v18_1 = v1_2;
                v1_1 = v3_2;
                v9 = v13_1;
                v3_2 = v16_2;
                v4 = v17;
                v17 = 0;
                v13_1 = v20_1;
                v11 = v22_1;
                v19_1 = v23_1;
                v20_1 = arg53;
                v16_1 = v10;
                v10_1 = v21_1;
                v21 = 1;
            }
            else {
                v6.skipToGroupEnd();
                if((v5 & 0x4000) != 0) {
                    v17 &= 0xFFFF1FFF;
                }

                if((0x8000 & v5) != 0) {
                    v17 &= 0xFFF8FFFF;
                }

                v1_1 = arg44;
                v12_1 = arg45;
                v9 = arg46;
                v11 = arg48;
                v3_2 = arg49;
                v13_1 = arg50;
                v18_1 = arg52;
                v20_1 = arg53;
                v16_1 = v10;
                v4 = v17;
                v17 = 0;
                v21 = 1;
                v10_1 = arg47;
                v19_1 = arg51;
            }

        label_444:
            v6.endDefaults();
            Function2 v43_1 = v3_2;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x98BF7AEE, v8, v4, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1168)");
            }

            ComposerKt.sourceInformationMarkerStart(v6, 0x66CD164F, "CC(remember):TextFieldDefaults.kt#9igjgp");
            v3 = (v8 & 14) == 4 ? v21 : v17;
            int v44 = v3;
            if((0xE000 & v8) == 0x4000) {
                v17 = v21;
            }

            Object v5_1 = v6.rememberedValue();
            if((v44 | v17) != 0 || v5_1 == Composer.Companion.getEmpty()) {
                v17 = v4;
                v5_2 = v0.filter(new AnnotatedString(v2, null, 2, null));
                v6.updateRememberedValue(v5_2);
            }
            else {
                v17 = v4;
            }

            ComposerKt.sourceInformationMarkerEnd(v6);
            String v5_3 = v5_2.getText().getText();
            TextFieldType v3_4 = TextFieldType.Outlined;
            Attached v22_2 = new Attached(false, null, null, 7, null);
            if(v1_1 == null) {
                v6.startReplaceGroup(1927058812);
                v6.endReplaceGroup();
                arg44 = v1_1;
                v4_2 = null;
            }
            else {
                v6.startReplaceGroup(1927058813);
                ComposerKt.sourceInformation(v6, "*1182@62008L15");
                arg44 = v1_1;
                v4_2 = ComposableLambdaKt.rememberComposableLambda(0xA8FE7A2E, ((boolean)v21), new OutlinedTextFieldDefaults$DecorationBox$2$1(v1_1), v6, 54);
                v6.endReplaceGroup();
            }

            String v0_1 = v5_3;
            int v2_1 = v8 >> 9;
            v5 = v17 << 21;
            int v1_4 = v8 << 3 & 0x380 | 6 | 0x70000 & v2_1 | 0x380000 & v2_1 | v5 & 0x1C00000 | v5 & 0xE000000 | v5 & 0x70000000;
            v23 = v8 & 0x380 | (v17 >> 9 & 14 | v8 >> 6 & 0x70) | v2_1 & 0x1C00 | v8 >> 3 & 0xE000 | v17 & 0x70000 | v17 << 6 & 0x380000 | v17 << 3 & 0x1C00000;
            v21_2 = v6;
            Function2 v8_1 = v12_1;
            v12_1 = v43_1;
            TextFieldImplKt.CommonDecorationBox(v3_4, v0_1, arg38, v22_2, v4_2, v8_1, v9, v10_1, v11, v12_1, v13_1, v14_1, v15, v16_1, v7, v18_1, v19_1, ((Function2)v20_2), v21_2, v1_4, v23);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v14_2 = v12_1;
            v15_1 = v13_1;
            v17_1 = v18_1;
            v18_2 = ((Function2)v20_2);
            v12_1 = v10_1;
            v13_1 = v11;
            v10_1 = v8_1;
            v11 = v9;
            v8_2 = v16_1;
            v16_3 = v19_1;
        }
        else {
            v21_2 = v6;
            v21_2.skipToGroupEnd();
            v11 = arg46;
            v12_1 = arg47;
            v13_1 = arg48;
            v14_2 = arg49;
            v15_1 = arg50;
            v16_3 = arg51;
            v17_1 = arg52;
            v18_2 = arg53;
            v8_2 = v10;
            v10_1 = arg45;
        }

        v9 = arg44;
        ScopeUpdateScope v0_2 = v21_2.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new OutlinedTextFieldDefaults$$ExternalSyntheticLambda1(this, arg37, arg38, arg39, arg40, arg41, arg42, v8_2, v9, v10_1, v11, v12_1, v13_1, v14_2, v15_1, v16_3, v17_1, v18_2, arg55, arg56, arg57));
        }
    }

    static final Unit DecorationBox$lambda$3(OutlinedTextFieldDefaults arg23, String arg24, Function2 arg25, boolean arg26, boolean arg27, VisualTransformation arg28, InteractionSource arg29, boolean arg30, Function2 arg31, Function2 arg32, Function2 arg33, Function2 arg34, Function2 arg35, Function2 arg36, Function2 arg37, TextFieldColors arg38, PaddingValues arg39, Function2 arg40, int arg41, int arg42, int arg43, Composer arg44, int arg45) {
        arg23.DecorationBox(arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg44, RecomposeScopeImplKt.updateChangedFlags(arg41 | 1), RecomposeScopeImplKt.updateChangedFlags(arg42), arg43);
        return Unit.INSTANCE;
    }

    public final TextFieldColors colors(Composer arg4, int arg5) {
        int v1 = -471651810;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)1215@63265L11,1215@63277L30:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1215)");
        }

        TextFieldColors v3 = this.getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(arg4, 6), arg4, arg5 << 3 & 0x70);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final TextFieldColors colors-0hiis_0(long arg88, long arg90, long arg92, long arg94, long arg96, long arg98, long arg100, long arg102, long arg104, long arg106, TextSelectionColors arg108, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, long arg145, long arg147, long arg149, long arg151, long arg153, long arg155, long arg157, long arg159, long arg161, long arg163, long arg165, long arg167, long arg169, long arg171, Composer arg173, int arg174, int arg175, int arg176, int arg177, int arg178, int arg179, int arg180) {
        Composer v0 = arg173;
        int v1 = arg179;
        int v2 = arg180;
        ComposerKt.sourceInformationMarkerStart(v0, 0x695BB4BD, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedBorderColor:c#ui.graphics.Color,unfocusedBorderColor:c#ui.graphics.Color,disabledBorderColor:c#ui.graphics.Color,errorBorderColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)1317@70088L11,1317@70100L30:TextFieldDefaults.kt#uh7d8r");
        long v5 = (v1 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg88;
        long v7 = (v1 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg90;
        long v9 = (v1 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg92;
        long v11 = (v1 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg94;
        long v13 = (v1 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg96;
        long v15 = (v1 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg98;
        long v17 = (v1 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg100;
        long v19 = (v1 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg102;
        long v21 = (v1 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg104;
        long v23 = (v1 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg106;
        TextSelectionColors v3 = (v1 & 0x400) != 0 ? null : arg108;
        long v25 = (v1 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg109;
        long v27 = (v1 & 0x1000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg111;
        long v29 = (v1 & 0x2000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg113;
        long v31 = (v1 & 0x4000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg115;
        long v33 = (0x8000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg117;
        long v35 = (0x10000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg119;
        long v37 = (0x20000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg121;
        long v39 = (0x40000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg123;
        long v41 = (0x80000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg125;
        long v43 = (0x100000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg127;
        long v45 = (0x200000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg129;
        long v47 = (0x400000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg131;
        long v49 = (0x800000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg133;
        long v51 = (0x1000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg135;
        long v53 = (0x2000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg137;
        long v55 = (0x4000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg139;
        long v57 = (0x8000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg141;
        long v59 = (0x10000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg143;
        long v61 = (0x20000000 & v1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg145;
        long v63 = (v1 & 0x40000000) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg147;
        long v65 = (v2 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg149;
        long v67 = (v2 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg151;
        long v69 = (v2 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg153;
        long v71 = (v2 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg155;
        long v73 = (v2 & 16) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg157;
        long v75 = (v2 & 0x20) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg159;
        long v77 = (v2 & 0x40) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg161;
        long v79 = (v2 & 0x80) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg163;
        long v81 = (v2 & 0x100) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg165;
        long v83 = (v2 & 0x200) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg167;
        long v85 = (v2 & 0x400) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg169;
        long v1_1 = (v2 & 0x800) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg171;
        if(ComposerKt.isTraceInProgress()) {
            arg171 = v1_1;
            arg108 = v3;
            ComposerKt.traceEventStart(0x695BB4BD, arg174, arg175, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1317)");
        }
        else {
            arg171 = v1_1;
            arg108 = v3;
        }

        TextFieldColors v1_2 = this.getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(v0, 6), v0, arg178 >> 6 & 0x70).copy-ejIjP34(v5, v7, v9, v11, v13, v15, v17, v19, v21, v23, arg108, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, v81, v83, v85, arg171);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_2;
    }

    public final PaddingValues contentPadding-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return PaddingKt.PaddingValues-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues contentPadding-a9UjIt4$default(OutlinedTextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 2) != 0) {
            arg2 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 4) != 0) {
            arg3 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 8) != 0) {
            arg4 = TextFieldImplKt.getTextFieldPadding();
        }

        return arg0.contentPadding-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public final TextFieldDecorator decorator(TextFieldState arg24, boolean arg25, TextFieldLineLimits arg26, OutputTransformation arg27, InteractionSource arg28, TextFieldLabelPosition arg29, Function3 arg30, Function2 arg31, Function2 arg32, Function2 arg33, Function2 arg34, Function2 arg35, Function2 arg36, boolean arg37, TextFieldColors arg38, PaddingValues arg39, Function2 arg40, Composer arg41, int arg42, int arg43, int arg44) {
        Function2 v22_1;
        boolean v18;
        InteractionSource v7;
        boolean v6_1;
        TextFieldColors v5_1;
        OutlinedTextFieldDefaults v6;
        TextFieldLabelPosition v9_1;
        Composer v0 = arg41;
        int v1 = arg43;
        int v2 = arg44;
        ComposerKt.sourceInformationMarkerStart(v0, -449059361, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)980@51820L8,982@51932L371:TextFieldDefaults.kt#uh7d8r");
        if((v2 & 0x20) != 0) {
            Attached v9 = new Attached(false, null, null, 7, null);
        }
        else {
            v9_1 = arg29;
        }

        Function3 v5 = null;
        Function3 v10 = (v2 & 0x40) != 0 ? v5 : arg30;
        Function2 v11 = (v2 & 0x80) != 0 ? ((Function2)v5) : arg31;
        Function2 v12 = (v2 & 0x100) != 0 ? ((Function2)v5) : arg32;
        Function2 v13 = (v2 & 0x200) != 0 ? ((Function2)v5) : arg33;
        Function2 v14 = (v2 & 0x400) != 0 ? ((Function2)v5) : arg34;
        Function2 v15 = (v2 & 0x800) != 0 ? ((Function2)v5) : arg35;
        Function2 v16 = (v2 & 0x1000) != 0 ? ((Function2)v5) : arg36;
        boolean v3 = (v2 & 0x2000) != 0 ? false : arg37;
        if((v2 & 0x4000) != 0) {
            v6 = this;
            v5_1 = v6.colors(v0, v1 >> 21 & 14);
        }
        else {
            v6 = this;
            v5_1 = arg38;
        }

        PaddingValues v20 = (0x8000 & v2) != 0 ? OutlinedTextFieldDefaults.contentPadding-a9UjIt4$default(v6, 0f, 0f, 0f, 0f, 15, null) : arg39;
        if((v2 & 0x10000) != 0) {
            v6_1 = arg25;
            v7 = arg28;
            v18 = v3;
            ComposableLambda v22 = ComposableLambdaKt.rememberComposableLambda(0xF641AACA, true, new OutlinedTextFieldDefaults$decorator$1(v6_1, v3, v7, v5_1), v0, 54);
        }
        else {
            v6_1 = arg25;
            v7 = arg28;
            v18 = v3;
            v22_1 = arg40;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-449059361, arg42, v1, "androidx.compose.material3.OutlinedTextFieldDefaults.decorator (TextFieldDefaults.kt:993)");
        }

        OutlinedTextFieldDefaults$decorator$2 v5_2 = new OutlinedTextFieldDefaults$decorator$2(arg27, arg24, arg26, v9_1, v10, v11, v12, v13, v14, v15, v16, v6_1, v18, v7, v20, v5_1, v22_1);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((TextFieldDecorator)v5_2);
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme arg96, Composer arg97, int arg98) {
        ProvidableCompositionLocal v4_1;
        TextFieldColors v4;
        ColorScheme v0 = arg96;
        Composer v1 = arg97;
        int v3 = 0xEE92E2C7;
        ComposerKt.sourceInformationMarkerStart(v1, v3, "C(<get-defaultOutlinedTextFieldColors>):TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, arg98, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1365)");
        }

        TextFieldColors v5 = v0.getDefaultOutlinedTextFieldColorsCached$material3();
        String v2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
        v3 = 0x789C5F52;
        if(v5 == null) {
            v1.startReplaceGroup(390452338);
            v1.endReplaceGroup();
            v4 = null;
        }
        else {
            v1.startReplaceGroup(390452339);
            ComposerKt.sourceInformation(v1, "*1367@72895L7");
            v4_1 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v1, v3, v2);
            Object v4_2 = v1.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            if(Intrinsics.areEqual(v5.getTextSelectionColors(), v4_2)) {
            }
            else {
                v5 = TextFieldColors.copy-ejIjP34$default(v5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v4_2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFFFFFBFF, 0x7FF, null);
                v0.setDefaultOutlinedTextFieldColorsCached$material3(v5);
            }

            v1.endReplaceGroup();
            v4 = v5;
        }

        if(v4 == null) {
            v1.startReplaceGroup(0x95686259);
            ComposerKt.sourceInformation(v1, "1389@74318L7");
            long v6 = ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long v8 = ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long v10 = Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0f, 0f, 0f, 14, null);
            long v12 = ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long v14 = Color.Companion.getTransparent-0d7_KjU();
            long v16 = Color.Companion.getTransparent-0d7_KjU();
            long v18 = Color.Companion.getTransparent-0d7_KjU();
            long v20 = Color.Companion.getTransparent-0d7_KjU();
            long v22 = ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long v24 = ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            v4_1 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v1, v3, v2);
            Object v2_1 = v1.consume(((CompositionLocal)v4_1));
            ComposerKt.sourceInformationMarkerEnd(v1);
            v5 = new TextFieldColors(v6, v8, v10, v12, v14, v16, v18, v20, v22, v24, v2_1, ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            v0.setDefaultOutlinedTextFieldColorsCached$material3(v5);
            v1.endReplaceGroup();
            v4 = v5;
        }
        else {
            v1.startReplaceGroup(0x95656B93);
            v1.endReplaceGroup();
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v4;
    }

    public final float getFocusedBorderThickness-D9Ej5fM() {
        return OutlinedTextFieldDefaults.FocusedBorderThickness;
    }

    public final float getMinHeight-D9Ej5fM() {
        return OutlinedTextFieldDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return OutlinedTextFieldDefaults.MinWidth;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xC06A949F;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)887@46101L5:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:887)");
        }

        Shape v2 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getUnfocusedBorderThickness-D9Ej5fM() {
        return OutlinedTextFieldDefaults.UnfocusedBorderThickness;
    }
}

