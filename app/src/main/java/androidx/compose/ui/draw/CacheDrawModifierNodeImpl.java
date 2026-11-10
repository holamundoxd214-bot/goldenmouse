package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B(\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0017\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010&\u001A\u00020\'H\u0016J\b\u0010(\u001A\u00020\'H\u0016J\b\u0010)\u001A\u00020\'H\u0016J\b\u0010*\u001A\u00020\'H\u0016J\b\u0010+\u001A\u00020\'H\u0016J\b\u0010,\u001A\u00020\'H\u0016J\b\u0010-\u001A\u00020\'H\u0016J\u0010\u0010.\u001A\u00020\t2\u0006\u0010/\u001A\u000200H\u0002J\f\u00101\u001A\u00020\'*\u000200H\u0016R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E¢\u0006\u0002\n\u0000RF\u0010\u0007\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n2\u0017\u0010\u0011\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n@FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u001F8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b \u0010!R\u0011\u0010\"\u001A\u00020#8F¢\u0006\u0006\u001A\u0004\b$\u0010%¨\u00062"}, d2={"Landroidx/compose/ui/draw/CacheDrawModifierNodeImpl;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "cacheDrawScope", "Landroidx/compose/ui/draw/CacheDrawScope;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/ui/draw/CacheDrawScope;Lkotlin/jvm/functions/Function1;)V", "isCacheValid", "", "cachedGraphicsContext", "Landroidx/compose/ui/draw/ScopedGraphicsContext;", "value", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "(Lkotlin/jvm/functions/Function1;)V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "onDetach", "", "onReset", "onMeasureResultChanged", "onObservedReadsChanged", "invalidateDrawCache", "onDensityChange", "onLayoutDirectionChange", "getOrBuildCachedDrawBlock", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class CacheDrawModifierNodeImpl extends Node implements BuildDrawCacheParams, CacheDrawModifierNode, ObserverModifierNode {
    private Function1 block;
    private final CacheDrawScope cacheDrawScope;
    private ScopedGraphicsContext cachedGraphicsContext;
    private boolean isCacheValid;

    public CacheDrawModifierNodeImpl(CacheDrawScope arg1, Function1 arg2) {
        super();
        this.cacheDrawScope = arg1;
        this.block = arg2;
        arg1.setCacheParams$ui(this);
        arg1.setGraphicsContextProvider$ui(new Function0() {
            public final GraphicsContext invoke() {
                return CacheDrawModifierNodeImpl.this.getGraphicsContext();
            }

            public Object invoke() {
                return this.invoke();
            }
        });
    }

    public void draw(ContentDrawScope arg1) {
        this.getOrBuildCachedDrawBlock(arg1).getBlock$ui().invoke(arg1);
    }

    public final Function1 getBlock() {
        return this.block;
    }

    public Density getDensity() {
        return DelegatableNodeKt.requireDensity(((DelegatableNode)this));
    }

    public final GraphicsContext getGraphicsContext() {
        ScopedGraphicsContext v0 = this.cachedGraphicsContext;
        if(v0 == null) {
            v0 = new ScopedGraphicsContext();
            this.cachedGraphicsContext = v0;
        }

        if(v0.getGraphicsContext() == null) {
            v0.setGraphicsContext(DelegatableNodeKt.requireGraphicsContext(((DelegatableNode)this)));
        }

        return ((GraphicsContext)v0);
    }

    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutDirection(((DelegatableNode)this));
    }

    private final DrawResult getOrBuildCachedDrawBlock(ContentDrawScope arg3) {
        if(!this.isCacheValid) {
            CacheDrawScope v0 = this.cacheDrawScope;
            v0.setDrawResult$ui(null);
            v0.setContentDrawScope$ui(arg3);
            ObserverModifierNodeKt.observeReads(this, new CacheDrawModifierNodeImpl$getOrBuildCachedDrawBlock$1$1(this, v0));
            if(v0.getDrawResult$ui() != null) {
                this.isCacheValid = true;
            }
            else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("DrawResult not defined, did you forget to call onDraw?");
                throw new KotlinNothingValueException();
            }
        }

        DrawResult v2 = this.cacheDrawScope.getDrawResult$ui();
        Intrinsics.checkNotNull(v2);
        return v2;
    }

    public long getSize-NH-jbRc() {
        return IntSizeKt.toSize-ozmzZPI(DelegatableNodeKt.requireCoordinator-64DMado(((DelegatableNode)this), NodeKind.constructor-impl(4)).getSize-YbymL2g());
    }

    public void invalidateDrawCache() {
        ScopedGraphicsContext v0 = this.cachedGraphicsContext;
        if(v0 != null) {
            v0.releaseGraphicsLayers();
        }

        this.isCacheValid = false;
        this.cacheDrawScope.setDrawResult$ui(null);
        DrawModifierNodeKt.invalidateDraw(((DrawModifierNode)this));
    }

    public void onDensityChange() {
        this.invalidateDrawCache();
    }

    public void onDetach() {
        super.onDetach();
        ScopedGraphicsContext v0 = this.cachedGraphicsContext;
        if(v0 != null) {
            v0.releaseGraphicsLayers();
        }
    }

    public void onLayoutDirectionChange() {
        this.invalidateDrawCache();
    }

    public void onMeasureResultChanged() {
        this.invalidateDrawCache();
    }

    public void onObservedReadsChanged() {
        this.invalidateDrawCache();
    }

    public void onReset() {
        super.onReset();
        this.invalidateDrawCache();
    }

    public final void setBlock(Function1 arg1) {
        this.block = arg1;
        this.invalidateDrawCache();
    }
}

