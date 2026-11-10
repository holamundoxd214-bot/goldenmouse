package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\u0007\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u0006H\u0016J\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001A\u00020\u0004H\u0016J \u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0012\u001A\u00020\u00042\u000E\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000FH\u0016J\u001C\u0010\u0016\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016R\u001A\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001A\u001E\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000F0\u000E\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2={"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "Landroidx/collection/MutableScatterMap;", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "performSave", "runtime-saveable"}, k=1, mv={2, 1, 0}, xi=0x30) final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1 canBeSaved;
    private final MutableScatterMap restored;
    private MutableScatterMap valueProviders;

    public SaveableStateRegistryImpl(Map arg1, Function1 arg2) {
        super();
        this.canBeSaved = arg2;
        MutableScatterMap v1 = arg1 == null || (arg1.isEmpty()) ? null : SaveableStateRegistryKt.access$toMutableScatterMap(arg1);
        this.restored = v1;
    }

    public boolean canBeSaved(Object arg1) {
        return this.canBeSaved.invoke(arg1).booleanValue();
    }

    public Object consumeRestored(String arg4) {
        MutableScatterMap v0 = this.restored;
        Object v1 = null;
        Object v0_1 = v0 != null ? v0.remove(arg4) : v1;
        Object v2 = v0_1;
        if(v2 != null) {
            if(((Collection)v2).isEmpty()) {
            }
            else {
                if(((List)v0_1).size() > 1) {
                    MutableScatterMap v3 = this.restored;
                    if(v3 != null) {
                        v3.put(arg4, ((List)v0_1).subList(1, ((List)v0_1).size()));
                    }
                }

                return ((List)v0_1).get(0);
            }
        }

        return v1;
    }

    public Map performSave() {
        long[] v25;
        long v23;
        int v22;
        int v20;
        int v7;
        int v6;
        long v18;
        long v16;
        int v15;
        long[] v1_2;
        SaveableStateRegistryImpl v0 = this;
        MutableScatterMap v1 = v0.restored;
        if(v1 == null && v0.valueProviders == null) {
            return MapsKt.emptyMap();
        }

        int v2 = 0;
        int v1_1 = v1 != null ? v1.getSize() : 0;
        MutableScatterMap v3 = v0.valueProviders;
        int v3_1 = v3 != null ? v3.getSize() : 0;
        HashMap v3_2 = new HashMap(v1_1 + v3_1);
        v1 = v0.restored;
        int v8 = 7;
        long v9 = -9187201950435737472L;
        int v11 = 8;
        if(v1 != null) {
            Object[] v12 = ((ScatterMap)v1).keys;
            Object[] v13 = ((ScatterMap)v1).values;
            v1_2 = ((ScatterMap)v1).metadata;
            int v14 = v1_2.length - 2;
            if(v14 >= 0) {
                v15 = 0;
                v16 = 0x80;
                while(true) {
                    long v4 = v1_2[v15];
                    v18 = 0xFF;
                    if((~v4 << v8 & v4 & v9) != v9) {
                        v6 = 8 - (~(v15 - v14) >>> 0x1F);
                        v7 = 0;
                        while(v7 < v6) {
                            if((v4 & v18) < v16) {
                                v20 = (v15 << 3) + v7;
                                v22 = v8;
                                v23 = v9;
                                v3_2.put(v12[v20], v13[v20]);
                            }
                            else {
                                v22 = v8;
                                v23 = v9;
                            }

                            v4 >>= v11;
                            ++v7;
                            v8 = v22;
                            v9 = v23;
                        }

                        v22 = v8;
                        v23 = v9;
                        if(v6 != v11) {
                            break;
                        }
                    }
                    else {
                        v22 = v8;
                        v23 = v9;
                    }

                    if(v15 == v14) {
                        break;
                    }

                    ++v15;
                    v8 = v22;
                    v9 = v23;
                }
            }
            else {
                goto label_77;
            }
        }
        else {
        label_77:
            v22 = v8;
            v23 = v9;
            v16 = 0x80;
            v18 = 0xFF;
        }

        v1 = v0.valueProviders;
        if(v1 != null) {
            Object[] v4_1 = ((ScatterMap)v1).keys;
            Object[] v5 = ((ScatterMap)v1).values;
            v1_2 = ((ScatterMap)v1).metadata;
            v6 = v1_2.length - 2;
            if(v6 >= 0) {
                v7 = 0;
                while(true) {
                    long v8_1 = v1_2[v7];
                    if((~v8_1 << v22 & v8_1 & v23) != v23) {
                        int v10 = 8 - (~(v7 - v6) >>> 0x1F);
                        int v12_1 = v2;
                        while(v12_1 < v10) {
                            if((v8_1 & v18) < v16) {
                                int v13_1 = (v7 << 3) + v12_1;
                                Object v14_1 = v4_1[v13_1];
                                Object v13_2 = v5[v13_1];
                                v20 = v11;
                                if(((List)v13_2).size() == 1) {
                                    Object v11_1 = ((List)v13_2).get(v2).invoke();
                                    if(v11_1 != null) {
                                        if(v0.canBeSaved(v11_1)) {
                                            v3_2.put(v14_1, CollectionsKt.arrayListOf(new Object[]{v11_1}));
                                        }
                                        else {
                                            throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(v11_1).toString());
                                        }
                                    }

                                    v25 = v1_2;
                                }
                                else {
                                    HashMap v11_2 = v3_2;
                                    v15 = ((List)v13_2).size();
                                    ArrayList v2_1 = new ArrayList(v15);
                                    v25 = v1_2;
                                    for(v1_1 = 0; v1_1 < v15; v1_1 = v27 + 1) {
                                        int v27 = v1_1;
                                        Object v1_3 = ((List)v13_2).get(v1_1).invoke();
                                        if(v1_3 != null) {
                                            if(v0.canBeSaved(v1_3)) {
                                            }
                                            else {
                                                throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(v1_3).toString());
                                            }
                                        }

                                        v2_1.add(v1_3);
                                    }

                                    ((Map)v11_2).put(v14_1, v2_1);
                                }
                            }
                            else {
                                v25 = v1_2;
                                v20 = v11;
                            }

                            v8_1 >>= v20;
                            ++v12_1;
                            v11 = v20;
                            v1_2 = v25;
                            v2 = 0;
                        }

                        v25 = v1_2;
                        v1_1 = v11;
                        if(v10 != v1_1) {
                            break;
                        }
                    }
                    else {
                        v25 = v1_2;
                        v1_1 = v11;
                    }

                    if(v7 == v6) {
                        break;
                    }

                    ++v7;
                    v11 = v1_1;
                    v1_2 = v25;
                    v2 = 0;
                }
            }
        }

        return ((Map)v3_2);
    }

    public Entry registerProvider(String arg2, Function0 arg3) {
        if(!SaveableStateRegistryKt.access$fastIsBlank(arg2)) {
            MutableScatterMap v0 = this.valueProviders;
            if(v0 == null) {
                v0 = ScatterMapKt.mutableScatterMapOf();
                this.valueProviders = v0;
            }

            Object v1 = v0.get(arg2);
            if(v1 == null) {
                ArrayList v1_1 = new ArrayList();
                v0.set(arg2, v1_1);
            }

            ((List)v1).add(arg3);
            return new SaveableStateRegistryImpl$registerProvider$3(v0, arg2, arg3);
        }

        throw new IllegalArgumentException("Registered key is empty or blank".toString());
    }
}

