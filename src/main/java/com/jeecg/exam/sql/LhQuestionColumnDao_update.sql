UPDATE lh_question_column
SET 
	   <#if lhQuestionColumn.id ?exists>
		   ID = :lhQuestionColumn.id,
		</#if>
	   <#if lhQuestionColumn.imageHref ?exists>
		   IMAGE_HREF = :lhQuestionColumn.imageHref,
		</#if>
	   <#if lhQuestionColumn.imageName ?exists>
		   IMAGE_NAME = :lhQuestionColumn.imageName,
		</#if>
	   <#if lhQuestionColumn.columnName ?exists>
		   COLUMN_NAME = :lhQuestionColumn.columnName,
		</#if>
	   <#if lhQuestionColumn.type ?exists>
		   TYPE = :lhQuestionColumn.type,
		</#if>
	   <#if lhQuestionColumn.parentCode ?exists>
		   PARENT_CODE = :lhQuestionColumn.parentCode,
		</#if>
	   <#if lhQuestionColumn.href ?exists>
		   HREF = :lhQuestionColumn.href,
		</#if>
	   <#if lhQuestionColumn.owner ?exists>
		   OWNER = :lhQuestionColumn.owner,
		</#if>
WHERE id = :lhQuestionColumn.id