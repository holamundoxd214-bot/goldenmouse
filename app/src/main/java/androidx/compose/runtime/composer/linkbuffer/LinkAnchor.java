package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Anchor;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000E\u001A\u00020\u000FH\u0016R\u001E\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "Landroidx/compose/runtime/Anchor;", "address", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupAddress;", "<init>", "(I)V", "getAddress", "()I", "setAddress", "valid", "", "getValid", "()Z", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class LinkAnchor implements Anchor {
    public static final int $stable = 8;
    private int address;

    static {
    }

    public LinkAnchor(int arg1) {
        super();
        this.address = arg1;
    }

    public final int getAddress() {
        return this.address;
    }

    public boolean getValid() {
        if(this.address != -1) {
            return 1;
        }

        return 0;
    }

    public final void setAddress(int arg1) {
        this.address = arg1;
    }

    public String toString() {
        return super.toString() + "{ address: " + this.address + " }";
    }
}

