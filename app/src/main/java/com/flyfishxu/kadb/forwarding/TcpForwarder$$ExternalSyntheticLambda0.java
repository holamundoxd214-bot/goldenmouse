package com.flyfishxu.kadb.forwarding;

import java.net.Socket;

public final class TcpForwarder$$ExternalSyntheticLambda0 implements Runnable {
    public TcpForwarder$$ExternalSyntheticLambda0(TcpForwarder arg1, Socket arg2) {
        super();
        this.f$0 = arg1;
        this.f$1 = arg2;
    }

    public final void run() {
        TcpForwarder.handleForwarding$lambda$0(this.f$0, this.f$1);
    }
}

