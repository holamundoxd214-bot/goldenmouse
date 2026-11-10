package com.TryJeanPc.goldenmouse.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\f\u0012\b\b\u0002\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u000E\u0010\u000FJ\t\u0010 \u001A\u00020\u0003HÆ\u0003J\t\u0010!\u001A\u00020\u0005HÆ\u0003J\t\u0010\"\u001A\u00020\u0005HÆ\u0003J\t\u0010#\u001A\u00020\bHÆ\u0003J\t\u0010$\u001A\u00020\nHÆ\u0003J\t\u0010%\u001A\u00020\fHÆ\u0003J\t\u0010&\u001A\u00020\bHÆ\u0003JO\u0010\'\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\bHÆ\u0001J\u0013\u0010(\u001A\u00020\b2\b\u0010)\u001A\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001A\u00020\nHÖ\u0001J\t\u0010,\u001A\u00020\u001DHÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000B\u001A\u00020\f¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\r\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0016R\u0014\u0010\u001C\u001A\u00020\u001DX\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001F¨\u0006-"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/TapComponent;", "Lcom/TryJeanPc/goldenmouse/profile/ControlComponent;", "mode", "Lcom/TryJeanPc/goldenmouse/profile/TapMode;", "touchDurationMs", "", "intervalMs", "repeatEnabled", "", "repeatCount", "", "repeatsPerSecond", "", "advancedTimingEnabled", "<init>", "(Lcom/TryJeanPc/goldenmouse/profile/TapMode;JJZIFZ)V", "getMode", "()Lcom/TryJeanPc/goldenmouse/profile/TapMode;", "getTouchDurationMs", "()J", "getIntervalMs", "getRepeatEnabled", "()Z", "getRepeatCount", "()I", "getRepeatsPerSecond", "()F", "getAdvancedTimingEnabled", "type", "", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class TapComponent implements ControlComponent {
    public static final int $stable;
    private final boolean advancedTimingEnabled;
    private final long intervalMs;
    private final TapMode mode;
    private final int repeatCount;
    private final boolean repeatEnabled;
    private final float repeatsPerSecond;
    private final long touchDurationMs;
    private final String type;

    static {
    }

    public TapComponent(TapMode arg2, long arg3, long arg5, boolean arg7, int arg8, float arg9, boolean arg10, int arg11, DefaultConstructorMarker arg12) {
        boolean v9;
        float v11;
        int v10;
        boolean v12;
        if((arg11 & 1) != 0) {
            arg2 = TapMode.SINGLE;
        }

        if((arg11 & 2) != 0) {
            arg3 = 45;
        }

        if((arg11 & 4) != 0) {
            arg5 = 120;
        }

        if((arg11 & 0x20) != 0) {
            arg9 = 8f;
        }

        if((arg11 & 0x40) != 0) {
            v12 = false;
            v10 = 1;
            v11 = arg9;
            v9 = false;
        }
        else {
            v12 = arg10;
            v11 = arg9;
            v9 = false;
            v10 = 1;
        }

        this(arg2, arg3, arg5, v9, v10, v11, v12);
    }

    public TapComponent(TapMode arg2, long arg3, long arg5, boolean arg7, int arg8, float arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg2, "mode");
        super();
        this.mode = arg2;
        this.touchDurationMs = arg3;
        this.intervalMs = arg5;
        this.repeatEnabled = arg7;
        this.repeatCount = arg8;
        this.repeatsPerSecond = arg9;
        this.advancedTimingEnabled = arg10;
        this.type = "TAP";
    }

    public TapComponent() {
        this(null, 0, 0, false, 0, 0f, false, 0x7F, null);
    }

    public final TapMode component1() {
        return this.mode;
    }

    public final long component2() {
        return this.touchDurationMs;
    }

    public final long component3() {
        return this.intervalMs;
    }

    public final boolean component4() {
        return this.repeatEnabled;
    }

    public final int component5() {
        return this.repeatCount;
    }

    public final float component6() {
        return this.repeatsPerSecond;
    }

    public final boolean component7() {
        return this.advancedTimingEnabled;
    }

    public final TapComponent copy(TapMode arg11, long arg12, long arg14, boolean arg16, int arg17, float arg18, boolean arg19) {
        Intrinsics.checkNotNullParameter(arg11, "mode");
        return new TapComponent(arg11, arg12, arg14, arg16, arg17, arg18, arg19);
    }

    public static TapComponent copy$default(TapComponent arg0, TapMode arg1, long arg2, long arg4, boolean arg6, int arg7, float arg8, boolean arg9, int arg10, Object arg11) {
        if((arg10 & 1) != 0) {
            arg1 = arg0.mode;
        }

        if((arg10 & 2) != 0) {
            arg2 = arg0.touchDurationMs;
        }

        if((arg10 & 4) != 0) {
            arg4 = arg0.intervalMs;
        }

        if((arg10 & 8) != 0) {
            arg6 = arg0.repeatEnabled;
        }

        if((arg10 & 16) != 0) {
            arg7 = arg0.repeatCount;
        }

        if((arg10 & 0x20) != 0) {
            arg8 = arg0.repeatsPerSecond;
        }

        if((arg10 & 0x40) != 0) {
            arg9 = arg0.advancedTimingEnabled;
        }

        return arg0.copy(arg1, arg2, arg4, arg6, arg7, arg8, arg9);
    }

    public boolean equals(Object arg8) {
        if(this == (((TapComponent)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof TapComponent)) {
            return 0;
        }

        if(this.mode != ((TapComponent)arg8).mode) {
            return 0;
        }

        if(this.touchDurationMs != ((TapComponent)arg8).touchDurationMs) {
            return 0;
        }

        if(this.intervalMs != ((TapComponent)arg8).intervalMs) {
            return 0;
        }

        if(this.repeatEnabled != ((TapComponent)arg8).repeatEnabled) {
            return 0;
        }

        if(this.repeatCount != ((TapComponent)arg8).repeatCount) {
            return 0;
        }

        if(Float.compare(this.repeatsPerSecond, ((TapComponent)arg8).repeatsPerSecond) != 0) {
            return 0;
        }

        if(this.advancedTimingEnabled != ((TapComponent)arg8).advancedTimingEnabled) {
            return 0;
        }

        return 1;
    }

    public final boolean getAdvancedTimingEnabled() {
        return this.advancedTimingEnabled;
    }

    public final long getIntervalMs() {
        return this.intervalMs;
    }

    public final TapMode getMode() {
        return this.mode;
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    public final boolean getRepeatEnabled() {
        return this.repeatEnabled;
    }

    public final float getRepeatsPerSecond() {
        return this.repeatsPerSecond;
    }

    public final long getTouchDurationMs() {
        return this.touchDurationMs;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.mode.hashCode() * 0x1F + Long.hashCode(this.touchDurationMs)) * 0x1F + Long.hashCode(this.intervalMs)) * 0x1F + Boolean.hashCode(this.repeatEnabled)) * 0x1F + Integer.hashCode(this.repeatCount)) * 0x1F + Float.hashCode(this.repeatsPerSecond)) * 0x1F + Boolean.hashCode(this.advancedTimingEnabled);
    }

    public String toString() {
        return "TapComponent(mode=" + this.mode + ", touchDurationMs=" + this.touchDurationMs + ", intervalMs=" + this.intervalMs + ", repeatEnabled=" + this.repeatEnabled + ", repeatCount=" + this.repeatCount + ", repeatsPerSecond=" + this.repeatsPerSecond + ", advancedTimingEnabled=" + this.advancedTimingEnabled + ")";
    }
}

