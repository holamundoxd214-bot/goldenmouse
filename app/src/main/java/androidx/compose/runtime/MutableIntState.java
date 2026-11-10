package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00038W@WX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2={"Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/MutableState;", "", "value", "getValue", "()Ljava/lang/Integer;", "setValue", "(I)V", "intValue", "getIntValue", "()I", "setIntValue", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface MutableIntState extends IntState, MutableState {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Integer getValue(MutableIntState arg0) {
            return Integer.valueOf(MutableIntState.access$getValue$jd(arg0));
        }

        @Deprecated public static void setValue(MutableIntState arg0, int arg1) {
            arg0.setValue(arg1);
        }
    }

    static int access$getValue$jd(MutableIntState arg0) {
        return super.getValue().intValue();
    }

    static void access$setValue$jd(MutableIntState arg0, int arg1) {
        super.setValue(arg1);
    }

    int getIntValue();

    default Integer getValue() {
        return Integer.valueOf(this.getIntValue());
    }

    default Object getValue() {
        return this.getValue();
    }

    void setIntValue(int arg1);

    default void setValue(int arg1) {
        this.setIntValue(arg1);
    }

    default void setValue(Object arg1) {
        this.setValue(((Number)arg1).intValue());
    }
}

