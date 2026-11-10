package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0081\u0080\u0004\u001A\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u0006H\u0081\u0080\u0004\u001A\u0012\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\tH\u0081\u0080\u0004\u001A\u0012\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0002\u001A\u00020\fH\u0081\u0080\u0004\u001A\u0012\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0002\u001A\u00020\u000FH\u0081\u0080\u0004\u001A\u0012\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0002\u001A\u00020\u0012H\u0081\u0080\u0004\u001A\u0012\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0002\u001A\u00020\u0015H\u0081\u0080\u0004\u001A\u0012\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0002\u001A\u00020\u0018H\u0081\u0080\u0004¨\u0006\u0019"}, d2={"boxBoolean", "Ljava/lang/Boolean;", "primitive", "", "boxByte", "Ljava/lang/Byte;", "", "boxShort", "Ljava/lang/Short;", "", "boxInt", "Ljava/lang/Integer;", "", "boxLong", "Ljava/lang/Long;", "", "boxFloat", "Ljava/lang/Float;", "", "boxDouble", "Ljava/lang/Double;", "", "boxChar", "Ljava/lang/Character;", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class Boxing {
    public static final Boolean boxBoolean(boolean arg0) {
        return Boolean.valueOf(arg0);
    }

    public static final Byte boxByte(byte arg0) {
        return Byte.valueOf(arg0);
    }

    public static final Character boxChar(char arg1) {
        return new Character(arg1);
    }

    public static final Double boxDouble(double arg1) {
        return new Double(arg1);
    }

    public static final Float boxFloat(float arg1) {
        return new Float(arg1);
    }

    public static final Integer boxInt(int arg1) {
        return new Integer(arg1);
    }

    public static final Long boxLong(long arg1) {
        return new Long(arg1);
    }

    public static final Short boxShort(short arg1) {
        return new Short(arg1);
    }
}

