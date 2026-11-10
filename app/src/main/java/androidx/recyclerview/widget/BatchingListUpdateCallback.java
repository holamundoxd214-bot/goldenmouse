package androidx.recyclerview.widget;

public class BatchingListUpdateCallback implements ListUpdateCallback {
    private static final int TYPE_ADD = 1;
    private static final int TYPE_CHANGE = 3;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_REMOVE = 2;
    int mLastEventCount;
    Object mLastEventPayload;
    int mLastEventPosition;
    int mLastEventType;
    final ListUpdateCallback mWrapped;

    public BatchingListUpdateCallback(ListUpdateCallback arg2) {
        super();
        this.mLastEventType = 0;
        this.mLastEventPosition = -1;
        this.mLastEventCount = -1;
        this.mLastEventPayload = null;
        this.mWrapped = arg2;
    }

    public void dispatchLastEvent() {
        int v0 = this.mLastEventType;
        if(v0 == 0) {
            return;
        }

        if(v0 == 1) {
            this.mWrapped.onInserted(this.mLastEventPosition, this.mLastEventCount);
        }
        else if(v0 == 2) {
            this.mWrapped.onRemoved(this.mLastEventPosition, this.mLastEventCount);
        }
        else if(v0 != 3) {
        }
        else {
            this.mWrapped.onChanged(this.mLastEventPosition, this.mLastEventCount, this.mLastEventPayload);
        }

        this.mLastEventPayload = null;
        this.mLastEventType = 0;
    }

    public void onChanged(int arg6, int arg7, Object arg8) {
        int v1 = 3;
        if(this.mLastEventType == v1) {
            int v0 = this.mLastEventPosition;
            int v2 = this.mLastEventCount;
            if(arg6 <= v0 + v2) {
                int v3 = arg6 + arg7;
                if(v3 >= v0 && this.mLastEventPayload == arg8) {
                    this.mLastEventPosition = Math.min(arg6, v0);
                    this.mLastEventCount = Math.max(v2 + v0, v3) - this.mLastEventPosition;
                    return;
                }
            }
        }

        this.dispatchLastEvent();
        this.mLastEventPosition = arg6;
        this.mLastEventCount = arg7;
        this.mLastEventPayload = arg8;
        this.mLastEventType = v1;
    }

    public void onInserted(int arg5, int arg6) {
        if(this.mLastEventType == 1) {
            int v0 = this.mLastEventPosition;
            if(arg5 >= v0) {
                int v2 = this.mLastEventCount;
                if(arg5 <= v0 + v2) {
                    this.mLastEventCount = v2 + arg6;
                    this.mLastEventPosition = Math.min(arg5, v0);
                    return;
                }
            }
        }

        this.dispatchLastEvent();
        this.mLastEventPosition = arg5;
        this.mLastEventCount = arg6;
        this.mLastEventType = 1;
    }

    public void onMoved(int arg1, int arg2) {
        this.dispatchLastEvent();
        this.mWrapped.onMoved(arg1, arg2);
    }

    public void onRemoved(int arg4, int arg5) {
        int v1 = 2;
        if(this.mLastEventType == v1) {
            int v0 = this.mLastEventPosition;
            if(v0 >= arg4 && v0 <= arg4 + arg5) {
                this.mLastEventCount += arg5;
                this.mLastEventPosition = arg4;
                return;
            }
        }

        this.dispatchLastEvent();
        this.mLastEventPosition = arg4;
        this.mLastEventCount = arg5;
        this.mLastEventType = v1;
    }
}

