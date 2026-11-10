package kotlin.experimental;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u0016\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u0016\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0006H\u0087\u008C\u0004\u001A\u0016\u0010\u0003\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0006H\u0087\u008C\u0004\u001A\u0016\u0010\u0004\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0006H\u0087\u008C\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004¨\u0006\u0007"}, d2={"and", "", "other", "or", "xor", "inv", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class BitwiseOperationsKt {
    private static final byte and(byte arg0, byte arg1) {
        return ((byte)(arg0 & arg1));
    }

    private static final short and(short arg0, short arg1) {
        return ((short)(arg0 & arg1));
    }

    private static final byte inv(byte arg0) {
        return ((byte)(~arg0));
    }

    private static final short inv(short arg0) {
        return ((short)(~arg0));
    }

    private static final byte or(byte arg0, byte arg1) {
        return ((byte)(arg0 | arg1));
    }

    private static final short or(short arg0, short arg1) {
        return ((short)(arg0 | arg1));
    }

    private static final byte xor(byte arg0, byte arg1) {
        return ((byte)(arg0 ^ arg1));
    }

    private static final short xor(short arg0, short arg1) {
        return ((short)(arg0 ^ arg1));
    }
}

