package com.TryJeanPc.goldenmouse.stretch.agent;

import android.os.IBinder;
import android.os.ParcelFileDescriptor$AutoCloseInputStream;
import android.os.ParcelFileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tJ\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\tH\u0002J\b\u0010\f\u001A\u00020\tH\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchCompositorReader;", "", "worker", "Ljava/util/concurrent/ExecutorService;", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "capture", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "physicalIdentity", "", "sample", "identity", "dump", "CompositorOutputLimit", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchCompositorReader {
    @Metadata(d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchCompositorReader$CompositorOutputLimit;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "<init>", "()V", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class CompositorOutputLimit extends IllegalStateException {
        public CompositorOutputLimit() {
            super();
        }
    }

    public static final int $stable = 8;
    private final ExecutorService worker;

    static {
    }

    public AndroidStretchCompositorReader(ExecutorService arg2) {
        Intrinsics.checkNotNullParameter(arg2, "worker");
        super();
        this.worker = arg2;
    }

    public final StretchCompositorRead capture(String arg7) {
        if(arg7 != null) {
            if(!StringsKt.startsWith$default(arg7, "aosp-physical:", false, 2, null)) {
            }
            else {
                StretchCompositorRead v0 = this.sample(arg7);
                if(v0.getState() == null) {
                    return v0;
                }
                else {
                    return StretchCompositorParser.INSTANCE.stable(v0, this.sample(arg7));
                }
            }
        }

        return new StretchCompositorRead(CompositorReadCode.DISPLAY_MISMATCH, null, false, 6, null);
    }

    private final String dump() {
        Future v3_1;
        Object v3 = null;
        Object v0 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(v3, "SurfaceFlinger");
        if((v0 instanceof IBinder)) {
        }
        else {
            v0 = v3;
        }

        if(v0 != null) {
            ParcelFileDescriptor[] v2 = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor$AutoCloseInputStream v5 = new ParcelFileDescriptor$AutoCloseInputStream(v2[0]);
            try {
                v3_1 = this.worker.submit(new AndroidStretchCompositorReader$$ExternalSyntheticLambda0(v5));
                ((IBinder)v0).dumpAsync(v2[1].getFileDescriptor(), new String[]{"--comp-displays"});
                v2[1].close();
                v0 = v3_1.get(750, TimeUnit.MILLISECONDS);
                Intrinsics.checkNotNullExpressionValue(v0, "get(...)");
                if(v3_1 == null) {
                    goto label_41;
                }
            }
            catch(Throwable v9) {
                if(v3_1 != null) {
                    v3_1.cancel(true);
                }

                try {
                    v5.close();
                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v0_1) {
                    Result.constructor-impl(ResultKt.createFailure(v0_1));
                }

                try {
                    v2[1].close();
                    Result.constructor-impl(Unit.INSTANCE);
                }
                catch(Throwable v0_1) {
                    Result.constructor-impl(ResultKt.createFailure(v0_1));
                }

                throw v9;
            }

            v3_1.cancel(true);
            try {
            label_41:
                v5.close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v3_2) {
                Result.constructor-impl(ResultKt.createFailure(v3_2));
            }

            try {
                v2[1].close();
                Result.constructor-impl(Unit.INSTANCE);
            }
            catch(Throwable v9) {
                Result.constructor-impl(ResultKt.createFailure(v9));
            }

            return ((String)v0);
        }

        throw new NoSuchMethodException();
    }

    static final String dump$lambda$2(ParcelFileDescriptor$AutoCloseInputStream arg6) {
        String v0_2;
        try {
            ParcelFileDescriptor$AutoCloseInputStream v0_1 = arg6;
            ByteArrayOutputStream v1 = new ByteArrayOutputStream();
            byte[] v2 = new byte[0x800];
            while(true) {
                int v3 = v0_1.read(v2);
                if(v3 < 0) {
                    goto label_21;
                }

                if(v3 == 0) {
                    goto label_18;
                }

                if(v1.size() + v3 > 0x20000) {
                    break;
                }

                v1.write(v2, 0, v3);
            }

            throw new CompositorOutputLimit();
        label_18:
            throw new IOException();
        label_21:
            v0_2 = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(v1.toByteArray())).toString();
        }
        catch(Throwable v0) {
            goto label_35;
        }

        CloseableKt.closeFinally(((Closeable)arg6), null);
        return v0_2;
        try {
        label_35:
            throw v0;
        }
        catch(Throwable v1_1) {
            CloseableKt.closeFinally(((Closeable)arg6), v0);
            throw v1_1;
        }
    }

    private final StretchCompositorRead sample(String arg12) {
        StretchCompositorRead v0_3;
        CompositorReadCode v11_1;
        try {
            long v0_2 = Long.parseUnsignedLong(StringsKt.removePrefix(arg12, "aosp-physical:"));
            Method v2 = Class.forName("android.view.SurfaceControl").getMethod("getStaticDisplayInfo", Long.TYPE);
            int v3 = AndroidStretchCompositorReader.sample$orientation(v2, v0_2);
            String v11 = this.dump();
            if(AndroidStretchCompositorReader.sample$orientation(v2, v0_2) != v3) {
                return new StretchCompositorRead(CompositorReadCode.UNSTABLE, null, false, 6, null);
            }

            return StretchCompositorParser.INSTANCE.parse(v11, arg12, Integer.valueOf(v3));
        }
        catch(Exception ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.READ_FAILED, null, false, 6, null);
        }
        catch(ExecutionException v0) {
            v11_1 = (v0.getCause() instanceof CompositorOutputLimit) ? CompositorReadCode.OUTPUT_LIMIT : CompositorReadCode.READ_FAILED;
            v0_3 = new StretchCompositorRead(v11_1, null, false, 6, null);
        }
        catch(CompositorOutputLimit ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.OUTPUT_LIMIT, null, false, 6, null);
        }
        catch(TimeoutException ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.TIMED_OUT, null, false, 6, null);
        }
        catch(LinkageError ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.UNSUPPORTED, null, false, 6, null);
        }
        catch(ReflectiveOperationException ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.UNSUPPORTED, null, false, 6, null);
        }
        catch(SecurityException ) {
            v0_3 = new StretchCompositorRead(CompositorReadCode.PERMISSION_DENIED, null, false, 6, null);
        }
        catch(InvocationTargetException v0_1) {
            v11_1 = (v0_1.getTargetException() instanceof SecurityException) ? CompositorReadCode.PERMISSION_DENIED : CompositorReadCode.READ_FAILED;
            v0_3 = new StretchCompositorRead(v11_1, null, false, 6, null);
        }

        return v0_3;
    }

    private static final int sample$orientation(Method arg0, long arg1) {
        Object v0 = arg0.invoke(null, Long.valueOf(arg1));
        if(v0 != null) {
            int v0_1 = v0.getClass().getField("installOrientation").getInt(v0);
            if(v0_1 >= 0 && v0_1 < 4) {
                return v0_1;
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        throw new IllegalArgumentException("Required value was null.".toString());
    }
}

