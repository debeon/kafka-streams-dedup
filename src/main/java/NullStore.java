import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.StateRestoreCallback;
import org.apache.kafka.streams.processor.StateStore;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.List;

public class NullStore implements KeyValueStore<Bytes, byte[]> {

    @Override
    public void put(Bytes key, byte[] value) {

    }

    @Override
    public byte[] putIfAbsent(Bytes key, byte[] value) {
        return new byte[0];
    }

    @Override
    public void putAll(List<KeyValue<Bytes, byte[]>> entries) {

    }

    @Override
    public byte[] delete(Bytes key) {
        return new byte[0];
    }

    @Override
    public String name() {
        return "NullStore";
    }

    @Override
    public void init(ProcessorContext context, StateStore root) {
        if (root != null) {
            context.register(root, false, new StateRestoreCallback() {
                @Override
                public void restore(byte[] key, byte[] value) {
                    if (value == null) {
                        delete(null);
                    } else {
                        put(null, null);
                    }
                }
            });
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean persistent() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @Override
    public byte[] get(Bytes key) {
        return new byte[0];
    }

    @Override
    public KeyValueIterator<Bytes, byte[]> range(Bytes from, Bytes to) {
        return null;
    }

    @Override
    public KeyValueIterator<Bytes, byte[]> all() {
        return null;
    }

    @Override
    public long approximateNumEntries() {
        return 0;
    }
}
