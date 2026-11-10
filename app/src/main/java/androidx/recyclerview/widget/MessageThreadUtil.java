package androidx.recyclerview.widget;

import android.os.Handler;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil implements ThreadUtil {
    class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
            super();
        }

        SyncQueueItem next() {
            SyncQueueItem v0_1;
            __monitor_enter(this);
            try {
                v0_1 = this.mRoot;
                if(v0_1 != null) {
                    goto label_6;
                }
            }
            catch(Throwable v0) {
                goto label_11;
            }

            __monitor_exit(this);
            return null;
            try {
            label_6:
                this.mRoot = v0_1.next;
            }
            catch(Throwable v0) {
                try {
                label_11:
                    __monitor_exit(this);
                }
                catch(Throwable v0) {
                    goto label_11;
                }

                throw v0;
            }

            __monitor_exit(this);
            return v0_1;
        }

        void removeMessages(int arg5) {
            SyncQueueItem v2;
            SyncQueueItem v1;
            SyncQueueItem v0;
            __monitor_enter(this);
            try {
                while(true) {
                    v0 = this.mRoot;
                    if(v0 != null && v0.what == arg5) {
                        v0 = this.mRoot;
                        this.mRoot = v0.next;
                        v0.recycle();
                        continue;
                    }

                    break;
                }

                v0 = this.mRoot;
                if(v0 != null) {
                    v1 = v0.next;
                    while(true) {
                    label_13:
                        if(v1 != null) {
                            v2 = v1.next;
                            if(v1.what == arg5) {
                                v0.next = v2;
                                v1.recycle();
                            }
                            else {
                                goto label_20;
                            }

                            goto label_21;
                        }

                        goto label_23;
                    }
                }

                goto label_23;
            }
            catch(Throwable v5) {
                goto label_26;
            }

        label_20:
            v0 = v1;
        label_21:
            v1 = v2;
            goto label_13;
        label_23:
            __monitor_exit(this);
            return;
            try {
            label_26:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_26;
            }

            throw v5;
        }

        void sendMessage(SyncQueueItem arg3) {
            SyncQueueItem v0;
            __monitor_enter(this);
            try {
                v0 = this.mRoot;
                if(v0 == null) {
                    this.mRoot = arg3;
                    goto label_4;
                }

                goto label_6;
            }
            catch(Throwable v3) {
                goto label_14;
            }

        label_4:
            __monitor_exit(this);
            return;
            try {
            label_6:
                while(v0.next != null) {
                    v0 = v0.next;
                }

                v0.next = arg3;
            }
            catch(Throwable v3) {
                goto label_14;
            }

            __monitor_exit(this);
            return;
            try {
            label_14:
                __monitor_exit(this);
            }
            catch(Throwable v3) {
                goto label_14;
            }

            throw v3;
        }

        void sendMessageAtFrontOfQueue(SyncQueueItem arg2) {
            __monitor_enter(this);
            try {
                arg2.next = this.mRoot;
                this.mRoot = arg2;
            }
            catch(Throwable v2) {
                try {
                label_7:
                    __monitor_exit(this);
                }
                catch(Throwable v2) {
                    goto label_7;
                }

                throw v2;
            }

            __monitor_exit(this);
        }
    }

    class SyncQueueItem {
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        private static SyncQueueItem sPool;
        private static final Object sPoolLock;
        public int what;

        static {
            SyncQueueItem.sPoolLock = new Object();
        }

        SyncQueueItem() {
            super();
        }

        static SyncQueueItem obtainMessage(int arg7, int arg8, int arg9) {
            return SyncQueueItem.obtainMessage(arg7, arg8, arg9, 0, 0, 0, null);
        }

        static SyncQueueItem obtainMessage(int arg7, int arg8, Object arg9) {
            return SyncQueueItem.obtainMessage(arg7, arg8, 0, 0, 0, 0, arg9);
        }

        static SyncQueueItem obtainMessage(int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, Object arg9) {
            Object v0 = SyncQueueItem.sPoolLock;
            __monitor_enter(v0);
            try {
                SyncQueueItem v1 = SyncQueueItem.sPool;
                if(v1 == null) {
                    v1 = new SyncQueueItem();
                }
                else {
                    SyncQueueItem.sPool = v1.next;
                    v1.next = null;
                }

                v1.what = arg3;
                v1.arg1 = arg4;
                v1.arg2 = arg5;
                v1.arg3 = arg6;
                v1.arg4 = arg7;
                v1.arg5 = arg8;
                v1.data = arg9;
                __monitor_exit(v0);
                return v1;
            label_21:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_21;
            }

            throw v3;
        }

        void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object v0 = SyncQueueItem.sPoolLock;
            __monitor_enter(v0);
            try {
                SyncQueueItem v1 = SyncQueueItem.sPool;
                if(v1 != null) {
                    this.next = v1;
                }

                SyncQueueItem.sPool = this;
                __monitor_exit(v0);
                return;
            label_19:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_19;
            }

            throw v2;
        }
    }

    MessageThreadUtil() {
        super();
    }

    public BackgroundCallback getBackgroundProxy(BackgroundCallback arg2) {
        return new BackgroundCallback(arg2) {
            class androidx.recyclerview.widget.MessageThreadUtil$2$1 implements Runnable {
                androidx.recyclerview.widget.MessageThreadUtil$2$1(androidx.recyclerview.widget.MessageThreadUtil$2 arg1) {
                    this.this$1 = arg1;
                    super();
                }

                public void run() {
                    while(true) {
                        SyncQueueItem v0 = this.this$1.mQueue.next();
                        if(v0 == null) {
                            break;
                        }

                        int v1 = v0.what;
                        if(v1 != 1) {
                            int v2 = 3;
                            int v3 = 2;
                            if(v1 != v3) {
                                if(v1 != v2) {
                                    if(v1 != 4) {
                                        Log.e("ThreadUtil", "Unsupported message, what=" + v0.what);
                                        continue;
                                    }

                                    this.this$1.val$callback.recycleTile(v0.data);
                                    continue;
                                }

                                this.this$1.val$callback.loadTile(v0.arg1, v0.arg2);
                                continue;
                            }

                            this.this$1.mQueue.removeMessages(v3);
                            this.this$1.mQueue.removeMessages(v2);
                            this.this$1.val$callback.updateRange(v0.arg1, v0.arg2, v0.arg3, v0.arg4, v0.arg5);
                            continue;
                        }

                        this.this$1.mQueue.removeMessages(1);
                        this.this$1.val$callback.refresh(v0.arg1);
                    }

                    this.this$1.mBackgroundRunning.set(false);
                }
            }

            static final int LOAD_TILE = 3;
            static final int RECYCLE_TILE = 4;
            static final int REFRESH = 1;
            static final int UPDATE_RANGE = 2;
            private Runnable mBackgroundRunnable;
            AtomicBoolean mBackgroundRunning;
            private final Executor mExecutor;
            final MessageQueue mQueue;

            public void loadTile(int arg2, int arg3) {
                this.sendMessage(SyncQueueItem.obtainMessage(3, arg2, arg3));
            }

            private void maybeExecuteBackgroundRunnable() {
                if(this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            public void recycleTile(Tile arg3) {
                this.sendMessage(SyncQueueItem.obtainMessage(4, 0, arg3));
            }

            public void refresh(int arg3) {
                this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, arg3, null));
            }

            private void sendMessage(SyncQueueItem arg2) {
                this.mQueue.sendMessage(arg2);
                this.maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem arg2) {
                this.mQueue.sendMessageAtFrontOfQueue(arg2);
                this.maybeExecuteBackgroundRunnable();
            }

            public void updateRange(int arg8, int arg9, int arg10, int arg11, int arg12) {
                this.sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, arg8, arg9, arg10, arg11, arg12, null));
            }
        };
    }

    public MainThreadCallback getMainThreadProxy(MainThreadCallback arg2) {
        return new MainThreadCallback(arg2) {
            class androidx.recyclerview.widget.MessageThreadUtil$1$1 implements Runnable {
                androidx.recyclerview.widget.MessageThreadUtil$1$1(androidx.recyclerview.widget.MessageThreadUtil$1 arg1) {
                    this.this$1 = arg1;
                    super();
                }

                public void run() {
                    SyncQueueItem v0;
                    for(v0 = this.this$1.mQueue.next(); v0 != null; v0 = this.this$1.mQueue.next()) {
                        int v1 = v0.what;
                        if(v1 == 1) {
                            this.this$1.val$callback.updateItemCount(v0.arg1, v0.arg2);
                        }
                        else if(v1 == 2) {
                            this.this$1.val$callback.addTile(v0.arg1, v0.data);
                        }
                        else if(v1 != 3) {
                            Log.e("ThreadUtil", "Unsupported message, what=" + v0.what);
                        }
                        else {
                            this.this$1.val$callback.removeTile(v0.arg1, v0.arg2);
                        }
                    }
                }
            }

            static final int ADD_TILE = 2;
            static final int REMOVE_TILE = 3;
            static final int UPDATE_ITEM_COUNT = 1;
            private final Handler mMainThreadHandler;
            private Runnable mMainThreadRunnable;
            final MessageQueue mQueue;

            public void addTile(int arg2, Tile arg3) {
                this.sendMessage(SyncQueueItem.obtainMessage(2, arg2, arg3));
            }

            public void removeTile(int arg2, int arg3) {
                this.sendMessage(SyncQueueItem.obtainMessage(3, arg2, arg3));
            }

            private void sendMessage(SyncQueueItem arg2) {
                this.mQueue.sendMessage(arg2);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void updateItemCount(int arg2, int arg3) {
                this.sendMessage(SyncQueueItem.obtainMessage(1, arg2, arg3));
            }
        };
    }
}

