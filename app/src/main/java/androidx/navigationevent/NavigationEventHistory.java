package androidx.navigationevent;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001F\b\u0002\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0007\u0010\tB1\b\u0011\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\rJ\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0006H\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/navigationevent/NavigationEventHistory;", "", "mergedHistory", "", "Landroidx/navigationevent/NavigationEventInfo;", "currentIndex", "", "<init>", "(Ljava/util/List;I)V", "()V", "currentInfo", "backInfo", "forwardInfo", "(Landroidx/navigationevent/NavigationEventInfo;Ljava/util/List;Ljava/util/List;)V", "getMergedHistory", "()Ljava/util/List;", "getCurrentIndex", "()I", "equals", "", "other", "hashCode", "toString", "", "navigationevent"}, k=1, mv={2, 0, 0}, xi=0x30) public final class NavigationEventHistory {
    private final int currentIndex;
    private final List mergedHistory;

    public NavigationEventHistory() {
        this(CollectionsKt.emptyList(), -1);
    }

    private NavigationEventHistory(List arg2, int arg3) {
        super();
        this.mergedHistory = arg2;
        this.currentIndex = arg3;
        if((arg2.isEmpty()) && arg3 == -1) {
            return;
        }
        else if(!arg2.isEmpty()) {
            int v1 = arg2.size();
            if(arg3 >= 0 && arg3 < v1) {
                return;
            }
        }

        throw new IllegalArgumentException("Invalid \'NavigationEventHistory\' state:  \'currentIndex\' must be within the bounds of \'mergedHistory\' (or -1 if empty). Received: currentIndex = \'" + arg3 + "\', bounds = \'" + CollectionsKt.getIndices(((Collection)arg2)) + "\'.".toString());
    }

    public NavigationEventHistory(NavigationEventInfo arg8) {
        Intrinsics.checkNotNullParameter(arg8, "currentInfo");
        this(arg8, null, null, 6, null);
    }

    public NavigationEventHistory(NavigationEventInfo arg1, List arg2, List arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        if((arg4 & 4) != 0) {
            arg3 = CollectionsKt.emptyList();
        }

        this(arg1, arg2, arg3);
    }

    public NavigationEventHistory(NavigationEventInfo arg8, List arg9) {
        Intrinsics.checkNotNullParameter(arg8, "currentInfo");
        Intrinsics.checkNotNullParameter(arg9, "backInfo");
        this(arg8, arg9, null, 4, null);
    }

    public NavigationEventHistory(NavigationEventInfo arg4, List arg5, List arg6) {
        Intrinsics.checkNotNullParameter(arg4, "currentInfo");
        Intrinsics.checkNotNullParameter(arg5, "backInfo");
        Intrinsics.checkNotNullParameter(arg6, "forwardInfo");
        List v0 = CollectionsKt.createListBuilder();
        CollectionsKt.addAll(v0, arg5);
        v0.add(arg4);
        CollectionsKt.addAll(v0, ((Iterable)arg6));
        this(CollectionsKt.build(v0), arg5.size());
    }

    public boolean equals(Object arg5) {
        if(this == (((NavigationEventHistory)arg5))) {
            return 1;
        }

        if(arg5 != null) {
            if(this.getClass() != arg5.getClass()) {
            }
            else if(this.currentIndex != ((NavigationEventHistory)arg5).currentIndex) {
                return 0;
            }
            else if(!Intrinsics.areEqual(this.mergedHistory, ((NavigationEventHistory)arg5).mergedHistory)) {
                return 0;
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final List getMergedHistory() {
        return this.mergedHistory;
    }

    public int hashCode() {
        return this.currentIndex * 0x1F + this.mergedHistory.hashCode();
    }

    public String toString() {
        return "NavigationEventHistory(currentIndex=" + this.currentIndex + ", mergedHistory=" + this.mergedHistory + ')';
    }
}

