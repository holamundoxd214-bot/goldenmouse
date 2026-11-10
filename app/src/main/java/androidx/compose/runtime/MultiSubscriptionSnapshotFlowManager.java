package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0014\u001A\u00020\b2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0016\u001A\u00020\u0006H\u0010¢\u0006\u0002\b\u0017J\'\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u0019J\u001B\u0010\u001A\u001A\u00020\b2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0010¢\u0006\u0002\b\u001BJ\r\u0010\u001C\u001A\u00020\bH\u0010¢\u0006\u0002\b\u001DJ\r\u0010\u001E\u001A\u00020\bH\u0010¢\u0006\u0002\b\u001FR\"\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000EX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000F\u001A \u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager;", "Landroidx/compose/runtime/SnapshotFlowManagerImpl;", "<init>", "()V", "subscriptions", "Landroidx/compose/runtime/collection/ScopeMap;", "", "Lkotlinx/coroutines/channels/SendChannel;", "", "Landroidx/collection/MutableScatterMap;", "pendingChanges", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "toNotify", "Landroidx/collection/MutableScatterSet;", "readObserverCache", "Landroidx/collection/MutableScatterMap;", "Lkotlin/Function1;", "unregisterApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "watch", "channel", "obj", "watch$runtime", "readObserverFor", "readObserverFor$runtime", "clearWatchSet", "clearWatchSet$runtime", "commitSubscriptionChanges", "commitSubscriptionChanges$runtime", "dispose", "dispose$runtime", "SubscriptionChange", "Add", "RemoveScope", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class MultiSubscriptionSnapshotFlowManager extends SnapshotFlowManagerImpl {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\r"}, d2={"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "obj", "", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/SendChannel;)V", "getObj", "()Ljava/lang/Object;", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class Add implements SubscriptionChange {
        private final SendChannel channel;
        private final Object obj;

        public Add(Object arg1, SendChannel arg2) {
            super();
            this.obj = arg1;
            this.channel = arg2;
        }

        public final SendChannel getChannel() {
            return this.channel;
        }

        public final Object getObj() {
            return this.obj;
        }
    }

    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "", "<init>", "(Lkotlinx/coroutines/channels/SendChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class RemoveScope implements SubscriptionChange {
        private final SendChannel channel;

        public RemoveScope(SendChannel arg1) {
            super();
            this.channel = arg1;
        }

        public final SendChannel getChannel() {
            return this.channel;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001\u0082\u0001\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2={"Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$SubscriptionChange;", "", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$Add;", "Landroidx/compose/runtime/MultiSubscriptionSnapshotFlowManager$RemoveScope;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) interface SubscriptionChange {
    }

    private final List pendingChanges;
    private final MutableScatterMap readObserverCache;
    private MutableScatterMap subscriptions;
    private final MutableScatterSet toNotify;
    private final ObserverHandle unregisterApplyObserver;

    public static Unit $r8$lambda$xNNEdMVot8VHS-aAteXRpilElDA(Set arg0, MultiSubscriptionSnapshotFlowManager arg1, Object arg2) {
        return MultiSubscriptionSnapshotFlowManager.unregisterApplyObserver$lambda$0$0$0(arg0, arg1, arg2);
    }

    public MultiSubscriptionSnapshotFlowManager() {
        super();
        this.subscriptions = ScopeMap.constructor-impl$default(null, 1, null);
        this.pendingChanges = new ArrayList();
        this.toNotify = ScatterSetKt.mutableScatterSetOf();
        this.readObserverCache = ScatterMapKt.mutableScatterMapOf();
        this.unregisterApplyObserver = Snapshot.Companion.registerApplyObserver(new MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda2(this));
    }

    public void clearWatchSet$runtime(SendChannel arg2) {
        this.pendingChanges.add(new RemoveScope(arg2));
    }

    public void commitSubscriptionChanges$runtime() {
        Object v0 = this.getLock();
        __monitor_enter(v0);
        try {
            List v1 = this.pendingChanges;
            int v2 = v1.size();
            int v3;
            for(v3 = 0; true; ++v3) {
                if(v3 >= v2) {
                    goto label_26;
                }

                Object v4 = v1.get(v3);
                if((v4 instanceof Add)) {
                    ScopeMap.add-impl(this.subscriptions, v4.getObj(), ((Add)v4).getChannel());
                }
                else if((v4 instanceof RemoveScope)) {
                    ScopeMap.removeScope-impl(this.subscriptions, ((RemoveScope)v4).getChannel());
                }
                else {
                    break;
                }
            }

            throw new NoWhenBranchMatchedException();
        label_26:
        }
        catch(Throwable v7) {
            goto label_32;
        }

        __monitor_exit(v0);
        this.pendingChanges.clear();
        return;
    label_32:
        __monitor_exit(v0);
        throw v7;
    }

    public void dispose$runtime() {
        this.unregisterApplyObserver.dispose();
        this.pendingChanges.clear();
        this.readObserverCache.clear();
        Object v0 = this.getLock();
        __monitor_enter(v0);
        try {
            ScopeMap.clear-impl(this.subscriptions);
        }
        catch(Throwable v1) {
            __monitor_exit(v0);
            throw v1;
        }

        __monitor_exit(v0);
    }

    static final Unit readObserverFor$lambda$0(MultiSubscriptionSnapshotFlowManager arg0, SendChannel arg1, Object arg2) {
        arg0.watch$runtime(arg1, arg2);
        return Unit.INSTANCE;
    }

    public Function1 readObserverFor$runtime(SendChannel arg2) {
        Object v0 = this.readObserverCache.get(arg2);
        if(v0 == null) {
            MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0 v0_1 = new MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda0(this, arg2);
            this.readObserverCache.put(arg2, v0_1);
        }

        return ((Function1)v0);
    }

    static final Unit unregisterApplyObserver$lambda$0(MultiSubscriptionSnapshotFlowManager arg13, Set arg14, Snapshot arg15) {
        Object v15 = arg13.getLock();
        __monitor_enter(v15);
        try {
            ScopeMap.forEachKey-impl(arg13.subscriptions, new MultiSubscriptionSnapshotFlowManager$$ExternalSyntheticLambda1(arg14, arg13));
            MutableScatterSet v14 = arg13.toNotify;
            Object[] v0 = ((ScatterSet)v14).elements;
            long[] v14_1 = ((ScatterSet)v14).metadata;
            int v1 = v14_1.length - 2;
            if(v1 >= 0) {
                int v3;
                for(v3 = 0; true; ++v3) {
                    long v4 = v14_1[v3];
                    if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                        int v7 = 8;
                        int v6 = 8 - (~(v3 - v1) >>> 0x1F);
                        int v8;
                        for(v8 = 0; v8 < v6; ++v8) {
                            if((0xFF & v4) < 0x80) {
                                v0[(v3 << 3) + v8].trySend-JP2dKIU(Unit.INSTANCE);
                            }

                            v4 >>= v7;
                        }

                        if(v6 != v7) {
                            break;
                        }
                    }

                    if(v3 == v1) {
                        break;
                    }
                }
            }

            arg13.toNotify.clear();
        }
        catch(Throwable v13) {
            __monitor_exit(v15);
            throw v13;
        }

        __monitor_exit(v15);
        return Unit.INSTANCE;
    }

    private static final Unit unregisterApplyObserver$lambda$0$0$0(Set arg12, MultiSubscriptionSnapshotFlowManager arg13, Object arg14) {
        if(arg12.contains(arg14)) {
            Object v12 = arg13.subscriptions.get(arg14);
            if(v12 != null) {
                if((v12 instanceof MutableScatterSet)) {
                    Object[] v14 = ((ScatterSet)v12).elements;
                    long[] v12_1 = ((ScatterSet)v12).metadata;
                    int v0 = v12_1.length - 2;
                    if(v0 >= 0) {
                        int v2;
                        for(v2 = 0; true; ++v2) {
                            long v3 = v12_1[v2];
                            if((~v3 << 7 & v3 & -9187201950435737472L) != -9187201950435737472L) {
                                int v6 = 8;
                                int v5 = 8 - (~(v2 - v0) >>> 0x1F);
                                int v7;
                                for(v7 = 0; v7 < v5; ++v7) {
                                    if((0xFF & v3) < 0x80) {
                                        arg13.toNotify.add(v14[(v2 << 3) + v7]);
                                    }

                                    v3 >>= v6;
                                }

                                if(v5 != v6) {
                                    break;
                                }
                            }

                            if(v2 == v0) {
                                break;
                            }
                        }
                    }
                }
                else {
                    arg13.toNotify.add(v12);
                }
            }
        }

        return Unit.INSTANCE;
    }

    public void watch$runtime(SendChannel arg2, Object arg3) {
        this.pendingChanges.add(new Add(arg3, arg2));
    }
}

