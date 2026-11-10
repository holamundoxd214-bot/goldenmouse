package androidx.compose.material3;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u001A\u0010\u0002\u001A\u00020\u00038gX¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\u00038gX¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000B\u001A\u00020\fX¦\u000E¢\u0006\f\u001A\u0004\b\u000B\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0010\u001A\u00020\u0011X¦\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2={"Landroidx/compose/material3/TimePickerState;", "", "minute", "", "getMinute", "()I", "setMinute", "(I)V", "hour", "getHour", "setHour", "is24hour", "", "()Z", "set24hour", "(Z)V", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TimePickerState {
    int getHour();

    int getMinute();

    int getSelection-yecRtBI();

    boolean is24hour();

    void set24hour(boolean arg1);

    void setHour(int arg1);

    void setMinute(int arg1);

    void setSelection-6_8s6DQ(int arg1);
}

