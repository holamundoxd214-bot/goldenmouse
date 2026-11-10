package com.TryJeanPc.goldenmouse.macro.execution;

import com.TryJeanPc.goldenmouse.macro.MacroValidationPolicy;
import com.TryJeanPc.goldenmouse.macro.editor.MacroActionType;
import com.TryJeanPc.goldenmouse.macro.editor.MacroDraft;
import com.TryJeanPc.goldenmouse.macro.editor.MacroEditAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\t\u0010\u001A\u001A\u00020\nHÆ\u0003J7\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nHÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u001D2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001F\u001A\u00020\nHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0014¨\u0006#"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "contacts", "", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroEditAction;", "durationMs", "", "peakContacts", "", "<init>", "(Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;Ljava/util/List;JI)V", "getDraft", "()Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "getContacts", "()Ljava/util/List;", "getDurationMs", "()J", "getPeakContacts", "()I", "contactQuota", "getContactQuota", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class MacroProgram {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram$Companion;", "", "<init>", "()V", "compile", "Lcom/TryJeanPc/goldenmouse/macro/execution/MacroProgram;", "draft", "Lcom/TryJeanPc/goldenmouse/macro/editor/MacroDraft;", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final MacroProgram compile(MacroDraft arg24) {
            long v14;
            long v2_2;
            int v3;
            Object v2_1;
            MacroDraft v0 = arg24;
            Intrinsics.checkNotNullParameter(v0, "draft");
            MacroValidationPolicy.INSTANCE.requireValid(v0, true);
            List v6 = CollectionsKt.toList(v0.getTracks());
            List v1 = v0.getActions();
            ArrayList v2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v1), 10));
            Iterator v1_1 = ((Iterable)v1).iterator();
            while(v1_1.hasNext()) {
                Object v11 = v1_1.next();
                ((Collection)v2).add(MacroEditAction.copy$default(((MacroEditAction)v11), 0, null, 0, 0, null, CollectionsKt.toList(((MacroEditAction)v11).getPoints()), 0x1F, null));
            }

            MacroDraft v12 = MacroDraft.copy$default(v0, null, null, 0, 0, v6, v2, 15, null);
            List v0_1 = v12.getActions();
            ArrayList v1_2 = new ArrayList();
            Iterator v0_2 = ((Iterable)v0_1).iterator();
            while(v0_2.hasNext()) {
                v2_1 = v0_2.next();
                if(v2_1.getType() == MacroActionType.DELAY) {
                    continue;
                }

                ((Collection)v1_2).add(v2_1);
            }

            List v13 = CollectionsKt.sortedWith(((Iterable)v1_2), new MacroProgram$Companion$compile$$inlined$thenBy$1(new MacroProgram$Companion$compile$$inlined$compareBy$1()));
            v1_2 = new ArrayList();
            v0_2 = v13.iterator();
            while(true) {
                v3 = 0;
                if(!v0_2.hasNext()) {
                    break;
                }

                v2_1 = v0_2.next();
                CollectionsKt.addAll(((Collection)v1_2), CollectionsKt.listOf(new Pair[]{TuplesKt.to(Long.valueOf(((MacroEditAction)v2_1).getStartMs()), Integer.valueOf(1)), TuplesKt.to(Long.valueOf(((MacroEditAction)v2_1).getEndMs()), Integer.valueOf(-1))}));
            }

            v0_2 = CollectionsKt.sortedWith(((Iterable)v1_2), new MacroProgram$Companion$compile$$inlined$thenBy$2(new MacroProgram$Companion$compile$$inlined$compareBy$2())).iterator();
            int v1_3;
            for(v1_3 = 0; v0_2.hasNext(); v1_3 = Math.max(v1_3, v3)) {
                v3 += v0_2.next().component2().intValue();
            }

            v0_2 = v12.getActions().iterator();
            if(v0_2.hasNext()) {
                v2_2 = v0_2.next().getEndMs();
                goto label_101;
            }

            throw new NoSuchElementException();
            while(true) {
            label_101:
                v14 = v2_2;
                do {
                    if(!v0_2.hasNext()) {
                        break;
                    }

                    v2_2 = v0_2.next().getEndMs();
                }
                while(v14 >= v2_2);
            }

            return new MacroProgram(v12, v13, v14, v1_3, null);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private final int contactQuota;
    private final List contacts;
    private final MacroDraft draft;
    private final long durationMs;
    private final int peakContacts;

    static {
        MacroProgram.Companion = new Companion(null);
        MacroProgram.$stable = 8;
    }

    private MacroProgram(MacroDraft arg7, List arg8, long arg9, int arg11) {
        int v2;
        super();
        this.draft = arg7;
        this.contacts = arg8;
        this.durationMs = arg9;
        this.peakContacts = arg11;
        List v7 = this.contacts;
        ArrayList v8 = new ArrayList();
        Iterator v7_1 = ((Iterable)v7).iterator();
        while(v7_1.hasNext()) {
            Object v9 = v7_1.next();
            if(v9.getType() == MacroActionType.TAP) {
                continue;
            }

            ((Collection)v8).add(v9);
        }

        int v9_1 = 10;
        ArrayList v7_2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v8), v9_1));
        Iterator v8_1 = ((Iterable)v8).iterator();
        while(v8_1.hasNext()) {
            ((Collection)v7_2).add(v8_1.next().getTrack());
        }

        Set v7_3 = CollectionsKt.toSet(((Iterable)v7_2));
        arg8 = this.contacts;
        ArrayList v10 = new ArrayList();
        v8_1 = ((Iterable)arg8).iterator();
        while(v8_1.hasNext()) {
            Object v11 = v8_1.next();
            if(v7_3.contains(v11.getTrack())) {
                continue;
            }

            ((Collection)v10).add(v11);
        }

        v8 = new ArrayList();
        Iterator v11_1 = ((Iterable)v10).iterator();
        while(true) {
            v2 = 0;
            if(!v11_1.hasNext()) {
                break;
            }

            Object v0 = v11_1.next();
            CollectionsKt.addAll(((Collection)v8), CollectionsKt.listOf(new Pair[]{TuplesKt.to(Long.valueOf(((MacroEditAction)v0).getStartMs()), Integer.valueOf(1)), TuplesKt.to(Long.valueOf(((MacroEditAction)v0).getEndMs()), Integer.valueOf(-1))}));
        }

        v8_1 = CollectionsKt.sortedWith(((Iterable)v8), new MacroProgram$contactQuota$lambda$8$$inlined$thenBy$1(new MacroProgram$contactQuota$lambda$8$$inlined$compareBy$1())).iterator();
        for(arg11 = 0; v8_1.hasNext(); arg11 = Math.max(arg11, v2)) {
            v2 += v8_1.next().component2().intValue();
        }

        int v7_4 = v7_3.size();
        v8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v10), v9_1));
        Iterator v9_2 = ((Iterable)v10).iterator();
        while(v9_2.hasNext()) {
            ((Collection)v8).add(v9_2.next().getTrack());
        }

        this.contactQuota = v7_4 + Math.min(CollectionsKt.toSet(((Iterable)v8)).size(), arg11 + 1);
    }

    public MacroProgram(MacroDraft arg1, List arg2, long arg3, int arg5, DefaultConstructorMarker arg6) {
        this(arg1, arg2, arg3, arg5);
    }

    public final MacroDraft component1() {
        return this.draft;
    }

    public final List component2() {
        return this.contacts;
    }

    public final long component3() {
        return this.durationMs;
    }

    public final int component4() {
        return this.peakContacts;
    }

    public final MacroProgram copy(MacroDraft arg7, List arg8, long arg9, int arg11) {
        Intrinsics.checkNotNullParameter(arg7, "draft");
        Intrinsics.checkNotNullParameter(arg8, "contacts");
        return new MacroProgram(arg7, arg8, arg9, arg11);
    }

    public static MacroProgram copy$default(MacroProgram arg0, MacroDraft arg1, List arg2, long arg3, int arg5, int arg6, Object arg7) {
        if((arg6 & 1) != 0) {
            arg1 = arg0.draft;
        }

        if((arg6 & 2) != 0) {
            arg2 = arg0.contacts;
        }

        if((arg6 & 4) != 0) {
            arg3 = arg0.durationMs;
        }

        if((arg6 & 8) != 0) {
            arg5 = arg0.peakContacts;
        }

        return arg0.copy(arg1, arg2, arg3, arg5);
    }

    public boolean equals(Object arg8) {
        if(this == (((MacroProgram)arg8))) {
            return 1;
        }

        if(!(arg8 instanceof MacroProgram)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.draft, ((MacroProgram)arg8).draft)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.contacts, ((MacroProgram)arg8).contacts)) {
            return 0;
        }

        if(this.durationMs != ((MacroProgram)arg8).durationMs) {
            return 0;
        }

        if(this.peakContacts != ((MacroProgram)arg8).peakContacts) {
            return 0;
        }

        return 1;
    }

    public final int getContactQuota() {
        return this.contactQuota;
    }

    public final List getContacts() {
        return this.contacts;
    }

    public final MacroDraft getDraft() {
        return this.draft;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final int getPeakContacts() {
        return this.peakContacts;
    }

    public int hashCode() {
        return ((this.draft.hashCode() * 0x1F + this.contacts.hashCode()) * 0x1F + Long.hashCode(this.durationMs)) * 0x1F + Integer.hashCode(this.peakContacts);
    }

    public String toString() {
        return "MacroProgram(draft=" + this.draft + ", contacts=" + this.contacts + ", durationMs=" + this.durationMs + ", peakContacts=" + this.peakContacts + ")";
    }
}

