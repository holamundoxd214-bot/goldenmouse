package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0010\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u000F\u0010\u0011\u0012\u0013\u0014B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0010\u0015\u0016\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F !\"#$¨\u0006%"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty;", "T", "", "<init>", "()V", "Rotation", "PivotX", "PivotY", "ScaleX", "ScaleY", "TranslateX", "TranslateY", "PathData", "Fill", "FillAlpha", "Stroke", "StrokeLineWidth", "StrokeAlpha", "TrimPathStart", "TrimPathEnd", "TrimPathOffset", "Landroidx/compose/ui/graphics/vector/VectorProperty$Fill;", "Landroidx/compose/ui/graphics/vector/VectorProperty$FillAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PathData;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PivotX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$PivotY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$Rotation;", "Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$Stroke;", "Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeLineWidth;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateX;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateY;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathEnd;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathOffset;", "Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathStart;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class VectorProperty {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$Fill;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "Landroidx/compose/ui/graphics/Brush;", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Fill extends VectorProperty {
        public static final int $stable;
        public static final Fill INSTANCE;

        static {
            Fill.INSTANCE = new Fill();
        }

        private Fill() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$FillAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class FillAlpha extends VectorProperty {
        public static final int $stable;
        public static final FillAlpha INSTANCE;

        static {
            FillAlpha.INSTANCE = new FillAlpha();
        }

        private FillAlpha() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$PathData;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathData extends VectorProperty {
        public static final int $stable;
        public static final PathData INSTANCE;

        static {
            PathData.INSTANCE = new PathData();
        }

        private PathData() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$PivotX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PivotX extends VectorProperty {
        public static final int $stable;
        public static final PivotX INSTANCE;

        static {
            PivotX.INSTANCE = new PivotX();
        }

        private PivotX() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$PivotY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PivotY extends VectorProperty {
        public static final int $stable;
        public static final PivotY INSTANCE;

        static {
            PivotY.INSTANCE = new PivotY();
        }

        private PivotY() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$Rotation;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Rotation extends VectorProperty {
        public static final int $stable;
        public static final Rotation INSTANCE;

        static {
            Rotation.INSTANCE = new Rotation();
        }

        private Rotation() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScaleX extends VectorProperty {
        public static final int $stable;
        public static final ScaleX INSTANCE;

        static {
            ScaleX.INSTANCE = new ScaleX();
        }

        private ScaleX() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$ScaleY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ScaleY extends VectorProperty {
        public static final int $stable;
        public static final ScaleY INSTANCE;

        static {
            ScaleY.INSTANCE = new ScaleY();
        }

        private ScaleY() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$Stroke;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "Landroidx/compose/ui/graphics/Brush;", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Stroke extends VectorProperty {
        public static final int $stable;
        public static final Stroke INSTANCE;

        static {
            Stroke.INSTANCE = new Stroke();
        }

        private Stroke() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeAlpha;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StrokeAlpha extends VectorProperty {
        public static final int $stable;
        public static final StrokeAlpha INSTANCE;

        static {
            StrokeAlpha.INSTANCE = new StrokeAlpha();
        }

        private StrokeAlpha() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$StrokeLineWidth;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class StrokeLineWidth extends VectorProperty {
        public static final int $stable;
        public static final StrokeLineWidth INSTANCE;

        static {
            StrokeLineWidth.INSTANCE = new StrokeLineWidth();
        }

        private StrokeLineWidth() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateX;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TranslateX extends VectorProperty {
        public static final int $stable;
        public static final TranslateX INSTANCE;

        static {
            TranslateX.INSTANCE = new TranslateX();
        }

        private TranslateX() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$TranslateY;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TranslateY extends VectorProperty {
        public static final int $stable;
        public static final TranslateY INSTANCE;

        static {
            TranslateY.INSTANCE = new TranslateY();
        }

        private TranslateY() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathEnd;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TrimPathEnd extends VectorProperty {
        public static final int $stable;
        public static final TrimPathEnd INSTANCE;

        static {
            TrimPathEnd.INSTANCE = new TrimPathEnd();
        }

        private TrimPathEnd() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathOffset;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TrimPathOffset extends VectorProperty {
        public static final int $stable;
        public static final TrimPathOffset INSTANCE;

        static {
            TrimPathOffset.INSTANCE = new TrimPathOffset();
        }

        private TrimPathOffset() {
            super(null);
        }
    }

    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Landroidx/compose/ui/graphics/vector/VectorProperty$TrimPathStart;", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "", "<init>", "()V", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class TrimPathStart extends VectorProperty {
        public static final int $stable;
        public static final TrimPathStart INSTANCE;

        static {
            TrimPathStart.INSTANCE = new TrimPathStart();
        }

        private TrimPathStart() {
            super(null);
        }
    }

    public static final int $stable;

    static {
    }

    private VectorProperty() {
        super();
    }

    public VectorProperty(DefaultConstructorMarker arg1) {
        this();
    }
}

