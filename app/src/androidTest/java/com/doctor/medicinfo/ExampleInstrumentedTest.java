<<<<<<< Updated upstream:RidzJAV/app/src/androidTest/java/com/comicflix/ridz_jav/ExampleInstrumentedTest.java
package com.comicflix.ridz_jav;
=======
package com.doctor.medicinfo;
>>>>>>> Stashed changes:MedicInfo/app/src/androidTest/java/com/doctor/medicinfo/ExampleInstrumentedTest.java

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
<<<<<<< Updated upstream:RidzJAV/app/src/androidTest/java/com/comicflix/ridz_jav/ExampleInstrumentedTest.java

        assertEquals("com.comicflix.ridz_jav", appContext.getPackageName());
=======
        assertEquals("com.doctor.medicinfo", appContext.getPackageName());
>>>>>>> Stashed changes:MedicInfo/app/src/androidTest/java/com/doctor/medicinfo/ExampleInstrumentedTest.java
    }
}