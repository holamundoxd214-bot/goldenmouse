package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b3\b!\u0018\u0000 c*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001cB1\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ;\u0010&\u001A\u00028\u0000\"\u0004\b\u0001\u0010\'*\u0002H\'2\b\b\u0002\u0010(\u001A\u00020)2\u0017\u0010*\u001A\u0013\u0012\u0004\u0012\u0002H\'\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-H\u0084\b¢\u0006\u0002\u0010.J\u0010\u0010/\u001A\u00020,2\u0006\u00100\u001A\u000201H\u0004J\u0018\u00102\u001A\u00020,2\u0006\u00103\u001A\u0002012\u0006\u00104\u001A\u000201H\u0004J\u000B\u00105\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u00107\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u00108\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u00109\u001A\u00028\u0000¢\u0006\u0002\u00106J$\u0010:\u001A\u00028\u00002\u0017\u0010;\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J$\u0010=\u001A\u00028\u00002\u0017\u0010;\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J\u0006\u0010>\u001A\u000201J\u0006\u0010?\u001A\u000201J\u0006\u0010@\u001A\u000201J\r\u0010A\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010B\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000B\u0010C\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010D\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010E\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010F\u001A\u00028\u0000¢\u0006\u0002\u00106J\r\u0010G\u001A\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010I\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010J\u001A\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010K\u001A\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000B\u0010L\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010M\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010N\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010O\u001A\u00028\u0000¢\u0006\u0002\u00106J\r\u0010P\u001A\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000B\u0010Q\u001A\u00028\u0000¢\u0006\u0002\u00106J\r\u0010R\u001A\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000B\u0010S\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010T\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010U\u001A\u00028\u0000¢\u0006\u0002\u00106J\u000B\u0010V\u001A\u00028\u0000¢\u0006\u0002\u00106J\b\u0010W\u001A\u00020)H\u0002J\u0017\u0010X\u001A\u000201*\u00020\b2\b\b\u0002\u0010Y\u001A\u000201H\u0082\u0010J\u0017\u0010Z\u001A\u000201*\u00020\b2\b\b\u0002\u0010Y\u001A\u000201H\u0082\u0010J\u0016\u0010[\u001A\u000201*\u00020\b2\b\b\u0002\u0010Y\u001A\u000201H\u0002J\u0016\u0010\\\u001A\u000201*\u00020\b2\b\b\u0002\u0010Y\u001A\u000201H\u0002J\u0014\u0010]\u001A\u000201*\u00020\b2\u0006\u0010^\u001A\u000201H\u0002J\b\u0010_\u001A\u000201H\u0002J\b\u0010`\u001A\u000201H\u0002J\b\u0010a\u001A\u000201H\u0002J\u0010\u0010b\u001A\u0002012\u0006\u00100\u001A\u000201H\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0005\u001A\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001C\u0010\u001A\u001A\u00020\u0006X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0013\u001A\u0004\b\u001B\u0010\u0012\"\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001E\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0010\"\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020#8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u0006d"}, d2={"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "getOriginalSelection-d9O1mEE", "()J", "J", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "text", "", "getText$foundation", "()Ljava/lang/String;", "apply", "U", "resetCachedX", "", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "setCursor", "offset", "", "setSelection", "start", "end", "selectAll", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "deselect", "moveCursorLeft", "moveCursorRight", "collapseLeftOr", "or", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCodePointOrEmojiStartIndex", "getPrecedingCharacterIndex", "getNextCharacterIndex", "moveCursorPrev", "moveCursorNext", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "moveCursorNextByWord", "getPreviousWordOffset", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "transformedEndOffset", "transformedMinOffset", "transformedMaxOffset", "charOffset", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class BaseTextPreparedSelection {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
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
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    static {
        BaseTextPreparedSelection.Companion = new Companion(null);
        BaseTextPreparedSelection.$stable = 8;
    }

    private BaseTextPreparedSelection(AnnotatedString arg1, long arg2, TextLayoutResult arg4, OffsetMapping arg5, TextPreparedSelectionState arg6) {
        super();
        this.originalText = arg1;
        this.originalSelection = arg2;
        this.layoutResult = arg4;
        this.offsetMapping = arg5;
        this.state = arg6;
        this.selection = arg2;
        this.annotatedString = arg1;
    }

    public BaseTextPreparedSelection(AnnotatedString arg1, long arg2, TextLayoutResult arg4, OffsetMapping arg5, TextPreparedSelectionState arg6, DefaultConstructorMarker arg7) {
        this(arg1, arg2, arg4, arg5, arg6);
    }

    protected final BaseTextPreparedSelection apply(Object arg1, boolean arg2, Function1 arg3) {
        if(arg2) {
            this.getState().resetCachedX();
        }

        if(this.getText$foundation().length() > 0) {
            arg3.invoke(arg1);
        }

        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return arg1;
    }

    public static BaseTextPreparedSelection apply$default(BaseTextPreparedSelection arg0, Object arg1, boolean arg2, Function1 arg3, int arg4, Object arg5) {
        if(arg5 == null) {
            if(1 != 0) {
                arg0.getState().resetCachedX();
            }

            if(arg0.getText$foundation().length() > 0) {
                arg3.invoke(arg1);
            }

            Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return arg1;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }

    private final int charOffset(int arg1) {
        return RangesKt.coerceAtMost(arg1, this.getText$foundation().length() - 1);
    }

    public final BaseTextPreparedSelection collapseLeftOr(Function1 arg5) {
        this.getState().resetCachedX();
        String v1 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection";
        if(this.getText$foundation().length() > 0) {
            if(TextRange.getCollapsed-impl(this.selection)) {
                Intrinsics.checkNotNull(this, v1);
                arg5.invoke(this);
            }
            else {
                boolean v5 = this.isLtr();
                long v2 = this.selection;
                if(v5) {
                    this.setCursor(TextRange.getMin-impl(v2));
                }
                else {
                    this.setCursor(TextRange.getMax-impl(v2));
                }
            }
        }

        Intrinsics.checkNotNull(this, v1);
        return this;
    }

    public final BaseTextPreparedSelection collapseRightOr(Function1 arg5) {
        this.getState().resetCachedX();
        String v1 = "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection";
        if(this.getText$foundation().length() > 0) {
            if(TextRange.getCollapsed-impl(this.selection)) {
                Intrinsics.checkNotNull(this, v1);
                arg5.invoke(this);
            }
            else {
                boolean v5 = this.isLtr();
                long v2 = this.selection;
                if(v5) {
                    this.setCursor(TextRange.getMax-impl(v2));
                }
                else {
                    this.setCursor(TextRange.getMin-impl(v2));
                }
            }
        }

        Intrinsics.checkNotNull(this, v1);
        return this;
    }

    public final BaseTextPreparedSelection deselect() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            this.setCursor(TextRange.getEnd-impl(this.selection));
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult v0 = this.layoutResult;
        Object v1 = null;
        if(v0 != null) {
            return Integer.valueOf(BaseTextPreparedSelection.getLineEndByOffsetForLayout$default(this, v0, 0, 1, v1));
        }

        return ((Integer)v1);
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult arg2, int arg3) {
        return this.offsetMapping.transformedToOriginal(arg2.getLineEnd(arg2.getLineForOffset(arg3), true));
    }

    static int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = arg0.transformedMaxOffset();
            }

            return arg0.getLineEndByOffsetForLayout(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult v0 = this.layoutResult;
        Object v1 = null;
        if(v0 != null) {
            return Integer.valueOf(BaseTextPreparedSelection.getLineStartByOffsetForLayout$default(this, v0, 0, 1, v1));
        }

        return ((Integer)v1);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult arg1, int arg2) {
        return this.offsetMapping.transformedToOriginal(arg1.getLineStart(arg1.getLineForOffset(arg2)));
    }

    static int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = arg0.transformedMinOffset();
            }

            return arg0.getLineStartByOffsetForLayout(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult v0 = this.layoutResult;
        Object v1 = null;
        if(v0 != null) {
            return Integer.valueOf(BaseTextPreparedSelection.getNextWordOffsetForLayout$default(this, v0, 0, 1, v1));
        }

        return ((Integer)v1);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult arg4, int arg5) {
        long v0;
        while(true) {
            if(arg5 >= this.originalText.length()) {
                goto label_3;
            }

            v0 = arg4.getWordBoundary--jx7JFs(this.charOffset(arg5));
            if(TextRange.getEnd-impl(v0) > arg5) {
                break;
            }

            ++arg5;
        }

        return this.offsetMapping.transformedToOriginal(TextRange.getEnd-impl(v0));
    label_3:
        return this.originalText.length();
    }

    static int getNextWordOffsetForLayout$default(BaseTextPreparedSelection arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = arg0.transformedEndOffset();
            }

            return arg0.getNextWordOffsetForLayout(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final long getOriginalSelection-d9O1mEE() {
        return this.originalSelection;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection));
    }

    public final int getPrecedingCodePointOrEmojiStartIndex() {
        return StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.annotatedString.getText(), TextRange.getEnd-impl(this.selection), -1);
    }

    private final int getPrevWordOffset(TextLayoutResult arg4, int arg5) {
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

        return this.offsetMapping.transformedToOriginal(TextRange.getStart-impl(v0));
    }

    static int getPrevWordOffset$default(BaseTextPreparedSelection arg0, TextLayoutResult arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                arg2 = arg0.transformedEndOffset();
            }

            return arg0.getPrevWordOffset(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult v0 = this.layoutResult;
        Object v1 = null;
        if(v0 != null) {
            return Integer.valueOf(BaseTextPreparedSelection.getPrevWordOffset$default(this, v0, 0, 1, v1));
        }

        return ((Integer)v1);
    }

    public final long getSelection-d9O1mEE() {
        return this.selection;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    public final String getText$foundation() {
        return this.annotatedString.getText();
    }

    private final boolean isLtr() {
        TextLayoutResult v0 = this.layoutResult;
        ResolvedTextDirection v1 = v0 != null ? v0.getParagraphDirection(this.transformedEndOffset()) : null;
        if(v1 != ResolvedTextDirection.Rtl) {
            return 1;
        }

        return 0;
    }

    private final int jumpByLinesOffset(TextLayoutResult arg7, int arg8) {
        int v0 = this.transformedEndOffset();
        if(this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(arg7.getCursorRect(v0).getLeft()));
        }

        v0 = arg7.getLineForOffset(v0) + arg8;
        if(v0 < 0) {
            return 0;
        }

        if(v0 >= arg7.getLineCount()) {
            return this.getText$foundation().length();
        }

        float v8 = arg7.getLineBottom(v0) - 1f;
        Float v1 = this.state.getCachedX();
        Intrinsics.checkNotNull(v1);
        float v2 = ((Number)v1).floatValue();
        if((this.isLtr()) && v2 >= arg7.getLineRight(v0) || !this.isLtr() && v2 <= arg7.getLineLeft(v0)) {
            return arg7.getLineEnd(v0, true);
        }

        return this.offsetMapping.transformedToOriginal(arg7.getOffsetForPosition-k-4lQ0M(Offset.constructor-impl((((long)Float.floatToRawIntBits(((Number)v1).floatValue()))) << 0x20 | (((long)Float.floatToRawIntBits(v8))) & 0xFFFFFFFFL)));
    }

    public final BaseTextPreparedSelection moveCursorDownByLine() {
        if(this.getText$foundation().length() > 0) {
            TextLayoutResult v0 = this.layoutResult;
            if(v0 != null) {
                this.setCursor(this.jumpByLinesOffset(v0, 1));
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorLeft() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorPrev();
            }
            else {
                this.moveCursorNext();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorLeftByWord() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorPrevByWord();
            }
            else {
                this.moveCursorNextByWord();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection moveCursorNext() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            int v0 = this.getNextCharacterIndex();
            if(v0 != -1) {
                this.setCursor(v0);
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorNextByParagraph() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            int v0 = StringHelpersKt.findParagraphEnd(this.getText$foundation(), TextRange.getMax-impl(this.selection));
            if(v0 == TextRange.getMax-impl(this.selection) && v0 != this.getText$foundation().length()) {
                v0 = StringHelpersKt.findParagraphEnd(this.getText$foundation(), v0 + 1);
            }

            this.setCursor(v0);
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection moveCursorNextByWord() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            Integer v0 = this.getNextWordOffset();
            if(v0 != null) {
                this.setCursor(((Number)v0).intValue());
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection moveCursorPrev() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            int v0 = this.getPrecedingCharacterIndex();
            if(v0 != -1) {
                this.setCursor(v0);
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorPrevByParagraph() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            int v0 = StringHelpersKt.findParagraphStart(this.getText$foundation(), TextRange.getMin-impl(this.selection));
            if(v0 == TextRange.getMin-impl(this.selection) && v0 != 0) {
                v0 = StringHelpersKt.findParagraphStart(this.getText$foundation(), v0 - 1);
            }

            this.setCursor(v0);
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    private final BaseTextPreparedSelection moveCursorPrevByWord() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            Integer v0 = this.getPreviousWordOffset();
            if(v0 != null) {
                this.setCursor(((Number)v0).intValue());
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorRight() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorNext();
            }
            else {
                this.moveCursorPrev();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorRightByWord() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorNextByWord();
            }
            else {
                this.moveCursorPrevByWord();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToEnd() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            this.setCursor(this.getText$foundation().length());
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToHome() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            this.setCursor(0);
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToLineEnd() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            Integer v0 = this.getLineEndByOffset();
            if(v0 != null) {
                this.setCursor(((Number)v0).intValue());
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToLineLeftSide() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorToLineStart();
            }
            else {
                this.moveCursorToLineEnd();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToLineRightSide() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            if(this.isLtr()) {
                this.moveCursorToLineEnd();
            }
            else {
                this.moveCursorToLineStart();
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorToLineStart() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            Integer v0 = this.getLineStartByOffset();
            if(v0 != null) {
                this.setCursor(((Number)v0).intValue());
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection moveCursorUpByLine() {
        if(this.getText$foundation().length() > 0) {
            TextLayoutResult v0 = this.layoutResult;
            if(v0 != null) {
                this.setCursor(this.jumpByLinesOffset(v0, -1));
            }
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection selectAll() {
        this.getState().resetCachedX();
        if(this.getText$foundation().length() > 0) {
            this.setSelection(0, this.getText$foundation().length());
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final BaseTextPreparedSelection selectMovement() {
        if(this.getText$foundation().length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.getStart-impl(this.originalSelection), TextRange.getEnd-impl(this.selection));
        }

        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    }

    public final void setAnnotatedString(AnnotatedString arg1) {
        this.annotatedString = arg1;
    }

    protected final void setCursor(int arg1) {
        this.setSelection(arg1, arg1);
    }

    protected final void setSelection(int arg1, int arg2) {
        this.selection = TextRangeKt.TextRange(arg1, arg2);
    }

    public final void setSelection-5zc-tL8(long arg1) {
        this.selection = arg1;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMax-impl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.getMin-impl(this.selection));
    }
}

