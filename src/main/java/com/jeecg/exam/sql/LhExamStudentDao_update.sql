UPDATE lh_exam_student
SET 
	   <#if lhExamStudent.id ?exists>
		   ID = :lhExamStudent.id,
		</#if>
	   <#if lhExamStudent.phone ?exists>
		   PHONE = :lhExamStudent.phone,
		</#if>
	   <#if lhExamStudent.username ?exists>
		   USERNAME = :lhExamStudent.username,
		</#if>
	   <#if lhExamStudent.password ?exists>
		   PASSWORD = :lhExamStudent.password,
		</#if>
	   <#if lhExamStudent.status ?exists>
		   STATUS = :lhExamStudent.status,
		</#if>
	   <#if lhExamStudent.openid ?exists>
		   OPENID = :lhExamStudent.openid,
		</#if>
	   <#if lhExamStudent.smscode ?exists>
		   SMSCODE = :lhExamStudent.smscode,
		</#if>
	   <#if lhExamStudent.userkey ?exists>
		   USERKEY = :lhExamStudent.userkey,
		</#if>
	   <#if lhExamStudent.idcard ?exists>
		   IDCARD = :lhExamStudent.idcard,
		</#if>
	   <#if lhExamStudent.realname ?exists>
		   REALNAME = :lhExamStudent.realname,
		</#if>
	   <#if lhExamStudent.sex ?exists>
		   SEX = :lhExamStudent.sex,
		</#if>
	   <#if lhExamStudent.address ?exists>
		   ADDRESS = :lhExamStudent.address,
		</#if>
WHERE id = :lhExamStudent.id