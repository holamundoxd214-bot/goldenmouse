package com.TryJeanPc.goldenmouse.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000F\u0012\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0014\u001A\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001A\u00020\u0003HÆ\u0003J\t\u0010)\u001A\u00020\u0005HÆ\u0003J\t\u0010*\u001A\u00020\u0003HÆ\u0003J\t\u0010+\u001A\u00020\u0003HÆ\u0003J\t\u0010,\u001A\u00020\u0003HÆ\u0003J\u000F\u0010-\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÆ\u0003J\t\u0010.\u001A\u00020\rHÆ\u0003J\u000F\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00030\u000FHÆ\u0003J\u0011\u00100\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u0015\u00101\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u00102\u001A\u00020\rHÆ\u0003J\u0097\u0001\u00103\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\b\b\u0002\u0010\f\u001A\u00020\r2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000F2\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0014\b\u0002\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001A\u00020\rHÆ\u0001J\u0013\u00104\u001A\u00020\r2\b\u00105\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001A\u00020\u0005HÖ\u0001J\t\u00107\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0018R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0018R\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0018R\u0017\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\f\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b \u0010!R\u0017\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u000F¢\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0019\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001FR\u001D\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001A\u0004\b%\u0010&R\u0011\u0010\u0014\u001A\u00020\r¢\u0006\b\n\u0000\u001A\u0004\b\'\u0010!¨\u00068"}, d2={"Lcom/TryJeanPc/goldenmouse/graphics/GraphicsRecord;", "", "session", "", "user", "", "pkg", "backend", "boot", "changes", "", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsChange;", "uncertain", "", "packages", "", "textureFeatures", "previous", "", "Lcom/TryJeanPc/goldenmouse/graphics/GraphicsValue;", "automatic", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/util/Set;Ljava/util/List;Ljava/util/Map;Z)V", "getSession", "()Ljava/lang/String;", "getUser", "()I", "getPkg", "getBackend", "getBoot", "getChanges", "()Ljava/util/List;", "getUncertain", "()Z", "getPackages", "()Ljava/util/Set;", "getTextureFeatures", "getPrevious", "()Ljava/util/Map;", "getAutomatic", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class GraphicsRecord {
    public static final int $stable = 8;
    private final boolean automatic;
    private final String backend;
    private final String boot;
    private final List changes;
    private final Set packages;
    private final String pkg;
    private final Map previous;
    private final String session;
    private final List textureFeatures;
    private final boolean uncertain;
    private final int user;

    static {
    }

    public GraphicsRecord(String arg2, int arg3, String arg4, String arg5, String arg6, List arg7, boolean arg8, Set arg9, List arg10, Map arg11, boolean arg12) {
        Iterator v2_1;
        Intrinsics.checkNotNullParameter(arg2, "session");
        Intrinsics.checkNotNullParameter(arg4, "pkg");
        Intrinsics.checkNotNullParameter(arg5, "backend");
        Intrinsics.checkNotNullParameter(arg6, "boot");
        Intrinsics.checkNotNullParameter(arg7, "changes");
        Intrinsics.checkNotNullParameter(arg9, "packages");
        Intrinsics.checkNotNullParameter(arg11, "previous");
        super();
        this.session = arg2;
        this.user = arg3;
        this.pkg = arg4;
        this.backend = arg5;
        this.boot = arg6;
        this.changes = arg7;
        this.uncertain = arg8;
        this.packages = arg9;
        this.textureFeatures = arg10;
        this.previous = arg11;
        this.automatic = arg12;
        int v2 = arg9.size();
        String v3 = "Failed requirement.";
        if(1 <= v2 && v2 < 65 && (arg9.contains(arg4))) {
            if(!(arg9 instanceof Collection) || !arg9.isEmpty()) {
                v2_1 = ((Iterable)arg9).iterator();
                while(v2_1.hasNext()) {
                    if(GraphicsProfileKt.validGraphicsPackage(v2_1.next())) {
                        continue;
                    }
                    else {
                        goto label_134;
                    }
                }
            }
            else {
            }

            v2 = this.changes.size();
            if(1 <= v2 && v2 < 17) {
                List v2_2 = this.changes;
                ArrayList v4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(((Iterable)v2_2), 10));
                v2_1 = ((Iterable)v2_2).iterator();
                while(v2_1.hasNext()) {
                    ((Collection)v4).add(v2_1.next().getKey());
                }

                if(CollectionsKt.distinct(((Iterable)v4)).size() == this.changes.size()) {
                    Set v2_3 = this.previous.keySet();
                    if(!(v2_3 instanceof Collection) || !v2_3.isEmpty()) {
                        v2_1 = ((Iterable)v2_3).iterator();
                        while(true) {
                            if(v2_1.hasNext()) {
                                Object v4_1 = v2_1.next();
                                List v5 = this.changes;
                                if(!(v5 instanceof Collection) || !v5.isEmpty()) {
                                    Iterator v5_1 = ((Iterable)v5).iterator();
                                    do {
                                        if(v5_1.hasNext()) {
                                            if(!Intrinsics.areEqual(v5_1.next().getKey(), v4_1)) {
                                                continue;
                                            }

                                            break;
                                        }

                                        goto label_95;
                                    }
                                    while(true);

                                    continue;
                                }

                                break;
                            }

                            goto label_99;
                        }

                    label_95:
                        throw new IllegalArgumentException(v3.toString());
                    }
                    else {
                    }

                label_99:
                    v2_2 = this.textureFeatures;
                    if(v2_2 != null) {
                        if(!((Collection)v2_2).isEmpty() && (Intrinsics.areEqual(CollectionsKt.distinct(this.textureFeatures), this.textureFeatures))) {
                            List v1 = this.textureFeatures;
                            if(((v1 instanceof Collection)) && (v1.isEmpty())) {
                                return;
                            }

                            Iterator v1_1 = ((Iterable)v1).iterator();
                            while(true) {
                                if(!v1_1.hasNext()) {
                                    return;
                                }

                                if(!new Regex("force(NearestFiltering|NearestMipFiltering|TextureLodOffset[1-4])").matches(v1_1.next())) {
                                    break;
                                }
                            }
                        }

                        throw new IllegalArgumentException(v3.toString());
                    }

                    return;
                }
            }

            throw new IllegalArgumentException(v3.toString());
        }

    label_134:
        throw new IllegalArgumentException(v3.toString());
    }

    public GraphicsRecord(String arg2, int arg3, String arg4, String arg5, String arg6, List arg7, boolean arg8, Set arg9, List arg10, Map arg11, boolean arg12, int arg13, DefaultConstructorMarker arg14) {
        if((arg13 & 0x80) != 0) {
            arg9 = SetsKt.setOf(arg4);
        }

        if((arg13 & 0x100) != 0) {
            arg10 = null;
        }

        if((arg13 & 0x200) != 0) {
            arg11 = MapsKt.emptyMap();
        }

        this(arg2, arg3, arg4, arg5, arg6, arg7, false, arg9, arg10, arg11, false);
    }

    public final String component1() {
        return this.session;
    }

    public final Map component10() {
        return this.previous;
    }

    public final boolean component11() {
        return this.automatic;
    }

    public final int component2() {
        return this.user;
    }

    public final String component3() {
        return this.pkg;
    }

    public final String component4() {
        return this.backend;
    }

    public final String component5() {
        return this.boot;
    }

    public final List component6() {
        return this.changes;
    }

    public final boolean component7() {
        return this.uncertain;
    }

    public final Set component8() {
        return this.packages;
    }

    public final List component9() {
        return this.textureFeatures;
    }

    public final GraphicsRecord copy(String arg13, int arg14, String arg15, String arg16, String arg17, List arg18, boolean arg19, Set arg20, List arg21, Map arg22, boolean arg23) {
        Intrinsics.checkNotNullParameter(arg13, "session");
        Intrinsics.checkNotNullParameter(arg15, "pkg");
        Intrinsics.checkNotNullParameter(arg16, "backend");
        Intrinsics.checkNotNullParameter(arg17, "boot");
        Intrinsics.checkNotNullParameter(arg18, "changes");
        Intrinsics.checkNotNullParameter(arg20, "packages");
        Intrinsics.checkNotNullParameter(arg22, "previous");
        return new GraphicsRecord(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23);
    }

    public static GraphicsRecord copy$default(GraphicsRecord arg0, String arg1, int arg2, String arg3, String arg4, String arg5, List arg6, boolean arg7, Set arg8, List arg9, Map arg10, boolean arg11, int arg12, Object arg13) {
        if((arg12 & 1) != 0) {
            arg1 = arg0.session;
        }

        if((arg12 & 2) != 0) {
            arg2 = arg0.user;
        }

        if((arg12 & 4) != 0) {
            arg3 = arg0.pkg;
        }

        if((arg12 & 8) != 0) {
            arg4 = arg0.backend;
        }

        if((arg12 & 16) != 0) {
            arg5 = arg0.boot;
        }

        if((arg12 & 0x20) != 0) {
            arg6 = arg0.changes;
        }

        if((arg12 & 0x40) != 0) {
            arg7 = arg0.uncertain;
        }

        if((arg12 & 0x80) != 0) {
            arg8 = arg0.packages;
        }

        if((arg12 & 0x100) != 0) {
            arg9 = arg0.textureFeatures;
        }

        if((arg12 & 0x200) != 0) {
            arg10 = arg0.previous;
        }

        if((arg12 & 0x400) != 0) {
            arg11 = arg0.automatic;
        }

        return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public boolean equals(Object arg5) {
        if(this == (((GraphicsRecord)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof GraphicsRecord)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.session, ((GraphicsRecord)arg5).session)) {
            return 0;
        }

        if(this.user != ((GraphicsRecord)arg5).user) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.pkg, ((GraphicsRecord)arg5).pkg)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.backend, ((GraphicsRecord)arg5).backend)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.boot, ((GraphicsRecord)arg5).boot)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.changes, ((GraphicsRecord)arg5).changes)) {
            return 0;
        }

        if(this.uncertain != ((GraphicsRecord)arg5).uncertain) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.packages, ((GraphicsRecord)arg5).packages)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.textureFeatures, ((GraphicsRecord)arg5).textureFeatures)) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.previous, ((GraphicsRecord)arg5).previous)) {
            return 0;
        }

        if(this.automatic != ((GraphicsRecord)arg5).automatic) {
            return 0;
        }

        return 1;
    }

    public final boolean getAutomatic() {
        return this.automatic;
    }

    public final String getBackend() {
        return this.backend;
    }

    public final String getBoot() {
        return this.boot;
    }

    public final List getChanges() {
        return this.changes;
    }

    public final Set getPackages() {
        return this.packages;
    }

    public final String getPkg() {
        return this.pkg;
    }

    public final Map getPrevious() {
        return this.previous;
    }

    public final String getSession() {
        return this.session;
    }

    public final List getTextureFeatures() {
        return this.textureFeatures;
    }

    public final boolean getUncertain() {
        return this.uncertain;
    }

    public final int getUser() {
        return this.user;
    }

    public int hashCode() {
        int v0 = (((((((this.session.hashCode() * 0x1F + Integer.hashCode(this.user)) * 0x1F + this.pkg.hashCode()) * 0x1F + this.backend.hashCode()) * 0x1F + this.boot.hashCode()) * 0x1F + this.changes.hashCode()) * 0x1F + Boolean.hashCode(this.uncertain)) * 0x1F + this.packages.hashCode()) * 0x1F;
        List v1 = this.textureFeatures;
        int v1_1 = v1 == null ? 0 : v1.hashCode();
        return ((v0 + v1_1) * 0x1F + this.previous.hashCode()) * 0x1F + Boolean.hashCode(this.automatic);
    }

    public String toString() {
        return "GraphicsRecord(session=" + this.session + ", user=" + this.user + ", pkg=" + this.pkg + ", backend=" + this.backend + ", boot=" + this.boot + ", changes=" + this.changes + ", uncertain=" + this.uncertain + ", packages=" + this.packages + ", textureFeatures=" + this.textureFeatures + ", previous=" + this.previous + ", automatic=" + this.automatic + ")";
    }
}

