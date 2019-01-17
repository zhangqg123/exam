		<#if ( lhQuestionColumn.id )?? && lhQuestionColumn.id ?length gt 0>
		    /* id */
			and lqc.ID = :lhQuestionColumn.id
		</#if>
		<#if ( lhQuestionColumn.imageHref )?? && lhQuestionColumn.imageHref ?length gt 0>
		    /* 图片地址 */
			and lqc.IMAGE_HREF = :lhQuestionColumn.imageHref
		</#if>
		<#if ( lhQuestionColumn.imageName )?? && lhQuestionColumn.imageName ?length gt 0>
		    /* 图片名称 */
			and lqc.IMAGE_NAME = :lhQuestionColumn.imageName
		</#if>
		<#if ( lhQuestionColumn.columnName )?? && lhQuestionColumn.columnName ?length gt 0>
		    /* 类别名称 */
			and lqc.COLUMN_NAME = :lhQuestionColumn.columnName
		</#if>
		<#if ( lhQuestionColumn.type )?? && lhQuestionColumn.type ?length gt 0>
		    /* 类型 */
			and lqc.TYPE = :lhQuestionColumn.type
		</#if>
		<#if ( lhQuestionColumn.parentCode )?? && lhQuestionColumn.parentCode ?length gt 0>
		    /* 父节点 */
			and lqc.PARENT_CODE = :lhQuestionColumn.parentCode
		</#if>
		<#if ( lhQuestionColumn.href )?? && lhQuestionColumn.href ?length gt 0>
		    /* 地址 */
			and lqc.HREF = :lhQuestionColumn.href
		</#if>
		<#if ( lhQuestionColumn.owner )?? && lhQuestionColumn.owner ?length gt 0>
		    /* owner */
			and lqc.OWNER = :lhQuestionColumn.owner
		</#if>
