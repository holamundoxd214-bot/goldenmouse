package androidx.compose.ui.node;

import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0019\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u001AJ\u0015\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u001EJ\f\u0010\u001F\u001A\u00020\u001C*\u00020\bH\u0016J\b\u0010 \u001A\u00020!H&J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010\u0011H¦\u0002R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\f\u001A\u0004\u0018\u00010\r8F¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u00158F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2={"Landroidx/compose/ui/node/ModifierNodeElement;", "N", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectableValue;", "<init>", "()V", "_inspectorValues", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectorValues", "getInspectorValues", "()Landroidx/compose/ui/platform/InspectorInfo;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "", "getValueOverride", "()Ljava/lang/Object;", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "create", "()Landroidx/compose/ui/Modifier$Node;", "update", "", "node", "(Landroidx/compose/ui/Modifier$Node;)V", "inspectableProperties", "hashCode", "", "equals", "", "other", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class ModifierNodeElement implements Element, InspectableValue {
    public static final int $stable;
    private InspectorInfo _inspectorValues;

    static {
    }

    public ModifierNodeElement() {
        super();
    }

    public abstract Node create();

    public abstract boolean equals(Object arg1);

    public final Sequence getInspectableElements() {
        return this.getInspectorValues().getProperties();
    }

    private final InspectorInfo getInspectorValues() {
        InspectorInfo v0 = this._inspectorValues;
        if(v0 == null) {
            v0 = new InspectorInfo();
            v0.setName(Reflection.getOrCreateKotlinClass(this.getClass()).getSimpleName());
            this.inspectableProperties(v0);
            this._inspectorValues = v0;
        }

        return v0;
    }

    public final String getNameFallback() {
        return this.getInspectorValues().getName();
    }

    public final Object getValueOverride() {
        return this.getInspectorValues().getValue();
    }

    public abstract int hashCode();

    public void inspectableProperties(InspectorInfo arg1) {
        Actual_jvmKt.tryPopulateReflectively(arg1, this);
    }

    public abstract void update(Node arg1);
}

