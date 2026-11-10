package com.TryJeanPc.goldenmouse.macro.editor;

import com.TryJeanPc.goldenmouse.macro.MacroValidationPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u000FJ\u000E\u0010#\u001A\u00020!2\u0006\u0010$\u001A\u00020\bJ\u000E\u0010%\u001A\u00020!2\u0006\u0010&\u001A\u00020\'J\u0016\u0010(\u001A\u00020\u001B2\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020\u000FJ\u0006\u0010,\u001A\u00020*J \u0010-\u001A\u0004\u0018\u00010.2\u0006\u0010/\u001A\u0002002\u000E\b\u0002\u00101\u001A\b\u0012\u0004\u0012\u00020302J=\u00104\u001A\u00020\u001B2\u0006\u00105\u001A\u00020\u000F2\u0006\u00106\u001A\u00020\u000F2\u0006\u00107\u001A\u00020\u000F2\b\u00108\u001A\u0004\u0018\u00010*2\u000E\b\u0002\u00101\u001A\b\u0012\u0004\u0012\u00020302¢\u0006\u0002\u00109J\u0010\u0010:\u001A\u0004\u0018\u00010.2\u0006\u00105\u001A\u00020\u000FJ\u000E\u0010;\u001A\u00020!2\u0006\u00105\u001A\u00020\u000FJ\u0010\u0010<\u001A\u0004\u0018\u00010.2\u0006\u00105\u001A\u00020\u000FJ\u0006\u0010=\u001A\u00020!J1\u0010>\u001A\u00020\u001B2\b\u00108\u001A\u0004\u0018\u00010*2\u0006\u0010?\u001A\u00020\u000F2\u0006\u0010@\u001A\u00020\u000F2\n\b\u0002\u0010A\u001A\u0004\u0018\u00010\u000F¢\u0006\u0002\u0010BR\u000E\u0010\u0006\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\b8F¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u001E\u0010\f\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001E\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\u000F@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\u0004\u0018\u00010\u000FX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0018\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000E\u0010\u0019\u001A\u00020\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u001A\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\u001B8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u001D¨\u0006D"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel;", "", "saved", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;)V", "initial", "baselineName", "", "getBaselineName", "()Ljava/lang/String;", "value", "draft", "getDraft", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "", "selectedTimeMs", "getSelectedTimeMs", "()J", "selectedActionId", "getSelectedActionId", "()Ljava/lang/Long;", "setSelectedActionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "nextId", "hasChanges", "", "getHasChanges", "()Z", "canSave", "getCanSave", "selectTime", "", "timeMs", "setName", "name", "setMode", "mode", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroRunMode;", "setLoop", "repetitions", "", "intervalMs", "addTrack", "insert", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "type", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroActionType;", "points", "", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroPoint;", "edit", "id", "startMs", "durationMs", "track", "(JJJLjava/lang/Integer;Ljava/util/List;)Z", "duplicate", "delete", "action", "discard", "compatible", "start", "duration", "ignoreId", "(Ljava/lang/Integer;JJLjava/lang/Long;)Z", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroEditorModel {
    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u000BJ\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\tH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditorModel$Companion;", "", "<init>", "()V", "MAX_TIME_MS", "", "requireValid", "", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "requireActions", "", "snapshot", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final MacroDraft access$snapshot(Companion arg0, MacroDraft arg1) {
            return arg0.snapshot(arg1);
        }

        public final void requireValid(MacroDraft arg1, boolean arg2) {
            Intrinsics.checkNotNullParameter(arg1, "draft");
            MacroValidationPolicy.INSTANCE.requireValid(arg1, arg2);
        }

        public static void requireValid$default(Companion arg0, MacroDraft arg1, boolean arg2, int arg3, Object arg4) {
            arg0.requireValid(arg1, false);
        }

        private final MacroDraft snapshot(MacroDraft arg21) {
            List v7 = CollectionsKt.toList(arg21.getTracks());
            List v0 = arg21.getActions();
            ArrayList v1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10));
            Iterator v0_1 = ((Iterable)v0).iterator();
            while(v0_1.hasNext()) {
                Object v8 = v0_1.next();
                ((Collection)v1).add(MacroEditAction.copy$default(((MacroEditAction)v8), 0, null, 0, 0, null, CollectionsKt.toList(((MacroEditAction)v8).getPoints()), 0x1F, null));
            }

            return MacroDraft.copy$default(arg21, null, null, 0, 0, v7, v1, 15, null);
        }
    }

    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final long MAX_TIME_MS = 86400000;
    private MacroDraft draft;
    private final MacroDraft initial;
    private long nextId;
    private Long selectedActionId;
    private long selectedTimeMs;

    static {
        MacroEditorModel.Companion = new Companion(null);
        MacroEditorModel.$stable = 8;
    }

    public MacroEditorModel(MacroDraft arg12) {
        Long v3_1;
        super();
        Companion v0 = MacroEditorModel.Companion;
        if(arg12 == null) {
            arg12 = new MacroDraft(null, null, 0, 0, null, null, 0x3F, null);
        }

        arg12 = Companion.access$snapshot(v0, arg12);
        Object v3 = null;
        Companion.requireValid$default(v0, arg12, false, 2, v3);
        this.initial = arg12;
        this.draft = arg12;
        Iterator v12 = arg12.getActions().iterator();
        if(!v12.hasNext()) {
        }
        else {
            Long v0_1 = Long.valueOf(v12.next().getId());
            while(true) {
                v3_1 = v0_1;
                do {
                    if(v12.hasNext()) {
                        v0_1 = Long.valueOf(v12.next().getId());
                        if(((Comparable)v3_1).compareTo(v0_1) >= 0) {
                            continue;
                        }

                        break;
                    }

                    break;
                }
                while(true);
            }
        }

        long v0_2 = v3_1 != null ? v3_1.longValue() : 0;
        this.nextId = v0_2 + 1;
    }

    public MacroEditorModel() {
        this(null, 1, null);
    }

    public MacroEditorModel(MacroDraft arg1, int arg2, DefaultConstructorMarker arg3) {
        if((arg2 & 1) != 0) {
            arg1 = null;
        }

        this(arg1);
    }

    public final MacroEditAction action(long arg4) {
        MacroEditAction v0_1;
        Iterator v3 = this.draft.getActions().iterator();
        do {
            if(v3.hasNext()) {
                Object v0 = v3.next();
                if(v0.getId() != arg4) {
                    continue;
                }

                return v0_1;
            }
            else {
                goto label_10;
            }
        }
        while(true);

        return v0_1;
    label_10:
        v0_1 = null;
        return v0_1;
    }

    public final int addTrack() {
        Comparable v0 = CollectionsKt.maxOrNull(this.draft.getTracks());
        int v0_1 = v0 != null ? ((Integer)v0).intValue() : 0;
        ++v0_1;
        this.draft = MacroDraft.copy$default(this.draft, null, null, 0, 0, CollectionsKt.plus(this.draft.getTracks(), Integer.valueOf(v0_1)), null, 0x2F, null);
        return v0_1;
    }

    public final boolean compatible(Integer arg7, long arg8, long arg10, Long arg12) {
        List v6 = this.draft.getActions();
        if(((v6 instanceof Collection)) && (v6.isEmpty())) {
            return 1;
        }

        Iterator v6_1 = ((Iterable)v6).iterator();
        do {
        label_10:
            if(!v6_1.hasNext()) {
                return 1;
            }

            Object v0 = v6_1.next();
            long v2 = ((MacroEditAction)v0).getId();
            if(arg12 == null) {
            }
            else {
                if(v2 != arg12.longValue()) {
                    goto label_18;
                }

                goto label_10;
            }

        label_18:
            if(!Intrinsics.areEqual(((MacroEditAction)v0).getTrack(), arg7)) {
                goto label_10;
            }

            if(arg8 >= ((MacroEditAction)v0).getEndMs()) {
                goto label_10;
            }
        }
        while(((MacroEditAction)v0).getStartMs() >= arg8 + arg10);

        return 0;
    }

    public static boolean compatible$default(MacroEditorModel arg7, Integer arg8, long arg9, long arg11, Long arg13, int arg14, Object arg15) {
        if((arg14 & 8) != 0) {
            arg13 = null;
        }

        return arg7.compatible(arg8, arg9, arg11, arg13);
    }

    public final void delete(long arg11) {
        MacroDraft v0 = this.draft;
        List v1 = v0.getActions();
        ArrayList v2 = new ArrayList();
        Iterator v1_1 = ((Iterable)v1).iterator();
        while(v1_1.hasNext()) {
            Object v3 = v1_1.next();
            if(v3.getId() == arg11) {
                continue;
            }

            ((Collection)v2).add(v3);
        }

        this.draft = MacroDraft.copy$default(v0, null, null, 0, 0, null, v2, 0x1F, null);
        Long v0_1 = this.selectedActionId;
        if(v0_1 == null) {
        }
        else if(v0_1.longValue() == arg11) {
            this.selectedActionId = null;
        }
    }

    public final void discard() {
        this.draft = Companion.access$snapshot(MacroEditorModel.Companion, this.initial);
        long v0 = 0;
        this.selectedTimeMs = v0;
        Long v2 = null;
        this.selectedActionId = v2;
        Iterator v3 = this.initial.getActions().iterator();
        if(!v3.hasNext()) {
        }
        else {
            for(v2 = Long.valueOf(v3.next().getId()); v3.hasNext(); v2 = v4) {
                Long v4 = Long.valueOf(v3.next().getId());
                if(((Comparable)v2).compareTo(v4) >= 0) {
                    continue;
                }
            }
        }

        if(v2 != null) {
            v0 = v2.longValue();
        }

        this.nextId = v0 + 1;
    }

    public final MacroEditAction duplicate(long arg14) {
        Object v10;
        MacroEditorModel v12;
        Long v4_1;
        long v1;
        MacroEditAction v0 = this.action(arg14);
        MacroEditAction v14 = null;
        if(v0 == null) {
            return v14;
        }

        Integer v15 = v0.getTrack();
        long v3 = v0.getStartMs();
        if(v15 == null) {
            v1 = v0.getEndMs();
            List v3_1 = this.draft.getActions();
            ArrayList v4 = new ArrayList();
            Iterator v3_2 = ((Iterable)v3_1).iterator();
            while(v3_2.hasNext()) {
                Object v5 = v3_2.next();
                if(v5.getTrack() != null) {
                    continue;
                }

                ((Collection)v4).add(v5);
            }

            v3_2 = ((Iterable)v4).iterator();
            if(!v3_2.hasNext()) {
                v4_1 = ((Long)v14);
            }
            else {
                for(v4_1 = Long.valueOf(v3_2.next().getEndMs()); v3_2.hasNext(); v4_1 = v5_1) {
                    Long v5_1 = Long.valueOf(v3_2.next().getEndMs());
                    if(((Comparable)v4_1).compareTo(v5_1) >= 0) {
                        continue;
                    }
                }
            }

            v3 = v4_1 != null ? v4_1.longValue() : 0;
            v3 = Math.max(v1, v3);
            v12 = this;
        }
        else {
            Iterator v15_1 = this.draft.getTracks().iterator();
            while(true) {
                if(v15_1.hasNext()) {
                    v10 = v15_1.next();
                    v12 = this;
                    if(MacroEditorModel.compatible$default(this, Integer.valueOf(v10.intValue()), v3, v0.getDurationMs(), null, 8, null)) {
                    }
                    else {
                        this = v12;
                        continue;
                    }
                }
                else {
                    break;
                }

                goto label_67;
            }

            v12 = this;
            v10 = v14;
        label_67:
            if(v10 == null) {
                v15 = Integer.valueOf(v12.addTrack());
                goto label_73;
            }

            Object v15_2 = v10;
        }

    label_73:
        Integer v8 = v15;
        long v4_2 = v3;
        if(!MacroValidationPolicy.INSTANCE.validTimes$app(v4_2, v0.getDurationMs())) {
            return v14;
        }

        v1 = v12.nextId;
        v12.nextId = 1 + v1;
        MacroEditAction v13 = MacroEditAction.copy$default(v0, v1, null, v4_2, 0, v8, null, 42, null);
        v12.draft = MacroDraft.copy$default(v12.draft, null, null, 0, 0, null, CollectionsKt.plus(v12.draft.getActions(), v13), 0x1F, null);
        v12.selectedActionId = Long.valueOf(v13.getId());
        return v13;
    }

    public final boolean edit(long arg13, long arg15, long arg17, Integer arg19, List arg20) {
        MacroEditAction v4_2;
        Integer v8 = arg19;
        List v7 = arg20;
        Intrinsics.checkNotNullParameter(v7, "points");
        MacroEditAction v9 = this.action(arg13);
        if(v9 == null) {
            return 0;
        }

        long v2 = arg15;
        long v4 = arg17;
        if(MacroValidationPolicy.INSTANCE.validTimes$app(v2, v4)) {
            if(!MacroValidationPolicy.INSTANCE.validPoints$app(v9.getType(), v7)) {
            }
            else {
                if(v8 == null && v9.getType() != MacroActionType.DELAY) {
                    return 0;
                }

                if(v8 != null && !this.draft.getTracks().contains(v8)) {
                    return 0;
                }

                if(!this.compatible(v8, v2, v4, Long.valueOf(arg13))) {
                    return 0;
                }

                MacroEditAction v0 = MacroEditAction.copy$default(v9, 0, null, arg15, arg17, arg19, CollectionsKt.toList(v7), 3, null);
                MacroDraft v1 = this.draft;
                List v2_1 = v1.getActions();
                ArrayList v3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_1), 10));
                Iterator v2_2 = ((Iterable)v2_1).iterator();
                while(v2_2.hasNext()) {
                    Object v4_1 = v2_2.next();
                    if(((MacroEditAction)v4_1).getId() == arg13) {
                        v4_2 = v0;
                    }

                    ((Collection)v3).add(v4_2);
                }

                this.draft = MacroDraft.copy$default(v1, null, null, 0, 0, null, v3, 0x1F, null);
                return 1;
            }
        }

        return 0;
    }

    public static boolean edit$default(MacroEditorModel arg10, long arg11, long arg13, long arg15, Integer arg17, List arg18, int arg19, Object arg20) {
        List v9;
        if((arg19 & 16) != 0) {
            MacroEditAction v0 = arg10.action(arg11);
            List v0_1 = v0 != null ? v0.getPoints() : null;
            if(v0_1 == null) {
                v0_1 = CollectionsKt.emptyList();
            }

            v9 = v0_1;
        }
        else {
            v9 = arg18;
        }

        return arg10.edit(arg11, arg13, arg15, arg17, v9);
    }

    public final String getBaselineName() {
        return this.initial.getName();
    }

    public final boolean getCanSave() {
        return this.draft.getActions().isEmpty() ^ 1;
    }

    public final MacroDraft getDraft() {
        return this.draft;
    }

    public final boolean getHasChanges() {
        return Intrinsics.areEqual(this.draft, this.initial) ^ 1;
    }

    public final Long getSelectedActionId() {
        return this.selectedActionId;
    }

    public final long getSelectedTimeMs() {
        return this.selectedTimeMs;
    }

    public final MacroEditAction insert(MacroActionType arg13, List arg14) {
        Object v11;
        Integer v2;
        MacroEditorModel v1;
        Intrinsics.checkNotNullParameter(arg13, "type");
        Intrinsics.checkNotNullParameter(arg14, "points");
        long v3 = this.selectedTimeMs;
        long v5 = arg13.getDefaultDurationMs();
        MacroEditAction v10 = null;
        if(MacroValidationPolicy.INSTANCE.validTimes$app(v3, v5)) {
            if(!MacroValidationPolicy.INSTANCE.validPoints$app(arg13, arg14)) {
            }
            else {
                if(arg13 == MacroActionType.DELAY) {
                    v1 = this;
                    v2 = ((Integer)v10);
                }
                else {
                    Iterator v0 = this.draft.getTracks().iterator();
                    while(true) {
                        if(v0.hasNext()) {
                            v11 = v0.next();
                            v1 = this;
                            if(MacroEditorModel.compatible$default(v1, Integer.valueOf(v11.intValue()), v3, v5, null, 8, null)) {
                            }
                            else {
                                this = v1;
                                continue;
                            }
                        }
                        else {
                            break;
                        }

                        goto label_39;
                    }

                    v1 = this;
                    v11 = v10;
                label_39:
                    int v12 = v11 != null ? ((Integer)v11).intValue() : v1.addTrack();
                    v2 = Integer.valueOf(v12);
                }

                MacroEditorModel v0_1 = v1;
                if(!MacroEditorModel.compatible$default(v1, v2, v3, v5, null, 8, null)) {
                    return v10;
                }

                Integer v9 = v2;
                long v7 = v5;
                v5 = v3;
                long v2_1 = v0_1.nextId;
                v0_1.nextId = 1 + v2_1;
                MacroEditAction v1_1 = new MacroEditAction(v2_1, arg13, v5, v7, v9, CollectionsKt.toList(((Iterable)arg14)));
                v0_1.draft = MacroDraft.copy$default(v0_1.draft, null, null, 0, 0, null, CollectionsKt.plus(v0_1.draft.getActions(), v1_1), 0x1F, null);
                v0_1.selectedActionId = Long.valueOf(v1_1.getId());
                return v1_1;
            }
        }

        return v10;
    }

    public static MacroEditAction insert$default(MacroEditorModel arg0, MacroActionType arg1, List arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = CollectionsKt.emptyList();
        }

        return arg0.insert(arg1, arg2);
    }

    public final void selectTime(long arg7) {
        this.selectedTimeMs = RangesKt.coerceIn(arg7, 0, 0x5265BFF);
    }

    public final boolean setLoop(int arg12, long arg13) {
        if(arg12 >= 0 && 0 <= arg13 && arg13 < 86400001) {
            this.draft = MacroDraft.copy$default(this.draft, null, null, arg12, arg13, null, null, 51, null);
            return 1;
        }

        return 0;
    }

    public final void setMode(MacroRunMode arg12) {
        Intrinsics.checkNotNullParameter(arg12, "mode");
        this.draft = MacroDraft.copy$default(this.draft, null, arg12, 0, 0, null, null, 61, null);
    }

    public final void setName(String arg12) {
        Intrinsics.checkNotNullParameter(arg12, "name");
        MacroDraft v1 = this.draft;
        if(StringsKt.isBlank(((CharSequence)arg12))) {
            arg12 = "Macro 1";
        }

        this.draft = MacroDraft.copy$default(v1, arg12, null, 0, 0, null, null, 62, null);
    }

    public final void setSelectedActionId(Long arg1) {
        this.selectedActionId = arg1;
    }
}

