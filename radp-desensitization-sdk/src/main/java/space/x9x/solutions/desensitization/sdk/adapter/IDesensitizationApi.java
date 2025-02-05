package space.x9x.solutions.desensitization.sdk.adapter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import space.x9x.solutions.desensitization.api.dto.DesensitizationRuleRespDTO;

import java.util.List;

/**
 * @author x9x
 * @since 2024-12-03 11:32
 */
public interface IDesensitizationApi {

    @GET("/api/desensitization/rules")
    Call<List<DesensitizationRuleRespDTO>> getRules(@Query("system_id") String systemId);
}
