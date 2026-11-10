package androidx.compose.ui.text.android;

import android.text.Layout$Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\tH\u0016¨\u0006\r"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "<init>", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class StaticLayoutFactoryDefault implements StaticLayoutFactoryImpl {
    @Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactoryDefault$Companion;", "", "<init>", "()V", "isInitialized", "", "staticLayoutConstructor", "Ljava/lang/reflect/Constructor;", "Landroid/text/StaticLayout;", "getStaticLayoutConstructor", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public static final Constructor access$getStaticLayoutConstructor(Companion arg0) {
            return arg0.getStaticLayoutConstructor();
        }

        private final Constructor getStaticLayoutConstructor() {
            if(StaticLayoutFactoryDefault.isInitialized) {
                return StaticLayoutFactoryDefault.staticLayoutConstructor;
            }

            StaticLayoutFactoryDefault.isInitialized = true;
            try {
                StaticLayoutFactoryDefault.staticLayoutConstructor = StaticLayout.class.getConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout$Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils$TruncateAt.class, Integer.TYPE, Integer.TYPE);
            }
            catch(NoSuchMethodException ) {
                StaticLayoutFactoryDefault.staticLayoutConstructor = null;
                Log.e("StaticLayoutFactory", "unable to collect necessary constructor.");
            }

            return StaticLayoutFactoryDefault.staticLayoutConstructor;
        }
    }

    public static final Companion Companion;
    private static boolean isInitialized;
    private static Constructor staticLayoutConstructor;

    static {
        StaticLayoutFactoryDefault.Companion = new Companion(null);
    }

    public StaticLayoutFactoryDefault() {
        super();
    }

    public static final Constructor access$getStaticLayoutConstructor$cp() {
        return StaticLayoutFactoryDefault.staticLayoutConstructor;
    }

    public static final boolean access$isInitialized$cp() {
        return StaticLayoutFactoryDefault.isInitialized;
    }

    public static final void access$setInitialized$cp(boolean arg0) {
        StaticLayoutFactoryDefault.isInitialized = arg0;
    }

    public static final void access$setStaticLayoutConstructor$cp(Constructor arg0) {
        StaticLayoutFactoryDefault.staticLayoutConstructor = arg0;
    }

    public StaticLayout create(StaticLayoutParams arg18) {
        String v0 = "unable to call constructor";
        String v1 = "StaticLayoutFactory";
        Constructor v2 = Companion.access$getStaticLayoutConstructor(StaticLayoutFactoryDefault.Companion);
        Object v3 = null;
        if(v2 != null) {
            try {
                v3 = v2.newInstance(arg18.getText(), Integer.valueOf(arg18.getStart()), Integer.valueOf(arg18.getEnd()), arg18.getPaint(), Integer.valueOf(arg18.getWidth()), arg18.getAlignment(), arg18.getTextDir(), Float.valueOf(arg18.getLineSpacingMultiplier()), Float.valueOf(arg18.getLineSpacingExtra()), Boolean.valueOf(arg18.getIncludePadding()), arg18.getEllipsize(), Integer.valueOf(arg18.getEllipsizedWidth()), Integer.valueOf(arg18.getMaxLines()));
            }
            catch(InvocationTargetException ) {
                StaticLayoutFactoryDefault.staticLayoutConstructor = ((Constructor)v3);
                Log.e(v1, v0);
            }
            catch(InstantiationException ) {
                StaticLayoutFactoryDefault.staticLayoutConstructor = ((Constructor)v3);
                Log.e(v1, v0);
            }
            catch(IllegalAccessException ) {
                StaticLayoutFactoryDefault.staticLayoutConstructor = ((Constructor)v3);
                Log.e(v1, v0);
            }
        }

        if(v3 != null) {
            return ((StaticLayout)v3);
        }

        return new StaticLayout(arg18.getText(), arg18.getStart(), arg18.getEnd(), arg18.getPaint(), arg18.getWidth(), arg18.getAlignment(), arg18.getLineSpacingMultiplier(), arg18.getLineSpacingExtra(), arg18.getIncludePadding(), arg18.getEllipsize(), arg18.getEllipsizedWidth());
    }

    public boolean isFallbackLineSpacingEnabled(StaticLayout arg1, boolean arg2) {
        return 0;
    }
}

