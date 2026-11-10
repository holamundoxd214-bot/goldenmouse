package androidx.compose.ui.tooling.preview;

import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\bH\u0016R\u0018\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000EÀ\u0006\u0003"}, d2={"Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "T", "", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "count", "", "getCount", "()I", "getDisplayName", "", "index", "ui-tooling-preview"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PreviewParameterProvider {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static int getCount(PreviewParameterProvider arg0) {
            return arg0.getCount();
        }

        @Deprecated public static String getDisplayName(PreviewParameterProvider arg0, int arg1) {
            return arg0.getDisplayName(arg1);
        }
    }

    static int access$getCount$jd(PreviewParameterProvider arg0) {
        return super.getCount();
    }

    static String access$getDisplayName$jd(PreviewParameterProvider arg0, int arg1) {
        return super.getDisplayName(arg1);
    }

    default int getCount() {
        return SequencesKt.count(this.getValues());
    }

    default String getDisplayName(int arg1) {
        return null;
    }

    Sequence getValues();
}

