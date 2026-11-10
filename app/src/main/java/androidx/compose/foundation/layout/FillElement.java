package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000B\u001A\u00020\u0002H\u0016J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0016J\f\u0010\u000F\u001A\u00020\r*\u00020\u0010H\u0016J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001A\u00020\u0016H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/foundation/layout/FillElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/FillNode;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "inspectorName", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;FLjava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "Companion", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) final class FillElement extends ModifierNodeElement {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007¨\u0006\n"}, d2={"Landroidx/compose/foundation/layout/FillElement$Companion;", "", "<init>", "()V", "width", "Landroidx/compose/foundation/layout/FillElement;", "fraction", "", "height", "size", "foundation-layout"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final FillElement height(float arg3) {
            return new FillElement(Direction.Vertical, arg3, "fillMaxHeight");
        }

        public final FillElement size(float arg3) {
            return new FillElement(Direction.Both, arg3, "fillMaxSize");
        }

        public final FillElement width(float arg3) {
            return new FillElement(Direction.Horizontal, arg3, "fillMaxWidth");
        }
    }

    public static final Companion Companion;
    private final Direction direction;
    private final float fraction;
    private final String inspectorName;

    static {
        FillElement.Companion = new Companion(null);
    }

    public FillElement(Direction arg1, float arg2, String arg3) {
        super();
        this.direction = arg1;
        this.fraction = arg2;
        this.inspectorName = arg3;
    }

    public FillNode create() {
        return new FillNode(this.direction, this.fraction);
    }

    public Node create() {
        return this.create();
    }

    public boolean equals(Object arg5) {
        if(this == (((FillElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof FillElement)) {
            return 0;
        }

        if(this.direction != ((FillElement)arg5).direction) {
            return 0;
        }

        if(this.fraction == ((FillElement)arg5).fraction) {
            return 1;
        }

        return 0;
    }

    public int hashCode() {
        return this.direction.hashCode() * 0x1F + Float.hashCode(this.fraction);
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName(this.inspectorName);
        arg2.getProperties().set("fraction", Float.valueOf(this.fraction));
    }

    public void update(FillNode arg2) {
        arg2.setDirection(this.direction);
        arg2.setFraction(this.fraction);
    }

    public void update(Node arg1) {
        this.update(((FillNode)arg1));
    }
}

