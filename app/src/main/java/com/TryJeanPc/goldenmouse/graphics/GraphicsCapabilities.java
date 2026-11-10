package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build$VERSION;
import android.view.Display$Mode;
import android.view.Display;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0081\b\u0018\u0000 <2\u00020\u0001:\u0001<B­\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001C\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00030&2\u0006\u0010\'\u001A\u00020\u00112\u0006\u0010(\u001A\u00020\u0003J\t\u0010)\u001A\u00020\u0003HÆ\u0003J\u000B\u0010*\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000F\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000F\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000B\u0010-\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010.\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010/\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000F\u00100\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000B\u00101\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u00102\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u00103\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u00104\u001A\u0004\u0018\u00010\u0011HÆ\u0003J\u000B\u00105\u001A\u0004\u0018\u00010\u0003HÆ\u0003J¯\u0001\u00106\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00107\u001A\u0002082\b\u00109\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001A\u00020\u0007HÖ\u0001J\t\u0010;\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0019R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0016R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0016R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0016R\u0017\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0019R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0016R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b \u0010\u0016R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0016R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u0016¨\u0006="}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCapabilities;", "", "backend", "", "error", "hz", "", "", "colors", "angle", "msaa", "gameDriver", "modes", "animations", "texture", "checkedPackage", "checkedProfile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "planError", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;Ljava/lang/String;)V", "getBackend", "()Ljava/lang/String;", "getError", "getHz", "()Ljava/util/Set;", "getColors", "getAngle", "getMsaa", "getGameDriver", "getModes", "getAnimations", "getTexture", "getCheckedPackage", "getCheckedProfile", "()Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "getPlanError", "blockers", "", "p", "pkg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsCapabilities {
    @Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000FJy\u0010\u0010\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00162\u0012\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\u00182$\u0010\u001A\u001A \u0012\u0004\u0012\u00020\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001C0\u001B0\u00182\b\b\u0002\u0010\u001D\u001A\u00020\u001EH\u0000¢\u0006\u0002\b\u001F¨\u0006 "}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCapabilities$Companion;", "", "<init>", "()V", "inspect", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCapabilities;", "context", "Landroid/content/Context;", "pkg", "", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "display", "Landroid/view/Display;", "access", "Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;", "inspectBackend", "sdk", "", "a", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;", "session", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsSession;", "run", "Lkotlin/Function1;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsResponse;", "gameModes", "Lkotlin/Pair;", "", "device", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAngleDevice;", "inspectBackend$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GraphicsCapabilities inspect(Context arg27, String arg28, GraphicsProfile arg29, Display arg30, GoldenGraphicsBackend arg31) {
            GoldenGraphicsBackend v0_7;
            Object v0_5;
            Set v0_3;
            int v9;
            Context v1 = arg27;
            String v2 = arg28;
            Intrinsics.checkNotNullParameter(v1, "context");
            Intrinsics.checkNotNullParameter(v2, "pkg");
            GraphicsProfile v3 = arg29;
            Intrinsics.checkNotNullParameter(v3, "profile");
            GraphicsAttemptLog v4 = null;
            Display$Mode[] v0 = arg30 != null ? arg30.getSupportedModes() : ((Display$Mode[])v4);
            int v5 = 0;
            if(v0 == null) {
                v0 = new Display$Mode[0];
            }

            ArrayList v6 = new ArrayList();
            int v7 = v0.length;
            int v8;
            for(v8 = 0; true; ++v8) {
                v9 = 2;
                if(v8 >= v7) {
                    break;
                }

                Display$Mode v10 = v0[v8];
                Integer[] v11 = new Integer[4];
                v11[0] = Integer.valueOf(60);
                v11[1] = Integer.valueOf(90);
                v11[v9] = Integer.valueOf(120);
                v11[3] = Integer.valueOf(0x90);
                List v9_1 = CollectionsKt.listOf(((Object[])v11));
                ArrayList v11_1 = new ArrayList();
                Iterator v9_2 = ((Iterable)v9_1).iterator();
                while(v9_2.hasNext()) {
                    Object v12 = v9_2.next();
                    if(Math.abs(v10.getRefreshRate() - (((float)v12.intValue()))) >= 1.5f) {
                        continue;
                    }

                    ((Collection)v11_1).add(v12);
                }

                CollectionsKt.addAll(((Collection)v6), ((Iterable)v11_1));
            }

            Set v13 = CollectionsKt.toSet(((Iterable)v6));
            try {
                int v0_2 = Resources.getSystem().getIdentifier("config_availableColorModes", "array", "android");
                if(v0_2 == 0) {
                    v0_3 = SetsKt.emptySet();
                }
                else {
                    int[] v0_4 = Resources.getSystem().getIntArray(v0_2);
                    Intrinsics.checkNotNullExpressionValue(v0_4, "getIntArray(...)");
                    v6 = new ArrayList();
                    v7 = v0_4.length;
                    while(v5 < v7) {
                        v8 = v0_4[v5];
                        if(v8 >= 0 && v8 < v9) {
                            ((Collection)v6).add(Integer.valueOf(v8));
                        }

                        ++v5;
                    }

                    v0_3 = CollectionsKt.toSet(((Iterable)v6));
                }

                v0_5 = Result.constructor-impl(v0_3);
            }
            catch(Throwable v0_1) {
                v0_5 = Result.constructor-impl(ResultKt.createFailure(v0_1));
            }

            Set v5_1 = SetsKt.emptySet();
            if(Result.isFailure-impl(v0_5)) {
                v0_3 = v5_1;
            }

            Object v14 = v0_5;
            if(arg31 == null) {
                try {
                    v0_7 = com.TryJeanPc.goldenmouse.graphics.GoldenGraphicsBackend$Companion.open$default(GoldenGraphicsBackend.Companion, v1, v4, v9, v4);
                }
                catch(Exception v0_6) {
                    return new GraphicsCapabilities(null, v0_6.getMessage(), v13, ((Set)v14), null, null, null, null, null, null, null, null, null, 0x1FF1, null);
                }
            }
            else {
                v0_7 = arg31;
            }

            int v4_1 = Build$VERSION.SDK_INT;
            GoldenGraphicsBackend v5_2 = v0_7;
            GraphicsSession v6_1 = new GraphicsSession(new GraphicsJournal(v1));
            GraphicsCapabilities$Companion$inspect$1 v7_1 = new GraphicsCapabilities$Companion$inspect$1(v0_7);
            GraphicsCapabilities$Companion$inspect$2 v8_1 = new GraphicsCapabilities$Companion$inspect$2(v0_7);
            GraphicsAngleDevice v15 = (v3.getTextureRequested()) || v3.getDriver() == v9 ? GraphicsAngle.INSTANCE.device(v1, v2, new GraphicsCapabilities$Companion$inspect$3(v0_7)) : new GraphicsAngleDevice(null, false, null, 7, null);
            return GraphicsCapabilities.copy$default(this.inspectBackend$app(v2, v3, v4_1, ((GraphicsAccess)v5_2), v6_1, ((Function1)v7_1), ((Function1)v8_1), v15), null, null, v13, ((Set)v14), null, null, null, null, null, null, null, null, null, 0x1FF3, null);
        }

        public static GraphicsCapabilities inspect$default(Companion arg6, Context arg7, String arg8, GraphicsProfile arg9, Display arg10, GoldenGraphicsBackend arg11, int arg12, Object arg13) {
            if((arg12 & 16) != 0) {
                arg11 = null;
            }

            return arg6.inspect(arg7, arg8, arg9, arg10, arg11);
        }

        public final GraphicsCapabilities inspectBackend$app(String arg19, GraphicsProfile arg20, int arg21, GraphicsAccess arg22, GraphicsSession arg23, Function1 arg24, Function1 arg25, GraphicsAngleDevice arg26) {
            Set v0_6;
            Object v0_5;
            String v14;
            String v0_3;
            String[] v0_2;
            String v11 = arg19;
            GraphicsProfile v12 = arg20;
            int v1 = arg21;
            GraphicsAccess v2 = arg22;
            GraphicsSession v3 = arg23;
            Function1 v4 = arg24;
            Function1 v5 = arg25;
            GraphicsAngleDevice v0 = arg26;
            Intrinsics.checkNotNullParameter(v11, "pkg");
            Intrinsics.checkNotNullParameter(v12, "profile");
            Intrinsics.checkNotNullParameter(v2, "a");
            Intrinsics.checkNotNullParameter(v3, "session");
            Intrinsics.checkNotNullParameter(v4, "run");
            Intrinsics.checkNotNullParameter(v5, "gameModes");
            Intrinsics.checkNotNullParameter(v0, "device");
            if(GraphicsProfileKt.validGraphicsPackage(v11)) {
                int v6 = 2;
                int v7 = 4;
                Object v9 = null;
                try {
                    GraphicsAngle.INSTANCE.route(v1, v0, v2, v4);
                    v0_2 = new String[v6];
                    v0_2[0] = "global:angle_gl_driver_selection_pkgs";
                    v0_2[1] = "global:angle_gl_driver_selection_values";
                    v0_3 = Companion.inspectBackend$original$default(v2, CollectionsKt.listOf(((Object[])v0_2)), false, v7, v9);
                }
                catch(Exception v0_1) {
                    v0_3 = v0_1.getMessage();
                    if(v0_3 != null) {
                        goto label_43;
                    }

                    v0_3 = "ANGLE no disponible";
                }

            label_43:
                String v13 = v0_3;
                if(v13 == null) {
                    if(!v12.getTextureRequested()) {
                        v0_3 = "Textura no solicitada en este perfil";
                    }
                    else {
                        v0_2 = new String[v6];
                        v0_2[0] = "prop:debug.angle.feature_overrides_enabled";
                        v0_2[1] = "global:angle_egl_features";
                        v0_3 = Companion.inspectBackend$original$default(v2, CollectionsKt.listOf(((Object[])v0_2)), false, v7, v9);
                    }

                    v14 = v0_3;
                }
                else {
                    v14 = v13;
                }

                String v15 = Companion.inspectBackend$original(v2, CollectionsKt.listOf("prop:debug.egl.force_msaa"), true);
                if(v1 < 29) {
                    goto label_82;
                }

                try {
                    if(StringsKt.trim(v4.invoke("getprop ro.gfx.driver.0").getOut()).toString().length() > 0) {
                        v0_3 = Companion.inspectBackend$original$default(v2, CollectionsKt.listOf("global:updatable_driver_production_opt_in_apps"), false, v7, v9);
                        goto label_90;
                    }

                    throw new IllegalStateException("El sistema no declara Game Driver actualizable".toString());
                label_82:
                    throw new IllegalStateException("Game Driver requiere Android 10 o posterior".toString());
                label_81:
                }
                catch(Exception v0_1) {
                    goto label_81;
                }

                v0_3 = v0_1.getMessage();
                if(v0_3 == null) {
                    v0_3 = "Driver no disponible";
                }

            label_90:
                String v1_1 = v0_3;
                try {
                    v0_5 = Result.constructor-impl(v5.invoke(v11).getSecond());
                }
                catch(Throwable v0_4) {
                    v0_5 = Result.constructor-impl(ResultKt.createFailure(v0_4));
                }

                Set v4_1 = SetsKt.emptySet();
                if(Result.isFailure-impl(v0_5)) {
                    v0_6 = v4_1;
                }

                Object v4_2 = v0_6;
                try {
                    v3.plan(v2, v11, v12);
                    v0_3 = ((String)v9);
                }
                catch(Exception v0_1) {
                    v0_3 = v0_1.getMessage();
                    if(v0_3 != null) {
                        goto label_113;
                    }

                    v0_3 = "No se puede planificar/restaurar el perfil solicitado";
                }

            label_113:
                String v5_1 = v1_1;
                v1_1 = v2.getIdentity();
                int v16 = v6;
                String[] v6_1 = new String[3];
                v6_1[0] = "global:window_animation_scale";
                v6_1[1] = "global:transition_animation_scale";
                v6_1[v16] = "global:animator_duration_scale";
                return new GraphicsCapabilities(v1_1, null, null, null, v13, v15, v5_1, v4_2, Companion.inspectBackend$original$default(v2, CollectionsKt.listOf(((Object[])v6_1)), false, v7, v9), v14, v11, v12, v0_3, 12, null);
            }

            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static GraphicsCapabilities inspectBackend$app$default(Companion arg11, String arg12, GraphicsProfile arg13, int arg14, GraphicsAccess arg15, GraphicsSession arg16, Function1 arg17, Function1 arg18, GraphicsAngleDevice arg19, int arg20, Object arg21) {
            GraphicsAngleDevice v10 = (arg20 & 0x80) != 0 ? new GraphicsAngleDevice(null, false, null, 7, null) : arg19;
            return arg11.inspectBackend$app(arg12, arg13, arg14, arg15, arg16, arg17, arg18, v10);
        }

        private static final String inspectBackend$original(GraphicsAccess arg2, List arg3, boolean arg4) {
            try {
                Iterator v3 = ((Iterable)arg3).iterator();
                while(v3.hasNext()) {
                    Object v0 = v3.next();
                    if(arg4) {
                        if(arg2.read(((String)v0)).getPresent()) {
                        }
                        else {
                            throw new IllegalStateException("Propiedad ausente: Android no permite restituir su ausencia".toString());
                        }
                    }

                    if(arg4) {
                        continue;
                    }

                    arg2.read(((String)v0));
                }
            }
            catch(Exception v2) {
                goto label_20;
            }

            return null;
        label_20:
            String v2_1 = v2.getMessage();
            if(v2_1 == null) {
                v2_1 = "Lectura de originales fallida";
            }

            return v2_1;
        }

        static String inspectBackend$original$default(GraphicsAccess arg0, List arg1, boolean arg2, int arg3, Object arg4) {
            return Companion.inspectBackend$original(arg0, arg1, false);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final String angle;
    private final String animations;
    private final String backend;
    private final String checkedPackage;
    private final GraphicsProfile checkedProfile;
    private final Set colors;
    private final String error;
    private final String gameDriver;
    private final Set hz;
    private final Set modes;
    private final String msaa;
    private final String planError;
    private final String texture;

    static {
        GraphicsCapabilities.Companion = new Companion(null);
        GraphicsCapabilities.$stable = 8;
    }

    public GraphicsCapabilities() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 0x1FFF, null);
    }

    public GraphicsCapabilities(String arg14, String arg15, Set arg16, Set arg17, String arg18, String arg19, String arg20, Set arg21, String arg22, String arg23, String arg24, GraphicsProfile arg25, String arg26, int arg27, DefaultConstructorMarker arg28) {
        int v0 = arg27;
        if((v0 & 1) != 0) {
            arg14 = "No comprobado";
        }

        String v1 = (v0 & 2) != 0 ? "Comprueba el backend elegido de Golden" : arg15;
        Set v2 = (v0 & 4) != 0 ? SetsKt.emptySet() : arg16;
        Set v3 = (v0 & 8) != 0 ? SetsKt.emptySet() : arg17;
        String v4 = (v0 & 16) != 0 ? "ANGLE no comprobado" : arg18;
        String v5 = (v0 & 0x20) != 0 ? "EGL no comprobado" : arg19;
        String v6 = (v0 & 0x40) != 0 ? "Game Driver no comprobado" : arg20;
        Set v7 = (v0 & 0x80) != 0 ? SetsKt.emptySet() : arg21;
        String v8 = (v0 & 0x100) != 0 ? "Valores anteriores no comprobados" : arg22;
        String v9 = (v0 & 0x200) != 0 ? v4 : arg23;
        String v11 = null;
        String v10 = (v0 & 0x400) != 0 ? v11 : arg24;
        GraphicsProfile v12 = (v0 & 0x800) != 0 ? ((GraphicsProfile)v11) : arg25;
        String v28 = (v0 & 0x1000) != 0 ? v11 : arg26;
        this(arg14, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v12, v28);
    }

    public GraphicsCapabilities(String arg2, String arg3, Set arg4, Set arg5, String arg6, String arg7, String arg8, Set arg9, String arg10, String arg11, String arg12, GraphicsProfile arg13, String arg14) {
        Intrinsics.checkNotNullParameter(arg2, "backend");
        Intrinsics.checkNotNullParameter(arg4, "hz");
        Intrinsics.checkNotNullParameter(arg5, "colors");
        Intrinsics.checkNotNullParameter(arg9, "modes");
        super();
        this.backend = arg2;
        this.error = arg3;
        this.hz = arg4;
        this.colors = arg5;
        this.angle = arg6;
        this.msaa = arg7;
        this.gameDriver = arg8;
        this.modes = arg9;
        this.animations = arg10;
        this.texture = arg11;
        this.checkedPackage = arg12;
        this.checkedProfile = arg13;
        this.planError = arg14;
    }

    public final List blockers(GraphicsProfile arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg4, "p");
        Intrinsics.checkNotNullParameter(arg5, "pkg");
        List v0 = CollectionsKt.createListBuilder();
        String v1 = this.error;
        if(v1 != null) {
            v0.add(v1);
        }

        if(!Intrinsics.areEqual(this.checkedPackage, arg5) || !Intrinsics.areEqual(this.checkedProfile, arg4)) {
            v0.add("Comprueba la compatibilidad del paquete y perfil actuales");
        }

        arg5 = this.planError;
        if(arg5 != null) {
            v0.add(arg5);
        }

        if(arg4.getTextureRequested()) {
            arg5 = this.texture;
            if(arg5 != null) {
                v0.add(arg5);
            }
        }

        if(arg4.getDriver() == 2) {
            arg5 = this.angle;
            if(arg5 != null) {
                v0.add(arg5);
            }
        }

        if(arg4.getMsaa()) {
            arg5 = this.msaa;
            if(arg5 != null) {
                v0.add(arg5);
            }
        }

        if(arg4.getDriver() == 1) {
            arg5 = this.gameDriver;
            if(arg5 != null) {
                v0.add(arg5);
            }
        }

        if((arg4.getTextureRequested()) && arg4.getDriver() == 1) {
            v0.add("Textura Ligera requiere ANGLE, no Game Driver");
        }

        if(arg4.getHz() > 0 && !this.hz.contains(Integer.valueOf(arg4.getHz()))) {
            v0.add("Frecuencia no disponible en el panel");
        }

        if(arg4.getColor() >= 0 && !this.colors.contains(Integer.valueOf(arg4.getColor()))) {
            v0.add("Modo de color no acreditado para esta pantalla");
        }

        if(arg4.getSaturation() != 10) {
            v0.add("Saturación: no existe lectura fiable del original de SurfaceFlinger");
        }

        if(arg4.getFixed()) {
            v0.add("Rendimiento fijo: no existe lectura fiable del estado anterior");
        }

        if(arg4.getAnimations() != 0) {
            arg5 = this.animations;
            if(arg5 != null) {
                v0.add(arg5);
            }
        }

        if(arg4.getFps() != 0) {
            v0.add("FPS: falta restitución exacta del override GameManager preexistente");
        }

        if(arg4.getResolution() != 100) {
            v0.add("Downscale bloqueado: exclusión con Stretch y recuperación del override sin acreditar");
        }

        if(arg4.getMode() > 0) {
            Set v3 = this.modes;
            String v4 = arg4.getMode() == 1 ? "performance" : "battery";
            if(v3.contains(v4)) {
                goto label_100;
            }

            v0.add("El juego no ofrece este modo GameManager");
        }

    label_100:
        return CollectionsKt.build(v0);
    }

    public final String component1() {
        return this.backend;
    }

    public final String component10() {
        return this.texture;
    }

    public final String component11() {
        return this.checkedPackage;
    }

    public final GraphicsProfile component12() {
        return this.checkedProfile;
    }

    public final String component13() {
        return this.planError;
    }

    public final String component2() {
        return this.error;
    }

    public final Set component3() {
        return this.hz;
    }

    public final Set component4() {
        return this.colors;
    }

    public final String component5() {
        return this.angle;
    }

    public final String component6() {
        return this.msaa;
    }

    public final String component7() {
        return this.gameDriver;
    }

    public final Set component8() {
        return this.modes;
    }

    public final String component9() {
        return this.animations;
    }

    public final GraphicsCapabilities copy(String arg15, String arg16, Set arg17, Set arg18, String arg19, String arg20, String arg21, Set arg22, String arg23, String arg24, String arg25, GraphicsProfile arg26, String arg27) {
        Intrinsics.checkNotNullParameter(arg15, "backend");
        Intrinsics.checkNotNullParameter(arg17, "hz");
        Intrinsics.checkNotNullParameter(arg18, "colors");
        Intrinsics.checkNotNullParameter(arg22, "modes");
        return new GraphicsCapabilities(arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27);
    }

    public static GraphicsCapabilities copy$default(GraphicsCapabilities arg12, String arg13, String arg14, Set arg15, Set arg16, String arg17, String arg18, String arg19, Set arg20, String arg21, String arg22, String arg23, GraphicsProfile arg24, String arg25, int arg26, Object arg27) {
        int v0 = arg26;
        if((v0 & 1) != 0) {
            arg13 = arg12.backend;
        }

        String v1 = (v0 & 2) != 0 ? arg12.error : arg14;
        Set v2 = (v0 & 4) != 0 ? arg12.hz : arg15;
        Set v3 = (v0 & 8) != 0 ? arg12.colors : arg16;
        String v4 = (v0 & 16) != 0 ? arg12.angle : arg17;
        String v5 = (v0 & 0x20) != 0 ? arg12.msaa : arg18;
        String v6 = (v0 & 0x40) != 0 ? arg12.gameDriver : arg19;
        Set v7 = (v0 & 0x80) != 0 ? arg12.modes : arg20;
        String v8 = (v0 & 0x100) != 0 ? arg12.animations : arg21;
        String v9 = (v0 & 0x200) != 0 ? arg12.texture : arg22;
        String v10 = (v0 & 0x400) != 0 ? arg12.checkedPackage : arg23;
        GraphicsProfile v11 = (v0 & 0x800) != 0 ? arg12.checkedProfile : arg24;
        String v27 = (v0 & 0x1000) != 0 ? arg12.planError : arg25;
        return arg12.copy(arg13, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v27);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsCapabilities)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsCapabilities)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backend, ((GraphicsCapabilities)arg5).backend)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.error, ((GraphicsCapabilities)arg5).error)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.hz, ((GraphicsCapabilities)arg5).hz)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.colors, ((GraphicsCapabilities)arg5).colors)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.angle, ((GraphicsCapabilities)arg5).angle)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.msaa, ((GraphicsCapabilities)arg5).msaa)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.gameDriver, ((GraphicsCapabilities)arg5).gameDriver)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.modes, ((GraphicsCapabilities)arg5).modes)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.animations, ((GraphicsCapabilities)arg5).animations)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.texture, ((GraphicsCapabilities)arg5).texture)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.checkedPackage, ((GraphicsCapabilities)arg5).checkedPackage)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.checkedProfile, ((GraphicsCapabilities)arg5).checkedProfile)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.planError, ((GraphicsCapabilities)arg5).planError)) {
            return 0;
        }

        return 1;
    }

    public final String getAngle() {
        return this.angle;
    }

    public final String getAnimations() {
        return this.animations;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getCheckedPackage() {
        return this.checkedPackage;
    }

    public final GraphicsProfile getCheckedProfile() {
        return this.checkedProfile;
    }

    public final Set getColors() {
        return this.colors;
    }

    public final String getError() {
        return this.error;
    }

    public final String getGameDriver() {
        return this.gameDriver;
    }

    public final Set getHz() {
        return this.hz;
    }

    public final Set getModes() {
        return this.modes;
    }

    public final String getMsaa() {
        return this.msaa;
    }

    public final String getPlanError() {
        return this.planError;
    }

    public final String getTexture() {
        return this.texture;
    }

    public int hashCode() {
        int v0 = this.backend.hashCode() * 0x1F;
        String v1 = this.error;
        int v2 = 0;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (((v0 + v1_1) * 0x1F + this.hz.hashCode()) * 0x1F + this.colors.hashCode()) * 0x1F;
        v1 = this.angle;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.msaa;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.gameDriver;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = ((v0 + v1_1) * 0x1F + this.modes.hashCode()) * 0x1F;
        v1 = this.animations;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.texture;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        v1 = this.checkedPackage;
        v1_1 = v1 == null ? 0 : v1.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        GraphicsProfile v1_2 = this.checkedProfile;
        v1_1 = v1_2 == null ? 0 : v1_2.hashCode();
        v0 = (v0 + v1_1) * 0x1F;
        String v3 = this.planError;
        if(v3 == null) {
        }
        else {
            v2 = v3.hashCode();
        }

        return v0 + v2;
    }

    public String toString() {
        return "GraphicsCapabilities(backend=" + this.backend + ", error=" + this.error + ", hz=" + this.hz + ", colors=" + this.colors + ", angle=" + this.angle + ", msaa=" + this.msaa + ", gameDriver=" + this.gameDriver + ", modes=" + this.modes + ", animations=" + this.animations + ", texture=" + this.texture + ", checkedPackage=" + this.checkedPackage + ", checkedProfile=" + this.checkedProfile + ", planError=" + this.planError + ")";
    }
}

