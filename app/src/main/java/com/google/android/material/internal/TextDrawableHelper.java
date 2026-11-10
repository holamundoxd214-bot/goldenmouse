package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

public class TextDrawableHelper {
    class com.google.android.material.internal.TextDrawableHelper$1 extends TextAppearanceFontCallback {
        com.google.android.material.internal.TextDrawableHelper$1(TextDrawableHelper arg1) {
            TextDrawableHelper.this = arg1;
            super();
        }

        public void onFontRetrievalFailed(int arg2) {
            TextDrawableHelper.this.textSizeDirty = true;
            Object v1 = TextDrawableHelper.this.delegate.get();
            if(v1 != null) {
                ((TextDrawableDelegate)v1).onTextSizeChange();
            }
        }

        public void onFontRetrieved(Typeface arg1, boolean arg2) {
            if(arg2) {
            }
            else {
                TextDrawableHelper.this.textSizeDirty = true;
                Object v0 = TextDrawableHelper.this.delegate.get();
                if(v0 != null) {
                    ((TextDrawableDelegate)v0).onTextSizeChange();
                }
            }
        }
    }

    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] arg1);

        void onTextSizeChange();
    }

    private WeakReference delegate;
    private final TextAppearanceFontCallback fontCallback;
    private TextAppearance textAppearance;
    private float textHeight;
    private final TextPaint textPaint;
    private boolean textSizeDirty;
    private float textWidth;

    public TextDrawableHelper(TextDrawableDelegate arg3) {
        super();
        this.textPaint = new TextPaint(1);
        this.fontCallback = new com.google.android.material.internal.TextDrawableHelper$1(this);
        this.textSizeDirty = true;
        this.delegate = new WeakReference(null);
        this.setDelegate(arg3);
    }

    static boolean access$002(TextDrawableHelper arg0, boolean arg1) {
        arg0.textSizeDirty = arg1;
        return arg1;
    }

    static WeakReference access$100(TextDrawableHelper arg0) {
        return arg0.delegate;
    }

    private float calculateTextHeight(String arg1) {
        if(arg1 == null) {
            return 0;
        }

        return Math.abs(this.textPaint.getFontMetrics().ascent);
    }

    private float calculateTextWidth(CharSequence arg3) {
        if(arg3 == null) {
            return 0;
        }

        return this.textPaint.measureText(arg3, 0, arg3.length());
    }

    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    public float getTextHeight(String arg2) {
        if(!this.textSizeDirty) {
            return this.textHeight;
        }

        this.refreshTextDimens(arg2);
        return this.textHeight;
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public float getTextWidth(String arg2) {
        if(!this.textSizeDirty) {
            return this.textWidth;
        }

        this.refreshTextDimens(arg2);
        return this.textWidth;
    }

    public boolean isTextWidthDirty() {
        return this.textSizeDirty;
    }

    private void refreshTextDimens(String arg2) {
        this.textWidth = this.calculateTextWidth(((CharSequence)arg2));
        this.textHeight = this.calculateTextHeight(arg2);
        this.textSizeDirty = false;
    }

    public void setDelegate(TextDrawableDelegate arg2) {
        this.delegate = new WeakReference(arg2);
    }

    public void setTextAppearance(TextAppearance arg3, Context arg4) {
        if(this.textAppearance != arg3) {
            this.textAppearance = arg3;
            if(arg3 != null) {
                arg3.updateMeasureState(arg4, this.textPaint, this.fontCallback);
                Object v0 = this.delegate.get();
                if(v0 != null) {
                    this.textPaint.drawableState = ((TextDrawableDelegate)v0).getState();
                }

                arg3.updateDrawState(arg4, this.textPaint, this.fontCallback);
                this.textSizeDirty = true;
            }

            Object v2 = this.delegate.get();
            if(v2 == null) {
                return;
            }

            ((TextDrawableDelegate)v2).onTextSizeChange();
            ((TextDrawableDelegate)v2).onStateChange(((TextDrawableDelegate)v2).getState());
        }
    }

    public void setTextSizeDirty(boolean arg1) {
        this.textSizeDirty = arg1;
    }

    public void setTextWidthDirty(boolean arg1) {
        this.textSizeDirty = arg1;
    }

    public void updateTextPaintDrawState(Context arg3) {
        this.textAppearance.updateDrawState(arg3, this.textPaint, this.fontCallback);
    }
}

