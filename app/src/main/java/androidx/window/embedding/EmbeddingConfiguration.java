package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u001D\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000B\u001A\u00020\u00052\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u0010H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2={"Landroidx/window/embedding/EmbeddingConfiguration;", "", "dimAreaBehavior", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "isAutoSaveEmbeddingState", "", "<init>", "(Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;Z)V", "getDimAreaBehavior", "()Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "()Z", "equals", "other", "hashCode", "", "toString", "", "DimAreaBehavior", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingConfiguration {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0005H\u0007J\u0010\u0010\n\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\u0007H\u0007J\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/window/embedding/EmbeddingConfiguration$Builder;", "", "<init>", "()V", "mDimAreaBehavior", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "mSaveEmbeddingState", "", "setDimAreaBehavior", "area", "setAutoSaveEmbeddingState", "saveState", "build", "Landroidx/window/embedding/EmbeddingConfiguration;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private DimAreaBehavior mDimAreaBehavior;
        private boolean mSaveEmbeddingState;

        public Builder() {
            super();
            this.mDimAreaBehavior = DimAreaBehavior.UNDEFINED;
        }

        public final EmbeddingConfiguration build() {
            return new EmbeddingConfiguration(this.mDimAreaBehavior, this.mSaveEmbeddingState, null);
        }

        public final Builder setAutoSaveEmbeddingState(boolean arg2) {
            this.mSaveEmbeddingState = arg2;
            return this;
        }

        public final Builder setDimAreaBehavior(DimAreaBehavior arg2) {
            Intrinsics.checkNotNullParameter(arg2, "area");
            this.mDimAreaBehavior = arg2;
            return this;
        }
    }

    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "", "value", "", "<init>", "(I)V", "getValue$window_release", "()I", "toString", "", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DimAreaBehavior {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior$Companion;", "", "<init>", "()V", "UNDEFINED", "Landroidx/window/embedding/EmbeddingConfiguration$DimAreaBehavior;", "ON_ACTIVITY_STACK", "ON_TASK", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }
        }

        public static final Companion Companion;
        public static final DimAreaBehavior ON_ACTIVITY_STACK;
        public static final DimAreaBehavior ON_TASK;
        public static final DimAreaBehavior UNDEFINED;
        private final int value;

        static {
            DimAreaBehavior.Companion = new Companion(null);
            DimAreaBehavior.UNDEFINED = new DimAreaBehavior(0);
            DimAreaBehavior.ON_ACTIVITY_STACK = new DimAreaBehavior(1);
            DimAreaBehavior.ON_TASK = new DimAreaBehavior(2);
        }

        private DimAreaBehavior(int arg1) {
            super();
            this.value = arg1;
        }

        public final int getValue$window_release() {
            return this.value;
        }

        public String toString() {
            String v1_1;
            int v1 = this.value;
            if(v1 == 0) {
                v1_1 = "UNDEFINED";
            }
            else if(v1 == 1) {
                v1_1 = "ON_ACTIVITY_STACK";
            }
            else if(v1 != 2) {
                v1_1 = "UNKNOWN";
            }
            else {
                v1_1 = "ON_TASK";
            }

            return "DimAreaBehavior=".concat(v1_1);
        }
    }

    private final DimAreaBehavior dimAreaBehavior;
    private final boolean isAutoSaveEmbeddingState;

    private EmbeddingConfiguration(DimAreaBehavior arg1, boolean arg2) {
        super();
        this.dimAreaBehavior = arg1;
        this.isAutoSaveEmbeddingState = arg2;
    }

    EmbeddingConfiguration(DimAreaBehavior arg1, boolean arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 1) != 0) {
            arg1 = DimAreaBehavior.UNDEFINED;
        }

        this(arg1, false);
    }

    public EmbeddingConfiguration(DimAreaBehavior arg1, boolean arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((EmbeddingConfiguration)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EmbeddingConfiguration)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.dimAreaBehavior, ((EmbeddingConfiguration)arg5).dimAreaBehavior)) {
            return 0;
        }

        if(this.isAutoSaveEmbeddingState != ((EmbeddingConfiguration)arg5).isAutoSaveEmbeddingState) {
            return 0;
        }

        return 1;
    }

    public final DimAreaBehavior getDimAreaBehavior() {
        return this.dimAreaBehavior;
    }

    public int hashCode() {
        return this.dimAreaBehavior.hashCode() * 0x1F + Boolean.hashCode(this.isAutoSaveEmbeddingState);
    }

    public final boolean isAutoSaveEmbeddingState() {
        return this.isAutoSaveEmbeddingState;
    }

    public String toString() {
        return "EmbeddingConfiguration{dimArea=" + this.dimAreaBehavior + ", saveState=" + this.isAutoSaveEmbeddingState + '}';
    }
}

