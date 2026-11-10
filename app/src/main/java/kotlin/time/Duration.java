package kotlin.time;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\bA\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\f\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ\u0011\u0010\u0010\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u000FJ\u0011\u0010\u0016\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u0017\u0010\u0005J\u0019\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u0003H\u0082\u0080\u0004¢\u0006\u0004\b\u001F\u0010 J\u0019\u0010!\u001A\u00020\u00002\u0006\u0010\u0019\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\"\u0010\u001BJ\u0019\u0010#\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010#\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\'H\u0086\u0082\u0004¢\u0006\u0004\b%\u0010(J\u0019\u0010)\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b*\u0010&J\u0019\u0010)\u001A\u00020\u00002\u0006\u0010$\u001A\u00020\'H\u0086\u0082\u0004¢\u0006\u0004\b*\u0010(J\u0019\u0010)\u001A\u00020\'2\u0006\u0010\u0019\u001A\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0013H\u0080\u0080\u0004¢\u0006\u0004\b/\u00100J\u0011\u00101\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0004\b2\u0010\u000FJ\u0011\u00103\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0004\b4\u0010\u000FJ\u0011\u00105\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0004\b6\u0010\u000FJ\u0011\u00107\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0004\b8\u0010\u000FJ\u0019\u0010;\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\b<\u0010=J\u009E\u0001\u0010>\u001A\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001Aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0089\u0001\u0010>\u001A\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001A\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJt\u0010>\u001A\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001AG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ_\u0010>\u001A\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001A2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0019\u0010^\u001A\u00020\'2\u0006\u0010.\u001A\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b_\u0010`J\u0019\u0010a\u001A\u00020\u00032\u0006\u0010.\u001A\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\bb\u00100J\u0019\u0010c\u001A\u00020\t2\u0006\u0010.\u001A\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\bd\u0010eJ\u0011\u0010t\u001A\u00020uH\u0096\u0080\u0004¢\u0006\u0004\bv\u0010wJC\u0010x\u001A\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001A\u00020\t2\u0006\u0010}\u001A\u00020\t2\u0006\u0010~\u001A\u00020\t2\u0006\u0010.\u001A\u00020u2\u0006\u0010\u007F\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J%\u0010t\u001A\u00020u2\u0006\u0010.\u001A\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001A\u00020\tH\u0086\u0080\u0004¢\u0006\u0005\bv\u0010\u0083\u0001J\u0013\u0010\u0084\u0001\u001A\u00020uH\u0086\u0080\u0004¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0016\u0010\u0086\u0001\u001A\u00020\r2\t\u0010\u0019\u001A\u0005\u0018\u00010\u0087\u0001HÖ\u0083\u0004J\u000B\u0010\u0088\u0001\u001A\u00020\tHÖ\u0081\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0006\u001A\u00020\u00038BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001A\u00020\t8Â\u0002X\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\u0012\u001A\u00020\u00138BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0015\u00109\u001A\u00020\u00008FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b:\u0010\u0005R\u001B\u0010Q\u001A\u00020\t8@X\u0081\u0084\b¢\u0006\f\u0012\u0004\bR\u0010S\u001A\u0004\bT\u0010\u000BR\u001B\u0010U\u001A\u00020\t8@X\u0081\u0084\b¢\u0006\f\u0012\u0004\bV\u0010S\u001A\u0004\bW\u0010\u000BR\u001B\u0010X\u001A\u00020\t8@X\u0081\u0084\b¢\u0006\f\u0012\u0004\bY\u0010S\u001A\u0004\bZ\u0010\u000BR\u001B\u0010[\u001A\u00020\t8@X\u0081\u0084\b¢\u0006\f\u0012\u0004\b\\\u0010S\u001A\u0004\b]\u0010\u000BR\u0015\u0010f\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bg\u0010\u0005R\u0015\u0010h\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bi\u0010\u0005R\u0015\u0010j\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bk\u0010\u0005R\u0015\u0010l\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bm\u0010\u0005R\u0015\u0010n\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bo\u0010\u0005R\u0015\u0010p\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bq\u0010\u0005R\u0015\u0010r\u001A\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008A\u0001"}, d2={"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) @JvmInline public final class Duration implements Comparable {
    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001A\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001BH\u0087\u0080\u0004J\u0019\u00108\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u000209H\u0086\u0080\u0004¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001A\u00020\u00052\u0006\u0010\u0019\u001A\u000209H\u0086\u0080\u0004¢\u0006\u0004\b=\u0010;J\u0019\u0010>\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001A\u000209H\u0086\u0080\u0004¢\u0006\u0002\b?J\u0019\u0010@\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001A\u000209H\u0086\u0080\u0004¢\u0006\u0002\bAR\u001D\u0010\n\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\u0010\n\u0002\u0010\u000E\u0012\u0004\b\u000B\u0010\u0003\u001A\u0004\b\f\u0010\rR\u0017\u0010\u000F\u001A\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\u0012\u0010\rR\u000F\u0010\u0013\u001A\u00020\u0007X\u0080Ô\b¢\u0006\u0002\n\u0000R\u001D\u0010\u0014\u001A\u00020\u0005X\u0080\u0084\b¢\u0006\u0010\n\u0002\u0010\u000E\u0012\u0004\b\u0015\u0010\u0003\u001A\u0004\b\u0016\u0010\rR \u0010\u001D\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R \u0010\u001D\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001F\u0010#\u001A\u0004\b!\u0010\tR \u0010\u001D\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u001F\u0010$\u001A\u0004\b!\u0010%R \u0010&\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\'\u0010 \u001A\u0004\b(\u0010\"R \u0010&\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\'\u0010#\u001A\u0004\b(\u0010\tR \u0010&\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\'\u0010$\u001A\u0004\b(\u0010%R \u0010)\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b*\u0010 \u001A\u0004\b+\u0010\"R \u0010)\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b*\u0010#\u001A\u0004\b+\u0010\tR \u0010)\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b*\u0010$\u001A\u0004\b+\u0010%R \u0010,\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b-\u0010 \u001A\u0004\b.\u0010\"R \u0010,\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b-\u0010#\u001A\u0004\b.\u0010\tR \u0010,\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b-\u0010$\u001A\u0004\b.\u0010%R \u0010/\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b0\u0010 \u001A\u0004\b1\u0010\"R \u0010/\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b0\u0010#\u001A\u0004\b1\u0010\tR \u0010/\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b0\u0010$\u001A\u0004\b1\u0010%R \u00102\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b3\u0010 \u001A\u0004\b4\u0010\"R \u00102\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b3\u0010#\u001A\u0004\b4\u0010\tR \u00102\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b3\u0010$\u001A\u0004\b4\u0010%R \u00105\u001A\u00020\u0005*\u00020\u001E8Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b6\u0010 \u001A\u0004\b7\u0010\"R \u00105\u001A\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b6\u0010#\u001A\u0004\b7\u0010\tR \u00105\u001A\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b6\u0010$\u001A\u0004\b7\u0010%¨\u0006B"}, d2={"Lkotlin/time/Duration$Companion;", "", "<init>", "()V", "fromRawValue", "Lkotlin/time/Duration;", "rawValue", "", "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "ZERO", "getZERO-UwyO8pc$annotations", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID_RAW_VALUE", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "getINVALID-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "(J)V", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final double convert(double arg1, DurationUnit arg3, DurationUnit arg4) {
            Intrinsics.checkNotNullParameter(arg3, "sourceUnit");
            Intrinsics.checkNotNullParameter(arg4, "targetUnit");
            return DurationUnitKt.convertDurationUnit(arg1, arg3, arg4);
        }

        public final long fromRawValue-UwyO8pc$kotlin_stdlib(long arg7) {
            long v0;
            long v6 = Duration.constructor-impl(arg7);
            if(DurationJvmKt.getDurationAssertionsEnabled()) {
                if(Duration.isInNanos-impl(v6)) {
                    v0 = Duration.getValue-impl(v6);
                    if(-4611686018426999999L <= v0 && v0 < 0x3FFFFFFFFFFA14C0L) {
                        return v6;
                    }

                    throw new AssertionError(Duration.getValue-impl(v6) + " ns is out of nanoseconds range");
                }
                else {
                    v0 = Duration.getValue-impl(v6);
                    long v2 = -4611686018427387903L;
                    long v4 = 0x3FFFFFFFFFFFFFFFL;
                    if(Long.compare(v2, v0) >= 0 || v0 >= v4) {
                        v0 = Duration.getValue-impl(v6);
                        if(v0 != v4) {
                            if(v0 == v2) {
                            }
                            else {
                                throw new AssertionError(Duration.getValue-impl(v6) + " ms is out of milliseconds range");
                            }
                        }
                    }
                    else {
                    }

                    v0 = Duration.getValue-impl(v6);
                    if(-4611686018426L > v0) {
                        return v6;
                    }

                    if(v0 >= 4611686018427L) {
                        return v6;
                    }

                    throw new AssertionError(Duration.getValue-impl(v6) + " ms is denormalized");
                }
            }

            return v6;
        }

        private final long getDays-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.DAYS);
        }

        private final long getDays-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.DAYS);
        }

        private final long getDays-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.DAYS);
        }

        public static void getDays-UwyO8pc$annotations(double arg0) {
        }

        public static void getDays-UwyO8pc$annotations(int arg0) {
        }

        public static void getDays-UwyO8pc$annotations(long arg0) {
        }

        private final long getHours-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.HOURS);
        }

        private final long getHours-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.HOURS);
        }

        private final long getHours-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.HOURS);
        }

        public static void getHours-UwyO8pc$annotations(double arg0) {
        }

        public static void getHours-UwyO8pc$annotations(int arg0) {
        }

        public static void getHours-UwyO8pc$annotations(long arg0) {
        }

        public final long getINFINITE-UwyO8pc() {
            return Duration.INFINITE;
        }

        public final long getINVALID-UwyO8pc$kotlin_stdlib() {
            return Duration.INVALID;
        }

        public static void getINVALID-UwyO8pc$kotlin_stdlib$annotations() {
        }

        private final long getMicroseconds-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MICROSECONDS);
        }

        private final long getMicroseconds-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MICROSECONDS);
        }

        private final long getMicroseconds-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MICROSECONDS);
        }

        public static void getMicroseconds-UwyO8pc$annotations(double arg0) {
        }

        public static void getMicroseconds-UwyO8pc$annotations(int arg0) {
        }

        public static void getMicroseconds-UwyO8pc$annotations(long arg0) {
        }

        private final long getMilliseconds-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MILLISECONDS);
        }

        private final long getMilliseconds-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MILLISECONDS);
        }

        private final long getMilliseconds-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MILLISECONDS);
        }

        public static void getMilliseconds-UwyO8pc$annotations(double arg0) {
        }

        public static void getMilliseconds-UwyO8pc$annotations(int arg0) {
        }

        public static void getMilliseconds-UwyO8pc$annotations(long arg0) {
        }

        private final long getMinutes-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MINUTES);
        }

        private final long getMinutes-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MINUTES);
        }

        private final long getMinutes-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.MINUTES);
        }

        public static void getMinutes-UwyO8pc$annotations(double arg0) {
        }

        public static void getMinutes-UwyO8pc$annotations(int arg0) {
        }

        public static void getMinutes-UwyO8pc$annotations(long arg0) {
        }

        public final long getNEG_INFINITE-UwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        private final long getNanoseconds-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.NANOSECONDS);
        }

        private final long getNanoseconds-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.NANOSECONDS);
        }

        private final long getNanoseconds-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.NANOSECONDS);
        }

        public static void getNanoseconds-UwyO8pc$annotations(double arg0) {
        }

        public static void getNanoseconds-UwyO8pc$annotations(int arg0) {
        }

        public static void getNanoseconds-UwyO8pc$annotations(long arg0) {
        }

        private final long getSeconds-UwyO8pc(double arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.SECONDS);
        }

        private final long getSeconds-UwyO8pc(int arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.SECONDS);
        }

        private final long getSeconds-UwyO8pc(long arg1) {
            return DurationKt.toDuration(arg1, DurationUnit.SECONDS);
        }

        public static void getSeconds-UwyO8pc$annotations(double arg0) {
        }

        public static void getSeconds-UwyO8pc$annotations(int arg0) {
        }

        public static void getSeconds-UwyO8pc$annotations(long arg0) {
        }

        public final long getZERO-UwyO8pc() {
            return Duration.ZERO;
        }

        public static void getZERO-UwyO8pc$annotations() {
        }

        public final long parse-UwyO8pc(String arg5) {
            Intrinsics.checkNotNullParameter(arg5, "value");
            int v4 = 4;
            Object v0 = null;
            try {
                long v0_1 = DurationKt.parseDuration$default(arg5, false, false, v4, v0);
                if(!Duration.equals-impl0(v0_1, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
                    return v0_1;
                }

                throw new IllegalStateException("invariant failed".toString());
            }
            catch(IllegalArgumentException v4_1) {
                throw new IllegalArgumentException("Invalid duration string format: \'" + arg5 + "\'.", ((Throwable)v4_1));
            }
        }

        public final long parseIsoString-UwyO8pc(String arg5) {
            Intrinsics.checkNotNullParameter(arg5, "value");
            int v4 = 4;
            Object v0 = null;
            try {
                long v0_1 = DurationKt.parseDuration$default(arg5, true, false, v4, v0);
                if(!Duration.equals-impl0(v0_1, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
                    return v0_1;
                }

                throw new IllegalStateException("invariant failed".toString());
            }
            catch(IllegalArgumentException v4_1) {
                throw new IllegalArgumentException("Invalid ISO duration string format: \'" + arg5 + "\'.", ((Throwable)v4_1));
            }
        }

        public final Duration parseIsoStringOrNull-FghU774(String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "value");
            long v2 = DurationKt.access$parseDuration(arg3, true, false);
            if(Duration.equals-impl0(v2, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
                return null;
            }

            return Duration.box-impl(v2);
        }

        public final Duration parseOrNull-FghU774(String arg3) {
            Intrinsics.checkNotNullParameter(arg3, "value");
            long v2 = DurationKt.access$parseDuration(arg3, false, false);
            if(Duration.equals-impl0(v2, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
                return null;
            }

            return Duration.box-impl(v2);
        }
    }

    public static final Companion Companion = null;
    private static final long INFINITE = 0;
    private static final long INVALID = 0;
    public static final long INVALID_RAW_VALUE = 0x7FFFFFFFFFFFC0DEL;
    private static final long NEG_INFINITE;
    private static final long ZERO;
    private final long rawValue;

    static {
        Duration.Companion = new Companion(null);
        Duration.ZERO = Duration.constructor-impl(0);
        Duration.INFINITE = DurationKt.access$durationOfMillis(0x3FFFFFFFFFFFFFFFL);
        Duration.NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);
        Duration.INVALID = Duration.constructor-impl(0x7FFFFFFFFFFFC0DEL);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Don\'t call this constructor directly.") private Duration(long arg1) {
        super();
        this.rawValue = arg1;
    }

    public static final long access$getINFINITE$cp() {
        return Duration.INFINITE;
    }

    public static final long access$getINVALID$cp() {
        return Duration.INVALID;
    }

    public static final long access$getNEG_INFINITE$cp() {
        return Duration.NEG_INFINITE;
    }

    public static final long access$getValue-impl(long arg0) {
        return Duration.getValue-impl(arg0);
    }

    public static final long access$getZERO$cp() {
        return Duration.ZERO;
    }

    public static final boolean access$isInNanos-impl(long arg0) {
        return Duration.isInNanos-impl(arg0);
    }

    private static final long addValuesMixedRanges-UwyO8pc(long arg2, long arg4, long arg6) {
        arg2 = DurationKt.access$nanosToMillis(arg6);
        arg4 = DurationKt.access$addMillisWithoutOverflow(arg4, arg2);
        if(-4611686018426L <= arg4 && arg4 < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(arg4) + (arg6 - DurationKt.access$millisToNanos(arg2)));
        }

        return DurationKt.access$durationOfMillis(arg4);
    }

    private static final void appendFractional-impl(long arg1, StringBuilder arg3, int arg4, int arg5, int arg6, String arg7, boolean arg8) {
        arg3.append(arg4);
        if(arg5 != 0) {
            arg3.append('.');
            char v2 = '0';
            String v1 = StringsKt.padStart(String.valueOf(arg5), arg6, v2);
            arg5 = -1;
            arg4 = ((CharSequence)v1).length() + arg5;
            if(arg4 >= 0) {
                while(true) {
                    arg6 = arg4 - 1;
                    if(((CharSequence)v1).charAt(arg4) != v2) {
                        break;
                    }
                    else if(arg6 < 0) {
                    }
                    else {
                        arg4 = arg6;
                        continue;
                    }

                    goto label_20;
                }

                arg5 = arg4;
            }

        label_20:
            int v2_1 = arg5 + 1;
            String v4 = "append(...)";
            int v0 = 3;
            if(!arg8 && v2_1 < v0) {
                Intrinsics.checkNotNullExpressionValue(arg3.append(((CharSequence)v1), 0, v2_1), v4);
                goto label_34;
            }

            Intrinsics.checkNotNullExpressionValue(arg3.append(((CharSequence)v1), 0, (arg5 + v0) / v0 * v0), v4);
        }

    label_34:
        arg3.append(arg7);
    }

    public static final Duration box-impl(long arg1) {
        return new Duration(arg1);
    }

    public int compareTo(Object arg3) {
        return this.compareTo-LRDsOJo(((Duration)arg3).unbox-impl());
    }

    public static int compareTo-LRDsOJo(long arg4, long arg6) {
        long v0 = arg4 ^ arg6;
        if(v0 >= 0) {
            if(((((int)v0)) & 1) == 0) {
            }
            else {
                int v0_1 = ((((int)arg4)) & 1) - ((((int)arg6)) & 1);
                if(Duration.isNegative-impl(arg4)) {
                    return -v0_1;
                }
                else {
                    return v0_1;
                }
            }
        }

        return Intrinsics.compare(arg4, arg6);
    }

    public int compareTo-LRDsOJo(long arg3) {
        return Duration.compareTo-LRDsOJo(this.rawValue, arg3);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Don\'t call this constructor directly.") public static long constructor-impl(long arg0) {
        return arg0;
    }

    public static final double div-LRDsOJo(long arg2, long arg4) {
        Comparable v0 = ComparisonsKt.maxOf(Duration.getStorageUnit-impl(arg2), Duration.getStorageUnit-impl(arg4));
        return Duration.toDouble-impl(arg2, ((DurationUnit)v0)) / Duration.toDouble-impl(arg4, ((DurationUnit)v0));
    }

    public static final long div-UwyO8pc(long arg3, double arg5) {
        int v0 = MathKt.roundToInt(arg5);
        if((((double)v0)) == arg5 && v0 != 0) {
            return Duration.div-UwyO8pc(arg3, v0);
        }

        DurationUnit v0_1 = Duration.getStorageUnit-impl(arg3);
        return DurationKt.toDuration(Duration.toDouble-impl(arg3, v0_1) / arg5, v0_1);
    }

    public static final long div-UwyO8pc(long arg6, int arg8) {
        if(arg8 == 0) {
            if(Duration.isPositive-impl(arg6)) {
                return Duration.INFINITE;
            }

            if(Duration.isNegative-impl(arg6)) {
                return Duration.NEG_INFINITE;
            }

            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }

        if(Duration.isInNanos-impl(arg6)) {
            return DurationKt.access$durationOfNanos(Duration.getValue-impl(arg6) / (((long)arg8)));
        }

        if(Duration.isInfinite-impl(arg6)) {
            return Duration.times-UwyO8pc(arg6, MathKt.getSign(arg8));
        }

        long v2 = ((long)arg8);
        long v0 = Duration.getValue-impl(arg6) / v2;
        if(-4611686018426L <= v0 && v0 < 4611686018427L) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(v0) + DurationKt.access$millisToNanos(Duration.getValue-impl(arg6) - v0 * v2) / v2);
        }

        return DurationKt.access$durationOfMillis(v0);
    }

    public boolean equals(Object arg3) {
        return Duration.equals-impl(this.rawValue, arg3);
    }

    public static boolean equals-impl(long arg4, Object arg6) {
        if(!(arg6 instanceof Duration)) {
            return 0;
        }

        if(arg4 != ((Duration)arg6).unbox-impl()) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(long arg0, long arg2) {
        if(arg0 == arg2) {
            return 1;
        }

        return 0;
    }

    public static final long getAbsoluteValue-UwyO8pc(long arg1) {
        if(Duration.isNegative-impl(arg1)) {
            arg1 = Duration.unaryMinus-UwyO8pc(arg1);
        }

        return arg1;
    }

    public static void getHoursComponent$annotations() {
    }

    public static final int getHoursComponent-impl(long arg2) {
        if(Duration.isInfinite-impl(arg2)) {
            return 0;
        }

        return ((int)(Duration.getInWholeHours-impl(arg2) % 24));
    }

    public static final long getInWholeDays-impl(long arg1) {
        return Duration.toLong-impl(arg1, DurationUnit.DAYS);
    }

    public static final long getInWholeHours-impl(long arg1) {
        return Duration.toLong-impl(arg1, DurationUnit.HOURS);
    }

    public static final long getInWholeMicroseconds-impl(long arg1) {
        return Duration.toLong-impl(arg1, DurationUnit.MICROSECONDS);
    }

    public static final long getInWholeMilliseconds-impl(long arg1) {
        if((Duration.isInMillis-impl(arg1)) && (Duration.isFinite-impl(arg1))) {
            return Duration.getValue-impl(arg1);
        }

        return Duration.toLong-impl(arg1, DurationUnit.MILLISECONDS);
    }

    public static final long getInWholeMinutes-impl(long arg1) {
        return Duration.toLong-impl(arg1, DurationUnit.MINUTES);
    }

    public static final long getInWholeNanoseconds-impl(long arg2) {
        long v0 = Duration.getValue-impl(arg2);
        if(Duration.isInNanos-impl(arg2)) {
            return v0;
        }

        if(v0 > 0x8637BD05AF6L) {
            return 0x7FFFFFFFFFFFFFFFL;
        }

        if(v0 < -9223372036854L) {
            return -9223372036854775808L;
        }

        return DurationKt.access$millisToNanos(v0);
    }

    public static final long getInWholeSeconds-impl(long arg1) {
        return Duration.toLong-impl(arg1, DurationUnit.SECONDS);
    }

    public static void getMinutesComponent$annotations() {
    }

    public static final int getMinutesComponent-impl(long arg2) {
        if(Duration.isInfinite-impl(arg2)) {
            return 0;
        }

        return ((int)(Duration.getInWholeMinutes-impl(arg2) % 60));
    }

    public static void getNanosecondsComponent$annotations() {
    }

    public static final int getNanosecondsComponent-impl(long arg2) {
        if(Duration.isInfinite-impl(arg2)) {
            return 0;
        }

        arg2 = Duration.isInMillis-impl(arg2) ? DurationKt.access$millisToNanos(Duration.getValue-impl(arg2) % 1000) : Duration.getValue-impl(arg2) % 1000000000;
        return ((int)arg2);
    }

    public static void getSecondsComponent$annotations() {
    }

    public static final int getSecondsComponent-impl(long arg2) {
        if(Duration.isInfinite-impl(arg2)) {
            return 0;
        }

        return ((int)(Duration.getInWholeSeconds-impl(arg2) % 60));
    }

    private static final DurationUnit getStorageUnit-impl(long arg0) {
        if(Duration.isInNanos-impl(arg0)) {
            return DurationUnit.NANOSECONDS;
        }

        return DurationUnit.MILLISECONDS;
    }

    private static final int getUnitDiscriminator-impl(long arg0) {
        return (((int)arg0)) & 1;
    }

    private static final long getValue-impl(long arg1) {
        return arg1 >> 1;
    }

    public int hashCode() {
        return Duration.hashCode-impl(this.rawValue);
    }

    public static int hashCode-impl(long arg0) {
        return Long.hashCode(arg0);
    }

    public static final boolean isFinite-impl(long arg0) {
        return Duration.isInfinite-impl(arg0) ^ 1;
    }

    private static final boolean isInMillis-impl(long arg0) {
        if(((((int)arg0)) & 1) == 1) {
            return 1;
        }

        return 0;
    }

    private static final boolean isInNanos-impl(long arg0) {
        if(((((int)arg0)) & 1) == 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isInfinite-impl(long arg2) {
        if(arg2 != Duration.INFINITE) {
            if(arg2 == Duration.NEG_INFINITE) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final boolean isNegative-impl(long arg2) {
        if(arg2 < 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean isPositive-impl(long arg2) {
        if(arg2 > 0) {
            return 1;
        }

        return 0;
    }

    public static final long minus-LRDsOJo(long arg0, long arg2) {
        return Duration.plus-LRDsOJo(arg0, Duration.unaryMinus-UwyO8pc(arg2));
    }

    public static final long plus-LRDsOJo(long arg7, long arg9) {
        if(((((int)arg7)) & 1) == ((((int)arg9)) & 1)) {
            if(Duration.isInNanos-impl(arg7)) {
                return DurationKt.access$durationOfNanosNormalized(Duration.getValue-impl(arg7) + Duration.getValue-impl(arg9));
            }

            arg7 = DurationKt.access$addMillisWithoutOverflow(Duration.getValue-impl(arg7), Duration.getValue-impl(arg9));
            if(arg7 != 0x7FFFFFFFFFFFC0DEL) {
                if(arg7 != 0x3FFFFFFFFFFFFFFFL) {
                    if(arg7 == -4611686018427387903L) {
                    }
                    else {
                        return DurationKt.access$durationOfMillisNormalized(arg7);
                    }
                }

                return DurationKt.access$durationOfMillis(arg7);
            }

            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }

        if(Duration.isInMillis-impl(arg7)) {
            return Duration.addValuesMixedRanges-UwyO8pc(arg7, Duration.getValue-impl(arg7), Duration.getValue-impl(arg9));
        }

        return Duration.addValuesMixedRanges-UwyO8pc(arg7, Duration.getValue-impl(arg9), Duration.getValue-impl(arg7));
    }

    public static final long times-UwyO8pc(long arg12, int arg14) {
        if(Duration.isInfinite-impl(arg12)) {
            if(arg14 != 0) {
                if(arg14 > 0) {
                    return arg12;
                }

                return Duration.unaryMinus-UwyO8pc(arg12);
            }

            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }

        if(arg14 == 0) {
            return Duration.ZERO;
        }

        long v0 = Duration.getValue-impl(arg12);
        long v2 = ((long)arg14);
        long v4 = v0 * v2;
        long v6 = 0x3FFFFFFFFFFFFFFFL;
        long v8 = -4611686018427387903L;
        if(Duration.isInNanos-impl(arg12)) {
            if(-2147483647 <= v0 && v0 < 0x80000000L) {
                return DurationKt.access$durationOfNanos(v4);
            }

            if(v4 / v2 == v0) {
                return DurationKt.access$durationOfNanosNormalized(v4);
            }

            arg12 = DurationKt.access$nanosToMillis(v0);
            long v10 = arg12 * v2;
            v4 = DurationKt.access$nanosToMillis((v0 - DurationKt.access$millisToNanos(arg12)) * v2) + v10;
            if(v10 / v2 == arg12 && (v4 ^ v10) >= 0) {
                return DurationKt.access$durationOfMillis(RangesKt.coerceIn(v4, new LongRange(v8, v6)));
            }

            if(MathKt.getSign(v0) * MathKt.getSign(arg14) > 0) {
                return Duration.INFINITE;
            }

            return Duration.NEG_INFINITE;
        }

        if(v4 / v2 == v0) {
            return DurationKt.access$durationOfMillis(RangesKt.coerceIn(v4, new LongRange(v8, v6)));
        }

        if(MathKt.getSign(v0) * MathKt.getSign(arg14) > 0) {
            return Duration.INFINITE;
        }

        return Duration.NEG_INFINITE;
    }

    public static final long times-UwyO8pc(long arg3, double arg5) {
        int v0 = MathKt.roundToInt(arg5);
        if((((double)v0)) == arg5) {
            return Duration.times-UwyO8pc(arg3, v0);
        }

        DurationUnit v0_1 = Duration.getStorageUnit-impl(arg3);
        return DurationKt.toDuration(Duration.toDouble-impl(arg3, v0_1) * arg5, v0_1);
    }

    public static final Object toComponents-impl(long arg2, Function2 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        return arg4.invoke(Long.valueOf(Duration.getInWholeSeconds-impl(arg2)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg2)));
    }

    public static final Object toComponents-impl(long arg2, Function3 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "action");
        return arg4.invoke(Long.valueOf(Duration.getInWholeMinutes-impl(arg2)), Integer.valueOf(Duration.getSecondsComponent-impl(arg2)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg2)));
    }

    public static final Object toComponents-impl(long arg3, Function4 arg5) {
        Intrinsics.checkNotNullParameter(arg5, "action");
        return arg5.invoke(Long.valueOf(Duration.getInWholeHours-impl(arg3)), Integer.valueOf(Duration.getMinutesComponent-impl(arg3)), Integer.valueOf(Duration.getSecondsComponent-impl(arg3)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg3)));
    }

    public static final Object toComponents-impl(long arg8, Function5 arg10) {
        Intrinsics.checkNotNullParameter(arg10, "action");
        return arg10.invoke(Long.valueOf(Duration.getInWholeDays-impl(arg8)), Integer.valueOf(Duration.getHoursComponent-impl(arg8)), Integer.valueOf(Duration.getMinutesComponent-impl(arg8)), Integer.valueOf(Duration.getSecondsComponent-impl(arg8)), Integer.valueOf(Duration.getNanosecondsComponent-impl(arg8)));
    }

    public static final double toDouble-impl(long arg2, DurationUnit arg4) {
        Intrinsics.checkNotNullParameter(arg4, "unit");
        if(arg2 == Duration.INFINITE) {
            return Infinity;
        }

        if(arg2 == Duration.NEG_INFINITE) {
            return -Infinity;
        }

        return DurationUnitKt.convertDurationUnit(((double)Duration.getValue-impl(arg2)), Duration.getStorageUnit-impl(arg2), arg4);
    }

    public static final int toInt-impl(long arg7, DurationUnit arg9) {
        Intrinsics.checkNotNullParameter(arg9, "unit");
        return ((int)RangesKt.coerceIn(Duration.toLong-impl(arg7, arg9), -2147483648, 0x7FFFFFFF));
    }

    public static final String toIsoString-impl(long arg10) {
        StringBuilder v2 = new StringBuilder();
        if(Duration.isNegative-impl(arg10)) {
            v2.append('-');
        }

        v2.append("PT");
        long v0 = Duration.getAbsoluteValue-UwyO8pc(arg10);
        long v3 = Duration.getInWholeHours-impl(v0);
        int v5 = Duration.getMinutesComponent-impl(v0);
        long v6 = v3;
        int v3_1 = Duration.getSecondsComponent-impl(v0);
        int v4 = Duration.getNanosecondsComponent-impl(v0);
        v0 = Duration.isInfinite-impl(arg10) ? 0x9184E729FFFL : v6;
        int v7 = 1;
        int v6_1 = Long.compare(v0, 0) != 0 ? 1 : 0;
        int v9 = v3_1 != 0 || v4 != 0 ? 1 : 0;
        if(v5 == 0 && (v9 == 0 || v6_1 == 0)) {
            v7 = 0;
        }

        if(v6_1 != 0) {
            v2.append(v0).append('H');
        }

        if(v7 != 0) {
            v2.append(v5).append('M');
        }

        if(v9 != 0 || v6_1 == 0 && v7 == 0) {
            Duration.appendFractional-impl(arg10, v2, v3_1, v4, 9, "S", true);
        }

        return v2.toString();
    }

    public static final long toLong-impl(long arg2, DurationUnit arg4) {
        Intrinsics.checkNotNullParameter(arg4, "unit");
        if(arg2 == Duration.INFINITE) {
            return 0x7FFFFFFFFFFFFFFFL;
        }

        if(arg2 == Duration.NEG_INFINITE) {
            return -9223372036854775808L;
        }

        return DurationUnitKt.convertDurationUnit(Duration.getValue-impl(arg2), Duration.getStorageUnit-impl(arg2), arg4);
    }

    public String toString() {
        return Duration.toString-impl(this.rawValue);
    }

    public static String toString-impl(long arg14) {
        int v11;
        long v0 = 0;
        if(arg14 == v0) {
            return "0s";
        }

        if(arg14 == Duration.INFINITE) {
            return "Infinity";
        }

        if(arg14 == Duration.NEG_INFINITE) {
            return "-Infinity";
        }

        boolean v2 = Duration.isNegative-impl(arg14);
        StringBuilder v5 = new StringBuilder();
        if(v2) {
            v5.append('-');
        }

        long v3 = Duration.getAbsoluteValue-UwyO8pc(arg14);
        long v6 = Duration.getInWholeDays-impl(v3);
        int v8 = Duration.getHoursComponent-impl(v3);
        int v9 = Duration.getMinutesComponent-impl(v3);
        long v10 = v6;
        int v6_1 = Duration.getSecondsComponent-impl(v3);
        int v7 = Duration.getNanosecondsComponent-impl(v3);
        int v0_1 = Long.compare(v10, v0);
        int v1 = 0;
        v0_1 = v0_1 != 0 ? 1 : 0;
        int v3_1 = v8 != 0 ? 1 : 0;
        int v4 = v9 != 0 ? 1 : 0;
        int v13 = v6_1 != 0 || v7 != 0 ? 1 : 0;
        if(v0_1 != 0) {
            v5.append(v10).append('d');
            v1 = 1;
        }

        char v10_1 = ' ';
        if(v3_1 != 0) {
        label_56:
            v11 = v1 + 1;
            if(v1 > 0) {
                v5.append(v10_1);
            }

            v5.append(v8).append('h');
            v1 = v11;
        }
        else if(v0_1 != 0) {
            if(v4 != 0) {
                goto label_56;
            }
            else if(v13 != 0) {
                goto label_56;
            }
        }

        if(v4 != 0) {
        label_67:
            v8 = v1 + 1;
            if(v1 > 0) {
                v5.append(v10_1);
            }

            v5.append(v9).append('m');
            v1 = v8;
        }
        else if(v13 != 0) {
            if(v3_1 != 0) {
                goto label_67;
            }
            else if(v0_1 != 0) {
                goto label_67;
            }
        }

        if(v13 != 0) {
            v11 = v1 + 1;
            if(v1 > 0) {
                v5.append(v10_1);
            }

            if(v6_1 != 0 || v0_1 != 0 || v3_1 != 0 || v4 != 0) {
                Duration.appendFractional-impl(arg14, v5, v6_1, v7, 9, "s", false);
            }
            else {
                v0_1 = 1000000;
                if(v7 >= v0_1) {
                    Duration.appendFractional-impl(arg14, v5, v7 / v0_1, v7 % v0_1, 6, "ms", false);
                }
                else {
                    v3 = arg14;
                    int v14 = 1000;
                    if(v7 >= v14) {
                        Duration.appendFractional-impl(v3, v5, v7 / 1000, v7 % v14, 3, "us", false);
                    }
                    else {
                        v5.append(v7).append("ns");
                    }
                }
            }

            v1 = v11;
        }

        if((v2) && v1 > 1) {
            v5.insert(1, '(').append(')');
        }

        return v5.toString();
    }

    public static final String toString-impl(long arg2, DurationUnit arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg4, "unit");
        if(arg5 >= 0) {
            double v2 = Duration.toDouble-impl(arg2, arg4);
            if(Double.isInfinite(v2)) {
                return String.valueOf(v2);
            }

            return DurationJvmKt.formatToExactDecimals(v2, RangesKt.coerceAtMost(arg5, 12)) + DurationUnitKt.shortName(arg4);
        }

        throw new IllegalArgumentException("decimals must be not negative, but was " + arg5.toString());
    }

    public static String toString-impl$default(long arg0, DurationUnit arg2, int arg3, int arg4, Object arg5) {
        return Duration.toString-impl(arg0, arg2, 0);
    }

    public static final long truncateTo-UwyO8pc$kotlin_stdlib(long arg5, DurationUnit arg7) {
        Intrinsics.checkNotNullParameter(arg7, "unit");
        DurationUnit v0 = Duration.getStorageUnit-impl(arg5);
        if(arg7.compareTo(v0) > 0) {
            if(Duration.isInfinite-impl(arg5)) {
            }
            else {
                arg5 = DurationKt.toDuration(Duration.getValue-impl(arg5) - Duration.getValue-impl(arg5) % DurationUnitKt.convertDurationUnit(1, arg7, v0), v0);
            }
        }

        return arg5;
    }

    public static final long unaryMinus-UwyO8pc(long arg2) {
        return DurationKt.access$durationOf(-Duration.getValue-impl(arg2), (((int)arg2)) & 1);
    }

    public final long unbox-impl() {
        return this.rawValue;
    }
}

