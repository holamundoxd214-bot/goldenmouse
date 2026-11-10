package com.flyfishxu.kadb;

import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0002¨\u0006\u0005"}, d2={"readUntil", "Lokio/Buffer;", "Lokio/BufferedSource;", "endByte", "", "kadb"}, k=2, mv={2, 3, 0}, xi=0x30) public final class KadbKt {
    public static final Buffer access$readUntil(BufferedSource arg0, byte arg1) {
        return KadbKt.readUntil(arg0, arg1);
    }

    private static final Buffer readUntil(BufferedSource arg2, byte arg3) {
        Buffer v0 = new Buffer();
        do {
            int v1 = arg2.readByte();
            v0.writeByte(v1);
        }
        while(v1 != arg3);

        return v0;
    }
}

