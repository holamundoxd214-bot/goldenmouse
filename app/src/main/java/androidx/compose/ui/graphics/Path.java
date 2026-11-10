package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 _2\u00020\u0001:\u0002^_J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH&J\u0018\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u000FH&J\u0018\u0010\u0014\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000FH&J\u0018\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u000FH&J(\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u000FH\'J(\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u000FH\u0016J(\u0010\u001C\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001F\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020\u000FH\'J(\u0010!\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001F\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020\u000FH\u0016J8\u0010\"\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u000F2\u0006\u0010\u0019\u001A\u00020\u000F2\u0006\u0010\u001A\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\u000F2\u0006\u0010$\u001A\u00020\u000FH&J8\u0010%\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001E\u001A\u00020\u000F2\u0006\u0010\u001F\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\u000F2\u0006\u0010\'\u001A\u00020\u000FH&J(\u0010(\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u000F2\u0006\u0010,\u001A\u00020\u000F2\u0006\u0010-\u001A\u00020\tH\u0016J(\u0010.\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\u0006\u0010/\u001A\u00020\u000F2\u0006\u00100\u001A\u00020\u000F2\u0006\u0010-\u001A\u00020\tH&J\u0010\u00101\u001A\u00020\r2\u0006\u0010)\u001A\u00020*H\'J\u001A\u00101\u001A\u00020\r2\u0006\u0010)\u001A\u00020*2\b\b\u0002\u00102\u001A\u000203H&J\u0010\u00104\u001A\u00020\r2\u0006\u00105\u001A\u00020*H\'J\u001A\u00104\u001A\u00020\r2\u0006\u00105\u001A\u00020*2\b\b\u0002\u00102\u001A\u000203H&J\u0010\u00106\u001A\u00020\r2\u0006\u00107\u001A\u000208H\'J\u001A\u00106\u001A\u00020\r2\u0006\u00107\u001A\u0002082\b\b\u0002\u00102\u001A\u000203H&J \u00109\u001A\u00020\r2\u0006\u00105\u001A\u00020*2\u0006\u0010+\u001A\u00020\u000F2\u0006\u0010,\u001A\u00020\u000FH&J \u0010:\u001A\u00020\r2\u0006\u00105\u001A\u00020*2\u0006\u0010/\u001A\u00020\u000F2\u0006\u00100\u001A\u00020\u000FH&J!\u0010;\u001A\u00020\r2\u0006\u0010<\u001A\u00020\u00002\b\b\u0002\u0010=\u001A\u00020>H&¢\u0006\u0004\b?\u0010@J\b\u0010A\u001A\u00020\rH&J\b\u0010B\u001A\u00020\rH&J\b\u0010C\u001A\u00020\rH\u0016J\u0017\u0010D\u001A\u00020\r2\u0006\u0010=\u001A\u00020>H&¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001A\u00020\r2\u0006\u0010H\u001A\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\b\u0010L\u001A\u00020*H&J\t\u0010M\u001A\u00020NH\u0096\u0002J\u001A\u0010M\u001A\u00020N2\u0006\u0010O\u001A\u00020P2\b\b\u0002\u0010Q\u001A\u00020\u000FH\u0016J\'\u0010R\u001A\u00020\t2\u0006\u0010S\u001A\u00020\u00002\u0006\u0010T\u001A\u00020\u00002\u0006\u0010U\u001A\u00020VH&¢\u0006\u0004\bW\u0010XJ\u0011\u0010Y\u001A\u00020\u00002\u0006\u0010<\u001A\u00020\u0000H\u0096\u0002J\u0011\u0010Z\u001A\u00020\u00002\u0006\u0010<\u001A\u00020\u0000H\u0096\u0002J\u0011\u0010[\u001A\u00020\u00002\u0006\u0010<\u001A\u00020\u0000H\u0096\u0004J\u0011\u0010\\\u001A\u00020\u00002\u0006\u0010<\u001A\u00020\u0000H\u0096\u0004J\u0011\u0010]\u001A\u00020\u00002\u0006\u0010<\u001A\u00020\u0000H\u0096\u0004R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\nR\u0012\u0010\u000B\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006`À\u0006\u0003"}, d2={"Landroidx/compose/ui/graphics/Path;", "", "fillType", "Landroidx/compose/ui/graphics/PathFillType;", "getFillType-Rg-k1Os", "()I", "setFillType-oQ8Xj4U", "(I)V", "isConvex", "", "()Z", "isEmpty", "moveTo", "", "x", "", "y", "relativeMoveTo", "dx", "dy", "lineTo", "relativeLineTo", "quadraticBezierTo", "x1", "y1", "x2", "y2", "quadraticTo", "relativeQuadraticBezierTo", "dx1", "dy1", "dx2", "dy2", "relativeQuadraticTo", "cubicTo", "x3", "y3", "relativeCubicTo", "dx3", "dy3", "arcToRad", "rect", "Landroidx/compose/ui/geometry/Rect;", "startAngleRadians", "sweepAngleRadians", "forceMoveTo", "arcTo", "startAngleDegrees", "sweepAngleDegrees", "addRect", "direction", "Landroidx/compose/ui/graphics/Path$Direction;", "addOval", "oval", "addRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "addArcRad", "addArc", "addPath", "path", "offset", "Landroidx/compose/ui/geometry/Offset;", "addPath-Uv8p0NA", "(Landroidx/compose/ui/graphics/Path;J)V", "close", "reset", "rewind", "translate", "translate-k-4lQ0M", "(J)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "getBounds", "iterator", "Landroidx/compose/ui/graphics/PathIterator;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "op", "path1", "path2", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "op-N5in7k0", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;I)Z", "plus", "minus", "or", "and", "xor", "Direction", "Companion", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface Path {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/graphics/Path$Companion;", "", "<init>", "()V", "combine", "Landroidx/compose/ui/graphics/Path;", "operation", "Landroidx/compose/ui/graphics/PathOperation;", "path1", "path2", "combine-xh6zSI8", "(ILandroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Path;)Landroidx/compose/ui/graphics/Path;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        static {
            Companion.$$INSTANCE = new Companion();
        }

        private Companion() {
            super();
        }

        public final Path combine-xh6zSI8(int arg1, Path arg2, Path arg3) {
            Path v0 = AndroidPath_androidKt.Path();
            if(v0.op-N5in7k0(arg2, arg3, arg1)) {
                return v0;
            }

            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class DefaultImpls {
        public static void addOval$default(Path arg0, Rect arg1, Direction arg2, int arg3, Object arg4) {
            Path.addOval$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static void addPath-Uv8p0NA$default(Path arg0, Path arg1, long arg2, int arg4, Object arg5) {
            Path.addPath-Uv8p0NA$default(arg0, arg1, arg2, arg4, arg5);
        }

        public static void addRect$default(Path arg0, Rect arg1, Direction arg2, int arg3, Object arg4) {
            Path.addRect$default(arg0, arg1, arg2, arg3, arg4);
        }

        public static void addRoundRect$default(Path arg0, RoundRect arg1, Direction arg2, int arg3, Object arg4) {
            Path.addRoundRect$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static Path and(Path arg0, Path arg1) {
            return arg0.and(arg1);
        }

        @Deprecated public static void arcToRad(Path arg0, Rect arg1, float arg2, float arg3, boolean arg4) {
            arg0.arcToRad(arg1, arg2, arg3, arg4);
        }

        @Deprecated public static PathIterator iterator(Path arg0) {
            return arg0.iterator();
        }

        @Deprecated public static PathIterator iterator(Path arg0, ConicEvaluation arg1, float arg2) {
            return arg0.iterator(arg1, arg2);
        }

        public static PathIterator iterator$default(Path arg0, ConicEvaluation arg1, float arg2, int arg3, Object arg4) {
            return Path.iterator$default(arg0, arg1, arg2, arg3, arg4);
        }

        @Deprecated public static Path minus(Path arg0, Path arg1) {
            return arg0.minus(arg1);
        }

        @Deprecated public static Path or(Path arg0, Path arg1) {
            return arg0.or(arg1);
        }

        @Deprecated public static Path plus(Path arg0, Path arg1) {
            return arg0.plus(arg1);
        }

        @Deprecated public static void quadraticTo(Path arg0, float arg1, float arg2, float arg3, float arg4) {
            arg0.quadraticTo(arg1, arg2, arg3, arg4);
        }

        @Deprecated public static void relativeQuadraticTo(Path arg0, float arg1, float arg2, float arg3, float arg4) {
            arg0.relativeQuadraticTo(arg1, arg2, arg3, arg4);
        }

        @Deprecated public static void rewind(Path arg0) {
            arg0.rewind();
        }

        @Deprecated public static void transform-58bKbWc(Path arg0, float[] arg1) {
            arg0.transform-58bKbWc(arg1);
        }

        @Deprecated public static Path xor(Path arg0, Path arg1) {
            return arg0.xor(arg1);
        }
    }

    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/graphics/Path$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "CounterClockwise", "Clockwise", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Direction {
        public static final enum Direction Clockwise;
        public static final enum Direction CounterClockwise;

        private static final Direction[] $values() {
            return new Direction[]{Direction.CounterClockwise, Direction.Clockwise};
        }

        static {
            Direction.CounterClockwise = new Direction("CounterClockwise", 0);
            Direction.Clockwise = new Direction("Clockwise", 1);
            Direction[] v0 = Direction.$values();
            Direction.$VALUES = v0;
            Direction.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Direction(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Direction.$ENTRIES;
        }

        public static Direction valueOf(String arg1) {
            return Enum.valueOf(Direction.class, arg1);
        }

        public static Direction[] values() {
            return Direction.$VALUES.clone();
        }
    }

    public static final Companion Companion;

    static {
        Path.Companion = Companion.$$INSTANCE;
    }

    static Path access$and$jd(Path arg0, Path arg1) {
        return super.and(arg1);
    }

    static void access$arcToRad$jd(Path arg0, Rect arg1, float arg2, float arg3, boolean arg4) {
        super.arcToRad(arg1, arg2, arg3, arg4);
    }

    static PathIterator access$iterator$jd(Path arg0) {
        return super.iterator();
    }

    static PathIterator access$iterator$jd(Path arg0, ConicEvaluation arg1, float arg2) {
        return super.iterator(arg1, arg2);
    }

    static Path access$minus$jd(Path arg0, Path arg1) {
        return super.minus(arg1);
    }

    static Path access$or$jd(Path arg0, Path arg1) {
        return super.or(arg1);
    }

    static Path access$plus$jd(Path arg0, Path arg1) {
        return super.plus(arg1);
    }

    static void access$quadraticTo$jd(Path arg0, float arg1, float arg2, float arg3, float arg4) {
        super.quadraticTo(arg1, arg2, arg3, arg4);
    }

    static void access$relativeQuadraticTo$jd(Path arg0, float arg1, float arg2, float arg3, float arg4) {
        super.relativeQuadraticTo(arg1, arg2, arg3, arg4);
    }

    static void access$rewind$jd(Path arg0) {
        super.rewind();
    }

    static void access$transform-58bKbWc$jd(Path arg0, float[] arg1) {
        super.transform-58bKbWc(arg1);
    }

    static Path access$xor$jd(Path arg0, Path arg1) {
        return super.xor(arg1);
    }

    void addArc(Rect arg1, float arg2, float arg3);

    void addArcRad(Rect arg1, float arg2, float arg3);

    void addOval(Rect arg1, Direction arg2);

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of addOval() with a winding direction", replaceWith="<_subannotation>") void addOval(Rect arg1);

    static void addOval$default(Path arg0, Rect arg1, Direction arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = Direction.CounterClockwise;
            }

            arg0.addOval(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
    }

    void addPath-Uv8p0NA(Path arg1, long arg2);

    static void addPath-Uv8p0NA$default(Path arg0, Path arg1, long arg2, int arg4, Object arg5) {
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                arg2 = Offset.Companion.getZero-F1C5BW0();
            }

            arg0.addPath-Uv8p0NA(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
    }

    void addRect(Rect arg1, Direction arg2);

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of addRect() with a winding direction", replaceWith="<_subannotation>") void addRect(Rect arg1);

    static void addRect$default(Path arg0, Rect arg1, Direction arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = Direction.CounterClockwise;
            }

            arg0.addRect(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
    }

    void addRoundRect(RoundRect arg1, Direction arg2);

    @kotlin.Deprecated(level=DeprecationLevel.HIDDEN, message="Prefer usage of addRoundRect() with a winding direction", replaceWith="<_subannotation>") void addRoundRect(RoundRect arg1);

    static void addRoundRect$default(Path arg0, RoundRect arg1, Direction arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = Direction.CounterClockwise;
            }

            arg0.addRoundRect(arg1, arg2);
            return;
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
    }

    default Path and(Path arg3) {
        Path v0 = AndroidPath_androidKt.Path();
        v0.op-N5in7k0(this, arg3, PathOperation.Companion.getIntersect-b3I0S0c());
        return v0;
    }

    void arcTo(Rect arg1, float arg2, float arg3, boolean arg4);

    default void arcToRad(Rect arg1, float arg2, float arg3, boolean arg4) {
        this.arcTo(arg1, DegreesKt.degrees(arg2), DegreesKt.degrees(arg3), arg4);
    }

    void close();

    void cubicTo(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6);

    Rect getBounds();

    int getFillType-Rg-k1Os();

    boolean isConvex();

    boolean isEmpty();

    default PathIterator iterator(ConicEvaluation arg1, float arg2) {
        return AndroidPathIterator_androidKt.PathIterator(this, arg1, arg2);
    }

    default PathIterator iterator() {
        return AndroidPathIterator_androidKt.PathIterator$default(this, null, 0f, 6, null);
    }

    static PathIterator iterator$default(Path arg0, ConicEvaluation arg1, float arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            if((arg3 & 2) != 0) {
                arg2 = 0.25f;
            }

            return arg0.iterator(arg1, arg2);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: iterator");
    }

    void lineTo(float arg1, float arg2);

    default Path minus(Path arg3) {
        Path v0 = AndroidPath_androidKt.Path();
        v0.op-N5in7k0(this, arg3, PathOperation.Companion.getDifference-b3I0S0c());
        return v0;
    }

    void moveTo(float arg1, float arg2);

    boolean op-N5in7k0(Path arg1, Path arg2, int arg3);

    default Path or(Path arg1) {
        return this.plus(arg1);
    }

    default Path plus(Path arg3) {
        Path v0 = AndroidPath_androidKt.Path();
        v0.op-N5in7k0(this, arg3, PathOperation.Companion.getUnion-b3I0S0c());
        return v0;
    }

    @kotlin.Deprecated(level=DeprecationLevel.WARNING, message="Use quadraticTo() for consistency with cubicTo()", replaceWith="<_subannotation>") void quadraticBezierTo(float arg1, float arg2, float arg3, float arg4);

    default void quadraticTo(float arg1, float arg2, float arg3, float arg4) {
        this.quadraticBezierTo(arg1, arg2, arg3, arg4);
    }

    void relativeCubicTo(float arg1, float arg2, float arg3, float arg4, float arg5, float arg6);

    void relativeLineTo(float arg1, float arg2);

    void relativeMoveTo(float arg1, float arg2);

    @kotlin.Deprecated(level=DeprecationLevel.WARNING, message="Use relativeQuadraticTo() for consistency with relativeCubicTo()", replaceWith="<_subannotation>") void relativeQuadraticBezierTo(float arg1, float arg2, float arg3, float arg4);

    default void relativeQuadraticTo(float arg1, float arg2, float arg3, float arg4) {
        this.relativeQuadraticBezierTo(arg1, arg2, arg3, arg4);
    }

    void reset();

    default void rewind() {
        this.reset();
    }

    void setFillType-oQ8Xj4U(int arg1);

    default void transform-58bKbWc(float[] arg1) {
    }

    void translate-k-4lQ0M(long arg1);

    default Path xor(Path arg3) {
        Path v0 = AndroidPath_androidKt.Path();
        v0.op-N5in7k0(this, arg3, PathOperation.Companion.getXor-b3I0S0c());
        return v0;
    }
}

