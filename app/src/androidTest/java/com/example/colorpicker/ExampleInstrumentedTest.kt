package com.example.colorpicker

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.jvm.internal.Intrinsics

@RunWith(AndroidJUnit4::class)

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val var10000 = InstrumentationRegistry.getInstrumentation()
        Intrinsics.checkNotNullExpressionValue(
            var10000,
            "InstrumentationRegistry.getInstrumentation()"
        )
        val appContext = var10000.targetContext
        Intrinsics.checkNotNullExpressionValue(appContext, "appContext")
        Assert.assertEquals("com.example.colorpicker", appContext.packageName)
    }
}
