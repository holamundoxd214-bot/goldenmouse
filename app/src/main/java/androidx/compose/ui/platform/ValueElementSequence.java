package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\bH\u0096\u0002J\u001B\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0086\u0002R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/ui/platform/ValueElementSequence;", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "<init>", "()V", "elements", "", "iterator", "", "set", "", "name", "", "value", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ValueElementSequence implements Sequence {
    public static final int $stable = 8;
    private final List elements;

    static {
    }

    public ValueElementSequence() {
        super();
        this.elements = new ArrayList();
    }

    public Iterator iterator() {
        return this.elements.iterator();
    }

    public final void set(String arg2, Object arg3) {
        this.elements.add(new ValueElement(arg2, arg3));
    }
}

