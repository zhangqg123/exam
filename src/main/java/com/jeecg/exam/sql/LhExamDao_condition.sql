		<#if ( lhExam.id )?? && lhExam.id ?length gt 0>
		    /* 题目ID */
			and le.ID = :lhExam.id
		</#if>
		<#if ( lhExam.examName )?? && lhExam.examName ?length gt 0>
		    /* 考试名称 */
			and le.EXAM_NAME = :lhExam.examName
		</#if>
		<#if ( lhExam.questionColumn )?? && lhExam.questionColumn ?length gt 0>
		    /* 试题编号 */
			and le.QUESTION_COLUMN = :lhExam.questionColumn
		</#if>
		<#if ( lhExam.score )?? && lhExam.score ?length gt 0>
		    /* 分数 */
			and le.SCORE = :lhExam.score
		</#if>
		<#if ( lhExam.questionNumber )?? && lhExam.questionNumber ?length gt 0>
		    /* 题目个数 */
			and le.QUESTION_NUMBER = :lhExam.questionNumber
		</#if>
		<#if ( lhExam.examType )?? && lhExam.examType ?length gt 0>
		    /* 考试类型 */
			and le.EXAM_TYPE = :lhExam.examType
		</#if>
		<#if ( lhExam.answerTime )?? && lhExam.answerTime ?length gt 0>
		    /* 答题时间 */
			and le.ANSWER_TIME = :lhExam.answerTime
		</#if>
		<#if ( lhExam.number )?? && lhExam.number ?length gt 0>
		    /* 考试次数 */
			and le.NUMBER = :lhExam.number
		</#if>
		<#if ( lhExam.createBy )?? && lhExam.createBy ?length gt 0>
		    /* 创建人id */
			and le.CREATE_BY = :lhExam.createBy
		</#if>
	    <#if ( lhExam.createDate )??>
		    /* 创建日期 */
			and le.CREATE_DATE = :lhExam.createDate
		</#if>
		<#if ( lhExam.remark )?? && lhExam.remark ?length gt 0>
		    /* 备注 */
			and le.REMARK = :lhExam.remark
		</#if>
		<#if ( lhExam.rightAnswer )?? && lhExam.rightAnswer ?length gt 0>
		    /* 正确答案 */
			and le.RIGHT_ANSWER = :lhExam.rightAnswer
		</#if>
