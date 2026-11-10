package androidx.savedstate.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\'\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0012"}, d2={"Landroidx/savedstate/serialization/SavedStateConfiguration;", "", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "classDiscriminatorMode", "", "encodeDefaults", "", "<init>", "(Lkotlinx/serialization/modules/SerializersModule;IZ)V", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getClassDiscriminatorMode", "()I", "getEncodeDefaults", "()Z", "Builder", "Companion", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SavedStateConfiguration {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u001B\u001A\u00020\u0003H\u0000¢\u0006\u0002\b\u001CR\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR \u0010\f\u001A\u00020\rX\u0086\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001A\u00020\u0015X\u0086\u000E¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000F\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001D"}, d2={"Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "encodeDefaults", "", "getEncodeDefaults$annotations", "()V", "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "classDiscriminatorMode", "", "getClassDiscriminatorMode$annotations", "getClassDiscriminatorMode", "()I", "setClassDiscriminatorMode", "(I)V", "build", "build$savedstate", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Builder {
        private int classDiscriminatorMode;
        private boolean encodeDefaults;
        private SerializersModule serializersModule;

        public Builder(SavedStateConfiguration arg2) {
            Intrinsics.checkNotNullParameter(arg2, "configuration");
            super();
            this.serializersModule = arg2.getSerializersModule();
            this.encodeDefaults = arg2.getEncodeDefaults();
            this.classDiscriminatorMode = arg2.getClassDiscriminatorMode();
        }

        public final SavedStateConfiguration build$savedstate() {
            return new SavedStateConfiguration(SerializersModuleKt.overwriteWith(SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p(), this.serializersModule), this.classDiscriminatorMode, this.encodeDefaults, null);
        }

        public final int getClassDiscriminatorMode() {
            return this.classDiscriminatorMode;
        }

        public static void getClassDiscriminatorMode$annotations() {
        }

        public final boolean getEncodeDefaults() {
            return this.encodeDefaults;
        }

        public static void getEncodeDefaults$annotations() {
        }

        public final SerializersModule getSerializersModule() {
            return this.serializersModule;
        }

        public final void setClassDiscriminatorMode(int arg1) {
            this.classDiscriminatorMode = arg1;
        }

        public final void setEncodeDefaults(boolean arg1) {
            this.encodeDefaults = arg1;
        }

        public final void setSerializersModule(SerializersModule arg2) {
            Intrinsics.checkNotNullParameter(arg2, "<set-?>");
            this.serializersModule = arg2;
        }
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2={"Landroidx/savedstate/serialization/SavedStateConfiguration$Companion;", "", "<init>", "()V", "DEFAULT", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "savedstate"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final Companion Companion;
    public static final SavedStateConfiguration DEFAULT;
    private final int classDiscriminatorMode;
    private final boolean encodeDefaults;
    private final SerializersModule serializersModule;

    static {
        SavedStateConfiguration.Companion = new Companion(null);
        SavedStateConfiguration.DEFAULT = new SavedStateConfiguration(null, 0, false, 7, null);
    }

    SavedStateConfiguration(SerializersModule arg1, int arg2, boolean arg3, int arg4, DefaultConstructorMarker arg5) {
        if((arg4 & 1) != 0) {
            arg1 = SavedStateConfigurationKt.access$getDEFAULT_SERIALIZERS_MODULE$p();
        }

        if((arg4 & 2) != 0) {
            arg2 = 2;
        }

        this(arg1, arg2, false);
    }

    private SavedStateConfiguration(SerializersModule arg1, int arg2, boolean arg3) {
        super();
        this.serializersModule = arg1;
        this.classDiscriminatorMode = arg2;
        this.encodeDefaults = arg3;
    }

    public SavedStateConfiguration(SerializersModule arg1, int arg2, boolean arg3, DefaultConstructorMarker arg4) {
        this(arg1, arg2, arg3);
    }

    public final int getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }
}

