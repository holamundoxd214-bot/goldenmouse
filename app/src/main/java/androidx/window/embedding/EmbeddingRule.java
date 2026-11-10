package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/window/embedding/EmbeddingRule;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class EmbeddingRule {
    private final String tag;

    public EmbeddingRule(String arg1) {
        super();
        this.tag = arg1;
    }

    public boolean equals(Object arg2) {
        if(this == (((EmbeddingRule)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof EmbeddingRule)) {
            return 0;
        }

        return Intrinsics.areEqual(this.tag, ((EmbeddingRule)arg2).tag);
    }

    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        String v0 = this.tag;
        if(v0 != null) {
            return v0.hashCode();
        }

        return 0;
    }
}

