package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R$styleable;

public class ImageFilterButton extends AppCompatImageButton {
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

    public ImageFilterButton(Context arg2) {
        super(arg2);
        this.mImageMatrix = new ImageMatrix();
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.mOverlay = true;
        this.init(arg2, null);
    }

    public ImageFilterButton(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mImageMatrix = new ImageMatrix();
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.mOverlay = true;
        this.init(arg2, arg3);
    }

    public ImageFilterButton(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mImageMatrix = new ImageMatrix();
        this.mCrossfade = 0f;
        this.mRoundPercent = 0f;
        this.mRound = NaNf;
        this.mOverlay = true;
        this.init(arg1, arg2);
    }

    static float access$000(ImageFilterButton arg0) {
        return arg0.mRoundPercent;
    }

    static float access$100(ImageFilterButton arg0) {
        return arg0.mRound;
    }

    public void draw(Canvas arg1) {
        super.draw(arg1);
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
        this.setPadding(0, 0, 0, 0);
        if(arg8 != null) {
            TypedArray v8 = this.getContext().obtainStyledAttributes(arg8, styleable.ImageFilterView);
            int v0 = v8.getIndexCount();
            Drawable v1 = v8.getDrawable(styleable.ImageFilterView_altSrc);
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v8.getIndex(v2);
                if(v3 == styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = v8.getFloat(v3, 0f);
                }
                else if(v3 == styleable.ImageFilterView_warmth) {
                    this.setWarmth(v8.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_saturation) {
                    this.setSaturation(v8.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_contrast) {
                    this.setContrast(v8.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_round) {
                    this.setRound(v8.getDimension(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_roundPercent) {
                    this.setRoundPercent(v8.getFloat(v3, 0f));
                }
                else if(v3 == styleable.ImageFilterView_overlay) {
                    this.setOverlay(v8.getBoolean(v3, this.mOverlay));
                }
            }

            v8.recycle();
            if(v1 == null) {
                return;
            }

            Drawable[] v8_1 = new Drawable[2];
            this.mLayers = v8_1;
            v8_1[0] = this.getDrawable();
            this.mLayers[1] = v1;
            LayerDrawable v7 = new LayerDrawable(this.mLayers);
            this.mLayer = v7;
            v7.getDrawable(1).setAlpha(((int)(this.mCrossfade * 255f)));
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
                androidx.constraintlayout.utils.widget.ImageFilterButton$2 v5 = new ViewOutlineProvider() {
                    public void getOutline(View arg7, Outline arg8) {
                        arg8.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.mRound);
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
                androidx.constraintlayout.utils.widget.ImageFilterButton$1 v6 = new ViewOutlineProvider() {
                    public void getOutline(View arg7, Outline arg8) {
                        int v3 = ImageFilterButton.this.getWidth();
                        int v4 = ImageFilterButton.this.getHeight();
                        arg8.setRoundRect(0, 0, v3, v4, (((float)Math.min(v3, v4))) * ImageFilterButton.this.mRoundPercent / 2f);
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

