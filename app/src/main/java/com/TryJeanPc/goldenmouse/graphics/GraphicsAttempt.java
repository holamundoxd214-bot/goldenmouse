package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b!\b\u0081\b\u0018\u0000 /2\u00020\u0001:\u0001/Bc\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010 \u001A\u00020\u0003J\t\u0010!\u001A\u00020\u0003HÆ\u0003J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0006HÆ\u0003J\t\u0010$\u001A\u00020\u0003HÆ\u0003J\t\u0010%\u001A\u00020\u0003HÆ\u0003J\t\u0010&\u001A\u00020\u0003HÆ\u0003J\t\u0010\'\u001A\u00020\u000BHÆ\u0003J\t\u0010(\u001A\u00020\rHÆ\u0003J\u000F\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00030\u000FHÆ\u0003Ji\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000FHÆ\u0001J\u0013\u0010+\u001A\u00020\r2\b\u0010,\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001A\u00020\u000BHÖ\u0001J\t\u0010.\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001F¨\u00060"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "", "pkg", "", "source", "at", "", "phase", "message", "backend", "uid", "", "saved", "", "events", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;)V", "getPkg", "()Ljava/lang/String;", "getSource", "getAt", "()J", "getPhase", "getMessage", "getBackend", "getUid", "()I", "getSaved", "()Z", "getEvents", "()Ljava/util/List;", "encode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsAttempt {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt$Companion;", "", "<init>", "()V", "decode", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAttempt;", "raw", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GraphicsAttempt decode(String arg12) {
            Intrinsics.checkNotNullParameter(arg12, "raw");
            byte[] v11 = arg12.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v11, "getBytes(...)");
            if(v11.length <= 0x20000) {
                JSONObject v11_1 = new JSONObject(arg12);
                String v1 = v11_1.getString("pkg");
                Intrinsics.checkNotNull(v1);
                if(GraphicsProfileKt.validGraphicsPackage(v1)) {
                    JSONArray v12 = v11_1.getJSONArray("events");
                    if(v12.length() <= 0x30) {
                        String v2 = v11_1.getString("source");
                        Intrinsics.checkNotNullExpressionValue(v2, "getString(...)");
                        long v3 = v11_1.getLong("at");
                        String v5 = v11_1.getString("phase");
                        Intrinsics.checkNotNullExpressionValue(v5, "getString(...)");
                        String v6 = v11_1.getString("message");
                        Intrinsics.checkNotNullExpressionValue(v6, "getString(...)");
                        String v7 = v11_1.getString("backend");
                        Intrinsics.checkNotNullExpressionValue(v7, "getString(...)");
                        int v8 = v11_1.getInt("uid");
                        boolean v9 = v11_1.getBoolean("saved");
                        IntRange v11_2 = RangesKt.until(0, v12.length());
                        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v11_2), 10));
                        Iterator v11_3 = ((Iterable)v11_2).iterator();
                        while(v11_3.hasNext()) {
                            ((Collection)v0).add(v12.getString(v11_3.nextInt()));
                        }

                        return new GraphicsAttempt(v1, v2, v3, v5, v6, v7, v8, v9, v0);
                    }

                    throw new IllegalStateException("Check failed.");
                }

                throw new IllegalArgumentException("Failed requirement.".toString());
            }

            throw new IllegalStateException("Recibo gráfico excedido".toString());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final long at;
    private final String backend;
    private final List events;
    private final String message;
    private final String phase;
    private final String pkg;
    private final boolean saved;
    private final String source;
    private final int uid;

    static {
        GraphicsAttempt.Companion = new Companion(null);
        GraphicsAttempt.$stable = 8;
    }

    public GraphicsAttempt(String arg2, String arg3, long arg4, String arg6, String arg7, String arg8, int arg9, boolean arg10, List arg11) {
        Intrinsics.checkNotNullParameter(arg2, "pkg");
        Intrinsics.checkNotNullParameter(arg3, "source");
        Intrinsics.checkNotNullParameter(arg6, "phase");
        Intrinsics.checkNotNullParameter(arg7, "message");
        Intrinsics.checkNotNullParameter(arg8, "backend");
        Intrinsics.checkNotNullParameter(arg11, "events");
        super();
        this.pkg = arg2;
        this.source = arg3;
        this.at = arg4;
        this.phase = arg6;
        this.message = arg7;
        this.backend = arg8;
        this.uid = arg9;
        this.saved = arg10;
        this.events = arg11;
    }

    public GraphicsAttempt(String arg15, String arg16, long arg17, String arg19, String arg20, String arg21, int arg22, boolean arg23, List arg24, int arg25, DefaultConstructorMarker arg26) {
        int v0 = arg25;
        long v6 = (v0 & 4) != 0 ? System.currentTimeMillis() : arg17;
        String v8 = (v0 & 8) != 0 ? "SOLICITADO" : arg19;
        String v9 = (v0 & 16) != 0 ? "Solicitud registrada; aún sin ejecutar" : arg20;
        String v10 = (v0 & 0x20) != 0 ? "Sin abrir" : arg21;
        int v11 = (v0 & 0x40) != 0 ? -1 : arg22;
        boolean v12 = (v0 & 0x80) != 0 ? false : arg23;
        List v13 = (v0 & 0x100) != 0 ? CollectionsKt.emptyList() : arg24;
        this(arg15, arg16, v6, v8, v9, v10, v11, v12, v13);
    }

    public final String component1() {
        return this.pkg;
    }

    public final String component2() {
        return this.source;
    }

    public final long component3() {
        return this.at;
    }

    public final String component4() {
        return this.phase;
    }

    public final String component5() {
        return this.message;
    }

    public final String component6() {
        return this.backend;
    }

    public final int component7() {
        return this.uid;
    }

    public final boolean component8() {
        return this.saved;
    }

    public final List component9() {
        return this.events;
    }

    public final GraphicsAttempt copy(String arg12, String arg13, long arg14, String arg16, String arg17, String arg18, int arg19, boolean arg20, List arg21) {
        Intrinsics.checkNotNullParameter(arg12, "pkg");
        Intrinsics.checkNotNullParameter(arg13, "source");
        Intrinsics.checkNotNullParameter(arg16, "phase");
        Intrinsics.checkNotNullParameter(arg17, "message");
        Intrinsics.checkNotNullParameter(arg18, "backend");
        Intrinsics.checkNotNullParameter(arg21, "events");
        return new GraphicsAttempt(arg12, arg13, arg14, arg16, arg17, arg18, arg19, arg20, arg21);
    }

    public static GraphicsAttempt copy$default(GraphicsAttempt arg0, String arg1, String arg2, long arg3, String arg5, String arg6, String arg7, int arg8, boolean arg9, List arg10, int arg11, Object arg12) {
        if((arg11 & 1) != 0) {
            arg1 = arg0.pkg;
        }

        if((arg11 & 2) != 0) {
            arg2 = arg0.source;
        }

        if((arg11 & 4) != 0) {
            arg3 = arg0.at;
        }

        if((arg11 & 8) != 0) {
            arg5 = arg0.phase;
        }

        if((arg11 & 16) != 0) {
            arg6 = arg0.message;
        }

        if((arg11 & 0x20) != 0) {
            arg7 = arg0.backend;
        }

        if((arg11 & 0x40) != 0) {
            arg8 = arg0.uid;
        }

        if((arg11 & 0x80) != 0) {
            arg9 = arg0.saved;
        }

        if((arg11 & 0x100) != 0) {
            arg10 = arg0.events;
        }

        return arg0.copy(arg1, arg2, arg3, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public final String encode() {
        String v4 = new JSONObject().put("pkg", this.pkg).put("source", this.source).put("at", this.at).put("phase", this.phase).put("message", this.message).put("backend", this.backend).put("uid", this.uid).put("saved", this.saved).put("events", new JSONArray(this.events)).toString();
        Intrinsics.checkNotNullExpressionValue(v4, "toString(...)");
        return v4;
    }

    public boolean equals(Object arg8) {
        if(this == (((GraphicsAttempt)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof GraphicsAttempt)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.pkg, ((GraphicsAttempt)arg8).pkg)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.source, ((GraphicsAttempt)arg8).source)) {
            return 0;
        }

        if(this.at != ((GraphicsAttempt)arg8).at) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.phase, ((GraphicsAttempt)arg8).phase)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.message, ((GraphicsAttempt)arg8).message)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backend, ((GraphicsAttempt)arg8).backend)) {
            return 0;
        }

        if(this.uid != ((GraphicsAttempt)arg8).uid) {
            return 0;
        }

        if(this.saved != ((GraphicsAttempt)arg8).saved) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.events, ((GraphicsAttempt)arg8).events)) {
            return 0;
        }

        return 1;
    }

    public final long getAt() {
        return this.at;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final List getEvents() {
        return this.events;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPhase() {
        return this.phase;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final boolean getSaved() {
        return this.saved;
    }

    public final String getSource() {
        return this.source;
    }

    public final int getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((this.pkg.hashCode() * 0x1F + this.source.hashCode()) * 0x1F + Long.hashCode(this.at)) * 0x1F + this.phase.hashCode()) * 0x1F + this.message.hashCode()) * 0x1F + this.backend.hashCode()) * 0x1F + Integer.hashCode(this.uid)) * 0x1F + Boolean.hashCode(this.saved)) * 0x1F + this.events.hashCode();
    }

    public String toString() {
        return "GraphicsAttempt(pkg=" + this.pkg + ", source=" + this.source + ", at=" + this.at + ", phase=" + this.phase + ", message=" + this.message + ", backend=" + this.backend + ", uid=" + this.uid + ", saved=" + this.saved + ", events=" + this.events + ")";
    }
}

