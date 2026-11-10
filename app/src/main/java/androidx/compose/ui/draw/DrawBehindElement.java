package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B \u0012\u0017\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001A\u00020\u0002H\u0016J\u0010\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\f\u0010\u000F\u001A\u00020\u0006*\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\"\u0010\u0003\u001A\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0017"}, d2={"Landroidx/compose/ui/draw/DrawBehindElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/DrawBackgroundModifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnDraw", "()Lkotlin/jvm/functions/Function1;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class DrawBehindElement extends ModifierNodeElement {
    private final Function1 onDraw;

    public DrawBehindElement(Function1 arg1) {
        super();
        this.onDraw = arg1;
    }

    public Node create() {
        return this.create();
    }

    public DrawBackgroundModifier create() {
        return new DrawBackgroundModifier(this.onDraw);
    }

    public boolean equals(Object arg4) {
        if(this == (((DrawBehindElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof DrawBehindElement)) {
            return 0;
        }

        if(this.onDraw != ((DrawBehindElement)arg4).onDraw) {
            return 0;
        }

        return 1;
    }

    public final Function1 getOnDraw() {
        return this.onDraw;
    }

    public int hashCode() {
        return this.onDraw.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("drawBehind");
        arg2.getProperties().set("onDraw", this.onDraw);
    }

    public void update(Node arg1) {
        this.update(((DrawBackgroundModifier)arg1));
    }

    public void update(DrawBackgroundModifier arg1) {
        arg1.setOnDraw(this.onDraw);
    }
}

