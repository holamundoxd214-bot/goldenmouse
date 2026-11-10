package androidx.compose.runtime.tooling;

import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u001C\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0005R\u001A\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0003"}, d2={"Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/runtime/tooling/CompositionData;", "key", "", "getKey", "()Ljava/lang/Object;", "sourceInfo", "", "getSourceInfo", "()Ljava/lang/String;", "node", "getNode", "data", "", "getData", "()Ljava/lang/Iterable;", "identity", "getIdentity", "groupSize", "", "getGroupSize", "()I", "slotsSize", "getSlotsSize", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface CompositionGroup extends CompositionData {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static CompositionGroup find(CompositionGroup arg0, Object arg1) {
            return arg0.find(arg1);
        }

        @Deprecated public static int getGroupSize(CompositionGroup arg0) {
            return arg0.getGroupSize();
        }

        @Deprecated public static Object getIdentity(CompositionGroup arg0) {
            return arg0.getIdentity();
        }

        @Deprecated public static int getSlotsSize(CompositionGroup arg0) {
            return arg0.getSlotsSize();
        }
    }

    static CompositionGroup access$find$jd(CompositionGroup arg0, Object arg1) {
        return super.find(arg1);
    }

    static int access$getGroupSize$jd(CompositionGroup arg0) {
        return super.getGroupSize();
    }

    static Object access$getIdentity$jd(CompositionGroup arg0) {
        return super.getIdentity();
    }

    static int access$getSlotsSize$jd(CompositionGroup arg0) {
        return super.getSlotsSize();
    }

    Iterable getData();

    default int getGroupSize() {
        return 0;
    }

    default Object getIdentity() {
        return null;
    }

    Object getKey();

    Object getNode();

    default int getSlotsSize() {
        return 0;
    }

    String getSourceInfo();
}

