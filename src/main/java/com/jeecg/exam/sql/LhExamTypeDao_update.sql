UPDATE lh_exam_type
SET 
	   <#if lhExamType.id ?exists>
		   ID = :lhExamType.id,
		</#if>
	   <#if lhExamType.name ?exists>
		   NAME = :lhExamType.name,
		</#if>
WHERE id = :lhExamType.id