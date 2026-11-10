package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010!\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001nBÓ\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001A\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001E\b\u0002\u0010\u001A\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u0017\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0010\u00102\u001A\u0002002\u0006\u00104\u001A\u000205H\u0002J\u0018\u00106\u001A\u00020\u00122\b\u00107\u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u0007\u001A\u00020\bJ\u0015\u00108\u001A\u00020\u00122\u0006\u0010\u0005\u001A\u00020\u0006H\u0000¢\u0006\u0002\b9J]\u0010:\u001A\u00020\u00122\u0006\u0010\u0007\u001A\u00020\b2\u0014\u0010\u0016\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010 \u001A\u0004\u0018\u00010!¢\u0006\u0004\b;\u0010<JZ\u0010=\u001A\u00020\u00122\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f2\u001C\u0010\u001A\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u0017\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\u0014\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fJ&\u0010>\u001A\u00020\u000E2\u0006\u0010?\u001A\u00020\u00122\u0006\u0010@\u001A\u00020\u00122\u0006\u0010A\u001A\u00020\u00122\u0006\u0010B\u001A\u00020\u0012J\u0010\u0010J\u001A\u00020\u00122\u0006\u0010K\u001A\u00020\u0006H\u0002J\b\u0010L\u001A\u00020\u000EH\u0002J\r\u0010M\u001A\u00020\u000EH\u0000¢\u0006\u0002\bNJ\f\u0010O\u001A\u00020\u000E*\u00020PH\u0016J%\u0010Q\u001A\u00020R2\u0006\u0010S\u001A\u00020T2\u0006\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020X¢\u0006\u0004\bY\u0010ZJ#\u0010[\u001A\u00020R*\u00020T2\u0006\u0010U\u001A\u00020V2\u0006\u0010W\u001A\u00020XH\u0016¢\u0006\u0004\b\\\u0010ZJ\u001E\u0010]\u001A\u00020\u00142\u0006\u0010^\u001A\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010a\u001A\u00020\u0014J\u001C\u0010b\u001A\u00020\u0014*\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010a\u001A\u00020\u0014H\u0016J\u001E\u0010c\u001A\u00020\u00142\u0006\u0010^\u001A\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010d\u001A\u00020\u0014J\u001C\u0010e\u001A\u00020\u0014*\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010d\u001A\u00020\u0014H\u0016J\u001E\u0010f\u001A\u00020\u00142\u0006\u0010^\u001A\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010a\u001A\u00020\u0014J\u001C\u0010g\u001A\u00020\u0014*\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010a\u001A\u00020\u0014H\u0016J\u001E\u0010h\u001A\u00020\u00142\u0006\u0010^\u001A\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010d\u001A\u00020\u0014J\u001C\u0010i\u001A\u00020\u0014*\u00020_2\u0006\u0010U\u001A\u00020`2\u0006\u0010d\u001A\u00020\u0014H\u0016J\u000E\u0010j\u001A\u00020\u000E2\u0006\u0010k\u001A\u00020lJ\f\u0010m\u001A\u00020\u000E*\u00020lH\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0004\n\u0002\u0010&R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\u0016\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017X\u0082\u000E¢\u0006\u0002\n\u0000R$\u0010\u001A\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u0017\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001E\u001A\u0004\u0018\u00010\u001FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010 \u001A\u0004\u0018\u00010!X\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\'\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b(\u0010)R\"\u0010*\u001A\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0014\u0018\u00010+X\u0082\u000E¢\u0006\b\n\u0000\u0012\u0004\b-\u0010.R\u0010\u0010/\u001A\u0004\u0018\u000100X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u00101\u001A\u0002008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b2\u00103R\"\u0010C\u001A\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0D\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010E\u001A\u0004\u0018\u00010#X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006o"}, d2={"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "baselineCache", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getBaselineCache$annotations", "()V", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "layoutCache", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "density", "Landroidx/compose/ui/unit/Density;", "updateDraw", "color", "updateText", "updateText$foundation", "updateLayoutRelatedArgs", "updateLayoutRelatedArgs-y0k-MQk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILandroidx/compose/foundation/text/TextAutoSize;)Z", "updateCallbacks", "doInvalidations", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "semanticsTextLayoutResult", "", "textSubstitution", "getTextSubstitution$foundation", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "setSubstitution", "updatedText", "invalidateForTranslate", "clearSubstitution", "clearSubstitution$foundation", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "measureNonExtension", "Landroidx/compose/ui/layout/MeasureResult;", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "measure-3p2s80s", "minIntrinsicWidthNonExtension", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "minIntrinsicHeightNonExtension", "width", "minIntrinsicHeight", "maxIntrinsicWidthNonExtension", "maxIntrinsicWidth", "maxIntrinsicHeightNonExtension", "maxIntrinsicHeight", "drawNonExtension", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "TextSubstitutionValue", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextAnnotatedStringNode extends Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÆ\u0003J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u00062\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\f\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2={"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "", "original", "Landroidx/compose/ui/text/AnnotatedString;", "substitution", "isShowingSubstitution", "", "layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "()Z", "setShowingSubstitution", "(Z)V", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextSubstitutionValue {
        public static final int $stable = 8;
        private boolean isShowingSubstitution;
        private MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;

        static {
        }

        public TextSubstitutionValue(AnnotatedString arg1, AnnotatedString arg2, boolean arg3, MultiParagraphLayoutCache arg4, int arg5, DefaultConstructorMarker arg6) {
            if((arg5 & 8) != 0) {
                arg4 = null;
            }

            this(arg1, arg2, false, arg4);
        }

        public TextSubstitutionValue(AnnotatedString arg1, AnnotatedString arg2, boolean arg3, MultiParagraphLayoutCache arg4) {
            super();
            this.original = arg1;
            this.substitution = arg2;
            this.isShowingSubstitution = arg3;
            this.layoutCache = arg4;
        }

        public final AnnotatedString component1() {
            return this.original;
        }

        public final AnnotatedString component2() {
            return this.substitution;
        }

        public final boolean component3() {
            return this.isShowingSubstitution;
        }

        public final MultiParagraphLayoutCache component4() {
            return this.layoutCache;
        }

        public final TextSubstitutionValue copy(AnnotatedString arg1, AnnotatedString arg2, boolean arg3, MultiParagraphLayoutCache arg4) {
            return new TextSubstitutionValue(arg1, arg2, arg3, arg4);
        }

        public static TextSubstitutionValue copy$default(TextSubstitutionValue arg0, AnnotatedString arg1, AnnotatedString arg2, boolean arg3, MultiParagraphLayoutCache arg4, int arg5, Object arg6) {
            if((arg5 & 1) != 0) {
                arg1 = arg0.original;
            }

            if((arg5 & 2) != 0) {
                arg2 = arg0.substitution;
            }

            if((arg5 & 4) != 0) {
                arg3 = arg0.isShowingSubstitution;
            }

            if((arg5 & 8) != 0) {
                arg4 = arg0.layoutCache;
            }

            return arg0.copy(arg1, arg2, arg3, arg4);
        }

        public boolean equals(Object arg5) {
            if(this == (((TextSubstitutionValue)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof TextSubstitutionValue)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.original, ((TextSubstitutionValue)arg5).original)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.substitution, ((TextSubstitutionValue)arg5).substitution)) {
                return 0;
            }

            if(this.isShowingSubstitution != ((TextSubstitutionValue)arg5).isShowingSubstitution) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.layoutCache, ((TextSubstitutionValue)arg5).layoutCache)) {
                return 0;
            }

            return 1;
        }

        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int v0 = ((this.original.hashCode() * 0x1F + this.substitution.hashCode()) * 0x1F + Boolean.hashCode(this.isShowingSubstitution)) * 0x1F;
            MultiParagraphLayoutCache v2 = this.layoutCache;
            int v2_1 = v2 == null ? 0 : v2.hashCode();
            return v0 + v2_1;
        }

        public final boolean isShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(MultiParagraphLayoutCache arg1) {
            this.layoutCache = arg1;
        }

        public final void setShowingSubstitution(boolean arg1) {
            this.isShowingSubstitution = arg1;
        }

        public final void setSubstitution(AnnotatedString arg1) {
            this.substitution = arg1;
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + this.original + ", substitution=" + this.substitution + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }
    }

    public static final int $stable = 8;
    private MultiParagraphLayoutCache _layoutCache;
    private TextAutoSize autoSize;
    private Map baselineCache;
    private Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1 onPlaceholderLayout;
    private Function1 onShowTranslation;
    private Function1 onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List placeholders;
    private SelectionController selectionController;
    private Function1 semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    private TextSubstitutionValue textSubstitution;

    public static Unit $r8$lambda$F3nlfexdzk9eOn3oAn6KPGQj5ls(Placeable arg0, PlacementScope arg1) {
        return TextAnnotatedStringNode.measure_3p2s80s$lambda$0$0(arg0, arg1);
    }

    static {
    }

    public TextAnnotatedStringNode(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, Function1 arg14, DefaultConstructorMarker arg15) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    private TextAnnotatedStringNode(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, Function1 arg14) {
        super();
        this.text = arg1;
        this.style = arg2;
        this.fontFamilyResolver = arg3;
        this.onTextLayout = arg4;
        this.overflow = arg5;
        this.softWrap = arg6;
        this.maxLines = arg7;
        this.minLines = arg8;
        this.placeholders = arg9;
        this.onPlaceholderLayout = arg10;
        this.selectionController = arg11;
        this.overrideColor = arg12;
        this.autoSize = arg13;
        this.onShowTranslation = arg14;
    }

    public TextAnnotatedStringNode(AnnotatedString arg20, TextStyle arg21, Resolver arg22, Function1 arg23, int arg24, boolean arg25, int arg26, int arg27, List arg28, Function1 arg29, SelectionController arg30, ColorProducer arg31, TextAutoSize arg32, Function1 arg33, int arg34, DefaultConstructorMarker arg35) {
        int v0 = arg34;
        Function1 v2 = null;
        Function1 v7 = (v0 & 8) != 0 ? v2 : arg23;
        int v8 = (v0 & 16) != 0 ? TextOverflow.Companion.getClip-gIe3tQ8() : arg24;
        boolean v9 = (v0 & 0x20) != 0 ? true : arg25;
        int v10 = (v0 & 0x40) != 0 ? 0x7FFFFFFF : arg26;
        int v11 = (v0 & 0x80) != 0 ? 1 : arg27;
        List v12 = (v0 & 0x100) != 0 ? ((List)v2) : arg28;
        Function1 v13 = (v0 & 0x200) != 0 ? v2 : arg29;
        SelectionController v14 = (v0 & 0x400) != 0 ? ((SelectionController)v2) : arg30;
        ColorProducer v15 = (v0 & 0x800) != 0 ? ((ColorProducer)v2) : arg31;
        TextAutoSize v16 = (v0 & 0x1000) != 0 ? ((TextAutoSize)v2) : arg32;
        Function1 v17 = (v0 & 0x2000) != 0 ? v2 : arg33;
        this(arg20, arg21, arg22, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, null);
    }

    public void applySemantics(SemanticsPropertyReceiver arg5) {
        TextAnnotatedStringNode$$ExternalSyntheticLambda1 v0_1;
        Function1 v0 = this.semanticsTextLayoutResult;
        if(v0 == null) {
            v0_1 = new TextAnnotatedStringNode$$ExternalSyntheticLambda1(this);
            this.semanticsTextLayoutResult = ((Function1)v0_1);
        }

        SemanticsPropertiesKt.setText(arg5, this.text);
        TextSubstitutionValue v1 = this.textSubstitution;
        if(v1 != null) {
            SemanticsPropertiesKt.setTextSubstitution(arg5, v1.getSubstitution());
            SemanticsPropertiesKt.setShowingTextSubstitution(arg5, v1.isShowingSubstitution());
        }

        SemanticsPropertiesKt.setTextSubstitution$default(arg5, null, new TextAnnotatedStringNode$$ExternalSyntheticLambda2(this), 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(arg5, null, new TextAnnotatedStringNode$$ExternalSyntheticLambda3(this), 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(arg5, null, new TextAnnotatedStringNode$$ExternalSyntheticLambda4(this), 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(arg5, null, ((Function1)v0_1), 1, null);
    }

    static final boolean applySemantics$lambda$0(TextAnnotatedStringNode arg37, List arg38) {
        TextLayoutResult v0_3;
        TextAnnotatedStringNode v0 = arg37;
        TextLayoutResult v2 = v0.getLayoutCache().getLayoutOrNull();
        if(v2 != null) {
            AnnotatedString v4 = v2.getLayoutInput().getText();
            TextStyle v5 = v0.style;
            ColorProducer v0_1 = v0.overrideColor;
            long v0_2 = v0_1 != null ? v0_1.invoke-0d7_KjU() : Color.Companion.getUnspecified-0d7_KjU();
            v0_3 = TextLayoutResult.copy-O0kMr_c$default(v2, new TextLayoutInput(v4, TextStyle.merge-dA7vx0o$default(v5, v0_2, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, 0, 0, null, null, 0xFFFFFE, null), v2.getLayoutInput().getPlaceholders(), v2.getLayoutInput().getMaxLines(), v2.getLayoutInput().getSoftWrap(), v2.getLayoutInput().getOverflow-gIe3tQ8(), v2.getLayoutInput().getDensity(), v2.getLayoutInput().getLayoutDirection(), v2.getLayoutInput().getFontFamilyResolver(), v2.getLayoutInput().getConstraints-msEJaDk(), null), 0, 2, null);
            if(v0_3 == null) {
                goto label_67;
            }

            arg38.add(v0_3);
        }
        else {
        label_67:
            v0_3 = null;
        }

        if(v0_3 != null) {
            return 1;
        }

        return 0;
    }

    static final boolean applySemantics$lambda$1(TextAnnotatedStringNode arg0, AnnotatedString arg1) {
        arg0.setSubstitution(arg1);
        arg0.invalidateForTranslate();
        return 1;
    }

    static final boolean applySemantics$lambda$2(TextAnnotatedStringNode arg2, boolean arg3) {
        TextSubstitutionValue v0 = arg2.textSubstitution;
        if(v0 == null) {
            return 0;
        }

        Function1 v1 = arg2.onShowTranslation;
        if(v1 != null) {
            Intrinsics.checkNotNull(v0);
            v1.invoke(v0);
        }

        v0 = arg2.textSubstitution;
        if(v0 != null) {
            v0.setShowingSubstitution(arg3);
        }

        arg2.invalidateForTranslate();
        return 1;
    }

    static final boolean applySemantics$lambda$3(TextAnnotatedStringNode arg0) {
        arg0.clearSubstitution$foundation();
        arg0.invalidateForTranslate();
        return 1;
    }

    public final void clearSubstitution$foundation() {
        this.textSubstitution = null;
    }

    public final void doInvalidations(boolean arg11, boolean arg12, boolean arg13, boolean arg14) {
        if((arg12) || (arg13) || (arg14)) {
            this.getLayoutCache().update-J2qo7bo(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.autoSize);
        }

        if(!this.isAttached()) {
        }
        else {
            if((arg12) || (arg11) && this.semanticsTextLayoutResult != null) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }

            if((arg12) || (arg13) || (arg14)) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }

            if(!arg11) {
                return;
            }

            DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
        }
    }

    public void draw(ContentDrawScope arg18) {
        TextAnnotatedStringNode v0 = this;
        if(!v0.isAttached()) {
            return;
        }

        SelectionController v1 = v0.selectionController;
        if(v1 != null) {
            v1.draw(arg18);
        }

        Canvas v3 = arg18.getDrawContext().getCanvas();
        TextLayoutResult v1_1 = v0.getLayoutCache(arg18).getTextLayoutResult();
        MultiParagraph v2 = v1_1.getMultiParagraph();
        boolean v13 = false;
        int v14 = !v1_1.getHasVisualOverflow() || (TextOverflow.equals-impl0(v0.overflow, TextOverflow.Companion.getVisible-gIe3tQ8())) ? 0 : 1;
        if(v14 != 0) {
            Rect v1_2 = RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), Size.constructor-impl((((long)Float.floatToRawIntBits(((float)(((int)(v1_1.getSize-YbymL2g() >> 0x20))))))) << 0x20 | (((long)Float.floatToRawIntBits(((float)(((int)(v1_1.getSize-YbymL2g() & 0xFFFFFFFFL))))))) & 0xFFFFFFFFL));
            v3.save();
            Canvas.clipRect-mtrdD-E$default(v3, v1_2, 0, 2, null);
        }

        try {
            TextDecoration v1_3 = v0.style.getTextDecoration();
            if(v1_3 == null) {
                v1_3 = TextDecoration.Companion.getNone();
            }

            TextDecoration v7 = v1_3;
            Shadow v1_4 = v0.style.getShadow();
            if(v1_4 == null) {
                v1_4 = Shadow.Companion.getNone();
            }

            Shadow v6 = v1_4;
            DrawStyle v1_5 = v0.style.getDrawStyle();
            if(v1_5 == null) {
                Fill v1_6 = Fill.INSTANCE;
            }

            DrawStyle v8 = v1_5;
            Brush v4 = v0.style.getBrush();
            if(v4 != null) {
                MultiParagraph.paint-hn5TExg$default(v2, v3, v4, v0.style.getAlpha(), v6, v7, v8, 0, 0x40, null);
            }
            else {
                ColorProducer v1_7 = v0.overrideColor;
                long v4_1 = v1_7 != null ? v1_7.invoke-0d7_KjU() : Color.Companion.getUnspecified-0d7_KjU();
                long v9 = 16;
                if(v4_1 != v9) {
                }
                else if(v0.style.getColor-0d7_KjU() != v9) {
                    v4_1 = v0.style.getColor-0d7_KjU();
                }
                else {
                    v4_1 = Color.Companion.getBlack-0d7_KjU();
                }

                MultiParagraph.paint-LG529CI$default(v2, v3, v4_1, v6, v7, v8, 0, 0x20, null);
            }
        }
        catch(Throwable v0_1) {
            if(v14 != 0) {
                v3.restore();
            }

            throw v0_1;
        }

        if(v14 != 0) {
            v3.restore();
        }

        TextSubstitutionValue v1_8 = v0.textSubstitution;
        if(v1_8 == null || !v1_8.isShowingSubstitution()) {
            v13 = TextAnnotatedStringNodeKt.hasLinks(v0.text);
        }
        else {
        }

        if(!v13) {
            List v0_2 = v0.placeholders;
            if(v0_2 != null && !((Collection)v0_2).isEmpty()) {
                goto label_117;
            }

            return;
        }

    label_117:
        arg18.drawContent();
    }

    public final void drawNonExtension(ContentDrawScope arg1) {
        this.draw(arg1);
    }

    private static void getBaselineCache$annotations() {
    }

    private final MultiParagraphLayoutCache getLayoutCache() {
        MultiParagraphLayoutCache v0 = this._layoutCache;
        if(v0 == null) {
            MultiParagraphLayoutCache v1 = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, this.autoSize, null);
            this._layoutCache = v1;
            v0 = v1;
        }

        Intrinsics.checkNotNull(v0);
        return v0;
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density arg3) {
        TextSubstitutionValue v0 = this.textSubstitution;
        if(v0 != null && (v0.isShowingSubstitution())) {
            MultiParagraphLayoutCache v0_1 = v0.getLayoutCache();
            if(v0_1 != null) {
                v0_1.setDensity$foundation(arg3);
                return v0_1;
            }
        }

        MultiParagraphLayoutCache v2 = this.getLayoutCache();
        v2.setDensity$foundation(arg3);
        return v2;
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public final TextSubstitutionValue getTextSubstitution$foundation() {
        return this.textSubstitution;
    }

    private final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCache(arg1).intrinsicHeight(arg3, arg1.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.maxIntrinsicHeight(arg1, arg2, arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCache(arg1).maxIntrinsicWidth(arg1.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.maxIntrinsicWidth(arg1, arg2, arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg10, Measurable arg11, long arg12) {
        MeasureResult v9_2;
        LinkedHashMap v12_4;
        Function1 v12_1;
        Trace.beginSection("TextAnnotatedStringNode:measure");
        try {
            MultiParagraphLayoutCache v0 = this.getLayoutCache(arg10);
            boolean v12 = v0.layoutWithConstraints-K40F9xA(arg12, arg10.getLayoutDirection());
            TextLayoutResult v13 = v0.getTextLayoutResult();
            v13.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
            if(v12) {
                LayoutModifierNodeKt.invalidateLayer(this);
                v12_1 = this.onTextLayout;
                if(v12_1 != null) {
                    v12_1.invoke(v13);
                }

                SelectionController v12_2 = this.selectionController;
                if(v12_2 != null) {
                    v12_2.updateTextLayout(v13);
                }

                Map v12_3 = this.baselineCache;
                if(v12_3 == null) {
                    v12_4 = new LinkedHashMap(2);
                }

                HorizontalAlignmentLine v0_1 = AlignmentLineKt.getFirstBaseline();
                ((Map)v12_4).put(v0_1, Integer.valueOf(Math.round(v13.getFirstBaseline())));
                ((Map)v12_4).put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(v13.getLastBaseline())));
                this.baselineCache = ((Map)v12_4);
            }

            v12_1 = this.onPlaceholderLayout;
            if(v12_1 != null) {
                v12_1.invoke(v13.getPlaceholderRects());
            }

            Placeable v11 = arg11.measure-BRTryo0(Constraints.Companion.fitPrioritizingWidth-Zbe2FdA(((int)(v13.getSize-YbymL2g() >> 0x20)), ((int)(v13.getSize-YbymL2g() >> 0x20)), ((int)(v13.getSize-YbymL2g() & 0xFFFFFFFFL)), ((int)(v13.getSize-YbymL2g() & 0xFFFFFFFFL))));
            int v12_5 = ((int)(v13.getSize-YbymL2g() >> 0x20));
            int v13_1 = ((int)(v13.getSize-YbymL2g() & 0xFFFFFFFFL));
            Map v9_1 = this.baselineCache;
            Intrinsics.checkNotNull(v9_1);
            v9_2 = arg10.layout(v12_5, v13_1, v9_1, new TextAnnotatedStringNode$$ExternalSyntheticLambda0(v11));
        }
        catch(Throwable v9) {
            Trace.endSection();
            throw v9;
        }

        Trace.endSection();
        return v9_2;
    }

    public final MeasureResult measureNonExtension-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3) {
        return this.measure-3p2s80s(arg1, arg2, arg3);
    }

    private static final Unit measure_3p2s80s$lambda$0$0(Placeable arg7, PlacementScope arg8) {
        PlacementScope.place$default(arg8, arg7, 0, 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCache(arg1).intrinsicHeight(arg3, arg1.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.minIntrinsicHeight(arg1, arg2, arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.getLayoutCache(arg1).minIntrinsicWidth(arg1.getLayoutDirection());
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.minIntrinsicWidth(arg1, arg2, arg3);
    }

    private final boolean setSubstitution(AnnotatedString arg14) {
        TextSubstitutionValue v2 = this.textSubstitution;
        if(v2 == null) {
            TextSubstitutionValue v12 = new TextSubstitutionValue(this.text, arg14, false, null, 12, null);
            MultiParagraphLayoutCache v1 = new MultiParagraphLayoutCache(arg14, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, CollectionsKt.emptyList(), this.autoSize, null);
            v1.setDensity$foundation(this.getLayoutCache().getDensity$foundation());
            v12.setLayoutCache(v1);
            this.textSubstitution = v12;
        }
        else if(Intrinsics.areEqual(arg14, v2.getSubstitution())) {
            return 0;
        }
        else {
            v2.setSubstitution(arg14);
            MultiParagraphLayoutCache v2_1 = v2.getLayoutCache();
            if(v2_1 != null) {
                v2_1.update-J2qo7bo(arg14, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, CollectionsKt.emptyList(), this.autoSize);
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final void setTextSubstitution$foundation(TextSubstitutionValue arg1) {
        this.textSubstitution = arg1;
    }

    public final boolean updateCallbacks(Function1 arg3, Function1 arg4, SelectionController arg5, Function1 arg6) {
        boolean v3;
        if(this.onTextLayout != arg3) {
            this.onTextLayout = arg3;
            v3 = true;
        }
        else {
            v3 = false;
        }

        if(this.onPlaceholderLayout != arg4) {
            this.onPlaceholderLayout = arg4;
            v3 = true;
        }

        if(!Intrinsics.areEqual(this.selectionController, arg5)) {
            this.selectionController = arg5;
            v3 = true;
        }

        if(this.onShowTranslation != arg6) {
            this.onShowTranslation = arg6;
            return 1;
        }

        return v3;
    }

    public final boolean updateDraw(ColorProducer arg2, TextStyle arg3) {
        boolean v0 = Intrinsics.areEqual(arg2, this.overrideColor);
        this.overrideColor = arg2;
        if(v0) {
            if(!arg3.hasSameDrawAffectingAttributes(this.style)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean updateLayoutRelatedArgs-y0k-MQk(TextStyle arg3, List arg4, int arg5, int arg6, boolean arg7, Resolver arg8, int arg9, TextAutoSize arg10) {
        boolean v0_1;
        int v0 = this.style.hasSameLayoutAffectingAttributes(arg3) ^ 1;
        this.style = arg3;
        if(!Intrinsics.areEqual(this.placeholders, arg4)) {
            this.placeholders = arg4;
            v0_1 = true;
        }

        if(this.minLines != arg5) {
            this.minLines = arg5;
            v0_1 = true;
        }

        if(this.maxLines != arg6) {
            this.maxLines = arg6;
            v0_1 = true;
        }

        if(this.softWrap != arg7) {
            this.softWrap = arg7;
            v0_1 = true;
        }

        if(!Intrinsics.areEqual(this.fontFamilyResolver, arg8)) {
            this.fontFamilyResolver = arg8;
            v0_1 = true;
        }

        if(!TextOverflow.equals-impl0(this.overflow, arg9)) {
            this.overflow = arg9;
            v0_1 = true;
        }

        if(!Intrinsics.areEqual(this.autoSize, arg10)) {
            this.autoSize = arg10;
            return 1;
        }

        return v0_1;
    }

    public final boolean updateText$foundation(AnnotatedString arg3) {
        boolean v0 = Intrinsics.areEqual(this.text.getText(), arg3.getText());
        boolean v1 = this.text.hasEqualAnnotations(arg3);
        v1 = !v0 || !v1 ? true : false;
        if(v1) {
            this.text = arg3;
        }

        if(!v0) {
            this.clearSubstitution$foundation();
        }

        return v1;
    }
}

