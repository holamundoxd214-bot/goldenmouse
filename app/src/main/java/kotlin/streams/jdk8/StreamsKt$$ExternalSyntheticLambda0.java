package kotlin.streams.jdk8;

import java.util.function.Supplier;
import kotlin.sequences.Sequence;

public final class StreamsKt$$ExternalSyntheticLambda0 implements Supplier {
    public StreamsKt$$ExternalSyntheticLambda0(Sequence arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object get() {
        return StreamsKt.asStream$lambda$0(this.f$0);
    }
}

