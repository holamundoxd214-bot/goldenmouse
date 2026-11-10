package androidx.compose.foundation.lazy;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement$Vertical;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

@Metadata(d1={"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A©\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000B\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001A-\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0011\u001A\u0082\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001A-\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0012\u001Aè\u0001\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001AB\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0017\u001A¬\u0001\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001AB\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0018\u001A©\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000B\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001A-\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001A\u001A\u0082\u0001\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001A\u001F\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001A-\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001B\u001Aè\u0001\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000B\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001AB\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001C\u001A¬\u0001\u0010\u0013\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001A4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001AB\u0012\u0004\u0012\u00020\u000E\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000F¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001D\u001A\u0082\u0001\u0010\u001E\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020*2\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020&2\n\b\u0002\u0010.\u001A\u0004\u0018\u00010/2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00101\u001A\u0082\u0001\u00102\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u00103\u001A\u0002042\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020&2\n\b\u0002\u0010.\u001A\u0004\u0018\u00010/2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00107\u001Av\u00102\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u00103\u001A\u0002042\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020&2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00108\u001Al\u00102\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u00103\u001A\u0002042\b\b\u0002\u00105\u001A\u0002062\b\b\u0002\u0010+\u001A\u00020,2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00109\u001Av\u0010\u001E\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020*2\b\b\u0002\u0010+\u001A\u00020,2\b\b\u0002\u0010-\u001A\u00020&2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010:\u001Al\u0010\u001E\u001A\u00020\u00012\b\b\u0002\u0010\u001F\u001A\u00020 2\b\b\u0002\u0010!\u001A\u00020\"2\b\b\u0002\u0010#\u001A\u00020$2\b\b\u0002\u0010%\u001A\u00020&2\b\b\u0002\u0010\'\u001A\u00020(2\b\b\u0002\u0010)\u001A\u00020*2\b\b\u0002\u0010+\u001A\u00020,2\u0017\u00100\u001A\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010;¨\u0006<"}, d2={"items", "", "T", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "LazyRow", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyColumn", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LazyDslKt {
    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyColumn(Modifier arg23, LazyListState arg24, PaddingValues arg25, boolean arg26, Vertical arg27, Horizontal arg28, FlingBehavior arg29, Function1 arg30, Composer arg31, int arg32, int arg33) {
        FlingBehavior v7_1;
        Horizontal v6_2;
        Vertical v5_1;
        boolean v4_1;
        PaddingValues v3_2;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v20;
        Vertical v14_2;
        boolean v13_2;
        FlingBehavior v16_1;
        Horizontal v15_2;
        PaddingValues v12_1;
        Companion v10_2;
        LazyListState v11_2;
        Modifier v0_2;
        int v16;
        int v15;
        FlingBehavior v14_1;
        Horizontal v13_1;
        int v12;
        Vertical v11_1;
        boolean v10;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v9 = arg32;
        Composer v1 = arg31.startRestartGroup(0xDE6BE73B);
        ComposerKt.sourceInformation(v1, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,content)456@22882L351:LazyDsl.kt#428nma");
        int v2 = arg33 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v1.changed(arg23) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            if((arg33 & 2) == 0) {
                v5 = arg24;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg24;
            label_34:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg24;
        }

        v6 = arg33 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_52;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg25;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_52:
            v7 = arg25;
        }

        v8 = arg33 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_67;
        }
        else if((v9 & 0xC00) == 0) {
            v10 = arg26;
            int v11 = v1.changed(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_67:
            v10 = arg26;
        }

        if((v9 & 0x6000) == 0) {
            if((arg33 & 16) == 0) {
                v11_1 = arg27;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v11_1 = arg27;
            label_78:
                v12 = 0x2000;
            }

            v4 |= v12;
        }
        else {
            v11_1 = arg27;
        }

        v12 = arg33 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v4 |= v13;
            goto label_97;
        }
        else if((v13 & v9) == 0) {
            v13_1 = arg28;
            int v14 = v1.changed(v13_1) ? 0x20000 : 0x10000;
            v4 |= v14;
        }
        else {
        label_97:
            v13_1 = arg28;
        }

        if((0x180000 & v9) == 0) {
            if((arg33 & 0x40) == 0) {
                v14_1 = arg29;
                if(v1.changed(v14_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v14_1 = arg29;
            label_109:
                v15 = 0x80000;
            }

            v4 |= v15;
        }
        else {
            v14_1 = arg29;
        }

        int v31 = 0xC00000;
        Function1 v15_1 = arg30;
        if((v9 & 0xC00000) == 0) {
            v16 = v1.changedInstance(v15_1) ? 0x800000 : 0x400000;
            v4 |= v16;
        }

        v16 = v2;
        boolean v0 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "447@22464L23,453@22818L15");
            int v18 = 0xFFFF1FFF;
            int v19 = 0xFFC7FFFF;
            v2 = 6;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v16 != 0) {
                    Companion v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = arg23;
                }

                if((arg33 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, 3);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v10 = false;
                }

                if((arg33 & 16) != 0) {
                    Arrangement v3 = Arrangement.INSTANCE;
                    Vertical v3_1 = !v10 ? v3.getTop() : v3.getBottom();
                    v4 &= v18;
                    v11_1 = v3_1;
                }

                if(v12 != 0) {
                    v13_1 = Alignment.Companion.getStart();
                }

                if((arg33 & 0x40) != 0) {
                    v4 &= v19;
                    v16_1 = ScrollableDefaults.INSTANCE.flingBehavior(v1, v2);
                    v12_1 = v6_1;
                    v14_2 = v11_1;
                    v15_2 = v13_1;
                    v11_2 = v5;
                    v13_2 = v10;
                    v10_2 = ((Companion)v0_2);
                    goto label_215;
                }

                v12_1 = v6_1;
                v15_2 = v13_1;
                v16_1 = v14_1;
                v13_2 = v10;
                v14_2 = v11_1;
                v10_2 = ((Companion)v0_2);
            label_163:
                v11_2 = v5;
            }
            else {
                v1.skipToGroupEnd();
                if((arg33 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg33 & 16) != 0) {
                    v4 &= v18;
                }

                if((arg33 & 0x40) != 0) {
                    v4 &= v19;
                }

                v12_1 = v7;
                v15_2 = v13_1;
                v16_1 = v14_1;
                v13_2 = v10;
                v14_2 = v11_1;
                Modifier v10_1 = arg23;
                goto label_163;
            }

        label_215:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xDE6BE73B, v4, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:455)");
            }

            v20 = v1;
            LazyDslKt.LazyColumn(((Modifier)v10_2), v11_2, v12_1, v13_2, v14_2, v15_2, v16_1, true, null, arg30, v20, v4 & 14 | v31 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4 | 0x70000 & v4 | 0x380000 & v4 | v4 << 6 & 0x70000000, 0x100);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Modifier)v10_2);
            v2_1 = v11_2;
            v3_2 = v12_1;
            v4_1 = v13_2;
            v5_1 = v14_2;
            v6_2 = v15_2;
            v7_1 = v16_1;
        }
        else {
            v20 = v1;
            v20.skipToGroupEnd();
            v1_1 = arg23;
            v2_1 = v5;
            v3_2 = v7;
            v4_1 = v10;
            v5_1 = v11_1;
            v6_2 = v13_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v11_3 = v20.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new LazyDslKt$$ExternalSyntheticLambda1(v1_1, v2_1, v3_2, v4_1, v5_1, v6_2, v7_1, arg30, v9, arg33));
        }
    }

    public static final void LazyColumn(Modifier arg31, LazyListState arg32, PaddingValues arg33, boolean arg34, Vertical arg35, Horizontal arg36, FlingBehavior arg37, boolean arg38, OverscrollEffect arg39, Function1 arg40, Composer arg41, int arg42, int arg43) {
        Vertical v5_1;
        Horizontal v6_2;
        OverscrollEffect v9_1;
        boolean v8_2;
        FlingBehavior v7_3;
        boolean v4_1;
        PaddingValues v3;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v27;
        PaddingValues v15_2;
        LazyListState v14_2;
        FlingBehavior v18_2;
        Horizontal v22;
        Vertical v23;
        boolean v16_1;
        OverscrollEffect v20_1;
        boolean v19_1;
        Modifier v13_1;
        Companion v13_2;
        FlingBehavior v10_2;
        Vertical v7_2;
        Companion v0_3;
        int v18;
        int v16;
        FlingBehavior v15_1;
        Horizontal v14_1;
        int v13;
        Vertical v10_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v11 = arg42;
        int v12 = arg43;
        Composer v1 = arg41.startRestartGroup(0x3335543);
        ComposerKt.sourceInformation(v1, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,userScrollEnabled,overscrollEffect,content)400@20806L434:LazyDsl.kt#428nma");
        int v2 = v12 & 1;
        if(v2 != 0) {
            v4 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v4 = v1.changed(arg31) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        if((v11 & 0x30) == 0) {
            if((v12 & 2) == 0) {
                v5 = arg32;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg32;
            label_35:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg32;
        }

        v6 = v12 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v11 & 0x180) == 0) {
            v7 = arg33;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_53:
            v7 = arg33;
        }

        v8 = v12 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_68;
        }
        else if((v11 & 0xC00) == 0) {
            v9 = arg34;
            int v10 = v1.changed(v9) ? 0x800 : 0x400;
            v4 |= v10;
        }
        else {
        label_68:
            v9 = arg34;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v10_1 = arg35;
                if(v1.changed(v10_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v10_1 = arg35;
            label_79:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v10_1 = arg35;
        }

        v13 = v12 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v4 |= v14;
            goto label_98;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg36;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_98:
            v14_1 = arg36;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v15_1 = arg37;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v15_1 = arg37;
            label_110:
                v16 = 0x80000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg37;
        }

        int v0 = v12 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v4 |= v17;
            goto label_130;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg38) ? 0x800000 : 0x400000;
            v4 |= v18;
        }
        else {
        label_130:
            v17 = v0;
        }

        if((v11 & 0x6000000) == 0) {
            v18 = (v12 & 0x100) != 0 || !v1.changed(arg39) ? 0x2000000 : 0x4000000;
            v4 |= v18;
        }

        Function1 v0_1 = arg40;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x20000000 : 0x10000000;
            v4 |= v18;
        }

        int v41 = v2;
        boolean v18_1 = true;
        boolean v0_2 = (v4 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "389@20279L23,395@20633L15,397@20731L26");
            v2 = 0xF1FFFFFF;
            int v19 = 0xFFC7FFFF;
            int v20 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v41 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg31;
                }

                if((v12 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, 3);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v12 & 16) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getTop() : v7_1.getBottom();
                    v4 &= v20;
                }
                else {
                    v7_2 = v10_1;
                }

                Horizontal v8_1 = v13 != 0 ? Alignment.Companion.getStart() : v14_1;
                if((v12 & 0x40) != 0) {
                    v10_2 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v4 &= v19;
                }
                else {
                    v10_2 = v15_1;
                }

                if(v17 != 0) {
                }
                else {
                    v18_1 = arg38;
                }

                if((v12 & 0x100) != 0) {
                    v4 &= v2;
                    v13_2 = v0_3;
                    v20_1 = OverscrollKt.rememberOverscrollEffect(v1, 0);
                }
                else {
                    v20_1 = arg39;
                    v13_2 = v0_3;
                }

                v14_2 = v5;
                v15_2 = v6_1;
                v23 = v7_2;
                v22 = v8_1;
                v16_1 = v9;
                v19_1 = v18_1;
                v0 = 0x3335543;
                v18_2 = v10_2;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v12 & 16) != 0) {
                    v4 &= v20;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v19;
                }

                if((v12 & 0x100) != 0) {
                    v4 &= v2;
                }

                v13_1 = arg31;
                v19_1 = arg38;
                v20_1 = arg39;
                v16_1 = v9;
                v23 = v10_1;
                v22 = v14_1;
                v18_2 = v15_1;
                v0 = 0x3335543;
                v14_2 = v5;
                v15_2 = v7;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:399)");
            }

            v2 = v4 >> 3;
            v27 = v1;
            LazyListKt.LazyList(v13_1, v14_2, v15_2, v16_1, true, v18_2, v19_1, v20_1, 0, v22, v23, null, null, arg40, v27, v4 & 14 | 0x6000 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000 | v4 << 12 & 0x70000000, v4 >> 12 & 14 | v4 >> 18 & 0x1C00, 6400);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v13_1;
            v2_1 = v14_2;
            v3 = v15_2;
            v4_1 = v16_1;
            v7_3 = v18_2;
            v8_2 = v19_1;
            v9_1 = v20_1;
            v6_2 = v22;
            v5_1 = v23;
        }
        else {
            v27 = v1;
            v27.skipToGroupEnd();
            v1_1 = arg31;
            v8_2 = arg38;
            v2_1 = v5;
            v3 = v7;
            v4_1 = v9;
            v5_1 = v10_1;
            v6_2 = v14_1;
            v7_3 = v15_1;
            v9_1 = arg39;
        }

        ScopeUpdateScope v13_3 = v27.endRestartGroup();
        if(v13_3 != null) {
            v13_3.updateScope(new LazyDslKt$$ExternalSyntheticLambda0(v1_1, v2_1, v3, v4_1, v5_1, v6_2, v7_3, v8_2, v9_1, arg40, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyColumn(Modifier arg25, LazyListState arg26, PaddingValues arg27, boolean arg28, Vertical arg29, Horizontal arg30, FlingBehavior arg31, boolean arg32, Function1 arg33, Composer arg34, int arg35, int arg36) {
        boolean v8_2;
        FlingBehavior v7_3;
        Horizontal v6_2;
        Vertical v5_1;
        boolean v4_1;
        PaddingValues v3;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v22;
        boolean v15_2;
        PaddingValues v14_2;
        Modifier v12_2;
        FlingBehavior v18_1;
        Horizontal v17_1;
        Vertical v16_1;
        LazyListState v13_1;
        boolean v19_1;
        FlingBehavior v12_3;
        Vertical v7_2;
        Companion v0_3;
        int v18;
        int v16;
        FlingBehavior v15_1;
        Horizontal v14_1;
        int v13;
        Vertical v12_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v10 = arg35;
        int v11 = arg36;
        Composer v1 = arg34.startRestartGroup(-740714857);
        ComposerKt.sourceInformation(v1, "C(LazyColumn)N(modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,userScrollEnabled,content)438@22230L26,429@21871L419:LazyDsl.kt#428nma");
        int v2 = v11 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v4 = v1.changed(arg25) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v4 = v10;
        }

        if((v10 & 0x30) == 0) {
            if((v11 & 2) == 0) {
                v5 = arg26;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg26;
            label_35:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg26;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg27;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_53:
            v7 = arg27;
        }

        v8 = v11 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_68;
        }
        else if((v10 & 0xC00) == 0) {
            v9 = arg28;
            int v12 = v1.changed(v9) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_68:
            v9 = arg28;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v12_1 = arg29;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v12_1 = arg29;
            label_79:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v12_1 = arg29;
        }

        v13 = v11 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v4 |= v14;
            goto label_98;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg30;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_98:
            v14_1 = arg30;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v15_1 = arg31;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v15_1 = arg31;
            label_110:
                v16 = 0x80000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg31;
        }

        int v0 = v11 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v4 |= v17;
            goto label_130;
        }
        else if((v10 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg32) ? 0x800000 : 0x400000;
            v4 |= v18;
        }
        else {
        label_130:
            v17 = v0;
        }

        Function1 v0_1 = arg33;
        if((v10 & 0x6000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x4000000 : 0x2000000;
            v4 |= v18;
        }

        int v34 = v2;
        boolean v0_2 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "419@21414L23,425@21768L15");
            int v19 = 0xFFFF1FFF;
            int v20 = 0xFFC7FFFF;
            v2 = 3;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v34 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg25;
                }

                if((v11 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, v2);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v11 & 16) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getTop() : v7_1.getBottom();
                    v4 &= v19;
                }
                else {
                    v7_2 = v12_1;
                }

                Horizontal v8_1 = v13 != 0 ? Alignment.Companion.getStart() : v14_1;
                if((v11 & 0x40) != 0) {
                    v12_3 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v4 &= v20;
                }
                else {
                    v12_3 = v15_1;
                }

                if(v17 != 0) {
                    v13_1 = v5;
                    v14_2 = v6_1;
                    v16_1 = v7_2;
                    v17_1 = v8_1;
                    v15_2 = v9;
                    v19_1 = true;
                }
                else {
                    v19_1 = arg32;
                    v13_1 = v5;
                    v14_2 = v6_1;
                    v16_1 = v7_2;
                    v17_1 = v8_1;
                    v15_2 = v9;
                }

                v18_1 = v12_3;
                Companion v12_4 = v0_3;
                v0 = -740714857;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v11 & 16) != 0) {
                    v4 &= v19;
                }

                if((v11 & 0x40) != 0) {
                    v4 &= v20;
                }

                v19_1 = arg32;
                v13_1 = v5;
                v16_1 = v12_1;
                v17_1 = v14_1;
                v18_1 = v15_1;
                v0 = -740714857;
                v12_2 = arg25;
                v14_2 = v7;
                v15_2 = v9;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:428)");
            }

            v22 = v1;
            LazyDslKt.LazyColumn(v12_2, v13_1, v14_2, v15_2, v16_1, v17_1, v18_1, v19_1, OverscrollKt.rememberOverscrollEffect(v1, 0), arg33, v22, 0x1FFFFFE & v4 | v4 << 3 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v12_2;
            v2_1 = v13_1;
            v3 = v14_2;
            v4_1 = v15_2;
            v5_1 = v16_1;
            v6_2 = v17_1;
            v7_3 = v18_1;
            v8_2 = v19_1;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v1_1 = arg25;
            v8_2 = arg32;
            v2_1 = v5;
            v3 = v7;
            v4_1 = v9;
            v5_1 = v12_1;
            v6_2 = v14_1;
            v7_3 = v15_1;
        }

        ScopeUpdateScope v12_5 = v22.endRestartGroup();
        if(v12_5 != null) {
            v12_5.updateScope(new LazyDslKt$$ExternalSyntheticLambda3(v1_1, v2_1, v3, v4_1, v5_1, v6_2, v7_3, v8_2, arg33, v10, v11));
        }
    }

    static final Unit LazyColumn$lambda$0(Modifier arg14, LazyListState arg15, PaddingValues arg16, boolean arg17, Vertical arg18, Horizontal arg19, FlingBehavior arg20, boolean arg21, OverscrollEffect arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyDslKt.LazyColumn(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit LazyColumn$lambda$1(Modifier arg13, LazyListState arg14, PaddingValues arg15, boolean arg16, Vertical arg17, Horizontal arg18, FlingBehavior arg19, boolean arg20, Function1 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        LazyDslKt.LazyColumn(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit LazyColumn$lambda$2(Modifier arg12, LazyListState arg13, PaddingValues arg14, boolean arg15, Vertical arg16, Horizontal arg17, FlingBehavior arg18, Function1 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        LazyDslKt.LazyColumn(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyRow(Modifier arg23, LazyListState arg24, PaddingValues arg25, boolean arg26, androidx.compose.foundation.layout.Arrangement$Horizontal arg27, androidx.compose.ui.Alignment$Vertical arg28, FlingBehavior arg29, Function1 arg30, Composer arg31, int arg32, int arg33) {
        FlingBehavior v7_1;
        androidx.compose.ui.Alignment$Vertical v6_2;
        androidx.compose.foundation.layout.Arrangement$Horizontal v5_1;
        boolean v4_1;
        PaddingValues v3_2;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v20;
        Modifier v10_1;
        androidx.compose.foundation.layout.Arrangement$Horizontal v14_2;
        boolean v13_2;
        FlingBehavior v16_1;
        androidx.compose.ui.Alignment$Vertical v15_2;
        PaddingValues v12_1;
        Companion v10_2;
        LazyListState v11_2;
        Modifier v0_2;
        int v16;
        int v15;
        FlingBehavior v14_1;
        androidx.compose.ui.Alignment$Vertical v13_1;
        int v12;
        androidx.compose.foundation.layout.Arrangement$Horizontal v11_1;
        boolean v10;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v9 = arg32;
        Composer v1 = arg31.startRestartGroup(0x185083DF);
        ComposerKt.sourceInformation(v1, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,content)510@24860L348:LazyDsl.kt#428nma");
        int v2 = arg33 & 1;
        if(v2 != 0) {
            v4 = v9 | 6;
        }
        else if((v9 & 6) == 0) {
            v4 = v1.changed(arg23) ? 4 : 2;
            v4 |= v9;
        }
        else {
            v4 = v9;
        }

        if((v9 & 0x30) == 0) {
            if((arg33 & 2) == 0) {
                v5 = arg24;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_34;
                }
            }
            else {
                v5 = arg24;
            label_34:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg24;
        }

        v6 = arg33 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_52;
        }
        else if((v9 & 0x180) == 0) {
            v7 = arg25;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_52:
            v7 = arg25;
        }

        v8 = arg33 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_67;
        }
        else if((v9 & 0xC00) == 0) {
            v10 = arg26;
            int v11 = v1.changed(v10) ? 0x800 : 0x400;
            v4 |= v11;
        }
        else {
        label_67:
            v10 = arg26;
        }

        if((v9 & 0x6000) == 0) {
            if((arg33 & 16) == 0) {
                v11_1 = arg27;
                if(v1.changed(v11_1)) {
                    v12 = 0x4000;
                }
                else {
                    goto label_78;
                }
            }
            else {
                v11_1 = arg27;
            label_78:
                v12 = 0x2000;
            }

            v4 |= v12;
        }
        else {
            v11_1 = arg27;
        }

        v12 = arg33 & 0x20;
        int v13 = 0x30000;
        if(v12 != 0) {
            v4 |= v13;
            goto label_97;
        }
        else if((v13 & v9) == 0) {
            v13_1 = arg28;
            int v14 = v1.changed(v13_1) ? 0x20000 : 0x10000;
            v4 |= v14;
        }
        else {
        label_97:
            v13_1 = arg28;
        }

        if((0x180000 & v9) == 0) {
            if((arg33 & 0x40) == 0) {
                v14_1 = arg29;
                if(v1.changed(v14_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_109;
                }
            }
            else {
                v14_1 = arg29;
            label_109:
                v15 = 0x80000;
            }

            v4 |= v15;
        }
        else {
            v14_1 = arg29;
        }

        int v31 = 0xC00000;
        Function1 v15_1 = arg30;
        if((v9 & 0xC00000) == 0) {
            v16 = v1.changedInstance(v15_1) ? 0x800000 : 0x400000;
            v4 |= v16;
        }

        v16 = v2;
        boolean v0 = (v4 & 0x492493) != 4793490 ? true : false;
        if(v1.shouldExecute(v0, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "501@24445L23,507@24796L15");
            int v18 = 0xFFFF1FFF;
            int v19 = 0xFFC7FFFF;
            v2 = 6;
            if((v9 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v16 != 0) {
                    Companion v0_1 = Modifier.Companion;
                }
                else {
                    v0_2 = arg23;
                }

                if((arg33 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, 3);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v10 = false;
                }

                if((arg33 & 16) != 0) {
                    Arrangement v3 = Arrangement.INSTANCE;
                    androidx.compose.foundation.layout.Arrangement$Horizontal v3_1 = !v10 ? v3.getStart() : v3.getEnd();
                    v4 &= v18;
                    v11_1 = v3_1;
                }

                if(v12 != 0) {
                    v13_1 = Alignment.Companion.getTop();
                }

                if((arg33 & 0x40) != 0) {
                    v4 &= v19;
                    v16_1 = ScrollableDefaults.INSTANCE.flingBehavior(v1, v2);
                    v12_1 = v6_1;
                    v14_2 = v11_1;
                    v15_2 = v13_1;
                    v11_2 = v5;
                    v13_2 = v10;
                    v10_2 = ((Companion)v0_2);
                    goto label_215;
                }

                v12_1 = v6_1;
                v15_2 = v13_1;
                v16_1 = v14_1;
                v13_2 = v10;
                v14_2 = v11_1;
                v10_2 = ((Companion)v0_2);
            label_163:
                v11_2 = v5;
            }
            else {
                v1.skipToGroupEnd();
                if((arg33 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((arg33 & 16) != 0) {
                    v4 &= v18;
                }

                if((arg33 & 0x40) != 0) {
                    v4 &= v19;
                }

                v12_1 = v7;
                v15_2 = v13_1;
                v16_1 = v14_1;
                v13_2 = v10;
                v14_2 = v11_1;
                v10_1 = arg23;
                goto label_163;
            }

        label_215:
            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x185083DF, v4, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:509)");
            }

            v20 = v1;
            LazyDslKt.LazyRow(v10_1, v11_2, v12_1, v13_2, v14_2, v15_2, v16_1, true, null, arg30, v20, v4 & 14 | v31 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0xE000 & v4 | 0x70000 & v4 | 0x380000 & v4 | v4 << 6 & 0x70000000, 0x100);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v10_1;
            v2_1 = v11_2;
            v3_2 = v12_1;
            v4_1 = v13_2;
            v5_1 = v14_2;
            v6_2 = v15_2;
            v7_1 = v16_1;
        }
        else {
            v20 = v1;
            v20.skipToGroupEnd();
            v1_1 = arg23;
            v2_1 = v5;
            v3_2 = v7;
            v4_1 = v10;
            v5_1 = v11_1;
            v6_2 = v13_1;
            v7_1 = v14_1;
        }

        ScopeUpdateScope v11_3 = v20.endRestartGroup();
        if(v11_3 != null) {
            v11_3.updateScope(new LazyDslKt$$ExternalSyntheticLambda5(v1_1, v2_1, v3_2, v4_1, v5_1, v6_2, v7_1, arg30, v9, arg33));
        }
    }

    public static final void LazyRow(Modifier arg31, LazyListState arg32, PaddingValues arg33, boolean arg34, androidx.compose.foundation.layout.Arrangement$Horizontal arg35, androidx.compose.ui.Alignment$Vertical arg36, FlingBehavior arg37, boolean arg38, OverscrollEffect arg39, Function1 arg40, Composer arg41, int arg42, int arg43) {
        androidx.compose.foundation.layout.Arrangement$Horizontal v5_1;
        androidx.compose.ui.Alignment$Vertical v6_2;
        OverscrollEffect v9_1;
        boolean v8_2;
        FlingBehavior v7_3;
        boolean v4_1;
        PaddingValues v3;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v27;
        PaddingValues v15_2;
        LazyListState v14_2;
        FlingBehavior v18_2;
        androidx.compose.ui.Alignment$Vertical v24;
        androidx.compose.foundation.layout.Arrangement$Horizontal v25;
        boolean v16_1;
        OverscrollEffect v20_1;
        boolean v19_1;
        Modifier v13_1;
        Companion v13_2;
        FlingBehavior v10_2;
        androidx.compose.foundation.layout.Arrangement$Horizontal v7_2;
        Companion v0_3;
        int v18;
        int v16;
        FlingBehavior v15_1;
        androidx.compose.ui.Alignment$Vertical v14_1;
        int v13;
        androidx.compose.foundation.layout.Arrangement$Horizontal v10_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v11 = arg42;
        int v12 = arg43;
        Composer v1 = arg41.startRestartGroup(0x8FAF791F);
        ComposerKt.sourceInformation(v1, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,userScrollEnabled,overscrollEffect,content)340@17489L435:LazyDsl.kt#428nma");
        int v2 = v12 & 1;
        if(v2 != 0) {
            v4 = v11 | 6;
        }
        else if((v11 & 6) == 0) {
            v4 = v1.changed(arg31) ? 4 : 2;
            v4 |= v11;
        }
        else {
            v4 = v11;
        }

        if((v11 & 0x30) == 0) {
            if((v12 & 2) == 0) {
                v5 = arg32;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg32;
            label_35:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg32;
        }

        v6 = v12 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v11 & 0x180) == 0) {
            v7 = arg33;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_53:
            v7 = arg33;
        }

        v8 = v12 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_68;
        }
        else if((v11 & 0xC00) == 0) {
            v9 = arg34;
            int v10 = v1.changed(v9) ? 0x800 : 0x400;
            v4 |= v10;
        }
        else {
        label_68:
            v9 = arg34;
        }

        if((v11 & 0x6000) == 0) {
            if((v12 & 16) == 0) {
                v10_1 = arg35;
                if(v1.changed(v10_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v10_1 = arg35;
            label_79:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v10_1 = arg35;
        }

        v13 = v12 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v4 |= v14;
            goto label_98;
        }
        else if((v14 & v11) == 0) {
            v14_1 = arg36;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_98:
            v14_1 = arg36;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v15_1 = arg37;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v15_1 = arg37;
            label_110:
                v16 = 0x80000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg37;
        }

        int v0 = v12 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v4 |= v17;
            goto label_130;
        }
        else if((v11 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg38) ? 0x800000 : 0x400000;
            v4 |= v18;
        }
        else {
        label_130:
            v17 = v0;
        }

        if((v11 & 0x6000000) == 0) {
            v18 = (v12 & 0x100) != 0 || !v1.changed(arg39) ? 0x2000000 : 0x4000000;
            v4 |= v18;
        }

        Function1 v0_1 = arg40;
        if((v11 & 0x30000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x20000000 : 0x10000000;
            v4 |= v18;
        }

        int v41 = v2;
        boolean v18_1 = true;
        boolean v0_2 = (v4 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "329@16965L23,335@17316L15,337@17414L26");
            v2 = 0xF1FFFFFF;
            int v19 = 0xFFC7FFFF;
            int v20 = 0xFFFF1FFF;
            if((v11 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v41 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg31;
                }

                if((v12 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, 3);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v12 & 16) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getStart() : v7_1.getEnd();
                    v4 &= v20;
                }
                else {
                    v7_2 = v10_1;
                }

                androidx.compose.ui.Alignment$Vertical v8_1 = v13 != 0 ? Alignment.Companion.getTop() : v14_1;
                if((v12 & 0x40) != 0) {
                    v10_2 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v4 &= v19;
                }
                else {
                    v10_2 = v15_1;
                }

                if(v17 != 0) {
                }
                else {
                    v18_1 = arg38;
                }

                if((v12 & 0x100) != 0) {
                    v4 &= v2;
                    v13_2 = v0_3;
                    v20_1 = OverscrollKt.rememberOverscrollEffect(v1, 0);
                }
                else {
                    v20_1 = arg39;
                    v13_2 = v0_3;
                }

                v14_2 = v5;
                v15_2 = v6_1;
                v25 = v7_2;
                v24 = v8_1;
                v16_1 = v9;
                v19_1 = v18_1;
                v0 = 0x8FAF791F;
                v18_2 = v10_2;
            }
            else {
                v1.skipToGroupEnd();
                if((v12 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v12 & 16) != 0) {
                    v4 &= v20;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v19;
                }

                if((v12 & 0x100) != 0) {
                    v4 &= v2;
                }

                v13_1 = arg31;
                v19_1 = arg38;
                v20_1 = arg39;
                v16_1 = v9;
                v25 = v10_1;
                v24 = v14_1;
                v18_2 = v15_1;
                v0 = 0x8FAF791F;
                v14_2 = v5;
                v15_2 = v7;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:339)");
            }

            v2 = v4 >> 3;
            v27 = v1;
            LazyListKt.LazyList(v13_1, v14_2, v15_2, v16_1, false, v18_2, v19_1, v20_1, 0, null, null, v24, v25, arg40, v27, v4 & 14 | 0x6000 | v4 & 0x70 | v4 & 0x380 | v4 & 0x1C00 | 0x70000 & v2 | 0x380000 & v2 | v2 & 0x1C00000, v4 >> 12 & 0x70 | v4 >> 6 & 0x380 | v4 >> 18 & 0x1C00, 0x700);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = v13_1;
            v2_1 = v14_2;
            v3 = v15_2;
            v4_1 = v16_1;
            v7_3 = v18_2;
            v8_2 = v19_1;
            v9_1 = v20_1;
            v6_2 = v24;
            v5_1 = v25;
        }
        else {
            v27 = v1;
            v27.skipToGroupEnd();
            v1_1 = arg31;
            v8_2 = arg38;
            v2_1 = v5;
            v3 = v7;
            v4_1 = v9;
            v5_1 = v10_1;
            v6_2 = v14_1;
            v7_3 = v15_1;
            v9_1 = arg39;
        }

        ScopeUpdateScope v13_3 = v27.endRestartGroup();
        if(v13_3 != null) {
            v13_3.updateScope(new LazyDslKt$$ExternalSyntheticLambda2(v1_1, v2_1, v3, v4_1, v5_1, v6_2, v7_3, v8_2, v9_1, arg40, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void LazyRow(Modifier arg25, LazyListState arg26, PaddingValues arg27, boolean arg28, androidx.compose.foundation.layout.Arrangement$Horizontal arg29, androidx.compose.ui.Alignment$Vertical arg30, FlingBehavior arg31, boolean arg32, Function1 arg33, Composer arg34, int arg35, int arg36) {
        boolean v8_2;
        FlingBehavior v7_3;
        androidx.compose.ui.Alignment$Vertical v6_2;
        androidx.compose.foundation.layout.Arrangement$Horizontal v5_1;
        boolean v4_1;
        PaddingValues v3;
        LazyListState v2_1;
        Modifier v1_1;
        Composer v22;
        boolean v15_2;
        PaddingValues v14_2;
        FlingBehavior v18_1;
        androidx.compose.ui.Alignment$Vertical v17_1;
        androidx.compose.foundation.layout.Arrangement$Horizontal v16_1;
        LazyListState v13_1;
        boolean v19_1;
        Companion v12_4;
        FlingBehavior v12_3;
        androidx.compose.foundation.layout.Arrangement$Horizontal v7_2;
        Companion v0_3;
        int v18;
        int v16;
        FlingBehavior v15_1;
        androidx.compose.ui.Alignment$Vertical v14_1;
        int v13;
        androidx.compose.foundation.layout.Arrangement$Horizontal v12_1;
        boolean v9;
        int v8;
        PaddingValues v7;
        int v6;
        LazyListState v5;
        int v4;
        int v10 = arg35;
        int v11 = arg36;
        Composer v1 = arg34.startRestartGroup(0x99394F3B);
        ComposerKt.sourceInformation(v1, "C(LazyRow)N(modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalAlignment,flingBehavior,userScrollEnabled,content)492@24214L26,483@23858L416:LazyDsl.kt#428nma");
        int v2 = v11 & 1;
        if(v2 != 0) {
            v4 = v10 | 6;
        }
        else if((v10 & 6) == 0) {
            v4 = v1.changed(arg25) ? 4 : 2;
            v4 |= v10;
        }
        else {
            v4 = v10;
        }

        if((v10 & 0x30) == 0) {
            if((v11 & 2) == 0) {
                v5 = arg26;
                if(v1.changed(v5)) {
                    v6 = 0x20;
                }
                else {
                    goto label_35;
                }
            }
            else {
                v5 = arg26;
            label_35:
                v6 = 16;
            }

            v4 |= v6;
        }
        else {
            v5 = arg26;
        }

        v6 = v11 & 4;
        if(v6 != 0) {
            v4 |= 0x180;
            goto label_53;
        }
        else if((v10 & 0x180) == 0) {
            v7 = arg27;
            v8 = v1.changed(v7) ? 0x100 : 0x80;
            v4 |= v8;
        }
        else {
        label_53:
            v7 = arg27;
        }

        v8 = v11 & 8;
        if(v8 != 0) {
            v4 |= 0xC00;
            goto label_68;
        }
        else if((v10 & 0xC00) == 0) {
            v9 = arg28;
            int v12 = v1.changed(v9) ? 0x800 : 0x400;
            v4 |= v12;
        }
        else {
        label_68:
            v9 = arg28;
        }

        if((v10 & 0x6000) == 0) {
            if((v11 & 16) == 0) {
                v12_1 = arg29;
                if(v1.changed(v12_1)) {
                    v13 = 0x4000;
                }
                else {
                    goto label_79;
                }
            }
            else {
                v12_1 = arg29;
            label_79:
                v13 = 0x2000;
            }

            v4 |= v13;
        }
        else {
            v12_1 = arg29;
        }

        v13 = v11 & 0x20;
        int v14 = 0x30000;
        if(v13 != 0) {
            v4 |= v14;
            goto label_98;
        }
        else if((v14 & v10) == 0) {
            v14_1 = arg30;
            int v15 = v1.changed(v14_1) ? 0x20000 : 0x10000;
            v4 |= v15;
        }
        else {
        label_98:
            v14_1 = arg30;
        }

        if((0x180000 & v10) == 0) {
            if((v11 & 0x40) == 0) {
                v15_1 = arg31;
                if(v1.changed(v15_1)) {
                    v16 = 0x100000;
                }
                else {
                    goto label_110;
                }
            }
            else {
                v15_1 = arg31;
            label_110:
                v16 = 0x80000;
            }

            v4 |= v16;
        }
        else {
            v15_1 = arg31;
        }

        int v0 = v11 & 0x80;
        int v17 = 0xC00000;
        if(v0 != 0) {
            v4 |= v17;
            goto label_130;
        }
        else if((v10 & v17) == 0) {
            v17 = v0;
            v18 = v1.changed(arg32) ? 0x800000 : 0x400000;
            v4 |= v18;
        }
        else {
        label_130:
            v17 = v0;
        }

        Function1 v0_1 = arg33;
        if((v10 & 0x6000000) == 0) {
            v18 = v1.changedInstance(v0_1) ? 0x4000000 : 0x2000000;
            v4 |= v18;
        }

        int v34 = v2;
        boolean v0_2 = (v4 & 0x2492493) != 0x2492492 ? true : false;
        if(v1.shouldExecute(v0_2, v4 & 1)) {
            v1.startDefaults();
            ComposerKt.sourceInformation(v1, "473@23404L23,479@23755L15");
            int v19 = 0xFFFF1FFF;
            int v20 = 0xFFC7FFFF;
            v2 = 3;
            if((v10 & 1) == 0 || (v1.getDefaultsInvalid())) {
                if(v34 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = arg25;
                }

                if((v11 & 2) != 0) {
                    v5 = LazyListStateKt.rememberLazyListState(0, 0, v1, 0, v2);
                    v4 &= 0xFFFFFF8F;
                }

                PaddingValues v6_1 = v6 != 0 ? PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0f)) : v7;
                if(v8 != 0) {
                    v9 = false;
                }

                if((v11 & 16) != 0) {
                    Arrangement v7_1 = Arrangement.INSTANCE;
                    v7_2 = !v9 ? v7_1.getStart() : v7_1.getEnd();
                    v4 &= v19;
                }
                else {
                    v7_2 = v12_1;
                }

                androidx.compose.ui.Alignment$Vertical v8_1 = v13 != 0 ? Alignment.Companion.getTop() : v14_1;
                if((v11 & 0x40) != 0) {
                    v12_3 = ScrollableDefaults.INSTANCE.flingBehavior(v1, 6);
                    v4 &= v20;
                }
                else {
                    v12_3 = v15_1;
                }

                if(v17 != 0) {
                    v13_1 = v5;
                    v14_2 = v6_1;
                    v16_1 = v7_2;
                    v17_1 = v8_1;
                    v15_2 = v9;
                    v19_1 = true;
                }
                else {
                    v19_1 = arg32;
                    v13_1 = v5;
                    v14_2 = v6_1;
                    v16_1 = v7_2;
                    v17_1 = v8_1;
                    v15_2 = v9;
                }

                v18_1 = v12_3;
                v12_4 = v0_3;
                v0 = 0x99394F3B;
            }
            else {
                v1.skipToGroupEnd();
                if((v11 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }

                if((v11 & 16) != 0) {
                    v4 &= v19;
                }

                if((v11 & 0x40) != 0) {
                    v4 &= v20;
                }

                v19_1 = arg32;
                v13_1 = v5;
                v16_1 = v12_1;
                v17_1 = v14_1;
                v18_1 = v15_1;
                v0 = 0x99394F3B;
                Modifier v12_2 = arg25;
                v14_2 = v7;
                v15_2 = v9;
            }

            v1.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v0, v4, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:482)");
            }

            v22 = v1;
            LazyDslKt.LazyRow(((Modifier)v12_4), v13_1, v14_2, v15_2, v16_1, v17_1, v18_1, v19_1, OverscrollKt.rememberOverscrollEffect(v1, 0), arg33, v22, 0x1FFFFFE & v4 | v4 << 3 & 0x70000000, 0);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v1_1 = ((Modifier)v12_4);
            v2_1 = v13_1;
            v3 = v14_2;
            v4_1 = v15_2;
            v5_1 = v16_1;
            v6_2 = v17_1;
            v7_3 = v18_1;
            v8_2 = v19_1;
        }
        else {
            v22 = v1;
            v22.skipToGroupEnd();
            v1_1 = arg25;
            v8_2 = arg32;
            v2_1 = v5;
            v3 = v7;
            v4_1 = v9;
            v5_1 = v12_1;
            v6_2 = v14_1;
            v7_3 = v15_1;
        }

        ScopeUpdateScope v12_5 = v22.endRestartGroup();
        if(v12_5 != null) {
            v12_5.updateScope(new LazyDslKt$$ExternalSyntheticLambda4(v1_1, v2_1, v3, v4_1, v5_1, v6_2, v7_3, v8_2, arg33, v10, v11));
        }
    }

    static final Unit LazyRow$lambda$0(Modifier arg14, LazyListState arg15, PaddingValues arg16, boolean arg17, androidx.compose.foundation.layout.Arrangement$Horizontal arg18, androidx.compose.ui.Alignment$Vertical arg19, FlingBehavior arg20, boolean arg21, OverscrollEffect arg22, Function1 arg23, int arg24, int arg25, Composer arg26, int arg27) {
        LazyDslKt.LazyRow(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit LazyRow$lambda$1(Modifier arg13, LazyListState arg14, PaddingValues arg15, boolean arg16, androidx.compose.foundation.layout.Arrangement$Horizontal arg17, androidx.compose.ui.Alignment$Vertical arg18, FlingBehavior arg19, boolean arg20, Function1 arg21, int arg22, int arg23, Composer arg24, int arg25) {
        LazyDslKt.LazyRow(arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg24, RecomposeScopeImplKt.updateChangedFlags(arg22 | 1), arg23);
        return Unit.INSTANCE;
    }

    static final Unit LazyRow$lambda$2(Modifier arg12, LazyListState arg13, PaddingValues arg14, boolean arg15, androidx.compose.foundation.layout.Arrangement$Horizontal arg16, androidx.compose.ui.Alignment$Vertical arg17, FlingBehavior arg18, Function1 arg19, int arg20, int arg21, Composer arg22, int arg23) {
        LazyDslKt.LazyRow(arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg22, RecomposeScopeImplKt.updateChangedFlags(arg20 | 1), arg21);
        return Unit.INSTANCE;
    }

    public static final void items(LazyListScope arg2, List arg3, Function1 arg4, Function1 arg5, Function4 arg6) {
        Function1 v1_1;
        int v0 = arg3.size();
        if(arg4 != null) {
            LazyDslKt$items$2 v1 = new LazyDslKt$items$2(arg4, arg3);
        }
        else {
            v1_1 = null;
        }

        arg2.items(v0, v1_1, new LazyDslKt$items$3(arg5, arg3), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(arg6, arg3)));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void items(LazyListScope arg3, List arg4, Function1 arg5, Function4 arg6) {
        LazyDslKt$items$2 v2;
        LazyDslKt$items$1 v0 = LazyDslKt$items$1.INSTANCE;
        int v1 = arg4.size();
        if(arg5 != null) {
            v2 = new LazyDslKt$items$2(arg5, arg4);
        }
        else {
            Function1 v2_1 = null;
        }

        arg3.items(v1, ((Function1)v2), new LazyDslKt$items$3(((Function1)v0), arg4), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(arg6, arg4)));
    }

    public static final void items(LazyListScope arg2, Object[] arg3, Function1 arg4, Function1 arg5, Function4 arg6) {
        Function1 v1_1;
        int v0 = arg3.length;
        if(arg4 != null) {
            LazyDslKt$items$6 v1 = new LazyDslKt$items$6(arg4, arg3);
        }
        else {
            v1_1 = null;
        }

        arg2.items(v0, v1_1, new LazyDslKt$items$7(arg5, arg3), ComposableLambdaKt.composableLambdaInstance(0x95CCC41D, true, new LazyDslKt$items$8(arg6, arg3)));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void items(LazyListScope arg3, Object[] arg4, Function1 arg5, Function4 arg6) {
        LazyDslKt$items$6 v2;
        LazyDslKt$items$5 v0 = LazyDslKt$items$5.INSTANCE;
        int v1 = arg4.length;
        if(arg5 != null) {
            v2 = new LazyDslKt$items$6(arg5, arg4);
        }
        else {
            Function1 v2_1 = null;
        }

        arg3.items(v1, ((Function1)v2), new LazyDslKt$items$7(((Function1)v0), arg4), ComposableLambdaKt.composableLambdaInstance(0x95CCC41D, true, new LazyDslKt$items$8(arg6, arg4)));
    }

    public static void items$default(LazyListScope arg1, List arg2, Function1 arg3, Function1 arg4, Function4 arg5, int arg6, Object arg7) {
        LazyDslKt$items$1 v4;
        Function1 v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            v4 = LazyDslKt$items$1.INSTANCE;
        }

        arg6 = arg2.size();
        if(arg3 != null) {
            LazyDslKt$items$2 v0_1 = new LazyDslKt$items$2(arg3, arg2);
        }

        arg1.items(arg6, v0, new LazyDslKt$items$3(((Function1)v4), arg2), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(arg5, arg2)));
    }

    public static void items$default(LazyListScope arg1, List arg2, Function1 arg3, Function4 arg4, int arg5, Object arg6) {
        Function1 v6 = null;
        if((arg5 & 2) != 0) {
            arg3 = v6;
        }

        LazyDslKt$items$1 v5 = LazyDslKt$items$1.INSTANCE;
        int v0 = arg2.size();
        if(arg3 != null) {
            LazyDslKt$items$2 v6_1 = new LazyDslKt$items$2(arg3, arg2);
        }

        arg1.items(v0, v6, new LazyDslKt$items$3(((Function1)v5), arg2), ComposableLambdaKt.composableLambdaInstance(802480018, true, new LazyDslKt$items$4(arg4, arg2)));
    }

    public static void items$default(LazyListScope arg1, Object[] arg2, Function1 arg3, Function1 arg4, Function4 arg5, int arg6, Object arg7) {
        LazyDslKt$items$5 v4;
        Function1 v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = v0;
        }

        if((arg6 & 4) != 0) {
            v4 = LazyDslKt$items$5.INSTANCE;
        }

        arg6 = arg2.length;
        if(arg3 != null) {
            LazyDslKt$items$6 v0_1 = new LazyDslKt$items$6(arg3, arg2);
        }

        arg1.items(arg6, v0, new LazyDslKt$items$7(((Function1)v4), arg2), ComposableLambdaKt.composableLambdaInstance(0x95CCC41D, true, new LazyDslKt$items$8(arg5, arg2)));
    }

    public static void items$default(LazyListScope arg1, Object[] arg2, Function1 arg3, Function4 arg4, int arg5, Object arg6) {
        LazyDslKt$items$6 v6_1;
        Function1 v6 = null;
        if((arg5 & 2) != 0) {
            arg3 = v6;
        }

        LazyDslKt$items$5 v5 = LazyDslKt$items$5.INSTANCE;
        int v0 = arg2.length;
        if(arg3 != null) {
            v6_1 = new LazyDslKt$items$6(arg3, arg2);
        }

        arg1.items(v0, ((Function1)v6_1), new LazyDslKt$items$7(((Function1)v5), arg2), ComposableLambdaKt.composableLambdaInstance(0x95CCC41D, true, new LazyDslKt$items$8(arg4, arg2)));
    }

    public static final void itemsIndexed(LazyListScope arg2, List arg3, Function2 arg4, Function2 arg5, Function5 arg6) {
        Function1 v1_1;
        int v0 = arg3.size();
        if(arg4 != null) {
            LazyDslKt$itemsIndexed$2 v1 = new LazyDslKt$itemsIndexed$2(arg4, arg3);
        }
        else {
            v1_1 = null;
        }

        arg2.items(v0, v1_1, new LazyDslKt$itemsIndexed$3(arg5, arg3), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(arg6, arg3)));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void itemsIndexed(LazyListScope arg3, List arg4, Function2 arg5, Function5 arg6) {
        LazyDslKt$itemsIndexed$2 v1;
        int v0 = arg4.size();
        if(arg5 != null) {
            v1 = new LazyDslKt$itemsIndexed$2(arg5, arg4);
        }
        else {
            Function1 v1_1 = null;
        }

        arg3.items(v0, ((Function1)v1), new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(arg4), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(arg6, arg4)));
    }

    public static final void itemsIndexed(LazyListScope arg2, Object[] arg3, Function2 arg4, Function2 arg5, Function5 arg6) {
        Function1 v1_1;
        int v0 = arg3.length;
        if(arg4 != null) {
            LazyDslKt$itemsIndexed$6 v1 = new LazyDslKt$itemsIndexed$6(arg4, arg3);
        }
        else {
            v1_1 = null;
        }

        arg2.items(v0, v1_1, new LazyDslKt$itemsIndexed$7(arg5, arg3), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(arg6, arg3)));
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Use the non deprecated overload") public static final void itemsIndexed(LazyListScope arg3, Object[] arg4, Function2 arg5, Function5 arg6) {
        Function1 v1_1;
        int v0 = arg4.length;
        if(arg5 != null) {
            LazyDslKt$itemsIndexed$6 v1 = new LazyDslKt$itemsIndexed$6(arg5, arg4);
        }
        else {
            v1_1 = null;
        }

        arg3.items(v0, v1_1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(arg4), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(arg6, arg4)));
    }

    public static void itemsIndexed$default(LazyListScope arg1, List arg2, Function2 arg3, Function2 arg4, Function5 arg5, int arg6, Object arg7) {
        LazyDslKt$itemsIndexed$1 v4;
        Function1 v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = ((Function2)v0);
        }

        if((arg6 & 4) != 0) {
            v4 = LazyDslKt$itemsIndexed$1.INSTANCE;
        }

        arg6 = arg2.size();
        if(arg3 != null) {
            LazyDslKt$itemsIndexed$2 v0_1 = new LazyDslKt$itemsIndexed$2(arg3, arg2);
        }

        arg1.items(arg6, v0, new LazyDslKt$itemsIndexed$3(((Function2)v4), arg2), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(arg5, arg2)));
    }

    public static void itemsIndexed$default(LazyListScope arg1, List arg2, Function2 arg3, Function5 arg4, int arg5, Object arg6) {
        Function1 v6 = null;
        if((arg5 & 2) != 0) {
            arg3 = ((Function2)v6);
        }

        arg5 = arg2.size();
        if(arg3 != null) {
            LazyDslKt$itemsIndexed$2 v6_1 = new LazyDslKt$itemsIndexed$2(arg3, arg2);
        }

        arg1.items(arg5, v6, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(arg2), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new LazyDslKt$itemsIndexed$4(arg4, arg2)));
    }

    public static void itemsIndexed$default(LazyListScope arg1, Object[] arg2, Function2 arg3, Function2 arg4, Function5 arg5, int arg6, Object arg7) {
        LazyDslKt$itemsIndexed$5 v4;
        Function1 v0 = null;
        if((arg6 & 2) != 0) {
            arg3 = ((Function2)v0);
        }

        if((arg6 & 4) != 0) {
            v4 = LazyDslKt$itemsIndexed$5.INSTANCE;
        }

        arg6 = arg2.length;
        if(arg3 != null) {
            LazyDslKt$itemsIndexed$6 v0_1 = new LazyDslKt$itemsIndexed$6(arg3, arg2);
        }

        arg1.items(arg6, v0, new LazyDslKt$itemsIndexed$7(((Function2)v4), arg2), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(arg5, arg2)));
    }

    public static void itemsIndexed$default(LazyListScope arg1, Object[] arg2, Function2 arg3, Function5 arg4, int arg5, Object arg6) {
        Function1 v6 = null;
        if((arg5 & 2) != 0) {
            arg3 = ((Function2)v6);
        }

        arg5 = arg2.length;
        if(arg3 != null) {
            LazyDslKt$itemsIndexed$6 v6_1 = new LazyDslKt$itemsIndexed$6(arg3, arg2);
        }

        arg1.items(arg5, v6, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(arg2), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new LazyDslKt$itemsIndexed$8(arg4, arg2)));
    }
}

