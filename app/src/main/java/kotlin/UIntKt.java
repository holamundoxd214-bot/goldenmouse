package kotlin;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0007\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010\t\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\nH\u0087\u0088\u0004¢\u0006\u0002\u0010\u000B\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\fH\u0087\u0088\u0004¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"toUInt", "Lkotlin/UInt;", "", "(B)I", "", "(S)I", "", "(I)I", "", "(J)I", "", "(F)I", "", "(D)I", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UIntKt {
    private static final int toUInt(byte arg0) {
        return UInt.constructor-impl(arg0);
    }

    private static final int toUInt(double arg0) {
        return UnsignedKt.doubleToUInt(arg0);
    }

    private static final int toUInt(float arg2) {
        return UnsignedKt.doubleToUInt(((double)arg2));
    }

    private static final int toUInt(int arg0) {
        return UInt.constructor-impl(arg0);
    }

    private static final int toUInt(long arg0) {
        return UInt.constructor-impl(((int)arg0));
    }

    private static final int toUInt(short arg0) {
        return UInt.constructor-impl(arg0);
    }
}

