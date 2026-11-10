package com.TryJeanPc.goldenmouse.controls;

import com.TryJeanPc.goldenmouse.mapper.InputBinding;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\u000E\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0018\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH&J\u0014\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u000BH&¨\u0006\fÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/controls/ConfigurableInputControl;", "", "bindingSlots", "", "", "updateBinding", "", "slot", "binding", "Lcom/TryJeanPc/goldenmouse/mapper/InputBinding;", "currentBindings", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface ConfigurableInputControl {
    List bindingSlots();

    Map currentBindings();

    void updateBinding(String arg1, InputBinding arg2);
}

