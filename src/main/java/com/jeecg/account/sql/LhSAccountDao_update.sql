UPDATE lh_s_account
SET 
	   <#if lhSAccount.id ?exists>
		   ID = :lhSAccount.id,
		</#if>
	   <#if lhSAccount.accountName ?exists>
		   ACCOUNT_NAME = :lhSAccount.accountName,
		</#if>
	   <#if lhSAccount.appId ?exists>
		   APP_ID = :lhSAccount.appId,
		</#if>
	   <#if lhSAccount.appSecret ?exists>
		   APP_SECRET = :lhSAccount.appSecret,
		</#if>
	   <#if lhSAccount.userId ?exists>
		   USER_ID = :lhSAccount.userId,
		</#if>
	   <#if lhSAccount.lat ?exists>
		   lat = :lhSAccount.lat,
		</#if>
	   <#if lhSAccount.lng ?exists>
		   lng = :lhSAccount.lng,
		</#if>
	   <#if lhSAccount.aesKey ?exists>
		   aes_key = :lhSAccount.aesKey,
		</#if>
	   <#if lhSAccount.ivKey ?exists>
		   iv_key = :lhSAccount.ivKey,
		</#if>
	   <#if lhSAccount.smsAppid ?exists>
		   sms_appid = :lhSAccount.smsAppid,
		</#if>
	   <#if lhSAccount.smsAppkey ?exists>
		   sms_appkey = :lhSAccount.smsAppkey,
		</#if>
	   <#if lhSAccount.smsTemplateid ?exists>
		   sms_templateid = :lhSAccount.smsTemplateid,
		</#if>
WHERE id = :lhSAccount.id