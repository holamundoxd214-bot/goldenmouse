package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits$SingleLine;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1={"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020!2\b\b\u0002\u0010\"\u001A\u00020!2\u000E\b\u0002\u0010#\u001A\b\u0012\u0004\u0012\u00020%0$2\u000E\b\u0002\u0010&\u001A\b\u0012\u0004\u0012\u00020!0\'2\u000E\b\u0002\u0010(\u001A\b\u0012\u0004\u0012\u00020!0)2\b\b\u0002\u0010*\u001A\u00020%H\u0007¢\u0006\u0002\u0010+J-\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020/2\b\b\u0002\u00100\u001A\u00020/2\b\b\u0002\u00101\u001A\u000202H\u0007¢\u0006\u0004\b3\u00104Jõ\u0001\u00101\u001A\u0002022\b\b\u0002\u00105\u001A\u00020/2\b\b\u0002\u00106\u001A\u00020/2\b\b\u0002\u00107\u001A\u00020/2\b\b\u0002\u00108\u001A\u00020/2\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020/2\b\b\u0002\u0010<\u001A\u00020/2\b\b\u0002\u0010=\u001A\u00020/2\b\b\u0002\u0010>\u001A\u00020/2\b\b\u0002\u0010?\u001A\u00020/2\b\b\u0002\u0010@\u001A\u00020/2\b\b\u0002\u0010A\u001A\u00020/2\b\b\u0002\u0010B\u001A\u00020/2\b\b\u0002\u0010C\u001A\u00020/2\b\b\u0002\u0010D\u001A\u00020/2\b\b\u0002\u0010E\u001A\u00020/2\b\b\u0002\u0010F\u001A\u00020/2\b\b\u0002\u0010G\u001A\u00020/2\b\b\u0002\u0010H\u001A\u00020/2\b\b\u0002\u0010I\u001A\u00020/2\b\b\u0002\u0010J\u001A\u00020/2\b\b\u0002\u0010K\u001A\u00020/2\b\b\u0002\u0010L\u001A\u00020/H\u0007¢\u0006\u0004\bM\u0010NJ\u008E\u0002\u0010O\u001A\u00020P2\u0006\u0010Q\u001A\u00020R2\u0006\u0010S\u001A\u00020T2\u0012\u0010U\u001A\u000E\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001A\u00020Y2\b\b\u0002\u0010Z\u001A\u00020%2\b\b\u0002\u0010[\u001A\u00020%2\b\b\u0002\u0010\\\u001A\u00020]2\u0015\b\u0002\u0010^\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001A\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001A\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001A\u00020i2\b\b\u0002\u0010j\u001A\u00020\u00112\b\b\u0002\u0010,\u001A\u0002022\n\b\u0002\u0010k\u001A\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010mJ¢\u0002\u0010O\u001A\u00020P2\u0006\u0010n\u001A\u00020R2\u0012\u0010U\u001A\u000E\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001A\u00020%2\u0012\u0010p\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001A\u00020Y2\b\b\u0002\u0010Z\u001A\u00020%2\b\b\u0002\u0010[\u001A\u00020%2\b\b\u0002\u0010\\\u001A\u00020]2\u0015\b\u0002\u0010^\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001A\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001A\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001A\u00020i2\b\b\u0002\u0010j\u001A\u00020\u00112\b\b\u0002\u0010,\u001A\u0002022\n\b\u0002\u0010k\u001A\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010qJÈ\u0001\u0010O\u001A\u00020P2\u0006\u0010r\u001A\u00020W2\u0012\u0010s\u001A\u000E\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0012\u0010U\u001A\u000E\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001A\u00020%2\u0012\u0010p\u001A\u000E\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001A\u00020Y2\b\b\u0002\u0010Z\u001A\u00020%2\u0015\b\u0002\u0010^\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001A\u000F\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\b\b\u0002\u0010,\u001A\u0002022\n\b\u0002\u0010k\u001A\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010tJ#\u0010,\u001A\u00020-2\b\b\u0002\u0010.\u001A\u00020/2\b\b\u0002\u00100\u001A\u00020/H\u0007¢\u0006\u0004\bu\u0010vJ\u009B\u0001\u00101\u001A\u0002022\b\b\u0002\u00105\u001A\u00020/2\b\b\u0002\u00106\u001A\u00020/2\b\b\u0002\u00107\u001A\u00020/2\b\b\u0002\u00108\u001A\u00020/2\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020/2\b\b\u0002\u0010<\u001A\u00020/2\b\b\u0002\u0010=\u001A\u00020/2\b\b\u0002\u0010>\u001A\u00020/2\b\b\u0002\u0010?\u001A\u00020/2\b\b\u0002\u0010@\u001A\u00020/2\b\b\u0002\u0010A\u001A\u00020/2\b\b\u0002\u0010B\u001A\u00020/2\b\b\u0002\u0010C\u001A\u00020/H\u0007¢\u0006\u0004\bw\u0010xJ\u0087\u0001\u00101\u001A\u0002022\b\b\u0002\u0010y\u001A\u00020/2\b\b\u0002\u00107\u001A\u00020/2\b\b\u0002\u00108\u001A\u00020/2\b\b\u0002\u00109\u001A\u00020:2\b\b\u0002\u0010;\u001A\u00020/2\b\b\u0002\u0010<\u001A\u00020/2\b\b\u0002\u0010=\u001A\u00020/2\b\b\u0002\u0010>\u001A\u00020/2\b\b\u0002\u0010?\u001A\u00020/2\b\b\u0002\u0010@\u001A\u00020/2\b\b\u0002\u0010z\u001A\u00020/2\b\b\u0002\u0010C\u001A\u00020/H\u0007¢\u0006\u0004\b{\u0010|R\u0013\u0010\u0004\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\n\u0010\u0007R\u001E\u0010\u000B\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001A\u0004\b\r\u0010\u0007R\u0013\u0010\u000E\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u000F\u0010\u0007R\u0011\u0010\u0010\u001A\u00020\u00118G¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00118G¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u00118G¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001A\u00020\u00198G¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u001C\u001A\u00020\u00198G¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001B¨\u0006}²\u0006\n\u0010~\u001A\u00020%X\u008A\u0084\u0002"}, d2={"Landroidx/compose/material3/SearchBarDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "inputFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getInputFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "dockedShape", "getDockedShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "fullScreenWindowInsets", "getFullScreenWindowInsets", "enterAlwaysSearchBarScrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "reverseLayout", "(FFLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarScrollBehavior;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "inputFieldColors-JVEmHcM", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "InputField", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "searchBarState", "Landroidx/compose/material3/SearchBarState;", "onSearch", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "placeholder", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "prefix", "suffix", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "state", "expanded", "onExpandedChange", "(Landroidx/compose/foundation/text/input/TextFieldState;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "query", "onQueryChange", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "textColor", "placeholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3", "focused"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SearchBarDefaults {
    public static final int $stable;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE;
    private static final float InputFieldHeight;
    private static final float ShadowElevation;
    private static final float TonalElevation;

    static {
        SearchBarDefaults.INSTANCE = new SearchBarDefaults();
        float v0 = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        SearchBarDefaults.TonalElevation = v0;
        SearchBarDefaults.ShadowElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        SearchBarDefaults.Elevation = v0;
        SearchBarDefaults.InputFieldHeight = SearchBarTokens.INSTANCE.getContainerHeight-D9Ej5fM();
    }

    private SearchBarDefaults() {
        super();
    }

    public final void InputField(TextFieldState arg117, SearchBarState arg118, Function1 arg119, Modifier arg120, boolean arg121, boolean arg122, TextStyle arg123, Function2 arg124, Function2 arg125, Function2 arg126, Function2 arg127, Function2 arg128, InputTransformation arg129, OutputTransformation arg130, ScrollState arg131, Shape arg132, TextFieldColors arg133, MutableInteractionSource arg134, Composer arg135, int arg136, int arg137, int arg138) {
        OutputTransformation v15_1;
        InputTransformation v14_5;
        Shape v17_1;
        Function2 v11_2;
        TextStyle v8_5;
        Modifier v5_4;
        MutableInteractionSource v19_3;
        TextFieldColors v18_2;
        Composer v47;
        ScrollState v16_2;
        boolean v7_4;
        boolean v6_5;
        SearchBarDefaults$InputField$9$1 v8_4;
        SearchBarState v6_4;
        SearchBarDefaults$$ExternalSyntheticLambda2 v8_3;
        ComposableLambda v3_6;
        ComposableLambda v10_3;
        Function2 v10_2;
        SolidColor v130;
        TextFieldDefaults v129;
        Modifier v128;
        TextFieldState v13_3;
        SearchBarDefaults$$ExternalSyntheticLambda14 v2_10;
        SearchBarDefaults$$ExternalSyntheticLambda13 v0_5;
        Modifier v20_1;
        SearchBarDefaults$InputField$1$1 v2_8;
        SearchBarState v3_5;
        boolean v19_1;
        CoroutineScope v6_3;
        Shape v16_1;
        MutableInteractionSource v0_2;
        Object v0_1;
        MutableInteractionSource v14_2;
        Object v14_1;
        TextFieldColors v7_1;
        int v8_1;
        MutableInteractionSource v23_1;
        Function2 v12_1;
        Function2 v4_1;
        Function2 v9_1;
        boolean v56;
        Modifier v1_1;
        Shape v6_1;
        ScrollState v66;
        OutputTransformation v65;
        InputTransformation v64;
        Function2 v13_1;
        Function2 v5_1;
        Object v3_4;
        Shape v67;
        Function2 v63;
        Function2 v62;
        Function2 v61;
        Function2 v60;
        Function2 v59;
        int v58;
        TextStyle v57_1;
        Object v2_7;
        Modifier v54_1;
        Companion v54;
        TextFieldColors v2_3;
        Shape v2_2;
        int v31;
        int v30;
        int v29;
        int v28;
        int v27;
        int v26;
        Function2 v14;
        int v23;
        TextStyle v12;
        boolean v11;
        int v19;
        boolean v9;
        int v16;
        Modifier v8;
        int v10;
        int v7;
        SearchBarDefaults v1 = this;
        TextFieldState v0 = arg117;
        SearchBarState v2 = arg118;
        Function1 v3 = arg119;
        int v4 = arg136;
        int v5 = arg137;
        int v6 = arg138;
        Composer v15 = arg135.startRestartGroup(0x2D41C906);
        ComposerKt.sourceInformation(v15, "C(InputField)N(textFieldState,searchBarState,onSearch,modifier,enabled,readOnly,textStyle,placeholder,leadingIcon,trailingIcon,prefix,suffix,inputTransformation,outputTransformation,scrollState,shape,colors,interactionSource)1323@62121L25,1324@62192L7,1325@62250L7,1327@62318L34,1328@62397L39,1336@62701L24,1342@62874L721,1360@63845L199,1365@64076L244,1377@64667L44,1402@65952L645,1383@64973L1643,1338@62735L3892,1421@66956L148,1421@66904L200,1428@67216L736,1428@67169L783,1446@68100L113,1446@68058L155:SearchBar.kt#uh7d8r");
        if((v6 & 1) != 0) {
            v7 = v4 | 6;
        }
        else if((v4 & 6) == 0) {
            v7 = v15.changed(v0) ? 4 : 2;
            v7 |= v4;
        }
        else {
            v7 = v4;
        }

        if((v6 & 2) != 0) {
            v7 |= 0x30;
        }
        else if((v4 & 0x30) == 0) {
            v10 = v15.changed(v2) ? 0x20 : 16;
            v7 |= v10;
        }

        if((v6 & 4) != 0) {
            v7 |= 0x180;
        }
        else if((v4 & 0x180) == 0) {
            v10 = v15.changedInstance(v3) ? 0x100 : 0x80;
            v7 |= v10;
        }

        v10 = v6 & 8;
        if(v10 != 0) {
            v7 |= 0xC00;
            goto label_64;
        }
        else if((v4 & 0xC00) == 0) {
            v8 = arg120;
            v16 = v15.changed(v8) ? 0x800 : 0x400;
            v7 |= v16;
        }
        else {
        label_64:
            v8 = arg120;
        }

        v16 = v6 & 16;
        int v17 = 0x4000;
        if(v16 != 0) {
            v7 |= 0x6000;
            goto label_80;
        }
        else if((v4 & 0x6000) == 0) {
            v9 = arg121;
            v19 = v15.changed(v9) ? v17 : 0x2000;
            v7 |= v19;
        }
        else {
        label_80:
            v9 = arg121;
        }

        v19 = v6 & 0x20;
        int v20 = 0x10000;
        int v21 = 0x30000;
        if(v19 != 0) {
            v7 |= v21;
            v11 = arg122;
        }
        else {
            v11 = arg122;
            if((v4 & v21) == 0) {
                int v22 = v15.changed(v11) ? 0x20000 : v20;
                v7 |= v22;
            }
        }

        if((v4 & 0x180000) == 0) {
            v12 = arg123;
            v23 = (v6 & 0x40) != 0 || !v15.changed(v12) ? 0x80000 : 0x100000;
            v7 |= v23;
        }
        else {
            v12 = arg123;
        }

        int v13 = v6 & 0x80;
        int v24 = 0xC00000;
        if(v13 != 0) {
            v7 |= v24;
            v14 = arg124;
        }
        else {
            v14 = arg124;
            if((v4 & v24) == 0) {
                v26 = v15.changedInstance(v14) ? 0x800000 : 0x400000;
                v7 |= v26;
            }
        }

        int v2_1 = v6 & 0x100;
        v26 = 0x6000000;
        if(v2_1 != 0) {
            v7 |= v26;
            goto label_142;
        }
        else if((v4 & v26) == 0) {
            v27 = v2_1;
            v28 = v15.changedInstance(arg125) ? 0x4000000 : 0x2000000;
            v7 |= v28;
        }
        else {
        label_142:
            v27 = v2_1;
        }

        v2_1 = v6 & 0x200;
        v28 = 0x30000000;
        if(v2_1 != 0) {
            v7 |= v28;
            goto label_160;
        }
        else if((v4 & v28) == 0) {
            v28 = v2_1;
            v29 = v15.changedInstance(arg126) ? 0x20000000 : 0x10000000;
            v7 |= v29;
        }
        else {
        label_160:
            v28 = v2_1;
        }

        v2_1 = v6 & 0x400;
        if(v2_1 != 0) {
            v30 = v5 | 6;
            v29 = v2_1;
        }
        else if((v5 & 6) == 0) {
            v29 = v2_1;
            v30 = v15.changedInstance(arg127) ? 4 : 2;
            v30 |= v5;
        }
        else {
            v29 = v2_1;
            v30 = v5;
        }

        v2_1 = v6 & 0x800;
        if(v2_1 != 0) {
            v30 |= 0x30;
            v31 = v2_1;
        }
        else if((v5 & 0x30) == 0) {
            v31 = v2_1;
            v21 = v15.changedInstance(arg128) ? 0x20 : 16;
            v30 |= v21;
        }
        else {
            v31 = v2_1;
        }

        v2_1 = v30;
        int v3_1 = v6 & 0x1000;
        if(v3_1 != 0) {
            v2_1 |= 0x180;
        }
        else {
            v21 = v2_1;
            if((v5 & 0x180) == 0) {
                v23 = v15.changed(arg129) ? 0x100 : 0x80;
                v21 |= v23;
            }

            v2_1 = v21;
        }

        v21 = v3_1;
        v3_1 = v6 & 0x2000;
        if(v3_1 != 0) {
            v23 = v2_1 | 0xC00;
        }
        else {
            v23 = v2_1;
            if((v5 & 0xC00) == 0) {
                v30 = v15.changed(arg130) ? 0x800 : 0x400;
                v23 |= v30;
            }
        }

        if((v5 & 0x6000) == 0) {
            if((v6 & 0x4000) != 0 || !v15.changed(arg131)) {
                v17 = 0x2000;
            }
            else {
            }

            v23 |= v17;
        }

        if((v5 & 0x30000) == 0) {
            v2_2 = arg132;
            v17 = (v6 & 0x8000) != 0 || !v15.changed(v2_2) ? v20 : 0x20000;
            v23 |= v17;
        }

        if((v5 & 0x180000) == 0) {
            v2_3 = arg133;
            v17 = (v6 & v20) != 0 || !v15.changed(v2_3) ? 0x80000 : 0x100000;
            v23 |= v17;
        }

        int v52 = v6 & 0x20000;
        if(v52 != 0) {
            v23 |= v24;
        }
        else {
            MutableInteractionSource v2_4 = arg134;
            if((v5 & v24) == 0) {
                v17 = v15.changed(v2_4) ? 0x800000 : 0x400000;
                v23 |= v17;
            }
        }

        if((v6 & 0x40000) != 0) {
            v23 |= v26;
        }
        else if((v5 & v26) == 0) {
            v17 = v15.changed(v1) ? 0x4000000 : 0x2000000;
            v23 |= v17;
        }

        v17 = v3_1;
        boolean v2_5 = (v7 & 306783379) != 306783378 || (v23 & 0x2492493) != 0x2492492 ? true : false;
        if(v15.shouldExecute(v2_5, v7 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "1298@60882L7,1306@61310L21,1307@61356L15,1308@61407L18");
            int v53 = 0xFFC7FFFF;
            Function2 v3_2 = null;
            if((arg136 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v10 != 0) {
                    v54 = Modifier.Companion;
                }
                else {
                    v54_1 = v8;
                }

                boolean v55 = v16 != 0 ? true : v9;
                v56 = v19 != 0 ? false : v11;
                if((v6 & 0x40) != 0) {
                    ProvidableCompositionLocal v2_6 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v2_7 = v15.consume(((CompositionLocal)v2_6));
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    v7 &= v53;
                    Object v57 = v2_7;
                }
                else {
                    v57_1 = v12;
                }

                v58 = v7;
                v59 = v13 != 0 ? v3_2 : v14;
                v60 = v27 != 0 ? v3_2 : arg125;
                v61 = v28 != 0 ? v3_2 : arg126;
                v62 = v29 != 0 ? v3_2 : arg127;
                v63 = v31 != 0 ? v3_2 : arg128;
                v64 = v21 != 0 ? ((InputTransformation)v3_2) : arg129;
                v65 = v17 != 0 ? ((OutputTransformation)v3_2) : arg130;
                if((v6 & 0x4000) != 0) {
                    v23 &= 0xFFFF1FFF;
                    v66 = ScrollKt.rememberScrollState(0, v15, 0, 1);
                }
                else {
                    v66 = arg131;
                }

                if((0x8000 & v6) != 0) {
                    v2_2 = v1.getInputFieldShape(v15, v23 >> 24 & 14);
                    v23 &= 0xFFF8FFFF;
                    v67 = v2_2;
                }
                else {
                    v67 = arg132;
                }

                int v68 = v23;
                if((v6 & v20) != 0) {
                    v2_3 = v1.inputFieldColors-JVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v15, 0, 0, v68 >> 15 & 0x1C00, 0x7FFFFF);
                    v15 = v15;
                    v23 = v68 & v53;
                }
                else {
                    v2_3 = arg133;
                    v23 = v68;
                }

                v7_1 = v2_3;
                v10 = v23;
                Companion v1_2 = v54;
                v2_5 = v55;
                v3_4 = v57_1;
                v8_1 = v58;
                v9_1 = v59;
                v4_1 = v60;
                v5_1 = v61;
                v12_1 = v62;
                v13_1 = v63;
                v6_1 = v67;
                if(v52 != 0) {
                    v23_1 = null;
                    goto label_545;
                }

                v23_1 = arg134;
            }
            else {
                v15.skipToGroupEnd();
                if((v6 & 0x40) != 0) {
                    v7 &= v53;
                }

                if((v6 & 0x4000) != 0) {
                    v23 &= 0xFFFF1FFF;
                }

                if((0x8000 & v6) != 0) {
                    v23 &= 0xFFF8FFFF;
                }

                if((v6 & v20) != 0) {
                    v23 &= v53;
                }

                v5_1 = arg126;
                v13_1 = arg128;
                v64 = arg129;
                v65 = arg130;
                v66 = arg131;
                v6_1 = arg132;
                v1_1 = v8;
                v2_5 = v9;
                v56 = v11;
                TextStyle v3_3 = v12;
                v9_1 = v14;
                v10 = v23;
                v4_1 = arg125;
                v12_1 = arg127;
                v23_1 = arg134;
                v8_1 = v7;
                v7_1 = arg133;
            }

        label_545:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x2D41C906, v8_1, v10, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1310)");
            }

            String v11_1 = "CC(remember):SearchBar.kt#9igjgp";
            if(v23_1 == null) {
                v15.startReplaceGroup(0x9A8FFCB5);
                ComposerKt.sourceInformation(v15, "1312@61585L39");
                ComposerKt.sourceInformationMarkerStart(v15, -470540051, v11_1);
                v14_1 = v15.rememberedValue();
                if(v14_1 == Composer.Companion.getEmpty()) {
                    v14_2 = InteractionSourceKt.MutableInteractionSource();
                    v15.updateRememberedValue(v14_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                v15.endReplaceGroup();
                v0_1 = v14_2;
            }
            else {
                v15.startReplaceGroup(-470540702);
                v15.endReplaceGroup();
                v0_2 = v23_1;
            }

            v14_1 = v0_2;
            Object v120 = v0_2;
            Function2 v121 = v9_1;
            State v9_2 = FocusInteractionKt.collectIsFocusedAsState(((InteractionSource)v14_1), v15, 0);
            ProvidableCompositionLocal v0_3 = CompositionLocalsKt.getLocalFocusManager();
            Function2 v122 = v12_1;
            Function2 v123 = v13_1;
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v0_1 = v15.consume(((CompositionLocal)v0_3));
            ComposerKt.sourceInformationMarkerEnd(v15);
            ProvidableCompositionLocal v12_2 = CompositionLocalsKt.getLocalInputModeManager();
            Object v124 = v14_1;
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v12_3 = v15.consume(((CompositionLocal)v12_2));
            ComposerKt.sourceInformationMarkerEnd(v15);
            boolean v12_4 = InputMode.equals-impl0(((InputModeManager)v12_3).getInputMode-aOaMEAU(), InputMode.Companion.getTouch-aOaMEAU());
            String v13_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_search_bar_search), v15, 0);
            v17 = v10;
            String v10_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_suggestions_available), v15, 0);
            long v18 = ((TextStyle)v3_4).getColor-0d7_KjU();
            if(v18 != 16) {
                v16_1 = v6_1;
            }
            else {
                v16_1 = v6_1;
                v18 = v7_1.textColor-XeAY9LY$material3(v2_5, false, SearchBarDefaults.InputField$lambda$5(v9_2));
            }

            TextStyle v25 = ((TextStyle)v3_4).merge(new TextStyle(v18, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null));
            ComposerKt.sourceInformationMarkerStart(v15, 0x2E20B340, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(v15, 0x28C10104, "CC(remember):Effects.kt#9igjgp");
            Object v6_2 = v15.rememberedValue();
            if(v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, v15);
                v15.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerEnd(v15);
            ComposerKt.sourceInformationMarkerStart(v15, 0xE3F4C4B7, v11_1);
            boolean v125 = v15.changed(v12_4);
            int v14_3 = v8_1 & 0x70;
            TextStyle v126 = ((TextStyle)v3_4);
            int v18_1 = v14_3 == 0x20 ? 1 : 0;
            v18_1 = (((int)v125)) | v18_1 | v15.changedInstance(v6_3) | v15.changedInstance(v0_1);
            v3_4 = v15.rememberedValue();
            if(v18_1 == 0) {
                v19_1 = v2_5;
                if(v3_4 == Composer.Companion.getEmpty()) {
                    goto label_687;
                }
                else {
                    v2_7 = v3_4;
                    v3_5 = arg118;
                }
            }
            else {
                v19_1 = v2_5;
            label_687:
                v3_5 = arg118;
                v2_8 = new SearchBarDefaults$InputField$1$1(v12_4, v3_5, v6_3, ((FocusManager)v0_1));
                v15.updateRememberedValue(v2_8);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v2_9 = SizeKt.sizeIn-qDBjuR0$default(KeyInputModifierKt.onPreviewKeyEvent(v1_1, ((Function1)v2_8)), SearchBarKt.getSearchBarMinWidth(), SearchBarDefaults.InputFieldHeight, SearchBarKt.access$getSearchBarMaxWidth$p(), 0f, 8, null);
            Object v125_1 = v0_1;
            ComposerKt.sourceInformationMarkerStart(v15, 0xE3F53C0D, v11_1);
            int v127 = v15.changed(v12_4) | v15.changedInstance(v6_3);
            int v0_4 = v14_3 == 0x20 ? 1 : 0;
            v127 |= v0_4;
            v0_1 = v15.rememberedValue();
            if(v127 == 0) {
                v20_1 = v1_1;
                if(v0_1 == Composer.Companion.getEmpty()) {
                    goto label_729;
                }
            }
            else {
                v20_1 = v1_1;
            label_729:
                v0_5 = new SearchBarDefaults$$ExternalSyntheticLambda13(v12_4, v6_3, v3_5);
                v15.updateRememberedValue(v0_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v0_6 = FocusChangedModifierKt.onFocusChanged(v2_9, ((Function1)v0_5));
            ComposerKt.sourceInformationMarkerStart(v15, -470460134, v11_1);
            boolean v1_3 = v15.changed(v13_2);
            v18_1 = v14_3 == 0x20 ? 1 : 0;
            int v1_4 = (((int)v1_3)) | v18_1 | v15.changed(v10_1);
            v2_7 = v15.rememberedValue();
            if(v1_4 != 0 || v2_7 == Composer.Companion.getEmpty()) {
                v2_10 = new SearchBarDefaults$$ExternalSyntheticLambda14(v13_2, v3_5, v10_1);
                v15.updateRememberedValue(v2_10);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            v0_6 = SemanticsModifierKt.semantics$default(v0_6, false, ((Function1)v2_10), 1, null);
            SingleLine v24_1 = SingleLine.INSTANCE;
            v127 = v14_3;
            SolidColor v2_11 = new SolidColor(v7_1.cursorColor-vNxB06k$material3(false), null);
            KeyboardOptions v27_1 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 0x77, null);
            ComposerKt.sourceInformationMarkerStart(v15, 0xE3F5A232, v11_1);
            v13 = (v8_1 & 0x380) == 0x100 ? 1 : 0;
            v14_3 = v8_1 & 14;
            v18_1 = v8_1;
            v21 = v14_3 == 4 ? 1 : 0;
            Object v1_5 = v15.rememberedValue();
            if((v13 | v21) != 0 || v1_5 == Composer.Companion.getEmpty()) {
                v13_3 = arg117;
                SearchBarDefaults$$ExternalSyntheticLambda1 v1_6 = new SearchBarDefaults$$ExternalSyntheticLambda1(arg119, v13_3);
                v15.updateRememberedValue(v1_6);
            }
            else {
                v13_3 = arg117;
            }

            Object v28_1 = v1_5;
            ComposerKt.sourceInformationMarkerEnd(v15);
            TextFieldDefaults v1_7 = TextFieldDefaults.INSTANCE;
            SingleLine v30_1 = SingleLine.INSTANCE;
            if(v4_1 == null) {
                v15.startReplaceGroup(-1698078028);
                v15.endReplaceGroup();
                v128 = v0_6;
                v129 = v1_7;
                v130 = v2_11;
                v10_2 = null;
            }
            else {
                v15.startReplaceGroup(-1698078027);
                ComposerKt.sourceInformation(v15, "*1392@65419L64");
                v128 = v0_6;
                v129 = v1_7;
                v130 = v2_11;
                ComposableLambda v0_7 = ComposableLambdaKt.rememberComposableLambda(0x2D3E01DC, true, new SearchBarDefaults$InputField$5$1(v4_1), v15, 54);
                v15.endReplaceGroup();
                v10_3 = v0_7;
            }

            if(v5_1 == null) {
                v15.startReplaceGroup(0x9ACC90D1);
                v15.endReplaceGroup();
                v3_6 = null;
            }
            else {
                v15.startReplaceGroup(0x9ACC90D2);
                ComposerKt.sourceInformation(v15, "*1396@65630L66");
                v3_6 = ComposableLambdaKt.rememberComposableLambda(0x351083B, true, new SearchBarDefaults$InputField$6$1(v5_1), v15, 54);
                v15.endReplaceGroup();
            }

            v67 = v16_1;
            v57_1 = v126;
            v60 = v4_1;
            v61 = v5_1;
            Object v109 = v6_3;
            State v108 = v9_2;
            boolean v26_1 = v12_4;
            v58 = v18_1;
            v54_1 = v20_1;
            TextFieldDecorator v1_8 = v129.decorator(v13_3, v19_1, v30_1, v65, v124, null, null, v121, ((Function2)v10_3), v3_6, v122, v123, null, false, v7_1, TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null), ComposableLambdaKt.rememberComposableLambda(1500441906, true, new SearchBarDefaults$InputField$7(v7_1, v19_1, v16_1, v9_2), v15, 54), v15, v14_3 | 0x180 | v18_1 >> 9 & 0x70 | v17 & 0x1C00 | v18_1 & 0x1C00000, v17 & 14 | 0xD80000 | v17 & 0x70 | v17 >> 6 & 0xE000, 0x3060);
            v2_5 = v19_1;
            v59 = v121;
            v62 = v122;
            v63 = v123;
            OutputTransformation v12_5 = v65;
            TextFieldColors v19_2 = v7_1;
            v4 = v58 >> 6;
            v16 = 0x6180000 | v14_3 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v17 << 6;
            Object v113 = v125_1;
            int v114 = v14_3;
            Object v112 = v124;
            v15 = v15;
            boolean v3_7 = v56;
            InputTransformation v4_2 = v64;
            ScrollState v14_4 = v66;
            BasicTextFieldKt.BasicTextField(arg117, v128, v2_5, v3_7, v4_2, v25, v27_1, v28_1, v24_1, null, v120, v130, v12_5, v1_8, v14_4, v15, v16, v17 >> 3 & 0x380 | v17 & 0xE000, 0x200);
            String v1_9 = v11_1;
            ComposerKt.sourceInformationMarkerStart(v15, -470368070, v1_9);
            v0_4 = v127;
            v5 = 0x20;
            v6 = v0_4 == v5 ? 1 : 0;
            Object v7_2 = v109;
            v6 |= v15.changedInstance(v7_2);
            Object v8_2 = v15.rememberedValue();
            if(v6 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                v6_4 = arg118;
                v8_3 = new SearchBarDefaults$$ExternalSyntheticLambda2(v6_4, ((CoroutineScope)v7_2));
                v15.updateRememberedValue(v8_3);
            }
            else {
                v6_4 = arg118;
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            SearchBarKt.access$DetectClickFromInteractionSource(v112, ((Function0)v8_3), v15, 0);
            ComposerKt.sourceInformationMarkerStart(v15, 0xE3F6E386, v1_9);
            v0_4 = v0_4 == v5 ? 1 : 0;
            v5 = v114 == 4 ? 1 : 0;
            v0_4 |= v5;
            State v5_2 = v108;
            v0_4 = v0_4 | v15.changed(v5_2) | v15.changedInstance(v7_2);
            v8_2 = v15.rememberedValue();
            if(v0_4 != 0 || v8_2 == Composer.Companion.getEmpty()) {
                v0 = arg117;
                v108 = v5_2;
                v8_4 = new SearchBarDefaults$InputField$9$1(v6_4, arg117, v7_2, v5_2, null);
                v15.updateRememberedValue(v8_4);
            }
            else {
                v0 = arg117;
                v108 = v5_2;
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EffectsKt.LaunchedEffect(v6_4, v0, ((Function2)v8_4), v15, v58 >> 3 & 14 | v58 << 3 & 0x70);
            boolean v5_3 = (SearchBarKt.access$isExpanded(v6_4)) || !SearchBarDefaults.InputField$lambda$5(v108) || !v26_1 ? false : true;
            Boolean v7_3 = Boolean.valueOf(SearchBarKt.access$isExpanded(v6_4));
            ComposerKt.sourceInformationMarkerStart(v15, 0xE3F74F97, v1_9);
            v8_2 = v113;
            v1_4 = v15.changed(v5_3) | v15.changedInstance(v8_2);
            Object v9_3 = v15.rememberedValue();
            if(v1_4 != 0 || v9_3 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$InputField$10$1 v9_4 = new SearchBarDefaults$InputField$10$1(v5_3, ((FocusManager)v8_2), null);
                v15.updateRememberedValue(v9_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EffectsKt.LaunchedEffect(v7_3, ((Function2)v9_3), v15, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v6_5 = v2_5;
            v7_4 = v3_7;
            v16_2 = v14_4;
            v47 = v15;
            v18_2 = v19_2;
            v19_3 = v23_1;
            v5_4 = v54_1;
            v8_5 = v57_1;
            v9_1 = v59;
            v10_2 = v60;
            v11_2 = v61;
            v13_1 = v63;
            v17_1 = v67;
            v14_5 = v4_2;
            v15_1 = v12_5;
            v12_1 = v62;
        }
        else {
            v15.skipToGroupEnd();
            v10_2 = arg125;
            v13_1 = arg128;
            v16_2 = arg131;
            v17_1 = arg132;
            v18_2 = arg133;
            v19_3 = arg134;
            v5_4 = v8;
            v6_5 = v9;
            v7_4 = v11;
            v8_5 = v12;
            v9_1 = v14;
            v47 = v15;
            v11_2 = arg126;
            v12_1 = arg127;
            v14_5 = arg129;
            v15_1 = arg130;
        }

        ScopeUpdateScope v1_10 = v47.endRestartGroup();
        if(v1_10 != null) {
            v1_10.updateScope(new SearchBarDefaults$$ExternalSyntheticLambda3(this, arg117, arg118, arg119, v5_4, v6_5, v7_4, v8_5, v9_1, v10_2, v11_2, v12_1, v13_1, v14_5, v15_1, v16_2, v17_1, v18_2, v19_3, arg136, arg137, arg138));
        }
    }

    public final void InputField(TextFieldState arg111, Function1 arg112, boolean arg113, Function1 arg114, Modifier arg115, boolean arg116, boolean arg117, TextStyle arg118, Function2 arg119, Function2 arg120, Function2 arg121, Function2 arg122, Function2 arg123, InputTransformation arg124, OutputTransformation arg125, ScrollState arg126, Shape arg127, TextFieldColors arg128, MutableInteractionSource arg129, Composer arg130, int arg131, int arg132, int arg133) {
        InputTransformation v15_1;
        Shape v18_1;
        Function2 v11_2;
        TextStyle v9_5;
        Modifier v6_4;
        MutableInteractionSource v20_2;
        Composer v47;
        ScrollState v17_2;
        OutputTransformation v16_1;
        boolean v8_3;
        boolean v7_2;
        TextFieldColors v19_1;
        ComposableLambda v3_3;
        Function2 v10_3;
        TextFieldDefaults v118;
        Object v117;
        SearchBarDefaults$$ExternalSyntheticLambda9 v12_3;
        FocusRequester v5_3;
        MutableInteractionSource v0_2;
        MutableInteractionSource v14_2;
        Object v14_1;
        Function2 v12_1;
        Function2 v4_1;
        int v10_1;
        Function2 v9_1;
        TextStyle v1_1;
        boolean v56;
        MutableInteractionSource v23_1;
        TextFieldColors v7_1;
        Shape v6_1;
        ScrollState v66;
        OutputTransformation v5_1;
        InputTransformation v64;
        Function2 v13_1;
        Modifier v54;
        Object v1_2;
        Shape v67;
        Function2 v63;
        Function2 v62;
        Function2 v61;
        Function2 v60;
        Function2 v59;
        int v58;
        TextStyle v57_1;
        Companion v54_1;
        TextFieldColors v2_4;
        Shape v2_3;
        int v31;
        int v25;
        int v30;
        int v29;
        int v28;
        int v27;
        int v26;
        Function2 v14;
        int v23;
        TextStyle v12;
        boolean v10;
        int v20;
        boolean v9;
        int v16;
        int v11;
        int v8;
        SearchBarDefaults v1 = this;
        TextFieldState v0 = arg111;
        Function1 v2 = arg112;
        boolean v3 = arg113;
        Function1 v4 = arg114;
        int v5 = arg131;
        int v6 = arg132;
        int v7 = arg133;
        Composer v15 = arg130.startRestartGroup(0x76E29BB3);
        ComposerKt.sourceInformation(v15, "C(InputField)N(state,onSearch,expanded,onExpandedChange,modifier,enabled,readOnly,textStyle,placeholder,leadingIcon,trailingIcon,prefix,suffix,inputTransformation,outputTransformation,scrollState,shape,colors,interactionSource)1524@72733L25,1525@72794L29,1526@72869L7,1528@72908L34,1529@72987L39,1547@73662L44,1548@73738L227,1560@74312L35,1585@75579L645,1566@74609L1634,1537@73270L2984,1602@76341L320,1602@76316L345:SearchBar.kt#uh7d8r");
        if((v7 & 1) != 0) {
            v8 = v5 | 6;
        }
        else if((v5 & 6) == 0) {
            v8 = v15.changed(v0) ? 4 : 2;
            v8 |= v5;
        }
        else {
            v8 = v5;
        }

        if((v7 & 2) != 0) {
            v8 |= 0x30;
        }
        else if((v5 & 0x30) == 0) {
            v11 = v15.changedInstance(v2) ? 0x20 : 16;
            v8 |= v11;
        }

        if((v7 & 4) != 0) {
            v8 |= 0x180;
        }
        else if((v5 & 0x180) == 0) {
            v11 = v15.changed(v3) ? 0x100 : 0x80;
            v8 |= v11;
        }

        if((v7 & 8) != 0) {
            v8 |= 0xC00;
        }
        else if((v5 & 0xC00) == 0) {
            v11 = v15.changedInstance(v4) ? 0x800 : 0x400;
            v8 |= v11;
        }

        v11 = v7 & 16;
        if(v11 != 0) {
            v8 |= 0x6000;
        }
        else if((v5 & 0x6000) == 0) {
            v16 = v15.changed(arg115) ? 0x4000 : 0x2000;
            v8 |= v16;
        }

        v16 = v7 & 0x20;
        int v17 = 0x20000;
        int v18 = 0x10000;
        int v19 = 0x30000;
        if(v16 != 0) {
            v8 |= v19;
            v9 = arg116;
        }
        else {
            v9 = arg116;
            if((v5 & v19) == 0) {
                v20 = v15.changed(v9) ? v17 : v18;
                v8 |= v20;
            }
        }

        v20 = v7 & 0x40;
        int v21 = 0x180000;
        if(v20 != 0) {
            v8 |= v21;
            v10 = arg117;
        }
        else {
            v10 = arg117;
            if((v5 & v21) == 0) {
                int v22 = v15.changed(v10) ? 0x100000 : 0x80000;
                v8 |= v22;
            }
        }

        if((v5 & 0xC00000) == 0) {
            if((v7 & 0x80) == 0) {
                v12 = arg118;
                if(v15.changed(v12)) {
                    v23 = 0x800000;
                }
                else {
                    goto label_121;
                }
            }
            else {
                v12 = arg118;
            label_121:
                v23 = 0x400000;
            }

            v8 |= v23;
        }
        else {
            v12 = arg118;
        }

        int v13 = v7 & 0x100;
        int v24 = 0x6000000;
        if(v13 != 0) {
            v8 |= v24;
            v14 = arg119;
        }
        else {
            v14 = arg119;
            if((v5 & v24) == 0) {
                v26 = v15.changedInstance(v14) ? 0x4000000 : 0x2000000;
                v8 |= v26;
            }
        }

        int v2_1 = v7 & 0x200;
        v26 = 0x30000000;
        if(v2_1 != 0) {
            v8 |= v26;
            goto label_156;
        }
        else if((v5 & v26) == 0) {
            v27 = v2_1;
            v28 = v15.changedInstance(arg120) ? 0x20000000 : 0x10000000;
            v8 |= v28;
        }
        else {
        label_156:
            v27 = v2_1;
        }

        v2_1 = v7 & 0x400;
        if(v2_1 != 0) {
            v19 = v6 | 6;
            v28 = v2_1;
        }
        else if((v6 & 6) == 0) {
            v28 = v2_1;
            v19 = v15.changedInstance(arg121) ? 4 : 2;
            v19 |= v6;
        }
        else {
            v28 = v2_1;
            v19 = v6;
        }

        v2_1 = v7 & 0x800;
        if(v2_1 != 0) {
            v19 |= 0x30;
            v29 = v2_1;
        }
        else if((v6 & 0x30) == 0) {
            v29 = v2_1;
            v30 = v15.changedInstance(arg122) ? 0x20 : 16;
            v19 |= v30;
        }
        else {
            v29 = v2_1;
        }

        v2_1 = v19;
        int v3_1 = v7 & 0x1000;
        if(v3_1 != 0) {
            v2_1 |= 0x180;
        }
        else {
            v19 = v2_1;
            if((v6 & 0x180) == 0) {
                v25 = v15.changedInstance(arg123) ? 0x100 : 0x80;
                v19 |= v25;
            }

            v2_1 = v19;
        }

        v19 = v3_1;
        v3_1 = v7 & 0x2000;
        if(v3_1 != 0) {
            v2_1 |= 0xC00;
        }
        else {
            v25 = v2_1;
            if((v6 & 0xC00) == 0) {
                v30 = v15.changed(arg124) ? 0x800 : 0x400;
                v25 |= v30;
            }

            v2_1 = v25;
        }

        v25 = v3_1;
        v3_1 = v7 & 0x4000;
        if(v3_1 != 0) {
            v30 = v2_1 | 0x6000;
        }
        else {
            v30 = v2_1;
            if((v6 & 0x6000) == 0) {
                v31 = v15.changed(arg125) ? 0x4000 : 0x2000;
                v30 |= v31;
            }
        }

        if((v6 & 0x30000) == 0) {
            ScrollState v2_2 = arg126;
            v31 = (v7 & 0x8000) != 0 || !v15.changed(v2_2) ? v18 : v17;
            v30 |= v31;
        }

        if((v6 & 0x180000) == 0) {
            v2_3 = arg127;
            v31 = (v7 & v18) != 0 || !v15.changed(v2_3) ? 0x80000 : 0x100000;
            v30 |= v31;
        }

        if((v6 & 0xC00000) == 0) {
            v2_4 = arg128;
            v31 = (v7 & v17) != 0 || !v15.changed(v2_4) ? 0x400000 : 0x800000;
            v30 |= v31;
        }

        int v52 = v7 & 0x40000;
        if(v52 != 0) {
            v30 |= v24;
        }
        else {
            MutableInteractionSource v2_5 = arg129;
            if((v6 & v24) == 0) {
                v24 = v15.changed(v2_5) ? 0x4000000 : 0x2000000;
                v30 |= v24;
            }
        }

        if((v7 & 0x80000) != 0) {
            v30 |= v26;
        }
        else if((v6 & v26) == 0) {
            v24 = v15.changed(v1) ? 0x20000000 : 0x10000000;
            v30 |= v24;
        }

        v24 = v3_1;
        boolean v2_6 = (v8 & 306783379) != 306783378 || (v30 & 306783379) != 306783378 ? true : false;
        if(v15.shouldExecute(v2_6, v8 & 1)) {
            v15.startDefaults();
            ComposerKt.sourceInformation(v15, "1508@71949L7,1516@72377L21,1517@72423L15,1518@72474L18");
            int v53 = 0xFE3FFFFF;
            Function2 v3_2 = null;
            if((arg131 & 1) == 0 || (v15.getDefaultsInvalid())) {
                if(v11 != 0) {
                    v54_1 = Modifier.Companion;
                }
                else {
                    v54 = arg115;
                }

                boolean v55 = v16 != 0 ? true : v9;
                v56 = v20 != 0 ? false : v10;
                if((v7 & 0x80) != 0) {
                    ProvidableCompositionLocal v2_7 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v2_8 = v15.consume(((CompositionLocal)v2_7));
                    ComposerKt.sourceInformationMarkerEnd(v15);
                    v8 &= v53;
                    Object v57 = v2_8;
                }
                else {
                    v57_1 = v12;
                }

                v58 = v8;
                v59 = v13 != 0 ? v3_2 : v14;
                v60 = v27 != 0 ? v3_2 : arg120;
                v61 = v28 != 0 ? v3_2 : arg121;
                v62 = v29 != 0 ? v3_2 : arg122;
                v63 = v19 != 0 ? v3_2 : arg123;
                v64 = v25 != 0 ? ((InputTransformation)v3_2) : arg124;
                OutputTransformation v65 = v24 != 0 ? ((OutputTransformation)v3_2) : arg125;
                if((0x8000 & v7) != 0) {
                    v30 &= 0xFFF8FFFF;
                    v66 = ScrollKt.rememberScrollState(0, v15, 0, 1);
                }
                else {
                    v66 = arg126;
                }

                if((v7 & v18) != 0) {
                    v2_3 = v1.getInputFieldShape(v15, v30 >> 27 & 14);
                    v30 &= 0xFFC7FFFF;
                    v67 = v2_3;
                }
                else {
                    v67 = arg127;
                }

                int v68 = v30;
                if((v7 & v17) != 0) {
                    v2_4 = v1.inputFieldColors-JVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v15, 0, 0, v68 >> 18 & 0x1C00, 0x7FFFFF);
                    v15 = v15;
                    v30 = v68 & v53;
                }
                else {
                    v2_4 = arg128;
                    v30 = v68;
                }

                if(v52 != 0) {
                    v7_1 = v2_4;
                    v10_1 = v30;
                    v2_6 = v55;
                    v1_2 = v57_1;
                    v8 = v58;
                    v9_1 = v59;
                    v3_2 = v60;
                    v4_1 = v61;
                    v12_1 = v62;
                    v13_1 = v63;
                    v5_1 = v65;
                    v6_1 = v67;
                    v23_1 = null;
                    goto label_569;
                }

                v23_1 = arg129;
                v7_1 = v2_4;
                v10_1 = v30;
                v2_6 = v55;
                v1_2 = v57_1;
                v8 = v58;
                v9_1 = v59;
                v3_2 = v60;
                v4_1 = v61;
                v12_1 = v62;
                v13_1 = v63;
                v5_1 = v65;
                v6_1 = v67;
            }
            else {
                v15.skipToGroupEnd();
                if((v7 & 0x80) != 0) {
                    v8 &= v53;
                }

                if((0x8000 & v7) != 0) {
                    v30 &= 0xFFF8FFFF;
                }

                if((v7 & v18) != 0) {
                    v30 &= 0xFFC7FFFF;
                }

                if((v7 & v17) != 0) {
                    v30 &= v53;
                }

                v54 = arg115;
                v3_2 = arg120;
                v13_1 = arg123;
                v64 = arg124;
                v5_1 = arg125;
                v66 = arg126;
                v6_1 = arg127;
                v7_1 = arg128;
                v23_1 = arg129;
                v2_6 = v9;
                v56 = v10;
                v1_1 = v12;
                v9_1 = v14;
                v10_1 = v30;
                v4_1 = arg121;
                v12_1 = arg122;
            }

        label_569:
            v15.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x76E29BB3, v8, v10_1, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1520)");
            }

            String v11_1 = "CC(remember):SearchBar.kt#9igjgp";
            if(v23_1 == null) {
                v15.startReplaceGroup(0xCCB4E808);
                ComposerKt.sourceInformation(v15, "1522@72652L39");
                ComposerKt.sourceInformationMarkerStart(v15, 0x48AAFF3A, v11_1);
                v14_1 = v15.rememberedValue();
                if(v14_1 == Composer.Companion.getEmpty()) {
                    v14_2 = InteractionSourceKt.MutableInteractionSource();
                    v15.updateRememberedValue(v14_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15);
                v15.endReplaceGroup();
                Object v0_1 = v14_2;
            }
            else {
                v15.startReplaceGroup(0x48AAFCAF);
                v15.endReplaceGroup();
                v0_2 = v23_1;
            }

            v14_1 = v0_2;
            Object v122 = v0_2;
            boolean v0_3 = FocusInteractionKt.collectIsFocusedAsState(((InteractionSource)v14_1), v15, 0).getValue().booleanValue();
            OutputTransformation v123 = v5_1;
            ComposerKt.sourceInformationMarkerStart(v15, 0x48AB10F0, v11_1);
            Object v5_2 = v15.rememberedValue();
            Function2 v124 = v9_1;
            if(v5_2 == Composer.Companion.getEmpty()) {
                v5_3 = new FocusRequester();
                v15.updateRememberedValue(v5_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            ProvidableCompositionLocal v9_2 = CompositionLocalsKt.getLocalFocusManager();
            v16 = v10_1;
            Function2 v125 = v12_1;
            ComposerKt.sourceInformationMarkerStart(v15, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v9_3 = v15.consume(((CompositionLocal)v9_2));
            ComposerKt.sourceInformationMarkerEnd(v15);
            String v10_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_search_bar_search), v15, 0);
            Object v126 = v9_3;
            String v9_4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_suggestions_available), v15, 0);
            long v17_1 = v1_1.getColor-0d7_KjU();
            if(v17_1 != 16) {
            }
            else {
                v17_1 = v7_1.textColor-XeAY9LY$material3(v2_6, false, v0_3);
            }

            TextStyle v24_1 = v1_1.merge(new TextStyle(v17_1, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null));
            Modifier v5_4 = FocusRequesterModifierKt.focusRequester(SizeKt.sizeIn-qDBjuR0$default(((Modifier)v54_1), SearchBarKt.getSearchBarMinWidth(), SearchBarDefaults.InputFieldHeight, SearchBarKt.access$getSearchBarMaxWidth$p(), 0f, 8, null), v5_3);
            ComposerKt.sourceInformationMarkerStart(v15, 0x48AB7D7F, v11_1);
            TextStyle v115 = v1_1;
            int v1_3 = (v8 & 0x1C00) == 0x800 ? 1 : 0;
            Object v12_2 = v15.rememberedValue();
            if(v1_3 != 0 || v12_2 == Composer.Companion.getEmpty()) {
                v12_3 = new SearchBarDefaults$$ExternalSyntheticLambda9(arg114);
                v15.updateRememberedValue(v12_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            v5_4 = FocusChangedModifierKt.onFocusChanged(v5_4, ((Function1)v12_3));
            ComposerKt.sourceInformationMarkerStart(v15, 1219200950, v11_1);
            boolean v12_4 = v15.changed(v10_2);
            v17 = v8;
            v1_3 = (v8 & 0x380) == 0x100 ? 1 : 0;
            v1_3 = v1_3 | (((int)v12_4)) | v15.changed(v9_4);
            Object v8_1 = v15.rememberedValue();
            if(v1_3 != 0 || v8_1 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$$ExternalSyntheticLambda10 v8_2 = new SearchBarDefaults$$ExternalSyntheticLambda10(v10_2, arg113, v9_4);
                v15.updateRememberedValue(v8_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            Modifier v25_1 = SemanticsModifierKt.semantics$default(v5_4, false, ((Function1)v8_1), 1, null);
            SingleLine v26_1 = SingleLine.INSTANCE;
            Function2 v116 = v13_1;
            SolidColor v5_5 = new SolidColor(v7_1.cursorColor-vNxB06k$material3(false), null);
            KeyboardOptions v27_1 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 0x77, null);
            ComposerKt.sourceInformationMarkerStart(v15, 0x48ABCEB6, v11_1);
            v8 = (v17 & 0x70) == 0x20 ? 1 : 0;
            int v12_5 = v17 & 14;
            v13 = v12_5 == 4 ? 1 : 0;
            v8 |= v13;
            Object v13_2 = v15.rememberedValue();
            if(v8 != 0 || v13_2 == Composer.Companion.getEmpty()) {
                v117 = v14_1;
                SearchBarDefaults$$ExternalSyntheticLambda11 v13_3 = new SearchBarDefaults$$ExternalSyntheticLambda11(arg112, arg111);
                v15.updateRememberedValue(v13_3);
            }
            else {
                v117 = v14_1;
            }

            Object v28_1 = v13_2;
            ComposerKt.sourceInformationMarkerEnd(v15);
            TextFieldDefaults v1_4 = TextFieldDefaults.INSTANCE;
            SingleLine v13_4 = SingleLine.INSTANCE;
            if(v3_2 == null) {
                v15.startReplaceGroup(0xCCD88207);
                v15.endReplaceGroup();
                v118 = v1_4;
                arg119 = v3_2;
                v10_3 = null;
            }
            else {
                v15.startReplaceGroup(0xCCD88208);
                ComposerKt.sourceInformation(v15, "*1575@75046L64");
                v118 = v1_4;
                arg119 = v3_2;
                v3_3 = ComposableLambdaKt.rememberComposableLambda(0x12BC937E, true, new SearchBarDefaults$InputField$15$1(v3_2), v15, 54);
                v15.endReplaceGroup();
                ComposableLambda v10_4 = v3_3;
            }

            if(v4_1 == null) {
                v15.startReplaceGroup(0xCCDBB024);
                v15.endReplaceGroup();
                arg120 = v4_1;
                v3_3 = null;
            }
            else {
                v15.startReplaceGroup(0xCCDBB025);
                ComposerKt.sourceInformation(v15, "*1579@75257L66");
                arg120 = v4_1;
                v3_3 = ComposableLambdaKt.rememberComposableLambda(0x22AEFCBF, true, new SearchBarDefaults$InputField$16$1(v4_1), v15, 54);
                v15.endReplaceGroup();
            }

            int v4_2 = v16 >> 3;
            v30 = v16;
            v57_1 = v115;
            v60 = arg119;
            v61 = arg120;
            int v32 = v4_2;
            v67 = v6_1;
            String v107 = v11_1;
            v31 = v12_5;
            v58 = v17;
            TextFieldDecorator v1_5 = v118.decorator(arg111, v2_6, v13_4, v123, v117, null, null, v124, v10_3, v3_3, v125, v116, null, false, v7_1, TextFieldDefaults.contentPaddingWithoutLabel-a9UjIt4$default(TextFieldDefaults.INSTANCE, 0f, 0f, 0f, 0f, 15, null), ComposableLambdaKt.rememberComposableLambda(0xA386E068, true, new SearchBarDefaults$InputField$17(v7_1, v2_6, v0_3, v6_1), v15, 54), v15, v12_5 | 0x180 | v17 >> 12 & 0x70 | v4_2 & 0x1C00 | v17 >> 3 & 0x1C00000, v4_2 & 14 | 0xD80000 | v4_2 & 0x70 | v16 >> 9 & 0xE000, 0x3060);
            v2_6 = v2_6;
            v59 = v124;
            v62 = v125;
            v63 = v116;
            OutputTransformation v12_6 = v123;
            v19_1 = v7_1;
            v4_2 = v58 >> 9;
            v16 = v31 | 0x6180000 | v4_2 & 0x380 | v4_2 & 0x1C00 | v30 << 3 & 0xE000;
            boolean v20_1 = v0_3;
            Object v108 = v126;
            v15 = v15;
            v3 = v56;
            InputTransformation v4_3 = v64;
            ScrollState v14_3 = v66;
            BasicTextFieldKt.BasicTextField(arg111, v25_1, v2_6, v3, v4_3, v24_1, v27_1, v28_1, v26_1, null, v122, v5_5, v12_6, v1_5, v14_3, v15, v16, v30 >> 6 & 0x380 | v32 & 0xE000, 0x200);
            v0_3 = (arg113) || !v20_1 ? false : true;
            Boolean v1_6 = Boolean.valueOf(arg113);
            ComposerKt.sourceInformationMarkerStart(v15, 0x48ACCD73, v107);
            v9_3 = v108;
            v5 = v15.changed(v0_3) | v15.changedInstance(v9_3);
            Object v6_2 = v15.rememberedValue();
            if(v5 != 0 || v6_2 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$InputField$18$1 v6_3 = new SearchBarDefaults$InputField$18$1(v0_3, ((FocusManager)v9_3), null);
                v15.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15);
            EffectsKt.LaunchedEffect(v1_6, ((Function2)v6_2), v15, v58 >> 6 & 14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v7_2 = v2_6;
            v8_3 = v3;
            v16_1 = v12_6;
            v17_2 = v14_3;
            v47 = v15;
            v20_2 = v23_1;
            v6_4 = ((Modifier)v54_1);
            v9_5 = v57_1;
            v10_3 = v59;
            v11_2 = v60;
            v12_1 = v61;
            v13_1 = v62;
            v14 = v63;
            v18_1 = v67;
            v15_1 = v4_3;
        }
        else {
            v15.skipToGroupEnd();
            v6_4 = arg115;
            v11_2 = arg120;
            v13_1 = arg122;
            v16_1 = arg125;
            v17_2 = arg126;
            v18_1 = arg127;
            v19_1 = arg128;
            v20_2 = arg129;
            v7_2 = v9;
            v8_3 = v10;
            v9_5 = v12;
            v10_3 = v14;
            v47 = v15;
            v12_1 = arg121;
            v14 = arg123;
            v15_1 = arg124;
        }

        ScopeUpdateScope v0_4 = v47.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new SearchBarDefaults$$ExternalSyntheticLambda12(this, arg111, arg112, arg113, arg114, v6_4, v7_2, v8_3, v9_5, v10_3, v11_2, v12_1, v13_1, v14, v15_1, v16_1, v17_2, v18_1, v19_1, v20_2, arg131, arg132, arg133));
        }
    }

    public final void InputField(String arg73, Function1 arg74, Function1 arg75, boolean arg76, Function1 arg77, Modifier arg78, boolean arg79, Function2 arg80, Function2 arg81, Function2 arg82, TextFieldColors arg83, MutableInteractionSource arg84, Composer arg85, int arg86, int arg87, int arg88) {
        Function2 v11_1;
        Function2 v10_1;
        Function2 v9_1;
        TextFieldColors v12_3;
        Modifier v7_2;
        MutableInteractionSource v13_4;
        SearchBarDefaults$InputField$24$1 v3_3;
        FocusRequester v4_5;
        MutableInteractionSource v5_2;
        Object v5_1;
        TextFieldColors v1_2;
        int v8_1;
        boolean v2_1;
        Modifier v4_2;
        Composer v15_1;
        MutableInteractionSource v20_1;
        Function2 v6;
        Function2 v67;
        TextFieldColors v2_2;
        Function2 v68;
        boolean v8_2;
        Companion v4_3;
        int v17;
        int v85;
        int v22;
        int v21;
        Function2 v7;
        boolean v5;
        int v19;
        Modifier v8;
        int v15;
        int v3;
        String v0 = arg73;
        Function1 v9 = arg75;
        boolean v10 = arg76;
        Function1 v11 = arg77;
        int v12 = arg86;
        int v13 = arg87;
        int v14 = arg88;
        Composer v2 = arg85.startRestartGroup(748018311);
        ComposerKt.sourceInformation(v2, "C(InputField)N(query,onQueryChange,onSearch,expanded,onExpandedChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,colors,interactionSource)1659@79407L25,1660@79468L29,1661@79543L7,1663@79582L34,1664@79661L39,1667@79753L7,1682@80316L44,1683@80392L227,1691@80722L7,1694@80976L19,1697@81105L1935,1671@79881L3170,1737@83138L320,1737@83113L345:SearchBar.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v3 = v12 | 6;
        }
        else if((v12 & 6) == 0) {
            v3 = v2.changed(v0) ? 4 : 2;
            v3 |= v12;
        }
        else {
            v3 = v12;
        }

        if((v14 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v12 & 0x30) == 0) {
            v15 = v2.changedInstance(arg74) ? 0x20 : 16;
            v3 |= v15;
        }

        int v16 = 0x80;
        if((v14 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v12 & 0x180) == 0) {
            v15 = v2.changedInstance(v9) ? 0x100 : v16;
            v3 |= v15;
        }

        if((v14 & 8) != 0) {
            v3 |= 0xC00;
        }
        else if((v12 & 0xC00) == 0) {
            v15 = v2.changed(v10) ? 0x800 : 0x400;
            v3 |= v15;
        }

        if((v14 & 16) != 0) {
            v3 |= 0x6000;
        }
        else if((v12 & 0x6000) == 0) {
            v15 = v2.changedInstance(v11) ? 0x4000 : 0x2000;
            v3 |= v15;
        }

        v15 = v14 & 0x20;
        int v18 = 0x30000;
        if(v15 != 0) {
            v3 |= v18;
            v8 = arg78;
        }
        else {
            v8 = arg78;
            if((v12 & v18) == 0) {
                v19 = v2.changed(v8) ? 0x20000 : 0x10000;
                v3 |= v19;
            }
        }

        v19 = v14 & 0x40;
        int v20 = 0x180000;
        if(v19 != 0) {
            v3 |= v20;
        }
        else {
            v5 = arg79;
            if((v12 & v20) == 0) {
                v20 = v2.changed(v5) ? 0x100000 : 0x80000;
                v3 |= v20;
            }
        }

        int v4 = v14 & 0x80;
        v20 = 0xC00000;
        if(v4 != 0) {
            v3 |= v20;
            v7 = arg80;
        }
        else {
            v7 = arg80;
            if((v12 & v20) == 0) {
                v20 = v2.changedInstance(v7) ? 0x800000 : 0x400000;
                v3 |= v20;
            }
        }

        int v1 = v14 & 0x100;
        v20 = 0x6000000;
        if(v1 != 0) {
            v3 |= v20;
            goto label_139;
        }
        else if((v12 & v20) == 0) {
            v20 = v1;
            v21 = v2.changedInstance(arg81) ? 0x4000000 : 0x2000000;
            v3 |= v21;
        }
        else {
        label_139:
            v20 = v1;
        }

        v1 = v14 & 0x200;
        v21 = 0x30000000;
        if(v1 != 0) {
            v3 |= v21;
            goto label_157;
        }
        else if((v12 & v21) == 0) {
            v21 = v1;
            v22 = v2.changedInstance(arg82) ? 0x20000000 : 0x10000000;
            v3 |= v22;
        }
        else {
        label_157:
            v21 = v1;
        }

        if((v13 & 6) == 0) {
            v22 = (v14 & 0x400) != 0 || !v2.changed(arg83) ? 2 : 4;
            v22 |= v13;
        }
        else {
            v22 = v13;
        }

        v1 = v14 & 0x800;
        if(v1 != 0) {
            v22 |= 0x30;
            v85 = v1;
        }
        else {
            v85 = v1;
            MutableInteractionSource v1_1 = arg84;
            if((v13 & 0x30) == 0) {
                v17 = v2.changed(v1_1) ? 0x20 : 16;
                v22 |= v17;
            }
        }

        v1 = v22;
        v17 = v4;
        if((v14 & 0x1000) != 0) {
            v1 |= 0x180;
        }
        else if((v13 & 0x180) == 0) {
            if(v2.changed(this)) {
                v16 = 0x100;
            }

            v1 |= v16;
        }

        boolean v4_1 = (v3 & 306783379) != 306783378 || (v1 & 0x93) != 0x92 ? true : false;
        if(v2.shouldExecute(v4_1, v3 & 1)) {
            v2.startDefaults();
            ComposerKt.sourceInformation(v2, "1653@79148L18");
            if((arg86 & 1) == 0 || (v2.getDefaultsInvalid())) {
                if(v15 != 0) {
                    v4_3 = Modifier.Companion;
                }
                else {
                    v4_2 = v8;
                }

                v8_2 = v19 != 0 ? true : arg79;
                if(v17 != 0) {
                    v7 = null;
                }

                v67 = v20 != 0 ? null : arg81;
                v68 = v21 != 0 ? null : arg82;
                if((v14 & 0x400) != 0) {
                    Composer v61 = v2;
                    v2_2 = this.inputFieldColors-JVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v61, 0, 0, v1 << 3 & 0x1C00, 0x7FFFFF);
                    v15_1 = v61;
                    v1 &= -15;
                }
                else {
                    v15_1 = v2;
                    v2_2 = arg83;
                }

                boolean v6_1 = v8_2;
                v8_1 = v1;
                v1_2 = v2_2;
                v2_1 = v6_1;
                if(v85 != 0) {
                    v6 = v68;
                    v20_1 = null;
                    goto label_306;
                }

                v20_1 = arg84;
                v6 = v68;
            }
            else {
                v2.skipToGroupEnd();
                if((v14 & 0x400) != 0) {
                    v1 &= -15;
                }

                v67 = arg81;
                v6 = arg82;
                v20_1 = arg84;
                v15_1 = v2;
                v4_2 = v8;
                v2_1 = arg79;
                v8_1 = v1;
                v1_2 = arg83;
            }

        label_306:
            v15_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(748018311, v3, v8_1, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1655)");
            }

            String v12_1 = "CC(remember):SearchBar.kt#9igjgp";
            if(v20_1 == null) {
                v15_1.startReplaceGroup(1923851092);
                ComposerKt.sourceInformation(v15_1, "1657@79326L39");
                ComposerKt.sourceInformationMarkerStart(v15_1, 1586080366, v12_1);
                v5_1 = v15_1.rememberedValue();
                if(v5_1 == Composer.Companion.getEmpty()) {
                    v5_2 = InteractionSourceKt.MutableInteractionSource();
                    v15_1.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v15_1);
                v15_1.endReplaceGroup();
            }
            else {
                v15_1.startReplaceGroup(1586079715);
                v15_1.endReplaceGroup();
                v5_2 = v20_1;
            }

            arg78 = ((Modifier)v4_3);
            v8_2 = FocusInteractionKt.collectIsFocusedAsState(v5_1, v15_1, 0).getValue().booleanValue();
            ComposerKt.sourceInformationMarkerStart(v15_1, 1586084900, v12_1);
            Object v4_4 = v15_1.rememberedValue();
            Object v18_1 = v5_1;
            if(v4_4 == Composer.Companion.getEmpty()) {
                v4_5 = new FocusRequester();
                v15_1.updateRememberedValue(v4_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            ProvidableCompositionLocal v5_3 = CompositionLocalsKt.getLocalFocusManager();
            Function2 v17_1 = v6;
            Function2 v19_1 = v7;
            String v7_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x789C5F52, v7_1);
            v5_1 = v15_1.consume(((CompositionLocal)v5_3));
            ComposerKt.sourceInformationMarkerEnd(v15_1);
            Object v21_1 = v5_1;
            String v6_2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_search_bar_search), v15_1, 0);
            String v13_1 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(string.m3c_suggestions_available), v15_1, 0);
            v5_3 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x789C5F52, v7_1);
            v5_1 = v15_1.consume(((CompositionLocal)v5_3));
            ComposerKt.sourceInformationMarkerEnd(v15_1);
            long v23 = ((TextStyle)v5_1).getColor-0d7_KjU();
            if(v23 != 16) {
            }
            else {
                v23 = v1_2.textColor-XeAY9LY$material3(v2_1, false, v8_2);
            }

            long v26 = v23;
            Modifier v23_1 = arg78;
            v4_2 = FocusRequesterModifierKt.focusRequester(SizeKt.sizeIn-qDBjuR0$default(arg78, SearchBarKt.getSearchBarMinWidth(), SearchBarDefaults.InputFieldHeight, SearchBarKt.access$getSearchBarMaxWidth$p(), 0f, 8, null), v4_5);
            ComposerKt.sourceInformationMarkerStart(v15_1, 1586112051, v12_1);
            int v5_4 = (0xE000 & v3) == 0x4000 ? 1 : 0;
            Object v14_1 = v15_1.rememberedValue();
            if(v5_4 != 0 || v14_1 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$$ExternalSyntheticLambda0 v14_2 = new SearchBarDefaults$$ExternalSyntheticLambda0(v11);
                v15_1.updateRememberedValue(v14_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            v4_2 = FocusChangedModifierKt.onFocusChanged(v4_2, ((Function1)v14_1));
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x5E8A306A, v12_1);
            v5 = v15_1.changed(v6_2);
            boolean v24 = v2_1;
            int v2_3 = (v3 & 0x1C00) == 0x800 ? 1 : 0;
            v2_3 = v2_3 | (((int)v5)) | v15_1.changed(v13_1);
            v5_1 = v15_1.rememberedValue();
            if(v2_3 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$$ExternalSyntheticLambda6 v5_5 = new SearchBarDefaults$$ExternalSyntheticLambda6(v6_2, v10, v13_1);
                v15_1.updateRememberedValue(v5_5);
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            Modifier v14_3 = SemanticsModifierKt.semantics$default(v4_2, false, ((Function1)v5_1), 1, null);
            ProvidableCompositionLocal v2_4 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x789C5F52, v7_1);
            Object v2_5 = v15_1.consume(((CompositionLocal)v2_4));
            ComposerKt.sourceInformationMarkerEnd(v15_1);
            TextStyle v13_2 = ((TextStyle)v2_5).merge(new TextStyle(v26, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 0xFFFFFE, null));
            SolidColor v2_6 = new SolidColor(v1_2.cursorColor-vNxB06k$material3(false), null);
            KeyboardOptions v25 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 0x77, null);
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x5E8A789A, v12_1);
            v5_4 = (v3 & 0x380) == 0x100 ? 1 : 0;
            int v6_3 = v3 & 14;
            v4 = v6_3 == 4 ? 1 : 0;
            v4 |= v5_4;
            v5_1 = v15_1.rememberedValue();
            if(v4 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                SearchBarDefaults$$ExternalSyntheticLambda7 v5_6 = new SearchBarDefaults$$ExternalSyntheticLambda7(v9, v0);
                v15_1.updateRememberedValue(v5_6);
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            KeyboardActions v26_1 = new KeyboardActions(null, null, null, null, v5_1, null, 0x2F, null);
            SolidColor v22_1 = v2_6;
            Function2 v2_7 = v17_1;
            v17 = v3;
            Object v3_1 = v18_1;
            v18 = v6_3;
            v6 = v2_7;
            Object v69 = v21_1;
            v2_1 = v24;
            Function2 v27 = v19_1;
            v68 = v6;
            TextFieldColors v24_1 = v1_2;
            boolean v21_2 = v8_2;
            ComposableLambda v0_1 = ComposableLambdaKt.rememberComposableLambda(0xCF7C7644, true, new SearchBarDefaults$InputField$23(arg73, v2_1, ((MutableInteractionSource)v3_1), v19_1, v67, v6, v1_2, v8_2), v15_1, 54);
            v4 = v17 >> 9;
            String v70 = v12_1;
            TextStyle v5_7 = v13_2;
            Object v13_3 = v3_1;
            boolean v3_2 = v2_1;
            Modifier v2_8 = v14_3;
            SolidColor v14_4 = v22_1;
            v22 = v4;
            BasicTextFieldKt.BasicTextField(arg73, arg74, v2_8, v3_2, false, v5_7, v25, v26_1, true, 0, 0, null, null, ((MutableInteractionSource)v13_3), ((Brush)v14_4), v0_1, v15_1, v18 | 0x6180000 | v17 & 0x70 | v4 & 0x1C00, 0x30000, 0x1E10);
            v2_1 = v3_2;
            v15_1 = v15_1;
            boolean v12_2 = (arg76) || !v21_2 ? false : true;
            Boolean v0_2 = Boolean.valueOf(arg76);
            ComposerKt.sourceInformationMarkerStart(v15_1, 0x5E8B8807, v70);
            v5_1 = v69;
            v1 = v15_1.changed(v12_2) | v15_1.changedInstance(v5_1);
            v3_1 = v15_1.rememberedValue();
            if(v1 != 0 || v3_1 == Composer.Companion.getEmpty()) {
                v3_3 = new SearchBarDefaults$InputField$24$1(v12_2, ((FocusManager)v5_1), null);
                v15_1.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v15_1);
            EffectsKt.LaunchedEffect(v0_2, ((Function2)v3_3), v15_1, v22 & 14);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8_2 = v2_1;
            v13_4 = v20_1;
            v7_2 = v23_1;
            v12_3 = v24_1;
            v9_1 = v27;
            v10_1 = v67;
            v11_1 = v68;
        }
        else {
            v15_1 = v2;
            v15_1.skipToGroupEnd();
            v10_1 = arg81;
            v11_1 = arg82;
            v12_3 = arg83;
            v13_4 = arg84;
            v9_1 = v7;
            v7_2 = v8;
            v8_2 = arg79;
        }

        ScopeUpdateScope v0_3 = v15_1.endRestartGroup();
        if(v0_3 != null) {
            v0_3.updateScope(new SearchBarDefaults$$ExternalSyntheticLambda8(this, arg73, arg74, arg75, arg76, arg77, v7_2, v8_2, v9_1, v10_1, v11_1, v12_3, v13_4, arg86, arg87, arg88));
        }
    }

    static final Unit InputField$lambda$11$lambda$10(String arg0, SearchBarState arg1, String arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setContentDescription(arg3, arg0);
        if(SearchBarKt.access$isExpanded(arg1)) {
            SemanticsPropertiesKt.setStateDescription(arg3, arg2);
        }

        return Unit.INSTANCE;
    }

    static final void InputField$lambda$13$lambda$12(Function1 arg0, TextFieldState arg1, Function0 arg2) {
        arg0.invoke(arg1.getText().toString());
    }

    static final Unit InputField$lambda$17$lambda$16(SearchBarState arg8, CoroutineScope arg9) {
        if(!SearchBarKt.access$isExpanded(arg8)) {
            BuildersKt.launch$default(arg9, null, null, new SearchBarDefaults$InputField$8$1$1(arg8, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$20(SearchBarDefaults arg24, TextFieldState arg25, SearchBarState arg26, Function1 arg27, Modifier arg28, boolean arg29, boolean arg30, TextStyle arg31, Function2 arg32, Function2 arg33, Function2 arg34, Function2 arg35, Function2 arg36, InputTransformation arg37, OutputTransformation arg38, ScrollState arg39, Shape arg40, TextFieldColors arg41, MutableInteractionSource arg42, int arg43, int arg44, int arg45, Composer arg46, int arg47) {
        arg24.InputField(arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg46, RecomposeScopeImplKt.updateChangedFlags(arg43 | 1), RecomposeScopeImplKt.updateChangedFlags(arg44), arg45);
        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$25$lambda$24(Function1 arg0, FocusState arg1) {
        if(arg1.isFocused()) {
            arg0.invoke(Boolean.valueOf(true));
        }

        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$27$lambda$26(String arg0, boolean arg1, String arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setContentDescription(arg3, arg0);
        if(arg1) {
            SemanticsPropertiesKt.setStateDescription(arg3, arg2);
        }

        return Unit.INSTANCE;
    }

    static final void InputField$lambda$29$lambda$28(Function1 arg0, TextFieldState arg1, Function0 arg2) {
        arg0.invoke(arg1.getText().toString());
    }

    static final Unit InputField$lambda$33(SearchBarDefaults arg25, TextFieldState arg26, Function1 arg27, boolean arg28, Function1 arg29, Modifier arg30, boolean arg31, boolean arg32, TextStyle arg33, Function2 arg34, Function2 arg35, Function2 arg36, Function2 arg37, Function2 arg38, InputTransformation arg39, OutputTransformation arg40, ScrollState arg41, Shape arg42, TextFieldColors arg43, MutableInteractionSource arg44, int arg45, int arg46, int arg47, Composer arg48, int arg49) {
        arg25.InputField(arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg48, RecomposeScopeImplKt.updateChangedFlags(arg45 | 1), RecomposeScopeImplKt.updateChangedFlags(arg46), arg47);
        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$38$lambda$37(Function1 arg0, FocusState arg1) {
        if(arg1.isFocused()) {
            arg0.invoke(Boolean.valueOf(true));
        }

        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$40$lambda$39(String arg0, boolean arg1, String arg2, SemanticsPropertyReceiver arg3) {
        SemanticsPropertiesKt.setContentDescription(arg3, arg0);
        if(arg1) {
            SemanticsPropertiesKt.setStateDescription(arg3, arg2);
        }

        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$42$lambda$41(Function1 arg0, String arg1, KeyboardActionScope arg2) {
        arg0.invoke(arg1);
        return Unit.INSTANCE;
    }

    static final Unit InputField$lambda$44(SearchBarDefaults arg18, String arg19, Function1 arg20, Function1 arg21, boolean arg22, Function1 arg23, Modifier arg24, boolean arg25, Function2 arg26, Function2 arg27, Function2 arg28, TextFieldColors arg29, MutableInteractionSource arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        arg18.InputField(arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    private static final boolean InputField$lambda$5(State arg0) {
        return arg0.getValue().booleanValue();
    }

    static final Unit InputField$lambda$9$lambda$8(boolean arg6, CoroutineScope arg7, SearchBarState arg8, FocusState arg9) {
        if((arg9.isFocused()) && (arg6)) {
            BuildersKt.launch$default(arg7, null, null, new SearchBarDefaults$InputField$2$1$1(arg8, null), 3, null);
        }

        return Unit.INSTANCE;
    }

    public static final boolean access$InputField$lambda$5(State arg0) {
        return SearchBarDefaults.InputField$lambda$5(arg0);
    }

    public final SearchBarColors colors-Klgx-Pg(long arg55, long arg57, TextFieldColors arg59, Composer arg60, int arg61, int arg62) {
        TextFieldColors v12;
        int v0_1;
        long v41;
        Composer v0 = arg60;
        int v1 = arg61;
        int v3 = 701925149;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,inputFieldColors)1128@50345L5,1129@50412L5,1131@50475L202:SearchBar.kt#uh7d8r");
        int v4 = 6;
        long v8 = (arg62 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v4) : arg55;
        long v52 = (arg62 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), v0, v4) : arg57;
        if((arg62 & 4) != 0) {
            v41 = v8;
            Composer v47 = v0;
            v0_1 = v1;
            v12 = this.inputFieldColors-JVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v41, v41, v41, v47, 0, 0, v1 & 14 | v1 << 3 & 0x70 | v1 << 6 & 0x380 | v1 & 0x1C00, 0xFFFFF);
        }
        else {
            v0_1 = v1;
            v41 = v8;
            v12 = arg59;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(701925149, v0_1, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1137)");
        }

        SearchBarColors v7 = new SearchBarColors(v41, v52, v12, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg60);
        return v7;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final SearchBarColors colors-dgg9oW8(long arg56, long arg58, Composer arg60, int arg61, int arg62) {
        Composer v0 = arg60;
        int v1 = arg61;
        int v3 = 0x351F77CE;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color)1750@83659L5,1751@83726L5,1757@83916L218:SearchBar.kt#uh7d8r");
        int v4 = 6;
        long v8 = (arg62 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v4) : arg56;
        long v52 = (arg62 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), v0, v4) : arg58;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1753)");
        }

        v3 = v1 << 3;
        SearchBarColors v7 = new SearchBarColors(v8, v52, this.inputFieldColors-JVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, v8, v8, v8, v0, 0, 0, v1 << v4 & 0x380 | (v1 & 14 | v3 & 0x70) | v3 & 0x1C00, 0xFFFFF), null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg60);
        return v7;
    }

    public final SearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior(float arg17, float arg18, Function0 arg19, AnimationSpec arg20, DecayAnimationSpec arg21, boolean arg22, Composer arg23, int arg24, int arg25) {
        FiniteAnimationSpec v7;
        SearchBarDefaults$$ExternalSyntheticLambda4 v5_1;
        Composer v0 = arg23;
        int v1 = arg24;
        int v3 = 1222500790;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(enterAlwaysSearchBarScrollBehavior)N(initialOffset,initialOffsetLimit,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1088@48597L8,1090@48770L7,1091@48835L26,1105@49345L375,1094@48944L776:SearchBar.kt#uh7d8r");
        float v2 = (arg25 & 1) != 0 ? 0f : arg17;
        float v4 = (arg25 & 2) != 0 ? -3.402823E+38f : arg18;
        String v6 = "CC(remember):SearchBar.kt#9igjgp";
        if((arg25 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(v0, 0x88EC667E, v6);
            Object v5 = v0.rememberedValue();
            if(v5 == Composer.Companion.getEmpty()) {
                v5_1 = new SearchBarDefaults$$ExternalSyntheticLambda4();
                v0.updateRememberedValue(v5_1);
            }

            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            Function0 v5_2 = arg19;
        }

        int v8 = 6;
        if((arg25 & 8) != 0) {
            v7 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, v0, v8);
        }
        else {
            AnimationSpec v7_1 = arg20;
        }

        DecayAnimationSpec v9 = (arg25 & 16) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(v0, 0) : arg21;
        int v11 = 0x20;
        boolean v12 = (arg25 & 0x20) != 0 ? false : arg22;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.SearchBarDefaults.enterAlwaysSearchBarScrollBehavior (SearchBar.kt:1094)");
        }

        Object[] v3_1 = new Object[]{v7, v9, v5_1, Boolean.valueOf(v12)};
        Saver v13 = EnterAlwaysSearchBarScrollBehavior.Companion.Saver(((Function0)v5_1), ((AnimationSpec)v7), v9);
        ComposerKt.sourceInformationMarkerStart(v0, 0x88ECC56D, v6);
        int v6_1 = v1 & 14 ^ v8;
        v8 = 4;
        int v14 = 1;
        v6_1 = v6_1 > v8 && (v0.changed(v2)) || (v1 & 6) == v8 ? 1 : 0;
        v8 = (v1 & 0x70 ^ 0x30) > v11 && (v0.changed(v4)) || (v1 & 0x30) == v11 ? 1 : 0;
        v6_1 |= v8;
        v11 = 0x100;
        v8 = (v1 & 0x380 ^ 0x180) > v11 && (v0.changed(v5_1)) || (v1 & 0x180) == v11 ? 1 : 0;
        v6_1 |= v8;
        v11 = 0x30000;
        int v15 = 0x20000;
        if((0x70000 & v1 ^ v11) <= v15 || !v0.changed(v12)) {
            if((v1 & v11) == v15) {
            }
            else {
                v14 = 0;
            }
        }

        v1 = v6_1 | v14 | v0.changedInstance(v7) | v0.changedInstance(v9);
        Object v6_2 = v0.rememberedValue();
        if(v1 != 0 || v6_2 == Composer.Companion.getEmpty()) {
            SearchBarDefaults$$ExternalSyntheticLambda5 v6_3 = new SearchBarDefaults$$ExternalSyntheticLambda5(v2, v4, v5_1, v12, v7, v9);
            v0.updateRememberedValue(v6_3);
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        Object v1_1 = RememberSaveableKt.rememberSaveable(v3_1, v13, ((Function0)v6_2), v0, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return ((SearchBarScrollBehavior)v1_1);
    }

    static final boolean enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0() {
        return 1;
    }

    static final EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(float arg7, float arg8, Function0 arg9, boolean arg10, AnimationSpec arg11, DecayAnimationSpec arg12) {
        return new EnterAlwaysSearchBarScrollBehavior(arg7, arg8, arg9, arg10, arg11, arg12);
    }

    public final Shape getDockedShape(Composer arg3, int arg4) {
        int v0 = 0xA9BB20F7;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-dockedShape>)1047@46512L5:SearchBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:1047)");
        }

        Shape v2 = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getElevation-D9Ej5fM() {
        return SearchBarDefaults.Elevation;
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith="<_subannotation>") public static void getElevation-D9Ej5fM$annotations() {
    }

    public final Shape getFullScreenShape(Composer arg3, int arg4) {
        int v0 = -2009956471;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-fullScreenShape>)1043@46362L5:SearchBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:1043)");
        }

        Shape v2 = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final WindowInsets getFullScreenWindowInsets(Composer arg3, int arg4) {
        int v0 = 0x97FAD4B8;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-fullScreenWindowInsets>)1059@46961L11:SearchBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenWindowInsets> (SearchBar.kt:1059)");
        }

        WindowInsets v2 = WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getInputFieldHeight-D9Ej5fM() {
        return SearchBarDefaults.InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer arg3, int arg4) {
        int v0 = 0x967738F3;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-inputFieldShape>)1039@46188L5:SearchBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:1039)");
        }

        Shape v2 = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getShadowElevation-D9Ej5fM() {
        return SearchBarDefaults.ShadowElevation;
    }

    public final float getTonalElevation-D9Ej5fM() {
        return SearchBarDefaults.TonalElevation;
    }

    public final WindowInsets getWindowInsets(Composer arg3, int arg4) {
        int v0 = 0x94F4586E;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-windowInsets>)1053@46670L29:SearchBar.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:1053)");
        }

        WindowInsets v2 = WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, arg3, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getTop-JoeWqyM()));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors inputFieldColors--u-KgnY(long arg53, long arg55, long arg57, TextSelectionColors arg59, long arg60, long arg62, long arg64, long arg66, long arg68, long arg70, long arg72, long arg74, Composer arg76, int arg77, int arg78, int arg79) {
        TextSelectionColors v4_2;
        Composer v0 = arg76;
        int v1 = arg77;
        int v2 = arg78;
        int v3 = arg79;
        ComposerKt.sourceInformationMarkerStart(v0, 0x6DD3292A, "C(inputFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1829@87858L5,1831@87953L5,1834@88109L5,1835@88188L7,1836@88271L5,1837@88354L5,1839@88462L5,1842@88638L5,1843@88723L5,1845@88833L5,1848@89004L5,1850@89106L5,1854@89216L825:SearchBar.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), v0, v6) : arg53;
        long v9 = (v3 & 2) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg55;
        long v11 = (v3 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), v0, v6) : arg57;
        if((v3 & 8) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            v4_2 = arg59;
        }

        long v13 = (v3 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg60;
        long v15 = (v3 & 0x20) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg62;
        long v19 = (v3 & 0x40) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg64;
        long v21 = (v3 & 0x80) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg66;
        long v23 = (v3 & 0x100) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg68;
        long v25 = (v3 & 0x200) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg70;
        long v27 = (v3 & 0x400) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), v0, v6) : arg72;
        long v29 = (v3 & 0x800) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg74;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(0x6DD3292A, v1, v2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1854)");
        }

        int v5 = v1 << 3;
        v3 = v2 << 3;
        v2 <<= 6;
        TextFieldColors v0_1 = this.inputFieldColors-JVEmHcM(v7, v7, v9, v11, v4_2, v13, v15, v19, v21, v23, v25, v27, v27, v29, 0, 0, 0, 0, 0, 0, 0, 0, 0, v0, v1 & 14 | v5 & 0x70 | v5 & 0x380 | v5 & 0x1C00 | 0xE000 & v5 | 0x70000 & v5 | 0x380000 & v5 | 0x1C00000 & v5 | 0xE000000 & v5 | v5 & 0x70000000, v1 >> 27 & 14 | v3 & 0x70 | v2 & 0x380 | v2 & 0x1C00, v3 & 0x1C00, 0x7FC000);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg76);
        return v0_1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public final TextFieldColors inputFieldColors-ITpI4ow(long arg58, long arg60, long arg62, long arg64, TextSelectionColors arg66, long arg67, long arg69, long arg71, long arg73, long arg75, long arg77, long arg79, long arg81, long arg83, Composer arg85, int arg86, int arg87, int arg88) {
        Object v4_1;
        Composer v0 = arg85;
        int v1 = arg86;
        int v2 = arg87;
        int v3 = arg88;
        ComposerKt.sourceInformationMarkerStart(v0, -2048506052, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1767@84342L5,1768@84416L5,1770@84511L5,1773@84667L5,1774@84746L7,1775@84829L5,1776@84912L5,1778@85020L5,1781@85196L5,1782@85281L5,1784@85391L5,1787@85569L5,1788@85655L5,1790@85757L5,1809@86804L5,1810@86885L5,1812@86981L5,1815@87155L5,1816@87236L5,1818@87332L5,1821@87501L5,1822@87577L5,1823@87652L5,1794@85884L1784:SearchBar.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), v0, v6) : arg58;
        long v9 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), v0, v6) : arg60;
        long v11 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg62;
        long v13 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), v0, v6) : arg64;
        if((v3 & 16) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
        }
        else {
            TextSelectionColors v4_2 = arg66;
        }

        long v17 = (v3 & 0x20) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg67;
        long v19 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg69;
        long v21 = (v3 & 0x80) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg71;
        long v23 = (v3 & 0x100) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg73;
        long v25 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg75;
        long v27 = (v3 & 0x400) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg77;
        long v29 = (v3 & 0x800) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), v0, v6) : arg79;
        long v31 = (v3 & 0x1000) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), v0, v6) : arg81;
        long v33 = (v3 & 0x2000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg83;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2048506052, v1, v2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1794)");
        }

        TextFieldColors v0_1 = this.inputFieldColors-JVEmHcM(v7, v9, v11, v13, v4_1, v17, v19, v21, v23, v25, v27, v29, v31, v33, ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6), Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6), v0, v1 & 0x7FFFFFFE, v2 & 0x1FFE, v2 >> 3 & 0x1C00, 0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg85);
        return v0_1;
    }

    public final TextFieldColors inputFieldColors-JVEmHcM(long arg100, long arg102, long arg104, long arg106, TextSelectionColors arg108, long arg109, long arg111, long arg113, long arg115, long arg117, long arg119, long arg121, long arg123, long arg125, long arg127, long arg129, long arg131, long arg133, long arg135, long arg137, long arg139, long arg141, long arg143, Composer arg145, int arg146, int arg147, int arg148, int arg149) {
        Object v22;
        Composer v0 = arg145;
        int v1 = arg146;
        int v2 = arg147;
        int v3 = arg149;
        int v5 = -2000124979;
        ComposerKt.sourceInformationMarkerStart(v0, v5, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color)1178@53452L5,1179@53526L5,1181@53621L5,1184@53777L5,1185@53856L7,1186@53939L5,1187@54022L5,1189@54130L5,1192@54306L5,1193@54391L5,1195@54501L5,1198@54679L5,1199@54765L5,1201@54867L5,1204@55036L5,1205@55120L5,1207@55215L5,1210@55384L5,1211@55468L5,1213@55563L5,1216@55727L5,1217@55806L5,1218@55884L5,1220@55942L1360:SearchBar.kt#uh7d8r");
        int v6 = 6;
        long v7 = (v3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), v0, v6) : arg100;
        long v9 = (v3 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), v0, v6) : arg102;
        long v11 = (v3 & 4) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg104;
        long v18 = (v3 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), v0, v6) : arg106;
        if((v3 & 16) != 0) {
            ProvidableCompositionLocal v4 = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(v0, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v4_1 = v0.consume(((CompositionLocal)v4));
            ComposerKt.sourceInformationMarkerEnd(v0);
            v22 = v4_1;
        }
        else {
            TextSelectionColors v22_1 = arg108;
        }

        long v31 = (v3 & 0x20) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg109;
        long v33 = (v3 & 0x40) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), v0, v6) : arg111;
        long v35 = (v3 & 0x80) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null) : arg113;
        long v39 = (v3 & 0x100) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg115;
        long v41 = (v3 & 0x200) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), v0, v6) : arg117;
        long v43 = (v3 & 0x400) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0f, 0f, 0f, 14, null) : arg119;
        long v55 = (v3 & 0x800) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), v0, v6) : arg121;
        long v57 = (v3 & 0x1000) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), v0, v6) : arg123;
        long v59 = (v3 & 0x2000) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg125;
        long v71 = (v3 & 0x4000) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6) : arg127;
        long v73 = (0x8000 & v3) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6) : arg129;
        long v75 = (0x10000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg131;
        long v79 = (0x20000 & v3) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6) : arg133;
        long v81 = (0x40000 & v3) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6) : arg135;
        long v83 = (0x80000 & v3) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), v0, v6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0f, 0f, 0f, 14, null) : arg137;
        long v13 = (0x100000 & v3) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6) : arg139;
        long v15 = (0x200000 & v3) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6) : arg141;
        long v3_1 = (v3 & 0x400000) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), v0, v6) : arg143;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v5, v1, v2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1220)");
        }

        int v17 = arg148 << 12;
        int v88 = v1 & 0x3FE | v17 & 0xE000 | v17 & 0x70000 | v17 & 0x380000 | v1 << 15 & 0xE000000;
        int v89 = v1 >> 12 & 14 | v1 & 0x70000 | v1 & 0x380000 | v1 & 0x1C00000 | v1 << 3 & 0x70000000;
        v6 = v2 << 3;
        int v20 = v2 << 18;
        int v90 = v1 >> 27 & 14 | v6 & 0x70 | v20 & 0x1C00000 | v20 & 0xE000000 | v20 & 0x70000000;
        v1 = v2 >> 24;
        TextFieldColors v0_1 = TextFieldDefaults.INSTANCE.colors-0hiis_0(v7, v9, v11, 0, v13, v15, v3_1, 0, v18, 0, ((TextSelectionColors)v22), 0, 0, 0, 0, v31, v33, v35, 0, v39, v41, v43, 0, 0, 0, 0, 0, v55, v57, v59, 0, 0, 0, 0, 0, v71, v73, v75, 0, v79, v81, v83, 0, v0, v88, v89, v90, 0x1FF0000 & v6 | v2 << 6 & 0x70000000, v1 & 14 | 0xC00 | v1 & 0x70, 1204058760, 0x88F);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg145);
        return v0_1;
    }
}

