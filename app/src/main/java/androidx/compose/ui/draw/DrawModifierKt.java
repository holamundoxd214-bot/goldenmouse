package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u001A#\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u0006\u001A\u001F\u0010\u000B\u001A\u00020\f2\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\b\u0006\u001A#\u0010\r\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u000F"}, d2={"drawBehind", "Landroidx/compose/ui/Modifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawWithCache", "onBuildDrawCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "CacheDrawModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class DrawModifierKt {
    public static final CacheDrawModifierNode CacheDrawModifierNode(Function1 arg2) {
        return new CacheDrawModifierNodeImpl(new CacheDrawScope(), arg2);
    }

    public static final Modifier drawBehind(Modifier arg1, Function1 arg2) {
        return arg1.then(new DrawBehindElement(arg2));
    }

    public static final Modifier drawWithCache(Modifier arg1, Function1 arg2) {
        return arg1.then(new DrawWithCacheElement(arg2));
    }

    public static final Modifier drawWithContent(Modifier arg1, Function1 arg2) {
        return arg1.then(new DrawWithContentElement(arg2));
    }
}

