package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class DifferentialMotionFlingController {
    interface DifferentialVelocityProvider {
        float getCurrentVelocity(VelocityTracker arg1, MotionEvent arg2, int arg3);
    }

    interface FlingVelocityThresholdCalculator {
        void calculateFlingVelocityThresholds(Context arg1, int[] arg2, MotionEvent arg3, int arg4);
    }

    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final DifferentialVelocityProvider mVelocityProvider;
    private final FlingVelocityThresholdCalculator mVelocityThresholdCalculator;
    private VelocityTracker mVelocityTracker;

    public static void $r8$lambda$lv23FpWloyumz6IvnMabmJR9BpE(Context arg0, int[] arg1, MotionEvent arg2, int arg3) {
        DifferentialMotionFlingController.calculateFlingVelocityThresholds(arg0, arg1, arg2, arg3);
    }

    public static float $r8$lambda$rCNQ1h5KBIaVcUXhwymI_1638W0(VelocityTracker arg0, MotionEvent arg1, int arg2) {
        return DifferentialMotionFlingController.getCurrentVelocity(arg0, arg1, arg2);
    }

    public DifferentialMotionFlingController(Context arg3, DifferentialMotionFlingTarget arg4) {
        this(arg3, arg4, new DifferentialMotionFlingController$$ExternalSyntheticLambda0(), new DifferentialMotionFlingController$$ExternalSyntheticLambda1());
    }

    DifferentialMotionFlingController(Context arg3, DifferentialMotionFlingTarget arg4, FlingVelocityThresholdCalculator arg5, DifferentialVelocityProvider arg6) {
        super();
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{0x7FFFFFFF, 0};
        this.mContext = arg3;
        this.mTarget = arg4;
        this.mVelocityThresholdCalculator = arg5;
        this.mVelocityProvider = arg6;
    }

    private static void calculateFlingVelocityThresholds(Context arg3, int[] arg4, MotionEvent arg5, int arg6) {
        ViewConfiguration v0 = ViewConfiguration.get(arg3);
        arg4[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(arg3, v0, arg5.getDeviceId(), arg6, arg5.getSource());
        arg4[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(arg3, v0, arg5.getDeviceId(), arg6, arg5.getSource());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent arg6, int arg7) {
        int v0 = arg6.getSource();
        int v1 = arg6.getDeviceId();
        if(this.mLastProcessedSource == v0 && this.mLastProcessedDeviceId == v1) {
            if(this.mLastProcessedAxis != arg7) {
            }
            else {
                return 0;
            }
        }

        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, arg6, arg7);
        this.mLastProcessedSource = v0;
        this.mLastProcessedDeviceId = v1;
        this.mLastProcessedAxis = arg7;
        return 1;
    }

    private static float getCurrentVelocity(VelocityTracker arg0, MotionEvent arg1, int arg2) {
        VelocityTrackerCompat.addMovement(arg0, arg1);
        VelocityTrackerCompat.computeCurrentVelocity(arg0, 1000);
        return VelocityTrackerCompat.getAxisVelocity(arg0, arg2);
    }

    private float getCurrentVelocity(MotionEvent arg2, int arg3) {
        VelocityTracker v0 = this.mVelocityTracker;
        if(v0 == null) {
            v0 = VelocityTracker.obtain();
            this.mVelocityTracker = v0;
        }

        return this.mVelocityProvider.getCurrentVelocity(v0, arg2, arg3);
    }

    public void onMotionEvent(MotionEvent arg5, int arg6) {
        int[] v0_1;
        float v1;
        float v5_1;
        boolean v0 = this.calculateFlingVelocityThresholds(arg5, arg6);
        if(this.mFlingVelocityThresholds[0] == 0x7FFFFFFF) {
            VelocityTracker v5 = this.mVelocityTracker;
            if(v5 != null) {
                v5.recycle();
                this.mVelocityTracker = null;
                return;
            }
        }
        else {
            v5_1 = this.getCurrentVelocity(arg5, arg6) * this.mTarget.getScaledScrollFactor();
            float v6 = Math.signum(v5_1);
            v1 = 0f;
            if((v0) || v6 != Math.signum(this.mLastFlingVelocity) && v6 != 0f) {
                this.mTarget.stopDifferentialMotionFling();
            }

            v6 = Math.abs(v5_1);
            v0_1 = this.mFlingVelocityThresholds;
            if(v6 >= (((float)v0_1[0]))) {
                goto label_31;
            }
        }

        return;
    label_31:
        v5_1 = Math.max(((float)(-v0_1[1])), Math.min(v5_1, ((float)v0_1[1])));
        if(this.mTarget.startDifferentialMotionFling(v5_1)) {
            v1 = v5_1;
        }

        this.mLastFlingVelocity = v1;
    }
}

