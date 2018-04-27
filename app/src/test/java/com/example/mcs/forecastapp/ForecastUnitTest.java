package com.example.mcs.forecastapp;

import com.example.mcs.forecastapp.Model.DayModel;
import com.example.mcs.forecastapp.Model.ForecastModel;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ForecastUnitTest {

    @Test
    public void shouldUpdateDayModel() {

        //given
        DayModel model1 = new DayModel("03/10", 50,87,"Clear");
        DayModel model2 = new DayModel("03/10", 50,87,"Clear");

        //when
        model1.updateVals(40,90,"Clouds");
        model2.updateVals(55,80,"Clear");

        //then
        Assert.assertEquals(40, model1.getMinTemp());
        Assert.assertEquals(90,model1.getMaxTemp());
        Assert.assertEquals("Clear/Clouds",model1.getDescription());

        Assert.assertEquals(50, model2.getMinTemp());
        Assert.assertEquals(87,model2.getMaxTemp());
        Assert.assertEquals("Clear",model2.getDescription());

    }
}