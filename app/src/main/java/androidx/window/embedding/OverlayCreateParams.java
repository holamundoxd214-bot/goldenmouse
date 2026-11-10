package androidx.window.embedding;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u000E2\u00020\u0001:\u0002\r\u000EB\u001D\b\u0007\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000F"}, d2={"Landroidx/window/embedding/OverlayCreateParams;", "", "tag", "", "overlayAttributes", "Landroidx/window/embedding/OverlayAttributes;", "<init>", "(Ljava/lang/String;Landroidx/window/embedding/OverlayAttributes;)V", "getTag", "()Ljava/lang/String;", "getOverlayAttributes", "()Landroidx/window/embedding/OverlayAttributes;", "toString", "Builder", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class OverlayCreateParams {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\b\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u000E\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0007J\u0006\u0010\u000B\u001A\u00020\fR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/embedding/OverlayCreateParams$Builder;", "", "<init>", "()V", "tag", "", "launchAttrs", "Landroidx/window/embedding/OverlayAttributes;", "setTag", "setOverlayAttributes", "attrs", "build", "Landroidx/window/embedding/OverlayCreateParams;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private OverlayAttributes launchAttrs;
        private String tag;

        public Builder() {
            super();
        }

        public final OverlayCreateParams build() {
            String v1 = this.tag;
            if(v1 == null) {
                v1 = OverlayCreateParams.Companion.generateOverlayTag();
            }

            OverlayAttributes v2 = this.launchAttrs;
            if(v2 == null) {
                v2 = new androidx.window.embedding.OverlayAttributes$Builder().build();
            }

            return new OverlayCreateParams(v1, v2);
        }

        public final Builder setOverlayAttributes(OverlayAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "attrs");
            this.launchAttrs = arg2;
            return this;
        }

        public final Builder setTag(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "tag");
            this.tag = arg2;
            return this;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0007¨\u0006\u0006"}, d2={"Landroidx/window/embedding/OverlayCreateParams$Companion;", "", "<init>", "()V", "generateOverlayTag", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        @JvmStatic public final String generateOverlayTag() {
            String v3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v3, "toString(...)");
            return StringsKt.substring(v3, new IntRange(0, 0x20));
        }
    }

    public static final Companion Companion;
    private final OverlayAttributes overlayAttributes;
    private final String tag;

    static {
        OverlayCreateParams.Companion = new Companion(null);
    }

    public OverlayCreateParams() {
        this(null, null, 3, null);
    }

    public OverlayCreateParams(String arg1, OverlayAttributes arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = OverlayCreateParams.Companion.generateOverlayTag();
        }

        if((arg3 & 2) != 0) {
            arg2 = new androidx.window.embedding.OverlayAttributes$Builder().build();
        }

        this(arg1, arg2);
    }

    public OverlayCreateParams(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "tag");
        this(arg3, null, 2, null);
    }

    public OverlayCreateParams(String arg2, OverlayAttributes arg3) {
        Intrinsics.checkNotNullParameter(arg2, "tag");
        Intrinsics.checkNotNullParameter(arg3, "overlayAttributes");
        super();
        this.tag = arg2;
        this.overlayAttributes = arg3;
    }

    @JvmStatic public static final String generateOverlayTag() {
        return OverlayCreateParams.Companion.generateOverlayTag();
    }

    public final OverlayAttributes getOverlayAttributes() {
        return this.overlayAttributes;
    }

    public final String getTag() {
        return this.tag;
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(OverlayCreateParams.class).getSimpleName() + ":{ , tag=" + this.tag + ", attrs=" + this.overlayAttributes + '}';
    }
}

