package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0005./#0-J\u001C\u0010\u0005\u001A\u00020\u0006*\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH&J\u001C\u0010\t\u001A\u00020\u0006*\u00020\u00062\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u0016J&\u0010\n\u001A\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\u000B\u001A\u00020\f2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00030\bH&JN\u0010\u000E\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u0019H&Jl\u0010\u001A\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010\u001B\u001A\u00020\u001C2\b\b\u0002\u0010\u001D\u001A\u00020\u001E2\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u0019H&JN\u0010!\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u0019H&J\u0010\u0010#\u001A\u00020\u00192\u0006\u0010$\u001A\u00020%H&J\u0015\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020(H\u0017¢\u0006\u0002\u0010)J\u001D\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020(2\u0006\u0010*\u001A\u00020+H\u0017¢\u0006\u0002\u0010,J\b\u0010-\u001A\u00020+H\u0016R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2={"Landroidx/compose/animation/SharedTransitionScope;", "Landroidx/compose/ui/layout/LookaheadScope;", "isTransitionActive", "", "()Z", "skipToLookaheadSize", "Landroidx/compose/ui/Modifier;", "enabled", "Lkotlin/Function0;", "skipToLookaheadPosition", "renderInSharedTransitionScopeOverlay", "zIndexInOverlay", "", "renderInOverlay", "sharedElement", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "animatedVisibilityScope", "Landroidx/compose/animation/AnimatedVisibilityScope;", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "placeholderSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "renderInOverlayDuringTransition", "clipInOverlayDuringTransition", "Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "sharedBounds", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "resizeMode", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "sharedElementWithCallerManagedVisibility", "visible", "OverlayClip", "clipShape", "Landroidx/compose/ui/graphics/Shape;", "rememberSharedContentState", "key", "", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "config", "Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "SharedContentConfig", "PlaceholderSize", "ResizeMode", "SharedContentState", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SharedTransitionScope extends LookaheadScope {
    @Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2={"Landroidx/compose/animation/SharedTransitionScope$OverlayClip;", "", "getClipPath", "Landroidx/compose/ui/graphics/Path;", "sharedContentState", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface OverlayClip {
        Path getClipPath(SharedContentState arg1, Rect arg2, LayoutDirection arg3, Density arg4);
    }

    @Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001F\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2={"Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "", "calculateSize", "Landroidx/compose/ui/unit/IntSize;", "contentSize", "animatedSize", "calculateSize-JyjRU_E", "(JJ)J", "Companion", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface PlaceholderSize {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007¨\u0006\n"}, d2={"Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize$Companion;", "", "<init>", "()V", "AnimatedSize", "Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "getAnimatedSize", "()Landroidx/compose/animation/SharedTransitionScope$PlaceholderSize;", "ContentSize", "getContentSize", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            private static final PlaceholderSize AnimatedSize;
            private static final PlaceholderSize ContentSize;

            static {
                Companion.$$INSTANCE = new Companion();
                Companion.AnimatedSize = SharedTransitionScope$PlaceholderSize$Companion$AnimatedSize$1.INSTANCE;
                Companion.ContentSize = SharedTransitionScope$PlaceholderSize$Companion$ContentSize$1.INSTANCE;
            }

            private Companion() {
                super();
            }

            public final PlaceholderSize getAnimatedSize() {
                return Companion.AnimatedSize;
            }

            public final PlaceholderSize getContentSize() {
                return Companion.ContentSize;
            }
        }

        public static final Companion Companion;

        static {
            PlaceholderSize.Companion = Companion.$$INSTANCE;
        }

        long calculateSize-JyjRU_E(long arg1, long arg2);
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2={"Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "", "Companion", "Landroidx/compose/animation/RemeasureImpl;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface ResizeMode {
        @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/animation/SharedTransitionScope$ResizeMode$Companion;", "", "<init>", "()V", "RemeasureToBounds", "Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "getRemeasureToBounds", "()Landroidx/compose/animation/SharedTransitionScope$ResizeMode;", "scaleToBounds", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion {
            private static final ResizeMode RemeasureToBounds;

            static {
                androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion.$$INSTANCE = new androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion();
                androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion.RemeasureToBounds = RemeasureImpl.INSTANCE;
            }

            private androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion() {
                super();
            }

            public final ResizeMode getRemeasureToBounds() {
                return androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion.RemeasureToBounds;
            }

            public final ResizeMode scaleToBounds(ContentScale arg1, Alignment arg2) {
                return SharedTransitionScopeKt.access$ScaleToBoundsCached(arg1, arg2);
            }

            public static ResizeMode scaleToBounds$default(androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion arg0, ContentScale arg1, Alignment arg2, int arg3, Object arg4) {
                if((arg3 & 1) != 0) {
                    arg1 = ContentScale.Companion.getFillWidth();
                }

                if((arg3 & 2) != 0) {
                    arg2 = Alignment.Companion.getCenter();
                }

                return arg0.scaleToBounds(arg1, arg2);
            }
        }

        public static final androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion Companion;

        static {
            ResizeMode.Companion = androidx.compose.animation.SharedTransitionScope$ResizeMode$Companion.$$INSTANCE;
        }
    }

    @Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\t\u001A\u0004\u0018\u00010\n*\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0002\u001A\u00020\u0003*\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0005R\u0014\u0010\u0006\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2={"Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;", "", "isEnabled", "", "Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;)Z", "shouldKeepEnabledForOngoingAnimation", "getShouldKeepEnabledForOngoingAnimation", "()Z", "alternativeTargetBoundsInTransitionScopeAfterRemoval", "Landroidx/compose/ui/geometry/Rect;", "targetBoundsBeforeRemoval", "sharedTransitionLayoutSize", "Landroidx/compose/ui/geometry/Size;", "alternativeTargetBoundsInTransitionScopeAfterRemoval-cSwnlzA", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentState;Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/Rect;", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public interface SharedContentConfig {
        default Rect alternativeTargetBoundsInTransitionScopeAfterRemoval-cSwnlzA(SharedContentState arg1, Rect arg2, long arg3) {
            return null;
        }

        default boolean getShouldKeepEnabledForOngoingAnimation() {
            return 1;
        }

        default boolean isEnabled(SharedContentState arg1) {
            return 1;
        }
    }

    @Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001B\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u001A¢\u0006\u0004\b\u001B\u0010\u001CR\u0011\u0010\u0002\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR+\u0010\u0003\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u00048@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001A\u00020\n8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\fR\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u001E8F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0013\u0010!\u001A\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001A\u0004\b\"\u0010#R/\u0010%\u001A\u0004\u0018\u00010$2\b\u0010\r\u001A\u0004\u0018\u00010$8@@@X\u0080\u008E\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0013\u001A\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0014\u0010+\u001A\u00020$8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b,\u0010\'¨\u0006-"}, d2={"Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "", "key", "config", "Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;)V", "getKey", "()Ljava/lang/Object;", "isAnimating", "", "isAnimating$animation", "()Z", "<set-?>", "getConfig$animation", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;", "setConfig$animation", "(Landroidx/compose/animation/SharedTransitionScope$SharedContentConfig;)V", "config$delegate", "Landroidx/compose/runtime/MutableState;", "isEnabledByUser", "isEnabledByUser$animation", "isMatchFound", "prepareTransitionWithInitialVelocity", "", "initialVelocity", "Landroidx/compose/ui/unit/Velocity;", "prepareTransitionWithInitialVelocity-TH1AsA0", "(J)V", "clipPathInOverlay", "Landroidx/compose/ui/graphics/Path;", "getClipPathInOverlay", "()Landroidx/compose/ui/graphics/Path;", "parentSharedContentState", "getParentSharedContentState", "()Landroidx/compose/animation/SharedTransitionScope$SharedContentState;", "Landroidx/compose/animation/SharedElementEntry;", "internalState", "getInternalState$animation", "()Landroidx/compose/animation/SharedElementEntry;", "setInternalState$animation", "(Landroidx/compose/animation/SharedElementEntry;)V", "internalState$delegate", "nonNullInternalState", "getNonNullInternalState", "animation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SharedContentState {
        public static final int $stable = 8;
        private final MutableState config$delegate;
        private final MutableState internalState$delegate;
        private final Object key;

        static {
        }

        public SharedContentState(Object arg2, SharedContentConfig arg3) {
            super();
            this.key = arg2;
            this.config$delegate = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
            this.internalState$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        }

        public SharedContentState(Object arg1, SharedContentConfig arg2, int arg3, DefaultConstructorMarker arg4) {
            androidx.compose.animation.SharedTransitionDefaults$SharedContentConfig v2;
            if((arg3 & 2) != 0) {
                v2 = androidx.compose.animation.SharedTransitionDefaults$SharedContentConfig.INSTANCE;
            }

            this(arg1, ((SharedContentConfig)v2));
        }

        public final Path getClipPathInOverlay() {
            return this.getNonNullInternalState().getClipPathInOverlay$animation();
        }

        public final SharedContentConfig getConfig$animation() {
            return this.config$delegate.getValue();
        }

        public final SharedElementEntry getInternalState$animation() {
            return this.internalState$delegate.getValue();
        }

        public final Object getKey() {
            return this.key;
        }

        private final SharedElementEntry getNonNullInternalState() {
            SharedElementEntry v1 = this.getInternalState$animation();
            if(v1 != null) {
                return v1;
            }

            throw new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not been initialized.".toString());
        }

        public final SharedContentState getParentSharedContentState() {
            SharedElementEntry v0 = this.getNonNullInternalState().getParentState();
            if(v0 != null) {
                return v0.getUserState();
            }

            return null;
        }

        public final boolean isAnimating$animation() {
            State v0_2;
            SharedElementEntry v0 = this.getInternalState$animation();
            if(v0 != null) {
                BoundsAnimation v0_1 = v0.getBoundsAnimation();
                if(v0_1 != null) {
                    v0_2 = v0_1.getAnimationState();
                }
                else {
                    goto label_6;
                }
            }
            else {
            label_6:
                v0_2 = null;
            }

            if(v0_2 != null) {
                return 1;
            }

            return 0;
        }

        public final boolean isEnabledByUser$animation() {
            SharedContentConfig v0 = this.getConfig$animation();
            if(!v0.isEnabled(this) && (!this.isAnimating$animation() || !v0.getShouldKeepEnabledForOngoingAnimation())) {
                return 0;
            }

            return 1;
        }

        public final boolean isMatchFound() {
            SharedElementEntry v0 = this.getInternalState$animation();
            if(v0 != null) {
                SharedElement v0_1 = v0.getSharedElement();
                if(v0_1 != null) {
                    return v0_1.getFoundMatch();
                }
            }

            return 0;
        }

        public final void prepareTransitionWithInitialVelocity-TH1AsA0(long arg3) {
            SharedElementEntry v0 = this.getNonNullInternalState();
            if(!this.getConfig$animation().isEnabled(this)) {
                return;
            }

            v0.getSharedElement().updateExitVelocity-TH1AsA0$animation(arg3);
        }

        public final void setConfig$animation(SharedContentConfig arg1) {
            this.config$delegate.setValue(arg1);
        }

        public final void setInternalState$animation(SharedElementEntry arg1) {
            this.internalState$delegate.setValue(arg1);
        }
    }

    OverlayClip OverlayClip(Shape arg1);

    default SharedContentConfig SharedContentConfig() {
        return CachedSharedContentConfig.INSTANCE;
    }

    boolean isTransitionActive();

    default SharedContentState rememberSharedContentState(Object arg3, SharedContentConfig arg4, Composer arg5, int arg6) {
        SharedContentState v6_1;
        int v2 = 0xF71F441C;
        arg5.startReplaceGroup(v2);
        ComposerKt.sourceInformation(arg5, "C(rememberSharedContentState)P(1)820@46705L49:SharedTransitionScope.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v2, arg6, -1, "androidx.compose.animation.SharedTransitionScope.rememberSharedContentState (SharedTransitionScope.kt:818)");
        }

        ComposerKt.sourceInformationMarkerStart(arg5, -1403074483, "CC(remember):SharedTransitionScope.kt#9igjgp");
        boolean v2_1 = arg5.changed(arg3);
        Object v6 = arg5.rememberedValue();
        if((v2_1) || v6 == Composer.Companion.getEmpty()) {
            v6_1 = new SharedContentState(arg3, arg4);
            arg5.updateRememberedValue(v6_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg5);
        v6_1.setConfig$animation(arg4);
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v6_1;
    }

    default SharedContentState rememberSharedContentState(Object arg4, Composer arg5, int arg6) {
        int v0 = 800730162;
        arg5.startReplaceGroup(v0);
        ComposerKt.sourceInformation(arg5, "C(rememberSharedContentState)796@45458L77:SharedTransitionScope.kt#xbi5r1");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v0, arg6, -1, "androidx.compose.animation.SharedTransitionScope.rememberSharedContentState (SharedTransitionScope.kt:796)");
        }

        SharedContentState v3 = this.rememberSharedContentState(arg4, androidx.compose.animation.SharedTransitionDefaults$SharedContentConfig.INSTANCE, arg5, arg6 << 3 & 0x380 | (arg6 & 14 | 0x30));
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        arg5.endReplaceGroup();
        return v3;
    }

    Modifier renderInSharedTransitionScopeOverlay(Modifier arg1, float arg2, Function0 arg3);

    static Modifier renderInSharedTransitionScopeOverlay$default(SharedTransitionScope arg0, Modifier arg1, float arg2, Function0 arg3, int arg4, Object arg5) {
        SharedTransitionScope$renderInSharedTransitionScopeOverlay$1 v3;
        if(arg5 == null) {
            if((arg4 & 2) != 0) {
                v3 = new SharedTransitionScope$renderInSharedTransitionScopeOverlay$1(arg0);
            }

            return arg0.renderInSharedTransitionScopeOverlay(arg1, 0f, ((Function0)v3));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderInSharedTransitionScopeOverlay");
    }

    Modifier sharedBounds(Modifier arg1, SharedContentState arg2, AnimatedVisibilityScope arg3, EnterTransition arg4, ExitTransition arg5, BoundsTransform arg6, ResizeMode arg7, PlaceholderSize arg8, boolean arg9, float arg10, OverlayClip arg11);

    static Modifier sharedBounds$default(SharedTransitionScope arg17, Modifier arg18, SharedContentState arg19, AnimatedVisibilityScope arg20, EnterTransition arg21, ExitTransition arg22, BoundsTransform arg23, ResizeMode arg24, PlaceholderSize arg25, boolean arg26, float arg27, OverlayClip arg28, int arg29, Object arg30) {
        int v0 = arg29;
        if(arg30 == null) {
            int v2 = 3;
            FiniteAnimationSpec v4 = null;
            EnterTransition v9 = (v0 & 4) != 0 ? EnterExitTransitionKt.fadeIn$default(v4, 0f, v2, v4) : arg21;
            ExitTransition v10 = (v0 & 8) != 0 ? EnterExitTransitionKt.fadeOut$default(v4, 0f, v2, v4) : arg22;
            BoundsTransform v11 = (v0 & 16) != 0 ? SharedTransitionDefaults.INSTANCE.getBoundsTransform() : arg23;
            ResizeMode v12 = (v0 & 0x20) != 0 ? ResizeMode.Companion.scaleToBounds(ContentScale.Companion.getFillWidth(), Alignment.Companion.getCenter()) : arg24;
            PlaceholderSize v13 = (v0 & 0x40) != 0 ? PlaceholderSize.Companion.getContentSize() : arg25;
            boolean v14 = (v0 & 0x80) != 0 ? true : arg26;
            float v15 = (v0 & 0x100) != 0 ? 0f : arg27;
            OverlayClip v16 = (v0 & 0x200) != 0 ? SharedTransitionScopeKt.access$getParentClip$p() : arg28;
            return arg17.sharedBounds(arg18, arg19, arg20, v9, v10, v11, v12, v13, v14, v15, v16);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedBounds");
    }

    Modifier sharedElement(Modifier arg1, SharedContentState arg2, AnimatedVisibilityScope arg3, BoundsTransform arg4, PlaceholderSize arg5, boolean arg6, float arg7, OverlayClip arg8);

    static Modifier sharedElement$default(SharedTransitionScope arg9, Modifier arg10, SharedContentState arg11, AnimatedVisibilityScope arg12, BoundsTransform arg13, PlaceholderSize arg14, boolean arg15, float arg16, OverlayClip arg17, int arg18, Object arg19) {
        if(arg19 == null) {
            if((arg18 & 4) != 0) {
                arg13 = SharedTransitionDefaults.INSTANCE.getBoundsTransform();
            }

            BoundsTransform v4 = arg13;
            if((arg18 & 8) != 0) {
                arg14 = PlaceholderSize.Companion.getContentSize();
            }

            PlaceholderSize v5 = arg14;
            boolean v6 = (arg18 & 16) != 0 ? true : arg15;
            float v7 = (arg18 & 0x20) != 0 ? 0f : arg16;
            OverlayClip v8 = (arg18 & 0x40) != 0 ? SharedTransitionScopeKt.access$getParentClip$p() : arg17;
            return arg9.sharedElement(arg10, arg11, arg12, v4, v5, v6, v7, v8);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElement");
    }

    Modifier sharedElementWithCallerManagedVisibility(Modifier arg1, SharedContentState arg2, boolean arg3, BoundsTransform arg4, PlaceholderSize arg5, boolean arg6, float arg7, OverlayClip arg8);

    static Modifier sharedElementWithCallerManagedVisibility$default(SharedTransitionScope arg9, Modifier arg10, SharedContentState arg11, boolean arg12, BoundsTransform arg13, PlaceholderSize arg14, boolean arg15, float arg16, OverlayClip arg17, int arg18, Object arg19) {
        if(arg19 == null) {
            if((arg18 & 4) != 0) {
                arg13 = SharedTransitionDefaults.INSTANCE.getBoundsTransform();
            }

            BoundsTransform v4 = arg13;
            if((arg18 & 8) != 0) {
                arg14 = PlaceholderSize.Companion.getContentSize();
            }

            PlaceholderSize v5 = arg14;
            boolean v6 = (arg18 & 16) != 0 ? true : arg15;
            float v7 = (arg18 & 0x20) != 0 ? 0f : arg16;
            OverlayClip v8 = (arg18 & 0x40) != 0 ? SharedTransitionScopeKt.access$getParentClip$p() : arg17;
            return arg9.sharedElementWithCallerManagedVisibility(arg10, arg11, arg12, v4, v5, v6, v7, v8);
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sharedElementWithCallerManagedVisibility");
    }

    default Modifier skipToLookaheadPosition(Modifier arg4, Function0 arg5) {
        return LookaheadScopeKt.approachLayout(arg4, SharedTransitionScope$skipToLookaheadPosition$2.INSTANCE, new SharedTransitionScope$skipToLookaheadPosition$3(arg5), new SharedTransitionScope$skipToLookaheadPosition$4(arg5, this));
    }

    static Modifier skipToLookaheadPosition$default(SharedTransitionScope arg0, Modifier arg1, Function0 arg2, int arg3, Object arg4) {
        SharedTransitionScope$skipToLookaheadPosition$1 v2;
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                v2 = new SharedTransitionScope$skipToLookaheadPosition$1(arg0);
            }

            return arg0.skipToLookaheadPosition(arg1, ((Function0)v2));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: skipToLookaheadPosition");
    }

    Modifier skipToLookaheadSize(Modifier arg1, Function0 arg2);

    static Modifier skipToLookaheadSize$default(SharedTransitionScope arg0, Modifier arg1, Function0 arg2, int arg3, Object arg4) {
        SharedTransitionScope$skipToLookaheadSize$1 v2;
        if(arg4 == null) {
            if((arg3 & 1) != 0) {
                v2 = new SharedTransitionScope$skipToLookaheadSize$1(arg0);
            }

            return arg0.skipToLookaheadSize(arg1, ((Function0)v2));
        }

        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: skipToLookaheadSize");
    }
}

