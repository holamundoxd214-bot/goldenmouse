package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B \u0012\u0017\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001A\u00020\u0002H\u0016J\u0010\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0002H\u0016J\f\u0010\u0014\u001A\u00020\u0007*\u00020\u0015H\u0016J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001A\u001A\u00020\u001BH\u0016R\"\u0010\u0004\u001A\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2={"Landroidx/compose/ui/semantics/ClearAndSetSemanticsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/semantics/CoreSemanticsModifierNode;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getProperties", "()Lkotlin/jvm/functions/Function1;", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ClearAndSetSemanticsElement extends ModifierNodeElement implements SemanticsModifier {
    public static final int $stable;
    private final Function1 properties;

    static {
    }

    public ClearAndSetSemanticsElement(Function1 arg1) {
        super();
        this.properties = arg1;
    }

    public Node create() {
        return this.create();
    }

    public CoreSemanticsModifierNode create() {
        return new CoreSemanticsModifierNode(false, true, this.properties);
    }

    public boolean equals(Object arg4) {
        if(this == (((ClearAndSetSemanticsElement)arg4))) {
            return 1;
        }

        if(!(arg4 instanceof ClearAndSetSemanticsElement)) {
            return 0;
        }

        if(this.properties != ((ClearAndSetSemanticsElement)arg4).properties) {
            return 0;
        }

        return 1;
    }

    public final Function1 getProperties() {
        return this.properties;
    }

    public SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsConfiguration v0 = new SemanticsConfiguration();
        v0.setMergingSemanticsOfDescendants(false);
        v0.setClearingSemantics(true);
        this.properties.invoke(v0);
        return v0;
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    public void inspectableProperties(InspectorInfo arg2) {
        arg2.setName("clearAndSetSemantics");
        SemanticsModifierKt.access$addSemanticsPropertiesFrom(arg2, this.getSemanticsConfiguration());
    }

    public void update(Node arg1) {
        this.update(((CoreSemanticsModifierNode)arg1));
    }

    public void update(CoreSemanticsModifierNode arg1) {
        arg1.setProperties(this.properties);
    }
}

