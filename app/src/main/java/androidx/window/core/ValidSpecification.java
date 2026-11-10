package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\'\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ/\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001A\u00020\u00062\u0017\u0010\u0018\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001A0\u0019¢\u0006\u0002\b\u001BH\u0016J\r\u0010\u001C\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000ER\u0013\u0010\u0004\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u000F\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u001D"}, d2={"Landroidx/window/core/ValidSpecification;", "T", "", "Landroidx/window/core/SpecificationComputer;", "value", "tag", "", "verificationMode", "Landroidx/window/core/VerificationMode;", "logger", "Landroidx/window/core/Logger;", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/VerificationMode;Landroidx/window/core/Logger;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTag", "()Ljava/lang/String;", "getVerificationMode", "()Landroidx/window/core/VerificationMode;", "getLogger", "()Landroidx/window/core/Logger;", "require", "message", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "compute", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class ValidSpecification extends SpecificationComputer {
    private final Logger logger;
    private final String tag;
    private final Object value;
    private final VerificationMode verificationMode;

    public ValidSpecification(Object arg2, String arg3, VerificationMode arg4, Logger arg5) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        Intrinsics.checkNotNullParameter(arg3, "tag");
        Intrinsics.checkNotNullParameter(arg4, "verificationMode");
        Intrinsics.checkNotNullParameter(arg5, "logger");
        super();
        this.value = arg2;
        this.tag = arg3;
        this.verificationMode = arg4;
        this.logger = arg5;
    }

    public Object compute() {
        return this.value;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getTag() {
        return this.tag;
    }

    public final Object getValue() {
        return this.value;
    }

    public final VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public SpecificationComputer require(String arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "message");
        Intrinsics.checkNotNullParameter(arg8, "condition");
        if(arg8.invoke(this.value).booleanValue()) {
            return this;
        }

        return new FailedSpecification(this.value, this.tag, arg7, this.logger, this.verificationMode);
    }
}

