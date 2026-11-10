package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\u0080\u0004\u001AF\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0080\u0080\u0004\u001AJ\u0010\f\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0080\u0080\u0004¨\u0006\u000F"}, d2={"checkWindowSizeStep", "", "size", "", "step", "windowedSequence", "Lkotlin/sequences/Sequence;", "", "T", "partialWindows", "", "reuseBuffer", "windowedIterator", "", "iterator", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class SlidingWindowKt {
    public static final void checkWindowSizeStep(int arg3, int arg4) {
        if(arg3 > 0 && arg4 > 0) {
            return;
        }

        String v0 = " must be greater than zero.";
        String v3 = arg3 != arg4 ? "Both size " + arg3 + " and step " + arg4 + v0 : "size " + arg3 + v0;
        throw new IllegalArgumentException(v3.toString());
    }

    public static final Iterator windowedIterator(Iterator arg7, int arg8, int arg9, boolean arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg7, "iterator");
        if(!arg7.hasNext()) {
            return EmptyIterator.INSTANCE;
        }

        return SequencesKt.iterator(new SlidingWindowKt$windowedIterator$1(arg8, arg9, arg7, arg11, arg10, null));
    }

    public static final Sequence windowedSequence(Sequence arg7, int arg8, int arg9, boolean arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        SlidingWindowKt.checkWindowSizeStep(arg8, arg9);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(arg7, arg8, arg9, arg10, arg11);
    }
}

