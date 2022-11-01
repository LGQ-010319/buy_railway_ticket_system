package com.LGQ.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LGQ.domain.Prep;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * 
 * @ClassName: AlipayServlet 
 * @Description: 支付宝支付接口 PC端   沙箱测试
 * @author: 刘国强
 * @date: 2022年6月1日 上午1:10:23
 */
public class AlipayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = "https://openapi.alipaydev.com/gateway.do";	//沙箱环境使用
		//String URL = "https://openapi.alipay.com/gateway.do"; 	//外网真实环境使用
		String APP_ID = "2021000120612307";  // 即创建应用后生成
		String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCa18yS5YIcBNJp7JFI7OoKIdVLchYySqwGfEL3B66WSooZHqS2ZJmKr4+OjvkPAQPNcDd11tChuS7830a9fhRCGlMAHDLxUF1LJOMxIrIBgz7L1PlAcsAFL25G9IyNGwAdTTJ8aUlk/5TdpLbs0sW1YjwAC+Yg8MLMFUHZFv/2+0yxmQ9jv1trb165kzcYa8l+ztUCM+PqCs1g1ONI/64p/CNgVLtzpcAaIa1XyDAuMXvhKM0lxqt9YDzdD0RmnLlvBMLrS5M6SoJ8YGdeZ7VU+msXirUK6Bq9F68PUnzTZpMsU+K21hSS1GIVcpTpe8AUNfrszBQG1EEaRMtCi1DNAgMBAAECggEAUlxUkRIImbSq4vKU+JAjkI4ccMvXKJr1U2HHELSCVaiCOghFnkp2LQFiv3Ym3acxiZWVulUvlcX1S0XLz8D/L4Xm/hkBs7+GUBDn01vcCNfxj+PRTEl8/4USCCXNmMRy1CMapnguNM2JNjeFoQQfa3I77d5mYsENLBZmdv032vtJEIVil/vILODg7wLFlq0OkqhG/uuh0f7UFx/NMAGFQ/r9pVnJ3HRbpEsaywmREnrOc+3LDM47E8Q7wAT8VczZpLZl6oIouSJIpOorckdTIufl2UXGDsIhJY3CvY3gAfD0ObIvEsFwbjBge42imb9QWLe4tKXP9kZ+bpC2R3L2YQKBgQD34A+dgoSN3PDR2+3oMQ3jZluU3qyS5EMnf+TbBqRlyFANuIQtAzjMphvfAgqXTLPmiOYenhqpAn3kIVMZk957QtUwrevirZNQulzBR1uJ53hwF48FCuM9RIfd7BEpfuz3/b3N0XbGa8SAJG97IAwLV/BXvWUmdFWsj4IfGPDaiQKBgQCf6xj8v+woAZgspbAGn0KKgx77b3eJUswxdOU4RHspFesVQ4fqp4SIDTmb6S5NgqU2HmV0hC53khprrb1TM45XxsvJE72nHFMv6cDYpjfNyq3ehshduQgiQ2hTqHQrm7ued544Z2+SEkmjH1vBO02/S7KDuokFaOj83H1ESEMjJQKBgG53nZ3tp9NtTqnIIOukyPK6EEB1SGWicscsuTpfaG6v6fVjcQx6bhrOQIePalbpaRdplVy5y1nc8Wv06grxGmrGayppqEF6Z7fHhkTg30vDK6qQ5T0zD/ijDQX7Cd77YPJYU/lgy1U8e/M7ya8Opi97/nGrx2Nu3yurPStMuzI5AoGABk9miwKftOxrLsfS7E/4djK6VD2Pv/FucT0lllTNb0+YGRyzDkVR63RqI4bN9u0Cy+HjKvfURY+UT09puxC7uyby/5oxz5hEiA13OJVGem5W8gLrgRc+BOwX/8UT4GyiuJwLuDoMovzpvvAL1NIcPUIlZyFDKt165A9nOfyH+akCgYBIJ/HMW/DMucrrxkjxS0uRnrSFJRTd8Z/mqkXjvN5NjlNSEXkfW8LNE8k0332pMNbGRdhhXIuDhdu4p1WbdN+S4mgIJ+zRW11w5u3uBPgJJs1HiuQv25/lR0zFyyN8Dsami+yztI1JCkIOJkI2e1EYY7uFjShdUPDtrRBy5Js1pg=="; //开发者私钥，由开发者自己生成
		String FORMAT = "json"; // 参数返回格式，只支持 json
		String CHARSET = "UTF-8"; // 编码集，支持 GBK/UTF-8
		String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmtfMkuWCHATSaeyRSOzqCiHVS3IWMkqsBnxC9weulkqKGR6ktmSZiq+Pjo75DwEDzXA3ddbQobku/N9GvX4UQhpTABwy8VBdSyTjMSKyAYM+y9T5QHLABS9uRvSMjRsAHU0yfGlJZP+U3aS27NLFtWI8AAvmIPDCzBVB2Rb/9vtMsZkPY79ba29euZM3GGvJfs7VAjPj6grNYNTjSP+uKfwjYFS7c6XAGiGtV8gwLjF74SjNJcarfWA83Q9EZpy5bwTC60uTOkqCfGBnXme1VPprF4q1CugavRevD1J802aTLFPittYUktRiFXKU6XvAFDX67MwUBtRBGkTLQotQzQIDAQAB"; //支付宝公钥，由支付宝生成
		String SIGN_TYPE = "RSA2"; // 商户生成签名字符串所使用的签名算法类型，目前支持 RSA2 和 RSA，推荐使用 RSA2

		// 从PayServlet获取的订单信息
		Prep prep = (Prep) request.getAttribute("prep");
		
		
		
        String out_trade_no = String.valueOf(new Date()) + String.valueOf(prep.getPrepId());  // 商户订单号，商户网站订单系统中唯一订单号，必填
        String total_amount = String.valueOf(prep.getPrice())+".00";  // 付款金额，必填
        String subject = prep.getStartStation()+"站 - "+prep.getEndStation() + "站    火车票";  // 商品名称
        //String returnUrl = "http://localhost:8080/ticketing/PayServlet?temp=1&prepId="+prep.getPrepId()+""; // 回跳地址
        String returnUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/dome4/PayServlet?temp=1&prepId="+prep.getPrepId()+"";
        
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(returnUrl);
		alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\""+out_trade_no+"\","
				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":"+total_amount+","
				+ "    \"subject\":\""+subject+"\"," + "    \"body\":\""+subject+"\","
				+ "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=" + CHARSET);
		response.getWriter().write(form);// 直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
