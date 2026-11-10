package androidx.compose.foundation.text;

import androidx.compose.foundation.text.modifiers.SelectableTextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$TextSubstitutionValue;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001A\u0083\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u0099\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0\u001A2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001C\u0010\u001D\u001Aw\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001A\u008D\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0\u001A2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0016\u0010 \u001Aa\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u0010H\u0007¢\u0006\u0004\b!\u0010\"\u001Aw\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0\u001AH\u0007¢\u0006\u0004\b#\u0010$\u001Ak\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0010H\u0007¢\u0006\u0004\b#\u0010%\u001A\u0081\u0001\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\u0016\b\u0002\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000E2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0\u001AH\u0007¢\u0006\u0004\b\u001E\u0010&\u001A\u001E\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001A\u0004\u0018\u00010+H\u0002\u001A@\u0010,\u001A\u001E\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/\u0012\f\u0012\n\u0012\u0004\u0012\u000201\u0018\u0001000.\u0018\u00010-2\f\u00102\u001A\b\u0012\u0004\u0012\u0002030-2\f\u00104\u001A\b\u0012\u0004\u0012\u00020\u000E00H\u0002\u001AÉ\u0001\u00105\u001A\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00182\u0006\u0010\u0006\u001A\u00020\u00072\u0014\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u00106\u001A\u0002072\u0014\u00108\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0018\u00010-2\u001C\u0010;\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010=\u001A\u0004\u0018\u00010>2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0014\u0010?\u001A\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\bA\u0010B\u001A·\u0001\u0010C\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00182\u0014\u0010\b\u001A\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\u0006\u0010D\u001A\u00020\u000E2\u0014\b\u0002\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001B0\u001A2\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u00106\u001A\u0002072\b\u0010=\u001A\u0004\u0018\u00010>2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0014\u0010?\u001A\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\bE\u0010F¨\u0006G²\u0006\n\u0010H\u001A\u00020\u0018X\u008A\u008E\u0002"}, d2={"BasicText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Landroidx/compose/ui/text/TextStyle;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "BasicText-RWo7tUw", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/text/AnnotatedString;", "inlineContent", "", "Landroidx/compose/foundation/text/InlineTextContent;", "BasicText-CL7eQgs", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "BasicText-VhcvRP8", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText-BpD7jsM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILandroidx/compose/runtime/Composer;II)V", "BasicText-4YKlhWE", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/runtime/Composer;II)V", "selectionIdSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "measureWithTextRangeMeasureConstraints", "", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntOffset;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "shouldMeasureLinks", "textModifier", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "placeholders", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "textModifier-CL7eQgs", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;)Landroidx/compose/ui/Modifier;", "LayoutWithLinksAndInlineContent", "hasInlineContent", "LayoutWithLinksAndInlineContent-11Od_4g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/TextAutoSize;Landroidx/compose/runtime/Composer;III)V", "foundation", "displayedText"}, k=2, mv={2, 0, 0}, xi=0x30) public final class BasicTextKt {
    public static Unit $r8$lambda$3_N8UIU533ibeUqjTAAaOCCYZCw(MutableState arg0, List arg1) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$4$0(arg0, arg1);
    }

    public static AnnotatedString $r8$lambda$IUeU8J7jgA_Om7kUMzqhYmBdS-4(AnnotatedString arg0) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$2$0(arg0);
    }

    public static boolean $r8$lambda$JGzY3PAQWoicXOKo7g_T2qcP13Y(TextLinkScope arg0) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$7$0(arg0);
    }

    public static long $r8$lambda$KfNERdSZspclrPtF7-JGc-ik6ew(SelectionRegistrar arg2) {
        return BasicTextKt.BasicText_RWo7tUw$lambda$0$0(arg2);
    }

    public static Unit $r8$lambda$QIamDssrSz6f1AA87CxyOUpt1Tg(TextLinkScope arg0, Function1 arg1, TextLayoutResult arg2) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$6$0(arg0, arg1, arg2);
    }

    public static boolean $r8$lambda$YZjiog-e7SI4H2y73shVBmOST1I(TextLinkScope arg0) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$8$0(arg0);
    }

    public static Unit $r8$lambda$ae1CQlo-OZbKFUNQkrELWmtjpNM(MutableState arg0, TextSubstitutionValue arg1) {
        return BasicTextKt.BasicText_CL7eQgs$lambda$5$0(arg0, arg1);
    }

    public static List $r8$lambda$kN7FLDccAq-xT3g1TKVqSLGOjl8(MutableState arg0) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$9$0(arg0);
    }

    public static long $r8$lambda$n4vN65FWJZ64A2x_sVJud6oJ4vA(SelectionRegistrar arg2) {
        return BasicTextKt.BasicText_CL7eQgs$lambda$0$0(arg2);
    }

    public static AnnotatedString $r8$lambda$qfwpW3k9W9Myr_IU8yqcggZ1wto(TextLinkScope arg0, AnnotatedString arg1) {
        return BasicTextKt.LayoutWithLinksAndInlineContent_11Od_4g$lambda$1$0(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicText-4YKlhWE(AnnotatedString arg27, Modifier arg28, TextStyle arg29, Function1 arg30, int arg31, boolean arg32, int arg33, Map arg34, Composer arg35, int arg36, int arg37) {
        Modifier v2_2;
        Map v8_1;
        boolean v6_1;
        Function1 v4_1;
        TextStyle v3_1;
        Composer v22;
        Function1 v14_1;
        Modifier v12_2;
        int v26;
        int v19;
        int v18;
        int v0;
        int v16;
        int v14;
        int v12;
        Function1 v8;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v9 = arg36;
        int v10 = arg37;
        Composer v1 = arg35.startRestartGroup(0xD9570F18);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,inlineContent)409@18970L274:BasicText.kt#423gt5");
        AnnotatedString v11 = arg27;
        if((v9 & 6) == 0) {
            v2 = v1.changed(v11) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        int v3 = v10 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg28;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg28;
        }

        v5 = v10 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v9 & 0x180) == 0) {
            v6 = arg29;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_47:
            v6 = arg29;
        }

        v7 = v10 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg30;
            v12 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v12;
        }
        else {
        label_62:
            v8 = arg30;
        }

        v12 = v10 & 16;
        if(v12 != 0) {
            v2 |= 0x6000;
        }
        else if((v9 & 0x6000) == 0) {
            v14 = v1.changed(arg31) ? 0x4000 : 0x2000;
            v2 |= v14;
        }

        v14 = v10 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
        }
        else if((v15 & v9) == 0) {
            v16 = v1.changed(arg32) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        v16 = v10 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg33;
            if((v9 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v0 = v10 & 0x80;
        v18 = 0xC00000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_125;
        }
        else if((v9 & v18) == 0) {
            v19 = v0;
            int v20 = v1.changedInstance(arg34) ? 0x800000 : 0x400000;
            v2 |= v20;
        }
        else {
        label_125:
            v19 = v0;
        }

        int v35 = v3;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v35 != 0) {
                v26 = v12;
                Companion v12_1 = Modifier.Companion;
                v0 = v26;
            }
            else {
                v0 = v12;
                v12_2 = v4;
            }

            TextStyle v13 = v5 != 0 ? TextStyle.Companion.getDefault() : v6;
            if(v7 != 0) {
                v26 = v14;
                v14_1 = null;
                v3 = v26;
            }
            else {
                v3 = v14;
                v14_1 = v8;
            }

            v15 = v0 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg31;
            v0 = v16;
            boolean v16_1 = v3 != 0 ? true : arg32;
            v17 = v0 != 0 ? 0x7FFFFFFF : arg33;
            v0 = 0xD9570F18;
            Map v19_1 = v19 != 0 ? MapsKt.emptyMap() : arg34;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:408)");
            }

            v22 = v1;
            BasicTextKt.BasicText-CL7eQgs(v11, v12_2, v13, v14_1, v15, v16_1, v17, 1, v19_1, null, null, v22, v2 & 14 | v18 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | 0x380000 & v2 | v2 << 3 & 0xE000000, 0, 0x600);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = ((Companion)v12_2);
            v3_1 = v13;
            v4_1 = v14_1;
            v5 = v15;
            v6_1 = v16_1;
            v7 = v17;
            v8_1 = v19_1;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v5 = arg31;
            v7 = arg33;
            v2_2 = v4;
            v3_1 = v6;
            v4_1 = v8;
            v6_1 = arg32;
            v8_1 = arg34;
        }

        ScopeUpdateScope v11_1 = v22.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new BasicTextKt$$ExternalSyntheticLambda12(arg27, v2_2, v3_1, v4_1, v5, v6_1, v7, v8_1, v9, v10));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compat") public static final void BasicText-4YKlhWE(String arg25, Modifier arg26, TextStyle arg27, Function1 arg28, int arg29, boolean arg30, int arg31, int arg32, Composer arg33, int arg34, int arg35) {
        Modifier v2_2;
        int v8_1;
        boolean v6_1;
        Function1 v4_1;
        TextStyle v3_1;
        Composer v21;
        Function1 v14_1;
        Modifier v12_2;
        int v24;
        int v18;
        int v0;
        int v16;
        int v14;
        int v12;
        Function1 v8;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v9 = arg34;
        int v10 = arg35;
        Composer v1 = arg33.startRestartGroup(0x5BF3FBC9);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines)433@19643L86:BasicText.kt#423gt5");
        String v11 = arg25;
        if((v9 & 6) == 0) {
            v2 = v1.changed(v11) ? 4 : 2;
            v2 |= v9;
        }
        else {
            v2 = v9;
        }

        int v3 = v10 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v9 & 0x30) == 0) {
            v4 = arg26;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg26;
        }

        v5 = v10 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v9 & 0x180) == 0) {
            v6 = arg27;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_47:
            v6 = arg27;
        }

        v7 = v10 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v9 & 0xC00) == 0) {
            v8 = arg28;
            v12 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v12;
        }
        else {
        label_62:
            v8 = arg28;
        }

        v12 = v10 & 16;
        if(v12 != 0) {
            v2 |= 0x6000;
        }
        else if((v9 & 0x6000) == 0) {
            v14 = v1.changed(arg29) ? 0x4000 : 0x2000;
            v2 |= v14;
        }

        v14 = v10 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
        }
        else if((v15 & v9) == 0) {
            v16 = v1.changed(arg30) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        v16 = v10 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg31;
            if((v9 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v0 = v10 & 0x80;
        v18 = 0xC00000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_125;
        }
        else if((v9 & v18) == 0) {
            v18 = v0;
            int v19 = v1.changed(arg32) ? 0x800000 : 0x400000;
            v2 |= v19;
        }
        else {
        label_125:
            v18 = v0;
        }

        int v33 = v3;
        boolean v0_1 = (v2 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v33 != 0) {
                v24 = v12;
                Companion v12_1 = Modifier.Companion;
                v0 = v24;
            }
            else {
                v0 = v12;
                v12_2 = v4;
            }

            TextStyle v13 = v5 != 0 ? TextStyle.Companion.getDefault() : v6;
            if(v7 != 0) {
                v24 = v14;
                v14_1 = null;
                v3 = v24;
            }
            else {
                v3 = v14;
                v14_1 = v8;
            }

            v15 = v0 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg29;
            v0 = v16;
            boolean v16_1 = v3 != 0 ? true : arg30;
            v17 = v0 != 0 ? 0x7FFFFFFF : arg31;
            v0 = 0x5BF3FBC9;
            v18 = v18 != 0 ? 1 : arg32;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:433)");
            }

            v21 = v1;
            BasicTextKt.BasicText-RWo7tUw(v11, v12_2, v13, v14_1, v15, v16_1, v17, v18, null, null, v21, v2 & 0x1FFFFFE, 0x300);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = ((Companion)v12_2);
            v3_1 = v13;
            v4_1 = v14_1;
            v5 = v15;
            v6_1 = v16_1;
            v7 = v17;
            v8_1 = v18;
        }
        else {
            v21 = v1;
            v21.skipToGroupEnd();
            v5 = arg29;
            v7 = arg31;
            v2_2 = v4;
            v3_1 = v6;
            v4_1 = v8;
            v6_1 = arg30;
            v8_1 = arg32;
        }

        ScopeUpdateScope v11_1 = v21.endRestartGroup();
        if(v11_1 != null) {
            v11_1.updateScope(new BasicTextKt$$ExternalSyntheticLambda0(arg25, v2_2, v3_1, v4_1, v5, v6_1, v7, v8_1, v9, v10));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicText-BpD7jsM(String arg23, Modifier arg24, TextStyle arg25, Function1 arg26, int arg27, boolean arg28, int arg29, Composer arg30, int arg31, int arg32) {
        Modifier v2_2;
        Function1 v4_1;
        TextStyle v3_1;
        Composer v19;
        TextStyle v11_1;
        int v22;
        Modifier v10_1;
        int v0;
        int v15;
        boolean v14_1;
        int v13;
        int v11;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v8 = arg31;
        Composer v1 = arg30.startRestartGroup(0x3CF10926);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines)385@18278L235:BasicText.kt#423gt5");
        String v9 = arg23;
        if((v8 & 6) == 0) {
            v2 = v1.changed(v9) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        int v3 = arg32 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_31;
        }
        else if((v8 & 0x30) == 0) {
            v4 = arg24;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_31:
            v4 = arg24;
        }

        v5 = arg32 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_46;
        }
        else if((v8 & 0x180) == 0) {
            v6 = arg25;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_46:
            v6 = arg25;
        }

        v7 = arg32 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
        }
        else if((v8 & 0xC00) == 0) {
            v11 = v1.changedInstance(arg26) ? 0x800 : 0x400;
            v2 |= v11;
        }

        v11 = arg32 & 16;
        if(v11 != 0) {
            v2 |= 0x6000;
        }
        else if((v8 & 0x6000) == 0) {
            v13 = v1.changed(arg27) ? 0x4000 : 0x2000;
            v2 |= v13;
        }

        v13 = arg32 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v2 |= v14;
            goto label_92;
        }
        else if((v14 & v8) == 0) {
            v14_1 = arg28;
            v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v2 |= v15;
        }
        else {
        label_92:
            v14_1 = arg28;
        }

        v15 = arg32 & 0x40;
        int v16 = 0x180000;
        if(v15 != 0) {
            v2 |= v16;
        }
        else {
            v0 = arg29;
            if((v8 & v16) == 0) {
                int v17 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v17;
            }
        }

        int v30 = v3;
        boolean v0_1 = (v2 & 0x92493) != 0x92492 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v30 != 0) {
                Companion v10 = Modifier.Companion;
            }
            else {
                v10_1 = v4;
            }

            if(v5 != 0) {
                v22 = v11;
                v11_1 = TextStyle.Companion.getDefault();
                v0 = v22;
            }
            else {
                v0 = v11;
                v11_1 = v6;
            }

            Function1 v12 = v7 != 0 ? null : arg26;
            if(v0 != 0) {
                v22 = v13;
                v13 = TextOverflow.Companion.getClip-gIe3tQ8();
                v0 = v22;
            }
            else {
                v0 = v13;
                v13 = arg27;
            }

            if(v0 != 0) {
                v14_1 = true;
            }

            v15 = v15 != 0 ? 0x7FFFFFFF : arg29;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x3CF10926, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:384)");
            }

            v19 = v1;
            BasicTextKt.BasicText-RWo7tUw(v9, v10_1, v11_1, v12, v13, v14_1, v15, 1, null, null, v19, v2 & 14 | 0xC00000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | 0xE000 & v2 | 0x70000 & v2 | v2 & 0x380000, 0x300);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = ((Companion)v10_1);
            v3_1 = v11_1;
            v4_1 = v12;
            v5 = v13;
            v7 = v15;
        }
        else {
            v19 = v1;
            v19.skipToGroupEnd();
            v5 = arg27;
            v7 = arg29;
            v2_2 = v4;
            v3_1 = v6;
            v4_1 = arg26;
        }

        boolean v6_1 = v14_1;
        ScopeUpdateScope v10_2 = v19.endRestartGroup();
        if(v10_2 != null) {
            v10_2.updateScope(new BasicTextKt$$ExternalSyntheticLambda10(arg23, v2_2, v3_1, v4_1, v5, v6_1, v7, v8, arg32));
        }
    }

    public static final void BasicText-CL7eQgs(AnnotatedString arg36, Modifier arg37, TextStyle arg38, Function1 arg39, int arg40, boolean arg41, int arg42, int arg43, Map arg44, ColorProducer arg45, TextAutoSize arg46, Composer arg47, int arg48, int arg49, int arg50) {
        Companion v2_5;
        TextStyle v3_3;
        Function1 v4_2;
        boolean v6_3;
        Map v9_5;
        TextAutoSize v11_3;
        ColorProducer v10_4;
        Object v11_2;
        Composer v15_1;
        int v4_1;
        boolean v5_3;
        Composer v31;
        BasicTextKt$$ExternalSyntheticLambda20 v9_4;
        MutableState v0_7;
        Object v6_1;
        int v27;
        int v25;
        Function1 v24_1;
        TextStyle v22_1;
        Object v0_3;
        Companion v21_1;
        Companion v1_3;
        int v0_1;
        int v23;
        int v22;
        int v21;
        int v20;
        int v7;
        int v18;
        int v16;
        int v6;
        int v14;
        Function1 v13;
        int v12;
        TextStyle v11;
        int v10;
        int v5;
        AnnotatedString v1 = arg36;
        TextAutoSize v0 = arg46;
        int v15 = arg48;
        int v2 = arg50;
        Composer v4 = arg47.startRestartGroup(0xAFEC53B5);
        ComposerKt.sourceInformation(v4, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color,autoSize)202@10280L7,219@11037L7:BasicText.kt#423gt5");
        if((v15 & 6) == 0) {
            v5 = v4.changed(v1) ? 4 : 2;
            v5 |= v15;
        }
        else {
            v5 = v15;
        }

        int v8 = v2 & 2;
        if(v8 != 0) {
            v5 |= 0x30;
        }
        else if((v15 & 0x30) == 0) {
            v10 = v4.changed(arg37) ? 0x20 : 16;
            v5 |= v10;
        }

        v10 = v2 & 4;
        if(v10 != 0) {
            v5 |= 0x180;
            goto label_48;
        }
        else if((v15 & 0x180) == 0) {
            v11 = arg38;
            v12 = v4.changed(v11) ? 0x100 : 0x80;
            v5 |= v12;
        }
        else {
        label_48:
            v11 = arg38;
        }

        v12 = v2 & 8;
        if(v12 != 0) {
            v5 |= 0xC00;
            goto label_63;
        }
        else if((v15 & 0xC00) == 0) {
            v13 = arg39;
            v14 = v4.changedInstance(v13) ? 0x800 : 0x400;
            v5 |= v14;
        }
        else {
        label_63:
            v13 = arg39;
        }

        v14 = v2 & 16;
        if(v14 != 0) {
            v5 |= 0x6000;
            goto label_78;
        }
        else if((v15 & 0x6000) == 0) {
            v6 = arg40;
            v16 = v4.changed(v6) ? 0x4000 : 0x2000;
            v5 |= v16;
        }
        else {
        label_78:
            v6 = arg40;
        }

        v16 = v2 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v5 |= v17;
        }
        else {
            boolean v3 = arg41;
            if((v15 & v17) == 0) {
                v18 = v4.changed(v3) ? 0x20000 : 0x10000;
                v5 |= v18;
            }
        }

        v18 = v2 & 0x40;
        int v19 = 0x180000;
        if(v18 != 0) {
            v5 |= v19;
            v7 = arg42;
        }
        else {
            v7 = arg42;
            if((v15 & v19) == 0) {
                v20 = v4.changed(v7) ? 0x100000 : 0x80000;
                v5 |= v20;
            }
        }

        int v1_1 = v2 & 0x80;
        v20 = 0xC00000;
        if(v1_1 != 0) {
            v5 |= v20;
            goto label_125;
        }
        else if((v15 & v20) == 0) {
            v20 = v1_1;
            v21 = v4.changed(arg43) ? 0x800000 : 0x400000;
            v5 |= v21;
        }
        else {
        label_125:
            v20 = v1_1;
        }

        v1_1 = v2 & 0x100;
        v21 = 0x6000000;
        if(v1_1 != 0) {
            v5 |= v21;
            goto label_143;
        }
        else if((v15 & v21) == 0) {
            v21 = v1_1;
            v22 = v4.changedInstance(arg44) ? 0x4000000 : 0x2000000;
            v5 |= v22;
        }
        else {
        label_143:
            v21 = v1_1;
        }

        v1_1 = v2 & 0x200;
        v22 = 0x30000000;
        if(v1_1 != 0) {
            v5 |= v22;
            goto label_161;
        }
        else if((v15 & v22) == 0) {
            v22 = v1_1;
            v23 = v4.changedInstance(arg45) ? 0x20000000 : 0x10000000;
            v5 |= v23;
        }
        else {
        label_161:
            v22 = v1_1;
        }

        v1_1 = v2 & 0x400;
        if(v1_1 != 0) {
            v23 = arg49 | 6;
            goto label_166;
        }
        else if((arg49 & 6) == 0) {
            boolean v23_1 = (arg49 & 8) == 0 ? v4.changed(v0) : v4.changedInstance(v0);
            v23 = v23_1 ? 4 : 2;
            v23 |= arg49;
        label_166:
            v0_1 = v23;
        }
        else {
            v0_1 = arg49;
        }

        int v24 = v1_1;
        boolean v1_2 = (v5 & 306783379) != 306783378 || (v0_1 & 3) != 2 ? true : false;
        if(v4.shouldExecute(v1_2, v5 & 1)) {
            if(v8 != 0) {
                v1_3 = Modifier.Companion;
            }
            else {
                Modifier v1_4 = arg37;
            }

            TextStyle v2_1 = v10 != 0 ? TextStyle.Companion.getDefault() : v11;
            Function1 v3_1 = v12 != 0 ? null : v13;
            if(v14 != 0) {
                v6 = TextOverflow.Companion.getClip-gIe3tQ8();
            }

            boolean v10_1 = v16 != 0 ? true : arg41;
            if(v18 != 0) {
                v7 = 0x7FFFFFFF;
            }

            int v35 = v7;
            v7 = v6;
            v6 = v35;
            int v11_1 = v7;
            v7 = v20 != 0 ? 1 : arg43;
            Map v20_1 = v21 != 0 ? MapsKt.emptyMap() : arg44;
            ColorProducer v12_1 = v22 != 0 ? null : arg45;
            TextAutoSize v14_1 = v24 != 0 ? null : arg46;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xAFEC53B5, v5, v0_1, "androidx.compose.foundation.text.BasicText (BasicText.kt:200)");
            }

            HeightInLinesModifierKt.validateMinMaxLines(v7, v6);
            ProvidableCompositionLocal v8_1 = SelectionRegistrarKt.getLocalSelectionRegistrar();
            String v9 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v9);
            Object v8_2 = v4.consume(((CompositionLocal)v8_1));
            ComposerKt.sourceInformationMarkerEnd(v4);
            String v13_1 = "CC(remember):BasicText.kt#9igjgp";
            if(v8_2 != null) {
                v18 = v0_1;
                v4.startReplaceGroup(0x5EAB0CD5);
                ComposerKt.sourceInformation(v4, "205@10428L7,207@10582L77,207@10499L160,210@10672L180");
                ProvidableCompositionLocal v0_2 = TextSelectionColorsKt.getLocalTextSelectionColors();
                v21_1 = v1_3;
                ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v9);
                v0_3 = v4.consume(((CompositionLocal)v0_2));
                ComposerKt.sourceInformationMarkerEnd(v4);
                long v0_4 = ((TextSelectionColors)v0_3).getBackgroundColor-0d7_KjU();
                v22_1 = v2_1;
                Object[] v2_2 = new Object[]{v8_2};
                v24_1 = v3_1;
                Saver v3_2 = BasicTextKt.selectionIdSaver(((SelectionRegistrar)v8_2));
                v25 = v5;
                ComposerKt.sourceInformationMarkerStart(v4, 1713809186, v13_1);
                boolean v38 = v4.changedInstance(v8_2);
                Object v5_1 = v4.rememberedValue();
                if(!v38) {
                    v27 = v6;
                    if(v5_1 == Composer.Companion.getEmpty()) {
                        goto label_284;
                    }
                }
                else {
                    v27 = v6;
                label_284:
                    BasicTextKt$$ExternalSyntheticLambda19 v5_2 = new BasicTextKt$$ExternalSyntheticLambda19(((SelectionRegistrar)v8_2));
                    v4.updateRememberedValue(v5_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                long v2_3 = RememberSaveableKt.rememberSaveable(v2_2, v3_2, ((Function0)v5_1), v4, 0).longValue();
                ComposerKt.sourceInformationMarkerStart(v4, 0x6626B2C9, v13_1);
                v5 = v4.changed(v2_3) | v4.changed(v8_2) | v4.changed(v0_4);
                v6_1 = v4.rememberedValue();
                if(v5 != 0 || v6_1 == Composer.Companion.getEmpty()) {
                    SelectionController v6_2 = new SelectionController(v2_3, v8_2, v0_4, null, 8, null);
                    v4.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v18 = v0_1;
                v21_1 = v1_3;
                v22_1 = v2_1;
                v24_1 = v3_1;
                v25 = v5;
                v27 = v6;
                v4.startReplaceGroup(1588759409);
                v4.endReplaceGroup();
                v6_1 = null;
            }

            v2 = 2;
            boolean v19_1 = AnnotatedStringResolveInlineContentKt.hasInlineContent(arg36);
            boolean v0_5 = TextAnnotatedStringNodeKt.hasLinks(arg36);
            ProvidableCompositionLocal v1_5 = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(v4, 0x789C5F52, v9);
            Object v1_6 = v4.consume(((CompositionLocal)v1_5));
            ComposerKt.sourceInformationMarkerEnd(v4);
            v8_2 = v1_6;
            if((v19_1) || (v0_5)) {
                v1 = arg36;
                v15_1 = v4;
                v5_3 = v10_1;
                v4_1 = v11_1;
                v3_1 = v24_1;
                int v9_2 = 0;
                v11_2 = v6_1;
                v6 = v27;
                v15_1.startReplaceGroup(1590022070);
                ComposerKt.sourceInformation(v15_1, "253@12268L39,269@12876L292,255@12317L895");
                ComposerKt.sourceInformationMarkerStart(v15_1, 1713863100, v13_1);
                if((v25 & 14) == 4) {
                    v9_2 = 1;
                }

                v0_3 = v15_1.rememberedValue();
                if(v9_2 != 0 || v0_3 == Composer.Companion.getEmpty()) {
                    v0_7 = SnapshotStateKt.mutableStateOf$default(v1, null, v2, null);
                    v15_1.updateRememberedValue(v0_7);
                }

                ComposerKt.sourceInformationMarkerEnd(v15_1);
                AnnotatedString v17_1 = BasicTextKt.BasicText_CL7eQgs$lambda$3(v0_7);
                ComposerKt.sourceInformationMarkerStart(v15_1, 1713882809, v13_1);
                boolean v2_4 = v15_1.changed(v0_7);
                Object v9_3 = v15_1.rememberedValue();
                if((v2_4) || v9_3 == Composer.Companion.getEmpty()) {
                    v9_4 = new BasicTextKt$$ExternalSyntheticLambda20(v0_7);
                    v15_1.updateRememberedValue(v9_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v15_1);
                v2 = v25 << 6;
                v31 = v15_1;
                BasicTextKt.LayoutWithLinksAndInlineContent-11Od_4g(v21_1, v17_1, v3_1, v19_1, v20_1, v22_1, v4_1, v5_3, v6, v7, v8_2, v11_2, v12_1, v9_4, v14_1, v31, v25 >> 3 & 910 | v25 >> 12 & 0xE000 | v25 << 9 & 0x70000 | 0x380000 & v2 | 0x1C00000 & v2 | 0xE000000 & v2 | v2 & 0x70000000, v25 >> 21 & 0x380 | v18 << 12 & 0xE000, 0);
                v2_1 = v22_1;
                v21_1 = v21_1;
                v31.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(1589006262);
                ComposerKt.sourceInformation(v4, "222@11096L174,230@11349L746");
                BasicText_androidKt.BackgroundTextMeasurement(arg36, v22_1, v8_2, null, v4, v25 & 14 | 0xC00 | v25 >> 3 & 0x70);
                v31 = v4;
                v5_3 = v10_1;
                v1 = arg36;
                v4_1 = v11_1;
                v3_1 = v24_1;
                v15_1 = v31;
                v11_2 = v6_1;
                v6 = v27;
                Modifier v8_3 = BasicTextKt.textModifier-CL7eQgs(v21_1, v1, v22_1, v3_1, v4_1, v5_3, v6, v7, ((Resolver)v8_2), null, null, ((SelectionController)v11_2), v12_1, null, v14_1);
                v22_1 = v22_1;
                EmptyMeasurePolicy v0_6 = EmptyMeasurePolicy.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(v15_1, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
                v2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v15_1, 0));
                v8_3 = ComposedModifierKt.materializeModifier(v15_1, v8_3);
                CompositionLocalMap v9_1 = v15_1.getCurrentCompositionLocalMap();
                Function0 v10_2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(v15_1, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
                if(!(v15_1.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }

                v15_1.startReusableNode();
                if(v15_1.getInserting()) {
                    v15_1.createNode(v10_2);
                }
                else {
                    v15_1.useNode();
                }

                Composer v10_3 = Updater.constructor-impl(v15_1);
                Updater.set-impl(v10_3, v0_6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(v10_3, v9_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.reconcile-impl(v10_3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(v10_3, v8_3, ComposeUiNode.Companion.getSetModifier());
                Updater.init-impl(v10_3, Integer.valueOf(v2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                v15_1.endNode();
                ComposerKt.sourceInformationMarkerEnd(v15_1);
                ComposerKt.sourceInformationMarkerEnd(v15_1);
                v15_1.endReplaceGroup();
                v31 = v15_1;
                v2_1 = v22_1;
            }

            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v8 = v7;
            v10_4 = v12_1;
            v11_3 = v14_1;
            v9_5 = v20_1;
            v7 = v6;
            v6_3 = v5_3;
            v5 = v4_1;
            v4_2 = v3_1;
            v3_3 = v2_1;
            v2_5 = v21_1;
        }
        else {
            v1 = arg36;
            v31 = v4;
            v31.skipToGroupEnd();
            Modifier v2_6 = arg37;
            v8 = arg43;
            v9_5 = arg44;
            v10_4 = arg45;
            v5 = v6;
            v3_3 = v11;
            v4_2 = v13;
            v6_3 = arg41;
            v11_3 = arg46;
        }

        ScopeUpdateScope v15_2 = v31.endRestartGroup();
        if(v15_2 != null) {
            v15_2.updateScope(new BasicTextKt$$ExternalSyntheticLambda1(v1, ((Modifier)v2_5), v3_3, v4_2, v5, v6_3, v7, v8, v9_5, v10_4, v11_3, arg48, arg49, arg50));
        }
    }

    public static final void BasicText-RWo7tUw(String arg38, Modifier arg39, TextStyle arg40, Function1 arg41, int arg42, boolean arg43, int arg44, int arg45, ColorProducer arg46, TextAutoSize arg47, Composer arg48, int arg49, int arg50) {
        TextAutoSize v10_2;
        ColorProducer v9_1;
        int v7_2;
        boolean v6_3;
        int v5_2;
        Function1 v4_4;
        TextStyle v3_1;
        Modifier v2_6;
        Composer v0_8;
        Modifier v23;
        Modifier v0_6;
        int v30;
        TextStyle v25;
        Object v34;
        SelectionController v2_3;
        Object v2_2;
        BasicTextKt$$ExternalSyntheticLambda14 v4_2;
        int v29;
        Companion v7_1;
        int v21;
        int v20;
        int v19;
        int v2;
        boolean v5;
        int v16;
        int v15;
        int v14;
        Function1 v13;
        int v10;
        TextStyle v9;
        int v8;
        Modifier v7;
        int v4;
        String v1 = arg38;
        TextAutoSize v0 = arg47;
        int v11 = arg49;
        int v12 = arg50;
        Composer v3 = arg48.startRestartGroup(-1040751001);
        ComposerKt.sourceInformation(v3, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color,autoSize)104@5458L7,119@6129L7,121@6142L94,154@7432L41:BasicText.kt#423gt5");
        if((v11 & 6) == 0) {
            v4 = v3.changed(v1) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        int v6 = v12 & 2;
        if(v6 != 0) {
            v4 |= 0x30;
            goto label_33;
        }
        else if((v11 & 0x30) == 0) {
            v7 = arg39;
            v8 = v3.changed(v7) ? 0x20 : 16;
            v4 |= v8;
        }
        else {
        label_33:
            v7 = arg39;
        }

        v8 = v12 & 4;
        if(v8 != 0) {
            v4 |= 0x180;
            goto label_48;
        }
        else if((v11 & 0x180) == 0) {
            v9 = arg40;
            v10 = v3.changed(v9) ? 0x100 : 0x80;
            v4 |= v10;
        }
        else {
        label_48:
            v9 = arg40;
        }

        v10 = v12 & 8;
        if(v10 != 0) {
            v4 |= 0xC00;
            goto label_63;
        }
        else if((v11 & 0xC00) == 0) {
            v13 = arg41;
            v14 = v3.changedInstance(v13) ? 0x800 : 0x400;
            v4 |= v14;
        }
        else {
        label_63:
            v13 = arg41;
        }

        v14 = v12 & 16;
        if(v14 != 0) {
            v4 |= 0x6000;
            goto label_78;
        }
        else if((v11 & 0x6000) == 0) {
            v15 = arg42;
            v16 = v3.changed(v15) ? 0x4000 : 0x2000;
            v4 |= v16;
        }
        else {
        label_78:
            v15 = arg42;
        }

        v16 = v12 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v4 |= v17;
        }
        else {
            v5 = arg43;
            if((v11 & v17) == 0) {
                v17 = v3.changed(v5) ? 0x20000 : 0x10000;
                v4 |= v17;
            }
        }

        v17 = v12 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v4 |= v18;
        }
        else {
            v2 = arg44;
            if((v11 & v18) == 0) {
                v19 = v3.changed(v2) ? 0x100000 : 0x80000;
                v4 |= v19;
            }
        }

        v2 = v12 & 0x80;
        v19 = 0xC00000;
        if(v2 != 0) {
            v4 |= v19;
            goto label_125;
        }
        else if((v11 & v19) == 0) {
            v19 = v2;
            v20 = v3.changed(arg45) ? 0x800000 : 0x400000;
            v4 |= v20;
        }
        else {
        label_125:
            v19 = v2;
        }

        v2 = v12 & 0x100;
        v20 = 0x6000000;
        if(v2 != 0) {
            v4 |= v20;
            goto label_143;
        }
        else if((v11 & v20) == 0) {
            v20 = v2;
            v21 = v3.changedInstance(arg46) ? 0x4000000 : 0x2000000;
            v4 |= v21;
        }
        else {
        label_143:
            v20 = v2;
        }

        v2 = v12 & 0x200;
        v21 = 0x30000000;
        if(v2 != 0) {
        label_148:
            v4 |= v21;
        }
        else if((v11 & v21) == 0) {
            boolean v21_1 = (v11 & 0x40000000) == 0 ? v3.changed(v0) : v3.changedInstance(v0);
            if(v21_1) {
                v21 = 0x20000000;
                goto label_148;
            }

            v21 = 0x10000000;
            goto label_148;
        }

        v21 = v2;
        boolean v0_1 = (v4 & 306783379) != 306783378 ? true : false;
        if(v3.shouldExecute(v0_1, v4 & 1)) {
            if(v6 != 0) {
                v7_1 = Modifier.Companion;
            }

            if(v8 != 0) {
                v9 = TextStyle.Companion.getDefault();
            }

            Function1 v26 = v10 != 0 ? null : v13;
            int v27 = v14 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : v15;
            boolean v28 = v16 != 0 ? true : arg43;
            v2 = v17 != 0 ? 0x7FFFFFFF : arg44;
            v6 = v19 != 0 ? 1 : arg45;
            ColorProducer v35 = v20 != 0 ? null : arg46;
            TextAutoSize v37 = v21 != 0 ? null : arg47;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1040751001, v4, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:102)");
            }

            HeightInLinesModifierKt.validateMinMaxLines(v6, v2);
            ProvidableCompositionLocal v8_1 = SelectionRegistrarKt.getLocalSelectionRegistrar();
            v10 = 0x789C5F52;
            String v13_1 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(v3, v10, v13_1);
            Object v8_2 = v3.consume(((CompositionLocal)v8_1));
            ComposerKt.sourceInformationMarkerEnd(v3);
            if(v8_2 != null) {
                v3.startReplaceGroup(356423075);
                ComposerKt.sourceInformation(v3, "107@5606L7,109@5760L77,109@5677L160,112@5850L180");
                ProvidableCompositionLocal v14_1 = TextSelectionColorsKt.getLocalTextSelectionColors();
                ComposerKt.sourceInformationMarkerStart(v3, v10, v13_1);
                Object v14_2 = v3.consume(((CompositionLocal)v14_1));
                ComposerKt.sourceInformationMarkerEnd(v3);
                long v14_3 = ((TextSelectionColors)v14_2).getBackgroundColor-0d7_KjU();
                Object[] v0_2 = new Object[]{v8_2};
                Saver v10_1 = BasicTextKt.selectionIdSaver(((SelectionRegistrar)v8_2));
                v29 = v2;
                String v2_1 = "CC(remember):BasicText.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(v3, 0x21B7CC94, v2_1);
                v5 = v3.changedInstance(v8_2);
                v19 = v4;
                Object v4_1 = v3.rememberedValue();
                if((v5) || v4_1 == Composer.Companion.getEmpty()) {
                    v4_2 = new BasicTextKt$$ExternalSyntheticLambda14(((SelectionRegistrar)v8_2));
                    v3.updateRememberedValue(v4_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                long v4_3 = RememberSaveableKt.rememberSaveable(v0_2, v10_1, ((Function0)v4_2), v3, 0).longValue();
                ComposerKt.sourceInformationMarkerStart(v3, 0x21B7D83B, v2_1);
                int v0_3 = v3.changed(v4_3) | v3.changed(v8_2) | v3.changed(v14_3);
                v2_2 = v3.rememberedValue();
                if(v0_3 != 0 || v2_2 == Composer.Companion.getEmpty()) {
                    v2_3 = new SelectionController(v4_3, v8_2, v14_3, null, 8, null);
                    v3.updateRememberedValue(v2_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v3);
                v3.endReplaceGroup();
                v34 = v2_3;
            }
            else {
                v29 = v2;
                v19 = v4;
                v3.startReplaceGroup(0x1546143F);
                v3.endReplaceGroup();
                v34 = null;
            }

            ProvidableCompositionLocal v0_4 = CompositionLocalsKt.getLocalFontFamilyResolver();
            ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, v13_1);
            Object v0_5 = v3.consume(((CompositionLocal)v0_4));
            ComposerKt.sourceInformationMarkerEnd(v3);
            BasicText_androidKt.BackgroundTextMeasurement(v1, v9, ((Resolver)v0_5), v3, v19 & 14 | v19 >> 3 & 0x70);
            if(v34 != null || v26 != null || v37 != null) {
                v30 = v6;
                v25 = v9;
                v3.startReplaceGroup(0x154AEDF1);
                ComposerKt.sourceInformation(v3, "133@6715L7");
                AnnotatedString v0_7 = new AnnotatedString(v1, null, 2, null);
                ProvidableCompositionLocal v2_4 = CompositionLocalsKt.getLocalFontFamilyResolver();
                ComposerKt.sourceInformationMarkerStart(v3, 0x789C5F52, v13_1);
                v2_2 = v3.consume(((CompositionLocal)v2_4));
                ComposerKt.sourceInformationMarkerEnd(v3);
                v23 = ((Modifier)v7_1);
                v0_6 = BasicTextKt.textModifier-CL7eQgs(v23, v0_7, v25, v26, v27, v28, v29, v30, v2_2, null, null, ((SelectionController)v34), v35, null, v37);
                v3.endReplaceGroup();
            }
            else {
                v3.startReplaceGroup(0x1554C093);
                v3.endReplaceGroup();
                v25 = v9;
                v30 = v6;
                v0_6 = ((Modifier)v7_1).then(new TextStringSimpleElement(v1, v9, v0_5, v27, v28, v29, v6, v35, null));
                v23 = ((Modifier)v7_1);
            }

            EmptyMeasurePolicy v2_5 = EmptyMeasurePolicy.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(v3, 0x207BAF9A, "CC(Layout)P(1)124@5019L27,127@5185L389:Layout.kt#80mrfh");
            v4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v3, 0));
            v0_6 = ComposedModifierKt.materializeModifier(v3, v0_6);
            CompositionLocalMap v5_1 = v3.getCurrentCompositionLocalMap();
            Function0 v6_1 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v3, 1405779621, "CC(ReusableComposeNode)N(factory,update):Composables.kt#9igjgp");
            if(!(v3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v3.startReusableNode();
            if(v3.getInserting()) {
                v3.createNode(v6_1);
            }
            else {
                v3.useNode();
            }

            Composer v6_2 = Updater.constructor-impl(v3);
            Updater.set-impl(v6_2, v2_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v6_2, v5_1, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.reconcile-impl(v6_2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v6_2, v0_6, ComposeUiNode.Companion.getSetModifier());
            Updater.init-impl(v6_2, Integer.valueOf(v4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            v3.endNode();
            ComposerKt.sourceInformationMarkerEnd(v3);
            ComposerKt.sourceInformationMarkerEnd(v3);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v0_8 = v3;
            v2_6 = v23;
            v3_1 = v25;
            v4_4 = v26;
            v5_2 = v27;
            v6_3 = v28;
            v7_2 = v29;
            v8 = v30;
            v9_1 = v35;
            v10_2 = v37;
        }
        else {
            v3.skipToGroupEnd();
            v6_3 = arg43;
            v8 = arg45;
            v10_2 = arg47;
            v0_8 = v3;
            v2_6 = v7;
            v3_1 = v9;
            v4_4 = v13;
            v5_2 = v15;
            v7_2 = arg44;
            v9_1 = arg46;
        }

        ScopeUpdateScope v13_2 = v0_8.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new BasicTextKt$$ExternalSyntheticLambda15(v1, v2_6, v3_1, v4_4, v5_2, v6_3, v7_2, v8, v9_1, v10_2, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicText-RWo7tUw(AnnotatedString arg29, Modifier arg30, TextStyle arg31, Function1 arg32, int arg33, boolean arg34, int arg35, int arg36, Map arg37, ColorProducer arg38, Composer arg39, int arg40, int arg41) {
        ColorProducer v10_1;
        Map v9_1;
        int v8_1;
        boolean v6_1;
        Function1 v4_2;
        TextStyle v3_2;
        Companion v2_1;
        Composer v24;
        boolean v18_1;
        Companion v14_1;
        int v28;
        int v20;
        int v19;
        int v18;
        int v0;
        int v16;
        int v14;
        int v10;
        int v9;
        Function1 v8;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v11 = arg40;
        int v12 = arg41;
        Composer v1 = arg39.startRestartGroup(0xC08FFDC4);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent,color)360@17696L195:BasicText.kt#423gt5");
        AnnotatedString v13 = arg29;
        if((v11 & 6) == 0) {
            v2 = v1.changed(v13) ? 4 : 2;
            v2 |= v11;
        }
        else {
            v2 = v11;
        }

        int v3 = v12 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v11 & 0x30) == 0) {
            v4 = arg30;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg30;
        }

        v5 = v12 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v11 & 0x180) == 0) {
            v6 = arg31;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_47:
            v6 = arg31;
        }

        v7 = v12 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v11 & 0xC00) == 0) {
            v8 = arg32;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_62:
            v8 = arg32;
        }

        v9 = v12 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
            goto label_77;
        }
        else if((v11 & 0x6000) == 0) {
            v10 = arg33;
            v14 = v1.changed(v10) ? 0x4000 : 0x2000;
            v2 |= v14;
        }
        else {
        label_77:
            v10 = arg33;
        }

        v14 = v12 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
        }
        else if((v15 & v11) == 0) {
            v16 = v1.changed(arg34) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        v16 = v12 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg35;
            if((v11 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v0 = v12 & 0x80;
        v18 = 0xC00000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_125;
        }
        else if((v11 & v18) == 0) {
            v18 = v0;
            v19 = v1.changed(arg36) ? 0x800000 : 0x400000;
            v2 |= v19;
        }
        else {
        label_125:
            v18 = v0;
        }

        v0 = v12 & 0x100;
        v19 = 0x6000000;
        if(v0 != 0) {
            v2 |= v19;
            goto label_143;
        }
        else if((v11 & v19) == 0) {
            v19 = v0;
            v20 = v1.changedInstance(arg37) ? 0x4000000 : 0x2000000;
            v2 |= v20;
        }
        else {
        label_143:
            v19 = v0;
        }

        v0 = v12 & 0x200;
        v20 = 0x30000000;
        if(v0 != 0) {
            v2 |= v20;
            goto label_161;
        }
        else if((v11 & v20) == 0) {
            v20 = v0;
            int v21 = v1.changedInstance(arg38) ? 0x20000000 : 0x10000000;
            v2 |= v21;
        }
        else {
        label_161:
            v20 = v0;
        }

        int v39 = v3;
        boolean v0_1 = (v2 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v39 != 0) {
                v28 = v14;
                v14_1 = Modifier.Companion;
                v0 = v28;
            }
            else {
                v0 = v14;
                Modifier v14_2 = v4;
            }

            TextStyle v15_1 = v5 != 0 ? TextStyle.Companion.getDefault() : v6;
            Function1 v3_1 = null;
            int v4_1 = v16;
            Function1 v16_1 = v7 != 0 ? v3_1 : v8;
            v17 = v9 != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : v10;
            v5 = 0xC08FFDC4;
            if(v0 != 0) {
                v0 = v18;
                v18_1 = true;
            }
            else {
                v0 = v18;
                v18_1 = arg34;
            }

            if(v4_1 != 0) {
                v28 = v19;
                v19 = 0x7FFFFFFF;
                v4_1 = v28;
            }
            else {
                v4_1 = v19;
                v19 = arg35;
            }

            if(v0 != 0) {
                v0 = v20;
                v20 = 1;
            }
            else {
                v0 = v20;
                v20 = arg36;
            }

            Map v21_1 = v4_1 != 0 ? MapsKt.emptyMap() : arg37;
            ColorProducer v22 = v0 != 0 ? ((ColorProducer)v3_1) : arg38;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v5, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:359)");
            }

            v24 = v1;
            BasicTextKt.BasicText-CL7eQgs(v13, ((Modifier)v14_1), v15_1, v16_1, v17, v18_1, v19, v20, v21_1, v22, null, v24, v2 & 0x7FFFFFFE, 0, 0x400);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v2_1 = v14_1;
            v3_2 = v15_1;
            v4_2 = v16_1;
            v5 = v17;
            v6_1 = v18_1;
            v7 = v19;
            v8_1 = v20;
            v9_1 = v21_1;
            v10_1 = v22;
        }
        else {
            v24 = v1;
            v24.skipToGroupEnd();
            v7 = arg35;
            v9_1 = arg37;
            Modifier v2_2 = v4;
            v3_2 = v6;
            v4_2 = v8;
            v5 = v10;
            v6_1 = arg34;
            v8_1 = arg36;
            v10_1 = arg38;
        }

        ScopeUpdateScope v13_1 = v24.endRestartGroup();
        if(v13_1 != null) {
            v13_1.updateScope(new BasicTextKt$$ExternalSyntheticLambda11(arg29, ((Modifier)v2_1), v3_2, v4_2, v5, v6_1, v7, v8_1, v9_1, v10_1, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compat") public static final void BasicText-VhcvRP8(AnnotatedString arg28, Modifier arg29, TextStyle arg30, Function1 arg31, int arg32, boolean arg33, int arg34, int arg35, Map arg36, Composer arg37, int arg38, int arg39) {
        Modifier v2_2;
        Map v9_1;
        int v8_1;
        boolean v6_1;
        Function1 v4_1;
        TextStyle v3_1;
        Composer v23;
        TextStyle v14_1;
        int v27;
        Modifier v13_1;
        int v19;
        int v18;
        int v0;
        int v16;
        int v14;
        int v9;
        Function1 v8;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v10 = arg38;
        int v11 = arg39;
        Composer v1 = arg37.startRestartGroup(0x32BF773B);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,inlineContent)448@20200L281:BasicText.kt#423gt5");
        AnnotatedString v12 = arg28;
        if((v10 & 6) == 0) {
            v2 = v1.changed(v12) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        int v3 = v11 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg29;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg29;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg30;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_47:
            v6 = arg30;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg31;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_62:
            v8 = arg31;
        }

        v9 = v11 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
        }
        else if((v10 & 0x6000) == 0) {
            v14 = v1.changed(arg32) ? 0x4000 : 0x2000;
            v2 |= v14;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
        }
        else if((v15 & v10) == 0) {
            v16 = v1.changed(arg33) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        v16 = v11 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg34;
            if((v10 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v0 = v11 & 0x80;
        v18 = 0xC00000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_125;
        }
        else if((v10 & v18) == 0) {
            v18 = v0;
            v19 = v1.changed(arg35) ? 0x800000 : 0x400000;
            v2 |= v19;
        }
        else {
        label_125:
            v18 = v0;
        }

        v0 = v11 & 0x100;
        v19 = 0x6000000;
        if(v0 != 0) {
            v2 |= v19;
            goto label_143;
        }
        else if((v10 & v19) == 0) {
            v19 = v0;
            int v20 = v1.changedInstance(arg36) ? 0x4000000 : 0x2000000;
            v2 |= v20;
        }
        else {
        label_143:
            v19 = v0;
        }

        int v37 = v3;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v37 != 0) {
                Companion v13 = Modifier.Companion;
            }
            else {
                v13_1 = v4;
            }

            if(v5 != 0) {
                v27 = v14;
                v14_1 = TextStyle.Companion.getDefault();
                v0 = v27;
            }
            else {
                v0 = v14;
                v14_1 = v6;
            }

            Function1 v15_1 = v7 != 0 ? null : v8;
            if(v9 != 0) {
                v27 = v16;
                v16 = TextOverflow.Companion.getClip-gIe3tQ8();
                v3 = v27;
            }
            else {
                v3 = v16;
                v16 = arg32;
            }

            boolean v17_1 = v0 != 0 ? true : arg33;
            v0 = 0x32BF773B;
            if(v3 != 0) {
                v27 = v18;
                v18 = 0x7FFFFFFF;
                v3 = v27;
            }
            else {
                v3 = v18;
                v18 = arg34;
            }

            if(v3 != 0) {
                v3 = v19;
                v19 = 1;
            }
            else {
                v3 = v19;
                v19 = arg35;
            }

            Map v20_1 = v3 != 0 ? MapsKt.emptyMap() : arg36;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:448)");
            }

            v23 = v1;
            BasicTextKt.BasicText-CL7eQgs(v12, v13_1, v14_1, v15_1, v16, v17_1, v18, v19, v20_1, null, null, v23, v2 & 0xFFFFFFE, 0, 0x600);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = ((Companion)v13_1);
            v3_1 = v14_1;
            v4_1 = v15_1;
            v5 = v16;
            v6_1 = v17_1;
            v7 = v18;
            v8_1 = v19;
            v9_1 = v20_1;
        }
        else {
            v23 = v1;
            v23.skipToGroupEnd();
            v5 = arg32;
            v7 = arg34;
            v9_1 = arg36;
            v2_2 = v4;
            v3_1 = v6;
            v4_1 = v8;
            v6_1 = arg33;
            v8_1 = arg35;
        }

        ScopeUpdateScope v12_1 = v23.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new BasicTextKt$$ExternalSyntheticLambda13(arg28, v2_2, v3_1, v4_1, v5, v6_1, v7, v8_1, v9_1, v10, v11));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility") public static final void BasicText-VhcvRP8(String arg26, Modifier arg27, TextStyle arg28, Function1 arg29, int arg30, boolean arg31, int arg32, int arg33, ColorProducer arg34, Composer arg35, int arg36, int arg37) {
        Modifier v2_2;
        ColorProducer v9_1;
        int v8_1;
        boolean v6_1;
        Function1 v4_2;
        TextStyle v3_2;
        Composer v22;
        int v4_1;
        TextStyle v14_1;
        int v25;
        Modifier v13_1;
        int v19;
        int v18;
        int v0;
        int v16;
        int v14;
        int v9;
        Function1 v8;
        int v7;
        TextStyle v6;
        int v5;
        Modifier v4;
        int v2;
        int v10 = arg36;
        int v11 = arg37;
        Composer v1 = arg35.startRestartGroup(0xB94271D2);
        ComposerKt.sourceInformation(v1, "C(BasicText)N(text,modifier,style,onTextLayout,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,color)318@15279L93:BasicText.kt#423gt5");
        String v12 = arg26;
        if((v10 & 6) == 0) {
            v2 = v1.changed(v12) ? 4 : 2;
            v2 |= v10;
        }
        else {
            v2 = v10;
        }

        int v3 = v11 & 2;
        if(v3 != 0) {
            v2 |= 0x30;
            goto label_32;
        }
        else if((v10 & 0x30) == 0) {
            v4 = arg27;
            v5 = v1.changed(v4) ? 0x20 : 16;
            v2 |= v5;
        }
        else {
        label_32:
            v4 = arg27;
        }

        v5 = v11 & 4;
        if(v5 != 0) {
            v2 |= 0x180;
            goto label_47;
        }
        else if((v10 & 0x180) == 0) {
            v6 = arg28;
            v7 = v1.changed(v6) ? 0x100 : 0x80;
            v2 |= v7;
        }
        else {
        label_47:
            v6 = arg28;
        }

        v7 = v11 & 8;
        if(v7 != 0) {
            v2 |= 0xC00;
            goto label_62;
        }
        else if((v10 & 0xC00) == 0) {
            v8 = arg29;
            v9 = v1.changedInstance(v8) ? 0x800 : 0x400;
            v2 |= v9;
        }
        else {
        label_62:
            v8 = arg29;
        }

        v9 = v11 & 16;
        if(v9 != 0) {
            v2 |= 0x6000;
        }
        else if((v10 & 0x6000) == 0) {
            v14 = v1.changed(arg30) ? 0x4000 : 0x2000;
            v2 |= v14;
        }

        v14 = v11 & 0x20;
        int v15 = 0x30000;
        if(v14 != 0) {
            v2 |= v15;
        }
        else if((v15 & v10) == 0) {
            v16 = v1.changed(arg31) ? 0x20000 : 0x10000;
            v2 |= v16;
        }

        v16 = v11 & 0x40;
        int v17 = 0x180000;
        if(v16 != 0) {
            v2 |= v17;
        }
        else {
            v0 = arg32;
            if((v10 & v17) == 0) {
                v18 = v1.changed(v0) ? 0x100000 : 0x80000;
                v2 |= v18;
            }
        }

        v0 = v11 & 0x80;
        v18 = 0xC00000;
        if(v0 != 0) {
            v2 |= v18;
            goto label_125;
        }
        else if((v10 & v18) == 0) {
            v18 = v0;
            v19 = v1.changed(arg33) ? 0x800000 : 0x400000;
            v2 |= v19;
        }
        else {
        label_125:
            v18 = v0;
        }

        v0 = v11 & 0x100;
        v19 = 0x6000000;
        if(v0 != 0) {
            v2 |= v19;
            goto label_143;
        }
        else if((v10 & v19) == 0) {
            v19 = v0;
            int v20 = v1.changedInstance(arg34) ? 0x4000000 : 0x2000000;
            v2 |= v20;
        }
        else {
        label_143:
            v19 = v0;
        }

        int v35 = v3;
        boolean v0_1 = (v2 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_1, v2 & 1)) {
            if(v35 != 0) {
                Companion v13 = Modifier.Companion;
            }
            else {
                v13_1 = v4;
            }

            if(v5 != 0) {
                v25 = v14;
                v14_1 = TextStyle.Companion.getDefault();
                v0 = v25;
            }
            else {
                v0 = v14;
                v14_1 = v6;
            }

            Function1 v3_1 = null;
            Function1 v15_1 = v7 != 0 ? v3_1 : v8;
            if(v9 != 0) {
                v25 = v16;
                v16 = TextOverflow.Companion.getClip-gIe3tQ8();
                v4_1 = v25;
            }
            else {
                v4_1 = v16;
                v16 = arg30;
            }

            boolean v17_1 = v0 != 0 ? true : arg31;
            v0 = 0xB94271D2;
            if(v4_1 != 0) {
                v25 = v18;
                v18 = 0x7FFFFFFF;
                v4_1 = v25;
            }
            else {
                v4_1 = v18;
                v18 = arg32;
            }

            if(v4_1 != 0) {
                v4_1 = v19;
                v19 = 1;
            }
            else {
                v4_1 = v19;
                v19 = arg33;
            }

            ColorProducer v20_1 = v4_1 != 0 ? ((ColorProducer)v3_1) : arg34;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v2, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:317)");
            }

            v22 = v1;
            BasicTextKt.BasicText-RWo7tUw(v12, v13_1, v14_1, v15_1, v16, v17_1, v18, v19, v20_1, null, v22, v2 & 0xFFFFFFE, 0x200);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            Companion v2_1 = ((Companion)v13_1);
            v3_2 = v14_1;
            v4_2 = v15_1;
            v5 = v16;
            v6_1 = v17_1;
            v7 = v18;
            v8_1 = v19;
            v9_1 = v20_1;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v5 = arg30;
            v7 = arg32;
            v9_1 = arg34;
            v2_2 = v4;
            v3_2 = v6;
            v4_2 = v8;
            v6_1 = arg31;
            v8_1 = arg33;
        }

        ScopeUpdateScope v12_1 = v22.endRestartGroup();
        if(v12_1 != null) {
            v12_1.updateScope(new BasicTextKt$$ExternalSyntheticLambda16(arg26, v2_2, v3_2, v4_2, v5, v6_1, v7, v8_1, v9_1, v10, v11));
        }
    }

    static final Unit BasicText_4YKlhWE$lambda$0(AnnotatedString arg12, Modifier arg13, TextStyle arg14, Function1 arg15, int arg16, boolean arg17, int arg18, Map arg19, int arg20, int arg21, Composer arg22, int arg23) {
        BasicTextKt.BasicText-4YKlhWE(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_4YKlhWE$lambda$1(String arg12, Modifier arg13, TextStyle arg14, Function1 arg15, int arg16, boolean arg17, int arg18, int arg19, int arg20, int arg21, Composer arg22, int arg23) {
        BasicTextKt.BasicText-4YKlhWE(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_BpD7jsM$lambda$0(String arg11, Modifier arg12, TextStyle arg13, Function1 arg14, int arg15, boolean arg16, int arg17, int arg18, int arg19, Composer arg20, int arg21) {
        BasicTextKt.BasicText-BpD7jsM(arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg20, RecomposeScopeImplKt.updateChangedFlags(arg18 | 1), arg19);
        return Unit.INSTANCE;
    }

    private static final long BasicText_CL7eQgs$lambda$0$0(SelectionRegistrar arg2) {
        return arg2.nextSelectableId();
    }

    private static final AnnotatedString BasicText_CL7eQgs$lambda$3(MutableState arg0) {
        return ((State)arg0).getValue();
    }

    private static final void BasicText_CL7eQgs$lambda$4(MutableState arg0, AnnotatedString arg1) {
        arg0.setValue(arg1);
    }

    private static final Unit BasicText_CL7eQgs$lambda$5$0(MutableState arg1, TextSubstitutionValue arg2) {
        AnnotatedString v2 = arg2.isShowingSubstitution() ? arg2.getSubstitution() : arg2.getOriginal();
        BasicTextKt.BasicText_CL7eQgs$lambda$4(arg1, v2);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_CL7eQgs$lambda$6(AnnotatedString arg16, Modifier arg17, TextStyle arg18, Function1 arg19, int arg20, boolean arg21, int arg22, int arg23, Map arg24, ColorProducer arg25, TextAutoSize arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        BasicTextKt.BasicText-CL7eQgs(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    private static final long BasicText_RWo7tUw$lambda$0$0(SelectionRegistrar arg2) {
        return arg2.nextSelectableId();
    }

    static final Unit BasicText_RWo7tUw$lambda$2(String arg14, Modifier arg15, TextStyle arg16, Function1 arg17, int arg18, boolean arg19, int arg20, int arg21, ColorProducer arg22, TextAutoSize arg23, int arg24, int arg25, Composer arg26, int arg27) {
        BasicTextKt.BasicText-RWo7tUw(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_RWo7tUw$lambda$3(AnnotatedString arg14, Modifier arg15, TextStyle arg16, Function1 arg17, int arg18, boolean arg19, int arg20, int arg21, Map arg22, ColorProducer arg23, int arg24, int arg25, Composer arg26, int arg27) {
        BasicTextKt.BasicText-RWo7tUw(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_VhcvRP8$lambda$0(String arg13, Modifier arg14, TextStyle arg15, Function1 arg16, int arg17, boolean arg18, int arg19, int arg20, ColorProducer arg21, int arg22, int arg23, Composer arg24, int arg25) {
        BasicTextKt.BasicText-VhcvRP8(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit BasicText_VhcvRP8$lambda$1(AnnotatedString arg13, Modifier arg14, TextStyle arg15, Function1 arg16, int arg17, boolean arg18, int arg19, int arg20, Map arg21, int arg22, int arg23, Composer arg24, int arg25) {
        BasicTextKt.BasicText-VhcvRP8(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    private static final void LayoutWithLinksAndInlineContent-11Od_4g(Modifier arg31, AnnotatedString arg32, Function1 arg33, boolean arg34, Map arg35, TextStyle arg36, int arg37, boolean arg38, int arg39, int arg40, Resolver arg41, SelectionController arg42, ColorProducer arg43, Function1 arg44, TextAutoSize arg45, Composer arg46, int arg47, int arg48, int arg49) {
        Map v5_7;
        BasicTextKt$$ExternalSyntheticLambda7 v8_2;
        LinksTextMeasurePolicy v5_5;
        BasicTextKt$$ExternalSyntheticLambda6 v7_4;
        MutableState v0_2;
        Object v20_1;
        Object v0_1;
        BasicTextKt$$ExternalSyntheticLambda2 v5_3;
        Object v3_2;
        TextLinkScope v5_2;
        Object v5_1;
        int v20;
        int v26;
        int v21;
        int v11;
        int v2;
        AnnotatedString v0 = arg32;
        Function1 v6 = arg33;
        boolean v7 = arg34;
        TextAutoSize v15 = arg45;
        int v8 = arg47;
        int v9 = arg48;
        Composer v4 = arg46.startRestartGroup(0x81B92561);
        ComposerKt.sourceInformation(v4, "C(LayoutWithLinksAndInlineContent)N(modifier,text,onTextLayout,hasInlineContent,inlineContent,style,overflow:c#ui.text.style.TextOverflow,softWrap,maxLines,minLines,fontFamilyResolver,selectionController,color,onShowTranslation,autoSize)678@28236L162,694@28726L117,685@28404L1429:BasicText.kt#423gt5");
        Modifier v10 = arg31;
        if((v8 & 6) == 0) {
            v2 = v4.changed(v10) ? 4 : 2;
            v2 |= v8;
        }
        else {
            v2 = v8;
        }

        if((v8 & 0x30) == 0) {
            v11 = v4.changed(v0) ? 0x20 : 16;
            v2 |= v11;
        }

        if((v8 & 0x180) == 0) {
            v11 = v4.changedInstance(v6) ? 0x100 : 0x80;
            v2 |= v11;
        }

        int v16 = 0x800;
        int v17 = 0x400;
        if((v8 & 0xC00) == 0) {
            v11 = v4.changed(v7) ? v16 : v17;
            v2 |= v11;
        }

        v11 = arg49 & 16;
        int v18 = 0x4000;
        int v19 = 0x2000;
        if(v11 != 0) {
            v2 |= 0x6000;
        }
        else if((v8 & 0x6000) == 0) {
            v21 = v4.changedInstance(arg35) ? v18 : v19;
            v2 |= v21;
        }

        TextStyle v14 = arg36;
        if((v8 & 0x30000) == 0) {
            int v22 = v4.changed(v14) ? 0x20000 : 0x10000;
            v2 |= v22;
        }

        int v12 = arg37;
        if((v8 & 0x180000) == 0) {
            int v23 = v4.changed(v12) ? 0x100000 : 0x80000;
            v2 |= v23;
        }

        boolean v5 = arg38;
        if((v8 & 0xC00000) == 0) {
            int v24 = v4.changed(v5) ? 0x800000 : 0x400000;
            v2 |= v24;
        }

        int v13 = arg39;
        if((v8 & 0x6000000) == 0) {
            int v25 = v4.changed(v13) ? 0x4000000 : 0x2000000;
            v2 |= v25;
        }

        int v1 = arg40;
        if((v8 & 0x30000000) == 0) {
            v26 = v4.changed(v1) ? 0x20000000 : 0x10000000;
            v2 |= v26;
        }

        Resolver v1_1 = arg41;
        if((v9 & 6) == 0) {
            v20 = v4.changedInstance(v1_1) ? 4 : 2;
            v20 |= v9;
        }
        else {
            v20 = v9;
        }

        SelectionController v7_1 = arg42;
        if((v9 & 0x30) == 0) {
            v26 = v4.changedInstance(v7_1) ? 0x20 : 16;
            v20 |= v26;
        }

        if((v9 & 0x180) == 0) {
            v21 = v4.changedInstance(arg43) ? 0x100 : 0x80;
            v20 |= v21;
        }

        if((v9 & 0xC00) == 0) {
            if(v4.changedInstance(arg44)) {
            }
            else {
                v16 = v17;
            }

            v20 |= v16;
        }

        if((v9 & 0x6000) == 0) {
            boolean v1_2 = (0x8000 & v9) == 0 ? v4.changed(v15) : v4.changedInstance(v15);
            if(v1_2) {
            }
            else {
                v18 = v19;
            }

            v20 |= v18;
        }

        v1 = v20;
        v16 = 1;
        boolean v3 = (v2 & 306783379) != 306783378 || (v1 & 9363) != 9362 ? true : false;
        if(v4.shouldExecute(v3, v2 & 1)) {
            Map v11_1 = v11 != 0 ? MapsKt.emptyMap() : arg35;
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x81B92561, v2, v1, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:646)");
            }

            String v7_2 = "CC(remember):BasicText.kt#9igjgp";
            if(TextAnnotatedStringNodeKt.hasLinks(v0)) {
                v4.startReplaceGroup(0x8AE5063);
                ComposerKt.sourceInformation(v4, "650@27301L38");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF805A127, v7_2);
                int v3_1 = (v2 & 0x70) == 0x20 ? 1 : 0;
                v5_1 = v4.rememberedValue();
                if(v3_1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                    v5_2 = new TextLinkScope(v0);
                    v4.updateRememberedValue(v5_2);
                }

                v3_2 = v5_2;
                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(0x8AF50DC);
                v4.endReplaceGroup();
                v3_2 = null;
            }

            if(TextAnnotatedStringNodeKt.hasLinks(v0)) {
                v4.startReplaceGroup(145905443);
                ComposerKt.sourceInformation(v4, "657@27566L70");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF805C267, v7_2);
                v17 = v1;
                v1 = (v2 & 0x70) == 0x20 ? 1 : 0;
                v1 |= v4.changed(v3_2);
                v5_1 = v4.rememberedValue();
                if(v1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                    v5_3 = new BasicTextKt$$ExternalSyntheticLambda2(((TextLinkScope)v3_2), v0);
                    v4.updateRememberedValue(v5_3);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v17 = v1;
                v4.startReplaceGroup(146002721);
                ComposerKt.sourceInformation(v4, "659@27666L8");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF805CEA9, v7_2);
                v1 = (v2 & 0x70) == 0x20 ? 1 : 0;
                v5_1 = v4.rememberedValue();
                if(v1 != 0 || v5_1 == Composer.Companion.getEmpty()) {
                    BasicTextKt$$ExternalSyntheticLambda3 v5_4 = new BasicTextKt$$ExternalSyntheticLambda3(v0);
                    v4.updateRememberedValue(v5_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }

            Object v18_1 = v5_3;
            Pair v1_3 = arg34 ? AnnotatedStringResolveInlineContentKt.resolveInlineContent(v0, v11_1) : new Pair(null, null);
            v5_1 = v1_3.component1();
            Object v1_4 = v1_3.component2();
            if(arg34) {
                v4.startReplaceGroup(0x8B8A5EC);
                ComposerKt.sourceInformation(v4, "670@27983L61");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF805F67E, v7_2);
                v0_1 = v4.rememberedValue();
                v20_1 = v1_4;
                if(v0_1 == Composer.Companion.getEmpty()) {
                    v1_4 = null;
                    v0_2 = SnapshotStateKt.mutableStateOf$default(v1_4, ((SnapshotMutationPolicy)v1_4), 2, v1_4);
                    v4.updateRememberedValue(v0_2);
                }
                else {
                    v1_4 = null;
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v20_1 = v1_4;
                v1_4 = null;
                v4.startReplaceGroup(0x8B9FCBC);
                v4.endReplaceGroup();
                v0_1 = v1_4;
            }

            if(arg34) {
                v4.startReplaceGroup(0x8BB68FD);
                ComposerKt.sourceInformation(v4, "675@28166L44");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF8060D4D, v7_2);
                boolean v35 = v4.changed(v0_2);
                v1_4 = v4.rememberedValue();
                if(!v35) {
                    v21 = v2;
                    if(v1_4 == Composer.Companion.getEmpty()) {
                        goto label_330;
                    }
                }
                else {
                    v21 = v2;
                label_330:
                    BasicTextKt$$ExternalSyntheticLambda4 v1_5 = new BasicTextKt$$ExternalSyntheticLambda4(v0_2);
                    v4.updateRememberedValue(v1_5);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
            }
            else {
                v21 = v2;
                v4.startReplaceGroup(0x8BC7FFC);
                v4.endReplaceGroup();
            }

            Object v19_1 = v1_4;
            v1 = v21 >> 3 & 14;
            int v29 = v1;
            Object v8_1 = v3_2;
            Object v27 = v20_1;
            Object v28 = v0_2;
            v0 = arg32;
            BasicText_androidKt.BackgroundTextMeasurement(v0, v14, arg41, v5_1, v4, v17 << 6 & 0x380 | (v21 >> 12 & 0x70 | v1));
            Object v17_1 = v5_1;
            v1_4 = ((Function0)v18_1).invoke();
            ComposerKt.sourceInformationMarkerStart(v4, 0xF8065396, v7_2);
            boolean v2_1 = v4.changedInstance(v8_1);
            if((v21 & 0x380) == 0x100) {
            }
            else {
                v16 = 0;
            }

            v3_2 = v4.rememberedValue();
            if(((((int)v2_1)) | v16) != 0 || v3_2 == Composer.Companion.getEmpty()) {
                BasicTextKt$$ExternalSyntheticLambda5 v3_3 = new BasicTextKt$$ExternalSyntheticLambda5(((TextLinkScope)v8_1), v6);
                v4.updateRememberedValue(v3_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            Object v9_1 = v1_4;
            Map v1_6 = v11_1;
            Object v11_2 = v3_2;
            v3_2 = v8_1;
            Modifier v2_2 = BasicTextKt.textModifier-CL7eQgs(v10, ((AnnotatedString)v9_1), arg36, ((Function1)v11_2), v12, arg38, v13, arg40, arg41, ((List)v17_1), v19_1, arg42, arg43, arg44, v15);
            if(!arg34) {
                v4.startReplaceGroup(0x8CE8017);
                ComposerKt.sourceInformation(v4, "713@29493L55");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF806B338, v7_2);
                v5 = v4.changedInstance(v3_2);
                Object v7_3 = v4.rememberedValue();
                if((v5) || v7_3 == Composer.Companion.getEmpty()) {
                    v7_4 = new BasicTextKt$$ExternalSyntheticLambda6(((TextLinkScope)v3_2));
                    v4.updateRememberedValue(v7_4);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v5_5 = new LinksTextMeasurePolicy(((Function0)v7_4));
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(0x8D13291);
                ComposerKt.sourceInformation(v4, "717@29664L55,718@29754L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0xF806C898, v7_2);
                v5 = v4.changedInstance(v3_2);
                v8_1 = v4.rememberedValue();
                if((v5) || v8_1 == Composer.Companion.getEmpty()) {
                    v8_2 = new BasicTextKt$$ExternalSyntheticLambda7(((TextLinkScope)v3_2));
                    v4.updateRememberedValue(v8_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                ComposerKt.sourceInformationMarkerStart(v4, 0xF806D3C8, v7_2);
                v5_1 = v28;
                v7 = v4.changed(v5_1);
                v9_1 = v4.rememberedValue();
                if((v7) || v9_1 == Composer.Companion.getEmpty()) {
                    BasicTextKt$$ExternalSyntheticLambda8 v9_2 = new BasicTextKt$$ExternalSyntheticLambda8(((MutableState)v5_1));
                    v4.updateRememberedValue(v9_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                TextMeasurePolicy v5_6 = new TextMeasurePolicy(((Function0)v8_2), ((Function0)v9_1));
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xBAE1EBD9, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int v7_5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(v4, 0));
            CompositionLocalMap v8_3 = v4.getCurrentCompositionLocalMap();
            v2_2 = ComposedModifierKt.materializeModifier(v4, v2_2);
            Function0 v9_3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(v4, 0xDF082A64, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if(!(v4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }

            v4.startReusableNode();
            if(v4.getInserting()) {
                v4.createNode(v9_3);
            }
            else {
                v4.useNode();
            }

            Composer v9_4 = Updater.constructor-impl(v4);
            Updater.set-impl(v9_4, v5_5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(v9_4, v8_3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(v9_4, Integer.valueOf(v7_5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(v9_4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(v9_4, v2_2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(v4, 0xE6285356, "C:BasicText.kt#423gt5");
            if(v3_2 == null) {
                v4.startReplaceGroup(-433557001);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(-291080374);
                ComposerKt.sourceInformation(v4, "687@28455L18");
                ((TextLinkScope)v3_2).LinksComposables(v4, 0);
                v4.endReplaceGroup();
            }

            Object v2_3 = v27;
            if(v2_3 == null) {
                v4.startReplaceGroup(0xE6293851);
                v4.endReplaceGroup();
            }
            else {
                v4.startReplaceGroup(-433506222);
                ComposerKt.sourceInformation(v4, "*688@28511L48");
                AnnotatedStringResolveInlineContentKt.InlineChildren(v0, ((List)v2_3), v4, v29);
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v4.endNode();
            ComposerKt.sourceInformationMarkerEnd(v4);
            ComposerKt.sourceInformationMarkerEnd(v4);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v5_7 = v1_6;
        }
        else {
            v4.skipToGroupEnd();
            v5_7 = arg35;
        }

        ScopeUpdateScope v1_7 = v4.endRestartGroup();
        if(v1_7 != null) {
            v1_7.updateScope(new BasicTextKt$$ExternalSyntheticLambda9(arg31, arg32, v6, arg34, v5_7, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg47, arg48, arg49));
        }
    }

    private static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$1$0(TextLinkScope arg0, AnnotatedString arg1) {
        if(arg0 != null) {
            AnnotatedString v0 = arg0.applyAnnotators$foundation();
            if(v0 == null) {
            }
            else {
                return v0;
            }
        }

        return arg1;
    }

    static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$10(Modifier arg20, AnnotatedString arg21, Function1 arg22, boolean arg23, Map arg24, TextStyle arg25, int arg26, boolean arg27, int arg28, int arg29, Resolver arg30, SelectionController arg31, ColorProducer arg32, Function1 arg33, TextAutoSize arg34, int arg35, int arg36, int arg37, Composer arg38, int arg39) {
        BasicTextKt.LayoutWithLinksAndInlineContent-11Od_4g(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg38, RecomposeScopeImplKt.updateChangedFlags(arg35 | 1), RecomposeScopeImplKt.updateChangedFlags(arg36), arg37);
        return Unit.INSTANCE;
    }

    private static final AnnotatedString LayoutWithLinksAndInlineContent_11Od_4g$lambda$2$0(AnnotatedString arg0) {
        return arg0;
    }

    private static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$4$0(MutableState arg0, List arg1) {
        if(arg0 != null) {
            arg0.setValue(arg1);
        }

        return Unit.INSTANCE;
    }

    private static final Unit LayoutWithLinksAndInlineContent_11Od_4g$lambda$6$0(TextLinkScope arg0, Function1 arg1, TextLayoutResult arg2) {
        if(arg0 != null) {
            arg0.setTextLayoutResult(arg2);
        }

        if(arg1 != null) {
            arg1.invoke(arg2);
        }

        return Unit.INSTANCE;
    }

    private static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$7$0(TextLinkScope arg0) {
        if(arg0 != null) {
            return arg0.getShouldMeasureLinks().invoke().booleanValue();
        }

        return 0;
    }

    private static final boolean LayoutWithLinksAndInlineContent_11Od_4g$lambda$8$0(TextLinkScope arg0) {
        if(arg0 != null) {
            return arg0.getShouldMeasureLinks().invoke().booleanValue();
        }

        return 0;
    }

    private static final List LayoutWithLinksAndInlineContent_11Od_4g$lambda$9$0(MutableState arg0) {
        if(arg0 != null) {
            return arg0.getValue();
        }

        return null;
    }

    public static final List access$measureWithTextRangeMeasureConstraints(List arg0, Function0 arg1) {
        return BasicTextKt.measureWithTextRangeMeasureConstraints(arg0, arg1);
    }

    private static final List measureWithTextRangeMeasureConstraints(List arg10, Function0 arg11) {
        if(arg11.invoke().booleanValue()) {
            TextRangeLayoutMeasureScope v11 = new TextRangeLayoutMeasureScope();
            ArrayList v0 = new ArrayList(arg10.size());
            int v1 = arg10.size();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                Object v3 = arg10.get(v2);
                Object v4 = ((Measurable)v3).getParentData();
                Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
                TextRangeLayoutMeasureResult v4_1 = ((TextRangeLayoutModifier)v4).getMeasurePolicy().measure(v11);
                v0.add(new Pair(((Measurable)v3).measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(v4_1.getWidth(), v4_1.getWidth(), v4_1.getHeight(), v4_1.getHeight())), v4_1.getPlace()));
            }

            return ((List)v0);
        }

        return null;
    }

    private static final Saver selectionIdSaver(SelectionRegistrar arg1) {
        return SaverKt.Saver(new BasicTextKt$$ExternalSyntheticLambda17(arg1), new BasicTextKt$$ExternalSyntheticLambda18());
    }

    static final Long selectionIdSaver$lambda$0(SelectionRegistrar arg0, SaverScope arg1, long arg2) {
        if(SelectionRegistrarKt.hasSelection(arg0, arg2)) {
            return Long.valueOf(arg2);
        }

        return null;
    }

    static final Long selectionIdSaver$lambda$1(long arg0) {
        return Long.valueOf(arg0);
    }

    private static final Modifier textModifier-CL7eQgs(Modifier arg17, AnnotatedString arg18, TextStyle arg19, Function1 arg20, int arg21, boolean arg22, int arg23, int arg24, Resolver arg25, List arg26, Function1 arg27, SelectionController arg28, ColorProducer arg29, Function1 arg30, TextAutoSize arg31) {
        Modifier v0 = arg17;
        if(arg28 == null) {
            return v0.then(Modifier.Companion).then(new TextAnnotatedStringElement(arg18, arg19, arg25, arg20, arg21, arg22, arg23, arg24, arg26, arg27, null, arg29, arg31, arg30, null));
        }

        return v0.then(arg28.getModifier()).then(new SelectableTextAnnotatedStringElement(arg18, arg19, arg25, arg20, arg21, arg22, arg23, arg24, arg26, arg27, arg28, arg29, arg31, null));
    }
}

