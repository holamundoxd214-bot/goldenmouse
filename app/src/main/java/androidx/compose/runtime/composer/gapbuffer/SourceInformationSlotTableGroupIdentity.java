package androidx.compose.runtime.composer.gapbuffer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0001HÆ\u0003J\t\u0010\f\u001A\u00020\u0004HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0004HÆ\u0001J\u0014\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001A\u00020\u0004HÖ\u0081\u0004J\n\u0010\u0012\u001A\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0014"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SourceInformationSlotTableGroupIdentity;", "", "parentIdentity", "index", "", "<init>", "(Ljava/lang/Object;I)V", "getParentIdentity", "()Ljava/lang/Object;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SourceInformationSlotTableGroupIdentity {
    private final int index;
    private final Object parentIdentity;

    public SourceInformationSlotTableGroupIdentity(Object arg1, int arg2) {
        super();
        this.parentIdentity = arg1;
        this.index = arg2;
    }

    public final Object component1() {
        return this.parentIdentity;
    }

    public final int component2() {
        return this.index;
    }

    public final SourceInformationSlotTableGroupIdentity copy(Object arg1, int arg2) {
        return new SourceInformationSlotTableGroupIdentity(arg1, arg2);
    }

    public static SourceInformationSlotTableGroupIdentity copy$default(SourceInformationSlotTableGroupIdentity arg0, Object arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = arg0.parentIdentity;
        }

        if((arg3 & 2) != 0) {
            arg2 = arg0.index;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg5) {
        if(this == (((SourceInformationSlotTableGroupIdentity)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof SourceInformationSlotTableGroupIdentity)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.parentIdentity, ((SourceInformationSlotTableGroupIdentity)arg5).parentIdentity)) {
            return 0;
        }

        if(this.index != ((SourceInformationSlotTableGroupIdentity)arg5).index) {
            return 0;
        }

        return 1;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getParentIdentity() {
        return this.parentIdentity;
    }

    public int hashCode() {
        return this.parentIdentity.hashCode() * 0x1F + Integer.hashCode(this.index);
    }

    public String toString() {
        return "SourceInformationSlotTableGroupIdentity(parentIdentity=" + this.parentIdentity + ", index=" + this.index + ')';
    }
}

