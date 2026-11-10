package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.GoldenStretchGeometryCalculator;
import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum$Companion;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoveryDatum;
import com.TryJeanPc.goldenmouse.stretch.recovery.RecoverySource;
import com.TryJeanPc.goldenmouse.stretch.recovery.StretchScaling;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00052\b\u0010\f\u001A\u0004\u0018\u00010\u00052\u0006\u0010\r\u001A\u00020\u000EJ#\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001A\u00020\u000E2\b\u0010\u0013\u001A\u0004\u0018\u00010\u000E¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0017\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u000EX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchOriginalEvidenceParser;", "", "<init>", "()V", "N", "", "R", "viewportPattern", "Lkotlin/text/Regex;", "viewport", "Lcom/TryJeanPc/goldenmouse/stretch/agent/OriginalViewportRead;", "text", "expectedPhysicalIdentity", "rotation", "", "scaling", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "Lcom/TryJeanPc/goldenmouse/stretch/recovery/StretchScaling;", "flags", "scalingDisabledMask", "(ILjava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/stretch/recovery/RecoveryDatum;", "sizeOverride", "Lcom/TryJeanPc/goldenmouse/stretch/StretchSize;", "windowDump", "MAX_DUMP_CHARS", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchOriginalEvidenceParser {
    public static final int $stable = 0;
    public static final StretchOriginalEvidenceParser INSTANCE = null;
    public static final int MAX_DUMP_CHARS = 0x20000;
    private static final String N = "(-?\\d{1,10})";
    private static final String R = "Rect\\((-?\\d{1,10}), (-?\\d{1,10}) - (-?\\d{1,10}), (-?\\d{1,10})\\)";
    private static final Regex viewportPattern;

    static {
        StretchOriginalEvidenceParser.INSTANCE = new StretchOriginalEvidenceParser();
        StretchOriginalEvidenceParser.viewportPattern = new Regex("DisplayViewport\\{type=INTERNAL, valid=(true|false), (?:isActive=(true|false), )?displayId=(\\d{1,10}), uniqueId=\'local:(\\d{1,20})\', (?:physicalPort=(?:null|\\d{1,3}), )?orientation=([0-3]), (?:densityDpi=\\d{1,10}, xDpi=\\d{1,10}(?:\\.\\d{1,6})?, yDpi=\\d{1,10}(?:\\.\\d{1,6})?, )?logicalFrame=Rect\\((-?\\d{1,10}), (-?\\d{1,10}) - (-?\\d{1,10}), (-?\\d{1,10})\\), physicalFrame=Rect\\((-?\\d{1,10}), (-?\\d{1,10}) - (-?\\d{1,10}), (-?\\d{1,10})\\), deviceWidth=(\\d{1,10}), deviceHeight=(\\d{1,10})\\}");
        StretchOriginalEvidenceParser.$stable = 8;
    }

    private StretchOriginalEvidenceParser() {
        super();
    }

    public final RecoveryDatum scaling(int arg1, Integer arg2) {
        if(arg2 != null) {
            int v0 = arg2.intValue();
            if(v0 > 0) {
                if((v0 - 1 & v0) != 0) {
                }
                else {
                    Companion v2 = RecoveryDatum.Companion;
                    StretchScaling v0_1 = (v0 & arg1) != 0 ? StretchScaling.OFF : StretchScaling.AUTO;
                    return v2.known(v0_1, RecoverySource.INFORMATIVE_BACKEND);
                }
            }

            return RecoveryDatum.Companion.failed(RecoverySource.INFORMATIVE_BACKEND);
        }

        return RecoveryDatum.Companion.unsupported(RecoverySource.INFORMATIVE_BACKEND);
    }

    public final RecoveryDatum sizeOverride(String arg7) {
        Intrinsics.checkNotNullParameter(arg7, "windowDump");
        if(arg7.length() > 0x20000) {
            return RecoveryDatum.Companion.failed(RecoverySource.INFORMATIVE_BACKEND);
        }

        int v0 = 0;
        int v1 = 2;
        Object v2 = null;
        List v6 = SequencesKt.toList(Regex.findAll$default(new Regex("Display: mDisplayId=0(?: \\(organized\\))?\\r?\\n[ \\t]+init=(\\d+)x(\\d+) (\\d+)dpi([^\\r\\n]*)"), ((CharSequence)arg7), 0, v1, v2));
        if(v6.size() != 1) {
            return RecoveryDatum.Companion.unknown(RecoverySource.INFORMATIVE_BACKEND);
        }

        Object v6_1 = CollectionsKt.single(v6);
        Integer v4 = StringsKt.toIntOrNull(((MatchResult)v6_1).getGroupValues().get(1));
        int v4_1 = v4 != null ? v4.intValue() : 0;
        Integer v5 = StringsKt.toIntOrNull(((MatchResult)v6_1).getGroupValues().get(v1));
        int v5_1 = v5 != null ? v5.intValue() : 0;
        StretchSize v7 = new StretchSize(v4_1, v5_1);
        MatchResult v6_2 = Regex.find$default(new Regex(" base=(\\d+)x(\\d+) (\\d+)dpi"), ((MatchResult)v6_1).getGroupValues().get(4), 0, v1, v2);
        if(v6_2 == null) {
            return RecoveryDatum.Companion.unknown(RecoverySource.INFORMATIVE_BACKEND);
        }

        Integer v3 = StringsKt.toIntOrNull(v6_2.getGroupValues().get(1));
        int v3_1 = v3 != null ? v3.intValue() : 0;
        Integer v6_3 = StringsKt.toIntOrNull(v6_2.getGroupValues().get(v1));
        if(v6_3 != null) {
            v0 = v6_3.intValue();
        }

        StretchSize v2_1 = new StretchSize(v3_1, v0);
        if(v7.getWidth() > 0 && v7.getHeight() > 0 && v2_1.getWidth() > 0 && v2_1.getHeight() > 0 && !Intrinsics.areEqual(v2_1, v7)) {
            return RecoveryDatum.Companion.known(v2_1, RecoverySource.INFORMATIVE_BACKEND);
        }

        return RecoveryDatum.Companion.unknown(RecoverySource.INFORMATIVE_BACKEND);
    }

    public final OriginalViewportRead viewport(String arg9, String arg10, int arg11) {
        StretchSize v3_1;
        StretchRect v0_2;
        StretchRect v10;
        Object v5;
        Intrinsics.checkNotNullParameter(arg9, "text");
        int v1 = 2;
        OriginalViewport v2 = null;
        if(arg9.length() > 0x20000) {
            return new OriginalViewportRead(OriginalReadCode.OUTPUT_LIMIT, v2, v1, ((DefaultConstructorMarker)v2));
        }

        if(arg10 != null) {
            String v8 = "aosp-physical:";
            if(!StringsKt.startsWith$default(arg10, v8, false, v1, v2)) {
            }
            else {
                if(arg11 >= 0) {
                    int v3 = 4;
                    if(arg11 < v3) {
                        List v4 = SequencesKt.toList(Regex.findAll$default(new Regex("DisplayViewport\\{[^{}]{1,2048}\\}"), ((CharSequence)arg9), 0, v1, v2));
                        if(v4.size() != SequencesKt.count(Regex.findAll$default(new Regex("DisplayViewport\\{"), ((CharSequence)arg9), 0, v1, v2))) {
                            return new OriginalViewportRead(OriginalReadCode.INVALID_DATA, v2, v1, ((DefaultConstructorMarker)v2));
                        }
                        else {
                            ArrayList v9 = new ArrayList();
                            Iterator v4_1 = ((Iterable)v4).iterator();
                            while(v4_1.hasNext()) {
                                v5 = v4_1.next();
                                if(!StringsKt.startsWith$default(v5.getValue(), "DisplayViewport{type=INTERNAL,", false, v1, v2)) {
                                    continue;
                                }

                                ((Collection)v9).add(v5);
                            }

                            if(((List)v9).isEmpty()) {
                                return new OriginalViewportRead(OriginalReadCode.FORMAT_UNSUPPORTED, v2, v1, ((DefaultConstructorMarker)v2));
                            }
                            else {
                                int v4_2 = 10;
                                ArrayList v0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v9), v4_2));
                                Iterator v9_1 = ((Iterable)v9).iterator();
                                while(true) {
                                    if(v9_1.hasNext()) {
                                        MatchResult v5_1 = StretchOriginalEvidenceParser.viewportPattern.matchEntire(v9_1.next().getValue());
                                        if(v5_1 == null) {
                                            return new OriginalViewportRead(OriginalReadCode.FORMAT_UNSUPPORTED, v2, v1, ((DefaultConstructorMarker)v2));
                                        }
                                        else {
                                            ((Collection)v0).add(v5_1);
                                            continue;
                                        }
                                    }
                                    else {
                                        break;
                                    }

                                    goto label_178;
                                }

                                v9 = new ArrayList();
                                Iterator v0_1 = ((Iterable)v0).iterator();
                                while(v0_1.hasNext()) {
                                    v5 = v0_1.next();
                                    if(!Intrinsics.areEqual(v5.getGroupValues().get(3), "0")) {
                                        continue;
                                    }

                                    ((Collection)v9).add(v5);
                                }

                                if(((List)v9).size() != 1) {
                                    OriginalReadCode v9_2 = ((List)v9).isEmpty() ? OriginalReadCode.DISPLAY_MISMATCH : OriginalReadCode.AMBIGUOUS;
                                    return new OriginalViewportRead(v9_2, v2, v1, ((DefaultConstructorMarker)v2));
                                }
                                else {
                                    List v9_3 = CollectionsKt.single(((List)v9)).getGroupValues();
                                    try {
                                        v8 = v8 + Long.toUnsignedString(Long.parseUnsignedLong(v9_3.get(v3)));
                                        if(!Intrinsics.areEqual(v8, arg10)) {
                                            return new OriginalViewportRead(OriginalReadCode.DISPLAY_MISMATCH, v2, v1, ((DefaultConstructorMarker)v2));
                                        }

                                        if((Intrinsics.areEqual(v9_3.get(1), "true")) && !Intrinsics.areEqual(v9_3.get(v1), "false")) {
                                            if(Integer.parseInt(v9_3.get(5)) != arg11) {
                                            }
                                            else {
                                                v10 = StretchOriginalEvidenceParser.viewport$rect(v9_3, 6);
                                                v0_2 = StretchOriginalEvidenceParser.viewport$rect(v9_3, v4_2);
                                                v3_1 = new StretchSize(Integer.parseInt(v9_3.get(14)), Integer.parseInt(v9_3.get(15)));
                                                int v9_4 = v10.getLeft();
                                                goto label_140;
                                            }
                                        }

                                        goto label_170;
                                    }
                                    catch(IllegalArgumentException ) {
                                        goto label_174;
                                    }

                                label_140:
                                    String v4_3 = "Failed requirement.";
                                    if(v9_4 >= 0) {
                                        try {
                                            if(v10.getTop() >= 0 && v10.getRight() > v10.getLeft() && v10.getBottom() > v10.getTop()) {
                                                if(new GoldenStretchGeometryCalculator().validateRectangle(v0_2, v3_1) == null) {
                                                    return new OriginalViewportRead(OriginalReadCode.OBSERVED_DIAGNOSTIC_ONLY, new OriginalViewport(v8, new StretchFullProjection(v10, v0_2, arg11), v3_1));
                                                }
                                                else {
                                                    throw new IllegalArgumentException(v4_3.toString());
                                                }
                                            }

                                        label_166:
                                            throw new IllegalArgumentException(v4_3.toString());
                                        label_170:
                                            return new OriginalViewportRead(OriginalReadCode.DISPLAY_CHANGED, v2, v1, ((DefaultConstructorMarker)v2));
                                        }
                                        catch(IllegalArgumentException ) {
                                        label_174:
                                            return new OriginalViewportRead(OriginalReadCode.INVALID_DATA, v2, v1, ((DefaultConstructorMarker)v2));
                                        }
                                    }

                                    goto label_166;
                                }
                            }
                        }
                    }
                }

            label_178:
                return new OriginalViewportRead(OriginalReadCode.INVALID_DATA, v2, v1, ((DefaultConstructorMarker)v2));
            }
        }

        return new OriginalViewportRead(OriginalReadCode.UNKNOWN_IDENTITY, v2, v1, ((DefaultConstructorMarker)v2));
    }

    private static final StretchRect viewport$rect(List arg4, int arg5) {
        return new StretchRect(Integer.parseInt(arg4.get(arg5)), Integer.parseInt(arg4.get(arg5 + 1)), Integer.parseInt(arg4.get(arg5 + 2)), Integer.parseInt(arg4.get(arg5 + 3)));
    }
}

