package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BJ$\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u0010J(\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0012\u001A\u00020\u0013J\u0010\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0010H\u0002J@\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\r2\b\b\u0002\u0010\u0012\u001A\u00020\u0013J&\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\u00072\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0002J8\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0018\u0010\u001D\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001F0\u001EJ\u0017\u0010!\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\b\"J(\u0010#\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\t2\u0018\u0010\u001D\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001F0\u001EJ(\u0010$\u001A\u00020\u00132\u0006\u0010\b\u001A\u00020\t2\u0018\u0010\u001D\u001A\u0014\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001F0\u001EJ\u000E\u0010%\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsSession;", "", "store", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecordStore;", "<init>", "(Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecordStore;)V", "validate", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "access", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;", "pkg", "", "plan", "", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsChange;", "profile", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "configure", "automatic", "", "sharedTexture", "p", "apply", "changes", "textureFeatures", "commit", "record", "prepareAutomatic", "", "pids", "Lkotlin/Function1;", "", "", "checkRecovery", "checkRecovery$app", "recoverForLaunch", "recoverIfIdle", "restore", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsSession {
    public static final int $stable = 8;
    private final GraphicsRecordStore store;

    static {
    }

    public GraphicsSession(GraphicsRecordStore arg2) {
        Intrinsics.checkNotNullParameter(arg2, "store");
        super();
        this.store = arg2;
    }

    public final String apply(GraphicsAccess arg17, String arg18, List arg19, List arg20, boolean arg21) {
        String v0_2;
        String v5;
        GraphicsSession v1 = this;
        GraphicsAccess v0 = arg17;
        List v8 = arg19;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "access");
            v5 = arg18;
            Intrinsics.checkNotNullParameter(v5, "pkg");
            Intrinsics.checkNotNullParameter(v8, "changes");
            if(!GraphicsProfileKt.validGraphicsPackage(v5)) {
                goto label_79;
            }

            if(v1.store.read() != null) {
                goto label_74;
            }

            ArrayList v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v8, 10));
            Iterator v2 = v8.iterator();
            while(v2.hasNext()) {
                ((Collection)v3).add(v2.next().getKey());
            }

            if(CollectionsKt.distinct(((Iterable)v3)).size() != v8.size()) {
                goto label_70;
            }

            if(!v8.isEmpty()) {
                goto label_37;
            }

            v0_2 = "Sin cambios externos solicitados";
        }
        catch(Throwable v0_1) {
            goto label_85;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_37:
            String v3_1 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(v3_1, "toString(...)");
            GraphicsRecord v2_1 = new GraphicsRecord(v3_1, v0.getUser(), v5, v0.getIdentity(), v0.boot(), v8, false, null, arg20, null, arg21, 704, null);
            ArrayList v4 = new ArrayList();
            Iterator v3_2 = arg19.iterator();
            goto label_57;
        label_70:
            throw new IllegalStateException("Check failed.");
        label_57:
            while(v3_2.hasNext()) {
                Object v5_1 = v3_2.next();
                if(Intrinsics.areEqual(v5_1.getBefore(), v5_1.getAfter())) {
                    continue;
                }

                ((Collection)v4).add(v5_1);
            }

            v0_2 = v1.commit(v0, v2_1, ((List)v4));
        }
        catch(Throwable v0_1) {
            goto label_85;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_74:
            throw new IllegalStateException("Restaura la sesión pendiente antes de aplicar otra configuración".toString());
        label_79:
            throw new IllegalArgumentException("Failed requirement.".toString());
        label_85:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_85;
        }

        throw v0_1;
    }

    public static String apply$default(GraphicsSession arg6, GraphicsAccess arg7, String arg8, List arg9, List arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 8) != 0) {
            arg10 = null;
        }

        return arg6.apply(arg7, arg8, arg9, arg10, false);
    }

    public final GraphicsRecord checkRecovery$app(GraphicsAccess arg3) {
        Intrinsics.checkNotNullParameter(arg3, "access");
        GraphicsRecord v2 = this.store.read();
        if(v2 == null) {
            return null;
        }

        if(v2.getUser() == arg3.getUser()) {
            if(Intrinsics.areEqual(v2.getBackend(), arg3.getIdentity())) {
                if(!v2.getUncertain()) {
                    if(Intrinsics.areEqual(v2.getBoot(), arg3.boot())) {
                        return v2;
                    }

                    throw new IllegalStateException("Recuperación pendiente: arranque distinto; reconciliación de originales necesaria".toString());
                }

                throw new IllegalStateException("Recuperación pendiente: resultado remoto incierto; journal conservado".toString());
            }

            throw new IllegalStateException("Recuperación pendiente: usa el backend original " + v2.getBackend() + "; journal conservado".toString());
        }

        throw new IllegalStateException("Recuperación pendiente: usuario distinto al original; journal conservado".toString());
    }

    private final String commit(GraphicsAccess arg20, GraphicsRecord arg21, List arg22) {
        Object v3;
        GraphicsSession v1 = this;
        GraphicsAccess v0 = arg20;
        Iterator v2 = arg22.iterator();
        while(true) {
            if(!v2.hasNext()) {
                goto label_23;
            }

            v3 = v2.next();
            if(!Intrinsics.areEqual(v0.read(((GraphicsChange)v3).getKey()), ((GraphicsChange)v3).getBefore())) {
                break;
            }
        }

        throw new IllegalStateException("El original cambió: " + ((GraphicsChange)v3).getKey().toString());
    label_23:
        v1.store.write(GraphicsRecord.copy$default(arg21, null, 0, null, null, null, null, true, null, null, null, false, 0x7BF, null));
        try {
            v2 = arg22.iterator();
            while(true) {
                if(!v2.hasNext()) {
                    goto label_81;
                }

                v3 = v2.next();
                if(!Intrinsics.areEqual(v0.read(((GraphicsChange)v3).getKey()), ((GraphicsChange)v3).getBefore())) {
                    goto label_70;
                }

                v0.write(((GraphicsChange)v3).getKey(), ((GraphicsChange)v3).getAfter());
                if(!Intrinsics.areEqual(v0.read(((GraphicsChange)v3).getKey()), ((GraphicsChange)v3).getAfter())) {
                    break;
                }
            }

            throw new IllegalStateException("No se confirmó " + ((GraphicsChange)v3).getKey().toString());
        label_70:
            throw new IllegalStateException("Conflicto antes de escribir " + ((GraphicsChange)v3).getKey().toString());
        label_81:
            List v2_1 = arg21.getChanges();
            if(!(v2_1 instanceof Collection) || !v2_1.isEmpty()) {
                v2 = ((Iterable)v2_1).iterator();
                while(true) {
                    if(v2.hasNext()) {
                        v3 = v2.next();
                        if(Intrinsics.areEqual(v0.read(((GraphicsChange)v3).getKey()), ((GraphicsChange)v3).getAfter())) {
                            continue;
                        }
                        else {
                            break;
                        }
                    }

                    goto label_103;
                }

                throw new IllegalStateException("La configuración cambió durante la aplicación; journal conservado".toString());
            }
            else {
            }
        }
        catch(Exception v0_1) {
            goto label_160;
        }

    label_103:
        v1.store.write(GraphicsRecord.copy$default(arg21, null, 0, null, null, null, null, false, null, null, MapsKt.emptyMap(), false, 0x5FF, null));
        String v0_2 = arg21.getTextureFeatures() != null ? " Textura GLOBAL compartida: " + CollectionsKt.joinToString$default(arg21.getPackages(), null, null, null, 0, null, null, 0x3F, null) + ". Otras apps ANGLE también pueden recibir el efecto; restauración conjunta." : "";
        int v1_1 = arg22.size();
        String v2_2 = arg21.getAutomatic() ? "Recuperación automática." : "Restauración manual.";
        return "CONFIGURADO, EFECTO NO VERIFICADO · " + v1_1 + " valores confirmados. " + v2_2 + v0_2;
    label_160:
        if(!(v0_1 instanceof GraphicsUncertain)) {
            v1.store.write(arg21);
        }

        throw v0_1;
    }

    public final String configure(GraphicsAccess arg27, String arg28, GraphicsProfile arg29, boolean arg30) {
        GraphicsValue v5_2;
        Object v6;
        String v0_2;
        List v7;
        GraphicsRecord v12;
        List v11;
        GraphicsSession v1 = this;
        GraphicsAccess v2 = arg27;
        String v3 = arg28;
        GraphicsProfile v0 = arg29;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v2, "access");
            Intrinsics.checkNotNullParameter(v3, "pkg");
            Intrinsics.checkNotNullParameter(v0, "profile");
            v11 = this.plan(arg27, arg28, arg29);
            v12 = v1.store.read();
            v7 = null;
            List v5 = v1.sharedTexture(v0) ? v0.features() : v7;
            if(v12 != null) {
                goto label_27;
            }

            v0_2 = v1.apply(v2, v3, v11, v5, arg30);
        }
        catch(Throwable v0_1) {
            goto label_148;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_27:
            if((Intrinsics.areEqual(v12.getChanges(), v11)) && (v12.getPackages().contains(v3))) {
                if((arg30) && !v12.getAutomatic()) {
                    v1.store.write(GraphicsRecord.copy$default(v12, null, 0, null, null, null, null, false, null, null, null, true, 0x3FF, null));
                }

                v0_2 = "CONFIGURACIÓN VIGENTE CONFIRMADA · efecto visual no verificado.";
                goto label_53;
            }

            goto label_55;
        }
        catch(Throwable v0_1) {
            goto label_148;
        }

    label_53:
        __monitor_exit(this);
        return v0_2;
        try {
        label_55:
            if(v12.getTextureFeatures() != null && (Intrinsics.areEqual(v5, v12.getTextureFeatures()))) {
                ArrayList v4 = new ArrayList();
                Iterator v0_3 = v11.iterator();
                while(v0_3.hasNext()) {
                    Object v13 = v0_3.next();
                    Iterator v5_1 = v12.getChanges().iterator();
                    do {
                        if(v5_1.hasNext()) {
                            v6 = v5_1.next();
                            if(!Intrinsics.areEqual(v6.getKey(), ((GraphicsChange)v13).getKey())) {
                                continue;
                            }

                            break;
                        }
                        else {
                            goto label_79;
                        }
                    }
                    while(true);

                    goto label_80;
                label_79:
                    v6 = v7;
                label_80:
                    if(v6 != null) {
                        v5_2 = ((GraphicsChange)v6).getAfter();
                        if(v5_2 == null) {
                            goto label_83;
                        }
                    }
                    else {
                    label_83:
                        v5_2 = ((GraphicsChange)v13).getBefore();
                    }

                    GraphicsValue v15 = v5_2;
                    GraphicsChange v5_3 = Intrinsics.areEqual(v15, ((GraphicsChange)v13).getAfter()) ? ((GraphicsChange)v7) : GraphicsChange.copy$default(((GraphicsChange)v13), null, v15, null, 5, null);
                    if(v5_3 == null) {
                        continue;
                    }

                    ((Collection)v4).add(v5_3);
                }

                Set v13_1 = SetsKt.plus(v12.getPackages(), v3);
                LinkedHashMap v15_1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(v4, 10)), 16));
                v0_3 = v4.iterator();
                while(v0_3.hasNext()) {
                    Object v3_1 = v0_3.next();
                    Pair v3_2 = TuplesKt.to(((GraphicsChange)v3_1).getKey(), ((GraphicsChange)v3_1).getBefore());
                    ((Map)v15_1).put(v3_2.getFirst(), v3_2.getSecond());
                }

                boolean v0_4 = (v12.getAutomatic()) || (arg30) ? true : false;
                v0_2 = v1.commit(v2, GraphicsRecord.copy$default(v12, null, 0, null, null, null, v11, false, v13_1, null, ((Map)v15_1), v0_4, 0x15F, null), ((List)v4));
                goto label_140;
            }

            goto label_142;
        }
        catch(Throwable v0_1) {
            goto label_148;
        }

    label_140:
        __monitor_exit(this);
        return v0_2;
        try {
        label_142:
            throw new IllegalStateException("Restaura la sesión antes de cambiar el perfil".toString());
        label_148:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_148;
        }

        throw v0_1;
    }

    public static String configure$default(GraphicsSession arg0, GraphicsAccess arg1, String arg2, GraphicsProfile arg3, boolean arg4, int arg5, Object arg6) {
        return arg0.configure(arg1, arg2, arg3, false);
    }

    public final List plan(GraphicsAccess arg22, String arg23, GraphicsProfile arg24) {
        GraphicsValue v5_7;
        Pair v1_4;
        Pair v5_6;
        Object v3_2;
        Object v4_2;
        GraphicsValue v6_2;
        Object v6_1;
        Object v5_2;
        Iterator v1_2;
        LinkedHashMap v6;
        List v0_1;
        String v14;
        GraphicsAccess v0 = arg22;
        String v1 = arg23;
        GraphicsProfile v2 = arg24;
        Intrinsics.checkNotNullParameter(v0, "access");
        Intrinsics.checkNotNullParameter(v1, "pkg");
        Intrinsics.checkNotNullParameter(v2, "profile");
        GraphicsRecord v3 = this.validate(arg22, arg23);
        GraphicsSession$plan$original$1 v4 = new GraphicsSession$plan$original$1(v0, v3);
        List v5 = v3 != null ? v3.getTextureFeatures() : null;
        if(v5 != null && (this.sharedTexture(v2))) {
            if(Intrinsics.areEqual(v3.getTextureFeatures(), v2.features())) {
                v5 = v3.getChanges();
                int v8 = 2;
                String v9 = "global:angle_gl_driver_selection_values";
                String v11 = "global:angle_gl_driver_selection_pkgs";
                int v12 = 16;
                int v13 = 10;
                if(!(v5 instanceof Collection) || !v5.isEmpty()) {
                    Iterator v5_1 = ((Iterable)v5).iterator();
                    do {
                        if(v5_1.hasNext()) {
                            v14 = "global:angle_egl_features";
                            if(!Intrinsics.areEqual(v5_1.next().getKey(), v14)) {
                                continue;
                            }

                            break;
                        }

                        goto label_159;
                    }
                    while(true);

                    v0_1 = GraphicsPlan.INSTANCE.build(v0, v1, v2);
                    List v1_1 = v3.getChanges();
                    v6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v1_1), v13)), v12));
                    v1_2 = ((Iterable)v1_1).iterator();
                    while(v1_2.hasNext()) {
                        v5_2 = v1_2.next();
                        ((Map)v6).put(v5_2.getKey(), v5_2);
                    }

                    Map v1_3 = MapsKt.toMutableMap(((Map)v6));
                    Iterator v0_2 = ((Iterable)v0_1).iterator();
                    while(v0_2.hasNext()) {
                        Object v15 = v0_2.next();
                        String v5_3 = ((GraphicsChange)v15).getKey();
                        v6_1 = v1_3.get(((GraphicsChange)v15).getKey());
                        if(v6_1 != null) {
                            v6_2 = ((GraphicsChange)v6_1).getBefore();
                            if(v6_2 == null) {
                                goto label_74;
                            }
                        }
                        else {
                        label_74:
                            v6_2 = ((GraphicsChange)v15).getBefore();
                        }

                        v1_3.put(v5_3, GraphicsChange.copy$default(((GraphicsChange)v15), null, v6_2, null, 5, null));
                    }

                    v0_1 = GraphicsPlan.INSTANCE.build(((GraphicsAccess)v4), v3.getPkg(), v2);
                    String[] v2_1 = new String[3];
                    v2_1[0] = v11;
                    v2_1[1] = v9;
                    v2_1[v8] = v14;
                    Set v2_2 = SetsKt.setOf(((Object[])v2_1));
                    ArrayList v4_1 = new ArrayList();
                    v0_2 = ((Iterable)v0_1).iterator();
                    while(v0_2.hasNext()) {
                        v5_2 = v0_2.next();
                        if(v2_2.contains(v5_2.getKey())) {
                            continue;
                        }

                        ((Collection)v4_1).add(v5_2);
                    }

                    LinkedHashMap v5_4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v4_1), v13)), v12));
                    v0_2 = ((Iterable)v4_1).iterator();
                    while(v0_2.hasNext()) {
                        v4_2 = v0_2.next();
                        Pair v4_3 = TuplesKt.to(((GraphicsChange)v4_2).getKey(), ((GraphicsChange)v4_2).getAfter());
                        ((Map)v5_4).put(v4_3.getFirst(), v4_3.getSecond());
                    }

                    v0_1 = v3.getChanges();
                    ArrayList v3_1 = new ArrayList();
                    v0_2 = ((Iterable)v0_1).iterator();
                    while(v0_2.hasNext()) {
                        v4_2 = v0_2.next();
                        if(v2_2.contains(v4_2.getKey())) {
                            continue;
                        }

                        ((Collection)v3_1).add(v4_2);
                    }

                    LinkedHashMap v2_3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v3_1), v13)), v12));
                    v0_2 = ((Iterable)v3_1).iterator();
                    while(v0_2.hasNext()) {
                        v3_2 = v0_2.next();
                        Pair v3_3 = TuplesKt.to(((GraphicsChange)v3_2).getKey(), ((GraphicsChange)v3_2).getAfter());
                        ((Map)v2_3).put(v3_3.getFirst(), v3_3.getSecond());
                    }

                    if(Intrinsics.areEqual(v5_4, v2_3)) {
                        return CollectionsKt.toList(v1_3.values());
                    }

                    throw new IllegalStateException("Opciones globales incompatibles con la sesión compartida".toString());
                }
                else {
                }

            label_159:
                List v2_4 = GraphicsPlan.INSTANCE.build(((GraphicsAccess)v4), v1, v2);
                String[] v4_4 = new String[v8];
                v4_4[0] = v11;
                v4_4[1] = v9;
                Set v4_5 = SetsKt.setOf(((Object[])v4_4));
                ArrayList v5_5 = new ArrayList();
                Iterator v2_5 = ((Iterable)v2_4).iterator();
                while(v2_5.hasNext()) {
                    v6_1 = v2_5.next();
                    if(v4_5.contains(v6_1.getKey())) {
                        continue;
                    }

                    ((Collection)v5_5).add(v6_1);
                }

                v6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v5_5), v13)), v12));
                v2_5 = ((Iterable)v5_5).iterator();
                while(v2_5.hasNext()) {
                    v5_2 = v2_5.next();
                    v5_6 = TuplesKt.to(((GraphicsChange)v5_2).getKey(), ((GraphicsChange)v5_2).getAfter());
                    ((Map)v6).put(v5_6.getFirst(), v5_6.getSecond());
                }

                v2_4 = v3.getChanges();
                v5_5 = new ArrayList();
                v2_5 = ((Iterable)v2_4).iterator();
                while(v2_5.hasNext()) {
                    Object v14_1 = v2_5.next();
                    if(v4_5.contains(v14_1.getKey())) {
                        continue;
                    }

                    ((Collection)v5_5).add(v14_1);
                }

                LinkedHashMap v4_6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v5_5), v13)), v12));
                v2_5 = ((Iterable)v5_5).iterator();
                while(v2_5.hasNext()) {
                    v5_2 = v2_5.next();
                    v5_6 = TuplesKt.to(((GraphicsChange)v5_2).getKey(), ((GraphicsChange)v5_2).getAfter());
                    ((Map)v4_6).put(v5_6.getFirst(), v5_6.getSecond());
                }

                if(Intrinsics.areEqual(v6, v4_6)) {
                    v1_4 = GraphicsPlan.INSTANCE.angleLists(v0.read(v11).getText(), v0.read(v9).getText(), v1);
                    v2_4 = v3.getChanges();
                    v4_6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_4), v13)), v12));
                    v2_5 = ((Iterable)v2_4).iterator();
                }
                else {
                    throw new IllegalStateException("La sesión compartida tiene otras opciones distintas; restaura antes de cambiar la configuración global".toString());
                }

                while(v2_5.hasNext()) {
                    v3_2 = v2_5.next();
                    ((Map)v4_6).put(v3_2.getKey(), v3_2);
                }

                Map v2_6 = MapsKt.toMutableMap(((Map)v4_6));
                Pair[] v3_4 = new Pair[v8];
                v3_4[0] = TuplesKt.to(v11, v1_4.getFirst());
                v3_4[1] = TuplesKt.to(v9, v1_4.getSecond());
                v1_2 = CollectionsKt.listOf(((Object[])v3_4)).iterator();
                while(v1_2.hasNext()) {
                    v3_2 = v1_2.next();
                    v4_2 = ((Pair)v3_2).component1();
                    v3_2 = ((Pair)v3_2).component2();
                    v5_2 = v2_6.get(v4_2);
                    if(v5_2 != null) {
                        v5_7 = ((GraphicsChange)v5_2).getBefore();
                        if(v5_7 == null) {
                            goto label_263;
                        }
                    }
                    else {
                    label_263:
                        v5_7 = v0.read(((String)v4_2));
                    }

                    v6_2 = new GraphicsValue(true, ((String)v3_2));
                    if(Intrinsics.areEqual(v5_7, v6_2)) {
                        continue;
                    }

                    v2_6.put(v4_2, new GraphicsChange(((String)v4_2), v5_7, v6_2));
                }

                return CollectionsKt.toList(v2_6.values());
            }
            else {
                throw new IllegalStateException("La textura es global: la sesión usa " + v3.getTextureFeatures() + ". Restaura todos los juegos antes de cambiar LOD/filtros.".toString());
            }
        }

        v0_1 = GraphicsPlan.INSTANCE.build(((GraphicsAccess)v4), v1, v2);
        if(v3 != null) {
            if(Intrinsics.areEqual(v3.getChanges(), v0_1)) {
            }
            else {
                throw new IllegalStateException("El perfil cambió; restaura la sesión antes de aplicar el nuevo".toString());
            }
        }

        return v0_1;
    }

    public final void prepareAutomatic(GraphicsAccess arg3, String arg4, GraphicsProfile arg5, Function1 arg6) {
        GraphicsRecord v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg3, "access");
            Intrinsics.checkNotNullParameter(arg4, "pkg");
            Intrinsics.checkNotNullParameter(arg5, "profile");
            Intrinsics.checkNotNullParameter(arg6, "pids");
            v0 = this.store.read();
            if(v0 != null) {
                goto label_14;
            }
        }
        catch(Throwable v3) {
            goto label_60;
        }

        __monitor_exit(this);
        return;
        try {
        label_14:
            if(!v0.getAutomatic() && v0.getTextureFeatures() == null) {
                goto label_18;
            }

            goto label_20;
        }
        catch(Throwable v3) {
            goto label_60;
        }

    label_18:
        __monitor_exit(this);
        return;
        try {
        label_20:
            if(!arg6.invoke(arg4).isEmpty()) {
                goto label_54;
            }

            Set v4 = v0.getPackages();
            if(!(v4 instanceof Collection) || !v4.isEmpty()) {
                Iterator v4_1 = ((Iterable)v4).iterator();
                do {
                    if(v4_1.hasNext()) {
                        if(arg6.invoke(v4_1.next()).isEmpty()) {
                            continue;
                        }

                        break;
                    }
                    else {
                        goto label_51;
                    }
                }
                while(true);

                List v3_1 = v0.getTextureFeatures();
                List v4_2 = arg5.features();
                if(arg5.getTextureRequested()) {
                }
                else {
                    Object v4_3 = null;
                }

                if(Intrinsics.areEqual(v3_1, v4_3)) {
                    goto label_52;
                }

                throw new IllegalStateException("LOD y filtros globales compartidos: primero termina los otros juegos de la sesión. Se conserva su configuración.".toString());
            label_51:
                this.restore(arg3);
            }
            else {
                goto label_51;
            }
        }
        catch(Throwable v3) {
            goto label_60;
        }

    label_52:
        __monitor_exit(this);
        return;
        try {
        label_54:
            throw new IllegalStateException("Confirma el reinicio antes de cambiar la sesión de textura".toString());
        label_60:
            __monitor_exit(this);
        }
        catch(Throwable v3) {
            goto label_60;
        }

        throw v3;
    }

    public final String recoverForLaunch(GraphicsAccess arg10, Function1 arg11) {
        Throwable v10_1;
        ArrayList v1;
        String v10;
        GraphicsRecord v0_1;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg10, "access");
            Intrinsics.checkNotNullParameter(arg11, "pids");
            v0_1 = this.checkRecovery$app(arg10);
            if(v0_1 != null) {
                goto label_10;
            }

            v10 = "Sin recuperación pendiente";
        }
        catch(Throwable v0) {
            goto label_61;
        }

        __monitor_exit(this);
        return v10;
        try {
        label_10:
            if(!v0_1.getAutomatic()) {
                if(v0_1.getTextureFeatures() != null) {
                }
                else {
                    throw new IllegalStateException("Sesión gráfica independiente: conserva su recuperación original".toString());
                }
            }

            Set v0_2 = v0_1.getPackages();
            v1 = new ArrayList();
            Iterator v0_3 = ((Iterable)v0_2).iterator();
            while(v0_3.hasNext()) {
                Object v2 = v0_3.next();
                if(arg11.invoke(v2).isEmpty()) {
                    continue;
                }

                ((Collection)v1).add(v2);
            }

            if(!((List)v1).isEmpty()) {
                goto label_38;
            }

            v10 = this.restore(arg10);
        }
        catch(Throwable v0) {
            goto label_61;
        }

        __monitor_exit(this);
        return v10;
        try {
        label_38:
            throw new IllegalStateException("Recuperación pendiente: siguen activos " + CollectionsKt.joinToString$default(v1, null, null, null, 0, null, null, 0x3F, null) + "; termina esos juegos para recuperar sus originales con seguridad. No se aplicó textura.".toString());
        label_61:
            v10_1 = v0;
            __monitor_exit(this);
        }
        catch(Throwable v0) {
            goto label_61;
        }

        throw v10_1;
    }

    public final boolean recoverIfIdle(GraphicsAccess arg5, Function1 arg6) {
        GraphicsRecord v0;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(arg5, "access");
            Intrinsics.checkNotNullParameter(arg6, "pids");
            v0 = this.store.read();
            if(v0 != null && (v0.getAutomatic())) {
                v0 = this.checkRecovery$app(arg5);
                if(v0 == null) {
                    goto label_14;
                }
                else {
                    goto label_16;
                }
            }

            goto label_35;
        }
        catch(Throwable v5) {
            goto label_38;
        }

    label_14:
        __monitor_exit(this);
        return 0;
        try {
        label_16:
            Set v0_1 = v0.getPackages();
            if(!(v0_1 instanceof Collection) || !v0_1.isEmpty()) {
                Iterator v0_2 = ((Iterable)v0_1).iterator();
                do {
                    if(v0_2.hasNext()) {
                        if(arg6.invoke(v0_2.next()).isEmpty()) {
                            continue;
                        }

                        goto label_30;
                    }

                    goto label_32;
                }
                while(true);
            }
            else {
            }

            goto label_32;
        }
        catch(Throwable v5) {
            goto label_38;
        }

    label_30:
        __monitor_exit(this);
        return 0;
        try {
        label_32:
            this.restore(arg5);
        }
        catch(Throwable v5) {
            try {
            label_38:
                __monitor_exit(this);
            }
            catch(Throwable v5) {
                goto label_38;
            }

            throw v5;
        }

        __monitor_exit(this);
        return 1;
    label_35:
        __monitor_exit(this);
        return 0;
    }

    public final String restore(GraphicsAccess arg18) {
        GraphicsValue v5;
        Object v4;
        String v0_2;
        GraphicsRecord v3;
        GraphicsSession v1 = this;
        GraphicsAccess v0 = arg18;
        __monitor_enter(this);
        try {
            Intrinsics.checkNotNullParameter(v0, "access");
            v3 = v1.store.read();
            if(v3 != null) {
                goto label_11;
            }

            v0_2 = "Sin intervención pendiente";
        }
        catch(Throwable v0_1) {
            goto label_170;
        }

        __monitor_exit(this);
        return v0_2;
        try {
        label_11:
            if(v3.getUser() == v0.getUser() && (Intrinsics.areEqual(v3.getBackend(), v0.getIdentity()))) {
                if(v3.getUncertain()) {
                    goto label_159;
                }
                else if(Intrinsics.areEqual(v3.getBoot(), v0.boot())) {
                    Iterator v2 = v3.getChanges().iterator();
                    while(true) {
                        if(v2.hasNext()) {
                            v4 = v2.next();
                            v5 = v0.read(((GraphicsChange)v4).getKey());
                            if(Intrinsics.areEqual(v5, ((GraphicsChange)v4).getBefore())) {
                                continue;
                            }

                            if(Intrinsics.areEqual(v5, ((GraphicsChange)v4).getAfter())) {
                                continue;
                            }

                            if(Intrinsics.areEqual(v5, v3.getPrevious().get(((GraphicsChange)v4).getKey()))) {
                                continue;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            goto label_56;
                        }

                        goto label_164;
                    }

                    throw new IllegalStateException("Conflicto externo en " + ((GraphicsChange)v4).getKey() + "; no se sobrescribe. Restauración pendiente.".toString());
                label_56:
                    v1.store.write(GraphicsRecord.copy$default(v3, null, 0, null, null, null, null, true, null, null, null, false, 0x7BF, null));
                    try {
                        v2 = CollectionsKt.asReversed(v3.getChanges()).iterator();
                        while(true) {
                            if(v2.hasNext()) {
                                v4 = v2.next();
                                v5 = v0.read(((GraphicsChange)v4).getKey());
                                if(Intrinsics.areEqual(v5, ((GraphicsChange)v4).getBefore())) {
                                    continue;
                                }

                                if(!Intrinsics.areEqual(v5, ((GraphicsChange)v4).getAfter())) {
                                    if(Intrinsics.areEqual(v5, v3.getPrevious().get(((GraphicsChange)v4).getKey()))) {
                                    }
                                    else {
                                        throw new IllegalStateException("Conflicto externo en " + ((GraphicsChange)v4).getKey() + "; no se sobrescribe. Restauración pendiente.".toString());
                                    }
                                }

                                v0.write(((GraphicsChange)v4).getKey(), ((GraphicsChange)v4).getBefore());
                                if(!Intrinsics.areEqual(v0.read(((GraphicsChange)v4).getKey()), ((GraphicsChange)v4).getBefore())) {
                                    break;
                                }

                                continue;
                            }
                            else {
                                goto label_125;
                            }
                        }

                        throw new IllegalStateException("Restauración no confirmada: " + ((GraphicsChange)v4).getKey().toString());
                    label_125:
                        v2 = v3.getChanges().iterator();
                        while(true) {
                            if(!v2.hasNext()) {
                                goto label_141;
                            }

                            v4 = v2.next();
                            if(!Intrinsics.areEqual(v0.read(((GraphicsChange)v4).getKey()), ((GraphicsChange)v4).getBefore())) {
                                break;
                            }
                        }

                        throw new IllegalStateException("Estado cambió durante restauración".toString());
                    }
                    catch(Exception v0_3) {
                        goto label_149;
                    }

                label_141:
                    v1.store.write(v3);
                    v1.store.clear();
                    v0_2 = "RESTAURADO · valores anteriores confirmados";
                    goto label_146;
                }
                else {
                    goto label_154;
                }
            }

            goto label_164;
        }
        catch(Throwable v0_1) {
            goto label_170;
        }

    label_146:
        __monitor_exit(this);
        return v0_2;
        try {
        label_149:
            if(!(v0_3 instanceof GraphicsUncertain)) {
                v1.store.write(v3);
            }

            throw v0_3;
        label_154:
            throw new IllegalStateException("Arranque distinto: requiere reconciliación de originales; journal conservado".toString());
        label_159:
            throw new IllegalStateException("Resultado incierto: falta acreditar el fin de la operación remota. Journal conservado.".toString());
        label_164:
            throw new IllegalStateException("Usa el mismo usuario y backend de la sesión".toString());
        label_170:
            __monitor_exit(this);
        }
        catch(Throwable v0_1) {
            goto label_170;
        }

        throw v0_1;
    }

    private final boolean sharedTexture(GraphicsProfile arg1) {
        if((arg1.getTextureRequested()) && arg1.getDriver() != 1) {
            return 1;
        }

        return 0;
    }

    public final GraphicsRecord validate(GraphicsAccess arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg3, "access");
        Intrinsics.checkNotNullParameter(arg4, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(arg4)) {
            GraphicsRecord v2 = this.store.read();
            if(v2 == null) {
                return null;
            }

            if(((Intrinsics.areEqual(v2.getPkg(), arg4)) || v2.getTextureFeatures() != null) && (v2.getUser() == arg3.getUser() && (Intrinsics.areEqual(v2.getBackend(), arg3.getIdentity())))) {
                if(!v2.getUncertain() && (Intrinsics.areEqual(v2.getBoot(), arg3.boot()))) {
                    if(v2.getPrevious().isEmpty()) {
                        List v4 = v2.getChanges();
                        if(((v4 instanceof Collection)) && (v4.isEmpty())) {
                            return v2;
                        }

                        Iterator v4_1 = ((Iterable)v4).iterator();
                        while(true) {
                            if(!v4_1.hasNext()) {
                                return v2;
                            }

                            Object v0 = v4_1.next();
                            if(!Intrinsics.areEqual(arg3.read(((GraphicsChange)v0).getKey()), ((GraphicsChange)v0).getAfter())) {
                                break;
                            }
                        }

                        throw new IllegalStateException("La configuración cambió por otro actor; journal conservado".toString());
                        return v2;
                    }
                    else {
                        throw new IllegalStateException("Ampliación incompleta de la sesión global; restaura antes de continuar".toString());
                    }
                }

                throw new IllegalStateException("Sesión incierta o de otro arranque; recuperación pendiente".toString());
            }

            throw new IllegalStateException("Restaura la sesión pendiente de " + v2.getPkg() + " con su usuario y backend originales".toString());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

