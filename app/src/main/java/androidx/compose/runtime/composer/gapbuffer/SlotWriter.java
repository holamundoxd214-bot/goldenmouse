package androidx.compose.runtime.composer.gapbuffer;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberObserverHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u001A\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u001A\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0001\u0018\u0000 Û\u00012\u00020\u0001:\u0002Û\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u00103\u001A\u00020/2\u0006\u00108\u001A\u00020\u0019J\u000E\u0010!\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J\u000E\u00109\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J\u0010\u0010:\u001A\u0004\u0018\u00010\u00012\u0006\u00108\u001A\u00020\u0019J\u000E\u0010;\u001A\u00020/2\u0006\u00108\u001A\u00020\u0019J\u000E\u0010<\u001A\u00020/2\u0006\u00108\u001A\u00020\u0019J\u000E\u0010=\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J\u0010\u0010>\u001A\u0004\u0018\u00010\u00012\u0006\u00108\u001A\u00020\u0019J\u000E\u0010?\u001A\u00020/2\u0006\u00108\u001A\u00020\u0019J\u000E\u0010@\u001A\u00020/2\u0006\u00108\u001A\u00020\u0019J\u0016\u0010A\u001A\u00020/2\u0006\u00108\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u0019J\u0010\u0010C\u001A\u0004\u0018\u00010\u00012\u0006\u00108\u001A\u00020\u0019J\u0010\u0010C\u001A\u0004\u0018\u00010\u00012\u0006\u0010D\u001A\u00020\u000FJ\u000E\u0010E\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J\u000E\u0010E\u001A\u00020\u00192\u0006\u0010D\u001A\u00020\u000FJ\u000E\u0010I\u001A\u00020J2\u0006\u0010K\u001A\u00020/J\u0006\u0010L\u001A\u00020JJ\u0012\u0010M\u001A\u0004\u0018\u00010\u00012\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0014\u0010N\u001A\u0004\u0018\u00010\u00012\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u0002J\u0018\u0010O\u001A\u00020J2\u0006\u0010D\u001A\u00020\u000F2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u000E\u0010P\u001A\u00020J2\u0006\u0010Q\u001A\u00020\u0019J\u0010\u0010R\u001A\u00020J2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0010\u0010S\u001A\u00020J2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0006\u0010T\u001A\u00020JJ\u000E\u0010U\u001A\u00020J2\u0006\u0010V\u001A\u00020WJ\u0016\u0010X\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\u0006\u0010(\u001A\u00020WJ\u0006\u0010Z\u001A\u00020JJ\u001C\u0010[\u001A\u0004\u0018\u00010\u00132\u0006\u0010E\u001A\u00020\u00192\b\u0010V\u001A\u0004\u0018\u00010WH\u0002J\u0010\u0010\\\u001A\u00020J2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0018\u0010\\\u001A\u00020J2\u0006\u0010D\u001A\u00020\u000F2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0010\u0010]\u001A\u00020J2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0010\u0010^\u001A\u00020J2\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u001D\u0010^\u001A\u0004\u0018\u00010\u00012\u0006\u00108\u001A\u00020\u00192\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u0086\bJ\u0016\u0010_\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J\"\u0010^\u001A\u0004\u0018\u00010\u00012\u0006\u0010B\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u00192\b\u0010(\u001A\u0004\u0018\u00010\u0001J\u0010\u0010`\u001A\u0004\u0018\u00010\u00012\u0006\u0010a\u001A\u00020\u0019J\b\u0010b\u001A\u0004\u0018\u00010\u0001J\u0018\u0010c\u001A\u0004\u0018\u00010\u00012\u0006\u0010D\u001A\u00020\u000F2\u0006\u00108\u001A\u00020\u0019J\u0018\u0010c\u001A\u0004\u0018\u00010\u00012\u0006\u0010d\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019J5\u0010e\u001A\u00020J2\u0006\u0010d\u001A\u00020\u00192\u0006\u0010Q\u001A\u00020\u00192\u001A\u0010f\u001A\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020J0gH\u0086\bJ\u0015\u0010h\u001A\u00020\u00192\u0006\u0010d\u001A\u00020\u0019H\u0000¢\u0006\u0002\biJ\u0015\u0010j\u001A\u00020\u00192\u0006\u0010d\u001A\u00020\u0019H\u0000¢\u0006\u0002\bkJ\u0015\u0010l\u001A\u00020\u00192\u0006\u0010d\u001A\u00020\u0019H\u0000¢\u0006\u0002\bmJ\u000E\u0010p\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u0019J\u000E\u0010q\u001A\u00020J2\u0006\u0010r\u001A\u00020\u0019J\u000E\u0010s\u001A\u00020J2\u0006\u0010D\u001A\u00020\u000FJ\u0006\u0010t\u001A\u00020JJ\u0006\u0010u\u001A\u00020JJ\u0006\u0010v\u001A\u00020JJ\u0006\u0010w\u001A\u00020JJ\u000E\u0010w\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u0019J\u0018\u0010w\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010x\u001A\u0004\u0018\u00010\u0001J\u0018\u0010y\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010z\u001A\u0004\u0018\u00010\u0001J\"\u0010y\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010z\u001A\u0004\u0018\u00010\u00012\b\u0010C\u001A\u0004\u0018\u00010\u0001J\"\u0010{\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010z\u001A\u0004\u0018\u00010\u00012\b\u0010|\u001A\u0004\u0018\u00010\u0001J\u0018\u0010{\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010|\u001A\u0004\u0018\u00010\u0001J,\u0010w\u001A\u00020J2\u0006\u0010Y\u001A\u00020\u00192\b\u0010z\u001A\u0004\u0018\u00010\u00012\u0006\u00103\u001A\u00020/2\b\u0010|\u001A\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010}\u001A\u00020\u0019J\u000E\u0010~\u001A\u00020J2\u0006\u00108\u001A\u00020\u0019J\u000E\u0010~\u001A\u00020J2\u0006\u0010D\u001A\u00020\u000FJ\u0006\u0010\u007F\u001A\u00020\u0019J\u0007\u0010\u0080\u0001\u001A\u00020/J\u0010\u0010\u0081\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0082\u0001JQ\u0010\u0083\u0001\u001A\u00020J2\u0006\u0010B\u001A\u00020\u00192=\u0010f\u001A9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000E\b\u0084\u0001\u0012\t\b\u0085\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000F\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020J0gH\u0086\bJb\u0010\u0087\u0001\u001A\u00020J2\u0006\u0010B\u001A\u00020\u00192&\u0010\u0088\u0001\u001A!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000F\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u008A\u0001\u0012\u0004\u0012\u00020J0\u0089\u00012&\u0010\u008B\u0001\u001A!\u0012\u0016\u0012\u00140\u0019¢\u0006\u000F\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u008A\u0001\u0012\u0004\u0012\u00020J0\u0089\u0001H\u0086\bJN\u0010\u008C\u0001\u001A\u00020J2\u0006\u0010B\u001A\u00020\u00192=\u0010f\u001A9\u0012\u0015\u0012\u00130\u0019¢\u0006\u000E\b\u0084\u0001\u0012\t\b\u0085\u0001\u0012\u0004\b\b(8\u0012\u0018\u0012\u0016\u0018\u00010\u0001¢\u0006\u000F\b\u0084\u0001\u0012\n\b\u0085\u0001\u0012\u0005\b\b(\u0086\u0001\u0012\u0004\u0012\u00020J0gJ\u0019\u0010\u008D\u0001\u001A\u00020\u00192\u0006\u0010E\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019H\u0002J\u0010\u0010\u008E\u0001\u001A\u00020J2\u0007\u0010\u008F\u0001\u001A\u00020\u0019J\u0018\u0010\u0090\u0001\u001A\u00020/2\u0007\u0010\u0091\u0001\u001A\u00020\u000F2\u0006\u0010D\u001A\u00020\u000FJ(\u0010\u0092\u0001\u001A\t\u0012\u0004\u0012\u00020\u000F0\u0093\u00012\u0006\u0010D\u001A\u00020\u000F2\u0007\u0010\u008F\u0001\u001A\u00020\u00192\u0007\u0010\u0094\u0001\u001A\u00020\u0000J)\u0010\u0095\u0001\u001A\t\u0012\u0004\u0012\u00020\u000F0\u0093\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u00108\u001A\u00020\u00192\t\b\u0002\u0010\u0096\u0001\u001A\u00020/J\u0007\u0010\u0097\u0001\u001A\u00020JJ\'\u0010\u0098\u0001\u001A\t\u0012\u0004\u0012\u00020\u000F0\u0093\u00012\u0007\u0010\u008F\u0001\u001A\u00020\u00192\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u00108\u001A\u00020\u0019J\u0010\u0010D\u001A\u00020\u000F2\b\b\u0002\u00108\u001A\u00020\u0019J\u0011\u0010\u0099\u0001\u001A\u00020J2\b\b\u0002\u0010B\u001A\u00020\u0019J\u0011\u0010\u009A\u0001\u001A\u00020/2\u0006\u0010B\u001A\u00020\u0019H\u0002J\u0011\u0010\u009B\u0001\u001A\u00020/2\u0006\u0010B\u001A\u00020\u0019H\u0002J\t\u0010\u009F\u0001\u001A\u00020JH\u0002J\u0011\u0010 \u0001\u001A\u00020J2\u0006\u0010B\u001A\u00020\u0019H\u0002J#\u0010¡\u0001\u001A\u00020J2\u0006\u0010B\u001A\u00020\u00192\u0007\u0010^\u001A\u00030\u009D\u0001H\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0011\u0010¤\u0001\u001A\u00020/2\u0006\u0010B\u001A\u00020\u0019H\u0002J\u000F\u0010¥\u0001\u001A\u00020\u00192\u0006\u0010D\u001A\u00020\u000FJ\t\u0010¦\u0001\u001A\u00020WH\u0016J\t\u0010§\u0001\u001A\u00020JH\u0002J\t\u0010¨\u0001\u001A\u00020\u0019H\u0002J\"\u0010©\u0001\u001A\u00020J2\u0006\u0010E\u001A\u00020\u00192\u0006\u0010}\u001A\u00020\u00192\u0007\u0010ª\u0001\u001A\u00020\u0019H\u0002J\u0011\u0010«\u0001\u001A\u00020J2\u0006\u00108\u001A\u00020\u0019H\u0002J\u0019\u0010¬\u0001\u001A\u00020J2\u0006\u00108\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u0019H\u0002J\t\u0010­\u0001\u001A\u00020JH\u0002J\u0012\u0010®\u0001\u001A\u00020J2\u0007\u0010¯\u0001\u001A\u00020\u0019H\u0002J\u001A\u0010°\u0001\u001A\u00020J2\u0007\u0010¯\u0001\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u0019H\u0002J\u001B\u0010±\u0001\u001A\u00020/2\u0007\u0010²\u0001\u001A\u00020\u00192\u0007\u0010³\u0001\u001A\u00020\u0019H\u0002J\u0019\u0010´\u0001\u001A\u0004\u0018\u00010\u00132\u0006\u0010B\u001A\u00020\u0019H\u0000¢\u0006\u0003\bµ\u0001J\u0019\u0010¶\u0001\u001A\u0004\u0018\u00010\u000F2\u0006\u0010B\u001A\u00020\u0019H\u0000¢\u0006\u0003\b·\u0001J#\u0010¸\u0001\u001A\u00020J2\u0007\u0010²\u0001\u001A\u00020\u00192\u0007\u0010³\u0001\u001A\u00020\u00192\u0006\u0010B\u001A\u00020\u0019H\u0002J\u001B\u0010¹\u0001\u001A\u00020J2\u0006\u00108\u001A\u00020\u00192\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u0002J\u001B\u0010º\u0001\u001A\u00020J2\u0007\u0010»\u0001\u001A\u00020\u00192\u0007\u0010¼\u0001\u001A\u00020\u0019H\u0002JC\u0010½\u0001\u001A\u00020/2\u0007\u0010¾\u0001\u001A\u00020\u00192\u0007\u0010¯\u0001\u001A\u00020\u00192&\u0010\u0011\u001A\"\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002J$\u0010¿\u0001\u001A\u00020J2\u0007\u0010À\u0001\u001A\u00020\u00192\u0007\u0010Á\u0001\u001A\u00020\u00192\u0007\u0010¯\u0001\u001A\u00020\u0019H\u0002J\u0007\u0010Â\u0001\u001A\u00020WJ\u001B\u0010Ã\u0001\u001A\u00020J*\b0Ä\u0001j\u0003`Å\u00012\u0006\u00108\u001A\u00020\u0019H\u0002J\u000F\u0010Æ\u0001\u001A\u00020JH\u0000¢\u0006\u0003\bÇ\u0001J\u000F\u0010È\u0001\u001A\u00020JH\u0000¢\u0006\u0003\bÉ\u0001J\u0011\u0010Í\u0001\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019H\u0002J\u0012\u0010Î\u0001\u001A\u00020\u00192\u0007\u0010Ï\u0001\u001A\u00020\u0019H\u0002J\u0014\u0010E\u001A\u00020\u0019*\u00020\t2\u0006\u00108\u001A\u00020\u0019H\u0002J\u0011\u0010Ï\u0001\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019H\u0002J\u0016\u0010Ï\u0001\u001A\u00020\u0019*\u00020\t2\u0007\u0010Ð\u0001\u001A\u00020\u0019H\u0002J\u0015\u0010a\u001A\u00020\u0019*\u00020\t2\u0007\u0010Ð\u0001\u001A\u00020\u0019H\u0002J\u001F\u0010Ñ\u0001\u001A\u00020J*\u00020\t2\u0007\u0010Ð\u0001\u001A\u00020\u00192\u0007\u0010Ï\u0001\u001A\u00020\u0019H\u0002J\u0016\u0010Ò\u0001\u001A\u00020\u0019*\u00020\t2\u0007\u0010Ð\u0001\u001A\u00020\u0019H\u0002J\u0016\u0010Ó\u0001\u001A\u00020\u0019*\u00020\t2\u0007\u0010Ð\u0001\u001A\u00020\u0019H\u0002J\u0014\u0010Ô\u0001\u001A\t\u0012\u0004\u0012\u00020\u00190\u0093\u0001*\u00020\tH\u0002J\u0010\u0010Õ\u0001\u001A\t\u0012\u0004\u0012\u00020\u00190\u0093\u0001H\u0002J,\u0010Ö\u0001\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u00192\u0007\u0010¾\u0001\u001A\u00020\u00192\u0007\u0010×\u0001\u001A\u00020\u00192\u0007\u0010Ë\u0001\u001A\u00020\u0019H\u0002J#\u0010Ø\u0001\u001A\u00020\u00192\u0006\u0010D\u001A\u00020\u00192\u0007\u0010×\u0001\u001A\u00020\u00192\u0007\u0010Ë\u0001\u001A\u00020\u0019H\u0002J\u001A\u0010Ù\u0001\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u00192\u0007\u0010¾\u0001\u001A\u00020\u0019H\u0002J\u0011\u0010Ú\u0001\u001A\u00020\u00192\u0006\u00108\u001A\u00020\u0019H\u0002R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000BX\u0082\u000E¢\u0006\u0004\n\u0002\u0010\fR\u001E\u0010\r\u001A\u0012\u0012\u0004\u0012\u00020\u000F0\u000Ej\b\u0012\u0004\u0012\u00020\u000F`\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R.\u0010\u0011\u001A\"\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0019X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001E\u0010&\u001A\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\'\u0018\u00010\u0016X\u0082\u000E¢\u0006\u0002\n\u0000R\u001E\u0010)\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u0019@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b*\u0010+R\u001E\u0010,\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u0019@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b-\u0010+R\u0011\u0010.\u001A\u00020/8F¢\u0006\u0006\u001A\u0004\b.\u00100R\u0011\u00101\u001A\u00020\u00198F¢\u0006\u0006\u001A\u0004\b2\u0010+R\u0011\u00103\u001A\u00020/8F¢\u0006\u0006\u001A\u0004\b3\u00100R\u0011\u00104\u001A\u00020/8F¢\u0006\u0006\u001A\u0004\b5\u00100R\u0011\u00106\u001A\u00020/8F¢\u0006\u0006\u001A\u0004\b7\u00100R\u001E\u0010E\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\u0019@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\bF\u0010+R\u001E\u0010G\u001A\u00020/2\u0006\u0010(\u001A\u00020/@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\bH\u00100R\u0014\u0010n\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\bo\u0010+R\u0015\u0010\u009C\u0001\u001A\u0005\u0018\u00010\u009D\u0001X\u0082\u000E¢\u0006\u0005\n\u0003\u0010\u009E\u0001R\u0016\u0010¯\u0001\u001A\u00020\u00198@X\u0080\u0004¢\u0006\u0007\u001A\u0005\bÊ\u0001\u0010+R\u0016\u0010Ë\u0001\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001A\u0005\bÌ\u0001\u0010+¨\u0006Ü\u0001"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "", "table", "Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "<init>", "(Landroidx/compose/runtime/composer/gapbuffer/SlotTable;)V", "getTable$runtime", "()Landroidx/compose/runtime/composer/gapbuffer/SlotTable;", "groups", "", "slots", "", "[Ljava/lang/Object;", "anchors", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "Lkotlin/collections/ArrayList;", "sourceInformationMap", "Ljava/util/HashMap;", "Landroidx/compose/runtime/composer/gapbuffer/GapGroupSourceInformation;", "Lkotlin/collections/HashMap;", "calledByMap", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "groupGapStart", "", "groupGapLen", "currentSlot", "currentSlotEnd", "slotsGapStart", "slotsGapLen", "slotsGapOwner", "insertCount", "nodeCount", "startStack", "Landroidx/compose/runtime/IntStack;", "endStack", "nodeCountStack", "deferredSlotWrites", "Landroidx/collection/MutableObjectList;", "value", "currentGroup", "getCurrentGroup", "()I", "currentGroupEnd", "getCurrentGroupEnd", "isGroupEnd", "", "()Z", "slotsSize", "getSlotsSize", "isNode", "collectingSourceInformation", "getCollectingSourceInformation", "collectingCalledInformation", "getCollectingCalledInformation", "index", "groupKey", "groupObjectKey", "isValid", "hasObjectKey", "groupSize", "groupAux", "indexInParent", "indexInCurrentGroup", "indexInGroup", "group", "node", "anchor", "parent", "getParent", "closed", "getClosed", "close", "", "normalClose", "reset", "update", "rawUpdate", "appendSlot", "trimTailSlots", "count", "updateAux", "insertAux", "updateToTableMaps", "recordGroupSourceInformation", "sourceInformation", "", "recordGrouplessCallSourceInformationStart", "key", "recordGrouplessCallSourceInformationEnd", "groupSourceInformationFor", "updateNode", "updateParentNode", "set", "slotIndexOfGroupSlotIndex", "clear", "slotIndex", "skip", "slot", "groupIndex", "forEachTailSlot", "block", "Lkotlin/Function2;", "slotsStartIndex", "slotsStartIndex$runtime", "slotsEndIndex", "slotsEndIndex$runtime", "slotsEndAllIndex", "slotsEndAllIndex$runtime", "currentGroupSlotIndex", "getCurrentGroupSlotIndex", "groupSlotIndex", "advanceBy", "amount", "seek", "skipToGroupEnd", "beginInsert", "endInsert", "startGroup", "dataKey", "startNode", "objectKey", "startData", "aux", "endGroup", "ensureStarted", "skipGroup", "removeGroup", "groupSlots", "", "forAllData", "Lkotlin/ParameterName;", "name", "data", "traverseGroupAndChildren", "enter", "Lkotlin/Function1;", "child", "exit", "forAllDataInRememberOrder", "childGroupAtIndex", "moveGroup", "offset", "inGroup", "groupAnchor", "moveTo", "", "writer", "moveFrom", "removeSourceGroup", "bashCurrentGroup", "moveIntoGroupFrom", "markGroup", "containsGroupMark", "containsAnyGroupMarks", "pendingRecalculateMarks", "Landroidx/compose/runtime/composer/gapbuffer/PrioritySet;", "Landroidx/collection/MutableIntList;", "recalculateMarks", "updateContainsMark", "updateContainsMarkNow", "updateContainsMarkNow-qrM0pCk", "(ILandroidx/collection/MutableIntList;)V", "childContainsAnyMarks", "anchorIndex", "toString", "saveCurrentGroupEnd", "restoreCurrentGroupEnd", "fixParentAnchorsFor", "firstChild", "moveGroupGapTo", "moveSlotGapTo", "clearSlotGap", "insertGroups", "size", "insertSlots", "removeGroups", "start", "len", "sourceInformationOf", "sourceInformationOf$runtime", "tryAnchor", "tryAnchor$runtime", "removeSlots", "updateNodeOfGroup", "updateAnchors", "previousGapStart", "newGapStart", "removeAnchors", "gapStart", "moveAnchors", "originalLocation", "newLocation", "toDebugString", "groupAsString", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "verifyDataAnchors", "verifyDataAnchors$runtime", "verifyParentAnchors", "verifyParentAnchors$runtime", "getSize$runtime", "capacity", "getCapacity", "groupIndexToAddress", "dataIndexToDataAddress", "dataIndex", "address", "updateDataIndex", "nodeIndex", "auxIndex", "dataIndexes", "keys", "dataIndexToDataAnchor", "gapLen", "dataAnchorToDataIndex", "parentIndexToAnchor", "parentAnchorToIndex", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class SlotWriter {
    @Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\rH\u0002¨\u0006\u0010"}, d2={"Landroidx/compose/runtime/composer/gapbuffer/SlotWriter$Companion;", "", "<init>", "()V", "moveGroup", "", "Landroidx/compose/runtime/composer/gapbuffer/GapAnchor;", "fromWriter", "Landroidx/compose/runtime/composer/gapbuffer/SlotWriter;", "fromIndex", "", "toWriter", "updateFromCursor", "", "updateToCursor", "removeSourceGroup", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final List access$moveGroup(Companion arg0, SlotWriter arg1, int arg2, SlotWriter arg3, boolean arg4, boolean arg5, boolean arg6) {
            return arg0.moveGroup(arg1, arg2, arg3, arg4, arg5, arg6);
        }

        private final List moveGroup(SlotWriter arg24, int arg25, SlotWriter arg26, boolean arg27, boolean arg28, boolean arg29) {
            boolean v19_1;
            Object v11_1;
            List v9_2;
            ArrayList v9_1;
            ArrayList v8_2;
            int[] v21;
            int v20;
            int v19;
            SlotWriter v0 = arg24;
            int v1 = arg25;
            SlotWriter v2 = arg26;
            int v3 = arg24.groupSize(arg25);
            int v4 = v1 + v3;
            int v5 = arg24.dataIndex(arg25);
            int v6 = v0.dataIndex(v4);
            int v7 = v6 - v5;
            boolean v8 = arg24.containsAnyGroupMarks(arg25);
            v2.insertGroups(v3);
            v2.insertSlots(v7, v2.getCurrentGroup());
            if(v0.groupGapStart < v4) {
                v0.moveGroupGapTo(v4);
            }

            if(v0.slotsGapStart < v6) {
                v0.moveSlotGapTo(v6, v4);
            }

            int[] v6_1 = v2.groups;
            int v9 = v2.getCurrentGroup();
            int v11 = v9 * 5;
            ArraysKt.copyInto(v0.groups, v6_1, v11, v1 * 5, v4 * 5);
            Object[] v10 = v2.slots;
            int v12 = v2.currentSlot;
            System.arraycopy(v0.slots, v5, v10, v12, v7);
            int v13 = v2.getParent();
            v6_1[v11 + 2] = v13;
            int v14 = v9 - v1;
            int v15 = v9 + v3;
            int v16 = v12 - v2.dataIndex(v6_1, v9);
            int v17 = v2.slotsGapOwner;
            boolean v23 = v8;
            int v8_1 = v2.slotsGapLen;
            int v10_1 = v10.length;
            int v18 = v11;
            v11 = v17;
            v17 = v12;
            v12 = v9;
            while(true) {
                v19 = 0;
                if(v12 >= v15) {
                    break;
                }

                if(v12 != v9) {
                    v20 = v12 * 5 + 2;
                    v6_1[v20] += v14;
                }

                v21 = v6_1;
                v6 = v2.dataIndex(v6_1, v12) + v16;
                if(v11 < v12) {
                }
                else {
                    v19 = v2.slotsGapStart;
                }

                v20 = v9;
                v21[v12 * 5 + 4] = v2.dataIndexToDataAnchor(v6, v19, v8_1, v10_1);
                if(v12 == v11) {
                    ++v11;
                }

                ++v12;
                v9 = v20;
                v6_1 = v21;
            }

            v21 = v6_1;
            v2.slotsGapOwner = v11;
            v6 = SlotTableKt.locationOf(v0.anchors, v1, v0.getSize$runtime());
            v4 = SlotTableKt.locationOf(v0.anchors, v4, v0.getSize$runtime());
            if(v6 < v4) {
                v8_2 = v0.anchors;
                v9_1 = new ArrayList(v4 - v6);
                v10_1 = v6;
                goto label_84;
            }
            else {
                v9_2 = CollectionsKt.emptyList();
                goto label_103;
            label_84:
                while(v10_1 < v4) {
                    v11_1 = v8_2.get(v10_1);
                    ((GapAnchor)v11_1).setLocation$runtime(((GapAnchor)v11_1).getLocation$runtime() + v14);
                    v9_1.add(v11_1);
                    ++v10_1;
                }

                v2.anchors.addAll(SlotTableKt.locationOf(v2.anchors, v2.getCurrentGroup(), v2.getSize$runtime()), v9_1);
                v8_2.subList(v6, v4).clear();
            }

        label_103:
            ArrayList v4_1 = ((ArrayList)v9_2);
            if(!((Collection)v4_1).isEmpty()) {
                HashMap v6_2 = v0.sourceInformationMap;
                HashMap v8_3 = v2.sourceInformationMap;
                if(v6_2 != null && v8_3 != null) {
                    v4 = ((Collection)v4_1).size();
                    for(v10_1 = 0; v10_1 < v4; ++v10_1) {
                        v11_1 = v9_2.get(v10_1);
                        Object v12_1 = v6_2.get(v11_1);
                        if(v12_1 != null) {
                            v6_2.remove(v11_1);
                            v8_3.put(v11_1, v12_1);
                        }
                    }
                }
            }

            v4 = v2.getParent();
            GapGroupSourceInformation v6_3 = v2.sourceInformationOf$runtime(v13);
            v8_1 = 1;
            if(v6_3 != null) {
                ++v4;
                v10_1 = v2.getCurrentGroup();
                v11 = -1;
                while(v4 < v10_1) {
                    v11 = v4;
                    v4 = SlotTableKt.groupSize(v2.groups, v4) + v4;
                }

                v6_3.addGroupAfter(v2, v11, v10_1);
            }

            v4 = arg24.parent(arg25);
            if(!arg29) {
            }
            else if(arg27) {
                if(v4 >= 0) {
                    v19 = 1;
                }

                if(v19 != 0) {
                    v0.startGroup();
                    v0.advanceBy(v4 - v0.getCurrentGroup());
                    v0.startGroup();
                }

                v0.advanceBy(v1 - v0.getCurrentGroup());
                boolean v1_1 = v0.removeGroup();
                if(v19 != 0) {
                    v0.skipToGroupEnd();
                    v0.endGroup();
                    v0.skipToGroupEnd();
                    v0.endGroup();
                }

                v19_1 = v1_1;
            }
            else {
                v19_1 = v0.removeGroups(v1, v3);
                v0.removeSlots(v5, v7, v1 - 1);
            }

            if(v19_1) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }

            int v0_1 = v2.nodeCount;
            v1 = v21[v18 + 1];
            if((0x40000000 & v1) != 0) {
            }
            else {
                v8_1 = v1 & 0x3FFFFFF;
            }

            v2.nodeCount = v0_1 + v8_1;
            if(arg28) {
                v2.currentGroup = v15;
                v2.currentSlot = v17 + v7;
            }

            if(v23) {
                v2.updateContainsMark(v13);
            }

            return v9_2;
        }

        static List moveGroup$default(Companion arg7, SlotWriter arg8, int arg9, SlotWriter arg10, boolean arg11, boolean arg12, boolean arg13, int arg14, Object arg15) {
            return arg7.moveGroup(arg8, arg9, arg10, arg11, arg12, true);
        }
    }

    public static final int $stable;
    public static final Companion Companion;
    private ArrayList anchors;
    private MutableIntObjectMap calledByMap;
    private boolean closed;
    private int currentGroup;
    private int currentGroupEnd;
    private int currentSlot;
    private int currentSlotEnd;
    private MutableIntObjectMap deferredSlotWrites;
    private final IntStack endStack;
    private int groupGapLen;
    private int groupGapStart;
    private int[] groups;
    private int insertCount;
    private int nodeCount;
    private final IntStack nodeCountStack;
    private int parent;
    private MutableIntList pendingRecalculateMarks;
    private Object[] slots;
    private int slotsGapLen;
    private int slotsGapOwner;
    private int slotsGapStart;
    private HashMap sourceInformationMap;
    private final IntStack startStack;
    private final SlotTable table;

    static {
        SlotWriter.Companion = new Companion(null);
        SlotWriter.$stable = 8;
    }

    public SlotWriter(SlotTable arg3) {
        super();
        this.table = arg3;
        this.groups = arg3.getGroups();
        this.slots = arg3.getSlots();
        this.anchors = arg3.getAnchors$runtime();
        this.sourceInformationMap = arg3.getSourceInformationMap$runtime();
        this.calledByMap = arg3.getCalledByMap$runtime();
        this.groupGapStart = arg3.getGroupsSize();
        this.groupGapLen = this.groups.length / 5 - arg3.getGroupsSize();
        this.slotsGapStart = arg3.getSlotsSize();
        this.slotsGapLen = this.slots.length - arg3.getSlotsSize();
        this.slotsGapOwner = arg3.getGroupsSize();
        this.startStack = new IntStack();
        this.endStack = new IntStack();
        this.nodeCountStack = new IntStack();
        this.currentGroupEnd = arg3.getGroupsSize();
        this.parent = -1;
    }

    public static final boolean access$containsAnyGroupMarks(SlotWriter arg0, int arg1) {
        return arg0.containsAnyGroupMarks(arg1);
    }

    public static final int access$dataIndex(SlotWriter arg0, int arg1) {
        return arg0.dataIndex(arg1);
    }

    public static final int access$dataIndex(SlotWriter arg0, int[] arg1, int arg2) {
        return arg0.dataIndex(arg1, arg2);
    }

    public static final int access$dataIndexToDataAddress(SlotWriter arg0, int arg1) {
        return arg0.dataIndexToDataAddress(arg1);
    }

    public static final int access$dataIndexToDataAnchor(SlotWriter arg0, int arg1, int arg2, int arg3, int arg4) {
        return arg0.dataIndexToDataAnchor(arg1, arg2, arg3, arg4);
    }

    public static final ArrayList access$getAnchors$p(SlotWriter arg0) {
        return arg0.anchors;
    }

    public static final int access$getCurrentSlot$p(SlotWriter arg0) {
        return arg0.currentSlot;
    }

    public static final int access$getGroupGapStart$p(SlotWriter arg0) {
        return arg0.groupGapStart;
    }

    public static final int[] access$getGroups$p(SlotWriter arg0) {
        return arg0.groups;
    }

    public static final int access$getNodeCount$p(SlotWriter arg0) {
        return arg0.nodeCount;
    }

    public static final Object[] access$getSlots$p(SlotWriter arg0) {
        return arg0.slots;
    }

    public static final int access$getSlotsGapLen$p(SlotWriter arg0) {
        return arg0.slotsGapLen;
    }

    public static final int access$getSlotsGapOwner$p(SlotWriter arg0) {
        return arg0.slotsGapOwner;
    }

    public static final int access$getSlotsGapStart$p(SlotWriter arg0) {
        return arg0.slotsGapStart;
    }

    public static final HashMap access$getSourceInformationMap$p(SlotWriter arg0) {
        return arg0.sourceInformationMap;
    }

    public static final int access$groupIndexToAddress(SlotWriter arg0, int arg1) {
        return arg0.groupIndexToAddress(arg1);
    }

    public static final void access$insertGroups(SlotWriter arg0, int arg1) {
        arg0.insertGroups(arg1);
    }

    public static final void access$insertSlots(SlotWriter arg0, int arg1, int arg2) {
        arg0.insertSlots(arg1, arg2);
    }

    public static final void access$moveGroupGapTo(SlotWriter arg0, int arg1) {
        arg0.moveGroupGapTo(arg1);
    }

    public static final void access$moveSlotGapTo(SlotWriter arg0, int arg1, int arg2) {
        arg0.moveSlotGapTo(arg1, arg2);
    }

    public static final boolean access$removeGroups(SlotWriter arg0, int arg1, int arg2) {
        return arg0.removeGroups(arg1, arg2);
    }

    public static final void access$removeSlots(SlotWriter arg0, int arg1, int arg2, int arg3) {
        arg0.removeSlots(arg1, arg2, arg3);
    }

    public static final void access$setCurrentGroup$p(SlotWriter arg0, int arg1) {
        arg0.currentGroup = arg1;
    }

    public static final void access$setCurrentSlot$p(SlotWriter arg0, int arg1) {
        arg0.currentSlot = arg1;
    }

    public static final void access$setNodeCount$p(SlotWriter arg0, int arg1) {
        arg0.nodeCount = arg1;
    }

    public static final void access$setSlotsGapOwner$p(SlotWriter arg0, int arg1) {
        arg0.slotsGapOwner = arg1;
    }

    public static final void access$updateContainsMark(SlotWriter arg0, int arg1) {
        arg0.updateContainsMark(arg1);
    }

    public final void advanceBy(int arg4) {
        int v0 = 1;
        int v2 = arg4 >= 0 ? 1 : 0;
        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek backwards");
        }

        v2 = this.insertCount <= 0 ? 1 : 0;
        if(v2 == 0) {
            PreconditionsKt.throwIllegalStateException("Cannot call seek() while inserting");
        }

        if(arg4 == 0) {
            return;
        }

        v2 = this.currentGroup + arg4;
        if(v2 < this.parent || v2 > this.currentGroupEnd) {
            v0 = 0;
        }
        else {
        }

        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot seek outside the current group (" + this.parent + '-' + this.currentGroupEnd + ')');
        }

        this.currentGroup = v2;
        arg4 = this.dataIndex(this.groups, this.groupIndexToAddress(v2));
        this.currentSlot = arg4;
        this.currentSlotEnd = arg4;
    }

    public final GapAnchor anchor(int arg5) {
        ArrayList v0 = this.anchors;
        int v1 = SlotTableKt.search(v0, arg5, this.getSize$runtime());
        if(v1 < 0) {
            if(arg5 <= this.groupGapStart) {
            }
            else {
                arg5 = -(this.getSize$runtime() - arg5);
            }

            GapAnchor v2 = new GapAnchor(arg5);
            v0.add(-(v1 + 1), v2);
            return v2;
        }

        return v0.get(v1);
    }

    public static GapAnchor anchor$default(SlotWriter arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.currentGroup;
        }

        return arg0.anchor(arg1);
    }

    public final int anchorIndex(GapAnchor arg1) {
        int v1 = arg1.getLocation$runtime();
        if(v1 < 0) {
            return this.getSize$runtime() + v1;
        }

        return v1;
    }

    public final void appendSlot(GapAnchor arg6, Object arg7) {
        int v0 = this.insertCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Can only append a slot if not current inserting");
        }

        v0 = this.currentSlot;
        int v2 = this.currentSlotEnd;
        int v6 = this.anchorIndex(arg6);
        int v3 = this.dataIndex(this.groups, this.groupIndexToAddress(v6 + 1));
        this.currentSlot = v3;
        this.currentSlotEnd = v3;
        this.insertSlots(1, v6);
        if(v0 >= v3) {
            ++v0;
            ++v2;
        }

        this.slots[v3] = arg7;
        this.currentSlot = v0;
        this.currentSlotEnd = v2;
    }

    private final int auxIndex(int[] arg1, int arg2) {
        return this.dataIndex(arg1, arg2) + Integer.bitCount(arg1[arg2 * 5 + 1] >> 29);
    }

    public final void bashCurrentGroup() {
        SlotTableKt.updateGroupKey(this.groups, this.currentGroup, -3);
    }

    public final void beginInsert() {
        int v0 = this.insertCount;
        this.insertCount = v0 + 1;
        if(v0 == 0) {
            this.saveCurrentGroupEnd();
        }
    }

    private final boolean childContainsAnyMarks(int arg5) {
        int v0 = arg5 + 1;
        arg5 += this.groupSize(arg5);
        while(v0 < arg5) {
            if((this.groups[this.groupIndexToAddress(v0) * 5 + 1] & 0xC000000) != 0) {
                return 1;
            }

            v0 += this.groupSize(v0);
        }

        return 0;
    }

    private final int childGroupAtIndex(int arg5, int arg6) {
        int v0 = this.groupSize(arg5) + arg5;
        ++arg5;
        int v1 = 0;
        while(arg5 < v0) {
            if(v1 >= arg6) {
                return arg5;
            }

            int v2 = this.groupIndexToAddress(arg5);
            arg5 += SlotTableKt.groupSize(this.groups, v2);
            if(arg5 >= v0) {
                continue;
            }

            if((this.groups[v2 * 5 + 1] & 0x20000000) != 0) {
            }
            else {
                ++v1;
            }
        }

        return arg5;
    }

    public final Object clear(int arg3) {
        arg3 = this.dataIndexToDataAddress(arg3);
        Object[] v2 = this.slots;
        Object v0 = v2[arg3];
        v2[arg3] = Composer.Companion.getEmpty();
        return v0;
    }

    private final void clearSlotGap() {
        ArraysKt.fill(this.slots, null, this.slotsGapStart, this.slotsGapLen + this.slotsGapStart);
    }

    public final void close(boolean arg11) {
        this.closed = true;
        if((arg11) && this.startStack.tos == 0) {
            this.moveGroupGapTo(this.getSize$runtime());
            this.moveSlotGapTo(this.slots.length - this.slotsGapLen, this.groupGapStart);
            this.clearSlotGap();
            this.recalculateMarks();
        }

        this.table.close$runtime(this, this.groups, this.groupGapStart, this.slots, this.slotsGapStart, this.anchors, this.sourceInformationMap, this.calledByMap);
    }

    private final boolean containsAnyGroupMarks(int arg2) {
        if(arg2 >= 0 && (this.groups[this.groupIndexToAddress(arg2) * 5 + 1] & 0xC000000) != 0) {
            return 1;
        }

        return 0;
    }

    private final boolean containsGroupMark(int arg2) {
        if(arg2 >= 0 && (this.groups[this.groupIndexToAddress(arg2) * 5 + 1] & 0x4000000) != 0) {
            return 1;
        }

        return 0;
    }

    private final int dataAnchorToDataIndex(int arg1, int arg2, int arg3) {
        if(arg1 < 0) {
            return arg3 - arg2 + arg1 + 1;
        }

        return arg1;
    }

    private final int dataIndex(int arg2) {
        return this.dataIndex(this.groups, this.groupIndexToAddress(arg2));
    }

    private final int dataIndex(int[] arg2, int arg3) {
        if(arg3 >= this.getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }

        return this.dataAnchorToDataIndex(arg2[arg3 * 5 + 4], this.slotsGapLen, this.slots.length);
    }

    private final int dataIndexToDataAddress(int arg2) {
        int v0 = this.slotsGapLen;
        int v1 = arg2 < this.slotsGapStart ? 0 : 1;
        return arg2 + v0 * v1;
    }

    private final int dataIndexToDataAnchor(int arg1, int arg2, int arg3, int arg4) {
        if(arg1 > arg2) {
            return -(arg4 - arg3 - arg1 + 1);
        }

        return arg1;
    }

    private final List dataIndexes(int[] arg8) {
        int v3 = 0;
        List v0 = SlotTableKt.dataAnchors$default(this.groups, 0, 1, null);
        List v8 = CollectionsKt.plus(CollectionsKt.slice(v0, RangesKt.until(0, this.groupGapStart)), CollectionsKt.slice(v0, RangesKt.until(this.groupGapStart + this.groupGapLen, arg8.length / 5)));
        ArrayList v0_1 = new ArrayList(v8.size());
        int v1 = v8.size();
        while(v3 < v1) {
            v0_1.add(Integer.valueOf(this.dataAnchorToDataIndex(v8.get(v3).intValue(), this.slotsGapLen, this.slots.length)));
            ++v3;
        }

        return ((List)v0_1);
    }

    public final int endGroup() {
        int v1 = 0;
        int v0 = this.insertCount > 0 ? 1 : 0;
        int v3 = this.currentGroup;
        int v4 = this.currentGroupEnd;
        int v5 = this.parent;
        int v6 = this.groupIndexToAddress(v5);
        int v7 = this.nodeCount;
        int v8 = v3 - v5;
        int v10 = v6 * 5 + 1;
        int v11 = 0x40000000;
        int v9 = (this.groups[v10] & v11) != 0 ? 1 : 0;
        if(v0 != 0) {
            MutableIntObjectMap v0_1 = this.deferredSlotWrites;
            if(v0_1 != null) {
                Object v3_1 = v0_1.get(v5);
                if(v3_1 != null) {
                    Object[] v4_1 = ((ObjectList)v3_1).content;
                    v3 = ((ObjectList)v3_1)._size;
                    for(v10 = 0; v10 < v3; ++v10) {
                        this.rawUpdate(v4_1[v10]);
                    }

                    v0_1.remove(v5);
                }
            }

            SlotTableKt.updateGroupSize(this.groups, v6, v8);
            SlotTableKt.updateNodeCount(this.groups, v6, v7);
            v0 = this.nodeCountStack.pop();
            v3 = v9 != 0 ? 1 : v7;
            this.nodeCount = v0 + v3;
            v0 = this.parent(this.groups, v5);
            this.parent = v0;
            v0 = v0 < 0 ? this.getSize$runtime() : this.groupIndexToAddress(v0 + 1);
            if(v0 < 0) {
            }
            else {
                v1 = this.dataIndex(this.groups, v0);
            }

            this.currentSlot = v1;
            this.currentSlotEnd = v1;
            return v7;
        }

        v0 = v3 == v4 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Expected to be at the end of a group");
        }

        v0 = SlotTableKt.groupSize(this.groups, v6);
        int[] v3_2 = this.groups;
        v4 = v3_2[v10];
        v10 = 0x3FFFFFF;
        v4 &= v10;
        SlotTableKt.updateGroupSize(v3_2, v6, v8);
        SlotTableKt.updateNodeCount(this.groups, v6, v7);
        v3 = this.startStack.pop();
        this.restoreCurrentGroupEnd();
        this.parent = v3;
        v5 = this.parent(this.groups, v5);
        v6 = this.nodeCountStack.pop();
        this.nodeCount = v6;
        if(v5 == v3) {
            if(v9 != 0) {
            }
            else {
                v1 = v7 - v4;
            }

            this.nodeCount = v6 + v1;
            return v7;
        }

        v8 -= v0;
        v0 = v9 != 0 ? 0 : v7 - v4;
        if(v8 != 0 || v0 != 0) {
            while(v5 != 0) {
                if(v5 == v3) {
                    break;
                }

                if(v0 == 0 && v8 == 0) {
                    break;
                }

                v4 = this.groupIndexToAddress(v5);
                if(v8 != 0) {
                    SlotTableKt.updateGroupSize(this.groups, v4, SlotTableKt.groupSize(this.groups, v4) + v8);
                }

                if(v0 != 0) {
                    SlotTableKt.updateNodeCount(this.groups, v4, (this.groups[v4 * 5 + 1] & v10) + v0);
                }

                int[] v6_1 = this.groups;
                if((v6_1[v4 * 5 + 1] & v11) != 0) {
                    v0 = 0;
                }

                v5 = this.parent(v6_1, v5);
            }
        }

        this.nodeCount += v0;
        return v7;
    }

    public final void endInsert() {
        int v1 = 1;
        int v0 = this.insertCount > 0 ? 1 : 0;
        if(v0 == 0) {
            PreconditionsKt.throwIllegalStateException("Unbalanced begin/end insert");
        }

        v0 = this.insertCount - 1;
        this.insertCount = v0;
        if(v0 == 0) {
            if(this.nodeCountStack.tos == this.startStack.tos) {
            }
            else {
                v1 = 0;
            }

            if(v1 == 0) {
                ComposerKt.composeImmediateRuntimeError("startGroup/endGroup mismatch while inserting");
            }

            this.restoreCurrentGroupEnd();
        }
    }

    public final void ensureStarted(int arg5) {
        int v1 = 1;
        int v0 = this.insertCount <= 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot call ensureStarted() while inserting");
        }

        v0 = this.parent;
        if(v0 != arg5) {
            if(arg5 < v0 || arg5 >= this.currentGroupEnd) {
                v1 = 0;
            }
            else {
            }

            if(v1 == 0) {
                ComposerKt.composeImmediateRuntimeError("Started group at " + arg5 + " must be a subgroup of the group at " + v0);
            }

            v0 = this.currentGroup;
            v1 = this.currentSlot;
            int v2 = this.currentSlotEnd;
            this.currentGroup = arg5;
            this.startGroup();
            this.currentGroup = v0;
            this.currentSlot = v1;
            this.currentSlotEnd = v2;
        }
    }

    public final void ensureStarted(GapAnchor arg1) {
        this.ensureStarted(arg1.toIndexFor(this));
    }

    private final void fixParentAnchorsFor(int arg3, int arg4, int arg5) {
        arg3 = this.parentIndexToAnchor(arg3, this.groupGapStart);
        while(arg5 < arg4) {
            this.groups[this.groupIndexToAddress(arg5) * 5 + 2] = arg3;
            int v0 = SlotTableKt.groupSize(this.groups, this.groupIndexToAddress(arg5)) + arg5;
            this.fixParentAnchorsFor(arg5, v0, arg5 + 1);
            arg5 = v0;
        }
    }

    public final void forAllData(int arg5, Function2 arg6) {
        arg5 = this.dataIndex(this.groups, this.groupIndexToAddress(arg5));
        int v0 = this.dataIndex(this.groups, this.groupIndexToAddress(this.getCurrentGroup() + this.groupSize(this.getCurrentGroup())));
        while(arg5 < v0) {
            arg6.invoke(Integer.valueOf(arg5), this.slots[this.dataIndexToDataAddress(arg5)]);
            ++arg5;
        }
    }

    public final void forAllDataInRememberOrder(int arg19, Function2 arg20) {
        int v16;
        int v14_1;
        int v15;
        int v13;
        SlotWriter v0 = this;
        int v1 = arg19;
        Function2 v2 = arg20;
        int v3 = this.parent(arg19);
        int v4 = v0.getSize$runtime();
        int v5 = this.groupSize(arg19) + v1;
        DefaultConstructorMarker v6 = null;
        int v7 = v1;
        MutableIntSet v8 = ((MutableIntSet)v6);
        MutableIntList v9 = ((MutableIntList)v8);
        while(v7 < v5) {
            int v10 = v0.dataIndex(v7);
            int v11 = v7 + 1;
            int v12 = v0.dataIndex(v11);
            while(true) {
                v13 = 0;
                if(v10 >= v12) {
                    break;
                }

                Object v14 = v0.slots[v0.dataIndexToDataAddress(v10)];
                if((v14 instanceof RememberObserverHolder)) {
                    v15 = GapComposerKt.asGapRememberObserverHolder(v14).getAfterGroupIndex();
                    if(v15 >= 0) {
                        v14_1 = v0.childGroupAtIndex(v7, v15);
                        if(v8 == null) {
                            v8 = IntSetKt.mutableIntSetOf();
                        }

                        if(v9 == null) {
                            v9 = new MutableIntList(0, 1, v6);
                        }

                        v8.add(v14_1);
                        v9.add(v14_1);
                        v9.add(v10);
                    }
                    else {
                        goto label_37;
                    }
                }
                else {
                label_37:
                    v2.invoke(Integer.valueOf(v10), v14);
                }

                ++v10;
            }

            v10 = v11 < v4 ? v0.parent(v11) : -1;
            if(v10 == v7) {
                v16 = v4;
            }
            else {
                while(true) {
                    if(v9 == null || v8 == null || !v8.remove(v7)) {
                        v16 = v4;
                    }
                    else {
                        v12 = v9._size;
                        v14_1 = v12 / 2;
                        int v6_1 = v13;
                        v15 = v6_1;
                        while(v15 < v14_1) {
                            v13 = v15 * 2;
                            v16 = v4;
                            v4 = v9.get(v13);
                            if(v4 == v7) {
                                v4 = v9.get(v13 + 1);
                                v2.invoke(Integer.valueOf(v4), v0.slots[v0.dataIndexToDataAddress(v4)]);
                            }
                            else if(v13 != v6_1) {
                                int v2_1 = v6_1 + 1;
                                v9.set(v6_1, v4);
                                v6_1 += 2;
                                v9.set(v2_1, v9.get(v13 + 1));
                            }
                            else {
                                v6_1 += 2;
                            }

                            ++v15;
                            v2 = arg20;
                            v4 = v16;
                        }

                        v16 = v4;
                        if(v6_1 == v12) {
                            goto label_87;
                        }

                        v9.removeRange(v6_1, v12);
                    }

                label_87:
                    if(v7 == v1) {
                        break;
                    }

                    if(v3 == v10) {
                        break;
                    }

                    v7 = v3;
                    v4 = v16;
                    v13 = 0;
                    v3 = v0.parent(v3);
                    v2 = arg20;
                }
            }

            v2 = arg20;
            v3 = v10;
            v7 = v11;
            v4 = v16;
            v6 = null;
        }
    }

    public final void forEachTailSlot(int arg4, int arg5, Function2 arg6) {
        int v0 = this.slotsStartIndex$runtime(arg4);
        arg4 = this.slotsEndIndex$runtime(arg4);
        for(arg5 = Math.max(v0, arg4 - arg5); arg5 < arg4; ++arg5) {
            arg6.invoke(Integer.valueOf(arg5), this.slots[this.dataIndexToDataAddress(arg5)]);
        }
    }

    private final int getCapacity() {
        return this.groups.length / 5;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean getCollectingCalledInformation() {
        if(this.calledByMap != null) {
            return 1;
        }

        return 0;
    }

    public final boolean getCollectingSourceInformation() {
        if(this.sourceInformationMap != null) {
            return 1;
        }

        return 0;
    }

    public final int getCurrentGroup() {
        return this.currentGroup;
    }

    public final int getCurrentGroupEnd() {
        return this.currentGroupEnd;
    }

    private final int getCurrentGroupSlotIndex() {
        return this.groupSlotIndex(this.parent);
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getSize$runtime() {
        return this.getCapacity() - this.groupGapLen;
    }

    public final int getSlotsSize() {
        return this.slots.length - this.slotsGapLen;
    }

    public final SlotTable getTable$runtime() {
        return this.table;
    }

    private final void groupAsString(StringBuilder arg9, int arg10) {
        int v0 = this.groupIndexToAddress(arg10);
        arg9.append("Group(");
        char v1 = ' ';
        int v2 = 10;
        if(arg10 < v2) {
            arg9.append(v1);
        }

        if(arg10 < 100) {
            arg9.append(v1);
        }

        if(arg10 < 1000) {
            arg9.append(v1);
        }

        arg9.append(arg10);
        String v1_1 = ")";
        if(v0 != arg10) {
            arg9.append("(");
            arg9.append(v0);
            arg9.append(v1_1);
        }

        arg9.append('#');
        arg9.append(SlotTableKt.groupSize(this.groups, v0));
        arg9.append('^');
        int v4 = v0 * 5;
        int v5 = v4 + 2;
        arg9.append(this.parentAnchorToIndex(this.groups[v5]));
        arg9.append(": key=");
        arg9.append(this.groups[v4]);
        arg9.append(", nodes=");
        int v6 = v4 + 1;
        arg9.append(this.groups[v6] & 0x3FFFFFF);
        arg9.append(", dataAnchor=");
        arg9.append(this.groups[v4 + 4]);
        arg9.append(", parentAnchor=");
        arg9.append(this.groups[v5]);
        if((this.groups[v6] & 0x40000000) != 0) {
            arg9.append(", node=" + SlotTableKt.summarize(String.valueOf(this.slots[this.dataIndexToDataAddress(this.nodeIndex(this.groups, v0))]), v2));
        }

        v0 = this.slotIndex(this.groups, v0);
        arg10 = this.dataIndex(this.groups, this.groupIndexToAddress(arg10 + 1));
        if(arg10 > v0) {
            arg9.append(", [");
            int v3;
            for(v3 = v0; v3 < arg10; ++v3) {
                if(v3 != v0) {
                    arg9.append(", ");
                }

                arg9.append(SlotTableKt.summarize(String.valueOf(this.slots[this.dataIndexToDataAddress(v3)]), v2));
            }

            arg9.append(']');
        }

        arg9.append(v1_1);
    }

    public final Object groupAux(int arg4) {
        arg4 = this.groupIndexToAddress(arg4);
        int[] v0 = this.groups;
        if((v0[arg4 * 5 + 1] & 0x10000000) != 0) {
            return this.slots[this.auxIndex(v0, arg4)];
        }

        return Composer.Companion.getEmpty();
    }

    private final int groupIndexToAddress(int arg2) {
        int v0 = this.groupGapLen;
        int v1 = arg2 < this.groupGapStart ? 0 : 1;
        return arg2 + v0 * v1;
    }

    public final int groupKey(int arg2) {
        return this.groups[this.groupIndexToAddress(arg2) * 5];
    }

    public final Object groupObjectKey(int arg4) {
        arg4 = this.groupIndexToAddress(arg4);
        int[] v0 = this.groups;
        if((v0[arg4 * 5 + 1] & 0x20000000) != 0) {
            return this.slots[SlotTableKt.objectKeyIndex(v0, arg4)];
        }

        return null;
    }

    public final int groupSize(int arg2) {
        return SlotTableKt.groupSize(this.groups, this.groupIndexToAddress(arg2));
    }

    public final int groupSlotIndex(int arg3) {
        int v2_2;
        int v0 = this.currentSlot - this.slotsStartIndex$runtime(arg3);
        MutableIntObjectMap v2 = this.deferredSlotWrites;
        if(v2 != null) {
            Object v2_1 = v2.get(arg3);
            if(v2_1 != null) {
                v2_2 = ((MutableObjectList)v2_1).getSize();
            }
            else {
                goto label_9;
            }
        }
        else {
        label_9:
            v2_2 = 0;
        }

        return v0 + v2_2;
    }

    public final Iterator groupSlots() {
        return new SlotWriter$groupSlots$1(this.dataIndex(this.groups, this.groupIndexToAddress(this.currentGroup)), this.dataIndex(this.groups, this.groupIndexToAddress(this.currentGroup + this.groupSize(this.currentGroup))), this);
    }

    private final GapGroupSourceInformation groupSourceInformationFor(int arg5, String arg6) {
        GapGroupSourceInformation v2_1;
        HashMap v0 = this.sourceInformationMap;
        if(v0 != null) {
            GapAnchor v1 = this.anchor(arg5);
            Object v2 = ((Map)v0).get(v1);
            if(v2 == null) {
                v2_1 = new GapGroupSourceInformation(0, arg6, 0);
                if(arg6 == null) {
                    ++arg5;
                    int v6 = this.currentGroup;
                    while(arg5 < v6) {
                        v2_1.reportGroup(this, arg5);
                        arg5 += SlotTableKt.groupSize(this.groups, arg5);
                    }
                }

                ((Map)v0).put(v1, v2_1);
            }

            return v2_1;
        }

        return null;
    }

    public final boolean hasObjectKey(int arg2) {
        if((this.groups[this.groupIndexToAddress(arg2) * 5 + 1] & 0x20000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean inGroup(GapAnchor arg2, GapAnchor arg3) {
        int v2 = this.anchorIndex(arg2);
        int v1 = SlotTableKt.groupSize(this.groups, v2) + v2;
        int v3 = arg3.getLocation$runtime();
        if(v2 <= v3 && v3 < v1) {
            return 1;
        }

        return 0;
    }

    public final boolean indexInCurrentGroup(int arg2) {
        return this.indexInGroup(arg2, this.currentGroup);
    }

    public final boolean indexInGroup(int arg5, int arg6) {
        int v0;
        int v4;
        if(arg6 == this.parent) {
            v4 = this.currentGroupEnd;
        }
        else {
            if(arg6 > this.startStack.peekOr(0)) {
                v4 = this.groupSize(arg6);
            }
            else {
                v0 = this.startStack.indexOf(arg6);
                if(v0 < 0) {
                    v4 = this.groupSize(arg6);
                }
                else {
                    goto label_16;
                }
            }

            v4 += arg6;
            goto label_22;
        label_16:
            v4 = this.getCapacity() - this.groupGapLen - this.endStack.peek(v0);
        }

    label_22:
        if(arg5 > arg6 && arg5 < v4) {
            return 1;
        }

        return 0;
    }

    public final boolean indexInParent(int arg2) {
        int v0 = this.parent;
        if(arg2 > v0 && arg2 < this.currentGroupEnd || v0 == 0 && arg2 == 0) {
            return 1;
        }

        return 0;
    }

    public final void insertAux(Object arg7) {
        int v1 = 0;
        int v0 = this.insertCount >= 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot insert auxiliary data when not inserting");
        }

        v0 = this.parent;
        int v3 = this.groupIndexToAddress(v0);
        int v4 = (this.groups[v3 * 5 + 1] & 0x10000000) != 0 ? 1 : 0;
        if(v4 != 0) {
            ComposerKt.composeImmediateRuntimeError("Group already has auxiliary data");
        }

        this.insertSlots(1, v0);
        v0 = this.auxIndex(this.groups, v3);
        v4 = this.dataIndexToDataAddress(v0);
        int v5 = this.currentSlot;
        if(v5 > v0) {
            v5 -= v0;
            if(v5 < 3) {
                v1 = 1;
            }

            if(v1 == 0) {
                PreconditionsKt.throwIllegalStateException("Moving more than two slot not supported");
            }

            if(v5 > 1) {
                this.slots[v4 + 2] = this.slots[v4 + 1];
            }

            this.slots[v4 + 1] = this.slots[v4];
        }

        SlotTableKt.addAux(this.groups, v3);
        this.slots[v4] = arg7;
        ++this.currentSlot;
    }

    private final void insertGroups(int arg12) {
        if(arg12 > 0) {
            int v0 = this.currentGroup;
            this.moveGroupGapTo(v0);
            int v1 = this.groupGapStart;
            int v2 = this.groupGapLen;
            int[] v3 = this.groups;
            int v4 = v3.length / 5;
            int v5 = v4 - v2;
            int v6 = 0;
            if(v2 < arg12) {
                int v7 = Math.max(Math.max(v4 * 2, v5 + arg12), 0x20);
                int[] v8 = new int[v7 * 5];
                v7 -= v5;
                ArraysKt.copyInto(v3, v8, 0, 0, v1 * 5);
                ArraysKt.copyInto(v3, v8, (v1 + v7) * 5, (v2 + v1) * 5, v4 * 5);
                this.groups = v8;
                v2 = v7;
            }

            int v3_1 = this.currentGroupEnd;
            if(v3_1 >= v1) {
                this.currentGroupEnd = v3_1 + arg12;
            }

            v3_1 = v1 + arg12;
            this.groupGapStart = v3_1;
            this.groupGapLen = v2 - arg12;
            v0 = v5 > 0 ? this.dataIndex(v0 + arg12) : 0;
            if(this.slotsGapOwner < v1) {
            }
            else {
                v6 = this.slotsGapStart;
            }

            v0 = this.dataIndexToDataAnchor(v0, v6, this.slotsGapLen, this.slots.length);
            for(v2 = v1; v2 < v3_1; ++v2) {
                this.groups[v2 * 5 + 4] = v0;
            }

            v0 = this.slotsGapOwner;
            if(v0 < v1) {
                return;
            }

            this.slotsGapOwner = v0 + arg12;
        }
    }

    private final void insertSlots(int arg10, int arg11) {
        if(arg10 > 0) {
            this.moveSlotGapTo(this.currentSlot, arg11);
            arg11 = this.slotsGapStart;
            int v0 = this.slotsGapLen;
            if(v0 < arg10) {
                Object[] v1 = this.slots;
                int v2 = v1.length;
                int v3 = v2 - v0;
                int v4 = Math.max(Math.max(v2 * 2, v3 + arg10), 0x20);
                Object[] v5 = new Object[v4];
                int v7;
                for(v7 = 0; v7 < v4; ++v7) {
                    v5[v7] = null;
                }

                v4 -= v3;
                v0 += arg11;
                System.arraycopy(v1, 0, v5, 0, arg11);
                System.arraycopy(v1, v0, v5, arg11 + v4, v2 - v0);
                this.slots = v5;
                v0 = v4;
            }

            int v1_1 = this.currentSlotEnd;
            if(v1_1 >= arg11) {
                this.currentSlotEnd = v1_1 + arg10;
            }

            this.slotsGapStart = arg11 + arg10;
            this.slotsGapLen = v0 - arg10;
        }
    }

    public final boolean isGroupEnd() {
        if(this.currentGroup == this.currentGroupEnd) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode(int arg2) {
        if((this.groups[this.groupIndexToAddress(arg2) * 5 + 1] & 0x40000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isNode() {
        int v0 = this.currentGroup;
        if(v0 < this.currentGroupEnd && (this.groups[this.groupIndexToAddress(v0) * 5 + 1] & 0x40000000) != 0) {
            return 1;
        }

        return 0;
    }

    public final boolean isValid(int arg1) {
        if(this.groupIndexToAddress(arg1) * 5 < this.groups.length) {
            return 1;
        }

        return 0;
    }

    private final List keys() {
        int v3 = 0;
        List v0 = SlotTableKt.keys$default(this.groups, 0, 1, null);
        ArrayList v1 = new ArrayList(v0.size());
        int v2 = v0.size();
        while(v3 < v2) {
            Object v4 = v0.get(v3);
            v4.intValue();
            int v5 = this.groupGapStart;
            if(v3 < v5 || v3 >= v5 + this.groupGapLen) {
                v1.add(v4);
            }

            ++v3;
        }

        return ((List)v1);
    }

    public final void markGroup(int arg7) {
        int v0 = this.groupIndexToAddress(arg7);
        int[] v1 = this.groups;
        int v2 = v0 * 5 + 1;
        if((v1[v2] & 0x8000000) != 0) {
            return;
        }

        SlotTableKt.updateMark(v1, v0, true);
        if((this.groups[v2] & 0x4000000) != 0) {
            return;
        }

        this.updateContainsMark(this.parent(arg7));
    }

    public static void markGroup$default(SlotWriter arg0, int arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = arg0.parent;
        }

        arg0.markGroup(arg1);
    }

    private final void moveAnchors(int arg6, int arg7, int arg8) {
        arg8 += arg6;
        int v0 = this.getSize$runtime();
        int v1 = SlotTableKt.locationOf(this.anchors, arg6, v0);
        ArrayList v2 = new ArrayList();
        if(v1 >= 0) {
            while(v1 < this.anchors.size()) {
                Object v3 = this.anchors.get(v1);
                int v4 = this.anchorIndex(((GapAnchor)v3));
                if(v4 < arg6) {
                    break;
                }

                if(v4 >= arg8) {
                    break;
                }

                ((List)v2).add(v3);
                this.anchors.remove(v1);
            }
        }

        arg7 -= arg6;
        arg6 = v2.size();
        for(arg8 = 0; arg8 < arg6; ++arg8) {
            Object v1_1 = ((List)v2).get(arg8);
            int v3_1 = this.anchorIndex(((GapAnchor)v1_1)) + arg7;
            if(v3_1 >= this.groupGapStart) {
                ((GapAnchor)v1_1).setLocation$runtime(-(v0 - v3_1));
            }
            else {
                ((GapAnchor)v1_1).setLocation$runtime(v3_1);
            }

            this.anchors.add(SlotTableKt.locationOf(this.anchors, v3_1, v0), v1_1);
        }
    }

    public final List moveFrom(SlotTable arg13, int arg14, boolean arg15) {
        List v12;
        int v0 = this.insertCount > 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }

        if(arg14 == 0 && this.currentGroup == 0 && this.table.getGroupsSize() == 0 && SlotTableKt.groupSize(arg13.getGroups(), arg14) == arg13.getGroupsSize()) {
            int[] v5 = this.groups;
            Object[] v7 = this.slots;
            ArrayList v9 = this.anchors;
            HashMap v10 = this.sourceInformationMap;
            MutableIntObjectMap v11 = this.calledByMap;
            int[] v14 = arg13.getGroups();
            int v15 = arg13.getGroupsSize();
            Object[] v0_1 = arg13.getSlots();
            int v1 = arg13.getSlotsSize();
            HashMap v2 = arg13.getSourceInformationMap$runtime();
            MutableIntObjectMap v3 = arg13.getCalledByMap$runtime();
            this.groups = v14;
            this.slots = v0_1;
            this.anchors = arg13.getAnchors$runtime();
            this.groupGapStart = v15;
            this.groupGapLen = v14.length / 5 - v15;
            this.slotsGapStart = v1;
            this.slotsGapLen = v0_1.length - v1;
            this.slotsGapOwner = v15;
            this.sourceInformationMap = v2;
            this.calledByMap = v3;
            arg13.setTo$runtime(v5, 0, v7, 0, v9, v10, v11);
            return this.anchors;
        }

        SlotWriter v4 = arg13.openWriter();
        try {
            v12 = Companion.access$moveGroup(SlotWriter.Companion, v4, arg14, this, true, true, arg15);
        }
        catch(Throwable v0_2) {
            v4.close(false);
            throw v0_2;
        }

        v4.close(true);
        return v12;
    }

    public static List moveFrom$default(SlotWriter arg0, SlotTable arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        return arg0.moveFrom(arg1, arg2, true);
    }

    public final void moveGroup(int arg19) {
        int v13;
        int v9_1;
        int[] v9;
        SlotWriter v0 = this;
        int v3 = 1;
        int v1 = v0.insertCount == 0 ? 1 : 0;
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot move a group while inserting");
        }

        v1 = arg19 >= 0 ? 1 : 0;
        String v4 = "Parameter offset is out of bounds";
        if(v1 == 0) {
            ComposerKt.composeImmediateRuntimeError(v4);
        }

        if(arg19 == 0) {
        }
        else {
            v1 = v0.currentGroup;
            int v5 = v0.parent;
            int v6 = v0.currentGroupEnd;
            int v7 = arg19;
            int v8 = v1;
            while(true) {
                v9 = v0.groups;
                if(v7 <= 0) {
                    break;
                }

                v8 += SlotTableKt.groupSize(v9, v0.groupIndexToAddress(v8));
                v9_1 = v8 <= v6 ? 1 : 0;
                if(v9_1 == 0) {
                    ComposerKt.composeImmediateRuntimeError(v4);
                }

                --v7;
            }

            int v4_1 = SlotTableKt.groupSize(v9, v0.groupIndexToAddress(v8));
            v6 = v0.dataIndex(v0.groups, v0.groupIndexToAddress(v0.currentGroup));
            v7 = v0.dataIndex(v0.groups, v0.groupIndexToAddress(v8));
            v8 += v4_1;
            v9_1 = v0.dataIndex(v0.groups, v0.groupIndexToAddress(v8));
            int v10 = v9_1 - v7;
            v0.insertSlots(v10, Math.max(v0.currentGroup - 1, 0));
            v0.insertGroups(v4_1);
            int[] v11 = v0.groups;
            int v12 = v0.groupIndexToAddress(v8) * 5;
            ArraysKt.copyInto(v11, v11, v0.groupIndexToAddress(v1) * 5, v12, v4_1 * 5 + v12);
            if(v10 > 0) {
                Object[] v12_1 = v0.slots;
                v13 = v0.dataIndexToDataAddress(v7 + v10);
                System.arraycopy(v12_1, v13, v12_1, v6, v0.dataIndexToDataAddress(v9_1 + v10) - v13);
            }

            v7 += v10;
            v6 = v7 - v6;
            v9_1 = v0.slotsGapStart;
            v12 = v0.slotsGapLen;
            v13 = v0.slots.length;
            int v14 = v0.slotsGapOwner;
            int v15 = v1 + v4_1;
            int v2 = v1;
            while(v2 < v15) {
                int v16 = v3;
                v3 = v0.groupIndexToAddress(v2);
                arg19 = v2;
                v2 = v0.dataIndex(v11, v3) - v6;
                int v17 = v6;
                v6 = v14 < v3 ? 0 : v9_1;
                v0.updateDataIndex(v11, v3, v0.dataIndexToDataAnchor(v2, v6, v12, v13));
                v2 = arg19 + 1;
                v3 = v16;
                v6 = v17;
            }

            v0.moveAnchors(v8, v1, v4_1);
            if(v0.removeGroups(v8, v4_1)) {
                ComposerKt.composeImmediateRuntimeError("Unexpectedly removed anchors");
            }

            v0.fixParentAnchorsFor(v5, v0.currentGroupEnd, v1);
            if(v10 <= 0) {
                return;
            }

            v0.removeSlots(v7, v10, v8 - 1);
        }
    }

    private final void moveGroupGapTo(int arg8) {
        int v5;
        int v4;
        int v3;
        int v0 = this.groupGapLen;
        int v1 = this.groupGapStart;
        if(v1 != arg8) {
            if(!this.anchors.isEmpty()) {
                this.updateAnchors(v1, arg8);
            }

            if(v0 > 0) {
                int[] v2 = this.groups;
                v3 = arg8 * 5;
                v4 = v0 * 5;
                v5 = v1 * 5;
                if(arg8 < v1) {
                    ArraysKt.copyInto(v2, v2, v4 + v3, v3, v5);
                }
                else {
                    ArraysKt.copyInto(v2, v2, v5, v5 + v4, v3 + v4);
                }
            }

            if(arg8 < v1) {
                v1 = arg8 + v0;
            }

            int v2_1 = this.getCapacity();
            v3 = v1 < v2_1 ? 1 : 0;
            if(v3 == 0) {
                ComposerKt.composeImmediateRuntimeError("Check failed");
            }

            while(v1 < v2_1) {
                v4 = v1 * 5 + 2;
                v3 = this.groups[v4];
                v5 = this.parentIndexToAnchor(this.parentAnchorToIndex(v3), arg8);
                if(v5 != v3) {
                    this.groups[v4] = v5;
                }

                ++v1;
                if(v1 != arg8) {
                    continue;
                }

                v1 += v0;
            }
        }

        this.groupGapStart = arg8;
    }

    public final List moveIntoGroupFrom(int arg15, SlotTable arg16, int arg17) {
        List v15;
        int v0 = this.insertCount > 0 || this.groupSize(this.currentGroup + arg15) != 1 ? 0 : 1;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Check failed");
        }

        v0 = this.currentGroup;
        int v3 = this.currentSlot;
        int v4 = this.currentSlotEnd;
        this.advanceBy(arg15);
        this.startGroup();
        this.beginInsert();
        SlotWriter v6 = arg16.openWriter();
        try {
            v15 = Companion.moveGroup$default(SlotWriter.Companion, v6, arg17, this, false, true, false, 0x20, null);
        }
        catch(Throwable v0_1) {
            v6.close(false);
            throw v0_1;
        }

        v6.close(true);
        this.endInsert();
        this.endGroup();
        this.currentGroup = v0;
        this.currentSlot = v3;
        this.currentSlotEnd = v4;
        return v15;
    }

    private final void moveSlotGapTo(int arg10, int arg11) {
        int v6;
        int v7;
        int v5;
        int v4;
        int v0 = this.slotsGapLen;
        int v1 = this.slotsGapStart;
        int v2 = this.slotsGapOwner;
        if(v1 != arg10) {
            Object[] v3 = this.slots;
            if(arg10 < v1) {
                System.arraycopy(v3, arg10, v3, arg10 + v0, v1 - arg10);
            }
            else {
                v4 = v1 + v0;
                System.arraycopy(v3, v4, v3, v1, arg10 + v0 - v4);
            }
        }

        arg11 = Math.min(arg11 + 1, this.getSize$runtime());
        if(v2 != arg11) {
            int v3_1 = this.slots.length - v0;
            if(arg11 < v2) {
                v4 = this.groupIndexToAddress(arg11);
                v2 = this.groupIndexToAddress(v2);
                v5 = this.groupGapStart;
                while(v4 < v2) {
                    v7 = v4 * 5 + 4;
                    v6 = this.groups[v7];
                    int v8 = v6 >= 0 ? 1 : 0;
                    if(v8 == 0) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a positive anchor");
                    }

                    this.groups[v7] = -(v3_1 - v6 + 1);
                    ++v4;
                    if(v4 != v5) {
                        continue;
                    }

                    v4 += this.groupGapLen;
                }
            }
            else {
                v2 = this.groupIndexToAddress(v2);
                v4 = this.groupIndexToAddress(arg11);
                while(v2 < v4) {
                    v6 = v2 * 5 + 4;
                    v5 = this.groups[v6];
                    v7 = v5 < 0 ? 1 : 0;
                    if(v7 == 0) {
                        ComposerKt.composeImmediateRuntimeError("Unexpected anchor value, expected a negative anchor");
                    }

                    this.groups[v6] = v5 + v3_1 + 1;
                    ++v2;
                    if(v2 != this.groupGapStart) {
                        continue;
                    }

                    v2 += this.groupGapLen;
                }
            }

            this.slotsGapOwner = arg11;
        }

        this.slotsGapStart = arg10;
    }

    public final List moveTo(GapAnchor arg17, int arg18, SlotWriter arg19) {
        SlotWriter v1 = this;
        SlotWriter v3 = arg19;
        int v9 = 1;
        int v0 = v3.insertCount > 0 ? 1 : 0;
        String v11 = "Check failed";
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError(v11);
        }

        v0 = v1.insertCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError(v11);
        }

        if(!arg17.getValid()) {
            ComposerKt.composeImmediateRuntimeError(v11);
        }

        int v2 = this.anchorIndex(arg17) + arg18;
        int v12 = v1.currentGroup;
        v0 = v12 > v2 || v2 >= v1.currentGroupEnd ? 0 : 1;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError(v11);
        }

        int v13 = v1.parent(v2);
        int v14 = v1.groupSize(v2);
        int v15 = v1.isNode(v2) ? 1 : v1.nodeCount(v2);
        List v0_1 = Companion.moveGroup$default(SlotWriter.Companion, v1, v2, v3, false, false, false, 0x20, null);
        v1.updateContainsMark(v13);
        v2 = v15 > 0 ? 1 : 0;
        while(v13 >= v12) {
            int v3_1 = v1.groupIndexToAddress(v13);
            SlotTableKt.updateGroupSize(v1.groups, v3_1, SlotTableKt.groupSize(v1.groups, v3_1) - v14);
            if(v2 != 0) {
                int[] v4 = v1.groups;
                int v5 = v4[v3_1 * 5 + 1];
                if((0x40000000 & v5) != 0) {
                    v2 = 0;
                }
                else {
                    SlotTableKt.updateNodeCount(v4, v3_1, (v5 & 0x3FFFFFF) - v15);
                }
            }

            v13 = v1.parent(v13);
        }

        if(v2 != 0) {
            if(v1.nodeCount >= v15) {
            }
            else {
                v9 = 0;
            }

            if(v9 == 0) {
                ComposerKt.composeImmediateRuntimeError(v11);
            }

            v1.nodeCount -= v15;
        }

        return v0_1;
    }

    public final Object node(int arg4) {
        arg4 = this.groupIndexToAddress(arg4);
        int[] v0 = this.groups;
        if((v0[arg4 * 5 + 1] & 0x40000000) != 0) {
            return this.slots[this.dataIndexToDataAddress(this.nodeIndex(v0, arg4))];
        }

        return null;
    }

    public final Object node(GapAnchor arg1) {
        return this.node(arg1.toIndexFor(this));
    }

    public final int nodeCount(int arg2) {
        return this.groups[this.groupIndexToAddress(arg2) * 5 + 1] & 0x3FFFFFF;
    }

    private final int nodeIndex(int[] arg1, int arg2) {
        return this.dataIndex(arg1, arg2);
    }

    public final int parent(int arg2) {
        return this.parent(this.groups, arg2);
    }

    private final int parent(int[] arg1, int arg2) {
        return this.parentAnchorToIndex(arg1[this.groupIndexToAddress(arg2) * 5 + 2]);
    }

    public final int parent(GapAnchor arg2) {
        if(arg2.getValid()) {
            return this.parent(this.groups, this.anchorIndex(arg2));
        }

        return -1;
    }

    private final int parentAnchorToIndex(int arg2) {
        int v0 = -2;
        if(arg2 > v0) {
            return arg2;
        }

        return this.getSize$runtime() + arg2 - v0;
    }

    private final int parentIndexToAnchor(int arg1, int arg2) {
        if(arg1 < arg2) {
            return arg1;
        }

        return -(this.getSize$runtime() - arg1 + 2);
    }

    private final Object rawUpdate(Object arg2) {
        Object v0 = this.skip();
        this.set(arg2);
        return v0;
    }

    private final void recalculateMarks() {
        MutableIntList v0 = this.pendingRecalculateMarks;
        if(v0 != null) {
            while(PrioritySet.isNotEmpty-impl(v0)) {
                this.updateContainsMarkNow-qrM0pCk(PrioritySet.takeMax-impl(v0), v0);
            }
        }
    }

    public final void recordGroupSourceInformation(String arg2) {
        if(this.insertCount > 0) {
            this.groupSourceInformationFor(this.parent, arg2);
        }
    }

    public final void recordGrouplessCallSourceInformationEnd() {
        if(this.insertCount > 0) {
            GapGroupSourceInformation v0 = this.groupSourceInformationFor(this.parent, null);
            if(v0 != null) {
                v0.endGrouplessCall(this.getCurrentGroupSlotIndex());
            }
        }
    }

    public final void recordGrouplessCallSourceInformationStart(int arg3, String arg4) {
        if(this.insertCount > 0) {
            MutableIntObjectMap v0 = this.calledByMap;
            if(v0 != null) {
                SlotTableKt.add(v0, arg3, this.groupKey(this.parent));
            }

            GapGroupSourceInformation v0_1 = this.groupSourceInformationFor(this.parent, null);
            if(v0_1 == null) {
                return;
            }

            v0_1.startGrouplessCall(arg3, arg4, this.getCurrentGroupSlotIndex());
        }
    }

    private final boolean removeAnchors(int arg7, int arg8, HashMap arg9) {
        arg8 += arg7;
        int v0 = SlotTableKt.locationOf(this.anchors, arg8, this.getCapacity() - this.groupGapLen);
        if(v0 >= this.anchors.size()) {
            --v0;
        }

        int v1 = v0 + 1;
        boolean v2 = false;
        int v3 = 0;
        while(v0 >= 0) {
            Object v4 = this.anchors.get(v0);
            int v5 = this.anchorIndex(((GapAnchor)v4));
            if(v5 < arg7) {
                break;
            }

            if(v5 < arg8) {
                ((GapAnchor)v4).setLocation$runtime(0x80000000);
                if(arg9 != null) {
                    arg9.remove(v4);
                }

                if(v3 == 0) {
                    v3 = v0 + 1;
                }

                v1 = v0;
            }

            --v0;
        }

        if(v1 < v3) {
            v2 = true;
        }

        if(v2) {
            this.anchors.subList(v1, v3).clear();
        }

        return v2;
    }

    public final boolean removeGroup() {
        int v0 = this.insertCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot remove group while inserting");
        }

        v0 = this.currentGroup;
        int v1 = this.currentSlot;
        int v2 = this.dataIndex(this.groups, this.groupIndexToAddress(v0));
        int v3 = this.skipGroup();
        GapGroupSourceInformation v4 = this.sourceInformationOf$runtime(this.parent);
        if(v4 != null) {
            GapAnchor v5 = this.tryAnchor$runtime(v0);
            if(v5 != null) {
                v4.removeAnchor(v5);
            }
        }

        MutableIntList v4_1 = this.pendingRecalculateMarks;
        if(v4_1 != null) {
            while(PrioritySet.isNotEmpty-impl(v4_1)) {
                if(PrioritySet.peek-impl(v4_1) < v0) {
                    break;
                }

                PrioritySet.takeMax-impl(v4_1);
            }
        }

        boolean v4_2 = this.removeGroups(v0, this.currentGroup - v0);
        this.removeSlots(v2, this.currentSlot - v2, v0 - 1);
        this.currentGroup = v0;
        this.currentSlot = v1;
        this.nodeCount -= v3;
        return v4_2;
    }

    private final boolean removeGroups(int arg3, int arg4) {
        boolean v0 = false;
        if(arg4 > 0) {
            ArrayList v1 = this.anchors;
            this.moveGroupGapTo(arg3);
            if(!((Collection)v1).isEmpty()) {
                v0 = this.removeAnchors(arg3, arg4, this.sourceInformationMap);
            }

            this.groupGapStart = arg3;
            this.groupGapLen += arg4;
            int v1_1 = this.slotsGapOwner;
            if(v1_1 > arg3) {
                this.slotsGapOwner = Math.max(arg3, v1_1 - arg4);
            }

            arg3 = this.currentGroupEnd;
            if(arg3 >= this.groupGapStart) {
                this.currentGroupEnd = arg3 - arg4;
            }

            arg3 = this.parent;
            if(!this.containsGroupMark(arg3)) {
                return v0;
            }

            this.updateContainsMark(arg3);
        }

        return v0;
    }

    private final void removeSlots(int arg3, int arg4, int arg5) {
        if(arg4 > 0) {
            int v0 = this.slotsGapLen;
            int v1 = arg3 + arg4;
            this.moveSlotGapTo(v1, arg5);
            this.slotsGapStart = arg3;
            this.slotsGapLen = v0 + arg4;
            ArraysKt.fill(this.slots, null, arg3, v1);
            arg5 = this.currentSlotEnd;
            if(arg5 >= arg3) {
                this.currentSlotEnd = arg5 - arg4;
            }
        }
    }

    public final void reset() {
        int v0 = this.insertCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Cannot reset when inserting");
        }

        this.recalculateMarks();
        this.currentGroup = 0;
        this.currentGroupEnd = this.getCapacity() - this.groupGapLen;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
        this.nodeCount = 0;
    }

    private final int restoreCurrentGroupEnd() {
        int v0 = this.getCapacity() - this.groupGapLen - this.endStack.pop();
        this.currentGroupEnd = v0;
        return v0;
    }

    private final void saveCurrentGroupEnd() {
        this.endStack.push(this.getCapacity() - this.groupGapLen - this.currentGroupEnd);
    }

    public final void seek(GapAnchor arg2) {
        this.advanceBy(arg2.toIndexFor(this) - this.currentGroup);
    }

    public final void set(Object arg4) {
        int v0 = this.currentSlot <= this.currentSlotEnd ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Writing to an invalid slot");
        }

        this.slots[this.dataIndexToDataAddress(this.currentSlot - 1)] = arg4;
    }

    public final Object set(int arg1, int arg2, Object arg3) {
        arg1 = this.dataIndexToDataAddress(this.slotIndexOfGroupSlotIndex(arg1, arg2));
        Object[] v0 = this.slots;
        Object v2 = v0[arg1];
        v0[arg1] = arg3;
        return v2;
    }

    public final Object set(int arg2, Object arg3) {
        return this.set(this.getCurrentGroup(), arg2, arg3);
    }

    public final Object skip() {
        if(this.insertCount > 0) {
            this.insertSlots(1, this.parent);
        }

        Object[] v0 = this.slots;
        int v1 = this.currentSlot;
        this.currentSlot = v1 + 1;
        return v0[this.dataIndexToDataAddress(v1)];
    }

    public final int skipGroup() {
        int v0 = this.groupIndexToAddress(this.currentGroup);
        int v1 = this.currentGroup + SlotTableKt.groupSize(this.groups, v0);
        this.currentGroup = v1;
        this.currentSlot = this.dataIndex(this.groups, this.groupIndexToAddress(v1));
        int v3 = this.groups[v0 * 5 + 1];
        if((0x40000000 & v3) != 0) {
            return 1;
        }

        return v3 & 0x3FFFFFF;
    }

    public final void skipToGroupEnd() {
        int v0 = this.currentGroupEnd;
        this.currentGroup = v0;
        this.currentSlot = this.dataIndex(this.groups, this.groupIndexToAddress(v0));
    }

    public final Object slot(GapAnchor arg1, int arg2) {
        return this.slot(this.anchorIndex(arg1), arg2);
    }

    public final Object slot(int arg3, int arg4) {
        int v0 = this.slotIndex(this.groups, this.groupIndexToAddress(arg3));
        arg3 = this.dataIndex(this.groups, this.groupIndexToAddress(arg3 + 1));
        arg4 += v0;
        if(v0 <= arg4 && arg4 < arg3) {
            return this.slots[this.dataIndexToDataAddress(arg4)];
        }

        return Composer.Companion.getEmpty();
    }

    private final int slotIndex(int[] arg2, int arg3) {
        if(arg3 >= this.getCapacity()) {
            return this.slots.length - this.slotsGapLen;
        }

        return this.dataAnchorToDataIndex(SlotTableKt.slotAnchor(arg2, arg3), this.slotsGapLen, this.slots.length);
    }

    public final int slotIndexOfGroupSlotIndex(int arg4, int arg5) {
        int v0 = this.slotIndex(this.groups, this.groupIndexToAddress(arg4));
        int v3 = this.dataIndex(this.groups, this.groupIndexToAddress(arg4 + 1));
        int v1 = v0 + arg5;
        v3 = v1 < v0 || v1 >= v3 ? 0 : 1;
        if(v3 == 0) {
            ComposerKt.composeImmediateRuntimeError("Write to an invalid slot index " + arg5 + " for group " + arg4);
        }

        return v1;
    }

    public final int slotsEndAllIndex$runtime(int arg3) {
        return this.dataIndex(this.groups, this.groupIndexToAddress(arg3 + this.groupSize(arg3)));
    }

    public final int slotsEndIndex$runtime(int arg2) {
        return this.dataIndex(this.groups, this.groupIndexToAddress(arg2 + 1));
    }

    public final int slotsStartIndex$runtime(int arg2) {
        return this.slotIndex(this.groups, this.groupIndexToAddress(arg2));
    }

    public final GapGroupSourceInformation sourceInformationOf$runtime(int arg3) {
        HashMap v0 = this.sourceInformationMap;
        GapGroupSourceInformation v1 = null;
        if(v0 != null) {
            GapAnchor v2 = this.tryAnchor$runtime(arg3);
            if(v2 != null) {
                return v0.get(v2);
            }
        }

        return v1;
    }

    public final void startData(int arg2, Object arg3, Object arg4) {
        this.startGroup(arg2, arg3, false, arg4);
    }

    public final void startData(int arg3, Object arg4) {
        this.startGroup(arg3, Composer.Companion.getEmpty(), false, arg4);
    }

    public final void startGroup(int arg3, Object arg4) {
        this.startGroup(arg3, arg4, false, Composer.Companion.getEmpty());
    }

    public final void startGroup() {
        int v0 = this.insertCount == 0 ? 1 : 0;
        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError("Key must be supplied when inserting");
        }

        this.startGroup(0, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    private final void startGroup(int arg17, Object arg18, boolean arg19, Object arg20) {
        int v1_1;
        SlotWriter v0 = this;
        Object v1 = arg18;
        Object v2 = arg20;
        int v3 = v0.parent;
        int v4 = v0.insertCount > 0 ? 1 : 0;
        v0.nodeCountStack.push(v0.nodeCount);
        if(v4 != 0) {
            v4 = v0.currentGroup;
            int v7 = v0.dataIndex(v0.groups, v0.groupIndexToAddress(v4));
            v0.insertGroups(1);
            v0.currentSlot = v7;
            v0.currentSlotEnd = v7;
            int v9 = v0.groupIndexToAddress(v4);
            boolean v12 = v1 != Composer.Companion.getEmpty() ? true : false;
            boolean v13 = (arg19) || v2 == Composer.Companion.getEmpty() ? false : true;
            v7 = v0.dataIndexToDataAnchor(v7, v0.slotsGapStart, v0.slotsGapLen, v0.slots.length);
            if(v7 >= 0 && v0.slotsGapOwner < v4) {
                v7 = -(v0.slots.length - v0.slotsGapLen - v7 + 1);
            }

            SlotTableKt.initGroup(v0.groups, v9, arg17, arg19, v12, v13, v0.parent, v7);
            int v6 = (((int)arg19)) + (((int)v12)) + (((int)v13));
            if(v6 > 0) {
                v0.insertSlots(v6, v4);
                Object[] v6_1 = v0.slots;
                v7 = v0.currentSlot;
                if(arg19) {
                    v6_1[v7] = v2;
                    ++v7;
                }

                if(v12) {
                    v6_1[v7] = v1;
                    ++v7;
                }

                if(v13) {
                    v6_1[v7] = v2;
                    ++v7;
                }

                v0.currentSlot = v7;
            }

            v0.nodeCount = 0;
            v1_1 = v4 + 1;
            v0.parent = v4;
            v0.currentGroup = v1_1;
            if(v3 < 0) {
                goto label_119;
            }

            GapGroupSourceInformation v2_1 = v0.sourceInformationOf$runtime(v3);
            if(v2_1 == null) {
                goto label_119;
            }

            v2_1.reportGroup(v0, v4);
        }
        else {
            v0.startStack.push(v3);
            v0.saveCurrentGroupEnd();
            v1_1 = v0.currentGroup;
            v3 = v0.groupIndexToAddress(v1_1);
            if(!Intrinsics.areEqual(v2, Composer.Companion.getEmpty())) {
                if(arg19) {
                    v0.updateNode(v2);
                }
                else {
                    v0.updateAux(v2);
                }
            }

            v0.currentSlot = v0.slotIndex(v0.groups, v3);
            v0.currentSlotEnd = v0.dataIndex(v0.groups, v0.groupIndexToAddress(v0.currentGroup + 1));
            int[] v2_2 = v0.groups;
            v0.nodeCount = v2_2[v3 * 5 + 1] & 0x3FFFFFF;
            v0.parent = v1_1;
            v0.currentGroup = v1_1 + 1;
            v1_1 += SlotTableKt.groupSize(v2_2, v3);
        }

    label_119:
        v0.currentGroupEnd = v1_1;
    }

    public final void startGroup(int arg4) {
        this.startGroup(arg4, Composer.Companion.getEmpty(), false, Composer.Companion.getEmpty());
    }

    public final void startNode(int arg3, Object arg4) {
        this.startGroup(arg3, arg4, true, Composer.Companion.getEmpty());
    }

    public final void startNode(int arg2, Object arg3, Object arg4) {
        this.startGroup(arg2, arg3, true, arg4);
    }

    public final String toDebugString() {
        StringBuilder v0 = new StringBuilder();
        char v2 = '\n';
        v0.append(this.toString()).append(v2);
        v0.append("  parent:    " + this.parent).append(v2);
        v0.append("  current:   " + this.currentGroup).append(v2);
        v0.append("  group gap: " + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + '(' + this.groupGapLen + ')').append(v2);
        v0.append("  slots gap: " + this.slotsGapStart + '-' + (this.slotsGapStart + this.slotsGapLen) + '(' + this.slotsGapLen + ')').append(v2);
        v0.append("  gap owner: " + this.slotsGapOwner).append(v2);
        int v1 = this.getSize$runtime();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            this.groupAsString(v0, v3);
            v0.append(v2);
        }

        return v0.toString();
    }

    public String toString() {
        return "SlotWriter(current = " + this.currentGroup + " end=" + this.currentGroupEnd + " size = " + this.getSize$runtime() + " gap=" + this.groupGapStart + '-' + (this.groupGapStart + this.groupGapLen) + ')';
    }

    public final void traverseGroupAndChildren(int arg9, Function1 arg10, Function1 arg11) {
        int v0 = this.parent(arg9);
        int v1 = this.getSize$runtime();
        int v2 = this.groupSize(arg9) + arg9;
        int v3 = arg9;
        while(v3 < v2) {
            arg10.invoke(Integer.valueOf(v3));
            int v4 = v3 + 1;
            int v5 = v4 < v1 ? this.parent(v4) : -1;
            if(v5 != v3) {
                while(true) {
                    arg11.invoke(Integer.valueOf(v3));
                    if(v3 != arg9 && v0 != v5) {
                        v3 = v0;
                        v0 = this.parent(v0);
                        continue;
                    }

                    break;
                }
            }

            v3 = v4;
            v0 = v5;
        }
    }

    public final void trimTailSlots(int arg8) {
        int v0 = 0;
        int v2 = arg8 > 0 ? 1 : 0;
        String v3 = "Check failed";
        if(v2 == 0) {
            ComposerKt.composeImmediateRuntimeError(v3);
        }

        v2 = this.parent;
        int v4 = this.slotIndex(this.groups, this.groupIndexToAddress(v2));
        int v5 = this.dataIndex(this.groups, this.groupIndexToAddress(v2 + 1)) - arg8;
        if(v5 >= v4) {
            v0 = 1;
        }

        if(v0 == 0) {
            ComposerKt.composeImmediateRuntimeError(v3);
        }

        this.removeSlots(v5, arg8, v2);
        v0 = this.currentSlot;
        if(v0 >= v4) {
            this.currentSlot = v0 - arg8;
        }
    }

    public final GapAnchor tryAnchor$runtime(int arg2) {
        if(arg2 >= 0 && arg2 < this.getSize$runtime()) {
            return SlotTableKt.find(this.anchors, arg2, this.getSize$runtime());
        }

        return null;
    }

    public final Object update(Object arg6) {
        MutableObjectList v4_1;
        if(this.insertCount > 0 && this.currentSlot != this.slotsGapStart) {
            MutableIntObjectMap v0 = this.deferredSlotWrites;
            DefaultConstructorMarker v1 = null;
            if(v0 == null) {
                v0 = new MutableIntObjectMap(0, 1, v1);
            }

            this.deferredSlotWrites = v0;
            int v5 = this.parent;
            Object v4 = v0.get(v5);
            if(v4 == null) {
                v4_1 = new MutableObjectList(0, 1, v1);
                v0.set(v5, v4_1);
            }

            v4_1.add(arg6);
            return Composer.Companion.getEmpty();
        }

        return this.rawUpdate(arg6);
    }

    private final void updateAnchors(int arg4, int arg5) {
        int v1 = this.getCapacity() - this.groupGapLen;
        ArrayList v0 = this.anchors;
        if(arg4 < arg5) {
            for(arg4 = SlotTableKt.locationOf(v0, arg4, v1); arg4 < this.anchors.size(); ++arg4) {
                Object v0_1 = this.anchors.get(arg4);
                int v2 = ((GapAnchor)v0_1).getLocation$runtime();
                if(v2 >= 0) {
                    return;
                }

                v2 += v1;
                if(v2 >= arg5) {
                    return;
                }

                ((GapAnchor)v0_1).setLocation$runtime(v2);
            }
        }
        else {
            for(arg4 = SlotTableKt.locationOf(v0, arg5, v1); arg4 < this.anchors.size(); ++arg4) {
                Object v5 = this.anchors.get(arg4);
                int v0_2 = ((GapAnchor)v5).getLocation$runtime();
                if(v0_2 < 0) {
                    return;
                }

                ((GapAnchor)v5).setLocation$runtime(-(v1 - v0_2));
            }
        }
    }

    public final void updateAux(Object arg5) {
        int v0 = this.groupIndexToAddress(this.currentGroup);
        int v3 = 1;
        if((this.groups[v0 * 5 + 1] & 0x10000000) != 0) {
        }
        else {
            v3 = 0;
        }

        if(v3 == 0) {
            ComposerKt.composeImmediateRuntimeError("Updating the data of a group that was not created with a data slot");
        }

        this.slots[this.dataIndexToDataAddress(this.auxIndex(this.groups, v0))] = arg5;
    }

    private final void updateContainsMark(int arg3) {
        if(arg3 >= 0) {
            MutableIntList v0 = this.pendingRecalculateMarks;
            if(v0 == null) {
                v0 = PrioritySet.constructor-impl$default(null, 1, null);
                this.pendingRecalculateMarks = v0;
            }

            PrioritySet.add-impl(v0, arg3);
        }
    }

    private final void updateContainsMarkNow-qrM0pCk(int arg7, MutableIntList arg8) {
        int v0 = this.groupIndexToAddress(arg7);
        boolean v1 = this.childContainsAnyMarks(arg7);
        int[] v2 = this.groups;
        boolean v4 = true;
        if((v2[v0 * 5 + 1] & 0x4000000) != 0) {
        }
        else {
            v4 = false;
        }

        if(v4 != v1) {
            SlotTableKt.updateContainsMark(v2, v0, v1);
            int v6 = this.parent(arg7);
            if(v6 >= 0) {
                PrioritySet.add-impl(arg8, v6);
            }
        }
    }

    private final void updateDataIndex(int[] arg4, int arg5, int arg6) {
        arg4[arg5 * 5 + 4] = this.dataIndexToDataAnchor(arg6, this.slotsGapStart, this.slotsGapLen, this.slots.length);
    }

    public final void updateNode(Object arg2) {
        this.updateNodeOfGroup(this.currentGroup, arg2);
    }

    public final void updateNode(GapAnchor arg1, Object arg2) {
        this.updateNodeOfGroup(arg1.toIndexFor(this), arg2);
    }

    private final void updateNodeOfGroup(int arg5, Object arg6) {
        int v3;
        int v0 = this.groupIndexToAddress(arg5);
        int[] v1 = this.groups;
        if(v0 < v1.length) {
            v3 = 1;
            if((v1[v0 * 5 + 1] & 0x40000000) != 0) {
            }
            else {
                goto label_12;
            }
        }
        else {
        label_12:
            v3 = 0;
        }

        if(v3 == 0) {
            ComposerKt.composeImmediateRuntimeError("Updating the node of a group at " + arg5 + " that was not created with as a node group");
        }

        this.slots[this.dataIndexToDataAddress(this.nodeIndex(this.groups, v0))] = arg6;
    }

    public final void updateParentNode(Object arg2) {
        this.updateNodeOfGroup(this.parent, arg2);
    }

    public final void updateToTableMaps() {
        this.sourceInformationMap = this.table.getSourceInformationMap$runtime();
        this.calledByMap = this.table.getCalledByMap$runtime();
    }

    public final void verifyDataAnchors$runtime() {
        int v0 = this.slotsGapOwner;
        int v1 = this.slots.length - this.slotsGapLen;
        int v2 = this.getSize$runtime();
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        while(v4 < v2) {
            int v7 = this.groupIndexToAddress(v4);
            int[] v8 = this.groups;
            int v9 = v8[v7 * 5 + 4];
            v7 = this.dataIndex(v8, v7);
            int v10 = v7 >= v5 ? 1 : 0;
            if(v10 == 0) {
                PreconditionsKt.throwIllegalStateException("Data index out of order at " + v4 + ", previous = " + v5 + ", current = " + v7);
            }

            v5 = v7 <= v1 ? 1 : 0;
            if(v5 == 0) {
                PreconditionsKt.throwIllegalStateException("Data index, " + v7 + ", out of bound at " + v4);
            }

            if(v9 < 0 && v6 == 0) {
                v5 = v0 == v4 ? 1 : 0;
                if(v5 == 0) {
                    PreconditionsKt.throwIllegalStateException("Expected the slot gap owner to be " + v0 + " found gap at " + v4);
                }

                v6 = 1;
            }

            ++v4;
            v5 = v7;
        }
    }

    public final void verifyParentAnchors$runtime() {
        int v6;
        String v5;
        int v0 = this.groupGapStart;
        int v1 = this.groupGapLen;
        int v2 = this.getCapacity();
        int v4;
        for(v4 = 0; true; ++v4) {
            v5 = "Expected a start relative anchor at ";
            v6 = -2;
            int v7 = 1;
            if(v4 >= v0) {
                break;
            }

            if(this.groups[v4 * 5 + 2] > v6) {
            }
            else {
                v7 = 0;
            }

            if(v7 == 0) {
                PreconditionsKt.throwIllegalStateException(v5 + v4);
            }
        }

        v1 += v0;
        while(v1 < v2) {
            v4 = this.groups[v1 * 5 + 2];
            if(this.parentAnchorToIndex(v4) < v0) {
                v4 = v4 > v6 ? 1 : 0;
                if(v4 != 0) {
                    goto label_54;
                }

                PreconditionsKt.throwIllegalStateException(v5 + v1);
            }
            else {
                v4 = v4 <= v6 ? 1 : 0;
                if(v4 != 0) {
                    goto label_54;
                }

                PreconditionsKt.throwIllegalStateException("Expected an end relative anchor at " + v1);
            }

        label_54:
            ++v1;
        }
    }
}

