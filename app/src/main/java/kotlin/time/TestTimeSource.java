package kotlin.time;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001A\u00020\u0005H\u0094\u0080\u0004J\u0019\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0086\u0082\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\r\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0082\u0080\u0004¢\u0006\u0004\b\u000E\u0010\fR\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u008E\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", "duration", "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        this.markNow();
    }

    private final void overflow-LRDsOJo(long arg5) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(this.getUnit()) + " is advanced by " + Duration.toString-impl(arg5) + '.');
    }

    public final void plusAssign-LRDsOJo(long arg9) {
        long v0 = Duration.toLong-impl(arg9, this.getUnit());
        long v2 = 1;
        long v6 = 0x7FFFFFFFFFFFFFFFL;
        if((v0 - v2 | v2) == v6) {
            v0 = Duration.div-UwyO8pc(arg9, 2);
            if((v2 | Duration.toLong-impl(v0, this.getUnit()) - v2) == v6) {
                this.overflow-LRDsOJo(arg9);
                return;
            }

            v2 = this.reading;
            try {
                this.plusAssign-LRDsOJo(v0);
                this.plusAssign-LRDsOJo(Duration.minus-LRDsOJo(arg9, v0));
                return;
            }
            catch(IllegalStateException v9) {
                this.reading = v2;
                throw v9;
            }
        }

        v2 = this.reading;
        long v4 = v2 + v0;
        v6 = 0;
        if((v0 ^ v2) >= v6 && (v2 ^ v4) < v6) {
            this.overflow-LRDsOJo(arg9);
        }

        this.reading = v4;
    }

    protected long read() {
        return this.reading;
    }
}

