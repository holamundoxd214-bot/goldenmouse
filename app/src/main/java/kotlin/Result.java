package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u001E*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001E\u001FB\u0013\bA\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001A\u0004\u0018\u00018\u0000H\u0087\u0088\u0004¢\u0006\u0004\b\u0011\u0010\u0007J\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0013H\u0086\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001A\u00020\u0017H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001A\u001A\u00020\u000B2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0005HÖ\u0083\u0004J\n\u0010\u001C\u001A\u00020\u001DHÖ\u0081\u0004R\u0019\u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u0015\u0010\n\u001A\u00020\u000B8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0015\u0010\u000E\u001A\u00020\u000B8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u000F\u0010\r\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0005¨\u0006 "}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue$annotations", "()V", "isSuccess", "", "isSuccess-impl", "(Ljava/lang/Object;)Z", "isFailure", "isFailure-impl", "getOrNull", "getOrNull-impl", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "equals", "other", "hashCode", "", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class Result implements Serializable {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001A\u0002H\u0006H\u0087\u0088\u0004¢\u0006\u0002\u0010\bJ#\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\n\u001A\u00020\u000BH\u0087\u0088\u0004¢\u0006\u0002\u0010\f¨\u0006\r"}, d2={"Lkotlin/Result$Companion;", "", "<init>", "()V", "success", "Lkotlin/Result;", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "failure", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final Object failure(Throwable arg1) {
            Intrinsics.checkNotNullParameter(arg1, "exception");
            return Result.constructor-impl(ResultKt.createFailure(arg1));
        }

        private final Object success(Object arg1) {
            return Result.constructor-impl(arg1);
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001A\u00020\b2\b\u0010\t\u001A\u0004\u0018\u00010\nH\u0096\u0082\u0004J\n\u0010\u000B\u001A\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001A\u00020\u000EH\u0096\u0080\u0004R\u0011\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "<init>", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable arg2) {
            Intrinsics.checkNotNullParameter(arg2, "exception");
            super();
            this.exception = arg2;
        }

        public boolean equals(Object arg2) {
            if(((arg2 instanceof Failure)) && (Intrinsics.areEqual(this.exception, ((Failure)arg2).exception))) {
                return 1;
            }

            return 0;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    public static final Companion Companion;
    private final Object value;

    static {
        Result.Companion = new Companion(null);
    }

    private Result(Object arg1) {
        super();
        this.value = arg1;
    }

    public static final Result box-impl(Object arg1) {
        return new Result(arg1);
    }

    public static Object constructor-impl(Object arg0) {
        return arg0;
    }

    public boolean equals(Object arg1) {
        return Result.equals-impl(this.value, arg1);
    }

    public static boolean equals-impl(Object arg2, Object arg3) {
        if(!(arg3 instanceof Result)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((Result)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Object arg0, Object arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final Throwable exceptionOrNull-impl(Object arg1) {
        if((arg1 instanceof Failure)) {
            return ((Failure)arg1).exception;
        }

        return null;
    }

    private static final Object getOrNull-impl(Object arg1) {
        if(Result.isFailure-impl(arg1)) {
            arg1 = null;
        }

        return arg1;
    }

    public static void getValue$annotations() {
    }

    public int hashCode() {
        return Result.hashCode-impl(this.value);
    }

    public static int hashCode-impl(Object arg0) {
        if(arg0 == null) {
            return 0;
        }

        return arg0.hashCode();
    }

    public static final boolean isFailure-impl(Object arg0) {
        return arg0 instanceof Failure;
    }

    public static final boolean isSuccess-impl(Object arg0) {
        return arg0 instanceof Failure ^ 1;
    }

    public String toString() {
        return Result.toString-impl(this.value);
    }

    public static String toString-impl(Object arg2) {
        if((arg2 instanceof Failure)) {
            return ((Failure)arg2).toString();
        }

        return "Success(" + arg2 + ')';
    }

    public final Object unbox-impl() {
        return this.value;
    }
}

