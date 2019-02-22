UPDATE lh_exam_score
SET 
	   <#if lhExamScore.id ?exists>
		   ID = :lhExamScore.id,
		</#if>
	   <#if lhExamScore.examId ?exists>
		   EXAM_ID = :lhExamScore.examId,
		</#if>
	   <#if lhExamScore.openId ?exists>
		   OPEN_ID = :lhExamScore.openId,
		</#if>
	   <#if lhExamScore.score ?exists>
		   SCORE = :lhExamScore.score,
		</#if>
	   <#if lhExamScore.number ?exists>
		   NUMBER = :lhExamScore.number,
		</#if>
	   <#if lhExamScore.createDate ?exists>
		   create_date = :lhExamScore.createDate,
		</#if>
WHERE id = :lhExamScore.id