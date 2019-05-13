package org.kfjava.weixin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kemao_1/weixin/recevier")
public class MessageReciverController {

		@GetMapping
		public String echo(
				@RequestParam("signature") String signature, //
				@RequestParam("timestamp") String timestamp, //
				@RequestParam("nonce") String nonce, //
				@RequestParam("echostr") String echostr
				) {
		
		return echostr;
		
	}
}

