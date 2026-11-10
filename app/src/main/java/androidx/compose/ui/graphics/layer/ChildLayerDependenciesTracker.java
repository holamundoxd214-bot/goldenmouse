package androidx.compose.ui.graphics.layer;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\f\u001A\u00020\r2\u0012\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u000F2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\r0\u0011H\u0086\bJ\u000E\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u0005J\u001D\u0010\u0014\u001A\u00020\r2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u000FH\u0086\bR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2={"Landroidx/compose/ui/graphics/layer/ChildLayerDependenciesTracker;", "", "<init>", "()V", "dependency", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "oldDependency", "dependenciesSet", "Landroidx/collection/MutableScatterSet;", "oldDependenciesSet", "trackingInProgress", "", "withTracking", "", "onDependencyRemoved", "Lkotlin/Function1;", "block", "Lkotlin/Function0;", "onDependencyAdded", "graphicsLayer", "removeDependencies", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ChildLayerDependenciesTracker {
    public static final int $stable = 8;
    private MutableScatterSet dependenciesSet;
    private GraphicsLayer dependency;
    private MutableScatterSet oldDependenciesSet;
    private GraphicsLayer oldDependency;
    private boolean trackingInProgress;

    static {
    }

    public ChildLayerDependenciesTracker() {
        super();
    }

    public static final MutableScatterSet access$getDependenciesSet$p(ChildLayerDependenciesTracker arg0) {
        return arg0.dependenciesSet;
    }

    public static final GraphicsLayer access$getDependency$p(ChildLayerDependenciesTracker arg0) {
        return arg0.dependency;
    }

    public static final MutableScatterSet access$getOldDependenciesSet$p(ChildLayerDependenciesTracker arg0) {
        return arg0.oldDependenciesSet;
    }

    public static final GraphicsLayer access$getOldDependency$p(ChildLayerDependenciesTracker arg0) {
        return arg0.oldDependency;
    }

    public static final void access$setDependency$p(ChildLayerDependenciesTracker arg0, GraphicsLayer arg1) {
        arg0.dependency = arg1;
    }

    public static final void access$setOldDependenciesSet$p(ChildLayerDependenciesTracker arg0, MutableScatterSet arg1) {
        arg0.oldDependenciesSet = arg1;
    }

    public static final void access$setOldDependency$p(ChildLayerDependenciesTracker arg0, GraphicsLayer arg1) {
        arg0.oldDependency = arg1;
    }

    public static final void access$setTrackingInProgress$p(ChildLayerDependenciesTracker arg0, boolean arg1) {
        arg0.trackingInProgress = arg1;
    }

    public final boolean onDependencyAdded(GraphicsLayer arg4) {
        if(!this.trackingInProgress) {
            InlineClassHelperKt.throwIllegalArgumentException("Only add dependencies during a tracking");
        }

        MutableScatterSet v0 = this.dependenciesSet;
        GraphicsLayer v1 = null;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            v0.add(arg4);
        }
        else if(this.dependency != null) {
            v0 = ScatterSetKt.mutableScatterSetOf();
            GraphicsLayer v2 = this.dependency;
            Intrinsics.checkNotNull(v2);
            v0.add(v2);
            v0.add(arg4);
            this.dependenciesSet = v0;
            this.dependency = v1;
        }
        else {
            this.dependency = arg4;
        }

        v0 = this.oldDependenciesSet;
        if(v0 != null) {
            Intrinsics.checkNotNull(v0);
            return v0.remove(arg4) ^ 1;
        }

        if(this.oldDependency != arg4) {
            return 1;
        }

        this.oldDependency = v1;
        return 0;
    }

    public final void removeDependencies(Function1 arg15) {
        GraphicsLayer v0 = this.dependency;
        if(v0 != null) {
            arg15.invoke(v0);
            this.dependency = null;
        }

        MutableScatterSet v14 = this.dependenciesSet;
        if(v14 != null) {
            Object[] v1 = v14.elements;
            long[] v0_1 = v14.metadata;
            int v2 = v0_1.length - 2;
            if(v2 >= 0) {
                int v4;
                for(v4 = 0; true; ++v4) {
                    long v5 = v0_1[v4];
                    if((~v5 << 7 & v5 & -9187201950435737472L) != -9187201950435737472L) {
                        int v8 = 8;
                        int v7 = 8 - (~(v4 - v2) >>> 0x1F);
                        int v9;
                        for(v9 = 0; v9 < v7; ++v9) {
                            if((0xFF & v5) < 0x80) {
                                arg15.invoke(v1[(v4 << 3) + v9]);
                            }

                            v5 >>= v8;
                        }

                        if(v7 != v8) {
                            break;
                        }
                    }

                    if(v4 == v2) {
                        break;
                    }
                }
            }

            v14.clear();
        }
    }

    public final void withTracking(Function1 arg14, Function0 arg15) {
        this.oldDependency = this.dependency;
        MutableScatterSet v0 = this.dependenciesSet;
        if(v0 != null && (v0.isNotEmpty())) {
            MutableScatterSet v1 = this.oldDependenciesSet;
            if(v1 == null) {
                v1 = ScatterSetKt.mutableScatterSetOf();
                this.oldDependenciesSet = v1;
            }

            v1.addAll(v0);
            v0.clear();
        }

        this.trackingInProgress = true;
        arg15.invoke();
        this.trackingInProgress = false;
        GraphicsLayer v0_1 = this.oldDependency;
        if(v0_1 != null) {
            arg14.invoke(v0_1);
        }

        MutableScatterSet v13 = this.oldDependenciesSet;
        if(v13 != null && (v13.isNotEmpty())) {
            Object[] v1_1 = v13.elements;
            long[] v0_2 = v13.metadata;
            int v2 = v0_2.length - 2;
            if(v2 >= 0) {
                int v3;
                for(v3 = 0; true; ++v3) {
                    long v4 = v0_2[v3];
                    if((~v4 << 7 & v4 & -9187201950435737472L) != -9187201950435737472L) {
                        int v7 = 8;
                        int v6 = 8 - (~(v3 - v2) >>> 0x1F);
                        int v8;
                        for(v8 = 0; v8 < v6; ++v8) {
                            if((0xFF & v4) < 0x80) {
                                arg14.invoke(v1_1[(v3 << 3) + v8]);
                            }

                            v4 >>= v7;
                        }

                        if(v6 != v7) {
                            break;
                        }
                    }

                    if(v3 == v2) {
                        break;
                    }
                }
            }

            v13.clear();
        }
    }
}

