		<#if ( signinDate.id )?? && signinDate.id ?length gt 0>
		    /* id */
			and sd.ID = :signinDate.id
		</#if>
		<#if ( signinDate.openid )?? && signinDate.openid ?length gt 0>
		    /* openid */
			and sd.OPENID = :signinDate.openid
		</#if>
		<#if ( signinDate.year )?? && signinDate.year ?length gt 0>
		    /* 年 */
			and sd.YEAR = :signinDate.year
		</#if>
		<#if ( signinDate.month )?? && signinDate.month ?length gt 0>
		    /* 月 */
			and sd.MONTH = :signinDate.month
		</#if>
		<#if ( signinDate.day )?? && signinDate.day ?length gt 0>
		    /* 日 */
			and sd.DAY = :signinDate.day
		</#if>
	    <#if ( signinDate.time )??>
		    /* 日期 */
			and sd.TIME = :signinDate.time
		</#if>
