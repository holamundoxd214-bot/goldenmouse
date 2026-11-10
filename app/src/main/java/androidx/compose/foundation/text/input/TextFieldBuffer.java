package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString$Annotation;
import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0086\u0001B3\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0004\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010;\u001A\u00020\'H\u0000¢\u0006\u0002\b<J\r\u0010=\u001A\u00020>H\u0000¢\u0006\u0002\b?J9\u0010@\u001A\u00020>2\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u00152\u001A\b\u0002\u0010C\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0002\bFJ\'\u0010L\u001A\u00020>2\u0006\u0010M\u001A\u00020H2\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u0015H\u0000¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001A\u00020>H\u0000¢\u0006\u0002\bQJ\u001E\u0010R\u001A\u00020>2\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u00152\u0006\u0010S\u001A\u00020\u0019J9\u0010R\u001A\u00020>2\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u00152\u0006\u0010S\u001A\u00020\u00192\b\b\u0002\u0010T\u001A\u00020\u00152\b\b\u0002\u0010U\u001A\u00020\u0015H\u0000¢\u0006\u0002\bVJ\u0015\u0010W\u001A\u00020>2\u0006\u0010X\u001A\u00020\u0019H\u0000¢\u0006\u0002\bYJ\u0016\u0010Z\u001A\u00060\u0001j\u0002`\u00022\b\u0010S\u001A\u0004\u0018\u00010\u0019H\u0016J&\u0010Z\u001A\u00060\u0001j\u0002`\u00022\b\u0010S\u001A\u0004\u0018\u00010\u00192\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u0015H\u0016J\u0014\u0010Z\u001A\u00060\u0001j\u0002`\u00022\u0006\u0010[\u001A\u00020\\H\u0016J \u0010]\u001A\u00020>2\u0006\u0010^\u001A\u00020\u00152\u0006\u0010_\u001A\u00020\u00152\u0006\u0010`\u001A\u00020\u0015H\u0002J\u000E\u0010a\u001A\u00020\\2\u0006\u0010b\u001A\u00020\u0015J\b\u0010c\u001A\u00020dH\u0016J\u0006\u0010e\u001A\u00020\u0019J\b\u0010f\u001A\u00020>H\u0002J\u0006\u0010g\u001A\u00020>J\u000E\u0010h\u001A\u00020>2\u0006\u0010b\u001A\u00020\u0015J\u000E\u0010i\u001A\u00020>2\u0006\u0010b\u001A\u00020\u0015J]\u0010j\u001A\u00020\u00042\b\b\u0002\u0010,\u001A\u00020\u001D2\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u001D2\u001A\b\u0002\u00108\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010D2\u001A\b\u0002\u0010k\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0004\bl\u0010mJ \u0010n\u001A\u00020>2\u0006\u0010b\u001A\u00020\u00152\u0006\u0010o\u001A\u00020\'2\u0006\u0010p\u001A\u00020\'H\u0002J\u0017\u0010q\u001A\u00020>2\u0006\u0010r\u001A\u00020\u001DH\u0002¢\u0006\u0004\bs\u0010/J&\u0010~\u001A\u00020>2\u0006\u0010\u007F\u001A\u0002072\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u0015H\u0000¢\u0006\u0003\b\u0080\u0001J!\u0010\u0081\u0001\u001A\u00020>2\b\u0010\u0082\u0001\u001A\u00030\u0083\u00012\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u0015J!\u0010\u0081\u0001\u001A\u00020>2\b\u0010\u0084\u0001\u001A\u00030\u0085\u00012\u0006\u0010A\u001A\u00020\u00152\u0006\u0010B\u001A\u00020\u0015R\u0014\u0010\u0007\u001A\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001A\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001A\u00020\u00158F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\u001C\u001A\u00020\u001D8F¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u001A\u0010 \u001A\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u0011\u0010&\u001A\u00020\'8G¢\u0006\u0006\u001A\u0004\b&\u0010(R\u0010\u0010)\u001A\u00020\u001DX\u0082\u000E¢\u0006\u0004\n\u0002\u0010*R$\u0010,\u001A\u00020\u001D2\u0006\u0010+\u001A\u00020\u001D8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b-\u0010\u001F\"\u0004\b.\u0010/R(\u00100\u001A\u0004\u0018\u00010\u001D2\b\u0010+\u001A\u0004\u0018\u00010\u001D@BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b1\u00102\"\u0004\b3\u00104R:\u00108\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u0001052\u0014\u0010+\u001A\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u000105@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b9\u0010:R:\u0010I\u001A\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001D\u0018\u00010G2\u0014\u0010+\u001A\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001D\u0018\u00010G@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\bJ\u0010KR\u001A\u0010t\u001A\u00020\'X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bu\u0010(\"\u0004\bv\u0010wR,\u0010x\u001A\u0014\u0012\u000E\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010yX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\bz\u0010{\"\u0004\b|\u0010}¨\u0006\u0087\u0001"}, d2={"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOriginalValue$foundation", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "backingChangeTracker", "changeTracker", "getChangeTracker$foundation", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "length", "", "getLength", "()I", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "getOriginalSelection-d9O1mEE", "()J", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "hasSelection", "", "()Z", "selectionInChars", "J", "value", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "composition", "getComposition-MzsxiRA$foundation", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "composingAnnotations", "getComposingAnnotations$foundation", "()Landroidx/compose/runtime/collection/MutableVector;", "hasComposition", "hasComposition$foundation", "commitComposition", "", "commitComposition$foundation", "setComposition", "start", "end", "annotations", "", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setComposition$foundation", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlight", "getHighlight$foundation", "()Lkotlin/Pair;", "setHighlight", "type", "setHighlight-K7f2yys$foundation", "(III)V", "clearHighlight", "clearHighlight$foundation", "replace", "text", "textStart", "textEnd", "replace$foundation", "setTextIfChanged", "newText", "setTextIfChanged$foundation", "append", "char", "", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "charAt", "index", "toString", "", "asCharSequence", "clearChangeList", "revertAllChanges", "placeCursorBeforeCharAt", "placeCursorAfterCharAt", "toTextFieldCharSequence", "outputAnnotations", "toTextFieldCharSequence-wFTz33Y$foundation", "(JLandroidx/compose/ui/text/TextRange;Ljava/util/List;Ljava/util/List;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", "range", "requireValidRange-5zc-tL8", "canCallAddStyle", "getCanCallAddStyle$foundation", "setCanCallAddStyle$foundation", "(Z)V", "outputTransformationAnnotations", "", "getOutputTransformationAnnotations$foundation", "()Ljava/util/List;", "setOutputTransformationAnnotations$foundation", "(Ljava/util/List;)V", "addAnnotation", "annotation", "addAnnotation$foundation", "addStyle", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "ChangeList", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TextFieldBuffer implements Appendable {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H&¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2={"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ChangeList {
        int getChangeCount();

        long getOriginalRange--jx7JFs(int arg1);

        long getRange--jx7JFs(int arg1);
    }

    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private boolean canCallAddStyle;
    private MutableVector composingAnnotations;
    private TextRange composition;
    private Pair highlight;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private List outputTransformationAnnotations;
    private long selectionInChars;

    static {
    }

    public TextFieldBuffer(TextFieldCharSequence arg3, ChangeTracker arg4, TextFieldCharSequence arg5, OffsetMappingCalculator arg6) {
        super();
        this.originalValue = arg5;
        this.offsetMappingCalculator = arg6;
        this.buffer = new PartialGapBuffer(arg3);
        MutableVector v5 = null;
        ChangeTracker v6 = arg4 != null ? new ChangeTracker(arg4) : ((ChangeTracker)v5);
        this.backingChangeTracker = v6;
        this.selectionInChars = arg3.getSelection-d9O1mEE();
        this.composition = arg3.getComposition-MzsxiRA();
        List v4 = arg3.getComposingAnnotations();
        boolean v6_1 = false;
        if(v4 != null) {
            if(((Collection)v4).isEmpty()) {
            }
            else {
                int v4_1 = arg3.getComposingAnnotations().size();
                TextFieldBuffer$$ExternalSyntheticLambda0 v5_1 = new TextFieldBuffer$$ExternalSyntheticLambda0(arg3);
                Range[] v3 = new Range[v4_1];
                int v0;
                for(v0 = 0; v0 < v4_1; ++v0) {
                    v3[v0] = ((Function1)v5_1).invoke(Integer.valueOf(v0));
                }

                v5 = new MutableVector(((Object[])v3), v4_1);
            }
        }

        this.composingAnnotations = v5;
        if(this.offsetMappingCalculator != null) {
            v6_1 = true;
        }

        this.canCallAddStyle = v6_1;
    }

    public TextFieldBuffer(TextFieldCharSequence arg2, ChangeTracker arg3, TextFieldCharSequence arg4, OffsetMappingCalculator arg5, int arg6, DefaultConstructorMarker arg7) {
        ChangeTracker v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            arg4 = arg2;
        }

        if((arg6 & 8) != 0) {
            arg5 = ((OffsetMappingCalculator)v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public final void addAnnotation$foundation(Annotation arg2, int arg3, int arg4) {
        if(!this.canCallAddStyle) {
            InlineClassHelperKt.throwIllegalStateException("You can add styling to a [TextFieldBuffer] only from an [OutputTransformation].");
        }

        List v0 = this.outputTransformationAnnotations;
        if(v0 == null) {
            ArrayList v0_1 = new ArrayList();
            this.outputTransformationAnnotations = ((List)v0_1);
        }

        if(v0 != null) {
            v0.add(new Range(arg2, arg3, arg4));
        }
    }

    public final void addStyle(ParagraphStyle arg1, int arg2, int arg3) {
        this.addAnnotation$foundation(((Annotation)arg1), arg2, arg3);
    }

    public final void addStyle(SpanStyle arg1, int arg2, int arg3) {
        this.addAnnotation$foundation(((Annotation)arg1), arg2, arg3);
    }

    public Appendable append(char arg12) {
        this.onTextWillChange(this.getLength(), this.getLength(), 1);
        PartialGapBuffer.replace$default(this.buffer, this.buffer.length(), this.buffer.length(), String.valueOf(arg12), 0, 0, 24, null);
        return this;
    }

    public Appendable append(CharSequence arg12) {
        if(arg12 != null) {
            this.onTextWillChange(this.getLength(), this.getLength(), arg12.length());
            PartialGapBuffer.replace$default(this.buffer, this.buffer.length(), this.buffer.length(), arg12, 0, 0, 24, null);
        }

        return this;
    }

    public Appendable append(CharSequence arg12, int arg13, int arg14) {
        if(arg12 != null) {
            this.onTextWillChange(this.getLength(), this.getLength(), arg14 - arg13);
            PartialGapBuffer.replace$default(this.buffer, this.buffer.length(), this.buffer.length(), arg12.subSequence(arg13, arg14), 0, 0, 24, null);
        }

        return this;
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    public final char charAt(int arg1) {
        return this.buffer.charAt(arg1);
    }

    private final void clearChangeList() {
        this.getChangeTracker$foundation().clearChanges();
    }

    public final void clearHighlight$foundation() {
        this.highlight = null;
    }

    public final void commitComposition$foundation() {
        this.setComposition-OEnZFl4(null);
    }

    static final Range composingAnnotations$lambda$0(TextFieldCharSequence arg0, int arg1) {
        return arg0.getComposingAnnotations().get(arg1);
    }

    public final boolean getCanCallAddStyle$foundation() {
        return this.canCallAddStyle;
    }

    public final ChangeTracker getChangeTracker$foundation() {
        ChangeTracker v0 = this.backingChangeTracker;
        if(v0 == null) {
            v0 = new ChangeTracker(null, 1, null);
            this.backingChangeTracker = v0;
        }

        return v0;
    }

    public final ChangeList getChanges() {
        return this.getChangeTracker$foundation();
    }

    public static void getChanges$annotations() {
    }

    public final MutableVector getComposingAnnotations$foundation() {
        return this.composingAnnotations;
    }

    public final TextRange getComposition-MzsxiRA$foundation() {
        return this.composition;
    }

    public final Pair getHighlight$foundation() {
        return this.highlight;
    }

    public final int getLength() {
        return this.buffer.length();
    }

    public final long getOriginalSelection-d9O1mEE() {
        return this.originalValue.getSelection-d9O1mEE();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    public final TextFieldCharSequence getOriginalValue$foundation() {
        return this.originalValue;
    }

    public final List getOutputTransformationAnnotations$foundation() {
        return this.outputTransformationAnnotations;
    }

    public final long getSelection-d9O1mEE() {
        return this.selectionInChars;
    }

    public final boolean hasComposition$foundation() {
        if(this.composition != null) {
            return 1;
        }

        return 0;
    }

    public final boolean hasSelection() {
        return TextRange.getCollapsed-impl(this.getSelection-d9O1mEE()) ^ 1;
    }

    private final void onTextWillChange(int arg3, int arg4, int arg5) {
        this.getChangeTracker$foundation().trackChange(arg3, arg4, arg5);
        OffsetMappingCalculator v0 = this.offsetMappingCalculator;
        if(v0 != null) {
            v0.recordEditOperation(arg3, arg4, arg5);
        }

        this.selectionInChars = TextFieldBufferKt.adjustTextRange-vJH6DeI(this.getSelection-d9O1mEE(), arg3, arg4, arg5);
    }

    public final void placeCursorAfterCharAt(int arg3) {
        this.requireValidIndex(arg3, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(arg3 + 1, this.getLength()));
    }

    public final void placeCursorBeforeCharAt(int arg3) {
        this.requireValidIndex(arg3, true, false);
        this.selectionInChars = TextRangeKt.TextRange(arg3);
    }

    public final void replace(int arg7, int arg8, CharSequence arg9) {
        this.replace$foundation(arg7, arg8, arg9, 0, arg9.length());
    }

    public final void replace$foundation(int arg8, int arg9, CharSequence arg10, int arg11, int arg12) {
        int v0 = 1;
        int v2 = arg8 <= arg9 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected start=" + arg8 + " <= end=" + arg9);
        }

        if(arg11 <= arg12) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected textStart=" + arg11 + " <= textEnd=" + arg12);
        }

        this.onTextWillChange(arg8, arg9, arg12 - arg11);
        this.buffer.replace(arg8, arg9, arg10, arg11, arg12);
        this.commitComposition$foundation();
        this.clearHighlight$foundation();
    }

    public static void replace$foundation$default(TextFieldBuffer arg6, int arg7, int arg8, CharSequence arg9, int arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 16) != 0) {
            arg11 = arg9.length();
        }

        arg6.replace$foundation(arg7, arg8, arg9, 0, arg11);
    }

    private final void requireValidIndex(int arg3, boolean arg4, boolean arg5) {
        int v0 = 0;
        int v4 = arg4 ? 0 : -1;
        int v2 = this.getLength();
        if(arg5) {
        }
        else {
            ++v2;
        }

        if(v4 <= arg3 && arg3 < v2) {
            v0 = 1;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected " + arg3 + " to be in [" + v4 + ", " + v2 + ')');
        }
    }

    private final void requireValidRange-5zc-tL8(long arg4) {
        long v0 = TextRangeKt.TextRange(0, this.getLength());
        if(!TextRange.contains-5zc-tL8(v0, arg4)) {
            InlineClassHelperKt.throwIllegalArgumentException("Expected " + TextRange.toString-impl(arg4) + " to be in " + TextRange.toString-impl(v0));
        }
    }

    public final void revertAllChanges() {
        this.replace(0, this.getLength(), this.originalValue.toString());
        this.setSelection-5zc-tL8(this.originalValue.getSelection-d9O1mEE());
        this.clearChangeList();
    }

    public final void setCanCallAddStyle$foundation(boolean arg1) {
        this.canCallAddStyle = arg1;
    }

    public final void setComposition$foundation(int arg10, int arg11, List arg12) {
        String v0 = ") offset is outside of text region ";
        if(arg10 >= 0 && arg10 <= this.buffer.length()) {
            if(arg11 >= 0 && arg11 <= this.buffer.length()) {
                if(arg10 < arg11) {
                    this.setComposition-OEnZFl4(TextRange.box-impl(TextRangeKt.TextRange(arg10, arg11)));
                    MutableVector v11 = this.composingAnnotations;
                    if(v11 != null) {
                        v11.clear();
                    }

                    List v11_1 = arg12;
                    if(v11_1 != null) {
                        if(((Collection)v11_1).isEmpty()) {
                        }
                        else {
                            int v1 = 0;
                            if(this.composingAnnotations == null) {
                                this.composingAnnotations = new MutableVector(new Range[16], 0);
                            }

                            arg11 = ((Collection)v11_1).size();
                            while(v1 < arg11) {
                                Object v2 = arg12.get(v1);
                                MutableVector v0_1 = this.composingAnnotations;
                                if(v0_1 != null) {
                                    v0_1.add(Range.copy$default(((Range)v2), null, ((Range)v2).getStart() + arg10, ((Range)v2).getEnd() + arg10, null, 9, null));
                                }

                                ++v1;
                            }
                        }
                    }

                    return;
                }
                else {
                    throw new IllegalArgumentException("Do not set reversed or empty range: " + arg10 + " > " + arg11);
                }
            }

            throw new IndexOutOfBoundsException("end (" + arg11 + v0 + this.buffer.length());
        }

        throw new IndexOutOfBoundsException("start (" + arg10 + v0 + this.buffer.length());
    }

    public static void setComposition$foundation$default(TextFieldBuffer arg0, int arg1, int arg2, List arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.setComposition$foundation(arg1, arg2, arg3);
    }

    private final void setComposition-OEnZFl4(TextRange arg3) {
        if(arg3 != null) {
            if(TextRange.getCollapsed-impl(arg3.unbox-impl())) {
            }
            else {
                this.composition = arg3;
                return;
            }
        }

        this.composition = null;
        MutableVector v2 = this.composingAnnotations;
        if(v2 != null) {
            v2.clear();
        }
    }

    public final void setHighlight-K7f2yys$foundation(int arg3, int arg4, int arg5) {
        if(arg4 < arg5) {
            this.highlight = new Pair(TextHighlightType.box-impl(arg3), TextRange.box-impl(TextRangeKt.TextRange(RangesKt.coerceIn(arg4, 0, this.getLength()), RangesKt.coerceIn(arg5, 0, this.getLength()))));
            return;
        }

        throw new IllegalArgumentException("Do not set reversed or empty range: " + arg4 + " > " + arg5);
    }

    public final void setOutputTransformationAnnotations$foundation(List arg1) {
        this.outputTransformationAnnotations = arg1;
    }

    public final void setSelection-5zc-tL8(long arg1) {
        this.requireValidRange-5zc-tL8(arg1);
        this.selectionInChars = arg1;
        this.highlight = null;
    }

    public final void setTextIfChanged$foundation(CharSequence arg14) {
        int v11;
        int v8;
        PartialGapBuffer v0 = this.buffer;
        int v1 = ((CharSequence)v0).length();
        int v2 = arg14.length();
        int v4 = 0;
        if(((CharSequence)v0).length() <= 0 || arg14.length() <= 0) {
            v8 = 0;
            v11 = 0;
        }
        else {
            int v3 = 0;
            int v5 = 0;
            int v6 = 0;
            do {
            label_11:
                if(v4 == 0) {
                    if(((CharSequence)v0).charAt(v3) == arg14.charAt(v5)) {
                        ++v3;
                        ++v5;
                    }
                    else {
                        v4 = 1;
                    }
                }

                if(v6 == 0) {
                    if(((CharSequence)v0).charAt(v1 - 1) == arg14.charAt(v2 - 1)) {
                        --v1;
                        --v2;
                    }
                    else {
                        v6 = 1;
                    }
                }

                if(v3 >= v1) {
                    break;
                }

                if(v5 >= v2) {
                    break;
                }

                if(v4 == 0) {
                    goto label_11;
                }
            }
            while(v6 == 0);

            v8 = v3;
            v11 = v5;
        }

        int v9 = v1;
        int v12 = v2;
        if(v8 >= v9 && v11 >= v12) {
            return;
        }

        this.replace$foundation(v8, v9, arg14, v11, v12);
    }

    public String toString() {
        return this.buffer.toString();
    }

    public final TextFieldCharSequence toTextFieldCharSequence-wFTz33Y$foundation(long arg11, TextRange arg13, List arg14, List arg15) {
        return new TextFieldCharSequence(this.buffer.toString(), arg11, arg13, null, arg14, arg15, 8, null);
    }

    public static TextFieldCharSequence toTextFieldCharSequence-wFTz33Y$foundation$default(TextFieldBuffer arg6, long arg7, TextRange arg9, List arg10, List arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg7 = arg6.getSelection-d9O1mEE();
        }

        long v1 = arg7;
        if((arg12 & 2) != 0) {
            arg9 = arg6.composition;
        }

        TextRange v3 = arg9;
        List v8 = null;
        if((arg12 & 4) != 0) {
            MutableVector v7 = arg6.composingAnnotations;
            if(v7 != null) {
                List v7_1 = v7.asMutableList();
                if(v7_1 != null && !v7_1.isEmpty()) {
                    arg10 = v7_1;
                    goto label_21;
                }
            }

            arg10 = v8;
        }

    label_21:
        List v4 = arg10;
        List v5 = (arg12 & 8) != 0 ? v8 : arg11;
        return arg6.toTextFieldCharSequence-wFTz33Y$foundation(v1, v3, v4, v5);
    }
}

