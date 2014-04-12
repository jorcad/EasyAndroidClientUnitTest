package ca.sukhni.net.android.api.client.test;

import ca.sukhni.net.android.api.client.ApiClient;
import ca.sukhni.net.android.api.client.ApiClientBuilder;
import ca.sukhni.net.android.api.client.ApiClientHandler;
import ca.sukhni.net.android.api.client.HttpMethod;
import ca.sukhni.net.android.api.client.HttpResponseResult;
import ca.sukhni.net.android.api.client.MediaType;
import ca.sukhni.net.android.api.client.logger.Logger;
import junit.framework.TestCase;

public class EasyAndroidClientTest extends TestCase
{

	@Override
	protected void setUp() throws Exception
	{
		// TODO Auto-generated method stub
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception
	{
		// TODO Auto-generated method stub
		super.tearDown();
	}
	
	public ApiClient getApiClientForTest()
	{
		ApiClientBuilder apiClientBuilder = new ApiClientBuilder()
		.setBaseUri("https://play.google.com")
		.addPath("store","apps","details")
		.addParam("id", "ca.sukhni.net.android.api.client.test")
		.setSocketTimeout(4000)
		.setContentType(MediaType.TEXT_HTML)
		.setHttpMethod(HttpMethod.GET);
		
		return apiClientBuilder.build();
	}
	public void testBlockingEasyAndroidClient() throws Exception
	{
		ApiClient apiClient = getApiClientForTest();
		HttpResponseResult httpResponseResult =  apiClient.execute();
		
		Logger.debug("Response Code:" + httpResponseResult.getResponseCode());
		Logger.debug("Response Status Line:" + httpResponseResult.getResponseStatusLine());
		Logger.debug("Response Entity (String):" + httpResponseResult.getResponseEntity().getStringEntity());
	}
	
	public void testAsyncEasyAndroidClient() throws Exception
	{
		ApiClient apiClient = getApiClientForTest();
		
		apiClient.executeOnAsyncTask(new ApiClientHandler()
		{
			
			@Override
			public void onSuccessful(int responseCode, String responseStatus, HttpResponseResult response)
			{
				Logger.debug("onSuccessful");
				Logger.debug("Response Code:" + response.getResponseCode());
				Logger.debug("Response Status Line:" + response.getResponseStatusLine());
				Logger.debug("Response Entity (String):" + response.getResponseEntity().getStringEntity());
				
			}
			
			@Override
			public void onServerError(int responseCode, String responseStatus, HttpResponseResult response)
			{
				Logger.debug("onServerError");
				Logger.debug("Response Code:" + response.getResponseCode());
				Logger.debug("Response Status Line:" + response.getResponseStatusLine());
				Logger.debug("Response Entity (String):" + response.getResponseEntity().getStringEntity());
				
			}
			
			@Override
			public void onRedirection(int responseCode, String responseStatus, HttpResponseResult response)
			{
				Logger.debug("onRedirection");
				Logger.debug("Response Code:" + response.getResponseCode());
				Logger.debug("Response Status Line:" + response.getResponseStatusLine());
				Logger.debug("Response Entity (String):" + response.getResponseEntity().getStringEntity());
				
			}
			
			@Override
			public void onInformational(int responseCode, String responseStatus, HttpResponseResult response)
			{
				Logger.debug("onInformational");
				Logger.debug("Response Code:" + response.getResponseCode());
				Logger.debug("Response Status Line:" + response.getResponseStatusLine());
				Logger.debug("Response Entity (String):" + response.getResponseEntity().getStringEntity());
				
			}
			
			@Override
			public void onException(Exception e)
			{
				Logger.debug("onException");
				Logger.printStackTrace(e);
				
			}
			
			@Override
			public void onClientError(int responseCode, String responseStatus, HttpResponseResult response)
			{
				Logger.debug("onClientError");
				Logger.debug("Response Code:" + response.getResponseCode());
				Logger.debug("Response Status Line:" + response.getResponseStatusLine());
				Logger.debug("Response Entity (String):" + response.getResponseEntity().getStringEntity());
				
			}
		});
		
		Thread.sleep(7000);
	}
	
	
}
