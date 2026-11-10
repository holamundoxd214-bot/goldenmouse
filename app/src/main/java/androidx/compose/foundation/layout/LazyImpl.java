package androidx.compose.foundation.layout;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u0006H\u0016R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u000E\u0010\r\u001A\u00020\u0002X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\u000E\u001A\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0015"}, d2={"Landroidx/compose/foundation/layout/LazyImpl;", "Lkotlin/Lazy;", "", "initializer", "Lkotlin/Function0;", "errorMessage", "", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)V", "getInitializer", "()Lkotlin/jvm/functions/Function0;", "getErrorMessage", "()Ljava/lang/String;", "_value", "value", "getValue", "()Ljava/lang/Integer;", "isInitialized", "", "toString", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class LazyImpl implements Lazy {
    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/compose/foundation/layout/LazyImpl$Companion;", "", "<init>", "()V", "UNINITIALIZED_VALUE", "", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion = null;
    public static final int UNINITIALIZED_VALUE = -1;
    private int _value;
    private final String errorMessage;
    private final Function0 initializer;

    static {
        LazyImpl.Companion = new Companion(null);
    }

    public LazyImpl(Function0 arg1, String arg2) {
        super();
        this.initializer = arg1;
        this.errorMessage = arg2;
        this._value = -1;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Function0 getInitializer() {
        return this.initializer;
    }

    public Integer getValue() {
        int v0 = this._value;
        int v1 = -1;
        if(v0 == v1) {
            v0 = this.initializer.invoke().intValue();
            this._value = v0;
        }

        if(v0 != v1) {
            return Integer.valueOf(v0);
        }

        throw new IllegalStateException(this.errorMessage);
    }

    public Object getValue() {
        return this.getValue();
    }

    public boolean isInitialized() {
        if(this._value != -1) {
            return 1;
        }

        return 0;
    }

    public String toString() {
        if(this.isInitialized()) {
            return String.valueOf(this.getValue().intValue());
        }

        return this.errorMessage;
    }
}

