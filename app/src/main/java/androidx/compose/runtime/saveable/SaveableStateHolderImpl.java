package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B1\u0012(\b\u0002\u0010\u0002\u001A\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00042\u0011\u0010\u0018\u001A\r\u0012\u0004\u0012\u00020\u00160\u0019¢\u0006\u0002\b\u001AH\u0017¢\u0006\u0002\u0010\u001BJ*\u0010\u001C\u001A$\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u0005\u0018\u00010\u0003H\u0002J\u0010\u0010\u001D\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0004H\u0016J<\u0010\u001E\u001A\u00020\u0016*\u00020\f2&\u0010\u001F\u001A\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u00032\u0006\u0010\u0017\u001A\u00020\u0004H\u0002R.\u0010\u0002\u001A\"\u0012\u0004\u0012\u00020\u0004\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\r\u001A\u0004\u0018\u00010\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2={"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "savedStates", "", "", "", "", "", "<init>", "(Ljava/util/Map;)V", "registries", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "parentSaveableStateRegistry", "getParentSaveableStateRegistry", "()Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "setParentSaveableStateRegistry", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;)V", "canBeSaved", "Lkotlin/Function1;", "", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "saveAll", "removeState", "saveTo", "map", "Companion", "runtime-saveable"}, k=1, mv={2, 1, 0}, xi=0x30) final class SaveableStateHolderImpl implements SaveableStateHolder {
    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\u0004\u001A\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2={"Landroidx/compose/runtime/saveable/SaveableStateHolderImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/saveable/SaveableStateHolderImpl;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "runtime-saveable"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }

        public final Saver getSaver() {
            return SaveableStateHolderImpl.Saver;
        }
    }

    public static final Companion Companion;
    private static final Saver Saver;
    private final Function1 canBeSaved;
    private SaveableStateRegistry parentSaveableStateRegistry;
    private final MutableScatterMap registries;
    private final Map savedStates;

    public static DisposableEffectResult $r8$lambda$dY-R2u7aBBNRLgMjL53qJRgF29s(SaveableStateHolderImpl arg0, Object arg1, SaveableStateRegistryWrapper arg2, DisposableEffectScope arg3) {
        return SaveableStateHolderImpl.SaveableStateProvider$lambda$0$1$0(arg0, arg1, arg2, arg3);
    }

    static {
        SaveableStateHolderImpl.Companion = new Companion(null);
        SaveableStateHolderImpl.Saver = SaverKt.Saver(new SaveableStateHolderImpl$$ExternalSyntheticLambda3(), new SaveableStateHolderImpl$$ExternalSyntheticLambda4());
    }

    public SaveableStateHolderImpl() {
        this(null, 1, null);
    }

    public SaveableStateHolderImpl(Map arg1, int arg2, DefaultConstructorMarker arg3) {
        LinkedHashMap v1;
        if((arg2 & 1) != 0) {
            v1 = new LinkedHashMap();
        }

        this(((Map)v1));
    }

    public SaveableStateHolderImpl(Map arg1) {
        super();
        this.savedStates = arg1;
        this.registries = ScatterMapKt.mutableScatterMapOf();
        this.canBeSaved = new SaveableStateHolderImpl$$ExternalSyntheticLambda0(this);
    }

    public void SaveableStateProvider(Object arg9, Function2 arg10, Composer arg11, int arg12) {
        int v3;
        int v1;
        int v0 = 0x1FCD8740;
        arg11 = arg11.startRestartGroup(v0);
        ComposerKt.sourceInformation(arg11, "C(SaveableStateProvider)N(key,content)71@3248L1083:SaveableStateHolder.kt#r2ddri");
        int v2 = 2;
        if((arg12 & 6) == 0) {
            v1 = arg11.changedInstance(arg9) ? 4 : v2;
            v1 |= arg12;
        }
        else {
            v1 = arg12;
        }

        if((arg12 & 0x30) == 0) {
            v3 = arg11.changedInstance(arg10) ? 0x20 : 16;
            v1 |= v3;
        }

        if((arg12 & 0x180) == 0) {
            v3 = arg11.changedInstance(this) ? 0x100 : 0x80;
            v1 |= v3;
        }

        boolean v3_1 = (v1 & 0x93) != 0x92 ? true : false;
        if(arg11.shouldExecute(v3_1, v1 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v1, -1, "androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:70)");
            }

            ComposerKt.sourceInformationMarkerStart(arg11, 1800201264, "CC(ReusableContent)N(key,content)143@5486L9:Composables.kt#9igjgp");
            arg11.startReusableGroup(0xCF, arg9);
            ComposerKt.sourceInformationMarkerStart(arg11, 0xA5D6B6B7, "C72@3298L408,81@3719L200,86@3955L366,86@3932L389:SaveableStateHolder.kt#r2ddri");
            String v3_2 = "CC(remember):SaveableStateHolder.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(arg11, 0x15DDA236, v3_2);
            Object v0_1 = arg11.rememberedValue();
            if(v0_1 == Composer.Companion.getEmpty()) {
                if(this.canBeSaved.invoke(arg9).booleanValue()) {
                    SaveableStateRegistryWrapper v0_2 = new SaveableStateRegistryWrapper(SaveableStateRegistryKt.SaveableStateRegistry(this.savedStates.get(arg9), this.canBeSaved));
                    arg11.updateRememberedValue(v0_2);
                }
                else {
                    throw new IllegalArgumentException("Type of the key " + arg9 + " is not supported. On Android you can only use types which can be stored inside the Bundle.".toString());
                }
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            ProvidedValue[] v2_1 = new ProvidedValue[v2];
            v2_1[0] = SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(v0_1);
            v2_1[1] = LocalSavedStateRegistryOwnerKt.getLocalSavedStateRegistryOwner().provides(v0_1);
            CompositionLocalKt.CompositionLocalProvider(v2_1, arg10, arg11, v1 & 0x70 | ProvidedValue.$stable);
            Unit v1_1 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(arg11, 366867500, v3_2);
            v2 = arg11.changedInstance(this) | arg11.changedInstance(arg9) | arg11.changedInstance(v0_1);
            Object v3_3 = arg11.rememberedValue();
            if(v2 != 0 || v3_3 == Composer.Companion.getEmpty()) {
                SaveableStateHolderImpl$$ExternalSyntheticLambda1 v3_4 = new SaveableStateHolderImpl$$ExternalSyntheticLambda1(this, arg9, ((SaveableStateRegistryWrapper)v0_1));
                arg11.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(arg11);
            EffectsKt.DisposableEffect(v1_1, ((Function1)v3_3), arg11, 6);
            ComposerKt.sourceInformationMarkerEnd(arg11);
            arg11.endReusableGroup();
            ComposerKt.sourceInformationMarkerEnd(arg11);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_124;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            arg11.skipToGroupEnd();
        }

    label_124:
        ScopeUpdateScope v11 = arg11.endRestartGroup();
        if(v11 != null) {
            v11.updateScope(new SaveableStateHolderImpl$$ExternalSyntheticLambda2(this, arg9, arg10, arg12));
        }
    }

    private static final DisposableEffectResult SaveableStateProvider$lambda$0$1$0(SaveableStateHolderImpl arg0, Object arg1, SaveableStateRegistryWrapper arg2, DisposableEffectScope arg3) {
        if(!arg0.registries.contains(arg1)) {
            arg0.savedStates.remove(arg1);
            arg0.registries.set(arg1, arg2);
            return new SaveableStateHolderImpl$SaveableStateProvider$lambda$0$1$0$$inlined$onDispose$1(arg0, arg1, arg2);
        }

        throw new IllegalArgumentException("Key " + arg1 + " was used multiple times ".toString());
    }

    static final Unit SaveableStateProvider$lambda$1(SaveableStateHolderImpl arg0, Object arg1, Function2 arg2, int arg3, Composer arg4, int arg5) {
        arg0.SaveableStateProvider(arg1, arg2, arg4, RecomposeScopeImplKt.updateChangedFlags(arg3 | 1));
        return Unit.INSTANCE;
    }

    static final Map Saver$lambda$0(SaverScope arg0, SaveableStateHolderImpl arg1) {
        return arg1.saveAll();
    }

    static final SaveableStateHolderImpl Saver$lambda$1(Map arg1) {
        return new SaveableStateHolderImpl(arg1);
    }

    public static final MutableScatterMap access$getRegistries$p(SaveableStateHolderImpl arg0) {
        return arg0.registries;
    }

    public static final Map access$getSavedStates$p(SaveableStateHolderImpl arg0) {
        return arg0.savedStates;
    }

    public static final Saver access$getSaver$cp() {
        return SaveableStateHolderImpl.Saver;
    }

    public static final void access$saveTo(SaveableStateHolderImpl arg0, SaveableStateRegistry arg1, Map arg2, Object arg3) {
        arg0.saveTo(arg1, arg2, arg3);
    }

    static final boolean canBeSaved$lambda$0(SaveableStateHolderImpl arg0, Object arg1) {
        SaveableStateRegistry v0 = arg0.parentSaveableStateRegistry;
        if(v0 != null) {
            return v0.canBeSaved(arg1);
        }

        return 1;
    }

    public final SaveableStateRegistry getParentSaveableStateRegistry() {
        return this.parentSaveableStateRegistry;
    }

    public void removeState(Object arg2) {
        if(this.registries.remove(arg2) == null) {
            this.savedStates.remove(arg2);
        }
    }

    private final Map saveAll() {
        SaveableStateHolderImpl v0 = this;
        Map v1 = v0.savedStates;
        MutableScatterMap v2 = v0.registries;
        Object[] v3 = ((ScatterMap)v2).keys;
        Object[] v4 = ((ScatterMap)v2).values;
        long[] v2_1 = ((ScatterMap)v2).metadata;
        int v5 = v2_1.length - 2;
        if(v5 >= 0) {
            int v7;
            for(v7 = 0; true; ++v7) {
                long v8 = v2_1[v7];
                if((~v8 << 7 & v8 & -9187201950435737472L) != -9187201950435737472L) {
                    int v11 = 8;
                    int v10 = 8 - (~(v7 - v5) >>> 0x1F);
                    int v12;
                    for(v12 = 0; v12 < v10; ++v12) {
                        if((0xFF & v8) < 0x80) {
                            int v13 = (v7 << 3) + v12;
                            v0.saveTo(v4[v13], v1, v3[v13]);
                        }

                        v8 >>= v11;
                    }

                    if(v10 != v11) {
                        break;
                    }
                }

                if(v7 == v5) {
                    break;
                }
            }
        }

        if(v1.isEmpty()) {
            return null;
        }

        return v1;
    }

    private final void saveTo(SaveableStateRegistry arg1, Map arg2, Object arg3) {
        Map v0 = arg1.performSave();
        if(v0.isEmpty()) {
            arg2.remove(arg3);
            return;
        }

        arg2.put(arg3, v0);
    }

    public final void setParentSaveableStateRegistry(SaveableStateRegistry arg1) {
        this.parentSaveableStateRegistry = arg1;
    }
}

