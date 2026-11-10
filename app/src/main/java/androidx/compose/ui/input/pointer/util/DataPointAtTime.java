package androidx.compose.ui.input.pointer.util;

import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u001A"}, d2={"Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "", "time", "", "dataPoint", "", "<init>", "(JF)V", "getTime", "()J", "setTime", "(J)V", "getDataPoint", "()F", "setDataPoint", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DataPointAtTime {
    public static final int $stable = 8;
    private float dataPoint;
    private long time;

    static {
    }

    public DataPointAtTime(long arg1, float arg3) {
        super();
        this.time = arg1;
        this.dataPoint = arg3;
    }

    public final long component1() {
        return this.time;
    }

    public final float component2() {
        return this.dataPoint;
    }

    public final DataPointAtTime copy(long arg1, float arg3) {
        return new DataPointAtTime(arg1, arg3);
    }

    public static DataPointAtTime copy$default(DataPointAtTime arg0, long arg1, float arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.time;
        }

        if((arg4 & 2) != 0) {
            arg3 = arg0.dataPoint;
        }

        return arg0.copy(arg1, arg3);
    }

    public boolean equals(Object arg8) {
        if(this == (((DataPointAtTime)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof DataPointAtTime)) {
            return 0;
        }

        if(this.time != ((DataPointAtTime)arg8).time) {
            return 0;
        }

        if(Float.compare(this.dataPoint, ((DataPointAtTime)arg8).dataPoint) != 0) {
            return 0;
        }

        return 1;
    }

    public final float getDataPoint() {
        return this.dataPoint;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        return Long.hashCode(this.time) * 0x1F + Float.hashCode(this.dataPoint);
    }

    public final void setDataPoint(float arg1) {
        this.dataPoint = arg1;
    }

    public final void setTime(long arg1) {
        this.time = arg1;
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.time + ", dataPoint=" + this.dataPoint + ')';
    }
}

