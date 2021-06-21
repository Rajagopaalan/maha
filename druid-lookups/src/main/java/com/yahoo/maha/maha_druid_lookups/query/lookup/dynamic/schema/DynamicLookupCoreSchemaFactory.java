package com.yahoo.maha.maha_druid_lookups.query.lookup.dynamic.schema;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.druid.java.util.common.logger.Logger;

public class DynamicLookupCoreSchemaFactory {

    private static final Logger LOG = new Logger(DynamicLookupCoreSchemaFactory.class);

    public static DynamicLookupCoreSchema buildSchema(SCHEMA_TYPE schemaType, JsonNode coreSchema) {
        DynamicLookupCoreSchema dynamicLookupCoreSchema = null;
        switch (schemaType) {
            case PROTOBUF:
                dynamicLookupCoreSchema = new DynamicLookupProtobufSchemaSerDe(coreSchema);
                break;

            case FLATBUFFER:
                dynamicLookupCoreSchema = new DynamicLookupFlatbufferSchemaSerDe(coreSchema);
                break;

            default:
                //should never reach this code
                LOG.error("Schema_type is not currently supported" + schemaType.toString());
                throw new IllegalArgumentException("Schema_type " + schemaType.toString() + "is not currently supported");

        }
        return dynamicLookupCoreSchema;
    }
}
