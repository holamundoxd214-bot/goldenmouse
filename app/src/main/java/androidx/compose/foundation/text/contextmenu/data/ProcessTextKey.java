package androidx.compose.foundation.text.contextmenu.data;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2={"Landroidx/compose/foundation/text/contextmenu/data/ProcessTextKey;", "", "id", "", "<init>", "(I)V", "getId", "()I", "equals", "", "other", "hashCode", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ProcessTextKey {
    public static final int $stable;
    private final int id;

    static {
    }

    public ProcessTextKey(int arg1) {
        super();
        this.id = arg1;
    }

    public boolean equals(Object arg3) {
        if(!(arg3 instanceof ProcessTextKey)) {
            return 0;
        }

        if(this.id == ((ProcessTextKey)arg3).id) {
            return 1;
        }

        return 0;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id;
    }
}

