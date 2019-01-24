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
WHERE id = :lhSAccount.id