UPDATE signin_date
SET 
	   <#if signinDate.id ?exists>
		   ID = :signinDate.id,
		</#if>
	   <#if signinDate.openid ?exists>
		   OPENID = :signinDate.openid,
		</#if>
	   <#if signinDate.year ?exists>
		   YEAR = :signinDate.year,
		</#if>
	   <#if signinDate.month ?exists>
		   MONTH = :signinDate.month,
		</#if>
	   <#if signinDate.day ?exists>
		   DAY = :signinDate.day,
		</#if>
	    <#if signinDate.time ?exists>
		   TIME = :signinDate.time,
		</#if>
WHERE id = :signinDate.id