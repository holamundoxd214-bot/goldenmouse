package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\u0003H\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/window/embedding/EmbeddingAspectRatio;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getDescription$window_release", "()Ljava/lang/String;", "getValue$window_release", "()F", "toString", "equals", "", "other", "hashCode", "", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingAspectRatio {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\b\u0001\u0010\u0004\u001A\u00020\u0006H\u0007J\u0015\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0006H\u0000¢\u0006\u0002\b\u000BR\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/window/embedding/EmbeddingAspectRatio$Companion;", "", "<init>", "()V", "ratio", "Landroidx/window/embedding/EmbeddingAspectRatio;", "", "ALWAYS_ALLOW", "ALWAYS_DISALLOW", "buildAspectRatioFromValue", "value", "buildAspectRatioFromValue$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final EmbeddingAspectRatio buildAspectRatioFromValue$window_release(float arg2) {
            if(arg2 == EmbeddingAspectRatio.ALWAYS_ALLOW.getValue$window_release()) {
                return EmbeddingAspectRatio.ALWAYS_ALLOW;
            }

            if(arg2 == EmbeddingAspectRatio.ALWAYS_DISALLOW.getValue$window_release()) {
                return EmbeddingAspectRatio.ALWAYS_DISALLOW;
            }

            return this.ratio(arg2);
        }

        @JvmStatic public final EmbeddingAspectRatio ratio(float arg3) {
            if(arg3 > 1f) {
                return new EmbeddingAspectRatio("ratio:" + arg3, arg3, null);
            }

            throw new IllegalArgumentException("Ratio must be greater than 1.".toString());
        }
    }

    public static final EmbeddingAspectRatio ALWAYS_ALLOW;
    public static final EmbeddingAspectRatio ALWAYS_DISALLOW;
    public static final Companion Companion;
    private final String description;
    private final float value;

    static {
        EmbeddingAspectRatio.Companion = new Companion(null);
        EmbeddingAspectRatio.ALWAYS_ALLOW = new EmbeddingAspectRatio("ALWAYS_ALLOW", 0f);
        EmbeddingAspectRatio.ALWAYS_DISALLOW = new EmbeddingAspectRatio("ALWAYS_DISALLOW", -1f);
    }

    private EmbeddingAspectRatio(String arg1, float arg2) {
        super();
        this.description = arg1;
        this.value = arg2;
    }

    public EmbeddingAspectRatio(String arg1, float arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if((((EmbeddingAspectRatio)arg5)) == this) {
            return 1;
        }

        if(!(arg5 instanceof EmbeddingAspectRatio)) {
            return 0;
        }

        if(this.value == ((EmbeddingAspectRatio)arg5).value && (Intrinsics.areEqual(this.description, ((EmbeddingAspectRatio)arg5).description))) {
            return 1;
        }

        return 0;
    }

    public final String getDescription$window_release() {
        return this.description;
    }

    public final float getValue$window_release() {
        return this.value;
    }

    public int hashCode() {
        return this.description.hashCode() + Float.hashCode(this.value) * 0x1F;
    }

    @JvmStatic public static final EmbeddingAspectRatio ratio(float arg1) {
        return EmbeddingAspectRatio.Companion.ratio(arg1);
    }

    public String toString() {
        return "EmbeddingAspectRatio(" + this.description + ')';
    }
}

