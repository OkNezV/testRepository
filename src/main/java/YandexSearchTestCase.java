import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Проверка, что при вводе текста <test>, рельтат сожержит слово <Испытание>
 * @author Oksana Nezlobina <nez_oksana@mail.ru>
 */
public class YandexSearchTestCase {
    private RestTemplate restTemplate;
    private final String api_url = "https://www.yandex.ru";

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void testSearchRequest(){
        String searchText = "test";
        String urlRequest = api_url +
                String.format("/search/?text=%s&lr=213", searchText);

        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

        ResponseEntity<String> searchResponse = restTemplate.getForEntity(urlRequest, String.class);
        System.out.println("---searchResponse---\n " + searchResponse + "\n---");

        // проверка, что метод suggestResponse вернул код состояния <Успех>
        Assert.assertEquals(HttpStatus.OK, searchResponse.getStatusCode());
        System.out.println("\nМетод вернул статус кода состояния, равный: " + searchResponse.getStatusCode());

        // проверка, что в результатах поиска есть слово <Испытание>
        Assert.assertTrue("В результате поиска нет слова <Испытание>",
                searchResponse.getBody().contains("испытание"));
        System.out.println("\nВ результате поиска есть слово <Испытание>: " + searchResponse.getBody().contains("испытание"));
    }

}