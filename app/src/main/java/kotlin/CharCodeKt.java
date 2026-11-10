package kotlin;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0088\u0004\" \u0010\u0002\u001A\u00020\u0003*\u00020\u00018Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Char", "", "code", "", "getCode$annotations", "(C)V", "getCode", "(C)I", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class CharCodeKt {
    private static final char Char(int arg3) {
        if(arg3 >= 0 && arg3 <= 0xFFFF) {
            return ((char)arg3);
        }

        throw new IllegalArgumentException("Invalid Char code: " + arg3);
    }

    private static final int getCode(char arg0) {
        return arg0;
    }

    public static void getCode$annotations(char arg0) {
    }
}

