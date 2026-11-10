package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0016J\u001E\u0010\u0007\u001A\u0002H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001A\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\nR\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlinx/coroutines/internal/Symbol;", "", "symbol", "", "<init>", "(Ljava/lang/String;)V", "toString", "unbox", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Symbol {
    public final String symbol;

    public Symbol(String arg1) {
        super();
        this.symbol = arg1;
    }

    public String toString() {
        return "<" + this.symbol + '>';
    }

    public final Object unbox(Object arg1) {
        if((((Symbol)arg1)) == this) {
            return null;
        }

        return arg1;
    }
}

