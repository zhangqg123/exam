UPDATE lh_question
SET 
	   <#if lhQuestion.id ?exists>
		   ID = :lhQuestion.id,
		</#if>
	   <#if lhQuestion.subject ?exists>
		   SUBJECT = :lhQuestion.subject,
		</#if>
	   <#if lhQuestion.summary ?exists>
		   SUMMARY = :lhQuestion.summary,
		</#if>
	   <#if lhQuestion.chooseAnswer ?exists>
		   CHOOSE_ANSWER = :lhQuestion.chooseAnswer,
		</#if>
	   <#if lhQuestion.chooseNumber ?exists>
		   CHOOSE_NUMBER = :lhQuestion.chooseNumber,
		</#if>
	   <#if lhQuestion.columnId ?exists>
		   COLUMN_ID = :lhQuestion.columnId,
		</#if>
	   <#if lhQuestion.type ?exists>
		   TYPE = :lhQuestion.type,
		</#if>
	   <#if lhQuestion.rightAnswer ?exists>
		   RIGHT_ANSWER = :lhQuestion.rightAnswer,
		</#if>
	   <#if lhQuestion.number ?exists>
		   NUMBER = :lhQuestion.number,
		</#if>
	   <#if lhQuestion.createBy ?exists>
		   CREATE_BY = :lhQuestion.createBy,
		</#if>
	    <#if lhQuestion.createDate ?exists>
		   CREATE_DATE = :lhQuestion.createDate,
		</#if>
	   <#if lhQuestion.remark ?exists>
		   REMARK = :lhQuestion.remark,
		</#if>
	   <#if lhQuestion.analysis ?exists>
		   analysis = :lhQuestion.analysis,
		</#if>
WHERE id = :lhQuestion.id