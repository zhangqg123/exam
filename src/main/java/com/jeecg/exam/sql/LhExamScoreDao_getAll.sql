SELECT les.*,le.exam_name FROM lh_exam_score les left join lh_exam le on les.exam_id=le.id where 1=1
<#include "LhExamScoreDao_condition.sql"> 
order by les.create_date desc