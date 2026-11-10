package kotlin;

import java.io.Serializable;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0011\bF\u0012\u0006\u0010\u0005\u001A\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u000B\u001A\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004R\u0017\u0010\u0005\u001A\u00028\u0000X\u0096\u0084\b¢\u0006\n\n\u0002\u0010\n\u001A\u0004\b\b\u0010\t¨\u0006\u000F"}, d2={"Lkotlin/InitializedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isInitialized", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class InitializedLazyImpl implements Serializable, Lazy {
    private final Object value;

    public InitializedLazyImpl(Object arg1) {
        super();
        this.value = arg1;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isInitialized() {
        return 1;
    }

    public String toString() {
        return String.valueOf(this.getValue());
    }
}

