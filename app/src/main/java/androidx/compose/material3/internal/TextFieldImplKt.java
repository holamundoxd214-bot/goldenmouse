package androidx.compose.material3.internal;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MotionSchemeKt;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextFieldLabelPosition$Above;
import androidx.compose.material3.TextFieldLabelPosition$Attached;
import androidx.compose.material3.TextFieldLabelPosition;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\u001A\u0099\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0011\u0010\u0006\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\t\u001A\u00020\n2\u001E\u0010\u000B\u001A\u001A\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\b¢\u0006\u0002\b\u000E2\u0013\u0010\u000F\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0010\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0011\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0013\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0013\u0010\u0014\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\b2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001E2\u0011\u0010\u001F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010 \u001A2\u0010*\u001A\u00020\u00012\u0006\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\u0011\u0010/\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b0\u00101\u001A*\u0010*\u001A\u00020\u00012\u0006\u0010+\u001A\u00020,2\u0011\u0010/\u001A\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0004\b2\u00103\u001A\u001C\u00104\u001A\u000205*\u0002052\u0006\u0010\u0018\u001A\u00020\u00162\u0006\u00106\u001A\u000207H\u0000\u001A\u001C\u00108\u001A\u000205*\u0002052\u0006\u00109\u001A\u00020:2\u0006\u0010;\u001A\u00020<H\u0000\u001A\u001A\u0010=\u001A\u000205*\u0002052\f\u0010>\u001A\b\u0012\u0004\u0012\u00020?0\u0007H\u0000\u001AÔ\u0001\u0010@\u001A\u00020\u00012\u0006\u0010A\u001A\u00020B2\u0006\u0010C\u001A\u00020,2\u0006\u0010D\u001A\u00020,2\u0006\u0010E\u001A\u00020,2\u0006\u0010!\u001A\u00020\u00162\u0099\u0001\u0010/\u001A\u0094\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(L\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020,0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(N\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020H0G¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\b\bH\u0083\b¢\u0006\u0004\bP\u0010Q\u001AE\u0010R\u001A\b\u0012\u0004\u0012\u00020S0G2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u00162\u0006\u0010T\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010U\u001A\u00020?2\u0006\u0010V\u001A\u00020?H\u0001¢\u0006\u0004\bW\u0010X\u001A\r\u0010b\u001A\u00020?H\u0001¢\u0006\u0002\u0010c\u001A\r\u0010d\u001A\u00020?H\u0001¢\u0006\u0002\u0010c\"\u0018\u0010!\u001A\u00020\u0016*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#\"\u0018\u0010$\u001A\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'\"\u0018\u0010(\u001A\u00020%*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b)\u0010\'\"\u000E\u0010Y\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010Z\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010[\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\\\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010]\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010^\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010_\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010`\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010a\u001A\u000207X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010e\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bf\u0010g\"\u0016\u0010i\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bj\u0010g\"\u0016\u0010k\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bl\u0010g\"\u0016\u0010m\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bn\u0010g\"\u0016\u0010o\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bp\u0010g\"\u0016\u0010q\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\br\u0010g\"\u0016\u0010s\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bt\u0010g\"\u0016\u0010u\u001A\u00020?X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001A\u0004\bv\u0010g¨\u0006w²\u0006\n\u0010x\u001A\u00020\u0016X\u008A\u0084\u0002²\u0006\n\u0010y\u001A\u00020\u0016X\u008A\u0084\u0002"}, d2={"CommonDecorationBox", "", "type", "Landroidx/compose/material3/internal/TextFieldType;", "visualText", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "labelPosition", "Landroidx/compose/material3/TextFieldLabelPosition;", "label", "Lkotlin/Function1;", "Landroidx/compose/material3/TextFieldLabelScope;", "Lkotlin/ExtensionFunctionType;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/internal/TextFieldType;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldLabelPosition;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "showExpandedLabel", "getShowExpandedLabel", "(Landroidx/compose/material3/TextFieldLabelPosition;)Z", "minimizedAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getMinimizedAlignment", "(Landroidx/compose/material3/TextFieldLabelPosition;)Landroidx/compose/ui/Alignment$Horizontal;", "expandedAlignment", "getExpandedAlignment", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-3J-VO9M", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Decoration-Iv8Zu3U", "(JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "defaultErrorSemantics", "Landroidx/compose/ui/Modifier;", "defaultErrorMessage", "", "textFieldBackground", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "shape", "Landroidx/compose/ui/graphics/Shape;", "textFieldLabelMinHeight", "minHeight", "Landroidx/compose/ui/unit/Dp;", "TextFieldTransitionScope", "inputState", "Landroidx/compose/material3/internal/InputPhase;", "focusedLabelTextStyleColor", "unfocusedLabelTextStyleColor", "labelColor", "Lkotlin/Function5;", "Landroidx/compose/runtime/State;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "TextFieldTransitionScope-Jy8F4Js", "(Landroidx/compose/material3/internal/InputPhase;JJJZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "animateBorderStrokeAsState", "Landroidx/compose/foundation/BorderStroke;", "focused", "focusedBorderThickness", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZZLandroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TextFieldId", "PlaceholderId", "LabelId", "LeadingId", "TrailingId", "PrefixId", "SuffixId", "SupportingId", "ContainerId", "textFieldHorizontalIconPadding", "(Landroidx/compose/runtime/Composer;I)F", "minimizedLabelHalfHeight", "TextFieldPadding", "getTextFieldPadding", "()F", "F", "AboveLabelHorizontalPadding", "getAboveLabelHorizontalPadding", "AboveLabelBottomPadding", "getAboveLabelBottomPadding", "SupportingTopPadding", "getSupportingTopPadding", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "MinTextLineHeight", "getMinTextLineHeight", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "material3", "showPlaceholder", "showPrefixSuffix"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextFieldImplKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TextFieldType.values().length];
            try {
                v0[TextFieldType.Filled.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
            label_7:
                int v2 = 2;
                try {
                    v0[TextFieldType.Outlined.ordinal()] = v2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    v0 = new int[InputPhase.values().length];
                    try {
                        v0[InputPhase.Focused.ordinal()] = 1;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            v0[InputPhase.UnfocusedEmpty.ordinal()] = v2;
                            goto label_21;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_21:
                                v0[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
                                goto label_25;
                            }
                            catch(NoSuchFieldError ) {
                            label_25:
                                WhenMappings.$EnumSwitchMapping$1 = v0;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static final float AboveLabelBottomPadding = 0f;
    private static final float AboveLabelHorizontalPadding = 0f;
    public static final String ContainerId = "Container";
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight = 0f;
    private static final float MinSupportingTextLineHeight = 0f;
    private static final float MinTextLineHeight = 0f;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    private static final float PrefixSuffixTextPadding = 0f;
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = 0f;
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = 0f;
    public static final String TrailingId = "Trailing";

    static {
        TextFieldImplKt.TextFieldPadding = Dp.constructor-impl(16f);
        TextFieldImplKt.AboveLabelHorizontalPadding = Dp.constructor-impl(4f);
        TextFieldImplKt.AboveLabelBottomPadding = Dp.constructor-impl(4f);
        TextFieldImplKt.SupportingTopPadding = Dp.constructor-impl(4f);
        TextFieldImplKt.PrefixSuffixTextPadding = Dp.constructor-impl(2f);
        TextFieldImplKt.MinTextLineHeight = Dp.constructor-impl(24f);
        TextFieldImplKt.MinFocusedLabelLineHeight = Dp.constructor-impl(16f);
        TextFieldImplKt.MinSupportingTextLineHeight = Dp.constructor-impl(16f);
    }

    public static final void CommonDecorationBox(TextFieldType arg44, CharSequence arg45, Function2 arg46, TextFieldLabelPosition arg47, Function3 arg48, Function2 arg49, Function2 arg50, Function2 arg51, Function2 arg52, Function2 arg53, Function2 arg54, boolean arg55, boolean arg56, boolean arg57, InteractionSource arg58, PaddingValues arg59, TextFieldColors arg60, Function2 arg61, Composer arg62, int arg63, int arg64) {
        Composer v22;
        TextFieldImplKt$$ExternalSyntheticLambda4 v11_4;
        MutableState v2_7;
        Function2 v5_8;
        ComposableLambda v62_1;
        ComposableLambda v19;
        ComposableLambda v0_7;
        State v1_9;
        ComposableLambda v17_6;
        State v0_6;
        State v5_7;
        String v11_2;
        int v42;
        boolean v12_1;
        TextStyle v6_2;
        TextStyle v4_8;
        State v62;
        State v17_5;
        State v7_3;
        Composer v15_1;
        TextFieldColors v9_1;
        boolean v14_1;
        boolean v13_5;
        TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1 v1_7;
        int v13_4;
        TextStyle v31_1;
        float v4_4;
        float v1_4;
        long v40;
        Object v18;
        float v3_4;
        int v37;
        boolean v36;
        boolean v5_3;
        InputPhase v7_1;
        TextFieldColors v5_2;
        int v5_1;
        int v17;
        int v16;
        int v6;
        TextFieldLabelPosition v9 = arg47;
        Function3 v5 = arg48;
        Function2 v10 = arg49;
        Function2 v11 = arg50;
        Function2 v12 = arg51;
        Function2 v13 = arg52;
        Function2 v14 = arg53;
        Function2 v15 = arg54;
        boolean v0 = arg56;
        boolean v1 = arg57;
        InteractionSource v2 = arg58;
        PaddingValues v3 = arg59;
        int v7 = arg63;
        int v8 = arg64;
        Composer v4 = arg62.startRestartGroup(546805032);
        ComposerKt.sourceInformation(v4, "C(CommonDecorationBox)N(type,visualText,innerTextField,labelPosition,label,placeholder,leadingIcon,trailingIcon,prefix,suffix,supportingText,singleLine,enabled,isError,interactionSource,contentPadding,colors,container)99@4125L25,109@4463L10,116@4780L8045:TextFieldImpl.kt#mqatfk");
        if((v7 & 6) == 0) {
            v6 = v4.changed(arg44.ordinal()) ? 4 : 2;
            v6 |= v7;
        }
        else {
            v6 = v7;
        }

        if((v7 & 0x30) == 0) {
            v16 = v6;
            v17 = v4.changedInstance(arg45) ? 0x20 : 16;
            v16 |= v17;
        }
        else {
            v16 = v6;
        }

        if((v7 & 0x180) == 0) {
            v17 = v4.changedInstance(arg46) ? 0x100 : 0x80;
            v16 |= v17;
        }

        if((v7 & 0xC00) == 0) {
            v17 = v4.changed(v9) ? 0x800 : 0x400;
            v16 |= v17;
        }

        if((v7 & 0x6000) == 0) {
            v6 = v4.changedInstance(v5) ? 0x4000 : 0x2000;
            v16 |= v6;
        }

        if((0x30000 & v7) == 0) {
            v6 = v4.changedInstance(v10) ? 0x20000 : 0x10000;
            v16 |= v6;
        }

        if((0x180000 & v7) == 0) {
            v6 = v4.changedInstance(v11) ? 0x100000 : 0x80000;
            v16 |= v6;
        }

        if((0xC00000 & v7) == 0) {
            v6 = v4.changedInstance(v12) ? 0x800000 : 0x400000;
            v16 |= v6;
        }

        if((0x6000000 & v7) == 0) {
            v6 = v4.changedInstance(v13) ? 0x4000000 : 0x2000000;
            v16 |= v6;
        }

        if((0x30000000 & v7) == 0) {
            v6 = v4.changedInstance(v14) ? 0x20000000 : 0x10000000;
            v16 |= v6;
        }

        v6 = v16;
        if((v8 & 6) == 0) {
            v16 = v4.changedInstance(v15) ? 4 : 2;
            v16 |= v8;
        }
        else {
            v16 = v8;
        }

        boolean v10_1 = arg55;
        if((v8 & 0x30) == 0) {
            v17 = v4.changed(v10_1) ? 0x20 : 16;
            v16 |= v17;
        }

        if((v8 & 0x180) == 0) {
            v5_1 = v4.changed(v0) ? 0x100 : 0x80;
            v16 |= v5_1;
        }

        if((v8 & 0xC00) == 0) {
            v5_1 = v4.changed(v1) ? 0x800 : 0x400;
            v16 |= v5_1;
        }

        if((v8 & 0x6000) == 0) {
            v5_1 = v4.changed(v2) ? 0x4000 : 0x2000;
            v16 |= v5_1;
        }

        if((0x30000 & v8) == 0) {
            v5_1 = v4.changed(v3) ? 0x20000 : 0x10000;
            v16 |= v5_1;
        }

        if((0x180000 & v8) == 0) {
            v5_2 = arg60;
            v17 = v4.changed(v5_2) ? 0x100000 : 0x80000;
            v16 |= v17;
        }
        else {
            v5_2 = arg60;
        }

        Function2 v3_1 = arg61;
        if((v8 & 0xC00000) == 0) {
            v17 = v4.changedInstance(v3_1) ? 0x800000 : 0x400000;
            v16 |= v17;
        }

        int v10_2 = v16;
        boolean v3_2 = (v6 & 306783379) != 306783378 || (0x492493 & v10_2) != 4793490 ? true : false;
        if(v4.shouldExecute(v3_2, v6 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(546805032, v6, v10_2, "androidx.compose.material3.internal.CommonDecorationBox (TextFieldImpl.kt:98)");
            }

            v3_2 = FocusInteractionKt.collectIsFocusedAsState(v2, v4, v10_2 >> 12 & 14).getValue().booleanValue();
            if(v3_2) {
                v7_1 = InputPhase.Focused;
            }
            else if(arg45.length() == 0) {
                v7_1 = InputPhase.UnfocusedEmpty;
            }
            else {
                v7_1 = InputPhase.UnfocusedNotEmpty;
            }

            long v25 = v5_2.labelColor-XeAY9LY$material3(v0, v1, v3_2);
            int v28 = v10_2;
            Typography v13_1 = MaterialTheme.INSTANCE.getTypography(v4, 6);
            TextStyle v1_1 = v13_1.getBodyLarge();
            TextStyle v13_2 = v13_1.getBodySmall();
            TextStyle v30 = v1_1;
            if(!Color.equals-impl0(v1_1.getColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU()) || (Color.equals-impl0(v13_2.getColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU()))) {
                if(!Color.equals-impl0(v30.getColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU()) && (Color.equals-impl0(v13_2.getColor-0d7_KjU(), Color.Companion.getUnspecified-0d7_KjU()))) {
                label_255:
                    v5_3 = true;
                    goto label_258;
                }

                v5_3 = false;
            }
            else {
                goto label_255;
            }

        label_258:
            long v0_1 = v13_2.getColor-0d7_KjU();
            if(v5_3) {
                if(v0_1 != 16) {
                }
                else {
                    v0_1 = v25;
                }
            }

            long v10_3 = v30.getColor-0d7_KjU();
            if(v5_3) {
                if(v10_3 != 16) {
                }
                else {
                    v10_3 = v25;
                }
            }

            int v31 = arg48 == null || !TextFieldImplKt.getShowExpandedLabel(v9) ? 0 : 1;
            long v32 = v0_1;
            ComposerKt.sourceInformationMarkerStart(v4, 0x80E48A8B, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
            Transition v16_1 = TransitionKt.updateTransition(v7_1, "TextFieldInputState", v4, 0x30, 0);
            TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 v2_1 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v4, 6));
            ComposerKt.sourceInformationMarkerStart(v4, 0xB03404EB, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter v20 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            String v7_2 = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
            ComposerKt.sourceInformationMarkerStart(v4, 0xF77F2E11, v7_2);
            Object v17_1 = v16_1.getCurrentState();
            v4.startReplaceGroup(-1436405362);
            String v0_2 = "CN(it):TextFieldImpl.kt#mqatfk";
            ComposerKt.sourceInformation(v4, v0_2);
            int v1_2 = -1;
            boolean v35 = v3_2;
            if(ComposerKt.isTraceInProgress()) {
                v36 = v5_3;
                v37 = v6;
                ComposerKt.traceEventStart(-1436405362, 0, v1_2, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
            }
            else {
                v36 = v5_3;
                v37 = v6;
            }

            int v3_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v17_1).ordinal()];
            v6 = 3;
            float v38 = 1f;
            if(v3_3 == 1) {
            label_332:
                v3_4 = v38;
            }
            else if(v3_3 != 2) {
                if(v3_3 == v6) {
                    goto label_332;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else if(v31 != 0) {
                v3_4 = 0f;
            }
            else {
                goto label_332;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4.endReplaceGroup();
            Float v17_2 = Float.valueOf(v3_4);
            Object v3_5 = v16_1.getTargetState();
            v5_1 = -1436405362;
            v4.startReplaceGroup(v5_1);
            ComposerKt.sourceInformation(v4, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v18 = v3_5;
                ComposerKt.traceEventStart(v5_1, 0, v1_2, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)");
            }
            else {
                v18 = v3_5;
            }

            v3_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v18).ordinal()];
            if(v3_3 == 1) {
            label_366:
                v3_4 = v38;
            }
            else if(v3_3 != 2) {
                if(v3_3 == 3) {
                    goto label_366;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else if(v31 != 0) {
                v3_4 = 0f;
            }
            else {
                goto label_366;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v4.endReplaceGroup();
            int v23 = 0x30000;
            State v3_6 = TransitionKt.createTransitionAnimation(v16_1, v17_2, Float.valueOf(v3_4), ((Function3)v2_1).invoke(v16_1.getSegment(), v4, Integer.valueOf(0)), v20, "LabelProgress", v4, v23);
            Composer v2_2 = v4;
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            FiniteAnimationSpec v4_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v2_2, 6);
            TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 v5_4 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(v4_1, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, v2_2, 6));
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xB03404EB, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            v20 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xF77F2E11, v7_2);
            Object v1_3 = v16_1.getCurrentState();
            v6 = -1093194547;
            v2_2.startReplaceGroup(v6);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v17_1 = v1_3;
                v40 = v10_3;
                ComposerKt.traceEventStart(v6, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
            }
            else {
                v17_1 = v1_3;
                v40 = v10_3;
            }

            v1_2 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v17_1).ordinal()];
            if(v1_2 != 1) {
                if(v1_2 != 2) {
                    if(v1_2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                else if(v31 != 0) {
                }
                else {
                    goto label_429;
                }

                v1_4 = 0f;
            }
            else {
            label_429:
                v1_4 = v38;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            v17_2 = Float.valueOf(v1_4);
            v1_3 = v16_1.getTargetState();
            v2_2.startReplaceGroup(v6);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v6, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)");
            }

            v1_2 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v1_3).ordinal()];
            if(v1_2 != 1) {
                if(v1_2 != 2) {
                    if(v1_2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                else if(v31 != 0) {
                }
                else {
                    goto label_460;
                }

                v1_4 = 0f;
            }
            else {
            label_460:
                v1_4 = v38;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            State v10_4 = TransitionKt.createTransitionAnimation(v16_1, v17_2, Float.valueOf(v1_4), ((Function3)v5_4).invoke(v16_1.getSegment(), v2_2, Integer.valueOf(0)), v20, "PlaceholderOpacity", v2_2, v23);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 v1_5 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(v4_1);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xB03404EB, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            v20 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xF77F2E11, v7_2);
            Object v4_2 = v16_1.getCurrentState();
            v5_1 = 0xB4FD7EE7;
            v2_2.startReplaceGroup(v5_1);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5_1, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }

            int v4_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v4_2).ordinal()];
            if(v4_3 == 1) {
            label_511:
                v4_4 = v38;
            }
            else if(v4_3 != 2) {
                if(v4_3 == 3) {
                    goto label_511;
                }
                else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else if(v31 != 0) {
                v4_4 = 0f;
            }
            else {
                goto label_511;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            v17_2 = Float.valueOf(v4_4);
            v4_2 = v16_1.getTargetState();
            v2_2.startReplaceGroup(v5_1);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5_1, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
            }

            v4_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v4_2).ordinal()];
            if(v4_3 != 1) {
                if(v4_3 != 2) {
                    if(v4_3 == 3) {
                    }
                    else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                else if(v31 != 0) {
                    v38 = 0f;
                }
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            State v11_1 = TransitionKt.createTransitionAnimation(v16_1, v17_2, Float.valueOf(v38), ((Function3)v1_5).invoke(v16_1.getSegment(), v2_2, Integer.valueOf(0)), v20, "PrefixSuffixOpacity", v2_2, v23);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            FiniteAnimationSpec v1_6 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v2_2, 6);
            TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 v4_5 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(v1_6);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0x8C629A81, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            Object v5_5 = v16_1.getTargetState();
            v6 = 0xFF3A0AAE;
            v2_2.startReplaceGroup(v6);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v17_1 = v5_5;
                v31_1 = v13_2;
                ComposerKt.traceEventStart(v6, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            else {
                v17_1 = v5_5;
                v31_1 = v13_2;
            }

            long v17_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v17_1).ordinal()] == 1 ? v32 : v40;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            ColorSpace v5_6 = Color.getColorSpace-impl(v17_3);
            ComposerKt.sourceInformationMarkerStart(v2_2, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean v8_1 = v2_2.changed(v5_6);
            Object v13_3 = v2_2.rememberedValue();
            if((v8_1) || v13_3 == Composer.Companion.getEmpty()) {
                v13_3 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v5_6);
                v2_2.updateRememberedValue(v13_3);
            }

            Object v20_1 = v13_3;
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xF77F2E11, v7_2);
            v5_5 = v16_1.getCurrentState();
            v2_2.startReplaceGroup(v6);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v17_1 = v5_5;
                ComposerKt.traceEventStart(v6, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            else {
                v17_1 = v5_5;
            }

            v17_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v17_1).ordinal()] == 1 ? v32 : v40;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            Color v17_4 = Color.box-impl(v17_3);
            v5_5 = v16_1.getTargetState();
            v2_2.startReplaceGroup(v6);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v18 = v5_5;
                ComposerKt.traceEventStart(v6, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)");
            }
            else {
                v18 = v5_5;
            }

            if(WhenMappings.$EnumSwitchMapping$1[((InputPhase)v18).ordinal()] == 1) {
                v40 = v32;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            State v6_1 = TransitionKt.createTransitionAnimation(v16_1, v17_4, Color.box-impl(v40), ((Function3)v4_5).invoke(v16_1.getSegment(), v2_2, Integer.valueOf(0)), ((TwoWayConverter)v20_1), "LabelTextStyleColor", v2_2, v23);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 v4_6 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(v1_6);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0x8C629A81, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            v16_1.getTargetState();
            v1_2 = 0xE44C70A3;
            v2_2.startReplaceGroup(v1_2);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1_2, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            v5_6 = Color.getColorSpace-impl(v25);
            ComposerKt.sourceInformationMarkerStart(v2_2, 1918408359, "CC(remember):Transition.kt#9igjgp");
            v8_1 = v2_2.changed(v5_6);
            v13_3 = v2_2.rememberedValue();
            if((v8_1) || v13_3 == Composer.Companion.getEmpty()) {
                v13_3 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v5_6);
                v2_2.updateRememberedValue(v13_3);
            }

            v20_1 = v13_3;
            ComposerKt.sourceInformationMarkerEnd(v2_2);
            ComposerKt.sourceInformationMarkerStart(v2_2, 0xF77F2E11, v7_2);
            v16_1.getCurrentState();
            v2_2.startReplaceGroup(v1_2);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v1_2, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            v17_4 = Color.box-impl(v25);
            v16_1.getTargetState();
            v2_2.startReplaceGroup(v1_2);
            ComposerKt.sourceInformation(v2_2, v0_2);
            if(ComposerKt.isTraceInProgress()) {
                v13_4 = 0;
                ComposerKt.traceEventStart(v1_2, 0, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)");
            }
            else {
                v13_4 = 0;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2.endReplaceGroup();
            State v4_7 = TransitionKt.createTransitionAnimation(v16_1, v17_4, Color.box-impl(v25), ((Function3)v4_6).invoke(v16_1.getSegment(), v2_2, Integer.valueOf(v13_4)), ((TwoWayConverter)v20_1), "LabelContentColor", v2_2, v23);
            Composer v0_3 = v2_2;
            ComposerKt.sourceInformationMarkerEnd(v0_3);
            ComposerKt.sourceInformationMarkerEnd(v0_3);
            ComposerKt.sourceInformationMarkerStart(v0_3, 0x8F3D990F, "CN(labelProgress,labelTextStyleColor,labelContentColor,placeholderAlpha,prefixSuffixAlpha)130@5443L184,155@6570L107,172@7353L108:TextFieldImpl.kt#mqatfk");
            String v2_3 = "CC(remember):TextFieldImpl.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v0_3, 0x1D64FB6B, v2_3);
            v1_3 = v0_3.rememberedValue();
            if(v1_3 == Composer.Companion.getEmpty()) {
                v1_7 = new TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1(v3_6);
                v0_3.updateRememberedValue(v1_7);
            }

            Object v8_2 = v1_7;
            ComposerKt.sourceInformationMarkerEnd(v0_3);
            ComposableLambda v1_8 = null;
            v5_1 = 54;
            if(arg48 == null) {
                v0_3.startReplaceGroup(0x8F3E91C7);
                v0_3.endReplaceGroup();
                v13_5 = arg56;
                v14_1 = arg57;
                v9_1 = arg60;
                v15_1 = v0_3;
                v7_3 = v3_6;
                v17_5 = v10_4;
                v62 = v11_1;
                v4_8 = v30;
                v6_2 = v31_1;
                v12_1 = v35;
                v42 = v37;
                v11_2 = v2_3;
                v10_2 = v5_1;
            }
            else {
                v0_3.startReplaceGroup(0x8F3E91C8);
                ComposerKt.sourceInformation(v0_3, "*138@5746L526");
                v13_5 = arg56;
                v14_1 = arg57;
                v9_1 = arg60;
                v17_5 = v10_4;
                v62 = v11_1;
                v15_1 = v0_3;
                v12_1 = v35;
                v42 = v37;
                v11_2 = v2_3;
                v10_2 = v5_1;
                TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1 v0_4 = new TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1(v30, v31_1, v3_6, v4_7, v36, v6_1, arg48, ((TextFieldImplKt$CommonDecorationBox$3$labelScope$1$1)v8_2));
                v4_8 = v30;
                v6_2 = v31_1;
                v7_3 = v3_6;
                v1_8 = ComposableLambdaKt.rememberComposableLambda(-1076580032, true, v0_4, v15_1, v10_2);
                v15_1.endReplaceGroup();
            }

            ComposableLambda v8_3 = v1_8;
            long v2_4 = v9_1.placeholderColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x1D6587FE, v11_2);
            Object v0_5 = v15_1.rememberedValue();
            if(v0_5 == Composer.Companion.getEmpty()) {
                v5_7 = v17_5;
                v0_6 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TextFieldImplKt$$ExternalSyntheticLambda2(v5_7));
                v15_1.updateRememberedValue(v0_6);
            }
            else {
                v5_7 = v17_5;
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            if(arg49 == null || arg45.length() != 0 || !TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$8(v0_6)) {
                v15_1.startReplaceGroup(-1890217110);
                v15_1.endReplaceGroup();
                v17_6 = null;
            }
            else {
                v15_1.startReplaceGroup(0x8F4F83D8);
                ComposerKt.sourceInformation(v15_1, "160@6858L363");
                v1_8 = ComposableLambdaKt.rememberComposableLambda(1405547205, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1(v5_7, v2_4, v4_8, arg49), v15_1, v10_2);
                v15_1.endReplaceGroup();
                v17_6 = v1_8;
            }

            v2_4 = v9_1.prefixColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x1D65E9DF, v11_2);
            v0_5 = v15_1.rememberedValue();
            if(v0_5 == Composer.Companion.getEmpty()) {
                v5_7 = v62;
                v0_6 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new TextFieldImplKt$$ExternalSyntheticLambda3(v5_7));
                v15_1.updateRememberedValue(v0_6);
            }
            else {
                v5_7 = v62;
            }

            v18 = v0_6;
            ComposerKt.sourceInformationMarkerEnd(v15_1);
            if(arg52 == null || !TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$11(((State)v18))) {
                v1_9 = v5_7;
                v15_1.startReplaceGroup(0x8F60812A);
                v15_1.endReplaceGroup();
                v19 = null;
            }
            else {
                v15_1.startReplaceGroup(0x8F5AC06D);
                ComposerKt.sourceInformation(v15_1, "177@7601L342");
                v1_9 = v5_7;
                v0_7 = ComposableLambdaKt.rememberComposableLambda(0x2427E65F, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1(v1_9, v2_4, v4_8, arg52), v15_1, v10_2);
                v15_1.endReplaceGroup();
                v19 = v0_7;
            }

            v2_4 = v9_1.suffixColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            if(arg53 == null || !TextFieldImplKt.CommonDecorationBox$lambda$18$lambda$11(((State)v18))) {
                v15_1.startReplaceGroup(0x8F694C8A);
                v15_1.endReplaceGroup();
                v1_8 = null;
            }
            else {
                v15_1.startReplaceGroup(0x8F638BCD);
                ComposerKt.sourceInformation(v15_1, "191@8182L342");
                v1_8 = ComposableLambdaKt.rememberComposableLambda(0xFD50271E, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1(v1_9, v2_4, v4_8, arg53), v15_1, v10_2);
                v15_1.endReplaceGroup();
            }

            v2_4 = v9_1.leadingIconColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            if(arg50 == null) {
                v15_1.startReplaceGroup(0x8F6BF7A1);
                v15_1.endReplaceGroup();
                v0_7 = null;
            }
            else {
                v15_1.startReplaceGroup(0x8F6BF7A2);
                ComposerKt.sourceInformation(v15_1, "*205@8751L61");
                v0_7 = ComposableLambdaKt.rememberComposableLambda(0x98824391, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1(v2_4, arg50), v15_1, v10_2);
                v15_1.endReplaceGroup();
            }

            v2_4 = v9_1.trailingIconColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            if(arg51 == null) {
                v15_1.startReplaceGroup(0x8F703C80);
                v15_1.endReplaceGroup();
                v62_1 = v0_7;
                v5_8 = null;
            }
            else {
                v15_1.startReplaceGroup(0x8F703C81);
                ComposerKt.sourceInformation(v15_1, "*211@9033L62");
                v62_1 = v0_7;
                v0_7 = ComposableLambdaKt.rememberComposableLambda(0x4F8B22F9, true, new TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1(v2_4, arg51), v15_1, 54);
                v15_1.endReplaceGroup();
                ComposableLambda v5_9 = v0_7;
            }

            v2_4 = v9_1.supportingTextColor-XeAY9LY$material3(v13_5, v14_1, v12_1);
            if(arg54 == null) {
                v15_1.startReplaceGroup(0x8F74B704);
                v15_1.endReplaceGroup();
                v0_7 = null;
                v6 = 1;
            }
            else {
                v15_1.startReplaceGroup(0x8F74B705);
                ComposerKt.sourceInformation(v15_1, "*217@9324L218");
                TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1 v0_8 = new TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1(v2_4, v6_2, arg54);
                v6 = 1;
                v0_7 = ComposableLambdaKt.rememberComposableLambda(0x31E62E50, true, v0_8, v15_1, 54);
                v15_1.endReplaceGroup();
            }

            int v2_5 = WhenMappings.$EnumSwitchMapping$0[arg44.ordinal()];
            if(v2_5 != v6) {
                v3_3 = 2;
                if(v2_5 == v3_3) {
                    v15_1.startReplaceGroup(0x8F8A0CB6);
                    ComposerKt.sourceInformation(v15_1, "253@10710L38,254@10817L517,279@11893L667,268@11352L1443");
                    ComposerKt.sourceInformationMarkerStart(v15_1, 0x1D678D39, v11_2);
                    Object v2_6 = v15_1.rememberedValue();
                    if(v2_6 == Composer.Companion.getEmpty()) {
                        v2_7 = SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), null, v3_3, null);
                        v15_1.updateRememberedValue(v2_7);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v15_1);
                    TextFieldLabelPosition v6_3 = arg47;
                    PaddingValues v14_2 = arg59;
                    ComposableLambda v16_2 = v0_7;
                    ComposableLambda v20_2 = v1_8;
                    v0_7 = ComposableLambdaKt.rememberComposableLambda(0x1F7A6892, true, new TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1(v2_7, v6_3, v14_2, arg61), v15_1, 54);
                    Companion v1_10 = Modifier.Companion;
                    TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 v4_9 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new TextFieldImplKt$CommonDecorationBox$3$2(v7_3));
                    ComposerKt.sourceInformationMarkerStart(v15_1, 493364110, v11_2);
                    v3_3 = v42;
                    ComposableLambda v18_1 = v0_7;
                    int v27 = (v3_3 & 0x1C00) == 0x800 ? 1 : 0;
                    int v0_9 = v27 | v15_1.changed(v7_3);
                    Object v11_3 = v15_1.rememberedValue();
                    if(v0_9 != 0 || v11_3 == Composer.Companion.getEmpty()) {
                        v11_4 = new TextFieldImplKt$$ExternalSyntheticLambda4(v6_3, v7_3, v2_7);
                        v15_1.updateRememberedValue(v11_4);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v15_1);
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(v1_10, arg46, v17_6, v8_3, v62_1, v5_8, v19, v20_2, arg55, v6_3, v4_9, ((Function1)v11_4), v18_1, v16_2, v14_2, v15_1, v3_3 >> 3 & 0x70 | 6 | v28 << 21 & 0xE000000 | v3_3 << 18 & 0x70000000, 0xE000 & v28 >> 3 | 0x180);
                    v15_1.endReplaceGroup();
                    v22 = v15_1;
                }
                else {
                    v15_1.startReplaceGroup(0x1D670AC8);
                    v15_1.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
            }
            else {
                v15_1.startReplaceGroup(0x8F79FD56);
                ComposerKt.sourceInformation(v15_1, "228@9680L167,234@9865L722");
                TextFieldKt.TextFieldLayout(Modifier.Companion, arg46, v8_3, v17_6, v62_1, v5_8, v19, v1_8, arg55, arg47, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(new TextFieldImplKt$CommonDecorationBox$3$1(v7_3)), ComposableLambdaKt.rememberComposableLambda(0x98E47575, true, new TextFieldImplKt$CommonDecorationBox$3$containerWithId$1(arg61), v15_1, 54), v0_7, arg59, v15_1, v42 >> 3 & 0x70 | 6 | v28 << 21 & 0xE000000 | v42 << 18 & 0x70000000, v28 >> 6 & 0x1C00 | 0x30);
                v22 = v15_1;
                v22.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v22);
            ComposerKt.sourceInformationMarkerEnd(v22);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_1147;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v22 = v4;
            v22.skipToGroupEnd();
        }

    label_1147:
        ScopeUpdateScope v0_10 = v22.endRestartGroup();
        if(v0_10 != null) {
            v0_10.updateScope(new TextFieldImplKt$$ExternalSyntheticLambda5(arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg51, arg52, arg53, arg54, arg55, arg56, arg57, arg58, arg59, arg60, arg61, arg63, arg64));
        }
    }

    static final boolean CommonDecorationBox$lambda$18$lambda$10$lambda$9(State arg1) {
        if(arg1.getValue().floatValue() > 0f) {
            return 1;
        }

        return 0;
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$11(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit CommonDecorationBox$lambda$18$lambda$17$lambda$16(TextFieldLabelPosition arg7, State arg8, MutableState arg9, Size arg10) {
        if((arg7 instanceof Above)) {
            return Unit.INSTANCE;
        }

        float v7 = arg8.getValue().floatValue();
        int v8 = 0x20;
        float v0 = Float.intBitsToFloat(((int)(arg10.unbox-impl() >> v8))) * v7;
        long v3 = 0xFFFFFFFFL;
        float v10 = Float.intBitsToFloat(((int)(arg10.unbox-impl() & v3))) * v7;
        if(Float.intBitsToFloat(((int)(arg9.getValue().unbox-impl() >> v8))) != v0 || Float.intBitsToFloat(((int)(arg9.getValue().unbox-impl() & v3))) != v10) {
            arg9.setValue(Size.box-impl(Size.constructor-impl((((long)Float.floatToRawIntBits(v0))) << v8 | (((long)Float.floatToRawIntBits(v10))) & v3)));
        }
        else {
        }

        return Unit.INSTANCE;
    }

    static final boolean CommonDecorationBox$lambda$18$lambda$7$lambda$6(State arg1) {
        if(arg1.getValue().floatValue() > 0f) {
            return 1;
        }

        return 0;
    }

    private static final boolean CommonDecorationBox$lambda$18$lambda$8(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit CommonDecorationBox$lambda$19(TextFieldType arg22, CharSequence arg23, Function2 arg24, TextFieldLabelPosition arg25, Function3 arg26, Function2 arg27, Function2 arg28, Function2 arg29, Function2 arg30, Function2 arg31, Function2 arg32, boolean arg33, boolean arg34, boolean arg35, InteractionSource arg36, PaddingValues arg37, TextFieldColors arg38, Function2 arg39, int arg40, int arg41, Composer arg42, int arg43) {
        TextFieldImplKt.CommonDecorationBox(arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg42, RecomposeScopeImplKt.updateChangedFlags(arg40 | 1), RecomposeScopeImplKt.updateChangedFlags(arg41));
        return Unit.INSTANCE;
    }

    private static final void Decoration-3J-VO9M(long arg7, TextStyle arg9, Function2 arg10, Composer arg11, int arg12) {
        Function2 v11_1;
        TextStyle v10;
        long v8;
        int v1;
        int v11;
        int v0 = 0x17A3CFF9;
        Composer v5 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(v5, "C(Decoration)N(contentColor:c#ui.graphics.Color,textStyle,content)325@13794L62:TextFieldImpl.kt#mqatfk");
        if((arg12 & 6) == 0) {
            v11 = v5.changed(arg7) ? 4 : 2;
            v11 |= arg12;
        }
        else {
            v11 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v1 = v5.changed(arg9) ? 0x20 : 16;
            v11 |= v1;
        }

        if((arg12 & 0x180) == 0) {
            v1 = v5.changedInstance(arg10) ? 0x100 : 0x80;
            v11 |= v1;
        }

        boolean v1_1 = (v11 & 0x93) != 0x92 ? true : false;
        if(v5.shouldExecute(v1_1, v11 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v11, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:325)");
            }

            TextStyle v3 = arg9;
            Function2 v4 = arg10;
            ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(arg7, v3, v4, v5, v11 & 0x3FE);
            v8 = arg7;
            v10 = v3;
            v11_1 = v4;
            if(!ComposerKt.isTraceInProgress()) {
                goto label_60;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v11_1 = arg10;
            v10 = arg9;
            v8 = arg7;
            v5.skipToGroupEnd();
        }

    label_60:
        ScopeUpdateScope v0_1 = v5.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new TextFieldImplKt$$ExternalSyntheticLambda10(v8, v10, v11_1, arg12));
        }
    }

    private static final void Decoration-Iv8Zu3U(long arg4, Function2 arg6, Composer arg7, int arg8) {
        int v1;
        int v0 = 590397809;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(Decoration)N(contentColor:c#ui.graphics.Color,content)330@14001L84:TextFieldImpl.kt#mqatfk");
        if((arg8 & 6) == 0) {
            v1 = arg7.changed(arg4) ? 4 : 2;
            v1 |= arg8;
        }
        else {
            v1 = arg8;
        }

        if((arg8 & 0x30) == 0) {
            int v2 = arg7.changedInstance(arg6) ? 0x20 : 16;
            v1 |= v2;
        }

        boolean v2_1 = (v1 & 19) != 18 ? true : false;
        if(arg7.shouldExecute(v2_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.internal.Decoration (TextFieldImpl.kt:330)");
            }

            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(arg4)), arg6, arg7, v1 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_48;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_48:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new TextFieldImplKt$$ExternalSyntheticLambda1(arg4, arg6, arg8));
        }
    }

    static final Unit Decoration_3J_VO9M$lambda$20(long arg6, TextStyle arg8, Function2 arg9, int arg10, Composer arg11, int arg12) {
        TextFieldImplKt.Decoration-3J-VO9M(arg6, arg8, arg9, arg11, RecomposeScopeImplKt.updateChangedFlags(arg10 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Decoration_Iv8Zu3U$lambda$21(long arg0, Function2 arg2, int arg3, Composer arg4, int arg5) {
        TextFieldImplKt.Decoration-Iv8Zu3U(arg0, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    private static final void TextFieldTransitionScope-Jy8F4Js(InputPhase arg25, long arg26, long arg28, long arg30, boolean arg32, Function7 arg33, Composer arg34, int arg35) {
        float v2_4;
        float v5_1;
        float v3_1;
        float v1_2;
        Composer v6 = arg34;
        ComposerKt.sourceInformationMarkerStart(v6, 0x80E48A8B, "CC(TextFieldTransitionScope)N(inputState,focusedLabelTextStyleColor:c#ui.graphics.Color,unfocusedLabelTextStyleColor:c#ui.graphics.Color,labelColor:c#ui.graphics.Color,showExpandedLabel,content)385@16247L59,388@16444L14,390@16502L300,398@16874L14,399@16959L14,401@17022L830,424@17903L347,435@18316L14,437@18380L288,449@18771L167,455@18944L150:TextFieldImpl.kt#mqatfk");
        Integer v9 = Integer.valueOf(0);
        Transition v0 = TransitionKt.updateTransition(arg25, "TextFieldInputState", v6, arg35 & 14 | 0x30, 0);
        TextFieldImplKt$TextFieldTransitionScope$labelProgress$1 v2 = new TextFieldImplKt$TextFieldTransitionScope$labelProgress$1(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v6, 6));
        String v12 = "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli";
        ComposerKt.sourceInformationMarkerStart(v6, 0xB03404EB, v12);
        TwoWayConverter v4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        String v14 = "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli";
        ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v14);
        Object v1 = v0.getCurrentState();
        int v3 = -1436405362;
        v6.startReplaceGroup(v3);
        String v15 = "CN(it):TextFieldImpl.kt#mqatfk";
        ComposerKt.sourceInformation(v6, v15);
        String v7 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:391)";
        int v13 = -1;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v7);
        }

        int v1_1 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v1).ordinal()];
        int v5 = 3;
        int v11 = 2;
        float v17 = 0f;
        float v18 = 1f;
        if(v1_1 == 1) {
        label_52:
            v1_2 = v18;
        }
        else if(v1_1 != v11) {
            if(v1_1 == v5) {
                goto label_52;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        else if(arg32) {
            v1_2 = 0f;
        }
        else {
            goto label_52;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Float v1_3 = Float.valueOf(v1_2);
        Object v19 = v0.getTargetState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v7);
        }

        v3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v19).ordinal()];
        if(v3 == 1) {
        label_77:
            v3_1 = v18;
        }
        else if(v3 != v11) {
            if(v3 == v5) {
                goto label_77;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        else if(arg32) {
            v3_1 = 0f;
        }
        else {
            goto label_77;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        State v19_1 = TransitionKt.createTransitionAnimation(v0, v1_3, Float.valueOf(v3_1), ((Function3)v2).invoke(v0.getSegment(), v6, v9), v4, "LabelProgress", v6, 0x30000);
        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerEnd(v6);
        FiniteAnimationSpec v1_4 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v6, 6);
        TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 v2_1 = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1(v1_4, MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, v6, 6));
        ComposerKt.sourceInformationMarkerStart(v6, 0xB03404EB, v12);
        v4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v14);
        Object v3_2 = v0.getCurrentState();
        v5 = -1093194547;
        v6.startReplaceGroup(v5);
        ComposerKt.sourceInformation(v6, v15);
        v7 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:416)";
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, 0, v13, v7);
        }

        v3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v3_2).ordinal()];
        if(v3 != 1) {
            if(v3 != v11) {
                v11 = 3;
                if(v3 != v11) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else {
                v11 = 3;
                if(arg32) {
                }
                else {
                    goto label_132;
                }
            }

            v3_1 = 0f;
        }
        else {
            v11 = 3;
        label_132:
            v3_1 = v18;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Float v3_3 = Float.valueOf(v3_1);
        Object v21 = v0.getTargetState();
        v6.startReplaceGroup(v5);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, 0, v13, v7);
        }

        v5 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v21).ordinal()];
        if(v5 != 1) {
            if(v5 != 2) {
                if(v5 != v11) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            else if(arg32) {
            }
            else {
                goto label_158;
            }

            v5_1 = 0f;
        }
        else {
        label_158:
            v5_1 = v18;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        int v7_1 = 0x30000;
        State v22 = TransitionKt.createTransitionAnimation(v0, v3_3, Float.valueOf(v5_1), ((Function3)v2_1).invoke(v0.getSegment(), v6, v9), v4, "PlaceholderOpacity", v6, v7_1);
        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerEnd(v6);
        TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1 v1_5 = new TextFieldImplKt$TextFieldTransitionScope$prefixSuffixOpacity$1(v1_4);
        ComposerKt.sourceInformationMarkerStart(v6, 0xB03404EB, v12);
        v4 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v14);
        Object v2_2 = v0.getCurrentState();
        v3 = 0xB4FD7EE7;
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
        }

        int v2_3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v2_2).ordinal()];
        if(v2_3 == 1) {
        label_207:
            v2_4 = v18;
        }
        else if(v2_3 != 2) {
            if(v2_3 == 3) {
                goto label_207;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        else if(arg32) {
            v2_4 = 0f;
        }
        else {
            goto label_207;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Float v2_5 = Float.valueOf(v2_4);
        Object v5_2 = v0.getTargetState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:428)");
        }

        v3 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v5_2).ordinal()];
        if(v3 == 1) {
        label_234:
            v17 = v18;
        }
        else if(v3 != 2) {
            if(v3 == 3) {
                goto label_234;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }
        else if(arg32) {
        }
        else {
            goto label_234;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        State v11_1 = TransitionKt.createTransitionAnimation(v0, v2_5, Float.valueOf(v17), ((Function3)v1_5).invoke(v0.getSegment(), v6, v9), v4, "PrefixSuffixOpacity", v6, v7_1);
        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerEnd(v6);
        FiniteAnimationSpec v12_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v6, 6);
        TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1 v1_6 = new TextFieldImplKt$TextFieldTransitionScope$labelTextStyleColor$1(v12_1);
        ComposerKt.sourceInformationMarkerStart(v6, 0x8C629A81, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        v2_2 = v0.getTargetState();
        v3 = 0xFF3A0AAE;
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        String v5_3 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:441)";
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        long v16 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v2_2).ordinal()] == 1 ? arg26 : arg28;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        ColorSpace v2_6 = Color.getColorSpace-impl(v16);
        ComposerKt.sourceInformationMarkerStart(v6, 1918408359, "CC(remember):Transition.kt#9igjgp");
        boolean v4_1 = v6.changed(v2_6);
        Object v7_2 = v6.rememberedValue();
        if((v4_1) || v7_2 == Composer.Companion.getEmpty()) {
            v7_2 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v2_6);
            v6.updateRememberedValue(v7_2);
        }

        Object v4_2 = v7_2;
        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v14);
        v2_2 = v0.getCurrentState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        v16 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v2_2).ordinal()] == 1 ? arg26 : arg28;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Color v2_7 = Color.box-impl(v16);
        v7_2 = v0.getTargetState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        v16 = WhenMappings.$EnumSwitchMapping$1[((InputPhase)v7_2).ordinal()] == 1 ? arg26 : arg28;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Color v7_3 = Color.box-impl(v16);
        v3_2 = ((Function3)v1_6).invoke(v0.getSegment(), v6, v9);
        Color v1_7 = v2_7;
        v2_7 = v7_3;
        v7_1 = 0x30000;
        State v1_8 = TransitionKt.createTransitionAnimation(v0, v1_7, v2_7, ((FiniteAnimationSpec)v3_2), ((TwoWayConverter)v4_2), "LabelTextStyleColor", v6, v7_1);
        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerEnd(v6);
        TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1 v2_8 = new TextFieldImplKt$TextFieldTransitionScope$labelContentColor$1(v12_1);
        ComposerKt.sourceInformationMarkerStart(v6, 0x8C629A81, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
        v0.getTargetState();
        v3 = 0xE44C70A3;
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        v5_3 = "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:452)";
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        ColorSpace v4_3 = Color.getColorSpace-impl(arg30);
        ComposerKt.sourceInformationMarkerStart(v6, 1918408359, "CC(remember):Transition.kt#9igjgp");
        boolean v10 = v6.changed(v4_3);
        Object v12_2 = v6.rememberedValue();
        if((v10) || v12_2 == Composer.Companion.getEmpty()) {
            v12_2 = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(v4_3);
            v6.updateRememberedValue(v12_2);
        }

        ComposerKt.sourceInformationMarkerEnd(v6);
        ComposerKt.sourceInformationMarkerStart(v6, 0xF77F2E11, v14);
        v0.getCurrentState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        Color v4_4 = Color.box-impl(arg30);
        v0.getTargetState();
        v6.startReplaceGroup(v3);
        ComposerKt.sourceInformation(v6, v15);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, 0, v13, v5_3);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        v6.endReplaceGroup();
        State v0_1 = TransitionKt.createTransitionAnimation(v0, v4_4, Color.box-impl(arg30), ((Function3)v2_8).invoke(v0.getSegment(), v6, v9), v12_2, "LabelContentColor", v6, v7_1);
        ComposerKt.sourceInformationMarkerEnd(arg34);
        ComposerKt.sourceInformationMarkerEnd(arg34);
        arg33.invoke(v19_1, v1_8, v0_1, v22, v11_1, arg34, Integer.valueOf(arg35 & 0x70000));
        ComposerKt.sourceInformationMarkerEnd(arg34);
    }

    public static final void access$Decoration-3J-VO9M(long arg0, TextStyle arg2, Function2 arg3, Composer arg4, int arg5) {
        TextFieldImplKt.Decoration-3J-VO9M(arg0, arg2, arg3, arg4, arg5);
    }

    public static final void access$Decoration-Iv8Zu3U(long arg0, Function2 arg2, Composer arg3, int arg4) {
        TextFieldImplKt.Decoration-Iv8Zu3U(arg0, arg2, arg3, arg4);
    }

    public static final State animateBorderStrokeAsState-NuRrP5Q(boolean arg11, boolean arg12, boolean arg13, TextFieldColors arg14, float arg15, float arg16, Composer arg17, int arg18) {
        State v11_1;
        State v12_1;
        Composer v4 = arg17;
        int v8 = arg18;
        int v1 = 0x7A02F0B5;
        ComposerKt.sourceInformationMarkerStart(v4, v1, "C(animateBorderStrokeAsState)N(enabled,isError,focused,colors,focusedBorderThickness:c#ui.unit.Dp,unfocusedBorderThickness:c#ui.unit.Dp)475@19543L14,483@19812L11,492@20135L73:TextFieldImpl.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, v8, -1, "androidx.compose.material3.internal.animateBorderStrokeAsState (TextFieldImpl.kt:472)");
        }

        long v0 = arg14.indicatorColor-XeAY9LY$material3(arg11, arg12, arg13);
        int v9 = 6;
        FiniteAnimationSpec v12 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, v4, v9);
        if(arg11) {
            v4.startReplaceGroup(0x9C310921);
            ComposerKt.sourceInformation(v4, "478@19618L52");
            v12_1 = SingleValueAnimationKt.animateColorAsState-euL9pac(v0, v12, null, null, arg17, 0, 12);
            v4 = arg17;
            v4.endReplaceGroup();
        }
        else {
            v4.startReplaceGroup(0x9C324494);
            ComposerKt.sourceInformation(v4, "480@19700L33");
            v12_1 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(v0), v4, 0);
            v4.endReplaceGroup();
        }

        FiniteAnimationSpec v0_1 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, v4, v9);
        if(arg11) {
            v4.startReplaceGroup(0x9C350938);
            ComposerKt.sourceInformation(v4, "487@19979L57");
            FiniteAnimationSpec v11 = v0_1;
            float v0_2 = arg13 ? arg15 : arg16;
            v11_1 = AnimateAsStateKt.animateDpAsState-AjpBEmI(v0_2, v11, null, null, v4, 0, 12);
            v4.endReplaceGroup();
        }
        else {
            v4.startReplaceGroup(0x9C37D067);
            ComposerKt.sourceInformation(v4, "489@20066L46");
            v11_1 = SnapshotStateKt.rememberUpdatedState(Dp.box-impl(arg16), v4, v8 >> 15 & 14);
            v4.endReplaceGroup();
        }

        v11_1 = SnapshotStateKt.rememberUpdatedState(BorderStrokeKt.BorderStroke-cXLIe8U(v11_1.getValue().unbox-impl(), v12_1.getValue().unbox-impl()), v4, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v4);
        return v11_1;
    }

    public static final Modifier defaultErrorSemantics(Modifier arg2, boolean arg3, String arg4) {
        if(arg3) {
            arg2 = SemanticsModifierKt.semantics$default(arg2, false, new TextFieldImplKt$$ExternalSyntheticLambda7(arg4), 1, null);
        }

        return arg2;
    }

    static final Unit defaultErrorSemantics$lambda$22(String arg0, SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.error(arg1, arg0);
        return Unit.INSTANCE;
    }

    public static final float getAboveLabelBottomPadding() {
        return TextFieldImplKt.AboveLabelBottomPadding;
    }

    public static final float getAboveLabelHorizontalPadding() {
        return TextFieldImplKt.AboveLabelHorizontalPadding;
    }

    public static final Horizontal getExpandedAlignment(TextFieldLabelPosition arg3) {
        if((arg3 instanceof Above)) {
            return ((Above)arg3).getAlignment();
        }

        if((arg3 instanceof Attached)) {
            return ((Attached)arg3).getExpandedAlignment();
        }

        throw new IllegalArgumentException("Unknown position: " + arg3);
    }

    public static final float getMinFocusedLabelLineHeight() {
        return TextFieldImplKt.MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return TextFieldImplKt.MinSupportingTextLineHeight;
    }

    public static final float getMinTextLineHeight() {
        return TextFieldImplKt.MinTextLineHeight;
    }

    public static final Horizontal getMinimizedAlignment(TextFieldLabelPosition arg3) {
        if((arg3 instanceof Above)) {
            return ((Above)arg3).getAlignment();
        }

        if((arg3 instanceof Attached)) {
            return ((Attached)arg3).getMinimizedAlignment();
        }

        throw new IllegalArgumentException("Unknown position: " + arg3);
    }

    public static final float getPrefixSuffixTextPadding() {
        return TextFieldImplKt.PrefixSuffixTextPadding;
    }

    private static final boolean getShowExpandedLabel(TextFieldLabelPosition arg1) {
        if(((arg1 instanceof Attached)) && !((Attached)arg1).getAlwaysMinimize()) {
            return 1;
        }

        return 0;
    }

    public static final float getSupportingTopPadding() {
        return TextFieldImplKt.SupportingTopPadding;
    }

    public static final float getTextFieldPadding() {
        return TextFieldImplKt.TextFieldPadding;
    }

    public static final float minimizedLabelHalfHeight(Composer arg4, int arg5) {
        int v1 = 0x4A99107F;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(minimizedLabelHalfHeight)528@21499L10,531@21709L7:TextFieldImpl.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.internal.minimizedLabelHalfHeight (TextFieldImpl.kt:527)");
        }

        long v0 = MaterialTheme.INSTANCE.getTypography(arg4, 6).getBodySmall().getLineHeight-XSAIIZE();
        long v2 = TypeScaleTokens.INSTANCE.getBodySmallLineHeight-XSAIIZE();
        if(TextUnit.isSp-impl(v0)) {
        }
        else {
            v0 = v2;
        }

        ProvidableCompositionLocal v5 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(arg4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v5_1 = arg4.consume(((CompositionLocal)v5));
        ComposerKt.sourceInformationMarkerEnd(arg4);
        float v5_2 = Dp.constructor-impl(((Density)v5_1).toDp-GaN1DYA(v0) / 2f);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v5_2;
    }

    public static final Modifier textFieldBackground(Modifier arg1, ColorProducer arg2, Shape arg3) {
        return DrawModifierKt.drawWithCache(arg1, new TextFieldImplKt$$ExternalSyntheticLambda9(arg3, arg2));
    }

    static final DrawResult textFieldBackground$lambda$24(Shape arg4, ColorProducer arg5, CacheDrawScope arg6) {
        return arg6.onDrawBehind(new TextFieldImplKt$$ExternalSyntheticLambda8(arg4.createOutline-Pq9zytI(arg6.getSize-NH-jbRc(), arg6.getLayoutDirection(), arg6), arg5));
    }

    static final Unit textFieldBackground$lambda$24$lambda$23(Outline arg10, ColorProducer arg11, DrawScope arg12) {
        OutlineKt.drawOutline-wDX37Ww$default(arg12, arg10, arg11.invoke-0d7_KjU(), 0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final float textFieldHorizontalIconPadding(Composer arg3, int arg4) {
        int v1 = 1986450462;
        ComposerKt.sourceInformationMarkerStart(arg3, v1, "C(textFieldHorizontalIconPadding)521@21199L7:TextFieldImpl.kt#mqatfk");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg4, -1, "androidx.compose.material3.internal.textFieldHorizontalIconPadding (TextFieldImpl.kt:520)");
        }

        ProvidableCompositionLocal v4 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
        ComposerKt.sourceInformationMarkerStart(arg3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object v4_1 = arg3.consume(((CompositionLocal)v4));
        ComposerKt.sourceInformationMarkerEnd(arg3);
        float v4_2 = ((Dp)v4_1).unbox-impl();
        if(Float.isNaN(v4_2)) {
            v4_2 = Dp.constructor-impl(0f);
        }

        v4_2 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(v4_2 - SmallIconButtonTokens.INSTANCE.getIconSize-D9Ej5fM()) / 2f), Dp.constructor-impl(0f)));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v4_2;
    }

    public static final Modifier textFieldLabelMinHeight(Modifier arg1, Function0 arg2) {
        return LayoutModifierKt.layout(arg1, new TextFieldImplKt$$ExternalSyntheticLambda6(arg2));
    }

    static final MeasureResult textFieldLabelMinHeight$lambda$26(Function0 arg10, MeasureScope arg11, Measurable arg12, Constraints arg13) {
        float v10 = arg10.invoke().unbox-impl();
        long v0 = arg13.unbox-impl();
        int v10_1 = !Dp.equals-impl0(v10, Dp.Companion.getUnspecified-D9Ej5fM()) ? arg11.roundToPx-0680j_4(v10) : 0;
        Placeable v10_2 = arg12.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg13.unbox-impl(), 0, 0, ConstraintsKt.constrainHeight-K40F9xA(v0, v10_1), 0, 11, null));
        return MeasureScope.layout$default(arg11, v10_2.getWidth(), v10_2.getHeight(), null, new TextFieldImplKt$$ExternalSyntheticLambda0(v10_2), 4, null);
    }

    static final Unit textFieldLabelMinHeight$lambda$26$lambda$25(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }
}

