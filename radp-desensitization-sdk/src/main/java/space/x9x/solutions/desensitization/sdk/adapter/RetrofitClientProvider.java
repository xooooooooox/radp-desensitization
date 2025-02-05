package space.x9x.solutions.desensitization.sdk.adapter;

import space.x9x.radp.commons.json.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author x9x
 * @since 2024-12-03 12:03
 */
@Slf4j
public class RetrofitClientProvider {

    public static final String DEFAULT_BASE_URL = "http://localhost:8888";

    private static Retrofit retrofit;

    private RetrofitClientProvider() {

    }

    public static Retrofit getInstance(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl == null ? DEFAULT_BASE_URL : baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create(JacksonUtils.getDefaultObjectMapper()))
                    .build();
        }
        log.info("SDK 以[定时获取模式]运行: will fetch latest rule from '{}'", baseUrl);
        return retrofit;
    }
}
