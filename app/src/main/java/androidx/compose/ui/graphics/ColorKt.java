package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A9\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\rH\u0007¢\u0006\u0002\u0010\u000E\u001A9\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\b2\b\b\u0002\u0010\f\u001A\u00020\rH\u0001¢\u0006\u0002\u0010\u000E\u001A\u0017\u0010\u0005\u001A\u00020\u00062\b\b\u0001\u0010\u0010\u001A\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001A\u0015\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001A5\u0010\u0005\u001A\u00020\u00062\b\b\u0001\u0010\u0007\u001A\u00020\u00112\b\b\u0001\u0010\t\u001A\u00020\u00112\b\b\u0001\u0010\n\u001A\u00020\u00112\b\b\u0003\u0010\u000B\u001A\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001A)\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00062\b\b\u0001\u0010\u0019\u001A\u00020\bH\u0007¢\u0006\u0004\b\u001A\u0010\u001B\u001A\u001B\u0010\u001C\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u001E\u0010\u001F\u001A1\u0010 \u001A\u00020\b2\u0006\u0010!\u001A\u00020\b2\u0006\u0010\"\u001A\u00020\b2\u0006\u0010#\u001A\u00020\b2\u0006\u0010$\u001A\u00020\b2\u0006\u0010%\u001A\u00020\bH\u0082\b\u001A\u0013\u0010&\u001A\u00020\'*\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)\u001A\u0013\u0010*\u001A\u00020\b*\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001A\u0013\u0010-\u001A\u00020\u0011*\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/\u001A\"\u00109\u001A\u00020\u0006*\u00020\u00062\f\u0010:\u001A\b\u0012\u0004\u0012\u00020\u00060;H\u0086\b¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001A\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001F\u00100\u001A\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001A\u0004\b4\u00105\"\u001F\u00106\u001A\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001A\u0004\b8\u00105¨\u0006>"}, d2={"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "Color", "Landroidx/compose/ui/graphics/Color;", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "color", "", "(I)J", "", "(J)J", "(IIII)J", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "toArgb", "toArgb-8_81llA", "(J)I", "isSpecified", "", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "ui-graphics"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    public static final long Color(long arg1) {
        return Color.constructor-impl(ULong.constructor-impl(arg1 << 0x20));
    }

    public static final long Color(int arg2) {
        return Color.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(((long)arg2)) << 0x20));
    }

    public static final long Color(float arg20, float arg21, float arg22, float arg23, ColorSpace arg24) {
        float v6;
        int v0_2;
        float v0_1;
        ColorSpace v0 = arg24;
        int v2 = 16;
        float v3 = 0.5f;
        float v4 = 1f;
        float v5 = 0f;
        if(v0.isSrgb()) {
            v0_1 = arg23 < 0f ? 0f : arg23;
            if(v0_1 > v4) {
                v0_1 = v4;
            }

            float v1 = 255f;
            v0_2 = (((int)(v0_1 * v1 + v3))) << 24;
            v6 = arg20 < 0f ? 0f : arg20;
            if(v6 > v4) {
                v6 = v4;
            }

            v0_2 |= (((int)(v6 * v1 + v3))) << 16;
            float v2_1 = arg21 < 0f ? 0f : arg21;
            if(v2_1 > v4) {
                v2_1 = v4;
            }

            v0_2 |= (((int)(v2_1 * v1 + v3))) << 8;
            if(arg22 < 0f) {
            }
            else {
                v5 = arg22;
            }

            if(v5 > v4) {
            }
            else {
                v4 = v5;
            }

            return Color.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(((long)(v0_2 | (((int)(v4 * v1 + v3)))))) << 0x20));
        }

        int v8 = 0;
        int v1_1 = v0.getComponentCount() == 3 ? 1 : 0;
        if(v1_1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }

        v1_1 = v0.getId$ui_graphics();
        int v6_1 = v1_1 != -1 ? 1 : 0;
        if(v6_1 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }

        v6 = v0.getMinValue(0);
        float v9 = v0.getMaxValue(0);
        if(arg20 < v6) {
        }
        else {
            v6 = arg20;
        }

        if(v6 > v9) {
        }
        else {
            v9 = v6;
        }

        v6_1 = Float.floatToRawIntBits(v9);
        int v9_1 = v6_1 >>> 0x1F;
        int v11 = 0xFF;
        int v10 = v6_1 >>> 23 & v11;
        int v12 = 0x7FFFFF;
        int v13 = v6_1 & v12;
        int v14 = 0x800000;
        int v15 = -10;
        int v16 = 0x200;
        int v17 = 49;
        int v18 = v2;
        v2 = 0x1F;
        if(v10 == v11) {
            v6_1 = v13 != 0 ? v16 : 0;
            v10 = v2;
            goto label_134;
        }
        else {
            v10 += 0xFFFFFF90;
            if(v10 >= v2) {
                v6_1 = 0;
                v10 = v17;
                goto label_134;
            }

            if(v10 <= 0) {
                if(v10 >= v15) {
                    v6_1 = (v13 | v14) >> 1 - v10;
                    if((v6_1 & 0x1000) != 0) {
                        v6_1 += 0x2000;
                    }

                    v6_1 >>= 13;
                    v10 = 0;
                    goto label_134;
                }

                v6_1 = 0;
                v10 = 0;
                goto label_134;
            }

            v13 >>= 13;
            if((v6_1 & 0x1000) != 0) {
                v6_1 = (v10 << 10 | v13) + 1 | v9_1 << 15;
                goto label_138;
            }

            v6_1 = v13;
        label_134:
            v6_1 |= v9_1 << 15 | v10 << 10;
        }

    label_138:
        short v6_2 = ((short)v6_1);
        v9 = v0.getMinValue(1);
        float v10_1 = v0.getMaxValue(1);
        if(arg21 < v9) {
        }
        else {
            v9 = arg21;
        }

        if(v9 > v10_1) {
        }
        else {
            v10_1 = v9;
        }

        v9_1 = Float.floatToRawIntBits(v10_1);
        v10 = v9_1 >>> 0x1F;
        v13 = v9_1 >>> 23 & v11;
        int v19 = v9_1 & v12;
        if(v13 == v11) {
            v9_1 = v19 != 0 ? v16 : 0;
            v13 = v2;
            goto label_188;
        }
        else {
            v13 += 0xFFFFFF90;
            if(v13 >= v2) {
                v9_1 = 0;
                v13 = v17;
                goto label_188;
            }

            if(v13 <= 0) {
                if(v13 >= v15) {
                    v9_1 = (v19 | v14) >> 1 - v13;
                    if((v9_1 & 0x1000) != 0) {
                        v9_1 += 0x2000;
                    }

                    v9_1 >>= 13;
                    v13 = 0;
                    goto label_188;
                }

                v9_1 = 0;
                v13 = 0;
                goto label_188;
            }

            v19 >>= 13;
            if((v9_1 & 0x1000) != 0) {
                v9_1 = (v13 << 10 | v19) + 1 | v10 << 15;
                goto label_192;
            }

            v9_1 = v19;
        label_188:
            v9_1 |= v10 << 15 | v13 << 10;
        }

    label_192:
        short v9_2 = ((short)v9_1);
        v10_1 = v0.getMinValue(2);
        v0_1 = v0.getMaxValue(2);
        if(arg22 < v10_1) {
        }
        else {
            v10_1 = arg22;
        }

        if(v10_1 > v0_1) {
        }
        else {
            v0_1 = v10_1;
        }

        v0_2 = Float.floatToRawIntBits(v0_1);
        v10 = v0_2 >>> 0x1F;
        v13 = v0_2 >>> 23 & v11;
        v12 &= v0_2;
        if(v13 == v11) {
            if(v12 != 0) {
                v8 = v16;
            }

            v0_2 = v8;
            v8 = v2;
            goto label_242;
        }
        else {
            v13 += 0xFFFFFF90;
            if(v13 >= v2) {
                v0_2 = 0;
                v8 = v17;
                goto label_242;
            }

            if(v13 <= 0) {
                if(v13 >= v15) {
                    v0_2 = (v12 | v14) >> 1 - v13;
                    if((v0_2 & 0x1000) != 0) {
                        v0_2 += 0x2000;
                    }

                    v0_2 >>= 13;
                    goto label_242;
                }

                v0_2 = 0;
                goto label_242;
            }

            v8 = v12 >> 13;
            if((v0_2 & 0x1000) != 0) {
                v0_2 = (v13 << 10 | v8) + 1 | v10 << 15;
                goto label_246;
            }

            v0_2 = v8;
            v8 = v13;
        label_242:
            v0_2 |= v10 << 15 | v8 << 10;
        }

    label_246:
        short v0_3 = ((short)v0_2);
        if(arg23 < 0f) {
        }
        else {
            v5 = arg23;
        }

        if(v5 > v4) {
        }
        else {
            v4 = v5;
        }

        return Color.constructor-impl(ULong.constructor-impl((((long)v1_1)) & 0x3F | (((((long)v6_2)) & 0xFFFF) << 0x30 | ((((long)v9_2)) & 0xFFFF) << 0x20 | (0xFFFF & (((long)v0_3))) << v18 | ((((long)(((int)(v4 * 1023f + v3))))) & 0x3FF) << 6)));
    }

    public static final long Color(int arg0, int arg1, int arg2, int arg3) {
        return ColorKt.Color((arg0 & 0xFF) << 16 | (arg3 & 0xFF) << 24 | (arg1 & 0xFF) << 8 | arg2 & 0xFF);
    }

    public static long Color$default(int arg0, int arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 8) != 0) {
            arg3 = 0xFF;
        }

        return ColorKt.Color(arg0, arg1, arg2, arg3);
    }

    public static long Color$default(float arg0, float arg1, float arg2, float arg3, ColorSpace arg4, int arg5, Object arg6) {
        Rgb v4;
        if((arg5 & 8) != 0) {
            arg3 = 1f;
        }

        if((arg5 & 16) != 0) {
            v4 = ColorSpaces.INSTANCE.getSrgb();
        }

        return ColorKt.Color(arg0, arg1, arg2, arg3, ((ColorSpace)v4));
    }

    public static final long UncheckedColor(float arg17, float arg18, float arg19, float arg20, ColorSpace arg21) {
        float v0 = arg20;
        int v2 = 0x20;
        int v3 = 16;
        float v4 = 0.5f;
        if(arg21.isSrgb()) {
            return Color.constructor-impl(ULong.constructor-impl(ULong.constructor-impl(((long)((((int)(v0 * 255f + v4))) << 24 | (((int)(arg17 * 255f + v4))) << 16 | (((int)(arg18 * 255f + v4))) << 8 | (((int)(255f * arg19 + v4)))))) << v2));
        }

        int v1 = Float.floatToRawIntBits(arg17);
        int v5 = v1 >>> 0x1F;
        int v7 = 0xFF;
        int v6 = v1 >>> 23 & v7;
        int v8 = 0x7FFFFF;
        int v9 = v1 & v8;
        int v10 = 0x800000;
        int v11 = -10;
        int v12 = 0x200;
        int v13 = 49;
        int v14 = 0;
        int v15 = 0x1F;
        if(v6 == v7) {
            v1 = v9 != 0 ? v12 : 0;
            v6 = v15;
            goto label_80;
        }
        else {
            v6 += 0xFFFFFF90;
            if(v6 >= v15) {
                v6 = v13;
                v1 = 0;
                goto label_80;
            }

            if(v6 <= 0) {
                if(v6 >= v11) {
                    v1 = (v9 | v10) >> 1 - v6;
                    if((v1 & 0x1000) != 0) {
                        v1 += 0x2000;
                    }

                    v1 >>= 13;
                    v6 = 0;
                    goto label_80;
                }

                v1 = 0;
                v6 = 0;
                goto label_80;
            }

            v9 >>= 13;
            if((v1 & 0x1000) != 0) {
                v1 = (v6 << 10 | v9) + 1 | v5 << 15;
                goto label_84;
            }

            v1 = v9;
        label_80:
            v1 |= v5 << 15 | v6 << 10;
        }

    label_84:
        short v1_1 = ((short)v1);
        v5 = Float.floatToRawIntBits(arg18);
        v6 = v5 >>> 0x1F;
        v9 = v5 >>> 23 & v7;
        int v16 = v5 & v8;
        if(v9 == v7) {
            v5 = v16 != 0 ? v12 : 0;
            v9 = v15;
            goto label_126;
        }
        else {
            v9 += 0xFFFFFF90;
            if(v9 >= v15) {
                v9 = v13;
                v5 = 0;
                goto label_126;
            }

            if(v9 <= 0) {
                if(v9 >= v11) {
                    v5 = (v16 | v10) >> 1 - v9;
                    if((v5 & 0x1000) != 0) {
                        v5 += 0x2000;
                    }

                    v5 >>= 13;
                    v9 = 0;
                    goto label_126;
                }

                v5 = 0;
                v9 = 0;
                goto label_126;
            }

            v16 >>= 13;
            if((v5 & 0x1000) != 0) {
                v5 = (v9 << 10 | v16) + 1 | v6 << 15;
                goto label_130;
            }

            v5 = v16;
        label_126:
            v5 |= v6 << 15 | v9 << 10;
        }

    label_130:
        short v5_1 = ((short)v5);
        v6 = Float.floatToRawIntBits(arg19);
        v9 = v6 >>> 0x1F;
        v16 = v2;
        v2 = v6 >>> 23 & v7;
        v8 &= v6;
        if(v2 == v7) {
            if(v8 != 0) {
            }
            else {
                v12 = 0;
            }

            v14 = v12;
            v13 = v15;
            goto label_171;
        }
        else {
            v2 += 0xFFFFFF90;
            if(v2 < v15) {
                if(v2 <= 0) {
                    if(v2 >= v11) {
                        v2 = (v8 | v10) >> 1 - v2;
                        if((v2 & 0x1000) != 0) {
                            v2 += 0x2000;
                        }

                        v13 = 0;
                        v14 = v2 >> 13;
                        goto label_171;
                    }

                    v13 = 0;
                    goto label_171;
                }

                v14 = v8 >> 13;
                if((v6 & 0x1000) != 0) {
                    v2 = (v2 << 10 | v14) + 1 | v9 << 15;
                    goto label_175;
                }

                v13 = v2;
            }

        label_171:
            v2 = v9 << 15 | v13 << 10 | v14;
        }

    label_175:
        return Color.constructor-impl(ULong.constructor-impl(((((long)(((short)v2)))) & 0xFFFF) << v3 | (((((long)v1_1)) & 0xFFFF) << 0x30 | ((((long)v5_1)) & 0xFFFF) << v16) | ((((long)(((int)(Math.max(0f, Math.min(v0, 1f)) * 1023f + v4))))) & 0x3FF) << 6 | (((long)arg21.getId$ui_graphics())) & 0x3F));
    }

    public static long UncheckedColor$default(float arg0, float arg1, float arg2, float arg3, ColorSpace arg4, int arg5, Object arg6) {
        Rgb v4;
        if((arg5 & 8) != 0) {
            arg3 = 1f;
        }

        if((arg5 & 16) != 0) {
            v4 = ColorSpaces.INSTANCE.getSrgb();
        }

        return ColorKt.UncheckedColor(arg0, arg1, arg2, arg3, ((ColorSpace)v4));
    }

    private static final float compositeComponent(float arg2, float arg3, float arg4, float arg5, float arg6) {
        if(arg6 == 0f) {
            return 0;
        }

        return (arg2 * arg4 + arg3 * arg5 * (1f - arg4)) / arg6;
    }

    public static final long compositeOver--OWjLjI(long arg9, long arg11) {
        arg9 = Color.convert-vNxB06k(arg9, Color.getColorSpace-impl(arg11));
        float v0 = Color.getAlpha-impl(arg11);
        float v1 = Color.getAlpha-impl(arg9);
        float v2 = 1f - v1;
        float v3 = v0 * v2 + v1;
        float v4 = Color.getRed-impl(arg9);
        float v5 = Color.getRed-impl(arg11);
        float v6 = 0f;
        int v7 = Float.compare(v3, 0f);
        v4 = v7 == 0 ? 0f : (v4 * v1 + v5 * v0 * v2) / v3;
        v5 = Color.getGreen-impl(arg9);
        float v8 = Color.getGreen-impl(arg11);
        v5 = v7 == 0 ? 0f : (v5 * v1 + v8 * v0 * v2) / v3;
        float v9 = Color.getBlue-impl(arg9);
        float v10 = Color.getBlue-impl(arg11);
        if(v7 == 0) {
        }
        else {
            v6 = (v9 * v1 + v10 * v0 * v2) / v3;
        }

        return ColorKt.UncheckedColor(v4, v5, v6, v3, Color.getColorSpace-impl(arg11));
    }

    private static final float[] getComponents-8_81llA(long arg4) {
        return new float[]{Color.getRed-impl(arg4), Color.getGreen-impl(arg4), Color.getBlue-impl(arg4), Color.getAlpha-impl(arg4)};
    }

    public static void getUnspecifiedColor$annotations() {
    }

    public static final boolean isSpecified-8_81llA(long arg2) {
        if(arg2 != 16) {
            return 1;
        }

        return 0;
    }

    public static void isSpecified-8_81llA$annotations(long arg0) {
    }

    public static final boolean isUnspecified-8_81llA(long arg2) {
        if(arg2 == 16) {
            return 1;
        }

        return 0;
    }

    public static void isUnspecified-8_81llA$annotations(long arg0) {
    }

    public static final long lerp-jxsXWHM(long arg9, long arg11, float arg13) {
        ColorSpace v0 = ColorSpaces.INSTANCE.getOklab();
        arg9 = Color.convert-vNxB06k(arg9, v0);
        long v1 = Color.convert-vNxB06k(arg11, v0);
        float v3 = Color.getAlpha-impl(arg9);
        float v4 = Color.getRed-impl(arg9);
        float v5 = Color.getGreen-impl(arg9);
        float v9 = Color.getBlue-impl(arg9);
        float v10 = Color.getAlpha-impl(v1);
        float v6 = Color.getRed-impl(v1);
        float v7 = Color.getGreen-impl(v1);
        float v1_1 = Color.getBlue-impl(v1);
        if(arg13 < 0f) {
            arg13 = 0f;
        }

        float v2 = 1f;
        if(0f > v2) {
            arg13 = v2;
        }

        return Color.convert-vNxB06k(ColorKt.UncheckedColor(MathHelpersKt.lerp(v4, v6, arg13), MathHelpersKt.lerp(v5, v7, arg13), MathHelpersKt.lerp(v9, v1_1, arg13), MathHelpersKt.lerp(v3, v10, arg13), v0), Color.getColorSpace-impl(arg11));
    }

    public static final float luminance-8_81llA(long arg7) {
        ColorSpace v0 = Color.getColorSpace-impl(arg7);
        if(!ColorModel.equals-impl0(v0.getModel-xdoWZVw(), ColorModel.Companion.getRgb-xdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.toString-impl(v0.getModel-xdoWZVw()));
        }

        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction v0_1 = ((Rgb)v0).getEotfFunc$ui_graphics();
        float v7 = ((float)(v0_1.invoke(((double)Color.getRed-impl(arg7))) * 0.2126 + v0_1.invoke(((double)Color.getGreen-impl(arg7))) * 0.7152 + v0_1.invoke(((double)Color.getBlue-impl(arg7))) * 0.0722));
        if(v7 < 0f) {
            v7 = 0f;
        }

        float v8 = 1f;
        if(v7 > v8) {
            return v8;
        }

        return v7;
    }

    public static final long takeOrElse-DxMtmZc(long arg2, Function0 arg4) {
        if(arg2 != 16) {
            return arg2;
        }

        return arg4.invoke().unbox-impl();
    }

    public static final int toArgb-8_81llA(long arg1) {
        return ((int)ULong.constructor-impl(Color.convert-vNxB06k(arg1, ColorSpaces.INSTANCE.getSrgb()) >>> 0x20));
    }
}

