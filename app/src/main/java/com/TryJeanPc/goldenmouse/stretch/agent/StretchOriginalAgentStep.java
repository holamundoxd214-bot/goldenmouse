package com.TryJeanPc.goldenmouse.stretch.agent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001B\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001B¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalAgentStep;", "", "<init>", "(Ljava/lang/String;I)V", "REQUEST_ACCEPTED", "BASELINE_VALIDATION", "READER_CREATE", "DISPLAY_PIPE", "DISPLAY_SERVICE", "DISPLAY_READER_SUBMIT", "DISPLAY_DUMP_ASYNC", "DISPLAY_WRITE_CLOSE", "DISPLAY_READ_WAIT", "DISPLAY_CLEANUP", "PARSE_VIEWPORT", "WINDOW_PIPE", "WINDOW_SERVICE", "WINDOW_READER_SUBMIT", "WINDOW_DUMP_ASYNC", "WINDOW_WRITE_CLOSE", "WINDOW_READ_WAIT", "WINDOW_CLEANUP", "PARSE_OVERRIDE", "READ_SCALING", "RECHECK_BASELINE", "BUILD_EVIDENCE", "SESSION_RECHECK", "REPLY_ENCODE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum StretchOriginalAgentStep {
    public static final enum StretchOriginalAgentStep BASELINE_VALIDATION;
    public static final enum StretchOriginalAgentStep BUILD_EVIDENCE;
    public static final enum StretchOriginalAgentStep DISPLAY_CLEANUP;
    public static final enum StretchOriginalAgentStep DISPLAY_DUMP_ASYNC;
    public static final enum StretchOriginalAgentStep DISPLAY_PIPE;
    public static final enum StretchOriginalAgentStep DISPLAY_READER_SUBMIT;
    public static final enum StretchOriginalAgentStep DISPLAY_READ_WAIT;
    public static final enum StretchOriginalAgentStep DISPLAY_SERVICE;
    public static final enum StretchOriginalAgentStep DISPLAY_WRITE_CLOSE;
    public static final enum StretchOriginalAgentStep PARSE_OVERRIDE;
    public static final enum StretchOriginalAgentStep PARSE_VIEWPORT;
    public static final enum StretchOriginalAgentStep READER_CREATE;
    public static final enum StretchOriginalAgentStep READ_SCALING;
    public static final enum StretchOriginalAgentStep RECHECK_BASELINE;
    public static final enum StretchOriginalAgentStep REPLY_ENCODE;
    public static final enum StretchOriginalAgentStep REQUEST_ACCEPTED;
    public static final enum StretchOriginalAgentStep SESSION_RECHECK;
    public static final enum StretchOriginalAgentStep WINDOW_CLEANUP;
    public static final enum StretchOriginalAgentStep WINDOW_DUMP_ASYNC;
    public static final enum StretchOriginalAgentStep WINDOW_PIPE;
    public static final enum StretchOriginalAgentStep WINDOW_READER_SUBMIT;
    public static final enum StretchOriginalAgentStep WINDOW_READ_WAIT;
    public static final enum StretchOriginalAgentStep WINDOW_SERVICE;
    public static final enum StretchOriginalAgentStep WINDOW_WRITE_CLOSE;

    private static final StretchOriginalAgentStep[] $values() {
        return new StretchOriginalAgentStep[]{StretchOriginalAgentStep.REQUEST_ACCEPTED, StretchOriginalAgentStep.BASELINE_VALIDATION, StretchOriginalAgentStep.READER_CREATE, StretchOriginalAgentStep.DISPLAY_PIPE, StretchOriginalAgentStep.DISPLAY_SERVICE, StretchOriginalAgentStep.DISPLAY_READER_SUBMIT, StretchOriginalAgentStep.DISPLAY_DUMP_ASYNC, StretchOriginalAgentStep.DISPLAY_WRITE_CLOSE, StretchOriginalAgentStep.DISPLAY_READ_WAIT, StretchOriginalAgentStep.DISPLAY_CLEANUP, StretchOriginalAgentStep.PARSE_VIEWPORT, StretchOriginalAgentStep.WINDOW_PIPE, StretchOriginalAgentStep.WINDOW_SERVICE, StretchOriginalAgentStep.WINDOW_READER_SUBMIT, StretchOriginalAgentStep.WINDOW_DUMP_ASYNC, StretchOriginalAgentStep.WINDOW_WRITE_CLOSE, StretchOriginalAgentStep.WINDOW_READ_WAIT, StretchOriginalAgentStep.WINDOW_CLEANUP, StretchOriginalAgentStep.PARSE_OVERRIDE, StretchOriginalAgentStep.READ_SCALING, StretchOriginalAgentStep.RECHECK_BASELINE, StretchOriginalAgentStep.BUILD_EVIDENCE, StretchOriginalAgentStep.SESSION_RECHECK, StretchOriginalAgentStep.REPLY_ENCODE};
    }

    static {
        StretchOriginalAgentStep.REQUEST_ACCEPTED = new StretchOriginalAgentStep("REQUEST_ACCEPTED", 0);
        StretchOriginalAgentStep.BASELINE_VALIDATION = new StretchOriginalAgentStep("BASELINE_VALIDATION", 1);
        StretchOriginalAgentStep.READER_CREATE = new StretchOriginalAgentStep("READER_CREATE", 2);
        StretchOriginalAgentStep.DISPLAY_PIPE = new StretchOriginalAgentStep("DISPLAY_PIPE", 3);
        StretchOriginalAgentStep.DISPLAY_SERVICE = new StretchOriginalAgentStep("DISPLAY_SERVICE", 4);
        StretchOriginalAgentStep.DISPLAY_READER_SUBMIT = new StretchOriginalAgentStep("DISPLAY_READER_SUBMIT", 5);
        StretchOriginalAgentStep.DISPLAY_DUMP_ASYNC = new StretchOriginalAgentStep("DISPLAY_DUMP_ASYNC", 6);
        StretchOriginalAgentStep.DISPLAY_WRITE_CLOSE = new StretchOriginalAgentStep("DISPLAY_WRITE_CLOSE", 7);
        StretchOriginalAgentStep.DISPLAY_READ_WAIT = new StretchOriginalAgentStep("DISPLAY_READ_WAIT", 8);
        StretchOriginalAgentStep.DISPLAY_CLEANUP = new StretchOriginalAgentStep("DISPLAY_CLEANUP", 9);
        StretchOriginalAgentStep.PARSE_VIEWPORT = new StretchOriginalAgentStep("PARSE_VIEWPORT", 10);
        StretchOriginalAgentStep.WINDOW_PIPE = new StretchOriginalAgentStep("WINDOW_PIPE", 11);
        StretchOriginalAgentStep.WINDOW_SERVICE = new StretchOriginalAgentStep("WINDOW_SERVICE", 12);
        StretchOriginalAgentStep.WINDOW_READER_SUBMIT = new StretchOriginalAgentStep("WINDOW_READER_SUBMIT", 13);
        StretchOriginalAgentStep.WINDOW_DUMP_ASYNC = new StretchOriginalAgentStep("WINDOW_DUMP_ASYNC", 14);
        StretchOriginalAgentStep.WINDOW_WRITE_CLOSE = new StretchOriginalAgentStep("WINDOW_WRITE_CLOSE", 15);
        StretchOriginalAgentStep.WINDOW_READ_WAIT = new StretchOriginalAgentStep("WINDOW_READ_WAIT", 16);
        StretchOriginalAgentStep.WINDOW_CLEANUP = new StretchOriginalAgentStep("WINDOW_CLEANUP", 17);
        StretchOriginalAgentStep.PARSE_OVERRIDE = new StretchOriginalAgentStep("PARSE_OVERRIDE", 18);
        StretchOriginalAgentStep.READ_SCALING = new StretchOriginalAgentStep("READ_SCALING", 19);
        StretchOriginalAgentStep.RECHECK_BASELINE = new StretchOriginalAgentStep("RECHECK_BASELINE", 20);
        StretchOriginalAgentStep.BUILD_EVIDENCE = new StretchOriginalAgentStep("BUILD_EVIDENCE", 21);
        StretchOriginalAgentStep.SESSION_RECHECK = new StretchOriginalAgentStep("SESSION_RECHECK", 22);
        StretchOriginalAgentStep.REPLY_ENCODE = new StretchOriginalAgentStep("REPLY_ENCODE", 23);
        StretchOriginalAgentStep[] v0 = StretchOriginalAgentStep.$values();
        StretchOriginalAgentStep.$VALUES = v0;
        StretchOriginalAgentStep.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
    }

    private StretchOriginalAgentStep(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static EnumEntries getEntries() {
        return StretchOriginalAgentStep.$ENTRIES;
    }

    public static StretchOriginalAgentStep valueOf(String arg1) {
        return Enum.valueOf(StretchOriginalAgentStep.class, arg1);
    }

    public static StretchOriginalAgentStep[] values() {
        return StretchOriginalAgentStep.$VALUES.clone();
    }
}

