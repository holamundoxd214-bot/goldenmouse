package com.TryJeanPc.goldenmouse.stretch.agent;

import com.TryJeanPc.goldenmouse.stretch.StretchFullProjection;
import com.TryJeanPc.goldenmouse.stretch.StretchRect;
import com.TryJeanPc.goldenmouse.stretch.StretchSize;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00072\b\u0010\u000F\u001A\u0004\u0018\u00010\u00072\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\rR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorParser;", "", "<init>", "()V", "MAX_BYTES", "", "N", "", "R", "header", "Lkotlin/text/Regex;", "space", "parse", "Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "text", "physicalIdentity", "installOrientation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorRead;", "stable", "first", "second", "Space", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class StretchCompositorParser {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\r¨\u0006\u0018"}, d2={"Lcom/TryJeanPc/goldenmouse/stretch/agent/StretchCompositorParser$Space;", "", "bounds", "Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "content", "orientation", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;I)V", "getBounds", "()Lcom/TryJeanPc/goldenmouse/stretch/StretchRect;", "getContent", "getOrientation", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) final class Space {
        private final StretchRect bounds;
        private final StretchRect content;
        private final int orientation;

        public Space(StretchRect arg2, StretchRect arg3, int arg4) {
            Intrinsics.checkNotNullParameter(arg2, "bounds");
            Intrinsics.checkNotNullParameter(arg3, "content");
            super();
            this.bounds = arg2;
            this.content = arg3;
            this.orientation = arg4;
        }

        public final StretchRect component1() {
            return this.bounds;
        }

        public final StretchRect component2() {
            return this.content;
        }

        public final int component3() {
            return this.orientation;
        }

        public final Space copy(StretchRect arg1, StretchRect arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg1, "bounds");
            Intrinsics.checkNotNullParameter(arg2, "content");
            return new Space(arg1, arg2, arg3);
        }

        public static Space copy$default(Space arg0, StretchRect arg1, StretchRect arg2, int arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.bounds;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.content;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.orientation;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((Space)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Space)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.bounds, ((Space)arg5).bounds)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.content, ((Space)arg5).content)) {
                return 0;
            }

            if(this.orientation != ((Space)arg5).orientation) {
                return 0;
            }

            return 1;
        }

        public final StretchRect getBounds() {
            return this.bounds;
        }

        public final StretchRect getContent() {
            return this.content;
        }

        public final int getOrientation() {
            return this.orientation;
        }

        public int hashCode() {
            return (this.bounds.hashCode() * 0x1F + this.content.hashCode()) * 0x1F + Integer.hashCode(this.orientation);
        }

        public String toString() {
            return "Space(bounds=" + this.bounds + ", content=" + this.content + ", orientation=" + this.orientation + ")";
        }
    }

    public static final int $stable = 0;
    public static final StretchCompositorParser INSTANCE = null;
    public static final int MAX_BYTES = 0x20000;
    private static final String N = "(-?\\d{1,10})";
    private static final String R = "Rect\\((-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10})\\)";
    private static final Regex header;
    private static final Regex space;

    static {
        StretchCompositorParser.INSTANCE = new StretchCompositorParser();
        StretchCompositorParser.header = new Regex("Display (\\d{1,20}) \\(physical, \"[^\"\\r\\n]{0,128}\"\\)");
        StretchCompositorParser.space = new Regex("(layerStackSpace|orientedDisplaySpace|displaySpace)=ProjectionSpace\\{bounds=Rect\\((-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10})\\), content=Rect\\((-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10}), (-?\\d{1,10})\\), orientation=ROTATION_(0|90|180|270)\\}");
        StretchCompositorParser.$stable = 8;
    }

    private StretchCompositorParser() {
        super();
    }

    public final StretchCompositorRead parse(String arg17, String arg18, Integer arg19) {
        int v5_1;
        StretchRect v4_2;
        Object v3_3;
        Object v2_1;
        Object v0_2;
        Object v10_3;
        String v11;
        int v9;
        String v0 = arg17;
        String v1 = arg18;
        String v2 = "Display ";
        Intrinsics.checkNotNullParameter(v0, "text");
        byte[] v3 = v0.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v3, "getBytes(...)");
        if(v3.length > 0x20000) {
            return StretchCompositorParser.parse$failed(CompositorReadCode.OUTPUT_LIMIT);
        }

        boolean v5 = false;
        int v6 = 2;
        Object v7 = null;
        if(StringsKt.startsWith$default(StringsKt.trimStart(v0).toString(), "Permission Denial:", false, v6, v7)) {
            return StretchCompositorParser.parse$failed(CompositorReadCode.PERMISSION_DENIED);
        }

        if(v1 != null) {
            String v3_1 = "aosp-physical:";
            if(!StringsKt.startsWith$default(v1, v3_1, false, v6, v7)) {
            }
            else {
                int v8 = 3;
                IntRange v4 = new IntRange(0, v8);
                if(arg19 != null && (v4.contains(arg19.intValue()))) {
                    try {
                        String v4_1 = Long.toUnsignedString(Long.parseUnsignedLong(StringsKt.removePrefix(v1, v3_1)));
                        if(!Intrinsics.areEqual(v1, v3_1 + v4_1)) {
                            return StretchCompositorParser.parse$failed(CompositorReadCode.DISPLAY_MISMATCH);
                        }
                        else {
                            LinkedHashMap v3_2 = new LinkedHashMap();
                            Iterator v0_1 = StringsKt.lineSequence(((CharSequence)v0)).iterator();
                            v9 = 0;
                            boolean v10 = false;
                            do {
                            label_58:
                                if(v0_1.hasNext()) {
                                    v11 = StringsKt.trim(v0_1.next()).toString();
                                    if(StringsKt.startsWith$default(v11, v2, v5, v6, v7)) {
                                        MatchResult v10_1 = StretchCompositorParser.header.matchEntire(v11);
                                        if((StringsKt.startsWith$default(v11, v2 + v4_1 + " ", v5, v6, v7)) && v10_1 == null) {
                                            return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                                        }

                                        if(v10_1 != null) {
                                            List v10_2 = v10_1.getGroupValues();
                                            if(v10_2 != null) {
                                                v10_3 = v10_2.get(1);
                                            }
                                            else {
                                                goto label_87;
                                            }
                                        }
                                        else {
                                        label_87:
                                            v10_3 = v7;
                                        }

                                        v10 = Intrinsics.areEqual(v10_3, v4_1);
                                        if(!v10) {
                                            continue;
                                        }

                                        ++v9;
                                        if(v9 <= 1) {
                                            continue;
                                        }

                                        break;
                                    }
                                    else {
                                        goto label_95;
                                    }
                                }
                                else {
                                    goto label_142;
                                }

                                goto label_246;
                            }
                            while(true);

                            return StretchCompositorParser.parse$failed(CompositorReadCode.AMBIGUOUS);
                        label_95:
                            if(v10) {
                                String[] v12 = new String[v8];
                                v12[((int)v5)] = "layerStackSpace=";
                                v12[1] = "orientedDisplaySpace=";
                                v12[v6] = "displaySpace=";
                                List v12_1 = CollectionsKt.listOf(((Object[])v12));
                                if(((v12_1 instanceof Collection)) && (v12_1.isEmpty())) {
                                    goto label_140;
                                }

                                Iterator v12_2 = ((Iterable)v12_1).iterator();
                                goto label_111;
                            label_142:
                                if(v9 == 0) {
                                    return StretchCompositorParser.parse$failed(CompositorReadCode.DISPLAY_MISMATCH);
                                }

                                v0_2 = ((Map)v3_2).get("layerStackSpace");
                                if(v0_2 == null) {
                                    return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                                }

                                v2_1 = ((Map)v3_2).get("orientedDisplaySpace");
                                if(v2_1 == null) {
                                    return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                                }

                                v3_3 = ((Map)v3_2).get("displaySpace");
                                if(v3_3 == null) {
                                    return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                                }

                                if(((Space)v0_2).getOrientation() == 0) {
                                    if(((Space)v2_1).getOrientation() != 0) {
                                    }
                                    else {
                                        v4_2 = ((Space)v3_3).getBounds();
                                        v5_1 = v4_2.getLeft();
                                        goto label_171;
                                    }
                                }

                                goto label_240;
                            }

                            goto label_140;
                        }

                        goto label_246;
                    }
                    catch(IllegalArgumentException ) {
                        goto label_243;
                    }

                label_171:
                    String v7_1 = "Failed requirement.";
                    if(v5_1 == 0) {
                        try {
                            if(v4_2.getTop() == 0) {
                                StretchRect v5_2 = ((Space)v2_1).getBounds();
                                if(v5_2.getLeft() == 0 && v5_2.getTop() == 0) {
                                    v8 = v5_2.getRight();
                                    v9 = ((Space)v3_3).getOrientation() % v6 == 0 ? v4_2.getRight() : v4_2.getBottom();
                                    if(v8 != v9) {
                                        goto label_232;
                                    }

                                    v5_1 = v5_2.getBottom();
                                    v6 = ((Space)v3_3).getOrientation() % v6 == 0 ? v4_2.getBottom() : v4_2.getRight();
                                    if(v5_1 != v6) {
                                        goto label_232;
                                    }

                                    v5_1 = ((Space)v3_3).getOrientation();
                                    if(arg19 != null) {
                                        return new StretchCompositorRead(CompositorReadCode.OBSERVED_COMPOSITOR_ONLY, new StretchCompositorState(v1, new StretchFullProjection(((Space)v0_2).getContent(), v2_1.getContent(), (v5_1 - arg19.intValue() + 4) % 4), new StretchSize(v4_2.getRight(), v4_2.getBottom()), v3_3.getOrientation(), arg19.intValue()), false, 4, null);
                                    }

                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }

                            label_232:
                                throw new IllegalArgumentException(v7_1.toString());
                            }

                        label_236:
                            throw new IllegalArgumentException(v7_1.toString());
                        label_240:
                            return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                            do {
                            label_111:
                                if(!v12_2.hasNext()) {
                                    goto label_140;
                                }
                            }
                            while(!StringsKt.startsWith$default(v11, v12_2.next(), v5, v6, v7));

                            MatchResult v11_1 = StretchCompositorParser.space.matchEntire(((CharSequence)v11));
                            if(v11_1 != null) {
                                List v11_2 = v11_1.getGroupValues();
                                if(v11_2 == null) {
                                }
                                else if(((Map)v3_2).put(v11_2.get(1), new Space(StretchCompositorParser.parse$rect(v11_2, v6), StretchCompositorParser.parse$rect(v11_2, 6), Integer.parseInt(v11_2.get(10)) / 90)) != null) {
                                    return StretchCompositorParser.parse$failed(CompositorReadCode.AMBIGUOUS);
                                }
                                else {
                                    goto label_140;
                                }
                            }

                            return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
                        label_140:
                            v5 = false;
                            goto label_58;
                        }
                        catch(IllegalArgumentException ) {
                        label_243:
                            return StretchCompositorParser.parse$failed(CompositorReadCode.INVALID_DATA);
                        }
                    }

                    goto label_236;
                }

            label_246:
                return StretchCompositorParser.parse$failed(CompositorReadCode.UNSUPPORTED);
            }
        }

        return StretchCompositorParser.parse$failed(CompositorReadCode.DISPLAY_MISMATCH);
    }

    private static final StretchCompositorRead parse$failed(CompositorReadCode arg6) {
        return new StretchCompositorRead(arg6, null, false, 6, null);
    }

    private static final StretchRect parse$rect(List arg4, int arg5) {
        StretchRect v0 = new StretchRect(Integer.parseInt(arg4.get(arg5)), Integer.parseInt(arg4.get(arg5 + 1)), Integer.parseInt(arg4.get(arg5 + 2)), Integer.parseInt(arg4.get(arg5 + 3)));
        if(v0.getLeft() >= 0 && v0.getTop() >= 0 && v0.getRight() > v0.getLeft() && v0.getBottom() > v0.getTop()) {
            arg5 = 0x8000;
            if(v0.getRight() <= arg5 && v0.getBottom() <= arg5) {
                return v0;
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final StretchCompositorRead stable(StretchCompositorRead arg8, StretchCompositorRead arg9) {
        Intrinsics.checkNotNullParameter(arg8, "first");
        Intrinsics.checkNotNullParameter(arg9, "second");
        if(arg8.getState() == null) {
            return arg8;
        }

        if(arg9.getState() == null) {
            return arg9;
        }

        if(!Intrinsics.areEqual(arg8.getState(), arg9.getState())) {
            return new StretchCompositorRead(CompositorReadCode.UNSTABLE, null, false, 6, null);
        }

        return StretchCompositorRead.copy$default(arg9, null, null, true, 3, null);
    }
}

