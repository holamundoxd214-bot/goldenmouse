package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0005J\u0006\u0010\u0012\u001A\u00020\u0011R\u001E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\r\u001A\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/GoldenStretchSelection;", "", "<init>", "()V", "value", "", "progress", "getProgress", "()I", "label", "", "getLabel", "()Ljava/lang/String;", "preset", "getPreset", "()Ljava/lang/Integer;", "select", "", "restore", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenStretchSelection {
    public static final int $stable = 8;
    private int progress;

    static {
    }

    public GoldenStretchSelection() {
        super();
        this.progress = 10;
    }

    public final String getLabel() {
        return "1." + StringsKt.padStart(String.valueOf(this.progress), 2, '0') + "×";
    }

    public final Integer getPreset() {
        Integer v2 = Integer.valueOf(this.progress);
        int v0 = v2.intValue();
        if(v0 != 5 && v0 != 10 && v0 != 11) {
            if(v0 == 15) {
            }
            else {
                v2 = null;
            }
        }

        return v2;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void restore() {
        this.progress = 0;
    }

    public final void select(int arg3) {
        this.progress = RangesKt.coerceIn(arg3, 0, 99);
    }
}

