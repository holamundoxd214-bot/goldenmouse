package androidx.graphics.path;

import android.graphics.PointF;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B%\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001A\u00020\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0019\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0019"}, d2={"Landroidx/graphics/path/PathSegment;", "", "type", "Landroidx/graphics/path/PathSegment$Type;", "points", "", "Landroid/graphics/PointF;", "weight", "", "(Landroidx/graphics/path/PathSegment$Type;[Landroid/graphics/PointF;F)V", "getPoints", "()[Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "getType", "()Landroidx/graphics/path/PathSegment$Type;", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Type", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public final class PathSegment {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2={"Landroidx/graphics/path/PathSegment$Type;", "", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", "Close", "Done", "graphics-path_release"}, k=1, mv={1, 8, 0}, xi=0x30) public enum Type {
        public static final enum Type Close;
        public static final enum Type Conic;
        public static final enum Type Cubic;
        public static final enum Type Done;
        public static final enum Type Line;
        public static final enum Type Move;
        public static final enum Type Quadratic;

        private static final Type[] $values() {
            return new Type[]{Type.Move, Type.Line, Type.Quadratic, Type.Conic, Type.Cubic, Type.Close, Type.Done};
        }

        static {
            Type.Move = new Type("Move", 0);
            Type.Line = new Type("Line", 1);
            Type.Quadratic = new Type("Quadratic", 2);
            Type.Conic = new Type("Conic", 3);
            Type.Cubic = new Type("Cubic", 4);
            Type.Close = new Type("Close", 5);
            Type.Done = new Type("Done", 6);
            Type.$VALUES = Type.$values();
        }

        private Type(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static Type valueOf(String arg1) {
            return Enum.valueOf(Type.class, arg1);
        }

        public static Type[] values() {
            return Type.$VALUES.clone();
        }
    }

    private final PointF[] points;
    private final Type type;
    private final float weight;

    public PathSegment(Type arg2, PointF[] arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "type");
        Intrinsics.checkNotNullParameter(arg3, "points");
        super();
        this.type = arg2;
        this.points = arg3;
        this.weight = arg4;
    }

    public boolean equals(Object arg5) {
        if(this == (((PathSegment)arg5))) {
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

        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type androidx.graphics.path.PathSegment");
        if(this.type != ((PathSegment)arg5).type) {
            return 0;
        }

        if(!Arrays.equals(this.points, ((PathSegment)arg5).points)) {
            return 0;
        }

        if(this.weight == ((PathSegment)arg5).weight) {
            return 1;
        }

        return 0;
    }

    public final PointF[] getPoints() {
        return this.points;
    }

    public final Type getType() {
        return this.type;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (this.type.hashCode() * 0x1F + Arrays.hashCode(this.points)) * 0x1F + Float.hashCode(this.weight);
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder("PathSegment(type=").append(this.type).append(", points=");
        String v1 = Arrays.toString(this.points);
        Intrinsics.checkNotNullExpressionValue(v1, "toString(this)");
        return v0.append(v1).append(", weight=").append(this.weight).append(')').toString();
    }
}

