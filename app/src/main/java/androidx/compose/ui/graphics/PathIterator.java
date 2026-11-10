package androidx.compose.ui.graphics;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019J\u0012\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u0012H&J\t\u0010\u0013\u001A\u00020\u0012H¦\u0002J\u001A\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u0010H&J\t\u0010\u0014\u001A\u00020\u0002H¦\u0002R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\fX¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001AÀ\u0006\u0001"}, d2={"Landroidx/compose/ui/graphics/PathIterator;", "", "Landroidx/compose/ui/graphics/PathSegment;", "path", "Landroidx/compose/ui/graphics/Path;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "conicEvaluation", "Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "getConicEvaluation", "()Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "tolerance", "", "getTolerance", "()F", "calculateSize", "", "includeConvertedConics", "", "hasNext", "next", "Landroidx/compose/ui/graphics/PathSegment$Type;", "outPoints", "", "offset", "ConicEvaluation", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PathIterator extends Iterator, KMappedMarker {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/graphics/PathIterator$ConicEvaluation;", "", "<init>", "(Ljava/lang/String;I)V", "AsConic", "AsQuadratics", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public enum ConicEvaluation {
        public static final enum ConicEvaluation AsConic;
        public static final enum ConicEvaluation AsQuadratics;

        private static final ConicEvaluation[] $values() {
            return new ConicEvaluation[]{ConicEvaluation.AsConic, ConicEvaluation.AsQuadratics};
        }

        static {
            ConicEvaluation.AsConic = new ConicEvaluation("AsConic", 0);
            ConicEvaluation.AsQuadratics = new ConicEvaluation("AsQuadratics", 1);
            ConicEvaluation[] v0 = ConicEvaluation.$values();
            ConicEvaluation.$VALUES = v0;
            ConicEvaluation.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private ConicEvaluation(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return ConicEvaluation.$ENTRIES;
        }

        public static ConicEvaluation valueOf(String arg1) {
            return Enum.valueOf(ConicEvaluation.class, arg1);
        }

        public static ConicEvaluation[] values() {
            return ConicEvaluation.$VALUES.clone();
        }
    }

    int calculateSize(boolean arg1);

    static int calculateSize$default(PathIterator arg0, boolean arg1, int arg2, Object arg3) {
        if(arg3 == null) {
            return arg0.calculateSize(true);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateSize");
    }

    ConicEvaluation getConicEvaluation();

    Path getPath();

    float getTolerance();

    boolean hasNext();

    PathSegment next();

    Type next(float[] arg1, int arg2);

    static Type next$default(PathIterator arg0, float[] arg1, int arg2, int arg3, Object arg4) {
        if(arg4 == null) {
            return arg0.next(arg1, 0);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: next");
    }
}

