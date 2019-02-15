		<#if ( lhExamType.id )?? && lhExamType.id ?length gt 0>
		    /* id */
			and let.ID = :lhExamType.id
		</#if>
		<#if ( lhExamType.name )?? && lhExamType.name ?length gt 0>
		    /* name */
			and let.NAME = :lhExamType.name
		</#if>
