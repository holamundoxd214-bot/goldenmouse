package com.flyfishxu.kadb.shell;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0012\u001A\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u001B\u0010\u000E\u001A\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u000F\u0010\n¨\u0006\u0013"}, d2={"Lcom/flyfishxu/kadb/shell/AdbShellResponse;", "", "output", "", "errorOutput", "exitCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getOutput", "()Ljava/lang/String;", "getErrorOutput", "getExitCode", "()I", "allOutput", "getAllOutput", "allOutput$delegate", "Lkotlin/Lazy;", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class AdbShellResponse {
    private final Lazy allOutput$delegate;
    private final String errorOutput;
    private final int exitCode;
    private final String output;

    public AdbShellResponse(String arg2, String arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "output");
        Intrinsics.checkNotNullParameter(arg3, "errorOutput");
        super();
        this.output = arg2;
        this.errorOutput = arg3;
        this.exitCode = arg4;
        this.allOutput$delegate = LazyKt.lazy(new AdbShellResponse$$ExternalSyntheticLambda0(this));
    }

    static final String allOutput_delegate$lambda$0(AdbShellResponse arg2) {
        return arg2.output + arg2.errorOutput;
    }

    public final String getAllOutput() {
        return this.allOutput$delegate.getValue();
    }

    public final String getErrorOutput() {
        return this.errorOutput;
    }

    public final int getExitCode() {
        return this.exitCode;
    }

    public final String getOutput() {
        return this.output;
    }

    public String toString() {
        return "Shell response (" + this.exitCode + "):\n" + this.getAllOutput();
    }
}

