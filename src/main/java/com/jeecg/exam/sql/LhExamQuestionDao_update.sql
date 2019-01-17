UPDATE lh_exam_question
SET 
	   <#if lhExamQuestion.id ?exists>
		   ID = :lhExamQuestion.id,
		</#if>
	   <#if lhExamQuestion.examId ?exists>
		   EXAM_ID = :lhExamQuestion.examId,
		</#if>
	   <#if lhExamQuestion.questionId ?exists>
		   QUESTION_ID = :lhExamQuestion.questionId,
		</#if>
WHERE id = :lhExamQuestion.id