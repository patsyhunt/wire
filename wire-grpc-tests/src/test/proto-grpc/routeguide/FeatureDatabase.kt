// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: routeguide/RouteGuideProto.proto
package routeguide

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.TagHandler
import com.squareup.wire.WireField
import com.squareup.wire.internal.Internal
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * Not used in the RPC.  Instead, this is here for the form serialized to disk.
 */
data class FeatureDatabase(@field:WireField(tag = 1, adapter = "routeguide.Feature#ADAPTER")
    val feature: List<Feature> = emptyList(), val unknownFields: ByteString = ByteString.EMPTY) :
    Message<FeatureDatabase, FeatureDatabase.Builder>(ADAPTER, unknownFields) {
  @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Builder = Builder(this.copy())

  class Builder(private val message: FeatureDatabase) : Message.Builder<FeatureDatabase, Builder>()
      {
    override fun build(): FeatureDatabase = message
  }

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<FeatureDatabase> = object : ProtoAdapter<FeatureDatabase>(
      FieldEncoding.LENGTH_DELIMITED, 
      FeatureDatabase::class.java
    ) {
      override fun encodedSize(value: FeatureDatabase): Int = 
        Feature.ADAPTER.asRepeated().encodedSizeWithTag(1, value.feature) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: FeatureDatabase) {
        Feature.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.feature)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): FeatureDatabase {
        val feature = mutableListOf<Feature>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> feature.add(Feature.ADAPTER.decode(reader))
            else -> TagHandler.UNKNOWN_TAG
          }
        }
        return FeatureDatabase(
          feature = feature,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: FeatureDatabase): FeatureDatabase? = value.copy(
        feature = value.feature.also { Internal.redactElements(it, Feature.ADAPTER) },
        unknownFields = ByteString.EMPTY
      )
    }
  }
}
