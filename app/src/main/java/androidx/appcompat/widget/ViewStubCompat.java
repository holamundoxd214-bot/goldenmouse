package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    public interface OnInflateListener {
        void onInflate(ViewStubCompat arg1, View arg2);
    }

    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    public ViewStubCompat(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public ViewStubCompat(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.mLayoutResource = 0;
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, styleable.ViewStubCompat, arg5, 0);
        this.mInflatedId = v3.getResourceId(styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = v3.getResourceId(styleable.ViewStubCompat_android_layout, 0);
        this.setId(v3.getResourceId(styleable.ViewStubCompat_android_id, -1));
        v3.recycle();
        this.setVisibility(8);
        this.setWillNotDraw(true);
    }

    protected void dispatchDraw(Canvas arg1) {
    }

    public void draw(Canvas arg1) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent v0 = this.getParent();
        if((v0 instanceof ViewGroup)) {
            if(this.mLayoutResource != 0) {
                LayoutInflater v1 = this.mInflater;
                if(v1 != null) {
                }
                else {
                    v1 = LayoutInflater.from(this.getContext());
                }

                View v1_1 = v1.inflate(this.mLayoutResource, ((ViewGroup)v0), false);
                int v2 = this.mInflatedId;
                if(v2 != -1) {
                    v1_1.setId(v2);
                }

                v2 = ((ViewGroup)v0).indexOfChild(((View)this));
                ((ViewGroup)v0).removeViewInLayout(((View)this));
                ViewGroup$LayoutParams v3 = this.getLayoutParams();
                if(v3 != null) {
                    ((ViewGroup)v0).addView(v1_1, v2, v3);
                }
                else {
                    ((ViewGroup)v0).addView(v1_1, v2);
                }

                this.mInflatedViewRef = new WeakReference(v1_1);
                OnInflateListener v0_1 = this.mInflateListener;
                if(v0_1 != null) {
                    v0_1.onInflate(this, v1_1);
                }

                return v1_1;
            }

            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }

        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    protected void onMeasure(int arg1, int arg2) {
        this.setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int arg1) {
        this.mInflatedId = arg1;
    }

    public void setLayoutInflater(LayoutInflater arg1) {
        this.mInflater = arg1;
    }

    public void setLayoutResource(int arg1) {
        this.mLayoutResource = arg1;
    }

    public void setOnInflateListener(OnInflateListener arg1) {
        this.mInflateListener = arg1;
    }

    public void setVisibility(int arg2) {
        WeakReference v0 = this.mInflatedViewRef;
        if(v0 != null) {
            Object v1 = v0.get();
            if(v1 != null) {
                ((View)v1).setVisibility(arg2);
                return;
            }

            throw new IllegalStateException("setVisibility called on un-referenced view");
        }

        super.setVisibility(arg2);
        if(arg2 != 0) {
            if(arg2 == 4) {
            }
            else {
                return;
            }
        }

        this.inflate();
    }
}

