package kotlin.text;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 52\u00060\u0001j\u0002`\u0002:\u000245B\u0011\bA\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\u0005\u0010\tB\u0019\bV\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\u0005\u0010\fB\u001F\bV\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000B0\u000E¢\u0006\u0004\b\u0005\u0010\u000FJ\u0012\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0086\u0084\u0004J\u0012\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0086\u0080\u0004J\u001E\u0010\u001A\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u001C\u001A\u00020\u001DH\u0086\u0080\u0004J\"\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001F2\u0006\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u001C\u001A\u00020\u001DH\u0086\u0080\u0004J\u0014\u0010 \u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u0018H\u0086\u0080\u0004J\u001C\u0010!\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u001DH\u0087\u0080\u0004J\u001A\u0010#\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010\"\u001A\u00020\u001DH\u0087\u0080\u0004J\u001A\u0010$\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010%\u001A\u00020\bH\u0086\u0080\u0004J&\u0010$\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u00182\u0012\u0010&\u001A\u000E\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\u00180\'H\u0086\u0080\u0004J\u001A\u0010(\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u00182\u0006\u0010%\u001A\u00020\bH\u0086\u0080\u0004J\"\u0010)\u001A\b\u0012\u0004\u0012\u00020\b0*2\u0006\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010+\u001A\u00020\u001DH\u0086\u0080\u0004J\"\u0010,\u001A\b\u0012\u0004\u0012\u00020\b0\u001F2\u0006\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010+\u001A\u00020\u001DH\u0087\u0080\u0004J\n\u0010-\u001A\u00020\bH\u0096\u0080\u0004J\n\u0010.\u001A\u00020\u0004H\u0086\u0080\u0004J\n\u0010/\u001A\u000200H\u0082\u0080\u0004J\u0012\u00101\u001A\u0002022\u0006\u0010\u0017\u001A\u000203H\u0082\u0080\u0004R\u000F\u0010\u0003\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001A\u00020\b8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u000EX\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001B\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000B0\u000E8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u00066"}, d2={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "nativePattern", "Ljava/util/regex/Pattern;", "<init>", "(Ljava/util/regex/Pattern;)V", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "getPattern", "()Ljava/lang/String;", "_options", "getOptions", "()Ljava/util/Set;", "matches", "", "input", "", "containsMatchIn", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchEntire", "matchAt", "index", "matchesAt", "replace", "replacement", "transform", "Lkotlin/Function1;", "replaceFirst", "split", "", "limit", "splitToSequence", "toString", "toPattern", "writeReplace", "", "readObject", "", "Ljava/io/ObjectInputStream;", "Serialized", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Regex implements Serializable {
    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\t\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0082\u0080\u0004¨\u0006\r"}, d2={"Lkotlin/text/Regex$Companion;", "", "<init>", "()V", "fromLiteral", "Lkotlin/text/Regex;", "literal", "", "escape", "escapeReplacement", "ensureUnicodeCase", "", "flags", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final int access$ensureUnicodeCase(Companion arg0, int arg1) {
            return arg0.ensureUnicodeCase(arg1);
        }

        private final int ensureUnicodeCase(int arg1) {
            if((arg1 & 2) != 0) {
                return arg1 | 0x40;
            }

            return arg1;
        }

        public final String escape(String arg1) {
            Intrinsics.checkNotNullParameter(arg1, "literal");
            String v0 = Pattern.quote(arg1);
            Intrinsics.checkNotNullExpressionValue(v0, "quote(...)");
            return v0;
        }

        public final String escapeReplacement(String arg1) {
            Intrinsics.checkNotNullParameter(arg1, "literal");
            String v0 = Matcher.quoteReplacement(arg1);
            Intrinsics.checkNotNullExpressionValue(v0, "quoteReplacement(...)");
            return v0;
        }

        public final Regex fromLiteral(String arg2) {
            Intrinsics.checkNotNullParameter(arg2, "literal");
            return new Regex(arg2, RegexOption.LITERAL);
        }
    }

    @Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000F2\u00060\u0001j\u0002`\u0002:\u0001\u000FB\u0019\bF\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004R\u0015\u0010\u0003\u001A\u00020\u0004X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001A\u00020\u0006X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006\u0010"}, d2={"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "<init>", "(Ljava/lang/String;I)V", "getPattern", "()Ljava/lang/String;", "getFlags", "()I", "readResolve", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Serialized implements Serializable {
        @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Lkotlin/text/Regex$Serialized$Companion;", "", "<init>", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class kotlin.text.Regex$Serialized$Companion {
            public kotlin.text.Regex$Serialized$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private kotlin.text.Regex$Serialized$Companion() {
                super();
            }
        }

        public static final kotlin.text.Regex$Serialized$Companion Companion;
        private final int flags;
        private final String pattern;
        private static final long serialVersionUID;

        static {
            Serialized.Companion = new kotlin.text.Regex$Serialized$Companion(null);
        }

        public Serialized(String arg2, int arg3) {
            Intrinsics.checkNotNullParameter(arg2, "pattern");
            super();
            this.pattern = arg2;
            this.flags = arg3;
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern v2 = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(v2, "compile(...)");
            return new Regex(v2);
        }
    }

    public static final Companion Companion;
    private Set _options;
    private final Pattern nativePattern;

    static {
        Regex.Companion = new Companion(null);
    }

    public Regex(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pattern");
        Pattern v2 = Pattern.compile(arg2);
        Intrinsics.checkNotNullExpressionValue(v2, "compile(...)");
        this(v2);
    }

    public Regex(String arg2, RegexOption arg3) {
        Intrinsics.checkNotNullParameter(arg2, "pattern");
        Intrinsics.checkNotNullParameter(arg3, "option");
        Pattern v2 = Pattern.compile(arg2, Companion.access$ensureUnicodeCase(Regex.Companion, arg3.getValue()));
        Intrinsics.checkNotNullExpressionValue(v2, "compile(...)");
        this(v2);
    }

    public Regex(Pattern arg2) {
        Intrinsics.checkNotNullParameter(arg2, "nativePattern");
        super();
        this.nativePattern = arg2;
    }

    public Regex(String arg2, Set arg3) {
        Intrinsics.checkNotNullParameter(arg2, "pattern");
        Intrinsics.checkNotNullParameter(arg3, "options");
        Pattern v2 = Pattern.compile(arg2, Companion.access$ensureUnicodeCase(Regex.Companion, RegexKt.access$toInt(((Iterable)arg3))));
        Intrinsics.checkNotNullExpressionValue(v2, "compile(...)");
        this(v2);
    }

    public static final Pattern access$getNativePattern$p(Regex arg0) {
        return arg0.nativePattern;
    }

    public final boolean containsMatchIn(CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        return this.nativePattern.matcher(arg2).find();
    }

    public final MatchResult find(CharSequence arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Matcher v1 = this.nativePattern.matcher(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "matcher(...)");
        return RegexKt.access$findNext(v1, arg3, arg2);
    }

    public static MatchResult find$default(Regex arg0, CharSequence arg1, int arg2, int arg3, Object arg4) {
        return arg0.find(arg1, 0);
    }

    public final Sequence findAll(CharSequence arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        if(arg4 >= 0 && arg4 <= arg3.length()) {
            return SequencesKt.generateSequence(new Regex$$ExternalSyntheticLambda0(this, arg3, arg4), Regex$findAll$2.INSTANCE);
        }

        throw new IndexOutOfBoundsException("Start index out of bounds: " + arg4 + ", input length: " + arg3.length());
    }

    public static Sequence findAll$default(Regex arg0, CharSequence arg1, int arg2, int arg3, Object arg4) {
        return arg0.findAll(arg1, 0);
    }

    static final MatchResult findAll$lambda$0(Regex arg0, CharSequence arg1, int arg2) {
        return arg0.find(arg1, arg2);
    }

    public final Set getOptions() {
        Set v0 = this._options;
        if(v0 == null) {
            int v0_1 = this.nativePattern.flags();
            EnumSet v1 = EnumSet.allOf(RegexOption.class);
            Intrinsics.checkNotNull(v1);
            CollectionsKt.retainAll(v1, new Regex$special$$inlined$fromInt$1(v0_1));
            v0 = Collections.unmodifiableSet(((Set)v1));
            Intrinsics.checkNotNullExpressionValue(v0, "unmodifiableSet(...)");
            this._options = v0;
        }

        return v0;
    }

    public final String getPattern() {
        String v1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(v1, "pattern(...)");
        return v1;
    }

    public final MatchResult matchAt(CharSequence arg2, int arg3) {
        MatcherMatchResult v3;
        Intrinsics.checkNotNullParameter(arg2, "input");
        Matcher v1 = this.nativePattern.matcher(arg2).useAnchoringBounds(false).useTransparentBounds(true).region(arg3, arg2.length());
        if(v1.lookingAt()) {
            Intrinsics.checkNotNull(v1);
            v3 = new MatcherMatchResult(v1, arg2);
        }
        else {
            MatchResult v3_1 = null;
        }

        return ((MatchResult)v3);
    }

    public final MatchResult matchEntire(CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Matcher v1 = this.nativePattern.matcher(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "matcher(...)");
        return RegexKt.access$matchEntire(v1, arg2);
    }

    public final boolean matches(CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        return this.nativePattern.matcher(arg2).matches();
    }

    public final boolean matchesAt(CharSequence arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        return this.nativePattern.matcher(arg2).useAnchoringBounds(false).useTransparentBounds(true).region(arg3, arg2.length()).lookingAt();
    }

    private final void readObject(ObjectInputStream arg1) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    public final String replace(CharSequence arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "input");
        Intrinsics.checkNotNullParameter(arg6, "transform");
        int v2 = 0;
        MatchResult v4 = Regex.find$default(this, arg5, 0, 2, null);
        if(v4 == null) {
            return arg5.toString();
        }

        int v0 = arg5.length();
        StringBuilder v1 = new StringBuilder(v0);
        do {
            v1.append(arg5, v2, v4.getRange().getStart().intValue());
            v1.append(arg6.invoke(v4));
            v2 = v4.getRange().getEndInclusive().intValue() + 1;
            v4 = v4.next();
            if(v2 >= v0) {
                break;
            }
        }
        while(v4 != null);

        if(v2 < v0) {
            v1.append(arg5, v2, v0);
        }

        String v4_1 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v4_1, "toString(...)");
        return v4_1;
    }

    public final String replace(CharSequence arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        String v1 = this.nativePattern.matcher(arg2).replaceAll(arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "replaceAll(...)");
        return v1;
    }

    public final String replaceFirst(CharSequence arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "input");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        String v1 = this.nativePattern.matcher(arg2).replaceFirst(arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "replaceFirst(...)");
        return v1;
    }

    public final List split(CharSequence arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "input");
        StringsKt.requireNonNegativeLimit(arg5);
        Matcher v3 = this.nativePattern.matcher(arg4);
        if(arg5 != 1) {
            if(!v3.find()) {
            }
            else {
                int v2 = 10;
                if(arg5 > 0) {
                    v2 = RangesKt.coerceAtMost(arg5, v2);
                }

                ArrayList v1 = new ArrayList(v2);
                --arg5;
                int v0 = 0;
                do {
                    v1.add(arg4.subSequence(v0, v3.start()).toString());
                    v0 = v3.end();
                    if(arg5 >= 0 && v1.size() == arg5) {
                        break;
                    }
                }
                while(v3.find());

                v1.add(arg4.subSequence(v0, arg4.length()).toString());
                return ((List)v1);
            }
        }

        return CollectionsKt.listOf(arg4.toString());
    }

    public static List split$default(Regex arg0, CharSequence arg1, int arg2, int arg3, Object arg4) {
        return arg0.split(arg1, 0);
    }

    public final Sequence splitToSequence(CharSequence arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "input");
        StringsKt.requireNonNegativeLimit(arg4);
        return SequencesKt.sequence(new Regex$splitToSequence$1(this, arg3, arg4, null));
    }

    public static Sequence splitToSequence$default(Regex arg0, CharSequence arg1, int arg2, int arg3, Object arg4) {
        return arg0.splitToSequence(arg1, 0);
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String v1 = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(v1, "toString(...)");
        return v1;
    }

    private final Object writeReplace() {
        String v1 = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(v1, "pattern(...)");
        return new Serialized(v1, this.nativePattern.flags());
    }
}

