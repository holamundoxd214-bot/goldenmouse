package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003 !\"B\u0013\b\u0001\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0010\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0011\u0010\u0005J\r\u0010\u0012\u001A\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0005J\u000F\u0010\u0014\u001A\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u0013\u0010\u001C\u001A\u00020\t2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001R\u0018\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\f\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u000E\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u000B\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002¨\u0006#"}, d2={"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getHolder$annotations", "()V", "isSuccess", "", "isSuccess-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "isClosed", "isClosed-impl", "getOrNull", "getOrNull-impl", "getOrThrow", "getOrThrow-impl", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "equals", "other", "hashCode", "", "Failed", "Closed", "Companion", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) @JvmInline public final class ChannelResult {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001A\u00020\u000BH\u0016J\b\u0010\f\u001A\u00020\rH\u0016R\u0012\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable arg1) {
            super();
            this.cause = arg1;
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof Closed)) && (Intrinsics.areEqual(this.cause, ((Closed)arg2).cause))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            Throwable v0 = this.cause;
            if(v0 != null) {
                return v0.hashCode();
            }

            return 0;
        }

        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001A\u0002H\bH\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u001B\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\bH\u0007¢\u0006\u0004\b\r\u0010\u000EJ%\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0001\u0010\b2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "<init>", "()V", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "success", "Lkotlinx/coroutines/channels/ChannelResult;", "E", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "closed", "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Object closed-JP2dKIU(Throwable arg1) {
            return ChannelResult.constructor-impl(new Closed(arg1));
        }

        public final Object failure-PtdJZtk() {
            return ChannelResult.constructor-impl(ChannelResult.failed);
        }

        public final Object success-JP2dKIU(Object arg1) {
            return ChannelResult.constructor-impl(arg1);
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001A\u00020\u0005H\u0016¨\u0006\u0006"}, d2={"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "<init>", "()V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={2, 1, 0}, xi=0x30) public class Failed {
        public Failed() {
            super();
        }

        public String toString() {
            return "Failed";
        }
    }

    public static final Companion Companion;
    private static final Failed failed;
    private final Object holder;

    static {
        ChannelResult.Companion = new Companion(null);
        ChannelResult.failed = new Failed();
    }

    private ChannelResult(Object arg1) {
        super();
        this.holder = arg1;
    }

    public static final Failed access$getFailed$cp() {
        return ChannelResult.failed;
    }

    public static final ChannelResult box-impl(Object arg1) {
        return new ChannelResult(arg1);
    }

    public static Object constructor-impl(Object arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return ChannelResult.equals-impl(this.holder, arg1);
    }

    public static boolean equals-impl(Object arg2, Object arg3) {
        if(!(arg3 instanceof ChannelResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((ChannelResult)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final Throwable exceptionOrNull-impl(Object arg2) {
        Throwable v1 = null;
        if((arg2 instanceof Closed)) {
        }
        else {
            arg2 = v1;
        }

        if(arg2 != null) {
            return ((Closed)arg2).cause;
        }

        return v1;
    }

    public static void getHolder$annotations() {
    }

    public static final Object getOrNull-impl(Object arg1) {
        if(!(arg1 instanceof Failed)) {
            return arg1;
        }

        return null;
    }

    public static final Object getOrThrow-impl(Object arg1) {
        if(!(arg1 instanceof Failed)) {
            return arg1;
        }

        if((arg1 instanceof Closed)) {
            if(((Closed)arg1).cause != null) {
                throw ((Closed)arg1).cause;
            }

            throw new IllegalStateException("Trying to call \'getOrThrow\' on a channel closed without a cause".toString());
        }

        throw new IllegalStateException("Trying to call \'getOrThrow\' on a failed result of a non-closed channel".toString());
    }

    public int hashCode() {
        return ChannelResult.hashCode-impl(this.holder);
    }

    public static int hashCode-impl(Object arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public static final boolean isClosed-impl(Object arg0) {
        return arg0 instanceof Closed;
    }

    public static final boolean isFailure-impl(Object arg0) {
        return arg0 instanceof Failed;
    }

    public static final boolean isSuccess-impl(Object arg0) {
        return arg0 instanceof Failed ^ 1;
    }

    public String toString() {
        return ChannelResult.toString-impl(this.holder);
    }

    public static String toString-impl(Object arg2) {
        if((arg2 instanceof Closed)) {
            return ((Closed)arg2).toString();
        }

        return "Value(" + arg2 + ')';
    }

    public final Object unbox-impl() {
        return this.holder;
    }
}

