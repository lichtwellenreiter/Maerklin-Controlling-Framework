package de.cortex42.maerklin.testscript;

import de.cortex42.maerklin.framework.EthernetConnection;
import de.cortex42.maerklin.framework.FrameworkException;
import de.cortex42.maerklin.framework.scripting.Script;
import de.cortex42.maerklin.framework.scripting.ScriptContext;

/**
 * Created by ivo on 13.11.15.
 */
public final class Main {
    public static void main(final String[] args) {
        final int PC_PORT = 15730;
        final int CS2_PORT = 15731;
        final String CS2_IP_ADDRESS = "192.168.16.2";

        try (EthernetConnection ethernetConnection = new EthernetConnection(PC_PORT, CS2_PORT, CS2_IP_ADDRESS)) { //todo mit gleisbox testen
            final Script script = TestScript.getTestScript(new ScriptContext(ethernetConnection));
            script.execute();
        } catch (final FrameworkException e) {
            e.printStackTrace();
        }
    }
}
