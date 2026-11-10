package com.TryJeanPc.goldenmouse.stretch.agent;

import java.io.InputStream;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u000EB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchViewportDumpReader;", "", "<init>", "()V", "PREFIX", "", "MAX_SCAN_BYTES", "", "MAX_RETAINED_BYTES", "MAX_RECORD_BYTES", "read", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchViewportDumpReader$Result;", "input", "Ljava/io/InputStream;", "Result", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchViewportDumpReader {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchViewportDumpReader$Result;", "", "code", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "text", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;Ljava/lang/String;)V", "getCode", "()Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalReadCode;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Result {
        public static final int $stable;
        private final OriginalReadCode code;
        private final String text;

        static {
        }

        public Result(OriginalReadCode arg1, String arg2, int arg3, DefaultConstructorMarker arg4) {
            if((arg3 & 2) != 0) {
                arg2 = "";
            }

            this(arg1, arg2);
        }

        public Result(OriginalReadCode arg2, String arg3) {
            Intrinsics.checkNotNullParameter(arg2, "code");
            Intrinsics.checkNotNullParameter(arg3, "text");
            super();
            this.code = arg2;
            this.text = arg3;
        }

        public final OriginalReadCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.text;
        }

        public final Result copy(OriginalReadCode arg1, String arg2) {
            Intrinsics.checkNotNullParameter(arg1, "code");
            Intrinsics.checkNotNullParameter(arg2, "text");
            return new Result(arg1, arg2);
        }

        public static Result copy$default(Result arg0, OriginalReadCode arg1, String arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.code;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.text;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Result)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Result)) {
                return 0;
            }

            if(this.code != ((Result)arg5).code) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.text, ((Result)arg5).text)) {
                return 0;
            }

            return 1;
        }

        public final OriginalReadCode getCode() {
            return this.code;
        }

        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.code.hashCode() * 0x1F + this.text.hashCode();
        }

        public String toString() {
            return "Result(code=" + this.code + ", text=" + this.text + ")";
        }
    }

    public static final int $stable = 0;
    public static final StretchViewportDumpReader INSTANCE = null;
    public static final int MAX_RECORD_BYTES = 2065;
    public static final int MAX_RETAINED_BYTES = 0x4000;
    public static final int MAX_SCAN_BYTES = 0x200000;
    private static final String PREFIX = "DisplayViewport{";

    static {
        StretchViewportDumpReader.INSTANCE = new StretchViewportDumpReader();
    }

    private StretchViewportDumpReader() {
        super();
    }

    public final Result read(InputStream arg15) {
        Intrinsics.checkNotNullParameter(arg15, "input");
        StringBuilder v14 = new StringBuilder();
        int v0 = 0x800;
        byte[] v1 = new byte[v0];
        String v3 = null;
        int v4 = 0;
        int v6 = 0;
        StringBuilder v5 = ((StringBuilder)v3);
    label_11:
        if(!Thread.currentThread().isInterrupted()) {
            int v7 = arg15.read(v1, 0, Math.min(v0, 0x200001 - v4));
            int v8 = 2;
            if(v7 >= 0) {
                if(v7 == 0) {
                    return new Result(OriginalReadCode.READ_FAILED, v3, v8, ((DefaultConstructorMarker)v3));
                }

                v4 += v7;
                if(v4 > 0x200000) {
                    return new Result(OriginalReadCode.OUTPUT_LIMIT, v3, v8, ((DefaultConstructorMarker)v3));
                }

                int v9;
                for(v9 = 0; true; ++v9) {
                    if(v9 >= v7) {
                        goto label_11;
                    }

                    int v10 = v1[v9] & 0xFF;
                    int v11 = 1;
                    if(v5 == null) {
                        String v12 = "DisplayViewport{";
                        if(v10 == v12.charAt(v6)) {
                            v11 = v6 + 1;
                        }
                        else if(v10 == 68) {
                        }
                        else {
                            v11 = 0;
                        }

                        if(v11 == 16) {
                            v5 = new StringBuilder(v12);
                            v6 = 0;
                            goto label_87;
                        }

                        v6 = v11;
                    }
                    else {
                        if(0x20 <= v10 && v10 < 0x7F) {
                            if(v10 == 0x7B) {
                            }
                            else {
                                v5.append(((char)v10));
                                if(v5.length() > 2065) {
                                    return new Result(OriginalReadCode.OUTPUT_LIMIT, v3, v8, ((DefaultConstructorMarker)v3));
                                }
                                else if(v10 != 0x7D) {
                                    goto label_87;
                                }
                                else if(v14.length() + v5.length() + 1 > 0x4000) {
                                    return new Result(OriginalReadCode.OUTPUT_LIMIT, v3, v8, ((DefaultConstructorMarker)v3));
                                }
                                else {
                                    v14.append(((CharSequence)v5)).append('\n');
                                    v5 = ((StringBuilder)v3);
                                    goto label_87;
                                }
                            }
                        }

                        break;
                    }

                label_87:
                }

                return new Result(OriginalReadCode.INVALID_DATA, v3, v8, ((DefaultConstructorMarker)v3));
            }

            if(v5 != null) {
                return new Result(OriginalReadCode.INVALID_DATA, v3, v8, ((DefaultConstructorMarker)v3));
            }

            OriginalReadCode v0_1 = OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY;
            String v14_1 = v14.toString();
            Intrinsics.checkNotNullExpressionValue(v14_1, "toString(...)");
            return new Result(v0_1, v14_1);
        }

        throw new InterruptedIOException();
    }
}

