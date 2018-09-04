package project.selection.services.account.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Headers;
import project.selection.services.account.web.domain.AccountRest;

@FeignClient(name = "uaa-server")
public interface UAAServiceProxy {

	@PostMapping(value = "/uaa/create")
	String create(@RequestBody AccountRest accountRest);

	@Headers("X-Auth-Token: {access_token}")
	@DeleteMapping(value = "/uaa/{login}")
	String removeByLogin(@RequestParam("access_token") String accessToken, @PathVariable("login") String login);

}
