package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchConnectStep;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "SHIZUKU_CHECK", "USER_SERVICE_ARGS", "BIND_USER_SERVICE", "WAIT_SERVICE", "ATTEST_TRANSACT", "ATTEST_REPLY", "ATTEST_GENERATION", "LINK_DEATH", "READY", "CALLBACK_PEER", "CALLBACK_INTERFACE", "CALLBACK_CHALLENGE", "CALLBACK_GENERATION", "CALLBACK_REPLY", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchConnectStep {
    public static final enum StretchConnectStep ATTEST_GENERATION;
    public static final enum StretchConnectStep ATTEST_REPLY;
    public static final enum StretchConnectStep ATTEST_TRANSACT;
    public static final enum StretchConnectStep BIND_USER_SERVICE;
    public static final enum StretchConnectStep CALLBACK_CHALLENGE;
    public static final enum StretchConnectStep CALLBACK_GENERATION;
    public static final enum StretchConnectStep CALLBACK_INTERFACE;
    public static final enum StretchConnectStep CALLBACK_PEER;
    public static final enum StretchConnectStep CALLBACK_REPLY;
    public static final enum StretchConnectStep LINK_DEATH;
    public static final enum StretchConnectStep NOT_STARTED;
    public static final enum StretchConnectStep READY;
    public static final enum StretchConnectStep SHIZUKU_CHECK;
    public static final enum StretchConnectStep USER_SERVICE_ARGS;
    public static final enum StretchConnectStep WAIT_SERVICE;

    private static final StretchConnectStep[] $values() {
        return new StretchConnectStep[]{StretchConnectStep.NOT_STARTED, StretchConnectStep.SHIZUKU_CHECK, StretchConnectStep.USER_SERVICE_ARGS, StretchConnectStep.BIND_USER_SERVICE, StretchConnectStep.WAIT_SERVICE, StretchConnectStep.ATTEST_TRANSACT, StretchConnectStep.ATTEST_REPLY, StretchConnectStep.ATTEST_GENERATION, StretchConnectStep.LINK_DEATH, StretchConnectStep.READY, StretchConnectStep.CALLBACK_PEER, StretchConnectStep.CALLBACK_INTERFACE, StretchConnectStep.CALLBACK_CHALLENGE, StretchConnectStep.CALLBACK_GENERATION, StretchConnectStep.CALLBACK_REPLY};
    }

    static {
        StretchConnectStep.NOT_STARTED = new StretchConnectStep("NOT_STARTED", 0);
        StretchConnectStep.SHIZUKU_CHECK = new StretchConnectStep("SHIZUKU_CHECK", 1);
        StretchConnectStep.USER_SERVICE_ARGS = new StretchConnectStep("USER_SERVICE_ARGS", 2);
        StretchConnectStep.BIND_USER_SERVICE = new StretchConnectStep("BIND_USER_SERVICE", 3);
        StretchConnectStep.WAIT_SERVICE = new StretchConnectStep("WAIT_SERVICE", 4);
        StretchConnectStep.ATTEST_TRANSACT = new StretchConnectStep("ATTEST_TRANSACT", 5);
        StretchConnectStep.ATTEST_REPLY = new StretchConnectStep("ATTEST_REPLY", 6);
        StretchConnectStep.ATTEST_GENERATION = new StretchConnectStep("ATTEST_GENERATION", 7);
        StretchConnectStep.LINK_DEATH = new StretchConnectStep("LINK_DEATH", 8);
        StretchConnectStep.READY = new StretchConnectStep("READY", 9);
        StretchConnectStep.CALLBACK_PEER = new StretchConnectStep("CALLBACK_PEER", 10);
        StretchConnectStep.CALLBACK_INTERFACE = new StretchConnectStep("CALLBACK_INTERFACE", 11);
        StretchConnectStep.CALLBACK_CHALLENGE = new StretchConnectStep("CALLBACK_CHALLENGE", 12);
        StretchConnectStep.CALLBACK_GENERATION = new StretchConnectStep("CALLBACK_GENERATION", 13);
        StretchConnectStep.CALLBACK_REPLY = new StretchConnectStep("CALLBACK_REPLY", 14);
        StretchConnectStep[] v0 = StretchConnectStep.$values();
        StretchConnectStep.$VALUES = v0;
        StretchConnectStep.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchConnectStep(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchConnectStep.$ENTRIES;
    }

    public static StretchConnectStep valueOf(String arg1) {
        return Enum.valueOf(StretchConnectStep.class, arg1);
    }

    public static StretchConnectStep[] values() {
        return StretchConnectStep.$VALUES.clone();
    }
}

