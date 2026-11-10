package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0015\u001A\u00020\f2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\u0017\u001A\u00020\u0005H\u0010¢\u0006\u0002\b\u0018J\'\u0010\u0019\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u00122\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0010¢\u0006\u0002\b\u001AJ\b\u0010\u001B\u001A\u00020\fH\u0002J\u001B\u0010\u001C\u001A\u00020\f2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0010¢\u0006\u0002\b\u001DJ\r\u0010\u001E\u001A\u00020\fH\u0010¢\u0006\u0002\b\u001FJ\r\u0010 \u001A\u00020\fH\u0010¢\u0006\u0002\b!J\u0006\u0010\"\u001A\u00020#R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\"\u0010\n\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2={"Landroidx/compose/runtime/SingleSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", "soleWatchedObject", "", "workingSoleWatchedObject", "watchSet", "Landroidx/collection/MutableScatterSet;", "workingWatchSet", "subscribedChannel", "Lkotlinx/coroutines/channels/SendChannel;", "", "getSubscribedChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "setSubscribedChannel", "(Lkotlinx/coroutines/channels/SendChannel;)V", "readObserverCache", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSetImpl", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "promote", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SingleSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    private final Function1 readObserverCache;
    private Object soleWatchedObject;
    private SendChannel subscribedChannel;
    private final ObserverHandle unregisterApplyObserver;
    private MutableScatterSet watchSet;
    private Object workingSoleWatchedObject;
    private MutableScatterSet workingWatchSet;

    public SingleSubscriptionSnapshotFlowManager() {
        super();
        this.readObserverCache = new SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0(this);
        this.unregisterApplyObserver = Snapshot.Companion.registerApplyObserver(new SingleSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1(this));
    }

    public void clearWatchSet$runtime(SendChannel arg1) {
        this.clearWatchSetImpl();
    }

    private final void clearWatchSetImpl() {
        this.workingSoleWatchedObject = null;
        this.workingWatchSet = null;
    }

    public void commitSubscriptionChanges$runtime() {
        Object v0 = this.getLock();
        __monitor_enter(v0);
        try {
            this.soleWatchedObject = this.workingSoleWatchedObject;
            if(this.workingWatchSet == null) {
                this.watchSet = null;
            }
            else {
                MutableScatterSet v1 = this.watchSet;
                if(v1 == null) {
                    v1 = ScatterSetKt.mutableScatterSetOf();
                    this.watchSet = v1;
                }

                this.watchSet = this.workingWatchSet;
                this.workingWatchSet = v1;
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
    }

    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.clearWatchSetImpl();
        Object v0 = this.getLock();
        __monitor_enter(v0);
        SendChannel v1 = null;
        try {
            this.subscribedChannel = v1;
            this.soleWatchedObject = v1;
            this.watchSet = ((MutableScatterSet)v1);
        }
        catch(Throwable v2) {
            __monitor_exit(v0);
            throw v2;
        }

        __monitor_exit(v0);
    }

    public final SendChannel getSubscribedChannel() {
        return this.subscribedChannel;
    }

    public final MultiSubscriptionSnapshotFlowManager promote() {
        SingleSubscriptionSnapshotFlowManager v0 = this;
        MultiSubscriptionSnapshotFlowManager v1 = new MultiSubscriptionSnapshotFlowManager();
        SendChannel v2 = v0.subscribedChannel;
        int v4 = v2 != null ? 1 : 0;
        if(v4 == 0) {
            PreconditionsKt.throwIllegalStateException("promote must only be called when a manager is managing subscriptions for one channel and needs to start managing them for a second");
        }

        MutableScatterSet v4_1 = v0.watchSet;
        if(v4_1 == null) {
            Object v3 = v0.soleWatchedObject;
            Intrinsics.checkNotNull(v3);
            v1.watch$runtime(v2, v3);
        }
        else {
            Object[] v5 = ((ScatterSet)v4_1).elements;
            long[] v4_2 = ((ScatterSet)v4_1).metadata;
            int v6 = v4_2.length - 2;
            if(v6 >= 0) {
                int v7;
                for(v7 = 0; true; ++v7) {
                    long v8 = v4_2[v7];
                    if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                        int v11 = 8;
                        int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                        int v12;
                        for(v12 = 0; v12 < v10; ++v12) {
                            if((0xFF & v8) < 0x80) {
                                v1.watch$runtime(v2, v5[(v7 << 3) + v12]);
                            }

                            v8 >>= v11;
                        }

                        if(v10 != v11) {
                            break;
                        }
                    }

                    if(v7 == v6) {
                        break;
                    }
                }
            }
        }

        v1.commitSubscriptionChanges$runtime();
        v0.dispose$runtime();
        return v1;
    }

    static final Unit readObserverCache$lambda$0(SingleSubscriptionSnapshotFlowManager arg1, Object arg2) {
        SendChannel v0 = arg1.subscribedChannel;
        Intrinsics.checkNotNull(v0);
        arg1.watch$runtime(v0, arg2);
        return Unit.INSTANCE;
    }

    public Function1 readObserverFor$runtime(SendChannel arg2) {
        SendChannel v0 = this.subscribedChannel;
        int v0_1 = v0 == null || (Intrinsics.areEqual(v0, arg2)) ? 1 : 0;
        if(v0_1 == 0) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }

        this.subscribedChannel = arg2;
        return this.readObserverCache;
    }

    public final void setSubscribedChannel(SendChannel arg1) {
        this.subscribedChannel = arg1;
    }

    static final Unit unregisterApplyObserver$lambda$0(SingleSubscriptionSnapshotFlowManager arg17, Set arg18, Snapshot arg19) {
        SendChannel v0_2;
        SingleSubscriptionSnapshotFlowManager v0 = arg17;
        Set v1 = arg18;
        Object v2 = v0.getLock();
        __monitor_enter(v2);
        try {
            MutableScatterSet v3 = v0.watchSet;
            if(v3 != null) {
                Object[] v4 = ((ScatterSet)v3).elements;
                long[] v3_1 = ((ScatterSet)v3).metadata;
                int v5 = v3_1.length - 2;
                if(v5 >= 0) {
                    int v7;
                    for(v7 = 0; true; ++v7) {
                        long v8 = v3_1[v7];
                        if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                            int v11 = 8;
                            int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                            int v12;
                            for(v12 = 0; v12 < v10; ++v12) {
                                if((0xFF & v8) < 0x80 && (v1.contains(v4[(v7 << 3) + v12]))) {
                                    v0_2 = v0.subscribedChannel;
                                    goto label_52;
                                }

                                v8 >>= v11;
                            }

                            if(v10 != v11) {
                                goto label_51;
                            }
                        }

                        if(v7 == v5) {
                            goto label_51;
                        }
                    }
                }
                else {
                label_51:
                    v0_2 = null;
                }
            }
            else if(CollectionsKt.contains(((Iterable)v1), v0.soleWatchedObject)) {
                v0_2 = v0.subscribedChannel;
            }
            else {
                goto label_51;
            }

        label_52:
        }
        catch(Throwable v0_1) {
            __monitor_exit(v2);
            throw v0_1;
        }

        __monitor_exit(v2);
        if(v0_2 != null) {
            ChannelResult.box-impl(v0_2.trySend-JP2dKIU(Unit.INSTANCE));
        }

        return Unit.INSTANCE;
    }

    public void watch$runtime(SendChannel arg2, Object arg3) {
        if(!Intrinsics.areEqual(this.subscribedChannel, arg2)) {
            PreconditionsKt.throwIllegalStateException("Requested a SingleSubscriptionSnapshotFlowManager to manage multiple subscriptions");
        }

        MutableScatterSet v2 = this.workingWatchSet;
        Object v0 = this.workingSoleWatchedObject;
        if(v2 == null) {
            if(v0 == null) {
                this.workingSoleWatchedObject = arg3;
                return;
            }

            v2 = ScatterSetKt.mutableScatterSetOf();
            v2.add(v0);
            v2.add(arg3);
            this.workingWatchSet = v2;
            this.workingSoleWatchedObject = null;
            return;
        }

        int v1 = v0 == null ? 1 : 0;
        if(v1 == 0) {
            PreconditionsKt.throwIllegalStateException("workingSoleWatchedObject must be null when workingWatchSet is non-null");
        }

        v2.add(arg3);
    }
}

