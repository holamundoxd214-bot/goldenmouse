package androidx.activity.compose;

import androidx.navigationevent.NavigationEventInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0014\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÖ\u0083\u0004J\n\u0010\u0012\u001A\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001A\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2={"Landroidx/activity/compose/PredictiveBackHandlerInfo;", "Landroidx/navigationevent/NavigationEventInfo;", "owner", "", "compositeKey", "", "<init>", "(Ljava/lang/Object;J)V", "getOwner", "()Ljava/lang/Object;", "getCompositeKey", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "activity-compose"}, k=1, mv={2, 1, 0}, xi=0x30) final class PredictiveBackHandlerInfo extends NavigationEventInfo {
    private final long compositeKey;
    private final Object owner;

    public PredictiveBackHandlerInfo(Object arg1, long arg2) {
        super();
        this.owner = arg1;
        this.compositeKey = arg2;
    }

    public final Object component1() {
        return this.owner;
    }

    public final long component2() {
        return this.compositeKey;
    }

    public final PredictiveBackHandlerInfo copy(Object arg1, long arg2) {
        return new PredictiveBackHandlerInfo(arg1, arg2);
    }

    public static PredictiveBackHandlerInfo copy$default(PredictiveBackHandlerInfo arg0, Object arg1, long arg2, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.owner;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.compositeKey;
        }

        return arg0.copy(arg1, arg2);
    }

    public boolean equals(Object arg6) {
        if(this == (((PredictiveBackHandlerInfo)arg6))) {
            return 1;
        }

        if(!(arg6 instanceof PredictiveBackHandlerInfo)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.owner, ((PredictiveBackHandlerInfo)arg6).owner)) {
            return 0;
        }

        if(this.compositeKey != ((PredictiveBackHandlerInfo)arg6).compositeKey) {
            return 0;
        }

        return 1;
    }

    public final long getCompositeKey() {
        return this.compositeKey;
    }

    public final Object getOwner() {
        return this.owner;
    }

    public int hashCode() {
        return this.owner.hashCode() * 0x1F + Long.hashCode(this.compositeKey);
    }

    public String toString() {
        return "PredictiveBackHandlerInfo(owner=" + this.owner + ", compositeKey=" + this.compositeKey + ')';
    }
}

