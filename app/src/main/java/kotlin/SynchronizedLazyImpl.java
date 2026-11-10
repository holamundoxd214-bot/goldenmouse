package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B#\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u000F\u001A\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001A\u00020\bH\u0082\u0080\u0004R\u0017\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u0004\u0018\u00010\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001A\u00028\u00008VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0014"}, d2={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SynchronizedLazyImpl implements Serializable, Lazy {
    private volatile Object _value;
    private Function0 initializer;
    private final Object lock;

    public SynchronizedLazyImpl(Function0 arg2, Object arg3) {
        SynchronizedLazyImpl v3;
        Intrinsics.checkNotNullParameter(arg2, "initializer");
        super();
        this.initializer = arg2;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        if(arg3 == null) {
            v3 = this;
        }

        this.lock = v3;
    }

    public SynchronizedLazyImpl(Function0 arg1, Object arg2, int arg3, DefaultConstructorMarker arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        this(arg1, arg2);
    }

    public Object getValue() {
        Object v1;
        Object v0 = this._value;
        if(v0 != UNINITIALIZED_VALUE.INSTANCE) {
            return v0;
        }

        v0 = this.lock;
        __monitor_enter(v0);
        try {
            v1 = this._value;
            if(v1 != UNINITIALIZED_VALUE.INSTANCE) {
            }
            else {
                Function0 v1_1 = this.initializer;
                Intrinsics.checkNotNull(v1_1);
                v1 = v1_1.invoke();
                this._value = v1;
                this.initializer = null;
            }
        }
        catch(Throwable v3) {
            __monitor_exit(v0);
            throw v3;
        }

        __monitor_exit(v0);
        return v1;
    }

    public boolean isInitialized() {
        if(this._value != UNINITIALIZED_VALUE.INSTANCE) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        if(this.isInitialized()) {
            return String.valueOf(this.getValue());
        }

        return "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(this.getValue());
    }
}

