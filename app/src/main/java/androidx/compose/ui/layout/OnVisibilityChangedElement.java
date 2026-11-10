package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000EJ\b\u0010\u0017\u001A\u00020\u0002H\u0016J\u0010\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016J\f\u0010\u001A\u001A\u00020\f*\u00020\u001BH\u0016J\u0013\u0010\u001C\u001A\u00020\u000B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0096\u0002J\b\u0010\u001F\u001A\u00020 H\u0016R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u001D\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2={"Landroidx/compose/ui/layout/OnVisibilityChangedElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnVisibilityChangedNode;", "minDurationMs", "", "minFractionVisible", "", "viewportBounds", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "callback", "Lkotlin/Function1;", "", "", "<init>", "(JFLandroidx/compose/ui/layout/LayoutBoundsHolder;Lkotlin/jvm/functions/Function1;)V", "getMinDurationMs", "()J", "getMinFractionVisible", "()F", "getViewportBounds", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class OnVisibilityChangedElement extends ModifierNodeElement {
    private final Function1 callback;
    private final long minDurationMs;
    private final float minFractionVisible;
    private final LayoutBoundsHolder viewportBounds;

    public OnVisibilityChangedElement(long arg1, float arg3, LayoutBoundsHolder arg4, Function1 arg5) {
        super();
        this.minDurationMs = arg1;
        this.minFractionVisible = arg3;
        this.viewportBounds = arg4;
        this.callback = arg5;
    }

    public Node create() {
        return this.create();
    }

    public OnVisibilityChangedNode create() {
        return new OnVisibilityChangedNode(this.minDurationMs, this.minFractionVisible, this.viewportBounds, this.callback);
    }

    public boolean equals(Object arg7) {
        if(this == (((OnVisibilityChangedElement)arg7))) {
            return 1;
        }

        if(arg7 != null) {
            if(this.getClass() != arg7.getClass()) {
            }
            else if(this.minDurationMs != ((OnVisibilityChangedElement)arg7).minDurationMs) {
                return 0;
            }
            else if(this.minFractionVisible == ((OnVisibilityChangedElement)arg7).minFractionVisible) {
                if(!Intrinsics.areEqual(this.viewportBounds, ((OnVisibilityChangedElement)arg7).viewportBounds)) {
                    return 0;
                }
                else if(this.callback != ((OnVisibilityChangedElement)arg7).callback) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
        }

        return 0;
    }

    public final Function1 getCallback() {
        return this.callback;
    }

    public final long getMinDurationMs() {
        return this.minDurationMs;
    }

    public final float getMinFractionVisible() {
        return this.minFractionVisible;
    }

    public final LayoutBoundsHolder getViewportBounds() {
        return this.viewportBounds;
    }

    public int hashCode() {
        int v0 = (Long.hashCode(this.minDurationMs) * 0x1F + Float.hashCode(this.minFractionVisible)) * 0x1F;
        LayoutBoundsHolder v1 = this.viewportBounds;
        int v1_1 = v1 != null ? v1.hashCode() : 0;
        return (v0 + v1_1) * 0x1F + this.callback.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("onViewportVisibilityChanged");
        arg4.getProperties().set("minDurationMs", Long.valueOf(this.minDurationMs));
        arg4.getProperties().set("minFractionVisible", Float.valueOf(this.minFractionVisible));
        arg4.getProperties().set("viewportRef", this.viewportBounds);
        arg4.getProperties().set("callback", this.callback);
    }

    public void update(Node arg1) {
        this.update(((OnVisibilityChangedNode)arg1));
    }

    public void update(OnVisibilityChangedNode arg3) {
        arg3.setMinDurationMs(this.minDurationMs);
        arg3.setMinFractionVisible(this.minFractionVisible);
        arg3.setCallback(this.callback);
        arg3.setViewportBounds(this.viewportBounds);
        arg3.forceUpdate();
    }
}

