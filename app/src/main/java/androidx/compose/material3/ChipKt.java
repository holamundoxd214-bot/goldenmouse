package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier$Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1={"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A¨\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001A¦\u0001\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001A¨\u0001\u0010\u0019\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001A¦\u0001\u0010\u0019\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001A°\u0001\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020\t2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u001C2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001E\u001A°\u0001\u0010\u001F\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020\t2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u001C2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001E\u001AÇ\u0001\u0010 \u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020\t2\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u001C2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u001D2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\"\u001A\u0091\u0001\u0010#\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010$\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001A\u008F\u0001\u0010#\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010$\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001A\u0091\u0001\u0010\'\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010$\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001A\u008F\u0001\u0010\'\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\u0015\b\u0002\u0010$\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001A\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001A¸\u0001\u0010(\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001A\u00020\t2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u0002002\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b1\u00102\u001AÍ\u0001\u00103\u001A\u00020\u00012\u0006\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00072\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001A\u00020\t2\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001A\u00020*2\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u001C2\b\u0010\u0010\u001A\u0004\u0018\u00010\u001D2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u0002002\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b4\u00105\u001A\u0091\u0001\u00106\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001A\u00020,2\u0006\u00108\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u000200H\u0003¢\u0006\u0004\b9\u0010:\u001A\u0091\u0001\u0010;\u001A\u00020\u00012\u0011\u0010\u0004\u001A\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001A\u00020*2\u0006\u0010+\u001A\u00020,2\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001A\u00020,2\u0006\u00108\u001A\u00020,2\u0006\u0010-\u001A\u00020.2\u0006\u0010/\u001A\u000200H\u0003¢\u0006\u0004\b<\u0010:\u001AN\u0010=\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001A\u00020,H\u0003¢\u0006\u0004\b>\u0010?\u001A9\u0010@\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000B\u001A\u000F\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00108\u001A\u00020,H\u0003¢\u0006\u0004\bA\u0010B\u001A%\u0010C\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001HE0D\"\u0004\b\u0000\u0010E2\b\u0010F\u001A\u0004\u0018\u0001HEH\u0003¢\u0006\u0002\u0010G\u001A&\u0010L\u001A\u0002002\b\b\u0002\u0010M\u001A\u00020\t2\b\b\u0002\u0010N\u001A\u00020\t2\b\b\u0002\u0010O\u001A\u00020\tH\u0002\"\u0018\u0010H\u001A\u00020\u000F*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\bJ\u0010K\"\u0010\u0010P\u001A\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q\"\u000E\u0010R\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010S\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010T\u001A\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010U\u001A\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010W\u001A\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010X\u001A\u00020VX\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2={"AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedAssistChip", "FilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedFilterChip", "InputChip", "avatar", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ElevatedSuggestionChip", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "AnimatingChipContent", "AnimatingChipContent-fe0OD_I", "leadingContent", "leadingContent-XO-JAsU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "trailingContent", "trailingContent-RPmYEkk", "(Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRetainedState", "Landroidx/compose/runtime/State;", "T", "targetValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "defaultSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "HorizontalElementsPadding", "F", "AssistChipPadding", "FilterChipPadding", "SuggestionChipPadding", "LeadingIconLayoutId", "", "LabelLayoutId", "TrailingIconLayoutId", "material3"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ChipKt {
    private static final PaddingValues AssistChipPadding = null;
    private static final PaddingValues FilterChipPadding = null;
    private static final float HorizontalElementsPadding = 0f;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding = null;
    private static final String TrailingIconLayoutId = "trailingIcon";

    static {
        float v0 = Dp.constructor-impl(8f);
        ChipKt.HorizontalElementsPadding = v0;
        ChipKt.AssistChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(v0, 0f, 2, null);
        ChipKt.FilterChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(v0, 0f, 2, null);
        ChipKt.SuggestionChipPadding = PaddingKt.PaddingValues-YgX7TsA$default(v0, 0f, 2, null);
    }

    private static final void AnimatingChipContent-fe0OD_I(Function2 arg26, TextStyle arg27, long arg28, Function2 arg30, Function2 arg31, Function2 arg32, long arg33, long arg35, float arg37, PaddingValues arg38, Composer arg39, int arg40) {
        int v13;
        long v11_1;
        Function2 v10_1;
        Function2 v9_1;
        Function2 v8_1;
        long v6_1;
        int v5;
        TextStyle v2 = arg27;
        int v14 = arg40;
        Composer v1 = arg39.startRestartGroup(-2070754602);
        ComposerKt.sourceInformation(v1, "C(AnimatingChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2118@102851L4086,2115@102724L4213:Chip.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v5 = v1.changedInstance(arg26) ? 4 : 2;
            v5 |= v14;
        }
        else {
            v5 = v14;
        }

        if((v14 & 0x30) == 0) {
            int v6 = v1.changed(v2) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v14 & 0x180) == 0) {
            v6_1 = arg28;
            int v8 = v1.changed(v6_1) ? 0x100 : 0x80;
            v5 |= v8;
        }
        else {
            v6_1 = arg28;
        }

        if((v14 & 0xC00) == 0) {
            v8_1 = arg30;
            int v9 = v1.changedInstance(v8_1) ? 0x800 : 0x400;
            v5 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        if((v14 & 0x6000) == 0) {
            v9_1 = arg31;
            int v10 = v1.changedInstance(v9_1) ? 0x4000 : 0x2000;
            v5 |= v10;
        }
        else {
            v9_1 = arg31;
        }

        if((0x30000 & v14) == 0) {
            v10_1 = arg32;
            int v11 = v1.changedInstance(v10_1) ? 0x20000 : 0x10000;
            v5 |= v11;
        }
        else {
            v10_1 = arg32;
        }

        if((0x180000 & v14) == 0) {
            v11_1 = arg33;
            v13 = v1.changed(v11_1) ? 0x100000 : 0x80000;
            v5 |= v13;
        }
        else {
            v11_1 = arg33;
        }

        if((0xC00000 & v14) == 0) {
            v13 = v5;
            int v15 = v1.changed(arg35) ? 0x800000 : 0x400000;
            v13 |= v15;
        }
        else {
            v13 = v5;
        }

        if((0x6000000 & v14) == 0) {
            int v16 = v1.changed(arg37) ? 0x4000000 : 0x2000000;
            v13 |= v16;
        }

        PaddingValues v0 = arg38;
        if((v14 & 0x30000000) == 0) {
            int v17 = v1.changed(v0) ? 0x20000000 : 0x10000000;
            v13 |= v17;
        }

        boolean v0_1 = (v13 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070754602, v13, -1, "androidx.compose.material3.AnimatingChipContent (Chip.kt:2114)");
            }

            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(v6_1)), TextKt.getLocalTextStyle().provides(v2)}, ComposableLambdaKt.rememberComposableLambda(0xD82B8E16, true, new ChipKt$AnimatingChipContent$1(arg37, arg38, v9_1, v8_1, v10_1, v11_1, arg26, arg35), v1, 54), v1, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_168;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_168:
        ScopeUpdateScope v15_1 = v1.endRestartGroup();
        if(v15_1 != null) {
            v15_1.updateScope(new ChipKt$$ExternalSyntheticLambda14(arg26, v2, v6_1, arg30, arg31, arg32, arg33, arg35, arg37, arg38, v14));
        }
    }

    static final Unit AnimatingChipContent_fe0OD_I$lambda$24(Function2 arg16, TextStyle arg17, long arg18, Function2 arg20, Function2 arg21, Function2 arg22, long arg23, long arg25, float arg27, PaddingValues arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.AnimatingChipContent-fe0OD_I(arg16, arg17, arg18, arg20, arg21, arg22, arg23, arg25, arg27, arg28, arg30, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1));
        return Unit.INSTANCE;
    }

    public static final void AssistChip(Function0 arg35, Function2 arg36, Modifier arg37, boolean arg38, Function2 arg39, Function2 arg40, Shape arg41, ChipColors arg42, ChipElevation arg43, BorderStroke arg44, MutableInteractionSource arg45, Composer arg46, int arg47, int arg48, int arg49) {
        MutableInteractionSource v11_2;
        BorderStroke v10_1;
        ChipElevation v9_1;
        ChipColors v8_1;
        Shape v7_1;
        Function2 v6_1;
        Function2 v5_2;
        boolean v4_1;
        Modifier v3_2;
        Composer v31;
        Function2 v22;
        boolean v2_2;
        int v11_1;
        MutableInteractionSource v30;
        BorderStroke v27;
        ChipElevation v26;
        Shape v24;
        Function2 v23;
        int v0_2;
        Companion v15_3;
        int v3_1;
        BorderStroke v1_1;
        ChipElevation v20_1;
        Companion v37;
        Shape v17_1;
        int v5_1;
        Companion v0_3;
        int v18;
        ChipColors v3;
        int v17;
        int v15;
        Function2 v10;
        int v9;
        boolean v7;
        int v6;
        Modifier v5;
        int v4;
        Function2 v13;
        int v1;
        int v12 = arg47;
        int v14 = arg49;
        Composer v8 = arg46.startRestartGroup(0x470DBF8B);
        ComposerKt.sourceInformation(v8, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)151@7455L5,146@7287L542:Chip.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v1 = v12 | 6;
        }
        else {
            Function0 v11 = arg35;
            if((v12 & 6) == 0) {
                v1 = v8.changedInstance(v11) ? 4 : 2;
                v1 |= v12;
            }
            else {
                v1 = v12;
            }
        }

        if((v14 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg36;
        }
        else {
            v13 = arg36;
            if((v12 & 0x30) == 0) {
                v4 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        v4 = v14 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v5 = arg37;
            v6 = v8.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg37;
        }

        v6 = v14 & 8;
        if(v6 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v7 = arg38;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_66:
            v7 = arg38;
        }

        v9 = v14 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = arg39;
            v15 = v8.changedInstance(v10) ? 0x4000 : 0x2000;
            v1 |= v15;
        }
        else {
        label_81:
            v10 = arg39;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            Function2 v2 = arg40;
            if((v12 & v16) == 0) {
                v16 = v8.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v16;
            }
        }

        if((v12 & 0x180000) == 0) {
            Shape v0 = arg41;
            v17 = (v14 & 0x40) != 0 || !v8.changed(v0) ? 0x80000 : 0x100000;
            v1 |= v17;
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v3 = arg42;
                if(v8.changed(v3)) {
                    v18 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v3 = arg42;
            label_122:
                v18 = 0x400000;
            }

            v1 |= v18;
        }
        else {
            v3 = arg42;
        }

        if((v12 & 0x6000000) == 0) {
            v18 = (v14 & 0x100) != 0 || !v8.changed(arg43) ? 0x2000000 : 0x4000000;
            v1 |= v18;
        }

        if((v12 & 0x30000000) == 0) {
            v18 = (v14 & 0x200) != 0 || !v8.changed(arg44) ? 0x10000000 : 0x20000000;
            v1 |= v18;
        }

        int v2_1 = v14 & 0x400;
        if(v2_1 != 0) {
            v18 = v2_1;
            v2_1 = arg48 | 6;
        }
        else if((arg48 & 6) == 0) {
            v18 = v2_1;
            int v19 = v8.changed(arg45) ? 4 : 2;
            v2_1 = arg48 | v19;
        }
        else {
            v18 = v2_1;
            v2_1 = arg48;
        }

        int v46 = v1;
        boolean v19_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 || (v2_1 & 3) != 2 ? true : false;
        if(v8.shouldExecute(v0_1, v46 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "140@7003L5,141@7054L18,142@7125L21,143@7195L25");
            v1 = 0xFE3FFFFF;
            v17 = 0xFFC7FFFF;
            int v20 = v2_1;
            v2_1 = 6;
            if((v12 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v5;
                }

                if(v6 != 0) {
                }
                else {
                    v19_1 = v7;
                }

                Function2 v21 = null;
                v22 = v9 != 0 ? v21 : v10;
                Function2 v15_2 = v15 != 0 ? v21 : arg40;
                if((v14 & 0x40) != 0) {
                    v5_1 = v46 & v17;
                    v17_1 = AssistChipDefaults.INSTANCE.getShape(v8, v2_1);
                }
                else {
                    v17_1 = arg41;
                    v5_1 = v46;
                }

                if((v14 & 0x80) != 0) {
                    v3 = AssistChipDefaults.INSTANCE.assistChipColors(v8, v2_1);
                    v5_1 &= v1;
                }

                ChipColors v23_1 = v3;
                int v24_1 = v5_1;
                if((v14 & 0x100) != 0) {
                    v37 = v0_3;
                    v0_2 = v20;
                    v11_1 = v2_1;
                    v24_1 &= 0xF1FFFFFF;
                    v20_1 = AssistChipDefaults.INSTANCE.assistChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                }
                else {
                    v37 = v0_3;
                    v11_1 = v2_1;
                    v0_2 = v20;
                    v20_1 = arg43;
                }

                if((v14 & 0x200) != 0) {
                    v2_2 = v19_1;
                    v1_1 = AssistChipDefaults.INSTANCE.assistChipBorder-h1eT-Ww(v2_2, 0, 0, 0f, v8, v24_1 >> 9 & 14 | 0x6000, 14);
                    v3_1 = v24_1 & 0x8FFFFFFF;
                }
                else {
                    v2_2 = v19_1;
                    v1_1 = arg44;
                    v3_1 = v24_1;
                }

                if(v18 != 0) {
                    v27 = v1_1;
                    v1 = v3_1;
                    v24 = v17_1;
                    v26 = v20_1;
                    v30 = ((MutableInteractionSource)v21);
                }
                else {
                    v30 = arg45;
                    v27 = v1_1;
                    v1 = v3_1;
                    v24 = v17_1;
                    v26 = v20_1;
                }

                v3 = v23_1;
                v23 = v15_2;
                v15_3 = v37;
            }
            else {
                v8.skipToGroupEnd();
                v0_2 = (v14 & 0x40) != 0 ? v46 & v17 : v46;
                if((v14 & 0x80) != 0) {
                    v0_2 &= v1;
                }

                if((v14 & 0x100) != 0) {
                    v0_2 &= 0xF1FFFFFF;
                }

                if((v14 & 0x200) != 0) {
                    v0_2 &= 0x8FFFFFFF;
                }

                v23 = arg40;
                v24 = arg41;
                v26 = arg43;
                v27 = arg44;
                v30 = arg45;
                v1 = v0_2;
                v11_1 = v2_1;
                Modifier v15_1 = v5;
                v2_2 = v7;
                v22 = v10;
                v0_2 = v20;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x470DBF8B, v1, v0_2, "androidx.compose.material3.AssistChip (Chip.kt:146)");
            }

            v5_1 = v1 << 6;
            int v32 = v1 >> 6 & 14 | v1 << 3 & 0x70 | v1 >> 3 & 0x380 | v5_1 & 0x1C00 | 0x380000 & v5_1 | 0x1C00000 & v5_1 | 0xE000000 & v5_1 | v5_1 & 0x70000000;
            v1 >>= 24;
            boolean v17_2 = v2_2;
            ChipColors v25 = v3;
            ChipKt.Chip-nkUnTEs(((Modifier)v15_3), arg35, v17_2, v13, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), v8, v11_1), v3.labelColor-vNxB06k$material3(v2_2), v22, v23, v24, v25, v26, v27, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, v30, v8, v32, v1 & 0x70 | (v1 & 14 | 0xD80) | v0_2 << 12 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v31 = v8;
            v3_2 = ((Modifier)v15_3);
            v4_1 = v17_2;
            v5_2 = v22;
            v6_1 = v23;
            v7_1 = v24;
            v8_1 = v25;
            v9_1 = v26;
            v10_1 = v27;
            v11_2 = v30;
        }
        else {
            v8.skipToGroupEnd();
            v6_1 = arg40;
            v9_1 = arg43;
            v11_2 = arg45;
            v4_1 = v7;
            v31 = v8;
            v7_1 = arg41;
            v8_1 = v3;
            v3_2 = v5;
            v5_2 = v10;
            v10_1 = arg44;
        }

        ScopeUpdateScope v15_4 = v31.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new ChipKt$$ExternalSyntheticLambda6(arg35, arg36, v3_2, v4_1, v5_2, v6_1, v7_1, v8_1, v9_1, v10_1, v11_2, v12, arg48, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith="<_subannotation>") public static final void AssistChip(Function0 arg35, Function2 arg36, Modifier arg37, boolean arg38, Function2 arg39, Function2 arg40, Shape arg41, ChipColors arg42, ChipElevation arg43, ChipBorder arg44, MutableInteractionSource arg45, Composer arg46, int arg47, int arg48, int arg49) {
        MutableInteractionSource v11_2;
        ChipElevation v9_1;
        ChipColors v8_1;
        Shape v7_1;
        Function2 v6_1;
        Function2 v5_3;
        boolean v4_2;
        Modifier v3_3;
        ChipBorder v10_2;
        State v5_2;
        Function2 v22;
        int v11_1;
        MutableInteractionSource v30;
        ChipBorder v1_1;
        ChipElevation v26;
        Shape v24;
        Function2 v23;
        int v0_2;
        Companion v15_3;
        Object v30_1;
        MutableInteractionSource v3_2;
        ChipElevation v10_1;
        Companion v37;
        Composer v31;
        Shape v17_1;
        int v5_1;
        Modifier v0_4;
        int v18;
        ChipColors v3;
        int v17;
        int v15;
        Function2 v10;
        int v9;
        boolean v8;
        int v6;
        Modifier v5;
        int v4;
        Function2 v13;
        int v1;
        int v12 = arg47;
        int v14 = arg49;
        Composer v7 = arg46.startRestartGroup(0x730A685F);
        ComposerKt.sourceInformation(v7, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)236@11549L5,231@11381L572:Chip.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v1 = v12 | 6;
        }
        else {
            Function0 v11 = arg35;
            if((v12 & 6) == 0) {
                v1 = v7.changedInstance(v11) ? 4 : 2;
                v1 |= v12;
            }
            else {
                v1 = v12;
            }
        }

        if((v14 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg36;
        }
        else {
            v13 = arg36;
            if((v12 & 0x30) == 0) {
                v4 = v7.changedInstance(v13) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        v4 = v14 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v5 = arg37;
            v6 = v7.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg37;
        }

        v6 = v14 & 8;
        if(v6 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v8 = arg38;
            v9 = v7.changed(v8) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_66:
            v8 = arg38;
        }

        v9 = v14 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = arg39;
            v15 = v7.changedInstance(v10) ? 0x4000 : 0x2000;
            v1 |= v15;
        }
        else {
        label_81:
            v10 = arg39;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            Function2 v2 = arg40;
            if((v12 & v16) == 0) {
                v16 = v7.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v16;
            }
        }

        if((v12 & 0x180000) == 0) {
            Shape v0 = arg41;
            v17 = (v14 & 0x40) != 0 || !v7.changed(v0) ? 0x80000 : 0x100000;
            v1 |= v17;
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v3 = arg42;
                if(v7.changed(v3)) {
                    v18 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v3 = arg42;
            label_122:
                v18 = 0x400000;
            }

            v1 |= v18;
        }
        else {
            v3 = arg42;
        }

        if((v12 & 0x6000000) == 0) {
            v18 = (v14 & 0x100) != 0 || !v7.changed(arg43) ? 0x2000000 : 0x4000000;
            v1 |= v18;
        }

        if((v12 & 0x30000000) == 0) {
            v18 = (v14 & 0x200) != 0 || !v7.changed(arg44) ? 0x10000000 : 0x20000000;
            v1 |= v18;
        }

        int v2_1 = v14 & 0x400;
        if(v2_1 != 0) {
            v18 = v2_1;
            v2_1 = arg48 | 6;
        }
        else if((arg48 & 6) == 0) {
            v18 = v2_1;
            int v19 = v7.changed(arg45) ? 4 : 2;
            v2_1 = arg48 | v19;
        }
        else {
            v18 = v2_1;
            v2_1 = arg48;
        }

        int v46 = v1;
        boolean v19_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 || (v2_1 & 3) != 2 ? true : false;
        if(v7.shouldExecute(v0_1, v46 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "225@11072L5,226@11123L18,227@11194L21,228@11262L18,229@11332L39");
            v1 = 0xFE3FFFFF;
            v17 = 0xFFC7FFFF;
            Function2 v20 = null;
            int v21 = v2_1;
            v2_1 = 6;
            if((v12 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_4 = v5;
                }

                if(v6 != 0) {
                }
                else {
                    v19_1 = v8;
                }

                v22 = v9 != 0 ? v20 : v10;
                Function2 v15_2 = v15 != 0 ? v20 : arg40;
                if((v14 & 0x40) != 0) {
                    v5_1 = v46 & v17;
                    v17_1 = AssistChipDefaults.INSTANCE.getShape(v7, v2_1);
                }
                else {
                    v17_1 = arg41;
                    v5_1 = v46;
                }

                if((v14 & 0x80) != 0) {
                    v3 = AssistChipDefaults.INSTANCE.assistChipColors(v7, v2_1);
                    v5_1 &= v1;
                }

                ChipColors v23_1 = v3;
                int v24_1 = v5_1;
                if((v14 & 0x100) != 0) {
                    v31 = v7;
                    v37 = ((Companion)v0_4);
                    v11_1 = v2_1;
                    v0_2 = v21;
                    v24_1 &= 0xF1FFFFFF;
                    v10_1 = AssistChipDefaults.INSTANCE.assistChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v31, 0x180000, 0x3F);
                }
                else {
                    v37 = ((Companion)v0_4);
                    v11_1 = v2_1;
                    v31 = v7;
                    v0_2 = v21;
                    v10_1 = arg43;
                }

                if((v14 & 0x200) != 0) {
                    v7 = v31;
                    v1_1 = AssistChipDefaults.INSTANCE.assistChipBorder-d_3_b6Q(0, 0, 0f, v7, 0xC00, 7);
                    v2_1 = v24_1 & 0x8FFFFFFF;
                }
                else {
                    v7 = v31;
                    v1_1 = arg44;
                    v2_1 = v24_1;
                }

                if(v18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v7, -636337050, "CC(remember):Chip.kt#9igjgp");
                    Object v3_1 = v7.rememberedValue();
                    if(v3_1 == Composer.Companion.getEmpty()) {
                        v3_2 = InteractionSourceKt.MutableInteractionSource();
                        v7.updateRememberedValue(v3_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v7);
                    v30_1 = v3_2;
                }
                else {
                    v30 = arg45;
                }

                v26 = v10_1;
                v24 = v17_1;
                v8 = v19_1;
                v3 = v23_1;
                v23 = v15_2;
                v15_3 = v37;
            }
            else {
                v7.skipToGroupEnd();
                v0_2 = (v14 & 0x40) != 0 ? v46 & v17 : v46;
                if((v14 & 0x80) != 0) {
                    v0_2 &= v1;
                }

                if((v14 & 0x100) != 0) {
                    v0_2 &= 0xF1FFFFFF;
                }

                if((v14 & 0x200) != 0) {
                    v0_2 &= 0x8FFFFFFF;
                }

                v23 = arg40;
                v24 = arg41;
                v26 = arg43;
                v1_1 = arg44;
                v30 = arg45;
                v11_1 = v2_1;
                Modifier v15_1 = v5;
                v22 = v10;
                v2_1 = v0_2;
                v0_2 = v21;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x730A685F, v2_1, v0_2, "androidx.compose.material3.AssistChip (Chip.kt:231)");
            }

            TextStyle v19_2 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), v7, v11_1);
            Object v4_1 = v20;
            long v20_1 = v3.labelColor-vNxB06k$material3(v8);
            if(v1_1 == null) {
                v7.startReplaceGroup(0x683D120D);
                v7.endReplaceGroup();
                v5_2 = ((State)v4_1);
            }
            else {
                v7.startReplaceGroup(-636322700);
                ComposerKt.sourceInformation(v7, "243@11781L21");
                v5_2 = v1_1.borderStroke$material3(v8, v7, v2_1 >> 9 & 14 | v2_1 >> 24 & 0x70);
                v7.endReplaceGroup();
            }

            if(v5_2 != null) {
                v4_1 = v5_2.getValue();
            }

            v5_1 = v2_1 << 6;
            ChipColors v25 = v3;
            v31 = v7;
            boolean v17_2 = v8;
            ChipKt.Chip-nkUnTEs(((Modifier)v15_3), arg35, v17_2, v13, v19_2, v20_1, v22, v23, v24, v25, v26, v4_1, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, ((MutableInteractionSource)v30_1), v31, v2_1 >> 6 & 14 | v2_1 << 3 & 0x70 | v2_1 >> 3 & 0x380 | v5_1 & 0x1C00 | 0x380000 & v5_1 | 0x1C00000 & v5_1 | 0xE000000 & v5_1 | v5_1 & 0x70000000, v2_1 >> 24 & 14 | 0xD80 | v0_2 << 12 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_2 = v1_1;
            v3_3 = ((Modifier)v15_3);
            v4_2 = v17_2;
            v5_3 = v22;
            v6_1 = v23;
            v7_1 = v24;
            v8_1 = v25;
            v9_1 = v26;
            v11_2 = ((MutableInteractionSource)v30_1);
        }
        else {
            v31 = v7;
            v31.skipToGroupEnd();
            v6_1 = arg40;
            v7_1 = arg41;
            v9_1 = arg43;
            v11_2 = arg45;
            v4_2 = v8;
            v8_1 = v3;
            v3_3 = v5;
            v5_3 = v10;
            v10_2 = arg44;
        }

        ScopeUpdateScope v15_4 = v31.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new ChipKt$$ExternalSyntheticLambda13(arg35, arg36, v3_3, v4_2, v5_3, v6_1, v7_1, v8_1, v9_1, v10_2, v11_2, v12, arg48, v14));
        }
    }

    static final Unit AssistChip$lambda$0(Function0 arg16, Function2 arg17, Modifier arg18, boolean arg19, Function2 arg20, Function2 arg21, Shape arg22, ChipColors arg23, ChipElevation arg24, BorderStroke arg25, MutableInteractionSource arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.AssistChip(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit AssistChip$lambda$2(Function0 arg16, Function2 arg17, Modifier arg18, boolean arg19, Function2 arg20, Function2 arg21, Shape arg22, ChipColors arg23, ChipElevation arg24, ChipBorder arg25, MutableInteractionSource arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.AssistChip(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    private static final void Chip-nkUnTEs(Modifier arg28, Function0 arg29, boolean arg30, Function2 arg31, TextStyle arg32, long arg33, Function2 arg35, Function2 arg36, Shape arg37, ChipColors arg38, ChipElevation arg39, BorderStroke arg40, float arg41, PaddingValues arg42, MutableInteractionSource arg43, Composer arg44, int arg45, int arg46) {
        Composer v15_1;
        State v7_3;
        ChipKt$$ExternalSyntheticLambda8 v6_3;
        Object v13_1;
        MutableInteractionSource v7_2;
        Object v7_1;
        int v26;
        int v23;
        int v22;
        int v20;
        Function2 v12_1;
        int v12;
        int v5;
        Modifier v1 = arg28;
        boolean v3 = arg30;
        ChipColors v9 = arg38;
        ChipElevation v0 = arg39;
        MutableInteractionSource v13 = arg43;
        int v14 = arg45;
        int v15 = arg46;
        Composer v4 = arg44.startRestartGroup(0x3531F1D6);
        ComposerKt.sourceInformation(v4, "C(Chip)N(modifier,onClick,enabled,label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)1962@97212L22,1969@97509L478,1960@97138L849:Chip.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v5 = v4.changed(v1) ? 4 : 2;
            v5 |= v14;
        }
        else {
            v5 = v14;
        }

        if((v14 & 0x30) == 0) {
            v12 = v4.changedInstance(arg29) ? 0x20 : 16;
            v5 |= v12;
        }

        int v16 = 0x100;
        int v17 = 0x80;
        if((v14 & 0x180) == 0) {
            v12 = v4.changed(v3) ? v16 : v17;
            v5 |= v12;
        }

        int v18 = 0x800;
        int v19 = 0x400;
        if((v14 & 0xC00) == 0) {
            v12_1 = arg31;
            v20 = v4.changedInstance(v12_1) ? v18 : v19;
            v5 |= v20;
        }
        else {
            v12_1 = arg31;
        }

        v20 = 0x4000;
        int v21 = 0x2000;
        if((v14 & 0x6000) == 0) {
            v22 = v4.changed(arg32) ? v20 : v21;
            v5 |= v22;
        }

        long v7 = arg33;
        if((v14 & 0x30000) == 0) {
            v23 = v4.changed(v7) ? 0x20000 : 0x10000;
            v5 |= v23;
        }

        Function2 v10 = arg35;
        if((v14 & 0x180000) == 0) {
            int v24 = v4.changedInstance(v10) ? 0x100000 : 0x80000;
            v5 |= v24;
        }

        Function2 v11 = arg36;
        if((v14 & 0xC00000) == 0) {
            int v25 = v4.changedInstance(v11) ? 0x800000 : 0x400000;
            v5 |= v25;
        }

        Shape v2 = arg37;
        if((v14 & 0x6000000) == 0) {
            v26 = v4.changed(v2) ? 0x4000000 : 0x2000000;
            v5 |= v26;
        }

        if((v14 & 0x30000000) == 0) {
            v26 = v4.changed(v9) ? 0x20000000 : 0x10000000;
            v5 |= v26;
        }

        if((v15 & 6) == 0) {
            v22 = v4.changed(v0) ? 4 : 2;
            v22 |= v15;
        }
        else {
            v22 = v15;
        }

        BorderStroke v14_1 = arg40;
        if((v15 & 0x30) == 0) {
            v23 = v4.changed(v14_1) ? 0x20 : 16;
            v22 |= v23;
        }

        if((v15 & 0x180) == 0) {
            if(v4.changed(arg41)) {
            }
            else {
                v16 = v17;
            }

            v22 |= v16;
        }

        if((v15 & 0xC00) == 0) {
            if(v4.changed(arg42)) {
            }
            else {
                v18 = v19;
            }

            v22 |= v18;
        }

        if((v15 & 0x6000) == 0) {
            if(v4.changed(v13)) {
            }
            else {
                v20 = v21;
            }

            v22 |= v20;
        }

        int v2_1 = v22;
        boolean v6 = (v5 & 306783379) != 306783378 || (v2_1 & 9363) != 9362 ? true : false;
        if(v4.shouldExecute(v6, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x3531F1D6, v5, v2_1, "androidx.compose.material3.Chip (Chip.kt:1957)");
            }

            String v6_1 = "CC(remember):Chip.kt#9igjgp";
            if(v13 == null) {
                v4.startReplaceGroup(0x5F265045);
                ComposerKt.sourceInformation(v4, "1959@97094L39");
                ComposerKt.sourceInformationMarkerStart(v4, 0xB07D1B5D, v6_1);
                v7_1 = v4.rememberedValue();
                if(v7_1 == Composer.Companion.getEmpty()) {
                    v7_2 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v7_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                v13_1 = v7_2;
            }
            else {
                v4.startReplaceGroup(0xB07D18D2);
                v4.endReplaceGroup();
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xB07D2A0C, v6_1);
            Object v6_2 = v4.rememberedValue();
            if(v6_2 == Composer.Companion.getEmpty()) {
                v6_3 = new ChipKt$$ExternalSyntheticLambda8();
                v4.updateRememberedValue(v6_3);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            v7_1 = null;
            v16 = v2_1;
            Modifier v17_1 = SemanticsModifierKt.semantics$default(v1, false, ((Function1)v6_3), 1, v7_1);
            long v18_1 = v9.containerColor-vNxB06k$material3(v3);
            if(v0 == null) {
                v4.startReplaceGroup(0x5F2A8220);
            }
            else {
                v4.startReplaceGroup(0xB07D3E01);
                ComposerKt.sourceInformation(v4, "1966@97371L43");
                v7_3 = v0.shadowElevation$material3(v3, ((MutableInteractionSource)v13_1), v4, v5 >> 6 & 14 | v16 << 6 & 0x380);
            }

            v4.endReplaceGroup();
            float v6_4 = v7_3 != null ? v7_3.getValue().unbox-impl() : Dp.constructor-impl(0f);
            v15_1 = v4;
            SurfaceKt.Surface-o_FOJdg(arg29, v17_1, arg30, arg37, v18_1, 0, 0f, v6_4, v14_1, ((MutableInteractionSource)v13_1), ComposableLambdaKt.rememberComposableLambda(-70915349, true, new ChipKt$Chip$2(v12_1, arg32, arg33, v10, v11, v9, v3, arg41, arg42), v15_1, 54), v15_1, v5 >> 15 & 0x1C00 | (v5 >> 3 & 14 | v5 & 0x380) | v16 << 21 & 0xE000000, 6, 0x60);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_291;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v15_1 = v4;
            v15_1.skipToGroupEnd();
        }

    label_291:
        ScopeUpdateScope v0_1 = v15_1.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ChipKt$$ExternalSyntheticLambda9(arg28, arg29, arg30, arg31, arg32, arg33, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg45, arg46));
        }
    }

    private static final void ChipContent-fe0OD_I(Function2 arg26, TextStyle arg27, long arg28, Function2 arg30, Function2 arg31, Function2 arg32, long arg33, long arg35, float arg37, PaddingValues arg38, Composer arg39, int arg40) {
        int v13;
        long v11_1;
        Function2 v10_1;
        Function2 v9_1;
        Function2 v8_1;
        long v6_1;
        int v5;
        TextStyle v2 = arg27;
        int v14 = arg40;
        Composer v1 = arg39.startRestartGroup(1105630840);
        ComposerKt.sourceInformation(v1, "C(ChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2056@100480L1721,2053@100353L1848:Chip.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v5 = v1.changedInstance(arg26) ? 4 : 2;
            v5 |= v14;
        }
        else {
            v5 = v14;
        }

        if((v14 & 0x30) == 0) {
            int v6 = v1.changed(v2) ? 0x20 : 16;
            v5 |= v6;
        }

        if((v14 & 0x180) == 0) {
            v6_1 = arg28;
            int v8 = v1.changed(v6_1) ? 0x100 : 0x80;
            v5 |= v8;
        }
        else {
            v6_1 = arg28;
        }

        if((v14 & 0xC00) == 0) {
            v8_1 = arg30;
            int v9 = v1.changedInstance(v8_1) ? 0x800 : 0x400;
            v5 |= v9;
        }
        else {
            v8_1 = arg30;
        }

        if((v14 & 0x6000) == 0) {
            v9_1 = arg31;
            int v10 = v1.changedInstance(v9_1) ? 0x4000 : 0x2000;
            v5 |= v10;
        }
        else {
            v9_1 = arg31;
        }

        if((0x30000 & v14) == 0) {
            v10_1 = arg32;
            int v11 = v1.changedInstance(v10_1) ? 0x20000 : 0x10000;
            v5 |= v11;
        }
        else {
            v10_1 = arg32;
        }

        if((0x180000 & v14) == 0) {
            v11_1 = arg33;
            v13 = v1.changed(v11_1) ? 0x100000 : 0x80000;
            v5 |= v13;
        }
        else {
            v11_1 = arg33;
        }

        if((0xC00000 & v14) == 0) {
            v13 = v5;
            int v15 = v1.changed(arg35) ? 0x800000 : 0x400000;
            v13 |= v15;
        }
        else {
            v13 = v5;
        }

        if((0x6000000 & v14) == 0) {
            int v16 = v1.changed(arg37) ? 0x4000000 : 0x2000000;
            v13 |= v16;
        }

        PaddingValues v0 = arg38;
        if((v14 & 0x30000000) == 0) {
            int v17 = v1.changed(v0) ? 0x20000000 : 0x10000000;
            v13 |= v17;
        }

        boolean v0_1 = (v13 & 306783379) != 306783378 ? true : false;
        if(v1.shouldExecute(v0_1, v13 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105630840, v13, -1, "androidx.compose.material3.ChipContent (Chip.kt:2052)");
            }

            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(v6_1)), TextKt.getLocalTextStyle().provides(v2)}, ComposableLambdaKt.rememberComposableLambda(-2130105544, true, new ChipKt$ChipContent$1(arg37, arg38, v9_1, v8_1, v10_1, v11_1, arg26, arg35), v1, 54), v1, ProvidedValue.$stable | 0x30);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_168;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v1.skipToGroupEnd();
        }

    label_168:
        ScopeUpdateScope v15_1 = v1.endRestartGroup();
        if(v15_1 != null) {
            v15_1.updateScope(new ChipKt$$ExternalSyntheticLambda1(arg26, v2, v6_1, arg30, arg31, arg32, arg33, arg35, arg37, arg38, v14));
        }
    }

    static final Unit ChipContent_fe0OD_I$lambda$23(Function2 arg16, TextStyle arg17, long arg18, Function2 arg20, Function2 arg21, Function2 arg22, long arg23, long arg25, float arg27, PaddingValues arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.ChipContent-fe0OD_I(arg16, arg17, arg18, arg20, arg21, arg22, arg23, arg25, arg27, arg28, arg30, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1));
        return Unit.INSTANCE;
    }

    static final Unit Chip_nkUnTEs$lambda$17$lambda$16(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit Chip_nkUnTEs$lambda$18(Modifier arg20, Function0 arg21, boolean arg22, Function2 arg23, TextStyle arg24, long arg25, Function2 arg27, Function2 arg28, Shape arg29, ChipColors arg30, ChipElevation arg31, BorderStroke arg32, float arg33, PaddingValues arg34, MutableInteractionSource arg35, int arg36, int arg37, Composer arg38, int arg39) {
        ChipKt.Chip-nkUnTEs(arg20, arg21, arg22, arg23, arg24, arg25, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg38, RecomposeScopeImplKt.updateChangedFlags(arg36 | 1), RecomposeScopeImplKt.updateChangedFlags(arg37));
        return Unit.INSTANCE;
    }

    public static final void ElevatedAssistChip(Function0 arg35, Function2 arg36, Modifier arg37, boolean arg38, Function2 arg39, Function2 arg40, Shape arg41, ChipColors arg42, ChipElevation arg43, BorderStroke arg44, MutableInteractionSource arg45, Composer arg46, int arg47, int arg48, int arg49) {
        MutableInteractionSource v11_2;
        BorderStroke v10_1;
        ChipElevation v9_1;
        ChipColors v8_1;
        Shape v7_1;
        Function2 v6_1;
        Function2 v5_2;
        boolean v4_1;
        Modifier v3_2;
        Composer v31;
        Function2 v22_1;
        Modifier v15_1;
        int v11_1;
        MutableInteractionSource v30;
        BorderStroke v27;
        ChipElevation v26;
        Shape v24;
        Function2 v23;
        int v0_2;
        Companion v15_3;
        ChipElevation v1_1;
        Companion v37;
        ChipColors v25;
        Shape v21_1;
        int v5_1;
        Companion v0_3;
        int v19;
        int v18;
        ChipColors v3;
        int v17;
        int v15;
        Function2 v10;
        int v9;
        boolean v7;
        int v6;
        Modifier v5;
        int v4;
        Function2 v13;
        int v1;
        int v12 = arg47;
        int v14 = arg49;
        Composer v8 = arg46.startRestartGroup(2028863105);
        ComposerKt.sourceInformation(v8, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)310@15241L5,305@15073L542:Chip.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v1 = v12 | 6;
        }
        else {
            Function0 v11 = arg35;
            if((v12 & 6) == 0) {
                v1 = v8.changedInstance(v11) ? 4 : 2;
                v1 |= v12;
            }
            else {
                v1 = v12;
            }
        }

        if((v14 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg36;
        }
        else {
            v13 = arg36;
            if((v12 & 0x30) == 0) {
                v4 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        v4 = v14 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v5 = arg37;
            v6 = v8.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg37;
        }

        v6 = v14 & 8;
        if(v6 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v7 = arg38;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_66:
            v7 = arg38;
        }

        v9 = v14 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = arg39;
            v15 = v8.changedInstance(v10) ? 0x4000 : 0x2000;
            v1 |= v15;
        }
        else {
        label_81:
            v10 = arg39;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            Function2 v2 = arg40;
            if((v12 & v16) == 0) {
                v16 = v8.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v16;
            }
        }

        if((v12 & 0x180000) == 0) {
            Shape v0 = arg41;
            v17 = (v14 & 0x40) != 0 || !v8.changed(v0) ? 0x80000 : 0x100000;
            v1 |= v17;
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v3 = arg42;
                if(v8.changed(v3)) {
                    v18 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v3 = arg42;
            label_122:
                v18 = 0x400000;
            }

            v1 |= v18;
        }
        else {
            v3 = arg42;
        }

        if((v12 & 0x6000000) == 0) {
            v18 = (v14 & 0x100) != 0 || !v8.changed(arg43) ? 0x2000000 : 0x4000000;
            v1 |= v18;
        }

        int v2_1 = v14 & 0x200;
        v18 = 0x30000000;
        if(v2_1 != 0) {
            v1 |= v18;
            goto label_157;
        }
        else if((v12 & v18) == 0) {
            v18 = v2_1;
            v19 = v8.changed(arg44) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_157:
            v18 = v2_1;
        }

        v2_1 = v14 & 0x400;
        if(v2_1 != 0) {
            v19 = v2_1;
            v2_1 = arg48 | 6;
        }
        else if((arg48 & 6) == 0) {
            v19 = v2_1;
            int v20 = v8.changed(arg45) ? 4 : 2;
            v2_1 = arg48 | v20;
        }
        else {
            v19 = v2_1;
            v2_1 = arg48;
        }

        int v46 = v1;
        boolean v20_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 || (v2_1 & 3) != 2 ? true : false;
        if(v8.shouldExecute(v0_1, v46 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "299@14813L5,300@14864L26,301@14943L29");
            v17 = 0xF1FFFFFF;
            v1 = 0xFE3FFFFF;
            int v21 = 0xFFC7FFFF;
            int v22 = v2_1;
            v2_1 = 6;
            if((v12 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v5;
                }

                if(v6 != 0) {
                }
                else {
                    v20_1 = v7;
                }

                v23 = null;
                Function2 v24_1 = v9 != 0 ? v23 : v10;
                Function2 v15_2 = v15 != 0 ? v23 : arg40;
                if((v14 & 0x40) != 0) {
                    v5_1 = v46 & v21;
                    v21_1 = AssistChipDefaults.INSTANCE.getShape(v8, v2_1);
                }
                else {
                    v21_1 = arg41;
                    v5_1 = v46;
                }

                if((v14 & 0x80) != 0) {
                    v3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(v8, v2_1);
                    v5_1 &= v1;
                }

                v25 = v3;
                int v26_1 = v5_1;
                if((v14 & 0x100) != 0) {
                    v37 = v0_3;
                    v0_2 = v22;
                    v11_1 = v2_1;
                    v1_1 = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                    v2_1 = v26_1 & v17;
                }
                else {
                    v37 = v0_3;
                    v11_1 = v2_1;
                    v0_2 = v22;
                    v1_1 = arg43;
                    v2_1 = v26_1;
                }

                BorderStroke v3_1 = v18 != 0 ? ((BorderStroke)v23) : arg44;
                if(v19 != 0) {
                    v26 = v1_1;
                    v27 = v3_1;
                    v7 = v20_1;
                    v30 = ((MutableInteractionSource)v23);
                    v22_1 = v24_1;
                    v3 = v25;
                    v23 = v15_2;
                    v24 = v21_1;
                    v15_3 = v37;
                    goto label_317;
                }

                v30 = arg45;
                v26 = v1_1;
                v27 = v3_1;
                v23 = v15_2;
                v7 = v20_1;
                v22_1 = v24_1;
                v3 = v25;
                v15_3 = v37;
                v24 = v21_1;
            }
            else {
                v8.skipToGroupEnd();
                v0_2 = (v14 & 0x40) != 0 ? v46 & v21 : v46;
                if((v14 & 0x80) != 0) {
                    v0_2 &= v1;
                }

                if((v14 & 0x100) != 0) {
                    v0_2 &= v17;
                }

                v23 = arg40;
                v24 = arg41;
                v26 = arg43;
                v27 = arg44;
                v30 = arg45;
                v11_1 = v2_1;
                v15_1 = v5;
                v2_1 = v0_2;
                v0_2 = v22;
                v22_1 = v10;
            }

        label_317:
            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2028863105, v2_1, v0_2, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:305)");
            }

            v4 = v2_1 << 6;
            v1 = v2_1 >> 24;
            v25 = v3;
            boolean v17_1 = v7;
            ChipKt.Chip-nkUnTEs(v15_1, arg35, v17_1, v13, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), v8, v11_1), v3.labelColor-vNxB06k$material3(v7), v22_1, v23, v24, v25, v26, v27, AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.AssistChipPadding, v30, v8, v2_1 >> 6 & 14 | v2_1 << 3 & 0x70 | v2_1 >> 3 & 0x380 | v4 & 0x1C00 | 0x380000 & v4 | 0x1C00000 & v4 | 0xE000000 & v4 | v4 & 0x70000000, v1 & 0x70 | (v1 & 14 | 0xD80) | v0_2 << 12 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v31 = v8;
            v3_2 = v15_1;
            v4_1 = v17_1;
            v5_2 = v22_1;
            v6_1 = v23;
            v7_1 = v24;
            v8_1 = v25;
            v9_1 = v26;
            v10_1 = v27;
            v11_2 = v30;
        }
        else {
            v8.skipToGroupEnd();
            v6_1 = arg40;
            v9_1 = arg43;
            v11_2 = arg45;
            v4_1 = v7;
            v31 = v8;
            v7_1 = arg41;
            v8_1 = v3;
            v3_2 = v5;
            v5_2 = v10;
            v10_1 = arg44;
        }

        ScopeUpdateScope v15_4 = v31.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new ChipKt$$ExternalSyntheticLambda5(arg35, arg36, v3_2, v4_1, v5_2, v6_1, v7_1, v8_1, v9_1, v10_1, v11_2, v12, arg48, v14));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith="<_subannotation>") public static final void ElevatedAssistChip(Function0 arg35, Function2 arg36, Modifier arg37, boolean arg38, Function2 arg39, Function2 arg40, Shape arg41, ChipColors arg42, ChipElevation arg43, ChipBorder arg44, MutableInteractionSource arg45, Composer arg46, int arg47, int arg48, int arg49) {
        MutableInteractionSource v11_2;
        ChipElevation v9_1;
        ChipColors v8_1;
        Shape v7_1;
        Function2 v6_1;
        Function2 v5_3;
        boolean v4_3;
        Modifier v3_2;
        Composer v31;
        ChipBorder v10_1;
        State v5_2;
        Function2 v22_1;
        int v11_1;
        MutableInteractionSource v30;
        ChipBorder v1_1;
        ChipElevation v26;
        Shape v24;
        Function2 v23;
        int v0_2;
        Companion v15_3;
        Object v4_1;
        ChipElevation v1_2;
        Companion v37;
        Shape v17_1;
        int v5_1;
        Companion v0_3;
        int v19;
        int v18;
        ChipColors v3;
        int v17;
        int v15;
        Function2 v10;
        int v9;
        boolean v7;
        int v6;
        Modifier v5;
        int v4;
        Function2 v13;
        int v1;
        int v12 = arg47;
        int v14 = arg49;
        Composer v8 = arg46.startRestartGroup(0xD2B9ECD5);
        ComposerKt.sourceInformation(v8, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)394@19326L5,389@19158L572:Chip.kt#uh7d8r");
        if((v14 & 1) != 0) {
            v1 = v12 | 6;
        }
        else {
            Function0 v11 = arg35;
            if((v12 & 6) == 0) {
                v1 = v8.changedInstance(v11) ? 4 : 2;
                v1 |= v12;
            }
            else {
                v1 = v12;
            }
        }

        if((v14 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg36;
        }
        else {
            v13 = arg36;
            if((v12 & 0x30) == 0) {
                v4 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        v4 = v14 & 4;
        if(v4 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v12 & 0x180) == 0) {
            v5 = arg37;
            v6 = v8.changed(v5) ? 0x100 : 0x80;
            v1 |= v6;
        }
        else {
        label_51:
            v5 = arg37;
        }

        v6 = v14 & 8;
        if(v6 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v12 & 0xC00) == 0) {
            v7 = arg38;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_66:
            v7 = arg38;
        }

        v9 = v14 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v12 & 0x6000) == 0) {
            v10 = arg39;
            v15 = v8.changedInstance(v10) ? 0x4000 : 0x2000;
            v1 |= v15;
        }
        else {
        label_81:
            v10 = arg39;
        }

        v15 = v14 & 0x20;
        int v16 = 0x30000;
        if(v15 != 0) {
            v1 |= v16;
        }
        else {
            Function2 v2 = arg40;
            if((v12 & v16) == 0) {
                v16 = v8.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v16;
            }
        }

        if((v12 & 0x180000) == 0) {
            Shape v0 = arg41;
            v17 = (v14 & 0x40) != 0 || !v8.changed(v0) ? 0x80000 : 0x100000;
            v1 |= v17;
        }

        if((v12 & 0xC00000) == 0) {
            if((v14 & 0x80) == 0) {
                v3 = arg42;
                if(v8.changed(v3)) {
                    v18 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v3 = arg42;
            label_122:
                v18 = 0x400000;
            }

            v1 |= v18;
        }
        else {
            v3 = arg42;
        }

        if((v12 & 0x6000000) == 0) {
            v18 = (v14 & 0x100) != 0 || !v8.changed(arg43) ? 0x2000000 : 0x4000000;
            v1 |= v18;
        }

        int v2_1 = v14 & 0x200;
        v18 = 0x30000000;
        if(v2_1 != 0) {
            v1 |= v18;
            goto label_157;
        }
        else if((v12 & v18) == 0) {
            v18 = v2_1;
            v19 = v8.changed(arg44) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_157:
            v18 = v2_1;
        }

        v2_1 = v14 & 0x400;
        if(v2_1 != 0) {
            v19 = v2_1;
            v2_1 = arg48 | 6;
        }
        else if((arg48 & 6) == 0) {
            v19 = v2_1;
            int v20 = v8.changed(arg45) ? 4 : 2;
            v2_1 = arg48 | v20;
        }
        else {
            v19 = v2_1;
            v2_1 = arg48;
        }

        int v46 = v1;
        boolean v20_1 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 || (v2_1 & 3) != 2 ? true : false;
        if(v8.shouldExecute(v0_1, v46 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "383@18866L5,384@18917L26,385@18996L29,387@19109L39");
            v1 = 0xFE3FFFFF;
            v17 = 0xFFC7FFFF;
            Function2 v21 = null;
            int v22 = v2_1;
            v2_1 = 6;
            if((v12 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    Modifier v0_4 = v5;
                }

                if(v6 != 0) {
                }
                else {
                    v20_1 = v7;
                }

                v23 = v9 != 0 ? v21 : v10;
                Function2 v15_2 = v15 != 0 ? v21 : arg40;
                if((v14 & 0x40) != 0) {
                    v5_1 = v46 & v17;
                    v17_1 = AssistChipDefaults.INSTANCE.getShape(v8, v2_1);
                }
                else {
                    v17_1 = arg41;
                    v5_1 = v46;
                }

                if((v14 & 0x80) != 0) {
                    v3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(v8, v2_1);
                    v5_1 &= v1;
                }

                ChipColors v24_1 = v3;
                int v25 = v5_1;
                if((v14 & 0x100) != 0) {
                    v37 = v0_3;
                    v0_2 = v22;
                    v11_1 = v2_1;
                    v1_2 = AssistChipDefaults.INSTANCE.elevatedAssistChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                    v2_1 = v25 & 0xF1FFFFFF;
                }
                else {
                    v37 = v0_3;
                    v11_1 = v2_1;
                    v0_2 = v22;
                    v1_2 = arg43;
                    v2_1 = v25;
                }

                ChipBorder v3_1 = v18 != 0 ? ((ChipBorder)v21) : arg44;
                if(v19 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v8, 200442940, "CC(remember):Chip.kt#9igjgp");
                    v4_1 = v8.rememberedValue();
                    if(v4_1 == Composer.Companion.getEmpty()) {
                        MutableInteractionSource v4_2 = InteractionSourceKt.MutableInteractionSource();
                        v8.updateRememberedValue(v4_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    v26 = v1_2;
                    v1_1 = v3_1;
                    Object v30_1 = v4_1;
                }
                else {
                    v30 = arg45;
                    v26 = v1_2;
                    v1_1 = v3_1;
                }

                v7 = v20_1;
                v22_1 = v23;
                v3 = v24_1;
                v23 = v15_2;
                v24 = v17_1;
                v15_3 = v37;
            }
            else {
                v8.skipToGroupEnd();
                v0_2 = (v14 & 0x40) != 0 ? v46 & v17 : v46;
                if((v14 & 0x80) != 0) {
                    v0_2 &= v1;
                }

                if((v14 & 0x100) != 0) {
                    v0_2 &= 0xF1FFFFFF;
                }

                v23 = arg40;
                v24 = arg41;
                v26 = arg43;
                v1_1 = arg44;
                v30 = arg45;
                v11_1 = v2_1;
                Modifier v15_1 = v5;
                v2_1 = v0_2;
                v0_2 = v22;
                v22_1 = v10;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xD2B9ECD5, v2_1, v0_2, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:389)");
            }

            TextStyle v19_1 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), v8, v11_1);
            v4_1 = v21;
            long v20_2 = v3.labelColor-vNxB06k$material3(v7);
            float v28 = AssistChipDefaults.INSTANCE.getHeight-D9Ej5fM();
            PaddingValues v29 = ChipKt.AssistChipPadding;
            if(v1_1 == null) {
                v8.startReplaceGroup(0x726629B7);
                v8.endReplaceGroup();
                v5_2 = ((State)v4_1);
            }
            else {
                v8.startReplaceGroup(200460170);
                ComposerKt.sourceInformation(v8, "403@19648L21");
                v5_2 = v1_1.borderStroke$material3(v7, v8, v2_1 >> 9 & 14 | v2_1 >> 24 & 0x70);
                v8.endReplaceGroup();
            }

            if(v5_2 != null) {
                v4_1 = v5_2.getValue();
            }

            v5_1 = v2_1 << 6;
            ChipColors v25_1 = v3;
            boolean v17_2 = v7;
            ChipKt.Chip-nkUnTEs(((Modifier)v15_3), arg35, v17_2, v13, v19_1, v20_2, v22_1, v23, v24, v25_1, v26, v4_1, v28, v29, v30, v8, v2_1 >> 6 & 14 | v2_1 << 3 & 0x70 | v2_1 >> 3 & 0x380 | v5_1 & 0x1C00 | 0x380000 & v5_1 | 0x1C00000 & v5_1 | 0xE000000 & v5_1 | v5_1 & 0x70000000, v2_1 >> 24 & 14 | 0xD80 | v0_2 << 12 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v10_1 = v1_1;
            v31 = v8;
            v3_2 = ((Modifier)v15_3);
            v4_3 = v17_2;
            v5_3 = v22_1;
            v6_1 = v23;
            v7_1 = v24;
            v8_1 = v25_1;
            v9_1 = v26;
            v11_2 = v30;
        }
        else {
            v8.skipToGroupEnd();
            v6_1 = arg40;
            v9_1 = arg43;
            v11_2 = arg45;
            v4_3 = v7;
            v31 = v8;
            v7_1 = arg41;
            v8_1 = v3;
            v3_2 = v5;
            v5_3 = v10;
            v10_1 = arg44;
        }

        ScopeUpdateScope v15_4 = v31.endRestartGroup();
        if(v15_4 != null) {
            v15_4.updateScope(new ChipKt$$ExternalSyntheticLambda12(arg35, arg36, v3_2, v4_3, v5_3, v6_1, v7_1, v8_1, v9_1, v10_1, v11_2, v12, arg48, v14));
        }
    }

    static final Unit ElevatedAssistChip$lambda$3(Function0 arg16, Function2 arg17, Modifier arg18, boolean arg19, Function2 arg20, Function2 arg21, Shape arg22, ChipColors arg23, ChipElevation arg24, BorderStroke arg25, MutableInteractionSource arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.ElevatedAssistChip(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedAssistChip$lambda$5(Function0 arg16, Function2 arg17, Modifier arg18, boolean arg19, Function2 arg20, Function2 arg21, Shape arg22, ChipColors arg23, ChipElevation arg24, ChipBorder arg25, MutableInteractionSource arg26, int arg27, int arg28, int arg29, Composer arg30, int arg31) {
        ChipKt.ElevatedAssistChip(arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg30, RecomposeScopeImplKt.updateChangedFlags(arg27 | 1), RecomposeScopeImplKt.updateChangedFlags(arg28), arg29);
        return Unit.INSTANCE;
    }

    public static final void ElevatedFilterChip(boolean arg36, Function0 arg37, Function2 arg38, Modifier arg39, boolean arg40, Function2 arg41, Function2 arg42, Shape arg43, SelectableChipColors arg44, SelectableChipElevation arg45, BorderStroke arg46, MutableInteractionSource arg47, Composer arg48, int arg49, int arg50, int arg51) {
        MutableInteractionSource v12_1;
        BorderStroke v11_2;
        SelectableChipElevation v10_1;
        SelectableChipColors v9_1;
        Shape v8_1;
        Function2 v7_1;
        Function2 v6_1;
        boolean v5_1;
        Modifier v4_1;
        Composer v32;
        boolean v19_1;
        int v3_1;
        SelectableChipColors v26;
        Shape v25;
        Function2 v24_1;
        int v11_1;
        MutableInteractionSource v31;
        BorderStroke v28;
        SelectableChipElevation v27;
        Function2 v22_1;
        int v0_1;
        Companion v17_3;
        SelectableChipElevation v1_1;
        Companion v39;
        Shape v20_1;
        Modifier v0_3;
        int v20;
        int v24;
        int v23;
        int v22;
        SelectableChipColors v6;
        int v21;
        Shape v5;
        int v19;
        Function2 v3;
        int v16;
        boolean v10;
        int v9;
        Modifier v7;
        Function2 v14;
        int v4;
        Function0 v12;
        int v1;
        int v13 = arg49;
        int v15 = arg51;
        Composer v8 = arg48.startRestartGroup(0x5B682CB6);
        ComposerKt.sourceInformation(v8, "C(ElevatedFilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)562@27590L5,556@27383L555:Chip.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v1 = v13 | 6;
        }
        else {
            boolean v11 = arg36;
            if((v13 & 6) == 0) {
                v1 = v8.changed(v11) ? 4 : 2;
                v1 |= v13;
            }
            else {
                v1 = v13;
            }
        }

        if((v15 & 2) != 0) {
            v1 |= 0x30;
            v12 = arg37;
        }
        else {
            v12 = arg37;
            if((v13 & 0x30) == 0) {
                v4 = v8.changedInstance(v12) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        if((v15 & 4) != 0) {
            v1 |= 0x180;
            v14 = arg38;
        }
        else {
            v14 = arg38;
            if((v13 & 0x180) == 0) {
                v4 = v8.changedInstance(v14) ? 0x100 : 0x80;
                v1 |= v4;
            }
        }

        v4 = v15 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_65;
        }
        else if((v13 & 0xC00) == 0) {
            v7 = arg39;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_65:
            v7 = arg39;
        }

        v9 = v15 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_80;
        }
        else if((v13 & 0x6000) == 0) {
            v10 = arg40;
            v16 = v8.changed(v10) ? 0x4000 : 0x2000;
            v1 |= v16;
        }
        else {
        label_80:
            v10 = arg40;
        }

        v16 = v15 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v1 |= v17;
        }
        else {
            Function2 v2 = arg41;
            if((v13 & v17) == 0) {
                v17 = v8.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v17;
            }
        }

        v17 = v15 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v1 |= v18;
            v3 = arg42;
        }
        else {
            v3 = arg42;
            if((v13 & v18) == 0) {
                v19 = v8.changedInstance(v3) ? 0x100000 : 0x80000;
                v1 |= v19;
            }
        }

        v19 = 0xC00000;
        if((v13 & v19) == 0) {
            if((v15 & 0x80) == 0) {
                v5 = arg43;
                if(v8.changed(v5)) {
                    v21 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v5 = arg43;
            label_122:
                v21 = 0x400000;
            }

            v1 |= v21;
        }
        else {
            v5 = arg43;
        }

        if((v13 & 0x6000000) == 0) {
            if((v15 & 0x100) == 0) {
                v6 = arg44;
                if(v8.changed(v6)) {
                    v22 = 0x4000000;
                }
                else {
                    goto label_137;
                }
            }
            else {
                v6 = arg44;
            label_137:
                v22 = 0x2000000;
            }

            v1 |= v22;
        }
        else {
            v6 = arg44;
        }

        if((v13 & 0x30000000) == 0) {
            v23 = (v15 & 0x200) != 0 || !v8.changed(arg45) ? 0x10000000 : 0x20000000;
            v1 |= v23;
        }

        int v2_1 = v15 & 0x400;
        if(v2_1 != 0) {
            v18 = arg50 | 6;
            v23 = v2_1;
        }
        else if((arg50 & 6) == 0) {
            v23 = v2_1;
            v18 = v8.changed(arg46) ? 4 : 2;
            v18 |= arg50;
        }
        else {
            v23 = v2_1;
            v18 = arg50;
        }

        v2_1 = v15 & 0x800;
        if(v2_1 != 0) {
            v18 |= 0x30;
            v24 = v2_1;
        }
        else if((arg50 & 0x30) == 0) {
            v24 = v2_1;
            v20 = v8.changed(arg47) ? 0x20 : 16;
            v18 |= v20;
        }
        else {
            v24 = v2_1;
        }

        v2_1 = v18;
        int v48 = v1;
        boolean v18_1 = true;
        boolean v0 = (v1 & 306783379) != 306783378 || (v2_1 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v0, v48 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "550@27103L5,551@27164L26,552@27253L29");
            v1 = 0xF1FFFFFF;
            v20 = 0xFE3FFFFF;
            v21 = v2_1;
            v2_1 = 6;
            if((v13 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v4 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v7;
                }

                if(v9 != 0) {
                }
                else {
                    v18_1 = v10;
                }

                Function2 v25_1 = null;
                Function2 v16_1 = v16 != 0 ? v25_1 : arg41;
                Function2 v17_2 = v17 != 0 ? v25_1 : v3;
                if((v15 & 0x80) != 0) {
                    v4 = v48 & v20;
                    v20_1 = FilterChipDefaults.INSTANCE.getShape(v8, v2_1);
                }
                else {
                    v4 = v48;
                    v20_1 = v5;
                }

                if((v15 & 0x100) != 0) {
                    v4 &= v1;
                    v26 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(v8, v2_1);
                }
                else {
                    v26 = v6;
                }

                int v27_1 = v4;
                if((v15 & 0x200) != 0) {
                    v39 = ((Companion)v0_3);
                    v0_1 = v21;
                    v11_1 = v2_1;
                    v1_1 = FilterChipDefaults.INSTANCE.elevatedFilterChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                    v2_1 = v27_1 & 0x8FFFFFFF;
                }
                else {
                    v39 = ((Companion)v0_3);
                    v11_1 = v2_1;
                    v0_1 = v21;
                    v1_1 = arg45;
                    v2_1 = v27_1;
                }

                BorderStroke v3_2 = v23 != 0 ? ((BorderStroke)v25_1) : arg46;
                if(v24 != 0) {
                    v27 = v1_1;
                    v28 = v3_2;
                    v22_1 = v16_1;
                    v24_1 = v17_2;
                    v1 = v19;
                    v31 = ((MutableInteractionSource)v25_1);
                    v3_1 = 0x5B682CB6;
                    v17_3 = v39;
                    v19_1 = v18_1;
                    v25 = v20_1;
                    goto label_340;
                }

                v31 = arg47;
                v27 = v1_1;
                v28 = v3_2;
                v22_1 = v16_1;
                v24_1 = v17_2;
                v1 = v19;
                v25 = v20_1;
                v3_1 = 0x5B682CB6;
                v17_3 = v39;
                v19_1 = v18_1;
            }
            else {
                v8.skipToGroupEnd();
                v0_1 = (v15 & 0x80) != 0 ? v48 & v20 : v48;
                if((v15 & 0x100) != 0) {
                    v0_1 &= v1;
                }

                if((v15 & 0x200) != 0) {
                    v0_1 &= 0x8FFFFFFF;
                }

                v22_1 = arg41;
                v27 = arg45;
                v28 = arg46;
                v31 = arg47;
                v11_1 = v2_1;
                v24_1 = v3;
                v25 = v5;
                v26 = v6;
                Modifier v17_1 = v7;
                v1 = v19;
                v3_1 = 0x5B682CB6;
                v2_1 = v0_1;
                v19_1 = v10;
                v0_1 = v21;
            }

        label_340:
            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(v3_1, v2_1, v0_1, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:556)");
            }

            v3_1 = v2_1 << 3;
            v4 = v2_1 << 6;
            int v33 = v1 | v2_1 & 14 | v2_1 >> 6 & 0x70 | v3_1 & 0x380 | v2_1 >> 3 & 0x1C00 | 0xE000 & v4 | v3_1 & 0x380000 | 0xE000000 & v4 | 0x70000000 & v4;
            v1 = v2_1 >> 24;
            ChipKt.SelectableChip-u0RnIRE(arg36, ((Modifier)v17_3), v12, v19_1, v14, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), v8, v11_1), v22_1, null, v24_1, v25, v26, v27, v28, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, v31, v8, v33, v1 & 0x70 | (v1 & 14 | 0x6C00) | v0_1 << 6 & 0x380 | v0_1 << 12 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v32 = v8;
            v4_1 = ((Modifier)v17_3);
            v5_1 = v19_1;
            v6_1 = v22_1;
            v7_1 = v24_1;
            v8_1 = v25;
            v9_1 = v26;
            v10_1 = v27;
            v11_2 = v28;
            v12_1 = v31;
        }
        else {
            v8.skipToGroupEnd();
            v11_2 = arg46;
            v12_1 = arg47;
            v9_1 = v6;
            v4_1 = v7;
            v32 = v8;
            v6_1 = arg41;
            v7_1 = v3;
            v8_1 = v5;
            v5_1 = v10;
            v10_1 = arg45;
        }

        ScopeUpdateScope v0_4 = v32.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new ChipKt$$ExternalSyntheticLambda7(arg36, arg37, arg38, v4_1, v5_1, v6_1, v7_1, v8_1, v9_1, v10_1, v11_2, v12_1, v13, arg50, v15));
        }
    }

    static final Unit ElevatedFilterChip$lambda$7(boolean arg17, Function0 arg18, Function2 arg19, Modifier arg20, boolean arg21, Function2 arg22, Function2 arg23, Shape arg24, SelectableChipColors arg25, SelectableChipElevation arg26, BorderStroke arg27, MutableInteractionSource arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        ChipKt.ElevatedFilterChip(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    public static final void ElevatedSuggestionChip(Function0 arg32, Function2 arg33, Modifier arg34, boolean arg35, Function2 arg36, Shape arg37, ChipColors arg38, ChipElevation arg39, BorderStroke arg40, MutableInteractionSource arg41, Composer arg42, int arg43, int arg44) {
        MutableInteractionSource v10_2;
        BorderStroke v9_2;
        ChipElevation v8_1;
        ChipColors v7_1;
        Shape v6_1;
        Function2 v5_1;
        boolean v4_1;
        Composer v29;
        boolean v15_2;
        int v3_1;
        ChipElevation v24;
        Shape v22_1;
        Function2 v20_1;
        Modifier v0_2;
        MutableInteractionSource v28;
        BorderStroke v25;
        ChipColors v23_1;
        Shape v19_1;
        Companion v0_3;
        int v19;
        int v18;
        int v16;
        ChipElevation v15_1;
        int v42;
        int v15;
        ChipColors v10_1;
        int v10;
        Shape v9_1;
        Function2 v7;
        int v6;
        boolean v5;
        int v4;
        Modifier v3;
        int v2;
        Function2 v13;
        Function0 v14;
        int v1;
        int v11 = arg43;
        int v12 = arg44;
        Composer v8 = arg42.startRestartGroup(0xCAAFFE07);
        ComposerKt.sourceInformation(v8, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)904@43788L5,899@43616L539:Chip.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v14 = arg32;
        }
        else {
            v14 = arg32;
            if((v11 & 6) == 0) {
                v1 = v8.changedInstance(v14) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg33;
        }
        else {
            v13 = arg33;
            if((v11 & 0x30) == 0) {
                v2 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v12 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v11 & 0x180) == 0) {
            v3 = arg34;
            v4 = v8.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_51:
            v3 = arg34;
        }

        v4 = v12 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v11 & 0xC00) == 0) {
            v5 = arg35;
            v6 = v8.changed(v5) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_66:
            v5 = arg35;
        }

        v6 = v12 & 16;
        if(v6 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v11 & 0x6000) == 0) {
            v7 = arg36;
            int v9 = v8.changedInstance(v7) ? 0x4000 : 0x2000;
            v1 |= v9;
        }
        else {
        label_81:
            v7 = arg36;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg37;
                if(v8.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v9_1 = arg37;
            label_93:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg37;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v10_1 = arg38;
                if(v8.changed(v10_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_108;
                }
            }
            else {
                v10_1 = arg38;
            label_108:
                v15 = 0x80000;
            }

            v1 |= v15;
        }
        else {
            v10_1 = arg38;
        }

        v15 = 0xC00000;
        if((v11 & v15) == 0) {
            v42 = v15;
            if((v12 & 0x80) == 0) {
                v15_1 = arg39;
                if(v8.changed(v15_1)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15_1 = arg39;
            label_124:
                v16 = 0x400000;
            }

            v1 |= v16;
        }
        else {
            v42 = v15;
            v15_1 = arg39;
        }

        int v0 = v12 & 0x100;
        int v17 = 0x6000000;
        if(v0 != 0) {
            v1 |= v17;
            goto label_145;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v8.changed(arg40) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }
        else {
        label_145:
            v17 = v2;
        }

        v2 = v12 & 0x200;
        v18 = 0x30000000;
        if(v2 != 0) {
            v1 |= v18;
            goto label_163;
        }
        else if((v11 & v18) == 0) {
            v18 = v2;
            v19 = v8.changed(arg41) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_163:
            v18 = v2;
        }

        int v20 = v0;
        v19 = v1;
        boolean v21 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 ? true : false;
        if(v8.shouldExecute(v0_1, v19 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "893@43340L5,894@43395L30,895@43482L33");
            int v22 = 0xFE3FFFFF;
            v1 = 0xFFC7FFFF;
            int v23 = 0xFFF8FFFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v17 != 0) {
                    v0_3 = Modifier.Companion;
                }
                else {
                    v0_2 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v21 = v5;
                }

                Function2 v17_1 = null;
                Function2 v24_1 = v6 != 0 ? v17_1 : v7;
                if((v12 & 0x20) != 0) {
                    v4 = v19 & v23;
                    v19_1 = SuggestionChipDefaults.INSTANCE.getShape(v8, v2);
                }
                else {
                    v4 = v19;
                    v19_1 = v9_1;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v1;
                    v23_1 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(v8, v2);
                }
                else {
                    v23_1 = v10_1;
                }

                int v25_1 = v4;
                if((v12 & 0x80) != 0) {
                    v25_1 &= v22;
                    v3_1 = v2;
                    v15_1 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                }
                else {
                    v3_1 = v2;
                }

                BorderStroke v1_1 = v20 != 0 ? ((BorderStroke)v17_1) : arg40;
                v10 = v25_1;
                v25 = v1_1;
                v1 = v10;
                v28 = v18 != 0 ? ((MutableInteractionSource)v17_1) : arg41;
                v22_1 = v19_1;
                v10_1 = v23_1;
                v20_1 = v24_1;
                v24 = v15_1;
                v15_2 = v21;
            }
            else {
                v8.skipToGroupEnd();
                if((v12 & 0x20) != 0) {
                    v19 &= v23;
                }

                if((v12 & 0x40) != 0) {
                    v19 &= v1;
                }

                if((v12 & 0x80) != 0) {
                    v19 &= v22;
                }

                v25 = arg40;
                v28 = arg41;
                v0_2 = v3;
                v20_1 = v7;
                v22_1 = v9_1;
                v24 = v15_1;
                v1 = v19;
                v3_1 = v2;
                v15_2 = v5;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xCAAFFE07, v1, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:899)");
            }

            TextStyle v17_2 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), v8, v3_1);
            v3_1 = v1 << 6;
            v2 = v1 >> 6 & 14 | v42 | v1 << 3 & 0x70 | v1 >> 3 & 0x380 | v3_1 & 0x1C00 | v3_1 & 0x380000;
            v3_1 = v1 << 9;
            int v30 = v2 | 0xE000000 & v3_1 | v3_1 & 0x70000000;
            v2 = v1 >> 21;
            v23_1 = v10_1;
            Function2 v16_1 = v13;
            Modifier v13_1 = ((Modifier)v0_3);
            ChipKt.Chip-nkUnTEs(v13_1, v14, v15_2, v16_1, v17_2, v10_1.labelColor-vNxB06k$material3(v15_2), v20_1, null, v22_1, v23_1, v24, v25, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, v28, v8, v30, v2 & 0x70 | (v2 & 14 | 0xD80) | v1 >> 15 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v29 = v8;
            v3 = v13_1;
            v4_1 = v15_2;
            v5_1 = v20_1;
            v6_1 = v22_1;
            v7_1 = v23_1;
            v8_1 = v24;
            v9_2 = v25;
            v10_2 = v28;
        }
        else {
            v8.skipToGroupEnd();
            v4_1 = v5;
            v5_1 = v7;
            v29 = v8;
            v6_1 = v9_1;
            v7_1 = v10_1;
            v8_1 = v15_1;
            v9_2 = arg40;
            v10_2 = arg41;
        }

        ScopeUpdateScope v13_2 = v29.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new ChipKt$$ExternalSyntheticLambda15(arg32, arg33, v3, v4_1, v5_1, v6_1, v7_1, v8_1, v9_2, v10_2, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith="<_subannotation>") public static final void ElevatedSuggestionChip(Function0 arg32, Function2 arg33, Modifier arg34, boolean arg35, Function2 arg36, Shape arg37, ChipColors arg38, ChipElevation arg39, ChipBorder arg40, MutableInteractionSource arg41, Composer arg42, int arg43, int arg44) {
        MutableInteractionSource v10_2;
        ChipElevation v8_1;
        ChipColors v7_1;
        Shape v6_1;
        Function2 v5_1;
        boolean v4_2;
        Composer v29;
        ChipBorder v9_2;
        Object v25_1;
        State v3_2;
        boolean v15_2;
        ChipElevation v24_1;
        int v3_1;
        State v4_1;
        Shape v22_1;
        Function2 v20_1;
        Modifier v0_2;
        MutableInteractionSource v28;
        ChipBorder v1_1;
        MutableInteractionSource v2_2;
        ChipColors v23_1;
        Shape v19_1;
        int v19;
        int v18;
        int v16;
        ChipElevation v15_1;
        int v42;
        int v15;
        ChipColors v10_1;
        int v10;
        Shape v9_1;
        Function2 v7;
        int v6;
        boolean v5;
        int v4;
        Modifier v3;
        int v2;
        Function2 v13;
        Function0 v14;
        int v1;
        int v11 = arg43;
        int v12 = arg44;
        Composer v8 = arg42.startRestartGroup(1306662363);
        ComposerKt.sourceInformation(v8, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)985@47676L5,980@47504L569:Chip.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v14 = arg32;
        }
        else {
            v14 = arg32;
            if((v11 & 6) == 0) {
                v1 = v8.changedInstance(v14) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg33;
        }
        else {
            v13 = arg33;
            if((v11 & 0x30) == 0) {
                v2 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v12 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v11 & 0x180) == 0) {
            v3 = arg34;
            v4 = v8.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_51:
            v3 = arg34;
        }

        v4 = v12 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v11 & 0xC00) == 0) {
            v5 = arg35;
            v6 = v8.changed(v5) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_66:
            v5 = arg35;
        }

        v6 = v12 & 16;
        if(v6 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v11 & 0x6000) == 0) {
            v7 = arg36;
            int v9 = v8.changedInstance(v7) ? 0x4000 : 0x2000;
            v1 |= v9;
        }
        else {
        label_81:
            v7 = arg36;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg37;
                if(v8.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v9_1 = arg37;
            label_93:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg37;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v10_1 = arg38;
                if(v8.changed(v10_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_108;
                }
            }
            else {
                v10_1 = arg38;
            label_108:
                v15 = 0x80000;
            }

            v1 |= v15;
        }
        else {
            v10_1 = arg38;
        }

        v15 = 0xC00000;
        if((v11 & v15) == 0) {
            v42 = v15;
            if((v12 & 0x80) == 0) {
                v15_1 = arg39;
                if(v8.changed(v15_1)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15_1 = arg39;
            label_124:
                v16 = 0x400000;
            }

            v1 |= v16;
        }
        else {
            v42 = v15;
            v15_1 = arg39;
        }

        int v0 = v12 & 0x100;
        int v17 = 0x6000000;
        if(v0 != 0) {
            v1 |= v17;
            goto label_145;
        }
        else if((v11 & v17) == 0) {
            v17 = v2;
            v18 = v8.changed(arg40) ? 0x4000000 : 0x2000000;
            v1 |= v18;
        }
        else {
        label_145:
            v17 = v2;
        }

        v2 = v12 & 0x200;
        v18 = 0x30000000;
        if(v2 != 0) {
            v1 |= v18;
            goto label_163;
        }
        else if((v11 & v18) == 0) {
            v18 = v2;
            v19 = v8.changed(arg41) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_163:
            v18 = v2;
        }

        int v20 = v0;
        v19 = v1;
        boolean v21 = true;
        boolean v0_1 = (v1 & 306783379) != 306783378 ? true : false;
        if(v8.shouldExecute(v0_1, v19 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "974@47196L5,975@47251L30,976@47338L33,978@47455L39");
            int v22 = 0xFE3FFFFF;
            v1 = 0xFFC7FFFF;
            int v23 = 0xFFF8FFFF;
            Function2 v24 = null;
            v2 = 6;
            if((v11 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v17 != 0) {
                    Companion v0_3 = Modifier.Companion;
                }
                else {
                    v0_2 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v21 = v5;
                }

                Function2 v17_1 = v6 != 0 ? v24 : v7;
                if((v12 & 0x20) != 0) {
                    v4 = v19 & v23;
                    v19_1 = SuggestionChipDefaults.INSTANCE.getShape(v8, v2);
                }
                else {
                    v4 = v19;
                    v19_1 = v9_1;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v1;
                    v23_1 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(v8, v2);
                }
                else {
                    v23_1 = v10_1;
                }

                int v25 = v4;
                if((v12 & 0x80) != 0) {
                    v25 &= v22;
                    v3_1 = v2;
                    v15_1 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                }
                else {
                    v3_1 = v2;
                }

                v1_1 = v20 != 0 ? ((ChipBorder)v24) : arg40;
                if(v18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v8, 1572109794, "CC(remember):Chip.kt#9igjgp");
                    Object v2_1 = v8.rememberedValue();
                    if(v2_1 == Composer.Companion.getEmpty()) {
                        v2_2 = InteractionSourceKt.MutableInteractionSource();
                        v8.updateRememberedValue(v2_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v8);
                    Object v28_1 = v2_2;
                }
                else {
                    v28 = arg41;
                }

                v20_1 = v17_1;
                v22_1 = v19_1;
                v10_1 = v23_1;
                v4_1 = ((State)v24);
                v2 = v25;
                v24_1 = v15_1;
                v15_2 = v21;
            }
            else {
                v8.skipToGroupEnd();
                if((v12 & 0x20) != 0) {
                    v19 &= v23;
                }

                if((v12 & 0x40) != 0) {
                    v19 &= v1;
                }

                if((v12 & 0x80) != 0) {
                    v19 &= v22;
                }

                v1_1 = arg40;
                v28 = arg41;
                v0_2 = v3;
                v20_1 = v7;
                v22_1 = v9_1;
                v4_1 = ((State)v24);
                v3_1 = v2;
                v24_1 = v15_1;
                v2 = v19;
                v15_2 = v5;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306662363, v2, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:980)");
            }

            TextStyle v17_2 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), v8, v3_1);
            long v18_1 = v10_1.labelColor-vNxB06k$material3(v15_2);
            float v26 = SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM();
            PaddingValues v27 = ChipKt.SuggestionChipPadding;
            if(v1_1 == null) {
                v8.startReplaceGroup(0x58E35931);
                v8.endReplaceGroup();
                v3_2 = v4_1;
            }
            else {
                v8.startReplaceGroup(0x5DB4C0D0);
                ComposerKt.sourceInformation(v8, "994@47991L21");
                v3_2 = v1_1.borderStroke$material3(v15_2, v8, v2 >> 9 & 14 | v2 >> 21 & 0x70);
                v8.endReplaceGroup();
            }

            if(v3_2 != null) {
                v25_1 = v3_2.getValue();
            }
            else {
                BorderStroke v25_2 = ((BorderStroke)v4_1);
            }

            v4 = v2 << 6;
            v3_1 = v2 >> 6 & 14 | v42 | v2 << 3 & 0x70 | v2 >> 3 & 0x380 | v4 & 0x1C00 | v4 & 0x380000;
            v4 = v2 << 9;
            v23_1 = v10_1;
            Function2 v16_1 = v13;
            Modifier v13_1 = v0_2;
            ChipKt.Chip-nkUnTEs(v13_1, v14, v15_2, v16_1, v17_2, v18_1, v20_1, null, v22_1, v23_1, v24_1, ((BorderStroke)v25_1), v26, v27, v28, v8, v3_1 | 0xE000000 & v4 | v4 & 0x70000000, v2 >> 21 & 14 | 0xD80 | v2 >> 15 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_2 = v1_1;
            v29 = v8;
            v3 = v13_1;
            v4_2 = v15_2;
            v5_1 = v20_1;
            v6_1 = v22_1;
            v7_1 = v23_1;
            v8_1 = v24_1;
            v10_2 = v28;
        }
        else {
            v8.skipToGroupEnd();
            v4_2 = v5;
            v5_1 = v7;
            v29 = v8;
            v6_1 = v9_1;
            v7_1 = v10_1;
            v8_1 = v15_1;
            v9_2 = arg40;
            v10_2 = arg41;
        }

        ScopeUpdateScope v13_2 = v29.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new ChipKt$$ExternalSyntheticLambda2(arg32, arg33, v3, v4_2, v5_1, v6_1, v7_1, v8_1, v9_2, v10_2, v11, v12));
        }
    }

    static final Unit ElevatedSuggestionChip$lambda$12(Function0 arg14, Function2 arg15, Modifier arg16, boolean arg17, Function2 arg18, Shape arg19, ChipColors arg20, ChipElevation arg21, BorderStroke arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ChipKt.ElevatedSuggestionChip(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit ElevatedSuggestionChip$lambda$14(Function0 arg14, Function2 arg15, Modifier arg16, boolean arg17, Function2 arg18, Shape arg19, ChipColors arg20, ChipElevation arg21, ChipBorder arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ChipKt.ElevatedSuggestionChip(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void FilterChip(boolean arg41, Function0 arg42, Function2 arg43, Modifier arg44, boolean arg45, Function2 arg46, Function2 arg47, Shape arg48, SelectableChipColors arg49, SelectableChipElevation arg50, BorderStroke arg51, MutableInteractionSource arg52, Composer arg53, int arg54, int arg55, int arg56) {
        MutableInteractionSource v12_1;
        BorderStroke v11_1;
        SelectableChipElevation v10_1;
        SelectableChipColors v9_1;
        Shape v8_1;
        Function2 v7_1;
        Function2 v6_1;
        boolean v5_1;
        Modifier v4_1;
        Composer v32;
        boolean v19_1;
        SelectableChipColors v26;
        Shape v25;
        Function2 v24;
        MutableInteractionSource v31;
        BorderStroke v28;
        SelectableChipElevation v27;
        Function2 v22;
        int v0_1;
        Companion v17_3;
        BorderStroke v3_1;
        SelectableChipElevation v1_1;
        int v39;
        Companion v44;
        SelectableChipColors v38;
        Shape v37;
        Companion v0_2;
        MutableInteractionSource v2_2;
        int v33;
        int v21;
        SelectableChipColors v6;
        int v20;
        Shape v5;
        int v19;
        Function2 v3;
        int v16;
        boolean v10;
        int v9;
        Modifier v7;
        Function2 v14;
        int v4;
        Function0 v12;
        boolean v11;
        int v1;
        int v13 = arg54;
        int v15 = arg56;
        Composer v8 = arg53.startRestartGroup(0xAD6B5AC0);
        ComposerKt.sourceInformation(v8, "C(FilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)480@23562L5,474@23355L555:Chip.kt#uh7d8r");
        if((v15 & 1) != 0) {
            v1 = v13 | 6;
            v11 = arg41;
        }
        else {
            v11 = arg41;
            if((v13 & 6) == 0) {
                v1 = v8.changed(v11) ? 4 : 2;
                v1 |= v13;
            }
            else {
                v1 = v13;
            }
        }

        if((v15 & 2) != 0) {
            v1 |= 0x30;
            v12 = arg42;
        }
        else {
            v12 = arg42;
            if((v13 & 0x30) == 0) {
                v4 = v8.changedInstance(v12) ? 0x20 : 16;
                v1 |= v4;
            }
        }

        if((v15 & 4) != 0) {
            v1 |= 0x180;
            v14 = arg43;
        }
        else {
            v14 = arg43;
            if((v13 & 0x180) == 0) {
                v4 = v8.changedInstance(v14) ? 0x100 : 0x80;
                v1 |= v4;
            }
        }

        v4 = v15 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_65;
        }
        else if((v13 & 0xC00) == 0) {
            v7 = arg44;
            v9 = v8.changed(v7) ? 0x800 : 0x400;
            v1 |= v9;
        }
        else {
        label_65:
            v7 = arg44;
        }

        v9 = v15 & 16;
        if(v9 != 0) {
            v1 |= 0x6000;
            goto label_80;
        }
        else if((v13 & 0x6000) == 0) {
            v10 = arg45;
            v16 = v8.changed(v10) ? 0x4000 : 0x2000;
            v1 |= v16;
        }
        else {
        label_80:
            v10 = arg45;
        }

        v16 = v15 & 0x20;
        int v17 = 0x30000;
        if(v16 != 0) {
            v1 |= v17;
        }
        else {
            Function2 v2 = arg46;
            if((v13 & v17) == 0) {
                v17 = v8.changedInstance(v2) ? 0x20000 : 0x10000;
                v1 |= v17;
            }
        }

        v17 = v15 & 0x40;
        int v18 = 0x180000;
        if(v17 != 0) {
            v1 |= v18;
            v3 = arg47;
        }
        else {
            v3 = arg47;
            if((v13 & v18) == 0) {
                v19 = v8.changedInstance(v3) ? 0x100000 : 0x80000;
                v1 |= v19;
            }
        }

        if((v13 & 0xC00000) == 0) {
            if((v15 & 0x80) == 0) {
                v5 = arg48;
                if(v8.changed(v5)) {
                    v20 = 0x800000;
                }
                else {
                    goto label_122;
                }
            }
            else {
                v5 = arg48;
            label_122:
                v20 = 0x400000;
            }

            v1 |= v20;
        }
        else {
            v5 = arg48;
        }

        if((v13 & 0x6000000) == 0) {
            if((v15 & 0x100) == 0) {
                v6 = arg49;
                if(v8.changed(v6)) {
                    v21 = 0x4000000;
                }
                else {
                    goto label_137;
                }
            }
            else {
                v6 = arg49;
            label_137:
                v21 = 0x2000000;
            }

            v1 |= v21;
        }
        else {
            v6 = arg49;
        }

        if((v13 & 0x30000000) == 0) {
            v21 = (v15 & 0x200) != 0 || !v8.changed(arg50) ? 0x10000000 : 0x20000000;
            v1 |= v21;
        }

        if((arg55 & 6) == 0) {
            v18 = (v15 & 0x400) != 0 || !v8.changed(arg51) ? 2 : 4;
            v18 |= arg55;
        }
        else {
            v18 = arg55;
        }

        int v2_1 = v15 & 0x800;
        if(v2_1 != 0) {
            v21 = v2_1;
            v33 = v18 | 0x30;
            v2_2 = arg52;
        }
        else {
            if((arg55 & 0x30) == 0) {
                v21 = v2_1;
                v2_2 = arg52;
                v19 = v8.changed(v2_2) ? 0x20 : 16;
                v18 |= v19;
            }
            else {
                v21 = v2_1;
                v2_2 = arg52;
            }

            v33 = v18;
        }

        int v53 = v1;
        boolean v0 = (v1 & 306783379) != 306783378 || (v33 & 19) != 18 ? true : false;
        if(v8.shouldExecute(v0, v53 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "468@23041L5,469@23102L18,470@23183L21,471@23253L35");
            v1 = 6;
            if((v13 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v4 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v7;
                }

                v4 = v17;
                boolean v17_2 = v9 != 0 ? true : v10;
                Function2 v34 = null;
                Function2 v35 = v16 != 0 ? v34 : arg46;
                Function2 v36 = v4 != 0 ? v34 : v3;
                if((v15 & 0x80) != 0) {
                    v4 = v53 & 0xFE3FFFFF;
                    v37 = FilterChipDefaults.INSTANCE.getShape(v8, v1);
                }
                else {
                    v4 = v53;
                    v37 = v5;
                }

                if((v15 & 0x100) != 0) {
                    v4 &= 0xF1FFFFFF;
                    v38 = FilterChipDefaults.INSTANCE.filterChipColors(v8, v1);
                }
                else {
                    v38 = v6;
                }

                v16 = v4;
                if((v15 & 0x200) != 0) {
                    v44 = v0_2;
                    v0_1 = v1;
                    v39 = v21;
                    v1_1 = FilterChipDefaults.INSTANCE.filterChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                    v2_1 = v16 & 0x8FFFFFFF;
                }
                else {
                    v44 = v0_2;
                    v0_1 = v1;
                    v39 = v21;
                    v1_1 = arg50;
                    v2_1 = v16;
                }

                if((v15 & 0x400) != 0) {
                    v3_1 = FilterChipDefaults.INSTANCE.filterChipBorder-_7El2pE(v17_2, v11, 0, 0, 0, 0, 0f, 0f, v8, v2_1 >> 12 & 14 | 0x6000000 | v2_1 << 3 & 0x70, 0xFC);
                    v33 &= -15;
                }
                else {
                    v3_1 = arg51;
                }

                if(v39 != 0) {
                    v27 = v1_1;
                    v28 = v3_1;
                    v19_1 = v17_2;
                    v1 = v33;
                    v31 = ((MutableInteractionSource)v34);
                }
                else {
                    v31 = arg52;
                    v27 = v1_1;
                    v28 = v3_1;
                    v19_1 = v17_2;
                    v1 = v33;
                }

                v22 = v35;
                v24 = v36;
                v25 = v37;
                v26 = v38;
                v17_3 = v44;
            }
            else {
                v8.skipToGroupEnd();
                v0_1 = (v15 & 0x80) != 0 ? v53 & 0xFE3FFFFF : v53;
                if((v15 & 0x100) != 0) {
                    v0_1 &= 0xF1FFFFFF;
                }

                if((v15 & 0x200) != 0) {
                    v0_1 &= 0x8FFFFFFF;
                }

                if((v15 & 0x400) != 0) {
                    v33 &= -15;
                }

                v22 = arg46;
                v27 = arg50;
                v28 = arg51;
                v31 = v2_2;
                v24 = v3;
                v25 = v5;
                v26 = v6;
                Modifier v17_1 = v7;
                v19_1 = v10;
                v2_1 = v0_1;
                v0_1 = v1;
                v1 = v33;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xAD6B5AC0, v2_1, v1, "androidx.compose.material3.FilterChip (Chip.kt:474)");
            }

            TextStyle v21_1 = TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), v8, v0_1);
            int v3_2 = v2_1 << 3;
            v4 = v2_1 << 6;
            v0_1 = v2_1 >> 24;
            ChipKt.SelectableChip-u0RnIRE(arg41, ((Modifier)v17_3), v12, v19_1, v14, v21_1, v22, null, v24, v25, v26, v27, v28, FilterChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.FilterChipPadding, v31, v8, v2_1 & 14 | 0xC00000 | v2_1 >> 6 & 0x70 | v3_2 & 0x380 | v2_1 >> 3 & 0x1C00 | 0xE000 & v4 | v3_2 & 0x380000 | 0xE000000 & v4 | 0x70000000 & v4, v0_1 & 0x70 | (v0_1 & 14 | 0x6C00) | v1 << 6 & 0x380 | v1 << 12 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v32 = v8;
            v4_1 = ((Modifier)v17_3);
            v5_1 = v19_1;
            v6_1 = v22;
            v7_1 = v24;
            v8_1 = v25;
            v9_1 = v26;
            v10_1 = v27;
            v11_1 = v28;
            v12_1 = v31;
        }
        else {
            v8.skipToGroupEnd();
            v11_1 = arg51;
            v12_1 = arg52;
            v9_1 = v6;
            v4_1 = v7;
            v32 = v8;
            v6_1 = arg46;
            v7_1 = v3;
            v8_1 = v5;
            v5_1 = v10;
            v10_1 = arg50;
        }

        ScopeUpdateScope v0_4 = v32.endRestartGroup();
        if(v0_4 != null) {
            v0_4.updateScope(new ChipKt$$ExternalSyntheticLambda0(arg41, arg42, arg43, v4_1, v5_1, v6_1, v7_1, v8_1, v9_1, v10_1, v11_1, v12_1, v13, arg55, v15));
        }
    }

    static final Unit FilterChip$lambda$6(boolean arg17, Function0 arg18, Function2 arg19, Modifier arg20, boolean arg21, Function2 arg22, Function2 arg23, Shape arg24, SelectableChipColors arg25, SelectableChipElevation arg26, BorderStroke arg27, MutableInteractionSource arg28, int arg29, int arg30, int arg31, Composer arg32, int arg33) {
        ChipKt.FilterChip(arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg32, RecomposeScopeImplKt.updateChangedFlags(arg29 | 1), RecomposeScopeImplKt.updateChangedFlags(arg30), arg31);
        return Unit.INSTANCE;
    }

    public static final void InputChip(boolean arg43, Function0 arg44, Function2 arg45, Modifier arg46, boolean arg47, Function2 arg48, Function2 arg49, Function2 arg50, Shape arg51, SelectableChipColors arg52, SelectableChipElevation arg53, BorderStroke arg54, MutableInteractionSource arg55, Composer arg56, int arg57, int arg58, int arg59) {
        MutableInteractionSource v13_1;
        BorderStroke v12_1;
        SelectableChipElevation v11_1;
        SelectableChipColors v10_1;
        Shape v9_1;
        Function2 v8_2;
        boolean v5_1;
        Modifier v4_4;
        Composer v32;
        boolean v8_1;
        Function2 v24_1;
        Function2 v22_1;
        MutableInteractionSource v31;
        BorderStroke v28;
        SelectableChipElevation v27;
        SelectableChipColors v26;
        Shape v25;
        boolean v19_1;
        Modifier v17_1;
        BorderStroke v4;
        SelectableChipElevation v2_1;
        int v41;
        Companion v46;
        SelectableChipColors v39;
        Shape v38;
        int v7_1;
        Companion v1_2;
        int v17;
        int v24;
        Function2 v10;
        int v22;
        Function2 v7;
        int v20;
        Function2 v6;
        int v18;
        int v16;
        int v11;
        Function0 v13;
        boolean v12;
        int v2;
        int v14 = arg57;
        int v15 = arg58;
        int v0 = arg59;
        Composer v9 = arg56.startRestartGroup(-1975409271);
        ComposerKt.sourceInformation(v9, "C(InputChip)N(selected,onClick,label,modifier,enabled,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,interactionSource)673@32653L5,667@32447L747:Chip.kt#uh7d8r");
        if((v0 & 1) != 0) {
            v2 = v14 | 6;
            v12 = arg43;
        }
        else {
            v12 = arg43;
            if((v14 & 6) == 0) {
                v2 = v9.changed(v12) ? 4 : 2;
                v2 |= v14;
            }
            else {
                v2 = v14;
            }
        }

        if((v0 & 2) != 0) {
            v2 |= 0x30;
            v13 = arg44;
        }
        else {
            v13 = arg44;
            if((v14 & 0x30) == 0) {
                int v5 = v9.changedInstance(v13) ? 0x20 : 16;
                v2 |= v5;
            }
        }

        if((v0 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v14 & 0x180) == 0) {
            v11 = v9.changedInstance(arg45) ? 0x100 : 0x80;
            v2 |= v11;
        }

        v11 = v0 & 8;
        if(v11 != 0) {
            v2 |= 0xC00;
        }
        else if((v14 & 0xC00) == 0) {
            v16 = v9.changed(arg46) ? 0x800 : 0x400;
            v2 |= v16;
        }

        v16 = v0 & 16;
        if(v16 != 0) {
            v2 |= 0x6000;
        }
        else if((v14 & 0x6000) == 0) {
            v18 = v9.changed(arg47) ? 0x4000 : 0x2000;
            v2 |= v18;
        }

        v18 = v0 & 0x20;
        int v19 = 0x30000;
        if(v18 != 0) {
            v2 |= v19;
            v6 = arg48;
        }
        else {
            v6 = arg48;
            if((v14 & v19) == 0) {
                v20 = v9.changedInstance(v6) ? 0x20000 : 0x10000;
                v2 |= v20;
            }
        }

        v20 = v0 & 0x40;
        int v21 = 0x180000;
        if(v20 != 0) {
            v2 |= v21;
            v7 = arg49;
        }
        else {
            v7 = arg49;
            if((v14 & v21) == 0) {
                v22 = v9.changedInstance(v7) ? 0x100000 : 0x80000;
                v2 |= v22;
            }
        }

        int v8 = v0 & 0x80;
        int v23 = 0xC00000;
        if(v8 != 0) {
            v2 |= v23;
            v10 = arg50;
        }
        else {
            v10 = arg50;
            if((v14 & v23) == 0) {
                v24 = v9.changedInstance(v10) ? 0x800000 : 0x400000;
                v2 |= v24;
            }
        }

        if((v14 & 0x6000000) == 0) {
            v24 = (v0 & 0x100) != 0 || !v9.changed(arg51) ? 0x2000000 : 0x4000000;
            v2 |= v24;
        }

        if((v14 & 0x30000000) == 0) {
            v24 = (v0 & 0x200) != 0 || !v9.changed(arg52) ? 0x10000000 : 0x20000000;
            v2 |= v24;
        }

        if((v15 & 6) == 0) {
            v17 = (v0 & 0x400) != 0 || !v9.changed(arg53) ? 2 : 4;
            v17 |= v15;
        }
        else {
            v17 = v15;
        }

        if((v15 & 0x30) == 0) {
            v19 = (v0 & 0x800) != 0 || !v9.changed(arg54) ? 16 : 0x20;
            v17 |= v19;
        }

        int v1 = v17;
        int v3 = v0 & 0x1000;
        if(v3 != 0) {
            v19 = v3;
            v3 = v1 | 0x180;
        }
        else {
            v17 = v1;
            if((v15 & 0x180) == 0) {
                v22 = v9.changed(arg55) ? 0x100 : 0x80;
                v17 |= v22;
            }

            v19 = v3;
            v3 = v17;
        }

        int v56 = v2;
        boolean v1_1 = (v2 & 306783379) != 306783378 || (v3 & 0x93) != 0x92 ? true : false;
        if(v9.shouldExecute(v1_1, v56 & 1)) {
            v9.startDefaults();
            ComposerKt.sourceInformation(v9, "640@31314L5,641@31374L17,642@31453L20,643@31521L34");
            ComposableLambda v34 = null;
            v2 = 6;
            if((v14 & 1) == 0 || (v9.getDefaultsInvalid())) {
                if(v11 != 0) {
                    v1_2 = Modifier.Companion;
                }
                else {
                    Modifier v1_3 = arg46;
                }

                boolean v17_2 = v16 != 0 ? true : arg47;
                Function2 v35 = v18 != 0 ? ((Function2)v34) : v6;
                Function2 v36 = v20 != 0 ? ((Function2)v34) : v7;
                Function2 v37 = v8 != 0 ? ((Function2)v34) : v10;
                if((v0 & 0x100) != 0) {
                    v7_1 = v56 & 0xF1FFFFFF;
                    v38 = InputChipDefaults.INSTANCE.getShape(v9, v2);
                }
                else {
                    v38 = arg51;
                    v7_1 = v56;
                }

                if((v0 & 0x200) != 0) {
                    v7_1 &= 0x8FFFFFFF;
                    v39 = InputChipDefaults.INSTANCE.inputChipColors(v9, v2);
                }
                else {
                    v39 = arg52;
                }

                int v40 = v7_1;
                if((v0 & 0x400) != 0) {
                    v46 = v1_2;
                    v1 = v2;
                    v41 = v19;
                    v2_1 = InputChipDefaults.INSTANCE.inputChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v9, 0x180000, 0x3F);
                    v3 &= -15;
                }
                else {
                    v46 = v1_2;
                    v1 = v2;
                    v41 = v19;
                    v2_1 = arg53;
                }

                if((v0 & 0x800) != 0) {
                    v4 = InputChipDefaults.INSTANCE.inputChipBorder-_7El2pE(v17_2, v12, 0, 0, 0, 0, 0f, 0f, v9, v40 >> 12 & 14 | 0x6000000 | v40 << 3 & 0x70, 0xFC);
                    v3 &= 0xFFFFFF8F;
                }
                else {
                    v4 = arg54;
                }

                if(v41 != 0) {
                    v27 = v2_1;
                    v28 = v4;
                    v19_1 = v17_2;
                    v31 = ((MutableInteractionSource)v34);
                }
                else {
                    v31 = arg55;
                    v27 = v2_1;
                    v28 = v4;
                    v19_1 = v17_2;
                }

                v22_1 = v35;
                v7 = v36;
                v24_1 = v37;
                v25 = v38;
                v26 = v39;
                v2 = v40;
                Companion v17_3 = v46;
            }
            else {
                v9.skipToGroupEnd();
                v1 = (v0 & 0x100) != 0 ? v56 & 0xF1FFFFFF : v56;
                if((v0 & 0x200) != 0) {
                    v1 &= 0x8FFFFFFF;
                }

                if((v0 & 0x400) != 0) {
                    v3 &= -15;
                }

                if((v0 & 0x800) != 0) {
                    v3 &= 0xFFFFFF8F;
                }

                v17 = v2;
                v2 = v1;
                v1 = v17;
                v17_1 = arg46;
                v19_1 = arg47;
                v25 = arg51;
                v26 = arg52;
                v27 = arg53;
                v28 = arg54;
                v31 = arg55;
                v22_1 = v6;
                v24_1 = v10;
            }

            v9.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1975409271, v2, v3, "androidx.compose.material3.InputChip (Chip.kt:645)");
            }

            if(v7 != null) {
                v9.startReplaceGroup(0xD6BE8EB);
                ComposerKt.sourceInformation(v9, "651@31963L5,653@32016L420");
                float v4_1 = v19_1 ? 1f : InputChipTokens.INSTANCE.getDisabledAvatarOpacity();
                v8_1 = true;
                v34 = ComposableLambdaKt.rememberComposableLambda(0xDDFF96B9, true, new ChipKt$InputChip$1(v4_1, ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), v9, v1), v7), v9, 54);
                v9.endReplaceGroup();
            }
            else {
                v8_1 = true;
                v9.startReplaceGroup(0xD7507D9);
                v9.endReplaceGroup();
            }

            ComposableLambda v23_1 = v34;
            TextStyle v21_1 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), v9, v1);
            float v29 = InputChipDefaults.INSTANCE.getHeight-D9Ej5fM();
            boolean v4_2 = v23_1 != null ? v8_1 : false;
            v1_1 = v22_1 != null ? v8_1 : false;
            if(v24_1 != null) {
            }
            else {
                v8_1 = false;
            }

            PaddingValues v30 = ChipKt.inputChipPadding(v4_2, v1_1, v8_1);
            int v4_3 = v2 << 3;
            int v33 = v2 & 14 | v2 >> 6 & 0x70 | v4_3 & 0x380 | v2 >> 3 & 0x1C00 | v2 << 6 & 0xE000 | 0x380000 & v4_3 | 0xE000000 & v4_3 | v4_3 & 0x70000000;
            v1 = v2 >> 27 & 14 | 0xC00;
            v2 = v3 << 3;
            ChipKt.SelectableChip-u0RnIRE(arg43, v17_1, v13, v19_1, arg45, v21_1, v22_1, ((Function2)v23_1), v24_1, v25, v26, v27, v28, v29, v30, v31, v9, v33, v1 | v2 & 0x70 | v2 & 0x380 | v3 << 9 & 0x70000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v32 = v9;
            v4_4 = v17_1;
            v5_1 = v19_1;
            v6 = v22_1;
            v8_2 = v24_1;
            v9_1 = v25;
            v10_1 = v26;
            v11_1 = v27;
            v12_1 = v28;
            v13_1 = v31;
        }
        else {
            v9.skipToGroupEnd();
            v4_4 = arg46;
            v5_1 = arg47;
            v11_1 = arg53;
            v12_1 = arg54;
            v13_1 = arg55;
            v32 = v9;
            v8_2 = v10;
            v9_1 = arg51;
            v10_1 = arg52;
        }

        ScopeUpdateScope v1_4 = v32.endRestartGroup();
        if(v1_4 != null) {
            v1_4.updateScope(new ChipKt$$ExternalSyntheticLambda11(arg43, arg44, arg45, v4_4, v5_1, v6, v7, v8_2, v9_1, v10_1, v11_1, v12_1, v13_1, v14, v15, arg59));
        }
    }

    static final Unit InputChip$lambda$8(boolean arg18, Function0 arg19, Function2 arg20, Modifier arg21, boolean arg22, Function2 arg23, Function2 arg24, Function2 arg25, Shape arg26, SelectableChipColors arg27, SelectableChipElevation arg28, BorderStroke arg29, MutableInteractionSource arg30, int arg31, int arg32, int arg33, Composer arg34, int arg35) {
        ChipKt.InputChip(arg18, arg19, arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg34, RecomposeScopeImplKt.updateChangedFlags(arg31 | 1), RecomposeScopeImplKt.updateChangedFlags(arg32), arg33);
        return Unit.INSTANCE;
    }

    private static final void SelectableChip-u0RnIRE(boolean arg31, Modifier arg32, Function0 arg33, boolean arg34, Function2 arg35, TextStyle arg36, Function2 arg37, Function2 arg38, Function2 arg39, Shape arg40, SelectableChipColors arg41, SelectableChipElevation arg42, BorderStroke arg43, float arg44, PaddingValues arg45, MutableInteractionSource arg46, Composer arg47, int arg48, int arg49) {
        Composer v14_2;
        State v3_5;
        ChipKt$$ExternalSyntheticLambda3 v3_4;
        MutableInteractionSource v16_2;
        int v23;
        int v29;
        int v26;
        int v22;
        int v18;
        int v5;
        boolean v0 = arg31;
        Modifier v11 = arg32;
        boolean v2 = arg34;
        SelectableChipColors v1 = arg41;
        SelectableChipElevation v12 = arg42;
        MutableInteractionSource v13 = arg46;
        int v14 = arg48;
        int v15 = arg49;
        Composer v4 = arg47.startRestartGroup(0x6A811700);
        ComposerKt.sourceInformation(v4, "C(SelectableChip)N(selected,modifier,onClick,enabled,label,labelTextStyle,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)2009@98774L24,2016@99083L670,2006@98671L1082:Chip.kt#uh7d8r");
        if((v14 & 6) == 0) {
            v5 = v4.changed(v0) ? 4 : 2;
            v5 |= v14;
        }
        else {
            v5 = v14;
        }

        if((v14 & 0x30) == 0) {
            int v8 = v4.changed(v11) ? 0x20 : 16;
            v5 |= v8;
        }

        int v16 = 0x100;
        int v17 = 0x80;
        if((v14 & 0x180) == 0) {
            v18 = v4.changedInstance(arg33) ? v16 : v17;
            v5 |= v18;
        }

        v18 = 0x800;
        int v19 = 0x400;
        if((v14 & 0xC00) == 0) {
            int v6 = v4.changed(v2) ? v18 : v19;
            v5 |= v6;
        }

        int v20 = 0x4000;
        int v21 = 0x2000;
        if((v14 & 0x6000) == 0) {
            v22 = v4.changedInstance(arg35) ? v20 : v21;
            v5 |= v22;
        }

        v22 = 0x30000;
        int v24 = 0x20000;
        int v25 = 0x10000;
        TextStyle v7 = arg36;
        if((v14 & v22) == 0) {
            v26 = v4.changed(v7) ? v24 : v25;
            v5 |= v26;
        }

        Function2 v9 = arg37;
        if((v14 & 0x180000) == 0) {
            int v27 = v4.changedInstance(v9) ? 0x100000 : 0x80000;
            v5 |= v27;
        }

        Function2 v10 = arg38;
        if((v14 & 0xC00000) == 0) {
            int v28 = v4.changedInstance(v10) ? 0x800000 : 0x400000;
            v5 |= v28;
        }

        Function2 v3 = arg39;
        if((v14 & 0x6000000) == 0) {
            v29 = v4.changedInstance(v3) ? 0x4000000 : 0x2000000;
            v5 |= v29;
        }

        v29 = v14 & 0x30000000;
        Shape v14_1 = arg40;
        if(v29 == 0) {
            v29 = v4.changed(v14_1) ? 0x20000000 : 0x10000000;
            v5 |= v29;
        }

        if((v15 & 6) == 0) {
            v23 = v4.changed(v1) ? 4 : 2;
            v23 |= v15;
        }
        else {
            v23 = v15;
        }

        if((v15 & 0x30) == 0) {
            v26 = v4.changed(v12) ? 0x20 : 16;
            v23 |= v26;
        }

        if((v15 & 0x180) == 0) {
            if(v4.changed(arg43)) {
            }
            else {
                v16 = v17;
            }

            v23 |= v16;
        }

        if((v15 & 0xC00) == 0) {
            if(v4.changed(arg44)) {
            }
            else {
                v18 = v19;
            }

            v23 |= v18;
        }

        if((v15 & 0x6000) == 0) {
            if(v4.changed(arg45)) {
            }
            else {
                v20 = v21;
            }

            v23 |= v20;
        }

        if((v15 & v22) == 0) {
            if(v4.changed(v13)) {
            }
            else {
                v24 = v25;
            }

            v23 |= v24;
        }

        int v13_1 = v23;
        boolean v3_1 = (v5 & 306783379) != 306783378 || (74899 & v13_1) != 74898 ? true : false;
        if(v4.shouldExecute(v3_1, v5 & 1)) {
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0x6A811700, v5, v13_1, "androidx.compose.material3.SelectableChip (Chip.kt:2003)");
            }

            String v3_2 = "CC(remember):Chip.kt#9igjgp";
            if(arg46 == null) {
                v4.startReplaceGroup(0x45D2E3B);
                ComposerKt.sourceInformation(v4, "2005@98627L39");
                ComposerKt.sourceInformationMarkerStart(v4, -828922201, v3_2);
                Object v6_1 = v4.rememberedValue();
                if(v6_1 == Composer.Companion.getEmpty()) {
                    MutableInteractionSource v6_2 = InteractionSourceKt.MutableInteractionSource();
                    v4.updateRememberedValue(v6_2);
                }

                ComposerKt.sourceInformationMarkerEnd(v4);
                v4.endReplaceGroup();
                Object v16_1 = v6_1;
            }
            else {
                v4.startReplaceGroup(0xCE97A41C);
                v4.endReplaceGroup();
                v16_2 = arg46;
            }

            ComposerKt.sourceInformationMarkerStart(v4, 0xCE97B8F8, v3_2);
            Object v3_3 = v4.rememberedValue();
            if(v3_3 == Composer.Companion.getEmpty()) {
                v3_4 = new ChipKt$$ExternalSyntheticLambda3();
                v4.updateRememberedValue(v3_4);
            }

            ComposerKt.sourceInformationMarkerEnd(v4);
            int v47 = v5;
            Modifier v17_1 = SemanticsModifierKt.semantics$default(v11, false, ((Function1)v3_4), 1, null);
            long v18_1 = v1.containerColor-WaAFU9c$material3(v2, v0);
            if(v12 == null) {
                v4.startReplaceGroup(0x461FEF6);
                v4.endReplaceGroup();
                v3_5 = null;
            }
            else {
                v4.startReplaceGroup(-828912021);
                ComposerKt.sourceInformation(v4, "2013@98945L43");
                v3_5 = v12.shadowElevation$material3(v2, v16_2, v4, v47 >> 9 & 14 | v13_1 << 3 & 0x380);
                v4.endReplaceGroup();
            }

            float v3_6 = v3_5 != null ? v3_5.getValue().unbox-impl() : Dp.constructor-impl(0f);
            v14_2 = v4;
            SurfaceKt.Surface-d85dljk(arg31, arg33, v17_1, arg34, arg40, v18_1, 0, 0f, v3_6, arg43, v16_2, ComposableLambdaKt.rememberComposableLambda(-990050154, true, new ChipKt$SelectableChip$2(v1, v2, arg31, arg35, arg36, v9, v10, arg39, arg44, arg45), v14_2, 54), v14_2, v47 & 14 | v47 >> 3 & 0x70 | v47 & 0x1C00 | v47 >> 15 & 0xE000 | v13_1 << 21 & 0x70000000, 0x30, 0xC0);
            if(!ComposerKt.isTraceInProgress()) {
                goto label_310;
            }

            ComposerKt.traceEventEnd();
        }
        else {
            v14_2 = v4;
            v14_2.skipToGroupEnd();
        }

    label_310:
        ScopeUpdateScope v0_1 = v14_2.endRestartGroup();
        if(v0_1 != null) {
            v0_1.updateScope(new ChipKt$$ExternalSyntheticLambda4(arg31, arg32, arg33, arg34, arg35, arg36, arg37, arg38, arg39, arg40, arg41, arg42, arg43, arg44, arg45, arg46, arg48, arg49));
        }
    }

    static final Unit SelectableChip_u0RnIRE$lambda$21$lambda$20(SemanticsPropertyReceiver arg1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(arg1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit SelectableChip_u0RnIRE$lambda$22(boolean arg20, Modifier arg21, Function0 arg22, boolean arg23, Function2 arg24, TextStyle arg25, Function2 arg26, Function2 arg27, Function2 arg28, Shape arg29, SelectableChipColors arg30, SelectableChipElevation arg31, BorderStroke arg32, float arg33, PaddingValues arg34, MutableInteractionSource arg35, int arg36, int arg37, Composer arg38, int arg39) {
        ChipKt.SelectableChip-u0RnIRE(arg20, arg21, arg22, arg23, arg24, arg25, arg26, arg27, arg28, arg29, arg30, arg31, arg32, arg33, arg34, arg35, arg38, RecomposeScopeImplKt.updateChangedFlags(arg36 | 1), RecomposeScopeImplKt.updateChangedFlags(arg37));
        return Unit.INSTANCE;
    }

    public static final void SuggestionChip(Function0 arg32, Function2 arg33, Modifier arg34, boolean arg35, Function2 arg36, Shape arg37, ChipColors arg38, ChipElevation arg39, BorderStroke arg40, MutableInteractionSource arg41, Composer arg42, int arg43, int arg44) {
        MutableInteractionSource v10_2;
        BorderStroke v9_2;
        ChipElevation v8_1;
        ChipColors v7_1;
        Shape v6_1;
        Function2 v5_1;
        boolean v4_1;
        Composer v29;
        boolean v15_2;
        ChipElevation v24;
        Shape v22_1;
        Function2 v20_1;
        int v0_1;
        MutableInteractionSource v28;
        BorderStroke v25;
        Companion v3_2;
        BorderStroke v1_1;
        boolean v2_1;
        Companion v34;
        int v3_1;
        ChipColors v23_1;
        Shape v19_1;
        Modifier v0_3;
        int v19;
        int v17;
        int v16;
        ChipElevation v15_1;
        int v42;
        int v15;
        ChipColors v10_1;
        int v10;
        Shape v9_1;
        Function2 v7;
        int v6;
        boolean v5;
        int v4;
        Modifier v3;
        int v2;
        Function2 v13;
        Function0 v14;
        int v1;
        int v11 = arg43;
        int v12 = arg44;
        Composer v8 = arg42.startRestartGroup(0xF0F71311);
        ComposerKt.sourceInformation(v8, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)751@36361L5,746@36189L539:Chip.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v14 = arg32;
        }
        else {
            v14 = arg32;
            if((v11 & 6) == 0) {
                v1 = v8.changedInstance(v14) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg33;
        }
        else {
            v13 = arg33;
            if((v11 & 0x30) == 0) {
                v2 = v8.changedInstance(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v12 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v11 & 0x180) == 0) {
            v3 = arg34;
            v4 = v8.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_51:
            v3 = arg34;
        }

        v4 = v12 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v11 & 0xC00) == 0) {
            v5 = arg35;
            v6 = v8.changed(v5) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_66:
            v5 = arg35;
        }

        v6 = v12 & 16;
        if(v6 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v11 & 0x6000) == 0) {
            v7 = arg36;
            int v9 = v8.changedInstance(v7) ? 0x4000 : 0x2000;
            v1 |= v9;
        }
        else {
        label_81:
            v7 = arg36;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg37;
                if(v8.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v9_1 = arg37;
            label_93:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg37;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v10_1 = arg38;
                if(v8.changed(v10_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_108;
                }
            }
            else {
                v10_1 = arg38;
            label_108:
                v15 = 0x80000;
            }

            v1 |= v15;
        }
        else {
            v10_1 = arg38;
        }

        v15 = 0xC00000;
        if((v11 & v15) == 0) {
            v42 = v15;
            if((v12 & 0x80) == 0) {
                v15_1 = arg39;
                if(v8.changed(v15_1)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15_1 = arg39;
            label_124:
                v16 = 0x400000;
            }

            v1 |= v16;
        }
        else {
            v42 = v15;
            v15_1 = arg39;
        }

        if((v11 & 0x6000000) == 0) {
            v17 = (v12 & 0x100) != 0 || !v8.changed(arg40) ? 0x2000000 : 0x4000000;
            v1 |= v17;
        }

        v17 = v2;
        v2 = v12 & 0x200;
        int v18 = 0x30000000;
        if(v2 != 0) {
            v1 |= v18;
            goto label_161;
        }
        else if((v11 & v18) == 0) {
            v18 = v2;
            v19 = v8.changed(arg41) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_161:
            v18 = v2;
        }

        v19 = v1;
        boolean v20 = true;
        boolean v0 = (v1 & 306783379) != 306783378 ? true : false;
        if(v8.shouldExecute(v0, v19 & 1)) {
            v8.startDefaults();
            ComposerKt.sourceInformation(v8, "740@35881L5,741@35936L22,742@36015L25,743@36093L29");
            int v21 = 0xF1FFFFFF;
            int v22 = 0xFE3FFFFF;
            v1 = 0xFFC7FFFF;
            int v23 = 0xFFF8FFFF;
            v2 = 6;
            if((v11 & 1) == 0 || (v8.getDefaultsInvalid())) {
                if(v17 != 0) {
                    Companion v0_2 = Modifier.Companion;
                }
                else {
                    v0_3 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v20 = v5;
                }

                Function2 v17_1 = null;
                Function2 v24_1 = v6 != 0 ? v17_1 : v7;
                if((v12 & 0x20) != 0) {
                    v4 = v19 & v23;
                    v19_1 = SuggestionChipDefaults.INSTANCE.getShape(v8, v2);
                }
                else {
                    v4 = v19;
                    v19_1 = v9_1;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v1;
                    v23_1 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(v8, v2);
                }
                else {
                    v23_1 = v10_1;
                }

                int v25_1 = v4;
                if((v12 & 0x80) != 0) {
                    v25_1 &= v22;
                    v3_1 = v2;
                    v15_1 = SuggestionChipDefaults.INSTANCE.suggestionChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v8, 0x180000, 0x3F);
                }
                else {
                    v3_1 = v2;
                }

                if((v12 & 0x100) != 0) {
                    v34 = ((Companion)v0_3);
                    v0_1 = v3_1;
                    v2_1 = v20;
                    v1_1 = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-h1eT-Ww(v2_1, 0, 0, 0f, v8, v25_1 >> 9 & 14 | 0x6000, 14);
                    v3_1 = v25_1 & v21;
                }
                else {
                    v34 = ((Companion)v0_3);
                    v0_1 = v3_1;
                    v2_1 = v20;
                    v1_1 = arg40;
                    v3_1 = v25_1;
                }

                if(v18 != 0) {
                    v25 = v1_1;
                    v1 = v3_1;
                    v28 = ((MutableInteractionSource)v17_1);
                }
                else {
                    v28 = arg41;
                    v25 = v1_1;
                    v1 = v3_1;
                }

                v22_1 = v19_1;
                v10_1 = v23_1;
                v20_1 = v24_1;
                v3_2 = v34;
                v24 = v15_1;
                v15_2 = v2_1;
            }
            else {
                v8.skipToGroupEnd();
                if((v12 & 0x20) != 0) {
                    v19 &= v23;
                }

                if((v12 & 0x40) != 0) {
                    v19 &= v1;
                }

                if((v12 & 0x80) != 0) {
                    v19 &= v22;
                }

                if((v12 & 0x100) != 0) {
                    v19 &= v21;
                }

                v25 = arg40;
                v28 = arg41;
                v0_1 = v2;
                v20_1 = v7;
                v22_1 = v9_1;
                v24 = v15_1;
                v1 = v19;
                v15_2 = v5;
            }

            v8.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(0xF0F71311, v1, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
            }

            TextStyle v17_2 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), v8, v0_1);
            v2 = v1 << 6;
            v0_1 = v1 >> 6 & 14 | v42 | v1 << 3 & 0x70 | v1 >> 3 & 0x380 | v2 & 0x1C00 | v2 & 0x380000;
            v2 = v1 << 9;
            int v30 = v0_1 | 0xE000000 & v2 | v2 & 0x70000000;
            v0_1 = v1 >> 21;
            v23_1 = v10_1;
            Function2 v16_1 = v13;
            Modifier v13_1 = ((Modifier)v3_2);
            ChipKt.Chip-nkUnTEs(v13_1, v14, v15_2, v16_1, v17_2, v10_1.labelColor-vNxB06k$material3(v15_2), v20_1, null, v22_1, v23_1, v24, v25, SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, v28, v8, v30, v0_1 & 0x70 | (v0_1 & 14 | 0xD80) | v1 >> 15 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v29 = v8;
            v3 = v13_1;
            v4_1 = v15_2;
            v5_1 = v20_1;
            v6_1 = v22_1;
            v7_1 = v23_1;
            v8_1 = v24;
            v9_2 = v25;
            v10_2 = v28;
        }
        else {
            v8.skipToGroupEnd();
            v4_1 = v5;
            v5_1 = v7;
            v29 = v8;
            v6_1 = v9_1;
            v7_1 = v10_1;
            v8_1 = v15_1;
            v9_2 = arg40;
            v10_2 = arg41;
        }

        ScopeUpdateScope v13_2 = v29.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new ChipKt$$ExternalSyntheticLambda10(arg32, arg33, v3, v4_1, v5_1, v6_1, v7_1, v8_1, v9_2, v10_2, v11, v12));
        }
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith="<_subannotation>") public static final void SuggestionChip(Function0 arg32, Function2 arg33, Modifier arg34, boolean arg35, Function2 arg36, Shape arg37, ChipColors arg38, ChipElevation arg39, ChipBorder arg40, MutableInteractionSource arg41, Composer arg42, int arg43, int arg44) {
        MutableInteractionSource v10_2;
        ChipElevation v8_1;
        ChipColors v7_1;
        Shape v6_1;
        Function2 v5_3;
        boolean v4_2;
        ChipBorder v9_2;
        State v5_1;
        boolean v15_2;
        ChipElevation v24_1;
        Object v4_1;
        ChipColors v0_1;
        Shape v22_1;
        Function2 v20_1;
        MutableInteractionSource v28;
        ChipBorder v1_1;
        Companion v3_1;
        MutableInteractionSource v2_2;
        Composer v29;
        ChipColors v23_1;
        Shape v19_1;
        Companion v0_2;
        int v19;
        int v17;
        int v16;
        ChipElevation v15_1;
        int v42;
        int v15;
        ChipColors v10_1;
        int v10;
        Shape v9_1;
        Function2 v8;
        int v6;
        boolean v5;
        int v4;
        Modifier v3;
        int v2;
        Function2 v13;
        Function0 v14;
        int v1;
        int v11 = arg43;
        int v12 = arg44;
        Composer v7 = arg42.startRestartGroup(270460261);
        ComposerKt.sourceInformation(v7, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)833@40281L5,828@40109L569:Chip.kt#uh7d8r");
        if((v12 & 1) != 0) {
            v1 = v11 | 6;
            v14 = arg32;
        }
        else {
            v14 = arg32;
            if((v11 & 6) == 0) {
                v1 = v7.changedInstance(v14) ? 4 : 2;
                v1 |= v11;
            }
            else {
                v1 = v11;
            }
        }

        if((v12 & 2) != 0) {
            v1 |= 0x30;
            v13 = arg33;
        }
        else {
            v13 = arg33;
            if((v11 & 0x30) == 0) {
                v2 = v7.changedInstance(v13) ? 0x20 : 16;
                v1 |= v2;
            }
        }

        v2 = v12 & 4;
        if(v2 != 0) {
            v1 |= 0x180;
            goto label_51;
        }
        else if((v11 & 0x180) == 0) {
            v3 = arg34;
            v4 = v7.changed(v3) ? 0x100 : 0x80;
            v1 |= v4;
        }
        else {
        label_51:
            v3 = arg34;
        }

        v4 = v12 & 8;
        if(v4 != 0) {
            v1 |= 0xC00;
            goto label_66;
        }
        else if((v11 & 0xC00) == 0) {
            v5 = arg35;
            v6 = v7.changed(v5) ? 0x800 : 0x400;
            v1 |= v6;
        }
        else {
        label_66:
            v5 = arg35;
        }

        v6 = v12 & 16;
        if(v6 != 0) {
            v1 |= 0x6000;
            goto label_81;
        }
        else if((v11 & 0x6000) == 0) {
            v8 = arg36;
            int v9 = v7.changedInstance(v8) ? 0x4000 : 0x2000;
            v1 |= v9;
        }
        else {
        label_81:
            v8 = arg36;
        }

        if((0x30000 & v11) == 0) {
            if((v12 & 0x20) == 0) {
                v9_1 = arg37;
                if(v7.changed(v9_1)) {
                    v10 = 0x20000;
                }
                else {
                    goto label_93;
                }
            }
            else {
                v9_1 = arg37;
            label_93:
                v10 = 0x10000;
            }

            v1 |= v10;
        }
        else {
            v9_1 = arg37;
        }

        if((0x180000 & v11) == 0) {
            if((v12 & 0x40) == 0) {
                v10_1 = arg38;
                if(v7.changed(v10_1)) {
                    v15 = 0x100000;
                }
                else {
                    goto label_108;
                }
            }
            else {
                v10_1 = arg38;
            label_108:
                v15 = 0x80000;
            }

            v1 |= v15;
        }
        else {
            v10_1 = arg38;
        }

        v15 = 0xC00000;
        if((v11 & v15) == 0) {
            v42 = v15;
            if((v12 & 0x80) == 0) {
                v15_1 = arg39;
                if(v7.changed(v15_1)) {
                    v16 = 0x800000;
                }
                else {
                    goto label_124;
                }
            }
            else {
                v15_1 = arg39;
            label_124:
                v16 = 0x400000;
            }

            v1 |= v16;
        }
        else {
            v42 = v15;
            v15_1 = arg39;
        }

        if((v11 & 0x6000000) == 0) {
            v17 = (v12 & 0x100) != 0 || !v7.changed(arg40) ? 0x2000000 : 0x4000000;
            v1 |= v17;
        }

        v17 = v2;
        v2 = v12 & 0x200;
        int v18 = 0x30000000;
        if(v2 != 0) {
            v1 |= v18;
            goto label_161;
        }
        else if((v11 & v18) == 0) {
            v18 = v2;
            v19 = v7.changed(arg41) ? 0x20000000 : 0x10000000;
            v1 |= v19;
        }
        else {
        label_161:
            v18 = v2;
        }

        v19 = v1;
        boolean v20 = true;
        boolean v0 = (v1 & 306783379) != 306783378 ? true : false;
        if(v7.shouldExecute(v0, v19 & 1)) {
            v7.startDefaults();
            ComposerKt.sourceInformation(v7, "822@39776L5,823@39831L22,824@39910L25,825@39986L22,826@40060L39");
            int v21 = 0xF1FFFFFF;
            int v22 = 0xFE3FFFFF;
            v1 = 0xFFC7FFFF;
            int v23 = 0xFFF8FFFF;
            Object v24 = null;
            v2 = 6;
            if((v11 & 1) == 0 || (v7.getDefaultsInvalid())) {
                if(v17 != 0) {
                    v0_2 = Modifier.Companion;
                }
                else {
                    Modifier v0_3 = v3;
                }

                if(v4 != 0) {
                }
                else {
                    v20 = v5;
                }

                Function2 v17_1 = v6 != 0 ? ((Function2)v24) : v8;
                if((v12 & 0x20) != 0) {
                    v4 = v19 & v23;
                    v19_1 = SuggestionChipDefaults.INSTANCE.getShape(v7, v2);
                }
                else {
                    v4 = v19;
                    v19_1 = v9_1;
                }

                if((v12 & 0x40) != 0) {
                    v4 &= v1;
                    v23_1 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(v7, v2);
                }
                else {
                    v23_1 = v10_1;
                }

                int v25 = v4;
                if((v12 & 0x80) != 0) {
                    v29 = v7;
                    v25 &= v22;
                    v10 = v2;
                    v15_1 = SuggestionChipDefaults.INSTANCE.suggestionChipElevation-aqJV_2Y(0f, 0f, 0f, 0f, 0f, 0f, v29, 0x180000, 0x3F);
                }
                else {
                    v10 = v2;
                    v29 = v7;
                }

                if((v12 & 0x100) != 0) {
                    v7 = v29;
                    v1_1 = SuggestionChipDefaults.INSTANCE.suggestionChipBorder-d_3_b6Q(0, 0, 0f, v7, 0xC00, 7);
                    v25 &= v21;
                }
                else {
                    v7 = v29;
                    v1_1 = arg40;
                }

                if(v18 != 0) {
                    ComposerKt.sourceInformationMarkerStart(v7, -2080664820, "CC(remember):Chip.kt#9igjgp");
                    Object v2_1 = v7.rememberedValue();
                    if(v2_1 == Composer.Companion.getEmpty()) {
                        v2_2 = InteractionSourceKt.MutableInteractionSource();
                        v7.updateRememberedValue(v2_2);
                    }

                    ComposerKt.sourceInformationMarkerEnd(v7);
                    v3_1 = v0_2;
                    Object v28_1 = v2_2;
                }
                else {
                    v28 = arg41;
                    v3_1 = v0_2;
                }

                v22_1 = v19_1;
                v0_1 = v23_1;
                v4_1 = v24;
                v2 = v25;
                v24_1 = v15_1;
                v15_2 = v20;
                v20_1 = v17_1;
            }
            else {
                v7.skipToGroupEnd();
                if((v12 & 0x20) != 0) {
                    v19 &= v23;
                }

                if((v12 & 0x40) != 0) {
                    v19 &= v1;
                }

                if((v12 & 0x80) != 0) {
                    v19 &= v22;
                }

                if((v12 & 0x100) != 0) {
                    v19 &= v21;
                }

                v1_1 = arg40;
                v28 = arg41;
                v20_1 = v8;
                v22_1 = v9_1;
                v0_1 = v10_1;
                v4_1 = v24;
                v10 = v2;
                v24_1 = v15_1;
                v2 = v19;
                v15_2 = v5;
            }

            v7.endDefaults();
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(270460261, v2, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:828)");
            }

            TextStyle v17_2 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), v7, v10);
            long v18_1 = v0_1.labelColor-vNxB06k$material3(v15_2);
            if(v1_1 == null) {
                v7.startReplaceGroup(-75666041);
                v7.endReplaceGroup();
                v5_1 = ((State)v4_1);
            }
            else {
                v7.startReplaceGroup(-2080650822);
                ComposerKt.sourceInformation(v7, "840@40498L21");
                v5_1 = v1_1.borderStroke$material3(v15_2, v7, v2 >> 9 & 14 | v2 >> 21 & 0x70);
                v7.endReplaceGroup();
            }

            if(v5_1 != null) {
                v4_1 = v5_1.getValue();
            }

            Object v25_1 = v4_1;
            int v5_2 = v2 << 6;
            v4 = v2 >> 6 & 14 | v42 | v2 << 3 & 0x70 | v2 >> 3 & 0x380 | v5_2 & 0x1C00 | v5_2 & 0x380000;
            v5_2 = v2 << 9;
            v23_1 = v0_1;
            v29 = v7;
            Function2 v16_1 = v13;
            Modifier v13_1 = v3;
            ChipKt.Chip-nkUnTEs(v13_1, v14, v15_2, v16_1, v17_2, v18_1, v20_1, null, v22_1, v23_1, v24_1, ((BorderStroke)v25_1), SuggestionChipDefaults.INSTANCE.getHeight-D9Ej5fM(), ChipKt.SuggestionChipPadding, v28, v29, v4 | 0xE000000 & v5_2 | v5_2 & 0x70000000, v2 >> 21 & 14 | 0xD80 | v2 >> 15 & 0xE000);
            if(ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }

            v9_2 = v1_1;
            v3 = v13_1;
            v4_2 = v15_2;
            v5_3 = v20_1;
            v6_1 = v22_1;
            v7_1 = v23_1;
            v8_1 = v24_1;
            v10_2 = v28;
        }
        else {
            v29 = v7;
            v29.skipToGroupEnd();
            v4_2 = v5;
            v5_3 = v8;
            v6_1 = v9_1;
            v7_1 = v10_1;
            v8_1 = v15_1;
            v9_2 = arg40;
            v10_2 = arg41;
        }

        ScopeUpdateScope v13_2 = v29.endRestartGroup();
        if(v13_2 != null) {
            v13_2.updateScope(new ChipKt$$ExternalSyntheticLambda16(arg32, arg33, v3, v4_2, v5_3, v6_1, v7_1, v8_1, v9_2, v10_2, v11, v12));
        }
    }

    static final Unit SuggestionChip$lambda$11(Function0 arg14, Function2 arg15, Modifier arg16, boolean arg17, Function2 arg18, Shape arg19, ChipColors arg20, ChipElevation arg21, ChipBorder arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ChipKt.SuggestionChip(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    static final Unit SuggestionChip$lambda$9(Function0 arg14, Function2 arg15, Modifier arg16, boolean arg17, Function2 arg18, Shape arg19, ChipColors arg20, ChipElevation arg21, BorderStroke arg22, MutableInteractionSource arg23, int arg24, int arg25, Composer arg26, int arg27) {
        ChipKt.SuggestionChip(arg14, arg15, arg16, arg17, arg18, arg19, arg20, arg21, arg22, arg23, arg26, RecomposeScopeImplKt.updateChangedFlags(arg24 | 1), arg25);
        return Unit.INSTANCE;
    }

    public static final void access$AnimatingChipContent-fe0OD_I(Function2 arg0, TextStyle arg1, long arg2, Function2 arg4, Function2 arg5, Function2 arg6, long arg7, long arg9, float arg11, PaddingValues arg12, Composer arg13, int arg14) {
        ChipKt.AnimatingChipContent-fe0OD_I(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg9, arg11, arg12, arg13, arg14);
    }

    public static final void access$ChipContent-fe0OD_I(Function2 arg0, TextStyle arg1, long arg2, Function2 arg4, Function2 arg5, Function2 arg6, long arg7, long arg9, float arg11, PaddingValues arg12, Composer arg13, int arg14) {
        ChipKt.ChipContent-fe0OD_I(arg0, arg1, arg2, arg4, arg5, arg6, arg7, arg9, arg11, arg12, arg13, arg14);
    }

    public static final float access$getHorizontalElementsPadding$p() {
        return ChipKt.HorizontalElementsPadding;
    }

    public static final Function2 access$leadingContent-XO-JAsU(Function2 arg0, Function2 arg1, long arg2, Composer arg4, int arg5) {
        return ChipKt.leadingContent-XO-JAsU(arg0, arg1, arg2, arg4, arg5);
    }

    public static final State access$rememberRetainedState(Object arg0, Composer arg1, int arg2) {
        return ChipKt.rememberRetainedState(arg0, arg1, arg2);
    }

    public static final Function2 access$trailingContent-RPmYEkk(Function2 arg0, long arg1, Composer arg3, int arg4) {
        return ChipKt.trailingContent-RPmYEkk(arg0, arg1, arg3, arg4);
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme arg23) {
        ColorScheme v0 = arg23;
        ChipColors v1 = v0.getDefaultSuggestionChipColorsCached$material3();
        if(v1 == null) {
            ChipColors v2 = new ChipColors(Color.Companion.getTransparent-0d7_KjU(), ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.getUnspecified-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0f, 0f, 0f, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(v0, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0f, 0f, 0f, 14, null), Color.Companion.getUnspecified-0d7_KjU(), null);
            v0.setDefaultSuggestionChipColorsCached$material3(v2);
            return v2;
        }

        return v1;
    }

    private static final PaddingValues inputChipPadding(boolean arg8, boolean arg9, boolean arg10) {
        float v0 = 8f;
        float v1 = 4f;
        float v8 = (arg8) || !arg9 ? Dp.constructor-impl(v1) : Dp.constructor-impl(v0);
        float v2 = v8;
        v8 = arg10 ? Dp.constructor-impl(v0) : Dp.constructor-impl(v1);
        return PaddingKt.PaddingValues-a9UjIt4$default(v2, 0f, v8, 0f, 10, null);
    }

    static PaddingValues inputChipPadding$default(boolean arg1, boolean arg2, boolean arg3, int arg4, Object arg5) {
        return ChipKt.inputChipPadding(false, false, false);
    }

    private static final Function2 leadingContent-XO-JAsU(Function2 arg3, Function2 arg4, long arg5, Composer arg7, int arg8) {
        ComposableLambda v3;
        int v1 = 1330309098;
        ComposerKt.sourceInformationMarkerStart(arg7, v1, "C(leadingContent)N(avatar,leadingIcon,leadingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg8, -1, "androidx.compose.material3.leadingContent (Chip.kt:2212)");
        }

        if(arg3 != null) {
            arg7.startReplaceGroup(0xA830B0F0);
            arg7.endReplaceGroup();
        }
        else if(arg4 != null) {
            arg7.startReplaceGroup(1575390813);
            ComposerKt.sourceInformation(arg7, "2215@107394L183");
            v3 = ComposableLambdaKt.rememberComposableLambda(-237350650, true, new ChipKt$leadingContent$1(arg5, arg4), arg7, 54);
            arg7.endReplaceGroup();
        }
        else {
            arg7.startReplaceGroup(0x5DEA06D3);
            arg7.endReplaceGroup();
            arg3 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg7);
        return ((Function2)v3);
    }

    private static final State rememberRetainedState(Object arg3, Composer arg4, int arg5) {
        MutableState v5_1;
        int v1 = 0xDB270A54;
        ComposerKt.sourceInformationMarkerStart(arg4, v1, "C(rememberRetainedState)N(targetValue)2249@108434L40:Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg5, -1, "androidx.compose.material3.rememberRetainedState (Chip.kt:2248)");
        }

        ComposerKt.sourceInformationMarkerStart(arg4, 0xAD8DD27C, "CC(remember):Chip.kt#9igjgp");
        Object v5 = arg4.rememberedValue();
        if(v5 == Composer.Companion.getEmpty()) {
            v5_1 = SnapshotStateKt.mutableStateOf$default(arg3, null, 2, null);
            arg4.updateRememberedValue(v5_1);
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        if(arg3 != null) {
            v5_1.setValue(arg3);
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg4);
        return ((State)v5_1);
    }

    private static final Function2 trailingContent-RPmYEkk(Function2 arg3, long arg4, Composer arg6, int arg7) {
        int v1 = -165980551;
        ComposerKt.sourceInformationMarkerStart(arg6, v1, "C(trailingContent)N(trailingIcon,trailingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(v1, arg7, -1, "androidx.compose.material3.trailingContent (Chip.kt:2231)");
        }

        if(arg3 != null) {
            arg6.startReplaceGroup(0xB756B028);
            ComposerKt.sourceInformation(arg6, "2232@107914L165");
            ComposableLambda v3 = ComposableLambdaKt.rememberComposableLambda(-566924201, true, new ChipKt$trailingContent$1(arg4, arg3), arg6, 54);
            arg6.endReplaceGroup();
        }
        else {
            arg6.startReplaceGroup(0xB7599E55);
            arg6.endReplaceGroup();
            arg3 = null;
        }

        if(ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }

        ComposerKt.sourceInformationMarkerEnd(arg6);
        return arg3;
    }
}

