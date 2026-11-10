package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000BJ=\u0010\f\u001A\u00020\u0003*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00112\u0017\u0010\u0012\u001A\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001A\u00020\tJ\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0003HÂ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0005HÂ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0007HÂ\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020%HÖ\u0001R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "<init>", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "obtainPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class BorderCache {
    private Path borderPath;
    private Canvas canvas;
    private CanvasDrawScope canvasDrawScope;
    private ImageBitmap imageBitmap;

    public BorderCache() {
        this(null, null, null, null, 15, null);
    }

    public BorderCache(ImageBitmap arg2, Canvas arg3, CanvasDrawScope arg4, Path arg5, int arg6, DefaultConstructorMarker arg7) {
        ImageBitmap v0 = null;
        if((arg6 & 1) != 0) {
            arg2 = v0;
        }

        if((arg6 & 2) != 0) {
            arg3 = ((Canvas)v0);
        }

        if((arg6 & 4) != 0) {
            arg4 = ((CanvasDrawScope)v0);
        }

        if((arg6 & 8) != 0) {
            arg5 = ((Path)v0);
        }

        this(arg2, arg3, arg4, arg5);
    }

    public BorderCache(ImageBitmap arg1, Canvas arg2, CanvasDrawScope arg3, Path arg4) {
        super();
        this.imageBitmap = arg1;
        this.canvas = arg2;
        this.canvasDrawScope = arg3;
        this.borderPath = arg4;
    }

    public static final Canvas access$getCanvas$p(BorderCache arg0) {
        return arg0.canvas;
    }

    public static final CanvasDrawScope access$getCanvasDrawScope$p(BorderCache arg0) {
        return arg0.canvasDrawScope;
    }

    public static final ImageBitmap access$getImageBitmap$p(BorderCache arg0) {
        return arg0.imageBitmap;
    }

    public static final void access$setCanvas$p(BorderCache arg0, Canvas arg1) {
        arg0.canvas = arg1;
    }

    public static final void access$setCanvasDrawScope$p(BorderCache arg0, CanvasDrawScope arg1) {
        arg0.canvasDrawScope = arg1;
    }

    public static final void access$setImageBitmap$p(BorderCache arg0, ImageBitmap arg1) {
        arg0.imageBitmap = arg1;
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public final BorderCache copy(ImageBitmap arg1, Canvas arg2, CanvasDrawScope arg3, Path arg4) {
        return new BorderCache(arg1, arg2, arg3, arg4);
    }

    public static BorderCache copy$default(BorderCache arg0, ImageBitmap arg1, Canvas arg2, CanvasDrawScope arg3, Path arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.imageBitmap;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.canvas;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.canvasDrawScope;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.borderPath;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public final ImageBitmap drawBorderCache-EMwLDEs(CacheDrawScope arg26, long arg27, int arg29, Function1 arg30) {
        int v9;
        BorderCache v0 = this;
        ImageBitmap v1 = v0.imageBitmap;
        Canvas v2 = v0.canvas;
        Object v3 = null;
        ImageBitmapConfig v4 = v1 != null ? ImageBitmapConfig.box-impl(v1.getConfig-_sVssgQ()) : ((ImageBitmapConfig)v3);
        int v5 = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        int v6 = 0;
        boolean v4_1 = v4 == null ? false : ImageBitmapConfig.equals-impl0(v4.unbox-impl(), v5);
        if(!v4_1) {
            if(v1 != null) {
                ImageBitmapConfig v3_1 = ImageBitmapConfig.box-impl(v1.getConfig-_sVssgQ());
            }

            v9 = arg29;
            if(!ImageBitmapConfig.equals-impl(v9, v3)) {
                goto label_27;
            }

            goto label_26;
        }
        else {
            v9 = arg29;
        label_26:
            v6 = 1;
        }

    label_27:
        long v3_2 = 0xFFFFFFFFL;
        v5 = 0x20;
        if(v1 == null || v2 == null || Float.intBitsToFloat(((int)(arg26.getSize-NH-jbRc() >> v5))) > (((float)v1.getWidth())) || Float.intBitsToFloat(((int)(arg26.getSize-NH-jbRc() & v3_2))) > (((float)v1.getHeight())) || v6 == 0) {
            v1 = ImageBitmapKt.ImageBitmap-x__-hDU$default(((int)(arg27 >> v5)), ((int)(arg27 & v3_2)), v9, false, null, 24, null);
            v0.imageBitmap = v1;
            v2 = CanvasKt.Canvas(v1);
            v0.canvas = v2;
        }

        CanvasDrawScope v3_3 = v0.canvasDrawScope;
        if(v3_3 == null) {
            v3_3 = new CanvasDrawScope();
            v0.canvasDrawScope = v3_3;
        }

        long v9_1 = IntSizeKt.toSize-ozmzZPI(arg27);
        LayoutDirection v4_2 = arg26.getLayoutDirection();
        DrawParams v5_1 = v3_3.getDrawParams();
        Density v6_1 = v5_1.component1();
        LayoutDirection v7 = v5_1.component2();
        Canvas v8 = v5_1.component3();
        long v11 = v5_1.component4-NH-jbRc();
        v5_1 = v3_3.getDrawParams();
        v5_1.setDensity(arg26);
        v5_1.setLayoutDirection(v4_2);
        v5_1.setCanvas(v2);
        v5_1.setSize-uvyYCjk(v9_1);
        v2.save();
        DrawScope.drawRect-n-J9OG0$default(v3_3, Color.Companion.getBlack-0d7_KjU(), 0, v9_1, 0f, null, null, BlendMode.Companion.getClear-0nO6VwU(), 58, null);
        arg30.invoke(v3_3);
        v2.restore();
        DrawParams v3_4 = v3_3.getDrawParams();
        v3_4.setDensity(v6_1);
        v3_4.setLayoutDirection(v7);
        v3_4.setCanvas(v8);
        v3_4.setSize-uvyYCjk(v11);
        v1.prepareToDraw();
        return v1;
    }

    public boolean equals(Object arg5) {
        if(this == (((BorderCache)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof BorderCache)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.imageBitmap, ((BorderCache)arg5).imageBitmap)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.canvas, ((BorderCache)arg5).canvas)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.canvasDrawScope, ((BorderCache)arg5).canvasDrawScope)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.borderPath, ((BorderCache)arg5).borderPath)) {
            return 0;
        }

        return 1;
    }

    public int hashCode() {
        ImageBitmap v0 = this.imageBitmap;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        Canvas v2 = this.canvas;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        CanvasDrawScope v2_2 = this.canvasDrawScope;
        v2_1 = v2_2 == null ? 0 : v2_2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        Path v3 = this.borderPath;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public final Path obtainPath() {
        Path v0 = this.borderPath;
        if(v0 == null) {
            v0 = AndroidPath_androidKt.Path();
            this.borderPath = v0;
        }

        return v0;
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }
}

