package androidx.compose.runtime.snapshots;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0003H&J\"\u0010\t\u001A\u0004\u0018\u00010\u00032\u0006\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u0003H\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2={"Landroidx/compose/runtime/snapshots/StateObject;", "", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "", "value", "mergeRecords", "previous", "current", "applied", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface StateObject {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static StateRecord mergeRecords(StateObject arg0, StateRecord arg1, StateRecord arg2, StateRecord arg3) {
            return arg0.mergeRecords(arg1, arg2, arg3);
        }
    }

    static StateRecord access$mergeRecords$jd(StateObject arg0, StateRecord arg1, StateRecord arg2, StateRecord arg3) {
        return super.mergeRecords(arg1, arg2, arg3);
    }

    StateRecord getFirstStateRecord();

    default StateRecord mergeRecords(StateRecord arg1, StateRecord arg2, StateRecord arg3) {
        return null;
    }

    void prependStateRecord(StateRecord arg1);
}

