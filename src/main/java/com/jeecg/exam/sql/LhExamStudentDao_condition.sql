		<#if ( lhExamStudent.id )?? && lhExamStudent.id ?length gt 0>
		    /* id */
			and les.ID = :lhExamStudent.id
		</#if>
		<#if ( lhExamStudent.phone )?? && lhExamStudent.phone ?length gt 0>
		    /* 手机 */
			and les.PHONE = :lhExamStudent.phone
		</#if>
		<#if ( lhExamStudent.username )?? && lhExamStudent.username ?length gt 0>
		    /* 用户账号 */
			and les.USERNAME = :lhExamStudent.username
		</#if>
		<#if ( lhExamStudent.password )?? && lhExamStudent.password ?length gt 0>
		    /* 密码 */
			and les.PASSWORD = :lhExamStudent.password
		</#if>
		<#if ( lhExamStudent.status )?? && lhExamStudent.status ?length gt 0>
		    /* 有效状态 */
			and les.STATUS = :lhExamStudent.status
		</#if>
		<#if ( lhExamStudent.openid )?? && lhExamStudent.openid ?length gt 0>
		    /* openId */
			and les.OPENID = :lhExamStudent.openid
		</#if>
		<#if ( lhExamStudent.smscode )?? && lhExamStudent.smscode ?length gt 0>
		    /* 验证码 */
			and les.SMSCODE = :lhExamStudent.smscode
		</#if>
		<#if ( lhExamStudent.userkey )?? && lhExamStudent.userkey ?length gt 0>
		    /* 用户KEY */
			and les.USERKEY = :lhExamStudent.userkey
		</#if>
		<#if ( lhExamStudent.idcard )?? && lhExamStudent.idcard ?length gt 0>
		    /* 身份证号 */
			and les.IDCARD = :lhExamStudent.idcard
		</#if>
		<#if ( lhExamStudent.realname )?? && lhExamStudent.realname ?length gt 0>
		    /* 真实名字 */
			and les.REALNAME = :lhExamStudent.realname
		</#if>
		<#if ( lhExamStudent.sex )?? && lhExamStudent.sex ?length gt 0>
		    /* 性别 */
			and les.SEX = :lhExamStudent.sex
		</#if>
		<#if ( lhExamStudent.address )?? && lhExamStudent.address ?length gt 0>
		    /* 地址 */
			and les.ADDRESS = :lhExamStudent.address
		</#if>
