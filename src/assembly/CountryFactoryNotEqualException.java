package assembly;

import car.Country;
import java.util.Arrays;

public class CountryFactoryNotEqualException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE =
            "отличаются страны фабрики и сборочной линии: \"%s\"";
    private final Country[] countries;

    public CountryFactoryNotEqualException(Country[] countries) {
        this.countries = countries;
    }

    @Override
    public String getMessage() {
        return String.format(MESSAGE_TEMPLATE, Arrays.toString(countries));
    }
}
