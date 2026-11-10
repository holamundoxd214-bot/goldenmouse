package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH ¢\u0006\u0004\b\f\u0010\rJ\'\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\t2\u0006\u0010\u0011\u001A\u00020\tH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001B\u0010\u0014\u001A\u00020\u000F*\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/text/selection/SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "Vertical", "Horizontal", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation", "(JLandroidx/compose/ui/geometry/Rect;)I", "isSelected", "", "start", "end", "isSelected-2x9bVx0$foundation", "(Landroidx/compose/ui/geometry/Rect;JJ)Z", "containsInclusive", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract enum SelectionMode {
    @Metadata(d1={"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"androidx/compose/foundation/text/selection/SelectionMode.Horizontal", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Horizontal extends SelectionMode {
        Horizontal(String arg2, int arg3) {
            super(arg2, arg3, null);
        }

        public int compare-3MmeM6k$foundation(long arg5, Rect arg7) {
            if(SelectionManagerKt.containsInclusive-Uv8p0NA(arg7, arg5)) {
                return 0;
            }

            int v4 = ((int)(arg5 >> 0x20));
            int v1 = -1;
            if(Float.compare(Float.intBitsToFloat(v4), arg7.getLeft()) < 0) {
                return v1;
            }

            if(Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL))) < arg7.getTop() && Float.intBitsToFloat(v4) < arg7.getRight()) {
                return v1;
            }

            return 1;
        }
    }

    @Metadata(d1={"\u0000\u001F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2={"androidx/compose/foundation/text/selection/SelectionMode.Vertical", "Landroidx/compose/foundation/text/selection/SelectionMode;", "compare", "", "position", "Landroidx/compose/ui/geometry/Offset;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "compare-3MmeM6k$foundation", "(JLandroidx/compose/ui/geometry/Rect;)I", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class Vertical extends SelectionMode {
        Vertical(String arg2, int arg3) {
            super(arg2, arg3, null);
        }

        public int compare-3MmeM6k$foundation(long arg3, Rect arg5) {
            if(SelectionManagerKt.containsInclusive-Uv8p0NA(arg5, arg3)) {
                return 0;
            }

            int v2 = ((int)(0xFFFFFFFFL & arg3));
            int v1 = -1;
            if(Float.compare(Float.intBitsToFloat(v2), arg5.getTop()) < 0) {
                return v1;
            }

            if(Float.intBitsToFloat(((int)(arg3 >> 0x20))) < arg5.getLeft() && Float.intBitsToFloat(v2) < arg5.getBottom()) {
                return v1;
            }

            return 1;
        }
    }

    public static final enum SelectionMode Horizontal;
    public static final enum SelectionMode Vertical;

    private static final SelectionMode[] $values() {
        return new SelectionMode[]{SelectionMode.Vertical, SelectionMode.Horizontal};
    }

    static {
        SelectionMode.Vertical = new Vertical("Vertical", 0);
        SelectionMode.Horizontal = new Horizontal("Horizontal", 1);
        SelectionMode[] v0 = SelectionMode.$values();
        SelectionMode.$VALUES = v0;
        SelectionMode.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private SelectionMode(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public SelectionMode(String arg1, int arg2, DefaultConstructorMarker arg3) {
        this(arg1, arg2);
    }

    public abstract int compare-3MmeM6k$foundation(long arg1, Rect arg2);

    private final boolean containsInclusive-Uv8p0NA(Rect arg4, long arg5) {
        float v3 = arg4.getLeft();
        float v0 = arg4.getRight();
        float v1 = Float.intBitsToFloat(((int)(arg5 >> 0x20)));
        if(v3 <= v1 && v1 <= v0) {
            v3 = arg4.getTop();
            float v4 = arg4.getBottom();
            float v5 = Float.intBitsToFloat(((int)(arg5 & 0xFFFFFFFFL)));
            if(v3 <= v5 && v5 <= v4) {
                return 1;
            }
        }

        return 0;
    }

    public static EnumEntries getEntries() {
        return SelectionMode.$ENTRIES;
    }

    public final boolean isSelected-2x9bVx0$foundation(Rect arg3, long arg4, long arg6) {
        int v1 = 1;
        if(!this.containsInclusive-Uv8p0NA(arg3, arg4)) {
            if(this.containsInclusive-Uv8p0NA(arg3, arg6)) {
            }
            else {
                int v4 = this.compare-3MmeM6k$foundation(arg4, arg3);
                int v2 = this.compare-3MmeM6k$foundation(arg6, arg3);
                v4 = v4 > 0 ? 1 : 0;
                if(v2 > 0) {
                }
                else {
                    v1 = 0;
                }

                return v4 ^ v1;
            }
        }

        return 1;
    }

    public static SelectionMode valueOf(String arg1) {
        return Enum.valueOf(SelectionMode.class, arg1);
    }

    public static SelectionMode[] values() {
        return SelectionMode.$VALUES.clone();
    }
}

