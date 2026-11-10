package com.TryJeanPc.goldenmouse.injector;

import android.os.Process;
import android.os.SystemClock;
import com.TryJeanPc.goldenmouse.bridge.InputManagerBridge;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0004\u001A\u00020\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\bH\u0002R\u000E\u0010\r\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Lcom/TryJeanPc/goldenmouse/injector/KadbTouchServiceMain;", "", "<init>", "()V", "main", "", "args", "", "", "([Ljava/lang/String;)V", "parseCommand", "Lcom/TryJeanPc/goldenmouse/injector/TouchCommand;", "value", "RESPONSE_READY", "RESPONSE_UNAVAILABLE", "RESPONSE_OK", "RESPONSE_ERROR", "SEPARATOR", "", "COMMAND_PARTS", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class KadbTouchServiceMain {
    public static final int $stable = 0;
    private static final int COMMAND_PARTS = 5;
    public static final KadbTouchServiceMain INSTANCE = null;
    public static final String RESPONSE_ERROR = "0";
    public static final String RESPONSE_OK = "1";
    public static final String RESPONSE_READY = "GOLDEN_TOUCH_READY";
    public static final String RESPONSE_UNAVAILABLE = "GOLDEN_TOUCH_UNAVAILABLE";
    public static final char SEPARATOR = '|';

    static {
        KadbTouchServiceMain.INSTANCE = new KadbTouchServiceMain();
    }

    private KadbTouchServiceMain() {
        super();
    }

    @JvmStatic public static final void main(String[] arg14) {
        Throwable v14_4;
        String v0_3;
        BufferedReader v2_1;
        InputStreamReader v2;
        Intrinsics.checkNotNullParameter(arg14, "args");
        InputManagerBridge v14 = new InputManagerBridge();
        if(!v14.estaDisponible()) {
            System.out.println("GOLDEN_TOUCH_UNAVAILABLE");
            return;
        }

        TouchEventProcessor v1 = new TouchEventProcessor(new KadbTouchServiceMain$main$processor$1(v14));
        System.out.println("GOLDEN_TOUCH_READY uid=" + Process.myUid());
        try {
            InputStream v14_1 = System.in;
            Intrinsics.checkNotNullExpressionValue(v14_1, "in");
            v2 = new InputStreamReader(v14_1, Charsets.UTF_8);
            int v0_1 = 0x2000;
            if((v2 instanceof BufferedReader)) {
            }
            else {
                v2_1 = new BufferedReader(((Reader)v2), v0_1);
            }

            if((v2 instanceof BufferedReader)) {
            }
            else {
                v2_1 = new BufferedReader(((Reader)v2), v0_1);
            }
        }
        catch(Throwable v0) {
            goto label_84;
        }

        InputStreamReader v14_2 = v2;
        try {
            Iterator v14_3 = TextStreamsKt.lineSequence(((BufferedReader)v14_2)).iterator();
            while(v14_3.hasNext()) {
                TouchCommand v4 = KadbTouchServiceMain.INSTANCE.parseCommand(v14_3.next());
                if(v4 != null) {
                    TouchCommand v0_2 = TouchCommand.copy$default(v4, null, 0f, 0f, 0, SystemClock.uptimeMillis(), null, 0x2F, null);
                    if(v0_2 == null) {
                        goto label_65;
                    }
                    else if(v1.execute(v0_2)) {
                        v0_3 = "1";
                    }
                    else {
                        goto label_65;
                    }
                }
                else {
                label_65:
                    v0_3 = "0";
                }

                System.out.println(v0_3);
            }

            v14_4 = null;
        }
        catch(Throwable v0) {
            goto label_76;
        }

        try {
            CloseableKt.closeFinally(((Closeable)v2), v14_4);
        }
        catch(Throwable v0) {
            goto label_84;
        }

        v1.cancelAll(SystemClock.uptimeMillis());
        return;
    label_76:
        v14_4 = v0;
        try {
            throw v14_4;
        }
        catch(Throwable v0) {
            try {
                CloseableKt.closeFinally(((Closeable)v2), v14_4);
                throw v0;
            }
            catch(Throwable v0) {
            label_84:
                v1.cancelAll(SystemClock.uptimeMillis());
                throw v0;
            }
        }
    }

    private final TouchCommand parseCommand(String arg15) {
        List v0 = StringsKt.split$default(arg15, new char[]{'|'}, false, 0, 6, null);
        TouchCommand v3 = null;
        if(v0.size() != 5) {
            return v3;
        }

        Integer v15 = StringsKt.toIntOrNull(v0.get(0));
        if(v15 != null) {
            Object v5 = ArraysKt.getOrNull(Action.values(), ((Number)v15).intValue());
            if(v5 != null) {
                Float v14 = StringsKt.toFloatOrNull(v0.get(1));
                if(v14 != null) {
                    float v6 = v14.floatValue();
                    v14 = StringsKt.toFloatOrNull(v0.get(2));
                    if(v14 != null) {
                        float v7 = v14.floatValue();
                        Integer v14_1 = StringsKt.toIntOrNull(v0.get(3));
                        if(v14_1 != null) {
                            int v8 = v14_1.intValue();
                            Long v14_2 = StringsKt.toLongOrNull(v0.get(4));
                            if(v14_2 != null) {
                                return new TouchCommand(((Action)v5), v6, v7, v8, v14_2.longValue(), null, 0x20, null);
                            }
                        }
                    }
                }
            }
        }

        return v3;
    }
}

