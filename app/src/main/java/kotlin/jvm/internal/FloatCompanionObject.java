package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0014\u001A\u00020\u0005H\u0086\u0080\u0004J\n\u0010\u0015\u001A\u00020\u0005H\u0086\u0080\u0004J\n\u0010\u0016\u001A\u00020\u0005H\u0086\u0080\u0004J\n\u0010\u0017\u001A\u00020\u0005H\u0086\u0080\u0004J\n\u0010\u0018\u001A\u00020\u0005H\u0086\u0080\u0004R\u0017\u0010\u0004\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u0017\u0010\u0007\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0017\u0010\t\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R\u0017\u0010\u000B\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003R\u0017\u0010\r\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u000E\u0010\u0003R\u0017\u0010\u000F\u001A\u00020\u00108\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R\u0017\u0010\u0012\u001A\u00020\u00108\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003¨\u0006\u0019"}, d2={"Lkotlin/jvm/internal/FloatCompanionObject;", "", "<init>", "()V", "MIN_VALUE", "", "getMIN_VALUE$annotations", "MAX_VALUE", "getMAX_VALUE$annotations", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY$annotations", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY$annotations", "NaN", "getNaN$annotations", "SIZE_BYTES", "", "getSIZE_BYTES$annotations", "SIZE_BITS", "getSIZE_BITS$annotations", "getMIN_VALUE", "getMAX_VALUE", "getPOSITIVE_INFINITY", "getNEGATIVE_INFINITY", "getNaN", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class FloatCompanionObject {
    public static final FloatCompanionObject INSTANCE = null;
    public static final float MAX_VALUE = 3.402823E+38f;
    public static final float MIN_VALUE = 1.401298E-45f;
    public static final float NEGATIVE_INFINITY = -Infinityf;
    public static final float NaN = NaNf;
    public static final float POSITIVE_INFINITY = Infinityf;
    public static final int SIZE_BITS = 0x20;
    public static final int SIZE_BYTES = 4;

    static {
        FloatCompanionObject.INSTANCE = new FloatCompanionObject();
    }

    private FloatCompanionObject() {
        super();
    }

    public final float getMAX_VALUE() {
        return 3.402823E+38f;
    }

    public static void getMAX_VALUE$annotations() {
    }

    public final float getMIN_VALUE() {
        return 1;
    }

    public static void getMIN_VALUE$annotations() {
    }

    public final float getNEGATIVE_INFINITY() {
        return -Infinityf;
    }

    public static void getNEGATIVE_INFINITY$annotations() {
    }

    public final float getNaN() {
        return NaNf;
    }

    public static void getNaN$annotations() {
    }

    public final float getPOSITIVE_INFINITY() {
        return Infinityf;
    }

    public static void getPOSITIVE_INFINITY$annotations() {
    }

    public static void getSIZE_BITS$annotations() {
    }

    public static void getSIZE_BYTES$annotations() {
    }
}

