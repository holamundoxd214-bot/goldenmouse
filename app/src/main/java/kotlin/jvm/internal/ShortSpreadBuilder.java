package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000E\u0010\b\u001A\u00020\u0004*\u00020\u0002H\u0094\u0080\u0004J\u0012\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0086\u0080\u0004J\n\u0010\r\u001A\u00020\u0002H\u0086\u0080\u0004R\u000F\u0010\u0007\u001A\u00020\u0002X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "<init>", "(I)V", "values", "getSize", "add", "", "value", "", "toArray", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class ShortSpreadBuilder extends PrimitiveSpreadBuilder {
    private final short[] values;

    public ShortSpreadBuilder(int arg1) {
        super(arg1);
        this.values = new short[arg1];
    }

    public final void add(short arg4) {
        short[] v0 = this.values;
        int v1 = this.getPosition();
        this.setPosition(v1 + 1);
        v0[v1] = arg4;
    }

    public int getSize(Object arg1) {
        return this.getSize(((short[])arg1));
    }

    protected int getSize(short[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.length;
    }

    public final short[] toArray() {
        return this.toArray(this.values, new short[this.size()]);
    }
}

