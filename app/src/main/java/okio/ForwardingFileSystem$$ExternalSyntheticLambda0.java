package okio;

import kotlin.jvm.functions.Function1;

public final class ForwardingFileSystem$$ExternalSyntheticLambda0 implements Function1 {
    public ForwardingFileSystem$$ExternalSyntheticLambda0(ForwardingFileSystem arg1) {
        super();
        this.f$0 = arg1;
    }

    public final Object invoke(Object arg1) {
        return ForwardingFileSystem.listRecursively$lambda$0(this.f$0, ((Path)arg1));
    }
}

