package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.functions.Function1;

public final class TextStreamsKt$$ExternalSyntheticLambda0 implements Function1 {
    public TextStreamsKt$$ExternalSyntheticLambda0(ArrayList arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return TextStreamsKt.readLines$lambda$0(this.f$0, ((String)arg1));
    }
}

