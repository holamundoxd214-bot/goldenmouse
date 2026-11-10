package kotlin.streams.jdk8;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001A \u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004\u001A\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0087\u0080\u0004\u001A\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0087\u0080\u0004\u001A\u0014\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\b0\u0001*\u00020\tH\u0087\u0080\u0004\u001A \u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0080\u0004\u001A \u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0080\u0004\u001A\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0087\u0080\u0004\u001A\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0087\u0080\u0004\u001A\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\b0\f*\u00020\tH\u0087\u0080\u0004¨\u0006\r"}, d2={"asSequence", "Lkotlin/sequences/Sequence;", "T", "Ljava/util/stream/Stream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "", "Ljava/util/stream/DoubleStream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k=2, mv={2, 3, 0}, pn="kotlin.streams", xi=0x30) public final class StreamsKt {
    public static final Sequence asSequence(DoubleStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$4(arg1);
    }

    public static final Sequence asSequence(IntStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$2(arg1);
    }

    public static final Sequence asSequence(LongStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$3(arg1);
    }

    public static final Sequence asSequence(Stream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StreamsKt$asSequence$$inlined$Sequence$1(arg1);
    }

    public static final Stream asStream(Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Stream v2 = StreamSupport.stream(new StreamsKt$$ExternalSyntheticLambda0(arg2), 16, false);
        Intrinsics.checkNotNullExpressionValue(v2, "stream(...)");
        return v2;
    }

    static final Spliterator asStream$lambda$0(Sequence arg1) {
        return Spliterators.spliteratorUnknownSize(arg1.iterator(), 16);
    }

    public static final List toList(DoubleStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        double[] v1 = arg1.toArray();
        Intrinsics.checkNotNullExpressionValue(v1, "toArray(...)");
        return ArraysKt.asList(v1);
    }

    public static final List toList(IntStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        int[] v1 = arg1.toArray();
        Intrinsics.checkNotNullExpressionValue(v1, "toArray(...)");
        return ArraysKt.asList(v1);
    }

    public static final List toList(LongStream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        long[] v1 = arg1.toArray();
        Intrinsics.checkNotNullExpressionValue(v1, "toArray(...)");
        return ArraysKt.asList(v1);
    }

    public static final List toList(Stream arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v1 = arg1.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(v1, "collect(...)");
        return ((List)v1);
    }
}

