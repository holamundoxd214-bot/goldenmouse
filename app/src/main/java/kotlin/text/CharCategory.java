package kotlin.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b%\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u0019\bB\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010*\u001A\u00020+2\u0006\u0010,\u001A\u00020-H\u0086\u0082\u0004R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001Bj\u0002\b\u001Cj\u0002\b\u001Dj\u0002\b\u001Ej\u0002\b\u001Fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'j\u0002\b(j\u0002\b)¨\u0006/"}, d2={"Lkotlin/text/CharCategory;", "", "value", "", "code", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getCode", "()Ljava/lang/String;", "UNASSIGNED", "UPPERCASE_LETTER", "LOWERCASE_LETTER", "TITLECASE_LETTER", "MODIFIER_LETTER", "OTHER_LETTER", "NON_SPACING_MARK", "ENCLOSING_MARK", "COMBINING_SPACING_MARK", "DECIMAL_DIGIT_NUMBER", "LETTER_NUMBER", "OTHER_NUMBER", "SPACE_SEPARATOR", "LINE_SEPARATOR", "PARAGRAPH_SEPARATOR", "CONTROL", "FORMAT", "PRIVATE_USE", "SURROGATE", "DASH_PUNCTUATION", "START_PUNCTUATION", "END_PUNCTUATION", "CONNECTOR_PUNCTUATION", "OTHER_PUNCTUATION", "MATH_SYMBOL", "CURRENCY_SYMBOL", "MODIFIER_SYMBOL", "OTHER_SYMBOL", "INITIAL_QUOTE_PUNCTUATION", "FINAL_QUOTE_PUNCTUATION", "contains", "", "char", "", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum CharCategory {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\u0080\u0004¨\u0006\b"}, d2={"Lkotlin/text/CharCategory$Companion;", "", "<init>", "()V", "valueOf", "Lkotlin/text/CharCategory;", "category", "", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final CharCategory valueOf(int arg3) {
            if(arg3 >= 0 && arg3 < 17) {
                return CharCategory.getEntries().get(arg3);
            }

            if(18 <= arg3 && arg3 < 0x1F) {
                return CharCategory.getEntries().get(arg3 - 1);
            }

            throw new IllegalArgumentException("Category #" + arg3 + " is not defined.");
        }
    }

    public static final enum CharCategory COMBINING_SPACING_MARK;
    public static final enum CharCategory CONNECTOR_PUNCTUATION;
    public static final enum CharCategory CONTROL;
    public static final enum CharCategory CURRENCY_SYMBOL;
    public static final Companion Companion;
    public static final enum CharCategory DASH_PUNCTUATION;
    public static final enum CharCategory DECIMAL_DIGIT_NUMBER;
    public static final enum CharCategory ENCLOSING_MARK;
    public static final enum CharCategory END_PUNCTUATION;
    public static final enum CharCategory FINAL_QUOTE_PUNCTUATION;
    public static final enum CharCategory FORMAT;
    public static final enum CharCategory INITIAL_QUOTE_PUNCTUATION;
    public static final enum CharCategory LETTER_NUMBER;
    public static final enum CharCategory LINE_SEPARATOR;
    public static final enum CharCategory LOWERCASE_LETTER;
    public static final enum CharCategory MATH_SYMBOL;
    public static final enum CharCategory MODIFIER_LETTER;
    public static final enum CharCategory MODIFIER_SYMBOL;
    public static final enum CharCategory NON_SPACING_MARK;
    public static final enum CharCategory OTHER_LETTER;
    public static final enum CharCategory OTHER_NUMBER;
    public static final enum CharCategory OTHER_PUNCTUATION;
    public static final enum CharCategory OTHER_SYMBOL;
    public static final enum CharCategory PARAGRAPH_SEPARATOR;
    public static final enum CharCategory PRIVATE_USE;
    public static final enum CharCategory SPACE_SEPARATOR;
    public static final enum CharCategory START_PUNCTUATION;
    public static final enum CharCategory SURROGATE;
    public static final enum CharCategory TITLECASE_LETTER;
    public static final enum CharCategory UNASSIGNED;
    public static final enum CharCategory UPPERCASE_LETTER;
    private final String code;
    private final int value;

    private static final CharCategory[] $values() {
        return new CharCategory[]{CharCategory.UNASSIGNED, CharCategory.UPPERCASE_LETTER, CharCategory.LOWERCASE_LETTER, CharCategory.TITLECASE_LETTER, CharCategory.MODIFIER_LETTER, CharCategory.OTHER_LETTER, CharCategory.NON_SPACING_MARK, CharCategory.ENCLOSING_MARK, CharCategory.COMBINING_SPACING_MARK, CharCategory.DECIMAL_DIGIT_NUMBER, CharCategory.LETTER_NUMBER, CharCategory.OTHER_NUMBER, CharCategory.SPACE_SEPARATOR, CharCategory.LINE_SEPARATOR, CharCategory.PARAGRAPH_SEPARATOR, CharCategory.CONTROL, CharCategory.FORMAT, CharCategory.PRIVATE_USE, CharCategory.SURROGATE, CharCategory.DASH_PUNCTUATION, CharCategory.START_PUNCTUATION, CharCategory.END_PUNCTUATION, CharCategory.CONNECTOR_PUNCTUATION, CharCategory.OTHER_PUNCTUATION, CharCategory.MATH_SYMBOL, CharCategory.CURRENCY_SYMBOL, CharCategory.MODIFIER_SYMBOL, CharCategory.OTHER_SYMBOL, CharCategory.INITIAL_QUOTE_PUNCTUATION, CharCategory.FINAL_QUOTE_PUNCTUATION};
    }

    static {
        CharCategory.UNASSIGNED = new CharCategory("UNASSIGNED", 0, 0, "Cn");
        CharCategory.UPPERCASE_LETTER = new CharCategory("UPPERCASE_LETTER", 1, 1, "Lu");
        CharCategory.LOWERCASE_LETTER = new CharCategory("LOWERCASE_LETTER", 2, 2, "Ll");
        CharCategory.TITLECASE_LETTER = new CharCategory("TITLECASE_LETTER", 3, 3, "Lt");
        CharCategory.MODIFIER_LETTER = new CharCategory("MODIFIER_LETTER", 4, 4, "Lm");
        CharCategory.OTHER_LETTER = new CharCategory("OTHER_LETTER", 5, 5, "Lo");
        CharCategory.NON_SPACING_MARK = new CharCategory("NON_SPACING_MARK", 6, 6, "Mn");
        CharCategory.ENCLOSING_MARK = new CharCategory("ENCLOSING_MARK", 7, 7, "Me");
        CharCategory.COMBINING_SPACING_MARK = new CharCategory("COMBINING_SPACING_MARK", 8, 8, "Mc");
        CharCategory.DECIMAL_DIGIT_NUMBER = new CharCategory("DECIMAL_DIGIT_NUMBER", 9, 9, "Nd");
        CharCategory.LETTER_NUMBER = new CharCategory("LETTER_NUMBER", 10, 10, "Nl");
        CharCategory.OTHER_NUMBER = new CharCategory("OTHER_NUMBER", 11, 11, "No");
        CharCategory.SPACE_SEPARATOR = new CharCategory("SPACE_SEPARATOR", 12, 12, "Zs");
        CharCategory.LINE_SEPARATOR = new CharCategory("LINE_SEPARATOR", 13, 13, "Zl");
        CharCategory.PARAGRAPH_SEPARATOR = new CharCategory("PARAGRAPH_SEPARATOR", 14, 14, "Zp");
        CharCategory.CONTROL = new CharCategory("CONTROL", 15, 15, "Cc");
        CharCategory.FORMAT = new CharCategory("FORMAT", 16, 16, "Cf");
        CharCategory.PRIVATE_USE = new CharCategory("PRIVATE_USE", 17, 18, "Co");
        CharCategory.SURROGATE = new CharCategory("SURROGATE", 18, 19, "Cs");
        CharCategory.DASH_PUNCTUATION = new CharCategory("DASH_PUNCTUATION", 19, 20, "Pd");
        CharCategory.START_PUNCTUATION = new CharCategory("START_PUNCTUATION", 20, 21, "Ps");
        CharCategory.END_PUNCTUATION = new CharCategory("END_PUNCTUATION", 21, 22, "Pe");
        CharCategory.CONNECTOR_PUNCTUATION = new CharCategory("CONNECTOR_PUNCTUATION", 22, 23, "Pc");
        CharCategory.OTHER_PUNCTUATION = new CharCategory("OTHER_PUNCTUATION", 23, 24, "Po");
        CharCategory.MATH_SYMBOL = new CharCategory("MATH_SYMBOL", 24, 25, "Sm");
        CharCategory.CURRENCY_SYMBOL = new CharCategory("CURRENCY_SYMBOL", 25, 26, "Sc");
        CharCategory.MODIFIER_SYMBOL = new CharCategory("MODIFIER_SYMBOL", 26, 27, "Sk");
        CharCategory.OTHER_SYMBOL = new CharCategory("OTHER_SYMBOL", 27, 28, "So");
        CharCategory.INITIAL_QUOTE_PUNCTUATION = new CharCategory("INITIAL_QUOTE_PUNCTUATION", 28, 29, "Pi");
        CharCategory.FINAL_QUOTE_PUNCTUATION = new CharCategory("FINAL_QUOTE_PUNCTUATION", 29, 30, "Pf");
        CharCategory[] v0 = CharCategory.$values();
        CharCategory.$VALUES = v0;
        CharCategory.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        CharCategory.Companion = new Companion(null);
    }

    private CharCategory(String arg1, int arg2, int arg3, String arg4) {
        super(arg1, arg2);
        this.value = arg3;
        this.code = arg4;
    }

    public final boolean contains(char arg1) {
        if(Character.getType(arg1) == this.value) {
            return 1;
        }

        return 0;
    }

    public final String getCode() {
        return this.code;
    }

    public static EnumEntries getEntries() {
        return CharCategory.$ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static CharCategory valueOf(String arg1) {
        return Enum.valueOf(CharCategory.class, arg1);
    }

    public static CharCategory[] values() {
        return CharCategory.$VALUES.clone();
    }
}

