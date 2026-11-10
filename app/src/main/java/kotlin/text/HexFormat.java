package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B!\b@\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0010\u001A\u00020\u0011H\u0096\u0080\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001A\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0016"}, d2={"Lkotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat;", "number", "Lkotlin/text/HexFormat$NumberHexFormat;", "<init>", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getUpperCase", "()Z", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "toString", "", "BytesHexFormat", "NumberHexFormat", "Builder", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class HexFormat {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\bA¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001A\u00020\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\u0088\u0004ø\u0001\u0000J&\u0010\u000F\u001A\u00020\u00142\u0017\u0010\u0015\u001A\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\u0088\u0004ø\u0001\u0000J\n\u0010\u0018\u001A\u00020\u0019H\u0081\u0080\u0004R\u001B\u0010\u0004\u001A\u00020\u0005X\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0015\u0010\n\u001A\u00020\u000B8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0011\u0010\u000E\u001A\u0004\u0018\u00010\u000BX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000F\u001A\u00020\u00108FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001A\u0004\u0018\u00010\u0010X\u0082\u008E\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001A"}, d2={"Lkotlin/text/HexFormat$Builder;", "", "<init>", "()V", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "bytes", "Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_bytes", "number", "Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "_number", "", "builderAction", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "build", "Lkotlin/text/HexFormat;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Builder {
        private kotlin.text.HexFormat$BytesHexFormat$Builder _bytes;
        private kotlin.text.HexFormat$NumberHexFormat$Builder _number;
        private boolean upperCase;

        public Builder() {
            super();
            this.upperCase = HexFormat.Companion.getDefault().getUpperCase();
        }

        public final HexFormat build() {
            NumberHexFormat v3_1;
            BytesHexFormat v2_1;
            boolean v1 = this.upperCase;
            kotlin.text.HexFormat$BytesHexFormat$Builder v2 = this._bytes;
            if(v2 != null) {
                v2_1 = v2.build$kotlin_stdlib();
                if(v2_1 == null) {
                    goto label_6;
                }
            }
            else {
            label_6:
                v2_1 = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            }

            kotlin.text.HexFormat$NumberHexFormat$Builder v3 = this._number;
            if(v3 != null) {
                v3_1 = v3.build$kotlin_stdlib();
                if(v3_1 == null) {
                    goto label_12;
                }
            }
            else {
            label_12:
                v3_1 = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
            }

            return new HexFormat(v1, v2_1, v3_1);
        }

        private final void bytes(Function1 arg2) {
            Intrinsics.checkNotNullParameter(arg2, "builderAction");
            arg2.invoke(this.getBytes());
        }

        public final kotlin.text.HexFormat$BytesHexFormat$Builder getBytes() {
            kotlin.text.HexFormat$BytesHexFormat$Builder v0 = this._bytes;
            if(v0 == null) {
                v0 = new kotlin.text.HexFormat$BytesHexFormat$Builder();
                this._bytes = v0;
            }

            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final kotlin.text.HexFormat$NumberHexFormat$Builder getNumber() {
            kotlin.text.HexFormat$NumberHexFormat$Builder v0 = this._number;
            if(v0 == null) {
                v0 = new kotlin.text.HexFormat$NumberHexFormat$Builder();
                this._number = v0;
            }

            Intrinsics.checkNotNull(v0);
            return v0;
        }

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        private final void number(Function1 arg2) {
            Intrinsics.checkNotNullParameter(arg2, "builderAction");
            arg2.invoke(this.getNumber());
        }

        public final void setUpperCase(boolean arg1) {
            this.upperCase = arg1;
        }
    }

    @Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B9\b@\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\u000BJ\n\u0010\u001C\u001A\u00020\u0006H\u0096\u0080\u0004J)\u0010\u001D\u001A\u00060\u001Ej\u0002`\u001F2\n\u0010 \u001A\u00060\u001Ej\u0002`\u001F2\u0006\u0010!\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0004\b\"\u0010#R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0015\u0010\u0007\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010R\u0015\u0010\b\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0010R\u0015\u0010\t\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0010R\u0015\u0010\u0014\u001A\u00020\u0015X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0018\u001A\u00020\u0015X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0017R\u0015\u0010\u001A\u001A\u00020\u0015X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0017¨\u0006&"}, d2={"Lkotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytesPerLine", "()I", "getBytesPerGroup", "getGroupSeparator", "()Ljava/lang/String;", "getByteSeparator", "getBytePrefix", "getByteSuffix", "noLineAndGroupSeparator", "", "getNoLineAndGroupSeparator$kotlin_stdlib", "()Z", "shortByteSeparatorNoPrefixAndSuffix", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class BytesHexFormat {
        @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b@¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u001D\u001A\u00020\u001EH\u0080\u0080\u0004¢\u0006\u0002\b\u001FR%\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR%\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001B\u0010\u000E\u001A\u00020\u000FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R%\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\u0004\u001A\u00020\u000F@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R%\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0004\u001A\u00020\u000F@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R%\u0010\u001A\u001A\u00020\u000F2\u0006\u0010\u0004\u001A\u00020\u000F@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0011\"\u0004\b\u001C\u0010\u0013¨\u0006 "}, d2={"Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "", "<init>", "()V", "value", "", "bytesPerLine", "getBytesPerLine", "()I", "setBytesPerLine", "(I)V", "bytesPerGroup", "getBytesPerGroup", "setBytesPerGroup", "groupSeparator", "", "getGroupSeparator", "()Ljava/lang/String;", "setGroupSeparator", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "bytePrefix", "getBytePrefix", "setBytePrefix", "byteSuffix", "getByteSuffix", "setByteSuffix", "build", "Lkotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.text.HexFormat$BytesHexFormat$Builder {
            private String bytePrefix;
            private String byteSeparator;
            private String byteSuffix;
            private int bytesPerGroup;
            private int bytesPerLine;
            private String groupSeparator;

            public kotlin.text.HexFormat$BytesHexFormat$Builder() {
                super();
                this.bytesPerLine = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerLine();
                this.bytesPerGroup = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerGroup();
                this.groupSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getGroupSeparator();
                this.byteSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSeparator();
                this.bytePrefix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytePrefix();
                this.byteSuffix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSuffix();
            }

            public final BytesHexFormat build$kotlin_stdlib() {
                return new BytesHexFormat(this.bytesPerLine, this.bytesPerGroup, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
            }

            public final String getBytePrefix() {
                return this.bytePrefix;
            }

            public final String getByteSeparator() {
                return this.byteSeparator;
            }

            public final String getByteSuffix() {
                return this.byteSuffix;
            }

            public final int getBytesPerGroup() {
                return this.bytesPerGroup;
            }

            public final int getBytesPerLine() {
                return this.bytesPerLine;
            }

            public final String getGroupSeparator() {
                return this.groupSeparator;
            }

            public final void setBytePrefix(String arg6) {
                Intrinsics.checkNotNullParameter(arg6, "value");
                String v0 = arg6;
                int v3 = 2;
                Object v4 = null;
                if(!StringsKt.contains$default(((CharSequence)v0), '\n', false, v3, v4) && !StringsKt.contains$default(((CharSequence)v0), '\r', false, v3, v4)) {
                    this.bytePrefix = arg6;
                    return;
                }

                throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + arg6);
            }

            public final void setByteSeparator(String arg6) {
                Intrinsics.checkNotNullParameter(arg6, "value");
                String v0 = arg6;
                int v3 = 2;
                Object v4 = null;
                if(!StringsKt.contains$default(((CharSequence)v0), '\n', false, v3, v4) && !StringsKt.contains$default(((CharSequence)v0), '\r', false, v3, v4)) {
                    this.byteSeparator = arg6;
                    return;
                }

                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + arg6);
            }

            public final void setByteSuffix(String arg6) {
                Intrinsics.checkNotNullParameter(arg6, "value");
                String v0 = arg6;
                int v3 = 2;
                Object v4 = null;
                if(!StringsKt.contains$default(((CharSequence)v0), '\n', false, v3, v4) && !StringsKt.contains$default(((CharSequence)v0), '\r', false, v3, v4)) {
                    this.byteSuffix = arg6;
                    return;
                }

                throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + arg6);
            }

            public final void setBytesPerGroup(int arg3) {
                if(arg3 > 0) {
                    this.bytesPerGroup = arg3;
                    return;
                }

                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + arg3);
            }

            public final void setBytesPerLine(int arg3) {
                if(arg3 > 0) {
                    this.bytesPerLine = arg3;
                    return;
                }

                throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + arg3);
            }

            public final void setGroupSeparator(String arg2) {
                Intrinsics.checkNotNullParameter(arg2, "<set-?>");
                this.groupSeparator = arg2;
            }
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/text/HexFormat$BytesHexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.Default;
            }
        }

        public static final Companion Companion;
        private static final BytesHexFormat Default;
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;
        private final boolean ignoreCase;
        private final boolean noLineAndGroupSeparator;
        private final boolean shortByteSeparatorNoPrefixAndSuffix;

        static {
            BytesHexFormat.Companion = new Companion(null);
            BytesHexFormat.Default = new BytesHexFormat(0x7FFFFFFF, 0x7FFFFFFF, "  ", "", "", "");
        }

        public BytesHexFormat(int arg4, int arg5, String arg6, String arg7, String arg8, String arg9) {
            Intrinsics.checkNotNullParameter(arg6, "groupSeparator");
            Intrinsics.checkNotNullParameter(arg7, "byteSeparator");
            Intrinsics.checkNotNullParameter(arg8, "bytePrefix");
            Intrinsics.checkNotNullParameter(arg9, "byteSuffix");
            super();
            this.bytesPerLine = arg4;
            this.bytesPerGroup = arg5;
            this.groupSeparator = arg6;
            this.byteSeparator = arg7;
            this.bytePrefix = arg8;
            this.byteSuffix = arg9;
            boolean v0 = false;
            int v2 = 0x7FFFFFFF;
            boolean v4 = arg4 != v2 || arg5 != v2 ? false : true;
            this.noLineAndGroupSeparator = v4;
            v4 = arg8.length() != 0 || arg9.length() != 0 || arg7.length() > 1 ? false : true;
            this.shortByteSeparatorNoPrefixAndSuffix = v4;
            if((HexFormatKt.access$isCaseSensitive(arg6)) || (HexFormatKt.access$isCaseSensitive(arg7)) || (HexFormatKt.access$isCaseSensitive(arg8)) || (HexFormatKt.access$isCaseSensitive(arg9))) {
                v0 = true;
            }

            this.ignoreCase = v0;
        }

        public static final BytesHexFormat access$getDefault$cp() {
            return BytesHexFormat.Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder arg5, String arg6) {
            Intrinsics.checkNotNullParameter(arg5, "sb");
            Intrinsics.checkNotNullParameter(arg6, "indent");
            arg5.append(arg6).append("bytesPerLine = ").append(this.bytesPerLine).append(",").append('\n');
            arg5.append(arg6).append("bytesPerGroup = ").append(this.bytesPerGroup).append(",").append('\n');
            arg5.append(arg6).append("groupSeparator = \"").append(this.groupSeparator).append("\",").append('\n');
            arg5.append(arg6).append("byteSeparator = \"").append(this.byteSeparator).append("\",").append('\n');
            arg5.append(arg6).append("bytePrefix = \"").append(this.bytePrefix).append("\",").append('\n');
            arg5.append(arg6).append("byteSuffix = \"").append(this.byteSuffix).append("\"");
            return arg5;
        }

        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final boolean getNoLineAndGroupSeparator$kotlin_stdlib() {
            return this.noLineAndGroupSeparator;
        }

        public final boolean getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() {
            return this.shortByteSeparatorNoPrefixAndSuffix;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder();
            v0.append("BytesHexFormat(\n");
            this.appendOptionsTo$kotlin_stdlib(v0, "    ").append('\n');
            v0.append(")");
            return v0.toString();
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0015\u0010\b\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Lkotlin/text/HexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.text.HexFormat$Companion {
        public kotlin.text.HexFormat$Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private kotlin.text.HexFormat$Companion() {
            super();
        }

        public final HexFormat getDefault() {
            return HexFormat.Default;
        }

        public final HexFormat getUpperCase() {
            return HexFormat.UpperCase;
        }
    }

    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B)\b@\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\n\u0010\u001A\u001A\u00020\u0003H\u0096\u0080\u0004J)\u0010\u001B\u001A\u00060\u001Cj\u0002`\u001D2\n\u0010\u001E\u001A\u00060\u001Cj\u0002`\u001D2\u0006\u0010\u001F\u001A\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0004\b \u0010!R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0015\u0010\u0004\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u001D\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0084\b¢\u0006\u000E\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001A\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000FR\u0015\u0010\u0016\u001A\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000FR\u0015\u0010\u0018\u001A\u00020\u0006X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u000F¨\u0006$"}, d2={"Lkotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "minLength", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getPrefix", "()Ljava/lang/String;", "getSuffix", "getRemoveLeadingZeros", "()Z", "getMinLength$annotations", "()V", "getMinLength", "()I", "isDigitsOnly", "isDigitsOnly$kotlin_stdlib", "isDigitsOnlyAndNoPadding", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class NumberHexFormat {
        @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b@¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u001CH\u0080\u0080\u0004¢\u0006\u0002\b\u001DR%\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR%\u0010\u000B\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0005@FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001B\u0010\u000E\u001A\u00020\u000FX\u0086\u008E\b¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R-\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0004\u001A\u00020\u00148\u0006@FX\u0087\u008E\b¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001E"}, d2={"Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "", "<init>", "()V", "value", "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "suffix", "getSuffix", "setSuffix", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "", "minLength", "getMinLength$annotations", "getMinLength", "()I", "setMinLength", "(I)V", "build", "Lkotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.text.HexFormat$NumberHexFormat$Builder {
            private int minLength;
            private String prefix;
            private boolean removeLeadingZeros;
            private String suffix;

            public kotlin.text.HexFormat$NumberHexFormat$Builder() {
                super();
                this.prefix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getPrefix();
                this.suffix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getSuffix();
                this.removeLeadingZeros = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
                this.minLength = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getMinLength();
            }

            public final NumberHexFormat build$kotlin_stdlib() {
                return new NumberHexFormat(this.prefix, this.suffix, this.removeLeadingZeros, this.minLength);
            }

            public final int getMinLength() {
                return this.minLength;
            }

            public static void getMinLength$annotations() {
            }

            public final String getPrefix() {
                return this.prefix;
            }

            public final boolean getRemoveLeadingZeros() {
                return this.removeLeadingZeros;
            }

            public final String getSuffix() {
                return this.suffix;
            }

            public final void setMinLength(int arg2) {
                if(arg2 > 0) {
                    this.minLength = arg2;
                    return;
                }

                throw new IllegalArgumentException("Non-positive values are prohibited for minLength, but was " + arg2.toString());
            }

            public final void setPrefix(String arg6) {
                Intrinsics.checkNotNullParameter(arg6, "value");
                String v0 = arg6;
                int v3 = 2;
                Object v4 = null;
                if(!StringsKt.contains$default(((CharSequence)v0), '\n', false, v3, v4) && !StringsKt.contains$default(((CharSequence)v0), '\r', false, v3, v4)) {
                    this.prefix = arg6;
                    return;
                }

                throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + arg6);
            }

            public final void setRemoveLeadingZeros(boolean arg1) {
                this.removeLeadingZeros = arg1;
            }

            public final void setSuffix(String arg6) {
                Intrinsics.checkNotNullParameter(arg6, "value");
                String v0 = arg6;
                int v3 = 2;
                Object v4 = null;
                if(!StringsKt.contains$default(((CharSequence)v0), '\n', false, v3, v4) && !StringsKt.contains$default(((CharSequence)v0), '\r', false, v3, v4)) {
                    this.suffix = arg6;
                    return;
                }

                throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + arg6);
            }
        }

        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0015\u0010\u0004\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2={"Lkotlin/text/HexFormat$NumberHexFormat$Companion;", "", "<init>", "()V", "Default", "Lkotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.text.HexFormat$NumberHexFormat$Companion {
            public kotlin.text.HexFormat$NumberHexFormat$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private kotlin.text.HexFormat$NumberHexFormat$Companion() {
                super();
            }

            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.Default;
            }
        }

        public static final kotlin.text.HexFormat$NumberHexFormat$Companion Companion;
        private static final NumberHexFormat Default;
        private final boolean ignoreCase;
        private final boolean isDigitsOnly;
        private final boolean isDigitsOnlyAndNoPadding;
        private final int minLength;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;

        static {
            NumberHexFormat.Companion = new kotlin.text.HexFormat$NumberHexFormat$Companion(null);
            NumberHexFormat.Default = new NumberHexFormat("", "", false, 1);
        }

        public NumberHexFormat(String arg3, String arg4, boolean arg5, int arg6) {
            Intrinsics.checkNotNullParameter(arg3, "prefix");
            Intrinsics.checkNotNullParameter(arg4, "suffix");
            super();
            this.prefix = arg3;
            this.suffix = arg4;
            this.removeLeadingZeros = arg5;
            this.minLength = arg6;
            boolean v0 = false;
            arg5 = arg3.length() != 0 || arg4.length() != 0 ? false : true;
            this.isDigitsOnly = arg5;
            arg5 = !arg5 || arg6 != 1 ? false : true;
            this.isDigitsOnlyAndNoPadding = arg5;
            if((HexFormatKt.access$isCaseSensitive(arg3)) || (HexFormatKt.access$isCaseSensitive(arg4))) {
                v0 = true;
            }

            this.ignoreCase = v0;
        }

        public static final NumberHexFormat access$getDefault$cp() {
            return NumberHexFormat.Default;
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder arg5, String arg6) {
            Intrinsics.checkNotNullParameter(arg5, "sb");
            Intrinsics.checkNotNullParameter(arg6, "indent");
            arg5.append(arg6).append("prefix = \"").append(this.prefix).append("\",").append('\n');
            arg5.append(arg6).append("suffix = \"").append(this.suffix).append("\",").append('\n');
            arg5.append(arg6).append("removeLeadingZeros = ").append(this.removeLeadingZeros).append(',').append('\n');
            arg5.append(arg6).append("minLength = ").append(this.minLength);
            return arg5;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public final int getMinLength() {
            return this.minLength;
        }

        public static void getMinLength$annotations() {
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final boolean isDigitsOnly$kotlin_stdlib() {
            return this.isDigitsOnly;
        }

        public final boolean isDigitsOnlyAndNoPadding$kotlin_stdlib() {
            return this.isDigitsOnlyAndNoPadding;
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder();
            v0.append("NumberHexFormat(\n");
            this.appendOptionsTo$kotlin_stdlib(v0, "    ").append('\n');
            v0.append(")");
            return v0.toString();
        }
    }

    public static final kotlin.text.HexFormat$Companion Companion;
    private static final HexFormat Default;
    private static final HexFormat UpperCase;
    private final BytesHexFormat bytes;
    private final NumberHexFormat number;
    private final boolean upperCase;

    static {
        HexFormat.Companion = new kotlin.text.HexFormat$Companion(null);
        HexFormat.Default = new HexFormat(false, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
        HexFormat.UpperCase = new HexFormat(true, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
    }

    public HexFormat(boolean arg2, BytesHexFormat arg3, NumberHexFormat arg4) {
        Intrinsics.checkNotNullParameter(arg3, "bytes");
        Intrinsics.checkNotNullParameter(arg4, "number");
        super();
        this.upperCase = arg2;
        this.bytes = arg3;
        this.number = arg4;
    }

    public static final HexFormat access$getDefault$cp() {
        return HexFormat.Default;
    }

    public static final HexFormat access$getUpperCase$cp() {
        return HexFormat.UpperCase;
    }

    public final BytesHexFormat getBytes() {
        return this.bytes;
    }

    public final NumberHexFormat getNumber() {
        return this.number;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public String toString() {
        StringBuilder v0 = new StringBuilder();
        v0.append("HexFormat(\n    upperCase = ");
        v0.append(this.upperCase).append(",\n    bytes = BytesHexFormat(\n");
        this.bytes.appendOptionsTo$kotlin_stdlib(v0, "        ").append('\n');
        v0.append("    ),").append('\n');
        v0.append("    number = NumberHexFormat(").append('\n');
        this.number.appendOptionsTo$kotlin_stdlib(v0, "        ").append('\n');
        v0.append("    )").append('\n');
        v0.append(")");
        return v0.toString();
    }
}

