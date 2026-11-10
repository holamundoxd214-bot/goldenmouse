package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView$ScaleType;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    public interface OnSharedElementsReadyListener {
        void onSharedElementsReady();
    }

    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 0x100000;
    private Matrix mTempMatrix;

    public SharedElementCallback() {
        super();
    }

    private static Bitmap createDrawableBitmap(Drawable arg9) {
        int v0 = arg9.getIntrinsicWidth();
        int v1 = arg9.getIntrinsicHeight();
        if(v0 > 0) {
            if(v1 <= 0) {
            }
            else {
                float v2 = 1f;
                float v3 = Math.min(v2, 1048576f / (((float)(v0 * v1))));
                if(((arg9 instanceof BitmapDrawable)) && v3 == v2) {
                    return ((BitmapDrawable)arg9).getBitmap();
                }

                v0 = ((int)((((float)v0)) * v3));
                v1 = ((int)((((float)v1)) * v3));
                Bitmap v2_1 = Bitmap.createBitmap(v0, v1, Bitmap$Config.ARGB_8888);
                Canvas v3_1 = new Canvas(v2_1);
                Rect v4 = arg9.getBounds();
                int v5 = v4.left;
                int v6 = v4.top;
                int v7 = v4.right;
                int v4_1 = v4.bottom;
                arg9.setBounds(0, 0, v0, v1);
                arg9.draw(v3_1);
                arg9.setBounds(v5, v6, v7, v4_1);
                return v2_1;
            }
        }

        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View arg5, Matrix arg6, RectF arg7) {
        if((arg5 instanceof ImageView)) {
            View v0 = arg5;
            Drawable v1 = ((ImageView)v0).getDrawable();
            Drawable v2 = ((ImageView)v0).getBackground();
            if(v1 != null && v2 == null) {
                Bitmap v1_1 = SharedElementCallback.createDrawableBitmap(v1);
                if(v1_1 != null) {
                    Bundle v4 = new Bundle();
                    v4.putParcelable("sharedElement:snapshot:bitmap", ((Parcelable)v1_1));
                    v4.putString("sharedElement:snapshot:imageScaleType", ((ImageView)v0).getScaleType().toString());
                    if(((ImageView)v0).getScaleType() == ImageView$ScaleType.MATRIX) {
                        Matrix v5 = ((ImageView)v0).getImageMatrix();
                        float[] v6 = new float[9];
                        v5.getValues(v6);
                        v4.putFloatArray("sharedElement:snapshot:imageMatrix", v6);
                    }

                    return ((Parcelable)v4);
                }
            }
        }

        int v0_1 = Math.round(arg7.width());
        int v1_2 = Math.round(arg7.height());
        if(v0_1 > 0 && v1_2 > 0) {
            float v2_1 = Math.min(1f, 1048576f / (((float)(v0_1 * v1_2))));
            v0_1 = ((int)((((float)v0_1)) * v2_1));
            v1_2 = ((int)((((float)v1_2)) * v2_1));
            Matrix v3 = this.mTempMatrix;
            if(v3 == null) {
                v3 = new Matrix();
                this.mTempMatrix = v3;
            }

            v3.set(arg6);
            this.mTempMatrix.postTranslate(-arg7.left, -arg7.top);
            this.mTempMatrix.postScale(v2_1, v2_1);
            Bitmap v6_1 = Bitmap.createBitmap(v0_1, v1_2, Bitmap$Config.ARGB_8888);
            Canvas v7 = new Canvas(v6_1);
            v7.concat(this.mTempMatrix);
            arg5.draw(v7);
            return ((Parcelable)v6_1);
        }

        return null;
    }

    public View onCreateSnapshotView(Context arg2, Parcelable arg3) {
        View v0 = null;
        if((arg3 instanceof Bundle)) {
            Parcelable v1 = ((Bundle)arg3).getParcelable("sharedElement:snapshot:bitmap");
            if(v1 == null) {
                return v0;
            }

            ImageView v0_1 = new ImageView(arg2);
            v0_1.setImageBitmap(((Bitmap)v1));
            v0_1.setScaleType(ImageView$ScaleType.valueOf(((Bundle)arg3).getString("sharedElement:snapshot:imageScaleType")));
            if(v0_1.getScaleType() == ImageView$ScaleType.MATRIX) {
                float[] v1_1 = ((Bundle)arg3).getFloatArray("sharedElement:snapshot:imageMatrix");
                Matrix v2 = new Matrix();
                v2.setValues(v1_1);
                v0_1.setImageMatrix(v2);
            }

            return ((View)v0_1);
        }

        if((arg3 instanceof Bitmap)) {
            ImageView v1_2 = new ImageView(arg2);
            v1_2.setImageBitmap(((Bitmap)arg3));
            return ((View)v1_2);
        }

        return v0;
    }

    public void onMapSharedElements(List arg1, Map arg2) {
    }

    public void onRejectSharedElements(List arg1) {
    }

    public void onSharedElementEnd(List arg1, List arg2, List arg3) {
    }

    public void onSharedElementStart(List arg1, List arg2, List arg3) {
    }

    public void onSharedElementsArrived(List arg1, List arg2, OnSharedElementsReadyListener arg3) {
        arg3.onSharedElementsReady();
    }
}

