package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001A\u00020&J\u0006\u0010\'\u001A\u00020(JH\u0010)\u001A\u00020**\u00020&2\b\b\u0002\u0010+\u001A\u00020\u00012\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010\u001D\u001A\u00020,2\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/¢\u0006\u0004\b0\u00101J\u001F\u00102\u001A\u00020\u000B2\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/J\u001F\u00104\u001A\u00020\u000B2\u0017\u0010-\u001A\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/R\u001A\u0010\u0004\u001A\u00020\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001A\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR\u0011\u0010\u001D\u001A\u00020\u001E8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0011\u0010!\u001A\u00020\"8F¢\u0006\u0006\u001A\u0004\b#\u0010$R\u0014\u0010+\u001A\u0002058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b6\u00107R\u0014\u00108\u001A\u0002058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b9\u00107¨\u0006:"}, d2={"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", "<init>", "()V", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui", "(Landroidx/compose/ui/draw/DrawResult;)V", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "getContentDrawScope$ui", "()Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setContentDrawScope$ui", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "graphicsContextProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContextProvider$ui", "()Lkotlin/jvm/functions/Function0;", "setGraphicsContextProvider$ui", "(Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "obtainGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "obtainShadowContext", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "record", "", "density", "Landroidx/compose/ui/unit/IntSize;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-TdoYBX4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "onDrawBehind", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDrawWithContent", "", "getDensity", "()F", "fontScale", "getFontScale", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class CacheDrawScope implements Density {
    public static final int $stable;
    private BuildDrawCacheParams cacheParams;
    private ContentDrawScope contentDrawScope;
    private DrawResult drawResult;
    private Function0 graphicsContextProvider;

    static {
    }

    public CacheDrawScope() {
        super();
        this.cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    }

    public final BuildDrawCacheParams getCacheParams$ui() {
        return this.cacheParams;
    }

    public final ContentDrawScope getContentDrawScope$ui() {
        return this.contentDrawScope;
    }

    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    public final DrawResult getDrawResult$ui() {
        return this.drawResult;
    }

    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    public final Function0 getGraphicsContextProvider$ui() {
        return this.graphicsContextProvider;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    public final long getSize-NH-jbRc() {
        return this.cacheParams.getSize-NH-jbRc();
    }

    public final GraphicsLayer obtainGraphicsLayer() {
        Function0 v0 = this.graphicsContextProvider;
        Intrinsics.checkNotNull(v0);
        return v0.invoke().createGraphicsLayer();
    }

    public final ShadowContext obtainShadowContext() {
        Function0 v0 = this.graphicsContextProvider;
        Intrinsics.checkNotNull(v0);
        return v0.invoke().getShadowContext();
    }

    public final DrawResult onDrawBehind(Function1 arg2) {
        return this.onDrawWithContent(new CacheDrawScope$onDrawBehind$1(arg2));
    }

    public final DrawResult onDrawWithContent(Function1 arg2) {
        DrawResult v0 = new DrawResult(arg2);
        this.drawResult = v0;
        return v0;
    }

    public final void record-TdoYBX4(GraphicsLayer arg8, Density arg9, LayoutDirection arg10, long arg11, Function1 arg13) {
        ContentDrawScope v2 = this.contentDrawScope;
        Intrinsics.checkNotNull(v2);
        v2.record-JVtK1S4(arg8, arg11, new CacheDrawScope$record$1$1(arg13, v2, arg9, arg10, v2.getDrawContext().getDensity(), v2.getDrawContext().getLayoutDirection()));
    }

    public static void record-TdoYBX4$default(CacheDrawScope arg7, GraphicsLayer arg8, Density arg9, LayoutDirection arg10, long arg11, Function1 arg13, int arg14, Object arg15) {
        CacheDrawScope v9;
        if((arg14 & 1) != 0) {
            v9 = arg7;
        }

        Density v2 = ((Density)v9);
        if((arg14 & 2) != 0) {
            arg10 = arg7.getLayoutDirection();
        }

        LayoutDirection v3 = arg10;
        if((arg14 & 4) != 0) {
            arg11 = IntSizeKt.toIntSize-uvyYCjk(arg7.getSize-NH-jbRc());
        }

        arg7.record-TdoYBX4(arg8, v2, v3, arg11, arg13);
    }

    public final void setCacheParams$ui(BuildDrawCacheParams arg1) {
        this.cacheParams = arg1;
    }

    public final void setContentDrawScope$ui(ContentDrawScope arg1) {
        this.contentDrawScope = arg1;
    }

    public final void setDrawResult$ui(DrawResult arg1) {
        this.drawResult = arg1;
    }

    public final void setGraphicsContextProvider$ui(Function0 arg1) {
        this.graphicsContextProvider = arg1;
    }
}

