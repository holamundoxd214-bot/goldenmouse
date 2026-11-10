package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder$DefaultImpls;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\'\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001A\u00028\u0000*\u00020\b2\u0006\u0010\t\u001A\u00020\nH$¢\u0006\u0002\u0010\u000BJ\u001D\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u0002H\u0014¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\u001D\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\nH\u0014¢\u0006\u0002\u0010\u0019J\u001D\u0010\u001A\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u001BH\u0014¢\u0006\u0002\u0010\u001CJ\u001D\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u001EH\u0014¢\u0006\u0002\u0010\u001FJ\u001D\u0010 \u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020!H\u0014¢\u0006\u0002\u0010\"J\u001D\u0010#\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020$H\u0014¢\u0006\u0002\u0010%J\u001D\u0010&\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\'H\u0014¢\u0006\u0002\u0010(J\u001D\u0010)\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020*H\u0014¢\u0006\u0002\u0010+J\u001D\u0010,\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020-H\u0014¢\u0006\u0002\u0010.J\u001D\u0010/\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u000200H\u0014¢\u0006\u0002\u00101J%\u00102\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u00103\u001A\u00020\b2\u0006\u00104\u001A\u00020\nH\u0014¢\u0006\u0002\u00105J\u001D\u00106\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00028\u00002\u0006\u00107\u001A\u00020\bH\u0014¢\u0006\u0002\u00108J\u0010\u00109\u001A\u00020\u00032\u0006\u0010:\u001A\u00020\bH\u0016J\u0018\u0010;\u001A\u00020*2\u0006\u0010<\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0002J\b\u0010=\u001A\u00020\u0011H\u0016J\b\u0010>\u001A\u00020\u0011H\u0016J\u000E\u0010?\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020*J\u000E\u0010@\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u001BJ\u000E\u0010A\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u001EJ\u000E\u0010B\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nJ\u000E\u0010C\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020!J\u000E\u0010D\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020$J\u000E\u0010E\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\'J\u000E\u0010F\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020-J\u000E\u0010G\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u000200J\u0016\u0010H\u001A\u00020\u00112\u0006\u00103\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ\u0010\u0010I\u001A\u00020\u00042\u0006\u0010:\u001A\u00020\bH\u0016J\u000E\u0010J\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\bJ\u0010\u0010K\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\bH\u0014J\u001E\u0010L\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020*J\u001E\u0010M\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u001BJ\u001E\u0010N\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u001EJ\u001E\u0010O\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\nJ\u001E\u0010P\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020!J\u001E\u0010Q\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020$J\u001E\u0010R\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\'J\u001E\u0010S\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020-J\u001E\u0010T\u001A\u00020\u00112\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0013\u001A\u000200J\u0016\u0010U\u001A\u00020\u00032\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nJ?\u0010V\u001A\u00020\u0011\"\n\b\u0001\u0010W*\u0004\u0018\u00010\u00022\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010X\u001A\b\u0012\u0004\u0012\u0002HW0Y2\u0006\u0010\u0013\u001A\u0002HWH\u0016¢\u0006\u0002\u0010ZJ?\u0010[\u001A\u00020\u0011\"\b\b\u0001\u0010W*\u00020\u00022\u0006\u0010:\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\f\u0010X\u001A\b\u0012\u0004\u0012\u0002HW0Y2\b\u0010\u0013\u001A\u0004\u0018\u0001HWH\u0016¢\u0006\u0002\u0010ZJ\u0015\u0010d\u001A\u00020\u00112\u0006\u0010e\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\r\u0010f\u001A\u00028\u0000H\u0004¢\u0006\u0002\u0010aR\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u001E\u0010\\\u001A\u0012\u0012\u0004\u0012\u00028\u00000]j\b\u0012\u0004\u0012\u00028\u0000`^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001A\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b`\u0010aR\u0016\u0010b\u001A\u0004\u0018\u00018\u00008DX\u0084\u0004¢\u0006\u0006\u001A\u0004\bc\u0010a¨\u0006g"}, d2={"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "<init>", "()V", "getTag", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeTaggedValue", "", "tag", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "encodeTaggedNonNullMark", "(Ljava/lang/Object;)V", "encodeTaggedNull", "encodeTaggedInt", "(Ljava/lang/Object;I)V", "encodeTaggedByte", "", "(Ljava/lang/Object;B)V", "encodeTaggedShort", "", "(Ljava/lang/Object;S)V", "encodeTaggedLong", "", "(Ljava/lang/Object;J)V", "encodeTaggedFloat", "", "(Ljava/lang/Object;F)V", "encodeTaggedDouble", "", "(Ljava/lang/Object;D)V", "encodeTaggedBoolean", "", "(Ljava/lang/Object;Z)V", "encodeTaggedChar", "", "(Ljava/lang/Object;C)V", "encodeTaggedString", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "encodeTaggedEnum", "enumDescriptor", "ordinal", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "encodeTaggedInline", "inlineDescriptor", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeInline", "descriptor", "encodeElement", "desc", "encodeNotNullMark", "encodeNull", "encodeBoolean", "encodeByte", "encodeShort", "encodeInt", "encodeLong", "encodeFloat", "encodeDouble", "encodeChar", "encodeString", "encodeEnum", "beginStructure", "endStructure", "endEncode", "encodeBooleanElement", "encodeByteElement", "encodeShortElement", "encodeIntElement", "encodeLongElement", "encodeFloatElement", "encodeDoubleElement", "encodeCharElement", "encodeStringElement", "encodeInlineElement", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "pushTag", "name", "popTag", "kotlinx-serialization-core"}, k=1, mv={2, 0, 0}, xi=0x30) @InternalSerializationApi public abstract class TaggedEncoder implements CompositeEncoder, Encoder {
    private final ArrayList tagStack;

    public TaggedEncoder() {
        super();
        this.tagStack = new ArrayList();
    }

    public CompositeEncoder beginCollection(SerialDescriptor arg1, int arg2) {
        return DefaultImpls.beginCollection(((Encoder)this), arg1, arg2);
    }

    public CompositeEncoder beginStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this;
    }

    public final void encodeBoolean(boolean arg2) {
        this.encodeTaggedBoolean(this.popTag(), arg2);
    }

    public final void encodeBooleanElement(SerialDescriptor arg2, int arg3, boolean arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedBoolean(this.getTag(arg2, arg3), arg4);
    }

    public final void encodeByte(byte arg2) {
        this.encodeTaggedByte(this.popTag(), arg2);
    }

    public final void encodeByteElement(SerialDescriptor arg2, int arg3, byte arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedByte(this.getTag(arg2, arg3), arg4);
    }

    public final void encodeChar(char arg2) {
        this.encodeTaggedChar(this.popTag(), arg2);
    }

    public final void encodeCharElement(SerialDescriptor arg2, int arg3, char arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedChar(this.getTag(arg2, arg3), arg4);
    }

    public final void encodeDouble(double arg2) {
        this.encodeTaggedDouble(this.popTag(), arg2);
    }

    public final void encodeDoubleElement(SerialDescriptor arg2, int arg3, double arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedDouble(this.getTag(arg2, arg3), arg4);
    }

    private final boolean encodeElement(SerialDescriptor arg1, int arg2) {
        this.pushTag(this.getTag(arg1, arg2));
        return 1;
    }

    public final void encodeEnum(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "enumDescriptor");
        this.encodeTaggedEnum(this.popTag(), arg2, arg3);
    }

    public final void encodeFloat(float arg2) {
        this.encodeTaggedFloat(this.popTag(), arg2);
    }

    public final void encodeFloatElement(SerialDescriptor arg2, int arg3, float arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedFloat(this.getTag(arg2, arg3), arg4);
    }

    public Encoder encodeInline(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.encodeTaggedInline(this.popTag(), arg2);
    }

    public final Encoder encodeInlineElement(SerialDescriptor arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        return this.encodeTaggedInline(this.getTag(arg2, arg3), arg2.getElementDescriptor(arg3));
    }

    public final void encodeInt(int arg2) {
        this.encodeTaggedInt(this.popTag(), arg2);
    }

    public final void encodeIntElement(SerialDescriptor arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedInt(this.getTag(arg2, arg3), arg4);
    }

    public final void encodeLong(long arg2) {
        this.encodeTaggedLong(this.popTag(), arg2);
    }

    public final void encodeLongElement(SerialDescriptor arg2, int arg3, long arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedLong(this.getTag(arg2, arg3), arg4);
    }

    public void encodeNotNullMark() {
        this.encodeTaggedNonNullMark(this.getCurrentTag());
    }

    public void encodeNull() {
        this.encodeTaggedNull(this.popTag());
    }

    public void encodeNullableSerializableElement(SerialDescriptor arg2, int arg3, SerializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "serializer");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeNullableSerializableValue(arg4, arg5);
        }
    }

    @ExperimentalSerializationApi public void encodeNullableSerializableValue(SerializationStrategy arg1, Object arg2) {
        DefaultImpls.encodeNullableSerializableValue(((Encoder)this), arg1, arg2);
    }

    public void encodeSerializableElement(SerialDescriptor arg2, int arg3, SerializationStrategy arg4, Object arg5) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "serializer");
        if(this.encodeElement(arg2, arg3)) {
            this.encodeSerializableValue(arg4, arg5);
        }
    }

    public void encodeSerializableValue(SerializationStrategy arg1, Object arg2) {
        DefaultImpls.encodeSerializableValue(((Encoder)this), arg1, arg2);
    }

    public final void encodeShort(short arg2) {
        this.encodeTaggedShort(this.popTag(), arg2);
    }

    public final void encodeShortElement(SerialDescriptor arg2, int arg3, short arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        this.encodeTaggedShort(this.getTag(arg2, arg3), arg4);
    }

    public final void encodeString(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "value");
        this.encodeTaggedString(this.popTag(), arg2);
    }

    public final void encodeStringElement(SerialDescriptor arg2, int arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        Intrinsics.checkNotNullParameter(arg4, "value");
        this.encodeTaggedString(this.getTag(arg2, arg3), arg4);
    }

    protected void encodeTaggedBoolean(Object arg1, boolean arg2) {
        this.encodeTaggedValue(arg1, Boolean.valueOf(arg2));
    }

    protected void encodeTaggedByte(Object arg1, byte arg2) {
        this.encodeTaggedValue(arg1, Byte.valueOf(arg2));
    }

    protected void encodeTaggedChar(Object arg1, char arg2) {
        this.encodeTaggedValue(arg1, Character.valueOf(arg2));
    }

    protected void encodeTaggedDouble(Object arg1, double arg2) {
        this.encodeTaggedValue(arg1, Double.valueOf(arg2));
    }

    protected void encodeTaggedEnum(Object arg2, SerialDescriptor arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "enumDescriptor");
        this.encodeTaggedValue(arg2, Integer.valueOf(arg4));
    }

    protected void encodeTaggedFloat(Object arg1, float arg2) {
        this.encodeTaggedValue(arg1, Float.valueOf(arg2));
    }

    protected Encoder encodeTaggedInline(Object arg2, SerialDescriptor arg3) {
        Intrinsics.checkNotNullParameter(arg3, "inlineDescriptor");
        this.pushTag(arg2);
        return this;
    }

    protected void encodeTaggedInt(Object arg1, int arg2) {
        this.encodeTaggedValue(arg1, Integer.valueOf(arg2));
    }

    protected void encodeTaggedLong(Object arg1, long arg2) {
        this.encodeTaggedValue(arg1, Long.valueOf(arg2));
    }

    protected void encodeTaggedNonNullMark(Object arg1) {
    }

    protected void encodeTaggedNull(Object arg1) {
        throw new SerializationException("null is not supported");
    }

    protected void encodeTaggedShort(Object arg1, short arg2) {
        this.encodeTaggedValue(arg1, Short.valueOf(arg2));
    }

    protected void encodeTaggedString(Object arg2, String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "value");
        this.encodeTaggedValue(arg2, arg3);
    }

    protected void encodeTaggedValue(Object arg3, Object arg4) {
        Intrinsics.checkNotNullParameter(arg4, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(arg4.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(this.getClass()) + " encoder");
    }

    protected void endEncode(SerialDescriptor arg1) {
        Intrinsics.checkNotNullParameter(arg1, "descriptor");
    }

    public final void endStructure(SerialDescriptor arg2) {
        Intrinsics.checkNotNullParameter(arg2, "descriptor");
        if(!this.tagStack.isEmpty()) {
            this.popTag();
        }

        this.endEncode(arg2);
    }

    protected final Object getCurrentTag() {
        return CollectionsKt.last(this.tagStack);
    }

    protected final Object getCurrentTagOrNull() {
        return CollectionsKt.lastOrNull(this.tagStack);
    }

    public SerializersModule getSerializersModule() {
        return SerializersModuleBuildersKt.EmptySerializersModule();
    }

    protected abstract Object getTag(SerialDescriptor arg1, int arg2);

    protected final Object popTag() {
        if(!this.tagStack.isEmpty()) {
            return this.tagStack.remove(CollectionsKt.getLastIndex(this.tagStack));
        }

        throw new SerializationException("No tag in stack for requested element");
    }

    protected final void pushTag(Object arg1) {
        this.tagStack.add(arg1);
    }

    @ExperimentalSerializationApi public boolean shouldEncodeElementDefault(SerialDescriptor arg1, int arg2) {
        return kotlinx.serialization.encoding.CompositeEncoder$DefaultImpls.shouldEncodeElementDefault(((CompositeEncoder)this), arg1, arg2);
    }
}

