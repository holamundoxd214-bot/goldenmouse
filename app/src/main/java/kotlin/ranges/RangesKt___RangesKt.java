package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;

@Metadata(d1={"\u0000r\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010\u000F\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0003*\u00020\u0004H\u0087\u0080\u0004\u001A\u000E\u0010\u0000\u001A\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004\u001A\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0003*\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0005*\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001A\u000E\u0010\u000B\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u0010\u000B\u001A\u00020\u0003*\u00020\u0004H\u0087\u0080\u0004\u001A\u000E\u0010\u000B\u001A\u00020\u0005*\u00020\u0006H\u0087\u0080\u0004\u001A\u0015\u0010\f\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A\u0015\u0010\f\u001A\u0004\u0018\u00010\u0003*\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u0015\u0010\f\u001A\u0004\u0018\u00010\u0005*\u00020\u0006H\u0087\u0080\u0004¢\u0006\u0002\u0010\n\u001A\u000E\u0010\r\u001A\u00020\u0001*\u00020\u000EH\u0087\u0088\u0004\u001A\u000E\u0010\r\u001A\u00020\u0003*\u00020\u000FH\u0087\u0088\u0004\u001A\u000E\u0010\r\u001A\u00020\u0005*\u00020\u0010H\u0087\u0088\u0004\u001A\u0016\u0010\r\u001A\u00020\u0001*\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004\u001A\u0016\u0010\r\u001A\u00020\u0003*\u00020\u000F2\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004\u001A\u0016\u0010\r\u001A\u00020\u0005*\u00020\u00102\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004\u001A\u0015\u0010\u0012\u001A\u0004\u0018\u00010\u0001*\u00020\u000EH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0013\u001A\u0015\u0010\u0012\u001A\u0004\u0018\u00010\u0003*\u00020\u000FH\u0087\u0088\u0004¢\u0006\u0002\u0010\u0014\u001A\u0015\u0010\u0012\u001A\u0004\u0018\u00010\u0005*\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0015\u001A\u001D\u0010\u0012\u001A\u0004\u0018\u00010\u0001*\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0016\u001A\u001D\u0010\u0012\u001A\u0004\u0018\u00010\u0003*\u00020\u000F2\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A\u001D\u0010\u0012\u001A\u0004\u0018\u00010\u0005*\u00020\u00102\u0006\u0010\r\u001A\u00020\u0011H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0018\u001A\u001D\u0010\u0019\u001A\u00020\u001A*\u00020\u000E2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001H\u0087\u008A\u0004¢\u0006\u0002\u0010\u001C\u001A\u001D\u0010\u0019\u001A\u00020\u001A*\u00020\u000F2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0003H\u0087\u008A\u0004¢\u0006\u0002\u0010\u001D\u001A\u001D\u0010\u0019\u001A\u00020\u001A*\u00020\u00102\b\u0010\u001B\u001A\u0004\u0018\u00010\u0005H\u0087\u008A\u0004¢\u0006\u0002\u0010\u001E\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010\u001F2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0\u001F2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0\u001F2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020(0\u001F2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b)\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001A\u00020!H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000E2\u0006\u0010 \u001A\u00020!H\u0087\u008A\u0004\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000F2\u0006\u0010 \u001A\u00020!H\u0087\u008A\u0004\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010\u001F2\u0006\u0010 \u001A\u00020&H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020&H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0\u001F2\u0006\u0010 \u001A\u00020&H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0\u001F2\u0006\u0010 \u001A\u00020&H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020(0\u001F2\u0006\u0010 \u001A\u00020&H\u0087\u0082\u0004¢\u0006\u0002\b)\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010\u001F2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0\u001F2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0\u001F2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0\u001F2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0*2\u0006\u0010 \u001A\u00020(H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0\u001F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0\u001F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0\u001F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020(0\u001F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b)\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001A\u00020\u0001H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000F2\u0006\u0010 \u001A\u00020\u0001H\u0087\u008A\u0004\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010\u001F2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0\u001F2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0\u001F2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0\u001F2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020(0\u001F2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b)\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010 \u001A\u00020\u0003H\u0087\u0082\u0004¢\u0006\u0002\b%\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000E2\u0006\u0010 \u001A\u00020\u0003H\u0087\u008A\u0004\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010\u001F2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030\u001F2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0\u001F2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020&0\u001F2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b\'\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020(0\u001F2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b)\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00010*2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b\"\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b#\u001A!\u0010\u0019\u001A\u00020\u001A*\b\u0012\u0004\u0012\u00020!0*2\u0006\u0010 \u001A\u00020$H\u0087\u0082\u0004¢\u0006\u0002\b+\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000E2\u0006\u0010 \u001A\u00020$H\u0087\u008A\u0004\u001A\u0016\u0010\u0019\u001A\u00020\u001A*\u00020\u000F2\u0006\u0010 \u001A\u00020$H\u0087\u008A\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020\u00012\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020\u00032\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020!2\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020$2\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0006*\u00020\u00052\u0006\u0010-\u001A\u00020\u0005H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020\u00012\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020\u00032\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020!2\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020$2\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020\u00012\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020\u00032\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020!2\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020$2\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020\u00012\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0004*\u00020\u00032\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020!2\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010,\u001A\u00020\u0002*\u00020$2\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u000E\u0010.\u001A\u00020\u0002*\u00020\u0002H\u0086\u0080\u0004\u001A\u000E\u0010.\u001A\u00020\u0004*\u00020\u0004H\u0086\u0080\u0004\u001A\u000E\u0010.\u001A\u00020\u0006*\u00020\u0006H\u0086\u0080\u0004\u001A\u0016\u0010/\u001A\u00020\u0002*\u00020\u00022\u0006\u0010/\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010/\u001A\u00020\u0004*\u00020\u00042\u0006\u0010/\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010/\u001A\u00020\u0006*\u00020\u00062\u0006\u0010/\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0015\u00100\u001A\u0004\u0018\u00010!*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u00101\u001A\u0015\u00100\u001A\u0004\u0018\u00010!*\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0002\u00102\u001A\u0015\u00100\u001A\u0004\u0018\u00010!*\u00020$H\u0080\u0080\u0004¢\u0006\u0002\u00103\u001A\u0015\u00100\u001A\u0004\u0018\u00010!*\u00020&H\u0080\u0080\u0004¢\u0006\u0002\u00104\u001A\u0015\u00100\u001A\u0004\u0018\u00010!*\u00020(H\u0080\u0080\u0004¢\u0006\u0002\u00105\u001A\u0015\u00106\u001A\u0004\u0018\u00010\u0001*\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0002\u00107\u001A\u0015\u00106\u001A\u0004\u0018\u00010\u0001*\u00020&H\u0080\u0080\u0004¢\u0006\u0002\u00108\u001A\u0015\u00106\u001A\u0004\u0018\u00010\u0001*\u00020(H\u0080\u0080\u0004¢\u0006\u0002\u00109\u001A\u0015\u0010:\u001A\u0004\u0018\u00010\u0003*\u00020&H\u0080\u0080\u0004¢\u0006\u0002\u0010;\u001A\u0015\u0010:\u001A\u0004\u0018\u00010\u0003*\u00020(H\u0080\u0080\u0004¢\u0006\u0002\u0010<\u001A\u0015\u0010=\u001A\u0004\u0018\u00010$*\u00020\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010>\u001A\u0015\u0010=\u001A\u0004\u0018\u00010$*\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0002\u0010?\u001A\u0015\u0010=\u001A\u0004\u0018\u00010$*\u00020&H\u0080\u0080\u0004¢\u0006\u0002\u0010@\u001A\u0015\u0010=\u001A\u0004\u0018\u00010$*\u00020(H\u0080\u0080\u0004¢\u0006\u0002\u0010A\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020\u00012\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020\u00032\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020!2\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020$2\u0006\u0010-\u001A\u00020!H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u0010*\u00020\u00052\u0006\u0010-\u001A\u00020\u0005H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020\u00012\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020\u00032\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020!2\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020$2\u0006\u0010-\u001A\u00020\u0001H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020\u00012\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020\u00032\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020!2\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020$2\u0006\u0010-\u001A\u00020\u0003H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020\u00012\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000F*\u00020\u00032\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020!2\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A\u0016\u0010B\u001A\u00020\u000E*\u00020$2\u0006\u0010-\u001A\u00020$H\u0086\u0084\u0004\u001A+\u0010C\u001A\u0002HD\"\u000E\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\u0006\u0010F\u001A\u0002HDH\u0086\u0080\u0004¢\u0006\u0002\u0010G\u001A\u0016\u0010C\u001A\u00020!*\u00020!2\u0006\u0010F\u001A\u00020!H\u0086\u0080\u0004\u001A\u0016\u0010C\u001A\u00020$*\u00020$2\u0006\u0010F\u001A\u00020$H\u0086\u0080\u0004\u001A\u0016\u0010C\u001A\u00020\u0001*\u00020\u00012\u0006\u0010F\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010C\u001A\u00020\u0003*\u00020\u00032\u0006\u0010F\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u0016\u0010C\u001A\u00020(*\u00020(2\u0006\u0010F\u001A\u00020(H\u0086\u0080\u0004\u001A\u0016\u0010C\u001A\u00020&*\u00020&2\u0006\u0010F\u001A\u00020&H\u0086\u0080\u0004\u001A+\u0010H\u001A\u0002HD\"\u000E\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\u0006\u0010I\u001A\u0002HDH\u0086\u0080\u0004¢\u0006\u0002\u0010G\u001A\u0016\u0010H\u001A\u00020!*\u00020!2\u0006\u0010I\u001A\u00020!H\u0086\u0080\u0004\u001A\u0016\u0010H\u001A\u00020$*\u00020$2\u0006\u0010I\u001A\u00020$H\u0086\u0080\u0004\u001A\u0016\u0010H\u001A\u00020\u0001*\u00020\u00012\u0006\u0010I\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u0010H\u001A\u00020\u0003*\u00020\u00032\u0006\u0010I\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u0016\u0010H\u001A\u00020(*\u00020(2\u0006\u0010I\u001A\u00020(H\u0086\u0080\u0004\u001A\u0016\u0010H\u001A\u00020&*\u00020&2\u0006\u0010I\u001A\u00020&H\u0086\u0080\u0004\u001A7\u0010J\u001A\u0002HD\"\u000E\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\b\u0010F\u001A\u0004\u0018\u0001HD2\b\u0010I\u001A\u0004\u0018\u0001HDH\u0086\u0080\u0004¢\u0006\u0002\u0010K\u001A\u001E\u0010J\u001A\u00020!*\u00020!2\u0006\u0010F\u001A\u00020!2\u0006\u0010I\u001A\u00020!H\u0086\u0080\u0004\u001A\u001E\u0010J\u001A\u00020$*\u00020$2\u0006\u0010F\u001A\u00020$2\u0006\u0010I\u001A\u00020$H\u0086\u0080\u0004\u001A\u001E\u0010J\u001A\u00020\u0001*\u00020\u00012\u0006\u0010F\u001A\u00020\u00012\u0006\u0010I\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u001E\u0010J\u001A\u00020\u0003*\u00020\u00032\u0006\u0010F\u001A\u00020\u00032\u0006\u0010I\u001A\u00020\u0003H\u0086\u0080\u0004\u001A\u001E\u0010J\u001A\u00020(*\u00020(2\u0006\u0010F\u001A\u00020(2\u0006\u0010I\u001A\u00020(H\u0086\u0080\u0004\u001A\u001E\u0010J\u001A\u00020&*\u00020&2\u0006\u0010F\u001A\u00020&2\u0006\u0010I\u001A\u00020&H\u0086\u0080\u0004\u001A1\u0010J\u001A\u0002HD\"\u000E\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\f\u0010L\u001A\b\u0012\u0004\u0012\u0002HD0MH\u0087\u0080\u0004¢\u0006\u0002\u0010N\u001A1\u0010J\u001A\u0002HD\"\u000E\b\u0000\u0010D*\b\u0012\u0004\u0012\u0002HD0E*\u0002HD2\f\u0010L\u001A\b\u0012\u0004\u0012\u0002HD0\u001FH\u0086\u0080\u0004¢\u0006\u0002\u0010O\u001A\u001C\u0010J\u001A\u00020\u0001*\u00020\u00012\f\u0010L\u001A\b\u0012\u0004\u0012\u00020\u00010\u001FH\u0086\u0080\u0004\u001A\u001C\u0010J\u001A\u00020\u0003*\u00020\u00032\f\u0010L\u001A\b\u0012\u0004\u0012\u00020\u00030\u001FH\u0086\u0080\u0004¨\u0006P"}, d2={"first", "", "Lkotlin/ranges/IntProgression;", "", "Lkotlin/ranges/LongProgression;", "", "Lkotlin/ranges/CharProgression;", "firstOrNull", "(Lkotlin/ranges/IntProgression;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongProgression;)Ljava/lang/Long;", "(Lkotlin/ranges/CharProgression;)Ljava/lang/Character;", "last", "lastOrNull", "random", "Lkotlin/ranges/IntRange;", "Lkotlin/ranges/LongRange;", "Lkotlin/ranges/CharRange;", "Lkotlin/random/Random;", "randomOrNull", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "contains", "", "element", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "Lkotlin/ranges/ClosedRange;", "value", "", "intRangeContains", "longRangeContains", "", "shortRangeContains", "", "doubleRangeContains", "", "floatRangeContains", "Lkotlin/ranges/OpenEndRange;", "byteRangeContains", "downTo", "to", "reversed", "step", "toByteExactOrNull", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "toIntExactOrNull", "(J)Ljava/lang/Integer;", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "until", "coerceAtLeast", "T", "", "minimumValue", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "coerceAtMost", "maximumValue", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "range", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/ranges/RangesKt") class RangesKt___RangesKt extends RangesKt__RangesKt {
    public RangesKt___RangesKt() {
        super();
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean byteRangeContains(ClosedRange arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean byteRangeContains(ClosedRange arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(ClosedRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(ClosedRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(ClosedRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(OpenEndRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(OpenEndRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean byteRangeContains(OpenEndRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Byte v2 = RangesKt.toByteExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final byte coerceAtLeast(byte arg0, byte arg1) {
        if(arg0 < arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final double coerceAtLeast(double arg1, double arg3) {
        if(arg1 < arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final float coerceAtLeast(float arg1, float arg2) {
        if(arg1 < arg2) {
            return arg2;
        }

        return arg1;
    }

    public static final int coerceAtLeast(int arg0, int arg1) {
        if(arg0 < arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final long coerceAtLeast(long arg1, long arg3) {
        if(arg1 < arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final Comparable coerceAtLeast(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "minimumValue");
        if(arg1.compareTo(arg2) < 0) {
            return arg2;
        }

        return arg1;
    }

    public static final short coerceAtLeast(short arg0, short arg1) {
        if(arg0 < arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final byte coerceAtMost(byte arg0, byte arg1) {
        if(arg0 > arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final double coerceAtMost(double arg1, double arg3) {
        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final float coerceAtMost(float arg1, float arg2) {
        if(arg1 > arg2) {
            return arg2;
        }

        return arg1;
    }

    public static final int coerceAtMost(int arg0, int arg1) {
        if(arg0 > arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final long coerceAtMost(long arg1, long arg3) {
        if(arg1 > arg3) {
            return arg3;
        }

        return arg1;
    }

    public static final Comparable coerceAtMost(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "maximumValue");
        if(arg1.compareTo(arg2) > 0) {
            return arg2;
        }

        return arg1;
    }

    public static final short coerceAtMost(short arg0, short arg1) {
        if(arg0 > arg1) {
            return arg1;
        }

        return arg0;
    }

    public static final byte coerceIn(byte arg2, byte arg3, byte arg4) {
        if(arg3 <= arg4) {
            if(arg2 < arg3) {
                return arg3;
            }

            if(arg2 > arg4) {
                return arg4;
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg4 + " is less than minimum " + arg3 + '.');
    }

    public static final double coerceIn(double arg1, double arg3, double arg5) {
        if(arg3 <= arg5) {
            if(arg1 < arg3) {
                return arg3;
            }

            if(arg1 > arg5) {
                return arg5;
            }

            return arg1;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg5 + " is less than minimum " + arg3 + '.');
    }

    public static final float coerceIn(float arg2, float arg3, float arg4) {
        if(arg3 <= arg4) {
            if(arg2 < arg3) {
                return arg3;
            }

            if(arg2 > arg4) {
                return arg4;
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg4 + " is less than minimum " + arg3 + '.');
    }

    public static final int coerceIn(int arg2, int arg3, int arg4) {
        if(arg3 <= arg4) {
            if(arg2 < arg3) {
                return arg3;
            }

            if(arg2 > arg4) {
                return arg4;
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg4 + " is less than minimum " + arg3 + '.');
    }

    public static final int coerceIn(int arg2, ClosedRange arg3) {
        Intrinsics.checkNotNullParameter(arg3, "range");
        if((arg3 instanceof ClosedFloatingPointRange)) {
            return RangesKt.coerceIn(Integer.valueOf(arg2), ((ClosedFloatingPointRange)arg3)).intValue();
        }

        if(!arg3.isEmpty()) {
            if(arg2 < arg3.getStart().intValue()) {
                return arg3.getStart().intValue();
            }

            if(arg2 > arg3.getEndInclusive().intValue()) {
                arg2 = arg3.getEndInclusive().intValue();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg3 + '.');
    }

    public static final long coerceIn(long arg1, long arg3, long arg5) {
        if(arg3 <= arg5) {
            if(arg1 < arg3) {
                return arg3;
            }

            if(arg1 > arg5) {
                return arg5;
            }

            return arg1;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg5 + " is less than minimum " + arg3 + '.');
    }

    public static final long coerceIn(long arg2, ClosedRange arg4) {
        Intrinsics.checkNotNullParameter(arg4, "range");
        if((arg4 instanceof ClosedFloatingPointRange)) {
            return RangesKt.coerceIn(Long.valueOf(arg2), ((ClosedFloatingPointRange)arg4)).longValue();
        }

        if(!arg4.isEmpty()) {
            if(arg2 < arg4.getStart().longValue()) {
                return arg4.getStart().longValue();
            }

            if(arg2 > arg4.getEndInclusive().longValue()) {
                arg2 = arg4.getEndInclusive().longValue();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg4 + '.');
    }

    public static final Comparable coerceIn(Comparable arg2, Comparable arg3, Comparable arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 == null || arg4 == null) {
            if(arg3 != null && arg2.compareTo(arg3) < 0) {
                return arg3;
            }

            if(arg4 == null) {
                return arg2;
            }

            if(arg2.compareTo(arg4) <= 0) {
                return arg2;
            }

            return arg4;
        }
        else if(arg3.compareTo(arg4) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg4 + " is less than minimum " + arg3 + '.');
        }
        else if(arg2.compareTo(arg3) < 0) {
            return arg3;
        }
        else if(arg2.compareTo(arg4) > 0) {
            return arg4;
        }

        return arg2;
    }

    public static final Comparable coerceIn(Comparable arg2, ClosedFloatingPointRange arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "range");
        if(!arg3.isEmpty()) {
            if((arg3.lessThanOrEquals(arg2, arg3.getStart())) && !arg3.lessThanOrEquals(arg3.getStart(), arg2)) {
                return arg3.getStart();
            }

            if((arg3.lessThanOrEquals(arg3.getEndInclusive(), arg2)) && !arg3.lessThanOrEquals(arg2, arg3.getEndInclusive())) {
                arg2 = arg3.getEndInclusive();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg3 + '.');
    }

    public static final Comparable coerceIn(Comparable arg2, ClosedRange arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "range");
        if((arg3 instanceof ClosedFloatingPointRange)) {
            return RangesKt.coerceIn(arg2, ((ClosedFloatingPointRange)arg3));
        }

        if(!arg3.isEmpty()) {
            if(arg2.compareTo(arg3.getStart()) < 0) {
                return arg3.getStart();
            }

            if(arg2.compareTo(arg3.getEndInclusive()) > 0) {
                arg2 = arg3.getEndInclusive();
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + arg3 + '.');
    }

    public static final short coerceIn(short arg2, short arg3, short arg4) {
        if(arg3 <= arg4) {
            if(arg2 < arg3) {
                return arg3;
            }

            if(arg2 > arg4) {
                return arg4;
            }

            return arg2;
        }

        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + arg4 + " is less than minimum " + arg3 + '.');
    }

    private static final boolean contains(CharRange arg1, Character arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(arg2.charValue()))) {
            return 1;
        }

        return 0;
    }

    private static final boolean contains(IntRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.intRangeContains(((ClosedRange)arg1), arg2);
    }

    private static final boolean contains(IntRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.intRangeContains(((ClosedRange)arg1), arg2);
    }

    private static final boolean contains(IntRange arg1, Integer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(arg2.intValue()))) {
            return 1;
        }

        return 0;
    }

    private static final boolean contains(IntRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.intRangeContains(((ClosedRange)arg1), arg2);
    }

    private static final boolean contains(LongRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.longRangeContains(((ClosedRange)arg1), arg2);
    }

    private static final boolean contains(LongRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.longRangeContains(((ClosedRange)arg1), arg2);
    }

    private static final boolean contains(LongRange arg2, Long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg3 != null && (arg2.contains(arg3.longValue()))) {
            return 1;
        }

        return 0;
    }

    private static final boolean contains(LongRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.longRangeContains(((ClosedRange)arg1), arg2);
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean doubleRangeContains(ClosedRange arg2, byte arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Double.valueOf(((double)arg3)));
    }

    public static final boolean doubleRangeContains(ClosedRange arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Double.valueOf(((double)arg3)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean doubleRangeContains(ClosedRange arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Double.valueOf(((double)arg3)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean doubleRangeContains(ClosedRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Double.valueOf(((double)arg2)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean doubleRangeContains(ClosedRange arg2, short arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Double.valueOf(((double)arg3)));
    }

    public static final boolean doubleRangeContains(OpenEndRange arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Double.valueOf(((double)arg3)));
    }

    public static final CharProgression downTo(char arg2, char arg3) {
        return CharProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(byte arg2, byte arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(byte arg2, int arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(byte arg2, short arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(int arg2, byte arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(int arg2, int arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(int arg2, short arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(short arg2, byte arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(short arg2, int arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final IntProgression downTo(short arg2, short arg3) {
        return IntProgression.Companion.fromClosedRange(arg2, arg3, -1);
    }

    public static final LongProgression downTo(byte arg7, long arg8) {
        return LongProgression.Companion.fromClosedRange(((long)arg7), arg8, -1);
    }

    public static final LongProgression downTo(int arg7, long arg8) {
        return LongProgression.Companion.fromClosedRange(((long)arg7), arg8, -1);
    }

    public static final LongProgression downTo(long arg7, byte arg9) {
        return LongProgression.Companion.fromClosedRange(arg7, ((long)arg9), -1);
    }

    public static final LongProgression downTo(long arg7, int arg9) {
        return LongProgression.Companion.fromClosedRange(arg7, ((long)arg9), -1);
    }

    public static final LongProgression downTo(long arg7, long arg9) {
        return LongProgression.Companion.fromClosedRange(arg7, arg9, -1);
    }

    public static final LongProgression downTo(long arg7, short arg9) {
        return LongProgression.Companion.fromClosedRange(arg7, ((long)arg9), -1);
    }

    public static final LongProgression downTo(short arg7, long arg8) {
        return LongProgression.Companion.fromClosedRange(((long)arg7), arg8, -1);
    }

    public static final char first(CharProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getFirst();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final int first(IntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getFirst();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final long first(LongProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getFirst();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final Character firstOrNull(CharProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return Character.valueOf(arg1.getFirst());
    }

    public static final Integer firstOrNull(IntProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return Integer.valueOf(arg1.getFirst());
    }

    public static final Long firstOrNull(LongProgression arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.isEmpty()) {
            return null;
        }

        return Long.valueOf(arg2.getFirst());
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean floatRangeContains(ClosedRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Float.valueOf(((float)arg2)));
    }

    public static final boolean floatRangeContains(ClosedRange arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Float.valueOf(((float)arg2)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean floatRangeContains(ClosedRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Float.valueOf(((float)arg2)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean floatRangeContains(ClosedRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Float.valueOf(((float)arg2)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean floatRangeContains(ClosedRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Float.valueOf(((float)arg2)));
    }

    public static final boolean intRangeContains(ClosedRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Integer.valueOf(arg2));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean intRangeContains(ClosedRange arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v2 = RangesKt.toIntExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean intRangeContains(ClosedRange arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v2 = RangesKt.toIntExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean intRangeContains(ClosedRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v2 = RangesKt.toIntExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean intRangeContains(ClosedRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Integer.valueOf(arg2));
    }

    public static final boolean intRangeContains(OpenEndRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Integer.valueOf(arg2));
    }

    public static final boolean intRangeContains(OpenEndRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Integer v2 = RangesKt.toIntExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean intRangeContains(OpenEndRange arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Integer.valueOf(arg2));
    }

    public static final char last(CharProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getLast();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final int last(IntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getLast();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final long last(LongProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(!arg3.isEmpty()) {
            return arg3.getLast();
        }

        throw new NoSuchElementException("Progression " + arg3 + " is empty.");
    }

    public static final Character lastOrNull(CharProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return Character.valueOf(arg1.getLast());
    }

    public static final Integer lastOrNull(IntProgression arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.isEmpty()) {
            return null;
        }

        return Integer.valueOf(arg1.getLast());
    }

    public static final Long lastOrNull(LongProgression arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.isEmpty()) {
            return null;
        }

        return Long.valueOf(arg2.getLast());
    }

    public static final boolean longRangeContains(ClosedRange arg2, byte arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean longRangeContains(ClosedRange arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Long v2 = RangesKt.toLongExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean longRangeContains(ClosedRange arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Long v2 = RangesKt.toLongExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean longRangeContains(ClosedRange arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    public static final boolean longRangeContains(ClosedRange arg2, short arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    public static final boolean longRangeContains(OpenEndRange arg2, byte arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    public static final boolean longRangeContains(OpenEndRange arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    public static final boolean longRangeContains(OpenEndRange arg2, short arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return arg2.contains(Long.valueOf(((long)arg3)));
    }

    private static final char random(CharRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.random(arg1, Random.Default);
    }

    public static final char random(CharRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        try {
            return ((char)arg2.nextInt(arg1.getFirst(), arg1.getLast() + 1));
        }
        catch(IllegalArgumentException v1) {
            throw new NoSuchElementException(v1.getMessage());
        }
    }

    private static final int random(IntRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.random(arg1, Random.Default);
    }

    public static final int random(IntRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        try {
            return RandomKt.nextInt(arg2, arg1);
        }
        catch(IllegalArgumentException v1) {
            throw new NoSuchElementException(v1.getMessage());
        }
    }

    private static final long random(LongRange arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return RangesKt.random(arg2, Random.Default);
    }

    public static final long random(LongRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        try {
            return RandomKt.nextLong(arg2, arg1);
        }
        catch(IllegalArgumentException v1) {
            throw new NoSuchElementException(v1.getMessage());
        }
    }

    private static final Character randomOrNull(CharRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.randomOrNull(arg1, Random.Default);
    }

    public static final Character randomOrNull(CharRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        if(arg1.isEmpty()) {
            return null;
        }

        return Character.valueOf(((char)arg2.nextInt(arg1.getFirst(), arg1.getLast() + 1)));
    }

    private static final Integer randomOrNull(IntRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.randomOrNull(arg1, Random.Default);
    }

    public static final Integer randomOrNull(IntRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        if(arg1.isEmpty()) {
            return null;
        }

        return Integer.valueOf(RandomKt.nextInt(arg2, arg1));
    }

    private static final Long randomOrNull(LongRange arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return RangesKt.randomOrNull(arg1, Random.Default);
    }

    public static final Long randomOrNull(LongRange arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        if(arg1.isEmpty()) {
            return null;
        }

        return Long.valueOf(RandomKt.nextLong(arg2, arg1));
    }

    public static final CharProgression reversed(CharProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return CharProgression.Companion.fromClosedRange(arg3.getLast(), arg3.getFirst(), -arg3.getStep());
    }

    public static final IntProgression reversed(IntProgression arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        return IntProgression.Companion.fromClosedRange(arg3.getLast(), arg3.getFirst(), -arg3.getStep());
    }

    public static final LongProgression reversed(LongProgression arg8) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        return LongProgression.Companion.fromClosedRange(arg8.getLast(), arg8.getFirst(), -arg8.getStep());
    }

    public static final boolean shortRangeContains(ClosedRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Short.valueOf(((short)arg2)));
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean shortRangeContains(ClosedRange arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    @Deprecated(message="This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.") @DeprecatedSinceKotlin(errorSince="1.4", hiddenSince="1.5", warningSince="1.3") public static final boolean shortRangeContains(ClosedRange arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean shortRangeContains(ClosedRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean shortRangeContains(ClosedRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean shortRangeContains(OpenEndRange arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.contains(Short.valueOf(((short)arg2)));
    }

    public static final boolean shortRangeContains(OpenEndRange arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final boolean shortRangeContains(OpenEndRange arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Short v2 = RangesKt.toShortExactOrNull(arg2);
        if(v2 != null) {
            return arg1.contains(((Comparable)v2));
        }

        return 0;
    }

    public static final CharProgression step(CharProgression arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        boolean v0 = arg4 > 0 ? true : false;
        RangesKt.checkStepIsPositive(v0, Integer.valueOf(arg4));
        Companion v0_1 = CharProgression.Companion;
        char v1 = arg3.getFirst();
        char v2 = arg3.getLast();
        if(arg3.getStep() > 0) {
        }
        else {
            arg4 = -arg4;
        }

        return v0_1.fromClosedRange(v1, v2, arg4);
    }

    public static final IntProgression step(IntProgression arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        boolean v0 = arg4 > 0 ? true : false;
        RangesKt.checkStepIsPositive(v0, Integer.valueOf(arg4));
        kotlin.ranges.IntProgression$Companion v0_1 = IntProgression.Companion;
        int v1 = arg3.getFirst();
        int v2 = arg3.getLast();
        if(arg3.getStep() > 0) {
        }
        else {
            arg4 = -arg4;
        }

        return v0_1.fromClosedRange(v1, v2, arg4);
    }

    public static final LongProgression step(LongProgression arg11, long arg12) {
        Intrinsics.checkNotNullParameter(arg11, "<this>");
        long v0 = 0;
        boolean v2 = arg12 > v0 ? true : false;
        RangesKt.checkStepIsPositive(v2, Long.valueOf(arg12));
        kotlin.ranges.LongProgression$Companion v4 = LongProgression.Companion;
        long v5 = arg11.getFirst();
        long v7 = arg11.getLast();
        if(arg11.getStep() > v0) {
        }
        else {
            arg12 = -arg12;
        }

        return v4.fromClosedRange(v5, v7, arg12);
    }

    public static final Byte toByteExactOrNull(double arg2) {
        if(-128 <= arg2 && arg2 <= 127) {
            return Byte.valueOf(((byte)(((int)arg2))));
        }

        return null;
    }

    public static final Byte toByteExactOrNull(float arg1) {
        if(-128f <= arg1 && arg1 <= 127f) {
            return Byte.valueOf(((byte)(((int)arg1))));
        }

        return null;
    }

    public static final Byte toByteExactOrNull(int arg1) {
        if(0xFFFFFF80 <= arg1 && arg1 < 0x80) {
            return Byte.valueOf(((byte)arg1));
        }

        return null;
    }

    public static final Byte toByteExactOrNull(long arg2) {
        if(-128 <= arg2 && arg2 < 0x80) {
            return Byte.valueOf(((byte)(((int)arg2))));
        }

        return null;
    }

    public static final Byte toByteExactOrNull(short arg1) {
        if(0xFFFFFF80 <= arg1 && arg1 < 0x80) {
            return Byte.valueOf(((byte)arg1));
        }

        return null;
    }

    public static final Integer toIntExactOrNull(double arg2) {
        if(-2147483648 <= arg2 && arg2 <= 2147483647) {
            return Integer.valueOf(((int)arg2));
        }

        return null;
    }

    public static final Integer toIntExactOrNull(float arg1) {
        if(-2147483648f <= arg1 && arg1 <= 2147483648f) {
            return Integer.valueOf(((int)arg1));
        }

        return null;
    }

    public static final Integer toIntExactOrNull(long arg2) {
        if(-2147483648 <= arg2 && arg2 < 0x80000000L) {
            return Integer.valueOf(((int)arg2));
        }

        return null;
    }

    public static final Long toLongExactOrNull(double arg2) {
        if(-9223372036854776000 <= arg2 && arg2 <= 9223372036854776000) {
            return Long.valueOf(((long)arg2));
        }

        return null;
    }

    public static final Long toLongExactOrNull(float arg2) {
        if(-9223372036854776000f <= arg2 && arg2 <= 9223372036854776000f) {
            return Long.valueOf(((long)arg2));
        }

        return null;
    }

    public static final Short toShortExactOrNull(double arg2) {
        if(-32768 <= arg2 && arg2 <= 32767) {
            return Short.valueOf(((short)(((int)arg2))));
        }

        return null;
    }

    public static final Short toShortExactOrNull(float arg1) {
        if(-32768f <= arg1 && arg1 <= 32767f) {
            return Short.valueOf(((short)(((int)arg1))));
        }

        return null;
    }

    public static final Short toShortExactOrNull(int arg1) {
        if(0xFFFF8000 <= arg1 && arg1 < 0x8000) {
            return Short.valueOf(((short)arg1));
        }

        return null;
    }

    public static final Short toShortExactOrNull(long arg2) {
        if(-32768 <= arg2 && arg2 < 0x8000) {
            return Short.valueOf(((short)(((int)arg2))));
        }

        return null;
    }

    public static final CharRange until(char arg1, char arg2) {
        if(Intrinsics.compare(arg2, 0) <= 0) {
            return CharRange.Companion.getEMPTY();
        }

        return new CharRange(arg1, ((char)(arg2 - 1)));
    }

    public static final IntRange until(byte arg1, byte arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(byte arg1, int arg2) {
        if(arg2 <= 0x80000000) {
            return IntRange.Companion.getEMPTY();
        }

        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(byte arg1, short arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(int arg1, byte arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(int arg1, int arg2) {
        if(arg2 <= 0x80000000) {
            return IntRange.Companion.getEMPTY();
        }

        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(int arg1, short arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(short arg1, byte arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(short arg1, int arg2) {
        if(arg2 <= 0x80000000) {
            return IntRange.Companion.getEMPTY();
        }

        return new IntRange(arg1, arg2 - 1);
    }

    public static final IntRange until(short arg1, short arg2) {
        return new IntRange(arg1, arg2 - 1);
    }

    public static final LongRange until(byte arg5, long arg6) {
        if(arg6 <= -9223372036854775808L) {
            return LongRange.Companion.getEMPTY();
        }

        return new LongRange(((long)arg5), arg6 - 1);
    }

    public static final LongRange until(int arg5, long arg6) {
        if(arg6 <= -9223372036854775808L) {
            return LongRange.Companion.getEMPTY();
        }

        return new LongRange(((long)arg5), arg6 - 1);
    }

    public static final LongRange until(long arg5, byte arg7) {
        return new LongRange(arg5, (((long)arg7)) - 1);
    }

    public static final LongRange until(long arg5, int arg7) {
        return new LongRange(arg5, (((long)arg7)) - 1);
    }

    public static final LongRange until(long arg3, long arg5) {
        if(arg5 <= -9223372036854775808L) {
            return LongRange.Companion.getEMPTY();
        }

        return new LongRange(arg3, arg5 - 1);
    }

    public static final LongRange until(long arg5, short arg7) {
        return new LongRange(arg5, (((long)arg7)) - 1);
    }

    public static final LongRange until(short arg5, long arg6) {
        if(arg6 <= -9223372036854775808L) {
            return LongRange.Companion.getEMPTY();
        }

        return new LongRange(((long)arg5), arg6 - 1);
    }
}

