package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00072\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00070\nJ*\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007J3\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00072\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00070\nH\u0000¢\u0006\u0002\b\u0014J$\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u001AR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsPlan;", "", "<init>", "()V", "owned", "Lkotlin/text/Regex;", "angleFeatures", "", "old", "requested", "", "angleLists", "Lkotlin/Pair;", "pkgs", "values", "pkg", "eglFeatures", "packages", "existing", "features", "eglFeatures$app", "build", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsChange;", "access", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsAccess;", "p", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsProfile;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsPlan {
    public static final int $stable;
    public static final GraphicsPlan INSTANCE;
    private static final Regex owned;

    static {
        GraphicsPlan.INSTANCE = new GraphicsPlan();
        GraphicsPlan.owned = new Regex("force(nearestfiltering|nearestmipfiltering|texturelodoffset[1-4])");
        GraphicsPlan.$stable = 8;
    }

    private GraphicsPlan() {
        super();
    }

    public final String angleFeatures(String arg11, List arg12) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg11, "old");
        Intrinsics.checkNotNullParameter(arg12, "requested");
        int v0 = 91;
        if(arg11.length() <= v0 && (new Regex("[A-Za-z0-9_:*.-]*").matches(arg11))) {
            List v10 = StringsKt.split$default(arg11, new char[]{':'}, false, 0, 6, null);
            ArrayList v11 = new ArrayList();
            Iterator v10_1 = ((Iterable)v10).iterator();
            while(v10_1.hasNext()) {
                v1 = v10_1.next();
                if(v1.length() <= 0) {
                    continue;
                }

                ((Collection)v11).add(v1);
            }

            ArrayList v10_2 = new ArrayList();
            Iterator v11_1 = ((Iterable)v11).iterator();
            while(v11_1.hasNext()) {
                v1 = v11_1.next();
                Regex v8 = GraphicsPlan.owned;
                String v2 = StringsKt.replace$default(v1, "_", "", false, 4, null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(v2, "toLowerCase(...)");
                if(v8.matches(((CharSequence)v2))) {
                    continue;
                }

                ((Collection)v10_2).add(v1);
            }

            String v10_3 = CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus(((Collection)v10_2), ((Iterable)arg12))), ":", null, null, 0, null, null, 62, null);
            if(v10_3.length() <= v0) {
                return v10_3;
            }
            else {
                throw new IllegalArgumentException("La propiedad ANGLE no admite esta combinación".toString());
            }
        }

        throw new IllegalArgumentException("Features ANGLE anteriores no interpretables".toString());
    }

    public final Pair angleLists(String arg12, String arg13, String arg14) {
        Iterator v13_1;
        ArrayList v12_1;
        ArrayList v11;
        Intrinsics.checkNotNullParameter(arg12, "pkgs");
        Intrinsics.checkNotNullParameter(arg13, "values");
        Intrinsics.checkNotNullParameter(arg14, "pkg");
        if(GraphicsProfileKt.validGraphicsPackage(arg14)) {
            String v0 = arg12;
            char v12 = ',';
            if(((CharSequence)v0).length() == 0) {
                v11 = new ArrayList();
            }
            else {
                List v11_1 = CollectionsKt.toMutableList(StringsKt.split$default(((CharSequence)v0), new char[]{v12}, false, 0, 6, null));
            }

            v0 = arg13;
            if(((CharSequence)v0).length() == 0) {
                v12_1 = new ArrayList();
            }
            else {
                List v12_2 = CollectionsKt.toMutableList(StringsKt.split$default(((CharSequence)v0), new char[]{v12}, false, 0, 6, null));
            }

            if(((List)v11).size() == ((List)v12_1).size()) {
                ArrayList v13 = v11;
                if(CollectionsKt.distinct(((Iterable)v13)).size() == ((List)v11).size()) {
                    if(!(v13 instanceof Collection) || !v13.isEmpty()) {
                        v13_1 = ((Iterable)v13).iterator();
                        while(v13_1.hasNext()) {
                            if(GraphicsProfileKt.validGraphicsPackage(v13_1.next())) {
                                continue;
                            }
                            else {
                                goto label_111;
                            }
                        }
                    }
                    else {
                    }

                    v13 = v12_1;
                    String v1 = "angle";
                    if(!(v13 instanceof Collection) || !v13.isEmpty()) {
                        v13_1 = ((Iterable)v13).iterator();
                        while(v13_1.hasNext()) {
                            if(SetsKt.setOf(new String[]{v1, "native", "default"}).contains(v13_1.next())) {
                                continue;
                            }
                            else {
                                goto label_111;
                            }
                        }
                    }
                    else {
                    }

                    int v13_2 = ((List)v11).indexOf(arg14);
                    if(v13_2 >= 0) {
                        ((List)v12_1).set(v13_2, v1);
                    }
                    else {
                        ((List)v11).add(arg14);
                        ((List)v12_1).add(v1);
                    }

                    return TuplesKt.to(CollectionsKt.joinToString$default(v11, ",", null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default(v12_1, ",", null, null, 0, null, null, 62, null));
                }
            }

        label_111:
            throw new IllegalStateException("Listas ANGLE desalineadas o valores desconocidos".toString());
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final List build(GraphicsAccess arg23, String arg24, GraphicsProfile arg25) {
        Object v3_1;
        GraphicsValue v5_3;
        String v10;
        String v9;
        Iterator v5_1;
        GraphicsPlan v0 = this;
        GraphicsAccess v1 = arg23;
        String v2 = arg24;
        Intrinsics.checkNotNullParameter(v1, "access");
        Intrinsics.checkNotNullParameter(v2, "pkg");
        GraphicsProfile v4 = arg25;
        Intrinsics.checkNotNullParameter(v4, "p");
        if(!GraphicsProfileKt.validGraphicsPackage(v2)) {
            goto label_336;
        }

        LinkedHashMap v3 = new LinkedHashMap();
        if(v4.getHz() > 0) {
            GraphicsPlan.build$put(v3, "system:peak_refresh_rate", v4.getHz() + ".0");
            GraphicsPlan.build$put(v3, "system:min_refresh_rate", v4.getHz() + ".0");
        }

        if(v4.getColor() >= 0) {
            GraphicsPlan.build$put(v3, "system:display_color_mode", String.valueOf(v4.getColor()));
        }

        if(v4.getMsaa()) {
            GraphicsPlan.build$put(v3, "prop:debug.egl.force_msaa", "true");
        }

        int v6 = 2;
        if(v4.getAnimations() != 0) {
            String[] v5 = new String[3];
            v5[0] = "window_animation_scale";
            v5[1] = "transition_animation_scale";
            v5[v6] = "animator_duration_scale";
            v5_1 = CollectionsKt.listOf(((Object[])v5)).iterator();
            while(v5_1.hasNext()) {
                v9 = "global:" + v5_1.next();
                v10 = v4.getAnimations() == 1 ? "0.5" : "0";
                GraphicsPlan.build$put(v3, v9, v10);
            }
        }

        v9 = "global:updatable_driver_production_opt_in_apps";
        v10 = "global:angle_gl_driver_selection_values";
        String v11 = "global:angle_gl_driver_selection_pkgs";
        char v12 = ',';
        if(v4.getDriver() == 1) {
            List v5_2 = StringsKt.split$default(v1.read(v11).getText(), new char[]{v12}, false, 0, 6, null);
            List v13 = StringsKt.split$default(v1.read(v10).getText(), new char[]{v12}, false, 0, 6, null);
            if(v5_2.size() == v13.size()) {
                v5_2 = CollectionsKt.zip(((Iterable)v5_2), ((Iterable)v13));
                if(!(v5_2 instanceof Collection) || !v5_2.isEmpty()) {
                    v5_1 = ((Iterable)v5_2).iterator();
                    while(v5_1.hasNext()) {
                        Object v13_1 = v5_1.next();
                        if(!Intrinsics.areEqual(((Pair)v13_1).getFirst(), v2)) {
                            continue;
                        }

                        if(!Intrinsics.areEqual(((Pair)v13_1).getSecond(), "angle")) {
                            continue;
                        }
                        else {
                            goto label_173;
                        }
                    }
                }
                else {
                }

                v5_3 = v1.read(v9);
                v5_2 = !v5_3.getPresent() || v5_3.getText().length() == 0 ? CollectionsKt.emptyList() : StringsKt.split$default(v5_3.getText(), new char[]{v12}, false, 0, 6, null);
                v13 = v5_2;
                if(!(v13 instanceof Collection) || !v13.isEmpty()) {
                    Iterator v13_2 = ((Iterable)v13).iterator();
                    while(true) {
                        if(v13_2.hasNext()) {
                            if(GraphicsProfileKt.validGraphicsPackage(v13_2.next())) {
                                continue;
                            }
                            else {
                                break;
                            }
                        }

                        goto label_158;
                    }

                    throw new IllegalStateException("Lista Game Driver no interpretable".toString());
                }
                else {
                }

            label_158:
                GraphicsPlan.build$put(v3, v9, CollectionsKt.joinToString$default(CollectionsKt.distinct(CollectionsKt.plus(((Collection)v5_2), v2)), ",", null, null, 0, null, null, 62, null));
                goto label_178;
            }

        label_173:
            throw new IllegalStateException("El juego ya tiene ANGLE seleccionado por otro actor; no se superpone Game Driver".toString());
        }

    label_178:
        String v13_3 = "prop:debug.angle.feature_overrides_enabled";
        if(v4.getDriver() == v6 || (v4.getTextureRequested())) {
            if(v4.getDriver() == 1) {
                goto label_331;
            }
            else if(!StringsKt.split$default(v1.read(v9).getText(), new char[]{v12}, false, 0, 6, null).contains(v2)) {
                v5_3 = v1.read(v11);
                GraphicsValue v6_1 = v1.read(v10);
                v9 = "";
                String v7 = v5_3.getPresent() ? v5_3.getText() : v9;
                if(v6_1.getPresent()) {
                    v9 = v6_1.getText();
                }

                Pair v6_2 = v0.angleLists(v7, v9, v2);
                GraphicsPlan.build$put(v3, v11, v6_2.getFirst());
                GraphicsPlan.build$put(v3, v10, v6_2.getSecond());
                if(!v4.getTextureRequested()) {
                    goto label_259;
                }

                String v6_3 = "prop:debug.angle.feature_overrides_disabled";
                GraphicsValue v7_1 = v1.read(v6_3);
                if(v7_1.getPresent()) {
                    GraphicsPlan.build$put(v3, v6_3, v0.angleFeatures(v7_1.getText(), CollectionsKt.emptyList()));
                }

                v6_1 = v1.read(v13_3);
                if(v6_1.getPresent()) {
                    GraphicsPlan.build$put(v3, v13_3, v0.angleFeatures(v6_1.getText(), v4.features()));
                    goto label_259;
                }

                if(!v1.getAngleEglFeaturesSupported()) {
                    goto label_254;
                }

                Integer v6_4 = StringsKt.toIntOrNull(v1.read("global:angle_gl_driver_all_angle").getText());
                if(v6_4 == null) {
                }
                else {
                    if(v6_4.intValue() != 1) {
                        goto label_241;
                    }

                    goto label_249;
                }

            label_241:
                GraphicsPlan.build$put(v3, "global:angle_egl_features", v0.eglFeatures$app(v5_3.getText(), v1.read("global:angle_egl_features").getText(), v2, v4.features()));
                goto label_259;
            label_249:
                throw new IllegalStateException("Propiedad ANGLE ausente: con all_angle=1 Android omite el índice de features EGL por paquete; el backend no puede eliminar una propiedad nueva. Sin ruta recuperable acreditada.".toString());
            label_254:
                throw new IllegalStateException("Propiedad ANGLE ausente y ruta EGL por paquete no disponible; no se crea una propiedad que el backend no puede eliminar".toString());
            }
            else {
                goto label_326;
            }
        }

    label_259:
        if(v4.getSaturation() == 10 && !v4.getFixed()) {
            if(v4.getFps() == 0 && v4.getResolution() == 100) {
                if(v4.getMode() != 0) {
                    String v0_1 = "game:" + v2;
                    v2 = v4.getMode() == 1 ? "performance" : "battery";
                    GraphicsPlan.build$put(v3, v0_1, v2);
                }

                ArrayList v0_2 = new ArrayList(((Map)v3).size());
                Iterator v2_1 = ((Map)v3).entrySet().iterator();
                while(v2_1.hasNext()) {
                    v3_1 = v2_1.next();
                    Object v5_4 = ((Map$Entry)v3_1).getKey();
                    ((Collection)v0_2).add(new GraphicsChange(((String)v5_4), v1.read(((String)v5_4)), ((Map$Entry)v3_1).getValue()));
                }

                ArrayList v1_1 = new ArrayList();
                Iterator v0_3 = ((Iterable)v0_2).iterator();
                while(v0_3.hasNext()) {
                    Object v2_2 = v0_3.next();
                    v3_1 = v2_2;
                    if(Intrinsics.areEqual(((GraphicsChange)v3_1).getBefore(), ((GraphicsChange)v3_1).getAfter())) {
                        if(!v4.getTextureRequested()) {
                            continue;
                        }

                        if(Intrinsics.areEqual(((GraphicsChange)v3_1).getKey(), v13_3)) {
                            goto label_313;
                        }

                        continue;
                    }

                label_313:
                    ((Collection)v1_1).add(v2_2);
                }

                return ((List)v1_1);
            }

            throw new IllegalStateException("Falta recuperación exacta del override GameManager y contrato de exclusión Stretch".toString());
        }

        throw new IllegalStateException("Original no recuperable para saturación/rendimiento fijo".toString());
    label_326:
        throw new IllegalStateException("El juego ya está seleccionado en Game Driver; restaura su configuración antes de cambiar a ANGLE".toString());
    label_331:
        throw new IllegalStateException("Game Driver y Textura ANGLE son alternativas".toString());
    label_336:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final void build$put(LinkedHashMap arg2, String arg3, String arg4) {
        ((Map)arg2).put(arg3, new GraphicsValue(true, arg4));
    }

    public final String eglFeatures$app(String arg10, String arg11, String arg12, List arg13) {
        String v3;
        Intrinsics.checkNotNullParameter(arg10, "packages");
        Intrinsics.checkNotNullParameter(arg11, "existing");
        Intrinsics.checkNotNullParameter(arg12, "pkg");
        Intrinsics.checkNotNullParameter(arg13, "features");
        String v1 = arg10;
        char v7 = ',';
        List v10 = ((CharSequence)v1).length() == 0 ? CollectionsKt.emptyList() : StringsKt.split$default(((CharSequence)v1), new char[]{v7}, false, 0, 6, null);
        v1 = arg11;
        List v11 = ((CharSequence)v1).length() == 0 ? CollectionsKt.emptyList() : StringsKt.split$default(((CharSequence)v1), new char[]{v7}, false, 0, 6, null);
        if(v11.size() <= v10.size()) {
            IntRange v0 = CollectionsKt.getIndices(v10);
            ArrayList v1_1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
            Iterator v0_1 = ((Iterable)v0).iterator();
            while(true) {
                v3 = "";
                if(!v0_1.hasNext()) {
                    break;
                }

                int v2 = v0_1.nextInt();
                if(v2 >= 0 && v2 < v11.size()) {
                    Object v3_1 = v11.get(v2);
                }

                ((Collection)v1_1).add(v3);
            }

            v11 = CollectionsKt.toMutableList(((Collection)v1_1));
            int v10_1 = v10.indexOf(arg12);
            if(v10_1 < 0) {
                v11.add(this.angleFeatures(v3, arg13));
            }
            else {
                v11.set(v10_1, this.angleFeatures(v11.get(v10_1), arg13));
            }

            String v9 = CollectionsKt.joinToString$default(v11, ",", null, null, 0, null, null, 62, null);
            if(v9.length() <= 0x1000) {
                return v9;
            }

            throw new IllegalStateException("Lista EGL demasiado larga".toString());
        }

        throw new IllegalStateException("Lista de features EGL sin paquete correspondiente".toString());
    }
}

