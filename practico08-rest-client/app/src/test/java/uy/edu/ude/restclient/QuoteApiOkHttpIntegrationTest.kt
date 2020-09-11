package uy.edu.ude.restclient

import android.os.Build
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import uy.edu.ude.restclient.entities.Response
import uy.edu.ude.restclient.services.QuoteApiOkHttp

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class QuoteApiOkHttpIntegrationTest {

    @Test
    fun givenId_whenFindQuoteById_thenGetResponse() {
        //Arrange
        val urlService = "http://gturnquist-quoters.cfapps.io/"
        val api = QuoteApiOkHttp(urlService)
        val id = 2
        val expected = Response(
            "success",
            id,
            "With Boot you deploy everywhere you can find a JVM basically."
        )

        //Act
        val actual = api.findQuoteById(id.toString())

        //Assertions
        assertThat(actual).isEqualTo(expected)
    }
}