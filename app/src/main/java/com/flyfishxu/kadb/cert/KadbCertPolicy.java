package com.flyfishxu.kadb.cert;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001CB/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001A\u00020\bHÆ\u0003J1\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001A\u00020\u00062\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001A\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001A\u001A\u00020\u001BHÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001D"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", "", "keySizeBits", "", "certValidityDays", "autoHealInvalidPrivateKey", "", "subject", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "<init>", "(IIZLcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;)V", "getKeySizeBits", "()I", "getCertValidityDays", "getAutoHealInvalidPrivateKey", "()Z", "getSubject", "()Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Subject", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class KadbCertPolicy {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001C\u001A\u00020\u001DHÖ\u0081\u0004J\n\u0010\u001E\u001A\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001F"}, d2={"Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "", "cn", "", "ou", "o", "l", "st", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCn", "()Ljava/lang/String;", "getOu", "getO", "getL", "getSt", "getC", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "kadb"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Subject {
        private final String c;
        private final String cn;
        private final String l;
        private final String o;
        private final String ou;
        private final String st;

        public Subject(String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, int arg8, DefaultConstructorMarker arg9) {
            if((arg8 & 1) != 0) {
                arg2 = "Adb";
            }

            String v0 = "";
            if((arg8 & 2) != 0) {
                arg3 = v0;
            }

            if((arg8 & 4) != 0) {
                arg4 = "Android";
            }

            if((arg8 & 8) != 0) {
                arg5 = v0;
            }

            if((arg8 & 16) != 0) {
                arg6 = v0;
            }

            if((arg8 & 0x20) != 0) {
                arg7 = "US";
            }

            this(arg2, arg3, arg4, arg5, arg6, arg7);
        }

        public Subject() {
            this(null, null, null, null, null, null, 0x3F, null);
        }

        public Subject(String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) {
            Intrinsics.checkNotNullParameter(arg2, "cn");
            Intrinsics.checkNotNullParameter(arg3, "ou");
            Intrinsics.checkNotNullParameter(arg4, "o");
            Intrinsics.checkNotNullParameter(arg5, "l");
            Intrinsics.checkNotNullParameter(arg6, "st");
            Intrinsics.checkNotNullParameter(arg7, "c");
            super();
            this.cn = arg2;
            this.ou = arg3;
            this.o = arg4;
            this.l = arg5;
            this.st = arg6;
            this.c = arg7;
        }

        public final String component1() {
            return this.cn;
        }

        public final String component2() {
            return this.ou;
        }

        public final String component3() {
            return this.o;
        }

        public final String component4() {
            return this.l;
        }

        public final String component5() {
            return this.st;
        }

        public final String component6() {
            return this.c;
        }

        public final Subject copy(String arg8, String arg9, String arg10, String arg11, String arg12, String arg13) {
            Intrinsics.checkNotNullParameter(arg8, "cn");
            Intrinsics.checkNotNullParameter(arg9, "ou");
            Intrinsics.checkNotNullParameter(arg10, "o");
            Intrinsics.checkNotNullParameter(arg11, "l");
            Intrinsics.checkNotNullParameter(arg12, "st");
            Intrinsics.checkNotNullParameter(arg13, "c");
            return new Subject(arg8, arg9, arg10, arg11, arg12, arg13);
        }

        public static Subject copy$default(Subject arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, int arg7, Object arg8) {
            if((arg7 & 1) != 0) {
                arg1 = arg0.cn;
            }

            if((arg7 & 2) != 0) {
                arg2 = arg0.ou;
            }

            if((arg7 & 4) != 0) {
                arg3 = arg0.o;
            }

            if((arg7 & 8) != 0) {
                arg4 = arg0.l;
            }

            if((arg7 & 16) != 0) {
                arg5 = arg0.st;
            }

            if((arg7 & 0x20) != 0) {
                arg6 = arg0.c;
            }

            return arg0.copy(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        public boolean equals(Object arg5) {
            if(this == (((Subject)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof Subject)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.cn, ((Subject)arg5).cn)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.ou, ((Subject)arg5).ou)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.o, ((Subject)arg5).o)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.l, ((Subject)arg5).l)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.st, ((Subject)arg5).st)) {
                return 0;
            }

            if(!Intrinsics.areEqual(this.c, ((Subject)arg5).c)) {
                return 0;
            }

            return 1;
        }

        public final String getC() {
            return this.c;
        }

        public final String getCn() {
            return this.cn;
        }

        public final String getL() {
            return this.l;
        }

        public final String getO() {
            return this.o;
        }

        public final String getOu() {
            return this.ou;
        }

        public final String getSt() {
            return this.st;
        }

        public int hashCode() {
            return ((((this.cn.hashCode() * 0x1F + this.ou.hashCode()) * 0x1F + this.o.hashCode()) * 0x1F + this.l.hashCode()) * 0x1F + this.st.hashCode()) * 0x1F + this.c.hashCode();
        }

        public String toString() {
            return "Subject(cn=" + this.cn + ", ou=" + this.ou + ", o=" + this.o + ", l=" + this.l + ", st=" + this.st + ", c=" + this.c + ")";
        }
    }

    private final boolean autoHealInvalidPrivateKey;
    private final int certValidityDays;
    private final int keySizeBits;
    private final Subject subject;

    public KadbCertPolicy(int arg10, int arg11, boolean arg12, Subject arg13, int arg14, DefaultConstructorMarker arg15) {
        if((arg14 & 1) != 0) {
            arg10 = 0x800;
        }

        if((arg14 & 2) != 0) {
            arg11 = 3650;
        }

        if((arg14 & 8) != 0) {
            arg13 = new Subject(null, null, null, null, null, null, 0x3F, null);
        }

        this(arg10, arg11, true, arg13);
    }

    public KadbCertPolicy() {
        this(0, 0, false, null, 15, null);
    }

    public KadbCertPolicy(int arg2, int arg3, boolean arg4, Subject arg5) {
        Intrinsics.checkNotNullParameter(arg5, "subject");
        super();
        this.keySizeBits = arg2;
        this.certValidityDays = arg3;
        this.autoHealInvalidPrivateKey = arg4;
        this.subject = arg5;
    }

    public final int component1() {
        return this.keySizeBits;
    }

    public final int component2() {
        return this.certValidityDays;
    }

    public final boolean component3() {
        return this.autoHealInvalidPrivateKey;
    }

    public final Subject component4() {
        return this.subject;
    }

    public final KadbCertPolicy copy(int arg1, int arg2, boolean arg3, Subject arg4) {
        Intrinsics.checkNotNullParameter(arg4, "subject");
        return new KadbCertPolicy(arg1, arg2, arg3, arg4);
    }

    public static KadbCertPolicy copy$default(KadbCertPolicy arg0, int arg1, int arg2, boolean arg3, Subject arg4, int arg5, Object arg6) {
        if((arg5 & 1) != 0) {
            arg1 = arg0.keySizeBits;
        }

        if((arg5 & 2) != 0) {
            arg2 = arg0.certValidityDays;
        }

        if((arg5 & 4) != 0) {
            arg3 = arg0.autoHealInvalidPrivateKey;
        }

        if((arg5 & 8) != 0) {
            arg4 = arg0.subject;
        }

        return arg0.copy(arg1, arg2, arg3, arg4);
    }

    public boolean equals(Object arg5) {
        if(this == (((KadbCertPolicy)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof KadbCertPolicy)) {
            return 0;
        }

        if(this.keySizeBits != ((KadbCertPolicy)arg5).keySizeBits) {
            return 0;
        }

        if(this.certValidityDays != ((KadbCertPolicy)arg5).certValidityDays) {
            return 0;
        }

        if(this.autoHealInvalidPrivateKey != ((KadbCertPolicy)arg5).autoHealInvalidPrivateKey) {
            return 0;
        }

        if(!Intrinsics.areEqual(this.subject, ((KadbCertPolicy)arg5).subject)) {
            return 0;
        }

        return 1;
    }

    public final boolean getAutoHealInvalidPrivateKey() {
        return this.autoHealInvalidPrivateKey;
    }

    public final int getCertValidityDays() {
        return this.certValidityDays;
    }

    public final int getKeySizeBits() {
        return this.keySizeBits;
    }

    public final Subject getSubject() {
        return this.subject;
    }

    public int hashCode() {
        return ((Integer.hashCode(this.keySizeBits) * 0x1F + Integer.hashCode(this.certValidityDays)) * 0x1F + Boolean.hashCode(this.autoHealInvalidPrivateKey)) * 0x1F + this.subject.hashCode();
    }

    public String toString() {
        return "KadbCertPolicy(keySizeBits=" + this.keySizeBits + ", certValidityDays=" + this.certValidityDays + ", autoHealInvalidPrivateKey=" + this.autoHealInvalidPrivateKey + ", subject=" + this.subject + ")";
    }
}

