package com.TryJeanPc.goldenmouse.macro.execution;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingSink;", "", "enabled", "", "record", "", "event", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroTimingRecord;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface MacroTimingSink {
    boolean enabled();

    void record(MacroTimingRecord arg1);
}

