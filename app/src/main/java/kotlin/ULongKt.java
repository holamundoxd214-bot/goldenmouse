package kotlin;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0003\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0004H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0005\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\u0006H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0007\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\bH\u0087\u0088\u0004¢\u0006\u0002\u0010\t\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\nH\u0087\u0088\u0004¢\u0006\u0002\u0010\u000B\u001A\u0013\u0010\u0000\u001A\u00020\u0001*\u00020\fH\u0087\u0088\u0004¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"toULong", "Lkotlin/ULong;", "", "(B)J", "", "(S)J", "", "(I)J", "", "(J)J", "", "(F)J", "", "(D)J", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ULongKt {
    private static final long toULong(byte arg2) {
        return ULong.constructor-impl(((long)arg2));
    }

    private static final long toULong(double arg0) {
        return UnsignedKt.doubleToULong(arg0);
    }

    private static final long toULong(float arg2) {
        return UnsignedKt.doubleToULong(((double)arg2));
    }

    private static final long toULong(int arg2) {
        return ULong.constructor-impl(((long)arg2));
    }

    private static final long toULong(long arg0) {
        return ULong.constructor-impl(arg0);
    }

    private static final long toULong(short arg2) {
        return ULong.constructor-impl(((long)arg2));
    }
}

