package kotlin.text;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001A\b\u0086\u0081\u0002\u0018\u0000 \u001C2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001CB\u0011\bB\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001A\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001Aj\u0002\b\u001B¨\u0006\u001D"}, d2={"Lkotlin/text/CharDirectionality;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public enum CharDirectionality {
    @Metadata(d1={"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0006H\u0086\u0080\u0004R\'\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058BX\u0082\u0084\n¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\b\u0010\t¨\u0006\u000E"}, d2={"Lkotlin/text/CharDirectionality$Companion;", "", "<init>", "()V", "directionalityMap", "", "", "Lkotlin/text/CharDirectionality;", "getDirectionalityMap", "()Ljava/util/Map;", "directionalityMap$delegate", "Lkotlin/Lazy;", "valueOf", "directionality", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        private final Map getDirectionalityMap() {
            return CharDirectionality.directionalityMap$delegate.getValue();
        }

        public final CharDirectionality valueOf(int arg3) {
            Object v2 = this.getDirectionalityMap().get(Integer.valueOf(arg3));
            if(v2 != null) {
                return ((CharDirectionality)v2);
            }

            throw new IllegalArgumentException("Directionality #" + arg3 + " is not defined.");
        }
    }

    public static final enum CharDirectionality ARABIC_NUMBER;
    public static final enum CharDirectionality BOUNDARY_NEUTRAL;
    public static final enum CharDirectionality COMMON_NUMBER_SEPARATOR;
    public static final Companion Companion;
    public static final enum CharDirectionality EUROPEAN_NUMBER;
    public static final enum CharDirectionality EUROPEAN_NUMBER_SEPARATOR;
    public static final enum CharDirectionality EUROPEAN_NUMBER_TERMINATOR;
    public static final enum CharDirectionality LEFT_TO_RIGHT;
    public static final enum CharDirectionality LEFT_TO_RIGHT_EMBEDDING;
    public static final enum CharDirectionality LEFT_TO_RIGHT_OVERRIDE;
    public static final enum CharDirectionality NONSPACING_MARK;
    public static final enum CharDirectionality OTHER_NEUTRALS;
    public static final enum CharDirectionality PARAGRAPH_SEPARATOR;
    public static final enum CharDirectionality POP_DIRECTIONAL_FORMAT;
    public static final enum CharDirectionality RIGHT_TO_LEFT;
    public static final enum CharDirectionality RIGHT_TO_LEFT_ARABIC;
    public static final enum CharDirectionality RIGHT_TO_LEFT_EMBEDDING;
    public static final enum CharDirectionality RIGHT_TO_LEFT_OVERRIDE;
    public static final enum CharDirectionality SEGMENT_SEPARATOR;
    public static final enum CharDirectionality UNDEFINED;
    public static final enum CharDirectionality WHITESPACE;
    private static final Lazy directionalityMap$delegate;
    private final int value;

    private static final CharDirectionality[] $values() {
        return new CharDirectionality[]{CharDirectionality.UNDEFINED, CharDirectionality.LEFT_TO_RIGHT, CharDirectionality.RIGHT_TO_LEFT, CharDirectionality.RIGHT_TO_LEFT_ARABIC, CharDirectionality.EUROPEAN_NUMBER, CharDirectionality.EUROPEAN_NUMBER_SEPARATOR, CharDirectionality.EUROPEAN_NUMBER_TERMINATOR, CharDirectionality.ARABIC_NUMBER, CharDirectionality.COMMON_NUMBER_SEPARATOR, CharDirectionality.NONSPACING_MARK, CharDirectionality.BOUNDARY_NEUTRAL, CharDirectionality.PARAGRAPH_SEPARATOR, CharDirectionality.SEGMENT_SEPARATOR, CharDirectionality.WHITESPACE, CharDirectionality.OTHER_NEUTRALS, CharDirectionality.LEFT_TO_RIGHT_EMBEDDING, CharDirectionality.LEFT_TO_RIGHT_OVERRIDE, CharDirectionality.RIGHT_TO_LEFT_EMBEDDING, CharDirectionality.RIGHT_TO_LEFT_OVERRIDE, CharDirectionality.POP_DIRECTIONAL_FORMAT};
    }

    static {
        CharDirectionality.UNDEFINED = new CharDirectionality("UNDEFINED", 0, -1);
        CharDirectionality.LEFT_TO_RIGHT = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
        CharDirectionality.RIGHT_TO_LEFT = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
        CharDirectionality.RIGHT_TO_LEFT_ARABIC = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
        CharDirectionality.EUROPEAN_NUMBER = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
        CharDirectionality.EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
        CharDirectionality.EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
        CharDirectionality.ARABIC_NUMBER = new CharDirectionality("ARABIC_NUMBER", 7, 6);
        CharDirectionality.COMMON_NUMBER_SEPARATOR = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
        CharDirectionality.NONSPACING_MARK = new CharDirectionality("NONSPACING_MARK", 9, 8);
        CharDirectionality.BOUNDARY_NEUTRAL = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
        CharDirectionality.PARAGRAPH_SEPARATOR = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
        CharDirectionality.SEGMENT_SEPARATOR = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
        CharDirectionality.WHITESPACE = new CharDirectionality("WHITESPACE", 13, 12);
        CharDirectionality.OTHER_NEUTRALS = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
        CharDirectionality.LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
        CharDirectionality.LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
        CharDirectionality.RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
        CharDirectionality.RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
        CharDirectionality.POP_DIRECTIONAL_FORMAT = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
        CharDirectionality[] v0 = CharDirectionality.$values();
        CharDirectionality.$VALUES = v0;
        CharDirectionality.$ENTRIES = EnumEntriesKt.enumEntries(((Enum[])v0));
        CharDirectionality.Companion = new Companion(null);
        CharDirectionality.directionalityMap$delegate = LazyKt.lazy(new CharDirectionality$$ExternalSyntheticLambda0());
    }

    private CharDirectionality(String arg1, int arg2, int arg3) {
        super(arg1, arg2);
        this.value = arg3;
    }

    public static final Lazy access$getDirectionalityMap$delegate$cp() {
        return CharDirectionality.directionalityMap$delegate;
    }

    static final Map directionalityMap_delegate$lambda$0() {
        EnumEntries v0 = CharDirectionality.getEntries();
        LinkedHashMap v2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(((Iterable)v0), 10)), 16));
        Iterator v0_1 = ((Iterable)v0).iterator();
        while(v0_1.hasNext()) {
            Object v1 = v0_1.next();
            ((Map)v2).put(Integer.valueOf(v1.value), v1);
        }

        return ((Map)v2);
    }

    public static EnumEntries getEntries() {
        return CharDirectionality.$ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static CharDirectionality valueOf(String arg1) {
        return Enum.valueOf(CharDirectionality.class, arg1);
    }

    public static CharDirectionality[] values() {
        return CharDirectionality.$VALUES.clone();
    }
}

