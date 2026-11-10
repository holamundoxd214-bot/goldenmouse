package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1={"\u0000¸\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001F\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001AC\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001D\u0010\u0004\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001A2\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\u0087H¢\u0006\u0002\u0010\f\u001AJ\u0010\r\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u00122\u001A\u0010\u0013\u001A\u000E\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0014\"\u0006\u0012\u0002\b\u00030\u0006H\u0001¢\u0006\u0002\u0010\u0015\u001A&\u0010\u0016\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001A(\u0010\u001A\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0018H\u0087@¢\u0006\u0002\u0010\u0019\u001A\u001E\u0010\u001B\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A \u0010\u001D\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A&\u0010\u001E\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001F\u001A\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001A\u001E\u0010!\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A&\u0010\"\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u001F\u001A\u0002H\u0002H\u0087@¢\u0006\u0002\u0010 \u001A \u0010#\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A\u001E\u0010$\u001A\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A \u0010%\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A0\u0010&\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\'\u001A\u00020\u00182\b\b\u0002\u0010(\u001A\u00020)H\u0007\u001AQ\u0010*\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010+\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001AQ\u00101\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010+\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001Af\u00102\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)27\u0010+\u001A3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001AQ\u00105\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010+\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001A$\u00106\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0001\u001A>\u00107\u001A\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001A\u0002H8H\u0087@¢\u0006\u0002\u0010;\u001A<\u00107\u001A\u0002H8\"\b\b\u0000\u0010\u0002*\u00020/\"\u000E\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00062\u0006\u0010:\u001A\u0002H8H\u0087@¢\u0006\u0002\u0010=\u001A0\u0010>\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\'\u001A\u00020\u00182\b\b\u0002\u0010(\u001A\u00020)H\u0007\u001AQ\u0010?\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010+\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001A6\u0010@\u001A\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u00108*\b\u0012\u0004\u0012\u0002H\u00020<*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001A\u0002H8H\u0081@¢\u0006\u0002\u0010=\u001A8\u0010A\u001A\u0002H8\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u00108*\n\u0012\u0006\b\u0000\u0012\u0002H\u000209*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010:\u001A\u0002H8H\u0081@¢\u0006\u0002\u0010;\u001A<\u0010B\u001A\u000E\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0C\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001AR\u0010B\u001A\u0002HG\"\u0004\b\u0000\u0010D\"\u0004\b\u0001\u0010E\"\u0018\b\u0002\u0010G*\u0012\u0012\u0006\b\u0000\u0012\u0002HD\u0012\u0006\b\u0000\u0012\u0002HE0H*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002HD\u0012\u0004\u0012\u0002HE0F0\u00062\u0006\u0010:\u001A\u0002HGH\u0081@¢\u0006\u0002\u0010I\u001A$\u0010J\u001A\b\u0012\u0004\u0012\u0002H\u00020K\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A$\u0010L\u001A\b\u0012\u0004\u0012\u0002H\u00020M\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A]\u0010N\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2(\u0010O\u001A$\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00060-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001AW\u0010P\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010O\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001Al\u0010Q\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)27\u0010O\u001A3\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0001¢\u0006\u0002\u00104\u001Ar\u0010R\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)29\u0010O\u001A5\b\u0001\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/03H\u0007¢\u0006\u0002\u00104\u001A]\u0010S\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020/*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2$\u0010O\u001A \b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0007¢\u0006\u0002\u00100\u001A.\u0010T\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020U0\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)H\u0007\u001A\u001E\u0010V\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0007\u001AW\u0010W\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010D*\b\u0012\u0004\u0012\u0002H\u00020\u00062\b\b\u0002\u0010(\u001A\u00020)2\"\u0010X\u001A\u001E\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002HD0-\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0001¢\u0006\u0002\u00100\u001A$\u0010Y\u001A\b\u0012\u0004\u0012\u0002H\u00020Z\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0081@¢\u0006\u0002\u0010\u001C\u001A\u001E\u0010[\u001A\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A\u001E\u0010\\\u001A\u00020\u0018\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A<\u0010]\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001A\u0010^\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001A<\u0010b\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u001A\u0010^\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020_j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002``H\u0087@¢\u0006\u0002\u0010a\u001A\u001E\u0010c\u001A\u00020.\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u001C\u001A$\u0010d\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0006H\u0007\u001A?\u0010e\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010F0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0087\u0004\u001Az\u0010e\u001A\b\u0012\u0004\u0012\u0002HE0\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010E*\b\u0012\u0004\u0012\u0002H\u00020\u00062\f\u0010f\u001A\b\u0012\u0004\u0012\u0002H\u00010\u00062\b\b\u0002\u0010(\u001A\u00020)26\u0010O\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(g\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(h\u0012\u0004\u0012\u0002HE0,H\u0001\u001A1\u0010i\u001A#\u0012\u0015\u0012\u0013\u0018\u00010\u000E¢\u0006\f\b\u000F\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u0012*\u0006\u0012\u0002\b\u00030\u0006H\u0001¨\u0006j"}, d2={"consume", "R", "E", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumesAll", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "elementAt", "index", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "first", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "single", "singleOrNull", "drop", "n", "context", "Lkotlin/coroutines/CoroutineContext;", "dropWhile", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "K", "V", "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toSet", "", "flatMap", "transform", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "distinct", "distinctBy", "selector", "toMutableSet", "", "any", "count", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "zip", "other", "a", "b", "consumes", "kotlinx-coroutines-core"}, k=5, mv={2, 1, 0}, xi=0x30, xs="kotlinx/coroutines/channels/ChannelsKt") final class ChannelsKt__DeprecatedKt {
    public static Unit $r8$lambda$Pnlf7xJwYiqoh8L1-HZzjr5nMtM(ReceiveChannel[] arg0, Throwable arg1) {
        return ChannelsKt__DeprecatedKt.consumesAll$lambda$2$ChannelsKt__DeprecatedKt(arg0, arg1);
    }

    public static Unit $r8$lambda$TvPjweWNaRxtVDl8g-JDJ7l7UZo(ReceiveChannel arg0, Throwable arg1) {
        return ChannelsKt__DeprecatedKt.consumes$lambda$24$ChannelsKt__DeprecatedKt(arg0, arg1);
    }

    public static Pair $r8$lambda$V4jkZ9F5XaHXoqVWXin7SildXoQ(Object arg0, Object arg1) {
        return ChannelsKt__DeprecatedKt.zip$lambda$23$ChannelsKt__DeprecatedKt(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object any(ReceiveChannel arg4, Continuation arg5) {
        Object v4;
        ChannelsKt__DeprecatedKt$any$1 v0_1;
        int v2;
        if((arg5 instanceof ChannelsKt__DeprecatedKt$any$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$any$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$any$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$any$1(arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            try {
                ChannelIterator v5_2 = arg4.iterator();
                v0_1.L$0 = arg4;
                v0_1.label = 1;
                v5 = v5_2.hasNext(((Continuation)v0_1));
                if(v5 != v1) {
                    goto label_33;
                }
            }
            catch(Throwable v5_1) {
                try {
                label_37:
                    throw v5_1;
                }
                catch(Throwable v0_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v4), v5_1);
                    throw v0_2;
                }
            }

            return v1;
        }
        else if(v2 == 1) {
            v4 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v5);
            }
            catch(Throwable v5_1) {
                goto label_37;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_33:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v4), null);
        return v5;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final Object consume(BroadcastChannel arg2, Function1 arg3) {
        Object v3_1;
        ReceiveChannel v2 = arg2.openSubscription();
        CancellationException v1 = null;
        try {
            v3_1 = arg3.invoke(v2);
        }
        catch(Throwable v3) {
            DefaultImpls.cancel$default(v2, v1, 1, v1);
            throw v3;
        }

        DefaultImpls.cancel$default(v2, v1, 1, v1);
        return v3_1;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") public static final Object consumeEach(BroadcastChannel arg6, Function1 arg7, Continuation arg8) {
        Object v0_2;
        Continuation v5;
        Object v2_1;
        Object v7;
        Object v6;
        ChannelIterator v6_3;
        ReceiveChannel v8_1;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$consumeEach$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$consumeEach$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$consumeEach$1 v0_1 = new ChannelsKt__DeprecatedKt$consumeEach$1(arg8);
        }

        Object v8 = ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).label;
        CancellationException v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            ReceiveChannel v6_2 = arg6.openSubscription();
            try {
                v8_1 = v6_2;
                v6_3 = v6_2.iterator();
                goto label_41;
            }
            catch(Throwable v7_1) {
                Throwable v5_1 = v7_1;
                ChannelIterator v7_2 = v6_3;
                v6_1 = v5_1;
            }

        label_73:
            DefaultImpls.cancel$default(((ReceiveChannel)v7), v3, 1, v3);
            throw v6_1;
            try {
            label_41:
                ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$0 = v7;
                ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$1 = v8_1;
                ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$2 = v6;
                ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).label = 1;
                v2_1 = ((ChannelIterator)v6).hasNext(v0);
                if(v2_1 == v1) {
                }
                else {
                    goto label_48;
                }
            }
            catch(Throwable v6_1) {
                goto label_67;
            }

            return v1;
        label_48:
            v5 = v0;
            ReceiveChannel v0_3 = v8_1;
            v8 = v2_1;
            goto label_27;
        label_67:
            ReceiveChannel v7_3 = v8_1;
            goto label_73;
        }
        else if(v2 == 1) {
            v6 = ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$2;
            v7 = ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$consumeEach$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                v5 = v0;
                v0_2 = v7;
                v7 = v2_1;
            }
            catch(Throwable v6_1) {
                goto label_73;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_27:
        Continuation v2_2 = v5;
        try {
            if(((Boolean)v8).booleanValue()) {
                ((Function1)v7).invoke(((ChannelIterator)v6).next());
                v8 = v0_2;
                v0 = v2_2;
                goto label_41;
            }
        }
        catch(Throwable v6_1) {
            goto label_64;
        }

        DefaultImpls.cancel$default(((ReceiveChannel)v0_2), v3, 1, v3);
        return Unit.INSTANCE;
    label_64:
        v7 = v0_2;
        goto label_73;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported") private static final Object consumeEach$$forInline(BroadcastChannel arg3, Function1 arg4, Continuation arg5) {
        ReceiveChannel v3 = arg3.openSubscription();
        Continuation v0 = null;
        try {
            ChannelIterator v1 = v3.iterator();
            while(v1.hasNext(v0).booleanValue()) {
                arg4.invoke(v1.next());
            }
        }
        catch(Throwable v4) {
            goto label_16;
        }

        DefaultImpls.cancel$default(v3, ((CancellationException)v0), 1, v0);
        return Unit.INSTANCE;
    label_16:
        DefaultImpls.cancel$default(v3, ((CancellationException)v0), 1, v0);
        throw v4;
    }

    public static final Function1 consumes(ReceiveChannel arg1) {
        return new ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda0(arg1);
    }

    private static final Unit consumes$lambda$24$ChannelsKt__DeprecatedKt(ReceiveChannel arg0, Throwable arg1) {
        ChannelsKt.cancelConsumed(arg0, arg1);
        return Unit.INSTANCE;
    }

    public static final Function1 consumesAll(ReceiveChannel[] arg1) {
        return new ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda1(arg1);
    }

    private static final Unit consumesAll$lambda$2$ChannelsKt__DeprecatedKt(ReceiveChannel[] arg4, Throwable arg5) {
        int v0 = arg4.length;
        Throwable v1 = null;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            ReceiveChannel v3 = arg4[v2];
            try {
                ChannelsKt.cancelConsumed(v3, arg5);
            }
            catch(Throwable v3_1) {
                if(v1 == null) {
                    v1 = v3_1;
                    goto label_12;
                }

                ExceptionsKt.addSuppressed(v1, v3_1);
            }

        label_12:
        }

        if(v1 == null) {
            return Unit.INSTANCE;
        }

        throw v1;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object count(ReceiveChannel arg7, Continuation arg8) {
        Object v2_1;
        Object v7;
        ChannelIterator v7_2;
        ReceiveChannel v8_3;
        IntRef v5_1;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$count$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$count$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$count$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$count$1 v0_1 = new ChannelsKt__DeprecatedKt$count$1(arg8);
        }

        Object v8 = ((ChannelsKt__DeprecatedKt$count$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$count$1)v0).label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            IntRef v8_1 = new IntRef();
            try {
                v5_1 = v8_1;
                v8_3 = arg7;
                v7_2 = arg7.iterator();
                goto label_38;
            }
            catch(Throwable v8_2) {
                ChannelIterator v2_2 = v7_2;
                v7_1 = v8_2;
                try {
                label_67:
                    throw v7_1;
                }
                catch(Throwable v8_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v2_2), v7_1);
                    throw v8_2;
                }
            }

            try {
            label_48:
                if(((Boolean)v8).booleanValue()) {
                    ((ChannelIterator)v7).next();
                    ++v5_1.element;
                    v8 = v2_1;
                }
                else {
                    goto label_57;
                }

                goto label_38;
            }
            catch(Throwable v7_1) {
                goto label_26;
            }

        label_57:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v2_1), v3);
            return Boxing.boxInt(v5_1.element);
        }
        else if(v2 == 1) {
            v7 = ((ChannelsKt__DeprecatedKt$count$1)v0).L$2;
            v2_1 = ((ChannelsKt__DeprecatedKt$count$1)v0).L$1;
            Object v5 = ((ChannelsKt__DeprecatedKt$count$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_48;
            }
            catch(Throwable v7_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_38:
            ((ChannelsKt__DeprecatedKt$count$1)v0).L$0 = v5_1;
            ((ChannelsKt__DeprecatedKt$count$1)v0).L$1 = v8_3;
            ((ChannelsKt__DeprecatedKt$count$1)v0).L$2 = v7;
            ((ChannelsKt__DeprecatedKt$count$1)v0).label = 1;
            v2_1 = ((ChannelIterator)v7).hasNext(v0);
            if(v2_1 != v1) {
                goto label_45;
            }
        }
        catch(Throwable v7_1) {
            goto label_62;
        }

        return v1;
    label_45:
        Object v6 = v2_1;
        ReceiveChannel v2_3 = v8_3;
        v8 = v6;
        goto label_48;
    label_62:
        v2_3 = v8_3;
        goto label_67;
    label_26:
        goto label_67;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel distinct(ReceiveChannel arg3) {
        return ChannelsKt.distinctBy$default(arg3, null, new ChannelsKt__DeprecatedKt$distinct$1(null), 1, null);
    }

    public static final ReceiveChannel distinctBy(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$distinctBy$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel distinctBy$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.distinctBy(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel drop(ReceiveChannel arg9, int arg10, CoroutineContext arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg11, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$drop$1(arg10, arg9, null), 6, null);
    }

    public static ReceiveChannel drop$default(ReceiveChannel arg0, int arg1, CoroutineContext arg2, int arg3, Object arg4) {
        CoroutineDispatcher v2;
        if((arg3 & 2) != 0) {
            v2 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.drop(arg0, arg1, ((CoroutineContext)v2));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel dropWhile(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$dropWhile$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel dropWhile$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.dropWhile(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object elementAt(ReceiveChannel arg10, int arg11, Continuation arg12) {
        Object v7;
        Object v2_1;
        int v10;
        Object v10_2;
        int v8;
        ReceiveChannel v7_1;
        ChannelIterator v12_1;
        ChannelsKt__DeprecatedKt$elementAt$1 v0_1;
        int v2;
        if((arg12 instanceof ChannelsKt__DeprecatedKt$elementAt$1)) {
            Continuation v0 = arg12;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$elementAt$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$elementAt$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$elementAt$1(arg12);
        }

        Object v12 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        char v3 = '.';
        Throwable v4 = null;
        String v6 = "ReceiveChannel doesn\'t contain element at index ";
        if(v2 == 0) {
            ResultKt.throwOnFailure(v12);
            if(arg11 >= 0) {
                try {
                    v12_1 = arg10.iterator();
                    v2 = 0;
                    goto label_38;
                label_75:
                    throw new IndexOutOfBoundsException(v6 + arg11 + v3);
                }
                catch(Throwable v11) {
                label_72:
                    v7_1 = arg10;
                    v10_1 = v11;
                    try {
                    label_83:
                        throw v10_1;
                    }
                    catch(Throwable v11) {
                        ChannelsKt.cancelConsumed(((ReceiveChannel)v7), v10_1);
                        throw v11;
                    }
                }
            }
            else {
                goto label_75;
                try {
                label_51:
                    if(((Boolean)v12).booleanValue()) {
                        v12 = ((ChannelIterator)v2_1).next();
                        v8 = v10 + 1;
                        if(arg11 == v10) {
                            goto label_56;
                        }
                        else {
                            goto label_58;
                        }
                    }
                    else {
                        goto label_62;
                    }

                    goto label_38;
                }
                catch(Throwable v10_1) {
                    goto label_29;
                }

            label_56:
                ChannelsKt.cancelConsumed(((ReceiveChannel)v7), v4);
                return v12;
            label_58:
                v12 = v2_1;
                v10_2 = v7;
                v2 = v8;
                goto label_38;
                try {
                label_62:
                    throw new IndexOutOfBoundsException(v6 + arg11 + v3);
                }
                catch(Throwable v10_1) {
                    goto label_29;
                }
            }
        }
        else if(v2 == 1) {
            v10 = v0_1.I$1;
            arg11 = v0_1.I$0;
            v2_1 = v0_1.L$1;
            v7 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v12);
                goto label_51;
            }
            catch(Throwable v10_1) {
                goto label_29;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_38:
            v0_1.L$0 = v10_2;
            v0_1.L$1 = v12_1;
            v0_1.I$0 = arg11;
            v0_1.I$1 = v2;
            v0_1.label = 1;
            v7 = v12_1.hasNext(((Continuation)v0_1));
            if(v7 != v1) {
                goto label_46;
            }
        }
        catch(Throwable v11) {
            goto label_72;
        }

        return v1;
    label_46:
        Object v9 = v7;
        v7_1 = ((ReceiveChannel)v10_2);
        v10 = v2;
        ChannelIterator v2_2 = v12_1;
        v12 = v9;
        goto label_51;
    label_29:
        goto label_83;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object elementAtOrNull(ReceiveChannel arg9, int arg10, Continuation arg11) {
        Throwable v6_1;
        Object v0_2;
        Continuation v5_1;
        Object v9_2;
        Object v6;
        int v7;
        Throwable v5_2;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 v0_1;
        int v2;
        Continuation v0;
        if((arg11 instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1)) {
            v0 = arg11;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$elementAtOrNull$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$elementAtOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(arg11);
        }

        Object v11 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Throwable v4 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v11);
            if(arg10 < 0) {
                ChannelsKt.cancelConsumed(arg9, v4);
                return v4;
            }
            else {
                try {
                    ChannelIterator v11_1 = arg9.iterator();
                    v2 = 0;
                    v5_2 = v4;
                    goto label_45;
                }
                catch(Throwable v10) {
                    goto label_73;
                }

                try {
                label_75:
                    throw v9_1;
                }
                catch(Throwable v10) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v5_1), v9_1);
                    throw v10;
                }

            label_73:
                ReceiveChannel v5_3 = ((ReceiveChannel)v9_2);
                v9_1 = v10;
                goto label_75;
                try {
                label_58:
                    if(((Boolean)v11).booleanValue()) {
                        v11 = ((ChannelIterator)v0_2).next();
                        v7 = v2 + 1;
                        if(arg10 == v2) {
                            goto label_63;
                        }
                        else {
                            goto label_65;
                        }
                    }
                    else {
                        goto label_70;
                    }

                    goto label_45;
                }
                catch(Throwable v10) {
                    goto label_73;
                }

            label_63:
                ChannelsKt.cancelConsumed(((ReceiveChannel)v9_2), v6_1);
                return v11;
            label_65:
                v11 = v0_2;
                v0 = v5_1;
                v5_2 = v6_1;
                v2 = v7;
                goto label_45;
            label_70:
                ChannelsKt.cancelConsumed(((ReceiveChannel)v9_2), v6_1);
                return v4;
            }
        }
        else if(v2 == 1) {
            int v9 = v0_1.I$1;
            arg10 = v0_1.I$0;
            Object v2_1 = v0_1.L$1;
            Object v5 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v11);
                v6 = v2_1;
                v2 = v9;
                v9_2 = v5;
                v5_1 = ((Continuation)v0_1);
                v0_2 = v6;
                v6_1 = v4;
                goto label_58;
            }
            catch(Throwable v9_1) {
                goto label_75;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_45:
            v0_1.L$0 = v9_2;
            v0_1.L$1 = v11;
            v0_1.I$0 = arg10;
            v0_1.I$1 = v2;
            v0_1.label = 1;
            v6 = ((ChannelIterator)v11).hasNext(((Continuation)v0_1));
            if(v6 == v1) {
                return v1;
            }

            Continuation v8 = ((Continuation)v0_1);
            ChannelIterator v0_3 = ((ChannelIterator)v11);
            v11 = v6;
            v6_1 = v5_2;
            v5_1 = v8;
            goto label_58;
        }
        catch(Throwable v10) {
            goto label_73;
        }
    }

    public static final ReceiveChannel filter(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$filter$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel filter$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.filter(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel filterIndexed(ReceiveChannel arg9, CoroutineContext arg10, Function3 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$filterIndexed$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel filterIndexed$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.filterIndexed(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel filterNot(ReceiveChannel arg2, CoroutineContext arg3, Function2 arg4) {
        return ChannelsKt.filter(arg2, arg3, new ChannelsKt__DeprecatedKt$filterNot$1(arg4, null));
    }

    public static ReceiveChannel filterNot$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.filterNot(arg0, ((CoroutineContext)v1), arg2);
    }

    public static final ReceiveChannel filterNotNull(ReceiveChannel arg3) {
        arg3 = ChannelsKt.filter$default(arg3, null, new ChannelsKt__DeprecatedKt$filterNotNull$1(null), 1, null);
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return arg3;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object filterNotNullTo(ReceiveChannel arg6, Collection arg7, Continuation arg8) {
        Object v2_1;
        Collection v8_1;
        ChannelIterator v6_2;
        ReceiveChannel v7_2;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$filterNotNullTo$1 v0_1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(arg8);
        }

        Object v8 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                Collection v5 = arg7;
                v7_2 = arg6;
                v6_2 = arg6.iterator();
                v8_1 = v5;
                goto label_37;
            }
            catch(Throwable v7_1) {
                Throwable v5_1 = v7_1;
                ChannelIterator v7_3 = v6_2;
                v6_1 = v5_1;
                try {
                label_61:
                    throw v6_1;
                }
                catch(Throwable v8_2) {
                    ChannelsKt.cancelConsumed(v7_2, v6_1);
                    throw v8_2;
                }
            }

            try {
            label_47:
                if(((Boolean)v8).booleanValue()) {
                    v8 = v6_2.next();
                    if(v8 != null) {
                        ((Collection)v2_1).add(v8);
                    }

                    v8 = v2_1;
                }
                else {
                    goto label_55;
                }

                goto label_37;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }

        label_55:
            ChannelsKt.cancelConsumed(v7_2, v3);
            return v2_1;
        }
        else if(v2 == 1) {
            Object v6 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$2;
            Object v7 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_47;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_37:
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$0 = v8_1;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$1 = v7_2;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).L$2 = v6_2;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$1)v0).label = 1;
            v2_1 = v6_2.hasNext(v0);
            if(v2_1 == v1) {
                return v1;
            }

            Object v5_2 = v2_1;
            Collection v2_2 = v8_1;
            v8 = v5_2;
            goto label_47;
        }
        catch(Throwable v6_1) {
        label_26:
            goto label_61;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object filterNotNullTo(ReceiveChannel arg7, SendChannel arg8, Continuation arg9) {
        Object v2_1;
        Object v8;
        Object v7;
        ReceiveChannel v8_2;
        ChannelIterator v9_1;
        int v2;
        Continuation v0;
        if((arg9 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$filterNotNullTo$3 v0_1 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(arg9);
        }

        Object v9 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            try {
                v9_1 = arg7.iterator();
                goto label_40;
            }
            catch(Throwable v8_1) {
            label_71:
                Throwable v6 = v8_1;
                v8_2 = arg7;
                v7_1 = v6;
                try {
                label_74:
                    throw v7_1;
                }
                catch(Throwable v9_2) {
                    ChannelsKt.cancelConsumed(v8_2, v7_1);
                    throw v9_2;
                }
            }

            try {
            label_63:
                v9 = v7;
                v7 = v8;
                v8 = v2_1;
                goto label_40;
            label_52:
                if(((Boolean)v9).booleanValue()) {
                    v9 = ((ChannelIterator)v7).next();
                    if(v9 == null) {
                        goto label_63;
                    }

                    ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$0 = v2_1;
                    ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$1 = v8;
                    ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$2 = v7;
                    ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).label = v3;
                    if(((SendChannel)v2_1).send(v9, v0) != v1) {
                        goto label_63;
                    }

                    return v1;
                }
                else {
                }
            }
            catch(Throwable v7_1) {
                goto label_37;
            }

            ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v5);
            return v2_1;
        }
        else if(v2 == 1) {
            v7 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$2;
            v8 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_52;
            }
            catch(Throwable v7_1) {
                goto label_37;
            }
        }
        else if(v2 == v3) {
            v7 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$2;
            v8 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_63;
            }
            catch(Throwable v7_1) {
                goto label_37;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_40:
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$0 = v8;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$1 = v7;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).L$2 = v9_1;
            ((ChannelsKt__DeprecatedKt$filterNotNullTo$3)v0).label = 1;
            v2_1 = v9_1.hasNext(v0);
            if(v2_1 != v1) {
                goto label_47;
            }
        }
        catch(Throwable v8_1) {
            goto label_71;
        }

        return v1;
    label_47:
        SendChannel v6_1 = ((SendChannel)v8);
        v8_2 = ((ReceiveChannel)v7);
        ChannelIterator v7_2 = v9_1;
        v9 = v2_1;
        SendChannel v2_2 = v6_1;
        goto label_52;
    label_37:
        goto label_74;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object first(ReceiveChannel arg5, Continuation arg6) {
        Object v0_2;
        Object v5;
        ChannelIterator v5_2;
        ReceiveChannel v0_3;
        ChannelIterator v6_2;
        ChannelsKt__DeprecatedKt$first$1 v0_1;
        int v2;
        if((arg6 instanceof ChannelsKt__DeprecatedKt$first$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$first$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$first$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$first$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                v6_2 = arg5.iterator();
                v0_1.L$0 = arg5;
                v0_1.L$1 = v6_2;
                v0_1.label = 1;
                v0_2 = v6_2.hasNext(((Continuation)v0_1));
                if(v0_2 != v1) {
                    goto label_37;
                }
            }
            catch(Throwable v6_1) {
                v0_3 = arg5;
                v5_1 = v6_1;
                goto label_54;
            }

            return v1;
        label_37:
            Object v4 = v0_2;
            v0_3 = arg5;
            v5_2 = v6_2;
            v6 = v4;
        }
        else if(v2 == 1) {
            v5 = v0_1.L$1;
            v0_2 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v5_1) {
                goto label_24;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            if(!((Boolean)v6).booleanValue()) {
                goto label_47;
            }

            v5 = v5_2.next();
        }
        catch(Throwable v5_1) {
            goto label_24;
        }

        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), null);
        return v5;
        try {
        label_47:
            throw new NoSuchElementException("ReceiveChannel is empty.");
        }
        catch(Throwable v5_1) {
        label_24:
        }

        try {
        label_54:
            throw v5_1;
        }
        catch(Throwable v6_1) {
            ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v5_1);
            throw v6_1;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object firstOrNull(ReceiveChannel arg5, Continuation arg6) {
        Throwable v1_1;
        Object v0_2;
        Object v5;
        ChannelIterator v5_2;
        ReceiveChannel v0_3;
        ChannelIterator v6_2;
        ChannelsKt__DeprecatedKt$firstOrNull$1 v0_1;
        int v2;
        if((arg6 instanceof ChannelsKt__DeprecatedKt$firstOrNull$1)) {
            Continuation v0 = arg6;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$firstOrNull$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$firstOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$firstOrNull$1(arg6);
        }

        Object v6 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v6);
            try {
                v6_2 = arg5.iterator();
                v0_1.L$0 = arg5;
                v0_1.L$1 = v6_2;
                v0_1.label = 1;
                v0_2 = v6_2.hasNext(((Continuation)v0_1));
                if(v0_2 != v1) {
                    goto label_37;
                }
            }
            catch(Throwable v6_1) {
                v0_3 = arg5;
                v5_1 = v6_1;
                goto label_52;
            }

            return v1;
        label_37:
            Object v4 = v0_2;
            v0_3 = arg5;
            v5_2 = v6_2;
            v6 = v4;
        }
        else if(v2 == 1) {
            v5 = v0_1.L$1;
            v0_2 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v6);
            }
            catch(Throwable v5_1) {
                goto label_24;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            v1_1 = null;
            if(((Boolean)v6).booleanValue()) {
                goto label_46;
            }
        }
        catch(Throwable v5_1) {
            goto label_24;
        }

        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v1_1);
        return v1_1;
        try {
        label_46:
            v5 = v5_2.next();
            goto label_47;
        }
        catch(Throwable v5_1) {
        label_24:
        }

        try {
        label_52:
            throw v5_1;
        }
        catch(Throwable v6_1) {
            ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v5_1);
            throw v6_1;
        }

    label_47:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v1_1);
        return v5;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel flatMap(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$flatMap$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel flatMap$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.flatMap(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object indexOf(ReceiveChannel arg7, Object arg8, Continuation arg9) {
        Object v5;
        Object v2_1;
        Object v7;
        Integer v7_3;
        ChannelIterator v7_2;
        ReceiveChannel v8_1;
        Object v6;
        ChannelsKt__DeprecatedKt$indexOf$1 v0_1;
        int v2;
        if((arg9 instanceof ChannelsKt__DeprecatedKt$indexOf$1)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$indexOf$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$indexOf$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$indexOf$1(arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            IntRef v9_1 = new IntRef();
            try {
                v6 = arg8;
                v8_1 = arg7;
                v7_2 = arg7.iterator();
                IntRef v2_2 = v9_1;
                v9 = v6;
                goto label_41;
            }
            catch(Throwable v8) {
                Throwable v6_1 = v8;
                ChannelIterator v8_2 = v7_2;
                v7_1 = v6_1;
                try {
                label_75:
                    throw v7_1;
                }
                catch(Throwable v9_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v8_2), v7_1);
                    throw v9_2;
                }
            }

            try {
            label_52:
                if(!((Boolean)v9).booleanValue()) {
                    goto label_66;
                }
                else if(Intrinsics.areEqual(v5, ((ChannelIterator)v7).next())) {
                    v7_3 = Boxing.boxInt(((IntRef)v2_1).element);
                }
                else {
                    goto label_61;
                }
            }
            catch(Throwable v7_1) {
                goto label_27;
            }

            ChannelsKt.cancelConsumed(v8_1, v3);
            return v7_3;
            try {
            label_61:
                ++((IntRef)v2_1).element;
                v9 = v5;
                goto label_41;
            label_66:
            }
            catch(Throwable v7_1) {
                goto label_27;
            }

            ChannelsKt.cancelConsumed(v8_1, v3);
            return Boxing.boxInt(-1);
        }
        else if(v2 == 1) {
            v7 = v0_1.L$3;
            arg8 = v0_1.L$2;
            v2_1 = v0_1.L$1;
            v5 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_52;
            }
            catch(Throwable v7_1) {
                goto label_27;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_41:
            v0_1.L$0 = v9;
            v0_1.L$1 = v2_1;
            v0_1.L$2 = v8_1;
            v0_1.L$3 = v7;
            v0_1.label = 1;
            v5 = ((ChannelIterator)v7).hasNext(((Continuation)v0_1));
            if(v5 == v1) {
                return v1;
            }

            v6 = v5;
            v5 = v9;
            v9 = v6;
            goto label_52;
        }
        catch(Throwable v7_1) {
        label_27:
            goto label_75;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object last(ReceiveChannel arg7, Continuation arg8) {
        Object v4;
        Object v2_1;
        Object v7;
        Object v6;
        ChannelIterator v8_2;
        ChannelsKt__DeprecatedKt$last$1 v0_1;
        int v2;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$last$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$last$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$last$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$last$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                v8_2 = arg7.iterator();
                v0_1.L$0 = arg7;
                v0_1.L$1 = v8_2;
                v0_1.label = 1;
                v2_1 = v8_2.hasNext(((Continuation)v0_1));
                if(v2_1 == v1) {
                }
                else {
                    goto label_48;
                }
            }
            catch(Throwable v8_1) {
                goto label_81;
            }

            return v1;
        label_48:
            v6 = v2_1;
            ReceiveChannel v2_2 = arg7;
            ChannelIterator v7_2 = v8_2;
            v8 = v6;
            try {
            label_52:
                if(((Boolean)v8).booleanValue()) {
                    v8 = ((ChannelIterator)v7).next();
                    v6 = v2_2;
                    v2_1 = v7;
                    v7 = v6;
                }
                else {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }

                goto label_58;
            }
            catch(Throwable v7_1) {
            label_39:
                try {
                label_83:
                    throw v7_1;
                }
                catch(Throwable v8_1) {
                    ChannelsKt.cancelConsumed(v2_2, v7_1);
                    throw v8_1;
                }
            }

        label_81:
            v2_2 = ((ReceiveChannel)v7);
            v7_1 = v8_1;
            goto label_83;
            try {
            label_69:
                if(((Boolean)v8).booleanValue()) {
                    v8 = ((ChannelIterator)v2_1).next();
                    v7 = v4;
                }
                else {
                    goto label_74;
                }

                goto label_58;
            }
            catch(Throwable v7_1) {
                goto label_28;
            }

        label_74:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v4), v5);
            return v7;
        }
        else if(v2 == 1) {
            v7 = v0_1.L$1;
            v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_52;
            }
            catch(Throwable v7_1) {
                goto label_39;
            }
        }
        else if(v2 == v3) {
            v7 = v0_1.L$2;
            v2_1 = v0_1.L$1;
            v4 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_69;
            }
            catch(Throwable v7_1) {
                goto label_28;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_58:
            v0_1.L$0 = v7;
            v0_1.L$1 = v2_1;
            v0_1.L$2 = v8;
            v0_1.label = v3;
            v4 = ((ChannelIterator)v2_1).hasNext(((Continuation)v0_1));
            if(v4 != v1) {
                goto label_65;
            }

            return v1;
        }
        catch(Throwable v8_1) {
            goto label_81;
        }

    label_65:
        v6 = v4;
        v4 = v7;
        v7 = v8;
        v8 = v6;
        goto label_69;
    label_28:
        v2_1 = v4;
        goto label_83;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object lastIndexOf(ReceiveChannel arg8, Object arg9, Continuation arg10) {
        Object v6;
        Object v8;
        IntRef v5_1;
        ChannelIterator v8_2;
        Object v7;
        IntRef v2_2;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 v0_1;
        int v2;
        if((arg10 instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1)) {
            Continuation v0 = arg10;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$lastIndexOf$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$lastIndexOf$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(arg10);
        }

        Object v10 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            IntRef v10_1 = new IntRef();
            v10_1.element = -1;
            v2_2 = new IntRef();
            try {
                v7 = arg9;
                ReceiveChannel v9_1 = arg8;
                v8_2 = arg8.iterator();
                v5_1 = v10_1;
                v10 = v7;
                goto label_46;
            }
            catch(Throwable v9) {
                Throwable v7_1 = v9;
                ChannelIterator v9_2 = v8_2;
                v8_1 = v7_1;
                try {
                label_79:
                    throw v8_1;
                }
                catch(Throwable v10_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v9_2), v8_1);
                    throw v10_2;
                }
            }

            try {
            label_58:
                if(((Boolean)v10).booleanValue()) {
                    if(Intrinsics.areEqual(v6, ((ChannelIterator)v8).next())) {
                        v5_1.element = v2_2.element;
                    }

                    ++v2_2.element;
                    v10 = v6;
                }
                else {
                    goto label_71;
                }

                goto label_46;
            }
            catch(Throwable v8_1) {
                goto label_28;
            }

        label_71:
            ChannelsKt.cancelConsumed(((ReceiveChannel)arg9), v3);
            return Boxing.boxInt(v5_1.element);
        }
        else if(v2 == 1) {
            v8 = v0_1.L$4;
            arg9 = v0_1.L$3;
            Object v2_1 = v0_1.L$2;
            Object v5 = v0_1.L$1;
            v6 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_58;
            }
            catch(Throwable v8_1) {
                goto label_28;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_46:
            v0_1.L$0 = v10;
            v0_1.L$1 = v5_1;
            v0_1.L$2 = v2_2;
            v0_1.L$3 = arg9;
            v0_1.L$4 = v8;
            v0_1.label = 1;
            v6 = ((ChannelIterator)v8).hasNext(((Continuation)v0_1));
            if(v6 == v1) {
                return v1;
            }

            v7 = v6;
            v6 = v10;
            v10 = v7;
            goto label_58;
        }
        catch(Throwable v8_1) {
        label_28:
            goto label_79;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object lastOrNull(ReceiveChannel arg7, Continuation arg8) {
        Object v4;
        Object v2_1;
        Object v7;
        Object v6;
        ChannelIterator v8_2;
        ChannelsKt__DeprecatedKt$lastOrNull$1 v0_1;
        int v2;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$lastOrNull$1)) {
            Continuation v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$lastOrNull$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$lastOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$lastOrNull$1(arg8);
        }

        Object v8 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                v8_2 = arg7.iterator();
                v0_1.L$0 = arg7;
                v0_1.L$1 = v8_2;
                v0_1.label = 1;
                v2_1 = v8_2.hasNext(((Continuation)v0_1));
                if(v2_1 == v1) {
                }
                else {
                    goto label_48;
                }
            }
            catch(Throwable v8_1) {
                goto label_79;
            }

            return v1;
        label_48:
            v6 = v2_1;
            ReceiveChannel v2_2 = arg7;
            ChannelIterator v7_2 = v8_2;
            v8 = v6;
            try {
            label_52:
                if(!((Boolean)v8).booleanValue()) {
                }
                else {
                    goto label_56;
                }
            }
            catch(Throwable v7_1) {
                goto label_39;
            }

            ChannelsKt.cancelConsumed(((ReceiveChannel)v2_1), v5);
            return v5;
            try {
            label_56:
                v8 = v7_2.next();
                v6 = v2_1;
                v2_1 = v7_2;
                v7 = v6;
                goto label_60;
            }
            catch(Throwable v7_1) {
            label_39:
                try {
                label_81:
                    throw v7_1;
                }
                catch(Throwable v8_1) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v2_1), v7_1);
                    throw v8_1;
                }
            }

        label_79:
            v2_2 = ((ReceiveChannel)v7);
            v7_1 = v8_1;
            goto label_81;
            try {
            label_71:
                if(((Boolean)v8).booleanValue()) {
                    v8 = ((ChannelIterator)v2_1).next();
                    v7 = v4;
                }
                else {
                    goto label_76;
                }

                goto label_60;
            }
            catch(Throwable v7_1) {
                goto label_28;
            }

        label_76:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v4), v5);
            return v7;
        }
        else if(v2 == 1) {
            v7 = v0_1.L$1;
            v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_52;
            }
            catch(Throwable v7_1) {
                goto label_39;
            }
        }
        else if(v2 == v3) {
            v7 = v0_1.L$2;
            v2_1 = v0_1.L$1;
            v4 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_71;
            }
            catch(Throwable v7_1) {
                goto label_28;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_60:
            v0_1.L$0 = v7;
            v0_1.L$1 = v2_1;
            v0_1.L$2 = v8;
            v0_1.label = v3;
            v4 = ((ChannelIterator)v2_1).hasNext(((Continuation)v0_1));
            if(v4 != v1) {
                goto label_67;
            }

            return v1;
        }
        catch(Throwable v8_1) {
            goto label_79;
        }

    label_67:
        v6 = v4;
        v4 = v7;
        v7 = v8;
        v8 = v6;
        goto label_71;
    label_28:
        v2_1 = v4;
        goto label_81;
    }

    public static final ReceiveChannel map(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$map$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel map$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.map(arg0, ((CoroutineContext)v1), arg2);
    }

    public static final ReceiveChannel mapIndexed(ReceiveChannel arg9, CoroutineContext arg10, Function3 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$mapIndexed$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel mapIndexed$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.mapIndexed(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel mapIndexedNotNull(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(arg0, arg1, arg2));
    }

    public static ReceiveChannel mapIndexedNotNull$default(ReceiveChannel arg0, CoroutineContext arg1, Function3 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.mapIndexedNotNull(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel mapNotNull(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2) {
        return ChannelsKt.filterNotNull(ChannelsKt.map(arg0, arg1, arg2));
    }

    public static ReceiveChannel mapNotNull$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.mapNotNull(arg0, ((CoroutineContext)v1), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object maxWith(ReceiveChannel arg8, Comparator arg9, Continuation arg10) {
        Object v0_2;
        Continuation v7;
        Object v4;
        Object v2_1;
        Object v9;
        Object v8;
        ChannelIterator v10_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof ChannelsKt__DeprecatedKt$maxWith$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$maxWith$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$maxWith$1 v0_1 = new ChannelsKt__DeprecatedKt$maxWith$1(arg10);
        }

        Object v10 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            try {
                v10_1 = arg8.iterator();
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$0 = arg9;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$1 = arg8;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$2 = v10_1;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).label = 1;
                v2_1 = v10_1.hasNext(v0);
                if(v2_1 == v1) {
                }
                else {
                    goto label_55;
                }
            }
            catch(Throwable v9_1) {
                goto label_93;
            }

            return v1;
        label_55:
            Comparator v7_1 = arg9;
            ReceiveChannel v9_2 = arg8;
            ChannelIterator v8_2 = v10_1;
            v10 = v2_1;
            Comparator v2_2 = v7_1;
            try {
            label_60:
                if(!((Boolean)v10).booleanValue()) {
                }
                else {
                    goto label_64;
                }
            }
            catch(Throwable v8_1) {
                goto label_45;
            }

            ChannelsKt.cancelConsumed(((ReceiveChannel)v9), v5);
            return v5;
            try {
            label_64:
                v10 = ((ChannelIterator)v8).next();
                v4 = v9;
                v9 = v8;
                v8 = v4;
                v4 = v2_1;
                goto label_69;
            }
            catch(Throwable v8_1) {
            label_45:
            }

            try {
            label_96:
                throw v8_1;
            }
            catch(Throwable v10_2) {
                ChannelsKt.cancelConsumed(((ReceiveChannel)v9), v8_1);
                throw v10_2;
            }

        label_93:
            Throwable v7_2 = v9_1;
            v9_2 = ((ReceiveChannel)v8);
            v8_1 = v7_2;
            goto label_96;
            try {
                return v1;
            label_69:
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$0 = v4;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$1 = v8;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$2 = v9;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$3 = v10;
                ((ChannelsKt__DeprecatedKt$maxWith$1)v0).label = v3;
                v2_1 = ((ChannelIterator)v9).hasNext(v0);
                if(v2_1 == v1) {
                    return v1;
                }

                v7 = v0;
                v0_2 = v10;
                v10 = v2_1;
            }
            catch(Throwable v9_1) {
                goto label_93;
            }
        }
        else if(v2 == 1) {
            v8 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$2;
            v9 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_60;
            }
            catch(Throwable v8_1) {
                goto label_45;
            }
        }
        else if(v2 == v3) {
            v8 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$3;
            v9 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$2;
            v2_1 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$1;
            v4 = ((ChannelsKt__DeprecatedKt$maxWith$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                v7 = v0;
                v0_2 = v8;
                v8 = v2_1;
            }
            catch(Throwable v8_1) {
                v9 = v2_1;
                goto label_96;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        Continuation v2_3 = v7;
        try {
            if(!((Boolean)v10).booleanValue()) {
                goto label_90;
            }

            v10 = ((ChannelIterator)v9).next();
            if(((Comparator)v4).compare(v0_2, v10) < 0) {
            }
            else {
                goto label_87;
            }
        }
        catch(Throwable v9_1) {
            goto label_93;
        }

        goto label_88;
    label_87:
        v10 = v0_2;
    label_88:
        v0 = v2_3;
        goto label_69;
    label_90:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v5);
        return v0_2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object minWith(ReceiveChannel arg8, Comparator arg9, Continuation arg10) {
        Object v0_2;
        Continuation v7;
        Object v4;
        Object v2_1;
        Object v9;
        Object v8;
        ChannelIterator v10_1;
        int v2;
        Continuation v0;
        if((arg10 instanceof ChannelsKt__DeprecatedKt$minWith$1)) {
            v0 = arg10;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$minWith$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$minWith$1 v0_1 = new ChannelsKt__DeprecatedKt$minWith$1(arg10);
        }

        Object v10 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v10);
            try {
                v10_1 = arg8.iterator();
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$0 = arg9;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$1 = arg8;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$2 = v10_1;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).label = 1;
                v2_1 = v10_1.hasNext(v0);
                if(v2_1 == v1) {
                }
                else {
                    goto label_55;
                }
            }
            catch(Throwable v9_1) {
                goto label_93;
            }

            return v1;
        label_55:
            Comparator v7_1 = arg9;
            ReceiveChannel v9_2 = arg8;
            ChannelIterator v8_2 = v10_1;
            v10 = v2_1;
            Comparator v2_2 = v7_1;
            try {
            label_60:
                if(!((Boolean)v10).booleanValue()) {
                }
                else {
                    goto label_64;
                }
            }
            catch(Throwable v8_1) {
                goto label_45;
            }

            ChannelsKt.cancelConsumed(v9_2, v5);
            return v5;
            try {
            label_64:
                v10 = ((ChannelIterator)v8).next();
                v4 = v9_2;
                v9 = v8;
                v8 = v4;
                v4 = v2_2;
                goto label_69;
            }
            catch(Throwable v8_1) {
            label_45:
            }

            try {
            label_96:
                throw v8_1;
            }
            catch(Throwable v10_2) {
                ChannelsKt.cancelConsumed(v9_2, v8_1);
                throw v10_2;
            }

        label_93:
            Throwable v7_2 = v9_1;
            v9_2 = ((ReceiveChannel)v8);
            v8_1 = v7_2;
            goto label_96;
            try {
                return v1;
            label_69:
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$0 = v4;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$1 = v8;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$2 = v9;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$3 = v10;
                ((ChannelsKt__DeprecatedKt$minWith$1)v0).label = v3;
                v2_1 = ((ChannelIterator)v9).hasNext(v0);
                if(v2_1 == v1) {
                    return v1;
                }

                v7 = v0;
                v0_2 = v10;
                v10 = v2_1;
            }
            catch(Throwable v9_1) {
                goto label_93;
            }
        }
        else if(v2 == 1) {
            v8 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$2;
            v9 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                goto label_60;
            }
            catch(Throwable v8_1) {
                goto label_45;
            }
        }
        else if(v2 == v3) {
            v8 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$3;
            v9 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$2;
            v2_1 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$1;
            v4 = ((ChannelsKt__DeprecatedKt$minWith$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v10);
                v7 = v0;
                v0_2 = v8;
                v8 = v2_1;
            }
            catch(Throwable v8_1) {
                v9 = v2_1;
                goto label_96;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        Continuation v2_3 = v7;
        try {
            if(!((Boolean)v10).booleanValue()) {
                goto label_90;
            }

            v10 = ((ChannelIterator)v9).next();
            if(((Comparator)v4).compare(v0_2, v10) > 0) {
            }
            else {
                goto label_87;
            }
        }
        catch(Throwable v9_1) {
            goto label_93;
        }

        goto label_88;
    label_87:
        v10 = v0_2;
    label_88:
        v0 = v2_3;
        goto label_69;
    label_90:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v5);
        return v0_2;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object none(ReceiveChannel arg4, Continuation arg5) {
        Object v4;
        Boolean v5_3;
        ChannelsKt__DeprecatedKt$none$1 v0_1;
        int v2;
        if((arg5 instanceof ChannelsKt__DeprecatedKt$none$1)) {
            Continuation v0 = arg5;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$none$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$none$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$none$1(arg5);
        }

        Object v5 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v5);
            try {
                ChannelIterator v5_2 = arg4.iterator();
                v0_1.L$0 = arg4;
                v0_1.label = 1;
                v5 = v5_2.hasNext(((Continuation)v0_1));
                if(v5 == v1) {
                    return v1;
                }

            label_33:
                v5_3 = Boxing.boxBoolean(((Boolean)v5).booleanValue() ^ 1);
                goto label_36;
            }
            catch(Throwable v5_1) {
                try {
                label_40:
                    throw v5_1;
                }
                catch(Throwable v0_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v4), v5_1);
                    throw v0_2;
                }
            }
        }
        else if(v2 == 1) {
            v4 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v5);
                goto label_33;
            }
            catch(Throwable v5_1) {
                goto label_40;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        goto label_33;
    label_36:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v4), null);
        return v5_3;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Left for binary compatibility") public static final ReceiveChannel requireNoNulls(ReceiveChannel arg3) {
        return ChannelsKt.map$default(arg3, null, new ChannelsKt__DeprecatedKt$requireNoNulls$1(arg3, null), 1, null);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object single(ReceiveChannel arg6, Continuation arg7) {
        Object v0_2;
        Object v6;
        Object v2_1;
        ReceiveChannel v2_2;
        ChannelIterator v7_2;
        ChannelsKt__DeprecatedKt$single$1 v0_1;
        int v2;
        if((arg7 instanceof ChannelsKt__DeprecatedKt$single$1)) {
            Continuation v0 = arg7;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$single$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$single$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$single$1(arg7);
        }

        Object v7 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        int v3 = 2;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v7);
            try {
                v7_2 = arg6.iterator();
                v0_1.L$0 = arg6;
                v0_1.L$1 = v7_2;
                v0_1.label = 1;
                v2_1 = v7_2.hasNext(((Continuation)v0_1));
                if(v2_1 != v1) {
                    goto label_46;
                }
            }
            catch(Throwable v7_1) {
                v2_2 = arg6;
                v6_1 = v7_1;
                goto label_79;
            }

            return v1;
        label_46:
            Object v5 = v2_1;
            v2_2 = arg6;
            ChannelIterator v6_2 = v7_2;
            v7 = v5;
            try {
            label_50:
                if(((Boolean)v7).booleanValue()) {
                    v7 = v6_2.next();
                    v0_1.L$0 = v2_1;
                    v0_1.L$1 = v7;
                    v0_1.label = v3;
                    v6 = v6_2.hasNext(((Continuation)v0_1));
                    if(v6 == v1) {
                        return v1;
                    }
                    else {
                        goto label_59;
                    }
                }
                else {
                    goto label_72;
                }

                goto label_63;
            }
            catch(Throwable v6_1) {
                goto label_37;
            }

            return v1;
        label_59:
            v0_2 = v7;
            v7 = v6;
            v6 = v0_2;
            v0_2 = v2_1;
        }
        else if(v2 == 1) {
            v6 = v0_1.L$1;
            v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v7);
                goto label_50;
            }
            catch(Throwable v6_1) {
                goto label_37;
            }
        }
        else if(v2 == v3) {
            v6 = v0_1.L$1;
            v0_2 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v7);
            }
            catch(Throwable v6_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_63:
            if(((Boolean)v7).booleanValue()) {
                goto label_68;
            }
        }
        catch(Throwable v6_1) {
            goto label_26;
        }

        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), null);
        return v6;
        try {
        label_68:
            throw new IllegalArgumentException("ReceiveChannel has more than one element.");
        }
        catch(Throwable v6_1) {
        label_26:
            v2_1 = v0_2;
            goto label_79;
        }

        try {
        label_72:
            throw new NoSuchElementException("ReceiveChannel is empty.");
        }
        catch(Throwable v6_1) {
        label_37:
        }

        try {
        label_79:
            throw v6_1;
        }
        catch(Throwable v7_1) {
            ChannelsKt.cancelConsumed(((ReceiveChannel)v2_1), v6_1);
            throw v7_1;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object singleOrNull(ReceiveChannel arg7, Continuation arg8) {
        Object v0_2;
        Object v7;
        Object v2_1;
        ReceiveChannel v2_2;
        ChannelIterator v8_2;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$singleOrNull$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$singleOrNull$1 v0_1 = new ChannelsKt__DeprecatedKt$singleOrNull$1(arg8);
        }

        Object v8 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                v8_2 = arg7.iterator();
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$0 = arg7;
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$1 = v8_2;
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).label = 1;
                v2_1 = v8_2.hasNext(v0);
                if(v2_1 != v1) {
                    goto label_47;
                }
            }
            catch(Throwable v8_1) {
                v2_2 = arg7;
                v7_1 = v8_1;
                goto label_75;
            }

            return v1;
        label_47:
            Object v6 = v2_1;
            v2_2 = arg7;
            ChannelIterator v7_2 = v8_2;
            v8 = v6;
            try {
            label_51:
                if(!((Boolean)v8).booleanValue()) {
                }
                else {
                    goto label_55;
                }
            }
            catch(Throwable v7_1) {
                goto label_38;
            }

            ChannelsKt.cancelConsumed(v2_2, v5);
            return v5;
            try {
            label_55:
                v8 = v7_2.next();
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$0 = v2_2;
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$1 = v8;
                ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).label = v3;
                v7 = v7_2.hasNext(v0);
                if(v7 != v1) {
                    goto label_62;
                }
            }
            catch(Throwable v7_1) {
            label_38:
                goto label_75;
            }

            return v1;
        label_62:
            v0_2 = v8;
            v8 = v7;
            v7 = v0_2;
            v0_2 = v2_2;
        }
        else if(v2 == 1) {
            v7 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_51;
            }
            catch(Throwable v7_1) {
                goto label_38;
            }
        }
        else if(v2 == v3) {
            v7 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$1;
            v0_2 = ((ChannelsKt__DeprecatedKt$singleOrNull$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
            }
            catch(Throwable v7_1) {
                goto label_27;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
            if(!((Boolean)v8).booleanValue()) {
                goto label_70;
            }

            goto label_68;
        }
        catch(Throwable v7_1) {
        label_27:
            v2_1 = v0_2;
        }

        try {
        label_75:
            throw v7_1;
        }
        catch(Throwable v8_1) {
            ChannelsKt.cancelConsumed(v2_2, v7_1);
            throw v8_1;
        }

    label_68:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v5);
        return v5;
    label_70:
        ChannelsKt.cancelConsumed(((ReceiveChannel)v0_2), v5);
        return v7;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel take(ReceiveChannel arg9, int arg10, CoroutineContext arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg11, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$take$1(arg10, arg9, null), 6, null);
    }

    public static ReceiveChannel take$default(ReceiveChannel arg0, int arg1, CoroutineContext arg2, int arg3, Object arg4) {
        CoroutineDispatcher v2;
        if((arg3 & 2) != 0) {
            v2 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.take(arg0, arg1, ((CoroutineContext)v2));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel takeWhile(ReceiveChannel arg9, CoroutineContext arg10, Function2 arg11) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$takeWhile$1(arg9, arg11, null), 6, null);
    }

    public static ReceiveChannel takeWhile$default(ReceiveChannel arg0, CoroutineContext arg1, Function2 arg2, int arg3, Object arg4) {
        CoroutineDispatcher v1;
        if((arg3 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.takeWhile(arg0, ((CoroutineContext)v1), arg2);
    }

    public static final Object toChannel(ReceiveChannel arg7, SendChannel arg8, Continuation arg9) {
        Object v2_1;
        Object v8;
        Object v7;
        ReceiveChannel v8_2;
        ChannelIterator v9_1;
        int v2;
        Continuation v0;
        if((arg9 instanceof ChannelsKt__DeprecatedKt$toChannel$1)) {
            v0 = arg9;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$toChannel$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$toChannel$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$toChannel$1 v0_1 = new ChannelsKt__DeprecatedKt$toChannel$1(arg9);
        }

        Object v9 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).label;
        int v3 = 2;
        Throwable v5 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            try {
                v9_1 = arg7.iterator();
                goto label_43;
            }
            catch(Throwable v8_1) {
            label_69:
                Throwable v6 = v8_1;
                v8_2 = arg7;
                v7_1 = v6;
                try {
                label_72:
                    throw v7_1;
                }
                catch(Throwable v9_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v7_1);
                    throw v9_2;
                }
            }

            try {
            label_55:
                if(((Boolean)v9).booleanValue()) {
                    v9 = ((ChannelIterator)v7).next();
                    ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$0 = v2_1;
                    ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$1 = v8;
                    ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$2 = v7;
                    ((ChannelsKt__DeprecatedKt$toChannel$1)v0).label = v3;
                    if(((SendChannel)v2_1).send(v9, v0) != v1) {
                        goto label_26;
                    }

                    return v1;
                }
                else {
                }
            }
            catch(Throwable v7_1) {
                goto label_40;
            }

            ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v5);
            return v2_1;
            try {
            label_43:
                ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$0 = arg8;
                ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$1 = arg7;
                ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$2 = v9_1;
                ((ChannelsKt__DeprecatedKt$toChannel$1)v0).label = 1;
                v2_1 = v9_1.hasNext(v0);
                if(v2_1 == v1) {
                }
                else {
                    goto label_50;
                }
            }
            catch(Throwable v8_1) {
                goto label_69;
            }

            return v1;
        label_50:
            SendChannel v6_1 = arg8;
            v8_2 = arg7;
            v7 = v9_1;
            v9 = v2_1;
            SendChannel v2_2 = v6_1;
            goto label_55;
        label_40:
            goto label_72;
        }
        else if(v2 == 1) {
            v7 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$2;
            v8 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_55;
            }
            catch(Throwable v7_1) {
                goto label_40;
            }
        }
        else if(v2 == v3) {
            v7 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$2;
            v8 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$toChannel$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v9);
            }
            catch(Throwable v7_1) {
                goto label_40;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

    label_26:
        v9 = v7;
        v7 = v8;
        v8 = v2_1;
        goto label_43;
    }

    public static final Object toCollection(ReceiveChannel arg6, Collection arg7, Continuation arg8) {
        Object v2_1;
        Object v6;
        ChannelIterator v6_2;
        ReceiveChannel v7_2;
        int v2;
        Continuation v0;
        if((arg8 instanceof ChannelsKt__DeprecatedKt$toCollection$1)) {
            v0 = arg8;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$toCollection$1)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$toCollection$1)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            ChannelsKt__DeprecatedKt$toCollection$1 v0_1 = new ChannelsKt__DeprecatedKt$toCollection$1(arg8);
        }

        Object v8 = ((ChannelsKt__DeprecatedKt$toCollection$1)v0).result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = ((ChannelsKt__DeprecatedKt$toCollection$1)v0).label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v8);
            try {
                Collection v5 = arg7;
                v7_2 = arg6;
                v6_2 = arg6.iterator();
                Collection v8_1 = v5;
                goto label_37;
            }
            catch(Throwable v7_1) {
                Throwable v5_1 = v7_1;
                ChannelIterator v7_3 = v6_2;
                v6_1 = v5_1;
                try {
                label_60:
                    throw v6_1;
                }
                catch(Throwable v8_2) {
                    ChannelsKt.cancelConsumed(v7_2, v6_1);
                    throw v8_2;
                }
            }

            try {
            label_47:
                if(((Boolean)v8).booleanValue()) {
                    ((Collection)v2_1).add(((ChannelIterator)v6).next());
                    v8 = v2_1;
                }
                else {
                    goto label_54;
                }

                goto label_37;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }

        label_54:
            ChannelsKt.cancelConsumed(v7_2, v3);
            return v2_1;
        }
        else if(v2 == 1) {
            v6 = ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$2;
            Object v7 = ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$1;
            v2_1 = ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$0;
            try {
                ResultKt.throwOnFailure(v8);
                goto label_47;
            }
            catch(Throwable v6_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_37:
            ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$0 = v8;
            ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$1 = v7_2;
            ((ChannelsKt__DeprecatedKt$toCollection$1)v0).L$2 = v6;
            ((ChannelsKt__DeprecatedKt$toCollection$1)v0).label = 1;
            v2_1 = ((ChannelIterator)v6).hasNext(v0);
            if(v2_1 == v1) {
                return v1;
            }

            Object v5_2 = v2_1;
            Collection v2_2 = ((Collection)v8);
            v8 = v5_2;
            goto label_47;
        }
        catch(Throwable v6_1) {
        label_26:
            goto label_60;
        }
    }

    public static final Object toMap(ReceiveChannel arg7, Map arg8, Continuation arg9) {
        Object v2_1;
        Object v8;
        Object v7;
        ChannelIterator v7_2;
        ChannelsKt__DeprecatedKt$toMap$2 v0_1;
        int v2;
        if((arg9 instanceof ChannelsKt__DeprecatedKt$toMap$2)) {
            Continuation v0 = arg9;
            v2 = 0x80000000;
            if((((ChannelsKt__DeprecatedKt$toMap$2)v0).label & v2) != 0) {
                ((ChannelsKt__DeprecatedKt$toMap$2)v0).label -= v2;
            }
            else {
                goto label_11;
            }
        }
        else {
        label_11:
            v0_1 = new ChannelsKt__DeprecatedKt$toMap$2(arg9);
        }

        Object v9 = v0_1.result;
        Object v1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        v2 = v0_1.label;
        Throwable v3 = null;
        if(v2 == 0) {
            ResultKt.throwOnFailure(v9);
            try {
                Map v6 = arg8;
                ReceiveChannel v8_2 = arg7;
                v7_2 = arg7.iterator();
                Map v9_1 = v6;
                goto label_37;
            }
            catch(Throwable v8_1) {
                Throwable v6_1 = v8_1;
                ChannelIterator v8_3 = v7_2;
                v7_1 = v6_1;
                try {
                label_62:
                    throw v7_1;
                }
                catch(Throwable v9_2) {
                    ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v7_1);
                    throw v9_2;
                }
            }

            try {
            label_47:
                if(((Boolean)v9).booleanValue()) {
                    v9 = ((ChannelIterator)v7).next();
                    ((Map)v2_1).put(((Pair)v9).getFirst(), ((Pair)v9).getSecond());
                    v9 = v2_1;
                }
                else {
                    goto label_56;
                }

                goto label_37;
            }
            catch(Throwable v7_1) {
                goto label_26;
            }

        label_56:
            ChannelsKt.cancelConsumed(((ReceiveChannel)v8), v3);
            return v2_1;
        }
        else if(v2 == 1) {
            v7 = v0_1.L$2;
            v8 = v0_1.L$1;
            v2_1 = v0_1.L$0;
            try {
                ResultKt.throwOnFailure(v9);
                goto label_47;
            }
            catch(Throwable v7_1) {
                goto label_26;
            }
        }
        else {
            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        }

        try {
        label_37:
            v0_1.L$0 = v9;
            v0_1.L$1 = v8;
            v0_1.L$2 = v7;
            v0_1.label = 1;
            v2_1 = ((ChannelIterator)v7).hasNext(((Continuation)v0_1));
            if(v2_1 == v1) {
                return v1;
            }

            Object v6_2 = v2_1;
            Map v2_2 = ((Map)v9);
            v9 = v6_2;
            goto label_47;
        }
        catch(Throwable v7_1) {
        label_26:
            goto label_62;
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toMap(ReceiveChannel arg1, Continuation arg2) {
        return ChannelsKt.toMap(arg1, new LinkedHashMap(), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toMutableList(ReceiveChannel arg1, Continuation arg2) {
        return ChannelsKt.toCollection(arg1, new ArrayList(), arg2);
    }

    public static final Object toMutableSet(ReceiveChannel arg1, Continuation arg2) {
        return ChannelsKt.toCollection(arg1, new LinkedHashSet(), arg2);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final Object toSet(ReceiveChannel arg0, Continuation arg1) {
        return ChannelsKt.toMutableSet(arg0, arg1);
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel withIndex(ReceiveChannel arg9, CoroutineContext arg10) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg10, 0, null, ChannelsKt.consumes(arg9), new ChannelsKt__DeprecatedKt$withIndex$1(arg9, null), 6, null);
    }

    public static ReceiveChannel withIndex$default(ReceiveChannel arg0, CoroutineContext arg1, int arg2, Object arg3) {
        CoroutineDispatcher v1;
        if((arg2 & 1) != 0) {
            v1 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.withIndex(arg0, ((CoroutineContext)v1));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Binary compatibility") public static final ReceiveChannel zip(ReceiveChannel arg6, ReceiveChannel arg7) {
        return ChannelsKt.zip$default(arg6, arg7, null, new ChannelsKt__DeprecatedKt$$ExternalSyntheticLambda2(), 2, null);
    }

    public static final ReceiveChannel zip(ReceiveChannel arg9, ReceiveChannel arg10, CoroutineContext arg11, Function2 arg12) {
        return ProduceKt.produce$default(GlobalScope.INSTANCE, arg11, 0, null, ChannelsKt.consumesAll(new ReceiveChannel[]{arg9, arg10}), new ChannelsKt__DeprecatedKt$zip$2(arg10, arg9, arg12, null), 6, null);
    }

    public static ReceiveChannel zip$default(ReceiveChannel arg0, ReceiveChannel arg1, CoroutineContext arg2, Function2 arg3, int arg4, Object arg5) {
        CoroutineDispatcher v2;
        if((arg4 & 2) != 0) {
            v2 = Dispatchers.getUnconfined();
        }

        return ChannelsKt.zip(arg0, arg1, ((CoroutineContext)v2), arg3);
    }

    private static final Pair zip$lambda$23$ChannelsKt__DeprecatedKt(Object arg0, Object arg1) {
        return TuplesKt.to(arg0, arg1);
    }
}

