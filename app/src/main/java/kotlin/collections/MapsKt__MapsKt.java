package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u0084\u0001\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010&\n\u0002\b\f\n\u0002\u0010(\n\u0002\u0010)\n\u0002\u0010\'\n\u0002\b\b\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u001D\u001A\"\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0086\u0080\u0004\u001AS\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001A\"\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004\u001A\"\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004\u001AS\u0010\t\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001A7\u0010\u000B\u001A\u001E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\fj\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004¢\u0006\u0002\u0010\u000E\u001Ac\u0010\u000B\u001A\u001E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\fj\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000F\u001A7\u0010\u0010\u001A\u001E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011j\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0013\u001Ac\u0010\u0010\u001A\u001E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011j\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003`\u0012\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032*\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0014\u001AY\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032%\b\u0001\u0010\u0016\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001Aa\u0010\u0015\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u001A\u001A\u00020\u001B2%\b\u0001\u0010\u0016\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A(\u0010\u001C\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0088\u0004\u001A;\u0010\u001E\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0088\u0004\u0082\u0002\u000E\n\f\b\u0000\u0012\u0002\u0018\u0001\u001A\u0004\b\u0003\u0010\u0000\u001A4\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001H\u0087\u0088\u0004\u001AM\u0010 \u001A\u0002H!\"\u0014\b\u0000\u0010\"*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H!0$H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010%\u001A:\u0010&\u001A\u00020\u001D\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010)\u001A<\u0010*\u001A\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010+\u001A;\u0010,\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001A\u0002H\u00022\u0006\u0010-\u001A\u0002H\u0003H\u0087\u008A\u0004¢\u0006\u0002\u0010.\u001A2\u0010/\u001A\u00020\u001D\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\'*\u000E\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00012\u0006\u0010(\u001A\u0002H\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010)\u001A8\u00100\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\t\b\u0001\u0010\u0003¢\u0006\u0002\b\'*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010-\u001A\u0002H\u0003H\u0087\u0088\u0004¢\u0006\u0002\u0010)\u001A<\u00101\u001A\u0004\u0018\u0001H\u0003\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b\'\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001A\u0002H\u0002H\u0087\u0088\b¢\u0006\u0002\u0010+\u001A+\u00102\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\u008A\u0004¢\u0006\u0002\u00104\u001A+\u00105\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\u008A\u0004¢\u0006\u0002\u00104\u001A2\u00106\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\u0088\u0004\u001A2\u00107\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303H\u0087\u0080\u0004\u001A7\u00108\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010(\u001A\u0002H\u00022\u0006\u0010-\u001A\u0002H\u0003H\u0080\u0080\u0004¢\u0006\u0002\u00109\u001AQ\u0010:\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u00022\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00030$H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0002\u0010;\u001AD\u0010<\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u00022\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00030$H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010;\u001A3\u0010=\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010+\u001AD\u0010>\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001A\u0002H\u00022\f\u0010#\u001A\b\u0012\u0004\u0012\u0002H\u00030$H\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010;\u001A:\u0010?\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003030@\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u008A\u0004\u001A=\u0010?\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030B0A\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\nH\u0087\u008A\u0004¢\u0006\u0002\bC\u001Ax\u0010D\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!\"\u0018\b\u0003\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H!0\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010E\u001A\u0002H\"2\u001E\u0010F\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010G\u001Ax\u0010H\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!\"\u0018\b\u0003\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H!\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010E\u001A\u0002H\"2\u001E\u0010F\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010G\u001AK\u0010I\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u001A\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010J\u001AD\u0010I\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070KH\u0086\u0080\u0004\u001AD\u0010I\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070LH\u0086\u0080\u0004\u001A]\u0010M\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001E\u0010F\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001A]\u0010N\u001A\u000E\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010!*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001E\u0010F\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u0002H!0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001AK\u0010O\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010P\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u001D0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001AK\u0010Q\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010P\u001A\u000E\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001D0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001Ar\u0010R\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010E\u001A\u0002H\"2\u001E\u0010P\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001D0\u0017H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010G\u001AW\u0010S\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001E\u0010P\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001D0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001Ar\u0010T\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010E\u001A\u0002H\"2\u001E\u0010P\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001D0\u0017H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010G\u001AW\u0010U\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001E\u0010P\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000303\u0012\u0004\u0012\u00020\u001D0\u0017H\u0086\u0088\u0004ø\u0001\u0000\u001A8\u0010V\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070KH\u0086\u0080\u0004\u001AS\u0010V\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070K2\u0006\u0010E\u001A\u0002H\"H\u0087\u0080\b¢\u0006\u0002\u0010W\u001A?\u0010V\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001AU\u0010V\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u00062\u0006\u0010E\u001A\u0002H\"H\u0087\u0080\b¢\u0006\u0002\u0010X\u001A8\u0010V\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070LH\u0086\u0080\u0004\u001AS\u0010V\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070L2\u0006\u0010E\u001A\u0002H\"H\u0087\u0080\b¢\u0006\u0002\u0010Y\u001A4\u0010V\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0080\u0004\u001A4\u0010Z\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u0080\u0004\u001AO\u0010V\u001A\u0002H\"\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0018\b\u0002\u0010\"*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010E\u001A\u0002H\"H\u0087\u0080\b¢\u0006\u0002\u0010[\u001AH\u0010\\\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010]\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0086\u0082\u0004\u001AN\u0010\\\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070KH\u0086\u0082\u0004\u001AU\u0010\\\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u001A\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0086\u0082\u0004¢\u0006\u0002\u0010^\u001AN\u0010\\\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070LH\u0086\u0082\u0004\u001AJ\u0010\\\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0014\u0010_\u001A\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0082\u0004\u001A>\u0010`\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0012\u0010]\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u008A\u0004\u001AD\u0010`\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070KH\u0087\u008A\u0004\u001AK\u0010`\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u001A\u0010\u0005\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\u0006H\u0087\u008A\u0004¢\u0006\u0002\u0010J\u001AD\u0010`\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0018\u0010\u0005\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070LH\u0087\u008A\u0004\u001A>\u0010`\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0006\b\u0000\u0012\u0002H\u00030\n2\u0012\u0010_\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\u008A\u0004\u001AA\u0010a\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010(\u001A\u0002H\u0002H\u0087\u0082\u0004¢\u0006\u0002\u0010b\u001AB\u0010a\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010c\u001A\b\u0012\u0004\u0012\u0002H\u00020KH\u0087\u0082\u0004\u001AI\u0010a\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000E\u0010c\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\u0082\u0004¢\u0006\u0002\u0010d\u001AB\u0010a\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010c\u001A\b\u0012\u0004\u0012\u0002H\u00020LH\u0087\u0082\u0004\u001A3\u0010e\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u0006\u0010(\u001A\u0002H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010f\u001A4\u0010e\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\f\u0010c\u001A\b\u0012\u0004\u0012\u0002H\u00020KH\u0087\u008A\u0004\u001A;\u0010e\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\u000E\u0010c\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0087\u008A\u0004¢\u0006\u0002\u0010g\u001A4\u0010e\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\n2\f\u0010c\u001A\b\u0012\u0004\u0012\u0002H\u00020LH\u0087\u008A\u0004\u001A2\u0010h\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006i"}, d2={"emptyMap", "", "K", "V", "mapOf", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "()Ljava/util/HashMap;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "buildMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "isNotEmpty", "", "isNullOrEmpty", "orEmpty", "ifEmpty", "R", "M", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "set", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "containsKey", "containsValue", "remove", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "toPair", "copy", "mapEntryOf", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map$Entry;", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getValue", "getOrPut", "iterator", "", "", "", "mutableIterator", "mapValuesTo", "destination", "transform", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "mapKeysTo", "putAll", "(Ljava/util/Map;[Lkotlin/Pair;)V", "", "Lkotlin/sequences/Sequence;", "mapValues", "mapKeys", "filterKeys", "predicate", "filterValues", "filterTo", "filter", "filterNotTo", "filterNot", "toMap", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "plus", "pair", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "map", "plusAssign", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/MapsKt") class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public MapsKt__MapsKt() {
        super();
    }

    private static final Map buildMap(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Map v1 = MapsKt.createMapBuilder(arg1);
        arg2.invoke(v1);
        return MapsKt.build(v1);
    }

    private static final Map buildMap(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        Map v0 = MapsKt.createMapBuilder();
        arg1.invoke(v0);
        return MapsKt.build(v0);
    }

    private static final Object component1(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getKey();
    }

    private static final Object component2(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getValue();
    }

    private static final boolean contains(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.containsKey(arg2);
    }

    private static final boolean containsKey(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.containsKey(arg2);
    }

    private static final boolean containsValue(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.containsValue(arg2);
    }

    public static final Map$Entry copy(Map$Entry arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Map$Entry v0 = (arg1 instanceof DetachedMapEntry) ? arg1 : null;
        if(v0 != null) {
            return v0;
        }

        return MapsKt.mapEntryOf(arg1.getKey(), arg1.getValue());
    }

    public static final Map emptyMap() {
        EmptyMap v0 = EmptyMap.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return ((Map)v0);
    }

    public static final Map filter(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(!arg4.invoke(v1).booleanValue()) {
                continue;
            }

            ((Map)v0).put(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        }

        return ((Map)v0);
    }

    public static final Map filterKeys(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(!arg4.invoke(((Map$Entry)v1).getKey()).booleanValue()) {
                continue;
            }

            v0.put(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        }

        return ((Map)v0);
    }

    public static final Map filterNot(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(arg4.invoke(v1).booleanValue()) {
                continue;
            }

            ((Map)v0).put(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        }

        return ((Map)v0);
    }

    @IgnorableReturnValue public static final Map filterNotTo(Map arg2, Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            if(arg4.invoke(v0).booleanValue()) {
                continue;
            }

            arg3.put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }

        return arg3;
    }

    @IgnorableReturnValue public static final Map filterTo(Map arg2, Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            if(!arg4.invoke(v0).booleanValue()) {
                continue;
            }

            arg3.put(((Map$Entry)v0).getKey(), ((Map$Entry)v0).getValue());
        }

        return arg3;
    }

    public static final Map filterValues(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "predicate");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(!arg4.invoke(((Map$Entry)v1).getValue()).booleanValue()) {
                continue;
            }

            v0.put(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        }

        return ((Map)v0);
    }

    private static final Object get(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.get(arg2);
    }

    private static final Object getOrElse(Map arg1, Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v1 = arg1.get(arg2);
        if(v1 == null) {
            v1 = arg3.invoke();
        }

        return v1;
    }

    public static final Object getOrElseNullable(Map arg1, Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v0 = arg1.get(arg2);
        if(v0 == null && !arg1.containsKey(arg2)) {
            return arg3.invoke();
        }

        return v0;
    }

    public static final Object getOrPut(Map arg1, Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v0 = arg1.get(arg2);
        if(v0 == null) {
            Object v3 = arg3.invoke();
            arg1.put(arg2, v3);
            return v3;
        }

        return v0;
    }

    public static final Object getValue(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return MapsKt.getOrImplicitDefaultNullable(arg1, arg2);
    }

    private static final HashMap hashMapOf() {
        return new HashMap();
    }

    public static final HashMap hashMapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        HashMap v0 = new HashMap(MapsKt.mapCapacity(arg2.length));
        MapsKt.putAll(v0, arg2);
        return v0;
    }

    private static final Object ifEmpty(Map arg1, Function0 arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(arg1.isEmpty()) {
            v1 = arg2.invoke();
        }

        return ((Map)v1);
    }

    private static final boolean isNotEmpty(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty() ^ 1;
    }

    private static final boolean isNullOrEmpty(Map arg0) {
        if(arg0 != null) {
            if(arg0.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final Iterator iterator(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.entrySet().iterator();
    }

    private static final LinkedHashMap linkedMapOf() {
        return new LinkedHashMap();
    }

    public static final LinkedHashMap linkedMapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        return MapsKt.toMap(arg2, new LinkedHashMap(MapsKt.mapCapacity(arg2.length)));
    }

    public static final Map$Entry mapEntryOf(Object arg1, Object arg2) {
        return new DetachedMapEntry(arg1, arg2);
    }

    public static final Map mapKeys(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        LinkedHashMap v0 = new LinkedHashMap(MapsKt.mapCapacity(arg3.size()));
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            ((Map)v0).put(arg4.invoke(v1), ((Map$Entry)v1).getValue());
        }

        return ((Map)v0);
    }

    @IgnorableReturnValue public static final Map mapKeysTo(Map arg2, Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            arg3.put(arg4.invoke(v0), ((Map$Entry)v0).getValue());
        }

        return arg3;
    }

    private static final Map mapOf() {
        return MapsKt.emptyMap();
    }

    public static final Map mapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        if(arg2.length > 0) {
            return MapsKt.toMap(arg2, new LinkedHashMap(MapsKt.mapCapacity(arg2.length)));
        }

        return MapsKt.emptyMap();
    }

    public static final Map mapValues(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        LinkedHashMap v0 = new LinkedHashMap(MapsKt.mapCapacity(arg3.size()));
        Iterator v3 = arg3.entrySet().iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            ((Map)v0).put(v1.getKey(), arg4.invoke(v1));
        }

        return ((Map)v0);
    }

    @IgnorableReturnValue public static final Map mapValuesTo(Map arg2, Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "transform");
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            arg3.put(v0.getKey(), arg4.invoke(v0));
        }

        return arg3;
    }

    public static final Map minus(Map arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        arg1 = MapsKt.toMutableMap(arg1);
        CollectionsKt.removeAll(arg1.keySet(), arg2);
        return MapsKt.optimizeReadOnlyMap(arg1);
    }

    public static final Map minus(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = MapsKt.toMutableMap(arg1);
        arg1.remove(arg2);
        return MapsKt.optimizeReadOnlyMap(arg1);
    }

    public static final Map minus(Map arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        arg1 = MapsKt.toMutableMap(arg1);
        CollectionsKt.removeAll(arg1.keySet(), arg2);
        return MapsKt.optimizeReadOnlyMap(arg1);
    }

    public static final Map minus(Map arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        arg1 = MapsKt.toMutableMap(arg1);
        CollectionsKt.removeAll(arg1.keySet(), arg2);
        return MapsKt.optimizeReadOnlyMap(arg1);
    }

    private static final void minusAssign(Map arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        CollectionsKt.removeAll(arg1.keySet(), arg2);
    }

    private static final void minusAssign(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.remove(arg2);
    }

    private static final void minusAssign(Map arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        CollectionsKt.removeAll(arg1.keySet(), arg2);
    }

    private static final void minusAssign(Map arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "keys");
        CollectionsKt.removeAll(arg1.keySet(), arg2);
    }

    private static final Iterator mutableIterator(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.entrySet().iterator();
    }

    private static final Map mutableMapOf() {
        return new LinkedHashMap();
    }

    public static final Map mutableMapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        LinkedHashMap v0 = new LinkedHashMap(MapsKt.mapCapacity(arg2.length));
        MapsKt.putAll(((Map)v0), arg2);
        return ((Map)v0);
    }

    public static final Map optimizeReadOnlyMap(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v0 = arg2.size();
        if(v0 != 0) {
            if(v0 != 1) {
                return arg2;
            }

            return MapsKt.toSingletonMap(arg2);
        }

        return MapsKt.emptyMap();
    }

    private static final Map orEmpty(Map arg0) {
        if(arg0 == null) {
            arg0 = MapsKt.emptyMap();
        }

        return arg0;
    }

    public static final Map plus(Map arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        if(arg1.isEmpty()) {
            return MapsKt.toMap(arg2);
        }

        LinkedHashMap v0 = new LinkedHashMap(arg1);
        MapsKt.putAll(((Map)v0), arg2);
        return ((Map)v0);
    }

    public static final Map plus(Map arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "map");
        LinkedHashMap v0 = new LinkedHashMap(arg1);
        v0.putAll(arg2);
        return ((Map)v0);
    }

    public static final Map plus(Map arg1, Pair arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pair");
        if(arg1.isEmpty()) {
            return MapsKt.mapOf(arg2);
        }

        LinkedHashMap v0 = new LinkedHashMap(arg1);
        v0.put(arg2.getFirst(), arg2.getSecond());
        return ((Map)v0);
    }

    public static final Map plus(Map arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        LinkedHashMap v0 = new LinkedHashMap(arg1);
        MapsKt.putAll(((Map)v0), arg2);
        return MapsKt.optimizeReadOnlyMap(((Map)v0));
    }

    public static final Map plus(Map arg1, Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        if(arg1.isEmpty()) {
            return MapsKt.toMap(arg2);
        }

        LinkedHashMap v0 = new LinkedHashMap(arg1);
        MapsKt.putAll(((Map)v0), arg2);
        return ((Map)v0);
    }

    private static final void plusAssign(Map arg1, Iterable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        MapsKt.putAll(arg1, arg2);
    }

    private static final void plusAssign(Map arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "map");
        arg1.putAll(arg2);
    }

    private static final void plusAssign(Map arg1, Pair arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pair");
        arg1.put(arg2.getFirst(), arg2.getSecond());
    }

    private static final void plusAssign(Map arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        MapsKt.putAll(arg1, arg2);
    }

    private static final void plusAssign(Map arg1, Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        MapsKt.putAll(arg1, arg2);
    }

    public static final void putAll(Map arg2, Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "pairs");
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            arg2.put(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public static final void putAll(Map arg2, Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "pairs");
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            Object v0 = v3.next();
            arg2.put(((Pair)v0).component1(), ((Pair)v0).component2());
        }
    }

    public static final void putAll(Map arg4, Pair[] arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "pairs");
        int v0 = arg5.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg4.put(arg5[v1].component1(), arg5[v1].component2());
        }
    }

    @IgnorableReturnValue private static final Object remove(Map arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return TypeIntrinsics.asMutableMap(arg1).remove(arg2);
    }

    private static final void set(Map arg1, Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.put(arg2, arg3);
    }

    public static final Map toMap(Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if((arg3 instanceof Collection)) {
            Iterable v0 = arg3;
            int v1 = ((Collection)v0).size();
            if(v1 != 0) {
                if(v1 != 1) {
                    return MapsKt.toMap(arg3, new LinkedHashMap(MapsKt.mapCapacity(((Collection)v0).size())));
                }

                Object v3 = (arg3 instanceof List) ? ((List)arg3).get(0) : ((Collection)v0).iterator().next();
                return MapsKt.mapOf(((Pair)v3));
            }

            return MapsKt.emptyMap();
        }

        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(arg3, new LinkedHashMap()));
    }

    @IgnorableReturnValue public static final Map toMap(Iterable arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        MapsKt.putAll(arg2, arg1);
        return arg2;
    }

    public static final Map toMap(Map arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v0 = arg2.size();
        if(v0 != 0) {
            if(v0 != 1) {
                return MapsKt.toMutableMap(arg2);
            }

            return MapsKt.toSingletonMap(arg2);
        }

        return MapsKt.emptyMap();
    }

    @IgnorableReturnValue public static final Map toMap(Map arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        arg2.putAll(arg1);
        return arg2;
    }

    public static final Map toMap(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(arg1, new LinkedHashMap()));
    }

    @IgnorableReturnValue public static final Map toMap(Sequence arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        MapsKt.putAll(arg2, arg1);
        return arg2;
    }

    public static final Map toMap(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v0 = arg2.length;
        if(v0 != 0) {
            if(v0 != 1) {
                return MapsKt.toMap(arg2, new LinkedHashMap(MapsKt.mapCapacity(arg2.length)));
            }

            return MapsKt.mapOf(arg2[0]);
        }

        return MapsKt.emptyMap();
    }

    @IgnorableReturnValue public static final Map toMap(Pair[] arg1, Map arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        MapsKt.putAll(arg2, arg1);
        return arg2;
    }

    public static final Map toMutableMap(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new LinkedHashMap(arg1);
    }

    private static final Pair toPair(Map$Entry arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new Pair(arg2.getKey(), arg2.getValue());
    }
}

