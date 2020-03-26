package dev.iwhrim.city.exceptions;

import dev.iwhrim.city.controllers.CityController;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionsTests {

    private CityController cityController = new CityController();

    @Test
    public void invalidNameShouldThrowInvalidParameterValueException() {
        String nameWithNumbers = "C1t1 N4m3";
        Assertions.assertThatExceptionOfType(InvalidParameterValueException.class)
                .isThrownBy(() -> cityController.getCityByName(nameWithNumbers));

        String emptyName = "";
        Assertions.assertThatExceptionOfType(InvalidParameterValueException.class)
                .isThrownBy(() -> cityController.getCityByName(emptyName));
    }

    @Test
    public void invalidStateShouldThrowInvalidParameterValueException() {
        String stateWithNumbers = "R1";
        Assertions.assertThatExceptionOfType(InvalidParameterValueException.class)
                .isThrownBy(() -> cityController.getCityByState(stateWithNumbers));

        String emptyState = "";
        Assertions.assertThatExceptionOfType(InvalidParameterValueException.class)
                .isThrownBy(() -> cityController.getCityByState(emptyState));
    }

}
