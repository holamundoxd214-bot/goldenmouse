package kotlin;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\n\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0004\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0006\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0007\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0016\u0010\t\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\nH\u0087\u0088\u0004\u001A\u000E\u0010\u0003\u001A\u00020\u0001*\u00020\nH\u0087\u0088\u0004\u001A\u000E\u0010\u0004\u001A\u00020\u0001*\u00020\nH\u0087\u0088\u0004\u001A\u000E\u0010\u0005\u001A\u00020\n*\u00020\nH\u0087\u0088\u0004\u001A\u000E\u0010\u0006\u001A\u00020\n*\u00020\nH\u0087\u0088\u0004\u001A\u0016\u0010\u0007\u001A\u00020\n*\u00020\n2\u0006\u0010\b\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0016\u0010\t\u001A\u00020\n*\u00020\n2\u0006\u0010\b\u001A\u00020\u0001H\u0087\u0080\u0004¨\u0006\u000B"}, d2={"countOneBits", "", "", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "rotateRight", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/NumbersKt") class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public NumbersKt__NumbersKt() {
        super();
    }

    private static final int countLeadingZeroBits(byte arg0) {
        return Integer.numberOfLeadingZeros(arg0 & 0xFF) - 24;
    }

    private static final int countLeadingZeroBits(short arg1) {
        return Integer.numberOfLeadingZeros(arg1 & 0xFFFF) - 16;
    }

    private static final int countOneBits(byte arg0) {
        return Integer.bitCount(arg0 & 0xFF);
    }

    private static final int countOneBits(short arg1) {
        return Integer.bitCount(arg1 & 0xFFFF);
    }

    private static final int countTrailingZeroBits(byte arg0) {
        return Integer.numberOfTrailingZeros(arg0 | 0x100);
    }

    private static final int countTrailingZeroBits(short arg1) {
        return Integer.numberOfTrailingZeros(arg1 | 0x10000);
    }

    public static final byte rotateLeft(byte arg1, int arg2) {
        arg2 &= 7;
        return ((byte)((arg1 & 0xFF) >>> 8 - arg2 | arg1 << arg2));
    }

    public static final short rotateLeft(short arg2, int arg3) {
        arg3 &= 15;
        return ((short)((arg2 & 0xFFFF) >>> 16 - arg3 | arg2 << arg3));
    }

    public static final byte rotateRight(byte arg1, int arg2) {
        arg2 &= 7;
        return ((byte)((arg1 & 0xFF) >>> arg2 | arg1 << 8 - arg2));
    }

    public static final short rotateRight(short arg2, int arg3) {
        arg3 &= 15;
        return ((short)((arg2 & 0xFFFF) >>> arg3 | arg2 << 16 - arg3));
    }

    private static final byte takeHighestOneBit(byte arg0) {
        return ((byte)Integer.highestOneBit(arg0 & 0xFF));
    }

    private static final short takeHighestOneBit(short arg1) {
        return ((short)Integer.highestOneBit(arg1 & 0xFFFF));
    }

    private static final byte takeLowestOneBit(byte arg0) {
        return ((byte)Integer.lowestOneBit(arg0));
    }

    private static final short takeLowestOneBit(short arg0) {
        return ((short)Integer.lowestOneBit(arg0));
    }
}

