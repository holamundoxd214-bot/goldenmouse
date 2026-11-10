package androidx.core.graphics;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace$Named;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build$VERSION;
import androidx.annotation.ReplaceWith;

public final class BitmapCompat {
    class Api27Impl {
        private Api27Impl() {
            super();
        }

        static Bitmap copyBitmapIfHardware(Bitmap arg3) {
            if(arg3.getConfig() == Bitmap$Config.HARDWARE) {
                Bitmap$Config v0 = Bitmap$Config.ARGB_8888;
                if(Build$VERSION.SDK_INT >= 0x1F) {
                    v0 = Api31Impl.getHardwareBitmapConfig(arg3);
                }

                arg3 = arg3.copy(v0, true);
            }

            return arg3;
        }

        static Bitmap createBitmapWithSourceColorspace(int arg3, int arg4, Bitmap arg5, boolean arg6) {
            Bitmap$Config v0 = arg5.getConfig();
            ColorSpace v1 = arg5.getColorSpace();
            ColorSpace v2 = ColorSpace.get(ColorSpace$Named.LINEAR_EXTENDED_SRGB);
            if((arg6) && !arg5.getColorSpace().equals(v2)) {
                v0 = Bitmap$Config.RGBA_F16;
                v1 = v2;
            }
            else if(arg5.getConfig() == Bitmap$Config.HARDWARE) {
                v0 = Bitmap$Config.ARGB_8888;
                if(Build$VERSION.SDK_INT >= 0x1F) {
                    v0 = Api31Impl.getHardwareBitmapConfig(arg5);
                }
            }

            return Bitmap.createBitmap(arg3, arg4, v0, arg5.hasAlpha(), v1);
        }

        static boolean isAlreadyF16AndLinear(Bitmap arg3) {
            ColorSpace v0 = ColorSpace.get(ColorSpace$Named.LINEAR_EXTENDED_SRGB);
            if(arg3.getConfig() == Bitmap$Config.RGBA_F16 && (arg3.getColorSpace().equals(v0))) {
                return 1;
            }

            return 0;
        }
    }

    class Api29Impl {
        private Api29Impl() {
            super();
        }

        static void setPaintBlendMode(Paint arg1) {
            arg1.setBlendMode(BlendMode.SRC);
        }
    }

    class Api31Impl {
        private Api31Impl() {
            super();
        }

        static Bitmap$Config getHardwareBitmapConfig(Bitmap arg1) {
            if(arg1.getHardwareBuffer().getFormat() == 22) {
                return Bitmap$Config.RGBA_F16;
            }

            return Bitmap$Config.ARGB_8888;
        }
    }

    private BitmapCompat() {
        super();
    }

    public static Bitmap createScaledBitmap(Bitmap arg21, int arg22, int arg23, Rect arg24, boolean arg25) {
        int v12;
        Bitmap v5_1;
        int v20;
        int v14_1;
        Bitmap v10_2;
        int v10_1;
        double v10;
        int v18;
        Bitmap v0 = arg21;
        int v1 = arg22;
        int v2 = arg23;
        Rect v3 = arg24;
        if(v1 > 0 && v2 > 0) {
            if(v3 != null && ((v3.isEmpty()) || v3.left < 0 || v3.right > v0.getWidth() || v3.top < 0 || v3.bottom > v0.getHeight())) {
                throw new IllegalArgumentException("srcRect must be contained by srcBm!");
            }

            int v5 = 27;
            Bitmap v4 = Build$VERSION.SDK_INT >= v5 ? Api27Impl.copyBitmapIfHardware(v0) : v0;
            int v6 = v3 != null ? v3.width() : v0.getWidth();
            int v7 = v3 != null ? v3.height() : v0.getHeight();
            float v8 = (((float)v1)) / (((float)v6));
            float v9 = (((float)v2)) / (((float)v7));
            int v11 = v3 != null ? v3.left : 0;
            int v3_1 = v3 != null ? v3.top : 0;
            if(v11 == 0 && v3_1 == 0 && v1 == v0.getWidth() && v2 == v0.getHeight()) {
                if((v0.isMutable()) && v0 == v4) {
                    return v0.copy(v0.getConfig(), true);
                }

                return v4;
            }

            Paint v13 = new Paint(1);
            v13.setFilterBitmap(true);
            if(Build$VERSION.SDK_INT >= 29) {
                Api29Impl.setPaintBlendMode(v13);
            }
            else {
                v13.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.SRC));
            }

            if(v6 == v1 && v7 == v2) {
                v0 = Bitmap.createBitmap(v1, v2, v4.getConfig());
                new Canvas(v0).drawBitmap(v4, ((float)(-v11)), ((float)(-v3_1)), v13);
                return v0;
            }

            double v14 = Math.log(2);
            float v16 = 1f;
            if(v8 > v16) {
                v18 = v11;
                v10 = Math.ceil(Math.log(((double)v8)) / v14);
            }
            else {
                v18 = v11;
                v10 = Math.floor(Math.log(((double)v8)) / v14);
            }

            int v8_1 = ((int)v10);
            double v9_1 = v9 > v16 ? Math.ceil(Math.log(((double)v9)) / v14) : Math.floor(Math.log(((double)v9)) / v14);
            int v9_2 = ((int)v9_1);
            if(!arg25 || Build$VERSION.SDK_INT < v5 || (Api27Impl.isAlreadyF16AndLinear(v0))) {
                v10_2 = null;
                v11 = v18;
                v14_1 = 0;
            }
            else {
                v10_1 = v8_1 > 0 ? BitmapCompat.sizeAtStep(v6, v1, 1, v8_1) : v6;
                v11 = v9_2 > 0 ? BitmapCompat.sizeAtStep(v7, v2, 1, v9_2) : v7;
                v10_2 = Api27Impl.createBitmapWithSourceColorspace(v10_1, v11, v0, true);
                new Canvas(v10_2).drawBitmap(v4, ((float)(-v18)), ((float)(-v3_1)), v13);
                Bitmap v3_2 = v10_2;
                v10_2 = v4;
                v4 = v3_2;
                v14_1 = 1;
                v3_1 = 0;
                v11 = 0;
            }

            Rect v15 = new Rect(v11, v3_1, v6, v7);
            v3 = new Rect();
            v11 = v8_1;
            int v16_1;
            for(v16_1 = v9_2; true; v16_1 = v19) {
                if(v11 == 0) {
                    if(v16_1 != 0) {
                    }
                    else {
                        if(v10_2 != v0 && v10_2 != null) {
                            v10_2.recycle();
                        }

                        return v4;
                    }
                }

                if(v11 < 0) {
                    ++v11;
                }
                else if(v11 > 0) {
                    --v11;
                }

                if(v16_1 < 0) {
                    ++v16_1;
                }
                else if(v16_1 > 0) {
                    --v16_1;
                }

                v18 = v11;
                int v19 = v16_1;
                v3.set(0, 0, BitmapCompat.sizeAtStep(v6, v1, v11, v8_1), BitmapCompat.sizeAtStep(v7, v2, v16_1, v9_2));
                v5 = v18 != 0 || v19 != 0 ? 0 : 1;
                v11 = v10_2 == null || v10_2.getWidth() != v1 || v10_2.getHeight() != v2 ? 0 : 1;
                if(v10_2 == null || v10_2 == v0) {
                    v20 = v5;
                label_212:
                    if(v10_2 != v0 && v10_2 != null) {
                        v10_2.recycle();
                    }

                    v5 = v18 > 0 ? v14_1 : v18;
                    v5 = BitmapCompat.sizeAtStep(v6, v1, v5, v8_1);
                    v10_1 = v19 > 0 ? v14_1 : v19;
                    v10_1 = BitmapCompat.sizeAtStep(v7, v2, v10_1, v9_2);
                    v12 = 27;
                    if(Build$VERSION.SDK_INT >= v12) {
                        boolean v11_1 = !arg25 || v20 != 0 ? false : true;
                        v5_1 = Api27Impl.createBitmapWithSourceColorspace(v5, v10_1, v0, v11_1);
                        goto label_237;
                    }

                    v5_1 = Bitmap.createBitmap(v5, v10_1, v4.getConfig());
                }
                else {
                    if(arg25) {
                        v20 = v5;
                        if(Build$VERSION.SDK_INT >= 27) {
                            if(Api27Impl.isAlreadyF16AndLinear(v10_2)) {
                            }
                            else {
                                goto label_212;
                            }
                        }
                    }
                    else {
                        v20 = v5;
                    }

                    if(v20 != 0) {
                        if(v11 == 0) {
                            goto label_212;
                        }
                        else if(v14_1 != 0) {
                            goto label_212;
                        }
                    }

                    v5_1 = v10_2;
                    v12 = 27;
                }

            label_237:
                new Canvas(v5_1).drawBitmap(v4, v15, v3, v13);
                v15.set(v3);
                v10_2 = v4;
                v4 = v5_1;
                v11 = v18;
            }
        }

        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }

    @ReplaceWith(expression="bitmap.getAllocationByteCount()") @Deprecated public static int getAllocationByteCount(Bitmap arg0) {
        return arg0.getAllocationByteCount();
    }

    @ReplaceWith(expression="bitmap.hasMipMap()") @Deprecated public static boolean hasMipMap(Bitmap arg0) {
        return arg0.hasMipMap();
    }

    @ReplaceWith(expression="bitmap.setHasMipMap(hasMipMap)") @Deprecated public static void setHasMipMap(Bitmap arg0, boolean arg1) {
        arg0.setHasMipMap(arg1);
    }

    static int sizeAtStep(int arg1, int arg2, int arg3, int arg4) {
        if(arg3 == 0) {
            return arg2;
        }

        if(arg3 > 0) {
            return arg1 * (1 << arg4 - arg3);
        }

        return arg2 << -arg3 - 1;
    }
}

