package androidx.compose.ui.platform;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0001X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0011\u0010\u000F\u001A\u00020\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2={"Landroidx/compose/ui/platform/InspectorInfo;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "properties", "Landroidx/compose/ui/platform/ValueElementSequence;", "getProperties", "()Landroidx/compose/ui/platform/ValueElementSequence;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class InspectorInfo {
    public static final int $stable = 8;
    private String name;
    private final ValueElementSequence properties;
    private Object value;

    static {
    }

    public InspectorInfo() {
        super();
        this.properties = new ValueElementSequence();
    }

    public final String getName() {
        return this.name;
    }

    public final ValueElementSequence getProperties() {
        return this.properties;
    }

    public final Object getValue() {
        return this.value;
    }

    public final void setName(String arg1) {
        this.name = arg1;
    }

    public final void setValue(Object arg1) {
        this.value = arg1;
    }
}

