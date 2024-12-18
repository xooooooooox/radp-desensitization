package space.x9x.solutions.desensitization.sdk.test.handler;

import space.x9x.solutions.desensitization.sdk.handler.DesensitizationHandler;
import space.x9x.solutions.desensitization.sdk.test.annotation.Address;

/**
 * @author x9x
 * @since 2024-10-23 16:22
 */
public class AddressDesensitizationHandler implements DesensitizationHandler<Address> {

    @Override
    public String desensitize(String origin, Address annotation) {
        return origin + annotation.replacer();
    }
}

