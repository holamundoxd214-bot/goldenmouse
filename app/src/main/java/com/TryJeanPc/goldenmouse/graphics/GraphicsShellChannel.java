package com.TryJeanPc.goldenmouse.graphics;

import com.flyfishxu.kadb.shell.AdbShellPacket;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsShellChannel;", "Ljava/io/Closeable;", "read", "Lcom/flyfishxu/kadb/shell/AdbShellPacket;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface GraphicsShellChannel extends Closeable {
    AdbShellPacket read();
}

