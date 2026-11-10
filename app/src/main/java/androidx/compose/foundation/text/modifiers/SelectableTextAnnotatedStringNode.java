package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.style.TextOverflow;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BÓ\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0016\b\u0002\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001A\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001A\u00020\u0014\u0012\u0016\b\u0002\u0010\u0016\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u0017\u0012\u001E\b\u0002\u0010\u001A\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u0017\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u001D\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u001F\u0012\n\b\u0002\u0010 \u001A\u0004\u0018\u00010!\u0012\u0016\b\u0002\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f¢\u0006\u0004\b$\u0010%J\u0010\u0010+\u001A\u00020\u000E2\u0006\u0010,\u001A\u00020-H\u0016J\f\u0010.\u001A\u00020\u000E*\u00020/H\u0016J#\u00100\u001A\u000201*\u0002022\u0006\u00103\u001A\u0002042\u0006\u00105\u001A\u000206H\u0016¢\u0006\u0004\b7\u00108J\u001C\u00109\u001A\u00020\u0014*\u00020:2\u0006\u00103\u001A\u00020;2\u0006\u0010<\u001A\u00020\u0014H\u0016J\u001C\u0010=\u001A\u00020\u0014*\u00020:2\u0006\u00103\u001A\u00020;2\u0006\u0010>\u001A\u00020\u0014H\u0016J\u001C\u0010?\u001A\u00020\u0014*\u00020:2\u0006\u00103\u001A\u00020;2\u0006\u0010<\u001A\u00020\u0014H\u0016J\u001C\u0010@\u001A\u00020\u0014*\u00020:2\u0006\u00103\u001A\u00020;2\u0006\u0010>\u001A\u00020\u0014H\u0016J­\u0001\u0010A\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0014\u0010\u0016\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018\u0018\u00010\u00172\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u00102\u0014\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f2\u001C\u0010\u001A\u001A\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001B0\u0017\u0012\u0004\u0012\u00020\u000E\u0018\u00010\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001D2\b\u0010B\u001A\u0004\u0018\u00010\u001F2\b\u0010 \u001A\u0004\u0018\u00010!¢\u0006\u0004\bC\u0010DR\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u001DX\u0082\u000E¢\u0006\u0002\n\u0000R\u001C\u0010\"\u001A\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000E\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010&\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\'\u0010(R\u000E\u0010)\u001A\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2={"Landroidx/compose/foundation/text/modifiers/SelectableTextAnnotatedStringNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "onPlaceholderLayout", "Landroidx/compose/ui/geometry/Rect;", "selectionController", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "overrideColor", "Landroidx/compose/ui/graphics/ColorProducer;", "autoSize", "Landroidx/compose/foundation/text/TextAutoSize;", "onShowTranslation", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "textAnnotatedStringNode", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "update", "color", "update-7NebLg4", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/foundation/text/TextAutoSize;)V", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectableTextAnnotatedStringNode extends DelegatingNode implements DrawModifierNode, GlobalPositionAwareModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Function1 onShowTranslation;
    private SelectionController selectionController;
    private final TextAnnotatedStringNode textAnnotatedStringNode;

    static {
    }

    public SelectableTextAnnotatedStringNode(AnnotatedString arg20, TextStyle arg21, Resolver arg22, Function1 arg23, int arg24, boolean arg25, int arg26, int arg27, List arg28, Function1 arg29, SelectionController arg30, ColorProducer arg31, TextAutoSize arg32, Function1 arg33, int arg34, DefaultConstructorMarker arg35) {
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

    private SelectableTextAnnotatedStringNode(AnnotatedString arg18, TextStyle arg19, Resolver arg20, Function1 arg21, int arg22, boolean arg23, int arg24, int arg25, List arg26, Function1 arg27, SelectionController arg28, ColorProducer arg29, TextAutoSize arg30, Function1 arg31) {
        super();
        this.selectionController = arg28;
        this.onShowTranslation = arg31;
        this.textAnnotatedStringNode = this.delegate(new TextAnnotatedStringNode(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, this.selectionController, arg29, arg30, this.onShowTranslation, null));
        if(this.selectionController != null) {
            return;
        }

        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Do not use SelectionCapableStaticTextModifier unless selectionController != null");
        throw new KotlinNothingValueException();
    }

    public SelectableTextAnnotatedStringNode(AnnotatedString arg1, TextStyle arg2, Resolver arg3, Function1 arg4, int arg5, boolean arg6, int arg7, int arg8, List arg9, Function1 arg10, SelectionController arg11, ColorProducer arg12, TextAutoSize arg13, Function1 arg14, DefaultConstructorMarker arg15) {
        this(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }

    public void draw(ContentDrawScope arg1) {
        this.textAnnotatedStringNode.drawNonExtension(arg1);
    }

    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.textAnnotatedStringNode.maxIntrinsicHeightNonExtension(arg1, arg2, arg3);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.textAnnotatedStringNode.maxIntrinsicWidthNonExtension(arg1, arg2, arg3);
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg1, Measurable arg2, long arg3) {
        return this.textAnnotatedStringNode.measureNonExtension-3p2s80s(arg1, arg2, arg3);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.textAnnotatedStringNode.minIntrinsicHeightNonExtension(arg1, arg2, arg3);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope arg1, IntrinsicMeasurable arg2, int arg3) {
        return this.textAnnotatedStringNode.minIntrinsicWidthNonExtension(arg1, arg2, arg3);
    }

    public void onGloballyPositioned(LayoutCoordinates arg1) {
        SelectionController v0 = this.selectionController;
        if(v0 != null) {
            v0.updateGlobalPosition(arg1);
        }
    }

    public final void update-7NebLg4(AnnotatedString arg13, TextStyle arg14, List arg15, int arg16, int arg17, boolean arg18, Resolver arg19, int arg20, Function1 arg21, Function1 arg22, SelectionController arg23, ColorProducer arg24, TextAutoSize arg25) {
        this.textAnnotatedStringNode.doInvalidations(this.textAnnotatedStringNode.updateDraw(arg24, arg14), this.textAnnotatedStringNode.updateText$foundation(arg13), this.textAnnotatedStringNode.updateLayoutRelatedArgs-y0k-MQk(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg25), this.textAnnotatedStringNode.updateCallbacks(arg21, arg22, arg23, this.onShowTranslation));
        this.selectionController = arg23;
        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)this));
    }
}

