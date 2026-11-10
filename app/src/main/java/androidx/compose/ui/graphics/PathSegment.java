package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B!\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0018"}, d2={"Landroidx/compose/ui/graphics/PathSegment;", "", "type", "Landroidx/compose/ui/graphics/PathSegment$Type;", "points", "", "weight", "", "<init>", "(Landroidx/compose/ui/graphics/PathSegment$Type;[FF)V", "getType", "()Landroidx/compose/ui/graphics/PathSegment$Type;", "getPoints", "()[F", "getWeight", "()F", "equals", "", "other", "hashCode", "", "toString", "", "Type", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PathSegment {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2={"Landroidx/compose/ui/graphics/PathSegment$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Move", "Line", "Quadratic", "Conic", "Cubic", "Close", "Done", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Type {
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
            Type[] v0 = Type.$values();
            Type.$VALUES = v0;
            Type.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Type(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Type.$ENTRIES;
        }

        public static Type valueOf(String arg1) {
            return Enum.valueOf(Type.class, arg1);
        }

        public static Type[] values() {
            return Type.$VALUES.clone();
        }
    }

    public static final int $stable = 8;
    private final float[] points;
    private final Type type;
    private final float weight;

    static {
    }

    public PathSegment(Type arg1, float[] arg2, float arg3) {
        super();
        this.type = arg1;
        this.points = arg2;
        this.weight = arg3;
    }

    public boolean equals(Object arg5) {
        if(this == (((PathSegment)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.type != ((PathSegment)arg5).type) {
                return 0;
            }
            else if(!Arrays.equals(this.points, ((PathSegment)arg5).points)) {
                return 0;
            }
            else if(this.weight == ((PathSegment)arg5).weight) {
                return 1;
            }
        }

        return 0;
    }

    public final float[] getPoints() {
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
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v0.append(v1).append(", weight=").append(this.weight).append(')').toString();
    }
}

