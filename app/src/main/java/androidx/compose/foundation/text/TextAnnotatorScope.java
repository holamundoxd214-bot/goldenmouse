package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString$Range;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005¨\u0006\u0011"}, d2={"Landroidx/compose/foundation/text/TextAnnotatorScope;", "", "initialText", "Landroidx/compose/ui/text/AnnotatedString;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "styledText", "getStyledText", "()Landroidx/compose/ui/text/AnnotatedString;", "setStyledText", "replaceStyle", "", "linkRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "newStyle", "Landroidx/compose/ui/text/SpanStyle;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class TextAnnotatorScope {
    private final AnnotatedString initialText;
    private AnnotatedString styledText;

    public TextAnnotatorScope(AnnotatedString arg1) {
        super();
        this.initialText = arg1;
        this.styledText = arg1;
    }

    public final AnnotatedString getStyledText() {
        return this.styledText;
    }

    public final void replaceStyle(Range arg4, SpanStyle arg5) {
        this.styledText = this.initialText.mapAnnotations(new TextAnnotatorScope$$ExternalSyntheticLambda0(new BooleanRef(), arg4, arg5));
    }

    static final Range replaceStyle$lambda$0(BooleanRef arg25, Range arg26, SpanStyle arg27, Range arg28) {
        Range v3;
        Range v1;
        BooleanRef v0 = arg25;
        if(!v0.element || !(arg28.getItem() instanceof SpanStyle) || arg28.getStart() != arg26.getStart() || arg28.getEnd() != arg26.getEnd()) {
            v1 = arg28;
            v3 = v1;
        }
        else {
            SpanStyle v2 = arg27 == null ? new SpanStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, null, 0xFFFF, null) : arg27;
            v1 = new Range(v2, arg28.getStart(), arg28.getEnd());
            v3 = arg28;
        }

        v0.element = Intrinsics.areEqual(arg26, v3);
        return v1;
    }

    public final void setStyledText(AnnotatedString arg1) {
        this.styledText = arg1;
    }
}

