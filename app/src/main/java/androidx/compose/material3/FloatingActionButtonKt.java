package androidx.compose.material3;

import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ExtendedFabLargeTokens;
import androidx.compose.material3.tokens.ExtendedFabMediumTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.ExtendedFabSmallTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1={"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001An\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u0086\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0004\b\u0018\u0010\u0019\u001An\u0010\u001A\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001B\u0010\u0012\u001An\u0010\u001C\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0011\u0010\u000F\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001D\u0010\u0012\u001Ay\u0010\u001E\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000E2\u001C\u0010\u000F\u001A\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001F¢\u0006\u0002\b\u0010¢\u0006\u0002\b!H\u0007¢\u0006\u0004\b\"\u0010#\u001A\u008B\u0001\u0010\u001E\u001A\u00020\u00012\u0011\u0010$\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\'2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b(\u0010)\u001A»\u0001\u0010\u001E\u001A\u00020\u00012\u0011\u0010$\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\u0011\u0010%\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00102\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010*\u001A\u00020\u00162\u0006\u0010+\u001A\u00020\u00162\u0006\u0010,\u001A\u00020\u00162\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\'2\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0003¢\u0006\u0004\b-\u0010.\u001A\r\u0010G\u001A\u00020HH\u0003¢\u0006\u0002\u0010I\u001A\r\u0010J\u001A\u00020KH\u0003¢\u0006\u0002\u0010L\"\u0010\u0010/\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00101\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00102\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00103\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00104\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000E\u00105\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00107\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00108\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u00109\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010:\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010;\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000E\u0010<\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010=\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010>\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010?\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010@\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010A\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u000E\u0010B\u001A\u000206X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010C\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010D\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010E\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100\"\u0010\u0010F\u001A\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006M"}, d2={"FloatingActionButton", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "FloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "FloatingActionButton-lF-WlFE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "SmallFloatingActionButton", "SmallFloatingActionButton-X-z6DiA", "LargeFloatingActionButton", "LargeFloatingActionButton-X-z6DiA", "ExtendedFloatingActionButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "ExtendedFloatingActionButton-X-z6DiA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "text", "icon", "expanded", "", "ExtendedFloatingActionButton-ElI5-7k", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "startPadding", "endPadding", "iconPadding", "ExtendedFloatingActionButton-qtIzBjc", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/text/TextStyle;FFFFFLandroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/material3/FloatingActionButtonElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SmallExtendedFabMinimumWidth", "F", "SmallExtendedFabMinimumHeight", "SmallExtendedFabPaddingStart", "SmallExtendedFabPaddingEnd", "SmallExtendedFabIconPadding", "SmallExtendedFabTextStyle", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "MediumExtendedFabMinimumWidth", "MediumExtendedFabMinimumHeight", "MediumExtendedFabPaddingStart", "MediumExtendedFabPaddingEnd", "MediumExtendedFabIconPadding", "MediumExtendedFabTextStyle", "LargeExtendedFabMinimumWidth", "LargeExtendedFabMinimumHeight", "LargeExtendedFabPaddingStart", "LargeExtendedFabPaddingEnd", "LargeExtendedFabIconPadding", "LargeExtendedFabTextStyle", "ExtendedFabStartIconPadding", "ExtendedFabEndIconPadding", "ExtendedFabTextPadding", "ExtendedFabMinimumWidth", "extendedFabCollapseAnimation", "Landroidx/compose/animation/ExitTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "extendedFabExpandAnimation", "Landroidx/compose/animation/EnterTransition;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FloatingActionButtonKt {
    private static final float ExtendedFabEndIconPadding;
    private static final float ExtendedFabMinimumWidth;
    private static final float ExtendedFabStartIconPadding;
    private static final float ExtendedFabTextPadding;
    private static final float LargeExtendedFabIconPadding;
    private static final float LargeExtendedFabMinimumHeight;
    private static final float LargeExtendedFabMinimumWidth;
    private static final float LargeExtendedFabPaddingEnd;
    private static final float LargeExtendedFabPaddingStart;
    private static final TypographyKeyTokens LargeExtendedFabTextStyle;
    private static final float MediumExtendedFabIconPadding;
    private static final float MediumExtendedFabMinimumHeight;
    private static final float MediumExtendedFabMinimumWidth;
    private static final float MediumExtendedFabPaddingEnd;
    private static final float MediumExtendedFabPaddingStart;
    private static final TypographyKeyTokens MediumExtendedFabTextStyle;
    private static final float SmallExtendedFabIconPadding;
    private static final float SmallExtendedFabMinimumHeight;
    private static final float SmallExtendedFabMinimumWidth;
    private static final float SmallExtendedFabPaddingEnd;
    private static final float SmallExtendedFabPaddingStart;
    private static final TypographyKeyTokens SmallExtendedFabTextStyle;

    static {
        FloatingActionButtonKt.SmallExtendedFabMinimumWidth = ExtendedFabSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.SmallExtendedFabMinimumHeight = ExtendedFabSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.SmallExtendedFabPaddingStart = ExtendedFabSmallTokens.INSTANCE.getLeadingSpace-D9Ej5fM();
        FloatingActionButtonKt.SmallExtendedFabPaddingEnd = ExtendedFabSmallTokens.INSTANCE.getTrailingSpace-D9Ej5fM();
        FloatingActionButtonKt.SmallExtendedFabIconPadding = ExtendedFabSmallTokens.INSTANCE.getIconLabelSpace-D9Ej5fM();
        FloatingActionButtonKt.SmallExtendedFabTextStyle = TypographyKeyTokens.TitleMedium;
        FloatingActionButtonKt.MediumExtendedFabMinimumWidth = ExtendedFabMediumTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.MediumExtendedFabMinimumHeight = ExtendedFabMediumTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.MediumExtendedFabPaddingStart = ExtendedFabMediumTokens.INSTANCE.getLeadingSpace-D9Ej5fM();
        FloatingActionButtonKt.MediumExtendedFabPaddingEnd = ExtendedFabMediumTokens.INSTANCE.getTrailingSpace-D9Ej5fM();
        FloatingActionButtonKt.MediumExtendedFabIconPadding = Dp.constructor-impl(12f);
        FloatingActionButtonKt.MediumExtendedFabTextStyle = TypographyKeyTokens.TitleLarge;
        FloatingActionButtonKt.LargeExtendedFabMinimumWidth = ExtendedFabLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.LargeExtendedFabMinimumHeight = ExtendedFabLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        FloatingActionButtonKt.LargeExtendedFabPaddingStart = ExtendedFabLargeTokens.INSTANCE.getLeadingSpace-D9Ej5fM();
        FloatingActionButtonKt.LargeExtendedFabPaddingEnd = ExtendedFabLargeTokens.INSTANCE.getTrailingSpace-D9Ej5fM();
        FloatingActionButtonKt.LargeExtendedFabIconPadding = Dp.constructor-impl(16f);
        FloatingActionButtonKt.LargeExtendedFabTextStyle = TypographyKeyTokens.HeadlineSmall;
        FloatingActionButtonKt.ExtendedFabStartIconPadding = Dp.constructor-impl(16f);
        FloatingActionButtonKt.ExtendedFabEndIconPadding = Dp.constructor-impl(12f);
        FloatingActionButtonKt.ExtendedFabTextPadding = Dp.constructor-impl(20f);
        FloatingActionButtonKt.ExtendedFabMinimumWidth = Dp.constructor-impl(80f);
    }

    public static final void ExtendedFloatingActionButton-ElI5-7k(Function2 arg28, Function2 arg29, Function0 arg30, Modifier arg31, boolean arg32, Shape arg33, long arg34, long arg36, FloatingActionButtonElevation arg38, MutableInteractionSource arg39, Composer arg40, int arg41, int arg42) {
        MutableInteractionSource v12_2;
        FloatingActionButtonElevation v11;
        long v9_2;
        long v7_1;
        Shape v6_2;
        Modifier v4_1;
        boolean v5_1;
        long v20_1;
        MutableInteractionSource v23;
        int v17;
        FloatingActionButtonElevation v12_1;
        int v40;
        int v12;
        long v10_1;
        int v10;
        Shape v9_1;
        boolean v8;
        int v7;
        Modifier v6;
        Function0 v15;
        int v5;
        int v4;
        Function2 v1 = arg28;
        Function2 v2 = arg29;
        int v13 = arg41;
        int v14 = arg42;
        Composer v3 = arg40.startRestartGroup(-1161000600);
        ComposerKt.sourceInformation(v3, "C(ExtendedFloatingActionButton)N(text,icon,onClick,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)400@18910L1159,392@18647L1422:FloatingActionButton.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v4 = v13 | 6;
        }
        else if((v13 & 6) == 0) {
            v4 = v3.changedInstance(v1) ? 4 : 2;
            v4 |= v13;
        }
        else {
            v4 = v13;
        }

        if((v14 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v13 & 0x30) == 0) {
            v5 = v3.changedInstance(v2) ? 0x20 : 16;
            v4 |= v5;
        }

        if((v14 & 4) != 0) {
            v4 |= 0x180;
            v15 = arg30;
        }
        else {
            v15 = arg30;
            if((v13 & 0x180) == 0) {
                v5 = v3.changedInstance(v15) ? 0x100 : 0x80;
                v4 |= v5;
            }
        }

        v5 = v14 & 8;
        if(v5 != 0) {
            v4 |= 0xC00;
            goto label_63;
        }
        else if((v13 & 0xC00) == 0) {
            v6 = arg31;
            v7 = v3.changed(v6) ? 0x800 : 0x400;
            v4 |= v7;
        }
        else {
        label_63:
            v6 = arg31;
        }

        v7 = v14 & 16;
        if(v7 != 0) {
            v4 |= 0x6000;
            goto label_78;
        }
        else if((v13 & 0x6000) == 0) {
            v8 = arg32;
            int v9 = v3.changed(v8) ? 0x4000 : 0x2000;
            v4 |= v9;
        }
        else {
        label_78:
            v8 = arg32;
        }

        if((0x30000 & v13) == 0) {
            if((v14 & 0x20) == 0) {
                v9_1 = arg33;
                if(v3.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_90;
                }
            }
            else {
                v9_1 = arg33;
            label_90:
                v10 = 0x10000;
            }

            v4 |= v10;
        }
        else {
            v9_1 = arg33;
        }

        if((0x180000 & v13) == 0) {
            if((v14 & 0x40) == 0) {
                v10_1 = arg34;
                if(v3.changed(v10_1)) {
                    v12 = 0x100000;
                }
                else {
                    goto label_105;
                }
            }
            else {
                v10_1 = arg34;
            label_105:
                v12 = 0x80000;
            }

            v4 |= v12;
        }
        else {
            v10_1 = arg34;
        }

        v12 = 0xC00000;
        if((v13 & v12) == 0) {
            v40 = v12;
            long v0 = arg36;
            int v16 = (v14 & 0x80) != 0 || !v3.changed(v0) ? 0x400000 : 0x800000;
            v4 |= v16;
        }
        else {
            v40 = v12;
        }

        if((v13 & 0x6000000) == 0) {
            if((v14 & 0x100) == 0) {
                v12_1 = arg38;
                if(v3.changed(v12_1)) {
                    v17 = 0x4000000;
                }
                else {
                    goto label_136;
                }
            }
            else {
                v12_1 = arg38;
            label_136:
                v17 = 0x2000000;
            }

            v4 |= v17;
        }
        else {
            v12_1 = arg38;
        }

        int v0_1 = v14 & 0x200;
        int v1_1 = 0x30000000;
        if(v0_1 != 0) {
            v4 |= v1_1;
        }
        else if((v1_1 & v13) == 0) {
            v17 = v3.changed(arg39) ? 0x20000000 : 0x10000000;
            v4 |= v17;
        }

        int v18 = v0_1;
        v17 = v4;
        boolean v0_2 = (v4 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v0_2, v17 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "386@18343L16,387@18418L14,388@18460L31,389@18569L11");
            v1_1 = 0xF1FFFFFF;
            int v19 = 0xFE3FFFFF;
            int v20 = 0xFFC7FFFF;
            int v21 = 0xFFF8FFFF;
            if((v13 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v6_1 = Modifier.Companion;
                }

                if(v7 != 0) {
                    v8 = true;
                }

                v5 = 6;
                if((v14 & 0x20) != 0) {
                    v9_1 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(v3, v5);
                    v17 &= v21;
                }

                if((v14 & 0x40) != 0) {
                    v10_1 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v3, v5);
                    v17 &= v20;
                }

                if((v14 & 0x80) != 0) {
                    v20_1 = ColorSchemeKt.contentColorFor-ek8zF_U(v10_1, v3, v17 >> 18 & 14);
                    v17 &= v19;
                }
                else {
                    v20_1 = arg36;
                }

                if((v14 & 0x100) != 0) {
                    v12_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v3, 0x6000, 15);
                    v17 &= v1_1;
                }

                if(v18 != 0) {
                    v23 = null;
                    goto label_197;
                }

            label_196:
                v23 = arg39;
            }
            else {
                v3.skipToGroupEnd();
                if((v14 & 0x20) != 0) {
                    v17 &= v21;
                }

                if((v14 & 0x40) != 0) {
                    v17 &= v20;
                }

                if((v14 & 0x80) != 0) {
                    v17 &= v19;
                }

                if((v14 & 0x100) != 0) {
                    v17 &= v1_1;
                }

                v20_1 = arg36;
                goto label_196;
            }

        label_197:
            long v18_1 = v10_1;
            FloatingActionButtonElevation v22 = v12_1;
            v0_1 = v17;
            Shape v17_1 = v9_1;
            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161000600, v0_1, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:391)");
            }

            v1_1 = v0_1 >> 6;
            v0_1 >>= 9;
            Modifier v16_1 = v6;
            FloatingActionButtonKt.FloatingActionButton-X-z6DiA(v15, v16_1, v17_1, v18_1, v20_1, v22, v23, ComposableLambdaKt.rememberComposableLambda(0x25BA60EA, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$3(v8, v2, arg28), v3, 54), v3, v1_1 & 0x70 | (v1_1 & 14 | v40) | v0_1 & 0x380 | v0_1 & 0x1C00 | 0xE000 & v0_1 | 0x70000 & v0_1 | v0_1 & 0x380000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_1 = v8;
            v4_1 = v16_1;
            v6_2 = v17_1;
            v7_1 = v18_1;
            v9_2 = v20_1;
            v11 = v22;
            v12_2 = v23;
        }
        else {
            v3.skipToGroupEnd();
            v4_1 = v6;
            v5_1 = v8;
            v6_2 = v9_1;
            v7_1 = v10_1;
            v11 = v12_1;
            v9_2 = arg36;
            v12_2 = arg39;
        }

        ScopeUpdateScope v15_1 = v3.endRestartGroup();
        if(v15_1 != null) {
            v15_1.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda0(arg28, v2, arg30, v4_1, v5_1, v6_2, v7_1, v9_2, v11, v12_2, v13, v14));
        }
    }

    public static final void ExtendedFloatingActionButton-X-z6DiA(Function0 arg28, Modifier arg29, Shape arg30, long arg31, long arg33, FloatingActionButtonElevation arg35, MutableInteractionSource arg36, Function3 arg37, Composer arg38, int arg39, int arg40) {
        MutableInteractionSource v9_1;
        FloatingActionButtonElevation v8;
        long v6_1;
        long v4_2;
        Shape v3_1;
        Modifier v2_2;
        Composer v23;
        long v16_1;
        Shape v15;
        int v3;
        long v18_1;
        FloatingActionButtonElevation v20;
        MutableInteractionSource v21;
        Companion v14_2;
        Companion v29;
        long v22;
        Modifier v0_4;
        int v17;
        int v9;
        FloatingActionButtonElevation v5_1;
        long v14;
        long v7;
        int v5;
        Shape v4_1;
        int v4;
        Function0 v13;
        int v1;
        Function3 v10 = arg37;
        int v11 = arg39;
        int v12 = arg40;
        Composer v6 = arg38.startRestartGroup(1039585610);
        ComposerKt.sourceInformation(v6, "C(ExtendedFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)329@15450L335,321@15187L598:FloatingActionButton.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg28;
        }
        else {
            v13 = arg28;
            if((v11 & 6) == 0) {
                v1 = v6.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
        }
        else if((v11 & 0x30) == 0) {
            v4 = v6.changed(arg29) ? 0x20 : 16;
            v1 |= v4;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v4_1 = arg30;
                if(v6.changed(v4_1)) {
                    v5 = 0x100;
                }
                else {
                    goto label_49;
                }
            }
            else {
                v4_1 = arg30;
            label_49:
                v5 = 0x80;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg30;
        }

        if((v11 & 0xC00) == 0) {
            v7 = arg31;
            v5 = (v12 & 8) != 0 || !v6.changed(v7) ? 0x400 : 0x800;
            v1 |= v5;
        }
        else {
            v7 = arg31;
        }

        if((v11 & 0x6000) == 0) {
            v14 = arg33;
            v5 = (v12 & 16) != 0 || !v6.changed(v14) ? 0x2000 : 0x4000;
            v1 |= v5;
        }
        else {
            v14 = arg33;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v5_1 = arg35;
                if(v6.changed(v5_1)) {
                    v9 = 0x20000;
                }
                else {
                    goto label_90;
                }
            }
            else {
                v5_1 = arg35;
            label_90:
                v9 = 0x10000;
            }

            v1 |= v9;
        }
        else {
            v5_1 = arg35;
        }

        v9 = v12 & 0x40;
        int v16 = 0x180000;
        if(v9 != 0) {
            v1 |= v16;
        }
        else {
            MutableInteractionSource v0 = arg36;
            if((v11 & v16) == 0) {
                v17 = v6.changed(v0) ? 0x100000 : 0x80000;
                v1 |= v17;
            }
        }

        v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            int v0_1 = v6.changedInstance(v10) ? 0x800000 : 0x400000;
            v1 |= v0_1;
        }

        int v38 = v2;
        boolean v0_2 = (0x492493 & v1) != 4793490 ? true : false;
        if(v6.shouldExecute(v0_2, v1 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "314@14837L16,315@14912L14,316@14954L31,317@15063L11");
            int v18 = 0xFFF8FFFF;
            v2 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v38 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_4 = arg29;
                }

                v38 = v2;
                v2 = 6;
                if((v12 & 4) != 0) {
                    v4_1 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(v6, v2);
                    v1 &= -897;
                }

                Shape v19 = v4_1;
                if((v12 & 8) != 0) {
                    v7 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v6, v2);
                    v1 &= 0xFFFFE3FF;
                }

                v4 = v1;
                long v1_1 = v7;
                if((v12 & 16) != 0) {
                    v7 = ColorSchemeKt.contentColorFor-ek8zF_U(v1_1, v6, v4 >> 9 & 14);
                    v4 &= v38;
                    v14 = v7;
                }

                int v20_1 = v4;
                if((v12 & 0x20) != 0) {
                    v22 = v1_1;
                    v29 = ((Companion)v0_4);
                    v0_2 = true;
                    v5_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v6, 0x6000, 15);
                    v1 = v20_1 & v18;
                }
                else {
                    v29 = ((Companion)v0_4);
                    v22 = v1_1;
                    v0_2 = true;
                    v1 = v20_1;
                }

                if(v9 != 0) {
                    long v20_2 = v14;
                    v15 = v19;
                    v18_1 = v20_2;
                    v14_2 = v29;
                    v21 = null;
                }
                else {
                    long v2_1 = v14;
                    v15 = v19;
                    v18_1 = v2_1;
                    v14_2 = v29;
                    v21 = arg36;
                }

                v20 = v5_1;
                v2 = v17;
                v16_1 = v22;
                v3 = 1039585610;
            }
            else {
                v6.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v1 &= -897;
                }

                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v18;
                }

                v21 = arg36;
                v0_2 = true;
                v20 = v5_1;
                v18_1 = v14;
                v2 = v17;
                v3 = 1039585610;
                Modifier v14_1 = arg29;
                v15 = v4_1;
                v16_1 = v7;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:320)");
            }

            FloatingActionButtonKt.FloatingActionButton-X-z6DiA(v13, ((Modifier)v14_2), v15, v16_1, v18_1, v20, v21, ComposableLambdaKt.rememberComposableLambda(0xB6739FCC, v0_2, new FloatingActionButtonKt$ExtendedFloatingActionButton$1(v10), v6, 54), v6, v1 & 14 | v2 | v1 & 0x70 | v1 & 0x380 | v1 & 0x1C00 | 0xE000 & v1 | 0x70000 & v1 | v1 & 0x380000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v23 = v6;
            v2_2 = ((Modifier)v14_2);
            v3_1 = v15;
            v4_2 = v16_1;
            v6_1 = v18_1;
            v8 = v20;
            v9_1 = v21;
        }
        else {
            v6.skipToGroupEnd();
            v2_2 = arg29;
            v9_1 = arg36;
            v3_1 = v4_1;
            v23 = v6;
            long v26 = v7;
            v8 = v5_1;
            v4_2 = v26;
            v6_1 = v14;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda6(arg28, v2_2, v3_1, v4_2, v6_1, v8, v9_1, v10, v11, v12));
        }
    }

    private static final void ExtendedFloatingActionButton-qtIzBjc(Function2 arg35, Function2 arg36, Function0 arg37, TextStyle arg38, float arg39, float arg40, float arg41, float arg42, float arg43, Modifier arg44, boolean arg45, Shape arg46, long arg47, long arg49, FloatingActionButtonElevation arg51, MutableInteractionSource arg52, Composer arg53, int arg54, int arg55, int arg56) {
        Modifier v10_2;
        boolean v11;
        long v13;
        Shape v12_2;
        long v15_2;
        MutableInteractionSource v18_2;
        FloatingActionButtonElevation v17_3;
        long v12_1;
        Composer v1_1;
        MutableInteractionSource v15_1;
        FloatingActionButtonElevation v14_1;
        long v10_1;
        Shape v9;
        boolean v18_1;
        Modifier v17_1;
        FloatingActionButtonElevation v0_6;
        long v0_5;
        Companion v17_2;
        Shape v14_2;
        Modifier v0_4;
        long v5;
        int v29;
        int v26;
        int v24;
        float v7;
        int v18;
        int v8;
        int v0 = arg54;
        int v1 = arg55;
        int v2 = arg56;
        Composer v4 = arg53.startRestartGroup(193103278);
        ComposerKt.sourceInformation(v4, "C(ExtendedFloatingActionButton)N(text,icon,onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,startPadding:c#ui.unit.Dp,endPadding:c#ui.unit.Dp,iconPadding:c#ui.unit.Dp,modifier,expanded,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource)463@21128L1923,452@20763L2288:FloatingActionButton.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changedInstance(arg35) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        if((v2 & 2) != 0) {
            v8 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            int v12 = v4.changedInstance(arg36) ? 0x20 : 16;
            v8 |= v12;
        }

        if((v2 & 4) != 0) {
            v8 |= 0x180;
        }
        else if((v0 & 0x180) == 0) {
            int v15 = v4.changedInstance(arg37) ? 0x100 : 0x80;
            v8 |= v15;
        }

        int v16 = 0x400;
        int v17 = 0x800;
        if((v2 & 8) != 0) {
            v8 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v18 = v4.changed(arg38) ? v17 : v16;
            v8 |= v18;
        }

        int v19 = 0x4000;
        int v20 = 0x2000;
        if((v2 & 16) != 0) {
            v8 |= 0x6000;
        }
        else if((v0 & 0x6000) == 0) {
            v18 = v4.changed(arg39) ? v19 : v20;
            v8 |= v18;
        }

        int v21 = 0x20000;
        int v22 = 0x10000;
        int v23 = 0x30000;
        if((v2 & 0x20) != 0) {
            v8 |= v23;
            v7 = arg40;
        }
        else {
            v7 = arg40;
            if((v0 & v23) == 0) {
                v24 = v4.changed(v7) ? v21 : v22;
                v8 |= v24;
            }
        }

        int v25 = 0x180000;
        if((v2 & 0x40) != 0) {
            v8 |= v25;
        }
        else {
            float v10 = arg41;
            if((v0 & v25) == 0) {
                v25 = v4.changed(v10) ? 0x100000 : 0x80000;
                v8 |= v25;
            }
        }

        if((v2 & 0x80) != 0) {
            v8 |= 0xC00000;
        }
        else if((0xC00000 & v0) == 0) {
            v26 = v4.changed(arg42) ? 0x800000 : 0x400000;
            v8 |= v26;
        }

        if((v2 & 0x100) != 0) {
            v8 |= 0x6000000;
        }
        else if((0x6000000 & v0) == 0) {
            int v27 = v4.changed(arg43) ? 0x4000000 : 0x2000000;
            v8 |= v27;
        }

        int v14 = v2 & 0x200;
        int v28 = 0x30000000;
        if(v14 != 0) {
            v8 |= v28;
        }
        else {
            Modifier v3 = arg44;
            if((v0 & v28) == 0) {
                v29 = v4.changed(v3) ? 0x20000000 : 0x10000000;
                v8 |= v29;
            }
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v18 = v1 | 6;
            v29 = v0;
        }
        else if((v1 & 6) == 0) {
            v29 = v0;
            v18 = v4.changed(arg45) ? 4 : 2;
            v18 |= v1;
        }
        else {
            v29 = v0;
            v18 = v1;
        }

        if((v1 & 0x30) == 0) {
            v24 = (v2 & 0x800) != 0 || !v4.changed(arg46) ? 16 : 0x20;
            v18 |= v24;
        }

        if((v1 & 0x180) == 0) {
            v5 = arg47;
            v26 = (v2 & 0x1000) != 0 || !v4.changed(v5) ? 0x80 : 0x100;
            v18 |= v26;
        }

        if((v1 & 0xC00) == 0) {
            v5 = arg49;
            if((v2 & 0x2000) == 0 && (v4.changed(v5))) {
                v16 = v17;
            }

            v18 |= v16;
        }
        else {
            v5 = arg49;
        }

        if((v1 & 0x6000) == 0) {
            if((v2 & 0x4000) != 0 || !v4.changed(arg51)) {
                v19 = v20;
            }
            else {
            }

            v18 |= v19;
        }

        v16 = v2 & 0x8000;
        if(v16 != 0) {
            v18 |= v23;
        }
        else {
            MutableInteractionSource v0_1 = arg52;
            if((v1 & v23) == 0) {
                if(v4.changed(v0_1)) {
                }
                else {
                    v21 = v22;
                }

                v18 |= v21;
            }
        }

        boolean v0_2 = (v8 & 306783379) != 306783378 || (v18 & 74899) != 74898 ? true : false;
        if(v4.shouldExecute(v0_2, v8 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "446@20459L16,447@20534L14,448@20576L31,449@20685L11");
            if((arg54 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v14 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_4 = arg44;
                }

                boolean v1_2 = v29 != 0 ? true : arg45;
                int v3_1 = 6;
                if((v2 & 0x800) != 0) {
                    v14_2 = FloatingActionButtonDefaults.INSTANCE.getExtendedFabShape(v4, v3_1);
                    v18 &= 0xFFFFFF8F;
                }
                else {
                    v14_2 = arg46;
                }

                int v31 = v18;
                if((v2 & 0x1000) != 0) {
                    v17_2 = ((Companion)v0_4);
                    v3_1 = v31 & -897;
                    v18_1 = v1_2;
                    v0_5 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v4, 6);
                }
                else {
                    v17_2 = ((Companion)v0_4);
                    v3_1 = v31;
                    v18_1 = v1_2;
                    v0_5 = arg47;
                }

                if((v2 & 0x2000) != 0) {
                    v5 = ColorSchemeKt.contentColorFor-ek8zF_U(v0_5, v4, v3_1 >> 6 & 14);
                    v3_1 &= 0xFFFFE3FF;
                }
                else {
                    v5 = arg49;
                }

                long v19_1 = v0_5;
                if((v2 & 0x4000) != 0) {
                    v0_6 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v4, 0x6000, 15);
                    v1_1 = v4;
                    v3_1 &= 0xFFFF1FFF;
                }
                else {
                    v1_1 = v4;
                    v0_6 = arg51;
                }

                v15_1 = v16 != 0 ? null : arg52;
                v12_1 = v5;
                v9 = v14_2;
                v10_1 = v19_1;
                v14_1 = v0_6;
                v0 = v3_1;
            }
            else {
                v4.skipToGroupEnd();
                if((v2 & 0x800) != 0) {
                    v18 &= 0xFFFFFF8F;
                }

                v0 = v18;
                if((v2 & 0x1000) != 0) {
                    v0 &= -897;
                }

                if((v2 & 0x2000) != 0) {
                    v0 &= 0xFFFFE3FF;
                }

                if((v2 & 0x4000) != 0) {
                    v0 &= 0xFFFF1FFF;
                }

                v17_1 = arg44;
                v18_1 = arg45;
                v9 = arg46;
                v10_1 = arg47;
                v14_1 = arg51;
                v15_1 = arg52;
                v1_1 = v4;
                v12_1 = v5;
            }

            v1_1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(193103278, v8, v0, "androidx.compose.material3.ExtendedFloatingActionButton (FloatingActionButton.kt:451)");
            }

            float v6 = Dp.Companion.getUnspecified-D9Ej5fM();
            float v3_2 = Dp.Companion.getUnspecified-D9Ej5fM();
            boolean v21_1 = v18_1;
            v16 = v0;
            ComposableLambda v0_7 = ComposableLambdaKt.rememberComposableLambda(0xCEAF0E1C, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5(v18_1, arg39, v7, arg41, arg42, arg36, arg43, arg35), v1_1, 54);
            int v4_1 = v8 >> 6;
            int v5_1 = v16 << 12;
            v18 = v4_1 & 0x70 | (v4_1 & 14 | 0xD80) | v8 >> 15 & 0xE000 | 0x70000 & v5_1 | 0x380000 & v5_1 | 0x1C00000 & v5_1 | 0xE000000 & v5_1 | v5_1 & 0x70000000;
            Modifier v8_1 = v17_1;
            FloatingActionButtonKt.FloatingActionButton-lF-WlFE(arg37, arg38, v6, v3_2, v8_1, v9, v10_1, v12_1, v14_1, v15_1, v0_7, v1_1, v18, 6, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v17_3 = v14_1;
            v18_2 = v15_1;
            v15_2 = v12_1;
            v12_2 = v9;
            v13 = v10_1;
            v11 = v21_1;
            v10_2 = v8_1;
        }
        else {
            v1_1 = v4;
            v1_1.skipToGroupEnd();
            v10_2 = arg44;
            v11 = arg45;
            v12_2 = arg46;
            v13 = arg47;
            v15_2 = arg49;
            v17_3 = arg51;
            v18_2 = arg52;
        }

        ScopeUpdateScope v0_8 = v1_1.endRestartGroup();
        if(v0_8 != null) {
            v0_8.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda7(arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, v10_2, v11, v12_2, v13, v15_2, v17_3, v18_2, arg54, arg55, v2));
        }
    }

    static final Unit ExtendedFloatingActionButton_ElI5_7k$lambda$8(Function2 arg16, Function2 arg17, Function0 arg18, Modifier arg19, boolean arg20, Shape arg21, long arg22, long arg24, FloatingActionButtonElevation arg26, MutableInteractionSource arg27, int arg28, int arg29, Composer arg30, int arg31) {
        FloatingActionButtonKt.ExtendedFloatingActionButton-ElI5-7k(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg24, arg26, arg27, arg30, RecomposeScopeImplKt.updateChangedFlags(arg28 | 1), arg29);
        return Unit.INSTANCE;
    }

    static final Unit ExtendedFloatingActionButton_X_z6DiA$lambda$7(Function0 arg14, Modifier arg15, Shape arg16, long arg17, long arg19, FloatingActionButtonElevation arg21, MutableInteractionSource arg22, Function3 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        FloatingActionButtonKt.ExtendedFloatingActionButton-X-z6DiA(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit ExtendedFloatingActionButton_qtIzBjc$lambda$9(Function2 arg23, Function2 arg24, Function0 arg25, TextStyle arg26, float arg27, float arg28, float arg29, float arg30, float arg31, Modifier arg32, boolean arg33, Shape arg34, long arg35, long arg37, FloatingActionButtonElevation arg39, MutableInteractionSource arg40, int arg41, int arg42, int arg43, Composer arg44, int arg45) {
        FloatingActionButtonKt.ExtendedFloatingActionButton-qtIzBjc(arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg37, arg39, arg40, arg44, RecomposeScopeImplKt.updateChangedFlags(arg41 | 1), RecomposeScopeImplKt.updateChangedFlags(arg42), arg43);
        return Unit.INSTANCE;
    }

    public static final void FloatingActionButton-X-z6DiA(Function0 arg32, Modifier arg33, Shape arg34, long arg35, long arg37, FloatingActionButtonElevation arg39, MutableInteractionSource arg40, Function2 arg41, Composer arg42, int arg43, int arg44) {
        MutableInteractionSource v9_1;
        FloatingActionButtonElevation v8;
        long v6_1;
        long v4_2;
        Shape v3_2;
        Modifier v2_1;
        Composer v26;
        MutableInteractionSource v24;
        long v21;
        long v19;
        FloatingActionButtonElevation v23;
        Shape v18_1;
        int v0_1;
        Companion v17_2;
        Companion v33;
        long v20;
        long v3_1;
        Shape v19_1;
        Companion v0_2;
        MutableInteractionSource v15_1;
        int v14;
        FloatingActionButtonElevation v5_1;
        long v9;
        long v7;
        int v5;
        Shape v4_1;
        Modifier v3;
        Function0 v13;
        int v1;
        int v11 = arg43;
        int v12 = arg44;
        Composer v6 = arg42.startRestartGroup(748201188);
        ComposerKt.sourceInformation(v6, "C(FloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)120@5970L5,118@5884L325:FloatingActionButton.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg32;
        }
        else {
            v13 = arg32;
            if((v11 & 6) == 0) {
                v1 = v6.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg33;
            int v4 = v6.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_37:
            v3 = arg33;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v4_1 = arg34;
                if(v6.changed(v4_1)) {
                    v5 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v4_1 = arg34;
            label_48:
                v5 = 0x80;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg34;
        }

        if((v11 & 0xC00) == 0) {
            v7 = arg35;
            v5 = (v12 & 8) != 0 || !v6.changed(v7) ? 0x400 : 0x800;
            v1 |= v5;
        }
        else {
            v7 = arg35;
        }

        if((v11 & 0x6000) == 0) {
            v9 = arg37;
            v5 = (v12 & 16) != 0 || !v6.changed(v9) ? 0x2000 : 0x4000;
            v1 |= v5;
        }
        else {
            v9 = arg37;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v5_1 = arg39;
                if(v6.changed(v5_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_89;
                }
            }
            else {
                v5_1 = arg39;
            label_89:
                v14 = 0x10000;
            }

            v1 |= v14;
        }
        else {
            v5_1 = arg39;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v1 |= v15;
            goto label_108;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg40;
            int v16 = v6.changed(v15_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_108:
            v15_1 = arg40;
        }

        int v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v6.changedInstance(arg41) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v42 = v2;
        boolean v0 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v6.shouldExecute(v0, v1 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "111@5554L5,112@5618L14,113@5660L31,114@5769L11");
            v17 = 0xFFF8FFFF;
            int v18 = 0xFFFF1FFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v42 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v3;
                }

                if((v12 & 4) != 0) {
                    v1 &= -897;
                    v19_1 = FloatingActionButtonDefaults.INSTANCE.getShape(v6, v2);
                }
                else {
                    v19_1 = v4_1;
                }

                if((v12 & 8) != 0) {
                    v3_1 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v6, v2);
                    v1 &= 0xFFFFE3FF;
                }
                else {
                    v3_1 = v7;
                }

                if((v12 & 16) != 0) {
                    v7 = ColorSchemeKt.contentColorFor-ek8zF_U(v3_1, v6, v1 >> 9 & 14);
                    v1 &= v18;
                    v9 = v7;
                }

                v18 = v1;
                if((v12 & 0x20) != 0) {
                    v20 = v3_1;
                    v33 = v0_2;
                    v0_1 = v2;
                    v5_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v6, 0x6000, 15);
                    v1 = v18 & v17;
                }
                else {
                    v33 = v0_2;
                    v0_1 = v2;
                    v20 = v3_1;
                    v1 = v18;
                }

                if(v14 != 0) {
                    v17_2 = v33;
                    v24 = null;
                    v23 = v5_1;
                }
                else {
                    v17_2 = v33;
                    v23 = v5_1;
                    v24 = v15_1;
                }

                v18_1 = v19_1;
                v19 = v20;
                v21 = v9;
            }
            else {
                v6.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v1 &= -897;
                }

                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v18;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v17;
                }

                v0_1 = v2;
                Modifier v17_1 = v3;
                v18_1 = v4_1;
                v23 = v5_1;
                v19 = v7;
                v21 = v9;
                v24 = v15_1;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(748201188, v1, -1, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:118)");
            }

            v2 = v1 << 9;
            FloatingActionButtonKt.FloatingActionButton-lF-WlFE(v13, TypographyKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont(), v6, v0_1), FabBaselineTokens.INSTANCE.getContainerWidth-D9Ej5fM(), FabBaselineTokens.INSTANCE.getContainerHeight-D9Ej5fM(), ((Modifier)v17_2), v18_1, v19, v21, v23, v24, arg41, v6, v1 & 14 | 0xD80 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000, v1 >> 21 & 14, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v26 = v6;
            v2_1 = ((Modifier)v17_2);
            v3_2 = v18_1;
            v4_2 = v19;
            v6_1 = v21;
            v8 = v23;
            v9_1 = v24;
        }
        else {
            v6.skipToGroupEnd();
            v2_1 = v3;
            v3_2 = v4_1;
            v26 = v6;
            long v30 = v7;
            v8 = v5_1;
            v4_2 = v30;
            v6_1 = v9;
            v9_1 = v15_1;
        }

        ScopeUpdateScope v13_1 = v26.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda5(arg32, v2_1, v3_2, v4_2, v6_1, v8, v9_1, arg41, v11, v12));
        }
    }

    private static final void FloatingActionButton-lF-WlFE(Function0 arg33, TextStyle arg34, float arg35, float arg36, Modifier arg37, Shape arg38, long arg39, long arg41, FloatingActionButtonElevation arg43, MutableInteractionSource arg44, Function2 arg45, Composer arg46, int arg47, int arg48, int arg49) {
        long v9_1;
        long v7_1;
        Shape v6_2;
        Composer v28;
        Modifier v5_2;
        MutableInteractionSource v12_1;
        FloatingActionButtonElevation v11_1;
        FloatingActionButtonKt$$ExternalSyntheticLambda3 v0_3;
        Object v26;
        MutableInteractionSource v0_2;
        Object v0_1;
        MutableInteractionSource v3_1;
        int v10_1;
        long v21_1;
        Shape v18_1;
        FloatingActionButtonElevation v2_1;
        long v19_1;
        Companion v6_1;
        Companion v37;
        long v24;
        long v5_1;
        Shape v21_2;
        Modifier v1_3;
        int v18;
        int v17;
        int v3;
        long v13;
        int v46;
        int v9;
        Shape v8_1;
        Modifier v6;
        float v12;
        float v11;
        int v5;
        Function0 v15;
        int v2;
        int v14 = arg47;
        int v0 = arg49;
        Composer v7 = arg46.startRestartGroup(0x740892C);
        ComposerKt.sourceInformation(v7, "C(FloatingActionButton)N(onClick,textStyle,minWidth:c#ui.unit.Dp,minHeight:c#ui.unit.Dp,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)150@6953L22,155@7158L54,157@7273L330,148@6879L724:FloatingActionButton.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v2 = v14 | 6;
            v15 = arg33;
        }
        else {
            v15 = arg33;
            if((v14 & 6) == 0) {
                v2 = v7.changedInstance(v15) ? 4 : 2;
                v2 |= v14;
            }
            else {
                v2 = v14;
            }
        }

        if((v0 & 2) != 0) {
            v2 |= 0x30;
        }
        else {
            TextStyle v10 = arg34;
            if((v14 & 0x30) == 0) {
                v5 = v7.changed(v10) ? 0x20 : 16;
                v2 |= v5;
            }
        }

        if((v0 & 4) != 0) {
            v2 |= 0x180;
            v11 = arg35;
        }
        else {
            v11 = arg35;
            if((v14 & 0x180) == 0) {
                v5 = v7.changed(v11) ? 0x100 : 0x80;
                v2 |= v5;
            }
        }

        if((v0 & 8) != 0) {
            v2 |= 0xC00;
            v12 = arg36;
        }
        else {
            v12 = arg36;
            if((v14 & 0xC00) == 0) {
                v5 = v7.changed(v12) ? 0x800 : 0x400;
                v2 |= v5;
            }
        }

        v5 = v0 & 16;
        if(v5 != 0) {
            v2 |= 0x6000;
            goto label_79;
        }
        else if((v14 & 0x6000) == 0) {
            v6 = arg37;
            int v8 = v7.changed(v6) ? 0x4000 : 0x2000;
            v2 |= v8;
        }
        else {
        label_79:
            v6 = arg37;
        }

        if((0x30000 & v14) == 0) {
            if((v0 & 0x20) == 0) {
                v8_1 = arg38;
                if(v7.changed(v8_1)) {
                    v9 = 0x20000;
                }
                else {
                    goto label_91;
                }
            }
            else {
                v8_1 = arg38;
            label_91:
                v9 = 0x10000;
            }

            v2 |= v9;
        }
        else {
            v8_1 = arg38;
        }

        if((0x180000 & v14) == 0) {
            v46 = v2;
            long v1 = arg39;
            v9 = (v0 & 0x40) != 0 || !v7.changed(v1) ? 0x80000 : 0x100000;
            v9 |= v46;
        }
        else {
            v9 = v2;
        }

        if((v14 & 0xC00000) == 0) {
            v13 = arg41;
            v3 = (v0 & 0x80) != 0 || !v7.changed(v13) ? 0x400000 : 0x800000;
            v9 |= v3;
        }
        else {
            v13 = arg41;
        }

        if((arg47 & 0x6000000) == 0) {
            v17 = (v0 & 0x100) != 0 || !v7.changed(arg43) ? 0x2000000 : 0x4000000;
            v9 |= v17;
        }

        v3 = v0 & 0x200;
        v17 = 0x30000000;
        if(v3 != 0) {
            v9 |= v17;
            goto label_157;
        }
        else if((arg47 & v17) == 0) {
            v17 = v3;
            v18 = v7.changed(arg44) ? 0x20000000 : 0x10000000;
            v9 |= v18;
        }
        else {
        label_157:
            v17 = v3;
        }

        if((v0 & 0x400) != 0) {
            v3 = arg48 | 6;
        }
        else if((arg48 & 6) == 0) {
            int v19 = v7.changedInstance(arg45) ? 4 : 2;
            v3 = arg48 | v19;
        }
        else {
            v3 = arg48;
        }

        v46 = v3;
        boolean v1_1 = (v9 & 306783379) != 306783378 || (v46 & 3) != 2 ? true : false;
        if(v7.shouldExecute(v1_1, v9 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "139@6428L5,140@6492L14,141@6534L31,142@6643L11");
            v18 = 0xF1FFFFFF;
            v2 = 0xFE3FFFFF;
            int v20 = 0xFFC7FFFF;
            int v21 = 0xFFF8FFFF;
            v3 = 6;
            if((arg47 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v5 != 0) {
                    Companion v1_2 = Modifier.Companion;
                }
                else {
                    v1_3 = v6;
                }

                if((v0 & 0x20) != 0) {
                    v9 &= v21;
                    v21_2 = FloatingActionButtonDefaults.INSTANCE.getShape(v7, v3);
                }
                else {
                    v21_2 = v8_1;
                }

                if((v0 & 0x40) != 0) {
                    v5_1 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v7, v3);
                    v9 &= v20;
                }
                else {
                    v5_1 = arg39;
                }

                if((v0 & 0x80) != 0) {
                    v13 = ColorSchemeKt.contentColorFor-ek8zF_U(v5_1, v7, v9 >> 18 & 14);
                    v9 &= v2;
                }

                v20 = v9;
                if((v0 & 0x100) != 0) {
                    v24 = v5_1;
                    v0 = v46;
                    v37 = ((Companion)v1_3);
                    v1_1 = false;
                    v10_1 = 1;
                    v2_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v7, 0x6000, 15);
                    v9 = v20 & v18;
                }
                else {
                    v0 = v46;
                    v37 = ((Companion)v1_3);
                    v24 = v5_1;
                    v1_1 = false;
                    v10_1 = 1;
                    v2_1 = arg43;
                    v9 = v20;
                }

                if(v17 != 0) {
                    v3_1 = null;
                    v6_1 = v37;
                }
                else {
                    v6_1 = v37;
                    v3_1 = arg44;
                }

                v18_1 = v21_2;
                v19_1 = v24;
                v21_1 = v13;
            }
            else {
                v7.skipToGroupEnd();
                if((v0 & 0x20) != 0) {
                    v9 &= v21;
                }

                if((v0 & 0x40) != 0) {
                    v9 &= v20;
                }

                if((v0 & 0x80) != 0) {
                    v9 &= v2;
                }

                if((v0 & 0x100) != 0) {
                    v9 &= v18;
                }

                v19_1 = arg39;
                v2_1 = arg43;
                v0 = v46;
                v18_1 = v8_1;
                v21_1 = v13;
                v1_1 = false;
                v10_1 = 1;
                v3_1 = arg44;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x740892C, v9, v0, "androidx.compose.material3.FloatingActionButton (FloatingActionButton.kt:145)");
            }

            if(v3_1 == null) {
                v7.startReplaceGroup(0xEF244E0F);
                ComposerKt.sourceInformation(v7, "147@6835L39");
                ComposerKt.sourceInformationMarkerStart(v7, 960707667, "CC(remember):FloatingActionButton.kt#9igjgp");
                v0_1 = v7.rememberedValue();
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v0_2 = InteractionSourceKt.MutableInteractionSource();
                    v7.updateRememberedValue(v0_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v7);
                v7.endReplaceGroup();
                v26 = v0_2;
            }
            else {
                v7.startReplaceGroup(960707016);
                v7.endReplaceGroup();
                MutableInteractionSource v26_1 = v3_1;
            }

            ComposerKt.sourceInformationMarkerStart(v7, 0x39434B02, "CC(remember):FloatingActionButton.kt#9igjgp");
            v0_1 = v7.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                v0_3 = new FloatingActionButtonKt$$ExternalSyntheticLambda3();
                v7.updateRememberedValue(v0_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v7);
            Modifier v16 = SemanticsModifierKt.semantics$default(v6, v1_1, ((Function1)v0_3), v10_1, null);
            v0 = v9 >> 6;
            SurfaceKt.Surface-o_FOJdg(v15, v16, false, v18_1, v19_1, v21_1, v2_1.tonalElevation-D9Ej5fM$material3(), v2_1.shadowElevation$material3(v26, v7, v9 >> 21 & 0x70).getValue().unbox-impl(), null, ((MutableInteractionSource)v26), ComposableLambdaKt.rememberComposableLambda(0x95ED67F7, ((boolean)v10_1), new FloatingActionButtonKt$FloatingActionButton$3(v21_1, arg34, v11, v12, arg45), v7, 54), v7, v9 & 14 | v0 & 0x1C00 | 0xE000 & v0 | v0 & 0x70000, 6, 260);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v11_1 = v2_1;
            v12_1 = v3_1;
            v5_2 = v6;
            v28 = v7;
            v6_2 = v18_1;
            v7_1 = v19_1;
            v9_1 = v21_1;
        }
        else {
            v7.skipToGroupEnd();
            v11_1 = arg43;
            v12_1 = arg44;
            v5_2 = v6;
            v28 = v7;
            v6_2 = v8_1;
            v9_1 = v13;
            v7_1 = arg39;
        }

        ScopeUpdateScope v0_4 = v28.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda4(arg33, arg34, arg35, arg36, v5_2, v6_2, v7_1, v9_1, v11_1, v12_1, arg45, arg47, arg48, arg49));
        }
    }

    static final Unit FloatingActionButton_X_z6DiA$lambda$0(Function0 arg14, Modifier arg15, Shape arg16, long arg17, long arg19, FloatingActionButtonElevation arg21, MutableInteractionSource arg22, Function2 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        FloatingActionButtonKt.FloatingActionButton-X-z6DiA(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit FloatingActionButton_lF_WlFE$lambda$3$lambda$2(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit FloatingActionButton_lF_WlFE$lambda$4(Function0 arg18, TextStyle arg19, float arg20, float arg21, Modifier arg22, Shape arg23, long arg24, long arg26, FloatingActionButtonElevation arg28, MutableInteractionSource arg29, Function2 arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        FloatingActionButtonKt.FloatingActionButton-lF-WlFE(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg26, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    public static final void LargeFloatingActionButton-X-z6DiA(Function0 arg28, Modifier arg29, Shape arg30, long arg31, long arg33, FloatingActionButtonElevation arg35, MutableInteractionSource arg36, Function2 arg37, Composer arg38, int arg39, int arg40) {
        MutableInteractionSource v9_1;
        FloatingActionButtonElevation v8;
        long v6_1;
        long v4_2;
        Shape v3_3;
        Composer v23;
        Modifier v2_1;
        Shape v15_2;
        int v0_1;
        MutableInteractionSource v21;
        long v18;
        long v16_1;
        FloatingActionButtonElevation v20;
        Companion v3_2;
        long v20_1;
        long v1_1;
        int v3_1;
        Shape v18_1;
        Companion v0_2;
        MutableInteractionSource v15_1;
        int v14;
        FloatingActionButtonElevation v5_1;
        long v9;
        long v7;
        int v5;
        Shape v4_1;
        Modifier v3;
        Function0 v13;
        int v1;
        int v11 = arg39;
        int v12 = arg40;
        Composer v6 = arg38.startRestartGroup(0x4BF87D85);
        ComposerKt.sourceInformation(v6, "C(LargeFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)263@12410L441:FloatingActionButton.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg28;
        }
        else {
            v13 = arg28;
            if((v11 & 6) == 0) {
                v1 = v6.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg29;
            int v4 = v6.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_37:
            v3 = arg29;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v4_1 = arg30;
                if(v6.changed(v4_1)) {
                    v5 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v4_1 = arg30;
            label_48:
                v5 = 0x80;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg30;
        }

        if((v11 & 0xC00) == 0) {
            v7 = arg31;
            v5 = (v12 & 8) != 0 || !v6.changed(v7) ? 0x400 : 0x800;
            v1 |= v5;
        }
        else {
            v7 = arg31;
        }

        if((v11 & 0x6000) == 0) {
            v9 = arg33;
            v5 = (v12 & 16) != 0 || !v6.changed(v9) ? 0x2000 : 0x4000;
            v1 |= v5;
        }
        else {
            v9 = arg33;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v5_1 = arg35;
                if(v6.changed(v5_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_89;
                }
            }
            else {
                v5_1 = arg35;
            label_89:
                v14 = 0x10000;
            }

            v1 |= v14;
        }
        else {
            v5_1 = arg35;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v1 |= v15;
            goto label_108;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg36;
            int v16 = v6.changed(v15_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_108:
            v15_1 = arg36;
        }

        int v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v6.changedInstance(arg37) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v38 = v2;
        boolean v0 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v6.shouldExecute(v0, v1 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "256@12075L10,257@12144L14,258@12186L31,259@12295L11");
            v17 = 0xFFF8FFFF;
            v2 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v38 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v3;
                }

                v38 = v2;
                v2 = 6;
                if((v12 & 4) != 0) {
                    v1 &= -897;
                    v18_1 = FloatingActionButtonDefaults.INSTANCE.getLargeShape(v6, v2);
                }
                else {
                    v18_1 = v4_1;
                }

                if((v12 & 8) != 0) {
                    v3_1 = v1 & 0xFFFFE3FF;
                    v1_1 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v6, v2);
                }
                else {
                    v3_1 = v1;
                    v1_1 = v7;
                }

                if((v12 & 16) != 0) {
                    v7 = ColorSchemeKt.contentColorFor-ek8zF_U(v1_1, v6, v3_1 >> 9 & 14);
                    v3_1 &= v38;
                    v9 = v7;
                }

                int v19 = v3_1;
                if((v12 & 0x20) != 0) {
                    v20_1 = v1_1;
                    v5_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v6, 0x6000, 15);
                    v1 = v19 & v17;
                }
                else {
                    v20_1 = v1_1;
                    v1 = v19;
                }

                if(v14 != 0) {
                    v3_2 = v0_2;
                    v15_2 = v18_1;
                    v16_1 = v20_1;
                    v0_1 = 0x4BF87D85;
                    v21 = null;
                    v20 = v5_1;
                }
                else {
                    v3_2 = v0_2;
                    v16_1 = v20_1;
                    v0_1 = 0x4BF87D85;
                    v20 = v5_1;
                    v21 = v15_1;
                    v15_2 = v18_1;
                }

                v18 = v9;
            }
            else {
                v6.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v1 &= -897;
                }

                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v17;
                }

                v20 = v5_1;
                v16_1 = v7;
                v18 = v9;
                v21 = v15_1;
                v0_1 = 0x4BF87D85;
                v15_2 = v4_1;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v1, -1, "androidx.compose.material3.LargeFloatingActionButton (FloatingActionButton.kt:262)");
            }

            FloatingActionButtonKt.FloatingActionButton-X-z6DiA(v13, SizeKt.sizeIn-qDBjuR0$default(v3, FabLargeTokens.INSTANCE.getContainerWidth-D9Ej5fM(), FabLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 0f, 0f, 12, null), v15_2, v16_1, v18, v20, v21, arg37, v6, v1 & 0x1FFFF8E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v3;
            v23 = v6;
            v3_3 = v15_2;
            v4_2 = v16_1;
            v6_1 = v18;
            v8 = v20;
            v9_1 = v21;
        }
        else {
            v6.skipToGroupEnd();
            v2_1 = v3;
            v3_3 = v4_1;
            v23 = v6;
            long v26 = v7;
            v8 = v5_1;
            v4_2 = v26;
            v6_1 = v9;
            v9_1 = v15_1;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda1(arg28, v2_1, v3_3, v4_2, v6_1, v8, v9_1, arg37, v11, v12));
        }
    }

    static final Unit LargeFloatingActionButton_X_z6DiA$lambda$6(Function0 arg14, Modifier arg15, Shape arg16, long arg17, long arg19, FloatingActionButtonElevation arg21, MutableInteractionSource arg22, Function2 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        FloatingActionButtonKt.LargeFloatingActionButton-X-z6DiA(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void SmallFloatingActionButton-X-z6DiA(Function0 arg28, Modifier arg29, Shape arg30, long arg31, long arg33, FloatingActionButtonElevation arg35, MutableInteractionSource arg36, Function2 arg37, Composer arg38, int arg39, int arg40) {
        MutableInteractionSource v9_1;
        FloatingActionButtonElevation v8;
        long v6_1;
        long v4_2;
        Shape v3_3;
        Composer v23;
        Modifier v2_1;
        Shape v15_2;
        int v0_1;
        MutableInteractionSource v21;
        long v18;
        long v16_1;
        FloatingActionButtonElevation v20;
        Companion v3_2;
        long v20_1;
        long v1_1;
        int v3_1;
        Shape v18_1;
        Modifier v0_3;
        MutableInteractionSource v15_1;
        int v14;
        FloatingActionButtonElevation v5_1;
        long v9;
        long v7;
        int v5;
        Shape v4_1;
        Modifier v3;
        Function0 v13;
        int v1;
        int v11 = arg39;
        int v12 = arg40;
        Composer v6 = arg38.startRestartGroup(0x1960339);
        ComposerKt.sourceInformation(v6, "C(SmallFloatingActionButton)N(onClick,modifier,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation,interactionSource,content)208@9786L441:FloatingActionButton.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v13 = arg28;
        }
        else {
            v13 = arg28;
            if((v11 & 6) == 0) {
                v1 = v6.changedInstance(v13) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        int v2 = v12 & 2;
        if(v2 != 0) {
            v1 |= 0x30;
            goto label_37;
        }
        else if((v11 & 0x30) == 0) {
            v3 = arg29;
            int v4 = v6.changed(v3) ? 0x20 : 16;
            v1 |= v4;
        }
        else {
        label_37:
            v3 = arg29;
        }

        if((v11 & 0x180) == 0) {
            if((v12 & 4) == 0) {
                v4_1 = arg30;
                if(v6.changed(v4_1)) {
                    v5 = 0x100;
                }
                else {
                    goto label_48;
                }
            }
            else {
                v4_1 = arg30;
            label_48:
                v5 = 0x80;
            }

            v1 |= v5;
        }
        else {
            v4_1 = arg30;
        }

        if((v11 & 0xC00) == 0) {
            v7 = arg31;
            v5 = (v12 & 8) != 0 || !v6.changed(v7) ? 0x400 : 0x800;
            v1 |= v5;
        }
        else {
            v7 = arg31;
        }

        if((v11 & 0x6000) == 0) {
            v9 = arg33;
            v5 = (v12 & 16) != 0 || !v6.changed(v9) ? 0x2000 : 0x4000;
            v1 |= v5;
        }
        else {
            v9 = arg33;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v5_1 = arg35;
                if(v6.changed(v5_1)) {
                    v14 = 0x20000;
                }
                else {
                    goto label_89;
                }
            }
            else {
                v5_1 = arg35;
            label_89:
                v14 = 0x10000;
            }

            v1 |= v14;
        }
        else {
            v5_1 = arg35;
        }

        v14 = v12 & 0x40;
        int v15 = 0x180000;
        if(v14 != 0) {
            v1 |= v15;
            goto label_108;
        }
        else if((v15 & v11) == 0) {
            v15_1 = arg36;
            int v16 = v6.changed(v15_1) ? 0x100000 : 0x80000;
            v1 |= v16;
        }
        else {
        label_108:
            v15_1 = arg36;
        }

        int v17 = 0xC00000;
        if((v12 & 0x80) != 0) {
            v1 |= v17;
        }
        else if((v11 & v17) == 0) {
            v17 = v6.changedInstance(arg37) ? 0x800000 : 0x400000;
            v1 |= v17;
        }

        int v38 = v2;
        boolean v0 = (v1 & 0x492493) != 4793490 ? true : false;
        if(v6.shouldExecute(v0, v1 & 1)) {
            v6.startDefaults();
            ComposerKt.sourceInformation(v6, "201@9451L10,202@9520L14,203@9562L31,204@9671L11");
            v17 = 0xFFF8FFFF;
            v2 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v6.getDefaultsInvalid())) {
                if(v38 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v3;
                }

                v38 = v2;
                v2 = 6;
                if((v12 & 4) != 0) {
                    v1 &= -897;
                    v18_1 = FloatingActionButtonDefaults.INSTANCE.getSmallShape(v6, v2);
                }
                else {
                    v18_1 = v4_1;
                }

                if((v12 & 8) != 0) {
                    v3_1 = v1 & 0xFFFFE3FF;
                    v1_1 = FloatingActionButtonDefaults.INSTANCE.getContainerColor(v6, v2);
                }
                else {
                    v3_1 = v1;
                    v1_1 = v7;
                }

                if((v12 & 16) != 0) {
                    v7 = ColorSchemeKt.contentColorFor-ek8zF_U(v1_1, v6, v3_1 >> 9 & 14);
                    v3_1 &= v38;
                    v9 = v7;
                }

                int v19 = v3_1;
                if((v12 & 0x20) != 0) {
                    v20_1 = v1_1;
                    v5_1 = FloatingActionButtonDefaults.INSTANCE.elevation-xZ9-QkE(0f, 0f, 0f, 0f, v6, 0x6000, 15);
                    v1 = v19 & v17;
                }
                else {
                    v20_1 = v1_1;
                    v1 = v19;
                }

                if(v14 != 0) {
                    v3_2 = ((Companion)v0_3);
                    v15_2 = v18_1;
                    v16_1 = v20_1;
                    v0_1 = 0x1960339;
                    v21 = null;
                    v20 = v5_1;
                }
                else {
                    v3_2 = ((Companion)v0_3);
                    v16_1 = v20_1;
                    v0_1 = 0x1960339;
                    v20 = v5_1;
                    v21 = v15_1;
                    v15_2 = v18_1;
                }

                v18 = v9;
            }
            else {
                v6.skipToGroupEnd();
                if((v12 & 4) != 0) {
                    v1 &= -897;
                }

                if((v12 & 8) != 0) {
                    v1 &= 0xFFFFE3FF;
                }

                if((v12 & 16) != 0) {
                    v1 &= v2;
                }

                if((v12 & 0x20) != 0) {
                    v1 &= v17;
                }

                v20 = v5_1;
                v16_1 = v7;
                v18 = v9;
                v21 = v15_1;
                v0_1 = 0x1960339;
                v15_2 = v4_1;
            }

            v6.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0_1, v1, -1, "androidx.compose.material3.SmallFloatingActionButton (FloatingActionButton.kt:207)");
            }

            FloatingActionButtonKt.FloatingActionButton-X-z6DiA(v13, SizeKt.sizeIn-qDBjuR0$default(v3, FabSmallTokens.INSTANCE.getContainerWidth-D9Ej5fM(), FabSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 0f, 0f, 12, null), v15_2, v16_1, v18, v20, v21, arg37, v6, v1 & 0x1FFFF8E, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v3;
            v23 = v6;
            v3_3 = v15_2;
            v4_2 = v16_1;
            v6_1 = v18;
            v8 = v20;
            v9_1 = v21;
        }
        else {
            v6.skipToGroupEnd();
            v2_1 = v3;
            v3_3 = v4_1;
            v23 = v6;
            long v26 = v7;
            v8 = v5_1;
            v4_2 = v26;
            v6_1 = v9;
            v9_1 = v15_1;
        }

        ScopeUpdateScope v13_1 = v23.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new FloatingActionButtonKt$$ExternalSyntheticLambda2(arg28, v2_1, v3_3, v4_2, v6_1, v8, v9_1, arg37, v11, v12));
        }
    }

    static final Unit SmallFloatingActionButton_X_z6DiA$lambda$5(Function0 arg14, Modifier arg15, Shape arg16, long arg17, long arg19, FloatingActionButtonElevation arg21, MutableInteractionSource arg22, Function2 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        FloatingActionButtonKt.SmallFloatingActionButton-X-z6DiA(arg14, arg15, arg16, arg17, arg19, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final ExitTransition access$extendedFabCollapseAnimation(Composer arg0, int arg1) {
        return FloatingActionButtonKt.extendedFabCollapseAnimation(arg0, arg1);
    }

    public static final EnterTransition access$extendedFabExpandAnimation(Composer arg0, int arg1) {
        return FloatingActionButtonKt.extendedFabExpandAnimation(arg0, arg1);
    }

    public static final float access$getExtendedFabEndIconPadding$p() {
        return FloatingActionButtonKt.ExtendedFabEndIconPadding;
    }

    public static final float access$getExtendedFabMinimumWidth$p() {
        return FloatingActionButtonKt.ExtendedFabMinimumWidth;
    }

    public static final float access$getExtendedFabStartIconPadding$p() {
        return FloatingActionButtonKt.ExtendedFabStartIconPadding;
    }

    public static final float access$getExtendedFabTextPadding$p() {
        return FloatingActionButtonKt.ExtendedFabTextPadding;
    }

    private static final ExitTransition extendedFabCollapseAnimation(Composer arg8, int arg9) {
        int v1 = -56172201;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(extendedFabCollapseAnimation)797@35053L7,800@35162L7:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.extendedFabCollapseAnimation (FloatingActionButton.kt:795)");
        }

        ExitTransition v9 = EnterExitTransitionKt.fadeOut$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, arg8, 6), 0f, 2, null).plus(EnterExitTransitionKt.shrinkHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, arg8, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return v9;
    }

    private static final EnterTransition extendedFabExpandAnimation(Composer arg8, int arg9) {
        int v1 = 0xD518EA0E;
        ComposerKt.sourceInformationMarkerStart(arg8, v1, "C(extendedFabExpandAnimation)808@35431L7,811@35537L7:FloatingActionButton.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg9, -1, "androidx.compose.material3.extendedFabExpandAnimation (FloatingActionButton.kt:806)");
        }

        EnterTransition v9 = EnterExitTransitionKt.fadeIn$default(MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, arg8, 6), 0f, 2, null).plus(EnterExitTransitionKt.expandHorizontally$default(MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, arg8, 6), Alignment.Companion.getStart(), false, null, 12, null));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg8);
        return v9;
    }
}

