package androidx.compose.runtime.tooling;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0006\u0012\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\t\u0012\u0006\u0010\u000E\u001A\u00020\u0006¢\u0006\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0011R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000E\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013¨\u0006\u001A"}, d2={"Landroidx/compose/runtime/tooling/SourceInformation;", "", "isCall", "", "isInline", "functionName", "", "sourceFile", "parameters", "", "Landroidx/compose/runtime/tooling/ParameterSourceInformation;", "packageHash", "locations", "Landroidx/compose/runtime/tooling/LocationSourceInformation;", "rawData", "<init>", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "()Z", "getFunctionName", "()Ljava/lang/String;", "getSourceFile", "getParameters", "()Ljava/util/List;", "getPackageHash", "getLocations", "getRawData", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SourceInformation {
    public static final int $stable = 8;
    private final String functionName;
    private final boolean isCall;
    private final boolean isInline;
    private final List locations;
    private final String packageHash;
    private final List parameters;
    private final String rawData;
    private final String sourceFile;

    static {
    }

    public SourceInformation(boolean arg1, boolean arg2, String arg3, String arg4, List arg5, String arg6, List arg7, String arg8) {
        super();
        this.isCall = arg1;
        this.isInline = arg2;
        this.functionName = arg3;
        this.sourceFile = arg4;
        this.parameters = arg5;
        this.packageHash = arg6;
        this.locations = arg7;
        this.rawData = arg8;
    }

    public final String getFunctionName() {
        return this.functionName;
    }

    public final List getLocations() {
        return this.locations;
    }

    public final String getPackageHash() {
        return this.packageHash;
    }

    public final List getParameters() {
        return this.parameters;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final boolean isCall() {
        return this.isCall;
    }

    public final boolean isInline() {
        return this.isInline;
    }
}

