package com.flyfishxu.kadb.queue;

import com.flyfishxu.kadb.exception.AdbStreamClosed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\r¢\u0006\u0002\u0010\u0015J\u000E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\rJ\u000E\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\rJ\b\u0010\u0019\u001A\u00020\u0017H\u0007J\r\u0010\u001A\u001A\u00028\u0000H$¢\u0006\u0002\u0010\u001BJ\u0015\u0010\u001C\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00028\u0000H$¢\u0006\u0002\u0010\u001EJ\u0015\u0010\u001F\u001A\u00020\r2\u0006\u0010\u001D\u001A\u00028\u0000H$¢\u0006\u0002\u0010\u001EJ\u0015\u0010 \u001A\u00020!2\u0006\u0010\u001D\u001A\u00028\u0000H$¢\u0006\u0002\u0010\"J\u001F\u0010#\u001A\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\rH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010$\u001A\u00020\u0017H\u0002R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u000B\u001A \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u000F\u001A&\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2={"Lcom/flyfishxu/kadb/queue/MessageQueue;", "V", "", "<init>", "()V", "readLock", "Ljava/util/concurrent/locks/ReentrantLock;", "queueLock", "queueCond", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "queues", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/Queue;", "openStreams", "", "", "take", "localId", "command", "(II)Ljava/lang/Object;", "startListening", "", "stopListening", "ensureEmpty", "readMessage", "()Ljava/lang/Object;", "getLocalId", "message", "(Ljava/lang/Object;)I", "getCommand", "isCloseCommand", "", "(Ljava/lang/Object;)Z", "poll", "read", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class MessageQueue {
    private final Set openStreams;
    private final Condition queueCond;
    private final ReentrantLock queueLock;
    private final ConcurrentHashMap queues;
    private final ReentrantLock readLock;

    public MessageQueue() {
        super();
        this.readLock = new ReentrantLock();
        ReentrantLock v0 = new ReentrantLock();
        this.queueLock = v0;
        this.queueCond = v0.newCondition();
        this.queues = new ConcurrentHashMap();
        this.openStreams = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public final void ensureEmpty() {
        if(!this.queues.isEmpty()) {
            Set v3 = this.queues.keySet();
            Intrinsics.checkNotNullExpressionValue(v3, "<get-keys>(...)");
            ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), 10));
            Iterator v3_1 = ((Iterable)v3).iterator();
            while(v3_1.hasNext()) {
                String v1 = String.format("%X", Arrays.copyOf(new Object[]{v3_1.next()}, 1));
                Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
                ((Collection)v0).add(v1);
            }

            throw new IllegalStateException("Queues is not empty: " + v0.toString());
        }

        if(this.openStreams.isEmpty()) {
            return;
        }

        throw new IllegalStateException("Check failed.");
    }

    protected abstract int getCommand(Object arg1);

    protected abstract int getLocalId(Object arg1);

    protected abstract boolean isCloseCommand(Object arg1);

    private final Object poll(int arg3, int arg4) {
        Object v0 = this.queues.get(Integer.valueOf(arg3));
        if(v0 != null) {
            Object v4 = ((ConcurrentHashMap)v0).get(Integer.valueOf(arg4));
            v4 = v4 != null ? ((Queue)v4).poll() : null;
            if(v4 == null) {
                if(this.openStreams.contains(Integer.valueOf(arg3))) {
                }
                else {
                    throw new AdbStreamClosed(arg3);
                }
            }

            return v4;
        }

        throw new IllegalStateException("Not listening for localId: " + arg3);
    }

    private final void read() {
        Object v2;
        Object v0 = this.readMessage();
        int v1 = this.getLocalId(v0);
        if(this.isCloseCommand(v0)) {
            this.openStreams.remove(Integer.valueOf(v1));
            return;
        }

        Object v1_1 = this.queues.get(Integer.valueOf(v1));
        if(v1_1 == null) {
            return;
        }

        int v4 = this.getCommand(v0);
        __monitor_enter(v1_1);
        try {
            v2 = ((ConcurrentHashMap)v1_1).get(Integer.valueOf(v4));
            if(v2 != null) {
            }
            else {
                ConcurrentLinkedQueue v2_1 = new ConcurrentLinkedQueue();
                v1_1.put(Integer.valueOf(v4), v2_1);
            }
        }
        catch(Throwable v4_1) {
            __monitor_exit(v1_1);
            throw v4_1;
        }

        __monitor_exit(v1_1);
        ((Queue)v2).add(v0);
    }

    protected abstract Object readMessage();

    public final void startListening(int arg3) {
        this.openStreams.add(Integer.valueOf(arg3));
        this.queues.putIfAbsent(Integer.valueOf(arg3), new ConcurrentHashMap());
    }

    public final void stopListening(int arg3) {
        this.openStreams.remove(Integer.valueOf(arg3));
        this.queues.remove(Integer.valueOf(arg3));
    }

    public final Object take(int arg4, int arg5) {
        ReentrantLock v1_1;
        Object v1;
        while(true) {
            ReentrantLock v0 = this.queueLock;
            v0.lock();
            try {
                v1 = this.poll(arg4, arg5);
                if(v1 == null) {
                    goto label_8;
                }
            }
            catch(Throwable v3) {
                goto label_35;
            }

            if(v0.isHeldByCurrentThread()) {
                v0.unlock();
            }

            return v1;
            try {
            label_8:
                v1_1 = this.readLock;
                if(v1_1.tryLock()) {
                }
                else {
                    goto label_27;
                }
            }
            catch(Throwable v3) {
                goto label_35;
            }

            try {
                this.queueLock.unlock();
                this.read();
                this.queueLock.lock();
                this.queueCond.signalAll();
                goto label_18;
            }
            catch(Throwable v3) {
                try {
                    if(v1_1.isHeldByCurrentThread()) {
                        v1_1.unlock();
                    }

                    throw v3;
                label_18:
                    if(!v1_1.isHeldByCurrentThread()) {
                        goto label_29;
                    }

                    v1_1.unlock();
                    goto label_29;
                label_27:
                    this.queueCond.await();
                }
                catch(Throwable v3) {
                label_35:
                    if(v0.isHeldByCurrentThread()) {
                        v0.unlock();
                    }

                    throw v3;
                }
            }

        label_29:
            if(!v0.isHeldByCurrentThread()) {
                continue;
            }

            v0.unlock();
        }
    }
}

