package com.TryJeanPc.goldenmouse.stretch.backend;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\n \n*\u0004\u0018\u00010\t0\tH\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/ShizukuQueryTransport;", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryTransport;", "<init>", "()V", "backend", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "getBackend", "()Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendType;", "processMethod", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "status", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchBackendStatus;", "open", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryChannel;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ShizukuQueryTransport implements StretchQueryTransport {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchBackendState.values().length];
            try {
                v0[StretchBackendState.NOT_AUTHORIZED.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchBackendState.DISCONNECTED.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchBackendState.UNSUPPORTED.ordinal()] = 3;
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

    public static final int $stable;
    private final StretchBackendType backend;

    static {
    }

    public ShizukuQueryTransport() {
        super();
        this.backend = StretchBackendType.SHIZUKU;
    }

    public StretchBackendType getBackend() {
        return this.backend;
    }

    public StretchQueryChannel open(StretchQuery arg5) {
        Object v4_2;
        StretchTransportError v5_2;
        Intrinsics.checkNotNullParameter(arg5, "query");
        List v5 = arg5.getArguments$app();
        if(v5 != null) {
            StretchBackendStatus v0 = this.status();
            if(v0.getState() != StretchBackendState.AVAILABLE) {
                int v5_1 = WhenMappings.$EnumSwitchMapping$0[v0.getState().ordinal()];
                if(v5_1 == 1) {
                    v5_2 = StretchTransportError.PERMISSION_DENIED;
                }
                else if(v5_1 == 2) {
                    v5_2 = StretchTransportError.DISCONNECTED;
                }
                else if(v5_1 != 3) {
                    v5_2 = StretchTransportError.TRANSPORT_FAILURE;
                }
                else {
                    v5_2 = StretchTransportError.UNSUPPORTED;
                }

                throw new StretchTransportException(v5_2);
            }

            try {
                Method v4_1 = this.processMethod();
                v4_1.setAccessible(true);
                v4_2 = v4_1.invoke(null, ((Collection)v5).toArray(new String[0]), null, null);
                Intrinsics.checkNotNull(v4_2, "null cannot be cast to non-null type java.lang.Process");
            }
            catch(ReflectiveOperationException ) {
                throw new StretchTransportException(StretchTransportError.UNSUPPORTED);
            }
            catch(InvocationTargetException v4) {
                if(!(v4.getTargetException() instanceof SecurityException)) {
                    v5_2 = !Shizuku.pingBinder() ? StretchTransportError.DISCONNECTED : StretchTransportError.TRANSPORT_FAILURE;
                    throw new StretchTransportException(v5_2);
                }

                throw new SecurityException("Query permission denied");
            }

            return new ProcessQueryChannel(((Process)v4_2));
        }

        throw new UnsupportedOperationException();
    }

    private final Method processMethod() {
        Class v3 = Shizuku.class;
        Class[] v0 = new Class[3];
        Class v1 = String[].class;
        v0[0] = v1;
        v0[1] = v1;
        v0[2] = String.class;
        return v3.getDeclaredMethod("newProcess", v0);
    }

    public StretchBackendStatus status() {
        String v1_2;
        StretchBackendState v6;
        int v1_1;
        Integer v1;
        StretchBackendStatus v3;
        try {
            if(!Shizuku.pingBinder()) {
                StretchBackendStatus v2 = new StretchBackendStatus(this.getBackend(), StretchBackendState.DISCONNECTED, Boolean.valueOf(false), null, null, null, 56, null);
                return v2;
            }

            if(Shizuku.checkSelfPermission() != 0) {
                v3 = new StretchBackendStatus(this.getBackend(), StretchBackendState.NOT_AUTHORIZED, Boolean.valueOf(true), Boolean.valueOf(false), null, null, 0x30, null);
                return v3;
            }

            v1 = Integer.valueOf(Shizuku.getUid());
            if(v1.intValue() >= 0) {
            }
            else {
                goto label_34;
            }
        }
        catch(SecurityException ) {
            goto label_82;
        }
        catch(Exception ) {
            goto label_70;
        }

        goto label_35;
    label_34:
        v1 = null;
    label_35:
        Integer v8 = v1;
        try {
            this.processMethod();
            v1_1 = 1;
            goto label_40;
        }
        catch(Exception ) {
        }
        catch(SecurityException ) {
        }
        catch(ReflectiveOperationException ) {
            v1_1 = 0;
            try {
            label_40:
                StretchBackendType v4 = this.getBackend();
                int v5 = 2000;
                if(v8 == null) {
                    v6 = StretchBackendState.UNKNOWN;
                }
                else {
                    if(v8.intValue() == v5) {
                        if(v1_1 == 0) {
                        }
                        else {
                            v6 = StretchBackendState.AVAILABLE;
                            goto label_53;
                        }
                    }

                    v6 = StretchBackendState.UNSUPPORTED;
                }

            label_53:
                Boolean v7 = Boolean.valueOf(true);
                Boolean v2_1 = Boolean.valueOf(true);
                if(v8 != null && v8.intValue() != v5) {
                    v1_2 = "Non-shell execution is outside this phase";
                }
                else if(v1_1 == 0) {
                    v1_2 = "SDK process entry unavailable; no bypass or service fallback";
                }
                else {
                    v1_2 = "Binder/permission observed; query execution not yet verified";
                }

                v3 = new StretchBackendStatus(v4, v6, v7, v2_1, v8, v1_2);
            }
            catch(Exception ) {
            label_70:
                v3 = new StretchBackendStatus(this.getBackend(), StretchBackendState.UNKNOWN, null, null, null, "SDK observation failed", 28, null);
            }
            catch(SecurityException ) {
            label_82:
                return new StretchBackendStatus(this.getBackend(), StretchBackendState.NOT_AUTHORIZED, null, Boolean.valueOf(false), null, null, 52, null);
            }
        }

        return v3;
    }
}

