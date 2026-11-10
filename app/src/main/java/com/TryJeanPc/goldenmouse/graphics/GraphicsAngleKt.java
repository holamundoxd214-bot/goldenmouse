package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\u001A&\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000¨\u0006\b"}, d2={"graphicsGpuObservation", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsGpuObservation;", "text", "", "pkg", "pids", "", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class GraphicsAngleKt {
    public static final GraphicsGpuObservation graphicsGpuObservation(String arg9, String arg10, Set arg11) {
        Integer v10_3;
        String v4_1;
        String v1_1;
        int v6_2;
        String v5_1;
        Object v6;
        Intrinsics.checkNotNullParameter(arg9, "text");
        Intrinsics.checkNotNullParameter(arg10, "pkg");
        Intrinsics.checkNotNullParameter(arg11, "pids");
        if(GraphicsProfileKt.validGraphicsPackage(arg10)) {
            if(arg9.length() <= 0x400000) {
                if(arg11.isEmpty()) {
                }
                else {
                    Object v4 = null;
                    List v0 = SequencesKt.toList(Regex.findAll$default(new Regex("(?m)^\\s*appPackageName\\s*[=:]\\s*([^\\s]+)"), arg9, 0, 2, v4));
                    ArrayList v2 = new ArrayList();
                    Iterator v1 = v0.iterator();
                    int v5;
                    for(v5 = 0; v1.hasNext(); v5 = v8) {
                        v6 = v1.next();
                        int v8 = v5 + 1;
                        if(v5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }

                        if(!Intrinsics.areEqual(((MatchResult)v6).getGroupValues().get(1), arg10)) {
                            v5_1 = ((String)v4);
                        }
                        else {
                            v5 = ((MatchResult)v6).getRange().getLast() + 1;
                            v6 = CollectionsKt.getOrNull(v0, v8);
                            if(v6 != null) {
                                IntRange v6_1 = ((MatchResult)v6).getRange();
                                if(v6_1 != null) {
                                    v6_2 = v6_1.getFirst();
                                }
                                else {
                                    goto label_50;
                                }
                            }
                            else {
                            label_50:
                                v6_2 = arg9.length();
                            }

                            v5_1 = arg9.substring(v5, v6_2);
                            Intrinsics.checkNotNullExpressionValue(v5_1, "substring(...)");
                        }

                        if(v5_1 != null) {
                            ((Collection)v2).add(v5_1);
                        }
                    }

                    if(((List)v2).isEmpty()) {
                        return GraphicsAngleKt.graphicsGpuObservation$unknown("Android no publicó estadísticas del paquete");
                    }

                    ArrayList v9 = new ArrayList();
                    Iterator v10 = ((Iterable)v2).iterator();
                    while(true) {
                        v1_1 = "processId";
                        v4_1 = "pid";
                        if(!v10.hasNext()) {
                            break;
                        }

                        Object v0_1 = v10.next();
                        Object v5_2 = v0_1;
                        Set v6_3 = arg11;
                        Integer v4_2 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v5_2), v4_1);
                        if(v4_2 == null) {
                            v4_2 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v5_2), v1_1);
                        }

                        if(!CollectionsKt.contains(((Iterable)v6_3), v4_2)) {
                            continue;
                        }

                        ((Collection)v9).add(v0_1);
                    }

                    String v0_2 = "angleInUse";
                    if(!((List)v9).isEmpty()) {
                        goto label_105;
                    }

                    if(!(v2 instanceof Collection) || !v2.isEmpty()) {
                        Iterator v9_1 = ((Iterable)v2).iterator();
                        goto label_90;
                    label_105:
                        boolean v10_1 = v9 instanceof Collection;
                        if(!v10_1 || !v9.isEmpty()) {
                            Iterator v2_1 = ((Iterable)v9).iterator();
                            do {
                                if(v2_1.hasNext()) {
                                    Integer v5_3 = GraphicsAngleKt.graphicsGpuObservation$value(v2_1.next(), v0_2);
                                    if(v5_3 == null) {
                                        continue;
                                    }
                                    else {
                                        if(v5_3.intValue() != 1) {
                                            continue;
                                        }

                                        break;
                                    }
                                }

                                goto label_125;
                            }
                            while(true);

                            return new GraphicsGpuObservation(GraphicsGpuState.ANGLE, "Juego observado utilizando ANGLE · estadísticas de PID actual; efecto visual no verificado");
                        }
                        else {
                        }

                    label_125:
                        v2 = new ArrayList();
                        Iterator v5_4 = ((Iterable)v9).iterator();
                        while(v5_4.hasNext()) {
                            v6 = v5_4.next();
                            Integer v7 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v6), v4_1);
                            if(v7 == null) {
                                v7 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v6), v1_1);
                            }

                            if(v7 == null) {
                                continue;
                            }

                            ((Collection)v2).add(v7);
                        }

                        if(Intrinsics.areEqual(CollectionsKt.toSet(((Iterable)v2)), arg11)) {
                            if(!v10_1 || !v9.isEmpty()) {
                                v9_1 = ((Iterable)v9).iterator();
                                while(v9_1.hasNext()) {
                                    Object v10_2 = v9_1.next();
                                    Integer v11 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v10_2), v0_2);
                                    if(v11 == null) {
                                        goto label_180;
                                    }
                                    else if(v11.intValue() == 0) {
                                        v11 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v10_2), "createdGlesContext");
                                        if(v11 == null) {
                                            goto label_180;
                                        }
                                        else if(v11.intValue() == 0) {
                                            v11 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v10_2), "createdVulkanSwapchain");
                                            int v11_1 = v11 != null ? v11.intValue() : 0;
                                            if(v11_1 > 0) {
                                                continue;
                                            }

                                            v10_3 = GraphicsAngleKt.graphicsGpuObservation$value(((String)v10_2), "cpuVulkanInUse");
                                            int v10_4 = v10_3 != null ? v10_3.intValue() : 0;
                                            if(v10_4 <= 0) {
                                                goto label_180;
                                            }

                                            continue;
                                        }
                                        else {
                                            goto label_180;
                                        }
                                    }
                                    else {
                                        goto label_180;
                                    }

                                    break;
                                }
                            }
                            else {
                            }

                            return new GraphicsGpuObservation(GraphicsGpuState.NATIVE_VULKAN, "Juego observado utilizando Vulkan nativo; filtros ANGLE no acreditados");
                        }

                    label_180:
                        return GraphicsAngleKt.graphicsGpuObservation$unknown("estadísticas insuficientes o renderizado mixto");
                        do {
                        label_90:
                            if(!v9_1.hasNext()) {
                                goto label_100;
                            }

                            v10_3 = GraphicsAngleKt.graphicsGpuObservation$value(v9_1.next(), v0_2);
                            if(v10_3 == null) {
                                goto label_90;
                            }
                        }
                        while(v10_3.intValue() != 1);

                        arg9 = "; el historial del paquete indica ANGLE";
                        goto label_101;
                    label_100:
                        arg9 = "";
                    }
                    else {
                        goto label_100;
                    }

                label_101:
                    return GraphicsAngleKt.graphicsGpuObservation$unknown("estadísticas sin atribución a los PID actuales".concat(arg9));
                }
            }

            return GraphicsAngleKt.graphicsGpuObservation$unknown("sin proceso o respuesta excedida");
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final GraphicsGpuObservation graphicsGpuObservation$unknown(String arg4) {
        return new GraphicsGpuObservation(GraphicsGpuState.UNVERIFIABLE, "GPU no verificable: " + arg4);
    }

    private static final Integer graphicsGpuObservation$value(String arg3, String arg4) {
        Object v2 = null;
        MatchResult v3 = Regex.find$default(new Regex("(?m)^\\s*" + arg4 + "\\s*[=:]\\s*(\\d+)\\s*$"), ((CharSequence)arg3), 0, 2, v2);
        if(v3 != null) {
            List v3_1 = v3.getGroupValues();
            if(v3_1 != null) {
                Object v3_2 = v3_1.get(1);
                if(v3_2 != null) {
                    return StringsKt.toIntOrNull(((String)v3_2));
                }
            }
        }

        return ((Integer)v2);
    }
}

