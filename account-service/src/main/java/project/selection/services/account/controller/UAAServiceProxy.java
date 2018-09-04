package project.selection.services.account.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Headers;

@FeignClient(name = "uaa-server")
public interface UAAServiceProxy {

	@Headers("X-Auth-Token: {access_token}")
	@PostMapping(value = "/uaa/entra")
	String entra(@RequestParam("access_token") String accessToken);

}
