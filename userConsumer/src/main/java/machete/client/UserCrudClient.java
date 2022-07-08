
package machete.client;

import machete.UsersApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "userCrudClient", url = "${userCrud.url}/${userCrud.context-path}")
public interface UserCrudClient extends UsersApi {

}
