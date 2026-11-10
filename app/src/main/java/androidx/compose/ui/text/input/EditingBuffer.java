package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001A\u00020\b\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\u001A\u001A\u00020\u001BH\u0000¢\u0006\u0002\b\u001CJ\u0016\u0010%\u001A\u00020&2\u0006\u0010\'\u001A\u00020\rH\u0080\u0002¢\u0006\u0002\b(J%\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\r2\u0006\u0010.\u001A\u00020\r2\u0006\u0010\u0002\u001A\u00020\u0003H\u0000¢\u0006\u0002\b/J%\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\r2\u0006\u0010.\u001A\u00020\r2\u0006\u0010\u0002\u001A\u00020\bH\u0000¢\u0006\u0002\b/J\u001D\u00100\u001A\u00020,2\u0006\u0010-\u001A\u00020\r2\u0006\u0010.\u001A\u00020\rH\u0000¢\u0006\u0002\b1J\u001D\u00102\u001A\u00020,2\u0006\u0010-\u001A\u00020\r2\u0006\u0010.\u001A\u00020\rH\u0000¢\u0006\u0002\b3J\u001D\u00104\u001A\u00020,2\u0006\u0010-\u001A\u00020\r2\u0006\u0010.\u001A\u00020\rH\u0000¢\u0006\u0002\b5J\r\u00106\u001A\u00020,H\u0000¢\u0006\u0002\b7J\r\u00108\u001A\u00020,H\u0000¢\u0006\u0002\b9J\b\u0010:\u001A\u00020\bH\u0016J\r\u0010;\u001A\u00020\u0003H\u0000¢\u0006\u0002\b<R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001E\u0010\u0016\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010R\u001E\u0010\u0018\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001D\u001A\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0004\u001A\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R$\u0010\"\u001A\u00020\r2\u0006\u0010\"\u001A\u00020\r8@@@X\u0080\u000E¢\u0006\f\u001A\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u0014\u0010)\u001A\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b*\u0010\u0010¨\u0006>"}, d2={"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "value", "", "selectionStart", "getSelectionStart$ui_text", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text", "setSelectionEnd", "compositionStart", "getCompositionStart$ui_text", "compositionEnd", "getCompositionEnd$ui_text", "hasComposition", "", "hasComposition$ui_text", "composition", "getComposition-MzsxiRA$ui_text", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE$ui_text", "()J", "cursor", "getCursor$ui_text", "setCursor$ui_text", "get", "", "index", "get$ui_text", "length", "getLength$ui_text", "replace", "", "start", "end", "replace$ui_text", "delete", "delete$ui_text", "setSelection", "setSelection$ui_text", "setComposition", "setComposition$ui_text", "cancelComposition", "cancelComposition$ui_text", "commitComposition", "commitComposition$ui_text", "toString", "toAnnotatedString", "toAnnotatedString$ui_text", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EditingBuffer {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/ui/text/input/EditingBuffer$Companion;", "", "<init>", "()V", "NOWHERE", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    static {
        EditingBuffer.Companion = new Companion(null);
        EditingBuffer.$stable = 8;
    }

    public EditingBuffer(AnnotatedString arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    private EditingBuffer(AnnotatedString arg3, long arg4) {
        super();
        this.gapBuffer = new PartialGapBuffer(arg3.getText());
        this.selectionStart = TextRange.getMin-impl(arg4);
        this.selectionEnd = TextRange.getMax-impl(arg4);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int v2 = TextRange.getMin-impl(arg4);
        int v4 = TextRange.getMax-impl(arg4);
        String v5 = ") offset is outside of text region ";
        if(v2 >= 0 && v2 <= arg3.length()) {
            if(v4 >= 0 && v4 <= arg3.length()) {
                if(v2 <= v4) {
                    return;
                }
                else {
                    throw new IllegalArgumentException("Do not set reversed range: " + v2 + " > " + v4);
                }
            }

            throw new IndexOutOfBoundsException("end (" + v4 + v5 + arg3.length());
        }

        throw new IndexOutOfBoundsException("start (" + v2 + v5 + arg3.length());
    }

    private EditingBuffer(String arg4, long arg5) {
        this(new AnnotatedString(arg4, null, 2, null), arg5, null);
    }

    public EditingBuffer(String arg1, long arg2, DefaultConstructorMarker arg4) {
        this(arg1, arg2);
    }

    public final void cancelComposition$ui_text() {
        this.replace$ui_text(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text(int arg5, int arg6) {
        long v0 = TextRangeKt.TextRange(arg5, arg6);
        this.gapBuffer.replace(arg5, arg6, "");
        long v5 = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), v0);
        this.setSelectionStart(TextRange.getMin-impl(v5));
        this.setSelectionEnd(TextRange.getMax-impl(v5));
        if(this.hasComposition$ui_text()) {
            v5 = EditingBufferKt.updateRangeAfterDelete-pWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), v0);
            if(TextRange.getCollapsed-impl(v5)) {
                this.commitComposition$ui_text();
                return;
            }
            else {
                this.compositionStart = TextRange.getMin-impl(v5);
                this.compositionEnd = TextRange.getMax-impl(v5);
            }
        }
    }

    public final char get$ui_text(int arg1) {
        return this.gapBuffer.get(arg1);
    }

    public final TextRange getComposition-MzsxiRA$ui_text() {
        if(this.hasComposition$ui_text()) {
            return TextRange.box-impl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }

        return null;
    }

    public final int getCompositionEnd$ui_text() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text() {
        int v0 = this.selectionStart;
        int v1 = this.selectionEnd;
        if(v0 == v1) {
            return v1;
        }

        return -1;
    }

    public final int getLength$ui_text() {
        return this.gapBuffer.getLength();
    }

    public final long getSelection-d9O1mEE$ui_text() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd$ui_text() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text() {
        if(this.compositionStart != -1) {
            return 1;
        }

        return 0;
    }

    public final void replace$ui_text(int arg3, int arg4, String arg5) {
        String v0 = ") offset is outside of text region ";
        if(arg3 >= 0 && arg3 <= this.gapBuffer.getLength()) {
            if(arg4 >= 0 && arg4 <= this.gapBuffer.getLength()) {
                if(arg3 <= arg4) {
                    this.gapBuffer.replace(arg3, arg4, arg5);
                    this.setSelectionStart(arg5.length() + arg3);
                    this.setSelectionEnd(arg3 + arg5.length());
                    this.compositionStart = -1;
                    this.compositionEnd = -1;
                    return;
                }
                else {
                    throw new IllegalArgumentException("Do not set reversed range: " + arg3 + " > " + arg4);
                }
            }

            throw new IndexOutOfBoundsException("end (" + arg4 + v0 + this.gapBuffer.getLength());
        }

        throw new IndexOutOfBoundsException("start (" + arg3 + v0 + this.gapBuffer.getLength());
    }

    public final void replace$ui_text(int arg1, int arg2, AnnotatedString arg3) {
        this.replace$ui_text(arg1, arg2, arg3.getText());
    }

    public final void setComposition$ui_text(int arg4, int arg5) {
        String v0 = ") offset is outside of text region ";
        if(arg4 >= 0 && arg4 <= this.gapBuffer.getLength()) {
            if(arg5 >= 0 && arg5 <= this.gapBuffer.getLength()) {
                if(arg4 < arg5) {
                    this.compositionStart = arg4;
                    this.compositionEnd = arg5;
                    return;
                }
                else {
                    throw new IllegalArgumentException("Do not set reversed or empty range: " + arg4 + " > " + arg5);
                }
            }

            throw new IndexOutOfBoundsException("end (" + arg5 + v0 + this.gapBuffer.getLength());
        }

        throw new IndexOutOfBoundsException("start (" + arg4 + v0 + this.gapBuffer.getLength());
    }

    public final void setCursor$ui_text(int arg1) {
        this.setSelection$ui_text(arg1, arg1);
    }

    public final void setSelection$ui_text(int arg4, int arg5) {
        String v0 = ") offset is outside of text region ";
        if(arg4 >= 0 && arg4 <= this.gapBuffer.getLength()) {
            if(arg5 >= 0 && arg5 <= this.gapBuffer.getLength()) {
                if(arg4 <= arg5) {
                    this.setSelectionStart(arg4);
                    this.setSelectionEnd(arg5);
                    return;
                }
                else {
                    throw new IllegalArgumentException("Do not set reversed range: " + arg4 + " > " + arg5);
                }
            }

            throw new IndexOutOfBoundsException("end (" + arg5 + v0 + this.gapBuffer.getLength());
        }

        throw new IndexOutOfBoundsException("start (" + arg4 + v0 + this.gapBuffer.getLength());
    }

    private final void setSelectionEnd(int arg3) {
        int v0 = arg3 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + arg3);
        }

        this.selectionEnd = arg3;
    }

    private final void setSelectionStart(int arg3) {
        int v0 = arg3 >= 0 ? 1 : 0;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + arg3);
        }

        this.selectionStart = arg3;
    }

    public final AnnotatedString toAnnotatedString$ui_text() {
        return new AnnotatedString(this.toString(), null, 2, null);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }
}

