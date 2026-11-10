package androidx.core.view;

import android.graphics.Matrix;
import android.graphics.Path;
import android.view.DisplayShape;
import androidx.core.graphics.PathParser;
import java.util.Objects;

public final class DisplayShapeCompat {
    class Impl34 implements Impl {
        private final DisplayShape mPlatformDisplayShape;

        Impl34(DisplayShape arg1) {
            super();
            this.mPlatformDisplayShape = arg1;
        }

        public boolean equals(Object arg2) {
            if(this == (((Impl34)arg2))) {
                return 1;
            }

            if(!(arg2 instanceof Impl34)) {
                return 0;
            }

            return Objects.equals(this.mPlatformDisplayShape, ((Impl34)arg2).mPlatformDisplayShape);
        }

        public Path getPath() {
            return this.mPlatformDisplayShape.getPath();
        }

        public DisplayShape getPlatformDisplayShape() {
            return this.mPlatformDisplayShape;
        }

        public int hashCode() {
            return Objects.hashCode(this.mPlatformDisplayShape);
        }

        public String toString() {
            return "DisplayShapeCompat{mPlatformDisplayShape=" + this.mPlatformDisplayShape + '}';
        }
    }

    interface Impl {
        Path getPath();

        DisplayShape getPlatformDisplayShape();
    }

    class ImplBase implements Impl {
        private Path mCachedPath;
        private final int mDisplayHeight;
        private final String mDisplayShapeSpec;
        private final int mDisplayWidth;
        private final int mOffsetX;
        private final int mOffsetY;
        private final float mPhysicalPixelDisplaySizeRatio;
        private final int mRotation;
        private final float mScale;

        ImplBase(String arg1, int arg2, int arg3, float arg4, int arg5, int arg6, int arg7, float arg8) {
            super();
            this.mDisplayShapeSpec = arg1;
            this.mDisplayWidth = arg2;
            this.mDisplayHeight = arg3;
            this.mPhysicalPixelDisplaySizeRatio = arg4;
            this.mRotation = arg5;
            this.mOffsetX = arg6;
            this.mOffsetY = arg7;
            this.mScale = arg8;
        }

        public boolean equals(Object arg5) {
            if(this == (((ImplBase)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof ImplBase)) {
                return 0;
            }

            if((Objects.equals(this.mDisplayShapeSpec, ((ImplBase)arg5).mDisplayShapeSpec)) && this.mDisplayWidth == ((ImplBase)arg5).mDisplayWidth && this.mDisplayHeight == ((ImplBase)arg5).mDisplayHeight && this.mPhysicalPixelDisplaySizeRatio == ((ImplBase)arg5).mPhysicalPixelDisplaySizeRatio && this.mRotation == ((ImplBase)arg5).mRotation && this.mOffsetX == ((ImplBase)arg5).mOffsetX && this.mOffsetY == ((ImplBase)arg5).mOffsetY && this.mScale == ((ImplBase)arg5).mScale) {
                return 1;
            }

            return 0;
        }

        public Path getPath() {
            float v3;
            float v2_1;
            Path v0 = this.mCachedPath;
            if(v0 != null) {
                return v0;
            }

            String v0_1 = this.mDisplayShapeSpec;
            if(v0_1 != null) {
                if(v0_1.isEmpty()) {
                }
                else {
                    try {
                        v0 = PathParser.createPathFromPathData(this.mDisplayShapeSpec);
                    }
                    catch(RuntimeException v0_2) {
                        throw new IllegalArgumentException("Failed to parse DisplayShapeCompat path data: " + this.mDisplayShapeSpec, ((Throwable)v0_2));
                    }

                    if(!v0.isEmpty()) {
                        Matrix v1 = new Matrix();
                        int v2 = this.mRotation;
                        if(v2 != 0) {
                            float v4 = 0f;
                            if(v2 != 1) {
                                if(v2 == 2) {
                                    v4 = ((float)this.mDisplayWidth);
                                    v2_1 = ((float)this.mDisplayHeight);
                                    v3 = 180f;
                                }
                                else if(v2 != 3) {
                                    v2_1 = 0f;
                                    v3 = 0f;
                                    goto label_46;
                                }
                                else {
                                    v2_1 = ((float)this.mDisplayHeight);
                                    v3 = 270f;
                                }

                                float v5 = v3;
                                v3 = v2_1;
                                v2_1 = v4;
                                v4 = v5;
                            }
                            else {
                                v2_1 = ((float)this.mDisplayWidth);
                                v4 = 90f;
                                v3 = 0f;
                            }

                        label_46:
                            v1.preRotate(v4, v2_1, v3);
                        }

                        v2_1 = this.mPhysicalPixelDisplaySizeRatio;
                        v3 = 1f;
                        if(v2_1 != v3) {
                            v1.preScale(v2_1, v2_1);
                        }

                        v2 = this.mOffsetX;
                        if(v2 != 0 || this.mOffsetY != 0) {
                            v1.postTranslate(((float)v2), ((float)this.mOffsetY));
                        }

                        v2_1 = this.mScale;
                        if(v2_1 != v3) {
                            v1.postScale(v2_1, v2_1);
                        }

                        v0.transform(v1);
                    }

                    this.mCachedPath = v0;
                    return v0;
                }
            }

            return new Path();
        }

        public DisplayShape getPlatformDisplayShape() {
            return null;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mDisplayShapeSpec, Integer.valueOf(this.mDisplayWidth), Integer.valueOf(this.mDisplayHeight), Float.valueOf(this.mPhysicalPixelDisplaySizeRatio), Integer.valueOf(this.mRotation), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), Float.valueOf(this.mScale)});
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("DisplayShapeCompat{ spec=");
            String v1 = this.mDisplayShapeSpec;
            if(v1 != null) {
                Integer v1_1 = Integer.valueOf(v1.hashCode());
            }
            else {
                v1 = "null";
            }

            return v0.append(v1).append(" displayWidth=").append(this.mDisplayWidth).append(" displayHeight=").append(this.mDisplayHeight).append(" physicalPixelDisplaySizeRatio=").append(this.mPhysicalPixelDisplaySizeRatio).append(" rotation=").append(this.mRotation).append(" offsetX=").append(this.mOffsetX).append(" offsetY=").append(this.mOffsetY).append(" scale=").append(this.mScale).append("}").toString();
        }
    }

    static final DisplayShapeCompat EMPTY = null;
    private static final String TAG = "DisplayShapeCompat";
    private final Impl mImpl;

    static {
        DisplayShapeCompat.EMPTY = new DisplayShapeCompat("", 0, 0, 1f, 0, 0, 0, 1f);
    }

    private DisplayShapeCompat(String arg10, int arg11, int arg12, float arg13, int arg14, int arg15, int arg16, float arg17) {
        super();
        this.mImpl = new ImplBase(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    private DisplayShapeCompat(DisplayShape arg2) {
        super();
        this.mImpl = new Impl34(arg2);
    }

    public static DisplayShapeCompat create(int arg9, int arg10, boolean arg11, int arg12, int arg13, int arg14, int arg15) {
        return new DisplayShapeCompat(DisplayShapeCompat.createSpecString(arg9, arg10, arg11, arg12, arg13, arg14, arg15), arg9, arg10, 1f, 0, 0, 0, 1f);
    }

    public static DisplayShapeCompat create(String arg9, float arg10, int arg11, int arg12) {
        return new DisplayShapeCompat(arg9, arg11, arg12, arg10, 0, 0, 0, 1f);
    }

    private static String createSpecString(int arg7, int arg8, boolean arg9, int arg10, int arg11, int arg12, int arg13) {
        String v0 = " Z";
        String v1 = ",";
        if(arg9) {
            int v9 = arg7 / 2;
            arg8 /= 2;
            return "M0," + arg8 + " A" + v9 + v1 + arg8 + " 0 1,1 " + arg7 + v1 + arg8 + " A" + v9 + v1 + arg8 + " 0 1,1 0," + arg8 + v0;
        }

        StringBuilder v9_1 = new StringBuilder("M ");
        int v2 = Math.min(arg7 / 2, arg8 / 2);
        arg10 = Math.min(v2, arg10);
        arg11 = Math.min(v2, arg11);
        arg12 = Math.min(v2, arg12);
        arg13 = Math.min(v2, arg13);
        v9_1.append(arg10).append(",0 L ");
        String v3 = ",0";
        v9_1.append(arg7 - arg11).append(v3);
        String v2_1 = " 0 0,1 ";
        String v4 = " A ";
        if(arg11 > 0) {
            v9_1.append(v4).append(arg11).append(v1).append(arg11).append(v2_1).append(arg7).append(v1).append(arg11);
        }

        String v11 = " L ";
        v9_1.append(v11).append(arg7).append(v1).append(arg8 - arg12);
        if(arg12 > 0) {
            v9_1.append(v4).append(arg12).append(v1).append(arg12).append(v2_1).append(arg7 - arg12).append(v1).append(arg8);
        }

        v9_1.append(v11).append(arg13).append(v1).append(arg8);
        if(arg13 > 0) {
            v9_1.append(v4).append(arg13).append(v1).append(arg13).append(" 0 0,1 0,").append(arg8 - arg13);
        }

        if(arg10 > 0) {
            v9_1.append(" L 0,").append(arg10);
            v9_1.append(v4).append(arg10).append(v1).append(arg10).append(v2_1).append(arg10).append(v3);
        }

        v9_1.append(v0);
        return v9_1.toString();
    }

    public boolean equals(Object arg2) {
        if(this == (((DisplayShapeCompat)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof DisplayShapeCompat)) {
            return 0;
        }

        return Objects.equals(this.mImpl, ((DisplayShapeCompat)arg2).mImpl);
    }

    public Path getPath() {
        return this.mImpl.getPath();
    }

    public int hashCode() {
        return Objects.hashCode(this.mImpl);
    }

    static DisplayShapeCompat toDisplayShapeCompat(DisplayShape arg1) {
        if(arg1 == null) {
            return null;
        }

        return new DisplayShapeCompat(arg1);
    }

    static DisplayShape toPlatformDisplayShape(DisplayShapeCompat arg0) {
        if(arg0 == null) {
            return null;
        }

        return arg0.mImpl.getPlatformDisplayShape();
    }

    public String toString() {
        return this.mImpl.toString();
    }
}

