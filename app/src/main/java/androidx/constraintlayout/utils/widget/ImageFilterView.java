package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;

public class ImageFilterView extends AppCompatImageView {
    class ImageMatrix {
        float[] m;
        float mBrightness;
        ColorMatrix mColorMatrix;
        float mContrast;
        float mSaturation;
        ColorMatrix mTmpColorMatrix;
        float mWarmth;

        ImageMatrix() {
            super();
            this.m = new float[20];
            this.mColorMatrix = new ColorMatrix();
            this.mTmpColorMatrix = new ColorMatrix();
            this.mBrightness = 1f;
            this.mSaturation = 1f;
            this.mContrast = 1f;
            this.mWarmth = 1f;
        }

        private void brightness(float arg3) {
            float[] v2 = this.m;
            v2[0] = arg3;
            v2[1] = 0f;
            v2[2] = 0f;
            v2[3] = 0f;
            v2[4] = 0f;
            v2[5] = 0f;
            v2[6] = arg3;
            v2[7] = 0f;
            v2[8] = 0f;
            v2[9] = 0f;
            v2[10] = 0f;
            v2[11] = 0f;
            v2[12] = arg3;
            v2[13] = 0f;
            v2[14] = 0f;
            v2[15] = 0f;
            v2[16] = 0f;
            v2[17] = 0f;
            v2[18] = 1f;
            v2[19] = 0f;
        }

        private void saturation(float arg8) {
            float v1 = 1f - arg8;
            float v2 = 0.2999f * v1;
            float v3 = 0.587f * v1;
            v1 *= 0.114f;
            float[] v7 = this.m;
            v7[0] = v2 + arg8;
            v7[1] = v3;
            v7[2] = v1;
            v7[3] = 0f;
            v7[4] = 0f;
            v7[5] = v2;
            v7[6] = v3 + arg8;
            v7[7] = v1;
            v7[8] = 0f;
            v7[9] = 0f;
            v7[10] = v2;
            v7[11] = v3;
            v7[12] = v1 + arg8;
            v7[13] = 0f;
            v7[14] = 0f;
            v7[15] = 0f;
            v7[16] = 0f;
            v7[17] = 0f;
            v7[18] = 1f;
            v7[19] = 0f;
        }

        void updateMatrix(ImageView arg6) {
            int v0_1;
            this.mColorMatrix.reset();
            float v0 = this.mSaturation;
            float v1 = 1f;
            int v3 = 1;
            if(Float.compare(v0, v1) != 0) {
                this.saturation(v0);
                this.mColorMatrix.set(this.m);
                v0_1 = 1;
            }
            else {
                v0_1 = 0;
            }

            float v2 = this.mContrast;
            if(v2 != v1) {
                this.mTmpColorMatrix.setScale(v2, v2, v2, v1);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                v0_1 = 1;
            }

            v2 = this.mWarmth;
            if(v2 != v1) {
                this.warmth(v2);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                v0_1 = 1;
            }

            v2 = this.mBrightness;
            if(v2 != v1) {
                this.brightness(v2);
                this.mTmpColorMatrix.set(this.m);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
            }
            else {
                v3 = v0_1;
            }

            if(v3 != 0) {
                arg6.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
                return;
            }

            arg6.clearColorFilter();
        }

        private void warmth(float arg12) {
            float v6_1;
            float v2;
            if(arg12 <= 0f) {
                arg12 = 0.01f;
            }

            float v1 = 5000f / arg12 / 100f;
            arg12 = 66f;
            float v3 = 161.119568f;
            float v4 = 99.470802f;
            float v5 = 255f;
            if(Float.compare(v1, arg12) > 0) {
                double v6 = ((double)(v1 - 60f));
                v2 = (((float)Math.pow(v6, -0.133205))) * 329.69873f;
                v6_1 = (((float)Math.pow(v6, 0.075515))) * 288.122162f;
            }
            else {
                v6_1 = (((float)Math.log(((double)v1)))) * v4 - v3;
                v2 = v5;
            }

            float v7 = 305.0448f;
            float v8 = 138.517731f;
            if(Float.compare(v1, arg12) >= 0) {
                arg12 = v5;
            }
            else if(v1 > 19f) {
                arg12 = (((float)Math.log(((double)(v1 - 10f))))) * v8 - v7;
            }
            else {
                arg12 = 0f;
            }

            v1 = Math.min(v5, Math.max(v2, 0f));
            v2 = Math.min(v5, Math.max(v6_1, 0f));
            arg12 = Math.min(v5, Math.max(arg12, 0f));
            v6_1 = (((float)Math.log(50))) * v4 - v3;
            v3 = (((float)Math.log(40))) * v8 - v7;
            v4 = Math.min(v5, Math.max(v5, 0f));
            v6_1 = Math.min(v5, Math.max(v6_1, 0f));
            arg12 /= Math.min(v5, Math.max(v3, 0f));
            float[] v11 = this.m;
            v11[0] = v1 / v4;
            v11[1] = 0f;
            v11[2] = 0f;
            v11[3] = 0f;
            v11[4] = 0f;
            v11[5] = 0f;
            v11[6] = v2 / v6_1;
            v11[7] = 0f;
            v11[8] = 0f;
            v11[9] = 0f;
            v11[10] = 0f;
            v11[11] = 0f;
            v11[12] = arg12;
            v11[13] = 0f;
            v11[14] = 0f;
            v11[15] = 0f;
            v11[16] = 0f;
            v11[17] = 0f;
            v11[18] = 1f;
            v11[19] = 0f;
        }
    }

    private float mCrossfade;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    RectF mRect;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterView(Context arg2) {
        super(arg2);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.init(arg2, null);
    }

    public ImageFilterView(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.init(arg2, arg3);
    }

    public ImageFilterView(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.init(arg1, arg2);
    }

    static float access$000(ImageFilterView arg0) {
        return arg0.mRoundPercent;
    }

    static float access$100(ImageFilterView arg0) {
        return arg0.mRound;
    }

    public void draw(Canvas arg1) {
        super.draw(arg1);
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    private void init(Context arg7, AttributeSet arg8) {
        if(arg8 != null) {
            TypedArray v7 = this.getContext().obtainStyledAttributes(arg8, styleable.ImageFilterView);
            int v8 = v7.getIndexCount();
            Drawable v0 = v7.getDrawable(styleable.ImageFilterView_altSrc);
            int v2;
            for(v2 = 0; v2 < v8; ++v2) {
                int v3 = v7.getIndex(v2);
                if(v3 == styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = v7.getFloat(v3, 0f);
                }
                else if(v3 == styleable.ImageFilterView_warmth) {
                    this.setWarmth(v7.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_saturation) {
                    this.setSaturation(v7.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_contrast) {
                    this.setContrast(v7.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_round) {
                    this.setRound(v7.getDimension(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_roundPercent) {
                    this.setRoundPercent(v7.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_overlay) {
                    this.setOverlay(v7.getBoolean(v3, this.mOverlay));
                }
            }

            v7.recycle();
            if(v0 == null) {
                return;
            }

            Drawable[] v7_1 = new Drawable[2];
            this.mLayers = v7_1;
            v7_1[0] = this.getDrawable();
            this.mLayers[1] = v0;
            LayerDrawable v7_2 = new LayerDrawable(this.mLayers);
            this.mLayer = v7_2;
            v7_2.getDrawable(1).setAlpha(((int)(this.mCrossfade * 255f)));
            super.setImageDrawable(this.mLayer);
        }
    }

    public void setBrightness(float arg2) {
        this.mImageMatrix.mBrightness = arg2;
        this.mImageMatrix.updateMatrix(((ImageView)this));
    }

    public void setContrast(float arg2) {
        this.mImageMatrix.mContrast = arg2;
        this.mImageMatrix.updateMatrix(((ImageView)this));
    }

    public void setCrossfade(float arg4) {
        this.mCrossfade = arg4;
        if(this.mLayers != null) {
            float v0 = 255f;
            if(!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha(((int)((1f - this.mCrossfade) * v0)));
            }

            this.mLayer.getDrawable(1).setAlpha(((int)(this.mCrossfade * v0)));
            super.setImageDrawable(this.mLayer);
        }
    }

    private void setOverlay(boolean arg1) {
        this.mOverlay = arg1;
    }

    public void setRound(float arg5) {
        if(Float.isNaN(arg5)) {
            this.mRound = arg5;
            arg5 = this.mRoundPercent;
            this.mRoundPercent = -1f;
            this.setRoundPercent(arg5);
            return;
        }

        int v0 = Float.compare(this.mRound, arg5) != 0 ? 1 : 0;
        this.mRound = arg5;
        if(arg5 != 0f) {
            if(this.mPath == null) {
                this.mPath = new Path();
            }

            if(this.mRect == null) {
                this.mRect = new RectF();
            }

            if(this.mViewOutlineProvider == null) {
                androidx.constraintlayout.utils.widget.ImageFilterView$2 v5 = new ViewOutlineProvider() {
                    public void getOutline(View arg7, Outline arg8) {
                        arg8.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.mRound);
                    }
                };
                this.mViewOutlineProvider = ((ViewOutlineProvider)v5);
                this.setOutlineProvider(((ViewOutlineProvider)v5));
            }

            this.setClipToOutline(true);
            this.mRect.set(0f, 0f, ((float)this.getWidth()), ((float)this.getHeight()));
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, this.mRound, this.mRound, Path$Direction.CW);
        }
        else {
            this.setClipToOutline(false);
        }

        if(v0 != 0) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float arg6) {
        int v0 = Float.compare(this.mRoundPercent, arg6) != 0 ? 1 : 0;
        this.mRoundPercent = arg6;
        if(arg6 != 0f) {
            if(this.mPath == null) {
                this.mPath = new Path();
            }

            if(this.mRect == null) {
                this.mRect = new RectF();
            }

            if(this.mViewOutlineProvider == null) {
                androidx.constraintlayout.utils.widget.ImageFilterView$1 v6 = new ViewOutlineProvider() {
                    public void getOutline(View arg7, Outline arg8) {
                        int v3 = ImageFilterView.this.getWidth();
                        int v4 = ImageFilterView.this.getHeight();
                        arg8.setRoundRect(0, 0, v3, v4, (((float)Math.min(v3, v4))) * ImageFilterView.this.mRoundPercent / 2f);
                    }
                };
                this.mViewOutlineProvider = ((ViewOutlineProvider)v6);
                this.setOutlineProvider(((ViewOutlineProvider)v6));
            }

            this.setClipToOutline(true);
            int v6_1 = this.getWidth();
            int v1 = this.getHeight();
            float v2 = (((float)Math.min(v6_1, v1))) * this.mRoundPercent / 2f;
            this.mRect.set(0f, 0f, ((float)v6_1), ((float)v1));
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, v2, v2, Path$Direction.CW);
        }
        else {
            this.setClipToOutline(false);
        }

        if(v0 != 0) {
            this.invalidateOutline();
        }
    }

    public void setSaturation(float arg2) {
        this.mImageMatrix.mSaturation = arg2;
        this.mImageMatrix.updateMatrix(((ImageView)this));
    }

    public void setWarmth(float arg2) {
        this.mImageMatrix.mWarmth = arg2;
        this.mImageMatrix.updateMatrix(((ImageView)this));
    }
}

