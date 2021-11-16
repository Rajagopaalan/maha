package com.yahoo.maha.maha_druid_lookups.server.lookup.namespace.entity;

import com.yahoo.maha.maha_druid_lookups.query.lookup.namespace.ExtractionNameSpaceSchemaType;
import com.yahoo.maha.maha_druid_lookups.server.lookup.namespace.schema.protobuf.ProtobufSchemaFactory;
import org.apache.druid.java.util.common.logger.Logger;
import org.apache.druid.java.util.emitter.service.ServiceEmitter;
import com.yahoo.maha.maha_druid_lookups.query.lookup.DecodeConfig;
import com.yahoo.maha.maha_druid_lookups.query.lookup.namespace.RocksDBExtractionNamespace;
import com.yahoo.maha.maha_druid_lookups.server.lookup.namespace.LookupService;
import org.rocksdb.RocksDB;

import java.util.Optional;

public class NoopCacheActionRunner extends CacheActionRunner {

    private static final Logger LOG = new Logger(NoopCacheActionRunner.class);

    @Override
    public byte[] getCacheValue(final String key
            , Optional<String> valueColumn
            , final Optional<DecodeConfig> decodeConfigOptional
            , RocksDB rocksDB
            , ProtobufSchemaFactory schemaFactory
            , LookupService lookupService
            , ServiceEmitter emitter
            , RocksDBExtractionNamespace extractionNamespace){
        LOG.error("Noop called, returning empty cache value.");
        return null;
    }

    @Override
    public void updateCache(ProtobufSchemaFactory schemaFactory
            , final String key
            , final byte[] value
            , RocksDB rocksDB
            , ServiceEmitter serviceEmitter
            , RocksDBExtractionNamespace extractionNamespace) {
        LOG.error("Noop called, no update to make.");
    }

    @Override
    public ExtractionNameSpaceSchemaType getSchemaType() {
        return ExtractionNameSpaceSchemaType.PROTOBUF;
    }

    @Override
    public String toString() {
        return "NoopCacheActionRunner{}";
    }
    
}
