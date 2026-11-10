package androidx.compose.runtime.composer.linkbuffer;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001A\u00060\bj\u0002`\tJ\b\u0010\n\u001A\u00020\u000BH\u0016J\u0015\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0000¢\u0006\u0002\b\u0010J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\u0003H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/AnchorHandle;", "", "groupAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "contextAnchor", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;)V", "toHandle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "toString", "", "ownedBy", "", "addressSpace", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "ownedBy$runtime", "anchor", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class AnchorHandle {
    public static final int $stable = 8;
    private final LinkAnchor contextAnchor;
    private final LinkAnchor groupAnchor;

    static {
    }

    public AnchorHandle(LinkAnchor arg1, LinkAnchor arg2) {
        super();
        this.groupAnchor = arg1;
        this.contextAnchor = arg2;
    }

    private final boolean ownedBy(SlotTableAddressSpace arg1, LinkAnchor arg2) {
        if(!Intrinsics.areEqual(arg2, LinkAnchorKt.getNullAnchor())) {
            if(Intrinsics.areEqual(arg2, LinkAnchorKt.getLazyAnchor())) {
            }
            else {
                return arg1.ownsAnchor(arg2);
            }
        }

        return 1;
    }

    public final boolean ownedBy$runtime(SlotTableAddressSpace arg2) {
        if((this.ownedBy(arg2, this.groupAnchor)) && (this.ownedBy(arg2, this.contextAnchor))) {
            return 1;
        }

        return 0;
    }

    public final long toHandle() {
        return (((long)this.contextAnchor.getAddress())) << 0x20 | (((long)UInt.constructor-impl(this.groupAnchor.getAddress()))) & 0xFFFFFFFFL;
    }

    public String toString() {
        return super.toString() + ": " + this.groupAnchor.getAddress() + ':' + this.contextAnchor.getAddress();
    }
}

