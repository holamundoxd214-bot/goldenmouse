package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B*\b\u0002\u0012\u001F\u0010\u0002\u001A\u001B\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tJ%\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\rH\u0010¢\u0006\u0002\b\u000F¨\u0006\u0011"}, d2={"Landroidx/compose/ui/layout/VerticalRuler;", "Landroidx/compose/ui/layout/Ruler;", "calculation", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "()V", "calculateCoordinate", "coordinate", "sourceCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "targetCoordinates", "calculateCoordinate$ui", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VerticalRuler extends Ruler {
    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0004\u001A\u00020\u00052\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005¢\u0006\u0002\u0010\bJ\u001F\u0010\t\u001A\u00020\u00052\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005¢\u0006\u0002\u0010\bJ4\u0010\n\u001A\u00020\u00052,\u0010\u000B\u001A(\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000E0\f¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/layout/VerticalRuler$Companion;", "", "<init>", "()V", "maxOf", "Landroidx/compose/ui/layout/VerticalRuler;", "rulers", "", "([Landroidx/compose/ui/layout/VerticalRuler;)Landroidx/compose/ui/layout/VerticalRuler;", "minOf", "derived", "calculation", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ParameterName;", "name", "defaultValue", "Lkotlin/ExtensionFunctionType;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final VerticalRuler derived(Function2 arg2) {
            return new VerticalRuler(arg2, null);
        }

        public final VerticalRuler maxOf(VerticalRuler[] arg2) {
            return this.derived(new VerticalRuler$Companion$maxOf$1(arg2));
        }

        public final VerticalRuler minOf(VerticalRuler[] arg2) {
            return this.derived(new VerticalRuler$Companion$minOf$1(arg2));
        }
    }

    public static final int $stable;
    public static final Companion Companion;

    static {
        VerticalRuler.Companion = new Companion(null);
    }

    public VerticalRuler() {
        this(null);
    }

    private VerticalRuler(Function2 arg2) {
        super(arg2, null);
    }

    public VerticalRuler(Function2 arg1, DefaultConstructorMarker arg2) {
        this(arg1);
    }

    public float calculateCoordinate$ui(float arg6, LayoutCoordinates arg7, LayoutCoordinates arg8) {
        return Float.intBitsToFloat(((int)(arg8.localPositionOf-R5De75A(arg7, Offset.constructor-impl((((long)Float.floatToRawIntBits((((float)(((int)(arg7.getSize-YbymL2g() & 0xFFFFFFFFL))))) / 2f))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg6))) << 0x20)) >> 0x20)));
    }
}

