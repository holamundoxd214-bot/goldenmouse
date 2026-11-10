package androidx.window.embedding;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature$Orientation;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0003%&\'B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u0015\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u0017H\u0000¢\u0006\u0002\b\u001AJ\f\u0010\u001B\u001A\u00020\u0013*\u00020\u0017H\u0002J\f\u0010\u001C\u001A\u00020\u0013*\u00020\u0017H\u0002J\u000E\u0010\u001D\u001A\u0004\u0018\u00010\u001E*\u00020\u0017H\u0002J\u001D\u0010\u001F\u001A\u00020\u00112\u0006\u0010 \u001A\u00020!2\u0006\u0010\u0016\u001A\u00020\u0017H\u0001¢\u0006\u0002\b\"J\u001D\u0010#\u001A\u00020\u00112\u0006\u0010 \u001A\u00020!2\u0006\u0010\u0016\u001A\u00020\u0017H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006("}, d2={"Landroidx/window/embedding/EmbeddingBounds;", "", "alignment", "Landroidx/window/embedding/EmbeddingBounds$Alignment;", "width", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "height", "<init>", "(Landroidx/window/embedding/EmbeddingBounds$Alignment;Landroidx/window/embedding/EmbeddingBounds$Dimension;Landroidx/window/embedding/EmbeddingBounds$Dimension;)V", "getAlignment", "()Landroidx/window/embedding/EmbeddingBounds$Alignment;", "getWidth", "()Landroidx/window/embedding/EmbeddingBounds$Dimension;", "getHeight", "toString", "", "hashCode", "", "equals", "", "other", "shouldUseFallbackDimensionForWidth", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "shouldUseFallbackDimensionForWidth$window_release", "shouldUseFallbackDimensionForHeight", "shouldUseFallbackDimensionForHeight$window_release", "isHorizontal", "isVertical", "getOnlyFoldingFeatureOrNull", "Landroidx/window/layout/FoldingFeature;", "getWidthInPixel", "parentContainerBounds", "Landroidx/window/core/Bounds;", "getWidthInPixel$window_release", "getHeightInPixel", "getHeightInPixel$window_release", "Alignment", "Dimension", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class EmbeddingBounds {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0013\b\u0000\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000F"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Alignment;", "", "value", "", "<init>", "(I)V", "getValue$window_release", "()I", "equals", "", "other", "hashCode", "toString", "", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Alignment {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Alignment$Companion;", "", "<init>", "()V", "ALIGN_LEFT", "Landroidx/window/embedding/EmbeddingBounds$Alignment;", "ALIGN_TOP", "ALIGN_RIGHT", "ALIGN_BOTTOM", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }
        }

        public static final Alignment ALIGN_BOTTOM;
        public static final Alignment ALIGN_LEFT;
        public static final Alignment ALIGN_RIGHT;
        public static final Alignment ALIGN_TOP;
        public static final Companion Companion;
        private final int value;

        static {
            Alignment.Companion = new Companion(null);
            Alignment.ALIGN_LEFT = new Alignment(0);
            Alignment.ALIGN_TOP = new Alignment(1);
            Alignment.ALIGN_RIGHT = new Alignment(2);
            Alignment.ALIGN_BOTTOM = new Alignment(3);
        }

        public Alignment(int arg1) {
            super();
            this.value = arg1;
            if(arg1 >= 0 && arg1 < 4) {
                return;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public boolean equals(Object arg4) {
            if(this == (((Alignment)arg4))) {
                return 1;
            }

            if(!(arg4 instanceof Alignment)) {
                return 0;
            }

            if(this.value == ((Alignment)arg4).value) {
                return 1;
            }

            return 0;
        }

        public final int getValue$window_release() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }

        public String toString() {
            int v0 = this.value;
            if(v0 != 0) {
                if(v0 != 1) {
                    if(v0 != 2) {
                        if(v0 != 3) {
                            return "unknown position:" + this.value;
                        }

                        return "bottom";
                    }

                    return "right";
                }

                return "top";
            }

            return "left";
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000FH\u0001¢\u0006\u0002\b\u0010J\u001C\u0010\u0011\u001A\u00020\u000B*\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0013H\u0002J\u001D\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0016H\u0000¢\u0006\u0002\b\u0010R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Companion;", "", "<init>", "()V", "BOUNDS_EXPANDED", "Landroidx/window/embedding/EmbeddingBounds;", "BOUNDS_HINGE_TOP", "BOUNDS_HINGE_LEFT", "BOUNDS_HINGE_BOTTOM", "BOUNDS_HINGE_RIGHT", "translateEmbeddingBounds", "Landroidx/window/core/Bounds;", "embeddingBounds", "parentContainerBounds", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "translateEmbeddingBounds$window_release", "offset", "dx", "", "dy", "parentContainerInfo", "Landroidx/window/embedding/ParentContainerInfo;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.EmbeddingBounds$Companion {
        public androidx.window.embedding.EmbeddingBounds$Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private androidx.window.embedding.EmbeddingBounds$Companion() {
            super();
        }

        private final Bounds offset(Bounds arg4, int arg5, int arg6) {
            return new Bounds(arg4.getLeft() + arg5, arg4.getTop() + arg6, arg4.getRight() + arg5, arg4.getBottom() + arg6);
        }

        public final Bounds translateEmbeddingBounds$window_release(EmbeddingBounds arg6, Bounds arg7, WindowLayoutInfo arg8) {
            Intrinsics.checkNotNullParameter(arg6, "embeddingBounds");
            Intrinsics.checkNotNullParameter(arg7, "parentContainerBounds");
            Intrinsics.checkNotNullParameter(arg8, "windowLayoutInfo");
            if((Intrinsics.areEqual(arg6.getWidth(), Dimension.DIMENSION_EXPANDED)) && (Intrinsics.areEqual(arg6.getHeight(), Dimension.DIMENSION_EXPANDED))) {
                return Bounds.Companion.getEMPTY_BOUNDS();
            }

            float v0 = 0.5f;
            Dimension v5 = arg6.shouldUseFallbackDimensionForWidth$window_release(arg8) ? Dimension.Companion.ratio(v0) : arg6.getWidth();
            Dimension v0_1 = arg6.shouldUseFallbackDimensionForHeight$window_release(arg8) ? Dimension.Companion.ratio(v0) : arg6.getHeight();
            EmbeddingBounds v1 = new EmbeddingBounds(arg6.getAlignment(), v5, v0_1);
            int v5_1 = v1.getWidthInPixel$window_release(arg7, arg8);
            int v8 = v1.getHeightInPixel$window_release(arg7, arg8);
            int v0_2 = arg7.getWidth();
            int v7 = arg7.getHeight();
            if(v5_1 == v0_2 && v8 == v7) {
                return Bounds.Companion.getEMPTY_BOUNDS();
            }

            Bounds v1_1 = new Bounds(0, 0, v5_1, v8);
            Alignment v3 = arg6.getAlignment();
            if(Intrinsics.areEqual(v3, Alignment.ALIGN_TOP)) {
                return EmbeddingBounds.Companion.offset(v1_1, (v0_2 - v5_1) / 2, 0);
            }

            if(Intrinsics.areEqual(v3, Alignment.ALIGN_LEFT)) {
                return EmbeddingBounds.Companion.offset(v1_1, 0, (v7 - v8) / 2);
            }

            if(Intrinsics.areEqual(v3, Alignment.ALIGN_BOTTOM)) {
                return EmbeddingBounds.Companion.offset(v1_1, (v0_2 - v5_1) / 2, v7 - v8);
            }

            if(Intrinsics.areEqual(v3, Alignment.ALIGN_RIGHT)) {
                return EmbeddingBounds.Companion.offset(v1_1, v0_2 - v5_1, (v7 - v8) / 2);
            }

            throw new IllegalArgumentException("Unknown alignment: " + arg6.getAlignment());
        }

        public final Bounds translateEmbeddingBounds$window_release(EmbeddingBounds arg2, ParentContainerInfo arg3) {
            Intrinsics.checkNotNullParameter(arg2, "embeddingBounds");
            Intrinsics.checkNotNullParameter(arg3, "parentContainerInfo");
            return this.translateEmbeddingBounds$window_release(arg2, arg3.getWindowBounds(), arg3.getWindowLayoutInfo());
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000 \u00102\u00020\u0001:\u0003\u000E\u000F\u0010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\u0003H\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Dimension;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "getDescription$window_release", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Pixel", "Ratio", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class Dimension {
        @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001A\u00020\u00052\b\b\u0001\u0010\b\u001A\u00020\tH\u0007J\u0012\u0010\n\u001A\u00020\u00052\b\b\u0001\u0010\n\u001A\u00020\u000BH\u0007R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Dimension$Companion;", "", "<init>", "()V", "DIMENSION_EXPANDED", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "DIMENSION_HINGE", "pixel", "value", "", "ratio", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.window.embedding.EmbeddingBounds$Dimension$Companion {
            public androidx.window.embedding.EmbeddingBounds$Dimension$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.window.embedding.EmbeddingBounds$Dimension$Companion() {
                super();
            }

            @JvmStatic public final Dimension pixel(int arg1) {
                return new Pixel(arg1);
            }

            @JvmStatic public final Dimension ratio(float arg1) {
                return new Ratio(arg1);
            }
        }

        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0003H\u0080\u0002¢\u0006\u0002\b\nR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u000B"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Dimension$Pixel;", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "value", "", "<init>", "(I)V", "getValue$window_release", "()I", "compareTo", "dimen", "compareTo$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Pixel extends Dimension {
            private final int value;

            public Pixel(int arg3) {
                super("dimension in pixel:" + arg3);
                this.value = arg3;
                if(arg3 >= 1) {
                    return;
                }

                throw new IllegalArgumentException("Pixel value must be a positive integer.".toString());
            }

            public final int compareTo$window_release(int arg1) {
                return this.value - arg1;
            }

            public final int getValue$window_release() {
                return this.value;
            }
        }

        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0080\u0002¢\u0006\u0002\b\u000BR\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Landroidx/window/embedding/EmbeddingBounds$Dimension$Ratio;", "Landroidx/window/embedding/EmbeddingBounds$Dimension;", "value", "", "<init>", "(F)V", "getValue$window_release", "()F", "times", "", "dimen", "times$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Ratio extends Dimension {
            private final float value;

            public Ratio(float arg5) {
                super("dimension in ratio:" + arg5);
                this.value = arg5;
                if((((double)arg5)) > 0 && (((double)arg5)) <= 1) {
                    return;
                }

                throw new IllegalArgumentException("Ratio must be in range (0.0, 1.0]".toString());
            }

            public final float getValue$window_release() {
                return this.value;
            }

            public final int times$window_release(int arg1) {
                return ((int)(this.value * (((float)arg1))));
            }
        }

        public static final androidx.window.embedding.EmbeddingBounds$Dimension$Companion Companion;
        public static final Dimension DIMENSION_EXPANDED;
        public static final Dimension DIMENSION_HINGE;
        private final String description;

        static {
            Dimension.Companion = new androidx.window.embedding.EmbeddingBounds$Dimension$Companion(null);
            Dimension.DIMENSION_EXPANDED = new Ratio(1f);
            Dimension.DIMENSION_HINGE = new EmbeddingBounds$Dimension$Companion$DIMENSION_HINGE$1();
        }

        public Dimension(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "description");
            super();
            this.description = arg2;
        }

        public boolean equals(Object arg2) {
            if(this == (((Dimension)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof Dimension)) {
                return 0;
            }

            return Intrinsics.areEqual(this.description, ((Dimension)arg2).description);
        }

        public final String getDescription$window_release() {
            return this.description;
        }

        public int hashCode() {
            return this.description.hashCode();
        }

        @JvmStatic public static final Dimension pixel(int arg1) {
            return Dimension.Companion.pixel(arg1);
        }

        @JvmStatic public static final Dimension ratio(float arg1) {
            return Dimension.Companion.ratio(arg1);
        }

        public String toString() {
            return this.description;
        }
    }

    public static final EmbeddingBounds BOUNDS_EXPANDED;
    public static final EmbeddingBounds BOUNDS_HINGE_BOTTOM;
    public static final EmbeddingBounds BOUNDS_HINGE_LEFT;
    public static final EmbeddingBounds BOUNDS_HINGE_RIGHT;
    public static final EmbeddingBounds BOUNDS_HINGE_TOP;
    public static final androidx.window.embedding.EmbeddingBounds$Companion Companion;
    private final Alignment alignment;
    private final Dimension height;
    private final Dimension width;

    static {
        EmbeddingBounds.Companion = new androidx.window.embedding.EmbeddingBounds$Companion(null);
        EmbeddingBounds.BOUNDS_EXPANDED = new EmbeddingBounds(Alignment.ALIGN_TOP, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_EXPANDED);
        EmbeddingBounds.BOUNDS_HINGE_TOP = new EmbeddingBounds(Alignment.ALIGN_TOP, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_HINGE);
        EmbeddingBounds.BOUNDS_HINGE_LEFT = new EmbeddingBounds(Alignment.ALIGN_LEFT, Dimension.DIMENSION_HINGE, Dimension.DIMENSION_EXPANDED);
        EmbeddingBounds.BOUNDS_HINGE_BOTTOM = new EmbeddingBounds(Alignment.ALIGN_BOTTOM, Dimension.DIMENSION_EXPANDED, Dimension.DIMENSION_HINGE);
        EmbeddingBounds.BOUNDS_HINGE_RIGHT = new EmbeddingBounds(Alignment.ALIGN_RIGHT, Dimension.DIMENSION_HINGE, Dimension.DIMENSION_EXPANDED);
    }

    public EmbeddingBounds(Alignment arg2, Dimension arg3, Dimension arg4) {
        Intrinsics.checkNotNullParameter(arg2, "alignment");
        Intrinsics.checkNotNullParameter(arg3, "width");
        Intrinsics.checkNotNullParameter(arg4, "height");
        super();
        this.alignment = arg2;
        this.width = arg3;
        this.height = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((EmbeddingBounds)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof EmbeddingBounds)) {
            return 0;
        }

        if((Intrinsics.areEqual(this.alignment, ((EmbeddingBounds)arg5).alignment)) && (Intrinsics.areEqual(this.width, ((EmbeddingBounds)arg5).width)) && (Intrinsics.areEqual(this.height, ((EmbeddingBounds)arg5).height))) {
            return 1;
        }

        return 0;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final Dimension getHeight() {
        return this.height;
    }

    public final int getHeightInPixel$window_release(Bounds arg4, WindowLayoutInfo arg5) {
        Intrinsics.checkNotNullParameter(arg4, "parentContainerBounds");
        Intrinsics.checkNotNullParameter(arg5, "windowLayoutInfo");
        int v0 = arg4.getHeight();
        Dimension v1 = this.shouldUseFallbackDimensionForHeight$window_release(arg5) ? Dimension.Companion.ratio(0.5f) : this.height;
        if((v1 instanceof Ratio)) {
            return ((Ratio)v1).times$window_release(v0);
        }

        if((v1 instanceof Pixel)) {
            return Math.min(v0, ((Pixel)v1).getValue$window_release());
        }

        if(Intrinsics.areEqual(v1, Dimension.DIMENSION_HINGE)) {
            FoldingFeature v0_1 = this.getOnlyFoldingFeatureOrNull(arg5);
            Intrinsics.checkNotNull(v0_1);
            Rect v0_2 = v0_1.getBounds();
            Alignment v1_1 = this.alignment;
            if(Intrinsics.areEqual(v1_1, Alignment.ALIGN_TOP)) {
                return v0_2.top - arg4.getTop();
            }

            if(Intrinsics.areEqual(v1_1, Alignment.ALIGN_BOTTOM)) {
                return arg4.getBottom() - v0_2.bottom;
            }

            throw new IllegalStateException("Unhandled condition to get height in pixel! embeddingBounds=" + this + " taskBounds=" + arg4 + " windowLayoutInfo=" + arg5);
        }

        throw new IllegalArgumentException("Unhandled width dimension=" + this.width);
    }

    private final FoldingFeature getOnlyFoldingFeatureOrNull(WindowLayoutInfo arg3) {
        List v2 = arg3.getDisplayFeatures();
        ArrayList v3 = new ArrayList();
        Iterator v2_1 = ((Iterable)v2).iterator();
        while(v2_1.hasNext()) {
            Object v0 = v2_1.next();
            if(!(v0 instanceof FoldingFeature)) {
                continue;
            }

            ((Collection)v3).add(v0);
        }

        if(((List)v3).size() == 1) {
            return ((List)v3).get(0);
        }

        return null;
    }

    public final Dimension getWidth() {
        return this.width;
    }

    public final int getWidthInPixel$window_release(Bounds arg4, WindowLayoutInfo arg5) {
        Intrinsics.checkNotNullParameter(arg4, "parentContainerBounds");
        Intrinsics.checkNotNullParameter(arg5, "windowLayoutInfo");
        int v0 = arg4.getWidth();
        Dimension v1 = this.shouldUseFallbackDimensionForWidth$window_release(arg5) ? Dimension.Companion.ratio(0.5f) : this.width;
        if((v1 instanceof Ratio)) {
            return ((Ratio)v1).times$window_release(v0);
        }

        if((v1 instanceof Pixel)) {
            return Math.min(v0, ((Pixel)v1).getValue$window_release());
        }

        if(Intrinsics.areEqual(v1, Dimension.DIMENSION_HINGE)) {
            FoldingFeature v0_1 = this.getOnlyFoldingFeatureOrNull(arg5);
            Intrinsics.checkNotNull(v0_1);
            Rect v0_2 = v0_1.getBounds();
            Alignment v1_1 = this.alignment;
            if(Intrinsics.areEqual(v1_1, Alignment.ALIGN_LEFT)) {
                return v0_2.left - arg4.getLeft();
            }

            if(Intrinsics.areEqual(v1_1, Alignment.ALIGN_RIGHT)) {
                return arg4.getRight() - v0_2.right;
            }

            throw new IllegalStateException("Unhandled condition to get height in pixel! embeddingBounds=" + this + " taskBounds=" + arg4 + " windowLayoutInfo=" + arg5);
        }

        throw new IllegalArgumentException("Unhandled width dimension=" + this.width);
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 0x1F + this.width.hashCode()) * 0x1F + this.height.hashCode();
    }

    private final boolean isHorizontal(WindowLayoutInfo arg1) {
        FoldingFeature v0 = this.getOnlyFoldingFeatureOrNull(arg1);
        if(v0 == null) {
            return 0;
        }

        return Intrinsics.areEqual(v0.getOrientation(), Orientation.HORIZONTAL);
    }

    private final boolean isVertical(WindowLayoutInfo arg1) {
        FoldingFeature v0 = this.getOnlyFoldingFeatureOrNull(arg1);
        if(v0 == null) {
            return 0;
        }

        return Intrinsics.areEqual(v0.getOrientation(), Orientation.VERTICAL);
    }

    public final boolean shouldUseFallbackDimensionForHeight$window_release(WindowLayoutInfo arg4) {
        Intrinsics.checkNotNullParameter(arg4, "windowLayoutInfo");
        if(!Intrinsics.areEqual(this.height, Dimension.DIMENSION_HINGE)) {
            return 0;
        }

        if(this.isHorizontal(arg4)) {
            if(CollectionsKt.listOf(new Alignment[]{Alignment.ALIGN_LEFT, Alignment.ALIGN_RIGHT}).contains(this.alignment)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public final boolean shouldUseFallbackDimensionForWidth$window_release(WindowLayoutInfo arg4) {
        Intrinsics.checkNotNullParameter(arg4, "windowLayoutInfo");
        if(!Intrinsics.areEqual(this.width, Dimension.DIMENSION_HINGE)) {
            return 0;
        }

        if(this.isVertical(arg4)) {
            if(CollectionsKt.listOf(new Alignment[]{Alignment.ALIGN_TOP, Alignment.ALIGN_BOTTOM}).contains(this.alignment)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public String toString() {
        return "Bounds:{alignment=" + this.alignment + ", width=" + this.width + ", height=" + this.height + '}';
    }
}

