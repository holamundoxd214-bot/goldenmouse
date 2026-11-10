package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.tokens.TypographyTokensKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation$Clickable;
import androidx.compose.ui.text.LinkAnnotation$Url;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u009C\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AÛ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001D2\u0016\b\u0002\u0010\u001F\u001A\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b$\u0010%\u001Aï\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020&2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001D2\u0014\b\u0002\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b*\u0010+\u001AÏ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001D2\u0016\b\u0002\u0010\u001F\u001A\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0001\u0018\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b,\u0010-\u001Aã\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020&2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\b\b\u0002\u0010\u001E\u001A\u00020\u001D2\u0014\b\u0002\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b.\u0010/\u001AÃ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\u0014\b\u0002\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b0\u00101\u001AÙ\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020&2\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u000B2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u000B2\b\b\u0002\u0010\u0018\u001A\u00020\u00192\b\b\u0002\u0010\u001A\u001A\u00020\u001B2\b\b\u0002\u0010\u001C\u001A\u00020\u001D2\u0014\b\u0002\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020)0(2\u0014\b\u0002\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010 2\b\b\u0002\u0010\"\u001A\u00020#H\u0007¢\u0006\u0004\b,\u00102\u001A(\u00107\u001A\u00020\u00012\u0006\u00108\u001A\u00020#2\u0011\u00109\u001A\r\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\b;H\u0007¢\u0006\u0002\u0010<\u001A\u0018\u0010=\u001A\u00020&2\u0006\u0010\u0002\u001A\u00020&2\u0006\u0010>\u001A\u00020?H\u0002\u001A\r\u0010@\u001A\u00020?H\u0003¢\u0006\u0002\u0010A\"\u0017\u00103\u001A\b\u0012\u0004\u0012\u00020#04¢\u0006\b\n\u0000\u001A\u0004\b5\u00106¨\u0006B"}, d2={"Text", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Landroidx/compose/ui/text/TextStyle;", "Text-Nvy7gAk", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "Text-Z58ophY", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/text/TextAutoSize;JLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createTextWithLinkStyles", "linkStyles", "Landroidx/compose/ui/text/TextLinkStyles;", "rememberTextLinkStyles", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextLinkStyles;", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TextKt {
    private static final ProvidableCompositionLocal LocalTextStyle;

    static {
        TextKt.LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new TextKt$$ExternalSyntheticLambda0());
    }

    static final TextStyle LocalTextStyle$lambda$19() {
        return TypographyTokensKt.getDefaultTextStyle();
    }

    public static final void ProvideTextStyle(TextStyle arg5, Function2 arg6, Composer arg7, int arg8) {
        int v1;
        int v0 = 0xE9E0CE;
        arg7 = arg7.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg7, "C(ProvideTextStyle)N(value,content)460@19447L7,461@19472L80:Text.kt#uh7d8r");
        if((arg8 & 6) == 0) {
            v1 = arg7.changed(arg5) ? 4 : 2;
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
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:459)");
            }

            ProvidableCompositionLocal v0_1 = TextKt.LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(arg7, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object v2_2 = arg7.consume(v0_1);
            ComposerKt.sourceInformationMarkerEnd(arg7);
            CompositionLocalKt.CompositionLocalProvider(v0_1.provides(((TextStyle)v2_2).merge(arg5)), arg6, arg7, v1 & 0x70 | ProvidedValue.$stable);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_54;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg7.skipToGroupEnd();
        }

    label_54:
        ScopeUpdateScope v7 = arg7.endRestartGroup();
        if(v7 != null) {
            v7.updateScope(new TextKt$$ExternalSyntheticLambda10(arg5, arg6, arg8));
        }
    }

    static final Unit ProvideTextStyle$lambda$20(TextStyle arg0, Function2 arg1, int arg2, Composer arg3, int arg4) {
        TextKt.ProvideTextStyle(arg0, arg1, arg3, RecomposeScopeImplKt.updateChangedFlags(arg2 | 1));
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with minLines instead") public static final void Text--4IGK_g(AnnotatedString arg45, Modifier arg46, long arg47, long arg49, FontStyle arg51, FontWeight arg52, FontFamily arg53, long arg54, TextDecoration arg56, TextAlign arg57, long arg58, int arg60, boolean arg61, int arg62, Map arg63, Function1 arg64, TextStyle arg65, Composer arg66, int arg67, int arg68, int arg69) {
        TextStyle v21_3;
        Function1 v20_2;
        Map v19_1;
        boolean v17_2;
        TextAlign v13_2;
        TextDecoration v12_1;
        long v10_1;
        FontFamily v9_3;
        FontWeight v8_1;
        FontStyle v7_1;
        long v3_1;
        Modifier v2_3;
        Composer v27_1;
        long v14_1;
        FontFamily v13_1;
        FontWeight v12;
        long v6_2;
        boolean v21_1;
        TextStyle v26_1;
        Function1 v25_1;
        Map v24_1;
        long v18_1;
        TextAlign v17_1;
        TextDecoration v16_2;
        long v9_1;
        FontStyle v11_1;
        Companion v5_4;
        Object v25_2;
        Object v1_6;
        TextAlign v47;
        Companion v1_4;
        Function1 v1_1;
        int v20;
        boolean v6_1;
        int v38;
        long v5;
        int v37;
        int v36;
        int v35;
        FontFamily v15;
        int v30;
        FontWeight v14;
        int v25;
        FontStyle v10;
        int v21;
        long v11;
        int v17;
        int v16;
        long v7;
        int v6;
        int v13;
        int v8;
        int v0 = arg67;
        int v1 = arg68;
        int v2 = arg69;
        Composer v4 = arg66.startRestartGroup(0xD620D0F);
        ComposerKt.sourceInformation(v4, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent,onTextLayout,style)419@17929L562:Text.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changed(arg45) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v13 = v4.changed(arg46) ? 0x20 : 16;
            v8 |= v13;
        }

        v13 = v2 & 4;
        if(v13 != 0) {
            v6 = v8 | 0x180;
            v7 = arg47;
        }
        else {
            v16 = v8;
            v7 = arg47;
            if((v0 & 0x180) == 0) {
                v17 = v4.changed(v7) ? 0x100 : 0x80;
                v16 |= v17;
            }

            v6 = v16;
        }

        v16 = v2 & 8;
        int v18 = 0x800;
        int v19 = 0x400;
        if(v16 != 0) {
            v6 |= 0xC00;
            v11 = arg49;
        }
        else {
            v11 = arg49;
            if((v0 & 0xC00) == 0) {
                v21 = v4.changed(v11) ? v18 : v19;
                v6 |= v21;
            }
        }

        v21 = v2 & 16;
        int v22 = 0x4000;
        int v23 = 0x2000;
        if(v21 != 0) {
            v6 |= 0x6000;
            goto label_90;
        }
        else if((v0 & 0x6000) == 0) {
            v10 = arg51;
            v25 = v4.changed(v10) ? v22 : v23;
            v6 |= v25;
        }
        else {
        label_90:
            v10 = arg51;
        }

        v25 = v2 & 0x20;
        int v26 = 0x20000;
        int v27 = 0x10000;
        int v28 = 0x30000;
        if(v25 != 0) {
            v6 |= v28;
            v14 = arg52;
        }
        else {
            v14 = arg52;
            if((v0 & v28) == 0) {
                v30 = v4.changed(v14) ? v26 : v27;
                v6 |= v30;
            }
        }

        v30 = v2 & 0x40;
        int v31 = 0x180000;
        if(v30 != 0) {
            v6 |= v31;
            v15 = arg53;
        }
        else {
            v15 = arg53;
            if((v0 & v31) == 0) {
                int v33 = v4.changed(v15) ? 0x100000 : 0x80000;
                v6 |= v33;
            }
        }

        int v3 = v2 & 0x80;
        int v34 = 0xC00000;
        if(v3 != 0) {
            v6 |= v34;
            goto label_139;
        }
        else if((v0 & v34) == 0) {
            v34 = v6;
            v35 = v4.changed(arg54) ? 0x800000 : 0x400000;
            v34 |= v35;
        }
        else {
        label_139:
            v34 = v6;
        }

        v0 = v2 & 0x100;
        v35 = 0x6000000;
        if(v0 != 0) {
            v34 |= v35;
            goto label_157;
        }
        else if((arg67 & v35) == 0) {
            v35 = v0;
            v36 = v4.changed(arg56) ? 0x4000000 : 0x2000000;
            v34 |= v36;
        }
        else {
        label_157:
            v35 = v0;
        }

        v0 = v2 & 0x200;
        v36 = 0x30000000;
        if(v0 != 0) {
            v34 |= v36;
            v36 = v0;
        }
        else if((arg67 & v36) == 0) {
            v36 = v0;
            v37 = v4.changed(arg57) ? 0x20000000 : 0x10000000;
            v34 |= v37;
        }
        else {
            v36 = v0;
        }

        v0 = v34;
        v34 = v3;
        v3 = v2 & 0x400;
        if(v3 != 0) {
            v17 = v1 | 6;
        }
        else {
            v5 = arg58;
            if((v1 & 6) == 0) {
                v17 = v4.changed(v5) ? 4 : 2;
                v17 |= v1;
            }
            else {
                v17 = v1;
            }
        }

        v37 = v3;
        v3 = v2 & 0x800;
        if(v3 != 0) {
            v17 |= 0x30;
            v38 = v3;
        }
        else if((v1 & 0x30) == 0) {
            v38 = v3;
            int v24 = v4.changed(arg60) ? 0x20 : 16;
            v17 |= v24;
        }
        else {
            v38 = v3;
        }

        v3 = v17;
        int v5_1 = v2 & 0x1000;
        if(v5_1 != 0) {
            v3 |= 0x180;
            goto label_230;
        }
        else if((v1 & 0x180) == 0) {
            v6_1 = arg61;
            int v29 = v4.changed(v6_1) ? 0x100 : 0x80;
            v3 |= v29;
        }
        else {
        label_230:
            v6_1 = arg61;
        }

        v17 = v5_1;
        v5_1 = v2 & 0x2000;
        if(v5_1 != 0) {
            v3 |= 0xC00;
        }
        else {
            v20 = v3;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg62)) {
                }
                else {
                    v18 = v19;
                }

                v3 = v20 | v18;
            }
            else {
                v3 = v20;
            }
        }

        v18 = v5_1;
        v5_1 = v2 & 0x4000;
        if(v5_1 != 0) {
            v3 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            if(v4.changedInstance(arg63)) {
            }
            else {
                v22 = v23;
            }

            v3 |= v22;
        }

        v19 = arg69 & 0x8000;
        if(v19 != 0) {
            v3 |= v28;
        }
        else {
            v20 = v1 & v28;
            v1_1 = arg64;
            if(v20 == 0) {
                if(v4.changedInstance(v1_1)) {
                }
                else {
                    v26 = v27;
                }

                v3 |= v26;
            }
        }

        if((arg68 & v31) == 0) {
            TextStyle v1_2 = arg65;
            v20 = (arg69 & v27) != 0 || !v4.changed(v1_2) ? 0x80000 : 0x100000;
            v3 |= v20;
        }

        boolean v20_1 = true;
        boolean v1_3 = (v0 & 306783379) != 306783378 || (0x92493 & v3) != 0x92492 ? true : false;
        if(v4.shouldExecute(v1_3, v0 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "416@17870L2,417@17912L7");
            if((arg67 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v9 != 0) {
                    v1_4 = Modifier.Companion;
                }
                else {
                    Modifier v1_5 = arg46;
                }

                if(v13 != 0) {
                    v7 = Color.Companion.getUnspecified-0d7_KjU();
                }

                if(v16 != 0) {
                    v11 = TextUnit.Companion.getUnspecified-XSAIIZE();
                }

                TextAlign v2_1 = null;
                if(v21 != 0) {
                    v10 = ((FontStyle)v2_1);
                }

                if(v25 != 0) {
                    v14 = ((FontWeight)v2_1);
                }

                if(v30 != 0) {
                    v15 = ((FontFamily)v2_1);
                }

                long v21_2 = v34 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg54;
                TextDecoration v9_2 = v35 != 0 ? ((TextDecoration)v2_1) : arg56;
                if(v36 != 0) {
                }
                else {
                    v2_1 = arg57;
                }

                long v23_1 = v37 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg58;
                v13 = v38 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg60;
                if(v17 != 0) {
                }
                else {
                    v20_1 = v6_1;
                }

                v6 = v18 != 0 ? 0x7FFFFFFF : arg62;
                Map v5_3 = v5_1 != 0 ? MapsKt.emptyMap() : arg63;
                Companion v46 = v1_4;
                if(v19 != 0) {
                    v47 = v2_1;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x3D1369F1, "CC(remember):Text.kt#9igjgp");
                    v1_6 = v4.rememberedValue();
                    if(v1_6 == Composer.Companion.getEmpty()) {
                        TextKt$$ExternalSyntheticLambda12 v1_7 = new TextKt$$ExternalSyntheticLambda12();
                        v4.updateRememberedValue(v1_7);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v4);
                }
                else {
                    v47 = v2_1;
                    v1_1 = arg64;
                }

                if((arg69 & v27) != 0) {
                    ProvidableCompositionLocal v2_2 = TextKt.LocalTextStyle;
                    Object v48 = v1_6;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v1_6 = v4.consume(((CompositionLocal)v2_2));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v3 &= 0xFFC7FFFF;
                    v17_1 = v47;
                    v25_2 = v48;
                    Object v26_2 = v1_6;
                }
                else {
                    v17_1 = v47;
                    v25_2 = v1_6;
                    v26_1 = arg65;
                }

                v16_2 = v9_2;
                v18_1 = v23_1;
                v24_1 = v5_3;
                v5_4 = v46;
                long v41 = v21_2;
                v22 = v6;
                v6_2 = v7;
                v21_1 = v20_1;
                v20 = v13;
                v13_1 = v15;
                long v43 = v11;
                v11_1 = v10;
                v9_1 = v43;
                v12 = v14;
                v14_1 = v41;
            }
            else {
                v4.skipToGroupEnd();
                if((arg69 & v27) != 0) {
                    v3 &= 0xFFC7FFFF;
                }

                long v16_1 = v11;
                v11_1 = v10;
                v9_1 = v16_1;
                Modifier v5_2 = arg46;
                v16_2 = arg56;
                v17_1 = arg57;
                v18_1 = arg58;
                v20 = arg60;
                v22 = arg62;
                v24_1 = arg63;
                v25_1 = arg64;
                v26_1 = arg65;
                v21_1 = v6_1;
                v6_2 = v7;
                v12 = v14;
                v13_1 = v15;
                v14_1 = arg54;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD620D0F, v0, v3, "androidx.compose.material3.Text (Text.kt:418)");
            }

            v2 = v0 << 3;
            v1 = v0 & 0x3FE | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000;
            v2 = v3 << 3;
            v0 = v0 >> 27 & 14 | v28 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000;
            v2 = v3 << 6;
            v27_1 = v4;
            TextKt.Text-Z58ophY(arg45, ((Modifier)v5_4), v6_2, null, v9_1, v11_1, v12, v13_1, v14_1, v16_2, v17_1, v18_1, v20, v21_1, v22, 1, v24_1, v25_1, v26_1, v27_1, v1, v0 | 0x380000 & v2 | 0x1C00000 & v2 | v2 & 0xE000000, 8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_3 = ((Modifier)v5_4);
            v3_1 = v6_2;
            v5 = v9_1;
            v7_1 = v11_1;
            v8_1 = v12;
            v9_3 = v13_1;
            v10_1 = v14_1;
            v12_1 = v16_2;
            v13_2 = v17_1;
            v14_1 = v18_1;
            v16 = v20;
            v17_2 = v21_1;
            v18 = v22;
            v19_1 = v24_1;
            v20_2 = v25_1;
            v21_3 = v26_1;
        }
        else {
            v27_1 = v4;
            v27_1.skipToGroupEnd();
            v2_3 = arg46;
            v13_2 = arg57;
            v16 = arg60;
            v18 = arg62;
            v19_1 = arg63;
            v20_2 = arg64;
            v21_3 = arg65;
            v17_2 = v6_1;
            v3_1 = v7;
            v7_1 = v10;
            v5 = v11;
            v8_1 = v14;
            v9_3 = v15;
            v10_1 = arg54;
            v12_1 = arg56;
            v14_1 = arg58;
        }

        ScopeUpdateScope v0_1 = v27_1.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new TextKt$$ExternalSyntheticLambda1(arg45, v2_3, v3_1, v5, v7_1, v8_1, v9_3, v10_1, v12_1, v13_2, v14_1, v16, v17_2, v18, v19_1, v20_2, v21_3, arg67, arg68, arg69));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with autoSize instead") public static final void Text--4IGK_g(String arg45, Modifier arg46, long arg47, long arg49, FontStyle arg51, FontWeight arg52, FontFamily arg53, long arg54, TextDecoration arg56, TextAlign arg57, long arg58, int arg60, boolean arg61, int arg62, int arg63, Function1 arg64, TextStyle arg65, Composer arg66, int arg67, int arg68, int arg69) {
        TextStyle v21_3;
        Function1 v20_1;
        boolean v17_2;
        TextDecoration v12_1;
        long v10_1;
        FontFamily v9_3;
        FontWeight v8_1;
        FontStyle v7_1;
        long v3_1;
        Modifier v2_2;
        Composer v26_1;
        long v14_1;
        FontFamily v13_1;
        FontWeight v12;
        long v6_2;
        boolean v21_1;
        TextStyle v25_1;
        Function1 v24_1;
        long v18_1;
        TextAlign v17_1;
        TextDecoration v16_2;
        long v9_1;
        FontStyle v11_1;
        Object v25_2;
        Companion v5_4;
        Function1 v47;
        TextAlign v13_2;
        Companion v1_4;
        int v20;
        boolean v6_1;
        int v38;
        long v5;
        int v37;
        int v36;
        int v35;
        FontFamily v15;
        int v30;
        FontWeight v14;
        int v25;
        FontStyle v10;
        int v21;
        long v11;
        int v17;
        int v16;
        long v7;
        int v6;
        int v13;
        int v8;
        int v0 = arg67;
        int v1 = arg68;
        int v2 = arg69;
        Composer v4 = arg66.startRestartGroup(-2055108902);
        ComposerKt.sourceInformation(v4, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style)283@13704L555:Text.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changed(arg45) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v13 = v4.changed(arg46) ? 0x20 : 16;
            v8 |= v13;
        }

        v13 = v2 & 4;
        if(v13 != 0) {
            v6 = v8 | 0x180;
            v7 = arg47;
        }
        else {
            v16 = v8;
            v7 = arg47;
            if((v0 & 0x180) == 0) {
                v17 = v4.changed(v7) ? 0x100 : 0x80;
                v16 |= v17;
            }

            v6 = v16;
        }

        v16 = v2 & 8;
        int v18 = 0x800;
        int v19 = 0x400;
        if(v16 != 0) {
            v6 |= 0xC00;
            v11 = arg49;
        }
        else {
            v11 = arg49;
            if((v0 & 0xC00) == 0) {
                v21 = v4.changed(v11) ? v18 : v19;
                v6 |= v21;
            }
        }

        v21 = v2 & 16;
        int v22 = 0x4000;
        int v23 = 0x2000;
        if(v21 != 0) {
            v6 |= 0x6000;
            goto label_90;
        }
        else if((v0 & 0x6000) == 0) {
            v10 = arg51;
            v25 = v4.changed(v10) ? v22 : v23;
            v6 |= v25;
        }
        else {
        label_90:
            v10 = arg51;
        }

        v25 = v2 & 0x20;
        int v26 = 0x20000;
        int v27 = 0x30000;
        int v28 = 0x10000;
        if(v25 != 0) {
            v6 |= v27;
            v14 = arg52;
        }
        else {
            v14 = arg52;
            if((v0 & v27) == 0) {
                v30 = v4.changed(v14) ? v26 : v28;
                v6 |= v30;
            }
        }

        v30 = v2 & 0x40;
        int v31 = 0x180000;
        if(v30 != 0) {
            v6 |= v31;
            v15 = arg53;
        }
        else {
            v15 = arg53;
            if((v0 & v31) == 0) {
                int v33 = v4.changed(v15) ? 0x100000 : 0x80000;
                v6 |= v33;
            }
        }

        int v3 = v2 & 0x80;
        int v34 = 0xC00000;
        if(v3 != 0) {
            v6 |= v34;
            goto label_139;
        }
        else if((v0 & v34) == 0) {
            v34 = v6;
            v35 = v4.changed(arg54) ? 0x800000 : 0x400000;
            v34 |= v35;
        }
        else {
        label_139:
            v34 = v6;
        }

        v0 = v2 & 0x100;
        v35 = 0x6000000;
        if(v0 != 0) {
            v34 |= v35;
            goto label_157;
        }
        else if((arg67 & v35) == 0) {
            v35 = v0;
            v36 = v4.changed(arg56) ? 0x4000000 : 0x2000000;
            v34 |= v36;
        }
        else {
        label_157:
            v35 = v0;
        }

        v0 = v2 & 0x200;
        v36 = 0x30000000;
        if(v0 != 0) {
            v34 |= v36;
            v36 = v0;
        }
        else if((arg67 & v36) == 0) {
            v36 = v0;
            v37 = v4.changed(arg57) ? 0x20000000 : 0x10000000;
            v34 |= v37;
        }
        else {
            v36 = v0;
        }

        v0 = v34;
        v34 = v3;
        v3 = v2 & 0x400;
        if(v3 != 0) {
            v17 = v1 | 6;
        }
        else {
            v5 = arg58;
            if((v1 & 6) == 0) {
                v17 = v4.changed(v5) ? 4 : 2;
                v17 |= v1;
            }
            else {
                v17 = v1;
            }
        }

        v37 = v3;
        v3 = v2 & 0x800;
        if(v3 != 0) {
            v17 |= 0x30;
            v38 = v3;
        }
        else if((v1 & 0x30) == 0) {
            v38 = v3;
            int v24 = v4.changed(arg60) ? 0x20 : 16;
            v17 |= v24;
        }
        else {
            v38 = v3;
        }

        v3 = v17;
        int v5_1 = v2 & 0x1000;
        if(v5_1 != 0) {
            v3 |= 0x180;
            goto label_230;
        }
        else if((v1 & 0x180) == 0) {
            v6_1 = arg61;
            int v29 = v4.changed(v6_1) ? 0x100 : 0x80;
            v3 |= v29;
        }
        else {
        label_230:
            v6_1 = arg61;
        }

        v17 = v5_1;
        v5_1 = v2 & 0x2000;
        if(v5_1 != 0) {
            v3 |= 0xC00;
        }
        else {
            v20 = v3;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg62)) {
                }
                else {
                    v18 = v19;
                }

                v3 = v20 | v18;
            }
            else {
                v3 = v20;
            }
        }

        v18 = v5_1;
        v5_1 = v2 & 0x4000;
        if(v5_1 != 0) {
            v3 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            if(v4.changed(arg63)) {
            }
            else {
                v22 = v23;
            }

            v3 |= v22;
        }

        v19 = arg69 & 0x8000;
        if(v19 != 0) {
            v3 |= v27;
        }
        else {
            v20 = v1 & v27;
            Function1 v1_1 = arg64;
            if(v20 == 0) {
                if(v4.changedInstance(v1_1)) {
                }
                else {
                    v26 = v28;
                }

                v3 |= v26;
            }
        }

        if((arg68 & v31) == 0) {
            TextStyle v1_2 = arg65;
            v20 = (arg69 & v28) != 0 || !v4.changed(v1_2) ? 0x80000 : 0x100000;
            v3 |= v20;
        }

        v20 = 1;
        boolean v1_3 = (v0 & 306783379) != 306783378 || (0x92493 & v3) != 0x92492 ? true : false;
        if(v4.shouldExecute(v1_3, v0 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "281@13687L7");
            if((arg67 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v9 != 0) {
                    v1_4 = Modifier.Companion;
                }
                else {
                    Modifier v1_5 = arg46;
                }

                if(v13 != 0) {
                    v7 = Color.Companion.getUnspecified-0d7_KjU();
                }

                if(v16 != 0) {
                    v11 = TextUnit.Companion.getUnspecified-XSAIIZE();
                }

                Function1 v2_1 = null;
                if(v21 != 0) {
                    v10 = ((FontStyle)v2_1);
                }

                if(v25 != 0) {
                    v14 = ((FontWeight)v2_1);
                }

                if(v30 != 0) {
                    v15 = ((FontFamily)v2_1);
                }

                long v21_2 = v34 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg54;
                TextDecoration v9_2 = v35 != 0 ? ((TextDecoration)v2_1) : arg56;
                v13_2 = v36 != 0 ? ((TextAlign)v2_1) : arg57;
                long v23_1 = v37 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg58;
                v16 = v38 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg60;
                if(v17 != 0) {
                    v6_1 = true;
                }

                v17 = v18 != 0 ? 0x7FFFFFFF : arg62;
                if(v5_1 != 0) {
                }
                else {
                    v20 = arg63;
                }

                if(v19 != 0) {
                }
                else {
                    v2_1 = arg64;
                }

                if((arg69 & v28) != 0) {
                    ProvidableCompositionLocal v5_3 = TextKt.LocalTextStyle;
                    Companion v46 = v1_4;
                    v47 = v2_1;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v1_6 = v4.consume(((CompositionLocal)v5_3));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v3 &= 0xFFC7FFFF;
                    v5_4 = v46;
                    v25_2 = v1_6;
                }
                else {
                    v47 = v2_1;
                    v5_4 = v1_4;
                    v25_1 = arg65;
                }

                v18_1 = v23_1;
                v24_1 = v47;
                v23 = v20;
                v20 = v16;
                v16_2 = v9_2;
                long v41 = v21_2;
                v21_1 = v6_1;
                v6_2 = v7;
                v22 = v17;
                v17_1 = v13_2;
                v13_1 = v15;
                long v43 = v11;
                v11_1 = v10;
                v9_1 = v43;
                v12 = v14;
                v14_1 = v41;
            }
            else {
                v4.skipToGroupEnd();
                if((arg69 & v28) != 0) {
                    v3 &= 0xFFC7FFFF;
                }

                long v16_1 = v11;
                v11_1 = v10;
                v9_1 = v16_1;
                Modifier v5_2 = arg46;
                v16_2 = arg56;
                v17_1 = arg57;
                v18_1 = arg58;
                v20 = arg60;
                v22 = arg62;
                v23 = arg63;
                v24_1 = arg64;
                v25_1 = arg65;
                v21_1 = v6_1;
                v6_2 = v7;
                v12 = v14;
                v13_1 = v15;
                v14_1 = arg54;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2055108902, v0, v3, "androidx.compose.material3.Text (Text.kt:283)");
            }

            v2 = v0 << 3;
            v1 = v3 << 3;
            v26_1 = v4;
            TextKt.Text-Nvy7gAk(arg45, ((Modifier)v5_4), v6_2, null, v9_1, v11_1, v12, v13_1, v14_1, v16_2, v17_1, v18_1, v20, v21_1, v22, v23, v24_1, ((TextStyle)v25_2), v26_1, v0 & 14 | 0xC00 | v0 & 0x70 | v0 & 0x380 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000, v0 >> 27 & 14 | v1 & 0x70 | v1 & 0x380 | v1 & 0x1C00 | 0xE000 & v1 | 0x70000 & v1 | 0x380000 & v1 | v1 & 0x1C00000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = ((Modifier)v5_4);
            v3_1 = v6_2;
            v5 = v9_1;
            v7_1 = v11_1;
            v8_1 = v12;
            v9_3 = v13_1;
            v10_1 = v14_1;
            v12_1 = v16_2;
            v13_2 = v17_1;
            v14_1 = v18_1;
            v16 = v20;
            v17_2 = v21_1;
            v18 = v22;
            v19 = v23;
            v20_1 = v24_1;
            v21_3 = ((TextStyle)v25_2);
        }
        else {
            v26_1 = v4;
            v26_1.skipToGroupEnd();
            v2_2 = arg46;
            v13_2 = arg57;
            v16 = arg60;
            v18 = arg62;
            v19 = arg63;
            v20_1 = arg64;
            v21_3 = arg65;
            v17_2 = v6_1;
            v3_1 = v7;
            v7_1 = v10;
            v5 = v11;
            v8_1 = v14;
            v9_3 = v15;
            v10_1 = arg54;
            v12_1 = arg56;
            v14_1 = arg58;
        }

        ScopeUpdateScope v0_1 = v26_1.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new TextKt$$ExternalSyntheticLambda2(arg45, v2_2, v3_1, v5, v7_1, v8_1, v9_3, v10_1, v12_1, v13_2, v14_1, v16, v17_2, v18, v19, v20_1, v21_3, arg67, arg68, arg69));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with autoSize instead") public static final void Text-IbK3jfQ(AnnotatedString arg39, Modifier arg40, long arg41, long arg43, FontStyle arg45, FontWeight arg46, FontFamily arg47, long arg48, TextDecoration arg50, TextAlign arg51, long arg52, int arg54, boolean arg55, int arg56, int arg57, Map arg58, Function1 arg59, TextStyle arg60, Composer arg61, int arg62, int arg63, int arg64) {
        TextStyle v22_1;
        Function1 v21_2;
        Map v20_1;
        boolean v17_2;
        TextAlign v13_2;
        TextDecoration v12_2;
        FontFamily v9_2;
        FontWeight v8_1;
        FontStyle v7_1;
        long v3_1;
        Modifier v2_1;
        Composer v27_1;
        long v18_1;
        long v14_1;
        Modifier v5_2;
        FontFamily v13_1;
        FontWeight v12_1;
        boolean v21_1;
        TextStyle v1_1;
        Map v24_1;
        TextAlign v17_1;
        TextDecoration v16_1;
        long v25_1;
        long v9_1;
        FontStyle v11;
        long v0_6;
        Companion v5_3;
        Object v42;
        Object v0_9;
        TextAlign v41;
        Modifier v0_8;
        Function1 v0_3;
        int v28;
        boolean v5_1;
        int v23;
        int v36;
        int v35;
        int v6;
        long v4;
        int v32;
        FontFamily v14;
        int v29;
        FontWeight v13;
        int v24;
        FontStyle v9;
        int v20;
        long v10;
        int v16;
        long v5;
        int v12;
        int v7;
        int v0 = arg62;
        int v1 = arg63;
        int v2 = arg64;
        Composer v3 = arg61.startRestartGroup(2027001676);
        ComposerKt.sourceInformation(v3, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style)329@15148L594:Text.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v3.changed(arg39) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        int v8 = v2 & 2;
        if(v8 != 0) {
            v7 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v12 = v3.changed(arg40) ? 0x20 : 16;
            v7 |= v12;
        }

        v12 = v2 & 4;
        if(v12 != 0) {
            v7 |= 0x180;
        }
        else {
            v5 = arg41;
            if((v0 & 0x180) == 0) {
                v16 = v3.changed(v5) ? 0x100 : 0x80;
                v7 |= v16;
            }
        }

        v16 = v2 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v7 |= 0xC00;
            v10 = arg43;
        }
        else {
            v10 = arg43;
            if((v0 & 0xC00) == 0) {
                v20 = v3.changed(v10) ? v17 : v18;
                v7 |= v20;
            }
        }

        v20 = v2 & 16;
        int v21 = 0x4000;
        int v22 = 0x2000;
        if(v20 != 0) {
            v7 |= 0x6000;
            goto label_87;
        }
        else if((v0 & 0x6000) == 0) {
            v9 = arg45;
            v24 = v3.changed(v9) ? v21 : v22;
            v7 |= v24;
        }
        else {
        label_87:
            v9 = arg45;
        }

        v24 = v2 & 0x20;
        int v25 = 0x10000;
        int v26 = 0x30000;
        int v27 = 0x20000;
        if(v24 != 0) {
            v7 |= v26;
            v13 = arg46;
        }
        else {
            v13 = arg46;
            if((v0 & v26) == 0) {
                v29 = v3.changed(v13) ? v27 : v25;
                v7 |= v29;
            }
        }

        v29 = v2 & 0x40;
        int v30 = 0x180000;
        if(v29 != 0) {
            v7 |= v30;
            v14 = arg47;
        }
        else {
            v14 = arg47;
            if((v0 & v30) == 0) {
                v32 = v3.changed(v14) ? 0x100000 : 0x80000;
                v7 |= v32;
            }
        }

        int v15 = v2 & 0x80;
        int v33 = 0xC00000;
        if(v15 != 0) {
            v7 |= v33;
        }
        else {
            v4 = arg48;
            if((v0 & v33) == 0) {
                v6 = v3.changed(v4) ? 0x800000 : 0x400000;
                v7 |= v6;
            }
        }

        v6 = v2 & 0x100;
        int v34 = 0x6000000;
        if(v6 != 0) {
            v7 |= v34;
        }
        else {
            v34 &= v0;
            TextDecoration v0_1 = arg50;
            if(v34 == 0) {
                v34 = v3.changed(v0_1) ? 0x4000000 : 0x2000000;
                v7 |= v34;
            }
        }

        v0 = v2 & 0x200;
        v34 = 0x30000000;
        if(v0 != 0) {
            v7 |= v34;
            goto label_166;
        }
        else if((arg62 & v34) == 0) {
            v34 = v0;
            v35 = v3.changed(arg51) ? 0x20000000 : 0x10000000;
            v7 |= v35;
        }
        else {
        label_166:
            v34 = v0;
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v32 = v1 | 6;
        }
        else {
            v4 = arg52;
            if((v1 & 6) == 0) {
                v32 = v3.changed(v4) ? 4 : 2;
                v32 |= v1;
            }
            else {
                v32 = v1;
            }
        }

        v35 = v0;
        v0 = v2 & 0x800;
        if(v0 != 0) {
            v32 |= 0x30;
            v36 = v0;
        }
        else if((v1 & 0x30) == 0) {
            v36 = v0;
            v23 = v3.changed(arg54) ? 0x20 : 16;
            v32 |= v23;
        }
        else {
            v36 = v0;
        }

        v0 = v32;
        int v4_1 = v2 & 0x1000;
        if(v4_1 != 0) {
            v0 |= 0x180;
            goto label_218;
        }
        else if((v1 & 0x180) == 0) {
            v5_1 = arg55;
            v28 = v3.changed(v5_1) ? 0x100 : 0x80;
            v0 |= v28;
        }
        else {
        label_218:
            v5_1 = arg55;
        }

        int v19 = v4_1;
        v4_1 = v2 & 0x2000;
        if(v4_1 != 0) {
            v0 |= 0xC00;
        }
        else {
            v23 = v0;
            if((v1 & 0xC00) == 0) {
                if(v3.changed(arg56)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v23 | v17;
            }
            else {
                v0 = v23;
            }
        }

        v17 = v4_1;
        v4_1 = v2 & 0x4000;
        if(v4_1 != 0) {
            v18 = v0 | 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v3.changed(arg57)) {
                }
                else {
                    v21 = v22;
                }

                v18 |= v21;
            }
        }

        v21 = v2 & 0x8000;
        if(v21 != 0) {
            v18 |= v26;
        }
        else {
            Map v0_2 = arg58;
            if((v1 & v26) == 0) {
                v22 = v3.changedInstance(v0_2) ? v27 : v25;
                v18 |= v22;
            }
        }

        v22 = v2 & v25;
        if(v22 != 0) {
            v18 |= v30;
        }
        else {
            v0_3 = arg59;
            if((v1 & v30) == 0) {
                v23 = v3.changedInstance(v0_3) ? 0x100000 : 0x80000;
                v18 |= v23;
            }
        }

        if((v1 & v33) == 0) {
            TextStyle v0_4 = arg60;
            v23 = (v2 & v27) != 0 || !v3.changed(v0_4) ? 0x400000 : 0x800000;
            v18 |= v23;
        }

        v23 = 1;
        boolean v0_5 = (v7 & 306783379) != 306783378 || (v18 & 0x492493) != 4793490 ? true : false;
        if(v3.shouldExecute(v0_5, v7 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "326@15089L2,327@15131L7");
            if((arg62 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v8 != 0) {
                    Companion v0_7 = Modifier.Companion;
                }
                else {
                    v0_8 = arg40;
                }

                v25_1 = v12 != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg41;
                if(v16 != 0) {
                    v10 = TextUnit.Companion.getUnspecified-XSAIIZE();
                }

                TextAlign v1_2 = null;
                if(v20 != 0) {
                    v9 = ((FontStyle)v1_2);
                }

                if(v24 != 0) {
                    v13 = ((FontWeight)v1_2);
                }

                if(v29 != 0) {
                    v14 = ((FontFamily)v1_2);
                }

                long v15_1 = v15 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg48;
                TextDecoration v6_1 = v6 != 0 ? ((TextDecoration)v1_2) : arg50;
                if(v34 != 0) {
                }
                else {
                    v1_2 = arg51;
                }

                long v28_1 = v35 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
                v8 = v36 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg54;
                if(v19 != 0) {
                    v5_1 = true;
                }

                v12 = v17 != 0 ? 0x7FFFFFFF : arg56;
                if(v4_1 != 0) {
                }
                else {
                    v23 = arg57;
                }

                Map v4_2 = v21 != 0 ? MapsKt.emptyMap() : arg58;
                Companion v40 = ((Companion)v0_8);
                if(v22 != 0) {
                    v41 = v1_2;
                    ComposerKt.sourceInformationMarkerStart(v3, -1966515250, "CC(remember):Text.kt#9igjgp");
                    v0_9 = v3.rememberedValue();
                    if(v0_9 == Composer.Companion.getEmpty()) {
                        TextKt$$ExternalSyntheticLambda8 v0_10 = new TextKt$$ExternalSyntheticLambda8();
                        v3.updateRememberedValue(v0_10);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v3);
                }
                else {
                    v41 = v1_2;
                    v0_3 = arg59;
                }

                if((v2 & v27) != 0) {
                    ProvidableCompositionLocal v1_3 = TextKt.LocalTextStyle;
                    v42 = v0_3;
                    ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v0_9 = v3.consume(((CompositionLocal)v1_3));
                    ComposerKt.sourceInformationMarkerEnd(v3);
                    long v1_4 = v10;
                    v11 = v9;
                    v9_1 = v1_4;
                    v17_1 = v41;
                    Object v1_5 = v0_9;
                    v24_1 = v4_2;
                    v21_1 = v5_1;
                    v20 = v8;
                    v22 = v12;
                    v12_1 = v13;
                    v13_1 = v14;
                    v14_1 = v15_1;
                    v2 = v18 & 0xFE3FFFFF;
                    v18_1 = v28_1;
                    v5_3 = v40;
                    v0_9 = v42;
                }
                else {
                    v42 = v0_3;
                    v0_6 = v10;
                    v11 = v9;
                    v9_1 = v0_6;
                    v17_1 = v41;
                    v0_9 = v42;
                    v1_1 = arg60;
                    v24_1 = v4_2;
                    v21_1 = v5_1;
                    v20 = v8;
                    v22 = v12;
                    v12_1 = v13;
                    v13_1 = v14;
                    v14_1 = v15_1;
                    v2 = v18;
                    v18_1 = v28_1;
                    v5_3 = v40;
                }

                v16_1 = v6_1;
            }
            else {
                v3.skipToGroupEnd();
                if((v2 & v27) != 0) {
                    v18 &= 0xFE3FFFFF;
                }

                v0_6 = v10;
                v11 = v9;
                v9_1 = v0_6;
                v25_1 = arg41;
                v16_1 = arg50;
                v17_1 = arg51;
                v20 = arg54;
                v22 = arg56;
                v23 = arg57;
                v24_1 = arg58;
                v0_3 = arg59;
                v1_1 = arg60;
                v21_1 = v5_1;
                v12_1 = v13;
                v13_1 = v14;
                v2 = v18;
                v5_2 = arg40;
                v14_1 = arg48;
                v18_1 = arg52;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027001676, v7, v2, "androidx.compose.material3.Text (Text.kt:329)");
            }

            v6 = v7 << 3;
            v28 = v7 & 14 | 0xC00 | v7 & 0x70 | v7 & 0x380 | 0xE000 & v6 | 0x70000 & v6 | 0x380000 & v6 | 0x1C00000 & v6 | 0xE000000 & v6 | v6 & 0x70000000;
            v2 <<= 3;
            v29 = v7 >> 27 & 14 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | v2 & 0xE000000;
            v27_1 = v3;
            long v6_2 = v25_1;
            Function1 v25_2 = v0_3;
            TextStyle v26_1 = v1_1;
            TextKt.Text-Z58ophY(arg39, v5_2, v6_2, null, v9_1, v11, v12_1, v13_1, v14_1, v16_1, v17_1, v18_1, v20, v21_1, v22, v23, v24_1, v25_2, v26_1, v27_1, v28, v29, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v5_2;
            v3_1 = v6_2;
            v5 = v9_1;
            v7_1 = v11;
            v8_1 = v12_1;
            v9_2 = v13_1;
            v10 = v14_1;
            v12_2 = v16_1;
            v13_2 = v17_1;
            v14_1 = v18_1;
            v16 = v20;
            v17_2 = v21_1;
            v18 = v22;
            v19 = v23;
            v20_1 = v24_1;
            v21_2 = v25_2;
            v22_1 = v26_1;
        }
        else {
            v27_1 = v3;
            v27_1.skipToGroupEnd();
            v2_1 = arg40;
            v3_1 = arg41;
            v12_2 = arg50;
            v16 = arg54;
            v18 = arg56;
            v19 = arg57;
            v20_1 = arg58;
            v21_2 = arg59;
            v22_1 = arg60;
            v17_2 = v5_1;
            v7_1 = v9;
            v5 = v10;
            v8_1 = v13;
            v9_2 = v14;
            v10 = arg48;
            v13_2 = arg51;
            v14_1 = arg52;
        }

        ScopeUpdateScope v0_11 = v27_1.endRestartGroup();
        if(v0_11 != null) {
            v0_11.updateScope(new TextKt$$ExternalSyntheticLambda9(arg39, v2_1, v3_1, v5, v7_1, v8_1, v9_2, v10, v12_2, v13_2, v14_1, v16, v17_2, v18, v19, v20_1, v21_2, v22_1, arg62, arg63, arg64));
        }
    }

    public static final void Text-Nvy7gAk(String arg47, Modifier arg48, long arg49, TextAutoSize arg51, long arg52, FontStyle arg54, FontWeight arg55, FontFamily arg56, long arg57, TextDecoration arg59, TextAlign arg60, long arg61, int arg63, boolean arg64, int arg65, int arg66, Function1 arg67, TextStyle arg68, Composer arg69, int arg70, int arg71, int arg72) {
        long v11_2;
        TextStyle v22_2;
        boolean v18_2;
        long v3_2;
        TextDecoration v13_2;
        FontFamily v10_2;
        FontStyle v8_2;
        long v6_2;
        Modifier v2_2;
        Function1 v21_1;
        TextAlign v14_2;
        FontWeight v9_1;
        TextAutoSize v5_2;
        Composer v0_7;
        Function1 v10_1;
        FontStyle v18_1;
        int v13_1;
        long v15_1;
        FontWeight v17_1;
        TextStyle v12_1;
        boolean v4_2;
        long v34_1;
        TextAlign v2_1;
        TextDecoration v29;
        long v22_1;
        FontFamily v20_1;
        long v0_4;
        Object v0_6;
        ProvidableCompositionLocal v0_5;
        Function1 v8_1;
        Companion v11_1;
        int v24;
        int v5_1;
        int v23;
        int v32;
        int v36;
        int v6;
        long v4;
        int v35;
        int v34;
        int v33;
        FontWeight v15;
        int v30;
        FontStyle v10;
        int v25;
        long v13;
        int v20;
        TextAutoSize v9;
        int v16;
        int v12;
        Modifier v11;
        int v7;
        int v0 = arg70;
        int v1 = arg71;
        int v2 = arg72;
        Composer v3 = arg69.startRestartGroup(1809465675);
        ComposerKt.sourceInformation(v3, "C(Text)N(text,modifier,color:c#ui.graphics.Color,autoSize,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,onTextLayout,style)124@6409L698:Text.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v7 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v7 = v3.changed(arg47) ? 4 : 2;
            v7 |= v0;
        }
        else {
            v7 = v0;
        }

        int v8 = v2 & 2;
        if(v8 != 0) {
            v7 |= 0x30;
            goto label_40;
        }
        else if((v0 & 0x30) == 0) {
            v11 = arg48;
            v12 = v3.changed(v11) ? 0x20 : 16;
            v7 |= v12;
        }
        else {
        label_40:
            v11 = arg48;
        }

        v12 = v2 & 4;
        if(v12 != 0) {
            v7 |= 0x180;
        }
        else {
            long v5 = arg49;
            if((v0 & 0x180) == 0) {
                v16 = v3.changed(v5) ? 0x100 : 0x80;
                v7 |= v16;
            }
        }

        v16 = v2 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v7 |= 0xC00;
            goto label_71;
        }
        else if((v0 & 0xC00) == 0) {
            v9 = arg51;
            v20 = v3.changedInstance(v9) ? v17 : v18;
            v7 |= v20;
        }
        else {
        label_71:
            v9 = arg51;
        }

        v20 = v2 & 16;
        int v21 = 0x4000;
        int v22 = 0x2000;
        if(v20 != 0) {
            v7 |= 0x6000;
            v13 = arg52;
        }
        else {
            v13 = arg52;
            if((v0 & 0x6000) == 0) {
                v25 = v3.changed(v13) ? v21 : v22;
                v7 |= v25;
            }
        }

        v25 = v2 & 0x20;
        int v26 = 0x10000;
        int v27 = 0x30000;
        int v28 = 0x20000;
        if(v25 != 0) {
            v7 |= v27;
            v10 = arg54;
        }
        else {
            v10 = arg54;
            if((v0 & v27) == 0) {
                v30 = v3.changed(v10) ? v28 : v26;
                v7 |= v30;
            }
        }

        v30 = v2 & 0x40;
        int v31 = 0x180000;
        if(v30 != 0) {
            v7 |= v31;
            v15 = arg55;
        }
        else {
            v15 = arg55;
            if((v0 & v31) == 0) {
                v33 = v3.changed(v15) ? 0x100000 : 0x80000;
                v7 |= v33;
            }
        }

        v0 = v2 & 0x80;
        v33 = 0xC00000;
        if(v0 != 0) {
            v7 |= v33;
            goto label_136;
        }
        else if((arg70 & v33) == 0) {
            v34 = v0;
            v35 = v3.changed(arg56) ? 0x800000 : 0x400000;
            v7 |= v35;
        }
        else {
        label_136:
            v34 = v0;
        }

        v0 = v2 & 0x100;
        v35 = 0x6000000;
        if(v0 != 0) {
            v7 |= v35;
        }
        else {
            v4 = arg57;
            if((arg70 & v35) == 0) {
                v6 = v3.changed(v4) ? 0x4000000 : 0x2000000;
                v7 |= v6;
            }
        }

        v6 = v2 & 0x200;
        v35 = 0x30000000;
        if(v6 != 0) {
            v7 |= v35;
            goto label_169;
        }
        else if((arg70 & v35) == 0) {
            v35 = v0;
            v36 = v3.changed(arg59) ? 0x20000000 : 0x10000000;
            v7 |= v36;
        }
        else {
        label_169:
            v35 = v0;
        }

        v0 = v2 & 0x400;
        if(v0 != 0) {
            v32 = v1 | 6;
            v36 = v0;
        }
        else if((v1 & 6) == 0) {
            v36 = v0;
            v32 = v3.changed(arg60) ? 4 : 2;
            v32 |= v1;
        }
        else {
            v36 = v0;
            v32 = v1;
        }

        v0 = v2 & 0x800;
        if(v0 != 0) {
            v32 |= 0x30;
        }
        else {
            v4 = arg61;
            if((v1 & 0x30) == 0) {
                v23 = v3.changed(v4) ? 0x20 : 16;
                v32 |= v23;
            }
        }

        int v19 = v0;
        v0 = v32;
        int v4_1 = v2 & 0x1000;
        if(v4_1 != 0) {
            v0 |= 0x180;
            goto label_221;
        }
        else if((v1 & 0x180) == 0) {
            v5_1 = arg63;
            v24 = v3.changed(v5_1) ? 0x100 : 0x80;
            v0 |= v24;
        }
        else {
        label_221:
            v5_1 = arg63;
        }

        v23 = v4_1;
        v4_1 = v2 & 0x2000;
        if(v4_1 != 0) {
            v0 |= 0xC00;
        }
        else {
            v24 = v0;
            if((v1 & 0xC00) == 0) {
                if(v3.changed(arg64)) {
                }
                else {
                    v17 = v18;
                }

                v0 = v24 | v17;
            }
            else {
                v0 = v24;
            }
        }

        v17 = v4_1;
        v4_1 = v2 & 0x4000;
        if(v4_1 != 0) {
            v18 = v0 | 0x6000;
        }
        else {
            v18 = v0;
            if((v1 & 0x6000) == 0) {
                if(v3.changed(arg65)) {
                }
                else {
                    v21 = v22;
                }

                v18 |= v21;
            }
        }

        v21 = v2 & 0x8000;
        if(v21 != 0) {
            v18 |= v27;
        }
        else {
            v0 = arg66;
            if((v1 & v27) == 0) {
                v22 = v3.changed(v0) ? v28 : v26;
                v18 |= v22;
            }
        }

        v22 = v2 & v26;
        if(v22 != 0) {
            v18 |= v31;
        }
        else {
            Function1 v0_1 = arg67;
            if((v1 & v31) == 0) {
                v24 = v3.changedInstance(v0_1) ? 0x100000 : 0x80000;
                v18 |= v24;
            }
        }

        if((v1 & v33) == 0) {
            TextStyle v0_2 = arg68;
            v24 = (v2 & v28) != 0 || !v3.changed(v0_2) ? 0x400000 : 0x800000;
            v18 |= v24;
        }

        v24 = 1;
        boolean v0_3 = (v7 & 306783379) != 306783378 || (v18 & 0x492493) != 4793490 ? true : false;
        if(v3.shouldExecute(v0_3, v7 & 1)) {
            v3.startDefaults();
            ComposerKt.sourceInformation(v3, "119@6296L7");
            if((arg70 & 1) == 0 || (v3.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v11_1 = Modifier.Companion;
                }

                v0_4 = v12 != 0 ? Color.Companion.getUnspecified-0d7_KjU() : arg49;
                v8_1 = null;
                if(v16 != 0) {
                    v9 = ((TextAutoSize)v8_1);
                }

                long v12_2 = v20 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : v13;
                if(v25 != 0) {
                    v10 = ((FontStyle)v8_1);
                }

                if(v30 != 0) {
                    v15 = ((FontWeight)v8_1);
                }

                FontFamily v14 = v34 != 0 ? ((FontFamily)v8_1) : arg56;
                long v25_1 = v35 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg57;
                TextDecoration v6_1 = v6 != 0 ? ((TextDecoration)v8_1) : arg59;
                TextAlign v16_1 = v36 != 0 ? ((TextAlign)v8_1) : arg60;
                long v19_1 = v19 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg61;
                if(v23 != 0) {
                    v5_1 = TextOverflow.Companion.getClip-gIe3tQ8();
                }

                boolean v17_2 = v17 != 0 ? true : arg64;
                v4_1 = v4_1 != 0 ? 0x7FFFFFFF : arg65;
                if(v21 != 0) {
                }
                else {
                    v24 = arg66;
                }

                if(v22 != 0) {
                }
                else {
                    v8_1 = arg67;
                }

                if((v2 & v28) != 0) {
                    long v48 = v0_4;
                    v0_5 = TextKt.LocalTextStyle;
                    ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v0_6 = v3.consume(((CompositionLocal)v0_5));
                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v29 = v6_1;
                    v2_1 = v16_1;
                    v34_1 = v19_1;
                    v22_1 = v25_1;
                    v6 = v4_1;
                    v20_1 = v14;
                    v4_2 = v17_2;
                    v17_1 = v15;
                    v15_1 = v12_2;
                    v13_1 = v18 & 0xFE3FFFFF;
                    Object v12_3 = v0_6;
                    v18_1 = v10;
                    v0_4 = v48;
                }
                else {
                    v29 = v6_1;
                    v2_1 = v16_1;
                    v34_1 = v19_1;
                    v22_1 = v25_1;
                    v6 = v4_1;
                    v20_1 = v14;
                    v4_2 = v17_2;
                    v17_1 = v15;
                    v15_1 = v12_2;
                    v13_1 = v18;
                    v12_1 = arg68;
                    v18_1 = v10;
                }

                v10_1 = v8_1;
                v8 = v24;
            }
            else {
                v3.skipToGroupEnd();
                if((v2 & v28) != 0) {
                    v18 &= 0xFE3FFFFF;
                }

                v0_4 = arg49;
                v20_1 = arg56;
                v22_1 = arg57;
                v29 = arg59;
                v2_1 = arg60;
                v34_1 = arg61;
                v4_2 = arg64;
                v6 = arg65;
                v8 = arg66;
                v12_1 = arg68;
                v17_1 = v15;
                v15_1 = v13;
                v13_1 = v18;
                v18_1 = v10;
                v10_1 = arg67;
            }

            v3.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                arg61 = v0_4;
                ComposerKt.traceEventStart(1809465675, v7, v13_1, "androidx.compose.material3.Text (Text.kt:120)");
            }
            else {
                arg61 = v0_4;
            }

            v3.startReplaceGroup(0xDE4F78AE);
            ComposerKt.sourceInformation(v3, "");
            if(arg61 != 16) {
                v0_4 = arg61;
            }
            else {
                v3.startReplaceGroup(0xDE4F7BB3);
                ComposerKt.sourceInformation(v3, "*122@6392L7");
                v0_4 = v12_1.getColor-0d7_KjU();
                if(v0_4 != 16) {
                }
                else {
                    v0_5 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v0_6 = v3.consume(((CompositionLocal)v0_5));
                    ComposerKt.sourceInformationMarkerEnd(v3);
                    v0_4 = ((Color)v0_6).unbox-impl();
                }

                v3.endReplaceGroup();
            }

            v3.endReplaceGroup();
            int v14_1 = v2_1 != null ? v2_1.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
            long v45 = v0_4;
            v0 = v13_1;
            v13_1 = v7 & 0x7E | v0 >> 9 & 0x1C00;
            v0 <<= 6;
            int v55 = v8;
            BasicTextKt.BasicText-RWo7tUw(arg47, ((Modifier)v11_1), TextStyle.merge-dA7vx0o$default(v12_1, v45, v15_1, v17_1, v18_1, null, v20_1, null, v22_1, null, null, null, 0, v29, null, null, v14_1, 0, v34_1, null, null, 0, 0, null, null, 0xFD6F50, null), v10_1, v5_1, v4_2, v6, v55, null, v9, v3, v0 & 0x1C00000 | (v13_1 | 0xE000 & v0 | 0x70000 & v0 | 0x380000 & v0) | v7 << 18 & 0x70000000, 0x100);
            v8_1 = v10_1;
            boolean v1_1 = v4_2;
            v4_1 = v6;
            v24 = v55;
            v0_7 = v3;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            FontWeight v3_1 = v17_1;
            v17 = v5_1;
            v5_2 = v9;
            v9_1 = v3_1;
            v14_2 = v2_1;
            v19 = v4_1;
            v21_1 = v8_1;
            v2_2 = ((Modifier)v11_1);
            v6_2 = v15_1;
            v8_2 = v18_1;
            v10_2 = v20_1;
            v20 = v24;
            v13_2 = v29;
            v15_1 = v34_1;
            v3_2 = arg61;
            v18_2 = v1_1;
            v45 = v22_1;
            v22_2 = v12_1;
            v11_2 = v45;
        }
        else {
            v0_7 = v3;
            v0_7.skipToGroupEnd();
            v3_2 = arg49;
            v18_2 = arg64;
            v19 = arg65;
            v20 = arg66;
            v21_1 = arg67;
            v22_2 = arg68;
            v17 = v5_1;
            v5_2 = v9;
            v8_2 = v10;
            v2_2 = v11;
            v6_2 = v13;
            v9_1 = v15;
            v10_2 = arg56;
            v11_2 = arg57;
            v13_2 = arg59;
            v14_2 = arg60;
            v15_1 = arg61;
        }

        ScopeUpdateScope v0_8 = v0_7.endRestartGroup();
        if(v0_8 != null) {
            v0_8.updateScope(new TextKt$$ExternalSyntheticLambda3(arg47, v2_2, v3_2, v5_2, v6_2, v8_2, v9_1, v10_2, v11_2, v13_2, v14_2, v15_1, v17, v18_2, v19, v20, v21_1, v22_2, arg70, arg71, arg72));
        }
    }

    public static final void Text-Z58ophY(AnnotatedString arg66, Modifier arg67, long arg68, TextAutoSize arg70, long arg71, FontStyle arg73, FontWeight arg74, FontFamily arg75, long arg76, TextDecoration arg78, TextAlign arg79, long arg80, int arg82, boolean arg83, int arg84, int arg85, Map arg86, Function1 arg87, TextStyle arg88, Composer arg89, int arg90, int arg91, int arg92) {
        long v15;
        long v6_1;
        boolean v18_1;
        TextDecoration v13_3;
        long v11_2;
        FontFamily v10;
        FontStyle v8_5;
        FontWeight v9_1;
        TextStyle v23_1;
        Map v21_1;
        Modifier v2_9;
        long v3_4;
        TextAutoSize v5_3;
        TextAlign v14_1;
        Function1 v22_1;
        Composer v0_1;
        AnnotatedString v13_2;
        long v34_1;
        Function1 v5_1;
        int v7_1;
        long v36_1;
        FontStyle v39;
        FontWeight v38_1;
        TextStyle v33_1;
        Map v19_1;
        boolean v17_1;
        long v55;
        TextAlign v3_1;
        TextDecoration v50;
        long v43;
        FontFamily v41;
        TextAutoSize v2_5;
        Object v5_2;
        Object v69;
        Object v2_7;
        TextAutoSize v68;
        Companion v11_1;
        Function1 v2_2;
        int v23;
        int v19;
        int v38;
        int v36;
        int v35;
        int v34;
        int v33;
        FontWeight v7;
        int v30;
        FontStyle v13;
        int v25;
        long v14;
        int v20;
        int v16;
        long v9;
        int v12;
        Modifier v11;
        int v5;
        AnnotatedString v1 = arg66;
        int v0 = arg90;
        int v2 = arg91;
        int v3 = arg92;
        Composer v4 = arg89.startRestartGroup(0x116B5779);
        ComposerKt.sourceInformation(v4, "C(Text)N(text,modifier,color:c#ui.graphics.Color,autoSize,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,onTextLayout,style)230@11970L24,232@12040L73,234@12119L759:Text.kt#uh7d8r");
        if((v3 & 1) != 0) {
            v5 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v5 = v4.changed(v1) ? 4 : 2;
            v5 |= v0;
        }
        else {
            v5 = v0;
        }

        int v8 = v3 & 2;
        if(v8 != 0) {
            v5 |= 0x30;
            goto label_37;
        }
        else if((v0 & 0x30) == 0) {
            v11 = arg67;
            v12 = v4.changed(v11) ? 0x20 : 16;
            v5 |= v12;
        }
        else {
        label_37:
            v11 = arg67;
        }

        v12 = v3 & 4;
        if(v12 != 0) {
            v5 |= 0x180;
            v9 = arg68;
        }
        else {
            v9 = arg68;
            if((v0 & 0x180) == 0) {
                v16 = v4.changed(v9) ? 0x100 : 0x80;
                v5 |= v16;
            }
        }

        v16 = v3 & 8;
        int v17 = 0x800;
        int v18 = 0x400;
        if(v16 != 0) {
            v5 |= 0xC00;
        }
        else if((v0 & 0xC00) == 0) {
            v20 = v4.changedInstance(arg70) ? v17 : v18;
            v5 |= v20;
        }

        v20 = v3 & 16;
        int v21 = 0x4000;
        int v22 = 0x2000;
        if(v20 != 0) {
            v5 |= 0x6000;
            v14 = arg71;
        }
        else {
            v14 = arg71;
            if((v0 & 0x6000) == 0) {
                v25 = v4.changed(v14) ? v21 : v22;
                v5 |= v25;
            }
        }

        v25 = v3 & 0x20;
        int v26 = 0x20000;
        int v27 = 0x10000;
        int v28 = 0x30000;
        if(v25 != 0) {
            v5 |= v28;
            v13 = arg73;
        }
        else {
            v13 = arg73;
            if((v0 & v28) == 0) {
                v30 = v4.changed(v13) ? v26 : v27;
                v5 |= v30;
            }
        }

        v30 = v3 & 0x40;
        int v31 = 0x180000;
        if(v30 != 0) {
            v5 |= v31;
            v7 = arg74;
        }
        else {
            v7 = arg74;
            if((v0 & v31) == 0) {
                v33 = v4.changed(v7) ? 0x100000 : 0x80000;
                v5 |= v33;
            }
        }

        v0 = v3 & 0x80;
        v33 = 0xC00000;
        if(v0 != 0) {
            v5 |= v33;
            goto label_133;
        }
        else if((arg90 & v33) == 0) {
            v34 = v0;
            v35 = v4.changed(arg75) ? 0x800000 : 0x400000;
            v5 |= v35;
        }
        else {
        label_133:
            v34 = v0;
        }

        v0 = v3 & 0x100;
        v35 = 0x6000000;
        if(v0 != 0) {
            v5 |= v35;
            goto label_151;
        }
        else if((arg90 & v35) == 0) {
            v35 = v5;
            v36 = v4.changed(arg76) ? 0x4000000 : 0x2000000;
            v35 |= v36;
        }
        else {
        label_151:
            v35 = v5;
        }

        v36 = v0;
        v0 = v3 & 0x200;
        int v37 = 0x30000000;
        if(v0 != 0) {
            v35 |= v37;
            v37 = v0;
        }
        else if((arg90 & v37) == 0) {
            v37 = v0;
            v38 = v4.changed(arg78) ? 0x20000000 : 0x10000000;
            v35 |= v38;
        }
        else {
            v37 = v0;
        }

        v0 = v35;
        v5 = v3 & 0x400;
        if(v5 != 0) {
            v19 = v2 | 6;
        }
        else if((v2 & 6) == 0) {
            v19 = v4.changed(arg79) ? 4 : 2;
            v19 |= v2;
        }
        else {
            v19 = v2;
        }

        v35 = v5;
        v5 = v3 & 0x800;
        if(v5 != 0) {
            v19 |= 0x30;
            v38 = v5;
        }
        else if((v2 & 0x30) == 0) {
            v38 = v5;
            int v24 = v4.changed(arg80) ? 0x20 : 16;
            v19 |= v24;
        }
        else {
            v38 = v5;
        }

        v5 = v19;
        int v6 = v3 & 0x1000;
        if(v6 != 0) {
            v5 |= 0x180;
        }
        else {
            v19 = v5;
            if((v2 & 0x180) == 0) {
                v23 = v4.changed(arg82) ? 0x100 : 0x80;
                v19 |= v23;
            }

            v5 = v19;
        }

        v19 = v6;
        v6 = v3 & 0x2000;
        if(v6 != 0) {
            v5 |= 0xC00;
        }
        else {
            v23 = v5;
            if((v2 & 0xC00) == 0) {
                if(v4.changed(arg83)) {
                }
                else {
                    v17 = v18;
                }

                v5 = v23 | v17;
            }
            else {
                v5 = v23;
            }
        }

        v17 = v6;
        v6 = v3 & 0x4000;
        if(v6 != 0) {
            v5 |= 0x6000;
        }
        else if((v2 & 0x6000) == 0) {
            if(v4.changed(arg84)) {
            }
            else {
                v21 = v22;
            }

            v5 |= v21;
        }

        v18 = arg92 & 0x8000;
        if(v18 != 0) {
            v5 |= v28;
        }
        else {
            v21 = v2 & v28;
            v2 = arg85;
            if(v21 == 0) {
                v21 = v4.changed(v2) ? v26 : v27;
                v5 |= v21;
            }
        }

        v21 = arg92 & v27;
        if(v21 != 0) {
            v5 |= v31;
        }
        else {
            Map v2_1 = arg86;
            if((arg91 & v31) == 0) {
                v22 = v4.changedInstance(v2_1) ? 0x100000 : 0x80000;
                v5 |= v22;
            }
        }

        v22 = arg92 & v26;
        if(v22 != 0) {
            v5 |= v33;
        }
        else {
            v2_2 = arg87;
            if((arg91 & v33) == 0) {
                v23 = v4.changedInstance(v2_2) ? 0x800000 : 0x400000;
                v5 |= v23;
            }
        }

        if((arg91 & 0x6000000) == 0) {
            TextStyle v2_3 = arg88;
            v23 = (arg92 & 0x40000) != 0 || !v4.changed(v2_3) ? 0x2000000 : 0x4000000;
            v5 |= v23;
        }

        v23 = 1;
        boolean v2_4 = (v0 & 306783379) != 306783378 || (0x2492493 & v5) != 0x2492492 ? true : false;
        if(v4.shouldExecute(v2_4, v0 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "226@11800L2,227@11842L7");
            if((arg90 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v8 != 0) {
                    v11_1 = Modifier.Companion;
                }

                if(v12 != 0) {
                    v9 = Color.Companion.getUnspecified-0d7_KjU();
                }

                TextAlign v2_6 = null;
                TextAutoSize v3_2 = v16 != 0 ? ((TextAutoSize)v2_6) : arg70;
                if(v20 != 0) {
                    v14 = TextUnit.Companion.getUnspecified-XSAIIZE();
                }

                if(v25 != 0) {
                    v13 = ((FontStyle)v2_6);
                }

                if(v30 != 0) {
                    v7 = ((FontWeight)v2_6);
                }

                FontFamily v8_1 = v34 != 0 ? ((FontFamily)v2_6) : arg75;
                long v24_1 = v36 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg76;
                TextDecoration v12_1 = v37 != 0 ? ((TextDecoration)v2_6) : arg78;
                if(v35 != 0) {
                }
                else {
                    v2_6 = arg79;
                }

                long v26_1 = v38 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg80;
                v16 = v19 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg82;
                v17_1 = v17 != 0 ? true : arg83;
                v6 = v6 != 0 ? 0x7FFFFFFF : arg84;
                v18 = v18 != 0 ? 1 : arg85;
                v19_1 = v21 != 0 ? MapsKt.emptyMap() : arg86;
                TextAlign v67 = v2_6;
                if(v22 != 0) {
                    v68 = v3_2;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x63F3B8FB, "CC(remember):Text.kt#9igjgp");
                    v2_7 = v4.rememberedValue();
                    if(v2_7 == Composer.Companion.getEmpty()) {
                        TextKt$$ExternalSyntheticLambda4 v2_8 = new TextKt$$ExternalSyntheticLambda4();
                        v4.updateRememberedValue(v2_8);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v4);
                }
                else {
                    v68 = v3_2;
                    v2_2 = arg87;
                }

                if((arg92 & 0x40000) != 0) {
                    ProvidableCompositionLocal v3_3 = TextKt.LocalTextStyle;
                    v69 = v2_2;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v2_7 = v4.consume(((CompositionLocal)v3_3));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v3_1 = v67;
                    Object v33_2 = v2_7;
                    v38_1 = v7;
                    v41 = v8_1;
                    v50 = v12_1;
                    v39 = v13;
                    v36_1 = v14;
                    v43 = v24_1;
                    v55 = v26_1;
                    v2_5 = v68;
                    v7_1 = v5 & 0xF1FFFFFF;
                    v5_2 = v69;
                    goto label_486;
                }

                v69 = v2_2;
                int v89 = v5;
                v3_1 = v67;
                v2_5 = v68;
                v5_2 = v69;
                v33_1 = arg88;
                v38_1 = v7;
                v41 = v8_1;
                v50 = v12_1;
                v39 = v13;
                v36_1 = v14;
                v43 = v24_1;
                v55 = v26_1;
                v7_1 = v89;
            }
            else {
                v4.skipToGroupEnd();
                if((arg92 & 0x40000) != 0) {
                    v5 &= 0xF1FFFFFF;
                }

                v2_5 = arg70;
                v41 = arg75;
                v43 = arg76;
                v50 = arg78;
                v3_1 = arg79;
                v55 = arg80;
                v16 = arg82;
                v17_1 = arg83;
                v6 = arg84;
                v18 = arg85;
                v19_1 = arg86;
                v33_1 = arg88;
                v38_1 = v7;
                v39 = v13;
                v36_1 = v14;
                v7_1 = v5;
                v5_1 = arg87;
            }

        label_486:
            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x116B5779, v0, v7_1, "androidx.compose.material3.Text (Text.kt:228)");
            }

            v4.startReplaceGroup(0x63F3C35C);
            ComposerKt.sourceInformation(v4, "");
            if(v9 != 16) {
                v34_1 = v9;
            }
            else {
                v4.startReplaceGroup(0x63F3C661);
                ComposerKt.sourceInformation(v4, "*229@11937L7");
                long v12_2 = v33_1.getColor-0d7_KjU();
                if(v12_2 != 16) {
                }
                else {
                    ProvidableCompositionLocal v8_2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object v8_3 = v4.consume(((CompositionLocal)v8_2));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v12_2 = ((Color)v8_3).unbox-impl();
                }

                v4.endReplaceGroup();
                v34_1 = v12_2;
            }

            v4.endReplaceGroup();
            TextLinkStyles v8_4 = TextKt.rememberTextLinkStyles(v4, 0);
            ComposerKt.sourceInformationMarkerStart(v4, 0x63F3D742, "CC(remember):Text.kt#9igjgp");
            if((v0 & 14) == 4) {
            }
            else {
                v23 = 0;
            }

            v12 = v23 | v4.changed(v8_4);
            Object v13_1 = v4.rememberedValue();
            if(v12 != 0 || v13_1 == Composer.Companion.getEmpty()) {
                v13_2 = TextKt.createTextWithLinkStyles(v1, v8_4);
                v4.updateRememberedValue(v13_2);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v8 = v3_1 != null ? v3_1.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk();
            v12 = v0 & 0x70 | v7_1 >> 12 & 0x1C00;
            v7_1 <<= 6;
            TextAutoSize v77 = v2_5;
            Composer v78 = v4;
            BasicTextKt.BasicText-CL7eQgs(v13_2, ((Modifier)v11_1), TextStyle.merge-dA7vx0o$default(v33_1, v34_1, v36_1, v38_1, v39, null, v41, null, v43, null, null, null, 0, v50, null, null, v8, 0, v55, null, null, 0, 0, null, null, 0xFD6F50, null), v5_1, v16, v17_1, v6, v18, v19_1, null, v77, v78, v7_1 & 0xE000000 | (v12 | 0xE000 & v7_1 | 0x70000 & v7_1 | 0x380000 & v7_1 | 0x1C00000 & v7_1), v0 >> 9 & 14, 0x200);
            v2_2 = v5_1;
            TextAutoSize v4_1 = v77;
            v0_1 = v78;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v22_1 = v2_2;
            v14_1 = v3_1;
            v5_3 = v4_1;
            v3_4 = v9;
            v2_9 = ((Modifier)v11_1);
            v20 = v18;
            v21_1 = v19_1;
            v23_1 = v33_1;
            v9_1 = v38_1;
            v8_5 = v39;
            v10 = v41;
            v11_2 = v43;
            v13_3 = v50;
            v19 = v6;
            v18_1 = v17_1;
            v6_1 = v36_1;
            v17 = v16;
            v15 = v55;
        }
        else {
            v0_1 = v4;
            v0_1.skipToGroupEnd();
            v5_3 = arg70;
            v17 = arg82;
            v18_1 = arg83;
            v19 = arg84;
            v20 = arg85;
            v21_1 = arg86;
            v22_1 = arg87;
            v23_1 = arg88;
            v3_4 = v9;
            v2_9 = v11;
            v8_5 = v13;
            v10 = arg75;
            v11_2 = arg76;
            v13_3 = arg78;
            v9_1 = v7;
            v6_1 = v14;
            v14_1 = arg79;
            v15 = arg80;
        }

        ScopeUpdateScope v0_2 = v0_1.endRestartGroup();
        if(v0_2 != null) {
            v0_2.updateScope(new TextKt$$ExternalSyntheticLambda5(v1, v2_9, v3_4, v5_3, v6_1, v8_5, v9_1, v10, v11_2, v13_3, v14_1, v15, v17, v18_1, v19, v20, v21_1, v22_1, v23_1, arg90, arg91, arg92));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with minLines instead") public static final void Text-fLXpl1I(String arg43, Modifier arg44, long arg45, long arg47, FontStyle arg49, FontWeight arg50, FontFamily arg51, long arg52, TextDecoration arg54, TextAlign arg55, long arg56, int arg58, boolean arg59, int arg60, Function1 arg61, TextStyle arg62, Composer arg63, int arg64, int arg65, int arg66) {
        TextStyle v20_1;
        Function1 v19_2;
        boolean v17_2;
        TextAlign v13_2;
        TextDecoration v12_1;
        long v10_1;
        FontFamily v9_3;
        FontWeight v8_1;
        FontStyle v7_1;
        long v3_1;
        Modifier v2_2;
        Composer v26_1;
        long v14_1;
        FontFamily v13_1;
        FontWeight v12;
        long v6_2;
        boolean v21_1;
        TextStyle v25_1;
        long v18_1;
        TextAlign v17_1;
        TextDecoration v16_2;
        Modifier v5_2;
        long v9_1;
        FontStyle v11_1;
        Object v24_2;
        Object v25_2;
        Companion v5_4;
        Object v45;
        Function1 v1_7;
        Object v1_5;
        Companion v44;
        Modifier v1_4;
        int v20;
        boolean v6_1;
        int v36;
        long v5;
        int v35;
        int v34;
        int v33;
        FontFamily v15;
        int v29;
        FontWeight v14;
        int v25;
        FontStyle v10;
        int v21;
        long v11;
        int v17;
        int v16;
        long v7;
        int v6;
        int v13;
        int v8;
        int v0 = arg64;
        int v1 = arg65;
        int v2 = arg66;
        Composer v4 = arg63.startRestartGroup(0x7559451D);
        ComposerKt.sourceInformation(v4, "C(Text)N(text,modifier,color:c#ui.graphics.Color,fontSize:c#ui.unit.TextUnit,fontStyle:c#ui.text.font.FontStyle,fontWeight,fontFamily,letterSpacing:c#ui.unit.TextUnit,textDecoration,textAlign:c#ui.text.style.TextAlign,lineHeight:c#ui.unit.TextUnit,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,onTextLayout,style)374@16538L523:Text.kt#uh7d8r");
        if((v2 & 1) != 0) {
            v8 = v0 | 6;
        }
        else if((v0 & 6) == 0) {
            v8 = v4.changed(arg43) ? 4 : 2;
            v8 |= v0;
        }
        else {
            v8 = v0;
        }

        int v9 = v2 & 2;
        if(v9 != 0) {
            v8 |= 0x30;
        }
        else if((v0 & 0x30) == 0) {
            v13 = v4.changed(arg44) ? 0x20 : 16;
            v8 |= v13;
        }

        v13 = v2 & 4;
        if(v13 != 0) {
            v6 = v8 | 0x180;
            v7 = arg45;
        }
        else {
            v16 = v8;
            v7 = arg45;
            if((v0 & 0x180) == 0) {
                v17 = v4.changed(v7) ? 0x100 : 0x80;
                v16 |= v17;
            }

            v6 = v16;
        }

        v16 = v2 & 8;
        int v18 = 0x800;
        int v19 = 0x400;
        if(v16 != 0) {
            v6 |= 0xC00;
            v11 = arg47;
        }
        else {
            v11 = arg47;
            if((v0 & 0xC00) == 0) {
                v21 = v4.changed(v11) ? v18 : v19;
                v6 |= v21;
            }
        }

        v21 = v2 & 16;
        int v22 = 0x4000;
        int v23 = 0x2000;
        if(v21 != 0) {
            v6 |= 0x6000;
            goto label_90;
        }
        else if((v0 & 0x6000) == 0) {
            v10 = arg49;
            v25 = v4.changed(v10) ? v22 : v23;
            v6 |= v25;
        }
        else {
        label_90:
            v10 = arg49;
        }

        v25 = v2 & 0x20;
        int v26 = 0x10000;
        int v27 = 0x30000;
        if(v25 != 0) {
            v6 |= v27;
            v14 = arg50;
        }
        else {
            v14 = arg50;
            if((v0 & v27) == 0) {
                v29 = v4.changed(v14) ? 0x20000 : v26;
                v6 |= v29;
            }
        }

        v29 = v2 & 0x40;
        int v30 = 0x180000;
        if(v29 != 0) {
            v6 |= v30;
            v15 = arg51;
        }
        else {
            v15 = arg51;
            if((v0 & v30) == 0) {
                int v31 = v4.changed(v15) ? 0x100000 : 0x80000;
                v6 |= v31;
            }
        }

        int v3 = v2 & 0x80;
        int v32 = 0xC00000;
        if(v3 != 0) {
            v6 |= v32;
            goto label_138;
        }
        else if((v0 & v32) == 0) {
            v32 = v6;
            v33 = v4.changed(arg52) ? 0x800000 : 0x400000;
            v32 |= v33;
        }
        else {
        label_138:
            v32 = v6;
        }

        v0 = v2 & 0x100;
        v33 = 0x6000000;
        if(v0 != 0) {
            v32 |= v33;
            goto label_156;
        }
        else if((arg64 & v33) == 0) {
            v33 = v0;
            v34 = v4.changed(arg54) ? 0x4000000 : 0x2000000;
            v32 |= v34;
        }
        else {
        label_156:
            v33 = v0;
        }

        v0 = v2 & 0x200;
        v34 = 0x30000000;
        if(v0 != 0) {
            v32 |= v34;
            v34 = v0;
        }
        else if((arg64 & v34) == 0) {
            v34 = v0;
            v35 = v4.changed(arg55) ? 0x20000000 : 0x10000000;
            v32 |= v35;
        }
        else {
            v34 = v0;
        }

        v0 = v32;
        v32 = v3;
        v3 = v2 & 0x400;
        if(v3 != 0) {
            v17 = v1 | 6;
        }
        else {
            v5 = arg56;
            if((v1 & 6) == 0) {
                v17 = v4.changed(v5) ? 4 : 2;
                v17 |= v1;
            }
            else {
                v17 = v1;
            }
        }

        v35 = v3;
        v3 = v2 & 0x800;
        if(v3 != 0) {
            v17 |= 0x30;
            v36 = v3;
        }
        else if((v1 & 0x30) == 0) {
            v36 = v3;
            int v24 = v4.changed(arg58) ? 0x20 : 16;
            v17 |= v24;
        }
        else {
            v36 = v3;
        }

        v3 = v17;
        int v5_1 = v2 & 0x1000;
        if(v5_1 != 0) {
            v3 |= 0x180;
            goto label_229;
        }
        else if((v1 & 0x180) == 0) {
            v6_1 = arg59;
            int v28 = v4.changed(v6_1) ? 0x100 : 0x80;
            v3 |= v28;
        }
        else {
        label_229:
            v6_1 = arg59;
        }

        v17 = v5_1;
        v5_1 = v2 & 0x2000;
        if(v5_1 != 0) {
            v3 |= 0xC00;
        }
        else {
            v20 = v3;
            if((v1 & 0xC00) == 0) {
                if(v4.changed(arg60)) {
                }
                else {
                    v18 = v19;
                }

                v3 = v20 | v18;
            }
            else {
                v3 = v20;
            }
        }

        v18 = v5_1;
        v5_1 = v2 & 0x4000;
        if(v5_1 != 0) {
            v3 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            if(v4.changedInstance(arg61)) {
            }
            else {
                v22 = v23;
            }

            v3 |= v22;
        }

        v20 = 0x8000;
        if((v1 & v27) == 0) {
            TextStyle v1_1 = arg62;
            if((arg66 & v20) == 0 && (v4.changed(v1_1))) {
                v26 = 0x20000;
            }

            v3 |= v26;
        }

        boolean v19_1 = true;
        boolean v1_2 = (v0 & 306783379) != 306783378 || (74899 & v3) != 74898 ? true : false;
        if(v4.shouldExecute(v1_2, v0 & 1)) {
            v4.startDefaults();
            ComposerKt.sourceInformation(v4, "371@16479L2,372@16521L7");
            if((arg64 & 1) == 0 || (v4.getDefaultsInvalid())) {
                if(v9 != 0) {
                    Companion v1_3 = Modifier.Companion;
                }
                else {
                    v1_4 = arg44;
                }

                if(v13 != 0) {
                    v7 = Color.Companion.getUnspecified-0d7_KjU();
                }

                if(v16 != 0) {
                    v11 = TextUnit.Companion.getUnspecified-XSAIIZE();
                }

                TextAlign v2_1 = null;
                if(v21 != 0) {
                    v10 = ((FontStyle)v2_1);
                }

                if(v25 != 0) {
                    v14 = ((FontWeight)v2_1);
                }

                if(v29 != 0) {
                    v15 = ((FontFamily)v2_1);
                }

                long v21_2 = v32 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg52;
                TextDecoration v9_2 = v33 != 0 ? ((TextDecoration)v2_1) : arg54;
                if(v34 != 0) {
                }
                else {
                    v2_1 = arg55;
                }

                long v23_1 = v35 != 0 ? TextUnit.Companion.getUnspecified-XSAIIZE() : arg56;
                v13 = v36 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg58;
                if(v17 != 0) {
                }
                else {
                    v19_1 = v6_1;
                }

                v6 = v18 != 0 ? 0x7FFFFFFF : arg60;
                if(v5_1 != 0) {
                    v44 = ((Companion)v1_4);
                    ComposerKt.sourceInformationMarkerStart(v4, -2078487105, "CC(remember):Text.kt#9igjgp");
                    v1_5 = v4.rememberedValue();
                    if(v1_5 == Composer.Companion.getEmpty()) {
                        TextKt$$ExternalSyntheticLambda6 v1_6 = new TextKt$$ExternalSyntheticLambda6();
                        v4.updateRememberedValue(v1_6);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v4);
                }
                else {
                    v44 = ((Companion)v1_4);
                    v1_7 = arg61;
                }

                if((arg66 & v20) != 0) {
                    ProvidableCompositionLocal v5_3 = TextKt.LocalTextStyle;
                    v45 = v1_7;
                    ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    v1_5 = v4.consume(((CompositionLocal)v5_3));
                    ComposerKt.sourceInformationMarkerEnd(v4);
                    v3 &= 0xFFF8FFFF;
                    v5_4 = v44;
                    v17_1 = v2_1;
                    v25_2 = v1_5;
                }
                else {
                    v45 = v1_7;
                    v5_4 = v44;
                    v17_1 = v2_1;
                    v25_1 = arg62;
                }

                v16_2 = v9_2;
                v20 = v13;
                v13_1 = v15;
                long v39 = v23_1;
                v24_2 = v45;
                long v41 = v21_2;
                v22 = v6;
                v6_2 = v7;
                v21_1 = v19_1;
                v18_1 = v39;
                v39 = v11;
                v11_1 = v10;
                v9_1 = v39;
                v12 = v14;
                v14_1 = v41;
            }
            else {
                v4.skipToGroupEnd();
                if((arg66 & v20) != 0) {
                    v3 &= 0xFFF8FFFF;
                }

                long v16_1 = v11;
                v11_1 = v10;
                v9_1 = v16_1;
                v5_2 = arg44;
                v16_2 = arg54;
                v17_1 = arg55;
                v18_1 = arg56;
                v20 = arg58;
                v22 = arg60;
                Function1 v24_1 = arg61;
                v25_1 = arg62;
                v21_1 = v6_1;
                v6_2 = v7;
                v12 = v14;
                v13_1 = v15;
                v14_1 = arg52;
            }

            v4.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x7559451D, v0, v3, "androidx.compose.material3.Text (Text.kt:373)");
            }

            v2 = v0 << 3;
            v1 = v0 & 0x3FE | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000;
            v2 = v3 << 3;
            v0 = v0 >> 27 & 14 | v27 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | v2 & 0xE000;
            v2 = v3 << 6;
            v26_1 = v4;
            TextKt.Text-Nvy7gAk(arg43, v5_2, v6_2, null, v9_1, v11_1, v12, v13_1, v14_1, v16_2, v17_1, v18_1, v20, v21_1, v22, 1, ((Function1)v24_2), ((TextStyle)v25_2), v26_1, v1, v0 | 0x380000 & v2 | v2 & 0x1C00000, 8);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_2 = v5_2;
            v3_1 = v6_2;
            v5 = v9_1;
            v7_1 = v11_1;
            v8_1 = v12;
            v9_3 = v13_1;
            v10_1 = v14_1;
            v12_1 = v16_2;
            v13_2 = v17_1;
            v14_1 = v18_1;
            v16 = v20;
            v17_2 = v21_1;
            v18 = v22;
            v19_2 = ((Function1)v24_2);
            v20_1 = ((TextStyle)v25_2);
        }
        else {
            v26_1 = v4;
            v26_1.skipToGroupEnd();
            v2_2 = arg44;
            v13_2 = arg55;
            v16 = arg58;
            v18 = arg60;
            v19_2 = arg61;
            v20_1 = arg62;
            v17_2 = v6_1;
            v3_1 = v7;
            v7_1 = v10;
            v5 = v11;
            v8_1 = v14;
            v9_3 = v15;
            v10_1 = arg52;
            v12_1 = arg54;
            v14_1 = arg56;
        }

        ScopeUpdateScope v0_1 = v26_1.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new TextKt$$ExternalSyntheticLambda7(arg43, v2_2, v3_1, v5, v7_1, v8_1, v9_3, v10_1, v12_1, v13_2, v14_1, v16, v17_2, v18, v19_2, v20_1, arg64, arg65, arg66));
        }
    }

    static final Unit Text_IbK3jfQ$lambda$11$lambda$10(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit Text_IbK3jfQ$lambda$12(AnnotatedString arg27, Modifier arg28, long arg29, long arg31, FontStyle arg33, FontWeight arg34, FontFamily arg35, long arg36, TextDecoration arg38, TextAlign arg39, long arg40, int arg42, boolean arg43, int arg44, int arg45, Map arg46, Function1 arg47, TextStyle arg48, int arg49, int arg50, int arg51, Composer arg52, int arg53) {
        TextKt.Text-IbK3jfQ(arg27, arg28, arg29, arg31, arg33, arg34, arg35, arg36, arg38, arg39, arg40, arg42, arg43, arg44, arg45, arg46, arg47, arg48, arg52, RecomposeScopeImplKt.updateChangedFlags(arg49 | 1), RecomposeScopeImplKt.updateChangedFlags(arg50), arg51);
        return Unit.INSTANCE;
    }

    static final Unit Text_Nvy7gAk$lambda$2(String arg27, Modifier arg28, long arg29, TextAutoSize arg31, long arg32, FontStyle arg34, FontWeight arg35, FontFamily arg36, long arg37, TextDecoration arg39, TextAlign arg40, long arg41, int arg43, boolean arg44, int arg45, int arg46, Function1 arg47, TextStyle arg48, int arg49, int arg50, int arg51, Composer arg52, int arg53) {
        TextKt.Text-Nvy7gAk(arg27, arg28, arg29, arg31, arg32, arg34, arg35, arg36, arg37, arg39, arg40, arg41, arg43, arg44, arg45, arg46, arg47, arg48, arg52, RecomposeScopeImplKt.updateChangedFlags(arg49 | 1), RecomposeScopeImplKt.updateChangedFlags(arg50), arg51);
        return Unit.INSTANCE;
    }

    static final Unit Text_Z58ophY$lambda$4$lambda$3(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit Text_Z58ophY$lambda$8(AnnotatedString arg28, Modifier arg29, long arg30, TextAutoSize arg32, long arg33, FontStyle arg35, FontWeight arg36, FontFamily arg37, long arg38, TextDecoration arg40, TextAlign arg41, long arg42, int arg44, boolean arg45, int arg46, int arg47, Map arg48, Function1 arg49, TextStyle arg50, int arg51, int arg52, int arg53, Composer arg54, int arg55) {
        TextKt.Text-Z58ophY(arg28, arg29, arg30, arg32, arg33, arg35, arg36, arg37, arg38, arg40, arg41, arg42, arg44, arg45, arg46, arg47, arg48, arg49, arg50, arg54, RecomposeScopeImplKt.updateChangedFlags(arg51 | 1), RecomposeScopeImplKt.updateChangedFlags(arg52), arg53);
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$17$lambda$16(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$18(AnnotatedString arg26, Modifier arg27, long arg28, long arg30, FontStyle arg32, FontWeight arg33, FontFamily arg34, long arg35, TextDecoration arg37, TextAlign arg38, long arg39, int arg41, boolean arg42, int arg43, Map arg44, Function1 arg45, TextStyle arg46, int arg47, int arg48, int arg49, Composer arg50, int arg51) {
        TextKt.Text--4IGK_g(arg26, arg27, arg28, arg30, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg41, arg42, arg43, arg44, arg45, arg46, arg50, RecomposeScopeImplKt.updateChangedFlags(arg47 | 1), RecomposeScopeImplKt.updateChangedFlags(arg48), arg49);
        return Unit.INSTANCE;
    }

    static final Unit Text__4IGK_g$lambda$9(String arg26, Modifier arg27, long arg28, long arg30, FontStyle arg32, FontWeight arg33, FontFamily arg34, long arg35, TextDecoration arg37, TextAlign arg38, long arg39, int arg41, boolean arg42, int arg43, int arg44, Function1 arg45, TextStyle arg46, int arg47, int arg48, int arg49, Composer arg50, int arg51) {
        TextKt.Text--4IGK_g(arg26, arg27, arg28, arg30, arg32, arg33, arg34, arg35, arg37, arg38, arg39, arg41, arg42, arg43, arg44, arg45, arg46, arg50, RecomposeScopeImplKt.updateChangedFlags(arg47 | 1), RecomposeScopeImplKt.updateChangedFlags(arg48), arg49);
        return Unit.INSTANCE;
    }

    static final Unit Text_fLXpl1I$lambda$14$lambda$13(TextLayoutResult arg0) {
        return Unit.INSTANCE;
    }

    static final Unit Text_fLXpl1I$lambda$15(String arg25, Modifier arg26, long arg27, long arg29, FontStyle arg31, FontWeight arg32, FontFamily arg33, long arg34, TextDecoration arg36, TextAlign arg37, long arg38, int arg40, boolean arg41, int arg42, Function1 arg43, TextStyle arg44, int arg45, int arg46, int arg47, Composer arg48, int arg49) {
        TextKt.Text-fLXpl1I(arg25, arg26, arg27, arg29, arg31, arg32, arg33, arg34, arg36, arg37, arg38, arg40, arg41, arg42, arg43, arg44, arg48, RecomposeScopeImplKt.updateChangedFlags(arg45 | 1), RecomposeScopeImplKt.updateChangedFlags(arg46), arg47);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString createTextWithLinkStyles(AnnotatedString arg1, TextLinkStyles arg2) {
        return arg1.mapAnnotations(new TextKt$$ExternalSyntheticLambda11(arg2));
    }

    static final Range createTextWithLinkStyles$lambda$21(TextLinkStyles arg9, Range arg10) {
        Object v1 = arg10.getItem();
        if((v1 instanceof Url)) {
            Object v3 = v1;
            if(((Url)v3).getStyles() == null) {
                Intrinsics.checkNotNull(arg10, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Url>");
                return Range.copy$default(arg10, Url.copy$default(((Url)v3), null, arg9, null, 5, null), 0, 0, null, 14, null);
            }
        }

        if(((v1 instanceof Clickable)) && ((Clickable)v1).getStyles() == null) {
            Intrinsics.checkNotNull(arg10, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation.Clickable>");
            return Range.copy$default(arg10, Clickable.copy$default(((Clickable)v1), null, arg9, null, 5, null), 0, 0, null, 14, null);
        }

        return arg10;
    }

    public static final ProvidableCompositionLocal getLocalTextStyle() {
        return TextKt.LocalTextStyle;
    }

    private static final TextLinkStyles rememberTextLinkStyles(Composer arg25, int arg26) {
        TextLinkStyles v2_2;
        Composer v0 = arg25;
        int v2 = 0x425C0EFB;
        ComposerKt.sourceInformationMarkerStart(v0, v2, "C(rememberTextLinkStyles)482@20251L11,483@20282L159:Text.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg26, -1, "androidx.compose.material3.rememberTextLinkStyles (Text.kt:481)");
        }

        long v3 = MaterialTheme.INSTANCE.getColorScheme(v0, 6).getPrimary-0d7_KjU();
        ComposerKt.sourceInformationMarkerStart(v0, 462704058, "CC(remember):Text.kt#9igjgp");
        boolean v1 = v0.changed(v3);
        Object v2_1 = v0.rememberedValue();
        if((v1) || v2_1 == Composer.Companion.getEmpty()) {
            TextLinkStyles v5 = new TextLinkStyles(new SpanStyle(v3, 0, null, null, null, null, null, 0, null, null, null, 0, TextDecoration.Companion.getUnderline(), null, null, null, 0xEFFE, null), null, null, null, 14, null);
            v0.updateRememberedValue(v5);
            v2_2 = v5;
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(v0);
        return v2_2;
    }
}

