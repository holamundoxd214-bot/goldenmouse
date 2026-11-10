package androidx.window.embedding;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B1\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0007\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\r¨\u0006\u0019"}, d2={"Landroidx/window/embedding/EmbeddingAnimationParams;", "", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "openAnimation", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "closeAnimation", "changeAnimation", "<init>", "(Landroidx/window/embedding/EmbeddingAnimationBackground;Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;)V", "getAnimationBackground", "()Landroidx/window/embedding/EmbeddingAnimationBackground;", "getOpenAnimation", "()Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "getCloseAnimation", "getChangeAnimation", "hashCode", "", "equals", "", "other", "toString", "", "AnimationSpec", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingAnimationParams {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001A\u00020\tH\u0016J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "", "value", "", "<init>", "(I)V", "getValue$window_release", "()I", "toString", "", "equals", "", "other", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AnimationSpec {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00052\b\b\u0001\u0010\b\u001A\u00020\tH\u0001¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "JUMP_CUT", "getAnimationSpecFromValue", "value", "", "getAnimationSpecFromValue$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            @JvmStatic public final AnimationSpec getAnimationSpecFromValue$window_release(int arg3) {
                if(arg3 == AnimationSpec.DEFAULT.getValue$window_release()) {
                    return AnimationSpec.DEFAULT;
                }

                if(arg3 == AnimationSpec.JUMP_CUT.getValue$window_release()) {
                    return AnimationSpec.JUMP_CUT;
                }

                throw new IllegalArgumentException("Undefined value:" + arg3);
            }
        }

        public static final Companion Companion;
        public static final AnimationSpec DEFAULT;
        public static final AnimationSpec JUMP_CUT;
        private final int value;

        static {
            AnimationSpec.Companion = new Companion(null);
            AnimationSpec.DEFAULT = new AnimationSpec(0);
            AnimationSpec.JUMP_CUT = new AnimationSpec(1);
        }

        private AnimationSpec(int arg1) {
            super();
            this.value = arg1;
        }

        public boolean equals(Object arg4) {
            if((((AnimationSpec)arg4)) == this) {
                return 1;
            }

            if(!(arg4 instanceof AnimationSpec)) {
                return 0;
            }

            if(this.value == ((AnimationSpec)arg4).value) {
                return 1;
            }

            return 0;
        }

        @JvmStatic public static final AnimationSpec getAnimationSpecFromValue$window_release(int arg1) {
            return AnimationSpec.Companion.getAnimationSpecFromValue$window_release(arg1);
        }

        public final int getValue$window_release() {
            return this.value;
        }

        public int hashCode() {
            return this.value * 0x1F;
        }

        public String toString() {
            int v0 = this.value;
            if(v0 != 0) {
                if(v0 != 1) {
                    return "Unknown value: " + this.value;
                }

                return "JUMP_CUT";
            }

            return "DEFAULT";
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\u0005H\u0007J\u0010\u0010\f\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u0007H\u0007J\u0010\u0010\u000E\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u0007H\u0007J\u0010\u0010\u000F\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u0007H\u0007J\u0006\u0010\u0010\u001A\u00020\u0011R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/window/embedding/EmbeddingAnimationParams$Builder;", "", "<init>", "()V", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "openAnimation", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "closeAnimation", "changeAnimation", "setAnimationBackground", "background", "setOpenAnimation", "spec", "setCloseAnimation", "setChangeAnimation", "build", "Landroidx/window/embedding/EmbeddingAnimationParams;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private EmbeddingAnimationBackground animationBackground;
        private AnimationSpec changeAnimation;
        private AnimationSpec closeAnimation;
        private AnimationSpec openAnimation;

        public Builder() {
            super();
            this.animationBackground = EmbeddingAnimationBackground.DEFAULT;
            this.openAnimation = AnimationSpec.DEFAULT;
            this.closeAnimation = AnimationSpec.DEFAULT;
            this.changeAnimation = AnimationSpec.DEFAULT;
        }

        public final EmbeddingAnimationParams build() {
            return new EmbeddingAnimationParams(this.animationBackground, this.openAnimation, this.closeAnimation, this.changeAnimation, null);
        }

        public final Builder setAnimationBackground(EmbeddingAnimationBackground arg2) {
            Intrinsics.checkNotNullParameter(arg2, "background");
            this.animationBackground = arg2;
            return this;
        }

        public final Builder setChangeAnimation(AnimationSpec arg2) {
            Intrinsics.checkNotNullParameter(arg2, "spec");
            this.changeAnimation = arg2;
            return this;
        }

        public final Builder setCloseAnimation(AnimationSpec arg2) {
            Intrinsics.checkNotNullParameter(arg2, "spec");
            this.closeAnimation = arg2;
            return this;
        }

        public final Builder setOpenAnimation(AnimationSpec arg2) {
            Intrinsics.checkNotNullParameter(arg2, "spec");
            this.openAnimation = arg2;
            return this;
        }
    }

    private final EmbeddingAnimationBackground animationBackground;
    private final AnimationSpec changeAnimation;
    private final AnimationSpec closeAnimation;
    private final AnimationSpec openAnimation;

    private EmbeddingAnimationParams(EmbeddingAnimationBackground arg1, AnimationSpec arg2, AnimationSpec arg3, AnimationSpec arg4) {
        super();
        this.animationBackground = arg1;
        this.openAnimation = arg2;
        this.closeAnimation = arg3;
        this.changeAnimation = arg4;
    }

    EmbeddingAnimationParams(EmbeddingAnimationBackground arg1, AnimationSpec arg2, AnimationSpec arg3, AnimationSpec arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 1) != 0) {
            arg1 = EmbeddingAnimationBackground.DEFAULT;
        }

        if((arg5 & 2) != 0) {
            arg2 = AnimationSpec.DEFAULT;
        }

        if((arg5 & 4) != 0) {
            arg3 = AnimationSpec.DEFAULT;
        }

        if((arg5 & 8) != 0) {
            arg4 = AnimationSpec.DEFAULT;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public EmbeddingAnimationParams(EmbeddingAnimationBackground arg1, AnimationSpec arg2, AnimationSpec arg3, AnimationSpec arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((EmbeddingAnimationParams)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EmbeddingAnimationParams)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.animationBackground, ((EmbeddingAnimationParams)arg5).animationBackground)) && (Intrinsics.areEqual(this.openAnimation, ((EmbeddingAnimationParams)arg5).openAnimation)) && (Intrinsics.areEqual(this.closeAnimation, ((EmbeddingAnimationParams)arg5).closeAnimation)) && (Intrinsics.areEqual(this.changeAnimation, ((EmbeddingAnimationParams)arg5).changeAnimation))) {
            return 1;
        }

        return 0;
    }

    public final EmbeddingAnimationBackground getAnimationBackground() {
        return this.animationBackground;
    }

    public final AnimationSpec getChangeAnimation() {
        return this.changeAnimation;
    }

    public final AnimationSpec getCloseAnimation() {
        return this.closeAnimation;
    }

    public final AnimationSpec getOpenAnimation() {
        return this.openAnimation;
    }

    public int hashCode() {
        return ((this.animationBackground.hashCode() * 0x1F + this.openAnimation.hashCode()) * 0x1F + this.closeAnimation.hashCode()) * 0x1F + this.changeAnimation.hashCode();
    }

    public String toString() {
        return "EmbeddingAnimationParams:{animationBackground=" + this.animationBackground + ", openAnimation=" + this.openAnimation + ", closeAnimation=" + this.closeAnimation + ", changeAnimation=" + this.changeAnimation + " }";
    }
}

