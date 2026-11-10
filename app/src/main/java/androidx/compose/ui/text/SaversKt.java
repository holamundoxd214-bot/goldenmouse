package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle$Alignment$Companion;
import androidx.compose.ui.text.style.LineHeightStyle$Alignment;
import androidx.compose.ui.text.style.LineHeightStyle$Mode;
import androidx.compose.ui.text.style.LineHeightStyle$Trim;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0080\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AI\u0010\u0000\u001A\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00052\b\u0010\u0006\u001A\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001A\u0002H\u00022\u0006\u0010\b\u001A\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001AL\u0010\u000B\u001A\u0004\u0018\u0001H\f\"\u0014\b\u0000\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0006\b\u0003\u0010\f\u0018\u00012\b\u0010\u0006\u001A\u0004\u0018\u0001H\u00052\u0006\u0010\u0007\u001A\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\r\u001Ay\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000F\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012.\u0010\u0000\u001A*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0010¢\u0006\u0002\b\u00132#\u0010\u000B\u001A\u001F\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0014H\u0002\u001A\u001F\u0010\u0000\u001A\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u00022\b\u0010\u0006\u001A\u0004\u0018\u0001H\u0002H\u0000¢\u0006\u0002\u0010\u0015\u001A\"\u0010\u000B\u001A\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0001H\u0080\b¢\u0006\u0002\u0010\u0015\" \u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"(\u0010\u001A\u001A\u001C\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001C0\u001B\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u001D\u001A\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001C\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001E\u0010\u001F\"\u001A\u0010 \u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001A\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001F\"\u001A\u0010%\u001A\u000E\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001A\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010)\u001A\u000E\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b+\u0010\u0019\" \u0010,\u001A\u000E\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b.\u0010\u0019\" \u0010/\u001A\u000E\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b1\u0010\u0019\"$\u00102\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003*\u0002048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u00106\"\u001A\u00107\u001A\u000E\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003*\u0002098@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010:\"\u001A\u0010;\u001A\u000E\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010>\"\u001A\u0010?\u001A\u000E\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010B\"\u001A\u0010C\u001A\u000E\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010F\"\u001A\u0010G\u001A\u000E\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010J\"\u001A\u0010K\u001A\u000E\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010N\"\u001A\u0010O\u001A\u000E\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010R\"\u001A\u0010S\u001A\u000E\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u0003*\u00020U8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010V\"\u001A\u0010W\u001A\u000E\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010Z\"\u001A\u0010[\u001A\u000E\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u0003*\u00020]8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010^\"\u001A\u0010_\u001A\u000E\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010b\" \u0010c\u001A\u000E\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bd\u0010\u0019\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003*\u00020f8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010g\" \u0010h\u001A\u000E\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\bi\u0010\u0019\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u0003*\u00020k8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010l\"\u001A\u0010m\u001A\u000E\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u0003*\u00020o8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010p\" \u0010q\u001A\u000E\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00010\u000FX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\br\u0010s\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u0003*\u00020u8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010v\"\u001A\u0010w\u001A\u000E\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003*\u00020y8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010z\"\u001A\u0010{\u001A\u000E\u0012\u0004\u0012\u00020x\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001A\u000E\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003*\u00020}8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b5\u0010~\"\u001A\u0010\u007F\u001A\u000E\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\'\u00102\u001A\u000F\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0081\u00018@X\u0080\u0004¢\u0006\u0007\u001A\u0005\b5\u0010\u0082\u0001\"\u001C\u0010\u0083\u0001\u001A\u000F\u0012\u0005\u0012\u00030\u0080\u0001\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\'\u00102\u001A\u000F\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0085\u00018BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b5\u0010\u0086\u0001\"\u001C\u0010\u0087\u0001\u001A\u000F\u0012\u0005\u0012\u00030\u0084\u0001\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"\'\u00102\u001A\u000F\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u0089\u00018BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b5\u0010\u008A\u0001\"\u001C\u0010\u008B\u0001\u001A\u000F\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000\"\'\u00102\u001A\u000F\u0012\u0005\u0012\u00030\u008C\u0001\u0012\u0004\u0012\u00020\u00010\u0003*\u00030\u008D\u00018BX\u0082\u0004¢\u0006\u0007\u001A\u0005\b5\u0010\u008E\u0001\"\u001C\u0010\u008F\u0001\u001A\u000F\u0012\u0005\u0012\u00030\u008C\u0001\u0012\u0004\u0012\u00020\u00010\u000FX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2={"save", "", "T", "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "value", "saver", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "restore", "Result", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "NonNullValueClassSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "Lkotlin/Function1;", "(Ljava/lang/Object;)Ljava/lang/Object;", "AnnotatedStringSaver", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "Saver", "Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ColorSaver", "Landroidx/compose/ui/text/style/TextAlign;", "Landroidx/compose/ui/text/style/TextAlign$Companion;", "(Landroidx/compose/ui/text/style/TextAlign$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextAlignSaver", "Landroidx/compose/ui/text/style/TextDirection;", "Landroidx/compose/ui/text/style/TextDirection$Companion;", "(Landroidx/compose/ui/text/style/TextDirection$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDirectionSaver", "Landroidx/compose/ui/text/style/Hyphens;", "Landroidx/compose/ui/text/style/Hyphens$Companion;", "(Landroidx/compose/ui/text/style/Hyphens$Companion;)Landroidx/compose/runtime/saveable/Saver;", "HyphensSaver", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontStyle$Companion;", "(Landroidx/compose/ui/text/font/FontStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontStyleSaver", "getFontStyleSaver", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroidx/compose/ui/text/font/FontSynthesis$Companion;", "(Landroidx/compose/ui/text/font/FontSynthesis$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontSynthesisSaver", "getFontSynthesisSaver", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitSaver", "Landroidx/compose/ui/unit/TextUnitType;", "Landroidx/compose/ui/unit/TextUnitType$Companion;", "(Landroidx/compose/ui/unit/TextUnitType$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitTypeSaver", "getTextUnitTypeSaver", "()Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleAlignmentSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleTrimSaver", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode;", "Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Mode$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleModeSaver", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SaversKt {
    @Metadata(k=3, mv={2, 0, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[AnnotationType.values().length];
            try {
                v0[AnnotationType.Paragraph.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[AnnotationType.Span.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[AnnotationType.VerbatimTts.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[AnnotationType.Url.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[AnnotationType.Link.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[AnnotationType.Clickable.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[AnnotationType.String.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final Saver AnnotatedStringSaver;
    private static final Saver AnnotationRangeListSaver;
    private static final Saver AnnotationRangeSaver;
    private static final Saver BaselineShiftSaver;
    private static final Saver ClickableSaver;
    private static final NonNullValueClassSaver ColorSaver;
    private static final Saver FontStyleSaver;
    private static final Saver FontSynthesisSaver;
    private static final Saver FontWeightSaver;
    private static final NonNullValueClassSaver HyphensSaver;
    private static final NonNullValueClassSaver LineHeightStyleAlignmentSaver;
    private static final NonNullValueClassSaver LineHeightStyleModeSaver;
    private static final Saver LineHeightStyleSaver;
    private static final NonNullValueClassSaver LineHeightStyleTrimSaver;
    private static final Saver LinkSaver;
    private static final Saver LocaleListSaver;
    private static final Saver LocaleSaver;
    private static final NonNullValueClassSaver OffsetSaver;
    private static final Saver ParagraphStyleSaver;
    private static final Saver ShadowSaver;
    private static final Saver SpanStyleSaver;
    private static final NonNullValueClassSaver TextAlignSaver;
    private static final Saver TextDecorationSaver;
    private static final NonNullValueClassSaver TextDirectionSaver;
    private static final Saver TextGeometricTransformSaver;
    private static final Saver TextIndentSaver;
    private static final Saver TextLinkStylesSaver;
    private static final Saver TextRangeSaver;
    private static final NonNullValueClassSaver TextUnitSaver;
    private static final NonNullValueClassSaver TextUnitTypeSaver;
    private static final Saver UrlAnnotationSaver;
    private static final Saver VerbatimTtsAnnotationSaver;

    static {
        SaversKt.AnnotatedStringSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda0(), new SaversKt$$ExternalSyntheticLambda2());
        SaversKt.AnnotationRangeListSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda14(), new SaversKt$$ExternalSyntheticLambda26());
        SaversKt.AnnotationRangeSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda38(), new SaversKt$$ExternalSyntheticLambda50());
        SaversKt.VerbatimTtsAnnotationSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda53(), new SaversKt$$ExternalSyntheticLambda54());
        SaversKt.UrlAnnotationSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda56(), new SaversKt$$ExternalSyntheticLambda57());
        SaversKt.LinkSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda11(), new SaversKt$$ExternalSyntheticLambda22());
        SaversKt.ClickableSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda33(), new SaversKt$$ExternalSyntheticLambda44());
        SaversKt.ParagraphStyleSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda55(), new SaversKt$$ExternalSyntheticLambda58());
        SaversKt.SpanStyleSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda59(), new SaversKt$$ExternalSyntheticLambda60());
        SaversKt.TextLinkStylesSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda61(), new SaversKt$$ExternalSyntheticLambda1());
        SaversKt.TextDecorationSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda3(), new SaversKt$$ExternalSyntheticLambda4());
        SaversKt.TextGeometricTransformSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda5(), new SaversKt$$ExternalSyntheticLambda6());
        SaversKt.TextIndentSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda7(), new SaversKt$$ExternalSyntheticLambda8());
        SaversKt.FontWeightSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda9(), new SaversKt$$ExternalSyntheticLambda10());
        SaversKt.BaselineShiftSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda12(), new SaversKt$$ExternalSyntheticLambda13());
        SaversKt.TextRangeSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda15(), new SaversKt$$ExternalSyntheticLambda16());
        SaversKt.ShadowSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda17(), new SaversKt$$ExternalSyntheticLambda18());
        SaversKt.ColorSaver = SaversKt.NonNullValueClassSaver(SaversKt$ColorSaver$1.INSTANCE, SaversKt$ColorSaver$2.INSTANCE);
        SaversKt.TextAlignSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda19(), new SaversKt$$ExternalSyntheticLambda20());
        SaversKt.TextDirectionSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda21(), new SaversKt$$ExternalSyntheticLambda23());
        SaversKt.HyphensSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda24(), new SaversKt$$ExternalSyntheticLambda25());
        SaversKt.FontStyleSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda27(), new SaversKt$$ExternalSyntheticLambda28());
        SaversKt.FontSynthesisSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda29(), new SaversKt$$ExternalSyntheticLambda30());
        SaversKt.TextUnitSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda31(), new SaversKt$$ExternalSyntheticLambda32());
        SaversKt.TextUnitTypeSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda34(), new SaversKt$$ExternalSyntheticLambda35());
        SaversKt.OffsetSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda36(), new SaversKt$$ExternalSyntheticLambda37());
        SaversKt.LocaleListSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda39(), new SaversKt$$ExternalSyntheticLambda40());
        SaversKt.LocaleSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda41(), new SaversKt$$ExternalSyntheticLambda42());
        SaversKt.LineHeightStyleSaver = SaverKt.Saver(new SaversKt$$ExternalSyntheticLambda43(), new SaversKt$$ExternalSyntheticLambda45());
        SaversKt.LineHeightStyleAlignmentSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda46(), new SaversKt$$ExternalSyntheticLambda47());
        SaversKt.LineHeightStyleTrimSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda48(), new SaversKt$$ExternalSyntheticLambda49());
        SaversKt.LineHeightStyleModeSaver = SaversKt.NonNullValueClassSaver(new SaversKt$$ExternalSyntheticLambda51(), new SaversKt$$ExternalSyntheticLambda52());
    }

    static final Object AnnotatedStringSaver$lambda$0(SaverScope arg2, AnnotatedString arg3) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(arg3.getText()), SaversKt.save(arg3.getAnnotations$ui_text(), SaversKt.AnnotationRangeListSaver, arg2)});
    }

    static final AnnotatedString AnnotatedStringSaver$lambda$1(Object arg5) {
        List v0_1;
        Intrinsics.checkNotNull(arg5, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Object v0 = ((List)arg5).get(1);
        Saver v1 = SaversKt.AnnotationRangeListSaver;
        Object v4 = null;
        if((Intrinsics.areEqual(v0, Boolean.valueOf(false))) && !(v1 instanceof NonNullValueClassSaver)) {
            goto label_16;
        }
        else if(v0 != null) {
            v0 = v1.restore(v0);
        }
        else {
        label_16:
            v0_1 = ((List)v4);
        }

        arg5 = ((List)arg5).get(0);
        if(arg5 != null) {
            v4 = arg5;
        }

        Intrinsics.checkNotNull(v4);
        return new AnnotatedString(v0_1, ((String)v4));
    }

    static final Object AnnotationRangeListSaver$lambda$0(SaverScope arg6, List arg7) {
        ArrayList v0 = new ArrayList(arg7.size());
        int v1 = arg7.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(SaversKt.save(arg7.get(v2), SaversKt.AnnotationRangeSaver, arg6));
        }

        return v0;
    }

    static final List AnnotationRangeListSaver$lambda$1(Object arg9) {
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        ArrayList v0 = new ArrayList(((List)arg9).size());
        int v1 = arg9.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = ((List)arg9).get(v3);
            ArrayList v5 = v0;
            Saver v6 = SaversKt.AnnotationRangeSaver;
            Object v8 = null;
            if((Intrinsics.areEqual(v4, Boolean.valueOf(false))) && !(v6 instanceof NonNullValueClassSaver)) {
            }
            else if(v4 != null) {
                v8 = v6.restore(v4);
            }

            Intrinsics.checkNotNull(v8);
            ((Collection)v5).add(v8);
        }

        return ((List)v0);
    }

    static final Object AnnotationRangeSaver$lambda$0(SaverScope arg3, Range arg4) {
        AnnotationType v0_1;
        Object v0 = arg4.getItem();
        if((v0 instanceof ParagraphStyle)) {
            v0_1 = AnnotationType.Paragraph;
        }
        else if((v0 instanceof SpanStyle)) {
            v0_1 = AnnotationType.Span;
        }
        else if((v0 instanceof VerbatimTtsAnnotation)) {
            v0_1 = AnnotationType.VerbatimTts;
        }
        else if((v0 instanceof UrlAnnotation)) {
            v0_1 = AnnotationType.Url;
        }
        else if((v0 instanceof Url)) {
            v0_1 = AnnotationType.Link;
        }
        else if((v0 instanceof Clickable)) {
            v0_1 = AnnotationType.Clickable;
        }
        else if((v0 instanceof StringAnnotation)) {
            v0_1 = AnnotationType.String;
        }
        else {
            goto label_88;
        }

        switch(WhenMappings.$EnumSwitchMapping$0[v0_1.ordinal()]) {
            case 1: {
                goto label_71;
            }
            case 2: {
                goto label_65;
            }
            case 3: {
                goto label_59;
            }
            case 4: {
                goto label_53;
            }
            case 5: {
                goto label_47;
            }
            case 6: {
                goto label_41;
            }
            case 7: {
                goto label_35;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_65:
        Object v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
        Object v3 = SaversKt.save(v1, SaversKt.SpanStyleSaver, arg3);
        goto label_76;
    label_35:
        v3 = arg4.getItem();
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
        v3 = SaversKt.save(((StringAnnotation)v3).unbox-impl());
        goto label_76;
    label_53:
        v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
        v3 = SaversKt.save(v1, SaversKt.UrlAnnotationSaver, arg3);
        goto label_76;
    label_71:
        v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
        v3 = SaversKt.save(v1, SaversKt.ParagraphStyleSaver, arg3);
        goto label_76;
    label_41:
        v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
        v3 = SaversKt.save(v1, SaversKt.ClickableSaver, arg3);
        goto label_76;
    label_59:
        v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
        v3 = SaversKt.save(v1, SaversKt.VerbatimTtsAnnotationSaver, arg3);
        goto label_76;
    label_47:
        v1 = arg4.getItem();
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
        v3 = SaversKt.save(v1, SaversKt.LinkSaver, arg3);
    label_76:
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(v0_1), v3, SaversKt.save(Integer.valueOf(arg4.getStart())), SaversKt.save(Integer.valueOf(arg4.getEnd())), SaversKt.save(arg4.getTag())});
    label_88:
        throw new UnsupportedOperationException();
    }

    static final Range AnnotationRangeSaver$lambda$1(Object arg7) {
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Boolean v1 = Boolean.valueOf(false);
        Object v0 = ((List)arg7).get(0);
        Object v2 = null;
        if(v0 != null) {
        }
        else {
            v0 = v2;
        }

        Intrinsics.checkNotNull(v0);
        Object v3 = ((List)arg7).get(2);
        if(v3 != null) {
        }
        else {
            v3 = v2;
        }

        Intrinsics.checkNotNull(v3);
        int v3_1 = ((Number)v3).intValue();
        Object v4 = ((List)arg7).get(3);
        if(v4 != null) {
        }
        else {
            v4 = v2;
        }

        Intrinsics.checkNotNull(v4);
        int v4_1 = ((Number)v4).intValue();
        Object v5 = ((List)arg7).get(4);
        if(v5 != null) {
        }
        else {
            v5 = v2;
        }

        Intrinsics.checkNotNull(v5);
        switch(WhenMappings.$EnumSwitchMapping$0[((AnnotationType)v0).ordinal()]) {
            case 1: {
                goto label_117;
            }
            case 2: {
                goto label_103;
            }
            case 3: {
                goto label_89;
            }
            case 4: {
                goto label_75;
            }
            case 5: {
                goto label_61;
            }
            case 6: {
                goto label_47;
            }
            case 7: {
                goto label_38;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_117:
        arg7 = ((List)arg7).get(1);
        Saver v0_1 = SaversKt.ParagraphStyleSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    label_38:
        arg7 = ((List)arg7).get(1);
        if(arg7 != null) {
            v2 = arg7;
        }

        Intrinsics.checkNotNull(v2);
        return new Range(StringAnnotation.box-impl(StringAnnotation.constructor-impl(((String)v2))), v3_1, v4_1, ((String)v5));
    label_103:
        arg7 = ((List)arg7).get(1);
        v0_1 = SaversKt.SpanStyleSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    label_89:
        arg7 = ((List)arg7).get(1);
        v0_1 = SaversKt.VerbatimTtsAnnotationSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    label_75:
        arg7 = ((List)arg7).get(1);
        v0_1 = SaversKt.UrlAnnotationSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    label_61:
        arg7 = ((List)arg7).get(1);
        v0_1 = SaversKt.LinkSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    label_47:
        arg7 = ((List)arg7).get(1);
        v0_1 = SaversKt.ClickableSaver;
        if((Intrinsics.areEqual(arg7, v1)) && !(v0_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            v2 = v0_1.restore(arg7);
        }

        Intrinsics.checkNotNull(v2);
        return new Range(v2, v3_1, v4_1, ((String)v5));
    }

    static final Object BaselineShiftSaver$lambda$0(SaverScope arg0, BaselineShift arg1) {
        return Float.valueOf(arg1.unbox-impl());
    }

    static final BaselineShift BaselineShiftSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Float");
        return BaselineShift.box-impl(BaselineShift.constructor-impl(((Float)arg1).floatValue()));
    }

    static final Object ClickableSaver$lambda$0(SaverScope arg2, Clickable arg3) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(arg3.getTag()), SaversKt.save(arg3.getStyles(), SaversKt.TextLinkStylesSaver, arg2)});
    }

    static final Clickable ClickableSaver$lambda$1(Object arg4) {
        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Object v1 = ((List)arg4).get(0);
        LinkInteractionListener v2 = null;
        if(v1 != null) {
        }
        else {
            v1 = v2;
        }

        Intrinsics.checkNotNull(v1);
        arg4 = ((List)arg4).get(1);
        Saver v3 = SaversKt.TextLinkStylesSaver;
        if((Intrinsics.areEqual(arg4, Boolean.valueOf(false))) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_21;
        }
        else if(arg4 != null) {
            arg4 = v3.restore(arg4);
        }
        else {
        label_21:
            TextLinkStyles v4 = ((TextLinkStyles)v2);
        }

        return new Clickable(((String)v1), ((TextLinkStyles)arg4), v2);
    }

    static final Object FontStyleSaver$lambda$0(SaverScope arg0, FontStyle arg1) {
        return SaversKt.save(Integer.valueOf(arg1.unbox-impl()));
    }

    static final FontStyle FontStyleSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return FontStyle.box-impl(FontStyle.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object FontSynthesisSaver$lambda$0(SaverScope arg0, FontSynthesis arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final FontSynthesis FontSynthesisSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return FontSynthesis.box-impl(FontSynthesis.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object FontWeightSaver$lambda$0(SaverScope arg0, FontWeight arg1) {
        return Integer.valueOf(arg1.getWeight());
    }

    static final FontWeight FontWeightSaver$lambda$1(Object arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.Int");
        return new FontWeight(((Integer)arg2).intValue());
    }

    static final Object HyphensSaver$lambda$0(SaverScope arg0, Hyphens arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final Hyphens HyphensSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return Hyphens.box-impl(Hyphens.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object LineHeightStyleAlignmentSaver$lambda$0(SaverScope arg0, Alignment arg1) {
        return Float.valueOf(arg1.unbox-impl());
    }

    static final Alignment LineHeightStyleAlignmentSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Float");
        return Alignment.box-impl(Alignment.constructor-impl(((Float)arg1).floatValue()));
    }

    static final Object LineHeightStyleModeSaver$lambda$0(SaverScope arg0, Mode arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final Mode LineHeightStyleModeSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return Mode.box-impl(Mode.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object LineHeightStyleSaver$lambda$0(SaverScope arg3, LineHeightStyle arg4) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Alignment.box-impl(arg4.getAlignment-PIaL0Z0()), SaversKt.getSaver(Alignment.Companion), arg3), SaversKt.save(Trim.box-impl(arg4.getTrim-EVpEnUU()), SaversKt.getSaver(Trim.Companion), arg3), SaversKt.save(Mode.box-impl(arg4.getMode-lzQqcRY()), SaversKt.getSaver(Mode.Companion), arg3)});
    }

    static final LineHeightStyle LineHeightStyleSaver$lambda$1(Object arg7) {
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Boolean v2 = Boolean.valueOf(false);
        Object v1 = ((List)arg7).get(0);
        Saver v3 = SaversKt.getSaver(Alignment.Companion);
        DefaultConstructorMarker v5 = null;
        if((Intrinsics.areEqual(v1, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v1 != null) {
            v1 = v3.restore(v1);
        }
        else {
        label_17:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        float v1_1 = ((Alignment)v1).unbox-impl();
        Object v3_1 = ((List)arg7).get(1);
        Saver v4 = SaversKt.getSaver(Trim.Companion);
        if((Intrinsics.areEqual(v3_1, v2)) && !(v4 instanceof NonNullValueClassSaver)) {
            goto label_32;
        }
        else if(v3_1 != null) {
            v3_1 = v4.restore(v3_1);
        }
        else {
        label_32:
            v3_1 = v5;
        }

        Intrinsics.checkNotNull(v3_1);
        int v3_2 = ((Trim)v3_1).unbox-impl();
        arg7 = ((List)arg7).get(2);
        v4 = SaversKt.getSaver(Mode.Companion);
        if((Intrinsics.areEqual(arg7, v2)) && !(v4 instanceof NonNullValueClassSaver)) {
            goto label_47;
        }
        else if(arg7 != null) {
            arg7 = v4.restore(arg7);
        }
        else {
        label_47:
            arg7 = v5;
        }

        Intrinsics.checkNotNull(arg7);
        return new LineHeightStyle(v1_1, v3_2, ((Mode)arg7).unbox-impl(), v5);
    }

    static final Object LineHeightStyleTrimSaver$lambda$0(SaverScope arg0, Trim arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final Trim LineHeightStyleTrimSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return Trim.box-impl(Trim.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object LinkSaver$lambda$0(SaverScope arg2, Url arg3) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(arg3.getUrl()), SaversKt.save(arg3.getStyles(), SaversKt.TextLinkStylesSaver, arg2)});
    }

    static final Url LinkSaver$lambda$1(Object arg9) {
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Object v1 = ((List)arg9).get(0);
        Object v2 = null;
        Object v4 = v1 != null ? v1 : v2;
        Intrinsics.checkNotNull(v4);
        arg9 = ((List)arg9).get(1);
        Saver v1_1 = SaversKt.TextLinkStylesSaver;
        if((Intrinsics.areEqual(arg9, Boolean.valueOf(false))) && !(v1_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg9 != null) {
            v2 = v1_1.restore(arg9);
        }

        return new Url(((String)v4), v2, null, 4, null);
    }

    static final Object LocaleListSaver$lambda$0(SaverScope arg6, LocaleList arg7) {
        List v7 = arg7.getLocaleList();
        ArrayList v0 = new ArrayList(v7.size());
        int v1 = v7.size();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            v0.add(SaversKt.save(v7.get(v2), SaversKt.getSaver(Locale.Companion), arg6));
        }

        return v0;
    }

    static final LocaleList LocaleListSaver$lambda$1(Object arg9) {
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        ArrayList v0 = new ArrayList(((List)arg9).size());
        int v1 = arg9.size();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            Object v4 = ((List)arg9).get(v3);
            ArrayList v5 = v0;
            Saver v6 = SaversKt.getSaver(Locale.Companion);
            Object v8 = null;
            if((Intrinsics.areEqual(v4, Boolean.valueOf(false))) && !(v6 instanceof NonNullValueClassSaver)) {
            }
            else if(v4 != null) {
                v8 = v6.restore(v4);
            }

            Intrinsics.checkNotNull(v8);
            ((Collection)v5).add(v8);
        }

        return new LocaleList(((List)v0));
    }

    static final Object LocaleSaver$lambda$0(SaverScope arg0, Locale arg1) {
        return arg1.toLanguageTag();
    }

    static final Locale LocaleSaver$lambda$1(Object arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.String");
        return new Locale(((String)arg2));
    }

    private static final NonNullValueClassSaver NonNullValueClassSaver(Function2 arg1, Function1 arg2) {
        return new SaversKt$NonNullValueClassSaver$1(arg1, arg2);
    }

    static final Object OffsetSaver$lambda$0(SaverScope arg4, Offset arg5) {
        long v0 = Offset.Companion.getUnspecified-F1C5BW0();
        boolean v0_1 = arg5 == null ? false : Offset.equals-impl0(arg5.unbox-impl(), v0);
        if(v0_1) {
            return Boolean.valueOf(false);
        }

        return CollectionsKt.arrayListOf(new Float[]{SaversKt.save(Float.valueOf(Float.intBitsToFloat(((int)(arg5.unbox-impl() >> 0x20))))), SaversKt.save(Float.valueOf(Float.intBitsToFloat(((int)(arg5.unbox-impl() & 0xFFFFFFFFL)))))});
    }

    static final Offset OffsetSaver$lambda$1(Object arg6) {
        if(Intrinsics.areEqual(arg6, Boolean.valueOf(false))) {
            return Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0());
        }

        Intrinsics.checkNotNull(arg6, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Object v0 = ((List)arg6).get(0);
        Object v1 = null;
        if(v0 != null) {
        }
        else {
            v0 = v1;
        }

        Intrinsics.checkNotNull(v0);
        float v0_1 = ((Number)v0).floatValue();
        arg6 = ((List)arg6).get(1);
        if(arg6 != null) {
            v1 = arg6;
        }

        Intrinsics.checkNotNull(v1);
        return Offset.box-impl(Offset.constructor-impl((((long)Float.floatToRawIntBits(v0_1))) << 0x20 | (((long)Float.floatToRawIntBits(((Number)v1).floatValue()))) & 0xFFFFFFFFL));
    }

    static final Object ParagraphStyleSaver$lambda$0(SaverScope arg11, ParagraphStyle arg12) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(TextAlign.box-impl(arg12.getTextAlign-e0LSkKk()), SaversKt.getSaver(TextAlign.Companion), arg11), SaversKt.save(TextDirection.box-impl(arg12.getTextDirection-s_7X-co()), SaversKt.getSaver(TextDirection.Companion), arg11), SaversKt.save(TextUnit.box-impl(arg12.getLineHeight-XSAIIZE()), SaversKt.getSaver(TextUnit.Companion), arg11), SaversKt.save(arg12.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), arg11), SaversKt.save(arg12.getPlatformStyle(), Savers_androidKt.getSaver(PlatformParagraphStyle.Companion), arg11), SaversKt.save(arg12.getLineHeightStyle(), SaversKt.getSaver(LineHeightStyle.Companion), arg11), SaversKt.save(LineBreak.box-impl(arg12.getLineBreak-rAG3T2k()), Savers_androidKt.getSaver(LineBreak.Companion), arg11), SaversKt.save(Hyphens.box-impl(arg12.getHyphens-vmbZdU8()), SaversKt.getSaver(Hyphens.Companion), arg11), SaversKt.save(arg12.getTextMotion(), Savers_androidKt.getSaver(TextMotion.Companion), arg11)});
    }

    static final ParagraphStyle ParagraphStyleSaver$lambda$1(Object arg14) {
        Intrinsics.checkNotNull(arg14, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Boolean v2 = Boolean.valueOf(false);
        Object v1 = ((List)arg14).get(0);
        Saver v3 = SaversKt.getSaver(TextAlign.Companion);
        Object v5 = null;
        if((Intrinsics.areEqual(v1, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v1 != null) {
            v1 = v3.restore(v1);
        }
        else {
        label_17:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        int v1_1 = ((TextAlign)v1).unbox-impl();
        Object v3_1 = ((List)arg14).get(1);
        Saver v4 = SaversKt.getSaver(TextDirection.Companion);
        if((Intrinsics.areEqual(v3_1, v2)) && !(v4 instanceof NonNullValueClassSaver)) {
            goto label_32;
        }
        else if(v3_1 != null) {
            v3_1 = v4.restore(v3_1);
        }
        else {
        label_32:
            v3_1 = v5;
        }

        Intrinsics.checkNotNull(v3_1);
        int v3_2 = ((TextDirection)v3_1).unbox-impl();
        Object v4_1 = ((List)arg14).get(2);
        Saver v6 = SaversKt.getSaver(TextUnit.Companion);
        if((Intrinsics.areEqual(v4_1, v2)) && !(v6 instanceof NonNullValueClassSaver)) {
            goto label_47;
        }
        else if(v4_1 != null) {
            v4_1 = v6.restore(v4_1);
        }
        else {
        label_47:
            v4_1 = v5;
        }

        Intrinsics.checkNotNull(v4_1);
        long v6_1 = ((TextUnit)v4_1).unbox-impl();
        v4_1 = ((List)arg14).get(3);
        Saver v8 = SaversKt.getSaver(TextIndent.Companion);
        if((Intrinsics.areEqual(v4_1, v2)) && !(v8 instanceof NonNullValueClassSaver)) {
            goto label_62;
        }
        else if(v4_1 != null) {
            v4_1 = v8.restore(v4_1);
        }
        else {
        label_62:
            v4_1 = v5;
        }

        Object v8_1 = ((List)arg14).get(4);
        Saver v9 = Savers_androidKt.getSaver(PlatformParagraphStyle.Companion);
        if((Intrinsics.areEqual(v8_1, v2)) && !(v9 instanceof NonNullValueClassSaver)) {
            goto label_75;
        }
        else if(v8_1 != null) {
            v8_1 = v9.restore(v8_1);
        }
        else {
        label_75:
            v8_1 = v5;
        }

        Object v9_1 = ((List)arg14).get(5);
        Saver v10 = SaversKt.getSaver(LineHeightStyle.Companion);
        if((Intrinsics.areEqual(v9_1, v2)) && !(v10 instanceof NonNullValueClassSaver)) {
            goto label_88;
        }
        else if(v9_1 != null) {
            v9_1 = v10.restore(v9_1);
        }
        else {
        label_88:
            v9_1 = v5;
        }

        Object v10_1 = ((List)arg14).get(6);
        Saver v11 = Savers_androidKt.getSaver(LineBreak.Companion);
        if((Intrinsics.areEqual(v10_1, v2)) && !(v11 instanceof NonNullValueClassSaver)) {
            goto label_101;
        }
        else if(v10_1 != null) {
            v10_1 = v11.restore(v10_1);
        }
        else {
        label_101:
            v10_1 = v5;
        }

        Intrinsics.checkNotNull(v10_1);
        int v10_2 = ((LineBreak)v10_1).unbox-impl();
        Object v11_1 = ((List)arg14).get(7);
        Saver v12 = SaversKt.getSaver(Hyphens.Companion);
        if((Intrinsics.areEqual(v11_1, v2)) && !(v12 instanceof NonNullValueClassSaver)) {
            goto label_116;
        }
        else if(v11_1 != null) {
            v11_1 = v12.restore(v11_1);
        }
        else {
        label_116:
            v11_1 = v5;
        }

        Intrinsics.checkNotNull(v11_1);
        int v11_2 = ((Hyphens)v11_1).unbox-impl();
        arg14 = ((List)arg14).get(8);
        v12 = Savers_androidKt.getSaver(TextMotion.Companion);
        if((Intrinsics.areEqual(arg14, v2)) && !(v12 instanceof NonNullValueClassSaver)) {
        }
        else if(arg14 != null) {
            v5 = v12.restore(arg14);
        }

        return new ParagraphStyle(v1_1, v3_2, v6_1, v4_1, v8_1, v9_1, v10_2, v11_2, v5, null);
    }

    static final Object ShadowSaver$lambda$0(SaverScope arg3, Shadow arg4) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Color.box-impl(arg4.getColor-0d7_KjU()), SaversKt.getSaver(Color.Companion), arg3), SaversKt.save(Offset.box-impl(arg4.getOffset-F1C5BW0()), SaversKt.getSaver(Offset.Companion), arg3), SaversKt.save(Float.valueOf(arg4.getBlurRadius()))});
    }

    static final Shadow ShadowSaver$lambda$1(Object arg9) {
        Intrinsics.checkNotNull(arg9, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Boolean v2 = Boolean.valueOf(false);
        Object v1 = ((List)arg9).get(0);
        Saver v3 = SaversKt.getSaver(Color.Companion);
        Object v5 = null;
        if((Intrinsics.areEqual(v1, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v1 != null) {
            v1 = v3.restore(v1);
        }
        else {
        label_17:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        long v3_1 = ((Color)v1).unbox-impl();
        v1 = ((List)arg9).get(1);
        Saver v6 = SaversKt.getSaver(Offset.Companion);
        if((Intrinsics.areEqual(v1, v2)) && !(v6 instanceof NonNullValueClassSaver)) {
            goto label_32;
        }
        else if(v1 != null) {
            v1 = v6.restore(v1);
        }
        else {
        label_32:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        long v1_1 = ((Offset)v1).unbox-impl();
        arg9 = ((List)arg9).get(2);
        if(arg9 != null) {
            v5 = arg9;
        }

        Intrinsics.checkNotNull(v5);
        return new Shadow(v3_1, v1_1, ((Number)v5).floatValue(), null);
    }

    static final Object SpanStyleSaver$lambda$0(SaverScope arg17, SpanStyle arg18) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Color.box-impl(arg18.getColor-0d7_KjU()), SaversKt.getSaver(Color.Companion), arg17), SaversKt.save(TextUnit.box-impl(arg18.getFontSize-XSAIIZE()), SaversKt.getSaver(TextUnit.Companion), arg17), SaversKt.save(arg18.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), arg17), SaversKt.save(arg18.getFontStyle-4Lr2A7w(), SaversKt.getSaver(FontStyle.Companion), arg17), SaversKt.save(arg18.getFontSynthesis-ZQGJjVo(), SaversKt.getSaver(FontSynthesis.Companion), arg17), SaversKt.save(Integer.valueOf(-1)), SaversKt.save(arg18.getFontFeatureSettings()), SaversKt.save(TextUnit.box-impl(arg18.getLetterSpacing-XSAIIZE()), SaversKt.getSaver(TextUnit.Companion), arg17), SaversKt.save(arg18.getBaselineShift-5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), arg17), SaversKt.save(arg18.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), arg17), SaversKt.save(arg18.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), arg17), SaversKt.save(Color.box-impl(arg18.getBackground-0d7_KjU()), SaversKt.getSaver(Color.Companion), arg17), SaversKt.save(arg18.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), arg17), SaversKt.save(arg18.getShadow(), SaversKt.getSaver(Shadow.Companion), arg17)});
    }

    static final SpanStyle SpanStyleSaver$lambda$1(Object arg24) {
        long v20;
        long v18;
        Object v15_1;
        Object v17;
        SpanStyle v16;
        Object v6;
        Object v0 = arg24;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        SpanStyle v1 = null;
        Boolean v3 = Boolean.valueOf(false);
        Object v2 = ((List)v0).get(0);
        Saver v4 = SaversKt.getSaver(Color.Companion);
        if((Intrinsics.areEqual(v2, v3)) && !(v4 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v2 != null) {
            v2 = v4.restore(v2);
        }
        else {
        label_17:
            v2 = null;
        }

        Intrinsics.checkNotNull(v2);
        long v4_1 = ((Color)v2).unbox-impl();
        v2 = ((List)v0).get(1);
        Saver v7 = SaversKt.getSaver(TextUnit.Companion);
        if((Intrinsics.areEqual(v2, v3)) && !(v7 instanceof NonNullValueClassSaver)) {
            goto label_32;
        }
        else if(v2 != null) {
            v2 = v7.restore(v2);
        }
        else {
        label_32:
            v2 = null;
        }

        Intrinsics.checkNotNull(v2);
        long v7_1 = ((TextUnit)v2).unbox-impl();
        v2 = ((List)v0).get(2);
        Saver v9 = SaversKt.getSaver(FontWeight.Companion);
        if((Intrinsics.areEqual(v2, v3)) && !(v9 instanceof NonNullValueClassSaver)) {
            goto label_47;
        }
        else if(v2 != null) {
            v2 = v9.restore(v2);
        }
        else {
        label_47:
            v2 = null;
        }

        Object v9_1 = ((List)v0).get(3);
        Saver v10 = SaversKt.getSaver(FontStyle.Companion);
        if((Intrinsics.areEqual(v9_1, v3)) && !(v10 instanceof NonNullValueClassSaver)) {
            goto label_60;
        }
        else if(v9_1 != null) {
            v9_1 = v10.restore(v9_1);
        }
        else {
        label_60:
            v9_1 = null;
        }

        Object v10_1 = ((List)v0).get(4);
        Saver v11 = SaversKt.getSaver(FontSynthesis.Companion);
        if((Intrinsics.areEqual(v10_1, v3)) && !(v11 instanceof NonNullValueClassSaver)) {
            goto label_73;
        }
        else if(v10_1 != null) {
            v10_1 = v11.restore(v10_1);
        }
        else {
        label_73:
            v10_1 = null;
        }

        Object v11_1 = ((List)v0).get(6);
        if(v11_1 != null) {
        }
        else {
            v11_1 = null;
        }

        Object v12 = ((List)v0).get(7);
        Saver v13 = SaversKt.getSaver(TextUnit.Companion);
        if((Intrinsics.areEqual(v12, v3)) && !(v13 instanceof NonNullValueClassSaver)) {
            goto label_91;
        }
        else if(v12 != null) {
            v12 = v13.restore(v12);
        }
        else {
        label_91:
            v12 = null;
        }

        Intrinsics.checkNotNull(v12);
        long v12_1 = ((TextUnit)v12).unbox-impl();
        Object v14 = ((List)v0).get(8);
        Saver v15 = SaversKt.getSaver(BaselineShift.Companion);
        if((Intrinsics.areEqual(v14, v3)) && !(v15 instanceof NonNullValueClassSaver)) {
            goto label_106;
        }
        else if(v14 != null) {
            v6 = v15.restore(v14);
        }
        else {
        label_106:
            v6 = null;
        }

        v14 = ((List)v0).get(9);
        v15 = SaversKt.getSaver(TextGeometricTransform.Companion);
        if(Intrinsics.areEqual(v14, v3)) {
            v16 = v1;
            if(!(v15 instanceof NonNullValueClassSaver)) {
                goto label_122;
            }
            else {
                goto label_118;
            }
        }
        else {
            v16 = v1;
        label_118:
            if(v14 != null) {
                v14 = v15.restore(v14);
            }
            else {
            label_122:
                TextGeometricTransform v14_1 = null;
            }
        }

        Object v1_1 = ((List)v0).get(10);
        v15 = SaversKt.getSaver(LocaleList.Companion);
        if(Intrinsics.areEqual(v1_1, v3)) {
            v17 = v2;
            if(!(v15 instanceof NonNullValueClassSaver)) {
                goto label_138;
            }
            else {
                goto label_134;
            }
        }
        else {
            v17 = v2;
        label_134:
            if(v1_1 != null) {
                v15_1 = v15.restore(v1_1);
            }
            else {
            label_138:
                LocaleList v15_2 = null;
            }
        }

        v1_1 = ((List)v0).get(11);
        Saver v2_1 = SaversKt.getSaver(Color.Companion);
        if(Intrinsics.areEqual(v1_1, v3)) {
            v18 = v4_1;
            if(!(v2_1 instanceof NonNullValueClassSaver)) {
                goto label_153;
            }
            else {
                goto label_150;
            }
        }
        else {
            v18 = v4_1;
        label_150:
            if(v1_1 != null) {
                v1_1 = v2_1.restore(v1_1);
            }
            else {
            label_153:
                v1_1 = null;
            }
        }

        Intrinsics.checkNotNull(v1_1);
        long v1_2 = ((Color)v1_1).unbox-impl();
        Object v4_2 = ((List)v0).get(12);
        Saver v5 = SaversKt.getSaver(TextDecoration.Companion);
        if(Intrinsics.areEqual(v4_2, v3)) {
            v20 = v1_2;
            if(!(v5 instanceof NonNullValueClassSaver)) {
                goto label_170;
            }
            else {
                goto label_167;
            }
        }
        else {
            v20 = v1_2;
        label_167:
            if(v4_2 != null) {
                v1_1 = v5.restore(v4_2);
            }
            else {
            label_170:
                v1_1 = null;
            }
        }

        v0 = ((List)v0).get(13);
        v2_1 = SaversKt.getSaver(Shadow.Companion);
        if((Intrinsics.areEqual(v0, v3)) && !(v2_1 instanceof NonNullValueClassSaver)) {
            goto label_183;
        }
        else if(v0 != null) {
            v0 = v2_1.restore(v0);
        }
        else {
        label_183:
            v0 = null;
        }

        super(v18, v7_1, v17, v9_1, v10_1, null, v11_1, v12_1, v6, ((TextGeometricTransform)v14), ((LocaleList)v15_1), v20, v1_1, v0, null, null, 0xC020, null);
        return v16;
    }

    static final Object TextAlignSaver$lambda$0(SaverScope arg0, TextAlign arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final TextAlign TextAlignSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return TextAlign.box-impl(TextAlign.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object TextDecorationSaver$lambda$0(SaverScope arg0, TextDecoration arg1) {
        return Integer.valueOf(arg1.getMask());
    }

    static final TextDecoration TextDecorationSaver$lambda$1(Object arg2) {
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type kotlin.Int");
        return new TextDecoration(((Integer)arg2).intValue());
    }

    static final Object TextDirectionSaver$lambda$0(SaverScope arg0, TextDirection arg1) {
        return Integer.valueOf(arg1.unbox-impl());
    }

    static final TextDirection TextDirectionSaver$lambda$1(Object arg1) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.Int");
        return TextDirection.box-impl(TextDirection.constructor-impl(((Integer)arg1).intValue()));
    }

    static final Object TextGeometricTransformSaver$lambda$0(SaverScope arg2, TextGeometricTransform arg3) {
        return CollectionsKt.arrayListOf(new Float[]{Float.valueOf(arg3.getScaleX()), Float.valueOf(arg3.getSkewX())});
    }

    static final TextGeometricTransform TextGeometricTransformSaver$lambda$1(Object arg3) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        return new TextGeometricTransform(((List)arg3).get(0).floatValue(), ((List)arg3).get(1).floatValue());
    }

    static final Object TextIndentSaver$lambda$0(SaverScope arg3, TextIndent arg4) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(TextUnit.box-impl(arg4.getFirstLine-XSAIIZE()), SaversKt.getSaver(TextUnit.Companion), arg3), SaversKt.save(TextUnit.box-impl(arg4.getRestLine-XSAIIZE()), SaversKt.getSaver(TextUnit.Companion), arg3)});
    }

    static final TextIndent TextIndentSaver$lambda$1(Object arg8) {
        Intrinsics.checkNotNull(arg8, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Boolean v2 = Boolean.valueOf(false);
        Object v1 = ((List)arg8).get(0);
        Saver v3 = SaversKt.getSaver(TextUnit.Companion);
        Object v5 = null;
        if((Intrinsics.areEqual(v1, v2)) && !(v3 instanceof NonNullValueClassSaver)) {
            goto label_17;
        }
        else if(v1 != null) {
            v1 = v3.restore(v1);
        }
        else {
        label_17:
            v1 = v5;
        }

        Intrinsics.checkNotNull(v1);
        long v3_1 = ((TextUnit)v1).unbox-impl();
        arg8 = ((List)arg8).get(1);
        Saver v1_1 = SaversKt.getSaver(TextUnit.Companion);
        if((Intrinsics.areEqual(arg8, v2)) && !(v1_1 instanceof NonNullValueClassSaver)) {
        }
        else if(arg8 != null) {
            v5 = v1_1.restore(arg8);
        }

        Intrinsics.checkNotNull(v5);
        return new TextIndent(v3_1, ((TextUnit)v5).unbox-impl(), null);
    }

    static final Object TextLinkStylesSaver$lambda$0(SaverScope arg4, TextLinkStyles arg5) {
        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(arg5.getStyle(), SaversKt.SpanStyleSaver, arg4), SaversKt.save(arg5.getFocusedStyle(), SaversKt.SpanStyleSaver, arg4), SaversKt.save(arg5.getHoveredStyle(), SaversKt.SpanStyleSaver, arg4), SaversKt.save(arg5.getPressedStyle(), SaversKt.SpanStyleSaver, arg4)});
    }

    static final TextLinkStyles TextLinkStylesSaver$lambda$1(Object arg7) {
        SpanStyle v5_1;
        SpanStyle v3_1;
        Intrinsics.checkNotNull(arg7, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        Boolean v1 = Boolean.valueOf(false);
        Object v0 = ((List)arg7).get(0);
        Saver v2 = SaversKt.SpanStyleSaver;
        SpanStyle v4 = null;
        if((Intrinsics.areEqual(v0, v1)) && !(v2 instanceof NonNullValueClassSaver)) {
            goto label_15;
        }
        else if(v0 != null) {
            v0 = v2.restore(v0);
        }
        else {
        label_15:
            SpanStyle v0_1 = v4;
        }

        Object v3 = ((List)arg7).get(1);
        if((Intrinsics.areEqual(v3, v1)) && !(v2 instanceof NonNullValueClassSaver)) {
            goto label_26;
        }
        else if(v3 != null) {
            v3 = v2.restore(v3);
        }
        else {
        label_26:
            v3_1 = v4;
        }

        Object v5 = ((List)arg7).get(2);
        if((Intrinsics.areEqual(v5, v1)) && !(v2 instanceof NonNullValueClassSaver)) {
            goto label_37;
        }
        else if(v5 != null) {
            v5 = v2.restore(v5);
        }
        else {
        label_37:
            v5_1 = v4;
        }

        arg7 = ((List)arg7).get(3);
        if((Intrinsics.areEqual(arg7, v1)) && !(v2 instanceof NonNullValueClassSaver)) {
        }
        else if(arg7 != null) {
            Object v4_1 = v2.restore(arg7);
        }

        return new TextLinkStyles(((SpanStyle)v0), v3_1, v5_1, v4);
    }

    static final Object TextRangeSaver$lambda$0(SaverScope arg2, TextRange arg3) {
        return CollectionsKt.arrayListOf(new Integer[]{SaversKt.save(Integer.valueOf(TextRange.getStart-impl(arg3.unbox-impl()))), SaversKt.save(Integer.valueOf(TextRange.getEnd-impl(arg3.unbox-impl())))});
    }

    static final TextRange TextRangeSaver$lambda$1(Object arg3) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Object v0 = ((List)arg3).get(0);
        Object v1 = null;
        if(v0 != null) {
        }
        else {
            v0 = v1;
        }

        Intrinsics.checkNotNull(v0);
        int v0_1 = ((Number)v0).intValue();
        arg3 = ((List)arg3).get(1);
        if(arg3 != null) {
            v1 = arg3;
        }

        Intrinsics.checkNotNull(v1);
        return TextRange.box-impl(TextRangeKt.TextRange(v0_1, ((Number)v1).intValue()));
    }

    static final Object TextUnitSaver$lambda$0(SaverScope arg5, TextUnit arg6) {
        long v0 = TextUnit.Companion.getUnspecified-XSAIIZE();
        boolean v0_1 = arg6 == null ? false : TextUnit.equals-impl0(arg6.unbox-impl(), v0);
        if(v0_1) {
            return Boolean.valueOf(false);
        }

        return CollectionsKt.arrayListOf(new Object[]{SaversKt.save(Float.valueOf(TextUnit.getValue-impl(arg6.unbox-impl()))), SaversKt.save(TextUnitType.box-impl(TextUnit.getType-UIouoOA(arg6.unbox-impl())), SaversKt.getSaver(TextUnitType.Companion), arg5)});
    }

    static final TextUnit TextUnitSaver$lambda$1(Object arg4) {
        Boolean v1 = Boolean.valueOf(false);
        if(Intrinsics.areEqual(arg4, v1)) {
            return TextUnit.box-impl(TextUnit.Companion.getUnspecified-XSAIIZE());
        }

        Intrinsics.checkNotNull(arg4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        Object v0 = ((List)arg4).get(0);
        Object v2 = null;
        if(v0 != null) {
        }
        else {
            v0 = v2;
        }

        Intrinsics.checkNotNull(v0);
        float v0_1 = ((Number)v0).floatValue();
        arg4 = ((List)arg4).get(1);
        Saver v3 = SaversKt.getSaver(TextUnitType.Companion);
        if((Intrinsics.areEqual(arg4, v1)) && !(v3 instanceof NonNullValueClassSaver)) {
        }
        else if(arg4 != null) {
            v2 = v3.restore(arg4);
        }

        Intrinsics.checkNotNull(v2);
        return TextUnit.box-impl(TextUnitKt.TextUnit-anM5pPY(v0_1, ((TextUnitType)v2).unbox-impl()));
    }

    static final Object TextUnitTypeSaver$lambda$0(SaverScope arg4, TextUnitType arg5) {
        long v4 = arg5.unbox-impl();
        if(TextUnitType.equals-impl0(v4, TextUnitType.Companion.getEm-UIouoOA())) {
            return Integer.valueOf(0);
        }

        if(TextUnitType.equals-impl0(v4, TextUnitType.Companion.getSp-UIouoOA())) {
            return Integer.valueOf(1);
        }

        return Boolean.valueOf(false);
    }

    static final TextUnitType TextUnitTypeSaver$lambda$1(Object arg2) {
        if(Intrinsics.areEqual(arg2, Integer.valueOf(0))) {
            return TextUnitType.box-impl(TextUnitType.Companion.getEm-UIouoOA());
        }

        if(Intrinsics.areEqual(arg2, Integer.valueOf(1))) {
            return TextUnitType.box-impl(TextUnitType.Companion.getSp-UIouoOA());
        }

        return TextUnitType.box-impl(TextUnitType.Companion.getUnspecified-UIouoOA());
    }

    static final Object UrlAnnotationSaver$lambda$0(SaverScope arg0, UrlAnnotation arg1) {
        return SaversKt.save(arg1.getUrl());
    }

    static final UrlAnnotation UrlAnnotationSaver$lambda$1(Object arg1) {
        if(arg1 != null) {
        }
        else {
            arg1 = null;
        }

        Intrinsics.checkNotNull(arg1);
        return new UrlAnnotation(((String)arg1));
    }

    static final Object VerbatimTtsAnnotationSaver$lambda$0(SaverScope arg0, VerbatimTtsAnnotation arg1) {
        return SaversKt.save(arg1.getVerbatim());
    }

    static final VerbatimTtsAnnotation VerbatimTtsAnnotationSaver$lambda$1(Object arg1) {
        if(arg1 != null) {
        }
        else {
            arg1 = null;
        }

        Intrinsics.checkNotNull(arg1);
        return new VerbatimTtsAnnotation(((String)arg1));
    }

    public static final Saver getAnnotatedStringSaver() {
        return SaversKt.AnnotatedStringSaver;
    }

    private static void getAnnotationRangeSaver$annotations() {
    }

    public static final Saver getFontStyleSaver() {
        return SaversKt.FontStyleSaver;
    }

    public static final Saver getFontSynthesisSaver() {
        return SaversKt.FontSynthesisSaver;
    }

    public static final Saver getParagraphStyleSaver() {
        return SaversKt.ParagraphStyleSaver;
    }

    private static final Saver getSaver(Companion arg0) {
        return SaversKt.LineHeightStyleAlignmentSaver;
    }

    private static final Saver getSaver(androidx.compose.ui.text.style.LineHeightStyle$Trim$Companion arg0) {
        return SaversKt.LineHeightStyleTrimSaver;
    }

    private static final Saver getSaver(androidx.compose.ui.text.style.LineHeightStyle$Mode$Companion arg0) {
        return SaversKt.LineHeightStyleModeSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.intl.Locale$Companion arg0) {
        return SaversKt.LocaleSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextAlign$Companion arg0) {
        return SaversKt.TextAlignSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextDirection$Companion arg0) {
        return SaversKt.TextDirectionSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.unit.TextUnit$Companion arg0) {
        return SaversKt.TextUnitSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextIndent$Companion arg0) {
        return SaversKt.TextIndentSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.LineHeightStyle$Companion arg0) {
        return SaversKt.LineHeightStyleSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.Hyphens$Companion arg0) {
        return SaversKt.HyphensSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.graphics.Color$Companion arg0) {
        return SaversKt.ColorSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.geometry.Offset$Companion arg0) {
        return SaversKt.OffsetSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.font.FontWeight$Companion arg0) {
        return SaversKt.FontWeightSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.font.FontStyle$Companion arg0) {
        return SaversKt.FontStyleSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.font.FontSynthesis$Companion arg0) {
        return SaversKt.FontSynthesisSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.BaselineShift$Companion arg0) {
        return SaversKt.BaselineShiftSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextGeometricTransform$Companion arg0) {
        return SaversKt.TextGeometricTransformSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.intl.LocaleList$Companion arg0) {
        return SaversKt.LocaleListSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.style.TextDecoration$Companion arg0) {
        return SaversKt.TextDecorationSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.graphics.Shadow$Companion arg0) {
        return SaversKt.ShadowSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.unit.TextUnitType$Companion arg0) {
        return SaversKt.TextUnitTypeSaver;
    }

    public static final Saver getSaver(androidx.compose.ui.text.TextRange$Companion arg0) {
        return SaversKt.TextRangeSaver;
    }

    public static final Saver getSpanStyleSaver() {
        return SaversKt.SpanStyleSaver;
    }

    public static final Saver getTextLinkStylesSaver() {
        return SaversKt.TextLinkStylesSaver;
    }

    public static final NonNullValueClassSaver getTextUnitTypeSaver() {
        return SaversKt.TextUnitTypeSaver;
    }

    private static void getUrlAnnotationSaver$annotations() {
    }

    public static final Object restore(Object arg2) {
        if(arg2 != null) {
            Intrinsics.reifiedOperationMarker(1, "Result");
            return arg2;
        }

        return null;
    }

    public static final Object restore(Object arg2, Saver arg3) {
        Object v1 = null;
        if((Intrinsics.areEqual(arg2, Boolean.valueOf(false))) && !(arg3 instanceof NonNullValueClassSaver)) {
            return v1;
        }

        if(arg2 != null) {
            arg2 = arg3.restore(arg2);
            Intrinsics.reifiedOperationMarker(1, "Result");
            return arg2;
        }

        return v1;
    }

    public static final Object save(Object arg0) {
        return arg0;
    }

    public static final Object save(Object arg0, Saver arg1, SaverScope arg2) {
        if(arg0 != null) {
            arg0 = arg1.save(arg2, arg0);
            if(arg0 == null) {
            }
            else {
                return arg0;
            }
        }

        return Boolean.valueOf(false);
    }
}

