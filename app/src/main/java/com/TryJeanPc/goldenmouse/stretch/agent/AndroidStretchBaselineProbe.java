package com.TryJeanPc.goldenmouse.stretch.agent;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build$VERSION;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display$Mode;
import android.view.Display;
import com.TryJeanPc.goldenmouse.stretch.StretchDisplayIdentity;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.backend.StretchBackendType;
import com.TryJeanPc.goldenmouse.stretch.physical.StretchProjectionApply;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum$Companion;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchOriginalDisplayState;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchRecoverySnapshot;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0017\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0002¢\u0006\u0002\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\u00102\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001A\u00020\u00132\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/AndroidStretchBaselineProbe;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "capture", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchAgentBaseline;", "sessionId", "", "physicalId", "", "display", "Landroid/view/Display;", "(Landroid/view/Display;)Ljava/lang/Long;", "projectionProbe", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;", "(Ljava/lang/Long;)Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProjectionProbe;", "inspect", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchProbeEvidence;", "block", "Lkotlin/Function0;", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class AndroidStretchBaselineProbe {
    public static final int $stable = 8;
    private final Context context;

    static {
    }

    public AndroidStretchBaselineProbe(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        super();
        this.context = arg2;
    }

    public final StretchAgentBaseline capture(String arg24) {
        RecoveryDatum v0_3;
        RecoveryDatum v2;
        StretchSize v12;
        AndroidStretchBaselineProbe v1 = this;
        String v4 = arg24;
        Intrinsics.checkNotNullParameter(v4, "sessionId");
        Object v0 = v1.context.getSystemService(DisplayManager.class);
        if(v0 != null) {
            Display v3 = ((DisplayManager)v0).getDisplay(0);
            if(v3 != null) {
                String v5 = "Failed requirement.";
                if((v3.isValid()) && v3.getDisplayId() == 0) {
                    int v6 = v3.getRotation();
                    Long v11 = v1.physicalId(v3);
                    Point v7 = new Point();
                    v3.getRealSize(v7);
                    try {
                        DisplayMetrics v0_2 = new DisplayMetrics();
                        v3.getRealMetrics(v0_2);
                        v0 = Result.constructor-impl(Integer.valueOf(v0_2.densityDpi));
                    }
                    catch(Throwable v0_1) {
                        v0 = Result.constructor-impl(ResultKt.createFailure(v0_1));
                    }

                    RecoverySource v9 = null;
                    if(Result.isFailure-impl(v0)) {
                        v0 = v9;
                    }

                    if(v0 != null) {
                        int v10 = v0.intValue();
                        if(1 > v10) {
                            goto label_46;
                        }
                        else if(v10 < 10001) {
                        }
                        else {
                            goto label_46;
                        }
                    }
                    else {
                    label_46:
                        v0 = v9;
                    }

                    if(v7.x > 0 && v7.y > 0 && v6 >= 0 && v6 < 4) {
                        Display$Mode v10_1 = v3.getMode();
                        if(v10_1 != null) {
                            v12 = new StretchSize(v10_1.getPhysicalWidth(), v10_1.getPhysicalHeight());
                            if(v12.getWidth() <= 0) {
                                goto label_65;
                            }
                            else if(v12.getHeight() > 0) {
                            }
                            else {
                                goto label_65;
                            }
                        }
                        else {
                        label_65:
                            v12 = ((StretchSize)v9);
                        }

                        if((v3.isValid()) && v3.getRotation() == v6 && (Intrinsics.areEqual(v1.physicalId(v3), v11))) {
                            String v3_1 = v3.getName();
                            Intrinsics.checkNotNullExpressionValue(v3_1, "getName(...)");
                            RecoveryDatum v14 = AndroidStretchBaselineProbe.capture$public(new StretchDisplayIdentity(0, StringsKt.take(v3_1, 0x80)));
                            if(v11 != null) {
                                v2 = RecoveryDatum.Companion.known("aosp-physical:" + Long.toUnsignedString(v11.longValue()), RecoverySource.INFORMATIVE_BACKEND);
                                if(v2 == null) {
                                    goto label_94;
                                }
                            }
                            else {
                            label_94:
                                v2 = Companion.unknown$default(RecoveryDatum.Companion, v9, 1, v9);
                            }

                            RecoveryDatum v15 = v2;
                            RecoveryDatum v16 = AndroidStretchBaselineProbe.capture$public(new StretchSize(v7.x, v7.y));
                            RecoveryDatum v17 = Companion.unknown$default(RecoveryDatum.Companion, v9, 1, v9);
                            RecoveryDatum v18 = Companion.unknown$default(RecoveryDatum.Companion, v9, 1, v9);
                            if(v0 != null) {
                                v0_3 = AndroidStretchBaselineProbe.capture$public(Integer.valueOf(((Number)v0).intValue()));
                                if(v0_3 == null) {
                                    goto label_111;
                                }
                            }
                            else {
                            label_111:
                                v0_3 = Companion.unknown$default(RecoveryDatum.Companion, v9, 1, v9);
                            }

                            RecoveryDatum v19 = v0_3;
                            RecoveryDatum v20 = AndroidStretchBaselineProbe.capture$public(Integer.valueOf(v6));
                            if(v12 != null) {
                                v0_3 = AndroidStretchBaselineProbe.capture$public(v12);
                                if(v0_3 == null) {
                                    goto label_119;
                                }
                            }
                            else {
                            label_119:
                                v0_3 = Companion.unknown$default(RecoveryDatum.Companion, v9, 1, v9);
                            }

                            return new StretchAgentBaseline(new StretchRecoverySnapshot(1, v4, Build$VERSION.SDK_INT, StretchBackendType.SHIZUKU, System.currentTimeMillis(), RecoverySource.INFORMATIVE_BACKEND, new StretchOriginalDisplayState(v14, v15, v16, v17, v18, v19, v20, v0_3, RecoveryDatum.Companion.unsupported(RecoverySource.INFORMATIVE_BACKEND))), v1.projectionProbe(v11));
                        }

                        throw new IllegalArgumentException(v5.toString());
                    }

                    throw new IllegalArgumentException(v5.toString());
                }

                throw new IllegalArgumentException(v5.toString());
            }
        }

        throw new IllegalStateException("Default display unavailable");
    }

    private static final RecoveryDatum capture$public(Object arg2) {
        return RecoveryDatum.Companion.known(arg2, RecoverySource.PUBLIC_API);
    }

    private final StretchProbeEvidence inspect(Function0 arg1) {
        StretchProbeEvidence v0_1;
        try {
            if(arg1.invoke().booleanValue()) {
                return StretchProbeEvidence.OBSERVED;
            }

            return StretchProbeEvidence.UNAVAILABLE;
        }
        catch(LinkageError ) {
            v0_1 = StretchProbeEvidence.UNSUPPORTED;
        }
        catch(ReflectiveOperationException ) {
            v0_1 = StretchProbeEvidence.UNSUPPORTED;
        }
        catch(SecurityException ) {
            v0_1 = StretchProbeEvidence.PERMISSION_DENIED;
        }
        catch(InvocationTargetException v0) {
            if((v0.getTargetException() instanceof SecurityException)) {
                return StretchProbeEvidence.PERMISSION_DENIED;
            }

            v0_1 = StretchProbeEvidence.READ_FAILED;
        }
        catch(StretchCompatibilityFailure ) {
            v0_1 = StretchProbeEvidence.UNAVAILABLE;
        }

        return v0_1;
    }

    private final Long physicalId(Display arg4) {
        return StretchPhysicalDisplayIdentity.INSTANCE.resolve(Build$VERSION.SDK_INT, new AndroidStretchBaselineProbe$$ExternalSyntheticLambda2(arg4), new AndroidStretchBaselineProbe$$ExternalSyntheticLambda3(arg4));
    }

    static final Long physicalId$lambda$7(Display arg5) {
        Object v5 = Display.class.getMethod("getAddress").invoke(arg5);
        Long v0 = null;
        if(v5 != null) {
            Class v2 = v5.getClass();
            if(v2 != null) {
                Method v2_1 = v2.getMethod("getPhysicalDisplayId");
                if(v2_1 != null) {
                    v5 = v2_1.invoke(v5);
                }
                else {
                    goto label_18;
                }
            }
            else {
                goto label_18;
            }
        }
        else {
        label_18:
            v5 = v0;
        }

        if((v5 instanceof Long)) {
            return ((Long)v5);
        }

        return v0;
    }

    static final String physicalId$lambda$8(Display arg4) {
        Object v4 = Display.class.getMethod("getUniqueId").invoke(arg4);
        if((v4 instanceof String)) {
            return ((String)v4);
        }

        return null;
    }

    private final StretchProjectionProbe projectionProbe(Long arg3) {
        StretchProbeEvidence v3 = arg3 == null ? StretchProbeEvidence.UNAVAILABLE : this.inspect(new AndroidStretchBaselineProbe$$ExternalSyntheticLambda0(arg3));
        StretchProbeEvidence v2 = this.inspect(new AndroidStretchBaselineProbe$$ExternalSyntheticLambda1());
        if(v2 == StretchProbeEvidence.OBSERVED) {
            v2 = StretchProbeEvidence.METHOD_PRESENT;
        }

        return new StretchProjectionProbe(v3, v2, StretchProbeEvidence.UNSUPPORTED);
    }

    static final boolean projectionProbe$lambda$10() {
        Class v0 = Class.forName("android.view.SurfaceControl$Transaction");
        v0.getConstructor();
        Class[] v2 = new Class[4];
        v2[0] = IBinder.class;
        v2[1] = Integer.TYPE;
        Class v3 = Rect.class;
        int v5 = 2;
        v2[v5] = v3;
        int v6 = 3;
        v2[v6] = v3;
        v0.getMethod("setDisplayProjection", v2);
        StretchProjectionApply v2_1 = StretchProjectionApply.INSTANCE;
        Intrinsics.checkNotNull(v0);
        v2_1.method(v0);
        Class.forName("android.view.SurfaceControl").getMethod("getStaticDisplayInfo", Long.TYPE);
        v0 = Class.forName("android.view.IWindowManager");
        String[] v2_2 = new String[v5];
        v2_2[0] = "getInitialDisplaySize";
        v2_2[1] = "getBaseDisplaySize";
        Iterator v2_3 = CollectionsKt.listOf(((Object[])v2_2)).iterator();
        while(v2_3.hasNext()) {
            Object v3_1 = v2_3.next();
            v0.getMethod(((String)v3_1), Integer.TYPE, Point.class);
        }

        v0.getMethod("getBaseDisplayDensity", Integer.TYPE);
        v2 = new Class[v6];
        v2[0] = Integer.TYPE;
        v2[1] = Integer.TYPE;
        v2[v5] = Integer.TYPE;
        v0.getMethod("setForcedDisplaySize", v2);
        v0.getMethod("clearForcedDisplaySize", Integer.TYPE);
        v0.getMethod("setForcedDisplayScalingMode", Integer.TYPE, Integer.TYPE);
        return 1;
    }

    static final boolean projectionProbe$lambda$9(Long arg3) {
        return AndroidStretchDisplayTokens.INSTANCE.resolve(arg3.longValue()).getBinder().isBinderAlive();
    }
}

