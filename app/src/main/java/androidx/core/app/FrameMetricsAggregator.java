package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window$OnFrameMetricsAvailableListener;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameMetricsAggregator {
    class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        class androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1 implements Window$OnFrameMetricsAvailableListener {
            androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1(FrameMetricsApi24Impl arg1) {
                FrameMetricsApi24Impl.this = arg1;
                super();
            }

            public void onFrameMetricsAvailable(Window arg9, FrameMetrics arg10, int arg11) {
                int v1 = 8;
                if((FrameMetricsApi24Impl.this.mTrackingFlags & 1) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[0], arg10.getMetric(v1));
                }

                int v2 = 2;
                if((FrameMetricsApi24Impl.this.mTrackingFlags & v2) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[1], arg10.getMetric(1));
                }

                arg11 = 4;
                int v3 = 3;
                if((FrameMetricsApi24Impl.this.mTrackingFlags & arg11) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[v2], arg10.getMetric(v3));
                }

                if((FrameMetricsApi24Impl.this.mTrackingFlags & v1) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[v3], arg10.getMetric(arg11));
                }

                v3 = 5;
                if((FrameMetricsApi24Impl.this.mTrackingFlags & 16) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[arg11], arg10.getMetric(v3));
                }

                arg11 = 7;
                int v4 = 6;
                if((FrameMetricsApi24Impl.this.mTrackingFlags & 0x40) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[v4], arg10.getMetric(arg11));
                }

                if((FrameMetricsApi24Impl.this.mTrackingFlags & 0x20) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[v3], arg10.getMetric(v4));
                }

                if((FrameMetricsApi24Impl.this.mTrackingFlags & 0x80) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[arg11], arg10.getMetric(0));
                }

                if((FrameMetricsApi24Impl.this.mTrackingFlags & 0x100) != 0) {
                    FrameMetricsApi24Impl.this.addDurationItem(FrameMetricsApi24Impl.this.mMetrics[v1], arg10.getMetric(v2));
                }
            }
        }

        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private final ArrayList mActivities;
        Window$OnFrameMetricsAvailableListener mListener;
        SparseIntArray[] mMetrics;
        int mTrackingFlags;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;

        static {
        }

        FrameMetricsApi24Impl(int arg2) {
            super();
            this.mMetrics = new SparseIntArray[9];
            this.mActivities = new ArrayList();
            this.mListener = new androidx.core.app.FrameMetricsAggregator$FrameMetricsApi24Impl$1(this);
            this.mTrackingFlags = arg2;
        }

        public void add(Activity arg5) {
            if(FrameMetricsApi24Impl.sHandlerThread == null) {
                HandlerThread v0 = new HandlerThread("FrameMetricsAggregator");
                FrameMetricsApi24Impl.sHandlerThread = v0;
                v0.start();
                FrameMetricsApi24Impl.sHandler = new Handler(FrameMetricsApi24Impl.sHandlerThread.getLooper());
            }

            int v0_1;
            for(v0_1 = 0; v0_1 <= 8; ++v0_1) {
                SparseIntArray[] v1 = this.mMetrics;
                if(v1[v0_1] == null && (this.mTrackingFlags & 1 << v0_1) != 0) {
                    v1[v0_1] = new SparseIntArray();
                }
            }

            arg5.getWindow().addOnFrameMetricsAvailableListener(this.mListener, FrameMetricsApi24Impl.sHandler);
            this.mActivities.add(new WeakReference(arg5));
        }

        void addDurationItem(SparseIntArray arg5, long arg6) {
            if(arg5 != null) {
                int v4 = ((int)((500000 + arg6) / 1000000));
                if(arg6 >= 0) {
                    arg5.put(v4, arg5.get(v4) + 1);
                }
            }
        }

        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        public SparseIntArray[] remove(Activity arg4) {
            Object v1;
            Iterator v0 = this.mActivities.iterator();
            do {
                if(v0.hasNext()) {
                    v1 = v0.next();
                    if(((WeakReference)v1).get() != arg4) {
                        continue;
                    }

                    break;
                }

                goto label_9;
            }
            while(true);

            this.mActivities.remove(v1);
        label_9:
            arg4.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        public SparseIntArray[] reset() {
            SparseIntArray[] v0 = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return v0;
        }

        public SparseIntArray[] stop() {
            int v0;
            for(v0 = this.mActivities.size() - 1; v0 >= 0; --v0) {
                Object v1 = this.mActivities.get(v0);
                Object v2 = ((WeakReference)v1).get();
                if(((WeakReference)v1).get() != null) {
                    ((Activity)v2).getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                    this.mActivities.remove(v0);
                }
            }

            return this.mMetrics;
        }
    }

    class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
            super();
        }

        public void add(Activity arg1) {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity arg1) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface MetricType {
    }

    public static final int ANIMATION_DURATION = 0x100;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 0x20;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 0x80;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 0x1FF;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 0x40;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX;
    private final FrameMetricsBaseImpl mInstance;

    public FrameMetricsAggregator() {
        this(1);
    }

    public FrameMetricsAggregator(int arg2) {
        super();
        this.mInstance = new FrameMetricsApi24Impl(arg2);
    }

    public void add(Activity arg1) {
        this.mInstance.add(arg1);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    public SparseIntArray[] remove(Activity arg1) {
        return this.mInstance.remove(arg1);
    }

    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }
}

