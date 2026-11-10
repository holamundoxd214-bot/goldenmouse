package com.TryJeanPc.goldenmouse;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001D\b\u0081\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B\u0012\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\r\u0012\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010!\u001A\u00020\u0003HÆ\u0003J\t\u0010\"\u001A\u00020\u0003HÆ\u0003J\t\u0010#\u001A\u00020\u0003HÆ\u0003J\t\u0010$\u001A\u00020\u0007HÆ\u0003J\t\u0010%\u001A\u00020\tHÆ\u0003J\u000B\u0010&\u001A\u0004\u0018\u00010\u000BHÆ\u0003J\u0015\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\rHÆ\u0003J\u000F\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003Jm\u0010)\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0014\b\u0002\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\r2\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\u0013\u0010*\u001A\u00020\u000E2\b\u0010+\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001A\u00020\tHÖ\u0001J\t\u0010-\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\n\u001A\u0004\u0018\u00010\u000B¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u001D\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000E0\r¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u001ER\u0017\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u0006."}, d2={"Lcom/TryJeanPc/goldenmouse/RequirementDefinition;", "", "id", "", "name", "description", "type", "Lcom/TryJeanPc/goldenmouse/RequirementType;", "order", "", "action", "Lcom/TryJeanPc/goldenmouse/RequirementAction;", "isApplicable", "Lkotlin/Function1;", "", "check", "Lkotlin/Function0;", "Lcom/TryJeanPc/goldenmouse/RequirementStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/TryJeanPc/goldenmouse/RequirementType;ILcom/TryJeanPc/goldenmouse/RequirementAction;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getId", "()Ljava/lang/String;", "getName", "getDescription", "getType", "()Lcom/TryJeanPc/goldenmouse/RequirementType;", "getOrder", "()I", "getAction", "()Lcom/TryJeanPc/goldenmouse/RequirementAction;", "()Lkotlin/jvm/functions/Function1;", "getCheck", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RequirementDefinition {
    public static final int $stable;
    private final RequirementAction action;
    private final Function0 check;
    private final String description;
    private final String id;
    private final Function1 isApplicable;
    private final String name;
    private final int order;
    private final RequirementType type;

    static {
    }

    public RequirementDefinition(String arg11, String arg12, String arg13, RequirementType arg14, int arg15, RequirementAction arg16, Function1 arg17, Function0 arg18, int arg19, DefaultConstructorMarker arg20) {
        Function1 v8_1;
        RequirementAction v7 = (arg19 & 0x20) != 0 ? null : arg16;
        if((arg19 & 0x40) != 0) {
            RequirementDefinition$$ExternalSyntheticLambda0 v8 = new RequirementDefinition$$ExternalSyntheticLambda0();
        }
        else {
            v8_1 = arg17;
        }

        this(arg11, arg12, arg13, arg14, arg15, v7, v8_1, arg18);
    }

    public RequirementDefinition(String arg2, String arg3, String arg4, RequirementType arg5, int arg6, RequirementAction arg7, Function1 arg8, Function0 arg9) {
        Intrinsics.checkNotNullParameter(arg2, "id");
        Intrinsics.checkNotNullParameter(arg3, "name");
        Intrinsics.checkNotNullParameter(arg4, "description");
        Intrinsics.checkNotNullParameter(arg5, "type");
        Intrinsics.checkNotNullParameter(arg8, "isApplicable");
        Intrinsics.checkNotNullParameter(arg9, "check");
        super();
        this.id = arg2;
        this.name = arg3;
        this.description = arg4;
        this.type = arg5;
        this.order = arg6;
        this.action = arg7;
        this.isApplicable = arg8;
        this.check = arg9;
    }

    static final boolean _init_$lambda$0(int arg0) {
        return 1;
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final RequirementType component4() {
        return this.type;
    }

    public final int component5() {
        return this.order;
    }

    public final RequirementAction component6() {
        return this.action;
    }

    public final Function1 component7() {
        return this.isApplicable;
    }

    public final Function0 component8() {
        return this.check;
    }

    public final RequirementDefinition copy(String arg10, String arg11, String arg12, RequirementType arg13, int arg14, RequirementAction arg15, Function1 arg16, Function0 arg17) {
        Intrinsics.checkNotNullParameter(arg10, "id");
        Intrinsics.checkNotNullParameter(arg11, "name");
        Intrinsics.checkNotNullParameter(arg12, "description");
        Intrinsics.checkNotNullParameter(arg13, "type");
        Intrinsics.checkNotNullParameter(arg16, "isApplicable");
        Intrinsics.checkNotNullParameter(arg17, "check");
        return new RequirementDefinition(arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    public static RequirementDefinition copy$default(RequirementDefinition arg0, String arg1, String arg2, String arg3, RequirementType arg4, int arg5, RequirementAction arg6, Function1 arg7, Function0 arg8, int arg9, Object arg10) {
        if((arg9 & 1) != 0) {
            arg1 = arg0.id;
        }

        if((arg9 & 2) != 0) {
            arg2 = arg0.name;
        }

        if((arg9 & 4) != 0) {
            arg3 = arg0.description;
        }

        if((arg9 & 8) != 0) {
            arg4 = arg0.type;
        }

        if((arg9 & 16) != 0) {
            arg5 = arg0.order;
        }

        if((arg9 & 0x20) != 0) {
            arg6 = arg0.action;
        }

        if((arg9 & 0x40) != 0) {
            arg7 = arg0.isApplicable;
        }

        if((arg9 & 0x80) != 0) {
            arg8 = arg0.check;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public boolean equals(Object arg5) {
        if(this == (((RequirementDefinition)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof RequirementDefinition)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.id, ((RequirementDefinition)arg5).id)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.name, ((RequirementDefinition)arg5).name)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.description, ((RequirementDefinition)arg5).description)) {
            return 0;
        }

        if(this.type != ((RequirementDefinition)arg5).type) {
            return 0;
        }

        if(this.order != ((RequirementDefinition)arg5).order) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.action, ((RequirementDefinition)arg5).action)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.isApplicable, ((RequirementDefinition)arg5).isApplicable)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.check, ((RequirementDefinition)arg5).check)) {
            return 0;
        }

        return 1;
    }

    public final RequirementAction getAction() {
        return this.action;
    }

    public final Function0 getCheck() {
        return this.check;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOrder() {
        return this.order;
    }

    public final RequirementType getType() {
        return this.type;
    }

    public int hashCode() {
        int v0 = ((((this.id.hashCode() * 0x1F + this.name.hashCode()) * 0x1F + this.description.hashCode()) * 0x1F + this.type.hashCode()) * 0x1F + Integer.hashCode(this.order)) * 0x1F;
        RequirementAction v1 = this.action;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return ((v0 + v1_1) * 0x1F + this.isApplicable.hashCode()) * 0x1F + this.check.hashCode();
    }

    public final Function1 isApplicable() {
        return this.isApplicable;
    }

    public String toString() {
        return "RequirementDefinition(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", type=" + this.type + ", order=" + this.order + ", action=" + this.action + ", isApplicable=" + this.isApplicable + ", check=" + this.check + ")";
    }
}

