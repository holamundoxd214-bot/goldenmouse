package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter$Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\b!\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JE\u0010\u0017\u001A\u00020\u0018*\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001C\u001A\u00020\r2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020!¢\u0006\u0004\b\"\u0010#J-\u0010$\u001A\u00020\u0018*\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\tH$¢\u0006\u0004\b%\u0010&J\b\u0010\'\u001A\u00020\u0018H\u0016JQ\u0010(\u001A\u00020\u0018*\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\t2\u0006\u0010\u001F\u001A\u00020\u00162\b\u0010\u001A\u001A\u0004\u0018\u00010\u000B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001E2\u0006\u0010 \u001A\u00020!H$¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\u000B2\u0006\u0010\u001C\u001A\u00020\rH\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001A\u00020\u00182\u0006\u0010\u0002\u001A\u00020\u0003H\u0002R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\rX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0010\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u0010\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u000ER\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/Outline;)V", "getOutline", "()Landroidx/compose/ui/graphics/Outline;", "path", "Landroidx/compose/ui/graphics/Path;", "shadowTint", "Landroidx/compose/ui/graphics/ColorFilter;", "shadowTintColor", "Landroidx/compose/ui/graphics/Color;", "J", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "generatedSize", "Landroidx/compose/ui/geometry/Size;", "generatedLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "generatedDensity", "", "drawShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "colorFilter", "size", "color", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawShadow-erFMhIw", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/ColorFilter;JJLandroidx/compose/ui/graphics/Brush;FI)V", "buildShadow", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "invalidateShadow", "onDrawShadow", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "obtainTint", "obtainTint-8_81llA", "(J)Landroidx/compose/ui/graphics/ColorFilter;", "updateParamsFromOutline", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ShadowRenderer {
    public static final int $stable = 8;
    private long cornerRadius;
    private float generatedDensity;
    private LayoutDirection generatedLayoutDirection;
    private long generatedSize;
    private final Outline outline;
    private Path path;
    private ColorFilter shadowTint;
    private long shadowTintColor;

    static {
    }

    public ShadowRenderer(Outline arg3) {
        super();
        this.outline = arg3;
        this.shadowTintColor = Color.Companion.getUnspecified-0d7_KjU();
        this.cornerRadius = CornerRadius.Companion.getZero-kKHJgLs();
        this.generatedSize = Size.Companion.getUnspecified-NH-jbRc();
        this.generatedLayoutDirection = LayoutDirection.Ltr;
        this.generatedDensity = 1f;
    }

    protected abstract void buildShadow-_SMYjrA(DrawScope arg1, long arg2, long arg3, Path arg4);

    public final void drawShadow-erFMhIw(DrawScope arg12, ColorFilter arg13, long arg14, long arg16, Brush arg18, float arg19, int arg20) {
        long v0 = arg16;
        this.updateParamsFromOutline(this.outline);
        if(arg13 == null) {
            if(arg18 == null && v0 != 16) {
                arg13 = this.obtainTint-8_81llA(v0);
                goto label_4;
            }

            arg13 = null;
        }

    label_4:
        ColorFilter v8 = arg13;
        v0 = this.generatedSize;
        if(v0 == 0x7FC000007FC00000L || !Size.equals-impl0(v0, arg14) || this.generatedLayoutDirection != arg12.getLayoutDirection() || this.generatedDensity != arg12.getDensity()) {
            this.buildShadow-_SMYjrA(arg12, arg14, this.cornerRadius, this.path);
            this.generatedSize = arg14;
            this.generatedLayoutDirection = arg12.getLayoutDirection();
            this.generatedDensity = arg12.getDensity();
        }
        else {
        }

        this.onDrawShadow-MLmccfk(arg12, arg14, this.cornerRadius, this.path, arg19, v8, arg18, arg20);
    }

    public final Outline getOutline() {
        return this.outline;
    }

    public void invalidateShadow() {
        this.generatedSize = Size.Companion.getUnspecified-NH-jbRc();
        this.generatedLayoutDirection = LayoutDirection.Ltr;
        this.generatedDensity = 1f;
    }

    private final ColorFilter obtainTint-8_81llA(long arg9) {
        ColorFilter v0 = this.shadowTint;
        if(v0 != null) {
            if(!Color.equals-impl0(this.shadowTintColor, arg9)) {
            }
            else {
                return v0;
            }
        }

        long v3 = arg9;
        ColorFilter v9 = Companion.tint-xETnrds$default(ColorFilter.Companion, v3, 0, 2, null);
        this.shadowTintColor = v3;
        this.shadowTint = v9;
        return v9;
    }

    protected abstract void onDrawShadow-MLmccfk(DrawScope arg1, long arg2, long arg3, Path arg4, float arg5, ColorFilter arg6, Brush arg7, int arg8);

    private final void updateParamsFromOutline(Outline arg3) {
        if((arg3 instanceof Generic)) {
            this.path = ((Generic)arg3).getPath();
            this.cornerRadius = CornerRadius.Companion.getZero-kKHJgLs();
            return;
        }

        Path v1 = null;
        if((arg3 instanceof Rounded)) {
            if(RoundRectKt.isSimple(((Rounded)arg3).getRoundRect())) {
                this.path = v1;
                this.cornerRadius = ((Rounded)arg3).getRoundRect().getTopLeftCornerRadius-kKHJgLs();
                return;
            }

            this.path = ((Rounded)arg3).getRoundRectPath$ui_graphics();
            this.cornerRadius = CornerRadius.Companion.getZero-kKHJgLs();
            return;
        }

        if((arg3 instanceof Rectangle)) {
            this.path = v1;
            this.cornerRadius = CornerRadius.Companion.getZero-kKHJgLs();
            return;
        }

        throw new NoWhenBranchMatchedException();
    }
}

