package kotlin;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001A*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u001AB\u0017\bF\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0011\u001A\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001A\u00020\u0014H\u0096\u0080\u0004J\n\u0010\u0015\u001A\u00020\nH\u0082\u0080\u0004J\u0012\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0082\u0080\u0004R\u0017\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000B\u001A\u00020\nX\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0015\u0010\u000E\u001A\u00028\u00008VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001B"}, d2={"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "getFinal$annotations", "()V", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class SafePublicationLazyImpl implements Serializable, Lazy {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R_\u0010\u0004\u001AR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001 \u0007*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/SafePublicationLazyImpl$Companion;", "", "<init>", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    private volatile Object _value;
    private final Object final;
    private volatile Function0 initializer;
    private static final AtomicReferenceFieldUpdater valueUpdater;

    static {
        SafePublicationLazyImpl.Companion = new Companion(null);
        SafePublicationLazyImpl.valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    }

    public SafePublicationLazyImpl(Function0 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "initializer");
        super();
        this.initializer = arg2;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.final = UNINITIALIZED_VALUE.INSTANCE;
    }

    private static void getFinal$annotations() {
    }

    public Object getValue() {
        Object v0 = this._value;
        if(v0 != UNINITIALIZED_VALUE.INSTANCE) {
            return v0;
        }

        Function0 v0_1 = this.initializer;
        if(v0_1 != null) {
            v0 = v0_1.invoke();
            if(AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(SafePublicationLazyImpl.valueUpdater, this, UNINITIALIZED_VALUE.INSTANCE, v0)) {
                this.initializer = null;
                return v0;
            }
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

