package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class AsyncListDiffer {
    public interface ListListener {
        void onCurrentListChanged(List arg1, List arg2);
    }

    class MainThreadExecutor implements Executor {
        final Handler mHandler;

        MainThreadExecutor() {
            super();
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        public void execute(Runnable arg1) {
            this.mHandler.post(arg1);
        }
    }

    final AsyncDifferConfig mConfig;
    private List mList;
    private final List mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;
    private static final Executor sMainThreadExecutor;

    static {
        AsyncListDiffer.sMainThreadExecutor = new MainThreadExecutor();
    }

    public AsyncListDiffer(ListUpdateCallback arg2, AsyncDifferConfig arg3) {
        super();
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = arg2;
        this.mConfig = arg3;
        if(arg3.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = arg3.getMainThreadExecutor();
            return;
        }

        this.mMainThreadExecutor = AsyncListDiffer.sMainThreadExecutor;
    }

    public AsyncListDiffer(Adapter arg2, ItemCallback arg3) {
        this(new AdapterListUpdateCallback(arg2), new Builder(arg3).build());
    }

    public void addListListener(ListListener arg1) {
        this.mListeners.add(arg1);
    }

    public List getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(List arg2, DiffResult arg3, Runnable arg4) {
        List v0 = this.mReadOnlyList;
        this.mList = arg2;
        this.mReadOnlyList = Collections.unmodifiableList(arg2);
        arg3.dispatchUpdatesTo(this.mUpdateCallback);
        this.onCurrentListChanged(v0, arg4);
    }

    private void onCurrentListChanged(List arg4, Runnable arg5) {
        Iterator v0 = this.mListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onCurrentListChanged(arg4, this.mReadOnlyList);
        }

        if(arg5 != null) {
            arg5.run();
        }
    }

    public void removeListListener(ListListener arg1) {
        this.mListeners.remove(arg1);
    }

    public void submitList(List arg2) {
        this.submitList(arg2, null);
    }

    public void submitList(List arg8, Runnable arg9) {
        int v5 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = v5;
        List v3 = this.mList;
        if(arg8 == v3) {
            if(arg9 != null) {
                arg9.run();
            }

            return;
        }

        List v0 = this.mReadOnlyList;
        if(arg8 == null) {
            int v8 = v3.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, v8);
            this.onCurrentListChanged(v0, arg9);
            return;
        }

        if(v3 == null) {
            this.mList = arg8;
            this.mReadOnlyList = Collections.unmodifiableList(arg8);
            this.mUpdateCallback.onInserted(0, arg8.size());
            this.onCurrentListChanged(v0, arg9);
            return;
        }

        this.mConfig.getBackgroundThreadExecutor().execute(new Runnable(v3, arg8, v5, arg9) {
            public void run() {
                AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable(DiffUtil.calculateDiff(new Callback() {
                    public boolean areContentsTheSame(int arg2, int arg3) {
                        Object v2 = this.this$1.val$oldList.get(arg2);
                        Object v3 = this.this$1.val$newList.get(arg3);
                        if(v2 != null && v3 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().areContentsTheSame(v2, v3);
                        }

                        if(v2 == null && v3 == null) {
                            return 1;
                        }

                        throw new AssertionError();
                    }

                    public boolean areItemsTheSame(int arg2, int arg3) {
                        Object v2 = this.this$1.val$oldList.get(arg2);
                        Object v3 = this.this$1.val$newList.get(arg3);
                        if(v2 != null && v3 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().areItemsTheSame(v2, v3);
                        }

                        if(v2 == null && v3 == null) {
                            return 1;
                        }

                        return 0;
                    }

                    public Object getChangePayload(int arg2, int arg3) {
                        Object v2 = this.this$1.val$oldList.get(arg2);
                        Object v3 = this.this$1.val$newList.get(arg3);
                        if(v2 != null && v3 != null) {
                            return this.this$1.this$0.mConfig.getDiffCallback().getChangePayload(v2, v3);
                        }

                        throw new AssertionError();
                    }

                    public int getNewListSize() {
                        return this.this$1.val$newList.size();
                    }

                    public int getOldListSize() {
                        return this.this$1.val$oldList.size();
                    }
                })) {
                    public void run() {
                        if(this.this$1.this$0.mMaxScheduledGeneration == this.this$1.val$runGeneration) {
                            this.this$1.this$0.latchList(this.this$1.val$newList, this.val$result, this.this$1.val$commitCallback);
                        }
                    }
                });
            }
        });
    }
}

