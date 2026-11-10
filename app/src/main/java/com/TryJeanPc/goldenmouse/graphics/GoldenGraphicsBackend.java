package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.os.Build$VERSION;
import android.os.Process;
import com.TryJeanPc.goldenmouse.activation.ActivationStorage;
import com.TryJeanPc.goldenmouse.bridge.KadbBridge;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import rikka.shizuku.Shizuku;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B%\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001A\u00020\u0015H\u0002J\u000E\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u0005J\u0006\u0010\u0019\u001A\u00020\u0015J\u0018\u0010\u001A\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001C0\u001BJ\u0014\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00110\u001C2\u0006\u0010\u001E\u001A\u00020\u0005J\u000E\u0010\u001F\u001A\u00020\u00152\u0006\u0010\u001E\u001A\u00020\u0005J\b\u0010 \u001A\u00020\u0005H\u0016J\u0010\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u0005H\u0016J \u0010$\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001C0%2\u0006\u0010\u001E\u001A\u00020\u0005J\u0018\u0010&\u001A\u00020\u00152\u0006\u0010#\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020\"H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;", "context", "Landroid/content/Context;", "identity", "", "audit", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;)V", "getIdentity", "()Ljava/lang/String;", "angleEglFeaturesSupported", "", "getAngleEglFeaturesSupported", "()Z", "user", "", "getUser", "()I", "selected", "", "run", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsResponse;", "command", "verifyUid", "processQuery", "Lkotlin/Function1;", "", "pids", "pkg", "stopGame", "boot", "read", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "key", "gameModes", "Lkotlin/Pair;", "write", "value", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GoldenGraphicsBackend implements GraphicsAccess {
    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0015\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\bH\u0000¢\u0006\u0002\b\u0013R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend$Companion;", "", "<init>", "()V", "commands", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsCommandRunner;", "settings", "", "", "props", "readOnly", "open", "Lcom/TryJeanPc/goldenmouse/graphics/GoldenGraphicsBackend;", "context", "Landroid/content/Context;", "audit", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttemptLog;", "quote", "value", "quote$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GoldenGraphicsBackend open(Context arg3, GraphicsAttemptLog arg4) {
            Intrinsics.checkNotNullParameter(arg3, "context");
            String v2 = new ActivationStorage(arg3).activeMethod();
            if(Intrinsics.areEqual(v2, "SHIZUKU")) {
                if((Shizuku.pingBinder()) && Shizuku.checkSelfPermission() == 0) {
                    v2 = "SHIZUKU:" + Shizuku.getUid();
                    goto label_31;
                }

                throw new IllegalStateException("Shizuku seleccionado: servidor o permiso no disponible".toString());
            }
            else {
                String v0 = "KADB";
                if(!Intrinsics.areEqual(v2, v0)) {
                    goto label_43;
                }

                if(!KadbBridge.INSTANCE.estaConectado()) {
                    goto label_38;
                }

                v2 = v0;
            }

        label_31:
            arg3 = arg3.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(arg3, "getApplicationContext(...)");
            return new GoldenGraphicsBackend(arg3, v2, arg4, null);
        label_38:
            throw new IllegalStateException("KADB seleccionado sin conexión".toString());
        label_43:
            throw new IllegalStateException("Selecciona y activa un backend en la activación existente de Golden".toString());
        }

        public static GoldenGraphicsBackend open$default(Companion arg0, Context arg1, GraphicsAttemptLog arg2, int arg3, Object arg4) {
            if((arg3 & 2) != 0) {
                arg2 = null;
            }

            return arg0.open(arg1, arg2);
        }

        public final String quote$app(String arg8) {
            Intrinsics.checkNotNullParameter(arg8, "value");
            if(arg8.length() <= 0x1000) {
                String v7 = arg8;
                int v0 = 0;
                while(true) {
                    if(v0 < ((CharSequence)v7).length()) {
                        int v1 = ((CharSequence)v7).charAt(v0);
                        if(v1 != 10 && v1 != 13 && v1 != 0) {
                            ++v0;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_31;
                }

                return "\'" + StringsKt.replace$default(arg8, "\'", "\'\\\'\'", false, 4, null) + "\'";
            }

        label_31:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final GraphicsAttemptLog audit;
    private static final GraphicsCommandRunner commands;
    private final Context context;
    private final String identity;
    private static final Set props;
    private static final Set readOnly;
    private static final Set settings;
    private final int user;

    static {
        GoldenGraphicsBackend.Companion = new Companion(null);
        GoldenGraphicsBackend.$stable = 8;
        GoldenGraphicsBackend.commands = new GraphicsCommandRunner(null, 0, 3, null);
        GoldenGraphicsBackend.settings = SetsKt.setOf(new String[]{"system:peak_refresh_rate", "system:min_refresh_rate", "system:display_color_mode", "global:updatable_driver_production_opt_in_apps", "global:angle_gl_driver_selection_pkgs", "global:angle_gl_driver_selection_values", "global:angle_egl_features", "global:window_animation_scale", "global:transition_animation_scale", "global:animator_duration_scale"});
        GoldenGraphicsBackend.props = SetsKt.setOf(new String[]{"prop:debug.angle.feature_overrides_enabled", "prop:debug.angle.feature_overrides_disabled", "prop:debug.egl.force_msaa"});
        GoldenGraphicsBackend.readOnly = SetsKt.setOf(new String[]{"global:angle_gl_driver_all_angle", "prop:debug.angle.libs.suffix", "prop:ro.hardware.egl", "prop:persist.graphics.egl"});
    }

    private GoldenGraphicsBackend(Context arg1, String arg2, GraphicsAttemptLog arg3) {
        super();
        this.context = arg1;
        this.identity = arg2;
        this.audit = arg3;
        this.user = Process.myUid() / 100000;
    }

    GoldenGraphicsBackend(Context arg1, String arg2, GraphicsAttemptLog arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 4) != 0) {
            arg3 = null;
        }

        this(arg1, arg2, arg3);
    }

    public GoldenGraphicsBackend(Context arg1, String arg2, GraphicsAttemptLog arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public String boot() {
        GraphicsResponse v3 = this.run("cat /proc/sys/kernel/random/boot_id");
        if(v3.getExit() == 0 && (new Regex("[0-9a-f-]{36}").matches(StringsKt.trim(v3.getOut()).toString()))) {
            return StringsKt.trim(v3.getOut()).toString();
        }

        throw new IllegalStateException("No se pudo identificar el arranque".toString());
    }

    public final Pair gameModes(String arg8) {
        Intrinsics.checkNotNullParameter(arg8, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(arg8)) {
            GraphicsResponse v0 = this.run("am get-current-user");
            if(v0.getExit() == 0 && (StringsKt.isBlank(v0.getError()))) {
                Integer v0_1 = StringsKt.toIntOrNull(StringsKt.trim(v0.getOut()).toString());
                int v1 = this.getUser();
                if(v0_1 != null && v0_1.intValue() == v1) {
                    GraphicsResponse v7 = this.run("cmd game list-modes " + GoldenGraphicsBackend.Companion.quote$app(arg8));
                    if(v7.getExit() == 0) {
                        MatchResult v7_1 = new Regex(Regex.Companion.escape(arg8) + " current mode: (standard|performance|battery|custom), available game modes: \\[([^]]+)\\]").matchEntire(StringsKt.trim(v7.getOut()).toString());
                        if(v7_1 != null) {
                            Object v8 = v7_1.getGroupValues().get(1);
                            List v7_2 = StringsKt.split$default(v7_1.getGroupValues().get(2), new char[]{','}, false, 0, 6, null);
                            ArrayList v0_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v7_2), 10));
                            Iterator v7_3 = ((Iterable)v7_2).iterator();
                            while(v7_3.hasNext()) {
                                ((Collection)v0_2).add(StringsKt.trim(v7_3.next()).toString());
                            }

                            return TuplesKt.to(v8, CollectionsKt.toSet(((Iterable)v0_2)));
                        }
                        else {
                            throw new IllegalStateException("Formato GameManager no acreditado".toString());
                        }
                    }
                    else {
                        throw new IllegalStateException("GameManager no permite consultar este juego".toString());
                    }
                }
            }

            throw new IllegalStateException("GameManager no permite acreditar el usuario del estado original".toString());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public boolean getAngleEglFeaturesSupported() {
        if(Build$VERSION.SDK_INT >= 33) {
            return 1;
        }

        return 0;
    }

    public String getIdentity() {
        return this.identity;
    }

    public int getUser() {
        return this.user;
    }

    public final Set pids(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(arg2)) {
            return this.processQuery().invoke(arg2);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Function1 processQuery() {
        GraphicsResponse v1 = this.run("ps -A -o PID,ARGS");
        if(v1.getExit() == 0 && (StringsKt.isBlank(v1.getError()))) {
            return new GoldenGraphicsBackend$$ExternalSyntheticLambda2(v1);
        }

        throw new IllegalStateException("No se pudieron consultar los procesos de la sesión gráfica".toString());
    }

    static final Set processQuery$lambda$6(GraphicsResponse arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pkg");
        return GoldenGraphicsBackendKt.graphicsPackagePids(arg1.getOut(), arg2);
    }

    public GraphicsValue read(String arg13) {
        Intrinsics.checkNotNullParameter(arg13, "key");
        String v0 = "game:";
        int v2 = 2;
        Object v3 = null;
        if(StringsKt.startsWith$default(arg13, v0, false, v2, v3)) {
            return new GraphicsValue(true, this.gameModes(StringsKt.removePrefix(arg13, ((CharSequence)v0))).getFirst());
        }

        if(!GoldenGraphicsBackend.settings.contains(arg13) && !GoldenGraphicsBackend.props.contains(arg13)) {
            if(GoldenGraphicsBackend.readOnly.contains(arg13)) {
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }

        char v0_1 = ':';
        String v6 = StringsKt.substringAfter$default(arg13, v0_1, ((String)v3), v2, v3);
        boolean v4 = StringsKt.startsWith$default(arg13, "prop:", false, v2, v3);
        GraphicsResponse v12 = v4 ? this.run("v=$(getprop) || exit $?; printf \'%s\\n\' \"$v\" | grep \'^\\[" + StringsKt.replace$default(v6, ".", "\\.", false, 4, null) + "\\]: \'") : this.run("v=$(settings --user " + this.getUser() + " list " + StringsKt.substringBefore$default(arg13, v0_1, ((String)v3), v2, v3) + ") || exit $?; printf \'%s\\n\' \"$v\" | grep \'^" + v6 + "=\'");
        if(v12.getExit() == 1 && v12.getOut().length() == 0 && v12.getError().length() == 0) {
            return GraphicsValue.Companion.getABSENT();
        }

        if(v12.getExit() == 0 && (StringsKt.isBlank(v12.getError()))) {
            String v12_1 = StringsKt.removeSuffix(StringsKt.removeSuffix(v12.getOut(), "\n"), "\r");
            arg13 = "Check failed.";
            v0 = "substring(...)";
            if(v4) {
                String v4_1 = "[" + v6 + "]: [";
                if((StringsKt.startsWith$default(v12_1, v4_1, false, v2, v3)) && (StringsKt.endsWith$default(v12_1, "]", false, v2, v3))) {
                    v12_1 = v12_1.substring(v4_1.length(), v12_1.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(v12_1, v0);
                    goto label_123;
                }

                throw new IllegalStateException(arg13);
            }
            else {
                if(!StringsKt.startsWith$default(v12_1, v6 + "=", false, v2, v3)) {
                    goto label_126;
                }

                v12_1 = v12_1.substring(v6.length() + 1);
                Intrinsics.checkNotNullExpressionValue(v12_1, v0);
            }

        label_123:
            return new GraphicsValue(true, v12_1);
        label_126:
            throw new IllegalStateException(arg13);
        }

        throw new IllegalStateException("No se pudo leer " + arg13 + ": " + StringsKt.take(v12.getError(), 200).toString());
    }

    public final GraphicsResponse run(String arg9) {
        Intrinsics.checkNotNullParameter(arg9, "command");
        GraphicsAttemptLog v0 = this.audit;
        if(v0 != null) {
            v0.event("COMANDO", arg9);
        }

        this.selected();
        return GoldenGraphicsBackend.commands.run(arg9, StringsKt.startsWith$default(this.getIdentity(), "SHIZUKU:", false, 2, null), this.audit, new GoldenGraphicsBackend$$ExternalSyntheticLambda0(arg9), new GoldenGraphicsBackend$$ExternalSyntheticLambda1(arg9));
    }

    static final java.lang.Process run$lambda$2(String arg7) {
        Class v0 = Shizuku.class;
        Class[] v2 = new Class[3];
        Class v3 = String[].class;
        v2[0] = v3;
        v2[1] = v3;
        v2[2] = String.class;
        Method v0_1 = v0.getDeclaredMethod("newProcess", v2);
        v0_1.setAccessible(true);
        Object v7 = v0_1.invoke(null, new String[]{"sh", "-c", arg7}, null, null);
        Intrinsics.checkNotNull(v7, "null cannot be cast to non-null type java.lang.Process");
        return ((java.lang.Process)v7);
    }

    static final GraphicsShellChannel run$lambda$3(String arg1) {
        return new GoldenGraphicsBackend$run$2$1(KadbBridge.INSTANCE.abrirShell(arg1));
    }

    private final void selected() {
        if(Intrinsics.areEqual(Companion.open$default(GoldenGraphicsBackend.Companion, this.context, null, 2, null).getIdentity(), this.getIdentity())) {
            return;
        }

        throw new IllegalStateException("El backend seleccionado cambió".toString());
    }

    public final void stopGame(String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(arg5)) {
            GraphicsResponse v0 = this.run("am force-stop --user " + this.getUser() + " " + GoldenGraphicsBackend.Companion.quote$app(arg5));
            if(v0.getExit() == 0 && (StringsKt.isBlank(v0.getError()))) {
                if(this.pids(arg5).isEmpty()) {
                    return;
                }
                else {
                    throw new IllegalStateException("El juego continúa abierto; no se aplicará en caliente".toString());
                }
            }

            throw new IllegalStateException("No se confirmó el cierre autorizado: " + StringsKt.take(v0.getError(), 200).toString());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final void verifyUid() {
        GraphicsResponse v0 = this.run("id -u");
        Integer v1 = StringsKt.toIntOrNull(StringsKt.trim(v0.getOut()).toString());
        int v5 = 2;
        Object v6 = null;
        boolean v2 = StringsKt.startsWith$default(this.getIdentity(), "SHIZUKU:", false, v5, v6);
        Integer v3 = Integer.valueOf(2000);
        Integer v2_1 = v2 ? StringsKt.toIntOrNull(StringsKt.substringAfter$default(this.getIdentity(), ':', ((String)v6), v5, v6)) : v3;
        if(v0.getExit() == 0 && (StringsKt.isBlank(v0.getError()))) {
            Integer[] v5_1 = new Integer[v5];
            v5_1[0] = Integer.valueOf(0);
            v5_1[1] = v3;
            if((CollectionsKt.contains(SetsKt.setOf(((Object[])v5_1)), v1)) && (Intrinsics.areEqual(v1, v2_1))) {
                GraphicsAttemptLog v0_1 = this.audit;
                if(v0_1 != null) {
                    String v8 = this.getIdentity();
                    if(v1 != null) {
                        v0_1.backend(v8, ((Number)v1).intValue());
                        return;
                    }
                    else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                else {
                    return;
                }
            }
        }

        throw new IllegalStateException("UID del canal gráfico no acreditado: " + this.getIdentity() + ", salida=" + StringsKt.take(v0.getOut(), 80) + ", error=" + StringsKt.take(v0.getError(), 120).toString());
    }

    public void write(String arg9, GraphicsValue arg10) {
        Intrinsics.checkNotNullParameter(arg9, "key");
        Intrinsics.checkNotNullParameter(arg10, "value");
        String v0 = "game:";
        int v2 = 2;
        Object v3 = null;
        String v6 = " ";
        if(StringsKt.startsWith$default(arg9, v0, false, v2, v3)) {
            arg9 = StringsKt.removePrefix(arg9, ((CharSequence)v0));
            if(arg10.getPresent()) {
                String[] v0_1 = new String[4];
                v0_1[0] = "standard";
                v0_1[1] = "performance";
                v0_1[v2] = "battery";
                v0_1[3] = "custom";
                if((SetsKt.setOf(((Object[])v0_1)).contains(arg10.getText())) && (this.gameModes(arg9).getSecond().contains(arg10.getText()))) {
                    arg9 = "cmd game mode --user " + this.getUser() + v6 + arg10.getText() + v6 + GoldenGraphicsBackend.Companion.quote$app(arg9);
                    goto label_117;
                }

                throw new IllegalStateException("Check failed.");
            }
            else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        else {
            char v1 = ':';
            if(GoldenGraphicsBackend.props.contains(arg9)) {
                if(arg10.getPresent()) {
                    arg9 = "setprop " + StringsKt.substringAfter$default(arg9, v1, ((String)v3), v2, v3) + v6 + GoldenGraphicsBackend.Companion.quote$app(arg10.getText());
                    goto label_117;
                }

                throw new IllegalStateException("Android no permite eliminar con seguridad una propiedad creada desde cero".toString());
            }

            if(!GoldenGraphicsBackend.settings.contains(arg9)) {
                goto label_154;
            }

            String v4 = "settings --user ";
            if(arg10.getPresent()) {
                arg9 = v4 + this.getUser() + " put " + StringsKt.substringBefore$default(arg9, v1, ((String)v3), v2, v3) + v6 + StringsKt.substringAfter$default(arg9, v1, ((String)v3), v2, v3) + v6 + GoldenGraphicsBackend.Companion.quote$app(arg10.getText());
                goto label_117;
            }

            arg9 = v4 + this.getUser() + " delete " + StringsKt.substringBefore$default(arg9, v1, ((String)v3), v2, v3) + v6 + StringsKt.substringAfter$default(arg9, v1, ((String)v3), v2, v3);
        }

    label_117:
        GraphicsResponse v8 = this.run(arg9);
        if(v8.getExit() == 0 && (StringsKt.isBlank(v8.getError())) && !StringsKt.contains(v8.getOut(), "not supported", true) && !StringsKt.contains(v8.getOut(), "error", true)) {
            return;
        }

        throw new IllegalStateException("Comando rechazado (" + v8.getExit() + "): " + StringsKt.take(v8.getError() + v8.getOut(), 300).toString());
    label_154:
        throw new IllegalStateException("Operación no permitida".toString());
    }
}

