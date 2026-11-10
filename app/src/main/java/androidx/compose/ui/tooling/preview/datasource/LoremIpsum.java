package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0010\u0010\f\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2={"Landroidx/compose/ui/tooling/preview/datasource/LoremIpsum;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "", "words", "", "<init>", "(I)V", "()V", "values", "Lkotlin/sequences/Sequence;", "getValues", "()Lkotlin/sequences/Sequence;", "generateLoremIpsum", "ui-tooling-preview"}, k=1, mv={2, 0, 0}, xi=0x30) public class LoremIpsum implements PreviewParameterProvider {
    public static final int $stable;
    private final int words;

    static {
    }

    public LoremIpsum() {
        this(500);
    }

    public LoremIpsum(int arg1) {
        super();
        this.words = arg1;
    }

    private final String generateLoremIpsum(int arg10) {
        return SequencesKt.joinToString$default(SequencesKt.take(SequencesKt.generateSequence(new LoremIpsum$$ExternalSyntheticLambda0(new IntRef(), LoremIpsumKt.access$getLOREM_IPSUM_SOURCE$p().size())), arg10), " ", null, null, 0, null, null, 62, null);
    }

    static final String generateLoremIpsum$lambda$0(IntRef arg3, int arg4) {
        List v0 = LoremIpsumKt.access$getLOREM_IPSUM_SOURCE$p();
        int v1 = arg3.element;
        arg3.element = v1 + 1;
        return v0.get(v1 % arg4);
    }

    public Sequence getValues() {
        return SequencesKt.sequenceOf(new String[]{this.generateLoremIpsum(this.words)});
    }
}

