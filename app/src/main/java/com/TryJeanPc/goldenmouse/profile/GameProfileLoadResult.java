package com.TryJeanPc.goldenmouse.profile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001%B+\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00032\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001AJ\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u001E\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001A\u00020#HÖ\u0001J\t\u0010$\u001A\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0017\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00050\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001A\u00020\u00138F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfileLoadResult;", "", "profile", "Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "originalJson", "", "error", "<init>", "(Lcom/TryJeanPc/goldenmouse/profile/GameProfile;Ljava/lang/String;Ljava/lang/String;)V", "getProfile", "()Lcom/TryJeanPc/goldenmouse/profile/GameProfile;", "getOriginalJson", "()Ljava/lang/String;", "getError", "macroErrors", "", "getMacroErrors", "()Ljava/util/List;", "status", "Lcom/TryJeanPc/goldenmouse/profile/GameProfileLoadResult$Status;", "getStatus", "()Lcom/TryJeanPc/goldenmouse/profile/GameProfileLoadResult$Status;", "requireWritable", "", "updated", "changedMacroId", "requireWritable$app", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GameProfileLoadResult {
    @Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2={"Lcom/TryJeanPc/goldenmouse/profile/GameProfileLoadResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "MISSING", "VALID", "INVALID_MACROS", "INVALID_PROFILE", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public enum Status {
        public static final enum Status INVALID_MACROS;
        public static final enum Status INVALID_PROFILE;
        public static final enum Status MISSING;
        public static final enum Status VALID;

        private static final Status[] $values() {
            return new Status[]{Status.MISSING, Status.VALID, Status.INVALID_MACROS, Status.INVALID_PROFILE};
        }

        static {
            Status.MISSING = new Status("MISSING", 0);
            Status.VALID = new Status("VALID", 1);
            Status.INVALID_MACROS = new Status("INVALID_MACROS", 2);
            Status.INVALID_PROFILE = new Status("INVALID_PROFILE", 3);
            Status[] v0 = Status.$values();
            Status.$VALUES = v0;
            Status.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        }

        private Status(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static EnumEntries getEntries() {
            return Status.$ENTRIES;
        }

        public static Status valueOf(String arg1) {
            return Enum.valueOf(Status.class, arg1);
        }

        public static Status[] values() {
            return Status.$VALUES.clone();
        }
    }

    public static final int $stable = 8;
    private final String error;
    private final List macroErrors;
    private final String originalJson;
    private final GameProfile profile;

    static {
    }

    public GameProfileLoadResult() {
        this(null, null, null, 7, null);
    }

    public GameProfileLoadResult(GameProfile arg2, String arg3, String arg4, int arg5, DefaultConstructorMarker arg6) {
        GameProfile v0 = null;
        if((arg5 & 1) != 0) {
            arg2 = v0;
        }

        if((arg5 & 2) != 0) {
            arg3 = ((String)v0);
        }

        if((arg5 & 4) != 0) {
            arg4 = ((String)v0);
        }

        this(arg2, arg3, arg4);
    }

    public GameProfileLoadResult(GameProfile arg4, String arg5, String arg6) {
        String v0_1;
        super();
        this.profile = arg4;
        this.originalJson = arg5;
        this.error = arg6;
        List v5 = null;
        List v4 = arg4 != null ? arg4.getControls() : v5;
        if(v4 == null) {
            v4 = CollectionsKt.emptyList();
        }

        ArrayList v6 = new ArrayList();
        Iterator v4_1 = ((Iterable)v4).iterator();
        while(v4_1.hasNext()) {
            Object v0 = v4_1.next();
            ControlComponent v1 = ((ProfileControl)v0).getComponent();
            if((v1 instanceof MacroScriptComponent)) {
            }
            else {
                v1 = ((ControlComponent)v5);
            }

            if(v1 != null) {
                RejectedMacroPayload v1_1 = ((MacroScriptComponent)v1).getRejectedPayload();
                if(v1_1 != null) {
                    v0_1 = ((ProfileControl)v0).getId() + ": " + v1_1.getReason();
                }
                else {
                    goto label_35;
                }
            }
            else {
            label_35:
                v0_1 = ((String)v5);
            }

            if(v0_1 == null) {
                continue;
            }

            ((Collection)v6).add(v0_1);
        }

        this.macroErrors = ((List)v6);
    }

    public final GameProfile component1() {
        return this.profile;
    }

    public final String component2() {
        return this.originalJson;
    }

    public final String component3() {
        return this.error;
    }

    public final GameProfileLoadResult copy(GameProfile arg1, String arg2, String arg3) {
        return new GameProfileLoadResult(arg1, arg2, arg3);
    }

    public static GameProfileLoadResult copy$default(GameProfileLoadResult arg0, GameProfile arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 1) != 0) {
            arg1 = arg0.profile;
        }

        if((arg4 & 2) != 0) {
            arg2 = arg0.originalJson;
        }

        if((arg4 & 4) != 0) {
            arg3 = arg0.error;
        }

        return arg0.copy(arg1, arg2, arg3);
    }

    public boolean equals(Object arg5) {
        if(this == (((GameProfileLoadResult)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GameProfileLoadResult)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.profile, ((GameProfileLoadResult)arg5).profile)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.originalJson, ((GameProfileLoadResult)arg5).originalJson)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.error, ((GameProfileLoadResult)arg5).error)) {
            return 0;
        }

        return 1;
    }

    public final String getError() {
        return this.error;
    }

    public final List getMacroErrors() {
        return this.macroErrors;
    }

    public final String getOriginalJson() {
        return this.originalJson;
    }

    public final GameProfile getProfile() {
        return this.profile;
    }

    public final Status getStatus() {
        if(this.originalJson == null) {
            return Status.MISSING;
        }

        if(this.profile == null) {
            return Status.INVALID_PROFILE;
        }

        if(!this.macroErrors.isEmpty()) {
            return Status.INVALID_MACROS;
        }

        return Status.VALID;
    }

    public int hashCode() {
        GameProfile v0 = this.profile;
        int v1 = 0;
        int v0_1 = v0 == null ? 0 : v0.hashCode();
        v0_1 *= 0x1F;
        String v2 = this.originalJson;
        int v2_1 = v2 == null ? 0 : v2.hashCode();
        v0_1 = (v0_1 + v2_1) * 0x1F;
        String v3 = this.error;
        if(v3 == null) {
        }
        else {
            v1 = v3.hashCode();
        }

        return v0_1 + v1;
    }

    public final void requireWritable$app(GameProfile arg10, String arg11) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg10, "updated");
        if(this.getStatus() == Status.INVALID_PROFILE) {
            goto label_66;
        }

        if(this.getStatus() != Status.INVALID_MACROS) {
        }
        else if(arg11 != null) {
            GameProfile v9 = this.profile;
            Intrinsics.checkNotNull(v9);
            List v9_1 = v9.getControls();
            ArrayList v0 = new ArrayList();
            Iterator v9_2 = ((Iterable)v9_1).iterator();
            while(v9_2.hasNext()) {
                v1 = v9_2.next();
                if(Intrinsics.areEqual(v1.getId(), arg11)) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            v9_1 = arg10.getControls();
            ArrayList v10 = new ArrayList();
            v9_2 = ((Iterable)v9_1).iterator();
            while(v9_2.hasNext()) {
                v1 = v9_2.next();
                if(Intrinsics.areEqual(v1.getId(), arg11)) {
                    continue;
                }

                ((Collection)v10).add(v1);
            }

            if(!Intrinsics.areEqual(v0, v10)) {
                throw new IllegalArgumentException("Recupera la macro sin sustituir los demás controles del perfil protegido".toString());
            }
        }
        else {
            goto label_46;
        }

        return;
    label_46:
        throw new IllegalArgumentException("Macros inválidas; JSON original protegido: " + CollectionsKt.joinToString$default(this.macroErrors, null, null, null, 0, null, null, 0x3F, null).toString());
    label_66:
        throw new IllegalArgumentException("Perfil inválido; JSON original protegido: " + this.error.toString());
    }

    public static void requireWritable$app$default(GameProfileLoadResult arg0, GameProfile arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = null;
        }

        arg0.requireWritable$app(arg1, arg2);
    }

    public String toString() {
        return "GameProfileLoadResult(profile=" + this.profile + ", originalJson=" + this.originalJson + ", error=" + this.error + ")";
    }
}

