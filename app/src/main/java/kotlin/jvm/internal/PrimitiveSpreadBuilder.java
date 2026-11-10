package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\u0004*\u00028\u0000H¤\u0080\u0004¢\u0006\u0002\u0010\bJ\u0017\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0015J\n\u0010\u0003\u001A\u00020\u0004H\u0084\u0080\u0004J\u001F\u0010\u0016\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00028\u00002\u0006\u0010\u0018\u001A\u00028\u0000H\u0084\u0080\u0004¢\u0006\u0002\u0010\u0019R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001B\u0010\t\u001A\u00020\u0004X\u0084\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\u0006R\u001F\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000EX\u0082\u0084\b¢\u0006\n\n\u0002\u0010\u0011\u0012\u0004\b\u000F\u0010\u0010¨\u0006\u001A"}, d2={"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "<init>", "(I)V", "getSize", "(Ljava/lang/Object;)I", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public abstract class PrimitiveSpreadBuilder {
    private int position;
    private final int size;
    private final Object[] spreads;

    public PrimitiveSpreadBuilder(int arg1) {
        super();
        this.size = arg1;
        this.spreads = new Object[arg1];
    }

    public final void addSpread(Object arg4) {
        Intrinsics.checkNotNullParameter(arg4, "spreadArgument");
        Object[] v0 = this.spreads;
        int v1 = this.position;
        this.position = v1 + 1;
        v0[v1] = arg4;
    }

    protected final int getPosition() {
        return this.position;
    }

    protected abstract int getSize(Object arg1);

    private static void getSpreads$annotations() {
    }

    protected final void setPosition(int arg1) {
        this.position = arg1;
    }

    protected final int size() {
        int v0 = this.size - 1;
        int v2 = 0;
        if(v0 >= 0) {
            int v3;
            for(v3 = 0; true; ++v3) {
                Object v4 = this.spreads[v3];
                int v4_1 = v4 != null ? this.getSize(v4) : 1;
                v2 += v4_1;
                if(v3 == v0) {
                    return v2;
                }
            }
        }

        return v2;
    }

    protected final Object toArray(Object arg8, Object arg9) {
        int v4;
        Intrinsics.checkNotNullParameter(arg8, "values");
        Intrinsics.checkNotNullParameter(arg9, "result");
        int v0 = this.size - 1;
        int v1 = 0;
        if(v0 >= 0) {
            int v2 = 0;
            int v3 = 0;
            v4 = 0;
            while(true) {
                Object v5 = this.spreads[v2];
                if(v5 != null) {
                    if(v3 < v2) {
                        int v6 = v2 - v3;
                        System.arraycopy(arg8, v3, arg9, v4, v6);
                        v4 += v6;
                    }

                    v3 = this.getSize(v5);
                    System.arraycopy(v5, 0, arg9, v4, v3);
                    v4 += v3;
                    v3 = v2 + 1;
                }

                if(v2 == v0) {
                    break;
                }

                ++v2;
            }

            v1 = v3;
        }
        else {
            v4 = 0;
        }

        int v7 = this.size;
        if(v1 < v7) {
            System.arraycopy(arg8, v1, arg9, v4, v7 - v1);
        }

        return arg9;
    }
}

