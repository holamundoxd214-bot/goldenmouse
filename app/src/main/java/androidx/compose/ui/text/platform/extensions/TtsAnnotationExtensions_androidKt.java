package androidx.compose.ui.text.platform.extensions;

import android.text.style.TtsSpan$VerbatimBuilder;
import android.text.style.TtsSpan;
import androidx.compose.ui.text.TtsAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0003¨\u0006\u0004"}, d2={"toSpan", "Landroid/text/style/TtsSpan;", "Landroidx/compose/ui/text/TtsAnnotation;", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class TtsAnnotationExtensions_androidKt {
    public static final TtsSpan toSpan(TtsAnnotation arg1) {
        if((arg1 instanceof VerbatimTtsAnnotation)) {
            return TtsAnnotationExtensions_androidKt.toSpan(((VerbatimTtsAnnotation)arg1));
        }

        throw new NoWhenBranchMatchedException();
    }

    public static final TtsSpan toSpan(VerbatimTtsAnnotation arg1) {
        return new TtsSpan$VerbatimBuilder(arg1.getVerbatim()).build();
    }
}

