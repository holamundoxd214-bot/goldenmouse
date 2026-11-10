package com.TryJeanPc.goldenmouse.stretch.backend;

import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryParser;", "", "<init>", "()V", "MAX_OUTPUT_BYTES", "", "evaluate", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQueryEvaluation;", "query", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchQuery;", "raw", "Lcom/TryJeanPc/goldenmouse/stretch/backend/StretchRawResponse;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchQueryParser {
    @Metadata(k=3, mv={2, 2, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[StretchQuery.values().length];
            try {
                v0[StretchQuery.EFFECTIVE_UID.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[StretchQuery.DISPLAY_SIZE.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[StretchQuery.DISPLAY_DENSITY.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[StretchQuery.BACKEND_STATUS.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                        label_19:
                            WhenMappings.$EnumSwitchMapping$0 = v0;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static final int $stable = 0;
    public static final StretchQueryParser INSTANCE = null;
    public static final int MAX_OUTPUT_BYTES = 0x10000;

    static {
        StretchQueryParser.INSTANCE = new StretchQueryParser();
    }

    private StretchQueryParser() {
        super();
    }

    public final StretchQueryEvaluation evaluate(StretchQuery arg11, StretchRawResponse arg12) {
        StretchExecutionStatus v10_8;
        DisplaySize v3_2;
        StretchSize v3_1;
        Object v0_2;
        Object v4_4;
        List v5_1;
        Integer v10_2;
        Intrinsics.checkNotNullParameter(arg11, "query");
        Intrinsics.checkNotNullParameter(arg12, "raw");
        byte[] v10 = arg12.getStdout().getBytes(Charsets.UTF_8);
        String v0 = "getBytes(...)";
        Intrinsics.checkNotNullExpressionValue(v10, v0);
        int v1 = 0x10000;
        if(v10.length <= v1) {
            v10 = arg12.getStderr().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(v10, v0);
            if(v10.length > v1) {
            }
            else {
                StretchTransportError v10_1 = arg12.getError();
                if(v10_1 != null) {
                    return StretchQueryParser.evaluate$failure(v10_1);
                }
                else if(!arg12.getComplete()) {
                    return StretchQueryParser.evaluate$failure(StretchTransportError.INCOMPLETE_RESPONSE);
                }
                else {
                    v1 = 2;
                    Object v3 = null;
                    if(arg12.getExitCode() != null) {
                        v10_2 = arg12.getExitCode();
                        if(v10_2 == null) {
                        }
                        else {
                            if(v10_2.intValue() != 0) {
                                goto label_39;
                            }

                            goto label_61;
                        }

                    label_39:
                        if((StringsKt.contains(arg12.getStderr(), "permission denied", true)) || (StringsKt.contains$default(arg12.getStderr(), "SecurityException", false, v1, v3))) {
                            v10_1 = StretchTransportError.PERMISSION_DENIED;
                        }
                        else {
                            v10_2 = arg12.getExitCode();
                            if(v10_2 == null) {
                            }
                            else if(v10_2.intValue() == 0x7F) {
                                v10_1 = StretchTransportError.UNSUPPORTED;
                                goto label_59;
                            }

                            v10_1 = StretchTransportError.COMMAND_FAILED;
                        }

                    label_59:
                        return StretchQueryParser.evaluate$failure(v10_1);
                    }

                label_61:
                    if(StringsKt.isBlank(arg12.getStdout())) {
                        return StretchQueryParser.evaluate$failure(StretchTransportError.EMPTY_RESPONSE);
                    }

                    List v10_3 = SequencesKt.toList(SequencesKt.filter(SequencesKt.map(StringsKt.lineSequence(arg12.getStdout()), new StretchQueryParser$$ExternalSyntheticLambda0()), new StretchQueryParser$$ExternalSyntheticLambda1()));
                    int v4 = WhenMappings.$EnumSwitchMapping$0[arg11.ordinal()];
                    if(v4 != 1) {
                        if(v4 != v1 && v4 != 3) {
                            if(v4 != 4) {
                                throw new NoWhenBranchMatchedException();
                            }
                            else {
                                goto label_85;
                            }
                        }

                        int v11 = arg11 == StretchQuery.DISPLAY_SIZE ? 1 : 0;
                        Regex v4_1 = v11 != 0 ? new Regex("(Physical|Override) size: ([0-9]+)x([0-9]+)") : new Regex("(Physical|Override) density: ([0-9]+)");
                        int v6 = 10;
                        ArrayList v5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10_3), v6));
                        Iterator v10_4 = ((Iterable)v10_3).iterator();
                        while(v10_4.hasNext()) {
                            MatchResult v7 = v4_1.matchEntire(v10_4.next());
                            if(v7 == null) {
                                return StretchQueryParser.evaluate$failure(StretchTransportError.MALFORMED_RESPONSE);
                            }

                            ((Collection)v5).add(v7);
                        }

                        ArrayList v10_5 = v5;
                        ArrayList v4_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10_5), v6));
                        Iterator v6_1 = ((Iterable)v10_5).iterator();
                        while(v6_1.hasNext()) {
                            ((Collection)v4_2).add(v6_1.next().getGroupValues().get(1));
                        }

                        if(CollectionsKt.distinct(((Iterable)v4_2)).size() != ((List)v5).size()) {
                            return StretchQueryParser.evaluate$failure(StretchTransportError.MALFORMED_RESPONSE);
                        }

                        if(!(v10_5 instanceof Collection) || !v10_5.isEmpty()) {
                            Iterator v4_3 = ((Iterable)v10_5).iterator();
                            while(true) {
                            label_144:
                                if(v4_3.hasNext()) {
                                    v5_1 = CollectionsKt.drop(v4_3.next().getGroupValues(), v1);
                                    if(((v5_1 instanceof Collection)) && (v5_1.isEmpty())) {
                                        continue;
                                    }

                                    break;
                                }

                                goto label_170;
                            }

                            Iterator v5_2 = ((Iterable)v5_1).iterator();
                            do {
                                if(!v5_2.hasNext()) {
                                    goto label_144;
                                }

                                Integer v6_2 = StringsKt.toIntOrNull(v5_2.next());
                                v6 = v6_2 == null || ((Number)v6_2).intValue() <= 0 ? 0 : 1;
                            }
                            while(v6 != 0);

                            return StretchQueryParser.evaluate$failure(StretchTransportError.MALFORMED_RESPONSE);
                        }
                        else {
                        }

                    label_170:
                        Iterator v0_1 = ((Iterable)v10_5).iterator();
                        do {
                            if(v0_1.hasNext()) {
                                v4_4 = v0_1.next();
                                if(!Intrinsics.areEqual(v4_4.getGroupValues().get(1), "Physical")) {
                                    continue;
                                }

                                break;
                            }
                            else {
                                goto label_181;
                            }
                        }
                        while(true);

                        goto label_182;
                    label_181:
                        v4_4 = v3;
                    label_182:
                        if(v4_4 == null) {
                            return StretchQueryParser.evaluate$failure(StretchTransportError.INCOMPLETE_RESPONSE);
                        }

                        v10_4 = ((Iterable)v10_5).iterator();
                        do {
                            if(v10_4.hasNext()) {
                                v0_2 = v10_4.next();
                                if(!Intrinsics.areEqual(v0_2.getGroupValues().get(1), "Override")) {
                                    continue;
                                }

                                break;
                            }
                            else {
                                goto label_197;
                            }
                        }
                        while(true);

                        goto label_198;
                    label_197:
                        v0_2 = v3;
                    label_198:
                        if(v11 != 0) {
                            StretchSize v10_6 = StretchQueryParser.evaluate$dimensions(((MatchResult)v4_4));
                            if(v0_2 != null) {
                                v3_1 = StretchQueryParser.evaluate$dimensions(((MatchResult)v0_2));
                            }

                            v3_2 = new DisplaySize(v10_6, v3_1);
                            goto label_85;
                        }

                        v11 = Integer.parseInt(((MatchResult)v4_4).getGroupValues().get(v1));
                        if(v0_2 != null) {
                            List v0_3 = ((MatchResult)v0_2).getGroupValues();
                            if(v0_3 != null) {
                                v0_2 = v0_3.get(v1);
                                if(v0_2 != null) {
                                    Integer v3_3 = Integer.valueOf(Integer.parseInt(((String)v0_2)));
                                }
                            }
                        }

                        Density v3_4 = new Density(v11, ((Integer)v3));
                    }
                    else {
                        String v10_7 = StringsKt.trim(arg12.getStdout()).toString();
                        if(new Regex("[0-9]+").matches(v10_7)) {
                        }
                        else {
                            v10_7 = ((String)v3);
                        }

                        if(v10_7 == null) {
                            goto label_85;
                        }

                        v10_2 = StringsKt.toIntOrNull(v10_7);
                        if(v10_2 == null) {
                            goto label_85;
                        }

                        Uid v3_5 = new Uid(((Number)v10_2).intValue());
                    }

                label_85:
                    DisplaySize v6_3 = v3_2;
                    if(v6_3 == null) {
                        return StretchQueryParser.evaluate$failure(StretchTransportError.MALFORMED_RESPONSE);
                    }

                    v10_2 = arg12.getExitCode();
                    if(v10_2 == null) {
                        goto label_250;
                    }
                    else if(v10_2.intValue() == 0) {
                        v10_8 = StretchExecutionStatus.SUCCEEDED;
                    }
                    else {
                    label_250:
                        v10_8 = StretchExecutionStatus.COMPLETED_UNVERIFIED;
                    }

                    return new StretchQueryEvaluation(v10_8, ((StretchQueryData)v6_3), null, 4, null);
                }
            }
        }

        return StretchQueryParser.evaluate$failure(StretchTransportError.OUTPUT_LIMIT);
    }

    private static final StretchSize evaluate$dimensions(MatchResult arg3) {
        return new StretchSize(Integer.parseInt(arg3.getGroupValues().get(2)), Integer.parseInt(arg3.getGroupValues().get(3)));
    }

    private static final StretchQueryEvaluation evaluate$failure(StretchTransportError arg6) {
        return new StretchQueryEvaluation(StretchExecutionStatus.FAILED, null, arg6, 2, null);
    }

    static final String evaluate$lambda$1(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        return StringsKt.trim(((CharSequence)arg1)).toString();
    }

    static final boolean evaluate$lambda$2(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "it");
        if(((CharSequence)arg1).length() > 0) {
            return 1;
        }

        return 0;
    }
}

