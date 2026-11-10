package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u001D\b\u0000\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\u0016\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001AJ\u0006\u0010\u001B\u001A\u00020\u001AJ\u000E\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001AJ\u0006\u0010\u001D\u001A\u00020\u0016J \u0010\u001E\u001A\u00020\u001A2\u0006\u0010\u001F\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u00122\u0006\u0010!\u001A\u00020\u000BH\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u000E\u0010\u0010\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D;", "", "isDataDifferential", "", "strategy", "Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "<init>", "(ZLandroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;)V", "(Z)V", "()Z", "minSampleSize", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "[Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "index", "reusableDataPointsArray", "", "reusableTimeArray", "reusableVelocityCoefficients", "addDataPoint", "", "timeMillis", "", "dataPoint", "", "calculateVelocity", "maximumVelocity", "resetTracking", "calculateLeastSquaresVelocity", "dataPoints", "time", "sampleCount", "Strategy", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class VelocityTracker1D {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2={"Landroidx/compose/ui/input/pointer/util/VelocityTracker1D$Strategy;", "", "<init>", "(Ljava/lang/String;I)V", "Lsq2", "Impulse", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public enum Strategy {
        public static final enum Strategy Impulse;
        public static final enum Strategy Lsq2;

        private static final Strategy[] $values() {
            return new Strategy[]{Strategy.Lsq2, Strategy.Impulse};
        }

        static {
            Strategy.Lsq2 = new Strategy("Lsq2", 0);
            Strategy.Impulse = new Strategy("Impulse", 1);
            Strategy[] v0 = Strategy.$values();
            Strategy.$VALUES = v0;
            Strategy.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Strategy(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Strategy.$ENTRIES;
        }

        public static Strategy valueOf(String arg1) {
            return Enum.valueOf(Strategy.class, arg1);
        }

        public static Strategy[] values() {
            return Strategy.$VALUES.clone();
        }
    }

    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[Strategy.values().length];
            try {
                v0[Strategy.Impulse.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[Strategy.Lsq2.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                label_11:
                    WhenMappings.$EnumSwitchMapping$0 = v0;
                    return;
                }
            }
        }
    }

    public static final int $stable = 8;
    private int index;
    private final boolean isDataDifferential;
    private final int minSampleSize;
    private final float[] reusableDataPointsArray;
    private final float[] reusableTimeArray;
    private final float[] reusableVelocityCoefficients;
    private final DataPointAtTime[] samples;
    private final Strategy strategy;

    static {
    }

    public VelocityTracker1D(boolean arg2) {
        this(arg2, Strategy.Impulse);
    }

    public VelocityTracker1D(boolean arg1, Strategy arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = Strategy.Lsq2;
        }

        this(false, arg2);
    }

    public VelocityTracker1D() {
        this(false, null, 3, null);
    }

    public VelocityTracker1D(boolean arg3, Strategy arg4) {
        super();
        this.isDataDifferential = arg3;
        this.strategy = arg4;
        if(arg3) {
            if(!arg4.equals(Strategy.Lsq2)) {
            }
            else {
                throw new IllegalStateException("Lsq2 not (yet) supported for differential axes");
            }
        }

        int v3 = WhenMappings.$EnumSwitchMapping$0[arg4.ordinal()];
        int v0 = 3;
        int v1 = 2;
        if(v3 != 1) {
            if(v3 == v1) {
                v1 = v0;
            }
            else {
                throw new NoWhenBranchMatchedException();
            }
        }

        this.minSampleSize = v1;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[v0];
    }

    public final void addDataPoint(long arg2, float arg4) {
        int v0 = (this.index + 1) % 20;
        this.index = v0;
        VelocityTrackerKt.access$set(this.samples, v0, arg2, arg4);
    }

    private final float calculateLeastSquaresVelocity(float[] arg2, float[] arg3, int arg4) {
        try {
            return VelocityTrackerKt.polyFitLeastSquares(arg3, arg2, arg4, 2, this.reusableVelocityCoefficients)[1];
        }
        catch(IllegalArgumentException ) {
            return 0;
        }
    }

    public final float calculateVelocity(float arg4) {
        int v1 = arg4 > 0f ? 1 : 0;
        if(v1 == 0) {
            InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + arg4);
        }

        float v3 = this.calculateVelocity();
        if(v3 == 0f) {
        }
        else {
            if(Float.isNaN(v3)) {
                return 0;
            }

            goto label_18;
        }

        return 0;
    label_18:
        if(v3 > 0f) {
            return RangesKt.coerceAtMost(v3, arg4);
        }

        return RangesKt.coerceAtLeast(v3, -arg4);
    }

    public final float calculateVelocity() {
        float v14;
        float[] v0 = this.reusableDataPointsArray;
        float[] v1 = this.reusableTimeArray;
        int v2 = this.index;
        DataPointAtTime v3 = this.samples[v2];
        if(v3 == null) {
            return 0;
        }

        int v5 = 0;
        DataPointAtTime v6;
        for(v6 = v3; true; v6 = v10) {
            DataPointAtTime v7 = this.samples[v2];
            if(v7 == null) {
                break;
            }

            float v9 = ((float)(v3.getTime() - v7.getTime()));
            float v6_1 = ((float)Math.abs(v7.getTime() - v6.getTime()));
            DataPointAtTime v10 = this.strategy == Strategy.Lsq2 || (this.isDataDifferential) ? v7 : v3;
            if(v9 > 100f) {
                break;
            }

            if(v6_1 > 40f) {
                break;
            }

            v0[v5] = v7.getDataPoint();
            v1[v5] = -v9;
            int v6_2 = 20;
            if(v2 == 0) {
                v2 = v6_2;
            }

            --v2;
            ++v5;
            if(v5 >= v6_2) {
                break;
            }
        }

        if(v5 >= this.minSampleSize) {
            v2 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
            if(v2 == 1) {
                v14 = VelocityTrackerKt.access$calculateImpulseVelocity(v0, v1, v5, this.isDataDifferential);
            }
            else if(v2 == 2) {
                v14 = this.calculateLeastSquaresVelocity(v0, v1, v5);
            }
            else {
                throw new NoWhenBranchMatchedException();
            }

            return v14 * 1000f;
        }

        return 0;
    }

    public final boolean isDataDifferential() {
        return this.isDataDifferential;
    }

    public final void resetTracking() {
        ArraysKt.fill$default(this.samples, null, 0, 0, 6, null);
        this.index = 0;
    }
}

