package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\u001A\u001A\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0001H\u0000¨\u0006\u0004"}, d2={"unbox", "Landroidx/compose/ui/text/AnnotatedString$Range;", "", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class StringAnnotationKt {
    public static final Range unbox(Range arg4) {
        Object v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
        return new Range(((StringAnnotation)v1).unbox-impl(), arg4.getStart(), arg4.getEnd(), arg4.getTag());
    }
}

