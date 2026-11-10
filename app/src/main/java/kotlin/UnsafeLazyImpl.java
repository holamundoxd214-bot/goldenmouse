package kotlin;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0017\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u000E\u001A\u00020\u000FH\u0096\u0080\u0004J\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004J\n\u0010\u0012\u001A\u00020\nH\u0082\u0080\u0004J\u001B\u0010\u0013\u001A\u00020\u00142\n\u0010\u0015\u001A\u00060\u0016j\u0002`\u0017H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0018R\u0017\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000B\u001A\u00028\u00008VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\r¨\u0006\u0019"}, d2={"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class UnsafeLazyImpl implements Serializable, Lazy {
    private Object _value;
    private Function0 initializer;

    public UnsafeLazyImpl(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializer");
        super();
        this.initializer = arg2;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
    }

    public Object getValue() {
        if(this._value == UNINITIALIZED_VALUE.INSTANCE) {
            Function0 v0 = this.initializer;
            Intrinsics.checkNotNull(v0);
            this._value = v0.invoke();
            this.initializer = null;
        }

        return this._value;
    }

    public boolean isInitialized() {
        if(this._value != UNINITIALIZED_VALUE.INSTANCE) {
            return 1;
        }

        return 0;
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
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

