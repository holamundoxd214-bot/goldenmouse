package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b-\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000F\u0010\u0004\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0006\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0007\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\b\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\t\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\n\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000B\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\f\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\r\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000E\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u000F\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R\u0017\u0010\u0012\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0003R\u000F\u0010\u0014\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0015\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0016\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0017\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0018\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0019\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001A\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001B\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001C\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001D\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001E\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\u001F\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010 \u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010!\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\"\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010#\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010$\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010%\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010&\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010\'\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010(\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010)\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010*\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010+\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010,\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000F\u0010-\u001A\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u0017\u0010.\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\u0003R\u0017\u00100\u001A\u00020\u00058\u0006X\u0087Ô\b¢\u0006\b\n\u0000\u0012\u0004\b1\u0010\u0003¨\u00062"}, d2={"Lkotlin/text/Typography;", "", "<init>", "()V", "quote", "", "dollar", "amp", "less", "greater", "nbsp", "times", "cent", "pound", "section", "copyright", "leftGuillemet", "getLeftGuillemet$annotations", "rightGuillemet", "getRightGuillemet$annotations", "registered", "degree", "plusMinus", "paragraph", "middleDot", "half", "ndash", "mdash", "leftSingleQuote", "rightSingleQuote", "lowSingleQuote", "leftDoubleQuote", "rightDoubleQuote", "lowDoubleQuote", "dagger", "doubleDagger", "bullet", "ellipsis", "prime", "doublePrime", "euro", "tm", "almostEqual", "notEqual", "lessOrEqual", "greaterOrEqual", "leftGuillemete", "getLeftGuillemete$annotations", "rightGuillemete", "getRightGuillemete$annotations", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Typography {
    public static final Typography INSTANCE = null;
    public static final char almostEqual = '≈';
    public static final char amp = '&';
    public static final char bullet = '•';
    public static final char cent = '¢';
    public static final char copyright = '©';
    public static final char dagger = '†';
    public static final char degree = '°';
    public static final char dollar = '$';
    public static final char doubleDagger = '‡';
    public static final char doublePrime = '″';
    public static final char ellipsis = '…';
    public static final char euro = '€';
    public static final char greater = '>';
    public static final char greaterOrEqual = '≥';
    public static final char half = '½';
    public static final char leftDoubleQuote = '“';
    public static final char leftGuillemet = '«';
    public static final char leftGuillemete = '«';
    public static final char leftSingleQuote = '‘';
    public static final char less = '<';
    public static final char lessOrEqual = '≤';
    public static final char lowDoubleQuote = '„';
    public static final char lowSingleQuote = '‚';
    public static final char mdash = '—';
    public static final char middleDot = '·';
    public static final char nbsp = ' ';
    public static final char ndash = '–';
    public static final char notEqual = '≠';
    public static final char paragraph = '¶';
    public static final char plusMinus = '±';
    public static final char pound = '£';
    public static final char prime = '′';
    public static final char quote = '\"';
    public static final char registered = '®';
    public static final char rightDoubleQuote = '”';
    public static final char rightGuillemet = '»';
    public static final char rightGuillemete = '»';
    public static final char rightSingleQuote = '’';
    public static final char section = '§';
    public static final char times = '×';
    public static final char tm = '™';

    static {
        Typography.INSTANCE = new Typography();
    }

    private Typography() {
        super();
    }

    public static void getLeftGuillemet$annotations() {
    }

    @Deprecated(message="This constant has a typo in the name. Use leftGuillemet instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.6") public static void getLeftGuillemete$annotations() {
    }

    public static void getRightGuillemet$annotations() {
    }

    @Deprecated(message="This constant has a typo in the name. Use rightGuillemet instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.6") public static void getRightGuillemete$annotations() {
    }
}

