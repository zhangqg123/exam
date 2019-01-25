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
WHERE id = :lhSAccount.id