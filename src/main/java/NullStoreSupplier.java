import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.KeyValueStore;

public class NullStoreSupplier implements KeyValueBytesStoreSupplier {

    private static final NullStore NULL_STORE = new NullStore();

    @Override
    public String name() {
        return "NullStore";
    }

    @Override
    public KeyValueStore<Bytes, byte[]> get() {
        return NULL_STORE;
    }

    @Override
    public String metricsScope() {
        return "NullStoreSupplier";
    }
}
