package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000z\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001F\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000F\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\\\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001A\u001C\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u001A^\u0010\n\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001A\u001C\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\t\u001A:\u0010\u000B\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\r0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001A]\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052$\u0010\u0006\u001A \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000F0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001Ab\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052$\u0010\u0006\u001A \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00100\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b\u0011\u001Av\u0010\u0012\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u0013*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0014*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0015\u001A\u0002H\u00132$\u0010\u0006\u001A \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u000F0\u0007H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001Ax\u0010\u0012\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u0013*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0014*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0015\u001A\u0002H\u00132$\u0010\u0006\u001A \u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00100\u0007H\u0087\u0088\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001AW\u0010\u0018\u001A\b\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\u0006\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001A]\u0010\u0019\u001A\b\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052 \u0010\u0006\u001A\u001C\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001Av\u0010\u001A\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0001*\u00020\u0004\"\u0010\b\u0003\u0010\u0013*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0014*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0015\u001A\u0002H\u00132 \u0010\u0006\u001A\u001C\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001Ap\u0010\u001B\u001A\u0002H\u0013\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001\"\u0010\b\u0003\u0010\u0013*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0014*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0015\u001A\u0002H\u00132\u001E\u0010\u0006\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\bø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001AK\u0010\u001C\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u001D0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001A(\u0010\u001F\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001AK\u0010\u001F\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u001D0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001A(\u0010 \u001A\u00020!\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0088\u0004\u001AK\u0010 \u001A\u00020!\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u001D0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001AK\u0010\"\u001A\u00020#\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010$\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020#0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001Al\u0010%\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b(\u001Ai\u0010)\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001AK\u0010*\u001A\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020+0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001AK\u0010*\u001A\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001A`\u0010*\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010-\u001AR\u0010.\u001A\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020+0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010/\u001AR\u0010.\u001A\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00100\u001Ab\u0010.\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010-\u001Ar\u00101\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001A\u00102\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000103j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`42\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00105\u001At\u00106\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001A\u00102\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000103j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`42\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00105\u001Ao\u00107\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u00102\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b03j\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`4H\u0087\u0088\u0004¢\u0006\u0004\b8\u00109\u001Ao\u0010:\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u00102\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b03j\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`4H\u0087\u0088\u0004¢\u0006\u0002\u00109\u001Al\u0010;\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b<\u001Ai\u0010=\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001AK\u0010>\u001A\u00020+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020+0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001AK\u0010>\u001A\u00020,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001A`\u0010>\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010-\u001AR\u0010?\u001A\u0004\u0018\u00010+\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020+0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010/\u001AR\u0010?\u001A\u0004\u0018\u00010,\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020,0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00100\u001Ab\u0010?\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010-\u001Ar\u0010@\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001A\u00102\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000103j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`42\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00105\u001At\u0010A\u001A\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001A\u00102\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000103j\n\u0012\u0006\b\u0000\u0012\u0002H\u0001`42\u001E\u0010\'\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u0002H\u00010\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u00105\u001Ao\u0010B\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u00102\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b03j\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`4H\u0087\u0088\u0004¢\u0006\u0004\bC\u00109\u001Ao\u0010D\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000522\u00102\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b03j\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b`4H\u0087\u0088\u0004¢\u0006\u0002\u00109\u001A(\u0010E\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001AK\u0010E\u001A\u00020\u001D\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u001E\u0010\u001E\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020\u001D0\u0007H\u0086\u0088\u0004ø\u0001\u0000\u001AZ\u0010F\u001A\u0002HG\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010G*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005*\u0002HG2\u001E\u0010$\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020#0\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010H\u001Ao\u0010I\u001A\u0002HG\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010G*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005*\u0002HG23\u0010$\u001A/\u0012\u0013\u0012\u00110!¢\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(M\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b\u0012\u0004\u0012\u00020#0JH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010N\u001A:\u0010O\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0\u000F\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0088\u0004\u001A:\u0010P\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\b0\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006Q"}, d2={"firstNotNullOf", "R", "K", "V", "", "", "transform", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "toList", "", "Lkotlin/Pair;", "flatMap", "", "Lkotlin/sequences/Sequence;", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "map", "mapNotNull", "mapNotNullTo", "mapTo", "all", "", "predicate", "any", "count", "", "forEach", "", "action", "maxBy", "", "selector", "maxByOrThrow", "maxByOrNull", "maxOf", "", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrThrow", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/Map$Entry;", "maxWithOrNull", "minBy", "minByOrThrow", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrThrow", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "asIterable", "asSequence", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/MapsKt") class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public MapsKt___MapsKt() {
        super();
    }

    public static final boolean all(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        if(arg2.isEmpty()) {
            return 1;
        }

        Iterator v2 = arg2.entrySet().iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(arg3.invoke(v2.next()).booleanValue());

        return 0;
    }

    public static final boolean any(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty() ^ 1;
    }

    public static final boolean any(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        if(arg2.isEmpty()) {
            return 0;
        }

        Iterator v2 = arg2.entrySet().iterator();
        do {
            if(!v2.hasNext()) {
                return 0;
            }
        }
        while(!arg3.invoke(v2.next()).booleanValue());

        return 1;
    }

    private static final Iterable asIterable(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.entrySet();
    }

    public static final Sequence asSequence(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.asSequence(arg1.entrySet());
    }

    private static final int count(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size();
    }

    public static final int count(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        int v1 = 0;
        if(arg2.isEmpty()) {
            return 0;
        }

        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            if(!arg3.invoke(v2.next()).booleanValue()) {
                continue;
            }

            ++v1;
        }

        return v1;
    }

    private static final Object firstNotNullOf(Map arg1, Function1 arg2) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        while(true) {
            if(v1.hasNext()) {
                v0 = arg2.invoke(v1.next());
                if(v0 == null) {
                    continue;
                }
            }
            else {
                break;
            }

            goto label_13;
        }

        v0 = null;
    label_13:
        if(v0 != null) {
            return v0;
        }

        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    private static final Object firstNotNullOfOrNull(Map arg1, Function1 arg2) {
        Object v0;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        do {
            if(!v1.hasNext()) {
                return null;
            }

            v0 = arg2.invoke(v1.next());
        }
        while(v0 == null);

        return v0;
    }

    public static final List flatMap(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        ArrayList v0 = new ArrayList();
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            CollectionsKt.addAll(((Collection)v0), arg3.invoke(v2.next()));
        }

        return ((List)v0);
    }

    public static final List flatMapSequence(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        ArrayList v0 = new ArrayList();
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            CollectionsKt.addAll(((Collection)v0), arg3.invoke(v2.next()));
        }

        return ((List)v0);
    }

    @IgnorableReturnValue public static final Collection flatMapSequenceTo(Map arg1, Collection arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        while(v1.hasNext()) {
            CollectionsKt.addAll(arg2, arg3.invoke(v1.next()));
        }

        return arg2;
    }

    @IgnorableReturnValue public static final Collection flatMapTo(Map arg1, Collection arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        while(v1.hasNext()) {
            CollectionsKt.addAll(arg2, arg3.invoke(v1.next()));
        }

        return arg2;
    }

    public static final void forEach(Map arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "action");
        Iterator v1 = arg1.entrySet().iterator();
        while(v1.hasNext()) {
            arg2.invoke(v1.next());
        }
    }

    public static final List map(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        ArrayList v0 = new ArrayList(arg2.size());
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            ((Collection)v0).add(arg3.invoke(v2.next()));
        }

        return ((List)v0);
    }

    public static final List mapNotNull(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        ArrayList v0 = new ArrayList();
        Iterator v2 = arg2.entrySet().iterator();
        while(v2.hasNext()) {
            Object v1 = arg3.invoke(v2.next());
            if(v1 == null) {
                continue;
            }

            ((Collection)v0).add(v1);
        }

        return ((List)v0);
    }

    @IgnorableReturnValue public static final Collection mapNotNullTo(Map arg1, Collection arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        while(v1.hasNext()) {
            Object v0 = arg3.invoke(v1.next());
            if(v0 == null) {
                continue;
            }

            arg2.add(v0);
        }

        return arg2;
    }

    @IgnorableReturnValue public static final Collection mapTo(Map arg1, Collection arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        Intrinsics.checkNotNullParameter(arg3, "transform");
        Iterator v1 = arg1.entrySet().iterator();
        while(v1.hasNext()) {
            arg2.add(arg3.invoke(v1.next()));
        }

        return arg2;
    }

    private static final Map$Entry maxByOrNull(Map arg5, Function1 arg6) {
        Object v5_2;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(!v5.hasNext()) {
            Map$Entry v5_1 = null;
        }
        else {
            Object v0 = v5.next();
            if(v5.hasNext()) {
                Object v1 = arg6.invoke(v0);
                do {
                    Object v2 = v5.next();
                    Object v3 = arg6.invoke(v2);
                    if(((Comparable)v1).compareTo(v3) < 0) {
                        v0 = v2;
                        v1 = v3;
                    }
                }
                while(v5.hasNext());
            }

            v5_2 = v0;
        }

        return ((Map$Entry)v5_2);
    }

    private static final Map$Entry maxByOrThrow(Map arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(v5.hasNext()) {
            Object v0 = v5.next();
            if(!v5.hasNext()) {
            }
            else {
                Object v1 = arg6.invoke(v0);
                do {
                    Object v2 = v5.next();
                    Object v3 = arg6.invoke(v2);
                    if(((Comparable)v1).compareTo(v3) < 0) {
                        v0 = v2;
                        v1 = v3;
                    }

                    if(v5.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }

            return ((Map$Entry)v0);
        }

        throw new NoSuchElementException();
    }

    private static final double maxOf(Map arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v4 = arg4.entrySet().iterator();
        if(v4.hasNext()) {
            double v0;
            for(v0 = arg5.invoke(v4.next()).doubleValue(); v4.hasNext(); v0 = Math.max(v0, arg5.invoke(v4.next()).doubleValue())) {
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final float maxOf(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        Iterator v2 = arg2.entrySet().iterator();
        if(v2.hasNext()) {
            float v0;
            for(v0 = arg3.invoke(v2.next()).floatValue(); v2.hasNext(); v0 = Math.max(v0, arg3.invoke(v2.next()).floatValue())) {
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final Comparable maxOf(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(v3.hasNext()) {
            Object v0;
            for(v0 = arg4.invoke(v3.next()); v3.hasNext(); v0 = v1) {
                Object v1 = arg4.invoke(v3.next());
                if(((Comparable)v0).compareTo(v1) >= 0) {
                    continue;
                }
            }

            return ((Comparable)v0);
        }

        throw new NoSuchElementException();
    }

    private static final Comparable maxOfOrNull(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(!v3.hasNext()) {
            return null;
        }

        Object v0;
        for(v0 = arg4.invoke(v3.next()); v3.hasNext(); v0 = v1) {
            Object v1 = arg4.invoke(v3.next());
            if(((Comparable)v0).compareTo(v1) >= 0) {
                continue;
            }
        }

        return ((Comparable)v0);
    }

    private static final Double maxOfOrNull(Map arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v4 = arg4.entrySet().iterator();
        if(!v4.hasNext()) {
            return null;
        }

        double v0;
        for(v0 = arg5.invoke(v4.next()).doubleValue(); v4.hasNext(); v0 = Math.max(v0, arg5.invoke(v4.next()).doubleValue())) {
        }

        return Double.valueOf(v0);
    }

    private static final Float maxOfOrNull(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        Iterator v2 = arg2.entrySet().iterator();
        if(!v2.hasNext()) {
            return null;
        }

        float v0;
        for(v0 = arg3.invoke(v2.next()).floatValue(); v2.hasNext(); v0 = Math.max(v0, arg3.invoke(v2.next()).floatValue())) {
        }

        return Float.valueOf(v0);
    }

    private static final Object maxOfWith(Map arg3, Comparator arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(v3.hasNext()) {
            Object v0;
            for(v0 = arg5.invoke(v3.next()); v3.hasNext(); v0 = v1) {
                Object v1 = arg5.invoke(v3.next());
                if(arg4.compare(v0, v1) >= 0) {
                    continue;
                }
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final Object maxOfWithOrNull(Map arg3, Comparator arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(!v3.hasNext()) {
            return null;
        }

        Object v0;
        for(v0 = arg5.invoke(v3.next()); v3.hasNext(); v0 = v1) {
            Object v1 = arg5.invoke(v3.next());
            if(arg4.compare(v0, v1) >= 0) {
                continue;
            }
        }

        return v0;
    }

    private static final Map$Entry maxWithOrNull(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.maxWithOrNull(arg1.entrySet(), arg2);
    }

    private static final Map$Entry maxWithOrThrow(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.maxWithOrThrow(arg1.entrySet(), arg2);
    }

    private static final Map$Entry minByOrNull(Map arg5, Function1 arg6) {
        Object v5_2;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(!v5.hasNext()) {
            Map$Entry v5_1 = null;
        }
        else {
            Object v0 = v5.next();
            if(v5.hasNext()) {
                Object v1 = arg6.invoke(v0);
                do {
                    Object v2 = v5.next();
                    Object v3 = arg6.invoke(v2);
                    if(((Comparable)v1).compareTo(v3) > 0) {
                        v0 = v2;
                        v1 = v3;
                    }
                }
                while(v5.hasNext());
            }

            v5_2 = v0;
        }

        return ((Map$Entry)v5_2);
    }

    private static final Map$Entry minByOrThrow(Map arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(v5.hasNext()) {
            Object v0 = v5.next();
            if(!v5.hasNext()) {
            }
            else {
                Object v1 = arg6.invoke(v0);
                do {
                    Object v2 = v5.next();
                    Object v3 = arg6.invoke(v2);
                    if(((Comparable)v1).compareTo(v3) > 0) {
                        v0 = v2;
                        v1 = v3;
                    }

                    if(v5.hasNext()) {
                        continue;
                    }

                    break;
                }
                while(true);
            }

            return ((Map$Entry)v0);
        }

        throw new NoSuchElementException();
    }

    private static final double minOf(Map arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v4 = arg4.entrySet().iterator();
        if(v4.hasNext()) {
            double v0;
            for(v0 = arg5.invoke(v4.next()).doubleValue(); v4.hasNext(); v0 = Math.min(v0, arg5.invoke(v4.next()).doubleValue())) {
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final float minOf(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        Iterator v2 = arg2.entrySet().iterator();
        if(v2.hasNext()) {
            float v0;
            for(v0 = arg3.invoke(v2.next()).floatValue(); v2.hasNext(); v0 = Math.min(v0, arg3.invoke(v2.next()).floatValue())) {
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final Comparable minOf(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(v3.hasNext()) {
            Object v0;
            for(v0 = arg4.invoke(v3.next()); v3.hasNext(); v0 = v1) {
                Object v1 = arg4.invoke(v3.next());
                if(((Comparable)v0).compareTo(v1) <= 0) {
                    continue;
                }
            }

            return ((Comparable)v0);
        }

        throw new NoSuchElementException();
    }

    private static final Comparable minOfOrNull(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(!v3.hasNext()) {
            return null;
        }

        Object v0;
        for(v0 = arg4.invoke(v3.next()); v3.hasNext(); v0 = v1) {
            Object v1 = arg4.invoke(v3.next());
            if(((Comparable)v0).compareTo(v1) <= 0) {
                continue;
            }
        }

        return ((Comparable)v0);
    }

    private static final Double minOfOrNull(Map arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v4 = arg4.entrySet().iterator();
        if(!v4.hasNext()) {
            return null;
        }

        double v0;
        for(v0 = arg5.invoke(v4.next()).doubleValue(); v4.hasNext(); v0 = Math.min(v0, arg5.invoke(v4.next()).doubleValue())) {
        }

        return Double.valueOf(v0);
    }

    private static final Float minOfOrNull(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        Iterator v2 = arg2.entrySet().iterator();
        if(!v2.hasNext()) {
            return null;
        }

        float v0;
        for(v0 = arg3.invoke(v2.next()).floatValue(); v2.hasNext(); v0 = Math.min(v0, arg3.invoke(v2.next()).floatValue())) {
        }

        return Float.valueOf(v0);
    }

    private static final Object minOfWith(Map arg3, Comparator arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(v3.hasNext()) {
            Object v0;
            for(v0 = arg5.invoke(v3.next()); v3.hasNext(); v0 = v1) {
                Object v1 = arg5.invoke(v3.next());
                if(arg4.compare(v0, v1) <= 0) {
                    continue;
                }
            }

            return v0;
        }

        throw new NoSuchElementException();
    }

    private static final Object minOfWithOrNull(Map arg3, Comparator arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        Iterator v3 = arg3.entrySet().iterator();
        if(!v3.hasNext()) {
            return null;
        }

        Object v0;
        for(v0 = arg5.invoke(v3.next()); v3.hasNext(); v0 = v1) {
            Object v1 = arg5.invoke(v3.next());
            if(arg4.compare(v0, v1) <= 0) {
                continue;
            }
        }

        return v0;
    }

    private static final Map$Entry minWithOrNull(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.minWithOrNull(arg1.entrySet(), arg2);
    }

    private static final Map$Entry minWithOrThrow(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.minWithOrThrow(arg1.entrySet(), arg2);
    }

    public static final boolean none(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty();
    }

    public static final boolean none(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "predicate");
        if(arg2.isEmpty()) {
            return 1;
        }

        Iterator v2 = arg2.entrySet().iterator();
        do {
            if(!v2.hasNext()) {
                return 1;
            }
        }
        while(!arg3.invoke(v2.next()).booleanValue());

        return 0;
    }

    public static final Map onEach(Map arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "action");
        Iterator v0 = arg2.entrySet().iterator();
        while(v0.hasNext()) {
            arg3.invoke(v0.next());
        }

        return arg2;
    }

    public static final Map onEachIndexed(Map arg4, Function2 arg5) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        Iterator v0 = arg4.entrySet().iterator();
        int v1;
        for(v1 = 0; v0.hasNext(); v1 = v3) {
            Object v2 = v0.next();
            int v3 = v1 + 1;
            if(v1 < 0) {
                CollectionsKt.throwIndexOverflow();
            }

            arg5.invoke(Integer.valueOf(v1), v2);
        }

        return arg4;
    }

    public static final List toList(Map arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(arg4.size() == 0) {
            return CollectionsKt.emptyList();
        }

        Iterator v0 = arg4.entrySet().iterator();
        if(!v0.hasNext()) {
            return CollectionsKt.emptyList();
        }

        Object v1 = v0.next();
        if(!v0.hasNext()) {
            return CollectionsKt.listOf(new Pair(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue()));
        }

        ArrayList v2 = new ArrayList(arg4.size());
        v2.add(new Pair(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue()));
        do {
            Object v4 = v0.next();
            v2.add(new Pair(((Map$Entry)v4).getKey(), ((Map$Entry)v4).getValue()));
        }
        while(v0.hasNext());

        return ((List)v2);
    }
}

