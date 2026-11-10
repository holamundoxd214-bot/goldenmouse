package androidx.window.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B/\u0012\u0006\u0010\u0004\u001A\u00028\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ/\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001A\u00020\u00062\u0017\u0010\u001D\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001F0\u001E¢\u0006\u0002\b H\u0016J\u000F\u0010!\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000FR\u0013\u0010\u0004\u001A\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001A\u00020\u0019¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001B¨\u0006\""}, d2={"Landroidx/window/core/FailedSpecification;", "T", "", "Landroidx/window/core/SpecificationComputer;", "value", "tag", "", "message", "logger", "Landroidx/window/core/Logger;", "verificationMode", "Landroidx/window/core/VerificationMode;", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Landroidx/window/core/Logger;Landroidx/window/core/VerificationMode;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTag", "()Ljava/lang/String;", "getMessage", "getLogger", "()Landroidx/window/core/Logger;", "getVerificationMode", "()Landroidx/window/core/VerificationMode;", "exception", "Landroidx/window/core/WindowStrictModeException;", "getException", "()Landroidx/window/core/WindowStrictModeException;", "require", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "compute", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) final class FailedSpecification extends SpecificationComputer {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[VerificationMode.values().length];
            try {
                v0[VerificationMode.STRICT.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[VerificationMode.LOG.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[VerificationMode.QUIET.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                    label_15:
                        WhenMappings.$EnumSwitchMapping$0 = v0;
                        return;
                    }
                }
            }
        }
    }

    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final Object value;
    private final VerificationMode verificationMode;

    public FailedSpecification(Object arg2, String arg3, String arg4, Logger arg5, VerificationMode arg6) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        Intrinsics.checkNotNullParameter(arg3, "tag");
        Intrinsics.checkNotNullParameter(arg4, "message");
        Intrinsics.checkNotNullParameter(arg5, "logger");
        Intrinsics.checkNotNullParameter(arg6, "verificationMode");
        super();
        this.value = arg2;
        this.tag = arg3;
        this.message = arg4;
        this.logger = arg5;
        this.verificationMode = arg6;
        WindowStrictModeException v3 = new WindowStrictModeException(this.createMessage(arg2, arg4));
        StackTraceElement[] v2 = v3.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(v2, "getStackTrace(...)");
        v3.setStackTrace(ArraysKt.drop(((Object[])v2), 2).toArray(new StackTraceElement[0]));
        this.exception = v3;
    }

    public Object compute() {
        int v0 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if(v0 != 1) {
            Object v2 = null;
            if(v0 != 2) {
                if(v0 == 3) {
                    return v2;
                }

                throw new NoWhenBranchMatchedException();
            }

            this.logger.debug(this.tag, this.createMessage(this.value, this.message));
            return v2;
        }

        throw this.exception;
    }

    public final WindowStrictModeException getException() {
        return this.exception;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getMessage() {
        return this.message;
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

    public SpecificationComputer require(String arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "message");
        Intrinsics.checkNotNullParameter(arg3, "condition");
        return this;
    }
}

