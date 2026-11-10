package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\u0006X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u000E8V@VX\u0096\u008E\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0016\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001A\u001A\u00020\u0017¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0019R$\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u00038V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u001E\u0010\u0011\"\u0004\b\u001F\u0010\u0013R$\u0010 \u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u00038V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013¨\u0006$"}, d2={"Landroidx/compose/material3/TimePickerStateImpl;", "Landroidx/compose/material3/TimePickerState;", "initialHour", "", "initialMinute", "is24Hour", "", "<init>", "(IIZ)V", "is24hour", "()Z", "set24hour", "(Z)V", "<set-?>", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "getSelection-yecRtBI", "()I", "setSelection-6_8s6DQ", "(I)V", "selection$delegate", "Landroidx/compose/runtime/MutableState;", "hourState", "Landroidx/compose/runtime/MutableIntState;", "getHourState", "()Landroidx/compose/runtime/MutableIntState;", "minuteState", "getMinuteState", "value", "minute", "getMinute", "setMinute", "hour", "getHour", "setHour", "Companion", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) final class TimePickerStateImpl implements TimePickerState {
    @Metadata(d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¨\u0006\u0007"}, d2={"Landroidx/compose/material3/TimePickerStateImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TimePickerStateImpl;", "material3"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver Saver() {
            return SaverKt.Saver(new TimePickerStateImpl$Companion$$ExternalSyntheticLambda0(), new TimePickerStateImpl$Companion$$ExternalSyntheticLambda1());
        }

        static final List Saver$lambda$0(SaverScope arg1, TimePickerStateImpl arg2) {
            return CollectionsKt.listOf(new Object[]{Integer.valueOf(arg2.getHour()), Integer.valueOf(arg2.getMinute()), Boolean.valueOf(arg2.is24hour())});
        }

        static final TimePickerStateImpl Saver$lambda$1(List arg4) {
            Object v1 = arg4.get(0);
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.Int");
            int v1_1 = ((Integer)v1).intValue();
            Object v3 = arg4.get(1);
            Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type kotlin.Int");
            int v2 = ((Integer)v3).intValue();
            Object v4 = arg4.get(2);
            Intrinsics.checkNotNull(v4, "null cannot be cast to non-null type kotlin.Boolean");
            return new TimePickerStateImpl(v1_1, v2, ((Boolean)v4).booleanValue());
        }
    }

    public static final Companion Companion;
    private final MutableIntState hourState;
    private boolean is24hour;
    private final MutableIntState minuteState;
    private final MutableState selection$delegate;

    static {
        TimePickerStateImpl.Companion = new Companion(null);
    }

    public TimePickerStateImpl(int arg3, int arg4, boolean arg5) {
        super();
        if(arg3 >= 0 && arg3 < 24) {
            if(arg4 >= 0 && arg4 < 60) {
                this.is24hour = arg5;
                this.selection$delegate = SnapshotStateKt.mutableStateOf$default(TimePickerSelectionMode.box-impl(TimePickerSelectionMode.Companion.getHour-yecRtBI()), null, 2, null);
                this.hourState = SnapshotIntStateKt.mutableIntStateOf(arg3);
                this.minuteState = SnapshotIntStateKt.mutableIntStateOf(arg4);
                return;
            }

            throw new IllegalArgumentException("initialMinute should be in [0..59] range".toString());
        }

        throw new IllegalArgumentException("initialHour should in [0..23] range".toString());
    }

    public int getHour() {
        return this.hourState.getIntValue();
    }

    public final MutableIntState getHourState() {
        return this.hourState;
    }

    public int getMinute() {
        return this.minuteState.getIntValue();
    }

    public final MutableIntState getMinuteState() {
        return this.minuteState;
    }

    public int getSelection-yecRtBI() {
        return this.selection$delegate.getValue().unbox-impl();
    }

    public boolean is24hour() {
        return this.is24hour;
    }

    public void set24hour(boolean arg1) {
        this.is24hour = arg1;
    }

    public void setHour(int arg1) {
        this.hourState.setIntValue(arg1);
    }

    public void setMinute(int arg1) {
        this.minuteState.setIntValue(arg1);
    }

    public void setSelection-6_8s6DQ(int arg1) {
        this.selection$delegate.setValue(TimePickerSelectionMode.box-impl(arg1));
    }
}

