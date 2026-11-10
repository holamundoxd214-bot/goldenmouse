package androidx.compose.ui.semantics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u000E"}, d2={"Landroidx/compose/ui/semantics/CollectionItemInfo;", "", "rowIndex", "", "rowSpan", "columnIndex", "columnSpan", "<init>", "(IIII)V", "getRowIndex", "()I", "getRowSpan", "getColumnIndex", "getColumnSpan", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CollectionItemInfo {
    public static final int $stable;
    private final int columnIndex;
    private final int columnSpan;
    private final int rowIndex;
    private final int rowSpan;

    static {
    }

    public CollectionItemInfo(int arg1, int arg2, int arg3, int arg4) {
        super();
        this.rowIndex = arg1;
        this.rowSpan = arg2;
        this.columnIndex = arg3;
        this.columnSpan = arg4;
    }

    public final int getColumnIndex() {
        return this.columnIndex;
    }

    public final int getColumnSpan() {
        return this.columnSpan;
    }

    public final int getRowIndex() {
        return this.rowIndex;
    }

    public final int getRowSpan() {
        return this.rowSpan;
    }
}

