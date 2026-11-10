package com.TryJeanPc.goldenmouse.graphics;

import android.content.Context;
import android.util.AtomicFile;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001A\u00020\tJ\n\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0016J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000BH\u0016J\b\u0010\u000F\u001A\u00020\rH\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsJournal;", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecordStore;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Landroid/util/AtomicFile;", "hasPending", "", "read", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "write", "", "record", "clear", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsJournal implements GraphicsRecordStore {
    @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\bJ\u0015\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u000B¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsJournal$Companion;", "", "<init>", "()V", "decode", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "raw", "", "decode$app", "encode", "record", "encode$app", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final GraphicsRecord decode$app(String arg29) {
            Map v26;
            Iterator v0_5;
            IntRange v0_4;
            Set v0_3;
            int v8_1;
            String v8;
            String v12;
            String v11;
            String v10;
            String v0 = arg29;
            Intrinsics.checkNotNullParameter(v0, "raw");
            byte[] v1 = v0.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
            if(v1.length <= 0x20000) {
                JSONObject v1_1 = new JSONObject(v0);
                int v0_1 = v1_1.getInt("schema");
                String v3 = "Check failed.";
                if(1 <= v0_1) {
                    int v4 = 4;
                    if(v0_1 < v4) {
                        JSONArray v0_2 = v1_1.getJSONArray("changes");
                        int v5 = v0_2.length();
                        if(1 <= v5 && v5 < 17) {
                            boolean v6 = false;
                            IntRange v5_1 = RangesKt.until(0, v0_2.length());
                            ArrayList v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v5_1), 10));
                            Iterator v5_2 = ((Iterable)v5_1).iterator();
                            while(true) {
                                v10 = "present";
                                v11 = "key";
                                v12 = "getString(...)";
                                if(!v5_2.hasNext()) {
                                    break;
                                }

                                JSONObject v9 = v0_2.getJSONObject(v5_2.nextInt());
                                v11 = v9.getString(v11);
                                Intrinsics.checkNotNullExpressionValue(v11, v12);
                                boolean v10_1 = v9.getBoolean(v10);
                                String v15 = v9.getString("before");
                                Intrinsics.checkNotNullExpressionValue(v15, v12);
                                GraphicsValue v14 = new GraphicsValue(v10_1, v15);
                                boolean v15_1 = v9.getBoolean("afterPresent");
                                v8 = v9.getString("after");
                                Intrinsics.checkNotNullExpressionValue(v8, v12);
                                ((Collection)v7).add(new GraphicsChange(v11, v14, new GraphicsValue(v15_1, v8)));
                            }

                            ArrayList v22 = v7;
                            String v19 = v1_1.getString("pkg");
                            v0 = "packages";
                            v7 = null;
                            v0_2 = v1_1.has(v0) ? v1_1.getJSONArray(v0) : ((JSONArray)v7);
                            if(v0_2 != null) {
                                v5 = v0_2.length();
                                if(1 <= v5 && v5 < 65) {
                                    goto label_80;
                                }

                                throw new IllegalStateException(v3);
                            }

                        label_80:
                            String v5_3 = "textureFeatures";
                            JSONArray v5_4 = v1_1.has(v5_3) ? v1_1.getJSONArray(v5_3) : ((JSONArray)v7);
                            if(v5_4 != null) {
                                v8_1 = v5_4.length();
                                if(1 <= v8_1 && v8_1 < v4) {
                                    goto label_94;
                                }

                                throw new IllegalStateException(v3);
                            }

                        label_94:
                            String v2 = "previous";
                            JSONArray v2_1 = v1_1.has(v2) ? v1_1.getJSONArray(v2) : ((JSONArray)v7);
                            if(v2_1 != null) {
                                v8_1 = v2_1.length();
                                if(v8_1 >= 0 && v8_1 < v4) {
                                    goto label_108;
                                }

                                throw new IllegalStateException(v3);
                            }

                        label_108:
                            v3 = v1_1.getString("session");
                            Intrinsics.checkNotNullExpressionValue(v3, v12);
                            int v18 = v1_1.getInt("user");
                            Intrinsics.checkNotNull(v19);
                            String v4_1 = v1_1.getString("backend");
                            Intrinsics.checkNotNullExpressionValue(v4_1, v12);
                            v8 = v1_1.getString("boot");
                            Intrinsics.checkNotNullExpressionValue(v8, v12);
                            boolean v23 = v1_1.getBoolean("uncertain");
                            if(v0_2 == null) {
                                v0_3 = SetsKt.setOf(v19);
                            }
                            else {
                                IntRange v9_1 = RangesKt.until(0, v0_2.length());
                                ArrayList v13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9_1), 10));
                                Iterator v9_2 = ((Iterable)v9_1).iterator();
                                while(v9_2.hasNext()) {
                                    ((Collection)v13).add(v0_2.getString(v9_2.nextInt()));
                                }

                                v0_3 = CollectionsKt.toSet(((Iterable)v13));
                            }

                            Set v24 = v0_3;
                            if(v5_4 != null) {
                                v0_4 = RangesKt.until(0, v5_4.length());
                                v7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_4), 10));
                                v0_5 = ((Iterable)v0_4).iterator();
                                while(v0_5.hasNext()) {
                                    ((Collection)v7).add(v5_4.getString(v0_5.nextInt()));
                                }
                            }

                            ArrayList v25 = v7;
                            if(v2_1 == null) {
                                v26 = MapsKt.emptyMap();
                            }
                            else {
                                v0_4 = RangesKt.until(0, v2_1.length());
                                LinkedHashMap v5_5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v0_4), 10)), 16));
                                v0_5 = ((Iterable)v0_4).iterator();
                                while(v0_5.hasNext()) {
                                    JSONObject v7_1 = v2_1.getJSONObject(v0_5.nextInt());
                                    String v9_3 = v7_1.getString(v11);
                                    boolean v14_1 = v7_1.getBoolean(v10);
                                    String v7_2 = v7_1.getString("text");
                                    Intrinsics.checkNotNullExpressionValue(v7_2, v12);
                                    Pair v7_3 = TuplesKt.to(v9_3, new GraphicsValue(v14_1, v7_2));
                                    ((Map)v5_5).put(v7_3.getFirst(), v7_3.getSecond());
                                }

                                LinkedHashMap v26_1 = v5_5;
                            }

                            v0 = "automatic";
                            if(v1_1.has(v0)) {
                                v6 = v1_1.getBoolean(v0);
                            }

                            return new GraphicsRecord(v3, v18, v19, v4_1, v8, ((List)v22), v23, v24, ((List)v25), v26, v6);
                        }

                        throw new IllegalStateException(v3);
                    }
                }

                throw new IllegalStateException(v3);
            }

            throw new IllegalStateException("Journal excede el límite".toString());
        }

        public final String encode$app(GraphicsRecord arg8) {
            String v3;
            String v2;
            Intrinsics.checkNotNullParameter(arg8, "record");
            JSONArray v7 = new JSONArray();
            Iterator v0 = arg8.getChanges().iterator();
            while(true) {
                v2 = "present";
                v3 = "key";
                if(!v0.hasNext()) {
                    break;
                }

                Object v1 = v0.next();
                v7.put(new JSONObject().put(v3, ((GraphicsChange)v1).getKey()).put(v2, ((GraphicsChange)v1).getBefore().getPresent()).put("before", ((GraphicsChange)v1).getBefore().getText()).put("afterPresent", ((GraphicsChange)v1).getAfter().getPresent()).put("after", ((GraphicsChange)v1).getAfter().getText()));
            }

            JSONArray v0_1 = new JSONArray();
            Iterator v1_1 = arg8.getPrevious().entrySet().iterator();
            while(v1_1.hasNext()) {
                Object v4 = v1_1.next();
                Object v5 = ((Map$Entry)v4).getKey();
                v4 = ((Map$Entry)v4).getValue();
                v0_1.put(new JSONObject().put(v3, v5).put(v2, ((GraphicsValue)v4).getPresent()).put("text", ((GraphicsValue)v4).getText()));
            }

            JSONObject v7_1 = new JSONObject().put("schema", 3).put("automatic", arg8.getAutomatic()).put("session", arg8.getSession()).put("user", arg8.getUser()).put("pkg", arg8.getPkg()).put("backend", arg8.getBackend()).put("boot", arg8.getBoot()).put("uncertain", arg8.getUncertain()).put("changes", v7).put("packages", new JSONArray(CollectionsKt.toList(arg8.getPackages()))).put("previous", v0_1);
            List v8 = arg8.getTextureFeatures();
            if(v8 != null) {
                v7_1.put("textureFeatures", new JSONArray(((Collection)v8)));
            }

            String v7_2 = v7_1.toString();
            Intrinsics.checkNotNullExpressionValue(v7_2, "toString(...)");
            byte[] v8_1 = v7_2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v8_1, "getBytes(...)");
            if(v8_1.length <= 0x20000) {
                return v7_2;
            }

            throw new IllegalStateException("Journal excede el límite".toString());
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final AtomicFile file;

    static {
        GraphicsJournal.Companion = new Companion(null);
        GraphicsJournal.$stable = 8;
    }

    public GraphicsJournal(Context arg4) {
        Intrinsics.checkNotNullParameter(arg4, "context");
        super();
        this.file = new AtomicFile(new File(arg4.getNoBackupFilesDir(), "golden_graphics_journal_v1.json"));
    }

    public void clear() {
        this.file.delete();
        if(!this.file.getBaseFile().exists() && !new File(this.file.getBaseFile().getPath() + ".bak").exists()) {
            return;
        }

        throw new IllegalStateException("No se pudo retirar el journal restaurado".toString());
    }

    public final boolean hasPending() {
        if(!this.file.getBaseFile().exists()) {
            if(new File(this.file.getBaseFile().getPath() + ".bak").exists()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public GraphicsRecord read() {
        if(!this.hasPending()) {
            return null;
        }

        Companion v0 = GraphicsJournal.Companion;
        byte[] v3 = this.file.readFully();
        Intrinsics.checkNotNullExpressionValue(v3, "readFully(...)");
        return v0.decode$app(new String(v3, Charsets.UTF_8));
    }

    public void write(GraphicsRecord arg2) {
        Intrinsics.checkNotNullParameter(arg2, "record");
        byte[] v2 = GraphicsJournal.Companion.encode$app(arg2).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
        FileOutputStream v0 = this.file.startWrite();
        try {
            v0.write(v2);
            this.file.finishWrite(v0);
            return;
        }
        catch(Exception v2_1) {
            this.file.failWrite(v0);
            throw v2_1;
        }
    }
}

