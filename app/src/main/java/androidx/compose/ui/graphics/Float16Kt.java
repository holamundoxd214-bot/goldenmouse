package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u0011\u0010\u0014\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u0016H\u0082\b\u001A\u0011\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\u0013H\u0080\b\u001A\u0011\u0010\u0019\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u0016H\u0080\b\u001A\u001F\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001CH\u0000¢\u0006\u0004\b\u001F\u0010 \u001A\u001F\u0010!\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\u001CH\u0000¢\u0006\u0004\b\"\u0010 \"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0006\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\b\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\f\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\r\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000E\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0010\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0011\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2={"Fp16SignShift", "", "Fp16SignMask", "Fp16ExponentShift", "Fp16ExponentMask", "Fp16SignificandMask", "Fp16ExponentBias", "Fp16Combined", "Fp16ExponentMax", "Fp16One", "Fp16TheNaN", "Fp32SignShift", "Fp32ExponentShift", "Fp32ExponentMask", "Fp32SignificandMask", "Fp32ExponentBias", "Fp32QNaNMask", "Fp32DenormalMagic", "Fp32DenormalFloat", "", "toCompareValue", "value", "", "floatToHalf", "f", "halfToFloat", "h", "min", "Landroidx/compose/ui/graphics/Float16;", "x", "y", "min-AoSsdG0", "(SS)S", "max", "max-AoSsdG0", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Float16Kt {
    private static final int Fp16Combined = 0x7FFF;
    private static final int Fp16ExponentBias = 15;
    private static final int Fp16ExponentMask = 0x1F;
    private static final int Fp16ExponentMax = 0x7C00;
    private static final int Fp16ExponentShift = 10;
    private static final int Fp16One = 0x3C00;
    private static final int Fp16SignMask = 0x8000;
    private static final int Fp16SignShift = 15;
    private static final int Fp16SignificandMask = 0x3FF;
    private static final int Fp16TheNaN = 0x7E00;
    private static final float Fp32DenormalFloat = 0f;
    private static final int Fp32DenormalMagic = 0x3F000000;
    private static final int Fp32ExponentBias = 0x7F;
    private static final int Fp32ExponentMask = 0xFF;
    private static final int Fp32ExponentShift = 23;
    private static final int Fp32QNaNMask = 0x400000;
    private static final int Fp32SignShift = 0x1F;
    private static final int Fp32SignificandMask = 0x7FFFFF;

    static {
        Float16Kt.Fp32DenormalFloat = Float.intBitsToFloat(0x3F000000);
    }

    public static final float access$getFp32DenormalFloat$p() {
        return Float16Kt.Fp32DenormalFloat;
    }

    public static final short floatToHalf(float arg6) {
        int v6 = Float.floatToRawIntBits(arg6);
        int v0 = v6 >>> 0x1F;
        int v1 = v6 >>> 23 & 0xFF;
        int v3 = 0x7FFFFF & v6;
        int v4 = 0x1F;
        int v5 = 0;
        if(v1 != 0xFF) {
            v1 += 0xFFFFFF90;
            if(v1 >= v4) {
                v4 = 49;
                goto label_44;
            }
            else if(v1 <= 0) {
                if(v1 >= -10) {
                    v6 = (0x800000 | v3) >> 1 - v1;
                    if((v6 & 0x1000) != 0) {
                        v6 += 0x2000;
                    }

                    v6 >>= 13;
                    v4 = 0;
                label_29:
                    v5 = v6;
                }
                else {
                    v4 = 0;
                }

                goto label_44;
            }
            else {
                v5 = v3 >> 13;
                if((v6 & 0x1000) != 0) {
                    v6 = (v1 << 10 | v5) + 1 | v0 << 15;
                    goto label_41;
                }

                v4 = v1;
            label_44:
                v6 = v0 << 15 | v4 << 10 | v5;
            }
        }
        else if(v3 != 0) {
            v6 = 0x200;
            goto label_29;
        }
        else {
            goto label_44;
        }

    label_41:
        return ((short)v6);
    }

    public static final float halfToFloat(short arg4) {
        int v1 = 0x8000 & arg4;
        int v2 = 0x1F;
        int v0 = (0xFFFF & arg4) >>> 10 & v2;
        int v4 = arg4 & 0x3FF;
        if(v0 != 0) {
            v4 <<= 13;
            if(v0 == v2) {
                v0 = 0xFF;
                if(v4 != 0) {
                    v4 |= 0x400000;
                }
            }
            else {
                v0 += 0x70;
            }

            int v3 = v0;
            v0 = v4;
            v4 = v3;
        }
        else if(v4 != 0) {
            float v4_1 = Float.intBitsToFloat(v4 + 0x3F000000) - Float16Kt.Fp32DenormalFloat;
            if(v1 == 0) {
                return v4_1;
            }
            else {
                return -v4_1;
            }
        }
        else {
            v4 = 0;
            v0 = 0;
        }

        return Float.intBitsToFloat(v4 << 23 | v1 << 16 | v0);
    }

    public static final short max-AoSsdG0(short arg1, short arg2) {
        if(!Float16.isNaN-impl(arg1)) {
            if(Float16.isNaN-impl(arg2)) {
            }
            else if(Float16.compareTo-41bOqos(arg1, arg2) >= 0) {
                return arg1;
            }
            else {
                return arg2;
            }
        }

        return Float16.Companion.getNaN-slo4al4();
    }

    public static final short min-AoSsdG0(short arg1, short arg2) {
        if(!Float16.isNaN-impl(arg1)) {
            if(Float16.isNaN-impl(arg2)) {
            }
            else if(Float16.compareTo-41bOqos(arg1, arg2) <= 0) {
                return arg1;
            }
            else {
                return arg2;
            }
        }

        return Float16.Companion.getNaN-slo4al4();
    }

    private static final int toCompareValue(short arg3) {
        int v0 = 0x8000;
        int v2 = 0xFFFF;
        if((arg3 & v0) != 0) {
            return v0 - (arg3 & v2);
        }

        return arg3 & v2;
    }
}

