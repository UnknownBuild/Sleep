package studio.xmatrix.minecraft.sleep;

import net.fabricmc.api.DedicatedServerModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SleepServer implements DedicatedServerModInitializer {

    public  static final String LOGGER_NAME = "SleepServer";
    private static final Logger LOGGER = LogManager.getLogger(LOGGER_NAME);

    @Override
    public void onInitializeServer() {
    }
}
