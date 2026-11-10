package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B(\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0017\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u000B\u0010\fJ\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u0010\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u0002H\u0016J\f\u0010\u0018\u001A\u00020\t*\u00020\u0019H\u0016J\u0013\u0010\u001A\u001A\u00020\u00052\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CH\u0096\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\"\u0010\u0006\u001A\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u001F"}, d2={"Landroidx/compose/ui/semantics/AppendedSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "mergeDescendants", "", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "getMergeDescendants", "()Z", "getProperties", "()Lkotlin/jvm/functions/Function1;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AppendedSemanticsElement extends ModifierNodeElement implements SemanticsModifier {
    public static final int $stable;
    private final boolean mergeDescendants;
    private final Function1 properties;

    static {
    }

    public AppendedSemanticsElement(boolean arg1, Function1 arg2) {
        super();
        this.mergeDescendants = arg1;
        this.properties = arg2;
    }

    public Node create() {
        return this.create();
    }

    public CoreSemanticsModifierNode create() {
        return new CoreSemanticsModifierNode(this.mergeDescendants, false, this.properties);
    }

    public boolean equals(Object arg5) {
        if(this == (((AppendedSemanticsElement)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof AppendedSemanticsElement)) {
            return 0;
        }

        if(this.mergeDescendants != ((AppendedSemanticsElement)arg5).mergeDescendants) {
            return 0;
        }

        if(this.properties != ((AppendedSemanticsElement)arg5).properties) {
            return 0;
        }

        return 1;
    }

    public final boolean getMergeDescendants() {
        return this.mergeDescendants;
    }

    public final Function1 getProperties() {
        return this.properties;
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration v0 = new SemanticsConfiguration();
        v0.setMergingSemanticsOfDescendants(this.mergeDescendants);
        this.properties.invoke(v0);
        return v0;
    }

    public int hashCode() {
        return Boolean.hashCode(this.mergeDescendants) * 0x1F + this.properties.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg4) {
        arg4.setName("semantics");
        arg4.getProperties().set("mergeDescendants", Boolean.valueOf(this.mergeDescendants));
        SemanticsModifierKt.access$addSemanticsPropertiesFrom(arg4, this.getSemanticsConfiguration());
    }

    public void update(Node arg1) {
        this.update(((CoreSemanticsModifierNode)arg1));
    }

    public void update(CoreSemanticsModifierNode arg2) {
        arg2.setMergeDescendants(this.mergeDescendants);
        arg2.setProperties(this.properties);
    }
}

