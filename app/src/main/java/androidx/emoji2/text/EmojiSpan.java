package androidx.emoji2.text;

import android.graphics.Paint$FontMetricsInt;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

public abstract class EmojiSpan extends ReplacementSpan {
    private short mHeight;
    private final TypefaceEmojiRasterizer mRasterizer;
    private float mRatio;
    private final Paint$FontMetricsInt mTmpFontMetrics;
    private short mWidth;

    EmojiSpan(TypefaceEmojiRasterizer arg2) {
        super();
        this.mTmpFontMetrics = new Paint$FontMetricsInt();
        this.mWidth = -1;
        this.mHeight = -1;
        this.mRatio = 1f;
        Preconditions.checkNotNull(arg2, "rasterizer cannot be null");
        this.mRasterizer = arg2;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int getId() {
        return this.getTypefaceRasterizer().getId();
    }

    final float getRatio() {
        return this.mRatio;
    }

    public int getSize(Paint arg1, CharSequence arg2, int arg3, int arg4, Paint$FontMetricsInt arg5) {
        arg1.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = (((float)Math.abs(this.mTmpFontMetrics.descent - this.mTmpFontMetrics.ascent))) * 1f / (((float)this.mRasterizer.getHeight()));
        this.mHeight = ((short)(((int)((((float)this.mRasterizer.getHeight())) * this.mRatio))));
        this.mWidth = ((short)(((int)((((float)this.mRasterizer.getWidth())) * this.mRatio))));
        if(arg5 != null) {
            arg5.ascent = this.mTmpFontMetrics.ascent;
            arg5.descent = this.mTmpFontMetrics.descent;
            arg5.top = this.mTmpFontMetrics.top;
            arg5.bottom = this.mTmpFontMetrics.bottom;
        }

        return this.mWidth;
    }

    public final TypefaceEmojiRasterizer getTypefaceRasterizer() {
        return this.mRasterizer;
    }

    final int getWidth() {
        return this.mWidth;
    }
}

