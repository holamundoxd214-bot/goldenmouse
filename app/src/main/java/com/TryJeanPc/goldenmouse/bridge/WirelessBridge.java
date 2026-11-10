package com.TryJeanPc.goldenmouse.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.nsd.NsdServiceInfo;
import android.os.Build$VERSION;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001BB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\nJ\u000E\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rJ\u0018\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\rH\u0086@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\rH\u0086@¢\u0006\u0002\u0010\u0010J\u000E\u0010\u0012\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rJ\u000E\u0010\u0013\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rJ \u0010\u0014\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\u0005H\u0002J\u0012\u0010\u0018\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001A\u00020\u001AH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001C"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/WirelessBridge;", "", "<init>", "()V", "PAIRING_SERVICE", "", "CONNECT_SERVICE", "DISCOVERY_TIMEOUT_MS", "", "esCompatible", "", "permisoRedLocalConcedido", "context", "Landroid/content/Context;", "descubrirEndpointEmparejamiento", "Lcom/TryJeanPc/goldenmouse/bridge/WirelessBridge$Endpoint;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "descubrirEndpointConexion", "abrirEmparejamiento", "abrirCodigoVinculacion", "descubrirEndpoint", "serviceType", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeServiceType", "resolvedHost", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "Endpoint", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WirelessBridge {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0014"}, d2={"Lcom/TryJeanPc/goldenmouse/bridge/WirelessBridge$Endpoint;", "", "host", "", "port", "", "<init>", "(Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "getPort", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Endpoint {
        public static final int $stable;
        private final String host;
        private final int port;

        static {
        }

        public Endpoint(String arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "host");
            super();
            this.host = arg2;
            this.port = arg3;
        }

        public final String component1() {
            return this.host;
        }

        public final int component2() {
            return this.port;
        }

        public final Endpoint copy(String arg1, int arg2) {
            Intrinsics.checkNotNullParameter(arg1, "host");
            return new Endpoint(arg1, arg2);
        }

        public static Endpoint copy$default(Endpoint arg0, String arg1, int arg2, int arg3, Object arg4) {
            if((arg3 & 1) != 0) {
                arg1 = arg0.host;
            }

            if((arg3 & 2) != 0) {
                arg2 = arg0.port;
            }

            return arg0.copy(arg1, arg2);
        }

        public boolean equals(Object arg5) {
            if(this == (((Endpoint)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Endpoint)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.host, ((Endpoint)arg5).host)) {
                return 0;
            }

            if(this.port != ((Endpoint)arg5).port) {
                return 0;
            }

            return 1;
        }

        public final String getHost() {
            return this.host;
        }

        public final int getPort() {
            return this.port;
        }

        public int hashCode() {
            return this.host.hashCode() * 0x1F + Integer.hashCode(this.port);
        }

        public String toString() {
            return "Endpoint(host=" + this.host + ", port=" + this.port + ")";
        }
    }

    public static final int $stable = 0;
    private static final String CONNECT_SERVICE = "_adb-tls-connect._tcp.";
    private static final long DISCOVERY_TIMEOUT_MS = 12000;
    public static final WirelessBridge INSTANCE = null;
    private static final String PAIRING_SERVICE = "_adb-tls-pairing._tcp.";

    static {
        WirelessBridge.INSTANCE = new WirelessBridge();
    }

    private WirelessBridge() {
        super();
    }

    public final boolean abrirCodigoVinculacion(Context arg5) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        Iterator v4 = CollectionsKt.listOf(new String[]{"android.settings.WIRELESS_DEBUGGING_PAIRING_SETTINGS", "android.settings.WIRELESS_DEBUGGING_SETTINGS", "android.settings.APPLICATION_DEVELOPMENT_SETTINGS"}).iterator();
    label_15:
        if(v4.hasNext()) {
            Object v0 = v4.next();
            try {
                Intent v3 = new Intent(((String)v0));
                v3.addFlags(0x10000000);
                arg5.startActivity(v3);
                return 1;
            }
            catch(Exception ) {
                goto label_15;
            }
        }

        return 0;
    }

    public final boolean abrirEmparejamiento(Context arg5) {
        Intrinsics.checkNotNullParameter(arg5, "context");
        Iterator v4 = CollectionsKt.listOf(new String[]{"android.settings.WIRELESS_DEBUGGING_SETTINGS", "android.settings.APPLICATION_DEVELOPMENT_SETTINGS"}).iterator();
    label_12:
        if(v4.hasNext()) {
            Object v0 = v4.next();
            try {
                arg5.startActivity(new Intent(((String)v0)));
                return 1;
            }
            catch(Exception ) {
                goto label_12;
            }
        }

        return 0;
    }

    public static final Object access$descubrirEndpoint(WirelessBridge arg0, Context arg1, String arg2, Continuation arg3) {
        return arg0.descubrirEndpoint(arg1, arg2, arg3);
    }

    public static final String access$normalizeServiceType(WirelessBridge arg0, String arg1) {
        return arg0.normalizeServiceType(arg1);
    }

    public static final String access$resolvedHost(WirelessBridge arg0, NsdServiceInfo arg1) {
        return arg0.resolvedHost(arg1);
    }

    private final Object descubrirEndpoint(Context arg2, String arg3, Continuation arg4) {
        Object v0 = null;
        if(!this.permisoRedLocalConcedido(arg2)) {
            return v0;
        }

        return TimeoutKt.withTimeoutOrNull(12000, new WirelessBridge$descubrirEndpoint$2(arg2, arg3, ((Continuation)v0)), arg4);
    }

    public final Object descubrirEndpointConexion(Context arg2, Continuation arg3) {
        return this.descubrirEndpoint(arg2, "_adb-tls-connect._tcp.", arg3);
    }

    public final Object descubrirEndpointEmparejamiento(Context arg2, Continuation arg3) {
        return this.descubrirEndpoint(arg2, "_adb-tls-pairing._tcp.", arg3);
    }

    public final boolean esCompatible() {
        if(Build$VERSION.SDK_INT >= 30) {
            return 1;
        }

        return 0;
    }

    private final String normalizeServiceType(String arg3) {
        String v2 = StringsKt.trimEnd(StringsKt.trim(((CharSequence)arg3)).toString(), new char[]{'.'}).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v2, "toLowerCase(...)");
        return v2;
    }

    public final boolean permisoRedLocalConcedido(Context arg2) {
        Intrinsics.checkNotNullParameter(arg2, "context");
        if(Build$VERSION.SDK_INT >= 37) {
            if(arg2.checkSelfPermission("android.permission.ACCESS_LOCAL_NETWORK") == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private final String resolvedHost(NsdServiceInfo arg2) {
        Object v1_1;
        if(Build$VERSION.SDK_INT >= 34) {
            List v1 = arg2.getHostAddresses();
            Intrinsics.checkNotNullExpressionValue(v1, "getHostAddresses(...)");
            v1_1 = CollectionsKt.firstOrNull(v1);
        }
        else {
            InetAddress v1_2 = arg2.getHost();
        }

        if(v1_1 != null) {
            return ((InetAddress)v1_1).getHostAddress();
        }

        return null;
    }
}

