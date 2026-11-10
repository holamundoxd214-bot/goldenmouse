package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001A\u00020\u0002H\u0016J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0002H\u0016J\f\u0010\u0010\u001A\u00020\u000E*\u00020\u0011H\u0016J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001A\u00020\u0017H\u0016R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0018"}, d2={"Landroidx/compose/ui/draw/DrawWithCacheElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/CacheDrawModifierNodeImpl;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnBuildDrawCache", "()Lkotlin/jvm/functions/Function1;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DrawWithCacheElement extends ModifierNodeElement {
    private final Function1 onBuildDrawCache;

    public DrawWithCacheElement(Function1 arg1) {
        super();
        this.onBuildDrawCache = arg1;
    }

    public Node create() {
        return this.create();
    }

    public CacheDrawModifierNodeImpl create() {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), this.onBuildDrawCache);
    }

    public boolean equals(Object arg4) {
        if(this == (((DrawWithCacheElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof DrawWithCacheElement)) {
            return 0;
        }

        if(this.onBuildDrawCache != ((DrawWithCacheElement)arg4).onBuildDrawCache) {
            return 0;
        }

        return 1;
    }

    public final Function1 getOnBuildDrawCache() {
        return this.onBuildDrawCache;
    }

    public int hashCode() {
        return this.onBuildDrawCache.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("drawWithCache");
        arg2.getProperties().set("onBuildDrawCache", this.onBuildDrawCache);
    }

    public void update(Node arg1) {
        this.update(((CacheDrawModifierNodeImpl)arg1));
    }

    public void update(CacheDrawModifierNodeImpl arg1) {
        arg1.setBlock(this.onBuildDrawCache);
    }
}

