package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000B\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000B\u001A%\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A%\u0010\u0000\u001A\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A%\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A%\u0010\u0007\u001A\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A%\u0010\b\u001A\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A%\u0010\b\u001A\u00020\u0006*\u00020\u00062\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0086\u0088\u0004ø\u0001\u0000\u001A\u001A\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u001A\u0010\u0000\u001A\u00020\u0006*\u00020\u00062\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u001A\u0010\u0007\u001A\u00020\u0001*\u00020\u00012\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u001A\u0010\u0007\u001A\u00020\u0006*\u00020\u00062\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u001A\u0010\b\u001A\u00020\u0001*\u00020\u00012\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u001A\u0010\b\u001A\u00020\u0006*\u00020\u00062\n\u0010\t\u001A\u00020\n\"\u00020\u0004H\u0086\u0080\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004\u001A\u000E\u0010\u0007\u001A\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\u0007\u001A\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004\u001A\u000E\u0010\b\u001A\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\b\u001A\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004\u001A \u0010\u000B\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u0004H\u0086\u0080\u0004\u001A \u0010\u000B\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u0004H\u0086\u0080\u0004\u001A \u0010\u000F\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u0004H\u0086\u0080\u0004\u001A \u0010\u000F\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u0004H\u0086\u0080\u0004\u001A!\u0010\u0010\u001A\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004\u0082\u0002\u000E\n\f\b\u0000\u0012\u0002\u0018\u0001\u001A\u0004\b\u0003\u0010\u0000\u001A\u000E\u0010\u0011\u001A\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u0010\u0013\u001A\u00020\u0005*\u00020\u0001H\u0086\u0080\u0004\u001A\u000E\u0010\u0014\u001A\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004\u001A!\u0010\u0015\u001A\u00020\u0005*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004\u0082\u0002\u000E\n\f\b\u0000\u0012\u0002\u0018\u0001\u001A\u0004\b\u0003\u0010\u0000\u001A\u000E\u0010\u0016\u001A\u00020\u0017*\u00020\u0001H\u0086\u0082\u0004\u001A\u0010\u0010\u0018\u001A\u00020\u0006*\u0004\u0018\u00010\u0006H\u0087\u0088\u0004\u001AE\u0010\u0019\u001A\u0002H\u001A\"\f\b\u0000\u0010\u001B*\u00020\u0001*\u0002H\u001A\"\u0004\b\u0001\u0010\u001A*\u0002H\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u001DH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001E\u001AE\u0010\u001F\u001A\u0002H\u001A\"\f\b\u0000\u0010\u001B*\u00020\u0001*\u0002H\u001A\"\u0004\b\u0001\u0010\u001A*\u0002H\u001B2\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u0002H\u001A0\u001DH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u001E\u001A\u0016\u0010\'\u001A\u00020\u0005*\u00020\u00012\u0006\u0010(\u001A\u00020\rH\u0086\u0080\u0004\u001A\u0016\u0010)\u001A\u00020\u0006*\u00020\u00062\u0006\u0010*\u001A\u00020!H\u0086\u0080\u0004\u001A\u0016\u0010+\u001A\u00020\u0001*\u00020\u00012\u0006\u0010*\u001A\u00020!H\u0086\u0080\u0004\u001A\u001E\u0010+\u001A\u00020\u0001*\u00020\u00062\u0006\u0010,\u001A\u00020\r2\u0006\u0010-\u001A\u00020\rH\u0087\u0088\u0004\u001A \u0010)\u001A\u00020\u0006*\u00020\u00012\u0006\u0010.\u001A\u00020\r2\b\b\u0002\u0010/\u001A\u00020\rH\u0087\u0088\u0004\u001A\u0016\u0010)\u001A\u00020\u0006*\u00020\u00012\u0006\u0010*\u001A\u00020!H\u0086\u0080\u0004\u001A \u00100\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00100\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00103\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00103\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00104\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00104\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00105\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A \u00105\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A&\u00106\u001A\u00020\u0001*\u00020\u00012\u0006\u0010.\u001A\u00020\r2\u0006\u0010/\u001A\u00020\r2\u0006\u00107\u001A\u00020\u0001H\u0086\u0080\u0004\u001A&\u00106\u001A\u00020\u0006*\u00020\u00062\u0006\u0010.\u001A\u00020\r2\u0006\u0010/\u001A\u00020\r2\u0006\u00107\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001E\u00106\u001A\u00020\u0001*\u00020\u00012\u0006\u0010*\u001A\u00020!2\u0006\u00107\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u001E\u00106\u001A\u00020\u0006*\u00020\u00062\u0006\u0010*\u001A\u00020!2\u0006\u00107\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001E\u00108\u001A\u00020\u0001*\u00020\u00012\u0006\u0010.\u001A\u00020\r2\u0006\u0010/\u001A\u00020\rH\u0086\u0080\u0004\u001A\u001E\u00108\u001A\u00020\u0006*\u00020\u00062\u0006\u0010.\u001A\u00020\r2\u0006\u0010/\u001A\u00020\rH\u0087\u0088\u0004\u001A\u0016\u00108\u001A\u00020\u0001*\u00020\u00012\u0006\u0010*\u001A\u00020!H\u0086\u0080\u0004\u001A\u0016\u00108\u001A\u00020\u0006*\u00020\u00062\u0006\u0010*\u001A\u00020!H\u0087\u0088\u0004\u001A\u0016\u00109\u001A\u00020\u0001*\u00020\u00012\u0006\u0010:\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u00109\u001A\u00020\u0006*\u00020\u00062\u0006\u0010:\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010;\u001A\u00020\u0001*\u00020\u00012\u0006\u0010<\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010;\u001A\u00020\u0006*\u00020\u00062\u0006\u0010<\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u001E\u0010=\u001A\u00020\u0001*\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\u0006\u0010<\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u001E\u0010=\u001A\u00020\u0006*\u00020\u00062\u0006\u0010:\u001A\u00020\u00012\u0006\u0010<\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010=\u001A\u00020\u0001*\u00020\u00012\u0006\u00101\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010=\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u0001H\u0086\u0080\u0004\u001A(\u0010>\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010>\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010?\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010?\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010@\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010@\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010A\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00042\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A(\u0010A\u001A\u00020\u0006*\u00020\u00062\u0006\u00101\u001A\u00020\u00062\u0006\u00107\u001A\u00020\u00062\b\b\u0002\u00102\u001A\u00020\u0006H\u0086\u0080\u0004\u001A\u001E\u0010B\u001A\u00020\u0006*\u00020\u00012\u0006\u0010C\u001A\u00020D2\u0006\u00107\u001A\u00020\u0006H\u0087\u0088\u0004\u001A/\u0010B\u001A\u00020\u0006*\u00020\u00012\u0006\u0010C\u001A\u00020D2\u0014\b\b\u0010E\u001A\u000E\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\u0088\u0004ø\u0001\u0000\u001A\u001E\u0010G\u001A\u00020\u0006*\u00020\u00012\u0006\u0010C\u001A\u00020D2\u0006\u00107\u001A\u00020\u0006H\u0087\u0088\u0004\u001A*\u0010H\u001A\u00020\u0006*\u00020\u00062\u0012\u0010E\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\bI\u001A*\u0010H\u001A\u00020\u0006*\u00020\u00062\u0012\u0010E\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\bJ\u001A\u0016\u0010K\u001A\u00020\u0005*\u00020\u00012\u0006\u0010C\u001A\u00020DH\u0087\u008C\u0004\u001A6\u0010L\u001A\u00020\u0005*\u00020\u00012\u0006\u0010M\u001A\u00020\r2\u0006\u0010N\u001A\u00020\u00012\u0006\u0010O\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010P\u001A\u00020\u0005H\u0080\u0080\u0004\u001A \u0010Q\u001A\u00020\u0005*\u00020\u00012\u0006\u0010R\u001A\u00020\u00042\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010S\u001A\u00020\u0005*\u00020\u00012\u0006\u0010R\u001A\u00020\u00042\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010Q\u001A\u00020\u0005*\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A(\u0010Q\u001A\u00020\u0005*\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\u0006\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010S\u001A\u00020\u0005*\u00020\u00012\u0006\u0010<\u001A\u00020\u00012\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010T\u001A\u00020\u0006*\u00020\u00012\u0006\u0010N\u001A\u00020\u00012\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010U\u001A\u00020\u0006*\u00020\u00012\u0006\u0010N\u001A\u00020\u00012\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010V\u001A\u00020\r*\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010W\u001A\u00020\r*\u00020\u00012\u0006\u0010\t\u001A\u00020\n2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A=\u0010X\u001A\u00020\r*\u00020\u00012\u0006\u0010N\u001A\u00020\u00012\u0006\u0010.\u001A\u00020\r2\u0006\u0010/\u001A\u00020\r2\u0006\u0010P\u001A\u00020\u00052\b\b\u0002\u0010Y\u001A\u00020\u0005H\u0082\u0080\u0004¢\u0006\u0002\bZ\u001AG\u0010[\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00060^2\u0006\u0010.\u001A\u00020\r2\u0006\u0010P\u001A\u00020\u00052\u0006\u0010Y\u001A\u00020\u0005H\u0082\u0080\u0004¢\u0006\u0002\b_\u001A>\u0010[\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A>\u0010`\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\\*\u00020\u00012\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A0\u0010V\u001A\u00020\r*\u00020\u00012\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A0\u0010W\u001A\u00020\r*\u00020\u00012\f\u0010]\u001A\b\u0012\u0004\u0012\u00020\u00060^2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010X\u001A\u00020\r*\u00020\u00012\u0006\u0010R\u001A\u00020\u00042\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010X\u001A\u00020\r*\u00020\u00012\u0006\u0010a\u001A\u00020\u00062\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010b\u001A\u00020\r*\u00020\u00012\u0006\u0010R\u001A\u00020\u00042\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A*\u0010b\u001A\u00020\r*\u00020\u00012\u0006\u0010a\u001A\u00020\u00062\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0080\u0004\u001A \u0010c\u001A\u00020\u0005*\u00020\u00012\u0006\u0010N\u001A\u00020\u00012\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0082\u0004\u001A \u0010c\u001A\u00020\u0005*\u00020\u00012\u0006\u0010R\u001A\u00020\u00042\b\b\u0002\u0010P\u001A\u00020\u0005H\u0086\u0082\u0004\u001A\u0016\u0010c\u001A\u00020\u0005*\u00020\u00012\u0006\u0010C\u001A\u00020DH\u0087\u008A\u0004\u001A?\u0010d\u001A\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u0006\u0010f\u001A\u00020\n2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0002\bh\u001AI\u0010d\u001A\b\u0012\u0004\u0012\u00020!0e*\u00020\u00012\u000E\u0010f\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060i2\b\b\u0002\u0010.\u001A\u00020\r2\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0004\bh\u0010j\u001A\u0012\u0010k\u001A\u00020l2\u0006\u0010g\u001A\u00020\rH\u0080\u0080\u0004\u001AA\u0010m\u001A\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0012\u0010f\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0002\u0010n\u001AA\u0010o\u001A\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0012\u0010f\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00060i\"\u00020\u00062\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0086\u0080\u0004¢\u0006\u0002\u0010q\u001A4\u0010m\u001A\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\n\u0010f\u001A\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0086\u0080\u0004\u001A4\u0010o\u001A\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\n\u0010f\u001A\u00020\n\"\u00020\u00042\b\b\u0002\u0010P\u001A\u00020\u00052\b\b\u0002\u0010g\u001A\u00020\rH\u0086\u0080\u0004\u001A1\u0010o\u001A\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u00101\u001A\u00020\u00062\u0006\u0010P\u001A\u00020\u00052\u0006\u0010g\u001A\u00020\rH\u0082\u0080\u0004¢\u0006\u0002\br\u001A&\u0010o\u001A\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u00012\u0006\u0010C\u001A\u00020D2\b\b\u0002\u0010g\u001A\u00020\rH\u0087\u0088\u0004\u001A&\u0010m\u001A\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u00012\u0006\u0010C\u001A\u00020D2\b\b\u0002\u0010g\u001A\u00020\rH\u0087\u0088\u0004\u001A\u0014\u0010s\u001A\b\u0012\u0004\u0012\u00020\u00060e*\u00020\u0001H\u0086\u0080\u0004\u001A\u0014\u0010t\u001A\b\u0012\u0004\u0012\u00020\u00060p*\u00020\u0001H\u0086\u0080\u0004\u001A\u001A\u0010u\u001A\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001A\u0004\u0018\u00010\u0001H\u0080\u0080\u0004\u001A\u001A\u0010v\u001A\u00020\u0005*\u0004\u0018\u00010\u00012\b\u0010N\u001A\u0004\u0018\u00010\u0001H\u0080\u0080\u0004\u001A\u000E\u0010w\u001A\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004\u001A\u0015\u0010x\u001A\u0004\u0018\u00010\u0005*\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010y\u001A-\u0010z\u001A\u00020\r*\u00020\u00062\u0006\u0010.\u001A\u00020\r2\u0012\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0080\u0088\u0004ø\u0001\u0000\"\u0019\u0010 \u001A\u00020!*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\"\u0010#\"\u0019\u0010$\u001A\u00020\r*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006{"}, d2={"trim", "", "predicate", "Lkotlin/Function1;", "", "", "", "trimStart", "trimEnd", "chars", "", "padStart", "length", "", "padChar", "padEnd", "isNullOrEmpty", "isEmpty", "isNotEmpty", "isBlank", "isNotBlank", "isNullOrBlank", "iterator", "Lkotlin/collections/CharIterator;", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifBlank", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/lang/CharSequence;)I", "hasSurrogatePairAt", "index", "substring", "range", "subSequence", "start", "end", "startIndex", "endIndex", "substringBefore", "delimiter", "missingDelimiterValue", "substringAfter", "substringBeforeLast", "substringAfterLast", "replaceRange", "replacement", "removeRange", "removePrefix", "prefix", "removeSuffix", "suffix", "removeSurrounding", "replaceBefore", "replaceAfter", "replaceAfterLast", "replaceBeforeLast", "replace", "regex", "Lkotlin/text/Regex;", "transform", "Lkotlin/text/MatchResult;", "replaceFirst", "replaceFirstChar", "replaceFirstCharWithChar", "replaceFirstCharWithCharSequence", "matches", "regionMatchesImpl", "thisOffset", "other", "otherOffset", "ignoreCase", "startsWith", "char", "endsWith", "commonPrefixWith", "commonSuffixWith", "indexOfAny", "lastIndexOfAny", "indexOf", "last", "indexOf$StringsKt__StringsKt", "findAnyOf", "Lkotlin/Pair;", "strings", "", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "string", "lastIndexOf", "contains", "rangesDelimitedBy", "Lkotlin/sequences/Sequence;", "delimiters", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "requireNonNegativeLimit", "", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "split", "", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "lineSequence", "lines", "contentEqualsIgnoreCaseImpl", "contentEqualsImpl", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "skipWhile", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static Pair $r8$lambda$4JwvsE_x9Qd4xJfLltMpDIP3RoA(char[] arg0, boolean arg1, CharSequence arg2, int arg3) {
        return StringsKt__StringsKt.rangesDelimitedBy$lambda$0$StringsKt__StringsKt(arg0, arg1, arg2, arg3);
    }

    public static String $r8$lambda$ELi_fx0JGmTRPjaALgYW_moJCr4(CharSequence arg0, IntRange arg1) {
        return StringsKt__StringsKt.splitToSequence$lambda$0$StringsKt__StringsKt(arg0, arg1);
    }

    public static Pair $r8$lambda$gKUnDVwn2f7eC7TWcWbv0SrbwQg(List arg0, boolean arg1, CharSequence arg2, int arg3) {
        return StringsKt__StringsKt.rangesDelimitedBy$lambda$1$StringsKt__StringsKt(arg0, arg1, arg2, arg3);
    }

    public static String $r8$lambda$iTftvDdL_lzGjVlJQTmElLXBbYs(CharSequence arg0, IntRange arg1) {
        return StringsKt__StringsKt.splitToSequence$lambda$1$StringsKt__StringsKt(arg0, arg1);
    }

    public StringsKt__StringsKt() {
        super();
    }

    public static final String commonPrefixWith(CharSequence arg5, CharSequence arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "other");
        int v0 = Math.min(arg5.length(), arg6.length());
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            if(!CharsKt.equals(arg5.charAt(v2), arg6.charAt(v2), arg7)) {
                break;
            }
        }

        int v7 = v2 - 1;
        if((StringsKt.hasSurrogatePairAt(arg5, v7)) || (StringsKt.hasSurrogatePairAt(arg6, v7))) {
            --v2;
        }

        return arg5.subSequence(0, v2).toString();
    }

    public static String commonPrefixWith$default(CharSequence arg0, CharSequence arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.commonPrefixWith(arg0, arg1, false);
    }

    public static final String commonSuffixWith(CharSequence arg6, CharSequence arg7, boolean arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "other");
        int v0 = arg6.length();
        int v1 = arg7.length();
        int v2 = Math.min(v0, v1);
        int v3;
        for(v3 = 0; v3 < v2; ++v3) {
            if(!CharsKt.equals(arg6.charAt(v0 - v3 - 1), arg7.charAt(v1 - v3 - 1), arg8)) {
                break;
            }
        }

        if((StringsKt.hasSurrogatePairAt(arg6, v0 - v3 - 1)) || (StringsKt.hasSurrogatePairAt(arg7, v1 - v3 - 1))) {
            --v3;
        }

        return arg6.subSequence(v0 - v3, v0).toString();
    }

    public static String commonSuffixWith$default(CharSequence arg0, CharSequence arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.commonSuffixWith(arg0, arg1, false);
    }

    public static final boolean contains(CharSequence arg7, char arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        if(StringsKt.indexOf$default(arg7, arg8, 0, arg9, 2, null) >= 0) {
            return 1;
        }

        return 0;
    }

    public static final boolean contains(CharSequence arg11, CharSequence arg12, boolean arg13) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        Intrinsics.checkNotNullParameter(arg12, "other");
        if((arg12 instanceof String)) {
            if(StringsKt.indexOf$default(arg11, arg12, 0, arg13, 2, null) >= 0) {
                return 1;
            }

            return 0;
        }

        if(StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default(arg11, arg12, 0, arg11.length(), arg13, false, 16, null) >= 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean contains(CharSequence arg1, Regex arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        return arg2.containsMatchIn(arg1);
    }

    public static boolean contains$default(CharSequence arg0, char arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.contains(arg0, arg1, false);
    }

    public static boolean contains$default(CharSequence arg0, CharSequence arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.contains(arg0, arg1, false);
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence arg6, CharSequence arg7) {
        if(((arg6 instanceof String)) && ((arg7 instanceof String))) {
            return StringsKt.equals(((String)arg6), ((String)arg7), true);
        }

        if(arg6 == arg7) {
            return 1;
        }

        if(arg6 != null && arg7 != null) {
            if(arg6.length() != arg7.length()) {
            }
            else {
                int v2 = arg6.length();
                int v3 = 0;
                while(true) {
                    if(v3 >= v2) {
                        return 1;
                    }
                    else if(!CharsKt.equals(arg6.charAt(v3), arg7.charAt(v3), true)) {
                        return 0;
                    }
                    else {
                        ++v3;
                        continue;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public static final boolean contentEqualsImpl(CharSequence arg6, CharSequence arg7) {
        if(((arg6 instanceof String)) && ((arg7 instanceof String))) {
            return Intrinsics.areEqual(arg6, arg7);
        }

        if(arg6 == arg7) {
            return 1;
        }

        if(arg6 != null && arg7 != null) {
            if(arg6.length() != arg7.length()) {
            }
            else {
                int v2 = arg6.length();
                int v3 = 0;
                while(true) {
                    if(v3 >= v2) {
                        return 1;
                    }
                    else if(arg6.charAt(v3) != arg7.charAt(v3)) {
                        return 0;
                    }
                    else {
                        ++v3;
                        continue;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public static final boolean endsWith(CharSequence arg1, char arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.length() > 0 && (CharsKt.equals(arg1.charAt(StringsKt.getLastIndex(arg1)), arg2, arg3))) {
            return 1;
        }

        return 0;
    }

    public static final boolean endsWith(CharSequence arg8, CharSequence arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "suffix");
        if(!arg10 && ((arg8 instanceof String)) && ((arg9 instanceof String))) {
            return StringsKt.endsWith$default(((String)arg8), ((String)arg9), false, 2, null);
        }

        return StringsKt.regionMatchesImpl(arg8, arg8.length() - arg9.length(), arg9, 0, arg9.length(), arg10);
    }

    public static boolean endsWith$default(CharSequence arg0, char arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.endsWith(arg0, arg1, false);
    }

    public static boolean endsWith$default(CharSequence arg0, CharSequence arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.endsWith(arg0, arg1, false);
    }

    public static final Pair findAnyOf(CharSequence arg1, Collection arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(arg1, arg2, arg3, arg4, false);
    }

    private static final Pair findAnyOf$StringsKt__StringsKt(CharSequence arg9, Collection arg10, int arg11, boolean arg12, boolean arg13) {
        CharSequence v5_1;
        Object v13_1;
        boolean v7;
        Object v8;
        Iterator v9_1;
        IntProgression v11_1;
        int v9;
        Pair v0 = null;
        if(!arg12 && arg10.size() == 1) {
            Object v2 = CollectionsKt.single(((Iterable)arg10));
            v9 = !arg13 ? StringsKt.indexOf$default(arg9, ((String)v2), arg11, false, 4, null) : StringsKt.lastIndexOf$default(arg9, ((String)v2), arg11, false, 4, null);
            if(v9 < 0) {
                return v0;
            }

            return TuplesKt.to(Integer.valueOf(v9), v2);
        }

        CharSequence v1 = arg9;
        int v3 = arg11;
        if(!arg13) {
            IntRange v11 = new IntRange(RangesKt.coerceAtLeast(v3, 0), v1.length());
        }
        else {
            v11_1 = RangesKt.downTo(RangesKt.coerceAtMost(v3, StringsKt.getLastIndex(v1)), 0);
        }

        if((v1 instanceof String)) {
            v9 = v11_1.getFirst();
            int v13 = v11_1.getLast();
            arg11 = v11_1.getStep();
            if(arg11 <= 0 || v9 > v13) {
                if(arg11 >= 0) {
                }
                else if(v13 <= v9) {
                    goto label_47;
                }

                return v0;
            }

        label_47:
            int v5 = v9;
            while(true) {
                v9_1 = arg10.iterator();
                while(true) {
                    if(v9_1.hasNext()) {
                        v8 = v9_1.next();
                        v7 = arg12;
                        if(StringsKt.regionMatches(v8, 0, v1, v5, v8.length(), v7)) {
                        }
                        else {
                            arg12 = v7;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_65;
                }

                v7 = arg12;
                v8 = v0;
            label_65:
                if(v8 != null) {
                    return TuplesKt.to(Integer.valueOf(v5), v8);
                }

                if(v5 == v13) {
                    return v0;
                }

                v5 += arg11;
                arg12 = v7;
            }
        }
        else {
            v7 = arg12;
            v9 = v11_1.getFirst();
            int v12 = v11_1.getLast();
            arg11 = v11_1.getStep();
            if(arg11 <= 0 || v9 > v12) {
                if(arg11 >= 0) {
                }
                else if(v12 <= v9) {
                    goto label_81;
                }

                return v0;
            }

        label_81:
            int v6 = v9;
            while(true) {
                v9_1 = arg10.iterator();
                while(true) {
                    if(v9_1.hasNext()) {
                        v13_1 = v9_1.next();
                        v5_1 = v1;
                        boolean v8_1 = v7;
                        v7 = v8_1;
                        if(StringsKt.regionMatchesImpl(v13_1, 0, v5_1, v6, v13_1.length(), v8_1)) {
                        }
                        else {
                            v1 = v5_1;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_102;
                }

                v5_1 = v1;
                v13_1 = v0;
            label_102:
                if(v13_1 != null) {
                    return TuplesKt.to(Integer.valueOf(v6), v13_1);
                }

                if(v6 == v12) {
                    return v0;
                }

                v6 += arg11;
                v1 = v5_1;
            }
        }

        return v0;
    }

    public static Pair findAnyOf$default(CharSequence arg1, Collection arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        return StringsKt.findAnyOf(arg1, arg2, 0, false);
    }

    public static final Pair findLastAnyOf(CharSequence arg1, Collection arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "strings");
        return StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(arg1, arg2, arg3, arg4, true);
    }

    public static Pair findLastAnyOf$default(CharSequence arg0, Collection arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = StringsKt.getLastIndex(arg0);
        }

        return StringsKt.findLastAnyOf(arg0, arg1, arg2, false);
    }

    public static final IntRange getIndices(CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new IntRange(0, arg2.length() - 1);
    }

    public static final int getLastIndex(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 >= 0 && arg2 <= arg1.length() - 2 && (Character.isHighSurrogate(arg1.charAt(arg2))) && (Character.isLowSurrogate(arg1.charAt(arg2 + 1)))) {
            return 1;
        }

        return 0;
    }

    private static final Object ifBlank(CharSequence arg1, Function0 arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(StringsKt.isBlank(arg1)) {
            v1 = arg2.invoke();
        }

        return ((CharSequence)v1);
    }

    private static final Object ifEmpty(CharSequence arg1, Function0 arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(arg1.length() == 0) {
            v1 = arg2.invoke();
        }

        return ((CharSequence)v1);
    }

    public static final int indexOf(CharSequence arg2, char arg3, int arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(!arg5) {
            if(!(arg2 instanceof String)) {
            }
            else {
                return ((String)arg2).indexOf(arg3, arg4);
            }
        }

        return StringsKt.indexOfAny(arg2, new char[]{arg3}, arg4, arg5);
    }

    public static final int indexOf(CharSequence arg8, String arg9, int arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "string");
        if(!arg11) {
            if(!(arg8 instanceof String)) {
            }
            else {
                return ((String)arg8).indexOf(arg9, arg10);
            }
        }

        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt$default(arg8, arg9, arg10, arg8.length(), arg11, false, 16, null);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence arg10, CharSequence arg11, int arg12, int arg13, boolean arg14, boolean arg15) {
        boolean v5;
        IntRange v15;
        if(!arg15) {
            v15 = new IntRange(RangesKt.coerceAtLeast(arg12, 0), RangesKt.coerceAtMost(arg13, arg10.length()));
        }
        else {
            IntProgression v15_1 = RangesKt.downTo(RangesKt.coerceAtMost(arg12, StringsKt.getLastIndex(arg10)), RangesKt.coerceAtLeast(arg13, 0));
        }

        if(!(arg10 instanceof String) || !(arg11 instanceof String)) {
            v5 = arg14;
            arg12 = ((IntProgression)v15).getFirst();
            arg13 = ((IntProgression)v15).getLast();
            int v14 = ((IntProgression)v15).getStep();
            if(v14 <= 0 || arg12 > arg13) {
                if(v14 >= 0) {
                }
                else if(arg13 <= arg12) {
                    goto label_44;
                }

                return -1;
            }

        label_44:
            int v7 = arg12;
            while(true) {
                CharSequence v6 = arg10;
                CharSequence v4 = arg11;
                boolean v10 = StringsKt.regionMatchesImpl(v4, 0, v6, v7, arg11.length(), v5);
                v5 = v5;
                if(v10) {
                    return v7;
                }

                if(v7 == arg13) {
                    return -1;
                }

                v7 += v14;
                arg11 = v4;
                arg10 = v6;
            }

            return v7;
        }
        else {
            arg12 = ((IntProgression)v15).getFirst();
            arg13 = ((IntProgression)v15).getLast();
            int v15_2 = ((IntProgression)v15).getStep();
            if(v15_2 <= 0 || arg12 > arg13) {
                if(v15_2 >= 0) {
                }
                else if(arg13 <= arg12) {
                    goto label_23;
                }

                return -1;
            }

        label_23:
            int v3 = arg12;
            while(true) {
                v5 = arg14;
                if(StringsKt.regionMatches(arg11, 0, arg10, v3, arg11.length(), v5)) {
                    return v3;
                }

                if(v3 == arg13) {
                    return -1;
                }

                v3 += v15_2;
                arg14 = v5;
            }

            return v3;
        }

        return -1;
    }

    static int indexOf$StringsKt__StringsKt$default(CharSequence arg6, CharSequence arg7, int arg8, int arg9, boolean arg10, boolean arg11, int arg12, Object arg13) {
        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(arg6, arg7, arg8, arg9, arg10, false);
    }

    public static int indexOf$default(CharSequence arg1, char arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        return StringsKt.indexOf(arg1, arg2, 0, false);
    }

    public static int indexOf$default(CharSequence arg1, String arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        return StringsKt.indexOf(arg1, arg2, 0, false);
    }

    public static final int indexOfAny(CharSequence arg1, Collection arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "strings");
        Pair v1 = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(arg1, arg2, arg3, arg4, false);
        if(v1 != null) {
            return v1.getFirst().intValue();
        }

        return -1;
    }

    public static final int indexOfAny(CharSequence arg6, char[] arg7, int arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "chars");
        if(!arg9 && arg7.length == 1 && ((arg6 instanceof String))) {
            return ((String)arg6).indexOf(ArraysKt.single(arg7), arg8);
        }

        arg8 = RangesKt.coerceAtLeast(arg8, 0);
        int v1 = StringsKt.getLastIndex(arg6);
        if(arg8 <= v1) {
            while(true) {
                char v2 = arg6.charAt(arg8);
                int v3 = arg7.length;
                int v4 = 0;
                while(true) {
                    if(v4 >= v3) {
                        break;
                    }
                    else if(CharsKt.equals(arg7[v4], v2, arg9)) {
                        return arg8;
                    }
                    else {
                        ++v4;
                        continue;
                    }

                    return -1;
                }

                if(arg8 != v1) {
                    ++arg8;
                    continue;
                }

                return -1;
            }
        }

        return -1;
    }

    public static int indexOfAny$default(CharSequence arg1, Collection arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        return StringsKt.indexOfAny(arg1, arg2, 0, false);
    }

    public static int indexOfAny$default(CharSequence arg1, char[] arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        return StringsKt.indexOfAny(arg1, arg2, 0, false);
    }

    public static final boolean isBlank(CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        int v1;
        for(v1 = 0; v1 < arg3.length(); ++v1) {
            if(!CharsKt.isWhitespace(arg3.charAt(v1))) {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isEmpty(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.length() == 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean isNotBlank(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.isBlank(arg1) ^ 1;
    }

    private static final boolean isNotEmpty(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.length() > 0) {
            return 1;
        }

        return 0;
    }

    private static final boolean isNullOrBlank(CharSequence arg0) {
        if(arg0 != null) {
            if(StringsKt.isBlank(arg0)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final boolean isNullOrEmpty(CharSequence arg0) {
        if(arg0 != null) {
            if(arg0.length() == 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static final CharIterator iterator(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StringsKt__StringsKt$iterator$1(arg1);
    }

    public static final int lastIndexOf(CharSequence arg2, char arg3, int arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(!arg5) {
            if(!(arg2 instanceof String)) {
            }
            else {
                return ((String)arg2).lastIndexOf(arg3, arg4);
            }
        }

        return StringsKt.lastIndexOfAny(arg2, new char[]{arg3}, arg4, arg5);
    }

    public static final int lastIndexOf(CharSequence arg6, String arg7, int arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "string");
        if(!arg9) {
            if(!(arg6 instanceof String)) {
            }
            else {
                return ((String)arg6).lastIndexOf(arg7, arg8);
            }
        }

        return StringsKt__StringsKt.indexOf$StringsKt__StringsKt(arg6, arg7, arg8, 0, arg9, true);
    }

    public static int lastIndexOf$default(CharSequence arg0, char arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = StringsKt.getLastIndex(arg0);
        }

        return StringsKt.lastIndexOf(arg0, arg1, arg2, false);
    }

    public static int lastIndexOf$default(CharSequence arg0, String arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = StringsKt.getLastIndex(arg0);
        }

        return StringsKt.lastIndexOf(arg0, arg1, arg2, false);
    }

    public static final int lastIndexOfAny(CharSequence arg1, Collection arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "strings");
        Pair v1 = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(arg1, arg2, arg3, arg4, true);
        if(v1 != null) {
            return v1.getFirst().intValue();
        }

        return -1;
    }

    public static final int lastIndexOfAny(CharSequence arg4, char[] arg5, int arg6, boolean arg7) {
        int v0;
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "chars");
        if(!arg7 && arg5.length == 1 && ((arg4 instanceof String))) {
            return ((String)arg4).lastIndexOf(ArraysKt.single(arg5), arg6);
        }

        for(arg6 = RangesKt.coerceAtMost(arg6, StringsKt.getLastIndex(arg4)); true; --arg6) {
            v0 = -1;
            if(v0 >= arg6) {
                return v0;
            }

            char v0_1 = arg4.charAt(arg6);
            int v1 = arg5.length;
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                if(CharsKt.equals(arg5[v2], v0_1, arg7)) {
                    return arg6;
                }
            }
        }

        return v0;
    }

    public static int lastIndexOfAny$default(CharSequence arg0, Collection arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = StringsKt.getLastIndex(arg0);
        }

        return StringsKt.lastIndexOfAny(arg0, arg1, arg2, false);
    }

    public static int lastIndexOfAny$default(CharSequence arg0, char[] arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = StringsKt.getLastIndex(arg0);
        }

        return StringsKt.lastIndexOfAny(arg0, arg1, arg2, false);
    }

    public static final Sequence lineSequence(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(arg1);
    }

    public static final List lines(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.toList(StringsKt.lineSequence(arg1));
    }

    private static final boolean matches(CharSequence arg1, Regex arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        return arg2.matches(arg1);
    }

    private static final String orEmpty(String arg0) {
        if(arg0 == null) {
            arg0 = "";
        }

        return arg0;
    }

    public static final CharSequence padEnd(CharSequence arg1, int arg2, char arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 >= 0) {
            if(arg2 <= arg1.length()) {
                return arg1.subSequence(0, arg1.length());
            }

            StringBuilder v0 = new StringBuilder(arg2);
            v0.append(arg1);
            arg2 -= arg1.length();
            int v1 = 1;
            if(1 <= arg2) {
                while(true) {
                    v0.append(arg3);
                    if(v1 != arg2) {
                        ++v1;
                        continue;
                    }

                    break;
                }
            }

            return ((CharSequence)v0);
        }

        throw new IllegalArgumentException("Desired length " + arg2 + " is less than zero.");
    }

    public static final String padEnd(String arg1, int arg2, char arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.padEnd(((CharSequence)arg1), arg2, arg3).toString();
    }

    public static CharSequence padEnd$default(CharSequence arg0, int arg1, char arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ' ';
        }

        return StringsKt.padEnd(arg0, arg1, arg2);
    }

    public static String padEnd$default(String arg0, int arg1, char arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ' ';
        }

        return StringsKt.padEnd(arg0, arg1, arg2);
    }

    public static final CharSequence padStart(CharSequence arg2, int arg3, char arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 >= 0) {
            if(arg3 <= arg2.length()) {
                return arg2.subSequence(0, arg2.length());
            }

            StringBuilder v0 = new StringBuilder(arg3);
            arg3 -= arg2.length();
            int v1 = 1;
            if(1 <= arg3) {
                while(true) {
                    v0.append(arg4);
                    if(v1 != arg3) {
                        ++v1;
                        continue;
                    }

                    break;
                }
            }

            v0.append(arg2);
            return ((CharSequence)v0);
        }

        throw new IllegalArgumentException("Desired length " + arg3 + " is less than zero.");
    }

    public static final String padStart(String arg1, int arg2, char arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.padStart(((CharSequence)arg1), arg2, arg3).toString();
    }

    public static CharSequence padStart$default(CharSequence arg0, int arg1, char arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ' ';
        }

        return StringsKt.padStart(arg0, arg1, arg2);
    }

    public static String padStart$default(String arg0, int arg1, char arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = ' ';
        }

        return StringsKt.padStart(arg0, arg1, arg2);
    }

    private static final Sequence rangesDelimitedBy$StringsKt__StringsKt(CharSequence arg2, char[] arg3, int arg4, boolean arg5, int arg6) {
        StringsKt.requireNonNegativeLimit(arg6);
        return new DelimitedRangesSequence(arg2, arg4, arg6, new StringsKt__StringsKt$$ExternalSyntheticLambda1(arg3, arg5));
    }

    private static final Sequence rangesDelimitedBy$StringsKt__StringsKt(CharSequence arg2, String[] arg3, int arg4, boolean arg5, int arg6) {
        StringsKt.requireNonNegativeLimit(arg6);
        return new DelimitedRangesSequence(arg2, arg4, arg6, new StringsKt__StringsKt$$ExternalSyntheticLambda2(ArraysKt.asList(((Object[])arg3)), arg5));
    }

    static Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence arg1, char[] arg2, int arg3, boolean arg4, int arg5, int arg6, Object arg7) {
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(arg1, arg2, 0, false, 0);
    }

    static Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence arg1, String[] arg2, int arg3, boolean arg4, int arg5, int arg6, Object arg7) {
        return StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt(arg1, arg2, 0, false, 0);
    }

    private static final Pair rangesDelimitedBy$lambda$0$StringsKt__StringsKt(char[] arg1, boolean arg2, CharSequence arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "$this$DelimitedRangesSequence");
        int v1 = StringsKt.indexOfAny(arg3, arg1, arg4, arg2);
        if(v1 < 0) {
            return null;
        }

        return TuplesKt.to(Integer.valueOf(v1), Integer.valueOf(1));
    }

    private static final Pair rangesDelimitedBy$lambda$1$StringsKt__StringsKt(List arg1, boolean arg2, CharSequence arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "$this$DelimitedRangesSequence");
        Pair v1 = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(arg3, ((Collection)arg1), arg4, arg2, false);
        if(v1 != null) {
            return TuplesKt.to(v1.getFirst(), Integer.valueOf(v1.getSecond().length()));
        }

        return null;
    }

    public static final boolean regionMatchesImpl(CharSequence arg4, int arg5, CharSequence arg6, int arg7, int arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "other");
        if(arg7 >= 0 && arg5 >= 0 && arg5 <= arg4.length() - arg8) {
            if(arg7 > arg6.length() - arg8) {
            }
            else {
                int v1 = 0;
                while(true) {
                    if(v1 >= arg8) {
                        return 1;
                    }
                    else if(!CharsKt.equals(arg4.charAt(arg5 + v1), arg6.charAt(arg7 + v1), arg9)) {
                        return 0;
                    }
                    else {
                        ++v1;
                        continue;
                    }

                    return 0;
                }

                return 1;
            }
        }

        return 0;
    }

    public static final CharSequence removePrefix(CharSequence arg3, CharSequence arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "prefix");
        if(StringsKt.startsWith$default(arg3, arg4, false, 2, null)) {
            return arg3.subSequence(arg4.length(), arg3.length());
        }

        return arg3.subSequence(0, arg3.length());
    }

    public static final String removePrefix(String arg4, CharSequence arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "prefix");
        if(StringsKt.startsWith$default(arg4, arg5, false, 2, null)) {
            arg4 = arg4.substring(arg5.length());
            Intrinsics.checkNotNullExpressionValue(arg4, "substring(...)");
        }

        return arg4;
    }

    public static final CharSequence removeRange(CharSequence arg4, int arg5, int arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg6 >= arg5) {
            if(arg6 == arg5) {
                return arg4.subSequence(0, arg4.length());
            }

            StringBuilder v1 = new StringBuilder(arg4.length() - (arg6 - arg5));
            Intrinsics.checkNotNullExpressionValue(v1.append(arg4, 0, arg5), "append(...)");
            Intrinsics.checkNotNullExpressionValue(v1.append(arg4, arg6, arg4.length()), "append(...)");
            return ((CharSequence)v1);
        }

        throw new IndexOutOfBoundsException("End index (" + arg6 + ") is less than start index (" + arg5 + ").");
    }

    public static final CharSequence removeRange(CharSequence arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        return StringsKt.removeRange(arg1, arg2.getStart().intValue(), arg2.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.removeRange(((CharSequence)arg1), arg2, arg3).toString();
    }

    private static final String removeRange(String arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        return StringsKt.removeRange(((CharSequence)arg1), arg2).toString();
    }

    public static final CharSequence removeSuffix(CharSequence arg3, CharSequence arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "suffix");
        if(StringsKt.endsWith$default(arg3, arg4, false, 2, null)) {
            return arg3.subSequence(0, arg3.length() - arg4.length());
        }

        return arg3.subSequence(0, arg3.length());
    }

    public static final String removeSuffix(String arg4, CharSequence arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "suffix");
        if(StringsKt.endsWith$default(arg4, arg5, false, 2, null)) {
            arg4 = arg4.substring(0, arg4.length() - arg5.length());
            Intrinsics.checkNotNullExpressionValue(arg4, "substring(...)");
        }

        return arg4;
    }

    public static final CharSequence removeSurrounding(CharSequence arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "delimiter");
        return StringsKt.removeSurrounding(arg1, arg2, arg2);
    }

    public static final CharSequence removeSurrounding(CharSequence arg4, CharSequence arg5, CharSequence arg6) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "prefix");
        Intrinsics.checkNotNullParameter(arg6, "suffix");
        if(arg4.length() >= arg5.length() + arg6.length()) {
            int v0 = 2;
            Object v1 = null;
            if((StringsKt.startsWith$default(arg4, arg5, false, v0, v1)) && (StringsKt.endsWith$default(arg4, arg6, false, v0, v1))) {
                return arg4.subSequence(arg5.length(), arg4.length() - arg6.length());
            }
        }

        return arg4.subSequence(0, arg4.length());
    }

    public static final String removeSurrounding(String arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "delimiter");
        return StringsKt.removeSurrounding(arg1, arg2, arg2);
    }

    public static final String removeSurrounding(String arg5, CharSequence arg6, CharSequence arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "prefix");
        Intrinsics.checkNotNullParameter(arg7, "suffix");
        if(arg5.length() >= arg6.length() + arg7.length()) {
            String v0 = arg5;
            int v2 = 2;
            Object v3 = null;
            if((StringsKt.startsWith$default(((CharSequence)v0), arg6, false, v2, v3)) && (StringsKt.endsWith$default(((CharSequence)v0), arg7, false, v2, v3))) {
                arg5 = arg5.substring(arg6.length(), arg5.length() - arg7.length());
                Intrinsics.checkNotNullExpressionValue(arg5, "substring(...)");
            }
        }

        return arg5;
    }

    private static final String replace(CharSequence arg1, Regex arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        return arg2.replace(arg1, arg3);
    }

    private static final String replace(CharSequence arg1, Regex arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        return arg2.replace(arg1, arg3);
    }

    public static final String replaceAfter(String arg7, char arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v8 = StringsKt.indexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8 + 1, arg7.length(), ((CharSequence)arg9)).toString();
    }

    public static final String replaceAfter(String arg7, String arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        String v2 = arg8;
        int v8 = StringsKt.indexOf$default(((CharSequence)v1), v2, 0, false, 6, null);
        if(v8 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8 + v2.length(), arg7.length(), ((CharSequence)arg9)).toString();
    }

    public static String replaceAfter$default(String arg0, char arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceAfter(arg0, arg1, arg2, arg3);
    }

    public static String replaceAfter$default(String arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceAfter(arg0, arg1, arg2, arg3);
    }

    public static final String replaceAfterLast(String arg7, char arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v8 = StringsKt.lastIndexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8 + 1, arg7.length(), ((CharSequence)arg9)).toString();
    }

    public static final String replaceAfterLast(String arg7, String arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        String v2 = arg8;
        int v8 = StringsKt.lastIndexOf$default(((CharSequence)v1), v2, 0, false, 6, null);
        if(v8 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8 + v2.length(), arg7.length(), ((CharSequence)arg9)).toString();
    }

    public static String replaceAfterLast$default(String arg0, char arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceAfterLast(arg0, arg1, arg2, arg3);
    }

    public static String replaceAfterLast$default(String arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceAfterLast(arg0, arg1, arg2, arg3);
    }

    public static final String replaceBefore(String arg7, char arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v7 = StringsKt.indexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v7 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), 0, v7, ((CharSequence)arg9)).toString();
    }

    public static final String replaceBefore(String arg7, String arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v7 = StringsKt.indexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v7 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), 0, v7, ((CharSequence)arg9)).toString();
    }

    public static String replaceBefore$default(String arg0, char arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceBefore(arg0, arg1, arg2, arg3);
    }

    public static String replaceBefore$default(String arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceBefore(arg0, arg1, arg2, arg3);
    }

    public static final String replaceBeforeLast(String arg7, char arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v7 = StringsKt.lastIndexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v7 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), 0, v7, ((CharSequence)arg9)).toString();
    }

    public static final String replaceBeforeLast(String arg7, String arg8, String arg9, String arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "replacement");
        Intrinsics.checkNotNullParameter(arg10, "missingDelimiterValue");
        String v1 = arg7;
        int v7 = StringsKt.lastIndexOf$default(((CharSequence)v1), arg8, 0, false, 6, null);
        if(v7 == -1) {
            return arg10;
        }

        return StringsKt.replaceRange(((CharSequence)v1), 0, v7, ((CharSequence)arg9)).toString();
    }

    public static String replaceBeforeLast$default(String arg0, char arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceBeforeLast(arg0, arg1, arg2, arg3);
    }

    public static String replaceBeforeLast$default(String arg0, String arg1, String arg2, String arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0;
        }

        return StringsKt.replaceBeforeLast(arg0, arg1, arg2, arg3);
    }

    private static final String replaceFirst(CharSequence arg1, Regex arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        return arg2.replaceFirst(arg1, arg3);
    }

    private static final String replaceFirstCharWithChar(String arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "transform");
        if(arg1.length() > 0) {
            char v2 = arg2.invoke(Character.valueOf(arg1.charAt(0))).charValue();
            arg1 = arg1.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
            arg1 = v2 + arg1;
        }

        return arg1;
    }

    private static final String replaceFirstCharWithCharSequence(String arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        if(arg2.length() > 0) {
            StringBuilder v3 = new StringBuilder().append(arg3.invoke(Character.valueOf(arg2.charAt(0))));
            arg2 = arg2.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
            arg2 = v3.append(arg2).toString();
        }

        return arg2;
    }

    public static final CharSequence replaceRange(CharSequence arg2, int arg3, int arg4, CharSequence arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "replacement");
        if(arg4 >= arg3) {
            StringBuilder v0 = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(v0.append(arg2, 0, arg3), "append(...)");
            v0.append(arg5);
            Intrinsics.checkNotNullExpressionValue(v0.append(arg2, arg4, arg2.length()), "append(...)");
            return ((CharSequence)v0);
        }

        throw new IndexOutOfBoundsException("End index (" + arg4 + ") is less than start index (" + arg3 + ").");
    }

    public static final CharSequence replaceRange(CharSequence arg1, IntRange arg2, CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        return StringsKt.replaceRange(arg1, arg2.getStart().intValue(), arg2.getEndInclusive().intValue() + 1, arg3);
    }

    private static final String replaceRange(String arg1, int arg2, int arg3, CharSequence arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "replacement");
        return StringsKt.replaceRange(((CharSequence)arg1), arg2, arg3, arg4).toString();
    }

    private static final String replaceRange(String arg1, IntRange arg2, CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        Intrinsics.checkNotNullParameter(arg3, "replacement");
        return StringsKt.replaceRange(((CharSequence)arg1), arg2, arg3).toString();
    }

    public static final void requireNonNegativeLimit(int arg2) {
        if(arg2 >= 0) {
            return;
        }

        throw new IllegalArgumentException("Limit must be non-negative, but was " + arg2.toString());
    }

    public static final int skipWhile(String arg1, int arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        while(arg2 < arg1.length()) {
            if(!arg3.invoke(Character.valueOf(arg1.charAt(arg2))).booleanValue()) {
                return arg2;
            }

            ++arg2;
        }

        return arg2;
    }

    private static final List split(CharSequence arg1, Regex arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        return arg2.split(arg1, arg3);
    }

    public static final List split(CharSequence arg7, char[] arg8, boolean arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiters");
        if(arg8.length == 1) {
            return StringsKt__StringsKt.split$StringsKt__StringsKt(arg7, String.valueOf(arg8[0]), arg9, arg10);
        }

        CharSequence v0 = arg7;
        Iterable v7 = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(v0, arg8, 0, arg9, arg10, 2, null));
        ArrayList v8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v7, 10));
        Iterator v7_1 = v7.iterator();
        while(v7_1.hasNext()) {
            ((Collection)v8).add(StringsKt.substring(v0, v7_1.next()));
        }

        return ((List)v8);
    }

    public static final List split(CharSequence arg7, String[] arg8, boolean arg9, int arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiters");
        if(arg8.length == 1) {
            String v0 = arg8[0];
            if(v0.length() == 0) {
            }
            else {
                return StringsKt__StringsKt.split$StringsKt__StringsKt(arg7, v0, arg9, arg10);
            }
        }

        CharSequence v0_1 = arg7;
        Iterable v7 = SequencesKt.asIterable(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(v0_1, arg8, 0, arg9, arg10, 2, null));
        ArrayList v8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(v7, 10));
        Iterator v7_1 = v7.iterator();
        while(v7_1.hasNext()) {
            ((Collection)v8).add(StringsKt.substring(v0_1, v7_1.next()));
        }

        return ((List)v8);
    }

    private static final List split$StringsKt__StringsKt(CharSequence arg7, String arg8, boolean arg9, int arg10) {
        StringsKt.requireNonNegativeLimit(arg10);
        int v0 = 0;
        int v1 = StringsKt.indexOf(arg7, arg8, 0, arg9);
        int v2 = -1;
        if(v1 != v2) {
            if(arg10 == 1) {
            }
            else {
                int v4 = arg10 > 0 ? 1 : 0;
                int v6 = 10;
                if(v4 != 0) {
                    v6 = RangesKt.coerceAtMost(arg10, v6);
                }

                ArrayList v5 = new ArrayList(v6);
                do {
                    v5.add(arg7.subSequence(v0, v1).toString());
                    v0 = arg8.length() + v1;
                    if(v4 != 0 && v5.size() == arg10 - 1) {
                        break;
                    }

                    v1 = StringsKt.indexOf(arg7, arg8, v0, arg9);
                }
                while(v1 != v2);

                v5.add(arg7.subSequence(v0, arg7.length()).toString());
                return ((List)v5);
            }
        }

        return CollectionsKt.listOf(arg7.toString());
    }

    static List split$default(CharSequence arg0, Regex arg1, int arg2, int arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "regex");
        return arg1.split(arg0, 0);
    }

    public static List split$default(CharSequence arg1, char[] arg2, boolean arg3, int arg4, int arg5, Object arg6) {
        return StringsKt.split(arg1, arg2, false, 0);
    }

    public static List split$default(CharSequence arg1, String[] arg2, boolean arg3, int arg4, int arg5, Object arg6) {
        return StringsKt.split(arg1, arg2, false, 0);
    }

    private static final Sequence splitToSequence(CharSequence arg1, Regex arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        return arg2.splitToSequence(arg1, arg3);
    }

    public static final Sequence splitToSequence(CharSequence arg8, char[] arg9, boolean arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(arg8, arg9, 0, arg10, arg11, 2, null), new StringsKt__StringsKt$$ExternalSyntheticLambda0(arg8));
    }

    public static final Sequence splitToSequence(CharSequence arg8, String[] arg9, boolean arg10, int arg11) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "delimiters");
        return SequencesKt.map(StringsKt__StringsKt.rangesDelimitedBy$StringsKt__StringsKt$default(arg8, arg9, 0, arg10, arg11, 2, null), new StringsKt__StringsKt$$ExternalSyntheticLambda3(arg8));
    }

    static Sequence splitToSequence$default(CharSequence arg0, Regex arg1, int arg2, int arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "regex");
        return arg1.splitToSequence(arg0, 0);
    }

    public static Sequence splitToSequence$default(CharSequence arg1, char[] arg2, boolean arg3, int arg4, int arg5, Object arg6) {
        return StringsKt.splitToSequence(arg1, arg2, false, 0);
    }

    public static Sequence splitToSequence$default(CharSequence arg1, String[] arg2, boolean arg3, int arg4, int arg5, Object arg6) {
        return StringsKt.splitToSequence(arg1, arg2, false, 0);
    }

    private static final String splitToSequence$lambda$0$StringsKt__StringsKt(CharSequence arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return StringsKt.substring(arg1, arg2);
    }

    private static final String splitToSequence$lambda$1$StringsKt__StringsKt(CharSequence arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg2, "it");
        return StringsKt.substring(arg1, arg2);
    }

    public static final boolean startsWith(CharSequence arg2, char arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.length() > 0 && (CharsKt.equals(arg2.charAt(0), arg3, arg4))) {
            return 1;
        }

        return 0;
    }

    public static final boolean startsWith(CharSequence arg7, CharSequence arg8, int arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "prefix");
        if(!arg10 && ((arg7 instanceof String)) && ((arg8 instanceof String))) {
            return StringsKt.startsWith$default(arg7, arg8, arg9, false, 4, null);
        }

        return StringsKt.regionMatchesImpl(arg7, arg9, arg8, 0, arg8.length(), arg10);
    }

    public static final boolean startsWith(CharSequence arg6, CharSequence arg7, boolean arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "prefix");
        if(!arg8 && ((arg6 instanceof String)) && ((arg7 instanceof String))) {
            return StringsKt.startsWith$default(((String)arg6), ((String)arg7), false, 2, null);
        }

        return StringsKt.regionMatchesImpl(arg6, 0, arg7, 0, arg7.length(), arg8);
    }

    public static boolean startsWith$default(CharSequence arg0, char arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.startsWith(arg0, arg1, false);
    }

    public static boolean startsWith$default(CharSequence arg0, CharSequence arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.startsWith(arg0, arg1, arg2, false);
    }

    public static boolean startsWith$default(CharSequence arg0, CharSequence arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.startsWith(arg0, arg1, false);
    }

    public static final CharSequence subSequence(CharSequence arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        return arg1.subSequence(arg2.getStart().intValue(), arg2.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message="Use parameters named startIndex and endIndex.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.3", warningSince="1.0") private static final CharSequence subSequence(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.subSequence(arg2, arg3);
    }

    private static final String substring(CharSequence arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.subSequence(arg2, arg3).toString();
    }

    public static final String substring(CharSequence arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        return arg1.subSequence(arg2.getStart().intValue(), arg2.getEndInclusive().intValue() + 1).toString();
    }

    public static final String substring(String arg1, IntRange arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "range");
        arg1 = arg1.substring(arg2.getStart().intValue(), arg2.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return arg1;
    }

    static String substring$default(CharSequence arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        return arg0.subSequence(arg1, arg2).toString();
    }

    public static final String substringAfter(String arg7, char arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.indexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(v8 + 1, arg7.length());
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static final String substringAfter(String arg7, String arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        String v2 = arg8;
        int v8 = StringsKt.indexOf$default(arg7, v2, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(v8 + v2.length(), arg7.length());
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static String substringAfter$default(String arg0, char arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringAfter(arg0, arg1, arg2);
    }

    public static String substringAfter$default(String arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringAfter(arg0, arg1, arg2);
    }

    public static final String substringAfterLast(String arg7, char arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.lastIndexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(v8 + 1, arg7.length());
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static final String substringAfterLast(String arg7, String arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        String v2 = arg8;
        int v8 = StringsKt.lastIndexOf$default(arg7, v2, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(v8 + v2.length(), arg7.length());
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static String substringAfterLast$default(String arg0, char arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringAfterLast(arg0, arg1, arg2);
    }

    public static String substringAfterLast$default(String arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringAfterLast(arg0, arg1, arg2);
    }

    public static final String substringBefore(String arg7, char arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.indexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(0, v8);
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static final String substringBefore(String arg7, String arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.indexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(0, v8);
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static String substringBefore$default(String arg0, char arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringBefore(arg0, arg1, arg2);
    }

    public static String substringBefore$default(String arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringBefore(arg0, arg1, arg2);
    }

    public static final String substringBeforeLast(String arg7, char arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.lastIndexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(0, v8);
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static final String substringBeforeLast(String arg7, String arg8, String arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "delimiter");
        Intrinsics.checkNotNullParameter(arg9, "missingDelimiterValue");
        int v8 = StringsKt.lastIndexOf$default(arg7, arg8, 0, false, 6, null);
        if(v8 == -1) {
            return arg9;
        }

        arg7 = arg7.substring(0, v8);
        Intrinsics.checkNotNullExpressionValue(arg7, "substring(...)");
        return arg7;
    }

    public static String substringBeforeLast$default(String arg0, char arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringBeforeLast(arg0, arg1, arg2);
    }

    public static String substringBeforeLast$default(String arg0, String arg1, String arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0;
        }

        return StringsKt.substringBeforeLast(arg0, arg1, arg2);
    }

    public static final boolean toBooleanStrict(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(Intrinsics.areEqual(arg3, "true")) {
            return 1;
        }

        if(Intrinsics.areEqual(arg3, "false")) {
            return 0;
        }

        throw new IllegalArgumentException("The string doesn\'t represent a boolean value: " + arg3);
    }

    public static final Boolean toBooleanStrictOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(Intrinsics.areEqual(arg1, "true")) {
            return Boolean.valueOf(true);
        }

        if(Intrinsics.areEqual(arg1, "false")) {
            return Boolean.valueOf(false);
        }

        return null;
    }

    public static final CharSequence trim(CharSequence arg5) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        int v0 = arg5.length() - 1;
        int v2 = 0;
        int v3 = 0;
        while(v2 <= v0) {
            int v4 = v3 == 0 ? v2 : v0;
            boolean v4_1 = CharsKt.isWhitespace(arg5.charAt(v4));
            if(v3 == 0) {
                if(!v4_1) {
                    v3 = 1;
                    continue;
                }

                ++v2;
                continue;
            }

            if(!v4_1) {
                break;
            }

            --v0;
        }

        return arg5.subSequence(v2, v0 + 1);
    }

    public static final CharSequence trim(CharSequence arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "predicate");
        int v0 = arg5.length() - 1;
        int v2 = 0;
        int v3 = 0;
        while(v2 <= v0) {
            int v4 = v3 == 0 ? v2 : v0;
            boolean v4_1 = arg6.invoke(Character.valueOf(arg5.charAt(v4))).booleanValue();
            if(v3 == 0) {
                if(!v4_1) {
                    v3 = 1;
                    continue;
                }

                ++v2;
                continue;
            }

            if(!v4_1) {
                break;
            }

            --v0;
        }

        return arg5.subSequence(v2, v0 + 1);
    }

    public static final CharSequence trim(CharSequence arg5, char[] arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "chars");
        int v0 = arg5.length() - 1;
        int v2 = 0;
        int v3 = 0;
        while(v2 <= v0) {
            int v4 = v3 == 0 ? v2 : v0;
            boolean v4_1 = ArraysKt.contains(arg6, arg5.charAt(v4));
            if(v3 == 0) {
                if(!v4_1) {
                    v3 = 1;
                    continue;
                }

                ++v2;
                continue;
            }

            if(!v4_1) {
                break;
            }

            --v0;
        }

        return arg5.subSequence(v2, v0 + 1);
    }

    private static final String trim(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.trim(((CharSequence)arg1)).toString();
    }

    public static final String trim(String arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "predicate");
        int v0 = ((CharSequence)arg5).length() - 1;
        int v2 = 0;
        int v3 = 0;
        while(v2 <= v0) {
            int v4 = v3 == 0 ? v2 : v0;
            boolean v4_1 = arg6.invoke(Character.valueOf(((CharSequence)arg5).charAt(v4))).booleanValue();
            if(v3 == 0) {
                if(!v4_1) {
                    v3 = 1;
                    continue;
                }

                ++v2;
                continue;
            }

            if(!v4_1) {
                break;
            }

            --v0;
        }

        return ((CharSequence)arg5).subSequence(v2, v0 + 1).toString();
    }

    public static final String trim(String arg5, char[] arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "chars");
        int v0 = ((CharSequence)arg5).length() - 1;
        int v2 = 0;
        int v3 = 0;
        while(v2 <= v0) {
            int v4 = v3 == 0 ? v2 : v0;
            boolean v4_1 = ArraysKt.contains(arg6, ((CharSequence)arg5).charAt(v4));
            if(v3 == 0) {
                if(!v4_1) {
                    v3 = 1;
                    continue;
                }

                ++v2;
                continue;
            }

            if(!v4_1) {
                break;
            }

            --v0;
        }

        return ((CharSequence)arg5).subSequence(v2, v0 + 1).toString();
    }

    public static final CharSequence trimEnd(CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        int v0 = arg3.length() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                if(!CharsKt.isWhitespace(arg3.charAt(v0))) {
                    break;
                }
                else if(v1 < 0) {
                }
                else {
                    v0 = v1;
                    continue;
                }

                return "";
            }

            return arg3.subSequence(0, v0 + 1);
        }

        return "";
    }

    public static final CharSequence trimEnd(CharSequence arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        int v0 = arg3.length() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                if(!arg4.invoke(Character.valueOf(arg3.charAt(v0))).booleanValue()) {
                    break;
                }
                else if(v1 < 0) {
                }
                else {
                    v0 = v1;
                    continue;
                }

                return "";
            }

            return arg3.subSequence(0, v0 + 1);
        }

        return "";
    }

    public static final CharSequence trimEnd(CharSequence arg3, char[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "chars");
        int v0 = arg3.length() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                if(!ArraysKt.contains(arg4, arg3.charAt(v0))) {
                    break;
                }
                else if(v1 < 0) {
                }
                else {
                    v0 = v1;
                    continue;
                }

                return "";
            }

            return arg3.subSequence(0, v0 + 1);
        }

        return "";
    }

    private static final String trimEnd(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.trimEnd(((CharSequence)arg1)).toString();
    }

    public static final String trimEnd(String arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        int v0 = ((CharSequence)arg3).length() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                if(!arg4.invoke(Character.valueOf(((CharSequence)arg3).charAt(v0))).booleanValue()) {
                    break;
                }
                else if(v1 < 0) {
                    goto label_21;
                }
                else {
                    v0 = v1;
                    continue;
                }
            }

            CharSequence v3 = ((CharSequence)arg3).subSequence(0, v0 + 1);
        }
        else {
        label_21:
            arg3 = "";
        }

        return arg3.toString();
    }

    public static final String trimEnd(String arg3, char[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "chars");
        int v0 = ((CharSequence)arg3).length() - 1;
        if(v0 >= 0) {
            while(true) {
                int v1 = v0 - 1;
                if(!ArraysKt.contains(arg4, ((CharSequence)arg3).charAt(v0))) {
                    break;
                }
                else if(v1 < 0) {
                    goto label_19;
                }
                else {
                    v0 = v1;
                    continue;
                }
            }

            CharSequence v3 = ((CharSequence)arg3).subSequence(0, v0 + 1);
        }
        else {
        label_19:
            arg3 = "";
        }

        return arg3.toString();
    }

    public static final CharSequence trimStart(CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        int v0 = arg3.length();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(!CharsKt.isWhitespace(arg3.charAt(v1))) {
                return arg3.subSequence(v1, arg3.length());
            }
        }

        return "";
    }

    public static final CharSequence trimStart(CharSequence arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        int v0 = arg3.length();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(!arg4.invoke(Character.valueOf(arg3.charAt(v1))).booleanValue()) {
                return arg3.subSequence(v1, arg3.length());
            }
        }

        return "";
    }

    public static final CharSequence trimStart(CharSequence arg3, char[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "chars");
        int v0 = arg3.length();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(!ArraysKt.contains(arg4, arg3.charAt(v1))) {
                return arg3.subSequence(v1, arg3.length());
            }
        }

        return "";
    }

    private static final String trimStart(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.trimStart(((CharSequence)arg1)).toString();
    }

    public static final String trimStart(String arg3, Function1 arg4) {
        CharSequence v3;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        int v0 = ((CharSequence)arg3).length();
        int v1 = 0;
        while(true) {
            if(v1 >= v0) {
                break;
            }
            else if(!arg4.invoke(Character.valueOf(((CharSequence)arg3).charAt(v1))).booleanValue()) {
                v3 = ((CharSequence)arg3).subSequence(v1, ((CharSequence)arg3).length());
            }
            else {
                ++v1;
                continue;
            }

            goto label_18;
        }

        arg3 = "";
    label_18:
        return v3.toString();
    }

    public static final String trimStart(String arg3, char[] arg4) {
        CharSequence v3;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "chars");
        int v0 = ((CharSequence)arg3).length();
        int v1 = 0;
        while(true) {
            if(v1 >= v0) {
                break;
            }
            else if(!ArraysKt.contains(arg4, ((CharSequence)arg3).charAt(v1))) {
                v3 = ((CharSequence)arg3).subSequence(v1, ((CharSequence)arg3).length());
            }
            else {
                ++v1;
                continue;
            }

            goto label_16;
        }

        arg3 = "";
    label_16:
        return v3.toString();
    }
}

