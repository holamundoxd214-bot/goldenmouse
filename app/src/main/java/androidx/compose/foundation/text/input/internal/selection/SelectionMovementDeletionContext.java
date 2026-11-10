package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b#\b\u0001\u0018\u0000 Y2\u00020\u0001:\u0001YB1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ,\u0010%\u001A\u00020\u00002\b\b\u0002\u0010&\u001A\u00020\u00072\u0017\u0010\'\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*H\u0082\bJ\u0006\u0010+\u001A\u00020\u0000J\u0006\u0010,\u001A\u00020\u0000J\u0006\u0010-\u001A\u00020\u0000J\u0006\u0010.\u001A\u00020\u0000J\u001F\u0010/\u001A\u00020\u00002\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u001F\u00101\u001A\u00020\u00002\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)0(¢\u0006\u0002\b*J\u0006\u00102\u001A\u000203J\u0006\u00104\u001A\u000203J!\u00105\u001A\u00020\u00002\b\b\u0002\u0010&\u001A\u00020\u00072\f\u00106\u001A\b\u0012\u0004\u0012\u00020307H\u0082\bJ\u0006\u00108\u001A\u00020\u0000J\u0006\u00109\u001A\u00020\u0000J\u0006\u0010:\u001A\u00020\u0000J\u0006\u0010;\u001A\u00020\u0000J\u0006\u0010<\u001A\u00020\u0000J\u0006\u0010=\u001A\u00020\u0000J\u0006\u0010>\u001A\u00020\u0000J\u0006\u0010?\u001A\u00020\u0000J\u0006\u0010@\u001A\u00020\u0000J\u0006\u0010A\u001A\u00020\u0000J\u0006\u0010B\u001A\u00020\u0000J\u0006\u0010C\u001A\u00020\u0000J\u0006\u0010D\u001A\u00020\u0000J\u0006\u0010E\u001A\u00020\u0000J\u0006\u0010F\u001A\u00020\u0000J\u0006\u0010G\u001A\u00020\u0000J\u0006\u0010H\u001A\u00020\u0000J\u0006\u0010I\u001A\u00020\u0000J\u0006\u0010J\u001A\u00020\u0000J\u0006\u0010K\u001A\u00020\u0000J\u0006\u0010L\u001A\u00020\u0000J\b\u0010M\u001A\u00020\u0007H\u0002J\u0017\u0010N\u001A\u000203*\u00020\u00052\b\b\u0002\u0010O\u001A\u000203H\u0082\u0010J\u0017\u0010P\u001A\u000203*\u00020\u00052\b\b\u0002\u0010O\u001A\u000203H\u0082\u0010J\u0016\u0010Q\u001A\u000203*\u00020\u00052\b\b\u0002\u0010O\u001A\u000203H\u0002J\u0016\u0010R\u001A\u000203*\u00020\u00052\b\b\u0002\u0010O\u001A\u000203H\u0002J\u0014\u0010S\u001A\u000203*\u00020\u00052\u0006\u0010T\u001A\u000203H\u0002J\u0010\u0010U\u001A\u0002032\u0006\u0010V\u001A\u000203H\u0002J\u0010\u0010W\u001A\u0002032\u0006\u0010X\u001A\u000203H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000E\u001A\u00020\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u0013¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u001C\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\u001C\u0010\u001D\u001A\u0004\u0018\u00010\u001EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\"R\u000E\u0010#\u001A\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext;", "", "state", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "", "textPreparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "getInitialWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selection", "Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "getWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "setWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/WedgeAffinity;)V", "text", "", "applyIfNotEmpty", "resetCachedX", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "selectAll", "deselect", "moveCursorLeftByChar", "moveCursorRightByChar", "collapseLeftOr", "or", "collapseRightOr", "getPrecedingCharacterIndex", "", "getNextCharacterIndex", "moveCursorTo", "proposedCursorMovement", "Lkotlin/Function0;", "moveCursorPrevByCodePointOrEmoji", "moveCursorPrevByChar", "moveCursorNextByChar", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "moveCursorNextByWord", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorToLineEnd", "moveCursorUpByPage", "moveCursorDownByPage", "selectMovement", "deleteMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffsetForLayout", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "jumpByPagesOffset", "pagesAmount", "charOffset", "offset", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SelectionMovementDeletionContext {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/input/internal/selection/SelectionMovementDeletionContext$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final SelectionWedgeAffinity initialWedgeAffinity;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    private WedgeAffinity wedgeAffinity;

    static {
        SelectionMovementDeletionContext.Companion = new Companion(null);
        SelectionMovementDeletionContext.$stable = 8;
    }

    public SelectionMovementDeletionContext(TransformedTextFieldState arg2, TextLayoutResult arg3, boolean arg4, float arg5, TextFieldPreparedSelectionState arg6) {
        TextFieldCharSequence v0;
        super();
        this.state = arg2;
        this.textLayoutResult = arg3;
        this.isFromSoftKeyboard = arg4;
        this.visibleTextLayoutHeight = arg5;
        this.textPreparedSelectionState = arg6;
        androidx.compose.runtime.snapshots.Snapshot$Companion v3 = Snapshot.Companion;
        Snapshot v4 = v3.getCurrentThreadSnapshot();
        Function1 v5 = v4 != null ? v4.getReadObserver() : null;
        Snapshot v6 = v3.makeCurrentNonObservable(v4);
        try {
            v0 = arg2.getVisualText();
            this.initialValue = v0;
            this.initialWedgeAffinity = arg2.getSelectionWedgeAffinity();
        }
        catch(Throwable v1) {
            v3.restoreNonObservable(v4, v6, v5);
            throw v1;
        }

        v3.restoreNonObservable(v4, v6, v5);
        this.selection = v0.getSelection-d9O1mEE();
        this.text = v0.getText().toString();
    }

    public static final TransformedTextFieldState access$getState$p(SelectionMovementDeletionContext arg0) {
        return arg0.state;
    }

    public static final String access$getText$p(SelectionMovementDeletionContext arg0) {
        return arg0.text;
    }

    public static final TextFieldPreparedSelectionState access$getTextPreparedSelectionState$p(SelectionMovementDeletionContext arg0) {
        return arg0.textPreparedSelectionState;
    }

    private final SelectionMovementDeletionContext applyIfNotEmpty(boolean arg1, Function1 arg2) {
        if(arg1) {
            this.textPreparedSelectionState.resetCachedX();
        }

        if(this.text.length() > 0) {
            arg2.invoke(this);
        }

        return this;
    }

    static SelectionMovementDeletionContext applyIfNotEmpty$default(SelectionMovementDeletionContext arg0, boolean arg1, Function1 arg2, int arg3, Object arg4) {
        if(1 != 0) {
            arg0.textPreparedSelectionState.resetCachedX();
        }

        if(arg0.text.length() > 0) {
            arg2.invoke(arg0);
        }

        return arg0;
    }

    private final int charOffset(int arg1) {
        return RangesKt.coerceAtMost(arg1, this.text.length() - 1);
    }

    public final SelectionMovementDeletionContext collapseLeftOr(Function1 arg3) {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            if(TextRange.getCollapsed-impl(this.selection)) {
                arg3.invoke(this);
                return this;
            }
            else {
                boolean v3 = this.isLtr();
                long v0 = this.selection;
                if(v3) {
                    this.selection = TextRangeKt.TextRange(TextRange.getMin-impl(v0));
                    return this;
                }
                else {
                    this.selection = TextRangeKt.TextRange(TextRange.getMax-impl(v0));
                }
            }
        }

        return this;
    }

    public final SelectionMovementDeletionContext collapseRightOr(Function1 arg3) {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            if(TextRange.getCollapsed-impl(this.selection)) {
                arg3.invoke(this);
                return this;
            }
            else {
                boolean v3 = this.isLtr();
                long v0 = this.selection;
                if(v3) {
                    this.selection = TextRangeKt.TextRange(TextRange.getMax-impl(v0));
                    return this;
                }
                else {
                    this.selection = TextRangeKt.TextRange(TextRange.getMin-impl(v0));
                }
            }
        }

        return this;
    }

    public final SelectionMovementDeletionContext deleteMovement() {
        if(this.text.length() > 0) {
            boolean v0 = TextRange.getCollapsed-impl(this.initialValue.getSelection-d9O1mEE());
            TransformedTextFieldState v1 = this.state;
            if(!v0) {
                v1.deleteSelectedText();
            }
            else {
                TransformedTextFieldState.replaceText-M8tDOmk$default(v1, "", TextRangeKt.TextRange(TextRange.getStart-impl(this.initialValue.getSelection-d9O1mEE()), TextRange.getEnd-impl(this.selection)), null, this.isFromSoftKeyboard ^ 1, 4, null);
            }

            this.selection = this.state.getVisualText().getSelection-d9O1mEE();
            this.wedgeAffinity = WedgeAffinity.Start;
        }

        return this;
    }

    public final SelectionMovementDeletionContext deselect() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.getEnd-impl(this.selection));
        }

        return this;
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final SelectionWedgeAffinity getInitialWedgeAffinity() {
        return this.initialWedgeAffinity;
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult arg1, int arg2) {
        return arg1.getLineEnd(arg1.getLineForOffset(arg2), true);
    }

    static int getLineEndByOffsetForLayout$default(SelectionMovementDeletionContext arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = TextRange.getMax-impl(arg0.selection);
        }

        return arg0.getLineEndByOffsetForLayout(arg1, arg2);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult arg1, int arg2) {
        return arg1.getLineStart(arg1.getLineForOffset(arg2));
    }

    static int getLineStartByOffsetForLayout$default(SelectionMovementDeletionContext arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = TextRange.getMin-impl(arg0.selection);
        }

        return arg0.getLineStartByOffsetForLayout(arg1, arg2);
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult arg4, int arg5) {
        long v0;
        while(true) {
            if(arg5 >= this.initialValue.length()) {
                goto label_3;
            }

            v0 = arg4.getWordBoundary--jx7JFs(this.charOffset(arg5));
            if(TextRange.getEnd-impl(v0) > arg5) {
                break;
            }

            ++arg5;
        }

        return TextRange.getEnd-impl(v0);
    label_3:
        return this.initialValue.length();
    }

    static int getNextWordOffsetForLayout$default(SelectionMovementDeletionContext arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = TextRange.getEnd-impl(arg0.selection);
        }

        return arg0.getNextWordOffsetForLayout(arg1, arg2);
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.getEnd-impl(this.selection));
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult arg4, int arg5) {
        long v0;
        while(true) {
            if(arg5 <= 0) {
                return 0;
            }

            v0 = arg4.getWordBoundary--jx7JFs(this.charOffset(arg5));
            if(TextRange.getStart-impl(v0) < arg5) {
                break;
            }

            --arg5;
        }

        return TextRange.getStart-impl(v0);
    }

    static int getPrevWordOffsetForLayout$default(SelectionMovementDeletionContext arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = TextRange.getEnd-impl(arg0.selection);
        }

        return arg0.getPrevWordOffsetForLayout(arg1, arg2);
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final WedgeAffinity getWedgeAffinity() {
        return this.wedgeAffinity;
    }

    private final boolean isLtr() {
        TextLayoutResult v0 = this.textLayoutResult;
        if(v0 != null) {
            ResolvedTextDirection v4 = v0.getParagraphDirection(TextRange.getEnd-impl(this.selection));
            if(v4 == null) {
            }
            else if(v4 == ResolvedTextDirection.Ltr) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final int jumpByLinesOffset(TextLayoutResult arg7, int arg8) {
        int v0 = TextRange.getEnd-impl(this.selection);
        if(Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(arg7.getCursorRect(v0).getLeft());
        }

        v0 = arg7.getLineForOffset(v0) + arg8;
        if(v0 < 0) {
            return 0x80000000;
        }

        if(v0 >= arg7.getLineCount()) {
            return 0x7FFFFFFF;
        }

        float v8 = arg7.getLineBottom(v0) - 1f;
        float v1 = this.textPreparedSelectionState.getCachedX();
        if((this.isLtr()) && v1 >= arg7.getLineRight(v0) || !this.isLtr() && v1 <= arg7.getLineLeft(v0)) {
            return arg7.getLineEnd(v0, true);
        }

        return arg7.getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(v1))) << 0x20 | (((long)Float.floatToRawIntBits(v8))) & 0xFFFFFFFFL));
    }

    private final int jumpByPagesOffset(int arg4) {
        int v0 = TextRange.getEnd-impl(this.initialValue.getSelection-d9O1mEE());
        if(this.textLayoutResult != null) {
            if(Float.isNaN(this.visibleTextLayoutHeight)) {
            }
            else {
                Rect v4 = this.textLayoutResult.getCursorRect(v0).translate(0f, this.visibleTextLayoutHeight * (((float)arg4)));
                float v0_1 = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(v4.getTop()));
                v0 = Float.compare(Math.abs(v4.getTop() - v0_1), Math.abs(v4.getBottom() - v0_1));
                TextLayoutResult v3 = this.textLayoutResult;
                if(v0 > 0) {
                    return v3.getOffsetForPosition-k-4lQ0M(v4.getTopLeft-F1C5BW0());
                }
                else {
                    return v3.getOffsetForPosition-k-4lQ0M(v4.getBottomLeft-F1C5BW0());
                }
            }
        }

        return v0;
    }

    public final SelectionMovementDeletionContext moveCursorDownByLine() {
        TextLayoutResult v0 = this.textLayoutResult;
        int v1 = 1;
        int v2 = 0x7FFFFFFF;
        int v0_1 = v0 != null ? this.jumpByLinesOffset(v0, 1) : v2;
        if(v0_1 == v2) {
        }
        else {
            v1 = 0;
        }

        if(v1 != 0) {
            this.textPreparedSelectionState.resetCachedX();
        }

        if(this.text.length() > 0) {
            v1 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v2_1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtMost(v0_1, this.text.length()), v1, this.state);
            v0_1 = CursorAndWedgeAffinity.component1-impl(v2_1);
            WedgeAffinity v2_2 = CursorAndWedgeAffinity.component2-impl(v2_1);
            if(v0_1 != v1 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v0_1));
            }

            if(v2_2 == null) {
                return this;
            }

            this.setWedgeAffinity(v2_2);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorDownByPage() {
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.jumpByPagesOffset(1), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorLeftByChar() {
        if(this.isLtr()) {
            return this.moveCursorPrevByChar();
        }

        return this.moveCursorNextByChar();
    }

    public final SelectionMovementDeletionContext moveCursorLeftByWord() {
        if(this.isLtr()) {
            return this.moveCursorPrevByWord();
        }

        return this.moveCursorNextByWord();
    }

    public final SelectionMovementDeletionContext moveCursorNextByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.getEnd-impl(this.selection)), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorNextByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            int v1 = StringHelpersKt.findParagraphEnd(this.text, TextRange.getMax-impl(this.selection));
            if(v1 == TextRange.getMax-impl(this.selection) && v1 != this.text.length()) {
                v1 = StringHelpersKt.findParagraphEnd(this.text, v1 + 1);
            }

            long v1_1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v1, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_1);
            WedgeAffinity v1_2 = CursorAndWedgeAffinity.component2-impl(v1_1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_2 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_2);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorNextByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            TextLayoutResult v1 = this.textLayoutResult;
            int v1_1 = v1 != null ? SelectionMovementDeletionContext.getNextWordOffsetForLayout$default(this, v1, 0, 1, null) : this.text.length();
            long v1_2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v1_1, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_2);
            WedgeAffinity v1_3 = CursorAndWedgeAffinity.component2-impl(v1_2);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_3 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_3);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByChar() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.getEnd-impl(this.selection)), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByCodePointOrEmoji() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.text, TextRange.getEnd-impl(this.selection), -1), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByParagraph() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            int v1 = StringHelpersKt.findParagraphStart(this.text, TextRange.getMin-impl(this.selection));
            if(v1 == TextRange.getMin-impl(this.selection) && v1 != 0) {
                v1 = StringHelpersKt.findParagraphStart(this.text, v1 - 1);
            }

            long v1_1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v1, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_1);
            WedgeAffinity v1_2 = CursorAndWedgeAffinity.component2-impl(v1_1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_2 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_2);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorPrevByWord() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            TextLayoutResult v1 = this.textLayoutResult;
            int v2 = 0;
            if(v1 != null) {
                v2 = SelectionMovementDeletionContext.getPrevWordOffsetForLayout$default(this, v1, 0, 1, null);
            }

            long v1_1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v2, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_1);
            WedgeAffinity v1_2 = CursorAndWedgeAffinity.component2-impl(v1_1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_2 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_2);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorRightByChar() {
        if(this.isLtr()) {
            return this.moveCursorNextByChar();
        }

        return this.moveCursorPrevByChar();
    }

    public final SelectionMovementDeletionContext moveCursorRightByWord() {
        if(this.isLtr()) {
            return this.moveCursorNextByWord();
        }

        return this.moveCursorPrevByWord();
    }

    private final SelectionMovementDeletionContext moveCursorTo(boolean arg4, Function0 arg5) {
        if(arg4) {
            this.textPreparedSelectionState.resetCachedX();
        }

        if(this.text.length() > 0) {
            int v4 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v0 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(arg5.invoke().intValue(), v4, this.state);
            int v5 = CursorAndWedgeAffinity.component1-impl(v0);
            WedgeAffinity v0_1 = CursorAndWedgeAffinity.component2-impl(v0);
            if(v5 != v4 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v5));
            }

            if(v0_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v0_1);
        }

        return this;
    }

    static SelectionMovementDeletionContext moveCursorTo$default(SelectionMovementDeletionContext arg2, boolean arg3, Function0 arg4, int arg5, Object arg6) {
        if(1 != 0) {
            arg2.textPreparedSelectionState.resetCachedX();
        }

        if(arg2.text.length() > 0) {
            int v3 = TextRange.getEnd-impl(arg2.getSelection-d9O1mEE());
            long v4 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(arg4.invoke().intValue(), v3, arg2.state);
            int v6 = CursorAndWedgeAffinity.component1-impl(v4);
            WedgeAffinity v4_1 = CursorAndWedgeAffinity.component2-impl(v4);
            if(v6 != v3 || !TextRange.getCollapsed-impl(arg2.getSelection-d9O1mEE())) {
                arg2.setSelection-5zc-tL8(TextRangeKt.TextRange(v6));
            }

            if(v4_1 == null) {
                return arg2;
            }

            arg2.setWedgeAffinity(v4_1);
        }

        return arg2;
    }

    public final SelectionMovementDeletionContext moveCursorToEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.text.length(), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToHome() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(0, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToLineEnd() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            TextLayoutResult v1 = this.textLayoutResult;
            int v1_1 = v1 != null ? SelectionMovementDeletionContext.getLineEndByOffsetForLayout$default(this, v1, 0, 1, null) : this.text.length();
            long v1_2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v1_1, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_2);
            WedgeAffinity v1_3 = CursorAndWedgeAffinity.component2-impl(v1_2);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_3 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_3);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorToLineLeftSide() {
        if(this.isLtr()) {
            return this.moveCursorToLineStart();
        }

        return this.moveCursorToLineEnd();
    }

    public final SelectionMovementDeletionContext moveCursorToLineRightSide() {
        if(this.isLtr()) {
            return this.moveCursorToLineEnd();
        }

        return this.moveCursorToLineStart();
    }

    public final SelectionMovementDeletionContext moveCursorToLineStart() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            TextLayoutResult v1 = this.textLayoutResult;
            int v2 = 0;
            if(v1 != null) {
                v2 = SelectionMovementDeletionContext.getLineStartByOffsetForLayout$default(this, v1, 0, 1, null);
            }

            long v1_1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(v2, v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1_1);
            WedgeAffinity v1_2 = CursorAndWedgeAffinity.component2-impl(v1_1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_2 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_2);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorUpByLine() {
        TextLayoutResult v0 = this.textLayoutResult;
        int v1 = 0x80000000;
        int v0_1 = v0 != null ? this.jumpByLinesOffset(v0, -1) : v1;
        v1 = v0_1 == v1 ? 1 : 0;
        if(v1 != 0) {
            this.textPreparedSelectionState.resetCachedX();
        }

        if(this.text.length() > 0) {
            v1 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v2 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(RangesKt.coerceAtLeast(v0_1, 0), v1, this.state);
            v0_1 = CursorAndWedgeAffinity.component1-impl(v2);
            WedgeAffinity v2_1 = CursorAndWedgeAffinity.component2-impl(v2);
            if(v0_1 != v1 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v0_1));
            }

            if(v2_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v2_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext moveCursorUpByPage() {
        if(this.text.length() > 0) {
            int v0 = TextRange.getEnd-impl(this.getSelection-d9O1mEE());
            long v1 = TextPreparedSelectionKt.calculateNextCursorPositionAndWedgeAffinity(this.jumpByPagesOffset(-1), v0, this.state);
            int v3 = CursorAndWedgeAffinity.component1-impl(v1);
            WedgeAffinity v1_1 = CursorAndWedgeAffinity.component2-impl(v1);
            if(v3 != v0 || !TextRange.getCollapsed-impl(this.getSelection-d9O1mEE())) {
                this.setSelection-5zc-tL8(TextRangeKt.TextRange(v3));
            }

            if(v1_1 == null) {
                return this;
            }

            this.setWedgeAffinity(v1_1);
        }

        return this;
    }

    public final SelectionMovementDeletionContext selectAll() {
        this.textPreparedSelectionState.resetCachedX();
        if(this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }

        return this;
    }

    public final SelectionMovementDeletionContext selectMovement() {
        if(this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.getStart-impl(this.initialValue.getSelection-d9O1mEE()), TextRange.getEnd-impl(this.selection));
        }

        return this;
    }

    public final void setSelection-5zc-tL8(long arg1) {
        this.selection = arg1;
    }

    public final void setWedgeAffinity(WedgeAffinity arg1) {
        this.wedgeAffinity = arg1;
    }
}

