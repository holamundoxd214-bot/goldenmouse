package androidx.compose.material.ripple;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u0007H\u0086\u0002J\u0013\u0010\r\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u000B\u001A\u00020\u0006H\u0086\u0002J\u0013\u0010\r\u001A\u0004\u0018\u00010\u00062\u0006\u0010\f\u001A\u00020\u0007H\u0086\u0002J\u000E\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0006R\u001A\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/material/ripple/RippleHostMap;", "", "<init>", "()V", "indicationToHostMap", "", "Landroidx/compose/material/ripple/RippleHostKey;", "Landroidx/compose/material/ripple/RippleHostView;", "hostToIndicationMap", "set", "", "indicationInstance", "rippleHostView", "get", "remove", "material-ripple"}, k=1, mv={2, 0, 0}, xi=0x30) final class RippleHostMap {
    private final Map hostToIndicationMap;
    private final Map indicationToHostMap;

    public RippleHostMap() {
        super();
        this.indicationToHostMap = new LinkedHashMap();
        this.hostToIndicationMap = new LinkedHashMap();
    }

    public final RippleHostView get(RippleHostKey arg1) {
        return this.indicationToHostMap.get(arg1);
    }

    public final RippleHostKey get(RippleHostView arg1) {
        return this.hostToIndicationMap.get(arg1);
    }

    public final void remove(RippleHostKey arg3) {
        Object v0 = this.indicationToHostMap.get(arg3);
        if(v0 != null) {
            this.hostToIndicationMap.remove(v0);
        }

        this.indicationToHostMap.remove(arg3);
    }

    public final void set(RippleHostKey arg2, RippleHostView arg3) {
        this.indicationToHostMap.put(arg2, arg3);
        this.hostToIndicationMap.put(arg3, arg2);
    }
}

