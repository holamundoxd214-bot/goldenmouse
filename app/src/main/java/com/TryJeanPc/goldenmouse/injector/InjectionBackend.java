package com.TryJeanPc.goldenmouse.injector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH&J\u0010\u0010\u0011\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0002\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\u000E\u001A\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/InjectionBackend;", "", "confirmedCancelEpoch", "", "getConfirmedCancelEpoch", "()J", "contactRegistryIdentity", "getContactRegistryIdentity", "()Ljava/lang/Object;", "executeConfirmed", "", "command", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "execute", "supportsAsyncMoves", "getSupportsAsyncMoves", "()Z", "executeMove", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public interface InjectionBackend {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static boolean executeConfirmed(InjectionBackend arg1, TouchCommand arg2) {
            Intrinsics.checkNotNullParameter(arg2, "command");
            return arg1.executeConfirmed(arg2);
        }

        @Deprecated public static boolean executeMove(InjectionBackend arg1, TouchCommand arg2) {
            Intrinsics.checkNotNullParameter(arg2, "command");
            return arg1.executeMove(arg2);
        }

        @Deprecated public static long getConfirmedCancelEpoch(InjectionBackend arg2) {
            return arg2.getConfirmedCancelEpoch();
        }

        @Deprecated public static Object getContactRegistryIdentity(InjectionBackend arg0) {
            return arg0.getContactRegistryIdentity();
        }

        @Deprecated public static boolean getSupportsAsyncMoves(InjectionBackend arg0) {
            return arg0.getSupportsAsyncMoves();
        }
    }

    static boolean access$executeConfirmed$jd(InjectionBackend arg0, TouchCommand arg1) {
        return super.executeConfirmed(arg1);
    }

    static boolean access$executeMove$jd(InjectionBackend arg0, TouchCommand arg1) {
        return super.executeMove(arg1);
    }

    static long access$getConfirmedCancelEpoch$jd(InjectionBackend arg2) {
        return super.getConfirmedCancelEpoch();
    }

    static Object access$getContactRegistryIdentity$jd(InjectionBackend arg0) {
        return super.getContactRegistryIdentity();
    }

    static boolean access$getSupportsAsyncMoves$jd(InjectionBackend arg0) {
        return super.getSupportsAsyncMoves();
    }

    boolean execute(TouchCommand arg1);

    default boolean executeConfirmed(TouchCommand arg3) {
        Intrinsics.checkNotNullParameter(arg3, "command");
        if(arg3.getAction() == Action.ACTION_MOVE && (this.getSupportsAsyncMoves())) {
            return 0;
        }

        return this.execute(arg3);
    }

    default boolean executeMove(TouchCommand arg2) {
        Intrinsics.checkNotNullParameter(arg2, "command");
        return this.execute(arg2);
    }

    default long getConfirmedCancelEpoch() {
        return 0;
    }

    default Object getContactRegistryIdentity() {
        return this;
    }

    default boolean getSupportsAsyncMoves() {
        return 0;
    }
}

