package androidx.window.embedding;

import androidx.window.core.SpecificationComputer;
import androidx.window.core.VerificationMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u0000 \u001D2\u00020\u0001:\u0004\u001B\u001C\u001D\u001EB1\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\b\u0010\u0014\u001A\u00020\u0015H\u0016J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001A\u00020\u001AH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001F"}, d2={"Landroidx/window/embedding/SplitAttributes;", "", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "<init>", "(Landroidx/window/embedding/SplitAttributes$SplitType;Landroidx/window/embedding/SplitAttributes$LayoutDirection;Landroidx/window/embedding/EmbeddingAnimationParams;Landroidx/window/embedding/DividerAttributes;)V", "getSplitType", "()Landroidx/window/embedding/SplitAttributes$SplitType;", "getLayoutDirection", "()Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "getAnimationParams", "()Landroidx/window/embedding/EmbeddingAnimationParams;", "getDividerAttributes", "()Landroidx/window/embedding/DividerAttributes;", "hashCode", "", "equals", "", "other", "toString", "", "SplitType", "LayoutDirection", "Companion", "Builder", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitAttributes {
    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000E\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\bJ\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\nJ\u0010\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\fH\u0007J\u0010\u0010\u0014\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u000EH\u0007J\u0006\u0010\u0015\u001A\u00020\u0005R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Landroidx/window/embedding/SplitAttributes$Builder;", "", "<init>", "()V", "original", "Landroidx/window/embedding/SplitAttributes;", "(Landroidx/window/embedding/SplitAttributes;)V", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "layoutDirection", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "animationParams", "Landroidx/window/embedding/EmbeddingAnimationParams;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "setSplitType", "type", "setLayoutDirection", "setAnimationParams", "params", "setDividerAttributes", "build", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private EmbeddingAnimationParams animationParams;
        private DividerAttributes dividerAttributes;
        private LayoutDirection layoutDirection;
        private SplitType splitType;

        public Builder() {
            super();
            this.splitType = SplitType.SPLIT_TYPE_EQUAL;
            this.layoutDirection = LayoutDirection.LOCALE;
            this.animationParams = new androidx.window.embedding.EmbeddingAnimationParams$Builder().build();
            this.dividerAttributes = DividerAttributes.NO_DIVIDER;
        }

        public Builder(SplitAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "original");
            this();
            this.setSplitType(arg2.getSplitType()).setLayoutDirection(arg2.getLayoutDirection()).setAnimationParams(arg2.getAnimationParams()).setDividerAttributes(arg2.getDividerAttributes());
        }

        public final SplitAttributes build() {
            return new SplitAttributes(this.splitType, this.layoutDirection, this.animationParams, this.dividerAttributes, null);
        }

        public final Builder setAnimationParams(EmbeddingAnimationParams arg2) {
            Intrinsics.checkNotNullParameter(arg2, "params");
            this.animationParams = arg2;
            return this;
        }

        public final Builder setDividerAttributes(DividerAttributes arg2) {
            Intrinsics.checkNotNullParameter(arg2, "dividerAttributes");
            this.dividerAttributes = arg2;
            return this;
        }

        public final Builder setLayoutDirection(LayoutDirection arg2) {
            Intrinsics.checkNotNullParameter(arg2, "layoutDirection");
            this.layoutDirection = arg2;
            return this;
        }

        public final Builder setSplitType(SplitType arg2) {
            Intrinsics.checkNotNullParameter(arg2, "type");
            this.splitType = arg2;
            return this;
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001A\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/window/embedding/SplitAttributes$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001A\u00020\u0003H\u0016J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000E\u001A\u00020\u0005H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u0010"}, d2={"Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;I)V", "getValue$window_release", "()I", "toString", "equals", "", "other", "hashCode", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutDirection {
        @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\n\u001A\u00020\u00052\b\b\u0001\u0010\u000B\u001A\u00020\fH\u0001¢\u0006\u0002\b\rR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Landroidx/window/embedding/SplitAttributes$LayoutDirection$Companion;", "", "<init>", "()V", "LOCALE", "Landroidx/window/embedding/SplitAttributes$LayoutDirection;", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "TOP_TO_BOTTOM", "BOTTOM_TO_TOP", "getLayoutDirectionFromValue", "value", "", "getLayoutDirectionFromValue$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.SplitAttributes$LayoutDirection$Companion {
            public androidx.window.embedding.SplitAttributes$LayoutDirection$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.SplitAttributes$LayoutDirection$Companion() {
                super();
            }

            @JvmStatic public final LayoutDirection getLayoutDirectionFromValue$window_release(int arg3) {
                if(arg3 == LayoutDirection.LEFT_TO_RIGHT.getValue$window_release()) {
                    return LayoutDirection.LEFT_TO_RIGHT;
                }

                if(arg3 == LayoutDirection.RIGHT_TO_LEFT.getValue$window_release()) {
                    return LayoutDirection.RIGHT_TO_LEFT;
                }

                if(arg3 == LayoutDirection.LOCALE.getValue$window_release()) {
                    return LayoutDirection.LOCALE;
                }

                if(arg3 == LayoutDirection.TOP_TO_BOTTOM.getValue$window_release()) {
                    return LayoutDirection.TOP_TO_BOTTOM;
                }

                if(arg3 == LayoutDirection.BOTTOM_TO_TOP.getValue$window_release()) {
                    return LayoutDirection.BOTTOM_TO_TOP;
                }

                throw new IllegalArgumentException("Undefined value:" + arg3);
            }
        }

        public static final LayoutDirection BOTTOM_TO_TOP;
        public static final androidx.window.embedding.SplitAttributes$LayoutDirection$Companion Companion;
        public static final LayoutDirection LEFT_TO_RIGHT;
        public static final LayoutDirection LOCALE;
        public static final LayoutDirection RIGHT_TO_LEFT;
        public static final LayoutDirection TOP_TO_BOTTOM;
        private final String description;
        private final int value;

        static {
            LayoutDirection.Companion = new androidx.window.embedding.SplitAttributes$LayoutDirection$Companion(null);
            LayoutDirection.LOCALE = new LayoutDirection("LOCALE", 0);
            LayoutDirection.LEFT_TO_RIGHT = new LayoutDirection("LEFT_TO_RIGHT", 1);
            LayoutDirection.RIGHT_TO_LEFT = new LayoutDirection("RIGHT_TO_LEFT", 2);
            LayoutDirection.TOP_TO_BOTTOM = new LayoutDirection("TOP_TO_BOTTOM", 3);
            LayoutDirection.BOTTOM_TO_TOP = new LayoutDirection("BOTTOM_TO_TOP", 4);
        }

        private LayoutDirection(String arg1, int arg2) {
            super();
            this.description = arg1;
            this.value = arg2;
        }

        public boolean equals(Object arg5) {
            if((((LayoutDirection)arg5)) == this) {
                return 1;
            }

            if(!(arg5 instanceof LayoutDirection)) {
                return 0;
            }

            if((Intrinsics.areEqual(this.description, ((LayoutDirection)arg5).description)) && this.value == ((LayoutDirection)arg5).value) {
                return 1;
            }

            return 0;
        }

        @JvmStatic public static final LayoutDirection getLayoutDirectionFromValue$window_release(int arg1) {
            return LayoutDirection.Companion.getLayoutDirectionFromValue$window_release(arg1);
        }

        public final int getValue$window_release() {
            return this.value;
        }

        public int hashCode() {
            return this.description.hashCode() * 0x1F + this.value;
        }

        public String toString() {
            return this.description;
        }
    }

    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001A\u00020\u0003H\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001A\u00020\u0011H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0013"}, d2={"Landroidx/window/embedding/SplitAttributes$SplitType;", "", "description", "", "value", "", "<init>", "(Ljava/lang/String;F)V", "getDescription$window_release", "()Ljava/lang/String;", "getValue$window_release", "()F", "toString", "equals", "", "other", "hashCode", "", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SplitType {
        @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\b\b\u0001\u0010\u0004\u001A\u00020\u0006H\u0007J\u0017\u0010\n\u001A\u00020\u00052\b\b\u0001\u0010\u000B\u001A\u00020\u0006H\u0001¢\u0006\u0002\b\fR\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Landroidx/window/embedding/SplitAttributes$SplitType$Companion;", "", "<init>", "()V", "ratio", "Landroidx/window/embedding/SplitAttributes$SplitType;", "", "SPLIT_TYPE_EXPAND", "SPLIT_TYPE_EQUAL", "SPLIT_TYPE_HINGE", "buildSplitTypeFromValue", "value", "buildSplitTypeFromValue$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.SplitAttributes$SplitType$Companion {
            public androidx.window.embedding.SplitAttributes$SplitType$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.SplitAttributes$SplitType$Companion() {
                super();
            }

            public final SplitType buildSplitTypeFromValue$window_release(float arg2) {
                if(arg2 == SplitType.SPLIT_TYPE_EXPAND.getValue$window_release()) {
                    return SplitType.SPLIT_TYPE_EXPAND;
                }

                return this.ratio(arg2);
            }

            @JvmStatic public final SplitType ratio(float arg8) {
                androidx.window.core.SpecificationComputer$Companion v0 = SpecificationComputer.Companion;
                Float v1 = Float.valueOf(arg8);
                String v2 = SplitAttributes.TAG;
                Intrinsics.checkNotNullExpressionValue(v2, "access$getTAG$cp(...)");
                Object v7 = androidx.window.core.SpecificationComputer$Companion.startSpecification$default(v0, v1, v2, VerificationMode.STRICT, null, 4, null).require("Ratio must be in range (0.0, 1.0). Use SplitType.expandContainers() instead of 0 or 1.", new SplitAttributes$SplitType$Companion$$ExternalSyntheticLambda0(arg8)).compute();
                Intrinsics.checkNotNull(v7);
                float v7_1 = ((Number)v7).floatValue();
                return new SplitType("ratio:" + v7_1, v7_1);
            }

            static final boolean ratio$lambda$0(float arg5, float arg6) {
                double v0 = ((double)arg5);
                if(Double.compare(0, v0) <= 0 && v0 <= 1 && !ArraysKt.contains(new Float[]{Float.valueOf(0f), Float.valueOf(1f)}, Float.valueOf(arg5))) {
                    return 1;
                }

                return 0;
            }
        }

        public static final androidx.window.embedding.SplitAttributes$SplitType$Companion Companion;
        public static final SplitType SPLIT_TYPE_EQUAL;
        public static final SplitType SPLIT_TYPE_EXPAND;
        public static final SplitType SPLIT_TYPE_HINGE;
        private final String description;
        private final float value;

        static {
            androidx.window.embedding.SplitAttributes$SplitType$Companion v0 = new androidx.window.embedding.SplitAttributes$SplitType$Companion(null);
            SplitType.Companion = v0;
            SplitType.SPLIT_TYPE_EXPAND = new SplitType("expandContainers", 0f);
            SplitType.SPLIT_TYPE_EQUAL = v0.ratio(0.5f);
            SplitType.SPLIT_TYPE_HINGE = new SplitType("hinge", -1f);
        }

        public SplitType(String arg2, float arg3) {
            Intrinsics.checkNotNullParameter(arg2, "description");
            super();
            this.description = arg2;
            this.value = arg3;
        }

        public boolean equals(Object arg5) {
            if((((SplitType)arg5)) == this) {
                return 1;
            }

            if(!(arg5 instanceof SplitType)) {
                return 0;
            }

            if(this.value == ((SplitType)arg5).value && (Intrinsics.areEqual(this.description, ((SplitType)arg5).description))) {
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

        @JvmStatic public static final SplitType ratio(float arg1) {
            return SplitType.Companion.ratio(arg1);
        }

        public String toString() {
            return this.description;
        }
    }

    public static final Companion Companion;
    private static final String TAG;
    private final EmbeddingAnimationParams animationParams;
    private final DividerAttributes dividerAttributes;
    private final LayoutDirection layoutDirection;
    private final SplitType splitType;

    static {
        SplitAttributes.Companion = new Companion(null);
        SplitAttributes.TAG = "SplitAttributes";
    }

    private SplitAttributes(SplitType arg1, LayoutDirection arg2, EmbeddingAnimationParams arg3, DividerAttributes arg4) {
        super();
        this.splitType = arg1;
        this.layoutDirection = arg2;
        this.animationParams = arg3;
        this.dividerAttributes = arg4;
    }

    SplitAttributes(SplitType arg1, LayoutDirection arg2, EmbeddingAnimationParams arg3, DividerAttributes arg4, int arg5, DefaultConstructorMarker arg6) {
        if((arg5 & 1) != 0) {
            arg1 = SplitType.SPLIT_TYPE_EQUAL;
        }

        if((arg5 & 2) != 0) {
            arg2 = LayoutDirection.LOCALE;
        }

        if((arg5 & 4) != 0) {
            arg3 = new androidx.window.embedding.EmbeddingAnimationParams$Builder().build();
        }

        if((arg5 & 8) != 0) {
            arg4 = DividerAttributes.NO_DIVIDER;
        }

        this(arg1, arg2, arg3, arg4);
    }

    public SplitAttributes(SplitType arg1, LayoutDirection arg2, EmbeddingAnimationParams arg3, DividerAttributes arg4, DefaultConstructorMarker arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    public static final String access$getTAG$cp() {
        return SplitAttributes.TAG;
    }

    public boolean equals(Object arg5) {
        if(this == (((SplitAttributes)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SplitAttributes)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.splitType, ((SplitAttributes)arg5).splitType)) && (Intrinsics.areEqual(this.layoutDirection, ((SplitAttributes)arg5).layoutDirection)) && (Intrinsics.areEqual(this.animationParams, ((SplitAttributes)arg5).animationParams)) && (Intrinsics.areEqual(this.dividerAttributes, ((SplitAttributes)arg5).dividerAttributes))) {
            return 1;
        }

        return 0;
    }

    public final EmbeddingAnimationParams getAnimationParams() {
        return this.animationParams;
    }

    public final DividerAttributes getDividerAttributes() {
        return this.dividerAttributes;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final SplitType getSplitType() {
        return this.splitType;
    }

    public int hashCode() {
        return ((this.splitType.hashCode() * 0x1F + this.layoutDirection.hashCode()) * 0x1F + this.animationParams.hashCode()) * 0x1F + this.dividerAttributes.hashCode();
    }

    public String toString() {
        return "SplitAttributes:{splitType=" + this.splitType + ", layoutDir=" + this.layoutDirection + ", animationParams=" + this.animationParams + ", dividerAttributes=" + this.dividerAttributes + " }";
    }
}

