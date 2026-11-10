package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0002X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2={"Landroidx/compose/runtime/LongState;", "Landroidx/compose/runtime/State;", "", "value", "getValue", "()Ljava/lang/Long;", "longValue", "getLongValue", "()J", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface LongState extends State {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Long getValue(LongState arg2) {
            return Long.valueOf(LongState.access$getValue$jd(arg2));
        }
    }

    static long access$getValue$jd(LongState arg2) {
        return super.getValue().longValue();
    }

    long getLongValue();

    default Long getValue() {
        return Long.valueOf(this.getLongValue());
    }

    default Object getValue() {
        return this.getValue();
    }
}

