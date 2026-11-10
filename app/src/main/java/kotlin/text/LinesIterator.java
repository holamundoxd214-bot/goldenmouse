package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000FB\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\f\u001A\u00020\rH\u0096\u0082\u0004J\n\u0010\u000E\u001A\u00020\u0002H\u0096\u0082\u0004R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\bX\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2={"Lkotlin/text/LinesIterator;", "", "", "string", "", "<init>", "(Ljava/lang/CharSequence;)V", "state", "", "tokenStartIndex", "delimiterStartIndex", "delimiterLength", "hasNext", "", "next", "State", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class LinesIterator implements Iterator, KMappedMarker {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Lkotlin/text/LinesIterator$State;", "", "<init>", "()V", "UNKNOWN", "", "HAS_NEXT", "EXHAUSTED", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class State {
        public State(DefaultConstructorMarker arg1) {
            this();
        }

        private State() {
            super();
        }
    }

    @Deprecated public static final int EXHAUSTED = 2;
    @Deprecated public static final int HAS_NEXT = 1;
    private static final State State;
    @Deprecated public static final int UNKNOWN;
    private int delimiterLength;
    private int delimiterStartIndex;
    private int state;
    private final CharSequence string;
    private int tokenStartIndex;

    static {
        LinesIterator.State = new State(null);
    }

    public LinesIterator(CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "string");
        super();
        this.string = arg2;
    }

    public boolean hasNext() {
        int v0 = this.state;
        if(v0 != 0) {
            if(v0 == 1) {
                return 1;
            }

            return 0;
        }

        int v3 = 2;
        if(this.delimiterLength < 0) {
            this.state = v3;
            return 0;
        }

        v0 = this.string.length();
        int v1 = this.tokenStartIndex;
        int v4 = this.string.length();
        while(true) {
            if(v1 < v4) {
                int v5 = this.string.charAt(v1);
                int v6 = 13;
                int v7 = 10;
                if(v5 != v7 && v5 != v6) {
                    ++v1;
                    continue;
                }

                break;
            }
            else {
                goto label_38;
            }
        }

        if(v5 == v6) {
            v0 = v1 + 1;
            if(v0 >= this.string.length()) {
                goto label_35;
            }
            else if(this.string.charAt(v0) == v7) {
            }
            else {
                goto label_35;
            }
        }
        else {
        label_35:
            v3 = 1;
        }

        v0 = v1;
        goto label_39;
    label_38:
        v3 = -1;
    label_39:
        this.state = 1;
        this.delimiterLength = v3;
        this.delimiterStartIndex = v0;
        return 1;
    }

    public Object next() {
        return this.next();
    }

    public String next() {
        if(this.hasNext()) {
            this.state = 0;
            int v0 = this.delimiterStartIndex;
            int v1 = this.tokenStartIndex;
            this.tokenStartIndex = this.delimiterLength + v0;
            return this.string.subSequence(v1, v0).toString();
        }

        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

