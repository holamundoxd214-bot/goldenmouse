package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
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
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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

@Metadata(d1={"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0019\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0002\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u001F\u001A\u00020 2 \b\u0002\u0010!\u001A\u001A\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2\u0015\b\u0002\u0010\'\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010.\u001A\u00020\u00182\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u0002022\u0013\b\u0002\u00103\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u00104JY\u00105\u001A\u00020$2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u00106\u001A\u0002072\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\tH\u0007¢\u0006\u0004\b:\u0010;JU\u0010<\u001A\u000207*\u0002072\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\n\b\u0002\u0010/\u001A\u0004\u0018\u0001002\n\b\u0002\u0010=\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\t¢\u0006\u0004\b>\u0010?J¦\u0002\u0010@\u001A\u00020$2\u0006\u0010A\u001A\u00020B2\u0011\u0010C\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010D\u001A\u00020\u00182\u0006\u0010E\u001A\u00020F2\u0006\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010.\u001A\u00020\u00182\u0015\b\u0002\u0010!\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010\'\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010)\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010*\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010+\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010,\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\u0015\b\u0002\u0010-\u001A\u000F\u0012\u0004\u0012\u00020$\u0018\u00010(¢\u0006\u0002\b%2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u0002022\u0013\b\u0002\u00103\u001A\r\u0012\u0004\u0012\u00020$0(¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010GJ5\u0010H\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\t¢\u0006\u0004\bM\u0010NJ5\u0010O\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\t¢\u0006\u0004\bP\u0010NJ7\u0010Q\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\tH\u0000¢\u0006\u0004\bR\u0010NJ\r\u0010/\u001A\u000200H\u0007¢\u0006\u0002\u0010SJÂ\u0003\u0010/\u001A\u0002002\b\b\u0002\u0010T\u001A\u00020U2\b\b\u0002\u0010V\u001A\u00020U2\b\b\u0002\u0010W\u001A\u00020U2\b\b\u0002\u0010X\u001A\u00020U2\b\b\u0002\u0010Y\u001A\u00020U2\b\b\u0002\u0010Z\u001A\u00020U2\b\b\u0002\u0010[\u001A\u00020U2\b\b\u0002\u0010\\\u001A\u00020U2\b\b\u0002\u0010]\u001A\u00020U2\b\b\u0002\u0010^\u001A\u00020U2\n\b\u0002\u0010_\u001A\u0004\u0018\u00010`2\b\b\u0002\u0010a\u001A\u00020U2\b\b\u0002\u0010b\u001A\u00020U2\b\b\u0002\u0010c\u001A\u00020U2\b\b\u0002\u0010d\u001A\u00020U2\b\b\u0002\u0010e\u001A\u00020U2\b\b\u0002\u0010f\u001A\u00020U2\b\b\u0002\u0010g\u001A\u00020U2\b\b\u0002\u0010h\u001A\u00020U2\b\b\u0002\u0010i\u001A\u00020U2\b\b\u0002\u0010j\u001A\u00020U2\b\b\u0002\u0010k\u001A\u00020U2\b\b\u0002\u0010l\u001A\u00020U2\b\b\u0002\u0010m\u001A\u00020U2\b\b\u0002\u0010n\u001A\u00020U2\b\b\u0002\u0010o\u001A\u00020U2\b\b\u0002\u0010p\u001A\u00020U2\b\b\u0002\u0010q\u001A\u00020U2\b\b\u0002\u0010r\u001A\u00020U2\b\b\u0002\u0010s\u001A\u00020U2\b\b\u0002\u0010t\u001A\u00020U2\b\b\u0002\u0010u\u001A\u00020U2\b\b\u0002\u0010v\u001A\u00020U2\b\b\u0002\u0010w\u001A\u00020U2\b\b\u0002\u0010x\u001A\u00020U2\b\b\u0002\u0010y\u001A\u00020U2\b\b\u0002\u0010z\u001A\u00020U2\b\b\u0002\u0010{\u001A\u00020U2\b\b\u0002\u0010|\u001A\u00020U2\b\b\u0002\u0010}\u001A\u00020U2\b\b\u0002\u0010~\u001A\u00020U2\b\b\u0002\u0010\u007F\u001A\u00020U2\t\b\u0002\u0010\u0080\u0001\u001A\u00020UH\u0007¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001D\u0010\u0083\u0001\u001A\u000200*\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001A\u00020`H\u0000¢\u0006\u0003\b\u0086\u0001JI\u0010<\u001A\u000207*\u0002072\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010/\u001A\u0002002\b\b\u0002\u00108\u001A\u00020\t2\b\b\u0002\u00109\u001A\u00020\tH\u0007¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J9\u0010\u0089\u0001\u001A\u00020$2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010.\u001A\u00020\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010/\u001A\u0002002\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0007¢\u0006\u0003\u0010\u008A\u0001J9\u0010\u0097\u0001\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\tH\u0007¢\u0006\u0005\b\u0098\u0001\u0010NJ9\u0010\u0099\u0001\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\tH\u0007¢\u0006\u0005\b\u009A\u0001\u0010NJ9\u0010\u009B\u0001\u001A\u0002022\b\b\u0002\u0010I\u001A\u00020\t2\b\b\u0002\u0010K\u001A\u00020\t2\b\b\u0002\u0010J\u001A\u00020\t2\b\b\u0002\u0010L\u001A\u00020\tH\u0007¢\u0006\u0005\b\u009C\u0001\u0010NR\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\r\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u000F\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0010\u0010\u000BR\u0013\u0010\u0011\u001A\u00020\t¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\u0012\u0010\u000BR\u001D\u0010\u008B\u0001\u001A\u00020\u00058GX\u0087\u0004¢\u0006\u000E\u0012\u0005\b\u008C\u0001\u0010\u0003\u001A\u0005\b\u008D\u0001\u0010\u0007R\u001D\u0010\u008E\u0001\u001A\u00020\u00058GX\u0087\u0004¢\u0006\u000E\u0012\u0005\b\u008F\u0001\u0010\u0003\u001A\u0005\b\u0090\u0001\u0010\u0007R!\u0010\u0091\u0001\u001A\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0092\u0001\u0010\u0003\u001A\u0005\b\u0093\u0001\u0010\u000BR!\u0010\u0094\u0001\u001A\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0002\u0010\f\u0012\u0005\b\u0095\u0001\u0010\u0003\u001A\u0005\b\u0096\u0001\u0010\u000B¨\u0006\u009D\u0001"}, d2={"Landroidx/compose/material3/TextFieldDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "MinHeight", "Landroidx/compose/ui/unit/Dp;", "getMinHeight-D9Ej5fM", "()F", "F", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedIndicatorThickness", "getUnfocusedIndicatorThickness-D9Ej5fM", "FocusedIndicatorThickness", "getFocusedIndicatorThickness-D9Ej5fM", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "enabled", "", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Landroidx/compose/foundation/text/input/TextFieldState;ZLandroidx/compose/foundation/text/input/TextFieldLineLimits;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Container", "modifier", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "Container-4EFweAY", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "indicatorLine", "textFieldShape", "indicatorLine-AWlRVLg", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FF)Landroidx/compose/ui/Modifier;", "DecorationBox", "value", "", "innerTextField", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "contentPaddingWithLabel", "start", "end", "top", "bottom", "contentPaddingWithLabel-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "contentPaddingWithoutLabel", "contentPaddingWithoutLabel-a9UjIt4", "supportingTextPadding", "supportingTextPadding-a9UjIt4$material3", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "defaultTextFieldColors", "Landroidx/compose/material3/ColorScheme;", "localTextSelectionColors", "defaultTextFieldColors$material3", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "ContainerBox", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "outlinedShape", "getOutlinedShape$annotations", "getOutlinedShape", "filledShape", "getFilledShape$annotations", "getFilledShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM$annotations", "getUnfocusedBorderThickness-D9Ej5fM", "FocusedBorderThickness", "getFocusedBorderThickness-D9Ej5fM$annotations", "getFocusedBorderThickness-D9Ej5fM", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "outlinedTextFieldPadding", "outlinedTextFieldPadding-a9UjIt4", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldDefaults {
    public static final int $stable;
    private static final float FocusedBorderThickness;
    private static final float FocusedIndicatorThickness;
    public static final TextFieldDefaults INSTANCE;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float UnfocusedBorderThickness;
    private static final float UnfocusedIndicatorThickness;

    static {
        TextFieldDefaults.INSTANCE = new TextFieldDefaults();
        TextFieldDefaults.MinHeight = Dp.constructor-impl(56f);
        TextFieldDefaults.MinWidth = Dp.constructor-impl(280f);
        float v0 = Dp.constructor-impl(1f);
        TextFieldDefaults.UnfocusedIndicatorThickness = v0;
        float v1 = Dp.constructor-impl(2f);
        TextFieldDefaults.FocusedIndicatorThickness = v1;
        TextFieldDefaults.UnfocusedBorderThickness = v0;
        TextFieldDefaults.FocusedBorderThickness = v1;
    }

    private TextFieldDefaults() {
        super();
    }

    public final void Container-4EFweAY(boolean arg22, boolean arg23, InteractionSource arg24, Modifier arg25, TextFieldColors arg26, Shape arg27, float arg28, float arg29, Composer arg30, int arg31, int arg32) {
        float v9_2;
        Composer v17_1;
        Modifier v5_1;
        Composer v9_1;
        TextFieldColors v6_1;
        float v20;
        float v8_1;
        Shape v7_1;
        Modifier v1_1;
        int v20_1;
        float v12_2;
        TextFieldColors v1_2;
        Companion v8_2;
        int v15;
        float v14_1;
        int v14;
        float v13_1;
        int v13;
        Shape v12_1;
        int v12;
        Modifier v8;
        int v7;
        int v6;
        TextFieldDefaults v0 = this;
        boolean v2 = arg22;
        boolean v3 = arg23;
        InteractionSource v4 = arg24;
        int v10 = arg31;
        int v11 = arg32;
        Composer v5 = arg30.startRestartGroup(0xCF343886);
        ComposerKt.sourceInformation(v5, "C(Container)N(enabled,isError,interactionSource,modifier,colors,shape,focusedIndicatorLineThickness:c#ui.unit.Dp,unfocusedIndicatorLineThickness:c#ui.unit.Dp)242@12387L25,247@12703L7,245@12536L189,249@12734L540:TextFieldDefaults.kt#uh7d8r");
        if((v11 & 1) != 0) {
            v6 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v6 = v5.changed(v2) ? 4 : 2;
            v6 |= v10;
        }
        else {
            v6 = v10;
        }

        if((v11 & 2) != 0) {
            v6 |= 0x30;
        }
        else if((v10 & 0x30) == 0) {
            v7 = v5.changed(v3) ? 0x20 : 16;
            v6 |= v7;
        }

        if((v11 & 4) != 0) {
            v6 |= 0x180;
        }
        else if((v10 & 0x180) == 0) {
            v7 = v5.changed(v4) ? 0x100 : 0x80;
            v6 |= v7;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v6 |= 0xC00;
            goto label_63;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg25;
            int v9 = v5.changed(v8) ? 0x800 : 0x400;
            v6 |= v9;
        }
        else {
        label_63:
            v8 = arg25;
        }

        if((v10 & 0x6000) == 0) {
            v12 = (v11 & 16) != 0 || !v5.changed(arg26) ? 0x2000 : 0x4000;
            v6 |= v12;
        }

        if((0x30000 & v10) == 0) {
            if((v11 & 0x20) == 0) {
                v12_1 = arg27;
                if(v5.changed(v12_1)) {
                    v13 = 0x20000;
                }
                else {
                    goto label_89;
                }
            }
            else {
                v12_1 = arg27;
            label_89:
                v13 = 0x10000;
            }

            v6 |= v13;
        }
        else {
            v12_1 = arg27;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v13_1 = arg28;
                if(v5.changed(v13_1)) {
                    v14 = 0x100000;
                }
                else {
                    goto label_104;
                }
            }
            else {
                v13_1 = arg28;
            label_104:
                v14 = 0x80000;
            }

            v6 |= v14;
        }
        else {
            v13_1 = arg28;
        }

        if((0xC00000 & v10) == 0) {
            if((v11 & 0x80) == 0) {
                v14_1 = arg29;
                if(v5.changed(v14_1)) {
                    v15 = 0x800000;
                }
                else {
                    goto label_119;
                }
            }
            else {
                v14_1 = arg29;
            label_119:
                v15 = 0x400000;
            }

            v6 |= v15;
        }
        else {
            v14_1 = arg29;
        }

        int v16 = 0x6000000;
        if((v11 & 0x100) != 0) {
            v6 |= v16;
        }
        else if((v10 & v16) == 0) {
            v15 = v5.changed(v0) ? 0x4000000 : 0x2000000;
            v6 |= v15;
        }

        boolean v1 = (0x2492493 & v6) != 0x2492492 ? true : false;
        if(v5.shouldExecute(v1, v6 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "237@12135L8,238@12186L5");
            int v17 = 0xFFC7FFFF;
            int v18 = 0xFFF8FFFF;
            int v19 = 0xFFFF1FFF;
            int v30 = 0xFE3FFFFF;
            v15 = 6;
            if((v10 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v7 != 0) {
                    v8_2 = Modifier.Companion;
                }

                if((v11 & 16) != 0) {
                    v1_2 = v0.colors(v5, v6 >> 24 & 14);
                    v6 &= v19;
                }
                else {
                    v1_2 = arg26;
                }

                if((v11 & 0x20) != 0) {
                    v7_1 = TextFieldDefaults.INSTANCE.getShape(v5, v15);
                    v6 &= v18;
                }
                else {
                    v7_1 = v12_1;
                }

                if((v11 & 0x40) != 0) {
                    v12_2 = TextFieldDefaults.FocusedIndicatorThickness;
                    v6 &= v17;
                }
                else {
                    v12_2 = v13_1;
                }

                if((v11 & 0x80) != 0) {
                    v20_1 = v6 & v30;
                    v6_1 = v1_2;
                    v1_1 = ((Modifier)v8_2);
                    v8_1 = v12_2;
                    v12 = v20_1;
                    v20 = TextFieldDefaults.UnfocusedIndicatorThickness;
                    goto label_220;
                }

                v20_1 = v6;
                v6_1 = v1_2;
                v1_1 = ((Modifier)v8_2);
                v8_1 = v12_2;
                v12 = v20_1;
                v20 = v14_1;
            }
            else {
                v5.skipToGroupEnd();
                if((v11 & 16) != 0) {
                    v6 &= v19;
                }

                if((v11 & 0x20) != 0) {
                    v6 &= v18;
                }

                if((v11 & 0x40) != 0) {
                    v6 &= v17;
                }

                if((v11 & 0x80) != 0) {
                    v6 &= v30;
                }

                v1_1 = v8;
                v7_1 = v12_1;
                v8_1 = v13_1;
                v20 = v14_1;
                v12 = v6;
                v6_1 = arg26;
            }

        label_220:
            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCF343886, v12, -1, "androidx.compose.material3.TextFieldDefaults.Container (TextFieldDefaults.kt:241)");
            }

            v9_1 = v5;
            v5_1 = TextFieldImplKt.textFieldBackground(v1_1, new TextFieldDefaults$sam$androidx_compose_ui_graphics_ColorProducer$0(new TextFieldDefaults$Container$1(SingleValueAnimationKt.animateColorAsState-euL9pac(v6_1.containerColor-XeAY9LY$material3(v2, v3, FocusInteractionKt.collectIsFocusedAsState(v4, v5, v12 >> 6 & 14).getValue().booleanValue()), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v5, v15), null, null, v5, 0, 12))), v7_1);
            Modifier v12_3 = v1_1;
            v1_1 = v5_1;
            TextFieldColors v5_2 = v6_1;
            Shape v6_2 = v7_1;
            float v7_2 = v8_1;
            v8_1 = v20;
            BoxKt.Box(v0.indicatorLine-AWlRVLg(v1_1, v2, v3, v4, v5_2, v6_2, v7_2, v8_1), v9_1, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v17_1 = v9_1;
            v9_2 = v8_1;
            v8_1 = v7_2;
            v7_1 = v6_2;
            v6_1 = v5_2;
            v5_1 = v12_3;
        }
        else {
            v9_1 = v5;
            v9_1.skipToGroupEnd();
            v6_1 = arg26;
            v5_1 = v8;
            v17_1 = v9_1;
            v7_1 = v12_1;
            v8_1 = v13_1;
            v9_2 = v14_1;
        }

        ScopeUpdateScope v12_4 = v17_1.endRestartGroup();
        if(v12_4 != null) {
            v12_4.updateScope(new TextFieldDefaults$$ExternalSyntheticLambda2(this, arg22, arg23, arg24, v5_1, v6_1, v7_1, v8_1, v9_2, v10, v11));
        }
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to TextFieldDefaults.Container", replaceWith="<_subannotation>") public final void ContainerBox(boolean arg21, boolean arg22, InteractionSource arg23, TextFieldColors arg24, Shape arg25, Composer arg26, int arg27, int arg28) {
        Shape v6;
        Composer v17;
        TextFieldDefaults v8;
        int v4;
        Shape v3_1;
        TextFieldColors v13;
        InteractionSource v11;
        int v3;
        boolean v10;
        boolean v9;
        int v2;
        int v7 = arg27;
        int v0 = 918564008;
        Composer v1 = arg26.startRestartGroup(v0);
        ComposerKt.sourceInformation(v1, "C(ContainerBox)N(enabled,isError,interactionSource,colors,shape)761@41419L368:TextFieldDefaults.kt#uh7d8r");
        if((arg28 & 1) != 0) {
            v2 = v7 | 6;
            v9 = arg21;
        }
        else {
            v9 = arg21;
            if((v7 & 6) == 0) {
                v2 = v1.changed(v9) ? 4 : 2;
                v2 |= v7;
            }
            else {
                v2 = v7;
            }
        }

        if((arg28 & 2) != 0) {
            v2 |= 0x30;
            v10 = arg22;
        }
        else {
            v10 = arg22;
            if((v7 & 0x30) == 0) {
                v3 = v1.changed(v10) ? 0x20 : 16;
                v2 |= v3;
            }
        }

        if((arg28 & 4) != 0) {
            v2 |= 0x180;
            v11 = arg23;
        }
        else {
            v11 = arg23;
            if((v7 & 0x180) == 0) {
                v3 = v1.changed(v11) ? 0x100 : 0x80;
                v2 |= v3;
            }
        }

        if((arg28 & 8) != 0) {
            v2 |= 0xC00;
            v13 = arg24;
        }
        else {
            v13 = arg24;
            if((v7 & 0xC00) == 0) {
                v3 = v1.changed(v13) ? 0x800 : 0x400;
                v2 |= v3;
            }
        }

        if((v7 & 0x6000) == 0) {
            if((arg28 & 16) == 0) {
                v3_1 = arg25;
                if(v1.changed(v3_1)) {
                    v4 = 0x4000;
                }
                else {
                    goto label_74;
                }
            }
            else {
                v3_1 = arg25;
            label_74:
                v4 = 0x2000;
            }

            v2 |= v4;
        }
        else {
            v3_1 = arg25;
        }

        int v5 = 0x30000;
        if((arg28 & 0x20) != 0) {
            v2 |= v5;
            v8 = this;
        }
        else {
            v8 = this;
            if((v7 & v5) == 0) {
                v4 = v1.changed(v8) ? 0x20000 : 0x10000;
                v2 |= v4;
            }
        }

        boolean v4_1 = (74899 & v2) != 74898 ? true : false;
        if(v1.shouldExecute(v4_1, v2 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "759@41396L5");
            v5 = 0xFFFF1FFF;
            if((v7 & 1) != 0 && !v1.getDefaultsInvalid()) {
                v1.skipToGroupEnd();
                if((arg28 & 16) != 0) {
                    goto label_121;
                }
            }
            else if((arg28 & 16) != 0) {
                v3_1 = TextFieldDefaults.INSTANCE.getShape(v1, 6);
            label_121:
                v2 &= v5;
            }

            Shape v14 = v3_1;
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.material3.TextFieldDefaults.ContainerBox (TextFieldDefaults.kt:761)");
            }

            v3 = v2 << 3;
            v17 = v1;
            v8.Container-4EFweAY(v9, v10, v11, Modifier.Companion, v13, v14, TextFieldDefaults.FocusedIndicatorThickness, TextFieldDefaults.UnfocusedIndicatorThickness, v17, v2 & 14 | 0xC00 | v2 & 0x70 | v2 & 0x380 | 0xE000 & v3 | v3 & 0x70000 | v2 << 9 & 0xE000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6 = v14;
        }
        else {
            v17 = v1;
            v17.skipToGroupEnd();
            v6 = v3_1;
        }

        ScopeUpdateScope v9_1 = v17.endRestartGroup();
        if(v9_1 != null) {
            v9_1.updateScope(new TextFieldDefaults$$ExternalSyntheticLambda1(this, arg21, arg22, arg23, arg24, v6, v7, arg28));
        }
    }

    static final Unit ContainerBox$lambda$7(TextFieldDefaults arg10, boolean arg11, boolean arg12, InteractionSource arg13, TextFieldColors arg14, Shape arg15, int arg16, int arg17, Composer arg18, int arg19) {
        arg10.ContainerBox(arg11, arg12, arg13, arg14, arg15, arg18, RecomposeScopeImplKt.updateChangedFlags(arg16 | 1), arg17);
        return Unit.INSTANCE;
    }

    static final Unit Container_4EFweAY$lambda$0(TextFieldDefaults arg13, boolean arg14, boolean arg15, InteractionSource arg16, Modifier arg17, TextFieldColors arg18, Shape arg19, float arg20, float arg21, int arg22, int arg23, Composer arg24, int arg25) {
        arg13.Container-4EFweAY(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    public final void DecorationBox(String arg36, Function2 arg37, boolean arg38, boolean arg39, VisualTransformation arg40, InteractionSource arg41, boolean arg42, Function2 arg43, Function2 arg44, Function2 arg45, Function2 arg46, Function2 arg47, Function2 arg48, Function2 arg49, Shape arg50, TextFieldColors arg51, PaddingValues arg52, Function2 arg53, Composer arg54, int arg55, int arg56, int arg57) {
        Shape v16_2;
        TextFieldColors v17_2;
        PaddingValues v18_3;
        boolean v8_2;
        Function2 v11_2;
        Composer v25_2;
        Function2 v15_1;
        ComposableLambda v25_1;
        String v45;
        PaddingValues v42_1;
        TransformedText v9_3;
        Shape v43_1;
        PaddingValues v3_1;
        Function2 v17_1;
        Function2 v24_1;
        TextFieldColors v23_1;
        Shape v1_1;
        Function2 v16_1;
        Function2 v22_1;
        Function2 v14_2;
        Function2 v13_2;
        ComposableLambda v24_2;
        ComposableLambda v0_5;
        Function2 v42;
        Shape v13_3;
        PaddingValues v1_2;
        TextFieldColors v3_2;
        Shape v8_1;
        Function2 v19_1;
        Function2 v9_1;
        int v19;
        int v32;
        int v31;
        int v30;
        Function2 v0_1;
        int v29;
        int v27;
        Function2 v12;
        boolean v15;
        int v22;
        InteractionSource v14_1;
        boolean v11;
        int v16;
        boolean v13_1;
        Function2 v10;
        int v7;
        TextFieldDefaults v1 = this;
        String v2 = arg36;
        VisualTransformation v6 = arg40;
        int v0 = arg55;
        int v3 = arg56;
        int v4 = arg57;
        Composer v5 = arg54.startRestartGroup(1806980801);
        ComposerKt.sourceInformation(v5, "C(DecorationBox)N(value,innerTextField,enabled,singleLine,visualTransformation,interactionSource,isError,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,shape,colors,contentPadding,container)403@21131L129,409@21314L749:TextFieldDefaults.kt#uh7d8r");
        if((v4 & 1) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v5.changed(v2) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        if((v4 & 2) != 0) {
            v7 |= 0x30;
            goto label_39;
        }
        else if((v0 & 0x30) == 0) {
            v10 = arg37;
            int v13 = v5.changedInstance(v10) ? 0x20 : 16;
            v7 |= v13;
        }
        else {
        label_39:
            v10 = arg37;
        }

        if((v4 & 4) != 0) {
            v7 |= 0x180;
            goto label_54;
        }
        else if((v0 & 0x180) == 0) {
            v13_1 = arg38;
            v16 = v5.changed(v13_1) ? 0x100 : 0x80;
            v7 |= v16;
        }
        else {
        label_54:
            v13_1 = arg38;
        }

        int v17 = 0x800;
        int v18 = 0x400;
        if((v4 & 8) != 0) {
            v7 |= 0xC00;
            goto label_71;
        }
        else if((v0 & 0xC00) == 0) {
            v11 = arg39;
            v16 = v5.changed(v11) ? v17 : v18;
            v7 |= v16;
        }
        else {
        label_71:
            v11 = arg39;
        }

        if((v4 & 16) != 0) {
            v7 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            int v14 = v5.changed(v6) ? 0x4000 : 0x2000;
            v7 |= v14;
        }

        int v20 = 0x30000;
        int v21 = 0x10000;
        if((v4 & 0x20) != 0) {
            v7 |= v20;
            goto label_100;
        }
        else if((v0 & v20) == 0) {
            v14_1 = arg41;
            v22 = v5.changed(v14_1) ? 0x20000 : v21;
            v7 |= v22;
        }
        else {
        label_100:
            v14_1 = arg41;
        }

        v22 = v4 & 0x40;
        int v23 = 0x180000;
        if(v22 != 0) {
            v7 |= v23;
            v15 = arg42;
        }
        else {
            v15 = arg42;
            if((v0 & v23) == 0) {
                int v24 = v5.changed(v15) ? 0x100000 : 0x80000;
                v7 |= v24;
            }
        }

        int v9 = v4 & 0x80;
        int v25 = 0xC00000;
        if(v9 != 0) {
            v7 |= v25;
            v12 = arg43;
        }
        else {
            v12 = arg43;
            if((v0 & v25) == 0) {
                v27 = v5.changedInstance(v12) ? 0x800000 : 0x400000;
                v7 |= v27;
            }
        }

        int v8 = v4 & 0x100;
        int v28 = 0x6000000;
        if(v8 != 0) {
            v7 |= v28;
        }
        else {
            v29 = v0 & v28;
            v0_1 = arg44;
            if(v29 == 0) {
                v29 = v5.changedInstance(v0_1) ? 0x4000000 : 0x2000000;
                v7 |= v29;
            }
        }

        v0 = v4 & 0x200;
        v29 = 0x30000000;
        if(v0 != 0) {
            v7 |= v29;
            goto label_162;
        }
        else if((arg55 & v29) == 0) {
            v29 = v0;
            v30 = v5.changedInstance(arg45) ? 0x20000000 : 0x10000000;
            v7 |= v30;
        }
        else {
        label_162:
            v29 = v0;
        }

        v0 = v4 & 0x400;
        if(v0 != 0) {
            v31 = v3 | 6;
            v30 = v0;
        }
        else if((v3 & 6) == 0) {
            v30 = v0;
            v31 = v5.changedInstance(arg46) ? 4 : 2;
            v31 |= v3;
        }
        else {
            v30 = v0;
            v31 = v3;
        }

        v0 = v4 & 0x800;
        if(v0 != 0) {
            v31 |= 0x30;
            v32 = v0;
        }
        else if((v3 & 0x30) == 0) {
            v32 = v0;
            v19 = v5.changedInstance(arg47) ? 0x20 : 16;
            v31 |= v19;
        }
        else {
            v32 = v0;
        }

        v0 = v31;
        v19 = v8;
        v8 = v4 & 0x1000;
        if(v8 != 0) {
            v0 |= 0x180;
        }
        else {
            v31 = v0;
            if((v3 & 0x180) == 0) {
                v16 = v5.changedInstance(arg48) ? 0x100 : 0x80;
                v0 = v31 | v16;
            }
            else {
                v0 = v31;
            }
        }

        v16 = v8;
        v8 = v4 & 0x2000;
        if(v8 != 0) {
            v17 = v0 | 0xC00;
        }
        else {
            v23 = v0;
            if((v3 & 0xC00) == 0) {
                if(v5.changedInstance(arg49)) {
                }
                else {
                    v17 = v18;
                }

                v17 |= v23;
            }
            else {
                v17 = v23;
            }
        }

        if((v3 & 0x6000) == 0) {
            v18 = (v4 & 0x4000) != 0 || !v5.changed(arg50) ? 0x2000 : 0x4000;
            v17 |= v18;
        }

        if((v3 & v20) == 0) {
            TextFieldColors v0_2 = arg51;
            v18 = (v4 & 0x8000) != 0 || !v5.changed(v0_2) ? v21 : 0x20000;
            v17 |= v18;
        }

        if((v3 & 0x180000) == 0) {
            PaddingValues v0_3 = arg52;
            v18 = (v4 & v21) != 0 || !v5.changed(v0_3) ? 0x80000 : 0x100000;
            v17 |= v18;
        }

        v18 = v4 & 0x20000;
        if(v18 != 0) {
            v17 |= v25;
        }
        else {
            v0_1 = arg53;
            if((v3 & v25) == 0) {
                v20 = v5.changedInstance(v0_1) ? 0x800000 : 0x400000;
                v17 |= v20;
            }
        }

        if((v4 & 0x40000) != 0) {
            v17 |= v28;
        }
        else if((v3 & v28) == 0) {
            v20 = v5.changed(v1) ? 0x4000000 : 0x2000000;
            v17 |= v20;
        }

        v20 = 0;
        v23 = v8;
        boolean v0_4 = (v7 & 306783379) != 306783378 || (v17 & 0x2492493) != 0x2492492 ? true : false;
        if(v5.shouldExecute(v0_4, v7 & 1)) {
            v5.startDefaults();
            ComposerKt.sourceInformation(v5, "381@20365L5,382@20406L8,389@20656L428");
            v3 = 6;
            if((arg55 & 1) == 0 || (v5.getDefaultsInvalid())) {
                if(v22 != 0) {
                    v15 = false;
                }

                if(v9 != 0) {
                    v12 = null;
                }

                v0_1 = v19 != 0 ? null : arg44;
                v9_1 = v29 != 0 ? null : arg45;
                v19_1 = v30 != 0 ? null : arg46;
                v22_1 = v32 != 0 ? null : arg47;
                v16_1 = v16 != 0 ? null : arg48;
                Function2 v23_2 = v23 != 0 ? null : arg49;
                if((v4 & 0x4000) != 0) {
                    v8_1 = TextFieldDefaults.INSTANCE.getShape(v5, v3);
                    v17 &= 0xFFFF1FFF;
                }
                else {
                    v8_1 = arg50;
                }

                if((v4 & 0x8000) != 0) {
                    v3_2 = v1.colors(v5, v17 >> 24 & 14);
                    v17 &= 0xFFF8FFFF;
                }
                else {
                    v3_2 = arg51;
                }

                if((v4 & v21) != 0) {
                    v1_2 = v12 == null ? TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(v1, 0f, 0f, 0f, 0f, 15, null) : TextFieldDefaults.contentPaddingWithLabel-a9UjIt4$default(this, 0f, 0f, 0f, 0f, 15, null);
                    v17 &= 0xFFC7FFFF;
                }
                else {
                    v1_2 = arg52;
                }

                if(v18 != 0) {
                    TextFieldColors v46 = v3_2;
                    TextFieldDefaults$DecorationBox$1 v3_3 = new TextFieldDefaults$DecorationBox$1(v13_1, v15, v14_1, v46, v8_1);
                    v13_3 = v8_1;
                    v42 = v0_1;
                    PaddingValues v43 = v1_2;
                    v0_5 = ComposableLambdaKt.rememberComposableLambda(417908150, true, v3_3, v5, 54);
                    Function2 v1_3 = v23_2;
                    v23_1 = v46;
                    v8 = v17;
                    v17_1 = v1_3;
                    v3_1 = v43;
                    v24_2 = v0_5;
                }
                else {
                    v42 = v0_1;
                    v13_3 = v8_1;
                    v0_1 = v23_2;
                    v23_1 = v3_2;
                    v8 = v17;
                    v17_1 = v0_1;
                    v3_1 = v1_2;
                    v24_1 = arg53;
                }

                v0_1 = v12;
                v1_1 = v13_3;
                v14_2 = v19_1;
                v12 = v42;
                v13_2 = v9_1;
            }
            else {
                v5.skipToGroupEnd();
                if((v4 & 0x4000) != 0) {
                    v17 &= 0xFFFF1FFF;
                }

                if((0x8000 & v4) != 0) {
                    v17 &= 0xFFF8FFFF;
                }

                if((v4 & v21) != 0) {
                    v17 &= 0xFFC7FFFF;
                }

                v13_2 = arg45;
                v14_2 = arg46;
                v22_1 = arg47;
                v16_1 = arg48;
                v1_1 = arg50;
                v23_1 = arg51;
                v24_1 = arg53;
                v0_1 = v12;
                v8 = v17;
                v12 = arg44;
                v17_1 = arg49;
                v3_1 = arg52;
            }

            v5.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                v43_1 = v1_1;
                ComposerKt.traceEventStart(1806980801, v7, v8, "androidx.compose.material3.TextFieldDefaults.DecorationBox (TextFieldDefaults.kt:401)");
            }
            else {
                v43_1 = v1_1;
            }

            ComposerKt.sourceInformationMarkerStart(v5, 0x4FFA6322, "CC(remember):TextFieldDefaults.kt#9igjgp");
            int v1_4 = (v7 & 14) == 4 ? 1 : 0;
            int v44 = v1_4;
            if((0xE000 & v7) == 0x4000) {
                v20 = 1;
            }

            Object v9_2 = v5.rememberedValue();
            if((v44 | v20) != 0 || v9_2 == Composer.Companion.getEmpty()) {
                v42_1 = v3_1;
                v9_3 = v6.filter(new AnnotatedString(v2, null, 2, null));
                v5.updateRememberedValue(v9_3);
            }
            else {
                v42_1 = v3_1;
            }

            ComposerKt.sourceInformationMarkerEnd(v5);
            String v1_5 = v9_3.getText().getText();
            TextFieldType v9_4 = TextFieldType.Filled;
            Attached v18_1 = new Attached(false, null, null, 7, null);
            if(v0_1 == null) {
                v5.startReplaceGroup(0xAF58DB49);
                v5.endReplaceGroup();
                arg44 = v0_1;
                v45 = v1_5;
                v25_1 = null;
            }
            else {
                v5.startReplaceGroup(0xAF58DB4A);
                ComposerKt.sourceInformation(v5, "*415@21593L15");
                arg44 = v0_1;
                v45 = v1_5;
                v0_5 = ComposableLambdaKt.rememberComposableLambda(1110058497, true, new TextFieldDefaults$DecorationBox$2$1(v0_1), v5, 54);
                v5.endReplaceGroup();
                v25_1 = v0_5;
            }

            int v2_1 = v7 >> 9;
            v3 = v8 << 21;
            int v26 = v7 << 3 & 0x380 | 6 | 0x70000 & v2_1 | 0x380000 & v2_1 | v3 & 0x1C00000 | v3 & 0xE000000 | v3 & 0x70000000;
            v27 = v8 >> 9 & 14 | v7 >> 6 & 0x70 | v7 & 0x380 | v2_1 & 0x1C00 | 0xE000 & v7 >> 3 | v8 >> 3 & 0x70000 | v8 << 3 & 0x380000 | 0x1C00000 & v8;
            TextFieldType v7_1 = v9_4;
            v9_1 = v10;
            boolean v20_1 = v15;
            Attached v10_1 = v18_1;
            v15_1 = v22_1;
            PaddingValues v22_2 = v42_1;
            boolean v18_2 = v11;
            ComposableLambda v11_1 = v25_1;
            v25_2 = v5;
            TextFieldImplKt.CommonDecorationBox(v7_1, v45, v9_1, ((TextFieldLabelPosition)v10_1), ((Function3)v11_1), v12, v13_2, v14_2, v15_1, v16_1, v17_1, v18_2, arg38, v20_1, arg41, v22_2, v23_1, ((Function2)v24_2), v25_2, v26, v27);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_1 = arg44;
            v10 = v12;
            v11_2 = v13_2;
            v12 = v14_2;
            v13_2 = v15_1;
            v14_2 = v16_1;
            v15_1 = v17_1;
            v8_2 = v20_1;
            v18_3 = v22_2;
            v17_2 = v23_1;
            v19_1 = ((Function2)v24_2);
            v16_2 = v43_1;
        }
        else {
            v25_2 = v5;
            v25_2.skipToGroupEnd();
            v10 = arg44;
            v11_2 = arg45;
            v13_2 = arg47;
            v14_2 = arg48;
            v16_2 = arg50;
            v17_2 = arg51;
            v18_3 = arg52;
            v19_1 = arg53;
            v9_1 = v12;
            v8_2 = v15;
            v12 = arg46;
            v15_1 = arg49;
        }

        ScopeUpdateScope v0_6 = v25_2.endRestartGroup();
        if(v0_6 != null) {
            v0_6.updateScope(new TextFieldDefaults$$ExternalSyntheticLambda0(this, arg36, arg37, arg38, arg39, v6, arg41, v8_2, v9_1, v10, v11_2, v12, v13_2, v14_2, v15_1, v16_2, v17_2, v18_3, v19_1, arg55, arg56, v4));
        }
    }

    static final Unit DecorationBox$lambda$3(TextFieldDefaults arg24, String arg25, Function2 arg26, boolean arg27, boolean arg28, VisualTransformation arg29, InteractionSource arg30, boolean arg31, Function2 arg32, Function2 arg33, Function2 arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, Shape arg39, TextFieldColors arg40, PaddingValues arg41, Function2 arg42, int arg43, int arg44, int arg45, Composer arg46, int arg47) {
        arg24.DecorationBox(arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg46, RecomposeScopeImplKt.updateChangedFlags(arg43 | 1), RecomposeScopeImplKt.updateChangedFlags(arg44), arg45);
        return Unit.INSTANCE;
    }

    public final TextFieldColors colors(Composer arg4, int arg5) {
        int v1 = 0x3193361C;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(colors)478@24135L11,478@24195L7:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:478)");
        }

        ColorScheme v5 = MaterialTheme.INSTANCE.getColorScheme(arg4, 6);
        ProvidableCompositionLocal v0 = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v0_1 = arg4.consume(((CompositionLocal)v0));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        TextFieldColors v3 = this.defaultTextFieldColors$material3(v5, ((TextSelectionColors)v0_1));
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
        ComposerKt.sourceInformationMarkerStart(v0, 0x5A33CFBB, "C(colors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,errorTextColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,errorContainerColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,errorCursorColor:c#ui.graphics.Color,selectionColors,focusedIndicatorColor:c#ui.graphics.Color,unfocusedIndicatorColor:c#ui.graphics.Color,disabledIndicatorColor:c#ui.graphics.Color,errorIndicatorColor:c#ui.graphics.Color,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,errorLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,errorTrailingIconColor:c#ui.graphics.Color,focusedLabelColor:c#ui.graphics.Color,unfocusedLabelColor:c#ui.graphics.Color,disabledLabelColor:c#ui.graphics.Color,errorLabelColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,errorPlaceholderColor:c#ui.graphics.Color,focusedSupportingTextColor:c#ui.graphics.Color,unfocusedSupportingTextColor:c#ui.graphics.Color,disabledSupportingTextColor:c#ui.graphics.Color,errorSupportingTextColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,errorPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,errorSuffixColor:c#ui.graphics.Color)580@31011L11,581@31084L7:TextFieldDefaults.kt#uh7d8r");
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
            ComposerKt.traceEventStart(0x5A33CFBB, arg174, arg175, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:580)");
        }
        else {
            arg171 = v1_1;
            arg108 = v3;
        }

        ColorScheme v1_2 = MaterialTheme.INSTANCE.getColorScheme(v0, 6);
        ProvidableCompositionLocal v2_1 = TextSelectionColorsKt.getLocalTextSelectionColors();
        ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v2_2 = v0.consume(((CompositionLocal)v2_1));
        ComposerKt.sourceInformationMarkerEnd(v0);
        TextFieldColors v1_3 = this.defaultTextFieldColors$material3(v1_2, ((TextSelectionColors)v2_2)).copy-ejIjP34(v5, v7, v9, v11, v13, v15, v17, v19, v21, v23, arg108, v25, v27, v29, v31, v33, v35, v37, v39, v41, v43, v45, v47, v49, v51, v53, v55, v57, v59, v61, v63, v65, v67, v69, v71, v73, v75, v77, v79, v81, v83, v85, arg171);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_3;
    }

    public final PaddingValues contentPaddingWithLabel-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return PaddingKt.PaddingValues-a9UjIt4(arg1, arg3, arg2, arg4);
    }

    public static PaddingValues contentPaddingWithLabel-a9UjIt4$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 2) != 0) {
            arg2 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 4) != 0) {
            arg3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }

        if((arg5 & 8) != 0) {
            arg4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }

        return arg0.contentPaddingWithLabel-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public final PaddingValues contentPaddingWithoutLabel-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return PaddingKt.PaddingValues-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues contentPaddingWithoutLabel-a9UjIt4$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
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

        return arg0.contentPaddingWithoutLabel-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public final TextFieldDecorator decorator(TextFieldState arg24, boolean arg25, TextFieldLineLimits arg26, OutputTransformation arg27, InteractionSource arg28, TextFieldLabelPosition arg29, Function3 arg30, Function2 arg31, Function2 arg32, Function2 arg33, Function2 arg34, Function2 arg35, Function2 arg36, boolean arg37, TextFieldColors arg38, PaddingValues arg39, Function2 arg40, Composer arg41, int arg42, int arg43, int arg44) {
        ComposableLambda v22;
        boolean v18;
        InteractionSource v7;
        boolean v6_2;
        PaddingValues v20;
        TextFieldColors v5_1;
        TextFieldDefaults v6;
        Attached v9;
        Composer v0 = arg41;
        int v1 = arg43;
        int v2 = arg44;
        ComposerKt.sourceInformationMarkerStart(v0, 0x132042DD, "C(decorator)N(state,enabled,lineLimits,outputTransformation,interactionSource,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,colors,contentPadding,container)160@8861L8,167@9160L391:TextFieldDefaults.kt#uh7d8r");
        if((v2 & 0x20) != 0) {
            v9 = new Attached(false, null, null, 7, null);
        }
        else {
            TextFieldLabelPosition v9_1 = arg29;
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

        if((0x8000 & v2) != 0) {
            PaddingValues v6_1 = v10 == null || ((v9 instanceof Above)) ? TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(this, 0f, 0f, 0f, 0f, 15, null) : TextFieldDefaults.contentPaddingWithLabel-a9UjIt4$default(v6, 0f, 0f, 0f, 0f, 15, null);
            v20 = v6_1;
        }
        else {
            v20 = arg39;
        }

        if((v2 & 0x10000) != 0) {
            v6_2 = arg25;
            v7 = arg28;
            v18 = v3;
            v22 = ComposableLambdaKt.rememberComposableLambda(0xEA322C8, true, new TextFieldDefaults$decorator$1(v6_2, v3, v7, v5_1), v0, 54);
        }
        else {
            v6_2 = arg25;
            v7 = arg28;
            v18 = v3;
            Function2 v22_1 = arg40;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x132042DD, arg42, v1, "androidx.compose.material3.TextFieldDefaults.decorator (TextFieldDefaults.kt:178)");
        }

        TextFieldDefaults$decorator$2 v5_2 = new TextFieldDefaults$decorator$2(arg27, arg24, arg26, ((TextFieldLabelPosition)v9), v10, v11, v12, v13, v14, v15, v16, v6_2, v18, v7, v20, v5_1, ((Function2)v22));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((TextFieldDecorator)v5_2);
    }

    public final TextFieldColors defaultTextFieldColors$material3(ColorScheme arg94, TextSelectionColors arg95) {
        ColorScheme v0 = arg94;
        TextFieldColors v1 = v0.getDefaultTextFieldColorsCached$material3();
        if(v1 != null) {
            if(Intrinsics.areEqual(v1.getTextSelectionColors(), arg95)) {
            }
            else {
                v1 = TextFieldColors.copy-ejIjP34$default(v1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, arg95, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0xFFFFFBFF, 0x7FF, null);
                v0.setDefaultTextFieldColorsCached$material3(v1);
            }

            if(v1 == null) {
                goto label_59;
            }

            return v1;
        }

    label_59:
        TextFieldColors v3 = new TextFieldColors(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusInputColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorInputColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getCaretColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorFocusCaretColor()), arg95, ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusActiveIndicatorColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getActiveIndicatorColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorColor()), FilledTextFieldTokens.INSTANCE.getDisabledActiveIndicatorOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorActiveIndicatorColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getLabelColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledLabelColor()), FilledTextFieldTokens.INSTANCE.getDisabledLabelOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledInputColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getSupportingColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getDisabledSupportingColor()), FilledTextFieldTokens.INSTANCE.getDisabledSupportingOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
        v0.setDefaultTextFieldColorsCached$material3(v3);
        return v3;
    }

    public final Shape getFilledShape(Composer arg4, int arg5) {
        int v1 = 0x247941E1;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(<get-filledShape>)790@42434L5:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.TextFieldDefaults.<get-filledShape> (TextFieldDefaults.kt:790)");
        }

        Shape v3 = this.getShape(arg4, arg5 & 14);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to `TextFieldDefaults.shape`", replaceWith="<_subannotation>") public static void getFilledShape$annotations() {
    }

    public final float getFocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.FocusedBorderThickness;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Split into `TextFieldDefaults.FocusedIndicatorThickness` and `OutlinedTextFieldDefaults.FocusedBorderThickness`. Please update as appropriate.", replaceWith="<_subannotation>") public static void getFocusedBorderThickness-D9Ej5fM$annotations() {
    }

    public final float getFocusedIndicatorThickness-D9Ej5fM() {
        return TextFieldDefaults.FocusedIndicatorThickness;
    }

    public final float getMinHeight-D9Ej5fM() {
        return TextFieldDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return TextFieldDefaults.MinWidth;
    }

    public final Shape getOutlinedShape(Composer arg3, int arg4) {
        int v0 = 0xDD256F21;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-outlinedShape>)782@42187L5:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TextFieldDefaults.<get-outlinedShape> (TextFieldDefaults.kt:782)");
        }

        Shape v2 = OutlinedTextFieldDefaults.INSTANCE.getShape(arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to `OutlinedTextFieldDefaults.shape`", replaceWith="<_subannotation>") public static void getOutlinedShape$annotations() {
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x8C49B19D;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)68@3251L5:TextFieldDefaults.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:68)");
        }

        Shape v2 = ShapesKt.getValue(FilledTextFieldTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getUnfocusedBorderThickness-D9Ej5fM() {
        return TextFieldDefaults.UnfocusedBorderThickness;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Split into `TextFieldDefaults.UnfocusedIndicatorThickness` and `OutlinedTextFieldDefaults.UnfocusedBorderThickness`. Please update as appropriate.", replaceWith="<_subannotation>") public static void getUnfocusedBorderThickness-D9Ej5fM$annotations() {
    }

    public final float getUnfocusedIndicatorThickness-D9Ej5fM() {
        return TextFieldDefaults.UnfocusedIndicatorThickness;
    }

    public final Modifier indicatorLine-AWlRVLg(Modifier arg10, boolean arg11, boolean arg12, InteractionSource arg13, TextFieldColors arg14, Shape arg15, float arg16, float arg17) {
        return arg10.then(new IndicatorLineElement(arg11, arg12, arg13, arg14, arg15, arg16, arg17, null));
    }

    public static Modifier indicatorLine-AWlRVLg$default(TextFieldDefaults arg1, Modifier arg2, boolean arg3, boolean arg4, InteractionSource arg5, TextFieldColors arg6, Shape arg7, float arg8, float arg9, int arg10, Object arg11) {
        TextFieldColors v0 = null;
        if((arg10 & 8) != 0) {
            arg6 = v0;
        }

        if((arg10 & 16) != 0) {
            arg7 = ((Shape)v0);
        }

        if((arg10 & 0x20) != 0) {
            arg8 = TextFieldDefaults.FocusedIndicatorThickness;
        }

        if((arg10 & 0x40) != 0) {
            arg9 = TextFieldDefaults.UnfocusedIndicatorThickness;
        }

        return arg1.indicatorLine-AWlRVLg(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use overload with `textFieldShape`.") public final Modifier indicatorLine-gv0btCI(Modifier arg10, boolean arg11, boolean arg12, InteractionSource arg13, TextFieldColors arg14, float arg15, float arg16) {
        return this.indicatorLine-AWlRVLg(arg10, arg11, arg12, arg13, arg14, null, arg15, arg16);
    }

    public static Modifier indicatorLine-gv0btCI$default(TextFieldDefaults arg8, Modifier arg9, boolean arg10, boolean arg11, InteractionSource arg12, TextFieldColors arg13, float arg14, float arg15, int arg16, Object arg17) {
        if((arg16 & 16) != 0) {
            arg14 = TextFieldDefaults.FocusedIndicatorThickness;
        }

        float v6 = arg14;
        float v7 = (arg16 & 0x20) != 0 ? TextFieldDefaults.UnfocusedIndicatorThickness : arg15;
        return arg8.indicatorLine-gv0btCI(arg9, arg10, arg11, arg12, arg13, v6, v7);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to `OutlinedTextFieldDefaults.contentPadding`", replaceWith="<_subannotation>") public final PaddingValues outlinedTextFieldPadding-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return OutlinedTextFieldDefaults.INSTANCE.contentPadding-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues outlinedTextFieldPadding-a9UjIt4$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
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

        return arg0.outlinedTextFieldPadding-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public final PaddingValues supportingTextPadding-a9UjIt4$material3(float arg1, float arg2, float arg3, float arg4) {
        return PaddingKt.PaddingValues-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues supportingTextPadding-a9UjIt4$material3$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 2) != 0) {
            arg2 = TextFieldImplKt.getSupportingTopPadding();
        }

        if((arg5 & 4) != 0) {
            arg3 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 8) != 0) {
            arg4 = Dp.constructor-impl(0f);
        }

        return arg0.supportingTextPadding-a9UjIt4$material3(arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to `TextFieldDefaults.contentPaddingWithLabel`", replaceWith="<_subannotation>") public final PaddingValues textFieldWithLabelPadding-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return this.contentPaddingWithLabel-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues textFieldWithLabelPadding-a9UjIt4$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 2) != 0) {
            arg2 = TextFieldImplKt.getTextFieldPadding();
        }

        if((arg5 & 4) != 0) {
            arg3 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }

        if((arg5 & 8) != 0) {
            arg4 = TextFieldKt.getTextFieldWithLabelVerticalPadding();
        }

        return arg0.textFieldWithLabelPadding-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to `TextFieldDefaults.contentPaddingWithoutLabel`", replaceWith="<_subannotation>") public final PaddingValues textFieldWithoutLabelPadding-a9UjIt4(float arg1, float arg2, float arg3, float arg4) {
        return this.contentPaddingWithoutLabel-a9UjIt4(arg1, arg2, arg3, arg4);
    }

    public static PaddingValues textFieldWithoutLabelPadding-a9UjIt4$default(TextFieldDefaults arg0, float arg1, float arg2, float arg3, float arg4, int arg5, Object arg6) {
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

        return arg0.textFieldWithoutLabelPadding-a9UjIt4(arg1, arg2, arg3, arg4);
    }
}

