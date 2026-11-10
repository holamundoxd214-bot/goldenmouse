package androidx.compose.ui.util;

import androidx.collection.MutableScatterSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0010\u000F\n\u0002\b\u0002\n\u0002\u0010\u001F\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u001C\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0003\u001A8\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\u0006\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A>\u0010\u0007\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001A\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\n\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A8\u0010\r\u001A\u00020\u000B\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A?\u0010\u000E\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000F\u001A8\u0010\u0010\u001A\u00020\t\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AD\u0010\u0012\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AO\u0010\u0015\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000F\u001A]\u0010\u0017\u001A\u0002H\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013\"\u0010\b\u0002\u0010\u0018*\n\u0012\u0006\b\u0000\u0012\u0002H\u00130\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001A\u001A\u0002H\u00182\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u001B\u001A?\u0010\u001C\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000F\u001A>\u0010\u001D\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A`\u0010\u001E\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u00052\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\u0010\n\u0006\b\u0001\u0012\u0002\u0010\u0001\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001A`\u0010\u001F\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010 \u001A\u0002H\u00132\'\u0010!\u001A#\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010%\u001AY\u0010&\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\'\u0010\u0014\u001A#\u0012\u0013\u0012\u00110\t¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\'\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A[\u0010(\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032)\u0010\u0014\u001A%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\'\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AO\u0010)\u001A\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010*\u001AU\u0010+\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010,\u001A\u0002H\u00132\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-\u001AJ\u0010.\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0014\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A\\\u0010/\u001A\u0002H0\"\u0004\b\u0000\u00100\"\b\b\u0001\u0010\u0002*\u0002H0*\b\u0012\u0004\u0012\u0002H\u00020\u00032\'\u0010!\u001A#\u0012\u0013\u0012\u0011H0¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H00\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00101\u001A|\u00102\u001A\b\u0012\u0004\u0012\u0002H30\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u00103*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u00104\u001A\b\u0012\u0004\u0012\u0002H\u00130\u000326\u0010\u0014\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(5\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(6\u0012\u0004\u0012\u0002H30\bH\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001AF\u00107\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A`\u00108\u001A\u000209\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010:\u001A\u00020;2\b\b\u0002\u0010<\u001A\u00020;2\b\b\u0002\u0010=\u001A\u00020;2\b\b\u0002\u0010>\u001A\u00020\t2\b\b\u0002\u0010?\u001A\u00020;2\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005\u001AD\u0010@\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010A*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002HA0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001AO\u0010B\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0016*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00130\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000F\u001AJ\u0010C\u001A\b\u0012\u0004\u0012\u0002H\u00130\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0014\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130D0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001A\"\u0010E\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020F*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\u001A=\u0010G\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000B0\u0005H\u0086\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u000F\u001A}\u0010H\u001A\u0002HI\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010I*\u00060Jj\u0002`K*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010L\u001A\u0002HI2\b\b\u0002\u0010:\u001A\u00020;2\b\b\u0002\u0010<\u001A\u00020;2\b\b\u0002\u0010=\u001A\u00020;2\b\b\u0002\u0010>\u001A\u00020\t2\b\b\u0002\u0010?\u001A\u00020;2\u0016\b\u0002\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010M\u001A9\u0010N\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060Jj\u0002`K2\u0006\u0010O\u001A\u0002H\u00022\u0014\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020;\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010P\u001A\u0010\u0010Q\u001A\u00020R2\u0006\u0010S\u001A\u000209H\u0001\u001A\u0010\u0010T\u001A\u00020\u00012\u0006\u0010S\u001A\u000209H\u0001¨\u0006U"}, d2={"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "fastForEachReversed", "fastForEachIndexed", "Lkotlin/Function2;", "", "fastAll", "", "predicate", "fastAny", "fastFirstOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastSumBy", "selector", "fastMap", "R", "transform", "fastMaxBy", "", "fastMapTo", "C", "", "destination", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastLastOrNull", "fastFilter", "fastFilteredMap", "fastFold", "initial", "operation", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastMapIndexed", "index", "fastMapIndexedNotNull", "fastMaxOfOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "fastMaxOfOrDefault", "defaultValue", "(Ljava/util/List;Ljava/lang/Comparable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "fastZipWithNext", "fastReduce", "S", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastZip", "V", "other", "a", "b", "fastMapNotNull", "fastJoinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "fastDistinctBy", "K", "fastMinByOrNull", "fastFlatMap", "", "fastFilterNotNull", "", "fastFirst", "fastJoinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "appendElement", "element", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "throwNoSuchElementException", "", "message", "throwUnsupportedOperationException", "ui-util"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ListUtilsKt {
    private static final void appendElement(Appendable arg0, Object arg1, Function1 arg2) {
        if(arg2 != null) {
            arg0.append(arg2.invoke(arg1));
            return;
        }

        boolean v2 = arg1 == null ? true : arg1 instanceof CharSequence;
        if(v2) {
            arg0.append(((CharSequence)arg1));
            return;
        }

        if((arg1 instanceof Character)) {
            arg0.append(((Character)arg1).charValue());
            return;
        }

        arg0.append(arg1.toString());
    }

    public static final boolean fastAll(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!arg5.invoke(arg4.get(v2)).booleanValue()) {
                return 0;
            }
        }

        return 1;
    }

    public static final boolean fastAny(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(arg5.invoke(arg4.get(v2)).booleanValue()) {
                return 1;
            }
        }

        return 0;
    }

    public static final List fastDistinctBy(List arg6, Function1 arg7) {
        MutableScatterSet v0 = new MutableScatterSet(arg6.size());
        ArrayList v1 = new ArrayList(arg6.size());
        int v2 = arg6.size();
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            Object v4 = arg6.get(v3);
            if(v0.add(arg7.invoke(v4))) {
                v1.add(v4);
            }
        }

        return ((List)v1);
    }

    public static final List fastFilter(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg5.get(v2);
            if(arg6.invoke(v3).booleanValue()) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final List fastFilterNotNull(List arg5) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg5.get(v2);
            if(v3 != null) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final List fastFilteredMap(List arg5, Function1 arg6, Function1 arg7) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg5.get(v2);
            if(arg6.invoke(v3).booleanValue()) {
                v0.add(arg7.invoke(v3));
            }
        }

        return ((List)v0);
    }

    public static final Object fastFirst(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg4.get(v1);
            if(arg5.invoke(v2).booleanValue()) {
                return v2;
            }
        }

        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public static final Object fastFirstOrNull(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg4.get(v1);
            if(arg5.invoke(v2).booleanValue()) {
                return v2;
            }
        }

        return null;
    }

    public static final List fastFlatMap(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            CollectionsKt.addAll(v0, arg6.invoke(arg5.get(v2)));
        }

        return ((List)v0);
    }

    public static final Object fastFold(List arg3, Object arg4, Function2 arg5) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4 = arg5.invoke(arg4, arg3.get(v1));
        }

        return arg4;
    }

    public static final void fastForEach(List arg3, Function1 arg4) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.invoke(arg3.get(v1));
        }
    }

    public static final void fastForEachIndexed(List arg4, Function2 arg5) {
        int v0 = arg4.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg5.invoke(Integer.valueOf(v1), arg4.get(v1));
        }
    }

    public static final void fastForEachReversed(List arg2, Function1 arg3) {
        int v0 = arg2.size() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                arg3.invoke(arg2.get(v0));
                if(v1 < 0) {
                    break;
                }

                v0 = v1;
            }
        }
    }

    private static final Appendable fastJoinTo(List arg4, Appendable arg5, CharSequence arg6, CharSequence arg7, CharSequence arg8, int arg9, CharSequence arg10, Function1 arg11) {
        arg5.append(arg7);
        int v7 = arg4.size();
        int v0 = 0;
        int v1 = 0;
        while(v0 < v7) {
            Object v2 = arg4.get(v0);
            ++v1;
            if(v1 > 1) {
                arg5.append(arg6);
            }

            if(arg9 >= 0 && v1 > arg9) {
                break;
            }

            ListUtilsKt.appendElement(arg5, v2, arg11);
            ++v0;
        }

        if(arg9 >= 0 && v1 > arg9) {
            arg5.append(arg10);
        }

        arg5.append(arg8);
        return arg5;
    }

    static Appendable fastJoinTo$default(List arg6, Appendable arg7, CharSequence arg8, CharSequence arg9, CharSequence arg10, int arg11, CharSequence arg12, Function1 arg13, int arg14, Object arg15) {
        CharSequence v4_1;
        CharSequence v2_1;
        CharSequence v1_1;
        String v0;
        if((arg14 & 2) != 0) {
            v0 = ", ";
        }
        else {
            CharSequence v0_1 = arg8;
        }

        String v2 = "";
        if((arg14 & 4) != 0) {
            String v1 = v2;
        }
        else {
            v1_1 = arg9;
        }

        if((arg14 & 8) != 0) {
        }
        else {
            v2_1 = arg10;
        }

        int v3 = (arg14 & 16) != 0 ? -1 : arg11;
        if((arg14 & 0x20) != 0) {
            String v4 = "...";
        }
        else {
            v4_1 = arg12;
        }

        Function1 v15 = (arg14 & 0x40) != 0 ? null : arg13;
        return ListUtilsKt.fastJoinTo(arg6, arg7, v0, ((String)v1_1), ((String)v2_1), v3, ((String)v4_1), v15);
    }

    public static final String fastJoinToString(List arg9, CharSequence arg10, CharSequence arg11, CharSequence arg12, int arg13, CharSequence arg14, Function1 arg15) {
        return ListUtilsKt.fastJoinTo(arg9, new StringBuilder(), arg10, arg11, arg12, arg13, arg14, arg15).toString();
    }

    public static String fastJoinToString$default(List arg1, CharSequence arg2, CharSequence arg3, CharSequence arg4, int arg5, CharSequence arg6, Function1 arg7, int arg8, Object arg9) {
        String v6;
        String v4;
        String v3;
        String v2;
        if((arg8 & 1) != 0) {
            v2 = ", ";
        }

        String v0 = "";
        if((arg8 & 2) != 0) {
            v3 = v0;
        }

        if((arg8 & 4) != 0) {
            v4 = v0;
        }

        if((arg8 & 8) != 0) {
            arg5 = -1;
        }

        if((arg8 & 16) != 0) {
            v6 = "...";
        }

        if((arg8 & 0x20) != 0) {
            arg7 = null;
        }

        return ListUtilsKt.fastJoinToString(arg1, ((CharSequence)v2), ((CharSequence)v3), ((CharSequence)v4), arg5, ((CharSequence)v6), arg7);
    }

    public static final Object fastLastOrNull(List arg3, Function1 arg4) {
        Object v0_1;
        int v0 = arg3.size() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                v0_1 = arg3.get(v0);
                if(arg4.invoke(v0_1).booleanValue()) {
                    return v0_1;
                }
                else if(v1 < 0) {
                }
                else {
                    v0 = v1;
                    continue;
                }

                return null;
            }

            return v0_1;
        }

        return null;
    }

    public static final List fastMap(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg6.invoke(arg5.get(v2)));
        }

        return ((List)v0);
    }

    public static final List fastMapIndexed(List arg6, Function2 arg7) {
        ArrayList v0 = new ArrayList(arg6.size());
        int v1 = arg6.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(arg7.invoke(Integer.valueOf(v2), arg6.get(v2)));
        }

        return ((List)v0);
    }

    public static final List fastMapIndexedNotNull(List arg5, Function2 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg6.invoke(Integer.valueOf(v2), arg5.get(v2));
            if(v3 != null) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final List fastMapNotNull(List arg5, Function1 arg6) {
        ArrayList v0 = new ArrayList(arg5.size());
        int v1 = arg5.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            Object v3 = arg6.invoke(arg5.get(v2));
            if(v3 != null) {
                v0.add(v3);
            }
        }

        return ((List)v0);
    }

    public static final Collection fastMapTo(List arg3, Collection arg4, Function1 arg5) {
        int v0 = arg3.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.add(arg5.invoke(arg3.get(v1)));
        }

        return arg4;
    }

    public static final Object fastMaxBy(List arg7, Function1 arg8) {
        if(arg7.isEmpty()) {
            return null;
        }

        Object v0 = arg7.get(0);
        Object v1 = arg8.invoke(v0);
        int v2 = CollectionsKt.getLastIndex(arg7);
        int v3 = 1;
        if(1 <= v2) {
            while(true) {
                Object v4 = arg7.get(v3);
                Object v5 = arg8.invoke(v4);
                if(((Comparable)v1).compareTo(v5) < 0) {
                    v0 = v4;
                    v1 = v5;
                }

                if(v3 == v2) {
                    return v0;
                }

                ++v3;
            }
        }

        return v0;
    }

    public static final Comparable fastMaxOfOrDefault(List arg4, Comparable arg5, Function1 arg6) {
        if(arg4.isEmpty()) {
            return arg5;
        }

        Object v5 = arg6.invoke(arg4.get(0));
        int v0 = CollectionsKt.getLastIndex(arg4);
        int v1 = 1;
        if(1 <= v0) {
            while(true) {
                Object v2 = arg6.invoke(arg4.get(v1));
                if(((Comparable)v2).compareTo(v5) > 0) {
                    v5 = v2;
                }

                if(v1 == v0) {
                    break;
                }

                ++v1;
            }
        }

        return ((Comparable)v5);
    }

    public static final Comparable fastMaxOfOrNull(List arg5, Function1 arg6) {
        if(arg5.isEmpty()) {
            return null;
        }

        Object v0 = arg6.invoke(arg5.get(0));
        int v1 = CollectionsKt.getLastIndex(arg5);
        int v2 = 1;
        if(1 <= v1) {
            while(true) {
                Object v3 = arg6.invoke(arg5.get(v2));
                if(((Comparable)v3).compareTo(v0) > 0) {
                    v0 = v3;
                }

                if(v2 == v1) {
                    break;
                }

                ++v2;
            }
        }

        return ((Comparable)v0);
    }

    public static final Object fastMinByOrNull(List arg7, Function1 arg8) {
        if(arg7.isEmpty()) {
            return null;
        }

        Object v0 = arg7.get(0);
        Object v1 = arg8.invoke(v0);
        int v2 = CollectionsKt.getLastIndex(arg7);
        int v3 = 1;
        if(1 <= v2) {
            while(true) {
                Object v4 = arg7.get(v3);
                Object v5 = arg8.invoke(v4);
                if(((Comparable)v1).compareTo(v5) > 0) {
                    v0 = v4;
                    v1 = v5;
                }

                if(v3 == v2) {
                    return v0;
                }

                ++v3;
            }
        }

        return v0;
    }

    public static final Object fastReduce(List arg4, Function2 arg5) {
        if(arg4.isEmpty()) {
            ListUtilsKt.throwUnsupportedOperationException("Empty collection can\'t be reduced.");
        }

        Object v0 = CollectionsKt.first(arg4);
        int v1 = CollectionsKt.getLastIndex(arg4);
        int v2 = 1;
        if(1 <= v1) {
            while(true) {
                v0 = arg5.invoke(v0, arg4.get(v2));
                if(v2 != v1) {
                    ++v2;
                    continue;
                }

                return v0;
            }
        }

        return v0;
    }

    public static final int fastSumBy(List arg4, Function1 arg5) {
        int v0 = arg4.size();
        int v1 = 0;
        int v2 = 0;
        while(v1 < v0) {
            v2 += arg5.invoke(arg4.get(v1)).intValue();
            ++v1;
        }

        return v2;
    }

    public static final List fastZip(List arg6, List arg7, Function2 arg8) {
        int v0 = Math.min(arg6.size(), arg7.size());
        ArrayList v1 = new ArrayList(v0);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1.add(arg8.invoke(arg6.get(v2), arg7.get(v2)));
        }

        return ((List)v1);
    }

    public static final List fastZipWithNext(List arg5, Function2 arg6) {
        if(arg5.size() <= 1) {
            return CollectionsKt.emptyList();
        }

        ArrayList v0 = new ArrayList();
        int v1 = 0;
        Object v2 = arg5.get(0);
        int v3 = CollectionsKt.getLastIndex(arg5);
        while(v1 < v3) {
            ++v1;
            Object v4 = arg5.get(v1);
            ((List)v0).add(arg6.invoke(v2, v4));
            v2 = v4;
        }

        return ((List)v0);
    }

    public static final Void throwNoSuchElementException(String arg1) {
        throw new NoSuchElementException(arg1);
    }

    public static final void throwUnsupportedOperationException(String arg1) {
        throw new UnsupportedOperationException(arg1);
    }
}

