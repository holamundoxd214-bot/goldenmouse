package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0017\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u0018\u0010\u0016JK\u0010\u0019\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u000F2\b\b\u0002\u0010\u0013\u001A\u00020\u000F2\b\b\u0002\u0010\u0014\u001A\u00020\u000FH\u0007¢\u0006\u0004\b\u001A\u0010\u0016J\r\u0010\u001B\u001A\u00020\u001CH\u0007¢\u0006\u0002\u0010\u001DJ7\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010!\u001A\u00020\u001F2\b\b\u0002\u0010\"\u001A\u00020\u001FH\u0007¢\u0006\u0004\b#\u0010$J\r\u0010)\u001A\u00020\u001CH\u0007¢\u0006\u0002\u0010\u001DJ7\u0010)\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010!\u001A\u00020\u001F2\b\b\u0002\u0010\"\u001A\u00020\u001FH\u0007¢\u0006\u0004\b*\u0010$J\r\u0010-\u001A\u00020\u001CH\u0007¢\u0006\u0002\u0010\u001DJ7\u0010-\u001A\u00020\u001C2\b\b\u0002\u0010\u001E\u001A\u00020\u001F2\b\b\u0002\u0010 \u001A\u00020\u001F2\b\b\u0002\u0010!\u001A\u00020\u001F2\b\b\u0002\u0010\"\u001A\u00020\u001FH\u0007¢\u0006\u0004\b.\u0010$J\u0017\u00101\u001A\u0002022\b\b\u0002\u00103\u001A\u000204H\u0007¢\u0006\u0002\u00105R\u0011\u0010\u0004\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001A\u00020\u00058G¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0007R\u0018\u0010%\u001A\u00020\u001C*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u0018\u0010+\u001A\u00020\u001C*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b,\u0010(R\u0018\u0010/\u001A\u00020\u001C*\u00020&8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b0\u0010(¨\u00066"}, d2={"Landroidx/compose/material3/CardDefaults;", "", "<init>", "()V", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedShape", "getElevatedShape", "outlinedShape", "getOutlinedShape", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "cardColors", "Landroidx/compose/material3/CardColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "defaultCardColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CardDefaults {
    public static final int $stable;
    public static final CardDefaults INSTANCE;

    static {
        CardDefaults.INSTANCE = new CardDefaults();
    }

    private CardDefaults() {
        super();
    }

    public final CardColors cardColors(Composer arg4, int arg5) {
        int v1 = 0x902DFD01;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(cardColors)472@21474L11:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:472)");
        }

        CardColors v3 = this.getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final CardColors cardColors-ro_MJ88(long arg16, long arg18, long arg20, long arg22, Composer arg24, int arg25, int arg26) {
        long v10;
        Composer v0 = arg24;
        int v1 = arg25;
        int v3 = 0xA140E6D5;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(cardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)486@22085L31,490@22291L11:Card.kt#uh7d8r");
        long v4 = (arg26 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg16;
        long v6 = (arg26 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v4, v0, v1 & 14) : arg18;
        long v8 = (arg26 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        if((arg26 & 8) != 0) {
            arg16 = v6;
            v6 = Color.copy-wmQWz5c$default(arg16, 0.38f, 0f, 0f, 0f, 14, null);
            v10 = arg16;
        }
        else {
            v10 = v6;
            v6 = arg22;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:490)");
        }

        CardColors v15 = this.getDefaultCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v10, v8, v6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v15;
    }

    public final CardElevation cardElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0xDDBBBEC9;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(cardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = FilledCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = FilledCardTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = FilledCardTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = FilledCardTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? FilledCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? FilledCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:400)");
        }

        CardElevation v2 = new CardElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final CardColors elevatedCardColors(Composer arg4, int arg5) {
        int v1 = 0x5FF8C177;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(elevatedCardColors)518@23660L11:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:518)");
        }

        CardColors v3 = this.getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final CardColors elevatedCardColors-ro_MJ88(long arg16, long arg18, long arg20, long arg22, Composer arg24, int arg25, int arg26) {
        long v10;
        Composer v0 = arg24;
        int v1 = arg25;
        int v3 = 0x8517D9F;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(elevatedCardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)532@24328L31,536@24534L11:Card.kt#uh7d8r");
        long v4 = (arg26 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg16;
        long v6 = (arg26 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v4, v0, v1 & 14) : arg18;
        long v8 = (arg26 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg20;
        if((arg26 & 8) != 0) {
            arg16 = v6;
            v6 = Color.copy-wmQWz5c$default(arg16, 0.38f, 0f, 0f, 0f, 14, null);
            v10 = arg16;
        }
        else {
            v10 = v6;
            v6 = arg22;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:536)");
        }

        CardColors v15 = this.getDefaultElevatedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v10, v8, v6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v15;
    }

    public final CardElevation elevatedCardElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0x44CC5593;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(elevatedCardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = ElevatedCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        if((arg19 & 2) != 0) {
            arg12 = ElevatedCardTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
        }

        float v4 = arg12;
        if((arg19 & 4) != 0) {
            arg13 = ElevatedCardTokens.INSTANCE.getFocusContainerElevation-D9Ej5fM();
        }

        float v5 = arg13;
        if((arg19 & 8) != 0) {
            arg14 = ElevatedCardTokens.INSTANCE.getHoverContainerElevation-D9Ej5fM();
        }

        float v6 = arg14;
        float v7 = (arg19 & 16) != 0 ? ElevatedCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? ElevatedCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:430)");
        }

        CardElevation v2 = new CardElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }

    public final CardColors getDefaultCardColors$material3(ColorScheme arg20) {
        ColorScheme v0 = arg20;
        CardColors v1 = v0.getDefaultCardColorsCached$material3();
        if(v1 == null) {
            CardColors v2 = new CardColors(ColorSchemeKt.fromToken(v0, FilledCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, FilledCardTokens.INSTANCE.getContainerColor())), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, FilledCardTokens.INSTANCE.getDisabledContainerColor()), FilledCardTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, FilledCardTokens.INSTANCE.getContainerColor())), Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, FilledCardTokens.INSTANCE.getContainerColor())), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultCardColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final CardColors getDefaultElevatedCardColors$material3(ColorScheme arg20) {
        ColorScheme v0 = arg20;
        CardColors v1 = v0.getDefaultElevatedCardColorsCached$material3();
        if(v1 == null) {
            CardColors v2 = new CardColors(ColorSchemeKt.fromToken(v0, ElevatedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, ElevatedCardTokens.INSTANCE.getContainerColor())), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), ElevatedCardTokens.INSTANCE.getDisabledContainerOpacity(), 0f, 0f, 0f, 14, null), ColorSchemeKt.fromToken(v0, ElevatedCardTokens.INSTANCE.getDisabledContainerColor())), Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, ElevatedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultElevatedCardColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final CardColors getDefaultOutlinedCardColors$material3(ColorScheme arg20) {
        ColorScheme v0 = arg20;
        CardColors v1 = v0.getDefaultOutlinedCardColorsCached$material3();
        if(v1 == null) {
            CardColors v2 = new CardColors(ColorSchemeKt.fromToken(v0, OutlinedCardTokens.INSTANCE.getContainerColor()), ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, OutlinedCardTokens.INSTANCE.getContainerColor())), ColorSchemeKt.fromToken(v0, OutlinedCardTokens.INSTANCE.getContainerColor()), Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(v0, ColorSchemeKt.fromToken(v0, OutlinedCardTokens.INSTANCE.getContainerColor())), 0.38f, 0f, 0f, 0f, 14, null), null);
            v0.setDefaultOutlinedCardColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    public final Shape getElevatedShape(Composer arg3, int arg4) {
        int v0 = 0xF80B0287;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-elevatedShape>)374@16691L5:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:374)");
        }

        Shape v2 = ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getOutlinedShape(Composer arg3, int arg4) {
        int v0 = 1095404023;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-outlinedShape>)378@16836L5:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:378)");
        }

        Shape v2 = ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final Shape getShape(Composer arg3, int arg4) {
        int v0 = 0x4B7FB373;
        ComposerKt.sourceInformationMarkerStart(arg3, v0, "C(<get-shape>)370@16546L5:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg4, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:370)");
        }

        Shape v2 = ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), arg3, 6);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg3);
        return v2;
    }

    public final BorderStroke outlinedCardBorder(boolean arg9, Composer arg10, int arg11, int arg12) {
        BorderStroke v12_1;
        long v8_1;
        int v0 = 0xE894436F;
        ComposerKt.sourceInformationMarkerStart(arg10, v0, "C(outlinedCardBorder)N(enabled)622@28587L72:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg11, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:613)");
        }

        int v8 = 6;
        if(1 != 0) {
            arg10.startReplaceGroup(2106932974);
            ComposerKt.sourceInformation(arg10, "616@28316L5");
            v8_1 = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), arg10, v8);
            arg10.endReplaceGroup();
        }
        else {
            arg10.startReplaceGroup(2107012365);
            ComposerKt.sourceInformation(arg10, "618@28399L5,620@28551L5");
            v8_1 = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), arg10, v8), 0.12f, 0f, 0f, 0f, 14, null), ColorSchemeKt.getValue(ElevatedCardTokens.INSTANCE.getContainerColor(), arg10, v8));
            arg10.endReplaceGroup();
        }

        ComposerKt.sourceInformationMarkerStart(arg10, 345070519, "CC(remember):Card.kt#9igjgp");
        boolean v11 = arg10.changed(v8_1);
        Object v12 = arg10.rememberedValue();
        if((v11) || v12 == Composer.Companion.getEmpty()) {
            v12_1 = BorderStrokeKt.BorderStroke-cXLIe8U(OutlinedCardTokens.INSTANCE.getOutlineWidth-D9Ej5fM(), v8_1);
            arg10.updateRememberedValue(v12_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg10);
        return v12_1;
    }

    public final CardColors outlinedCardColors(Composer arg4, int arg5) {
        int v1 = -1204388929;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(outlinedCardColors)567@26053L11:Card.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:567)");
        }

        CardColors v3 = this.getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(arg4, 6));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return v3;
    }

    public final CardColors outlinedCardColors-ro_MJ88(long arg18, long arg20, long arg22, long arg24, Composer arg26, int arg27, int arg28) {
        Composer v0 = arg26;
        int v1 = arg27;
        int v3 = -1112362409;
        ComposerKt.sourceInformationMarkerStart(v0, v3, "C(outlinedCardColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)581@26721L31,583@26851L31,585@26946L11:Card.kt#uh7d8r");
        long v4 = (arg28 & 1) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg18;
        long v6 = (arg28 & 2) != 0 ? ColorSchemeKt.contentColorFor-ek8zF_U(v4, v0, v1 & 14) : arg20;
        long v8 = (arg28 & 4) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg22;
        long v10 = (arg28 & 8) != 0 ? Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-ek8zF_U(v4, v0, v1 & 14), 0.38f, 0f, 0f, 0f, 14, null) : arg24;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v3, v1, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:585)");
        }

        CardColors v1_1 = this.getDefaultOutlinedCardColors$material3(MaterialTheme.INSTANCE.getColorScheme(v0, 6)).copy-jRlVdoo(v4, v6, v8, v10);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v1_1;
    }

    public final CardElevation outlinedCardElevation-aqJV_2Y(float arg11, float arg12, float arg13, float arg14, float arg15, float arg16, Composer arg17, int arg18, int arg19) {
        int v0 = 0xFA2D8A4B;
        Composer v1 = arg17;
        ComposerKt.sourceInformationMarkerStart(v1, v0, "C(outlinedCardElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,draggedElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Card.kt#uh7d8r");
        if((arg19 & 1) != 0) {
            arg11 = OutlinedCardTokens.INSTANCE.getContainerElevation-D9Ej5fM();
        }

        float v3 = arg11;
        float v4 = (arg19 & 2) != 0 ? v3 : arg12;
        float v5 = (arg19 & 4) != 0 ? v3 : arg13;
        float v6 = (arg19 & 8) != 0 ? v3 : arg14;
        float v7 = (arg19 & 16) != 0 ? OutlinedCardTokens.INSTANCE.getDraggedContainerElevation-D9Ej5fM() : arg15;
        float v8 = (arg19 & 0x20) != 0 ? OutlinedCardTokens.INSTANCE.getDisabledContainerElevation-D9Ej5fM() : arg16;
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg18, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:459)");
        }

        CardElevation v2 = new CardElevation(v3, v4, v5, v6, v7, v8, null);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v1);
        return v2;
    }
}

