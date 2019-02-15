		<#if ( lhTask.id )?? && lhTask.id ?length gt 0>
		    /* 题目ID */
			and lt.ID = :lhTask.id
		</#if>
		<#if ( lhTask.taskName )?? && lhTask.taskName ?length gt 0>
		    /* 作业名称 */
			and lt.TASK_NAME = :lhTask.taskName
		</#if>
		<#if ( lhTask.summary )?? && lhTask.summary ?length gt 0>
		    /* 简介 */
			and lt.SUMMARY = :lhTask.summary
		</#if>
		<#if ( lhTask.examType )?? && lhTask.examType ?length gt 0>
		    /*  考试类型 */
			and lt.EXAM_TYPE = :lhTask.examType
		</#if>
		<#if ( lhTask.examId )?? && lhTask.examId ?length gt 0>
		    /* 考试 */
			and lt.EXAM_ID = :lhTask.examId
		</#if>
		<#if ( lhTask.type )?? && lhTask.type ?length gt 0>
		    /* 类型 */
			and lt.TYPE = :lhTask.type
		</#if>
		<#if ( lhTask.createBy )?? && lhTask.createBy ?length gt 0>
		    /* 创建人id */
			and lt.CREATE_BY = :lhTask.createBy
		</#if>
	    <#if ( lhTask.createDate )??>
		    /* 创建日期 */
			and lt.CREATE_DATE = :lhTask.createDate
		</#if>
		<#if ( lhTask.assign )?? && lhTask.assign ?length gt 0>
		    /* 作业分派 */
			and lt.ASSIGN = :lhTask.assign
		</#if>
	    <#if ( lhTask.assignDate )??>
		    /* 作业日期 */
			and lt.ASSIGN_DATE = :lhTask.assignDate
		</#if>
