package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatingNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B0\u0012\'\u0010\u0002\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nR=\u0010\u0002\u001A#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0002\b\bX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u000E\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\n¨\u0006\u000F"}, d2={"Landroidx/compose/foundation/draganddrop/LegacyDragSourceNodeWithDefaultPainter;", "Landroidx/compose/ui/node/DelegatingNode;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "setDragAndDropSourceHandler", "Lkotlin/jvm/functions/Function2;", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) final class LegacyDragSourceNodeWithDefaultPainter extends DelegatingNode {
    private Function2 dragAndDropSourceHandler;

    public LegacyDragSourceNodeWithDefaultPainter(Function2 arg4) {
        super();
        this.dragAndDropSourceHandler = arg4;
        CacheDrawScopeDragShadowCallback v4 = new CacheDrawScopeDragShadowCallback();
        this.delegate(DrawModifierKt.CacheDrawModifierNode(new LegacyDragSourceNodeWithDefaultPainter$cacheDrawScopeDragShadowCallback$1$1(v4)));
        this.delegate(new LegacyDragAndDropSourceNode(new LegacyDragSourceNodeWithDefaultPainter$$ExternalSyntheticLambda0(v4), new Function2(null) {
            int label;

            public final Continuation create(Object arg2, Continuation arg3) {
                androidx.compose.foundation.draganddrop.LegacyDragSourceNodeWithDefaultPainter$2 v0 = new androidx.compose.foundation.draganddrop.LegacyDragSourceNodeWithDefaultPainter$2(LegacyDragSourceNodeWithDefaultPainter.this, arg3);
                v0.L$0 = arg2;
                return ((Continuation)v0);
            }

            public final Object invoke(DragAndDropSourceScope arg1, Continuation arg2) {
                return this.create(arg1, arg2).invokeSuspend(Unit.INSTANCE);
            }

            public Object invoke(Object arg1, Object arg2) {
                return this.invoke(((DragAndDropSourceScope)arg1), ((Continuation)arg2));
            }

            public final Object invokeSuspend(Object arg4) {
                Object v0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int v1 = this.label;
                if(v1 == 0) {
                    ResultKt.throwOnFailure(arg4);
                    arg4 = this.L$0;
                    Function2 v1_1 = LegacyDragSourceNodeWithDefaultPainter.this.getDragAndDropSourceHandler();
                    this.label = 1;
                    if(v1_1.invoke(arg4, this) == v0) {
                        return v0;
                    }
                }
                else if(v1 == 1) {
                    ResultKt.throwOnFailure(arg4);
                }
                else {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }

                return Unit.INSTANCE;
            }
        }));
    }

    static final Unit _init_$lambda$1(CacheDrawScopeDragShadowCallback arg0, DrawScope arg1) {
        arg0.drawDragShadow(arg1);
        return Unit.INSTANCE;
    }

    public final Function2 getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final void setDragAndDropSourceHandler(Function2 arg1) {
        this.dragAndDropSourceHandler = arg1;
    }
}

