package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage.RecipientType;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired 
	private JavaMailSender mailSender;

	@Override // test 이메일 전송
	public void email_send(String name, String email) {
		
		String pwCode = getCreateKey();
		System.out.println("랜덤 비밀번호 생성 :" + pwCode);
		
		// 문자만 전송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setFrom("이메일주소");
		message.setSubject(name+"님의 비밀번호가 초기화 되었습니다.\n");
		message.setText( "[ 임시비밀번호 : "+pwCode+" ]\n");
		mailSender.send(message);
		System.out.println(" 이메일 발송 완료!!");

	}
	
	@Override // html이메일 전송
	public void email_send2(String name, String email) {
		
		String pwCode = getCreateKey();
		System.out.println("랜덤 비밀번호 생성 :" + pwCode);
		
		// html 전송
		
		MimeMessage message = mailSender.createMimeMessage();

		
		try {
			message.setSubject("[안내]"+name+"님의 비밀번호가 초기화 되었습니다.","utf-8");
			String htmlData = "<tr>\r\n"
					+ "	<td style=\"width:700px;height:78px;padding:0;margin:0;vertical-align:top;\">\r\n"
					+ "		<p style=\"width:620px;margin:50px 0 40px 38px;text-align:center;font-size:0;line-height:0;\"><img src=\"../images/email/img_txt_password01.jpg\" alt=\"원두커피의 名家, JARDIN 임시 비밀번호가 발급되었습니다.\" /></p>\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "<tr>\r\n"
					+ "	<td style=\"width:700px;height:196px;padding:0;margin:0;vertical-align:top;\">\r\n"
					+ "		<table width=\"618\" height=\"194\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\" style=\"margin:0 0 0 40px;border:1px #d9d9d9 solid;\">\r\n"
					+ "		<tr>\r\n"
					+ "			<td style=\"width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#f9f9f9;\">\r\n"
					+ "				<p style=\"width:620px;margin:30px 0 0 0;padding:0;text-align:center;\"><img src=\"../images/email/img_txt_password02.jpg\" alt=\"JARDIN에서 비밀번호 찾기를 요청하셨습니다.\" /></p>\r\n"
					+ "				<p style=\"width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;\">아래의 PASSWORD는 임시 PASSWORD이므로 홈페이지 로그인 후 다시 수정해 주십시오.</p>\r\n"
					+ "				<p style=\"width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;\"><strong>임시 패스워드 : <span style=\"color:#f7703c;line-height:1;\">dasdw2341</span></strong></p>\r\n"
					+ "				<p style=\"width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;\">쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\r\n"
					+ "			</td>\r\n"
					+ "		</tr>\r\n"
					+ "		</table>	\r\n"
					+ "	</td>\r\n"
					+ "</tr>\r\n"
					+ "";
			
			message.setText(htmlData,"utf-8", "html");
			// 보내는 이메일 주소
			message.setFrom(new InternetAddress("danakim0209@gmail.com"));
			// 받는 이메일 주소
			message.addRecipient(RecipientType.TO, new InternetAddress(email));
			
			// 이메일 전송
			mailSender.send(message);
			
		} catch (MessagingException e) {}

		System.out.println(" 이메일 발송 완료!!");
	}
	

	// 비밀번호 생성 메서드
	public String getCreateKey() {
		char[] charSet = {
			'0','1','2','3','4','5','6','7','8','9',
			'A','B','C','D','E','F','G','H','I','J',	
			'K','L','M','N','O','P','Q','R','S','T',	
			'U','V','W','X','Y','Z'	
		};
		
		String pwCode = "";
		int idx = 0;
		for(int i=0;i<10;i++) {	
			idx = (int)(Math.random()*36);
			pwCode += ""+charSet[idx];	
		}

		return pwCode;
	}
}
