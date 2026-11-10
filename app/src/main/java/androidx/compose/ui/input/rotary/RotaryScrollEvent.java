package androidx.compose.ui.input.rotary;

import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001A\u00020\bH\u0016J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2={"Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "verticalScrollPixels", "", "horizontalScrollPixels", "uptimeMillis", "", "inputDeviceId", "", "<init>", "(FFJI)V", "getVerticalScrollPixels", "()F", "getHorizontalScrollPixels", "getUptimeMillis", "()J", "getInputDeviceId", "()I", "equals", "", "other", "hashCode", "toString", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RotaryScrollEvent {
    public static final int $stable;
    private final float horizontalScrollPixels;
    private final int inputDeviceId;
    private final long uptimeMillis;
    private final float verticalScrollPixels;

    static {
    }

    public RotaryScrollEvent(float arg1, float arg2, long arg3, int arg5) {
        super();
        this.verticalScrollPixels = arg1;
        this.horizontalScrollPixels = arg2;
        this.uptimeMillis = arg3;
        this.inputDeviceId = arg5;
    }

    public boolean equals(Object arg5) {
        if(((arg5 instanceof RotaryScrollEvent)) && ((RotaryScrollEvent)arg5).verticalScrollPixels == this.verticalScrollPixels && ((RotaryScrollEvent)arg5).horizontalScrollPixels == this.horizontalScrollPixels && ((RotaryScrollEvent)arg5).uptimeMillis == this.uptimeMillis && ((RotaryScrollEvent)arg5).inputDeviceId == this.inputDeviceId) {
            return 1;
        }

        return 0;
    }

    public final float getHorizontalScrollPixels() {
        return this.horizontalScrollPixels;
    }

    public final int getInputDeviceId() {
        return this.inputDeviceId;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final float getVerticalScrollPixels() {
        return this.verticalScrollPixels;
    }

    public int hashCode() {
        return ((Float.hashCode(this.verticalScrollPixels) * 0x1F + Float.hashCode(this.horizontalScrollPixels)) * 0x1F + Long.hashCode(this.uptimeMillis)) * 0x1F + Integer.hashCode(this.inputDeviceId);
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.verticalScrollPixels + ",horizontalScrollPixels=" + this.horizontalScrollPixels + ",uptimeMillis=" + this.uptimeMillis + ",deviceId=" + this.inputDeviceId + ')';
    }
}

