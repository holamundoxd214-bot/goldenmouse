package com.TryJeanPc.goldenmouse.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0007J\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0007J\u000E\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u0011R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/TapTimingPolicy;", "", "<init>", "()V", "VERSION", "", "MIN_DURATION_MS", "", "MAX_DURATION_MS", "MIN_INTERVAL_MS", "MAX_INTERVAL_MS", "MAX_REPEATS", "durationMs", "value", "intervalMs", "periodMs", "settings", "Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "normalize", "forExecution", "migrateLegacy", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TapTimingPolicy {
    public static final int $stable = 0;
    public static final TapTimingPolicy INSTANCE = null;
    public static final long MAX_DURATION_MS = 5000;
    public static final long MAX_INTERVAL_MS = 60000;
    public static final int MAX_REPEATS = 999;
    public static final long MIN_DURATION_MS = 1;
    public static final long MIN_INTERVAL_MS = 1;
    public static final int VERSION = 1;

    static {
        TapTimingPolicy.INSTANCE = new TapTimingPolicy();
    }

    private TapTimingPolicy() {
        super();
    }

    public final long durationMs(long arg7) {
        return RangesKt.coerceIn(arg7, 1, 5000);
    }

    public final TapComponent forExecution(TapComponent arg14) {
        Intrinsics.checkNotNullParameter(arg14, "settings");
        TapComponent v1 = this.normalize(arg14);
        if((v1.getAdvancedTimingEnabled()) && v1.getMode() != TapMode.HOLD && ((v1.getRepeatEnabled()) || v1.getMode() == TapMode.REPEATING)) {
            return TapComponent.copy$default(v1, null, Math.min(v1.getTouchDurationMs(), v1.getIntervalMs()), 0, false, 0, 0f, false, 0x7D, null);
        }

        return v1;
    }

    public final long intervalMs(long arg7) {
        return RangesKt.coerceIn(arg7, 1, 60000);
    }

    public final TapComponent migrateLegacy(TapComponent arg14) {
        Intrinsics.checkNotNullParameter(arg14, "settings");
        long v3 = RangesKt.coerceIn(arg14.getTouchDurationMs(), 45, 5000);
        long v5 = RangesKt.coerceIn(arg14.getIntervalMs(), 16, 60000);
        Float v0 = Float.valueOf(arg14.getRepeatsPerSecond());
        float v2 = v0.floatValue();
        if(Math.abs(v2) > 3.402823E+38f || v2 <= 0f) {
            v0 = null;
        }
        else {
        }

        float v0_1 = v0 != null ? v0.floatValue() : 8f;
        return this.normalize(TapComponent.copy$default(arg14, null, v3, Math.max(v3, Math.max(v5, ((long)(1000f / RangesKt.coerceIn(v0_1, 1f, 30f))))), false, 0, 0f, false, 0x79, null));
    }

    public final TapComponent normalize(TapComponent arg15) {
        Intrinsics.checkNotNullParameter(arg15, "settings");
        return TapComponent.copy$default(arg15, null, this.durationMs(arg15.getTouchDurationMs()), this.intervalMs(arg15.getIntervalMs()), false, RangesKt.coerceIn(arg15.getRepeatCount(), 1, 999), 0f, false, 105, null);
    }

    public final long periodMs(TapComponent arg5) {
        Intrinsics.checkNotNullParameter(arg5, "settings");
        return Math.max(this.durationMs(arg5.getTouchDurationMs()), this.intervalMs(arg5.getIntervalMs()));
    }
}

