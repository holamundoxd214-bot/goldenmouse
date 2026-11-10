package com.TryJeanPc.goldenmouse.input;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000E\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\u0004H&¨\u0006\tÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/input/InputDeviceDiscovery;", "", "listDevices", "", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceDescriptor;", "classifyRoles", "", "Lcom/TryJeanPc/goldenmouse/input/InputDeviceRole;", "device", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface InputDeviceDiscovery {
    Set classifyRoles(InputDeviceDescriptor arg1);

    List listDevices();
}

