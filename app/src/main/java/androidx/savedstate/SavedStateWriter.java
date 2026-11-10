package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000B\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0004\b\r\u0010\u000EJ\u001D\u0010\u000F\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0013\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0017\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ\u001D\u0010\u001B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u001C¢\u0006\u0004\b\u001D\u0010\u001EJ\u001D\u0010\u001F\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020 ¢\u0006\u0004\b!\u0010\"J\u001D\u0010#\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020$¢\u0006\u0004\b%\u0010&J\u001D\u0010\'\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010+\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b,\u0010-J\'\u0010.\u001A\u00020\b\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u0002H/¢\u0006\u0004\b1\u00102J\'\u00103\u001A\u00020\b\"\b\b\u0000\u0010/*\u0002042\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u0002H/¢\u0006\u0004\b5\u00106J\u001D\u00107\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u000208¢\u0006\u0004\b9\u0010:J\u001D\u0010;\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020<¢\u0006\u0004\b=\u0010>J\u001D\u0010?\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b@\u0010AJ#\u0010B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020$0C¢\u0006\u0004\bD\u0010EJ#\u0010F\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00180C¢\u0006\u0004\bG\u0010EJ\'\u0010H\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0010\u0010\u000B\u001A\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040C¢\u0006\u0004\bI\u0010EJ#\u0010J\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0C¢\u0006\u0004\bK\u0010EJ-\u0010L\u001A\u00020\b\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H/0C¢\u0006\u0004\bM\u0010EJ\u001D\u0010N\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020O¢\u0006\u0004\bP\u0010QJ\u001D\u0010R\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020S¢\u0006\u0004\bT\u0010UJ#\u0010V\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00180W¢\u0006\u0004\bX\u0010YJ\u001D\u0010Z\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020[¢\u0006\u0004\b\\\u0010]J\u001D\u0010^\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020_¢\u0006\u0004\b`\u0010aJ\u001D\u0010b\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020c¢\u0006\u0004\bd\u0010eJ\u001D\u0010f\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020g¢\u0006\u0004\bh\u0010iJ\'\u0010j\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0010\u0010\u000B\u001A\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040W¢\u0006\u0004\bk\u0010lJ#\u0010m\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0W¢\u0006\u0004\bn\u0010oJ-\u0010p\u001A\u00020\b\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H/0W¢\u0006\u0004\bq\u0010rJ-\u0010s\u001A\u00020\b\"\b\b\u0000\u0010/*\u0002002\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H/0t¢\u0006\u0004\bu\u0010vJ!\u0010w\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\n\u0010\u000B\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\bx\u0010yJ\u0019\u0010z\u001A\u00020\b2\n\u0010{\u001A\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b|\u0010}J\u0015\u0010~\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n¢\u0006\u0004\b\u007F\u0010-J\u0010\u0010\u0080\u0001\u001A\u00020\b¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001E\u0010\u0083\u0001\u001A\u00020\u00102\t\u0010\u0084\u0001\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0013\u0010\u0087\u0001\u001A\u00020$HÖ\u0001¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0013\u0010\u008A\u0001\u001A\u00020\nHÖ\u0001¢\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001R\u0012\u0010\u0002\u001A\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006\u008D\u0001"}, d2={"Landroidx/savedstate/SavedStateWriter;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "putBinder", "", "key", "", "value", "Landroid/os/IBinder;", "putBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/IBinder;)V", "putBoolean", "", "putBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;Z)V", "putChar", "", "putChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;C)V", "putCharSequence", "", "putCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/CharSequence;)V", "putDouble", "", "putDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;D)V", "putFloat", "", "putFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;F)V", "putInt", "", "putInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;I)V", "putLong", "", "putLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;J)V", "putNull", "putNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)V", "putParcelable", "T", "Landroid/os/Parcelable;", "putParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Parcelable;)V", "putJavaSerializable", "Ljava/io/Serializable;", "putJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "putSize", "Landroid/util/Size;", "putSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/Size;)V", "putSizeF", "Landroid/util/SizeF;", "putSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SizeF;)V", "putString", "putString-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "putIntList", "", "putIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;)V", "putCharSequenceList", "putCharSequenceList-impl", "putSavedStateList", "putSavedStateList-impl", "putStringList", "putStringList-impl", "putParcelableList", "putParcelableList-impl", "putBooleanArray", "", "putBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Z)V", "putCharArray", "", "putCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[C)V", "putCharSequenceArray", "", "putCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/CharSequence;)V", "putDoubleArray", "", "putDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[D)V", "putFloatArray", "", "putFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[F)V", "putIntArray", "", "putIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[I)V", "putLongArray", "", "putLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[J)V", "putSavedStateArray", "putSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Bundle;)V", "putStringArray", "putStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/lang/String;)V", "putParcelableArray", "putParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "putSparseParcelableArray", "Landroid/util/SparseArray;", "putSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/util/SparseArray;)V", "putSavedState", "putSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;)V", "putAll", "from", "putAll-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)V", "remove", "remove-impl", "clear", "clear-impl", "(Landroid/os/Bundle;)V", "equals", "other", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "(Landroid/os/Bundle;)I", "toString", "toString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) @JvmInline public final class SavedStateWriter {
    private final Bundle source;

    private SavedStateWriter(Bundle arg1) {
        super();
        this.source = arg1;
    }

    public static final SavedStateWriter box-impl(Bundle arg1) {
        return new SavedStateWriter(arg1);
    }

    public static final void clear-impl(Bundle arg0) {
        arg0.clear();
    }

    public static Bundle constructor-impl(Bundle arg1) {
        Intrinsics.checkNotNullParameter(arg1, "source");
        return arg1;
    }

    public boolean equals(Object arg1) {
        return SavedStateWriter.equals-impl(this.source, arg1);
    }

    public static boolean equals-impl(Bundle arg2, Object arg3) {
        if(!(arg3 instanceof SavedStateWriter)) {
            return 0;
        }

        if(!Intrinsics.areEqual(arg2, ((SavedStateWriter)arg3).unbox-impl())) {
            return 0;
        }

        return 1;
    }

    public static final boolean equals-impl0(Bundle arg0, Bundle arg1) {
        return Intrinsics.areEqual(arg0, arg1);
    }

    public int hashCode() {
        return SavedStateWriter.hashCode-impl(this.source);
    }

    public static int hashCode-impl(Bundle arg0) {
        return arg0.hashCode();
    }

    public static final void putAll-impl(Bundle arg1, Bundle arg2) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        arg1.putAll(arg2);
    }

    public static final void putBinder-impl(Bundle arg1, String arg2, IBinder arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putBinder(arg2, arg3);
    }

    public static final void putBoolean-impl(Bundle arg1, String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putBoolean(arg2, arg3);
    }

    public static final void putBooleanArray-impl(Bundle arg1, String arg2, boolean[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putBooleanArray(arg2, arg3);
    }

    public static final void putChar-impl(Bundle arg1, String arg2, char arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putChar(arg2, arg3);
    }

    public static final void putCharArray-impl(Bundle arg1, String arg2, char[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putCharArray(arg2, arg3);
    }

    public static final void putCharSequence-impl(Bundle arg1, String arg2, CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putCharSequence(arg2, arg3);
    }

    public static final void putCharSequenceArray-impl(Bundle arg1, String arg2, CharSequence[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putCharSequenceArray(arg2, arg3);
    }

    public static final void putCharSequenceList-impl(Bundle arg1, String arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putCharSequenceArrayList(arg2, SavedStateWriterKt.toArrayListUnsafe(((Collection)arg3)));
    }

    public static final void putDouble-impl(Bundle arg1, String arg2, double arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putDouble(arg2, arg3);
    }

    public static final void putDoubleArray-impl(Bundle arg1, String arg2, double[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putDoubleArray(arg2, arg3);
    }

    public static final void putFloat-impl(Bundle arg1, String arg2, float arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putFloat(arg2, arg3);
    }

    public static final void putFloatArray-impl(Bundle arg1, String arg2, float[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putFloatArray(arg2, arg3);
    }

    public static final void putInt-impl(Bundle arg1, String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putInt(arg2, arg3);
    }

    public static final void putIntArray-impl(Bundle arg1, String arg2, int[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putIntArray(arg2, arg3);
    }

    public static final void putIntList-impl(Bundle arg1, String arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putIntegerArrayList(arg2, SavedStateWriterKt.toArrayListUnsafe(((Collection)arg3)));
    }

    public static final void putJavaSerializable-impl(Bundle arg1, String arg2, Serializable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putSerializable(arg2, arg3);
    }

    public static final void putLong-impl(Bundle arg1, String arg2, long arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putLong(arg2, arg3);
    }

    public static final void putLongArray-impl(Bundle arg1, String arg2, long[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putLongArray(arg2, arg3);
    }

    public static final void putNull-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.putString(arg2, null);
    }

    public static final void putParcelable-impl(Bundle arg1, String arg2, Parcelable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putParcelable(arg2, arg3);
    }

    public static final void putParcelableArray-impl(Bundle arg1, String arg2, Parcelable[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putParcelableArray(arg2, arg3);
    }

    public static final void putParcelableList-impl(Bundle arg1, String arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putParcelableArrayList(arg2, SavedStateWriterKt.toArrayListUnsafe(((Collection)arg3)));
    }

    public static final void putSavedState-impl(Bundle arg1, String arg2, Bundle arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putBundle(arg2, arg3);
    }

    public static final void putSavedStateArray-impl(Bundle arg1, String arg2, Bundle[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        SavedStateWriter.putParcelableArray-impl(arg1, arg2, ((Parcelable[])arg3));
    }

    public static final void putSavedStateList-impl(Bundle arg1, String arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        SavedStateWriter.putParcelableList-impl(arg1, arg2, arg3);
    }

    public static final void putSize-impl(Bundle arg1, String arg2, Size arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putSize(arg2, arg3);
    }

    public static final void putSizeF-impl(Bundle arg1, String arg2, SizeF arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putSizeF(arg2, arg3);
    }

    public static final void putSparseParcelableArray-impl(Bundle arg1, String arg2, SparseArray arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putSparseParcelableArray(arg2, arg3);
    }

    public static final void putString-impl(Bundle arg1, String arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putString(arg2, arg3);
    }

    public static final void putStringArray-impl(Bundle arg1, String arg2, String[] arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putStringArray(arg2, arg3);
    }

    public static final void putStringList-impl(Bundle arg1, String arg2, List arg3) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1.putStringArrayList(arg2, SavedStateWriterKt.toArrayListUnsafe(((Collection)arg3)));
    }

    public static final void remove-impl(Bundle arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "key");
        arg1.remove(arg2);
    }

    public String toString() {
        return SavedStateWriter.toString-impl(this.source);
    }

    public static String toString-impl(Bundle arg2) {
        return "SavedStateWriter(source=" + arg2 + ')';
    }

    public final Bundle unbox-impl() {
        return this.source;
    }
}

