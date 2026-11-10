package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path$Direction;
import android.graphics.Path;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;

        OutlineProvider(ShapeableImageView arg1) {
            ShapeableImageView.this = arg1;
            super();
            this.rect = new Rect();
        }

        public void getOutline(View arg3, Outline arg4) {
            if(ShapeableImageView.this.shapeAppearanceModel == null) {
                return;
            }

            if(ShapeableImageView.this.shadowDrawable == null) {
                ShapeableImageView.this.shadowDrawable = new MaterialShapeDrawable(ShapeableImageView.this.shapeAppearanceModel);
            }

            ShapeableImageView.this.destination.round(this.rect);
            ShapeableImageView.this.shadowDrawable.setBounds(this.rect);
            ShapeableImageView.this.shadowDrawable.getOutline(arg4);
        }
    }

    private static final int DEF_STYLE_RES = 0;
    private static final int UNDEFINED_PADDING = 0x80000000;
    private final Paint borderPaint;
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    private int rightContentPadding;
    private MaterialShapeDrawable shadowDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private int startContentPadding;
    private ColorStateList strokeColor;
    private float strokeWidth;
    private int topContentPadding;

    static {
        ShapeableImageView.DEF_STYLE_RES = style.Widget_MaterialComponents_ShapeableImageView;
    }

    public ShapeableImageView(Context arg3) {
        this(arg3, null, 0);
    }

    public ShapeableImageView(Context arg7, AttributeSet arg8, int arg9) {
        int v0 = ShapeableImageView.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v0), arg8, arg9);
        this.pathProvider = ShapeAppearancePathProvider.getInstance();
        this.path = new Path();
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = false;
        Context v1 = this.getContext();
        Paint v2 = new Paint();
        this.clearPaint = v2;
        v2.setAntiAlias(true);
        v2.setColor(-1);
        v2.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray v2_1 = v1.obtainStyledAttributes(arg8, styleable.ShapeableImageView, arg9, v0);
        this.setLayerType(2, null);
        this.strokeColor = MaterialResources.getColorStateList(v1, v2_1, styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = ((float)v2_1.getDimensionPixelSize(styleable.ShapeableImageView_strokeWidth, 0));
        int v7 = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPadding, 0);
        this.leftContentPadding = v7;
        this.topContentPadding = v7;
        this.rightContentPadding = v7;
        this.bottomContentPadding = v7;
        this.leftContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingLeft, v7);
        this.topContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingTop, v7);
        this.rightContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingRight, v7);
        this.bottomContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingBottom, v7);
        this.startContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingStart, 0x80000000);
        this.endContentPadding = v2_1.getDimensionPixelSize(styleable.ShapeableImageView_contentPaddingEnd, 0x80000000);
        v2_1.recycle();
        Paint v7_1 = new Paint();
        this.borderPaint = v7_1;
        v7_1.setStyle(Paint$Style.STROKE);
        v7_1.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(v1, arg8, arg9, v0).build();
        this.setOutlineProvider(new OutlineProvider(this));
    }

    public ShapeableImageView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    static ShapeAppearanceModel access$000(ShapeableImageView arg0) {
        return arg0.shapeAppearanceModel;
    }

    static MaterialShapeDrawable access$100(ShapeableImageView arg0) {
        return arg0.shadowDrawable;
    }

    static MaterialShapeDrawable access$102(ShapeableImageView arg0, MaterialShapeDrawable arg1) {
        arg0.shadowDrawable = arg1;
        return arg1;
    }

    static RectF access$200(ShapeableImageView arg0) {
        return arg0.destination;
    }

    private void drawStroke(Canvas arg4) {
        if(this.strokeColor == null) {
        }
        else {
            this.borderPaint.setStrokeWidth(this.strokeWidth);
            int v0 = this.strokeColor.getColorForState(this.getDrawableState(), this.strokeColor.getDefaultColor());
            if(this.strokeWidth > 0f && v0 != 0) {
                this.borderPaint.setColor(v0);
                arg4.drawPath(this.path, this.borderPaint);
            }
        }
    }

    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    public final int getContentPaddingEnd() {
        int v0 = this.endContentPadding;
        if(v0 != 0x80000000) {
            return v0;
        }

        if(this.isRtl()) {
            return this.leftContentPadding;
        }

        return this.rightContentPadding;
    }

    public int getContentPaddingLeft() {
        int v0;
        if(this.isContentPaddingRelative()) {
            int v1 = 0x80000000;
            if(this.isRtl()) {
                v0 = this.endContentPadding;
                if(v0 != v1) {
                    return v0;
                }
            }

            if(this.isRtl()) {
                goto label_13;
            }

            v0 = this.startContentPadding;
            if(v0 == v1) {
                goto label_13;
            }

            return v0;
        }

    label_13:
        return this.leftContentPadding;
    }

    public int getContentPaddingRight() {
        int v0;
        if(this.isContentPaddingRelative()) {
            int v1 = 0x80000000;
            if(this.isRtl()) {
                v0 = this.startContentPadding;
                if(v0 != v1) {
                    return v0;
                }
            }

            if(this.isRtl()) {
                goto label_13;
            }

            v0 = this.endContentPadding;
            if(v0 == v1) {
                goto label_13;
            }

            return v0;
        }

    label_13:
        return this.rightContentPadding;
    }

    public final int getContentPaddingStart() {
        int v0 = this.startContentPadding;
        if(v0 != 0x80000000) {
            return v0;
        }

        if(this.isRtl()) {
            return this.rightContentPadding;
        }

        return this.leftContentPadding;
    }

    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    public int getPaddingBottom() {
        return super.getPaddingBottom() - this.getContentPaddingBottom();
    }

    public int getPaddingEnd() {
        return super.getPaddingEnd() - this.getContentPaddingEnd();
    }

    public int getPaddingLeft() {
        return super.getPaddingLeft() - this.getContentPaddingLeft();
    }

    public int getPaddingRight() {
        return super.getPaddingRight() - this.getContentPaddingRight();
    }

    public int getPaddingStart() {
        return super.getPaddingStart() - this.getContentPaddingStart();
    }

    public int getPaddingTop() {
        return super.getPaddingTop() - this.getContentPaddingTop();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    private boolean isContentPaddingRelative() {
        int v1 = 0x80000000;
        if(this.startContentPadding == v1) {
            if(this.endContentPadding != v1) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isRtl() {
        if(this.getLayoutDirection() == 1) {
            return 1;
        }

        return 0;
    }

    protected void onDraw(Canvas arg3) {
        super.onDraw(arg3);
        arg3.drawPath(this.maskPath, this.clearPaint);
        this.drawStroke(arg3);
    }

    protected void onMeasure(int arg3, int arg4) {
        super.onMeasure(arg3, arg4);
        if(this.hasAdjustedPaddingAfterLayoutDirectionResolved) {
        }
        else {
            if(!this.isLayoutDirectionResolved()) {
                return;
            }

            goto label_7;
        }

        return;
    label_7:
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if(!this.isPaddingRelative()) {
            if(this.isContentPaddingRelative()) {
            }
            else {
                this.setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
                return;
            }
        }

        this.setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.updateShapeMask(arg1, arg2);
    }

    public void setContentPadding(int arg6, int arg7, int arg8, int arg9) {
        this.startContentPadding = 0x80000000;
        this.endContentPadding = 0x80000000;
        super.setPadding(super.getPaddingLeft() - this.leftContentPadding + arg6, super.getPaddingTop() - this.topContentPadding + arg7, super.getPaddingRight() - this.rightContentPadding + arg8, super.getPaddingBottom() - this.bottomContentPadding + arg9);
        this.leftContentPadding = arg6;
        this.topContentPadding = arg7;
        this.rightContentPadding = arg8;
        this.bottomContentPadding = arg9;
    }

    public void setContentPaddingRelative(int arg6, int arg7, int arg8, int arg9) {
        super.setPaddingRelative(super.getPaddingStart() - this.getContentPaddingStart() + arg6, super.getPaddingTop() - this.topContentPadding + arg7, super.getPaddingEnd() - this.getContentPaddingEnd() + arg8, super.getPaddingBottom() - this.bottomContentPadding + arg9);
        int v0 = this.isRtl() ? arg8 : arg6;
        this.leftContentPadding = v0;
        this.topContentPadding = arg7;
        if(this.isRtl()) {
        }
        else {
            arg6 = arg8;
        }

        this.rightContentPadding = arg6;
        this.bottomContentPadding = arg9;
    }

    public void setPadding(int arg2, int arg3, int arg4, int arg5) {
        super.setPadding(arg2 + this.getContentPaddingLeft(), arg3 + this.getContentPaddingTop(), arg4 + this.getContentPaddingRight(), arg5 + this.getContentPaddingBottom());
    }

    public void setPaddingRelative(int arg2, int arg3, int arg4, int arg5) {
        super.setPaddingRelative(arg2 + this.getContentPaddingStart(), arg3 + this.getContentPaddingTop(), arg4 + this.getContentPaddingEnd(), arg5 + this.getContentPaddingBottom());
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        this.shapeAppearanceModel = arg2;
        MaterialShapeDrawable v0 = this.shadowDrawable;
        if(v0 != null) {
            v0.setShapeAppearanceModel(arg2);
        }

        this.updateShapeMask(this.getWidth(), this.getHeight());
        this.invalidate();
        this.invalidateOutline();
    }

    public void setStrokeColor(ColorStateList arg1) {
        this.strokeColor = arg1;
        this.invalidate();
    }

    public void setStrokeColorResource(int arg2) {
        this.setStrokeColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
    }

    public void setStrokeWidth(float arg2) {
        if(this.strokeWidth != arg2) {
            this.strokeWidth = arg2;
            this.invalidate();
        }
    }

    public void setStrokeWidthResource(int arg2) {
        this.setStrokeWidth(((float)this.getResources().getDimensionPixelSize(arg2)));
    }

    private void updateShapeMask(int arg6, int arg7) {
        this.destination.set(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()), ((float)(arg6 - this.getPaddingRight())), ((float)(arg7 - this.getPaddingBottom())));
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0f, 0f, ((float)arg6), ((float)arg7));
        this.maskPath.addRect(this.maskRect, Path$Direction.CCW);
    }
}

