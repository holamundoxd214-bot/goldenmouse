package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region$Op;
import android.graphics.Region;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    @Retention(value=RetentionPolicy.SOURCE) @public interface CompatibilityShadowMode {
    }

    public class MaterialShapeDrawableState extends Drawable$ConstantState {
        int alpha;
        ColorFilter colorFilter;
        float elevation;
        ElevationOverlayProvider elevationOverlayProvider;
        ColorStateList fillColor;
        float interpolation;
        Rect padding;
        Paint$Style paintStyle;
        float parentAbsoluteElevation;
        float scale;
        int shadowCompatMode;
        int shadowCompatOffset;
        int shadowCompatRadius;
        int shadowCompatRotation;
        ShapeAppearanceModel shapeAppearanceModel;
        ColorStateList strokeColor;
        ColorStateList strokeTintList;
        float strokeWidth;
        ColorStateList tintList;
        PorterDuff$Mode tintMode;
        float translationZ;
        boolean useTintColorForShadow;

        public MaterialShapeDrawableState(ShapeAppearanceModel arg3, ElevationOverlayProvider arg4) {
            super();
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff$Mode.SRC_IN;
            this.padding = null;
            this.scale = 1f;
            this.interpolation = 1f;
            this.alpha = 0xFF;
            this.parentAbsoluteElevation = 0f;
            this.elevation = 0f;
            this.translationZ = 0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint$Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = arg3;
            this.elevationOverlayProvider = arg4;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState arg3) {
            super();
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff$Mode.SRC_IN;
            this.padding = null;
            this.scale = 1f;
            this.interpolation = 1f;
            this.alpha = 0xFF;
            this.parentAbsoluteElevation = 0f;
            this.elevation = 0f;
            this.translationZ = 0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint$Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = arg3.shapeAppearanceModel;
            this.elevationOverlayProvider = arg3.elevationOverlayProvider;
            this.strokeWidth = arg3.strokeWidth;
            this.colorFilter = arg3.colorFilter;
            this.fillColor = arg3.fillColor;
            this.strokeColor = arg3.strokeColor;
            this.tintMode = arg3.tintMode;
            this.tintList = arg3.tintList;
            this.alpha = arg3.alpha;
            this.scale = arg3.scale;
            this.shadowCompatOffset = arg3.shadowCompatOffset;
            this.shadowCompatMode = arg3.shadowCompatMode;
            this.useTintColorForShadow = arg3.useTintColorForShadow;
            this.interpolation = arg3.interpolation;
            this.parentAbsoluteElevation = arg3.parentAbsoluteElevation;
            this.elevation = arg3.elevation;
            this.translationZ = arg3.translationZ;
            this.shadowCompatRadius = arg3.shadowCompatRadius;
            this.shadowCompatRotation = arg3.shadowCompatRotation;
            this.strokeTintList = arg3.strokeTintList;
            this.paintStyle = arg3.paintStyle;
            if(arg3.padding != null) {
                this.padding = new Rect(arg3.padding);
            }
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            MaterialShapeDrawable v0 = new MaterialShapeDrawable(this);
            v0.pathDirty = true;
            return ((Drawable)v0);
        }
    }

    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint;
    private final BitSet containsIncompatibleShadowOp;
    private final ShadowCompatOperation[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    private final ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;
    private final PathListener pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    static {
        Paint v0 = new Paint(1);
        MaterialShapeDrawable.clearPaint = v0;
        v0.setColor(-1);
        v0.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
    }

    public MaterialShapeDrawable(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        this(ShapeAppearanceModel.builder(arg1, arg2, arg3, arg4).build());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(ShapeAppearanceModel arg3) {
        this(new MaterialShapeDrawableState(arg3, null));
    }

    protected MaterialShapeDrawable(MaterialShapeDrawableState arg6) {
        super();
        this.cornerShadowOperation = new ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint v0 = new Paint(1);
        this.fillPaint = v0;
        Paint v2 = new Paint(1);
        this.strokePaint = v2;
        this.shadowRenderer = new ShadowRenderer();
        ShapeAppearancePathProvider v3 = Looper.getMainLooper().getThread() == Thread.currentThread() ? ShapeAppearancePathProvider.getInstance() : new ShapeAppearancePathProvider();
        this.pathProvider = v3;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = arg6;
        v2.setStyle(Paint$Style.STROKE);
        v0.setStyle(Paint$Style.FILL);
        this.updateTintFilter();
        this.updateColorsForState(this.getState());
        this.pathShadowListener = new PathListener() {
            public void onCornerPathCreated(ShapePath arg3, Matrix arg4, int arg5) {
                MaterialShapeDrawable.access$000(MaterialShapeDrawable.this).set(arg5, arg3.containsIncompatibleShadowOp());
                MaterialShapeDrawable.access$100(MaterialShapeDrawable.this)[arg5] = arg3.createShadowCompatOperation(arg4);
            }

            public void onEdgePathCreated(ShapePath arg4, Matrix arg5, int arg6) {
                MaterialShapeDrawable.access$000(MaterialShapeDrawable.this).set(arg6 + 4, arg4.containsIncompatibleShadowOp());
                MaterialShapeDrawable.access$200(MaterialShapeDrawable.this)[arg6] = arg4.createShadowCompatOperation(arg5);
            }
        };
    }

    @Deprecated public MaterialShapeDrawable(ShapePathModel arg1) {
        this(((ShapeAppearanceModel)arg1));
    }

    static BitSet access$000(MaterialShapeDrawable arg0) {
        return arg0.containsIncompatibleShadowOp;
    }

    static ShadowCompatOperation[] access$100(MaterialShapeDrawable arg0) {
        return arg0.cornerShadowOperation;
    }

    static ShadowCompatOperation[] access$200(MaterialShapeDrawable arg0) {
        return arg0.edgeShadowOperation;
    }

    static boolean access$302(MaterialShapeDrawable arg0, boolean arg1) {
        arg0.pathDirty = arg1;
        return arg1;
    }

    private PorterDuffColorFilter calculatePaintColorTintFilter(Paint arg1, boolean arg2) {
        if(arg2) {
            int v1 = arg1.getColor();
            int v2 = this.compositeElevationOverlayIfNeeded(v1);
            this.resolvedTintColor = v2;
            if(v2 != v1) {
                return new PorterDuffColorFilter(v2, PorterDuff$Mode.SRC_IN);
            }
        }

        return null;
    }

    private void calculatePath(RectF arg6, Path arg7) {
        this.calculatePathForSize(arg6, arg7);
        if(this.drawableState.scale != 1f) {
            this.matrix.reset();
            this.matrix.setScale(this.drawableState.scale, this.drawableState.scale, arg6.width() / 2f, arg6.height() / 2f);
            arg7.transform(this.matrix);
        }

        arg7.computeBounds(this.pathBounds, true);
    }

    protected final void calculatePathForSize(RectF arg7, Path arg8) {
        this.pathProvider.calculatePath(this.drawableState.shapeAppearanceModel, this.drawableState.interpolation, arg7, this.pathShadowListener, arg8);
    }

    private void calculateStrokePath() {
        ShapeAppearanceModel v0 = this.getShapeAppearanceModel().withTransformedCornerSizes(new CornerSizeUnaryOperator(-this.getStrokeInsetLength()) {
            public CornerSize apply(CornerSize arg2) {
                if((arg2 instanceof RelativeCornerSize)) {
                    return arg2;
                }

                return new AdjustedCornerSize(this.val$strokeInsetLength, arg2);
            }
        });
        this.strokeShapeAppearance = v0;
        this.pathProvider.calculatePath(v0, this.drawableState.interpolation, this.getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList arg3, PorterDuff$Mode arg4, boolean arg5) {
        int v3 = arg3.getColorForState(this.getState(), 0);
        if(arg5) {
            v3 = this.compositeElevationOverlayIfNeeded(v3);
        }

        this.resolvedTintColor = v3;
        return new PorterDuffColorFilter(v3, arg4);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList arg1, PorterDuff$Mode arg2, Paint arg3, boolean arg4) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else {
                return this.calculateTintColorTintFilter(arg1, arg2, arg4);
            }
        }

        return this.calculatePaintColorTintFilter(arg3, arg4);
    }

    protected int compositeElevationOverlayIfNeeded(int arg3) {
        float v0 = this.getZ() + this.getParentAbsoluteElevation();
        if(this.drawableState.elevationOverlayProvider != null) {
            return this.drawableState.elevationOverlayProvider.compositeOverlayIfNeeded(arg3, v0);
        }

        return arg3;
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context arg1) {
        return MaterialShapeDrawable.createWithElevationOverlay(arg1, 0f);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context arg1, float arg2) {
        return MaterialShapeDrawable.createWithElevationOverlay(arg1, arg2, null);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context arg1, float arg2, ColorStateList arg3) {
        if(arg3 == null) {
            arg3 = ColorStateList.valueOf(MaterialColors.getColor(arg1, attr.colorSurface, "MaterialShapeDrawable"));
        }

        MaterialShapeDrawable v0 = new MaterialShapeDrawable();
        v0.initializeElevationOverlay(arg1);
        v0.setFillColor(arg3);
        v0.setElevation(arg2);
        return v0;
    }

    public void draw(Canvas arg5) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int v0 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(MaterialShapeDrawable.modulateAlpha(v0, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int v1 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(MaterialShapeDrawable.modulateAlpha(v1, this.drawableState.alpha));
        if(this.pathDirty) {
            this.calculateStrokePath();
            this.calculatePath(this.getBoundsAsRectF(), this.path);
            this.pathDirty = false;
        }

        this.maybeDrawCompatShadow(arg5);
        if(this.hasFill()) {
            this.drawFillShape(arg5);
        }

        if(this.hasStroke()) {
            this.drawStrokeShape(arg5);
        }

        this.fillPaint.setAlpha(v0);
        this.strokePaint.setAlpha(v1);
    }

    private void drawCompatShadow(Canvas arg5) {
        if(this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(MaterialShapeDrawable.TAG, "Compatibility shadow requested but can\'t be drawn for all operations in this shape.");
        }

        if(this.drawableState.shadowCompatOffset != 0) {
            arg5.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }

        int v0;
        for(v0 = 0; v0 < 4; ++v0) {
            this.cornerShadowOperation[v0].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, arg5);
            this.edgeShadowOperation[v0].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, arg5);
        }

        if(this.shadowBitmapDrawingEnable) {
            v0 = this.getShadowOffsetX();
            int v1 = this.getShadowOffsetY();
            arg5.translate(((float)(-v0)), ((float)(-v1)));
            arg5.drawPath(this.path, MaterialShapeDrawable.clearPaint);
            arg5.translate(((float)v0), ((float)v1));
        }
    }

    private void drawFillShape(Canvas arg7) {
        this.drawShape(arg7, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, this.getBoundsAsRectF());
    }

    private void drawShape(Canvas arg2, Paint arg3, Path arg4, ShapeAppearanceModel arg5, RectF arg6) {
        if(arg5.isRoundRect(arg6)) {
            float v4 = arg5.getTopRightCornerSize().getCornerSize(arg6) * this.drawableState.interpolation;
            arg2.drawRoundRect(arg6, v4, v4, arg3);
            return;
        }

        arg2.drawPath(arg4, arg3);
    }

    protected void drawShape(Canvas arg8, Paint arg9, Path arg10, RectF arg11) {
        this.drawShape(arg8, arg9, arg10, this.drawableState.shapeAppearanceModel, arg11);
    }

    protected void drawStrokeShape(Canvas arg7) {
        this.drawShape(arg7, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, this.getBoundsInsetByStroke());
    }

    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(this.getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(this.getBoundsAsRectF());
    }

    protected RectF getBoundsAsRectF() {
        this.rectF.set(this.getBounds());
        return this.rectF;
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(this.getBoundsAsRectF());
        float v0 = this.getStrokeInsetLength();
        this.insetRectF.inset(v0, v0);
        return this.insetRectF;
    }

    public Drawable$ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline arg3) {
        if(this.drawableState.shadowCompatMode == 2) {
            return;
        }

        if(this.isRoundRect()) {
            arg3.setRoundRect(this.getBounds(), this.getTopLeftCornerResolvedSize() * this.drawableState.interpolation);
            return;
        }

        this.calculatePath(this.getBoundsAsRectF(), this.path);
        DrawableUtils.setOutlineToPath(arg3, this.path);
    }

    public boolean getPadding(Rect arg2) {
        if(this.drawableState.padding != null) {
            arg2.set(this.drawableState.padding);
            return 1;
        }

        return super.getPadding(arg2);
    }

    public Paint$Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated public void getPathForSize(int arg3, int arg4, Path arg5) {
        this.calculatePathForSize(new RectF(0f, 0f, ((float)arg3), ((float)arg4)), arg5);
    }

    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated public int getShadowElevation() {
        return ((int)this.getElevation());
    }

    public int getShadowOffsetX() {
        return ((int)((((double)this.drawableState.shadowCompatOffset)) * Math.sin(Math.toRadians(((double)this.drawableState.shadowCompatRotation)))));
    }

    public int getShadowOffsetY() {
        return ((int)((((double)this.drawableState.shadowCompatOffset)) * Math.cos(Math.toRadians(((double)this.drawableState.shadowCompatRotation)))));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Deprecated public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel v1 = this.getShapeAppearanceModel();
        if((v1 instanceof ShapePathModel)) {
            return ((ShapePathModel)v1);
        }

        return null;
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    private float getStrokeInsetLength() {
        if(this.hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2f;
        }

        return 0;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(this.getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(this.getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    public Region getTransparentRegion() {
        this.transparentRegion.set(this.getBounds());
        this.calculatePath(this.getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region$Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return this.getElevation() + this.getTranslationZ();
    }

    private boolean hasCompatShadow() {
        if(this.drawableState.shadowCompatMode != 1 && this.drawableState.shadowCompatRadius > 0 && (this.drawableState.shadowCompatMode == 2 || (this.requiresCompatShadow()))) {
            return 1;
        }

        return 0;
    }

    private boolean hasFill() {
        if(this.drawableState.paintStyle != Paint$Style.FILL_AND_STROKE) {
            if(this.drawableState.paintStyle == Paint$Style.FILL) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean hasStroke() {
        if((this.drawableState.paintStyle == Paint$Style.FILL_AND_STROKE || this.drawableState.paintStyle == Paint$Style.STROKE) && this.strokePaint.getStrokeWidth() > 0f) {
            return 1;
        }

        return 0;
    }

    public void initializeElevationOverlay(Context arg3) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(arg3);
        this.updateZ();
    }

    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        if(this.drawableState.elevationOverlayProvider != null && (this.drawableState.elevationOverlayProvider.isThemeElevationOverlayEnabled())) {
            return 1;
        }

        return 0;
    }

    public boolean isElevationOverlayInitialized() {
        if(this.drawableState.elevationOverlayProvider != null) {
            return 1;
        }

        return 0;
    }

    public boolean isPointInTransparentRegion(int arg1, int arg2) {
        return this.getTransparentRegion().contains(arg1, arg2);
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(this.getBoundsAsRectF());
    }

    @Deprecated public boolean isShadowEnabled() {
        if(this.drawableState.shadowCompatMode != 0) {
            if(this.drawableState.shadowCompatMode == 2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean isStateful() {
        if(!super.isStateful() && (this.drawableState.tintList == null || !this.drawableState.tintList.isStateful()) && (this.drawableState.strokeTintList == null || !this.drawableState.strokeTintList.isStateful()) && (this.drawableState.strokeColor == null || !this.drawableState.strokeColor.isStateful()) && (this.drawableState.fillColor == null || !this.drawableState.fillColor.isStateful())) {
            return 0;
        }

        return 1;
    }

    private void maybeDrawCompatShadow(Canvas arg7) {
        if(!this.hasCompatShadow()) {
            return;
        }

        arg7.save();
        this.prepareCanvasForShadow(arg7);
        if(!this.shadowBitmapDrawingEnable) {
            this.drawCompatShadow(arg7);
            arg7.restore();
            return;
        }

        int v0 = ((int)(this.pathBounds.width() - (((float)this.getBounds().width()))));
        int v1 = ((int)(this.pathBounds.height() - (((float)this.getBounds().height()))));
        if(v0 >= 0 && v1 >= 0) {
            Bitmap v2 = Bitmap.createBitmap((((int)this.pathBounds.width())) + this.drawableState.shadowCompatRadius * 2 + v0, (((int)this.pathBounds.height())) + this.drawableState.shadowCompatRadius * 2 + v1, Bitmap$Config.ARGB_8888);
            Canvas v3 = new Canvas(v2);
            float v0_1 = ((float)(this.getBounds().left - this.drawableState.shadowCompatRadius - v0));
            float v1_1 = ((float)(this.getBounds().top - this.drawableState.shadowCompatRadius - v1));
            v3.translate(-v0_1, -v1_1);
            this.drawCompatShadow(v3);
            arg7.drawBitmap(v2, v0_1, v1_1, null);
            v2.recycle();
            arg7.restore();
            return;
        }

        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int arg1, int arg2) {
        return arg1 * (arg2 + (arg2 >>> 7)) >>> 8;
    }

    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    protected void onBoundsChange(Rect arg2) {
        this.pathDirty = true;
        super.onBoundsChange(arg2);
    }

    protected boolean onStateChange(int[] arg2) {
        boolean v2 = this.updateColorsForState(arg2);
        boolean v0 = this.updateTintFilter();
        v2 = (v2) || (v0) ? true : false;
        if(v2) {
            this.invalidateSelf();
        }

        return v2;
    }

    private void prepareCanvasForShadow(Canvas arg2) {
        arg2.translate(((float)this.getShadowOffsetX()), ((float)this.getShadowOffsetY()));
    }

    public boolean requiresCompatShadow() {
        if(!this.isRoundRect() && !this.path.isConvex() && Build$VERSION.SDK_INT < 29) {
            return 1;
        }

        return 0;
    }

    public void setAlpha(int arg2) {
        if(this.drawableState.alpha != arg2) {
            this.drawableState.alpha = arg2;
            this.invalidateSelfIgnoreShape();
        }
    }

    public void setColorFilter(ColorFilter arg2) {
        this.drawableState.colorFilter = arg2;
        this.invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float arg2) {
        this.setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(arg2));
    }

    public void setCornerSize(CornerSize arg2) {
        this.setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(arg2));
    }

    public void setEdgeIntersectionCheckEnable(boolean arg1) {
        this.pathProvider.setEdgeIntersectionCheckEnable(arg1);
    }

    public void setElevation(float arg2) {
        if(this.drawableState.elevation != arg2) {
            this.drawableState.elevation = arg2;
            this.updateZ();
        }
    }

    public void setFillColor(ColorStateList arg2) {
        if(this.drawableState.fillColor != arg2) {
            this.drawableState.fillColor = arg2;
            this.onStateChange(this.getState());
        }
    }

    public void setInterpolation(float arg2) {
        if(this.drawableState.interpolation != arg2) {
            this.drawableState.interpolation = arg2;
            this.pathDirty = true;
            this.invalidateSelf();
        }
    }

    public void setPadding(int arg3, int arg4, int arg5, int arg6) {
        if(this.drawableState.padding == null) {
            this.drawableState.padding = new Rect();
        }

        this.drawableState.padding.set(arg3, arg4, arg5, arg6);
        this.invalidateSelf();
    }

    public void setPaintStyle(Paint$Style arg2) {
        this.drawableState.paintStyle = arg2;
        this.invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float arg2) {
        if(this.drawableState.parentAbsoluteElevation != arg2) {
            this.drawableState.parentAbsoluteElevation = arg2;
            this.updateZ();
        }
    }

    public void setScale(float arg2) {
        if(this.drawableState.scale != arg2) {
            this.drawableState.scale = arg2;
            this.invalidateSelf();
        }
    }

    public void setShadowBitmapDrawingEnable(boolean arg1) {
        this.shadowBitmapDrawingEnable = arg1;
    }

    public void setShadowColor(int arg2) {
        this.shadowRenderer.setShadowColor(arg2);
        this.drawableState.useTintColorForShadow = false;
        this.invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int arg2) {
        if(this.drawableState.shadowCompatRotation != arg2) {
            this.drawableState.shadowCompatRotation = arg2;
            this.invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int arg2) {
        if(this.drawableState.shadowCompatMode != arg2) {
            this.drawableState.shadowCompatMode = arg2;
            this.invalidateSelfIgnoreShape();
        }
    }

    @Deprecated public void setShadowElevation(int arg1) {
        this.setElevation(((float)arg1));
    }

    @Deprecated public void setShadowEnabled(boolean arg1) {
        this.setShadowCompatibilityMode((((int)arg1)) ^ 1);
    }

    @Deprecated public void setShadowRadius(int arg1) {
        this.drawableState.shadowCompatRadius = arg1;
    }

    public void setShadowVerticalOffset(int arg2) {
        if(this.drawableState.shadowCompatOffset != arg2) {
            this.drawableState.shadowCompatOffset = arg2;
            this.invalidateSelfIgnoreShape();
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        this.drawableState.shapeAppearanceModel = arg2;
        this.invalidateSelf();
    }

    @Deprecated public void setShapedViewModel(ShapePathModel arg1) {
        this.setShapeAppearanceModel(((ShapeAppearanceModel)arg1));
    }

    public void setStroke(float arg1, ColorStateList arg2) {
        this.setStrokeWidth(arg1);
        this.setStrokeColor(arg2);
    }

    public void setStroke(float arg1, int arg2) {
        this.setStrokeWidth(arg1);
        this.setStrokeColor(ColorStateList.valueOf(arg2));
    }

    public void setStrokeColor(ColorStateList arg2) {
        if(this.drawableState.strokeColor != arg2) {
            this.drawableState.strokeColor = arg2;
            this.onStateChange(this.getState());
        }
    }

    public void setStrokeTint(int arg1) {
        this.setStrokeTint(ColorStateList.valueOf(arg1));
    }

    public void setStrokeTint(ColorStateList arg2) {
        this.drawableState.strokeTintList = arg2;
        this.updateTintFilter();
        this.invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float arg2) {
        this.drawableState.strokeWidth = arg2;
        this.invalidateSelf();
    }

    public void setTint(int arg1) {
        this.setTintList(ColorStateList.valueOf(arg1));
    }

    public void setTintList(ColorStateList arg2) {
        this.drawableState.tintList = arg2;
        this.updateTintFilter();
        this.invalidateSelfIgnoreShape();
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.drawableState.tintMode != arg2) {
            this.drawableState.tintMode = arg2;
            this.updateTintFilter();
            this.invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float arg2) {
        if(this.drawableState.translationZ != arg2) {
            this.drawableState.translationZ = arg2;
            this.updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean arg2) {
        if(this.drawableState.useTintColorForShadow != arg2) {
            this.drawableState.useTintColorForShadow = arg2;
            this.invalidateSelf();
        }
    }

    public void setZ(float arg2) {
        this.setTranslationZ(arg2 - this.getElevation());
    }

    private boolean updateColorsForState(int[] arg5) {
        boolean v0_1;
        int v2;
        if(this.drawableState.fillColor != null) {
            int v0 = this.fillPaint.getColor();
            v2 = this.drawableState.fillColor.getColorForState(arg5, v0);
            if(v0 != v2) {
                this.fillPaint.setColor(v2);
                v0_1 = true;
            }
            else {
                goto label_14;
            }
        }
        else {
        label_14:
            v0_1 = false;
        }

        if(this.drawableState.strokeColor != null) {
            v2 = this.strokePaint.getColor();
            int v5 = this.drawableState.strokeColor.getColorForState(arg5, v2);
            if(v2 != v5) {
                this.strokePaint.setColor(v5);
                return 1;
            }
        }

        return v0_1;
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter v0 = this.tintFilter;
        PorterDuffColorFilter v1 = this.strokeTintFilter;
        this.tintFilter = this.calculateTintFilter(this.drawableState.tintList, this.drawableState.tintMode, this.fillPaint, true);
        this.strokeTintFilter = this.calculateTintFilter(this.drawableState.strokeTintList, this.drawableState.tintMode, this.strokePaint, false);
        if(this.drawableState.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(this.drawableState.tintList.getColorForState(this.getState(), 0));
        }

        if(ObjectsCompat.equals(v0, this.tintFilter)) {
            if(!ObjectsCompat.equals(v1, this.strokeTintFilter)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private void updateZ() {
        float v0 = this.getZ();
        this.drawableState.shadowCompatRadius = ((int)Math.ceil(((double)(0.75f * v0))));
        this.drawableState.shadowCompatOffset = ((int)Math.ceil(((double)(v0 * 0.25f))));
        this.updateTintFilter();
        this.invalidateSelfIgnoreShape();
    }
}

