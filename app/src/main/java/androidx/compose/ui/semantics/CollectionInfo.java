package androidx.compose.ui.semantics;

import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001A\u00020\u0003H\u0016J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0010"}, d2={"Landroidx/compose/ui/semantics/CollectionInfo;", "", "rowCount", "", "columnCount", "<init>", "(II)V", "getRowCount", "()I", "getColumnCount", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CollectionInfo {
    public static final int $stable;
    private final int columnCount;
    private final int rowCount;

    static {
    }

    public CollectionInfo(int arg1, int arg2) {
        super();
        this.rowCount = arg1;
        this.columnCount = arg2;
    }

    public boolean equals(Object arg5) {
        if(this == (((CollectionInfo)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof CollectionInfo)) {
            return 0;
        }

        if(this.rowCount != ((CollectionInfo)arg5).rowCount) {
            return 0;
        }

        if(this.columnCount != ((CollectionInfo)arg5).columnCount) {
            return 0;
        }

        return 1;
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final int getRowCount() {
        return this.rowCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.rowCount) * 0x1F + Integer.hashCode(this.columnCount);
    }

    public String toString() {
        return "CollectionInfo(rowCount=" + this.rowCount + ", columnCount=" + this.columnCount + ')';
    }
}

