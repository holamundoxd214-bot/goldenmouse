package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001+B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001A\u00020\u0011H\u0016J\u0018\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016H\u0016J \u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0016H\u0016J\b\u0010\u001B\u001A\u00020\u0011H\u0016J\u001D\u0010\u001C\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ\u001D\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001D\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001EJ3\u0010 \u001A\u00020\u00112\u001F\u0010!\u001A\u001B\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00110\"¢\u0006\u0002\b#2\b\u0010$\u001A\u0004\u0018\u00010\nH\u0016J\b\u0010%\u001A\u00020\u0011H\u0016J\u001C\u0010&\u001A\u00020\u00112\f\u0010\'\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010(\u001A\u00020)J\u0006\u0010*\u001A\u00020\u0011R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001C\u0010\u000B\u001A\u00028\u0000X\u0096\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u0005¨\u0006,"}, d2={"Landroidx/compose/runtime/RecordingApplier;", "N", "Landroidx/compose/runtime/Applier;", "root", "<init>", "(Ljava/lang/Object;)V", "operations", "Landroidx/collection/MutableIntList;", "instances", "Landroidx/collection/MutableObjectList;", "", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "down", "", "node", "up", "remove", "index", "", "count", "move", "from", "to", "clear", "insertBottomUp", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "apply", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "value", "reuse", "playTo", "applier", "rememberManager", "Landroidx/compose/runtime/internal/RememberEventDispatcher;", "markRecomposePending", "Companion", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class RecordingApplier implements Applier {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/runtime/RecordingApplier$Companion;", "", "<init>", "()V", "UP", "", "DOWN", "REMOVE", "MOVE", "CLEAR", "INSERT_BOTTOM_UP", "INSERT_TOP_DOWN", "APPLY", "REUSE", "RECOMPOSE_PENDING", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final int APPLY = 7;
    public static final int CLEAR = 4;
    public static final Companion Companion = null;
    public static final int DOWN = 1;
    public static final int INSERT_BOTTOM_UP = 5;
    public static final int INSERT_TOP_DOWN = 6;
    public static final int MOVE = 3;
    public static final int RECOMPOSE_PENDING = 9;
    public static final int REMOVE = 2;
    public static final int REUSE = 8;
    public static final int UP;
    private Object current;
    private final MutableObjectList instances;
    private final MutableIntList operations;

    static {
        RecordingApplier.Companion = new Companion(null);
        RecordingApplier.$stable = 8;
    }

    public RecordingApplier(Object arg5) {
        super();
        this.operations = new MutableIntList(0, 1, null);
        this.instances = new MutableObjectList(0, 1, null);
        this.current = arg5;
    }

    public void apply(Function2 arg3, Object arg4) {
        this.operations.add(7);
        this.instances.add(arg3);
        this.instances.add(arg4);
    }

    public void clear() {
        this.operations.add(4);
    }

    public void down(Object arg3) {
        this.operations.add(1);
        this.instances.add(arg3);
    }

    public Object getCurrent() {
        return this.current;
    }

    public void insertBottomUp(int arg3, Object arg4) {
        this.operations.add(5);
        this.operations.add(arg3);
        this.instances.add(arg4);
    }

    public void insertTopDown(int arg3, Object arg4) {
        this.operations.add(6);
        this.operations.add(arg3);
        this.instances.add(arg4);
    }

    public final void markRecomposePending() {
        this.operations.add(9);
    }

    public void move(int arg3, int arg4, int arg5) {
        this.operations.add(3);
        this.operations.add(arg3);
        this.operations.add(arg4);
        this.operations.add(arg5);
    }

    public final void playTo(Applier arg13, RememberEventDispatcher arg14) {
        int v9;
        MutableIntList v1 = this.operations;
        int v0 = v1._size;
        MutableObjectList v12 = this.instances;
        int v4 = 0;
        MutableObjectList v2 = new MutableObjectList(0, 1, null);
        arg13.onBeginChanges();
        int v3 = 0;
        int v6 = 0;
        while(true) {
            if(v3 >= v0) {
                goto label_84;
            }

            int v7 = v3 + 1;
            try {
                switch(v1.get(v3)) {
                    case 0: {
                        goto label_77;
                    }
                    case 1: {
                        goto label_72;
                    }
                    case 2: {
                        goto label_62;
                    }
                    case 3: {
                        goto label_50;
                    }
                    case 4: {
                        goto label_48;
                    }
                    case 5: {
                        goto label_41;
                    }
                    case 6: {
                        goto label_35;
                    }
                    case 7: {
                        goto label_25;
                    }
                    case 8: {
                        goto label_17;
                    }
                }

                goto label_78;
            label_17:
                Object v3_1 = arg13.getCurrent();
                if((v3_1 instanceof ComposeNodeLifecycleCallback)) {
                    arg14.dispatchOnDeactivateIfNecessary(v3_1);
                }

                v2.add(v3_1);
                arg13.reuse();
                goto label_78;
            }
            catch(Exception v0_1) {
                goto label_81;
            }
            catch(Throwable v0_2) {
                goto label_95;
            }

        label_50:
            int v8 = v3 + 2;
            try {
                v7 = v1.get(v7);
                v9 = v3 + 3;
            }
            catch(Exception v0_1) {
                goto label_69;
            }
            catch(Throwable v0_2) {
                goto label_95;
            }

            try {
                v8 = v1.get(v8);
                v3 += 4;
                goto label_55;
            }
            catch(Throwable v0_2) {
            }
            catch(Exception v0_1) {
                Exception v14 = v0_1;
                v3 = v9;
                goto label_99;
                try {
                label_55:
                    arg13.move(v7, v8, v1.get(v9));
                    continue;
                }
                catch(Exception v0_1) {
                    goto label_98;
                }
                catch(Throwable v0_2) {
                    goto label_95;
                }

            label_35:
                v3 += 2;
                try {
                    v8 = v6 + 1;
                    arg13.insertTopDown(v1.get(v7), v12.get(v6));
                    goto label_46;
                }
                catch(Exception v0_1) {
                    goto label_98;
                }
                catch(Throwable v0_2) {
                    goto label_95;
                }

            label_72:
                v3 = v6 + 1;
                try {
                    arg13.down(v12.get(v6));
                    v6 = v3;
                    goto label_78;
                }
                catch(Exception v0_1) {
                    goto label_81;
                }
                catch(Throwable v0_2) {
                    goto label_95;
                }

                try {
                label_41:
                    v3 += 2;
                    v8 = v6 + 1;
                    arg13.insertBottomUp(v1.get(v7), v12.get(v6));
                }
                catch(Exception v0_1) {
                    goto label_98;
                }
                catch(Throwable v0_2) {
                    goto label_95;
                }

            label_46:
                v6 = v8;
                continue;
                try {
                label_25:
                    v3 = v6 + 1;
                    Object v8_1 = v12.get(v6);
                    Intrinsics.checkNotNull(v8_1, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
                    v6 += 2;
                    arg13.apply(TypeIntrinsics.beforeCheckcastToFunctionOfArity(v8_1, 2), v12.get(v3));
                    goto label_78;
                label_77:
                    arg13.up();
                    goto label_78;
                }
                catch(Exception v0_1) {
                    goto label_81;
                }
                catch(Throwable v0_2) {
                    goto label_95;
                }

            label_62:
                v8 = v3 + 2;
                try {
                    v7 = v1.get(v7);
                    v3 += 3;
                    goto label_65;
                }
                catch(Throwable v0_2) {
                }
                catch(Exception v0_1) {
                label_69:
                    v14 = v0_1;
                    v3 = v8;
                    goto label_99;
                    try {
                    label_65:
                        arg13.remove(v7, v1.get(v8));
                        continue;
                    }
                    catch(Exception v0_1) {
                        goto label_98;
                    }
                    catch(Throwable v0_2) {
                        goto label_95;
                    }

                    try {
                    label_48:
                        arg13.clear();
                        goto label_78;
                    }
                    catch(Throwable v0_2) {
                    }
                    catch(Exception v0_1) {
                    label_81:
                        v14 = v0_1;
                        v3 = v7;
                        goto label_99;
                    label_78:
                        v3 = v7;
                        continue;
                        try {
                        label_84:
                            if(v6 == v12.getSize()) {
                                v4 = 1;
                            }

                            if(v4 == 0) {
                                ComposerKt.composeImmediateRuntimeError("Applier operation size mismatch");
                            }

                            v12.clear();
                            v1.clear();
                            break;
                        }
                        catch(Throwable v0_2) {
                        }
                        catch(Exception v0_1) {
                        label_98:
                            v14 = v0_1;
                            try {
                            label_99:
                                throw new ComposePausableCompositionException(v12, v2, v1, v3 - 1, v14);
                            }
                            catch(Throwable v0_2) {
                            label_95:
                                Throwable v12_1 = v0_2;
                                arg13.onEndChanges();
                                throw v12_1;
                            }
                        }
                    }
                }
            }
        }

        arg13.onEndChanges();
    }

    public void remove(int arg3, int arg4) {
        this.operations.add(2);
        this.operations.add(arg3);
        this.operations.add(arg4);
    }

    public void reuse() {
        this.operations.add(8);
    }

    public void setCurrent(Object arg1) {
        this.current = arg1;
    }

    public void up() {
        this.operations.add(0);
    }
}

