package androidx.compose.runtime.composer.linkbuffer;

import androidx.compose.runtime.composer.gapbuffer.BitVector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0010\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u0011\u0010\u0014\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003H\u0096\u0002J\t\u0010\u0015\u001A\u00020\u0016H\u0096\u0002J\u000B\u0010\u0017\u001A\u0004\u0018\u00010\u0002H\u0096\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u000E\u0010\u000E\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/composer/linkbuffer/SourceInformationGroupDataIterator;", "", "", "", "table", "Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "group", "", "sourceInformation", "Landroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;", "<init>", "(Landroidx/compose/runtime/composer/linkbuffer/SlotTable;ILandroidx/compose/runtime/composer/linkbuffer/LinkGroupSourceInformation;)V", "getTable", "()Landroidx/compose/runtime/composer/linkbuffer/SlotTable;", "base", "start", "end", "filter", "Landroidx/compose/runtime/composer/gapbuffer/BitVector;", "index", "iterator", "hasNext", "", "next", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SourceInformationGroupDataIterator implements Iterable, Iterator, KMappedMarker {
    private final int base;
    private final int end;
    private final BitVector filter;
    private int index;
    private final int start;
    private final SlotTable table;

    public SourceInformationGroupDataIterator(SlotTable arg4, int arg5, LinkGroupSourceInformation arg6) {
        super();
        this.table = arg4;
        arg5 += 5;
        this.base = arg4.getAddressSpace().getGroups()[arg5] >> 4;
        this.start = arg6.getDataStartOffset();
        int v0 = arg6.getDataEndOffset();
        int v1 = 0;
        if(v0 > 0) {
        }
        else {
            SlotTableAddressSpace v4 = arg4.getAddressSpace();
            arg5 = v4.getGroups()[arg5];
            if(arg5 == -1) {
                v0 = 0;
            }
            else {
                v0 = (arg5 & 15) + 1;
                if(v0 > 15) {
                    v0 = v4.getLargeSizes().get(arg5 >> 4);
                }
            }
        }

        this.end = v0;
        BitVector v4_1 = new BitVector();
        ArrayList v5 = arg6.getGroups();
        if(v5 == null) {
        }
        else {
            int v6 = v5.size();
            while(v1 < v6) {
                Object v0_1 = ((List)v5).get(v1);
                if((v0_1 instanceof LinkGroupSourceInformation)) {
                    v4_1.setRange(((LinkGroupSourceInformation)v0_1).getDataStartOffset(), ((LinkGroupSourceInformation)v0_1).getDataEndOffset());
                }

                ++v1;
            }
        }

        this.filter = v4_1;
        this.index = v4_1.nextClear(this.start);
    }

    public final SlotTable getTable() {
        return this.table;
    }

    public boolean hasNext() {
        if(this.index < this.end) {
            return 1;
        }

        return 0;
    }

    public Iterator iterator() {
        return this;
    }

    public Object next() {
        Object v0_2;
        int v0 = this.end;
        int v1 = this.index;
        if(v1 < 0 || v1 >= v0) {
            v0_2 = null;
        }
        else {
            Object[] v0_1 = this.table.getAddressSpace().getSlots();
            v1 = this.base;
            int v2 = this.index;
            v0_2 = v0_1[v1 + v2];
            v1 = v2;
        }

        this.index = this.filter.nextClear(v1 + 1);
        return v0_2;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

