package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.autofill.FillableData;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1={"\u0000ú\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0010\u001A\u0013\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\u0002¢\u0006\u0002\u0010\u0002\u001A\u001D\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001A\u00020\u0006H\u0080\b\u001A=\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0004\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u001E\b\b\u0010\u0007\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\bH\u0080\b\u001A-\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\n0\u0004\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\u0005\u001A\u00020\u0006H\u0082\b\u001A\n\u0010!\u001A\u00020\"*\u00020\u000F\u001A\n\u0010\'\u001A\u00020\"*\u00020\u000F\u001A\f\u0010@\u001A\u00020\"*\u00020\u000FH\u0007\u001A\n\u0010A\u001A\u00020\"*\u00020\u000F\u001A\n\u0010i\u001A\u00020\"*\u00020\u000F\u001A\n\u0010j\u001A\u00020\"*\u00020\u000F\u001A\u000B\u0010²\u0001\u001A\u00020\"*\u00020\u000F\u001A\u0014\u0010³\u0001\u001A\u00020\"*\u00020\u000F2\u0007\u0010´\u0001\u001A\u00020\u0006\u001A#\u0010µ\u0001\u001A\u00020\"*\u00020\u000F2\u0016\u0010¶\u0001\u001A\u0011\u0012\u0005\u0012\u00030¸\u0001\u0012\u0005\u0012\u00030¹\u00010·\u0001\u001A\u000B\u0010Å\u0001\u001A\u00020\"*\u00020\u000F\u001A8\u0010Î\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u001E\u0010Ð\u0001\u001A\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030Ò\u00010Ñ\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A*\u0010Ó\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010Õ\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001AW\u0010Ö\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062=\u0010Ð\u0001\u001A8\u0012\u0015\u0012\u00130W¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Ø\u0001\u0012\u0015\u0012\u00130W¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Ù\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u001AK\u0010Ú\u0001\u001A\u00020\"*\u00020\u000F28\u0010Ð\u0001\u001A3\b\u0001\u0012\u0016\u0012\u00140Û\u0001¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(Ü\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030Û\u00010Ý\u0001\u0012\u0007\u0012\u0005\u0018\u00010¸\u00010\b¢\u0006\u0003\u0010Þ\u0001\u001A/\u0010ß\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0015\u0010Ð\u0001\u001A\u0010\u0012\u0005\u0012\u00030¹\u0001\u0012\u0004\u0012\u00020\f0·\u0001\u001A2\u0010à\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001H\u0007\u001A0\u0010á\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A0\u0010â\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A/\u0010x\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A/\u0010}\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A0\u0010ã\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A*\u0010ä\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A0\u0010å\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0016\u0010Ð\u0001\u001A\u0011\u0012\u0004\u0012\u00020t\u0012\u0004\u0012\u00020\f\u0018\u00010·\u0001\u001A=\u0010æ\u0001\u001A\u00020\"*\u00020\u000F2\b\u0010ç\u0001\u001A\u00030\u0090\u00012\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001¢\u0006\u0006\bè\u0001\u0010é\u0001\u001A,\u0010ê\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001H\u0007\u001Aq\u0010ë\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062W\u0010Ð\u0001\u001AR\u0012\u0016\u0012\u00140¹\u0001¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(í\u0001\u0012\u0016\u0012\u00140¹\u0001¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(î\u0001\u0012\u0015\u0012\u00130\f¢\u0006\u000E\b×\u0001\u0012\t\b\u0005\u0012\u0005\b\b(ï\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010ì\u0001\u001A*\u0010ð\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ñ\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ò\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ó\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ô\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010õ\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ö\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010÷\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ø\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ù\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010ú\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0004\u0012\u00020\f\u0018\u00010Ô\u0001\u001A*\u0010û\u0001\u001A\u00020\"*\u00020\u000F2\u000B\b\u0002\u0010Ï\u0001\u001A\u0004\u0018\u00010\u00062\u0010\u0010Ð\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010W0Ô\u0001\"(\u0010\u000E\u001A\u00020\u0006*\u00020\u000F2\u0006\u0010\r\u001A\u00020\u00068F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"/\u0010\u0015\u001A\u00020\u0006*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00068F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013*\u0004\b\u0016\u0010\u0017\"/\u0010\u001B\u001A\u00020\u001A*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u001A8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 *\u0004\b\u001C\u0010\u0017\"/\u0010#\u001A\u00020\u0006*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00068F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013*\u0004\b$\u0010\u0017\"/\u0010)\u001A\u00020(*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020(8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.*\u0004\b*\u0010\u0017\"/\u0010/\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b1\u00102\"\u0004\b3\u00104*\u0004\b0\u0010\u0017\"5\u00105\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0087\u008E\u0002¢\u0006\u0018\u0012\u0004\b6\u00107\u001A\u0004\b5\u00102\"\u0004\b9\u00104*\u0004\b8\u0010\u0017\"/\u0010:\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b:\u00102\"\u0004\b<\u00104*\u0004\b;\u0010\u0017\"/\u0010=\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b=\u00102\"\u0004\b?\u00104*\u0004\b>\u0010\u0017\"/\u0010C\u001A\u00020B*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020B8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bE\u0010F\"\u0004\bG\u0010H*\u0004\bD\u0010\u0017\"/\u0010J\u001A\u00020I*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020I8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bL\u0010M\"\u0004\bN\u0010O*\u0004\bK\u0010\u0017\"/\u0010Q\u001A\u00020P*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020P8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bS\u0010T\"\u0004\bU\u0010V*\u0004\bR\u0010\u0017\"/\u0010X\u001A\u00020W*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020W8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]*\u0004\bY\u0010\u0017\"/\u0010_\u001A\u00020^*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020^8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\ba\u0010b\"\u0004\bc\u0010d*\u0004\b`\u0010\u0017\"/\u0010e\u001A\u00020^*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020^8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bg\u0010b\"\u0004\bh\u0010d*\u0004\bf\u0010\u0017\"/\u0010l\u001A\u00020k*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020k8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\bn\u0010,\"\u0004\bo\u0010.*\u0004\bm\u0010\u0017\"/\u0010p\u001A\u00020\u0006*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u00068F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\br\u0010\u0011\"\u0004\bs\u0010\u0013*\u0004\bq\u0010\u0017\"(\u0010u\u001A\u00020t*\u00020\u000F2\u0006\u0010\r\u001A\u00020t8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\bv\u0010w\"\u0004\bx\u0010y\"/\u0010z\u001A\u00020t*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020t8F@FX\u0086\u008E\u0002¢\u0006\u0012\u001A\u0004\b|\u0010w\"\u0004\b}\u0010y*\u0004\b{\u0010\u0017\"0\u0010~\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0013\u001A\u0004\b~\u00102\"\u0005\b\u0080\u0001\u00104*\u0004\b\u007F\u0010\u0017\"3\u0010\u0081\u0001\u001A\u00020t*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020t8F@FX\u0086\u008E\u0002¢\u0006\u0015\u001A\u0005\b\u0083\u0001\u0010w\"\u0005\b\u0084\u0001\u0010y*\u0005\b\u0082\u0001\u0010\u0017\"3\u0010\u0085\u0001\u001A\u00020t*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020t8F@FX\u0086\u008E\u0002¢\u0006\u0015\u001A\u0005\b\u0087\u0001\u0010w\"\u0005\b\u0088\u0001\u0010y*\u0005\b\u0086\u0001\u0010\u0017\"7\u0010\u008A\u0001\u001A\u00030\u0089\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030\u0089\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\b\u008C\u0001\u0010\u008D\u0001\"\u0006\b\u008E\u0001\u0010\u008F\u0001*\u0005\b\u008B\u0001\u0010\u0017\"<\u0010\u0091\u0001\u001A\u00030\u0090\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030\u0090\u00018G@GX\u0087\u008E\u0002¢\u0006\u001C\u0012\u0005\b\u0092\u0001\u00107\u001A\u0005\b\u0094\u0001\u0010,\"\u0005\b\u0095\u0001\u0010.*\u0005\b\u0093\u0001\u0010\u0017\"3\u0010\u0096\u0001\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0015\u001A\u0005\b\u0098\u0001\u00102\"\u0005\b\u0099\u0001\u00104*\u0005\b\u0097\u0001\u0010\u0017\"7\u0010\u009B\u0001\u001A\u00030\u009A\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030\u009A\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\b\u009D\u0001\u0010\u009E\u0001\"\u0006\b\u009F\u0001\u0010 \u0001*\u0005\b\u009C\u0001\u0010\u0017\"7\u0010¢\u0001\u001A\u00030¡\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030¡\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001*\u0005\b£\u0001\u0010\u0017\"7\u0010©\u0001\u001A\u00030¨\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030¨\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\b«\u0001\u0010¬\u0001\"\u0006\b­\u0001\u0010®\u0001*\u0005\bª\u0001\u0010\u0017\"3\u0010¯\u0001\u001A\u00020\f*\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\f8F@FX\u0086\u008E\u0002¢\u0006\u0015\u001A\u0005\b¯\u0001\u00102\"\u0005\b±\u0001\u00104*\u0005\b°\u0001\u0010\u0017\"5\u0010º\u0001\u001A\u00030¹\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030¹\u00018F@FX\u0086\u008E\u0002¢\u0006\u0015\u001A\u0005\b¼\u0001\u0010,\"\u0005\b½\u0001\u0010.*\u0005\b»\u0001\u0010\u0017\"7\u0010¿\u0001\u001A\u00030¾\u0001*\u00020\u000F2\u0007\u0010\u0014\u001A\u00030¾\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001*\u0005\bÀ\u0001\u0010\u0017\"E\u0010È\u0001\u001A\n\u0012\u0005\u0012\u00030Ç\u00010Æ\u0001*\u00020\u000F2\u000E\u0010\u0014\u001A\n\u0012\u0005\u0012\u00030Ç\u00010Æ\u00018F@FX\u0086\u008E\u0002¢\u0006\u0017\u001A\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001*\u0005\bÉ\u0001\u0010\u0017¨\u0006ü\u0001"}, d2={"throwSemanticsGetNotSupported", "T", "()Ljava/lang/Object;", "AccessibilityKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "name", "", "mergePolicy", "Lkotlin/Function2;", "ActionPropertyKey", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function;", "", "value", "contentDescription", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "<set-?>", "stateDescription", "getStateDescription$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getStateDescription", "setStateDescription", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo$delegate", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "heading", "", "paneTitle", "getPaneTitle$delegate", "getPaneTitle", "setPaneTitle", "disabled", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion$delegate", "getLiveRegion", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setLiveRegion-hR3wRGc", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "focused", "getFocused$delegate", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "isContainer", "isContainer$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "isContainer$delegate", "setContainer", "isTraversalGroup", "isTraversalGroup$delegate", "setTraversalGroup", "isSensitiveData", "isSensitiveData$delegate", "setSensitiveData", "invisibleToUser", "hideFromAccessibility", "Landroidx/compose/ui/autofill/ContentType;", "contentType", "getContentType$delegate", "getContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", "setContentType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentType;)V", "Landroidx/compose/ui/autofill/ContentDataType;", "contentDataType", "getContentDataType$delegate", "getContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", "setContentDataType", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/ContentDataType;)V", "Landroidx/compose/ui/autofill/FillableData;", "fillableData", "getFillableData$delegate", "getFillableData", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/FillableData;", "setFillableData", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/autofill/FillableData;)V", "", "traversalIndex", "getTraversalIndex$delegate", "getTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", "setTraversalIndex", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;F)V", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange$delegate", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "verticalScrollAxisRange", "getVerticalScrollAxisRange$delegate", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "popup", "dialog", "Landroidx/compose/ui/semantics/Role;", "role", "getRole$delegate", "getRole", "setRole-kuIjeqM", "testTag", "getTestTag$delegate", "getTestTag", "setTestTag", "Landroidx/compose/ui/text/AnnotatedString;", "text", "getText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "textSubstitution", "getTextSubstitution$delegate", "getTextSubstitution", "setTextSubstitution", "isShowingTextSubstitution", "isShowingTextSubstitution$delegate", "setShowingTextSubstitution", "inputText", "getInputText$delegate", "getInputText", "setInputText", "editableText", "getEditableText$delegate", "getEditableText", "setEditableText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange$delegate", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction$annotations", "getImeAction$delegate", "getImeAction", "setImeAction-4L7nppU", "selected", "getSelected$delegate", "getSelected", "setSelected", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "getCollectionInfo$delegate", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo$delegate", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState$delegate", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "isEditable", "isEditable$delegate", "setEditable", "password", "error", "description", "indexForKey", "mapping", "Lkotlin/Function1;", "", "", "maxTextLength", "getMaxTextLength$delegate", "getMaxTextLength", "setMaxTextLength", "Landroidx/compose/ui/graphics/Shape;", "shape", "getShape$delegate", "getShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/graphics/Shape;)V", "selectableGroup", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions$delegate", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "getTextLayoutResult", "label", "action", "", "Landroidx/compose/ui/text/TextLayoutResult;", "onClick", "Lkotlin/Function0;", "onLongClick", "scrollBy", "Lkotlin/ParameterName;", "x", "y", "scrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function2;)V", "scrollToIndex", "onAutofillText", "onFillData", "setProgress", "showTextSubstitution", "clearTextSubstitution", "insertTextAtCursor", "onImeAction", "imeActionType", "onImeAction-9UiTYpY", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;ILjava/lang/String;Lkotlin/jvm/functions/Function0;)V", "performImeAction", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "relativeToOriginalText", "copyText", "cutText", "pasteText", "expand", "collapse", "dismiss", "requestFocus", "pageUp", "pageDown", "pageLeft", "pageRight", "getScrollViewportLength", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class SemanticsPropertiesKt {
    static {
        KProperty[] v0 = new KProperty[30];
        Class v2 = SemanticsPropertiesKt.class;
        v0[0] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1));
        v0[1] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1));
        v0[2] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1));
        v0[3] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1));
        v0[4] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[5] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[6] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[7] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "isSensitiveData", "isSensitiveData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[8] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "contentType", "getContentType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentType;", 1));
        v0[9] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "contentDataType", "getContentDataType(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/ContentDataType;", 1));
        v0[10] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "fillableData", "getFillableData(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/autofill/FillableData;", 1));
        v0[11] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1));
        v0[12] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1));
        v0[13] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1));
        v0[14] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1));
        v0[15] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1));
        v0[16] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "textSubstitution", "getTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1));
        v0[17] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "isShowingTextSubstitution", "isShowingTextSubstitution(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[18] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "inputText", "getInputText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1));
        v0[19] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1));
        v0[20] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1));
        v0[21] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1));
        v0[22] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[23] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1));
        v0[24] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1));
        v0[25] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1));
        v0[26] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "isEditable", "isEditable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1));
        v0[27] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "maxTextLength", "getMaxTextLength(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1));
        v0[28] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "shape", "getShape(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/graphics/Shape;", 1));
        v0[29] = Reflection.mutableProperty1(new MutablePropertyReference1Impl(v2, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1));
        SemanticsPropertiesKt.$$delegatedProperties = v0;
        SemanticsProperties.INSTANCE.getStateDescription();
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
        SemanticsProperties.INSTANCE.getPaneTitle();
        SemanticsProperties.INSTANCE.getLiveRegion();
        SemanticsProperties.INSTANCE.getFocused();
        SemanticsProperties.INSTANCE.getIsContainer();
        SemanticsProperties.INSTANCE.getIsTraversalGroup();
        SemanticsProperties.INSTANCE.getIsSensitiveData();
        SemanticsProperties.INSTANCE.getContentType();
        SemanticsProperties.INSTANCE.getContentDataType();
        SemanticsProperties.INSTANCE.getFillableData();
        SemanticsProperties.INSTANCE.getTraversalIndex();
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        SemanticsProperties.INSTANCE.getRole();
        SemanticsProperties.INSTANCE.getTestTag();
        SemanticsProperties.INSTANCE.getTextSubstitution();
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution();
        SemanticsProperties.INSTANCE.getInputText();
        SemanticsProperties.INSTANCE.getEditableText();
        SemanticsProperties.INSTANCE.getTextSelectionRange();
        SemanticsProperties.INSTANCE.getImeAction();
        SemanticsProperties.INSTANCE.getSelected();
        SemanticsProperties.INSTANCE.getCollectionInfo();
        SemanticsProperties.INSTANCE.getCollectionItemInfo();
        SemanticsProperties.INSTANCE.getToggleableState();
        SemanticsProperties.INSTANCE.getIsEditable();
        SemanticsProperties.INSTANCE.getMaxTextLength();
        SemanticsProperties.INSTANCE.getShape();
        SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final SemanticsPropertyKey AccessibilityKey(String arg2) {
        return new SemanticsPropertyKey(arg2, true);
    }

    public static final SemanticsPropertyKey AccessibilityKey(String arg7, Function2 arg8) {
        return new SemanticsPropertyKey(arg7, true, arg8, null, 8, null);
    }

    private static final SemanticsPropertyKey ActionPropertyKey(String arg8) {
        return new SemanticsPropertyKey(arg8, true, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE, null, 8, null);
    }

    public static final Object access$throwSemanticsGetNotSupported() {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final void clearTextSubstitution(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getClearTextSubstitution(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void clearTextSubstitution$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.clearTextSubstitution(arg0, arg1, arg2);
    }

    public static final void collapse(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void collapse$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.collapse(arg0, arg1, arg2);
    }

    public static final void copyText(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void copyText$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.copyText(arg0, arg1, arg2);
    }

    public static final void cutText(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void cutText$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.cutText(arg0, arg1, arg2);
    }

    public static final void dialog(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final void disabled(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final void dismiss(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void dismiss$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.dismiss(arg0, arg1, arg2);
    }

    public static final void error(SemanticsPropertyReceiver arg1, String arg2) {
        arg1.set(SemanticsProperties.INSTANCE.getError(), arg2);
    }

    public static final void expand(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void expand$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.expand(arg0, arg1, arg2);
    }

    public static final CollectionInfo getCollectionInfo(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getCollectionInfo().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[23]);
    }

    private static Object getCollectionInfo$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getCollectionInfo();
    }

    public static final CollectionItemInfo getCollectionItemInfo(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[24]);
    }

    private static Object getCollectionItemInfo$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getCollectionItemInfo();
    }

    public static final ContentDataType getContentDataType(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getContentDataType().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[9]);
    }

    private static Object getContentDataType$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getContentDataType();
    }

    public static final String getContentDescription(SemanticsPropertyReceiver arg0) {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final ContentType getContentType(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getContentType().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[8]);
    }

    private static Object getContentType$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getContentType();
    }

    public static final List getCustomActions(SemanticsPropertyReceiver arg3) {
        return SemanticsActions.INSTANCE.getCustomActions().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[29]);
    }

    private static Object getCustomActions$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsActions.INSTANCE.getCustomActions();
    }

    public static final AnnotatedString getEditableText(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getEditableText().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[19]);
    }

    private static Object getEditableText$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getEditableText();
    }

    public static final FillableData getFillableData(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getFillableData().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[10]);
    }

    private static Object getFillableData$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getFillableData();
    }

    public static final boolean getFocused(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getFocused().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[4]).booleanValue();
    }

    private static Object getFocused$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getFocused();
    }

    public static final ScrollAxisRange getHorizontalScrollAxisRange(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[12]);
    }

    private static Object getHorizontalScrollAxisRange$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
    }

    @Deprecated(message="Pass the ImeAction to onImeAction instead.") public static final int getImeAction(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getImeAction().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[21]).unbox-impl();
    }

    @Deprecated(message="Pass the ImeAction to onImeAction instead.") public static void getImeAction$annotations(SemanticsPropertyReceiver arg0) {
    }

    private static Object getImeAction$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getImeAction();
    }

    public static final AnnotatedString getInputText(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getInputText().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[18]);
    }

    private static Object getInputText$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getInputText();
    }

    public static final int getLiveRegion(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getLiveRegion().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[3]).unbox-impl();
    }

    private static Object getLiveRegion$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getLiveRegion();
    }

    public static final int getMaxTextLength(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getMaxTextLength().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[27]).intValue();
    }

    private static Object getMaxTextLength$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getMaxTextLength();
    }

    public static final String getPaneTitle(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getPaneTitle().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[2]);
    }

    private static Object getPaneTitle$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getPaneTitle();
    }

    public static final ProgressBarRangeInfo getProgressBarRangeInfo(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[1]);
    }

    private static Object getProgressBarRangeInfo$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
    }

    public static final int getRole(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getRole().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[14]).unbox-impl();
    }

    private static Object getRole$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getRole();
    }

    public static final void getScrollViewportLength(SemanticsPropertyReceiver arg3, String arg4, Function0 arg5) {
        arg3.set(SemanticsActions.INSTANCE.getGetScrollViewportLength(), new AccessibilityAction(arg4, new SemanticsPropertiesKt$getScrollViewportLength$1(arg5)));
    }

    public static void getScrollViewportLength$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.getScrollViewportLength(arg0, arg1, arg2);
    }

    public static final boolean getSelected(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getSelected().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[22]).booleanValue();
    }

    private static Object getSelected$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getSelected();
    }

    public static final Shape getShape(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getShape().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[28]);
    }

    private static Object getShape$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getShape();
    }

    public static final String getStateDescription(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getStateDescription().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[0]);
    }

    private static Object getStateDescription$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getStateDescription();
    }

    public static final String getTestTag(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getTestTag().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[15]);
    }

    private static Object getTestTag$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getTestTag();
    }

    public static final AnnotatedString getText(SemanticsPropertyReceiver arg0) {
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void getTextLayoutResult$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.getTextLayoutResult(arg0, arg1, arg2);
    }

    public static final long getTextSelectionRange(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[20]).unbox-impl();
    }

    private static Object getTextSelectionRange$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getTextSelectionRange();
    }

    public static final AnnotatedString getTextSubstitution(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getTextSubstitution().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[16]);
    }

    private static Object getTextSubstitution$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getTextSubstitution();
    }

    public static final ToggleableState getToggleableState(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getToggleableState().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[25]);
    }

    private static Object getToggleableState$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getToggleableState();
    }

    public static final float getTraversalIndex(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getTraversalIndex().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[11]).floatValue();
    }

    private static Object getTraversalIndex$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getTraversalIndex();
    }

    public static final ScrollAxisRange getVerticalScrollAxisRange(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[13]);
    }

    private static Object getVerticalScrollAxisRange$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
    }

    public static final void heading(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final void hideFromAccessibility(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getHideFromAccessibility(), Unit.INSTANCE);
    }

    public static final void indexForKey(SemanticsPropertyReceiver arg1, Function1 arg2) {
        arg1.set(SemanticsProperties.INSTANCE.getIndexForKey(), arg2);
    }

    public static final void insertTextAtCursor(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getInsertTextAtCursor(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void insertTextAtCursor$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.insertTextAtCursor(arg0, arg1, arg2);
    }

    @Deprecated(message="Use `hideFromAccessibility()` instead.", replaceWith="<_subannotation>") public static final void invisibleToUser(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final boolean isContainer(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getIsContainer().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[5]).booleanValue();
    }

    @Deprecated(message="Use `isTraversalGroup` instead.", replaceWith="<_subannotation>") public static void isContainer$annotations(SemanticsPropertyReceiver arg0) {
    }

    private static Object isContainer$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getIsContainer();
    }

    public static final boolean isEditable(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getIsEditable().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[26]).booleanValue();
    }

    private static Object isEditable$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getIsEditable();
    }

    public static final boolean isSensitiveData(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getIsSensitiveData().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[7]).booleanValue();
    }

    private static Object isSensitiveData$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getIsSensitiveData();
    }

    public static final boolean isShowingTextSubstitution(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[17]).booleanValue();
    }

    private static Object isShowingTextSubstitution$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getIsShowingTextSubstitution();
    }

    public static final boolean isTraversalGroup(SemanticsPropertyReceiver arg3) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup().getValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[6]).booleanValue();
    }

    private static Object isTraversalGroup$delegate(SemanticsPropertyReceiver arg0) {
        return SemanticsProperties.INSTANCE.getIsTraversalGroup();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use onFillData instead", replaceWith="<_subannotation>") public static final void onAutofillText(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getOnAutofillText(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void onAutofillText$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.onAutofillText(arg0, arg1, arg2);
    }

    public static final void onClick(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void onClick$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.onClick(arg0, arg1, arg2);
    }

    public static final void onFillData(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getOnFillData(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void onFillData$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.onFillData(arg0, arg1, arg2);
    }

    public static final void onImeAction-9UiTYpY(SemanticsPropertyReceiver arg1, int arg2, String arg3, Function0 arg4) {
        arg1.set(SemanticsProperties.INSTANCE.getImeAction(), ImeAction.box-impl(arg2));
        arg1.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void onImeAction-9UiTYpY$default(SemanticsPropertyReceiver arg0, int arg1, String arg2, Function0 arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = null;
        }

        SemanticsPropertiesKt.onImeAction-9UiTYpY(arg0, arg1, arg2, arg3);
    }

    public static final void onLongClick(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void onLongClick$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.onLongClick(arg0, arg1, arg2);
    }

    public static final void pageDown(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getPageDown(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void pageDown$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.pageDown(arg0, arg1, arg2);
    }

    public static final void pageLeft(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getPageLeft(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void pageLeft$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.pageLeft(arg0, arg1, arg2);
    }

    public static final void pageRight(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getPageRight(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void pageRight$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.pageRight(arg0, arg1, arg2);
    }

    public static final void pageUp(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getPageUp(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void pageUp$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.pageUp(arg0, arg1, arg2);
    }

    public static final void password(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void pasteText(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void pasteText$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.pasteText(arg0, arg1, arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use `SemanticsPropertyReceiver.onImeAction` instead.", replaceWith="<_subannotation>") public static final void performImeAction(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getOnImeAction(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void performImeAction$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.performImeAction(arg0, arg1, arg2);
    }

    public static final void popup(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void requestFocus(SemanticsPropertyReceiver arg2, String arg3, Function0 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void requestFocus$default(SemanticsPropertyReceiver arg0, String arg1, Function0 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.requestFocus(arg0, arg1, arg2);
    }

    public static final void scrollBy(SemanticsPropertyReceiver arg2, String arg3, Function2 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void scrollBy$default(SemanticsPropertyReceiver arg0, String arg1, Function2 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.scrollBy(arg0, arg1, arg2);
    }

    public static final void scrollByOffset(SemanticsPropertyReceiver arg1, Function2 arg2) {
        arg1.set(SemanticsActions.INSTANCE.getScrollByOffset(), arg2);
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void scrollToIndex$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.scrollToIndex(arg0, arg1, arg2);
    }

    public static final void selectableGroup(SemanticsPropertyReceiver arg2) {
        arg2.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver arg3, CollectionInfo arg4) {
        SemanticsProperties.INSTANCE.getCollectionInfo().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[23], arg4);
    }

    public static final void setCollectionItemInfo(SemanticsPropertyReceiver arg3, CollectionItemInfo arg4) {
        SemanticsProperties.INSTANCE.getCollectionItemInfo().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[24], arg4);
    }

    public static final void setContainer(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getIsContainer().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[5], Boolean.valueOf(arg4));
    }

    public static final void setContentDataType(SemanticsPropertyReceiver arg3, ContentDataType arg4) {
        SemanticsProperties.INSTANCE.getContentDataType().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[9], arg4);
    }

    public static final void setContentDescription(SemanticsPropertyReceiver arg1, String arg2) {
        arg1.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(arg2));
    }

    public static final void setContentType(SemanticsPropertyReceiver arg3, ContentType arg4) {
        SemanticsProperties.INSTANCE.getContentType().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[8], arg4);
    }

    public static final void setCustomActions(SemanticsPropertyReceiver arg3, List arg4) {
        SemanticsActions.INSTANCE.getCustomActions().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[29], arg4);
    }

    public static final void setEditable(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getIsEditable().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[26], Boolean.valueOf(arg4));
    }

    public static final void setEditableText(SemanticsPropertyReceiver arg3, AnnotatedString arg4) {
        SemanticsProperties.INSTANCE.getEditableText().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[19], arg4);
    }

    public static final void setFillableData(SemanticsPropertyReceiver arg3, FillableData arg4) {
        SemanticsProperties.INSTANCE.getFillableData().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[10], arg4);
    }

    public static final void setFocused(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getFocused().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[4], Boolean.valueOf(arg4));
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver arg3, ScrollAxisRange arg4) {
        SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[12], arg4);
    }

    @Deprecated(message="Pass the ImeAction to onImeAction instead.") public static final void setImeAction-4L7nppU(SemanticsPropertyReceiver arg3, int arg4) {
        SemanticsProperties.INSTANCE.getImeAction().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[21], ImeAction.box-impl(arg4));
    }

    public static final void setInputText(SemanticsPropertyReceiver arg3, AnnotatedString arg4) {
        SemanticsProperties.INSTANCE.getInputText().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[18], arg4);
    }

    public static final void setLiveRegion-hR3wRGc(SemanticsPropertyReceiver arg3, int arg4) {
        SemanticsProperties.INSTANCE.getLiveRegion().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[3], LiveRegionMode.box-impl(arg4));
    }

    public static final void setMaxTextLength(SemanticsPropertyReceiver arg3, int arg4) {
        SemanticsProperties.INSTANCE.getMaxTextLength().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[27], Integer.valueOf(arg4));
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver arg3, String arg4) {
        SemanticsProperties.INSTANCE.getPaneTitle().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[2], arg4);
    }

    public static final void setProgress(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void setProgress$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.setProgress(arg0, arg1, arg2);
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver arg3, ProgressBarRangeInfo arg4) {
        SemanticsProperties.INSTANCE.getProgressBarRangeInfo().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[1], arg4);
    }

    public static final void setRole-kuIjeqM(SemanticsPropertyReceiver arg3, int arg4) {
        SemanticsProperties.INSTANCE.getRole().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[14], Role.box-impl(arg4));
    }

    public static final void setSelected(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getSelected().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[22], Boolean.valueOf(arg4));
    }

    public static final void setSelection(SemanticsPropertyReceiver arg2, String arg3, Function3 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void setSelection$default(SemanticsPropertyReceiver arg0, String arg1, Function3 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.setSelection(arg0, arg1, arg2);
    }

    public static final void setSensitiveData(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getIsSensitiveData().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[7], Boolean.valueOf(arg4));
    }

    public static final void setShape(SemanticsPropertyReceiver arg3, Shape arg4) {
        SemanticsProperties.INSTANCE.getShape().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[28], arg4);
    }

    public static final void setShowingTextSubstitution(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getIsShowingTextSubstitution().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[17], Boolean.valueOf(arg4));
    }

    public static final void setStateDescription(SemanticsPropertyReceiver arg3, String arg4) {
        SemanticsProperties.INSTANCE.getStateDescription().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[0], arg4);
    }

    public static final void setTestTag(SemanticsPropertyReceiver arg3, String arg4) {
        SemanticsProperties.INSTANCE.getTestTag().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[15], arg4);
    }

    public static final void setText(SemanticsPropertyReceiver arg1, AnnotatedString arg2) {
        arg1.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(arg2));
    }

    public static final void setText(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void setText$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.setText(arg0, arg1, arg2);
    }

    public static final void setTextSelectionRange-FDrldGo(SemanticsPropertyReceiver arg3, long arg4) {
        SemanticsProperties.INSTANCE.getTextSelectionRange().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[20], TextRange.box-impl(arg4));
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver arg3, AnnotatedString arg4) {
        SemanticsProperties.INSTANCE.getTextSubstitution().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[16], arg4);
    }

    public static final void setTextSubstitution(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getSetTextSubstitution(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void setTextSubstitution$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.setTextSubstitution(arg0, arg1, arg2);
    }

    public static final void setToggleableState(SemanticsPropertyReceiver arg3, ToggleableState arg4) {
        SemanticsProperties.INSTANCE.getToggleableState().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[25], arg4);
    }

    public static final void setTraversalGroup(SemanticsPropertyReceiver arg3, boolean arg4) {
        SemanticsProperties.INSTANCE.getIsTraversalGroup().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[6], Boolean.valueOf(arg4));
    }

    public static final void setTraversalIndex(SemanticsPropertyReceiver arg3, float arg4) {
        SemanticsProperties.INSTANCE.getTraversalIndex().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[11], Float.valueOf(arg4));
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver arg3, ScrollAxisRange arg4) {
        SemanticsProperties.INSTANCE.getVerticalScrollAxisRange().setValue(arg3, SemanticsPropertiesKt.$$delegatedProperties[13], arg4);
    }

    public static final void showTextSubstitution(SemanticsPropertyReceiver arg2, String arg3, Function1 arg4) {
        arg2.set(SemanticsActions.INSTANCE.getShowTextSubstitution(), new AccessibilityAction(arg3, ((Function)arg4)));
    }

    public static void showTextSubstitution$default(SemanticsPropertyReceiver arg0, String arg1, Function1 arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg1 = null;
        }

        SemanticsPropertiesKt.showTextSubstitution(arg0, arg1, arg2);
    }

    private static final Object throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }
}

