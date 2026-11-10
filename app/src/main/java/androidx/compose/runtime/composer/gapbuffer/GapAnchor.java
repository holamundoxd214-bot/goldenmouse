package androidx.compose.runtime.composer.gapbuffer;

import androidx.compose.runtime.Anchor;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0012J\b\u0010\u0013\u001A\u00020\u0014H\u0016R\u001A\u0010\u0006\u001A\u00020\u0003X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0015"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Landroidx/compose/runtime/Anchor;", "loc", "", "<init>", "(I)V", "location", "getLocation$runtime", "()I", "setLocation$runtime", "valid", "", "getValid", "()Z", "toIndexFor", "slots", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "writer", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class GapAnchor implements Anchor {
    public static final int $stable = 8;
    private int location;

    static {
    }

    public GapAnchor(int arg1) {
        super();
        this.location = arg1;
    }

    public final int getLocation$runtime() {
        return this.location;
    }

    public boolean getValid() {
        if(this.location != 0x80000000) {
            return 1;
        }

        return 0;
    }

    public final void setLocation$runtime(int arg1) {
        this.location = arg1;
    }

    public final int toIndexFor(SlotTable arg1) {
        return arg1.anchorIndex(this);
    }

    public final int toIndexFor(SlotWriter arg1) {
        return arg1.anchorIndex(this);
    }

    public String toString() {
        return super.toString() + "{ location = " + this.location + " }";
    }
}

