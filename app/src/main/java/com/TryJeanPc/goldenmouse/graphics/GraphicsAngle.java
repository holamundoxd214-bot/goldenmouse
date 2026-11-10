package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000BJ\u001D\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\tH\u0000¢\u0006\u0002\b\u0012J2\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00172\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000B¨\u0006\u000F"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAngle;", "", "<init>", "()V", "device", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAngleDevice;", "context", "Landroid/content/Context;", "pkg", "", "run", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsResponse;", "providerHasLibraries", "", "app", "Landroid/content/pm/ApplicationInfo;", "abi", "providerHasLibraries$app", "route", "sdk", "", "access", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsAngle {
    public static final int $stable;
    public static final GraphicsAngle INSTANCE;

    static {
        GraphicsAngle.INSTANCE = new GraphicsAngle();
    }

    private GraphicsAngle() {
        super();
    }

    public final GraphicsAngleDevice device(Context arg6, String arg7, Function1 arg8) {
        ApplicationInfo v1_4;
        List v1_2;
        Object v1_1;
        Intrinsics.checkNotNullParameter(arg6, "context");
        Intrinsics.checkNotNullParameter(arg7, "pkg");
        Intrinsics.checkNotNullParameter(arg8, "run");
        if(GraphicsProfileKt.validGraphicsPackage(arg7)) {
            Object v7 = arg8.invoke("dumpsys package " + GoldenGraphicsBackend.Companion.quote$app(arg7));
            Object v2 = null;
            if(((GraphicsResponse)v7).getExit() != 0 || !StringsKt.isBlank(((GraphicsResponse)v7).getError())) {
            label_35:
                v7 = v2;
            }
            else {
                MatchResult v7_1 = Regex.find$default(new Regex("\\bprimaryCpuAbi=([^\\s]+)"), ((GraphicsResponse)v7).getOut(), 0, 2, v2);
                if(v7_1 != null) {
                    List v7_2 = v7_1.getGroupValues();
                    if(v7_2 != null) {
                        v7 = v7_2.get(1);
                    }
                    else {
                        goto label_35;
                    }
                }
                else {
                    goto label_35;
                }
            }

            String v8 = "SUPPORTED_ABIS";
            if(v7 != null) {
                String[] v3 = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(v3, v8);
                if(ArraysKt.contains(((Object[])v3), v7)) {
                }
                else {
                    v7 = v2;
                }

                if(v7 != null) {
                    goto label_50;
                }

                goto label_45;
            }
            else {
            label_45:
                String[] v7_3 = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(v7_3, v8);
                v7 = ArraysKt.firstOrNull(((Object[])v7_3));
                if(v7 != null) {
                    goto label_50;
                }

                arg7 = "";
            }

        label_50:
            PackageManager v6 = arg6.getPackageManager();
            boolean v8_1 = v6.hasSystemFeature("android.hardware.vulkan.version", 0x401000);
            try {
                v1_1 = Result.constructor-impl(v6.queryIntentActivities(new Intent("android.app.action.ANGLE_FOR_ANDROID"), 0));
            }
            catch(Throwable v1) {
                v1_1 = Result.constructor-impl(ResultKt.createFailure(v1));
            }

            List v3_1 = CollectionsKt.emptyList();
            if(Result.isFailure-impl(v1_1)) {
                v1_2 = v3_1;
            }

            v1_1 = CollectionsKt.singleOrNull(v1_2);
            if(v1_1 != null) {
                ActivityInfo v1_3 = ((ResolveInfo)v1_1).activityInfo;
                if(v1_3 != null) {
                    v1_4 = v1_3.applicationInfo;
                }
                else {
                    goto label_76;
                }
            }
            else {
            label_76:
                v1_4 = ((ApplicationInfo)v2);
            }

            if(v1_4 != null && (1 & v1_4.flags) != 0 && v6.getLaunchIntentForPackage(v1_4.packageName) == null && (this.providerHasLibraries$app(v1_4, ((String)v7)))) {
                String v2_1 = v1_4.packageName;
            }

            return new GraphicsAngleDevice(((String)v7), v8_1, ((String)v2));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean providerHasLibraries$app(ApplicationInfo arg14, String arg15) {
        ZipFile v10;
        Intrinsics.checkNotNullParameter(arg14, "app");
        Intrinsics.checkNotNullParameter(arg15, "abi");
        int v13 = 2;
        String[] v0 = new String[v13];
        boolean v2 = false;
        v0[0] = "libEGL_angle.so";
        v0[1] = "libGLESv2_angle.so";
        List v0_1 = CollectionsKt.listOf(((Object[])v0));
        List v1 = CollectionsKt.listOf(arg14.sourceDir);
        String[] v4 = arg14.splitSourceDirs;
        if(v4 == null) {
            v4 = new String[0];
        }

        v1 = CollectionsKt.plus(((Collection)v1), ((Object[])v4));
        boolean v4_1 = v0_1 instanceof Collection;
        if(!v4_1 || !v0_1.isEmpty()) {
            Iterator v5 = ((Iterable)v0_1).iterator();
            while(true) {
                if(!v5.hasNext()) {
                    return 1;
                }

                Object v6 = v5.next();
                List v7 = v1;
                Throwable v9 = null;
                if(((v7 instanceof Collection)) && (v7.isEmpty())) {
                    break;
                }

                Iterator v7_1 = ((Iterable)v7).iterator();
                do {
                    if(!v7_1.hasNext()) {
                        break;
                    }

                    Object v8 = v7_1.next();
                    try {
                        v10 = new ZipFile(((String)v8));
                    }
                    catch(Throwable v8_1) {
                        goto label_71;
                    }

                    ZipFile v8_2 = v10;
                    try {
                        if(v8_2.getEntry("lib/" + arg15 + "/" + (((String)v6))) == null) {
                            goto label_58;
                        }
                    }
                    catch(Throwable v8_1) {
                        try {
                            throw v8_1;
                        }
                        catch(Throwable v11) {
                            try {
                                CloseableKt.closeFinally(((Closeable)v10), v8_1);
                                throw v11;
                            }
                            catch(Throwable v8_1) {
                                goto label_71;
                            }
                        }
                    }

                    boolean v8_3 = true;
                    goto label_59;
                label_58:
                    v8_3 = false;
                    try {
                    label_59:
                        CloseableKt.closeFinally(((Closeable)v10), v9);
                        v8 = Result.constructor-impl(Boolean.valueOf(v8_3));
                    }
                    catch(Throwable v8_1) {
                    label_71:
                        v8 = Result.constructor-impl(ResultKt.createFailure(v8_1));
                    }

                    Boolean v10_1 = Boolean.valueOf(false);
                    if(Result.isFailure-impl(v8)) {
                        Boolean v8_4 = v10_1;
                    }
                }
                while(!v8_4.booleanValue());
            }

            String v14 = arg14.nativeLibraryDir;
            if(v14 == null) {
                return 0;
            }

            String[] v1_1 = new String[v13];
            v1_1[0] = "arm64-v8a";
            v1_1[1] = "x86_64";
            if(StringsKt.endsWith$default(v14, "64", false, v13, v9) != SetsKt.setOf(((Object[])v1_1)).contains(arg15)) {
                return 0;
            }

            if(!v4_1 || !v0_1.isEmpty()) {
                Iterator v13_1 = ((Iterable)v0_1).iterator();
                do {
                    if(!v13_1.hasNext()) {
                        break;
                    }
                    else if(new File(v14, v13_1.next()).canRead()) {
                        continue;
                    }

                    return v2;
                }
                while(true);

            label_97:
                v2 = true;
            }
            else {
                goto label_97;
            }

            return v2;
        }

        return 1;
    }

    public final String route(int arg8, GraphicsAngleDevice arg9, GraphicsAccess arg10, Function1 arg11) {
        String v2_1;
        Intrinsics.checkNotNullParameter(arg9, "device");
        Intrinsics.checkNotNullParameter(arg10, "access");
        Intrinsics.checkNotNullParameter(arg11, "run");
        if(arg8 >= 33) {
            String[] v7 = new String[4];
            String v1 = "arm64-v8a";
            v7[0] = v1;
            v7[1] = "armeabi-v7a";
            int v2 = 2;
            String v4 = "x86_64";
            v7[v2] = v4;
            v7[3] = "x86";
            if(SetsKt.setOf(((Object[])v7)).contains(arg9.getAbi())) {
                v7 = new String[v2];
                v7[0] = v1;
                v7[1] = v4;
                String v7_1 = SetsKt.setOf(((Object[])v7)).contains(arg9.getAbi()) ? "lib64" : "lib";
                v1 = "angle";
                if(!StringsKt.equals(arg10.read("prop:ro.hardware.egl").getText(), v1, true) && (arg8 < 34 || !StringsKt.equals(arg10.read("prop:persist.graphics.egl").getText(), v1, true))) {
                    String v0 = "No se encontraron bibliotecas ANGLE utilizables para " + arg9.getAbi();
                    String v10 = arg10.read("prop:debug.angle.libs.suffix").getText();
                    List v1_1 = CollectionsKt.listOf("/system");
                    List v8 = arg8 < 35 || !arg9.getVulkan11() || v10.length() != 0 ? CollectionsKt.emptyList() : CollectionsKt.listOf("/system_ext");
                    Iterator v8_1 = CollectionsKt.plus(((Collection)v1_1), ((Iterable)v8)).iterator();
                    while(true) {
                        v2_1 = " · ABI ";
                        if(!v8_1.hasNext()) {
                            break;
                        }

                        Object v1_2 = v8_1.next();
                        v4 = "/";
                        Object v3 = arg11.invoke("test -r " + (((String)v1_2)) + v4 + v7_1 + "/libEGL_angle.so && test -r " + (((String)v1_2)) + v4 + v7_1 + "/libGLESv2_angle.so");
                        if(((GraphicsResponse)v3).getExit() == 0 && (StringsKt.isBlank(((GraphicsResponse)v3).getError()))) {
                            return (((String)v1_2)) + v4 + v7_1 + v2_1 + arg9.getAbi();
                        }

                        if(StringsKt.isBlank(((GraphicsResponse)v3).getError())) {
                            continue;
                        }

                        v0 = "No se pudo consultar ANGLE: " + StringsKt.take(((GraphicsResponse)v3).getError(), 0xA0);
                    }

                    if((arg9.getVulkan11()) && v10.length() == 0 && arg9.getProvider() != null) {
                        return "Proveedor ANGLE " + arg9.getProvider() + v2_1 + arg9.getAbi();
                    }

                    String v8_2 = v10.length() > 0 ? "; suffix EGL activo: " + v10 : "";
                    throw new IllegalStateException(v0 + v8_2.toString());
                }

                return "ANGLE global del sistema · ABI " + arg9.getAbi();
            }

            throw new IllegalStateException("ABI del juego no acreditada para ANGLE".toString());
        }

        throw new IllegalStateException("ANGLE requiere Android 13 o posterior".toString());
    }
}

