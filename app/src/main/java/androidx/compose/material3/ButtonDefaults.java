package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.BaselineButtonTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010-\u001A\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010-\u001A\u00020.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u0002012\b\b\u0002\u00104\u001A\u000201H\u0007¢\u0006\u0004\b5\u00106J\r\u0010;\u001A\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010;\u001A\u00020.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u0002012\b\b\u0002\u00104\u001A\u000201H\u0007¢\u0006\u0004\b<\u00106J\r\u0010?\u001A\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010?\u001A\u00020.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u0002012\b\b\u0002\u00104\u001A\u000201H\u0007¢\u0006\u0004\b@\u00106J\r\u0010C\u001A\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010C\u001A\u00020.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u0002012\b\b\u0002\u00104\u001A\u000201H\u0007¢\u0006\u0004\bD\u00106J\r\u0010G\u001A\u00020.H\u0007¢\u0006\u0002\u0010/J7\u0010G\u001A\u00020.2\b\b\u0002\u00100\u001A\u0002012\b\b\u0002\u00102\u001A\u0002012\b\b\u0002\u00103\u001A\u0002012\b\b\u0002\u00104\u001A\u000201H\u0007¢\u0006\u0004\bH\u00106JA\u0010K\u001A\u00020L2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010O\u001A\u00020\u00052\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010Q\u001A\u00020\u0005H\u0007¢\u0006\u0004\bR\u0010SJA\u0010T\u001A\u00020L2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010O\u001A\u00020\u00052\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010Q\u001A\u00020\u0005H\u0007¢\u0006\u0004\bU\u0010SJA\u0010V\u001A\u00020L2\b\b\u0002\u0010M\u001A\u00020\u00052\b\b\u0002\u0010N\u001A\u00020\u00052\b\b\u0002\u0010O\u001A\u00020\u00052\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010Q\u001A\u00020\u0005H\u0007¢\u0006\u0004\bW\u0010SJ\u0017\u0010X\u001A\u00020Y2\b\b\u0002\u0010\\\u001A\u00020]H\u0007¢\u0006\u0002\u0010^R\u0010\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000B\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0010\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0010\u0010\u0012\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0013\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000FR\u0010\u0010\u0015\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0016\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000FR\u0013\u0010\u0018\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\u001B\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\u001C\u0010\u001AR\u0013\u0010\u001D\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b\u001E\u0010\u001AR\u0013\u0010\u001F\u001A\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001A\u0004\b \u0010\u001AR\u0011\u0010!\u001A\u00020\"8G¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0011\u0010%\u001A\u00020\"8G¢\u0006\u0006\u001A\u0004\b&\u0010$R\u0011\u0010\'\u001A\u00020\"8G¢\u0006\u0006\u001A\u0004\b(\u0010$R\u0011\u0010)\u001A\u00020\"8G¢\u0006\u0006\u001A\u0004\b*\u0010$R\u0011\u0010+\u001A\u00020\"8G¢\u0006\u0006\u001A\u0004\b,\u0010$R\u0018\u00107\u001A\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b9\u0010:R\u0018\u0010=\u001A\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b>\u0010:R\u0018\u0010A\u001A\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bB\u0010:R\u0018\u0010E\u001A\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bF\u0010:R\u0018\u0010I\u001A\u00020.*\u0002088@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bJ\u0010:R\u0011\u0010X\u001A\u00020Y8G¢\u0006\u0006\u001A\u0004\bZ\u0010[¨\u0006_"}, d2={"Landroidx/compose/material3/ButtonDefaults;", "", "<init>", "()V", "ButtonLeadingSpace", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonTrailingSpace", "ButtonWithIconStartpadding", "SmallStartPadding", "SmallEndPadding", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconContentPadding", "getButtonWithIconContentPadding", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonWithIconHorizontalEndPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "filledTonalShape", "getFilledTonalShape", "outlinedShape", "getOutlinedShape", "textShape", "getTextShape", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "defaultButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3", "textButtonColors", "textButtonColors-ro_MJ88", "defaultTextButtonColors", "getDefaultTextButtonColors$material3", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ButtonDefaults {
    public static final int $stable;
    private static final float ButtonLeadingSpace;
    private static final float ButtonTrailingSpace;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconStartpadding;
    private static final PaddingValues ContentPadding;
    public static final ButtonDefaults INSTANCE;
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float SmallEndPadding;
    private static final float SmallStartPadding;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;

    static {
        ButtonDefaults.INSTANCE = new ButtonDefaults();
        float v0 = BaselineButtonTokens.INSTANCE.getLeadingSpace-D9Ej5fM();
        ButtonDefaults.ButtonLeadingSpace = v0;
        float v1 = BaselineButtonTokens.INSTANCE.getTrailingSpace-D9Ej5fM();
        ButtonDefaults.ButtonTrailingSpace = v1;
        float v3 = Dp.constructor-impl(16f);
        ButtonDefaults.ButtonWithIconStartpadding = v3;
        ButtonDefaults.SmallStartPadding = ButtonSmallTokens.INSTANCE.getLeadingSpace-D9Ej5fM();
        ButtonDefaults.SmallEndPadding = ButtonSmallTokens.INSTANCE.getTrailingSpace-D9Ej5fM();
        float v4 = Dp.constructor-impl(8f);
        ButtonDefaults.ButtonVerticalPadding = v4;
        PaddingValues v0_1 = PaddingKt.PaddingValues-a9UjIt4(v0, v4, v1, v4);
        ButtonDefaults.ContentPadding = v0_1;
        ButtonDefaults.ButtonWithIconContentPadding = PaddingKt.PaddingValues-a9UjIt4(v3, v4, v1, v4);
        v1 = Dp.constructor-impl(12f);
        ButtonDefaults.TextButtonHorizontalPadding = v1;
        ButtonDefaults.TextButtonContentPadding = PaddingKt.PaddingValues-a9UjIt4(v1, v0_1.calculateTopPadding-D9Ej5fM(), v1, v0_1.calculateBottomPadding-D9Ej5fM());
        float v2 = Dp.constructor-impl(16f);
        ButtonDefaults.TextButtonWithIconHorizontalEndPadding = v2;
        ButtonDefaults.TextButtonWithIconContentPadding = PaddingKt.PaddingValues-a9UjIt4(v1, v0_1.calculateTopPadding-D9Ej5fM(), v2, v0_1.calculateBottomPadding-D9Ej5fM());
        ButtonDefaults.MinWidth = Dp.constructor-impl(58f);
        ButtonDefaults.MinHeight = ButtonSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        ButtonDefaults.IconSize = Dp.constructor-impl(18f);
        ButtonDefaults.IconSpacing = ButtonSmallTokens.INSTANCE.getIconLabelSpace-D9Ej5fM();
    }

    private ButtonDefaults() {
        super();
    }

    public final ButtonColors buttonColors(Composer arg4, int arg5) {
        int v1 = 0x5661C77D;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(buttonColors)572@26919L11:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:572)");
        }

        ButtonColors v3 = this.getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ButtonColors buttonColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = -339300779;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(buttonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)590@27725L11:Button.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:590)");
        }

        ButtonColors v12 = this.getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }

    public final ButtonElevation buttonElevation-R_JCAzs(float arg9, float arg10, float arg11, float arg12, float arg13, Composer arg14, int arg15, int arg16) {
        int v0 = 0x6CF1E157;
        ComposerKt.sourceInformationMarkerStart(arg14, v0, "C(buttonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if((arg16 & 1) != 0) {
            arg9 = FilledButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v2 = arg9;
        if((arg16 & 2) != 0) {
            arg10 = FilledButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v3 = arg10;
        if((arg16 & 4) != 0) {
            arg11 = FilledButtonTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
        }

        float v4 = arg11;
        if((arg16 & 8) != 0) {
            arg12 = FilledButtonTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
        }

        float v5 = arg12;
        if((arg16 & 16) != 0) {
            arg13 = FilledButtonTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
        }

        float v6 = arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg15, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:811)");
        }

        ButtonElevation v1 = new ButtonElevation(v2, v3, v4, v5, v6, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v1;
    }

    public final ButtonColors elevatedButtonColors(Composer arg4, int arg5) {
        int v1 = 2025043443;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(elevatedButtonColors)617@29043L11:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:617)");
        }

        ButtonColors v3 = this.getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ButtonColors elevatedButtonColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = 0x59E0DB1F;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(elevatedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)635@29902L11:Button.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:635)");
        }

        ButtonColors v12 = this.getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }

    public final ButtonElevation elevatedButtonElevation-R_JCAzs(float arg9, float arg10, float arg11, float arg12, float arg13, Composer arg14, int arg15, int arg16) {
        int v0 = 0x3F81F8CD;
        ComposerKt.sourceInformationMarkerStart(arg14, v0, "C(elevatedButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if((arg16 & 1) != 0) {
            arg9 = ElevatedButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v2 = arg9;
        if((arg16 & 2) != 0) {
            arg10 = ElevatedButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v3 = arg10;
        if((arg16 & 4) != 0) {
            arg11 = ElevatedButtonTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
        }

        float v4 = arg11;
        if((arg16 & 8) != 0) {
            arg12 = ElevatedButtonTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
        }

        float v5 = arg12;
        if((arg16 & 16) != 0) {
            arg13 = ElevatedButtonTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM();
        }

        float v6 = arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg15, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:838)");
        }

        ButtonElevation v1 = new ButtonElevation(v2, v3, v4, v5, v6, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v1;
    }

    public final ButtonColors filledTonalButtonColors(Composer arg4, int arg5) {
        int v1 = 0x312C50BD;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(filledTonalButtonColors)663@31274L11:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:663)");
        }

        ButtonColors v3 = this.getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ButtonColors filledTonalButtonColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = 1670757653;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(filledTonalButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)682@32163L11:Button.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:682)");
        }

        ButtonColors v12 = this.getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }

    public final ButtonElevation filledTonalButtonElevation-R_JCAzs(float arg9, float arg10, float arg11, float arg12, float arg13, Composer arg14, int arg15, int arg16) {
        int v0 = 0x5B4A97;
        ComposerKt.sourceInformationMarkerStart(arg14, v0, "C(filledTonalButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if((arg16 & 1) != 0) {
            arg9 = FilledTonalButtonTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v2 = arg9;
        if((arg16 & 2) != 0) {
            arg10 = FilledTonalButtonTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v3 = arg10;
        if((arg16 & 4) != 0) {
            arg11 = FilledTonalButtonTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
        }

        float v4 = arg11;
        if((arg16 & 8) != 0) {
            arg12 = FilledTonalButtonTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
        }

        float v5 = arg12;
        if((arg16 & 16) != 0) {
            arg13 = Dp.constructor-impl(0f);
        }

        float v6 = arg13;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg15, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:868)");
        }

        ButtonElevation v1 = new ButtonElevation(v2, v3, v4, v5, v6, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg14);
        return v1;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonDefaults.ButtonWithIconContentPadding;
    }

    public final PaddingValues getContentPadding() {
        return ButtonDefaults.ContentPadding;
    }

    public final ButtonColors getDefaultButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        ButtonColors v1 = v0.getDefaultButtonColorsCached$material3();
        if(v1 == null) {
            ButtonColors v2 = new ButtonColors(ColorSchemeKt.fromToken(v0, FilledButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledButtonTokens.INSTANCE.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), FilledButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), FilledButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        ButtonColors v1 = v0.getDefaultElevatedButtonColorsCached$material3();
        if(v1 == null) {
            ButtonColors v2 = new ButtonColors(ColorSchemeKt.fromToken(v0, ElevatedButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, ElevatedButtonTokens.INSTANCE.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultElevatedButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        ButtonColors v1 = v0.getDefaultFilledTonalButtonColorsCached$material3();
        if(v1 == null) {
            ButtonColors v2 = new ButtonColors(ColorSchemeKt.fromToken(v0, FilledTonalButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(v0, FilledTonalButtonTokens.INSTANCE.getLabelTextColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultFilledTonalButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        ButtonColors v1 = v0.getDefaultOutlinedButtonColorsCached$material3();
        if(v1 == null) {
            ButtonColors v2 = new ButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, OutlinedButtonTokens.INSTANCE.getLabelTextColor()), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultOutlinedButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final ButtonColors getDefaultTextButtonColors$material3(ColorScheme arg18) {
        ColorScheme v0 = arg18;
        ButtonColors v1 = v0.getDefaultTextButtonColorsCached$material3();
        if(v1 == null) {
            ButtonColors v2 = new ButtonColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, ColorSchemeKeyTokens.Primary), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, TextButtonTokens.INSTANCE.getDisabledLabelColor()), TextButtonTokens.INSTANCE.getDisabledLabelOpacity(), 0f, 0f, 0f, 14, null), null);
            v0.setDefaultTextButtonColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final Shape getElevatedShape(Composer arg3, int arg4) {
        int v0 = 0x7FCA3707;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-elevatedShape>)554@26279L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:554)");
        }

        Shape v2 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getFilledTonalShape(Composer arg3, int arg4) {
        int v0 = 0xCB27C965;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-filledTonalShape>)558@26436L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:558)");
        }

        Shape v2 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final float getIconSize-D9Ej5fM() {
        return ButtonDefaults.IconSize;
    }

    public final float getIconSpacing-D9Ej5fM() {
        return ButtonDefaults.IconSpacing;
    }

    public final float getMinHeight-D9Ej5fM() {
        return ButtonDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return ButtonDefaults.MinWidth;
    }

    @Deprecated(message="Please use the version that takes an `enabled` param to get the `BorderStroke` with the correct opacity", replaceWith="<_subannotation>") public final BorderStroke getOutlinedButtonBorder(Composer arg3, int arg4) {
        int v0 = 0xDE62B058;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-outlinedButtonBorder>)888@42276L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:886)");
        }

        BorderStroke v2 = BorderStrokeKt.BorderStroke-cXLIe8U(ButtonSmallTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), arg3, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getOutlinedShape(Composer arg3, int arg4) {
        int v0 = -2045213065;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-outlinedShape>)562@26587L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:562)");
        }

        Shape v2 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0xB66491F3;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)550@26128L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:550)");
        }

        Shape v2 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final PaddingValues getTextButtonContentPadding() {
        return ButtonDefaults.TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return ButtonDefaults.TextButtonWithIconContentPadding;
    }

    public final Shape getTextShape(Composer arg3, int arg4) {
        int v0 = 0xEB30D3CD;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-textShape>)566@26729L5:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:566)");
        }

        Shape v2 = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final BorderStroke outlinedButtonBorder(boolean arg9, Composer arg10, int arg11, int arg12) {
        long v11;
        int v0 = 0xDAA2F491;
        ComposerKt.sourceInformationMarkerStart(arg10, v0, "C(outlinedButtonBorder)N(enabled):Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg11, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:898)");
        }

        float v8 = ButtonSmallTokens.INSTANCE.getOutlinedOutlineWidth-D9Ej5fM();
        arg11 = 6;
        if(1 != 0) {
            arg10.startReplaceGroup(0xF94DB8C2);
            ComposerKt.sourceInformation(arg10, "902@42706L5");
            v11 = ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), arg10, arg11);
            arg10.endReplaceGroup();
        }
        else {
            arg10.startReplaceGroup(0xF94F0EF8);
            ComposerKt.sourceInformation(arg10, "904@42791L5");
            v11 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), arg10, arg11), OutlinedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null);
            arg10.endReplaceGroup();
        }

        BorderStroke v8_1 = BorderStrokeKt.BorderStroke-cXLIe8U(v8, v11);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v8_1;
    }

    public final ButtonColors outlinedButtonColors(Composer arg4, int arg5) {
        int v1 = 0xAFD6A83B;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(outlinedButtonColors)709@33555L11:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:709)");
        }

        ButtonColors v3 = this.getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ButtonColors outlinedButtonColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = 0x95FDD7D7;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(outlinedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)727@34414L11:Button.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:727)");
        }

        ButtonColors v12 = this.getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }

    public final ButtonColors textButtonColors(Composer arg4, int arg5) {
        int v1 = 0x7013BC50;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(textButtonColors)752@35580L11:Button.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:752)");
        }

        ButtonColors v3 = this.getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final ButtonColors textButtonColors-ro_MJ88(long arg13, long arg15, long arg17, long arg19, Composer arg21, int arg22, int arg23) {
        Composer v0 = arg21;
        int v2 = 0xAC6AFC22;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(textButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)770@36410L11:Button.kt#uh7d8r");
        if((arg23 & 1) != 0) {
            arg13 = Color.Companion.getUnspecified-0d7_KjU();
        }

        long v4 = arg13;
        long v6 = (arg23 & 2) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg15;
        long v8 = (arg23 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg17;
        long v10 = (arg23 & 8) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg19;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg22, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:770)");
        }

        ButtonColors v12 = this.getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v12;
    }
}

