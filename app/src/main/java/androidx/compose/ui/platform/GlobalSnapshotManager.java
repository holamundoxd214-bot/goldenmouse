package androidx.compose.ui.platform;

import androidx.compose.runtime.snapshots.Snapshot;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001A\u00020\bR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/GlobalSnapshotManager;", "", "<init>", "()V", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sent", "ensureStarted", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class GlobalSnapshotManager {
    public static final int $stable;
    public static final GlobalSnapshotManager INSTANCE;
    private static final AtomicBoolean sent;
    private static final AtomicBoolean started;

    static {
        GlobalSnapshotManager.INSTANCE = new GlobalSnapshotManager();
        GlobalSnapshotManager.started = new AtomicBoolean(false);
        GlobalSnapshotManager.sent = new AtomicBoolean(false);
        GlobalSnapshotManager.$stable = 8;
    }

    private GlobalSnapshotManager() {
        super();
    }

    public static final AtomicBoolean access$getSent$p() {
        return GlobalSnapshotManager.sent;
    }

    public final void ensureStarted() {
        if(GlobalSnapshotManager.started.compareAndSet(false, true)) {
            Channel v8 = ChannelKt.Channel$default(1, null, null, 6, null);
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(AndroidUiDispatcher.Companion.getMain()), null, null, new GlobalSnapshotManager$ensureStarted$1(v8, null), 3, null);
            Snapshot.Companion.registerGlobalWriteObserver(new GlobalSnapshotManager$ensureStarted$2(v8));
        }
    }
}

