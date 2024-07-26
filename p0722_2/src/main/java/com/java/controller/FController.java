package com.java.controller;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.OAuthTokenDto;

@Controller
public class FController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	// 카카오 회사에서 code값을 전달해 줌.
	@RequestMapping("/kakao/oauth") // @RequestParam(value="code") 
	@ResponseBody
	public String oauth(String code, OAuthTokenDto OauthTokenDto) {
		System.out.println("code :"+code);
		
		//------- 토큰 요청 -> 인터넷 url로 전송 : post -------
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		String grant_type = "authorization_code";
		String client_id = "8aa39506228971f3907fe95e6c5b8a88";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
		// code = code;
		
		// http 전송
		RestTemplate rt = new RestTemplate();
		
		// HttpHeaders 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content_type", content_type);
		
		// HttpBody 생성 - 여러개를 입력 Map 사용
//		Map<String, String> map = new HashMap<>();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		// HttpEntity - HttpHeaders, HttpBody 1개의 오브젝트로 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers);

		// Http 전송 - HttpEntity
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		ResponseEntity<String> response = rt.exchange(oauthUrl, HttpMethod.POST,kakaoTokenRequest,String.class);
	
		System.out.println("카카오 토큰 요청에 의한 응답 : "+response);
		
		//json파일을 java파일로 변경 => code copy 해서 붙였으나 에러
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthTokenDto oAuthTokenDto = null;
		
		try {
			oAuthTokenDto = objectMapper.readValue(response.getBody(), OAuthTokenDto.class);
		} catch (Exception e) { e.printStackTrace();}
		
		System.out.println("3. Access_token : "+oAuthTokenDto.getAccess_token());
		
		return "카카오 토큰 요청에 대한 응답 : "+oAuthTokenDto.getAccess_token();

	}


}
