package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleCompat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

@Metadata(d1={"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0010$\n\u0002\b\n\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u000E\u0010\fJ\u0015\u0010\u000F\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u0004\u0018\u00010\u00102\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001A\u00020\u00172\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001A\u001A\u0004\u0018\u00010\u00172\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u001B\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010!\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\"\u0010 J\u0015\u0010#\u001A\u00020$2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b%\u0010&J\u0017\u0010\'\u001A\u0004\u0018\u00010$2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001A\u00020+2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001A\u0004\u0018\u00010+2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b/\u00100J\u0015\u00101\u001A\u0002022\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b3\u00104J\u0017\u00105\u001A\u0004\u0018\u0001022\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b6\u00107J\u0015\u00108\u001A\u0002092\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001A\u0004\u0018\u0001092\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b=\u0010>J-\u0010?\u001A\u0002H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bD\u0010EJ$\u0010?\u001A\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\bD\u0010FJ/\u0010G\u001A\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bH\u0010EJ&\u0010G\u001A\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\bH\u0010FJ-\u0010I\u001A\u0002H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001A\u00020\n2\f\u0010K\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bL\u0010MJ$\u0010I\u001A\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\bL\u0010NJ/\u0010O\u001A\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001A\u00020\n2\f\u0010K\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bP\u0010MJ&\u0010O\u001A\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\bP\u0010NJ\u0015\u0010Q\u001A\u00020R2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001A\u0004\u0018\u00010R2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bV\u0010TJ\u0015\u0010W\u001A\u00020X2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001A\u0004\u0018\u00010X2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\\\u0010ZJ\u001F\u0010]\u001A\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b_\u0010`J!\u0010a\u001A\u000E\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bb\u0010`J\u0015\u0010c\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001A\u0004\u0018\u00010\n2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bg\u0010eJ\u001B\u0010h\u001A\b\u0012\u0004\u0012\u0002020i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bj\u0010kJ\u001D\u0010l\u001A\n\u0012\u0004\u0012\u000202\u0018\u00010i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bm\u0010kJ\u001B\u0010n\u001A\b\u0012\u0004\u0012\u00020\u001E0i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bo\u0010kJ\u001D\u0010p\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bq\u0010kJ\u001F\u0010r\u001A\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bs\u0010kJ!\u0010t\u001A\u000E\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bu\u0010kJ\u001B\u0010v\u001A\b\u0012\u0004\u0012\u00020\n0i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\bw\u0010kJ\u001D\u0010x\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010i2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\by\u0010kJ3\u0010z\u001A\b\u0012\u0004\u0012\u0002H@0i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b{\u0010|J*\u0010z\u001A\b\u0012\u0004\u0012\u0002H@0i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\b{\u0010kJ5\u0010}\u001A\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b~\u0010|J,\u0010}\u001A\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0004\b~\u0010kJ\u0018\u0010\u007F\u001A\u00030\u0080\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001B\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0080\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0084\u0001\u0010\u0082\u0001J\u0019\u0010\u0085\u0001\u001A\u00030\u0086\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001B\u0010\u0089\u0001\u001A\u0005\u0018\u00010\u0086\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u008A\u0001\u0010\u0088\u0001J\u001E\u0010\u008B\u0001\u001A\b\u0012\u0004\u0012\u00020\u001E0^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u008C\u0001\u0010\u008D\u0001J \u0010\u008E\u0001\u001A\n\u0012\u0004\u0012\u00020\u001E\u0018\u00010^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u008F\u0001\u0010\u008D\u0001J\u0019\u0010\u0090\u0001\u001A\u00030\u0091\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001B\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u0091\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001J\u0019\u0010\u0096\u0001\u001A\u00030\u0097\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001B\u0010\u009A\u0001\u001A\u0005\u0018\u00010\u0097\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u009B\u0001\u0010\u0099\u0001J\u0019\u0010\u009C\u0001\u001A\u00030\u009D\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b\u009E\u0001\u0010\u009F\u0001J\u001B\u0010 \u0001\u001A\u0005\u0018\u00010\u009D\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b¡\u0001\u0010\u009F\u0001J\u0019\u0010¢\u0001\u001A\u00030£\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001B\u0010¦\u0001\u001A\u0005\u0018\u00010£\u00012\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b§\u0001\u0010¥\u0001J\u001E\u0010¨\u0001\u001A\b\u0012\u0004\u0012\u00020\n0^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b©\u0001\u0010ª\u0001J \u0010«\u0001\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010^2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b¬\u0001\u0010ª\u0001J6\u0010­\u0001\u001A\b\u0012\u0004\u0012\u0002H@0^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b®\u0001\u0010¯\u0001J-\u0010­\u0001\u001A\b\u0012\u0004\u0012\u0002H@0^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0006\b®\u0001\u0010°\u0001J8\u0010±\u0001\u001A\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b²\u0001\u0010¯\u0001J/\u0010±\u0001\u001A\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0006\b²\u0001\u0010°\u0001J7\u0010³\u0001\u001A\t\u0012\u0004\u0012\u0002H@0´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\bµ\u0001\u0010¶\u0001J.\u0010³\u0001\u001A\t\u0012\u0004\u0012\u0002H@0´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0006\bµ\u0001\u0010·\u0001J9\u0010¸\u0001\u001A\u000B\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001A\u00020\n2\f\u0010B\u001A\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b¹\u0001\u0010¶\u0001J0\u0010¸\u0001\u001A\u000B\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001A\u00020\nH\u0086\b¢\u0006\u0006\b¹\u0001\u0010·\u0001J\u001C\u0010º\u0001\u001A\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b»\u0001\u0010¼\u0001J \u0010½\u0001\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\t\u001A\u00020\n¢\u0006\u0006\b¾\u0001\u0010¼\u0001J\u0010\u0010¿\u0001\u001A\u000202¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001A\u00020\u0010¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u0017\u0010Å\u0001\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\n¢\u0006\u0005\bÆ\u0001\u0010\u0012J\u001A\u0010Ç\u0001\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\nH\u0086\u0002¢\u0006\u0005\bÈ\u0001\u0010\u0012J\u001D\u0010É\u0001\u001A\u00020\u00102\u000B\u0010Ê\u0001\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0010\u0010Í\u0001\u001A\u000202¢\u0006\u0006\bÎ\u0001\u0010Á\u0001J\u0010\u0010Ï\u0001\u001A\u00020\n¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001F\u0010Ò\u0001\u001A\u0011\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ó\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u001E\u0010Ö\u0001\u001A\u00020\u00102\t\u0010Ê\u0001\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u0013\u0010Ù\u0001\u001A\u000202HÖ\u0001¢\u0006\u0006\bÚ\u0001\u0010Á\u0001J\u0013\u0010Û\u0001\u001A\u00020\nHÖ\u0001¢\u0006\u0006\bÜ\u0001\u0010Ñ\u0001R\u0012\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006Ý\u0001"}, d2={"Landroidx/savedstate/SavedStateReader;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "getBinder", "Landroid/os/IBinder;", "key", "", "getBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;", "getBinderOrNull", "getBinderOrNull-impl", "getBoolean", "", "getBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Z", "getBooleanOrNull", "getBooleanOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "getChar", "", "getChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;)C", "getCharOrNull", "getCharOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Character;", "getCharSequence", "", "getCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/CharSequence;", "getCharSequenceOrNull", "getCharSequenceOrNull-impl", "getDouble", "", "getDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;)D", "getDoubleOrNull", "getDoubleOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "getFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;)F", "getFloatOrNull", "getFloatOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "getInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;)I", "getIntOrNull", "getIntOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "getLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;)J", "getLongOrNull", "getLongOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "getParcelable", "T", "Landroid/os/Parcelable;", "parcelableClass", "Lkotlin/reflect/KClass;", "getParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull", "getParcelableOrNull-impl", "getJavaSerializable", "Ljava/io/Serializable;", "serializableClass", "getJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getJavaSerializableOrNull", "getJavaSerializableOrNull-impl", "getSize", "Landroid/util/Size;", "getSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/Size;", "getSizeOrNull", "getSizeOrNull-impl", "getSizeF", "Landroid/util/SizeF;", "getSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SizeF;", "getSizeFOrNull", "getSizeFOrNull-impl", "getSavedStateArray", "", "getSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Bundle;", "getSavedStateArrayOrNull", "getSavedStateArrayOrNull-impl", "getString", "getString-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "getStringOrNull-impl", "getIntList", "", "getIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getIntListOrNull", "getIntListOrNull-impl", "getCharSequenceList", "getCharSequenceList-impl", "getCharSequenceListOrNull", "getCharSequenceListOrNull-impl", "getSavedStateList", "getSavedStateList-impl", "getSavedStateListOrNull", "getSavedStateListOrNull-impl", "getStringList", "getStringList-impl", "getStringListOrNull", "getStringListOrNull-impl", "getParcelableList", "getParcelableList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/util/List;", "getParcelableListOrNull", "getParcelableListOrNull-impl", "getBooleanArray", "", "getBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Z", "getBooleanArrayOrNull", "getBooleanArrayOrNull-impl", "getCharArray", "", "getCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[C", "getCharArrayOrNull", "getCharArrayOrNull-impl", "getCharSequenceArray", "getCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArrayOrNull", "getCharSequenceArrayOrNull-impl", "getDoubleArray", "", "getDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[D", "getDoubleArrayOrNull", "getDoubleArrayOrNull-impl", "getFloatArray", "", "getFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[F", "getFloatArrayOrNull", "getFloatArrayOrNull-impl", "getIntArray", "", "getIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[I", "getIntArrayOrNull", "getIntArrayOrNull-impl", "getLongArray", "", "getLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[J", "getLongArrayOrNull", "getLongArrayOrNull-impl", "getStringArray", "getStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "getStringArrayOrNull", "getStringArrayOrNull-impl", "getParcelableArray", "getParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)[Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "getParcelableArrayOrNull", "getParcelableArrayOrNull-impl", "getSparseParcelableArray", "Landroid/util/SparseArray;", "getSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/util/SparseArray;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SparseArray;", "getSparseParcelableArrayOrNull", "getSparseParcelableArrayOrNull-impl", "getSavedState", "getSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "getSavedStateOrNull", "getSavedStateOrNull-impl", "size", "size-impl", "(Landroid/os/Bundle;)I", "isEmpty", "isEmpty-impl", "(Landroid/os/Bundle;)Z", "isNull", "isNull-impl", "contains", "contains-impl", "contentDeepEquals", "other", "contentDeepEquals-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepHashCode", "contentDeepHashCode-impl", "contentDeepToString", "contentDeepToString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "toMap", "", "toMap-impl", "(Landroid/os/Bundle;)Ljava/util/Map;", "equals", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SavedStateReader {
    private final Bundle source;

    private SavedStateReader(Bundle arg1) {
        super();
        this.source = arg1;
    }

    public static final SavedStateReader box-impl(Bundle arg1) {
        return new SavedStateReader(arg1);
    }

    public static Bundle constructor-impl(Bundle arg1) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        return arg1;
    }

    public static final boolean contains-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.containsKey(arg2);
    }

    public static final boolean contentDeepEquals-impl(Bundle arg1, Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepEquals(arg1, arg2);
    }

    public static final int contentDeepHashCode-impl(Bundle arg0) {
        return SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepHashCode(arg0);
    }

    public static final String contentDeepToString-impl(Bundle arg2) {
        StringBuilder v1 = new StringBuilder(RangesKt.coerceAtMost(arg2.size(), 0x19999999) * 5 + 2);
        SavedStateReaderKt__SavedStateReader_androidKt.access$contentDeepToString(arg2, v1, new ArrayList());
        String v2 = v1.toString();
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        return v2;
    }

    public boolean equals(Object arg1) {
        return SavedStateReader.equals-impl(this.source, arg1);
    }

    public static boolean equals-impl(Bundle arg2, Object arg3) {
        if(!(arg3 instanceof SavedStateReader)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SavedStateReader)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Bundle arg0, Bundle arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public static final IBinder getBinder-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        IBinder v1 = arg1.getBinder(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final IBinder getBinderOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getBinder(arg2);
    }

    public static final boolean getBoolean-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        boolean v0 = arg2.getBoolean(arg3, false);
        if(!v0) {
            if(!arg2.getBoolean(arg3, true)) {
            }
            else {
                SavedStateReaderKt.keyOrValueNotFoundError(arg3);
                throw new KotlinNothingValueException();
            }
        }

        return v0;
    }

    public static final boolean[] getBooleanArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        boolean[] v1 = arg1.getBooleanArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final boolean[] getBooleanArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getBooleanArray(arg2);
    }

    public static final Boolean getBooleanOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        boolean v0 = arg2.getBoolean(arg3, false);
        if(!v0 && (arg2.getBoolean(arg3, true))) {
            return null;
        }

        return Boolean.valueOf(v0);
    }

    public static final char getChar-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        char v0 = arg2.getChar(arg3, '\u0000');
        if(v0 == 0) {
            if(arg2.getChar(arg3, '\uFFFF') != '\uFFFF') {
            }
            else {
                SavedStateReaderKt.keyOrValueNotFoundError(arg3);
                throw new KotlinNothingValueException();
            }
        }

        return v0;
    }

    public static final char[] getCharArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        char[] v1 = arg1.getCharArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final char[] getCharArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getCharArray(arg2);
    }

    public static final Character getCharOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        char v0 = arg2.getChar(arg3, '\u0000');
        if(v0 == 0 && arg2.getChar(arg3, '\uFFFF') == '\uFFFF') {
            return null;
        }

        return Character.valueOf(v0);
    }

    public static final CharSequence getCharSequence-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        CharSequence v1 = arg1.getCharSequence(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final CharSequence[] getCharSequenceArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        CharSequence[] v1 = arg1.getCharSequenceArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final CharSequence[] getCharSequenceArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getCharSequenceArray(arg2);
    }

    public static final List getCharSequenceList-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        ArrayList v1 = arg1.getCharSequenceArrayList(arg2);
        if(v1 != null) {
            return ((List)v1);
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final List getCharSequenceListOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getCharSequenceArrayList(arg2);
    }

    public static final CharSequence getCharSequenceOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getCharSequence(arg2);
    }

    public static final double getDouble-impl(Bundle arg6, String arg7) {
        Intrinsics.checkNotNullParameter(arg7, "key");
        double v2 = arg6.getDouble(arg7, 4.900000E-324);
        if(v2 == 4.900000E-324) {
            if(arg6.getDouble(arg7, 1.797693E+308) != 1.797693E+308) {
                return v2;
            }

            SavedStateReaderKt.keyOrValueNotFoundError(arg7);
            throw new KotlinNothingValueException();
        }

        return v2;
    }

    public static final double[] getDoubleArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        double[] v1 = arg1.getDoubleArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final double[] getDoubleArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getDoubleArray(arg2);
    }

    public static final Double getDoubleOrNull-impl(Bundle arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        double v2 = arg4.getDouble(arg5, 4.900000E-324);
        if(v2 == 4.900000E-324 && arg4.getDouble(arg5, 1.797693E+308) == 1.797693E+308) {
            return null;
        }

        return Double.valueOf(v2);
    }

    public static final float getFloat-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        float v1 = arg2.getFloat(arg3, 1.401298E-45f);
        if(v1 == 1.401298E-45f) {
            if(arg2.getFloat(arg3, 3.402823E+38f) != 3.402823E+38f) {
                return v1;
            }

            SavedStateReaderKt.keyOrValueNotFoundError(arg3);
            throw new KotlinNothingValueException();
        }

        return v1;
    }

    public static final float[] getFloatArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        float[] v1 = arg1.getFloatArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final float[] getFloatArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getFloatArray(arg2);
    }

    public static final Float getFloatOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        float v1 = arg2.getFloat(arg3, 1.401298E-45f);
        if(v1 == 1.401298E-45f && arg2.getFloat(arg3, 3.402823E+38f) == 3.402823E+38f) {
            return null;
        }

        return Float.valueOf(v1);
    }

    public static final int getInt-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        int v1 = arg2.getInt(arg3, 0x80000000);
        if(v1 == 0x80000000) {
            if(arg2.getInt(arg3, 0x7FFFFFFF) != 0x7FFFFFFF) {
            }
            else {
                SavedStateReaderKt.keyOrValueNotFoundError(arg3);
                throw new KotlinNothingValueException();
            }
        }

        return v1;
    }

    public static final int[] getIntArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        int[] v1 = arg1.getIntArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final int[] getIntArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getIntArray(arg2);
    }

    public static final List getIntList-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        ArrayList v1 = arg1.getIntegerArrayList(arg2);
        if(v1 != null) {
            return ((List)v1);
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final List getIntListOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getIntegerArrayList(arg2);
    }

    public static final Integer getIntOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        int v1 = arg2.getInt(arg3, 0x80000000);
        if(v1 == 0x80000000 && arg2.getInt(arg3, 0x7FFFFFFF) == 0x7FFFFFFF) {
            return null;
        }

        return Integer.valueOf(v1);
    }

    public static final Serializable getJavaSerializable-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getJavaSerializable-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    public static final Serializable getJavaSerializable-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "serializableClass");
        Serializable v1 = BundleCompat.getSerializable(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final Serializable getJavaSerializableOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getJavaSerializableOrNull-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    public static final Serializable getJavaSerializableOrNull-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "serializableClass");
        return BundleCompat.getSerializable(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
    }

    public static final long getLong-impl(Bundle arg6, String arg7) {
        Intrinsics.checkNotNullParameter(arg7, "key");
        long v2 = arg6.getLong(arg7, -9223372036854775808L);
        if(v2 == -9223372036854775808L) {
            if(arg6.getLong(arg7, 0x7FFFFFFFFFFFFFFFL) != 0x7FFFFFFFFFFFFFFFL) {
            }
            else {
                SavedStateReaderKt.keyOrValueNotFoundError(arg7);
                throw new KotlinNothingValueException();
            }
        }

        return v2;
    }

    public static final long[] getLongArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        long[] v1 = arg1.getLongArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final long[] getLongArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getLongArray(arg2);
    }

    public static final Long getLongOrNull-impl(Bundle arg4, String arg5) {
        Intrinsics.checkNotNullParameter(arg5, "key");
        long v2 = arg4.getLong(arg5, -9223372036854775808L);
        if(v2 == -9223372036854775808L && arg4.getLong(arg5, 0x7FFFFFFFFFFFFFFFL) == 0x7FFFFFFFFFFFFFFFL) {
            return null;
        }

        return Long.valueOf(v2);
    }

    public static final Parcelable getParcelable-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelable-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final Parcelable getParcelable-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        Object v1 = BundleCompat.getParcelable(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
        if(v1 != null) {
            return ((Parcelable)v1);
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final Parcelable[] getParcelableArray-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableArray-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final Parcelable[] getParcelableArray-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        Parcelable[] v1 = SavedStateReader.getParcelableArrayOrNull-impl(arg1, arg2, arg3);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final Parcelable[] getParcelableArrayOrNull-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        Parcelable[] v1 = BundleCompat.getParcelableArray(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
        if((v1 instanceof Parcelable[])) {
            return v1;
        }

        return null;
    }

    public static final Parcelable[] getParcelableArrayOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableArrayOrNull-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final List getParcelableList-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableList-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final List getParcelableList-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        ArrayList v1 = BundleCompat.getParcelableArrayList(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
        if(v1 != null) {
            return ((List)v1);
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final List getParcelableListOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableListOrNull-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final List getParcelableListOrNull-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        return BundleCompat.getParcelableArrayList(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
    }

    public static final Parcelable getParcelableOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getParcelableOrNull-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final Parcelable getParcelableOrNull-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        return BundleCompat.getParcelable(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
    }

    public static final Bundle getSavedState-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1 = arg1.getBundle(arg2);
        if(arg1 != null) {
            return arg1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final Bundle[] getSavedStateArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return SavedStateReader.getParcelableArray-impl(arg1, arg2, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final Bundle[] getSavedStateArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return SavedStateReader.getParcelableArrayOrNull-impl(arg1, arg2, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final List getSavedStateList-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return SavedStateReader.getParcelableList-impl(arg1, arg2, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final List getSavedStateListOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return SavedStateReader.getParcelableListOrNull-impl(arg1, arg2, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    public static final Bundle getSavedStateOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getBundle(arg2);
    }

    public static final Size getSize-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Size v1 = arg1.getSize(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final SizeF getSizeF-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        SizeF v1 = arg1.getSizeF(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final SizeF getSizeFOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getSizeF(arg2);
    }

    public static final Size getSizeOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getSize(arg2);
    }

    public static final SparseArray getSparseParcelableArray-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getSparseParcelableArray-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final SparseArray getSparseParcelableArray-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        SparseArray v1 = SavedStateReader.getSparseParcelableArrayOrNull-impl(arg1, arg2, arg3);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final SparseArray getSparseParcelableArrayOrNull-impl(Bundle arg1, String arg2, KClass arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(arg1, arg2, JvmClassMappingKt.getJavaClass(arg3));
    }

    public static final SparseArray getSparseParcelableArrayOrNull-impl(Bundle arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return SavedStateReader.getSparseParcelableArrayOrNull-impl(arg2, arg3, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    public static final String getString-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        String v1 = arg1.getString(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final String[] getStringArray-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        String[] v1 = arg1.getStringArray(arg2);
        if(v1 != null) {
            return v1;
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final String[] getStringArrayOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getStringArray(arg2);
    }

    public static final List getStringList-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        ArrayList v1 = arg1.getStringArrayList(arg2);
        if(v1 != null) {
            return ((List)v1);
        }

        SavedStateReaderKt.keyOrValueNotFoundError(arg2);
        throw new KotlinNothingValueException();
    }

    public static final List getStringListOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getStringArrayList(arg2);
    }

    public static final String getStringOrNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        return arg1.getString(arg2);
    }

    public int hashCode() {
        return SavedStateReader.hashCode-impl(this.source);
    }

    public static int hashCode-impl(Bundle arg0) {
        return arg0.hashCode();
    }

    public static final boolean isEmpty-impl(Bundle arg0) {
        return arg0.isEmpty();
    }

    public static final boolean isNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        if((SavedStateReader.contains-impl(arg1, arg2)) && arg1.get(arg2) == null) {
            return 1;
        }

        return 0;
    }

    public static final int size-impl(Bundle arg0) {
        return arg0.size();
    }

    public static final Map toMap-impl(Bundle arg4) {
        Map v0 = MapsKt.createMapBuilder(arg4.size());
        Iterator v1 = arg4.keySet().iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Intrinsics.checkNotNull(v2);
            v0.put(v2, arg4.get(((String)v2)));
        }

        return MapsKt.build(v0);
    }

    public String toString() {
        return SavedStateReader.toString-impl(this.source);
    }

    public static String toString-impl(Bundle arg2) {
        return "SavedStateReader(source=" + arg2 + ')';
    }

    public final Bundle unbox-impl() {
        return this.source;
    }
}

