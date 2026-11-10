package androidx.compose.ui.platform;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001A\u00020\u0002H\u0016J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0002H\u0016J\f\u0010\u000B\u001A\u00020\t*\u00020\fH\u0016J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/ui/platform/TestTagElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/platform/TestTagNode;", "tag", "", "<init>", "(Ljava/lang/String;)V", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class TestTagElement extends ModifierNodeElement {
    private final String tag;

    public TestTagElement(String arg1) {
        super();
        this.tag = arg1;
    }

    public Node create() {
        return this.create();
    }

    public TestTagNode create() {
        return new TestTagNode(this.tag);
    }

    public boolean equals(Object arg2) {
        if(this == (((TestTagElement)arg2))) {
            return 1;
        }

        if(!(arg2 instanceof TestTagElement)) {
            return 0;
        }

        return Intrinsics.areEqual(this.tag, ((TestTagElement)arg2).tag);
    }

    public int hashCode() {
        return this.tag.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("testTag");
        arg2.getProperties().set("tag", this.tag);
    }

    public void update(Node arg1) {
        this.update(((TestTagNode)arg1));
    }

    public void update(TestTagNode arg1) {
        arg1.setTag(this.tag);
    }
}

