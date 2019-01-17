		<#if ( lhExamQuestion.id )?? && lhExamQuestion.id ?length gt 0>
		    /* 题目ID */
			and leq.ID = :lhExamQuestion.id
		</#if>
		<#if ( lhExamQuestion.examId )?? && lhExamQuestion.examId ?length gt 0>
		    /* 考试编号 */
			and leq.EXAM_ID = :lhExamQuestion.examId
		</#if>
		<#if ( lhExamQuestion.questionId )?? && lhExamQuestion.questionId ?length gt 0>
		    /* 题目编号 */
			and leq.QUESTION_ID = :lhExamQuestion.questionId
		</#if>
