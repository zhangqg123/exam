UPDATE lh_task
SET 
	   <#if lhTask.id ?exists>
		   ID = :lhTask.id,
		</#if>
	   <#if lhTask.taskName ?exists>
		   TASK_NAME = :lhTask.taskName,
		</#if>
	   <#if lhTask.summary ?exists>
		   SUMMARY = :lhTask.summary,
		</#if>
	   <#if lhTask.examType ?exists>
		   EXAM_TYPE = :lhTask.examType,
		</#if>
	   <#if lhTask.examId ?exists>
		   EXAM_ID = :lhTask.examId,
		</#if>
	   <#if lhTask.type ?exists>
		   TYPE = :lhTask.type,
		</#if>
	   <#if lhTask.createBy ?exists>
		   CREATE_BY = :lhTask.createBy,
		</#if>
	    <#if lhTask.createDate ?exists>
		   CREATE_DATE = :lhTask.createDate,
		</#if>
	   <#if lhTask.assign ?exists>
		   ASSIGN = :lhTask.assign,
		</#if>
	    <#if lhTask.assignDate ?exists>
		   ASSIGN_DATE = :lhTask.assignDate,
		</#if>
WHERE id = :lhTask.id