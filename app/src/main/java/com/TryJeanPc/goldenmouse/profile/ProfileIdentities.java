package com.TryJeanPc.goldenmouse.profile;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\f\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001A\u00020\bJ\u0014\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00060\u000B2\u0006\u0010\t\u001A\u00020\bJ\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FJ\u001C\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00062\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00060\u0013J\u001A\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001A\u00020\u0006J\u0016\u0010\u0018\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u0006J\u000E\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0006J\u000E\u0010\u001B\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u0006J\u001A\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u00012\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001J\u0012\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00060\u000B*\u00020\bH\u0002J&\u0010!\u001A\u0004\u0018\u00010\u00012\b\u0010\"\u001A\u0004\u0018\u00010\u00012\b\u0010#\u001A\u0004\u0018\u00010\u00012\b\u0010$\u001A\u0004\u0018\u00010\u0001J>\u0010%\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\b2\u0006\u0010&\u001A\u00020\b2\u000E\u0010\'\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00052\u000E\u0010(\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0005R\u0014\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/ProfileIdentities;", "", "<init>", "()V", "collections", "", "", "entries", "Lorg/json/JSONObject;", "root", "conflicts", "", "requireUnique", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "fresh", "type", "used", "", "repair", "Lkotlin/Pair;", "", "json", "verifyRepair", "repaired", "checksum", "requireLosslessNumbers", "same", "", "a", "b", "keySetCompat", "merge", "raw", "before", "after", "editorSnapshot", "pending", "controlOrigins", "visualOrigins", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class ProfileIdentities {
    public static final int $stable;
    public static final ProfileIdentities INSTANCE;
    private static final List collections;

    static {
        ProfileIdentities.INSTANCE = new ProfileIdentities();
        ProfileIdentities.collections = CollectionsKt.listOf(new String[]{"controls", "visualControls"});
        ProfileIdentities.$stable = 8;
    }

    private ProfileIdentities() {
        super();
    }

    public final String checksum(String arg11) {
        Intrinsics.checkNotNullParameter(arg11, "json");
        MessageDigest v10 = MessageDigest.getInstance("SHA-256");
        byte[] v11 = arg11.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v11, "getBytes(...)");
        byte[] v1 = v10.digest(v11);
        Intrinsics.checkNotNullExpressionValue(v1, "digest(...)");
        return ArraysKt.joinToString$default(v1, "", null, null, 0, null, new ProfileIdentities$$ExternalSyntheticLambda0(), 30, null);
    }

    static final CharSequence checksum$lambda$25(byte arg1) {
        String v1 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(arg1)}, 1));
        Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
        return ((CharSequence)v1);
    }

    public final Set conflicts(JSONObject arg4) {
        Intrinsics.checkNotNullParameter(arg4, "root");
        List v3 = this.entries(arg4);
        ArrayList v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), 10));
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            ((Collection)v4).add(v3_1.next().optString("id"));
        }

        Map v3_2 = GroupingKt.eachCount(new ProfileIdentities$conflicts$$inlined$groupingBy$1(((Iterable)v4)));
        LinkedHashMap v4_1 = new LinkedHashMap();
        v3_1 = v3_2.entrySet().iterator();
        while(v3_1.hasNext()) {
            Object v0 = v3_1.next();
            Object v1 = ((Map$Entry)v0).getKey();
            int v2 = ((Map$Entry)v0).getValue().intValue();
            Intrinsics.checkNotNull(v1);
            if(!StringsKt.isBlank(((CharSequence)v1)) && v2 <= 1) {
                continue;
            }

            ((Map)v4_1).put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }

        return ((Map)v4_1).keySet();
    }

    public final String editorSnapshot(String arg17, JSONObject arg18, JSONObject arg19, List arg20, List arg21) {
        JSONObject v1 = arg18;
        JSONObject v2 = arg19;
        Intrinsics.checkNotNullParameter(arg17, "raw");
        Intrinsics.checkNotNullParameter(v1, "before");
        Intrinsics.checkNotNullParameter(v2, "pending");
        Intrinsics.checkNotNullParameter(arg20, "controlOrigins");
        Intrinsics.checkNotNullParameter(arg21, "visualOrigins");
        JSONObject v5 = new JSONObject(arg17);
        List v0 = ProfileIdentities.collections;
        List[] v6 = new List[2];
        int v7 = 0;
        v6[0] = arg20;
        v6[1] = arg21;
        Iterator v0_1 = CollectionsKt.zip(((Iterable)v0), CollectionsKt.listOf(((Object[])v6))).iterator();
        while(true) {
            if(!v0_1.hasNext()) {
                goto label_99;
            }

            Object v3 = v0_1.next();
            Object v4 = ((Pair)v3).component1();
            v3 = ((Pair)v3).component2();
            JSONArray v6_1 = v5.optJSONArray(((String)v4));
            if(v6_1 == null) {
                v6_1 = new JSONArray();
            }

            JSONArray v8 = v1.optJSONArray(((String)v4));
            if(v8 == null) {
                v8 = new JSONArray();
            }

            JSONArray v9 = v2.optJSONArray(((String)v4));
            if(v9 == null) {
                v9 = new JSONArray();
            }

            if(v6_1.length() == v8.length() && v9.length() == ((List)v3).size() && (Intrinsics.areEqual(CollectionsKt.sorted(CollectionsKt.filterNotNull(v3)), CollectionsKt.toList(RangesKt.until(v7, v6_1.length()))))) {
                JSONArray v10 = new JSONArray();
                int v11 = v6_1.length();
                int v12;
                for(v12 = v7; v12 < v11; ++v12) {
                    v10.put(ProfileIdentities.INSTANCE.merge(v6_1.get(v12), v8.get(v12), v9.get(((List)v3).indexOf(Integer.valueOf(v12)))));
                }

                Iterator v3_1 = ((Iterable)v3).iterator();
                int v6_2;
                for(v6_2 = 0; v3_1.hasNext(); v6_2 = v8_1) {
                    Object v7_1 = v3_1.next();
                    int v8_1 = v6_2 + 1;
                    if(v6_2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }

                    if(v7_1 == null) {
                        v10.put(v9.get(v6_2));
                    }
                }

                if((v5.has(((String)v4))) || v10.length() != 0) {
                    v5.put(((String)v4), v10);
                }

                v7 = 0;
                continue;
            }

            break;
        }

        throw new IllegalArgumentException("No se pueden asociar todos los controles originales a la edición pendiente".toString());
    label_99:
        String v0_2 = v5.toString();
        Intrinsics.checkNotNullExpressionValue(v0_2, "toString(...)");
        return v0_2;
    }

    public final List entries(JSONObject arg7) {
        Intrinsics.checkNotNullParameter(arg7, "root");
        List v6 = ProfileIdentities.collections;
        ArrayList v0 = new ArrayList();
        Iterator v6_1 = ((Iterable)v6).iterator();
        while(v6_1.hasNext()) {
            JSONArray v1 = arg7.optJSONArray(v6_1.next());
            if(v1 == null) {
                v1 = new JSONArray();
            }

            int v2 = v1.length();
            ArrayList v3 = new ArrayList(v2);
            int v4;
            for(v4 = 0; v4 < v2; ++v4) {
                v3.add(v1.getJSONObject(v4));
            }

            CollectionsKt.addAll(((Collection)v0), ((Iterable)v3));
        }

        return ((List)v0);
    }

    public final String fresh(String arg3, Collection arg4) {
        String v2;
        Intrinsics.checkNotNullParameter(arg3, "type");
        Intrinsics.checkNotNullParameter(arg4, "used");
        do {
            v2 = arg3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v2, "toLowerCase(...)");
            v2 = v2 + "-" + UUID.randomUUID();
        }
        while(arg4.contains(v2));

        return v2;
    }

    private final Set keySetCompat(JSONObject arg1) {
        Iterator v0 = arg1.keys();
        Intrinsics.checkNotNullExpressionValue(v0, "keys(...)");
        return SequencesKt.toSet(SequencesKt.asSequence(v0));
    }

    public final Object merge(Object arg19, Object arg20, Object arg21) {
        Integer v12_1;
        JSONObject v12;
        Iterator v11_1;
        IntRange v11;
        Object v10;
        Object v6;
        Object v5;
        ProfileIdentities v0 = this;
        Object v1 = arg19;
        Object v2 = arg20;
        Object v3 = arg21;
        if(v0.same(v2, v3)) {
            return v1;
        }

        if(((v2 instanceof JSONObject)) && ((v3 instanceof JSONObject))) {
            v5 = (v1 instanceof JSONObject) ? v1 : null;
            JSONObject v1_1 = v5 != null ? new JSONObject(((JSONObject)v5).toString()) : new JSONObject();
            Iterator v0_1 = SetsKt.plus(v0.keySetCompat(((JSONObject)v2)), v0.keySetCompat(((JSONObject)v3))).iterator();
            while(v0_1.hasNext()) {
                Object v4 = v0_1.next();
                if(!((JSONObject)v3).has(((String)v4))) {
                    v1_1.remove(((String)v4));
                    continue;
                }

                if(!((JSONObject)v2).has(((String)v4))) {
                    v1_1.put(((String)v4), ((JSONObject)v3).get(((String)v4)));
                    continue;
                }

                v1_1.put(((String)v4), ProfileIdentities.INSTANCE.merge(v1_1.opt(((String)v4)), ((JSONObject)v2).get(((String)v4)), ((JSONObject)v3).get(((String)v4))));
            }

            return v1_1;
        }

        if(((v1 instanceof JSONArray)) && ((v2 instanceof JSONArray)) && ((v3 instanceof JSONArray))) {
            String[] v4_1 = new String[2];
            int v7 = 0;
            v4_1[0] = "id";
            v4_1[1] = "slot";
            Iterator v4_2 = CollectionsKt.listOf(((Object[])v4_1)).iterator();
            do {
            label_62:
                if(v4_2.hasNext()) {
                    v6 = v4_2.next();
                    Object v9 = v6;
                    v10 = v2;
                    v11 = RangesKt.until(0, ((JSONArray)v10).length());
                    if(!(v11 instanceof Collection) || !v11.isEmpty()) {
                        v11_1 = ((Iterable)v11).iterator();
                        while(true) {
                        label_76:
                            if(v11_1.hasNext()) {
                                v12 = ((JSONArray)v10).optJSONObject(v11_1.nextInt());
                                if(v12 == null) {
                                    goto label_62;
                                }

                                if(!v12.has(((String)v9))) {
                                    goto label_62;
                                }

                                goto label_84;
                            }

                            goto label_85;
                        }
                    }
                    else {
                    }

                    goto label_85;
                }
                else {
                    goto label_104;
                }
            }
            while(true);

        label_84:
            goto label_76;
        label_85:
            v10 = v3;
            v11 = RangesKt.until(0, ((JSONArray)v10).length());
            if(!(v11 instanceof Collection) || !v11.isEmpty()) {
                v11_1 = ((Iterable)v11).iterator();
                while(true) {
                    if(!v11_1.hasNext()) {
                        goto label_105;
                    }

                    v12 = ((JSONArray)v10).optJSONObject(v11_1.nextInt());
                    if(v12 == null) {
                        goto label_62;
                    }

                    if(!v12.has(((String)v9))) {
                        goto label_62;
                    }
                }

            label_104:
                v6 = null;
            }

        label_105:
            JSONArray v4_3 = new JSONArray();
            int v9_1 = ((JSONArray)v3).length();
            int v10_1 = 0;
            while(v10_1 < v9_1) {
                Object v11_2 = ((JSONArray)v3).get(v10_1);
                if(v6 == null) {
                    v12_1 = Integer.valueOf(v10_1);
                    v12_1.intValue();
                    if(v2.length() == ((JSONArray)v3).length()) {
                    }
                    else {
                        v12_1 = null;
                    }
                }
                else {
                    Object v12_2 = v2;
                    Iterator v13 = RangesKt.until(v7, ((JSONArray)v12_2).length()).iterator();
                    int v14 = v7;
                    Object v15 = null;
                    while(true) {
                        if(v13.hasNext()) {
                            Object v16 = v13.next();
                            v5 = ((JSONArray)v12_2).getJSONObject(v16.intValue()).get(((String)v6));
                            Intrinsics.checkNotNull(v11_2, "null cannot be cast to non-null type org.json.JSONObject");
                            if(!Intrinsics.areEqual(v5, v11_2.get(((String)v6)))) {
                                continue;
                            }

                            if(v14 != 0) {
                                goto label_148;
                            }
                            else {
                                v14 = 1;
                                v15 = v16;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_149;
                    }

                    if(v14 == 0) {
                    label_148:
                        v15 = null;
                    }

                label_149:
                    v12_2 = v15;
                }

                if(v12_1 == null) {
                }
                else {
                    v11_2 = v0.merge(v1.opt(v12_1.intValue()), v2.get(v12_1.intValue()), v11_2);
                }

                v4_3.put(v11_2);
                ++v10_1;
                v7 = 0;
            }

            return v4_3;
        }

        return v3;
    }

    public final Pair repair(String arg11) {
        String v6_1;
        Object v5;
        Intrinsics.checkNotNullParameter(arg11, "json");
        this.requireLosslessNumbers(arg11);
        JSONObject v0 = new JSONObject(arg11);
        Set v1 = this.conflicts(v0);
        int v3 = 0;
        if(v1.isEmpty()) {
            return TuplesKt.to(arg11, Integer.valueOf(0));
        }

        List v2 = this.entries(v0);
        ArrayList v4 = new ArrayList();
        Iterator v1_1 = ((Iterable)v1).iterator();
        while(v1_1.hasNext()) {
            v5 = v1_1.next();
            if(StringsKt.isBlank(v5)) {
                continue;
            }

            ((Collection)v4).add(v5);
        }

        int v5_1 = 10;
        ArrayList v1_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v4), v5_1));
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            ((Collection)v1_2).add(new Regex("(?<![\\p{L}\\p{N}_-])" + Regex.Companion.escape(v4_1.next()) + "(?![\\p{L}\\p{N}_-])"));
        }

        v4_1 = v0.keys();
        Intrinsics.checkNotNullExpressionValue(v4_1, "keys(...)");
        while(v4_1.hasNext()) {
            Object v6 = v4_1.next();
            Intrinsics.checkNotNull(v6);
            ProfileIdentities.repair$requireUnambiguous(((List)v1_2), ((String)v6));
            if(ProfileIdentities.collections.contains(v6)) {
                continue;
            }

            ProfileIdentities.repair$checkReferences$default(((List)v1_2), v0.get(((String)v6)), false, 4, null);
        }

        v4_1 = ((Iterable)v2).iterator();
        while(v4_1.hasNext()) {
            ProfileIdentities.repair$checkReferences(((List)v1_2), v4_1.next(), true);
        }

        v1_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2), v5_1));
        v4_1 = ((Iterable)v2).iterator();
        while(true) {
            v6_1 = "id";
            if(!v4_1.hasNext()) {
                break;
            }

            ((Collection)v1_2).add(v4_1.next().optString(v6_1));
        }

        v1 = CollectionsKt.toMutableSet(((Iterable)v1_2));
        LinkedHashSet v4_2 = new LinkedHashSet();
        Iterator v2_1 = ((Iterable)v2).iterator();
        while(v2_1.hasNext()) {
            v5 = v2_1.next();
            String v7 = ((JSONObject)v5).optString(v6_1);
            Intrinsics.checkNotNull(v7);
            if(!StringsKt.isBlank(v7) && (((Set)v4_2).add(v7))) {
                continue;
            }

            ProfileIdentities v7_1 = ProfileIdentities.INSTANCE;
            String v8 = ((JSONObject)v5).optString("type", "control");
            Intrinsics.checkNotNullExpressionValue(v8, "optString(...)");
            v7 = v7_1.fresh(v8, v1);
            v1.add(v7);
            ((JSONObject)v5).put(v6_1, v7);
            ++v3;
        }

        if(this.conflicts(v0).isEmpty()) {
            String v1_3 = v0.toString();
            Intrinsics.checkNotNullExpressionValue(v1_3, "toString(...)");
            this.verifyRepair(arg11, v1_3);
            String v10 = v0.toString();
            Intrinsics.checkNotNullExpressionValue(v10, "toString(...)");
            return TuplesKt.to(v10, Integer.valueOf(v3));
        }

        throw new IllegalStateException("Check failed.");
    }

    private static final void repair$checkReferences(List arg6, Object arg7, boolean arg8) {
        Object v1 = null;
        int v2 = 4;
        if((arg7 instanceof JSONObject)) {
            Iterator v0 = ((JSONObject)arg7).keys();
            Intrinsics.checkNotNullExpressionValue(v0, "keys(...)");
            while(v0.hasNext()) {
                Object v4 = v0.next();
                Intrinsics.checkNotNull(v4);
                ProfileIdentities.repair$requireUnambiguous(arg6, ((String)v4));
                if((arg8) && (Intrinsics.areEqual(v4, "id"))) {
                    continue;
                }

                ProfileIdentities.repair$checkReferences$default(arg6, ((JSONObject)arg7).opt(((String)v4)), false, v2, v1);
            }
        }
        else {
            if((arg7 instanceof JSONArray)) {
                int v8 = ((JSONArray)arg7).length();
                int v0_1;
                for(v0_1 = 0; true; ++v0_1) {
                    if(v0_1 >= v8) {
                        return;
                    }

                    ProfileIdentities.repair$checkReferences$default(arg6, ((JSONArray)arg7).get(v0_1), false, v2, v1);
                }
            }

            if(!(arg7 instanceof String)) {
                return;
            }

            ProfileIdentities.repair$requireUnambiguous(arg6, ((String)arg7));
        }
    }

    static void repair$checkReferences$default(List arg0, Object arg1, boolean arg2, int arg3, Object arg4) {
        ProfileIdentities.repair$checkReferences(arg0, arg1, false);
    }

    private static final void repair$requireUnambiguous(List arg2, String arg3) {
        if(((arg2 instanceof Collection)) && (arg2.isEmpty())) {
            return;
        }

        Iterator v2 = ((Iterable)arg2).iterator();
        while(true) {
            if(!v2.hasNext()) {
                return;
            }

            if(v2.next().containsMatchIn(arg3)) {
                break;
            }
        }

        throw new IllegalArgumentException("Referencia ambigua a un ID repetido; no se modificó el perfil".toString());
    }

    public final void requireLosslessNumbers(String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "json");
        Iterator v4 = SequencesKt.mapNotNull(Regex.findAll$default(new Regex("\"(?:\\\\.|[^\"\\\\])*\"|(-?\\d+(?:\\.\\d+)?(?:[eE][+-]?\\d+)?)"), ((CharSequence)arg5), 0, 2, null), new ProfileIdentities$$ExternalSyntheticLambda1()).iterator();
        while(true) {
            if(!v4.hasNext()) {
                return;
            }

            Object v5 = v4.next();
            Object v0 = new JSONArray("[" + (((String)v5)) + "]").get(0);
            if(((v0 instanceof Number)) && new BigDecimal(((String)v5)).compareTo(new BigDecimal(((Number)v0).toString())) == 0) {
                continue;
            }

            break;
        }

        throw new IllegalArgumentException("El JSON contiene un número que esta versión no puede conservar exactamente; original protegido".toString());
    }

    static final String requireLosslessNumbers$lambda$26(MatchResult arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        MatchGroup v1 = arg1.getGroups().get(1);
        if(v1 != null) {
            return v1.getValue();
        }

        return null;
    }

    public final void requireUnique(GameProfile arg4) {
        Intrinsics.checkNotNullParameter(arg4, "profile");
        List v3 = arg4.getControls();
        int v1 = 10;
        ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), v1));
        Iterator v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            ((Collection)v0).add(v3_1.next().getId());
        }

        v3 = arg4.getVisualControls();
        ArrayList v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v3), v1));
        v3_1 = ((Iterable)v3).iterator();
        while(v3_1.hasNext()) {
            ((Collection)v4).add(v3_1.next().getId());
        }

        v3 = CollectionsKt.plus(((Collection)v0), ((Iterable)v4));
        List v4_1 = v3;
        if(!(v4_1 instanceof Collection) || !v4_1.isEmpty()) {
            Iterator v0_1 = ((Iterable)v4_1).iterator();
            while(true) {
                if(!v0_1.hasNext()) {
                    break;
                }
                else if(!StringsKt.isBlank(v0_1.next())) {
                    continue;
                }

                goto label_45;
            }

        label_40:
            if(CollectionsKt.distinct(((Iterable)v4_1)).size() == v3.size()) {
                return;
            }
        }
        else {
            goto label_40;
        }

    label_45:
        throw new IllegalArgumentException("IDs de control vacíos o repetidos; confirma la recuperación antes de guardar".toString());
    }

    public final boolean same(Object arg6, Object arg7) {
        Iterator v5_1;
        if(((arg6 instanceof JSONObject)) && ((arg7 instanceof JSONObject))) {
            if(Intrinsics.areEqual(this.keySetCompat(((JSONObject)arg6)), this.keySetCompat(((JSONObject)arg7)))) {
                Set v5 = this.keySetCompat(((JSONObject)arg6));
                if(!(v5 instanceof Collection) || !v5.isEmpty()) {
                    v5_1 = ((Iterable)v5).iterator();
                    do {
                        if(v5_1.hasNext()) {
                            Object v0 = v5_1.next();
                            if(ProfileIdentities.INSTANCE.same(((JSONObject)arg6).get(((String)v0)), ((JSONObject)arg7).get(((String)v0)))) {
                                continue;
                            }

                            return 0;
                        }

                        return 1;
                    }
                    while(true);

                    return 0;
                }
                else {
                }

                return 1;
            }

            return 0;
        }

        if(((arg6 instanceof JSONArray)) && ((arg7 instanceof JSONArray))) {
            if(((JSONArray)arg6).length() == ((JSONArray)arg7).length()) {
                IntRange v5_2 = RangesKt.until(0, ((JSONArray)arg6).length());
                if(!(v5_2 instanceof Collection) || !v5_2.isEmpty()) {
                    v5_1 = ((Iterable)v5_2).iterator();
                    do {
                        if(v5_1.hasNext()) {
                            int v0_1 = v5_1.nextInt();
                            if(ProfileIdentities.INSTANCE.same(((JSONArray)arg6).get(v0_1), ((JSONArray)arg7).get(v0_1))) {
                                continue;
                            }

                            return 0;
                        }

                        return 1;
                    }
                    while(true);

                    return 0;
                }
                else {
                }

                return 1;
            }

            return 0;
        }

        if(((arg6 instanceof Number)) && ((arg7 instanceof Number))) {
            if(new BigDecimal(((Number)arg6).toString()).compareTo(new BigDecimal(((Number)arg7).toString())) == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return Intrinsics.areEqual(arg6, arg7);
    }

    public final int verifyRepair(String arg9, String arg10) {
        String v5;
        Intrinsics.checkNotNullParameter(arg9, "json");
        Intrinsics.checkNotNullParameter(arg10, "repaired");
        JSONObject v0 = new JSONObject(arg9);
        JSONObject v9 = new JSONObject(arg10);
        if(!this.conflicts(v9).isEmpty()) {
            goto label_95;
        }

        List v10 = this.entries(v0);
        List v1 = this.entries(v9);
        if(v10.size() != v1.size()) {
            goto label_90;
        }

        ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10), 10));
        Iterator v3 = ((Iterable)v10).iterator();
        while(true) {
            v5 = "id";
            if(!v3.hasNext()) {
                break;
            }

            ((Collection)v2).add(v3.next().optString(v5));
        }

        Set v2_1 = CollectionsKt.toSet(((Iterable)v2));
        LinkedHashSet v3_1 = new LinkedHashSet();
        Iterator v10_1 = CollectionsKt.zip(((Iterable)v10), ((Iterable)v1)).iterator();
        int v1_1;
        for(v1_1 = 0; true; ++v1_1) {
        label_34:
            if(!v10_1.hasNext()) {
                goto label_66;
            }

            Object v4 = v10_1.next();
            Object v6 = ((Pair)v4).component1();
            v4 = ((Pair)v4).component2();
            String v6_1 = ((JSONObject)v6).optString(v5);
            Intrinsics.checkNotNull(v6_1);
            if(!StringsKt.isBlank(v6_1)) {
                if(!((Set)v3_1).add(v6_1)) {
                }
                else if(Intrinsics.areEqual(v6_1, ((JSONObject)v4).optString(v5))) {
                    goto label_34;
                }
                else {
                    throw new IllegalStateException("Cambió una identidad legítima".toString());
                }
            }

            if(v2_1.contains(((JSONObject)v4).optString(v5))) {
                break;
            }
        }

        throw new IllegalStateException("El ID nuevo ya pertenecía al perfil".toString());
    label_66:
        v10_1 = CollectionsKt.zip(this.entries(v0), this.entries(v9)).iterator();
        while(v10_1.hasNext()) {
            Object v2_2 = v10_1.next();
            Object v3_2 = ((Pair)v2_2).component1();
            v2_2 = ((Pair)v2_2).component2();
            if(((JSONObject)v3_2).has(v5)) {
                ((JSONObject)v2_2).put(v5, ((JSONObject)v3_2).get(v5));
                continue;
            }

            ((JSONObject)v2_2).remove(v5);
        }

        if(this.same(v0, v9)) {
            return v1_1;
        }

        throw new IllegalStateException("La reparación alteraría otros datos".toString());
    label_90:
        throw new IllegalStateException("Cambió la cantidad de controles".toString());
    label_95:
        throw new IllegalStateException("El resultado conserva identidades ambiguas".toString());
    }
}

