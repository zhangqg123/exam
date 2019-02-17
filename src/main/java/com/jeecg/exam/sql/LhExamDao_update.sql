UPDATE lh_exam
SET 
	   <#if lhExam.id ?exists>
		   ID = :lhExam.id,
		</#if>
	   <#if lhExam.examName ?exists>
		   EXAM_NAME = :lhExam.examName,
		</#if>
	   <#if lhExam.questionColumn ?exists>
		   QUESTION_COLUMN = :lhExam.questionColumn,
		</#if>
	   <#if lhExam.score ?exists>
		   SCORE = :lhExam.score,
		</#if>
	   <#if lhExam.questionNumber ?exists>
		   QUESTION_NUMBER = :lhExam.questionNumber,
		</#if>
	   <#if lhExam.examType ?exists>
		   EXAM_TYPE = :lhExam.examType,
		</#if>
	   <#if lhExam.answerTime ?exists>
		   ANSWER_TIME = :lhExam.answerTime,
		</#if>
	   <#if lhExam.number ?exists>
		   NUMBER = :lhExam.number,
		</#if>
	   <#if lhExam.assign ?exists>
		   assign = :lhExam.assign,
		</#if>
	   <#if lhExam.createBy ?exists>
		   CREATE_BY = :lhExam.createBy,
		</#if>
	    <#if lhExam.createDate ?exists>
		   CREATE_DATE = :lhExam.createDate,
		</#if>
	   <#if lhExam.remark ?exists>
		   REMARK = :lhExam.remark,
		</#if>
	   <#if lhExam.rightAnswer ?exists>
		   RIGHT_ANSWER = :lhExam.rightAnswer,
		</#if>
WHERE id = :lhExam.id