package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u00058V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001A\u0004\b\u000E\u0010\b\"\u0004\b\u000F\u0010\n¨\u0006\u0012"}, d2={"Landroidx/compose/material3/AppBarOverflowStateImpl;", "Landroidx/compose/material3/AppBarOverflowState;", "<init>", "()V", "<set-?>", "", "totalItemCount", "getTotalItemCount", "()I", "setTotalItemCount", "(I)V", "totalItemCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "visibleItemCount", "getVisibleItemCount", "setVisibleItemCount", "visibleItemCount$delegate", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class AppBarOverflowStateImpl implements AppBarOverflowState {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/material3/AppBarOverflowStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/AppBarOverflowStateImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return AppBarOverflowStateImpl.Saver;
        }
    }

    public static final Companion Companion;
    private static final Saver Saver;
    private final MutableIntState totalItemCount$delegate;
    private final MutableIntState visibleItemCount$delegate;

    static {
        AppBarOverflowStateImpl.Companion = new Companion(null);
        AppBarOverflowStateImpl.Saver = SaverKt.Saver(new AppBarOverflowStateImpl$$ExternalSyntheticLambda0(), new AppBarOverflowStateImpl$$ExternalSyntheticLambda1());
    }

    public AppBarOverflowStateImpl() {
        super();
        this.totalItemCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.visibleItemCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    static final List Saver$lambda$0(SaverScope arg2, AppBarOverflowStateImpl arg3) {
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(arg3.getTotalItemCount()), Integer.valueOf(arg3.getVisibleItemCount())});
    }

    static final AppBarOverflowStateImpl Saver$lambda$2(List arg2) {
        AppBarOverflowStateImpl v0 = new AppBarOverflowStateImpl();
        v0.setTotalItemCount(arg2.get(0).intValue());
        v0.setVisibleItemCount(arg2.get(1).intValue());
        return v0;
    }

    public static final Saver access$getSaver$cp() {
        return AppBarOverflowStateImpl.Saver;
    }

    public int getTotalItemCount() {
        return this.totalItemCount$delegate.getIntValue();
    }

    public int getVisibleItemCount() {
        return this.visibleItemCount$delegate.getIntValue();
    }

    public void setTotalItemCount(int arg1) {
        this.totalItemCount$delegate.setIntValue(arg1);
    }

    public void setVisibleItemCount(int arg1) {
        this.visibleItemCount$delegate.setIntValue(arg1);
    }
}

