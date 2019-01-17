		<#if ( lhQuestion.id )?? && lhQuestion.id ?length gt 0>
		    /* 题目ID */
			and lq.ID = :lhQuestion.id
		</#if>
		<#if ( lhQuestion.subject )?? && lhQuestion.subject ?length gt 0>
		    /* 题目内容 */
			and lq.SUBJECT = :lhQuestion.subject
		</#if>
		<#if ( lhQuestion.summary )?? && lhQuestion.summary ?length gt 0>
		    /* 简介 */
			and lq.SUMMARY = :lhQuestion.summary
		</#if>
		<#if ( lhQuestion.chooseAnswer )?? && lhQuestion.chooseAnswer ?length gt 0>
		    /* 选择答案 */
			and lq.CHOOSE_ANSWER = :lhQuestion.chooseAnswer
		</#if>
		<#if ( lhQuestion.chooseNumber )?? && lhQuestion.chooseNumber ?length gt 0>
		    /* 选择个数 */
			and lq.CHOOSE_NUMBER = :lhQuestion.chooseNumber
		</#if>
		<#if ( lhQuestion.columnId )?? && lhQuestion.columnId ?length gt 0>
		    /* 分类 */
			and lq.COLUMN_ID = :lhQuestion.columnId
		</#if>
		<#if ( lhQuestion.type )?? && lhQuestion.type ?length gt 0>
		    /* 题目类型 */
			and lq.TYPE = :lhQuestion.type
		</#if>
		<#if ( lhQuestion.rightAnswer )?? && lhQuestion.rightAnswer ?length gt 0>
		    /* 正确答案 */
			and lq.RIGHT_ANSWER = :lhQuestion.rightAnswer
		</#if>
		<#if ( lhQuestion.number )?? && lhQuestion.number ?length gt 0>
		    /* 出题次数 */
			and lq.NUMBER = :lhQuestion.number
		</#if>
		<#if ( lhQuestion.createBy )?? && lhQuestion.createBy ?length gt 0>
		    /* 创建人id */
			and lq.CREATE_BY = :lhQuestion.createBy
		</#if>
	    <#if ( lhQuestion.createDate )??>
		    /* 创建日期 */
			and lq.CREATE_DATE = :lhQuestion.createDate
		</#if>
		<#if ( lhQuestion.remark )?? && lhQuestion.remark ?length gt 0>
		    /* 备注 */
			and lq.REMARK = :lhQuestion.remark
		</#if>
