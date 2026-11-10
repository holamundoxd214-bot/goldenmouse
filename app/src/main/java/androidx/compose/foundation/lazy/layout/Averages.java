package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010\u001F\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010 \u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010!\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010\"\u001A\u00020\u001D2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010#\u001A\u00020\u001D2\u0006\u0010$\u001A\u00020\u0017J\u0018\u0010%\u001A\u00020\u00052\u0006\u0010&\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020\u0005H\u0002J\u0018\u0010(\u001A\u00020\u00172\u0006\u0010&\u001A\u00020\u00172\u0006\u0010\'\u001A\u00020\u0017H\u0002J\u0006\u0010)\u001A\u00020\u001DR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001A\u0010\r\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001A\u0010\u0010\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001A\u0010\u0013\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001A\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006*"}, d2={"Landroidx/compose/foundation/lazy/layout/Averages;", "", "<init>", "()V", "compositionTimeNanos", "", "getCompositionTimeNanos", "()J", "setCompositionTimeNanos", "(J)V", "resumeTimeNanos", "getResumeTimeNanos", "setResumeTimeNanos", "pauseTimeNanos", "getPauseTimeNanos", "setPauseTimeNanos", "applyTimeNanos", "getApplyTimeNanos", "setApplyTimeNanos", "measureTimeNanos", "getMeasureTimeNanos", "setMeasureTimeNanos", "nestedPrefetchCount", "", "getNestedPrefetchCount", "()I", "setNestedPrefetchCount", "(I)V", "saveCompositionTimeNanos", "", "timeNanos", "saveResumeTimeNanos", "savePauseTimeNanos", "saveApplyTimeNanos", "saveMeasureTimeNanos", "saveNestedPrefetchCount", "count", "calculateAverageTime", "new", "current", "calculateAverageCount", "clearMeasureTime", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Averages {
    public static final int $stable = 8;
    private long applyTimeNanos;
    private long compositionTimeNanos;
    private long measureTimeNanos;
    private int nestedPrefetchCount;
    private long pauseTimeNanos;
    private long resumeTimeNanos;

    static {
    }

    public Averages() {
        super();
        this.nestedPrefetchCount = -1;
    }

    private final int calculateAverageCount(int arg1, int arg2) {
        if(arg2 == -1) {
            return arg1;
        }

        return (arg2 * 3 + arg1) / 4;
    }

    private final long calculateAverageTime(long arg5, long arg7) {
        if(arg7 == 0) {
            return arg5;
        }

        return arg7 / 4 * 3 + arg5 / 4;
    }

    public final void clearMeasureTime() {
        this.measureTimeNanos = 0;
    }

    public final long getApplyTimeNanos() {
        return this.applyTimeNanos;
    }

    public final long getCompositionTimeNanos() {
        return this.compositionTimeNanos;
    }

    public final long getMeasureTimeNanos() {
        return this.measureTimeNanos;
    }

    public final int getNestedPrefetchCount() {
        return this.nestedPrefetchCount;
    }

    public final long getPauseTimeNanos() {
        return this.pauseTimeNanos;
    }

    public final long getResumeTimeNanos() {
        return this.resumeTimeNanos;
    }

    public final void saveApplyTimeNanos(long arg3) {
        this.applyTimeNanos = this.calculateAverageTime(arg3, this.applyTimeNanos);
    }

    public final void saveCompositionTimeNanos(long arg3) {
        this.compositionTimeNanos = this.calculateAverageTime(arg3, this.compositionTimeNanos);
    }

    public final void saveMeasureTimeNanos(long arg3) {
        this.measureTimeNanos = this.calculateAverageTime(arg3, this.measureTimeNanos);
    }

    public final void saveNestedPrefetchCount(int arg2) {
        this.nestedPrefetchCount = this.calculateAverageCount(arg2, this.nestedPrefetchCount);
    }

    public final void savePauseTimeNanos(long arg3) {
        this.pauseTimeNanos = this.calculateAverageTime(arg3, this.pauseTimeNanos);
    }

    public final void saveResumeTimeNanos(long arg3) {
        this.resumeTimeNanos = this.calculateAverageTime(arg3, this.resumeTimeNanos);
    }

    public final void setApplyTimeNanos(long arg1) {
        this.applyTimeNanos = arg1;
    }

    public final void setCompositionTimeNanos(long arg1) {
        this.compositionTimeNanos = arg1;
    }

    public final void setMeasureTimeNanos(long arg1) {
        this.measureTimeNanos = arg1;
    }

    public final void setNestedPrefetchCount(int arg1) {
        this.nestedPrefetchCount = arg1;
    }

    public final void setPauseTimeNanos(long arg1) {
        this.pauseTimeNanos = arg1;
    }

    public final void setResumeTimeNanos(long arg1) {
        this.resumeTimeNanos = arg1;
    }
}

