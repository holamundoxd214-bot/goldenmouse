package com.TryJeanPc.goldenmouse.graphics;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001A\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0003H&J\b\u0010\u0007\u001A\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecordStore;", "", "read", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "write", "", "record", "clear", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface GraphicsRecordStore {
    void clear();

    GraphicsRecord read();

    void write(GraphicsRecord arg1);
}

