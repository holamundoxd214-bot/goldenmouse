package androidx.compose.material3;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A£\u0003\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2 \b\u0002\u0010\r\u001A\u001A\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000E¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u0012\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001A\u00020\u00072\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001A\u00020#28\b\u0002\u0010$\u001A2\u0012\u0004\u0012\u00020&\u0012\u001B\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\'0\u0013¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u0001\u0018\u00010%¢\u0006\u0002\b\u00112\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020.2\b\b\u0002\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u0002022\n\b\u0002\u00103\u001A\u0004\u0018\u000104H\u0007¢\u0006\u0002\u00105\u001AØ\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u00106\u001A\u0002072\u0012\u00108\u001A\u000E\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00010\u000E2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0015\b\u0002\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001A\u00020\u00072\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010;\u001A\u00020<2\b\b\u0002\u0010=\u001A\u00020\u00072\b\b\u0002\u0010>\u001A\u00020?2\b\b\u0002\u0010@\u001A\u00020?2\n\b\u0002\u00103\u001A\u0004\u0018\u0001042\b\b\u0002\u0010-\u001A\u00020.2\b\b\u0002\u0010/\u001A\u000200H\u0007¢\u0006\u0002\u0010A\u001AØ\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u00106\u001A\u00020B2\u0012\u00108\u001A\u000E\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00010\u000E2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\n2\u0015\b\u0002\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0012\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0015\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0015\b\u0002\u0010\u0018\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0019\u001A\u00020\u00072\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010;\u001A\u00020<2\b\b\u0002\u0010=\u001A\u00020\u00072\b\b\u0002\u0010>\u001A\u00020?2\b\b\u0002\u0010@\u001A\u00020?2\n\b\u0002\u00103\u001A\u0004\u0018\u0001042\b\b\u0002\u0010-\u001A\u00020.2\b\b\u0002\u0010/\u001A\u000200H\u0007¢\u0006\u0002\u0010C\u001A\u0088\u0002\u0010D\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0011\u0010E\u001A\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0019\u0010\u0012\u001A\u0015\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000E¢\u0006\u0002\b\u00102\u0013\u0010\r\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010F\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010G\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0016\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010\u0017\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010=\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010H\u001A\u00020I2\u0012\u0010J\u001A\u000E\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00010\u000E2\u0011\u0010L\u001A\r\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00102\u0013\u0010M\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013¢\u0006\u0002\b\u00102\u0006\u0010N\u001A\u000202H\u0001¢\u0006\u0002\u0010O\u001A*\u0010P\u001A\u00020\u0005*\u00020\u00052\f\u0010Q\u001A\b\u0012\u0004\u0012\u00020K0\u00132\u0006\u0010R\u001A\u00020S2\u0006\u0010N\u001A\u000202H\u0000\"\u0010\u0010T\u001A\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010V¨\u0006W"}, d2={"OutlinedTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "placeholder", "Lkotlin/Function0;", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;IIII)V", "value", "", "onValueChange", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "labelProgress", "Landroidx/compose/material3/internal/FloatProducer;", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/TextFieldLabelPosition;Landroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "outlineCutout", "labelSize", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding;

    static {
        OutlinedTextFieldKt.OutlinedTextFieldInnerPadding = Dp.constructor-impl(4f);
    }

    public static final void OutlinedTextField(TextFieldValue arg66, Function1 arg67, Modifier arg68, boolean arg69, boolean arg70, TextStyle arg71, Function2 arg72, Function2 arg73, Function2 arg74, Function2 arg75, Function2 arg76, Function2 arg77, Function2 arg78, boolean arg79, VisualTransformation arg80, KeyboardOptions arg81, KeyboardActions arg82, boolean arg83, int arg84, int arg85, MutableInteractionSource arg86, Shape arg87, TextFieldColors arg88, Composer arg89, int arg90, int arg91, int arg92, int arg93) {
        TextFieldColors v23_2;
        MutableInteractionSource v21_2;
        Shape v22_2;
        Function2 v13_1;
        Function2 v9_3;
        VisualTransformation v15_3;
        boolean v18_2;
        KeyboardActions v17_2;
        KeyboardOptions v16_3;
        boolean v5_2;
        boolean v4_1;
        boolean v14_1;
        Function2 v7_1;
        Modifier v3_1;
        Composer v0_9;
        TextStyle v6_1;
        Object v24_1;
        boolean v15_1;
        TextFieldColors v12_1;
        KeyboardOptions v18_1;
        Modifier v9_1;
        Function2 v25_1;
        TextStyle v0_6;
        boolean v16_1;
        Shape v31_1;
        MutableInteractionSource v1_1;
        boolean v20_1;
        KeyboardActions v19_1;
        VisualTransformation v23_1;
        boolean v11_1;
        Function2 v30;
        Function2 v29_1;
        Function2 v28_1;
        Function2 v27_1;
        Function2 v26;
        Function2 v11_2;
        Function2 v8_1;
        Object v9_2;
        int v23;
        Shape v0_5;
        MutableInteractionSource v0_4;
        int v21;
        boolean v0_3;
        int v38;
        int v37;
        int v36;
        int v35;
        int v34;
        int v33;
        int v32;
        int v31;
        Function2 v12;
        int v27;
        Function2 v10;
        int v24;
        TextStyle v9;
        int v22;
        boolean v7;
        int v19;
        boolean v6;
        int v16;
        Modifier v15;
        int v8;
        Function1 v14;
        TextFieldValue v13;
        int v5;
        int v0 = arg90;
        int v1 = arg91;
        int v2 = arg92;
        int v3 = arg93;
        Composer v4 = arg89.startRestartGroup(0x7A9FBAF5);
        ComposerKt.sourceInformation(v4, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)571@32380L2835,571@32293L2922:OutlinedTextField.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
            v13 = arg66;
        }
        else {
            v13 = arg66;
            if((v0 & 6) == 0) {
                v5 = v4.changed(v13) ? 4 : 2;
                v5 |= v0;
            }
            else {
                v5 = v0;
            }
        }

        if((v3 & 2) != 0) {
            v5 |= 0x30;
            v14 = arg67;
        }
        else {
            v14 = arg67;
            if((v0 & 0x30) == 0) {
                v8 = v4.changedInstance(v14) ? 0x20 : 16;
                v5 |= v8;
            }
        }

        v8 = v3 & 4;
        if(v8 != 0) {
            v5 |= 0x180;
            goto label_53;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg68;
            v16 = v4.changed(v15) ? 0x100 : 0x80;
            v5 |= v16;
        }
        else {
        label_53:
            v15 = arg68;
        }

        v16 = v3 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v5 |= 0xC00;
            goto label_70;
        }
        else if((v0 & 0xC00) == 0) {
            v6 = arg69;
            v19 = v4.changed(v6) ? v17 : v18;
            v5 |= v19;
        }
        else {
        label_70:
            v6 = arg69;
        }

        v19 = v3 & 16;
        int v20 = 0x2000;
        if(v19 != 0) {
            v5 |= 0x6000;
            goto label_86;
        }
        else if((v0 & 0x6000) == 0) {
            v7 = arg70;
            v22 = v4.changed(v7) ? 0x4000 : v20;
            v5 |= v22;
        }
        else {
        label_86:
            v7 = arg70;
        }

        v22 = 0x30000;
        if((v0 & v22) == 0) {
            v9 = arg71;
            v24 = (v3 & 0x20) != 0 || !v4.changed(v9) ? 0x10000 : 0x20000;
            v5 |= v24;
        }
        else {
            v9 = arg71;
        }

        v24 = v3 & 0x40;
        int v25 = 0x180000;
        if(v24 != 0) {
            v5 |= v25;
            v10 = arg72;
        }
        else {
            v10 = arg72;
            if((v0 & v25) == 0) {
                v27 = v4.changedInstance(v10) ? 0x100000 : 0x80000;
                v5 |= v27;
            }
        }

        int v11 = v3 & 0x80;
        int v28 = 0x400000;
        int v29 = 0xC00000;
        if(v11 != 0) {
            v5 |= v29;
            v12 = arg73;
        }
        else {
            v12 = arg73;
            if((v0 & v29) == 0) {
                v31 = v4.changedInstance(v12) ? 0x800000 : v28;
                v5 |= v31;
            }
        }

        v0 = v3 & 0x100;
        v31 = 0x6000000;
        if(v0 != 0) {
            v5 |= v31;
            goto label_148;
        }
        else if((arg90 & v31) == 0) {
            v31 = v0;
            v32 = v4.changedInstance(arg74) ? 0x4000000 : 0x2000000;
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
        else if((arg90 & v32) == 0) {
            v33 = v0;
            v34 = v4.changedInstance(arg75) ? 0x20000000 : 0x10000000;
            v5 |= v34;
        }
        else {
        label_166:
            v33 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v35 = v1 | 6;
            v34 = v0;
        }
        else if((v1 & 6) == 0) {
            v34 = v0;
            v35 = v4.changedInstance(arg76) ? 4 : 2;
            v35 |= v1;
        }
        else {
            v34 = v0;
            v35 = v1;
        }

        v0 = v3 & 0x800;
        if(v0 != 0) {
            v35 |= 0x30;
            v36 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v36 = v0;
            v37 = v4.changedInstance(arg77) ? 0x20 : 16;
            v35 |= v37;
        }
        else {
            v36 = v0;
        }

        v0 = v35;
        v35 = v5;
        v5 = v3 & 0x1000;
        if(v5 != 0) {
            v0 |= 0x180;
        }
        else {
            v37 = v0;
            if((v1 & 0x180) == 0) {
                v38 = v4.changedInstance(arg78) ? 0x100 : 0x80;
                v37 |= v38;
            }

            v0 = v37;
        }

        v37 = v5;
        v5 = v3 & 0x2000;
        if(v5 != 0) {
            v0 |= 0xC00;
        }
        else {
            v38 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg79)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v38 | v17;
            }
            else {
                v0 = v38;
            }
        }

        v17 = v5;
        v5 = v3 & 0x4000;
        if(v5 != 0) {
            v18 = v0 | 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v4.changed(arg80)) {
                    v20 = 0x4000;
                }

                v18 |= v20;
            }
        }

        v20 = v3 & 0x8000;
        if(v20 != 0) {
            v18 |= v22;
        }
        else {
            KeyboardOptions v0_1 = arg81;
            if((v1 & v22) == 0) {
                v22 = v4.changed(v0_1) ? 0x20000 : 0x10000;
                v18 |= v22;
            }
        }

        v22 = v3 & 0x10000;
        if(v22 != 0) {
            v18 |= v25;
        }
        else {
            KeyboardActions v0_2 = arg82;
            if((v1 & v25) == 0) {
                v25 = v4.changed(v0_2) ? 0x100000 : 0x80000;
                v18 |= v25;
            }
        }

        v25 = v3 & 0x20000;
        if(v25 != 0) {
            v18 |= v29;
        }
        else {
            v0_3 = arg83;
            if((v1 & v29) == 0) {
                v29 = v4.changed(v0_3) ? 0x800000 : v28;
                v18 |= v29;
            }
        }

        if((v1 & 0x6000000) == 0) {
            v0 = arg84;
            v29 = (v3 & 0x40000) != 0 || !v4.changed(v0) ? 0x2000000 : 0x4000000;
            v18 |= v29;
        }

        v29 = v3 & 0x80000;
        if(v29 != 0) {
            v18 |= v32;
        }
        else {
            v0 = arg85;
            if((v1 & v32) == 0) {
                v32 = v4.changed(v0) ? 0x20000000 : 0x10000000;
                v18 |= v32;
            }
        }

        v32 = v3 & 0x100000;
        if(v32 != 0) {
            v21 = v2 | 6;
        }
        else {
            v0_4 = arg86;
            if((v2 & 6) == 0) {
                v21 = v4.changed(v0_4) ? 4 : 2;
                v21 |= v2;
            }
            else {
                v21 = v2;
            }
        }

        if((v2 & 0x30) == 0) {
            v0_5 = arg87;
            v23 = (v3 & 0x200000) != 0 || !v4.changed(v0_5) ? 16 : 0x20;
            v21 |= v23;
        }

        if((v2 & 0x180) == 0) {
            v27 = (v3 & v28) != 0 || !v4.changed(arg88) ? 0x80 : 0x100;
            v21 |= v27;
        }

        v0 = v21;
        v0_3 = (v35 & 306783379) != 306783378 || (v18 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v0_3, v35 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "542@30932L7,558@31736L5,559@31799L8");
            if((arg90 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v15_2 = Modifier.Companion;
                }

                if(v16 != 0) {
                    v6 = true;
                }

                if(v19 != 0) {
                    v7 = false;
                }

                if((arg93 & 0x20) != 0) {
                    ProvidableCompositionLocal v0_7 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_8 = v4.consume(((CompositionLocal)v0_7));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v1 = v35 & 0xFFF8FFFF;
                    v9_2 = v0_8;
                }
                else {
                    v1 = v35;
                }

                v0_4 = null;
                if(v24 != 0) {
                    v10 = ((Function2)v0_4);
                }

                if(v11 != 0) {
                    v12 = ((Function2)v0_4);
                }

                Function2 v2_1 = v31 != 0 ? ((Function2)v0_4) : arg74;
                v8_1 = v33 != 0 ? ((Function2)v0_4) : arg75;
                v11_2 = v34 != 0 ? ((Function2)v0_4) : arg76;
                Function2 v16_2 = v36 != 0 ? ((Function2)v0_4) : arg77;
                Function2 v19_2 = v37 != 0 ? ((Function2)v0_4) : arg78;
                boolean v17_1 = v17 != 0 ? false : arg79;
                VisualTransformation v5_1 = v5 != 0 ? VisualTransformation.Companion.getNone() : arg80;
                KeyboardOptions v20_2 = v20 != 0 ? KeyboardOptions.Companion.getDefault() : arg81;
                KeyboardActions v21_1 = v22 != 0 ? KeyboardActions.Companion.getDefault() : arg82;
                boolean v22_1 = v25 != 0 ? false : arg83;
                if((arg93 & 0x40000) != 0) {
                    v23 = v22_1 ? 1 : 0x7FFFFFFF;
                    v18 &= 0xF1FFFFFF;
                }
                else {
                    v23 = arg84;
                }

                v24 = v29 != 0 ? 1 : arg85;
                if(v32 != 0) {
                }
                else {
                    v0_4 = arg86;
                }

                v3 = 6;
                MutableInteractionSource v68 = v0_4;
                v0_5 = (arg93 & 0x200000) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(v4, v3) : arg87;
                Shape v69 = v0_5;
                if((arg93 & v28) != 0) {
                    v31_1 = v69;
                    v26 = v2_1;
                    v27_1 = v8_1;
                    v28_1 = v11_2;
                    v25_1 = v12;
                    v29_1 = v16_2;
                    v11_1 = v17_1;
                    v2 = v18;
                    v30 = v19_2;
                    v18_1 = v20_2;
                    v19_1 = v21_1;
                    v20_1 = v22_1;
                    v21 = v23;
                    v22 = v24;
                    v12_1 = OutlinedTextFieldDefaults.INSTANCE.colors(v4, v3);
                    v23_1 = v5_1;
                    v16_1 = v7;
                    v0_6 = ((TextStyle)v9_2);
                    v9_1 = v15;
                    v5 = v1;
                    v15_1 = v6;
                }
                else {
                    v31_1 = v69;
                    v26 = v2_1;
                    v27_1 = v8_1;
                    v0_6 = ((TextStyle)v9_2);
                    v28_1 = v11_2;
                    v25_1 = v12;
                    v9_1 = v15;
                    v29_1 = v16_2;
                    v11_1 = v17_1;
                    v2 = v18;
                    v30 = v19_2;
                    v18_1 = v20_2;
                    v19_1 = v21_1;
                    v20_1 = v22_1;
                    v21 = v23;
                    v22 = v24;
                    v12_1 = arg88;
                    v23_1 = v5_1;
                    v15_1 = v6;
                    v16_1 = v7;
                    v5 = v1;
                }

                v1_1 = v68;
            }
            else {
                v4.skipToGroupEnd();
                v5 = (arg93 & 0x20) != 0 ? v35 & 0xFFF8FFFF : v35;
                if((arg93 & 0x40000) != 0) {
                    v18 &= 0xF1FFFFFF;
                }

                v26 = arg74;
                v27_1 = arg75;
                v28_1 = arg76;
                v29_1 = arg77;
                v30 = arg78;
                v11_1 = arg79;
                v23_1 = arg80;
                v19_1 = arg82;
                v20_1 = arg83;
                v21 = arg84;
                v22 = arg85;
                v1_1 = arg86;
                v31_1 = arg87;
                v16_1 = v7;
                v0_6 = v9;
                v25_1 = v12;
                v9_1 = v15;
                v2 = v18;
                v18_1 = arg81;
                v12_1 = arg88;
                v15_1 = v6;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7A9FBAF5, v5, v2, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:560)");
            }

            if(v1_1 == null) {
                v4.startReplaceGroup(-502250010);
                ComposerKt.sourceInformation(v4, "562@31894L39");
                ComposerKt.sourceInformationMarkerStart(v4, 1369271708, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object v2_2 = v4.rememberedValue();
                if(v2_2 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v2_3 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                v24_1 = v2_2;
            }
            else {
                v4.startReplaceGroup(1369271057);
                v4.endReplaceGroup();
                MutableInteractionSource v24_2 = v1_1;
            }

            v4.startReplaceGroup(0x519D82EF);
            ComposerKt.sourceInformation(v4, "*566@32118L25");
            long v2_4 = v0_6.getColor-0d7_KjU();
            if(v2_4 != 16) {
            }
            else {
                v2_4 = v12_1.textColor-XeAY9LY$material3(v15_1, v11_1, FocusInteractionKt.collectIsFocusedAsState(v24_1, v4, 0).getValue().booleanValue());
            }

            v4.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(v12_1.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(0x832BDFB5, true, new OutlinedTextFieldKt$OutlinedTextField$5(v9_1, v10, v11_1, v12_1, v13, v14, v15_1, v16_1, v0_6.merge(new TextStyle(v2_4, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null)), v18_1, v19_1, v20_1, v21, v22, v23_1, ((MutableInteractionSource)v24_1), v25_1, v26, v27_1, v28_1, v29_1, v30, v31_1), v4, 54), v4, ProvidedValue.$stable | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v0_6;
            v0_9 = v4;
            v3_1 = v9_1;
            v7_1 = v10;
            v14_1 = v11_1;
            v4_1 = v15_1;
            v5_2 = v16_1;
            v16_3 = v18_1;
            v17_2 = v19_1;
            v18_2 = v20_1;
            v19 = v21;
            v20 = v22;
            v15_3 = v23_1;
            v8_1 = v25_1;
            v9_3 = v26;
            v10 = v27_1;
            v11_2 = v28_1;
            v13_1 = v30;
            v22_2 = v31_1;
            v21_2 = v1_1;
            v23_2 = v12_1;
            v12 = v29_1;
        }
        else {
            v4.skipToGroupEnd();
            v11_2 = arg76;
            v13_1 = arg78;
            v14_1 = arg79;
            v16_3 = arg81;
            v17_2 = arg82;
            v18_2 = arg83;
            v19 = arg84;
            v20 = arg85;
            v21_2 = arg86;
            v22_2 = arg87;
            v23_2 = arg88;
            v0_9 = v4;
            v4_1 = v6;
            v5_2 = v7;
            v6_1 = v9;
            v7_1 = v10;
            v8_1 = v12;
            v3_1 = v15;
            v9_3 = arg74;
            v10 = arg75;
            v12 = arg77;
            v15_3 = arg80;
        }

        ScopeUpdateScope v0_10 = v0_9.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new OutlinedTextFieldKt$$ExternalSyntheticLambda0(arg66, arg67, v3_1, v4_1, v5_2, v6_1, v7_1, v8_1, v9_3, v10, v11_2, v12, v13_1, v14_1, v15_3, v16_3, v17_2, v18_2, v19, v20, v21_2, v22_2, v23_2, arg90, arg91, arg92, arg93));
        }
    }

    public static final void OutlinedTextField(TextFieldState arg69, Modifier arg70, boolean arg71, boolean arg72, TextStyle arg73, TextFieldLabelPosition arg74, Function3 arg75, Function2 arg76, Function2 arg77, Function2 arg78, Function2 arg79, Function2 arg80, Function2 arg81, boolean arg82, InputTransformation arg83, OutputTransformation arg84, KeyboardOptions arg85, KeyboardActionHandler arg86, TextFieldLineLimits arg87, Function2 arg88, ScrollState arg89, Shape arg90, TextFieldColors arg91, PaddingValues arg92, MutableInteractionSource arg93, Composer arg94, int arg95, int arg96, int arg97, int arg98) {
        MutableInteractionSource v25_2;
        KeyboardOptions v17_3;
        PaddingValues v24_3;
        Function2 v13_2;
        OutputTransformation v16_3;
        TextFieldLineLimits v19_3;
        TextFieldColors v23_2;
        Shape v22_3;
        ScrollState v21_3;
        KeyboardActionHandler v18_4;
        InputTransformation v15_3;
        boolean v4_1;
        Function2 v11_3;
        Function2 v10_3;
        Function2 v9_3;
        boolean v3_2;
        boolean v14_1;
        TextFieldLabelPosition v6_1;
        Function3 v7_1;
        Modifier v2_5;
        Composer v0_13;
        TextStyle v5_2;
        MutableInteractionSource v18_3;
        MutableInteractionSource v2_3;
        TextFieldColors v13_1;
        Function3 v10_1;
        TextFieldLabelPosition v11_1;
        Modifier v9_1;
        TextStyle v0_9;
        boolean v26_1;
        boolean v15_1;
        MutableInteractionSource v1_1;
        PaddingValues v25_1;
        Shape v33_1;
        ScrollState v32_1;
        Function2 v31_1;
        TextFieldLineLimits v16_1;
        KeyboardActionHandler v30_1;
        KeyboardOptions v29_1;
        OutputTransformation v17_1;
        InputTransformation v27_1;
        boolean v12_1;
        Function2 v24_1;
        Function2 v23_1;
        Function2 v22_1;
        Function2 v21_1;
        Function2 v20_1;
        Function2 v19_1;
        Function3 v17_2;
        TextFieldLineLimits v22_2;
        Function2 v12_2;
        Function2 v8_1;
        Attached v10_2;
        Shape v0_7;
        int v19;
        int v39;
        int v38;
        int v37;
        int v36;
        int v35;
        int v34;
        int v33;
        int v32;
        Function2 v0_1;
        int v31;
        Function3 v13;
        int v24;
        TextFieldLabelPosition v10;
        int v23;
        TextStyle v9;
        int v20;
        boolean v7;
        int v16;
        boolean v6;
        int v12;
        Modifier v11;
        TextFieldState v14;
        int v5;
        int v0 = arg95;
        int v1 = arg96;
        int v2 = arg97;
        int v3 = arg98;
        Composer v4 = arg94.startRestartGroup(-2007078942);
        ComposerKt.sourceInformation(v4, "C(OutlinedTextField)N(state,modifier,enabled,readOnly,textStyle,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,inputTransformation,outputTransformation,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,scrollState,shape,colors,contentPadding,interactionSource)239@14004L2781,239@13917L2868:OutlinedTextField.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
            v14 = arg69;
        }
        else {
            v14 = arg69;
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
            v11 = arg70;
            v12 = v4.changed(v11) ? 0x20 : 16;
            v5 |= v12;
        }
        else {
        label_39:
            v11 = arg70;
        }

        v12 = v3 & 4;
        if(v12 != 0) {
            v5 |= 0x180;
            goto label_54;
        }
        else if((v0 & 0x180) == 0) {
            v6 = arg71;
            v16 = v4.changed(v6) ? 0x100 : 0x80;
            v5 |= v16;
        }
        else {
        label_54:
            v6 = arg71;
        }

        v16 = v3 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v5 |= 0xC00;
            goto label_71;
        }
        else if((v0 & 0xC00) == 0) {
            v7 = arg72;
            v20 = v4.changed(v7) ? v17 : v18;
            v5 |= v20;
        }
        else {
        label_71:
            v7 = arg72;
        }

        int v21 = 0x4000;
        int v22 = 0x2000;
        if((v0 & 0x6000) == 0) {
            if((v3 & 16) == 0) {
                v9 = arg73;
                if(v4.changed(v9)) {
                    v23 = v21;
                }
                else {
                    goto label_84;
                }
            }
            else {
                v9 = arg73;
            label_84:
                v23 = v22;
            }

            v5 |= v23;
        }
        else {
            v9 = arg73;
        }

        if((v0 & 0x30000) == 0) {
            v10 = arg74;
            v24 = (v3 & 0x20) != 0 || !v4.changed(v10) ? 0x10000 : 0x20000;
            v5 |= v24;
        }
        else {
            v10 = arg74;
        }

        v24 = v3 & 0x40;
        int v25 = 0x100000;
        int v26 = 0x180000;
        if(v24 != 0) {
            v5 |= v26;
            v13 = arg75;
        }
        else {
            v13 = arg75;
            if((v0 & v26) == 0) {
                int v28 = v4.changedInstance(v13) ? v25 : 0x80000;
                v5 |= v28;
            }
        }

        int v15 = v3 & 0x80;
        int v29 = 0x400000;
        int v30 = 0xC00000;
        if(v15 != 0) {
            v5 |= v30;
        }
        else {
            v31 = v0 & v30;
            v0_1 = arg76;
            if(v31 == 0) {
                v31 = v4.changedInstance(v0_1) ? 0x800000 : v29;
                v5 |= v31;
            }
        }

        v0 = v3 & 0x100;
        v31 = 0x6000000;
        if(v0 != 0) {
            v5 |= v31;
            goto label_150;
        }
        else if((arg95 & v31) == 0) {
            v31 = v0;
            v32 = v4.changedInstance(arg77) ? 0x4000000 : 0x2000000;
            v5 |= v32;
        }
        else {
        label_150:
            v31 = v0;
        }

        v0 = v3 & 0x200;
        v32 = 0x30000000;
        if(v0 != 0) {
            v5 |= v32;
            goto label_168;
        }
        else if((arg95 & v32) == 0) {
            v32 = v0;
            v33 = v4.changedInstance(arg78) ? 0x20000000 : 0x10000000;
            v5 |= v33;
        }
        else {
        label_168:
            v32 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v34 = v1 | 6;
            v33 = v0;
        }
        else if((v1 & 6) == 0) {
            v33 = v0;
            v34 = v4.changedInstance(arg79) ? 4 : 2;
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
            v36 = v4.changedInstance(arg80) ? 0x20 : 16;
            v34 |= v36;
        }
        else {
            v35 = v0;
        }

        v0 = v34;
        v34 = v5;
        v5 = v3 & 0x1000;
        if(v5 != 0) {
            v0 |= 0x180;
        }
        else {
            v36 = v0;
            if((v1 & 0x180) == 0) {
                v37 = v4.changedInstance(arg81) ? 0x100 : 0x80;
                v36 |= v37;
            }

            v0 = v36;
        }

        v36 = v5;
        v5 = v3 & 0x2000;
        if(v5 != 0) {
            v0 |= 0xC00;
        }
        else {
            v37 = v0;
            if((v1 & 0xC00) == 0) {
                v38 = v4.changed(arg82) ? v17 : v18;
                v37 |= v38;
            }

            v0 = v37;
        }

        v37 = v5;
        v5 = v3 & 0x4000;
        if(v5 != 0) {
            v38 = v0 | 0x6000;
        }
        else {
            v38 = v0;
            if((v1 & 0x6000) == 0) {
                v39 = v4.changed(arg83) ? v21 : v22;
                v38 |= v39;
            }
        }

        v39 = v3 & 0x8000;
        int v40 = 0x30000;
        if(v39 != 0) {
            v38 |= v40;
        }
        else {
            OutputTransformation v0_2 = arg84;
            if((v1 & v40) == 0) {
                v40 = v4.changed(v0_2) ? 0x20000 : 0x10000;
                v38 |= v40;
            }
        }

        v40 = v3 & 0x10000;
        if(v40 != 0) {
            v38 |= v26;
        }
        else {
            KeyboardOptions v0_3 = arg85;
            if((v1 & v26) == 0) {
                v26 = v4.changed(v0_3) ? v25 : 0x80000;
                v38 |= v26;
            }
        }

        v26 = v3 & 0x20000;
        if(v26 != 0) {
            v38 |= v30;
        }
        else {
            KeyboardActionHandler v0_4 = arg86;
            if((v1 & v30) == 0) {
                v30 = v4.changed(v0_4) ? 0x800000 : v29;
                v38 |= v30;
            }
        }

        if((v1 & 0x6000000) == 0) {
            TextFieldLineLimits v0_5 = arg87;
            v30 = (v3 & 0x40000) != 0 || !v4.changed(v0_5) ? 0x2000000 : 0x4000000;
            v38 |= v30;
        }

        v30 = v3 & 0x80000;
        int v41 = 0x30000000;
        if(v30 != 0) {
            v38 |= v41;
        }
        else {
            v0_1 = arg88;
            if((v1 & v41) == 0) {
                v41 = v4.changedInstance(v0_1) ? 0x20000000 : 0x10000000;
                v38 |= v41;
            }
        }

        if((v2 & 6) == 0) {
            ScrollState v0_6 = arg89;
            v19 = (v3 & v25) != 0 || !v4.changed(v0_6) ? 2 : 4;
            v19 |= v2;
        }
        else {
            v19 = v2;
        }

        if((v2 & 0x30) == 0) {
            v0_7 = arg90;
            v20 = (v3 & 0x200000) != 0 || !v4.changed(v0_7) ? 16 : 0x20;
            v19 |= v20;
        }

        if((v2 & 0x180) == 0) {
            int v27 = (v3 & v29) != 0 || !v4.changed(arg91) ? 0x80 : 0x100;
            v19 |= v27;
        }

        if((v2 & 0xC00) == 0) {
            if((0x800000 & v3) != 0 || !v4.changed(arg92)) {
                v17 = v18;
            }
            else {
            }

            v19 |= v17;
        }

        v0 = v19;
        v17 = v3 & 0x1000000;
        if(v17 != 0) {
            v0 |= 0x6000;
        }
        else {
            v18 = v0;
            if((v2 & 0x6000) == 0) {
                if(v4.changed(arg93)) {
                }
                else {
                    v21 = v22;
                }

                v18 |= v21;
            }

            v0 = v18;
        }

        boolean v0_8 = (v34 & 306783379) != 306783378 || (v38 & 306783379) != 306783378 || (v0 & 9363) != 9362 ? true : false;
        if(v4.shouldExecute(v0_8, v34 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "207@12265L7,223@13155L21,224@13223L5,225@13286L8");
            if((arg95 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v11_2 = Modifier.Companion;
                }

                if(v12 != 0) {
                    v6 = true;
                }

                if(v16 != 0) {
                    v7 = false;
                }

                if((arg98 & 16) != 0) {
                    ProvidableCompositionLocal v0_10 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_11 = v4.consume(((CompositionLocal)v0_10));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    Object v9_2 = v0_11;
                    v34 &= 0xFFFF1FFF;
                }

                if((arg98 & 0x20) != 0) {
                    v10_2 = new Attached(false, null, null, 7, null);
                    v34 &= 0xFFF8FFFF;
                }

                if(v24 != 0) {
                    v13 = null;
                }

                Function2 v1_2 = v15 != 0 ? null : arg76;
                Function2 v2_1 = v31 != 0 ? null : arg77;
                v8_1 = v32 != 0 ? null : arg78;
                v12_2 = v33 != 0 ? null : arg79;
                Function2 v15_2 = v35 != 0 ? null : arg80;
                Function2 v16_2 = v36 != 0 ? null : arg81;
                boolean v18_1 = v37 != 0 ? false : arg82;
                InputTransformation v5_1 = v5 != 0 ? null : arg83;
                OutputTransformation v19_2 = v39 != 0 ? null : arg84;
                KeyboardOptions v20_2 = v40 != 0 ? KeyboardOptions.Companion.getDefault() : arg85;
                KeyboardActionHandler v21_2 = v26 != 0 ? null : arg86;
                if((arg98 & 0x40000) != 0) {
                    v22_2 = TextFieldLineLimits.Companion.getDefault();
                    v38 &= 0xF1FFFFFF;
                }
                else {
                    v22_2 = arg87;
                }

                v23_1 = v30 != 0 ? null : arg88;
                ScrollState v24_2 = (arg98 & v25) != 0 ? ScrollKt.rememberScrollState(0, v4, 0, 1) : arg89;
                v3 = 6;
                v0_7 = (arg98 & 0x200000) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(v4, v3) : arg90;
                Shape v71 = v0_7;
                TextFieldColors v0_12 = (arg98 & v29) != 0 ? OutlinedTextFieldDefaults.INSTANCE.colors(v4, v3) : arg91;
                PaddingValues v3_1 = (arg98 & 0x800000) != 0 ? OutlinedTextFieldDefaults.contentPadding-a9UjIt4$default(OutlinedTextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null) : arg92;
                if(v17 != 0) {
                    v17_2 = v13;
                    v13_1 = v0_12;
                    v0_9 = v9;
                    v9_1 = v11;
                    v11_1 = ((TextFieldLabelPosition)v10_2);
                    v10_1 = v17_2;
                    v33_1 = v71;
                    v25_1 = v3_1;
                    v27_1 = v5_1;
                    v26_1 = v7;
                    v17_1 = v19_2;
                    v29_1 = v20_2;
                    v30_1 = v21_2;
                    v31_1 = v23_1;
                    v32_1 = v24_2;
                    v5 = v34;
                    v19_1 = v1_2;
                    v20_1 = v2_1;
                    v21_1 = v8_1;
                    v23_1 = v15_2;
                    v24_1 = v16_2;
                    v16_1 = v22_2;
                    v2 = v38;
                    v1_1 = null;
                }
                else {
                    v17_2 = v13;
                    v13_1 = v0_12;
                    v0_9 = v9;
                    v9_1 = v11;
                    v11_1 = ((TextFieldLabelPosition)v10_2);
                    v10_1 = v17_2;
                    v33_1 = v71;
                    v25_1 = v3_1;
                    v27_1 = v5_1;
                    v26_1 = v7;
                    v17_1 = v19_2;
                    v29_1 = v20_2;
                    v30_1 = v21_2;
                    v31_1 = v23_1;
                    v32_1 = v24_2;
                    v5 = v34;
                    v19_1 = v1_2;
                    v20_1 = v2_1;
                    v21_1 = v8_1;
                    v23_1 = v15_2;
                    v24_1 = v16_2;
                    v16_1 = v22_2;
                    v2 = v38;
                    v1_1 = arg93;
                }

                v15_1 = v6;
                v22_1 = v12_2;
                v12_1 = v18_1;
            }
            else {
                v4.skipToGroupEnd();
                v5 = (arg98 & 16) != 0 ? v34 & 0xFFFF1FFF : v34;
                if((arg98 & 0x20) != 0) {
                    v5 &= 0xFFF8FFFF;
                }

                if((arg98 & 0x40000) != 0) {
                    v38 &= 0xF1FFFFFF;
                }

                v19_1 = arg76;
                v20_1 = arg77;
                v21_1 = arg78;
                v22_1 = arg79;
                v23_1 = arg80;
                v24_1 = arg81;
                v12_1 = arg82;
                v27_1 = arg83;
                v17_1 = arg84;
                v29_1 = arg85;
                v30_1 = arg86;
                v16_1 = arg87;
                v31_1 = arg88;
                v32_1 = arg89;
                v33_1 = arg90;
                v25_1 = arg92;
                v1_1 = arg93;
                v15_1 = v6;
                v26_1 = v7;
                v0_9 = v9;
                v9_1 = v11;
                v2 = v38;
                v11_1 = v10;
                v10_1 = v13;
                v13_1 = arg91;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2007078942, v5, v2, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:228)");
            }

            if(v1_1 == null) {
                v4.startReplaceGroup(0x62318F19);
                ComposerKt.sourceInformation(v4, "230@13518L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0xEA64B209, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object v2_2 = v4.rememberedValue();
                if(v2_2 == Composer.Companion.getEmpty()) {
                    v2_3 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                Object v18_2 = v2_3;
            }
            else {
                v4.startReplaceGroup(-362500226);
                v4.endReplaceGroup();
                v18_3 = v1_1;
            }

            v4.startReplaceGroup(0xEA64C75C);
            ComposerKt.sourceInformation(v4, "*234@13742L25");
            long v2_4 = v0_9.getColor-0d7_KjU();
            if(v2_4 != 16) {
            }
            else {
                v2_4 = v13_1.textColor-XeAY9LY$material3(v15_1, v12_1, FocusInteractionKt.collectIsFocusedAsState(v18_3, v4, 0).getValue().booleanValue());
            }

            v4.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(v13_1.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(0xE7322B22, true, new OutlinedTextFieldKt$OutlinedTextField$1(v9_1, v10_1, v11_1, v12_1, v13_1, v14, v15_1, v16_1, v17_1, v18_3, v19_1, v20_1, v21_1, v22_1, v23_1, v24_1, v25_1, v26_1, v27_1, v0_9.merge(new TextStyle(v2_4, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null)), v29_1, v30_1, v31_1, v32_1, v33_1), v4, 54), v4, ProvidedValue.$stable | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_2 = v0_9;
            v0_13 = v4;
            v2_5 = v9_1;
            v7_1 = v10_1;
            v6_1 = v11_1;
            v14_1 = v12_1;
            v3_2 = v15_1;
            v8_1 = v19_1;
            v9_3 = v20_1;
            v10_3 = v21_1;
            v11_3 = v22_1;
            v12_2 = v23_1;
            v4_1 = v26_1;
            v15_3 = v27_1;
            v18_4 = v30_1;
            v20_1 = v31_1;
            v21_3 = v32_1;
            v22_3 = v33_1;
            v23_2 = v13_1;
            v19_3 = v16_1;
            v16_3 = v17_1;
            v13_2 = v24_1;
            v24_3 = v25_1;
            v17_3 = v29_1;
            v25_2 = v1_1;
        }
        else {
            v4.skipToGroupEnd();
            v8_1 = arg76;
            v12_2 = arg80;
            v14_1 = arg82;
            v15_3 = arg83;
            v16_3 = arg84;
            v17_3 = arg85;
            v18_4 = arg86;
            v19_3 = arg87;
            v20_1 = arg88;
            v21_3 = arg89;
            v22_3 = arg90;
            v23_2 = arg91;
            v24_3 = arg92;
            v25_2 = arg93;
            v0_13 = v4;
            v3_2 = v6;
            v4_1 = v7;
            v5_2 = v9;
            v6_1 = v10;
            v2_5 = v11;
            v7_1 = v13;
            v9_3 = arg77;
            v10_3 = arg78;
            v11_3 = arg79;
            v13_2 = arg81;
        }

        ScopeUpdateScope v0_14 = v0_13.endRestartGroup();
        if(v0_14 != null) {
            v0_14.updateScope(new OutlinedTextFieldKt$$ExternalSyntheticLambda3(arg69, v2_5, v3_2, v4_1, v5_2, v6_1, v7_1, v8_1, v9_3, v10_3, v11_3, v12_2, v13_2, v14_1, v15_3, v16_3, v17_3, v18_4, v19_3, v20_1, v21_3, v22_3, v23_2, v24_3, v25_2, arg95, arg96, arg97, arg98));
        }
    }

    public static final void OutlinedTextField(String arg66, Function1 arg67, Modifier arg68, boolean arg69, boolean arg70, TextStyle arg71, Function2 arg72, Function2 arg73, Function2 arg74, Function2 arg75, Function2 arg76, Function2 arg77, Function2 arg78, boolean arg79, VisualTransformation arg80, KeyboardOptions arg81, KeyboardActions arg82, boolean arg83, int arg84, int arg85, MutableInteractionSource arg86, Shape arg87, TextFieldColors arg88, Composer arg89, int arg90, int arg91, int arg92, int arg93) {
        TextFieldColors v23_2;
        MutableInteractionSource v21_2;
        Shape v22_2;
        Function2 v13_1;
        Function2 v9_3;
        VisualTransformation v15_3;
        boolean v18_2;
        KeyboardActions v17_2;
        KeyboardOptions v16_3;
        boolean v5_2;
        boolean v4_1;
        boolean v14_1;
        Function2 v7_1;
        Modifier v3_1;
        Composer v0_9;
        TextStyle v6_1;
        Object v24_1;
        boolean v15_1;
        TextFieldColors v12_1;
        KeyboardOptions v18_1;
        Modifier v9_1;
        Function2 v25_1;
        TextStyle v0_6;
        boolean v16_1;
        Shape v31_1;
        MutableInteractionSource v1_1;
        boolean v20_1;
        KeyboardActions v19_1;
        VisualTransformation v23_1;
        boolean v11_1;
        Function2 v30;
        Function2 v29_1;
        Function2 v28_1;
        Function2 v27_1;
        Function2 v26;
        Function2 v11_2;
        Function2 v8_1;
        Object v9_2;
        Companion v15_2;
        int v23;
        Shape v0_5;
        MutableInteractionSource v0_4;
        int v21;
        boolean v0_3;
        int v38;
        int v37;
        int v36;
        int v35;
        int v34;
        int v33;
        int v32;
        int v31;
        Function2 v12;
        int v27;
        Function2 v10;
        int v24;
        TextStyle v9;
        int v22;
        boolean v7;
        int v19;
        boolean v6;
        int v16;
        Modifier v15;
        int v8;
        Function1 v14;
        String v13;
        int v5;
        int v0 = arg90;
        int v1 = arg91;
        int v2 = arg92;
        int v3 = arg93;
        Composer v4 = arg89.startRestartGroup(1901501544);
        ComposerKt.sourceInformation(v4, "C(OutlinedTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,isError,visualTransformation,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,interactionSource,shape,colors)404@23117L2830,404@23030L2917:OutlinedTextField.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
            v13 = arg66;
        }
        else {
            v13 = arg66;
            if((v0 & 6) == 0) {
                v5 = v4.changed(v13) ? 4 : 2;
                v5 |= v0;
            }
            else {
                v5 = v0;
            }
        }

        if((v3 & 2) != 0) {
            v5 |= 0x30;
            v14 = arg67;
        }
        else {
            v14 = arg67;
            if((v0 & 0x30) == 0) {
                v8 = v4.changedInstance(v14) ? 0x20 : 16;
                v5 |= v8;
            }
        }

        v8 = v3 & 4;
        if(v8 != 0) {
            v5 |= 0x180;
            goto label_53;
        }
        else if((v0 & 0x180) == 0) {
            v15 = arg68;
            v16 = v4.changed(v15) ? 0x100 : 0x80;
            v5 |= v16;
        }
        else {
        label_53:
            v15 = arg68;
        }

        v16 = v3 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v5 |= 0xC00;
            goto label_70;
        }
        else if((v0 & 0xC00) == 0) {
            v6 = arg69;
            v19 = v4.changed(v6) ? v17 : v18;
            v5 |= v19;
        }
        else {
        label_70:
            v6 = arg69;
        }

        v19 = v3 & 16;
        int v20 = 0x2000;
        if(v19 != 0) {
            v5 |= 0x6000;
            goto label_86;
        }
        else if((v0 & 0x6000) == 0) {
            v7 = arg70;
            v22 = v4.changed(v7) ? 0x4000 : v20;
            v5 |= v22;
        }
        else {
        label_86:
            v7 = arg70;
        }

        v22 = 0x30000;
        if((v0 & v22) == 0) {
            v9 = arg71;
            v24 = (v3 & 0x20) != 0 || !v4.changed(v9) ? 0x10000 : 0x20000;
            v5 |= v24;
        }
        else {
            v9 = arg71;
        }

        v24 = v3 & 0x40;
        int v25 = 0x180000;
        if(v24 != 0) {
            v5 |= v25;
            v10 = arg72;
        }
        else {
            v10 = arg72;
            if((v0 & v25) == 0) {
                v27 = v4.changedInstance(v10) ? 0x100000 : 0x80000;
                v5 |= v27;
            }
        }

        int v11 = v3 & 0x80;
        int v28 = 0x400000;
        int v29 = 0xC00000;
        if(v11 != 0) {
            v5 |= v29;
            v12 = arg73;
        }
        else {
            v12 = arg73;
            if((v0 & v29) == 0) {
                v31 = v4.changedInstance(v12) ? 0x800000 : v28;
                v5 |= v31;
            }
        }

        v0 = v3 & 0x100;
        v31 = 0x6000000;
        if(v0 != 0) {
            v5 |= v31;
            goto label_148;
        }
        else if((arg90 & v31) == 0) {
            v31 = v0;
            v32 = v4.changedInstance(arg74) ? 0x4000000 : 0x2000000;
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
        else if((arg90 & v32) == 0) {
            v33 = v0;
            v34 = v4.changedInstance(arg75) ? 0x20000000 : 0x10000000;
            v5 |= v34;
        }
        else {
        label_166:
            v33 = v0;
        }

        v0 = v3 & 0x400;
        if(v0 != 0) {
            v35 = v1 | 6;
            v34 = v0;
        }
        else if((v1 & 6) == 0) {
            v34 = v0;
            v35 = v4.changedInstance(arg76) ? 4 : 2;
            v35 |= v1;
        }
        else {
            v34 = v0;
            v35 = v1;
        }

        v0 = v3 & 0x800;
        if(v0 != 0) {
            v35 |= 0x30;
            v36 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v36 = v0;
            v37 = v4.changedInstance(arg77) ? 0x20 : 16;
            v35 |= v37;
        }
        else {
            v36 = v0;
        }

        v0 = v35;
        v35 = v5;
        v5 = v3 & 0x1000;
        if(v5 != 0) {
            v0 |= 0x180;
        }
        else {
            v37 = v0;
            if((v1 & 0x180) == 0) {
                v38 = v4.changedInstance(arg78) ? 0x100 : 0x80;
                v37 |= v38;
            }

            v0 = v37;
        }

        v37 = v5;
        v5 = v3 & 0x2000;
        if(v5 != 0) {
            v0 |= 0xC00;
        }
        else {
            v38 = v0;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg79)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v38 | v17;
            }
            else {
                v0 = v38;
            }
        }

        v17 = v5;
        v5 = v3 & 0x4000;
        if(v5 != 0) {
            v18 = v0 | 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v4.changed(arg80)) {
                    v20 = 0x4000;
                }

                v18 |= v20;
            }
        }

        v20 = v3 & 0x8000;
        if(v20 != 0) {
            v18 |= v22;
        }
        else {
            KeyboardOptions v0_1 = arg81;
            if((v1 & v22) == 0) {
                v22 = v4.changed(v0_1) ? 0x20000 : 0x10000;
                v18 |= v22;
            }
        }

        v22 = v3 & 0x10000;
        if(v22 != 0) {
            v18 |= v25;
        }
        else {
            KeyboardActions v0_2 = arg82;
            if((v1 & v25) == 0) {
                v25 = v4.changed(v0_2) ? 0x100000 : 0x80000;
                v18 |= v25;
            }
        }

        v25 = v3 & 0x20000;
        if(v25 != 0) {
            v18 |= v29;
        }
        else {
            v0_3 = arg83;
            if((v1 & v29) == 0) {
                v29 = v4.changed(v0_3) ? 0x800000 : v28;
                v18 |= v29;
            }
        }

        if((v1 & 0x6000000) == 0) {
            v0 = arg84;
            v29 = (v3 & 0x40000) != 0 || !v4.changed(v0) ? 0x2000000 : 0x4000000;
            v18 |= v29;
        }

        v29 = v3 & 0x80000;
        if(v29 != 0) {
            v18 |= v32;
        }
        else {
            v0 = arg85;
            if((v1 & v32) == 0) {
                v32 = v4.changed(v0) ? 0x20000000 : 0x10000000;
                v18 |= v32;
            }
        }

        v32 = v3 & 0x100000;
        if(v32 != 0) {
            v21 = v2 | 6;
        }
        else {
            v0_4 = arg86;
            if((v2 & 6) == 0) {
                v21 = v4.changed(v0_4) ? 4 : 2;
                v21 |= v2;
            }
            else {
                v21 = v2;
            }
        }

        if((v2 & 0x30) == 0) {
            v0_5 = arg87;
            v23 = (v3 & 0x200000) != 0 || !v4.changed(v0_5) ? 16 : 0x20;
            v21 |= v23;
        }

        if((v2 & 0x180) == 0) {
            v27 = (v3 & v28) != 0 || !v4.changed(arg88) ? 0x80 : 0x100;
            v21 |= v27;
        }

        v0 = v21;
        v0_3 = (v35 & 306783379) != 306783378 || (v18 & 306783379) != 306783378 || (v0 & 0x93) != 0x92 ? true : false;
        if(v4.shouldExecute(v0_3, v35 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "375@21669L7,391@22473L5,392@22536L8");
            if((arg90 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v15_2 = Modifier.Companion;
                }

                if(v16 != 0) {
                    v6 = true;
                }

                if(v19 != 0) {
                    v7 = false;
                }

                if((arg93 & 0x20) != 0) {
                    ProvidableCompositionLocal v0_7 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v0_8 = v4.consume(((CompositionLocal)v0_7));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v1 = v35 & 0xFFF8FFFF;
                    v9_2 = v0_8;
                }
                else {
                    v1 = v35;
                }

                v0_4 = null;
                if(v24 != 0) {
                    v10 = ((Function2)v0_4);
                }

                if(v11 != 0) {
                    v12 = ((Function2)v0_4);
                }

                Function2 v2_1 = v31 != 0 ? ((Function2)v0_4) : arg74;
                v8_1 = v33 != 0 ? ((Function2)v0_4) : arg75;
                v11_2 = v34 != 0 ? ((Function2)v0_4) : arg76;
                Function2 v16_2 = v36 != 0 ? ((Function2)v0_4) : arg77;
                Function2 v19_2 = v37 != 0 ? ((Function2)v0_4) : arg78;
                boolean v17_1 = v17 != 0 ? false : arg79;
                VisualTransformation v5_1 = v5 != 0 ? VisualTransformation.Companion.getNone() : arg80;
                KeyboardOptions v20_2 = v20 != 0 ? KeyboardOptions.Companion.getDefault() : arg81;
                KeyboardActions v21_1 = v22 != 0 ? KeyboardActions.Companion.getDefault() : arg82;
                boolean v22_1 = v25 != 0 ? false : arg83;
                if((arg93 & 0x40000) != 0) {
                    v23 = v22_1 ? 1 : 0x7FFFFFFF;
                    v18 &= 0xF1FFFFFF;
                }
                else {
                    v23 = arg84;
                }

                v24 = v29 != 0 ? 1 : arg85;
                if(v32 != 0) {
                }
                else {
                    v0_4 = arg86;
                }

                v3 = 6;
                MutableInteractionSource v68 = v0_4;
                v0_5 = (arg93 & 0x200000) != 0 ? OutlinedTextFieldDefaults.INSTANCE.getShape(v4, v3) : arg87;
                Shape v69 = v0_5;
                if((arg93 & v28) != 0) {
                    v31_1 = v69;
                    v26 = v2_1;
                    v27_1 = v8_1;
                    v28_1 = v11_2;
                    v25_1 = v12;
                    v29_1 = v16_2;
                    v11_1 = v17_1;
                    v2 = v18;
                    v30 = v19_2;
                    v18_1 = v20_2;
                    v19_1 = v21_1;
                    v20_1 = v22_1;
                    v21 = v23;
                    v22 = v24;
                    v12_1 = OutlinedTextFieldDefaults.INSTANCE.colors(v4, v3);
                    v23_1 = v5_1;
                    v16_1 = v7;
                    v0_6 = ((TextStyle)v9_2);
                    v9_1 = ((Modifier)v15_2);
                    v5 = v1;
                    v15_1 = v6;
                }
                else {
                    v31_1 = v69;
                    v26 = v2_1;
                    v27_1 = v8_1;
                    v0_6 = ((TextStyle)v9_2);
                    v28_1 = v11_2;
                    v25_1 = v12;
                    v9_1 = ((Modifier)v15_2);
                    v29_1 = v16_2;
                    v11_1 = v17_1;
                    v2 = v18;
                    v30 = v19_2;
                    v18_1 = v20_2;
                    v19_1 = v21_1;
                    v20_1 = v22_1;
                    v21 = v23;
                    v22 = v24;
                    v12_1 = arg88;
                    v23_1 = v5_1;
                    v15_1 = v6;
                    v16_1 = v7;
                    v5 = v1;
                }

                v1_1 = v68;
            }
            else {
                v4.skipToGroupEnd();
                v5 = (arg93 & 0x20) != 0 ? v35 & 0xFFF8FFFF : v35;
                if((arg93 & 0x40000) != 0) {
                    v18 &= 0xF1FFFFFF;
                }

                v26 = arg74;
                v27_1 = arg75;
                v28_1 = arg76;
                v29_1 = arg77;
                v30 = arg78;
                v11_1 = arg79;
                v23_1 = arg80;
                v19_1 = arg82;
                v20_1 = arg83;
                v21 = arg84;
                v22 = arg85;
                v1_1 = arg86;
                v31_1 = arg87;
                v16_1 = v7;
                v0_6 = v9;
                v25_1 = v12;
                v9_1 = v15;
                v2 = v18;
                v18_1 = arg81;
                v12_1 = arg88;
                v15_1 = v6;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1901501544, v5, v2, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:393)");
            }

            if(v1_1 == null) {
                v4.startReplaceGroup(1310051731);
                ComposerKt.sourceInformation(v4, "395@22631L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0x7621BC4F, "CC(remember):OutlinedTextField.kt#9igjgp");
                Object v2_2 = v4.rememberedValue();
                if(v2_2 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v2_3 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                v24_1 = v2_2;
            }
            else {
                v4.startReplaceGroup(0x7621B9C4);
                v4.endReplaceGroup();
                MutableInteractionSource v24_2 = v1_1;
            }

            v4.startReplaceGroup(0x7621D1A2);
            ComposerKt.sourceInformation(v4, "*399@22855L25");
            long v2_4 = v0_6.getColor-0d7_KjU();
            if(v2_4 != 16) {
            }
            else {
                v2_4 = v12_1.textColor-XeAY9LY$material3(v15_1, v11_1, FocusInteractionKt.collectIsFocusedAsState(v24_1, v4, 0).getValue().booleanValue());
            }

            v4.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(v12_1.getTextSelectionColors()), ComposableLambdaKt.rememberComposableLambda(0x6FB38128, true, new OutlinedTextFieldKt$OutlinedTextField$3(v9_1, v10, v11_1, v12_1, v13, v14, v15_1, v16_1, v0_6.merge(new TextStyle(v2_4, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null)), v18_1, v19_1, v20_1, v21, v22, v23_1, ((MutableInteractionSource)v24_1), v25_1, v26, v27_1, v28_1, v29_1, v30, v31_1), v4, 54), v4, ProvidedValue.$stable | 0x30);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_1 = v0_6;
            v0_9 = v4;
            v3_1 = v9_1;
            v7_1 = v10;
            v14_1 = v11_1;
            v4_1 = v15_1;
            v5_2 = v16_1;
            v16_3 = v18_1;
            v17_2 = v19_1;
            v18_2 = v20_1;
            v19 = v21;
            v20 = v22;
            v15_3 = v23_1;
            v8_1 = v25_1;
            v9_3 = v26;
            v10 = v27_1;
            v11_2 = v28_1;
            v13_1 = v30;
            v22_2 = v31_1;
            v21_2 = v1_1;
            v23_2 = v12_1;
            v12 = v29_1;
        }
        else {
            v4.skipToGroupEnd();
            v11_2 = arg76;
            v13_1 = arg78;
            v14_1 = arg79;
            v16_3 = arg81;
            v17_2 = arg82;
            v18_2 = arg83;
            v19 = arg84;
            v20 = arg85;
            v21_2 = arg86;
            v22_2 = arg87;
            v23_2 = arg88;
            v0_9 = v4;
            v4_1 = v6;
            v5_2 = v7;
            v6_1 = v9;
            v7_1 = v10;
            v8_1 = v12;
            v3_1 = v15;
            v9_3 = arg74;
            v10 = arg75;
            v12 = arg77;
            v15_3 = arg80;
        }

        ScopeUpdateScope v0_10 = v0_9.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new OutlinedTextFieldKt$$ExternalSyntheticLambda2(arg66, arg67, v3_1, v4_1, v5_2, v6_1, v7_1, v8_1, v9_3, v10, v11_2, v12, v13_1, v14_1, v15_3, v16_3, v17_2, v18_2, v19, v20, v21_2, v22_2, v23_2, arg90, arg91, arg92, arg93));
        }
    }

    static final Unit OutlinedTextField$lambda$2(TextFieldState arg31, Modifier arg32, boolean arg33, boolean arg34, TextStyle arg35, TextFieldLabelPosition arg36, Function3 arg37, Function2 arg38, Function2 arg39, Function2 arg40, Function2 arg41, Function2 arg42, Function2 arg43, boolean arg44, InputTransformation arg45, OutputTransformation arg46, KeyboardOptions arg47, KeyboardActionHandler arg48, TextFieldLineLimits arg49, Function2 arg50, ScrollState arg51, Shape arg52, TextFieldColors arg53, PaddingValues arg54, MutableInteractionSource arg55, int arg56, int arg57, int arg58, int arg59, Composer arg60, int arg61) {
        OutlinedTextFieldKt.OutlinedTextField(arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, arg54, arg55, arg60, RecomposeScopeImplKt.updateChangedFlags(arg56 | 1), RecomposeScopeImplKt.updateChangedFlags(arg57), RecomposeScopeImplKt.updateChangedFlags(arg58), arg59);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$5(String arg29, Function1 arg30, Modifier arg31, boolean arg32, boolean arg33, TextStyle arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, Function2 arg39, Function2 arg40, Function2 arg41, boolean arg42, VisualTransformation arg43, KeyboardOptions arg44, KeyboardActions arg45, boolean arg46, int arg47, int arg48, MutableInteractionSource arg49, Shape arg50, TextFieldColors arg51, int arg52, int arg53, int arg54, int arg55, Composer arg56, int arg57) {
        OutlinedTextFieldKt.OutlinedTextField(arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg56, RecomposeScopeImplKt.updateChangedFlags(arg52 | 1), RecomposeScopeImplKt.updateChangedFlags(arg53), RecomposeScopeImplKt.updateChangedFlags(arg54), arg55);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedTextField$lambda$8(TextFieldValue arg29, Function1 arg30, Modifier arg31, boolean arg32, boolean arg33, TextStyle arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, Function2 arg39, Function2 arg40, Function2 arg41, boolean arg42, VisualTransformation arg43, KeyboardOptions arg44, KeyboardActions arg45, boolean arg46, int arg47, int arg48, MutableInteractionSource arg49, Shape arg50, TextFieldColors arg51, int arg52, int arg53, int arg54, int arg55, Composer arg56, int arg57) {
        OutlinedTextFieldKt.OutlinedTextField(arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg56, RecomposeScopeImplKt.updateChangedFlags(arg52 | 1), RecomposeScopeImplKt.updateChangedFlags(arg53), RecomposeScopeImplKt.updateChangedFlags(arg54), arg55);
        return Unit.INSTANCE;
    }

    public static final void OutlinedTextFieldLayout(Modifier arg42, Function2 arg43, Function3 arg44, Function2 arg45, Function2 arg46, Function2 arg47, Function2 arg48, Function2 arg49, boolean arg50, TextFieldLabelPosition arg51, FloatProducer arg52, Function1 arg53, Function2 arg54, Function2 arg55, PaddingValues arg56, Composer arg57, int arg58, int arg59) {
        Function2 v1_4;
        OutlinedTextFieldKt$$ExternalSyntheticLambda4 v15_6;
        FloatProducer v9_8;
        Companion v0_6;
        TextFieldLabelPosition v12_3;
        CompositionLocalMap v5_3;
        int v3_6;
        MeasurePolicy v2_4;
        float v30;
        Composer v3_5;
        Function0 v15_4;
        Modifier v0_4;
        Function2 v3_1;
        int v0_1;
        MeasurePolicy v15_3;
        PaddingValues v14_1;
        Composer v4_2;
        Object v9_3;
        int v17;
        int v16;
        int v10_2;
        int v21;
        int v20;
        int v15;
        int v18;
        Modifier v1 = arg42;
        Function2 v2 = arg43;
        Function3 v3 = arg44;
        Function2 v4 = arg45;
        Function2 v5 = arg46;
        Function2 v6 = arg47;
        Function2 v7 = arg48;
        Function2 v8 = arg49;
        TextFieldLabelPosition v10 = arg51;
        FloatProducer v11 = arg52;
        Function2 v0 = arg54;
        Function2 v9 = arg55;
        int v12 = arg58;
        int v13 = arg59;
        Composer v14 = arg57.startRestartGroup(0x2CEC89BE);
        ComposerKt.sourceInformation(v14, "C(OutlinedTextFieldLayout)N(modifier,textField,placeholder,label,leading,trailing,prefix,suffix,singleLine,labelPosition,labelProgress,onLabelMeasured,container,supporting,paddingValues)660@36112L32,662@36177L554,679@36779L7,680@36791L4040:OutlinedTextField.kt#uh7d8r");
        if((v12 & 6) == 0) {
            v18 = v14.changed(v1) ? 4 : 2;
            v18 |= v12;
        }
        else {
            v18 = v12;
        }

        if((v12 & 0x30) == 0) {
            int v19 = v14.changedInstance(v2) ? 0x20 : 16;
            v18 |= v19;
        }

        if((v12 & 0x180) == 0) {
            v15 = v14.changedInstance(v3) ? 0x100 : 0x80;
            v18 |= v15;
        }

        if((v12 & 0xC00) == 0) {
            v15 = v14.changedInstance(v4) ? 0x800 : 0x400;
            v18 |= v15;
        }

        if((v12 & 0x6000) == 0) {
            v15 = v14.changedInstance(v5) ? 0x4000 : 0x2000;
            v18 |= v15;
        }

        if((arg58 & 0x30000) == 0) {
            v15 = v14.changedInstance(v6) ? 0x20000 : 0x10000;
            v18 |= v15;
        }

        if((arg58 & 0x180000) == 0) {
            v15 = v14.changedInstance(v7) ? 0x100000 : 0x80000;
            v18 |= v15;
        }

        if((arg58 & 0xC00000) == 0) {
            v15 = v14.changedInstance(v8) ? 0x800000 : 0x400000;
            v18 |= v15;
        }

        if((arg58 & 0x6000000) == 0) {
            v20 = v14.changed(arg50) ? 0x4000000 : 0x2000000;
            v18 |= v20;
        }

        if((arg58 & 0x30000000) == 0) {
            v20 = v14.changed(v10) ? 0x20000000 : 0x10000000;
            v18 |= v20;
        }

        v12 = v18;
        if((v13 & 6) == 0) {
            boolean v18_1 = (v13 & 8) == 0 ? v14.changed(v11) : v14.changedInstance(v11);
            v18 = v18_1 ? 4 : 2;
            v18 |= v13;
        }
        else {
            v18 = v13;
        }

        Function1 v10_1 = arg53;
        if((v13 & 0x30) == 0) {
            v21 = v14.changedInstance(v10_1) ? 0x20 : 16;
            v18 |= v21;
        }

        if((v13 & 0x180) == 0) {
            v10_2 = v14.changedInstance(v0) ? 0x100 : 0x80;
            v18 |= v10_2;
        }

        if((v13 & 0xC00) == 0) {
            v10_2 = v14.changedInstance(v9) ? 0x800 : 0x400;
            v18 |= v10_2;
        }

        if((v13 & 0x6000) == 0) {
            v21 = v14.changed(arg56) ? 0x4000 : 0x2000;
            v18 |= v21;
        }

        int v4_1 = v18;
        boolean v9_1 = (v12 & 306783379) != 306783378 || (v4_1 & 9363) != 9362 ? true : false;
        if(v14.shouldExecute(v9_1, v12 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2CEC89BE, v12, v4_1, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:659)");
            }

            float v15_1 = TextFieldImplKt.textFieldHorizontalIconPadding(v14, 0);
            ComposerKt.sourceInformationMarkerStart(v14, 0xA3F16E28, "CC(remember):OutlinedTextField.kt#9igjgp");
            int v9_2 = (v4_1 & 0x70) == 0x20 ? 1 : 0;
            int v2_1 = (0xE000000 & v12) == 0x4000000 ? 1 : 0;
            v2_1 |= v9_2;
            v9_2 = (0x70000000 & v12) == 0x20000000 ? 1 : 0;
            v2_1 |= v9_2;
            v9_2 = v4_1 & 14;
            if(v9_2 != 4) {
                if((v4_1 & 8) != 0 && (v14.changed(v11))) {
                    goto label_218;
                }

                v16 = 0;
            }
            else {
            label_218:
                v16 = 1;
            }

            v16 |= v2_1;
            v2_1 = (v4_1 & 0xE000) == 0x4000 ? 1 : 0;
            v2_1 = v16 | v2_1 | v14.changed(v15_1);
            Object v10_3 = v14.rememberedValue();
            if(v2_1 != 0 || v10_3 == Composer.Companion.getEmpty()) {
                v21 = v9_2;
                v17 = v4_1;
                v20 = v12;
                v4_2 = v14;
                v14_1 = arg56;
                OutlinedTextFieldMeasurePolicy v9_4 = new OutlinedTextFieldMeasurePolicy(arg53, arg50, arg51, v11, v14_1, v15_1, null);
                v4_2.updateRememberedValue(v9_4);
            }
            else {
                v17 = v4_1;
                v21 = v9_2;
                v9_3 = v10_3;
                v20 = v12;
                v4_2 = v14;
                v14_1 = arg56;
            }

            ComposerKt.sourceInformationMarkerEnd(v4_2);
            ProvidableCompositionLocal v12_1 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(v4_2, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = v4_2.consume(((CompositionLocal)v12_1));
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            String v13_1 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
            int v22 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
            CompositionLocalMap v12_2 = v4_2.getCurrentCompositionLocalMap();
            Object v23 = v9_3;
            Modifier v9_5 = ComposedModifierKt.materializeModifier(v4_2, v1);
            Function0 v1_1 = ComposeUiNode.Companion.getConstructor();
            float v24 = v15_1;
            String v11_1 = "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
            if(!(v4_2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4_2.startReusableNode();
            if(v4_2.getInserting()) {
                v4_2.createNode(v1_1);
            }
            else {
                v4_2.useNode();
            }

            Composer v1_2 = Updater.constructor-impl(v4_2);
            Updater.set-impl(v1_2, v23, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v1_2, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 v10_4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v1_2.getInserting()) || !Intrinsics.areEqual(v1_2.rememberedValue(), Integer.valueOf(v22))) {
                v1_2.updateRememberedValue(Integer.valueOf(v22));
                v1_2.apply(Integer.valueOf(v22), v10_4);
            }

            Updater.set-impl(v1_2, v9_5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4_2, 0x7FE4B943, "C683@36860L11,751@39346L187:OutlinedTextField.kt#uh7d8r");
            v0.invoke(v4_2, Integer.valueOf(v17 >> 6 & 14));
            String v1_3 = "C72@3468L9:Box.kt#2w3rfo";
            String v10_5 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
            v12 = 0x2BB5B5D7;
            if(v5 != null) {
                v4_2.startReplaceGroup(0x7FE3B06D);
                ComposerKt.sourceInformation(v4_2, "686@36924L224");
                v9_5 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, "Leading"));
                Alignment v15_2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(v4_2, v12, v10_5);
                v15_3 = BoxKt.maybeCachedBoxMeasurePolicy(v15_2, false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v0_1 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v12_2 = v4_2.getCurrentCompositionLocalMap();
                v9_5 = ComposedModifierKt.materializeModifier(v4_2, v9_5);
                int v26 = v0_1;
                Function0 v0_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v0_2);
                }
                else {
                    v4_2.useNode();
                }

                Composer v0_3 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v0_3, v15_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v0_3, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v3_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v0_3.getInserting()) || !Intrinsics.areEqual(v0_3.rememberedValue(), Integer.valueOf(v26))) {
                    v0_3.updateRememberedValue(Integer.valueOf(v26));
                    v0_3.apply(Integer.valueOf(v26), v3_1);
                }

                Updater.set-impl(v0_3, v9_5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD8EB484, "C690@37121L9:OutlinedTextField.kt#uh7d8r");
                v5.invoke(v4_2, Integer.valueOf(v20 >> 12 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v4_2.startReplaceGroup(0x7FE7716D);
                v4_2.endReplaceGroup();
            }

            if(v6 != null) {
                v4_2.startReplaceGroup(0x7FE8184B);
                ComposerKt.sourceInformation(v4_2, "694@37215L226");
                v0_4 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(LayoutIdKt.layoutId(Modifier.Companion, "Trailing"));
                Alignment v3_2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
                MeasurePolicy v3_3 = BoxKt.maybeCachedBoxMeasurePolicy(v3_2, false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v9_2 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v12_2 = v4_2.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v4_2, v0_4);
                v15_4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v15_4);
                }
                else {
                    v4_2.useNode();
                }

                Composer v5_1 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v5_1, v3_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v5_1, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v3_1 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v5_1.getInserting()) || !Intrinsics.areEqual(v5_1.rememberedValue(), Integer.valueOf(v9_2))) {
                    v5_1.updateRememberedValue(Integer.valueOf(v9_2));
                    v5_1.apply(Integer.valueOf(v9_2), v3_1);
                }

                Updater.set-impl(v5_1, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x1FAAED8C, "C698@37413L10:OutlinedTextField.kt#uh7d8r");
                v6.invoke(v4_2, Integer.valueOf(v20 >> 15 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v4_2.startReplaceGroup(0x7FEBE0CD);
                v4_2.endReplaceGroup();
            }

            float v0_5 = PaddingKt.calculateStartPadding(v14_1, ((LayoutDirection)v2_2));
            float v2_3 = PaddingKt.calculateEndPadding(v14_1, ((LayoutDirection)v2_2));
            if(arg46 != null) {
                v0_5 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(v0_5 - v24), Dp.constructor-impl(0f)));
            }

            float v26_1 = v0_5;
            if(v6 != null) {
                v2_3 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(v2_3 - v24), Dp.constructor-impl(0f)));
            }

            v0_1 = 3;
            Object v5_2 = null;
            if(v7 != null) {
                v4_2.startReplaceGroup(0x7FF69EB8);
                ComposerKt.sourceInformation(v4_2, "719@38172L309");
                v9_5 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "Prefix"), TextFieldImplKt.getMinTextLineHeight(), 0f, 2, v5_2), ((Vertical)v5_2), false, v0_1, v5_2), v26_1, 0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
                v15_3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v0_1 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v12_2 = v4_2.getCurrentCompositionLocalMap();
                v9_5 = ComposedModifierKt.materializeModifier(v4_2, v9_5);
                Function0 v3_4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v3_4);
                }
                else {
                    v4_2.useNode();
                }

                v3_5 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v3_5, v15_3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v3_5, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v3_5.getInserting()) || !Intrinsics.areEqual(v3_5.rememberedValue(), Integer.valueOf(v0_1))) {
                    v3_5.updateRememberedValue(Integer.valueOf(v0_1));
                    v3_5.apply(Integer.valueOf(v0_1), v5);
                }

                Updater.set-impl(v3_5, v9_5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 843401773, "C725@38455L8:OutlinedTextField.kt#uh7d8r");
                v7.invoke(v4_2, Integer.valueOf(v20 >> 18 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v4_2.startReplaceGroup(0x7FFB9ECD);
                v4_2.endReplaceGroup();
            }

            if(v8 != null) {
                v4_2.startReplaceGroup(0x7FFC47BA);
                ComposerKt.sourceInformation(v4_2, "729@38546L307");
                v30 = v2_3;
                v0_4 = PaddingKt.padding-qDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "Suffix"), TextFieldImplKt.getMinTextLineHeight(), 0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0f, v30, 0f, 10, null);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
                v2_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v3_6 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v5_3 = v4_2.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v4_2, v0_4);
                Function0 v9_6 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v9_6);
                }
                else {
                    v4_2.useNode();
                }

                Composer v9_7 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v9_7, v2_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v9_7, v5_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v9_7.getInserting()) || !Intrinsics.areEqual(v9_7.rememberedValue(), Integer.valueOf(v3_6))) {
                    v9_7.updateRememberedValue(Integer.valueOf(v3_6));
                    v9_7.apply(Integer.valueOf(v3_6), v2);
                }

                Updater.set-impl(v9_7, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x44DFA70C, "C735@38827L8:OutlinedTextField.kt#uh7d8r");
                v8.invoke(v4_2, Integer.valueOf(v20 >> 21 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v30 = v2_3;
                v4_2.startReplaceGroup(0x8001404D);
                v4_2.endReplaceGroup();
            }

            Modifier v34 = SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(Modifier.Companion, TextFieldImplKt.getMinTextLineHeight(), 0f, 2, null), null, false, 3, null);
            if(v7 == null) {
            }
            else {
                v26_1 = Dp.constructor-impl(0f);
            }

            float v35 = v26_1;
            float v37 = v8 == null ? v30 : Dp.constructor-impl(0f);
            v0_4 = PaddingKt.padding-qDBjuR0$default(v34, v35, 0f, v37, 0f, 10, null);
            if(arg44 != null) {
                v4_2.startReplaceGroup(0x8006E58E);
                ComposerKt.sourceInformation(v4_2, "748@39255L63");
                arg44.invoke(LayoutIdKt.layoutId(Modifier.Companion, "Hint").then(v0_4), v4_2, Integer.valueOf(v20 >> 3 & 0x70));
                v4_2.endReplaceGroup();
            }
            else {
                v4_2.startReplaceGroup(0x80084A2D);
                v4_2.endReplaceGroup();
            }

            v0_4 = LayoutIdKt.layoutId(Modifier.Companion, "TextField").then(v0_4);
            ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
            v2_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
            v9_2 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
            v12_2 = v4_2.getCurrentCompositionLocalMap();
            v0_4 = ComposedModifierKt.materializeModifier(v4_2, v0_4);
            v15_4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
            if(!(v4_2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4_2.startReusableNode();
            if(v4_2.getInserting()) {
                v4_2.createNode(v15_4);
            }
            else {
                v4_2.useNode();
            }

            v3_5 = Updater.constructor-impl(v4_2);
            Updater.set-impl(v3_5, v2_4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v3_5, v12_2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            v2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if((v3_5.getInserting()) || !Intrinsics.areEqual(v3_5.rememberedValue(), Integer.valueOf(v9_2))) {
                v3_5.updateRememberedValue(Integer.valueOf(v9_2));
                v3_5.apply(Integer.valueOf(v9_2), v2);
            }

            Updater.set-impl(v3_5, v0_4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
            ComposerKt.sourceInformationMarkerStart(v4_2, -332553027, "C755@39508L11:OutlinedTextField.kt#uh7d8r");
            arg43.invoke(v4_2, Integer.valueOf(v20 >> 3 & 14));
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            v4_2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            v12_3 = arg51;
            if((v12_3 instanceof Above)) {
                v0_4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, TextFieldImplKt.getAboveLabelHorizontalPadding(), 0f, TextFieldImplKt.getAboveLabelHorizontalPadding(), TextFieldImplKt.getAboveLabelBottomPadding(), 2, null);
            }
            else {
                v0_6 = Modifier.Companion;
            }

            if(arg45 != null) {
                v4_2.startReplaceGroup(0x80123F52);
                ComposerKt.sourceInformation(v4_2, "771@40053L123,770@39995L379");
                Companion v3_7 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x80009F10, "CC(remember):OutlinedTextField.kt#9igjgp");
                if(v21 != 4) {
                    if((v17 & 8) != 0) {
                        v9_8 = arg52;
                        if(v4_2.changedInstance(v9_8)) {
                            goto label_821;
                        }
                    }
                    else {
                        v9_8 = arg52;
                    }

                    v18 = 0;
                }
                else {
                    v9_8 = arg52;
                label_821:
                    v18 = 1;
                }

                Object v15_5 = v4_2.rememberedValue();
                if(v18 != 0 || v15_5 == Composer.Companion.getEmpty()) {
                    v15_6 = new OutlinedTextFieldKt$$ExternalSyntheticLambda4(v9_8);
                    v4_2.updateRememberedValue(v15_6);
                }

                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v0_4 = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(TextFieldImplKt.textFieldLabelMinHeight(((Modifier)v3_7), ((Function0)v15_6)), null, false, 3, null), "Label").then(((Modifier)v0_6));
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
                v2_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v3_6 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v5_3 = v4_2.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v4_2, v0_4);
                v15_4 = ComposeUiNode.Companion.getConstructor();
                v18 = v3_6;
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v15_4);
                }
                else {
                    v4_2.useNode();
                }

                v3_5 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v3_5, v2_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v3_5, v5_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v3_5.getInserting()) || !Intrinsics.areEqual(v3_5.rememberedValue(), Integer.valueOf(v18))) {
                    v3_5.updateRememberedValue(Integer.valueOf(v18));
                    v3_5.apply(Integer.valueOf(v18), v2);
                }

                Updater.set-impl(v3_5, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x6A1460AB, "C778@40349L7:OutlinedTextField.kt#uh7d8r");
                arg45.invoke(v4_2, Integer.valueOf(v20 >> 9 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v9_8 = arg52;
                v4_2.startReplaceGroup(0x8018462D);
                v4_2.endReplaceGroup();
            }

            if(arg55 != null) {
                v4_2.startReplaceGroup(0x801903B0);
                ComposerKt.sourceInformation(v4_2, "783@40444L317");
                v0_4 = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.heightIn-VpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "Supporting"), TextFieldImplKt.getMinSupportingTextLineHeight(), 0f, 2, null), null, false, 3, null), TextFieldDefaults.supportingTextPadding-a9UjIt4$material3$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null));
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x2BB5B5D7, v10_5);
                v2_4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(v4_2, -1323940314, v13_1);
                v3_6 = ComposablesKt.getCurrentCompositeKeyHash(v4_2, 0);
                v5_3 = v4_2.getCurrentCompositionLocalMap();
                v0_4 = ComposedModifierKt.materializeModifier(v4_2, v0_4);
                Function0 v10_6 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v4_2, 0xD6BD0031, v11_1);
                if(!(v4_2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v4_2.startReusableNode();
                if(v4_2.getInserting()) {
                    v4_2.createNode(v10_6);
                }
                else {
                    v4_2.useNode();
                }

                Composer v10_7 = Updater.constructor-impl(v4_2);
                Updater.set-impl(v10_7, v2_4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v10_7, v5_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                v2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if((v10_7.getInserting()) || !Intrinsics.areEqual(v10_7.rememberedValue(), Integer.valueOf(v3_6))) {
                    v10_7.updateRememberedValue(Integer.valueOf(v3_6));
                    v10_7.apply(Integer.valueOf(v3_6), v2);
                }

                Updater.set-impl(v10_7, v0_4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(v4_2, 0x800B7D29, v1_3);
                ComposerKt.sourceInformationMarkerStart(v4_2, 2091826725, "C789@40731L12:OutlinedTextField.kt#uh7d8r");
                v1_4 = arg55;
                v1_4.invoke(v4_2, Integer.valueOf(v17 >> 9 & 14));
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endNode();
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                ComposerKt.sourceInformationMarkerEnd(v4_2);
                v4_2.endReplaceGroup();
            }
            else {
                v1_4 = arg55;
                v4_2.startReplaceGroup(0x801E21CD);
                v4_2.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v4_2);
            v4_2.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            ComposerKt.sourceInformationMarkerEnd(v4_2);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_1019;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v12_3 = arg51;
            v1_4 = arg55;
            v9_8 = v11;
            v4_2 = v14;
            v14_1 = arg56;
            v4_2.skipToGroupEnd();
        }

    label_1019:
        ScopeUpdateScope v0_7 = v4_2.endRestartGroup();
        if(v0_7 != null) {
            v0_7.updateScope(new OutlinedTextFieldKt$$ExternalSyntheticLambda5(arg42, arg43, arg44, arg45, arg46, v6, v7, v8, arg50, v12_3, v9_8, arg53, arg54, v1_4, v14_1, arg58, arg59));
        }
    }

    static final Dp OutlinedTextFieldLayout$lambda$19$lambda$16$lambda$15(FloatProducer arg2) {
        return Dp.box-impl(DpKt.lerp-Md-fbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), arg2.invoke()));
    }

    static final Unit OutlinedTextFieldLayout$lambda$20(Modifier arg19, Function2 arg20, Function3 arg21, Function2 arg22, Function2 arg23, Function2 arg24, Function2 arg25, Function2 arg26, boolean arg27, TextFieldLabelPosition arg28, FloatProducer arg29, Function1 arg30, Function2 arg31, Function2 arg32, PaddingValues arg33, int arg34, int arg35, Composer arg36, int arg37) {
        OutlinedTextFieldKt.OutlinedTextFieldLayout(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg36, RecomposeScopeImplKt.updateChangedFlags(arg34 | 1), RecomposeScopeImplKt.updateChangedFlags(arg35));
        return Unit.INSTANCE;
    }

    public static final Modifier outlineCutout(Modifier arg1, Function0 arg2, Horizontal arg3, PaddingValues arg4) {
        return DrawModifierKt.drawWithContent(arg1, new OutlinedTextFieldKt$$ExternalSyntheticLambda1(arg2, arg4, arg3));
    }

    static final Unit outlineCutout$lambda$22(Function0 arg12, PaddingValues arg13, Horizontal arg14, ContentDrawScope arg15) {
        long v0 = arg12.invoke().unbox-impl();
        int v12 = 0x20;
        float v2 = Float.intBitsToFloat(((int)(v0 >> v12)));
        if(v2 > 0f) {
            float v4 = arg15.toPx-0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float v5 = arg15.toPx-0680j_4(arg13.calculateLeftPadding-u2uoSUM(arg15.getLayoutDirection()));
            float v13 = arg15.toPx-0680j_4(arg13.calculateRightPadding-u2uoSUM(arg15.getLayoutDirection()));
            int v6 = MathKt.roundToInt(v2);
            v2 /= 2f;
            v13 = (((float)arg14.align(v6, MathKt.roundToInt(Float.intBitsToFloat(((int)(arg15.getSize-NH-jbRc() >> v12))) - v5 - v13), arg15.getLayoutDirection()))) + v5 + v2;
            float v7 = RangesKt.coerceAtLeast(v13 - v2 - v4, 0f);
            float v9 = RangesKt.coerceAtMost(v13 + v2 + v4, Float.intBitsToFloat(((int)(arg15.getSize-NH-jbRc() >> v12))));
            float v12_1 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & v0)));
            float v8 = -v12_1 / 2f;
            float v10 = v12_1 / 2f;
            int v11 = ClipOp.Companion.getDifference-rtfAjoo();
            DrawContext v12_2 = arg15.getDrawContext();
            long v13_1 = v12_2.getSize-NH-jbRc();
            v12_2.getCanvas().save();
            try {
                v12_2.getTransform().clipRect-N_I0leg(v7, v8, v9, v10, v11);
                arg15.drawContent();
            }
            catch(Throwable v0_1) {
                v12_2.getCanvas().restore();
                v12_2.setSize-uvyYCjk(v13_1);
                throw v0_1;
            }

            v12_2.getCanvas().restore();
            v12_2.setSize-uvyYCjk(v13_1);
        }
        else {
            arg15.drawContent();
        }

        return Unit.INSTANCE;
    }
}

