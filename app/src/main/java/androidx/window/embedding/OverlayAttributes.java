package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000FB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2={"Landroidx/window/embedding/OverlayAttributes;", "", "bounds", "Landroidx/window/embedding/EmbeddingBounds;", "<init>", "(Landroidx/window/embedding/EmbeddingBounds;)V", "getBounds", "()Landroidx/window/embedding/EmbeddingBounds;", "toString", "", "equals", "", "other", "hashCode", "", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverlayAttributes {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u0006\u0010\u0007\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/window/embedding/OverlayAttributes$Builder;", "", "<init>", "()V", "bounds", "Landroidx/window/embedding/EmbeddingBounds;", "setBounds", "build", "Landroidx/window/embedding/OverlayAttributes;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private EmbeddingBounds bounds;

        public Builder() {
            super();
            this.bounds = EmbeddingBounds.BOUNDS_EXPANDED;
        }

        public final OverlayAttributes build() {
            return new OverlayAttributes(this.bounds);
        }

        public final Builder setBounds(EmbeddingBounds arg2) {
            Intrinsics.checkNotNullParameter(arg2, "bounds");
            this.bounds = arg2;
            return this;
        }
    }

    private final EmbeddingBounds bounds;

    public OverlayAttributes(EmbeddingBounds arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bounds");
        super();
        this.bounds = arg2;
    }

    public OverlayAttributes() {
        this(null, 1, null);
    }

    public OverlayAttributes(EmbeddingBounds arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = EmbeddingBounds.BOUNDS_EXPANDED;
        }

        this(arg1);
    }

    public boolean equals(Object arg2) {
        if(this == (((OverlayAttributes)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof OverlayAttributes)) {
            return 0;
        }

        return Intrinsics.areEqual(this.bounds, ((OverlayAttributes)arg2).bounds);
    }

    public final EmbeddingBounds getBounds() {
        return this.bounds;
    }

    public int hashCode() {
        return this.bounds.hashCode();
    }

    public String toString() {
        return "OverlayAttributes: {bounds=" + this.bounds + '}';
    }
}

