package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0017\u0010\u001C\u001A\u0013\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\u001A0\u001D¢\u0006\u0002\b\u001F¢\u0006\u0004\b \u0010!J$\u0010\"\u001A\u00020\u001A2\u0006\u0010#\u001A\u00020\u001E2\b\b\u0002\u0010$\u001A\u00020%2\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\'J\f\u0010(\u001A\u00020\u001A*\u00020\u001EH\u0002R&\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0000@\u0000X\u0081\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001A\u00020\u0015X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0016R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "<init>", "()V", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "I", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-FqjB98A", "(IJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class DrawCache {
    public static final int $stable = 8;
    private final CanvasDrawScope cacheScope;
    private Canvas cachedCanvas;
    private int config;
    private LayoutDirection layoutDirection;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private long size;

    static {
    }

    public DrawCache() {
        super();
        this.layoutDirection = LayoutDirection.Ltr;
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.config = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        this.cacheScope = new CanvasDrawScope();
    }

    private final void clear(DrawScope arg14) {
        DrawScope.drawRect-n-J9OG0$default(arg14, Color.Companion.getBlack-0d7_KjU(), 0, 0, 0f, null, null, BlendMode.Companion.getClear-0nO6VwU(), 62, null);
    }

    public final void drawCachedImage-FqjB98A(int arg15, long arg16, Density arg18, LayoutDirection arg19, Function1 arg20) {
        long v8 = arg16;
        Density v10 = arg18;
        LayoutDirection v11 = arg19;
        this.scopeDensity = v10;
        this.layoutDirection = v11;
        ImageBitmap v1 = this.mCachedImage;
        Canvas v2 = this.cachedCanvas;
        long v4 = 0xFFFFFFFFL;
        int v6 = 0x20;
        if(v1 == null || v2 == null || (((int)(v8 >> v6))) > v1.getWidth() || (((int)(v8 & v4))) > v1.getHeight() || !ImageBitmapConfig.equals-impl0(this.config, arg15)) {
            v1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(v8 >> v6)), ((int)(v4 & v8)), arg15, false, null, 24, null);
            v2 = CanvasKt.Canvas(v1);
            this.mCachedImage = v1;
            this.cachedCanvas = v2;
            this.config = arg15;
        }

        this.size = v8;
        CanvasDrawScope v3 = this.cacheScope;
        v4 = IntSizeKt.toSize-ozmzZPI(v8);
        DrawParams v6_1 = v3.getDrawParams();
        Density v7 = v6_1.component1();
        LayoutDirection v8_1 = v6_1.component2();
        Canvas v9 = v6_1.component3();
        long v12 = v6_1.component4-NH-jbRc();
        v6_1 = v3.getDrawParams();
        v6_1.setDensity(v10);
        v6_1.setLayoutDirection(v11);
        v6_1.setCanvas(v2);
        v6_1.setSize-uvyYCjk(v4);
        v2.save();
        this.clear(v3);
        arg20.invoke(v3);
        v2.restore();
        DrawParams v0 = v3.getDrawParams();
        v0.setDensity(v7);
        v0.setLayoutDirection(v8_1);
        v0.setCanvas(v9);
        v0.setSize-uvyYCjk(v12);
        v1.prepareToDraw();
    }

    public final void drawInto(DrawScope arg18, float arg19, ColorFilter arg20) {
        DrawCache v0 = this;
        ImageBitmap v1 = v0.mCachedImage;
        int v2 = v1 != null ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }

        DrawScope.drawImage-AZ2fEMs$default(arg18, v1, 0, v0.size, 0, 0, arg19, null, arg20, 0, 0, 858, null);
    }

    public static void drawInto$default(DrawCache arg0, DrawScope arg1, float arg2, ColorFilter arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = 1f;
        }

        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        arg0.drawInto(arg1, arg2, arg3);
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public static void getMCachedImage$annotations() {
    }

    public final void setMCachedImage(ImageBitmap arg1) {
        this.mCachedImage = arg1;
    }
}

