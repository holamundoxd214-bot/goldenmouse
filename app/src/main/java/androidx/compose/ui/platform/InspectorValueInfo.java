package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B \u0012\u0017\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bR\u001F\u0010\u0002\u001A\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u0004\u0018\u00010\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2={"Landroidx/compose/ui/platform/InspectorValueInfo;", "Landroidx/compose/ui/platform/InspectableValue;", "info", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "_values", "values", "getValues", "()Landroidx/compose/ui/platform/InspectorInfo;", "nameFallback", "", "getNameFallback", "()Ljava/lang/String;", "valueOverride", "", "getValueOverride", "()Ljava/lang/Object;", "inspectableElements", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "getInspectableElements", "()Lkotlin/sequences/Sequence;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class InspectorValueInfo implements InspectableValue {
    public static final int $stable = 8;
    private InspectorInfo _values;
    private final Function1 info;

    static {
    }

    public InspectorValueInfo(Function1 arg1) {
        super();
        this.info = arg1;
    }

    public Sequence getInspectableElements() {
        return this.getValues().getProperties();
    }

    public String getNameFallback() {
        return this.getValues().getName();
    }

    public Object getValueOverride() {
        return this.getValues().getValue();
    }

    private final InspectorInfo getValues() {
        InspectorInfo v0 = this._values;
        if(v0 == null) {
            v0 = new InspectorInfo();
            this.info.invoke(v0);
        }

        this._values = v0;
        return v0;
    }
}

