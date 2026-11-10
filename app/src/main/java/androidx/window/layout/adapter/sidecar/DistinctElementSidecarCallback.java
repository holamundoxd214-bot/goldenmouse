package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface$SidecarCallback;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

public class DistinctElementSidecarCallback implements SidecarInterface$SidecarCallback {
    private final Map mActivityWindowLayoutInfo;
    private final SidecarAdapter mAdapter;
    private final SidecarInterface$SidecarCallback mCallback;
    private SidecarDeviceState mLastDeviceState;
    private final Object mLock;

    DistinctElementSidecarCallback(SidecarAdapter arg2, SidecarInterface$SidecarCallback arg3) {
        super();
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = arg2;
        this.mCallback = arg3;
    }

    public DistinctElementSidecarCallback(SidecarInterface$SidecarCallback arg2) {
        super();
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = new SidecarAdapter();
        this.mCallback = arg2;
    }

    public void onDeviceStateChanged(SidecarDeviceState arg4) {
        if(arg4 == null) {
            return;
        }

        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            if(this.mAdapter.isEqualSidecarDeviceState(this.mLastDeviceState, arg4)) {
                __monitor_exit(v0);
                return;
            }

            this.mLastDeviceState = arg4;
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            try {
            label_16:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_16;
            }

            throw v3;
        }

        this.mCallback.onDeviceStateChanged(arg4);
    }

    public void onWindowLayoutChanged(IBinder arg4, SidecarWindowLayoutInfo arg5) {
        Object v0 = this.mLock;
        __monitor_enter(v0);
        try {
            if(this.mAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(arg4), arg5)) {
                __monitor_exit(v0);
                return;
            }

            this.mActivityWindowLayoutInfo.put(arg4, arg5);
            __monitor_exit(v0);
        }
        catch(Throwable v3) {
            try {
            label_16:
                __monitor_exit(v0);
            }
            catch(Throwable v3) {
                goto label_16;
            }

            throw v3;
        }

        this.mCallback.onWindowLayoutChanged(arg4, arg5);
    }
}

