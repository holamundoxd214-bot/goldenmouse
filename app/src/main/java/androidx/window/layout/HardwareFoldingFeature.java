package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00020\u0001:\u0002$%B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001D\u001A\u00020\u001EH\u0016J\u0013\u0010\u001F\u001A\u00020\u00132\b\u0010 \u001A\u0004\u0018\u00010!H\u0096\u0002J\b\u0010\"\u001A\u00020#H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u001A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006&"}, d2={"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/FoldingFeature;", "featureBounds", "Landroidx/window/core/Bounds;", "type", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "state", "Landroidx/window/layout/FoldingFeature$State;", "<init>", "(Landroidx/window/core/Bounds;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/FoldingFeature$State;)V", "getType$window_release", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "getState", "()Landroidx/window/layout/FoldingFeature$State;", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "isSeparating", "", "()Z", "occlusionType", "Landroidx/window/layout/FoldingFeature$OcclusionType;", "getOcclusionType", "()Landroidx/window/layout/FoldingFeature$OcclusionType;", "orientation", "Landroidx/window/layout/FoldingFeature$Orientation;", "getOrientation", "()Landroidx/window/layout/FoldingFeature$Orientation;", "toString", "", "equals", "other", "", "hashCode", "", "Companion", "Type", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class HardwareFoldingFeature implements FoldingFeature {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2={"Landroidx/window/layout/HardwareFoldingFeature$Companion;", "", "<init>", "()V", "validateFeatureBounds", "", "bounds", "Landroidx/window/core/Bounds;", "validateFeatureBounds$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final void validateFeatureBounds$window_release(Bounds arg1) {
            Intrinsics.checkNotNullParameter(arg1, "bounds");
            if(arg1.getWidth() == 0) {
                if(arg1.getHeight() != 0) {
                }
                else {
                    throw new IllegalArgumentException("Bounds must be non zero".toString());
                }
            }

            if(arg1.getLeft() != 0) {
                if(arg1.getTop() == 0) {
                }
                else {
                    throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
                }
            }
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "toString", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Type {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/window/layout/HardwareFoldingFeature$Type$Companion;", "", "<init>", "()V", "FOLD", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "getFOLD", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "HINGE", "getHINGE", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.layout.HardwareFoldingFeature$Type$Companion {
            public androidx.window.layout.HardwareFoldingFeature$Type$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.layout.HardwareFoldingFeature$Type$Companion() {
                super();
            }

            public final Type getFOLD() {
                return Type.FOLD;
            }

            public final Type getHINGE() {
                return Type.HINGE;
            }
        }

        public static final androidx.window.layout.HardwareFoldingFeature$Type$Companion Companion;
        private static final Type FOLD;
        private static final Type HINGE;
        private final String description;

        static {
            Type.Companion = new androidx.window.layout.HardwareFoldingFeature$Type$Companion(null);
            Type.FOLD = new Type("FOLD");
            Type.HINGE = new Type("HINGE");
        }

        private Type(String arg1) {
            super();
            this.description = arg1;
        }

        public static final Type access$getFOLD$cp() {
            return Type.FOLD;
        }

        public static final Type access$getHINGE$cp() {
            return Type.HINGE;
        }

        public String toString() {
            return this.description;
        }
    }

    public static final Companion Companion;
    private final Bounds featureBounds;
    private final State state;
    private final Type type;

    static {
        HardwareFoldingFeature.Companion = new Companion(null);
    }

    public HardwareFoldingFeature(Bounds arg2, Type arg3, State arg4) {
        Intrinsics.checkNotNullParameter(arg2, "featureBounds");
        Intrinsics.checkNotNullParameter(arg3, "type");
        Intrinsics.checkNotNullParameter(arg4, "state");
        super();
        this.featureBounds = arg2;
        this.type = arg3;
        this.state = arg4;
        HardwareFoldingFeature.Companion.validateFeatureBounds$window_release(arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((HardwareFoldingFeature)arg5))) {
            return 1;
        }

        Class v1 = this.getClass();
        if(arg5 != null) {
            Class v2 = arg5.getClass();
        }
        else {
            Object v2_1 = null;
        }

        if(!Intrinsics.areEqual(v1, v2_1)) {
            return 0;
        }

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        if(!Intrinsics.areEqual(this.featureBounds, ((HardwareFoldingFeature)arg5).featureBounds)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.type, ((HardwareFoldingFeature)arg5).type)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.getState(), ((HardwareFoldingFeature)arg5).getState())) {
            return 0;
        }

        return 1;
    }

    public Rect getBounds() {
        return this.featureBounds.toRect();
    }

    public OcclusionType getOcclusionType() {
        if(this.featureBounds.getWidth() != 0) {
            if(this.featureBounds.getHeight() == 0) {
            }
            else {
                return OcclusionType.FULL;
            }
        }

        return OcclusionType.NONE;
    }

    public Orientation getOrientation() {
        if(this.featureBounds.getWidth() > this.featureBounds.getHeight()) {
            return Orientation.HORIZONTAL;
        }

        return Orientation.VERTICAL;
    }

    public State getState() {
        return this.state;
    }

    public final Type getType$window_release() {
        return this.type;
    }

    public int hashCode() {
        return (this.featureBounds.hashCode() * 0x1F + this.type.hashCode()) * 0x1F + this.getState().hashCode();
    }

    public boolean isSeparating() {
        if(Intrinsics.areEqual(this.type, Type.Companion.getHINGE())) {
            return 1;
        }

        if((Intrinsics.areEqual(this.type, Type.Companion.getFOLD())) && (Intrinsics.areEqual(this.getState(), State.HALF_OPENED))) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        return "HardwareFoldingFeature { " + this.featureBounds + ", type=" + this.type + ", state=" + this.getState() + " }";
    }
}

