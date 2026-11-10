package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\f\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0000\u001A\u0018\u0010\b\u001A\u00020\t*\u00020\n2\n\u0010\u000B\u001A\u00060\fj\u0002`\rH\u0000\u001A\u0014\u0010\u000E\u001A\u00020\u000F*\u00020\n2\u0006\u0010\b\u001A\u00020\tH\u0000\"\u0014\u0010\u0003\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001A\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2={"asLinkAnchor", "Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "Landroidx/compose/runtime/Anchor;", "NullAnchor", "getNullAnchor", "()Landroidx/compose/runtime/composer/linkbuffer/LinkAnchor;", "LazyAnchor", "getLazyAnchor", "anchorHandle", "Landroidx/compose/runtime/composer/linkbuffer/AnchorHandle;", "Landroidx/compose/runtime/composer/linkbuffer/SlotTableAddressSpace;", "handle", "", "Landroidx/compose/runtime/composer/linkbuffer/GroupHandle;", "ownsHandle", "", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class LinkAnchorKt {
    private static final LinkAnchor LazyAnchor;
    private static final LinkAnchor NullAnchor;

    static {
        LinkAnchorKt.NullAnchor = new LinkAnchor(-1);
        LinkAnchorKt.LazyAnchor = new LinkAnchor(0);
    }

    public static final AnchorHandle anchorHandle(SlotTableAddressSpace arg2, long arg3) {
        return new AnchorHandle(LinkAnchorKt.anchorHandle$anchorOf(arg2, GroupHandleKt.getGroup(arg3)), LinkAnchorKt.anchorHandle$anchorOf(arg2, GroupHandleKt.getContext(arg3)));
    }

    private static final LinkAnchor anchorHandle$anchorOf(SlotTableAddressSpace arg1, int arg2) {
        if(arg2 != -1) {
            if(arg2 != 0) {
                return arg1.anchorOfAddress(arg2);
            }

            return LinkAnchorKt.LazyAnchor;
        }

        return LinkAnchorKt.NullAnchor;
    }

    public static final LinkAnchor asLinkAnchor(Anchor arg1) {
        if((arg1 instanceof LinkAnchor)) {
        }
        else {
            arg1 = null;
        }

        if(0 != 0) {
            return arg1;
        }

        ComposerKt.composeRuntimeError("Inconsistent composition");
        throw new KotlinNothingValueException();
    }

    public static final LinkAnchor getLazyAnchor() {
        return LinkAnchorKt.LazyAnchor;
    }

    public static final LinkAnchor getNullAnchor() {
        return LinkAnchorKt.NullAnchor;
    }

    public static final boolean ownsHandle(SlotTableAddressSpace arg0, AnchorHandle arg1) {
        return arg1.ownedBy$runtime(arg0);
    }
}

