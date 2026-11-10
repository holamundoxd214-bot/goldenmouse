package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001A\u00020\u00072\u0017\u0010\b\u001A\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH&J\u000F\u0010\f\u001A\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\rJ\u0018\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0007H\u0004¨\u0006\u0011"}, d2={"Landroidx/window/core/SpecificationComputer;", "T", "", "<init>", "()V", "require", "message", "", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "compute", "()Ljava/lang/Object;", "createMessage", "value", "Companion", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class SpecificationComputer {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0001*\u0002H\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\r¨\u0006\u000E"}, d2={"Landroidx/window/core/SpecificationComputer$Companion;", "", "<init>", "()V", "startSpecification", "Landroidx/window/core/SpecificationComputer;", "T", "tag", "", "verificationMode", "Landroidx/window/core/VerificationMode;", "logger", "Landroidx/window/core/Logger;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/VerificationMode;Landroidx/window/core/Logger;)Landroidx/window/core/SpecificationComputer;", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final SpecificationComputer startSpecification(Object arg1, String arg2, VerificationMode arg3, Logger arg4) {
            Intrinsics.checkNotNullParameter(arg1, "<this>");
            Intrinsics.checkNotNullParameter(arg2, "tag");
            Intrinsics.checkNotNullParameter(arg3, "verificationMode");
            Intrinsics.checkNotNullParameter(arg4, "logger");
            return new ValidSpecification(arg1, arg2, arg3, arg4);
        }

        public static SpecificationComputer startSpecification$default(Companion arg0, Object arg1, String arg2, VerificationMode arg3, Logger arg4, int arg5, Object arg6) {
            AndroidLogger v4;
            if((arg5 & 2) != 0) {
                arg3 = BuildConfig.INSTANCE.getVerificationMode();
            }

            if((arg5 & 4) != 0) {
                v4 = AndroidLogger.INSTANCE;
            }

            return arg0.startSpecification(arg1, arg2, arg3, ((Logger)v4));
        }
    }

    public static final Companion Companion;

    static {
        SpecificationComputer.Companion = new Companion(null);
    }

    public SpecificationComputer() {
        super();
    }

    public abstract Object compute();

    protected final String createMessage(Object arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "value");
        Intrinsics.checkNotNullParameter(arg2, "message");
        return arg2 + " value: " + arg1;
    }

    public abstract SpecificationComputer require(String arg1, Function1 arg2);
}

