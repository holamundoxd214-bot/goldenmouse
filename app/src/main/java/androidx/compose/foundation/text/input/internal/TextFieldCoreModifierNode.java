package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.selection.AndroidTextFieldMagnifier_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job$DefaultImpls;
import kotlinx.coroutines.Job;

@Metadata(d1={"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006Ba\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\b\u0012\u0006\u0010\u0013\u001A\u00020\u0014\u0012\u0006\u0010\u0015\u001A\u00020\u0016\u0012\u0006\u0010\u0017\u001A\u00020\u0018\u0012\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A¢\u0006\u0004\b\u001B\u0010\u001CJ\b\u0010/\u001A\u000200H\u0016J`\u00101\u001A\u0002002\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AJ#\u00102\u001A\u000203*\u0002042\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u000208H\u0016¢\u0006\u0004\b9\u0010:J\f\u0010;\u001A\u000200*\u00020<H\u0016J#\u0010=\u001A\u000203*\u0002042\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u000208H\u0002¢\u0006\u0004\b>\u0010:J#\u0010?\u001A\u000203*\u0002042\u0006\u00105\u001A\u0002062\u0006\u00107\u001A\u000208H\u0002¢\u0006\u0004\b@\u0010:J\'\u0010A\u001A\u00020)2\u0006\u0010B\u001A\u00020%2\u0006\u0010C\u001A\u00020)2\u0006\u0010D\u001A\u00020)H\u0002¢\u0006\u0004\bE\u0010FJ3\u0010G\u001A\u000200*\u00020H2\u0006\u0010I\u001A\u00020)2\u0006\u0010J\u001A\u00020)2\u0006\u0010B\u001A\u00020%2\u0006\u0010K\u001A\u00020LH\u0002¢\u0006\u0004\bM\u0010NJ#\u0010O\u001A\u000200*\u00020P2\u0006\u0010Q\u001A\u00020%2\u0006\u0010R\u001A\u00020SH\u0002¢\u0006\u0004\bT\u0010UJ(\u0010V\u001A\u000200*\u00020P2\u0012\u0010W\u001A\u000E\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020%0X2\u0006\u0010R\u001A\u00020SH\u0002J\u0014\u0010Z\u001A\u000200*\u00020P2\u0006\u0010R\u001A\u00020SH\u0002J\f\u0010[\u001A\u000200*\u00020PH\u0002J\b\u0010\\\u001A\u000200H\u0002J\u0010\u0010]\u001A\u0002002\u0006\u0010^\u001A\u00020_H\u0016J\f\u0010`\u001A\u000200*\u00020aH\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u001AX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u001F\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u0010\u0010\"\u001A\u0004\u0018\u00010#X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010$\u001A\u0004\u0018\u00010%X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\'X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020)X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2={"Landroidx/compose/foundation/text/input/internal/TextFieldCoreModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "isFocused", "", "isDragHovered", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "writeable", "scrollState", "Landroidx/compose/foundation/ScrollState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "<init>", "(ZZLandroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/graphics/Brush;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "cursorAnimation", "Landroidx/compose/foundation/text/input/internal/CursorAnimationState;", "showCursor", "getShowCursor", "()Z", "changeObserverJob", "Lkotlinx/coroutines/Job;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousTextLayoutSize", "", "previousContainerSize", "textFieldMagnifierNode", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "textContextMenuToolbarHandlerNode", "Landroidx/compose/foundation/text/contextmenu/modifier/TextContextMenuToolbarHandlerNode;", "onAttach", "", "updateNode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "measureVerticalScroll", "measureVerticalScroll-3p2s80s", "measureHorizontalScroll", "measureHorizontalScroll-3p2s80s", "calculateOffsetToFollow", "currSelection", "currContainerSize", "currTextLayoutSize", "calculateOffsetToFollow-8ffj60Q", "(JII)I", "updateScrollState", "Landroidx/compose/ui/unit/Density;", "containerSize", "textLayoutSize", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "updateScrollState-tIlFzwE", "(Landroidx/compose/ui/unit/Density;IIJLandroidx/compose/ui/unit/LayoutDirection;)V", "drawSelection", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "selection", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawSelection-Sb-Bc2M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/text/TextLayoutResult;)V", "drawHighlight", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "drawText", "drawCursor", "startCursorJob", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldCoreModifierNode extends DelegatingNode implements CompositionLocalConsumerModifierNode, DrawModifierNode, GlobalPositionAwareModifierNode, LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Job changeObserverJob;
    private CursorAnimationState cursorAnimation;
    private Brush cursorBrush;
    private boolean isDragHovered;
    private boolean isFocused;
    private Orientation orientation;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousContainerSize;
    private Rect previousCursorRect;
    private TextRange previousSelection;
    private int previousTextLayoutSize;
    private ScrollState scrollState;
    private final TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode;
    private final TextFieldMagnifierNode textFieldMagnifierNode;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private ToolbarRequester toolbarRequester;
    private boolean writeable;

    static {
    }

    public TextFieldCoreModifierNode(boolean arg1, boolean arg2, TextLayoutState arg3, TransformedTextFieldState arg4, TextFieldSelectionState arg5, Brush arg6, boolean arg7, ScrollState arg8, Orientation arg9, ToolbarRequester arg10, PlatformSelectionBehaviors arg11) {
        super();
        this.isFocused = arg1;
        this.isDragHovered = arg2;
        this.textLayoutState = arg3;
        this.textFieldState = arg4;
        this.textFieldSelectionState = arg5;
        this.cursorBrush = arg6;
        this.writeable = arg7;
        this.scrollState = arg8;
        this.orientation = arg9;
        this.toolbarRequester = arg10;
        this.platformSelectionBehaviors = arg11;
        this.previousCursorRect = new Rect(-1f, -1f, -1f, -1f);
        TransformedTextFieldState v1 = this.textFieldState;
        TextFieldSelectionState v2 = this.textFieldSelectionState;
        arg3 = this.textLayoutState;
        boolean v4 = (this.isFocused) || (this.isDragHovered) ? true : false;
        this.textFieldMagnifierNode = this.delegate(AndroidTextFieldMagnifier_androidKt.textFieldMagnifierNode(v1, v2, arg3, v4));
        this.textContextMenuToolbarHandlerNode = this.delegate(new TextContextMenuToolbarHandlerNode(this.toolbarRequester, new TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$1(this, null), new TextFieldCoreModifierNode$textContextMenuToolbarHandlerNode$2(this, null), new TextFieldCoreModifierNode$$ExternalSyntheticLambda1(this)));
    }

    public static final CursorAnimationState access$getCursorAnimation$p(TextFieldCoreModifierNode arg0) {
        return arg0.cursorAnimation;
    }

    public static final PlatformSelectionBehaviors access$getPlatformSelectionBehaviors$p(TextFieldCoreModifierNode arg0) {
        return arg0.platformSelectionBehaviors;
    }

    public static final ScrollState access$getScrollState$p(TextFieldCoreModifierNode arg0) {
        return arg0.scrollState;
    }

    public static final TextFieldSelectionState access$getTextFieldSelectionState$p(TextFieldCoreModifierNode arg0) {
        return arg0.textFieldSelectionState;
    }

    public static final TransformedTextFieldState access$getTextFieldState$p(TextFieldCoreModifierNode arg0) {
        return arg0.textFieldState;
    }

    public static final TextLayoutState access$getTextLayoutState$p(TextFieldCoreModifierNode arg0) {
        return arg0.textLayoutState;
    }

    public void applySemantics(SemanticsPropertyReceiver arg1) {
        this.textFieldMagnifierNode.applySemantics(arg1);
    }

    private final int calculateOffsetToFollow-8ffj60Q(long arg5, int arg7, int arg8) {
        TextRange v0 = this.previousSelection;
        if(v0 != null && TextRange.getEnd-impl(arg5) == TextRange.getEnd-impl(v0.unbox-impl())) {
            v0 = this.previousSelection;
            if(v0 != null && TextRange.getStart-impl(arg5) == TextRange.getStart-impl(v0.unbox-impl())) {
                if(arg8 == this.previousTextLayoutSize) {
                    if(arg7 != this.previousContainerSize) {
                    }
                    else {
                        return -1;
                    }
                }

                return TextRange.getStart-impl(arg5);
            }

            return TextRange.getStart-impl(arg5);
        }

        return TextRange.getEnd-impl(arg5);
    }

    public void draw(ContentDrawScope arg6) {
        arg6.drawContent();
        TextFieldCharSequence v0 = this.textFieldState.getVisualText();
        TextLayoutResult v1 = this.textLayoutState.getLayoutResult();
        if(v1 == null) {
            return;
        }

        Pair v2 = v0.getHighlight();
        if(v2 != null) {
            this.drawHighlight(arg6, v2, v1);
        }

        if(TextRange.getCollapsed-impl(v0.getSelection-d9O1mEE())) {
            ContentDrawScope v2_1 = arg6;
            this.drawText(((DrawScope)v2_1), v1);
            if(v0.shouldShowSelection()) {
                this.drawCursor(((DrawScope)v2_1));
            }
        }
        else {
            if(v0.shouldShowSelection()) {
                this.drawSelection-Sb-Bc2M(arg6, v0.getSelection-d9O1mEE(), v1);
            }

            this.drawText(arg6, v1);
        }

        this.textFieldMagnifierNode.draw(arg6);
    }

    private final void drawCursor(DrawScope arg18) {
        TextFieldCoreModifierNode v0 = this;
        CursorAnimationState v1 = v0.cursorAnimation;
        float v12 = v1 != null ? v1.getCursorAlpha() : 0f;
        if(v12 == 0f) {
            return;
        }

        if(!v0.getShowCursor()) {
            return;
        }

        Rect v1_1 = v0.textFieldSelectionState.getCursorRect();
        DrawScope.drawLine-1RTmtNc$default(arg18, v0.cursorBrush, v1_1.getTopCenter-F1C5BW0(), v1_1.getBottomCenter-F1C5BW0(), v1_1.getRight() - v1_1.getLeft(), 0, null, v12, null, 0, 0x1B0, null);
    }

    private final void drawHighlight(DrawScope arg13, Pair arg14, TextLayoutResult arg15) {
        int v0 = arg14.component1().unbox-impl();
        long v1 = arg14.component2().unbox-impl();
        if(TextRange.getCollapsed-impl(v1)) {
            return;
        }

        Path v3 = arg15.getPathForRange(TextRange.getMin-impl(v1), TextRange.getMax-impl(v1));
        if(TextHighlightType.equals-impl0(v0, TextHighlightType.Companion.getHandwritingDeletePreview-s-xJuwY())) {
            Brush v4 = arg15.getLayoutInput().getStyle().getBrush();
            if(v4 != null) {
                DrawScope.drawPath-GBMwjPU$default(arg13, v3, v4, 0.2f, null, null, 0, 56, null);
                return;
            }

            DrawScope v2 = arg13;
            long v12 = arg15.getLayoutInput().getStyle().getColor-0d7_KjU();
            if(v12 != 16) {
            }
            else {
                v12 = Color.Companion.getBlack-0d7_KjU();
            }

            DrawScope.drawPath-LG529CI$default(v2, v3, Color.copy-wmQWz5c$default(v12, Color.getAlpha-impl(v12) * 0.2f, 0f, 0f, 0f, 14, null), 0f, null, null, 0, 60, null);
            return;
        }

        DrawScope.drawPath-LG529CI$default(arg13, v3, CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU(), 0f, null, null, 0, 60, null);
    }

    private final void drawSelection-Sb-Bc2M(DrawScope arg12, long arg13, TextLayoutResult arg15) {
        int v0 = TextRange.getMin-impl(arg13);
        int v13 = TextRange.getMax-impl(arg13);
        if(v0 != v13) {
            DrawScope.drawPath-LG529CI$default(arg12, arg15.getPathForRange(v0, v13), CompositionLocalConsumerModifierNodeKt.currentValueOf(((CompositionLocalConsumerModifierNode)this), TextSelectionColorsKt.getLocalTextSelectionColors()).getBackgroundColor-0d7_KjU(), 0f, null, null, 0, 60, null);
        }
    }

    private final void drawText(DrawScope arg1, TextLayoutResult arg2) {
        TextPainter.INSTANCE.paint(arg1.getDrawContext().getCanvas(), arg2);
    }

    private final boolean getShowCursor() {
        if((this.writeable) && ((this.isFocused) || (this.isDragHovered)) && (TextFieldCoreModifierKt.isSpecified(this.cursorBrush))) {
            return 1;
        }

        return 0;
    }

    public MeasureResult measure-3p2s80s(MeasureScope arg3, Measurable arg4, long arg5) {
        if(this.orientation == Orientation.Vertical) {
            return this.measureVerticalScroll-3p2s80s(arg3, arg4, arg5);
        }

        return this.measureHorizontalScroll-3p2s80s(arg3, arg4, arg5);
    }

    private final MeasureResult measureHorizontalScroll-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        Placeable v10 = arg10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg11, 0, 0x7FFFFFFF, 0, 0, 13, null));
        int v1 = Math.min(v10.getWidth(), Constraints.getMaxWidth-impl(arg11));
        return MeasureScope.layout$default(arg9, v1, v10.getHeight(), null, new TextFieldCoreModifierNode$$ExternalSyntheticLambda0(this, v1, v10, arg9), 4, null);
    }

    static final Unit measureHorizontalScroll_3p2s80s$lambda$0(TextFieldCoreModifierNode arg7, int arg8, Placeable arg9, MeasureScope arg10, PlacementScope arg11) {
        arg7.updateScrollState-tIlFzwE(arg11, arg8, arg9.getWidth(), arg7.textFieldState.getVisualText().getSelection-d9O1mEE(), arg10.getLayoutDirection());
        PlacementScope.placeRelative$default(arg11, arg9, -arg7.scrollState.getValue(), 0, 0f, 4, null);
        return Unit.INSTANCE;
    }

    private final MeasureResult measureVerticalScroll-3p2s80s(MeasureScope arg9, Measurable arg10, long arg11) {
        Placeable v10 = arg10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(arg11, 0, 0, 0, 0x7FFFFFFF, 7, null));
        int v2 = Math.min(v10.getHeight(), Constraints.getMaxHeight-impl(arg11));
        return MeasureScope.layout$default(arg9, v10.getWidth(), v2, null, new TextFieldCoreModifierNode$$ExternalSyntheticLambda2(this, v2, v10, arg9), 4, null);
    }

    static final Unit measureVerticalScroll_3p2s80s$lambda$0(TextFieldCoreModifierNode arg7, int arg8, Placeable arg9, MeasureScope arg10, PlacementScope arg11) {
        arg7.updateScrollState-tIlFzwE(arg11, arg8, arg9.getHeight(), arg7.textFieldState.getVisualText().getSelection-d9O1mEE(), arg10.getLayoutDirection());
        PlacementScope.placeRelative$default(arg11, arg9, 0, -arg7.scrollState.getValue(), 0f, 4, null);
        return Unit.INSTANCE;
    }

    public void onAttach() {
        if((this.isFocused) && (this.getShowCursor())) {
            this.startCursorJob();
        }
    }

    public void onGloballyPositioned(LayoutCoordinates arg2) {
        this.textLayoutState.setCoreNodeCoordinates(arg2);
        this.textFieldMagnifierNode.onGloballyPositioned(arg2);
    }

    private final void startCursorJob() {
        if(this.cursorAnimation == null) {
            this.cursorAnimation = new CursorAnimationState(CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalCursorBlinkEnabled()).booleanValue());
            DrawModifierNodeKt.invalidateDraw(this);
        }

        this.changeObserverJob = BuildersKt.launch$default(this.getCoroutineScope(), null, null, new TextFieldCoreModifierNode$startCursorJob$1(this, null), 3, null);
    }

    static final Rect textContextMenuToolbarHandlerNode$lambda$0(TextFieldCoreModifierNode arg1, LayoutCoordinates arg2) {
        Rect v0 = arg1.textFieldSelectionState.getDerivedVisibleContentBounds$foundation();
        if(v0 == null) {
            v0 = Rect.Companion.getZero();
        }

        LayoutCoordinates v1 = arg1.textLayoutState.getTextLayoutNodeCoordinates();
        if(v1 != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(v0, v1, arg2);
        }

        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public final void updateNode(boolean arg17, boolean arg18, TextLayoutState arg19, TransformedTextFieldState arg20, TextFieldSelectionState arg21, Brush arg22, boolean arg23, ScrollState arg24, Orientation arg25, ToolbarRequester arg26, PlatformSelectionBehaviors arg27) {
        TextFieldCoreModifierNode v0 = this;
        boolean v2 = arg18;
        TextLayoutState v3 = arg19;
        TransformedTextFieldState v4 = arg20;
        TextFieldSelectionState v5 = arg21;
        ScrollState v6 = arg24;
        ToolbarRequester v7 = arg26;
        boolean v8 = v0.getShowCursor();
        boolean v9 = v0.isFocused;
        TransformedTextFieldState v10 = v0.textFieldState;
        TextLayoutState v11 = v0.textLayoutState;
        TextFieldSelectionState v12 = v0.textFieldSelectionState;
        ScrollState v13 = v0.scrollState;
        v0.isFocused = arg17;
        v0.isDragHovered = v2;
        v0.textLayoutState = v3;
        v0.textFieldState = v4;
        v0.textFieldSelectionState = v5;
        v0.cursorBrush = arg22;
        v0.writeable = arg23;
        v0.scrollState = v6;
        v0.orientation = arg25;
        v0.toolbarRequester = v7;
        v0.platformSelectionBehaviors = arg27;
        TextFieldMagnifierNode v14 = v0.textFieldMagnifierNode;
        boolean v1 = (arg17) || (v2) ? true : false;
        v14.update(v4, v5, v3, v1);
        v0.textContextMenuToolbarHandlerNode.update(v7);
        if(!v0.getShowCursor()) {
            Job v1_1 = v0.changeObserverJob;
            CancellationException v2_1 = null;
            if(v1_1 != null) {
                DefaultImpls.cancel$default(v1_1, v2_1, 1, v2_1);
            }

            v0.changeObserverJob = ((Job)v2_1);
            CursorAnimationState v1_2 = v0.cursorAnimation;
            if(v1_2 == null) {
                goto label_56;
            }

            v1_2.cancelAndHide();
        }
        else {
            if((v9) && (Intrinsics.areEqual(v10, v4)) && (v8)) {
                goto label_56;
            }

            v0.startCursorJob();
        }

    label_56:
        if((Intrinsics.areEqual(v10, v4)) && (Intrinsics.areEqual(v11, v3)) && (Intrinsics.areEqual(v12, v5))) {
            if(!Intrinsics.areEqual(v13, v6)) {
            }
            else {
                return;
            }
        }

        LayoutModifierNodeKt.invalidateMeasurement(((LayoutModifierNode)v0));
    }

    private final void updateScrollState-tIlFzwE(Density arg10, int arg11, int arg12, long arg13, LayoutDirection arg15) {
        float v3_1;
        boolean v12;
        int v15_1;
        this.scrollState.setViewportSize$foundation(arg11);
        this.scrollState.setMaxValue$foundation(arg12 - arg11);
        int v0 = this.calculateOffsetToFollow-8ffj60Q(arg13, arg11, arg12);
        if(v0 >= 0) {
            if(!this.getShowCursor()) {
            }
            else {
                TextLayoutResult v1 = this.textLayoutState.getLayoutResult();
                if(v1 == null) {
                }
                else {
                    int v4 = 0;
                    Rect v0_1 = v1.getCursorRect(RangesKt.coerceIn(v0, new IntRange(0, v1.getLayoutInput().getText().length())));
                    boolean v15 = arg15 == LayoutDirection.Rtl ? true : false;
                    Rect v10 = TextFieldCoreModifierKt.getCursorRectInScroller(arg10, v0_1, v15, arg12);
                    if(v10.getLeft() != this.previousCursorRect.getLeft() || v10.getTop() != this.previousCursorRect.getTop() || arg12 != this.previousTextLayoutSize) {
                        v15_1 = arg12;
                        v12 = true;
                    }
                    else {
                        v15_1 = arg12;
                        v12 = false;
                    }

                    if(!v12 && arg11 == this.previousContainerSize) {
                        return;
                    }

                    if(this.orientation == Orientation.Vertical) {
                        v4 = 1;
                    }

                    float v1_1 = v4 != 0 ? v10.getTop() : v10.getLeft();
                    float v2 = v4 != 0 ? v10.getBottom() : v10.getRight();
                    int v3 = this.scrollState.getValue();
                    float v4_1 = ((float)(v3 + arg11));
                    if(v2 <= v4_1) {
                        v3_1 = ((float)v3);
                        int v5 = Float.compare(v1_1, v3_1);
                        if(v5 < 0 && v2 - v1_1 > (((float)arg11))) {
                            goto label_65;
                        }

                        goto label_74;
                    }
                    else {
                    label_65:
                        v2 -= v4_1;
                        goto label_81;
                    label_74:
                        if(v5 < 0 && v2 - v1_1 <= (((float)arg11))) {
                            v2 = v1_1 - v3_1;
                            goto label_81;
                        }

                        v2 = 0f;
                    }

                label_81:
                    this.previousSelection = TextRange.box-impl(arg13);
                    this.previousCursorRect = v10;
                    this.previousContainerSize = arg11;
                    this.previousTextLayoutSize = v15_1;
                    BuildersKt.launch$default(this.getCoroutineScope(), null, CoroutineStart.UNDISPATCHED, new TextFieldCoreModifierNode$updateScrollState$1(this, v2, v12, v0_1, null), 1, null);
                }
            }
        }
    }
}

