		<#if ( lhExamScore.id )?? && lhExamScore.id ?length gt 0>
		    /* 题目ID */
			and les.ID = :lhExamScore.id
		</#if>
		<#if ( lhExamScore.examId )?? && lhExamScore.examId ?length gt 0>
		    /* 考试编号 */
			and les.EXAM_ID = :lhExamScore.examId
		</#if>
		<#if ( lhExamScore.openId )?? && lhExamScore.openId ?length gt 0>
		    /* openId */
			and les.OPEN_ID = :lhExamScore.openId
		</#if>
		<#if ( lhExamScore.score )?? && lhExamScore.score ?length gt 0>
		    /* 分数 */
			and les.SCORE = :lhExamScore.score
		</#if>
		<#if ( lhExamScore.number )?? && lhExamScore.number ?length gt 0>
		    /* 分数 */
			and les.NUMBER = :lhExamScore.number
		</#if>
